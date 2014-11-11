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
import com.dyneinfo.zazh.model.SsDictItem;
import com.dyneinfo.zazh.service.SsDictItemManager;
import com.opensymphony.xwork2.ModelDriven;
import com.opensymphony.xwork2.Preparable;

/**
 * @author lisc email:lishicheng(a)gmail.com
 */


public class SsDictItemAction extends BaseStruts2Action implements Preparable,ModelDriven{
	//默认多列排序,example: username desc,createTime asc
	protected static final String DEFAULT_SORT_COLUMNS = " SORTNO asc "; 
	
	//forward paths
	protected static final String QUERY_JSP = "/pages/SsDictItem/query.jsp";
	protected static final String LIST_JSP= "/pages/SsDictItem/list.jsp";
	protected static final String CREATE_JSP = "/pages/SsDictItem/create.jsp";
	protected static final String EDIT_JSP = "/pages/SsDictItem/edit.jsp";
	protected static final String SHOW_JSP = "/pages/SsDictItem/show.jsp";
	protected static final String MASTERDETAIL = "/pages/SsDictItem/masterDetailQuery.jsp";
	//redirect paths,startWith: !
	protected static final String LIST_ACTION = "!/pages/SsDictItem/list.do";
	
	private SsDictItemManager ssDictItemManager;
	
	private SsDictItem ssDictItem;
	java.lang.String id = null;
	private String[] items;
	private String returnUrl;  //返回列表，保留查询条件
	private TreeMap<String, String> dateSelectMap;// //日期选择

	public void prepare() throws Exception {
		
			ssDictItem = new SsDictItem();
		
	}
	
	/** 增加setXXXX()方法,spring就可以通过autowire自动设置对象属性 */
	public void setSsDictItemManager(SsDictItemManager manager) {
		this.ssDictItemManager = manager;
	}	
	
	public Object getModel() {
		return ssDictItem;
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
	
	public String masterDetail() {
		HttpServletRequest request = ServletActionContext.getRequest();
		String id = "";
		if(request.getParameter("id") != null)
			id = request.getParameter("id");
		request.setAttribute("id",id);
		return MASTERDETAIL;
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

		Page page = ssDictItemManager.findByPageRequest(pageRequest);
		savePage(page,pageRequest);
		
		return LIST_JSP;
	}
	
	/** 查看对象*/
	public String show() {
		HttpServletRequest request = ServletActionContext.getRequest();
		String DICTTYPEID = "";
		if(request.getParameter("dicttypeid") != null)
			DICTTYPEID = request.getParameter("dicttypeid");
		String DICTID = "";
		if(request.getParameter("dictid") != null)
			DICTID = request.getParameter("dictid");
		ssDictItem = ssDictItemManager.getFindById(DICTTYPEID, DICTID);
		return SHOW_JSP;
	}
	
	/** 进入新增页面*/
	public String create() {
		HttpServletRequest request = ServletActionContext.getRequest();
		String dicttypeid = "";
		if(request.getParameter("s_dicttypeid") != null)
			dicttypeid = request.getParameter("s_dicttypeid");
		request.setAttribute("dicttypeid", dicttypeid);
		return CREATE_JSP;
	}
	
	/** 保存新增对象 */
	public String save() {
		HttpServletRequest request = ServletActionContext.getRequest();
		String dicttypeid = "";
		if(request.getParameter("dicttypeid") != null)
			dicttypeid = request.getParameter("dicttypeid");
		request.setAttribute("dicttypeid", dicttypeid);
		if(ssDictItemManager.getFindById(id, ssDictItem.getDictid())!=null){

			request.setAttribute("message", "字典代码已存在！");
			//"!/pages/SsDictItem/list.do?s_dicttypeid="+ssDictItem.getDicttypeid()+"&message=字典代码已存在！"
			return CREATE_JSP;
		}
		
		ssDictItem.setDictlevel(1L);
		ssDictItem.setSeqno("."+ssDictItem.getDictid()+".");
		ssDictItemManager.save(ssDictItem);
		 reloadDict();
		return returnUrl;////LIST_ACTION;
	}
	
	/**进入更新页面*/
	public String edit() {
		HttpServletRequest request = ServletActionContext.getRequest();
		String DICTTYPEID = "";
		if(request.getParameter("dicttypeid") != null)
			DICTTYPEID = request.getParameter("dicttypeid");
		String DICTID = "";
		if(request.getParameter("dictid") != null)
			DICTID = request.getParameter("dictid");
		ssDictItem = ssDictItemManager.getFindById(DICTTYPEID, DICTID);
		 reloadDict();
		return EDIT_JSP;
	}
	
	/**保存更新对象*/
	public String update() {
		HttpServletRequest request = ServletActionContext.getRequest();
		ssDictItemManager.update(this.ssDictItem);
		 reloadDict();
		return returnUrl;////LIST_ACTION;
	}
	
	/**删除对象*/
	public String delete() {
		for(int i = 0; i < items.length; i++) {
			Hashtable params = HttpUtils.parseQueryString(items[i]);
			java.lang.String id = new java.lang.String((String)params.get("dicttypeid"));
			java.lang.String dictid = new java.lang.String((String)params.get("dictid"));
			System.out.println(id);
			System.out.println("dictid="+dictid);
			ssDictItemManager.removeRecorderById(id,dictid);
		}
		 reloadDict();
		return returnUrl ;//LIST_ACTION;
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
}
