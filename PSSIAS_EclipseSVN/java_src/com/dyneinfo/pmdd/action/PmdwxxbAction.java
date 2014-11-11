/*
 * Powered By [lishicheng]
 */

package com.dyneinfo.pmdd.action;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.security.Key;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.TreeMap;
import javacommon.base.BaseStruts2Action;
import javacommon.util.CipherUtil;

import javax.crypto.Cipher;
import javax.servlet.http.HttpServletRequest;

import net.java.dev.common.dict.taglib.DictHelpImpl;
import net.java.dev.common.util.DateUtil;
import net.java.dev.common.util.PropertiesFileConfigManager;
import net.java.dev.common.util.SpringTagFunctions;

import org.apache.struts2.ServletActionContext;
import org.security.userdetails.MyUserDetails;
import org.springframework.security.Authentication;
import org.springframework.security.context.SecurityContext;
import org.springframework.security.context.SecurityContextHolder;
import cn.org.rapid_framework.page.Page;
import cn.org.rapid_framework.page.PageRequest;
import cn.org.rapid_framework.web.util.HttpUtils;

import com.action.Registered;
import com.dyneinfo.zazh.model.SsDept;
import com.dyneinfo.zazh.model.SsUser;
import com.dyneinfo.zazh.service.SsDeptManager;
import com.dyneinfo.zazh.service.SsUserManager;
import com.dyneinfo.zazh.util.Encry;
import com.dyneinfo.pmdd.model.Pmdwxxb;
import com.dyneinfo.pmdd.service.PmdwxxbManager;
import com.google.gson.Gson;
import com.opensymphony.xwork2.ModelDriven;
import com.opensymphony.xwork2.Preparable;

import org.apache.commons.configuration.ConfigurationException;
import org.apache.commons.configuration.PropertiesConfiguration;
import org.apache.commons.lang.StringUtils;

import sun.misc.BASE64Decoder;

import com.util.Encrypt;
import com.util.MD5;
import java.util.HashMap;

/**
 * @author lisc email:lishicheng(a)gmail.com
 */


public class PmdwxxbAction extends BaseStruts2Action implements Preparable,ModelDriven{
	//默认多列排序,example: username desc,createTime asc
	protected static final String DEFAULT_SORT_COLUMNS = null; 
	
	//forward paths
	protected static final String QUERY_JSP = "/pages/pmdd/Pmdwxxb/query.jsp";
	protected static final String LIST_JSP= "/pages/pmdd/Pmdwxxb/list.jsp";
	protected static final String CREATE_JSP = "/pages/pmdd/Pmdwxxb/create.jsp";
	protected static final String EDIT_JSP = "/pages/pmdd/Pmdwxxb/edit.jsp";
	protected static final String SHOW_JSP = "/pages/pmdd/Pmdwxxb/show.jsp";
	//redirect paths,startWith: !
	protected static final String LIST_ACTION = "!/pages/pmdd/Pmdwxxb/list.do";
	
	private PmdwxxbManager pmdwxxbManager;
	private SsDeptManager ssDeptManager;
	private SsUserManager ssUserManager;
	private PropertiesFileConfigManager fileConfigManager;
	private Pmdwxxb pmdwxxb;
	
	java.lang.String id = null;
	private String[] items;
	private String returnUrl;  //返回列表，保留查询条件
	private TreeMap<String, String> dateSelectMap;// //日期选择


	public void prepare() throws Exception {
		if (isNullOrEmptyString(id)) {
			pmdwxxb = new Pmdwxxb();
		} else {
			pmdwxxb = (Pmdwxxb)pmdwxxbManager.getById(id);
		}

	}
	
	/** 增加setXXXX()方法,spring就可以通过autowire自动设置对象属性 */
	public void setPmdwxxbManager(PmdwxxbManager manager) {
		this.pmdwxxbManager = manager;
	}	
	
