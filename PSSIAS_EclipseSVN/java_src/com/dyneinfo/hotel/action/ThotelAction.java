/*
 * Powered By [lishicheng]
 */

package com.dyneinfo.hotel.action;

import java.io.IOException;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import javacommon.base.BaseStruts2Action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.java.dev.common.util.DateUtil;

import org.apache.struts2.ServletActionContext;

import cn.org.rapid_framework.page.Page;
import cn.org.rapid_framework.page.PageRequest;
import cn.org.rapid_framework.web.util.HttpUtils;

import com.dyneinfo.hotel.model.Thotel;
import com.dyneinfo.hotel.service.ThotelManager;
import com.opensymphony.xwork2.ModelDriven;
import com.opensymphony.xwork2.Preparable;

/**
 * @author lisc email:lishicheng(a)gmail.com
 */


public class ThotelAction extends BaseStruts2Action implements Preparable,ModelDriven{
	//默认多列排序,example: username desc,createTime asc
	protected static final String DEFAULT_SORT_COLUMNS = null; 
	
	//forward paths
	protected static final String QUERY_JSP = "/pages/hotel/Thotel/query.jsp";
	protected static final String LIST_JSP= "/pages/hotel/Thotel/list.jsp";
	protected static final String LISTONLY_JSP= "/pages/hotel/Thotel/listOnly.jsp";
	protected static final String LISTONLYOFNULLINFO_JSP= "/pages/hotel/Thotel/listOnlyOfNullInfo.jsp";
	protected static final String CREATE_JSP = "/pages/hotel/Thotel/create.jsp";
	protected static final String EDIT_JSP = "/pages/hotel/Thotel/edit.jsp";
	protected static final String SHOW_JSP = "/pages/hotel/Thotel/show.jsp";
	//redirect paths,startWith: !
	protected static final String LIST_ACTION = "!/pages/hotel/Thotel/list.do";
	
	private ThotelManager thotelManager;
	
	private Thotel thotel;
	java.lang.String id = null;
	private String[] items;
	private String returnUrl;  //返回列表，保留查询条件
	private TreeMap<String, String> dateSelectMap;// //日期选择

	public void prepare() throws Exception {
		if (isNullOrEmptyString(id)) {
			thotel = new Thotel();
		} else {
			thotel = (Thotel)thotelManager.getById(id);
		}
	}
	
	/** 增加setXXXX()方法,spring就可以通过autowire自动设置对象属性 */
	public void setThotelManager(ThotelManager manager) {
		this.thotelManager = manager;
	}	
	
	public Object getModel() {
		return thotel;
	}
	
