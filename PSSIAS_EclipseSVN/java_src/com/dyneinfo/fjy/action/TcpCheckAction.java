/*
 * Powered By [lishicheng]
 */

package com.dyneinfo.fjy.action;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Hashtable;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.TreeMap;

import javacommon.base.BaseStruts2Action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.java.dev.common.dict.taglib.DictHelpImpl;
import net.java.dev.common.util.DateUtil;
import net.java.dev.common.util.SpringTagFunctions;

import org.apache.struts2.ServletActionContext;
import org.security.userdetails.MyUserDetails;

import cn.org.rapid_framework.page.Page;
import cn.org.rapid_framework.page.PageRequest;
import cn.org.rapid_framework.web.util.HttpUtils;

import com.dyneinfo.fjy.model.TcpCheck;
import com.dyneinfo.fjy.service.TcpCheckManager;
import com.dyneinfo.zazh.model.DictItem;
import com.opensymphony.xwork2.ModelDriven;
import com.opensymphony.xwork2.Preparable;

/**
 * @author lisc email:lishicheng(a)gmail.com
 */


public class TcpCheckAction extends BaseStruts2Action implements Preparable,ModelDriven{
	//默认多列排序,example: username desc,createTime asc
	protected static final String DEFAULT_SORT_COLUMNS = "CHECKTIME desc "; 
	
	//forward paths
	protected static final String QUERY_JSP = "/pages/fjy/TcpCheck/query.jsp";
	protected static final String LIST_JSP= "/pages/fjy/TcpCheck/list.jsp";
	protected static final String CREATE_JSP = "/pages/fjy/TcpCheck/create.jsp";
	protected static final String EDIT_JSP = "/pages/fjy/TcpCheck/edit.jsp";
	protected static final String SHOW_JSP = "/pages/fjy/TcpCheck/show.jsp";
	//redirect paths,startWith: !
	protected static final String LIST_ACTION = "!/pages/fjy/TcpCheck/list.do";
	
	protected static final String TAB_JSP = "/pages/fjy/TcpCheck/tab.jsp";
	
	private TcpCheckManager tcpCheckManager;
	
	private TcpCheck tcpCheck;
	java.lang.Long id = null;
	private String[] items;
	private String returnUrl;  //返回列表，保留查询条件
	private TreeMap<String, String> dateSelectMap;// //日期选择
	private List<DictItem> listCpMainTainItem;//存所有的选项 
	private List<DictItem> listCpCheckItem;//存所有的选项 

	public void prepare() throws Exception {
		if (isNullOrEmptyString(id)) {
			tcpCheck = new TcpCheck();
		} else {
			tcpCheck = (TcpCheck)tcpCheckManager.getById(id);
		}
	}
	
	/** 增加setXXXX()方法,spring就可以通过autowire自动设置对象属性 */
	public void setTcpCheckManager(TcpCheckManager manager) {
		this.tcpCheckManager = manager;
	}	
	
	public Object getModel() {
		return tcpCheck;
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
		String s_checktimeBeginFormat = DateUtil.parseString(request,"s_checktimeBegin","yyyy-MM-dd","yyyyMMdd");
		String s_checktimeEndFormat = DateUtil.parseString(request,"s_checktimeEnd","yyyy-MM-dd","yyyyMMdd");
		pageRequest.getFilters().put("checktimeBeginFormat",s_checktimeBeginFormat+"000000");
		pageRequest.getFilters().put("checktimeEndFormat",s_checktimeEndFormat+"235959");
		
		Page page = tcpCheckManager.findByPageRequest(pageRequest);
		savePage(page,pageRequest);
		return LIST_JSP;
	}
	
	/** 查看对象*/
	public String show() {
		HttpServletRequest request = ServletActionContext.getRequest();
		String checktime =  tcpCheck.getChecktime();
		String checktimeFormat = DateUtil.parseString(checktime,"yyyyMMddHHmmss","yyyy-MM-dd HH:mm:ss");
		tcpCheck.setChecktime(checktimeFormat);
		return SHOW_JSP;
	}
	
	/** 进入新增页面*/
	public String create() {
		
		Date date = new Date();
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String currDate = format.format(date);
		tcpCheck.setChecktime(currDate);
		Locale	locale = Locale.getDefault();
		
		  listCpMainTainItem = DictHelpImpl.getDict("D_mainTain_item",locale.toString());
		  listCpCheckItem = DictHelpImpl.getDict("D_check_item",locale.toString());
		 
		return CREATE_JSP;
	}
	
	/** 保存新增对象 */
	public void save() {
		
		//System.out.println("id=================================================================ddddd");
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
		
		Date date = new Date();
		SimpleDateFormat format = new SimpleDateFormat("yyyyMMddHHmmss");
		String currDate = format.format(date);
		tcpCheck.setChecktime(currDate);
		tcpCheck.setDemo(memo);
		
		//System.out.println("id=========================================="+id);
		
		Long id = tcpCheckManager.getSeq();
		tcpCheck.setId(id);
		
		
		System.out.println("id="+id);
		tcpCheckManager.saveCpCheck(tcpCheck,id,checkItemsArr);
		
		
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
		String checktime =  tcpCheck.getChecktime();
		String checktimeFormat = DateUtil.parseString(checktime,"yyyyMMddHHmmss","yyyy-MM-dd HH:mm:ss");
		tcpCheck.setChecktime(checktimeFormat);
		return EDIT_JSP;
	}
	
	/**保存更新对象*/
	public String update() {
		HttpServletRequest request = ServletActionContext.getRequest();
		String checktimeFormat = DateUtil.parseString(request,"checktime","yyyy-MM-dd HH:mm:ss","yyyyMMddHHmmss");
		tcpCheck.setChecktime(checktimeFormat);
		tcpCheckManager.update(this.tcpCheck);
		return returnUrl;////LIST_ACTION;
	}
	
	/**删除对象*/
	public String delete() {
		for(int i = 0; i < items.length; i++) {
			Hashtable params = HttpUtils.parseQueryString(items[i]);
			java.lang.Long id = new java.lang.Long((String)params.get("id"));
			tcpCheckManager.removeById(id);
		}
		return returnUrl ;//LIST_ACTION;
	}

	
	
	public String tab() {
		HttpServletRequest request = ServletActionContext.getRequest();
		String checkid = "";
		if (request.getParameter("checkid") != null)
			checkid = request.getParameter("checkid");
		Long long_checkid = Long.parseLong(checkid);
		tcpCheck = (TcpCheck)tcpCheckManager.getById(long_checkid);
		String checktime =  tcpCheck.getChecktime();
		String checktimeFormat = DateUtil.parseString(checktime,"yyyyMMddHHmmss","yyyy-MM-dd HH:mm:ss");
		tcpCheck.setChecktime(checktimeFormat);
		return TAB_JSP;
	}
	
	
	public List<DictItem> getListCpMainTainItem() {
		return listCpMainTainItem;
	}

	public void setListCpMainTainItem(List<DictItem> listCpMainTainItem) {
		this.listCpMainTainItem = listCpMainTainItem;
	}

	public List<DictItem> getListCpCheckItem() {
		return listCpCheckItem;
	}

	public void setListCpCheckItem(List<DictItem> listCpCheckItem) {
		this.listCpCheckItem = listCpCheckItem;
	}



}
