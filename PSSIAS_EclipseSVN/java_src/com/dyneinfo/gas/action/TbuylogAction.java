/*
 * Powered By [lishicheng]
 */

package com.dyneinfo.gas.action;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import javacommon.base.BaseStruts2Action;

import javax.servlet.http.HttpServletRequest;

import net.java.dev.common.dict.taglib.DictHelpImpl;
import net.java.dev.common.util.DateUtil;

import org.apache.struts2.ServletActionContext;
import org.security.userdetails.MyUserDetails;
import org.springframework.security.Authentication;
import org.springframework.security.context.SecurityContext;
import org.springframework.security.context.SecurityContextHolder;

import sun.misc.BASE64Decoder;
import com.dyneinfo.zazh.model.SsDept;
import com.dyneinfo.zazh.service.SsCommonManager;
import cn.org.rapid_framework.page.Page;
import cn.org.rapid_framework.page.PageRequest;
import cn.org.rapid_framework.web.util.HttpUtils;

import com.dyneinfo.gas.model.TbuyPic;
import com.dyneinfo.gas.model.Tbuylog;
import com.dyneinfo.gas.model.Tcompanyinfo;
import com.dyneinfo.gas.service.TbuyPicManager;
import com.dyneinfo.gas.service.TbuylogManager;
import com.dyneinfo.gas.service.TcompanyinfogasManager;
import com.opensymphony.xwork2.ModelDriven;
import com.opensymphony.xwork2.Preparable;

/**
 * @author lisc email:lishicheng(a)gmail.com
 */


public class TbuylogAction extends BaseStruts2Action implements Preparable,ModelDriven{
	//默认多列排序,example: username desc,createTime asc
	protected static final String DEFAULT_SORT_COLUMNS = null; 
	
	//forward paths
	protected static final String QUERY_JSP = "/pages/gas/Tbuylog/query.jsp";
	protected static final String LIST_JSP= "/pages/gas/Tbuylog/list.jsp";
	protected static final String DLLIST_JSP= "/pages/gas/Tbuylog/dllist.jsp";
	protected static final String GWLIST_JSP= "/pages/gas/Tbuylog/gwlist.jsp";
	protected static final String PFLIST_JSP= "/pages/gas/Tbuylog/pflist.jsp";
	protected static final String TZDLLIST_JSP= "/pages/gas/Tbuylog/tzdllist.jsp";
	protected static final String TZGWLIST_JSP= "/pages/gas/Tbuylog/tzgwlist.jsp";
	protected static final String TZPFLIST_JSP= "/pages/gas/Tbuylog/tzpflist.jsp";
	protected static final String TZGYLIST_JSP = "/pages/gas/Tbuylog/tzgylist.jsp";
	protected static final String JZLIST_JSP= "/pages/gas/Tbuylog/jzlist.jsp";
	protected static final String CREATE_JSP = "/pages/gas/Tbuylog/create.jsp";
	protected static final String EDIT_JSP = "/pages/gas/Tbuylog/edit.jsp";
	protected static final String SHOW_JSP = "/pages/gas/Tbuylog/show.jsp";
	
	protected static final String ZAZHSHOW_JSP = "/pages/gas/Tbuylog/zazhShow.jsp";
	
	protected static final String GYSHOW_JSP = "/pages/gas/Tbuylog/gyshow.jsp";
	protected static final String TZXXGYSHOW_JSP = "/pages/gas/Tbuylog/tzxxshow.jsp";
	protected static final String GYLIST_JSP = "/pages/gas/Tbuylog/gylist.jsp";
	protected static final String JZGYLIST_JSP = "/pages/gas/Tbuylog/jzgylist.jsp";
	protected static final String TZLIST_JSP = "/pages/gas/Tbuylog/tzlist.jsp";
	
	protected static final String SHOW_PIC = "/pages/pic/pic.jsp";
	
	//redirect paths,startWith: !
	protected static final String LIST_ACTION = "!/pages/gas/Tbuylog/list.do";
	
	private TbuylogManager tbuylogManager;
	private SsCommonManager ssCommonManager;
	private TcompanyinfogasManager tcompanyinfogasManager;
	TreeMap<String,String> provMap ;
	TreeMap<String,String> compMap ;
	
