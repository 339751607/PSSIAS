
package com.dyneinfo.fjy.action;

import java.io.File;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.security.Key;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import javacommon.base.BaseStruts2Action;

import javax.crypto.Cipher;
import javax.servlet.http.HttpServletRequest;

import net.java.dev.common.dict.taglib.DictHelpImpl;
import net.java.dev.common.dict.taglib.Util;
import net.java.dev.common.util.DateUtil;
import net.java.dev.common.util.PropertiesFileConfigManager;
import net.java.dev.common.util.SpringTagFunctions;

import org.apache.commons.configuration.PropertiesConfiguration;
import org.apache.commons.lang.StringUtils;
import org.apache.struts2.ServletActionContext;
import org.security.userdetails.MyUserDetails;
import org.springframework.security.Authentication;
import org.springframework.security.context.SecurityContext;
import org.springframework.security.context.SecurityContextHolder;

import sun.misc.BASE64Decoder;
import cn.org.rapid_framework.page.Page;
import cn.org.rapid_framework.page.PageRequest;

import com.dyneinfo.fjy.model.Tcpinfo;
import com.dyneinfo.fjy.model.TcpinfoLog;
import com.dyneinfo.fjy.service.TcpinfoLogManager;
import com.dyneinfo.fjy.service.TcpinfoManager;
import com.dyneinfo.zazh.model.SsDept;
import com.dyneinfo.zazh.model.SsUser;
import com.dyneinfo.zazh.service.SsCommonManager;
import com.dyneinfo.zazh.service.SsDeptManager;
import com.dyneinfo.zazh.service.SsUserManager;
import com.dyneinfo.zazh.util.Encry;
import com.opensymphony.xwork2.ModelDriven;
import com.opensymphony.xwork2.Preparable;

/**
 * @author lisc email:lishicheng(a)gmail.com
 */


public class TcpinfoAction extends BaseStruts2Action implements Preparable,ModelDriven{
	//默认多列排序,example: username desc,createTime asc
	protected static final String DEFAULT_SORT_COLUMNS = null; 
	
	//forward paths
	protected static final String QUERY_JSP = "/pages/fjy/Tcpinfo/query.jsp";
	protected static final String LIST_JSP= "/pages/fjy/Tcpinfo/list.jsp";
	protected static final String QUERYLIST_JSP= "/pages/fjy/Tcpinfo/queryList.jsp";
	protected static final String CREATE_JSP = "/pages/fjy/Tcpinfo/create.jsp";
	protected static final String EDIT_JSP = "/pages/fjy/Tcpinfo/edit.jsp";
	protected static final String EDITUSER_JSP = "/pages/fjy/Tcpinfo/editUser.jsp";
	protected static final String SHOW_JSP = "/pages/fjy/Tcpinfo/show.jsp";
	protected static final String QUERYSHOW_JSP= "/pages/fjy/Tcpinfo/queryshow.jsp";
	protected static final String CPINFO_STA= "/pages/fjy/Tcpinfo/cpinfosta.jsp";
	//redirect paths,startWith: !
	protected static final String LIST_ACTION = "!/pages/fjy/Tcpinfo/list.do";
	
	
	private TcpinfoManager tcpinfoManager;
	private SsDeptManager ssDeptManager;
	private SsUserManager ssUserManager;
	private SsCommonManager ssCommonManager;
	private TcpinfoLogManager tcpinfoLogManager;
	private PropertiesFileConfigManager fileConfigManager;
	private Tcpinfo tcpinfo;
	java.lang.String id = null;
	private String[] items;
	private String returnUrl;  //返回列表，保留查询条件
	private TreeMap<String, String> dateSelectMap;// //日期选择
	private TcpinfoLog tcpinfoLog=new TcpinfoLog();
	private String deptid="";
	private int userid=0;
	private String username;
	private String deptseq;
    
	public void prepare() throws Exception {
		MyUserDetails userDetail = null;
		userDetail = SpringTagFunctions.getUserDetails();
		if (userDetail != null) {
			username = userDetail.getUserName();
			deptid = userDetail.getDeptID();
			userid = userDetail.getUserId();
			deptseq=userDetail.getDeptSeq();
			tcpinfoLog.setUsername(userDetail.getUserXm());
			tcpinfoLog.setDeptname(userDetail.getDeptName());
		}

		tcpinfoLog.setUserid(String.valueOf(userid));
		tcpinfoLog.setDeptid(deptid);
		if (isNullOrEmptyString(id)) {
			tcpinfo = new Tcpinfo();
			tcpinfoLog.setType("1");
		} else {
			tcpinfo = (Tcpinfo)tcpinfoManager.getTcpinfoById(id);
			tcpinfoLog.setCpcode(id);
			tcpinfoLog.setType("2");
		}
	}
	
