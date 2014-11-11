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


public class TelxsAction extends BaseStruts2Action implements Preparable,ModelDriven{
	//默认多列排序,example: username desc,createTime asc
	protected static final String DEFAULT_SORT_COLUMNS = null; 
	
	//forward paths
	protected static final String QUERY_JSP = "/pages/fjy/Telxs/query.jsp";
	protected static final String LIST_JSP= "/pages/fjy/Telxs/list.jsp";
	protected static final String CREATE_JSP = "/pages/fjy/Telxs/create.jsp";
	protected static final String EDIT_JSP = "/pages/fjy/Telxs/edit.jsp";
	protected static final String SHOW_JSP = "/pages/fjy/Telxs/show.jsp";
	protected static final String TAB_JSP = "/pages/fjy/Telxs/tab.jsp";
	protected static final String TABSHOW_JSP = "/pages/fjy/Telxs/tabshow.jsp";
	//redirect paths,startWith: !
	protected static final String LIST_ACTION = "!/pages/fjy/Telxs/list.do";
	
	private TelxsManager telxsManager;
	
	private Telxs telxs;
	java.lang.String id = null;
	private String[] items;
	private String returnUrl;  //返回列表，保留查询条件
	private TreeMap<String, String> dateSelectMap;// //日期选择

	public void prepare() throws Exception {
		if (isNullOrEmptyString(id)) {
			telxs = new Telxs();
		} else {
			telxs = (Telxs)telxsManager.getById(id);
		}
	}
	
	/** 增加setXXXX()方法,spring就可以通过autowire自动设置对象属性 */
	public void setTelxsManager(TelxsManager manager) {
		this.telxsManager = manager;
	}	
	
	public Object getModel() {
		return telxs;
	}
	
	public void setTelinfoid(java.lang.String val) {
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
		String telinfoids = "";
		if (request.getParameter("telinfoids") != null)
			telinfoids = request.getParameter("telinfoids");
		request.setAttribute("telinfoids",telinfoids);
		telxs.setTelinfoid(telinfoids);
		
		String username = "";
		MyUserDetails userDetail = null;
		userDetail = SpringTagFunctions.getUserDetails();
		if (userDetail != null) {
			username = userDetail.getUsername();
		}
		telxs.setJbr(username);
		telxsManager.save(telxs);
		request.setAttribute("message", "保存成功"); 
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
		telxsManager.update(this.telxs);
		request.setAttribute("message", "保存成功"); 
		return returnUrl;////LIST_ACTION;
	}
	
	public String tab() {
		HttpServletRequest request = ServletActionContext.getRequest();
		String telinfoids = "";
		if (request.getParameter("telinfoids") != null)
			telinfoids = request.getParameter("telinfoids");
		request.setAttribute("telinfoids",telinfoids);
		return TAB_JSP;
	}
	
	
	public String tabshow() {
		HttpServletRequest request = ServletActionContext.getRequest();
		String telinfoids = "";
		if (request.getParameter("telinfoids") != null)
			telinfoids = request.getParameter("telinfoids");
		request.setAttribute("telinfoids",telinfoids);
		return TABSHOW_JSP;
	}
	
	

	
	public String xslist() {
		HttpServletRequest request = ServletActionContext.getRequest();
		String telinfoids = "",flag="";
		if (request.getParameter("telinfoids") != null)
			telinfoids = request.getParameter("telinfoids");
		if (request.getParameter("flag") != null)
			flag = request.getParameter("flag");
		request.setAttribute("telinfoids",telinfoids);
		
		int count = telxsManager.getCountT_ESDNXS(telinfoids);
		if(count <1){
			return CREATE_JSP;
		} else {
			telxs = (Telxs)telxsManager.getById(telinfoids);
			if(flag != null && flag.equals("1"))
			request.setAttribute("message", "保存成功"); 
		return EDIT_JSP;
		}
	}

}
