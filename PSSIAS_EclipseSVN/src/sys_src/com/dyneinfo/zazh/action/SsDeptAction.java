/*
 * Powered By []
 * Web Site: 
 * 
 */

package com.dyneinfo.zazh.action;

import static javacommon.util.extjs.Struts2JsonHelper.configJson;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javacommon.base.BaseStruts2Action;
import javacommon.util.extjs.JsonUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;

import org.apache.commons.lang.StringUtils;
import org.apache.struts2.ServletActionContext;
import org.security.userdetails.MyUserDetails;
import org.springframework.security.Authentication;
import org.springframework.security.context.SecurityContext;
import org.springframework.security.context.SecurityContextHolder;

import cn.org.rapid_framework.page.Page;
import cn.org.rapid_framework.page.PageRequest;

import com.dyneinfo.zazh.model.JSONJsTree;
import com.dyneinfo.zazh.model.JSONJsTreeAttr;
import com.dyneinfo.zazh.model.JSONTreeNode;
import com.dyneinfo.zazh.model.JSONTreeNodeSel;
import com.dyneinfo.zazh.model.SsDept;
import com.dyneinfo.zazh.model.SsUser;
import com.dyneinfo.zazh.service.SsDeptManager;
import com.dyneinfo.zazh.service.SsUserManager;
import com.google.gson.Gson;
import com.opensymphony.xwork2.ModelDriven;
import com.opensymphony.xwork2.Preparable;

/**
 * @author  email: lee(a)gmail.com
 * @version 1.0
 * @since 1.0
 */


public class SsDeptAction extends BaseStruts2Action implements Preparable,ModelDriven{
	//默认多列排序,example: username desc,createTime asc
	protected static final String DEFAULT_SORT_COLUMNS = null; 
	
	//forward paths
	protected static final String QUERY_JSP = "/pages/SsDept/query.jsp";
	protected static final String LIST_JSP= "/pages/SsDept/list.jsp";
	protected static final String CREATE_JSP = "/pages/SsDept/create.jsp";
	protected static final String EDIT_JSP = "/pages/SsDept/edit.jsp";
	protected static final String SHOW_JSP = "/pages/SsDept/show.jsp";
	protected static final String JSON_JSP = "/commons/jsonStruts.jsp";
	//redirect paths,startWith: !SELECTDEPT
	protected static final String LIST_ACTION = "!/pages/SsDept/list.do";
	protected static final String SELECTDEPT = "/pages/jsTree/selectDept.jsp";
	protected static final String SELECTDEPTCHECKBOX = "/pages/jsTree/selectDeptCheckbox.jsp";
	protected static final String SELECTPERSON = "/pages/jsTree/selectPerson.jsp";
	
	protected static final String SELECTCYRY="/pages/jsTree/selectCyry.jsp";
	protected static final String SELECTDEPTPOLICECHECK="/pages/jsTree/selectDeptForPoliceCheck.jsp";
	
	private SsDeptManager ssDeptManager;
	private SsUserManager ssUserManager;
	
	private SsDept ssDept;
	java.lang.String id = null;
	private String[] items;
	
	
	private SsUser ssUser = null;
	private List<SsUser> ssUsers = new ArrayList<SsUser>(0);
	private String delData;

	public void prepare() throws Exception {
		if (isNullOrEmptyString(id)) {
			ssDept = new SsDept();
		} else {
			ssDept = (SsDept)ssDeptManager.getById(id);
		}
	}
	
	/** 增加setXXXX()方法,spring就可以通过autowire自动设置对象属性 */
	public void setSsDeptManager(SsDeptManager manager) {
		this.ssDeptManager = manager;
	}	
	public void setSsUserManager(SsUserManager manager) {
		this.ssUserManager = manager;
	}	
	
	public Object getModel() {
		return ssDept;
	}
	
	public void setDeptid(java.lang.String val) {
		this.id = val;
	}

	public void setItems(String[] items) {
		this.items = items;
	}

	
//	/****
//	 * 
//	 * 
//	 * tree 部门树
//	 * 
//	 *
//	 */
//

	public String treelist(){
		
		HttpServletRequest request = ServletActionContext.getRequest();
		String deptTypeId= "";
		if (request.getParameter("deptTypeId") != null)
			deptTypeId = request.getParameter("deptTypeId");
		
		List<SsDept> listParent;
		StringBuffer buff = new StringBuffer("[{id:'"+0+"',text:'组织机构',expanded:true,children:[");
		listParent=ssDeptManager.findRootTree(deptTypeId);//最顶层父节点
		
		
		for(SsDept dep:listParent){
			buff.append("{id:'"+dep.getDeptid()+"',text:'"+dep.getDeptname()+"',");
		    buff.append(findChild(dep.getDeptid()));
		}
		if (!listParent.isEmpty()) {
			buff.deleteCharAt(buff.length() - 1);
	    }
		buff.append("]}]");
		setJsonString(buff.toString());
		//outString(buff.toString());
		//System.out.println(buff.toString());		
		return JSON_JSP;
	}
	/*
	 * 寻找子根节点*/
	
	public String findChild(String depId){
		HttpServletRequest request = ServletActionContext.getRequest();
		String deptTypeId= "";
		if (request.getParameter("deptTypeId") != null)
			deptTypeId = request.getParameter("deptTypeId");		
	
		StringBuffer buff1=new StringBuffer("");
		List<SsDept> list=ssDeptManager.findByParentId(depId,deptTypeId);
		if(list.size()==0){
			buff1.append("leaf:true},");
			return buff1.toString(); 
		}else {
			buff1.append("children:[");
			for(SsDept dep2:list){				
				buff1.append("{id:'"+dep2.getDeptid()+"',text:'"+dep2.getDeptname()+"',");
				buff1.append(findChild(dep2.getDeptid()));
			}
			buff1.deleteCharAt(buff1.length() - 1);
			buff1.append("]},");
			return buff1.toString();
		}
	}
	
	
	/**
	 *获取指定树节点的子节点 一级一级展开树列表 见tree.js tree.html
	 */
	
	

