/*
 * Powered By [lishicheng]
 */

package com.dyneinfo.pmdd.action;

import javax.servlet.http.HttpServletRequest;


import com.opensymphony.xwork2.Preparable;
import com.opensymphony.xwork2.ModelDriven;

import org.security.userdetails.MyUserDetails;
import org.springframework.security.Authentication;
import org.springframework.security.context.SecurityContext;
import org.springframework.security.context.SecurityContextHolder;
import net.java.dev.common.util.DateUtil;
import org.apache.struts2.ServletActionContext;

import java.util.*;

import javacommon.base.*;
import javacommon.util.CipherUtil;

import cn.org.rapid_framework.web.util.*;
import cn.org.rapid_framework.page.*;

import com.dyneinfo.zazh.service.SsUserManager;
import com.dyneinfo.pmdd.model.*;
import com.dyneinfo.pmdd.service.*;

/**
 * @author lisc email:lishicheng(a)gmail.com
 */


public class TpolicecheAction extends BaseStruts2Action implements Preparable,ModelDriven{
	//默认多列排序,example: username desc,createTime asc
	protected static final String DEFAULT_SORT_COLUMNS = null; 
	
	//forward paths
	protected static final String MSG1_JSP = "/commons/msg1.jsp";

	protected static final String GETDEPT_JSP = "/pages/pmdd/Tpoliceche/getDept.jsp";
	protected static final String QUERY_JSP = "/pages/pmdd/Tpoliceche/query.jsp";
	protected static final String LIST_JSP= "/pages/pmdd/Tpoliceche/list.jsp";
	protected static final String HTLIST_JSP= "/pages/pmdd/Tpoliceche/htlist.jsp";
	protected static final String CREATE_JSP = "/pages/pmdd/Tpoliceche/create.jsp";
	protected static final String EDIT_JSP = "/pages/pmdd/Tpoliceche/edit.jsp";
	protected static final String SHOW_JSP = "/pages/pmdd/Tpoliceche/show.jsp";
	//redirect paths,startWith: !
	protected static final String LIST_ACTION = "!/pages/pmdd/Tpoliceche/list.do";
	
	private TpolicechepmddManager tpolicecheManager;
	private SsUserManager ssUserManager;
	CipherUtil cipher = new CipherUtil();
	
	private Tpoliceche tpoliceche;
	Long id = null;
	private String[] items;
	private String returnUrl;  //返回列表，保留查询条件
	private TreeMap<String, String> dateSelectMap;// //日期选择

	public void prepare() throws Exception {
		if (isNullOrEmptyString(id)) {
			tpoliceche = new Tpoliceche();
		} else {
			tpoliceche = (Tpoliceche)tpolicecheManager.getById(id);
		}
	}
	
	/** 增加setXXXX()方法,spring就可以通过autowire自动设置对象属性 */
	public void setTpolicechepmddManager(TpolicechepmddManager manager) {
		this.tpolicecheManager = manager;
	}
	public void setSsUserManager(SsUserManager manager) {
		this.ssUserManager = manager;
	}
	
	public Object getModel() {
		return tpoliceche;
	}
	
	public void setCheckid(Long val) {
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
		if(request.getParameter("s_deadlineBegin")!= null){
			pageRequest.getFilters().put("s_deadlineBegin",request.getParameter("s_deadlineBegin")); 
		}
		if(request.getParameter("s_deadlineEnd")!= null){
			pageRequest.getFilters().put("s_deadlineEnd",request.getParameter("s_deadlineEnd")); 
		}
		if(request.getParameter("s_checktimeBegin")!= null){
			pageRequest.getFilters().put("s_checktimeBegin",request.getParameter("s_checktimeBegin")); 
		}
		if(request.getParameter("s_checktimeEnd")!= null){
			pageRequest.getFilters().put("s_checktimeEnd",request.getParameter("s_checktimeEnd")); 
		}
		pageRequest.getFilters().put("cpcode",deptid); 
		dateSelectMap  = DateUtil.getDateSelectData();
		String dateSelect4 = "";
		if (request.getParameter("dateSelect4") != null)
		    dateSelect4 = request.getParameter("dateSelect4");
			request.setAttribute("dateSelect4",dateSelect4);		        
		String dateSelect36 = "";
		if (request.getParameter("dateSelect36") != null)
		    dateSelect36 = request.getParameter("dateSelect36");
			request.setAttribute("dateSelect36",dateSelect36);		        
		
		Page page = tpolicecheManager.findByPageRequest(pageRequest);
		savePage(page,pageRequest);
		return LIST_JSP;
	}
	
