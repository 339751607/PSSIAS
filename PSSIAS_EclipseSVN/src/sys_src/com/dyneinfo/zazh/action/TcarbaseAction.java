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


public class TcarbaseAction extends BaseStruts2Action implements Preparable,ModelDriven{
	//默认多列排序,example: username desc,createTime asc
	protected static final String DEFAULT_SORT_COLUMNS = null; 
	
	//forward paths
	protected static final String QUERY_JSP = "/pages/zazh/Tcarbase/query.jsp";
	protected static final String LIST_JSP= "/pages/zazh/Tcarbase/list.jsp";
	protected static final String CREATE_JSP = "/pages/zazh/Tcarbase/create.jsp";
	protected static final String EDIT_JSP = "/pages/zazh/Tcarbase/edit.jsp";
	protected static final String SHOW_JSP = "/pages/zazh/Tcarbase/show.jsp";
	//redirect paths,startWith: !
	protected static final String LIST_ACTION = "!/pages/zazh/Tcarbase/list.do";
	
	protected static final String ANALYQUERY_JSP = "/pages/zazh/Tcarbase/analyquery.jsp";
	protected static final String ANALYLIST_JSP= "/pages/zazh/Tcarbase/analylist.jsp";
	protected static final String ANALYSHOW_JSP = "/pages/zazh/Tcarbase/analyshow.jsp";
	protected static final String ANALYSHOWTRACK_JSP = "/pages/zazh/Tcarbase/analyshowtrack.jsp";
	protected static final String ANALYSHOWLINE_JSP = "/pages/zazh/Tcarbase/analyshowline.jsp";
	private TcarbaseManager tcarbaseManager;
	private TcarlogManager tcarlogManager;
	private SsDatasourceManager ssDatasourceManager;
	private Tcarbase tcarbase;
	Long id = null;
	private String[] items;
	private String returnUrl;  //返回列表，保留查询条件
	private TreeMap<String, String> dateSelectMap;// //日期选择

	public void prepare() throws Exception {
		if (isNullOrEmptyString(id)) {
			tcarbase = new Tcarbase();
		} else {
			tcarbase = (Tcarbase)tcarbaseManager.getById(id);
		}
	}
	
	/** 增加setXXXX()方法,spring就可以通过autowire自动设置对象属性 */
	public void setTcarbaseManager(TcarbaseManager manager) {
		this.tcarbaseManager = manager;
	}	
	
	public Object getModel() {
		return tcarbase;
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
		
		Page page = tcarbaseManager.findByPageRequest(pageRequest);
		savePage(page,pageRequest);
		return LIST_JSP;
	}
	
