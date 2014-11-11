package com.dyneinfo.zazh.action;

import javacommon.base.BaseStruts2Action;
import javacommon.base.CustomerContextHolder;

import javax.servlet.http.HttpServletRequest;

import net.java.dev.common.dict.taglib.DictHelpImpl;
import net.java.dev.common.util.SpringTagFunctions;
import org.apache.commons.lang.StringUtils;
import org.apache.struts2.ServletActionContext;
import org.security.userdetails.MyUserDetails;

import com.action.Registered;
import com.dyneinfo.zazh.service.SsCommonManager;
import com.opensymphony.xwork2.Preparable;

public class outlookRightAction extends BaseStruts2Action implements Preparable {
	//默认多列排序,example: username desc,createTime asc
	protected static final String DEFAULT_SORT_COLUMNS = null;

	protected static final String LIST_TOP_RIGHT = "/pages/outlookmenu/Copyright.jsp";

	protected static final String LIST_LOGIN = "/login.jsp";

	private SsCommonManager ssCommonManager;

	public void prepare() throws Exception {

	}

	public String topRight() throws Exception {
		HttpServletRequest request = ServletActionContext.getRequest();
		String username = "";
		String deptid = "";
		String deptSeq = "";
		String deptleve = "";

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