	/** 增加setXXXX()方法,spring就可以通过autowire自动设置对象属性 */
	public void setTcpinfoManager(TcpinfoManager manager) {
		this.tcpinfoManager = manager;
	}	
	
	public void setSsDeptManager(SsDeptManager manager) {
		this.ssDeptManager = manager;
	}	
	
	public void setSsUserManager(SsUserManager manager) {
		this.ssUserManager = manager;
	}	
	
	public Object getModel() {
		return tcpinfo;
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

	
	 private static String decrypt(String path,String cryptograph) throws Exception{
	  	   /** 将文件中的私钥对象读出 */
	  	   ObjectInputStream ois = new ObjectInputStream(new FileInputStream(path));
	  	   Key key = (Key) ois.readObject();
	  	   /** 得到Cipher对象对已用公钥加密的数据进行RSA解密 */
	  	   Cipher cipher = Cipher.getInstance("RSA");
	  	   cipher.init(Cipher.DECRYPT_MODE, key);
	  	   BASE64Decoder decoder = new BASE64Decoder();
	  	   byte[] b1 = decoder.decodeBuffer(cryptograph);
	  	   /** 执行解密操作 */
	  	   byte[] b = cipher.doFinal(b1);
	  	   return new String(b);
	 }
	 
	public int count(){
		String license_key = "";
		String valid_time = "";
		String Remind_day = "";
		String dept_count = "";
		String Remind_dept_count = "";
		// 解密密文
		String de_license_key = "";
		String de_valid_time = "";
		String de_Remind_day = "";
		String de_dept_count = "";
		String de_Remind_dept_count = "";
		
		String path = "";
		this.fileConfigManager = PropertiesFileConfigManager.getInstance();

		try {
			license_key = this.fileConfigManager.getProperty("sys.license_key");
			valid_time = this.fileConfigManager.getProperty("sys.valid_time");
			Remind_day = this.fileConfigManager.getProperty("sys.Remind_day");
			dept_count = this.fileConfigManager.getProperty("sys.dept_count");
			Remind_dept_count = this.fileConfigManager.getProperty("sys.Remind_dept_count");
			
			File f = new PropertiesConfiguration("sys_config.properties").getFile();
			f = f.getParentFile();
			path = f.getAbsolutePath();
			System.out.println(path + "\\dyne\\PrivateKey");
			de_license_key = decrypt(path + "/dyne/PrivateKey", license_key);// 解密密文
			System.out.println("de_valid_time+++++++++++++++++++++++"+de_license_key);
			de_valid_time = decrypt(path + "/dyne/PrivateKey", valid_time);// 解密密文
			System.out.println("de_valid_time+++++++++++++++++++++++"+de_valid_time);
			de_Remind_day = decrypt(path + "/dyne/PrivateKey", Remind_day);// 解密密文
			System.out.println("de_Remind_day+++++++++++++++++++++++"+de_Remind_day);
			de_dept_count = decrypt(path + "/dyne/PrivateKey", dept_count);// 解密密文
			System.out.println("de_dept_count+++++++++++++++++++++++"+de_dept_count);
			de_Remind_dept_count = decrypt(path + "/dyne/PrivateKey", Remind_dept_count);// 解密密文
			System.out.println("de_Remind_dept_count+++++++++++++++++++++++"+de_Remind_dept_count);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Integer count=Integer.parseInt(de_dept_count);
		
		return count;
	}
	

	/** 执行搜索 */
	public String list() {
		PageRequest<Map> pageRequest = newPageRequest(DEFAULT_SORT_COLUMNS);
		HttpServletRequest request = ServletActionContext.getRequest();
		//pageRequest.getFilters().put("key",value);     //add custom filter
		

	
		if(SpringTagFunctions.ifAnyGranted("ROLE_QUERY_ALL,ROLE_ADMIN")){
			
		} else if(SpringTagFunctions.ifAnyGranted("ROLE_QUERY_CURRENT_ORG")){
			pageRequest.getFilters().put("cpcode",deptid);
		} else if(SpringTagFunctions.ifAnyGranted("ROLE_QUERY_CHILD_ORG")){
			pageRequest.getFilters().put("deptSeq",deptseq);
		} else {
			pageRequest.getFilters().put("deptSeq",deptseq);
		}
		
		
		
		dateSelectMap  = DateUtil.getDateSelectData();
		String s_sspcs = "";
		if (request.getParameter("s_sspcs") != null){
			s_sspcs = request.getParameter("s_sspcs");
			request.setAttribute("s_sspcs",s_sspcs);	
			pageRequest.getFilters().put("sspcs",s_sspcs);
		}	        
		
		
		
		String dateSelect17 = "";
		if (request.getParameter("dateSelect17") != null)
		    dateSelect17 = request.getParameter("dateSelect17");
			request.setAttribute("dateSelect17",dateSelect17);		        
		String s_zcrqBeginFormat = DateUtil.parseString(request,"s_zcrqBegin","yyyy-MM-dd","yyyyMMdd");
		String s_zcrqEndFormat = DateUtil.parseString(request,"s_zcrqEnd","yyyy-MM-dd","yyyyMMdd");
		pageRequest.getFilters().put("zcrqBeginFormat",s_zcrqBeginFormat);
		pageRequest.getFilters().put("zcrqEndFormat",s_zcrqEndFormat);
		
		Page page = tcpinfoManager.findByPageRequest(pageRequest);
		//System.out.println(page);
		request.setAttribute("count", count());
		request.setAttribute("qyjs", page.getTotalCount());
		savePage(page,pageRequest);
		return LIST_JSP;
	}
	/** 执行搜索 */
	public String queryList() {
		PageRequest<Map> pageRequest = newPageRequest(DEFAULT_SORT_COLUMNS);
		HttpServletRequest request = ServletActionContext.getRequest();
		//pageRequest.getFilters().put("key",value);     //add custom filter
		

		
		if(SpringTagFunctions.ifAnyGranted("ROLE_QUERY_ALL,ROLE_ADMIN")){
			
		} else if(SpringTagFunctions.ifAnyGranted("ROLE_QUERY_CURRENT_ORG")){
			pageRequest.getFilters().put("cpcode",deptid);
		} else if(SpringTagFunctions.ifAnyGranted("ROLE_QUERY_CHILD_ORG")){
			pageRequest.getFilters().put("deptSeq",deptseq);
		} else {
			pageRequest.getFilters().put("deptSeq",deptseq);
		}
		
		
		
		dateSelectMap  = DateUtil.getDateSelectData();
		String s_sspcs = "";
		if (request.getParameter("s_sspcs") != null){
			s_sspcs = request.getParameter("s_sspcs");
			request.setAttribute("s_sspcs",s_sspcs);	
			pageRequest.getFilters().put("sspcs",s_sspcs);
		}
		
			
	        
		String s_kysjBeginFormat = DateUtil.parseString(request,"s_kysjBegin","yyyy-MM-dd","yyyyMMdd");
		String s_kysjEndFormat = DateUtil.parseString(request,"s_kysjEnd","yyyy-MM-dd","yyyyMMdd");
		pageRequest.getFilters().put("kysjBeginFormat",s_kysjBeginFormat);
		pageRequest.getFilters().put("kysjEndFormat",s_kysjEndFormat);
		String s_stategbsjBeginFormat = DateUtil.parseString(request,"s_stategbsjBegin","yyyy-MM-dd","yyyyMMdd");
		String s_stategbsjEndFormat = DateUtil.parseString(request,"s_stategbsjEnd","yyyy-MM-dd","yyyyMMdd");
		pageRequest.getFilters().put("stategbsjBeginFormat",s_stategbsjBeginFormat);
		pageRequest.getFilters().put("stategbsjEndFormat",s_stategbsjEndFormat);
		
		
		
		Page page = tcpinfoManager.findByPageRequest(pageRequest);
		savePage(page,pageRequest);
		return QUERYLIST_JSP;
	}
	
	/** 查看对象*/
	public String show() {
		HttpServletRequest request = ServletActionContext.getRequest();
		String kysj =  tcpinfo.getKysj();
		String kysjFormat = DateUtil.parseString(kysj,"yyyyMMdd","yyyy-MM-dd");
		tcpinfo.setKysj(kysjFormat);
		String zcrq =  tcpinfo.getZcrq();
		String zcrqFormat = DateUtil.parseString(zcrq,"yyyyMMdd","yyyy-MM-dd");
		tcpinfo.setZcrq(zcrqFormat);
		String cpcode = "";
        if(tcpinfo != null && tcpinfo.getCpcode() != null)   
        	cpcode = tcpinfo.getCpcode();
		String sql = "select u.fullname ,t.deptname from ss_user u ,ss_dept t where u.deptid=t.deptid and u.userid="+tcpinfo.getCreateuserid();
		List staList = tcpinfoManager.getCpinfoFzr(sql);
		String username = "";
		String deptname="";
		if (staList != null) {
			for (int j = 0; j < staList.size(); j++) {
				Map staResults = (HashMap) staList.get(j);
				username = (String) staResults.get("username");
				deptname=(String)staResults.get("deptname");
				
			}
		}
		SecurityContext sc = SecurityContextHolder.getContext();
		Authentication auth = sc.getAuthentication();
		MyUserDetails ud = null;
		if ((auth != null) && auth.getPrincipal() instanceof MyUserDetails) {
			ud = (MyUserDetails) auth.getPrincipal();
			if (ud != null) {
				request.setAttribute("deptid", ud.getDeptID());
			}
		}
		tcpinfo.setCreateuserid(username);
		tcpinfo.setCreatedeptid(deptname);
		String getcyrysql = "select   t.empname,t.userid   from t_employee t  where t.cpcode ='"+cpcode.trim()+"' and t.cyrjzt<>2 ";
		List cyryList = tcpinfoManager.getCpinfoFzr(getcyrysql);
		int cyrs=0;
		if(!cyryList.isEmpty()){
			cyrs=cyryList.size();
		}
		String fj="";
		String pcs="";
		String detpname ="";
		String fjname="";
		detpname =ssCommonManager.getDeptFullNameByDeptId12(tcpinfo.getSspcs());
		if(detpname != null &&!detpname.equals("")){
			String x [] =detpname.split(",");
			int i = x.length;
			fjname = x[i-1];
		
			
		}
		tcpinfo.setDeptname(fjname);
		String deptcode = ssCommonManager.getDeptFullNameByDeptId11(tcpinfo.getSspcs());
		if(deptcode != null &&!deptcode.equals("")){
			String x [] =deptcode.split(",");
			int i = x.length;
			pcs = x[i-1];
			fj=x[i-2];
			
		}
		request.setAttribute("pcs", pcs);
		request.setAttribute("fj", fj);
		tcpinfo.setCyrs(cyrs);
		return SHOW_JSP;
	}
	/** 查看对象*/
	public String queryshow() {
		HttpServletRequest request = ServletActionContext.getRequest();
		String kysj =  tcpinfo.getKysj();
		String kysjFormat = DateUtil.parseString(kysj,"yyyyMMdd","yyyy-MM-dd");
		tcpinfo.setKysj(kysjFormat);
		String zcrq =  tcpinfo.getZcrq();
		String zcrqFormat = DateUtil.parseString(zcrq,"yyyyMMdd","yyyy-MM-dd");
		tcpinfo.setZcrq(zcrqFormat);
		String cpcode = "";
        if(tcpinfo != null && tcpinfo.getCpcode() != null)   
        	cpcode = tcpinfo.getCpcode();
		String sql = "select u.fullname ,t.deptname from ss_user u ,ss_dept t where u.deptid=t.deptid and u.userid="+tcpinfo.getCreateuserid();
		List staList = tcpinfoManager.getCpinfoFzr(sql);
		String username = "";
		String deptname="";
		if (staList != null) {
			for (int j = 0; j < staList.size(); j++) {
				Map staResults = (HashMap) staList.get(j);
				username = (String) staResults.get("username");
				deptname=(String)staResults.get("deptname");
			}
		}
		SecurityContext sc = SecurityContextHolder.getContext();
		Authentication auth = sc.getAuthentication();
		MyUserDetails ud = null;
		if ((auth != null) && auth.getPrincipal() instanceof MyUserDetails) {
			ud = (MyUserDetails) auth.getPrincipal();
			if (ud != null) {
				request.setAttribute("deptid", ud.getDeptID());
			}
		}
		tcpinfo.setCreateuserid(username);
		tcpinfo.setCreatedeptid(deptname);
		
		String getcyrysql = "select  t.empname,t.userid   from t_employee t  where t.cpcode ='"+cpcode.trim()+"' and t.cyrjzt<>2 ";
		List cyryList = tcpinfoManager.getCpinfoFzr(getcyrysql);
		int cyrs=0;
		if(!cyryList.isEmpty()){
			cyrs=cyryList.size();
		}


		tcpinfo.setDeptname(ssCommonManager.getDeptFullNameByDeptId(tcpinfo.getSspcs()));
		
		tcpinfo.setCyrs(cyrs);
		return QUERYSHOW_JSP;
	}
	/** 进入新增页面*/
	public String create() {
		tcpinfo.setCpstate("1");
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
		return CREATE_JSP;
	}
	
	
	/** 保存新增对象 */
	public String save() {
		HttpServletRequest request = ServletActionContext.getRequest();
		
		String fjid="";
		if(request.getParameter("fjid") != null){
			fjid = request.getParameter("fjid");
		}
		String cptype = "";
		String	cpcodeMauID = "";
		if(request.getParameter("cptype") != null)
			cptype = request.getParameter("cptype");
		

//		tcpinfo.setCreateuserid(String.valueOf(userid));
//		tcpinfo.setCreatedeptid(deptid);
		String fjCodePreSix = "fjid";
		if(fjid != null && fjid.length() >=6)
			fjCodePreSix = fjid.substring(0, 6);
		
		
		String start_char = "", str_end_char = "";

		String maxID = "";
		start_char =   fjCodePreSix;
		String sqlzjz ="select value from t_config where code='E02'";  //从配置库中读取信息
		String qybmzjz = tcpinfoManager.getCurrentMax(sqlzjz);
		String max_end_char =qybmzjz+ "000";
		String sql = "select max(CPCODE) from T_CPINFO where CPCODE like '"+start_char+"%' ";
		maxID = tcpinfoManager.getCurrentMax(sql);
		if (maxID != null && maxID.length() > 0) {
			max_end_char = maxID.substring(start_char.length());
		}
		int i_max_end_char = Integer.parseInt(max_end_char);
		i_max_end_char = i_max_end_char + 1;
		Integer obj = new Integer(i_max_end_char);
		str_end_char = Util.padString(obj.toString(), 4, "0", true);
		
		cpcodeMauID = start_char + str_end_char;
		
		
		if(cptype != null && cptype.length() > 0){
			int cpcodeCount = tcpinfoManager.getCountCpcode(cpcodeMauID);
			int deptCount = tcpinfoManager.getCountDept(cpcodeMauID);

			if(cpcodeCount > 0 || deptCount > 0 ){
				request.setAttribute("message", "企业代码已存在"); 
				return CREATE_JSP;
			} else {
				SsDept ssDept = new SsDept();
				String depPath = "";
				int level = 0;
				String parentId="";
				if(tcpinfo.getSspcs()!=null&&!tcpinfo.getSspcs().trim().equals(""))
					parentId= tcpinfo.getSspcs();
				java.lang.String parentIds = new java.lang.String(parentId);
				
				
				tcpinfo.setCpcode(cpcodeMauID);
				Date date = new Date();
				SimpleDateFormat format_inserttime = new SimpleDateFormat("yyyyMMdd");
		        String zcrqFormat = format_inserttime.format(date);
		        tcpinfo.setZcrq(zcrqFormat);
		        
				String kysjFormat = DateUtil.parseString(request,"kysj","yyyy-MM-dd","yyyyMMdd");
				tcpinfo.setKysj(kysjFormat);
				
				tcpinfo.setCreatedeptid(deptid);
				tcpinfo.setCreateuserid(String.valueOf(userid));
				
				tcpinfoManager.save(tcpinfo);
			
				//保存部门信息
				SsDept ssDeptSearch = (SsDept) ssDeptManager.getById(parentIds);
				depPath = ssDeptSearch.getDeptseq();
				level = ssDeptSearch.getDeptlevel();
				java.lang.Long displayorder = new java.lang.Long(0);
				ssDept.setDisplayorder(displayorder);
				ssDept.setDeptlevel(level + 1);
				ssDept.setParentid(parentIds);
				depPath += cpcodeMauID + ".";
				ssDept.setDeptseq(depPath);
				ssDept.setDeptid(cpcodeMauID);
				ssDept.setDepttypeid(tcpinfo.getCptype());
				ssDept.setStatus("1");
				ssDept.setDeptname(tcpinfo.getCpname());
				ssDept.setDeptdesc(tcpinfo.getCpname());
				
				
				//保存日志
				tcpinfoLog.setCpcode(tcpinfo.getCpcode());
				
//				tcpinfoLogManager.save(tcpinfoLog);
				
				ssDeptManager.saveWithAssigned(ssDept);//增加
				SsUser user=new SsUser();
				user.setUsername(tcpinfo.getCpcode());
				user.setPassword("e10adc3949ba59abbe56e057f20f883e");
				user.setDeptid(tcpinfo.getCpcode());
				user.setFullname("企业管理员");
				user.setEnabled(Long.parseLong("1"));
				user.setCreatedate(new java.sql.Date(date.getTime()));
				ssUserManager.save(user);
//				ssUserManager.insertRoleUser(121, user.getUserid());
				
//				if (tcpinfo != null && tcpinfo.getCptype() != null && tcpinfo.getCptype().equals("E02")) {
//					//废旧业
//					tcpinfoManager.insertDeptRole("1121", cpcodeMauID);
//					tcpinfoManager.insertDeptRole("1141", cpcodeMauID);
//				} else if (tcpinfo != null && tcpinfo.getCptype() != null
//						&& tcpinfo.getCptype().equals("E03")) {
//					//二手手机
//					tcpinfoManager.insertDeptRole("140", cpcodeMauID);
//					tcpinfoManager.insertDeptRole("180", cpcodeMauID);
//				} else if (tcpinfo != null && tcpinfo.getCptype() != null
//						&& tcpinfo.getCptype().equals("E04")) {
//					//二手电脑
//					tcpinfoManager.insertDeptRole("122", cpcodeMauID);
//					tcpinfoManager.insertDeptRole("142", cpcodeMauID);
//				}
				
				
			}
		}
		
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
				request.setAttribute("deptseq", ud.getDeptSeq());
				request.setAttribute("deptname",ud.getDeptName());
				request.setAttribute("deptid", session_deptid);
			}
		};
		String userType=request.getParameter("type")!=null?request.getParameter("type"):"";
		if(userType!=null&&userType.equals("user")){
			tcpinfo=(Tcpinfo)tcpinfoManager.getTcpinfoById(session_deptid);			
		}

		String kysj =  tcpinfo.getKysj();
		String kysjFormat = DateUtil.parseString(kysj,"yyyyMMdd","yyyy-MM-dd");
		tcpinfo.setKysj(kysjFormat);
		String zcrq =  tcpinfo.getZcrq();
		String zcrqFormat = DateUtil.parseString(zcrq,"yyyyMMdd","yyyy-MM-dd");
		tcpinfo.setZcrq(zcrqFormat);
		tcpinfo.setDeptname(ssCommonManager.getDeptFullNameByDeptId(tcpinfo.getSspcs()));
		if(userType!=null&&userType.equals("user")){
			return EDITUSER_JSP;
		}
		System.out.println(tcpinfo.getCpcode());
		request.setAttribute("deptseq", ssCommonManager.getDeptDeptseq(tcpinfo.getCpcode()));
		return EDIT_JSP;
	}
	
	
	/**保存更新对象*/
	public String update() {
		HttpServletRequest request = ServletActionContext.getRequest();
		
		String sspcs = "-1";
		String long_ref ="";
	
		String kysjFormat = DateUtil.parseString(request,"kysj","yyyy-MM-dd","yyyyMMdd");
		if(kysjFormat!=null&&!kysjFormat.equals(""))
		tcpinfo.setKysj(kysjFormat);
		String zcrqFormat = DateUtil.parseString(request,"zcrq","yyyy-MM-dd","yyyyMMdd");
		if(zcrqFormat!=null&&!zcrqFormat.equals(""))
		tcpinfo.setZcrq(zcrqFormat);
		
		if(tcpinfo.getStategbsj()!=null&!tcpinfo.getStategbsj().equals("")){
			java.text.SimpleDateFormat dateformat = new java.text.SimpleDateFormat("yyyyMMdd");
			tcpinfo.setStategbsj(dateformat.format(new Date()));
		}
		
		
		tcpinfoManager.update(this.tcpinfo);
		//保存日志
		tcpinfoLogManager.save(tcpinfoLog);
		if(tcpinfo.getCpstate()!=null&&!tcpinfo.getCpstate().equals("1")){
			

			ssUserManager.updateByDeptid(tcpinfo.getCpcode(),"0");
		}else{

			ssUserManager.updateByDeptid(tcpinfo.getCpcode(),"1");
		}
		if(request.getParameter("sspcs") != null){
			sspcs = (String)request.getParameter("sspcs");
			if (StringUtils.isNotEmpty(sspcs)){
				long_ref = sspcs;
			}
			String cpcode = "";
			String long_cpcode = "";
			if(request.getParameter("cpcode") != null){
				cpcode = (String)request.getParameter("cpcode");
			}
			if (StringUtils.isNotEmpty(cpcode))
				long_cpcode = cpcode;
			SsDept department = (SsDept) ssDeptManager.getById(long_ref);
			
		
			String deptid = department.getDeptid();
			int reftLevel = department.getDeptlevel();
			String refSEQ = department.getDeptseq();
			String parentid = department.getParentid();
			String deptseq = refSEQ.concat(cpcode + ".");
			
			SsDept dept = new SsDept();
			dept.setDeptid(long_cpcode);
			dept.setDeptlevel((reftLevel+1));
			dept.setDisplayorder(1L);
			dept.setDeptseq(deptseq);
			dept.setParentid(long_ref);
			ssDeptManager.updateSrcDept(dept);
		}
		
		return returnUrl;////LIST_ACTION;
	}
	
