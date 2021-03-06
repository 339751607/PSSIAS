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
import org.springframework.security.Authentication;
import org.springframework.security.context.SecurityContext;
import org.springframework.security.context.SecurityContextHolder;

import java.io.PrintWriter;
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

import com.dyneinfo.zazh.model.*;
import com.dyneinfo.zazh.dao.*;
import com.dyneinfo.zazh.service.*;
import com.dyneinfo.zazh.util.DictFun;
import com.dyneinfo.zazh.util.ToolUtil;

/**
 * @author lisc email:lishicheng(a)gmail.com
 */


public class TpersonbaseJnAction extends BaseStruts2Action implements Preparable,ModelDriven{
	//默认多列排序,example: username desc,createTime asc
	protected static final String DEFAULT_SORT_COLUMNS = null; 
	
	//forward paths
	protected static final String QUERY_JSP = "/pages/zazh/TpersonbaseJn/query.jsp";
	protected static final String LIST_JSP= "/pages/zazh/TpersonbaseJn/list.jsp";
	protected static final String CREATE_JSP = "/pages/zazh/TpersonbaseJn/create.jsp";
	protected static final String EDIT_JSP = "/pages/zazh/TpersonbaseJn/edit.jsp";
	protected static final String SHOW_JSP = "/pages/zazh/TpersonbaseJn/show.jsp";
	//redirect paths,startWith: !
	protected static final String LIST_ACTION = "!/pages/zazh/TpersonbaseJn/list.do";
	
	
	protected static final String ANALYQUERY_JSP = "/pages/zazh/TpersonbaseJn/analyquery.jsp";
	protected static final String ANALYLIST_JSP= "/pages/zazh/TpersonbaseJn/analylist.jsp";
	protected static final String ANALYSHOW_JSP = "/pages/zazh/TpersonbaseJn/analyshow.jsp";
	protected static final String ANALYSHOWTRACK_JSP = "/pages/zazh/TpersonbaseJn/analyshowtrack.jsp";
	protected static final String ANALYSHOWLINE_JSP = "/pages/zazh/TpersonbaseJn/analyshowline.jsp";
	
	private TpersonbaseJnManager tpersonbaseJnManager;
	private SsDatasourceManager ssDatasourceManager;
	private TpersonlogJnManager tpersonlogJnManager;
	
	private TpersonbaseJn tpersonbaseJn;
	Long id = null;
	private String[] items;
	private String returnUrl;  //返回列表，保留查询条件
	private TreeMap<String, String> dateSelectMap;// //日期选择

	public void prepare() throws Exception {
		if (isNullOrEmptyString(id)) {
			tpersonbaseJn = new TpersonbaseJn();
		} else {
			tpersonbaseJn = (TpersonbaseJn)tpersonbaseJnManager.getById(id);
		}
	}
	
	/** 增加setXXXX()方法,spring就可以通过autowire自动设置对象属性 */
	public void setTpersonbaseJnManager(TpersonbaseJnManager manager) {
		this.tpersonbaseJnManager = manager;
	}	
	
