/*
 * Powered By [lishicheng]
 */

package com.dyneinfo.zazh.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cn.org.rapid_framework.beanutils.BeanUtils;

import com.opensymphony.xwork2.Preparable;
import com.opensymphony.xwork2.ModelDriven;

import org.security.userdetails.MyUserDetails;
import org.springframework.security.Authentication;
import org.springframework.security.context.SecurityContext;
import org.springframework.security.context.SecurityContextHolder;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import net.java.dev.common.util.DateUtil;

import org.apache.commons.lang.StringUtils;
import org.apache.struts2.ServletActionContext;

import java.util.*;

import javacommon.base.*;
import javacommon.util.*;

import cn.org.rapid_framework.util.*;
import cn.org.rapid_framework.web.util.*;
import cn.org.rapid_framework.page.*;
import cn.org.rapid_framework.page.impl.*;


import com.dyneinfo.zazh.model.*;
import com.dyneinfo.zazh.dao.*;
import com.dyneinfo.zazh.service.*;
import com.google.gson.Gson;

/**
 * @author lisc email:lishicheng(a)gmail.com
 */


public class SsGroupAction extends BaseStruts2Action implements Preparable,ModelDriven{
	//默认多列排序,example: username desc,createTime asc
	protected static final String DEFAULT_SORT_COLUMNS = null; 
	
	//forward paths
	protected static final String QUERY_JSP = "/pages/SsGroup/query.jsp";
	protected static final String LIST_JSP= "/pages/SsGroup/list.jsp";
	protected static final String CREATE_JSP = "/pages/SsGroup/create.jsp";
	protected static final String EDIT_JSP = "/pages/SsGroup/edit.jsp";
	protected static final String SHOW_JSP = "/pages/SsGroup/show.jsp";
	//redirect paths,startWith: !
	protected static final String LIST_ACTION = "!/pages/SsGroup/list.do";
	
	protected static final String GROUPROLES_JSP = "/pages/SsGroup/groupRoles.jsp";
	
	private SsGroupManager ssGroupManager;
	private SsRoleManager ssRoleManager;
	
	private SsGroup ssGroup;
	java.lang.Long id = null;
	private String[] items;
	private String returnUrl;  //返回列表，保留查询条件
	private TreeMap<String, String> dateSelectMap;// //日期选择

	public void prepare() throws Exception {
		if (isNullOrEmptyString(id)) {
			ssGroup = new SsGroup();
		} else {
			ssGroup = (SsGroup)ssGroupManager.getById(id);
		}
	}
	
	/** 增加setXXXX()方法,spring就可以通过autowire自动设置对象属性 */
	public void setSsGroupManager(SsGroupManager manager) {
		this.ssGroupManager = manager;
	}	
	
	public Object getModel() {
		return ssGroup;
	}
	
	public void setGroupid(java.lang.Long val) {
		this.id = val;
	}

	public void setItems(String[] items) {
		this.items = items;
	}
	
	public String getReturnUrl() {
		return returnUrl;
	}

	public void setReturnUrl(String returnUrl) {
		this.returnUrl = returnUrl;
	}
	public TreeMap<String, String> getDateSelectMap() {
		return dateSelectMap;
	}

	public void setDateSelectMap(TreeMap<String, String> dateSelectMap) {
		this.dateSelectMap = dateSelectMap;
	}

	/** 进入查询页面 */
	public String query() {
		//日历快速选择用到
		dateSelectMap  = DateUtil.getDateSelectData();
//		HttpServletRequest request = ServletActionContext.getRequest();
//		request.setAttribute("dateSelect","11");//选中本周
//		DateUtil tt = new DateUtil();     
//      pageRequest.getFilters().put("s_inTime_start",tt.getMondayOFWeek());//页面
//      pageRequest.getFilters().put("s_inTime_end",tt.getCurrentWeekday());//
		return QUERY_JSP;
	}
	
