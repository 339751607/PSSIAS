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

import org.apache.commons.lang.StringUtils;
import org.apache.struts2.ServletActionContext;

import cn.org.rapid_framework.page.Page;
import cn.org.rapid_framework.page.PageRequest;
import cn.org.rapid_framework.web.util.HttpUtils;

import com.dyneinfo.hotel.model.Thotel;
import com.dyneinfo.hotel.model.TtjGuest;
import com.dyneinfo.hotel.service.ThotelManager;
import com.dyneinfo.hotel.service.TtjGuestManager;
import com.opensymphony.xwork2.ModelDriven;
import com.opensymphony.xwork2.Preparable;

/**
 * @author lisc email:lishicheng(a)gmail.com
 */


public class TtjGuestAction extends BaseStruts2Action implements Preparable,ModelDriven{
	//默认多列排序,example: username desc,createTime asc
	protected static final String DEFAULT_SORT_COLUMNS = " code asc "; 
	
	//forward paths
	protected static final String QUERY_JSP = "/pages/hotel/TtjGuest/query.jsp";
	protected static final String LIST_JSP= "/pages/hotel/TtjGuest/list.jsp";
	protected static final String CREATE_JSP = "/pages/hotel/TtjGuest/create.jsp";
	protected static final String EDIT_JSP = "/pages/hotel/TtjGuest/edit.jsp";
	protected static final String SHOW_JSP = "/pages/hotel/TtjGuest/show.jsp";
	//redirect paths,startWith: !
	protected static final String LIST_ACTION = "!/pages/hotel/TtjGuest/list.do";
	
	private TtjGuestManager tjGuestManager;
	
	private TtjGuest tjGuest;
	java.lang.String id = null;
	private String[] items;
	private String returnUrl;  //返回列表，保留查询条件
	private TreeMap<String, String> dateSelectMap;// //日期选择

	public void prepare() throws Exception {
		if (isNullOrEmptyString(id)) {
			tjGuest = new TtjGuest();
		} else {
			tjGuest = (TtjGuest)tjGuestManager.getById(id);
		}
	}
	
	/** 增加setXXXX()方法,spring就可以通过autowire自动设置对象属性 */
	public void setTtjGuestManager(TtjGuestManager manager) {
		this.tjGuestManager = manager;
	}	
	
