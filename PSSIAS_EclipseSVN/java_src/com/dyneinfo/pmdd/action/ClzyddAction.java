/*
 * Powered By [lishicheng]
 */

package com.dyneinfo.pmdd.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.apache.commons.collections.CollectionUtils;    
import org.apache.commons.io.IOUtils;
import org.apache.commons.lang.StringUtils;

import cn.org.rapid_framework.beanutils.BeanUtils;

import com.opensymphony.xwork2.Preparable;
import com.opensymphony.xwork2.ModelDriven;

import org.security.userdetails.MyUserDetails;
import org.springframework.security.Authentication;
import org.springframework.security.context.SecurityContext;
import org.springframework.security.context.SecurityContextHolder;
import org.springframework.security.GrantedAuthority;

import net.java.dev.common.util.IDCard;
import net.java.dev.common.util.SpringTagFunctions;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
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

import com.dyneinfo.zazh.service.FileAttachManager;
import com.dyneinfo.pmdd.dao.*;
import com.dyneinfo.pmdd.model.*;
import com.dyneinfo.pmdd.service.*;

/**
 * @author lisc email:lishicheng(a)gmail.com
 */


public class ClzyddAction extends BaseStruts2Action implements Preparable,ModelDriven{
	//默认多列排序,example: username desc,createTime asc
	protected static final String DEFAULT_SORT_COLUMNS = null; 

	protected static final String ZHCLSHOW_JSP = "/pages/pmdd/Clzydd/zhclshow.jsp";
	//forward paths
	protected static final String QUERY_JSP = "/pages/pmdd/Clzydd/query.jsp";
	protected static final String LIST_JSP= "/pages/pmdd/Clzydd/list.jsp";
	protected static final String CREATE_JSP = "/pages/pmdd/Clzydd/create.jsp";
	protected static final String EDIT_JSP = "/pages/pmdd/Clzydd/edit.jsp";
	protected static final String SHOW_JSP = "/pages/pmdd/Clzydd/show.jsp";
	//redirect paths,startWith: !
	protected static final String LIST_ACTION = "!/pages/pmdd/Clzydd/list.do";
	
	protected static final String SHOW_PIC = "/pages/pic/pic.jsp";
	protected static final String UPDATEPHOTOSUCCESS = "/pages/pic/uploadFileSuccess.jsp";
	protected static final String UPDATEPHOTOFAILURE= "/pages/pic/uploadFileFailure.jsp";
	protected static final String UPDATEPHOTOERROR = "/pages/pic/updateFileError.jsp";
	
	protected static final String REDEEMLIST_ACTION = "!/pages/pmdd/Clzydd/redeemList.do";
	protected static final String REDEEMLIST_JSP = "/pages/pmdd/Clzydd/redeemList.jsp";
	protected static final String REDEEMEDIT_JSP = "/pages/pmdd/Clzydd/redeemedit.jsp";
	protected static final String REDEEM_SHOW_JSP="/pages/pmdd/Clzydd/redeemshow.jsp";
	
	//系统查询
	protected static final String HTCXLIST_ACTION = "!/pages/pmdd/Clzydd/htcxList.do";
	protected static final String HTCXLIST_JSP = "/pages/pmdd/Clzydd/htcxList.jsp";
	protected static final String HTCXSHOW_JSP = "/pages/pmdd/Clzydd/htcxShow.jsp";
	
	private ClzyddManager clzyddManager;
	private FileAttachPmddManager fileAttachManager;
	private FileAttach fileAttach;
	private PmdwxxbManager pmdwxxbManager;
	
	private Clzydd clzydd;
	java.lang.String id = null;
	private String[] items;
	private String returnUrl;  //返回列表，保留查询条件
	private TreeMap<String, String> dateSelectMap;// //日期选择
	
	// 照片上传 start
	private List<File> upload = new ArrayList<File>();
	private List<String> uploadFileNames = new ArrayList<String>();
	private List<String> uploadContentTypes = new ArrayList<String>();

