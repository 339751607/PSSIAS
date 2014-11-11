/*
 * Powered By [lishicheng]
 */

package com.dyneinfo.pmdd.action;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
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

import org.apache.commons.io.IOUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.struts2.ServletActionContext;
import org.security.userdetails.MyUserDetails;
import org.springframework.security.Authentication;
import org.springframework.security.context.SecurityContext;
import org.springframework.security.context.SecurityContextHolder;

import cn.org.rapid_framework.page.Page;
import cn.org.rapid_framework.page.PageRequest;
import cn.org.rapid_framework.web.util.HttpUtils;

import com.dyneinfo.zazh.service.SsCommonManager;
import com.dyneinfo.zazh.util.IDCard;
import com.dyneinfo.pmdd.model.Temployee;
import com.dyneinfo.pmdd.model.Tempworklog;
import com.dyneinfo.pmdd.service.PmdwxxbManager;
import com.dyneinfo.pmdd.service.TemployeepmddManager;
import com.dyneinfo.pmdd.service.TempworklogpmddManager;
import com.opensymphony.xwork2.ModelDriven;
import com.opensymphony.xwork2.Preparable;

/**
 * @author lisc email:lishicheng(a)gmail.com
 */


public class TemployeeAction extends BaseStruts2Action implements Preparable,ModelDriven{
	//默认多列排序,example: username desc,createTime asc
	protected static final String DEFAULT_SORT_COLUMNS = null; 
	
	//forward paths
	protected static final String QUERY_JSP = "/pages/pmdd/Temployee/query.jsp";
	protected static final String LIST_JSP= "/pages/pmdd/Temployee/list.jsp";
	protected static final String ZJLIST_JSP= "/pages/pmdd/Temployee/zjlist.jsp";
	protected static final String CREATE_JSP = "/pages/pmdd/Temployee/create.jsp";
	protected static final String ZJCREATE_JSP = "/pages/pmdd/Temployee/zjcreate.jsp";
	protected static final String EDIT_JSP = "/pages/pmdd/Temployee/edit.jsp";
	protected static final String SHOW_JSP = "/pages/pmdd/Temployee/show.jsp";
	protected static final String TAB_JSP = "/pages/pmdd/Temployee/tab.jsp";
	//redirect paths,startWith: !
	protected static final String LIST_ACTION = "!/pages/pmdd/Temployee/list.do";
	
	protected static final String SHOWALL_JSP = "/pages/pmdd/Temployee/showAll.jsp";
	protected static final String LISTALL_JSP= "/pages/pmdd/Temployee/listAll.jsp";
	protected static final String CREATEALL_JSP = "/pages/pmdd/Temployee/createAll.jsp";
	protected static final String EDITALL_JSP = "/pages/pmdd/Temployee/editAll.jsp";
	protected static final String SHOW_PIC = "/pages/pic/pic.jsp";
	protected static final String TABALL_JSP = "/pages/pmdd/Temployee/tabAll.jsp";
	protected static final String UPDATEPHOTOSUCCESS = "/pages/pic/uploadFileSuccess.jsp";
	protected static final String UPDATEPHOTOFAILURE= "/pages/pic/uploadFileFailure.jsp";
	protected static final String UPDATEPHOTOERROR="/pages/pic/updateFileError.jsp";
	
	protected static final String LIST_ZAZHSHOW="/pages/pmdd/Temployee/zazhshow.jsp";
	
	private TemployeepmddManager temployeeManager;
	private SsCommonManager ssCommonManager;
	private TempworklogpmddManager tempworklogManager;
	private PmdwxxbManager pmdwxxbManager;
	
	private Temployee temployee;
	java.lang.String id = null;
	private String[] items;
	private String returnUrl;  //返回列表，保留查询条件
	private TreeMap<String, String> dateSelectMap;// //日期选择
	TreeMap<String,String> provMap ;
	
	private String filmName;
	private String filmContent;
	private File file;
	private String fileFileName;
	private String fileContentType;
	private long FilemaxSize = 3*1024*1024; //照片字节

	
	

	public void prepare() throws Exception {
		if (isNullOrEmptyString(id)) {
			temployee = new Temployee();
		} else {
			temployee = (Temployee)temployeeManager.getTemployeeById(id);
		}
	}
	
