/*
 * Powered By [lishicheng]
 */

package com.dyneinfo.zazh.model;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

import java.util.*;

import javacommon.base.*;
import javacommon.util.*;

import cn.org.rapid_framework.util.*;
import cn.org.rapid_framework.web.util.*;
import cn.org.rapid_framework.page.*;
import cn.org.rapid_framework.page.impl.*;

import com.dyneinfo.zazh.model.*;
import com.dyneinfo.zazh.dao.*;
import com.dyneinfo.zazh.service.*;

/**
 * @author lisc email:lishicheng(a)gmail.com
 */


public class LoginHistory extends BaseEntity {
	
	//alias
	public static final String TABLE_ALIAS = "登录日志";
	public static final String ALIAS_LOGINID = "登录ID";
	public static final String ALIAS_LOGINTIME = "登录时间";
	public static final String ALIAS_LOGINNAME = "登录名";
	public static final String ALIAS_ISVALID = "事件";
	public static final String ALIAS_INVALIDPASSWORD = "错误密码";
	public static final String ALIAS_IPADDRESS = "IP地址";
	public static final String ALIAS_BROWSER = "浏览器";
	public static final String ALIAS_HOSTNAME = "主机";
	
	//date formats
	public static final String FORMAT_LOGINTIME = DATE_TIME_FORMAT;
	
	//columns START
	private Long loginid;
	private java.util.Date logintime;
	private java.lang.String loginname;
	private java.lang.String isvalid;
	private java.lang.String invalidpassword;
	private java.lang.String ipaddress;
	private java.lang.String browser;
	private java.lang.String hostname;
	//columns END

	public LoginHistory(){
	}

	public LoginHistory(
		Long loginid
	){
		this.loginid = loginid;
	}

	public void setLoginid(Long value) {
		this.loginid = value;
	}
	
	public Long getLoginid() {
		return this.loginid;
	}
	public String getLogintimeString() {
		return date2String(getLogintime(), FORMAT_LOGINTIME);
	}
	public void setLogintimeString(String value) {
		setLogintime(string2Date(value, FORMAT_LOGINTIME,java.util.Date.class));
	}
	
	public void setLogintime(java.util.Date value) {
		this.logintime = value;
	}
	
	public java.util.Date getLogintime() {
		return this.logintime;
	}
	public void setLoginname(java.lang.String value) {
		this.loginname = value;
	}
	
	public java.lang.String getLoginname() {
		return this.loginname;
	}
	public void setIsvalid(java.lang.String value) {
		this.isvalid = value;
	}
	
	public java.lang.String getIsvalid() {
		return this.isvalid;
	}
	public void setInvalidpassword(java.lang.String value) {
		this.invalidpassword = value;
	}
	
	public java.lang.String getInvalidpassword() {
		return this.invalidpassword;
	}
	public void setIpaddress(java.lang.String value) {
		this.ipaddress = value;
	}
	
	public java.lang.String getIpaddress() {
		return this.ipaddress;
	}
	public void setBrowser(java.lang.String value) {
		this.browser = value;
	}
	
	public java.lang.String getBrowser() {
		return this.browser;
	}
	public void setHostname(java.lang.String value) {
		this.hostname = value;
	}
	
	public java.lang.String getHostname() {
		return this.hostname;
	}

	public String toString() {
		return new ToStringBuilder(this)
			.append("Loginid",getLoginid())
			.append("Logintime",getLogintime())
			.append("Loginname",getLoginname())
			.append("Isvalid",getIsvalid())
			.append("Invalidpassword",getInvalidpassword())
			.append("Ipaddress",getIpaddress())
			.append("Browser",getBrowser())
			.append("Hostname",getHostname())
			.toString();
	}
	
	public int hashCode() {
		return new HashCodeBuilder()
			.append(getLoginid())
			.append(getLogintime())
			.append(getLoginname())
			.append(getIsvalid())
			.append(getInvalidpassword())
			.append(getIpaddress())
			.append(getBrowser())
			.append(getHostname())
			.toHashCode();
	}
	
	public boolean equals(Object obj) {
		if(obj instanceof LoginHistory == false) return false;
		if(this == obj) return true;
		LoginHistory other = (LoginHistory)obj;
		return new EqualsBuilder()
			.append(getLoginid(),other.getLoginid())
			.append(getLogintime(),other.getLogintime())
			.append(getLoginname(),other.getLoginname())
			.append(getIsvalid(),other.getIsvalid())
			.append(getInvalidpassword(),other.getInvalidpassword())
			.append(getIpaddress(),other.getIpaddress())
			.append(getBrowser(),other.getBrowser())
			.append(getHostname(),other.getHostname())
			.isEquals();
	}
}

