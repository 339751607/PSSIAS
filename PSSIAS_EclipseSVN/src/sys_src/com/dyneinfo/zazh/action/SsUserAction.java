/*
 * Powered By []
 * Web Site: 
 * 
 */

package com.dyneinfo.zazh.action;

import static javacommon.util.extjs.Struts2JsonHelper.configJson;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Date;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javacommon.base.BaseStruts2Action;
import javacommon.util.CipherUtil;
import javacommon.util.extjs.JsonUtils;

import javax.servlet.http.HttpServletRequest;

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
import cn.org.rapid_framework.web.util.HttpUtils;

import com.dyneinfo.zazh.model.SsDept;
import com.dyneinfo.zazh.model.SsGroup;
import com.dyneinfo.zazh.model.SsRole;
import com.dyneinfo.zazh.model.SsUser;
import com.dyneinfo.zazh.service.SsDeptManager;
import com.dyneinfo.zazh.service.SsRoleManager;
import com.dyneinfo.zazh.service.SsUserManager;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.opensymphony.xwork2.ModelDriven;
import com.opensymphony.xwork2.Preparable;

/**
 * @author  email: lee(a)gmail.com
 * @version 1.0
 * @since 1.0
 */


public class SsUserAction extends BaseStruts2Action implements Preparable,ModelDriven{
	//默认多列排序,example: username desc,createTime asc
	protected static final String DEFAULT_SORT_COLUMNS = "deptid"; 
	
	//forward paths
	protected static final String QUERY_JSP = "/pages/SsUser/query.jsp";
	protected static final String LIST_JSP= "/pages/SsUser/list.jsp";
	protected static final String CREATE_JSP = "/pages/SsUser/create.jsp";
	protected static final String EDIT_JSP = "/pages/SsUser/edit.jsp";
	protected static final String SHOW_JSP = "/pages/SsUser/show.jsp";
	//redirect paths,startWith: !
	protected static final String LIST_ACTION = "!/pages/SsUser/list.do";
	protected static final String JSON_JSP = "/commons/jsonStruts.jsp";
	
	protected static final String UPDPASSWORD = "/pages/SsUser/updpass.jsp";
	
	private SsUserManager ssUserManager;
	private SsDeptManager ssDeptManager;
	private SsRoleManager ssRoleManager;
	CipherUtil cipher = new CipherUtil();
	private SsUser ssUser;
	java.lang.Long id = null;
	private String[] items;
	
	
	private Long userId;
	
	private Long deptId;
	
	private Long roleId;

	

	public Long getRoleId() {
		return roleId;
	}

	public void setRoleId(Long roleId) {
		this.roleId = roleId;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}
	
	public Long getDeptId() {
		return deptId;
	}

	public void setDeptId(Long deptId) {
		this.deptId = deptId;
	}

	public void prepare() throws Exception {
		if (isNullOrEmptyString(id)) {
			ssUser = new SsUser();
		} else {
			ssUser = (SsUser)ssUserManager.getById(id);
		}
	}
	
	/** 增加setXXXX()方法,spring就可以通过autowire自动设置对象属性 */
	public void setSsUserManager(SsUserManager manager) {
		this.ssUserManager = manager;
	}	
	
	public void setSsDeptManager(SsDeptManager manager) {
		this.ssDeptManager = manager;
	}	
	
	public Object getModel() {
		return ssUser;
	}
	
	public void setUserid(java.lang.Long val) {
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
		
		Page page = ssUserManager.findByPageRequest(pageRequest);
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
		ssUser.setCreateuserid(this.getSessionUserId());
		ssUser.setPassword(cipher.generatePassword(ssUser.getPassword()));
		ssUserManager.save(ssUser);
		return LIST_ACTION;
	}
	
	/**进入更新页面*/
	public String edit() {
		return EDIT_JSP;
	}
	
	/**保存更新对象*/
	public String update() {
		ssUser.setCreateuserid(this.getSessionUserId());
		ssUserManager.update(this.ssUser);
		return LIST_ACTION;
	}
	
