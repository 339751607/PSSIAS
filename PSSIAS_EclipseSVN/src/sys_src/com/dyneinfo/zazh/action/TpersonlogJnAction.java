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

import java.io.IOException;
import java.io.PrintWriter;
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
import com.google.gson.Gson;

/**
 * @author lisc email:lishicheng(a)gmail.com
 */


public class TpersonlogJnAction extends BaseStruts2Action implements Preparable,ModelDriven{
	//默认多列排序,example: username desc,createTime asc
	protected static final String DEFAULT_SORT_COLUMNS = null; 
	
	//forward paths
	protected static final String QUERY_JSP = "/pages/zazh/TpersonlogJn/query.jsp";
	protected static final String LIST_JSP= "/pages/zazh/TpersonlogJn/list.jsp";
	protected static final String ITEMLIST_JSP= "/pages/zazh/TpersonlogJn/itemlist.jsp";
	protected static final String CREATE_JSP = "/pages/zazh/TpersonlogJn/create.jsp";
	protected static final String EDIT_JSP = "/pages/zazh/TpersonlogJn/edit.jsp";
	protected static final String SHOW_JSP = "/pages/zazh/TpersonlogJn/show.jsp";
	//redirect paths,startWith: !
	protected static final String LIST_ACTION = "!/pages/zazh/TpersonlogJn/list.do";
	
	protected static final String STATISEMPQUERY_JSP = "/pages/zazh/TpersonlogJn/statisEmpQuery.jsp";
	protected static final String STATISEMPLIST_JSP = "/pages/zazh/TpersonlogJn/statisEmpList.jsp";
	
	private TpersonlogJnManager tpersonlogJnManager;
	private SsDatasourceManager ssDatasourceManager;
	private TpersonlogJn tpersonlogJn;
	private SsDeptManager ssDeptManager;
	
	Long id = null;
	private String[] items;
	private String returnUrl;  //返回列表，保留查询条件
	private TreeMap<String, String> dateSelectMap;// //日期选择

	public void prepare() throws Exception {
		if (isNullOrEmptyString(id)) {
			tpersonlogJn = new TpersonlogJn();
		} else {
			tpersonlogJn = (TpersonlogJn)tpersonlogJnManager.getById(id);
		}
	}
	
	/** 增加setXXXX()方法,spring就可以通过autowire自动设置对象属性 */
	public void setTpersonlogJnManager(TpersonlogJnManager manager) {
		this.tpersonlogJnManager = manager;
	}	
	
	public Object getModel() {
		return tpersonlogJn;
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
		String dateSelect9 = "";
		if (request.getParameter("dateSelect9") != null)
		    dateSelect9 = request.getParameter("dateSelect9");
			request.setAttribute("dateSelect9",dateSelect9);		        
		String dateSelect10 = "";
		if (request.getParameter("dateSelect10") != null)
		    dateSelect10 = request.getParameter("dateSelect10");
			request.setAttribute("dateSelect10",dateSelect10);		        
		
		Page page = tpersonlogJnManager.findByPageRequest(pageRequest);
		savePage(page,pageRequest);
		return LIST_JSP;
	}
	/** 执行搜索 */
	public String itemlist() {
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
		String dateSelect9 = "";
		if (request.getParameter("dateSelect9") != null)
		    dateSelect9 = request.getParameter("dateSelect9");
			request.setAttribute("dateSelect9",dateSelect9);		        
		String dateSelect10 = "";
		if (request.getParameter("dateSelect10") != null)
		    dateSelect10 = request.getParameter("dateSelect10");
			request.setAttribute("dateSelect10",dateSelect10);		        
		
		Page page = tpersonlogJnManager.findLogsInfoByPageRequestForItem(pageRequest);
		savePage(page,pageRequest);
		return ITEMLIST_JSP;
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
		tpersonlogJnManager.save(tpersonlogJn);
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
		tpersonlogJnManager.update(this.tpersonlogJn);
		return returnUrl;////LIST_ACTION;
	}
	
	/**删除对象*/
	public String delete() {
		for(int i = 0; i < items.length; i++) {
			Hashtable params = HttpUtils.parseQueryString(items[i]);
			Long id = new Long((String)params.get("id"));
			tpersonlogJnManager.removeById(id);
		}
		return returnUrl ;//LIST_ACTION;
	}
	