	/** 执行搜索 */
	public String list() {
		PageRequest<Map> pageRequest = newPageRequest(DEFAULT_SORT_COLUMNS);
		HttpServletRequest request = ServletActionContext.getRequest();
		//pageRequest.getFilters().put("key",value);     //add custom filter
		
        SecurityContext sc = SecurityContextHolder.getContext();
        Authentication auth = sc.getAuthentication();
        MyUserDetails ud = null;
		String username = "";
		String deptid = "";
		if ((auth != null) && auth.getPrincipal() instanceof MyUserDetails) {
			ud = (MyUserDetails) auth.getPrincipal();
			if (ud != null) {
				username = ud.getUserName();
				deptid = ud.getDeptID();
			}
		}	
		dateSelectMap  = DateUtil.getDateSelectData();
		String dateSelect7 = "";
		if (request.getParameter("dateSelect7") != null)
		    dateSelect7 = request.getParameter("dateSelect7");
			request.setAttribute("dateSelect7",dateSelect7);		        
		String dateSelect8 = "";
		if (request.getParameter("dateSelect8") != null)
		    dateSelect8 = request.getParameter("dateSelect8");
			request.setAttribute("dateSelect8",dateSelect8);		        
		String dateSelect11 = "";
		if (request.getParameter("dateSelect11") != null)
		    dateSelect11 = request.getParameter("dateSelect11");
			request.setAttribute("dateSelect11",dateSelect11);		        
		String dateSelect12 = "";
		if (request.getParameter("dateSelect12") != null)
		    dateSelect12 = request.getParameter("dateSelect12");
			request.setAttribute("dateSelect12",dateSelect12);		        
		
		Page page = ssGroupManager.findByPageRequest(pageRequest);
		savePage(page,pageRequest);
		return LIST_JSP;
	}
	
	/** 查看对象*/
	public String show() {
		HttpServletRequest request = ServletActionContext.getRequest();
		return SHOW_JSP;
	}
	
	/** 进入新增页面*/
	public String create() {
		return CREATE_JSP;
	}
	
	/** 保存新增对象 */
	public String save() {
		HttpServletRequest request = ServletActionContext.getRequest();
		ssGroupManager.save(ssGroup);
		return returnUrl;////LIST_ACTION;
	}
	
	/**进入更新页面*/
	public String edit() {
		HttpServletRequest request = ServletActionContext.getRequest();
		return EDIT_JSP;
	}
	
	/**保存更新对象*/
	public String update() {
		HttpServletRequest request = ServletActionContext.getRequest();
		ssGroupManager.update(this.ssGroup);
		return returnUrl;////LIST_ACTION;
	}
	
