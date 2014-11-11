/*
 * Powered By [lishicheng]
 */

package com.dyneinfo.hotel.action;

import java.util.Hashtable;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import javacommon.base.BaseStruts2Action;

import javax.servlet.http.HttpServletRequest;

import net.java.dev.common.util.DateUtil;

import org.apache.commons.lang.StringUtils;
import org.apache.struts2.ServletActionContext;

import cn.org.rapid_framework.page.Page;
import cn.org.rapid_framework.page.PageRequest;
import cn.org.rapid_framework.web.util.HttpUtils;

import com.dyneinfo.hotel.model.TchPre;
import com.dyneinfo.hotel.model.TtjGuestRepeat;
import com.dyneinfo.hotel.service.TchPreManager;
import com.dyneinfo.hotel.service.TtjGuestRepeatManager;
import com.dyneinfo.zazh.service.SsCommonManager;
import com.opensymphony.xwork2.ModelDriven;
import com.opensymphony.xwork2.Preparable;

/**
 * @author lisc email:lishicheng(a)gmail.com
 */


public class TtjGuestRepeatAction extends BaseStruts2Action implements Preparable,ModelDriven{
	//默认多列排序,example: username desc,createTime asc
	protected static final String DEFAULT_SORT_COLUMNS = "inCount desc"; 
	
	//forward paths
	protected static final String QUERY_JSP = "/pages/hotel/TtjGuestRepeat/query.jsp";
	protected static final String LIST_JSP= "/pages/hotel/TtjGuestRepeat/list.jsp";
	protected static final String CREATE_JSP = "/pages/hotel/TtjGuestRepeat/create.jsp";
	protected static final String EDIT_JSP = "/pages/hotel/TtjGuestRepeat/edit.jsp";
	protected static final String SHOW_JSP = "/pages/hotel/TtjGuestRepeat/show.jsp";
	protected static final String SHOW_PIC = "/pages/pic/pic.jsp";
	//redirect paths,startWith: !
	protected static final String LIST_ACTION = "!/pages/hotel/TtjGuestRepeat/list.do";
	
	private TtjGuestRepeatManager tjGuestRepeatManager;
	private SsCommonManager ssCommonManager;
	
	private TtjGuestRepeat tjGuestRepeat;
	java.lang.String id = null;
	private String[] items;
	private String returnUrl;  //返回列表，保留查询条件
	private TreeMap<String, String> dateSelectMap;// //日期选择
	TreeMap<String,String> provMap ;

	public TreeMap<String, String> getProvMap() {
		return provMap;
	}

	public void prepare() throws Exception {
		if (isNullOrEmptyString(id)) {
			tjGuestRepeat = new TtjGuestRepeat();
		} else {
			tjGuestRepeat = (TtjGuestRepeat)tjGuestRepeatManager.getTchPreById(id);
		}
	}
	
	/** 增加setXXXX()方法,spring就可以通过autowire自动设置对象属性 */
	public void setTtjGuestRepeatManager(TtjGuestRepeatManager manager) {
		this.tjGuestRepeatManager = manager;
	}
	
	public void setSsCommonManager(SsCommonManager ssCommonManager) {
		this.ssCommonManager = ssCommonManager;
	}
	
	public void setProvMap(TreeMap<String, String> provMap) {
		this.provMap = provMap;
	}
	
	public Object getModel() {
		return tjGuestRepeat;
	}
	
	public void setId(java.lang.String val) {
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
		return QUERY_JSP;
	}
	
	/** 执行搜索 */
	public String list() {
		PageRequest<Map> pageRequest = newPageRequest(DEFAULT_SORT_COLUMNS);
		HttpServletRequest request = ServletActionContext.getRequest();

		dateSelectMap  = DateUtil.getDateSelectData();
		if (request.getParameter("dateSelect1") != null)
			request.setAttribute("dateSelect1", request.getParameter("dateSelect1"));
		
		if (request.getParameter("s_inTime_Begin") != null)
			pageRequest.getFilters().put("inTime_BeginFormat",
					DateUtil.parseString(request,"s_inTime_Begin", "yyyy-MM-dd HH:mm", "yyyyMMddHHmm"));
		if (request.getParameter("s_inTime_End") != null)
			pageRequest.getFilters().put("inTime_EndFormat",
					DateUtil.parseString(request,"s_inTime_End", "yyyy-MM-dd HH:mm", "yyyyMMddHHmm"));
		
		if (StringUtils.isEmpty(request.getParameter("s_inCount"))){
			pageRequest.getFilters().put("inCount",5);
		}
		
		String s_TableName = "";
		if(StringUtils.isEmpty(request.getParameter("s_TableName"))){
			s_TableName = "V_CH_ALL";
		}else{
			s_TableName = request.getParameter("s_TableName");
		}
		
		Page page = tjGuestRepeatManager.findByPageRequest(pageRequest , s_TableName);
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
		tjGuestRepeatManager.save(tjGuestRepeat);
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
		tjGuestRepeatManager.update(this.tjGuestRepeat);
		return returnUrl;////LIST_ACTION;
	}
	
	/**删除对象*/
	public String delete() {
		for(int i = 0; i < items.length; i++) {
			Hashtable params = HttpUtils.parseQueryString(items[i]);
			java.lang.String id = new java.lang.String((String)params.get("id"));
			tjGuestRepeatManager.removeById(id);
		}
		return returnUrl ;//LIST_ACTION;
	}
	


}