	/**删除对象*/
	public String delete() {
		for(int i = 0; i < items.length; i++) {
			Hashtable params = HttpUtils.parseQueryString(items[i]);
			java.lang.Long id = new java.lang.Long((String)params.get("userid"));
			ssUserManager.removeById(id);
		}
		return LIST_ACTION;
	}
	
	
	
	
	
	public String extjslist() throws Exception {	
		
		
		
		java.lang.Long session_userid=this.getSessionUserId();

		java.lang.Long roleId=1L;

		int start = getStart();
		int limit = getLimit();
		int totalCount  = 0;
		int pageNumber = 0;
		
		pageNumber = start / limit + 1;
		
		//System.out.println(deptSEQ +"00"+session_deptid);

		PageRequest<Map> pageRequest = newPageRequest(DEFAULT_SORT_COLUMNS);
		pageRequest.setPageNumber(pageNumber);
		pageRequest.setPageSize(limit);
		//pageRequest.getFilters().put("createuserid",session_userid);
		
		//获取deptid
		String session_deptid="";
		String session_username ="";
		SecurityContext sc = SecurityContextHolder.getContext();
		Authentication auth = sc.getAuthentication();
		MyUserDetails ud = null;
		if ((auth != null) && auth.getPrincipal() instanceof MyUserDetails) {
			ud = (MyUserDetails) auth.getPrincipal();
			if (ud != null) {
				session_deptid = ud.getDeptID();
				session_username = ud.getUsername();
			}
		}
		
		pageRequest.getFilters().put("deptid",session_deptid);
		//Page page = ssUserManager.findUserByCreateuseridRequest(pageRequest);
		Page page=ssUserManager.findUserByDeptSeqRequestTwo(pageRequest);
		List<SsUser> list = page.getResult();
		for(int i=0;i<list.size();i++){  
			SsUser ssuser = new SsUser();
			ssuser = list.get(i);
			if(session_username.indexOf("C02") !=-1 ){
				if(ssuser.getUsername().equals(session_username)){
					ssuser.setSfxsdel("1");
				}else{
					ssuser.setSfxsdel("0");
				}
			}else{
				ssuser.setSfxsdel("1");
			}
		}
		totalCount = page.getTotalCount();
		this.setTotalCount(totalCount);


		StringBuffer buff = new StringBuffer("{success:true,'totalCounts':")
		.append(this.getTotalCount() ).append(",");	
		buff.append("result:");
		buff.append(JsonUtils.toJson(list,
	             getExcludes(),
		            getDatePattern()));
		buff.append("}");	
		
		System.out.println(buff.toString());
	this.setJsonString(buff.toString());
		
		
		
					
		return JSON_JSP;
	}
	
	
	/**
	 * 根据部门查找列表
	 */
    public String select() throws Exception{ 
    	
		String strDepId=getRequest().getParameter("depId");
		List<SsUser> list=new ArrayList<SsUser>();

        String deptSEQ=".";
		
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
		
	
		
		if(StringUtils.isNotEmpty(strDepId)){
			//java.lang.Long depId = new java.lang.Long(strDepId);
			SsDept ssDept = (SsDept)ssDeptManager.getById(strDepId);
           if(ssDept!=null){	
        	   deptSEQ=ssDept.getDeptseq();
           }			
		}else{
			if(StringUtils.isNotEmpty(session_deptid)){
			//java.lang.Long depId = new java.lang.Long(session_deptid);
			SsDept ssDept = (SsDept)ssDeptManager.getById(session_deptid);
           if(ssDept!=null){	
        	   deptSEQ=ssDept.getDeptseq();
           }
			}
		}
		
		
		int start = getStart();
		int limit = getLimit();
		int totalCount  = 0;
		int pageNumber = 0;
		pageNumber =  start/limit+1;
		
		if(".".equals(deptSEQ)){
			PageRequest<Map> pageRequest = newPageRequest(DEFAULT_SORT_COLUMNS);
			pageRequest.setPageNumber(pageNumber);
			pageRequest.setPageSize(limit);
			//pageRequest.getFilters().put("key",value);     
			Page page = ssUserManager.findUserByDeptSeqRequest(pageRequest);
			list=page.getResult();	
			totalCount  = page.getTotalCount();
		}else{
			PageRequest<Map> pageRequest = newPageRequest(DEFAULT_SORT_COLUMNS);
			pageRequest.setPageNumber(pageNumber);
			pageRequest.setPageSize(limit);
			pageRequest.getFilters().put("deptSEQ",deptSEQ);     
			Page page = ssUserManager.findUserByDeptSeqRequest(pageRequest);
			list=page.getResult();	
			totalCount  = page.getTotalCount();
		    
		}
		this.setTotalCount(totalCount);
		
		
		//Type type=new TypeToken<List<SsUser>>(){}.getType();
		StringBuffer buff = new StringBuffer("{success:true,'totalCounts':")
		.append(totalCount).append(",result:");		
		//Gson gson=new Gson();
		//buff.append(gson.toJson(list, type));
		buff.append(JsonUtils.toJson(list,
	             getExcludes(),
		            getDatePattern()));
		buff.append("}");
		
	
		this.setJsonString(buff.toString());
		
		return JSON_JSP;
	}
   
    
	/**
	 * 
	 * 根据角色查询
	 */
	public String find() {
		String strRoleId = getRequest().getParameter("roleId");
		if (StringUtils.isNotEmpty(strRoleId)) {
			// List<SsUser>
			// userList=appUserService.findByRole(Long.parseLong(strRoleId),
			// pb);

			int start = getStart();
			int limit = getLimit();
			int totalCount = 0;
			int pageNumber = 0;
			pageNumber = start / limit + 1;

			PageRequest<Map> pageRequest = newPageRequest(DEFAULT_SORT_COLUMNS);
			pageRequest.setPageNumber(pageNumber);
			pageRequest.setPageSize(limit);
			pageRequest.getFilters().put("roleid", strRoleId);
			Page page = ssUserManager.findUserByRoleRequest(pageRequest);
			List<SsUser> userList = page.getResult();
			totalCount = page.getTotalCount();

			Type type = new TypeToken<List<SsUser>>() {}.getType();
			StringBuffer buff = new StringBuffer("{success:true,'totalCounts':")
					.append(totalCount).append(",result:");
			Gson gson = new Gson();
			buff.append(gson.toJson(userList, type));
			buff.append("}");
			System.out.println(buff.toString());
			this.setJsonString(buff.toString());

		} else {
			this.setJsonString("{success:false}");

		}
		return JSON_JSP;
	}
	

