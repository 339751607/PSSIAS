/*
 * Powered By [lishicheng]
 */

package com.dyneinfo.jxy.model;

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

import com.dyneinfo.jxy.dao.*;
import com.dyneinfo.jxy.model.*;
import com.dyneinfo.jxy.service.*;

/**
 * @author lisc email:lishicheng(a)gmail.com
 */


public class Tcppunishinfo extends BaseEntity {
	
	//alias
	public static final String TABLE_ALIAS = "处罚信息";
	public static final String ALIAS_CPCODE = "企业编号";
	public static final String ALIAS_NAME = "企业名称";
	public static final String ALIAS_PDATE = "处罚日期";
	public static final String ALIAS_PFILENO = "行政处罚批准文号";
	public static final String ALIAS_AUTHUNIT = "批准机构";
	public static final String ALIAS_AUTHPERSON = "批准人";
	public static final String ALIAS_EXECPERSON = "执行人";
	public static final String ALIAS_CAUSE = "处罚原因";
	public static final String ALIAS_PTYPE = "处罚类型";
	public static final String ALIAS_RANGE = "幅度";
	public static final String ALIAS_PPERSON = "被处罚人";
	
	//date formats
	
	//columns START
	private java.lang.String cpcode;
	private java.lang.String pdate;
	private java.lang.String pfileno;
	private java.lang.String authunit;
	private java.lang.String authperson;
	private java.lang.String execperson;
	private java.lang.String cause;
	private java.lang.String ptype;
	private java.lang.String range;
	private java.lang.String pperson;
	private java.lang.String name;
	//columns END

	public java.lang.String getName() {
		return name;
	}

	public void setName(java.lang.String value) {
		this.name = value;
	}

	public Tcppunishinfo(){
	}

	public Tcppunishinfo(
		java.lang.String cpcode,
		java.lang.String pfileno
	){
		this.cpcode = cpcode;
		this.pfileno = pfileno;
	}

	public void setCpcode(java.lang.String value) {
		this.cpcode = value;
	}
	
	public java.lang.String getCpcode() {
		return this.cpcode;
	}
	public void setPdate(java.lang.String value) {
		this.pdate = value;
	}
	
	public java.lang.String getPdate() {
		return this.pdate;
	}
	public void setPfileno(java.lang.String value) {
		this.pfileno = value;
	}
	
	public java.lang.String getPfileno() {
		return this.pfileno;
	}
	public void setAuthunit(java.lang.String value) {
		this.authunit = value;
	}
	
	public java.lang.String getAuthunit() {
		return this.authunit;
	}
	public void setAuthperson(java.lang.String value) {
		this.authperson = value;
	}
	
	public java.lang.String getAuthperson() {
		return this.authperson;
	}
	public void setExecperson(java.lang.String value) {
		this.execperson = value;
	}
	
	public java.lang.String getExecperson() {
		return this.execperson;
	}
	public void setCause(java.lang.String value) {
		this.cause = value;
	}
	
	public java.lang.String getCause() {
		return this.cause;
	}
	public void setPtype(java.lang.String value) {
		this.ptype = value;
	}
	
	public java.lang.String getPtype() {
		return this.ptype;
	}
	public void setRange(java.lang.String value) {
		this.range = value;
	}
	
	public java.lang.String getRange() {
		return this.range;
	}
	public void setPperson(java.lang.String value) {
		this.pperson = value;
	}
	
	public java.lang.String getPperson() {
		return this.pperson;
	}

	public String toString() {
		return new ToStringBuilder(this)
			.append("Cpcode",getCpcode())
			.append("Pdate",getPdate())
			.append("Pfileno",getPfileno())
			.append("Authunit",getAuthunit())
			.append("Authperson",getAuthperson())
			.append("Execperson",getExecperson())
			.append("Cause",getCause())
			.append("Ptype",getPtype())
			.append("Range",getRange())
			.append("Pperson",getPperson())
			.append("name",getName())
			.toString();
	}
	
	public int hashCode() {
		return new HashCodeBuilder()
			.append(getCpcode())
			.append(getPdate())
			.append(getPfileno())
			.append(getAuthunit())
			.append(getAuthperson())
			.append(getExecperson())
			.append(getCause())
			.append(getPtype())
			.append(getRange())
			.append(getPperson())
			.append(getName())
			.toHashCode();
	}
	
	public boolean equals(Object obj) {
		if(obj instanceof Tcppunishinfo == false) return false;
		if(this == obj) return true;
		Tcppunishinfo other = (Tcppunishinfo)obj;
		return new EqualsBuilder()
			.append(getCpcode(),other.getCpcode())
			.append(getPdate(),other.getPdate())
			.append(getPfileno(),other.getPfileno())
			.append(getAuthunit(),other.getAuthunit())
			.append(getAuthperson(),other.getAuthperson())
			.append(getExecperson(),other.getExecperson())
			.append(getCause(),other.getCause())
			.append(getPtype(),other.getPtype())
			.append(getRange(),other.getRange())
			.append(getPperson(),other.getPperson())
			.append(getName(),other.getName())
			.isEquals();
	}
}

