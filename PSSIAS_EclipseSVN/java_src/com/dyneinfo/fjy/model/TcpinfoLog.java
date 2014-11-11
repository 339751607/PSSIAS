/*
 * Powered By [lishicheng]
 */

package com.dyneinfo.fjy.model;

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

import com.dyneinfo.fjy.model.*;
import com.dyneinfo.fjy.dao.*;
import com.dyneinfo.fjy.service.*;

/**
 * @author lisc email:lishicheng(a)gmail.com
 */


public class TcpinfoLog extends BaseEntity {
	
	//alias
	public static final String TABLE_ALIAS = "TcpinfoLog";
	public static final String ALIAS_CPCODE = "企业编号";
	public static final String ALIAS_USERID = "操作人";
	public static final String ALIAS_DEPTID = "操作人单位编号";
	public static final String ALIAS_TYPE = "操作类型";
	public static final String ALIAS_LOGID = "logID";
	public static final String ALIAS_DEPTNAME = "操作人单位名称";
	public static final String ALIAS_USERNAME = "操作人名字";
	public static final String ALIAS_UPDATEDATE = "操作时间";
	
	//date formats
	public static final String FORMAT_UPDATEDATE = DATE_TIME_FORMAT;
	
	//columns START
	private java.lang.String cpcode;
	private java.lang.String userid;
	private java.lang.String deptid;
	private java.lang.String type;
	private Long logid;
	private java.lang.String deptname;
	private java.lang.String username;
	private java.util.Date updatedate;
	//columns END

	public TcpinfoLog(){
	}

	public TcpinfoLog(
		Long logid
	){
		this.logid = logid;
	}

	public void setCpcode(java.lang.String value) {
		this.cpcode = value;
	}
	
	public java.lang.String getCpcode() {
		return this.cpcode;
	}
	public void setUserid(java.lang.String value) {
		this.userid = value;
	}
	
	public java.lang.String getUserid() {
		return this.userid;
	}
	public void setDeptid(java.lang.String value) {
		this.deptid = value;
	}
	
	public java.lang.String getDeptid() {
		return this.deptid;
	}
	public void setType(java.lang.String value) {
		this.type = value;
	}
	
	public java.lang.String getType() {
		return this.type;
	}
	public void setLogid(Long value) {
		this.logid = value;
	}
	
	public Long getLogid() {
		return this.logid;
	}
	public void setDeptname(java.lang.String value) {
		this.deptname = value;
	}
	
	public java.lang.String getDeptname() {
		return this.deptname;
	}
	public void setUsername(java.lang.String value) {
		this.username = value;
	}
	
	public java.lang.String getUsername() {
		return this.username;
	}
	public String getUpdatedateString() {
		return date2String(getUpdatedate(), FORMAT_UPDATEDATE);
	}
	public void setUpdatedateString(String value) {
		setUpdatedate(string2Date(value, FORMAT_UPDATEDATE,java.util.Date.class));
	}
	
	public void setUpdatedate(java.util.Date value) {
		this.updatedate = value;
	}
	
	public java.util.Date getUpdatedate() {
		return this.updatedate;
	}

	public String toString() {
		return new ToStringBuilder(this)
			.append("Cpcode",getCpcode())
			.append("Userid",getUserid())
			.append("Deptid",getDeptid())
			.append("Type",getType())
			.append("Logid",getLogid())
			.append("Deptname",getDeptname())
			.append("Username",getUsername())
			.append("Updatedate",getUpdatedate())
			.toString();
	}
	
	public int hashCode() {
		return new HashCodeBuilder()
			.append(getCpcode())
			.append(getUserid())
			.append(getDeptid())
			.append(getType())
			.append(getLogid())
			.append(getDeptname())
			.append(getUsername())
			.append(getUpdatedate())
			.toHashCode();
	}
	
	public boolean equals(Object obj) {
		if(obj instanceof TcpinfoLog == false) return false;
		if(this == obj) return true;
		TcpinfoLog other = (TcpinfoLog)obj;
		return new EqualsBuilder()
			.append(getCpcode(),other.getCpcode())
			.append(getUserid(),other.getUserid())
			.append(getDeptid(),other.getDeptid())
			.append(getType(),other.getType())
			.append(getLogid(),other.getLogid())
			.append(getDeptname(),other.getDeptname())
			.append(getUsername(),other.getUsername())
			.append(getUpdatedate(),other.getUpdatedate())
			.isEquals();
	}
}