	/**
	 * 批量删除
	 * 
	 * @return
	 */
	public String multiDel(){
		
		String[]ids=getRequest().getParameterValues("ids");
		if(ids!=null){
			for(String id:ids){
				java.lang.Long bd_id = new java.lang.Long(id);
				
				ssUserManager.removeroleUser(bd_id);//删除用户角色
				ssUserManager.removeById(bd_id);
			}
		}
		
		
		this.setJsonString("{success:true}");
		return SUCCESS;
	}
	
	
	public String extjsremoveGroupUser() {
		
		Enumeration<String> keys = getRequest().getParameterNames();
		while (keys.hasMoreElements()) {
			String key = keys.nextElement();
			String value = getRequest().getParameter(key);
			System.out.println(key + " extjsremove value=" + value);

		}

		java.lang.Long bd_id = new java.lang.Long(userId);
		ssUserManager.removeGroupUser(bd_id);//删除用户的工作组
		ssUserManager.removeById(bd_id);//删除用户

		this.setJsonString("{success:true}");
		return JSON_JSP;
	}
	public String extjsremove() {
		
		Enumeration<String> keys = getRequest().getParameterNames();
		while (keys.hasMoreElements()) {
			String key = keys.nextElement();
			String value = getRequest().getParameter(key);
			System.out.println(key + " extjsremove value=" + value);

		}

		java.lang.Long bd_id = new java.lang.Long(userId);
		ssUserManager.removeroleUser(bd_id);//删除用户角色
		ssUserManager.removeById(bd_id);//删除用户

		this.setJsonString("{success:true}");
		return JSON_JSP;
	}
	public String extjspassword() {
		
		Enumeration<String> keys = getRequest().getParameterNames();
		while (keys.hasMoreElements()) {
			String key = keys.nextElement();
			String value = getRequest().getParameter(key);
			System.out.println(key + " extjsremove value=" + value);

		}

		java.lang.Long bd_id = new java.lang.Long(userId);
		ssUserManager.editpasswrod(bd_id);
		

		this.setJsonString("{success:true}");
		return JSON_JSP;
	}
	
	
	/**
	 * 显示详细信息
	 * 
	 * @return
	 */
	public String get() throws Exception{
	
		
		java.lang.Long bd_userId = new java.lang.Long(userId);
		SsUser ssUsertmp = (SsUser)ssUserManager.getById(bd_userId);
		
		String bd_deptid = ssUsertmp.getDeptid();
		SsDept ssDept = (SsDept)ssDeptManager.getById(bd_deptid);
		if(ssDept != null && ssDept.getDeptid() != null)
		{
			System.out.println("get"+ssDept.getDeptid());
		}
		if(ssDept == null){
			ssDept = new SsDept();
			java.lang.String bd_deptId = new java.lang.String("0");
			ssDept.setDeptid(bd_deptId);
		}
			
		ssUsertmp.setDept(ssDept);
		
		//将数据转成JSON格式
//		StringBuffer sb = new StringBuffer("{success:true,totalCounts:1,data:[");
//		sb.append(JsonUtil.getJSONSerializer(new String[]{"accessionTime"}).prettyPrint(ssUser));
//		sb.append("]}");
//		setJsonString(sb.toString());
		
		Gson gson=new Gson();
		StringBuffer sb = new StringBuffer("{success:true,data:[");
		//sb.append(gson.toJson(ssUsertmp));
		
		sb.append(JsonUtils.toJson(ssUsertmp, getExcludes(),
		            getDatePattern()));
		sb.append("]}");
		setJsonString(sb.toString());
		return JSON_JSP;
		
		
	}
	public String getSessionUser() throws Exception{
		
		Long session_userid = 1L;
		String session_uusername=null;
		String expdate=null;
		SecurityContext sc = SecurityContextHolder.getContext();
		Authentication auth = sc.getAuthentication();
		MyUserDetails ud = null;
		if ((auth != null) && auth.getPrincipal() instanceof MyUserDetails) {
			ud = (MyUserDetails) auth.getPrincipal();
			if (ud != null) {
				session_userid = new java.lang.Long(ud.getUserId());
				session_uusername=ud.getUsername();
				expdate=ud.getExpirationDate();
			}
		}
		SsUser sessionUser=new SsUser();
		sessionUser.setUserid(session_userid);
		sessionUser.setUsername(session_uusername);
		
		StringBuffer sb = new StringBuffer("{success:true,\"userid\":")
		.append(session_userid)
		.append(",\"username\":").append("\""+session_uusername+"\"")
		.append(",\"expdate\":").append("\""+expdate+"\"")
		.append("}");
		setJsonString(sb.toString());
		System.out.println(sb.toString());
		return JSON_JSP;
		
	}
	/**
	 * 添加及保存操作
	 */
	public String extjssave() {
		Map<String, Object> result = new HashMap<String, Object>();
		try{
			//System.out.println("88888888888888888888888888888888");
		
		String[] ids = null;
		if (ssUser != null && ssUser.getUserid() != null) {// 保存
			String groupsIds = getRequest().getParameter("AppUserRoles");
			if (groupsIds != null)
				ids = groupsIds.split(",");
			ssUserManager.removeGroupUser(ssUser.getUserid());
			for (String id : ids) {
				if (!"".equals(id)) {
					ssUserManager.insertGroupUser(new Long(id), ssUser.getUserid().longValue());
				}
			}
			ssUserManager.saveOrUpdate(ssUser);
			result.put("success", true);
			result.put("msg", "修改成功!");
		} else {// 增加
			ssUser.setCreateuserid(this.getSessionUserId());
			Date d=new Date();
			java.sql.Date date=new java.sql.Date(d.getTime())  ;
			ssUser.setCreatedate(date);
			// 用户名是否存在
			int usernameCount = ssUserManager.getCountUserName(ssUser.getUsername());
			System.out.println(" usernameCount=" + usernameCount);
			if (usernameCount < 1) {
				String groupIds = getRequest().getParameter("AppUserRoles");
				if (groupIds != null)
					ids = groupIds.split(",");
				ssUser.setPassword(cipher.generatePassword(ssUser.getPassword()));
				ssUserManager.save(ssUser);
				//删除原来的工作组关联信息
				ssUserManager.removeGroupUser(ssUser.getUserid());
				for (String id : ids) {
					if (!"".equals(id)) {
						ssUserManager.insertGroupUser(new Long(id), ssUser.getUserid().longValue());
					}
				}
				result.put("success", true);
				result.put("msg", "增加用户成功!");
			} else {
				result.put("success", true);
				result.put("msg", "用户名在本部门或其它部门中已存在,请更换!");
			}

		}
		} catch(Exception e){
			result.put("failure", true);
			result.put("msg", "保存失败!");
		}
		JsonConfig jsonConfig = configJson("yyyy-MM-dd HH:mm:ss");
		setJsonString(JSONObject.fromObject(result, jsonConfig).toString());
		return JSON_JSP;
	}
	/**
	 * 添加及保存操作
	 */
	public String extjssave_back() {
		Map<String, Object> result = new HashMap<String, Object>();
		try{
			//System.out.println("88888888888888888888888888888888");
		
		String[] ids = null;
		if (ssUser != null && ssUser.getUserid() != null) {// 保存
			String rolesIds = getRequest().getParameter("AppUserRoles");
			if (rolesIds != null)
				ids = rolesIds.split(",");
			ssUserManager.removeroleUser(ssUser.getUserid());
			for (String id : ids) {
				if (!"".equals(id)) {
					ssUserManager.insertRoleUser(new Long(id), ssUser.getUserid().longValue());
				}
			}
			ssUserManager.saveOrUpdate(ssUser);
			result.put("success", true);
			result.put("msg", "修改成功!");
		} else {// 增加
			ssUser.setCreateuserid(this.getSessionUserId());
			Date d=new Date();
			java.sql.Date date=new java.sql.Date(d.getTime())  ;
			ssUser.setCreatedate(date);
			// 用户名是否存在
			int usernameCount = ssUserManager.getCountUserName(ssUser.getUsername());
			System.out.println(" usernameCount=" + usernameCount);
			if (usernameCount < 1) {
				String rolesIds = getRequest().getParameter("AppUserRoles");
				if (rolesIds != null)
					ids = rolesIds.split(",");
				ssUser.setPassword(cipher.generatePassword(ssUser.getPassword()));
				ssUserManager.save(ssUser);
				ssUserManager.removeroleUser(ssUser.getUserid());
				for (String id : ids) {
					if (!"".equals(id)) {
						ssUserManager.insertRoleUser(new Long(id), ssUser.getUserid().longValue());
					}
				}
				result.put("success", true);
				result.put("msg", "增加用户成功!");
			} else {
				result.put("success", true);
				result.put("msg", "用户名在本单位或其它单位中已存在,请更换!");
			}

		}
		} catch(Exception e){
			result.put("failure", true);
			result.put("msg", "保存失败!");
		}
		JsonConfig jsonConfig = configJson("yyyy-MM-dd HH:mm:ss");
		setJsonString(JSONObject.fromObject(result, jsonConfig).toString());
		return JSON_JSP;
	}
	