	/** 查看对象*/
	public String show() {
		HttpServletRequest request = ServletActionContext.getRequest();
		
		HashMap map = new HashMap();
		map.put("sortColumns", "code");
		map.put("isvalid", "1");  //开通的行业
		map.put("not_code", "000");
		
		List list = ToolUtil.getBusinessCodeIsValid(ssDatasourceManager,map);
		
		getPicture( request, this.tcarbase.getCarid());
		
		request.setAttribute("businessCode", list);
		
		return SHOW_JSP;
	}
	private void getPicture(HttpServletRequest request, String carid){
		
		if(carid != null && !"".equals(carid) ){		
								
			        PageRequest<Map> pgReq = newPageRequest(DEFAULT_SORT_COLUMNS);
			        pgReq.setPageNumber(1);
			        pgReq.getFilters().put("carid",carid);
			        pgReq.getFilters().put("starttime", "");
			        pgReq.getFilters().put("endtime", "");
			        
				    Page page = this.tcarlogManager.findLogsInfoByPageRequest(pgReq);
				    if(page!=null){
				    	
				    	List resultList = page.getResult();
				    	
				    	if(resultList!=null && resultList.size()>0){
				    		
				    		Tcarlog carLog = (Tcarlog)resultList.get(0);
				    		if(carLog!=null){
				    			
				    			String source = carLog.getSource();
				    			if(source!=null && !"".equals(source)){
				    			    request.setAttribute("pathInfo", ToolUtil.getPathForBusinessCode(source));
				    			}
				    			String sid = carLog.getSid();
				    			String strTable =  carLog.getTableforpic();
				    			String strField = carLog.getFieldforpic();
				    			String strID = carLog.getKeyforpic();
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
	/** 进入查询页面 */
	public String analyquery() {
		//日历快速选择用到
		dateSelectMap  = DateUtil.getDateSelectData();
//		HttpServletRequest request = ServletActionContext.getRequest();
//		request.setAttribute("dateSelect","11");//选中本周
//		DateUtil tt = new DateUtil();     
//      pageRequest.getFilters().put("s_inTime_start",tt.getMondayOFWeek());//页面
//      pageRequest.getFilters().put("s_inTime_end",tt.getCurrentWeekday());//
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
		
		Page page = tcarbaseManager.findByPageRequest(pageRequest);
		savePage(page,pageRequest);
		return ANALYLIST_JSP;
	}

	/** 查看对象*/
	public String analyshow() {
		PageRequest<Map> pageRequest = newPageRequest(DEFAULT_SORT_COLUMNS);
		HttpServletRequest request = ServletActionContext.getRequest();
			
		String s_starttime = request.getParameter("s_starttime")==null?"":request.getParameter("s_starttime");
		String s_endtime = request.getParameter("s_endtime")==null?"":request.getParameter("s_endtime");
		
		request.setAttribute("s_starttime", s_starttime);
		request.setAttribute("s_endtime", s_endtime);
	
		getPicture( request, this.tcarbase.getCarid());
		
		pageRequest.getFilters().put("carid",tcarbase.getCarid());
	
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
		
		Page page = tcarlogManager.findLogsInfoByPageRequest(pageRequest);
		savePage(page,pageRequest);

		return ANALYSHOW_JSP;
	}
	/** 查看对象*/
	public String analyshowLine() {
		PageRequest<Map> pageRequest = newPageRequest(DEFAULT_SORT_COLUMNS);
		HttpServletRequest request = ServletActionContext.getRequest();
			
		String s_starttime = request.getParameter("s_starttime")==null?"":request.getParameter("s_starttime");
		String s_endtime = request.getParameter("s_endtime")==null?"":request.getParameter("s_endtime");
		
		request.setAttribute("s_starttime", s_starttime);
		request.setAttribute("s_endtime", s_endtime);
	
		getPicture( request, this.tcarbase.getCarid());
		
		pageRequest.getFilters().put("carid",tcarbase.getCarid());
		
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
		
		Page page = tcarlogManager.findLogsInfoByPageRequest(pageRequest);
		List listMap = new ArrayList();
        List list = page.getResult();
        if(list!=null && list.size() > 0){
	       	for(int i = list.size()-1 ; i >= 0 ; i--){
				Tcarlog log =(Tcarlog)list.get(i);
				HashMap map = new HashMap();
				String str_starttime = log.getStarttime()==null?"":log.getStarttime();
				if(!"".equals(str_starttime)){
					str_starttime = str_starttime.substring(0,8);
					str_starttime = DateUtil.parseString(str_starttime, "yyyyMMdd", "yyyy-MM-dd");
				}
				map.put("disp_starttime",str_starttime);
				String activeName = DictFun.getDictValue("DIC_ITEM_BUSINESSTYPE",log.getCartype());
				map.put("activeName",activeName);
				map.put("activeCode",log.getCartype());
				String cpname = log.getCpname()==null?log.getCpcode():log.getCpname();
				map.put("cpname",cpname);
				map.put("starttime", DateUtil.parseString(log.getStarttime(), "yyyyMMddHHmm", "yyyy-MM-dd HH:mm"));
				map.put("endtime", DateUtil.parseString(log.getEndtime(), "yyyyMMddHHmm", "yyyy-MM-dd HH:mm"));
				
    			map.put("sid", log.getSid());
				map.put("source", log.getSource());
				map.put("cpcode", log.getCpcode());
				
				listMap.add(map);
//				listMap.add(map);
//				listMap.add(map);
//				listMap.add(map);
//				listMap.add(map);
//				listMap.add(map);
//				listMap.add(map);
	       	}
	       	if(listMap!=null && listMap.size()>0){
	       		String ctx = request.getContextPath();
	       		String trackInfo = ToolUtil.getTrackMap(listMap,ctx, "car");
	       		request.setAttribute("trackInfo", trackInfo);
	       	}
        }
		
		return ANALYSHOWLINE_JSP;
	}
	/** 查看对象*/
	public String analyshowTrackMap() {
		PageRequest<Map> pageRequest = newPageRequest(DEFAULT_SORT_COLUMNS);
		HttpServletRequest request = ServletActionContext.getRequest();
			
		String s_starttime = request.getParameter("s_starttime")==null?"":request.getParameter("s_starttime");
		String s_endtime = request.getParameter("s_endtime")==null?"":request.getParameter("s_endtime");
		
		request.setAttribute("s_starttime", s_starttime);
		request.setAttribute("s_endtime", s_endtime);
	
		getPicture( request, this.tcarbase.getCarid());
		
		pageRequest.getFilters().put("carid",tcarbase.getCarid());
		
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

		Page page = tcarlogManager.findLogsInfoByPageRequest(pageRequest);
		request.setAttribute("strXML", getXml(page.getResult(),subtitle));

		return ANALYSHOWTRACK_JSP;
	}	
	public String getXml(List list, String subtitle ){
		StringBuffer strXML=new StringBuffer();
		
		if(!list.isEmpty()&&list.size()>0){
			
			strXML.append("<graph caption='行动轨迹' subcaption='"+subtitle+"'  xAxisName='时间' yAxisName=''  ")
			      .append(" showAlternateHGridColor='true' numberSuffix='' showNames='1' baseFontSize='12' ")//样式
			      .append(" anchorRadius='10' anchorSides='10'  anchorRadius='10' anchorSides='10' anchorBgColor='0BBF59'  ")  //显示的提示圆圈的大小
			      .append(" canvasBorderColor='FFFFFF' lineThickness='1' formatNumberScale='0' showDivLinues ='0' ")
			      .append(" yAxisMinValue='0' yAxisMaxValue='2' showLegend='1' showLimits='0' divLineDecimalPrecision='0' ")  //y轴的显示方式
			      .append(" numVDivLines='0' numDivLines='0'   ") //单元格的显示
			      .append(" showToolTip='1' showValues='1' labelDisplay='ROTATE' slantLabels='1'  ")
			      .append(" > ")			
			      ;			

			for(int i = list.size()-1 ; i >= 0 ; i--){
				Tcarlog log =(Tcarlog)list.get(i);
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
				String activeName = DictFun.getDictValue("DIC_ITEM_BUSINESSTYPE",log.getCartype());
				strXML.append(activeName+"("+ log.getCpname() + ")");
				strXML.append("' toolText='");
				
				strXML.append(activeName + ":" + log.getCpname());
				strXML.append("   起止时间:" + DateUtil.parseString(log.getStarttime(), "yyyyMMddHHmm", "yyyy-MM-dd HH:mm"));
				strXML.append(" - " + DateUtil.parseString(log.getEndtime(), "yyyyMMddHHmm", "yyyy-MM-dd HH:mm"));
				//strXML.append("' link='javascript:alert(123455)");
				strXML.append("' />");
			}			
			strXML.append("</graph>");
		}
		return strXML.toString();
	}
	/** 进入新增页面*/
	public String create() {
		return CREATE_JSP;
	}
	
	/** 保存新增对象 */
	public String save() {
		HttpServletRequest request = ServletActionContext.getRequest();
		tcarbaseManager.save(tcarbase);
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
		tcarbaseManager.update(this.tcarbase);
		return returnUrl;////LIST_ACTION;
	}
	
	/**删除对象*/
	public String delete() {
		for(int i = 0; i < items.length; i++) {
			Hashtable params = HttpUtils.parseQueryString(items[i]);
			Long id = new Long((String)params.get("id"));
			tcarbaseManager.removeById(id);
		}
		return returnUrl ;//LIST_ACTION;
	}

	public TcarlogManager getTcarlogManager() {
		return tcarlogManager;
	}

	public void setTcarlogManager(TcarlogManager tcarlogManager) {
		this.tcarlogManager = tcarlogManager;
	}

	public SsDatasourceManager getSsDatasourceManager() {
		return ssDatasourceManager;
	}

	public void setSsDatasourceManager(SsDatasourceManager ssDatasourceManager) {
		this.ssDatasourceManager = ssDatasourceManager;
	}

}
