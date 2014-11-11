/*
 * Powered By [lishicheng]
 */

package com.dyneinfo.fjy.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cn.org.rapid_framework.beanutils.BeanUtils;
import com.opensymphony.xwork2.Preparable;
import com.opensymphony.xwork2.ModelDriven;
import org.apache.struts2.ServletActionContext;

import org.security.userdetails.MyUserDetails;
import net.java.dev.common.util.DateUtil;
import net.java.dev.common.util.SpringTagFunctions;

import java.text.SimpleDateFormat;
import java.util.*;

import javacommon.base.*;
import javacommon.util.*;

import cn.org.rapid_framework.util.*;
import cn.org.rapid_framework.web.util.*;
import cn.org.rapid_framework.page.*;
import cn.org.rapid_framework.page.impl.*;

import com.dyneinfo.fjy.model.*;
import com.dyneinfo.fjy.dao.*;
import com.dyneinfo.fjy.service.*;

/**
 * @author lisc email:lishicheng(a)gmail.com
 */


public class TpoliceCheckAction extends BaseStruts2Action implements Preparable,ModelDriven{
	//默认多列排序,example: username desc,createTime asc
	protected static final String DEFAULT_SORT_COLUMNS = null; 
	
	//forward paths
	protected static final String QUERY_JSP = "/pages/fjy/TpoliceCheck/query.jsp";
	protected static final String LIST_JSP= "/pages/fjy/TpoliceCheck/list.jsp";
	protected static final String CREATE_JSP = "/pages/fjy/TpoliceCheck/create.jsp";
	protected static final String EDIT_JSP = "/pages/fjy/TpoliceCheck/edit.jsp";
	protected static final String SHOW_JSP = "/pages/fjy/TpoliceCheck/show.jsp";
	//redirect paths,startWith: !
	protected static final String LIST_ACTION = "!/pages/fjy/TpoliceCheck/list.do";
	
	protected static final String LISTUSER_JSP= "/pages/fjy/TpoliceCheck/listUser.jsp";
	protected static final String CREATEUSER_JSP = "/pages/fjy/TpoliceCheck/createUser.jsp";
	protected static final String EDITUSER_JSP = "/pages/fjy/TpoliceCheck/editUser.jsp";
	protected static final String SHOWUSER_JSP = "/pages/fjy/TpoliceCheck/showUser.jsp";
	protected static final String TAB_JSP = "/pages/fjy/TpoliceCheck/tab.jsp";
	protected static final String TABUSER_JSP = "/pages/fjy/TpoliceCheck/tabUser.jsp";
	
	private TpoliceCheckManager tpoliceCheckManager;
	
	private TpoliceCheck tpoliceCheck;
	Long id = null;
	private String[] items;
	private String returnUrl;  //返回列表，保留查询条件
	private TreeMap<String, String> dateSelectMap;// //日期选择

	public void prepare() throws Exception {
		if (isNullOrEmptyString(id)) {
			tpoliceCheck = new TpoliceCheck();
		} else {
			tpoliceCheck = (TpoliceCheck)tpoliceCheckManager.getTpoliceCheckById(id);
		}
	}
	
	/** 增加setXXXX()方法,spring就可以通过autowire自动设置对象属性 */
	public void setTpoliceCheckManager(TpoliceCheckManager manager) {
		this.tpoliceCheckManager = manager;
	}	
	
	public Object getModel() {
		return tpoliceCheck;
	}
	
	public void setCheckid(Long val) {
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
		HttpServletRequest request = ServletActionContext.getRequest();

		return QUERY_JSP;
	}
	
	/** 执行搜索 */
	public String list() {
		PageRequest<Map> pageRequest = newPageRequest(DEFAULT_SORT_COLUMNS);
		HttpServletRequest request = ServletActionContext.getRequest();
		//pageRequest.getFilters().put("key",value);     //add custom filter
		

		
		String username = "";
		String deptid = "";
	    String deptseq = "";
		MyUserDetails userDetail = null;
		userDetail = SpringTagFunctions.getUserDetails();
		if (userDetail != null) {
			username = userDetail.getUserName();
			deptid = userDetail.getDeptID();
			deptseq = userDetail.getDeptSeq();
		}
	
		if(SpringTagFunctions.ifAnyGranted("ROLE_QUERY_ALL,ROLE_ADMIN")){
			
		} else if(SpringTagFunctions.ifAnyGranted("ROLE_QUERY_CURRENT_ORG")){
			pageRequest.getFilters().put("deptid",deptid);
		} else if(SpringTagFunctions.ifAnyGranted("ROLE_QUERY_CHILD_ORG")){
			pageRequest.getFilters().put("deptSeq",deptseq);
		} else {
			pageRequest.getFilters().put("deptid",deptid);
		}
		
		
		dateSelectMap  = DateUtil.getDateSelectData();
		String dateSelect4 = "";
		if (request.getParameter("dateSelect4") != null)
		    dateSelect4 = request.getParameter("dateSelect4");
			request.setAttribute("dateSelect4",dateSelect4);		        
		
		Page page = tpoliceCheckManager.findByPageRequest(pageRequest);
		savePage(page,pageRequest);
		return LIST_JSP;
	}
	
