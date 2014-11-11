/*
 * Powered By [lishicheng]
 */

package com.dyneinfo.pmdd.action;

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
import net.java.dev.common.util.SpringTagFunctions;

import org.apache.struts2.ServletActionContext;

import java.util.*;

import javacommon.base.*;
import javacommon.util.*;

import cn.org.rapid_framework.util.*;
import cn.org.rapid_framework.web.util.*;
import cn.org.rapid_framework.page.*;
import cn.org.rapid_framework.page.impl.*;

import com.dyneinfo.hotel.dao.*;
import com.dyneinfo.hotel.model.*;
import com.dyneinfo.hotel.service.*;
import com.dyneinfo.pmdd.model.Sdcpupload;
import com.dyneinfo.pmdd.service.SdcpuploadpmddManager;

/**
 * @author lisc email:lishicheng(a)gmail.com
 */


public class SdcpuploadAction extends BaseStruts2Action implements Preparable,ModelDriven{
	//默认多列排序,example: username desc,createTime asc
	protected static final String DEFAULT_SORT_COLUMNS = null; 
	
	//forward paths
	protected static final String QUERY_JSP = "/pages/pmdd/Sdcpupload/query.jsp";
	protected static final String LIST_JSP= "/pages/pmdd/Sdcpupload/list.jsp";
	protected static final String CREATE_JSP = "/pages/pmdd/Sdcpupload/create.jsp";
	protected static final String EDIT_JSP = "/pages/pmdd/Sdcpupload/edit.jsp";
	protected static final String SHOW_JSP = "/pages/pmdd/Sdcpupload/show.jsp";
	//redirect paths,startWith: !
	protected static final String LIST_ACTION = "!/pages/pmdd/Sdcpupload/list.do";
	
	private SdcpuploadpmddManager sdcpuploadManager;
	
	private Sdcpupload sdcpupload;
	java.lang.Long id = null;
	private String[] items;
	private String returnUrl;  //返回列表，保留查询条件
	private TreeMap<String, String> dateSelectMap;// //日期选择

	public void prepare() throws Exception {
		if (isNullOrEmptyString(id)) {
			sdcpupload = new Sdcpupload();
		} else {
			sdcpupload = (Sdcpupload)sdcpuploadManager.getById(id);
		}
	}
	
	/** 增加setXXXX()方法,spring就可以通过autowire自动设置对象属性 */
	public void setSdcpuploadpmddManager(SdcpuploadpmddManager manager) {
		this.sdcpuploadManager = manager;
	}	
	
	public Object getModel() {
		return sdcpupload;
	}
	
	public void setXh(java.lang.Long val) {
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
	@SuppressWarnings("deprecation")
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
		
		String dateSelect2 = "";
		if (request.getParameter("dateSelect2") != null)
			dateSelect2 = request.getParameter("dateSelect2");
		request.setAttribute("dateSelect2", dateSelect2);
		 Date   now   =   new   Date();   
		 
		 SimpleDateFormat   dateFormat   =   new   SimpleDateFormat("yyyyMMdd");    
		 SimpleDateFormat   dateFormat1   =   new   SimpleDateFormat("yyyy-MM-dd");  
		String   s_datenEndFormat = dateFormat.format(new   Date(System.currentTimeMillis()));
		String s_datenBeginFormat = dateFormat.format(new   Date(System.currentTimeMillis()-1000*60*60*24));
		
		if(request.getParameter("s_starttimeBegin")!= null){
		 s_datenBeginFormat = DateUtil.parseString(request, "s_starttimeBegin", "yyyy-MM-dd", "yyyyMMdd");
		 s_datenEndFormat = DateUtil.parseString(request, "s_starttimeEnd", "yyyy-MM-dd", "yyyyMMdd");
		}
		
		pageRequest.getFilters().put("s_starttimeBegin",s_datenBeginFormat);//页面
		pageRequest.getFilters().put("a.enroltime",s_datenEndFormat);//
		if(SpringTagFunctions.ifAnyGranted("ROLE_HT_ADMIN")){
			pageRequest.getFilters().put("deptid",deptid);
		}
		
		
		request.setAttribute("starttimeBegin", DateUtil.parseString(s_datenBeginFormat,"yyyyMMdd","yyyy-MM-dd"));
		request.setAttribute("starttimeEnd",DateUtil.parseString(s_datenEndFormat,"yyyyMMdd","yyyy-MM-dd") );
		
		
		
		dateSelectMap  = DateUtil.getDateSelectData();
		
		Page page = sdcpuploadManager.findByPageRequest(pageRequest);
		
		savePage(page,pageRequest);
		return LIST_JSP;
	}
	
	/** 查看对象*/
	public String show() {
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
		String dateSelect2 = "";
		if (request.getParameter("dateSelect2") != null)
			dateSelect2 = request.getParameter("dateSelect2");
		request.setAttribute("dateSelect2", dateSelect2);

		String s_datenBeginFormat = DateUtil.parseString(request, "s_starttimeBegin", "yyyy-MM-dd", "yyyyMMdd");
		String s_datenEndFormat = DateUtil.parseString(request, "s_starttimeEnd", "yyyy-MM-dd", "yyyyMMdd");
		pageRequest.getFilters().put("s_starttimeBegin",s_datenBeginFormat);//页面
		pageRequest.getFilters().put("a.enroltime",s_datenEndFormat);//
		
		String deptseq ="";
		
		deptseq = request.getParameter("dept");
		System.out.println(deptseq+"***");
		pageRequest.getFilters().put("deptseq",deptseq);//页面
		dateSelectMap  = DateUtil.getDateSelectData();
		
		Page page = sdcpuploadManager.finall(pageRequest,deptseq);
		
		savePage(page,pageRequest);
		
		
		
		
		
		return QUERY_JSP;
	}
	
	/** 进入新增页面*/
	public String create() {
		return CREATE_JSP;
	}
	
	/** 保存新增对象 */
	public String save() {
		HttpServletRequest request = ServletActionContext.getRequest();
		sdcpuploadManager.save(sdcpupload);
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
		sdcpuploadManager.update(this.sdcpupload);
		return returnUrl;////LIST_ACTION;
	}
	
	/**删除对象*/
	public String delete() {
		for(int i = 0; i < items.length; i++) {
			Hashtable params = HttpUtils.parseQueryString(items[i]);
			java.lang.Long id = new java.lang.Long((String)params.get("xh"));
			sdcpuploadManager.removeById(id);
		}
		return returnUrl ;//LIST_ACTION;
	}

}
