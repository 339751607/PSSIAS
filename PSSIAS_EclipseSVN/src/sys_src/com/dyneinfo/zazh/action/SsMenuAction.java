/*
 * Powered By []
 * Web Site: 
 * 
 */

package com.dyneinfo.zazh.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;

import org.apache.commons.lang.StringUtils;
import org.security.userdetails.MyUserDetails;
import org.springframework.security.Authentication;
import org.springframework.security.context.SecurityContext;
import org.springframework.security.context.SecurityContextHolder;

import cn.org.rapid_framework.beanutils.BeanUtils;

import com.opensymphony.xwork2.Preparable;
import com.opensymphony.xwork2.ModelDriven;

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



import java.io.IOException;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javacommon.util.extjs.ExtJsPageHelper;
import javacommon.util.extjs.ListRange;
import static javacommon.util.extjs.Struts2JsonHelper.*;


/**
 * @author  email: lee(a)gmail.com
 * @version 1.0
 * @since 1.0
 */


public class SsMenuAction extends BaseStruts2Action implements Preparable,ModelDriven{
	//默认多列排序,example: username desc,createTime asc
	protected static final String DEFAULT_SORT_COLUMNS = null; 
	
	//forward paths
	protected static final String QUERY_JSP = "/pages/SsMenu/query.jsp";
	protected static final String LIST_JSP= "/pages/SsMenu/list.jsp";
	protected static final String CREATE_JSP = "/pages/SsMenu/create.jsp";
	protected static final String EDIT_JSP = "/pages/SsMenu/edit.jsp";
	protected static final String SHOW_JSP = "/pages/SsMenu/show.jsp";
	protected static final String JSON_JSP = "/commons/jsonStruts.jsp";
	
	//redirect paths,startWith: !
	protected static final String LIST_ACTION = "!/pages/SsMenu/list.do";
	
	private SsMenuManager ssMenuManager;
	
	private SsMenu ssMenu;
	java.lang.Long id = null;
	private String[] items;
	
	

	private List<SsMenu> ssMenus = new ArrayList<SsMenu>(0);
	private String delData;


	public void prepare() throws Exception {
		if (isNullOrEmptyString(id)) {
			ssMenu = new SsMenu();
		} else {
			ssMenu = (SsMenu)ssMenuManager.getById(id);
		}
	}
	
	/** 增加setXXXX()方法,spring就可以通过autowire自动设置对象属性 */
	public void setSsMenuManager(SsMenuManager manager) {
		this.ssMenuManager = manager;
	}	
	
	public Object getModel() {
		return ssMenu;
	}
	
	public void setMenuid(java.lang.Long val) {
		this.id = val;
	}

	public void setItems(String[] items) {
		this.items = items;
	}

	/** 进入查询页面 */
	public String query() {
		return QUERY_JSP;
	}
	
	/** 执行搜索 */
	public String list() {
		PageRequest<Map> pageRequest = newPageRequest(DEFAULT_SORT_COLUMNS);
		//pageRequest.getFilters().put("key",value);     //add custom filter
		
		Page page = ssMenuManager.findByPageRequest(pageRequest);
		savePage(page,pageRequest);
		return LIST_JSP;
	}
	
	/** 查看对象*/
	public String show() {
		return SHOW_JSP;
	}
	
	/** 进入新增页面*/
	public String create() {
		return CREATE_JSP;
	}
	
	/** 保存新增对象 */
	public String save() {
		
		ssMenuManager.save(ssMenu);
		return LIST_ACTION;
	}
	
	/**进入更新页面*/
	public String edit() {
		return EDIT_JSP;
	}
	
	/**保存更新对象*/
	public String update() {
		ssMenuManager.update(this.ssMenu);
		return LIST_ACTION;
	}
	
	/**删除对象*/
	public String delete() {
		for(int i = 0; i < items.length; i++) {
			Hashtable params = HttpUtils.parseQueryString(items[i]);
			java.lang.Long id = new java.lang.Long((String)params.get("menuid"));
			ssMenuManager.removeById(id);
		}
		return LIST_ACTION;
	}
	
	
	
