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


public class VcarreturnAction extends BaseStruts2Action implements Preparable,ModelDriven{
	//默认多列排序,example: username desc,createTime asc
	protected static final String DEFAULT_SORT_COLUMNS = "enroltime desc"; 
	
	//forward paths
	protected static final String QUERY_JSP = "/pages/jxy/Vcarreturn/query.jsp";
	protected static final String LIST_JSP= "/pages/jxy/Vcarreturn/list.jsp";
	protected static final String CREATE_JSP = "/pages/jxy/Vcarreturn/create.jsp";
	protected static final String EDIT_JSP = "/pages/jxy/Vcarreturn/edit.jsp";
	protected static final String SHOW_JSP = "/pages/jxy/Vcarreturn/show.jsp";
	//redirect paths,startWith: !
	protected static final String LIST_ACTION = "!/jxy/Vcarreturn/list.do";
	
	private VcarreturnManager vcarreturnManager;
	private TcarinfoManager tcarinfoManager;
	private Vcarreturn vcarreturn;
	java.lang.String id = null;
	private String[] items;
	private String returnUrl;  //返回列表，保留查询条件
	private TreeMap<String, String> dateSelectMap;// //日期选择

	public void prepare() throws Exception {
		if (isNullOrEmptyString(id)) {
			vcarreturn = new Vcarreturn();
		} else {
			vcarreturn = (Vcarreturn)vcarreturnManager.getById(id);
		}
	}
	
	/** 增加setXXXX()方法,spring就可以通过autowire自动设置对象属性 */
	public void setVcarreturnManager(VcarreturnManager manager) {
		this.vcarreturnManager = manager;
	}	
	
	public Object getModel() {
		return vcarreturn;
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
		   
		
		String serveritem1="";
		if(request.getParameter("serveritem") != null){
		 serveritem1 = this.util(request.getParameter("serveritem"));
		 request.setAttribute("serveritem", serveritem1);
		}
		pageRequest.getFilters().put("serveritem", serveritem1);
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
		//取车时间
		String s_birthBeginFormat = DateUtil.parseString(request,"s_birthBegin","yyyy-MM-dd HH:mm","yyyyMMddHHmm");
		String s_birthEndFormat = DateUtil.parseString(request,"s_birthEnd","yyyy-MM-dd HH:mm","yyyyMMddHHmm");
		pageRequest.getFilters().put("birthBeginFormat",s_birthBeginFormat);
		pageRequest.getFilters().put("birthEndFormat",s_birthEndFormat);
		//送车时间
		String s_indateBeginFormat = DateUtil.parseString(request,"s_indateBegin","yyyy-MM-dd HH:mm","yyyyMMddHHmm");
		String s_indateEndFormat = DateUtil.parseString(request,"s_indateEnd","yyyy-MM-dd HH:mm","yyyyMMddHHmm");
		pageRequest.getFilters().put("indateBeginFormat",s_indateBeginFormat);
		pageRequest.getFilters().put("indateEndFormat",s_indateEndFormat);
		
		
		StringBuffer data = new StringBuffer("var ja=[];");
		 List serveritem = tcarinfoManager.getServeritemForLevelOne();
		if (serveritem != null) {
			for (int i = 0; i < serveritem.size(); i++) {
				Map map = (Map) serveritem.get(i);
				if(map.get("dictlevel") != null && map.get("dictlevel").toString().equals("1"))
					data.append("\r\n");
				data.append("ja['"+map.get("dictid")+"']='"+map.get("dictname")+"';");
			}
		}
		request.setAttribute("data", data);
		
		
		StringBuffer dataTwo = new StringBuffer("var menus=new Array(new Array('1','信息','0'),");
		List serveritemTwo = tcarinfoManager.getServeritemForLevelTwo();
		if (serveritemTwo != null) {
			for (int i = 0; i < serveritemTwo.size(); i++) {
				Map map = (Map) serveritemTwo.get(i);
				dataTwo.append("new Array('"+map.get("dictid")+"','"+map.get("dictname")+"','"+map.get("parentid")+"'),");
			}
		}
		dataTwo.append("'');");
		request.setAttribute("dataTwo", dataTwo);
		Page page = vcarreturnManager.findByPageRequest(pageRequest);
		savePage(page,pageRequest);
		return LIST_JSP;
	}
	
	/** 查看对象*/
	public String show() {
		HttpServletRequest request = ServletActionContext.getRequest();
		String carrid = "";
		if("".equals(request.getParameter("rid"))){
			carrid =request.getParameter("rid");
		}
		vcarreturn =vcarreturnManager.getById(carrid);
		return SHOW_JSP;
	}
	
	/** 进入新增页面*/
	public String create() {
		return CREATE_JSP;
	}
	
	/** 保存新增对象 */
	public String save() {
		HttpServletRequest request = ServletActionContext.getRequest();
		vcarreturnManager.save(vcarreturn);
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
		vcarreturnManager.update(this.vcarreturn);
		return returnUrl;////LIST_ACTION;
	}
	
	/**删除对象*/
	public String delete() {
		for(int i = 0; i < items.length; i++) {
			Hashtable params = HttpUtils.parseQueryString(items[i]);
			java.lang.String id = new java.lang.String((String)params.get("enrolid"));
			vcarreturnManager.removeById(id);
		}
		return returnUrl ;//LIST_ACTION;
	}
	public void setTcarinfoManager(TcarinfoManager manager) {
		this.tcarinfoManager = manager;
	}
public String util(String serveritem){
		
		String a[] = serveritem.split(";");
		java.util.Arrays.sort(a);
		
		String util="";
		for(int x = 0; x<a.length;x++){
			util +=a[x]+";" ;
			
		}
		util= util.substring(0, util.length()-1);
		
		
		return util;
		
	}

}