	/**删除对象*/
	public String delete() {
		for(int i = 0; i < items.length; i++) {
			Hashtable params = HttpUtils.parseQueryString(items[i]);
			java.lang.Long id = new java.lang.Long((String)params.get("groupid"));
			ssGroupManager.removeById(id);
		}
		return returnUrl ;//LIST_ACTION;
	}
    public String getJsTree() throws Exception {

//		Enumeration<String> keys = getRequest().getParameterNames();
//		while (keys.hasMoreElements()) {
//			String key = keys.nextElement();
//			String value = getRequest().getParameter(key);
//			System.out.println("getJsTree==========="+key + " value=" + value);
//
//		}
		HttpServletRequest request = ServletActionContext.getRequest();
		String str_id = "";
		String deptTypeId = "";
		String rootID = "";
		String session_deptid = "";
		Long long_id = 0L;
		if (request.getParameter("id") != null)
			str_id = request.getParameter("id");
		if (request.getParameter("deptTypeId") != null)
			deptTypeId = request.getParameter("deptTypeId");
		if (request.getParameter("rootID") != null)
			rootID = request.getParameter("rootID");
		if (StringUtils.isNotEmpty(str_id)) {
			long_id = new Long(str_id);
		}
		
		HttpServletResponse response = ServletActionContext.getResponse();
		// 在取得out对象之前必须先进行设置
		response.setContentType("text/json");
		response.setHeader("Cache-Control", "no-cache");
		response.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();
		if (StringUtils.isNotEmpty(str_id) && str_id.equals("1")) {
			out.write("[{\"data\":\"角色组\",\"state\":\"closed\",\"attr\":{\"id\":\"0\",\"names\":\"工作组\",\"rel\":\"drive\",\"level\":\"0\"},\"children\":[]}]");
		} else {
			List<SsGroup> list = null;
			SsGroup queryGroup = new SsGroup();
			queryGroup.setParentgroupid(long_id);
			queryGroup.setGrouptype(deptTypeId);
			list = ssGroupManager.getByParentId(queryGroup);
			List<JSONJsTree> listTrees = new ArrayList<JSONJsTree>();
			for (SsGroup group : list) {
				JSONJsTree jsTree = new JSONJsTree();
				jsTree.setData(group.getGroupname());
				JSONJsTreeAttr attr = new JSONJsTreeAttr();
				attr.setId(group.getGroupid().toString());
				attr.setNames(group.getGroupname());
				Number totalCount = ssGroupManager.getChildGroupCount(group.getGroupid());
				if (group.getGrouplevel() != null && group.getGrouplevel() == 0)
					attr.setRel("drive");
				else
					attr.setRel("folder");
				if (totalCount == null || totalCount.longValue() <= 0) {
					jsTree.setState("open");
				} else {
					jsTree.setState("closed");
				}
				long level = group.getGrouplevel();
				int int_level = (int) level;
				Integer obj = new Integer(int_level);
				attr.setLevel(obj.toString());
				jsTree.setAttr(attr);
				listTrees.add(jsTree);
			}
			Gson gson = new Gson();
			String json = gson.toJson(listTrees);
			out.write(json);
		}
		out.flush();
		return null;
	}
    
	public String saveJsTree() throws IOException {
		Enumeration<String> keys = getRequest().getParameterNames();
		while (keys.hasMoreElements()) {
			String key = keys.nextElement();
			String value = getRequest().getParameter(key);
			System.out.println(key + " value=" + value);

		}
		HttpServletRequest request = ServletActionContext.getRequest();
		
		String position = "";
		String operation = ""; // value=create_node
		String type = ""; // value=default
		String title = "";// value=New node
		String id = ""; // value=10

		Long long_id = null;
		Integer int_position = null;

		if (request.getParameter("position") != null)
			position = request.getParameter("position");
		if (request.getParameter("operation") != null)
			operation = request.getParameter("operation");
		if (request.getParameter("type") != null)
			type = request.getParameter("type");
		if (request.getParameter("title") != null)
			title = request.getParameter("title");
		if (request.getParameter("id") != null)
			id = request.getParameter("id");
		if (StringUtils.isNotEmpty(id))
			long_id = new Long(id);
		if (StringUtils.isNotEmpty(position))
			int_position = new Integer(position);



		String parentSeq = ".0.";
		int parentlevel = 0;
		SsGroup group = null;
		if (StringUtils.isNotEmpty(id) && !id.equals("0")) {
			 group = (SsGroup) ssGroupManager.getById(long_id);
			parentSeq = group.getGroupseq();
			parentlevel = group.getGrouplevel();
		}

		SsGroup newgroup = new SsGroup();
		Date date = new Date();
		SimpleDateFormat format_inserttime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String str_inserttime = format_inserttime.format(date);
		newgroup.setGroupname(title);
		newgroup.setGroupdesc(title);
		newgroup.setGrouplevel(parentlevel + 1);
		newgroup.setGroupseq(parentSeq);
		newgroup.setDisplayorder(int_position);
		newgroup.setParentgroupid(long_id);
		newgroup.setGroupstatus("1");
		newgroup.setIsleaf("N");
		newgroup.setCreatetimeString(str_inserttime);
		

		HttpServletResponse response = ServletActionContext.getResponse();
		// 在取得out对象之前必须先进行设置
		response.setContentType("text/json");
		response.setHeader("Cache-Control", "no-cache");
		response.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();
		try {
			ssGroupManager.save(newgroup);
			if (newgroup != null && newgroup.getGroupid() != null) {
				parentSeq += newgroup.getGroupid().toString() + ".";
				ssGroupManager.updateGroupseq(parentSeq,newgroup.getGroupid());
			} 
			if(group != null && group.getIsleaf() != null && group.getIsleaf().equals("N")){
				//父是非字节点，不处理
			} else {
				ssGroupManager.updateIsleaf("N", long_id);
			}
			out.write("{\"id\":\"" + newgroup.getGroupid()+ "\",\"status\":\"1\"}");
		} catch (Exception e) {
			e.printStackTrace();
			out.write("{ \"status\" : 0 }");
		}
		out.flush();
		return null;
	}

