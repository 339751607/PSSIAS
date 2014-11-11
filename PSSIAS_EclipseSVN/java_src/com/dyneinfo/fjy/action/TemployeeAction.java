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
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

import javacommon.base.BaseStruts2Action;
import javacommon.util.CipherUtil;

import javax.servlet.http.HttpServletRequest;

import net.java.dev.common.dict.taglib.DictHelpImpl;
import net.java.dev.common.util.DateUtil;
import net.java.dev.common.util.SpringTagFunctions;

import org.apache.commons.io.IOUtils;
import org.apache.struts2.ServletActionContext;
import org.security.userdetails.MyUserDetails;
import org.springframework.security.Authentication;
import org.springframework.security.context.SecurityContext;
import org.springframework.security.context.SecurityContextHolder;

import sun.misc.BASE64Decoder;
import cn.org.rapid_framework.page.Page;
import cn.org.rapid_framework.page.PageRequest;
import cn.org.rapid_framework.web.util.HttpUtils;

import com.dyneinfo.fjy.model.Temployee;
import com.dyneinfo.fjy.model.Tempworklog;
import com.dyneinfo.fjy.service.TcpinfoManager;
import com.dyneinfo.fjy.service.TemployeeManager;
import com.dyneinfo.fjy.service.TempworklogManager;
import com.dyneinfo.zazh.model.SsRole;
import com.dyneinfo.zazh.model.SsUser;
import com.dyneinfo.zazh.service.SsCommonManager;
import com.dyneinfo.zazh.service.SsUserManager;
import com.dyneinfo.zazh.util.Encry;
import com.dyneinfo.zazh.util.IDCard;
import com.opensymphony.xwork2.ModelDriven;
import com.opensymphony.xwork2.Preparable;

/**
 * @author lisc email:lishicheng(a)gmail.com
 */


public class TemployeeAction extends BaseStruts2Action implements Preparable,ModelDriven{
	//默认多列排序,example: username desc,createTime asc
	protected static final String DEFAULT_SORT_COLUMNS = null; 
	
	//forward paths
	protected static final String QUERY_JSP = "/pages/fjy/Temployee/query.jsp";
	protected static final String LIST_JSP= "/pages/fjy/Temployee/list.jsp";
	protected static final String CREATE_JSP = "/pages/fjy/Temployee/create.jsp";
	protected static final String EDIT_JSP = "/pages/fjy/Temployee/edit.jsp";
	protected static final String SHOW_JSP = "/pages/fjy/Temployee/show.jsp";
	protected static final String ZAZHSHOW_JSP = "/pages/fjy/Temployee/zazhShow.jsp";
	
	protected static final String TAB_JSP = "/pages/fjy/Temployee/tab.jsp";
	//redirect paths,startWith: !
	protected static final String LIST_ACTION = "!/pages/fjy/Temployee/list.do";
	
	protected static final String SHOWALL_JSP = "/pages/fjy/Temployee/showAll.jsp";
	protected static final String QUERYSHOW_JSP = "/pages/fjy/Temployee/queryshow.jsp";
	
	protected static final String LISTALL_JSP= "/pages/fjy/Temployee/listAll.jsp";
	protected static final String CREATEALL_JSP = "/pages/fjy/Temployee/createAll.jsp";
	protected static final String EDITALL_JSP = "/pages/fjy/Temployee/editAll.jsp";

	protected static final String TABALL_JSP = "/pages/fjy/Temployee/tabAll.jsp";
	protected static final String UPDATEPHOTOSUCCESS = "/pages/fjy/pic/uploadFileSuccess.jsp";
	protected static final String UPDATEPHOTOFAILURE= "/pages/fjy/pic/uploadFileFailure.jsp";
	protected static final String QUERYLIST_JSP="/pages/fjy/Temployee/queryList.jsp";
	
	protected static final String SHOW_PIC = "/pages/pic/pic.jsp";
	
	
	CipherUtil cipher = new CipherUtil();
	private TemployeeManager temployeeManager;
	private SsCommonManager ssCommonManager;
	private TempworklogManager tempworklogManager;
	private SsUserManager ssUserManager;
	private TcpinfoManager tcpinfoManager;
	
	public void setTcpinfoManager(TcpinfoManager tcpinfoManager) {
		this.tcpinfoManager = tcpinfoManager;
	}

	private Temployee temployee;
	java.lang.String id = null;
	private String[] items;
	private String returnUrl;  //返回列表，保留查询条件
	private String editReturnUrl;  //返回列表，保留查询条件
	private TreeMap<String, String> dateSelectMap;// //日期选择
	TreeMap<String,String> provMap ;
	
	
	private List <SsRole> rolemap;//存所有的选项 
	private List  selectList = new ArrayList();  //存已选中的选项 
	private String saveroleselected; //存更新后选中的选项（保存时调用） 
	
