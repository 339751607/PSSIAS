/*
 * Powered By [lishicheng]
 */

package com.dyneinfo.pmdd.action;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Hashtable;
import java.util.Map;
import java.util.TreeMap;

import javacommon.base.BaseStruts2Action;

import javax.servlet.http.HttpServletRequest;

import net.java.dev.common.util.DateUtil;
import net.java.dev.common.util.SpringTagFunctions;

import org.apache.struts2.ServletActionContext;
import org.security.userdetails.MyUserDetails;

import cn.org.rapid_framework.page.Page;
import cn.org.rapid_framework.page.PageRequest;
import cn.org.rapid_framework.web.util.HttpUtils;

import com.dyneinfo.pmdd.model.TpoliceCheck;
import com.dyneinfo.pmdd.model.TpoliceCheckinfo;
import com.dyneinfo.pmdd.service.TpoliceCheckpmddManager;
import com.opensymphony.xwork2.ModelDriven;
import com.opensymphony.xwork2.Preparable;

/**
 * @author lisc email:lishicheng(a)gmail.com
 */


public class TpoliceCheckAction extends BaseStruts2Action implements Preparable,ModelDriven{
	//默认多列排序,example: username desc,createTime asc
	protected static final String DEFAULT_SORT_COLUMNS = null; 
	
	//forward paths
	protected static final String QUERY_JSP = "/pages/pmdd/TpoliceCheck/query.jsp";
	protected static final String LIST_JSP= "/pages/pmdd/TpoliceCheck/list.jsp";
	protected static final String CREATE_JSP = "/pages/pmdd/TpoliceCheck/create.jsp";
	protected static final String EDIT_JSP = "/pages/pmdd/TpoliceCheck/edit.jsp";
	protected static final String SHOW_JSP = "/pages/pmdd/TpoliceCheck/show.jsp";
	//redirect paths,startWith: !
	protected static final String LIST_ACTION = "!/pages/pmdd/TpoliceCheck/list.do";
	
	protected static final String LISTUSER_JSP= "/pages/pmdd/TpoliceCheck/listUser.jsp";
	protected static final String CREATEUSER_JSP = "/pages/pmdd/TpoliceCheck/createUser.jsp";
	protected static final String EDITUSER_JSP = "/pages/pmdd/TpoliceCheck/editUser.jsp";
	protected static final String SHOWUSER_JSP = "/pages/pmdd/TpoliceCheck/showUser.jsp";
	protected static final String TAB_JSP = "/pages/pmdd/TpoliceCheck/tab.jsp";
	protected static final String TABUSER_JSP = "/pages/pmdd/TpoliceCheck/tabUser.jsp";
	
	private TpoliceCheckpmddManager tpoliceCheckManager;
	
	private TpoliceCheck tpoliceCheck;
	Long id = null;
	private String[] items;
	private String returnUrl;  //返回列表，保留查询条件
	private TreeMap<String, String> dateSelectMap;// //日期选择

	public void prepare() throws Exception {
		if (isNullOrEmptyString(id)) {
			tpoliceCheck = new TpoliceCheck();
		} else {
			tpoliceCheck = (TpoliceCheck)tpoliceCheckManager.getTpoliceCheckById(id);
		}
	}
	
	/** 增加setXXXX()方法,spring就可以通过autowire自动设置对象属性 */
	public void setTpoliceCheckpmddManager(TpoliceCheckpmddManager manager) {
		this.tpoliceCheckManager = manager;
	}	
	
	public Object getModel() {
		return tpoliceCheck;
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
		

		
		String username = "";
		String deptid = "";
	    String deptseq = "";
		MyUserDetails userDetail = null;
		userDetail = SpringTagFunctions.getUserDetails();
		if (userDetail != null) {
			username = userDetail.getUserName();
			deptid = userDetail.getDeptID();
			deptseq = userDetail.getDeptSeq();
		}
	
		if(SpringTagFunctions.ifAnyGranted("ROLE_HT_ADMIN,ROLE_ADMIN")){
			
		} else if(SpringTagFunctions.ifAnyGranted("ROLE_QUERY_CURRENT_ORG")){
			pageRequest.getFilters().put("deptid",deptid);
		} else if(SpringTagFunctions.ifAnyGranted("ROLE_QUERY_CHILD_ORG")){
			pageRequest.getFilters().put("deptSeq",deptseq);
		} else {
			pageRequest.getFilters().put("deptid",deptid);
		}
		
		
		dateSelectMap  = DateUtil.getDateSelectData();
		String dateSelect3 = "";
		if (request.getParameter("dateSelect3") != null)
			dateSelect3 = request.getParameter("dateSelect3");
		request.setAttribute("dateSelect3",dateSelect3);		        
		
		Page page = tpoliceCheckManager.findByPageRequest(pageRequest);
		savePage(page,pageRequest);
		return LIST_JSP;
	}
	