	public String moveJsTree() throws IOException {
		Enumeration<String> keys = getRequest().getParameterNames();
		while (keys.hasMoreElements()) {
			String key = keys.nextElement();
			String value = getRequest().getParameter(key);
			System.out.println("==========moveJsTree= "+key + " value=" + value);

		}
		HttpServletResponse response = ServletActionContext.getResponse();
		// 在取得out对象之前必须先进行设置
		response.setContentType("text/json");
		response.setHeader("Cache-Control", "no-cache");
		response.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();
		try {
		HttpServletRequest request = ServletActionContext.getRequest();
		String position = "";
		String operation = ""; // value=create_node
		String id = ""; // 源
		String ref ="";//目标
		String copy ="";
		

		Long long_id = null;
		Long long_ref = null;
		Long long_position = null;

		if (request.getParameter("position") != null)
			position = request.getParameter("position");
		if (request.getParameter("operation") != null)
			operation = request.getParameter("operation");
		if (request.getParameter("id") != null)
			id = request.getParameter("id");
		if (request.getParameter("ref") != null)
			ref = request.getParameter("ref");
		if (request.getParameter("copy") != null)
			copy = request.getParameter("copy");
		if (StringUtils.isNotEmpty(id))
			long_id = new Long(id);
		if (StringUtils.isNotEmpty(ref))
			long_ref = new Long(ref);
		if (StringUtils.isNotEmpty(position))
			long_position = new Long(position);

		if (id == null || id.equals(""))
			return "-1";
		if (ref == null || ref.equals(""))
			return "-1";
		// 移动一个机构到另外一个机构下，并且将这个机构下所有机构都转到目标机构
		// 查询源机构信息
		SsGroup srcGroup = (SsGroup) ssGroupManager.getById(long_id);
		if (srcGroup == null || srcGroup.getGroupseq().equals(""))
			return "-2";
		String srcSEQ = srcGroup.getGroupseq();
		List<SsGroup> srcList = ssGroupManager.getByGroupSeq(srcSEQ);
		int srcLevel = srcGroup.getGrouplevel();
		int src_displayorder = srcGroup.getDisplayorder();
		Long src_parentid = srcGroup.getParentgroupid();

		// 查询目标机构信息
		SsGroup refGroup = (SsGroup) ssGroupManager.getById(long_ref);
		if (refGroup == null || refGroup.getGroupseq().equals(""))
			return "-2";
		String refSEQ = refGroup.getGroupseq();
		List<SsGroup> refList = ssGroupManager.getByGroupSeq(refSEQ);
		int reftLevel = refGroup.getGrouplevel();
		int ref_displayorder = refGroup.getDisplayorder();
		Long ref_parentid = refGroup.getParentgroupid();

		if (refGroup.getGroupseq().startsWith(srcGroup.getGroupseq())) {
			System.out.println("移动机构的目标机构是源机构的子机构");
			return "-3"; // 移动机构的目标机构是源机构的子机构
		}

		Number totalCount = ssGroupManager.getChildGroupCount(long_ref);
		if (long_position >= totalCount.longValue()) {
			System.out.println("src_parentid="+src_parentid);
			System.out.println("long_ref="+long_ref);
			if(src_parentid.toString().equals(long_ref.toString()) ){
			    long_position = totalCount.longValue()-1;
			    System.out.println(src_parentid+"相等="+long_ref);
			}
			else {
				 long_position = totalCount.longValue();
				  System.out.println(src_parentid+"不相等="+long_ref);
			}
		}

		if (copy != null && copy.equals("0")) {
			System.out.println("移动 del cut 机构");
			System.out.println("updateDeptDisplayorder4NewParent ref_parentid="+ref_parentid);
			System.out.println(long_position);
		
			ssGroupManager.updateGroupDisplayorder4NewParentCopy(long_ref, long_position.intValue(),src_parentid);
			System.out.println("updateDeptDisplayorder4DelOrCut src_parentid="+src_parentid);
			System.out.println(src_displayorder);
			ssGroupManager.updateGroupDisplayorder4DelOrCut(src_parentid, src_displayorder);
			// 查询源机构下的所有机构，修改移动引起的level seq 数据
			for (SsGroup group : srcList) {
				Long groupid = group.getGroupid();
				long level = group.getGrouplevel();
				String seq = group.getGroupseq();
				Long parentid = group.getParentgroupid();
				if (srcSEQ.equals(seq)) {
					String deptseq = refSEQ.concat(String.valueOf(id) + ".");
					ssGroupManager.updateSrcGroup(deptseq, long_position.intValue(), long_ref,  reftLevel + 1, groupid);
				} else{
					StringBuffer newSeq = new StringBuffer(refSEQ);
					newSeq.append(id);
					newSeq.append(".");
					newSeq.append(seq.substring(srcSEQ.length()));
					Long childLevel =  level - srcLevel + reftLevel + 1;
					ssGroupManager.updateSrcChildGroup(newSeq.toString(), childLevel.intValue() , groupid);
				}
			}
			
			//更新目标菜单isleaf为N,复制的菜单数据isleaf不变
			ssGroupManager.updateIsleaf("N", long_ref);
			
		} else {
			System.out.println("复制机构");
			ssGroupManager.updateGroupDisplayorder4NewParent(long_ref, long_position.intValue());
			for (SsGroup group : srcList) {
				long level = group.getGrouplevel();
				
				
				String seq = group.getGroupseq();
				Long parentid = group.getParentgroupid();
				int displayorder = group.getDisplayorder();
				String title = group.getGroupname();
				String deptdesc =  group.getGroupdesc();
				
				if (srcSEQ.equals(seq)) {
					Number deptidNum = ssGroupManager.getGroupSeq();
					Long new_deptid = deptidNum.longValue();
					String deptseq = refSEQ.concat(new_deptid + ".");
//					
//					SsDept cpDept = new SsDept();
//					cpDept.setDeptid(new_deptid);
//					cpDept.setDeptname(title);
//					cpDept.setDeptdesc(deptdesc);
//					cpDept.setDeptcode("");
//					cpDept.setDeptlevel(reftLevel + 1);
//					cpDept.setDeptseq(deptseq);
//					cpDept.setDisplayorder(long_position);
//					cpDept.setParentid(long_ref);
//					cpDept.setDepttypeid("1");
//					cpDept.setStatus("1");
//					cpDept.setIsleaf("N");
//					ssGroupManager.insertCpDept(cpDept);
					
					
					
				} else{
					Number deptidNum = ssGroupManager.getGroupSeq();
					Long new_deptid = deptidNum.longValue();
					StringBuffer newSeq = new StringBuffer(refSEQ);
					newSeq.append(new_deptid);
					newSeq.append(".");
					newSeq.append(seq.substring(srcSEQ.length()));
					
					
//				
//					
//					SsDept cpDept = new SsDept();
//					cpDept.setDeptid(new_deptid);
//					cpDept.setDeptname(title);
//					cpDept.setDeptdesc(deptdesc);
//					cpDept.setDeptcode("");
//					cpDept.setDeptlevel(level - srcLevel + reftLevel + 1);
//					//cpDept.setDeptseq(deptseq);
//					cpDept.setDisplayorder(displayorder);
//					cpDept.setParentid(long_ref);
//					cpDept.setDepttypeid("1");
//					cpDept.setStatus("1");
					//ssGroupManager.insertCpDept(cpDept);
					
				}
			}
		}
			
			out.write("{\"id\":\"" + "success"+ "\",\"status\":\"1\"}");
		} catch (Exception e) {
			e.printStackTrace();
			out.write("{ \"status\" : 0 }");
		}
		out.flush();
		return null;
	}
	
