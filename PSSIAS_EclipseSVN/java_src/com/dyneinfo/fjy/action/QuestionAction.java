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


public class QuestionAction extends BaseStruts2Action implements Preparable,ModelDriven{
	//默认多列排序,example: username desc,createTime asc
	protected static final String DEFAULT_SORT_COLUMNS = null; 
	
	//forward paths
	protected static final String QUERY_JSP = "/pages/fjy/Question/query.jsp";
	protected static final String LIST_JSP= "/pages/fjy/Question/list.jsp";
	protected static final String CREATE_JSP = "/pages/fjy/Question/create.jsp";
	protected static final String EDIT_JSP = "/pages/fjy/Question/edit.jsp";
	protected static final String SHOW_JSP = "/pages/fjy/Question/show.jsp";
	//redirect paths,startWith: !
	
	
	
	protected static final String LISTALL_JSP= "/pages/fjy/Question/listAll.jsp";
	protected static final String EDITALL_JSP = "/pages/fjy/Question/editAll.jsp";
	protected static final String SHOWALL_JSP = "/pages/fjy/Question/showAll.jsp";
	
	protected static final String LISTALL_ACTION = "!/pages/fjy/Question/listAll.do";
	
	private QuestionManager questionManager;
	
	private Question question;
	Long id = null;
	private String[] items;
	private String returnUrl;  //返回列表，保留查询条件
	private TreeMap<String, String> dateSelectMap;// //日期选择

	public void prepare() throws Exception {
		if (isNullOrEmptyString(id)) {
			question = new Question();
		} else {
			question = (Question)questionManager.getById(id);
		}
	}
	
	/** 增加setXXXX()方法,spring就可以通过autowire自动设置对象属性 */
	public void setQuestionManager(QuestionManager manager) {
		this.questionManager = manager;
	}	
	
	public Object getModel() {
		return question;
	}
	
	public void setXh(Long val) {
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
		
		pageRequest.getFilters().put("flag","1");
        if(SpringTagFunctions.ifAnyGranted("ROLE_QUERY_ALL,ROLE_ADMIN")){
			
		} else if(SpringTagFunctions.ifAnyGranted("ROLE_QUERY_CURRENT_ORG")){
			pageRequest.getFilters().put("deptid",deptid);
		} else if(SpringTagFunctions.ifAnyGranted("ROLE_QUERY_CHILD_ORG")){
			pageRequest.getFilters().put("deptSeq",deptseq);
		} else {
			pageRequest.getFilters().put("deptid",deptid);
		}
		dateSelectMap  = DateUtil.getDateSelectData();
		String dateSelect1 = "";
		if (request.getParameter("dateSelect1") != null)
		    dateSelect1 = request.getParameter("dateSelect1");
			request.setAttribute("dateSelect1",dateSelect1);		        
		String s_wtsjBeginFormat = DateUtil.parseString(request,"s_wtsjBegin","yyyy-MM-dd HH:mm:ss","yyyyMMddHHmmss");
		String s_wtsjEndFormat = DateUtil.parseString(request,"s_wtsjEnd","yyyy-MM-dd HH:mm:ss","yyyyMMddHHmmss");
		pageRequest.getFilters().put("wtsjBeginFormat",s_wtsjBeginFormat);
		pageRequest.getFilters().put("wtsjEndFormat",s_wtsjEndFormat);
		String dateSelect6 = "";
		if (request.getParameter("dateSelect6") != null)
		    dateSelect6 = request.getParameter("dateSelect6");
			request.setAttribute("dateSelect6",dateSelect6);		        
		String s_jdsjBeginFormat = DateUtil.parseString(request,"s_jdsjBegin","yyyy-MM-dd HH:mm:ss","yyyyMMddHHmmss");
		String s_jdsjEndFormat = DateUtil.parseString(request,"s_jdsjEnd","yyyy-MM-dd HH:mm:ss","yyyyMMddHHmmss");
		pageRequest.getFilters().put("jdsjBeginFormat",s_jdsjBeginFormat);
		pageRequest.getFilters().put("jdsjEndFormat",s_jdsjEndFormat);
		
		Page page = questionManager.findByPageRequest(pageRequest);
		savePage(page,pageRequest);
		return LIST_JSP;
	}
	
