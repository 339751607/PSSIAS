/*
 * Powered By [lishicheng]
 */

package com.dyneinfo.jxy.action;

import javax.crypto.Cipher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cn.org.rapid_framework.beanutils.BeanUtils;

import com.opensymphony.xwork2.Preparable;
import com.opensymphony.xwork2.ModelDriven;

import org.security.userdetails.MyUserDetails;
import org.springframework.security.Authentication;
import org.springframework.security.context.SecurityContext;
import org.springframework.security.context.SecurityContextHolder;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.security.Key;
import java.text.SimpleDateFormat;

import net.java.dev.common.dict.taglib.DictHelpImpl;
import net.java.dev.common.util.DateUtil;
import net.java.dev.common.util.PropertiesFileConfigManager;

import org.apache.commons.configuration.PropertiesConfiguration;
import org.apache.commons.lang.StringUtils;
import org.apache.struts2.ServletActionContext;

import sun.misc.BASE64Decoder;

import java.util.*;

import javacommon.base.*;
import javacommon.util.*;

import cn.org.rapid_framework.util.*;
import cn.org.rapid_framework.web.util.*;
import cn.org.rapid_framework.page.*;
import cn.org.rapid_framework.page.impl.*;

import com.dyneinfo.jxy.dao.*;
import com.dyneinfo.jxy.model.*;
import com.dyneinfo.jxy.service.*;
import com.dyneinfo.zazh.model.SsDept;
import com.dyneinfo.zazh.model.SsUser;
import com.dyneinfo.zazh.service.SsDeptManager;
import com.dyneinfo.zazh.service.SsUserManager;
import com.dyneinfo.zazh.util.Encry;

/**
 * @author lisc email:lishicheng(a)gmail.com
 */


public class TcpinfoAction extends BaseStruts2Action implements Preparable,ModelDriven{
	//默认多列排序,example: username desc,createTime asc
	protected static final String DEFAULT_SORT_COLUMNS = null; 
	
	//forward paths
	protected static final String QUERY_JSP = "/pages/jxy/Tcpinfo/query.jsp";
	protected static final String LIST_JSP= "/pages/jxy/Tcpinfo/list.jsp";
	protected static final String QUERYLIST_JSP= "/pages/jxy/Tcpinfo/queryList.jsp";
	protected static final String CREATE_JSP = "/pages/jxy/Tcpinfo/create.jsp";
	protected static final String EDIT_JSP = "/pages/jxy/Tcpinfo/edit.jsp";
	protected static final String SHOW_JSP = "/pages/jxy/Tcpinfo/show.jsp";
	protected static final String LISTNSJL_JSP= "/pages/jxy/Tcpinfo/listnsjl.jsp";
	//redirect paths,startWith: !
	protected static final String LIST_ACTION = "!/jxy/Tcpinfo/list.do";
	
	private TcpinfojxyManager tcpinfojxyManager;
	private SsDeptManager ssDeptManager;
	private SsUserManager ssUserManager;
	private PropertiesFileConfigManager fileConfigManager;
	
	private Tcpinfo tcpinfo;
	java.lang.String id = null;
	private String[] items;
	private String returnUrl;  //返回列表，保留查询条件
	private TreeMap<String, String> dateSelectMap;// //日期选择

	public void prepare() throws Exception {
		HttpServletRequest request = ServletActionContext.getRequest();
		DateUtil tt = new DateUtil();   
		
	    request.setAttribute("date", tt.getNowTime("yyyy-MM-dd"));
		
		
		if (isNullOrEmptyString(id)) {
			tcpinfo = new Tcpinfo();
		} else {
			tcpinfo = (Tcpinfo)tcpinfojxyManager.getById(id);
		}
		this.fileConfigManager = PropertiesFileConfigManager.getInstance();
	}
	
	/** 增加setXXXX()方法,spring就可以通过autowire自动设置对象属性 */
	public void setTcpinfojxyManager(TcpinfojxyManager manager) {
		this.tcpinfojxyManager = manager;
	}
	
	public void setSsDeptManager(SsDeptManager ssDeptManager) {
		this.ssDeptManager = ssDeptManager;
	}

