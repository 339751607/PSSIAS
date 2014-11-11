/*
 * Powered By [lishicheng]
 */

package com.dyneinfo.zazh.action;

import java.util.Hashtable;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import javacommon.base.BaseStruts2Action;

import javax.servlet.http.HttpServletRequest;

import net.java.dev.common.dict.taglib.DictHelpImpl;
import net.java.dev.common.util.DateUtil;

import org.apache.struts2.ServletActionContext;
import org.security.userdetails.MyUserDetails;
import org.springframework.context.ApplicationContext;
import org.springframework.security.Authentication;
import org.springframework.security.context.SecurityContext;
import org.springframework.security.context.SecurityContextHolder;
import org.springframework.web.context.support.WebApplicationContextUtils;

import cn.org.rapid_framework.page.Page;
import cn.org.rapid_framework.page.PageRequest;
import cn.org.rapid_framework.web.util.HttpUtils;

import com.dyneinfo.zazh.model.DictType;
import com.dyneinfo.zazh.model.SsDictType;
import com.dyneinfo.zazh.service.SsDictItemManager;
import com.dyneinfo.zazh.service.SsDictTypeManager;
import com.opensymphony.xwork2.ModelDriven;
import com.opensymphony.xwork2.Preparable;

/**
 * @author lisc email:lishicheng(a)gmail.com
 */


public class SsDictTypeAction extends BaseStruts2Action implements Preparable,ModelDriven{
	//默认多列排序,example: username desc,createTime asc
	protected static final String DEFAULT_SORT_COLUMNS = null; 
	
	//forward paths
	protected static final String QUERY_JSP = "/pages/SsDictType/query.jsp";
	protected static final String LIST_JSP= "/pages/SsDictType/list.jsp";
	protected static final String CREATE_JSP = "/pages/SsDictType/create.jsp";
	protected static final String EDIT_JSP = "/pages/SsDictType/edit.jsp";
	protected static final String SHOW_JSP = "/pages/SsDictType/show.jsp";
	//redirect paths,startWith: !
	protected static final String LIST_ACTION = "!/pages/SsDictType/list.do";
	
	private SsDictTypeManager ssDictTypeManager;
	private SsDictItemManager ssDictItemManager;
	
	private SsDictType ssDictType;
	java.lang.String id = null;
	private String[] items;
	private String returnUrl;  //返回列表，保留查询条件
	private TreeMap<String, String> dateSelectMap;// //日期选择

	public void prepare() throws Exception {
		
		if (isNullOrEmptyString(id)) {
			ssDictType = new SsDictType();
		} else {
			ssDictType = (SsDictType)ssDictTypeManager.getById(id);
		}
		
			
		
	}
	
	/** 增加setXXXX()方法,spring就可以通过autowire自动设置对象属性 */
	public void setSsDictTypeManager(SsDictTypeManager manager) {
		this.ssDictTypeManager = manager;
	}	
	
	public void setSsDictItemManager(SsDictItemManager manager) {
		this.ssDictItemManager = manager;
	}	
	
	public Object getModel() {
		return ssDictType;
	}
	
	public void setDicttypeid(java.lang.String val) {
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
	public void reloadDict() {
		ApplicationContext ctx = WebApplicationContextUtils
		.getWebApplicationContext(ServletActionContext
				.getServletContext());
		DictHelpImpl beanRep = (DictHelpImpl) ctx.getBean("DictHelpImpl");

			List catList = beanRep.getSsDictType();
			if (catList != null) {
				 System.out.println("重新加载属性字典 ");
				for (int i = 0; i < catList.size(); i++) {
					DictType ssDictType = (DictType) catList.get(i);
					try {
						beanRep.reloadDict(ssDictType);
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
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
		
		Page page = ssDictTypeManager.findByPageRequest(pageRequest);
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
		String dicttypeid = "";
		if(request.getParameter("dicttypeids") != null)
			dicttypeid = request.getParameter("dicttypeids");
		int count = ssDictTypeManager.getFindCountById(dicttypeid);
		
		if(count < 1 ){
			SsDictType DictType = new SsDictType();
			DictType.setDicttypeid(dicttypeid);
			DictType.setDicttypename(ssDictType.getDicttypename());
			DictType.setDictlevel(1L);
			DictType.setSeqno("."+dicttypeid+".");
			DictType.setDictflag(ssDictType.getDictflag());
			DictType.setQuerysql(ssDictType.getQuerysql());
			
			ssDictTypeManager.save(DictType);
		} else{
			request.setAttribute("message", "字典已存在"); 
		}
		reloadDict();
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
		String dicttypeid = "";
		if(request.getParameter("dicttypeids") != null)
			dicttypeid = request.getParameter("dicttypeids");
		int count = ssDictTypeManager.getFindCountById(dicttypeid);
		if(count < 1)
		{
			//ssDictType.setDicttypeid(dicttypeid);
		   // ssDictTypeManager.save(ssDictType);
		}
		else{
			ssDictType.setDicttypeid(dicttypeid);
		    ssDictTypeManager.update(ssDictType);
		}
		reloadDict();
		return returnUrl;////LIST_ACTION;
	}
	
	/**删除对象*/
	public String delete() {
		for(int i = 0; i < items.length; i++) {
			Hashtable params = HttpUtils.parseQueryString(items[i]);
			java.lang.String id = new java.lang.String((String)params.get("dicttypeid"));
			ssDictTypeManager.removeById(id);
			ssDictItemManager.removeRecorderById(id);
		}
		reloadDict();
		return returnUrl ;//LIST_ACTION;
	}

}
