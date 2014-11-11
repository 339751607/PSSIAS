/*
 * Powered By [lishicheng]
 */

package com.dyneinfo.pmdd.model;

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

import com.dyneinfo.pmdd.dao.*;
import com.dyneinfo.pmdd.model.*;
import com.dyneinfo.pmdd.service.*;

/**
 * @author lisc email:lishicheng(a)gmail.com
 */


public class Tempworklog extends BaseEntity {
	
	//alias
	public static final String TABLE_ALIAS = "从业人员工作记录";
	public static final String ALIAS_WORKLOGID = "worklogid";
	public static final String ALIAS_EMPCODE = "从业人员编号";
	public static final String ALIAS_CPCODE = "单位编号";
	public static final String ALIAS_INDATE = "入职日期";
	public static final String ALIAS_LEFTDATE = "离职日期";
	public static final String ALIAS_EMPTYPE = "从业人员类型";
	public static final String ALIAS_DEMO = "备注";
	
	public static final String ALIAS_CPNAME = "单位名称";
	
	//date formats
	
	//columns START
	private Long worklogid;
	private String empcode;
	private String cpcode;
	private String indate;
	private String leftdate;
	private String emptype;
	private String demo;
	private String personid;
	//columns END
	private String cpname;
	private String status;
	

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Tempworklog(){
	}

	public Tempworklog(
		Long worklogid
	){
		this.worklogid = worklogid;
	}

	public void setWorklogid(Long value) {
		this.worklogid = value;
	}
	
	public Long getWorklogid() {
		return this.worklogid;
	}
	public void setEmpcode(String value) {
		this.empcode = value;
	}
	
	public String getEmpcode() {
		return this.empcode;
	}
	public void setCpcode(String value) {
		this.cpcode = value;
	}
	
	public String getCpcode() {
		return this.cpcode;
	}
	public void setIndate(String value) {
		this.indate = value;
	}
	
	public String getIndate() {
		return this.indate;
	}
	public void setLeftdate(String value) {
		this.leftdate = value;
	}
	
	public String getLeftdate() {
		return this.leftdate;
	}
	public void setEmptype(String value) {
		this.emptype = value;
	}
	
	public String getEmptype() {
		return this.emptype;
	}
	public void setDemo(String value) {
		this.demo = value;
	}
	
	public String getDemo() {
		return this.demo;
	}
	
	public String getCpname() {
		return cpname;
	}

	public void setCpname(String cpname) {
		this.cpname = cpname;
	}

	public String toString() {
		return new ToStringBuilder(this)
			.append("Worklogid",getWorklogid())
			.append("Empcode",getEmpcode())
			.append("Cpcode",getCpcode())
			.append("Indate",getIndate())
			.append("Leftdate",getLeftdate())
			.append("Emptype",getEmptype())
			.append("Demo",getDemo())
			.append("Cpname",getCpname())
			.append("Personid",getPersonid())
			.append("Status",getStatus())
			.toString();
	}
	
	public int hashCode() {
		return new HashCodeBuilder()
			.append(getWorklogid())
			.append(getEmpcode())
			.append(getCpcode())
			.append(getIndate())
			.append(getLeftdate())
			.append(getEmptype())
			.append(getDemo())
			.append(getPersonid())
			.append(getCpname())
			.append(getStatus())
			.toHashCode();
	}
	
	public boolean equals(Object obj) {
		if(obj instanceof Tempworklog == false) return false;
		if(this == obj) return true;
		Tempworklog other = (Tempworklog)obj;
		return new EqualsBuilder()
			.append(getWorklogid(),other.getWorklogid())
			.append(getEmpcode(),other.getEmpcode())
			.append(getCpcode(),other.getCpcode())
			.append(getIndate(),other.getIndate())
			.append(getLeftdate(),other.getLeftdate())
			.append(getEmptype(),other.getEmptype())
			.append(getDemo(),other.getDemo())
			.append(getCpname(),other.getCpname())
			.append(getPersonid(),other.getPersonid())
			.append(getStatus(),other.getStatus())
			.isEquals();
	}

	public String getPersonid() {
		return personid;
	}

	public void setPersonid(String personid) {
		this.personid = personid;
	}

	
}

