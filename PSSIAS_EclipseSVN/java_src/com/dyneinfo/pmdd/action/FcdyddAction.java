/*
 * Powered By [lishicheng]
 */

package com.dyneinfo.pmdd.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import cn.org.rapid_framework.beanutils.BeanUtils;
import com.opensymphony.xwork2.Preparable;
import com.opensymphony.xwork2.ModelDriven;
import org.security.userdetails.MyUserDetails;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.security.Authentication;
import org.springframework.security.context.SecurityContext;
import org.springframework.security.context.SecurityContextHolder;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import net.java.dev.common.util.DateUtil;
import net.java.dev.common.util.SpringTagFunctions;
import org.apache.commons.io.IOUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.struts2.ServletActionContext;
import java.util.*;
import javacommon.base.*;
import javacommon.util.*;
import cn.org.rapid_framework.util.*;
import cn.org.rapid_framework.web.util.*;
import cn.org.rapid_framework.page.*;
import cn.org.rapid_framework.page.impl.*;
import com.dyneinfo.pmdd.dao.*;
import com.dyneinfo.pmdd.model.*;
import com.dyneinfo.pmdd.service.*;
import net.java.dev.common.util.IDCard;

/**
 * @author lisc email:lishicheng(a)gmail.com
 */


public class FcdyddAction extends BaseStruts2Action implements Preparable,ModelDriven{
	//默认多列排序,example: username desc,createTime asc
	protected static final String DEFAULT_SORT_COLUMNS = null; 
	
	//forward paths
	protected static final String QUERY_JSP = "/pages/pmdd/Fcdydd/query.jsp";
	protected static final String LIST_JSP= "/pages/pmdd/Fcdydd/list.jsp";
	protected static final String CREATE_JSP = "/pages/pmdd/Fcdydd/create.jsp";
	protected static final String EDIT_JSP = "/pages/pmdd/Fcdydd/edit.jsp";
	protected static final String SHOW_JSP = "/pages/pmdd/Fcdydd/show.jsp";
	//redirect paths,startWith: !
	protected static final String LIST_ACTION = "!/pages/pmdd/Fcdydd/list.do";
	
	protected static final String ZHFCSHOW_JSP = "/pages/pmdd/Fcdydd/zhfcshow.jsp";
	
	protected static final String REDEEMLIST_ACTION = "!/pages/pmdd/Fcdydd/redeemList.do";
	protected static final String REDEEMLIST_JSP = "/pages/pmdd/Fcdydd/redeemList.jsp";
	protected static final String REDEEMEDIT_JSP = "/pages/pmdd/Fcdydd/redeemedit.jsp";
	protected static final String REDEEM_SHOW_JSP="/pages/pmdd/Fcdydd/redeemshow.jsp";
	
	//后台查询
	protected static final String HTCXLIST_ACTION = "!/pages/pmdd/Fcdydd/htcxList.do";
	protected static final String HTCXLIST_JSP = "/pages/pmdd/Fcdydd/htcxList.jsp";
	protected static final String HTCXSHOW_JSP = "/pages/pmdd/Fcdydd/htcxShow.jsp";
	
	protected static final String SHOW_PIC = "/pages/pic/pic.jsp";
	protected static final String UPDATEPHOTOSUCCESS = "/pages/pic/uploadFileSuccess.jsp";
	protected static final String UPDATEPHOTOFAILURE= "/pages/pic/uploadFileFailure.jsp";
	protected static final String UPDATEPHOTOERROR="/pages/pic/updateFileError.jsp";
	
	private FileAttachPmddManager fileAttachManager;
	private FileAttach fileAttach;
	
	private FcdyddManager fcdyddManager;
	private PmdwxxbManager pmdwxxbManager;
	
	private Fcdydd fcdydd;
	java.lang.String id = null;
	private String[] items;
	private String returnUrl;  //返回列表，保留查询条件
	private TreeMap<String, String> dateSelectMap;// //日期选择
	
	// 照片上传 start
	private List<File> upload = new ArrayList<File>();
	private List<String> uploadFileNames = new ArrayList<String>();
	private List<String> uploadContentTypes = new ArrayList<String>();
	
	
	//身份证扫描
	private List<File> pic = new ArrayList<File>();
	private List<String> picFileNames = new ArrayList<String>();
	private List<String> picContentTypes = new ArrayList<String>();
	
