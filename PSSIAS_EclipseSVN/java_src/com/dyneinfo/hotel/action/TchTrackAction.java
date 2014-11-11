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

import com.dyneinfo.hotel.model.TchTrack;
import com.dyneinfo.hotel.service.TchTrackManager;
import com.dyneinfo.zazh.service.SsCommonManager;
import com.opensymphony.xwork2.ModelDriven;
import com.opensymphony.xwork2.Preparable;

/**
 * @author lisc email:lishicheng(a)gmail.com
 */


public class TchTrackAction extends BaseStruts2Action implements Preparable,ModelDriven{
	//默认多列排序,example: username desc,createTime asc
	protected static final String DEFAULT_SORT_COLUMNS = "cishu desc"; 
	
	//forward paths
	protected static final String QUERY_JSP = "/pages/hotel/TchTrack/query.jsp";
	protected static final String LIST_JSP= "/pages/hotel/TchTrack/list.jsp";
	protected static final String DETAILLIST_JSP= "/pages/hotel/TchTrack/detailList.jsp";
	protected static final String JWDETAILLIST_JSP= "/pages/hotel/TchTrack/jw_detailList.jsp";
	protected static final String CREATE_JSP = "/pages/hotel/TchTrack/create.jsp";
	protected static final String EDIT_JSP = "/pages/hotel/TchTrack/edit.jsp";
	protected static final String SHOW_JSP = "/pages/hotel/TchTrack/show.jsp";
	//redirect paths,startWith: !
	protected static final String LIST_ACTION = "!/pages/hotel/TchTrack/list.do";
	
	private TchTrackManager tchTrackManager;
	private SsCommonManager ssCommonManager;
	
	private TchTrack tchTrack;
	java.lang.String id = null;
	java.lang.String idName = null;
	java.lang.String idCode = null;
	java.lang.String inTime_Begin = null;
	java.lang.String inTime_End = null;
	private String[] items;
	private String returnUrl;  //返回列表，保留查询条件
	private TreeMap<String, String> dateSelectMap;// //日期选择
	TreeMap<String,String> provMap ;

	public TreeMap<String, String> getProvMap() {
		return provMap;
	}

	public void prepare() throws Exception {
		if (isNullOrEmptyString(id)) {
			tchTrack = new TchTrack();
		} else {
			tchTrack = (TchTrack)tchTrackManager.getById(id);
		}
	}
	
	/** 增加setXXXX()方法,spring就可以通过autowire自动设置对象属性 */
	public void setTchTrackManager(TchTrackManager manager) {
		this.tchTrackManager = manager;
	}
	
	public void setSsCommonManager(SsCommonManager ssCommonManager) {
		this.ssCommonManager = ssCommonManager;
	}
	
	public void setProvMap(TreeMap<String, String> provMap) {
		this.provMap = provMap;
	}
	
	public Object getModel() {
		return tchTrack;
	}
	
	public void setId(java.lang.String val) {
		this.id = val;
	}

	public void setIdName(java.lang.String idName) {
		this.idName = idName;
	}

	public void setIdCode(java.lang.String idCode) {
		this.idCode = idCode;
	}

	public void setInTime_Begin(java.lang.String inTimeBegin) {
		inTime_Begin = DateUtil.parseString(inTimeBegin, "yyyy-MM-dd HH:mm", "yyyyMMddHHmm");
	}

