/*
 * Powered By [lishicheng]
 */

package com.dyneinfo.hotel.action;

import java.util.Hashtable;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import javacommon.base.BaseStruts2Action;

import javax.servlet.http.HttpServletRequest;

import net.java.dev.common.util.DateUtil;

import org.apache.commons.lang.StringUtils;
import org.apache.struts2.ServletActionContext;

import cn.org.rapid_framework.page.Page;
import cn.org.rapid_framework.page.PageRequest;
import cn.org.rapid_framework.web.util.HttpUtils;

import com.dyneinfo.hotel.model.TchPre;
import com.dyneinfo.hotel.service.TchPreManager;
import com.dyneinfo.zazh.service.SsCommonManager;
import com.opensymphony.xwork2.ModelDriven;
import com.opensymphony.xwork2.Preparable;

/**
 * @author lisc email:lishicheng(a)gmail.com
 */


public class TchPreAction extends BaseStruts2Action implements Preparable,ModelDriven{
	//默认多列排序,example: username desc,createTime asc
	protected static final String DEFAULT_SORT_COLUMNS = "id desc"; 
	
	//forward paths
	protected static final String QUERY_JSP = "/pages/hotel/TchPre/query.jsp";
	protected static final String LIST_JSP= "/pages/hotel/TchPre/list.jsp";
	protected static final String LISTONLY_JSP= "/pages/hotel/TchPre/listOnly.jsp";
	protected static final String CREATE_JSP = "/pages/hotel/TchPre/create.jsp";
	protected static final String EDIT_JSP = "/pages/hotel/TchPre/edit.jsp";
	protected static final String SHOW_JSP = "/pages/hotel/TchPre/show.jsp";
	protected static final String ZAZHSHOW_JSP = "/pages/hotel/TchPre/zazhShow.jsp";
	protected static final String SHOW_PIC = "/pages/pic/pic.jsp";
	//redirect paths,startWith: !
	protected static final String LIST_ACTION = "!/pages/hotel/TchPre/list.do";
	
	private TchPreManager tchPreManager;
	private SsCommonManager ssCommonManager;
	
	private TchPre tchPre;
	java.lang.String id = null;
	private String[] items;
	private String returnUrl;  //返回列表，保留查询条件
	private TreeMap<String, String> dateSelectMap;// //日期选择
	TreeMap<String,String> provMap ;

	public TreeMap<String, String> getProvMap() {
		return provMap;
	}

	public void prepare() throws Exception {
		if (isNullOrEmptyString(id)) {
			tchPre = new TchPre();
		} else {
			tchPre = (TchPre)tchPreManager.getTchPreById(id);
		}
	}
	
	/** 增加setXXXX()方法,spring就可以通过autowire自动设置对象属性 */
	public void setTchPreManager(TchPreManager manager) {
		this.tchPreManager = manager;
	}
	
	public void setSsCommonManager(SsCommonManager ssCommonManager) {
		this.ssCommonManager = ssCommonManager;
	}
	
	public void setProvMap(TreeMap<String, String> provMap) {
		this.provMap = provMap;
	}
	