	public String getTrees() throws Exception {
		
		HttpServletRequest request = ServletActionContext.getRequest();
		String deptTypeId= "",strParentId="";
		if (request.getParameter("deptTypeId") != null)
			deptTypeId = request.getParameter("deptTypeId");
		if (request.getParameter("parentId") != null)
			strParentId = request.getParameter("parentId");
		
		
		System.out.println("strParentId="+strParentId);
		
		String session_deptid="";
		SecurityContext sc = SecurityContextHolder.getContext();
		Authentication auth = sc.getAuthentication();
		MyUserDetails ud = null;
		if ((auth != null) && auth.getPrincipal() instanceof MyUserDetails) {
			ud = (MyUserDetails) auth.getPrincipal();
			if (ud != null) {
				session_deptid = ud.getDeptID();
			}
		}
		
		
		String parentId = strParentId;
		
		List<JSONTreeNode> treeNodeArray = null; 
		//查找所有拥有下级部门的的部门ID
		
		 List parentidlist = (List) ssDeptManager.getExistChildDept();
		 
		 StringBuffer parentIDBuffer =new StringBuffer(); 
         parentIDBuffer.append("|");        

		 
		 if (parentidlist != null) {
				for (int j = 0; j < parentidlist.size(); j++) {
					Map staResults = (HashMap) parentidlist.get(j);
					String parentIdValue = (String) staResults.get("parentId");
					parentIDBuffer.append(parentIdValue);
	                parentIDBuffer.append("|");
				}
			}
		 
		 String parentIDString = parentIDBuffer.toString();  
		
		//根据父节点查询子节点记录
		List<SsDept> list = null;
		if(strParentId != null && strParentId.equals("0")){
			if(StringUtils.isNotEmpty(session_deptid) && session_deptid.equals("0") ){
				 list=ssDeptManager.findRootTree(deptTypeId);
			} else {
//				String session_parentId = new java.lang.Long(session_deptid);
				 list=ssDeptManager.findByDeptId(session_deptid,deptTypeId);
			}
		    
		} else{
			 list=ssDeptManager.findByParentId(parentId,deptTypeId);
		}
		treeNodeArray = new ArrayList<JSONTreeNode>(); 

		for (SsDept department : list) {

			JSONTreeNode treeNode = new JSONTreeNode();
			String deptIdValue = department.getDeptid();
			String l_deptid = deptIdValue;
			String s_deptid = deptIdValue.toString();
			String name = department.getDeptname();
			String desc = department.getDeptdesc();
			treeNode.setId(s_deptid);
			treeNode.setText(name);
			treeNode.setDescription(desc);

			// treeNode.setHref("rightframe.jsp?categoryId="
			// + rs.getString("categoryId").toString());
			// treeNode.setHrefTarget("rightFrame");

			
			if (parentIDString.indexOf("|" + s_deptid + "|") >= 0) // 父节点
			{
				treeNode.setCls("folder"); 
                treeNode.setLeaf(false); 
                treeNode.setExpandable(false); 
			}
			else // 子节点

			{	
				treeNode.setCls("file"); 
                treeNode.setLeaf(true); 
                treeNode.setExpandable(false); 
			}
			treeNodeArray.add(treeNode); 	
		}
		
		 
	
//		System.out.println("=====================");
//		System.out.println(JsonUtils.toJson(treeNodeArray, getMenuExcludes(),
//	            getDatePattern()));

         setJsonString(JsonUtils.toJson(treeNodeArray, getMenuExcludes(),
		            getDatePattern()));
 			
 		return JSON_JSP;
		
	}
	
	

