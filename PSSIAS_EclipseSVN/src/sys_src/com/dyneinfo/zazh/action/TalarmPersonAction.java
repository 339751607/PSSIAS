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


public class TalarmPersonAction extends BaseStruts2Action implements Preparable,ModelDriven{
	//默认多列排序,example: username desc,createTime asc
	protected static final String DEFAULT_SORT_COLUMNS = null; 
	
	//forward paths
	protected static final String QUERY_JSP = "/pages/zazh/TalarmPerson/query.jsp";
	protected static final String LIST_JSP= "/pages/zazh/TalarmPerson/list.jsp";
	protected static final String CREATE_JSP = "/pages/zazh/TalarmPerson/create.jsp";
	protected static final String EDIT_JSP = "/pages/zazh/TalarmPerson/edit.jsp";
	protected static final String SHOW_JSP = "/pages/zazh/TalarmPerson/show.jsp";
	protected static final String ALARMSHOW_JSP = "/pages/zazh/TalarmPerson/alarmshow.jsp";
	
	//redirect paths,startWith: !
	protected static final String LIST_ACTION = "!/pages/zazh/TalarmPerson/list.do";
	
	protected static final String STATISQUERY_JSP = "/pages/zazh/TalarmPerson/statisQuery.jsp";
	protected static final String STATISLIST_JSP = "/pages/zazh/TalarmPerson/statisList.jsp";
	
	private TalarmPersonManager talarmPersonManager;
	private TbkPersonManager tbkPersonManager;
	private SsDeptManager ssDeptManager;
	
	private TalarmPerson talarmPerson;
	Long id = null;
	private String[] items;
	private String returnUrl;  //返回列表，保留查询条件
	private TreeMap<String, String> dateSelectMap;// //日期选择

	public void prepare() throws Exception {
		if (isNullOrEmptyString(id)) {
			talarmPerson = new TalarmPerson();
		} else {
			talarmPerson = (TalarmPerson)talarmPersonManager.getById(id);
		}
	}
	
	/** 增加setXXXX()方法,spring就可以通过autowire自动设置对象属性 */
	public void setTalarmPersonManager(TalarmPersonManager manager) {
		this.talarmPersonManager = manager;
	}	
	
	public Object getModel() {
		return talarmPerson;
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
		
		Page page = talarmPersonManager.findByPageRequest(pageRequest);
		savePage(page,pageRequest);
		return LIST_JSP;
	}
	
	/** 查看对象*/
	public String show() {
		HttpServletRequest request = ServletActionContext.getRequest();
		
		talarmPerson.setCjsj(DateUtil.parseString(talarmPerson.getCjsj(), "yyyyMMddHHmm", "yyyy-MM-dd HH:mm"));
		
		talarmPerson.setBdate(DateUtil.parseString(talarmPerson.getBdate(), "yyyyMMdd", "yyyy-MM-dd"));
		talarmPerson.setAlarmtime(DateUtil.parseString(talarmPerson.getAlarmtime(), "yyyyMMddHHmm", "yyyy-MM-dd HH:mm"));
		talarmPerson.setBusinesstime(DateUtil.parseString(talarmPerson.getBusinesstime(), "yyyyMMddHHmm", "yyyy-MM-dd HH:mm"));
	
		TbkPerson tbkPerson = tbkPersonManager.getById(talarmPerson.getBkid());
    	if(tbkPerson!=null){
    		if("".equals(tbkPerson.getCancelflag())){
    			request.setAttribute("cancelflag", "是");
    		}else{
    			request.setAttribute("cancelflag", "否");
    		}
            

            request.setAttribute("cancelcause", tbkPerson.getCancelcause());
    		tbkPersonManager.update(tbkPerson);
    	}
		return SHOW_JSP;
	}
	/** 查看对象*/
	public String alarmshow() {

		HttpServletRequest request = ServletActionContext.getRequest();
		//pageRequest.getFilters().put("key",value);     //add custom filter
		
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
		
		talarmPerson.setCjr(userxm);
		
		request.setAttribute("deptid", deptid);
		talarmPerson.setCjdw(deptname);
		talarmPerson.setCjsj(DateUtil.getNowTime("yyyy-MM-dd HH:ss"));
		talarmPerson.setBdate(DateUtil.parseString(talarmPerson.getBdate(),
                                                   "yyyyMMdd", "yyyy-MM-dd"));
		talarmPerson.setAlarmtime(DateUtil.parseString(talarmPerson.getAlarmtime(),
				                                       "yyyyMMddHHmm", "yyyy-MM-dd HH:mm"));
		talarmPerson.setBusinesstime(DateUtil.parseString(talarmPerson.getBusinesstime(),
                                                       "yyyyMMddHHmm", "yyyy-MM-dd HH:mm"));
		
		return ALARMSHOW_JSP;
	}
	/** 进入新增页面*/
	public String create() {
		return CREATE_JSP;
	}
	
