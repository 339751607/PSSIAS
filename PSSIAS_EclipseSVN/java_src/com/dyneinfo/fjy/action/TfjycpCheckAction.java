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

import org.security.userdetails.MyUserDetails;
import org.springframework.security.Authentication;
import org.springframework.security.context.SecurityContext;
import org.springframework.security.context.SecurityContextHolder;

import java.io.IOException;
import java.text.SimpleDateFormat;

import net.java.dev.common.dict.taglib.Util;
import net.java.dev.common.util.DateUtil;
import net.java.dev.common.util.SpringTagFunctions;

import org.apache.struts2.ServletActionContext;

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


public class TfjycpCheckAction extends BaseStruts2Action implements Preparable,ModelDriven{
	//默认多列排序,example: username desc,createTime asc
	protected static final String DEFAULT_SORT_COLUMNS = null; 
	
	//forward paths
	protected static final String QUERY_JSP = "/pages/fjy/TfjycpCheck/mjquery.jsp";
	protected static final String WHQUERY_JSP = "/pages/fjy/TfjycpCheck/whquery.jsp";
	protected static final String LIST_JSP= "/pages/fjy/TfjycpCheck/mjlist.jsp";
	protected static final String WHLIST_JSP= "/pages/fjy/TfjycpCheck/whlist.jsp";
	protected static final String CREATE_JSP = "/pages/fjy/TfjycpCheck/create.jsp";
	protected static final String WHCREATE_JSP = "/pages/fjy/TfjycpCheck/whcreate.jsp";
	protected static final String EDIT_JSP = "/pages/fjy/TfjycpCheck/edit.jsp";
	protected static final String SHOW_JSP = "/pages/fjy/TfjycpCheck/mjshow.jsp";
	protected static final String WHSHOW_JSP = "/pages/fjy/TfjycpCheck/whshow.jsp";
	protected static final String USER_LIST="/pages/fjy/TfjycpCheck/userMjList.jsp";
	protected static final String USER_SHOW="/pages/fjy/TfjycpCheck/userMjShow.jsp";
	protected static final String USER_LIST_WH="/pages/fjy/TfjycpCheck/userWhList.jsp";
	protected static final String USER_SHOW_WH="/pages/fjy/TfjycpCheck/userWhShow.jsp";

	//redirect paths,startWith: !
	protected static final String LIST_ACTION = "!/pages/fjy/TfjycpCheck/list.do";
	
	private TfjycpCheckManager tfjycpCheckManager;
	private TpoliceCheckinfoManager tpoliceCheckinfoManager;
	private TfjycpCheck tfjycpCheck;
	java.lang.String id = null;
	private String[] items;
	private String[] contents;
	private String returnUrl;  //返回列表，保留查询条件
	private TreeMap<String, String> dateSelectMap;// //日期选择

	public void prepare() throws Exception {
		HttpServletRequest request = ServletActionContext.getRequest();
		if (isNullOrEmptyString(id)&&request.getParameter("t_checktype")==null) {
			tfjycpCheck = new TfjycpCheck();
		} else {
			tfjycpCheck = (TfjycpCheck)tfjycpCheckManager.getById(id,request.getParameter("t_checktype"));
		}
	}
	
	/** 增加setXXXX()方法,spring就可以通过autowire自动设置对象属性 */
	public void setTfjycpCheckManager(TfjycpCheckManager manager) {
		this.tfjycpCheckManager = manager;
	}	
	
	public Object getModel() {
		return tfjycpCheck;
	}
	
