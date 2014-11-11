/*
 * Powered By [lishicheng]
 */

package com.dyneinfo.ylcs.action;

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

import com.dyneinfo.ylcs.model.*;
import com.dyneinfo.ylcs.dao.*;
import com.dyneinfo.ylcs.service.*;
import com.dyneinfo.zazh.model.DictItem;


/**
 * @author user - 刘涛 
 * @notice 
 * @since  2014-10-29 
 */
public class SatisficInfoAction extends BaseStruts2Action implements Preparable,ModelDriven{
	//默认多列排序,example: username desc,createTime asc
	protected static final String DEFAULT_SORT_COLUMNS = null; 
	
	//forward paths
	protected static final String QUERY_JSP = "/pages/ylcs/SatisficInfo/query.jsp";
	protected static final String LIST_JSP= "/pages/ylcs/SatisficInfo/list.jsp";
	protected static final String CREATE_JSP = "";
	protected static final String EDIT_JSP = "";
	protected static final String SHOW_JSP = "/pages/ylcs/SatisficInfo/show.jsp";
	//redirect paths,startWith: !
	protected static final String LIST_ACTION = "!/pages/ylcs/SatisficInfo/list.do";
	
	private SatisficInfoManager satisficInfoManager;
	
	private SatisficInfo satisficInfo;
	java.lang.String id = null;
	private String[] items;
	private String returnUrl;  //返回列表，保留查询条件
	private TreeMap<String, String> dateSelectMap;// //日期选择

	public void prepare() throws Exception {
		if (isNullOrEmptyString(id)) {
			satisficInfo = new SatisficInfo();
		} else {
			satisficInfo = (SatisficInfo)satisficInfoManager.getById(id);
		}
	}
	
	/** 增加setXXXX()方法,spring就可以通过autowire自动设置对象属性 */
	public void setSatisficInfoManager(SatisficInfoManager manager) {
		this.satisficInfoManager = manager;
	}	
	
	public Object getModel() {
		return satisficInfo;
	}
	