	/**
	 * 查询已有角色
	 */
	public String selectedRoles()throws Exception {
		if(userId!=null){
			System.out.println("selectedRoles 000000000000="+userId);
			
			//List<SsRole> rolelist = ssUserManager.findUserRole(userId);
			List<SsGroup> Grouplist = ssUserManager.findSelectedGroupByUserId(userId);
			Set<SsGroup> GroupSet = new LinkedHashSet<SsGroup>(Grouplist);
			//Set<AppRole> roles = appUser.getRoles();
			StringBuffer sb = new StringBuffer("[");
			for(SsGroup ssGroup:GroupSet){
				sb.append("['"+ssGroup.getGroupid()+"','"+ssGroup.getGroupdesc()+"'],");
			}
			sb.deleteCharAt(sb.length()-1);
			sb.append("]");
			setJsonString(sb.toString());
		}
		 //ServletActionContext.getResponse().getWriter().print(getJsonString());
		return JSON_JSP;
	}
	/**
	 * 查询可选角色
	 * @return
	 */
	public String chooseRoles() throws Exception {
		//当前登录用户的userid
		Long sessionUserId=getSessionUserId();
		
		//被新增或修改的用户useriid
		if(userId==null)
			userId=0L;		
		
		if (sessionUserId != null) {
			
			//当前登录的用户拥有的工作组信息	
			StringBuffer parentGroup = new StringBuffer("");
			List<SsGroup> loginGroupList = ssUserManager.findSelectedGroupByUserId(sessionUserId);
			if(loginGroupList!=null && loginGroupList.size() > 0){
				for(int i = 0; i < loginGroupList.size(); i++ ){
					SsGroup loginGroup = loginGroupList.get(i);
					parentGroup.append(loginGroup.getGroupid()+",");
				}
				parentGroup.deleteCharAt(parentGroup.length()-1);			
			
				List<SsGroup> ssGrouplist = ssUserManager.findLeftGroupByUserId(userId,parentGroup.toString() );
				Set<SsGroup> ssGroupSet = new LinkedHashSet<SsGroup>(ssGrouplist);
				StringBuffer sb = new StringBuffer("[");
				for (SsGroup ssGroup : ssGroupSet) {
					sb.append("['" + ssGroup.getGroupid() + "','" + ssGroup.getGroupdesc()
							+ "'],");
				}
				sb.deleteCharAt(sb.length() - 1);
				sb.append("]");
				setJsonString(sb.toString());
			}
		}
		//ServletActionContext.getResponse().getWriter().print(getJsonString());
		return JSON_JSP;
	}
	
