/*
 * Powered By [lishicheng]
 */

package com.dyneinfo.fjy.action;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import javacommon.base.BaseStruts2Action;

import javax.servlet.http.HttpServletRequest;

import net.java.dev.common.util.DateUtil;
import net.java.dev.common.util.SpringTagFunctions;

import org.apache.struts2.ServletActionContext;
import org.security.userdetails.MyUserDetails;

import cn.org.rapid_framework.page.Page;
import cn.org.rapid_framework.page.PageRequest;

import com.dyneinfo.fjy.model.TelInfoView;
import com.dyneinfo.fjy.service.TelInfoViewManager;
import com.dyneinfo.zazh.model.DoubleselectCity;
import com.dyneinfo.zazh.model.DoubleselectProv;
import com.dyneinfo.zazh.service.SsCommonManager;
import com.opensymphony.xwork2.ModelDriven;
import com.opensymphony.xwork2.Preparable;

/**
 * @author lisc email:lishicheng(a)gmail.com
 */


public class TelInfoViewAction extends BaseStruts2Action implements Preparable,ModelDriven{
	//默认多列排序,example: username desc,createTime asc
	protected static final String DEFAULT_SORT_COLUMNS = null; 
	
	//forward paths
	protected static final String LIST_JSP= "/pages/fjy/TelInfoView/list.jsp";
	protected static final String EDIT_JSP = "/pages/fjy/TelInfo/edit.jsp";
	protected static final String SHOW_JSP = "/pages/fjy/TelInfoView/show.jsp";
	
	protected static final String LISTALL_JSP= "/pages/fjy/TelInfoView/listAll.jsp";
	protected static final String SHOWALL_JSP = "/pages/fjy/TelInfoView/showAll.jsp";

	
	private TelInfoViewManager telInfoViewManager;
	private SsCommonManager ssCommonManager;
	
	private TelInfoView telInfoView;
	java.lang.String id = null;
	private String[] items;
	private String returnUrl;  //返回列表，保留查询条件
	private TreeMap<String, String> dateSelectMap;// //日期选择
	
	TreeMap<String,String> jbrMap ;
	
	//手机型号 双选框
	private List<DoubleselectProv> provList;
	private Map<String, List<DoubleselectCity>> cityMap;

	public void prepare() throws Exception {
		if (isNullOrEmptyString(id)) {
			telInfoView = new TelInfoView();
		} else {
			telInfoView = (TelInfoView)telInfoViewManager.getById(id);
		}
	}
	
	/** 增加setXXXX()方法,spring就可以通过autowire自动设置对象属性 */
	public void setTelInfoViewManager(TelInfoViewManager manager) {
		this.telInfoViewManager = manager;
	}	
	
	public Object getModel() {
		return telInfoView;
	}
	