	public String query(){
		PageRequest<Map> pageRequest = newPageRequest(DEFAULT_SORT_COLUMNS);
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
		String dateSelect14 = "";
		if (request.getParameter("dateSelect14") != null)
			dateSelect14 = request.getParameter("dateSelect14");
			request.setAttribute("dateSelect14",dateSelect14);		        

			
		return QUERY_JSP;
	}

	public void setSsCommonManager(SsCommonManager ssCommonManager) {
		this.ssCommonManager = ssCommonManager;
	}
	
	public String cpinfoSta(){
		SecurityContext sc = SecurityContextHolder.getContext();
		Authentication auth = sc.getAuthentication();
		String deptseq="";
		MyUserDetails ud = null;
		if ((auth != null) && auth.getPrincipal() instanceof MyUserDetails) {
			ud = (MyUserDetails) auth.getPrincipal();
			if (ud != null) {
				deptseq=ud.getDeptSeq();
			
			}
		}
		HttpServletRequest request = ServletActionContext.getRequest();
		
		
		String s_deptseq="";
		int level= 2;
		if(request.getParameter("s_deptseq") != null){
			  s_deptseq = request.getParameter("s_deptseq");
			String [] ss = s_deptseq.split("\\.");
			if(ss != null )
				level = ss.length-1;
		}  else {
			s_deptseq = deptseq;
			String [] ss = s_deptseq.split("\\.");
			if(ss != null )
				level = ss.length-1;
		}
		if(level <2)
			level =2;
//		request.setAttribute("deptseq", deptseq);
		String sql="select deptname,yysl,qdsl,azs,sumSl from v_cpinfo_sta where  deptLevel = '"+level+"' and  deptseq like '"+s_deptseq+"%'";
		
		List staList = tcpinfoManager.getCpinfoSta(sql);

		if(staList.size()>15)request.setAttribute("scro", "scro");
		String deptname = "",yysl = "", qdsl = "", azs ="",sumSl = "";
		StringBuffer staXML=new StringBuffer();
		staXML.append("<graph xaxisname='所属区域' yaxisname='数量' hovercapbg='DEDEBE' hovercapborder='889E6D' rotateNames='0'  numdivlines='9' baseFontSize='12' divLineColor='CCCCCC' divLineAlpha='80' decimalPrecision='0' showAlternateHGridColor='1' AlternateHGridAlpha='30' plotSpacePercent='20' AlternateHGridColor='CCCCCC' caption='企业信息统计图'  >");
		StringBuffer categories=new StringBuffer("<categories font='Arial' fontSize='12' fontColor='000000'>");
		StringBuffer dataset_sumSl=new StringBuffer("<dataset seriesname='企业总数' color='56B9F9'>");
		StringBuffer dataset_yysl=new StringBuffer("<dataset seriesname='营业企业' color='FDC12E'>");
		StringBuffer dataset_qdsl=new StringBuffer("<dataset seriesname='取缔企业' color='FF0033' >");
		StringBuffer dataset_azs=new StringBuffer("<dataset seriesname='已安系统' color='33FF66' >");
		if (staList != null) {
			for (int j = 0; j < staList.size(); j++) {
				Map staResults = (HashMap) staList.get(j);
				deptname = (String) staResults.get("deptname");
				yysl=(String)staResults.get("yysl");
				qdsl = (String) staResults.get("qdsl");
				azs = (String) staResults.get("azs");
				sumSl = (String) staResults.get("sumSl");
				
				categories.append("<category name='"+deptname+"' />");
				dataset_sumSl.append(" <set value='"+sumSl+"' />");
				dataset_yysl.append(" <set value='"+yysl+"' />");
				dataset_qdsl.append(" <set value='"+qdsl+"' />");
				dataset_azs.append(" <set value='"+azs+"' />");
			}
		}
		categories.append("</categories>");
		dataset_sumSl.append("</dataset>");
		dataset_yysl.append("</dataset>");
		dataset_qdsl.append("</dataset>");
		dataset_azs.append("</dataset>");
		staXML.append(categories);
		staXML.append(dataset_sumSl);
		staXML.append(dataset_yysl);
		staXML.append(dataset_qdsl);
		staXML.append(dataset_azs);
		staXML.append("</graph>");
		
		request.setAttribute("strXML",staXML.toString());
		return CPINFO_STA;
	}

