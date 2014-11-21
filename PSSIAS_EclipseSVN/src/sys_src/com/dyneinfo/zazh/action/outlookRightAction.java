package com.dyneinfo.zazh.action;

import java.util.Map;

import javacommon.base.BaseStruts2Action;
import javacommon.base.CustomerContextHolder;

import javax.servlet.http.HttpServletRequest;

import net.java.dev.common.util.SpringTagFunctions;

import org.apache.commons.lang.StringUtils;
import org.apache.struts2.ServletActionContext;
import org.security.userdetails.MyUserDetails;
import org.security.userdetails.jdbc.SessionUserCount;


import com.dyneinfo.zazh.model.SsDatasource;
import com.dyneinfo.zazh.service.SsCommonManager;
import com.dyneinfo.zazh.service.SsDatasourceManager;
import com.opensymphony.xwork2.ModelDriven;
import com.opensymphony.xwork2.Preparable;

public class outlookRightAction extends BaseStruts2Action implements Preparable {
	//默认多列排序,example: username desc,createTime asc
	protected static final String DEFAULT_SORT_COLUMNS = null;

	protected static final String LIST_TOP_RIGHT = "/pages/outlookmenu/Copyright.jsp";

	protected static final String LIST_LOGIN = "/login.jsp";

	private SsCommonManager ssCommonManager;
	
	private SsDatasourceManager ssDatasourceManager;

	public void prepare() throws Exception {
	}

	public String topRight() throws Exception {
		HttpServletRequest request = ServletActionContext.getRequest();
		String username = "";
		String deptid = "";
		String deptSeq = "";
		String deptleve = "";
		
		//用户总数
		String sql="SELECT COUNT(*) FROM SS_USER WHERE ENABLED='1' ";
		int userTotal = ssDatasourceManager.getCountForSQL(sql).intValue();
        request.setAttribute("usertotal", userTotal);	    
	    //在线用户数
        SessionUserCount userCount = new SessionUserCount();
	    request.setAttribute("usercount", userCount.getCount());

		MyUserDetails userDetail = null;
		userDetail = SpringTagFunctions.getUserDetails();
		if (userDetail != null) {
			username = userDetail.getUsername();
			deptid = userDetail.getDeptID();
			deptSeq = userDetail.getDeptSeq();
			deptleve = userDetail.getDeptLevel();
			request.getSession().setAttribute("deptId", deptid);
			request.getSession().setAttribute("deptleve", deptleve);
			request.getSession().setAttribute("parentId", userDetail.getDeptParentID());

		}
		if (StringUtils.isNotEmpty(username) && StringUtils.isNotEmpty(deptSeq)) {

		} else {
			return LIST_LOGIN;
		}

		CustomerContextHolder.clearCustomerType();
		return LIST_TOP_RIGHT;
	}


	public void setSsCommonManager(SsCommonManager ssCommonManager) {
		this.ssCommonManager = ssCommonManager;
	}

	public void setSsDatasourceManager(SsDatasourceManager ssDatasourceManager) {
		this.ssDatasourceManager = ssDatasourceManager;
	}

	
}