	public void setSsUserManager(SsUserManager ssUserManager) {
		this.ssUserManager = ssUserManager;
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
	@SuppressWarnings("unchecked")
	public String list() {
		PageRequest<Map> pageRequest = newPageRequest(DEFAULT_SORT_COLUMNS);
		HttpServletRequest request = ServletActionContext.getRequest();
		//pageRequest.getFilters().put("key",value);     //add custom filter
		
        SecurityContext sc = SecurityContextHolder.getContext();
        Authentication auth = sc.getAuthentication();
        MyUserDetails ud = null;
		String username = "";
		String deptid = "";
		String deptseq = "";
		if ((auth != null) && auth.getPrincipal() instanceof MyUserDetails) {
			ud = (MyUserDetails) auth.getPrincipal();
			if (ud != null) {
				username = ud.getUserName();
				deptid = ud.getDeptID();
				deptseq=ud.getDeptSeq();
			}
		}	
		if(request.getParameter("s_deptseq") == null ||request.getParameter("s_rowname")== null|| "".equals(request.getParameter("s_rowname"))){
			pageRequest.getFilters().put("deptseq",deptseq);
		}
		dateSelectMap  = DateUtil.getDateSelectData();
		String dateSelect7 = "";
		if (request.getParameter("dateSelect7") != null)
		    dateSelect7 = request.getParameter("dateSelect7");
			request.setAttribute("dateSelect7",dateSelect7);		        
		String s_startdateBeginFormat = DateUtil.parseString(request,"s_startdateBegin","yyyy-MM-dd","yyyyMMdd");
		String s_startdateEndFormat = DateUtil.parseString(request,"s_startdateEnd","yyyy-MM-dd","yyyyMMdd");
		pageRequest.getFilters().put("startdateBeginFormat",s_startdateBeginFormat);
		pageRequest.getFilters().put("startdateEndFormat",s_startdateEndFormat);
		String dateSelect17 = "";
		if (request.getParameter("dateSelect17") != null)
		    dateSelect17 = request.getParameter("dateSelect17");
			request.setAttribute("dateSelect17",dateSelect17);		        
		String s_basjBeginFormat = DateUtil.parseString(request,"s_basjBegin","yyyy-MM-dd","yyyyMMdd");
		String s_basjEndFormat = DateUtil.parseString(request,"s_basjEnd","yyyy-MM-dd","yyyyMMdd");
		pageRequest.getFilters().put("basjBeginFormat",s_basjBeginFormat);
		pageRequest.getFilters().put("basjEndFormat",s_basjEndFormat);
		
		Page page = tcpinfojxyManager.findByPageRequest(pageRequest);
		
		savePage(page,pageRequest);
		return LIST_JSP;
	}
	/** 执行搜索 */
	@SuppressWarnings("unchecked")
	public String queryList() {
		PageRequest<Map> pageRequest = newPageRequest(DEFAULT_SORT_COLUMNS);
		HttpServletRequest request = ServletActionContext.getRequest();
		//pageRequest.getFilters().put("key",value);     //add custom filter
		
		SecurityContext sc = SecurityContextHolder.getContext();
		Authentication auth = sc.getAuthentication();
		MyUserDetails ud = null;
		String username = "";
		String deptid = "";
		String deptseq = "";
		if ((auth != null) && auth.getPrincipal() instanceof MyUserDetails) {
			ud = (MyUserDetails) auth.getPrincipal();
			if (ud != null) {
				username = ud.getUserName();
				deptid = ud.getDeptID();
				deptseq=ud.getDeptSeq();
			}
		}	
		if(request.getParameter("s_deptseq") == null ||request.getParameter("s_rowname")== null|| "".equals(request.getParameter("s_rowname"))){
			pageRequest.getFilters().put("deptseq",deptseq);
		}
		dateSelectMap  = DateUtil.getDateSelectData();
		String dateSelect7 = "";
		if (request.getParameter("dateSelect7") != null)
			dateSelect7 = request.getParameter("dateSelect7");
		request.setAttribute("dateSelect7",dateSelect7);		        
		String s_startdateBeginFormat = DateUtil.parseString(request,"s_startdateBegin","yyyy-MM-dd","yyyyMMdd");
		String s_startdateEndFormat = DateUtil.parseString(request,"s_startdateEnd","yyyy-MM-dd","yyyyMMdd");
		pageRequest.getFilters().put("startdateBeginFormat",s_startdateBeginFormat);
		pageRequest.getFilters().put("startdateEndFormat",s_startdateEndFormat);
		String dateSelect17 = "";
		if (request.getParameter("dateSelect17") != null)
			dateSelect17 = request.getParameter("dateSelect17");
		request.setAttribute("dateSelect17",dateSelect17);		        
		String s_basjBeginFormat = DateUtil.parseString(request,"s_basjBegin","yyyy-MM-dd","yyyyMMdd");
		String s_basjEndFormat = DateUtil.parseString(request,"s_basjEnd","yyyy-MM-dd","yyyyMMdd");
		pageRequest.getFilters().put("basjBeginFormat",s_basjBeginFormat);
		pageRequest.getFilters().put("basjEndFormat",s_basjEndFormat);
		
		Page page = tcpinfojxyManager.findByPageRequest(pageRequest);
		
		savePage(page,pageRequest);
		return QUERYLIST_JSP;
	}
	public String listnsjl() {
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
		String dateSelect7 = "";
		if (request.getParameter("dateSelect7") != null)
		    dateSelect7 = request.getParameter("dateSelect7");
			request.setAttribute("dateSelect7",dateSelect7);		        
		String s_startdateBeginFormat = DateUtil.parseString(request,"s_startdateBegin","yyyy-MM-dd","yyyyMMdd");
		String s_startdateEndFormat = DateUtil.parseString(request,"s_startdateEnd","yyyy-MM-dd","yyyyMMdd");
		pageRequest.getFilters().put("startdateBeginFormat",s_startdateBeginFormat);
		pageRequest.getFilters().put("startdateEndFormat",s_startdateEndFormat);
		String dateSelect17 = "";
		if (request.getParameter("dateSelect17") != null)
		    dateSelect17 = request.getParameter("dateSelect17");
			request.setAttribute("dateSelect17",dateSelect17);		        
		String s_basjBeginFormat = DateUtil.parseString(request,"s_basjBegin","yyyy-MM-dd","yyyyMMdd");
		String s_basjEndFormat = DateUtil.parseString(request,"s_basjEnd","yyyy-MM-dd","yyyyMMdd");
		pageRequest.getFilters().put("basjBeginFormat",s_basjBeginFormat);
		pageRequest.getFilters().put("basjEndFormat",s_basjEndFormat);
		if(request.getParameter("s_deptseq")== null ||"".equals(request.getParameter("s_rowname")) || request.getParameter("s_rowname")==null){
			pageRequest.getFilters().put("deptseq", ud.getDeptSeq());
		}
		
		Page page = tcpinfojxyManager.findByPageRequest(pageRequest);
		savePage(page,pageRequest);
		return LISTNSJL_JSP;
	}
	
	/** 查看对象*/
	public String show() {
		HttpServletRequest request = ServletActionContext.getRequest();
		String startdate =  tcpinfo.getStartdate();
		String startdateFormat = DateUtil.parseString(startdate,"yyyyMMdd","yyyy-MM-dd");
		tcpinfo.setStartdate(startdateFormat);
		String basj =  tcpinfo.getBasj();
		String basjFormat = DateUtil.parseString(basj,"yyyyMMdd","yyyy-MM-dd");
		tcpinfo.setBasj(basjFormat);
		return SHOW_JSP;
	}
	
	/** 进入新增页面*/
	public String create() {
		//addActionError( "存在子机构或用户，不能删除！");
		  
		return CREATE_JSP;
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
     
 	
  public String Remind_dept_count(){
    	
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
		
		boolean credentialsNonExpired = true;
		boolean accountNonExpired = true;
		boolean accountNonLocked = true;
		String path = "";
		try {
			license_key = this.fileConfigManager.getProperty("sys.license_key");
			valid_time = this.fileConfigManager.getProperty("sys.valid_time");
			Remind_day = this.fileConfigManager.getProperty("sys.Remind_day");
			dept_count = this.fileConfigManager.getProperty("sys.dept_count");
			Remind_dept_count = this.fileConfigManager.getProperty("sys.Remind_dept_count");
			

			File f = new PropertiesConfiguration("sys_config.properties").getFile();
			f = f.getParentFile();
			path = f.getAbsolutePath();
			System.out.println(path + "/dyne/PrivateKey");
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
			System.out.println(de_license_key + "===de_license_key");
			if(StringUtils.isNotEmpty(de_license_key) && StringUtils.equals(de_license_key, "dyne_hotel_2011")){
				credentialsNonExpired = true;
			} else{
				credentialsNonExpired = false;
			}
		
			
		
	        int inDays = 0;
			
			if (de_valid_time != null && de_valid_time.length() > 0) {
				Date currdate = new Date();
				SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
				//String serviceDates = format.format(accountDateExpired);
				String currDates = format.format(currdate);
				String days = DateUtil.getTwoDay(de_valid_time, currDates);// 获取两个日期之间间隔天数
				//System.out.println("days="+days);
				if (days != null)
					inDays = Integer.parseInt(days);
				if (inDays < 0)
					accountNonExpired = false;
				else 
					accountNonExpired = true;
			}
			
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
    	
    	
    	
    	
		return de_Remind_dept_count;
    	
    }
     
     
	
	/** 保存新增对象 */
	public String save() {
		HttpServletRequest request = ServletActionContext.getRequest();
		
		int x = tcpinfojxyManager.cpcode();
		int y = Integer.parseInt(Remind_dept_count());
		if(x>=y){
			request.setAttribute("message", "很抱歉，当前版本最大企业家数为"+y+"家");
			return MSG_JSP;
		}
		
		
		
		String startdateFormat = DateUtil.parseString(request,"startdate","yyyy-MM-dd","yyyyMMdd");
		tcpinfo.setStartdate(startdateFormat);
		String basjFormat = DateUtil.parseString(request,"basj","yyyy-MM-dd","yyyyMMdd");
		tcpinfo.setBasj(basjFormat);
		tcpinfo.setFlag("0");
		
		SecurityContext sc = SecurityContextHolder.getContext();
		Authentication auth = sc.getAuthentication();
		MyUserDetails ud = null;
		int session_userid = 0;
		String userDeptId = "";
		if ((auth != null) && auth.getPrincipal() instanceof MyUserDetails) {
			ud = (MyUserDetails) auth.getPrincipal();
			if (ud != null) {
				session_userid = ud.getUserId();
				userDeptId = ud.getDeptID();
			}
		}
		
		
		String station ="";//派出所代码
		if(tcpinfo != null && tcpinfo.getStation() != null)
			station = tcpinfo.getStation();
		
	
		String dwbmSub = "";
		if (station != null && station.length() >= 6)
			dwbmSub = station.substring(0, 6);
			
		else {
			request.setAttribute("message", "部门代码长度小于6");
			return MSG_JSP;
		}



		String maxdwbm = null;
		String qybmzjz = null;
		try {
			maxdwbm = tcpinfojxyManager.getMaxDwbm(dwbmSub);
			qybmzjz = tcpinfojxyManager.getQybmzjz();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		
	  
		//创建企业
		maxdwbm = qybmzjz+maxdwbm.substring(1,4);
		String dwbm ="C02"+dwbmSub+maxdwbm;
		
		tcpinfo.setCpcode(dwbm);
		String s_deptid = null;
		Integer f_deptLevel = null;
		String s_parentid = null;
		String f_deptseq = "";
		int childCount = 0;
		
		if(StringUtils.isNotEmpty(station)){
			//java.lang.Long pcsdm_long = new java.lang.Long(station);
			SsDept pcsDept = (SsDept) ssDeptManager.getById(station);
			s_deptid = pcsDept.getDeptid();
			f_deptLevel = pcsDept.getDeptlevel();
			s_parentid = pcsDept.getParentid();
			f_deptseq = pcsDept.getDeptseq();
		    childCount = 	ssDeptManager.getCountChildDept(station);
			
		}  else {
			request.setAttribute("message", "请选中分局或派出所！");
			return MSG_JSP;
		}
		
		
		
		
		//创建企业组织机构
		SsDept ssDept=new SsDept();
		
		java.lang.Long displayorder_long = new java.lang.Long(childCount+1);
		ssDept.setDeptid(dwbm);
		ssDept.setDeptcode(dwbm);
		ssDept.setDeptname(tcpinfo.getCpname());
		ssDept.setDeptdesc(tcpinfo.getCpname());
		ssDept.setDeptlevel(f_deptLevel+1);
		ssDept.setDeptseq(f_deptseq+dwbm+".");
		ssDept.setDepttypeid("0");
		ssDept.setDisplayorder(displayorder_long);
		ssDept.setParentid(s_deptid);
		ssDept.setStatus("1");
	  
			
			
		

		//创建企业管理员用户
		SsUser ssUser=new SsUser();
		String userid = tcpinfojxyManager.getUserSeq();
		java.lang.Long userid_long = new java.lang.Long(userid);
		ssUser.setUserid(userid_long);
		ssUser.setUsername(dwbm);
		String pwd1=tcpinfo.getCpcode().trim();
		String pwd2="";
		CipherUtil cipher = new CipherUtil();
		//加密
		pwd2 = cipher.generatePassword(pwd1);
		ssUser.setPassword(pwd2);
		ssUser.setFullname("企业管理员");
		ssUser.setDeptid(dwbm);
		ssUser.setDescription(tcpinfo.getCpname()+"企业管理员");
		Date date=new Date();
		ssUser.setCreatedate(new java.sql.Date(date.getTime()));
		ssUser.setCreateuserid(Long.valueOf(session_userid));
		ssUser.setEnabled(1L);
		ssUser.setInitialpassword(0L);
		Calendar   cal=Calendar.getInstance();   
        cal.setTime(new   Date());   
        int   year=cal.get(Calendar.YEAR);   
		ssUser.setExpirationdate((year+1)+"-12-31");
		//ssUserManager.save(ssUser);
		
		//为用户分配角色
		//ssUserManager.insertRoleUser(new Long(3), ssUser.getUserid().longValue());
		//事务控制
		tcpinfo.setPoliceunit(tcpinfo.getPoliceunit());
		tcpinfo.setScbackupunit(tcpinfo.getScbackupunit());
	
		tcpinfojxyManager.savePmdwxxb(tcpinfo,ssDept,ssUser,new Long(3), userid_long);
		
		//tcpinfoManager.save(tcpinfo);
		return returnUrl;////LIST_ACTION;
	}
	
	/**进入更新页面*/
	public String edit() {
		HttpServletRequest request = ServletActionContext.getRequest();
		String startdate =  tcpinfo.getStartdate();
		String startdateFormat = DateUtil.parseString(startdate,"yyyyMMdd","yyyy-MM-dd");
		tcpinfo.setStartdate(startdateFormat);
		String basj =  tcpinfo.getBasj();
		String basjFormat = DateUtil.parseString(basj,"yyyyMMdd","yyyy-MM-dd");
		tcpinfo.setBasj(basjFormat);
		return EDIT_JSP;
	}
	
	/**保存更新对象*/
	public String update() {
		HttpServletRequest request = ServletActionContext.getRequest();
		String startdateFormat = DateUtil.parseString(request,"startdate","yyyy-MM-dd","yyyyMMdd");
		tcpinfo.setStartdate(startdateFormat);
		String basjFormat = DateUtil.parseString(request,"basj","yyyy-MM-dd","yyyyMMdd");
		tcpinfo.setBasj(basjFormat);
		
		
		SecurityContext sc = SecurityContextHolder.getContext();
        Authentication auth = sc.getAuthentication();
        MyUserDetails ud = null;

		String userDeptId = "";
		if ((auth != null) && auth.getPrincipal() instanceof MyUserDetails) {
			ud = (MyUserDetails) auth.getPrincipal();
			if (ud != null) {

				userDeptId = ud.getDeptID();
			}
		}
		
		
		String station ="";//派出所代码
		if(tcpinfo != null && tcpinfo.getStation() != null)
			station = tcpinfo.getStation();
		
		String s_deptid = null;
		Integer f_deptLevel = null;
		String s_parentid = null;
		String f_deptseq = "";
		int childCount = 0;
		
		if(StringUtils.isNotEmpty(station) ){
			//java.lang.Long pcsdm_long = new java.lang.Long(station);
			SsDept pcsDept = (SsDept) ssDeptManager.getById(station);
			s_deptid = pcsDept.getDeptid();
			f_deptLevel = pcsDept.getDeptlevel();
			s_parentid = pcsDept.getParentid();
			f_deptseq = pcsDept.getDeptseq();
		    childCount = 	ssDeptManager.getCountChildDept(station);
			
		}  else {
			request.setAttribute("message", "请选中分局或派出所！");
			return MSG_JSP;
		}
		
		SsDept ssDept=ssDeptManager.getById(tcpinfo.getCpcode());
		//java.lang.Long dwbm_long = new java.lang.Long(tcpinfo.getCpcode());
		java.lang.Long displayorder_long = new java.lang.Long(childCount+1);
		ssDept.setDeptid(tcpinfo.getCpcode());
		ssDept.setDeptcode(tcpinfo.getCpcode());
		ssDept.setDeptname(tcpinfo.getCpname());
		ssDept.setDeptdesc(tcpinfo.getCpname());
		ssDept.setDeptlevel(f_deptLevel+1);
		ssDept.setDeptseq(f_deptseq+tcpinfo.getCpcode()+".");
		ssDept.setDepttypeid("0");
		ssDept.setDisplayorder(displayorder_long);
		//java.lang.Long station_long = new java.lang.Long(station);
		ssDept.setParentid(station);
		ssDept.setStatus("1");
		
		//ssDeptManager.update(ssDept);
		//pmdwxxbManager.update(this.pmdwxxb);
		tcpinfojxyManager.updateDept(tcpinfo, ssDept);
		
		//tcpinfoManager.update(this.tcpinfo);
		return returnUrl;////LIST_ACTION;
	}
	
	/**删除对象*/
	public String delete() {
		HttpServletRequest request = ServletActionContext.getRequest();
		
			
			java.lang.String id = request.getParameter("cpcode");
			
			if(tcpinfojxyManager.isExistChildDept(id) == 0 && tcpinfojxyManager.isExistUser(id)<=1){	
				tcpinfojxyManager.deleteCpinfo(id);
			} else{
				//request.setAttribute("message", "存在子机构或用户，不能删除！");
				
				  addActionError( "存在子机构或用户，不能删除！");
				  return MSG_JSP; 
			}
			
			//tcpinfoManager.removeById(id);
		
		return LIST_ACTION ;//LIST_ACTION;
	}
	public String saveiscode(){
		HttpServletRequest request = ServletActionContext.getRequest();
		String code = request.getParameter("cp");
		request.setAttribute("cpcode", code);
		String iscode = request.getParameter("iscode");
		String typecode="";
		
		String jmType = (String) DictHelpImpl.getInitData("JmType");
		if(request.getParameter("typecode")!= null){
			typecode=request.getParameter("typecode");
		}
		String smycode="";
		if(request.getParameter("smycode")!= null){
			smycode=request.getParameter("smycode");
		}
		String cpcode = code.substring(3,code.length());
		Encry en = new Encry();
		
		String re="";
		if("1".equals(jmType)){
			re= en.crypt_pwd("e", "efficiently", iscode);		
		}else{
			re= en.crypt_pwd("e", "bslogyes", iscode);		
		}
		if(!re.equals(cpcode)){
			request.setAttribute("message", "软件授权码不正确"); 
			return "/pages/jxy/Tcpinfo/include_iscpde.jsp";		
		}
		
		if(smycode!= null && !smycode.equals("")){
		String type =""; 
		if("1".equals(jmType)){
			type = en.crypt_pwd("e", "energetically", smycode);
		}else{
			type = en.crypt_pwd("e", "smyesok", smycode);
		}
		if(!type.equals(cpcode)){
			request.setAttribute("message", "扫描仪授权码不正确"); 
			return "/pages/jxy/Tcpinfo/include_iscpde.jsp";		
		}
		tcpinfo.setSmycode(smycode);
		}
		if(typecode!= null && !typecode.equals("")){
			String type ="";
			if("1".equals(jmType)){
				type= en.crypt_pwd("e", "actively", typecode);
			}else{
				type= en.crypt_pwd("e", "bsdkyes", typecode);
			}
			if(!type.equals(cpcode)){
				request.setAttribute("message", "读卡器授权码不正确"); 
				return "/pages/jxy/Tcpinfo/include_iscpde.jsp";		
			}
			tcpinfo.setTypecode(typecode);
			}
		tcpinfo.setCpcode(code);
		tcpinfo.setIscode(iscode);
		tcpinfojxyManager.updatecode(tcpinfo);
		return returnUrl;
	}
	public String cariscode(){
		HttpServletRequest request = ServletActionContext.getRequest();
		String code = request.getParameter("cpcode");
		tcpinfo=tcpinfojxyManager.getById(code);
		request.setAttribute("cpcode", code);
		
		return "/pages/jxy/Tcpinfo/include_iscpde.jsp";
		
	}

}