	public void setTcpinfoLogManager(TcpinfoLogManager tcpinfoLogManager) {
		this.tcpinfoLogManager = tcpinfoLogManager;
	}
	public String cariscode(){
		HttpServletRequest request = ServletActionContext.getRequest();
		String code = request.getParameter("cpcode");
		tcpinfo=tcpinfoManager.getById(code);
		request.setAttribute("cpcode", code);
		
		return "/pages/fjy/Tcpinfo/include_iscpde.jsp";
		
	}
	
	/**
	 * 添加授权码
	 * 
	 * @return
	 */
	public String saveiscode() {
		HttpServletRequest request = ServletActionContext.getRequest();
		String code = request.getParameter("cp");
		request.setAttribute("cpcode", code);
		String iscode = request.getParameter("iscode");
		String typecode = "";
		String orcmmcode = "";
		String jmType = (String) DictHelpImpl.getInitData("jmType");
		if (request.getParameter("typecode") != null) {
			typecode = request.getParameter("typecode");
		}

		Encry en = new Encry();
		String re = "";
		if ("1".equals(jmType)) {
			re = en.crypt_pwd("e", "efficiently", iscode);
		} else {
			re = en.crypt_pwd("e", "bslogyes", iscode);
		}
		if (!re.equals(code)) {
			request.setAttribute("message", "软件授权码不正确");
			return "/pages/fjy/Tcpinfo/include_iscpde.jsp";
		}

		if (typecode != null && !typecode.equals("")) {

			String type = "";
			if ("1".equals(jmType)) {
				type = en.crypt_pwd("e", "actively", typecode);
			} else {
				type = en.crypt_pwd("e", "bsdkyes", typecode);
			}
			if (!type.equals(code)) {
				request.setAttribute("message", "读卡器授权码不正确");
				return "/pages/fjy/Tcpinfo/include_iscpde.jsp";
			}
			tcpinfo.setTypecode(typecode);
		}

		if (null != request.getParameter("orcmmcode")
				&& !"".equals(request.getParameter("orcmmcode"))) { // 扫描仪授权
			orcmmcode = request.getParameter("orcmmcode");
		}
		if (orcmmcode != null && !"".equals(orcmmcode)) { // 扫描仪授权码

			String orcmm = "";
			if ("1".equals(jmType)) {
				orcmm = en.crypt_pwd("e", "energetically", orcmmcode);
			} else {
				orcmm = en.crypt_pwd("e", "smyesok", orcmmcode);
			}
			if (!orcmm.equals(code)) {
				request.setAttribute("message", "扫描仪授权码不正确");
				return "/pages/fjy/Tcpinfo/include_iscpde.jsp";
			}
			tcpinfo.setOrcmmcode(orcmmcode);
		}

		tcpinfo.setCpcode(code);
		tcpinfo.setIscode(iscode);

		tcpinfoManager.insertiscode(tcpinfo);

		return returnUrl;

	}

}
