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

import java.io.IOException;
import java.text.SimpleDateFormat;
import net.java.dev.common.util.DateUtil;
import org.apache.struts2.ServletActionContext;

import sun.misc.BASE64Decoder;

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
import com.dyneinfo.zazh.model.SsDept;

/**
 * @author lisc email:lishicheng(a)gmail.com
 */


public class TemployeegasAction extends BaseStruts2Action implements Preparable,ModelDriven{
	//默认多列排序,example: username desc,createTime asc
	protected static final String DEFAULT_SORT_COLUMNS = null; 
	
	//forward paths
	protected static final String QUERY_JSP = "/pages/gas/Temployee/query.jsp";
	protected static final String LIST_JSP= "/pages/gas/Temployee/list.jsp";
	protected static final String QYLIST_JSP= "/pages/gas/Temployee/qylist.jsp";
	protected static final String CREATE_JSP = "/pages/gas/Temployee/create.jsp";
	protected static final String EDIT_JSP = "/pages/gas/Temployee/edit.jsp";
	protected static final String SHOW_JSP = "/pages/gas/Temployee/show.jsp";
	protected static final String ZAZHSHOW_JSP = "/pages/gas/Temployee/zazhShow.jsp";
	
	protected static final String SHOW_PIC = "/pages/pic/pic.jsp";
	//redirect paths,startWith: !
	protected static final String LIST_ACTION = "!/pages/gas/Temployee/list.do";
	
	private TemployeegasManager temployeegasManager;
	private TcompanyinfogasManager tcompanyinfogasManager;
	private TempPicManager tempPicManager;
	private TbuylogManager tbuylogManager;
	private TempworkloggasManager tempworkloggasManager;
	
	private Temployee temployee;
	private Tcompanyinfo tcompanyinfo;
	private Tempworklog  tempworklog;
	private TempPic tempPic;
	private String mgs;
	TreeMap<String,String> compMap ;
	
	TreeMap<String,String> provMap ;
	java.lang.String id = null;
	private String[] items;
	private String returnUrl;  //返回列表，保留查询条件
	private TreeMap<String, String> dateSelectMap;// //日期选择

	public void prepare() throws Exception {
		if (isNullOrEmptyString(id)) {
			temployee = new Temployee();
		} else {
			temployee = (Temployee)temployeegasManager.getById(id);
		}
	}
	
	/** 增加setXXXX()方法,spring就可以通过autowire自动设置对象属性 */
	public void setTemployeegasManager(TemployeegasManager manager) {
		this.temployeegasManager = manager;
	}	
	
	public Object getModel() {
		return temployee;
	}
	