	/** 增加setXXXX()方法,spring就可以通过autowire自动设置对象属性 */
	public void setTemployeepmddManager(TemployeepmddManager manager) {
		this.temployeeManager = manager;
	}	
	public void setSsCommonManager(SsCommonManager ssCommonManager) {
		this.ssCommonManager = ssCommonManager;
	}
	
	public void setTempworklogpmddManager(TempworklogpmddManager manager) {
		this.tempworklogManager = manager;
	}	
	public void setPmdwxxbManager(PmdwxxbManager manager) {
		this.pmdwxxbManager = manager;
	}	
	
	public Object getModel() {
		return temployee;
	}
	
	public void setEmpcode(java.lang.String val) {
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

	public String zazhshow(){
		HttpServletRequest request = ServletActionContext.getRequest();
		if(temployee == null){
		   temployee = new Temployee();
		}
		String birth =  temployee.getBirth();
		String birthFormat = DateUtil.parseString(birth,"yyyyMMdd","yyyy-MM-dd");
		temployee.setBirth(birthFormat);
		String rzrq =  temployee.getRzrq();
		String rzrqhFormat = DateUtil.parseString(rzrq,"yyyyMMdd","yyyy-MM-dd");
		temployee.setRzrq(rzrqhFormat);
		
		//显示照片
		int picCount = 0;
		if (temployee != null && temployee.getEmpcode() != null) {
			picCount = ssCommonManager.getPicIDIsExist(temployee.getEmpcode());
		}
		Integer obj = new Integer(picCount);
		request.setAttribute("picCount", obj.toString());
		return LIST_ZAZHSHOW;
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
		if(SpringTagFunctions.ifAnyGranted("ROLE_HT_ADMIN")){
			pageRequest.getFilters().put("deptSeq",deptseq);
		}
		
		dateSelectMap  = DateUtil.getDateSelectData();
	        
		String s_birthBeginFormat = DateUtil.parseString(request,"s_birthBegin","yyyy-MM-dd","yyyyMMdd");
		String s_birthEndFormat = DateUtil.parseString(request,"s_birthEnd","yyyy-MM-dd","yyyyMMdd");
		pageRequest.getFilters().put("birthBeginFormat",s_birthBeginFormat);
		pageRequest.getFilters().put("birthEndFormat",s_birthEndFormat);

		String dateSelect10 = "";
		if (request.getParameter("dateSelect10") != null)
		    dateSelect10 = request.getParameter("dateSelect10");
			request.setAttribute("dateSelect10",dateSelect10);		        
		String s_rzrqBeginFormat = DateUtil.parseString(request,"s_rzrqBegin","yyyy-MM-dd","yyyyMMdd");
		String s_rzrqEndFormat = DateUtil.parseString(request,"s_rzrqEnd","yyyy-MM-dd","yyyyMMdd");
		pageRequest.getFilters().put("rzrqBeginFormat",s_rzrqBeginFormat);
		pageRequest.getFilters().put("rzrqEndFormat",s_rzrqEndFormat);
		
		Page page = temployeeManager.findByPageRequest(pageRequest);
		request.setAttribute("deptid", deptid);
		savePage(page,pageRequest);
	
	    return LIST_JSP;
		
	}
	public String zjlist() {
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
		if(SpringTagFunctions.ifAnyGranted("ROLE_HT_ADMIN")){
			pageRequest.getFilters().put("deptSeq",deptseq);
		}
		
		dateSelectMap  = DateUtil.getDateSelectData();
	        
		String s_birthBeginFormat = DateUtil.parseString(request,"s_birthBegin","yyyy-MM-dd","yyyyMMdd");
		String s_birthEndFormat = DateUtil.parseString(request,"s_birthEnd","yyyy-MM-dd","yyyyMMdd");
		pageRequest.getFilters().put("birthBeginFormat",s_birthBeginFormat);
		pageRequest.getFilters().put("birthEndFormat",s_birthEndFormat);

		String dateSelect10 = "";
		if (request.getParameter("dateSelect10") != null)
		    dateSelect10 = request.getParameter("dateSelect10");
			request.setAttribute("dateSelect10",dateSelect10);		        
		String s_rzrqBeginFormat = DateUtil.parseString(request,"s_rzrqBegin","yyyy-MM-dd","yyyyMMdd");
		String s_rzrqEndFormat = DateUtil.parseString(request,"s_rzrqEnd","yyyy-MM-dd","yyyyMMdd");
		pageRequest.getFilters().put("rzrqBeginFormat",s_rzrqBeginFormat);
		pageRequest.getFilters().put("rzrqEndFormat",s_rzrqEndFormat);
		
		Page page = temployeeManager.findByPageRequest(pageRequest);
		request.setAttribute("deptid", deptid);
		savePage(page,pageRequest);

		return ZJLIST_JSP;

	}
	
	/** 查看对象*/
	public String show() {
		HttpServletRequest request = ServletActionContext.getRequest();
		String birth =  temployee.getBirth();
		String birthFormat = DateUtil.parseString(birth,"yyyyMMdd","yyyy-MM-dd");
		temployee.setBirth(birthFormat);
		
		String rzrq =  temployee.getRzrq();
		String rzrqhFormat = DateUtil.parseString(rzrq,"yyyyMMdd","yyyy-MM-dd");
		temployee.setRzrq(rzrqhFormat);
		
		//显示照片
		int picCount = 0;
		if (temployee != null && temployee.getEmpcode() != null) {
			picCount = ssCommonManager.getPicIDIsExist(temployee.getEmpcode());
		}
		Integer obj = new Integer(picCount);
		request.setAttribute("picCount", obj.toString());
		
		return SHOW_JSP;
	}
	
	/** 进入新增页面*/
	public String create() {
		HttpServletRequest request = ServletActionContext.getRequest();
		SecurityContext sc = SecurityContextHolder.getContext();
		Authentication auth = sc.getAuthentication();
		MyUserDetails ud = null;
	String deptid = "";
		
		if ((auth != null) && auth.getPrincipal() instanceof MyUserDetails) {
			ud = (MyUserDetails) auth.getPrincipal();
			if (ud != null) {
	
				deptid = ud.getDeptID();
				
			}
		}
		String smycode = pmdwxxbManager.getsmycode(deptid);
		String typecode = pmdwxxbManager.gettypecode(deptid);
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
public String zjcreate() {
	HttpServletRequest request = ServletActionContext.getRequest();
	SecurityContext sc = SecurityContextHolder.getContext();
	Authentication auth = sc.getAuthentication();
	MyUserDetails ud = null;
	String username = "";
	String deptid = "";
	String deptname = "";
	if ((auth != null) && auth.getPrincipal() instanceof MyUserDetails) {
		ud = (MyUserDetails) auth.getPrincipal();
		if (ud != null) {
			username = ud.getUserName();
			deptid = ud.getDeptID();
			deptname = ud.getDeptName();
		}
	}
		
		provMap = new TreeMap();
		List listprov = ssCommonManager.getProv();
		String smycode = pmdwxxbManager.getsmycode(deptid);
		String typecode = pmdwxxbManager.gettypecode(deptid);
		request.setAttribute("smycode", smycode);
		request.setAttribute("typecode", typecode);
		if (listprov != null && listprov.size() > 0) {
			for(int i=0;i<listprov.size();i++){
				Map results = (HashMap) listprov.get(i);
				String CODE = (String) results.get("CODE");
				String CALLED = (String) results.get("CALLED");
				provMap.put(CODE, CALLED);
				
			}
		}
		
		return ZJCREATE_JSP;
	}
	
	/** 保存新增对象 */
	public String save() {
		HttpServletRequest request = ServletActionContext.getRequest();
		Date date = new Date();
		SimpleDateFormat format = new SimpleDateFormat("yyyyMMddHHmmss");
		String currDate = format.format(date);
		
		SimpleDateFormat logformat = new SimpleDateFormat("yyyyMMdd");
		String currDatelog = logformat.format(date);
		
		SimpleDateFormat formatInsert = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String currDateInsert = formatInsert.format(date);
		temployee.setInserttimeString(currDateInsert);
		temployee.setEdittimeString(currDateInsert);
		
		String birthFormat = DateUtil.parseString(request,"birth","yyyy-MM-dd","yyyyMMdd");
		temployee.setBirth(birthFormat);
		
		String rzrqFormat = DateUtil.parseString(request,"rzrq","yyyy-MM-dd","yyyyMMdd");
		temployee.setRzrq(rzrqFormat);
		
		
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
		
		String deptID = "";
		String deptName = "";
		MyUserDetails userDetail = null;
		userDetail = SpringTagFunctions.getUserDetails();
		if (userDetail != null) {
			deptID = userDetail.getDeptID();
			deptName = userDetail.getDeptName();
		}
		if (file != null) {
			if (file.length() > FilemaxSize) {
				request.setAttribute("message", "上传照片不能大于"+FilemaxSize/1024/1024+"M"); 
				return	UPDATEPHOTOERROR ;
			}
		}
		
		//int idcardcount = temployeeManager.getCountByIdcard(new_IDCard, old_IDCard);
		List  tempcyryList = temployeeManager.findCyryByIdcard(new_IDCard, old_IDCard);
		  if (tempcyryList.size() > 0) {
			  for(int i=0;i<tempcyryList.size();i++){
				 Temployee tempcyry=(Temployee) tempcyryList.get(i);
				 if(tempcyry.getCpcode().equals(deptID)){
					 request.setAttribute("message","从业人员身份证信息已存在！");
					  getProv();
					  	String birth =  temployee.getBirth();
						String birth1Format = DateUtil.parseString(birth,"yyyyMMdd","yyyy-MM-dd");
						temployee.setBirth(birth1Format);
						String rzrq =  temployee.getRzrq();
						String rzrq1Format = DateUtil.parseString(rzrq,"yyyyMMdd","yyyy-MM-dd");
						temployee.setRzrq(rzrq1Format);
					  return CREATE_JSP;////LIST_ACTION;
				 }else if(tempcyry.getCyrjzt().equals("0")){
					 request.setAttribute("message","此身份证号码在其它企业已经注册为在职员工！");
					  getProv();
					  String birth =  temployee.getBirth();
						String birth1Format = DateUtil.parseString(birth,"yyyyMMdd","yyyy-MM-dd");
						temployee.setBirth(birth1Format);
						String rzrq =  temployee.getRzrq();
						String rzrq1Format = DateUtil.parseString(rzrq,"yyyyMMdd","yyyy-MM-dd");
						temployee.setRzrq(rzrq1Format);
					  return CREATE_JSP;////LIST_ACTION;
				 }
				  
			  }			  
		  }
		
		
		

		String empcode = deptID+currDate;
		temployee.setCpcode(deptID);
		temployee.setEmpcode(empcode);
		temployee.setCyrjzt("0");
		temployeeManager.save(temployee);
		
		
		Tempworklog tempworklog = new Tempworklog();
		tempworklog.setCpcode(deptID);
		tempworklog.setCpname(deptName);
		tempworklog.setEmpcode(temployee.getEmpcode());
		tempworklog.setEmptype("02");
		tempworklog.setIndate(temployee.getRzrq());
		tempworklog.setPersonid(new_IDCard.toUpperCase());
		tempworklog.setStatus("0");
		
		tempworklogManager.save(tempworklog);
		
		try {
		File uploadFile = null;
		InputStream uploadIs = null;
		byte[] uploadBytes= null;
		
		if(file != null && file.length() > 0 ){
			uploadFile = file;
			uploadIs = new FileInputStream(uploadFile);
		    uploadBytes =  (byte[])IOUtils.toByteArray(uploadIs);
		}
		
		String photoBuffer = "";
		if (request.getParameter("photoBuffer") != null)
			photoBuffer = request.getParameter("photoBuffer");
		if (StringUtils.isNotEmpty(photoBuffer)) {
			 uploadBytes = (byte[])net.java.dev.common.util.PicDecode.decode(photoBuffer);
		}
		
		
			int idCount = ssCommonManager.getPicIDIsExist(empcode);
			if (idCount > 0)
				ssCommonManager.updatePic(uploadBytes, uploadBytes.length, empcode);
			else
				ssCommonManager.savePic(uploadBytes, uploadBytes.length, empcode);
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
		}
		
		return returnUrl;////LIST_ACTION;
	}
	
	public String save_zj() {
		HttpServletRequest request = ServletActionContext.getRequest();
		Date date = new Date();
		SimpleDateFormat format = new SimpleDateFormat("yyyyMMddHHmmss");
		String currDate = format.format(date);
		
		SimpleDateFormat logformat = new SimpleDateFormat("yyyyMMdd");
		String currDatelog = logformat.format(date);
		
		SimpleDateFormat formatInsert = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String currDateInsert = formatInsert.format(date);
		temployee.setInserttimeString(currDateInsert);
		temployee.setEdittimeString(currDateInsert);
		
		String birthFormat = DateUtil.parseString(request,"birth","yyyy-MM-dd","yyyyMMdd");
		temployee.setBirth(birthFormat);
		
		String rzrqFormat = DateUtil.parseString(request,"rzrq","yyyy-MM-dd","yyyyMMdd");
		temployee.setRzrq(rzrqFormat);
		
		
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
		
		String deptID = "";
		String deptName = "";
		MyUserDetails userDetail = null;
		userDetail = SpringTagFunctions.getUserDetails();
		if (userDetail != null) {
			deptID = userDetail.getDeptID();
			deptName = userDetail.getDeptName();
		}
		if (file != null) {
			if (file.length() > FilemaxSize) {
				request.setAttribute("message", "上传照片不能大于"+FilemaxSize/1024/1024+"M"); 
				return	UPDATEPHOTOERROR ;
			}
		}
		
		//int idcardcount = temployeeManager.getCountByIdcard(new_IDCard, old_IDCard);
		List  tempcyryList = temployeeManager.findCyryByIdcard(new_IDCard, old_IDCard);
		  if (tempcyryList.size() > 0) {
			  for(int i=0;i<tempcyryList.size();i++){
				 Temployee tempcyry=(Temployee) tempcyryList.get(i);
				 if(tempcyry.getCpcode().equals(deptID)){
					 request.setAttribute("message","从业人员身份证信息已存在！");
					  getProv();
					  	String birth =  temployee.getBirth();
						String birth1Format = DateUtil.parseString(birth,"yyyyMMdd","yyyy-MM-dd");
						temployee.setBirth(birth1Format);
						String rzrq =  temployee.getRzrq();
						String rzrq1Format = DateUtil.parseString(rzrq,"yyyyMMdd","yyyy-MM-dd");
						temployee.setRzrq(rzrq1Format);
					  return ZJCREATE_JSP;////LIST_ACTION;
				 }else if(tempcyry.getCyrjzt().equals("0")){
//					 request.setAttribute("message","此身份证号码在其它企业已经注册为在职员工！");
//					  getProv();
//					  String birth =  temployee.getBirth();
//						String birth1Format = DateUtil.parseString(birth,"yyyyMMdd","yyyy-MM-dd");
//						temployee.setBirth(birth1Format);
//						String rzrq =  temployee.getRzrq();
//						String rzrq1Format = DateUtil.parseString(rzrq,"yyyyMMdd","yyyy-MM-dd");
//						temployee.setRzrq(rzrq1Format);
//					  return CREATE_JSP;////LIST_ACTION;
					 	System.out.println(tempcyryList);
					 	Temployee temp=(Temployee)tempcyryList.get(i);
					 	if(temp.getCyrjzt().equals("0")){
					 		temp.setCyrjzt("2");
					 		temployeeManager.update(temp);
					 	}
						request.setAttribute("message","已强制注销");
						String empcode = deptID+currDate;
						temployee.setCpcode(deptID);
						temployee.setEmpcode(empcode);
						temployee.setCyrjzt("0");
						temployeeManager.save(temployee);
						
						
						Tempworklog tempworklog = new Tempworklog();
						tempworklog.setCpcode(deptID);
						tempworklog.setCpname(deptName);
						tempworklog.setEmpcode(temployee.getEmpcode());
						tempworklog.setEmptype("02");
						tempworklog.setIndate(temployee.getRzrq());
						tempworklog.setPersonid(new_IDCard.toUpperCase());
						tempworklog.setStatus("0");
						
						tempworklogManager.save(tempworklog);
						
						try {
						File uploadFile = null;
						InputStream uploadIs = null;
						byte[] uploadBytes= null;
						
						if(file != null && file.length() > 0 ){
							uploadFile = file;
							uploadIs = new FileInputStream(uploadFile);
						    uploadBytes =  (byte[])IOUtils.toByteArray(uploadIs);
						}
						
						String photoBuffer = "";
						if (request.getParameter("photoBuffer") != null)
							photoBuffer = request.getParameter("photoBuffer");
						if (StringUtils.isNotEmpty(photoBuffer)) {
							 uploadBytes = (byte[])net.java.dev.common.util.PicDecode.decode(photoBuffer);
						}
						
						
							int idCount = ssCommonManager.getPicIDIsExist(empcode);
							if (idCount > 0)
								ssCommonManager.updatePic(uploadBytes, uploadBytes.length, empcode);
							else
								ssCommonManager.savePic(uploadBytes, uploadBytes.length, empcode);
						} catch (Exception ex) {
							System.out.println(ex.getMessage());
						}
						
						return returnUrl;////LIST_ACTION;
				 }
				  
			  }			  
		  }
		
		
		

		String empcode = deptID+currDate;
		temployee.setCpcode(deptID);
		temployee.setEmpcode(empcode);
		temployee.setCyrjzt("0");
		temployeeManager.save(temployee);
		
		
		Tempworklog tempworklog = new Tempworklog();
		tempworklog.setCpcode(deptID);
		tempworklog.setCpname(deptName);
		tempworklog.setEmpcode(temployee.getEmpcode());
		tempworklog.setEmptype("02");
		tempworklog.setIndate(temployee.getRzrq());
		tempworklog.setPersonid(new_IDCard.toUpperCase());
		tempworklog.setStatus("0");
		
		tempworklogManager.save(tempworklog);
		
		try {
		File uploadFile = null;
		InputStream uploadIs = null;
		byte[] uploadBytes= null;
		
		if(file != null && file.length() > 0 ){
			uploadFile = file;
			uploadIs = new FileInputStream(uploadFile);
		    uploadBytes =  (byte[])IOUtils.toByteArray(uploadIs);
		}
		
		String photoBuffer = "";
		if (request.getParameter("photoBuffer") != null)
			photoBuffer = request.getParameter("photoBuffer");
		if (StringUtils.isNotEmpty(photoBuffer)) {
			 uploadBytes = (byte[])net.java.dev.common.util.PicDecode.decode(photoBuffer);
		}
		
		
			int idCount = ssCommonManager.getPicIDIsExist(empcode);
			if (idCount > 0)
				ssCommonManager.updatePic(uploadBytes, uploadBytes.length, empcode);
			else
				ssCommonManager.savePic(uploadBytes, uploadBytes.length, empcode);
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
		}
		
		return returnUrl;////LIST_ACTION;
	}
	
	/**进入更新页面*/
	public String edit() {
		HttpServletRequest request = ServletActionContext.getRequest();
		String birth =  temployee.getBirth();
		String birthFormat = DateUtil.parseString(birth,"yyyyMMdd","yyyy-MM-dd");
		temployee.setBirth(birthFormat);
		String rzrq =  temployee.getRzrq();
		String rzrqFormat = DateUtil.parseString(rzrq,"yyyyMMdd","yyyy-MM-dd");
		temployee.setRzrq(rzrqFormat);
		
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
		
		//显示照片
		int picCount = 0;
		if (temployee != null && temployee.getEmpcode() != null) {
			picCount = ssCommonManager.getPicIDIsExist(temployee.getEmpcode());
		}
		Integer obj = new Integer(picCount);
		request.setAttribute("picCount", obj.toString());
		
		String sffz=request.getParameter("sffz");
		return EDIT_JSP;
	}
	
	/**保存更新对象*/
	public String update() {
		HttpServletRequest request = ServletActionContext.getRequest();
		String birthFormat = DateUtil.parseString(request,"birth","yyyy-MM-dd","yyyyMMdd");
		temployee.setBirth(birthFormat);
		String rzrqFormat = DateUtil.parseString(request,"rzrq","yyyy-MM-dd","yyyyMMdd");
		temployee.setRzrq(rzrqFormat);
		
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
		
		Temployee temployee2 = (Temployee)temployeeManager.getTemployeeById(temployee.getEmpcode());
		String deptID = "";

		MyUserDetails userDetail = null;
		userDetail = SpringTagFunctions.getUserDetails();
		if (userDetail != null) {
			deptID = userDetail.getDeptID();
		}
		//显示照片
		int picCount = 0;
		if (temployee != null && temployee.getEmpcode() != null) {
			picCount = ssCommonManager.getPicIDIsExist(temployee.getEmpcode());
		}
		Integer obj = new Integer(picCount);
		request.setAttribute("picCount", obj.toString());
		
			List  tempcyryList = temployeeManager.findCyryByIdcard(new_IDCard, old_IDCard);
			  if (tempcyryList.size() > 0) {
				  for(int i=0;i<tempcyryList.size();i++){
					 Temployee tempcyry=(Temployee) tempcyryList.get(i);
					 if(!tempcyry.getEmpcode().equals(temployee.getEmpcode())){
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

		temployeeManager.update(this.temployee);
		
		Tempworklog tempworklog=tempworklogManager.getTemployeeByEmpcade(temployee.getEmpcode());
		if(temployee.getCyrjzt().equals("1")){
			java.text.SimpleDateFormat df = new java.text.SimpleDateFormat("yyyyMMdd");
			String d=df.format(new Date());
			tempworklog.setIndate(temployee.getRzrq());
			tempworklog.setLeftdate(d);
			tempworklog.setStatus("1");
			
		}else{
			tempworklog.setIndate(temployee.getRzrq());
		}
		tempworklogManager.update(tempworklog);
		return returnUrl;////LIST_ACTION;
	}
	public String updatecyryzt(){
		
		return returnUrl;////LIST_ACTION;
	}
	
	/**删除对象*/
	public String delete() {
		for(int i = 0; i < items.length; i++) {
			Hashtable params = HttpUtils.parseQueryString(items[i]);
			java.lang.String id = new java.lang.String((String)params.get("empcode"));
			temployeeManager.removeById(id);
		}
		return returnUrl ;//LIST_ACTION;
	}
	public String fz(){
		HttpServletRequest request = ServletActionContext.getRequest();
		String empcode=request.getParameter("empcode");
		try {
			returnUrl=java.net.URLEncoder.encode(returnUrl, "UTF-8");
		} catch (UnsupportedEncodingException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		returnUrl="!/pages/Temployee/list.do?"+returnUrl;
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
			List  tempcyryList = temployeeManager.findCyryByIdcard(new_IDCard, old_IDCard);
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
			
			temployeeManager.update(temployee);
			
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
			tempworklog.setEmpcode(temployee.getEmpcode());
			tempworklog.setEmptype("02");
			tempworklog.setIndate(currDatelog);
			tempworklog.setPersonid(temployee.getPersonid());
			tempworklog.setStatus("0");
			tempworklogManager.save(tempworklog);
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
					
		
		Page page = temployeeManager.findByPageRequest(pageRequest);
		savePage(page,pageRequest);
		return LISTALL_JSP;
	}
	
	/** 查看对象*/
	public String showAll() {
		HttpServletRequest request = ServletActionContext.getRequest();
		String birth =  temployee.getBirth();
		String birthFormat = DateUtil.parseString(birth,"yyyyMMdd","yyyy-MM-dd");
		temployee.setBirth(birthFormat);
		String rzrq =  temployee.getRzrq();
		String rzrqFormat = DateUtil.parseString(rzrq,"yyyyMMdd","yyyy-MM-dd");
		temployee.setRzrq(rzrqFormat);
		
		//显示照片
		int picCount = 0;
		if (temployee != null && temployee.getEmpcode() != null) {
			picCount = ssCommonManager.getPicIDIsExist(temployee.getEmpcode());
		}
		Integer obj = new Integer(picCount);
		request.setAttribute("picCount", obj.toString());
		
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
		
		String birthFormat = DateUtil.parseString(request,"birth","yyyy-MM-dd","yyyyMMdd");
		temployee.setBirth(birthFormat);
		
		String rzrqFormat = DateUtil.parseString(request,"rzrq","yyyy-MM-dd","yyyyMMdd");
		temployee.setRzrq(rzrqFormat);
		
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
		
		int   idcardcount = temployeeManager.getCountByIdcard(new_IDCard, old_IDCard);
		  if (idcardcount > 0) {
				request.setAttribute("message","从业人员身份证信息已存在！");
				getProv();
				return CREATE_JSP;////LIST_ACTION;
		  }
		  
		String empcode = deptID+currDate;
		temployee.setCpcode(deptID);
		temployee.setEmpcode(empcode);
		
		temployeeManager.save(temployee);
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
					 request.setAttribute("message", "上传照片不能大于"+FilemaxSize/1024/1024+"M"); 
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
		String birth =  temployee.getBirth();
		String birthFormat = DateUtil.parseString(birth,"yyyyMMdd","yyyy-MM-dd");
		temployee.setBirth(birthFormat);
		String rzrq =  temployee.getRzrq();
		String rzrqhFormat = DateUtil.parseString(rzrq,"yyyyMMdd","yyyy-MM-dd");
		temployee.setRzrq(rzrqhFormat);
		
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
		
		//显示照片
		int picCount = 0;
		if (temployee != null && temployee.getEmpcode() != null) {
			picCount = ssCommonManager.getPicIDIsExist(temployee.getEmpcode());
		}
		Integer obj = new Integer(picCount);
		request.setAttribute("picCount", obj.toString());
		
		return EDITALL_JSP;
	}
	
	/**保存更新对象*/
	public String updateAll() {
		HttpServletRequest request = ServletActionContext.getRequest();
		String birthFormat = DateUtil.parseString(request,"birth","yyyy-MM-dd","yyyyMMdd");
		temployee.setBirth(birthFormat);

		String rzrqhFormat = DateUtil.parseString(request,"rzrq","yyyy-MM-dd","yyyyMMdd");
		temployee.setRzrq(rzrqhFormat);
		
		
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
		
		Temployee temployee2 = (Temployee)temployeeManager.getTemployeeById(temployee.getEmpcode());
		String deptID=null;
		MyUserDetails userDetail = null;
		userDetail = SpringTagFunctions.getUserDetails();
		if (userDetail != null) {
			deptID = userDetail.getDeptID();
		}
		int   idcardcount = temployeeManager.getCountByIdcard(new_IDCard, old_IDCard);
		  if (idcardcount > 0 && !temployee2.getPersonid().equals(temployee.getPersonid())) {
			  getProv();
				request.setAttribute("message","从业人员身份证信息已存在！");
				return EDITALL_JSP;////LIST_ACTION;
		  }
		
		temployeeManager.update(this.temployee);
		return returnUrl;////LIST_ACTION;
	}
	
	
	
	
	
	public String tab() {
		HttpServletRequest request = ServletActionContext.getRequest();
		String birth =  temployee.getBirth();
		String birthFormat = DateUtil.parseString(birth,"yyyyMMdd","yyyy-MM-dd");
		temployee.setBirth(birthFormat);
		String rzrq =  temployee.getRzrq();
		String rzrqhFormat = DateUtil.parseString(rzrq,"yyyyMMdd","yyyy-MM-dd");
		temployee.setRzrq(rzrqhFormat);
		
		//显示照片
		int picCount = 0;
		if (temployee != null && temployee.getEmpcode() != null) {
			picCount = ssCommonManager.getPicIDIsExist(temployee.getEmpcode());
		}
		Integer obj = new Integer(picCount);
		request.setAttribute("picCount", obj.toString());
		
		return TAB_JSP;
	}
	
	public String tabAll() {
		HttpServletRequest request = ServletActionContext.getRequest();
		String birth =  temployee.getBirth();
		String birthFormat = DateUtil.parseString(birth,"yyyyMMdd","yyyy-MM-dd");
		temployee.setBirth(birthFormat);
		String rzrq =  temployee.getRzrq();
		String rzrqhFormat = DateUtil.parseString(rzrq,"yyyyMMdd","yyyy-MM-dd");
		temployee.setRzrq(rzrqhFormat);
		//显示照片
		int picCount = 0;
		if (temployee != null && temployee.getEmpcode() != null) {
			picCount = ssCommonManager.getPicIDIsExist(temployee.getEmpcode());
		}
		Integer obj = new Integer(picCount);
		request.setAttribute("picCount", obj.toString());
		
		return TABALL_JSP;
	}
	
	
	
	//显示图片
	public String showPic() {
		HttpServletRequest request = ServletActionContext.getRequest();
		String xh = "";
		if (request.getParameter("xh") != null)
			xh = request.getParameter("xh");
		List list = (List) ssCommonManager.getPic(xh);
		request.setAttribute("list", list);   
		return SHOW_PIC;
	}
	
	//修改图片
	public String updatePic() {
		HttpServletRequest request = ServletActionContext.getRequest();
		String xh = "";
		if (request.getParameter("xh") != null)
			xh = request.getParameter("xh");
		try {
			if (file != null && file.length() < FilemaxSize) {
				System.out.println(file.length()+"------------------------");
				if (xh != null && xh.length() > 0) {
					int idCount = ssCommonManager.getPicIDIsExist(xh);
					if (idCount > 0)
						ssCommonManager.updatePic(file, file.length(), xh);
					else
						ssCommonManager.savePic(file, file.length(), xh);
				}
			}
			else{
				 request.setAttribute("message", "上传照片不能大于"+FilemaxSize/1024/1024+"M"); 
				return	UPDATEPHOTOFAILURE ;
			}
		} catch (IOException e) {
			 request.setAttribute("message", "修改照片失败"); 
			return	UPDATEPHOTOFAILURE ;
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

}
