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


public class TempworklogAction extends BaseStruts2Action implements Preparable,ModelDriven{
	//默认多列排序,example: username desc,createTime asc
	protected static final String DEFAULT_SORT_COLUMNS = null; 
	
	//forward paths
	protected static final String QUERY_JSP = "/pages/fjy/Tempworklog/query.jsp";
	protected static final String LIST_JSP= "/pages/fjy/Tempworklog/list.jsp";
	protected static final String CREATE_JSP = "/pages/fjy/Tempworklog/create.jsp";
	protected static final String EDIT_JSP = "/pages/fjy/Tempworklog/edit.jsp";
	protected static final String SHOW_JSP = "/pages/fjy/Tempworklog/show.jsp";
	//redirect paths,startWith: !
	protected static final String LIST_ACTION = "!/pages/fjy/Tempworklog/list.do";
	
	private TempworklogManager tempworklogManager;
	
	private TemployeeManager temployeeManager;
	
	private Tempworklog tempworklog;
	Long id = null;
	private String[] items;
	private String returnUrl;  //返回列表，保留查询条件
	private TreeMap<String, String> dateSelectMap;// //日期选择

	public void prepare() throws Exception {
		if (isNullOrEmptyString(id)) {
			tempworklog = new Tempworklog();
		} else {
			tempworklog = (Tempworklog)tempworklogManager.getById(id);
		}
	}
	
	/** 增加setXXXX()方法,spring就可以通过autowire自动设置对象属性 */
	public void setTempworklogManager(TempworklogManager manager) {
		this.tempworklogManager = manager;
	}	
	
	public void setTemployeeManager(TemployeeManager manager) {
		this.temployeeManager = manager;
	}	
	
	public Object getModel() {
		return tempworklog;
	}
	
	public void setWorklogid(Long val) {
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
//		
//		String username = "";
//		String deptid = "";
//		MyUserDetails userDetail = null;
//		userDetail = SpringTagFunctions.getUserDetails();
//		if (userDetail != null) {
//			username = userDetail.getUserName();
//			deptid = userDetail.getDeptID();
//		}
//		
//		if(!SpringTagFunctions.ifAnyGranted("ROLE_QUERY_ALL,ROLE_ADMIN")){
//			pageRequest.getFilters().put("deptid",deptid);
//			pageRequest.getFilters().put("deptLength",deptid.length());
//		}	
//		dateSelectMap  = DateUtil.getDateSelectData();
//		String dateSelect2 = "";
//		if (request.getParameter("dateSelect2") != null)
//		    dateSelect2 = request.getParameter("dateSelect2");
//			request.setAttribute("dateSelect2",dateSelect2);		        
//		String s_indateBeginFormat = DateUtil.parseString(request,"s_indateBegin","yyyy-MM-dd","yyyyMMdd");
//		String s_indateEndFormat = DateUtil.parseString(request,"s_indateEnd","yyyy-MM-dd","yyyyMMdd");
//		pageRequest.getFilters().put("indateBeginFormat",s_indateBeginFormat);
//		pageRequest.getFilters().put("indateEndFormat",s_indateEndFormat);
//		String dateSelect3 = "";
//		if (request.getParameter("dateSelect3") != null)
//		    dateSelect3 = request.getParameter("dateSelect3");
//			request.setAttribute("dateSelect3",dateSelect3);		        
//		String s_leftdateBeginFormat = DateUtil.parseString(request,"s_leftdateBegin","yyyy-MM-dd","yyyyMMdd");
//		String s_leftdateEndFormat = DateUtil.parseString(request,"s_leftdateEnd","yyyy-MM-dd","yyyyMMdd");
//		pageRequest.getFilters().put("leftdateBeginFormat",s_leftdateBeginFormat);
//		pageRequest.getFilters().put("leftdateEndFormat",s_leftdateEndFormat);
		
		Page page = tempworklogManager.findByPageRequest(pageRequest);
		savePage(page,pageRequest);
		return LIST_JSP;
	}
	
	/** 查看对象*/
	public String show() {
		HttpServletRequest request = ServletActionContext.getRequest();
		String indate =  tempworklog.getIndate();
		String indateFormat = DateUtil.parseString(indate,"yyyyMMdd","yyyy-MM-dd");
		tempworklog.setIndate(indateFormat);
		String leftdate =  tempworklog.getLeftdate();
		String leftdateFormat = DateUtil.parseString(leftdate,"yyyyMMdd","yyyy-MM-dd");
		tempworklog.setLeftdate(leftdateFormat);
		return SHOW_JSP;
	}
	
	/** 进入新增页面*/
	public String create() {
		return CREATE_JSP;
	}
	
	/** 保存新增对象 */
	public String save() {
		HttpServletRequest request = ServletActionContext.getRequest();
		String indateFormat = DateUtil.parseString(request,"indate","yyyy-MM-dd","yyyyMMdd");
		tempworklog.setIndate(indateFormat);
		String leftdateFormat = DateUtil.parseString(request,"leftdate","yyyy-MM-dd","yyyyMMdd");
		tempworklog.setLeftdate(leftdateFormat);
		tempworklogManager.save(tempworklog);
		return returnUrl;////LIST_ACTION;
	}
	
	/**进入更新页面*/
	public String edit() {
		HttpServletRequest request = ServletActionContext.getRequest();
		String indate =  tempworklog.getIndate();
		String indateFormat = DateUtil.parseString(indate,"yyyyMMdd","yyyy-MM-dd");
		tempworklog.setIndate(indateFormat);
		String leftdate =  tempworklog.getLeftdate();
		String leftdateFormat = DateUtil.parseString(leftdate,"yyyyMMdd","yyyy-MM-dd");
		tempworklog.setLeftdate(leftdateFormat);
		return EDIT_JSP;
	}
	
	/**保存更新对象*/
	public String update() {
		HttpServletRequest request = ServletActionContext.getRequest();
		String indateFormat = DateUtil.parseString(request,"indate","yyyy-MM-dd","yyyyMMdd");
		tempworklog.setIndate(indateFormat);
		String leftdateFormat = DateUtil.parseString(request,"leftdate","yyyy-MM-dd","yyyyMMdd");
		tempworklog.setLeftdate(leftdateFormat);
		
		
		tempworklogManager.update(this.tempworklog);
		
		
		if (leftdateFormat != null && leftdateFormat.length() > 0) {
			Temployee temployee = (Temployee) temployeeManager.getTemployeeById(tempworklog.getEmpcode());
			if (temployee != null) {
				temployee.setCyrjzt("2");
				temployeeManager.update(temployee);
			}
		}
		
		
		
		return returnUrl;////LIST_ACTION;
	}
	
	/**删除对象*/
	public String delete() {
		for(int i = 0; i < items.length; i++) {
			Hashtable params = HttpUtils.parseQueryString(items[i]);
			Long id = new Long((String)params.get("worklogid"));
			tempworklogManager.removeById(id);
		}
		return returnUrl ;//LIST_ACTION;
	}

}