	public String getLogJnCount() {
		
		HttpServletRequest request = ServletActionContext.getRequest();
		
		String s_source = request.getParameter("s_source")==null?"":request.getParameter("s_source");			
        String s_cardname = request.getParameter("s_cardname")==null?"":request.getParameter("s_cardname");		
		String s_cardcode = request.getParameter("s_cardno")==null?"":request.getParameter("s_cardno");		
		String s_starttime = request.getParameter("s_starttime")==null?"":request.getParameter("s_starttime");
		String s_endtime = request.getParameter("s_endtime")==null?"":request.getParameter("s_endtime");

		Map infoMap = new HashMap();
		if(!"".equals(s_source)){						
			List mapList = tpersonlogJnManager.getLogJnCountByBusinessCode(s_source, s_cardname, s_cardcode, 
								                                           s_starttime, s_endtime);						
		    if(mapList!=null && mapList.size() > 0 ){
			    for(int i=0; i < mapList.size(); i++){
						HashMap map = (HashMap)mapList.get(i);
						if(map != null){
						   infoMap.put(map.get("code"), map);
						}
			    }					
		    }
		}
		
		
		Gson gson = new Gson();
		String json = gson.toJson(infoMap);
		
		HttpServletResponse response = ServletActionContext.getResponse();
		
		// 在取得out对象之前必须先进行设置
		response.setContentType("text/json");
		response.setHeader("Cache-Control", "no-cache");
		response.setCharacterEncoding("UTF-8");
		PrintWriter out;
		try {
			out = response.getWriter();
			out.write(json);
			out.flush();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

       return null;
	}
	/** 进入查询页面 */
	public String statisEmpQuery() {
		//日历快速选择用到
		dateSelectMap  = DateUtil.getDateSelectData();
        return STATISEMPQUERY_JSP;
	}
	/** 执行统计 */
	public String statisEmpList() {
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
		
		String s_statisType = pageRequest.getFilters().get("statisType")==null?"0":(String)pageRequest.getFilters().get("statisType");
		String s_burcode = pageRequest.getFilters().get("burcode")==null?"0":(String)pageRequest.getFilters().get("burcode");
		
		String s_starttime = pageRequest.getFilters().get("starttime")==null?"":(String)pageRequest.getFilters().get("starttime");
		String s_endtime = pageRequest.getFilters().get("endtime")==null?"":(String)pageRequest.getFilters().get("endtime");
		
		request.setAttribute("statisType", s_statisType);
		request.setAttribute("burcode", s_burcode);
		request.setAttribute("starttime", s_starttime);
		request.setAttribute("endtime", s_endtime);		
		request.setAttribute("pageRequest", pageRequest);
		
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
          
		//所有从业状态的字典信息
		List businessDictList =  DictHelpImpl.getDict("cyryFlag"); 
		request.setAttribute("cyryDictList", businessDictList);
		
		List deptList = null;
		List returnDeptList = new ArrayList();
		if("0".equals(s_statisType)){ //按照分局
        	 deptList = DictHelpImpl.getDict("ssfj");       
        	 //获取所有分局的信息
        	 if(deptList!=null && deptList.size() > 0){
     			for(int i=0; i<deptList.size(); i++){
     				DictItem item = (DictItem)deptList.get(i);
     				String deptCode =  item.getDictid();
     				String deptName = item.getDictname();
     			    List empStatusList = tpersonlogJnManager.getCompCountByDeptCode(s_statisType, deptCode, starttime, endtime );
     			    //构造每个分局对应的员工状态
     			    HashMap deptCountMap = new HashMap();
     			    if(empStatusList != null && empStatusList.size() > 0){
     			    	for(int j=0; j < empStatusList.size(); j++){
     			    		HashMap empStatusMap = (HashMap)empStatusList.get(j);
     			    		//每个从业状态转移到统一的一个map里
     			    		String code = (String)empStatusMap.get("code");
     			    		int count = (Integer)empStatusMap.get("count");
     			    		deptCountMap.put(code, count);
     			    	}
     			    }
     			    HashMap deptMap = new HashMap();
     			    deptMap.put("deptcode", deptCode);
     			    deptMap.put("deptname", deptName);
     			    deptMap.put("deptCountMap", deptCountMap);
     			    returnDeptList.add(deptMap);
     			}
        	 }
        }else{  //按照派出所
        	 deptList = ssDeptManager.findByParentId(s_burcode, "");
        	 if(deptList!=null && deptList.size() > 0){
     			for(int i=0; i<deptList.size(); i++){
     				SsDept ssDept =  (SsDept)deptList.get(i);
     				String deptCode =  ssDept.getDeptid();
     				String deptName = ssDept.getDeptname();
     				List empStatusList = tpersonlogJnManager.getCompCountByDeptCode(s_statisType, deptCode, s_starttime, s_endtime );
     			   //构造每个派出所对应的从业状态的数据
     			    HashMap deptCountMap = new HashMap();
     			    if(empStatusList != null && empStatusList.size() > 0){
     			    	for(int j=0; j < empStatusList.size(); j++){
     			    		HashMap empStatusMap = (HashMap)empStatusList.get(j);
     			    		//每隔行业转移到统一的一个map里
     			    		String code = (String)empStatusMap.get("code");
     			    		int count = (Integer)empStatusMap.get("count");
     			    		deptCountMap.put(code, count);
     			    	}
     			    }
     			    HashMap deptMap = new HashMap();
     			    deptMap.put("deptcode", deptCode);
     			    deptMap.put("deptname", deptName);
     			    deptMap.put("deptCountMap", deptCountMap);
     			    returnDeptList.add(deptMap);
     			}
     		}
        }
		request.setAttribute("deptList", returnDeptList);
		
		return STATISEMPLIST_JSP;
	}
	public SsDatasourceManager getSsDatasourceManager() {
		return ssDatasourceManager;
	}

	public void setSsDatasourceManager(SsDatasourceManager ssDatasourceManager) {
		this.ssDatasourceManager = ssDatasourceManager;
	}

	public SsDeptManager getSsDeptManager() {
		return ssDeptManager;
	}

	public void setSsDeptManager(SsDeptManager ssDeptManager) {
		this.ssDeptManager = ssDeptManager;
	}
}
