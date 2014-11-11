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


public class VCarCaseInfo extends BaseEntity {
	
	//alias
	public static final String TABLE_ALIAS = "事故车辆信息";

	
	//date formats
	
	
	public static final String ALIAS_CPCODE="企业代码";
	public static final String ALIAS_CPNAME="企业名称";
	public static final String ALIAS_CAROWNER="车主姓名";
	public static final String ALIAS_CARTYPE="车辆类型";
	public static final String ALIAS_CARID="车牌号";
	public static final String ALIAS_ENGINECODE="发动机号";
	public static final String ALIAS_BODYCODE="车架号";
	public static final String ALIAS_REPORTER="报告人";
	public static final String ALIAS_ERPTIME="报告日期";
	public static final String ALIAS_PART="损坏部位";	
	
	//columns START
	private java.lang.String cpcode;
	private java.lang.String cpname;
	private java.lang.String carowner;
	private java.lang.String cartype;
	private java.lang.String carid;
	private java.lang.String enginecode;
	private java.lang.String bodycode;
	private java.lang.String reporter;
	private java.lang.String erptime;
	private java.lang.String part;
	
	//columns END
	public VCarCaseInfo(){
	}
	
	public java.lang.String getCpcode() {
		return cpcode;
	}

	public void setCpcode(java.lang.String value) {
		this.cpcode = value;
	}

	public java.lang.String getCpname() {
		return cpname;
	}

	public void setCpname(java.lang.String value) {
		this.cpname = value;
	}

	public java.lang.String getCarowner() {
		return carowner;
	}

	public void setCarowner(java.lang.String value) {
		this.carowner = value;
	}

	public java.lang.String getCartype() {
		return cartype;
	}

	public void setCartype(java.lang.String value) {
		this.cartype = value;
	}

	public java.lang.String getCarid() {
		return carid;
	}

	public void setCarid(java.lang.String value) {
		this.carid = value;
	}

	public java.lang.String getEnginecode() {
		return enginecode;
	}

	public void setEnginecode(java.lang.String value) {
		this.enginecode = value;
	}

	public java.lang.String getBodycode() {
		return bodycode;
	}

	public void setBodycode(java.lang.String value) {
		this.bodycode = value;
	}

	public java.lang.String getReporter() {
		return reporter;
	}

	public void setReporter(java.lang.String value) {
		this.reporter = value;
	}

	public java.lang.String getErptime() {
		return erptime;
	}

	public void setErptime(java.lang.String value) {
		this.erptime = value;
	}

	public java.lang.String getPart() {
		return part;
	}

	public void setPart(java.lang.String value) {
		this.part = value;
	}
	
	public String toString() {
		return new ToStringBuilder(this)
			.append("cpcode",getCpcode())
			.append("cpname",getCpname())
			.append("carowner",getCarowner())
			.append("cartype",getCartype())
			.append("carid",getCarid())
			.append("enginecode",getEnginecode())
			.append("bodycode",getBodycode())
			.append("reporter",getReporter())
			.append("erptime",getErptime())
			.append("part",getPart())
			.toString();
	}
	
	public int hashCode() {
		return new HashCodeBuilder()
		.append(getCpcode())
		.append(getCpname())
		.append(getCarowner())
		.append(getCartype())
		.append(getCarid())
		.append(getEnginecode())
		.append(getBodycode())
		.append(getReporter())
		.append(getErptime())
		.append(getPart())
		.toHashCode();
	}
	
	public boolean equals(Object obj) {
		if(obj instanceof VCarCaseInfo == false) return false;
		if(this == obj) return true;
		VCarCaseInfo other = (VCarCaseInfo)obj;
		return new EqualsBuilder()
			
		.append(getCpcode(),other.getCpcode())
		.append(getCpname(),other.getCpname())
		.append(getCarowner(),other.getCarowner())
		.append(getCartype(),other.getCartype())
		.append(getCarid(),other.getCarid())
		.append(getEnginecode(),other.getEnginecode())
		.append(getBodycode(),other.getBodycode())
		.append(getReporter(),other.getReporter())
		.append(getErptime(),other.getErptime())
		.append(getPart(),other.getPart())
		.isEquals();
	}
}

