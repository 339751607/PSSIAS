/*
 * Powered By [lishicheng]
 */

package com.dyneinfo.hotel.action;

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

import com.dyneinfo.hotel.model.*;
import com.dyneinfo.hotel.dao.*;
import com.dyneinfo.hotel.service.*;

/**
 * @author lisc email:lishicheng(a)gmail.com
 */


public class TchRecAction extends BaseStruts2Action implements Preparable,ModelDriven{
	//默认多列排序,example: username desc,createTime asc
	protected static final String DEFAULT_SORT_COLUMNS = "id desc"; 
	
	//forward paths
	protected static final String QUERY_JSP = "/pages/hotel/TchRec/query.jsp";
	protected static final String LIST_JSP= "/pages/hotel/TchRec/list.jsp";
	protected static final String CREATE_JSP = "/pages/hotel/TchRec/create.jsp";
	protected static final String EDIT_JSP = "/pages/hotel/TchRec/edit.jsp";
	protected static final String SHOW_JSP = "/pages/hotel/TchRec/show.jsp";
	//redirect paths,startWith: !
	protected static final String LIST_ACTION = "!/pages/hotel/TchRec/list.do";
	
	private TchRecManager tchRecManager;
	
	private TchRec tchRec;
	java.lang.String id = null;
	private String[] items;
	private String returnUrl;  //返回列表，保留查询条件
	private TreeMap<String, String> dateSelectMap;// //日期选择

	public void prepare() throws Exception {
		if (isNullOrEmptyString(id)) {
			tchRec = new TchRec();
		} else {
			tchRec = (TchRec)tchRecManager.getById(id);
		}
	}
	
	/** 增加setXXXX()方法,spring就可以通过autowire自动设置对象属性 */
	public void setTchRecManager(TchRecManager manager) {
		this.tchRecManager = manager;
	}	
	
	public Object getModel() {
		return tchRec;
	}
	
	public void setId(java.lang.String val) {
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
		dateSelectMap  = DateUtil.getDateSelectData();
		
		if (request.getParameter("dateSelect1") != null)
			request.setAttribute("dateSelect1", request.getParameter("dateSelect1"));
			if (request.getParameter("dateSelect2") != null)
			request.setAttribute("dateSelect2", request.getParameter("dateSelect2"));
			
			
			if (request.getParameter("s_inTime_Begin") != null)
				pageRequest.getFilters().put("inTime_BeginFormat",
						DateUtil.parseString(request,"s_inTime_Begin", "yyyy-MM-dd HH:mm", "yyyyMMddHHmm"));
			if (request.getParameter("s_inTime_End") != null)
				pageRequest.getFilters().put("inTime_EndFormat",
						DateUtil.parseString(request,"s_inTime_End", "yyyy-MM-dd HH:mm", "yyyyMMddHHmm"));
			if (request.getParameter("s_outTime_Begin") != null)
				pageRequest.getFilters().put("outTime_BeginFormat",
						DateUtil.parseString(request,"s_outTime_Begin", "yyyy-MM-dd HH:mm", "yyyyMMddHHmm"));
			if (request.getParameter("s_outTime_End") != null)
				pageRequest.getFilters().put("outTime_EndFormat",
						DateUtil.parseString(request,"s_outTime_End", "yyyy-MM-dd HH:mm", "yyyyMMddHHmm"));
			if (request.getParameter("s_bdate_Begin") != null)
				pageRequest.getFilters().put("bdate_BeginFormat",
						DateUtil.parseString(request,"s_bdate_Begin", "yyyy-MM-dd", "yyyyMMdd"));
			if (request.getParameter("s_bdate_End") != null)
				pageRequest.getFilters().put("bdate_EndFormat",
						DateUtil.parseString(request,"s_bdate_End", "yyyy-MM-dd", "yyyyMMdd"));
			if (request.getParameter("dateSelect1") != null)
				request.setAttribute("dateSelect1", request.getParameter("dateSelect1"));
				if (request.getParameter("dateSelect2") != null)
				request.setAttribute("dateSelect2", request.getParameter("dateSelect2"));
				
				
				if (request.getParameter("s_inTime_Begin") != null)
					pageRequest.getFilters().put("inTime_BeginFormat",
							DateUtil.parseString(request,"s_inTime_Begin", "yyyy-MM-dd HH:mm", "yyyyMMddHHmm"));
				if (request.getParameter("s_inTime_End") != null)
					pageRequest.getFilters().put("inTime_EndFormat",
							DateUtil.parseString(request,"s_inTime_End", "yyyy-MM-dd HH:mm", "yyyyMMddHHmm"));
				if (request.getParameter("s_outTime_Begin") != null)
					pageRequest.getFilters().put("outTime_BeginFormat",
							DateUtil.parseString(request,"s_outTime_Begin", "yyyy-MM-dd HH:mm", "yyyyMMddHHmm"));
				if (request.getParameter("s_outTime_End") != null)
					pageRequest.getFilters().put("outTime_EndFormat",
							DateUtil.parseString(request,"s_outTime_End", "yyyy-MM-dd HH:mm", "yyyyMMddHHmm"));
				if (request.getParameter("s_bdate_Begin") != null)
					pageRequest.getFilters().put("bdate_BeginFormat",
							DateUtil.parseString(request,"s_bdate_Begin", "yyyy-MM-dd", "yyyyMMdd"));
				if (request.getParameter("s_bdate_End") != null)
					pageRequest.getFilters().put("bdate_EndFormat",
							DateUtil.parseString(request,"s_bdate_End", "yyyy-MM-dd", "yyyyMMdd"));
				
				if (null ==  request.getParameter("s_days") || request.getParameter("s_days").equals(""))
					pageRequest.getFilters().put("days",5);
				
		Page page = tchRecManager.findByPageRequest(pageRequest);
		savePage(page,pageRequest);
		return LIST_JSP;
	}
	
	/** 查看对象*/
	public String show() {
		HttpServletRequest request = ServletActionContext.getRequest();
		tchRec.setBdate(DateUtil.parseString(tchRec.getBdate(), "yyyyMMdd","yyyy-MM-dd"));
		tchRec.setInTime(DateUtil.parseString(tchRec.getInTime(), "yyyyMMddHHmm","yyyy-MM-dd HH:mm"));
		tchRec.setOutTime(DateUtil.parseString(tchRec.getOutTime(), "yyyyMMddHHmm","yyyy-MM-dd HH:mm"));
		return SHOW_JSP;
	}
	
	/** 进入新增页面*/
	public String create() {
		return CREATE_JSP;
	}
	
	/** 保存新增对象 */
	public String save() {
		HttpServletRequest request = ServletActionContext.getRequest();
		tchRecManager.save(tchRec);
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
		tchRecManager.update(this.tchRec);
		return returnUrl;////LIST_ACTION;
	}
	
	/**删除对象*/
	public String delete() {
		for(int i = 0; i < items.length; i++) {
			Hashtable params = HttpUtils.parseQueryString(items[i]);
			java.lang.String id = new java.lang.String((String)params.get("id"));
			tchRecManager.removeById(id);
		}
		return returnUrl ;//LIST_ACTION;
	}

}