	private int uplodsSize = 100 * 1024;
	private int affixsSize = 10 * 1024 * 1024;
	
	
	// 照片上传 end

	// 附件
	private List<File> affix = new ArrayList<File>();
	private List<String> affixFileNames = new ArrayList<String>();
	private List<String> affixContentTypes = new ArrayList<String>();

	public List<File> getAffix() {
		return this.affix;
	}

	public void setAffix(List<File> affixs) {
		this.affix = affixs;
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

	// 附件 end
	
	
	//身份证扫描
	private List<File> pic = new ArrayList<File>();
	private List<String> picFileNames = new ArrayList<String>();
	private List<String> picContentTypes = new ArrayList<String>();
	
	public List<File> getPic() {
		return this.pic;
	}

	public void setPic(List<File> pics) {
		this.pic = pics;
	}

	public List<String> getPicFileName() {
		return this.picFileNames;
	}
	public void setPmdwxxbManager(PmdwxxbManager manager) {
		this.pmdwxxbManager = manager;
	}
	public void setPicFileName(List<String> picFileNames) {
		this.picFileNames = picFileNames;
	}

	public List<String> getPicContentType() {
		return this.picContentTypes;
	}

	public void setPicContentType(List<String> picContentTypes) {
		this.picContentTypes = picContentTypes;
	}
	
	

	public void prepare() throws Exception {
		if (isNullOrEmptyString(id)) {
			clzydd = new Clzydd();
		} else {
			clzydd = (Clzydd)clzyddManager.getById(id);
		}
	}
	
	/** 增加setXXXX()方法,spring就可以通过autowire自动设置对象属性 */
	public void setClzyddManager(ClzyddManager manager) {
		this.clzyddManager = manager;
	}	

	public FileAttachPmddManager getFileAttachPmddManager() {
		return fileAttachManager;
	}

	public void setFileAttachPmddManager(FileAttachPmddManager fileAttachManager) {
		this.fileAttachManager = fileAttachManager;
	}

	public FileAttach getFileAttach() {
		return fileAttach;
	}

	public void setFileAttach(FileAttach fileAttach) {
		this.fileAttach = fileAttach;
	}

	public Object getModel() {
		return clzydd;
	}
	
	public void setDnumber(java.lang.String val) {
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
		if(!SpringTagFunctions.ifAnyGranted("ROLE_HT_ADMIN,ROLE_ADMIN,ROLE_QUERY_CHILD_ORG")){
			pageRequest.getFilters().put("deptid",deptid);	
			pageRequest.getFilters().put("deptLength",deptid.length());
		}
		if(SpringTagFunctions.ifAnyGranted("ROLE_QUERY_CHILD_ORG")){
			pageRequest.getFilters().put("chdeptid",deptid);	
		}
		dateSelectMap  = DateUtil.getDateSelectData();
		String dateSelect19 = "";
		if (request.getParameter("dateSelect19") != null)
		    dateSelect19 = request.getParameter("dateSelect19");
			request.setAttribute("dateSelect19",dateSelect19);		        
		String s_ddrqBeginFormat = DateUtil.parseString(request,"s_ddrqBegin","yyyy-MM-dd","yyyyMMdd");
		String s_ddrqEndFormat = DateUtil.parseString(request,"s_ddrqEnd","yyyy-MM-dd","yyyyMMdd");
		pageRequest.getFilters().put("ddrqBeginFormat",s_ddrqBeginFormat+"000000");
		pageRequest.getFilters().put("ddrqEndFormat",s_ddrqEndFormat+"235959");
//		String dateSelect20 = "";
//		if (request.getParameter("dateSelect20") != null)
//		    dateSelect20 = request.getParameter("dateSelect20");
//			request.setAttribute("dateSelect20",dateSelect20);		        
//		String s_lrrqBeginFormat = DateUtil.parseString(request,"s_lrrqBegin","yyyy-MM-dd","yyyyMMdd");
//		String s_lrrqEndFormat = DateUtil.parseString(request,"s_lrrqEnd","yyyy-MM-dd","yyyyMMdd");
//		pageRequest.getFilters().put("lrrqBeginFormat",s_lrrqBeginFormat);
//		pageRequest.getFilters().put("lrrqEndFormat",s_lrrqEndFormat);
		
		//pageRequest.getFilters().put("ddrqEndFormat",s_ddrqEndFormat);
		String query= request.getParameter("query");
		Page page = clzyddManager.findByPageRequest(pageRequest);
		savePage(page,pageRequest);
		
		if(query!=null&&query.equals("true")){
			return QUERY_JSP;
		}
		return LIST_JSP;
	}
	
	/** 查看对象*/
	public String show() {
		HttpServletRequest request = ServletActionContext.getRequest();
		String ddrq =  clzydd.getDdrq();
		String ddrqFormat = DateUtil.parseString(ddrq,"yyyyMMddHHmmss","yyyy-MM-dd HH:mm:ss");
		clzydd.setDdrq(ddrqFormat);
		String lrrq =  clzydd.getLrrq();
		String lrrqFormat = DateUtil.parseString(lrrq,"yyyyMMdd","yyyy-MM-dd");
		clzydd.setLrrq(lrrqFormat);
		return SHOW_JSP;
	}

	/** 进入新增页面*/
	public String create() {
		HttpServletRequest request = ServletActionContext.getRequest();
		SecurityContext sc = SecurityContextHolder.getContext();
		Authentication auth = sc.getAuthentication();
		MyUserDetails ud = null;
		
		String deptid = "";
		
		if ((auth != null) && auth.getPrincipal() instanceof MyUserDetails) {
			ud = (MyUserDetails) auth.getPrincipal();
			if (ud != null) {
	
				deptid = ud.getDeptID();
				
			}
		}
		String smycode = pmdwxxbManager.getsmycode(deptid);
		String typecode = pmdwxxbManager.gettypecode(deptid);
		request.setAttribute("smycode", smycode);
		request.setAttribute("typecode", typecode);
		Date date = new Date();
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String currDate = format.format(date);
		SimpleDateFormat format1 = new SimpleDateFormat("yyyy-MM-dd");
		String currDate1 = format1.format(date);
		clzydd.setLrrq(currDate1);
		clzydd.setDdrq(currDate);
		return CREATE_JSP;
	}
	
	/** 保存新增对象 */
	public String save() {
		HttpServletRequest request = ServletActionContext.getRequest();
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
		String htid ="";
		if(clzydd != null && clzydd.getHtid() != null)
			htid = clzydd.getHtid();
		
		int count = clzyddManager.getFindCountById(htid);
		if(count > 0){
			request.setAttribute("message", "档案编号已存在！");
			return CREATE_JSP;
		}
		clzydd.setSfsh("0");
		
		
		String new_IDCard = "";
		String old_IDCard = "";
		if (clzydd != null && clzydd.getZjhm() != null
				&& clzydd.getZjhm().length() == 15) {
			new_IDCard = IDCard.getNewIDCard(clzydd.getZjhm());
			old_IDCard = clzydd.getZjhm();
		} else if (clzydd != null && clzydd.getZjhm() != null
				&& clzydd.getZjhm().length() == 18) {
			old_IDCard = IDCard.getOldIDCard(clzydd.getZjhm());
			new_IDCard = clzydd.getZjhm();
		} else {
			new_IDCard = clzydd.getZjhm();
			old_IDCard = clzydd.getZjhm();
		}
		clzydd.setZjhm(new_IDCard.toUpperCase());

		Date date = new Date();
		SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd");
		SimpleDateFormat formatoptime = new SimpleDateFormat("yyyyMMddhhmmssSSS");
		String currDate = format.format(date);
		String strOPTIME = formatoptime.format(date);
		clzydd.setOptime(strOPTIME);
		clzydd.setLrrq(currDate);
		String start_char = "", str_emd_char = "";

		String clzydd2 = (String) clzyddManager.getMaxID(deptid, currDate);
		String maxID = "";
		start_char = deptid + currDate;
		String max_end_char = "0000";
		if (clzydd2 != null) {
			maxID = clzydd2;
		}
		if (maxID != null && maxID.length() > 0) {
			max_end_char = maxID.substring(start_char.length());
		}
		int i_max_end_char = Integer.parseInt(max_end_char);
		i_max_end_char = i_max_end_char + 1;
		Integer obj = new Integer(i_max_end_char);
		str_emd_char = net.java.dev.common.dict.taglib.Util.padString(obj.toString(), 4, "0", true);
		String ddrqFormat = DateUtil.parseString(request, "ddrq", "yyyy-MM-dd HH:mm:ss","yyyyMMddHHmmss");
		clzydd.setDdrq(ddrqFormat);
		clzydd.setSqddje(0L);
		
		
		
		
		clzydd.setDnumber(start_char+str_emd_char);
		
		try{
			//判断申请人照片不能大于100KB
			if (upload != null && upload.size() > 0) {
				if (upload.get(0).length() > uplodsSize) {
					request.setAttribute("message", "申请人照片不能大于" + uplodsSize
							/ 1024 + "KB");
					return UPDATEPHOTOERROR;
				}
			}
			//判断当物照片不能大于5M
			if (affix != null && affix.size() > 0) {
				if (affix.get(0).length() > affixsSize) {
					request.setAttribute("message", "当物照片不能大于" + affixsSize
							/ 1024 / 1024 + "M");
					return UPDATEPHOTOERROR;
				}
			}
	
			File uploadFile = null;
			InputStream uploadIs = null;
			byte[] uploadBytes= null;
			if(upload != null && upload.size() > 0 ){
				uploadFile = upload.get(0);
				uploadIs = new FileInputStream(uploadFile);
			    uploadBytes =  (byte[])IOUtils.toByteArray(uploadIs);
			}
			
			String photoBuffer = "";
			if (request.getParameter("photoBuffer") != null)
				photoBuffer = request.getParameter("photoBuffer");
			if (StringUtils.isNotEmpty(photoBuffer)) {
				 uploadBytes = (byte[])net.java.dev.common.util.PicDecode.decode(photoBuffer);
			}
			//当物照片
			File affixFile = null;
			InputStream affixIs = null;
			byte[] affixBytes= null;
			if(affix != null && affix.size() > 0 ){
				affixFile = affix.get(0);
				affixIs = new FileInputStream(affixFile);
				affixBytes =  (byte[])IOUtils.toByteArray(affixIs);
				
			}
			
			String affixfileid = "";
			if (request.getParameter("affixfileid") != null)
				affixfileid = request.getParameter("affixfileid");
			if (StringUtils.isNotEmpty(affixfileid)) {
				List list = (List) fileAttachManager.getFileContent(affixfileid, " and 1=1 ");
				if (list != null && list.size() > 0) {
					for (int i = 0; i < list.size(); i++) {
						Map results = (HashMap) list.get(i);
						affixBytes = (byte[]) results.get("CONTENT");
					}
				}
			}
			//申请人扫描照片
			File picFile = null;
			InputStream picIs = null;
			byte[] picBytes= null;
			if(pic != null && pic.size() > 0 ){
				picFile = pic.get(0);
				picIs = new FileInputStream(picFile);
				picBytes =  (byte[])IOUtils.toByteArray(picIs);	
			}
			
			String picfileid = "";
			if (request.getParameter("picfileid") != null)
				picfileid = request.getParameter("picfileid");
			if (StringUtils.isNotEmpty(picfileid)) {
				List list = (List) fileAttachManager.getFileContent(picfileid, " and  1=1 ");
				if (list != null && list.size() > 0) {
					for (int i = 0; i < list.size(); i++) {
						Map results = (HashMap) list.get(i);
						 picBytes = (byte[]) results.get("CONTENT");
					}
				}
			}
			
			//if (uploadBytes != null  && affixBytes != null && picBytes != null) {
				clzyddManager.savePic(uploadBytes, affixBytes,picBytes, clzydd);
			//} 
			if(picIs != null)
				picIs.close();
			if(uploadIs != null)
				uploadIs.close();
			if(affixIs != null)
				affixIs.close();
			
		} catch(Exception ex){
			ex.printStackTrace();
		}
		
		return returnUrl;////LIST_ACTION;
	}
	
	/**进入更新页面*/
	public String edit() {
		HttpServletRequest request = ServletActionContext.getRequest();
		String ddrq =  clzydd.getDdrq();
		String ddrqFormat = DateUtil.parseString(ddrq,"yyyyMMddHHmmss","yyyy-MM-dd HH:mm:ss");
		clzydd.setDdrq(ddrqFormat);
		String lrrq =  clzydd.getLrrq();
		String lrrqFormat = DateUtil.parseString(lrrq,"yyyyMMdd","yyyy-MM-dd");
		clzydd.setLrrq(lrrqFormat);
		return EDIT_JSP;
	}
	
	/**保存更新对象*/
	public String update() {
		HttpServletRequest request = ServletActionContext.getRequest();
		String ddrqFormat = DateUtil.parseString(request,"ddrq","yyyy-MM-dd HH:mm:ss","yyyyMMddHHmmss");
		clzydd.setDdrq(ddrqFormat);
		String lrrqFormat = DateUtil.parseString(request,"lrrq","yyyy-MM-dd","yyyyMMdd");
		clzydd.setLrrq(lrrqFormat);
		
		
		String new_IDCard = "";
		String old_IDCard = "";
		if (clzydd != null && clzydd.getZjhm() != null
				&& clzydd.getZjhm().length() == 15) {
			new_IDCard = IDCard.getNewIDCard(clzydd.getZjhm());
			old_IDCard = clzydd.getZjhm();
		} else if (clzydd != null && clzydd.getZjhm() != null
				&& clzydd.getZjhm().length() == 18) {
			old_IDCard = IDCard.getOldIDCard(clzydd.getZjhm());
			new_IDCard = clzydd.getZjhm();
		} else {
			new_IDCard = clzydd.getZjhm();
			old_IDCard = clzydd.getZjhm();
		}
		clzydd.setZjhm(new_IDCard.toUpperCase());
		
		
		clzyddManager.update(this.clzydd);
		return returnUrl;////LIST_ACTION;
	}
	
	/**删除对象*/
	public String delete() {
		for(int i = 0; i < items.length; i++) {
			Hashtable params = HttpUtils.parseQueryString(items[i]);
			java.lang.String id = new java.lang.String((String)params.get("dnumber"));
			clzyddManager.removeById(id);
		}
		return returnUrl ;//LIST_ACTION;
	}
	
	
	//显示图片
	public String showPicry() {
		HttpServletRequest request = ServletActionContext.getRequest();
		String xh = "";
		String FlAG = "";
		if (request.getParameter("xh") != null)
			xh = request.getParameter("xh");
		List list = (List) clzyddManager.getPicRy(xh);
		if (list != null) {
			for (int i = 0; i < list.size(); i++) {
				Map results = (HashMap) list.get(i);
				FlAG = (String) results.get("FlAG");
			}
		}
		
			request.setAttribute("list", list);
			return SHOW_PIC;
		
	}
	
	
	public String showPicSmry() {
		HttpServletRequest request = ServletActionContext.getRequest();
		String xh = "";
		String FlAG = "";
		if (request.getParameter("xh") != null)
			xh = request.getParameter("xh");
		List list = (List) clzyddManager.getPicSmRy(xh);
		if (list != null) {
			for (int i = 0; i < list.size(); i++) {
				Map results = (HashMap) list.get(i);
				FlAG = (String) results.get("FlAG");
			}
		}
		
			request.setAttribute("list", list);
			return SHOW_PIC;
		
	}

	public String showPicdw() {
		HttpServletRequest request = ServletActionContext.getRequest();
		String xh = "";
		String FlAG = "";
		if (request.getParameter("xh") != null)
			xh = request.getParameter("xh");
		List list = (List) clzyddManager.getPicDw(xh);
		if (list != null) {
			for (int i = 0; i < list.size(); i++) {
				Map results = (HashMap) list.get(i);
				FlAG = (String) results.get("FlAG");
			}
		}
		
			request.setAttribute("list", list);
			return SHOW_PIC;
		
	}
	
	
	public String picEdit() throws IOException {
	      HttpServletRequest request = ServletActionContext.getRequest();
			
			String dnumber = "";
		    if(request.getParameter("dnumber") != null)
		    	dnumber = request.getParameter("dnumber");
		    
			//当物照片
			File uploadFile = null;
			InputStream uploadIs = null;
			byte[] uploadBytes= null;
			if(upload != null && upload.size() > 0 ){
				uploadFile = upload.get(0);
				uploadIs = new FileInputStream(uploadFile);
				uploadBytes =  (byte[])IOUtils.toByteArray(uploadIs);
				
			}
			
			String uploadfileid = "";
			if (request.getParameter("uploadfileid") != null)
				uploadfileid = request.getParameter("uploadfileid");
			if (StringUtils.isNotEmpty(uploadfileid)) {
				List list = (List) fileAttachManager.getFileContent(uploadfileid, " and 1=1 ");
				if (list != null && list.size() > 0) {
					for (int i = 0; i < list.size(); i++) {
						Map results = (HashMap) list.get(i);
						uploadBytes = (byte[]) results.get("CONTENT");
					}
				}
			}
			clzyddManager.updatePicRy(uploadBytes, dnumber);
			if(uploadIs != null)
				uploadIs.close();
		   
//		    int i = 0;
//			for (File u : uploads) {
//				Integer obj = new Integer(i);
//				String str_ojb = obj.toString();
//				if(u.length( )> uplodsSize){
//					request.setAttribute("message", "申请人照片不能大于"+uplodsSize/1024+"KB"); 
//					return	UPDATEPHOTOFAILURE ;
//				}
//				clzyddManager.updatePicRy(u, dnumber);
//				i++;
//			}
			return UPDATEPHOTOSUCCESS;
		}
	
	
	public String picSmEdit() throws IOException {
	      HttpServletRequest request = ServletActionContext.getRequest();
			
			String dnumber = "";
		    if(request.getParameter("dnumber") != null)
		    	dnumber = request.getParameter("dnumber");
		    
			
			File uploadFile = null;
			InputStream uploadIs = null;
			byte[] uploadBytes= null;
			if(upload != null && upload.size() > 0 ){
				uploadFile = upload.get(0);
				uploadIs = new FileInputStream(uploadFile);
				uploadBytes =  (byte[])IOUtils.toByteArray(uploadIs);
				
			}
			
			String uploadfileid = "";
			if (request.getParameter("uploadfileid") != null)
				uploadfileid = request.getParameter("uploadfileid");
			if (StringUtils.isNotEmpty(uploadfileid)) {
				List list = (List) fileAttachManager.getFileContent(uploadfileid, " and 1=1 ");
				if (list != null && list.size() > 0) {
					for (int i = 0; i < list.size(); i++) {
						Map results = (HashMap) list.get(i);
						uploadBytes = (byte[]) results.get("CONTENT");
					}
				}
			}
			clzyddManager.updatePicSmRy(uploadBytes, dnumber);
			if(uploadIs != null)
				uploadIs.close();
		   
//		    int i = 0;
//			for (File u : uploads) {
//				Integer obj = new Integer(i);
//				String str_ojb = obj.toString();
//				if(u.length( )> uplodsSize){
//					request.setAttribute("message", "申请人照片不能大于"+uplodsSize/1024+"KB"); 
//					return	UPDATEPHOTOFAILURE ;
//				}
//				clzyddManager.updatePicSmRy(u, dnumber);
//				i++;
//			}
			return UPDATEPHOTOSUCCESS;
		}
	
	public String picEditdw() throws IOException {
	      HttpServletRequest request = ServletActionContext.getRequest();
			
			String dnumber = "";
		    if(request.getParameter("dnumber") != null)
		    	dnumber = request.getParameter("dnumber");
		    
			File uploadFile = null;
			InputStream uploadIs = null;
			byte[] uploadBytes= null;
			if(upload != null && upload.size() > 0 ){
				uploadFile = upload.get(0);
				uploadIs = new FileInputStream(uploadFile);
				uploadBytes =  (byte[])IOUtils.toByteArray(uploadIs);
				
			}
			
			String uploadfileid = "";
			if (request.getParameter("uploadfileid") != null)
				uploadfileid = request.getParameter("uploadfileid");
			if (StringUtils.isNotEmpty(uploadfileid)) {
				List list = (List) fileAttachManager.getFileContent(uploadfileid, " and 1=1 ");
				if (list != null && list.size() > 0) {
					for (int i = 0; i < list.size(); i++) {
						Map results = (HashMap) list.get(i);
						uploadBytes = (byte[]) results.get("CONTENT");
					}
				}
			}
			clzyddManager.updatePicDw(uploadBytes, dnumber);
			if(uploadIs != null)
				uploadIs.close();
		   
//		    int i = 0;
//			for (File u : uploads) {
//				Integer obj = new Integer(i);
//				String str_ojb = obj.toString();
//				if(u.length( )> affixsSize){
//					request.setAttribute("message", "当物照片不能大于"+affixsSize/1024/1024+"M"); 
//					return	UPDATEPHOTOFAILURE ;
//				}
//				clzyddManager.updatePicDw(u, dnumber);
//				i++;
//			}
			return UPDATEPHOTOSUCCESS;
		}
	
	
	/** 执行搜索 */
	public String redeemList() {
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
		if(!SpringTagFunctions.ifAnyGranted("ROLE_HT_ADMIN,ROLE_ADMIN,ROLE_QUERY_CHILD_ORG")){
			pageRequest.getFilters().put("deptid",deptid);	
			pageRequest.getFilters().put("deptLength",deptid.length());
		}
		if(SpringTagFunctions.ifAnyGranted("ROLE_QUERY_CHILD_ORG")){
			pageRequest.getFilters().put("chdeptid",deptid);	
		}
		pageRequest.getFilters().put("ddlx","2");
		dateSelectMap  = DateUtil.getDateSelectData();
		String dateSelect19 = "";
		if (request.getParameter("dateSelect19") != null)
		    dateSelect19 = request.getParameter("dateSelect19");
			request.setAttribute("dateSelect19",dateSelect19);		        
		String s_ddrqBeginFormat = DateUtil.parseString(request,"s_ddrqBegin","yyyy-MM-dd","yyyyMMdd");
		String s_ddrqEndFormat = DateUtil.parseString(request,"s_ddrqEnd","yyyy-MM-dd","yyyyMMdd");
		pageRequest.getFilters().put("ddrqBeginFormat",s_ddrqBeginFormat+"000000");
		pageRequest.getFilters().put("ddrqEndFormat",s_ddrqEndFormat+"235959");

		
		Page page = clzyddManager.findByPageRequest(pageRequest);
		savePage(page,pageRequest);
		return REDEEMLIST_JSP;
	}
	
	/**进入更新页面*/
	public String redeemEdit() {
		HttpServletRequest request = ServletActionContext.getRequest();
		String ddrq =  clzydd.getDdrq();
		String ddrqFormat = DateUtil.parseString(ddrq,"yyyyMMddHHmmss","yyyy-MM-dd HH:mm:ss");
		clzydd.setDdrq(ddrqFormat);
		String lrrq =  clzydd.getLrrq();
		String lrrqFormat = DateUtil.parseString(lrrq,"yyyyMMdd","yyyy-MM-dd");
		clzydd.setLrrq(lrrqFormat);
		return REDEEMEDIT_JSP;
	}
	/** 查看赎回对象*/
	public String redeemShow() {
		HttpServletRequest request = ServletActionContext.getRequest();
		String ddrq =  clzydd.getDdrq();
		String ddrqFormat = DateUtil.parseString(ddrq,"yyyyMMdd","yyyy-MM-dd");
		clzydd.setDdrq(ddrqFormat);
		String lrrq =  clzydd.getLrrq();
		String lrrqFormat = DateUtil.parseString(lrrq,"yyyyMMdd","yyyy-MM-dd");
		clzydd.setLrrq(lrrqFormat);
		return REDEEM_SHOW_JSP;
	}
	/** 后台查询 */
	public String htcxList() {
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
		if(!SpringTagFunctions.ifAnyGranted("ROLE_HT_ADMIN,ROLE_ADMIN,ROLE_QUERY_CHILD_ORG")){
			pageRequest.getFilters().put("deptid",deptid);	
			pageRequest.getFilters().put("deptLength",deptid.length());
		}
		if(SpringTagFunctions.ifAnyGranted("ROLE_QUERY_CHILD_ORG")){
			pageRequest.getFilters().put("chdeptid",deptid);	
		}
		
		if(SpringTagFunctions.ifAnyGranted("ROLE_HT_ADMIN")){
			pageRequest.getFilters().put("chdeptid", deptid);
		}
		
//		pageRequest.getFilters().put("ddlx","2");
		dateSelectMap  = DateUtil.getDateSelectData();
		String dateSelect19 = "";
		if (request.getParameter("dateSelect19") != null)
		    dateSelect19 = request.getParameter("dateSelect19");
			request.setAttribute("dateSelect19",dateSelect19);		        
		String s_ddrqBeginFormat = DateUtil.parseString(request,"s_ddrqBegin","yyyy-MM-dd","yyyyMMdd");
		String s_ddrqEndFormat = DateUtil.parseString(request,"s_ddrqEnd","yyyy-MM-dd","yyyyMMdd");
		pageRequest.getFilters().put("ddrqBeginFormat",s_ddrqBeginFormat+"000000");
		pageRequest.getFilters().put("ddrqEndFormat",s_ddrqEndFormat+"235959");
		

		Page page = clzyddManager.findByPageRequest(pageRequest);
		

		savePage(page,pageRequest);
		return HTCXLIST_JSP;
	}
	
	/**进入更新页面*/
	public String  zhclshow() {
		HttpServletRequest request = ServletActionContext.getRequest();
		if(clzydd == null){
			clzydd = new Clzydd();
		}else{
		String ddrq =  clzydd.getDdrq();
		String ddrqFormat = DateUtil
		.parseString(ddrq, "yyyyMMddHHmmss", "yyyy-MM-dd HH:mm:ss");
		clzydd.setDdrq(ddrqFormat);
		String lrrq =  clzydd.getLrrq();
		String lrrqFormat = DateUtil.parseString(lrrq,"yyyyMMdd","yyyy-MM-dd");
		clzydd.setLrrq(lrrqFormat);
		}
		return ZHCLSHOW_JSP;
	}
	
	public String htcxShow() {
		HttpServletRequest request = ServletActionContext.getRequest();
		if(clzydd == null){
			clzydd = new Clzydd();
		}else{
		String ddrq =  clzydd.getDdrq();
		String ddrqFormat = DateUtil
		.parseString(ddrq, "yyyyMMddHHmmss", "yyyy-MM-dd HH:mm:ss");
		clzydd.setDdrq(ddrqFormat);
		String lrrq =  clzydd.getLrrq();
		String lrrqFormat = DateUtil.parseString(lrrq,"yyyyMMdd","yyyy-MM-dd");
		clzydd.setLrrq(lrrqFormat);
		}
		return HTCXSHOW_JSP;
	}
	
	public List<File> getUpload() {
		return this.upload;
	}

	public void setUpload(List<File> uploads) {
		this.upload = uploads;
	}

	public List<String> getUploadFileName() {
		return this.uploadFileNames;
	}

	public void setUploadFileName(List<String> uploadFileNames) {
		this.uploadFileNames = uploadFileNames;
	}

	public List<String> getUploadContentType() {
		return this.uploadContentTypes;
	}

	public void setUploadContentType(List<String> contentTypes) {
		this.uploadContentTypes = contentTypes;
	}

}