	public String listUser() {
		PageRequest<Map> pageRequest = newPageRequest(DEFAULT_SORT_COLUMNS);
		HttpServletRequest request = ServletActionContext.getRequest();
		//pageRequest.getFilters().put("key",value);     //add custom filter
		
		
		String username = "";
		String deptid = "";
	    String deptseq = "";
		MyUserDetails userDetail = null;
		userDetail = SpringTagFunctions.getUserDetails();
		if (userDetail != null) {
			username = userDetail.getUserName();
			deptid = userDetail.getDeptID();
			deptseq = userDetail.getDeptSeq();
		}
	
		if(SpringTagFunctions.ifAnyGranted("ROLE_HT_ADMIN,ROLE_ADMIN")){
			
		} else if(SpringTagFunctions.ifAnyGranted("ROLE_QUERY_CURRENT_ORG")){
			pageRequest.getFilters().put("deptid",deptid);
		} else if(SpringTagFunctions.ifAnyGranted("ROLE_QUERY_CHILD_ORG")){
			pageRequest.getFilters().put("deptSeq",deptseq);
		} else {
			pageRequest.getFilters().put("deptid",deptid);
		}
		String s_deptid = "";
		if (request.getParameter("s_deptid") != null){
			s_deptid = request.getParameter("s_deptid");
			request.setAttribute("s_deptid", s_deptid);	
		    pageRequest.getFilters().put("deptid",s_deptid);
		}

		dateSelectMap  = DateUtil.getDateSelectData();
		String dateSelect4 = "";
		if (request.getParameter("dateSelect4") != null)
		    dateSelect4 = request.getParameter("dateSelect4");
			request.setAttribute("dateSelect4",dateSelect4);		        
		
		Page page = tpoliceCheckManager.findByPageRequest(pageRequest);
		savePage(page,pageRequest);
		return LISTUSER_JSP;
	}
	
	/** 查看对象*/
	public String show() {
		HttpServletRequest request = ServletActionContext.getRequest();
		return SHOW_JSP;
	}
	
	public String showUser() {
		HttpServletRequest request = ServletActionContext.getRequest();
		return SHOWUSER_JSP;
	}
	
	/** 进入新增页面*/
	public String create() {
		Date date = new Date();
		SimpleDateFormat format_inserttime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String str_inserttime = format_inserttime.format(date);
        tpoliceCheck.setChecktimeString(str_inserttime);
        
		return CREATE_JSP;
	}
	
	public String createUser() {
		Date date = new Date();
		SimpleDateFormat format_inserttime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String str_inserttime = format_inserttime.format(date);
        tpoliceCheck.setChecktimeString(str_inserttime);
        
		
        
		return CREATEUSER_JSP;
	}
	
	/** 保存新增对象 */
	public String save() {
		HttpServletRequest request = ServletActionContext.getRequest();
		
		Long checkinfoid = tpoliceCheckManager.getSeqCheckinfo();
		Long checkid = tpoliceCheckManager.getSeq();
		tpoliceCheck.setCheckid(checkid);
		TpoliceCheckinfo tpoliceCheckinfo = new TpoliceCheckinfo();
		tpoliceCheckinfo.setCheckid(checkid);
		tpoliceCheckinfo.setCheckinfoid(checkinfoid);
		String item = "";
		if (request.getParameter("item") != null)
			item = request.getParameter("item");
		
		String detail = "";
		if (request.getParameter("detail") != null)
			detail = request.getParameter("detail");
		
		tpoliceCheckinfo.setDetail(detail);
		tpoliceCheckinfo.setItem(item);
		
		tpoliceCheckManager.saveTpoliceCheckAndCheckInfo(tpoliceCheckinfo,tpoliceCheck);
		return returnUrl;////LIST_ACTION;
	}
	
	public String saveUser() {
		String username = "";
		String deptid = "";
		MyUserDetails userDetail = null;
		userDetail = SpringTagFunctions.getUserDetails();
		if (userDetail != null) {
			username = userDetail.getUserName();
			deptid = userDetail.getDeptID();
		}
		
		tpoliceCheck.setDeptid(Long.parseLong(deptid));
		tpoliceCheckManager.save(tpoliceCheck);
		return returnUrl;////LIST_ACTION;
	}
	
	/**进入更新页面*/
	public String edit() {
		HttpServletRequest request = ServletActionContext.getRequest();
		return EDIT_JSP;
	}
	
	public String editUser() {
		HttpServletRequest request = ServletActionContext.getRequest();
		return EDITUSER_JSP;
	}
	
	/**保存更新对象*/
	public String update() {
		HttpServletRequest request = ServletActionContext.getRequest();
		tpoliceCheckManager.update(this.tpoliceCheck);
		return returnUrl;////LIST_ACTION;
	}
	
	/**删除对象*/
	public String delete() {
		for(int i = 0; i < items.length; i++) {
			Hashtable params = HttpUtils.parseQueryString(items[i]);
			Long id = new Long((String)params.get("checkid"));
			tpoliceCheckManager.removeById(id);
		}
		return returnUrl ;//LIST_ACTION;
	}
	
	public String tab() {
		return TAB_JSP;
	}
	public String tabUser() {
		return TABUSER_JSP;
	}
	

}
