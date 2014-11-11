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


public class TcppunishinfoAction extends BaseStruts2Action implements Preparable,ModelDriven{
	//默认多列排序,example: username desc,createTime asc
	protected static final String DEFAULT_SORT_COLUMNS = null; 
	
	//forward paths
	protected static final String QUERY_JSP = "/pages/jxy/Tcppunishinfo/query.jsp";
	protected static final String LIST_JSP= "/pages/jxy/Tcppunishinfo/list.jsp";
	protected static final String CREATE_JSP = "/pages/jxy/Tcppunishinfo/create.jsp";
	protected static final String EDIT_JSP = "/pages/jxy/Tcppunishinfo/edit.jsp";
	protected static final String SHOW_JSP = "/pages/jxy/Tcppunishinfo/show.jsp";
	//redirect paths,startWith: !
	protected static final String LIST_ACTION = "!/jxy/Tcppunishinfo/list.do";
	
	private TcppunishinfoManager tcppunishinfoManager;
	
	private Tcppunishinfo tcppunishinfo;
	java.lang.String id = null;
	
	private String[] items;
	private String returnUrl;  //返回列表，保留查询条件
	private TreeMap<String, String> dateSelectMap;// //日期选择

	public void prepare() throws Exception {
		HttpServletRequest request = ServletActionContext.getRequest();
		DateUtil tt = new DateUtil();   
				
			    request.setAttribute("date", tt.getNowTime("yyyy-MM-dd"));
		if (isNullOrEmptyString(id)) {
			tcppunishinfo = new Tcppunishinfo();
		} else {
			tcppunishinfo = (Tcppunishinfo)tcppunishinfoManager.getById(id);
		}
	}
	
	/** 增加setXXXX()方法,spring就可以通过autowire自动设置对象属性 */
	public void setTcppunishinfoManager(TcppunishinfoManager manager) {
		this.tcppunishinfoManager = manager;
	}	
	
	public Object getModel() {
		return tcppunishinfo;
	}
	
	public void setCpcode(java.lang.String val) {
		this.id = val;
	}
	public void setPfileno(java.lang.String val) {
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
		
		Page page = tcppunishinfoManager.findByPageRequest(pageRequest);
		savePage(page,pageRequest);
		return LIST_JSP;
	}
	
	/** 查看对象*/
	public String show() {
		HttpServletRequest request = ServletActionContext.getRequest();
		String cpcode = request.getParameter("cpcode");
		String pfileno = request.getParameter("pfileno");
		tcppunishinfo = tcppunishinfoManager.finbyid(cpcode, pfileno);
		tcppunishinfo.setPdate(DateUtil.parseString(tcppunishinfo.getPdate(),"yyyyMMdd","yyyy-MM-dd"));
		return SHOW_JSP;
	}
	
	/** 进入新增页面*/
	public String create() {
		return CREATE_JSP;
	}
	
	/** 保存新增对象 */
	public String save() {
		HttpServletRequest request = ServletActionContext.getRequest();
		Tcppunishinfo t = new Tcppunishinfo();
		//(:cpcode,:pdate,:pfileno,:authunit,:authperson,:execperson,:cause,:ptype,:range,:pperson)";
		t.setCpcode(request.getParameter("cpcode"));
		t.setPdate(DateUtil.parseString(request.getParameter("pdate"),"yyyy-MM-dd","yyyyMMdd"));
		t.setPfileno(request.getParameter("pfileno"));
		t.setAuthunit(request.getParameter("authunit"));
		t.setAuthperson(request.getParameter("authperson"));
		t.setExecperson(request.getParameter("execperson"));
		t.setCause(request.getParameter("cause"));
		t.setPtype(request.getParameter("ptype"));
		t.setRange(request.getParameter("range"));
		t.setPperson(request.getParameter("pperson"));
		if(tcppunishinfoManager.count(t.getCpcode(), t.getPfileno()) >=1){
			request.setAttribute("message", "行政处罚批准文号重复");
			return MSG_JSP;
		}else{
		tcppunishinfoManager.save(t);
		}
		return returnUrl;////LIST_ACTION;
	}
	
	/**进入更新页面*/
	public String edit() {
		HttpServletRequest request = ServletActionContext.getRequest();
		//cpcode=${item.cpcode}&casecode=${item.casecode}
		String cpcode = request.getParameter("cpcode");
		String pfileno = request.getParameter("pfileno");
		tcppunishinfo = tcppunishinfoManager.finbyid(cpcode, pfileno);
		tcppunishinfo.setPdate(DateUtil.parseString(tcppunishinfo.getPdate(),"yyyyMMdd","yyyy-MM-dd"));
		return EDIT_JSP;
	}
	
	/**保存更新对象*/
	public String update() {
		HttpServletRequest request = ServletActionContext.getRequest();
		Tcppunishinfo t = new Tcppunishinfo();
		//(:cpcode,:pdate,:pfileno,:authunit,:authperson,:execperson,:cause,:ptype,:range,:pperson)";
		t.setCpcode(request.getParameter("cpcode"));
		
		t.setPdate(DateUtil.parseString(request.getParameter("pdate"),"yyyy-MM-dd","yyyyMMdd"));
		t.setPfileno(request.getParameter("pfileno"));
		t.setAuthunit(request.getParameter("authunit"));
		t.setAuthperson(request.getParameter("authperson"));
		t.setExecperson(request.getParameter("execperson"));
		t.setCause(request.getParameter("cause"));
		t.setPtype(request.getParameter("ptype"));
		t.setRange(request.getParameter("range"));
		t.setPperson(request.getParameter("pperson"));
		tcppunishinfoManager.upd(t);
		return returnUrl;////LIST_ACTION;
	}
	
	/**删除对象*/
	public String delete() {
		HttpServletRequest request = ServletActionContext.getRequest();
			java.lang.String cpcode = request.getParameter("cpcode");
			String pfileno = request.getParameter("pfileno");
			
			
			tcppunishinfoManager.del(cpcode, pfileno);
	
		
		return "!/jxy/Tcppunishinfo/list.do";//LIST_ACTION;
	}

}
