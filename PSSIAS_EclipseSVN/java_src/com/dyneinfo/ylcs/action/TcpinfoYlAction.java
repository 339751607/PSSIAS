/*
 * Powered By [lishicheng]
 */

package com.dyneinfo.ylcs.action;

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

import net.java.dev.common.dict.taglib.DictHelpImpl;
import net.java.dev.common.util.DateUtil;
import org.apache.struts2.ServletActionContext;

import java.util.*;

import javacommon.base.*;
import javacommon.util.*;

import cn.org.rapid_framework.util.*;
import cn.org.rapid_framework.web.util.*;
import cn.org.rapid_framework.page.*;
import cn.org.rapid_framework.page.impl.*;

import com.dyneinfo.ylcs.model.*;
import com.dyneinfo.ylcs.dao.*;
import com.dyneinfo.ylcs.service.*;
import com.dyneinfo.zazh.util.Encry;

/**
 * @author lisc email:lishicheng(a)gmail.com
 */


public class TcpinfoYlAction extends BaseStruts2Action implements Preparable,ModelDriven{
	//默认多列排序,example: username desc,createTime asc
	protected static final String DEFAULT_SORT_COLUMNS = null; 
	
	//forward paths
	protected static final String QUERY_JSP = "/pages/ylcs/TcpinfoYl/query.jsp";
	protected static final String LIST_JSP= "/pages/ylcs/TcpinfoYl/list.jsp";
	protected static final String CREATE_JSP = "/pages/ylcs/TcpinfoYl/create.jsp";
	protected static final String EDIT_JSP = "/pages/ylcs/TcpinfoYl/edit.jsp";
	protected static final String AUTHORIZE_JSP = "/pages/ylcs/TcpinfoYl/authorize.jsp";
	
	protected static final String SHOW_JSP = "/pages/ylcs/TcpinfoYl/show.jsp";
	//redirect paths,startWith: !
	protected static final String LIST_ACTION = "!/pages/ylcs/TcpinfoYl/list.do";
	
	private TcpinfoYlManager tcpinfoYlManager;
	
	private TcpinfoYl tcpinfoYl;
	java.lang.String id = null;
	private String[] items;
	private String returnUrl;  //返回列表，保留查询条件
	private TreeMap<String, String> dateSelectMap;// //日期选择

	public void prepare() throws Exception {
		if (isNullOrEmptyString(id)) {
			tcpinfoYl = new TcpinfoYl();
		} else {
			tcpinfoYl = (TcpinfoYl)tcpinfoYlManager.getById(id);
		}
	}
	
	/** 增加setXXXX()方法,spring就可以通过autowire自动设置对象属性 */
	public void setTcpinfoYlManager(TcpinfoYlManager manager) {
		this.tcpinfoYlManager = manager;
	}	
	
	public Object getModel() {
		return tcpinfoYl;
	}
	
	public void setLocode(java.lang.String val) {
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
		String dateSelect1 = "";
		if (request.getParameter("dateSelect1") != null)
		    dateSelect1 = request.getParameter("dateSelect1");
			request.setAttribute("dateSelect1",dateSelect1);		        
		String dateSelect27 = "";
		if (request.getParameter("dateSelect27") != null)
		    dateSelect27 = request.getParameter("dateSelect27");
			request.setAttribute("dateSelect27",dateSelect27);		        
		
		Page page = tcpinfoYlManager.findByPageRequest(pageRequest);
		System.out.println(page.getResult().size());
		savePage(page,pageRequest);
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
		List hconfigList =tcpinfoYlManager.getQuery("select hcvalue from t_hconfig t where t.hckey='Code'");
		if(hconfigList.size()>0){
			String locode="";
			
			Map hconfigMap=(Map)hconfigList.get(0);
			String code = (String)hconfigMap.get("HCVALUE");//配置的CODE
			
			List idList=tcpinfoYlManager.getQuery("Select to_char(S_LIEUCODE.nextval) as id From dual");
			Map idMap=(Map)idList.get(0);
			String id=(String)idMap.get("ID");
			
			if (id.length() == 1) {
				locode = code + "00" + id;
	        }else if(id.length() == 2){
	        	locode = code + "0" + id;
	        }else if(id.length() == 3){
	        	locode = code + id;
	        }
			
			if("1".equals(tcpinfoYl.getDwlx())){
				tcpinfoYl.setLocode(tcpinfoYl.getThcode() + tcpinfoYl.getFjcode().substring(0,6) + locode) ;
			}else{
				tcpinfoYl.setLocode("J99" +  tcpinfoYl.getFjcode().substring(0,6) + locode);
			}
			System.out.println(tcpinfoYl);
			
			tcpinfoYlManager.save(tcpinfoYl);
			
		}else{
			//System.out.println("没有配置Code");
			request.setAttribute("message", "没有配置Code");
			return CREATE_JSP;
		}
		
		
		
		
		return returnUrl;////LIST_ACTION;
	}
	
	/**进入更新页面*/
	public String edit() {
		HttpServletRequest request = ServletActionContext.getRequest();
		return EDIT_JSP;
	}
	
	/**
	 * 企业授权
	 * @return
	 */
	public String authorize() {
		HttpServletRequest request = ServletActionContext.getRequest();
		return AUTHORIZE_JSP;
	}
	
	
	
	/**保存更新对象*/
	public String update() {
		HttpServletRequest request = ServletActionContext.getRequest();
		tcpinfoYlManager.update(this.tcpinfoYl);
		return returnUrl;////LIST_ACTION;
	}
	
	public String corporateLicense(){
		HttpServletRequest request = ServletActionContext.getRequest();
		String code = tcpinfoYl.getLocode().substring(3, tcpinfoYl.getLocode().length());
		Encry encry=new Encry();
		List hconfigList =tcpinfoYlManager.getQuery("select hcvalue from t_hconfig t where t.hckey='Encry'");
		Map hconfigMap=(Map)hconfigList.get(0);
		String hcvalue = (String)hconfigMap.get("HCVALUE");//配置的CODE
		
		String str=encry.crypt_pwd("e", hcvalue, tcpinfoYl.getAuthorizationcode());
		if(code.equals(str)){
			tcpinfoYlManager.update(this.tcpinfoYl);
		}else{
			//System.out.println("没有配置Code");
			request.setAttribute("message", "无效的授权");
			return AUTHORIZE_JSP;
		}
		
		return returnUrl;////LIST_ACTION;
	}
	
	/**删除对象*/
	public String delete() {
		for(int i = 0; i < items.length; i++) {
			Hashtable params = HttpUtils.parseQueryString(items[i]);
			java.lang.String id = new java.lang.String((String)params.get("locode"));
			tcpinfoYlManager.removeById(id);
		}
		return returnUrl ;//LIST_ACTION;
	}
	
	
	/**
	 * 硬件注销
	 * @return
	 */
	public String cancellation(){
		for(int i = 0; i < items.length; i++) {
			Hashtable params = HttpUtils.parseQueryString(items[i]);
			java.lang.String id = new java.lang.String((String)params.get("locode"));
			tcpinfoYlManager.doCancellation(id);
		}
		return returnUrl ;//LIST_ACTION;
	}
	
	public String lock(){
		for(int i = 0; i < items.length; i++) {
			Hashtable params = HttpUtils.parseQueryString(items[i]);
			java.lang.String id = new java.lang.String((String)params.get("locode"));
			tcpinfoYlManager.doLock(id);
		}
		return returnUrl ;//LIST_ACTION;
	}

}
