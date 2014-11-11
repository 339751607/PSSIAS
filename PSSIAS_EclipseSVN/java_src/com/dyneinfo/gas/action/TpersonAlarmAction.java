/*
 * Powered By [lishicheng]
 */

package com.dyneinfo.gas.action;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import javacommon.base.BaseStruts2Action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.java.dev.common.util.DateUtil;

import org.apache.struts2.ServletActionContext;
import org.security.userdetails.MyUserDetails;
import org.springframework.security.Authentication;
import org.springframework.security.context.SecurityContext;
import org.springframework.security.context.SecurityContextHolder;

import com.dyneinfo.zazh.model.SsDept;
import cn.org.rapid_framework.page.Page;
import cn.org.rapid_framework.page.PageRequest;
import cn.org.rapid_framework.web.util.HttpUtils;

import com.dyneinfo.gas.model.TpersonAlarm;
import com.dyneinfo.gas.service.TbuylogManager;
import com.dyneinfo.gas.service.TpersonAlarmManager;
import com.opensymphony.xwork2.ModelDriven;
import com.opensymphony.xwork2.Preparable;

/**
 * @author lisc email:lishicheng(a)gmail.com
 */


public class TpersonAlarmAction extends BaseStruts2Action implements Preparable,ModelDriven{
	//默认多列排序,example: username desc,createTime asc
	protected static final String DEFAULT_SORT_COLUMNS = null; 
	
	//forward paths
	protected static final String QUERY_JSP = "/pages/gas/TpersonAlarm/query.jsp";
	protected static final String LIST_JSP= "/pages/gas/TpersonAlarm/list.jsp";
	protected static final String MESSLIST_JSP= "/pages/gas/TpersonAlarm/messlist.jsp";
	protected static final String CREATE_JSP = "/pages/gas/TpersonAlarm/create.jsp";
	protected static final String EDIT_JSP = "/pages/gas/TpersonAlarm/edit.jsp";
	protected static final String MESSEDIT_JSP = "/pages/gas/TpersonAlarm/messedit.jsp";
	protected static final String MESSUCCES_JSP = "/pages/gas/TpersonAlarm/cjsuccess.jsp";
	protected static final String SHOW_JSP = "/pages/gas/TpersonAlarm/show.jsp";
	protected static final String TZSHOW_JSP = "/pages/gas/TpersonAlarm/tzshow.jsp";
	//redirect paths,startWith: !
	protected static final String LIST_ACTION = "!/pages/gas/TpersonAlarm/list.do";
	
	private TpersonAlarmManager tpersonAlarmManager;
	private TbuylogManager tbuylogManager;
	
	private TpersonAlarm tpersonAlarm;
	java.lang.String id = null;
	
	private String mgs;
	
	private String[] items;
	private String returnUrl;  //返回列表，保留查询条件
	private TreeMap<String, String> dateSelectMap;// //日期选择

	public void prepare() throws Exception {
		if (isNullOrEmptyString(id)) {
			tpersonAlarm = new TpersonAlarm();
		} else {
			tpersonAlarm = (TpersonAlarm)tpersonAlarmManager.getById(id);
		}
	}
	
	/** 增加setXXXX()方法,spring就可以通过autowire自动设置对象属性 */
	public void setTpersonAlarmManager(TpersonAlarmManager manager) {
		this.tpersonAlarmManager = manager;
	}	
	
	public Object getModel() {
		return tpersonAlarm;
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
		
		List listdept = tbuylogManager.findDept( "and CODE = '"+deptid +"'" );
		if(listdept != null && listdept.size() > 0){
			for(int j = 0; j<listdept.size(); j++){
				SsDept ssdept = (SsDept) listdept.get(j);
				String deptlevel = ssdept.getDeptlevel().toString();
				String buildxh_temp = ssdept.getDeptcode();
				String buildNoName_temp = ssdept.getDeptname();
				String buildburcode = ssdept.getParentid().toString();
				if("2".equals(deptlevel)){
					pageRequest.getFilters().put("burcode", buildxh_temp);
				}else if ("3".equals(deptlevel)){
					pageRequest.getFilters().put("stacode", buildxh_temp);
				}else{
				}
				
			}
		}else{
		}
		dateSelectMap  = DateUtil.getDateSelectData();
		
		dateSelectMap  = DateUtil.getDateSelectData();
		String dateSelect19 = "";
		if (request.getParameter("dateSelect13") != null)
		    dateSelect19 = request.getParameter("dateSelect13");
			request.setAttribute("dateSelect13",dateSelect19);		        
//		if (request.getParameter("dateSelect13") != null){
			String s_alarmtimeBeginFormat = DateUtil.parseString(request,"s_alarmtimeBegin","yyyy-MM-dd","yyyyMMdd");
			pageRequest.getFilters().put("alarmtimeBeginFormat",s_alarmtimeBeginFormat);
//		}
//		if (request.getParameter("dateSelect13") != null){
			String s_alarmtimeEndFormat = DateUtil.parseString(request,"s_alarmtimeEnd","yyyy-MM-dd","yyyyMMdd");
			pageRequest.getFilters().put("alarmtimeEndFormat",s_alarmtimeEndFormat);
//		}
		
		Page page = tpersonAlarmManager.findByPageRequest(pageRequest);
		savePage(page,pageRequest);
		return LIST_JSP;
	}
	

/**
 * 通知messlist
 * @return
 */
	public String messlist() {
		PageRequest<Map> pageRequest = newPageRequest(DEFAULT_SORT_COLUMNS);
		HttpServletRequest request = ServletActionContext.getRequest();
		
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
		List listdept = tbuylogManager.findDept( "and CODE = '"+deptid +"'" );
		if(listdept != null && listdept.size() > 0){
			for(int j = 0; j<listdept.size(); j++){
				SsDept ssdept = (SsDept) listdept.get(j);
				String deptlevel = ssdept.getDeptlevel().toString();
				String buildxh_temp = ssdept.getDeptcode();
				String buildNoName_temp = ssdept.getDeptname();
				String buildburcode = ssdept.getParentid().toString();
				if("2".equals(deptlevel)){
					pageRequest.getFilters().put("burcode", buildxh_temp);
				}else if ("3".equals(deptlevel)){
					pageRequest.getFilters().put("stacode", buildxh_temp);
				}else{
				}
				
			}
		}else{
		}
		pageRequest.getFilters().put("clflag","0");
		
		Page page = tpersonAlarmManager.findByPageRequest(pageRequest);
		savePage(page,pageRequest);
		return MESSLIST_JSP;
	}
	