	public String removeJsTree() throws IOException {
		Enumeration<String> keys = getRequest().getParameterNames();
		while (keys.hasMoreElements()) {
			String key = keys.nextElement();
			String value = getRequest().getParameter(key);
			System.out.println("updateJsTree= " + key + " value=" + value);

		}
		HttpServletResponse response = ServletActionContext.getResponse();
		// 在取得out对象之前必须先进行设置
		response.setContentType("text/json");
		response.setHeader("Cache-Control", "no-cache");
		response.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();
		HttpServletRequest request = ServletActionContext.getRequest();
		String operation = ""; // value=rename_node
		String id = ""; // value=10
		Long long_id = null;
		if (request.getParameter("operation") != null)
			operation = request.getParameter("operation");
		if (request.getParameter("id") != null)
			id = request.getParameter("id");
		if (StringUtils.isNotEmpty(id))
			long_id = new Long(id);
		
		if (StringUtils.isNotEmpty(id) && ( id.equals("1") || id.equals("2"))) {
			out.write("{\"message\":\"根工作组不能删除，删除失败!\",\"status\":\"0\"}");
			return null;
		}
		
		
		
		try {
			boolean removeFlag = true;
			SsGroup delGroup = ssGroupManager.getById(long_id);
			Number totalDeptCount = ssGroupManager.getChildGroupCount(long_id);
			
			if (totalDeptCount != null && totalDeptCount.longValue() > 0){
				removeFlag = false; 
				out.write("{\"message\":\"删除失败，存在子工作组!\",\"status\":\"0\"}");
			}
			
			if(removeFlag){
			   ssGroupManager.removeById(long_id);
			   ssGroupManager.deleteGroupRoleByGroupid(long_id);
			   //ssGroupManager.deleteGroupUserByGroupid(long_id);
			   ssGroupManager.updateGroupDisplayorder4DelOrCut(delGroup.getParentgroupid(),delGroup.getDisplayorder());
			   //检查父菜单是否有子菜单
			   Number parentDeptChildCount = ssGroupManager.getChildGroupCount(delGroup.getParentgroupid());
			   if (parentDeptChildCount != null && parentDeptChildCount.longValue() > 0)//没有子菜单，更新isleaf为Y
				   ssGroupManager.updateIsleaf("N", delGroup.getParentgroupid());
//			   else
//				   ssGroupManager.updateIsleaf("Y", delDept.getParentid());
			   
			   out.write("{\"message\":\"删除成功!\",\"status\":\"1\"}");
			}
		} catch (Exception e) {
			e.printStackTrace();
			out.write("{\"message\":\"出现异常，删除失败!\",\"status\":\"0\"}");
		}
		out.flush();
		return null;

	}
	public String updateJsTree() throws IOException {
		Enumeration<String> keys = getRequest().getParameterNames();
		while (keys.hasMoreElements()) {
			String key = keys.nextElement();
			String value = getRequest().getParameter(key);
			System.out.println("updateJsTree= " + key + " value=" + value);

		}
		HttpServletRequest request = ServletActionContext.getRequest();
		String operation = ""; // value=rename_node
		String title = "";// value=New node
		String id = ""; // value=10
		Long long_id = null;
		if (request.getParameter("operation") != null)
			operation = request.getParameter("operation");
		if (request.getParameter("title") != null)
			title = request.getParameter("title");
		if (request.getParameter("id") != null)
			id = request.getParameter("id");
		if (StringUtils.isNotEmpty(id))
			long_id = new Long(id);
		
		HttpServletResponse response = ServletActionContext.getResponse();
		// 在取得out对象之前必须先进行设置
		response.setContentType("text/json");
		response.setHeader("Cache-Control", "no-cache");
		response.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();
		try {
			ssGroupManager.updateGroupName(title,title,long_id);
			Number totalDeptCount = ssGroupManager.getChildGroupCount(long_id);
			if (totalDeptCount != null && totalDeptCount.longValue() > 0)//没有子菜单，更新isleaf为Y
				ssGroupManager.updateIsleaf("N", long_id);
			out.write("{ \"status\" : 1 }");
		} catch (Exception e) {
			e.printStackTrace();
			out.write("{ \"status\" : 0 }");
		}
		out.flush();
		return null;

	}
	public String groupRolesCheckbox() {
		
//		Enumeration<String> keys = getRequest().getParameterNames();
//		while (keys.hasMoreElements()) {
//			String key = keys.nextElement();
//			String value = getRequest().getParameter(key);
//			System.out.println("==========roleMenuCheckbox= "+key + " value=" + value);
//
//		}

		HttpServletRequest request = ServletActionContext.getRequest();
		String initOpenIdsStr = "";
		String initSelectIdsStr = "";
        String groupid = "";
        String action = "";
        String selectRoles = "";
        if(request.getParameter("action") != null)
        	action = request.getParameter("action");
        if(request.getParameter("groupid") != null)
        	groupid = request.getParameter("groupid");
           
        if(action != null && action.equals("y")){
        	 if(request.getParameter("selectRoles") != null) {
        		 selectRoles = request.getParameter("selectRoles");
        		 ssGroupManager.deleteRoleGroupbyGroupid(groupid);
        	     if(selectRoles != null){
        		     String[] arrmenu  = selectRoles.split(";");
        		     for(int i=0;i<arrmenu.length;i++){
        		    	 
        		    	 if(StringUtils.isNotEmpty(arrmenu[i]))
        		    		 ssGroupManager.insertRoleGroup(arrmenu[i] , groupid);
        		    	 
        		     }
        	     }
        	 }
        }
        
       
        Map<String, String> nodeMap = new LinkedHashMap<String, String>();
        Map<String, String> leafMap = new LinkedHashMap<String, String>();
        
        //获取非叶子节点, 
        List<SsRole> presidentopen = ssRoleManager.getNotleafRoleByGroupId(groupid);
        for (SsRole president : presidentopen) {
        	//String roleid = president.getStrRoleid();
        	String parentid = president.getBusinesscode();
        	if(parentid != null){  //非叶子的父节点集合
            	nodeMap.put(parentid, parentid);
        	}
		}
        
        //获取被选中的叶子节点
        List<SsRole> presidentsel = ssRoleManager.getLeafRoleByGroupId(groupid);
        for (SsRole president : presidentsel) {
        	//Long roleid = president.getRoleid();
        	String parentid =president.getBusinesscode();
        	if(parentid != null){      //叶子的父节点集合      	
            	leafMap.put(parentid, parentid);
        	}
		}
        //获取被选中的叶子节点
        List<SsRole> presidentAll = ssRoleManager.getRoleByGroupId(groupid);
        
        for (SsRole president : presidentAll) {
        	String roleid = president.getStrRoleid();
        	if(roleid != null) {
               if(!nodeMap.containsKey(roleid) && !leafMap.containsKey(roleid)){  //叶子节点，则表示为勾选状态
	        		initSelectIdsStr = initSelectIdsStr + "'" +roleid+"',";
	        	} else{ //如果是父节点，表示为打开
	        		initOpenIdsStr = initOpenIdsStr + "'" + roleid+"',";
	       	    }
        	}
		}		
        
      //  initOpenIdsStr = "'001','002','004','005',";
     //   initSelectIdsStr = "'4001','4003','364',";
        
        //默认所有的行业的父节点都打开
        List<SsRole> parentRolesAll = ssRoleManager.findByRoleType();
        initOpenIdsStr = "";
        for (SsRole president : parentRolesAll) {
        	String roleid = president.getStrRoleid();
        	if(roleid != null) {
                //如果是父节点，表示为打开
	            initOpenIdsStr = initOpenIdsStr + "'" + roleid+"',";	       	    
        	}
		}
        
        if(initOpenIdsStr != null && initOpenIdsStr.length() > 1)
          	initOpenIdsStr = initOpenIdsStr.substring(0, initOpenIdsStr.length() - 1);
        
        if(initSelectIdsStr != null && initSelectIdsStr.length() > 1)
        	initSelectIdsStr = initSelectIdsStr.substring(0, initSelectIdsStr.length() - 1);
       
      
      
		request.setAttribute("initSelectIds", initSelectIdsStr);
		request.setAttribute("initOpenIds", initOpenIdsStr);
		request.setAttribute("groupid", groupid);
	

		return GROUPROLES_JSP;
	}
	  public String getRolesJsTree() throws Exception {

			Enumeration<String> keys = getRequest().getParameterNames();
			while (keys.hasMoreElements()) {
				String key = keys.nextElement();
				String value = getRequest().getParameter(key);
				System.out.println("getRolesJsTree==========="+key + " value=" + value);
			}
			HttpServletRequest request = ServletActionContext.getRequest();
			String str_id = "";
			String deptTypeId = "";
			String rootID = "";
			String session_deptid = "";
			Long long_id = 0L;
			if (request.getParameter("id") != null)
				str_id = request.getParameter("id");
			
			if (request.getParameter("rootID") != null)
				rootID = request.getParameter("rootID");
			
			// 根据父节点查询子节点记录
			List<SsRole> list = null;  
//			if(str_id.length() <= 3 && "000".equals(rootID)){				
//				list = ssRoleManager.getRolesType();
//			}else{
				list = ssRoleManager.getRolesByParentId(str_id);
			//}
			

			List<JSONJsTree> listTrees = new ArrayList<JSONJsTree>();
			for (SsRole role : list) {
				JSONJsTree jsTree = new JSONJsTree();
				jsTree.setData(role.getRoledesc());
				JSONJsTreeAttr attr = new JSONJsTreeAttr();
				attr.setId(role.getStrRoleid());
				attr.setNames(role.getRolename());

				Number totalCount = ssRoleManager.getChildRoleCount(role.getStrRoleid());
				if (role.getRolelevel() != null && role.getRolelevel().equals("0"))
					attr.setRel("drive");
				else
					attr.setRel("folder");					

				if (totalCount == null || totalCount.longValue() <= 0){				
				   jsTree.setState("open");
				}else{						
					jsTree.setState("closed");
				}
				
				String level = role.getRolelevel()==null? "" : role.getRolelevel().toString() ;
				
				attr.setLevel(level);
				jsTree.setAttr(attr);
				listTrees.add(jsTree);
			}
			Gson gson = new Gson();
			String json = gson.toJson(listTrees);
			
			HttpServletResponse response = ServletActionContext.getResponse();
			// 在取得out对象之前必须先进行设置
			response.setContentType("text/json");
			response.setHeader("Cache-Control", "no-cache");
			response.setCharacterEncoding("UTF-8");
			PrintWriter out = response.getWriter();
			
		//	[{"data":"系统菜单","state":"closed","attr":{"id":"2","names":"系统菜单","rel":"drive","level":"0"},"children":[]}]
		  //[{"data":"工作组","state":"open","attr":{"id":"2","names":"工作组","rel":"drive","level":"0"},"children":[]}]
			 
			 
			//System.out.println(json);
			out.write(json);
			out.flush();
			return null;
		}

	public SsRoleManager getSsRoleManager() {
		return ssRoleManager;
	}

	public void setSsRoleManager(SsRoleManager ssRoleManager) {
		this.ssRoleManager = ssRoleManager;
	}
}
