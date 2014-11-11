/*
 * Powered By [lishicheng]
 */

package com.dyneinfo.zazh.action;

import java.util.Hashtable;
import java.util.Map;
import java.util.TreeMap;

import javacommon.base.BaseStruts2Action;

import javax.servlet.http.HttpServletRequest;

import net.java.dev.common.util.DateUtil;
import net.java.dev.common.util.SpringTagFunctions;

import org.apache.struts2.ServletActionContext;
import org.security.userdetails.MyUserDetails;

import cn.org.rapid_framework.page.Page;
import cn.org.rapid_framework.page.PageRequest;
import cn.org.rapid_framework.web.util.HttpUtils;

import com.dyneinfo.zazh.model.LoginHistory;
import com.dyneinfo.zazh.service.LoginHistoryManager;
import com.opensymphony.xwork2.ModelDriven;
import com.opensymphony.xwork2.Preparable;

/**
 * @author lisc email:lishicheng(a)gmail.com
 */


public class LoginHistoryAction extends BaseStruts2Action implements Preparable,ModelDriven{
	//默认多列排序,example: username desc,createTime asc
	protected static final String DEFAULT_SORT_COLUMNS = null; 
	
	//forward paths
	protected static final String QUERY_JSP = "/pages/LoginHistory/query.jsp";
	protected static final String LIST_JSP= "/pages/LoginHistory/list.jsp";
	protected static final String CREATE_JSP = "/pages/LoginHistory/create.jsp";
	protected static final String EDIT_JSP = "/pages/LoginHistory/edit.jsp";
	protected static final String SHOW_JSP = "/pages/LoginHistory/show.jsp";
	//redirect paths,startWith: !
	protected static final String LIST_ACTION = "!/pages/LoginHistory/list.do";
	
	private LoginHistoryManager loginHistoryManager;
	
	private LoginHistory loginHistory;
	Long id = null;
	private String[] items;
	private String returnUrl;  //返回列表，保留查询条件
	private TreeMap<String, String> dateSelectMap;// //日期选择

	public void prepare() throws Exception {
		if (isNullOrEmptyString(id)) {
			loginHistory = new LoginHistory();
		} else {
			loginHistory = (LoginHistory)loginHistoryManager.getById(id);
		}
	}
	
	/** 增加setXXXX()方法,spring就可以通过autowire自动设置对象属性 */
	public void setLoginHistoryManager(LoginHistoryManager manager) {
		this.loginHistoryManager = manager;
	}	
	
	public Object getModel() {
		return loginHistory;
	}
	
	public void setLoginid(Long val) {
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
		
        
		String username = "";
		String deptid = "";
		MyUserDetails userDetail = null;
		userDetail = SpringTagFunctions.getUserDetails();
		if (userDetail != null) {
			username = userDetail.getUserName();
			deptid = userDetail.getDeptID();
		}
		
		if(!SpringTagFunctions.ifAnyGranted("ROLE_HT_ADMIN,ROLE_ADMIN")){
			pageRequest.getFilters().put("deptid",deptid);
			pageRequest.getFilters().put("deptLength",deptid.length());
		}
		
		dateSelectMap  = DateUtil.getDateSelectData();
		String dateSelect0 = "";
		if (request.getParameter("dateSelect0") != null)
		    dateSelect0 = request.getParameter("dateSelect0");
			request.setAttribute("dateSelect0",dateSelect0);	
			java.text.SimpleDateFormat df = new java.text.SimpleDateFormat("");
		String logintimeBeginFormat = request.getParameter("s_logintimeBegin");
		String logintimeEndFormat =  request.getParameter("s_logintimeEnd");
		if(logintimeBeginFormat!=null){
			pageRequest.getFilters().put("ltimeBegin",logintimeBeginFormat);
		}
		if(logintimeBeginFormat!=null){
			pageRequest.getFilters().put("ltimeEnd",logintimeEndFormat);
		}
		Page page = loginHistoryManager.findByPageRequest(pageRequest);
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
		loginHistoryManager.save(loginHistory);
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
		loginHistoryManager.update(this.loginHistory);
		return returnUrl;////LIST_ACTION;
	}
	
	/**删除对象*/
	public String delete() {
		for(int i = 0; i < items.length; i++) {
			Hashtable params = HttpUtils.parseQueryString(items[i]);
			Long id = new Long((String)params.get("loginid"));
			loginHistoryManager.removeById(id);
		}
		return returnUrl ;//LIST_ACTION;
	}

}
