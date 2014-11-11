/*
 * Powered By []
 * Web Site: 
 * 
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
 * @author  email: lee(a)gmail.com
 * @version 1.0
 * @since 1.0
 */


public class SsLogs extends BaseEntity {
	
	//alias
	public static final String TABLE_ALIAS = "登录日志";
	public static final String ALIAS_XH = "序号";
	public static final String ALIAS_LOGINNAME = "登录名";
	public static final String ALIAS_LOGINTIME = "登录时间";
	public static final String ALIAS_IPADDRESS = "IP地址";
	public static final String ALIAS_BROWSER = "浏览器类型";
	public static final String ALIAS_HOSTNAME = "主机名";
	public static final String ALIAS_INVALIDPASSWORD = "错误密码";
	public static final String ALIAS_DEMO = "备注";
	
	//date formats
	
	//columns START
	private java.math.BigDecimal xh;
	private java.lang.String loginname;
	private java.lang.String logintime;
	private java.lang.String ipaddress;
	private java.lang.String browser;
	private java.lang.String hostname;
	private java.lang.String invalidpassword;
	private java.lang.String demo;
	//columns END

	public SsLogs(){
	}

	public SsLogs(
		java.math.BigDecimal xh
	){
		this.xh = xh;
	}

	public void setXh(java.math.BigDecimal value) {
		this.xh = value;
	}
	
	public java.math.BigDecimal getXh() {
		return this.xh;
	}
	public void setLoginname(java.lang.String value) {
		this.loginname = value;
	}
	
	public java.lang.String getLoginname() {
		return this.loginname;
	}
	public void setLogintime(java.lang.String value) {
		this.logintime = value;
	}
	
	public java.lang.String getLogintime() {
		return this.logintime;
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
	public void setInvalidpassword(java.lang.String value) {
		this.invalidpassword = value;
	}
	
	public java.lang.String getInvalidpassword() {
		return this.invalidpassword;
	}
	public void setDemo(java.lang.String value) {
		this.demo = value;
	}
	
	public java.lang.String getDemo() {
		return this.demo;
	}

	public String toString() {
		return new ToStringBuilder(this)
			.append("Xh",getXh())
			.append("Loginname",getLoginname())
			.append("Logintime",getLogintime())
			.append("Ipaddress",getIpaddress())
			.append("Browser",getBrowser())
			.append("Hostname",getHostname())
			.append("Invalidpassword",getInvalidpassword())
			.append("Demo",getDemo())
			.toString();
	}
	
	public int hashCode() {
		return new HashCodeBuilder()
			.append(getXh())
			.append(getLoginname())
			.append(getLogintime())
			.append(getIpaddress())
			.append(getBrowser())
			.append(getHostname())
			.append(getInvalidpassword())
			.append(getDemo())
			.toHashCode();
	}
	
	public boolean equals(Object obj) {
		if(obj instanceof SsLogs == false) return false;
		if(this == obj) return true;
		SsLogs other = (SsLogs)obj;
		return new EqualsBuilder()
			.append(getXh(),other.getXh())
			.append(getLoginname(),other.getLoginname())
			.append(getLogintime(),other.getLogintime())
			.append(getIpaddress(),other.getIpaddress())
			.append(getBrowser(),other.getBrowser())
			.append(getHostname(),other.getHostname())
			.append(getInvalidpassword(),other.getInvalidpassword())
			.append(getDemo(),other.getDemo())
			.isEquals();
	}
}