	private TbuyPicManager tbuyPicManager;
	
	private TbuyPic tbuyPic;
	private Tcompanyinfo tcompanyinfo;
	
	private Tbuylog tbuylog;
	
	private String mgs;
	
	java.lang.String id = null;
	private String[] items;
	private String returnUrl;  //返回列表，保留查询条件
	private TreeMap<String, String> dateSelectMap;// //日期选择

	public void prepare() throws Exception {
		if (isNullOrEmptyString(id)) {
			tbuylog = new Tbuylog();
		} else {
			tbuylog = (Tbuylog)tbuylogManager.getById(id);
		}
	}
	
	/** 增加setXXXX()方法,spring就可以通过autowire自动设置对象属性 */
	public void setTbuylogManager(TbuylogManager manager) {
		this.tbuylogManager = manager;
	}	
	
	public Object getModel() {
		return tbuylog;
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
		PageRequest<Map> pageRequest = newPageRequest(DEFAULT_SORT_COLUMNS);
		HttpServletRequest request = ServletActionContext.getRequest();
		//pageRequest.getFilters().put("key",value);     //add custom filter
		
        SecurityContext sc = SecurityContextHolder.getContext();
        Authentication auth = sc.getAuthentication();
        provMap = new TreeMap();

        MyUserDetails ud = null;
		String code ="";
		String pcscode = "";
		String pcsname = "";
		if ((auth != null) && auth.getPrincipal() instanceof MyUserDetails) {
			ud = (MyUserDetails) auth.getPrincipal();
			if (ud != null) {
				code = ud.getUsername();
			}
		}
		
		dateSelectMap  = DateUtil.getDateSelectData();
		String dateSelect19 = "";
		if (request.getParameter("dateSelect19") != null)
		    dateSelect19 = request.getParameter("dateSelect19");
			request.setAttribute("dateSelect19",dateSelect19);		        
		if (request.getParameter("s_logtimeBegin") != null){
			String s_logtimeBeginFormat = DateUtil.parseString(request,"s_logtimeBegin","yyyy-MM-dd","yyyyMMdd");
			pageRequest.getFilters().put("logtimeBeginFormat",s_logtimeBeginFormat);
			
		}
		if (request.getParameter("s_logtimeEnd") != null){
			String s_logtimeEndFormat = DateUtil.parseString(request,"s_logtimeEnd","yyyy-MM-dd","yyyyMMdd");
			pageRequest.getFilters().put("logtimeEndFormat",s_logtimeEndFormat);
		}
		
		pageRequest.getFilters().put("cpcode",code);
		
		Page page = tbuylogManager.findByPageRequest(pageRequest);
		savePage(page,pageRequest);
		return QUERY_JSP;
	}
	