	public Object getModel() {
		return tjGuest;
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
		if (request.getParameter("dateSelect2") != null)
			request.setAttribute("dateSelect2", request.getParameter("dateSelect2"));

		String deptWhere = " ";
		String hotelWhere = " ";
		String staWhere = " ";
		String s_burCode = request.getParameter("s_burCode");
		if (StringUtils.isNotEmpty(s_burCode)) {
			deptWhere = deptWhere + " and hotel.BUR_CODE = '" + s_burCode + "' ";
			staWhere = staWhere + " and sta.BUR_CODE = '" + s_burCode + "' ";
		}
		String s_staCode = request.getParameter("s_staCode");
		if (StringUtils.isNotEmpty(s_staCode)) {
			deptWhere = deptWhere + " and hotel.STA_CODE = '" + s_staCode + "' ";
			staWhere = staWhere + " and sta.code = '" + s_staCode + "' ";
		}
		String s_status = request.getParameter("s_status");
		if (StringUtils.isNotEmpty(s_status)) {
			hotelWhere = hotelWhere + " and STATUS = '" + s_status + "' ";
		}
		String s_star = request.getParameter("s_star");
		if (StringUtils.isNotEmpty(s_star)) {
			hotelWhere = hotelWhere + " and STAR = '" + s_star + "' ";
		}
		String s_roomNum_Begin = request.getParameter("s_roomNum_Begin");
		if (StringUtils.isNotEmpty(s_roomNum_Begin)) {
			hotelWhere = hotelWhere + " and nvl(ROOM_NUM,0) >= " + s_roomNum_Begin + " ";
		}
		String s_roomNum_End = request.getParameter("s_roomNum_End");
		if (StringUtils.isNotEmpty(s_roomNum_End)) {
			hotelWhere = hotelWhere + " and nvl(ROOM_NUM,0) <= " + s_roomNum_End + " ";
		}
		String s_bedNum_Begin = request.getParameter("s_bedNum_Begin");
		if (StringUtils.isNotEmpty(s_bedNum_Begin)) {
			hotelWhere = hotelWhere + " and nvl(BED_NUM,0) >= " + s_bedNum_Begin + " ";
		}
		String s_bedNum_End = request.getParameter("s_bedNum_End");
		if (StringUtils.isNotEmpty(s_bedNum_End)) {
			hotelWhere = hotelWhere + " and nvl(BED_NUM,0) <= " + s_bedNum_End + " ";
		}
		if (StringUtils.isEmpty(s_bedNum_Begin))
			pageRequest.getFilters().put("bedNum_Begin",0);
		if (StringUtils.isEmpty(s_roomNum_Begin))
			pageRequest.getFilters().put("roomNum_Begin",0);
		
		String sqlWhereTime = " ";
		String s_inTime_Begin = request.getParameter("s_inTime_Begin");
		if (StringUtils.isNotEmpty(s_inTime_Begin)) {
			sqlWhereTime = sqlWhereTime + " and replace(DATEN, chr(13) || chr(10), '') >= '" + DateUtil.parseString(s_inTime_Begin,"yyyy-MM-dd","yyyyMMdd") + "' ";
		}
		String s_inTime_End = request.getParameter("s_inTime_End");
		String inTime_End = "";
		if (StringUtils.isNotEmpty(s_inTime_End)) {
			inTime_End = DateUtil.parseString(s_inTime_End,"yyyy-MM-dd","yyyyMMdd");
			sqlWhereTime = sqlWhereTime + " and replace(DATEN, chr(13) || chr(10), '') <= '" + inTime_End + "' ";
			pageRequest.getFilters().put("inTime_End", s_inTime_End);
		}else{
			inTime_End = DateUtil.getNowTime("yyyyMMdd");
			pageRequest.getFilters().put("inTime_End", DateUtil.parseString(inTime_End, "yyyyMMdd", "yyyy-MM-dd"));
		}
		String s_TableName = "";
		if(StringUtils.isEmpty(request.getParameter("s_TableName"))){
			s_TableName = "T_CH_ALL_TEMP";
		}else{
			s_TableName = request.getParameter("s_TableName");
		}
		
		String s_type = request.getParameter("s_type");
		String sql = "";
		if(null != s_type && s_type.equals("1")){
			sql = ""
				+ "select distinct "
				+" CODE as code,"
				+" CALLED as called,"
				+" ADDRESS as address,"
				+" TEL as tel,"
				+ "                nvl(replace(replace(room_num, chr(13), ''), chr(10), ''), "
				+ "                    '0') as roomNum, "
				+ "                nvl(replace(replace(bed_num, chr(13), ''), chr(10), ''), "
				+ "                    '0') as bedNum, "
				+ "                (select nvl(sum(incount), '0') "
				+ "                   from "+ s_TableName +" "
				+ "                  where hotelid = code "
				+ " " + sqlWhereTime + " "
				+ "  ) as inGuestNum,"
				+ "                (select nvl(sum(outcount), '0') "
				+ "                   from "+ s_TableName +" "
				+ "                  where hotelid = code "
				+ " " + sqlWhereTime + " "
				+ "  ) as outGuestNum "
				+ "  from t_hotel hotel, "+ s_TableName +" b "
				+ " where 1 <> 2 "
				+ "   and hotel.code = b.hotelid(+) "
				+ hotelWhere
				+ deptWhere
				+ "/~ order by [sortColumns] ~/";
		}else if(null != s_burCode && !"".equals(s_burCode)){
			sql = ""
				+ "select code bur_sta_code, "
				+ "                       nvl(hotelsum, 0) hotelSum, "
				+ "                       nvl(roomNum, 0) roomNum, "
				+ "                       nvl(bedNum, 0) bedNum, "
				+ "                       nvl(insum, 0) inGuestNum, "
				+ "                       nvl(outsum, 0) outGuestNum, "
				+ "                       (nvl(insum, 0) + nvl(outsum, 0)) infoSum "
				+ "  from t_station sta, "
				+ "       (select sta_code, count(code) hotelsum, "
				+ "                               sum(room_num) roomNum, "
				+ "                               sum(bed_num) bedNum "
				+ "          from t_hotel hotel "
				+ "         where status = '1' "
				+ "           and (mod_time is null or mod_time <= '"+ inTime_End +"')" 
				+hotelWhere
				+deptWhere
				+ "         group by sta_code) h, "
				+ "       (select sta_code, sum(incount) insum, sum(outcount) outsum "
				+ "          from "+ s_TableName +" temp "
				+ "         where temp.hotelid in "
				+ "               (select hotel.code from t_hotel hotel where STATUS = 1 " 
				+hotelWhere
				+deptWhere
				+			") "
				+sqlWhereTime
				+ "         group by sta_code) t "
				+ " where sta.code = h.sta_code(+) "
				+ "   and sta.code = t.sta_code(+) "
				+staWhere
				+ "/~ order by [sortColumns] ~/";
		}else{
			sql = ""
				+ "select code bur_sta_code, "
				+ "       nvl(hotelsum, 0) hotelSum, "
				+ "       nvl(roomNum, 0) roomNum, "
				+ "       nvl(bedNum, 0) bedNum, "
				+ "       nvl(insum, 0) inGuestNum, "
				+ "       nvl(outsum, 0) outGuestNum, "
				+ "       (nvl(insum, 0) + nvl(outsum, 0)) infoSum "
				+ "  from t_bureau bur, "
				+ "       (select bur_code, "
				+ "               count(code) hotelsum, "
				+ "               sum(room_num) roomNum, "
				+ "               sum(bed_num) bedNum "
				+ "          from t_hotel "
				+ "         where STATUS = 1 "
				+ "           and (mod_time is null or mod_time <= '"+ inTime_End +"')" 				
				+hotelWhere
				+ "         group by bur_code) h, "
				+ "       (select bur_code, sum(incount) insum, sum(outcount) outsum "
				+ "          from "+ s_TableName +" temp "
				+ "         where temp.hotelid in "
				+ "               (select hotel.code from t_hotel hotel where STATUS = 1 " 
				+hotelWhere
				+			") "
				+sqlWhereTime
				+ "         group by bur_code) t "
				+ " where bur.code = h.bur_code(+) "
				+ "   and bur.code = t.bur_code(+)"
				+ "/~ order by [sortColumns] ~/";
		}
		
		Page page = tjGuestManager.findByPageRequest(sql,pageRequest);
		savePage(page,pageRequest);
		return LIST_JSP;
	}
	
