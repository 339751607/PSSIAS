/*
 * Powered By [lishicheng]
 */

package com.dyneinfo.fjy.action;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import javacommon.base.BaseStruts2Action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.java.dev.common.util.DateUtil;
import net.java.dev.common.util.SpringTagFunctions;

import org.apache.commons.lang.StringUtils;
import org.apache.struts2.ServletActionContext;
import org.security.userdetails.MyUserDetails;
import org.springframework.security.Authentication;
import org.springframework.security.context.SecurityContext;
import org.springframework.security.context.SecurityContextHolder;

import cn.org.rapid_framework.page.Page;
import cn.org.rapid_framework.page.PageRequest;

import com.dyneinfo.fjy.model.SsNotice;
import com.dyneinfo.fjy.model.SsNoticeAttend;
import com.dyneinfo.fjy.service.FileAttachfjyManager;
import com.dyneinfo.fjy.service.SsCommonfjyManager;
import com.dyneinfo.fjy.service.SsNoticeAttendManager;
import com.dyneinfo.fjy.service.SsNoticeManager;
import com.dyneinfo.zazh.model.FileAttach;
import com.dyneinfo.zazh.service.FileAttachManager;
import com.dyneinfo.zazh.service.SsCommonManager;
import com.opensymphony.xwork2.ModelDriven;
import com.opensymphony.xwork2.Preparable;

/**
 * @author lisc email:lishicheng(a)gmail.com
 */


public class SsNoticeAction extends BaseStruts2Action implements Preparable,ModelDriven{
	//默认多列排序,example: username desc,createTime asc
	protected static final String DEFAULT_SORT_COLUMNS = " sortno asc "; 
	
	//forward paths
	protected static final String QUERY_JSP = "/pages/fjy/SsNotice/query.jsp";
	protected static final String LIST_JSP= "/pages/fjy/SsNotice/list.jsp";
	protected static final String CREATE_JSP = "/pages/fjy/SsNotice/create.jsp";
	protected static final String EDIT_JSP = "/pages/fjy/SsNotice/edit.jsp";
	protected static final String SHOW_JSP = "/pages/fjy/SsNotice/show.jsp";
	protected static final String SHOW_PIC = "/pages/fjy/FileAttach/showPict.jsp";
	//redirect paths,startWith: !
	protected static final String LIST_ACTION = "!/pages/fjy/SsNotice/list.do";
	
	protected static final String LISTPOP_JSP= "/pages/fjy/SsNotice/listPop.jsp";
	protected static final String LISTUSER_JSP= "/pages/fjy/SsNotice/listUser.jsp";
	protected static final String SHOWPOP_JSP = "/pages/fjy/SsNotice/showPop.jsp";
	protected static final String SHOWUSER_JSP = "/pages/fjy/SsNotice/showUser.jsp";
	
	protected static final String REPLYSUCCESS_JSP = "/pages/fjy/SsNotice/replySuccess.jsp";
	
	protected static final String TZReplySTAT_JSP = "/pages/fjy/SsNotice/replyStat.jsp";
	protected static final String LISTTZREPLY_JSP= "/pages/fjy/SsNotice/listtzreply.jsp";
	protected static final String LISTTZNOREPLY_JSP= "/pages/fjy/SsNotice/listtznoreply.jsp";
	
	private SsNoticeManager ssNoticeManager;
	private SsCommonfjyManager ssCommonfjyManager;
	private SsNoticeAttendManager ssNoticeAttendManager;
	private FileAttachfjyManager fileAttachfjyManager;

	private FileAttach fileAttach;
	private SsNotice ssNotice;
	java.lang.Long id = null;
	private String[] items;
	private String returnUrl;  //返回列表，保留查询条件
	private TreeMap<String, String> dateSelectMap;// //日期选择
	
	private String deleteReturnUrl;
	private long maxSize = 5 * 1024 * 1024; //字节
	
	
	//照片上传 start
	private List<File> upload = new ArrayList<File>();
	private List<String> uploadFileName = new ArrayList<String>();
	private List<String> uploadContentType = new ArrayList<String>();

	public List<File> getUpload() {
		return this.upload;
	}

	public void setUpload(List<File> upload) {
		this.upload = upload;
	}

	public List<String> getUploadFileName() {
		return this.uploadFileName;
	}

	public void setUploadFileName(List<String> uploadFileName) {
		this.uploadFileName = uploadFileName;
	}

	public List<String> getUploadContentType() {
		return this.uploadContentType;
	}

	public void setUploadContentType(List<String> contentTypes) {
		this.uploadContentType = contentTypes;
	}

	//照片上传 end

	//附件
	private List<File> affix = new ArrayList<File>();
	private List<String> affixFileNames = new ArrayList<String>();
	private List<String> affixContentTypes = new ArrayList<String>();

	public List<File> getAffix() {
		return this.affix;
	}

