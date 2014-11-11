/*
 * Powered By [lishicheng]
 */

package com.dyneinfo.pmdd.action;

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
import com.dyneinfo.zazh.util.SpringTagFunctions;
import java.util.*;

import javacommon.base.*;
import javacommon.util.*;

import cn.org.rapid_framework.util.*;
import cn.org.rapid_framework.web.util.*;
import cn.org.rapid_framework.page.*;
import cn.org.rapid_framework.page.impl.*;

import com.dyneinfo.pmdd.dao.*;
import com.dyneinfo.pmdd.model.*;
import com.dyneinfo.pmdd.service.*;

/**
 * @author lisc email:lishicheng(a)gmail.com
 */


public class StaClAction extends BaseStruts2Action implements Preparable,ModelDriven{
	//默认多列排序,example: username desc,createTime asc
	protected static final String DEFAULT_SORT_COLUMNS = null; 
	
	//forward paths
	protected static final String QUERY_JSP = "/pages/pmdd/StaCl/query.jsp";
	protected static final String LIST_JSP= "/pages/pmdd/StaCl/list.jsp";
	protected static final String DC_LIST_JSP= "/pages/pmdd/StaCl/dclist.jsp";
	protected static final String FC_LIST_JSP= "/pages/pmdd/StaCl/fclist.jsp";
	//redirect paths,startWith: !
	protected static final String LIST_ACTION = "!/pages/pmdd/StaCl/list.do";
	
	private StaClpmddManager staClManager;
	
	private StaCl staCl;
	Long id = null;
	private String[] items;
	private String returnUrl;  //返回列表，保留查询条件
	private TreeMap<String, String> dateSelectMap;// //日期选择

	public void prepare() throws Exception {
		if (isNullOrEmptyString(id)) {
			staCl = new StaCl();
		} else {
			staCl = (StaCl)staClManager.getById(id);
		}
	}
	
	/** 增加setXXXX()方法,spring就可以通过autowire自动设置对象属性 */
	public void setStaClpmddManager(StaClpmddManager manager) {
		this.staClManager = manager;
	}	
	
	public Object getModel() {
		return staCl;
	}
	