	public void setLocode(java.lang.String val) {
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
	
	public String list() {
		String p_startTime = null,p_endTime = null,p_type = null;  //p_开头的变量，为调用控制层方法的传递参数
		int p_d = 1;
		PageRequest<Map> pageRequest = newPageRequest(DEFAULT_SORT_COLUMNS);
		HttpServletRequest request = ServletActionContext.getRequest();
		
        SecurityContext sc = SecurityContextHolder.getContext();
        Authentication auth = sc.getAuthentication();
        MyUserDetails ud = null;
		String username = "";
		String deptid = "";
		String deptLevel = "";
		if ((auth != null) && auth.getPrincipal() instanceof MyUserDetails) {
			ud = (MyUserDetails) auth.getPrincipal();
			if (ud != null) {
				username = ud.getUserName();
				deptid = ud.getDeptID();
				
			}
		}	
	
		dateSelectMap  = DateUtil.getDateSelectData();
		
		String s_statisType = pageRequest.getFilters().get("statisType")==null?"0":pageRequest.getFilters().get("statisType").toString();
		String s_burcode = pageRequest.getFilters().get("burcode")==null?"0":pageRequest.getFilters().get("burcode").toString();
		
		String s_starttime = pageRequest.getFilters().get("starttime")==null?"":pageRequest.getFilters().get("starttime").toString();
		String s_endtime = pageRequest.getFilters().get("endtime")==null?"":pageRequest.getFilters().get("endtime").toString();
		String s_day = request.getParameter("s_day")==null?"1":request.getParameter("s_day").toString();
		
		request.setAttribute("statisType", s_statisType);
		request.setAttribute("burcode", s_burcode);
		request.setAttribute("starttime", s_starttime);
		request.setAttribute("endtime", s_endtime);		
		request.setAttribute("pageRequest", pageRequest);
		if(request.getParameter("s_statisType")!=null){
			if(request.getParameter("s_statisType").equals("0")){
				
				deptLevel = "1";
			} else{
				deptid = s_burcode;
				deptLevel = "2";
			}
		}
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
		
		if(s_starttime!=null && !s_starttime.equals("")){
			s_starttime = s_starttime.replace("-", "");
		}else{
			s_starttime = sdf.format(new Date());
		}
		if(s_endtime!=null && !s_endtime.equals("")){
			s_endtime = s_endtime.replace("-", "");
		}else{
			s_endtime = sdf.format(new Date());
		}
		
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
          
		//所有行业的字典信息
		List businessDictList =  DictHelpImpl.getDict("DIC_ITEM_VALID_BUSINESSCODE"); 
		businessDictList.remove(0);   // 去掉"000"
		
		request.setAttribute("businessDictList", businessDictList);
		
		List deptList = null;
		List<SatisficInfo> returnDeptList = new ArrayList<SatisficInfo>();
		
//		returnDeptList = satisficInfoManager.statisfic(deptid,p_d,p_startTime,p_endTime,p_type);
		returnDeptList = satisficInfoManager.statisfic(deptid,Integer.parseInt(s_day),s_starttime, s_endtime,"",deptLevel);
		List<ArrayList<String>> chongzuList = new ArrayList<ArrayList<String>>();        //重组returnDeptList 
		
		HashMap<String,String> nameMap = new HashMap<String,String>();
		
		for (int i = 0; i < returnDeptList.size(); i++) {
			SatisficInfo si = returnDeptList.get(i);
			String deptId = si.getDeptId();
			int index = isDeptIdExsit(chongzuList,deptId);
			if(index!=-1){
					ArrayList<String> list = chongzuList.get(index);
					list.add(si.getOpenNum());
					list.add(si.getUploadNum());
					list.add(si.getNotUploadNum());
					chongzuList.set(index, list);
			}else{
				ArrayList<String> list = new ArrayList<String>();
				nameMap.put(si.getDeptId(), si.getDeptName());
				list.add(si.getDeptId());
				list.add(si.getOpenNum());
				list.add(si.getUploadNum());
				list.add(si.getNotUploadNum());
				chongzuList.add(list);
			}
		}
		// 添加合计信息  
		List<String> hejiList = new ArrayList<String>();
		//初始化 hejiList  
		hejiList.add("总计");
		for (int i = 0; i < businessDictList.size(); i++) {
			hejiList.add("0");
			hejiList.add("0");
			hejiList.add("0");
		}
		for (int i = 0; i < chongzuList.size(); i++) {
			
			List<String> list = chongzuList.get(i);
			for (int j = 0; j < list.size(); j++) {
				if(j==0){continue;}
				hejiList.set(j, String.valueOf(Integer.parseInt(hejiList.get(j))+Integer.parseInt(list.get(j))));
			}
		}
		
	    request.setAttribute("deptList", chongzuList);
	    request.setAttribute("hejiList", hejiList);
	    request.setAttribute("nameMap", nameMap);
		return LIST_JSP;
	}
	
	private int isDeptIdExsit(List<ArrayList<String>> list,String deptId){ //   返回-1表示不存在
		for (int i = 0; i < list.size(); i++) {
			String id = list.get(i).get(0);
			if(id!=null && deptId.equals(id)){
				return i;
			}
		}
		return -1;
	}
	
	private String getBusinessName(List businessDictList,String id){
		 for(int i=0; i < businessDictList.size(); i++){
			   
			   DictItem item = (DictItem)businessDictList.get(i);
			  
			   if("000".equals(item.getDictid())){ //治安综合忽略掉
				   continue;
			   }
			   if(item.getDictid().equals(id)){
				   return item.getDictname();
			   }
		 }
		 return "";
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
		satisficInfoManager.save(satisficInfo);
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
		satisficInfoManager.update(this.satisficInfo);
		return returnUrl;////LIST_ACTION;
	}
	
	/**删除对象*/
	public String delete() {
		for(int i = 0; i < items.length; i++) {
			Hashtable params = HttpUtils.parseQueryString(items[i]);
			java.lang.String id = new java.lang.String((String)params.get("locode"));
			satisficInfoManager.removeById(id);
		}
		return returnUrl ;//LIST_ACTION;
	}

}
