/*
 * Powered By [lishicheng]
 */

package com.dyneinfo.jxy.action;

import java.io.IOException;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import javacommon.base.BaseStruts2Action;

import javax.servlet.http.HttpServletRequest;

import net.java.dev.common.util.DateUtil;

import org.apache.commons.lang.StringUtils;
import org.apache.struts2.ServletActionContext;
import org.security.userdetails.MyUserDetails;
import org.springframework.security.Authentication;
import org.springframework.security.context.SecurityContext;
import org.springframework.security.context.SecurityContextHolder;

import cn.org.rapid_framework.page.Page;
import cn.org.rapid_framework.page.PageRequest;
import cn.org.rapid_framework.web.util.HttpUtils;

import com.dyneinfo.jxy.model.Tcompanyinfo;
import com.dyneinfo.jxy.service.TcompanyinfojxyManager;
import com.dyneinfo.zazh.model.SsDept;
import com.dyneinfo.zazh.service.SsDeptManager;
import com.opensymphony.xwork2.ModelDriven;
import com.opensymphony.xwork2.Preparable;

/**
 * @author lisc email:lishicheng(a)gmail.com
 */


public class TcompanyinfoAction extends BaseStruts2Action implements Preparable,ModelDriven{
	//默认多列排序,example: username desc,createTime asc
	protected static final String DEFAULT_SORT_COLUMNS = null; 	
	//forward paths
	protected static final String QUERY_JSP = "/pages/jxy/Tcompanyinfo/query.jsp";
	protected static final String LIST_JSP= "/pages/jxy/Tcompanyinfo/list.jsp";
	protected static final String LISTCPCASE_JSP= "/pages/jxy/Tcompanyinfo/listCpcase.jsp";
	protected static final String LISTCPNAMECASE_JSP= "/pages/jxy/Tcompanyinfo/listCpNameCase.jsp";
	protected static final String LISTCPCAS_JSP= "/pages/jxy/Tcompanyinfo/listChange.jsp";

	protected static final String CREATE_JSP = "/pages/jxy/Tcompanyinfo/create.jsp";
	protected static final String EDIT_JSP = "/pages/jxy/Tcompanyinfo/edit.jsp";
	protected static final String SHOW_JSP = "/pages/jxy/Tcompanyinfo/show.jsp";
	protected static final String UPD_JSP="/pages/jxy/Tcompanyinfo/upd.jsp";
	//redirect paths,startWith: !
	protected static final String LIST_ACTION = "!/jxy/Tcompanyinfo/list.do";
	
	private TcompanyinfojxyManager tcompanyinfojxyManager;
	private SsDeptManager ssDeptManager;
	

	
	private Tcompanyinfo tcompanyinfo;
	
	java.lang.String id = null;
	private String[] items;
	private String returnUrl;  //返回列表，保留查询条件
	private TreeMap<String, String> dateSelectMap;// //日期选择

	public void prepare() throws Exception {
		if (isNullOrEmptyString(id)) {
			tcompanyinfo = new Tcompanyinfo();
		} else {
			tcompanyinfo = (Tcompanyinfo)tcompanyinfojxyManager.getById(id);
		}
	}
	
	/** 增加setXXXX()方法,spring就可以通过autowire自动设置对象属性 */
	public void setTcompanyinfojxyManager(TcompanyinfojxyManager manager) {
		this.tcompanyinfojxyManager = manager;
	}	
	
	public void setSsDeptManager(SsDeptManager manager) {
		this.ssDeptManager = manager;
	}	
	
	public Object getModel() {
		return tcompanyinfo;
	}
	
	public void setCpcode(java.lang.String val) {
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
		
		Page page = tcompanyinfojxyManager.findByPageRequest(pageRequest);
		savePage(page,pageRequest);
		return LIST_JSP;
		
		

	}
	
	/** 查看对象*/
	public String show() {
		HttpServletRequest request = ServletActionContext.getRequest();
		tcompanyinfo.setStartdate(DateUtil.parseString(tcompanyinfo.getStartdate(),"yyyyMMdd","yyyy-MM-dd"));
		
		return SHOW_JSP;
	}
	
	/** 进入新增页面*/
	public String create() {
		return CREATE_JSP;
	}
	
	/** 保存新增对象 */
	public String save() {
		HttpServletRequest request = ServletActionContext.getRequest();
		tcompanyinfo.setStartdate(DateUtil.parseString(tcompanyinfo.getStartdate(),"yyyy-MM-dd","yyyyMMdd"));
		
		
		
		tcompanyinfojxyManager.save(tcompanyinfo);
		tcompanyinfojxyManager.Insertdept(tcompanyinfo);
		
		
		return returnUrl;////LIST_ACTION;
	}
	
