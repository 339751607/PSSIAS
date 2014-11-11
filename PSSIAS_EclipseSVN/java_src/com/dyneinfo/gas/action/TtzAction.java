/*
 * Powered By [lishicheng]
 */

package com.dyneinfo.gas.action;

import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import javacommon.base.BaseStruts2Action;

import javax.servlet.http.HttpServletRequest;

import net.java.dev.common.util.DateUtil;

import org.apache.struts2.ServletActionContext;
import org.security.userdetails.MyUserDetails;
import org.springframework.security.Authentication;
import org.springframework.security.context.SecurityContext;
import org.springframework.security.context.SecurityContextHolder;

import com.dyneinfo.zazh.model.SsDept;
import cn.org.rapid_framework.page.Page;
import cn.org.rapid_framework.page.PageRequest;
import cn.org.rapid_framework.web.util.HttpUtils;

import com.dyneinfo.gas.model.Ttz;
import com.dyneinfo.gas.model.TtztbFile;
import com.dyneinfo.gas.service.TbuylogManager;
import com.dyneinfo.gas.service.TtzManager;
import com.dyneinfo.gas.service.TtztbFileManager;
import com.opensymphony.xwork2.ModelDriven;
import com.opensymphony.xwork2.Preparable;

/**
 * @author lisc email:lishicheng(a)gmail.com
 */


public class TtzAction extends BaseStruts2Action implements Preparable,ModelDriven{
	//默认多列排序,example: username desc,createTime asc
	protected static final String DEFAULT_SORT_COLUMNS = null; 
	
	//forward paths
	protected static final String QUERY_JSP = "/pages/gas/Ttz/query.jsp";
	protected static final String LIST_JSP= "/pages/gas/Ttz/list.jsp";
	protected static final String QYLIST_JSP= "/pages/gas/Ttz/qylist.jsp";
	protected static final String CREATE_JSP = "/pages/gas/Ttz/create.jsp";
	protected static final String EDIT_JSP = "/pages/gas/Ttz/edit.jsp";
	protected static final String SHOW_JSP = "/pages/gas/Ttz/show.jsp";
	//redirect paths,startWith: !
	protected static final String LIST_ACTION = "!/pages/gas/Ttz/list.do";
	
	private TtzManager ttzManager;
	private TbuylogManager tbuylogManager;
	private TtztbFileManager ttztbFileManager;
	TreeMap<String,String> provMap ;
	
	private Ttz ttz;
	private TtztbFile ttztbFile;
	Long id = null;
	private String[] items;
	private String returnUrl;  //返回列表，保留查询条件
	private TreeMap<String, String> dateSelectMap;// //日期选择
	
	//附件
	private List<File> affixs = new ArrayList<File>();
	private List<String> affixFileNames = new ArrayList<String>();
	private List<String> affixContentTypes = new ArrayList<String>();
	

	public void prepare() throws Exception {
		if (isNullOrEmptyString(id)) {
			ttz = new Ttz();
		} else {
			ttz = (Ttz)ttzManager.getById(id);
			String xfsdw ="";
			if(ttz.getFsdw() != null && !"".equals(ttz.getFsdw())){  //下发指定加油站
				List listcomp = tbuylogManager.findComp( " and '"+ ttz.getFsdw() +"' like '%'|| cpcode || '%'");
				if(listcomp != null && listcomp.size() > 0){
					for(int j = 0; j<listcomp.size(); j++){
						SsDept ssdept = (SsDept) listcomp.get(j);
						if( j == 0){
							xfsdw = ssdept.getDeptname();
						}else{
							xfsdw +=","+ssdept.getDeptname();
						}
					}
				}
				ttz.setFsdw(xfsdw);
			}else if(ttz.getStacode() != null && !"".equals(ttz.getStacode()) && ttz.getBurcode() != null && !"".equals(ttz.getBurcode())){ //下发到派出所辖区下的加油站
				List listcomp = tbuylogManager.findDept( " and  t.CODE=" +ttz.getStacode());
				if(listcomp != null && listcomp.size() > 0){
					for(int j = 0; j<listcomp.size(); j++){
						SsDept ssdept = (SsDept) listcomp.get(j);
							xfsdw = ssdept.getDeptname();
					}
				}
				ttz.setFsdw(xfsdw+"辖区内所有加油站");
				
			}else if(ttz.getBurcode() != null && !"".equals(ttz.getBurcode())){ //下发到分局辖区下的加油站
				List listcomp = tbuylogManager.findDept( "  and  t.CODE="+ ttz.getBurcode());
				if(listcomp != null && listcomp.size() > 0){
					for(int j = 0; j<listcomp.size(); j++){
						SsDept ssdept = (SsDept) listcomp.get(j);
						xfsdw = ssdept.getDeptname();
					}
				}
				ttz.setFsdw(xfsdw+"辖区内所有加油站");
			}else{
				ttz.setFsdw(" 所有加油站");
			}
			
		}
	}
	