	/**
	 * 修改密码
	 * @return
	 */
	public String resetPassword(){
		String userId = getRequest().getParameter("appUserUserId");
		String oldPassword = cipher.generatePassword(getRequest().getParameter("oldPassword"));
		String newPassword = getRequest().getParameter("newPassword");
		String againPassword = getRequest().getParameter("againPassword");
		
		
		java.lang.Long bd_userId = new java.lang.Long(userId);
		SsUser ssUsertmp = (SsUser)ssUserManager.getById(bd_userId);
		
		
		StringBuffer msg = new StringBuffer("{msg:'");
		boolean pass = false;
		if(oldPassword.equals(ssUsertmp.getPassword())){
			if(newPassword.equals(againPassword)){
				pass = true;
			}
			else msg.append("两次输入不一致.'");
		}
		else msg.append("旧密码输入不正确.'");
		if(pass){
			ssUsertmp.setPassword( cipher.generatePassword(newPassword));
			ssUserManager.update(ssUsertmp);
			setJsonString("{success:true}");
		}else{
			msg.append(",failure:true}");
			setJsonString(msg.toString());
		}
		return JSON_JSP;
	}
	
	/**
	 * 删除用户照片
	 * @return
	 */
	public String photo(){
		//setAppUser(appUserService.get(getUserId()));
		//appUser.setPhoto("");
		//appUserService.save(appUser);
		
		java.lang.Long bd_userId = new java.lang.Long(userId);
		SsUser ssUsertmp = (SsUser)ssUserManager.getById(bd_userId);
		ssUsertmp.setPhoto("");
		ssUserManager.update(ssUsertmp);
		
		return JSON_JSP;
	}

	
	
