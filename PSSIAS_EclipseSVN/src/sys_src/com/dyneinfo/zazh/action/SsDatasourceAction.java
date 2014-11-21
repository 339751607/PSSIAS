/*
 * Powered By [lishicheng]
 */

package com.dyneinfo.zazh.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cn.org.rapid_framework.beanutils.BeanUtils;

import com.opensymphony.xwork2.Preparable;
import com.opensymphony.xwork2.ModelDriven;

import org.security.userdetails.MyUserDetails;
import org.security.userdetails.jdbc.SessionUserCount;
import org.springframework.security.Authentication;
import org.springframework.security.context.SecurityContext;
import org.springframework.security.context.SecurityContextHolder;
import java.text.SimpleDateFormat;

import net.java.dev.common.dict.taglib.DictHelpImpl;
import net.java.dev.common.util.DateUtil;
import org.apache.struts2.ServletActionContext;

import java.util.*;

import javacommon.base.*;
import javacommon.util.*;

import cn.org.rapid_framework.util.*;
import cn.org.rapid_framework.web.util.*;
import cn.org.rapid_framework.page.*;
import cn.org.rapid_framework.page.impl.*;

import com.dyneinfo.zazh.model.*;
import com.dyneinfo.zazh.dao.*;
import com.dyneinfo.zazh.service.*;
import com.dyneinfo.zazh.util.ToolUtil;

/**
 * @author lisc email:lishicheng(a)gmail.com
 */


public class SsDatasourceAction extends BaseStruts2Action implements Preparable,ModelDriven{
	//默认多列排序,example: username desc,createTime asc
	protected static final String DEFAULT_SORT_COLUMNS = null; 
	
	//forward paths
	protected static final String QUERY_JSP = "/pages/zazh/SsDatasource/query.jsp";
	protected static final String LIST_JSP= "/pages/zazh/SsDatasource/list.jsp";
	protected static final String CREATE_JSP = "/pages/zazh/SsDatasource/create.jsp";
	protected static final String EDIT_JSP = "/pages/zazh/SsDatasource/edit.jsp";
	protected static final String SHOW_JSP = "/pages/zazh/SsDatasource/show.jsp";
	protected static final String LOGINFO_JSP = "/pages/zazh/SsDatasource/loginfo.jsp";
	//redirect paths,startWith: !
	protected static final String LIST_ACTION = "!/pages/zazh/SsDatasource/list.do";
	
	private SsDatasourceManager ssDatasourceManager;
	
	private SsDatasource ssDatasource;
	Long id = null;
	private String[] items;
	private String returnUrl;  //返回列表，保留查询条件
	private TreeMap<String, String> dateSelectMap;// //日期选择

	public void prepare() throws Exception {
		if (isNullOrEmptyString(id)) {
			ssDatasource = new SsDatasource();
		} else {
			ssDatasource = (SsDatasource)ssDatasourceManager.getById(id);
		}
	}
	
	/** 增加setXXXX()方法,spring就可以通过autowire自动设置对象属性 */
	public void setSsDatasourceManager(SsDatasourceManager manager) {
		this.ssDatasourceManager = manager;
	}	
	
	public Object getModel() {
		return ssDatasource;
	}
	