	/** 执行搜索 */
	public String list() {
		PageRequest<Map> pageRequest = newPageRequest(DEFAULT_SORT_COLUMNS);
		HttpServletRequest request = ServletActionContext.getRequest();
		//pageRequest.getFilters().put("key",value);     //add custom filter
		String code ="";
		String deplevel ="";
        SecurityContext sc = SecurityContextHolder.getContext();
        Authentication auth = sc.getAuthentication();
        MyUserDetails ud = null;
        if ((auth != null) && auth.getPrincipal() instanceof MyUserDetails) {
			ud = (MyUserDetails) auth.getPrincipal();
			if (ud != null) {
				code = ud.getDeptID().toString();
				deplevel= ud.getDeptLevel();
			}
		}
        compMap = new TreeMap();
        
        if("2".equals(deplevel)){
			deplevel= " and burcode="+code;
			
		}else if("3".equals(deplevel)){
			deplevel= " and stacode="+code;
		}else{
			deplevel="";
		}
		List listcomp = tbuylogManager.findComp( deplevel);
		if(listcomp != null && listcomp.size() > 0){
			for(int j = 0; j<listcomp.size(); j++){
				SsDept ssdept = (SsDept) listcomp.get(j);
				String buildxh_temp = ssdept.getDeptcode();
				String buildNoName_temp = ssdept.getDeptname();
				compMap.put(buildxh_temp, buildNoName_temp);
			}
			compMap.put("", " 请选择...");
		}
		
        provMap = new TreeMap();
		qyxx( pageRequest);
		dateSelectMap  = DateUtil.getDateSelectData();
		String dateSelect19 = "";
		if (request.getParameter("dateSelect19") != null)
		    dateSelect19 = request.getParameter("dateSelect19");
			request.setAttribute("dateSelect19",dateSelect19);		        
		if (request.getParameter("s_logtimeBegin") != null){
			String s_logtimeBeginFormat = DateUtil.parseString(request,"s_logtimeBegin","yyyy-MM-dd","yyyyMMdd");
			pageRequest.getFilters().put("logtimeBeginFormat",s_logtimeBeginFormat);
			
		}
		if (request.getParameter("s_logtimeEnd") != null){
			String s_logtimeEndFormat = DateUtil.parseString(request,"s_logtimeEnd","yyyy-MM-dd","yyyyMMdd");
			pageRequest.getFilters().put("logtimeEndFormat",s_logtimeEndFormat);
		}
		pageRequest.getFilters().put("sortColumns","logtime desc");
		
		Page page = tbuylogManager.findByPageRequest(pageRequest);
		savePage(page,pageRequest);
		return LIST_JSP;
	}
	
	
	/**
	 * 初始三级联动下拉框赋值
	 */
	public void qyxx(PageRequest<Map> pageRequest){
		MyUserDetails ud = null;
		String code ="";
		String deplevel ="";
		String pcscode = "";
		String pcsname = "";
		SecurityContext sc = SecurityContextHolder.getContext();
		Authentication auth = sc.getAuthentication();
		if ((auth != null) && auth.getPrincipal() instanceof MyUserDetails) {
			ud = (MyUserDetails) auth.getPrincipal();
			if (ud != null) {
				code = ud.getDeptID().toString();
				deplevel = ud.getDeptLevel().toString();
			}
		}
		
		List listdept = tbuylogManager.findDept( " and CODE = '"+code +"'" );
		if(listdept != null && listdept.size() > 0){
			for(int j = 0; j<listdept.size(); j++){
				SsDept ssdept = (SsDept) listdept.get(j);
				String deptlevel = ssdept.getDeptlevel().toString();
				String buildxh_temp = ssdept.getDeptcode();
				String buildNoName_temp = ssdept.getDeptname();
				String buildburcode = ssdept.getParentid().toString();
				if("2".equals(deptlevel)){
					pageRequest.getFilters().put("burcode", buildxh_temp);
					provMap.put(buildxh_temp, buildNoName_temp);
				}else if ("3".equals(deptlevel)){
					pageRequest.getFilters().put("stacode", buildxh_temp);
					pcscode = buildxh_temp;
					pcsname = buildNoName_temp;
					List listburcode = tbuylogManager.findDept( "and  CODE = '"+buildburcode +"'" );
					if(listburcode != null && listburcode.size() > 0){
						for(int k = 0; k<listburcode.size(); k++){
							SsDept thotelfj = (SsDept) listburcode.get(k);
							String burcode = thotelfj.getDeptcode();
							String burname = thotelfj.getDeptname();
							provMap.put(burcode, burname);
						}
					}
				}else{
					List listconfig = tbuylogManager.findAllBureau();
					if (listconfig != null && listconfig.size() > 0) {
						for (int i = 0; i < listconfig.size(); i++) {
							SsDept thotelsj = (SsDept) listconfig.get(i);
							String sjcode = thotelsj.getDeptcode();
							String sjname = thotelsj.getDeptname();
							provMap.put(sjcode, sjname);
						}
						provMap.put("", "请选择...");
					}
				}
				
			}
		}else{
			List listconfig = tbuylogManager.findAllBureau();
			if (listconfig != null && listconfig.size() > 0) {
				for (int i = 0; i < listconfig.size(); i++) {
					SsDept tgas = (SsDept) listconfig.get(i);
					String buildxh_temp = tgas.getDeptcode();
					String buildNoName_temp = tgas.getDeptname();
					provMap.put(buildxh_temp, buildNoName_temp);
					
				}
				provMap.put("", "请选择...");
			}
		}
		HttpServletRequest request = ServletActionContext.getRequest();
		request.setAttribute("pcscode", pcscode);
		request.setAttribute("pcsname", pcsname);
	}
	
	
	/**
	 * 高危人群查询列表
	 * @return
	 */
	public String gwlist() {
		PageRequest<Map> pageRequest = newPageRequest(DEFAULT_SORT_COLUMNS);
		HttpServletRequest request = ServletActionContext.getRequest();
		//pageRequest.getFilters().put("key",value);     //add custom filter
		dateSelectMap  = DateUtil.getDateSelectData();
		provMap = new TreeMap();
		qyxx( pageRequest);
//		String gwxzqh = DictHelpImpl.getInitData("gwxzqh");
//		pageRequest.getFilters().put("xzqh",gwxzqh);
		String dateSelect19 = "";
		if (request.getParameter("dateSelect19") != null)
		    dateSelect19 = request.getParameter("dateSelect19");
			request.setAttribute("dateSelect19",dateSelect19);
			
		if (request.getParameter("s_logtimeBegin") != null){
			String s_logtimeBeginFormat = DateUtil.parseString(request,"s_logtimeBegin","yyyy-MM-dd","yyyyMMdd");
			pageRequest.getFilters().put("logtimeBeginFormat",s_logtimeBeginFormat);
			
		}
		if (request.getParameter("s_logtimeEnd") != null){
			String s_logtimeEndFormat = DateUtil.parseString(request,"s_logtimeEnd","yyyy-MM-dd","yyyyMMdd");
			pageRequest.getFilters().put("logtimeEndFormat",s_logtimeEndFormat);
		}
		
		String xzqhstring="";
		String citys ="";
		String gysl = DictHelpImpl.getInitData("gysl");
//		pageRequest.getFilters().put("quantity",gysl);
		if(!"".equals(pageRequest.getFilters().get("xzqh")) && pageRequest.getFilters().get("xzqh")!= null){
			xzqhstring =pageRequest.getFilters().get("xzqh").toString();
			String[] xzqh = xzqhstring.split(","); 
			for(int i =0; i<xzqh.length;i++){
				String city = xzqh[i].substring(0,2);
				if(i==0){
					citys = "substr(xzqh, 1, 2) ="+ city;
				}else{
					citys += " or substr(xzqh, 1,2) ="+ city;
				}
			}
			pageRequest.getFilters().put("xzqh", "("+ citys+")");
		}
		
		pageRequest.setSortColumns("logtime desc");
		
		Page page = tbuylogManager.gwfindByPageRequest(pageRequest);
		
		pageRequest.getFilters().put("xzqh", xzqhstring);
		savePage(page,pageRequest);
		return GWLIST_JSP;
	}
	/**
	 * 高危人群查询列表
	 * @return
	 */
	public String tzgwlist() {
		PageRequest<Map> pageRequest = newPageRequest(DEFAULT_SORT_COLUMNS);
		HttpServletRequest request = ServletActionContext.getRequest();
		//pageRequest.getFilters().put("key",value);     //add custom filter
		dateSelectMap  = DateUtil.getDateSelectData();
		provMap = new TreeMap();
		qyxx( pageRequest);
		
		String dateSelect19 = "";
		if (request.getParameter("dateSelect19") != null)
			dateSelect19 = request.getParameter("dateSelect19");
		request.setAttribute("dateSelect19",dateSelect19);		        
		if (request.getParameter("s_logtimeBegin") != null){
			String s_logtimeBeginFormat = DateUtil.parseString(request,"s_logtimeBegin","yyyy-MM-dd","yyyyMMdd");
			pageRequest.getFilters().put("logtimeBeginFormat",s_logtimeBeginFormat);
			
		}
		if (request.getParameter("s_logtimeEnd") != null){
			String s_logtimeEndFormat = DateUtil.parseString(request,"s_logtimeEnd","yyyy-MM-dd","yyyyMMdd");
			pageRequest.getFilters().put("logtimeEndFormat",s_logtimeEndFormat);
		}
		String xzqhstring="";
		String citys ="";
		String gwxzqh = DictHelpImpl.getInitData("gwxzqh");  //重点户籍地
		if(!"".equals(gwxzqh) && gwxzqh!= null){
			xzqhstring =gwxzqh.toString();
			String[] xzqh = xzqhstring.split(","); 
			for(int i =0; i<xzqh.length;i++){
				String city = xzqh[i].substring(0,2);
				if(i==0){
					citys = "substr(xzqh, 1, 2) ="+ city;
				}else{
					citys += " or substr(xzqh, 1,2) ="+ city;
				}
			}
			citys = "("+citys+")";
		}
		
		pageRequest.getFilters().put("xzqh", citys);
		pageRequest.setSortColumns("logtime desc");
		Page page = tbuylogManager.gwfindByPageRequest(pageRequest);
		
		pageRequest.getFilters().put("xzqh", xzqhstring);
		savePage(page,pageRequest);
		return TZGWLIST_JSP;
	}
	
	
	 