	public void setId(java.lang.String val) {
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
	/** 进入查询页面 */
	public String whquery() {
		//日历快速选择用到
		dateSelectMap  = DateUtil.getDateSelectData();

		return WHQUERY_JSP;
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
		String sessiondeptSeq = "";
		String deptid ="";
		if ((auth != null) && auth.getPrincipal() instanceof MyUserDetails) {
			ud = (MyUserDetails) auth.getPrincipal();
			if (ud != null) {
				username = ud.getUserName();
				sessiondeptSeq = ud.getDeptSeq();
				deptid = ud.getDeptID();
			}
		}	
		
		
        if(SpringTagFunctions.ifAnyGranted("ROLE_QUERY_ALL,ROLE_ADMIN")){
			
		} else if(SpringTagFunctions.ifAnyGranted("ROLE_QUERY_CURRENT_ORG")){
			pageRequest.getFilters().put("cpcode",deptid);
		} else if(SpringTagFunctions.ifAnyGranted("ROLE_QUERY_CHILD_ORG")){
			pageRequest.getFilters().put("orgseq",sessiondeptSeq);
		} else {
			pageRequest.getFilters().put("orgseq",sessiondeptSeq);
		}

		String deptseq=request.getParameter("s_deptseq")!=null?request.getParameter("s_deptseq"):"";
		dateSelectMap  = DateUtil.getDateSelectData();
		String s_checkdateBeginFormat = DateUtil.parseString(request,"s_checkdateBegin","yyyy-MM-dd","yyyyMMdd");
		String s_checkdateEndFormat = DateUtil.parseString(request,"s_checkdateEnd","yyyy-MM-dd","yyyyMMdd");
		pageRequest.getFilters().put("checkdateBeginFormat",s_checkdateBeginFormat);
		pageRequest.getFilters().put("checkdateEndFormat",s_checkdateEndFormat);
		pageRequest.getFilters().put("checktype","1");
		pageRequest.getFilters().put("emptype","01");
		pageRequest.getFilters().put("deptseq",deptseq);
		//System.out.println("======================================"+deptseq);
		
		Page page = tfjycpCheckManager.findByPageRequest(pageRequest);
		savePage(page,pageRequest);
		return LIST_JSP;
	}
	/** 执行搜索 */
	public String whlist() {
		PageRequest<Map> pageRequest = newPageRequest(DEFAULT_SORT_COLUMNS);
		HttpServletRequest request = ServletActionContext.getRequest();
		//pageRequest.getFilters().put("key",value);     //add custom filter
		
		 SecurityContext sc = SecurityContextHolder.getContext();
	        Authentication auth = sc.getAuthentication();
	        MyUserDetails ud = null;
			String username = "";
			String sessiondeptSeq = "";
			String deptid ="";
			if ((auth != null) && auth.getPrincipal() instanceof MyUserDetails) {
				ud = (MyUserDetails) auth.getPrincipal();
				if (ud != null) {
					username = ud.getUserName();
					sessiondeptSeq = ud.getDeptSeq();
					deptid = ud.getDeptID();
				}
			}	
			
			
	        if(SpringTagFunctions.ifAnyGranted("ROLE_QUERY_ALL,ROLE_ADMIN")){
				
			} else if(SpringTagFunctions.ifAnyGranted("ROLE_QUERY_CURRENT_ORG")){
				pageRequest.getFilters().put("cpcode",deptid);
			} else if(SpringTagFunctions.ifAnyGranted("ROLE_QUERY_CHILD_ORG")){
				pageRequest.getFilters().put("orgseq",sessiondeptSeq);
			} else {
				pageRequest.getFilters().put("orgseq",sessiondeptSeq);
			}
		dateSelectMap  = DateUtil.getDateSelectData();
		String s_checkdateBeginFormat = DateUtil.parseString(request,"s_checkdateBegin","yyyy-MM-dd","yyyyMMdd");
		String s_checkdateEndFormat = DateUtil.parseString(request,"s_checkdateEnd","yyyy-MM-dd","yyyyMMdd");
		pageRequest.getFilters().put("checkdateBeginFormat",s_checkdateBeginFormat);
		pageRequest.getFilters().put("checkdateEndFormat",s_checkdateEndFormat);
		pageRequest.getFilters().put("checktype","2");
		pageRequest.getFilters().put("emptype","02");
		
		String deptseq=request.getParameter("s_deptseq")!=null?request.getParameter("s_deptseq"):"";
		pageRequest.getFilters().put("deptseq",deptseq);
		//System.out.println("======================================"+deptseq);
		Page page = tfjycpCheckManager.findByPageRequest(pageRequest);
		savePage(page,pageRequest);
		return WHLIST_JSP;
	}
	/** 执行搜索 */
	public String listUser() {
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
		String s_checkdateBeginFormat = DateUtil.parseString(request,"s_checkdateBegin","yyyy-MM-dd","yyyyMMdd");
		String s_checkdateEndFormat = DateUtil.parseString(request,"s_checkdateEnd","yyyy-MM-dd","yyyyMMdd");
		pageRequest.getFilters().put("checkdateBeginFormat",s_checkdateBeginFormat);
		pageRequest.getFilters().put("checkdateEndFormat",s_checkdateEndFormat);
		String t_checktype=request.getParameter("t_checktype")!=null?request.getParameter("t_checktype"):"";
		String t_cpcode=request.getParameter("t_cpcode")!=null?request.getParameter("t_cpcode"):deptid;
		
		pageRequest.getFilters().put("cpcode", t_cpcode);
		request.setAttribute("cs", request.getParameter("cs")!=null?request.getParameter("cs"):null);
		if(t_checktype.equals("1")){
			pageRequest.getFilters().put("checktype","1");
			pageRequest.getFilters().put("emptype","01");
			Page page = tfjycpCheckManager.findByPageRequest(pageRequest);
			savePage(page,pageRequest);
			return USER_LIST;
		}
		
		pageRequest.getFilters().put("checktype","2");
		pageRequest.getFilters().put("emptype","02");
		Page page = tfjycpCheckManager.findByPageRequest(pageRequest);
		savePage(page,pageRequest);

		return USER_LIST_WH;
	}
	
	/** 查看对象*/
	public String show() {
		HttpServletRequest request = ServletActionContext.getRequest();
		String checkdate=tfjycpCheck.getCheckdate();
		String checkdateFormat = DateUtil.parseString(checkdate,"yyyyMMdd","yyyy-MM-dd");
		tfjycpCheck.setCheckdate(checkdateFormat);
		List<TpoliceCheckinfo> checkInfoList=tpoliceCheckinfoManager.getCheckList(tfjycpCheck.getId());
		request.setAttribute("checkInfoList", checkInfoList);
		return SHOW_JSP;
	}
	/** 查看对象*/
	public String whshow() {
		HttpServletRequest request = ServletActionContext.getRequest();
		String checkdate=tfjycpCheck.getCheckdate();
		String checkdateFormat = DateUtil.parseString(checkdate,"yyyyMMdd","yyyy-MM-dd");
		tfjycpCheck.setCheckdate(checkdateFormat);
		List<TpoliceCheckinfo> checkInfoList=tpoliceCheckinfoManager.getCheckList(tfjycpCheck.getId());
		request.setAttribute("checkInfoList", checkInfoList);
		return WHSHOW_JSP;
	}
	/** 查看对象*/
	public String userShow() {
		HttpServletRequest request = ServletActionContext.getRequest();
		String checkdate=tfjycpCheck.getCheckdate();
		String checkdateFormat = DateUtil.parseString(checkdate,"yyyyMMdd","yyyy-MM-dd");
		tfjycpCheck.setCheckdate(checkdateFormat);
		List<TpoliceCheckinfo> checkInfoList=tpoliceCheckinfoManager.getCheckList(tfjycpCheck.getId());
		request.setAttribute("checkInfoList", checkInfoList);
		String t_checktype=request.getParameter("t_checktype")!=null?request.getParameter("t_checktype"):"";
		if(t_checktype.equals("2")){
			return USER_SHOW_WH;
		}
		return USER_SHOW;
	}
	/** 进入新增页面*/
	public String create() {
		HttpServletRequest request = ServletActionContext.getRequest();

		String emptype=request.getParameter("t_emptype")!=null?request.getParameter("t_emptype"):"";
		String idcard=request.getParameter("idcard")!=null?request.getParameter("idcard"):"";
		request.setAttribute("idcard", idcard);
		request.setAttribute("emptype", emptype);
		
		if(emptype.equals("02")){
			return WHCREATE_JSP;
		}
		return CREATE_JSP;
	}
	public String authentication(){
		HttpServletRequest request = ServletActionContext.getRequest();
		String ajax=request.getParameter("ajax")!=null?request.getParameter("ajax"):null;
		String idcard =request.getParameter("idcard")!=null?request.getParameter("idcard"):null;
		String emptype=request.getParameter("t_emptype")!=null?request.getParameter("t_emptype"):null;
		int s=tfjycpCheckManager.getByIdcard(idcard, emptype);
		String result=null;
		if(s>0){
			result="true";
		}
        if (result == null) {
            return null;
        }
        if(ajax!=null && ajax.equals("true")){
	        try {
	            byte[] contents = result.getBytes("UTF-8");
	            getResponse().getOutputStream().write(contents);
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	        return null;
        }

		return result;
	}
	
	/** 保存新增对象 */
	public String save() {
		HttpServletRequest request = ServletActionContext.getRequest();
		Date date = new Date();
		SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd");

		String username = "";
		String deptid = "";
		MyUserDetails userDetail = null;
		userDetail = SpringTagFunctions.getUserDetails();
		if (userDetail != null) {
			username = userDetail.getUserName();
			deptid = userDetail.getDeptID();
		}
		String currDate=format.format(date);
		String start_char = "", str_end_char = "";

		String maxID = "";
		start_char = deptid + currDate;
		String max_end_char = "0000";
		String sql = "select max(id) from t_fjycp_check where CPCODE= ? and substr(checkdate,0,8)  = '"
			+ currDate + "'";
		maxID = tfjycpCheckManager.getCurrentMax(sql, deptid);
		if (maxID != null && maxID.length() > 0) {
			max_end_char = maxID.substring(start_char.length());
		}
		int i_max_end_char = Integer.parseInt(max_end_char);
		i_max_end_char = i_max_end_char + 1;
		Integer obj = new Integer(i_max_end_char);
		str_end_char = Util.padString(obj.toString(), 4, "0", true);

		tfjycpCheck.setId(start_char + str_end_char);
			
		tfjycpCheck.setCheckdate(format.format(date));
		tfjycpCheck.setCpcode(deptid);
		tfjycpCheckManager.save(tfjycpCheck);
		TpoliceCheckinfo info=new TpoliceCheckinfo();
		info.setCheckid(tfjycpCheck.getId());
		if(items != null){
			for(int i=0;i<items.length;i++){
				info.setItem(items[i]);
				info.setDetail(contents[i]);
				
				tpoliceCheckinfoManager.save(info);
			}
		}
		
		
		
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
		tfjycpCheckManager.update(this.tfjycpCheck);
		return returnUrl;////LIST_ACTION;
	}
	
	/**删除对象*/
	public String delete() {
		for(int i = 0; i < items.length; i++) {
			Hashtable params = HttpUtils.parseQueryString(items[i]);
			java.lang.String id = new java.lang.String((String)params.get("id"));
			tfjycpCheckManager.removeById(id);
		}
		return returnUrl ;//LIST_ACTION;
	}

	public void setTpoliceCheckinfoManager(
			TpoliceCheckinfoManager tpoliceCheckinfoManager) {
		this.tpoliceCheckinfoManager = tpoliceCheckinfoManager;
	}

	public void setTfjycpCheck(TfjycpCheck tfjycpCheck) {
		this.tfjycpCheck = tfjycpCheck;
	}

	public void setContents(String[] contents) {
		this.contents = contents;
	}

	
}