	public Object getModel() {
		return pmdwxxb;
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
		if(!SpringTagFunctions.ifAnyGranted("ROLE_ADMIN")){
			//pageRequest.getFilters().put("deptid",deptid);	
			pageRequest.getFilters().put("chdeptid",deptid);	
		}
		int count=count();
		request.setAttribute("count", count);
		dateSelectMap  = DateUtil.getDateSelectData();
		String dateSelect19 = "";
		if (request.getParameter("dateSelect19") != null)
		    dateSelect19 = request.getParameter("dateSelect19");
			request.setAttribute("dateSelect19",dateSelect19);		        
		String s_kyrqBeginFormat = DateUtil.parseString(request,"s_kyrqBegin","yyyy-MM-dd","yyyyMMdd");
		String s_kyrqEndFormat = DateUtil.parseString(request,"s_kyrqEnd","yyyy-MM-dd","yyyyMMdd");
		pageRequest.getFilters().put("kyrqBeginFormat",s_kyrqBeginFormat);
		pageRequest.getFilters().put("kyrqEndFormat",s_kyrqEndFormat);
		
		
		Page page = pmdwxxbManager.findByPageRequest(pageRequest);
		savePage(page,pageRequest);
		

		int js = 0;
		//Registered re = new Registered();
		Integer obj = new Integer(pmdwxxbManager.getQyjs());
		Integer obj2 = new Integer(getXzJs());

		request.setAttribute("qyjs", obj.toString());
		request.setAttribute("qyxzjs", obj2.toString());
		return QUERY_JSP;
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
		if(!SpringTagFunctions.ifAnyGranted("ROLE_ADMIN")){
			//pageRequest.getFilters().put("deptid",deptid);	
			pageRequest.getFilters().put("chdeptid",deptid);	
		}
		int count=count();
		request.setAttribute("count", count);
		dateSelectMap  = DateUtil.getDateSelectData();
		String dateSelect19 = "";
		if (request.getParameter("dateSelect19") != null)
		    dateSelect19 = request.getParameter("dateSelect19");
			request.setAttribute("dateSelect19",dateSelect19);		        
		String s_kyrqBeginFormat = DateUtil.parseString(request,"s_kyrqBegin","yyyy-MM-dd","yyyyMMdd");
		String s_kyrqEndFormat = DateUtil.parseString(request,"s_kyrqEnd","yyyy-MM-dd","yyyyMMdd");
		pageRequest.getFilters().put("kyrqBeginFormat",s_kyrqBeginFormat);
		pageRequest.getFilters().put("kyrqEndFormat",s_kyrqEndFormat);
		
		
		Page page = pmdwxxbManager.findByPageRequest(pageRequest);
		savePage(page,pageRequest);
		

		int js = 0;
		//Registered re = new Registered();
		Integer obj = new Integer(pmdwxxbManager.getQyjs());
		Integer obj2 = new Integer(getXzJs());

		request.setAttribute("qyjs", obj.toString());
		request.setAttribute("qyxzjs", obj2.toString());
		return LIST_JSP;
	}
	
	
	 public Map getRegistrationInfo() {

		Map xtkzMap;
		xtkzMap = new HashMap();
		List list = (List) pmdwxxbManager.getRegistrationInfo();
		if (list != null) {
			for (int i = 0; i < list.size(); i++) {
				Map results = (HashMap) list.get(i);
				String XZRQ = (String) results.get("XZRQ");
				String XZJS = (String) results.get("XZJS");
				String XZQH = (String) results.get("XZQH");
				String MD5 = (String) results.get("MD5");
				xtkzMap.put("XZRQ", XZRQ);
				xtkzMap.put("XZJS", XZJS);
				xtkzMap.put("XZQH", XZQH);
				xtkzMap.put("MD5", MD5);
			}
		}
		return xtkzMap;
	}
	
	  public int getXzJs()
	    {
	        int js = 0;
	        Map xtkzMap = getRegistrationInfo();
	        Encrypt pt = new Encrypt();
	        if(!xtkzMap.isEmpty())
	        {
	            String XZJS = pt.DelPassword(xtkzMap.get("XZJS").toString());
	            js = Integer.valueOf(XZJS).intValue();
	        }
	        return js;
	    }
	
	/** 查看对象*/
	public String show() {
		HttpServletRequest request = ServletActionContext.getRequest();
		String kyrq=pmdwxxb.getKyrq();
		String kyrqFormat = DateUtil.parseString(kyrq,"yyyyMMdd","yyyy-MM-dd");
		pmdwxxb.setKyrq(kyrqFormat);
		return SHOW_JSP;
	}
	
