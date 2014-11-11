/*
 * Powered By [lishicheng]
 */

package com.dyneinfo.gas.action;

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

import java.io.IOException;
import java.text.SimpleDateFormat;

import net.java.dev.common.dict.taglib.DictHelpImpl;
import net.java.dev.common.util.DateUtil;

import org.apache.commons.lang.StringUtils;
import org.apache.struts2.ServletActionContext;

import java.util.*;

import javacommon.base.*;
import javacommon.util.*;

import cn.org.rapid_framework.util.*;
import cn.org.rapid_framework.web.util.*;
import cn.org.rapid_framework.page.*;
import cn.org.rapid_framework.page.impl.*;

import com.dyneinfo.gas.model.*;
import com.dyneinfo.gas.dao.*;
import com.dyneinfo.gas.service.*;
import com.dyneinfo.zazh.model.SsDept;
import com.dyneinfo.zazh.model.SsUser;
import com.dyneinfo.zazh.service.SsDeptManager;
import com.dyneinfo.zazh.service.SsUserManager;
import com.dyneinfo.zazh.util.Encry;

/**
 * @author lisc email:lishicheng(a)gmail.com
 */


public class TcompanyinfogasAction extends BaseStruts2Action implements Preparable,ModelDriven{
	//默认多列排序,example: username desc,createTime asc
	protected static final String DEFAULT_SORT_COLUMNS = null; 
	
	//forward paths
	protected static final String QUERY_JSP = "/pages/gas/Tcompanyinfo/query.jsp";
	protected static final String LIST_JSP= "/pages/gas/Tcompanyinfo/list.jsp";
	protected static final String QUERYLIST_JSP= "/pages/gas/Tcompanyinfo/querylist.jsp";
	protected static final String CREATE_JSP = "/pages/gas/Tcompanyinfo/create.jsp";
	protected static final String EDIT_JSP = "/pages/gas/Tcompanyinfo/edit.jsp";
	protected static final String QYEDIT_JSP = "/pages/gas/Tcompanyinfo/qyedit.jsp";
	protected static final String SHOW_JSP = "/pages/gas/Tcompanyinfo/show.jsp";
	protected static final String CPSHOW_JSP = "/pages/gas/Tbuylog/cpshow.jsp";
	protected static final String GYCPSHOW_JSP = "/pages/gas/Tbuylog/gycpshow.jsp";
	protected static final String TZXXCPSHOW_JSP = "/pages/gas/Tbuylog/tzxxcpshow.jsp";
	//redirect paths,startWith: !
	protected static final String LIST_ACTION = "!/pages/gas/Tcompanyinfo/list.do";
	
	private TcompanyinfogasManager tcompanyinfogasManager;
	private SsDeptManager ssDeptManager;
	private SsUserManager ssUserManager;
	private TbuylogManager tbuylogManager;
	TreeMap<String,String> provMap ;
	
	
	private Tcompanyinfo tcompanyinfo;
	java.lang.String id = null;
	private String[] items;
	
	private String msg;
	private String returnUrl;  //返回列表，保留查询条件
	private TreeMap<String, String> dateSelectMap;// //日期选择

	public void prepare() throws Exception {
		if (isNullOrEmptyString(id)) {
			tcompanyinfo = new Tcompanyinfo();
		} else {
			tcompanyinfo = (Tcompanyinfo)tcompanyinfogasManager.getById(id);
		}
	}
	
	/** 增加setXXXX()方法,spring就可以通过autowire自动设置对象属性 */
	public void setTcompanyinfogasManager(TcompanyinfogasManager manager) {
		this.tcompanyinfogasManager = manager;
	}	
	