	   public String findUserByDepartmentht() throws Exception{ 
			int totalCount  = 0;
			
			String strDepId=getRequest().getParameter("depId");
			if(strDepId !=null && !"0".equals(strDepId)){
				
				String deptSEQ=".";
				
				String session_deptid="";
				java.lang.Long session_userid=null;
				SecurityContext sc = SecurityContextHolder.getContext();
				Authentication auth = sc.getAuthentication();
				MyUserDetails ud = null;
				if ((auth != null) && auth.getPrincipal() instanceof MyUserDetails) {
					ud = (MyUserDetails) auth.getPrincipal();
					if (ud != null) {
						session_deptid = ud.getDeptID();
						session_userid = new java.lang.Long(ud.getUserId());
					}
				}			
				
				if(StringUtils.isNotEmpty(strDepId)&&!strDepId.equals("0")){
					java.lang.String depId =strDepId;
					SsDept ssDept = (SsDept)ssDeptManager.getById(depId);
		          if(ssDept!=null){	
		       	   deptSEQ=ssDept.getDeptseq();
		          }			
				}else{
					if(StringUtils.isNotEmpty(session_deptid)){
					java.lang.String depId = session_deptid;
					SsDept ssDept = (SsDept)ssDeptManager.getById(depId);
		          if(ssDept!=null){	
		       	   deptSEQ=ssDept.getDeptseq();
		          }
					}
				}
				
				
				int start = getStart();
				int limit = getLimit();
			
				int pageNumber = 0;
				
				pageNumber =  start/limit+1;
				PageRequest<Map> pageRequest = newPageRequest(DEFAULT_SORT_COLUMNS);
				//pageRequest.getFilters().put("createuserid",session_userid);
				if(".".equals(deptSEQ)){
					
					pageRequest.setPageNumber(pageNumber);
					pageRequest.setPageSize(limit);
					//pageRequest.getFilters().put("key",value);     
					Page page = ssUserManager.findUserByDeptSeqRequest(pageRequest);
					ssUsers=page.getResult();	
					totalCount  = page.getTotalCount();
				}else{
					pageRequest.setPageNumber(pageNumber);
					pageRequest.setPageSize(limit);
					//pageRequest.getFilters().put("deptSEQ",deptSEQ);     
					pageRequest.getFilters().put("deptid",strDepId);  
					Page page = ssUserManager.findUserByDeptSeqRequest(pageRequest);
					ssUsers=page.getResult();	
					totalCount  = page.getTotalCount();
				    
				}
			}
			this.setTotalCount(totalCount);
//			JSONArray array = JSONArray.fromObject(this.ssUsers);
//			 System.out.println(this.getStart() + "---" + this.getLimit());
		//	this.setJsonString("{success:true,totalCount : " + this.getTotalCount() + ", list:" + array.toString() + "}");
			
			 this.setJsonString("{success:true,totalCount : " + this.getTotalCount() + ", list:" + JsonUtils.toJson(this.ssUsers,
		             getExcludes(),
			            getDatePattern()) + "}");
			 //System.out.println("-------------------------"+this.getJsonString());
			 return JSON_JSP;
		}
		
	
	/**
	 * 根据部门查找用户列表
	 */
   public String findUserByDepartment() throws Exception{ 
	   
//	   Enumeration<String> keys = getRequest().getParameterNames();
//		while (keys.hasMoreElements()) {
//			String key = keys.nextElement();
//			String value = getRequest().getParameter(key);
//			System.out.println("findUserByDepartment==========="+key + " value=" + value);
//
//		}
   
		String strDepId=getRequest().getParameter("depId");
		
		
		String session_deptid="";
		java.lang.Long session_userid=null;
		SecurityContext sc = SecurityContextHolder.getContext();
		Authentication auth = sc.getAuthentication();
		MyUserDetails ud = null;
		if ((auth != null) && auth.getPrincipal() instanceof MyUserDetails) {
			ud = (MyUserDetails) auth.getPrincipal();
			if (ud != null) {
				session_deptid = ud.getDeptID();
				session_userid = new java.lang.Long(ud.getUserId());
			}
		}
		//System.out.println("strDepId================="+strDepId);
		//System.out.println("session_deptid================="+session_deptid);
		
		
		if(StringUtils.isEmpty(strDepId)){
			strDepId = session_deptid;
		}
		

		int start = getStart();
		int limit = getLimit();
		int totalCount  = 0;
		int pageNumber = 0;
		
		pageNumber =  start/limit+1;
		PageRequest<Map> pageRequest = newPageRequest(DEFAULT_SORT_COLUMNS);
		pageRequest.getFilters().put("deptid",strDepId);
		
		
		pageRequest.setPageNumber(pageNumber);
		pageRequest.setPageSize(limit);
		pageRequest.getFilters().put("enabled","1");     
		Page page = ssUserManager.findUserByDeptSeqRequest(pageRequest);
		ssUsers=page.getResult();	
		totalCount  = page.getTotalCount();
		
		this.setTotalCount(totalCount);
//		JSONArray array = JSONArray.fromObject(this.ssUsers);
//		 System.out.println(this.getStart() + "---" + this.getLimit());
	//	this.setJsonString("{success:true,totalCount : " + this.getTotalCount() + ", list:" + array.toString() + "}");
		
		 this.setJsonString("{success:true,totalCount : " + this.getTotalCount() + ", list:" + JsonUtils.toJson(this.ssUsers,
	             getExcludes(),
		            getDatePattern()) + "}");
		 //System.out.println("-------------------------"+this.getJsonString());
		 return JSON_JSP;
	}
	
	
	
