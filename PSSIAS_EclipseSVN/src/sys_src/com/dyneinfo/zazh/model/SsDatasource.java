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


public class SsDatasource extends BaseEntity {
	
	//alias
	public static final String TABLE_ALIAS = "行业子系统配置表";
	public static final String ALIAS_ID = "流水号";
	public static final String ALIAS_CODE = "行业代码";
	public static final String ALIAS_CALLED = "行业名称";
	public static final String ALIAS_DBS_DRIVERCLASSNAME = "驱动名称";
	public static final String ALIAS_DBS_URL = "链接地址";
	public static final String ALIAS_DBS_USERNAME = "用户名";
	public static final String ALIAS_DBS_PASSWORD = "密码";
	public static final String ALIAS_DBS_NAME = "数据源名称";
	public static final String ALIAS_ISVALID = "是否有效";
	public static final String ALIAS_EXTEND1 = "扩展1";
	public static final String ALIAS_EXTEND2 = "扩展2";
	
	//date formats
	
	//columns START
	private Long id;
	private java.lang.String code;
	private java.lang.String called;
	private java.lang.String dbsDriverclassname;
	private java.lang.String dbsUrl;
	private java.lang.String dbsUsername;
	private java.lang.String dbsPassword;
	private java.lang.String dbsName;
	private java.lang.String isvalid;
	private java.lang.String extend1;
	private java.lang.String extend2;
	//columns END

	public SsDatasource(){
	}

	public SsDatasource(
		Long id
	){
		this.id = id;
	}

	public void setId(Long value) {
		this.id = value;
	}
	
	public Long getId() {
		return this.id;
	}
	public void setCode(java.lang.String value) {
		this.code = value;
	}
	
	public java.lang.String getCode() {
		return this.code;
	}
	public void setCalled(java.lang.String value) {
		this.called = value;
	}
	
	public java.lang.String getCalled() {
		return this.called;
	}
	public void setDbsDriverclassname(java.lang.String value) {
		this.dbsDriverclassname = value;
	}
	
	public java.lang.String getDbsDriverclassname() {
		return this.dbsDriverclassname;
	}
	public void setDbsUrl(java.lang.String value) {
		this.dbsUrl = value;
	}
	
	public java.lang.String getDbsUrl() {
		return this.dbsUrl;
	}
	public void setDbsUsername(java.lang.String value) {
		this.dbsUsername = value;
	}
	
	public java.lang.String getDbsUsername() {
		return this.dbsUsername;
	}
	public void setDbsPassword(java.lang.String value) {
		this.dbsPassword = value;
	}
	
	public java.lang.String getDbsPassword() {
		return this.dbsPassword;
	}
	public void setDbsName(java.lang.String value) {
		this.dbsName = value;
	}
	
	public java.lang.String getDbsName() {
		return this.dbsName;
	}
	public void setIsvalid(java.lang.String value) {
		this.isvalid = value;
	}
	
	public java.lang.String getIsvalid() {
		return this.isvalid;
	}
	public void setExtend1(java.lang.String value) {
		this.extend1 = value;
	}
	
	public java.lang.String getExtend1() {
		return this.extend1;
	}
	public void setExtend2(java.lang.String value) {
		this.extend2 = value;
	}
	
	public java.lang.String getExtend2() {
		return this.extend2;
	}

	public String toString() {
		return new ToStringBuilder(this)
			.append("Id",getId())
			.append("Code",getCode())
			.append("Called",getCalled())
			.append("DbsDriverclassname",getDbsDriverclassname())
			.append("DbsUrl",getDbsUrl())
			.append("DbsUsername",getDbsUsername())
			.append("DbsPassword",getDbsPassword())
			.append("DbsName",getDbsName())
			.append("Isvalid",getIsvalid())
			.append("Extend1",getExtend1())
			.append("Extend2",getExtend2())
			.toString();
	}
	
	public int hashCode() {
		return new HashCodeBuilder()
			.append(getId())
			.append(getCode())
			.append(getCalled())
			.append(getDbsDriverclassname())
			.append(getDbsUrl())
			.append(getDbsUsername())
			.append(getDbsPassword())
			.append(getDbsName())
			.append(getIsvalid())
			.append(getExtend1())
			.append(getExtend2())
			.toHashCode();
	}
	
	public boolean equals(Object obj) {
		if(obj instanceof SsDatasource == false) return false;
		if(this == obj) return true;
		SsDatasource other = (SsDatasource)obj;
		return new EqualsBuilder()
			.append(getId(),other.getId())
			.append(getCode(),other.getCode())
			.append(getCalled(),other.getCalled())
			.append(getDbsDriverclassname(),other.getDbsDriverclassname())
			.append(getDbsUrl(),other.getDbsUrl())
			.append(getDbsUsername(),other.getDbsUsername())
			.append(getDbsPassword(),other.getDbsPassword())
			.append(getDbsName(),other.getDbsName())
			.append(getIsvalid(),other.getIsvalid())
			.append(getExtend1(),other.getExtend1())
			.append(getExtend2(),other.getExtend2())
			.isEquals();
	}
}

