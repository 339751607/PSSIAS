/*
 * Powered By [lishicheng]
 */

package com.dyneinfo.jxy.action;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import java.util.Hashtable;
import java.util.List;
import java.util.Map;
import java.util.HashMap;
import java.util.TreeMap;

import javacommon.base.BaseStruts2Action;
import net.java.dev.common.dict.taglib.DictHelpImpl;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import net.java.dev.common.dict.ISelectOption;
import net.java.dev.common.util.DateUtil;
import net.java.dev.common.util.SpringTagFunctions;


import org.apache.struts2.ServletActionContext;
import org.security.userdetails.MyUserDetails;
import org.springframework.security.Authentication;
import org.springframework.security.context.SecurityContext;
import org.springframework.security.context.SecurityContextHolder;

import cn.org.rapid_framework.page.Page;
import cn.org.rapid_framework.page.PageRequest;
import cn.org.rapid_framework.web.util.HttpUtils;
import org.apache.commons.lang.StringUtils;

import com.dyneinfo.hotel.model.TjwPre;
import com.dyneinfo.jxy.model.Tcarinfo;
import com.dyneinfo.jxy.model.Tcarreturn;
import com.dyneinfo.jxy.service.TcarinfoManager;
import com.dyneinfo.jxy.service.TcarreturnManager;
import com.dyneinfo.jxy.service.TcpinfojxyManager;
import com.opensymphony.xwork2.ModelDriven;
import com.opensymphony.xwork2.Preparable;

/**
 * @author lisc email:lishicheng(a)gmail.com
 */