	@SuppressWarnings("unchecked")
	public String htlist() {
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
		if(request.getParameter("s_deadlineBegin")!= null){
			pageRequest.getFilters().put("s_deadlineBegin",request.getParameter("s_deadlineBegin")); 
		}
		if(request.getParameter("s_deadlineEnd")!= null){
			pageRequest.getFilters().put("s_deadlineEnd",request.getParameter("s_deadlineEnd")); 
		}
		if(request.getParameter("s_checktimeBegin")!= null){
			pageRequest.getFilters().put("s_checktimeBegin",request.getParameter("s_checktimeBegin")); 
		}
		if(request.getParameter("s_checktimeEnd")!= null){
			pageRequest.getFilters().put("s_checktimeEnd",request.getParameter("s_checktimeEnd")); 
		}
		pageRequest.getFilters().put("cpcode",deptid); 
		dateSelectMap  = DateUtil.getDateSelectData();
		String dateSelect4 = "";
		if (request.getParameter("dateSelect4") != null)
		    dateSelect4 = request.getParameter("dateSelect4");
			request.setAttribute("dateSelect4",dateSelect4);		        
		String dateSelect36 = "";
		if (request.getParameter("dateSelect36") != null)
		    dateSelect36 = request.getParameter("dateSelect36");
			request.setAttribute("dateSelect36",dateSelect36);		        
		
		Page page = tpolicecheManager.findByPageRequest_ht(pageRequest);
		savePage(page,pageRequest);
		return HTLIST_JSP;
	}
	
	/** 查看对象*/
	public String show() {
		HttpServletRequest request = ServletActionContext.getRequest();
		return SHOW_JSP;
	}
	
	/** 进入新增页面*/
	public String create() {
		DateUtil tt = new DateUtil(); 
		String nowtime = tt.getNowTime("yyyyy-MM-dd HH:mm:ss");	
		
		  SecurityContext sc = SecurityContextHolder.getContext();
	        Authentication auth = sc.getAuthentication();
	        MyUserDetails ud = null;
			String username = "";
			
			if ((auth != null) && auth.getPrincipal() instanceof MyUserDetails) {
				ud = (MyUserDetails) auth.getPrincipal();
				if (ud != null) {
					username = ud.getDeptName();
					
				}
			}

		
		tpoliceche.setCompanyinfo(username);
		tpoliceche.setChecktimeString(nowtime);
		return CREATE_JSP;
	}
	
	/** 保存新增对象 */
	public String save() {
		HttpServletRequest request = ServletActionContext.getRequest();
		 SecurityContext sc = SecurityContextHolder.getContext();
	        Authentication auth = sc.getAuthentication();
	        MyUserDetails ud = null;
			String username = "";
			
			if ((auth != null) && auth.getPrincipal() instanceof MyUserDetails) {
				ud = (MyUserDetails) auth.getPrincipal();
				if (ud != null) {
					username = ud.getDeptID();
					
				}
			}
		tpoliceche.setCpcode(username);
		tpoliceche.setCompanyinfo(request.getParameter("company"));
		tpoliceche.setChecktimeString(request.getParameter("checktime"));
		tpolicecheManager.save(tpoliceche);
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
		tpolicecheManager.update(this.tpoliceche);
		return returnUrl;////LIST_ACTION;
	}
	
	/**删除对象*/
	public String delete() {
		for(int i = 0; i < items.length; i++) {
			Hashtable params = HttpUtils.parseQueryString(items[i]);
			Long id = new Long((String)params.get("checkid"));
			tpolicecheManager.removeById(id);
		}
		return returnUrl ;//LIST_ACTION;
	}
	public String getDept(){
		PageRequest<Map> pageRequest = newPageRequest(null);
		HttpServletRequest request = ServletActionContext.getRequest();
		
if(request.getParameter("s_username")!= null && request.getParameter("s_username")!=""){
	String username=request.getParameter("s_username");
	String userid = tpolicecheManager.username(username);
	String count = tpolicecheManager.count(userid);
	if( count.equals("0")){
		request.setAttribute("message", "该用户没有权限");
		return MSG1_JSP;	
	}
	
}
		
		String username="";
		String password="";
		if(request.getParameter("s_username")== null || request.getParameter("s_username")==""){

			username="#";
			pageRequest.getFilters().put("username",username);
			
		}
		if(request.getParameter("password")!= null && request.getParameter("password")!="")
			password=cipher.generatePassword(request.getParameter("password"));//密码加密
			
		else
			password="#";
		pageRequest.getFilters().put("password",password);
		
		
		Page page = ssUserManager.findUserByDeptSeqRequest(pageRequest);
		savePage(page,pageRequest);
		return GETDEPT_JSP;
	}

}
