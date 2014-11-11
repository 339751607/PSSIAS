/*
 * Powered By []
 * Web Site: 
 * 
 */

package com.dyneinfo.zazh.action;

import static javacommon.util.extjs.Struts2JsonHelper.configJson;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;

import javacommon.base.BaseStruts2Action;
import javacommon.util.extjs.JsonUtils;

import javax.servlet.http.HttpServletRequest;

import net.java.dev.common.dict.taglib.DictHelpImpl;
import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;

import org.apache.commons.lang.StringUtils;
import org.apache.struts2.ServletActionContext;
import org.security.userdetails.MyUserDetails;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.context.ApplicationContext;
import org.springframework.security.Authentication;
import org.springframework.security.context.SecurityContext;
import org.springframework.security.context.SecurityContextHolder;
import org.springframework.security.intercept.web.FilterInvocationDefinitionSource;
import org.springframework.security.intercept.web.FilterSecurityInterceptor;
import org.springframework.web.context.support.WebApplicationContextUtils;

import cn.org.rapid_framework.page.Page;
import cn.org.rapid_framework.page.PageRequest;

import com.dyneinfo.zazh.model.DictItem;
import com.dyneinfo.zazh.model.JSONTreeNode;
import com.dyneinfo.zazh.model.Menu;
import com.dyneinfo.zazh.model.SsAuthority;
import com.dyneinfo.zazh.model.SsGroup;
import com.dyneinfo.zazh.model.SsMenu;
import com.dyneinfo.zazh.model.SsRole;
import com.dyneinfo.zazh.service.SsAuthorityManager;
import com.dyneinfo.zazh.service.SsGroupManager;
import com.dyneinfo.zazh.service.SsMenuManager;
import com.dyneinfo.zazh.service.SsRoleManager;
import com.google.gson.Gson;
import com.opensymphony.xwork2.ModelDriven;
import com.opensymphony.xwork2.Preparable;

/**
 * @author  email: lee(a)gmail.com
 * @version 1.0
 * @since 1.0
 */