	public Object getModel() {
		return tpersonbaseJn;
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
	/** 进入查询页面 */
	public String analyquery() {
		//日历快速选择用到
		dateSelectMap  = DateUtil.getDateSelectData();

		return ANALYQUERY_JSP;
	}
	/** 执行搜索 */
	public String analylist() {
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
		String dateSelect8 = "";
		if (request.getParameter("dateSelect8") != null)
		    dateSelect8 = request.getParameter("dateSelect8");
			request.setAttribute("dateSelect8",dateSelect8);		        
		
		Page page = tpersonbaseJnManager.findByPageRequest(pageRequest);
		savePage(page,pageRequest);
		return ANALYLIST_JSP;
	}
	
	/** 查看对象*/
	public String analyshow() {
		PageRequest<Map> pageRequest = newPageRequest(DEFAULT_SORT_COLUMNS);
		HttpServletRequest request = ServletActionContext.getRequest();
		
		tpersonbaseJn.setBdate(DateUtil.parseString(tpersonbaseJn.getBdate(), "yyyyMMdd", "yyyy-MM-dd"));
			
		String s_starttime = request.getParameter("s_starttime")==null?"":request.getParameter("s_starttime");
		String s_endtime = request.getParameter("s_endtime")==null?"":request.getParameter("s_endtime");
		
		request.setAttribute("s_starttime", s_starttime);
		request.setAttribute("s_endtime", s_endtime);
	
		pageRequest.getFilters().put("cardnam", tpersonbaseJn.getCardname());
		pageRequest.getFilters().put("cardno", tpersonbaseJn.getCardcode());
		
		String idName = this.tpersonbaseJn.getCardname();
		String idCode = this.tpersonbaseJn.getCardcode();

		getPicture(request, idName, idCode);
		
		String starttime = "";
		String endtime = "";
        if(!"".equals(s_starttime)){
    	  starttime = s_starttime.replace("-","");
    	  starttime = starttime + "0000";
        }
        if(!"".equals(s_endtime)){
          endtime = s_endtime.replace("-","");
          endtime = endtime + "2359";
        }
		pageRequest.getFilters().put("starttime", starttime);
		pageRequest.getFilters().put("endtime", endtime);
		
		Page page = tpersonlogJnManager.findLogsInfoByPageRequest(pageRequest);
		savePage(page,pageRequest);

		return ANALYSHOW_JSP;
	}
	/** 查看对象*/
	public String analyshowLine() {
		PageRequest<Map> pageRequest = newPageRequest(DEFAULT_SORT_COLUMNS);
		HttpServletRequest request = ServletActionContext.getRequest();
		
		tpersonbaseJn.setBdate(DateUtil.parseString(tpersonbaseJn.getBdate(), "yyyyMMdd", "yyyy-MM-dd"));
		
		pageRequest.getFilters().put("cardnam", tpersonbaseJn.getCardname());
		pageRequest.getFilters().put("cardno", tpersonbaseJn.getCardcode());
		
		String idName = this.tpersonbaseJn.getCardname();
		String idCode = this.tpersonbaseJn.getCardcode();
	
		getPicture(request, idName, idCode);
		
		String s_starttime = request.getParameter("s_starttime")==null?"":request.getParameter("s_starttime");
		String s_endtime = request.getParameter("s_endtime")==null?"":request.getParameter("s_endtime");
		
		request.setAttribute("s_starttime", s_starttime);
		request.setAttribute("s_endtime", s_endtime);
		
		String starttime = "";
		String endtime = "";
        if(!"".equals(s_starttime)){
    	  starttime = s_starttime.replace("-","");
    	  starttime = starttime + "0000";
        }
        if(!"".equals(s_endtime)){
          endtime = s_endtime.replace("-","");
          endtime = endtime + "2359";
        }
		pageRequest.getFilters().put("starttime", starttime);
		pageRequest.getFilters().put("endtime", endtime);	
		
		String subtitle ="查询时间段：从 "+s_starttime+" 到 "+s_endtime;
		pageRequest.setPageNumber(1);
		pageRequest.setPageSize(100000);
		Page page = tpersonlogJnManager.findLogsInfoByPageRequest(pageRequest);		
		List listMap = new ArrayList();
        List list = page.getResult();
        if(list!=null && list.size() > 0){
	       	for(int i = list.size()-1 ; i >= 0 ; i--){
				TpersonlogJn log =(TpersonlogJn)list.get(i);
				HashMap map = new HashMap();
				String str_starttime = log.getStarttime()==null?"":log.getStarttime();
				if(!"".equals(str_starttime)){
					str_starttime = str_starttime.substring(0,8);
					str_starttime = DateUtil.parseString(str_starttime, "yyyyMMdd", "yyyy-MM-dd");
				}
				map.put("disp_starttime",str_starttime);
				String activeName = DictFun.getDictValue("DIC_ITEM_BUSINESSTYPE",log.getPersontype());
				map.put("activeName",activeName);
				map.put("activeCode",log.getPersontype());
				String cpname = log.getCpname()==null?log.getCpcode():log.getCpname();
				map.put("cpname",cpname);
				map.put("starttime", DateUtil.parseString(log.getStarttime(), "yyyyMMddHHmm", "yyyy-MM-dd HH:mm"));
				map.put("endtime", DateUtil.parseString(log.getEndtime(), "yyyyMMddHHmm", "yyyy-MM-dd HH:mm"));
				
				map.put("cardname", log.getCardname());
				map.put("cardcode", log.getCardno());				
				map.put("sid", log.getSid());
				map.put("source", log.getSource());
				map.put("cpcode", log.getCpcode());
				
				listMap.add(map);
				//listMap.add(map);
				//listMap.add(map);
				//listMap.add(map);
				//listMap.add(map);
				//listMap.add(map);
				//listMap.add(map);
	       	}
	       	if(listMap!=null && listMap.size()>0){
	       		String ctx = request.getContextPath();
	       		String trackInfo = ToolUtil.getTrackMap(listMap,ctx, "jn");
	       		request.setAttribute("trackInfo", trackInfo);
	       	}
        }
		return ANALYSHOWLINE_JSP;
	}
	/** 查看对象*/
	public String analyshowTrackMap() {
		PageRequest<Map> pageRequest = newPageRequest(DEFAULT_SORT_COLUMNS);
		HttpServletRequest request = ServletActionContext.getRequest();
		
		tpersonbaseJn.setBdate(DateUtil.parseString(tpersonbaseJn.getBdate(), "yyyyMMdd", "yyyy-MM-dd"));
		
		pageRequest.getFilters().put("cardnam", tpersonbaseJn.getCardname());
		pageRequest.getFilters().put("cardno", tpersonbaseJn.getCardcode());
		
		String idName = this.tpersonbaseJn.getCardname();
		String idCode = this.tpersonbaseJn.getCardcode();
	
		getPicture(request, idName, idCode);
		
		String s_starttime = request.getParameter("s_starttime")==null?"":request.getParameter("s_starttime");
		String s_endtime = request.getParameter("s_endtime")==null?"":request.getParameter("s_endtime");
		
		request.setAttribute("s_starttime", s_starttime);
		request.setAttribute("s_endtime", s_endtime);
		
		String starttime = "";
		String endtime = "";
        if(!"".equals(s_starttime)){
    	  starttime = s_starttime.replace("-","");
    	  starttime = starttime + "0000";
        }
        if(!"".equals(s_endtime)){
          endtime = s_endtime.replace("-","");
          endtime = endtime + "2359";
        }
		pageRequest.getFilters().put("starttime", starttime);
		pageRequest.getFilters().put("endtime", endtime);	
		
		String subtitle ="查询时间段：从 "+s_starttime+" 到 "+s_endtime;

		Page page = tpersonlogJnManager.findLogsInfoByPageRequest(pageRequest);		
		request.setAttribute("strXML", getXml(page.getResult(),subtitle));

	
		return ANALYSHOWTRACK_JSP;
	}
	public String getXml(List list, String subtitle ){
		StringBuffer strXML=new StringBuffer();
		
		if(!list.isEmpty()&&list.size()>0){
			
			strXML.append("<graph caption='行为轨迹' subcaption='"+subtitle+"'  xAxisName='时间' yAxisName=''  ")
			      .append(" showAlternateHGridColor='true' numberSuffix='' showNames='1' baseFontSize='12' ")//样式
			      .append(" anchorRadius='10' anchorSides='10'  anchorRadius='10' anchorSides='10' anchorBgColor='0BBF59'  ")  //显示的提示圆圈的大小
			      .append(" canvasBorderColor='FFFFFF' lineThickness='1' formatNumberScale='0' showDivLinues ='0' ")
			      .append(" yAxisMinValue='0' yAxisMaxValue='2' showLegend='1' showLimits='0' divLineDecimalPrecision='0' ")  //y轴的显示方式
			      .append(" numVDivLines='0' numDivLines='0'   ") //单元格的显示
			      .append(" showToolTip='1' showValues='1' labelDisplay='ROTATE' slantLabels='1'  ")
			      .append(" > ")			
			      ;		

			for(int i = list.size()-1 ; i >= 0 ; i--){
				TpersonlogJn log =(TpersonlogJn)list.get(i);
				strXML.append("<set label='");
				String starttime = log.getStarttime()==null?"":log.getStarttime();
				if(!"".equals(starttime)){
					starttime = starttime.substring(0,8);
					starttime = DateUtil.parseString(starttime, "yyyyMMdd", "yyyy-MM-dd");
				}
				strXML.append(starttime);
				//只是水平显示
				strXML.append("' value='1");
				//strXML.append(log.getPersontype());				
				strXML.append("' displayValue='");
				String activeName = DictFun.getDictValue("DIC_ITEM_BUSINESSTYPE",log.getPersontype());
				String cpname = log.getCpname()==null?"":log.getCpname();
				strXML.append(activeName+"("+ cpname + ")");
				strXML.append("' toolText='");
				
				strXML.append(activeName + ":" + cpname) ;
				strXML.append("   起止时间:" + DateUtil.parseString(log.getStarttime(), "yyyyMMddHHmm", "yyyy-MM-dd HH:mm"));
				strXML.append(" - " + DateUtil.parseString(log.getEndtime(), "yyyyMMddHHmm", "yyyy-MM-dd HH:mm"));
				//strXML.append("' link='javascript:alert(123455)");
				strXML.append("' />");
			}			
			strXML.append("</graph>");
		}
		return strXML.toString();
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
		String dateSelect8 = "";
		if (request.getParameter("dateSelect8") != null)
		    dateSelect8 = request.getParameter("dateSelect8");
			request.setAttribute("dateSelect8",dateSelect8);		        
		
		Page page = tpersonbaseJnManager.findByPageRequest(pageRequest);
		savePage(page,pageRequest);
		return LIST_JSP;
	}
	
	/** 查看对象*/
	public String show() {
		PageRequest<Map> pageRequest = newPageRequest(DEFAULT_SORT_COLUMNS);
		HttpServletRequest request = ServletActionContext.getRequest();
		
		tpersonbaseJn.setBdate(DateUtil.parseString(tpersonbaseJn.getBdate(), "yyyyMMdd", "yyyy-MM-dd"));
				
		HashMap map = new HashMap();
		map.put("sortColumns", "code");
		map.put("isvalid", "1");  //开通的行业
		map.put("not_code", "000");
		
		List list = ToolUtil.getBusinessCodeIsValid(ssDatasourceManager,map);
		request.setAttribute("businessCode", list);
		
		String idName = this.tpersonbaseJn.getCardname();
		String idCode = this.tpersonbaseJn.getCardcode();
		
		getPicture(request, idName, idCode);
		
		return SHOW_JSP;
	}
	private void getPicture(HttpServletRequest request, String idName, String idCode){
		
		if(idName != null && idCode != null 
				   && !"".equals(idName) && !"".equals(idCode)){
			
			        PageRequest<Map> pgReq = newPageRequest(DEFAULT_SORT_COLUMNS);
			        pgReq.setPageNumber(1);			        
			        pgReq.getFilters().put("cardname", idName);
			        pgReq.getFilters().put("cardno", idCode);
			        pgReq.getFilters().put("starttime", "");
			        pgReq.getFilters().put("endtime", "");
			        
				    Page page = this.tpersonlogJnManager.findLogsInfoByPageRequest(pgReq);
				    if(page!=null){
				    	
				    	List resultList = page.getResult();
				    	
				    	if(resultList!=null && resultList.size()>0){
				    		
				    		TpersonlogJn personLog = (TpersonlogJn)resultList.get(0);
				    		if(personLog!=null){
				    			
				    			String source = personLog.getSource();
				    			if(source!=null && !"".equals(source)){
				    			    request.setAttribute("pathInfo", ToolUtil.getPathForBusinessCode(source));
				    			}
				    			String sid = personLog.getSid();
				    			String strTable =  personLog.getTableforpic();
				    			String strField = personLog.getFieldforpic();
				    			String strID = personLog.getKeyforpic();
				    		    if(sid!=null && strTable!=null && strField != null && strID !=null 
				    		       && !"".equals(sid) && !"".equals(strTable) && !"".equals(strField) 
				    		       && !"".equals(strID)	){			    			
				    		    	String sql = " SELECT "+ strField +" FROM "+ strTable 
					    			           + " WHERE " + strID + " = '"+sid+"' ";
					    			request.setAttribute("sql", sql);			    			
				    		    }
				    		    
				    		}
				    		
				    	}
				    	
				    }
				}
				
	}
	/** 进入新增页面*/
	public String create() {
		return CREATE_JSP;
	}
	
	/** 保存新增对象 */
	public String save() {
		HttpServletRequest request = ServletActionContext.getRequest();
		tpersonbaseJnManager.save(tpersonbaseJn);
		return returnUrl;////LIST_ACTION;
	}
	
	/**进入更新页面*/
	public String edit() {
		HttpServletRequest request = ServletActionContext.getRequest();
		return EDIT_JSP;
	}
	
	/**保存更新对象*/
	public String update() {
		HttpServletRequest request = ServletActionContext.getRequest();
		tpersonbaseJnManager.update(this.tpersonbaseJn);
		return returnUrl;////LIST_ACTION;
	}
	
	
	/**删除对象*/
	public String delete() {
		for(int i = 0; i < items.length; i++) {
			Hashtable params = HttpUtils.parseQueryString(items[i]);
			Long id = new Long((String)params.get("id"));
			tpersonbaseJnManager.removeById(id);
		}
		return returnUrl ;//LIST_ACTION;
	}

	public SsDatasourceManager getSsDatasourceManager() {
		return ssDatasourceManager;
	}

	public void setSsDatasourceManager(SsDatasourceManager ssDatasourceManager) {
		this.ssDatasourceManager = ssDatasourceManager;
	}

	public TpersonlogJnManager getTpersonlogJnManager() {
		return tpersonlogJnManager;
	}

	public void setTpersonlogJnManager(TpersonlogJnManager tpersonlogJnManager) {
		this.tpersonlogJnManager = tpersonlogJnManager;
	}

}
