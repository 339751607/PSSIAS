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


public class TchAlarminforAction extends BaseStruts2Action implements Preparable,ModelDriven{
	//默认多列排序,example: username desc,createTime asc
	protected static final String DEFAULT_SORT_COLUMNS = "id desc"; 
	
	//forward paths
	protected static final String QUERY_JSP = "/pages/hotel/TchAlarminfor/query.jsp";
	protected static final String LIST_JSP= "/pages/hotel/TchAlarminfor/list.jsp";
	protected static final String CREATE_JSP = "/pages/hotel/TchAlarminfor/create.jsp";
	protected static final String EDIT_JSP = "/pages/hotel/TchAlarminfor/edit.jsp";
	protected static final String SHOW_JSP = "/pages/hotel/TchAlarminfor/show.jsp";
	//redirect paths,startWith: !
	protected static final String LIST_ACTION = "!/pages/hotel/TchAlarminfor/list.do";
	
	private TchAlarminforManager tchAlarminforManager;
	
	private TchAlarminfor tchAlarminfor;
	java.lang.String id = null;
	private String[] items;
	private String returnUrl;  //返回列表，保留查询条件
	private TreeMap<String, String> dateSelectMap;// //日期选择

	public void prepare() throws Exception {
		if (isNullOrEmptyString(id)) {
			tchAlarminfor = new TchAlarminfor();
		} else {
			tchAlarminfor = (TchAlarminfor)tchAlarminforManager.getById(id);
		}
	}
	
	/** 增加setXXXX()方法,spring就可以通过autowire自动设置对象属性 */
	public void setTchAlarminforManager(TchAlarminforManager manager) {
		this.tchAlarminforManager = manager;
	}	
	
	public Object getModel() {
		return tchAlarminfor;
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
		if (request.getParameter("dateSelect1") != null)
			request.setAttribute("dateSelect1", request.getParameter("dateSelect1"));
		
		if (request.getParameter("s_pjsj_Begin") != null)
			pageRequest.getFilters().put("pjsj_BeginFormat",
					DateUtil.parseString(request,"s_pjsj_Begin", "yyyy-MM-dd HH:mm", "yyyyMMddHHmm"));
		if (request.getParameter("s_pjsj_End") != null)
			pageRequest.getFilters().put("pjsj_EndFormat",
					DateUtil.parseString(request,"s_pjsj_End", "yyyy-MM-dd HH:mm", "yyyyMMddHHmm"));
		
		Page page = tchAlarminforManager.findByPageRequest(pageRequest);
		savePage(page,pageRequest);
		return LIST_JSP;
	}
	
	/** 查看对象*/
	public String show() {
		HttpServletRequest request = ServletActionContext.getRequest();
		tchAlarminfor.setNl(DateUtil.parseString(tchAlarminfor.getNl(), "yyyyMMdd","yyyy-MM-dd"));
		tchAlarminfor.setBdate(DateUtil.parseString(tchAlarminfor.getBdate(), "yyyyMMdd","yyyy-MM-dd"));
		tchAlarminfor.setInTime(DateUtil.parseString(tchAlarminfor.getInTime(), "yyyyMMddHHmm","yyyy-MM-dd HH:mm"));
		tchAlarminfor.setFtime(DateUtil.parseString(tchAlarminfor.getFtime(), "yyyyMMddHHmm","yyyy-MM-dd HH:mm"));
		tchAlarminfor.setPjsj(DateUtil.parseString(tchAlarminfor.getPjsj(), "yyyyMMddHHmm","yyyy-MM-dd HH:mm"));
		return SHOW_JSP;
	}
	
	/** 进入新增页面*/
	public String create() {
		return CREATE_JSP;
	}
	
	/** 保存新增对象 */
	public String save() {
		HttpServletRequest request = ServletActionContext.getRequest();
		tchAlarminforManager.save(tchAlarminfor);
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
		tchAlarminforManager.update(this.tchAlarminfor);
		return returnUrl;////LIST_ACTION;
	}
	
	/**删除对象*/
	public String delete() {
		for(int i = 0; i < items.length; i++) {
			Hashtable params = HttpUtils.parseQueryString(items[i]);
			java.lang.String id = new java.lang.String((String)params.get("id"));
			tchAlarminforManager.removeById(id);
		}
		return returnUrl ;//LIST_ACTION;
	}

}
