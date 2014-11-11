/*
 * Powered By [lishicheng]
 */

package com.dyneinfo.jxy.action;

import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import javacommon.base.BaseStruts2Action;

import javax.servlet.http.HttpServletRequest;

import net.java.dev.common.util.DateUtil;
import net.java.dev.common.util.SpringTagFunctions;

import org.apache.struts2.ServletActionContext;
import org.security.userdetails.MyUserDetails;

import sun.misc.BASE64Decoder;

import cn.org.rapid_framework.page.Page;
import cn.org.rapid_framework.page.PageRequest;
import cn.org.rapid_framework.web.util.HttpUtils;

import com.dyneinfo.jxy.model.Tcarinfo;
import com.dyneinfo.jxy.model.Temployee;
import com.dyneinfo.jxy.model.Tempworklog;
import com.dyneinfo.jxy.service.TcpinfojxyManager;
import com.dyneinfo.jxy.service.TemployeejxyManager;
import com.dyneinfo.jxy.service.TempworklogjxyManager;
import com.dyneinfo.zazh.service.SsCommonManager;
import com.dyneinfo.zazh.util.IDCard;
import com.opensymphony.xwork2.ModelDriven;
import com.opensymphony.xwork2.Preparable;
import com.sun.org.apache.xerces.internal.impl.dv.util.Base64;

/**
 * @author lisc email:lishicheng(a)gmail.com
 */


public class TemployeeAction extends BaseStruts2Action implements Preparable,ModelDriven{
	//默认多列排序,example: username desc,createTime asc
	protected static final String DEFAULT_SORT_COLUMNS = null; 
	
	//forward paths
	protected static final String QUERY_JSP = "/pages/jxy/Temployee/query.jsp";
	protected static final String LIST_JSP= "/pages/jxy/Temployee/list.jsp";
	protected static final String CREATE_JSP = "/pages/jxy/Temployee/create.jsp";
	protected static final String EDIT_JSP = "/pages/jxy/Temployee/edit.jsp";
	protected static final String SHOW_JSP = "/pages/jxy/Temployee/show.jsp";
	protected static final String ZAZHSHOW_JSP = "/pages/jxy/Temployee/zazhShow.jsp";
	protected static final String TAB_JSP = "/pages/jxy/Temployee/tab.jsp";
	//redirect paths,startWith: !
	protected static final String LIST_ACTION = "!/jxy/Temployee/list.do";
	
	protected static final String SHOWALL_JSP = "/pages/jxy/Temployee/showAll.jsp";
	protected static final String LISTALL_JSP= "/pages/jxy/Temployee/listAll.jsp";
	protected static final String CREATEALL_JSP = "/pages/jxy/Temployee/createAll.jsp";
	protected static final String EDITALL_JSP = "/pages/jxy/Temployee/editAll.jsp";
	protected static final String SHOW_PIC = "/pages/jxy/pic/pic.jsp";
	protected static final String TABALL_JSP = "/pages/jxy/Temployee/tabAll.jsp";
	protected static final String UPDATEPHOTOSUCCESS = "/pages/jxy/pic/uploadFileSuccess.jsp";
	protected static final String UPDATEPHOTOFAILURE= "/pages/jxy/pic/uploadFileFailure.jsp";
	protected static final String UPDATEPHOTOERROR="/pages/jxy/pic/updateFileError.jsp";
	
	
	private TemployeejxyManager temployeejxyManager;
	private SsCommonManager ssCommonManager;
	private TempworklogjxyManager tempworklogjxyManager;
	private TcpinfojxyManager tcpinfojxyManager;
	public void setTcpinfojxyManager(TcpinfojxyManager manager) {
		this.tcpinfojxyManager = manager;
	}
	
	private Temployee temployee;
	java.lang.String id = null;
	java.lang.String cpcode=null;
	private String[] items;
	private String returnUrl;  //返回列表，保留查询条件
	private TreeMap<String, String> dateSelectMap;// //日期选择
	TreeMap<String,String> provMap ;
	
	private String filmName;
	private String filmContent;
	private File file;
	private String fileFileName;
	private String fileContentType;
	private long FilemaxSize = 100*1024; //照片字节

	
	