	/** 查看对象*/
	public String show() {
		HttpServletRequest request = ServletActionContext.getRequest();
		return SHOW_JSP;
	}
	/** 查看对象*/
	public String tzshow() {
		HttpServletRequest request = ServletActionContext.getRequest();
		return TZSHOW_JSP;
	}
	
	/** 进入新增页面*/
	public String create() {
		return CREATE_JSP;
	}
	
	/** 保存新增对象 */
	public String save() {
		HttpServletRequest request = ServletActionContext.getRequest();
		tpersonAlarmManager.save(tpersonAlarm);
		return returnUrl;////LIST_ACTION;
	}
	
	/**进入更新页面*/
	public String edit() {
		HttpServletRequest request = ServletActionContext.getRequest();
		SecurityContext sc = SecurityContextHolder.getContext();
        Authentication auth = sc.getAuthentication();
        MyUserDetails ud = null;
		String username = "";
		String deptid = "";
		String deptname="";
		String name="";
		if ((auth != null) && auth.getPrincipal() instanceof MyUserDetails) {
			ud = (MyUserDetails) auth.getPrincipal();
			if (ud != null) {
				username = ud.getUsername();
				deptid = ud.getDeptID();
				deptname = ud.getDeptName();
				name = ud.getUserXm();
			}
		}	
		tpersonAlarm.setPjdw(deptname);
		tpersonAlarm.setCjr(name);
		Date dqsj = new Date();
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm");
		tpersonAlarm.setPjsj(format.format(dqsj));
		
		return EDIT_JSP;
	}
	
	/**保存更新对象*/
	public String update() {
		HttpServletRequest request = ServletActionContext.getRequest();
		if(request.getParameter("zhsj") != null ){
			String zhsj = DateUtil.parseString(request,"zhsj","yyyy-MM-dd HH:mm","yyyyMMddHHmm");
			tpersonAlarm.setZhsj(zhsj);
		}
		if(request.getParameter("pjsj") != null ){
			String pjsj = DateUtil.parseString(request,"pjsj","yyyy-MM-dd HH:mm","yyyyMMddHHmm");
			tpersonAlarm.setPjsj(pjsj);
		}
		tpersonAlarm.setClflag("1");
		tpersonAlarmManager.update(this.tpersonAlarm);
		return returnUrl;////LIST_ACTION;
	}
	
	
	/**
	 * 进入更新页面
	 * */
	public String messedit() {
		HttpServletRequest request = ServletActionContext.getRequest();
		SecurityContext sc = SecurityContextHolder.getContext();
		Authentication auth = sc.getAuthentication();
		MyUserDetails ud = null;
		String username = "";
		String deptid = "";
		String deptname="";
		if ((auth != null) && auth.getPrincipal() instanceof MyUserDetails) {
			ud = (MyUserDetails) auth.getPrincipal();
			if (ud != null) {
				username = ud.getUserXm();
				deptid = ud.getDeptID();
				deptname = ud.getDeptName();
			}
		}	
		tpersonAlarm.setPjdw(deptname);
		tpersonAlarm.setCjr(username);
		Date dqsj = new Date();
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm");
		tpersonAlarm.setPjsj(format.format(dqsj));
		
		return MESSEDIT_JSP;
	}
	
	/**保存更新对象*/
	public String messupdate() {
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setCharacterEncoding("UTF-8");//通知response以UTF-8发送
		response.setContentType("text/html;charset=UTF-8");//设置浏览器以UTF-8打开
		
		if(request.getParameter("zhsj") != null ){
			String zhsj = DateUtil.parseString(request,"zhsj","yyyy-MM-dd HH:mm","yyyyMMddHHmm");
			tpersonAlarm.setZhsj(zhsj);
		}
		if(request.getParameter("pjsj") != null ){
			String pjsj = DateUtil.parseString(request,"pjsj","yyyy-MM-dd HH:mm","yyyyMMddHHmm");
			tpersonAlarm.setPjsj(pjsj);
		}
		tpersonAlarm.setClflag("1");
		tpersonAlarmManager.update(this.tpersonAlarm);
		try {
			response.getWriter().print("success");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return SUCCESS;
	}
	
	/**删除对象*/
	public String delete() {
		for(int i = 0; i < items.length; i++) {
			Hashtable params = HttpUtils.parseQueryString(items[i]);
			java.lang.String id = new java.lang.String((String)params.get("id"));
			tpersonAlarmManager.removeById(id);
		}
		return returnUrl ;//LIST_ACTION;
	}

	public String getMgs() {
		return mgs;
	}

	public void setMgs(String mgs) {
		this.mgs = mgs;
	}

	public void setTbuylogManager(TbuylogManager tbuylogManager) {
		this.tbuylogManager = tbuylogManager;
	}

}
