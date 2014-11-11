/*
 * Powered By [lishicheng]
 */

package com.dyneinfo.gas.model;

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

import com.dyneinfo.gas.model.*;
import com.dyneinfo.gas.dao.*;
import com.dyneinfo.gas.service.*;

/**
 * @author lisc email:lishicheng(a)gmail.com
 */


public class Tempworklog extends BaseEntity {
	
	//alias
	public static final String TABLE_ALIAS = "从业人员工作记录";
	public static final String ALIAS_EMPCODE = "从业人员编号";
	public static final String ALIAS_CPCODE = "加油站代码";
	public static final String ALIAS_INDATE = "入职日期";
	public static final String ALIAS_LEFTDATE = "离职日期";
	public static final String ALIAS_EMPDUTY = "职务";
	public static final String ALIAS_DEMO = "demo";
	
	//date formats
	
	//columns START
	private java.lang.String empcode;
	private java.lang.String cpcode;
	private java.lang.String indate;
	private java.lang.String leftdate;
	private java.lang.String empduty;
	private java.lang.String demo;
	//columns END

	public Tempworklog(){
	}

	public Tempworklog(
		java.lang.String empcode,
		java.lang.String cpcode
	){
		this.empcode = empcode;
		this.cpcode = cpcode;
	}

	public void setEmpcode(java.lang.String value) {
		this.empcode = value;
	}
	
	public java.lang.String getEmpcode() {
		return this.empcode;
	}
	public void setCpcode(java.lang.String value) {
		this.cpcode = value;
	}
	
	public java.lang.String getCpcode() {
		return this.cpcode;
	}
	public void setIndate(java.lang.String value) {
		this.indate = value;
	}
	
	public java.lang.String getIndate() {
		return this.indate;
	}
	public void setLeftdate(java.lang.String value) {
		this.leftdate = value;
	}
	
	public java.lang.String getLeftdate() {
		return this.leftdate;
	}
	public void setEmpduty(java.lang.String value) {
		this.empduty = value;
	}
	
	public java.lang.String getEmpduty() {
		return this.empduty;
	}
	public void setDemo(java.lang.String value) {
		this.demo = value;
	}
	
	public java.lang.String getDemo() {
		return this.demo;
	}

	public String toString() {
		return new ToStringBuilder(this)
			.append("Empcode",getEmpcode())
			.append("Cpcode",getCpcode())
			.append("Indate",getIndate())
			.append("Leftdate",getLeftdate())
			.append("Empduty",getEmpduty())
			.append("Demo",getDemo())
			.toString();
	}
	
	public int hashCode() {
		return new HashCodeBuilder()
			.append(getEmpcode())
			.append(getCpcode())
			.append(getIndate())
			.append(getLeftdate())
			.append(getEmpduty())
			.append(getDemo())
			.toHashCode();
	}
	
	public boolean equals(Object obj) {
		if(obj instanceof Tempworklog == false) return false;
		if(this == obj) return true;
		Tempworklog other = (Tempworklog)obj;
		return new EqualsBuilder()
			.append(getEmpcode(),other.getEmpcode())
			.append(getCpcode(),other.getCpcode())
			.append(getIndate(),other.getIndate())
			.append(getLeftdate(),other.getLeftdate())
			.append(getEmpduty(),other.getEmpduty())
			.append(getDemo(),other.getDemo())
			.isEquals();
	}
}