	/**进入更新页面*/
	public String edit() {
		HttpServletRequest request = ServletActionContext.getRequest();
		
		return EDIT_JSP;
	}
	public String upd(){
		HttpServletRequest request = ServletActionContext.getRequest();
		DateUtil tt = new DateUtil();
		String changedate =tt.getNowTime("yyyy-MM-dd");
		request.setAttribute("changedate", changedate);
		String station =  tcompanyinfo.getStation();
		String date = tcompanyinfo.getStartdate();
		if(null != date && 8 == date.length()){
			date = date.substring(0, 4) + "-" + date.substring(4, 6) + "-" +date.substring(6);
		}
		request.setAttribute("start_date", date);
		date = tcompanyinfo.getBasj();
		if(null != date && 8 == date.length()){
			date = date.substring(0, 4) + "-" + date.substring(4, 6) + "-" +date.substring(6);
		}
		request.setAttribute("ba_date", date);
		tcompanyinfo.setStationName(tcompanyinfojxyManager.getdeptname(station));
		       
		    


		
		
		return UPD_JSP;
	}
	public String updstatuts(){
		HttpServletRequest request = ServletActionContext.getRequest();
		if(!request.getParameter("s_cpname").equals(tcompanyinfo.getCpname())){
			String s_cpname=request.getParameter("s_cpname");
			DateUtil tt = new DateUtil();
			
			String changedate =tt.getNowTime("yyyyMMdd");		
			String changecode="1";
			tcompanyinfojxyManager.updateCpname(s_cpname, tcompanyinfo.getCpcode());
			tcompanyinfojxyManager.insertCorpname(tcompanyinfo,tcompanyinfo.getCpname(), changedate, s_cpname, changecode);
			
		}
		if(!request.getParameter("s_cpaddress").equals(tcompanyinfo.getCpaddress())){
			String s_cpaddress= request.getParameter("s_cpaddress");
			DateUtil tt = new DateUtil();
			String changedate =tt.getNowTime("yyyyMMdd");
			String changecode="2";
			tcompanyinfojxyManager.updateCpaddress(s_cpaddress, tcompanyinfo.getCpcode());
			tcompanyinfojxyManager.insertCorpname(tcompanyinfo,tcompanyinfo.getCpaddress(), changedate, s_cpaddress, changecode);
		}
		if(!request.getParameter("s_corpname").equals(tcompanyinfo.getCorpname())){
			String s_corpname= request.getParameter("s_corpname");
			DateUtil tt = new DateUtil();
			String changedate =tt.getNowTime("yyyyMMdd");
			String changecode="3";
			tcompanyinfojxyManager.updateCorpname(s_corpname, tcompanyinfo.getCpcode());
			tcompanyinfojxyManager.insertCorpname(tcompanyinfo,tcompanyinfo.getCorpname(), changedate, s_corpname, changecode);
			
		}
		if(!request.getParameter("s_policename").equals(tcompanyinfo.getPolicename())&&request.getParameter("s_policename")!=""){
			String s_policename= request.getParameter("s_policename");
			DateUtil tt = new DateUtil();
			String changedate =tt.getNowTime("yyyyMMdd");
			String changecode="4";
			tcompanyinfojxyManager.insertCorpname(tcompanyinfo,tcompanyinfo.getPolicename(), changedate, s_policename, changecode);
			tcompanyinfojxyManager.updatepolicename(s_policename, tcompanyinfo.getCpcode());
			
		}
		if(!request.getParameter("s_policeunit").equals(tcompanyinfo.getPoliceunit())){
				String s_policeunit= request.getParameter("s_policeunit");
				String policeunit1= request.getParameter("s_policeunit");
			
				String policeuni=request.getParameter("policeuni");
				DateUtil tt = new DateUtil();
				String changedate =tt.getNowTime("yyyyMMdd");
				String changecode="5";
				String station1 = policeunit1.substring(0, 12);
			        policeunit1= tcompanyinfojxyManager.getdeptname(station1);
				tcompanyinfojxyManager.insertCorpname(tcompanyinfo,policeuni, changedate, policeunit1, changecode);
				tcompanyinfojxyManager.updatepoliceunit(station1, tcompanyinfo.getCpcode());
			}
				
		if(!request.getParameter("s_station").equals(tcompanyinfo.getStation())){
			String station1=request.getParameter("s_station");
			String s_station= request.getParameter("statio");
			String station = request.getParameter("station");
			String stationname=request.getParameter("stationName");
		
			DateUtil tt = new DateUtil();
			String changedate =tt.getNowTime("yyyyMMdd");
			String changecode="6";
			
			
			String s_deptid = null;
			Integer f_deptLevel = null;
			String s_parentid = null;
			String f_deptseq = "";
			int childCount = 0;
			
			
			if(StringUtils.isNotEmpty(station1) ){
				
				SsDept pcsDept = (SsDept) ssDeptManager.getDeptseq(station1);
				s_deptid = pcsDept.getDeptid();
				f_deptLevel = pcsDept.getDeptlevel();
				s_parentid = pcsDept.getParentid();
				f_deptseq = pcsDept.getDeptseq();
			    childCount = 	ssDeptManager.getCountChildDept(station1);
			}  else {
				request.setAttribute("message", "请选中分局或派出所！");
				return MSG_JSP;
			}
			
			String deptLevel= f_deptLevel.toString();
			tcompanyinfojxyManager.insertCorpname(tcompanyinfo,s_station, changedate, stationname, changecode);
			String deptseq = f_deptseq+tcompanyinfo.getCpcode()+".";
			tcompanyinfojxyManager.updatestation(deptseq, tcompanyinfo.getCpcode(),s_deptid,deptLevel);
			
		}
		
		return "!/jxy/Tcpinfo/list.do";
		
	}
	/**保存更新对象*/
	public String update() {
		HttpServletRequest request = ServletActionContext.getRequest();
		tcompanyinfojxyManager.update(this.tcompanyinfo);		
		return returnUrl;////LIST_ACTION;
	}
	
