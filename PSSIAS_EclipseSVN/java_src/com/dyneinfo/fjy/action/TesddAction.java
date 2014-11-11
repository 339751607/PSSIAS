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


public class TesddAction extends BaseStruts2Action implements Preparable,ModelDriven{
	//默认多列排序,example: username desc,createTime asc
	protected static final String DEFAULT_SORT_COLUMNS = null; 
	
	//forward paths
	protected static final String QUERY_JSP = "/pages/fjy/Tesdd/query.jsp";
	protected static final String LIST_JSP= "/pages/fjy/Tesdd/list.jsp";
	protected static final String CREATE_JSP = "/pages/fjy/Tesdd/create.jsp";
	protected static final String EDIT_JSP = "/pages/fjy/Tesdd/edit.jsp";
	protected static final String SHOW_JSP = "/pages/fjy/Tesdd/show.jsp";
	protected static final String TAB_JSP = "/pages/fjy/Tesdd/tab.jsp";
	protected static final String TABALL_JSP = "/pages/fjy/Tesdd/tabAll.jsp";
	protected static final String LISTALL_JSP= "/pages/fjy/Tesdd/listAll.jsp";
	protected static final String SHOWALL_JSP = "/pages/fjy/Tesdd/showAll.jsp";
	//redirect paths,startWith: !
	protected static final String LIST_ACTION = "!/pages/fjy/Tesdd/list.do";
	
	private TesddManager tesddManager;
	
	private Tesdd tesdd;
	java.lang.String id = null;
	private String[] items;
	private String returnUrl;  //返回列表，保留查询条件
	private TreeMap<String, String> dateSelectMap;// //日期选择

	public void prepare() throws Exception {
		if (isNullOrEmptyString(id)) {
			tesdd = new Tesdd();
		} else {
			tesdd = (Tesdd)tesddManager.getById(id);
		}
	}
	
	/** 增加setXXXX()方法,spring就可以通过autowire自动设置对象属性 */
	public void setTesddManager(TesddManager manager) {
		this.tesddManager = manager;
	}	
	
	public Object getModel() {
		return tesdd;
	}
	
	public void setDnid(java.lang.String val) {
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
			pageRequest.getFilters().put("cpcode",deptid);
		} else if(SpringTagFunctions.ifAnyGranted("ROLE_QUERY_CHILD_ORG")){
			pageRequest.getFilters().put("deptSeq",deptseq);
		} else {
			pageRequest.getFilters().put("cpcode",deptid);
		}
		
		
		dateSelectMap  = DateUtil.getDateSelectData();
		String dateSelect13 = "";
		if (request.getParameter("dateSelect13") != null)
		    dateSelect13 = request.getParameter("dateSelect13");
			request.setAttribute("dateSelect13",dateSelect13);		        
		String s_sgsjBeginFormat = DateUtil.parseString(request,"s_sgsjBegin","yyyy-MM-dd HH:mm:ss","yyyyMMddHHmmss");
		String s_sgsjEndFormat = DateUtil.parseString(request,"s_sgsjEnd","yyyy-MM-dd HH:mm:ss","yyyyMMddHHmmss");
		pageRequest.getFilters().put("sgsjBeginFormat",s_sgsjBeginFormat);
		pageRequest.getFilters().put("sgsjEndFormat",s_sgsjEndFormat);
		String dateSelect17 = "";
		if (request.getParameter("dateSelect17") != null)
		    dateSelect17 = request.getParameter("dateSelect17");
			request.setAttribute("dateSelect17",dateSelect17);		        
		String s_gmsjBeginFormat = DateUtil.parseString(request,"s_gmsjBegin","yyyy-MM-dd HH:mm:ss","yyyyMMddHHmmss");
		String s_gmsjEndFormat = DateUtil.parseString(request,"s_gmsjEnd","yyyy-MM-dd HH:mm:ss","yyyyMMddHHmmss");
		pageRequest.getFilters().put("gmsjBeginFormat",s_gmsjBeginFormat);
		pageRequest.getFilters().put("gmsjEndFormat",s_gmsjEndFormat);
		
