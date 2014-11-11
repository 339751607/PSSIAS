/*
 * Powered By [lishicheng]
 */

package com.dyneinfo.jxy.action;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Hashtable;
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

import cn.org.rapid_framework.page.Page;
import cn.org.rapid_framework.page.PageRequest;
import cn.org.rapid_framework.web.util.HttpUtils;

import com.dyneinfo.jxy.model.SsNotice;
import com.dyneinfo.jxy.model.SsNoticeAttend;
import com.dyneinfo.jxy.service.FileAttachjxyManager;
import com.dyneinfo.jxy.service.SsNoticeAttendjxyManager;
import com.dyneinfo.jxy.service.SsNoticejxyManager;
import com.dyneinfo.zazh.model.FileAttach;
import com.dyneinfo.zazh.service.SsCommonManager;
import com.opensymphony.xwork2.ModelDriven;
import com.opensymphony.xwork2.Preparable;

/**
 * @author lisc email:lishicheng(a)gmail.com
 */


public class SsNoticeAction extends BaseStruts2Action implements Preparable,ModelDriven{

	//默认多列排序,example: username desc,createTime asc
	protected static final String DEFAULT_SORT_COLUMNS = " CREATETIME desc "; 
	
	//forward paths
	protected static final String QUERY_JSP = "/pages/jxy/SsNotice/query.jsp";
	protected static final String LIST_JSP= "/pages/jxy/SsNotice/list.jsp";
	protected static final String CREATE_JSP = "/pages/jxy/SsNotice/create.jsp";
	protected static final String EDIT_JSP = "/pages/jxy/SsNotice/edit.jsp";
	protected static final String SHOW_JSP = "/pages/jxy/SsNotice/show.jsp";
	protected static final String SHOW_PIC = "/pages/jxy/FileAttach/showPict.jsp";
	protected static final String UPDATEPHOTOERROR = "/pages/jxy/pic/updateFileError.jsp";
	//redirect paths,startWith: !
	protected static final String LIST_ACTION = "!/jxy/SsNotice/list.do";
	
	protected static final String LISTPOP_JSP= "/pages/jxy/SsNotice/listPop.jsp";
	protected static final String LISTUSER_JSP= "/pages/jxy/SsNotice/listUser.jsp";
	protected static final String SHOWPOP_JSP = "/pages/jxy/SsNotice/showPop.jsp";
	protected static final String SHOWUSER_JSP = "/pages/jxy/SsNotice/showUser.jsp";
	
	private SsNoticejxyManager ssNoticejxyManager;
	private SsNoticeAttendjxyManager ssNoticeAttendjxyManager;
	
	private FileAttachjxyManager fileAttachManager;

	private FileAttach fileAttach;
	private SsNotice ssNotice;
	java.lang.Long id = null;
	private String[] items;
	private String returnUrl;  //返回列表，保留查询条件
	private TreeMap<String, String> dateSelectMap;// //日期选择
	
	private String deleteReturnUrl;
	private long maxSize = 5 * 1024 * 1024; //字节
	String username = "";
	String deptid = "";
	String deptSeq = "";


	
	//照片上传 start
	private List<File> uploads = new ArrayList<File>();
	private List<String> uploadFileNames = new ArrayList<String>();
	private List<String> uploadContentTypes = new ArrayList<String>();

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

	//照片上传 end

	//附件
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

	//附件 end

	public void prepare() throws Exception {
		HttpServletRequest request = ServletActionContext.getRequest();
		DateUtil tt = new DateUtil();   
		
	    request.setAttribute("date", tt.getNowTime("yyyy-MM-dd"));
		
		
		
		
		
		
		MyUserDetails userDetail = null;
		userDetail = SpringTagFunctions.getUserDetails();
		if (userDetail != null) {
			username = userDetail.getUsername();
			deptid = userDetail.getDeptID();
			deptSeq = userDetail.getDeptSeq();

		}
		if (isNullOrEmptyString(id)) {
			ssNotice = new SsNotice();
		} else {
			ssNotice = (SsNotice)ssNoticejxyManager.getSsNoticeById(id);
		}
	}
	