	public void setId(Long val) {
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
	public String loginfo() {
		HttpServletRequest request = ServletActionContext.getRequest();
		net.sf.json.JSONArray jsonArray = null;
        SecurityContext sc = SecurityContextHolder.getContext();
        Authentication auth = sc.getAuthentication();
        MyUserDetails ud = null;
		String username = "";
		String deptid = "";
		String deptlevel = "";
		if ((auth != null) && auth.getPrincipal() instanceof MyUserDetails) {
			ud = (MyUserDetails) auth.getPrincipal();
			if (ud != null) {
				username = ud.getUserName();
				deptid = ud.getDeptID();
				deptlevel = ud.getDeptLevel();
			}
		}	
		
		//用户总数
		String sql="SELECT COUNT(*) FROM SS_USER WHERE ENABLED='1' ";
		int userTotal = ssDatasourceManager.getCountForSQL(sql).intValue();
        request.setAttribute("usertotal", userTotal);	    
	    //在线用户数
        SessionUserCount userCount = new SessionUserCount();
	    request.setAttribute("usercount", userCount.getCount());
	    
	    String deptWhere = " 1=1 ";
	    //分局用户
	    if("2".equals(deptlevel)){
	    	deptWhere += " AND cp.burcode = '" + deptid + "' ";
	    }
	    //派出所用户
	    if("3".equals(deptlevel)){
	    	deptWhere += " AND cp.stacode = '" + deptid + "' ";
	    }
	    //企业数统计
	    sql = " select code, called, nvl(inCount,0) incount, 0 inCount1 "
            + " from ss_datasource t1, (select BUSINESSCODE, count(1) inCount from t_companyinfo cp WHERE " + deptWhere + " group by BUSINESSCODE) t2 "
            + " where isvalid = '1' and code<>'000'  and t1.code = t2.BUSINESSCODE(+) "
            + " order by code ";
	    List compList = ssDatasourceManager.getLogInfoForMap(sql);
	    request.setAttribute("compList", compList);
	    jsonArray = net.sf.json.JSONArray.fromObject(compList);
	    request.setAttribute("jsonStr1", jsonArray.toString());
	    //采录数据数统计
        sql = " select code, called, nvl(inCount, 0) incount, 0 inCount1" 
            + "  from ss_datasource t1, (select source, sum(inCount) inCount "
	        + "        from (select source, count(id) inCount "
	        + "             from t_personlog_jn jn "
	        + "             Where exists( select cpcode from t_companyinfo cp WHERE " + deptWhere + " AND cp.cpcode = jn.cpcode )"
	        + "             group by source "
	        + "           union all "
	        + "           select source, count(id) inCount "
	        + "             from t_personlog_jw jw"
	        + "             Where exists( select cpcode from t_companyinfo cp WHERE " + deptWhere + " AND cp.cpcode = jw.cpcode )"
	        + "             group by source "
	        + "           union all "
	        + "           select source, count(id) inCount "
	        + "             from t_carlog car "
	        + "             Where exists( select cpcode from t_companyinfo cp WHERE " + deptWhere + " AND cp.cpcode = car.cpcode )"
	        + "             group by source) "
	        + "        group by source) t2 "
	        + " where code <> '000' "
	        + " and t1.code = t2.source(+) "
	        + " order by code ";
        List dataList = ssDatasourceManager.getLogInfoForMap(sql);
	    request.setAttribute("dataList", dataList);
	    jsonArray = net.sf.json.JSONArray.fromObject(dataList);
	    request.setAttribute("jsonStr2", jsonArray.toString());
	    //统计报警数
	    sql = " select code, called, nvl(inCount, 0) incount, nvl(inCount1, 0) inCount1 "
	        + " from ss_datasource t1, "
	        + "    (select alarmsource, sum(inCount) inCount "
	        + "       from (select alarmsource, count(id) inCount "
	        + "               from t_alarm_person p "
	        + "               Where exists( select cpcode from t_companyinfo cp WHERE " + deptWhere + " AND cp.cpcode = p.cpcode )"
	        + "              group by alarmsource "
	        + "             union all "
	        + "             select alarmsource, count(id) inCount "
	        + "               from t_alarm_car car "
	        + "             Where exists( select cpcode from t_companyinfo cp WHERE " + deptWhere + " AND cp.cpcode = car.cpcode )"
	        + "              group by alarmsource) "
	        + "      group by alarmsource) t2, "
	        + "    (select alarmsource, sum(inCount) inCount1 "
	        + "       from (select alarmsource, count(id) inCount "
	        + "               from t_alarm_person per "
	        + "              where clflag = '0' "
	        + "              AND  exists( select cpcode from t_companyinfo cp WHERE " + deptWhere + " AND cp.cpcode = per.cpcode )"
	        + "              group by alarmsource "
	        + "             union all "
	        + "             select alarmsource, count(id) inCount "
	        + "               from t_alarm_car car1 "	       
	        + "               where clflag = '0' "
	        + "               AND  exists( select cpcode from t_companyinfo cp WHERE " + deptWhere + " AND cp.cpcode = car1.cpcode )"
	        + "               group by alarmsource) "
	        + "      group by alarmsource) t3 "
	        + " where code <> '000' "
	        + " and t1.code = t2.alarmsource(+) "
	        + " and t1.code = t3.alarmsource(+) "
	        + " order by code ";
	    
	    List alermList = ssDatasourceManager.getLogInfoForMap(sql);
	    request.setAttribute("alermList", alermList);
	    jsonArray = net.sf.json.JSONArray.fromObject(alermList);
	    request.setAttribute("jsonStr3", jsonArray.toString());
	    String days = DictHelpImpl.getInitData("NOUPLOADDATE");
	    int intDay = 3;
        if(days != null && !"".equals(days)){
        	try{
        		intDay = Integer.parseInt(days);
        	}catch(Exception e){
        		
        	}
        	
        }
	    Date today = new Date();
	    Date d = new Date(today.getTime()-intDay*24*60*60*1000);
	    SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
	    String sql_date = sdf.format(d);
	    
	    SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
	    String disp_date = df.format(d);
	    request.setAttribute("disp_date", disp_date);
	    
	    String whereTime = " where STATUS = '1' "
	    	+ "              and moddate <= '"+sql_date+"' "
	    	+ "              and STARTTIME >= '"+sql_date+"2359' "
	    	+ "              and t.cpcode = cp.cpcode ";
	    
	    sql = "select code, called, nvl(inCount, 0) incount, 0 inCount1 "
	    	+ " from ss_datasource t1, "
	    	+ "  (select BUSINESSCODE, count(cpcode) inCount "
	    	+ "     from t_companyinfo cp "
	    	+ "     where " + deptWhere 
	    	+ "     and  not exists (select id "
	    	+ "             from t_personlog_jn t "
	    	+ "              " + whereTime
	    	+ "           union all "
	    	+ "           select id "
	    	+ "              from t_personlog_jw t "
	    	+ "              " + whereTime
	    	+ "           union all "
	    	+ "           select id "
	    	+ "             from t_carlog t "
	    	+ "             " + whereTime
	    	+ "           ) "
	    	+ "    group by businesscode) t2 "
	    	+ "  where code<>'000' and t1.code = t2.BUSINESSCODE(+) "
	    	+ "  order by code ";
	    
	    List uploadList = ssDatasourceManager.getLogInfoForMap(sql);
	    request.setAttribute("uploadList", uploadList);
	    jsonArray = net.sf.json.JSONArray.fromObject(uploadList);
	    request.setAttribute("jsonStr4", jsonArray.toString());
		return LOGINFO_JSP;
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
		pageRequest.getFilters().put("sortColumns", "code");
		Page page = ssDatasourceManager.findByPageRequest(pageRequest);
		savePage(page,pageRequest);
		return LIST_JSP;
	}
	
	/** 查看对象*/
	public String show() {
		HttpServletRequest request = ServletActionContext.getRequest();

		return SHOW_JSP;
	}
	
	/** 进入新增页面*/
	public String create() {
		return CREATE_JSP;
	}
	
	/** 保存新增对象 */
	public String save() {
		HttpServletRequest request = ServletActionContext.getRequest();
		String code = ssDatasource.getCode();
		String dbKey = ToolUtil.getDBKey(code);
		ssDatasource.setDbsName(dbKey);
		if(code!=null && !"".equals(code)){
			SsDatasource source= ssDatasourceManager.getDataSouceByBusinessCode(code);
			if(source!=null && source.getCode()!=null){
				request.setAttribute("message",ssDatasource.getCalled() + "数据源已经存在，拒绝重复添加！");
				return CREATE_JSP;
			}
		}
		String url = "jdbc:oracle:thin:@";
		String dbIP = request.getParameter("dbIP")==null?"":request.getParameter("dbIP").toString();
		String dbPort = request.getParameter("dbPort")==null?"":request.getParameter("dbPort").toString();
		String dbServ = request.getParameter("dbServ")==null?"":request.getParameter("dbServ").toString();
		if("".equals(dbIP) || "".equals(dbPort) || "".equals(dbServ)){
			request.setAttribute("message", "数据源的IP地址，端口号以及服务名称都不能为空，拒绝添加！");
		    return CREATE_JSP;
		}
		url = url + dbIP + ":"+ dbPort + ":" + dbServ;
		ssDatasource.setDbsUrl(url);
		ssDatasourceManager.save(ssDatasource);
		return returnUrl;////LIST_ACTION;
	}
	
	/**进入更新页面*/
	public String edit() {
		HttpServletRequest request = ServletActionContext.getRequest();
		if(ssDatasource == null){
			ssDatasource = new SsDatasource();
		}else{
			String url = ssDatasource.getDbsUrl();
			String prefix = "jdbc:oracle:thin:@";
			url = url.substring(prefix.length());
			String[] dbArray = url.split(":");
			if(dbArray != null && dbArray.length > 0){
			   String dbIP = dbArray.length>=1? dbArray[0] : "";
			   String dbPort = dbArray.length>=2? dbArray[1] : "";
			   String dbServ = dbArray.length>=3? dbArray[2] : "";
			   request.setAttribute("dbIP", dbIP);
			   request.setAttribute("dbPort", dbPort);
			   request.setAttribute("dbServ", dbServ);
			}
		}
		return EDIT_JSP;
	}
	
	/**保存更新对象*/
	public String update() {
		HttpServletRequest request = ServletActionContext.getRequest();
		String code = ssDatasource.getCode();
		if(code!= null && !"".equals(code)){
			SsDatasource source= ssDatasourceManager.getDataSouceByBusinessCode(code);
			if( source==null && source.getCode() == null){
				request.setAttribute("message",ssDatasource.getCalled() + "数据源不存在，拒绝更新！");
				return CREATE_JSP;
			}
		}
		
		String url = "jdbc:oracle:thin:@";
		String dbIP = request.getParameter("dbIP")==null?"":request.getParameter("dbIP").toString();
		String dbPort = request.getParameter("dbPort")==null?"":request.getParameter("dbPort").toString();
		String dbServ = request.getParameter("dbServ")==null?"":request.getParameter("dbServ").toString();
		if("".equals(dbIP) || "".equals(dbPort) || "".equals(dbServ)){
			request.setAttribute("message", "数据源的IP地址，端口号以及服务名称都不能为空，拒绝添加！");
		    return CREATE_JSP;
		}
		url = url + dbIP + ":"+ dbPort + ":" + dbServ;
		ssDatasource.setDbsUrl(url);
		
		ssDatasourceManager.update(this.ssDatasource);
		
		return returnUrl;////LIST_ACTION;
	}
	
	/**删除对象*/
	public String delete() {
		for(int i = 0; i < items.length; i++) {
			Hashtable params = HttpUtils.parseQueryString(items[i]);
			Long id = new Long((String)params.get("id"));
			ssDatasourceManager.removeById(id);
		}
		return returnUrl ;//LIST_ACTION;
	}

}
