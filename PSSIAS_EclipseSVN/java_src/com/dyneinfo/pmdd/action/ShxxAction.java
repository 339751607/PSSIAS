/*
 * Powered By [lishicheng]
 */

package com.dyneinfo.pmdd.action;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import javacommon.base.BaseStruts2Action;

import javax.servlet.http.HttpServletRequest;

import net.java.dev.common.util.DateUtil;
import net.java.dev.common.util.IDCard;
import net.java.dev.common.util.SpringTagFunctions;

import org.apache.commons.io.IOUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.struts2.ServletActionContext;
import org.security.userdetails.MyUserDetails;
import org.springframework.security.Authentication;
import org.springframework.security.context.SecurityContext;
import org.springframework.security.context.SecurityContextHolder;

import cn.org.rapid_framework.page.Page;
import cn.org.rapid_framework.page.PageRequest;
import cn.org.rapid_framework.web.util.HttpUtils;

import com.dyneinfo.zazh.service.FileAttachManager;
import com.dyneinfo.pmdd.model.Shxx;
import com.dyneinfo.pmdd.service.ShxxpmddManager;
import com.opensymphony.xwork2.ModelDriven;
import com.opensymphony.xwork2.Preparable;

/**
 * @author lisc email:lishicheng(a)gmail.com
 */


public class ShxxAction extends BaseStruts2Action implements Preparable,ModelDriven{
	//默认多列排序,example: username desc,createTime asc
	protected static final String DEFAULT_SORT_COLUMNS = null; 
	
	//forward paths
	protected static final String QUERY_JSP = "/pages/pmdd/Shxx/query.jsp";
	protected static final String LIST_JSP= "/pages/pmdd/Shxx/list.jsp";
	protected static final String CREATE_JSP = "/pages/pmdd/Shxx/create.jsp";
	protected static final String EDIT_JSP = "/pages/pmdd/Shxx/edit.jsp";
	protected static final String SHOW_JSP = "/pages/pmdd/Shxx/show.jsp";
	//redirect paths,startWith: !
	protected static final String LIST_ACTION = "!/pages/pmdd/Shxx/list.do";
	
	
	protected static final String REDEEMCREATE_JSP = "/pages/pmdd/Shxx/redeemCreate.jsp";
	protected static final String EDIT_JSPEXT = "/pages/pmdd/Shxx/editExt.jsp";
	protected static final String SHOW_JSPEXT = "/pages/pmdd/Shxx/showExt.jsp";
	
	//后台查询
	protected static final String HTCXLIST_ACTION = "!/pages/pmdd/Shxx/htcxList.do";
	protected static final String HTCXLIST_JSP = "/pages/pmdd/Shxx/htcxList.jsp";
	protected static final String HTCXSHOW_JSP = "/pages/pmdd/Shxx/htcxShow.jsp";
	

	protected static final String SHOW_PIC = "/pages/pic/pic.jsp";
	protected static final String UPDATEPHOTOSUCCESS = "/pages/pic/uploadFileSuccess.jsp";
	protected static final String UPDATEPHOTOFAILURE= "/pages/pic/uploadFileFailure.jsp";
	protected static final String UPDATEPHOTOERROR="/pages/pic/updateFileError.jsp";
	
	private ShxxpmddManager shxxManager;
	private FileAttachManager fileAttachManager;
	
	private Shxx shxx;
	java.lang.String id = null;
	private String[] items;
	private String returnUrl;  //返回列表，保留查询条件
	private TreeMap<String, String> dateSelectMap;// //日期选择
	
	
	// 照片上传 start
	private List<File> uploads = new ArrayList<File>();
	private List<String> uploadFileNames = new ArrayList<String>();
	private List<String> uploadContentTypes = new ArrayList<String>();
	private int updatesMaxSize=3*1024*1024;
	
	public List<File> getUpload() {
		return this.uploads;
	}

