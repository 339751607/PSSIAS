/*
 * Powered By [lishicheng]
 */

package com.dyneinfo.jxy.action;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import javacommon.base.BaseStruts2Action;

import javax.servlet.http.HttpServletRequest;

import net.java.dev.common.util.DateUtil;

import org.apache.struts2.ServletActionContext;
import org.security.userdetails.MyUserDetails;
import org.springframework.security.Authentication;
import org.springframework.security.context.SecurityContext;
import org.springframework.security.context.SecurityContextHolder;

import cn.org.rapid_framework.page.Page;
import cn.org.rapid_framework.page.PageRequest;
import cn.org.rapid_framework.web.util.HttpUtils;

import com.dyneinfo.jxy.model.Tcarcaseinfo;
import com.dyneinfo.jxy.service.TcarcaseinfoManager;
import com.opensymphony.xwork2.ModelDriven;
import com.opensymphony.xwork2.Preparable;

/**
 * @author lisc email:lishicheng(a)gmail.com
 */


public class TcarcaseinfoAction extends BaseStruts2Action implements Preparable,ModelDriven{
	//默认多列排序,example: username desc,createTime asc
	protected static final String DEFAULT_SORT_COLUMNS = null; 
	
	//forward paths
	protected static final String QUERY_JSP = "/pages/jxy/Tcarcaseinfo/query.jsp";
	protected static final String LIST_JSP= "/pages/jxy/Tcarcaseinfo/list.jsp";
	protected static final String CREATE_JSP = "/pages/jxy/Tcarcaseinfo/create.jsp";
	protected static final String EDIT_JSP = "/pages/jxy/Tcarcaseinfo/edit.jsp";
	protected static final String SHOW_JSP = "/pages/jxy/Tcarcaseinfo/show.jsp";
	protected static final String BLACK_JSP = "/pages/jxy/Tcarcaseinfo/black.jsp";
	
	//redirect paths,startWith: !
	protected static final String LIST_ACTION = "!/jxy/Tcarcaseinfo/list.do";
	
	private TcarcaseinfoManager tcarcaseinfoManager;
	
	private Tcarcaseinfo tcarcaseinfo;
	java.lang.String id = null;

	private String[] items;
	private String returnUrl;  //返回列表，保留查询条件
	private TreeMap<String, String> dateSelectMap;// //日期选择

	public void prepare() throws Exception {
		if (isNullOrEmptyString(id)) {
			tcarcaseinfo = new Tcarcaseinfo();
		} else {
			tcarcaseinfo = (Tcarcaseinfo)tcarcaseinfoManager.getById(id);
		}
	}
	
	/** 增加setXXXX()方法,spring就可以通过autowire自动设置对象属性 */
	public void setTcarcaseinfoManager(TcarcaseinfoManager manager) {
		this.tcarcaseinfoManager = manager;
	}	
	
	public Object getModel() {
		return tcarcaseinfo;
	}
	
	public void setEnrolid(java.lang.String val) {
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
		
		Page page = tcarcaseinfoManager.findByPageRequest(pageRequest);
		savePage(page,pageRequest);
		return LIST_JSP;
	}
	
	/** 查看对象*/
	public String show() {
		HttpServletRequest request = ServletActionContext.getRequest();
		if(tcarcaseinfo==null){
			return BLACK_JSP;
		}
		String reptime =  tcarcaseinfo.getReptime();
		String reptimeFormat = DateUtil.parseString(reptime,"yyyyMMddHHmm","yyyy-MM-dd HH:mm");
		tcarcaseinfo.setReptime(reptimeFormat);
		return SHOW_JSP;
	}
	
	/** 进入新增页面*/
	public String create() {
		HttpServletRequest request = ServletActionContext.getRequest();
		
		request.setAttribute("enrolid", request.getParameter("oldenrolid"));
		tcarcaseinfo.setEnrolid(request.getParameter("oldenrolid"));
		return CREATE_JSP;
	}
	
	/** 保存新增对象 */
	public String save() {
		HttpServletRequest request = ServletActionContext.getRequest();
		String enrolid=request.getParameter("oldenrolid");
		tcarcaseinfo.setEnrolid(enrolid);
		//时间格式转换
		String reptimeFormat = DateUtil.parseString(request,"reptime","yyyy-MM-dd HH:mm","yyyyMMddHHmm");
		tcarcaseinfo.setReptime(reptimeFormat);
		tcarcaseinfoManager.save(tcarcaseinfo);
		return returnUrl;////LIST_ACTION;
	}

	
	/** 执行搜索 */
	public String getCarcaseList() throws Exception{

		HttpServletRequest request = ServletActionContext.getRequest();

		SecurityContext sc = SecurityContextHolder.getContext();
		Authentication auth = sc.getAuthentication();
		MyUserDetails ud = null;
		String deptid = "";
		if ((auth != null) && auth.getPrincipal() instanceof MyUserDetails) {
			ud = (MyUserDetails) auth.getPrincipal();
			if (ud != null) {
				deptid = ud.getDeptID();
			}
		}
		String ajax=request.getParameter("ajax");
		String enrolid=request.getParameter("enrolid");

		
	
		tcarcaseinfo=tcarcaseinfoManager.getById(enrolid);
		String html=null;
		if(tcarcaseinfo!=null){
			html="edit";
		}else{
			html="create";
		}

	        if (html == null) {
	            return null;
	        }
	        if(ajax!=null && ajax.equals("true")){
		        try {
		            byte[] contents = html.getBytes("UTF-8");
		            getResponse().getOutputStream().write(contents);
		        } catch (IOException e) {
		            e.printStackTrace();
		        }
		        return null;
	        }
	        
	        return html;
	}
	
	
	protected boolean matchValue(String recename,String code){
		if(recename==null||recename.length()==0){
			return false;
		}
		if(recename.trim().equals(code)){
			return true;
		}
		return false;
	}
	/**进入更新页面*/
	public String edit() {
		HttpServletRequest request = ServletActionContext.getRequest();
		String reptime =  tcarcaseinfo.getReptime();
		String reptimeFormat = DateUtil.parseString(reptime,"yyyyMMddHHmm","yyyy-MM-dd HH:mm");
		tcarcaseinfo.setReptime(reptimeFormat);
		return EDIT_JSP;
	}
	
	/**保存更新对象*/
	public String update() {
		HttpServletRequest request = ServletActionContext.getRequest();
		//时间格式转换
		java.text.SimpleDateFormat dateformat = new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm");
		java.text.SimpleDateFormat df = new java.text.SimpleDateFormat("yyyyMMddHHmm");
		String reptime="";

		try {
			if(tcarcaseinfo.getReptime()!=null&&!tcarcaseinfo.getReptime().trim().equals(""))
				reptime=df.format(dateformat.parse(tcarcaseinfo.getReptime()));

		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		tcarcaseinfo.setReptime(reptime);
		
		
		tcarcaseinfoManager.update(this.tcarcaseinfo);
		return returnUrl;////LIST_ACTION;
	}
	
	/**删除对象*/
	public String delete() {
		tcarcaseinfoManager.removeById(id);
		return returnUrl ;//LIST_ACTION;
	}

}