public class SsRoleAction extends BaseStruts2Action implements Preparable,
		ModelDriven {
	//默认多列排序,example: username desc,createTime asc
	protected static final String DEFAULT_SORT_COLUMNS = null;

	//forward paths
	protected static final String QUERY_JSP = "/pages/SsRole/query.jsp";
	protected static final String LIST_JSP = "/pages/SsRole/list.jsp";
	protected static final String CREATE_JSP = "/pages/SsRole/create.jsp";
	protected static final String EDIT_JSP = "/pages/SsRole/edit.jsp";
	protected static final String SHOW_JSP = "/pages/SsRole/show.jsp";
	protected static final String JSON_JSP = "/commons/jsonStruts.jsp";
	//redirect paths,startWith: !
	protected static final String LIST_ACTION = "!/pages/SsRole/list.do";

	private SsRoleManager ssRoleManager;
	private SsAuthorityManager ssAuthorityManager;
	private SsMenuManager ssMenuManager;

	private SsGroupManager ssGroupManager;
	
	private SsRole ssRole;
	private List<SsRole> ssRoles = new ArrayList<SsRole>(0);
	private SsAuthority ssAuthority;
	private SsMenu ssMenu;

	/** * role list. */
	private List<SsRole> rolelist;

	/** * auth list. */
	private List<SsAuthority> authList;

	/** * menu list. */
	private List<SsMenu> menuList;

	/** * id. */
	private String id;

	/** * resc id. */
	private long authId;

	/** * menu id. */
	private long menuId;

	// ====================================================
	private int start;
	private int limit;
	private String sort;
	private String dir;
	private String filterTxt;
	private String filterValue;
	private String ids;
	private String data;
	private Long roleId;
	private boolean auth;

	java.lang.Long idrole = null;
	private String[] items;

	public void prepare() throws Exception {
		if (isNullOrEmptyString(idrole)) {
			ssRole = new SsRole();
		} else {
			ssRole = (SsRole) ssRoleManager.getById(idrole);
		}
	}

	/** 增加setXXXX()方法,spring就可以通过autowire自动设置对象属性 */
	public void setSsRoleManager(SsRoleManager manager) {
		this.ssRoleManager = manager;
	}

	public void setSsAuthorityManager(SsAuthorityManager manager) {
		this.ssAuthorityManager = manager;
	}

	public void setSsMenuManager(SsMenuManager manager) {
		this.ssMenuManager = manager;
	}

	public Object getModel() {
		return ssRole;
	}

	public void setRoleid(java.lang.Long val) {
		this.idrole = val;
	}

	public void setItems(String[] items) {
		this.items = items;
	}

	/** 进入查询页面 */
	public String query() {
		return QUERY_JSP;
	}

	//	/** 执行搜索 */
	//	public String list() {
	//		PageRequest<Map> pageRequest = newPageRequest(DEFAULT_SORT_COLUMNS);
	//		//pageRequest.getFilters().put("key",value);     //add custom filter
	//		
	//		Page page = ssRoleManager.findByPageRequest(pageRequest);
	//		savePage(page,pageRequest);
	//		return LIST_JSP;
	//	}
	//	
	//	/** 查看对象*/
	//	public String show() {
	//		return SHOW_JSP;
	//	}
	//	
	//	/** 进入新增页面*/
	//	public String create() {
	//		return CREATE_JSP;
	//	}
	//	
	//	/** 保存新增对象 */
	//	public String save() {
	//		ssRoleManager.save(ssRole);
	//		return LIST_ACTION;
	//	}
	//	
	//	/**进入更新页面*/
	//	public String edit() {
	//		return EDIT_JSP;
	//	}
	//	
	//	/**保存更新对象*/
	//	public String update() {
	//		ssRoleManager.update(this.ssRole);
	//		return LIST_ACTION;
	//	}
	//	
	//	/**删除对象*/
	//	public String delete() {
	//		for(int i = 0; i < items.length; i++) {
	//			Hashtable params = HttpUtils.parseQueryString(items[i]);
	//			java.lang.Long id = new java.lang.Long((String)params.get("roleid"));
	//			ssRoleManager.removeById(id);
	//		}
	//		return LIST_ACTION;
	//	}
	//	
	//	
	//	
	//
	//	/**
	//	 * ExtGrid使用
	//	 * 列表
	//	 * @throws IOException
	//	 */
	//	public void extlist() throws IOException
	//	{
	//		PageRequest<Map> pr = ExtJsPageHelper.createPageRequestForExtJs(getRequest(), DEFAULT_SORT_COLUMNS);
	//		Page page = ssRoleManager.findByPageRequest(pr);
	//		
	//		List<SsRole> SsRolelist = (List) page.getResult();
	//		ListRange<SsRole> resultList = new ListRange<SsRole>();
	//		resultList.setList(SsRolelist);
	//		resultList.setTotalSize(page.getTotalCount());
	//		resultList.setMessage("ok");
	//		resultList.setSuccess(true);
	//		outJson(resultList);
	//	}
	//
	//	/**
	//	 * extGrid保存
	//	 * @throws IOException
	//	 */
	//	public void extsave() throws IOException
	//	{
	//		Map<String, Object> result = new HashMap<String, Object>();
	//		try
	//		{
	//			ssRoleManager.save(ssRole);
	//			result.put("success", true);
	//			result.put("msg", "添 加 成 功!");
	//		}
	//		catch (Exception e)
	//		{
	//			result.put("failure", true);
	//			result.put("msg", e.getMessage());
	//			e.printStackTrace();
	//		}
	//		outJson(result);
	//	}
	//	
	//	/**
	//	 * extGrid修改
	//	 * @throws IOException
	//	 */
	//	public void extupdate() throws IOException
	//	{
	//		Map<String, Object> result = new HashMap<String, Object>();
	//		try
	//		{
	//			ssRoleManager.save(ssRole);
	//			result.put("success", true);
	//			result.put("msg", "修 改 成 功!");
	//		}
	//		catch (Exception e)
	//		{
	//			result.put("failure", true);
	//			result.put("msg", e.getMessage());
	//			e.printStackTrace();
	//		}
	//		outJson(result);
	//	}
	//	
	//	/**
	//	 * extGrid删除
	//	 * @throws IOException
	//	 */
	//	public void extdelete() throws IOException
	//	{
	//		String ids = getRequest().getParameter("ids");
	//		String[] idarray = ids.split(",");
	//		Map<String, Object> result = new HashMap<String, Object>();
	//		try
	//		{
	//			for (int i = 0; i < idarray.length; i++)
	//			{
	//				java.lang.Long id = new java.lang.Long((String)idarray[i]);
	//				ssRoleManager.removeById(id);
	//			}
	//			result.put("success", true);
	//			result.put("msg", "删除成功");
	//		}
	//		catch (Exception e)
	//		{
	//			result.put("failure", true);
	//			result.put("msg", e.getMessage());
	//			e.printStackTrace();
	//		}
	//		outJson(result);
	//	}
	//	
	//	
	//	
	//	
	//	
	//	
	//	
	//	
	//	
	//	
	//	

	/** * @param id long. */
	public void setId(String id) {
		this.id = id;
	}

	/** * @param menuId long. */
	public void setMenuId(long menuId) {
		this.menuId = menuId;
	}

	// ====================================================
	public void setStart(int start) {
		this.start = start;
	}

	public void setLimit(int limit) {
		this.limit = limit;
	}

	public void setSort(String sort) {
		this.sort = sort;
	}

	public void setDir(String dir) {
		this.dir = dir;
	}

	public void setFilterTxt(String filterTxt) {
		this.filterTxt = filterTxt;
	}

	public void setFilterValue(String filterValue) {
		this.filterValue = filterValue;
	}

	/**
	 * 分页浏览记录.
	 *
	 * @throws Exception 异常
	 */
	public void pagedQuery() throws Exception {
		// 分页
		int pageNo = (start / limit) + 1;

		System.out.println("dir=" + dir);
		System.out.println("sort=" + sort);
		System.out.println("filterTxt=" + filterTxt);
		System.out.println("filterValue=" + filterValue);
		System.out.println("start=" + start);
		System.out.println("limit=" + limit);

		Enumeration<String> keys = getRequest().getParameterNames();
		while (keys.hasMoreElements()) {
			String key = keys.nextElement();
			String value = getRequest().getParameter(key);
			System.out.println(key + "=== value=" + value);

		}

		int pageNumber = 0;
		pageNumber = start / limit + 1;

		PageRequest<Map> pageRequest = newPageRequest(DEFAULT_SORT_COLUMNS);
		pageRequest.setPageNumber(pageNumber);
		pageRequest.setPageSize(limit);

		if (filterTxt != null && filterTxt.equals("rolename"))
			pageRequest.getFilters().put("rolename", filterValue);
		else if (filterTxt != null && filterTxt.equals("roledesc"))
			pageRequest.getFilters().put("roledesc", filterValue);
		Page page = ssRoleManager.findByPageRequest(pageRequest);
		List result = page.getResult();
		int totalCount = page.getTotalCount();
		javacommon.util.extjs.Page pages = new javacommon.util.extjs.Page(
				result, totalCount);

		JsonUtils.write(pages, ServletActionContext.getResponse().getWriter(),
				getExcludes(), getDatePattern());
	}

	/**
	 * 保存，新增或修改.
	 *
	 * @throws Exception 异常
	 */
	public void extjssave() throws Exception {
		
		Map<String, Object> result = new HashMap<String, Object>();
		String message = "";
		//判断如果id部位空则是修改操作，反之进入新建操作
		if (id != null && id.length() > 0) {
			java.lang.Long bd_editid = new java.lang.Long(id);
			SsRole ssRole2 = (SsRole) ssRoleManager.getById(bd_editid);
			//如果根据id可以查询到数据，并且数据角色名称不为空，并且查询到的角色名称和表单提交的名称一致则更新本条数据
			if (ssRole2 != null && ssRole2.getRolename() != null
					&& ssRole2.getRolename().toUpperCase().equals(ssRole.getRolename().toUpperCase())) {
				//ssRole.setRoleid(bd_editid);
				ssRole2.setRolename(ssRole.getRolename().toUpperCase());
				ssRole2.setRoledesc(ssRole.getRoledesc());
				ssRoleManager.update(ssRole2);
				ServletActionContext.getResponse().getWriter().print(
						"{success:true}");
			} else {
				//如果新更新的数据名称与原有数据中名称重复则不能更新, 不同的行业应该可以同名
				int usercount = ssRoleManager.getCountRoleName(ssRole.getRolename(), ssRole.getParentid().toString());
				if (usercount < 1) {
					ssRole.setRoleid(bd_editid);
					ssRoleManager.update(ssRole);
					ServletActionContext.getResponse().getWriter().print(
							"{success:true}");
				} else {
					ServletActionContext.getResponse().getWriter().print(
							"{success:false,msg:\"相同行业角色名重复！\"}");
					message = "角色名重复！";
				}
			}
		} else if (id == null || "".equals(id)) {
			//行业类型
			String node_id=getRequest().getParameter("nodeId");			
			String businesscode = node_id ; 
			//检查同一个行业是否有重名存在
			int usercount = ssRoleManager.getCountRoleName(ssRole.getRolename(), businesscode);		
			
			if(businesscode == null || "0".equals(businesscode)){
				ServletActionContext.getResponse().getWriter().print("{success:false,msg:\"不能在根目录新增角色！\"}");
			}else{
				if (usercount < 1 && StringUtils.isNotEmpty(node_id)) {
					ssRole.setBusinesscode(businesscode);
					ssRole.setParentid(new Long(businesscode));
					ssRole.setRolelevel(new Long(3));
					
					ssRoleManager.save(ssRole);
				    ServletActionContext.getResponse().getWriter().print("{success:true,su:true,msg:\"保存成功！\"}");
			
				} else{
					ServletActionContext.getResponse().getWriter().print("{success:false,msg:\"角色名重复！\"}");
				}
			}
		}
		result.put("msg", message);
		JsonConfig jsonConfig = configJson("yyyy-MM-dd HH:mm:ss");
		String resultString = JSONObject.fromObject(result, jsonConfig)
				.toString();

	}

	/**
	 * 读取数据.
	 * 
	 * @throws Exception
	 *             异常
	 */
	public void loadData() throws Exception {

		java.lang.Long bd_editid = new java.lang.Long(id);
		ssRole = (SsRole) ssRoleManager.getById(bd_editid);
		if (ssRole != null) {
			List<SsRole> list = new ArrayList<SsRole>();
			list.add(ssRole);
			JsonUtils.write(list, ServletActionContext.getResponse()
					.getWriter(), getExcludes(), getDatePattern());
		}
	}

	/**
	 * 删除记录.
	 *
	 * @throws Exception 异常
	 */
	public void remove() throws Exception {
		Map<String, Object> result = new HashMap<String, Object>();
		String message = "";
		for (String str : ids.split(",")) {

			try {
				
				java.lang.Long id = new java.lang.Long(str);
				int rolecount=ssRoleManager.getCountRole(id.longValue());
				//不存在用户才能删除
				int usercount = ssRoleManager.getCountRoleUser(id.longValue());
				SsRole ssRoletmp = null;
				String roleName = "";
				ssRoletmp = ssRoleManager.getById(id);
				if (ssRoletmp != null)
					roleName = ssRoletmp.getRolename();
				if(rolecount<1){
					if (usercount < 1) {
	
						ssRoleManager.removeroleAuthority(id.longValue());
						ssRoleManager.removeroleMenu(id.longValue());
						ssRoleManager.removeroleUser(id.longValue());
	
						ssRoleManager.removeById(id);
	
						message = message + "角色" + roleName + "删除成功.<br>";
					} else {
	
						message = message + "角色" + roleName + "存在用户没有删除.<br>";
					}
				}else{
					message = message + "角色" + roleName + "存在下级角色，没有删除.<br>";
				}

			} catch (NumberFormatException ex) {
				ex.printStackTrace();
				continue;
			}

		}

		result.put("success", true);
		result.put("msg", message);
		refreshAuthority();
		JsonConfig jsonConfig = configJson("yyyy-MM-dd HH:mm:ss");
		String resultString = JSONObject.fromObject(result, jsonConfig)
				.toString();

		//setJsonString(resultString);

		//return JSON_JSP;
		ServletActionContext.getResponse().getWriter().print(resultString);

	}

	public void setIds(String ids) {
		this.ids = ids;
	}

	public void setData(String data) {
		this.data = data;
	}

	public String[] getExcludes() {
		return new String[] { "roles", "users", "menus", "rescs" };
	}

	public String getDatePattern() {
		return "yyyy-MM-dd";
	}

	/**
	 * 显示角色对应的资源列表.
	 *
	 * @throws Exception 异常
	 */
	public void getRescs() throws Exception {


		List<SsAuthority> roleAuthList = ssAuthorityManager
				.findAllByRoleID(roleId);


		java.lang.Long bd_roleid = new java.lang.Long(roleId);
		SsRole ssRole = (SsRole) ssRoleManager.getById(bd_roleid);

		List<SsAuthority> allAuthLists = ssAuthorityManager.findAll();

		if (ssRole != null) {
			for (SsAuthority resc : allAuthLists) {
				java.lang.Long authid = resc.getAuthorityid();
				for (SsAuthority ssAuthority : roleAuthList) {
					java.lang.Long roleauthid = ssAuthority.getAuthorityid();

					if (authid.equals(roleauthid)) {
						resc.setAuthorized(true);
					}
				}
			}
		}

		JsonUtils.write(allAuthLists, ServletActionContext.getResponse()
				.getWriter(), getExcludes(), getDatePattern());
	}

	public void setRoleId(Long roleId) {
		this.roleId = roleId;
	}

	public void setAuth(boolean auth) {
		this.auth = auth;
	}

	/**
	 * 授权与撤消授权.
	 *
	 * @throws Exception 异常
	 */
	public void authResc() throws Exception {
		//	    	 System.out.println("ttttttttttttttttttttttttttttttttttttttttttttt  authResc");
		//	    	 Enumeration<String> keys = getRequest().getParameterNames();
		//		 		while (keys.hasMoreElements()) {
		//		 			String key = keys.nextElement();
		//		 			String value = getRequest().getParameter(key);
		//		 			System.out.println(key + " value=" + value);
		//
		//		 		}

		//	        Role role = roleManager.get(roleId);
		//	        Resc resc = rescManager.get(authId);
		int count = ssRoleManager.getCountRoleAuthority(roleId, authId);
		//  System.out.println("99999999999999999999999999"+count + " value=" + count);
		if (auth) {
			if (count < 1) {
				ssRoleManager.insertRoleAuthority(roleId, authId);
			}
		} else {
			if (count > 0) {
				ssRoleManager.removeroleAuthority(roleId, authId);
			}
		}

		refreshAuthority();
		ServletActionContext.getResponse().getWriter().print("{success:true}");
	}

	//递归创建菜单树
	private Menu creatMenuTree(Menu parentMenu, List<Menu> roleMenuList,
			Long parentId, boolean AllowChildren) {

		if (AllowChildren) {
			List<Menu> childList = ssMenuManager
					.findCheckboxTreeByParentId(parentId);// sub children
			parentMenu.setChildren(new LinkedHashSet<Menu>(childList));// 节点
			if (childList != null) {
				for (Menu childMenu : childList) {
					Long childId = childMenu.getId();
					boolean childAllowChildren = childMenu.getAllowChildren();
					if (roleMenuList != null) {
						for (Menu roleMenu : roleMenuList) {
							Long roleMenuId = roleMenu.getId();
							if (childId.equals(roleMenuId)) {
								childMenu.setChecked(true);
							}
						}
					}
					creatMenuTree(childMenu, roleMenuList, childId,
							childAllowChildren);
				}
			}
		}
		return parentMenu;
	}

	/**
	 * 显示指定角色下可显示的菜单.
	 *
	 * @throws Exception 写入writer的时候，抛出异常
	 */
	public void getMenus() throws Exception {


		//
		//	          // 因为只有两级菜单，所以这里只需要写两个循环就可以判断哪些菜单被选中了
		//	          // 不考虑多级情况，只从最直接的角度考虑
		ssRole = (SsRole)ssRoleManager.getById(roleId);
		
		List<Menu> roleMenuList = ssMenuManager.findAllByRoleID(roleId);
		
		List<Menu> parentList = ssMenuManager.findRootCheckboxTree(ssRole.getBusinesscode());// 最顶层父节点

		if (parentList != null) {
			for (Menu parentMenu : parentList) {
				Long parentId = parentMenu.getId();
				boolean AllowChildren = parentMenu.getAllowChildren(); //true 父 false leaf
				if (roleMenuList != null) {
					for (Menu roleMenu : roleMenuList) {
						Long roleMenuId = roleMenu.getId();
						if (parentId.equals(roleMenuId)) {
							parentMenu.setChecked(true);
						}
					}
				}
				parentMenu = creatMenuTree(parentMenu, roleMenuList, parentId,
						AllowChildren);

			}
		}

		// 现在checkbox tree的问题是无法在js里设置根节点，必须在json里做一个根节点
		// 如果不设置根节点，getChecked()方法返回的只有第一棵树的数据，疑惑中。
		// 为了他的限制，多写了下面这么多代码，真郁闷

		Menu root = new Menu();
		root.setId(0L);
		root.setName("选择菜单");
		root.setChildren(new LinkedHashSet<Menu>(parentList));
		root.setChecked(true);

		Menu[] menus = new Menu[] { root };

		JsonUtils.write(menus, ServletActionContext.getResponse().getWriter(),
				getExcludes(), getDatePattern());
	}

	/**
	 * 选择角色对应的菜单.
	 *
	 * @throws Exception 写入response可能抛出异常吧？
	 */
	public void selectMenu() throws Exception {
		
		Enumeration<String> keys = getRequest().getParameterNames();
		while (keys.hasMoreElements()) {
			String key = keys.nextElement();
			String value = getRequest().getParameter(key);


		}
		String str_roleID = (String) getRequest().getParameter("roleId");

		java.lang.Long bd_roleid = new java.lang.Long(str_roleID);
		SsRole role = (SsRole) ssRoleManager.getById(bd_roleid);
		if (role == null) {

			ServletActionContext.getResponse().getWriter().print(
					"{success:false}");
			return;
		}
        //删除原来的分配菜单
		ssRoleManager.removeroleMenu(roleId);
		
		StringBuffer idsb = new StringBuffer(200);
		
		if(ids != null && !"".equals(ids)){
			String[] id = ids.split(",");
			if (id != null) {
				for (int i = 0; i < id.length; i++) {
	
					boolean isNunicodeDigits = StringUtils.isNumeric(id[i]);
					if (isNunicodeDigits) {
						//idsb.append("'");
						idsb.append(id[i]);
						//idsb.append("'");
						if (i != id.length - 1)
							idsb.append(",");
					}
				}
			}
	
			List<Menu> selectList = ssMenuManager.findSelectMenu(idsb.toString());
	
			if (selectList != null) {
				for (Menu selmenu : selectList) {
					try {
						long menuid = selmenu.getId();
	
						ssRoleManager.insertRoleMenu(roleId, menuid);
	
					} catch (Exception ex) {
	
					}
				}
			}
		}
		
		ServletActionContext.getResponse().getWriter().print("{success:true}");
	}

	public String getTrees() throws Exception {

		HttpServletRequest request = ServletActionContext.getRequest();
		String strParentId = "";
		if (request.getParameter("parentId") != null)
			strParentId = request.getParameter("parentId");



		int session_userid = 1;
		SecurityContext sc = SecurityContextHolder.getContext();
		Authentication auth = sc.getAuthentication();
		MyUserDetails ud = null;
		if ((auth != null) && auth.getPrincipal() instanceof MyUserDetails) {
			ud = (MyUserDetails) auth.getPrincipal();
			if (ud != null) {
				session_userid = ud.getUserId();
			}
		}
		
		List<JSONTreeNode> treeNodeArray = null;
		
		//List<DictItem> itemList = DictHelpImpl.getDict("T_ITEM_BUSSINESS");
		//List<SsRole>  roleList = ssRoleManager.findByParentId(new Long(2));
		List<SsRole>  roleList = ssRoleManager.findByRoleType();
		
		treeNodeArray = new ArrayList<JSONTreeNode>();
		if( roleList != null && roleList.size() > 0){
			for (SsRole item : roleList) {
	
				JSONTreeNode treeNode = new JSONTreeNode();				
				
				//String typeid = item.getRoleid().toString();
				String typeid = item.getBusinesscode();
				String name = item.getRoledesc(); //item.getRolename();
				
				treeNode.setId(typeid);
				treeNode.setText(name);
				treeNode.setDescription(name);
	
				treeNode.setCls("folder");
				treeNode.setLeaf(true);
				treeNode.setExpandable(false);
				
				treeNodeArray.add(treeNode);
			}
		}

		setJsonString(JsonUtils.toJson(treeNodeArray , getMenuExcludes() , getDatePattern()));

		return JSON_JSP;

	}
	
	public String getTrees_backup() throws Exception {

		HttpServletRequest request = ServletActionContext.getRequest();
		String strParentId = "";
		if (request.getParameter("parentId") != null)
			strParentId = request.getParameter("parentId");



		int session_userid = 1;
		SecurityContext sc = SecurityContextHolder.getContext();
		Authentication auth = sc.getAuthentication();
		MyUserDetails ud = null;
		if ((auth != null) && auth.getPrincipal() instanceof MyUserDetails) {
			ud = (MyUserDetails) auth.getPrincipal();
			if (ud != null) {
				session_userid = ud.getUserId();
			}
		}

		java.lang.Long parentId = new java.lang.Long(strParentId);

		List<JSONTreeNode> treeNodeArray = null;
		//查找所有拥有下级部门的的部门ID

		List parentidlist = (List) ssRoleManager.getExistChildDept();

		StringBuffer parentIDBuffer = new StringBuffer();
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
		List<SsRole> list = null;
		if (strParentId != null && strParentId.equals("0")) {
			if (session_userid==1) {
				list = ssRoleManager.findRootTree();
			} else {
				java.lang.Long userId = new java.lang.Long(
						session_userid);
				list = ssRoleManager.findByUserId(userId);
			}

		} else {
			list = ssRoleManager.findByParentId(parentId);
		}
		treeNodeArray = new ArrayList<JSONTreeNode>();

		for (SsRole department : list) {

			JSONTreeNode treeNode = new JSONTreeNode();
			java.lang.Long roleIdValue = department.getRoleid();
			Long l_roleid = roleIdValue.longValue();
			String s_roleid = roleIdValue.toString();
			String name = department.getRoledesc();
			String desc = department.getRolename();
			treeNode.setId(s_roleid);
			treeNode.setText(name);
			treeNode.setDescription(desc);

			if (parentIDString.indexOf("|" + s_roleid + "|") >= 0) // 父节点
			{
				treeNode.setCls("folder");
				treeNode.setLeaf(false);
				treeNode.setExpandable(false);
			} else // 子节点

			{
				treeNode.setCls("file");
				treeNode.setLeaf(true);
				treeNode.setExpandable(false);
			}
			treeNodeArray.add(treeNode);
		}


		setJsonString(JsonUtils.toJson(treeNodeArray, getMenuExcludes(),
				getDatePattern()));

		return JSON_JSP;

	}

	public String detail() {
		Long depId = Long.parseLong(getRequest().getParameter("depId"));
		java.lang.Long ids = new java.lang.Long(depId);
		SsRole ssRoletmp = (SsRole) ssRoleManager.getById(ids);
		Gson gson = new Gson();
		StringBuffer sb = new StringBuffer("{success:true,data:[");
		sb.append(gson.toJson(ssRoletmp));
		sb.append("]}");
		setJsonString(sb.toString());
		return JSON_JSP;
	}
	/**
	 * 根据行业查询角色节点数据
	 */
   public void findRolesByBussiness() throws Exception{ 
   
		String roleid=getRequest().getParameter("roleId");
//		if(roleid == null || "".equals(roleid)){
//			roleid ="0";
//		}
		int start = getStart();
		int limit = 15;
		int totalCount  = 0;
		int pageNumber = 0;
		
		pageNumber =  start/limit+1;
		
		Page page;
		PageRequest<Map> pageRequest = newPageRequest(DEFAULT_SORT_COLUMNS);	
			
		pageRequest.setPageNumber(pageNumber);
		pageRequest.setPageSize(limit);
		List result = null;

		if(roleid !=null && !"".equals(roleid)){
		   pageRequest.getFilters().put("businesscode",roleid);
		   page = ssRoleManager.findByPageRequest(pageRequest);
		   result = page.getResult();
		   totalCount = page.getTotalCount();
		}
//		if(roleId !=null && !"".equals(roleId)){
//			   pageRequest.getFilters().put("businesscode",roleId);
//			   page = ssRoleManager.findByPageRequest(pageRequest);
//			   result = page.getResult();
//			   totalCount = page.getTotalCount();
//		}
		//ssRoles= page.getResult();	
		//totalCount  = page.getTotalCount();		
		
		javacommon.util.extjs.Page pages = new javacommon.util.extjs.Page(
				result, totalCount);

		JsonUtils.write(pages, ServletActionContext.getResponse().getWriter(),
				getExcludes(), getDatePattern());

	}
	/**
	 * 根据角色id查询角色子节点数据
	 */
   public void findUserByDepartment() throws Exception{ 
   
		String strRoleId=getRequest().getParameter("roleId");
		String roleSEQ=".";
		
		java.lang.Long session_userid=this.getSessionUserId();
		
		if(StringUtils.isNotEmpty(strRoleId)&&!strRoleId.equals("0")){
			java.lang.Long roleId = new java.lang.Long(strRoleId);
			SsRole ssRole = (SsRole)ssRoleManager.getById(roleId);
           if(ssRole!=null){	
        	   roleSEQ=ssRole.getRoleseq();
           }			
		}else{
			if(session_userid!=1){
				java.lang.Long userid = new java.lang.Long(session_userid);
				List<SsRole> list=ssRoleManager.findByUserId(userid);
				SsRole ssRole = (SsRole)list.get(0);
				if(ssRole!=null){
					 roleSEQ=ssRole.getRoleseq();
				}
			}
		}
		
		int start = getStart();
		int limit = 15;
		int totalCount  = 0;
		int pageNumber = 0;
		
		pageNumber =  start/limit+1;
		
		Page page;
		PageRequest<Map> pageRequest = newPageRequest(DEFAULT_SORT_COLUMNS);
		if(".".equals(roleSEQ)){

			pageRequest.setPageNumber(pageNumber);
			pageRequest.setPageSize(limit);
			//pageRequest.getFilters().put("key",value);     
			 page = ssRoleManager.findByPageRequest(pageRequest);
			ssRoles= page.getResult();	
			totalCount  = page.getTotalCount();
		}else{
			
			pageRequest.setPageNumber(pageNumber);
			pageRequest.setPageSize(limit);
			pageRequest.getFilters().put("roleSEQ",roleSEQ);
			 page = ssRoleManager.findByPageRequest(pageRequest);
			ssRoles= page.getResult();	
			totalCount  = page.getTotalCount();
		    
		}

		List result = page.getResult();
		totalCount = page.getTotalCount();
		javacommon.util.extjs.Page pages = new javacommon.util.extjs.Page(
				result, totalCount);

		JsonUtils.write(pages, ServletActionContext.getResponse().getWriter(),
				getExcludes(), getDatePattern());

	}

   
	public String[] getMenuExcludes() {
		return new String[] { "checked", "children", "qtip", "theSort",
				"parent", "allowDelete", "allowEdit", "draggable" };
	}

	public List<SsRole> getRolelist() {
		return rolelist;
	}

	public void setRolelist(List<SsRole> rolelist) {
		this.rolelist = rolelist;
	}

	public List<SsAuthority> getAuthList() {
		return authList;
	}

	public void setAuthList(List<SsAuthority> authList) {
		this.authList = authList;
	}

	public List<SsMenu> getMenuList() {
		return menuList;
	}

	public void setMenuList(List<SsMenu> menuList) {
		this.menuList = menuList;
	}

	public long getAuthId() {
		return authId;
	}

	public void setAuthId(long authId) {
		this.authId = authId;
	}

	private static void refreshAuthority() throws IOException {

		try {
			ApplicationContext ctx = WebApplicationContextUtils
					.getWebApplicationContext(ServletActionContext
							.getServletContext());
			FactoryBean factoryBean = (FactoryBean) ctx
					.getBean("&filterInvocationDefinitionSource");
			FilterInvocationDefinitionSource fids = (FilterInvocationDefinitionSource) factoryBean
					.getObject();
			FilterSecurityInterceptor filter = (FilterSecurityInterceptor) ctx
					.getBean("filterSecurityInterceptor");
			filter.setObjectDefinitionSource(fids);
		} catch (Exception e) {
			e.printStackTrace();

		}

	}
	public java.lang.Long getSessionUserId(){
		java.lang.Long session_userid=1L;
		SecurityContext sc = SecurityContextHolder.getContext();
		Authentication auth = sc.getAuthentication();
		MyUserDetails ud = null;
		if ((auth != null) && auth.getPrincipal() instanceof MyUserDetails) {
			ud = (MyUserDetails) auth.getPrincipal();
			if (ud != null) {
				session_userid = new java.lang.Long(ud.getUserId());
			}
		}
		return session_userid;
	}

	public List<SsRole> getSsRoles() {
		return ssRoles;
	}

	public void setSsRoles(List<SsRole> ssRoles) {
		this.ssRoles = ssRoles;
	}

	public SsGroupManager getSsGroupManager() {
		return ssGroupManager;
	}

	public void setSsGroupManager(SsGroupManager ssGroupManager) {
		this.ssGroupManager = ssGroupManager;
	}




}