	/** 进入新增页面*/
	public String create() {
		
		return CREATE_JSP;
	}
	
	/** 保存新增对象 */
	public String save() {
		HttpServletRequest request = ServletActionContext.getRequest();
		
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
		
		String fjdm = "";//分局代码
		String pcsdm ="";//派出所代码
		if(pmdwxxb != null && pmdwxxb.getFjdm() != null)
			fjdm = pmdwxxb.getFjdm();
		if(pmdwxxb != null && pmdwxxb.getPcsdm() != null)
			pcsdm = pmdwxxb.getPcsdm();
	
		String dwbmSub = "";
		if (fjdm != null && fjdm.length() >= 6)
			dwbmSub = fjdm.substring(0, 6);
		else {
			request.setAttribute("message", "分局代码长度小于6");
			return returnUrl;
		}



		String maxdwbm = null;
		String	qybmzjz = null;
		try {
			maxdwbm = pmdwxxbManager.getMaxDwbm(dwbmSub);
			qybmzjz = (String) DictHelpImpl.getInitData("qybm");
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
	  
		//创建企业
		String dwbm =dwbmSub+qybmzjz+maxdwbm.substring(1, maxdwbm.length());
		pmdwxxb.setDwbm(dwbm);
		String kyrqFormat = DateUtil.parseString(request,"kyrq","yyyy-MM-dd","yyyyMMdd");
		pmdwxxb.setKyrq(kyrqFormat);
		SimpleDateFormat formatoptime = new SimpleDateFormat("yyyyMMddhhmmssSSS");
		pmdwxxb.setOptime(formatoptime.format(new Date()));
		Long f_deptid = null;
		Integer f_deptLevel = null;
		Long f_parentid = null;
		String f_deptseq = "";
		int childCount = 0;
		
		if(StringUtils.isNotEmpty(fjdm) && StringUtils.isNotEmpty(pcsdm)){
			String pcsdm_long = new String(pcsdm);
			SsDept pcsDept = (SsDept) ssDeptManager.getById(pcsdm_long);
			f_deptid = Long.parseLong(pcsDept.getDeptid());
			f_deptLevel = pcsDept.getDeptlevel();
			f_parentid = Long.parseLong(pcsDept.getParentid());
			f_deptseq = pcsDept.getDeptseq();
		    childCount = 	ssDeptManager.getCountChildDept(pcsdm);
			
		} else if(StringUtils.isNotEmpty(fjdm) && StringUtils.isEmpty(pcsdm)){
			String fjdm_long = new String(fjdm);
			SsDept fjDept = (SsDept) ssDeptManager.getById(fjdm_long);
			f_deptid = Long.parseLong(fjDept.getDeptid());
			f_deptLevel = fjDept.getDeptlevel();
			f_parentid = Long.parseLong(fjDept.getParentid());
			f_deptseq = fjDept.getDeptseq();
			childCount = 	ssDeptManager.getCountChildDept(fjdm);
			
		} else {
			request.setAttribute("message", "请选中分局或派出所！");
			return returnUrl;
		}
		//pmdwxxbManager.save(pmdwxxb);
		
		
		
		//创建企业组织机构
		SsDept ssDept=new SsDept();
		java.lang.String dwbm_long = new java.lang.String(dwbm);
		java.lang.Long displayorder_long = new java.lang.Long(childCount+1);
		ssDept.setDeptid(dwbm_long);
		ssDept.setDeptcode(dwbm);
		ssDept.setDeptname(pmdwxxb.getDwmc());
		ssDept.setDeptdesc(pmdwxxb.getDwmc());
		ssDept.setDeptlevel(f_deptLevel+1);
		ssDept.setDeptseq(f_deptseq+dwbm+".");
		ssDept.setDepttypeid("0");
		ssDept.setDisplayorder(displayorder_long);
		ssDept.setParentid(f_deptid.toString());
		ssDept.setStatus("1");
	   // ssDeptManager.save(ssDept);
			
			
		

		//创建企业管理员用户
		SsUser ssUser=new SsUser();
		String userid = pmdwxxbManager.getUserSeq();
		java.lang.Long userid_long = new java.lang.Long(userid);
		ssUser.setUserid(userid_long);
		ssUser.setUsername(dwbm);
		String pwd1=pmdwxxb.getDwbm().trim();
		String pwd2="";
		CipherUtil cipher = new CipherUtil();
		//加密
		pwd2 = cipher.generatePassword(pwd1);
		ssUser.setPassword(pwd2);
		ssUser.setFullname("企业管理员");
		ssUser.setDeptid(dwbm_long);
		ssUser.setDescription(pmdwxxb.getDwmc()+"企业管理员");
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
		pmdwxxbManager.savePmdwxxb(pmdwxxb,ssDept,ssUser,new Long(3), userid_long);
		
		
		return returnUrl;////LIST_ACTION;
	}
	
	/**进入更新页面*/
	public String edit() {
		HttpServletRequest request = ServletActionContext.getRequest();
		String kyrq=pmdwxxb.getKyrq();
		String kyrqFormat = DateUtil.parseString(kyrq,"yyyyMMdd","yyyy-MM-dd");
		pmdwxxb.setKyrq(kyrqFormat);
		return EDIT_JSP;
	}
	
	/**保存更新对象*/
	public String update() {
		HttpServletRequest request = ServletActionContext.getRequest();
		String kyrqFormat = DateUtil.parseString(request,"kyrq","yyyy-MM-dd","yyyyMMdd");
		pmdwxxb.setKyrq(kyrqFormat);
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
		
		String fjdm = "";//分局代码
		String pcsdm ="";//派出所代码
		if(pmdwxxb != null && pmdwxxb.getFjdm() != null)
			fjdm = pmdwxxb.getFjdm();
		if(pmdwxxb != null && pmdwxxb.getPcsdm() != null)
			pcsdm = pmdwxxb.getPcsdm();
		
		Long f_deptid = null;
		Integer f_deptLevel = null;
		Long f_parentid = null;
		String f_deptseq = "";
		int childCount = 0;
		
		if(StringUtils.isNotEmpty(fjdm) && StringUtils.isNotEmpty(pcsdm)){
			java.lang.String pcsdm_long = new java.lang.String(pcsdm);
			SsDept pcsDept = (SsDept) ssDeptManager.getById(pcsdm_long);
			f_deptid = Long.parseLong(pcsDept.getDeptid());
			f_deptLevel = pcsDept.getDeptlevel();
			f_parentid = Long.parseLong(pcsDept.getParentid());
			f_deptseq = pcsDept.getDeptseq();
		    childCount = 	ssDeptManager.getCountChildDept(pcsdm);
			
		} else if(StringUtils.isNotEmpty(fjdm) && StringUtils.isEmpty(pcsdm)){
			java.lang.String fjdm_long = new java.lang.String(fjdm);
			SsDept fjDept = (SsDept) ssDeptManager.getById(fjdm_long);
			f_deptid = Long.parseLong(fjDept.getDeptid());
			f_deptLevel = fjDept.getDeptlevel();
			f_parentid = Long.parseLong(fjDept.getParentid());
			f_deptseq = fjDept.getDeptseq();
			childCount = 	ssDeptManager.getCountChildDept(fjdm);
			
		} else {
			request.setAttribute("message", "请选中分局或派出所！");
			return returnUrl;
		}
		
		SsDept ssDept=ssDeptManager.getById( pmdwxxb.getDwbm());
		if(ssDept == null){
			ssDept  = new SsDept();
		}
		String dwbm_long = pmdwxxb.getDwbm();
		long displayorder_long = Long.valueOf(childCount+1);
		ssDept.setDeptid(dwbm_long);
		ssDept.setDeptcode(pmdwxxb.getDwbm());
		ssDept.setDeptname(pmdwxxb.getDwmc());
		ssDept.setDeptdesc(pmdwxxb.getDwmc());
		ssDept.setDeptlevel(f_deptLevel+1);
		ssDept.setDeptseq(f_deptseq+pmdwxxb.getDwbm()+".");
		ssDept.setDepttypeid("0");
		ssDept.setDisplayorder(displayorder_long);
		ssDept.setParentid(f_deptid.toString());
		ssDept.setStatus("1");
		
		//ssDeptManager.update(ssDept);
		//pmdwxxbManager.update(this.pmdwxxb);
		pmdwxxbManager.updateDept(pmdwxxb, ssDept);
		return returnUrl;////LIST_ACTION;
	}
	
	/**删除对象*/
	public String delete() {
		for(int i = 0; i < items.length; i++) {
			Hashtable params = HttpUtils.parseQueryString(items[i]);
			java.lang.String id = new java.lang.String((String)params.get("optime"));
			pmdwxxb=pmdwxxbManager.getById(id);
			
			//删除企业信息到部门表
			Long deptId=Long.valueOf(pmdwxxb.getDwbm().trim());//单位编码
			Long rootId=Long.valueOf(pmdwxxb.getFjdm().trim());//分局编码
			Long parentId=Long.valueOf(pmdwxxb.getPcsdm().trim());//派出所编码
			if(ssDeptManager.getById(deptId.toString())!=null){
				ssDeptManager.removeById(deptId.toString());
			}
			pmdwxxbManager.removeById(id);
			
		}
		return returnUrl ;//LIST_ACTION;
	}

	public void setSsDeptManager(SsDeptManager ssDeptManager) {
		this.ssDeptManager = ssDeptManager;
	}

	public void setSsUserManager(SsUserManager ssUserManager) {
		this.ssUserManager = ssUserManager;
	}

	public String cariscode(){
		HttpServletRequest request = ServletActionContext.getRequest();
		String code = request.getParameter("cpcode");
		pmdwxxb = pmdwxxbManager.getById(code);
		request.setAttribute("cpcode", code);
		return "/pages/pmdd/Pmdwxxb/createiscode.jsp";
		
	}
	public String saveiscode(){
		HttpServletRequest request = ServletActionContext.getRequest();
		String optime = request.getParameter("cp");
		String code = request.getParameter("code");
		request.setAttribute("cpcode", code);
		String iscode = request.getParameter("iscode");
		String typecode="";
		String jmType = (String) DictHelpImpl.getInitData("jmType");
		if(request.getParameter("typecode")!= null){
		typecode=request.getParameter("typecode");
		}
		String smycode="";
		if(request.getParameter("smycode")!= null){
			smycode=request.getParameter("smycode");
		}
		String cpcode = code;
		Encry en = new Encry();
		
		String re="";	
		if ("1".equals(jmType)) {
			re = en.crypt_pwd("e", "efficiently", iscode);
		} else {
			re = en.crypt_pwd("e", "bslogyes", iscode);
		}
		if(!re.equals(cpcode)){
			request.setAttribute("message", "软件授权码不正确"); 
			return "/pages/pmdd/Pmdwxxb/createiscode.jsp";		
		}
		
		if(smycode!= null && !smycode.equals("")){
		String type = "";
		if ("1".equals(jmType)) {
			type=en.crypt_pwd("e", "energetically", smycode);
		}else{
			type=en.crypt_pwd("e", "smyesok", smycode);
		}
		if(!type.equals(cpcode)){
			request.setAttribute("message", "扫描仪授权码不正确"); 
			return "/pages/pmdd/Pmdwxxb/createiscode.jsp";		
		}
		pmdwxxb.setSmycode(smycode);
		
		}
		if(typecode!= null && !typecode.equals("")){
			String type = "";
			if ("1".equals(jmType)) {
				type = en.crypt_pwd("e", "actively", typecode);
			}else{
				type = en.crypt_pwd("e", "bsdkyes", typecode);
			}
			if(!type.equals(cpcode)){
				request.setAttribute("message", "读卡器授权码不正确"); 
				return "/pages/pmdd/Pmdwxxb/createiscode.jsp";		
			}
			pmdwxxb.setTypecode(typecode);
			
			}
		pmdwxxb.setOptime(optime);
		pmdwxxb.setIscode(iscode);
		pmdwxxbManager.updatecode(pmdwxxb);

		return returnUrl;
	}

}