	/**
	 * 集中购油信息查询
	 * @return
	 */
	public String jzlist() {
		PageRequest<Map> pageRequest = newPageRequest(DEFAULT_SORT_COLUMNS);
		HttpServletRequest request = ServletActionContext.getRequest();
		provMap = new TreeMap();
		qyxx( pageRequest);
		dateSelectMap  = DateUtil.getDateSelectData();
		String dateSelect19 = "";
		if (request.getParameter("dateSelect19") != null)
		    dateSelect19 = request.getParameter("dateSelect19");
			request.setAttribute("dateSelect19",dateSelect19);		
		if (request.getParameter("s_logtimeBegin") != null){
			String s_logtimeBeginFormat = DateUtil.parseString(request,"s_logtimeBegin","yyyy-MM-dd","yyyyMMdd");
			pageRequest.getFilters().put("logtimeBeginFormat",s_logtimeBeginFormat);
			
		}
		if (request.getParameter("s_logtimeEnd") != null){
			String s_logtimeEndFormat = DateUtil.parseString(request,"s_logtimeEnd","yyyy-MM-dd","yyyyMMdd");
			pageRequest.getFilters().put("logtimeEndFormat",s_logtimeEndFormat);
		}
		pageRequest.getFilters().put("sortColumns","gycs desc");
		Page page = tbuylogManager.jzfindByPageRequest(pageRequest);
		savePage(page,pageRequest);
		return JZLIST_JSP;
	}
	
	
	
