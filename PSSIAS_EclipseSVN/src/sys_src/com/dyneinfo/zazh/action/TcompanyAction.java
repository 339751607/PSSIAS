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

/**
 * @author lisc email:lishicheng(a)gmail.com
 */


public class TcompanyAction extends BaseStruts2Action implements Preparable,ModelDriven{
	//默认多列排序,example: username desc,createTime asc
	protected static final String DEFAULT_SORT_COLUMNS = null; 
	
	//forward paths
	protected static final String QUERY_JSP = "/pages/zazh/Tcompany/query.jsp";
	protected static final String STATISQUERY_JSP = "/pages/zazh/Tcompany/statisQuery.jsp";
	protected static final String STATISLIST_JSP = "/pages/zazh/Tcompany/statisList.jsp";
	protected static final String LIST_JSP= "/pages/zazh/Tcompany/list.jsp";
	protected static final String CREATE_JSP = "/pages/zazh/Tcompany/create.jsp";
	protected static final String EDIT_JSP = "/pages/zazh/Tcompany/edit.jsp";
	protected static final String SHOW_JSP = "/pages/zazh/Tcompany/show.jsp";
	//redirect paths,startWith: !
	protected static final String LIST_ACTION = "!/pages/zazh/Tcompany/list.do";
	
	private TcompanyManager tcompanyManager;
	private SsDeptManager ssDeptManager;
	
	private Tcompany tcompany;
	java.lang.String id = null;
	private String[] items;
	private String returnUrl;  //返回列表，保留查询条件
	private TreeMap<String, String> dateSelectMap;// //日期选择

	public void prepare() throws Exception {
		if (isNullOrEmptyString(id)) {
			tcompany = new Tcompany();
		} else {
			tcompany = (Tcompany)tcompanyManager.getById(id);
		}
	}
	
	/** 增加setXXXX()方法,spring就可以通过autowire自动设置对象属性 */
	public void setTcompanyManager(TcompanyManager manager) {
		this.tcompanyManager = manager;
	}	
	
	public Object getModel() {
		return tcompany;
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
	/** 进入查询页面 */
	public String statisQuery() {
		//日历快速选择用到
		dateSelectMap  = DateUtil.getDateSelectData();
        return STATISQUERY_JSP;
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
		
		String s_moddate_start = (String)pageRequest.getFilters().get("moddate_start");
		if(s_moddate_start != null && !"".equals(s_moddate_start)){
			s_moddate_start = s_moddate_start.replace("-", "");	
			pageRequest.getFilters().put("moddatestart", s_moddate_start);
		}
		String s_moddate_end = (String)pageRequest.getFilters().get("moddate_end");
		if(s_moddate_end != null && !"".equals(s_moddate_end)){
			s_moddate_end = s_moddate_end.replace("-", "");	
			pageRequest.getFilters().put("moddateend", s_moddate_end);
		}
		
		Page page = tcompanyManager.findByPageRequest(pageRequest);
		savePage(page,pageRequest);
		return LIST_JSP;
	}
	/** 执行统计 */
	public String statisList() {
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
		
		String s_status = pageRequest.getFilters().get("status")==null?"":(String)pageRequest.getFilters().get("status");
		
		request.setAttribute("statisType", s_statisType);
		request.setAttribute("burcode", s_burcode);
		request.setAttribute("status", s_status);
		
		request.setAttribute("pageRequest", pageRequest);
		
		//所有行业的字典信息
		List businessDictList =  DictHelpImpl.getDict("DIC_ITEM_VALID_BUSINESSCODE"); 
		request.setAttribute("businessDictList", businessDictList);
		
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
     			    List busiCodeList = tcompanyManager.getCompCountByDeptCode(s_statisType, deptCode, s_status);
     			    //构造每个分局对应的行业企业数量
     			    HashMap deptCountMap = new HashMap();
     			    if(busiCodeList != null && busiCodeList.size() > 0){
     			    	for(int j=0; j < busiCodeList.size(); j++){
     			    		HashMap businMap = (HashMap)busiCodeList.get(j);
     			    		//每个行业转移到统一的一个map里
     			    		String code = (String)businMap.get("code");
     			    		int count = (Integer)businMap.get("count");
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
     			    List busiCodeList = tcompanyManager.getCompCountByDeptCode(s_statisType, deptCode, s_status);
     			   //构造每个派出所对应的行业企业数量
     			    HashMap deptCountMap = new HashMap();
     			    if(busiCodeList != null && busiCodeList.size() > 0){
     			    	for(int j=0; j < busiCodeList.size(); j++){
     			    		HashMap businMap = (HashMap)busiCodeList.get(j);
     			    		//每隔行业转移到统一的一个map里
     			    		String code = (String)businMap.get("code");
     			    		int count = (Integer)businMap.get("count");
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
		
		return STATISLIST_JSP;
	}
	
	/** 查看对象*/
	public String show() {
		HttpServletRequest request = ServletActionContext.getRequest();
		String timeInfo = this.tcompany.getStartdate();
		if(timeInfo!=null && !"".equals(timeInfo) && timeInfo.length() >=8){		   
		   String s = String.format("%s-%s-%s",timeInfo.substring(0,4), timeInfo.substring(4,6),timeInfo.substring(6));
		   this.tcompany.setStartdate(s);
		}

        timeInfo = this.tcompany.getModdate();
		if(timeInfo!=null && !"".equals(timeInfo) && timeInfo.length() >=8){		   
		   String s = String.format("%s-%s-%s",timeInfo.substring(0,4), timeInfo.substring(4,6),timeInfo.substring(6));
		   this.tcompany.setModdate(s);
		}
        timeInfo = this.tcompany.getBasj();
		if(timeInfo!=null && !"".equals(timeInfo) && timeInfo.length() >=8){		   
		   String s = String.format("%s-%s-%s",timeInfo.substring(0,4), timeInfo.substring(4,6),timeInfo.substring(6));
		   this.tcompany.setBasj(s);
		}
		return SHOW_JSP;
	}
	
	/** 进入新增页面*/
	public String create() {
		return CREATE_JSP;
	}
	
	/** 保存新增对象 */
	public String save() {
		HttpServletRequest request = ServletActionContext.getRequest();
		tcompanyManager.save(tcompany);
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
		tcompanyManager.update(this.tcompany);
		return returnUrl;////LIST_ACTION;
	}
	
	/**删除对象*/
	public String delete() {
		for(int i = 0; i < items.length; i++) {
			Hashtable params = HttpUtils.parseQueryString(items[i]);
			java.lang.String id = new java.lang.String((String)params.get("cpcode"));
			tcompanyManager.removeById(id);
		}
		return returnUrl ;//LIST_ACTION;
	}

	public SsDeptManager getSsDeptManager() {
		return ssDeptManager;
	}

	public void setSsDeptManager(SsDeptManager ssDeptManager) {
		this.ssDeptManager = ssDeptManager;
	}

}
