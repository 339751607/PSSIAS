/*
 * Powered By [lishicheng]
 */

package com.dyneinfo.jxy.action;

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
import java.text.SimpleDateFormat;
import net.java.dev.common.util.DateUtil;
import org.apache.struts2.ServletActionContext;

import java.util.*;

import javacommon.base.*;
import javacommon.util.*;

import cn.org.rapid_framework.util.*;
import cn.org.rapid_framework.web.util.*;
import cn.org.rapid_framework.page.*;
import cn.org.rapid_framework.page.impl.*;

import com.dyneinfo.jxy.dao.*;
import com.dyneinfo.jxy.model.*;
import com.dyneinfo.jxy.service.*;

/**
 * @author lisc email:lishicheng(a)gmail.com
 */


public class VupdatacountAction extends BaseStruts2Action implements Preparable,ModelDriven{
	//默认多列排序,example: username desc,createTime asc
	protected static final String DEFAULT_SORT_COLUMNS = null; 
	
	//forward paths
	protected static final String QUERY_JSP = "/pages/jxy/Vupdatacount/query.jsp";
	protected static final String LIST_JSP= "/pages/jxy/Vupdatacount/list.jsp";
	protected static final String CREATE_JSP = "/pages/jxy/Vupdatacount/create.jsp";
	protected static final String EDIT_JSP = "/pages/jxy/Vupdatacount/edit.jsp";
	protected static final String SHOW_JSP = "/pages/jxy/Vupdatacount/show.jsp";
	//redirect paths,startWith: !
	protected static final String LIST_ACTION = "!/jxy/Vupdatacount/list.do";
	
	private VupdatacountManager vupdatacountManager;
	
	private Vupdatacount vupdatacount;
	java.lang.String id = null;
	private String[] items;
	private String returnUrl;  //返回列表，保留查询条件
	private TreeMap<String, String> dateSelectMap;// //日期选择

	public void prepare() throws Exception {
		if (isNullOrEmptyString(id)) {
			vupdatacount = new Vupdatacount();
		} else {
			vupdatacount = (Vupdatacount)vupdatacountManager.getById(id);
		}
	}
	
	/** 增加setXXXX()方法,spring就可以通过autowire自动设置对象属性 */
	public void setVupdatacountManager(VupdatacountManager manager) {
		this.vupdatacountManager = manager;
	}	
	
	public Object getModel() {
		return vupdatacount;
	}
	
	public void setCpcode(java.lang.String val) {
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
		String deptseq ="";
		if ((auth != null) && auth.getPrincipal() instanceof MyUserDetails) {
			ud = (MyUserDetails) auth.getPrincipal();
			if (ud != null) {
				username = ud.getUserName();
				deptid = ud.getDeptID();
				deptseq = ud.getDeptSeq();
				pageRequest.getFilters().put("deptSeq",deptseq);
			}
		}	
		dateSelectMap  = DateUtil.getDateSelectData();
		
		
		if (request.getParameter("s_deptseq") != null) {
			pageRequest.getFilters().put("station",
					request.getParameter("s_deptseq"));
		}
		if (request.getParameter("datatype") != null) {
			if (!request.getParameter("datatype").equals("0")) {
				pageRequest.getFilters().put("datatype",
						request.getParameter("datatype"));
			}
		}
		if (request.getParameter("count") != null) {
			pageRequest.getFilters().put("count1",
					request.getParameter("count"));
			if (request.getParameter("count").equals("0")) {
				pageRequest.getFilters().put("count",
						request.getParameter("count"));
			}
		}
		String s_birthBeginFormat = DateUtil.parseString(request,"s_birthBegin","yyyy-MM-dd","yyyyMMdd");
		String s_birthEndFormat = DateUtil.parseString(request,"s_birthEnd","yyyy-MM-dd","yyyyMMdd");
		pageRequest.getFilters().put("birthBeginFormat",s_birthBeginFormat);
		pageRequest.getFilters().put("birthEndFormat",s_birthEndFormat);
		
		
		
		Page page = vupdatacountManager.findByPageRequest(pageRequest);
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
		vupdatacountManager.save(vupdatacount);
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
		vupdatacountManager.update(this.vupdatacount);
		return returnUrl;////LIST_ACTION;
	}
	
	/**删除对象*/
	public String delete() {
		for(int i = 0; i < items.length; i++) {
			Hashtable params = HttpUtils.parseQueryString(items[i]);
			java.lang.String id = new java.lang.String((String)params.get("cpcode"));
			vupdatacountManager.removeById(id);
		}
		return returnUrl ;//LIST_ACTION;
	}

}
