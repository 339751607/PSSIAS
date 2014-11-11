/*
 * Powered By [lishicheng]
 */

package com.dyneinfo.zazh.action;

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
import java.io.PrintWriter;
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

import com.dyneinfo.zazh.model.*;
import com.dyneinfo.zazh.dao.*;
import com.dyneinfo.zazh.service.*;
import com.google.gson.Gson;

/**
 * @author lisc email:lishicheng(a)gmail.com
 */


public class TcarlogAction extends BaseStruts2Action implements Preparable,ModelDriven{
	//默认多列排序,example: username desc,createTime asc
	protected static final String DEFAULT_SORT_COLUMNS = null; 
	
	//forward paths
	protected static final String QUERY_JSP = "/pages/zazh/Tcarlog/query.jsp";
	protected static final String LIST_JSP= "/pages/zazh/Tcarlog/list.jsp";
	protected static final String ITEMLIST_JSP= "/pages/zazh/Tcarlog/itemlist.jsp";
	protected static final String CREATE_JSP = "/pages/zazh/Tcarlog/create.jsp";
	protected static final String EDIT_JSP = "/pages/zazh/Tcarlog/edit.jsp";
	protected static final String SHOW_JSP = "/pages/zazh/Tcarlog/show.jsp";
	//redirect paths,startWith: !
	protected static final String LIST_ACTION = "!/pages/zazh/Tcarlog/list.do";
	
	private TcarlogManager tcarlogManager;
	
	private Tcarlog tcarlog;
	java.lang.Long id = null;
	private String[] items;
	private String returnUrl;  //返回列表，保留查询条件
	private TreeMap<String, String> dateSelectMap;// //日期选择

	public void prepare() throws Exception {
		if (isNullOrEmptyString(id)) {
			tcarlog = new Tcarlog();
		} else {
			tcarlog = (Tcarlog)tcarlogManager.getById(id);
		}
	}
	
	/** 增加setXXXX()方法,spring就可以通过autowire自动设置对象属性 */
	public void setTcarlogManager(TcarlogManager manager) {
		this.tcarlogManager = manager;
	}	
	
	public Object getModel() {
		return tcarlog;
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
		String dateSelect6 = "";
		if (request.getParameter("dateSelect6") != null)
		    dateSelect6 = request.getParameter("dateSelect6");
			request.setAttribute("dateSelect6",dateSelect6);		        
		String dateSelect7 = "";
		if (request.getParameter("dateSelect7") != null)
		    dateSelect7 = request.getParameter("dateSelect7");
			request.setAttribute("dateSelect7",dateSelect7);		        
		
		Page page = tcarlogManager.findByPageRequest(pageRequest);
		savePage(page,pageRequest);
		return LIST_JSP;
	}
	/** 执行搜索 */
	public String itemlist() {
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
		String dateSelect9 = "";
		if (request.getParameter("dateSelect9") != null)
		    dateSelect9 = request.getParameter("dateSelect9");
			request.setAttribute("dateSelect9",dateSelect9);		        
		String dateSelect10 = "";
		if (request.getParameter("dateSelect10") != null)
		    dateSelect10 = request.getParameter("dateSelect10");
			request.setAttribute("dateSelect10",dateSelect10);		        
		
		Page page = tcarlogManager.findLogsInfoByPageRequestForItem(pageRequest);
		savePage(page,pageRequest);
		return ITEMLIST_JSP;
	}
	public String getLogJnCount() {
		
		HttpServletRequest request = ServletActionContext.getRequest();
		
		String s_source = request.getParameter("s_source")==null?"":request.getParameter("s_source");	
		String s_carid = request.getParameter("s_carid")==null?"":request.getParameter("s_carid");		
		String s_starttime = request.getParameter("s_starttime")==null?"":request.getParameter("s_starttime");
		String s_endtime = request.getParameter("s_endtime")==null?"":request.getParameter("s_endtime");

		Map infoMap = new HashMap();
		if(!"".equals(s_source)){						
			List mapList = tcarlogManager.getLogCountByBusinessCode(s_source,s_carid, s_starttime, s_endtime);						
		    if(mapList!=null && mapList.size() > 0 ){
			    for(int i=0; i < mapList.size(); i++){
						HashMap map = (HashMap)mapList.get(i);
						if(map != null){
						   infoMap.put(map.get("code"), map);
						}
			    }					
		    }
		}
		
		
		Gson gson = new Gson();
		String json = gson.toJson(infoMap);
		
		HttpServletResponse response = ServletActionContext.getResponse();
		
		// 在取得out对象之前必须先进行设置
		response.setContentType("text/json");
		response.setHeader("Cache-Control", "no-cache");
		response.setCharacterEncoding("UTF-8");
		PrintWriter out;
		try {
			out = response.getWriter();
			out.write(json);
			out.flush();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

       return null;
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
		tcarlogManager.save(tcarlog);
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
		tcarlogManager.update(this.tcarlog);
		return returnUrl;////LIST_ACTION;
	}
	
	/**删除对象*/
	public String delete() {
		for(int i = 0; i < items.length; i++) {
			Hashtable params = HttpUtils.parseQueryString(items[i]);
			java.lang.Long id = new java.lang.Long((String)params.get("id"));
			tcarlogManager.removeById(id);
		}
		return returnUrl ;//LIST_ACTION;
	}

}
