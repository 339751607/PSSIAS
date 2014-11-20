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

import com.dyneinfo.zazh.service.SsCommonManager;
import com.dyneinfo.zazh.service.SsUserManager;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.Preparable;

public class outlookRightAction extends BaseStruts2Action implements Preparable {
	//默认多列排序,example: username desc,createTime asc
	protected static final String DEFAULT_SORT_COLUMNS = null;

	protected static final String LIST_TOP_RIGHT = "/pages/outlookmenu/Copyright.jsp";

	protected static final String LIST_LOGIN = "/login.jsp";

	private SsCommonManager ssCommonManager;

	private SsUserManager ssUserManager;

	public void prepare() throws Exception {

	}
	
	public SsUserManager getSsUserManager() {
		return ssUserManager;
	}

	public void setSsUserManager(SsUserManager ssUserManager) {
		this.ssUserManager = ssUserManager;
	}

	public String topRight() throws Exception {
		HttpServletRequest request = ServletActionContext.getRequest();
		ActionContext ac = ActionContext.getContext();
//		Map map = ac.getContextMap();
		
		String username = "";
		String deptid = "";
		String deptSeq = "";
		String deptleve = "";

		//用户总数
		int userTotal = ssUserManager.getEnabledUserCount().intValue();
        request.setAttribute("usertotal", userTotal);	    
       // map.put("userTotal", userTotal);
	    //在线用户数
        SessionUserCount userCount = new SessionUserCount();
	    request.setAttribute("usercount", userCount.getCount());
	 //   map.put("usercount", userCount.getCount());
		MyUserDetails userDetail = null;
		userDetail = SpringTagFunctions.getUserDetails();
		if (userDetail != null) {
			username = userDetail.getUsername();
			deptid = userDetail.getDeptID();
			deptSeq = userDetail.getDeptSeq();
			deptleve = userDetail.getDeptLevel();

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

}