	public void setTelinfoid(java.lang.String val) {
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
	
		if(SpringTagFunctions.ifAnyGranted("ROLE_QUERY_ALL,ROLE_ADMIN")){
			
		} else if(SpringTagFunctions.ifAnyGranted("ROLE_QUERY_CURRENT_ORG")){
			pageRequest.getFilters().put("cpcode",deptid);
		} else if(SpringTagFunctions.ifAnyGranted("ROLE_QUERY_CHILD_ORG")){
			pageRequest.getFilters().put("deptSeq",deptseq);
		} else {
			pageRequest.getFilters().put("cpcode",deptid);
		}
		
		dateSelectMap  = DateUtil.getDateSelectData();
		// 手机品牌型号联动选择框
		 getMobilePPXH();
		String s_telpp = "",s_telxh="";
		if (request.getParameter("s_telpp") != null)
			s_telpp = request.getParameter("s_telpp");
		request.setAttribute("defaultItem",s_telpp);
		if (request.getParameter("s_telxh") != null)
			s_telxh = request.getParameter("s_telxh");
		request.setAttribute("doubleDefaultItem",s_telxh);
		
		
		String dateSelect12 = "";
		if (request.getParameter("dateSelect12") != null)
		    dateSelect12 = request.getParameter("dateSelect12");
			request.setAttribute("dateSelect12",dateSelect12);		        
		String dateSelect16 = "";
		if (request.getParameter("dateSelect16") != null)
		    dateSelect16 = request.getParameter("dateSelect16");
			request.setAttribute("dateSelect16",dateSelect16);	
			
		
		pageRequest.getFilters().put("inputFormat","yyyy-MM-dd");
		
		
//		String s_jxxlh = "";
//		if (request.getParameter("s_jxxlh") != null){
//			s_jxxlh = request.getParameter("s_jxxlh");
//			s_jxxlh = "%".concat(s_jxxlh).concat("%");
//		    pageRequest.getFilters().put("jxxlhLike",s_jxxlh);
//		}
		
		Page page = telInfoViewManager.findByPageRequest(pageRequest);
		savePage(page,pageRequest);
		return LIST_JSP;
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
			pageRequest.getFilters().put("cpcode",deptid);
		} else if(SpringTagFunctions.ifAnyGranted("ROLE_QUERY_CHILD_ORG")){
			pageRequest.getFilters().put("deptSeq",deptseq);
		} else {
			pageRequest.getFilters().put("cpcode",deptid);
		}
		
		
		dateSelectMap  = DateUtil.getDateSelectData();
		// 手机品牌型号联动选择框
		 getMobilePPXH();
		String s_telpp = "",s_telxh="";
		if (request.getParameter("s_telpp") != null)
			s_telpp = request.getParameter("s_telpp");
		request.setAttribute("defaultItem",s_telpp);
		if (request.getParameter("s_telxh") != null)
			s_telxh = request.getParameter("s_telxh");
		request.setAttribute("doubleDefaultItem",s_telxh);
		
		
		String s_cpcode = "";
		if (request.getParameter("s_cpcode") != null){
			s_cpcode = request.getParameter("s_cpcode");
			request.setAttribute("s_cpcode", s_cpcode);	
		    String  s_cpcodeSearchVaue =   s_cpcode.concat("%");
		    pageRequest.getFilters().put("deptSeq",s_cpcodeSearchVaue);
		}
		
		
		String dateSelect12 = "";
		if (request.getParameter("dateSelect12") != null)
		    dateSelect12 = request.getParameter("dateSelect12");
			request.setAttribute("dateSelect12",dateSelect12);		        
		String dateSelect16 = "";
		if (request.getParameter("dateSelect16") != null)
		    dateSelect16 = request.getParameter("dateSelect16");
			request.setAttribute("dateSelect16",dateSelect16);	
			
	   pageRequest.getFilters().put("inputFormat","yyyy-MM-dd");  
		
		String s_jxxlh = "";
		if (request.getParameter("s_jxxlh") != null){
			s_jxxlh = request.getParameter("s_jxxlh");
			s_jxxlh = "%".concat(s_jxxlh).concat("%");
		    pageRequest.getFilters().put("jxxlhLike",s_jxxlh);
		}
		
