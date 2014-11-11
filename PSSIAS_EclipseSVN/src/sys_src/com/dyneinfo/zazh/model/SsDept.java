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


public class SsDept extends BaseEntity {
	
	//alias
	public static final String TABLE_ALIAS = "SsDept";
	public static final String ALIAS_DEPTID = "deptid";
	public static final String ALIAS_DEPTNAME = "deptname";
	public static final String ALIAS_DEPTDESC = "deptdesc";
	public static final String ALIAS_DEPTCODE = "deptcode";
	public static final String ALIAS_DEPTSEQ = "deptseq";
	public static final String ALIAS_DISPLAYORDER = "displayorder";
	public static final String ALIAS_PARENTID = "parentid";
	public static final String ALIAS_DEPTLEVEL = "deptlevel";
	public static final String ALIAS_DEPTTYPEID = "类型编号";
	public static final String ALIAS_STATUS = "状态";
	
	//date formats
	
	//columns START
	private java.lang.String deptid;
	private java.lang.String deptname;
	private java.lang.String deptdesc;
	private java.lang.String deptcode;
	private java.lang.String deptseq;
	private Long displayorder;
	private java.lang.String parentid;
	private Integer deptlevel;
	private java.lang.String depttypeid;
	private java.lang.String status;
	//columns END

	public SsDept(){
	}

	public SsDept(
			java.lang.String deptid
	){
		this.deptid = deptid;
	}

	public void setDeptid(String value) {
		this.deptid = value;
	}
	
	public java.lang.String getDeptid() {
		return this.deptid;
	}
	public void setDeptname(java.lang.String value) {
		this.deptname = value;
	}
	
	public java.lang.String getDeptname() {
		return this.deptname;
	}
	public void setDeptdesc(java.lang.String value) {
		this.deptdesc = value;
	}
	
	public java.lang.String getDeptdesc() {
		return this.deptdesc;
	}
	public void setDeptcode(java.lang.String value) {
		this.deptcode = value;
	}
	
	public java.lang.String getDeptcode() {
		return this.deptcode;
	}
	public void setDeptseq(java.lang.String value) {
		this.deptseq = value;
	}
	
	public java.lang.String getDeptseq() {
		return this.deptseq;
	}
	public void setDisplayorder(Long value) {
		this.displayorder = value;
	}
	
	public Long getDisplayorder() {
		return this.displayorder;
	}
	public void setParentid(java.lang.String value) {
		this.parentid = value;
	}
	
	public java.lang.String getParentid() {
		return this.parentid;
	}
	public void setDeptlevel(Integer value) {
		this.deptlevel = value;
	}
	
	public Integer getDeptlevel() {
		return this.deptlevel;
	}
	public void setDepttypeid(java.lang.String value) {
		this.depttypeid = value;
	}
	
	public java.lang.String getDepttypeid() {
		return this.depttypeid;
	}
	public void setStatus(java.lang.String value) {
		this.status = value;
	}
	
	public java.lang.String getStatus() {
		return this.status;
	}

	public String toString() {
		return new ToStringBuilder(this)
			.append("Deptid",getDeptid())
			.append("Deptname",getDeptname())
			.append("Deptdesc",getDeptdesc())
			.append("Deptcode",getDeptcode())
			.append("Deptseq",getDeptseq())
			.append("Displayorder",getDisplayorder())
			.append("Parentid",getParentid())
			.append("Deptlevel",getDeptlevel())
			.append("Depttypeid",getDepttypeid())
			.append("Status",getStatus())
			.toString();
	}
	
	public int hashCode() {
		return new HashCodeBuilder()
			.append(getDeptid())
			.append(getDeptname())
			.append(getDeptdesc())
			.append(getDeptcode())
			.append(getDeptseq())
			.append(getDisplayorder())
			.append(getParentid())
			.append(getDeptlevel())
			.append(getDepttypeid())
			.append(getStatus())
			.toHashCode();
	}
	
	public boolean equals(Object obj) {
		if(obj instanceof SsDept == false) return false;
		if(this == obj) return true;
		SsDept other = (SsDept)obj;
		return new EqualsBuilder()
			.append(getDeptid(),other.getDeptid())
			.append(getDeptname(),other.getDeptname())
			.append(getDeptdesc(),other.getDeptdesc())
			.append(getDeptcode(),other.getDeptcode())
			.append(getDeptseq(),other.getDeptseq())
			.append(getDisplayorder(),other.getDisplayorder())
			.append(getParentid(),other.getParentid())
			.append(getDeptlevel(),other.getDeptlevel())
			.append(getDepttypeid(),other.getDepttypeid())
			.append(getStatus(),other.getStatus())
			.isEquals();
	}
}