	public void setInTime_End(java.lang.String inTimeEnd) {
		inTime_End = DateUtil.parseString(inTimeEnd, "yyyy-MM-dd HH:mm", "yyyyMMddHHmm");
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
		
		dateSelectMap = DateUtil.getDateSelectData();
		
		if (request.getParameter("dateSelect1") != null)
		request.setAttribute("dateSelect1", request.getParameter("dateSelect1"));
		
		if (request.getParameter("s_inTime_Begin") != null)
			pageRequest.getFilters().put("inTime_BeginFormat",
					DateUtil.parseString(request,"s_inTime_Begin", "yyyy-MM-dd HH:mm", "yyyyMMddHHmm"));
		if (request.getParameter("s_inTime_End") != null)
			pageRequest.getFilters().put("inTime_EndFormat",
					DateUtil.parseString(request,"s_inTime_End", "yyyy-MM-dd HH:mm", "yyyyMMddHHmm"));
		
		String sqlWhere = " 1=1 ";
		String s_name = request.getParameter("s_name");
		if (StringUtils.isNotEmpty(s_name)) {
			sqlWhere = sqlWhere + " and t.NAME like '%" + s_name + "%' ";
		}
		String s_idCode = request.getParameter("s_idCode");
		if (StringUtils.isNotEmpty(s_idCode)) {
			sqlWhere = sqlWhere + " and t.ID_CODE like '%" + s_idCode + "%' ";
		}
		String s_inTime_Begin = request.getParameter("s_inTime_Begin");
		if (StringUtils.isNotEmpty(s_inTime_Begin)) {
			sqlWhere = sqlWhere + " and t.in_time >= '" + DateUtil.parseString(s_inTime_Begin,"yyyy-MM-dd HH:mm","yyyyMMddHHmm") + "%' ";
		}
		String s_inTime_End = request.getParameter("s_inTime_End");
		if (StringUtils.isNotEmpty(s_inTime_End)) {
			sqlWhere = sqlWhere + " and t.in_time <= '" + DateUtil.parseString(s_inTime_End,"yyyy-MM-dd HH:mm","yyyyMMddHHmm") + "%' ";
		}
		String sql = "select " 
						+" NAME as name,"
						+" ID_NAME as idName,"
						+" ID_CODE as idCode,"
						+" guesttype as guesttype,"
						+" count(1) cishu"
						+" from V_ALL_GUEST t "
						+" where "
						+  sqlWhere
						+" group by name, id_name, id_code, guesttype" 
						+" order by cishu desc";
		Page page = null ;
		page = tchTrackManager.findByPageRequest(sql,pageRequest);
		savePage(page,pageRequest);
		return LIST_JSP;
	}
	public String detailList() {
		PageRequest<Map> pageRequest = newPageRequest(DEFAULT_SORT_COLUMNS);
		HttpServletRequest request = ServletActionContext.getRequest();
		String url = request.getQueryString();
		System.out.println("========================="+url);
		dateSelectMap = DateUtil.getDateSelectData();
		
		if (request.getParameter("dateSelect1") != null)
			request.setAttribute("dateSelect1", request.getParameter("dateSelect1"));
		
		if (request.getParameter("s_inTime_Begin") != null)
			pageRequest.getFilters().put("inTime_Begin",
					request.getParameter("s_inTime_Begin"));
		if (request.getParameter("s_inTime_End") != null)
			pageRequest.getFilters().put("inTime_End",
					request.getParameter("s_inTime_End"));
		if (request.getParameter("s_idCode") != null)
			pageRequest.getFilters().put("idCode",
					request.getParameter("s_idCode"));
		
		String sqlWhere = " v.hotelid=hotel.code(+) ";
		String id_name = request.getParameter("s_idName");
		if (StringUtils.isNotEmpty(id_name)) {
			sqlWhere = sqlWhere + " and v.ID_NAME = '" + id_name + "' ";
		}
		String s_idCode = request.getParameter("s_idCode");
		if (StringUtils.isNotEmpty(s_idCode)) {
			sqlWhere = sqlWhere + " and v.ID_CODE = '" + s_idCode + "' ";
		}
		String s_inTime_Begin = request.getParameter("s_inTime_Begin");
		if (StringUtils.isNotEmpty(s_inTime_Begin)) {
			sqlWhere = sqlWhere + " and v.in_time >= '" + DateUtil.parseString(s_inTime_Begin,"yyyy-MM-dd HH:mm","yyyyMMddHHmm") + "' ";
		}
		String s_inTime_End = request.getParameter("s_inTime_End");
		if (StringUtils.isNotEmpty(s_inTime_End)) {
			sqlWhere = sqlWhere + " and v.in_time <= '" + DateUtil.parseString(s_inTime_End,"yyyy-MM-dd HH:mm","yyyyMMddHHmm") + "' ";
		}
		String sql = "select v.ID as id, "
			+ "       v.NAME as name, "
			+ "       v.SEX as sex, "
			+ "       v.ID_NAME as idName, "
			+ "       v.ID_CODE as idCode, "
			+ "       v.hotelid as hotelid, "
			+ "       v.NO_ROOM as noRoom, "
			+ "       v.BDATE as bdate, "
			+ "       v.in_time as inTime, "
			+ "       v.sta_code as staCode, "
			+ "       v.guesttype as guesttype, "
			+ "       hotel.called as hotelName " 
			+ " from v_all_guest v,t_hotel hotel"
			+ " where "
			+ sqlWhere
			+ " order by in_time desc";
		Page page = null ;
		page = tchTrackManager.findByPageRequest(sql,pageRequest);
		savePage(page,pageRequest);
		String guesttype="";
		try {
			if(page.getResult().size() > 0){
				Map guestMap = (Map)page.getResult().get(0);
				guesttype = (String) guestMap.get("guesttype");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		if(guesttype.equals("境外")){
			return JWDETAILLIST_JSP;
		}else{
			return DETAILLIST_JSP;
		}
	}
	
	/** 查看对象*/
	public String show() {
		HttpServletRequest request = ServletActionContext.getRequest();
		PageRequest<Map> pageRequest = newPageRequest(DEFAULT_SORT_COLUMNS);
		return SHOW_JSP;
	}
	
	/** 进入新增页面*/
	public String create() {
		return CREATE_JSP;
	}
	
	/** 保存新增对象 */
	public String save() {
		HttpServletRequest request = ServletActionContext.getRequest();
		tchTrackManager.save(tchTrack);
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
		tchTrackManager.update(this.tchTrack);
		return returnUrl;////LIST_ACTION;
	}
	
	/**删除对象*/
	public String delete() {
		for(int i = 0; i < items.length; i++) {
			Hashtable params = HttpUtils.parseQueryString(items[i]);
			java.lang.String id = new java.lang.String((String)params.get("id"));
			tchTrackManager.removeById(id);
		}
		return returnUrl ;//LIST_ACTION;
	}
	


}
