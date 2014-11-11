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


public class TfjycpCheck extends BaseEntity {
	
	//alias
	public static final String TABLE_ALIAS = "民警检查";
	public static final String ALIAS_ID = "编号";
	public static final String ALIAS_CPCODE = "企业编号";
	public static final String ALIAS_IDCARD = "民警身份证号码";
	public static final String ALIAS_CONTENT = "检查内容";
	public static final String ALIAS_CHECKDATE = "检查日期";
	public static final String ALIAS_CHECKTYPE = "1 民警检查 2 维护检查";
	public static final String ALIAS_EMPCODE="被检查人";
	
	//date formats
	
	//columns START
	private java.lang.String id;
	private java.lang.String cpcode;
	private java.lang.String idcard;
	private java.lang.String content;
	private java.lang.String checkdate;
	private java.lang.String checktype;
	private java.lang.String fullname;//民警姓名
	private java.lang.String policeno;//警号
	private java.lang.String deptname;//企业名称
	private java.lang.String empcode;//被检查人
	private java.lang.String empname;//被检查人姓名
	private java.lang.String pcsname;//派出所
	
	
	//columns END


	public TfjycpCheck(){
	}

	public TfjycpCheck(
		java.lang.String id
	){
		this.id = id;
	}

	public java.lang.String getEmpname() {
		return empname;
	}

	public void setEmpname(java.lang.String empname) {
		this.empname = empname;
	}

	public void setId(java.lang.String value) {
		this.id = value;
	}
	
	public java.lang.String getId() {
		return this.id;
	}
	public void setCpcode(java.lang.String value) {
		this.cpcode = value;
	}
	
	public java.lang.String getCpcode() {
		return this.cpcode;
	}
	public void setIdcard(java.lang.String value) {
		this.idcard = value;
	}
	
	public java.lang.String getEmpcode() {
		return empcode;
	}

	public void setEmpcode(java.lang.String empcode) {
		this.empcode = empcode;
	}

	public java.lang.String getIdcard() {
		return this.idcard;
	}
	public void setContent(java.lang.String value) {
		this.content = value;
	}
	
	public java.lang.String getContent() {
		return this.content;
	}
	public void setCheckdate(java.lang.String value) {
		this.checkdate = value;
	}
	
	public java.lang.String getCheckdate() {
		return this.checkdate;
	}
	public void setChecktype(java.lang.String value) {
		this.checktype = value;
	}
	
	public java.lang.String getChecktype() {
		return this.checktype;
	}

	public String toString() {
		return new ToStringBuilder(this)
			.append("Id",getId())
			.append("Cpcode",getCpcode())
			.append("Idcard",getIdcard())
			.append("Content",getContent())
			.append("Checkdate",getCheckdate())
			.append("Checktype",getChecktype())
			.append("Fullname",getFullname())
			.append("Policeno",getPoliceno())
			.append("Deptname",getDeptname())
			.append("Empcode",getEmpcode())
			.append("Pcsname",getPcsname())
			.toString();
	}
	
	public int hashCode() {
		return new HashCodeBuilder()
			.append(getId())
			.append(getCpcode())
			.append(getIdcard())
			.append(getContent())
			.append(getCheckdate())
			.append(getChecktype())
			.append(getFullname())
			.append(getPoliceno())
			.append(getDeptname())
			.append(getEmpcode())
			.append(getPcsname())
			.toHashCode();
	}
	
	public boolean equals(Object obj) {
		if(obj instanceof TfjycpCheck == false) return false;
		if(this == obj) return true;
		TfjycpCheck other = (TfjycpCheck)obj;
		return new EqualsBuilder()
			.append(getId(),other.getId())
			.append(getCpcode(),other.getCpcode())
			.append(getIdcard(),other.getIdcard())
			.append(getContent(),other.getContent())
			.append(getCheckdate(),other.getCheckdate())
			.append(getChecktype(),other.getChecktype())
			.append(getFullname(),other.getFullname())
			.append(getPoliceno(),other.getPoliceno())
			.append(getDeptname(),other.getDeptname())
			.append(getEmpcode(),other.getEmpcode())
			.append(getPcsname(),other.getPcsname())
			.isEquals();
	}

	public java.lang.String getFullname() {
		return fullname;
	}

	public void setFullname(java.lang.String fullname) {
		this.fullname = fullname;
	}

	public java.lang.String getPoliceno() {
		return policeno;
	}

	public void setPoliceno(java.lang.String policeno) {
		this.policeno = policeno;
	}

	public java.lang.String getDeptname() {
		return deptname;
	}

	public void setDeptname(java.lang.String deptname) {
		this.deptname = deptname;
	}

	public java.lang.String getPcsname() {
		return pcsname;
	}

	public void setPcsname(java.lang.String pcsname) {
		this.pcsname = pcsname;
	}
}