	public void setUpload(List<File> uploads) {
		this.uploads = uploads;
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

	public void prepare() throws Exception {
		if (isNullOrEmptyString(id)) {
			shxx = new Shxx();
		} else {
			shxx = (Shxx)shxxManager.getById(id);
		}
	}
	
	/** 增加setXXXX()方法,spring就可以通过autowire自动设置对象属性 */
	public void setShxxpmddManager(ShxxpmddManager manager) {
		this.shxxManager = manager;
	}	
	
	public void setFileAttachManager(FileAttachManager manager) {
		this.fileAttachManager = manager;
	}
	
	
	
	public Object getModel() {
		return shxx;
	}
	
	public void setXh(java.lang.String val) {
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
		String dateSelect7 = "";
		if (request.getParameter("dateSelect7") != null)
		    dateSelect7 = request.getParameter("dateSelect7");
			request.setAttribute("dateSelect7",dateSelect7);		        
		String s_shrqBeginFormat = DateUtil.parseString(request,"s_shrqBegin","yyyy-MM-dd","yyyyMMdd");
		String s_shrqEndFormat = DateUtil.parseString(request,"s_shrqEnd","yyyy-MM-dd","yyyyMMdd");
		pageRequest.getFilters().put("shrqBeginFormat",s_shrqBeginFormat+"000000");
		pageRequest.getFilters().put("shrqEndFormat",s_shrqEndFormat+"235959");
		String dateSelect9 = "";
		if (request.getParameter("dateSelect9") != null)
		    dateSelect9 = request.getParameter("dateSelect9");
			request.setAttribute("dateSelect9",dateSelect9);		        
		String s_lrrqBeginFormat = DateUtil.parseString(request,"s_lrrqBegin","yyyy-MM-dd","yyyyMMdd");
		String s_lrrqEndFormat = DateUtil.parseString(request,"s_lrrqEnd","yyyy-MM-dd","yyyyMMdd");
		pageRequest.getFilters().put("lrrqBeginFormat",s_lrrqBeginFormat);
		pageRequest.getFilters().put("lrrqEndFormat",s_lrrqEndFormat);
		
		String query= request.getParameter("query");
		Page page = shxxManager.findByPageRequest(pageRequest);
		savePage(page,pageRequest);
		
		if(query!=null&&query.equals("true")){
			return QUERY_JSP;
		}
		return LIST_JSP;
	}
	
	/** 查看对象*/
	public String show() {
		HttpServletRequest request = ServletActionContext.getRequest();
		String shrq =  shxx.getShrq();
		String shrqFormat = DateUtil.parseString(shrq, "yyyyMMddHHmmss","yyyy-MM-dd HH:mm:ss");
		shxx.setShrq(shrqFormat);
		String lrrq =  shxx.getLrrq();
		String lrrqFormat = DateUtil.parseString(lrrq,"yyyyMMdd","yyyy-MM-dd");
		shxx.setLrrq(lrrqFormat);
		return SHOW_JSP;
	}
	
	/** 进入新增页面*/
	public String create() {
		return CREATE_JSP;
	}
	
	/** 保存新增对象 */
	public String save() {
		HttpServletRequest request = ServletActionContext.getRequest();
		String shrqFormat = DateUtil.parseString(request,"shrq","yyyy-MM-dd HH:mm:ss","yyyyMMddHHmmss");
		shxx.setShrq(shrqFormat);
		String lrrqFormat = DateUtil.parseString(request,"lrrq","yyyy-MM-dd","yyyyMMdd");
		shxx.setLrrq(lrrqFormat);
		shxxManager.save(shxx);
		return returnUrl;////LIST_ACTION;
	}
	
	/**进入更新页面*/
	public String edit() {
		HttpServletRequest request = ServletActionContext.getRequest();
		String shrq =  shxx.getShrq();
		String shrqFormat = DateUtil.parseString(request,"shrq","yyyy-MM-dd HH:mm:ss","yyyyMMddHHmmss");
		shxx.setShrq(shrqFormat);
		String lrrq =  shxx.getLrrq();
		String lrrqFormat = DateUtil.parseString(lrrq,"yyyyMMdd","yyyy-MM-dd");
		shxx.setLrrq(lrrqFormat);
		return EDIT_JSP;
	}
	
	/**保存更新对象*/
	public String update() {
		HttpServletRequest request = ServletActionContext.getRequest();
		String shrqFormat = DateUtil.parseString(request,"shrq","yyyy-MM-dd HH:mm:ss","yyyyMMddHHmmss");
		shxx.setShrq(shrqFormat);
		String lrrqFormat = DateUtil.parseString(request,"lrrq","yyyy-MM-dd","yyyyMMdd");
		shxx.setLrrq(lrrqFormat);
		shxxManager.update(this.shxx);
		return returnUrl;////LIST_ACTION;
	}
	
	/**删除对象*/
	public String delete() {
		for(int i = 0; i < items.length; i++) {
			Hashtable params = HttpUtils.parseQueryString(items[i]);
			java.lang.String id = new java.lang.String((String)params.get("xh"));
			shxxManager.removeById(id);
		}
		return returnUrl ;//LIST_ACTION;
	}
	
	
	public String redeem() {
		HttpServletRequest request = ServletActionContext.getRequest();
		String dnumber = "";
		String type = "";
		String sql = "";
		List list = null;
		String dw="dwms";
		if (request.getParameter("dnumber") != null) {
			dnumber = request.getParameter("dnumber");
		}
		if (request.getParameter("type") != null) {
			type = request.getParameter("type");
			if (type != null && type.equals("D")) {
				sql = "select  HTID,DWMC,SQR,ZJHM,LXDH,GZDW,YXZJ from DCZYDDXXB where D_NUMBER = '"+ dnumber + "'";
				dw="dwmc";
			} else if (type != null && type.equals("F")) {
				sql = "select  HTID,DWMS,SQR,ZJHM,LXDH,GZDW,YXZJ  from fcdyddxxb where D_NUMBER = '"+ dnumber + "'";

			} else if (type != null && type.equals("C")) {
				sql = "select  HTID,DWMS,SQR,ZJHM,LXDH,GZDW,YXZJ from clzyddxxb where D_NUMBER = '" + dnumber + "'";

			}
			list = (List) shxxManager.getDwxx(sql);
		}
		String htid = "", dwmc = "",sqr="",zjhm="",lxdh="",gzdw="",yxzj=""; 
		if (list != null) {
			for (int i = 0; i < list.size(); i++) {
				Map results = (Map) list.get(i);
				htid = (String) results.get("HTID");
				dwmc = (String) results.get(dw);
				sqr=(String) results.get("SQR");
				zjhm=(String) results.get("ZJHM");
				lxdh=(String) results.get("LXDH");
				gzdw=(String) results.get("GZDW");
				yxzj=(String )results.get("YXZJ");
			}
		}
		Date date = new Date();
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String currDate = format.format(date);
		shxx.setLrrq(currDate);
		shxx.setShrq(currDate);
		shxx.setDnumber(dnumber);
		shxx.setYxzj(yxzj);
		shxx.setFlag(type);
		shxx.setHtid(htid);
		shxx.setGzdw(gzdw);
		shxx.setLxdh(lxdh);
		shxx.setShrsfzhm(zjhm);
		shxx.setShrxm(sqr);
		request.setAttribute("dwmc", dwmc);
		request.setAttribute("type", type);
		return REDEEMCREATE_JSP;
	}
	
	public String redeemsave() {
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
		String dnumber = "";
		if (request.getParameter("dnumber") != null) {
			dnumber = request.getParameter("dnumber");
		}
		int count = 0;
		String flag = "";
		String sql = "";
		if (request.getParameter("flag") != null) {
			flag = request.getParameter("flag");
			if (flag != null && flag.equals("D")) {
				sql = "select  count(XH) from SHXXB where D_NUMBER = '"+ dnumber + "' and flag = 'D'";
				 count = shxxManager.getFindCountById(sql);	
			} else if (flag != null && flag.equals("F")) {
				sql = "select  count(XH)  from SHXXB where D_NUMBER = '"+ dnumber + "' and flag = 'F'";
				 count = shxxManager.getFindCountById(sql);
			} else if (flag != null && flag.equals("C")) {
				sql = "select   count(XH)   from SHXXB where D_NUMBER = '" + dnumber + "' and flag = 'C'";
				 count = shxxManager.getFindCountById(sql);
			} else {

			}
		}
		if(count > 0){
			request.setAttribute("message", "档案编号已存在！");
			return REDEEMCREATE_JSP;
		}
		
		String new_IDCard = "";
		String old_IDCard = "";
		if (shxx != null && shxx.getShrsfzhm() != null
				&& shxx.getShrsfzhm().length() == 15) {
			new_IDCard = IDCard.getNewIDCard(shxx.getShrsfzhm());
			old_IDCard = shxx.getShrsfzhm();
		} else if (shxx != null && shxx.getShrsfzhm() != null
				&& shxx.getShrsfzhm().length() == 18) {
			old_IDCard = IDCard.getOldIDCard(shxx.getShrsfzhm());
			new_IDCard = shxx.getShrsfzhm();
		} else {
			new_IDCard = shxx.getShrsfzhm();
			old_IDCard = shxx.getShrsfzhm();
		}
		shxx.setShrsfzhm(new_IDCard.toUpperCase());

		Date date = new Date();
		SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd");
		SimpleDateFormat formatoptime = new SimpleDateFormat("yyyyMMddhhmmssSSS");
		String currDate = format.format(date);
		String strOPTIME = formatoptime.format(date);
		shxx.setOptime(strOPTIME);
		shxx.setLrrq(currDate);

		String shrqFormat = DateUtil.parseString(request,"shrq","yyyy-MM-dd HH:mm:ss","yyyyMMddHHmmss");
		shxx.setShrq(shrqFormat);
		
		try {
			
			File uploadFile = null;
			InputStream uploadIs = null;
			byte[] uploadBytes= null;
			if(uploads != null && uploads.size() > 0 ){
				uploadFile = uploads.get(0);
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
			
			if(uploadBytes != null && uploadBytes.length >0){
				Long id = shxxManager.getSeq();
				shxx.setXh(id.toString());
				shxxManager.savePic(uploadBytes, shxx);
			} else {
				shxxManager.save(shxx);
			}
			
			if(uploadIs != null)
				uploadIs.close();
			
			
			
			
//			if (uploads != null && uploads.size() > 0) {
//				if (uploads.get(0).length() > updatesMaxSize) {
//					request.setAttribute("message", "赎回人照片不能大于"+updatesMaxSize/1024/1024+"M"); 
//					return	UPDATEPHOTOFAILURE ;
//				}
//				Long id = shxxManager.getSeq();
//				shxx.setXh(id.toString());
//				shxxManager.savePic(uploads.get(0), shxx);
//			} else {
//				shxxManager.save(shxx);
//			}
			 String updateSql ="";
				if (flag != null && flag.equals("D")) {
					 updateSql = "update DCZYDDXXB set SFSH ='1' where  D_NUMBER=:dnumber";
					 shxxManager.updateFlagShiFouShuHui(updateSql,dnumber);	
				} else if (flag != null && flag.equals("F")) {
					updateSql = "update FCDYDDXXB set SFSH ='1' where  D_NUMBER=:dnumber";
					 shxxManager.updateFlagShiFouShuHui(updateSql,dnumber);	
				} else if (flag != null && flag.equals("C")) {
					updateSql = "update CLZYDDXXB set SFSH ='1' where  D_NUMBER=:dnumber";
					 shxxManager.updateFlagShiFouShuHui(updateSql,dnumber);	
				} else {

				}
		
			
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		
		
		
		return UPDATEPHOTOSUCCESS;////LIST_ACTION;
	}
	
	
	public String showPic() {
		HttpServletRequest request = ServletActionContext.getRequest();
		String dnumber = "";
		String flag = "";
		if (request.getParameter("dnumber") != null)
			dnumber = request.getParameter("dnumber");
		if (request.getParameter("flag") != null)
			flag = request.getParameter("flag");
		List list = (List) shxxManager.getPic(dnumber,flag);
		
		
			request.setAttribute("list", list);
			return SHOW_PIC;
		
	}
	public String showShrPic() {
		HttpServletRequest request = ServletActionContext.getRequest();
		String dnumber = "";
		String flag = "";
		if (request.getParameter("dnumber") != null)
			dnumber = request.getParameter("dnumber");
		if (request.getParameter("flag") != null)
			flag = request.getParameter("flag");
		List list = (List) shxxManager.getShrPic(dnumber,flag);
		
		
			request.setAttribute("list", list);
			return SHOW_PIC;
		
	}
	
	public String picEdit() throws IOException {
	      HttpServletRequest request = ServletActionContext.getRequest();
			
			String dnumber = "", flag = "";
		    if(request.getParameter("dnumber") != null)
		    	dnumber = request.getParameter("dnumber");
		    if (request.getParameter("flag") != null)
				flag = request.getParameter("flag");
		   
		    int i = 0;
			for (File u : uploads) {
				Integer obj = new Integer(i);
				String str_ojb = obj.toString();
				
				if(u.length( )> updatesMaxSize){
					request.setAttribute("message", "申请人照片不能大于"+updatesMaxSize/1024/1024+"M"); 
					return	UPDATEPHOTOFAILURE ;
				}
				shxxManager.updatePic(u, dnumber,flag);
				i++;
			}
			return UPDATEPHOTOSUCCESS;
		}
	
	public String showExt() {
		HttpServletRequest request = ServletActionContext.getRequest();
		String dnumber = "", flag = "";
	    if(request.getParameter("dnumber") != null)
	    	dnumber = request.getParameter("dnumber");
	    if (request.getParameter("type") != null)
			flag = request.getParameter("type");
	      shxx = shxxManager.getShxxById(dnumber, flag);
		
		String shrq = "",lrrq="";
		if(shxx != null){
			shrq =  shxx.getShrq();
		    String shrqFormat = DateUtil.parseString(shrq, "yyyyMMddHHmmss","yyyy-MM-dd HH:mm:ss");
		    shxx.setShrq(shrqFormat);
		    shxx.setDnumber(dnumber);
		}   
		if(shxx != null){
		    lrrq =  shxx.getLrrq();
		    String lrrqFormat = DateUtil.parseString(lrrq,"yyyyMMdd","yyyy-MM-dd");
		    shxx.setLrrq(lrrqFormat);
		}
		return SHOW_JSPEXT;
	}
	
	/**进入更新页面*/
	public String editExt() {
		HttpServletRequest request = ServletActionContext.getRequest();
		String dnumber = "", flag = "";
	    if(request.getParameter("dnumber") != null)
	    	dnumber = request.getParameter("dnumber");
	    if (request.getParameter("type") != null)
			flag = request.getParameter("type");
	    shxx = shxxManager.getShxxById(dnumber, flag);
	    if (shxx != null) {
			String shrq = shxx.getShrq();
			String shrqFormat = DateUtil.parseString(shrq, "yyyyMMddHHmmss","yyyy-MM-dd HH:mm:ss");
			shxx.setShrq(shrqFormat);
			String lrrq = shxx.getLrrq();
			String lrrqFormat = DateUtil.parseString(lrrq, "yyyyMMdd","yyyy-MM-dd");
			shxx.setLrrq(lrrqFormat);
			
		} else{
			shxx = new Shxx();
			shxx.setDnumber(dnumber);
			shxx.setFlag(flag);
		}
		return EDIT_JSPEXT;
	}
	
	/**保存更新对象*/
	public String updateExt() {
		HttpServletRequest request = ServletActionContext.getRequest();
		String shrqFormat = DateUtil.parseString(request,"shrq","yyyy-MM-dd HH:mm:ss","yyyyMMddHHmmss");
		shxx.setShrq(shrqFormat);
		String lrrqFormat = DateUtil.parseString(request,"lrrq","yyyy-MM-dd","yyyyMMdd");
		shxx.setLrrq(lrrqFormat);
		
		String new_IDCard = "";
		String old_IDCard = "";
		if (shxx != null && shxx.getShrsfzhm() != null
				&& shxx.getShrsfzhm().length() == 15) {
			new_IDCard = IDCard.getNewIDCard(shxx.getShrsfzhm());
			old_IDCard = shxx.getShrsfzhm();
		} else if (shxx != null && shxx.getShrsfzhm() != null
				&& shxx.getShrsfzhm().length() == 18) {
			old_IDCard = IDCard.getOldIDCard(shxx.getShrsfzhm());
			new_IDCard = shxx.getShrsfzhm();
		} else {
			new_IDCard = shxx.getShrsfzhm();
			old_IDCard = shxx.getShrsfzhm();
		}
		shxx.setShrsfzhm(new_IDCard.toUpperCase());
		shxxManager.updateExt(this.shxx);
		String shrqFormat1 = DateUtil.parseString(this.shxx.getShrq(), "yyyyMMddHHmmss","yyyy-MM-dd HH:mm:ss");
		shxx.setShrq(shrqFormat1);
		return SHOW_JSPEXT;////LIST_ACTION;
	}
	/** 系统查询*/
	public String htcxList() {

		PageRequest<Map> pageRequest = newPageRequest(DEFAULT_SORT_COLUMNS);
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
		String dateSelect7 = "";
		if (request.getParameter("dateSelect7") != null)
		    dateSelect7 = request.getParameter("dateSelect7");
			request.setAttribute("dateSelect7",dateSelect7);		        
		String s_shrqBeginFormat = DateUtil.parseString(request,"s_shrqBegin","yyyy-MM-dd","yyyyMMdd");
		String s_shrqEndFormat = DateUtil.parseString(request,"s_shrqEnd","yyyy-MM-dd","yyyyMMdd");
		pageRequest.getFilters().put("shrqBeginFormat",s_shrqBeginFormat+"000000");
		pageRequest.getFilters().put("shrqEndFormat",s_shrqEndFormat+"235959");

		
		Page page = shxxManager.findByPageRequest(pageRequest);
		savePage(page,pageRequest);
	
		return HTCXLIST_JSP;
	}
	/**进入系统查询查看*/
	public String htcxShow() {
		HttpServletRequest request = ServletActionContext.getRequest();
		String shrq =  shxx.getShrq();
		String shrqFormat = DateUtil.parseString(request,"shrq","yyyy-MM-dd HH:mm:ss","yyyyMMddHHmmss");
		shxx.setShrq(shrqFormat);
		String lrrq =  shxx.getLrrq();
		String lrrqFormat = DateUtil.parseString(lrrq,"yyyyMMdd","yyyy-MM-dd");
		shxx.setLrrq(lrrqFormat);
		return HTCXSHOW_JSP;
	}
}