	/** 查看对象*/
	public String show() {
		HttpServletRequest request = ServletActionContext.getRequest();
		String wtsj =  question.getWtsj();
		String wtsjFormat = DateUtil.parseString(wtsj,"yyyyMMddHHmmss","yyyy-MM-dd HH:mm:ss");
		question.setWtsj(wtsjFormat);
		String jdsj =  question.getJdsj();
		String jdsjFormat = DateUtil.parseString(jdsj,"yyyyMMddHHmmss","yyyy-MM-dd HH:mm:ss");
		question.setJdsj(jdsjFormat);
		return SHOW_JSP;
	}
	
	/** 进入新增页面*/
	public String create() {
		return CREATE_JSP;
	}
	
	/** 保存新增对象 */
	public String save() {
		HttpServletRequest request = ServletActionContext.getRequest();
		
		
		
		String username = "";
		String deptid = "";
	    String deptseq = "";
		MyUserDetails userDetail = null;
		userDetail = SpringTagFunctions.getUserDetails();
		if (userDetail != null) {
			username = userDetail.getUsername();
			deptid = userDetail.getDeptID();
			deptseq = userDetail.getDeptSeq();
		}
		
		String ip = request.getRemoteAddr();
		
		Date date = new Date();
		SimpleDateFormat format = new SimpleDateFormat("yyyyMMddHHmmss");
		String currDate = format.format(date);
		
		question.setUsername(username);
		question.setComputerip(ip);
		question.setWtsj(currDate);
		question.setJdbz("0");
		question.setFlag("1");
		questionManager.save(question);
		return returnUrl;////LIST_ACTION;
	}
	
	/**进入更新页面*/
	public String edit() {
		HttpServletRequest request = ServletActionContext.getRequest();
		String wtsj =  question.getWtsj();
		String wtsjFormat = DateUtil.parseString(wtsj,"yyyyMMddHHmmss","yyyy-MM-dd HH:mm:ss");
		question.setWtsj(wtsjFormat);
		String jdsj =  question.getJdsj();
		String jdsjFormat = DateUtil.parseString(jdsj,"yyyyMMddHHmmss","yyyy-MM-dd HH:mm:ss");
		question.setJdsj(jdsjFormat);
		return EDIT_JSP;
	}
	
	/**保存更新对象*/
	public String update() {
		HttpServletRequest request = ServletActionContext.getRequest();
		String wtsjFormat = DateUtil.parseString(request,"wtsj","yyyy-MM-dd HH:mm:ss","yyyyMMddHHmmss");
		question.setWtsj(wtsjFormat);
		String jdsjFormat = DateUtil.parseString(request,"jdsj","yyyy-MM-dd HH:mm:ss","yyyyMMddHHmmss");
		question.setJdsj(jdsjFormat);
		questionManager.update(this.question);
		return returnUrl;////LIST_ACTION;
	}
	
