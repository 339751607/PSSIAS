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


public class ThotelBsQaAction extends BaseStruts2Action implements Preparable,ModelDriven{
	//默认多列排序,example: username desc,createTime asc
	protected static final String DEFAULT_SORT_COLUMNS = null; 
	
	//forward paths
	protected static final String QUERY_JSP = "/pages/jxy/ThotelBsQa/query.jsp";
	protected static final String LIST_JSP= "/pages/jxy/ThotelBsQa/list.jsp";
	protected static final String LIST_USER_JSP= "/pages/jxy/ThotelBsQa/listUser.jsp";
	protected static final String CREATE_JSP = "/pages/jxy/ThotelBsQa/create.jsp";
	protected static final String EDIT_JSP = "/pages/jxy/ThotelBsQa/edit.jsp";
	protected static final String SHOW_JSP = "/pages/jxy/ThotelBsQa/show.jsp";
	protected static final String SHOW_HT_JSP="/pages/jxy/ThotelBsQa/htshow.jsp";
	//redirect paths,startWith: !
	protected static final String LIST_ACTION = "!/jxy/ThotelBsQa/list.do";
	
	private ThotelBsQaManager thotelBsQaManager;
	
	private ThotelBsQa thotelBsQa;
	Long id = null;
	private String[] items;
	private String returnUrl;  //返回列表，保留查询条件
	private TreeMap<String, String> dateSelectMap;// //日期选择
	private String username="";
	private String deptid="";
	private String userXm="";
	public void prepare() throws Exception {
        SecurityContext sc = SecurityContextHolder.getContext();
        Authentication auth = sc.getAuthentication();
        MyUserDetails ud = null;

		if ((auth != null) && auth.getPrincipal() instanceof MyUserDetails) {
			ud = (MyUserDetails) auth.getPrincipal();
			if (ud != null) {
				username = ud.getUsername();
				deptid = ud.getDeptID();
				userXm=ud.getUserXm();
				
			}
		}
		if (isNullOrEmptyString(id)) {
			thotelBsQa = new ThotelBsQa();
		} else {
			thotelBsQa = (ThotelBsQa)thotelBsQaManager.getById(id);
		}
	}
	
	/** 增加setXXXX()方法,spring就可以通过autowire自动设置对象属性 */
	public void setThotelBsQaManager(ThotelBsQaManager manager) {
		this.thotelBsQaManager = manager;
	}	
	
	public Object getModel() {
		return thotelBsQa;
	}
	
	public void setXh(Long val) {
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
	public String htadlist() {
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
		pageRequest=setQueryPage(pageRequest);
		
		Page page = thotelBsQaManager.findByPageRequest(pageRequest);
		savePage(page,pageRequest);
		return LIST_JSP;
	}
	/** 执行搜索 */
	public String listUser() {
		PageRequest<Map> pageRequest = newPageRequest(DEFAULT_SORT_COLUMNS);
	
	
		dateSelectMap  = DateUtil.getDateSelectData();
		pageRequest=setQueryPage(pageRequest);
		pageRequest.getFilters().put("flag","1");
		Page page = thotelBsQaManager.findByPageRequest(pageRequest);
		savePage(page,pageRequest);
		return LIST_USER_JSP;
	}
	public PageRequest<Map> setQueryPage(PageRequest<Map> pageRequest){

		HttpServletRequest request = ServletActionContext.getRequest();
		String dateSelect1 = "";
		if (request.getParameter("dateSelect1") != null)
		    dateSelect1 = request.getParameter("dateSelect1");
			request.setAttribute("dateSelect1",dateSelect1);		        
		String dateSelect2 = "";
		if (request.getParameter("dateSelect2") != null)
		    dateSelect2 = request.getParameter("dateSelect2");
			request.setAttribute("dateSelect2",dateSelect2);		  
		
		String s_wtsjBeginFormat = DateUtil.parseString(request,"s_wtsjBegin","yyyy-MM-dd","yyyyMMdd");
		String s_wtsjEndFormat = DateUtil.parseString(request,"s_wtsjEnd","yyyy-MM-dd","yyyyMMdd");
		pageRequest.getFilters().put("wtsjBeginFormat",s_wtsjBeginFormat);
		pageRequest.getFilters().put("wtsjEndFormat",s_wtsjEndFormat);
		String s_jdsjBeginFormat = DateUtil.parseString(request,"s_jdsjBegin","yyyy-MM-dd","yyyyMMdd");
		String s_jdsjEndFormat = DateUtil.parseString(request,"s_jdsjEnd","yyyy-MM-dd","yyyyMMdd");
		pageRequest.getFilters().put("jdsjBeginFormat",s_jdsjBeginFormat);
		pageRequest.getFilters().put("jdsjEndFormat",s_jdsjEndFormat);
		return pageRequest;
		
	}
	/** 查看对象*/
	public String show() {
		setDateFormat();
		return SHOW_JSP;
	}
	/** 查看对象*/
	public String htadshow() {
		setDateFormat();
		return SHOW_HT_JSP;
	}
	
	/** 进入新增页面*/
	public String create() {
		return CREATE_JSP;
	}
	
	/** 保存新增对象 */
	public String save() {
		HttpServletRequest request = ServletActionContext.getRequest();

		thotelBsQa.setCode(deptid);
		thotelBsQa.setUsername(username);
		SimpleDateFormat f = new SimpleDateFormat(
				"yyyyMMdd");
		thotelBsQa.setWtsj(f.format(new Date()));
		thotelBsQa.setJdbz("1");
		thotelBsQa.setFlag("1");

		thotelBsQaManager.save(thotelBsQa);
		return returnUrl;////LIST_ACTION;
	}
	
	/**进入更新页面*/
	public String htadedit() {
		HttpServletRequest request = ServletActionContext.getRequest();
		setDateFormat();
		return EDIT_JSP;
	}
	public void setDateFormat(){
		HttpServletRequest request = ServletActionContext.getRequest();
		String jdsj=thotelBsQa.getJdsj();
		String jdsjFormat = DateUtil.parseString(jdsj,"yyyyMMdd","yyyy-MM-dd");
		thotelBsQa.setJdsj(jdsjFormat);
		String wtsj=thotelBsQa.getWtsj();
		String wtsjFormat = DateUtil.parseString(wtsj,"yyyyMMdd","yyyy-MM-dd");
		thotelBsQa.setWtsj(wtsjFormat);
	}
	
	/**保存更新对象*/
	public String update() {
		HttpServletRequest request = ServletActionContext.getRequest();
		SimpleDateFormat f = new SimpleDateFormat(
		"yyyyMMdd");
		thotelBsQa.setJdsj(f.format(new Date()));
		thotelBsQa.setJdr(userXm);
		thotelBsQaManager.update(this.thotelBsQa);
		return returnUrl;////LIST_ACTION;
	}
	
	/**删除对象*/
	public String delete() {
		for(int i = 0; i < items.length; i++) {
			Hashtable params = HttpUtils.parseQueryString(items[i]);
			Long id = new Long((String)params.get("xh"));
			thotelBsQaManager.removeById(id);
		}
		return returnUrl ;//LIST_ACTION;
	}

}
