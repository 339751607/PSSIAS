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
import org.apache.struts2.ServletActionContext;

import org.security.userdetails.MyUserDetails;
import org.springframework.security.Authentication;
import org.springframework.security.context.SecurityContext;
import org.springframework.security.context.SecurityContextHolder;

import net.java.dev.common.util.DateUtil;
import net.java.dev.common.util.SpringTagFunctions;

import java.util.*;

import javacommon.base.*;
import javacommon.util.*;

import cn.org.rapid_framework.util.*;
import cn.org.rapid_framework.web.util.*;
import cn.org.rapid_framework.page.*;
import cn.org.rapid_framework.page.impl.*;

import com.dyneinfo.zazh.util.IDCard;
import com.dyneinfo.pmdd.dao.*;
import com.dyneinfo.pmdd.model.*;
import com.dyneinfo.pmdd.service.*;

/**
 * @author lisc email:lishicheng(a)gmail.com
 */


public class TempworklogAction extends BaseStruts2Action implements Preparable,ModelDriven{
	//默认多列排序,example: username desc,createTime asc
	protected static final String DEFAULT_SORT_COLUMNS = null; 
	
	//forward paths
	protected static final String QUERY_JSP = "/pages/pmdd/Tempworklog/query.jsp";
	protected static final String LIST_JSP= "/pages/pmdd/Tempworklog/list.jsp";
	protected static final String CREATE_JSP = "/pages/pmdd/Tempworklog/create.jsp";
	protected static final String EDIT_JSP = "/pages/pmdd/Tempworklog/edit.jsp";
	protected static final String SHOW_JSP = "/pages/pmdd/Tempworklog/show.jsp";
	//redirect paths,startWith: !
	protected static final String LIST_ACTION = "!/pages/pmdd/Tempworklog/list.do";
	
	private TempworklogpmddManager tempworklogManager;
	private TemployeepmddManager temployeeManager;
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
	public void setTempworklogpmddManager(TempworklogpmddManager manager) {
		this.tempworklogManager = manager;
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
		String personid=request.getParameter("s_personid");
		request.setAttribute("deptid", deptid);
		String new_IDCard = "";
		String old_IDCard = "";
		if (  personid.length()== 15) {
			new_IDCard = IDCard.getNewIDCard(personid);
			old_IDCard = personid;
		} else if ( personid.length()== 18) {
			old_IDCard = IDCard.getOldIDCard(personid);
			new_IDCard = personid;
		} else {
			new_IDCard = personid;
			old_IDCard = personid;
		}
		if(SpringTagFunctions.ifAnyGranted("ROLE_HT_ADMIN,ROLE_ADMIN,ROLE_HT_ADMIN")){
			pageRequest.getFilters().put("personid", new_IDCard);
		}else{
			pageRequest.getFilters().put("personid", new_IDCard);
			pageRequest.getFilters().put("cpcode", deptid);
		}
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

	public void setTemployeepmddManager(TemployeepmddManager temployeeManager) {
		this.temployeeManager = temployeeManager;
	}

}