	/**
	 * 大量购油信息查询
	 * @return
	 */
	public String dllist() {
		PageRequest<Map> pageRequest = newPageRequest(DEFAULT_SORT_COLUMNS);
		HttpServletRequest request = ServletActionContext.getRequest();
		provMap = new TreeMap();
		qyxx( pageRequest);
		dateSelectMap  = DateUtil.getDateSelectData();
		String dateSelect19 = "";
		if (request.getParameter("dateSelect19") != null)
		    dateSelect19 = request.getParameter("dateSelect19");
			request.setAttribute("dateSelect19",dateSelect19);	
			
		if (request.getParameter("s_logtimeBegin") != null){
			String s_logtimeBeginFormat = DateUtil.parseString(request,"s_logtimeBegin","yyyy-MM-dd","yyyyMMdd");
			pageRequest.getFilters().put("logtimeBeginFormat",s_logtimeBeginFormat);
		}
		if (request.getParameter("s_logtimeEnd") != null){
			String s_logtimeEndFormat = DateUtil.parseString(request,"s_logtimeEnd","yyyy-MM-dd","yyyyMMdd");
			pageRequest.getFilters().put("logtimeEndFormat",s_logtimeEndFormat);
		}
		String gysl = DictHelpImpl.getInitData("gysl");
//		pageRequest.getFilters().put("quantity",gysl);
		pageRequest.getFilters().put("sortColumns","quantity desc");
		Page page = tbuylogManager.dlfindByPageRequest(pageRequest);
		savePage(page,pageRequest);
		return DLLIST_JSP;
	}
	