	/** 增加setXXXX()方法,spring就可以通过autowire自动设置对象属性 */
	public void setTtzManager(TtzManager manager) {
		this.ttzManager = manager;
	}	
	
	public Object getModel() {
		return ttz;
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
					pageRequest.getFilters().put("userunit", " t.USERUNIT in (select deptid  from SS_DEPT t where t.parentid='"+ buildxh_temp+"' or t.deptid='"+ buildxh_temp+"')");
					provMap.put(buildxh_temp, buildNoName_temp);
				}else if ("3".equals(deptlevel)){
					pageRequest.getFilters().put("userunit",  " t.USERUNIT in ("+ buildxh_temp+")");
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
						provMap.put("", "全部");
					}
				}
				
			}
		}else{
			List listconfig = tbuylogManager.findAllBureau();
			if (listconfig != null && listconfig.size() > 0) {
				for (int i = 0; i < listconfig.size(); i++) {
					SsDept tgas = (SsDept) listconfig.get(i);
					String buildxh_temp = tgas.getDeptcode();
					String buildNoName_temp = tgas.getDeptname();
					provMap.put(buildxh_temp, buildNoName_temp);
					
				}
				provMap.put("", "全部");
			}
		}
		HttpServletRequest request = ServletActionContext.getRequest();
		request.setAttribute("pcscode", pcscode);
		request.setAttribute("pcsname", pcsname);
	}
	
	
	/** 执行搜索 */
	public String list() {
		PageRequest<Map> pageRequest = newPageRequest(DEFAULT_SORT_COLUMNS);
		HttpServletRequest request = ServletActionContext.getRequest();
		//pageRequest.getFilters().put("key",value);     //add custom filter
		 provMap = new TreeMap();
		qyxx(pageRequest);
		dateSelectMap  = DateUtil.getDateSelectData();
		
		String dateSelect19 = "";
		if (request.getParameter("dateSelect19") != null)
		    dateSelect19 = request.getParameter("dateSelect19");
			request.setAttribute("dateSelect19",dateSelect19);	
		
		if (request.getParameter("s_rqBegin") != null){
			String s_rqBeginFormat = DateUtil.parseString(request,"s_rqBegin","yyyy-MM-dd","yyyyMMdd");
			pageRequest.getFilters().put("rqBeginFormat",s_rqBeginFormat);
		}
		if (request.getParameter("s_rqEnd") != null){
			String s_rqEndFormat = DateUtil.parseString(request,"s_rqEnd","yyyy-MM-dd","yyyyMMdd");
			pageRequest.getFilters().put("rqEndFormat",s_rqEndFormat);
		}
		pageRequest.getFilters().put("sortColumns","rq desc");
		
		Page page = ttzManager.findByPageRequest(pageRequest);
		savePage(page,pageRequest);
		return LIST_JSP;
	}
	
	
	/**
	 * 企业端通知管理查询
	 * @return
	 */
	public String qylist() {
		PageRequest<Map> pageRequest = newPageRequest(DEFAULT_SORT_COLUMNS);
		HttpServletRequest request = ServletActionContext.getRequest();
		//pageRequest.getFilters().put("key",value);     //add custom filter
		provMap = new TreeMap();
		qyxx(pageRequest);
		dateSelectMap  = DateUtil.getDateSelectData();
		String dateSelect19 = "";
		if (request.getParameter("dateSelect19") != null)
			dateSelect19 = request.getParameter("dateSelect19");
		request.setAttribute("dateSelect19",dateSelect19);	
		
		if (request.getParameter("s_rqBegin") != null){
			String s_rqBeginFormat = DateUtil.parseString(request,"s_rqBegin","yyyy-MM-dd","yyyyMMdd");
			pageRequest.getFilters().put("rqBeginFormat",s_rqBeginFormat);
		}
		if (request.getParameter("s_rqEnd") != null){
			String s_rqEndFormat = DateUtil.parseString(request,"s_rqEnd","yyyy-MM-dd","yyyyMMdd");
			pageRequest.getFilters().put("rqEndFormat",s_rqEndFormat);
		}
		pageRequest.getFilters().put("sortColumns","rq desc");
		
		MyUserDetails ud = null;
		String code ="";
		SecurityContext sc = SecurityContextHolder.getContext();
		Authentication auth = sc.getAuthentication();
		if ((auth != null) && auth.getPrincipal() instanceof MyUserDetails) {
			ud = (MyUserDetails) auth.getPrincipal();
			if (ud != null) {
				code = ud.getDeptCode().toString();
			}
		}
		pageRequest.getFilters().put("cpcode", code);
		Page page = ttzManager.findByPageRequest(pageRequest);
		savePage(page,pageRequest);
		return QYLIST_JSP;
	}
	
	/** 查看对象*/
	public String show() {
		HttpServletRequest request = ServletActionContext.getRequest();
		String noticeid = "";
		if (request.getParameter("id") != null)
			noticeid = request.getParameter("id");
		if (noticeid != null && noticeid.length() > 0) {
			List listfile = (List) ttztbFileManager.getFile(
					"1", noticeid, "");
			request.setAttribute("listfile", listfile);
		}
		SimpleDateFormat format = new SimpleDateFormat("yyyyMMddHHmmss");
		SimpleDateFormat format1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			try {
				Date dd= format.parse(ttz.getRq().toString());
				ttz.setRq(format1.format(dd));
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		return SHOW_JSP;
	}
	
	/** 进入新增页面*/
	public String create() {
		PageRequest<Map> pageRequest = newPageRequest(DEFAULT_SORT_COLUMNS);
		SimpleDateFormat s = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date date = new Date();
		String xzsj = s.format(date);
		ttz.setRq(xzsj);
		
		provMap = new TreeMap();
		qyxx(pageRequest);
		return CREATE_JSP;
	}
	
	/** 保存新增对象 
	 * @throws IOException */
	public String save() throws IOException {
		HttpServletRequest request = ServletActionContext.getRequest();
		MyUserDetails ud = null;
		String code ="";
		SecurityContext sc = SecurityContextHolder.getContext();
		Authentication auth = sc.getAuthentication();
		if ((auth != null) && auth.getPrincipal() instanceof MyUserDetails) {
			ud = (MyUserDetails) auth.getPrincipal();
			if (ud != null) {
				code = ud.getDeptID().toString();
			}
		}
		String xzsj = DateUtil.parseString(request,"rq","yyyy-MM-dd HH:mm:ss","yyyyMMddHHmmss");
		
		ttz.setRq(xzsj);
		ttz.setUserunit(code);
		if("".equals(ttz.getBurcode()) ){
			ttz.setFsqt("1");
		}
		if(!"".equals(ttz.getFsdw())){
			ttz.setBurcode("");
			ttz.setStacode("");
		}else if(!"".equals(ttz.getStacode() )){
//			ttz.setBurcode("");
		}else {
		}
		
		ttzManager.save(ttz);
		
		if (affixs != null) {
			int j = 0;
			Long fileId =ttztbFileManager.getSeq();
			for (; j < affixs.size(); j++) {
				 boolean uploadLimitSize = true;

				String fileName = affixFileNames.get(j);
				ttztbFile = new TtztbFile();
				ttztbFile.setId(fileId);
				ttztbFile.setFileid(ttz.getId());
				ttztbFile.setTztbtype("1");
				ttztbFile.setFilename(fileName);
				ttztbFileManager.saveFile(affixs.get(j),ttztbFile);
			}
		}
		
		return returnUrl;////LIST_ACTION;
	}
	
	
	private static String getNameWithoutExtension(String fileName) {
		return fileName.substring(0, fileName.lastIndexOf("."));
	}

	private String getExtension(String fileName) {
		return fileName.substring(fileName.lastIndexOf(".") + 1);
	}
	public List<File> getAffix() {
		return this.affixs;
	}

	public void setAffix(List<File> affixs) {
		this.affixs = affixs;
	}

	public List<String> getAffixFileName() {
		return this.affixFileNames;
	}

	public void setAffixFileName(List<String> affixFileNames) {
		this.affixFileNames = affixFileNames;
	}

	public List<String> getAffixContentType() {
		return this.affixContentTypes;
	}

	public void setAffixContentType(List<String> contentTypes) {
		this.affixContentTypes = contentTypes;
	}
	
	/**进入更新页面*/
	public String edit() {
		HttpServletRequest request = ServletActionContext.getRequest();
		return EDIT_JSP;
	}
	
	/**保存更新对象*/
	public String update() {
		HttpServletRequest request = ServletActionContext.getRequest();
		ttzManager.update(this.ttz);
		return returnUrl;////LIST_ACTION;
	}
	
	/**删除对象*/
	public String delete() {
		for(int i = 0; i < items.length; i++) {
			Hashtable params = HttpUtils.parseQueryString(items[i]);
			Long id = new Long((String)params.get("id"));
			ttztbFile = new TtztbFile();
			ttztbFile.setFileid(id);
			ttztbFile.setTztbtype("1");
			ttztbFileManager.removetztbfile(ttztbFile);
			ttzManager.removeById(id);
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

	public void setTtztbFileManager(TtztbFileManager ttztbFileManager) {
		this.ttztbFileManager = ttztbFileManager;
	}

}
