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

import java.io.UnsupportedEncodingException;
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


public class TcpnsjlAction extends BaseStruts2Action implements Preparable,ModelDriven{
	//默认多列排序,example: username desc,createTime asc
	protected static final String DEFAULT_SORT_COLUMNS = null; 
	
	//forward paths
	protected static final String QUERY_JSP = "/pages/jxy/Tcpnsjl/query.jsp";
	protected static final String LIST_JSP= "/pages/jxy/Tcpnsjl/list.jsp";
	protected static final String CREATE_JSP = "/pages/jxy/Tcpnsjl/create.jsp";
	protected static final String EDIT_JSP = "/pages/jxy/Tcpnsjl/edit.jsp";
	protected static final String SHOW_JSP = "/pages/jxy/Tcpnsjl/show.jsp";
	//redirect paths,startWith: !
	protected static final String LIST_ACTION = "!/jxy/Tcpnsjl/list.do";
	
	private TcpnsjlManager tcpnsjlManager;
	
	private Tcpnsjl tcpnsjl;
	
	java.lang.String id = null;
	
	private String[] items;
	private String returnUrl;  //返回列表，保留查询条件
	private TreeMap<String, String> dateSelectMap;// //日期选择

	public void prepare() throws Exception {
		HttpServletRequest request = ServletActionContext.getRequest();
		DateUtil tt = new DateUtil();   
				
 request.setAttribute("date", tt.getNowTime("yyyy-MM-dd"));
		//if (isNullOrEmptyString(id)) {
			//tcpnsjl = new Tcpnsjl();
	//	} else {
		//	tcpnsjl = (Tcpnsjl)tcpnsjlManager.getById(id);
	//	}
	}
	
	/** 增加setXXXX()方法,spring就可以通过autowire自动设置对象属性 */
	public void setTcpnsjlManager(TcpnsjlManager manager) {
		this.tcpnsjlManager = manager;
	}	
	
	public Object getModel() {
		return tcpnsjl;
	}
	
	public void setCpcode(java.lang.String val) {
		this.id = val;
	}
	public void setShnd(java.lang.String val) {
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
	
	/** 执行搜索 
	 * @throws UnsupportedEncodingException */
	public String list() throws UnsupportedEncodingException {
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
		
		if(request.getParameter("cpcode") != null){
			String cpcode = request.getParameter("cpcode");
			String cpname = tcpnsjlManager.find(cpcode);
			pageRequest.getFilters().put("cpcode", request.getParameter("cpcode"));
			request.setAttribute("cpcode", request.getParameter("cpcode"));
			request.setAttribute("cpname", cpname);
		}
	
		if(request.getParameter("static") != null && request.getParameter("static").equals("upd") && null != request.getParameter("nsyj")){
			this.upd();
		}
		if(request.getParameter("static") != null && request.getParameter("static").equals("show")){
			this.edit();
		}
		Page page = tcpnsjlManager.findByPageRequest(pageRequest);
		savePage(page,pageRequest);
		
		Calendar cal=Calendar.getInstance();
		System.out.println(cal.get(Calendar.YEAR));
		request.setAttribute("shnd", cal.get(Calendar.YEAR));
		
		return LIST_JSP;
	}
	
	/** 查看对象*/
	public String show() {
		HttpServletRequest request = ServletActionContext.getRequest();
		return SHOW_JSP;
	}
	
	/** 进入新增页面*/
	public String create() {
		return CREATE_JSP;
	}
	
	/** 保存新增对象 */
	public String save() {
		HttpServletRequest request = ServletActionContext.getRequest();
		Tcpnsjl nsjl = new Tcpnsjl();	
		
		nsjl.setCpcode(request.getParameter("cpcode"));
		nsjl.setShnd(request.getParameter("shnd"));
		nsjl.setShrj(DateUtil.parseString(request.getParameter("shrj"),"yyyy-MM-dd","yyyyMMdd"));
		nsjl.setNsyj(request.getParameter("nsyj"));
		nsjl.setQsr(request.getParameter("qsr"));
		nsjl.setJbr(request.getParameter("jbr"));
		DateUtil tt = new DateUtil();    
    	System.out.println(tt.getNowTime("yyyy"));
    	if(Integer.parseInt(nsjl.getShnd())>Integer.parseInt(tt.getNowTime("yyyy"))){
    		request.setAttribute("message", "审核年度大于当前年");
			return MSG_JSP;
    		
    	}
		if(tcpnsjlManager.getbyidt( nsjl.getShnd(),nsjl.getCpcode()) >= 1 ){
			request.setAttribute("message", "已有该年的年审记录");
			return MSG_JSP;	
		}else{
		
		tcpnsjlManager.insert(nsjl);
		}
		return returnUrl;////LIST_ACTION;
	}
	
	/**进入更新页面*/
	public void edit() {
		HttpServletRequest request = ServletActionContext.getRequest();
		String cpcode = request.getParameter("cpcode");
		String shnd =request.getParameter("shnd");
		tcpnsjl =tcpnsjlManager.finbyid(cpcode, shnd);
		
		request.setAttribute("shnd", tcpnsjl.getShnd());
		request.setAttribute("shrj", DateUtil.parseString(tcpnsjl.getShrj(),"yyyyMMdd","yyyy-MM-dd"));
		
		
	}
	
	/**保存更新对象*/
	public String update() {
		HttpServletRequest request = ServletActionContext.getRequest();
		Tcpnsjl nsjl = new Tcpnsjl();	
		nsjl.setCpcode(request.getParameter("cpcode"));
		nsjl.setShnd(request.getParameter("shnd"));
		nsjl.setShrj(DateUtil.parseString(request.getParameter("shrj"),"yyyy-MM-dd","yyyyMMdd"));
		nsjl.setNsyj(request.getParameter("nsyj"));
		nsjl.setQsr(request.getParameter("qsr"));
		nsjl.setJbr(request.getParameter("jbr"));
		String sh = request.getParameter("sh");
		System.out.println(sh);
		System.out.println(nsjl.getShnd());
		if(sh.equals(nsjl.getShnd())){
			
			tcpnsjlManager.update(nsjl);
		}else{
		if(tcpnsjlManager.getbyidt(nsjl.getShnd(),nsjl.getCpcode()) >=1 ){
			request.setAttribute("message", "已有该年的年审记录！");
			return MSG_JSP;	
		}else{
		tcpnsjlManager.update(nsjl);
		}
		}
		return returnUrl;////LIST_ACTION;
	}
	
	/**删除对象*/
	public String delete() {
		for(int i = 0; i < items.length; i++) {
			Hashtable params = HttpUtils.parseQueryString(items[i]);
		
			tcpnsjlManager.removeById(id);
		}
		return returnUrl ;//LIST_ACTION;
	}
	public void upd(){
		HttpServletRequest request = ServletActionContext.getRequest();
		String cpcode=request.getParameter("cpcode");
		String shnd=request.getParameter("shnd");
	
	if(tcpnsjlManager.getbyidt( shnd,cpcode) >= 1){
	
		this.update();
	}else{
		
		this.save();
		}
		
	
	}

}