	public void prepare() throws Exception {
		if (isNullOrEmptyString(id)||isNullOrEmptyString(cpcode)) {
			temployee = new Temployee();
		} else {
			temployee = (Temployee)temployeejxyManager.getTemployeeById(id,cpcode);
		}
		
	}
	
	/** 增加setXXXX()方法,spring就可以通过autowire自动设置对象属性 */
	public void setTemployeejxyManager(TemployeejxyManager manager) {
		this.temployeejxyManager = manager;
	}	
	public void setSsCommonManager(SsCommonManager ssCommonManager) {
		this.ssCommonManager = ssCommonManager;
	}
	
	public void setTempworklogjxyManager(TempworklogjxyManager manager) {
		this.tempworklogjxyManager = manager;
	}	
	
	public Object getModel() {
		return temployee;
	}
	
	public void setCpempcode(java.lang.String val) {
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
		String message=request.getParameter("message");
		if(message!=null){
			
			request.setAttribute("message",message);
		}

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

		if(SpringTagFunctions.ifAnyGranted("ROLE_HT_ADMIN,ROLE_ADMIN")){
			
		} else if(SpringTagFunctions.ifAnyGranted("ROLE_QUERY_CURRENT_ORG")){
			pageRequest.getFilters().put("cpcode",deptid);
		} else if(SpringTagFunctions.ifAnyGranted("ROLE_QUERY_CHILD_ORG")){
			pageRequest.getFilters().put("deptSeq",deptseq);
		} else {
			
			pageRequest.getFilters().put("cpcode",deptid);
		}
		pageRequest.getFilters().put("deptSeq",deptseq);
		
		dateSelectMap  = DateUtil.getDateSelectData();
	        
		String s_birthBeginFormat = DateUtil.parseString(request,"s_birthBegin","yyyy-MM-dd","yyyyMMdd");
		String s_birthEndFormat = DateUtil.parseString(request,"s_birthEnd","yyyy-MM-dd","yyyyMMdd");
		pageRequest.getFilters().put("birthBeginFormat",s_birthBeginFormat);
		pageRequest.getFilters().put("birthEndFormat",s_birthEndFormat);

		String dateSelect10 = "";
		if (request.getParameter("dateSelect10") != null)
		    dateSelect10 = request.getParameter("dateSelect10");
			request.setAttribute("dateSelect10",dateSelect10);		        
		String s_indateBeginFormat = DateUtil.parseString(request,"s_indateBegin","yyyy-MM-dd","yyyyMMdd");
		String s_indateEndFormat = DateUtil.parseString(request,"s_indateEnd","yyyy-MM-dd","yyyyMMdd");
		pageRequest.getFilters().put("indateBeginFormat",s_indateBeginFormat);
		pageRequest.getFilters().put("indateEndFormat",s_indateEndFormat);
		
		Page page = temployeejxyManager.findByPageRequest(pageRequest);
		request.setAttribute("deptid", deptid);
		savePage(page,pageRequest);
		return LIST_JSP;
	}
	
	/** 查看对象*/
	public String show() {
		this.dateFormat();
		//this.getPhoto();
		
		return SHOW_JSP;
	}
	/** 查看对象*/
	public String zazhShow() {
		if(null == temployee){
			temployee = new Temployee();
		}
		this.dateFormat();
		//this.getPhoto();
		return ZAZHSHOW_JSP;
	}
	
	/** 进入新增页面*/
	public String create() {
		HttpServletRequest request = ServletActionContext.getRequest();
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
		
		provMap = new TreeMap();
		List listprov = ssCommonManager.getProv();
		if (listprov != null && listprov.size() > 0) {
			for(int i=0;i<listprov.size();i++){
				Map results = (HashMap) listprov.get(i);
				String CODE = (String) results.get("CODE");
				String CALLED = (String) results.get("CALLED");
				provMap.put(CODE, CALLED);
				
			}
		}
		
		return CREATE_JSP;
	}
	