	public void setRowkey(Long val) {
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
	public String list() {
		PageRequest<Map> pageRequest = newPageRequest(DEFAULT_SORT_COLUMNS);
		HttpServletRequest request = ServletActionContext.getRequest();
		dateSelectMap = DateUtil.getDateSelectData();
		String dateSelect2 = "";
		if (request.getParameter("dateSelect2") != null)
			dateSelect2 = request.getParameter("dateSelect2");
		request.setAttribute("dateSelect2", dateSelect2);
		
		String  countSql   = "";
		String  querySql   = "";
		String  dataSqlWhere = " 1=1 ";
		String  deptStartSqlWhere = " 1=1 ";
		String  deptLevelCond = " 1=1 ";		
		String  sql_deptlevel = " ";		
		String username = "";
		String deptid = "";
		String deptseq = "";
		String deptlevel = "";

		SecurityContext sc = SecurityContextHolder.getContext();
		Authentication auth = sc.getAuthentication();
		MyUserDetails ud = null;
		if ((auth != null) && auth.getPrincipal() instanceof MyUserDetails) {
			ud = (MyUserDetails) auth.getPrincipal();
			if (ud != null) {
				deptid = ud.getDeptID();
				deptseq = ud.getDeptSeq();
				deptlevel = ud.getDeptLevel();
			}
		}
		
		
		String search_deptseq = "";
		if (request.getParameter("s_deptseq") != null)
			search_deptseq = request.getParameter("s_deptseq");
		if (search_deptseq != null && search_deptseq.length() > 0) {
			dataSqlWhere = dataSqlWhere + " and  t.deptseq like '" + search_deptseq + "%' ";
			deptStartSqlWhere = deptStartSqlWhere + " and  d.deptseq = '" + search_deptseq + "' ";
			sql_deptlevel = " select deptlevel from ss_dept  where deptseq = '" + search_deptseq + "' ";
			deptlevel =  staClManager.getDeptlevel(sql_deptlevel);
		} else {

			if (SpringTagFunctions.ifAnyGranted("ROLE_QUERY_ALL,ROLE_ADMIN")) {
				deptStartSqlWhere = deptStartSqlWhere + " and  d.parentid =1 ";
			} else if (SpringTagFunctions.ifAnyGranted("ROLE_QUERY_CURRENT_ORG")) {
				dataSqlWhere = dataSqlWhere + " and  t.deptseq = '" + deptseq + "' ";
				deptStartSqlWhere = deptStartSqlWhere + " and  d.deptseq = '" + deptseq + "' ";
			} else if (SpringTagFunctions.ifAnyGranted("ROLE_QUERY_CHILD_ORG")) {
				dataSqlWhere = dataSqlWhere + " and  t.deptseq like '" + deptseq + "%' ";
				deptStartSqlWhere = deptStartSqlWhere + " and  d.deptseq = '" + deptseq + "' ";
			} else {
				dataSqlWhere = dataSqlWhere + " and  t.deptseq like '" + deptseq + "%' ";
				deptStartSqlWhere = deptStartSqlWhere + " and  d.deptseq = '" + deptseq + "' ";
			}
			sql_deptlevel = " select deptlevel from ss_dept  where deptseq = '" + deptseq + "' ";
		}
		
		
		
		int childdep_count;
		int childjoinDep_count;
		if (search_deptseq != null && search_deptseq.length() > 0) {
			childdep_count = (int) staClManager.getTagOrgByDeptseq(" select count(*) from ss_dept where DEPTSEQ like '"+search_deptseq+"%'");
			//childjoinDep_count = (int) staClManager.getTagOrgByDeptseq("select count(*) from ss_dept where parentid in ( select deptid from  PMDWXXB a,ss_dept b where b.DEPTSEQ = '"+search_deptseq+"')");
		} else{
			childdep_count = (int) staClManager.getTagOrgByDeptseq(" select count(*) from ss_dept where DEPTSEQ like '"+deptseq+"%'");
			//childjoinDep_count = (int) staClManager.getTagOrgByDeptseq("select count(*) from ss_dept where parentid in ( select deptid from  PMDWXXB a,ss_dept b where b.DEPTSEQ = '"+deptseq+"')");
		}
		    if (deptlevel != null && deptlevel.length() > 0) {
			int dep_level_int = Integer.parseInt(deptlevel);
			if (childdep_count > 1)
				dep_level_int = dep_level_int + 1;
			deptLevelCond = deptLevelCond + " and dept.deptlevel = '" + dep_level_int + "' ";
		}
		   
//			if (childjoinDep_count <= 1)
//				request.setAttribute("searchButton", "hidden");
//			else
//				request.setAttribute("searchButton", "show");

		String s_datenBeginFormat = DateUtil.parseString(request, "s_starttimeBegin", "yyyy-MM-dd", "yyyyMMdd");
		String s_datenEndFormat = DateUtil.parseString(request, "s_starttimeEnd", "yyyy-MM-dd", "yyyyMMdd");

		String ctx = request.getContextPath(); 
		String linkUrl = ctx+"/pages/StaCl/list.do?";

		if (s_datenBeginFormat != null && s_datenBeginFormat.length() > 0) {
			dataSqlWhere = dataSqlWhere + " and  t.ddrq >=  '" + s_datenBeginFormat+ "' ";
			linkUrl = linkUrl + "s_starttimeBegin="+request.getParameter("s_starttimeBegin")+"&";
		}
		if (s_datenEndFormat != null && s_datenEndFormat.length() > 0) {
			dataSqlWhere = dataSqlWhere + " and  t.ddrq <= '" + s_datenEndFormat+ "' ";
			linkUrl = linkUrl + "s_starttimeEnd="+request.getParameter("s_starttimeEnd")+"&";
		}

		querySql= " select dept.deptid as ROWKEY,dept.deptname as ROWNAME,dept.deptseq as DEPTSEQ,oneZl as oneZl ,twoZl as twoZl,sumZl as  sumZl,NVL((SELECT 'N'  FROM ss_dept deptL  WHERE dept.deptid=deptL.Parentid    AND ROWNUM  < 2),'Y') isLeaf   "
			+ " from "
			+ "   (select a.root as id,nvl(sum(b.oneZl), 0) oneZl,nvl(sum(b.twoZl), 0) twoZl,nvl(sum(b.sumZl), 0) sumZl  "
			+ "   from (select id, fid,deptname ,connect_by_root(id) root "
			+ "       from (select d.deptid as id, d.parentid as fid,d.deptname "
			+ "         from ss_dept d "
			+ "         start with "+deptStartSqlWhere
			+ "        connect by prior d.deptid = d.parentid) "
			+ "    connect by prior id = fid) a "
			+ "  left join ( select deptid , "
			+ "   max(case  when  SFSH='0'  and stype='0'  then num else 0 end) oneZl, "//否
			+ "   max(case  when  SFSH='1'  and stype='0'  then num else 0 end)  twoZl, "//是
			+ "   sum(decode(stype,'0',num,0)) sumZl "
			+ "  from "
			+ "      (select t.deptid,t.SFSH,count(t.deptid) num ,'0' stype "
			+ "        from v_sta_cl  t where "+dataSqlWhere
			+ "       group by t.deptid,t.SFSH ) "
			+ "   where deptid is not null "
			+ "   group by deptid ) b "
			+ "   on a.id = b.deptid "
			+ "  group by root order by root ) g,ss_dept dept "
			+ "   where g.id=dept.deptid and "+deptLevelCond;
		
		String s_groupType ="0";
		if(request.getParameter("s_groupType")!=null)
			s_groupType = request.getParameter("s_groupType");
		request.setAttribute("s_groupType",s_groupType);
		
		linkUrl = linkUrl + "s_groupType="+s_groupType+"&";
		if(s_groupType != null && !s_groupType.equals("0")){
			List list=(List)staClManager.getXML(querySql);
			String swfFile = "Column3D.swf";
			if(s_groupType.equals("1"))
				swfFile = "Pie3D.swf";
			else if(s_groupType.equals("2"))
				swfFile = "Column3D.swf";
			request.setAttribute("strXML", getXml(ctx,swfFile,"车辆质押统计","单位","数量","100%","77%",list,linkUrl));
			
			if(list.size()>15)
				request.setAttribute("scro", "scro");
			
		}
		
		Page page = staClManager.findByPageRequest(querySql,pageRequest);
		savePage(page,pageRequest);
		return LIST_JSP;
	}
	
	
	
	/** 执行搜索 */
	public String dclist() {
		PageRequest<Map> pageRequest = newPageRequest(DEFAULT_SORT_COLUMNS);
		HttpServletRequest request = ServletActionContext.getRequest();
		dateSelectMap = DateUtil.getDateSelectData();
		String dateSelect2 = "";
		if (request.getParameter("dateSelect2") != null)
			dateSelect2 = request.getParameter("dateSelect2");
		request.setAttribute("dateSelect2", dateSelect2);
		
		String  countSql   = "";
		String  querySql   = "";
		String  dataSqlWhere = " 1=1 ";
		String  deptStartSqlWhere = " 1=1 ";
		String  deptLevelCond = " 1=1 ";
		
		String  sql_deptlevel = " ";
		
		String username = "";
		String deptid = "";
		String deptseq = "";
		String deptlevel ="";

		SecurityContext sc = SecurityContextHolder.getContext();
		Authentication auth = sc.getAuthentication();
		MyUserDetails ud = null;
		if ((auth != null) && auth.getPrincipal() instanceof MyUserDetails) {
			ud = (MyUserDetails) auth.getPrincipal();
			if (ud != null) {
				deptid = ud.getDeptID();
				deptseq = ud.getDeptSeq();
				deptlevel = ud.getDeptLevel();
			}
		}
		
		
		String search_deptseq = "";
		if (request.getParameter("s_deptseq") != null)
			search_deptseq = request.getParameter("s_deptseq");
		if (search_deptseq != null && search_deptseq.length() > 0) {
			dataSqlWhere = dataSqlWhere + " and  t.deptseq like '" + search_deptseq + "%' ";
			deptStartSqlWhere = deptStartSqlWhere + " and  d.deptseq = '" + search_deptseq + "' ";
			sql_deptlevel = " select deptlevel from ss_dept  where deptseq = '" + search_deptseq + "' ";
			deptlevel =  staClManager.getDeptlevel(sql_deptlevel);
		} else {

			if (SpringTagFunctions.ifAnyGranted("ROLE_QUERY_ALL,ROLE_ADMIN")) {
				deptStartSqlWhere = deptStartSqlWhere + " and  d.parentid =1 ";
			} else if (SpringTagFunctions.ifAnyGranted("ROLE_QUERY_CURRENT_ORG")) {
				dataSqlWhere = dataSqlWhere + " and  t.deptseq = '" + deptseq + "' ";
				deptStartSqlWhere = deptStartSqlWhere + " and  d.deptseq = '" + deptseq + "' ";
			} else if (SpringTagFunctions.ifAnyGranted("ROLE_QUERY_CHILD_ORG")) {
				dataSqlWhere = dataSqlWhere + " and  t.deptseq like '" + deptseq + "%' ";
				deptStartSqlWhere = deptStartSqlWhere + " and  d.deptseq = '" + deptseq + "' ";
			} else {
				dataSqlWhere = dataSqlWhere + " and  t.deptseq like '" + deptseq + "%' ";
				deptStartSqlWhere = deptStartSqlWhere + " and  d.deptseq = '" + deptseq + "' ";
			}
			sql_deptlevel = " select deptlevel from ss_dept  where deptseq = '" + deptseq + "' ";
		}
//		String deptlevel = staClManager.getDeptLevelBySeq(sql_deptlevel);
		
		int childdep_count;
		//int childjoinDep_count;
		if (search_deptseq != null && search_deptseq.length() > 0) {
			childdep_count = (int) staClManager.getTagOrgByDeptseq(" select count(*) from ss_dept where DEPTSEQ like '"+search_deptseq+"%'  ");
			//childjoinDep_count = (int) staClManager.getTagOrgByDeptseq("select count(*) from ss_dept where parentid in ( select deptid from  PMDWXXB a,ss_dept b where b.DEPTSEQ = '"+search_deptseq+"')");
		} else{
			childdep_count = (int) staClManager.getTagOrgByDeptseq(" select count(*) from ss_dept where DEPTSEQ like '"+deptseq+"%'");
			//childjoinDep_count = (int) staClManager.getTagOrgByDeptseq("select count(*) from ss_dept where parentid in ( select deptid from  PMDWXXB a,ss_dept b where b.DEPTSEQ = '"+deptseq+"')");
		  }
		if (deptlevel != null && deptlevel.length() > 0) {
			int dep_level_int = Integer.parseInt(deptlevel);
			if (childdep_count > 1)
				dep_level_int = dep_level_int + 1;
			deptLevelCond = deptLevelCond + " and dept.deptlevel = '" + dep_level_int + "' ";
		}
		
		

		String s_datenBeginFormat = DateUtil.parseString(request, "s_starttimeBegin", "yyyy-MM-dd", "yyyyMMdd");
		String s_datenEndFormat = DateUtil.parseString(request, "s_starttimeEnd", "yyyy-MM-dd", "yyyyMMdd");

		String ctx = request.getContextPath(); 
		String linkUrl = ctx+"/pages/StaCl/dclist.do?";

		if (s_datenBeginFormat != null && s_datenBeginFormat.length() > 0) {
			dataSqlWhere = dataSqlWhere + " and  t.ddrq >=  '" + s_datenBeginFormat+ "' ";
			linkUrl = linkUrl + "s_starttimeBegin="+request.getParameter("s_starttimeBegin")+"&";
		}
		if (s_datenEndFormat != null && s_datenEndFormat.length() > 0) {
			dataSqlWhere = dataSqlWhere + " and  t.ddrq <= '" + s_datenEndFormat+ "' ";
			linkUrl = linkUrl + "s_starttimeEnd="+request.getParameter("s_starttimeEnd")+"&";
		}

		querySql= " select dept.deptid as ROWKEY,dept.deptname as ROWNAME,dept.deptseq as DEPTSEQ,oneZl as oneZl ,twoZl as twoZl,sumZl as  sumZl,NVL((SELECT 'N'  FROM ss_dept deptL  WHERE dept.deptid=deptL.Parentid    AND ROWNUM  < 2),'Y') isLeaf  "
			+ " from "
			+ "   (select a.root as id,nvl(sum(b.oneZl), 0) oneZl,nvl(sum(b.twoZl), 0) twoZl,nvl(sum(b.sumZl), 0) sumZl  "
			+ "   from (select id, fid,deptname ,connect_by_root(id) root "
			+ "       from (select d.deptid as id, d.parentid as fid,d.deptname "
			+ "         from ss_dept d "
			+ "         start with "+deptStartSqlWhere
			+ "        connect by prior d.deptid = d.parentid) "
			+ "    connect by prior id = fid) a "
			+ "  left join ( select deptid , "
			+ "   max(case  when  SFSH='0'  and stype='0'  then num else 0 end) oneZl, "//否
			+ "   max(case  when  SFSH='1'  and stype='0'  then num else 0 end)  twoZl, "//是
			+ "   sum(decode(stype,'0',num,0)) sumZl "
			+ "  from "
			+ "      (select t.deptid,t.SFSH,count(t.deptid) num ,'0' stype "
			+ "        from v_sta_dc  t where "+dataSqlWhere
			+ "       group by t.deptid,t.SFSH ) "
			+ "   where deptid is not null "
			+ "   group by deptid ) b "
			+ "   on a.id = b.deptid "
			+ "  group by root order by root ) g,ss_dept dept "
			+ "   where g.id=dept.deptid and "+deptLevelCond;
		
		String s_groupType ="0";
		if(request.getParameter("s_groupType")!=null)
			s_groupType = request.getParameter("s_groupType");
		request.setAttribute("s_groupType",s_groupType);
		
		linkUrl = linkUrl + "s_groupType="+s_groupType+"&";
		if(s_groupType != null && !s_groupType.equals("0")){
			List list=(List)staClManager.getXML(querySql);
			String swfFile = "Column3D.swf";
			if(s_groupType.equals("1"))
				swfFile = "Pie3D.swf";
			else if(s_groupType.equals("2"))
				swfFile = "Column3D.swf";
			request.setAttribute("strXML", getXml(ctx,swfFile,"动产质押统计","单位","数量","100%","77%",list,linkUrl));
			
			if(list.size()>15)
				request.setAttribute("scro", "scro");
			
		}
		
		Page page = staClManager.findByPageRequest(querySql,pageRequest);
		savePage(page,pageRequest);
		return DC_LIST_JSP;
	}
	
	
	/** 执行搜索 */
	public String fclist() {
		PageRequest<Map> pageRequest = newPageRequest(DEFAULT_SORT_COLUMNS);
		HttpServletRequest request = ServletActionContext.getRequest();
		dateSelectMap = DateUtil.getDateSelectData();
		String dateSelect2 = "";
		if (request.getParameter("dateSelect2") != null)
			dateSelect2 = request.getParameter("dateSelect2");
		request.setAttribute("dateSelect2", dateSelect2);
		
		String  countSql   = "";
		String  querySql   = "";
		String  dataSqlWhere = " 1=1 ";
		String  deptStartSqlWhere = " 1=1 ";
		String  deptLevelCond = " 1=1 ";
		
		String  sql_deptlevel = " ";
		
		String username = "";
		String deptid = "";
		String deptseq = "";
		String deptlevel = "";
		SecurityContext sc = SecurityContextHolder.getContext();
		Authentication auth = sc.getAuthentication();
		MyUserDetails ud = null;
		if ((auth != null) && auth.getPrincipal() instanceof MyUserDetails) {
			ud = (MyUserDetails) auth.getPrincipal();
			if (ud != null) {
				deptid = ud.getDeptID();
				deptseq = ud.getDeptSeq();
				deptlevel = ud.getDeptLevel();
			}
		}
		
		
		String search_deptseq = "";
		if (request.getParameter("s_deptseq") != null)
			search_deptseq = request.getParameter("s_deptseq");
		if (search_deptseq != null && search_deptseq.length() > 0) {
			dataSqlWhere = dataSqlWhere + " and  t.deptseq like '" + search_deptseq + "%' ";
			deptStartSqlWhere = deptStartSqlWhere + " and  d.deptseq = '" + search_deptseq + "' ";
			sql_deptlevel = " select deptlevel from ss_dept  where deptseq = '" + search_deptseq + "' ";
			deptlevel =  staClManager.getDeptlevel(sql_deptlevel);
		} else {

			if (SpringTagFunctions.ifAnyGranted("ROLE_QUERY_ALL,ROLE_ADMIN")) {
				deptStartSqlWhere = deptStartSqlWhere + " and  d.parentid =1 ";
			} else if (SpringTagFunctions.ifAnyGranted("ROLE_QUERY_CURRENT_ORG")) {
				dataSqlWhere = dataSqlWhere + " and  t.deptseq = '" + deptseq + "' ";
				deptStartSqlWhere = deptStartSqlWhere + " and  d.deptseq = '" + deptseq + "' ";
			} else if (SpringTagFunctions.ifAnyGranted("ROLE_QUERY_CHILD_ORG")) {
				dataSqlWhere = dataSqlWhere + " and  t.deptseq like '" + deptseq + "%' ";
				deptStartSqlWhere = deptStartSqlWhere + " and  d.deptseq = '" + deptseq + "' ";
			} else {
				dataSqlWhere = dataSqlWhere + " and  t.deptseq like '" + deptseq + "%' ";
				deptStartSqlWhere = deptStartSqlWhere + " and  d.deptseq = '" + deptseq + "' ";
			}
			sql_deptlevel = " select deptlevel from ss_dept  where deptseq = '" + deptseq + "' ";
		}
		
		
		int childdep_count;
		//int childjoinDep_count;
		if (search_deptseq != null && search_deptseq.length() > 0) {
			childdep_count = (int) staClManager.getTagOrgByDeptseq(" select count(*) from ss_dept where DEPTSEQ like '"+search_deptseq+"%'  ");
			//childjoinDep_count = (int) staClManager.getTagOrgByDeptseq("select count(*) from ss_dept where parentid in ( select deptid from  PMDWXXB a,ss_dept b where b.DEPTSEQ = '"+search_deptseq+"')");
		} else{
			childdep_count = (int) staClManager.getTagOrgByDeptseq(" select count(*) from ss_dept where DEPTSEQ like '"+deptseq+"%'");
			//childjoinDep_count = (int) staClManager.getTagOrgByDeptseq("select count(*) from ss_dept where parentid in ( select deptid from  PMDWXXB a,ss_dept b where b.DEPTSEQ = '"+deptseq+"')");
		}
		    if (deptlevel != null && deptlevel.length() > 0) {
			int dep_level_int = Integer.parseInt(deptlevel);
			if (childdep_count > 1)
				dep_level_int = dep_level_int + 1;
			deptLevelCond = deptLevelCond + " and dept.deptlevel = '" + dep_level_int + "' ";
		}
//		if (childjoinDep_count <= 1)
//			request.setAttribute("searchButton", "hidden");
//		else
//			request.setAttribute("searchButton", "show");
			

		String s_datenBeginFormat = DateUtil.parseString(request, "s_starttimeBegin", "yyyy-MM-dd", "yyyyMMdd");
		String s_datenEndFormat = DateUtil.parseString(request, "s_starttimeEnd", "yyyy-MM-dd", "yyyyMMdd");
		String ctx = request.getContextPath(); 
		String linkUrl = ctx+"/pages/StaCl/fclist.do?";

		if (s_datenBeginFormat != null && s_datenBeginFormat.length() > 0) {
			dataSqlWhere = dataSqlWhere + " and  t.ddrq >=  '" + s_datenBeginFormat+ "' ";
			linkUrl = linkUrl + "s_starttimeBegin="+request.getParameter("s_starttimeBegin")+"&";
		}
		if (s_datenEndFormat != null && s_datenEndFormat.length() > 0) {
			dataSqlWhere = dataSqlWhere + " and  t.ddrq <= '" + s_datenEndFormat+ "' ";
			linkUrl = linkUrl + "s_starttimeEnd="+request.getParameter("s_starttimeEnd")+"&";
		}

		querySql= " select dept.deptid as ROWKEY,dept.deptname as ROWNAME,dept.deptseq as DEPTSEQ,oneZl as oneZl ,twoZl as twoZl,sumZl as  sumZl,NVL((SELECT 'N'  FROM ss_dept deptL  WHERE dept.deptid=deptL.Parentid    AND ROWNUM  < 2),'Y') isLeaf  "
			+ " from "
			+ "   (select a.root as id,nvl(sum(b.oneZl), 0) oneZl,nvl(sum(b.twoZl), 0) twoZl,nvl(sum(b.sumZl), 0) sumZl  "
			+ "   from (select id, fid,deptname ,connect_by_root(id) root "
			+ "       from (select d.deptid as id, d.parentid as fid,d.deptname "
			+ "         from ss_dept d "
			+ "         start with "+deptStartSqlWhere
			+ "        connect by prior d.deptid = d.parentid) "
			+ "    connect by prior id = fid) a "
			+ "  left join ( select deptid , "
			+ "   max(case  when  SFSH='0'  and stype='0'  then num else 0 end) oneZl, "//否
			+ "   max(case  when  SFSH='1'  and stype='0'  then num else 0 end)  twoZl, "//是
			+ "   sum(decode(stype,'0',num,0)) sumZl "
			+ "  from "
			+ "      (select t.deptid,t.SFSH,count(t.deptid) num ,'0' stype "
			+ "        from v_sta_fc  t where "+dataSqlWhere
			+ "       group by t.deptid,t.SFSH ) "
			+ "   where deptid is not null "
			+ "   group by deptid ) b "
			+ "   on a.id = b.deptid "
			+ "  group by root order by root ) g,ss_dept dept "
			+ "   where g.id=dept.deptid and "+deptLevelCond;
		
		String s_groupType ="0";
		if(request.getParameter("s_groupType")!=null)
			s_groupType = request.getParameter("s_groupType");
		request.setAttribute("s_groupType",s_groupType);
		
		linkUrl = linkUrl + "s_groupType="+s_groupType+"&";
		if(s_groupType != null && !s_groupType.equals("0")){
			List list=(List)staClManager.getXML(querySql);
			String swfFile = "Column3D.swf";
			if(s_groupType.equals("1"))
				swfFile = "Pie3D.swf";
			else if(s_groupType.equals("2"))
				swfFile = "Column3D.swf";
			request.setAttribute("strXML", getXml(ctx,swfFile,"房产质押统计","单位","数量","100%","77%",list,linkUrl));
			
			if(list.size()>15)
				request.setAttribute("scro", "scro");
			
		}
		
		Page page = staClManager.findByPageRequest(querySql,pageRequest);
		savePage(page,pageRequest);
		return FC_LIST_JSP;
	}
	

	public String getXml(String ctx,String swf,String caption,String xAxisName,String yAxisName,String width,String height,List list,String linkUrl){
		StringBuffer strXML=new StringBuffer();
		if(!list.isEmpty()&&list.size()>0){
			strXML.append("var chart_basicChart = new FusionCharts({\"id\":\"basicChart\"," +
					"\"registerWithJS\":\"0\"," +
					"\"width\":\""+width+"\"," +
					"\"dataFormat\":\"xml\"," +
					"\"debugMode\":\"0\"," +
					"\"dataSource\":\"" +
					"<chart caption='"+caption+"' " +
					"xAxisName='"+xAxisName+"' " +
					"yAxisName='"+yAxisName+"' " +
					"showValues='0' " +
					"showAboutMenuItem='0' " +
					"aboutMenuItemLabel='关于' " +
					"aboutMenuItemLink='n-/site_about.html' " +
					"formatNumberScale='0' " +
					"showBorder='1'>"); 
			
			
			for(int i=0;i<list.size();i++){
				
			
				Map map=(Map)list.get(i);
				strXML.append("<set label='");
				strXML.append(map.get("deptname"));
				strXML.append("'  link='"+linkUrl+"s_deptseq="+map.get("deptseq")+"' value='");
				strXML.append(map.get("sumZl"));

				strXML.append("'/>");
			}
			
			strXML.append("</chart>\",\"height\":\""+height+"\"," +
					"\"swfUrl\":\""+ctx+"/FusionCharts/"+swf+"\"," +
					"\"renderAt\":\"basicChartDiv\"}).render();");
		}
		

		return strXML.toString();
	}


}