	public void setCode(java.lang.String val) {
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

		dateSelectMap  = DateUtil.getDateSelectData();
		if (request.getParameter("dateSelect1") != null)
			request.setAttribute("dateSelect1", request.getParameter("dateSelect1"));
		if (request.getParameter("s_modTime_Begin") != null)
			pageRequest.getFilters().put("modTime_BeginFormat",
					DateUtil.parseString(request,"s_modTime_Begin", "yyyy-MM-dd", "yyyyMMdd"));
		if (request.getParameter("s_modTime_End") != null)
			pageRequest.getFilters().put("modTime_EndFormat",
					DateUtil.parseString(request,"s_modTime_End", "yyyy-MM-dd", "yyyyMMdd"));
		if (null ==  request.getParameter("s_bedNum_Begin") || request.getParameter("s_bedNum_Begin").equals(""))
			pageRequest.getFilters().put("bedNum_Begin",0);
		
		Page page = thotelManager.findByPageRequest(pageRequest);
		savePage(page,pageRequest);
		return LIST_JSP;
	}
	public String listOnly() {
		PageRequest<Map> pageRequest = newPageRequest(DEFAULT_SORT_COLUMNS);
		HttpServletRequest request = ServletActionContext.getRequest();
		
		dateSelectMap  = DateUtil.getDateSelectData();
		if (request.getParameter("dateSelect1") != null)
			request.setAttribute("dateSelect1", request.getParameter("dateSelect1"));
		if (request.getParameter("s_modTime_Begin") != null)
			pageRequest.getFilters().put("modTime_BeginFormat",
					DateUtil.parseString(request,"s_modTime_Begin", "yyyy-MM-dd", "yyyyMMdd"));
		if (request.getParameter("s_modTime_End") != null){
			pageRequest.getFilters().put("modTime_EndFormat",
					DateUtil.parseString(request,"s_modTime_End", "yyyy-MM-dd", "yyyyMMdd"));
		}else{
			pageRequest.getFilters().put("modTime_EndFormat",DateUtil.getNowTime("yyyyMMdd"));
		}
		if (null ==  request.getParameter("s_bedNum_Begin") || request.getParameter("s_bedNum_Begin").equals(""))
			pageRequest.getFilters().put("bedNum_Begin",0);
		
		Page page = thotelManager.findHotelByStatus(pageRequest);
		savePage(page,pageRequest);
		return LISTONLY_JSP;
	}
	public String listOnlyOfNullInfo() {
		PageRequest<Map> pageRequest = newPageRequest(DEFAULT_SORT_COLUMNS);
		HttpServletRequest request = ServletActionContext.getRequest();
		
		dateSelectMap  = DateUtil.getDateSelectData();
		if (request.getParameter("dateSelect1") != null)
			request.setAttribute("dateSelect1", request.getParameter("dateSelect1"));
		if (request.getParameter("s_modTime_Begin") != null)
			pageRequest.getFilters().put("modTime_BeginFormat",
					DateUtil.parseString(request,"s_modTime_Begin", "yyyy-MM-dd", "yyyyMMdd"));
		if (request.getParameter("s_modTime_End") != null){
			pageRequest.getFilters().put("modTime_EndFormat",
					DateUtil.parseString(request,"s_modTime_End", "yyyy-MM-dd", "yyyyMMdd"));
		}else{
			pageRequest.getFilters().put("modTime_EndFormat",DateUtil.getNowTime("yyyyMMdd"));
		}
		
		Page page = thotelManager.findHotelOfNullInfo(pageRequest);
		savePage(page,pageRequest);
		return LISTONLYOFNULLINFO_JSP;
	}
	
	/** 查看对象*/
	public String show() {
		HttpServletRequest request = ServletActionContext.getRequest();
		thotel.setModTime(DateUtil.parseString(thotel.getModTime(), "yyyyMMdd","yyyy-MM-dd"));
		return SHOW_JSP;
	}
	
	/** 进入新增页面*/
	public String create() {
		return CREATE_JSP;
	}
	
	/** 保存新增对象 */
	public String save() {
		HttpServletRequest request = ServletActionContext.getRequest();
		thotelManager.save(thotel);
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
		thotelManager.update(this.thotel);
		return returnUrl;////LIST_ACTION;
	}
	
	/**删除对象*/
	public String delete() {
		for(int i = 0; i < items.length; i++) {
			Hashtable params = HttpUtils.parseQueryString(items[i]);
			java.lang.String id = new java.lang.String((String)params.get("code"));
			thotelManager.removeById(id);
		}
		return returnUrl ;//LIST_ACTION;
	}
	
	public void getHotelNameBySta() throws IOException{
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("text/html;charset=UTF-8"); 
		String key = request.getParameter("key");
		List list=thotelManager.getHotelNameBySta(key);
		
		for(int i=0;i<list.size();i++){
			String st=list.get(i).toString();
			int strlength=st.length()-1;
			String str=st.substring(8,strlength);
			response.getWriter().write(str+"|");
		}
	}
	public void getHotelNameByName() throws IOException{
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("text/html;charset=UTF-8"); 
		String hotelName = java.net.URLDecoder.decode(request.getParameter("hotelName"),"UTF-8");
		List list=thotelManager.getHotelNameByName(hotelName);
		
		for(int i=0;i<list.size();i++){
			String st=list.get(i).toString();
			int strlength=st.length()-1;
			String str=st.substring(8,strlength);
			response.getWriter().write(str+"|");
		}
	}

}