	private String filmName;
	private String filmContent;
	private File file;
	private String fileFileName;
	private String fileContentType;
	private long FilemaxSize = 1*1024*1024; //照片字节

	
	

	public void prepare() throws Exception {
		if (isNullOrEmptyString(id)) {
			temployee = new Temployee();
		} else {
			temployee = (Temployee)temployeeManager.getTemployeeById(id);
		}
	}
	
	/** 增加setXXXX()方法,spring就可以通过autowire自动设置对象属性 */
	public void setTemployeeManager(TemployeeManager manager) {
		this.temployeeManager = manager;
	}	
	public void setSsCommonManager(SsCommonManager ssCommonManager) {
		this.ssCommonManager = ssCommonManager;
	}
	
	public void setTempworklogManager(TempworklogManager manager) {
		this.tempworklogManager = manager;
	}	
	
	public void setSsUserManager(SsUserManager manager) {
		this.ssUserManager = manager;
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


	
	/** 执行搜索 */
	public String list() {
		PageRequest<Map> pageRequest = newPageRequest(DEFAULT_SORT_COLUMNS);
		HttpServletRequest request = ServletActionContext.getRequest();
		//pageRequest.getFilters().put("key",value);     //add custom filter
		

		
		
		String username ="";
		String deptid = "";
		String deptseq ="";
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
		
		Page page = temployeeManager.findByPageRequest(pageRequest);
		savePage(page,pageRequest);
		return LIST_JSP;
	}
	
	/** 查看对象*/
	public String show() {
		HttpServletRequest request = ServletActionContext.getRequest();
		String birth =  temployee.getBirth();
		String birthFormat = DateUtil.parseString(birth,"yyyyMMdd","yyyy-MM-dd");
		temployee.setBirth(birthFormat);
		
		//显示照片
		int picCount = 0;
		if (temployee != null && temployee.getEmpcode() != null) {
			picCount = ssCommonManager.getPicIDIsExist(temployee.getEmpcode());
		}
		Integer obj = new Integer(picCount);
		request.setAttribute("picCount", obj.toString());
		
		return SHOW_JSP;
	}
	
	public String zazhShow() {
		HttpServletRequest request = ServletActionContext.getRequest();
		if(null!=temployee){
			String birth =  temployee.getBirth();
			String birthFormat = DateUtil.parseString(birth,"yyyyMMdd","yyyy-MM-dd");
			temployee.setBirth(birthFormat);
			
			//显示照片
			int picCount = 0;
			if (temployee != null && temployee.getEmpcode() != null) {
				picCount = ssCommonManager.getPicIDIsExist(temployee.getEmpcode());
			}
			Integer obj = new Integer(picCount);
			request.setAttribute("picCount", obj.toString());
		}
		
		return ZAZHSHOW_JSP;
	}
	
	/** 进入新增页面 */
	public String create() {
		HttpServletRequest request = ServletActionContext.getRequest();
		provMap = new TreeMap();
		List listprov = ssCommonManager.getProv();
		if (listprov != null && listprov.size() > 0) {
			for (int i = 0; i < listprov.size(); i++) {
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
		String orcmmcode = "";
		String x = "0";
		String jmType = (String) DictHelpImpl.getInitData("jmType");
		typecode = tcpinfoManager.typecode(deptid);
		if (typecode != null && !typecode.equals("")) {
			Encry en = new Encry();
			String re = "";
			if ("1".equals(jmType)) {
				re = en.crypt_pwd("e", "actively", typecode);
			} else {
				re = en.crypt_pwd("e", "bsdkyes", typecode);
			}
			if (!re.equals(deptid)) {
				x = "1";
			}
		} else {
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

		String session_deptid = "";
		SecurityContext sc = SecurityContextHolder.getContext();
		Authentication auth = sc.getAuthentication();
		MyUserDetails ud = null;
		if ((auth != null) && auth.getPrincipal() instanceof MyUserDetails) {
			ud = (MyUserDetails) auth.getPrincipal();
			if (ud != null) {
				session_deptid = ud.getDeptID();
			}
		}

		String userid = "";
		if (request.getParameter("userid") != null)
			userid = request.getParameter("userid");

		if (userid != null && userid.length() > 0) {
			rolemap = ssUserManager.findUserNoExistRole(session_deptid, Long
					.parseLong(userid));

		} else {
			rolemap = ssUserManager.findDeptRole(session_deptid);
		}
		temployee.setCyrjzt("1");
		temployee.setPosition("11");
		temployee.setEnabled("1");

		return CREATE_JSP;
	}
	
	/** 保存新增对象 */
	public String save()  throws IOException{
		HttpServletRequest request = ServletActionContext.getRequest();
		BASE64Decoder decode = new BASE64Decoder(); 
		String base64=request.getParameter("s_files")!=null?request.getParameter("s_files"):"";

		byte[] pic = decode.decodeBuffer(base64); 

		String deptID = "";
		String deptName = "";
		MyUserDetails userDetail = null;
		userDetail = SpringTagFunctions.getUserDetails();
		if (userDetail != null) {
			deptID = userDetail.getDeptID();
			deptName = userDetail.getDeptName();
		}

		String username = "";
		if (request.getParameter("username") != null)
			username = request.getParameter("username");
		
		String password = "";
		if (request.getParameter("password") != null)
			password = request.getParameter("password");
		
		Long enabled = 1L;
		if (request.getParameter("enabled") != null)
			enabled = Long.parseLong(request.getParameter("enabled"));
		
		

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

		int idcardcount = temployeeManager.getCountByIdcard(new_IDCard,
				old_IDCard, deptID);
		if (idcardcount > 0) {
			request.setAttribute("message", "从业人员身份证信息已存在！");
			getProv();
			rolemap = ssUserManager.findDeptRole(deptID);
			return CREATE_JSP;// //LIST_ACTION;
		}
		int usernameCount = ssUserManager.getCountUserName(username);
		if (usernameCount > 0) {
			request.setAttribute("message", "用户名已存在！");
			getProv();
			rolemap = ssUserManager.findDeptRole(deptID);
			return CREATE_JSP;// //LIST_ACTION;
		}

		Date date = new Date();
		SimpleDateFormat format = new SimpleDateFormat("yyyyMMddHHmmss");
		String currDate = format.format(date);

		SimpleDateFormat logformat = new SimpleDateFormat("yyyyMMdd");
		String currDatelog = logformat.format(date);

		SimpleDateFormat formatInsert = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String currDateInsert = formatInsert.format(date);

		temployee.setInserttimeString(currDateInsert);
		temployee.setEdittimeString(currDateInsert);

		String birthFormat = DateUtil.parseString(request, "birth","yyyy-MM-dd", "yyyyMMdd");
		temployee.setBirth(birthFormat);
		
		String empcode = deptID+currDate;
		temployee.setCpcode(deptID);
		temployee.setEmpcode(empcode);
		//temployeeManager.save(temployee);
		
		Long worklogid = temployeeManager.getEempworklogSeq();
		
		Tempworklog tempworklog = new Tempworklog();
		tempworklog.setCpcode(deptID);
		//tempworklog.setCpname(deptName);
		tempworklog.setDemo("添加从业人员附加");
		tempworklog.setEmpcode(empcode);
		tempworklog.setEmptype("20");
		tempworklog.setIndate(currDatelog);
		tempworklog.setWorklogid(worklogid);
		//tempworklogManager.save(tempworklog);
		
		SsUser  ssUser = new SsUser();
		ssUser.setUsername(username);
		ssUser.setPassword(cipher.generatePassword(temployee.getPassword()));
	//	ssUser.setPassword(password);
		ssUser.setEnabled(enabled);
		ssUser.setFullname(temployee.getEmpname());
		ssUser.setSex(temployee.getSex());
		ssUser.setSfzh(temployee.getPersonid());

		Date dates=Calendar.getInstance().getTime();   
		java.sql.Date sqldate = new java.sql.Date(date.getTime());  

		ssUser.setCreatedate(sqldate);
		String deptID_long  = deptID;
		ssUser.setDeptid(deptID_long);
		
		
		Long userid = temployeeManager.getSsUserSeq();
		ssUser.setUserid(userid);
		temployee.setUserid(userid.toString());
		String[] selectRoles = request.getParameterValues("roles");// 选中角色
		
		
		temployeeManager.saveEmployee(temployee, tempworklog, ssUser, selectRoles, empcode, userid, deptID,pic);
		

		
		return returnUrl;////LIST_ACTION;
	}
	
	/**进入更新页面*/
	public String edit() {
		HttpServletRequest request = ServletActionContext.getRequest();
		
		String session_deptid = "";
		SecurityContext sc = SecurityContextHolder.getContext();
		Authentication auth = sc.getAuthentication();
		MyUserDetails ud = null;
		if ((auth != null) && auth.getPrincipal() instanceof MyUserDetails) {
			ud = (MyUserDetails) auth.getPrincipal();
			if (ud != null) {
				session_deptid = ud.getDeptID();
			}
		}
		
		String userid = "";
		if (request.getParameter("userid") != null)
			userid = request.getParameter("userid");
		String message = "";
		if (request.getParameter("message") != null)
			message = request.getParameter("message");
		
		if (message != null && message.equals("1")) {
			request.setAttribute("message", "用户名已存在！");
		} else if (message != null && message.equals("2")) {
			request.setAttribute("message", "从业人员身份证信息已存在！");
		}
			
	    // 所有旅馆角色
	     rolemap = ssUserManager.findDeptRole(session_deptid);

	   // 已有角色
		 List<SsRole>  rolelist = ssUserManager.findUserRole(Long.parseLong(userid));
		 if(rolelist != null) {
			Set<SsRole> roles = new LinkedHashSet<SsRole>(rolelist);
			for (SsRole role : roles) {
				selectList.add(role.getRoleid());
				temployee.setUserrole(role.getRoleid().toString());
		 }
		 }
	
		
		String birth =  temployee.getBirth();
		String birthFormat = DateUtil.parseString(birth,"yyyyMMdd","yyyy-MM-dd");
		temployee.setBirth(birthFormat);
		
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
		
		return EDIT_JSP;
	}
	
	/**保存更新对象*/
	public String update() {
		HttpServletRequest request = ServletActionContext.getRequest();
		
		String deptid = "";
	    String deptseq = "";
		MyUserDetails userDetail = null;
		userDetail = SpringTagFunctions.getUserDetails();
		if (userDetail != null) {
			
			deptid = userDetail.getDeptID();
			deptseq = userDetail.getDeptSeq();
		}
		
		String userid = "";
		if (request.getParameter("userid") != null)
			userid = request.getParameter("userid");
		
		String username = "";
		if (request.getParameter("username") != null)
			username = request.getParameter("username");
			
		String updateusername = "";
		if (request.getParameter("updateusername") != null)
			updateusername = request.getParameter("updateusername");	
			
		
		String password = "";
		if (request.getParameter("password") != null)
			password = request.getParameter("password");
		
		Long enabled = 1L;
		if (request.getParameter("enabled") != null)
			enabled = Long.parseLong(request.getParameter("enabled"));
		
		
		String birthFormat = DateUtil.parseString(request,"birth","yyyy-MM-dd","yyyyMMdd");
		//temployee.setBirth(birthFormat);
		
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
		
		SsUser  ssUser = new SsUser();
		int usernameCount = 0;
		if (username != null && username.length() > 0) {
            if(updateusername != null && !username.equals(updateusername))
            	 usernameCount = ssUserManager.getCountUserName(updateusername);
		} else {
			if (updateusername != null && updateusername.length() > 0) 
			     usernameCount = ssUserManager.getCountUserName(updateusername);
		}
		
		if (usernameCount > 0) {
			request.setAttribute("message", "用户名已存在！");
			return editReturnUrl+"message=1";// //LIST_ACTION;
		} else {
				ssUser.setUsername(updateusername);
		}
		
		Temployee temployee2 = (Temployee)temployeeManager.getTemployeeById(temployee.getEmpcode());
		int   idcardcount = temployeeManager.getCountByIdcard(new_IDCard, old_IDCard,deptid);
		  if (idcardcount > 0 && !temployee2.getPersonid().equals(temployee.getPersonid())) {
				request.setAttribute("message","从业人员身份证信息已存在！");
				return editReturnUrl+"message=2";////LIST_ACTION;
		  }
		
		//temployeeManager.update(this.temployee);
		
		if(temployee != null && temployee.getCyrjzt() != null && temployee.getCyrjzt().equals("2")){
		SimpleDateFormat formatlzsj = new SimpleDateFormat("yyyyMMdd");
		String lzsj = formatlzsj.format(date);
		String empcode = temployee.getEmpcode();
		
		String  Sql = " update T_EMPWORKLOG set LEFTDATE = '"+lzsj+"' Where EMPCODE = '"+empcode+"' and CPCODE='"+deptid+"'";
		ssCommonManager.update(Sql);
		}
		//ssUser.setUsername(username);
		ssUser.setDeptid(deptid);
		ssUser.setPassword(cipher.generatePassword(temployee.getPassword()));
		ssUser.setEnabled(enabled);
		ssUser.setFullname(temployee.getEmpname());
		ssUser.setSex(temployee.getSex());
		ssUser.setSfzh(temployee.getPersonid());
		ssUser.setUserid(Long.parseLong(userid));
		//temployeeManager.updateSsUser(ssUser);
		
		String[] selectRoles = request.getParameterValues("roles");// 选中角色
		temployeeManager.updateEmployee(temployee, ssUser, selectRoles, Long.parseLong(userid),deptid);
		
		return returnUrl;////LIST_ACTION;
	}
	
	/**删除对象*/
	public String delete() {
		for(int i = 0; i < items.length; i++) {
			Hashtable params = HttpUtils.parseQueryString(items[i]);
			java.lang.String id = new java.lang.String((String)params.get("empcode"));
			temployeeManager.updateEmpStatus(id);
			temployeeManager.updateUserStatus(id);
		}
		return returnUrl ;//LIST_ACTION;
	}
	
	
	/** 执行搜索 */
	public String queryList() {
		PageRequest<Map> pageRequest = newPageRequest(DEFAULT_SORT_COLUMNS);
		HttpServletRequest request = ServletActionContext.getRequest();
		//pageRequest.getFilters().put("key",value);     //add custom filter
		//pageRequest.setPageSize(20);
		String username ="";
		String deptid = "";
		String deptseq ="";
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
			
			

		//System.out.println("1111111111");
		if (request.getParameter("dept_seq") != null) {
			String dept_seq = request.getParameter("dept_seq");
			pageRequest.getFilters().put("deptseq", dept_seq);
			request.setAttribute("s_deptseq", dept_seq);
			
			//System.out.println("1111111111=dept_seq="+dept_seq);
		}
		
		if(request.getParameter("s_cpcode")!= null &&!request.getParameter("s_cpcode").equals("") ){
			pageRequest.getFilters().put("cpcode", request.getParameter("s_cpcode"));
		}
		
		

		
		
		Page page = temployeeManager.findByPageRequest(pageRequest);
		savePage(page,pageRequest);
		if(request.getParameter("fh")!=null)return "/pages/fjy/Temployee/staList.jsp";
		return QUERYLIST_JSP;
	}

	
	
	/** 执行搜索 */
	public String listAll() {
		PageRequest<Map> pageRequest = newPageRequest(DEFAULT_SORT_COLUMNS);
		HttpServletRequest request = ServletActionContext.getRequest();
		//pageRequest.getFilters().put("key",value);     //add custom filter
		String username ="";
		String deptid = "";
		String deptseq ="";
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
			
			
		
		String s_cpcode = "";
		if (request.getParameter("s_cpcode") != null) {
			s_cpcode = request.getParameter("s_cpcode");
			request.setAttribute("s_cpcode", s_cpcode);
			pageRequest.getFilters().put("deptseq", s_cpcode);
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
		
		//显示照片
		int picCount = 0;
		if (temployee != null && temployee.getEmpcode() != null) {
			picCount = ssCommonManager.getPicIDIsExist(temployee.getEmpcode());
		}
		Integer obj = new Integer(picCount);
		request.setAttribute("picCount", obj.toString());
		
		return SHOWALL_JSP;
	}
	
	/** 查看对象*/
	public String queryshow() {
		HttpServletRequest request = ServletActionContext.getRequest();
		String birth =  temployee.getBirth();
		String birthFormat = DateUtil.parseString(birth,"yyyyMMdd","yyyy-MM-dd");
		temployee.setBirth(birthFormat);
		
		//显示照片
		int picCount = 0;
		if (temployee != null && temployee.getEmpcode() != null) {
			picCount = ssCommonManager.getPicIDIsExist(temployee.getEmpcode());
		}
		Integer obj = new Integer(picCount);
		request.setAttribute("picCount", obj.toString());
		if(request.getParameter("fh")!=null)return "/pages/fjy/Temployee/staShow.jsp";
		return QUERYSHOW_JSP;
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
		
		
		String session_deptid = "";
		SecurityContext sc = SecurityContextHolder.getContext();
		Authentication auth = sc.getAuthentication();
		MyUserDetails ud = null;
		if ((auth != null) && auth.getPrincipal() instanceof MyUserDetails) {
			ud = (MyUserDetails) auth.getPrincipal();
			if (ud != null) {
				session_deptid = ud.getDeptID();
			}
		}
		HttpServletRequest request = ServletActionContext.getRequest();	
		String userid = "";
		if (request.getParameter("userid") != null)
			userid = request.getParameter("userid");
		
		if (userid != null && userid.length() > 0) {
			 rolemap = ssUserManager.findUserNoExistRole(session_deptid,Long.parseLong(userid));
			
		} else {
			 rolemap = ssUserManager.findDeptRole(session_deptid);
		}
		temployee.setCyrjzt("1");
		temployee.setPosition("11");
		temployee.setEnabled("1");
		
		return CREATEALL_JSP;
	}
	
	/** 保存新增对象 */
	public String saveAll() throws IOException {
		HttpServletRequest request = ServletActionContext.getRequest();
		
		
		
		
		String deptName = "";
		MyUserDetails userDetail = null;
		userDetail = SpringTagFunctions.getUserDetails();
		if (userDetail != null) {
			deptName = userDetail.getDeptName();
		}

		String username = "";
		if (request.getParameter("username") != null)
			username = request.getParameter("username");
		
		String password = "";
		if (request.getParameter("password") != null)
			password = request.getParameter("password");
		
		Long enabled = 1L;
		if (request.getParameter("enabled") != null)
			enabled = Long.parseLong(request.getParameter("enabled"));
		
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
		
		int idcardcount = temployeeManager.getCountByIdcard(new_IDCard,old_IDCard, temployee.getCpcode());
		if (idcardcount > 0) {
			request.setAttribute("message", "从业人员身份证信息已存在！");
			getProv();
			rolemap = ssUserManager.findDeptRole(deptID);
			return CREATEALL_JSP;// //LIST_ACTION;
		}

		int usernameCount = ssUserManager.getCountUserName(username);
		if (usernameCount > 0) {
			request.setAttribute("message", "用户名已存在！");
			getProv();
			rolemap = ssUserManager.findDeptRole(deptID);
			return CREATEALL_JSP;// //LIST_ACTION;
		}
		  
		Date date = new Date();
		SimpleDateFormat format = new SimpleDateFormat("yyyyMMddHHmmss");
		String currDate = format.format(date);

		SimpleDateFormat logformat = new SimpleDateFormat("yyyyMMdd");
		String currDatelog = logformat.format(date);

		SimpleDateFormat formatInsert = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String currDateInsert = formatInsert.format(date);

		temployee.setInserttimeString(currDateInsert);
		temployee.setEdittimeString(currDateInsert);

		String birthFormat = DateUtil.parseString(request, "birth","yyyy-MM-dd", "yyyyMMdd");
		temployee.setBirth(birthFormat);
		
		String empcode = deptID+currDate;
		temployee.setCpcode(deptID);
		temployee.setEmpcode(empcode);
		//temployeeManager.save(temployee);
		
		Long worklogid = temployeeManager.getEempworklogSeq();
		
		Tempworklog tempworklog = new Tempworklog();
		tempworklog.setCpcode(deptID);
		//tempworklog.setCpname(deptName);
		tempworklog.setDemo("添加从业人员附加");
		tempworklog.setEmpcode(empcode);
		tempworklog.setEmptype("20");
		tempworklog.setIndate(currDatelog);
		tempworklog.setWorklogid(worklogid);
		//tempworklogManager.save(tempworklog);
		
		SsUser  ssUser = new SsUser();
		ssUser.setUsername(username);
		ssUser.setPassword(cipher.generatePassword(temployee.getPassword()));
		ssUser.setEnabled(enabled);
		ssUser.setFullname(temployee.getEmpname());
		ssUser.setSex(temployee.getSex());
		ssUser.setSfzh(temployee.getPersonid());
		String deptID_long  = deptID;
		ssUser.setDeptid(deptID_long);
		
		
		Long userid = temployeeManager.getSsUserSeq();
		ssUser.setUserid(userid);
		temployee.setUserid(userid.toString());
		
		String[] selectRoles = request.getParameterValues("roles");// 选中角色
		
		BASE64Decoder decode = new BASE64Decoder(); 
//		String base64=request.getParameter("file")!=null?request.getParameter("file"):"";
		
		File uploadFile = null;
		InputStream uploadIs = null;
		byte[] uploadBytes= null;
		if(file != null && file.length() > 0 ){
			
			uploadIs = new FileInputStream(file);
		    uploadBytes =  (byte[])IOUtils.toByteArray(uploadIs);
		}
		
		//byte[] pic = decode.decodeBuffer(base64); 
		temployeeManager.saveEmployee(temployee, tempworklog, ssUser, selectRoles, empcode, userid, deptID,uploadBytes);
		
		return returnUrl;////LIST_ACTION;
	}
	
	/**进入更新页面*/
	public String editAll() {
		HttpServletRequest request = ServletActionContext.getRequest();
		
		
		String session_deptid = "";
		SecurityContext sc = SecurityContextHolder.getContext();
		Authentication auth = sc.getAuthentication();
		MyUserDetails ud = null;
		if ((auth != null) && auth.getPrincipal() instanceof MyUserDetails) {
			ud = (MyUserDetails) auth.getPrincipal();
			if (ud != null) {
				session_deptid = ud.getDeptID();
			}
		}
		
//		String userid = "";
//		if (request.getParameter("userid") != null)
//			userid = request.getParameter("userid");
		
		String message = "";
		if (request.getParameter("message") != null)
			message = request.getParameter("message");
		
		if (message != null && message.equals("1")) {
			request.setAttribute("message", "用户名已存在！");
		} else if (message != null && message.equals("2")) {
			request.setAttribute("message", "从业人员身份证信息已存在！");
		}
		
//		String deptID = "";
//		if(request.getParameter("cpcode") != null)
//			deptID = request.getParameter("cpcode");
	
	    // 所有旅馆角色
	     rolemap = ssUserManager.findDeptRole(session_deptid);
	   // 已有角色
		 List<SsRole>  rolelist = ssUserManager.findUserRole(Long.parseLong(temployee.getUserid()));
		 if(rolelist != null) {
			Set<SsRole> roles = new LinkedHashSet<SsRole>(rolelist);
			for (SsRole role : roles) {
				selectList.add(role.getRoleid());
		 }
		 }
	
		
//		String birth =  temployee.getBirth();
//		String birthFormat = DateUtil.parseString(birth,"yyyyMMdd","yyyy-MM-dd");
//		temployee.setBirth(birthFormat);
		
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
		
		String session_deptid = "";
		SecurityContext sc = SecurityContextHolder.getContext();
		Authentication auth = sc.getAuthentication();
		MyUserDetails ud = null;
		if ((auth != null) && auth.getPrincipal() instanceof MyUserDetails) {
			ud = (MyUserDetails) auth.getPrincipal();
			if (ud != null) {
				session_deptid = ud.getDeptID();
			}
		}
		
		String deptID = "";
		if(request.getParameter("cpcode") != null)
			deptID = request.getParameter("cpcode");
		
		String userid = "";
		if (request.getParameter("userid") != null)
			userid = request.getParameter("userid");
		
		String username = "";
		if (request.getParameter("username") != null)
			username = request.getParameter("username");
		
		String updateusername = "";
		if (request.getParameter("updateusername") != null)
			updateusername = request.getParameter("updateusername");
		
		String password = "";
		if (request.getParameter("password") != null)
			password = request.getParameter("password");
		
		Long enabled = 1L;
		if (request.getParameter("enabled") != null)
			enabled = Long.parseLong(request.getParameter("enabled"));
		
		
		String birthFormat = DateUtil.parseString(request,"birth","yyyy-MM-dd","yyyyMMdd");
		//temployee.setBirth(birthFormat);
		
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
		SsUser  ssUser = new SsUser();
		int usernameCount = 0;
		if (username != null && username.length() > 0) {
            if(updateusername != null && !username.equals(updateusername))
            	 usernameCount = ssUserManager.getCountUserName(updateusername);
		} else {
			if (updateusername != null && updateusername.length() > 0) 
			     usernameCount = ssUserManager.getCountUserName(updateusername);
		}
		if (usernameCount > 0) {
			request.setAttribute("message", "用户名已存在！");
			return editReturnUrl+"message=1";// //LIST_ACTION;
		} else {
				ssUser.setUsername(updateusername);
		}
		
		Temployee temployee2 = (Temployee)temployeeManager.getTemployeeById(temployee.getEmpcode());
		int   idcardcount = temployeeManager.getCountByIdcard(new_IDCard, old_IDCard,deptID);
		  if (idcardcount > 0 && !temployee2.getPersonid().equals(temployee.getPersonid())) {
				request.setAttribute("message","从业人员身份证信息已存在！");
				return editReturnUrl+"message=2";////LIST_ACTION;
		  }
		
		//temployeeManager.update(this.temployee);
		
		if(temployee != null && temployee.getCyrjzt() != null && temployee.getCyrjzt().equals("2")){
		SimpleDateFormat formatlzsj = new SimpleDateFormat("yyyyMMdd");
		String lzsj = formatlzsj.format(date);
		String empcode = temployee.getEmpcode();
		
		String  Sql = " update T_EMPWORKLOG set LEFTDATE = '"+lzsj+"' Where EMPCODE = '"+empcode+"' and CPCODE='"+deptID+"'";
		ssCommonManager.update(Sql);
		}
		
		
		
		//ssUser.setUsername(username);
		ssUser.setPassword(cipher.generatePassword(temployee.getPassword()));
		ssUser.setEnabled(enabled);
		ssUser.setFullname(temployee.getEmpname());
		ssUser.setSex(temployee.getSex());
		ssUser.setSfzh(temployee.getPersonid());
		ssUser.setUserid(Long.parseLong(userid));
		//temployeeManager.updateSsUser(ssUser);
		
		String[] selectRoles = request.getParameterValues("roles");// 选中角色
		temployeeManager.updateEmployee(temployee, ssUser, selectRoles, Long.parseLong(userid),deptID);
		
		return returnUrl ;
	}
	
	public String query(){
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

		dateSelectMap  = DateUtil.getDateSelectData();
		String dateSelect3 = "";
		if (request.getParameter("dateSelect3") != null)
		    dateSelect3 = request.getParameter("dateSelect3");
			request.setAttribute("dateSelect3",dateSelect3);		        
		String dateSelect20 = "";
		if (request.getParameter("dateSelect20") != null)
		    dateSelect20 = request.getParameter("dateSelect20");
			request.setAttribute("dateSelect20",dateSelect20);		        
		String dateSelect21 = "";
		if (request.getParameter("dateSelect21") != null)
		    dateSelect21 = request.getParameter("dateSelect21");
			request.setAttribute("dateSelect21",dateSelect21);		
			
		return QUERY_JSP;
	}
	
	
	
	public String tab() {
		HttpServletRequest request = ServletActionContext.getRequest();
		String birth =  temployee.getBirth();
		String birthFormat = DateUtil.parseString(birth,"yyyyMMdd","yyyy-MM-dd");
		temployee.setBirth(birthFormat);
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
				if (xh != null && xh.length() > 0) {
					int idCount = ssCommonManager.getPicIDIsExist(xh);
					if (idCount > 0)
						ssCommonManager.updatePic(file, file.length(), xh);
					else
						ssCommonManager.savePic(file, file.length(), xh);
				}
			}
			else{
				 request.setAttribute("message", "上传照片不能大于"+FilemaxSize+"字节"); 
				return	UPDATEPHOTOFAILURE ;
			}
		} catch (IOException e) {
			 request.setAttribute("message", "修改照片失败"); 
			return	UPDATEPHOTOFAILURE ;
		}
		return UPDATEPHOTOSUCCESS;
	}
	
	
	
	/** 执行搜索 */
	/**
	 * @return
	 * @throws Exception
	 */
	public String selectList() throws Exception{
		PageRequest<Map> pageRequest = newPageRequest(DEFAULT_SORT_COLUMNS);
		HttpServletRequest request = ServletActionContext.getRequest();
		//pageRequest.getFilters().put("key",value);     //add custom filter
		String ajax=request.getParameter("ajax");

		String diptId=request.getParameter("diptId");
		
		StringBuffer htmls=new StringBuffer();
		String session_deptid = "";
		int userId=0;
		SecurityContext sc = SecurityContextHolder.getContext();
		Authentication auth = sc.getAuthentication();
		MyUserDetails ud = null;
		if ((auth != null) && auth.getPrincipal() instanceof MyUserDetails) {
			ud = (MyUserDetails) auth.getPrincipal();
			if (ud != null) {
				session_deptid = ud.getDeptID();
				userId=ud.getUserId();
			}
		}
		List cyryList=temployeeManager.getCyry(session_deptid);
		System.out.println(String.valueOf(userId));
		htmls.append("<option>请选择</option>");
		
		for(int i=0;i<cyryList.size();i++){
			Map map=(Map)cyryList.get(i);
			htmls.append("<option ");
			htmls.append("value='"+map.get("EMPCODE").toString().trim()+"'");
			System.out.println(map.get("USERID"));
			if(String.valueOf(userId).equals(map.get("USERID"))){
				htmls.append(" selected='true' ");
			}
			htmls.append(">");

			htmls.append(map.get("EMPNAME"));
			htmls.append("</option>");
		}

		 String html = htmls.toString();
	        if (html == null) {
	            return null;
	        }
	        if(ajax!=null && ajax.equals("true")){
		        try {
		            byte[] contents = html.getBytes("UTF-8");
		            getResponse().getOutputStream().write(contents);
		        } catch (IOException e) {
		            e.printStackTrace();
		        }
		        return null;
	        }
	        return html;
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
	// 显示图片
	public String getPicture() {
		HttpServletRequest request = ServletActionContext.getRequest();
		String sql = request.getParameter("sql");
		if (sql != null && !sql .equals("")){
			List list = (List) temployeeManager.getPicture(sql);
			request.setAttribute("list", list);
		}
		return SHOW_PIC;
	}
	
	public List<SsRole> getRolemap() {
		return rolemap;
	}

	public void setRolemap(List<SsRole> rolemap) {
		this.rolemap = rolemap;
	}

	public List getSelectList() {
		return selectList;
	}

	public void setSelectList(List selectList) {
		this.selectList = selectList;
	}

	public String getSaveroleselected() {
		return saveroleselected;
	}

	public void setSaveroleselected(String saveroleselected) {
		this.saveroleselected = saveroleselected;
	}

	public String getEditReturnUrl() {
		return editReturnUrl;
	}

	public void setEditReturnUrl(String editReturnUrl) {
		this.editReturnUrl = editReturnUrl;
	}

}