	/**
	 * 大量购油信息查询
	 * @return
	 */
	public String tzdllist() {
		PageRequest<Map> pageRequest = newPageRequest(DEFAULT_SORT_COLUMNS);
		HttpServletRequest request = ServletActionContext.getRequest();
		provMap = new TreeMap();
		qyxx( pageRequest);
		dateSelectMap  = DateUtil.getDateSelectData();
		String dateSelect19 = "";
		if (request.getParameter("dateSelect19") != null)
			dateSelect19 = request.getParameter("dateSelect19");
		request.setAttribute("dateSelect19",dateSelect19);		        
		if (request.getParameter("s_logtimeBegin") != null){
			String s_logtimeBeginFormat = DateUtil.parseString(request,"s_logtimeBegin","yyyy-MM-dd","yyyyMMdd");
			pageRequest.getFilters().put("logtimeBeginFormat",s_logtimeBeginFormat);
			
		}
		if (request.getParameter("s_logtimeEnd") != null){
			String s_logtimeEndFormat = DateUtil.parseString(request,"s_logtimeEnd","yyyy-MM-dd","yyyyMMdd");
			pageRequest.getFilters().put("logtimeEndFormat",s_logtimeEndFormat);
		}
		pageRequest.setSortColumns("logtime desc");
		Page page = tbuylogManager.dlfindByPageRequest(pageRequest);
		savePage(page,pageRequest);
		return TZDLLIST_JSP;
	}
	
	
	/**
	 * 频繁购油信息查询
	 * @return
	 */
	public String pflist() {
		PageRequest<Map> pageRequest = newPageRequest(DEFAULT_SORT_COLUMNS);
		HttpServletRequest request = ServletActionContext.getRequest();
		//pageRequest.getFilters().put("key",value);     //add custom filter
//		String gycs = DictHelpImpl.getInitData("gycs");
//		pageRequest.getFilters().put("gycs", gycs);
		provMap = new TreeMap();
		qyxx( pageRequest);
		dateSelectMap  = DateUtil.getDateSelectData();
		String dateSelect19 = "";
		if (request.getParameter("dateSelect19") != null)
		    dateSelect19 = request.getParameter("dateSelect19");
			request.setAttribute("dateSelect19",dateSelect19);		        
		if (request.getParameter("s_logtimeBegin") != null){
			String s_logtimeBeginFormat = DateUtil.parseString(request,"s_logtimeBegin","yyyy-MM-dd","yyyyMMdd");
			pageRequest.getFilters().put("logtimeBeginFormat",s_logtimeBeginFormat);
			
		}
		if (request.getParameter("s_logtimeEnd") != null){
			String s_logtimeEndFormat = DateUtil.parseString(request,"s_logtimeEnd","yyyy-MM-dd","yyyyMMdd");
			pageRequest.getFilters().put("logtimeEndFormat",s_logtimeEndFormat);
		}
		Page page = tbuylogManager.pffindByPageRequest(pageRequest);
		savePage(page,pageRequest);
		return PFLIST_JSP;
	}
	
	/**
	 * 频繁购油信息查询
	 * @return
	 */
	public String tzpflist() {
		PageRequest<Map> pageRequest = newPageRequest(DEFAULT_SORT_COLUMNS);
		HttpServletRequest request = ServletActionContext.getRequest();
		//pageRequest.getFilters().put("key",value);     //add custom filter
		
		provMap = new TreeMap();
		qyxx( pageRequest);
		dateSelectMap  = DateUtil.getDateSelectData();
		String dateSelect19 = "";
		if (request.getParameter("dateSelect19") != null)
			dateSelect19 = request.getParameter("dateSelect19");
		request.setAttribute("dateSelect19",dateSelect19);		        
		if (request.getParameter("s_logtimeBegin") != null){
			String s_logtimeBeginFormat = DateUtil.parseString(request,"s_logtimeBegin","yyyy-MM-dd","yyyyMMdd");
			pageRequest.getFilters().put("logtimeBeginFormat",s_logtimeBeginFormat);
			
		}
		if (request.getParameter("s_logtimeEnd") != null){
			String s_logtimeEndFormat = DateUtil.parseString(request,"s_logtimeEnd","yyyy-MM-dd","yyyyMMdd");
			pageRequest.getFilters().put("logtimeEndFormat",s_logtimeEndFormat);
		}
		String gycs = DictHelpImpl.getInitData("gycs");  //购油次数
		pageRequest.getFilters().put("gycs",gycs);
		Page page = tbuylogManager.pffindByPageRequest(pageRequest);
		savePage(page,pageRequest);
		return TZPFLIST_JSP;
	}
	