public class TcarinfoAction extends BaseStruts2Action implements Preparable,
		ModelDriven {
	// 默认多列排序,example: username desc,createTime asc
	protected static final String DEFAULT_SORT_COLUMNS = "enroltime desc";

	// forward paths
	protected static final String QUERY_JSP = "/pages/jxy/Tcarinfo/query.jsp";
	protected static final String LIST_JSP = "/pages/jxy/Tcarinfo/list.jsp";
	protected static final String RYLIST_JSP = "/pages/jxy/Tcarinfo/rylist.jsp";
	protected static final String CREATE_JSP = "/pages/jxy/Tcarinfo/create.jsp";
	protected static final String EDIT_JSP = "/pages/jxy/Tcarinfo/edit.jsp";
	protected static final String COLLECT_JSP = "/pages/jxy/Tcarinfo/collect.jsp";
	protected static final String SHOW_JSP = "/pages/jxy/Tcarinfo/show.jsp";
	protected static final String ZAZHSHOW_JSP = "/pages/jxy/Tcarinfo/zazhShow.jsp";
	protected static final String SHOW_VCARRETURN ="/pages/jxy/Vcarreturn/show.jsp";
	protected static final String SHOW1_JSP = "/pages/jxy/Tcarinfo/show1.jsp";
	protected static final String VIEW_JSP = "/pages/jxy/Tcarinfo/view.jsp";
	protected static final String LIST1_JSP="/pages/jxy/Tcarinfo/list1.jsp";
	// redirect paths,startWith: !
	protected static final String LIST_ACTION = "!/jxy/Tcarinfo/list.do";

	protected static final String UPDATEPHOTOERROR = "/pages/jxy/pic/updateFileError.jsp";
	protected static final String SHOW_PIC = "/pages/jxy/pic/pic.jsp";
	protected static final String UPDATEPHOTOSUCCESS = "/pages/jxy/pic/uploadFileSuccess.jsp";
	protected static final String UPDATEPHOTOFAILURE = "/pages/jxy/pic/uploadFileFailure.jsp";

	private TcarinfoManager tcarinfoManager;
	private TcarreturnManager tcarreturnManager;
	private TcpinfojxyManager tcpinfojxyManager;
	public void setTcpinfojxyManager(TcpinfojxyManager manager) {
		this.tcpinfojxyManager = manager;
	}
	private Tcarinfo tcarinfo;
	java.lang.String id = null;
	private String[] items;
	private String returnUrl; // 返回列表，保留查询条件
	private TreeMap<String, String> dateSelectMap;// //日期选择
	TreeMap<String, String> serverItemSelectMap;
	private File file;
	private String fileFileName;
	private String fileContentType;
	private long FilemaxSize = 3 * (1024 * 1024); // 照片字节

	private String deptId = ""; // 部门编号
	private int userId; // 用户id
	private String userName = ""; // 用户名

	public void prepare() throws Exception {
		setUserDetails();
		if (isNullOrEmptyString(id)) {
			tcarinfo = new Tcarinfo();
		} else {

			tcarinfo = (Tcarinfo) tcarinfoManager.getById(id);
		}
	}

	/** 进入查询页面 */
	public String query() {
		// 日历快速选择用到
		dateSelectMap = DateUtil.getDateSelectData();
		return QUERY_JSP;
	}

	//通用车辆信息查询，湛江list1()
	/** 执行搜索 */
	public String list() {
		PageRequest<Map> pageRequest = newPageRequest(DEFAULT_SORT_COLUMNS);
		HttpServletRequest request = ServletActionContext.getRequest();

		

		String clsbcode = "";
		if(request.getParameter("s_clsbcode") != null){
			clsbcode = request.getParameter("s_clsbcode");
			pageRequest.getFilters().put("clsbcode", clsbcode);
			//System.out.println(clsbcode+"--------------+");
		}

		
		dateSelectMap = DateUtil.getDateSelectData();
		String dateSelect1 = "";
		if (request.getParameter("dateSelect1") != null)
			dateSelect1 = request.getParameter("dateSelect1");
		request.setAttribute("dateSelect1", dateSelect1);
		String dateSelect2 = "";
		if (request.getParameter("dateSelect2") != null)
			dateSelect2 = request.getParameter("dateSelect2");
		request.setAttribute("dateSelect2", dateSelect2);
		
		
		//Integer.parseInt("ddd");
		
		
		serverItemSelectMap = new TreeMap();
		
		serverItemSelectMap.put("","请选择...");
		List serveritem = tcarinfoManager.getServeritemForLevelOne();
		for (int i = 0; i < serveritem.size(); i++) {
			Map map = (Map) serveritem.get(i);
			serverItemSelectMap.put(map.get("dictid").toString(), map.get("dictname").toString());
			
		}
		
		///xtvfhpwfn
		String serveritem1="";
		if(request.getParameter("serveritem") != null){
		 serveritem1 = this.util(request.getParameter("serveritem"));
		 request.setAttribute("serveritem", serveritem1);
		
		}
		String s_serveritem = "";
		if (request.getParameter("s_serveritem") != null)
			s_serveritem = request.getParameter("s_serveritem");
		request.setAttribute("s_serveritem", s_serveritem);
		
		
		String s_sgcl = "";
		if (request.getParameter("s_sgcl") != null)
			s_sgcl = request.getParameter("s_sgcl");
		if(StringUtils.isNotEmpty(s_sgcl) && StringUtils.equals("1", s_sgcl)){	//事故车辆
			pageRequest.getFilters().put("existSql", "  exists (select * from T_CARCASEINFO d where d.ENROLID = t.enrolid)  ");
		} else if(StringUtils.isNotEmpty(s_sgcl) && StringUtils.equals("0", s_sgcl)){	//不是事故车辆
			pageRequest.getFilters().put("notExistSql", " not exists (select * from T_CARCASEINFO d where d.ENROLID = t.enrolid) ");
		}

		pageRequest.getFilters().put("deptid", deptId);
		pageRequest.getFilters().put("serveritem", serveritem1);

		String s_enroltimeBeginFormat = DateUtil.parseString(request,
				"s_enroltimeBegin", "yyyy-MM-dd HH:mm", "yyyyMMddHHmm");
		String s_enroltimeEndFormat = DateUtil.parseString(request,
				"s_enroltimeEnd", "yyyy-MM-dd HH:mm", "yyyyMMddHHmm");
		pageRequest.getFilters().put("enroltimeBeginFormat",
				s_enroltimeBeginFormat);
		pageRequest.getFilters()
				.put("enroltimeEndFormat", s_enroltimeEndFormat);

		String s_totimeBeginFormat = DateUtil.parseString(request,
				"s_totimeBegin", "yyyy-MM-dd HH:mm", "yyyyMMddHHmm");
		String s_totimeEndFormat = DateUtil.parseString(request, "s_totimeEnd",
				"yyyy-MM-dd HH:mm", "yyyyMMddHHmm");
		pageRequest.getFilters().put("totimeBeginFormat", s_totimeBeginFormat);
		pageRequest.getFilters().put("totimeEndFormat", s_totimeEndFormat);

		String s_carid1 = "";
		if (request.getParameter("s_carid1") != null)
			s_carid1 = request.getParameter("s_carid1");
		request.setAttribute("s_carid1", s_carid1);
		String s_carid2 = "";
		if (request.getParameter("s_carid2") != null)
			s_carid2 = request.getParameter("s_carid2");
		request.setAttribute("s_carid2", s_carid2);

		pageRequest.getFilters().put("carid", s_carid1 + s_carid2);
		
		
		
		//xtvfhpwfn
		StringBuffer data = new StringBuffer("var ja=[];");
		 serveritem = tcarinfoManager.getServeritemForLevelOne();
		if (serveritem != null) {
			for (int i = 0; i < serveritem.size(); i++) {
				Map map = (Map) serveritem.get(i);
				if(map.get("dictlevel") != null && map.get("dictlevel").toString().equals("1"))
					data.append("\r\n");
				data.append("ja['"+map.get("dictid")+"']='"+map.get("dictname")+"';");
			}
		}
		request.setAttribute("data", data);
		
		
		StringBuffer dataTwo = new StringBuffer("var menus=new Array(new Array('1','信息','0'),");
		List serveritemTwo = tcarinfoManager.getServeritemForLevelTwo();
		if (serveritemTwo != null) {
			for (int i = 0; i < serveritemTwo.size(); i++) {
				Map map = (Map) serveritemTwo.get(i);
				dataTwo.append("new Array('"+map.get("dictid")+"','"+map.get("dictname")+"','"+map.get("parentid")+"'),");
			}
		}
		dataTwo.append("'');");
		request.setAttribute("dataTwo", dataTwo);

		Page page = tcarinfoManager.findByPageRequest(pageRequest);
		savePage(page, pageRequest);
		return LIST_JSP;
	}
	
	
	/**
	 * 查询车主 送车人信息
	 * 
	 * @return
	 */
	public String queryczxx() {
		String back = "";
		PageRequest<Map> pageRequest = newPageRequest(DEFAULT_SORT_COLUMNS);
		HttpServletRequest request = ServletActionContext.getRequest();
		String ajax = request.getParameter("ajax");
		try {
			request.setCharacterEncoding("utf-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		if (request.getParameter("carowner") != null
				&& !"".equals(request.getParameter("carowner"))) {
			String carowner = null;
			try {
				carowner = URLDecoder.decode(request.getParameter("carowner"),
						"UTF-8").trim();
			} catch (UnsupportedEncodingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			pageRequest.getFilters().put("carowner", carowner);
		}
		if (request.getParameter("deliname") != null
				&& !"".equals(request.getParameter("deliname"))) {
			String deliname = null;
			try {
				deliname = URLDecoder.decode(request.getParameter("deliname"),
				"UTF-8").trim();
			} catch (UnsupportedEncodingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			pageRequest.getFilters().put("deliname", deliname);
		}
		if (request.getParameter("cp") != null
				&& !"".equals(request.getParameter("cp"))) {
			pageRequest.getFilters().put("carid", request.getParameter("cp"));
		}
		
		
		String deptID = "";
		MyUserDetails userDetail = null;
		userDetail = SpringTagFunctions.getUserDetails();
		if (userDetail != null) {
			deptID = userDetail.getDeptID();
		}
		
		pageRequest.getFilters().put("deptid", deptID);

		Page page = tcarinfoManager.findByPageRequest(pageRequest);
		savePage(page, pageRequest);
		if (page.getResult().size() == 0) {
			back = null;
		} else if (page.getResult().size() == 1) {
			Tcarinfo dd = new Tcarinfo();
			List<Tcarinfo> dd1 = page.getResult();
			tcarinfo = dd1.get(0);
			StringBuffer html = new StringBuffer();
			String flag = "";
			html.append("{carowner: '");
			html.append(tcarinfo.getCarowner());// 车主
			html.append("',");

			html.append("deliname: '");
			html.append(tcarinfo.getDeliname());// 送车人姓名
			html.append("',");

			html.append("delicredcode: '");
			html.append(tcarinfo.getDelicredcode());// 送车人证件号码
			html.append("',");

			html.append("delitelephone: '");
			html.append(tcarinfo.getDelitelephone());// 送车人电话
			html.append("',");

			html.append("deliaddress: '");
			html.append(tcarinfo.getDeliaddress() != null ? tcarinfo.getDeliaddress():"");// 送车人住址
			html.append("',");

			html.append("cartype: '");
			html.append(tcarinfo.getCartype());// 车辆类型
			html.append("',");
			html.append("brand: '");
			html.append(tcarinfo.getBrand() != null ? tcarinfo.getBrand()
					.toString().trim() : "");// 车辆品牌
			html.append("',");
			html.append("color1: '");
			html.append(tcarinfo.getColor() != null ? tcarinfo.getColor()
					.toString().substring(0, 1) : "");// 车辆颜色1
			html.append("',");
			html.append("color2: '");
			html.append(tcarinfo.getColor() != null
					&& tcarinfo.getColor().toString().length() > 1 ? tcarinfo
					.getColor().toString().substring(1, 2) : "");// 车辆颜色2
			html.append("',");
			html.append("color3: '");
			html.append(tcarinfo.getColor() != null
					&& tcarinfo.getColor().toString().length() > 2 ? tcarinfo
					.getColor().toString().substring(2, 3) : "");// 车辆颜色3
			html.append("',");

			html.append("carid1: '");
			html.append(tcarinfo.getCarid() != null ? tcarinfo.getCarid()
					.toString().substring(0, 1) : "");// 车牌
			html.append("',");
			html.append("carid2: '");
			html.append(tcarinfo.getCarid() != null ? tcarinfo.getCarid()
					.toString().substring(1) : "");// 车牌号
			html.append("',");

			html.append("clsbcode: '");
			html.append(tcarinfo.getClsbcode() != null ?tcarinfo.getClsbcode() : "");  //车辆识别代码
			html.append("',");

			html.append("enginecode: '");
			html.append(tcarinfo.getEnginecode() != null ? tcarinfo
					.getEnginecode() : "");// 发动机号
			html.append("',");
			html.append("bodycode: '");
			html.append(tcarinfo.getBodycode() != null ? tcarinfo.getBodycode()
					: "");// 车架号
			html.append("'}");

			if (ajax != null && ajax.equals("true")) {
				try {
					byte[] contents = html.toString().getBytes("UTF-8");
					getResponse().getOutputStream().write(contents);
				} catch (IOException e) {
					e.printStackTrace();
				}
				return null;
			}

			back = html.toString();

		} else {

			back = RYLIST_JSP;
		}
		return back;
	}
	
	
	//湛江车辆信息查询
	public String list1() {
		PageRequest<Map> pageRequest = newPageRequest(DEFAULT_SORT_COLUMNS);
		HttpServletRequest request = ServletActionContext.getRequest();

		String clsbcode = "";
		if(request.getParameter("s_clsbcode") != null){
			clsbcode = request.getParameter("s_clsbcode");
			pageRequest.getFilters().put("clsbcode", clsbcode);
			System.out.println(clsbcode+"--------------+");
		}		
		
		SecurityContext sc = SecurityContextHolder.getContext();
		Authentication auth = sc.getAuthentication();
		MyUserDetails ud = null;
	
		
		String deptseq ="";
		if ((auth != null) && auth.getPrincipal() instanceof MyUserDetails) {
			ud = (MyUserDetails) auth.getPrincipal();
			if (ud != null) {
			
				deptseq = ud.getDeptSeq();
			}
		}
		
		String dept=request.getParameter("s_deptseq");
		if(dept!=null && !dept.equals("")){
			
			deptseq=dept;
		}
		

		
		dateSelectMap = DateUtil.getDateSelectData();
		String dateSelect1 = "";
		if (request.getParameter("dateSelect1") != null)
			dateSelect1 = request.getParameter("dateSelect1");
		request.setAttribute("dateSelect1", dateSelect1);
		String dateSelect2 = "";
		if (request.getParameter("dateSelect2") != null)
			dateSelect2 = request.getParameter("dateSelect2");
		request.setAttribute("dateSelect2", dateSelect2);
		
		
		//Integer.parseInt("ddd");
		
		
		serverItemSelectMap = new TreeMap();
		
		serverItemSelectMap.put("","请选择...");
		List serveritem = tcarinfoManager.getServeritemForLevelOne();
		for (int i = 0; i < serveritem.size(); i++) {
			Map map = (Map) serveritem.get(i);
			serverItemSelectMap.put(map.get("dictid").toString(), map.get("dictname").toString());
			
		}
		
		///xtvfhpwfn
		String serveritem1="";
		if(request.getParameter("serveritem") != null){
		 serveritem1 = this.util(request.getParameter("serveritem"));
		 request.setAttribute("serveritem", serveritem1);
		
		}
		String s_serveritem = "";
		if (request.getParameter("s_serveritem") != null)
			s_serveritem = request.getParameter("s_serveritem");
		request.setAttribute("s_serveritem", s_serveritem);
		
		
		String s_sgcl = "";
		if (request.getParameter("s_sgcl") != null)
			s_sgcl = request.getParameter("s_sgcl");
		if(StringUtils.isNotEmpty(s_sgcl) && StringUtils.equals("1", s_sgcl)){	//事故车辆
			pageRequest.getFilters().put("existSql", "  exists (select * from T_CARCASEINFO d where d.ENROLID = t.enrolid)  ");
		} else if(StringUtils.isNotEmpty(s_sgcl) && StringUtils.equals("0", s_sgcl)){	//不是事故车辆
			pageRequest.getFilters().put("notExistSql", " not exists (select * from T_CARCASEINFO d where d.ENROLID = t.enrolid) ");
		}

		pageRequest.getFilters().put("deptid", deptseq);
		pageRequest.getFilters().put("serveritem", serveritem1);

		String s_enroltimeBeginFormat = DateUtil.parseString(request,
				"s_enroltimeBegin", "yyyy-MM-dd HH:mm", "yyyyMMddHHmm");
		String s_enroltimeEndFormat = DateUtil.parseString(request,
				"s_enroltimeEnd", "yyyy-MM-dd HH:mm", "yyyyMMddHHmm");
		pageRequest.getFilters().put("enroltimeBeginFormat",
				s_enroltimeBeginFormat);
		pageRequest.getFilters()
				.put("enroltimeEndFormat", s_enroltimeEndFormat);

		String s_totimeBeginFormat = DateUtil.parseString(request,
				"s_totimeBegin", "yyyy-MM-dd HH:mm", "yyyyMMddHHmm");
		String s_totimeEndFormat = DateUtil.parseString(request, "s_totimeEnd",
				"yyyy-MM-dd HH:mm", "yyyyMMddHHmm");
		pageRequest.getFilters().put("totimeBeginFormat", s_totimeBeginFormat);
		pageRequest.getFilters().put("totimeEndFormat", s_totimeEndFormat);

		String s_carid1 = "";
		if (request.getParameter("s_carid1") != null)
			s_carid1 = request.getParameter("s_carid1");
		request.setAttribute("s_carid1", s_carid1);
		String s_carid2 = "";
		if (request.getParameter("s_carid2") != null)
			s_carid2 = request.getParameter("s_carid2");
		request.setAttribute("s_carid2", s_carid2);

		pageRequest.getFilters().put("carid", s_carid1 + s_carid2);
		
		
		
		//xtvfhpwfn
		StringBuffer data = new StringBuffer("var ja=[];");
		 serveritem = tcarinfoManager.getServeritemForLevelOne();
		if (serveritem != null) {
			for (int i = 0; i < serveritem.size(); i++) {
				Map map = (Map) serveritem.get(i);
				if(map.get("dictlevel") != null && map.get("dictlevel").toString().equals("1"))
					data.append("\r\n");
				data.append("ja['"+map.get("dictid")+"']='"+map.get("dictname")+"';");
			}
		}
		request.setAttribute("data", data);
		
		
		StringBuffer dataTwo = new StringBuffer("var menus=new Array(new Array('1','信息','0'),");
		List serveritemTwo = tcarinfoManager.getServeritemForLevelTwo();
		if (serveritemTwo != null) {
			for (int i = 0; i < serveritemTwo.size(); i++) {
				Map map = (Map) serveritemTwo.get(i);
				dataTwo.append("new Array('"+map.get("dictid")+"','"+map.get("dictname")+"','"+map.get("parentid")+"'),");
			}
		}
		dataTwo.append("'');");
		request.setAttribute("dataTwo", dataTwo);
		
		Page page = tcarinfoManager.findByPageRequest1(pageRequest);
		
		savePage(page, pageRequest);
		return LIST1_JSP;
	}
	

	/** 查看对象 */
	public String show() {
		HttpServletRequest request = ServletActionContext.getRequest();
		getColor();
		
		String dictValue = "";
		String dict = "";
		if (tcarinfo != null && tcarinfo.getServeritem() != null) {
			String[] arrMtffcs = tcarinfo.getServeritem().split(";");
			if (arrMtffcs != null && arrMtffcs.length > 0) {
				for (int i = 0; i < arrMtffcs.length; i++) {
					if("ABCDEFGHIJKLMNOPQRSTUVWXYZ".indexOf(arrMtffcs[i])!= -1){
						dict="喷漆:"+com.dyneinfo.zazh.util.DictFun.getDictValue("serverItem", arrMtffcs[i]);
					}else{
						dict=com.dyneinfo.zazh.util.DictFun.getDictValue("serverItem", arrMtffcs[i]);
					}
					if (i == 0)
						dictValue =dict;
					else
						dictValue = dictValue+ "-"+ dict;
				}
			}
		}
		tcarinfo.setServeritem(dictValue);
		
		
		java.lang.String deliname = "";// 送车人姓名
		java.lang.String delicredcode = "";// 送车人身份证号码
		java.lang.String delitelephone = "";// 送车人电话号码
		java.lang.String deliaddress = "";// 送车人住址 add by zzq 2012/06/12
		java.lang.String recename = "";// 收车人姓名
		java.lang.String recetime = "";// 收车时间
		java.lang.String serveritem = "";// 服务项目
		java.lang.String takeoffname = "";// 取车人姓名
		java.lang.String tocredcode = "";// 取车人证件号码
		java.lang.String totime = "";// 取车时间
		java.lang.String demo = "";// 备注
		if (tcarinfo != null) {
			deliname = tcarinfo.getDeliname();
			delicredcode = tcarinfo.getDelicredcode();
			delitelephone = tcarinfo.getDelitelephone();
			deliaddress=tcarinfo.getDeliaddress();//送车人住址 add by zzq 2012/06/12
			recename = tcarinfo.getRecename();
			recetime = tcarinfo.getRecetime();
			serveritem = tcarinfo.getServeritem();
			takeoffname = tcarinfo.getTakeoffname();
			tocredcode = tcarinfo.getTocredcode();
			totime = tcarinfo.getTotime();
			demo = tcarinfo.getDemo();

		}

		java.lang.String enrolid = "";
		java.lang.String carowner = "";
		java.lang.String cartype = "";
		java.lang.String brand = "";
		java.lang.String color_ext = "";
		java.lang.String carid_ext = "";
		java.lang.String enginecode = "";
		java.lang.String bodycode = "";
		java.lang.String enroltime = "";
		java.lang.String operator = "";
		java.lang.String cpcode = "";
		java.lang.String flag = "";
		java.lang.String color1 = "";
		java.lang.String color2 = "";
		java.lang.String color3 = "";
		java.lang.String carid1;	
		
		 String cardidName = "";
		 String cartypeName = "";
		 String color1Name= "";
		 String color2Name= "";
		 String color3Name= "";
		 String serveritemName = "";
		
		
		if (tcarinfo != null) {
			 enrolid = tcarinfo.getEnrolid();
			 carowner =tcarinfo.getCarowner();
			 
			 
			 
			 cartype =tcarinfo.getCartype();
			 brand = tcarinfo.getBrand();
			 color_ext = tcarinfo.getColor();
			 carid_ext = tcarinfo.getCarid();
			 enginecode = tcarinfo.getEnginecode();
			 bodycode = tcarinfo.getBodycode();
			 enroltime = tcarinfo.getEnroltime();
			 operator = tcarinfo.getOperator();
			 cpcode = tcarinfo.getCpcode();
			 flag = tcarinfo.getFlag();
			 color1 = tcarinfo.getColor1();
			 color2 = tcarinfo.getColor2();
			 color3 = tcarinfo.getColor3();
			 carid1 = tcarinfo.getCarid1();
			 
			 
			
			 List datas = DictHelpImpl.getDict("cpht");
				if(carid1 != null && carid1.length() > 0){
				for (int i = 0; i < datas.size(); i++) {
					ISelectOption bean = (ISelectOption) datas.get(i);
					if (bean.getValue() != null && bean.getValue().equals(carid1))
						cardidName = bean.getName();

				}}
				cardidName = cardidName+ carid_ext;
				
				
				datas = DictHelpImpl.getDict("cllx");
				if(cartype != null && cartype.length() > 0){
				for (int i = 0; i < datas.size(); i++) {
					ISelectOption bean = (ISelectOption) datas.get(i);
					if (bean.getValue() != null && bean.getValue().equals(cartype))
						cartypeName = bean.getName();

				}}
				
				datas = DictHelpImpl.getDict("csys");
				if(color1 != null && color1.length() > 0){
				for (int i = 0; i < datas.size(); i++) {
					ISelectOption bean = (ISelectOption) datas.get(i);
					if (bean.getValue() != null && bean.getValue().equals(color1))
						color1Name = bean.getName();

				}}
				
			
				if(color2 != null && color2.length() > 0){
				for (int i = 0; i < datas.size(); i++) {
					ISelectOption bean = (ISelectOption) datas.get(i);
					if (bean.getValue() != null && bean.getValue().equals(color2))
						color2Name = bean.getName();

				}}
				
			
				if(color3 != null && color3.length() > 0){
				for (int i = 0; i < datas.size(); i++) {
					ISelectOption bean = (ISelectOption) datas.get(i);
					if (bean.getValue() != null && bean.getValue().equals(color3))
						color3Name = bean.getName();

				}}
				
				
				if (tcarinfo != null && tcarinfo.getServeritem() != null) {
					String[] arrMtffcs = tcarinfo.getServeritem().split(";");
					if (arrMtffcs != null && arrMtffcs.length > 0) {
						for (int i = 0; i < arrMtffcs.length; i++) {
							if (i == 0)
								serveritemName = com.dyneinfo.zazh.util.DictFun.getDictValue("serverItem", arrMtffcs[i]);
							else
								serveritemName = serveritemName+ "-"+ com.dyneinfo.zazh.util.DictFun.getDictValue("serverItem", arrMtffcs[i]);
						}
					}
				}
		}
		request.setAttribute("carowner", carowner);
		request.setAttribute("cardidName", cardidName);
		request.setAttribute("cartypeName", cartypeName);
		request.setAttribute("brand", brand);
		request.setAttribute("enginecode", enginecode);
		request.setAttribute("bodycode", bodycode);
		request.setAttribute("color1Name", color1Name);
		request.setAttribute("color2Name", color2Name);
		request.setAttribute("color3Name", color3Name);
		request.setAttribute("deliname", deliname);
		request.setAttribute("delicredcode", delicredcode);
		request.setAttribute("delitelephone", delitelephone);
		request.setAttribute("delitelephone", delitelephone);
		request.setAttribute("deliaddress", deliaddress);	//送车人住址 add by zzq 2012/06/12
		request.setAttribute("recename", recename);
		request.setAttribute("recetime", recetime);
		request.setAttribute("takeoffname", takeoffname);
		request.setAttribute("tocredcode", tocredcode);
		request.setAttribute("serveritemName", serveritemName);
		request.setAttribute("totime", totime);
		request.setAttribute("demo", demo);
		
		return SHOW_JSP;
	}
	public String show1() {
		HttpServletRequest request = ServletActionContext.getRequest();
		getColor();
		
		String dictValue = "";
		if (tcarinfo != null && tcarinfo.getServeritem() != null) {
			String[] arrMtffcs = tcarinfo.getServeritem().split(";");
			if (arrMtffcs != null && arrMtffcs.length > 0) {
				for (int i = 0; i < arrMtffcs.length; i++) {
					if (i == 0)
						dictValue = com.dyneinfo.zazh.util.DictFun.getDictValue("serverItem", arrMtffcs[i]);
					else
						dictValue = dictValue+ "-"+ com.dyneinfo.zazh.util.DictFun.getDictValue("serverItem", arrMtffcs[i]);
				}
			}
		}
		tcarinfo.setServeritem(dictValue);
		
		
		java.lang.String deliname = "";// 送车人姓名
		java.lang.String delicredcode = "";// 送车人身份证号码
		java.lang.String delitelephone = "";// 送车人电话号码
		java.lang.String recename = "";// 收车人姓名
		java.lang.String recetime = "";// 收车时间
		java.lang.String serveritem = "";// 服务项目
		java.lang.String takeoffname = "";// 取车人姓名
		java.lang.String tocredcode = "";// 取车人证件号码
		java.lang.String totime = "";// 取车时间
		java.lang.String demo = "";// 备注
		if (tcarinfo != null) {
			deliname = tcarinfo.getDeliname();
			delicredcode = tcarinfo.getDelicredcode();
			delitelephone = tcarinfo.getDelitelephone();
			recename = tcarinfo.getRecename();
			recetime = tcarinfo.getRecetime();
			serveritem = tcarinfo.getServeritem();
			takeoffname = tcarinfo.getTakeoffname();
			tocredcode = tcarinfo.getTocredcode();
			totime = tcarinfo.getTotime();
			demo = tcarinfo.getDemo();

		}

		java.lang.String enrolid = "";
		java.lang.String carowner = "";
		java.lang.String cartype = "";
		java.lang.String brand = "";
		java.lang.String color_ext = "";
		java.lang.String carid_ext = "";
		java.lang.String enginecode = "";
		java.lang.String bodycode = "";
		java.lang.String enroltime = "";
		java.lang.String operator = "";
		java.lang.String cpcode = "";
		java.lang.String flag = "";
		java.lang.String color1 = "";
		java.lang.String color2 = "";
		java.lang.String color3 = "";
		java.lang.String carid1;	
		
		 String cardidName = "";
		 String cartypeName = "";
		 String color1Name= "";
		 String color2Name= "";
		 String color3Name= "";
		 String serveritemName = "";
		
		
		if (tcarinfo != null) {
			 enrolid = tcarinfo.getEnrolid();
			 carowner =tcarinfo.getCarowner();
			 
			 
			 
			 cartype =tcarinfo.getCartype();
			 brand = tcarinfo.getBrand();
			 color_ext = tcarinfo.getColor();
			 carid_ext = tcarinfo.getCarid();
			 enginecode = tcarinfo.getEnginecode();
			 bodycode = tcarinfo.getBodycode();
			 enroltime = tcarinfo.getEnroltime();
			 operator = tcarinfo.getOperator();
			 cpcode = tcarinfo.getCpcode();
			 flag = tcarinfo.getFlag();
			 color1 = tcarinfo.getColor1();
			 color2 = tcarinfo.getColor2();
			 color3 = tcarinfo.getColor3();
			 carid1 = tcarinfo.getCarid1();
			 
			 
			
			 List datas = DictHelpImpl.getDict("cpht");
				if(carid1 != null && carid1.length() > 0){
				for (int i = 0; i < datas.size(); i++) {
					ISelectOption bean = (ISelectOption) datas.get(i);
					if (bean.getValue() != null && bean.getValue().equals(carid1))
						cardidName = bean.getName();

				}}
				cardidName = cardidName+ carid_ext;
				
				
				datas = DictHelpImpl.getDict("cllx");
				if(cartype != null && cartype.length() > 0){
				for (int i = 0; i < datas.size(); i++) {
					ISelectOption bean = (ISelectOption) datas.get(i);
					if (bean.getValue() != null && bean.getValue().equals(cartype))
						cartypeName = bean.getName();

				}}
				
				datas = DictHelpImpl.getDict("csys");
				if(color1 != null && color1.length() > 0){
				for (int i = 0; i < datas.size(); i++) {
					ISelectOption bean = (ISelectOption) datas.get(i);
					if (bean.getValue() != null && bean.getValue().equals(color1))
						color1Name = bean.getName();

				}}
				
			
				if(color2 != null && color2.length() > 0){
				for (int i = 0; i < datas.size(); i++) {
					ISelectOption bean = (ISelectOption) datas.get(i);
					if (bean.getValue() != null && bean.getValue().equals(color2))
						color2Name = bean.getName();

				}}
				
			
				if(color3 != null && color3.length() > 0){
				for (int i = 0; i < datas.size(); i++) {
					ISelectOption bean = (ISelectOption) datas.get(i);
					if (bean.getValue() != null && bean.getValue().equals(color3))
						color3Name = bean.getName();

				}}
				
				
				if (tcarinfo != null && tcarinfo.getServeritem() != null) {
					String[] arrMtffcs = tcarinfo.getServeritem().split(";");
					if (arrMtffcs != null && arrMtffcs.length > 0) {
						for (int i = 0; i < arrMtffcs.length; i++) {
							if (i == 0)
								serveritemName = com.dyneinfo.zazh.util.DictFun.getDictValue("serverItem", arrMtffcs[i]);
							else
								serveritemName = serveritemName+ "-"+ com.dyneinfo.zazh.util.DictFun.getDictValue("serverItem", arrMtffcs[i]);
						}
					}
				}
		}
		request.setAttribute("carowner", carowner);
		request.setAttribute("cardidName", cardidName);
		request.setAttribute("cartypeName", cartypeName);
		request.setAttribute("brand", brand);
		request.setAttribute("enginecode", enginecode);
		request.setAttribute("bodycode", bodycode);
		request.setAttribute("color1Name", color1Name);
		request.setAttribute("color2Name", color2Name);
		request.setAttribute("color3Name", color3Name);
		request.setAttribute("deliname", deliname);
		request.setAttribute("delicredcode", delicredcode);
		request.setAttribute("delitelephone", delitelephone);
		request.setAttribute("recename", recename);
		request.setAttribute("recetime", recetime);
		request.setAttribute("takeoffname", takeoffname);
		request.setAttribute("tocredcode", tocredcode);
		request.setAttribute("serveritemName", serveritemName);
		request.setAttribute("totime", totime);
		request.setAttribute("demo", demo);
		
		return SHOW1_JSP;
	}
	public String zazhShow() {
		HttpServletRequest request = ServletActionContext.getRequest();
		if(null == tcarinfo){
			tcarinfo = new Tcarinfo();
		}
		getColor();
		String dictValue = "";
		if (tcarinfo != null && tcarinfo.getServeritem() != null) {
			String[] arrMtffcs = tcarinfo.getServeritem().split(";");
			if (arrMtffcs != null && arrMtffcs.length > 0) {
				for (int i = 0; i < arrMtffcs.length; i++) {
					if (i == 0)
						dictValue = com.dyneinfo.zazh.util.DictFun.getDictValue("serverItem", arrMtffcs[i]);
					else
						dictValue = dictValue+ "-"+ com.dyneinfo.zazh.util.DictFun.getDictValue("serverItem", arrMtffcs[i]);
				}
			}
		}
		tcarinfo.setServeritem(dictValue);
		
		
		java.lang.String deliname = "";// 送车人姓名
		java.lang.String delicredcode = "";// 送车人身份证号码
		java.lang.String delitelephone = "";// 送车人电话号码
		java.lang.String recename = "";// 收车人姓名
		java.lang.String recetime = "";// 收车时间
		java.lang.String serveritem = "";// 服务项目
		java.lang.String takeoffname = "";// 取车人姓名
		java.lang.String tocredcode = "";// 取车人证件号码
		java.lang.String totime = "";// 取车时间
		java.lang.String demo = "";// 备注
		if (tcarinfo != null) {
			deliname = tcarinfo.getDeliname();
			delicredcode = tcarinfo.getDelicredcode();
			delitelephone = tcarinfo.getDelitelephone();
			recename = tcarinfo.getRecename();
			recetime = tcarinfo.getRecetime();
			serveritem = tcarinfo.getServeritem();
			takeoffname = tcarinfo.getTakeoffname();
			tocredcode = tcarinfo.getTocredcode();
			totime = tcarinfo.getTotime();
			demo = tcarinfo.getDemo();
			
		}
		
		java.lang.String enrolid = "";
		java.lang.String carowner = "";
		java.lang.String cartype = "";
		java.lang.String brand = "";
		java.lang.String color_ext = "";
		java.lang.String carid_ext = "";
		java.lang.String enginecode = "";
		java.lang.String bodycode = "";
		java.lang.String enroltime = "";
		java.lang.String operator = "";
		java.lang.String cpcode = "";
		java.lang.String flag = "";
		java.lang.String color1 = "";
		java.lang.String color2 = "";
		java.lang.String color3 = "";
		java.lang.String carid1;	
		
		String cardidName = "";
		String cartypeName = "";
		String color1Name= "";
		String color2Name= "";
		String color3Name= "";
		String serveritemName = "";
		
		
		if (tcarinfo != null) {
			enrolid = tcarinfo.getEnrolid();
			carowner =tcarinfo.getCarowner();
			
			
			
			cartype =tcarinfo.getCartype();
			brand = tcarinfo.getBrand();
			color_ext = tcarinfo.getColor();
			carid_ext = tcarinfo.getCarid();
			enginecode = tcarinfo.getEnginecode();
			bodycode = tcarinfo.getBodycode();
			enroltime = tcarinfo.getEnroltime();
			operator = tcarinfo.getOperator();
			cpcode = tcarinfo.getCpcode();
			flag = tcarinfo.getFlag();
			color1 = tcarinfo.getColor1();
			color2 = tcarinfo.getColor2();
			color3 = tcarinfo.getColor3();
			carid1 = tcarinfo.getCarid1();
			
			
			
			List datas = DictHelpImpl.getDict("cpht");
			if(carid1 != null && carid1.length() > 0){
				for (int i = 0; i < datas.size(); i++) {
					ISelectOption bean = (ISelectOption) datas.get(i);
					if (bean.getValue() != null && bean.getValue().equals(carid1))
						cardidName = bean.getName();
					
				}}
			cardidName = cardidName+ carid_ext;
			
			
			datas = DictHelpImpl.getDict("cllx");
			if(cartype != null && cartype.length() > 0){
				for (int i = 0; i < datas.size(); i++) {
					ISelectOption bean = (ISelectOption) datas.get(i);
					if (bean.getValue() != null && bean.getValue().equals(cartype))
						cartypeName = bean.getName();
					
				}}
			
			datas = DictHelpImpl.getDict("csys");
			if(color1 != null && color1.length() > 0){
				for (int i = 0; i < datas.size(); i++) {
					ISelectOption bean = (ISelectOption) datas.get(i);
					if (bean.getValue() != null && bean.getValue().equals(color1))
						color1Name = bean.getName();
					
				}}
			
			
			if(color2 != null && color2.length() > 0){
				for (int i = 0; i < datas.size(); i++) {
					ISelectOption bean = (ISelectOption) datas.get(i);
					if (bean.getValue() != null && bean.getValue().equals(color2))
						color2Name = bean.getName();
					
				}}
			
			
			if(color3 != null && color3.length() > 0){
				for (int i = 0; i < datas.size(); i++) {
					ISelectOption bean = (ISelectOption) datas.get(i);
					if (bean.getValue() != null && bean.getValue().equals(color3))
						color3Name = bean.getName();
					
				}}
			
			
			if (tcarinfo != null && tcarinfo.getServeritem() != null) {
				String[] arrMtffcs = tcarinfo.getServeritem().split(";");
				if (arrMtffcs != null && arrMtffcs.length > 0) {
					for (int i = 0; i < arrMtffcs.length; i++) {
						if (i == 0)
							serveritemName = com.dyneinfo.zazh.util.DictFun.getDictValue("serverItem", arrMtffcs[i]);
						else
							serveritemName = serveritemName+ "-"+ com.dyneinfo.zazh.util.DictFun.getDictValue("serverItem", arrMtffcs[i]);
					}
				}
			}
		}
		request.setAttribute("carowner", carowner);
		request.setAttribute("cardidName", cardidName);
		request.setAttribute("cartypeName", cartypeName);
		request.setAttribute("brand", brand);
		request.setAttribute("enginecode", enginecode);
		request.setAttribute("bodycode", bodycode);
		request.setAttribute("color1Name", color1Name);
		request.setAttribute("color2Name", color2Name);
		request.setAttribute("color3Name", color3Name);
		request.setAttribute("deliname", deliname);
		request.setAttribute("delicredcode", delicredcode);
		request.setAttribute("delitelephone", delitelephone);
		request.setAttribute("recename", recename);
		request.setAttribute("recetime", recetime);
		request.setAttribute("takeoffname", takeoffname);
		request.setAttribute("tocredcode", tocredcode);
		request.setAttribute("serveritemName", serveritemName);
		request.setAttribute("totime", totime);
		request.setAttribute("demo", demo);
		
		return ZAZHSHOW_JSP;
	}

	/** 查看对象 */
	public String view() {
		HttpServletRequest request = ServletActionContext.getRequest();

		getColor();
		
		String dictValue = "";
		String dict = "";
		if (tcarinfo != null && tcarinfo.getServeritem() != null) {
			String[] arrMtffcs = tcarinfo.getServeritem().split(";");
			if (arrMtffcs != null && arrMtffcs.length > 0) {
				for (int i = 0; i < arrMtffcs.length; i++) {
					if("ABCDEFGHIJKLMNOPQRSTUVWXYZ".indexOf(arrMtffcs[i])!= -1){
						dict="喷漆:"+com.dyneinfo.zazh.util.DictFun.getDictValue("serverItem", arrMtffcs[i]);
					}else{
						dict=com.dyneinfo.zazh.util.DictFun.getDictValue("serverItem", arrMtffcs[i]);
					}
					if (i == 0)
						dictValue =dict;
					else
						dictValue = dictValue+ "-"+ dict;
//					if (i == 0)
//						dictValue = com.dyneinfo.hotel.util.DictFun.getDictValue("serverItem", arrMtffcs[i]);
//					else
//						dictValue = dictValue+ "-"+ com.dyneinfo.hotel.util.DictFun.getDictValue("serverItem", arrMtffcs[i]);
				}
			}
		}
		tcarinfo.setServeritem(dictValue);
		
		return VIEW_JSP;
	}

	/** 进入新增页面 */
	public String create() {
		HttpServletRequest request = ServletActionContext.getRequest();
		//getServeritem();
		
		java.text.SimpleDateFormat dateformat = new java.text.SimpleDateFormat(
				"yyyy-MM-dd HH:mm");
		tcarinfo.setRecetime(dateformat.format(new Date()));
	
		
		String deptID = "";
		String deptName = "";
		MyUserDetails userDetail = null;
		userDetail = SpringTagFunctions.getUserDetails();
		if (userDetail != null) {
			deptID = userDetail.getDeptID();
			deptName = userDetail.getDeptName();
		}
		String smycode = tcpinfojxyManager.smycode(deptID);
		String typecode = tcpinfojxyManager.typecode(deptID);
		request.setAttribute("smycode", smycode);
		request.setAttribute("typecode", typecode);
		
		

		
		
		
		StringBuffer data = new StringBuffer("var ja=[];");
		List serveritem = tcarinfoManager.getServeritemForLevelOne();
		if (serveritem != null) {
			for (int i = 0; i < serveritem.size(); i++) {
				Map map = (Map) serveritem.get(i);
				if(map.get("dictlevel") != null && map.get("dictlevel").toString().equals("1"))
					data.append("\r\n");
				data.append("ja['"+map.get("dictid")+"']='"+map.get("dictname")+"';");
			}
		}
		request.setAttribute("data", data);
		
		
		StringBuffer dataTwo = new StringBuffer("var menus=new Array(new Array('1','信息','0'),");
		List serveritemTwo = tcarinfoManager.getServeritemForLevelTwo();
		if (serveritemTwo != null) {
			for (int i = 0; i < serveritemTwo.size(); i++) {
				Map map = (Map) serveritemTwo.get(i);
				dataTwo.append("new Array('"+map.get("dictid")+"','"+map.get("dictname")+"','"+map.get("parentid")+"'),");
			}
		}
		dataTwo.append("'');");
		request.setAttribute("dataTwo", dataTwo);
		
	
		
		
		
		return CREATE_JSP;
	}

	/** 保存新增对象 */
	public String save() {
		HttpServletRequest request = ServletActionContext.getRequest();
		
		String tomobile = "";
		if(request.getParameter("clsbcode")!= null && !"".equals(request.getParameter("clsbcode"))){
			tcarinfo.setClsbcode(request.getParameter("clsbcode"));
			tcarinfo.setBodycode(request.getParameter("clsbcode"));
		}
		if (request.getParameter("tomobile") != null)
			tomobile = request.getParameter("tomobile");
		
		// 企业代码（13位） + YYYYMMDD + 三位顺序号
		// 三位顺序号每天自动从001开始 递增
		String enrolId = getEnrolId();
		tcarinfo.setEnrolid(enrolId);

		// 存储系统参数，部门编号，录入时间，信息状态等
		tcarinfo.setCpcode(deptId);
		tcarinfo.setOperator(String.valueOf(userId));
		SimpleDateFormat formatoptime = new SimpleDateFormat("yyyyMMddHHmm");
		tcarinfo.setEnroltime(formatoptime.format(new Date()));
		tcarinfo.setFlag("0");
		// 拼接车牌号码和车身颜色
		String carid = tcarinfo.getCarid1() + tcarinfo.getCarid().toUpperCase();
		tcarinfo.setCarid(carid);
		String color = tcarinfo.getColor1() + tcarinfo.getColor2()+ tcarinfo.getColor3();
		tcarinfo.setColor(color);

		// 保存图片
		if (file != null) {
			if (file.length() > FilemaxSize) {
				request.setAttribute("message", "上传照片不能大于" + FilemaxSize / 1024
						/ 1024 + "M");
				return UPDATEPHOTOERROR;
			}
			try {
				// /保存带照片的车辆基本信息
				tcarinfoManager.savePic(file, tcarinfo);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else {
			// 没有图片直接保存车辆基本信息
			tcarinfoManager.save(tcarinfo);

		}
		// 保存承接车辆基本信息
		Tcarreturn tcarreturn = this.setTcarreturn(enrolId,tomobile);
//		tcarreturn.setDelicredcode(this.changeID(tcarinfo.getDelicredcode()));
		tcarreturn.setDelicredcode(tcarinfo.getDelicredcode());
		// xtvfhpwfn
		tcarreturn.setServeritem(this.util(tcarreturn.getServeritem()));
		tcarreturnManager.save(tcarreturn);
		
		java.lang.String deliname = "";// 送车人姓名
		java.lang.String delicredcode = "";// 送车人身份证号码
		java.lang.String delitelephone = "";// 送车人电话号码
		java.lang.String recename = "";// 收车人姓名
		java.lang.String recetime = "";// 收车时间
		java.lang.String serveritem = "";// 服务项目
		java.lang.String takeoffname = "";// 取车人姓名
		java.lang.String tocredcode = "";// 取车人证件号码
		java.lang.String totime = "";// 取车时间
		java.lang.String demo = "";// 备注
		if (tcarreturn != null) {
			deliname = tcarreturn.getDeliname();
			delicredcode = tcarreturn.getDelicredcode();
			delitelephone = tcarreturn.getDelitelephone();
			recename = tcarreturn.getRecename();
			recetime = tcarreturn.getRecetime();
			// xtvfhpwfn
			String ss = this.util(tcarreturn.getServeritem());
			serveritem = ss;
			
			
			takeoffname = tcarreturn.getTakeoffname();
			tocredcode = tcarreturn.getTocredcode();
			totime = tcarreturn.getTotime();
			demo = tcarreturn.getDemo();

		}

		java.lang.String enrolid = "";
		java.lang.String carowner = "";
		java.lang.String cartype = "";
		java.lang.String brand = "";
		java.lang.String color_ext = "";
		java.lang.String carid_ext = "";
		java.lang.String enginecode = "";
		java.lang.String bodycode = "";
		java.lang.String enroltime = "";
		java.lang.String operator = "";
		java.lang.String cpcode = "";
		java.lang.String flag = "";
		java.lang.String color1 = "";
		java.lang.String color2 = "";
		java.lang.String color3 = "";
		java.lang.String carid1;	
		
		 String cardidName = "";
		 String cartypeName = "";
		 String color1Name= "";
		 String color2Name= "";
		 String color3Name= "";
		 String serveritemName = "";
		
		
		if (tcarinfo != null) {
			 enrolid = tcarinfo.getEnrolid();
			 carowner =tcarinfo.getCarowner();
			 cartype =tcarinfo.getCartype();
			 brand = tcarinfo.getBrand();
			 color_ext = tcarinfo.getColor();
			 carid_ext = tcarinfo.getCarid();
			 enginecode = tcarinfo.getEnginecode();
			 bodycode = tcarinfo.getBodycode();
			 enroltime = tcarinfo.getEnroltime();
			 operator = tcarinfo.getOperator();
			 cpcode = tcarinfo.getCpcode();
			 flag = tcarinfo.getFlag();
			 color1 = tcarinfo.getColor1();
			 color2 = tcarinfo.getColor2();
			 color3 = tcarinfo.getColor3();
			 carid1 = tcarinfo.getCarid1();
			 carid =  tcarinfo.getCarid().substring(1, tcarinfo.getCarid().length());
			 
			 
			
			 List datas = DictHelpImpl.getDict("cpht");
				if(carid1 != null && carid1.length() > 0){
				for (int i = 0; i < datas.size(); i++) {
					ISelectOption bean = (ISelectOption) datas.get(i);
					if (bean.getValue() != null && bean.getValue().equals(carid1))
						cardidName = bean.getName();

				}}
				cardidName = cardidName+ carid_ext;
				
				
				datas = DictHelpImpl.getDict("cllx");
				if(cartype != null && cartype.length() > 0){
				for (int i = 0; i < datas.size(); i++) {
					ISelectOption bean = (ISelectOption) datas.get(i);
					if (bean.getValue() != null && bean.getValue().equals(cartype))
						cartypeName = bean.getName();

				}}
				
				datas = DictHelpImpl.getDict("csys");
				if(color1 != null && color1.length() > 0){
				for (int i = 0; i < datas.size(); i++) {
					ISelectOption bean = (ISelectOption) datas.get(i);
					if (bean.getValue() != null && bean.getValue().equals(color1))
						color1Name = bean.getName();

				}}
				
			
				if(color2 != null && color2.length() > 0){
				for (int i = 0; i < datas.size(); i++) {
					ISelectOption bean = (ISelectOption) datas.get(i);
					if (bean.getValue() != null && bean.getValue().equals(color2))
						color2Name = bean.getName();

				}}
				
			
				if(color3 != null && color3.length() > 0){
				for (int i = 0; i < datas.size(); i++) {
					ISelectOption bean = (ISelectOption) datas.get(i);
					if (bean.getValue() != null && bean.getValue().equals(color3))
						color3Name = bean.getName();

				}}
				
				
				if (tcarinfo != null && tcarinfo.getServeritem() != null) {
					String[] arrMtffcs = tcarinfo.getServeritem().split(";");
					if (arrMtffcs != null && arrMtffcs.length > 0) {
						for (int i = 0; i < arrMtffcs.length; i++) {
							if (i == 0)
								serveritemName = com.dyneinfo.zazh.util.DictFun.getDictValue("serverItem", arrMtffcs[i]);
							else
								serveritemName = serveritemName+ "-"+ com.dyneinfo.zazh.util.DictFun.getDictValue("serverItem", arrMtffcs[i]);
						}
					}
				}
		}
		request.setAttribute("carowner", carowner);
		request.setAttribute("cardidName", cardidName);
		request.setAttribute("cartypeName", cartypeName);
		request.setAttribute("brand", brand);
		request.setAttribute("enginecode", enginecode);
		request.setAttribute("bodycode", bodycode);
		request.setAttribute("color1Name", color1Name);
		request.setAttribute("color2Name", color2Name);
		request.setAttribute("color3Name", color3Name);
		request.setAttribute("deliname", deliname);
		request.setAttribute("delicredcode", delicredcode);
		request.setAttribute("delitelephone", delitelephone);
		request.setAttribute("recename", recename);
		request.setAttribute("recetime", recetime);
		request.setAttribute("takeoffname", takeoffname);
		request.setAttribute("tocredcode", tocredcode);
		request.setAttribute("serveritemName", serveritemName);
		request.setAttribute("totime", totime);
		request.setAttribute("demo", demo);
		request.setAttribute("carid", carid);
		request.setAttribute("static", "1");
		
		String dictValue = "";
		if (tcarinfo != null && tcarinfo.getServeritem() != null) {
			String[] arrMtffcs = tcarinfo.getServeritem().split(";");
			if (arrMtffcs != null && arrMtffcs.length > 0) {
				for (int i = 0; i < arrMtffcs.length; i++) {
					if (i == 0)
						dictValue = com.dyneinfo.zazh.util.DictFun.getDictValue("serverItem", arrMtffcs[i]);
					else
						dictValue = dictValue+ "-"+ com.dyneinfo.zazh.util.DictFun.getDictValue("serverItem", arrMtffcs[i]);
				}
			}
		}
	
		tcarinfo.setServeritem(dictValue);
		
		
		return SHOW_JSP;
	}
	
	public void getDataByIdNum() throws IOException{
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("text/html;charset=UTF-8"); 
		
		String key = null;
		if (request.getParameter("key") != null
				&& !"".equals(request.getParameter("key"))) {
			try {
				key = URLDecoder.decode(request.getParameter("key"),
						"UTF-8").trim();
			} catch (UnsupportedEncodingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		String s=key.toUpperCase();
		
		List list=tcarinfoManager.getJsz(s);
		
		for(int i=0;i<list.size();i++){
			String st=list.get(i).toString();
			int strlength=st.length()-1;
			String str=st.substring(8,strlength);
			response.getWriter().write(str+"|");
		}
		

	}
	public void getDataByIdNum1() throws IOException{
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("text/html;charset=UTF-8"); 
		String key = request.getParameter("key");
		String s=key.toUpperCase();
		List list=tcarinfoManager.getJsz(s);
		
		for(int i=0;i<list.size();i++){
			String st=list.get(i).toString();
			int strlength=st.length()-1;
			String str=st.substring(7,strlength);
			response.getWriter().write(str+"|");
		}
		

	}
	
	/**
	 * 获取人员信息
	 * 
	 * @return
	 */
	public String ryedit() {
		HttpServletRequest request = ServletActionContext.getRequest();
		String hiddenid = request.getParameter("hidden_enrolid");
		tcarinfo = (Tcarinfo) tcarinfoManager.getById(hiddenid);

		getColor();
		String deptID = "";
		String deptName = "";
		MyUserDetails userDetail = null;
		userDetail = SpringTagFunctions.getUserDetails();
		if (userDetail != null) {
			deptID = userDetail.getDeptID();
			deptName = userDetail.getDeptName();
		}
		String smycode = tcpinfojxyManager.smycode(deptID);
		String typecode = tcpinfojxyManager.typecode(deptID);
		request.setAttribute("smycode", smycode);
		request.setAttribute("typecode", typecode);

		String dictValue = "";
		if (tcarinfo != null && tcarinfo.getServeritem() != null) {
			String[] arrMtffcs = tcarinfo.getServeritem().split(";");
			if (arrMtffcs != null && arrMtffcs.length > 0) {
				for (int i = 0; i < arrMtffcs.length; i++) {
					if (i == 0)
						dictValue = com.dyneinfo.zazh.util.DictFun
								.getDictValue("serverItem", arrMtffcs[i]);
					else
						dictValue = dictValue
								+ "-"
								+ com.dyneinfo.zazh.util.DictFun.getDictValue(
										"serverItem", arrMtffcs[i]);
				}
			}
		}
		request.setAttribute("serveritemName", dictValue);
		// tcarinfo.setServeritem(dictValue);

		StringBuffer data = new StringBuffer("var ja=[];");
		List serveritem = tcarinfoManager.getServeritemForLevelOne();
		if (serveritem != null) {
			for (int i = 0; i < serveritem.size(); i++) {
				Map map = (Map) serveritem.get(i);
				if (map.get("dictlevel") != null
						&& map.get("dictlevel").toString().equals("1"))
					data.append("\r\n");
				data.append("ja['" + map.get("dictid") + "']='"
						+ map.get("dictname") + "';");
			}
		}
		request.setAttribute("data", data);

		StringBuffer dataTwo = new StringBuffer(
				"var menus=new Array(new Array('1','信息','0'),");
		List serveritemTwo = tcarinfoManager.getServeritemForLevelTwo();
		if (serveritemTwo != null) {
			for (int i = 0; i < serveritemTwo.size(); i++) {
				Map map = (Map) serveritemTwo.get(i);
				dataTwo.append("new Array('" + map.get("dictid") + "','"
						+ map.get("dictname") + "','" + map.get("parentid")
						+ "'),");
			}
		}
		dataTwo.append("'');");
		request.setAttribute("dataTwo", dataTwo);

		return CREATE_JSP;
	}

	/** 进入更新页面 */
	public String edit() {
		HttpServletRequest request = ServletActionContext.getRequest();
		getColor();
		String deptID = "";
		String deptName = "";
		MyUserDetails userDetail = null;
		userDetail = SpringTagFunctions.getUserDetails();
		if (userDetail != null) {
			deptID = userDetail.getDeptID();
			deptName = userDetail.getDeptName();
		}
		String smycode = tcpinfojxyManager.smycode(deptID);
		String typecode = tcpinfojxyManager.typecode(deptID);
		request.setAttribute("smycode", smycode);
		request.setAttribute("typecode", typecode);
		
		
//		StringBuffer checkboxhtml = new StringBuffer("");
//		String language = "";
//		List datas = null;
//		Locale local = (Locale) request.getLocale();
//		if (local != null)
//			language = local.toString();
//		datas = DictHelpImpl.getDict("serverItem", language);
//		if (tcarinfo != null && tcarinfo.getServeritem() != null) {
//			String[] arrMtffcs = tcarinfo.getServeritem().split(";");
//			if (arrMtffcs != null && arrMtffcs.length > 0) {
//				for (int i = 0; i < arrMtffcs.length; i++) {
//					for (int j = 0; j < datas.size(); j++) {
//						ISelectOption bean = (ISelectOption) datas.get(j);
//						if (bean.getValue() != null && bean.getValue() != null
//								&& bean.getValue().equals(arrMtffcs[i])) {
//							checkboxhtml.append("<input type='checkbox' name='serveritemDiv' checked value='"
//											+ bean.getValue()
//											+ "'/> "
//											+ bean.getName());
//						}
//					}
//				}
//			}
//		}
//		request.setAttribute("checkboxhtml", checkboxhtml);
		
		
		String dictValue = "";
		String dict ="";
		if (tcarinfo != null && tcarinfo.getServeritem() != null) {
			String[] arrMtffcs = tcarinfo.getServeritem().split(";");
			if (arrMtffcs != null && arrMtffcs.length > 0) {
				for (int i = 0; i < arrMtffcs.length; i++) {
					if("ABCDEFGHIJKLMNOPQRSTUVWXYZ".indexOf(arrMtffcs[i])!= -1){
						dict="喷漆:"+com.dyneinfo.zazh.util.DictFun.getDictValue("serverItem", arrMtffcs[i]);
					}else{
						dict=com.dyneinfo.zazh.util.DictFun.getDictValue("serverItem", arrMtffcs[i]);
					}
					if (i == 0)
						dictValue =dict;
					else
						dictValue = dictValue+ "-"+ dict;
					
//					if (i == 0)
//						dictValue = com.dyneinfo.hotel.util.DictFun.getDictValue("serverItem", arrMtffcs[i]);
//					else
//						dictValue = dictValue+ "-"+ com.dyneinfo.hotel.util.DictFun.getDictValue("serverItem", arrMtffcs[i]);
				}
			}
		}
		request.setAttribute("serveritemName", dictValue);
		//tcarinfo.setServeritem(dictValue);
		
		StringBuffer data = new StringBuffer("var ja=[];");
		List serveritem = tcarinfoManager.getServeritemForLevelOne();
		if (serveritem != null) {
			for (int i = 0; i < serveritem.size(); i++) {
				Map map = (Map) serveritem.get(i);
				if(map.get("dictlevel") != null && map.get("dictlevel").toString().equals("1"))
					data.append("\r\n");
				data.append("ja['"+map.get("dictid")+"']='"+map.get("dictname")+"';");
			}
		}
		request.setAttribute("data", data);
		
		
		StringBuffer dataTwo = new StringBuffer("var menus=new Array(new Array('1','信息','0'),");
		List serveritemTwo = tcarinfoManager.getServeritemForLevelTwo();
		if (serveritemTwo != null) {
			for (int i = 0; i < serveritemTwo.size(); i++) {
				Map map = (Map) serveritemTwo.get(i);
				dataTwo.append("new Array('"+map.get("dictid")+"','"+map.get("dictname")+"','"+map.get("parentid")+"'),");
			}
		}
		dataTwo.append("'');");
		request.setAttribute("dataTwo", dataTwo);
		
		return EDIT_JSP;
	}

	/** 进入取车页面 */
	public String collectCar() {
		HttpServletRequest request = ServletActionContext.getRequest();
		getColor();
		String deptID = "";
		String deptName = "";
		MyUserDetails userDetail = null;
		userDetail = SpringTagFunctions.getUserDetails();
		if (userDetail != null) {
			deptID = userDetail.getDeptID();
			deptName = userDetail.getDeptName();
		}
		String smycode = tcpinfojxyManager.smycode(deptID);
		String typecode = tcpinfojxyManager.typecode(deptID);
		request.setAttribute("smycode", smycode);
		request.setAttribute("typecode", typecode);
		
	
		
//		StringBuffer checkboxhtml = new StringBuffer("");
//		String language = "";
//		List datas = null;
//		Locale local = (Locale) request.getLocale();
//		if (local != null)
//			language = local.toString();
//		datas = DictHelpImpl.getDict("serverItem", language);
//		if (tcarinfo != null && tcarinfo.getServeritem() != null) {
//			String[] arrMtffcs = tcarinfo.getServeritem().split(";");
//			if (arrMtffcs != null && arrMtffcs.length > 0) {
//				for (int i = 0; i < arrMtffcs.length; i++) {
//					for (int j = 0; j < datas.size(); j++) {
//						ISelectOption bean = (ISelectOption) datas.get(j);
//						if (bean.getValue() != null && bean.getValue() != null
//								&& bean.getValue().equals(arrMtffcs[i])) {
//							checkboxhtml.append("<INPUT type=checkbox_extended=\"true\" name='serveritemDiv' CHECKED value='"
//											+ bean.getValue()
//											+ "'/> "
//											+ bean.getName());
//						}
//					}
//				}
//			}
//		}
//		request.setAttribute("checkboxhtml", checkboxhtml);
		
		String dictValue = "";
		String dict = "";
		if (tcarinfo != null && tcarinfo.getServeritem() != null) {
			String[] arrMtffcs = tcarinfo.getServeritem().split(";");
			if (arrMtffcs != null && arrMtffcs.length > 0) {
				for (int i = 0; i < arrMtffcs.length; i++) {
					if("ABCDEFGHIJKLMNOPQRSTUVWXYZ".indexOf(arrMtffcs[i])!= -1){
						dict="喷漆:"+com.dyneinfo.zazh.util.DictFun.getDictValue("serverItem", arrMtffcs[i]);
					}else{
						dict=com.dyneinfo.zazh.util.DictFun.getDictValue("serverItem", arrMtffcs[i]);
					}
					if (i == 0)
						dictValue =dict;
					else
						dictValue = dictValue+ "-"+ dict;
//					if (i == 0)
//						dictValue = com.dyneinfo.hotel.util.DictFun.getDictValue("serverItem", arrMtffcs[i]);
//					else
//						dictValue = dictValue+ "-"+ com.dyneinfo.hotel.util.DictFun.getDictValue("serverItem", arrMtffcs[i]);
				}
			}
		}
		request.setAttribute("serveritemName", dictValue);
		//tcarinfo.setServeritem(dictValue);
		
		StringBuffer data = new StringBuffer("var ja=[];");
		List serveritem = tcarinfoManager.getServeritemForLevelOne();
		if (serveritem != null) {
			for (int i = 0; i < serveritem.size(); i++) {
				Map map = (Map) serveritem.get(i);
				if(map.get("dictlevel") != null && map.get("dictlevel").toString().equals("1"))
					data.append("\r\n");
				data.append("ja['"+map.get("dictid")+"']='"+map.get("dictname")+"';");
			}
		}
		request.setAttribute("data", data);
		
		
		StringBuffer dataTwo = new StringBuffer("var menus=new Array(new Array('1','信息','0'),");
		List serveritemTwo = tcarinfoManager.getServeritemForLevelTwo();
		if (serveritemTwo != null) {
			for (int i = 0; i < serveritemTwo.size(); i++) {
				Map map = (Map) serveritemTwo.get(i);
				dataTwo.append("new Array('"+map.get("dictid")+"','"+map.get("dictname")+"','"+map.get("parentid")+"'),");
			}
		}
		dataTwo.append("'');");
		request.setAttribute("dataTwo", dataTwo);
		
		java.text.SimpleDateFormat dateformat = new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm");
		tcarinfo.setTotime(dateformat.format(new Date()));
		return COLLECT_JSP;
	}

	// 显示图片
	public String showPic() {
		HttpServletRequest request = ServletActionContext.getRequest();
		String enrolid = "";
		if (request.getParameter("enrolid") != null)
			enrolid = request.getParameter("enrolid");
		List list = (List) tcarinfoManager.getPic(enrolid);
		request.setAttribute("list", list);
		return SHOW_PIC;
	}

	// 修改图片
	public String updatePic() {
		HttpServletRequest request = ServletActionContext.getRequest();
		String enrolid = "";
		if (request.getParameter("enrolid") != null)
			enrolid = request.getParameter("enrolid");
		try {
			if (file != null && file.length() < FilemaxSize) {
				if (enrolid != null && enrolid.length() > 0) {
					tcarinfoManager.updatePic(file, enrolid);
				}
			} else {
				request.setAttribute("message", "上传照片不能大于" + FilemaxSize / 1024
						/ 1024 + "M");
				return UPDATEPHOTOFAILURE;
			}
		} catch (IOException e) {
			request.setAttribute("message", "修改照片失败");
			return UPDATEPHOTOFAILURE;
		}
		return UPDATEPHOTOSUCCESS;
	}

	/** 保存更新对象 */
	public String update() {
		HttpServletRequest request = ServletActionContext.getRequest();

		String carid = tcarinfo.getCarid1() + tcarinfo.getCarid().toUpperCase();
		String color = tcarinfo.getColor1() + tcarinfo.getColor2()
				+ tcarinfo.getColor3();
		tcarinfo.setCarid(carid);
		tcarinfo.setColor(color);
		tcarinfoManager.update(this.tcarinfo);
		Tcarreturn tcarreturn = new Tcarreturn();
		
		String tomobile = "";
		if (request.getParameter("tomobile") != null)
			tomobile = request.getParameter("tomobile");

		tcarreturn = this.setTcarreturn(tcarinfo.getEnrolid(),tomobile);// 车辆交接信息表赋值
		tcarreturnManager.update(tcarreturn);
		return returnUrl;// //LIST_ACTION;
	}

	/** 取车 */
	public String collectUpdate() {
		HttpServletRequest request = ServletActionContext.getRequest();
		Tcarreturn tcarreturn = new Tcarreturn();

		tcarinfo.setFlag("1");
		tcarreturn.setFlag("1");

		tcarinfoManager.update(tcarinfo);
		
		String tomobile = "";
		if (request.getParameter("tomobile") != null)
			tomobile = request.getParameter("tomobile");
		
		tcarreturn = this.setTcarreturn(tcarinfo.getEnrolid(),tomobile);// 车辆交接信息表赋值
		tcarreturnManager.update(tcarreturn);
		return returnUrl;// //LIST_ACTION;
	}

	/** 删除对象 */
	public String delete() {
		for (int i = 0; i < items.length; i++) {
			Hashtable params = HttpUtils.parseQueryString(items[i]);
			java.lang.String id = new java.lang.String((String) params
					.get("enrolid"));
			tcarinfo = tcarinfoManager.getById(id);
			Tcarreturn tcarreturn = tcarreturnManager.getById(id);
			tcarinfo.setFlag("1");
			tcarreturn.setFlag("1");
			tcarinfoManager.update(tcarinfo);
			tcarreturnManager.update(tcarreturn);
			// tcarinfoManager.removeById(id);
		}
		return returnUrl;// LIST_ACTION;
	}

	public Tcarreturn setTcarreturn(String enrolId,String tomobile) {
		Tcarreturn tcarreturn = new Tcarreturn();
		// 时间格式转换
		java.text.SimpleDateFormat dateformat = new java.text.SimpleDateFormat(
				"yyyy-MM-dd HH:mm");
		java.text.SimpleDateFormat df = new java.text.SimpleDateFormat(
				"yyyyMMddHHmm");
		String recetime = "";
		String totime = "";
		try {
			if (tcarinfo.getRecetime() != null
					&& !tcarinfo.getRecetime().trim().equals(""))
				recetime = df.format(dateformat.parse(tcarinfo.getRecetime()));
			if (tcarinfo.getTotime() != null
					&& !tcarinfo.getTotime().trim().equals(""))
				totime = df.format(dateformat.parse(tcarinfo.getTotime()));
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		// 承接车辆基本信息赋值

		tcarreturn.setEnrolid(enrolId); // 登记序号
		tcarreturn.setDeliname(tcarinfo.getDeliname()); // 送车人姓名
//		tcarreturn.setDelicredcode(this.changeID(tcarinfo.getDelicredcode())); // 送车人身份证号码
		tcarreturn.setDelicredcode( tcarinfo.getDelicredcode()); // 送车人身份证号码
		tcarreturn.setDelitelephone(tcarinfo.getDelitelephone()); // 送车人电话号码
		tcarreturn.setDeliaddress(tcarinfo.getDeliaddress());//送车人住址 add by zzq 2012/06/12
		tcarreturn.setRecename(tcarinfo.getRecename()); // 收车人姓名
		tcarreturn.setRecetime(recetime); // 收车时间
		tcarreturn.setServeritem(tcarinfo.getServeritem()); // 服务项目
		tcarreturn.setTakeoffname(tcarinfo.getTakeoffname()); // 取车人姓名
//		tcarreturn.setTocredcode(this.changeID(tcarinfo.getTocredcode())); // 取车人证件号码
		tcarreturn.setTocredcode( tcarinfo.getTocredcode()); // 取车人证件号码
		tcarreturn.setTotime(totime); // 取车时间
		tcarreturn.setDemo(tcarinfo.getDemo()); // 备注
		tcarreturn.setFlag("0"); // 删除状态
		tcarreturn.setEnroltime(tcarinfo.getEnroltime()); // 操作时间
		tcarreturn.setOperator(tcarinfo.getOperator()); // 操作员
		tcarreturn.setDelicredtype("A");
		tcarreturn.setTomobile(tomobile);
		return tcarreturn;

	}

	public String getEnrolId() {
		HttpServletRequest request = ServletActionContext.getRequest();
		SecurityContext sc = SecurityContextHolder.getContext();
		Authentication auth = sc.getAuthentication();
		MyUserDetails ud = null;
		SimpleDateFormat formatoptime = new SimpleDateFormat("yyyyMMdd");

		String kyrqFormat = DateUtil.parseString(request, "kyrq", "yyyy-MM-dd",
				"yyyyMMdd");
		String deptid = "";
		String deptseq ="";
		if ((auth != null) && auth.getPrincipal() instanceof MyUserDetails) {
			ud = (MyUserDetails) auth.getPrincipal();
			if (ud != null) {
				deptid = ud.getDeptID();
				deptseq = ud.getDeptSeq();
			}
		}
		String sequence = deptid + formatoptime.format(new Date());
		String maxSequence = null;
		try {
			maxSequence = tcarinfoManager.getMaxSequence(sequence);
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		return deptid + formatoptime.format(new Date()) + maxSequence;
	}

	public void setUserDetails() {
		HttpServletRequest request = ServletActionContext.getRequest();
		SecurityContext sc = SecurityContextHolder.getContext();
		Authentication auth = sc.getAuthentication();
		MyUserDetails ud = null;

		if ((auth != null) && auth.getPrincipal() instanceof MyUserDetails) {
			ud = (MyUserDetails) auth.getPrincipal();
			if (ud != null) {
				deptId = ud.getDeptID();
				userId = ud.getUserId();
				userName = ud.getUserName();

			}
		}
	}

	public String getOldInfo() {
		HttpServletRequest request = ServletActionContext.getRequest();
		String ajax = request.getParameter("ajax");
		String carid = request.getParameter("carid");
		try {

			carid = URLDecoder.decode(carid, "UTF-8").trim();

		} catch (UnsupportedEncodingException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		List tcarinfoList = tcarinfoManager.getInfoByCarid(carid.toUpperCase());
		if (tcarinfoList.isEmpty()) {

			return null;
		}
		Map tcarinfoMap=new HashMap();
		StringBuffer html = new StringBuffer();
		String flag="";
		for(int i=0;i<tcarinfoList.size();i++){
			tcarinfoMap = (Map) tcarinfoList.get(i);
			 flag= tcarinfoMap.get("flag") != null && tcarinfoMap.get("flag").equals("0")? tcarinfoMap.get("flag")
						.toString().trim() : "1";
		}
		 
		if(flag.equals("0")){
			html.append("zt");
		}else{
			tcarinfoMap = (Map) tcarinfoList.get(0);
			html.append("{carowner: '");
			html.append(tcarinfoMap.get("carowner"));// 车主
			html.append("',");
			
			html.append("deliname: '");
			html.append(tcarinfoMap.get("deliname"));// 送车人姓名
			html.append("',");
			
			html.append("delicredcode: '");
			html.append(tcarinfoMap.get("delicredcode"));// 送车人证件号码
			html.append("',");
			
			html.append("delitelephone: '");
			html.append(tcarinfoMap.get("delitelephone"));//送车人电话
			html.append("',");
			
			html.append("deliaddress: '");
			html.append(tcarinfoMap.get("deliaddress")!= null ? tcarinfoMap.get("deliaddress") : "");// 送车人住址 
			html.append("',");
			
			html.append("cartype: '");
			html.append(tcarinfoMap.get("cartype"));// 车辆类型
			html.append("',");
			html.append("brand: '");
			html.append(tcarinfoMap.get("brand") != null ? tcarinfoMap.get("brand")
					.toString().trim() : "");// 车辆品牌
			html.append("',");
			
			html.append("clsbcode: '");
			html.append(tcarinfoMap.get("clsbcode")!= null ?tcarinfoMap.get("clsbcode") : "");  //车辆识别代码
			html.append("',");
			
			html.append("color1: '");
			html.append(tcarinfoMap.get("color") != null ? tcarinfoMap.get("color")
					.toString().substring(0, 1) : "");// 车辆颜色1
			html.append("',");
			html.append("color2: '");
			html.append(tcarinfoMap.get("color") != null
							&& tcarinfoMap.get("color").toString().length() > 1 ? tcarinfoMap
							.get("color").toString().substring(1, 2)
							: "");// 车辆颜色2
			html.append("',");
			html.append("color3: '");
			html.append(tcarinfoMap.get("color") != null
							&& tcarinfoMap.get("color").toString().length() > 2 ? tcarinfoMap
							.get("color").toString().substring(2, 3)
							: "");// 车辆颜色3
			html.append("',");
			html.append("enginecode: '");
			html.append(tcarinfoMap.get("enginecode") != null ? tcarinfoMap
					.get("enginecode") : "");// 发动机好
			html.append("',");
			html.append("bodycode: '");
			html.append(tcarinfoMap.get("bodycode") != null ? tcarinfoMap
					.get("bodycode") : "");// 车架号
			html.append("'}");
		}
		

		if (ajax != null && ajax.equals("true")) {
			try {
				byte[] contents = html.toString().getBytes("UTF-8");
				getResponse().getOutputStream().write(contents);
			} catch (IOException e) {
				e.printStackTrace();
			}
			return null;
		}

		return html.toString();
	}

	public void getColor() {
		String totime = tcarinfo.getTotime();
		String recetime = tcarinfo.getRecetime();

		String totimeFormat = DateUtil.parseString(totime, "yyyyMMddHHmm",
				"yyyy-MM-dd HH:mm");
		String recetimeFormat = DateUtil.parseString(recetime, "yyyyMMddHHmm",
				"yyyy-MM-dd HH:mm");

		tcarinfo.setTotime(totimeFormat);
		tcarinfo.setRecetime(recetimeFormat);

		String color = tcarinfo.getColor();
		String carid = tcarinfo.getCarid();
		if (color != null) {

			for (int i = 0; i < color.length(); i++) {
				if (i == 0)
					tcarinfo.setColor1(color.substring(0, 1));
				if (i == 1)
					tcarinfo.setColor2(color.substring(1, 2));
				if (i == 2)
					tcarinfo.setColor3(color.substring(2, 3));
			}
		}
		if (carid != null) {

			tcarinfo.setCarid1(carid.substring(0, 1));
			tcarinfo.setCarid(carid.substring(1, carid.length()));
		}

	}
	
	

	

	public void getServeritem() {

		HttpServletRequest request = ServletActionContext.getRequest();

		StringBuffer data = new StringBuffer("");
		// 数据格式：
		// {id: "10",name: "苹果"},{id: "20",name: "香蕉"},{id: "30",name:
		// "西瓜"},{id: "40",name: "桃子"},{id: "50",name: "葡萄"}
		List serveritem = tcarinfoManager.getServeritem();
		for (int i = 0; i < serveritem.size(); i++) {
			Map map = (Map) serveritem.get(i);
			data.append("{id: \"").append(map.get("dictid")).append("\"");
			data.append(",name:\"").append(map.get("dictname")).append("\"},");
		}
		data.replace(data.length() - 1, data.length(), "");

		request.setAttribute("data", data);
	}

	/** 增加setXXXX()方法,spring就可以通过autowire自动设置对象属性 */
	public void setTcarinfoManager(TcarinfoManager manager) {
		this.tcarinfoManager = manager;
	}

	public void setEnrolid(java.lang.String val) {
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

	public String getDeptId() {
		return deptId;
	}

	public void setDeptId(String deptId) {
		this.deptId = deptId;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public File getFile() {
		return file;
	}

	public void setFile(File file) {
		this.file = file;
	}

	public String getFileFileName() {
		return fileFileName;
	}

	public void setFileFileName(String fileFileName) {
		this.fileFileName = fileFileName;
	}

	public String getFileContentType() {
		return fileContentType;
	}

	public void setFileContentType(String fileContentType) {
		this.fileContentType = fileContentType;
	}

	public void setTcarreturnManager(TcarreturnManager tcarreturnManager) {
		this.tcarreturnManager = tcarreturnManager;
	}

	public Object getModel() {
		return tcarinfo;
	}

	public static String changeID(String ID15) {
		String ID18 = "";
		if (ID15 == null || ID15.equals(""))
			return null;
		if (ID15.length() == 18) {
			ID18 = ID15.toUpperCase();
		}
		if (ID15.length() == 15) {
			int[] w = { 7, 9, 10, 5, 8, 4, 2, 1, 6, 3, 7, 9, 10, 5, 8, 4, 2, 1 };
			char[] A = { '1', '0', 'X', '9', '8', '7', '6', '5', '4', '3', '2' };
			String ID17 = ID15.substring(0, 6) + "19" + ID15.substring(6, 15);
			int[] ID17Array;
			ID17Array = new int[17];
			for (int i = 0; i < 17; i++) {
				ID17Array[i] = Integer.parseInt(ID17.substring(i, i + 1));
			}
			int s = 0;
			for (int i = 0; i < 17; i++) {
				s = s + ID17Array[i] * w[i];
			}
			s = s % 11;
			ID18 = ID17 + Character.toString(A[s]);
		}

		return ID18;
	}

	public TreeMap<String, String> getServerItemSelectMap() {
		return serverItemSelectMap;
	}

	public void setServerItemSelectMap(TreeMap<String, String> serverItemSelectMap) {
		this.serverItemSelectMap = serverItemSelectMap;
	}
	public String util(String serveritem){
		
		String a[] = serveritem.split(";");
		java.util.Arrays.sort(a);
		System.out.println(a);
		String util="";
		for(int x = 0; x<a.length;x++){
			util +=a[x]+";" ;
			
		}
		util= util.substring(0, util.length()-1);
		System.out.println(util+"*********************************");
		
		return util;
		
	}
	public String showjsp() {
		HttpServletRequest request = ServletActionContext.getRequest();
		String pid = "";
		if(request.getParameter("pid")!=null){
			pid = request.getParameter("pid");
		}
		tcarinfo = (Tcarinfo) tcarinfoManager.getById(pid);
		getColor();
		
		String dictValue = "";
		String dict = "";
		if (tcarinfo != null && tcarinfo.getServeritem() != null) {
			String[] arrMtffcs = tcarinfo.getServeritem().split(";");
			if (arrMtffcs != null && arrMtffcs.length > 0) {
				for (int i = 0; i < arrMtffcs.length; i++) {
					if("ABCDEFGHIJKLMNOPQRSTUVWXYZ".indexOf(arrMtffcs[i])!= -1){
						dict="喷漆:"+com.dyneinfo.zazh.util.DictFun.getDictValue("serverItem", arrMtffcs[i]);
					}else{
						dict=com.dyneinfo.zazh.util.DictFun.getDictValue("serverItem", arrMtffcs[i]);
					}
					if (i == 0)
						dictValue =dict;
					else
						dictValue = dictValue+ "-"+ dict;
//					if (i == 0)
//						dictValue = com.dyneinfo.hotel.util.DictFun.getDictValue("serverItem", arrMtffcs[i]);
//					else
//						dictValue = dictValue+ "-"+ com.dyneinfo.hotel.util.DictFun.getDictValue("serverItem", arrMtffcs[i]);
				}
			}
		}
		tcarinfo.setServeritem(dictValue);
		
		
		java.lang.String deliname = "";// 送车人姓名
		java.lang.String delicredcode = "";// 送车人身份证号码
		java.lang.String delitelephone = "";// 送车人电话号码
		java.lang.String deliaddress = "";// 送车人住址 add by zzq 2012/06/12
		java.lang.String recename = "";// 收车人姓名
		java.lang.String recetime = "";// 收车时间
		java.lang.String serveritem = "";// 服务项目
		java.lang.String takeoffname = "";// 取车人姓名
		java.lang.String tocredcode = "";// 取车人证件号码
		java.lang.String totime = "";// 取车时间
		java.lang.String demo = "";// 备注
		if (tcarinfo != null) {
			deliname = tcarinfo.getDeliname();
			delicredcode = tcarinfo.getDelicredcode();
			delitelephone = tcarinfo.getDelitelephone();
			deliaddress=tcarinfo.getDeliaddress();//送车人住址 add by zzq 2012/06/12
			recename = tcarinfo.getRecename();
			recetime = tcarinfo.getRecetime();
			serveritem = tcarinfo.getServeritem();
			takeoffname = tcarinfo.getTakeoffname();
			tocredcode = tcarinfo.getTocredcode();
			totime = tcarinfo.getTotime();
			demo = tcarinfo.getDemo();

		}

		java.lang.String enrolid = "";
		java.lang.String carowner = "";
		java.lang.String cartype = "";
		java.lang.String brand = "";
		java.lang.String color_ext = "";
		java.lang.String carid_ext = "";
		java.lang.String enginecode = "";
		java.lang.String bodycode = "";
		java.lang.String enroltime = "";
		java.lang.String operator = "";
		java.lang.String cpcode = "";
		java.lang.String flag = "";
		java.lang.String color1 = "";
		java.lang.String color2 = "";
		java.lang.String color3 = "";
		java.lang.String carid1;	
		
		 String cardidName = "";
		 String cartypeName = "";
		 String color1Name= "";
		 String color2Name= "";
		 String color3Name= "";
		 String serveritemName = "";
		
		
		if (tcarinfo != null) {
			 enrolid = tcarinfo.getEnrolid();
			 carowner =tcarinfo.getCarowner();
			 
			 
			 
			 cartype =tcarinfo.getCartype();
			 brand = tcarinfo.getBrand();
			 color_ext = tcarinfo.getColor();
			 carid_ext = tcarinfo.getCarid();
			 enginecode = tcarinfo.getEnginecode();
			 bodycode = tcarinfo.getBodycode();
			 enroltime = tcarinfo.getEnroltime();
			 operator = tcarinfo.getOperator();
			 cpcode = tcarinfo.getCpcode();
			 flag = tcarinfo.getFlag();
			 color1 = tcarinfo.getColor1();
			 color2 = tcarinfo.getColor2();
			 color3 = tcarinfo.getColor3();
			 carid1 = tcarinfo.getCarid1();
			 
			 
			
			 List datas = DictHelpImpl.getDict("cpht");
				if(carid1 != null && carid1.length() > 0){
				for (int i = 0; i < datas.size(); i++) {
					ISelectOption bean = (ISelectOption) datas.get(i);
					if (bean.getValue() != null && bean.getValue().equals(carid1))
						cardidName = bean.getName();

				}}
				cardidName = cardidName+ carid_ext;
				
				
				datas = DictHelpImpl.getDict("cllx");
				if(cartype != null && cartype.length() > 0){
				for (int i = 0; i < datas.size(); i++) {
					ISelectOption bean = (ISelectOption) datas.get(i);
					if (bean.getValue() != null && bean.getValue().equals(cartype))
						cartypeName = bean.getName();

				}}
				
				datas = DictHelpImpl.getDict("csys");
				if(color1 != null && color1.length() > 0){
				for (int i = 0; i < datas.size(); i++) {
					ISelectOption bean = (ISelectOption) datas.get(i);
					if (bean.getValue() != null && bean.getValue().equals(color1))
						color1Name = bean.getName();

				}}
				
			
				if(color2 != null && color2.length() > 0){
				for (int i = 0; i < datas.size(); i++) {
					ISelectOption bean = (ISelectOption) datas.get(i);
					if (bean.getValue() != null && bean.getValue().equals(color2))
						color2Name = bean.getName();

				}}
				
			
				if(color3 != null && color3.length() > 0){
				for (int i = 0; i < datas.size(); i++) {
					ISelectOption bean = (ISelectOption) datas.get(i);
					if (bean.getValue() != null && bean.getValue().equals(color3))
						color3Name = bean.getName();

				}}
				
				
				if (tcarinfo != null && tcarinfo.getServeritem() != null) {
					String[] arrMtffcs = tcarinfo.getServeritem().split(";");
					if (arrMtffcs != null && arrMtffcs.length > 0) {
						for (int i = 0; i < arrMtffcs.length; i++) {
							if (i == 0)
								serveritemName = com.dyneinfo.zazh.util.DictFun.getDictValue("serverItem", arrMtffcs[i]);
							else
								serveritemName = serveritemName+ "-"+ com.dyneinfo.zazh.util.DictFun.getDictValue("serverItem", arrMtffcs[i]);
						}
					}
				}
		}
		request.setAttribute("carowner", carowner);
		request.setAttribute("cardidName", cardidName);
		request.setAttribute("cartypeName", cartypeName);
		request.setAttribute("brand", brand);
		request.setAttribute("enginecode", enginecode);
		request.setAttribute("bodycode", bodycode);
		request.setAttribute("color1Name", color1Name);
		request.setAttribute("color2Name", color2Name);
		request.setAttribute("color3Name", color3Name);
		request.setAttribute("deliname", deliname);
		request.setAttribute("delicredcode", delicredcode);
		request.setAttribute("delitelephone", delitelephone);
		request.setAttribute("delitelephone", delitelephone);
		request.setAttribute("deliaddress", deliaddress);	//送车人住址 add by zzq 2012/06/12
		request.setAttribute("recename", recename);
		request.setAttribute("recetime", recetime);
		request.setAttribute("takeoffname", takeoffname);
		request.setAttribute("tocredcode", tocredcode);
		request.setAttribute("serveritemName", serveritemName);
		request.setAttribute("totime", totime);
		request.setAttribute("demo", demo);
		
		return SHOW_VCARRETURN;
	}
	
	// 显示图片
	public String getPicture() {
		HttpServletRequest request = ServletActionContext.getRequest();
		String sql = request.getParameter("sql");
		if (sql != null && !sql .equals("")){
			List list = (List) tcarinfoManager.getPicture(sql);
			request.setAttribute("list", list);
		}
		return SHOW_PIC;
	}
}