	/** 查看对象*/
	public String show() {
		HttpServletRequest request = ServletActionContext.getRequest();
//		tjGuest.setModTime(DateUtil.parseString(tjGuest.getModTime(), "yyyyMMdd","yyyy-MM-dd"));
		return SHOW_JSP;
	}
	
	/** 进入新增页面*/
	public String create() {
		return CREATE_JSP;
	}
	
	/** 保存新增对象 */
	public String save() {
		HttpServletRequest request = ServletActionContext.getRequest();
		tjGuestManager.save(tjGuest);
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
		tjGuestManager.update(this.tjGuest);
		return returnUrl;////LIST_ACTION;
	}
	
	/**删除对象*/
	public String delete() {
		for(int i = 0; i < items.length; i++) {
			Hashtable params = HttpUtils.parseQueryString(items[i]);
			java.lang.String id = new java.lang.String((String)params.get("code"));
			tjGuestManager.removeById(id);
		}
		return returnUrl ;//LIST_ACTION;
	}
	
	public void getHotelNameBySta() throws IOException{
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("text/html;charset=UTF-8"); 
		String key = request.getParameter("key");
		List list=tjGuestManager.getHotelNameBySta(key);
		
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
		String hotelName = request.getParameter("hotelName");
		List list=tjGuestManager.getHotelNameByName(hotelName);
		
		for(int i=0;i<list.size();i++){
			String st=list.get(i).toString();
			int strlength=st.length()-1;
			String str=st.substring(8,strlength);
			response.getWriter().write(str+"|");
		}
	}

}
