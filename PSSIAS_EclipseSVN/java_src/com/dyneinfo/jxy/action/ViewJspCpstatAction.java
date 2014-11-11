/*
 * Powered By [lishicheng]
 */

package com.dyneinfo.jxy.action;

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
import java.text.SimpleDateFormat;
import net.java.dev.common.util.DateUtil;
import org.apache.struts2.ServletActionContext;

import java.util.*;

import javacommon.base.*;
import javacommon.util.*;

import cn.org.rapid_framework.util.*;
import cn.org.rapid_framework.web.util.*;
import cn.org.rapid_framework.page.*;
import cn.org.rapid_framework.page.impl.*;
import org.apache.commons.lang.StringUtils;
import com.dyneinfo.jxy.dao.*;
import com.dyneinfo.jxy.model.*;
import com.dyneinfo.jxy.service.*;
import com.dyneinfo.zazh.service.SsDeptManager;
import com.dyneinfo.zazh.util.SpringTagFunctions;

/**
 * @author lisc email:lishicheng(a)gmail.com
 */

public class ViewJspCpstatAction extends BaseStruts2Action implements Preparable, ModelDriven {
	//默认多列排序,example: username desc,createTime asc
	protected static final String DEFAULT_SORT_COLUMNS = null;

	//forward paths

	protected static final String LIST_JSP = "/pages/jxy/ViewJspCpstat/list.jsp";
	protected static final String LISTEMP_JSP = "/pages/jxy/ViewJspCpstat/listEmp.jsp";
	protected static final String LISTDATAUPLOAD_JSP = "/pages/jxy/ViewJspCpstat/listDataUpload.jsp";
	protected static final String LISTCAR_JSP = "/pages/jxy/ViewJspCpstat/listCar.jsp";
	protected static final String LISTINSTALLANDUPLOAD_JSP = "/pages/jxy/ViewJspCpstat/listInstallAndUpload.jsp";
	
	

	private ViewJspCpstatManager viewJspCpstatManager;

	private ViewJspCpstat viewJspCpstat;
	java.lang.String id = null;
	private String[] items;
	private String returnUrl; //返回列表，保留查询条件
	private TreeMap<String, String> dateSelectMap;// //日期选择

	public void prepare() throws Exception {
		if (isNullOrEmptyString(id)) {
			viewJspCpstat = new ViewJspCpstat();
		} else {
			viewJspCpstat = (ViewJspCpstat) viewJspCpstatManager.getById(id);
		}
	}

	/** 增加setXXXX()方法,spring就可以通过autowire自动设置对象属性 */
	public void setViewJspCpstatManager(ViewJspCpstatManager manager) {
		this.viewJspCpstatManager = manager;
	}