	/**
	 * 人员购油信息列表
	 * @return
	 */
	public String rygyshow(){
		PageRequest<Map> pageRequest = newPageRequest(DEFAULT_SORT_COLUMNS);
		HttpServletRequest request = ServletActionContext.getRequest();
		String idcode = null;

		if (request.getParameter("idcode") != null) {
			idcode = request.getParameter("idcode");
			pageRequest.getFilters().put("idCode", idcode);
		}
		pageRequest.setSortColumns("logtime desc");
		Page page = tbuylogManager.findByPageRequest(pageRequest);
		savePage(page,pageRequest);
		
		return GYLIST_JSP;
	}
	/**
	 * 人员购油信息列表
	 * @return
	 */
	public String tzrygyshow(){
		PageRequest<Map> pageRequest = newPageRequest(DEFAULT_SORT_COLUMNS);
		HttpServletRequest request = ServletActionContext.getRequest();
		String idcode = null;
		
		if (request.getParameter("idcode") != null) {
			idcode = request.getParameter("idcode");
			pageRequest.getFilters().put("idCode", idcode);
		}
		if (request.getParameter("s_logtimeBegin") != null){
			String s_logtimeBeginFormat = DateUtil.parseString(request,"s_logtimeBegin","yyyy-MM-dd","yyyyMMdd");
			pageRequest.getFilters().put("logtimeBeginFormat",s_logtimeBeginFormat);
			
		}
		if (request.getParameter("s_logtimeEnd") != null){
			String s_logtimeEndFormat = DateUtil.parseString(request,"s_logtimeEnd","yyyy-MM-dd","yyyyMMdd");
			pageRequest.getFilters().put("logtimeEndFormat",s_logtimeEndFormat);
		}
		pageRequest.setSortColumns("logtime desc");
		Page page = tbuylogManager.findByPageRequest(pageRequest);
		savePage(page,pageRequest);
		
		return TZGYLIST_JSP;
	}
	
	
	/**
	 * 集中购油信息列表
	 * @return
	 */
	public String jzgylist(){
		PageRequest<Map> pageRequest = newPageRequest(DEFAULT_SORT_COLUMNS);
		HttpServletRequest request = ServletActionContext.getRequest();
		String idcode = null;
		
		if (request.getParameter("cpcode") != null) {
			idcode = request.getParameter("cpcode");
			pageRequest.getFilters().put("stacode", idcode);
		}
		pageRequest.setSortColumns("logtime desc");
		Page page = tbuylogManager.findByPageRequest(pageRequest);
		savePage(page,pageRequest);
		
		return JZGYLIST_JSP;
	}
	/** 查看对象*/
	public String show() {
		HttpServletRequest request = ServletActionContext.getRequest();
		return SHOW_JSP;
	}
	
	/**治安综合详细页面*/
	public String zazhShow() {
		HttpServletRequest request = ServletActionContext.getRequest();
		return ZAZHSHOW_JSP;
	}
	
	/** 查看对象*/
	public String gyshow() {
		HttpServletRequest request = ServletActionContext.getRequest();
		return GYSHOW_JSP;
	}
	
	/** 查看对象*/
	public String tzxxgyshow() {
		HttpServletRequest request = ServletActionContext.getRequest();
		return TZXXGYSHOW_JSP;
	}
	
	/** 进入新增页面*/
	public String create() {
		SimpleDateFormat rq = new SimpleDateFormat("yyyy-MM-dd HH:mm");
		
		tbuylog.setLogtime(rq.format(new Date()));
		return CREATE_JSP;
	}
	
