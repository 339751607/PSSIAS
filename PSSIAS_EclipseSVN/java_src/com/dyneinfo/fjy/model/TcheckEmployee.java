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


public class TcheckEmployee extends BaseEntity {
	
	//alias
	public static final String TABLE_ALIAS = "检查维护人员";
	public static final String ALIAS_ID = "序号";
	public static final String ALIAS_IDCARD = "身份证号";
	public static final String ALIAS_EMPTYPE = "人员类别";
	public static final String ALIAS_POLICENO = "警号";
	public static final String ALIAS_FULLNAME = "姓名";
	public static final String ALIAS_SEX = "性别";
	public static final String ALIAS_DEPTID = "部门ID";
	public static final String ALIAS_DEMO = "备注";
	
	//date formats
	
	//columns START
	private java.lang.Long id;
	private String idcard;
	private String emptype;
	private String policeno;
	private String fullname;
	private String sex;
	private String deptid;
	private String demo;
	//columns END
	
	private String deptname;

	public TcheckEmployee(){
	}

	public TcheckEmployee(
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
	public void setIdcard(String value) {
		this.idcard = value;
	}
	
	public String getIdcard() {
		return this.idcard;
	}
	public void setEmptype(String value) {
		this.emptype = value;
	}
	
	public String getEmptype() {
		return this.emptype;
	}
	public void setPoliceno(String value) {
		this.policeno = value;
	}
	
	public String getPoliceno() {
		return this.policeno;
	}
	public void setFullname(String value) {
		this.fullname = value;
	}
	
	public String getFullname() {
		return this.fullname;
	}
	public void setSex(String value) {
		this.sex = value;
	}
	
	public String getSex() {
		return this.sex;
	}
	public void setDeptid(String value) {
		this.deptid = value;
	}
	
	public String getDeptid() {
		return this.deptid;
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
			.append("Idcard",getIdcard())
			.append("Emptype",getEmptype())
			.append("Policeno",getPoliceno())
			.append("Fullname",getFullname())
			.append("Sex",getSex())
			.append("Deptid",getDeptid())
			.append("Demo",getDemo())
			.toString();
	}
	
	public int hashCode() {
		return new HashCodeBuilder()
			.append(getId())
			.append(getIdcard())
			.append(getEmptype())
			.append(getPoliceno())
			.append(getFullname())
			.append(getSex())
			.append(getDeptid())
			.append(getDemo())
			.toHashCode();
	}
	
	public boolean equals(Object obj) {
		if(obj instanceof TcheckEmployee == false) return false;
		if(this == obj) return true;
		TcheckEmployee other = (TcheckEmployee)obj;
		return new EqualsBuilder()
			.append(getId(),other.getId())
			.append(getIdcard(),other.getIdcard())
			.append(getEmptype(),other.getEmptype())
			.append(getPoliceno(),other.getPoliceno())
			.append(getFullname(),other.getFullname())
			.append(getSex(),other.getSex())
			.append(getDeptid(),other.getDeptid())
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