	public Object getModel() {
		return viewJspCpstat;
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
	//	public String query() {
	//		//日历快速选择用到
	//		dateSelectMap  = DateUtil.getDateSelectData();
	////		HttpServletRequest request = ServletActionContext.getRequest();
	////		request.setAttribute("dateSelect","11");//选中本周
	////		DateUtil tt = new DateUtil();     
	////      pageRequest.getFilters().put("s_inTime_start",tt.getMondayOFWeek());//页面
	////      pageRequest.getFilters().put("s_inTime_end",tt.getCurrentWeekday());//
	//		return QUERY_JSP;
	//	}
	/** 执行搜索 */
	public String list() {
		PageRequest<Map> pageRequest = newPageRequest(DEFAULT_SORT_COLUMNS);
		HttpServletRequest request = ServletActionContext.getRequest();
		//pageRequest.getFilters().put("key",value);     //add custom filter

		SecurityContext sc = SecurityContextHolder.getContext();
		Authentication auth = sc.getAuthentication();
		MyUserDetails ud = null;
		String deptseq = "";
		String deptid = "";
		if ((auth != null) && auth.getPrincipal() instanceof MyUserDetails) {
			ud = (MyUserDetails) auth.getPrincipal();
			if (ud != null) {
				deptseq = ud.getDeptSeq();
				deptid = ud.getDeptID();
			}
		}
		dateSelectMap = DateUtil.getDateSelectData();

		String s_cpcode = "";
		if (request.getParameter("s_cpcode") != null)
			s_cpcode = request.getParameter("s_cpcode");

		String s_cpname = "";
		if (request.getParameter("s_cpname") != null)
			s_cpname = request.getParameter("s_cpname");

		String s_deptseq = "";
		if (request.getParameter("s_deptseq") != null)
			s_deptseq = request.getParameter("s_deptseq");

		String dateSelect2 = "";
		if (request.getParameter("dateSelect2") != null)
			dateSelect2 = request.getParameter("dateSelect2");
		request.setAttribute("dateSelect2", dateSelect2);

		String s_datenBeginFormat = DateUtil.parseString(request, "s_starttimeBegin", "yyyy-MM-dd", "yyyyMMdd");
		String s_datenEndFormat = DateUtil.parseString(request, "s_starttimeEnd", "yyyy-MM-dd", "yyyyMMdd");

		String t_cpcaseinfo_SqlWhere = " ";
		String t_cppunishinfo_SqlWhere = " ";

		if (StringUtils.isNotEmpty(s_datenBeginFormat)) {
			t_cpcaseinfo_SqlWhere = t_cpcaseinfo_SqlWhere + " and   case.happentime >=  '" + s_datenBeginFormat + "' ";
			t_cppunishinfo_SqlWhere = t_cppunishinfo_SqlWhere + " and  cpp.pdate >=  '" + s_datenBeginFormat + "' ";
		}

		if (StringUtils.isNotEmpty(s_datenEndFormat)) {
			t_cpcaseinfo_SqlWhere = t_cpcaseinfo_SqlWhere + " and  case.happentime <= '" + s_datenEndFormat + "' ";
			t_cppunishinfo_SqlWhere = t_cppunishinfo_SqlWhere + " and  cpp.pdate <= '" + s_datenEndFormat + "' ";
		}

		String sqlWhere = " cp.cpcode = dept.deptid ";
		if (StringUtils.isNotEmpty(s_deptseq)) {
			sqlWhere = sqlWhere + " and  dept.deptseq like '" + s_deptseq + "%' ";
		} else {
			if (SpringTagFunctions.ifAnyGranted("ROLE_QUERY_ALL,ROLE_ADMIN")) {

			} else if (SpringTagFunctions.ifAnyGranted("ROLE_QUERY_CURRENT_ORG")) {
				sqlWhere = sqlWhere + " and  dept.deptseq = '" + deptseq + "' ";
			} else if (SpringTagFunctions.ifAnyGranted("ROLE_QUERY_CHILD_ORG")) {
				sqlWhere = sqlWhere + " and  dept.deptseq like '" + deptseq + "%' ";
			} else {
				sqlWhere = sqlWhere + " and  dept.deptseq like '" + deptseq + "%' ";
			}

		}
		if (StringUtils.isNotEmpty(s_cpcode)) {
			sqlWhere = sqlWhere + " and cp.cpcode like '" + s_cpcode + "%' ";
		}
		if (StringUtils.isNotEmpty(s_cpname)) {
			sqlWhere = sqlWhere + " and  cp.cpname like '%" + s_cpname + "%' ";
		}

		String querySql = "select cp.cpcode cpcode,"
      +" cp.cpname cpname, "
      +"  (select count(*) "
      +"     from t_cpcaseinfo case "
      +"     where case.caseflag = '0' "
      +"       and case.cpcode = cp.cpcode "
      + t_cpcaseinfo_SqlWhere+") xsaj, "
      +"   (select count(*) "
      +"     from t_cpcaseinfo case "
      +"   where case.caseflag = '1' "
      +"      and case.cpcode = cp.cpcode "
      + t_cpcaseinfo_SqlWhere+") zaaj, "
      +"   (select count(*) "
      +"      from t_cppunishinfo cpp "
      +"    where cpp.ptype = '1' "
      +"      and cpp.cpcode = cp.cpcode "
      + t_cppunishinfo_SqlWhere+") jgcs, "
      +"  (select count(*) "
      +"      from t_cppunishinfo cpp "
      +"     where cpp.ptype = '4' "
      +"      and cpp.cpcode = cp.cpcode "
      + t_cppunishinfo_SqlWhere+") fmffsd, "
      +"  (select count(*) "
      +"     from t_cppunishinfo cpp "
      +"    where cpp.ptype = '5' "
      +"      and cpp.cpcode = cp.cpcode "
      + t_cppunishinfo_SqlWhere+") tyzd, "
      +"  (select count(*) "
      +"      from t_cppunishinfo cpp "
      +"    where cpp.ptype = '7' "
      +"     and cpp.cpcode = cp.cpcode "
      + t_cppunishinfo_SqlWhere+") zjzr, "
      +"  (select count(*) "
      +"     from t_cppunishinfo cpp "
      +"    where cpp.ptype not in ('1', '4', '5', '7') "
      +"      and cpp.cpcode = cp.cpcode "
      + t_cppunishinfo_SqlWhere+") qtcf "
      +"  from t_companyinfo cp,ss_dept dept "
      +"  where  "
      +sqlWhere;

		Page page = viewJspCpstatManager.findByPageRequest(querySql, pageRequest);
		savePage(page, pageRequest);

		return LIST_JSP;
	}
	
	public String listEmp() {

		PageRequest<Map> pageRequest = newPageRequest(DEFAULT_SORT_COLUMNS);
		HttpServletRequest request = ServletActionContext.getRequest();
		//pageRequest.getFilters().put("key",value);     //add custom filter

		SecurityContext sc = SecurityContextHolder.getContext();
		Authentication auth = sc.getAuthentication();
		MyUserDetails ud = null;
		String deptseq = "";
		String deptid = "";
		if ((auth != null) && auth.getPrincipal() instanceof MyUserDetails) {
			ud = (MyUserDetails) auth.getPrincipal();
			if (ud != null) {
				deptseq = ud.getDeptSeq();
				deptid = ud.getDeptID();
			}
		}
		dateSelectMap = DateUtil.getDateSelectData();

		String s_cpcode = "";
		if (request.getParameter("s_cpcode") != null)
			s_cpcode = request.getParameter("s_cpcode");

		String s_cpname = "";
		if (request.getParameter("s_cpname") != null)
			s_cpname = request.getParameter("s_cpname");

		String s_deptseq = "";
		if (request.getParameter("s_deptseq") != null)
			s_deptseq = request.getParameter("s_deptseq");

		String dateSelect2 = "";
		if (request.getParameter("dateSelect2") != null)
			dateSelect2 = request.getParameter("dateSelect2");
		request.setAttribute("dateSelect2", dateSelect2);

		String s_datenBeginFormat = DateUtil.parseString(request, "s_starttimeBegin", "yyyy-MM-dd", "yyyyMMdd");
		String s_datenEndFormat = DateUtil.parseString(request, "s_starttimeEnd", "yyyy-MM-dd", "yyyyMMdd");

		String t_cpcaseinfo_SqlWhere = " ";
		

		if (StringUtils.isNotEmpty(s_datenBeginFormat)) {
			t_cpcaseinfo_SqlWhere = t_cpcaseinfo_SqlWhere + " and  em.indate >=  '" + s_datenBeginFormat + "' ";
		}

		if (StringUtils.isNotEmpty(s_datenEndFormat)) {
			t_cpcaseinfo_SqlWhere = t_cpcaseinfo_SqlWhere + " and  em.indate <= '" + s_datenEndFormat + "' ";
		}

		String sqlWhere = " cp.cpcode = dept.deptid ";
		if (StringUtils.isNotEmpty(s_deptseq)) {
			sqlWhere = sqlWhere + " and  dept.deptseq like '" + s_deptseq + "%' ";
		} else {
			if (SpringTagFunctions.ifAnyGranted("ROLE_QUERY_ALL,ROLE_ADMIN")) {

			} else if (SpringTagFunctions.ifAnyGranted("ROLE_QUERY_CURRENT_ORG")) {
				sqlWhere = sqlWhere + " and  dept.deptseq = '" + deptseq + "' ";
			} else if (SpringTagFunctions.ifAnyGranted("ROLE_QUERY_CHILD_ORG")) {
				sqlWhere = sqlWhere + " and  dept.deptseq like '" + deptseq + "%' ";
			} else {
				sqlWhere = sqlWhere + " and  dept.deptseq like '" + deptseq + "%' ";
			}

		}
		if (StringUtils.isNotEmpty(s_cpcode)) {
			sqlWhere = sqlWhere + " and cp.cpcode like '" + s_cpcode + "%' ";
		}
		if (StringUtils.isNotEmpty(s_cpname)) {
			sqlWhere = sqlWhere + " and  cp.cpname like '%" + s_cpname + "%' ";
		}

		String querySql = " select cp.cpcode cpcode, "+
			"  cp.cpname cpname, "+
			" (select count(*) "+
			"    from t_employee em "+
			"  where em.schoolage >= '60' "+
			"    and em.flag = 0 "+
			"    and em.cpcode = cp.cpcode "+
			t_cpcaseinfo_SqlWhere+") xsaj ,  "+
			"   (select count(*) "+
			"     from t_employee em "+
			"    where em.schoolage > '20' "+
			"     and em.schoolage < '60' "+
			"     and em.flag = 0 "+
			"    and em.cpcode = cp.cpcode "+
			t_cpcaseinfo_SqlWhere+") zaaj, "+
			"  (select count(*) "+
			"    from t_employee em "+
			"   where (em.schoolage <= '20' and em.schoolage != '09') "+
			"    and em.flag = 0 "+
			"   and em.cpcode = cp.cpcode "+
			t_cpcaseinfo_SqlWhere+") jgcs, "+
			"  (select count(*) "+
			"   from t_employee em "+
			"   where em.leftdate is null "+
			"     and substr(em.NpCode, 0, 4) <> '1305' "+
			"    and em.flag = 0 "+
			"    and em.cpcode = cp.cpcode "+
			t_cpcaseinfo_SqlWhere+") fmffsd "+
			"  from t_companyinfo cp,ss_dept dept "
           +"  where  "
           +sqlWhere;

		Page page = viewJspCpstatManager.findByPageRequest(querySql, pageRequest);
		savePage(page, pageRequest);

		return LISTEMP_JSP;
	
	}
	
	
	
	
	public String listDataUpload() {

		PageRequest<Map> pageRequest = newPageRequest(DEFAULT_SORT_COLUMNS);
		HttpServletRequest request = ServletActionContext.getRequest();
		//pageRequest.getFilters().put("key",value);     //add custom filter

		SecurityContext sc = SecurityContextHolder.getContext();
		Authentication auth = sc.getAuthentication();
		MyUserDetails ud = null;
		String s_deptseq = "";
		String deptid = "";
		if ((auth != null) && auth.getPrincipal() instanceof MyUserDetails) {
			ud = (MyUserDetails) auth.getPrincipal();
			if (ud != null) {
				s_deptseq = ud.getDeptSeq();
				deptid = ud.getDeptID();
			}
		}
		dateSelectMap = DateUtil.getDateSelectData();

		

		if (request.getParameter("s_deptseq") != null && !request.getParameter("s_deptseq").equals(""))
			s_deptseq = request.getParameter("s_deptseq");

		String dateSelect2 = "";
		if (request.getParameter("dateSelect2") != null)
			dateSelect2 = request.getParameter("dateSelect2");
		request.setAttribute("dateSelect2", dateSelect2);

		String s_datenBeginFormat = DateUtil.parseString(request, "s_starttimeBegin", "yyyy-MM-dd", "yyyyMMdd");
		String s_datenEndFormat = DateUtil.parseString(request, "s_starttimeEnd", "yyyy-MM-dd", "yyyyMMdd");

		String sqlWhere = " ";
		

		if (StringUtils.isNotEmpty(s_datenBeginFormat)) {
			sqlWhere = sqlWhere + " and  a.enroltime >=  '" + s_datenBeginFormat + "0000' ";
		}

		if (StringUtils.isNotEmpty(s_datenEndFormat)) {
			sqlWhere = sqlWhere + " and  a.enroltime <= '" + s_datenEndFormat + "2359' ";
		}
		String  deptStartSqlWhere = " 1=1 ";
		
		String  sql_getParentId = " ";
		if (StringUtils.isNotEmpty(s_deptseq)) {
			sqlWhere = sqlWhere + " and  b3.deptseq like '" + s_deptseq + "%' ";
			deptStartSqlWhere = deptStartSqlWhere + " and  d.deptseq = '" + s_deptseq + "' ";
			sql_getParentId = " select deptid from ss_dept  where deptseq = '" + s_deptseq + "' ";
		} else {
			if (SpringTagFunctions.ifAnyGranted("ROLE_QUERY_ALL,ROLE_ADMIN")) {
				deptStartSqlWhere = deptStartSqlWhere + " ";
			} else if (SpringTagFunctions.ifAnyGranted("ROLE_QUERY_CURRENT_ORG")) {
				sqlWhere = sqlWhere + " and  b3.deptseq like '" + s_deptseq + "%' ";
				deptStartSqlWhere = deptStartSqlWhere + " and  d.deptseq = '" + s_deptseq + "' ";
			} else if (SpringTagFunctions.ifAnyGranted("ROLE_QUERY_CHILD_ORG")) {
				sqlWhere = sqlWhere + " and  b3.deptseq like '" + s_deptseq + "%' ";
				deptStartSqlWhere = deptStartSqlWhere + " and  d.deptseq = '" + s_deptseq + "' ";
			} else {
				sqlWhere = sqlWhere + " and  b3.deptseq like '" + s_deptseq + "%' ";
				deptStartSqlWhere = deptStartSqlWhere + " and  d.deptseq = '" + s_deptseq + "' ";
			}
			sql_getParentId = " select deptid from ss_dept  where deptseq = '" + s_deptseq + "' ";

		}
		String parentid = viewJspCpstatManager.getParentIDByDeptSeq(sql_getParentId);
		
		
		
//		select dic.code 分局代码,
//	       dic.called 分局名称,
//	       (select count(*)
//	          from t_companyinfo cp
//	         where substr(cp.station, 0, 6) = substr(dic.code, 0, 6)) 企业总数,
//	       count(car.cpcode) 已上传企业,
//	       decode(sum(upcount), null, 0, sum(upcount)) 上传数据总数
//	  from t_diccon dic,
//	       (select cpcode, count(1) upcount
//	          from V_CARINFOCOUNT
//	         where 1 = 1
//	           and (ReceTime >= '20120109' and ReceTime <= '20120109')
//	         group by cpcode) car
//	 where dic.partof = '26'
//	   and substr(dic.code, 0, 6) = substr(car.cpcode(+), 4, 6)
//	   and substr(dic.code, 0, 4) = 4408
//	 group by dic.code, dic.called

		String querySql ="SELECT deptid AS cpcode,"+
		 "        deptname AS cpname,"+
		 "        Decode(uploaddept,NULL,0,"+
		 "                          uploaddept) AS xsaj,"+
		 "        Decode(uploaddata,NULL,0,"+
		 "                          uploaddata) AS zaaj,"+
		 "        (SELECT Count(* )"+
		 "         FROM   ss_dept org,"+
		 "                t_companyinfo cpinfo"+
		 "         WHERE  cpinfo.cpcode = org.deptid"+
		 "                AND org.deptseq LIKE bbb.deptseq"+
		 "                                     ||'%') AS jgcs"+
		 " FROM   (SELECT   dept.root,"+
		 "                  Count(car.deptid) uploaddept,"+
		 "                  Decode(Sum(upcount),NULL,0,"+
		 "                                      Sum(upcount)) uploaddata"+
		 "         FROM     (SELECT id,"+
		 "                          fid,"+
		 "                          deptname,"+
		 "                          deptseq,"+
		 "                          Connect_by_root(id) root"+
		 "                   FROM   (SELECT d.deptid AS id,"+
		 "                                  d.parentid AS fid,"+
		 "                                  d.deptname,"+
		 "                                  d.deptseq"+
		 "                           FROM   ss_dept d"+
		 "                           WHERE  1 = 1"+
		 "                           START WITH "+deptStartSqlWhere+
		 "                           CONNECT BY PRIOR d.deptid = To_char(d.parentid))"+
		 "                   CONNECT BY PRIOR id = To_char(fid)) dept,"+
		 "                  (SELECT   b3.deptid,"+
		 "                            Count(a.enrolid) upcount"+
		 "                   FROM     t_carinfo a,"+
		 "                            t_carreturn b,"+
		 "                            ss_dept b3"+
		 "                   WHERE    a.enrolid = b.enrolid"+
		 "                            AND Substr(a.enrolid,0,13) = b3.deptid (+) "+sqlWhere+
		 "                   GROUP BY b3.deptid) car"+
		 "         WHERE    dept.id = car.deptid"+
		 "         GROUP BY dept.root) aaa,"+
		 "        ss_dept bbb"+
		 " WHERE  aaa.root(+) = bbb.deptid"+
		 "        AND bbb.parentid = '"+parentid+"' ";
          

		Page page = viewJspCpstatManager.findByPageRequest(querySql, pageRequest);
		savePage(page, pageRequest);

		return LISTDATAUPLOAD_JSP;
	
	}
	public String listInstallAndUpload() {
		
		PageRequest<Map> pageRequest = newPageRequest(DEFAULT_SORT_COLUMNS);
		HttpServletRequest request = ServletActionContext.getRequest();
		//pageRequest.getFilters().put("key",value);     //add custom filter
		
		SecurityContext sc = SecurityContextHolder.getContext();
		Authentication auth = sc.getAuthentication();
		MyUserDetails ud = null;
		String s_deptseq = "";
		String deptid = "";
		if ((auth != null) && auth.getPrincipal() instanceof MyUserDetails) {
			ud = (MyUserDetails) auth.getPrincipal();
			if (ud != null) {
				s_deptseq = ud.getDeptSeq();
				deptid = ud.getDeptID();
			}
		}
		dateSelectMap = DateUtil.getDateSelectData();
		
		
		
		if (request.getParameter("s_deptseq") != null && !request.getParameter("s_deptseq").equals(""))
			s_deptseq = request.getParameter("s_deptseq");
		
		String dateSelect2 = "";
		if (request.getParameter("dateSelect2") != null)
			dateSelect2 = request.getParameter("dateSelect2");
		request.setAttribute("dateSelect2", dateSelect2);
		
		String s_datenBeginFormat = DateUtil.parseString(request, "s_starttimeBegin", "yyyy-MM-dd", "yyyyMMdd");
		String s_datenEndFormat = DateUtil.parseString(request, "s_starttimeEnd", "yyyy-MM-dd", "yyyyMMdd");
		
		String sqlWhere = " ";
		
		
		if (StringUtils.isNotEmpty(s_datenBeginFormat)) {
			sqlWhere = sqlWhere + " and  a.enroltime >=  '" + s_datenBeginFormat + "0000' ";
		}
		
		if (StringUtils.isNotEmpty(s_datenEndFormat)) {
			sqlWhere = sqlWhere + " and  a.enroltime <= '" + s_datenEndFormat + "2359' ";
		}
		String  deptStartSqlWhere = " 1=1 ";
		
		String  sql_getParentId = " ";
		if (StringUtils.isNotEmpty(s_deptseq)) {
			sqlWhere = sqlWhere + " and  b3.deptseq like '" + s_deptseq + "%' ";
			deptStartSqlWhere = deptStartSqlWhere + " and  d.deptseq = '" + s_deptseq + "' ";
			sql_getParentId = " select deptid from ss_dept  where deptseq = '" + s_deptseq + "' ";
		} else {
			if (SpringTagFunctions.ifAnyGranted("ROLE_QUERY_ALL,ROLE_ADMIN")) {
				deptStartSqlWhere = deptStartSqlWhere + " ";
			} else if (SpringTagFunctions.ifAnyGranted("ROLE_QUERY_CURRENT_ORG")) {
				sqlWhere = sqlWhere + " and  b3.deptseq like '" + s_deptseq + "%' ";
				deptStartSqlWhere = deptStartSqlWhere + " and  d.deptseq = '" + s_deptseq + "' ";
			} else if (SpringTagFunctions.ifAnyGranted("ROLE_QUERY_CHILD_ORG")) {
				sqlWhere = sqlWhere + " and  b3.deptseq like '" + s_deptseq + "%' ";
				deptStartSqlWhere = deptStartSqlWhere + " and  d.deptseq = '" + s_deptseq + "' ";
			} else {
				sqlWhere = sqlWhere + " and  b3.deptseq like '" + s_deptseq + "%' ";
				deptStartSqlWhere = deptStartSqlWhere + " and  d.deptseq = '" + s_deptseq + "' ";
			}
			sql_getParentId = " select deptid from ss_dept  where deptseq = '" + s_deptseq + "' ";
			
		}
		String parentid = viewJspCpstatManager.getParentIDByDeptSeq(sql_getParentId);
		
//		if(parentid.equals("1000")){
//			String sql = "select t.deptid from V_DEPT t where t.parentid='1000'";
//			parentid = viewJspCpstatManager.getColBySql(sql);
//		}
		
		
		String querySql = "SELECT deptid AS cpcode,"+
		 "        deptname AS cpname,"+
		 "        Decode(uploaddept,NULL,0,"+
		 "                          uploaddept) AS xsaj,"+
		 "        Decode(uploaddata,NULL,0,"+
		 "                          uploaddata) AS zaaj,"+
		 "        (SELECT Count(* )"+
		 "         FROM   ss_dept org,"+
		 "                t_companyinfo cpinfo"+
		 "         WHERE  cpinfo.cpcode = org.deptid"+
		 "                AND org.deptseq LIKE bbb.deptseq"+
		 "                                     ||'%') AS jgcs,"+
		 "        (SELECT Count(* )"+
		 "         FROM   ss_dept org,"+
		 "                t_companyinfo cpinfo"+
		 "         WHERE  cpinfo.cpcode = org.deptid"+
		 "                AND cpinfo.flag = '0'"+
		 "                AND org.deptseq LIKE bbb.deptseq"+
		 "                                     ||'%') AS opennum,"+
		 "        (SELECT Count(* )"+
		 "         FROM   ss_dept org,"+
		 "                t_companyinfo cpinfo"+
		 "         WHERE  cpinfo.cpcode = org.deptid"+
		 "                AND cpinfo.flag = '1'"+
		 "                AND org.deptseq LIKE bbb.deptseq"+
		 "                                     ||'%') AS closenum,"+
		 "        ((SELECT Count(* )"+
		 "          FROM   ss_dept org,"+
		 "                 t_companyinfo cpinfo"+
		 "          WHERE  cpinfo.cpcode = org.deptid"+
		 "                 AND cpinfo.flag = '0'"+
		 "                 AND org.deptseq LIKE bbb.deptseq"+
		 "                                      ||'%') - Decode(uploaddept,NULL,0,"+
		 "                                                                 uploaddept)) AS unuploadnum"+
		 " FROM   (SELECT   dept.root,"+
		 "                  Count(car.deptid) uploaddept,"+
		 "                  Decode(Sum(upcount),NULL,0,"+
		 "                                      Sum(upcount)) uploaddata"+
		 "         FROM     (SELECT id,"+
		 "                          fid,"+
		 "                          deptname,"+
		 "                          deptseq,"+
		 "                          Connect_by_root(id) root"+
		 "                   FROM   (SELECT d.deptid AS id,"+
		 "                                  d.parentid AS fid,"+
		 "                                  d.deptname,"+
		 "                                  d.deptseq"+
		 "                           FROM   ss_dept d"+
		 "                           WHERE  1 = 1"+
		 "                           START WITH "+ deptStartSqlWhere +
		 "                           CONNECT BY PRIOR d.deptid = To_char(d.parentid))"+
		 "                   CONNECT BY PRIOR id = To_char(fid)) dept,"+
		 "                  (SELECT   b3.deptid,"+
		 "                            Count(a.enrolid) upcount"+
		 "                   FROM     t_carinfo a,"+
		 "                            t_carreturn b,"+
		 "                            ss_dept b3,"+
		 "                            t_companyinfo c"+
		 "                   WHERE    a.enrolid = b.enrolid"+
		 "                            AND a.cpcode = c.cpcode"+
		 "                            AND c.flag = '0'"+
		 "                            AND Substr(a.enrolid,0,13) = b3.deptid (+) "+sqlWhere+
		 "                   GROUP BY b3.deptid) car"+
		 "         WHERE    dept.id = car.deptid"+
		 "         GROUP BY dept.root) aaa,"+
		 "        ss_dept bbb"+
		 " WHERE  aaa.root(+) = bbb.deptid"+
		 "        AND bbb.parentid = '"+parentid+"' ";
		
		
		Page page = viewJspCpstatManager.findByPageRequest(querySql, pageRequest);
		savePage(page, pageRequest);
		
		return LISTINSTALLANDUPLOAD_JSP;
		
	}

	
	public String listCar() {
		PageRequest<Map> pageRequest = newPageRequest(DEFAULT_SORT_COLUMNS);
		HttpServletRequest request = ServletActionContext.getRequest();
		//pageRequest.getFilters().put("key",value);     //add custom filter

		SecurityContext sc = SecurityContextHolder.getContext();
		Authentication auth = sc.getAuthentication();
		MyUserDetails ud = null;
		String s_deptseq = "";
		String deptid = "";
		if ((auth != null) && auth.getPrincipal() instanceof MyUserDetails) {
			ud = (MyUserDetails) auth.getPrincipal();
			if (ud != null) {
				s_deptseq = ud.getDeptSeq();
				deptid = ud.getDeptID();
			}
		}
		dateSelectMap = DateUtil.getDateSelectData();



		
		String s_cpcode = "";
		if (request.getParameter("s_cpcode") != null)
			s_cpcode = request.getParameter("s_cpcode");

		String s_cpname = "";
		if (request.getParameter("s_cpname") != null)
			s_cpname = request.getParameter("s_cpname");


		if (request.getParameter("s_deptseq") != null && !request.getParameter("s_deptseq").equals(""))
			s_deptseq = request.getParameter("s_deptseq");

		String sqlWhere = "  ";
		String dateSelect2 = "";
		if (request.getParameter("dateSelect2") != null)
			dateSelect2 = request.getParameter("dateSelect2");
		request.setAttribute("dateSelect2", dateSelect2);
		
		String s_datenBeginFormat = DateUtil.parseString(request, "s_starttimeBegin", "yyyy-MM-dd", "yyyyMMdd");
		String s_datenEndFormat = DateUtil.parseString(request, "s_starttimeEnd", "yyyy-MM-dd", "yyyyMMdd");
		
		if (StringUtils.isNotEmpty(s_datenBeginFormat)) {
			sqlWhere = sqlWhere + " and  a.enroltime >=  '" + s_datenBeginFormat + "0000' ";
		}
		if (StringUtils.isNotEmpty(s_datenEndFormat)) {
			sqlWhere = sqlWhere + " and  a.enroltime <= '" + s_datenEndFormat + "2359' ";
		}
		
		String dateSelect3 = "";
		if (request.getParameter("dateSelect3") != null)
			dateSelect3 = request.getParameter("dateSelect3");
		request.setAttribute("dateSelect3", dateSelect3);
		String s_startDateBeginFormat = DateUtil.parseString(request, "s_startDateBegin", "yyyy-MM-dd", "yyyyMMdd");
		String s_startDateEndFormat = DateUtil.parseString(request, "s_startDateEnd", "yyyy-MM-dd", "yyyyMMdd");

		if (StringUtils.isNotEmpty(s_startDateBeginFormat)) {
			sqlWhere = sqlWhere + " and  b.totime >=  '" + s_startDateBeginFormat + "0000' ";
		}
		if (StringUtils.isNotEmpty(s_startDateEndFormat)) {
			sqlWhere = sqlWhere + " and  b.totime <= '" + s_startDateEndFormat + "2359' ";
		}	
		
		
		String sqlWhereDept = " ";
		
		if (StringUtils.isNotEmpty(s_cpcode)) {
			sqlWhereDept = sqlWhereDept + " and bbb.deptid like '" + s_cpcode + "%' ";
		}
		if (StringUtils.isNotEmpty(s_cpname)) {
			sqlWhereDept = sqlWhereDept + " and  bbb.deptname like '%" + s_cpname + "%' ";
		}
		


		String  deptStartSqlWhere = " 1=1 ";
		
		
		
		
		String sql_getParentId ="";
		if (StringUtils.isNotEmpty(s_deptseq)) {
			sqlWhere = sqlWhere + " and  b3.deptseq like '" + s_deptseq + "%' ";
			deptStartSqlWhere = deptStartSqlWhere + " and  d.deptseq = '" + s_deptseq + "' ";
			sql_getParentId = " select deptid from ss_dept  where deptseq = '" + s_deptseq + "' ";
		} else {
			if (SpringTagFunctions.ifAnyGranted("ROLE_QUERY_ALL,ROLE_ADMIN")) {
				deptStartSqlWhere = deptStartSqlWhere + " ";
			} else if (SpringTagFunctions.ifAnyGranted("ROLE_QUERY_CURRENT_ORG")) {
				sqlWhere = sqlWhere + " and  b3.deptseq like '" + s_deptseq + "%' ";
				deptStartSqlWhere = deptStartSqlWhere + " and  d.deptseq = '" + s_deptseq + "' ";
			} else if (SpringTagFunctions.ifAnyGranted("ROLE_QUERY_CHILD_ORG")) {
				sqlWhere = sqlWhere + " and  b3.deptseq like '" + s_deptseq + "%' ";
				deptStartSqlWhere = deptStartSqlWhere + " and  d.deptseq = '" + s_deptseq + "' ";
			} else {
				sqlWhere = sqlWhere + " and  b3.deptseq like '" + s_deptseq + "%' ";
				deptStartSqlWhere = deptStartSqlWhere + " and  d.deptseq = '" + s_deptseq + "' ";
			}
			sql_getParentId = " select deptid from ss_dept  where deptseq = '" + s_deptseq + "' ";
		}
	    String parentid = viewJspCpstatManager.getParentIDByDeptSeq(sql_getParentId);

		String querySql = "select deptid as cpcode,deptname as cpname,nvl(cheLiangCount,0) as xsaj "
			+ "  from  "
			+ " (select dept.root, "
			+ "      nvl(sum(car.cheLiangCount), 0) cheLiangCount "
			+ " from (select id, fid, deptname, deptseq, connect_by_root(id) root "
			+ "   from (select d.deptid   as id, "
			+ "             d.parentid as fid, "
			+ "            d.deptname, "
			+ "            d.deptseq "
			+ "       from ss_dept d "
			+ "      where 1 = 1 "
			+ "      start with  "+deptStartSqlWhere
			+ "     connect by prior d.deptid = to_char(d.parentid)) "
			+ "  connect by prior id = to_char(fid)) dept, "
			+ "  (select b3.deptid, count(a.enrolid) cheLiangCount "
			+ "   from t_carinfo a, t_carreturn b, ss_dept b3 "
			+ "  where a.enrolid = b.enrolid "
			+ "    and substr(a.enrolid,0,13) = b3.deptid(+) "+sqlWhere
			+ "  group by b3.deptid) car "
			+ " where dept.id = car.deptid "
			+ " group by dept.root) aaa, "
			+ " ss_dept bbb "
			+ "  where aaa.root(+) = bbb.deptid and bbb.parentid = '"+parentid+"' ";
          

		Page page = viewJspCpstatManager.findByPageRequest(querySql, pageRequest);
		savePage(page, pageRequest);

		return LISTCAR_JSP;
	
	}
	

}