	/** 增加setXXXX()方法,spring就可以通过autowire自动设置对象属性 */
	public void setSsNoticejxyManager(SsNoticejxyManager manager) {
		this.ssNoticejxyManager = manager;
	}	
	public void setSsNoticeAttendjxyManager(SsNoticeAttendjxyManager manager) {
		this.ssNoticeAttendjxyManager = manager;
	}	
	
	public void setFileAttachjxyManager(FileAttachjxyManager manager) {
		this.fileAttachManager = manager;
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
	public String htadlist() {
		PageRequest<Map> pageRequest = newPageRequest(DEFAULT_SORT_COLUMNS);
		HttpServletRequest request = ServletActionContext.getRequest();
		//pageRequest.getFilters().put("key",value);     //add custom filter
		
		 String deptseq = "";
			MyUserDetails userDetail = null;
			userDetail = SpringTagFunctions.getUserDetails();
			if (userDetail != null) {
				username = userDetail.getUserName();
				deptid = userDetail.getDeptID();
				deptseq = userDetail.getDeptSeq();
			}
			pageRequest.getFilters().put("deptseq", deptseq);
		
		
		
		if(!SpringTagFunctions.ifAnyGranted("ROLE_HT_ADMIN,ROLE_ADMIN")){
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
		
		Page page = ssNoticejxyManager.findByPageRequest(pageRequest);
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
			sqlWhere = sqlWhere +" and STATE = '"+s_state+"' " ;
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
		if(StringUtils.isNotEmpty(s_starttimeEnd) && s_starttimeEnd != null && s_starttimeEnd.length() > 0)
			sqlWhere = sqlWhere +" and t.ENDTIME <= to_date('"+s_endtimeEnd+" 23:59:59','yyyy-MM-dd HH24:mi:ss') " ;

		MyUserDetails userDetail = null;
		userDetail = SpringTagFunctions.getUserDetails();

		

		dateSelectMap  = DateUtil.getDateSelectData();
		String dateSelect2 = "";
		if (request.getParameter("dateSelect2") != null)
		    dateSelect2 = request.getParameter("dateSelect2");
			request.setAttribute("dateSelect2",dateSelect2);		        
		String dateSelect3 = "";
		if (request.getParameter("dateSelect3") != null)
		    dateSelect3 = request.getParameter("dateSelect3");
			request.setAttribute("dateSelect3",dateSelect3);	
		    		
        	Page page = ssNoticejxyManager.findByPageRequestUser(userDetail,pageRequest,null);
		savePage(page,pageRequest);
		return LISTUSER_JSP;
	}
	
	
	public String listPop() {
		PageRequest<Map> pageRequest = newPageRequest(DEFAULT_SORT_COLUMNS);
		HttpServletRequest request = ServletActionContext.getRequest();

		MyUserDetails userDetail = null;
		userDetail = SpringTagFunctions.getUserDetails();
	
		Page page = ssNoticejxyManager.findByPageRequestUser(userDetail,pageRequest,"");
		savePage(page,pageRequest);
		return LISTPOP_JSP;
	}
	/** 执行搜索 */
	public String listNotice() throws Exception{
	
		PageRequest<Map> pageRequest = newPageRequest(DEFAULT_SORT_COLUMNS);
		HttpServletRequest request = ServletActionContext.getRequest();
		String ajax=request.getParameter("ajax");
		MyUserDetails userDetail = null;
		userDetail = SpringTagFunctions.getUserDetails();
		StringBuffer htmls=new StringBuffer();
		List list=ssNoticejxyManager.getByNoticeByUser(userDetail);


		for(int i=0;i<list.size();i++){
			Map map=(Map)list.get(i);
			if(map.get("authorname")!=null&&map.get("noticetitle")!=null){
				htmls.append("<b>");
				htmls.append(map.get("authorname").toString().trim());
				htmls.append("：</b>");
				htmls.append(map.get("noticetitle").toString().trim());
				htmls.append("&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;");
			}
			
		}

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
	/** 查看对象*/
	public String show() {
		HttpServletRequest request = ServletActionContext.getRequest();
		//发布范围（单位） 
		String deptIdStr="",deptNameStr="";
		String usernameStr="",fullnameStr="";
		List orgList = (List) ssNoticejxyManager.getNotice_issuescope(ssNotice.getNoticeid());
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
		List userList = (List) ssNoticejxyManager.getNotice_participants(ssNotice.getNoticeid());
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
			List listfile = (List) fileAttachManager.getFile("D",
					"SS_NOTICE_FILE", noticeid, "");
			request.setAttribute("listfile", listfile);
		}

		return SHOW_JSP;
	}
	
	public String showPop() {
		HttpServletRequest request = ServletActionContext.getRequest();
		String noticeid = "";
		if (request.getParameter("noticeid") != null)
			noticeid = request.getParameter("noticeid");
		if (noticeid != null && noticeid.length() > 0) {
			List listfile = (List) fileAttachManager.getFile("D",
					"SS_NOTICE_FILE", noticeid, "");
			request.setAttribute("listfile", listfile);
		}
		
		return SHOWPOP_JSP;
	}
	
	public String showUser() {
		HttpServletRequest request = ServletActionContext.getRequest();
		String noticeid = "";
		if (request.getParameter("noticeid") != null)
			noticeid = request.getParameter("noticeid");
		if (noticeid != null && noticeid.length() > 0) {
			List listfile = (List) fileAttachManager.getFile("D",
					"SS_NOTICE_FILE", noticeid, "");
			request.setAttribute("listfile", listfile);
			int cont=ssNoticejxyManager.getNoticeReplyById(noticeid,deptid);
			if(cont>0){
				request.setAttribute("tips", "1");
			}
			
		}
		
		return SHOWUSER_JSP;
	}
	
	/** 进入新增页面*/
	public String create() {
		Date date = new Date();
		SimpleDateFormat format_inserttime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String str_inserttime = format_inserttime.format(date);
        
             
        
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
		
		String deptID = "";
		String username = "";
		MyUserDetails userDetail = null;
		userDetail = SpringTagFunctions.getUserDetails();
		if (userDetail != null) {
			deptID = userDetail.getDeptID();
			username = userDetail.getUsername();
		}
		Date date = new Date();
		SimpleDateFormat format_file_CREATETIME = new SimpleDateFormat(
				"yyyy-MM-dd HH:mm:ss");
		String str_file_CREATETIME = format_file_CREATETIME.format(date);
	
			if (affix != null) {
				int j = 0;
				for (; j < affix.size(); j++) {
					if (affix.get(j).length() <= 0) {
						request.setAttribute("message", "上传的文件不能为空！");
						continue; 
					}
					if (maxSize > 0 && affix.get(j).length() > maxSize) {
						request.setAttribute("message", "上传的单个文件不能超过" + maxSize/1024/1024
								+ "M！");
						return UPDATEPHOTOERROR; 
					}
				}
			}
		
		ssNoticejxyManager.save(ssNotice);
		//ISSUESCOPE 发布范围0则代表全部部门存放所有的参与部门ID  setIsdept 是否为部门 0 否 1 是
		String issueScopeIds = request.getParameter("issuescope");
		if (StringUtils.isNotEmpty(issueScopeIds)) {
			ssNoticeAttendjxyManager.deleteIssuescope(id);
			String strIssueScopeId[] = issueScopeIds.split(";");
			for (int i = 0; i < strIssueScopeId.length; i++)
				if (StringUtils.isNotEmpty(strIssueScopeId[i])) {
					Long depId = new Long(strIssueScopeId[i]);
					SsNoticeAttend ssNoticeAttend = new SsNoticeAttend();
					ssNoticeAttend.setDeptid(depId);
					ssNoticeAttend.setIsdept(1L);
					ssNoticeAttend.setNoticeid(ssNotice.getNoticeid());
					ssNoticeAttendjxyManager.save(ssNoticeAttend);
				}
		}
		String participantsIds = request.getParameter("participants");
        if(StringUtils.isNotEmpty(participantsIds))
        {
        	ssNoticeAttendjxyManager.deleteParticipants(id);
                String strParticipantsId[] = participantsIds.split(";");
                for(int i = 0; i < strParticipantsId.length; i++)
                    if(StringUtils.isNotEmpty(strParticipantsId[i]))
                    {
    					SsNoticeAttend ssNoticeAttend = new SsNoticeAttend();
    					ssNoticeAttend.setUserid(strParticipantsId[i]);
    					ssNoticeAttend.setIsdept(0L);
    					ssNoticeAttend.setNoticeid(ssNotice.getNoticeid());
    					ssNoticeAttendjxyManager.save(ssNoticeAttend);
                    }
        }
    	if (affix != null) {
    		try {
    			for (int j=0; j < affix.size(); j++) {	
    				String fileName = affixFileNames.get(j);
    				String nameWithoutExt = getNameWithoutExtension(fileName);
    				String ext = getExtension(fileName);
    				int fileSize = (int) affix.get(j).length();
    				Long fileId = fileAttachManager.getSeq();
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
    				fileAttachManager.saveFile(affix.get(j), fileAttach);
    			}
        	}
    		catch (Exception e) {
    			e.printStackTrace();
    		}
    	}
    	
		return returnUrl;////LIST_ACTION;
	}
	
	/**进入更新页面*/
	public String edit() {
		HttpServletRequest request = ServletActionContext.getRequest();
		//发布范围（单位） 
		String deptIdStr="",deptNameStr="";
		String usernameStr="",fullnameStr="";
		List orgList = (List) ssNoticejxyManager.getNotice_issuescope(ssNotice.getNoticeid());
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
		List userList = (List) ssNoticejxyManager.getNotice_participants(ssNotice.getNoticeid());
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
			List listfile = (List) fileAttachManager.getFile("D",
					"SS_NOTICE_FILE", noticeid, "");
			request.setAttribute("listfile", listfile);
		}
		
		return EDIT_JSP;
	}
	
	/**保存更新对象*/
	public String update() {
		HttpServletRequest request = ServletActionContext.getRequest();
		String username = "";
		MyUserDetails userDetail = null;
		userDetail = SpringTagFunctions.getUserDetails();
		if (userDetail != null) {
			username = userDetail.getUsername();
		}
		Date date = new Date();
		SimpleDateFormat format_file_CREATETIME = new SimpleDateFormat(
				"yyyy-MM-dd HH:mm:ss");
		String str_file_CREATETIME = format_file_CREATETIME.format(date);
	
			if (affix != null) {
				int j = 0;
				for (; j < affix.size(); j++) {
					if (affix.get(j).length() <= 0) {
						request.setAttribute("message", "上传的文件不能为空！");
						continue; 
					}
					if (maxSize > 0 && affix.get(j).length() > maxSize) {
						request.setAttribute("message", "上传的单个文件不能超过" + maxSize/1024/1024
								+ "M！");
						return UPDATEPHOTOERROR; 
					}
				}
			}
		ssNoticejxyManager.update(this.ssNotice);
		
		//ISSUESCOPE 发布范围0则代表全部部门存放所有的参与部门ID  setIsdept 是否为部门 0 否 1 是
		String issueScopeIds = request.getParameter("issuescope");
		if (StringUtils.isNotEmpty(issueScopeIds)) {
			ssNoticeAttendjxyManager.deleteIssuescope(id);
			String strIssueScopeId[] = issueScopeIds.split(";");
			for (int i = 0; i < strIssueScopeId.length; i++)
				if (StringUtils.isNotEmpty(strIssueScopeId[i])) {
					Long depId = new Long(strIssueScopeId[i]);
					SsNoticeAttend ssNoticeAttend = new SsNoticeAttend();
					ssNoticeAttend.setDeptid(depId);
					ssNoticeAttend.setIsdept(1L);
					ssNoticeAttend.setNoticeid(ssNotice.getNoticeid());
					ssNoticeAttendjxyManager.save(ssNoticeAttend);
				}
		}
		String participantsIds = request.getParameter("participants");
        if(StringUtils.isNotEmpty(participantsIds))
        {
        	ssNoticeAttendjxyManager.deleteParticipants(id);
                String strParticipantsId[] = participantsIds.split(";");
                for(int i = 0; i < strParticipantsId.length; i++)
                    if(StringUtils.isNotEmpty(strParticipantsId[i]))
                    {
    					SsNoticeAttend ssNoticeAttend = new SsNoticeAttend();
    					ssNoticeAttend.setUserid(strParticipantsId[i]);
    					ssNoticeAttend.setIsdept(0L);
    					ssNoticeAttend.setNoticeid(ssNotice.getNoticeid());
    					ssNoticeAttendjxyManager.save(ssNoticeAttend);
                    }
        }
        if (affix != null) {
        	try {
    			for (int j=0; j < affix.size(); j++) {	
    				String fileName = affixFileNames.get(j);
    				String nameWithoutExt = getNameWithoutExtension(fileName);
    				String ext = getExtension(fileName);
    				int fileSize = (int) affix.get(j).length();
    				Long fileId = fileAttachManager.getSeq();
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
    				fileAttachManager.saveFile(affix.get(j), fileAttach);
    			}
        	}
    		catch (Exception e) {
    			e.printStackTrace();
    		}
        }
    	
		
		return returnUrl;////LIST_ACTION;
	}
	
	/**删除对象*/
	public String delete() {
		for(int i = 0; i < items.length; i++) {
			Hashtable params = HttpUtils.parseQueryString(items[i]);
			java.lang.Long id = new java.lang.Long((String)params.get("noticeid"));
			ssNoticejxyManager.deleteNOTICE_attend(id);
		}
		return returnUrl ;//LIST_ACTION;
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
		List list = (List) fileAttachManager.getPicContent(FILEID, "");
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
		if (!SpringTagFunctions.ifAnyGranted("ROLE_HT_ADMIN,ROLE_ADMIN")) {
			sqlWhere = " and FILEGROUP = 'SS_NOTICE_FILE' and   relation_id in ( select NOTICEID  from SS_NOTICE  where SENDUNITID = '"+deptid+"' ) ";
		}
		
		if (affix != null) {
			int j = 0;
			for (; j < affix.size(); j++) {
				HttpServletResponse response = ServletActionContext.getResponse();
				response.setContentType("text/html;charset=GBK");
				if (maxSize > 0 && affix.get(j).length() > maxSize) {
					
					try {
						response.setContentType("text/html;charset=GBK");
						response.getWriter().print(
								"<script>alert(\" 图片过大修改失败！ \");window.close();</script>");
					} catch (Exception ex) {
						ex.printStackTrace();
					}
				}else{
					String fileName = affixFileNames.get(j);
					String nameWithoutExt = getNameWithoutExtension(fileName);
					String ext = getExtension(fileName);
					String ContentType = affixContentTypes.get(j);
					long fileSize = affix.get(j).length();
					fileAttachManager.updateFile(affix.get(j), fileName,
							ContentType, fileSize, ext, FILEID, sqlWhere);
					
					try {
						response.setContentType("text/html;charset=GBK");
						response.getWriter().print(
								"<script>alert(\" 修改成功！ \");window.close();</script>");
					} catch (Exception ex) {
						ex.printStackTrace();
					}
				}
				
				

			}
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
		if (!SpringTagFunctions.ifAnyGranted("ROLE_HT_ADMIN,ROLE_ADMIN")) {
			sqlWhere = " and FILEGROUP = 'SS_NOTICE_PIC' and   relation_id in ( select NOTICEID  from SS_NOTICE  where SENDUNITID = '"+deptid+"' ) ";
		}
		
		int i = 0;
		for (File u : uploads) {
			Integer obj = new Integer(i);
			String str_ojb = obj.toString();
			String fileName = uploadFileNames.get(i);
			String nameWithoutExt = getNameWithoutExtension(fileName);
			String ext = getExtension(fileName);
			String ContentType = uploadContentTypes.get(i);
			long fileSize = uploads.get(i).length();
			fileAttachManager.updateFile(uploads.get(i), nameWithoutExt,
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
		if (!SpringTagFunctions.ifAnyGranted("ROLE_HT_ADMIN,ROLE_ADMIN")) {
			sqlWhere = " and FILEGROUP = 'SS_NOTICE_PIC' and   relation_id in ( select NOTICEID  from SS_NOTICE  where SENDUNITID = '"+deptid+"' ) ";
		}
		
		fileAttachManager.removebyFileID(FILEID,sqlWhere);
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
		if (!SpringTagFunctions.ifAnyGranted("ROLE_HT_ADMIN,ROLE_ADMIN")) {
			sqlWhere = " and FILEGROUP = 'SS_NOTICE_FILE' and   relation_id in ( select NOTICEID  from SS_NOTICE  where SENDUNITID = '"+deptid+"' ) ";
		}
		
		fileAttachManager.removebyFileID(FILEID, sqlWhere);
		return deleteReturnUrl;
	}
}
