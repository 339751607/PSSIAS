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

import com.dyneinfo.pmdd.dao.*;
import com.dyneinfo.pmdd.model.*;
import com.dyneinfo.pmdd.service.*;

/**
 * @author lisc email:lishicheng(a)gmail.com
 */


public class CyryAction extends BaseStruts2Action implements Preparable,ModelDriven{
	//默认多列排序,example: username desc,createTime asc
	protected static final String DEFAULT_SORT_COLUMNS = null; 
	
	//forward paths
	protected static final String QUERY_JSP = "/pages/pmdd/Cyry/query.jsp";
	protected static final String LIST_JSP= "/pages/pmdd/Cyry/list.jsp";
	protected static final String CREATE_JSP = "/pages/pmdd/Cyry/create.jsp";
	protected static final String EDIT_JSP = "/pages/pmdd/Cyry/edit.jsp";
	protected static final String SHOW_JSP = "/pages/pmdd/Cyry/show.jsp";
	//redirect paths,startWith: !
	protected static final String LIST_ACTION = "!/pages/pmdd/Cyry/list.do";
	
	private CyryManager cyryManager;
	
	private Cyry cyry;
	java.lang.String dwbm = null;
	java.lang.String dwnbm = null;
	private String[] items;
	private String returnUrl;  //返回列表，保留查询条件
	private TreeMap<String, String> dateSelectMap;// //日期选择

	public void prepare() throws Exception {
		if (isNullOrEmptyString(dwbm) || isNullOrEmptyString(dwnbm) ) {
			cyry = new Cyry();
		} else {
			cyry = (Cyry)cyryManager.getCyryById(dwbm,dwnbm);
		}
	}
	
	/** 增加setXXXX()方法,spring就可以通过autowire自动设置对象属性 */
	public void setCyryManager(CyryManager manager) {
		this.cyryManager = manager;
	}	
	
	public Object getModel() {
		return cyry;
	}
	
	public void setDwbm(java.lang.String val) {
		this.dwbm = val;
	}
	public void setDwnbm(java.lang.String val) {
		this.dwnbm = val;
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
		if(!SpringTagFunctions.ifAnyGranted("ROLE_HT_ADMIN,ROLE_ADMIN,ROLE_QUERY_CHILD_ORG")){
			pageRequest.getFilters().put("deptid",deptid);	
		}
		if(SpringTagFunctions.ifAnyGranted("ROLE_QUERY_CHILD_ORG")){
			pageRequest.getFilters().put("chdeptid",deptid);	
		}
		
		dateSelectMap  = DateUtil.getDateSelectData();
		String dateSelect5 = "";
		if (request.getParameter("dateSelect5") != null)
		    dateSelect5 = request.getParameter("dateSelect5");
			request.setAttribute("dateSelect5",dateSelect5);		        
		String s_birthdayBeginFormat = DateUtil.parseString(request,"s_birthdayBegin","yyyy-MM-dd","yyyyMMdd");
		String s_birthdayEndFormat = DateUtil.parseString(request,"s_birthdayEnd","yyyy-MM-dd","yyyyMMdd");
		pageRequest.getFilters().put("birthdayBeginFormat",s_birthdayBeginFormat);
		pageRequest.getFilters().put("birthdayEndFormat",s_birthdayEndFormat);
		String dateSelect10 = "";
		if (request.getParameter("dateSelect10") != null)
		    dateSelect10 = request.getParameter("dateSelect10");
			request.setAttribute("dateSelect10",dateSelect10);		        
		String s_rzrqBeginFormat = DateUtil.parseString(request,"s_rzrqBegin","yyyy-MM-dd","yyyyMMdd");
		String s_rzrqEndFormat = DateUtil.parseString(request,"s_rzrqEnd","yyyy-MM-dd","yyyyMMdd");
		pageRequest.getFilters().put("rzrqBeginFormat",s_rzrqBeginFormat);
		pageRequest.getFilters().put("rzrqEndFormat",s_rzrqEndFormat);
		String dateSelect12 = "";
		if (request.getParameter("dateSelect12") != null)
		    dateSelect12 = request.getParameter("dateSelect12");
			request.setAttribute("dateSelect12",dateSelect12);		        
		String s_lzrqBeginFormat = DateUtil.parseString(request,"s_lzrqBegin","yyyy-MM-dd","yyyyMMdd");
		String s_lzrqEndFormat = DateUtil.parseString(request,"s_lzrqEnd","yyyy-MM-dd","yyyyMMdd");
		pageRequest.getFilters().put("lzrqBeginFormat",s_lzrqBeginFormat);
		pageRequest.getFilters().put("lzrqEndFormat",s_lzrqEndFormat);
		
		Page page = cyryManager.findByPageRequest(pageRequest);
		savePage(page,pageRequest);
		return LIST_JSP;
	}
	