	/**
	 * ExtGrid使用
	 * 列表
	 * @throws IOException
	 */
	public void extlist() throws IOException
	{
		PageRequest<Map> pr = ExtJsPageHelper.createPageRequestForExtJs(getRequest(), DEFAULT_SORT_COLUMNS);
		Page page = ssMenuManager.findByPageRequest(pr);
		
		List<SsMenu> SsMenulist = (List) page.getResult();
		ListRange<SsMenu> resultList = new ListRange<SsMenu>();
		resultList.setList(SsMenulist);
		resultList.setTotalSize(page.getTotalCount());
		resultList.setMessage("ok");
		resultList.setSuccess(true);
		outJson(resultList);
	}

	/**
	 * extGrid保存
	 * @throws IOException
	 */
	public void extsave() throws IOException
	{
		Map<String, Object> result = new HashMap<String, Object>();
		try
		{
			ssMenuManager.save(ssMenu);
			result.put("success", true);
			result.put("msg", "添 加 成 功!");
		}
		catch (Exception e)
		{
			result.put("failure", true);
			result.put("msg", e.getMessage());
			e.printStackTrace();
		}
		outJson(result);
	}
	
	/**
	 * extGrid修改
	 * @throws IOException
	 */
	public void extupdate() throws IOException
	{
		Map<String, Object> result = new HashMap<String, Object>();
		try
		{
			ssMenuManager.save(ssMenu);
			result.put("success", true);
			result.put("msg", "修 改 成 功!");
		}
		catch (Exception e)
		{
			result.put("failure", true);
			result.put("msg", e.getMessage());
			e.printStackTrace();
		}
		outJson(result);
	}
	