	public String LevelAjaxJsonData() throws Exception {
		if (this.getDelData() != null && !"".equals(this.getDelData())) {
			if (this.getDelData().indexOf(",") < 0) {
				java.lang.Long id = new java.lang.Long((String)this.getDelData());
				ssUserManager.removeById(id);
				//System.out.println("del_id:" + getDelData());
			} else {
				String id[] = this.getDelData().split(",");
				for (int i = 0; i < id.length; i++) {
					//System.out.println("del:" + id[i]);
					java.lang.Long ids = new java.lang.Long((String)id[i]);
					ssUserManager.removeById(ids);
				}
			}
		}
		HttpSession session = getRequest().getSession();
		Object o = null;// session.getAttribute("Level_Data1");
		if (o == null) {
			try {
				this.ssUsers = this.ssUserManager.findAll();
				session.setAttribute("Level_Data1", this.ssUsers);
				
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else {
			this.setSsUsers(((List<SsUser>) o));
		}
		this.setTotalCount(this.ssUsers.size());
		JSONArray array = JSONArray.fromObject(this.ssUsers);
		 //System.out.println(this.getStart() + "---" + this.getLimit());
		this.setJsonString("{success:true,totalCount : " + this.getTotalCount() + ", list:" + array.toString() + "}");
		 //System.out.println(this.getJsonString());
		 return JSON_JSP;
	}

	/**
	 * Find an entity by its id (primary key).
	 * 
	 * @param id
	 * @return The found entity instance or null if the entity does not exist.
	 */
	public String LoadLevel(Long id) {
		try {
			java.lang.Long ids = new java.lang.Long(id);
			this.ssUser = this.ssUserManager.getById(ids);
		} catch (Exception e) {
			e.printStackTrace();
		}
		JSONArray array = JSONArray.fromObject(ssUser);
		this.setJsonString(array.toString());
		return JSON_JSP;
	}

	public String findLevelById() {

		try {
			this.ssUser = this.ssUserManager.getById(this.ssUser.getUserid());
		} catch (Exception e) {
			e.printStackTrace();
		}
		JSONArray array = JSONArray.fromObject(this.ssUser);
		this.setJsonString(array.toString());
		this.setJsonString("{success:true,totalCount:1,list:" + array.toString() + "}");

		return JSON_JSP;
	}




	/**
	 * Make the given instance managed and persistent.
	 * 
	 * @return
	 */
	public String AddLevel() {

		this.setJsonString("{success:true}");
		try {
			this.ssUserManager.save(ssUser);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return JSON_JSP;
	}



	/**
	 * Remove an entity by its id (primary key). *
	 * 
	 * @return
	 */
	public String removeLevelById(Long id) {
		try {
			java.lang.Long ids = new java.lang.Long(id);
			ssUserManager.removeById(ids);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return SUCCESS;
	}





	public String getDelData() {
		return delData;
	}

	public void setDelData(String delData) {
		this.delData = delData;
	}

	public SsUser getSsUser() {
		return ssUser;
	}

	public void setSsUser(SsUser ssUser) {
		this.ssUser = ssUser;
	}

	public List<SsUser> getSsUsers() {
		return ssUsers;
	}

	public void setSsUsers(List<SsUser> ssUsers) {
		this.ssUsers = ssUsers;
	}

	

	
	public String add() {
		Enumeration<String> keys = getRequest().getParameterNames();
		while (keys.hasMoreElements()) {
			String key = keys.nextElement();
			String value = getRequest().getParameter(key);


		}
		
		
        String session_deptid="";
		
		SecurityContext sc = SecurityContextHolder.getContext();
		Authentication auth = sc.getAuthentication();
		MyUserDetails ud = null;
		if ((auth != null) && auth.getPrincipal() instanceof MyUserDetails) {
			ud = (MyUserDetails) auth.getPrincipal();
			if (ud != null) {
				session_deptid = ud.getDeptID();
			}
		}
		
		
		
		//根据session判断根目录
		String str_parent_id = (String)getRequest().getParameter("parentid");
		if(StringUtils.isNotEmpty(session_deptid)  && !session_deptid.equals("0") 
				&& str_parent_id != null && (str_parent_id.equals("") || str_parent_id.equals("0")) ){
			str_parent_id = session_deptid;
		}
		String depPath = "";
		int level = 0;
		//树形root目录
		if(str_parent_id != null && (str_parent_id.equals("") || str_parent_id.equals("0"))){//
			depPath = ".";
			java.lang.Long bd_Displayorder = new java.lang.Long(0);
			ssDept.setDisplayorder(bd_Displayorder);
			ssDept.setDeptlevel(level + 1);
			ssDept.setDepttypeid("0");
			//ssDept.setDeptcode("code");
			if(str_parent_id.equals("0")){
				ssDept.setDeptseq(".");
				ssDeptManager.insertRoot(ssDept);
			} else if(str_parent_id.equals("")){
				ssDeptManager.updateRoot(ssDept);
			}
		} 
		//树形子目录
		else {
			//Long parentId = Long.parseLong(str_parent_id);
			//java.lang.Long parentIds = new java.lang.Long(parentId);
			SsDept ssDeptSearch = (SsDept) ssDeptManager.getById(str_parent_id);
			depPath = ssDeptSearch.getDeptseq();
			level = ssDeptSearch.getDeptlevel();
			java.lang.Long bd_Displayorder = new java.lang.Long(0);
			ssDept.setDisplayorder(bd_Displayorder);
			ssDept.setDeptlevel(level + 1);
			ssDept.setDepttypeid("0");
			ssDept.setParentid(str_parent_id);
			if(ssDept != null && ssDept.getDeptid() != null){
				ssDeptManager.update(ssDept);//修改
			} else {
				ssDeptManager.save(ssDept);//增加
			}
		}

		
	
		if (ssDept != null && ssDept.getDeptid() != null) {
			depPath += ssDept.getDeptid().toString() + ".";
			ssDept.setDeptseq(depPath);
			ssDeptManager.updateSEQ(ssDept);
			setJsonString("{success:true}");
		} else {
			setJsonString("{success:false}");
		}

		return JSON_JSP;
	}
	
	public String remove(){
		
		HttpServletRequest request = ServletActionContext.getRequest();
		String deptTypeId= "";
		if (request.getParameter("deptTypeId") != null)
			deptTypeId = request.getParameter("deptTypeId");
		Map<String, Object> result = new HashMap<String, Object>();
		String depId=getRequest().getParameter("depId");
		String ids = depId;
		// 是否存在员工
		int usercount = ssDeptManager.getCountDeptUser(depId);
		if (usercount == 0) {
			List<SsDept> list = ssDeptManager.findByParentId(ids,deptTypeId);
			// 是否子机构
			if (list.size() == 0) {
			//	ssDeptManager.removeById(ids);
				ssDeptManager.deleteTcpinfo(ids);
				result.put("success", true);
				result.put("msg", "删除成功!");
				
			} else {
				result.put("failure", true);
				result.put("msg", "删除失败，存在子机构!");
				//setJsonString("{success:false,msg:删除失败，存在子机构}");
			}
		} else {
			result.put("failure", true);
			result.put("msg", "删除失败，机构存在用户！");
			
		}
		
		
		 JsonConfig jsonConfig = configJson("yyyy-MM-dd HH:mm:ss");    
		
		
		setJsonString(JSONObject.fromObject(result,jsonConfig).toString());
	   
		return JSON_JSP;
	}
	
	public String detail(){
		//Long depId=Long.parseLong(getRequest().getParameter("depId"));
		//java.lang.Long ids = new java.lang.Long(depId);
		
		String depId ="";//派出所代码
		if(getRequest().getParameter("depId") != null)
			depId =getRequest().getParameter("depId");
		
		SsDept ssDepttmp = (SsDept)ssDeptManager.getById(depId);
		Gson gson=new Gson();
		StringBuffer sb = new StringBuffer("{success:true,data:[");
		sb.append(gson.toJson(ssDepttmp));
		sb.append("]}");
		setJsonString(sb.toString());
		return JSON_JSP;
	}
	
	  public String[] getExcludes() {
	        return new String[] {};
	    }
	  
	  public String[] getMenuExcludes() {
		  return new String[] {"checked", "children", "qtip", "theSort","parent","allowDelete","allowEdit","draggable"};
	    }

	    public String getDatePattern() {
	        return "yyyy-MM-dd";
	    }
	    
	    
	    //部门，人员 树
	    
	    public JSONTreeNodeSel  createTree(List listDept,List listStaff,String parentID,JSONTreeNodeSel inode)
	    {
	    	
	    	for(int i= 0; i < listDept.size(); i++)
	    	{
	    		
	    		SsDept dep  = (SsDept)listDept.get(i);
	    		String depParentid = "";
	    		if(dep != null  && dep.getParentid() != null)
	    		      depParentid= dep.getParentid().toString();
	    		else 
	    			 depParentid= "0";

	    		
	    		if(depParentid.equals(parentID))
	    		{
	    		//	System.out.println("success 33333");
	    			JSONTreeNodeSel  node = new JSONTreeNodeSel();
	    			node.setText(dep.getDeptname());
	    			node.setId(dep.getDeptid().toString());
	    			node.setDep(true);
	    			
	    			inode.setLeaf(false);
	    			inode.getChildren().add(node);
	    			
	    			
	    		
	    			for(int j= 0; j < listStaff.size(); j++)
	    	    	{			
	    			
	    				SsUser staff1  = (SsUser)listStaff.get(j);
	    				
	    				
	    				
	    				if(staff1.getDeptid().equals(dep.getDeptid())){
	    					
	    					JSONTreeNodeSel node1 = new JSONTreeNodeSel();
	    					node1.setText(staff1.getFullname());
	    					node1.setId(staff1.getUsername());
	    					node1.setDep(false);
	    					node.getChildren().add(node1);
	    					node.setLeaf(false);
	    					node1.setIconCls("staffs");
	    					
	    					
	    				
	    				}
	    			}
	    			
	    			createTree(listDept,listStaff,dep.getDeptid().toString(), node);
	    		}
	    		
	    	}
	    	return inode;

	    }
	    
	    
		public String SelectUser() {
			try {
				JSONTreeNodeSel	node = new JSONTreeNodeSel();	
			 List listDept =	ssDeptManager.findAll();
			 List listStaff =	ssUserManager.findAll();
			 node.setText("顶级目录");
			 node.setId("0");
			 node.setChecked(false);
			 node.setDep(true);
			 
		
			 JSONTreeNodeSel myechoStr	=  createTree(listDept,listStaff, "0", node);
			 
			 JsonConfig jsonConfig = configJson("yyyy-MM-dd HH:mm:ss");    
				
				
				setJsonString("["+JSONObject.fromObject(myechoStr,jsonConfig).toString()+"]");

				System.out.println("["+JSONObject.fromObject(myechoStr,jsonConfig).toString()+"]");
			
			 
			} catch (Exception e) {
				e.printStackTrace();
			}
			 return JSON_JSP;
		}
		
		
		
		
	
		
		
		
		/**
		 * 根据部门查找用户列表
		 */
	 
	   
		public String selectDept() {

			HttpServletRequest request = ServletActionContext.getRequest();

			String session_deptid = "";
			SecurityContext sc = SecurityContextHolder.getContext();
			Authentication auth = sc.getAuthentication();
			MyUserDetails ud = null;
			if ((auth != null) && auth.getPrincipal() instanceof MyUserDetails) {
				ud = (MyUserDetails) auth.getPrincipal();
				if (ud != null) {
					session_deptid = ud.getDeptID();
				}
			}
			String formName = "";
			String inputName = "";
			String hiddenName = "";
			String hiddenType = "";
			String maxPatiNum = "1";
			String initPageFlag = "0";
			String rootID = "";
			String deptTypeId = "";
			String idValueIsSeq = "false";
			String startwith = "1000";
			if (request.getParameter("formName") != null)
				formName = request.getParameter("formName");
			if (request.getParameter("inputName") != null)
				inputName = request.getParameter("inputName");
			if (request.getParameter("hiddenName") != null)
				hiddenName = request.getParameter("hiddenName");
			if (request.getParameter("hiddenType") != null)
				hiddenType = request.getParameter("hiddenType");
			if (request.getParameter("maxPatiNum") != null)
				maxPatiNum = request.getParameter("maxPatiNum");
			if (request.getParameter("initPageFlag") != null)
				initPageFlag = request.getParameter("initPageFlag");
			if (request.getParameter("rootID") != null)
				rootID = request.getParameter("rootID");
			if (request.getParameter("deptTypeId") != null)
				deptTypeId = request.getParameter("deptTypeId");
			if (request.getParameter("idValueIsSeq") != null)
				idValueIsSeq = request.getParameter("idValueIsSeq");
			if (request.getParameter("startwith") != null)
				 startwith = request.getParameter("startwith");
			request.setAttribute("formName", formName);
			request.setAttribute("inputName", inputName);
			request.setAttribute("hiddenName", hiddenName);
			request.setAttribute("hiddenType", hiddenType);
			request.setAttribute("maxPatiNum", maxPatiNum);
			request.setAttribute("initPageFlag", initPageFlag);
			request.setAttribute("rootID", rootID);
			request.setAttribute("deptID", session_deptid);
			request.setAttribute("deptTypeId", deptTypeId);
			request.setAttribute("idValueIsSeq", idValueIsSeq);
			request.setAttribute("startwith", startwith);

			return SELECTDEPT;
		}
		/**
		 * 根据部门查找从业人员
		 */
	 
		public String selectCyry() {
			
		HttpServletRequest request = ServletActionContext.getRequest();
		String session_deptid = "";
		SecurityContext sc = SecurityContextHolder.getContext();
		Authentication auth = sc.getAuthentication();
		MyUserDetails ud = null;
		if ((auth != null) && auth.getPrincipal() instanceof MyUserDetails) {
			ud = (MyUserDetails) auth.getPrincipal();
			if (ud != null) {
				session_deptid = ud.getDeptID();
			}
		}
		String formName = "";
		String inputName = "";
		String hiddenName = "";
		String hiddenType = "";
		String maxPatiNum = "1";
		String initPageFlag = "0";
		String rootID="";
		String deptTypeId = "";
		if (request.getParameter("formName") != null)
			formName = request.getParameter("formName");
		if (request.getParameter("inputName") != null)
			inputName = request.getParameter("inputName");
		if (request.getParameter("hiddenName") != null)
			hiddenName = request.getParameter("hiddenName");
		if (request.getParameter("hiddenType") != null)
			hiddenType = request.getParameter("hiddenType");
		if (request.getParameter("maxPatiNum") != null)
			maxPatiNum = request.getParameter("maxPatiNum");
		if (request.getParameter("initPageFlag") != null)
			initPageFlag = request.getParameter("initPageFlag");
		if (request.getParameter("rootID") != null)
			rootID = request.getParameter("rootID");
		if (request.getParameter("deptTypeId") != null)
			deptTypeId = request.getParameter("deptTypeId");
		request.setAttribute("formName", formName);
		request.setAttribute("inputName", inputName);
		request.setAttribute("hiddenName", hiddenName);
		request.setAttribute("hiddenType", hiddenType);
		request.setAttribute("maxPatiNum", maxPatiNum);
		request.setAttribute("initPageFlag", initPageFlag);
		request.setAttribute("rootID", rootID);
		request.setAttribute("deptID", session_deptid);
		request.setAttribute("deptTypeId", deptTypeId);

		return SELECTCYRY;
	}
		public String selectDeptCheckbox() {

		HttpServletRequest request = ServletActionContext.getRequest();
		String formName = "";
		String inputName = "";
		String hiddenName = "";
		String hiddenType = "";
		String maxPatiNum = "1";
		String rootID = "";
		String initSelectIds = "";
		String initOpenIds = "";
		String deptTypeId = "";

		String session_deptid = "";
		SecurityContext sc = SecurityContextHolder.getContext();
		Authentication auth = sc.getAuthentication();
		MyUserDetails ud = null;
		if ((auth != null) && auth.getPrincipal() instanceof MyUserDetails) {
			ud = (MyUserDetails) auth.getPrincipal();
			if (ud != null) {
				session_deptid = ud.getDeptID();
			}
		}

		if (request.getParameter("formName") != null)
			formName = request.getParameter("formName");
		if (request.getParameter("inputName") != null)
			inputName = request.getParameter("inputName");
		if (request.getParameter("hiddenName") != null)
			hiddenName = request.getParameter("hiddenName");
		if (request.getParameter("hiddenType") != null)
			hiddenType = request.getParameter("hiddenType");
		if (request.getParameter("maxPatiNum") != null)
			maxPatiNum = request.getParameter("maxPatiNum");
		if (request.getParameter("rootID") != null)
			rootID = request.getParameter("rootID");
		if (request.getParameter("initSelectIds") != null)
			initSelectIds = request.getParameter("initSelectIds");
		if (request.getParameter("initOpenIds") != null)
			initOpenIds = request.getParameter("initOpenIds");
		if (request.getParameter("deptTypeId") != null)
			deptTypeId = request.getParameter("deptTypeId");
		String initSelectIdsStr = "";
		String initOpenIdsStr = "";	
		String SqlWhere = "";
		if (StringUtils.isNotEmpty(initSelectIds)) {
			String initSelectIdsArr[] = initSelectIds.split(";");
			for (int i = 0; i < initSelectIdsArr.length; i++) {
				initSelectIdsStr = initSelectIdsStr + "\""+ initSelectIdsArr[i] + "\",";
				SqlWhere = SqlWhere + "'" + initSelectIdsArr[i] + "',";
			}
			initSelectIdsStr = initSelectIdsStr.substring(0, initSelectIdsStr.length() - 1);
		
			SqlWhere = SqlWhere.substring(0, SqlWhere.length() - 1);
			String sql = "select distinct t.deptseq,t.deptlevel from ss_dept  t "
					+ " where  t.deptid in ("
					+ SqlWhere
					+ ") order by t.deptlevel";

			List parentidlist = (List) ssDeptManager.getDeptCheckbox(sql);
			Set<String> set = new HashSet<String>();
			if (parentidlist != null) {
				for (int j = 0; j < parentidlist.size(); j++) {
					Map staResults = (HashMap) parentidlist.get(j);
					String deptseq = (String) staResults.get("deptseq");
					if (deptseq != null && deptseq.length() > 0) {
						deptseq = deptseq.substring(1, deptseq.length() - 1);
						if (StringUtils.isNotEmpty(deptseq)) {
							String deptseqArr[] = deptseq.split("[.]");
							for (int i = 0; i < deptseqArr.length; i++) {
								set.add(deptseqArr[i]);
							}

						}

					}

				}
			}
			String SqlIN = "";
			for (Iterator<String> it = set.iterator(); it.hasNext();) {
				String str = (String) it.next();
				SqlIN = SqlIN + "'" + str + "',";
			}
			SqlIN = SqlIN.substring(0, SqlIN.length() - 1);
			String querySql = "select  deptid from ss_dept  t   "
					+ " where  t.deptid in ("
					+ SqlIN
					+ ") order by t.deptlevel";
			List deptlist = (List) ssDeptManager.getDeptCheckbox(querySql);
			
			if (deptlist != null) {
				for (int k = 0; k < deptlist.size(); k++) {
					Map staResults = (HashMap) deptlist.get(k);
					String deptid = (String) staResults.get("deptseq");
					initOpenIdsStr = initOpenIdsStr + "\""+ deptid + "\",";
				}
				initOpenIdsStr = initOpenIdsStr.substring(0, initOpenIdsStr.length() - 1);
			}

		}
		

		request.setAttribute("formName", formName);
		request.setAttribute("inputName", inputName);
		request.setAttribute("hiddenName", hiddenName);
		request.setAttribute("hiddenType", hiddenType);
		request.setAttribute("maxPatiNum", maxPatiNum);
		request.setAttribute("rootID", rootID);
		request.setAttribute("deptID", session_deptid);
		request.setAttribute("initSelectIds", initSelectIdsStr);
		request.setAttribute("initOpenIds", initOpenIdsStr);
		request.setAttribute("deptTypeId", deptTypeId);

		return SELECTDEPTCHECKBOX;
	}

	public String getJsTree() throws Exception {

//		Enumeration<String> keys = getRequest().getParameterNames();
//
//		while (keys.hasMoreElements()) {
//			String key = keys.nextElement();
//			//  System.out.println("key="+key);
//			String value = getRequest().getParameter(key);
//		}
		HttpServletRequest request = ServletActionContext.getRequest();
		String deptTypeId= "";
		if (request.getParameter("deptTypeId") != null)
			deptTypeId = request.getParameter("deptTypeId");

		String session_deptid = "";
		SecurityContext sc = SecurityContextHolder.getContext();
		Authentication auth = sc.getAuthentication();
		MyUserDetails ud = null;
		if ((auth != null) && auth.getPrincipal() instanceof MyUserDetails) {
			ud = (MyUserDetails) auth.getPrincipal();
			if (ud != null) {
				session_deptid = ud.getDeptID();
			}
		}
		String strID = getRequest().getParameter("id");
		String rootID="";
		if (getRequest().getParameter("rootID") != null)
			rootID = getRequest().getParameter("rootID");

	

		//根据父节点查询子节点记录
		List<SsDept> list = null;
		
		if (rootID != null && rootID.equals("true")) {
			if (strID == null || strID.equals("1")) {
				list = ssDeptManager.findRootTree(deptTypeId);
			} else {
				//java.lang.Long bdstrID = new java.lang.Long(strID);
				list = ssDeptManager.findByParentId(strID,deptTypeId);
			}
		} else {
			if (strID == null) {
				//java.lang.Long session_parentId = new java.lang.Long(session_deptid);
				list = ssDeptManager.findByParentId(session_deptid,deptTypeId);

			} else {
				if (StringUtils.isNotEmpty(session_deptid) && strID.equals("1") ) {
					if(session_deptid.equals("1000"))
					  list = ssDeptManager.findRootTree(deptTypeId);
					else{
						//java.lang.Long session_parentId = new java.lang.Long(session_deptid);
						list = ssDeptManager.findByDeptId(session_deptid,deptTypeId);
					}
				} else {
					//java.lang.Long bgstrID = new java.lang.Long(strID);
					list = ssDeptManager.findByParentId(strID,deptTypeId);
				}
			}

		}
		
		

	

		List<JSONJsTree> listTrees = new ArrayList<JSONJsTree>();
		for (SsDept department : list) {
			JSONJsTree jsTree = new JSONJsTree();
			jsTree.setData(department.getDeptname());
			JSONJsTreeAttr attr = new JSONJsTreeAttr();
			attr.setId(department.getDeptid().toString());
			attr.setNames(department.getDeptname());
			attr.setDeptseq(department.getDeptseq());
			
			if (department.getDeptlevel() != null
					&& department.getDeptlevel() == 1)
				attr.setRel("drive");
			else {
			 int count =	ssDeptManager.getCountChildDept(department.getDeptid().toString());
			 if(count < 1)
				 attr.setRel("default");
			 else 
				 attr.setRel("folder");
			}
			int level =department.getDeptlevel();
			Integer obj = new Integer(level);
			attr.setLevel(obj.toString());
			jsTree.setAttr(attr);
			jsTree.setState("closed");
			
			listTrees.add(jsTree);
		}
		Gson gson = new Gson();
		String json = gson.toJson(listTrees);
		
		HttpServletResponse response = ServletActionContext.getResponse();
		//在取得out对象之前必须先进行设置
		response.setContentType("text/json");
		response.setHeader("Cache-Control", "no-cache");
		response.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();
		out.write(json);
		out.flush();
		return null;
	}
	
	
	
	public String selectDeptForPoliceCheck() {

		HttpServletRequest request = ServletActionContext.getRequest();

		String session_deptid = "";
		SecurityContext sc = SecurityContextHolder.getContext();
		Authentication auth = sc.getAuthentication();
		MyUserDetails ud = null;
		if ((auth != null) && auth.getPrincipal() instanceof MyUserDetails) {
			ud = (MyUserDetails) auth.getPrincipal();
			if (ud != null) {
				session_deptid = ud.getDeptID();
			}
		}
		String formName = "";
		String inputName = "";
		String hiddenName = "";
		String hiddenType = "";
		String maxPatiNum = "1";
		String initPageFlag = "0";
		String rootID = "";
		String deptTypeId = "";
		String idValueIsSeq = "false";
		String startwith = "1000";
		String fzrName = "";
		if (request.getParameter("formName") != null)
			formName = request.getParameter("formName");
		if (request.getParameter("inputName") != null)
			inputName = request.getParameter("inputName");
		if (request.getParameter("hiddenName") != null)
			hiddenName = request.getParameter("hiddenName");
		if (request.getParameter("hiddenType") != null)
			hiddenType = request.getParameter("hiddenType");
		if (request.getParameter("maxPatiNum") != null)
			maxPatiNum = request.getParameter("maxPatiNum");
		if (request.getParameter("initPageFlag") != null)
			initPageFlag = request.getParameter("initPageFlag");
		if (request.getParameter("rootID") != null)
			rootID = request.getParameter("rootID");
		if (request.getParameter("deptTypeId") != null)
			deptTypeId = request.getParameter("deptTypeId");
		if (request.getParameter("idValueIsSeq") != null)
			idValueIsSeq = request.getParameter("idValueIsSeq");
		if (request.getParameter("startwith") != null)
			 startwith = request.getParameter("startwith");
		if (request.getParameter("fzrName") != null)
			fzrName = request.getParameter("fzrName");
		request.setAttribute("formName", formName);
		request.setAttribute("inputName", inputName);
		request.setAttribute("hiddenName", hiddenName);
		request.setAttribute("hiddenType", hiddenType);
		request.setAttribute("maxPatiNum", maxPatiNum);
		request.setAttribute("initPageFlag", initPageFlag);
		request.setAttribute("rootID", rootID);
		request.setAttribute("deptID", session_deptid);
		request.setAttribute("deptTypeId", deptTypeId);
		request.setAttribute("idValueIsSeq", idValueIsSeq);
		request.setAttribute("startwith", startwith);
		request.setAttribute("fzrName", fzrName);

		return SELECTDEPTPOLICECHECK;
	}
	
	public String selectPerson() {

		HttpServletRequest request = ServletActionContext.getRequest();
		String formName = "";
		String inputName = "";
		String hiddenName = "";
		String hiddenType = "";
		String maxPatiNum = "1";
		String initPageFlag = "0";
		String rootID="";
		String deptTypeId ="";
		String session_deptid = "";
		SecurityContext sc = SecurityContextHolder.getContext();
		Authentication auth = sc.getAuthentication();
		MyUserDetails ud = null;
		if ((auth != null) && auth.getPrincipal() instanceof MyUserDetails) {
			ud = (MyUserDetails) auth.getPrincipal();
			if (ud != null) {
				session_deptid = ud.getDeptID();
			}
		}
		if (request.getParameter("formName") != null)
			formName = request.getParameter("formName");
		if (request.getParameter("inputName") != null)
			inputName = request.getParameter("inputName");
		if (request.getParameter("hiddenName") != null)
			hiddenName = request.getParameter("hiddenName");
		if (request.getParameter("hiddenType") != null)
			hiddenType = request.getParameter("hiddenType");
		if (request.getParameter("maxPatiNum") != null)
			maxPatiNum = request.getParameter("maxPatiNum");
		if (request.getParameter("initPageFlag") != null)
			initPageFlag = request.getParameter("initPageFlag");
		if (request.getParameter("rootID") != null)
			rootID = request.getParameter("rootID");
		if (request.getParameter("deptTypeId") != null)
			deptTypeId = request.getParameter("deptTypeId");
		request.setAttribute("formName", formName);
		request.setAttribute("inputName", inputName);
		request.setAttribute("hiddenName", hiddenName);
		request.setAttribute("hiddenType", hiddenType);
		request.setAttribute("maxPatiNum", maxPatiNum);
		request.setAttribute("initPageFlag", initPageFlag);
		request.setAttribute("rootID", rootID);
		request.setAttribute("deptID", session_deptid);
		request.setAttribute("deptTypeId", deptTypeId);

		return SELECTPERSON;
	}

	public String getJsTreeForDeptPerson() throws Exception {

//		Enumeration<String> keys = getRequest().getParameterNames();
//
//		while (keys.hasMoreElements()) {
//			String key = keys.nextElement();
//			String value = getRequest().getParameter(key);
//			System.out.println(key+"=="+value);
//			
//		}

		HttpServletRequest request = ServletActionContext.getRequest();
		String deptTypeId= "";
		if (request.getParameter("deptTypeId") != null)
			deptTypeId = request.getParameter("deptTypeId");
		
		String session_deptid = "";
		SecurityContext sc = SecurityContextHolder.getContext();
		Authentication auth = sc.getAuthentication();
		MyUserDetails ud = null;
		if ((auth != null) && auth.getPrincipal() instanceof MyUserDetails) {
			ud = (MyUserDetails) auth.getPrincipal();
			if (ud != null) {
				session_deptid = ud.getDeptID();
			}
		}
		String strID = getRequest().getParameter("id");
		String rootID="";
		if (getRequest().getParameter("rootID") != null)
			rootID = getRequest().getParameter("rootID");


		//根据父节点查询子节点记录
		List<SsDept> list = null;
		List<SsUser> listUser = null;
		
		
		
		 if (rootID != null && rootID.equals("true")) {
				if (strID == null || strID.equals("1")) {
					list = ssDeptManager.findRootTree(deptTypeId);
					//listUser = ssUserManager.findUserByDeptId("1000");
				} else {
				
					list = ssDeptManager.findByParentId(strID, deptTypeId);
					listUser = ssUserManager.findUserByDeptId(strID);
				}
			} else {
				if (StringUtils.isNotEmpty(session_deptid) && strID.equals("1")) {
					
					list = ssDeptManager.findByParentId(session_deptid, deptTypeId);
					listUser = ssUserManager.findUserByDeptId(session_deptid);
				} else {
					list = ssDeptManager.findByParentId(strID, deptTypeId);
					listUser = ssUserManager.findUserByDeptId(strID);
				}

			}
		
		
		List<JSONJsTree> listTrees = new ArrayList<JSONJsTree>();
		//添加部门
		for (SsDept department : list) {
			JSONJsTree jsTree = new JSONJsTree();
			jsTree.setData(department.getDeptname());
			JSONJsTreeAttr attr = new JSONJsTreeAttr();
			attr.setId(department.getDeptid().toString());
			attr.setNames(department.getDeptname());
			if (department.getDeptlevel() != null
					&& department.getDeptlevel() == 1)
				attr.setRel("drive");
			else 
				attr.setRel("folder");
			int level =department.getDeptlevel();
			Integer obj = new Integer(level);
			attr.setLevel(obj.toString());
			attr.setNodeTypes("dept");
			jsTree.setAttr(attr);
			jsTree.setState("closed");
			listTrees.add(jsTree);
		}
		//添加用户
		for (SsUser user : listUser) {
			JSONJsTree jsTree = new JSONJsTree();
			jsTree.setData(user.getFullname());
			JSONJsTreeAttr attr = new JSONJsTreeAttr();
			attr.setId(user.getUsername());
			attr.setNames(user.getFullname());
			attr.setRel("default");
			attr.setLevel("person");
			attr.setNodeTypes("person");
			jsTree.setAttr(attr);
			jsTree.setState("");
			listTrees.add(jsTree);
		}
		Gson gson = new Gson();
		String json = gson.toJson(listTrees);
		
		//System.out.println(json);
		
		HttpServletResponse response = ServletActionContext.getResponse();
		//在取得out对象之前必须先进行设置
		response.setContentType("text/json");
		response.setHeader("Cache-Control", "no-cache");
		response.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();
		out.write(json);
		out.flush();
		return null;
	}

	private void insertWithAssigned(SsDept e, String sql) {
		// TODO Auto-generated method stub
		
	}
	


}
