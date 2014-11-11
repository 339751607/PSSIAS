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


public class RegistersAction extends BaseStruts2Action implements Preparable,ModelDriven{
	//默认多列排序,example: username desc,createTime asc
	protected static final String DEFAULT_SORT_COLUMNS = null; 
	
	//forward paths
	protected static final String QUERY_JSP = "/pages/pmdd/Registers/query.jsp";
	protected static final String LIST_JSP= "/pages/pmdd/Registers/list.jsp";
	protected static final String CREATE_JSP = "/pages/pmdd/Registers/create.jsp";
	protected static final String EDIT_JSP = "/pages/pmdd/Registers/edit.jsp";
	protected static final String SHOW_JSP = "/pages/pmdd/Registers/show.jsp";
	//redirect paths,startWith: !
	protected static final String LIST_ACTION = "!/pages/pmdd/Registers/list.do";
	
	private RegisterspmddManager registersManager;
	
	private Registers registers;
	Long id = null;
	private String[] items;
	private String returnUrl;  //返回列表，保留查询条件
	private TreeMap<String, String> dateSelectMap;// //日期选择

	public void prepare() throws Exception {
		if (isNullOrEmptyString(id)) {
			registers = new Registers();
		} else {
			registers = (Registers)registersManager.getById(id);
		}
	}
	
	/** 增加setXXXX()方法,spring就可以通过autowire自动设置对象属性 */
	public void setRegistersManager(RegisterspmddManager manager) {
		this.registersManager = manager;
	}	
	
	public Object getModel() {
		return registers;
	}
	
	public void setUnitid(Long val) {
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
		String dateSelect4 = "";
		if (request.getParameter("dateSelect4") != null)
		    dateSelect4 = request.getParameter("dateSelect4");
		request.setAttribute("dateSelect4",dateSelect4);		        
		String s_packagesBeginFormat = DateUtil.parseString(request,"s_packagesBegin","yyyy-MM-dd","yyyyMMdd");
		String s_packagesEndFormat = DateUtil.parseString(request,"s_packagesEnd","yyyy-MM-dd","yyyyMMdd");
		pageRequest.getFilters().put("s_packagesBeginFormat",s_packagesBeginFormat);
		pageRequest.getFilters().put("s_packagesEndFormat",s_packagesEndFormat);
		String dateSelect7 = "";
		if (request.getParameter("dateSelect7") != null)
		    dateSelect7 = request.getParameter("dateSelect7");
		request.setAttribute("dateSelect7",dateSelect7);		        
		
		Page page = registersManager.findByPageRequest(pageRequest);
		savePage(page,pageRequest);
		return LIST_JSP;
	}
	
	/** 查看对象*/
	public String show() {
		HttpServletRequest request = ServletActionContext.getRequest();
		String packages =  registers.getPackages();
		String packagesFormat = DateUtil.parseString(packages,"yyyyMMdd","yyyy-MM-dd");
		registers.setPackages(packagesFormat);
		return SHOW_JSP;
	}
	
	/** 进入新增页面*/
	public String create() {
		return CREATE_JSP;
	}
	
	/** 保存新增对象 */
	public String save() {
		HttpServletRequest request = ServletActionContext.getRequest();
		String packagesFormat = DateUtil.parseString(request,"packages","yyyy-MM-dd","yyyyMMdd");
		registers.setPackages(packagesFormat);
		registersManager.save(registers);
		return returnUrl;////LIST_ACTION;
	}
	
	/**进入更新页面*/
	public String edit() {
		HttpServletRequest request = ServletActionContext.getRequest();
		String packages =  registers.getPackages();
		String packagesFormat = DateUtil.parseString(packages,"yyyyMMdd","yyyy-MM-dd");
		registers.setPackages(packagesFormat);
		return EDIT_JSP;
	}
	
	/**保存更新对象*/
	public String update() {
		HttpServletRequest request = ServletActionContext.getRequest();
		String packagesFormat = DateUtil.parseString(request,"packages","yyyy-MM-dd","yyyyMMdd");
		registers.setPackages(packagesFormat);
		registersManager.update(this.registers);
		return returnUrl;////LIST_ACTION;
	}
	
	/**删除对象*/
	public String delete() {
		for(int i = 0; i < items.length; i++) {
			Hashtable params = HttpUtils.parseQueryString(items[i]);
			Long id = new Long((String)params.get("unitid"));
			registersManager.removeById(id);
		}
		return returnUrl ;//LIST_ACTION;
	}

}