		Page page = telInfoViewManager.findByPageRequest(pageRequest);
		savePage(page,pageRequest);
		return LISTALL_JSP;
	}
	
	/** 查看对象*/
	public String show() {
		HttpServletRequest request = ServletActionContext.getRequest();
		String gjsj =  telInfoView.getGjsj();
		String gjsjFormat = DateUtil.parseString(gjsj,"yyyyMMddHHmmss","yyyy-MM-dd HH:mm:ss");
		telInfoView.setGjsj(gjsjFormat);
		
		String sbutton = "";
		if (request.getParameter("sbutton") != null)
			sbutton = request.getParameter("sbutton");
		request.setAttribute("sbutton",sbutton);	
		
		return SHOW_JSP;
	}
	
	public String showAll() {
		HttpServletRequest request = ServletActionContext.getRequest();
		String gjsj =  telInfoView.getGjsj();
		String gjsjFormat = DateUtil.parseString(gjsj,"yyyyMMddHHmmss","yyyy-MM-dd HH:mm:ss");
		telInfoView.setGjsj(gjsjFormat);
		
		String sbutton = "";
		if (request.getParameter("sbutton") != null)
			sbutton = request.getParameter("sbutton");
		request.setAttribute("sbutton",sbutton);	
		
		return SHOWALL_JSP;
	}

	
	/**进入更新页面*/
	public String edit() {
		HttpServletRequest request = ServletActionContext.getRequest();
		// 手机品牌型号联动选择框
		 getMobilePPXH();
		String s_telpp = "",s_telxh="";
		if (telInfoView != null && telInfoView.getTelpp() != null)
			s_telpp = telInfoView.getTelpp();
		request.setAttribute("defaultItem",s_telpp);
		if (telInfoView != null && telInfoView.getTelxh() != null)
			s_telxh =  telInfoView.getTelxh();
		request.setAttribute("doubleDefaultItem",s_telxh);
		
		String gjsj =  telInfoView.getGjsj();
		String gjsjFormat = DateUtil.parseString(gjsj,"yyyyMMddHHmmss","yyyy-MM-dd HH:mm:ss");
		telInfoView.setGjsj(gjsjFormat);
		
		
		String deptID = "";
		MyUserDetails userDetail = null;
		userDetail = SpringTagFunctions.getUserDetails();
		if (userDetail != null) {
			deptID = userDetail.getDeptID();
		}
		
		
		String sql = "select  EMPCODE,EMPNAME  from T_EMPLOYEE where CPCODE ='"+deptID+"'";
		jbrMap = new TreeMap();
		List staList = ssCommonManager.getSjpp(sql);
		if (staList != null) {
			for (int j = 0; j < staList.size(); j++) {
				Map staResults = (HashMap) staList.get(j);
				String staCODE = (String) staResults.get("CODE");
				String staCALLED = (String) staResults.get("CALLED");
				jbrMap.put(staCODE, staCALLED);
			}
		}
		
		
		return EDIT_JSP;
	}
	

	

	
	
	
	
	
	
	
	public List<DoubleselectProv> getProvList() {
		return provList;
	}

	public void setProvList(List<DoubleselectProv> provList) {
		this.provList = provList;
	}

	public Map<String, List<DoubleselectCity>> getCityMap() {
		return cityMap;
	}

	public void setCityMap(Map<String, List<DoubleselectCity>> cityMap) {
		this.cityMap = cityMap;
	}

	public SsCommonManager getSsCommonManager() {
		return ssCommonManager;
	}

	public void setSsCommonManager(SsCommonManager ssCommonManager) {
		this.ssCommonManager = ssCommonManager;
	}
	
	public void getMobilePPXH() {
		// 手机品牌型号联动选择框
		String sql = "select  CODE,CALLED  from T_DIC_SJPP";
		List list = (List) ssCommonManager.getSjpp(sql);
		provList = new ArrayList<DoubleselectProv>();
		cityMap = new HashMap<String, List<DoubleselectCity>>();
		DoubleselectProv doubleselectProv;
		DoubleselectCity city;

		doubleselectProv = new DoubleselectProv();
		doubleselectProv.setId("");
		doubleselectProv.setName("请选择...");
		provList.add(doubleselectProv);

		List<DoubleselectCity> cityList_start = new ArrayList<DoubleselectCity>();
		city = new DoubleselectCity();
		city.setId("");
		city.setName("请选择...");
		city.setDoubleselectProvId("");
		cityList_start.add(city);
		cityMap.put("", cityList_start);

		if (list != null) {
			for (int i = 0; i < list.size(); i++) {
				Map results = (HashMap) list.get(i);
				String CODE = (String) results.get("CODE");
				String CALLED = (String) results.get("CALLED");

				doubleselectProv = new DoubleselectProv();
				doubleselectProv.setId(CODE);
				doubleselectProv.setName(CALLED);
				provList.add(doubleselectProv);
				// 手机型号代码数据
				List staList = (List) ssCommonManager
						.getSjxh(" where  PPCODE= '" + CODE + "'");
				List<DoubleselectCity> cityList = new ArrayList<DoubleselectCity>();
				city = new DoubleselectCity();
				city.setId("");
				city.setName("请选择...");
				city.setDoubleselectProvId(CODE);
				cityList.add(city);
				if (staList != null) {
					for (int j = 0; j < staList.size(); j++) {
						Map staResults = (HashMap) staList.get(j);
						String staCODE = (String) staResults.get("CODE");
						String staCALLED = (String) staResults.get("CALLED");
						city = new DoubleselectCity();
						city.setId(staCODE);
						city.setName(staCALLED);
						city.setDoubleselectProvId(CODE);
						cityList.add(city);
					}
				}
				cityMap.put(CODE, cityList);
			}
		}
		// //手机品牌型号联动选择框 结束
	}

	public TreeMap<String, String> getJbrMap() {
		return jbrMap;
	}

	public void setJbrMap(TreeMap<String, String> jbrMap) {
		this.jbrMap = jbrMap;
	}

}
