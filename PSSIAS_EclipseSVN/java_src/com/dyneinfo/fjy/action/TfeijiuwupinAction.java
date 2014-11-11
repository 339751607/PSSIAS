/*
 * Powered By [lishicheng]
 */

package com.dyneinfo.fjy.action;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import javacommon.base.BaseStruts2Action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.java.dev.common.dict.taglib.DictHelpImpl;
import net.java.dev.common.dict.taglib.Util;
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

import com.dyneinfo.fjy.model.Tcsrxx;
import com.dyneinfo.fjy.model.Tfeijiuwupin;
import com.dyneinfo.fjy.service.TcpinfoManager;
import com.dyneinfo.fjy.service.TcsrxxManager;
import com.dyneinfo.fjy.service.TemployeeManager;
import com.dyneinfo.fjy.service.TfeijiuwupinManager;
import com.dyneinfo.zazh.model.FileAttach;
import com.dyneinfo.zazh.service.FileAttachManager;
import com.dyneinfo.zazh.service.SsCommonManager;
import com.dyneinfo.zazh.util.Encry;
import com.opensymphony.xwork2.ModelDriven;
import com.opensymphony.xwork2.Preparable;

/**
 * @author lisc email:lishicheng(a)gmail.com
 */

public class TfeijiuwupinAction extends BaseStruts2Action implements
		Preparable, ModelDriven {
	//默认多列排序,example: username desc,createTime asc
	protected static final String DEFAULT_SORT_COLUMNS = null;

	//forward paths
	protected static final String QUERY_JSP = "/pages/fjy/Tfeijiuwupin/query.jsp";
	protected static final String LIST_JSP = "/pages/fjy/Tfeijiuwupin/list.jsp";
	protected static final String QUERYLIST_JSP = "/pages/fjy/Tfeijiuwupin/queryList.jsp";
	
	protected static final String CREATE_JSP = "/pages/fjy/Tfeijiuwupin/create.jsp";
	protected static final String EDIT_JSP = "/pages/fjy/Tfeijiuwupin/edit.jsp";
	protected static final String SHOW_JSP = "/pages/fjy/Tfeijiuwupin/show.jsp";
	protected static final String QUERYSHOW_JSP = "/pages/fjy/Tfeijiuwupin/queryshow.jsp";
	protected static final String ZAZHSHOW_JSP = "/pages/fjy/Tfeijiuwupin/zazhShow.jsp";
	
	protected static final String TAB_JSP = "/pages/fjy/Tfeijiuwupin/tab.jsp";
	//redirect paths,startWith: !
	protected static final String LIST_ACTION = "!/pages/fjy/Tfeijiuwupin/list.do";
	protected static final String SHOW_PIC = "/pages/fjy/FileAttach/showPict.jsp";
	protected static final String QUWEYSHOW_PIC = "/pages/fjy/pic/pic.jsp";
	protected static final String SHOWALL_JSP = "/pages/fjy/Tfeijiuwupin/showAll.jsp";
	protected static final String TABALL_JSP = "/pages/fjy/Tfeijiuwupin/tabAll.jsp";
	protected static final String LISTALL_JSP = "/pages/fjy/Tfeijiuwupin/listAll.jsp";
	protected static final String UPDATEPHOTOSUCCESS = "/pages/fjy/pic/uploadFileSuccess.jsp";
	protected static final String UPDATEPHOTOFAILURE = "/pages/fjy/pic/uploadFileFailure.jsp";
	protected static final String UPDATEPHOTOERROR = "/pages/fjy/pic/updateFileError.jsp";


	private TfeijiuwupinManager tfeijiuwupinManager;
	private TcsrxxManager tcsrxxManager;
	private FileAttachManager fileAttachManager;
	private SsCommonManager ssCommonManager;
	private TcpinfoManager tcpinfoManager;
	private TemployeeManager temployeeManager;
	
	
	
	

	public void setTcpinfoManager(TcpinfoManager tcpinfoManager) {
		this.tcpinfoManager = tcpinfoManager;
	}

	private FileAttach fileAttach;
	private Tfeijiuwupin tfeijiuwupin;

	java.lang.String id = null;
	private String[] items;
	private String returnUrl; //返回列表，保留查询条件
	private String deleteReturnUrl;
	private TreeMap<String, String> dateSelectMap;// //日期选择

	private long maxSize = 5 * 1024 * 1024; //字节
	
	private String mgs;
	TreeMap<String,String> jbrMap ;

	TreeMap<String,String> provMap ;
	//照片上传 start
	private List<File> uploads = new ArrayList<File>();
	private List<String> uploadFileNames = new ArrayList<String>();
	private List<String> uploadContentTypes = new ArrayList<String>();
	private List<File> pics = new ArrayList<File>();
	private List<String> picFileNames = new ArrayList<String>();
	private List<String> picContentTypes = new ArrayList<String>();
	
	private int uplodsSize = 100 * 1024;
	private int affixsSize = 5 * 1024 * 1024;

	public List<File> getUpload() {
		return this.uploads;
	}

	public void setUpload(List<File> uploads) {
		this.uploads = uploads;
	}

	public List<String> getUploadFileName() {
		return this.uploadFileNames;
	}

	public void setUploadFileName(List<String> uploadFileNames) {
		this.uploadFileNames = uploadFileNames;
	}

	public List<String> getUploadContentType() {
		return this.uploadContentTypes;
	}

	public void setUploadContentType(List<String> contentTypes) {
		this.uploadContentTypes = contentTypes;
	}

	//照片上传 end

	//附件
	private List<File> affixs = new ArrayList<File>();
	private List<String> affixFileNames = new ArrayList<String>();
	private List<String> affixContentTypes = new ArrayList<String>();

	public List<File> getAffix() {
		return this.affixs;
	}

	public void setAffix(List<File> affixs) {
		this.affixs = affixs;
	}

	public List<String> getAffixFileName() {
		return this.affixFileNames;
	}

	public void setAffixFileName(List<String> affixFileNames) {
		this.affixFileNames = affixFileNames;
	}

	public List<String> getAffixContentType() {
		return this.affixContentTypes;
	}

	public void setAffixContentType(List<String> contentTypes) {
		this.affixContentTypes = contentTypes;
	}

	//附件 end
	
	
	public List<File> getPic() {
		return this.pics;
	}

	public void setPic(List<File> pics) {
		this.pics = pics;
	}

	public List<String> getPicFileName() {
		return this.picFileNames;
	}

	public void setPicFileName(List<String> picFileNames) {
		this.picFileNames = picFileNames;
	}

	public List<String> getPicContentType() {
		return this.picContentTypes;
	}

	public void setPicContentType(List<String> picContentTypes) {
		this.picContentTypes = picContentTypes;
	}

	public void prepare() throws Exception {
		if (isNullOrEmptyString(id)) {
			tfeijiuwupin = new Tfeijiuwupin();
			
		} else {
			tfeijiuwupin = (Tfeijiuwupin) tfeijiuwupinManager.getById(id);
		}

	}

	/** 增加setXXXX()方法,spring就可以通过autowire自动设置对象属性 */
	public void setTfeijiuwupinManager(TfeijiuwupinManager manager) {
		this.tfeijiuwupinManager = manager;
	}

	public void setFileAttachManager(FileAttachManager manager) {
		this.fileAttachManager = manager;
	}

	public void setSsCommonManager(SsCommonManager ssCommonManager) {
		this.ssCommonManager = ssCommonManager;
	}
	public Object getModel() {
		return tfeijiuwupin;
	}

	public void setWupinxh(java.lang.String val) {
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
		HttpServletRequest request = ServletActionContext.getRequest();
		String session_deptid = "";
		SecurityContext sc = SecurityContextHolder.getContext();
		Authentication auth = sc.getAuthentication();
		MyUserDetails ud = null;
		if ((auth != null) && auth.getPrincipal() instanceof MyUserDetails) {
			ud = (MyUserDetails) auth.getPrincipal();
			if (ud != null) {
				session_deptid = ud.getDeptID();
				request.setAttribute("deptseq", ud.getDeptSeq());
				request.setAttribute("deptname",ud.getDeptName());
				request.setAttribute("deptid", session_deptid);
			}
		}
		//日历快速选择用到
		dateSelectMap = DateUtil.getDateSelectData();
		String dateSelect2 = "";
		if (request.getParameter("dateSelect2") != null)
			dateSelect2 = request.getParameter("dateSelect2");
		return QUERY_JSP;
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

		
		dateSelectMap = DateUtil.getDateSelectData();
		String dateSelect2 = "";
		if (request.getParameter("dateSelect2") != null)
			dateSelect2 = request.getParameter("dateSelect2");
		request.setAttribute("dateSelect2", dateSelect2);
		String s_shougourqBeginFormat = DateUtil.parseString(request,
				"s_shougourqBegin", "yyyy-MM-dd HH:mm", "yyyyMMddHHmmss");
		String s_shougourqEndFormat = DateUtil.parseString(request,
				"s_shougourqEnd", "yyyy-MM-dd HH:mm", "yyyyMMddHHmmss");
		if(s_shougourqBeginFormat != null && s_shougourqBeginFormat.length() > 0 )
		pageRequest.getFilters().put("shougourqBeginFormat",s_shougourqBeginFormat);
		if(s_shougourqEndFormat != null && s_shougourqEndFormat.length() > 0 )
		pageRequest.getFilters().put("shougourqEndFormat", s_shougourqEndFormat);

		Page page = tfeijiuwupinManager.findByPageRequest(pageRequest, deptseq);
		savePage(page, pageRequest);
		return LIST_JSP;
	}
	public String queryList(){

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
		
		if (SpringTagFunctions.ifAnyGranted("ROLE_QUERY_ALL,ROLE_ADMIN")) {

		} else if (SpringTagFunctions.ifAnyGranted("ROLE_QUERY_CURRENT_ORG")) {
			pageRequest.getFilters().put("cpcode", deptid);
		} else if (SpringTagFunctions.ifAnyGranted("ROLE_QUERY_CHILD_ORG")) {
			pageRequest.getFilters().put("orgseq", deptseq);
		} else {
			pageRequest.getFilters().put("orgseq", deptseq);
		}
		
		String s_deptSeq = request.getParameter("s_deptSeq") != null ? request.getParameter("s_deptSeq") : "";
	
		String s_nativeplace = request.getParameter("s_nativeplace") != null ? request.getParameter("s_nativeplace") : "";
		pageRequest.getFilters().put("npcode", s_nativeplace);
		
		
		
		

		
		
		dateSelectMap = DateUtil.getDateSelectData();
		String dateSelect2 = "";
		if (request.getParameter("dateSelect2") != null)
			dateSelect2 = request.getParameter("dateSelect2");
		request.setAttribute("dateSelect2", dateSelect2);
		String s_shougourqBeginFormat = DateUtil.parseString(request,
				"s_shougourqBegin", "yyyy-MM-dd HH:mm", "yyyyMMddHHmmss");
		String s_shougourqEndFormat = DateUtil.parseString(request,
				"s_shougourqEnd", "yyyy-MM-dd HH:mm", "yyyyMMddHHmmss");
		if(s_shougourqBeginFormat != null && s_shougourqBeginFormat.length() > 0 )
		pageRequest.getFilters().put("shougourqBeginFormat",s_shougourqBeginFormat);
		if(s_shougourqEndFormat != null && s_shougourqEndFormat.length() > 0 )
		pageRequest.getFilters().put("shougourqEndFormat", s_shougourqEndFormat);

		Page page = tfeijiuwupinManager.findByPageRequest(pageRequest, s_deptSeq);
		savePage(page, pageRequest);
		if(request.getParameter("fh")!=null)return "/pages/fjy/Tfeijiuwupin/staList.jsp";
		return QUERYLIST_JSP;
	
	}

	/** 查看对象*/
	public String show() {

		HttpServletRequest request = ServletActionContext.getRequest();
		String shougourq = tfeijiuwupin.getShougourq();
		
		String shougourqFormat = DateUtil.parseString(shougourq, "yyyyMMddHHmmss",
				"yyyy-MM-dd HH:mm");
		tfeijiuwupin.setShougourq(shougourqFormat);

		
		//显示照片
		String picCount=null;
		if (tfeijiuwupin != null && tfeijiuwupin.getChushourensfzh() != null) {
			List list = tfeijiuwupinManager.getPicIDIsExist(tfeijiuwupin.getChushourensfzh());
			if(!list.isEmpty()){
				picCount="1";
			}
		}
		String ddryzpCount=null;
		if (tfeijiuwupin != null && tfeijiuwupin.getChushourensfzh() != null) {
			List list = tfeijiuwupinManager.getPicddryzp(tfeijiuwupin.getWupinxh());
			if(!list.isEmpty()){
				ddryzpCount="1";
			}
		}
		String dwzpCount=null;
		if (tfeijiuwupin != null && tfeijiuwupin.getChushourensfzh() != null) {
			List list = tfeijiuwupinManager.getPicdwzp(tfeijiuwupin.getWupinxh());
			if(!list.isEmpty()){
				dwzpCount="1";
			}
		}
		String ddrysmzpCount=null;
		if (tfeijiuwupin != null && tfeijiuwupin.getChushourensfzh() != null) {
			List list = tfeijiuwupinManager.getPicddrysmzp(tfeijiuwupin.getWupinxh());
			if(!list.isEmpty()){
				ddrysmzpCount="1";
			}
		}
		request.setAttribute("picCount", picCount);
		request.setAttribute("ddryzpCount", ddryzpCount);
		request.setAttribute("dwzpCount", dwzpCount);
		request.setAttribute("ddrysmzpCount", ddrysmzpCount);
		
		String sgrq=request.getParameter("sgrq")!=null?request.getParameter("sgrq"):"";
		String sfzh=request.getParameter("sfzh")!=null?request.getParameter("sfzh"):"";
		if(!sgrq.equals("")){
			tfeijiuwupin=tfeijiuwupinManager.getByrq(sgrq,sfzh);
			return "/pages/fjy/Tfeijiuwupin/allShow.jsp";
		}

		if(request.getParameter("fh")!=null)return "/pages/fjy/Tfeijiuwupin/staShow.jsp";

		return SHOW_JSP;
	}	
	/** 查看对象*/
	public String queryshow() {
		HttpServletRequest request = ServletActionContext.getRequest();
		String shougourq = tfeijiuwupin.getShougourq();
		
		String shougourqFormat = DateUtil.parseString(shougourq, "yyyyMMddHHmmss",
				"yyyy-MM-dd HH:mm:ss");
		tfeijiuwupin.setShougourq(shougourqFormat);

		//显示照片
		String picCount=null;
		if (tfeijiuwupin != null && tfeijiuwupin.getChushourensfzh() != null) {
			List list = tfeijiuwupinManager.getPicIDIsExist(tfeijiuwupin.getChushourensfzh());
			if(!list.isEmpty()){
				picCount="1";
			}
		}
		String ddryzpCount=null;
		if (tfeijiuwupin != null && tfeijiuwupin.getChushourensfzh() != null) {
			List list = tfeijiuwupinManager.getPicddryzp(tfeijiuwupin.getWupinxh());
			if(!list.isEmpty()){
				ddryzpCount="1";
			}
		}
		String dwzpCount=null;
		if (tfeijiuwupin != null && tfeijiuwupin.getChushourensfzh() != null) {
			List list = tfeijiuwupinManager.getPicdwzp(tfeijiuwupin.getWupinxh());
			if(!list.isEmpty()){
				dwzpCount="1";
			}
		}
		String ddrysmzpCount=null;
		if (tfeijiuwupin != null && tfeijiuwupin.getChushourensfzh() != null) {
			List list = tfeijiuwupinManager.getPicddrysmzp(tfeijiuwupin.getWupinxh());
			if(!list.isEmpty()){
				ddrysmzpCount="1";
			}
		}
	
		request.setAttribute("ddryzpCount", ddryzpCount);
		request.setAttribute("dwzpCount", dwzpCount);
		request.setAttribute("ddrysmzpCount", ddrysmzpCount);
		
		String sgrq=request.getParameter("sgrq")!=null?request.getParameter("sgrq"):"";
		String sfzh=request.getParameter("sfzh")!=null?request.getParameter("sfzh"):"";
		if(!sgrq.equals("")){
			tfeijiuwupin=tfeijiuwupinManager.getByrq(sgrq,sfzh);
			return "/pages/fjy/Tfeijiuwupin/allShow.jsp";
		}
		
		
		
		request.setAttribute("picCount", picCount);
		if(request.getParameter("fh")!=null)return "/pages/fjy/Tfeijiuwupin/staShow.jsp";
		return QUERYSHOW_JSP;
	}
	
	public String zazhShow() {
		HttpServletRequest request = ServletActionContext.getRequest();
		if(null!=tfeijiuwupin){
		String shougourq = tfeijiuwupin.getShougourq();
		
		String shougourqFormat = DateUtil.parseString(shougourq, "yyyyMMddHHmmss",
				"yyyy-MM-dd HH:mm:ss");
		tfeijiuwupin.setShougourq(shougourqFormat);

		//显示照片
		String picCount=null;
		if (tfeijiuwupin != null && tfeijiuwupin.getChushourensfzh() != null) {
			List list = tfeijiuwupinManager.getPicIDIsExist(tfeijiuwupin.getChushourensfzh());
			if(!list.isEmpty()){
				picCount="1";
			}
		}
		String ddryzpCount=null;
		if (tfeijiuwupin != null && tfeijiuwupin.getChushourensfzh() != null) {
			List list = tfeijiuwupinManager.getPicddryzp(tfeijiuwupin.getWupinxh());
			if(!list.isEmpty()){
				ddryzpCount="1";
			}
		}
		String dwzpCount=null;
		if (tfeijiuwupin != null && tfeijiuwupin.getChushourensfzh() != null) {
			List list = tfeijiuwupinManager.getPicdwzp(tfeijiuwupin.getWupinxh());
			if(!list.isEmpty()){
				dwzpCount="1";
			}
		}
		String ddrysmzpCount=null;
		if (tfeijiuwupin != null && tfeijiuwupin.getChushourensfzh() != null) {
			List list = tfeijiuwupinManager.getPicddrysmzp(tfeijiuwupin.getWupinxh());
			if(!list.isEmpty()){
				ddrysmzpCount="1";
			}
		}
	
		request.setAttribute("ddryzpCount", ddryzpCount);
		request.setAttribute("dwzpCount", dwzpCount);
		request.setAttribute("ddrysmzpCount", ddrysmzpCount);
		
		String sgrq=request.getParameter("sgrq")!=null?request.getParameter("sgrq"):"";
		String sfzh=request.getParameter("sfzh")!=null?request.getParameter("sfzh"):"";
		if(!sgrq.equals("")){
			tfeijiuwupin=tfeijiuwupinManager.getByrq(sgrq,sfzh);
			return "/pages/fjy/Tfeijiuwupin/zazhAllShow.jsp";
		}
		
		
		
		request.setAttribute("picCount", picCount);
		if(request.getParameter("fh")!=null)return "/pages/fjy/Tfeijiuwupin/zazhStaShow.jsp";
		}
		return ZAZHSHOW_JSP;
	}

	public String tab() {
		HttpServletRequest request = ServletActionContext.getRequest();
		String shougourq = tfeijiuwupin.getShougourq();
		String shougourqFormat = DateUtil.parseString(shougourq, "yyyyMMddHHmmss",
				"yyyy-MM-dd HH:mm:ss");
		tfeijiuwupin.setShougourq(shougourqFormat);

		String wupinxh = "";
		if (request.getParameter("wupinxh") != null)
			wupinxh = request.getParameter("wupinxh");
		if (wupinxh != null && wupinxh.length() > 0) {
			List listpic = (List) fileAttachManager.getPic("D",
					"T_FEIJIUWUPIN_PIC", wupinxh, "");
			request.setAttribute("listpic", listpic);
			List listfile = (List) fileAttachManager.getFile("D",
					"T_FEIJIUWUPIN_FILE", wupinxh, "");
			request.setAttribute("listfile", listfile);
		}

		return TAB_JSP;
	}

	/** 进入新增页面*/
	public String create() {
		HttpServletRequest request = ServletActionContext.getRequest();
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
		String typecode = "";
		String x = "0";
		
		typecode=tcpinfoManager.typecode(deptid);
		String jmType = (String)DictHelpImpl.getInitData("jmType");
		if(typecode != null && !typecode.equals("")){
			Encry en = new Encry();
			String re="";
			if("1".equals(jmType)){
				re=en.crypt_pwd("e", "actively", typecode);
			}else{
				re=en.crypt_pwd("e", "bsdkyes", typecode);
			}
			if(!re.equals(deptid)){
				x="1";
			}
		}else{
			String orcmmcode="";
			orcmmcode = tcpinfoManager.orcmmcode(deptid);
			if (orcmmcode != null && !orcmmcode.equals("")) {
				Encry en = new Encry();
				String orcmm = "";
				if ("1".equals(jmType)) {
					orcmm = en.crypt_pwd("e", "energetically", orcmmcode);
				} else {
					orcmm = en.crypt_pwd("e", "smyesok", orcmmcode);
				}
				if (!orcmm.equals(deptid)) {
					x = "1";
				}
			} else {
				x = "1";
			}
		}
		request.setAttribute("x", x);
		Date date = new Date();
		SimpleDateFormat format_shougourq = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String currDate = format_shougourq.format(date);
		tfeijiuwupin.setShougourq(currDate);
		tfeijiuwupin.setIskeyi("0");
		
		String deptID = "";
		Integer userid = 0;   //用户id
	
		userDetail = SpringTagFunctions.getUserDetails();
		if (userDetail != null) {
			deptID = userDetail.getDeptID();
			userid = userDetail.getUserId();
		}
		
		String shougoury  = temployeeManager.getemploee(deptID, userid);
		
		request.setAttribute("shougoury", shougoury);
		request.setAttribute("username", userDetail.getUserXm());
		
		
//		String sql = "select  EMPCODE,EMPNAME  from T_EMPLOYEE where cyrjzt != '2' and CPCODE ='"+deptID+"' and USERID="+userid+"";
//		jbrMap = new TreeMap();
//		List staList = ssCommonManager.getSjpp(sql);
//		if (staList != null) {
//			for (int j = 0; j < staList.size(); j++) {
//				Map staResults = (HashMap) staList.get(j);
//				String staCODE = (String) staResults.get("CODE");
//				String staCALLED = (String) staResults.get("CALLED");
//				jbrMap.put(staCODE, staCALLED);
//			}
//		}
		if(tfeijiuwupin != null && tfeijiuwupin.getNpcode() != null && tfeijiuwupin.getNpcode().length() > 2){
			request.setAttribute("npcodehidden", tfeijiuwupin.getNpcode());
			request.setAttribute("npcodeprovhidden", tfeijiuwupin.getNpcode().substring(0, 2)+"0000");
		}else{
			request.setAttribute("npcodeprovhidden", DictHelpImpl.getInitData("prcode"));
		}
		return CREATE_JSP;
	}

	/** 保存新增对象 */
	public String save() {
		HttpServletRequest request = ServletActionContext.getRequest();

		Date date = new Date();
		SimpleDateFormat format_shougourq = new SimpleDateFormat("yyyyMMdd");
		String currDate = format_shougourq.format(date);
		SimpleDateFormat shougourqFormat = new SimpleDateFormat("yyyyMMddHHmmss");

		tfeijiuwupin.setShougourq(shougourqFormat.format(date));
		
		byte[] uploadBytes= null;
		String photoBuffer = "";
		if (request.getParameter("photoBuffer") != null)
			photoBuffer = request.getParameter("photoBuffer");
		if (StringUtils.isNotEmpty(photoBuffer)) {
			 uploadBytes = (byte[])net.java.dev.common.util.PicDecode.decode(photoBuffer);
		}
	

		String deptID = "";
		String username = "";
		Long userid=null;
		MyUserDetails userDetail = null;
		userDetail = SpringTagFunctions.getUserDetails();
		if (userDetail != null) {
			deptID = userDetail.getDeptID();
			username = userDetail.getUsername();
			userid=Long.valueOf(userDetail.getUserId());
		}
		tfeijiuwupin.setCpcode(deptID);
		tfeijiuwupin.setUserid(userid);
		String start_char = "", str_end_char = "";

		String maxID = "";
		start_char = deptID + currDate;
		String max_end_char = "0000";
		String sql = "select max(WUPINXH) from T_FEIJIUWUPIN where CPCODE= ? and substr(SHOUGOURQ,0,8)  = '"
				+ currDate + "'";
		maxID = tfeijiuwupinManager.getCurrentMax(sql, deptID);
		//System.out.println("11111111111="+maxID);
		if (maxID != null && maxID.length() > 0) {
			max_end_char = maxID.substring(start_char.length());
		}
		////System.out.println("11111111111max_end_char ="+max_end_char);
		int i_max_end_char = Integer.parseInt(max_end_char);
		i_max_end_char = i_max_end_char + 1;
		Integer obj = new Integer(i_max_end_char);
		str_end_char = Util.padString(obj.toString(), 4, "0", true);
		//System.out.println("00000000000000="+start_char + str_end_char);
		tfeijiuwupin.setWupinxh(start_char + str_end_char);

		try {

			SimpleDateFormat format_file_CREATETIME = new SimpleDateFormat(
					"yyyy-MM-dd HH:mm:ss");
			String str_file_CREATETIME = format_file_CREATETIME.format(date);

			int i = 0;
			for (File u : uploads) {
				Integer objfile = new Integer(i);
				String str_ojb = objfile.toString();

				String fileName = uploadFileNames.get(i);
				String nameWithoutExt = getNameWithoutExtension(fileName);
				String ext = getExtension(fileName);
				int fileSize = (int) uploads.get(i).length();
				Long fileId = tfeijiuwupinManager.getSeq();
				fileAttach = new FileAttach();
				fileAttach.setFileid(fileId);
				fileAttach.setCreatetimeString(str_file_CREATETIME);
				fileAttach.setAbsolutepath("");
				fileAttach.setContenttype(uploadContentTypes.get(i));
				fileAttach.setCreator(username);
				fileAttach.setFileext(ext);
				fileAttach.setFilegroup("T_FEIJIUWUPIN_PIC");
				fileAttach.setFilename(nameWithoutExt);
				fileAttach.setFilepath("");
				fileAttach.setFileSave("D");
				fileAttach.setFilesize(fileSize);
				fileAttach.setNote("废旧物品照片");
				fileAttach.setRelationId(start_char + str_end_char);
				if (uploads.get(i).length() <= 0) {
					request.setAttribute("message", "上传的文件不能为空！");
					//return CREATE_JSP;
				}
				if (maxSize > 0 && uploads.get(i).length() > maxSize) {
					request.setAttribute("message", "上传的单个文件不能超过" + maxSize
							+ "字节！");
					//return CREATE_JSP;
				}
				fileAttachManager.savePic(u, fileAttach);
				i++;
			}
			//判断申请人照片不能大于100KB
			if (uploads != null && uploads.size() > 0) {
				if (uploads.get(0).length() > uplodsSize) {
					request.setAttribute("message", "申请人照片不能大于" + uplodsSize
							/ 1024 + "KB");
					return UPDATEPHOTOERROR;
				}
			}
			//判断当物照片不能大于5M
			if (affixs != null && affixs.size() > 0) {
				if (affixs.get(0).length() > affixsSize) {
					request.setAttribute("message", "当物照片不能大于" + affixsSize
							/ 1024 / 1024 + "M");
					return UPDATEPHOTOERROR;
				}
			}

			if (affixs != null) {
				int j = 0;
				for (; j < affixs.size(); j++) {
					if (affixs.get(j).length() <= 0) {
						request.setAttribute("message", "上传的文件不能为空！");
						continue; 
					}
					System.out.println("affixs.get(j).length()="+affixs.get(j).length());
					System.out.println("affixContentTypes.get(j)="+affixContentTypes.get(j));
					if (maxSize > 0 && affixs.get(j).length() > maxSize) {
						request.setAttribute("message", "上传的单个文件不能超过" + maxSize
								+ "字节！");
						System.out.println("上传的单个文件不能超过" + maxSize+ "字节,忽略数据");
						continue; 
					}

					String fileName = affixFileNames.get(j);
					String nameWithoutExt = getNameWithoutExtension(fileName);
					String ext = getExtension(fileName);
					int fileSize = (int) affixs.get(j).length();

					Long fileId = tfeijiuwupinManager.getSeq();
					fileAttach = new FileAttach();
					fileAttach.setFileid(fileId);
					fileAttach.setCreatetimeString(str_file_CREATETIME);
					fileAttach.setAbsolutepath("");
					fileAttach.setContenttype(affixContentTypes.get(j));
					fileAttach.setCreator(username);
					fileAttach.setFileext(ext);
					fileAttach.setFilegroup("T_FEIJIUWUPIN_FILE");
					fileAttach.setFilename(nameWithoutExt);
					fileAttach.setFilepath("");
					fileAttach.setFileSave("D");
					fileAttach.setFilesize(fileSize);
					fileAttach.setNote("废旧物品附件");
					fileAttach.setRelationId(start_char + str_end_char);

					fileAttachManager.saveFile(affixs.get(j), fileAttach);
				}
			}

		}

		catch (Exception e) {
			e.printStackTrace();
		}
		
		String queryCount = " select count(*) from T_CSRXX t where t.idcard = '"+tfeijiuwupin.getChushourensfzh()+"' and cpcode = '"+tfeijiuwupin.getCpcode()+"' ";
		//Tcsrxx tcsrxx=tcsrxxManager.getById(tfeijiuwupin.getChushourensfzh());
		int counts = tcsrxxManager.getRecorderCount(queryCount);
		//public int getRecorderCount(String sql) {
		
		try {
	     
		if(counts <= 0){
			Tcsrxx tcsrxx=new Tcsrxx();
				tcsrxx.setIdcard(tfeijiuwupin.getChushourensfzh());
				tcsrxx.setCsrxm(tfeijiuwupin.getCsrxm());
				tcsrxx.setCsrdh(tfeijiuwupin.getChushourenlxdh());
				tcsrxx.setNpcode(tfeijiuwupin.getNpcode());
				tcsrxx.setNpaddress(tfeijiuwupin.getNpaddress());
				tcsrxx.setCpcode(tfeijiuwupin.getCpcode());
				tcsrxx.setCsrxb(tfeijiuwupin.getCsrxb());
				tcsrxx.setPraddress(tfeijiuwupin.getPraddress());
				tcsrxx.setHjaddress(tfeijiuwupin.getHjaddress());
				tcsrxxManager.savePic(tcsrxx,uploadBytes);
				
			}else {
				Tcsrxx tcsrxx=tcsrxxManager.getById(tfeijiuwupin.getChushourensfzh(),tfeijiuwupin.getCpcode());
				tcsrxx.setCsrxm(tfeijiuwupin.getCsrxm());
				if(tfeijiuwupin.getChushourenlxdh()!=null&&!tfeijiuwupin.getChushourenlxdh().equals(""))
				tcsrxx.setCsrdh(tfeijiuwupin.getChushourenlxdh());
				
				tcsrxx.setNpcode(tfeijiuwupin.getNpcode());
				if(tfeijiuwupin.getNpaddress()!=null&&!tfeijiuwupin.getNpaddress().equals(""))
				tcsrxx.setNpaddress(tfeijiuwupin.getNpaddress());
				tcsrxx.setCpcode(tfeijiuwupin.getCpcode());
				tcsrxx.setCsrxb(tfeijiuwupin.getCsrxb());
				tcsrxx.setPraddress(tfeijiuwupin.getPraddress());
				tcsrxx.setHjaddress(tfeijiuwupin.getHjaddress());
				tcsrxxManager.updateTcsrxx(tcsrxx);
				
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			mgs="保存失败！";
			return create();
		}
		tfeijiuwupinManager.save(tfeijiuwupin);
		
		try {
		    
			File uploadFile = null;
			InputStream uploadIs = null;
			byte[] uploadBytes1= null;
			if(uploads != null && uploads.size() > 0 ){
				uploadFile = uploads.get(0);
				uploadIs = new FileInputStream(uploadFile);
			    uploadBytes1 =  (byte[])IOUtils.toByteArray(uploadIs);
			}
			
			String photoBuffer1 = "";
			if (request.getParameter("photoBuffer") != null)
				photoBuffer1 = request.getParameter("photoBuffer");
			if (StringUtils.isNotEmpty(photoBuffer1)) {
				 uploadBytes1 = (byte[])net.java.dev.common.util.PicDecode.decode(photoBuffer1);
			}
			//当物照片
			File affixFile = null;
			InputStream affixIs = null;
			byte[] affixBytes= null;
			if(affixs != null && affixs.size() > 0 ){
				affixFile = affixs.get(0);
				affixIs = new FileInputStream(affixFile);
				affixBytes =  (byte[])IOUtils.toByteArray(affixIs);
				
			}
			
			String affixfileid = "";
			if (request.getParameter("affixfileid") != null)
				affixfileid = request.getParameter("affixfileid");
			if (StringUtils.isNotEmpty(affixfileid)) {
				List list = (List) fileAttachManager.getFileContent(affixfileid, " and 1=1 ");
				if (list != null && list.size() > 0) {
					for (int i = 0; i < list.size(); i++) {
						Map results = (HashMap) list.get(i);
						affixBytes = (byte[]) results.get("CONTENT");
					}
				}
			}
			//申请人扫描照片
			File picFile = null;
			InputStream picIs = null;
			byte[] picBytes= null;
			if(pics != null && pics.size() > 0 ){
				picFile = pics.get(0);
				picIs = new FileInputStream(picFile);
				picBytes =  (byte[])IOUtils.toByteArray(picIs);	
			}
			
			String picfileid = "";
			if (request.getParameter("picfileid") != null)
				picfileid = request.getParameter("picfileid");
			if (StringUtils.isNotEmpty(picfileid)) {
				List list = (List) fileAttachManager.getFileContent(picfileid, " and  1=1 ");
				if (list != null && list.size() > 0) {
					for (int i = 0; i < list.size(); i++) {
						Map results = (HashMap) list.get(i);
						 picBytes = (byte[]) results.get("CONTENT");
					}
				}
			}
			
			if (uploadBytes1 != null  || affixBytes != null || picBytes != null) {
				tfeijiuwupinManager.savePic(uploadBytes1, affixBytes,picBytes, tfeijiuwupin);
			} 
			if(picIs != null)
				picIs.close();
			if(uploadIs != null)
				uploadIs.close();
			if(affixIs != null)
				affixIs.close();
			

		} catch (Exception ex) {
			ex.printStackTrace();

		}
		
		mgs="保存成功！";

		return create();////LIST_ACTION;
	}

	/**进入更新页面*/
	public String edit() {
		HttpServletRequest request = ServletActionContext.getRequest();
		
		String deptID = "";
		MyUserDetails userDetail = null;
		userDetail = SpringTagFunctions.getUserDetails();
		if (userDetail != null) {
			deptID = userDetail.getDeptID();
		}
		String sql = "select  EMPCODE,EMPNAME  from T_EMPLOYEE where cyrjzt != '2' and CPCODE ='"+deptID+"'";
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
		
		String shougourq = tfeijiuwupin.getShougourq();
		String shougourqFormat = DateUtil.parseString(shougourq, "yyyyMMddHHmmss","yyyy-MM-dd HH:mm:ss");
		tfeijiuwupin.setShougourq(shougourqFormat);

		String wupinxh = "";
		if (request.getParameter("wupinxh") != null)
			wupinxh = request.getParameter("wupinxh");
		if (wupinxh != null && wupinxh.length() > 0) {
			List listpic = (List) fileAttachManager.getPic("D",
					"T_FEIJIUWUPIN_PIC", wupinxh, "");
			request.setAttribute("listpic", listpic);
			List listfile = (List) fileAttachManager.getFile("D",
					"T_FEIJIUWUPIN_FILE", wupinxh, "");
			request.setAttribute("listfile", listfile);
		}

		return EDIT_JSP;
	}

	/**保存更新对象*/
	public String update() {
		HttpServletRequest request = ServletActionContext.getRequest();
		String shougourqFormat = DateUtil.parseString(request, "shougourq",
				"yyyy-MM-dd HH:mm:ss", "yyyyMMddHHmmss");
		tfeijiuwupin.setShougourq(shougourqFormat);
		tfeijiuwupinManager.update(this.tfeijiuwupin);
		return returnUrl;////LIST_ACTION;
	}

	/**删除对象*/
	public String delete() {
		for (int i = 0; i < items.length; i++) {
			Hashtable params = HttpUtils.parseQueryString(items[i]);
			java.lang.String id = new java.lang.String((String) params
					.get("wupinxh"));
			tfeijiuwupinManager.removeById(id);
		}
		return returnUrl;//LIST_ACTION;
	}

	private static String getNameWithoutExtension(String fileName) {
		return fileName.substring(0, fileName.lastIndexOf("."));
	}

	private String getExtension(String fileName) {
		return fileName.substring(fileName.lastIndexOf(".") + 1);
	}
	
	
	//显示图片
	public String showPic() {
		HttpServletRequest request = ServletActionContext.getRequest();
		String idcard=null, cpcode=null;
		
		
		String ddryzpCount=null;
	
		String dwzpCount=null;
	
		String ddrysmzpCount=null;
		if (request.getParameter("idcard") != null)
			idcard = request.getParameter("idcard");
		
		
		//List list = (List) ssCommonManager.getPic(xh);
		List list = (List) tfeijiuwupinManager.getPic(idcard);
		
		request.setAttribute("list", list);
		return QUWEYSHOW_PIC;
	}
	public String showPicddryzp() {
		HttpServletRequest request = ServletActionContext.getRequest();
		String idcard=null, cpcode=null;
		
		
		if (request.getParameter("idcard") != null)
			idcard = request.getParameter("idcard");
		
		
		//List list = (List) ssCommonManager.getPic(xh);
		List list = (List) tfeijiuwupinManager.getPicddryzp(idcard);
		
		request.setAttribute("list", list);
		return QUWEYSHOW_PIC;
	}
	public String showPicdwzp() {
		HttpServletRequest request = ServletActionContext.getRequest();
		String idcard=null, cpcode=null;
		
		
		if (request.getParameter("idcard") != null)
			idcard = request.getParameter("idcard");
		
		
		//List list = (List) ssCommonManager.getPic(xh);
		List list = (List) tfeijiuwupinManager.getPicdwzp(idcard);
		
		request.setAttribute("list", list);
		return QUWEYSHOW_PIC;
	}
	public String showPicddrysmzp() {
		HttpServletRequest request = ServletActionContext.getRequest();
		String idcard=null, cpcode=null;
		
		
		if (request.getParameter("idcard") != null)
			idcard = request.getParameter("idcard");
		
		
		//List list = (List) ssCommonManager.getPic(xh);
		List list = (List) tfeijiuwupinManager.getPicddrysmzp(idcard);
		
		request.setAttribute("list", list);
		return QUWEYSHOW_PIC;
	}

	public String pictShow() {
		HttpServletRequest request = ServletActionContext.getRequest();
		String FILEID = "";
		if (request.getParameter("FILEID") != null)
			FILEID = request.getParameter("FILEID");
		List list = (List) fileAttachManager.getPicContent(FILEID, "");
		request.setAttribute("list", list);
		return SHOW_PIC;
	}

	public void editFile() throws IOException {
		HttpServletRequest request = ServletActionContext.getRequest();

		String FILEID = "";
		if (request.getParameter("FILEID") != null)
			FILEID = request.getParameter("FILEID");
		
		
		String deptid = "";
		String sqlWhere = "";
		MyUserDetails userDetail = null;
		userDetail = SpringTagFunctions.getUserDetails();
		if (userDetail != null) {
			deptid = userDetail.getDeptID();
		}
		if (!SpringTagFunctions.ifAnyGranted("ROLE_QUERY_ALL,ROLE_ADMIN")) {
			sqlWhere = " and  FILEGROUP = 'T_FEIJIUWUPIN_FILE' and   relation_id in ( select WUPINXH  from T_FEIJIUWUPIN  where CPCODE = '"+deptid+"' ) ";
		}
		
		if (affixs != null) {
			int j = 0;
			for (; j < affixs.size(); j++) {
				String fileName = affixFileNames.get(j);
				String nameWithoutExt = getNameWithoutExtension(fileName);
				String ext = getExtension(fileName);
				String ContentType = affixContentTypes.get(j);
				long fileSize = affixs.get(j).length();
				fileAttachManager.updateFile(affixs.get(j), fileName,
						ContentType, fileSize, ext, FILEID, sqlWhere);

			}
		}
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("text/html;charset=GBK");
		try {
			response.setContentType("text/html;charset=GBK");
			response.getWriter().print(
					"<script>alert(\" 修改成功！ \");window.close();</script>");
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public void editPict() throws IOException {
		HttpServletRequest request = ServletActionContext.getRequest();

		String FILEID = "";
		if (request.getParameter("FILEID") != null)
			FILEID = request.getParameter("FILEID");
		
		String deptid = "";
		String sqlWhere = "";
		MyUserDetails userDetail = null;
		userDetail = SpringTagFunctions.getUserDetails();
		if (userDetail != null) {
			deptid = userDetail.getDeptID();
		}
		if (!SpringTagFunctions.ifAnyGranted("ROLE_QUERY_ALL,ROLE_ADMIN")) {
			sqlWhere = " and  FILEGROUP = 'T_FEIJIUWUPIN_PIC' and   relation_id in ( select WUPINXH  from T_FEIJIUWUPIN  where CPCODE = '"+deptid+"' ) ";
		}
		
		int i = 0;
		for (File u : uploads) {
			Integer obj = new Integer(i);
			String str_ojb = obj.toString();
			String fileName = uploadFileNames.get(i);
			String nameWithoutExt = getNameWithoutExtension(fileName);
			String ext = getExtension(fileName);
			String ContentType = uploadContentTypes.get(i);
			long fileSize = uploads.get(i).length();
			fileAttachManager.updateFile(uploads.get(i), nameWithoutExt,
					ContentType, fileSize, ext, FILEID, sqlWhere);

			i++;
		}
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("text/html;charset=GBK");
		try {
			response.setContentType("text/html;charset=GBK");
			response.getWriter().print(
					"<script>alert(\" 修改成功！ \");window.close();</script>");
		} catch (Exception ex) {

		}
	}

	public String deletePict() {
		HttpServletRequest request = ServletActionContext.getRequest();
		String FILEID = "";
		if (request.getParameter("FILEID") != null)
			FILEID = request.getParameter("FILEID");
		
		String deptid = "";
		String sqlWhere = "";
		MyUserDetails userDetail = null;
		userDetail = SpringTagFunctions.getUserDetails();
		if (userDetail != null) {
			deptid = userDetail.getDeptID();
		}
		if (!SpringTagFunctions.ifAnyGranted("ROLE_QUERY_ALL,ROLE_ADMIN")) {
			sqlWhere = " and  FILEGROUP = 'T_FEIJIUWUPIN_PIC'  and   relation_id in ( select WUPINXH  from T_FEIJIUWUPIN  where CPCODE = '"+deptid+"' ) ";
		}
		
		fileAttachManager.removebyFileID(FILEID,sqlWhere);
		return deleteReturnUrl;
	}

	public String deleteFile() {
		HttpServletRequest request = ServletActionContext.getRequest();
		String FILEID = "";
		if (request.getParameter("FILEID") != null)
			FILEID = request.getParameter("FILEID");
		
		String deptid = "";
		String sqlWhere = "";
		MyUserDetails userDetail = null;
		userDetail = SpringTagFunctions.getUserDetails();
		if (userDetail != null) {
			deptid = userDetail.getDeptID();
		}
		if (!SpringTagFunctions.ifAnyGranted("ROLE_QUERY_ALL,ROLE_ADMIN")) {
			sqlWhere = " and  FILEGROUP = 'T_FEIJIUWUPIN_FILE' and   relation_id in ( select WUPINXH  from T_FEIJIUWUPIN  where CPCODE = '"+deptid+"' ) ";
		}
		
		fileAttachManager.removebyFileID(FILEID, sqlWhere);
		return deleteReturnUrl;
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


		
		dateSelectMap = DateUtil.getDateSelectData();
		String dateSelect2 = "";
		if (request.getParameter("dateSelect2") != null)
			dateSelect2 = request.getParameter("dateSelect2");
		request.setAttribute("dateSelect2", dateSelect2);
		String s_shougourqBeginFormat = DateUtil.parseString(request,"s_shougourqBegin", "yyyy-MM-dd", "yyyyMMdd");
		String s_shougourqEndFormat = DateUtil.parseString(request,"s_shougourqEnd", "yyyy-MM-dd", "yyyyMMdd");
		if(s_shougourqBeginFormat != null && s_shougourqBeginFormat.length() > 0)
			pageRequest.getFilters().put("shougourqBeginFormat",s_shougourqBeginFormat+"000000");
		if(s_shougourqEndFormat != null && s_shougourqEndFormat.length() > 0)
			pageRequest.getFilters().put("shougourqEndFormat", s_shougourqEndFormat+"235959");

		Page page = tfeijiuwupinManager.findByPageRequest(pageRequest, deptseq);
		savePage(page, pageRequest);
		return LISTALL_JSP;
	}

	/** 查看对象*/
	public String showAll() {
		HttpServletRequest request = ServletActionContext.getRequest();
		String shougourq = tfeijiuwupin.getShougourq();
		String shougourqFormat = DateUtil.parseString(shougourq, "yyyyMMddHHmmss",
				"yyyy-MM-dd HH:mm:ss");
		tfeijiuwupin.setShougourq(shougourqFormat);

		String wupinxh = "";
		if (request.getParameter("wupinxh") != null)
			wupinxh = request.getParameter("wupinxh");
		if (wupinxh != null && wupinxh.length() > 0) {
			List listpic = (List) fileAttachManager.getPic("D",
					"T_FEIJIUWUPIN_PIC", wupinxh, "");
			request.setAttribute("listpic", listpic);
			List listfile = (List) fileAttachManager.getFile("D",
					"T_FEIJIUWUPIN_FILE", wupinxh, "");
			request.setAttribute("listfile", listfile);
		}

		return SHOWALL_JSP;
	}

	public String tabAll() {
		HttpServletRequest request = ServletActionContext.getRequest();
		String shougourq = tfeijiuwupin.getShougourq();
		String shougourqFormat = DateUtil.parseString(shougourq, "yyyyMMddHHmmss",
				"yyyy-MM-dd HH:mm:ss");
		tfeijiuwupin.setShougourq(shougourqFormat);

		String wupinxh = "";
		if (request.getParameter("wupinxh") != null)
			wupinxh = request.getParameter("wupinxh");
		if (wupinxh != null && wupinxh.length() > 0) {
			List listpic = (List) fileAttachManager.getPic("D",
					"T_FEIJIUWUPIN_PIC", wupinxh, "");
			request.setAttribute("listpic", listpic);
			List listfile = (List) fileAttachManager.getFile("D",
					"T_FEIJIUWUPIN_FILE", wupinxh, "");
			request.setAttribute("listfile", listfile);
		}

		return TABALL_JSP;
	}

	public String getDeleteReturnUrl() {
		return deleteReturnUrl;
	}

	public void setDeleteReturnUrl(String deleteReturnUrl) {
		this.deleteReturnUrl = deleteReturnUrl;
	}

	public TreeMap<String, String> getJbrMap() {
		return jbrMap;
	}

	public void setJbrMap(TreeMap<String, String> jbrMap) {
		this.jbrMap = jbrMap;
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

	public void setTcsrxxManager(TcsrxxManager tcsrxxManager) {
		this.tcsrxxManager = tcsrxxManager;
	}

	public String getMgs() {
		return mgs;
	}

	public void setMgs(String mgs) {
		this.mgs = mgs;
	}
}
