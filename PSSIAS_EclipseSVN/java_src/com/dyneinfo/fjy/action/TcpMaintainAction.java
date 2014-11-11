/*
 * Powered By [lishicheng]
 */

package com.dyneinfo.fjy.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cn.org.rapid_framework.beanutils.BeanUtils;
import com.opensymphony.xwork2.Preparable;
import com.opensymphony.xwork2.ModelDriven;
import org.apache.struts2.ServletActionContext;

import org.security.userdetails.MyUserDetails;
import net.java.dev.common.util.DateUtil;
import net.java.dev.common.util.SpringTagFunctions;

import java.text.SimpleDateFormat;
import java.util.*;

import javacommon.base.*;
import javacommon.util.*;

import cn.org.rapid_framework.util.*;
import cn.org.rapid_framework.web.util.*;
import cn.org.rapid_framework.page.*;
import cn.org.rapid_framework.page.impl.*;

import com.dyneinfo.fjy.model.*;
import com.dyneinfo.fjy.dao.*;
import com.dyneinfo.fjy.service.*;

/**
 * @author lisc email:lishicheng(a)gmail.com
 */


public class TcpMaintainAction extends BaseStruts2Action implements Preparable,ModelDriven{
	//默认多列排序,example: username desc,createTime asc
	protected static final String DEFAULT_SORT_COLUMNS = " MAINTAINTIME desc "; 
	
	//forward paths
	protected static final String QUERY_JSP = "/pages/fjy/TcpMaintain/query.jsp";
	protected static final String LIST_JSP= "/pages/fjy/TcpMaintain/list.jsp";
	protected static final String CREATE_JSP = "/pages/fjy/TcpMaintain/create.jsp";
	protected static final String EDIT_JSP = "/pages/fjy/TcpMaintain/edit.jsp";
	protected static final String SHOW_JSP = "/pages/fjy/TcpMaintain/show.jsp";
	//redirect paths,startWith: !
	protected static final String LIST_ACTION = "!/pages/fjy/TcpMaintain/list.do";
	
	protected static final String TAB_JSP = "/pages/fjy/TcpMaintain/tab.jsp";
	
	private TcpMaintainManager tcpMaintainManager;
	
	private TcpMaintain tcpMaintain;
	java.lang.Long id = null;
	private String[] items;
	private String returnUrl;  //返回列表，保留查询条件
	private TreeMap<String, String> dateSelectMap;// //日期选择

	public void prepare() throws Exception {
		if (isNullOrEmptyString(id)) {
			tcpMaintain = new TcpMaintain();
		} else {
			tcpMaintain = (TcpMaintain)tcpMaintainManager.getById(id);
		}
	}
	
	/** 增加setXXXX()方法,spring就可以通过autowire自动设置对象属性 */
	public void setTcpMaintainManager(TcpMaintainManager manager) {
		this.tcpMaintainManager = manager;
	}	
	
	public Object getModel() {
		return tcpMaintain;
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
		String dateSelect2 = "";
		if (request.getParameter("dateSelect2") != null)
		    dateSelect2 = request.getParameter("dateSelect2");
			request.setAttribute("dateSelect2",dateSelect2);		        
		String s_maintaintimeBeginFormat = DateUtil.parseString(request,"s_maintaintimeBegin","yyyy-MM-dd","yyyyMMdd");
		String s_maintaintimeEndFormat = DateUtil.parseString(request,"s_maintaintimeEnd","yyyy-MM-dd","yyyyMMdd");
		pageRequest.getFilters().put("maintaintimeBeginFormat",s_maintaintimeBeginFormat+"000000");
		pageRequest.getFilters().put("maintaintimeEndFormat",s_maintaintimeEndFormat+"235959");
		
		Page page = tcpMaintainManager.findByPageRequest(pageRequest);
		savePage(page,pageRequest);
		return LIST_JSP;
	}
	
