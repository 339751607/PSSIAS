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

import net.java.dev.common.dict.taglib.DictHelpImpl;
import net.java.dev.common.util.DateUtil;

import org.apache.commons.lang.StringUtils;
import org.apache.struts2.ServletActionContext;

import cn.org.rapid_framework.page.Page;
import cn.org.rapid_framework.page.PageRequest;
import cn.org.rapid_framework.web.util.HttpUtils;

import com.dyneinfo.hotel.model.TtjGuestPre;
import com.dyneinfo.hotel.service.TtjGuestPreManager;
import com.dyneinfo.zazh.model.DictItem;
import com.dyneinfo.zazh.service.SsCommonManager;
import com.opensymphony.xwork2.ModelDriven;
import com.opensymphony.xwork2.Preparable;

/**
 * @author lisc email:lishicheng(a)gmail.com
 */


public class TtjGuestPreAction extends BaseStruts2Action implements Preparable,ModelDriven{
	//默认多列排序,example: username desc,createTime asc
	protected static final String DEFAULT_SORT_COLUMNS = "id desc"; 
	
	//forward paths
	protected static final String QUERY_JSP = "/pages/hotel/TtjGuestPre/query.jsp";
	protected static final String LIST_JSP= "/pages/hotel/TtjGuestPre/list.jsp";
	protected static final String CREATE_JSP = "/pages/hotel/TtjGuestPre/create.jsp";
	protected static final String EDIT_JSP = "/pages/hotel/TtjGuestPre/edit.jsp";
	protected static final String SHOW_JSP = "/pages/hotel/TtjGuestPre/show.jsp";
	//redirect paths,startWith: !
	protected static final String LIST_ACTION = "!/pages/hotel/TtjGuestPre/list.do";
	
	private TtjGuestPreManager tjGuestPreManager;
	private SsCommonManager ssCommonManager;
	
