/*
 * Powered By [lishicheng]
 */

package com.dyneinfo.pmdd.action;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import javacommon.base.BaseStruts2Action;

import javax.servlet.http.HttpServletRequest;

import net.java.dev.common.util.DateUtil;
import net.java.dev.common.util.SpringTagFunctions;

import org.apache.struts2.ServletActionContext;
import org.security.userdetails.MyUserDetails;
import org.springframework.security.Authentication;
import org.springframework.security.context.SecurityContext;
import org.springframework.security.context.SecurityContextHolder;

import cn.org.rapid_framework.page.Page;
import cn.org.rapid_framework.page.PageRequest;
import cn.org.rapid_framework.web.util.HttpUtils;

import com.dyneinfo.pmdd.model.Pmdwnsxxb;
import com.dyneinfo.pmdd.service.PmdwnsxxbManager;
import com.opensymphony.xwork2.ModelDriven;
import com.opensymphony.xwork2.Preparable;

/**
 * @author lisc email:lishicheng(a)gmail.com
 */


public class PmdwnsxxbAction extends BaseStruts2Action implements Preparable,ModelDriven{
	//默认多列排序,example: username desc,createTime asc
	protected static final String DEFAULT_SORT_COLUMNS = null; 
	
	//forward paths
	protected static final String QUERY_JSP = "/pages/pmdd/Pmdwnsxxb/query.jsp";
	protected static final String LIST_JSP= "/pages/pmdd/Pmdwnsxxb/list.jsp";
	protected static final String CREATE_JSP = "/pages/pmdd/Pmdwnsxxb/create.jsp";
	protected static final String EDIT_JSP = "/pages/pmdd/Pmdwnsxxb/edit.jsp";
	protected static final String SHOW_JSP = "/pages/pmdd/Pmdwnsxxb/show.jsp";
	//redirect paths,startWith: !
	protected static final String LIST_ACTION = "!/pages/pmdd/Pmdwnsxxb/list.do";
	
	private PmdwnsxxbManager pmdwnsxxbManager;
	
	private Pmdwnsxxb pmdwnsxxb;
	private String dwbm;
	private String nsnd;
	java.lang.String id = null;
	private String[] items;
	private String returnUrl;  //返回列表，保留查询条件
	private TreeMap<String, String> dateSelectMap;// //日期选择
	private Map dwMap;

	public Map getDwMap() {
		return dwMap;
	}

	public void setDwMap(Map dwMap) {
		this.dwMap = dwMap;
	}

	public void prepare() throws Exception {
//		if (isNullOrEmptyString(id)) {
			pmdwnsxxb = new Pmdwnsxxb();
//		} else {
//			pmdwnsxxb = (Pmdwnsxxb)pmdwnsxxbManager.getByPkId(id, nsnd);
//		}
	}
	
	/** 增加setXXXX()方法,spring就可以通过autowire自动设置对象属性 */
	public void setPmdwnsxxbManager(PmdwnsxxbManager manager) {
		this.pmdwnsxxbManager = manager;
	}	
	
	public Object getModel() {
		return pmdwnsxxb;
	}
	
	public void setDwbm(java.lang.String val) {
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
		String deptid = getDetpId();
		if(!SpringTagFunctions.ifAnyGranted("ROLE_ADMIN,ROLE_QUERY_CHILD_ORG")){
			pageRequest.getFilters().put("chdeptid",deptid);	
			pageRequest.getFilters().put("deptLength",deptid.length());
		}
//		if(SpringTagFunctions.ifAnyGranted("ROLE_QUERY_CHILD_ORG")){
//			pageRequest.getFilters().put("chdeptid",deptid);	
//			pageRequest.getFilters().put("chdeptLength",deptid.length());
//		}
		dateSelectMap  = DateUtil.getDateSelectData();
		
		Page page = pmdwnsxxbManager.findByPageRequest(pageRequest);
		savePage(page,pageRequest);
		return LIST_JSP;
	}
	
	/** 查看对象*/
	public String show() {
		HttpServletRequest request = ServletActionContext.getRequest();
		pmdwnsxxb = (Pmdwnsxxb)pmdwnsxxbManager.getById(id, nsnd);
		String nsrq=pmdwnsxxb.getNsrq();
		String nsrqFormat = DateUtil.parseString(nsrq,"yyyyMMdd","yyyy-MM-dd");
		pmdwnsxxb.setNsrq(nsrqFormat);
		
		return SHOW_JSP;
	}
	
	/** 进入新增页面*/
	public String create() {
		HttpServletRequest request = ServletActionContext.getRequest();
		List dwbmList=new ArrayList();
		if(!SpringTagFunctions.ifAnyGranted("ROLE_HT_ADMIN,ROLE_ADMIN,ROLE_QUERY_CHILD_ORG")){
			 dwbmList=pmdwnsxxbManager.findDwbm(getDetpId(),null);
		}else  if(SpringTagFunctions.ifAnyGranted("ROLE_HT_ADMIN,ROLE_QUERY_CHILD_ORG")){
			 dwbmList=pmdwnsxxbManager.findDwbm(null,getDetpId());
		}else{
			dwbmList=pmdwnsxxbManager.findDwbm(null,null);
		}

		dwMap=new HashMap();
	
		List list=new ArrayList();
		for(int i=0;i<dwbmList.size();i++){
			Map map=(Map)dwbmList.get(i);
			dwMap.put(map.get("DWBM"), map.get("DWMC"));
		}

		return CREATE_JSP;
	}
	
	/** 保存新增对象 */
	public String save() {
		HttpServletRequest request = ServletActionContext.getRequest();
		String nsrqFormat = DateUtil.parseString(request,"nsrq","yyyy-MM-dd","yyyyMMdd");
		pmdwnsxxb.setNsrq(nsrqFormat);
		String dwbm ="";
		String nsnd="";
		if(pmdwnsxxb != null && pmdwnsxxb.getDwbm()!= null)
			dwbm = pmdwnsxxb.getDwbm();
		if(pmdwnsxxb != null && pmdwnsxxb.getNsnd()!= null)
			nsnd = pmdwnsxxb.getNsnd();
		
		int count = pmdwnsxxbManager.getFindCountById(dwbm,nsnd);
		if(count > 0){
			request.setAttribute("message", "已存在该单位"+nsnd+"年度年审信息!");
			String nsrq =  pmdwnsxxb.getNsrq();
			String nsrq1Format = DateUtil.parseString(nsrq,"yyyyMMdd","yyyy-MM-dd");
			pmdwnsxxb.setNsrq(nsrq1Format);
			return create();
		}
		
		pmdwnsxxbManager.save(pmdwnsxxb);
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
		pmdwnsxxbManager.update(this.pmdwnsxxb);
		return returnUrl;////LIST_ACTION;
	}
	
	/**删除对象*/
	public String delete() {
		for(int i = 0; i < items.length; i++) {
			Hashtable params = HttpUtils.parseQueryString(items[i]);
			java.lang.String id = new java.lang.String((String)params.get("dwbm"));
			pmdwnsxxbManager.removeById(id);
		}
		return returnUrl ;//LIST_ACTION;
	}
	
	public String getDetpId(){
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
		return deptid;
	}

	public String getNsnd() {
		return nsnd;
	}

	public void setNsnd(String nsnd) {
		this.nsnd = nsnd;
	}

	public String getDwbm() {
		return dwbm;
	}

}