	public Object getModel() {
		return tcompanyinfo;
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
	
	/**
	 * 初始三级联动下拉框赋值
	 */
	public void qyxx(PageRequest<Map> pageRequest){
		MyUserDetails ud = null;
		String code ="";
		String pcscode = "";
		String pcsname = "";
		SecurityContext sc = SecurityContextHolder.getContext();
		Authentication auth = sc.getAuthentication();
		if ((auth != null) && auth.getPrincipal() instanceof MyUserDetails) {
			ud = (MyUserDetails) auth.getPrincipal();
			if (ud != null) {
				code = ud.getDeptID().toString();
			}
		}
		
		List listdept = tbuylogManager.findDept( "and CODE = '"+code +"'" );
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
					SsDept ssDept = (SsDept) listconfig.get(i);
					String buildxh_temp = ssDept.getDeptcode();
					String buildNoName_temp = ssDept.getDeptname();
					provMap.put(buildxh_temp, buildNoName_temp);
					
				}
				provMap.put("", "请选择...");
			}
		}
		HttpServletRequest request = ServletActionContext.getRequest();
		request.setAttribute("pcscode", pcscode);
		request.setAttribute("pcsname", pcsname);
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
		
		provMap = new TreeMap();
		qyxx( pageRequest);
			
		dateSelectMap  = DateUtil.getDateSelectData();
		String dateSelect19 = "";
		if (request.getParameter("dateSelect19") != null)
		    dateSelect19 = request.getParameter("dateSelect19");
			request.setAttribute("dateSelect19",dateSelect19);		        
		String s_modTimeBeginFormat = DateUtil.parseString(request,"s_modTimeBegin","yyyy-MM-dd","yyyyMMdd");
		String s_modTimeEndFormat = DateUtil.parseString(request,"s_modTimeEnd","yyyy-MM-dd","yyyyMMdd");
		pageRequest.getFilters().put("modtimeBeginFormat",s_modTimeBeginFormat);
		pageRequest.getFilters().put("modtimeEndFormat",s_modTimeEndFormat);
		
		
		Page page = tcompanyinfogasManager.findByPageRequest(pageRequest);
		savePage(page,pageRequest);
		return LIST_JSP;
	}
	
	/** 执行搜索 */
	public String querylist() {
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
		
		provMap = new TreeMap();
		qyxx( pageRequest);
			
		dateSelectMap  = DateUtil.getDateSelectData();
		String dateSelect19 = "";
		if (request.getParameter("dateSelect19") != null)
		    dateSelect19 = request.getParameter("dateSelect19");
			request.setAttribute("dateSelect19",dateSelect19);		        
		String s_modTimeBeginFormat = DateUtil.parseString(request,"s_modTimeBegin","yyyy-MM-dd","yyyyMMdd");
		String s_modTimeEndFormat = DateUtil.parseString(request,"s_modTimeEnd","yyyy-MM-dd","yyyyMMdd");
		pageRequest.getFilters().put("modtimeBeginFormat",s_modTimeBeginFormat);
		pageRequest.getFilters().put("modtimeEndFormat",s_modTimeEndFormat);
		
		
		Page page = tcompanyinfogasManager.findByPageRequest(pageRequest);
		savePage(page,pageRequest);
		return QUERYLIST_JSP;
	}
	
	/** 查看对象*/
	public String show() {
		HttpServletRequest request = ServletActionContext.getRequest();
		return SHOW_JSP;
	}
	/** 查看对象*/
	public String cpshow() {
		HttpServletRequest request = ServletActionContext.getRequest();
		return CPSHOW_JSP;
	}
	/** 查看对象*/
	public String gycpshow() {
		HttpServletRequest request = ServletActionContext.getRequest();
		return GYCPSHOW_JSP;
	}
	
	/** 查看对象*/
	public String tzxxcpshow() {
		HttpServletRequest request = ServletActionContext.getRequest();
		return TZXXCPSHOW_JSP;
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
//		SimpleDateFormat formatoptime = new SimpleDateFormat("yyyyMMdd");
//		tcompanyinfo.setModTime(formatoptime.format(new Date()));
		
		if ((auth != null) && auth.getPrincipal() instanceof MyUserDetails) {
			ud = (MyUserDetails) auth.getPrincipal();
			if (ud != null) {
				session_userid = ud.getUserId();
				userDeptId = ud.getDeptID();
			}
		}
		
		String fjdm = "";//分局代码
		String pcsdm ="";//派出所代码
		if(tcompanyinfo != null && tcompanyinfo.getBurcode() != null)
			fjdm = tcompanyinfo.getBurcode();
		if(tcompanyinfo != null && tcompanyinfo.getStacode()!= null)
			pcsdm = tcompanyinfo.getStacode();
	
		String dwbmSub = "";
		if (fjdm != null && fjdm.length() >= 6)
			dwbmSub = fjdm.substring(0, 6);
		else {
			request.setAttribute("message", "分局代码长度小于6");
			return returnUrl;
		}

		String maxdwbm = null;
		dwbmSub = "G01" + dwbmSub;
		try {
			maxdwbm = tcompanyinfogasManager.getMaxDwbm(dwbmSub);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    String max_end_id = "0";
	    if (maxdwbm != null && !"".equals(maxdwbm) && maxdwbm.length() > 0) {
	    	max_end_id = maxdwbm.substring(dwbmSub.length());
		}
	    int i_max_end_id = Integer.parseInt(max_end_id);
		i_max_end_id = i_max_end_id + 1;		
		String dwbm = "0000"+i_max_end_id;
		dwbm = dwbm.substring(dwbm.length()-4);
		
		dwbm =dwbmSub+dwbm;
		
		Encry en=new Encry();
		//创建企业
		tcompanyinfo.setCpcode(dwbm);
		String kyrqFormat = DateUtil.parseString(request,"modTime","yyyy-MM-dd","yyyyMMdd");
		tcompanyinfo.setModTime(kyrqFormat);
		String servicedateview = DateUtil.parseString(request,"servicedateview","yyyy-MM-dd","yyyyMMdd");
//		tcompanyinfo.setServicedateview(servicedateview);
		String re=en.crypt_pwd("d", "efficiently",dwbm+"----"+servicedateview);
		tcompanyinfo.setServicedate(re);
		String f_deptid = null;
		Integer f_deptLevel = null;
		String f_parentid = null;
		String f_deptseq = "";
		int childCount = 0;
		
		if(StringUtils.isNotEmpty(fjdm) && StringUtils.isNotEmpty(pcsdm)){
			SsDept pcsDept = (SsDept) ssDeptManager.getById(pcsdm);
			f_deptid = pcsDept.getDeptid();
			f_deptLevel = pcsDept.getDeptlevel();
			f_parentid = pcsDept.getParentid();
			f_deptseq = pcsDept.getDeptseq();
		    childCount = 	ssDeptManager.getCountChildDept(pcsdm);
			
		} else if(StringUtils.isNotEmpty(fjdm) && StringUtils.isEmpty(pcsdm)){
			SsDept fjDept = (SsDept) ssDeptManager.getById(fjdm);
			f_deptid = fjDept.getDeptid();
			f_deptLevel = fjDept.getDeptlevel();
			f_parentid = fjDept.getParentid();
			f_deptseq = fjDept.getDeptseq();
			childCount = 	ssDeptManager.getCountChildDept(fjdm);
			
		} else {
			request.setAttribute("message", "请选中分局或派出所！");
			return returnUrl;
		}
		//pmdwxxbManager.save(pmdwxxb);
		
		//创建企业组织机构
		SsDept ssDept=new SsDept();
		java.lang.Long displayorder_long = new java.lang.Long(childCount+1);
		ssDept.setDeptid(dwbm.substring(3));
		ssDept.setDeptcode(dwbm);
		ssDept.setDeptname(tcompanyinfo.getCpname());
		ssDept.setDeptdesc(tcompanyinfo.getCpname());
		ssDept.setDeptlevel(f_deptLevel+1);
		ssDept.setDeptseq(f_deptseq+dwbm+".");
		ssDept.setDepttypeid("0");
		ssDept.setDisplayorder(displayorder_long);
		ssDept.setParentid(f_deptid);
		ssDept.setStatus("1");
		
		
		//创建企业管理员用户
		SsUser ssUser=new SsUser();
		String userid = tcompanyinfogasManager.getUserSeq();
		java.lang.Long userid_long = new java.lang.Long(userid);
		ssUser.setUserid(userid_long);
		ssUser.setUsername(dwbm);
		String pwd1=tcompanyinfo.getCpcode().trim();
		String pwd2="";
		CipherUtil cipher = new CipherUtil();
		//加密
		pwd2 = cipher.generatePassword(pwd1);
		ssUser.setPassword(pwd2);
		ssUser.setFullname("企业管理员");
		ssUser.setDeptid(dwbm.substring(3));
		ssUser.setDescription(tcompanyinfo.getCpname()+"企业管理员");
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
		tcompanyinfogasManager.saveTcompanyinfo(tcompanyinfo,ssDept,ssUser,new Long(4003), userid_long);
		
		
		return returnUrl;////LIST_ACTION;
		
	}
	
	/**进入更新页面*/
	public String edit() {
		HttpServletRequest request = ServletActionContext.getRequest();
		String modtime=tcompanyinfo.getModTime();
		String modtimeFormat = DateUtil.parseString(modtime,"yyyyMMdd","yyyy-MM-dd");
		tcompanyinfo.setModTime(modtimeFormat);
		return EDIT_JSP;
	}
	
	/**
	 * 企业维护页面
	 * @return
	 */
	public String qyedit() {
		HttpServletRequest request = ServletActionContext.getRequest();
		MyUserDetails ud = null;
		String code ="";
		String pcscode = "";
		String pcsname = "";
		SecurityContext sc = SecurityContextHolder.getContext();
		Authentication auth = sc.getAuthentication();
		if ((auth != null) && auth.getPrincipal() instanceof MyUserDetails) {
			ud = (MyUserDetails) auth.getPrincipal();
			if (ud != null) {
				code =ud.getUsername();
			}
		}
		tcompanyinfo = (Tcompanyinfo)tcompanyinfogasManager.getById(code);
		String modtime=tcompanyinfo.getModTime();
		String modtimeFormat = DateUtil.parseString(modtime,"yyyyMMdd","yyyy-MM-dd");
		tcompanyinfo.setModTime(modtimeFormat);
		
		return QYEDIT_JSP;
	}
	
	/**保存更新对象*/
	public String qyupdate() {
		HttpServletRequest request = ServletActionContext.getRequest();
		String fjdm = "";//分局代码
		String pcsdm ="";//派出所代码
		if(tcompanyinfo != null && tcompanyinfo.getBurcode() != null)
			fjdm = tcompanyinfo.getBurcode();
		if(tcompanyinfo != null && tcompanyinfo.getStacode()!= null)
			pcsdm = tcompanyinfo.getStacode();
		
		String f_deptid = null;
		Integer f_deptLevel = null;
		String f_parentid = null;
		String f_deptseq = "";
		int childCount = 0;
		
		if(StringUtils.isNotEmpty(fjdm) && StringUtils.isNotEmpty(pcsdm)){
			SsDept pcsDept = (SsDept) ssDeptManager.getById(pcsdm);
			f_deptid = pcsDept.getDeptid();
			f_deptLevel = pcsDept.getDeptlevel();
			f_parentid = pcsDept.getParentid();
			f_deptseq = pcsDept.getDeptseq();
		    childCount = 	ssDeptManager.getCountChildDept(pcsdm);
			
		} else if(StringUtils.isNotEmpty(fjdm) && StringUtils.isEmpty(pcsdm)){
			SsDept fjDept = (SsDept) ssDeptManager.getById(fjdm);
			f_deptid = fjDept.getDeptid();
			f_deptLevel = fjDept.getDeptlevel();
			f_parentid = fjDept.getParentid();
			f_deptseq = fjDept.getDeptseq();
			childCount = 	ssDeptManager.getCountChildDept(fjdm);
			
		} else {
			request.setAttribute("message", "请选中分局或派出所！");
			return returnUrl;
		}
		
		SsDept ssDept=ssDeptManager.getById(tcompanyinfo.getCpcode().substring(3));
		java.lang.Long displayorder_long = new java.lang.Long(childCount+1);
		ssDept.setDeptid(tcompanyinfo.getCpcode().substring(3));
		ssDept.setDeptcode(tcompanyinfo.getCpcode());
		ssDept.setDeptname(tcompanyinfo.getCpname());
		ssDept.setDeptdesc(tcompanyinfo.getCpname());
		ssDept.setDeptlevel(f_deptLevel+1);
		ssDept.setDeptseq(f_deptseq+tcompanyinfo.getCpcode()+".");
		ssDept.setDepttypeid("0");
		ssDept.setDisplayorder(displayorder_long);
		ssDept.setParentid(f_deptid);
		ssDept.setStatus("1");
		
		tcompanyinfogasManager.updateDept(tcompanyinfo, ssDept);
		
		msg="保存成功！";
		return qyedit();
		
	}
	
	/**保存更新对象*/
	public String update() {
		HttpServletRequest request = ServletActionContext.getRequest();
		String modTimeFormat = DateUtil.parseString(request,"modTime","yyyy-MM-dd","yyyyMMdd");
		tcompanyinfo.setModTime(modTimeFormat);
		String fjdm = "";//分局代码
		String pcsdm ="";//派出所代码
		if(tcompanyinfo != null && tcompanyinfo.getBurcode() != null)
			fjdm = tcompanyinfo.getBurcode();
		if(tcompanyinfo != null && tcompanyinfo.getStacode()!= null)
			pcsdm = tcompanyinfo.getStacode();
		
		String f_deptid = null;
		Integer f_deptLevel = null;
		String f_parentid = null;
		String f_deptseq = "";
		int childCount = 0;
		
		if(StringUtils.isNotEmpty(fjdm) && StringUtils.isNotEmpty(pcsdm)){
			SsDept pcsDept = (SsDept) ssDeptManager.getById(pcsdm);
			f_deptid = pcsDept.getDeptid();
			f_deptLevel = pcsDept.getDeptlevel();
			f_parentid = pcsDept.getParentid();
			f_deptseq = pcsDept.getDeptseq();
		    childCount = 	ssDeptManager.getCountChildDept(pcsdm);
			
		} else if(StringUtils.isNotEmpty(fjdm) && StringUtils.isEmpty(pcsdm)){
			SsDept fjDept = (SsDept) ssDeptManager.getById(fjdm);
			f_deptid = fjDept.getDeptid();
			f_deptLevel = fjDept.getDeptlevel();
			f_parentid = fjDept.getParentid();
			f_deptseq = fjDept.getDeptseq();
			childCount = 	ssDeptManager.getCountChildDept(fjdm);
			
		} else {
			request.setAttribute("message", "请选中分局或派出所！");
			return returnUrl;
		}
		
		SsDept ssDept=ssDeptManager.getById(tcompanyinfo.getCpcode().substring(3));
		java.lang.Long displayorder_long = new java.lang.Long(childCount+1);
		ssDept.setDeptid(tcompanyinfo.getCpcode().substring(3));
		ssDept.setDeptcode(tcompanyinfo.getCpcode());
		ssDept.setDeptname(tcompanyinfo.getCpname());
		ssDept.setDeptdesc(tcompanyinfo.getCpname());
		ssDept.setDeptlevel(f_deptLevel+1);
		ssDept.setDeptseq(f_deptseq+tcompanyinfo.getCpcode()+".");
		ssDept.setDepttypeid("0");
		ssDept.setDisplayorder(displayorder_long);
		ssDept.setParentid(f_deptid);
		ssDept.setStatus("1");
		
		Encry en=new Encry();
		String servicedateview = DateUtil.parseString(request,"servicedateview","yyyy-MM-dd","yyyyMMdd");
		String re=en.crypt_pwd("d", "efficiently",tcompanyinfo.getCpcode()+"----"+servicedateview);
		tcompanyinfo.setServicedate(re);
		
		tcompanyinfogasManager.updateDept(tcompanyinfo, ssDept);
		return returnUrl;////LIST_ACTION;
		
	}
	
	/**删除对象*/
	public String delete() {
		for(int i = 0; i < items.length; i++) {
			Hashtable params = HttpUtils.parseQueryString(items[i]);
			java.lang.String id = new java.lang.String((String)params.get("cpcode"));
			tcompanyinfogasManager.removeById(id);
		}
		return returnUrl ;//LIST_ACTION;
	}

	public void setSsDeptManager(SsDeptManager ssDeptManager) {
		this.ssDeptManager = ssDeptManager;
	}

	public void setSsUserManager(SsUserManager ssUserManager) {
		this.ssUserManager = ssUserManager;
	}

	public TreeMap<String, String> getProvMap() {
		return provMap;
	}

	public void setProvMap(TreeMap<String, String> provMap) {
		this.provMap = provMap;
	}

	public void setTbuylogManager(TbuylogManager tbuylogManager) {
		this.tbuylogManager = tbuylogManager;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

}