	/** 保存新增对象 
	 * @throws IOException */
	public String save() throws IOException {
		HttpServletRequest request = ServletActionContext.getRequest();
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
		Date date = new Date();
		BASE64Decoder decode = new BASE64Decoder();
		String pPhotoBuffer = null;
		byte[] pic =null;
		if(request.getParameter("pPhotoBuffer")!= null){
			pPhotoBuffer = request.getParameter("pPhotoBuffer").toString();
			
			 pic = decode.decodeBuffer(pPhotoBuffer); 
		}
		SimpleDateFormat format = new SimpleDateFormat("yyyyMMddHHmmss");
		String currDate = format.format(date);
		
		SimpleDateFormat logformat = new SimpleDateFormat("yyyyMMdd");
		String currDatelog = logformat.format(date);
		
		SimpleDateFormat formatInsert = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String currDateInsert = formatInsert.format(date);
		temployee.setInserttimeString(currDateInsert);
		temployee.setEdittimeString(currDateInsert);
		
		this.setFormatDate();
		
		
		String new_IDCard = "";
		String old_IDCard = "";
		if (temployee != null && temployee.getPersonid() != null
				&& temployee.getPersonid().length() == 15) {
			new_IDCard = IDCard.getNewIDCard(temployee.getPersonid());
			old_IDCard = temployee.getPersonid();
		} else if (temployee != null && temployee.getPersonid() != null
				&& temployee.getPersonid().length() == 18) {
			old_IDCard = IDCard.getOldIDCard(temployee.getPersonid());
			new_IDCard = temployee.getPersonid();
		} else {
			new_IDCard = temployee.getPersonid();
			old_IDCard = temployee.getPersonid();
		}
		temployee.setPersonid(new_IDCard.toUpperCase());
		
	

		
		
		
		//int idcardcount = temployeeManager.getCountByIdcard(new_IDCard, old_IDCard);
		List  tempcyryList = temployeejxyManager.findCyryByIdcard(new_IDCard, old_IDCard);
		  if (tempcyryList.size() > 0) {
			  for(int i=0;i<tempcyryList.size();i++){
				 Temployee tempcyry=(Temployee) tempcyryList.get(i);
				 if(tempcyry.getCpcode().equals(deptID)){
					 request.setAttribute("message","从业人员身份证信息已存在！");
					  getProv();
					  	String birth =  temployee.getBirth();
						String birth1Format = DateUtil.parseString(birth,"yyyyMMdd","yyyy-MM-dd");
						temployee.setBirth(birth1Format);
						String rzrq =  temployee.getIndate();
						String rzrq1Format = DateUtil.parseString(rzrq,"yyyyMMdd","yyyy-MM-dd");
						temployee.setIndate(rzrq1Format);
					  return CREATE_JSP;////LIST_ACTION;
				 }else if(tempcyry.getCyrjzt().equals("0")){
					 request.setAttribute("message","此身份证号码在其它企业已经注册为在职员工！");
					  getProv();
					  String birth =  temployee.getBirth();
						String birth1Format = DateUtil.parseString(birth,"yyyyMMdd","yyyy-MM-dd");
						temployee.setBirth(birth1Format);
						String rzrq =  temployee.getIndate();
						String rzrq1Format = DateUtil.parseString(rzrq,"yyyyMMdd","yyyy-MM-dd");
						temployee.setIndate(rzrq1Format);
					  return CREATE_JSP;////LIST_ACTION;
				 }
				  
			  }			  
		  }
		
		
		

		String empcode = deptID+currDate;
		temployee.setCpcode(deptID);
		temployee.setCpempcode(empcode);
		temployee.setCyrjzt("0");
		
	
		
		// 保存图片
		if (file != null) {
			if (file.length() > FilemaxSize) {
				request.setAttribute("message", "上传照片不能大于"+FilemaxSize/1024+"KB"); 
				return	UPDATEPHOTOERROR ;
			}
			try {
				// /保存带照片的信息
				temployeejxyManager.savePic(file, temployee);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else  {
			// 没有图片直接保
			if(pic!= null){
				temployeejxyManager.savePic1(pic, temployee);
			}else{
			temployeejxyManager.save(temployee);
			}
		}
		
		
		
		Tempworklog tempworklog = new Tempworklog();
		tempworklog.setCpcode(deptID);
		tempworklog.setCpname(deptName);
		tempworklog.setEmpcode(temployee.getCpempcode());
		tempworklog.setEmptype("02");
		tempworklog.setIndate(temployee.getIndate());
		tempworklog.setPersonid(new_IDCard.toUpperCase());
		tempworklog.setStatus("0");
		
		tempworklogjxyManager.save(tempworklog);
		
		try {
			int idCount = ssCommonManager.getPicIDIsExist(empcode);
			if (idCount > 0)
				ssCommonManager.updatePic(file, file.length(), empcode);
			else
				ssCommonManager.savePic(file, file.length(), empcode);
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
		}
		
		return returnUrl;////LIST_ACTION;
	}
	
	/**进入更新页面*/
	public String edit() {
		HttpServletRequest request = ServletActionContext.getRequest();
		
		String smycode = tcpinfojxyManager.smycode(temployee.getCpcode());
		String typecode = tcpinfojxyManager.typecode(temployee.getCpcode());
		request.setAttribute("smycode", smycode);
		request.setAttribute("typecode", typecode);

		this.dateFormat();
		
		provMap = new TreeMap();
		List listprov = ssCommonManager.getProv();
		if (listprov != null && listprov.size() > 0) {
			for(int i=0;i<listprov.size();i++){
				Map results = (HashMap) listprov.get(i);
				String CODE = (String) results.get("CODE");
				String CALLED = (String) results.get("CALLED");
				provMap.put(CODE, CALLED);
				
			}
		}
		
		if(temployee != null && temployee.getNpcode() != null && temployee.getNpcode().length() > 2){
			request.setAttribute("npcodehidden", temployee.getNpcode());
			request.setAttribute("npcodeprovhidden", temployee.getNpcode().substring(0, 2)+"0000");
		}
		if(temployee != null && temployee.getNativeplace() != null && temployee.getNativeplace().length() > 2){
			request.setAttribute("nativeplacehidden", temployee.getNativeplace());
			request.setAttribute("nativeplaceprovhidden", temployee.getNativeplace().substring(0, 2)+"0000");
		}
		
		//this.getPhoto();
		
		
		String sffz=request.getParameter("sffz");
		return EDIT_JSP;
	}
	
	/**保存更新对象*/
	public String update() {
		HttpServletRequest request = ServletActionContext.getRequest();
		this.setFormatDate();
		
		Date date = new Date();
		SimpleDateFormat formatInsert = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String currDateInsert = formatInsert.format(date);
		temployee.setEdittimeString(currDateInsert);
		String new_IDCard = "";
		String old_IDCard = "";
		if (temployee != null && temployee.getPersonid() != null
				&& temployee.getPersonid().length() == 15) {
			new_IDCard = IDCard.getNewIDCard(temployee.getPersonid());
			old_IDCard = temployee.getPersonid();
		} else if (temployee != null && temployee.getPersonid() != null
				&& temployee.getPersonid().length() == 18) {
			old_IDCard = IDCard.getOldIDCard(temployee.getPersonid());
			new_IDCard = temployee.getPersonid();
		} else {
			new_IDCard = temployee.getPersonid();
			old_IDCard = temployee.getPersonid();
		}
		temployee.setPersonid(new_IDCard.toUpperCase());
		
		Temployee temployee2 = (Temployee)temployeejxyManager.getTemployeeById(temployee.getCpempcode(),temployee.getCpcode());
		String deptID = "";

		MyUserDetails userDetail = null;
		userDetail = SpringTagFunctions.getUserDetails();
		if (userDetail != null) {
			deptID = userDetail.getDeptID();
		}

		
			List  tempcyryList = temployeejxyManager.findCyryByIdcard(new_IDCard, old_IDCard);
			  if (tempcyryList.size() > 0) {
				  for(int i=0;i<tempcyryList.size();i++){
					 Temployee tempcyry=(Temployee) tempcyryList.get(i);
					 if(!tempcyry.getCpempcode().equals(temployee.getCpempcode())){
						 if(tempcyry.getCpcode().equals(deptID)){
							 request.setAttribute("message","从业人员身份证信息已存在！");
							  getProv();
							  return EDIT_JSP;////LIST_ACTION;
						 
						 }else if(tempcyry.getCyrjzt().equals("0")){
							 request.setAttribute("message","此身份证号码在其它企业已经注册为在职员工！");
							  getProv();
							  return EDIT_JSP;////LIST_ACTION;
						 }
					 }
					

				  }			  
			  }

		
		
//		Tempworklog tempworklog=tempworklogManager.getTemployeeByEmpcade(temployee.getCpempcode());
//		if(temployee.getCyrjzt().equals("1")){
//			java.text.SimpleDateFormat df = new java.text.SimpleDateFormat("yyyyMMdd");
//			String d=df.format(new Date());
//			tempworklog.setIndate(temployee.getIndate());
//			tempworklog.setLeftdate(d);
//			tempworklog.setStatus("1");
//			temployee.setLeftdate(d);
//			
//		}
//		else{
//			tempworklog.setIndate(temployee.getIndate());
//		}
		
		temployeejxyManager.update(this.temployee);
		
//		tempworklogManager.update(tempworklog);
		return returnUrl;////LIST_ACTION;
	}
	public String updatecyryzt(){
		
		return returnUrl;////LIST_ACTION;
	}
	
	/**删除对象*/
	public String delete() {
		for(int i = 0; i < items.length; i++) {
			Hashtable params = HttpUtils.parseQueryString(items[i]);
			java.lang.String id = new java.lang.String((String)params.get("cpempcode"));
			temployeejxyManager.removeById(id);
		}
		return returnUrl ;//LIST_ACTION;
	}
	public String fz(){
		HttpServletRequest request = ServletActionContext.getRequest();
		String empcode=request.getParameter("cpempcode");
		String cpcode=request.getParameter("cpcode");
		try {
			returnUrl=java.net.URLEncoder.encode(returnUrl, "UTF-8");
		} catch (UnsupportedEncodingException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		returnUrl="!/jxy/Temployee/list.do?"+returnUrl;
		if(temployee!=null){
			String new_IDCard = "";
			String old_IDCard = "";
			if (temployee != null && temployee.getPersonid() != null
					&& temployee.getPersonid().length() == 15) {
				new_IDCard = IDCard.getNewIDCard(temployee.getPersonid());
				old_IDCard = temployee.getPersonid();
			} else if (temployee != null && temployee.getPersonid() != null
					&& temployee.getPersonid().length() == 18) {
				old_IDCard = IDCard.getOldIDCard(temployee.getPersonid());
				new_IDCard = temployee.getPersonid();
			} else {
				new_IDCard = temployee.getPersonid();
				old_IDCard = temployee.getPersonid();
			}
			List  tempcyryList = temployeejxyManager.findCyryByIdcard(new_IDCard, old_IDCard);
			  if (tempcyryList.size() > 0) {
				  for(int i=0;i<tempcyryList.size();i++){
					 Temployee tempcyry=(Temployee) tempcyryList.get(i);
					  if(tempcyry.getCyrjzt().equals("0")){
						 String message="此身份证号码在其它企业已经注册为在职员工！";
						  getProv();
						 
						  try {
							  message=java.net.URLEncoder.encode(message, "UTF-8");
							  
						} catch (UnsupportedEncodingException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						returnUrl=returnUrl+"&message="+message;
						  return returnUrl;////LIST_ACTION;
					 }
				  }			  
			  }
			temployee.setCyrjzt("0");
			
			temployeejxyManager.update(temployee);
			
			String deptID = "";
			String deptName = "";
			MyUserDetails userDetail = null;
			userDetail = SpringTagFunctions.getUserDetails();
			if (userDetail != null) {
				deptID = userDetail.getDeptID();
				deptName = userDetail.getDeptName();
			}
			Date date = new Date();

			SimpleDateFormat logformat = new SimpleDateFormat("yyyyMMdd");
			String currDatelog = logformat.format(date);
			
			Tempworklog tempworklog = new Tempworklog();
			tempworklog.setCpcode(deptID);
			tempworklog.setCpname(deptName);
			tempworklog.setEmpcode(temployee.getCpempcode());
			tempworklog.setEmptype("02");
			tempworklog.setIndate(currDatelog);
			tempworklog.setPersonid(temployee.getPersonid());
			tempworklog.setStatus("0");
			tempworklogjxyManager.save(tempworklog);
		}

		
		return returnUrl;
	}
	
	
	/** 执行搜索 */
	public String listAll() {
		PageRequest<Map> pageRequest = newPageRequest(DEFAULT_SORT_COLUMNS);
		HttpServletRequest request = ServletActionContext.getRequest();
		//pageRequest.getFilters().put("key",value);     //add custom filter

		dateSelectMap  = DateUtil.getDateSelectData();
		String dateSelect3 = "";
		if (request.getParameter("dateSelect3") != null)
		    dateSelect3 = request.getParameter("dateSelect3");
			request.setAttribute("dateSelect3",dateSelect3);		        
		String s_birthBeginFormat = DateUtil.parseString(request,"s_birthBegin","yyyy-MM-dd","yyyyMMdd");
		String s_birthEndFormat = DateUtil.parseString(request,"s_birthEnd","yyyy-MM-dd","yyyyMMdd");
		pageRequest.getFilters().put("birthBeginFormat",s_birthBeginFormat);
		pageRequest.getFilters().put("birthEndFormat",s_birthEndFormat);
		String dateSelect20 = "";
		if (request.getParameter("dateSelect20") != null)
		    dateSelect20 = request.getParameter("dateSelect20");
			request.setAttribute("dateSelect20",dateSelect20);		        
		String dateSelect21 = "";
		if (request.getParameter("dateSelect21") != null)
		    dateSelect21 = request.getParameter("dateSelect21");
			request.setAttribute("dateSelect21",dateSelect21);		
			
			
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
		if (SpringTagFunctions.ifAnyGranted("ROLE_HT_ADMIN,ROLE_ADMIN")) {

		} else if (SpringTagFunctions.ifAnyGranted("ROLE_QUERY_CURRENT_ORG")) {
			pageRequest.getFilters().put("cpcode", deptid);
		} else if (SpringTagFunctions.ifAnyGranted("ROLE_QUERY_CHILD_ORG")) {
			pageRequest.getFilters().put("deptSeq", deptseq);
		} else {
			pageRequest.getFilters().put("cpcode", deptid);
		}
		String s_cpcode = "";
		if (request.getParameter("s_cpcode") != null) {
			s_cpcode = request.getParameter("s_cpcode");
			request.setAttribute("s_cpcode", s_cpcode);
			pageRequest.getFilters().put("deptSeq", s_cpcode);
		}
					
		
		Page page = temployeejxyManager.findByPageRequest(pageRequest);
		savePage(page,pageRequest);
		return LISTALL_JSP;
	}
	
	/** 查看对象*/
	public String showAll() {
		this.dateFormat();
		//this.getPhoto();
		
		return SHOWALL_JSP;
	}
	
	/** 进入新增页面*/
	public String createAll() {
		
		provMap = new TreeMap();
		List listprov = ssCommonManager.getProv();
		if (listprov != null && listprov.size() > 0) {
			for(int i=0;i<listprov.size();i++){
				Map results = (HashMap) listprov.get(i);
				String CODE = (String) results.get("CODE");
				String CALLED = (String) results.get("CALLED");
				provMap.put(CODE, CALLED);
				
			}
		}
		
		return CREATEALL_JSP;
	}
	
	/** 保存新增对象 */
	public String saveAll() {
		HttpServletRequest request = ServletActionContext.getRequest();
		Date date = new Date();
		SimpleDateFormat format = new SimpleDateFormat("yyyyMMddHHmmss");
		String currDate = format.format(date);
		
		SimpleDateFormat formatInsert = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String currDateInsert = formatInsert.format(date);
		temployee.setInserttimeString(currDateInsert);
		temployee.setEdittimeString(currDateInsert);
		
		this.setFormatDate();
		
		String deptID = "";
		if(request.getParameter("cpcode") != null)
			deptID = request.getParameter("cpcode");
		

		String new_IDCard = "";
		String old_IDCard = "";
		if (temployee != null && temployee.getPersonid() != null
				&& temployee.getPersonid().length() == 15) {
			new_IDCard = IDCard.getNewIDCard(temployee.getPersonid());
			old_IDCard = temployee.getPersonid();
		} else if (temployee != null && temployee.getPersonid() != null
				&& temployee.getPersonid().length() == 18) {
			old_IDCard = IDCard.getOldIDCard(temployee.getPersonid());
			new_IDCard = temployee.getPersonid();
		} else {
			new_IDCard = temployee.getPersonid();
			old_IDCard = temployee.getPersonid();
		}
		temployee.setPersonid(new_IDCard.toUpperCase());
		
		int   idcardcount = temployeejxyManager.getCountByIdcard(new_IDCard, old_IDCard);
		  if (idcardcount > 0) {
				request.setAttribute("message","从业人员身份证信息已存在！");
				getProv();
				return CREATE_JSP;////LIST_ACTION;
		  }
		  
		String empcode = deptID+currDate;
		temployee.setCpcode(deptID);
		temployee.setCpempcode(empcode);
		
		temployeejxyManager.save(temployee);
		System.out.println(file.length()+"------------------------");
		try {
			if (file != null) {
				if (file.length() < FilemaxSize) {
					int idCount = ssCommonManager.getPicIDIsExist(empcode);
					if (idCount > 0)
						ssCommonManager.updatePic(file, file.length(), empcode);
					else
						ssCommonManager.savePic(file, file.length(), empcode);
				}else{
					 request.setAttribute("message", "上传照片不能大于"+FilemaxSize/1024+"KB"); 
					return	UPDATEPHOTOFAILURE ;
				}
			}
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
		}
		
		return returnUrl;////LIST_ACTION;
	}
	
	/**进入更新页面*/
	public String editAll() {
		HttpServletRequest request = ServletActionContext.getRequest();
		this.dateFormat();

		
		provMap = new TreeMap();
		List listprov = ssCommonManager.getProv();
		if (listprov != null && listprov.size() > 0) {
			for(int i=0;i<listprov.size();i++){
				Map results = (HashMap) listprov.get(i);
				String CODE = (String) results.get("CODE");
				String CALLED = (String) results.get("CALLED");
				provMap.put(CODE, CALLED);
				
			}
		}
		
		if(temployee != null && temployee.getNpcode() != null && temployee.getNpcode().length() > 2){
			request.setAttribute("npcodehidden", temployee.getNpcode());
			request.setAttribute("npcodeprovhidden", temployee.getNpcode().substring(0, 2)+"0000");
		}
		if(temployee != null && temployee.getNativeplace() != null && temployee.getNativeplace().length() > 2){
			request.setAttribute("nativeplacehidden", temployee.getNativeplace());
			request.setAttribute("nativeplaceprovhidden", temployee.getNativeplace().substring(0, 2)+"0000");
		}
		

		//this.getPhoto();
		
		return EDITALL_JSP;
	}
	
	/**保存更新对象*/
	public String updateAll() {
		HttpServletRequest request = ServletActionContext.getRequest();
		this.setFormatDate();
		
		
		Date date = new Date();
		SimpleDateFormat formatInsert = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String currDateInsert = formatInsert.format(date);
		temployee.setEdittimeString(currDateInsert);
		
		String new_IDCard = "";
		String old_IDCard = "";
		if (temployee != null && temployee.getPersonid() != null
				&& temployee.getPersonid().length() == 15) {
			new_IDCard = IDCard.getNewIDCard(temployee.getPersonid());
			old_IDCard = temployee.getPersonid();
		} else if (temployee != null && temployee.getPersonid() != null
				&& temployee.getPersonid().length() == 18) {
			old_IDCard = IDCard.getOldIDCard(temployee.getPersonid());
			new_IDCard = temployee.getPersonid();
		} else {
			new_IDCard = temployee.getPersonid();
			old_IDCard = temployee.getPersonid();
		}
		temployee.setPersonid(new_IDCard.toUpperCase());
		
		Temployee temployee2 = (Temployee)temployeejxyManager.getTemployeeById(temployee.getCpempcode(),temployee.getCpcode());
		String deptID=null;
		MyUserDetails userDetail = null;
		userDetail = SpringTagFunctions.getUserDetails();
		if (userDetail != null) {
			deptID = userDetail.getDeptID();
		}
		int   idcardcount = temployeejxyManager.getCountByIdcard(new_IDCard, old_IDCard);
		  if (idcardcount > 0 && !temployee2.getPersonid().equals(temployee.getPersonid())) {
			  getProv();
				request.setAttribute("message","从业人员身份证信息已存在！");
				return EDITALL_JSP;////LIST_ACTION;
		  }
		
		temployeejxyManager.update(this.temployee);
		return returnUrl;////LIST_ACTION;
	}
	
	
	
	
	
	public String tab() {
		HttpServletRequest request = ServletActionContext.getRequest();
		this.dateFormat();
		//this.getPhoto();
		
		return TAB_JSP;
	}
	
	public String tabAll() {
		this.dateFormat();
		//this.getPhoto();
		
		return TABALL_JSP;
	}
	
	
	
	//显示图片
	public String showPic() {
		HttpServletRequest request = ServletActionContext.getRequest();
		String cpempcode = "";
		String cpcode="";
		if (request.getParameter("cpempcode") != null)
			cpempcode = request.getParameter("cpempcode");
		if (request.getParameter("cpcode") != null)
			cpcode = request.getParameter("cpcode");
		List list = (List) temployeejxyManager.getPic(cpempcode,cpcode);
		request.setAttribute("list", list); 
		return SHOW_PIC;
	}
	
	//修改图片
	public String updatePic() {
		HttpServletRequest request = ServletActionContext.getRequest();
		String cpempcode = "";
		if (request.getParameter("cpempcode") != null)
			cpempcode = request.getParameter("cpempcode");
		try {
			if (file != null && file.length() < FilemaxSize) {
				if (cpempcode != null && cpempcode.length() > 0) {
					temployeejxyManager.updatePic(file, cpempcode);
				}
			} else {
				request.setAttribute("message", "上传照片不能大于" + FilemaxSize / 1024
						+ "KB");
				return UPDATEPHOTOFAILURE;
			}
		} catch (IOException e) {
			request.setAttribute("message", "修改照片失败");
			return UPDATEPHOTOFAILURE;
		}
		return UPDATEPHOTOSUCCESS;
	}
	
	
	public String getFilmName() {
		return filmName;
	}

	public void setFilmName(String filmName) {
		this.filmName = filmName;
	}

	public String getFilmContent() {
		return filmContent;
	}

	public void setFilmContent(String filmContent) {
		this.filmContent = filmContent;
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

	public TreeMap<String, String> getProvMap() {
		return provMap;
	}

	public void setProvMap(TreeMap<String, String> provMap) {
		this.provMap = provMap;
	}
	public void dateFormat(){
		HttpServletRequest request = ServletActionContext.getRequest();
		String birth =  temployee.getBirth();
		String birthFormat = DateUtil.parseString(birth,"yyyyMMdd","yyyy-MM-dd");
		temployee.setBirth(birthFormat);
		String rzrq =  temployee.getIndate();
		String rzrqFormat = DateUtil.parseString(rzrq,"yyyyMMdd","yyyy-MM-dd");
		temployee.setIndate(rzrqFormat);
	}
	public void getPhoto(){
		HttpServletRequest request = ServletActionContext.getRequest();
		//显示照片
		int picCount = 0;
		if (temployee != null && temployee.getCpempcode() != null) {
			picCount = ssCommonManager.getPicIDIsExist(temployee.getCpempcode());
		}
		Integer obj = new Integer(picCount);
		request.setAttribute("picCount", obj.toString());
	}
	public void setFormatDate(){
		HttpServletRequest request = ServletActionContext.getRequest();
		String birthFormat = DateUtil.parseString(request,"birth","yyyy-MM-dd","yyyyMMdd");
		temployee.setBirth(birthFormat);

		String rzrqhFormat = DateUtil.parseString(request,"indate","yyyy-MM-dd","yyyyMMdd");
		temployee.setIndate(rzrqhFormat);
	}
	
	public void getProv() {
		
		provMap = new TreeMap();
		List listprov = ssCommonManager.getProv();
		if (listprov != null && listprov.size() > 0) {
			for(int i=0;i<listprov.size();i++){
				Map results = (HashMap) listprov.get(i);
				String CODE = (String) results.get("CODE");
				String CALLED = (String) results.get("CALLED");
				provMap.put(CODE, CALLED);
				
			}
		}
		
		
	}

	public java.lang.String getCpcode() {
		return cpcode;
	}

	public void setCpcode(java.lang.String cpcode) {
		this.cpcode = cpcode;
	}

}