	public String listUser() {
		PageRequest<Map> pageRequest = newPageRequest(DEFAULT_SORT_COLUMNS);
		HttpServletRequest request = ServletActionContext.getRequest();
		//pageRequest.getFilters().put("key",value);     //add custom filter
		
		
		String username = "";
		String deptid = "";
	    String deptseq = "";
		MyUserDetails userDetail = null;
		userDetail = SpringTagFunctions.getUserDetails();
		if (userDetail != null) {
			username = userDetail.getUserName();
			deptid = userDetail.getDeptID();
			deptseq = userDetail.getDeptSeq();
		}
	
		if(SpringTagFunctions.ifAnyGranted("ROLE_QUERY_ALL,ROLE_ADMIN")){
			
		} else if(SpringTagFunctions.ifAnyGranted("ROLE_QUERY_CURRENT_ORG")){
			pageRequest.getFilters().put("deptid",deptid);
		} else if(SpringTagFunctions.ifAnyGranted("ROLE_QUERY_CHILD_ORG")){
			pageRequest.getFilters().put("deptSeq",deptseq);
		} else {
			pageRequest.getFilters().put("deptid",deptid);
		}
		String s_deptid = "";
		if (request.getParameter("s_deptid") != null){
			s_deptid = request.getParameter("s_deptid");
			request.setAttribute("s_deptid", s_deptid);	
		    pageRequest.getFilters().put("deptid",s_deptid);
		}
		
		
		dateSelectMap  = DateUtil.getDateSelectData();
		String dateSelect4 = "";
		if (request.getParameter("dateSelect4") != null)
		    dateSelect4 = request.getParameter("dateSelect4");
			request.setAttribute("dateSelect4",dateSelect4);		        
		
		Page page = tpoliceCheckManager.findByPageRequest(pageRequest);
		savePage(page,pageRequest);
		return LISTUSER_JSP;
	}
	
	/** 查看对象*/
	public String show() {
		HttpServletRequest request = ServletActionContext.getRequest();
		return SHOW_JSP;
	}
	
	public String showUser() {
		HttpServletRequest request = ServletActionContext.getRequest();
		return SHOWUSER_JSP;
	}
	
	/** 进入新增页面*/
	public String create() {
		return CREATE_JSP;
	}
	
	public String createUser() {
		Date date = new Date();
		SimpleDateFormat format_inserttime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String str_inserttime = format_inserttime.format(date);
        tpoliceCheck.setChecktimeString(str_inserttime);
        
		
        
		return CREATEUSER_JSP;
	}
	
	/** 保存新增对象 */
	public String save() {
		HttpServletRequest request = ServletActionContext.getRequest();
		tpoliceCheckManager.save(tpoliceCheck);
		return returnUrl;////LIST_ACTION;
	}
	
	public String saveUser() {
		String username = "";
		String deptid = "";
		MyUserDetails userDetail = null;
		userDetail = SpringTagFunctions.getUserDetails();
		if (userDetail != null) {
			username = userDetail.getUserName();
			deptid = userDetail.getDeptID();
		}
		
		tpoliceCheck.setDeptid(Long.parseLong(deptid));
		tpoliceCheckManager.save(tpoliceCheck);
		return returnUrl;////LIST_ACTION;
	}
	
	/**进入更新页面*/
	public String edit() {
		HttpServletRequest request = ServletActionContext.getRequest();
		return EDIT_JSP;
	}
	
	public String editUser() {
		HttpServletRequest request = ServletActionContext.getRequest();
		return EDITUSER_JSP;
	}
	
	/**保存更新对象*/
	public String update() {
		HttpServletRequest request = ServletActionContext.getRequest();
		tpoliceCheckManager.update(this.tpoliceCheck);
		return returnUrl;////LIST_ACTION;
	}
	
	/**删除对象*/
	public String delete() {
		for(int i = 0; i < items.length; i++) {
			Hashtable params = HttpUtils.parseQueryString(items[i]);
			Long id = new Long((String)params.get("checkid"));
			tpoliceCheckManager.removeById(id);
		}
		return returnUrl ;//LIST_ACTION;
	}
	
	public String tab() {
		return TAB_JSP;
	}
	public String tabUser() {
		return TABUSER_JSP;
	}
	

}