	/** 保存新增对象 */
	public String save() {
		HttpServletRequest request = ServletActionContext.getRequest();
		talarmPersonManager.save(talarmPerson);
		return returnUrl;////LIST_ACTION;
	}
	/** 保存新增对象 */
	public String alarmsave() {
		HttpServletRequest request = ServletActionContext.getRequest();

        talarmPerson.setCjsj(DateUtil.parseString(talarmPerson.getCjsj(), "yyyy-MM-dd HH:ss", "yyyyMMddHHss"));
        talarmPerson.setZhsj(DateUtil.parseString(talarmPerson.getZhsj(), "yyyy-MM-dd HH:ss", "yyyyMMddHHss"));
        if(talarmPerson.getBkid()!=null && !"".equals(talarmPerson.getBkid())){
        	TbkPerson tbkPerson = tbkPersonManager.getById(talarmPerson.getBkid());
        	if(tbkPerson!=null){
        		String cancelflag = request.getParameter("cancelflag")==null? "0" : request.getParameter("cancelflag");
        		String cancelcause = request.getParameter("cancelcause")==null? "0" : request.getParameter("cancelcause");
        		
        		tbkPerson.setCancelflag(cancelflag);
        		tbkPerson.setCancelcause(cancelcause);
        		tbkPerson.setCancelname(talarmPerson.getCjr());
        		tbkPerson.setCanceltime(DateUtil.getNowTime("yyyyMMddHHmm"));
        		tbkPersonManager.update(tbkPerson);
        	}
        }
        talarmPersonManager.update(talarmPerson);
		
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
		talarmPersonManager.update(this.talarmPerson);
		return returnUrl;////LIST_ACTION;
	}
	
	/**删除对象*/
	public String delete() {
		for(int i = 0; i < items.length; i++) {
			Hashtable params = HttpUtils.parseQueryString(items[i]);
			Long id = new Long((String)params.get("id"));
			talarmPersonManager.removeById(id);
		}
		return returnUrl ;//LIST_ACTION;
	}
	/** 进入统计页面 */
	public String statisAlarmQuery() {
		//日历快速选择用到
		dateSelectMap  = DateUtil.getDateSelectData();
        return STATISQUERY_JSP;
	}
	/** 执行统计 */
	public String statisAlarmList() {
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
     			    List empStatusList = talarmPersonManager.getAlarmCountByDeptCode(s_statisType, deptCode, starttime, endtime );
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
     				List empStatusList = talarmPersonManager.getAlarmCountByDeptCode(s_statisType, deptCode, s_starttime, s_endtime );
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
		
		return STATISLIST_JSP;
	}
	public TbkPersonManager getTbkPersonManager() {
		return tbkPersonManager;
	}

	public void setTbkPersonManager(TbkPersonManager tbkPersonManager) {
		this.tbkPersonManager = tbkPersonManager;
	}

	public SsDeptManager getSsDeptManager() {
		return ssDeptManager;
	}

	public void setSsDeptManager(SsDeptManager ssDeptManager) {
		this.ssDeptManager = ssDeptManager;
	}

}