	/** 保存新增对象 */
	public String save() {
		HttpServletRequest request = ServletActionContext.getRequest();
		MyUserDetails ud = null;
		String cpcode ="";
		SecurityContext sc = SecurityContextHolder.getContext();
		Authentication auth = sc.getAuthentication();
		if ((auth != null) && auth.getPrincipal() instanceof MyUserDetails) {
			ud = (MyUserDetails) auth.getPrincipal();
			if (ud != null) {
				cpcode = ud.getUsername().toString();
			}
		}
		
		String bdate = DateUtil.parseString(request,"bdate","yyyy-MM-dd","yyyyMMdd");
		String logtime = DateUtil.parseString(request,"logtime","yyyy-MM-dd HH:mm","yyyyMMddHHmm");
		SimpleDateFormat rq = new SimpleDateFormat("yyyyMMddHHmm");
		tcompanyinfo= new Tcompanyinfo();
		tcompanyinfo = tcompanyinfogasManager.getById(cpcode);
		tbuylog.setBdate(bdate);
		tbuylog.setLogtime(logtime);
		tbuylog.setTratime(rq.format(new Date()));
		tbuylog.setCpcode(tcompanyinfo.getCpcode());
		tbuylog.setStacode(tcompanyinfo.getStacode());
		tbuylog.setBurcode(tcompanyinfo.getBurcode());
	
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
		String currentDate = sdf.format(new Date());	    
		String prefixID = cpcode + currentDate;
		String maxID = tbuylogManager.getCurrentMax(prefixID);
	    String max_end_id = "0";
	    if (maxID != null && !"".equals(maxID) && maxID.length() > 0) {
	    	max_end_id = maxID.substring(prefixID.length());
		}
	    int i_max_end_id = Integer.parseInt(max_end_id);
		i_max_end_id = i_max_end_id + 1;		
		String s_max_end_id = "0000"+i_max_end_id;
		s_max_end_id = s_max_end_id.substring(s_max_end_id.length()-4);
		tbuylog.setId(prefixID + s_max_end_id);
		tbuylogManager.save(tbuylog);
		if(tbuylog.getPPhotoBuffer() != null){
			tbuyPic = new TbuyPic();
			tbuyPic.setId(tbuylog.getId());
		    byte[] pic = getPicStringToByte(tbuylog.getPPhotoBuffer());
			tbuyPic.setPiclen(pic.length);
			tbuyPic.setPicture(pic);
			tbuyPicManager.save(tbuyPic);
		}   
		mgs="保存成功！";
		return create();
	}
	
	
	private static byte[] getPicStringToByte(String picture){
		BASE64Decoder decoder = new BASE64Decoder();
		byte[] bytePic = null;
		try {
			bytePic = decoder.decodeBuffer(picture);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return bytePic;
	}
	
	// 显示图片
	public String getPicture() {
		HttpServletRequest request = ServletActionContext.getRequest();
		String sql = request.getParameter("sql");
		if (sql != null && !sql .equals("")){
			List list = (List) tbuylogManager.getPicture(sql);
			request.setAttribute("list", list);
		}
		return SHOW_PIC;
	}
	
	/**进入更新页面*/
	public String edit() {
		HttpServletRequest request = ServletActionContext.getRequest();
		return EDIT_JSP;
	}
	
	/**保存更新对象*/
	public String update() {
		HttpServletRequest request = ServletActionContext.getRequest();
		tbuylogManager.update(this.tbuylog);
		return returnUrl;////LIST_ACTION;
	}
	
	/**删除对象*/
	public String delete() {
		for(int i = 0; i < items.length; i++) {
			Hashtable params = HttpUtils.parseQueryString(items[i]);
			java.lang.String id = new java.lang.String((String)params.get("id"));
			tbuylogManager.removeById(id);
		}
		return returnUrl ;//LIST_ACTION;
	}

	public TreeMap<String, String> getProvMap() {
		return provMap;
	}

	public void setProvMap(TreeMap<String, String> provMap) {
		this.provMap = provMap;
	}

	public void setSsCommonManager(SsCommonManager ssCommonManager) {
		this.ssCommonManager = ssCommonManager;
	}

	public void setTbuyPicManager(TbuyPicManager tbuyPicManager) {
		this.tbuyPicManager = tbuyPicManager;
	}

	public void setTcompanyinfogasManager(TcompanyinfogasManager tcompanyinfogasManager) {
		this.tcompanyinfogasManager = tcompanyinfogasManager;
	}

	public String getMgs() {
		return mgs;
	}

	public void setMgs(String mgs) {
		this.mgs = mgs;
	}

	public TreeMap<String, String> getCompMap() {
		return compMap;
	}

	public void setCompMap(TreeMap<String, String> compMap) {
		this.compMap = compMap;
	}

}
