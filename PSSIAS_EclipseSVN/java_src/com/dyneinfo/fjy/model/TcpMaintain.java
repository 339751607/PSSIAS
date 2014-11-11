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


public class TcpMaintain extends BaseEntity {
	
	//alias
	public static final String TABLE_ALIAS = "企业维护";
	public static final String ALIAS_ID = "id";
	public static final String ALIAS_DEPTID = "部门ID";
	public static final String ALIAS_IDCARD = "身份证号";
	public static final String ALIAS_MAINTAINTIME = "维护时间";
	public static final String ALIAS_DEMO = "备注";
	
	//date formats
	
	//columns START
	private java.lang.Long id;
	private String deptid;
	private String idcard;
	private String maintaintime;
	private String demo;
	//columns END
	
	private String deptname;

	public TcpMaintain(){
	}

	public TcpMaintain(
		java.lang.Long id
	){
		this.id = id;
	}

	public void setId(java.lang.Long value) {
		this.id = value;
	}
	
	public java.lang.Long getId() {
		return this.id;
	}
	public void setDeptid(String value) {
		this.deptid = value;
	}
	
	public String getDeptid() {
		return this.deptid;
	}
	public void setIdcard(String value) {
		this.idcard = value;
	}
	
	public String getIdcard() {
		return this.idcard;
	}
	public void setMaintaintime(String value) {
		this.maintaintime = value;
	}
	
	public String getMaintaintime() {
		return this.maintaintime;
	}
	public void setDemo(String value) {
		this.demo = value;
	}
	
	public String getDemo() {
		return this.demo;
	}

	public String toString() {
		return new ToStringBuilder(this)
			.append("Id",getId())
			.append("Deptid",getDeptid())
			.append("Idcard",getIdcard())
			.append("Maintaintime",getMaintaintime())
			.append("Demo",getDemo())
			.toString();
	}
	
	public int hashCode() {
		return new HashCodeBuilder()
			.append(getId())
			.append(getDeptid())
			.append(getIdcard())
			.append(getMaintaintime())
			.append(getDemo())
			.toHashCode();
	}
	
	public boolean equals(Object obj) {
		if(obj instanceof TcpMaintain == false) return false;
		if(this == obj) return true;
		TcpMaintain other = (TcpMaintain)obj;
		return new EqualsBuilder()
			.append(getId(),other.getId())
			.append(getDeptid(),other.getDeptid())
			.append(getIdcard(),other.getIdcard())
			.append(getMaintaintime(),other.getMaintaintime())
			.append(getDemo(),other.getDemo())
			.isEquals();
	}

	public String getDeptname() {
		return deptname;
	}

	public void setDeptname(String deptname) {
		this.deptname = deptname;
	}
}