	/**删除对象*/
	public String delete() {
		for(int i = 0; i < items.length; i++) {
			Hashtable params = HttpUtils.parseQueryString(items[i]);
			Long id = new Long((String)params.get("xh"));
			questionManager.removeById(id);
		}
		return returnUrl ;//LIST_ACTION;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	/** 执行搜索 */
	public String listAll() {
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
		
        if(SpringTagFunctions.ifAnyGranted("ROLE_QUERY_ALL,ROLE_ADMIN")){
			
		} else if(SpringTagFunctions.ifAnyGranted("ROLE_QUERY_CURRENT_ORG")){
			pageRequest.getFilters().put("deptid",deptid);
		} else if(SpringTagFunctions.ifAnyGranted("ROLE_QUERY_CHILD_ORG")){
			pageRequest.getFilters().put("deptSeq",deptseq);
		} else {
			pageRequest.getFilters().put("deptid",deptid);
		}
		dateSelectMap  = DateUtil.getDateSelectData();
		String dateSelect1 = "";
		if (request.getParameter("dateSelect1") != null)
		    dateSelect1 = request.getParameter("dateSelect1");
			request.setAttribute("dateSelect1",dateSelect1);		        
		String s_wtsjBeginFormat = DateUtil.parseString(request,"s_wtsjBegin","yyyy-MM-dd HH:mm:ss","yyyyMMddHHmmss");
		String s_wtsjEndFormat = DateUtil.parseString(request,"s_wtsjEnd","yyyy-MM-dd HH:mm:ss","yyyyMMddHHmmss");
		pageRequest.getFilters().put("wtsjBeginFormat",s_wtsjBeginFormat);
		pageRequest.getFilters().put("wtsjEndFormat",s_wtsjEndFormat);
		String dateSelect6 = "";
		if (request.getParameter("dateSelect6") != null)
		    dateSelect6 = request.getParameter("dateSelect6");
			request.setAttribute("dateSelect6",dateSelect6);		        
		String s_jdsjBeginFormat = DateUtil.parseString(request,"s_jdsjBegin","yyyy-MM-dd HH:mm:ss","yyyyMMddHHmmss");
		String s_jdsjEndFormat = DateUtil.parseString(request,"s_jdsjEnd","yyyy-MM-dd HH:mm:ss","yyyyMMddHHmmss");
		pageRequest.getFilters().put("jdsjBeginFormat",s_jdsjBeginFormat);
		pageRequest.getFilters().put("jdsjEndFormat",s_jdsjEndFormat);
		
		Page page = questionManager.findByPageRequest(pageRequest);
		savePage(page,pageRequest);
		return LISTALL_JSP;
	}
	
	/** 查看对象*/
	public String showAll() {
		HttpServletRequest request = ServletActionContext.getRequest();
		String wtsj =  question.getWtsj();
		String wtsjFormat = DateUtil.parseString(wtsj,"yyyyMMddHHmmss","yyyy-MM-dd HH:mm:ss");
		question.setWtsj(wtsjFormat);
		String jdsj =  question.getJdsj();
		String jdsjFormat = DateUtil.parseString(jdsj,"yyyyMMddHHmmss","yyyy-MM-dd HH:mm:ss");
		question.setJdsj(jdsjFormat);
		return SHOWALL_JSP;
	}
	

	

	
	/**进入更新页面*/
	public String editAll() {
		HttpServletRequest request = ServletActionContext.getRequest();
		String wtsj =  question.getWtsj();
		String wtsjFormat = DateUtil.parseString(wtsj,"yyyyMMddHHmmss","yyyy-MM-dd HH:mm:ss");
		question.setWtsj(wtsjFormat);
		String jdsj =  question.getJdsj();
		String jdsjFormat = DateUtil.parseString(jdsj,"yyyyMMddHHmmss","yyyy-MM-dd HH:mm:ss");
		question.setJdsj(jdsjFormat);
		return EDITALL_JSP;
	}
	
	/**保存更新对象*/
	public String updateAll() {
		HttpServletRequest request = ServletActionContext.getRequest();
		String wtsjFormat = DateUtil.parseString(request,"wtsj","yyyy-MM-dd HH:mm:ss","yyyyMMddHHmmss");
		question.setWtsj(wtsjFormat);
		
		
		
		String UserXm = "";
		String deptid = "";
	    String deptseq = "";
		MyUserDetails userDetail = null;
		userDetail = SpringTagFunctions.getUserDetails();
		if (userDetail != null) {
			UserXm = userDetail.getUserXm();
			deptid = userDetail.getDeptID();
			deptseq = userDetail.getDeptSeq();
		}
		
		String ip = request.getRemoteAddr();
		
		Date date = new Date();
		SimpleDateFormat format = new SimpleDateFormat("yyyyMMddHHmmss");
		String currDate = format.format(date);
		question.setJdsj(currDate);
		question.setJdr(UserXm);
		questionManager.update(this.question);
		return returnUrl;////LIST_ACTION;
	}

}