	/** 查看对象*/
	public String show() {
		HttpServletRequest request = ServletActionContext.getRequest();
		String birthday =  cyry.getBirthday();
		String birthdayFormat = DateUtil.parseString(birthday,"yyyyMMdd","yyyy-MM-dd");
		cyry.setBirthday(birthdayFormat);
		String rzrq =  cyry.getRzrq();
		String rzrqFormat = DateUtil.parseString(rzrq,"yyyyMMdd","yyyy-MM-dd");
		cyry.setRzrq(rzrqFormat);
		String lzrq =  cyry.getLzrq();
		String lzrqFormat = DateUtil.parseString(lzrq,"yyyyMMdd","yyyy-MM-dd");
		cyry.setLzrq(lzrqFormat);
		return SHOW_JSP;
	}
	
	/** 进入新增页面*/
	public String create() {
		return CREATE_JSP;
	}
	
	/** 保存新增对象 */
	public String save() {
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
		String maxID = "";
		String nextMaxID ="";
		
		cyry.setFlag("1");
		
		maxID = cyryManager.getCurrentMax(deptid);
		if(maxID == null || ( maxID != null && maxID.equals("")))
			maxID = "0000";	
		int int_maxID = Integer.parseInt(maxID);
		int_maxID = int_maxID + 1;
		Integer obj = new Integer(int_maxID);
		nextMaxID = net.java.dev.common.dict.taglib.Util.padString(obj.toString(), 4, "0", true);
		
		cyry.setDwbm(deptid);
		cyry.setDwnbm(nextMaxID);
		
		String birthdayFormat = DateUtil.parseString(request,"birthday","yyyy-MM-dd","yyyyMMdd");
		cyry.setBirthday(birthdayFormat);
		String rzrqFormat = DateUtil.parseString(request,"rzrq","yyyy-MM-dd","yyyyMMdd");
		cyry.setRzrq(rzrqFormat);
		
		cyryManager.save(cyry);
		return returnUrl;////LIST_ACTION;
	}
	
	/**进入更新页面*/
	public String edit() {
		HttpServletRequest request = ServletActionContext.getRequest();
		String birthday =  cyry.getBirthday();
		String birthdayFormat = DateUtil.parseString(birthday,"yyyyMMdd","yyyy-MM-dd");
		cyry.setBirthday(birthdayFormat);
		String rzrq =  cyry.getRzrq();
		String rzrqFormat = DateUtil.parseString(rzrq,"yyyyMMdd","yyyy-MM-dd");
		cyry.setRzrq(rzrqFormat);
		String lzrq =  cyry.getLzrq();
		String lzrqFormat = DateUtil.parseString(lzrq,"yyyyMMdd","yyyy-MM-dd");
		cyry.setLzrq(lzrqFormat);
		return EDIT_JSP;
	}
	
	/**保存更新对象*/
	public String update() {
		HttpServletRequest request = ServletActionContext.getRequest();
		String birthdayFormat = DateUtil.parseString(request,"birthday","yyyy-MM-dd","yyyyMMdd");
		cyry.setBirthday(birthdayFormat);
		String rzrqFormat = DateUtil.parseString(request,"rzrq","yyyy-MM-dd","yyyyMMdd");
		cyry.setRzrq(rzrqFormat);
		String lzrqFormat = DateUtil.parseString(request,"lzrq","yyyy-MM-dd","yyyyMMdd");
		cyry.setLzrq(lzrqFormat);
		cyryManager.update(this.cyry);
		return returnUrl;////LIST_ACTION;
	}
	
	/**删除对象*/
	public String delete() {
		for(int i = 0; i < items.length; i++) {
			Hashtable params = HttpUtils.parseQueryString(items[i]);
			java.lang.String dwbm = new java.lang.String((String)params.get("dwbm"));
			java.lang.String dwnbm = new java.lang.String((String)params.get("dwnbm"));
			System.out.println(dwbm);
			System.out.println("dwnbm="+dwnbm);
			cyryManager.removeRecorderById(dwbm,dwnbm);
			
			//cyryManager.removeById(id);
		}
		return returnUrl ;//LIST_ACTION;
	}

}
