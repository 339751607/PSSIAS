/*
 * Powered By [lishicheng]
 */

package com.dyneinfo.fjy.action;

import java.util.Hashtable;
import java.util.Map;
import java.util.TreeMap;

import javacommon.base.BaseStruts2Action;

import javax.servlet.http.HttpServletRequest;

import net.java.dev.common.dict.taglib.DictHelpImpl;
import net.java.dev.common.util.DateUtil;
import net.java.dev.common.util.SpringTagFunctions;

import org.apache.struts2.ServletActionContext;
import org.security.userdetails.MyUserDetails;

import cn.org.rapid_framework.page.Page;
import cn.org.rapid_framework.page.PageRequest;
import cn.org.rapid_framework.web.util.HttpUtils;

import com.dyneinfo.fjy.model.TcheckEmployee;
import com.dyneinfo.fjy.service.TcheckEmployeeManager;
import com.dyneinfo.zazh.service.SsCommonManager;
import com.opensymphony.xwork2.ModelDriven;
import com.opensymphony.xwork2.Preparable;

/**
 * @author lisc email:lishicheng(a)gmail.com
 */


public class TcheckEmployeeAction extends BaseStruts2Action implements Preparable,ModelDriven{
	//默认多列排序,example: username desc,createTime asc
	protected static final String DEFAULT_SORT_COLUMNS = null; 
	
	//forward paths
	protected static final String QUERY_JSP = "/pages/fjy/TcheckEmployee/query.jsp";
	protected static final String LIST_JSP= "/pages/fjy/TcheckEmployee/list.jsp";
	protected static final String CREATE_JSP = "/pages/fjy/TcheckEmployee/create.jsp";
	protected static final String EDIT_JSP = "/pages/fjy/TcheckEmployee/edit.jsp";
	protected static final String SHOW_JSP = "/pages/fjy/TcheckEmployee/show.jsp";
	//redirect paths,startWith: !
	protected static final String LIST_ACTION = "!/pages/fjy/TcheckEmployee/list.do";
	
	private TcheckEmployeeManager tcheckEmployeeManager;
	
	private TcheckEmployee tcheckEmployee;
	java.lang.Long id = null;
	private String[] items;
	private String returnUrl;  //返回列表，保留查询条件
	private TreeMap<String, String> dateSelectMap;// //日期选择
	private SsCommonManager ssCommonManager;


	public void prepare() throws Exception {
		if (isNullOrEmptyString(id)) {
			tcheckEmployee = new TcheckEmployee();
		} else {
			tcheckEmployee = (TcheckEmployee)tcheckEmployeeManager.getById(id);
		}
	}
	
	/** 增加setXXXX()方法,spring就可以通过autowire自动设置对象属性 */
	public void setTcheckEmployeeManager(TcheckEmployeeManager manager) {
		this.tcheckEmployeeManager = manager;
	}	
	
	public Object getModel() {
		return tcheckEmployee;
	}
	
	public void setId(java.lang.Long val) {
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
		
		String username = "";
		String deptid = "";
		MyUserDetails userDetail = null;
		userDetail = SpringTagFunctions.getUserDetails();
		if (userDetail != null) {
			username = userDetail.getUserName();
			deptid = userDetail.getDeptID();
		}
		
		if(!SpringTagFunctions.ifAnyGranted("ROLE_QUERY_ALL,ROLE_ADMIN")){
			pageRequest.getFilters().put("deptid",deptid);
			pageRequest.getFilters().put("deptLength",deptid.length());
		}	
		dateSelectMap  = DateUtil.getDateSelectData();
		
		Page page = tcheckEmployeeManager.findByPageRequest(pageRequest);
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
		String idcard = "";
		if (request.getParameter("idcard") != null)
			idcard = request.getParameter("idcard");
		if(tcheckEmployee.getDeptid()==null||tcheckEmployee.getDeptid().equals(""))tcheckEmployee.setDeptid(DictHelpImpl.getInitData("mpcode"));
		int count = tcheckEmployeeManager.getCountByIdcard(idcard);
		if(count < 1)
		  tcheckEmployeeManager.save(tcheckEmployee);
		return returnUrl;////LIST_ACTION;
	}
	
	/**进入更新页面*/
	public String edit() {
		HttpServletRequest request = ServletActionContext.getRequest();
		request.setAttribute("deptseq", ssCommonManager.getDeptDeptseq(tcheckEmployee.getDeptid()));
		return EDIT_JSP;
	}
	
	/**保存更新对象*/
	public String update() {
		HttpServletRequest request = ServletActionContext.getRequest();
		if(tcheckEmployee.getDeptid()==null||tcheckEmployee.getDeptid().equals(""))tcheckEmployee.setDeptid(DictHelpImpl.getInitData("mpcode"));
		tcheckEmployeeManager.update(this.tcheckEmployee);
		return returnUrl;////LIST_ACTION;
	}
	
	/**删除对象*/
	public String delete() {
		for(int i = 0; i < items.length; i++) {
			Hashtable params = HttpUtils.parseQueryString(items[i]);
			java.lang.Long id = new java.lang.Long((String)params.get("id"));
			tcheckEmployeeManager.removeById(id);
		}
		return returnUrl ;//LIST_ACTION;
	}
	public void setSsCommonManager(SsCommonManager ssCommonManager) {
		this.ssCommonManager = ssCommonManager;
	}
}