	/**删除对象*/
	public String delete() {
		HttpServletRequest request = ServletActionContext.getRequest();
		for(int i = 0; i < items.length; i++) {
			Hashtable params = HttpUtils.parseQueryString(items[i]);
			java.lang.String id = new java.lang.String((String)params.get("cpcode"));
			
				if(tcompanyinfojxyManager.deptCount(id) == 0 & tcompanyinfojxyManager.userCount(id)==0){	
				tcompanyinfojxyManager.deletedept(id);
				}
			
			
		}
		return returnUrl ;//LIST_ACTION;
	}
	public String list1() {
		PageRequest<Map> pageRequest = newPageRequest(DEFAULT_SORT_COLUMNS);
		HttpServletRequest request = ServletActionContext.getRequest();
		//pageRequest.getFilters().put("key",value);     //add custom filter
		
        SecurityContext sc = SecurityContextHolder.getContext();
        Authentication auth = sc.getAuthentication();
        MyUserDetails ud = null;
		String username = "";
		String deptid = "";
		String deptseq ="";
		if ((auth != null) && auth.getPrincipal() instanceof MyUserDetails) {
			ud = (MyUserDetails) auth.getPrincipal();
			if (ud != null) {
				username = ud.getUserName();
				deptid = ud.getDeptID();
				deptseq = ud.getDeptSeq();
				pageRequest.getFilters().put("deptSeq",deptseq);
			}
		}	
		dateSelectMap  = DateUtil.getDateSelectData();
		
		Page page = tcompanyinfojxyManager.findByPageRequest(pageRequest);
		savePage(page,pageRequest);
		return LISTCPCASE_JSP;
	}
	
	
	public String list2() {
		PageRequest<Map> pageRequest = newPageRequest(DEFAULT_SORT_COLUMNS);
		HttpServletRequest request = ServletActionContext.getRequest();
		//pageRequest.getFilters().put("key",value);     //add custom filter
		
        SecurityContext sc = SecurityContextHolder.getContext();
        Authentication auth = sc.getAuthentication();
        MyUserDetails ud = null;
		String username = "";
		String deptid = "";
		String deptseq ="";
		if ((auth != null) && auth.getPrincipal() instanceof MyUserDetails) {
			ud = (MyUserDetails) auth.getPrincipal();
			if (ud != null) {
				username = ud.getUserName();
				deptid = ud.getDeptID();
				deptseq = ud.getDeptSeq();
				pageRequest.getFilters().put("deptSeq",deptseq);
			}
		}	
		dateSelectMap  = DateUtil.getDateSelectData();
		
		Page page = tcompanyinfojxyManager.findByPageRequest(pageRequest);
		savePage(page,pageRequest);
		return LISTCPNAMECASE_JSP;
	}
	
	public String listt() {
		PageRequest<Map> pageRequest = newPageRequest(DEFAULT_SORT_COLUMNS);
		HttpServletRequest request = ServletActionContext.getRequest();
		//pageRequest.getFilters().put("key",value);     //add custom filter
		
        SecurityContext sc = SecurityContextHolder.getContext();
        Authentication auth = sc.getAuthentication();
        MyUserDetails ud = null;
		String username = "";
		String deptid = "";
		String deptseq ="";
		if ((auth != null) && auth.getPrincipal() instanceof MyUserDetails) {
			ud = (MyUserDetails) auth.getPrincipal();
			if (ud != null) {
				username = ud.getUserName();
				deptid = ud.getDeptID();
				deptseq = ud.getDeptSeq();
				pageRequest.getFilters().put("deptSeq",deptseq);
			}
		}	
		dateSelectMap  = DateUtil.getDateSelectData();
		
		Page page = tcompanyinfojxyManager.findByPageRequest(pageRequest);
		savePage(page,pageRequest);
		return "/pages/jxy/Tcompanyinfo/listChange.jsp";
	}

	
	
	
	

}
