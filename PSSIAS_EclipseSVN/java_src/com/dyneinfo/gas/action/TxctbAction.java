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

import java.io.File;
import java.io.IOException;
import java.text.ParseException;
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


public class TxctbAction extends BaseStruts2Action implements Preparable,ModelDriven{
	//默认多列排序,example: username desc,createTime asc
	protected static final String DEFAULT_SORT_COLUMNS = null; 
	
	//forward paths
	protected static final String QUERY_JSP = "/pages/gas/Txctb/query.jsp";
	protected static final String LIST_JSP= "/pages/gas/Txctb/list.jsp";
	protected static final String QYLIST_JSP= "/pages/gas/Txctb/qylist.jsp";
	protected static final String CREATE_JSP = "/pages/gas/Txctb/create.jsp";
	protected static final String EDIT_JSP = "/pages/gas/Txctb/edit.jsp";
	protected static final String SHOW_JSP = "/pages/gas/Txctb/show.jsp";
	protected static final String SHOW_PIC = "/pages/pic/pic.jsp";
	protected static final String UPDATEPHOTOERROR = "/pages/pic/updateFileError.jsp";
	//redirect paths,startWith: !
	protected static final String LIST_ACTION = "!/pages/gas/Txctb/list.do";
	
	private TxctbManager txctbManager;
	private TxctbPicManager txctbPicManager;
	private TtztbFileManager ttztbFileManager;
	
	private Txctb txctb;
	private TxctbPic txctbPic;
	private TtztbFile ttztbFile;
	Long id = null;
	private String[] items;
	private String returnUrl;  //返回列表，保留查询条件
	private TreeMap<String, String> dateSelectMap;// //日期选择
	private long maxSize = 5 * 1024 * 1024; //字节
	
	
	//照片上传 start
	private List<File> uploads = new ArrayList<File>();
	private List<String> uploadFileNames = new ArrayList<String>();
	private List<String> uploadContentTypes = new ArrayList<String>();
	
	//附件
	private List<File> affixs = new ArrayList<File>();
	private List<String> affixFileNames = new ArrayList<String>();
	private List<String> affixContentTypes = new ArrayList<String>();
	
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

	public void prepare() throws Exception {
		if (isNullOrEmptyString(id)) {
			txctb = new Txctb();
		} else {
			txctb = (Txctb)txctbManager.getById(id);
		}
	}
	
	/** 增加setXXXX()方法,spring就可以通过autowire自动设置对象属性 */
	public void setTxctbManager(TxctbManager manager) {
		this.txctbManager = manager;
	}	
	
	public Object getModel() {
		return txctb;
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
	
	
	//显示图片
	public String showPic() {
		HttpServletRequest request = ServletActionContext.getRequest();
		String xh = "";
		if (request.getParameter("xh") != null)
			xh = request.getParameter("xh");
		List list = (List) txctbManager.getPic(xh);
		request.setAttribute("list", list);   
		return SHOW_PIC;
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
		String dateSelect19 = "";
		if (request.getParameter("dateSelect19") != null)
		    dateSelect19 = request.getParameter("dateSelect19");
			request.setAttribute("dateSelect19",dateSelect19);
	
		if (request.getParameter("s_fbsjBegin") != null){
			String s_fbsjBeginFormat = DateUtil.parseString(request,"s_fbsjBegin","yyyy-MM-dd","yyyyMMdd");
			pageRequest.getFilters().put("fbsjBeginFormat",s_fbsjBeginFormat);
		}
		if (request.getParameter("s_fbsjEnd") != null){
			String s_fbsjEndFormat = DateUtil.parseString(request,"s_fbsjEnd","yyyy-MM-dd","yyyyMMdd");
			pageRequest.getFilters().put("fbsjEndFormat",s_fbsjEndFormat);
		}
		pageRequest.getFilters().put("sortColumns","fbsj desc");
		
		Page page = txctbManager.findByPageRequest(pageRequest);
		savePage(page,pageRequest);
		return LIST_JSP;
	}
	
	
	/**
	 * 企业端协查通报查询
	 * @return
	 */
	public String qylist() {
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
		String dateSelect19 = "";
		if (request.getParameter("dateSelect19") != null)
			dateSelect19 = request.getParameter("dateSelect19");
		request.setAttribute("dateSelect19",dateSelect19);
		
		if (request.getParameter("s_fbsjBegin") != null){
			String s_fbsjBeginFormat = DateUtil.parseString(request,"s_fbsjBegin","yyyy-MM-dd","yyyyMMdd");
			pageRequest.getFilters().put("fbsjBeginFormat",s_fbsjBeginFormat);
		}
		if (request.getParameter("s_fbsjEnd") != null){
			String s_fbsjEndFormat = DateUtil.parseString(request,"s_fbsjEnd","yyyy-MM-dd","yyyyMMdd");
			pageRequest.getFilters().put("fbsjEndFormat",s_fbsjEndFormat);
		}
		pageRequest.getFilters().put("sortColumns","fbsj desc");
		
		Page page = txctbManager.findByPageRequest(pageRequest);
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
					"2", noticeid, "");
			List listpic = (List) txctbPicManager.getPic(noticeid);
			request.setAttribute("listpic",listpic);
			request.setAttribute("listfile", listfile);
		}
		SimpleDateFormat format = new SimpleDateFormat("yyyyMMddHHmm");
		SimpleDateFormat format1 = new SimpleDateFormat("yyyy-MM-dd HH:mm");
			try {
				Date dd= format.parse(txctb.getFbsj().toString());
				txctb.setFbsj(format1.format(dd));
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		return SHOW_JSP;
	}
	
