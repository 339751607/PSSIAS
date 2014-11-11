/*
 * Powered By [lishicheng]
 */

package com.dyneinfo.gas.action;

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

import com.dyneinfo.gas.model.*;
import com.dyneinfo.gas.dao.*;
import com.dyneinfo.gas.service.*;

/**
 * @author lisc email:lishicheng(a)gmail.com
 */


public class TalarmtelAction extends BaseStruts2Action implements Preparable,ModelDriven{
	//默认多列排序,example: username desc,createTime asc
	protected static final String DEFAULT_SORT_COLUMNS = null; 
	
	//forward paths
	protected static final String QUERY_JSP = "/pages/gas/Talarmtel/query.jsp";
	protected static final String LIST_JSP= "/pages/gas/Talarmtel/list.jsp";
	protected static final String CREATE_JSP = "/pages/gas/Talarmtel/create.jsp";
	protected static final String EDIT_JSP = "/pages/gas/Talarmtel/edit.jsp";
	protected static final String SHOW_JSP = "/pages/gas/Talarmtel/show.jsp";
	//redirect paths,startWith: !
	protected static final String LIST_ACTION = "!/pages/gas/Talarmtel/list.do";
	
	private TalarmtelManager talarmtelManager;
	
	private Talarmtel talarmtel;
	java.lang.String id = null;
	private String[] items;
	private String returnUrl;  //返回列表，保留查询条件
	private TreeMap<String, String> dateSelectMap;// //日期选择

	public void prepare() throws Exception {
		if (isNullOrEmptyString(id)) {
			talarmtel = new Talarmtel();
		} else {
			talarmtel = (Talarmtel)talarmtelManager.getById(id);
		}
	}
	
	/** 增加setXXXX()方法,spring就可以通过autowire自动设置对象属性 */
	public void setTalarmtelManager(TalarmtelManager manager) {
		this.talarmtelManager = manager;
	}	
	
	public Object getModel() {
		return talarmtel;
	}
	
	public void setDeptcode(java.lang.String val) {
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
		if(!"".equals(request.getParameter("s_exitend1"))&& request.getParameter("s_exitend1") != null){
			talarmtel.setExitend1(request.getParameter("s_exitend1").toString());
		}
		Page page = talarmtelManager.findByPageRequest(pageRequest);
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
		PageRequest<Map> pageRequest = newPageRequest(DEFAULT_SORT_COLUMNS);
		HttpServletRequest request = ServletActionContext.getRequest();
		pageRequest.getFilters().put("deptcode",talarmtel.getExitend1());
		Page page = talarmtelManager.findByPageRequest(pageRequest);
		if(page.getResult().size()>=1){
			request.setAttribute("message", "本辖区已设置报警电话，不能增加，请修改！");
			return CREATE_JSP;
		}else{
			if("1".equals(talarmtel.getAlarmall())){
				pageRequest = newPageRequest(DEFAULT_SORT_COLUMNS);
				pageRequest.getFilters().put("alarmall","1");
				page = talarmtelManager.findByPageRequest(pageRequest);
				if(page.getResult().size()>=1){
					request.setAttribute("message", "不能增加接收全部报警，请修改！");
					return CREATE_JSP;
				}else{
					talarmtelManager.save(talarmtel);
				}
			}else{
				talarmtelManager.save(talarmtel);
			}
		}
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
		PageRequest<Map> pageRequest = newPageRequest(DEFAULT_SORT_COLUMNS);
		if("1".equals(talarmtel.getAlarmall())){
			pageRequest.getFilters().put("alarmall","1");
			Page page = talarmtelManager.findByPageRequest(pageRequest);
			if(page.getResult().size()>=1){
				Talarmtel talarmtelcode = new Talarmtel();
				talarmtelcode = (Talarmtel)page.getResult().get(0);
				if(talarmtelcode.getDeptcode().equals(talarmtel.getDeptcode())){
					talarmtelManager.update(this.talarmtel);
				}else{
					request.setAttribute("message", "不能增加接收全部报警，请修改！");
					return EDIT_JSP;
				}
			}else{
				talarmtelManager.update(this.talarmtel);
			}
		}else{
			talarmtelManager.update(this.talarmtel);
		}
		
		return returnUrl;////LIST_ACTION;
	}
	
	/**删除对象*/
	public String delete() {
		for(int i = 0; i < items.length; i++) {
			Hashtable params = HttpUtils.parseQueryString(items[i]);
			java.lang.String id = new java.lang.String((String)params.get("deptcode"));
			talarmtelManager.removeById(id);
		}
		return returnUrl ;//LIST_ACTION;
	}

}
