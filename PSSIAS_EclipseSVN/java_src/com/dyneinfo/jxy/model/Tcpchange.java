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


public class Tcpchange extends BaseEntity {
	
	//alias
	public static final String TABLE_ALIAS = "变更信息";
	public static final String ALIAS_CPCODE = "企业代码";
	public static final String ALIAS_NAME = "企业名称";
	public static final String ALIAS_CHANGEDATE = "变更日期";
	public static final String ALIAS_CHANGECODE = "变更项";
	public static final String ALIAS_BEFORECONTEN = "变更前内容";
	public static final String ALIAS_AFTERCONTENT = "变更后内容";
	
	//date formats
	
	//columns START
	private java.lang.String cpcode;
	private java.lang.String changedate;
	private java.lang.String changecode;
	private java.lang.String beforeconten;
	private java.lang.String aftercontent;
	private java.lang.String name;
	//columns END

	public java.lang.String getName() {
		return name;
	}

	public void setName(java.lang.String value) {
		this.name = value;
	}

	public Tcpchange(){
	}

	public Tcpchange(
		java.lang.String cpcode,
		java.lang.String changecode
	){
		this.cpcode = cpcode;
		this.changecode = changecode;
	}

	public void setCpcode(java.lang.String value) {
		this.cpcode = value;
	}
	
	public java.lang.String getCpcode() {
		return this.cpcode;
	}
	public void setChangedate(java.lang.String value) {
		this.changedate = value;
	}
	
	public java.lang.String getChangedate() {
		return this.changedate;
	}
	public void setChangecode(java.lang.String value) {
		this.changecode = value;
	}
	
	public java.lang.String getChangecode() {
		return this.changecode;
	}
	public void setBeforeconten(java.lang.String value) {
		this.beforeconten = value;
	}
	
	public java.lang.String getBeforeconten() {
		return this.beforeconten;
	}
	public void setAftercontent(java.lang.String value) {
		this.aftercontent = value;
	}
	
	public java.lang.String getAftercontent() {
		return this.aftercontent;
	}

	public String toString() {
		return new ToStringBuilder(this)
			.append("Cpcode",getCpcode())
			.append("Changedate",getChangedate())
			.append("Changecode",getChangecode())
			.append("Beforeconten",getBeforeconten())
			.append("Aftercontent",getAftercontent())
			.append("name",getName())
			.toString();
	}
	
	public int hashCode() {
		return new HashCodeBuilder()
			.append(getCpcode())
			.append(getChangedate())
			.append(getChangecode())
			.append(getBeforeconten())
			.append(getAftercontent())
			.append(getName())
			.toHashCode();
	}
	
	public boolean equals(Object obj) {
		if(obj instanceof Tcpchange == false) return false;
		if(this == obj) return true;
		Tcpchange other = (Tcpchange)obj;
		return new EqualsBuilder()
			.append(getCpcode(),other.getCpcode())
			.append(getChangedate(),other.getChangedate())
			.append(getChangecode(),other.getChangecode())
			.append(getBeforeconten(),other.getBeforeconten())
			.append(getAftercontent(),other.getAftercontent())
			.append(getName(),other.getName())
			.isEquals();
	}
}

