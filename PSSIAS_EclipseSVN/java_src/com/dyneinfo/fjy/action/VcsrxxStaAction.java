/*
 * Powered By [lishicheng]
 */

package com.dyneinfo.fjy.action;

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

import com.dyneinfo.fjy.model.*;
import com.dyneinfo.fjy.dao.*;
import com.dyneinfo.fjy.service.*;

/**
 * @author lisc email:lishicheng(a)gmail.com
 */


public class VcsrxxStaAction extends BaseStruts2Action implements Preparable,ModelDriven{
	//默认多列排序,example: username desc,createTime asc
	protected static final String DEFAULT_SORT_COLUMNS = null; 
	
	//forward paths
	protected static final String QUERY_JSP = "/pages/fjy/VcsrxxSta/query.jsp";
	protected static final String LIST_JSP= "/pages/fjy/VcsrxxSta/list.jsp";
	protected static final String TXLIST_JSP= "/pages/fjy/VcsrxxSta/txlist.jsp";
	protected static final String CSR_JSP = "/pages/fjy/VcsrxxSta/csrlist.jsp";
	protected static final String EDIT_JSP = "/pages/fjy/VcsrxxSta/edit.jsp";
	protected static final String SHOW_JSP = "/pages/fjy/VcsrxxSta/show.jsp";
	//redirect paths,startWith: !
	protected static final String LIST_ACTION = "!/pages/fjy/VcsrxxSta/list.do";
	
	private VcsrxxStaManager vcsrxxStaManager;
	
	private VcsrxxSta vcsrxxSta;
	java.lang.String id = null;
	private String[] items;
	private String returnUrl;  //返回列表，保留查询条件
	private TreeMap<String, String> dateSelectMap;// //日期选择

	public void prepare() throws Exception {
		if (isNullOrEmptyString(id)) {
			vcsrxxSta = new VcsrxxSta();
		} else {
			vcsrxxSta = (VcsrxxSta)vcsrxxStaManager.getById(id);
		}
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
        SecurityContext sc = SecurityContextHolder.getContext();
        Authentication auth = sc.getAuthentication();
        MyUserDetails ud = null;
		String username = "";
		String deptid = "";
		String deptseq="";
		String x = "";
		if ((auth != null) && auth.getPrincipal() instanceof MyUserDetails) {
			ud = (MyUserDetails) auth.getPrincipal();
			if (ud != null) {
				username = ud.getUserName();
				deptid = ud.getDeptID();
				deptseq=ud.getDeptSeq();
				x = ud.getDeptLevel();
				
			}
		}	
		dateSelectMap  = DateUtil.getDateSelectData();
//		HttpServletRequest request = ServletActionContext.getRequest();
//		request.setAttribute("dateSelect","11");//选中本周
	   
		String bDate = DateUtil.parseString(request,
				"s_shougourqBegin", "yyyy-MM-dd HH:mm", "yyyyMMddHHmmSS");
		String eDate = DateUtil.parseString(request,
				"s_shougourqEnd", "yyyy-MM-dd HH:mm", "yyyyMMddHHmmSS");
		String sql="";
		String s_deptseq=request.getParameter("s_deptseq")!=null?request.getParameter("s_deptseq"):deptseq;
		String npcode=request.getParameter("s_nativeplace")!=null?request.getParameter("s_nativeplace"):"";
		request.setAttribute("xzqhCode", npcode);
		request.setAttribute("deptseq", s_deptseq);
		
		if(vcsrxxSta.getNpcode()!=null)npcode=vcsrxxSta.getNpcode();
		sql="{call pr_csrxx_sta('"+s_deptseq+"','"+bDate+"','"+eDate+"','"+npcode+"',?)}";
		int pageSize = pageRequest.getPageSize();
		int pageNumber = pageRequest.getPageNumber();
		
		List list=(List)vcsrxxStaManager.getXML(sql);
		
		
	if(request.getParameter("tx")!=null&&!request.getParameter("tx").equals("")){
		request.setAttribute("tx", request.getParameter("tx"));
		int pagNumber=request.getParameter("pagenamber")!=null?(Integer.valueOf(request.getParameter("pagenamber"))):0;
		if(list.size()>20)request.setAttribute("scro", "scro");
		request.setAttribute("strXML", getXml(list,pagNumber));
		request.setAttribute("pagenamber",pagNumber);
		return TXLIST_JSP;
	}
		
		
		Page page=new Page(pageNumber, pageSize, list.size());
		page.setResult(list);
		savePage(page,pageRequest);

		return LIST_JSP;
	}
	public String getXml(List list,int pageNumber){
		StringBuffer strXML=new StringBuffer();
		if(!list.isEmpty()&&list.size()>0){
			strXML.append("<graph caption='出售人员统计' showNames='1' baseFontSize='12' showAlternateHGridColor='true' xAxisName='所属单位' yAxisName='斤数' numberSuffix='斤' >"); 
			String[] s=new String[]{"AFD8F8","F6BD0F","8BBA00","FF0099","0099FF"};
			int h=0;
			
			int i=pageNumber*12-12;
			int size=12;
			if(i<0)i=0;
			if(pageNumber>1){
				size=size*pageNumber;
			}
			if(size>list.size())size=list.size();
			for(;i<size;i++){
				Map map=(Map)list.get(i);
				strXML.append("<set name='");
				strXML.append(map.get("csrxm"));
				strXML.append("' value='");
				strXML.append(map.get("sumzl"));
//				strXML.append("' color='");
				
//				if(h>=5){
//					h=0;
//				}
//				strXML.append(s[h]);
//				h++;
				strXML.append("'/>");
			}
			
			strXML.append("</graph>");
		}
		

		return strXML.toString();
	}
	public String csrList(){
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
		
		Page page=vcsrxxStaManager.findByPageRequest(pageRequest);
		savePage(page,pageRequest);
		
		return CSR_JSP;
	}
	
	/** 查看对象*/
	public String show() {
		HttpServletRequest request = ServletActionContext.getRequest();
		return SHOW_JSP;
	}
	/** 增加setXXXX()方法,spring就可以通过autowire自动设置对象属性 */
	public void setVcsrxxStaManager(VcsrxxStaManager manager) {
		this.vcsrxxStaManager = manager;
	}	
	
	public Object getModel() {
		return vcsrxxSta;
	}
	
	public void setIdcard(java.lang.String val) {
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
}
