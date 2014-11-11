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

/**
 * @author lisc email:lishicheng(a)gmail.com
 */


public class TalarmCarAction extends BaseStruts2Action implements Preparable,ModelDriven{
	//默认多列排序,example: username desc,createTime asc
	protected static final String DEFAULT_SORT_COLUMNS = null; 
	
	//forward paths
	protected static final String QUERY_JSP = "/pages/zazh/TalarmCar/query.jsp";
	protected static final String LIST_JSP= "/pages/zazh/TalarmCar/list.jsp";
	protected static final String CREATE_JSP = "/pages/zazh/TalarmCar/create.jsp";
	protected static final String EDIT_JSP = "/pages/zazh/TalarmCar/edit.jsp";
	protected static final String SHOW_JSP = "/pages/zazh/TalarmCar/show.jsp";
	protected static final String ALARMSHOW_JSP = "/pages/zazh/TalarmCar/alarmshow.jsp";

	//redirect paths,startWith: !
	protected static final String LIST_ACTION = "!/pages/zazh/TalarmCar/list.do";
	
	private TalarmCarManager talarmCarManager;
	private TbkCarManager tbkCarManager;
	private TalarmCar talarmCar;
	Long id = null;
	private String[] items;
	private String returnUrl;  //返回列表，保留查询条件
	private TreeMap<String, String> dateSelectMap;// //日期选择

	public void prepare() throws Exception {
		if (isNullOrEmptyString(id)) {
			talarmCar = new TalarmCar();
		} else {
			talarmCar = (TalarmCar)talarmCarManager.getById(id);
		}
	}
	
	/** 增加setXXXX()方法,spring就可以通过autowire自动设置对象属性 */
	public void setTalarmCarManager(TalarmCarManager manager) {
		this.talarmCarManager = manager;
	}	
	
	public Object getModel() {
		return talarmCar;
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
		
		//限定获取数据的范围		
		pageRequest.getFilters().put("deptseq", deptid);
		
		Page page = talarmCarManager.findByPageRequest(pageRequest);
		savePage(page,pageRequest);
		return LIST_JSP;
	}
	
	/** 查看对象*/
	public String show() {
		HttpServletRequest request = ServletActionContext.getRequest();
		
		talarmCar.setCjsj(DateUtil.parseString(talarmCar.getCjsj(),
				"yyyyMMddHHmm", "yyyy-MM-dd HH:mm"));		
		talarmCar.setAlarmtime(DateUtil.parseString(talarmCar.getAlarmtime(),
                "yyyyMMddHHmm", "yyyy-MM-dd HH:mm"));
        talarmCar.setBusinesstime(DateUtil.parseString(talarmCar.getBusinesstime(),
                "yyyyMMddHHmm", "yyyy-MM-dd HH:mm"));
        
        if(talarmCar.getBkid()!=null && !"".equals(talarmCar.getBkid())){
        	TbkCar tbkCar = tbkCarManager.getById(talarmCar.getBkid());
        	if(tbkCar!=null){
        		if("".equals(tbkCar.getCancelflag())){
        			request.setAttribute("cancelflag", "是");
        		}else{
        			request.setAttribute("cancelflag", "否");
        		}       
                request.setAttribute("cancelcause", tbkCar.getCancelcause());
        	}
        }
		return SHOW_JSP;
	}
	
	/** 查看对象*/
	public String alarmshow() {
		HttpServletRequest request = ServletActionContext.getRequest();
		
        SecurityContext sc = SecurityContextHolder.getContext();
        Authentication auth = sc.getAuthentication();
        MyUserDetails ud = null;
		String username = "";
		String userxm = "";
		String deptid = "";
		String deptname = "";
		if ((auth != null) && auth.getPrincipal() instanceof MyUserDetails) {
			ud = (MyUserDetails) auth.getPrincipal();
			if (ud != null) {
				username = ud.getUserName();
				userxm = ud.getUserXm();
				deptid = ud.getDeptID();
				deptname = ud.getDeptName();
			}
		}		
		
		talarmCar.setCjr(userxm);
		
		request.setAttribute("deptid", deptid);
		talarmCar.setCjdw(deptname);
		talarmCar.setCjsj(DateUtil.getNowTime("yyyy-MM-dd HH:ss"));
		talarmCar.setAlarmtime(DateUtil.parseString(talarmCar.getAlarmtime(),
				                                       "yyyyMMddHHmm", "yyyy-MM-dd HH:mm"));
		talarmCar.setBusinesstime(DateUtil.parseString(talarmCar.getBusinesstime(),
                                                       "yyyyMMddHHmm", "yyyy-MM-dd HH:mm"));

		return ALARMSHOW_JSP;
	}
	/** 保存新增对象 */
	public String alarmsave() {
		HttpServletRequest request = ServletActionContext.getRequest();
		talarmCar.setCjsj(DateUtil.parseString(talarmCar.getCjsj(), "yyyy-MM-dd HH:ss", "yyyyMMddHHss"));
		talarmCar.setZhsj(DateUtil.parseString(talarmCar.getZhsj(), "yyyy-MM-dd HH:ss", "yyyyMMddHHss"));
        if(talarmCar.getBkid()!=null && !"".equals(talarmCar.getBkid())){
        	TbkCar tbkCar = tbkCarManager.getById(talarmCar.getBkid());
        	if(tbkCar!=null){
        		String cancelflag = request.getParameter("cancelflag")==null? "0" : request.getParameter("cancelflag");
        		String cancelcause = request.getParameter("cancelcause")==null? "0" : request.getParameter("cancelcause");
        		
        		tbkCar.setCancelflag(cancelflag);
        		tbkCar.setCancelcause(cancelcause);
        		tbkCar.setCancelname(talarmCar.getCjr());
        		tbkCar.setCanceltime(DateUtil.getNowTime("yyyyMMddHHmm"));
        		tbkCarManager.update(tbkCar);
        	}
        }
        talarmCarManager.update(talarmCar);
		return returnUrl;////LIST_ACTION;
	}
	/** 进入新增页面*/
	public String create() {
		return CREATE_JSP;
	}
	
	/** 保存新增对象 */
	public String save() {
		HttpServletRequest request = ServletActionContext.getRequest();
		talarmCarManager.save(talarmCar);
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
		talarmCarManager.update(this.talarmCar);
		return returnUrl;////LIST_ACTION;
	}
	
	/**删除对象*/
	public String delete() {
		for(int i = 0; i < items.length; i++) {
			Hashtable params = HttpUtils.parseQueryString(items[i]);
			Long id = new Long((String)params.get("id"));
			talarmCarManager.removeById(id);
		}
		return returnUrl ;//LIST_ACTION;
	}

	public TbkCarManager getTbkCarManager() {
		return tbkCarManager;
	}

	public void setTbkCarManager(TbkCarManager tbkCarManager) {
		this.tbkCarManager = tbkCarManager;
	}

}