	public void setEmpcode(java.lang.String val) {
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
	
	/**
	 * 初始三级联动下拉框赋值
	 */
	public void qyxx(PageRequest<Map> pageRequest){
		MyUserDetails ud = null;
		String code ="";
		String pcscode = "";
		String pcsname = "";
		SecurityContext sc = SecurityContextHolder.getContext();
		Authentication auth = sc.getAuthentication();
		if ((auth != null) && auth.getPrincipal() instanceof MyUserDetails) {
			ud = (MyUserDetails) auth.getPrincipal();
			if (ud != null) {
				code = ud.getDeptID().toString();
			}
		}
		
		List listdept = tbuylogManager.findDept( "and CODE = '"+code +"'" );
		if(listdept != null && listdept.size() > 0){
			for(int j = 0; j<listdept.size(); j++){
				SsDept ssdept = (SsDept) listdept.get(j);
				String deptlevel = ssdept.getDeptlevel().toString();
				String buildxh_temp = ssdept.getDeptcode();
				String buildNoName_temp = ssdept.getDeptname();
				String buildburcode = ssdept.getParentid().toString();
				if("2".equals(deptlevel)){
					pageRequest.getFilters().put("burcode", buildxh_temp);
					provMap.put(buildxh_temp, buildNoName_temp);
				}else if ("3".equals(deptlevel)){
					pageRequest.getFilters().put("stacode", buildxh_temp);
					pcscode = buildxh_temp;
					pcsname = buildNoName_temp;
					List listburcode = tbuylogManager.findDept( "and  CODE = '"+buildburcode +"'" );
					if(listburcode != null && listburcode.size() > 0){
						for(int k = 0; k<listburcode.size(); k++){
							SsDept thotelfj = (SsDept) listburcode.get(k);
							String burcode = thotelfj.getDeptcode();
							String burname = thotelfj.getDeptname();
							provMap.put(burcode, burname);
						}
					}
				}else{
					List listconfig = tbuylogManager.findAllBureau();
					if (listconfig != null && listconfig.size() > 0) {
						for (int i = 0; i < listconfig.size(); i++) {
							SsDept thotelsj = (SsDept) listconfig.get(i);
							String sjcode = thotelsj.getDeptcode();
							String sjname = thotelsj.getDeptname();
							provMap.put(sjcode, sjname);
						}
						provMap.put("", "请选择...");
					}
				}
				
			}
		}else{
			List listconfig = tbuylogManager.findAllBureau();
			if (listconfig != null && listconfig.size() > 0) {
				for (int i = 0; i < listconfig.size(); i++) {
					SsDept ssDept = (SsDept) listconfig.get(i);
					String buildxh_temp = ssDept.getDeptcode();
					String buildNoName_temp = ssDept.getDeptname();
					provMap.put(buildxh_temp, buildNoName_temp);
					
				}
				provMap.put("", "请选择...");
			}
		}
		HttpServletRequest request = ServletActionContext.getRequest();
		request.setAttribute("pcscode", pcscode);
		request.setAttribute("pcsname", pcsname);
	}
	
	private static byte[] getPicStringToByte(String picture){
		BASE64Decoder decoder = new BASE64Decoder();
		byte[] bytePic = null;
		try {
			bytePic = decoder.decodeBuffer(picture);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return bytePic;
	}
	
	//显示图片
	public String showPic() {
		HttpServletRequest request = ServletActionContext.getRequest();
		String xh = "";
		if (request.getParameter("xh") != null)
			xh = request.getParameter("xh");
		List list = (List) temployeegasManager.getPic(xh);
		request.setAttribute("list", list);   
		return SHOW_PIC;
	}
	
	/** 执行搜索 */
	public String list() {
		PageRequest<Map> pageRequest = newPageRequest(DEFAULT_SORT_COLUMNS);
		HttpServletRequest request = ServletActionContext.getRequest();
		//pageRequest.getFilters().put("key",value);     //add custom filter
		
		String code ="";
		String deplevel ="";
        SecurityContext sc = SecurityContextHolder.getContext();
        Authentication auth = sc.getAuthentication();
        MyUserDetails ud = null;
        if ((auth != null) && auth.getPrincipal() instanceof MyUserDetails) {
			ud = (MyUserDetails) auth.getPrincipal();
			if (ud != null) {
				code = ud.getDeptID().toString();
				deplevel= ud.getDeptLevel();
			}
		}
        compMap = new TreeMap();
        
        if("2".equals(deplevel)){
			deplevel= " and burcode="+code;
			
		}else if("3".equals(deplevel)){
			deplevel= " and stacode="+code;
		}else{
			deplevel="";
		}
		List listcomp = tbuylogManager.findComp( deplevel);
		if(listcomp != null && listcomp.size() > 0){
			for(int j = 0; j<listcomp.size(); j++){
				SsDept ssdept = (SsDept) listcomp.get(j);
				String buildxh_temp = ssdept.getDeptcode();
				String buildNoName_temp = ssdept.getDeptname();
				compMap.put(buildxh_temp, buildNoName_temp);
			}
			compMap.put("", " 请选择...");
		}
		
		provMap = new TreeMap();
		qyxx(pageRequest);
		dateSelectMap  = DateUtil.getDateSelectData();
		
		String dateSelect19 = "";
		if (request.getParameter("dateSelect19") != null)
		    dateSelect19 = request.getParameter("dateSelect19");
			request.setAttribute("dateSelect19",dateSelect19);		        
		if (request.getParameter("s_indateBegin") != null){
			String s_indateBeginFormat = DateUtil.parseString(request,"s_indateBegin","yyyy-MM-dd","yyyyMMdd");
			pageRequest.getFilters().put("indateBeginFormat",s_indateBeginFormat);
			
		}
		if (request.getParameter("s_indateEnd") != null){
			String s_indateEndFormat = DateUtil.parseString(request,"s_indateEnd","yyyy-MM-dd","yyyyMMdd");
			pageRequest.getFilters().put("indateEndFormat",s_indateEndFormat);
		}
		
		
		Page page = temployeegasManager.findByPageRequest(pageRequest);
		savePage(page,pageRequest);
		return LIST_JSP;
	}
	
	
	/** 执行搜索 */
	public String qylist() {
		PageRequest<Map> pageRequest = newPageRequest(DEFAULT_SORT_COLUMNS);
		HttpServletRequest request = ServletActionContext.getRequest();
		//pageRequest.getFilters().put("key",value);     //add custom filter
		provMap = new TreeMap();

		MyUserDetails ud = null;
		String code ="";
		String pcscode = "";
		String pcsname = "";
		SecurityContext sc = SecurityContextHolder.getContext();
		Authentication auth = sc.getAuthentication();
		if ((auth != null) && auth.getPrincipal() instanceof MyUserDetails) {
			ud = (MyUserDetails) auth.getPrincipal();
			if (ud != null) {
				code = ud.getUsername();
			}
		}
		
		dateSelectMap  = DateUtil.getDateSelectData();
		
		pageRequest.getFilters().put("cpcode",code);
		Page page = temployeegasManager.findByPageRequest(pageRequest);
		savePage(page,pageRequest);
		return QYLIST_JSP;
	}
	
	/** 查看对象*/
	public String show() {
		HttpServletRequest request = ServletActionContext.getRequest();
		return SHOW_JSP;
	}
	
	public String zazhShow() {
		HttpServletRequest request = ServletActionContext.getRequest();
		return ZAZHSHOW_JSP;
	}
	
	/** 进入新增页面*/
	public String create() {
		SimpleDateFormat rq = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		temployee.setInserttime(rq.format(new Date()));
		return CREATE_JSP;
	}
	
	/** 保存新增对象 */
	public String save() {
		HttpServletRequest request = ServletActionContext.getRequest();
		MyUserDetails ud = null;
		String cpcode ="";
		SecurityContext sc = SecurityContextHolder.getContext();
		Authentication auth = sc.getAuthentication();
		if ((auth != null) && auth.getPrincipal() instanceof MyUserDetails) {
			ud = (MyUserDetails) auth.getPrincipal();
			if (ud != null) {
				cpcode = ud.getUsername().toString();
			}
		}
		
		String bdate = DateUtil.parseString(request,"birth","yyyy-MM-dd","yyyyMMdd");
		String inserttime = DateUtil.parseString(request,"inserttime","yyyy-MM-dd HH:mm:ss","yyyyMMddHHmmss");
		SimpleDateFormat rq = new SimpleDateFormat("yyyyMMddHHmmss");
		tcompanyinfo= new Tcompanyinfo();
		tcompanyinfo = tcompanyinfogasManager.getById(cpcode);
		
		temployee.setBirth(bdate);
		temployee.setTratime(rq.format(new Date()));
		temployee.setEdittime(rq.format(new Date()));
		temployee.setCpcode(tcompanyinfo.getCpcode());
		temployee.setStacode(tcompanyinfo.getStacode());
		temployee.setBurcode(tcompanyinfo.getBurcode());
		temployee.setInserttime(inserttime);
		
	
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
		String currentDate = sdf.format(new Date());	    
		String prefixID = cpcode + currentDate;
		temployee.setEmpcode(prefixID);
		temployeegasManager.save(temployee);
		
		String indate = DateUtil.parseString(request,"indate","yyyy-MM-dd","yyyyMMdd");
		String leftdate = "";
		if(request.getParameter("leftdate") != null){
			leftdate = DateUtil.parseString(request,"leftdate","yyyy-MM-dd","yyyyMMdd");
		}
		
		tempworklog = new Tempworklog(); //从业人员工作记录
		tempworklog.setEmpcode(prefixID);
		tempworklog.setCpcode(tcompanyinfo.getCpcode());
		tempworklog.setIndate(indate);
		tempworklog.setLeftdate(leftdate);
		tempworklog.setEmpduty(temployee.getEmpduty());
		tempworkloggasManager.save(tempworklog);
		
//		if(temployee.getPPhotoBuffer() != null){
			tempPic = new TempPic();
			tempPic.setEmpcode(temployee.getEmpcode());
		    byte[] pic = getPicStringToByte(temployee.getPPhotoBuffer());
		    tempPic.setPiclen(pic.length);
		    tempPic.setPicture(pic);
		    tempPicManager.save(tempPic);
//		}   
		mgs="保存成功！";
		
		return create();////LIST_ACTION;
	}
	
	/**进入更新页面*/
	public String edit() {
		HttpServletRequest request = ServletActionContext.getRequest();
		
		String inserttime = temployee.getInserttime();
		String inserttimeFormat = DateUtil.parseString(inserttime,"yyyyMMddHHmmss","yyyy-MM-dd HH:mm:ss");
		temployee.setInserttime(inserttimeFormat);
		return EDIT_JSP;
	}
	
	/**保存更新对象*/
	public String update() {
		HttpServletRequest request = ServletActionContext.getRequest();
		
		String bdate = DateUtil.parseString(request,"birth","yyyy-MM-dd","yyyyMMdd");
		String inserttime = DateUtil.parseString(request,"inserttime","yyyy-MM-dd HH:mm:ss","yyyyMMddHHmmss");
		SimpleDateFormat rq = new SimpleDateFormat("yyyyMMddHHmmss");
		
		temployee.setBirth(bdate);
		temployee.setTratime(rq.format(new Date()));
		temployee.setEdittime(rq.format(new Date()));
		temployee.setInserttime(inserttime);
		
		temployeegasManager.update(this.temployee);
		
		String indate = DateUtil.parseString(request,"indate","yyyy-MM-dd","yyyyMMdd");
		String leftdate = "";
		if(request.getParameter("leftdate") != null){
			leftdate = DateUtil.parseString(request,"leftdate","yyyy-MM-dd","yyyyMMdd");
		}
		
		tempworklog = new Tempworklog(); //从业人员工作记录
		tempworklog.setEmpcode(temployee.getEmpcode());
		tempworklog.setCpcode(temployee.getCpcode());
		tempworklog.setIndate(indate);
		tempworklog.setLeftdate(leftdate);
		tempworklog.setEmpduty(temployee.getEmpduty());
		tempworkloggasManager.update(tempworklog);
		
 	if(temployee.getPPhotoBuffer() != null){
			tempPic = new TempPic();
			tempPic.setEmpcode(temployee.getEmpcode());
		    byte[] pic = getPicStringToByte(temployee.getPPhotoBuffer());
		    tempPic.setPiclen(pic.length);
		    tempPic.setPicture(pic);
		    tempPicManager.update(tempPic);
 	}   
		mgs="保存成功！";
		
		return returnUrl;////LIST_ACTION;
	}
	
	/**删除对象*/
	public String delete() {
		for(int i = 0; i < items.length; i++) {
			Hashtable params = HttpUtils.parseQueryString(items[i]);
			java.lang.String id = new java.lang.String((String)params.get("empcode"));
			temployeegasManager.removeById(id);
		}
		return returnUrl ;//LIST_ACTION;
	}

	public void setTbuylogManager(TbuylogManager tbuylogManager) {
		this.tbuylogManager = tbuylogManager;
	}

	public TreeMap<String, String> getProvMap() {
		return provMap;
	}

	public void setProvMap(TreeMap<String, String> provMap) {
		this.provMap = provMap;
	}

	public void setTcompanyinfogasManager(TcompanyinfogasManager tcompanyinfogasManager) {
		this.tcompanyinfogasManager = tcompanyinfogasManager;
	}

	public void setTempPicManager(TempPicManager tempPicManager) {
		this.tempPicManager = tempPicManager;
	}

	public String getMgs() {
		return mgs;
	}

	public void setMgs(String mgs) {
		this.mgs = mgs;
	}

	public void setTempworkloggasManager(TempworkloggasManager tempworkloggasManager) {
		this.tempworkloggasManager = tempworkloggasManager;
	}

	public TreeMap<String, String> getCompMap() {
		return compMap;
	}

	public void setCompMap(TreeMap<String, String> compMap) {
		this.compMap = compMap;
	}

}