	public Object getModel() {
		return tchPre;
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
	
	/** 执行搜索 */
	public String list() {
		PageRequest<Map> pageRequest = newPageRequest(DEFAULT_SORT_COLUMNS);
		HttpServletRequest request = ServletActionContext.getRequest();
		String url = request.getQueryString();
		System.out.println("========================="+url);
		dateSelectMap = DateUtil.getDateSelectData();
		
		if (request.getParameter("dateSelect1") != null)
		request.setAttribute("dateSelect1", request.getParameter("dateSelect1"));
		if (request.getParameter("dateSelect2") != null)
		request.setAttribute("dateSelect2", request.getParameter("dateSelect2"));
		
		
		if (request.getParameter("s_inTime_Begin") != null)
			pageRequest.getFilters().put("inTime_BeginFormat",
					DateUtil.parseString(request,"s_inTime_Begin", "yyyy-MM-dd HH:mm", "yyyyMMddHHmm"));
		if (request.getParameter("s_inTime_End") != null)
			pageRequest.getFilters().put("inTime_EndFormat",
					DateUtil.parseString(request,"s_inTime_End", "yyyy-MM-dd HH:mm", "yyyyMMddHHmm"));
		if (request.getParameter("s_outTime_Begin") != null)
			pageRequest.getFilters().put("outTime_BeginFormat",
					DateUtil.parseString(request,"s_outTime_Begin", "yyyy-MM-dd HH:mm", "yyyyMMddHHmm"));
		if (request.getParameter("s_outTime_End") != null)
			pageRequest.getFilters().put("outTime_EndFormat",
					DateUtil.parseString(request,"s_outTime_End", "yyyy-MM-dd HH:mm", "yyyyMMddHHmm"));
		if (request.getParameter("s_bdate_Begin") != null)
			pageRequest.getFilters().put("bdate_BeginFormat",
					DateUtil.parseString(request,"s_bdate_Begin", "yyyy-MM-dd", "yyyyMMdd"));
		if (request.getParameter("s_bdate_End") != null)
			pageRequest.getFilters().put("bdate_EndFormat",
					DateUtil.parseString(request,"s_bdate_End", "yyyy-MM-dd", "yyyyMMdd"));
		
		Page page = null ;
		if(null == request.getParameter("s_TableName") || "".equals(request.getParameter("s_TableName"))){
			page = tchPreManager.findByPageRequest(pageRequest);
		}else{
			page = tchPreManager.findByPageRequest(pageRequest,request.getParameter("s_TableName"));
		}
		savePage(page,pageRequest);
		if (StringUtils.isNotEmpty(request.getParameter("listOnly")) && request.getParameter("listOnly").equals("true")){
			return LISTONLY_JSP;
		}else{
			return LIST_JSP;
		}
	}
	
	/** 查看对象*/
	public String show() {
		PageRequest<Map> pageRequest = newPageRequest(DEFAULT_SORT_COLUMNS);
		HttpServletRequest request = ServletActionContext.getRequest();
		pageRequest.setPageSize(100);
		Page page = null ;
		page = tchPreManager.findByPageRequest(pageRequest,tchPre);
		String roommates = "";
		try {
			List result = page.getResult();
			roommates += tchPre.getId();
			for(int i = 0; i < result.size(); i ++){
				TchPre tchPreMap = (TchPre)page.getResult().get(i);
				roommates += "," + (String) tchPreMap.getId();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		tchPre.setRoommates(roommates);
		savePage(page,pageRequest);
		tchPre.setBdate(DateUtil.parseString(tchPre.getBdate(), "yyyyMMdd","yyyy-MM-dd"));
		tchPre.setInTime(DateUtil.parseString(tchPre.getInTime(), "yyyyMMddHHmm","yyyy-MM-dd HH:mm"));
		tchPre.setOutTime(DateUtil.parseString(tchPre.getOutTime(), "yyyyMMddHHmm","yyyy-MM-dd HH:mm"));
		boolean existCar = tchPreManager.existCar(tchPre.getId());
		request.setAttribute("existCar", existCar);
		return SHOW_JSP;
	}
	/** 查看同住人*/
	public String roommatesShow() {
		PageRequest<Map> pageRequest = newPageRequest(DEFAULT_SORT_COLUMNS);
		HttpServletRequest request = ServletActionContext.getRequest();
		String roommates = "";
		String [] roommatesArray = request.getParameter("roommates").split(",");
		for(int i = 0; i < roommatesArray.length; i++){
			if(!roommatesArray[i].equals(tchPre.getId())){
				roommates += "'" + roommatesArray[i] + "',";
			}
		}
		if(roommates.length() > 0){
			roommates = roommates.substring(0, roommates.length()-1);
		}
		Page page = null ;
		page = tchPreManager.findByRoommates(pageRequest,roommates);
		savePage(page,pageRequest);
		tchPre.setBdate(DateUtil.parseString(tchPre.getBdate(), "yyyyMMdd","yyyy-MM-dd"));
		tchPre.setInTime(DateUtil.parseString(tchPre.getInTime(), "yyyyMMddHHmm","yyyy-MM-dd HH:mm"));
		tchPre.setOutTime(DateUtil.parseString(tchPre.getOutTime(), "yyyyMMddHHmm","yyyy-MM-dd HH:mm"));
		boolean existCar = tchPreManager.existCar(tchPre.getId());
		request.setAttribute("existCar", existCar);
		return SHOW_JSP;
	}
	/** 查看对象*/
	public String zazhShow() {
		HttpServletRequest request = ServletActionContext.getRequest();
		if(null == tchPre){
			tchPre = new TchPre();
		}
		PageRequest<Map> pageRequest = newPageRequest(DEFAULT_SORT_COLUMNS);
		pageRequest.setPageSize(100);
		Page page = null ;
		page = tchPreManager.findByPageRequest(pageRequest,tchPre);
		String roommates = "";
		try {
			List result = page.getResult();
			roommates += tchPre.getId();
			for(int i = 0; i < result.size(); i ++){
				TchPre tchPreMap = (TchPre)page.getResult().get(i);
				roommates += "," + (String) tchPreMap.getId();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		tchPre.setRoommates(roommates);
		savePage(page,pageRequest);
		tchPre.setBdate(DateUtil.parseString(tchPre.getBdate(), "yyyyMMdd","yyyy-MM-dd"));
		tchPre.setInTime(DateUtil.parseString(tchPre.getInTime(), "yyyyMMddHHmm","yyyy-MM-dd HH:mm"));
		tchPre.setOutTime(DateUtil.parseString(tchPre.getOutTime(), "yyyyMMddHHmm","yyyy-MM-dd HH:mm"));
		boolean existCar = tchPreManager.existCar(tchPre.getId());
		request.setAttribute("existCar", existCar);
		return ZAZHSHOW_JSP;
	}
	/** 进入新增页面*/
	public String create() {
		return CREATE_JSP;
	}
	
	/** 保存新增对象 */
	public String save() {
		HttpServletRequest request = ServletActionContext.getRequest();
		tchPreManager.save(tchPre);
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
		tchPreManager.update(this.tchPre);
		return returnUrl;////LIST_ACTION;
	}
	
	/**删除对象*/
	public String delete() {
		for(int i = 0; i < items.length; i++) {
			Hashtable params = HttpUtils.parseQueryString(items[i]);
			java.lang.String id = new java.lang.String((String)params.get("id"));
			tchPreManager.removeById(id);
		}
		return returnUrl ;//LIST_ACTION;
	}
	
	// 显示图片
	public String showPic() {
		HttpServletRequest request = ServletActionContext.getRequest();
		String id = "";
		if (request.getParameter("id") != null)
			id = request.getParameter("id");
		List list = (List) tchPreManager.getPic(id);
		request.setAttribute("list", list);
		return SHOW_PIC;
	}
	// 显示图片
	public String getPicture() {
		HttpServletRequest request = ServletActionContext.getRequest();
		String sql = request.getParameter("sql");
		if (sql != null && !sql .equals("")){
			List list = (List) tchPreManager.getPicture(sql);
			request.setAttribute("list", list);
		}
		return SHOW_PIC;
	}


}