	private TtjGuestPre tjGuestPre;
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
			tjGuestPre = new TtjGuestPre();
		} else {
			tjGuestPre = (TtjGuestPre)tjGuestPreManager.getById(id);
		}
	}
	
	/** 增加setXXXX()方法,spring就可以通过autowire自动设置对象属性 */
	public void setTtjGuestPreManager(TtjGuestPreManager manager) {
		this.tjGuestPreManager = manager;
	}
	
	public void setSsCommonManager(SsCommonManager ssCommonManager) {
		this.ssCommonManager = ssCommonManager;
	}
	
	public void setProvMap(TreeMap<String, String> provMap) {
		this.provMap = provMap;
	}
	
	public Object getModel() {
		return tjGuestPre;
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
		return QUERY_JSP;
	}
	
	/** 执行搜索 */
	public String list() {
		PageRequest<Map> pageRequest = newPageRequest(DEFAULT_SORT_COLUMNS);
		HttpServletRequest request = ServletActionContext.getRequest();
		
		dateSelectMap = DateUtil.getDateSelectData();
		
		if (request.getParameter("dateSelect1") != null)
		request.setAttribute("dateSelect1", request.getParameter("dateSelect1"));
		
		String sqlWhere = " ";
		String s_guestHotel = request.getParameter("s_guestHotel");
		String s_guestRoom = request.getParameter("s_guestRoom");
		if (StringUtils.isNotEmpty(s_guestHotel)){
			sqlWhere += sqlWhere + " and guest_hotel >= "+ s_guestHotel +"";
		}else{
			pageRequest.getFilters().put("guestHotel",1);
		}
		if (StringUtils.isNotEmpty(s_guestRoom)){
			sqlWhere += sqlWhere + " and guest_room >= "+ s_guestRoom +"";
		}else{
			pageRequest.getFilters().put("guestRoom",1);
		}
		String s_burCode = request.getParameter("s_burCode");
		if (StringUtils.isNotEmpty(s_burCode)) {
			sqlWhere = sqlWhere + " and bur_code = '" + s_burCode + "' ";
		}
		String s_staCode = request.getParameter("s_staCode");
		if (StringUtils.isNotEmpty(s_staCode)) {
			sqlWhere = sqlWhere + " and sta_code = '" + s_staCode + "' ";
		}
		
		String chPreWhere = " ";
		String s_inTime_Begin = request.getParameter("s_inTime_Begin");
		if (StringUtils.isNotEmpty(s_inTime_Begin)) {
			chPreWhere = chPreWhere + " and replace(in_time, chr(13) || chr(10), '') >= '" + DateUtil.parseString(s_inTime_Begin,"yyyy-MM-dd HH:mm", "yyyyMMddHHmm") + "' ";
		}
		String s_inTime_End = request.getParameter("s_inTime_End");
		if (StringUtils.isNotEmpty(s_inTime_End)) {
			chPreWhere = chPreWhere + " and replace(in_time, chr(13) || chr(10), '') <= '" + DateUtil.parseString(s_inTime_End,"yyyy-MM-dd HH:mm", "yyyyMMddHHmm") + "' ";
		}
		String s_province = request.getParameter("s_province");
		if (StringUtils.isNotEmpty(s_province)) {
			chPreWhere = chPreWhere + " and XZQH like substr('"+ s_province +"',0,2)||'%' ";
		}
		String s_xzqh = request.getParameter("s_xzqh");
		if (StringUtils.isNotEmpty(s_xzqh)) {
			chPreWhere = chPreWhere + " and XZQH = '" + s_xzqh + "' ";
		}
		String s_nonnative = request.getParameter("s_nonnative");
		String xzqhLocal = "";
		if (StringUtils.isNotEmpty(s_nonnative) && s_nonnative.equals("1")) {
			List xzqhlist = (List)DictHelpImpl.DictMap.get("DIC_ITEM_LOCAL_XZQHzh_CN");
			DictItem xzqhItem = (DictItem)xzqhlist.get(0);
			xzqhLocal = xzqhItem.getDictid().substring(0,2);
			chPreWhere = chPreWhere + " and substr(xzqh, 0, 2) <> '"+ xzqhLocal +"' ";
		}
		
		String sql = ""
			+ "select code hotelid, "
			+ "       called hotelname, "
			+ "       address address, "
			+ "       tel tel, "
			+ "       room_num roomNum, "
			+ "       bed_num bedNum, "
			+ "       guest_hotel guestHotel, "
			+ "       guest_room guestRoom, "
			+ "       bur_code burCode, "
			+ "       sta_code  staCode "
			+ "  from t_hotel h, "
			+ "       (select hotelid, count(id) guest_hotel "
			+ "          from t_ch_pre "
			+ "         where 1 = 1 "
			+chPreWhere
			+ "         group by hotelid) t1, "
			+ "       (select hotelid, max(guest_room) guest_room "
			+ "          from (select hotelid, no_room, count(id) guest_room "
			+ "                  from t_ch_pre "
			+ "                 where 1 = 1 "
			+chPreWhere
			+ "                 group by hotelid, no_room) "
			+ "         group by hotelid) t2 "
			+ " where h.code = t1.hotelid "
			+ "   and h.code = t2.hotelid "
			+sqlWhere
			+ " order by code";
		
		Page page = tjGuestPreManager.findByPageRequest(sql,pageRequest);
		savePage(page,pageRequest);
		return LIST_JSP;
	}
	
	/** 查看对象*/
	public String show() {
		HttpServletRequest request = ServletActionContext.getRequest();
		tjGuestPre.setBdate(DateUtil.parseString(tjGuestPre.getBdate(), "yyyyMMdd","yyyy-MM-dd"));
		tjGuestPre.setInTime(DateUtil.parseString(tjGuestPre.getInTime(), "yyyyMMddHHmm","yyyy-MM-dd HH:mm"));
		tjGuestPre.setOutTime(DateUtil.parseString(tjGuestPre.getOutTime(), "yyyyMMddHHmm","yyyy-MM-dd HH:mm"));
		return SHOW_JSP;
	}
	
	/** 进入新增页面*/
	public String create() {
		return CREATE_JSP;
	}
	
	/** 保存新增对象 */
	public String save() {
		HttpServletRequest request = ServletActionContext.getRequest();
		tjGuestPreManager.save(tjGuestPre);
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
		tjGuestPreManager.update(this.tjGuestPre);
		return returnUrl;////LIST_ACTION;
	}
	
	/**删除对象*/
	public String delete() {
		for(int i = 0; i < items.length; i++) {
			Hashtable params = HttpUtils.parseQueryString(items[i]);
			java.lang.String id = new java.lang.String((String)params.get("id"));
			tjGuestPreManager.removeById(id);
		}
		return returnUrl ;//LIST_ACTION;
	}
	


}