	// 附件
	private List<File> affix = new ArrayList<File>();
	private List<String> affixFileNames = new ArrayList<String>();
	private List<String> affixContentTypes = new ArrayList<String>();
	
	private int updatesMaxSize=100*1024;
	public void setPmdwxxbManager(PmdwxxbManager manager) {
		this.pmdwxxbManager = manager;
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

	// 照片上传 end
	
	
	public List<File> getPic() {
		return this.pic;
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
	public void setPic(List<File> pics) {
		this.pic = pics;
	}

	public List<String> getPicFileName() {
		return this.picFileNames;
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

	public void prepare() throws Exception {
		if (isNullOrEmptyString(id)) {
			fcdydd = new Fcdydd();
		} else {
			fcdydd = (Fcdydd)fcdyddManager.getById(id);
		}
	}
	
	/** 增加setXXXX()方法,spring就可以通过autowire自动设置对象属性 */
	public void setFcdyddManager(FcdyddManager manager) {
		this.fcdyddManager = manager;
	}	

	public Object getModel() {
		return fcdydd;
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
		String dateSelect18 = "";
		if (request.getParameter("dateSelect18") != null)
		    dateSelect18 = request.getParameter("dateSelect18");
			request.setAttribute("dateSelect18",dateSelect18);		        
		String s_ddrqBeginFormat = DateUtil.parseString(request,"s_ddrqBegin","yyyy-MM-dd","yyyyMMdd");
		String s_ddrqEndFormat = DateUtil.parseString(request,"s_ddrqEnd","yyyy-MM-dd","yyyyMMdd");
		pageRequest.getFilters().put("ddrqBeginFormat",s_ddrqBeginFormat+"000000");
		pageRequest.getFilters().put("ddrqEndFormat",s_ddrqEndFormat+"235959");

		//pageRequest.getFilters().put("ddrqEndFormat",s_ddrqEndFormat);
		String query= request.getParameter("query");
		Page page = fcdyddManager.findByPageRequest(pageRequest);
		savePage(page,pageRequest);
		
		if(query!=null&&query.equals("true")){
			return QUERY_JSP;
		}
		return LIST_JSP;
	}
	
	/** 查看对象*/
	public String show() {
		HttpServletRequest request = ServletActionContext.getRequest();
		String ddrq =  fcdydd.getDdrq();
		String ddrqFormat = DateUtil.parseString(ddrq,"yyyyMMddHHmmss","yyyy-MM-dd HH:mm:ss");
		fcdydd.setDdrq(ddrqFormat);
		String lrrq =  fcdydd.getLrrq();
		String lrrqFormat = DateUtil.parseString(lrrq,"yyyyMMdd","yyyy-MM-dd");
		fcdydd.setLrrq(lrrqFormat);
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
		fcdydd.setLrrq(currDate1);
		fcdydd.setDdrq(currDate);
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
		fcdydd.setSfsh("0");
		
		String new_IDCard = "";
		String old_IDCard = "";
		if (fcdydd != null && fcdydd.getZjhm() != null
				&& fcdydd.getZjhm().length() == 15) {
			new_IDCard = IDCard.getNewIDCard(fcdydd.getZjhm());
			old_IDCard = fcdydd.getZjhm();
		} else if (fcdydd != null && fcdydd.getZjhm() != null
				&& fcdydd.getZjhm().length() == 18) {
			old_IDCard = IDCard.getOldIDCard(fcdydd.getZjhm());
			new_IDCard = fcdydd.getZjhm();
		} else {
			new_IDCard = fcdydd.getZjhm();
			old_IDCard = fcdydd.getZjhm();
		}
		fcdydd.setZjhm(new_IDCard.toUpperCase());
		
		String htid ="";
		if(fcdydd != null && fcdydd.getHtid() != null)
			htid = fcdydd.getHtid();
		
		int count = fcdyddManager.getFindCountById(htid);
		if(count > 0){
			request.setAttribute("message", "档案编号已存在！");
			return CREATE_JSP;
		}

		Date date = new Date();
		SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd");
		SimpleDateFormat formatoptime = new SimpleDateFormat("yyyyMMddhhmmssSSS");
		String currDate = format.format(date);
		String strOPTIME = formatoptime.format(date);
		fcdydd.setOptime(strOPTIME);
		fcdydd.setLrrq(currDate);
		String start_char = "", str_emd_char = "";

		Fcdydd fcdydd2 = (Fcdydd) fcdyddManager.getMaxID(deptid, currDate);
		String maxID = "";
		start_char = deptid + currDate;
		String max_end_char = "0000";
		if (fcdydd2 != null) {
			maxID = fcdydd2.getDnumber();
			
		}
		if (maxID != null && maxID.length() > 0) {
			max_end_char = maxID.substring(start_char.length());
		}
		int i_max_end_char = Integer.parseInt(max_end_char);
		i_max_end_char = i_max_end_char + 1;
		Integer obj = new Integer(i_max_end_char);
		str_emd_char = net.java.dev.common.dict.taglib.Util.padString(obj.toString(), 4, "0", true);
		String ddrqFormat = DateUtil.parseString(request, "ddrq", "yyyy-MM-dd HH:mm:ss","yyyyMMddHHmmss");
		fcdydd.setDdrq(ddrqFormat);
		fcdydd.setSqddje(0L);
		fcdydd.setDnumber(start_char+str_emd_char);
		
		try {
			if (upload != null && upload.size() > 0) {
					if (upload.get(0).length() > updatesMaxSize) {
						request.setAttribute("message", "申请人照片不能大于"+updatesMaxSize/1024+"KB"); 
						return	UPDATEPHOTOERROR ;
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
				fcdyddManager.savePic(uploadBytes, affixBytes,picBytes, fcdydd);
		//	} 
			if(picIs != null)
				picIs.close();
			if(uploadIs != null)
				uploadIs.close();
			if(affixIs != null)
				affixIs.close();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return returnUrl;////LIST_ACTION;
	}
	
	/**进入更新页面*/
	public String edit() {
		HttpServletRequest request = ServletActionContext.getRequest();
		String ddrq =  fcdydd.getDdrq();
		String ddrqFormat = DateUtil.parseString(ddrq,"yyyyMMddHHmmss","yyyy-MM-dd HH:mm:ss");
		fcdydd.setDdrq(ddrqFormat);
		String lrrq =  fcdydd.getLrrq();
		String lrrqFormat = DateUtil.parseString(lrrq,"yyyyMMdd","yyyy-MM-dd");
		fcdydd.setLrrq(lrrqFormat);
		return EDIT_JSP;
	}
	
	/**保存更新对象*/
	public String update() {
		HttpServletRequest request = ServletActionContext.getRequest();
		String ddrqFormat = DateUtil.parseString(request,"ddrq","yyyy-MM-dd HH:mm:ss","yyyyMMddHHmmss");
		fcdydd.setDdrq(ddrqFormat);
		String lrrqFormat = DateUtil.parseString(request,"lrrq","yyyy-MM-dd","yyyyMMdd");
		fcdydd.setLrrq(lrrqFormat);
		
		
		String new_IDCard = "";
		String old_IDCard = "";
		if (fcdydd != null && fcdydd.getZjhm() != null
				&& fcdydd.getZjhm().length() == 15) {
			new_IDCard = IDCard.getNewIDCard(fcdydd.getZjhm());
			old_IDCard = fcdydd.getZjhm();
		} else if (fcdydd != null && fcdydd.getZjhm() != null
				&& fcdydd.getZjhm().length() == 18) {
			old_IDCard = IDCard.getOldIDCard(fcdydd.getZjhm());
			new_IDCard = fcdydd.getZjhm();
		} else {
			new_IDCard = fcdydd.getZjhm();
			old_IDCard = fcdydd.getZjhm();
		}
		fcdydd.setZjhm(new_IDCard.toUpperCase());
		
		fcdyddManager.update(this.fcdydd);
		return returnUrl;////LIST_ACTION;
	}
	
	/**删除对象*/
	public String delete() {
		for(int i = 0; i < items.length; i++) {
			Hashtable params = HttpUtils.parseQueryString(items[i]);
			java.lang.String id = new java.lang.String((String)params.get("dnumber"));
			fcdyddManager.removeById(id);
		}
		return returnUrl ;//LIST_ACTION;
	}
	
	
	public String showPic() {
		HttpServletRequest request = ServletActionContext.getRequest();
		String xh = "";
		String FlAG = "";
		if (request.getParameter("xh") != null)
			xh = request.getParameter("xh");
		List list = (List) fcdyddManager.getPic(xh);
		if (list != null) {
			for (int i = 0; i < list.size(); i++) {
				Map results = (HashMap) list.get(i);
				FlAG = (String) results.get("FlAG");
			}
		}
		
			request.setAttribute("list", list);
			return SHOW_PIC;
		
	}
	
	// 显示图片
	public String getPicture() {
		HttpServletRequest request = ServletActionContext.getRequest();
		String sql = request.getParameter("sql");
		if (sql != null && !sql .equals("")){
			List list = (List) fcdyddManager.getPicture(sql);
			request.setAttribute("list", list);
		}
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
			fcdyddManager.updatePic(uploadBytes, dnumber);
			if(uploadIs != null)
				uploadIs.close();
			
		   
//		    int i = 0;
//			for (File u : uploads) {
//				Integer obj = new Integer(i);
//				String str_ojb = obj.toString();
//				if(u.length( )> updatesMaxSize){
//					request.setAttribute("message", "申请人照片不能大于"+updatesMaxSize/1024+"KB"); 
//					return	UPDATEPHOTOFAILURE ;
//				}
//				fcdyddManager.updatePic(u, dnumber);
//				i++;
//			}
			return UPDATEPHOTOSUCCESS;
		}
	
	
	
	
	public String showSmPic() {
		HttpServletRequest request = ServletActionContext.getRequest();
		String xh = "";
		String FlAG = "";
		if (request.getParameter("xh") != null)
			xh = request.getParameter("xh");
		List list = (List) fcdyddManager.getSmPic(xh);
		if (list != null) {
			for (int i = 0; i < list.size(); i++) {
				Map results = (HashMap) list.get(i);
				FlAG = (String) results.get("FlAG");
			}
		}
		
			request.setAttribute("list", list);
			return SHOW_PIC;
		
	}
	
	
	public String picSmEdit() throws IOException {
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
			fcdyddManager.updateSmPic(uploadBytes, dnumber);
			if(uploadIs != null)
				uploadIs.close();
		   
//		    int i = 0;
//			for (File u : uploads) {
//				Integer obj = new Integer(i);
//				String str_ojb = obj.toString();
//				if(u.length( )> updatesMaxSize){
//					request.setAttribute("message", "申请人照片不能大于"+updatesMaxSize/1024+"KB"); 
//					return	UPDATEPHOTOFAILURE ;
//				}
//				fcdyddManager.updateSmPic(u, dnumber);
//				i++;
//			}
			return UPDATEPHOTOSUCCESS;
		}
	
	
	
	public String showDwPic() {
		HttpServletRequest request = ServletActionContext.getRequest();
		String xh = "";
		String FlAG = "";
		if (request.getParameter("xh") != null)
			xh = request.getParameter("xh");
		List list = (List) fcdyddManager.getDwPic(xh);
		if (list != null) {
			for (int i = 0; i < list.size(); i++) {
				Map results = (HashMap) list.get(i);
				FlAG = (String) results.get("FlAG");
			}
		}
		
			request.setAttribute("list", list);
			return SHOW_PIC;
		
	}
	
	
	public String picDwEdit() throws IOException {
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
			fcdyddManager.updateDwPic(uploadBytes, dnumber);
			if(uploadIs != null)
				uploadIs.close();
//		   
//		    int i = 0;
//			for (File u : uploads) {
//				Integer obj = new Integer(i);
//				String str_ojb = obj.toString();
//				if(u.length( )> updatesMaxSize){
//					request.setAttribute("message", "申请人照片不能大于"+updatesMaxSize/1024+"KB"); 
//					return	UPDATEPHOTOFAILURE ;
//				}
//				fcdyddManager.updateDwPic(u, dnumber);
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

		dateSelectMap  = DateUtil.getDateSelectData();
		String dateSelect18 = "";
		if (request.getParameter("dateSelect18") != null)
		    dateSelect18 = request.getParameter("dateSelect18");
			request.setAttribute("dateSelect18",dateSelect18);		        
		String s_ddrqBeginFormat = DateUtil.parseString(request,"s_ddrqBegin","yyyy-MM-dd","yyyyMMdd");
		String s_ddrqEndFormat = DateUtil.parseString(request,"s_ddrqEnd","yyyy-MM-dd","yyyyMMdd");
		pageRequest.getFilters().put("ddrqBeginFormat",s_ddrqBeginFormat+"000000");
		pageRequest.getFilters().put("ddrqEndFormat",s_ddrqEndFormat+"235959");
		pageRequest.getFilters().put("ddlb", "2");
		
		Page page = fcdyddManager.findByPageRequest(pageRequest);
		savePage(page,pageRequest);
		return REDEEMLIST_JSP;
	}
	
	/**进入更新页面*/
	public String redeemEdit() {
		HttpServletRequest request = ServletActionContext.getRequest();
		String ddrq =  fcdydd.getDdrq();
		String ddrqFormat = DateUtil.parseString(ddrq,"yyyyMMddHHmmss","yyyy-MM-dd HH:mm:ss");
		fcdydd.setDdrq(ddrqFormat);
		String lrrq =  fcdydd.getLrrq();
		String lrrqFormat = DateUtil.parseString(lrrq,"yyyyMMdd","yyyy-MM-dd");
		fcdydd.setLrrq(lrrqFormat);
		return REDEEMEDIT_JSP;
	}
	/** 查看赎回信息 */
	public String redeemShow() {
		HttpServletRequest request = ServletActionContext.getRequest();
		String ddrq =  fcdydd.getDdrq();
		String ddrqFormat = DateUtil.parseString(ddrq,"yyyyMMdd","yyyy-MM-dd");
		fcdydd.setDdrq(ddrqFormat);
		String lrrq =  fcdydd.getLrrq();
		String lrrqFormat = DateUtil.parseString(lrrq,"yyyyMMdd","yyyy-MM-dd");
		fcdydd.setLrrq(lrrqFormat);
		return REDEEM_SHOW_JSP;
	}
	/** 执行搜索 */
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
		dateSelectMap  = DateUtil.getDateSelectData();
		String dateSelect18 = "";
		if (request.getParameter("dateSelect18") != null)
		    dateSelect18 = request.getParameter("dateSelect18");
			request.setAttribute("dateSelect18",dateSelect18);		        
		String s_ddrqBeginFormat = DateUtil.parseString(request,"s_ddrqBegin","yyyy-MM-dd","yyyyMMdd");
		String s_ddrqEndFormat = DateUtil.parseString(request,"s_ddrqEnd","yyyy-MM-dd","yyyyMMdd");
		pageRequest.getFilters().put("ddrqBeginFormat",s_ddrqBeginFormat+"000000");
		pageRequest.getFilters().put("ddrqEndFormat",s_ddrqEndFormat+"235959");
		
		Page page = fcdyddManager.findByPageRequest(pageRequest);
		savePage(page,pageRequest);
		return HTCXLIST_JSP;
	}
	
	/**进入后台查询查看页面*/
	public String htcxShow() {
		HttpServletRequest request = ServletActionContext.getRequest();
		if(fcdydd == null ){
			 fcdydd = new Fcdydd();
		}else{
			String ddrq =  fcdydd.getDdrq();
			String ddrqFormat = DateUtil.parseString(ddrq, "yyyyMMddHHmmss", "yyyy-MM-dd HH:mm:ss");
			fcdydd.setDdrq(ddrqFormat);
			String lrrq =  fcdydd.getLrrq();
			String lrrqFormat = DateUtil.parseString(lrrq,"yyyyMMdd","yyyy-MM-dd");
			fcdydd.setLrrq(lrrqFormat);
		}
		return HTCXSHOW_JSP;
	}
	
	public String zhfcshow() {
		HttpServletRequest request = ServletActionContext.getRequest();
		if(fcdydd == null ){
			 fcdydd = new Fcdydd();
		}else{
			String ddrq =  fcdydd.getDdrq();
			String ddrqFormat = DateUtil.parseString(ddrq, "yyyyMMddHHmmss", "yyyy-MM-dd HH:mm:ss");
			fcdydd.setDdrq(ddrqFormat);
			String lrrq =  fcdydd.getLrrq();
			String lrrqFormat = DateUtil.parseString(lrrq,"yyyyMMdd","yyyy-MM-dd");
			fcdydd.setLrrq(lrrqFormat);
		}
		return ZHFCSHOW_JSP;
	}

}