		String s_dnpp = "";
		if (request.getParameter("s_dnpp") != null){
			s_dnpp = request.getParameter("s_dnpp");
		    s_dnpp = "%".concat(s_dnpp).concat("%");
		    pageRequest.getFilters().put("dnppLike",s_dnpp);
		}
		Page page = tesddManager.findByPageRequest(pageRequest);
		savePage(page,pageRequest);
		return LIST_JSP;
	}
	
	
	public String listAll() {
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
			pageRequest.getFilters().put("cpcode",deptid);
		} else if(SpringTagFunctions.ifAnyGranted("ROLE_QUERY_CHILD_ORG")){
			pageRequest.getFilters().put("deptSeq",deptseq);
		} else {
			pageRequest.getFilters().put("cpcode",deptid);
		}
		
		dateSelectMap  = DateUtil.getDateSelectData();
		String dateSelect13 = "";
		if (request.getParameter("dateSelect13") != null)
		    dateSelect13 = request.getParameter("dateSelect13");
			request.setAttribute("dateSelect13",dateSelect13);		        
		String s_sgsjBeginFormat = DateUtil.parseString(request,"s_sgsjBegin","yyyy-MM-dd HH:mm:ss","yyyyMMddHHmmss");
		String s_sgsjEndFormat = DateUtil.parseString(request,"s_sgsjEnd","yyyy-MM-dd HH:mm:ss","yyyyMMddHHmmss");
		pageRequest.getFilters().put("sgsjBeginFormat",s_sgsjBeginFormat);
		pageRequest.getFilters().put("sgsjEndFormat",s_sgsjEndFormat);
		String dateSelect17 = "";
		if (request.getParameter("dateSelect17") != null)
		    dateSelect17 = request.getParameter("dateSelect17");
			request.setAttribute("dateSelect17",dateSelect17);		        
		String s_gmsjBeginFormat = DateUtil.parseString(request,"s_gmsjBegin","yyyy-MM-dd HH:mm:ss","yyyyMMddHHmmss");
		String s_gmsjEndFormat = DateUtil.parseString(request,"s_gmsjEnd","yyyy-MM-dd HH:mm:ss","yyyyMMddHHmmss");
		pageRequest.getFilters().put("gmsjBeginFormat",s_gmsjBeginFormat);
		pageRequest.getFilters().put("gmsjEndFormat",s_gmsjEndFormat);
		
		Page page = tesddManager.findByPageRequest(pageRequest);
		savePage(page,pageRequest);
		return LISTALL_JSP;
	}
	
	/** 查看对象*/
	public String show() {
		HttpServletRequest request = ServletActionContext.getRequest();
		String sgsj =  tesdd.getSgsj();
		String sgsjFormat = DateUtil.parseString(sgsj,"yyyyMMddHHmmss","yyyy-MM-dd HH:mm:ss");
		tesdd.setSgsj(sgsjFormat);
		String gmsj =  tesdd.getGmsj();
		String gmsjFormat = DateUtil.parseString(gmsj,"yyyyMMddHHmmss","yyyy-MM-dd HH:mm:ss");
		tesdd.setGmsj(gmsjFormat);
		return SHOW_JSP;
	}
	
	public String showAll() {
		HttpServletRequest request = ServletActionContext.getRequest();
		String sgsj =  tesdd.getSgsj();
		String sgsjFormat = DateUtil.parseString(sgsj,"yyyyMMddHHmmss","yyyy-MM-dd HH:mm:ss");
		tesdd.setSgsj(sgsjFormat);
		String gmsj =  tesdd.getGmsj();
		String gmsjFormat = DateUtil.parseString(gmsj,"yyyyMMddHHmmss","yyyy-MM-dd HH:mm:ss");
		tesdd.setGmsj(gmsjFormat);
		return SHOWALL_JSP;
	}
	
	
	public String tab() {
		HttpServletRequest request = ServletActionContext.getRequest();
		String sgsj =  tesdd.getSgsj();
		String sgsjFormat = DateUtil.parseString(sgsj,"yyyyMMddHHmmss","yyyy-MM-dd HH:mm:ss");
		tesdd.setSgsj(sgsjFormat);
		String gmsj =  tesdd.getGmsj();
		String gmsjFormat = DateUtil.parseString(gmsj,"yyyyMMddHHmmss","yyyy-MM-dd HH:mm:ss");
		tesdd.setGmsj(gmsjFormat);
		return TAB_JSP;
	}
	
	public String tabAll() {
		HttpServletRequest request = ServletActionContext.getRequest();
		String sgsj =  tesdd.getSgsj();
		String sgsjFormat = DateUtil.parseString(sgsj,"yyyyMMddHHmmss","yyyy-MM-dd HH:mm:ss");
		tesdd.setSgsj(sgsjFormat);
		String gmsj =  tesdd.getGmsj();
		String gmsjFormat = DateUtil.parseString(gmsj,"yyyyMMddHHmmss","yyyy-MM-dd HH:mm:ss");
		tesdd.setGmsj(gmsjFormat);
		return TABALL_JSP;
	}
	
	/** 进入新增页面*/
	public String create() {
		tesdd.setDdlx("1");
		return CREATE_JSP;
	}
	
	/** 保存新增对象 */
	public String save() {
		HttpServletRequest request = ServletActionContext.getRequest();
	
		Date date = new Date();
		SimpleDateFormat format_shougourq = new SimpleDateFormat("yyyyMMddHHmmss");
		String currDate = format_shougourq.format(date);
		tesdd.setSgsj(currDate);

		String deptID = "";
		String username = "";
		MyUserDetails userDetail = null;
		userDetail = SpringTagFunctions.getUserDetails();
		if (userDetail != null) {
			deptID = userDetail.getDeptID();
			username = userDetail.getUsername();
		}
		tesdd.setCpcode(deptID);
		tesdd.setJbr(username);
		
		
		String gmsjFormat = DateUtil.parseString(request,"gmsj","yyyy-MM-dd HH:mm:ss","yyyyMMddHHmmss");
		tesdd.setGmsj(gmsjFormat);
		tesddManager.save(tesdd);
		return returnUrl;////LIST_ACTION;
	}
	
	/**进入更新页面*/
	public String edit() {
		HttpServletRequest request = ServletActionContext.getRequest();
		String sgsj =  tesdd.getSgsj();
		String sgsjFormat = DateUtil.parseString(sgsj,"yyyyMMddHHmmss","yyyy-MM-dd HH:mm:ss");
		tesdd.setSgsj(sgsjFormat);
		String gmsj =  tesdd.getGmsj();
		String gmsjFormat = DateUtil.parseString(gmsj,"yyyyMMddHHmmss","yyyy-MM-dd HH:mm:ss");
		tesdd.setGmsj(gmsjFormat);
		return EDIT_JSP;
	}
	
	/**保存更新对象*/
	public String update() {
		HttpServletRequest request = ServletActionContext.getRequest();
		String sgsjFormat = DateUtil.parseString(request,"sgsj","yyyy-MM-dd HH:mm:ss","yyyyMMddHHmmss");
		tesdd.setSgsj(sgsjFormat);
		String gmsjFormat = DateUtil.parseString(request,"gmsj","yyyy-MM-dd HH:mm:ss","yyyyMMddHHmmss");
		tesdd.setGmsj(gmsjFormat);
		tesddManager.update(this.tesdd);
		return returnUrl;////LIST_ACTION;
	}
	
	/**删除对象*/
	public String delete() {
		for(int i = 0; i < items.length; i++) {
			Hashtable params = HttpUtils.parseQueryString(items[i]);
			java.lang.String id = new java.lang.String((String)params.get("dnid"));
			tesddManager.removeById(id);
		}
		return returnUrl ;//LIST_ACTION;
	}

}