	/**
	 * extGrid删除
	 * @throws IOException
	 */
	public void extdelete() throws IOException
	{
		String ids = getRequest().getParameter("ids");
		String[] idarray = ids.split(",");
		Map<String, Object> result = new HashMap<String, Object>();
		try
		{
			for (int i = 0; i < idarray.length; i++)
			{
				java.lang.Long id = new java.lang.Long((String)idarray[i]);
				ssMenuManager.removeById(id);
			}
			result.put("success", true);
			result.put("msg", "删除成功");
		}
		catch (Exception e)
		{
			result.put("failure", true);
			result.put("msg", e.getMessage());
			e.printStackTrace();
		}
		outJson(result);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	/****
	 * 
	 * 
	 * tree 菜单树
	 * 
	 *
	 */


	public String treelist(){
		List<SsMenu> listParent;
		StringBuffer buff = new StringBuffer("[{id:'"+0+"',text:'菜单结构',expanded:true,children:[");
		listParent=ssMenuManager.findRootTree();//最顶层父节点
		
		
		for(SsMenu dep:listParent){
			buff.append("{id:'"+dep.getMenuid()+"',text:'"+dep.getMenuname()+"',");
		    buff.append(findChild(dep.getMenuid(),dep.getIsleaf()));
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
	
	public String findChild(java.lang.Long depId,String isLeaf){
		//System.out.println("isLeaf="+isLeaf.toLowerCase());		
	
		StringBuffer buff1=new StringBuffer("");
		
		if(isLeaf != null && isLeaf.toLowerCase().equals("y")){
			buff1.append("leaf:true},");
			return buff1.toString(); 
		} else {
		List<SsMenu> list=ssMenuManager.findByParentId(depId);
		if(list.size()==0){
			buff1.append("leaf:true},");
			return buff1.toString(); 
		}else {
			buff1.append("children:[");
			for(SsMenu dep2:list){				
				buff1.append("{id:'"+dep2.getMenuid()+"',text:'"+dep2.getMenuname()+"',");
				buff1.append(findChild(dep2.getMenuid(),dep2.getIsleaf()));
			}
			buff1.deleteCharAt(buff1.length() - 1);
			buff1.append("]},");
			return buff1.toString();
		}
		}
	}
	
	
	
	
	/**
	 * 根据部门查找列表
	 */
   public String findMenuBySeq(){ 
   
		String strmenuId=getRequest().getParameter("menuId");
		String menuSEQ=".";

		
//		SecurityContext sc = SecurityContextHolder.getContext();
//		Authentication auth = sc.getAuthentication();
//		MyUserDetails ud = null;
//		if ((auth != null) && auth.getPrincipal() instanceof MyUserDetails) {
//			ud = (MyUserDetails) auth.getPrincipal();
//			if (ud != null) {
//				session_deptid = ud.getDeptID();
//			}
//		}
		
	
		
		if(StringUtils.isNotEmpty(strmenuId)){
			java.lang.Long depId = new java.lang.Long(strmenuId);
			SsMenu ssMenu = (SsMenu)ssMenuManager.getById(depId);
           if(ssMenu!=null){	
        	   menuSEQ=ssMenu.getMenuseq();
           }			
		}
		
		
		int start = getStart();
		int limit = getLimit(); 
		 System.out.println("start="+start);
	      System.out.println("limit="+limit);
		int totalCount  = 0;
		int pageNumber = 0;
		pageNumber =  start/limit+1;
		System.out.println("pageNumber="+pageNumber);
		 System.out.println(this.getStart() + "---" + this.getLimit());
		if(".".equals(menuSEQ)){
			PageRequest<Map> pageRequest = newPageRequest(DEFAULT_SORT_COLUMNS);
			pageRequest.setPageNumber(pageNumber);
			pageRequest.setPageSize(limit);
			pageRequest.setSortColumns(" menulevel,displayorder ");
			//pageRequest.getFilters().put("key",value);     
			Page page = ssMenuManager.findByPageRequest(pageRequest);
			
			ssMenus=page.getResult();
			totalCount  = page.getTotalCount();
		}else{
			PageRequest<Map> pageRequest = newPageRequest(DEFAULT_SORT_COLUMNS);
			pageRequest.setPageNumber(pageNumber);
			pageRequest.setPageSize(limit);
			pageRequest.getFilters().put("menuseq",menuSEQ);     
			pageRequest.setSortColumns(" menulevel,displayorder ");
			Page page = ssMenuManager.findByPageRequest(pageRequest);
			ssMenus=page.getResult();	
			totalCount  = page.getTotalCount();
		    
		}
		
		this.setTotalCount(totalCount);
		JSONArray array = JSONArray.fromObject(this.ssMenus);
		
		this.setJsonString("{success:true,totalCount : " + this.getTotalCount() + ", list:" + array.toString() + "}");
		 System.out.println(this.getJsonString());
		 return JSON_JSP;
	}
	
	
	
	public String LevelAjaxJsonData() throws Exception {
		if (this.getDelData() != null && !"".equals(this.getDelData())) {
			if (this.getDelData().indexOf(",") < 0) {
				java.lang.Long id = new java.lang.Long((String)this.getDelData());
				ssMenuManager.removeById(id);
				System.out.println("del_id:" + getDelData());
			} else {
				String id[] = this.getDelData().split(",");
				for (int i = 0; i < id.length; i++) {
					System.out.println("del:" + id[i]);
					java.lang.Long ids = new java.lang.Long((String)id[i]);
					ssMenuManager.removeById(ids);
				}
			}
		}
		HttpSession session = getRequest().getSession();
		Object o = null;// session.getAttribute("Level_Data1");
		if (o == null) {
			try {
				this.ssMenus = this.ssMenuManager.findAll();
				session.setAttribute("Level_Data1", this.ssMenus);
				
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else {
			this.setSsMenus(((List<SsMenu>) o));
		}
		this.setTotalCount(this.ssMenus.size());
		JSONArray array = JSONArray.fromObject(this.ssMenus);
		 System.out.println(this.getStart() + "---" + this.getLimit());
		this.setJsonString("{success:true,totalCount : " + this.getTotalCount() + ", list:" + array.toString() + "}");
		 System.out.println(this.getJsonString());
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
			this.ssMenu = this.ssMenuManager.getById(ids);
		} catch (Exception e) {
			e.printStackTrace();
		}
		JSONArray array = JSONArray.fromObject(ssMenu);
		this.setJsonString(array.toString());
		return JSON_JSP;
	}

	public String findLevelById() {
		
		try {
			this.ssMenu = this.ssMenuManager.getById(this.ssMenu.getMenuid());
		} catch (Exception e) {
			e.printStackTrace();
		}
		JSONArray array = JSONArray.fromObject(this.ssMenu);
		this.setJsonString(array.toString());
		this.setJsonString("{success:true,totalCount:1,list:" + array.toString() + "}");
		System.out.println(array.toString());
		return JSON_JSP;
	}




	/**
	 * Make the given instance managed and persistent.
	 * 
	 * @return
	 */
	public String AddMenu() {
		
		this.setJsonString("{success:true}");
		try {
			this.ssMenuManager.save(ssMenu);
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
	public String removeMenuById(Long id) {
		Map<String, Object> result = new HashMap<String, Object>();
		try {
			java.lang.Long ids = new java.lang.Long(id);
			
			List<SsMenu> list=ssMenuManager.findByParentId(ids);
			if(list.size()==0){
				SsMenu	tmpssMenu = this.ssMenuManager.getById(ids);
				ssMenuManager.removeroleMenu(ids.longValue());
				ssMenuManager.removeById(ids);
				//检查父菜单是否有子菜单
				 int childrenMenuCount = ssMenuManager.getCountChildrenMenu(tmpssMenu.getParentid().longValue());
				     if(childrenMenuCount < 1)//没有子菜单，更新isleaf为Y
				    	 ssMenuManager.updateIsleaf("Y", tmpssMenu.getParentid().longValue());
				        result.put("success", true);
						result.put("msg", "删除成功!");
					 
				
			} else{
				result.put("failure", true);
				result.put("msg", "删除失败，存在子菜单!");
				
			}
		} catch (Exception e) {
			e.printStackTrace();
			result.put("failure", true);
			result.put("msg", e.getMessage());
		}
		 JsonConfig jsonConfig = configJson("yyyy-MM-dd HH:mm:ss");    
		 setJsonString(JSONObject.fromObject(result,jsonConfig).toString());
		 return JSON_JSP;
	}





	public String getDelData() {
		return delData;
	}

	public void setDelData(String delData) {
		this.delData = delData;
	}





	

	
	public String add() {
		Enumeration<String> keys = getRequest().getParameterNames();
		while (keys.hasMoreElements()) {
			String key = keys.nextElement();
			String value = getRequest().getParameter(key);
			System.out.println(key + " value=" + value);

		}
		String str_parent_id = (String)getRequest().getParameter("parentid");
		String depPath = "";
		int level = 0;
		//树形root目录
		
		if(str_parent_id != null && (str_parent_id.equals("") || str_parent_id.equals("0"))){//
			
			depPath = ".";
			//java.lang.Long bd_Displayorder = new java.lang.Long(0);
			//ssMenu.setDisplayorder(bd_Displayorder);
			Integer obj = new Integer(level + 1);
			ssMenu.setMenulevel(obj.toString());
			//ssMenu.setMenudesc("desc");
			
			if(str_parent_id.equals("0")){
				ssMenu.setMenuseq(".");
				ssMenu.setIsleaf("N");
				ssMenuManager.insertRoot(ssMenu);
			} else if(str_parent_id.equals("")){
				ssMenuManager.updateRoot(ssMenu);
				 int childrenMenuCount = ssMenuManager.getCountChildrenMenu(ssMenu.getMenuid().longValue());
			     if(childrenMenuCount < 1)//没有子菜单，更新isleaf为Y
			    	 ssMenuManager.updateIsleaf("Y", ssMenu.getMenuid().longValue());
			     else
			    	 ssMenuManager.updateIsleaf("N", ssMenu.getMenuid().longValue());
			    	 
				
			}
		} 
		//树形子目录
		else {
			Long parentId = Long.parseLong(getRequest().getParameter("parentid"));
			java.lang.Long parentIds = new java.lang.Long(parentId);
			SsMenu ssDeptSearch = (SsMenu) ssMenuManager.getById(parentIds);
			depPath = ssDeptSearch.getMenuseq();
			level = Integer.parseInt(ssDeptSearch.getMenulevel());
			//java.lang.Long bd_Displayorder = new java.lang.Long(0);
			//ssMenu.setDisplayorder(bd_Displayorder);
			Integer obj = new Integer(level + 1);
			ssMenu.setMenulevel(obj.toString());
			//ssMenu.setMenudesc("desc");
			if(ssMenu != null && ssMenu.getMenuid() != null){
				ssMenuManager.update(ssMenu);//修改
				 int childrenMenuCount = ssMenuManager.getCountChildrenMenu(ssMenu.getMenuid().longValue());
			     if(childrenMenuCount < 1)//没有子菜单，更新isleaf为Y
			    	 ssMenuManager.updateIsleaf("Y", ssMenu.getMenuid().longValue());
			     else
			    	 ssMenuManager.updateIsleaf("N", ssMenu.getMenuid().longValue());
			} else {
				ssMenu.setIsleaf("Y");
				ssMenuManager.save(ssMenu);//增加
				ssMenuManager.updateIsleaf("N", ssMenu.getParentid().longValue());
			}
		}

		
	//更新菜单层次关系seq
		if (ssMenu != null && ssMenu.getMenuid() != null) {
			depPath += ssMenu.getMenuid().toString() + ".";
			ssMenu.setMenuseq(depPath);
			ssMenuManager.updateSEQ(ssMenu);
			setJsonString("{success:true}");
		} else {
			setJsonString("{success:false}");
		}

		return JSON_JSP;
	}
	
	public String remove(){
		Long menuId=Long.parseLong(getRequest().getParameter("menuId"));
		java.lang.Long ids = new java.lang.Long(menuId);
		
		Map<String, Object> result = new HashMap<String, Object>();
		try{
		List<SsMenu> list=ssMenuManager.findByParentId(ids);
		if(list.size()==0){
			SsMenu	tmpssMenu = this.ssMenuManager.getById(ids);
			ssMenuManager.removeroleMenu(ids.longValue());
			ssMenuManager.removeById(ids);
			//检查父菜单是否有子菜单
			if(tmpssMenu != null && tmpssMenu.getParentid() != null){
			 int childrenMenuCount = ssMenuManager.getCountChildrenMenu(tmpssMenu.getParentid().longValue());
			     if(childrenMenuCount < 1)//没有子菜单，更新isleaf为Y
			    	 ssMenuManager.updateIsleaf("Y", tmpssMenu.getParentid().longValue());
			}   
			        result.put("success", true);
					result.put("msg", "删除成功!"); 
			 
		} else{
			result.put("failure", true);
			result.put("msg", "删除失败，存在子菜单!");
		}
		
		
		
	} catch (Exception e) {
		e.printStackTrace();
		result.put("failure", true);
		result.put("msg", e.getMessage());
	}
	JsonConfig jsonConfig = configJson("yyyy-MM-dd HH:mm:ss");    
	 setJsonString(JSONObject.fromObject(result,jsonConfig).toString());
		 return JSON_JSP;
		
	}
	
	public String detail(){
		Long depId=Long.parseLong(getRequest().getParameter("depId"));
		java.lang.Long ids = new java.lang.Long(depId);
		SsMenu ssMenutmp = (SsMenu)ssMenuManager.getById(ids);
		Gson gson=new Gson();
		StringBuffer sb = new StringBuffer("{success:true,data:[");
		sb.append(gson.toJson(ssMenutmp));
		sb.append("]}");
		setJsonString(sb.toString());
		return JSON_JSP;
	}

	public List<SsMenu> getSsMenus() {
		return ssMenus;
	}

	public void setSsMenus(List<SsMenu> ssMenus) {
		this.ssMenus = ssMenus;
	}

}