	public void setAffix(List<File> affix) {
		this.affix = affix;
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

	//附件 end

	public void prepare() throws Exception {
		if (isNullOrEmptyString(id)) {
			ssNotice = new SsNotice();
		} else {
			ssNotice = (SsNotice)ssNoticeManager.getSsNoticeById(id);
		}
	}
	
	/** 增加setXXXX()方法,spring就可以通过autowire自动设置对象属性 */
	public void setSsNoticeManager(SsNoticeManager manager) {
		this.ssNoticeManager = manager;
	}	

	
	

	public SsCommonfjyManager getSsCommonfjyManager() {
		return ssCommonfjyManager;
	}

	public void setSsCommonfjyManager(SsCommonfjyManager ssCommonfjyManager) {
		this.ssCommonfjyManager = ssCommonfjyManager;
	}

	public void setSsNoticeAttendManager(SsNoticeAttendManager manager) {
		this.ssNoticeAttendManager = manager;
	}	
	
	
	
	public FileAttachfjyManager getFileAttachfjyManager() {
		return fileAttachfjyManager;
	}

	public void setFileAttachfjyManager(FileAttachfjyManager fileAttachfjyManager) {
		this.fileAttachfjyManager = fileAttachfjyManager;
	}

	public Object getModel() {
		return ssNotice;
	}
	
	public void setNoticeid(java.lang.Long val) {
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
	
	public String getDeleteReturnUrl() {
		return deleteReturnUrl;
	}

	public void setDeleteReturnUrl(String deleteReturnUrl) {
		this.deleteReturnUrl = deleteReturnUrl;
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
		
		String username = "";
		String deptid = "";
		MyUserDetails userDetail = null;
		userDetail = SpringTagFunctions.getUserDetails();
		if (userDetail != null) {
			username = userDetail.getUserName();
			deptid = userDetail.getDeptID();
		
		}
		
		if(!SpringTagFunctions.ifAnyGranted("ROLE_QUERY_ALL,ROLE_ADMIN")){
			pageRequest.getFilters().put("deptid",deptid);
			pageRequest.getFilters().put("deptLength",deptid.length());
		}	
		dateSelectMap  = DateUtil.getDateSelectData();
		String dateSelect2 = "";
		if (request.getParameter("dateSelect2") != null)
		    dateSelect2 = request.getParameter("dateSelect2");
			request.setAttribute("dateSelect2",dateSelect2);		        
		String dateSelect3 = "";
		if (request.getParameter("dateSelect3") != null)
		    dateSelect3 = request.getParameter("dateSelect3");
			request.setAttribute("dateSelect3",dateSelect3);		        
		String dateSelect7 = "";
		if (request.getParameter("dateSelect7") != null)
		    dateSelect7 = request.getParameter("dateSelect7");
			request.setAttribute("dateSelect7",dateSelect7);		        
		pageRequest.getFilters().put("authorid", userDetail.getUsername());
		Page page = ssNoticeManager.findByPageRequest(pageRequest);
		savePage(page,pageRequest);
		return LIST_JSP;
	}
	
	
	
	public String listUser() {
		PageRequest<Map> pageRequest = newPageRequest(DEFAULT_SORT_COLUMNS);
		HttpServletRequest request = ServletActionContext.getRequest();
		//pageRequest.getFilters().put("key",value);     //add custom filter
		
		String s_noticetitle = null;
		String s_state = null;
		String s_authorid = null;
		String s_sendunitid = null;
		String s_starttimeBegin = null;
		String s_starttimeEnd = null;
		String s_endtimeBegin = null;
		String s_endtimeEnd = null;
		
		if(request.getParameter("s_noticetitle") != null)
			s_noticetitle = request.getParameter("s_noticetitle");
		if(request.getParameter("s_state") != null)
			s_state = request.getParameter("s_state");
		if(request.getParameter("s_authorid") != null)
			s_authorid = request.getParameter("s_authorid");
		if(request.getParameter("s_sendunitid") != null)
			s_sendunitid = request.getParameter("s_sendunitid");
		if(request.getParameter("s_starttimeBegin") != null)
			s_starttimeBegin = request.getParameter("s_starttimeBegin");
		if(request.getParameter("s_starttimeEnd") != null)
			s_starttimeEnd = request.getParameter("s_starttimeEnd");
		if(request.getParameter("s_endtimeBegin") != null)
			s_endtimeBegin = request.getParameter("s_endtimeBegin");
		if(request.getParameter("s_endtimeEnd") != null)
			s_endtimeEnd = request.getParameter("s_endtimeEnd");
		
		String sqlWhere = " ";
		if(StringUtils.isNotEmpty(s_noticetitle))
			sqlWhere = sqlWhere +" and noticetitle like '%"+s_noticetitle+"%' " ;
		if(StringUtils.isNotEmpty(s_state))
			sqlWhere = sqlWhere +" and t.STATE = '"+s_state+"' " ;
		if(StringUtils.isNotEmpty(s_authorid))
			sqlWhere = sqlWhere +" and c.fullname like '%"+s_authorid+"%' " ;
		if(StringUtils.isNotEmpty(s_sendunitid))
			sqlWhere = sqlWhere +" and b.deptname like '%"+s_sendunitid+"%' " ;
		if(StringUtils.isNotEmpty(s_starttimeBegin) && s_starttimeBegin != null && s_starttimeBegin.length() > 0)
			sqlWhere = sqlWhere +" and t.STARTTIME >= to_date('"+s_starttimeBegin+" 00:00:00','yyyy-MM-dd HH24:mi:ss') " ;
		if(StringUtils.isNotEmpty(s_starttimeEnd) && s_starttimeEnd != null && s_starttimeEnd.length() > 0)
			sqlWhere = sqlWhere +" and t.STARTTIME <= to_date('"+s_starttimeEnd+" 23:59:59','yyyy-MM-dd HH24:mi:ss') " ;
		if(StringUtils.isNotEmpty(s_endtimeBegin) && s_endtimeBegin != null && s_endtimeBegin.length() > 0)
			sqlWhere = sqlWhere +" and t.ENDTIME >= to_date('"+s_endtimeBegin+" 00:00:00','yyyy-MM-dd HH24:mi:ss') " ;
		if(StringUtils.isNotEmpty(s_endtimeEnd) && s_endtimeEnd != null && s_endtimeEnd.length() > 0)
			sqlWhere = sqlWhere +" and t.ENDTIME <= to_date('"+s_endtimeEnd+" 23:59:59','yyyy-MM-dd HH24:mi:ss') " ;
		
		
		String dateSelect2 = "";
		if (request.getParameter("dateSelect2") != null)
		    dateSelect2 = request.getParameter("dateSelect2");
			request.setAttribute("dateSelect2",dateSelect2);		        
		String dateSelect3 = "";
		if (request.getParameter("dateSelect3") != null)
		    dateSelect3 = request.getParameter("dateSelect3");
			request.setAttribute("dateSelect3",dateSelect3);		        
		String dateSelect7 = "";
		if (request.getParameter("dateSelect7") != null)
		    dateSelect7 = request.getParameter("dateSelect7");
			request.setAttribute("dateSelect7",dateSelect7);	
		
		 
		
		
		String username = "";
		String deptid = "";
		String deptSeq = "";
		String deptTypeID = "";
		MyUserDetails userDetail = null;
		userDetail = SpringTagFunctions.getUserDetails();
		if (userDetail != null) {
			username = userDetail.getUsername();
			deptid = userDetail.getDeptID();
			deptSeq = userDetail.getDeptSeq();
			deptTypeID = userDetail.getDeptTypeID();
		}
		
		String deptTypeIDWhere = "";
		if(deptTypeID != null && deptTypeID.length() > 0){
			if(deptTypeID.equals("0"))
				deptTypeIDWhere = " and  b.DEPTTYPEID in (select code  from t_dic_cptype )";
			else
				deptTypeIDWhere = " and b.DEPTTYPEID in ('0','"+deptTypeID+"')";
		} else {
			    deptTypeIDWhere = " and b.DEPTTYPEID = 0";
		}
		dateSelectMap  = DateUtil.getDateSelectData();
		String query = " select * from (select  "
			+" distinct  t.NOTICEID as noticeid,"
			+" NOTICETITLE as noticetitle,"
			+" NOTICECONTENT as noticecontent,"
			+" STARTTIME as starttime,"
			+" ENDTIME as endtime,"
			+" t.STATE as state,"
			+" AUTHORID as authorid,"
			+" SENDUNITID as sendunitid,"
			+" t.CREATETIME as createtime,"
			+" ISREPLY as isreply,"
			+" ISSUESCOPE as issuescope,"
			+" PARTICIPANTS as participants,"
			+" SORTNO as sortno,"
			+" c.fullname as authorname,"
			+" b.deptname as sendunitname, "
			+" (case  when t.noticeid not in (select noticeid from ss_notice_reply where deptid='"+deptid+"')  then  null else  0  end) as readflag "
			+" from SS_NOTICE t,SS_dept b ,SS_user c,SS_NOTICE_ATTEND d ,ss_notice_reply r";
			query = query + "   where t.authorid = c.username  " +deptTypeIDWhere+
					" and t.STATE = 1  " +
		    " and t.sendunitid = b.deptid   and d.NOTICEID = t.NOTICEID   and t.noticeid = r.noticeid(+) "; 
		    if(StringUtils.isNotEmpty(sqlWhere)){
		    	query += sqlWhere;
		    }
		    
		    
		    query +=" and ( " ;
			
			 StringBuffer sb = new StringBuffer(query);
			 if(StringUtils.isNotEmpty(username))
	         {
				 StringBuffer buff = new StringBuffer(" ( d.isdept = 0 and d.userid = '"+username+"') "); 
				 sb.append(buff.toString());
	         }
            if(StringUtils.isNotEmpty(deptSeq))
            {
                StringBuffer buff = new StringBuffer(deptSeq.replace(".", ","));
                buff.deleteCharAt(0);
                buff.deleteCharAt(buff.length() - 1);
                sb.append((new StringBuilder(" or (d.DEPTID  in (")).append(buff.toString()).append(") and d.isdept = 1 )").toString());
            }
            sb.append(" )  )");
           
      
		    		
		Page page = ssNoticeManager.findByPageRequest(pageRequest,sb.toString());
		savePage(page,pageRequest);
		return LISTUSER_JSP;
	}
	
	
	public String listPop() {
		PageRequest<Map> pageRequest = newPageRequest(DEFAULT_SORT_COLUMNS);
		HttpServletRequest request = ServletActionContext.getRequest();
		//pageRequest.getFilters().put("key",value);     //add custom filter
		
		String username = "";
		String deptid = "";
		String deptSeq = "";
		String deptTypeID = "";
		MyUserDetails userDetail = null;
		userDetail = SpringTagFunctions.getUserDetails();
		if (userDetail != null) {
			username = userDetail.getUsername();
			deptid = userDetail.getDeptID();
			deptSeq = userDetail.getDeptSeq();
			deptTypeID = userDetail.getDeptTypeID();
		}
		
		String deptTypeIDWhere = "";
		if(deptTypeID != null && deptTypeID.length() > 0){
			if(deptTypeID.equals("0"))
				deptTypeIDWhere = " and  t.DEPTTYPEID in (select code  from t_dic_cptype )";
			else
				deptTypeIDWhere = " and t.DEPTTYPEID in ('0','"+deptTypeID+"')";
		} else {
			    deptTypeIDWhere = " and t.DEPTTYPEID = 0";
		}
		dateSelectMap  = DateUtil.getDateSelectData();
		String query = "select  "
			+" distinct  t.NOTICEID as noticeid,"
			+" NOTICETITLE as noticetitle,"
			+" NOTICECONTENT as noticecontent,"
			+" STARTTIME as starttime,"
			+" ENDTIME as endtime,"
			+" STATE as state,"
			+" AUTHORID as authorid,"
			+" SENDUNITID as sendunitid,"
			+" CREATETIME as createtime,"
			+" ISREPLY as isreply,"
			+" ISSUESCOPE as issuescope,"
			+" PARTICIPANTS as participants,"
			+" SORTNO as sortno,"
			+" c.fullname as authorname,"
			+" b.deptname as sendunitname "
			+" from SS_NOTICE t,SS_dept b ,SS_user c,SS_NOTICE_ATTEND d ";
			query = query + "   where t.NOTICEID not in (select NOTICEID from SS_NOTICE_REPLY where DEPTID='"+deptid+"') and t.authorid = c.username " +
			  deptTypeIDWhere +
		    " and t.sendunitid = b.deptid and STATE = 1  and d.NOTICEID = t.NOTICEID " +
		    " and t.STARTTIME <= sysdate and t.ENDTIME >= sysdate  "+
		    " and ( " ;
			
			 StringBuffer sb = new StringBuffer(query);
			 if(StringUtils.isNotEmpty(username))
	         {
				 StringBuffer buff = new StringBuffer(" ( d.isdept = 0 and d.userid = '"+username+"') "); 
				 sb.append(buff.toString());
	         }
            if(StringUtils.isNotEmpty(deptSeq))
            {
                StringBuffer buff = new StringBuffer(deptSeq.replace(".", ","));
                buff.deleteCharAt(0);
                buff.deleteCharAt(buff.length() - 1);
                sb.append((new StringBuilder(" or (d.DEPTID  in (")).append(buff.toString()).append(") and d.isdept = 1 )").toString());
            }
            sb.append(" ) order by SORTNO");
			
		    		
		Page page = ssNoticeManager.findByPageRequest(pageRequest,sb.toString());
		savePage(page,pageRequest);
		return LISTPOP_JSP;
	}
	
	/** 查看对象*/
	public String show() {
		HttpServletRequest request = ServletActionContext.getRequest();
		//发布范围（单位） 
		String deptIdStr="",deptNameStr="";
		String usernameStr="",fullnameStr="";
		List orgList = (List) ssCommonfjyManager.getNotice_issuescope(ssNotice.getNoticeid());
		if (orgList != null) {
			for (int i = 0; i < orgList.size(); i++) {
				Map results = (HashMap) orgList.get(i);
				String DEPTID = (String) results.get("DEPTID");
				String DEPTNAME = (String) results.get("DEPTNAME");
				deptIdStr = deptIdStr +DEPTID+ ";";
				deptNameStr = deptNameStr +DEPTNAME+ ";";
			}
			if(StringUtils.isNotEmpty(deptIdStr))
			    deptIdStr = deptIdStr.substring(0, deptIdStr.length()-1);
			if(StringUtils.isNotEmpty(deptNameStr))
				deptNameStr = deptNameStr.substring(0, deptNameStr.length()-1);
		}
		//ssNotice.setIssuescope(deptIdStr);
		ssNotice.setIssuescopeName(deptNameStr);
		
		//通知 参与人员
		List userList = (List) ssCommonfjyManager.getNotice_participants(ssNotice.getNoticeid());
		if (userList != null) {
			for (int i = 0; i < userList.size(); i++) {
				Map results = (HashMap) userList.get(i);
				String USERNAME = (String) results.get("USERNAME");
				String FULLNAME = (String) results.get("FULLNAME");
				usernameStr = usernameStr +USERNAME+ ";";
				fullnameStr = fullnameStr +FULLNAME+ ";";
			}
			if(StringUtils.isNotEmpty(usernameStr))
				usernameStr = usernameStr.substring(0, usernameStr.length()-1);
			if(StringUtils.isNotEmpty(fullnameStr))
				fullnameStr = fullnameStr.substring(0, fullnameStr.length()-1);
		}
		//ssNotice.setParticipants(usernameStr);
		ssNotice.setParticipantsName(fullnameStr);
		
		
		
		String noticeid = "";
		if (request.getParameter("noticeid") != null)
			noticeid = request.getParameter("noticeid");
		if (noticeid != null && noticeid.length() > 0) {
			List listpic = (List) fileAttachfjyManager.getPic("D",
					"SS_NOTICE_PIC", noticeid, "");
			request.setAttribute("listpic", listpic);
			List listfile = (List) fileAttachfjyManager.getFile("D",
					"SS_NOTICE_FILE", noticeid, "");
			request.setAttribute("listfile", listfile);
		}
		
		
		String deptid = "",deptseq="";
		MyUserDetails userDetail = null;
		userDetail = SpringTagFunctions.getUserDetails();
		if (userDetail != null) {
			deptid = userDetail.getDeptID();
			deptseq=userDetail.getDeptSeq();
		}
		ssNotice.setSendunitname(ssCommonfjyManager.getDeptFullNameByDeptId(ssNotice.getSendunitid()));
		int c_count = ssNoticeManager.getCountByKey(noticeid, deptid,"0");
		if (c_count < 1)
			request.setAttribute("fzFlag", "0");
		else
			request.setAttribute("fzFlag", "1");
		
	
		return SHOW_JSP;
	}
	
	public String showPop() {
		HttpServletRequest request = ServletActionContext.getRequest();
		String noticeid = "";
		if (request.getParameter("noticeid") != null)
			noticeid = request.getParameter("noticeid");
		if (noticeid != null && noticeid.length() > 0) {
			List listpic = (List) fileAttachfjyManager.getPic("D",
					"SS_NOTICE_PIC", noticeid, "");
			request.setAttribute("listpic", listpic);
			List listfile = (List) fileAttachfjyManager.getFile("D",
					"SS_NOTICE_FILE", noticeid, "");
			request.setAttribute("listfile", listfile);
		}
		
		String deptid = "";
		MyUserDetails userDetail = null;
		userDetail = SpringTagFunctions.getUserDetails();
		if (userDetail != null) {
			deptid = userDetail.getDeptID();
		}
		
		int c_count = ssNoticeManager.getCountByKey(noticeid, deptid,"0");
		if (c_count < 1)
			request.setAttribute("fzFlag", "0");
		else
			request.setAttribute("fzFlag", "1");
		return SHOWPOP_JSP;
	}
	
	public String showUser() {
		HttpServletRequest request = ServletActionContext.getRequest();
		String noticeid = "";
		if (request.getParameter("noticeid") != null)
			noticeid = request.getParameter("noticeid");
		if (noticeid != null && noticeid.length() > 0) {
			List listpic = (List) fileAttachfjyManager.getPic("D",
					"SS_NOTICE_PIC", noticeid, "");
			request.setAttribute("listpic", listpic);
			List listfile = (List) fileAttachfjyManager.getFile("D",
					"SS_NOTICE_FILE", noticeid, "");
			request.setAttribute("listfile", listfile);
		}
		String deptid = "";
		MyUserDetails userDetail = null;
		userDetail = SpringTagFunctions.getUserDetails();
		if (userDetail != null) {
			deptid = userDetail.getDeptID();
		}
		
		int c_count = ssNoticeManager.getCountByKey(noticeid, deptid,"0");
		if (c_count < 1)
			request.setAttribute("fzFlag", "0");
		else
			request.setAttribute("fzFlag", "1");
		
		
		String isreply=request.getParameter("isreply")!=null?request.getParameter("isreply"):"";
	 	Date date = new Date();
		SimpleDateFormat format = new SimpleDateFormat("yyyyMMddHHmmss");
		String currDate = format.format(date);
		int r_count = ssNoticeManager.getCountByKey(noticeid,deptid,"1");
		
		if(r_count < 1&&c_count<1&&isreply.equals("0"))
			ssNoticeManager.insertNoticeReply(noticeid ,deptid,currDate,"1");
		return SHOWUSER_JSP;
	}
	
	/** 进入新增页面*/
	public String create() {
		HttpServletRequest request = ServletActionContext.getRequest();
		Date date = new Date();
		SimpleDateFormat format_inserttime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String str_inserttime = format_inserttime.format(date);
		String session_deptid = "";
		SecurityContext sc = SecurityContextHolder.getContext();
		Authentication auth = sc.getAuthentication();
		MyUserDetails ud = null;
		if ((auth != null) && auth.getPrincipal() instanceof MyUserDetails) {
			ud = (MyUserDetails) auth.getPrincipal();
			if (ud != null) {
				session_deptid = ud.getDeptID();
				request.setAttribute("deptseq", ud.getDeptSeq());
				request.setAttribute("deptname",ssCommonfjyManager.getDeptFullNameByDeptId(ud.getDeptID()));
				
				request.setAttribute("deptid", session_deptid);
			}
		}
             
        
        Calendar lastDate = Calendar.getInstance();    
        lastDate.set(Calendar.DATE,1);//设为当前月的1号    
        lastDate.add(Calendar.MONTH,1);//加一个月，变为下月的1号    
        lastDate.add(Calendar.DATE,-1);//减去一天，变为当月最后一天    
            
        String endtime =format_inserttime.format(lastDate.getTime());  
        
        ssNotice.setStarttimeString(str_inserttime);
        ssNotice.setEndtimeString(endtime);
        ssNotice.setCreatetimeString(str_inserttime);
        ssNotice.setIsreply("0");
        ssNotice.setState("0");
		return CREATE_JSP;
	}
	
	/** 保存新增对象 */ 
	
	//没有使用事务
	public String save() {
		HttpServletRequest request = ServletActionContext.getRequest();

		SecurityContext sc = SecurityContextHolder.getContext();
		Authentication auth = sc.getAuthentication();
		MyUserDetails ud = null;
		if ((auth != null) && auth.getPrincipal() instanceof MyUserDetails) {
			ud = (MyUserDetails) auth.getPrincipal();
			if (ud != null) {
				ssNotice.setAuthorid(ud.getUsername());

			}
		}
	
		ssNoticeManager.save(ssNotice);
		//ISSUESCOPE 发布范围0则代表全部部门存放所有的参与部门ID  setIsdept 是否为部门 0 否 1 是
		String issueScopeIds = request.getParameter("issuescope");
		if (StringUtils.isNotEmpty(issueScopeIds)) {
			ssNoticeAttendManager.deleteIssuescope(id);
			String strIssueScopeId[] = issueScopeIds.split(";");
			for (int i = 0; i < strIssueScopeId.length; i++)
				if (StringUtils.isNotEmpty(strIssueScopeId[i])) {
					Long depId = new Long(strIssueScopeId[i]);
					SsNoticeAttend ssNoticeAttend = new SsNoticeAttend();
					ssNoticeAttend.setDeptid(depId);
					ssNoticeAttend.setIsdept(1L);
					ssNoticeAttend.setNoticeid(ssNotice.getNoticeid());
					ssNoticeAttendManager.save(ssNoticeAttend);
				}
		}
		String participantsIds = request.getParameter("participants");
        if(StringUtils.isNotEmpty(participantsIds))
        {
        	ssNoticeAttendManager.deleteParticipants(id);
                String strParticipantsId[] = participantsIds.split(";");
                for(int i = 0; i < strParticipantsId.length; i++)
                    if(StringUtils.isNotEmpty(strParticipantsId[i]))
                    {
    					SsNoticeAttend ssNoticeAttend = new SsNoticeAttend();
    					ssNoticeAttend.setUserid(strParticipantsId[i]);
    					ssNoticeAttend.setIsdept(0L);
    					ssNoticeAttend.setNoticeid(ssNotice.getNoticeid());
    					ssNoticeAttendManager.save(ssNoticeAttend);
                    }
        }
		
		String deptID = "";
		String username = "";
		MyUserDetails userDetail = null;
		userDetail = SpringTagFunctions.getUserDetails();
		if (userDetail != null) {
			deptID = userDetail.getDeptID();
			username = userDetail.getUsername();
		}
        
		try {
			Date date = new Date();
			SimpleDateFormat format_file_CREATETIME = new SimpleDateFormat(
					"yyyy-MM-dd HH:mm:ss");
			String str_file_CREATETIME = format_file_CREATETIME.format(date);

			int i = 0;
			for (File u : upload) {
				Integer objfile = new Integer(i);
				String str_ojb = objfile.toString();

				String fileName = uploadFileName.get(i);
				String nameWithoutExt = getNameWithoutExtension(fileName);
				String ext = getExtension(fileName);
				int fileSize = (int) upload.get(i).length();
				Long fileId = fileAttachfjyManager.getSeq();
				fileAttach = new FileAttach();
				fileAttach.setFileid(fileId);
				fileAttach.setCreatetimeString(str_file_CREATETIME);
				fileAttach.setAbsolutepath("");
				fileAttach.setContenttype(uploadContentType.get(i));
				fileAttach.setCreator(username);
				fileAttach.setFileext(ext);
				fileAttach.setFilegroup("SS_NOTICE_PIC");
				fileAttach.setFilename(nameWithoutExt);
				fileAttach.setFilepath("");
				fileAttach.setFileSave("D");
				fileAttach.setFilesize(fileSize);
				fileAttach.setNote("通知照片");
				fileAttach.setRelationId(ssNotice.getNoticeid().toString());
				if (upload.get(i).length() <= 0) {
					request.setAttribute("message", "上传的文件不能为空！");
					//return CREATE_JSP;
				}
				if (maxSize > 0 && upload.get(i).length() > maxSize) {
					request.setAttribute("message", "上传的单个文件不能超过" + maxSize
							+ "字节！");
					//return CREATE_JSP;
				}
				fileAttachfjyManager.savePic(u, fileAttach);
				i++;
			}

			if (affix != null) {
				int j = 0;
				for (; j < affix.size(); j++) {
					 boolean uploadLimitSize = true;
					if (affix.get(j).length() <= 0) {
						request.setAttribute("message", "上传的文件不能为空！");
						continue; 
					}
					if (maxSize > 0 && affix.get(j).length() > maxSize) {
						request.setAttribute("message", "上传的单个文件不能超过" + maxSize
								+ "字节！");
						System.out.println("上传的单个文件不能超过" + maxSize+ "字节！");
						continue; 
					}
					System.out.println("affix.get(j).length()="+affix.get(j).length());
					System.out.println("affixContentTypes.get(j)="+affixContentTypes.get(j));

					String fileName = affixFileNames.get(j);
					String nameWithoutExt = getNameWithoutExtension(fileName);
					String ext = getExtension(fileName);
					int fileSize = (int) affix.get(j).length();

					Long fileId = fileAttachfjyManager.getSeq();
					fileAttach = new FileAttach();
					fileAttach.setFileid(fileId);
					fileAttach.setCreatetimeString(str_file_CREATETIME);
					fileAttach.setAbsolutepath("");
					fileAttach.setContenttype(affixContentTypes.get(j));
					fileAttach.setCreator(username);
					fileAttach.setFileext(ext);
					fileAttach.setFilegroup("SS_NOTICE_FILE");
					fileAttach.setFilename(nameWithoutExt);
					fileAttach.setFilepath("");
					fileAttach.setFileSave("D");
					fileAttach.setFilesize(fileSize);
					fileAttach.setNote("通知附件");
					fileAttach.setRelationId(ssNotice.getNoticeid().toString());

					fileAttachfjyManager.saveFile(affix.get(j), fileAttach);
				}
			}

		}

		catch (Exception e) {
			e.printStackTrace();
		}
        
        
		return returnUrl;////LIST_ACTION;
	}
	
	/**进入更新页面*/
	public String edit() {
		HttpServletRequest request = ServletActionContext.getRequest();
		//发布范围（单位） 
		String deptIdStr="",deptNameStr="";
		String usernameStr="",fullnameStr="";
		List orgList = (List) ssCommonfjyManager.getNotice_issuescope(ssNotice.getNoticeid());
		if (orgList != null) {
			for (int i = 0; i < orgList.size(); i++) {
				Map results = (HashMap) orgList.get(i);
				String DEPTID = (String) results.get("DEPTID");
				String DEPTNAME = (String) results.get("DEPTNAME");
				deptIdStr = deptIdStr +DEPTID+ ";";
				deptNameStr = deptNameStr +DEPTNAME+ ";";
			}
			if(StringUtils.isNotEmpty(deptIdStr))
			    deptIdStr = deptIdStr.substring(0, deptIdStr.length()-1);
			if(StringUtils.isNotEmpty(deptNameStr))
				deptNameStr = deptNameStr.substring(0, deptNameStr.length()-1);
		}
		//ssNotice.setIssuescope(deptIdStr);
		ssNotice.setIssuescopeName(deptNameStr);
		
		//通知 参与人员
		List userList = (List) ssCommonfjyManager.getNotice_participants(ssNotice.getNoticeid());
		if (userList != null) {
			for (int i = 0; i < userList.size(); i++) {
				Map results = (HashMap) userList.get(i);
				String USERNAME = (String) results.get("USERNAME");
				String FULLNAME = (String) results.get("FULLNAME");
				usernameStr = usernameStr +USERNAME+ ";";
				fullnameStr = fullnameStr +FULLNAME+ ";";
			}
			if(StringUtils.isNotEmpty(usernameStr))
				usernameStr = usernameStr.substring(0, usernameStr.length()-1);
			if(StringUtils.isNotEmpty(fullnameStr))
				fullnameStr = fullnameStr.substring(0, fullnameStr.length()-1);
		}
		//ssNotice.setParticipants(usernameStr);
		ssNotice.setParticipantsName(fullnameStr);
		
	
		String noticeid = "";
		if (request.getParameter("noticeid") != null)
			noticeid = request.getParameter("noticeid");
		if (noticeid != null && noticeid.length() > 0) {
			List listpic = (List) fileAttachfjyManager.getPic("D",
					"SS_NOTICE_PIC", noticeid, "");
			request.setAttribute("listpic", listpic);
			List listfile = (List) fileAttachfjyManager.getFile("D",
					"SS_NOTICE_FILE", noticeid, "");
			request.setAttribute("listfile", listfile);
		}
		return EDIT_JSP;
	}
	
	/**保存更新对象*/
	public String update() {
		HttpServletRequest request = ServletActionContext.getRequest();
		
		ssNoticeManager.update(this.ssNotice);
		
		//ISSUESCOPE 发布范围0则代表全部部门存放所有的参与部门ID  setIsdept 是否为部门 0 否 1 是
		String issueScopeIds = request.getParameter("issuescope");
		if (StringUtils.isNotEmpty(issueScopeIds)) {
			ssNoticeAttendManager.deleteIssuescope(id);
			String strIssueScopeId[] = issueScopeIds.split(";");
			for (int i = 0; i < strIssueScopeId.length; i++)
				if (StringUtils.isNotEmpty(strIssueScopeId[i])) {
					Long depId = new Long(strIssueScopeId[i]);
					SsNoticeAttend ssNoticeAttend = new SsNoticeAttend();
					ssNoticeAttend.setDeptid(depId);
					ssNoticeAttend.setIsdept(1L);
					ssNoticeAttend.setNoticeid(ssNotice.getNoticeid());
					ssNoticeAttendManager.save(ssNoticeAttend);
				}
		}
		String participantsIds = request.getParameter("participants");
        if(StringUtils.isNotEmpty(participantsIds))
        {
        	ssNoticeAttendManager.deleteParticipants(id);
                String strParticipantsId[] = participantsIds.split(";");
                for(int i = 0; i < strParticipantsId.length; i++)
                    if(StringUtils.isNotEmpty(strParticipantsId[i]))
                    {
    					SsNoticeAttend ssNoticeAttend = new SsNoticeAttend();
    					ssNoticeAttend.setUserid(strParticipantsId[i]);
    					ssNoticeAttend.setIsdept(0L);
    					ssNoticeAttend.setNoticeid(ssNotice.getNoticeid());
    					ssNoticeAttendManager.save(ssNoticeAttend);
                    }
        }
		
		
		return returnUrl;////LIST_ACTION;
	}
	
	/**删除对象*/
	public String delete() {
//		for(int i = 0; i < items.length; i++) {
//			Hashtable params = HttpUtils.parseQueryString(items[i]);
//			java.lang.Long id = new java.lang.Long((String)params.get("noticeid"));
//			ssNoticeManager.deleteNOTICE_attend(id);
//		}
		if(ssNotice.getNoticeid()!=null)ssNoticeManager.deleteNOTICE_attend(ssNotice.getNoticeid());
		return returnUrl ;//LIST_ACTION;
	}
	
	
	
	public String reply() {
		String deptID = "";
		String username = "";
		MyUserDetails userDetail = null;
		userDetail = SpringTagFunctions.getUserDetails();
		if (userDetail != null) {
			deptID = userDetail.getDeptID();
			username = userDetail.getUsername();
		}
		
         String noticeid = "";
	     HttpServletRequest request = ServletActionContext.getRequest();
	     if(request.getParameter("noticeid") != null){
	    	 noticeid = request.getParameter("noticeid");
	     }
	 	Date date = new Date();
		SimpleDateFormat format = new SimpleDateFormat("yyyyMMddHHmmss");
		String currDate = format.format(date);
		int c_count = ssNoticeManager.getCountByKey(noticeid,deptID,"0");
		if(c_count < 1)
			ssNoticeManager.insertNoticeReply(noticeid ,deptID,currDate,"0");
		//return LIST_ACTION;
		return returnUrl;
	}
	public String read(){
		String deptID = "";
		String username = "";
		MyUserDetails userDetail = null;
		userDetail = SpringTagFunctions.getUserDetails();
		if (userDetail != null) {
			deptID = userDetail.getDeptID();
			username = userDetail.getUsername();
		}
		
         String noticeid = "";
	     HttpServletRequest request = ServletActionContext.getRequest();
	     if(request.getParameter("noticeid") != null){
	    	 noticeid = request.getParameter("noticeid");
	     }
	 	Date date = new Date();
		SimpleDateFormat format = new SimpleDateFormat("yyyyMMddHHmmss");
		String currDate = format.format(date);
		int c_count = ssNoticeManager.getCountByKey(noticeid,deptID,"1");
		if(c_count < 1)
			ssNoticeManager.insertNoticeReply(noticeid ,deptID,currDate,"0");
		//return LIST_ACTION;
		return returnUrl;
	}
	
	
	public String replypop() {
		String deptID = "";
		String username = "";
		MyUserDetails userDetail = null;
		userDetail = SpringTagFunctions.getUserDetails();
		if (userDetail != null) {
			deptID = userDetail.getDeptID();
			username = userDetail.getUsername();
		}
		
         String noticeid = "";
	     HttpServletRequest request = ServletActionContext.getRequest();
	     if(request.getParameter("noticeid") != null){
	    	 noticeid = request.getParameter("noticeid");
	     }
	     Date date = new Date();
			SimpleDateFormat format = new SimpleDateFormat("yyyyMMddHHmmss");
			String currDate = format.format(date);
			int c_count = ssNoticeManager.getCountByKey(noticeid,deptID,"0");
			if(c_count < 1)
				ssNoticeManager.insertNoticeReply(noticeid ,deptID,currDate,"0");
		return REPLYSUCCESS_JSP;
	}
	
	
	
	
	private static String getNameWithoutExtension(String fileName) {
		return fileName.substring(0, fileName.lastIndexOf("."));
	}

	private String getExtension(String fileName) {
		return fileName.substring(fileName.lastIndexOf(".") + 1);
	}
	
	
	
	
	
	

	public String pictShow() {
		HttpServletRequest request = ServletActionContext.getRequest();
		String FILEID = "";
		if (request.getParameter("FILEID") != null)
			FILEID = request.getParameter("FILEID");
		List list = (List) fileAttachfjyManager.getPicContent(FILEID, "");
		request.setAttribute("list", list);
		return SHOW_PIC;
	}

	public void editFile() throws IOException {
		HttpServletRequest request = ServletActionContext.getRequest();

		String FILEID = "";
		if (request.getParameter("FILEID") != null)
			FILEID = request.getParameter("FILEID");
		
		
		String deptid = "";
		String sqlWhere = "";
		MyUserDetails userDetail = null;
		userDetail = SpringTagFunctions.getUserDetails();
		if (userDetail != null) {
			deptid = userDetail.getDeptID();
		}
		if (!SpringTagFunctions.ifAnyGranted("ROLE_QUERY_ALL,ROLE_ADMIN")) {
			sqlWhere = " and FILEGROUP = 'SS_NOTICE_FILE' and   relation_id in ( select NOTICEID  from SS_NOTICE  where SENDUNITID = '"+deptid+"' ) ";
		}
		
		if (affix != null) {
			int j = 0;
			for (; j < affix.size(); j++) {
				String fileName = affixFileNames.get(j);
				String nameWithoutExt = getNameWithoutExtension(fileName);
				String ext = getExtension(fileName);
				String ContentType = affixContentTypes.get(j);
				long fileSize = affix.get(j).length();
				fileAttachfjyManager.updateFile(affix.get(j), fileName,
						ContentType, fileSize, ext, FILEID, sqlWhere);

			}
		}
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("text/html;charset=GBK");
		try {
			response.setContentType("text/html;charset=GBK");
			response.getWriter().print(
					"<script>alert(\" 修改成功！ \");window.close();</script>");
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public void editPict() throws IOException {
		HttpServletRequest request = ServletActionContext.getRequest();

		String FILEID = "";
		if (request.getParameter("FILEID") != null)
			FILEID = request.getParameter("FILEID");
		
		String deptid = "";
		String sqlWhere = "";
		MyUserDetails userDetail = null;
		userDetail = SpringTagFunctions.getUserDetails();
		if (userDetail != null) {
			deptid = userDetail.getDeptID();
		}
		if (!SpringTagFunctions.ifAnyGranted("ROLE_QUERY_ALL,ROLE_ADMIN")) {
			sqlWhere = " and FILEGROUP = 'SS_NOTICE_PIC' and   relation_id in ( select NOTICEID  from SS_NOTICE  where SENDUNITID = '"+deptid+"' ) ";
		}
		
		int i = 0;
		for (File u : upload) {
			Integer obj = new Integer(i);
			String str_ojb = obj.toString();
			String fileName = uploadFileName.get(i);
			String nameWithoutExt = getNameWithoutExtension(fileName);
			String ext = getExtension(fileName);
			String ContentType = uploadContentType.get(i);
			long fileSize = upload.get(i).length();
			fileAttachfjyManager.updateFile(upload.get(i), nameWithoutExt,
					ContentType, fileSize, ext, FILEID, sqlWhere);

			i++;
		}
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("text/html;charset=GBK");
		try {
			response.setContentType("text/html;charset=GBK");
			response.getWriter().print(
					"<script>alert(\" 修改成功！ \");window.close();</script>");
		} catch (Exception ex) {

		}
	}

	public String deletePict() {
		HttpServletRequest request = ServletActionContext.getRequest();
		String FILEID = "";
		if (request.getParameter("FILEID") != null)
			FILEID = request.getParameter("FILEID");
		
		String deptid = "";
		String sqlWhere = "";
		MyUserDetails userDetail = null;
		userDetail = SpringTagFunctions.getUserDetails();
		if (userDetail != null) {
			deptid = userDetail.getDeptID();
		}
		if (!SpringTagFunctions.ifAnyGranted("ROLE_QUERY_ALL,ROLE_ADMIN")) {
			sqlWhere = " and FILEGROUP = 'SS_NOTICE_PIC' and   relation_id in ( select NOTICEID  from SS_NOTICE  where SENDUNITID = '"+deptid+"' ) ";
		}
		
		fileAttachfjyManager.removebyFileID(FILEID,sqlWhere);
		return deleteReturnUrl;
	}

	public String deleteFile() {
		HttpServletRequest request = ServletActionContext.getRequest();
		String FILEID = "";
		if (request.getParameter("FILEID") != null)
			FILEID = request.getParameter("FILEID");
		
		String deptid = "";
		String sqlWhere = "";
		MyUserDetails userDetail = null;
		userDetail = SpringTagFunctions.getUserDetails();
		if (userDetail != null) {
			deptid = userDetail.getDeptID();
		}
		if (!SpringTagFunctions.ifAnyGranted("ROLE_QUERY_ALL,ROLE_ADMIN")) {
			sqlWhere = " and FILEGROUP = 'SS_NOTICE_FILE' and   relation_id in ( select NOTICEID  from SS_NOTICE  where SENDUNITID = '"+deptid+"' ) ";
		}
		
		fileAttachfjyManager.removebyFileID(FILEID, sqlWhere);
		return deleteReturnUrl;
	}
	
	/** 执行搜索 */
	public String tzReplylist() {
		
		HttpServletRequest request = ServletActionContext.getRequest();	
	    String noticeid = "";
		if (request.getParameter("noticeid") != null)
			noticeid = request.getParameter("noticeid");
		List list = (List) ssNoticeManager.getDeptSeq(noticeid);
		String sqlWhere = " 1 != 1 or ";
		if (list != null && list.size() > 0) {
			for (int i = 0; i < list.size(); i++) {
				Map results = (HashMap) list.get(i);
				String deptseq = (String) results.get("deptseq");
				if(i == list.size()-1)
					sqlWhere = sqlWhere + " deptseq like '"+deptseq+"%' ";
				else
				    sqlWhere = sqlWhere + " deptseq like '"+deptseq+"%'" +" or ";
			}
		} else {
			sqlWhere = " 1 != 1  ";
		}
		  
			// //通知回执旅馆数量
			int tzReplyHotelCount = ssNoticeManager.getTzReplyHotelCount(noticeid);
			//通知没有回执旅馆数量
			int tzNoReplyHotelCount = ssNoticeManager.getTzNoReplyHotelCount(sqlWhere,noticeid);
          
			Integer obj1 =new Integer(tzReplyHotelCount);
			Integer obj2 =new Integer(tzNoReplyHotelCount);
			
			
			request.setAttribute("tzReplyHotelCount", obj1.toString());
			request.setAttribute("tzNoReplyHotelCount", obj2.toString());
			request.setAttribute("noticeid", noticeid);
		
		return TZReplySTAT_JSP;
	}
	
	public String listtz() {
		PageRequest<Map> pageRequest = newPageRequest(DEFAULT_SORT_COLUMNS);
		HttpServletRequest request = ServletActionContext.getRequest();
		String noticeid = "";
		if (request.getParameter("noticeid") != null)
			noticeid = request.getParameter("noticeid");
		
	
		Page page = ssNoticeManager.findByPageRequestReplyNotice(pageRequest,noticeid);
		savePage(page,pageRequest);
		return LISTTZREPLY_JSP;
	}
	
	public String listNoReplytz() {
		PageRequest<Map> pageRequest = newPageRequest(DEFAULT_SORT_COLUMNS);
		HttpServletRequest request = ServletActionContext.getRequest();	
	    String noticeid = "";
		if (request.getParameter("noticeid") != null)
			noticeid = request.getParameter("noticeid");
		List list = (List) ssNoticeManager.getDeptSeq(noticeid);
		String sqlWhere = " 1 != 1 or ";
		if (list != null && list.size() > 0) {
			for (int i = 0; i < list.size(); i++) {
				Map results = (HashMap) list.get(i);
				String deptseq = (String) results.get("deptseq");
				if(i == list.size()-1)
					sqlWhere = sqlWhere + " deptseq like '"+deptseq+"%' ";
				else
				    sqlWhere = sqlWhere + " deptseq like '"+deptseq+"%'" +" or ";
			}
		} else {
			sqlWhere = " 1 != 1  ";
		}
		
		pageRequest.getFilters().put("noticeid",noticeid); 
		pageRequest.getFilters().put("sqlWhere",sqlWhere); 
		  
		Page page = ssNoticeManager.findByPageRequesttzNoReply(pageRequest);
		savePage(page,pageRequest);
		return LISTTZNOREPLY_JSP;
	}
	
	public String getNoticeNumber(){
		HttpServletRequest request = ServletActionContext.getRequest();	
		
		
		String s_noticetitle = null;
		String s_state = null;
		String s_authorid = null;
		String s_sendunitid = null;
		String s_starttimeBegin = null;
		String s_starttimeEnd = null;
		String s_endtimeBegin = null;
		String s_endtimeEnd = null;
		
		if(request.getParameter("s_noticetitle") != null)
			s_noticetitle = request.getParameter("s_noticetitle");
		if(request.getParameter("s_state") != null)
			s_state = request.getParameter("s_state");
		if(request.getParameter("s_authorid") != null)
			s_authorid = request.getParameter("s_authorid");
		if(request.getParameter("s_sendunitid") != null)
			s_sendunitid = request.getParameter("s_sendunitid");
		if(request.getParameter("s_starttimeBegin") != null)
			s_starttimeBegin = request.getParameter("s_starttimeBegin");
		if(request.getParameter("s_starttimeEnd") != null)
			s_starttimeEnd = request.getParameter("s_starttimeEnd");
		if(request.getParameter("s_endtimeBegin") != null)
			s_endtimeBegin = request.getParameter("s_endtimeBegin");
		if(request.getParameter("s_endtimeEnd") != null)
			s_endtimeEnd = request.getParameter("s_endtimeEnd");
		
		String sqlWhere = " ";
		if(StringUtils.isNotEmpty(s_noticetitle))
			sqlWhere = sqlWhere +" and noticetitle like '%"+s_noticetitle+"%' " ;
		if(StringUtils.isNotEmpty(s_state))
			sqlWhere = sqlWhere +" and t.STATE = '"+s_state+"' " ;
		if(StringUtils.isNotEmpty(s_authorid))
			sqlWhere = sqlWhere +" and c.fullname like '%"+s_authorid+"%' " ;
		if(StringUtils.isNotEmpty(s_sendunitid))
			sqlWhere = sqlWhere +" and b.deptname like '%"+s_sendunitid+"%' " ;
		if(StringUtils.isNotEmpty(s_starttimeBegin) && s_starttimeBegin != null && s_starttimeBegin.length() > 0)
			sqlWhere = sqlWhere +" and t.STARTTIME >= to_date('"+s_starttimeBegin+" 00:00:00','yyyy-MM-dd HH24:mi:ss') " ;
		if(StringUtils.isNotEmpty(s_starttimeEnd) && s_starttimeEnd != null && s_starttimeEnd.length() > 0)
			sqlWhere = sqlWhere +" and t.STARTTIME <= to_date('"+s_starttimeEnd+" 23:59:59','yyyy-MM-dd HH24:mi:ss') " ;
		if(StringUtils.isNotEmpty(s_endtimeBegin) && s_endtimeBegin != null && s_endtimeBegin.length() > 0)
			sqlWhere = sqlWhere +" and t.ENDTIME >= to_date('"+s_endtimeBegin+" 00:00:00','yyyy-MM-dd HH24:mi:ss') " ;
		if(StringUtils.isNotEmpty(s_endtimeEnd) && s_endtimeEnd != null && s_endtimeEnd.length() > 0)
			sqlWhere = sqlWhere +" and t.ENDTIME <= to_date('"+s_endtimeEnd+" 23:59:59','yyyy-MM-dd HH24:mi:ss') " ;
		
		
		String dateSelect2 = "";
		if (request.getParameter("dateSelect2") != null)
		    dateSelect2 = request.getParameter("dateSelect2");
			request.setAttribute("dateSelect2",dateSelect2);		        
		String dateSelect3 = "";
		if (request.getParameter("dateSelect3") != null)
		    dateSelect3 = request.getParameter("dateSelect3");
			request.setAttribute("dateSelect3",dateSelect3);		        
		String dateSelect7 = "";
		if (request.getParameter("dateSelect7") != null)
		    dateSelect7 = request.getParameter("dateSelect7");
			request.setAttribute("dateSelect7",dateSelect7);	
		
		 
		
		
		String username = "";
		String deptid = "";
		String deptSeq = "";
		String deptTypeID = "";
		MyUserDetails userDetail = null;
		userDetail = SpringTagFunctions.getUserDetails();
		if (userDetail != null) {
			username = userDetail.getUsername();
			deptid = userDetail.getDeptID();
			deptSeq = userDetail.getDeptSeq();
			deptTypeID = userDetail.getDeptTypeID();
		}
		
		String deptTypeIDWhere = "";
		if(deptTypeID != null && deptTypeID.length() > 0){
			if(deptTypeID.equals("0"))
				deptTypeIDWhere = " and  b.DEPTTYPEID in (select code  from t_dic_cptype )";
			else
				deptTypeIDWhere = " and b.DEPTTYPEID in ('0','"+deptTypeID+"')";
		} else {
			    deptTypeIDWhere = " and b.DEPTTYPEID = 0";
		}
		dateSelectMap  = DateUtil.getDateSelectData();
		String query = " select count(*) from (select  "
			+" distinct  t.NOTICEID as noticeid,"
			+" NOTICETITLE as noticetitle,"
			+" NOTICECONTENT as noticecontent,"
			+" STARTTIME as starttime,"
			+" ENDTIME as endtime,"
			+" t.STATE as state,"
			+" AUTHORID as authorid,"
			+" SENDUNITID as sendunitid,"
			+" t.CREATETIME as createtime,"
			+" ISREPLY as isreply,"
			+" ISSUESCOPE as issuescope,"
			+" PARTICIPANTS as participants,"
			+" SORTNO as sortno,"
			+" c.fullname as authorname,"
			+" b.deptname as sendunitname, "
			+" (case  when t.noticeid not in (select noticeid from ss_notice_reply where deptid='"+deptid+"')  then  null else  0  end) as readflag "
			+" from SS_NOTICE t,SS_dept b ,SS_user c,SS_NOTICE_ATTEND d ,ss_notice_reply r";
			query = query + "   where t.authorid = c.username  " +deptTypeIDWhere+
					" and t.STATE = 1 and t.STARTTIME <= sysdate and t.ENDTIME >= sysdate  " +
		    " and t.sendunitid = b.deptid   and d.NOTICEID = t.NOTICEID   and t.noticeid = r.noticeid(+) "; 
		    if(StringUtils.isNotEmpty(sqlWhere)){
		    	query += sqlWhere;
		    }
		    
		    
		    query +=" and ( " ;
			
			 StringBuffer sb = new StringBuffer(query);
			 if(StringUtils.isNotEmpty(username))
	         {
				 StringBuffer buff = new StringBuffer(" ( d.isdept = 0 and d.userid = '"+username+"') "); 
				 sb.append(buff.toString());
	         }
            if(StringUtils.isNotEmpty(deptSeq))
            {
                StringBuffer buff = new StringBuffer(deptSeq.replace(".", ","));
                buff.deleteCharAt(0);
                buff.deleteCharAt(buff.length() - 1);
                sb.append((new StringBuilder(" or (d.DEPTID  in (")).append(buff.toString()).append(") and d.isdept = 1 )").toString());
            }
            sb.append(" )  )");
            
			String ajax=request.getParameter("ajax");
			StringBuffer htmls=new StringBuffer();
			
			int nb=ssNoticeManager.getNoticeNumber(sb.toString());
			if(nb>0)
			htmls.append(nb);
			
			String html = htmls.toString();
	        if (html == null) {
	            return null;
	        }
	        if(ajax!=null && ajax.equals("true")){
		        try {
		            byte[] contents = html.getBytes("UTF-8");
		            getResponse().getOutputStream().write(contents);
		        } catch (IOException e) {
		            e.printStackTrace();
		        }
		        return null;
	        }

			return html;
		}
	
	

}