	  public String[] getExcludes() {
	        return new String[] {};
	    }

	    public String getDatePattern() {
	        return "yyyy-MM-dd";
	    }
	    
	    
	    
	    
	    
	    /** 修改密码*/
		public String changepwd() {
			return UPDPASSWORD;
		}
		
		
		public String changepwdSave() {
			SecurityContext sc = SecurityContextHolder.getContext();
	        Authentication auth = sc.getAuthentication();
	        
	        HttpServletRequest request = ServletActionContext.getRequest();
			MyUserDetails ud = null;
			
			String oldpass = "";
			if (request.getParameter("oldpass") != null) {
				oldpass = request.getParameter("oldpass");
				oldpass= cipher.generatePassword(oldpass.trim());
			}
			
			String newpass = "";
			if (request.getParameter("newpass") != null) {
				
				newpass= cipher.generatePassword(request.getParameter("newpass"));
			}

			String username = "";
			if ((auth != null) && auth.getPrincipal() instanceof MyUserDetails) {
				ud = (MyUserDetails) auth.getPrincipal();
				if (ud != null) {
					username = ud.getUsername();
				}
			}
			SsUser	thotelBsUser2 = ssUserManager.getByUsername(username);
			String password = thotelBsUser2.getPassword();
			if(password != null && password.length() > 0 && oldpass != null && oldpass.length() > 0){
				if(password.equals(oldpass)){
					 
					ssUserManager.updatePasswd(username, newpass);
					 request.setAttribute("message", "修改密码成功");
				} else{
					 request.setAttribute("message", "原密码不正确！");
				}
			}
			
			return UPDPASSWORD;
		}
		
		
		
		
		public String extjslist4Hotel() throws Exception {	
			
			
			
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
			String searchDeptID="&&&&";
			
			if (StringUtils.isNotEmpty(session_deptid)) {
				searchDeptID = session_deptid;
				
			}
			
			
			int start = getStart();
			int limit = getLimit();
			int totalCount  = 0;
			int pageNumber = 0;
			
			pageNumber = start / limit + 1;
			
			PageRequest<Map> pageRequest = newPageRequest(DEFAULT_SORT_COLUMNS);
			pageRequest.setPageNumber(pageNumber);
			pageRequest.setPageSize(limit);
			if (StringUtils.isNotEmpty(searchDeptID) && !searchDeptID.equals("0")) {
				pageRequest.getFilters().put("deptSEQ",searchDeptID);
			} else {
			
			}
			Page page = ssUserManager.findUserByDeptRequest4Hotel(pageRequest);
			List<SsUser> list = page.getResult();
			totalCount = page.getTotalCount();
			this.setTotalCount(totalCount);

			
		
			
			StringBuffer buff = new StringBuffer("{success:true,'totalCounts':")
			.append(this.getTotalCount() ).append(",result:");		
			buff.append(JsonUtils.toJson(list,
		             getExcludes(),
			            getDatePattern()));
			buff.append("}");	
			
			System.out.println(buff.toString());
			
			
			
		this.setJsonString(buff.toString());
			
			
			
						
			return JSON_JSP;
		}
		
		
		public Long getSessionUserId(){
			Long session_userid = 1L;
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

		public void setSsRoleManager(SsRoleManager ssRoleManager) {
			this.ssRoleManager = ssRoleManager;
		}
		
		

}
