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


public class TjwPreAction extends BaseStruts2Action implements Preparable,ModelDriven{
	//默认多列排序,example: username desc,createTime asc
	protected static final String DEFAULT_SORT_COLUMNS = "id desc"; 
	
	//forward paths
	protected static final String QUERY_JSP = "/pages/hotel/TjwPre/query.jsp";
	protected static final String LIST_JSP= "/pages/hotel/TjwPre/list.jsp";
	protected static final String CREATE_JSP = "/pages/hotel/TjwPre/create.jsp";
	protected static final String EDIT_JSP = "/pages/hotel/TjwPre/edit.jsp";
	protected static final String SHOW_JSP = "/pages/hotel/TjwPre/show.jsp";
	protected static final String ZAZHSHOW_JSP = "/pages/hotel/TjwPre/zazhShow.jsp";
	protected static final String SHOW_PIC = "/pages/pic/pic.jsp";
	//redirect paths,startWith: !
	protected static final String LIST_ACTION = "!/pages/hotel/TjwPre/list.do";
	
	private TjwPreManager tjwPreManager;
	
	private TjwPre tjwPre;
	java.lang.String id = null;
	private String[] items;
	private String returnUrl;  //返回列表，保留查询条件
	private TreeMap<String, String> dateSelectMap;// //日期选择

	public void prepare() throws Exception {
		if (isNullOrEmptyString(id)) {
			tjwPre = new TjwPre();
		} else {
			tjwPre = (TjwPre)tjwPreManager.getById(id);
		}
	}
	
	/** 增加setXXXX()方法,spring就可以通过autowire自动设置对象属性 */
	public void setTjwPreManager(TjwPreManager manager) {
		this.tjwPreManager = manager;
	}	
	
	public Object getModel() {
		return tjwPre;
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
		//pageRequest.getFilters().put("key",value);     //add custom filter
		
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
			if (request.getParameter("s_stayDate_Begin") != null)
				pageRequest.getFilters().put("stayDate_BeginFormat",
						DateUtil.parseString(request,"s_stayDate_Begin", "yyyy-MM-dd", "yyyyMMdd"));
			if (request.getParameter("s_stayDate_End") != null)
				pageRequest.getFilters().put("stayDate_EndFormat",
						DateUtil.parseString(request,"s_stayDate_End", "yyyy-MM-dd", "yyyyMMdd"));
			if (request.getParameter("s_inDate_Begin") != null)
				pageRequest.getFilters().put("inDate_BeginFormat",
						DateUtil.parseString(request,"s_inDate_Begin", "yyyy-MM-dd", "yyyyMMdd"));
			if (request.getParameter("s_inDate_End") != null)
				pageRequest.getFilters().put("inDate_EndFormat",
						DateUtil.parseString(request,"s_inDate_End", "yyyy-MM-dd", "yyyyMMdd"));
		
		Page page = null ;
		if(null == request.getParameter("s_TableName") || "".equals(request.getParameter("s_TableName"))){
			page = tjwPreManager.findByPageRequest(pageRequest);
		}else{
			page = tjwPreManager.findByPageRequest(pageRequest,request.getParameter("s_TableName"));
		}
		savePage(page,pageRequest);
		return LIST_JSP;
	}
	
	/** 查看对象*/
	public String show() {
		HttpServletRequest request = ServletActionContext.getRequest();
		tjwPre.setBdate(DateUtil.parseString(tjwPre.getBdate(), "yyyyMMdd","yyyy-MM-dd"));
		tjwPre.setInDate(DateUtil.parseString(tjwPre.getInDate(), "yyyyMMdd","yyyy-MM-dd"));
		tjwPre.setInTime(DateUtil.parseString(tjwPre.getInTime(), "yyyyMMddHHmm","yyyy-MM-dd HH:mm"));
		tjwPre.setOutTime(DateUtil.parseString(tjwPre.getOutTime(), "yyyyMMddHHmm","yyyy-MM-dd HH:mm"));
		tjwPre.setStayDate(DateUtil.parseString(tjwPre.getStayDate(), "yyyyMMdd","yyyy-MM-dd"));
		return SHOW_JSP;
	}
	/** 查看对象*/
	public String zazhShow() {
		HttpServletRequest request = ServletActionContext.getRequest();
		if(null == tjwPre){
			tjwPre = new TjwPre();
		}
		tjwPre.setBdate(DateUtil.parseString(tjwPre.getBdate(), "yyyyMMdd","yyyy-MM-dd"));
		tjwPre.setInDate(DateUtil.parseString(tjwPre.getInDate(), "yyyyMMdd","yyyy-MM-dd"));
		tjwPre.setInTime(DateUtil.parseString(tjwPre.getInTime(), "yyyyMMddHHmm","yyyy-MM-dd HH:mm"));
		tjwPre.setOutTime(DateUtil.parseString(tjwPre.getOutTime(), "yyyyMMddHHmm","yyyy-MM-dd HH:mm"));
		tjwPre.setStayDate(DateUtil.parseString(tjwPre.getStayDate(), "yyyyMMdd","yyyy-MM-dd"));
		return ZAZHSHOW_JSP;
	}

	/** 进入新增页面*/
	public String create() {
		return CREATE_JSP;
	}
	
	/** 保存新增对象 */
	public String save() {
		HttpServletRequest request = ServletActionContext.getRequest();
		tjwPreManager.save(tjwPre);
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
		tjwPreManager.update(this.tjwPre);
		return returnUrl;////LIST_ACTION;
	}
	
	/**删除对象*/
	public String delete() {
		for(int i = 0; i < items.length; i++) {
			Hashtable params = HttpUtils.parseQueryString(items[i]);
			java.lang.String id = new java.lang.String((String)params.get("id"));
			tjwPreManager.removeById(id);
		}
		return returnUrl ;//LIST_ACTION;
	}

	// 显示图片
	public String showPic() {
		HttpServletRequest request = ServletActionContext.getRequest();
		String id = "";
		if (request.getParameter("id") != null)
			id = request.getParameter("id");
		List list = (List) tjwPreManager.getPic(id);
		request.setAttribute("list", list);
		return SHOW_PIC;
	}
}