	/** 进入新增页面*/
	public String create() {
		SimpleDateFormat s = new SimpleDateFormat("yyyy-MM-dd HH:mm");
		Date date = new Date();
		String xzsj = s.format(date);
		txctb.setFbsj(xzsj);
		
		return CREATE_JSP;
	}
	
	/** 保存新增对象 */
	public String save() {
		HttpServletRequest request = ServletActionContext.getRequest();
		String fbsjFormat = DateUtil.parseString(request,"fbsj","yyyy-MM-dd HH:mm","yyyyMMddHHmm");
		
		txctb.setFbsj(fbsjFormat);
		
		txctbManager.save(txctb);
		int i = 0;
		for (File u : uploads) {
			Integer objfile = new Integer(i);
			String str_ojb = objfile.toString();

			String fileName = uploadFileNames.get(i);
			int fileSize = (int) uploads.get(i).length();
			Long fileId = txctbManager.getSeq();
			txctbPic = new TxctbPic();
			txctbPic.setId(fileId);
			txctbPic.setTbid(txctb.getId());
			if (maxSize > 0 && uploads.get(i).length() > maxSize) {
				request.setAttribute("message", "上传的单个文件不能超过" + maxSize
						+ "字节！");
				return UPDATEPHOTOERROR;
			}
			try {
				txctbPicManager.savePic(u, txctbPic);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			i++;
		}
		
		if (affixs != null) {
			int j = 0;
			Long fileId =ttztbFileManager.getSeq();
			for (; j < affixs.size(); j++) {
				 boolean uploadLimitSize = true;

				String fileName = affixFileNames.get(j);
				ttztbFile = new TtztbFile();
				ttztbFile.setId(fileId);
				ttztbFile.setFileid(txctb.getId());
				ttztbFile.setTztbtype("2");
				ttztbFile.setFilename(fileName);
				try {
					ttztbFileManager.saveFile(affixs.get(j),ttztbFile);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
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
		txctbManager.update(this.txctb);
		return returnUrl;////LIST_ACTION;
	}
	
	/**删除对象*/
	public String delete() {
		for(int i = 0; i < items.length; i++) {
			Hashtable params = HttpUtils.parseQueryString(items[i]);
			Long id = new Long((String)params.get("id"));
			ttztbFile  = new TtztbFile();
			ttztbFile.setFileid(id);
			ttztbFile.setTztbtype("2");
			txctbPicManager.removeById(id);
			ttztbFileManager.removetztbfile(ttztbFile);
			txctbManager.removeById(id);
		}
		return returnUrl ;//LIST_ACTION;
	}

	public void setTxctbPicManager(TxctbPicManager txctbPicManager) {
		this.txctbPicManager = txctbPicManager;
	}

	public void setTtztbFileManager(TtztbFileManager ttztbFileManager) {
		this.ttztbFileManager = ttztbFileManager;
	}

}