	/** 查看对象*/
	public String show() {
		HttpServletRequest request = ServletActionContext.getRequest();
		String maintaintime =  tcpMaintain.getMaintaintime();
		String maintaintimeFormat = DateUtil.parseString(maintaintime,"yyyyMMddHHmmss","yyyy-MM-dd HH:mm:ss");
		tcpMaintain.setMaintaintime(maintaintimeFormat);
		return SHOW_JSP;
	}
	
	/** 进入新增页面*/
	public String create() {
		return CREATE_JSP;
	}
	
	/** 保存新增对象 */
	public void save() {
		//System.out.println("id11111111111111111111111111111111111111111"+id);
		HttpServletRequest request = ServletActionContext.getRequest();
		String deptid = "";
		if (request.getParameter("deptid") != null)
			deptid = request.getParameter("deptid");
		
		String idcard = "";
		if (request.getParameter("idcard") != null)
			idcard = request.getParameter("idcard");
		
		String[] mtItemsArr =null;
		if (request.getParameterValues("mtItems") != null)
			mtItemsArr = request.getParameterValues("mtItems");
		
		String[] checkItemsArr =null;
		if (request.getParameterValues("checkItems") != null)
			checkItemsArr = request.getParameterValues("checkItems");
		
		String memo = "";
		if (request.getParameter("memo") != null)
			memo = request.getParameter("memo");
		//System.out.println("id=========================================="+id);
		Date date = new Date();
		SimpleDateFormat format = new SimpleDateFormat("yyyyMMddHHmmss");
		String currDate = format.format(date);
		tcpMaintain.setMaintaintime(currDate);
		tcpMaintain.setDemo(memo);
		Long id = tcpMaintainManager.getSeq();
		tcpMaintain.setId(id);
		//System.out.println("22222222222222222===="+id);
		tcpMaintainManager.saveCpCheck(tcpMaintain,id,mtItemsArr);
		
		
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("text/html;charset=GBK");
		try {
			response.setContentType("text/html;charset=GBK");
			response.getWriter().print(
					"<script>alert(\" 保存成功！ \");window.parent.document.getElementById(\"idcard\").value=\"\";window.parent.document.getElementById(\"submitButton\").disabled = false;window.close();</script>");
		} catch (Exception ex) {

		}
	}
	
	/**进入更新页面*/
	public String edit() {
		HttpServletRequest request = ServletActionContext.getRequest();
		String maintaintime =  tcpMaintain.getMaintaintime();
		String maintaintimeFormat = DateUtil.parseString(maintaintime,"yyyyMMddHHmmss","yyyy-MM-dd HH:mm:ss");
		tcpMaintain.setMaintaintime(maintaintimeFormat);
		return EDIT_JSP;
	}
	
	/**保存更新对象*/
	public String update() {
		HttpServletRequest request = ServletActionContext.getRequest();
		String maintaintimeFormat = DateUtil.parseString(request,"maintaintime","yyyy-MM-dd HH:mm:ss","yyyyMMddHHmmss");
		tcpMaintain.setMaintaintime(maintaintimeFormat);
		tcpMaintainManager.update(this.tcpMaintain);
		return returnUrl;////LIST_ACTION;
	}
	
	/**删除对象*/
	public String delete() {
		for(int i = 0; i < items.length; i++) {
			Hashtable params = HttpUtils.parseQueryString(items[i]);
			java.lang.Long id = new java.lang.Long((String)params.get("id"));
			tcpMaintainManager.removeById(id);
		}
		return returnUrl ;//LIST_ACTION;
	}
	
	public String tab() {
		HttpServletRequest request = ServletActionContext.getRequest();
		String checkid = "";
		if (request.getParameter("checkid") != null)
			checkid = request.getParameter("checkid");
		Long long_checkid = Long.parseLong(checkid);
		tcpMaintain = (TcpMaintain)tcpMaintainManager.getById(long_checkid);
		String maintaintime =  tcpMaintain.getMaintaintime();
		String maintaintimeFormat = DateUtil.parseString(maintaintime,"yyyyMMddHHmmss","yyyy-MM-dd HH:mm:ss");
		tcpMaintain.setMaintaintime(maintaintimeFormat);
		return TAB_JSP;
	}

}
