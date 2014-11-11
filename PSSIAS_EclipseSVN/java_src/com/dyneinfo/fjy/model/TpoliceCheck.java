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


public class TpoliceCheck extends BaseEntity {
	
	//alias
	public static final String TABLE_ALIAS = "民警检查";
	public static final String ALIAS_CHECKID = "检查ID";
	public static final String ALIAS_DEPTID = "部门";
	public static final String ALIAS_ACCEPTCHECKNAME = "被检查人";
	public static final String ALIAS_CHECKNAME = "检查人";
	public static final String ALIAS_CHECKNAMEPHONE = "检查人电话";
	public static final String ALIAS_CHECKTIME = "检查时间 ";
	
	//date formats
	public static final String FORMAT_CHECKTIME = DATE_TIME_FORMAT;
	
	//columns START
	private Long checkid;
	private Long deptid;
	private java.lang.String acceptcheckname;
	private java.lang.String checkname;
	private java.lang.String checknamephone;
	private java.util.Date checktime;
	//columns END
	
	private java.lang.String deptname;
	private java.lang.String acceptchecknameXm;
	private java.lang.String checknameXm;

	public TpoliceCheck(){
	}

	public TpoliceCheck(
		Long checkid
	){
		this.checkid = checkid;
	}

	public void setCheckid(Long value) {
		this.checkid = value;
	}
	
	public Long getCheckid() {
		return this.checkid;
	}
	public void setDeptid(Long value) {
		this.deptid = value;
	}
	
	public Long getDeptid() {
		return this.deptid;
	}
	public void setAcceptcheckname(java.lang.String value) {
		this.acceptcheckname = value;
	}
	
	public java.lang.String getAcceptcheckname() {
		return this.acceptcheckname;
	}
	public void setCheckname(java.lang.String value) {
		this.checkname = value;
	}
	
	public java.lang.String getCheckname() {
		return this.checkname;
	}
	public void setChecknamephone(java.lang.String value) {
		this.checknamephone = value;
	}
	
	public java.lang.String getChecknamephone() {
		return this.checknamephone;
	}
	public String getChecktimeString() {
		return date2String(getChecktime(), FORMAT_CHECKTIME);
	}
	public void setChecktimeString(String value) {
		setChecktime(string2Date(value, FORMAT_CHECKTIME,java.util.Date.class));
	}
	
	public void setChecktime(java.util.Date value) {
		this.checktime = value;
	}
	
	public java.util.Date getChecktime() {
		return this.checktime;
	}

	public String toString() {
		return new ToStringBuilder(this)
			.append("Checkid",getCheckid())
			.append("Deptid",getDeptid())
			.append("Acceptcheckname",getAcceptcheckname())
			.append("Checkname",getCheckname())
			.append("Checknamephone",getChecknamephone())
			.append("Checktime",getChecktime())
			.toString();
	}
	
	public int hashCode() {
		return new HashCodeBuilder()
			.append(getCheckid())
			.append(getDeptid())
			.append(getAcceptcheckname())
			.append(getCheckname())
			.append(getChecknamephone())
			.append(getChecktime())
			.toHashCode();
	}
	
	public boolean equals(Object obj) {
		if(obj instanceof TpoliceCheck == false) return false;
		if(this == obj) return true;
		TpoliceCheck other = (TpoliceCheck)obj;
		return new EqualsBuilder()
			.append(getCheckid(),other.getCheckid())
			.append(getDeptid(),other.getDeptid())
			.append(getAcceptcheckname(),other.getAcceptcheckname())
			.append(getCheckname(),other.getCheckname())
			.append(getChecknamephone(),other.getChecknamephone())
			.append(getChecktime(),other.getChecktime())
			.isEquals();
	}

	public java.lang.String getDeptname() {
		return deptname;
	}

	public void setDeptname(java.lang.String deptname) {
		this.deptname = deptname;
	}

	public java.lang.String getAcceptchecknameXm() {
		return acceptchecknameXm;
	}

	public void setAcceptchecknameXm(java.lang.String acceptchecknameXm) {
		this.acceptchecknameXm = acceptchecknameXm;
	}

	public java.lang.String getChecknameXm() {
		return checknameXm;
	}

	public void setChecknameXm(java.lang.String checknameXm) {
		this.checknameXm = checknameXm;
	}
}

