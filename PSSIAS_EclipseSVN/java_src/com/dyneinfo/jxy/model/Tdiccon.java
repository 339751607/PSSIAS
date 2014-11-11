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


public class Tdiccon extends BaseEntity {
	
	//alias
	public static final String TABLE_ALIAS = "Tdiccon";
	public static final String ALIAS_ID = "序号";
	public static final String ALIAS_CALLED = "名称";
	public static final String ALIAS_CODE = "代码";
	public static final String ALIAS_PARTOF = "所属类别";
	public static final String ALIAS_JC = "简称";
	
	//date formats
	
	//columns START
	private Long id;
	private java.lang.String called;
	private java.lang.String code;
	private java.lang.String partof;
	private java.lang.String jc;
	//columns END

	public Tdiccon(){
	}

	public Tdiccon(
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
	public void setCalled(java.lang.String value) {
		this.called = value;
	}
	
	public java.lang.String getCalled() {
		return this.called;
	}
	public void setCode(java.lang.String value) {
		this.code = value;
	}
	
	public java.lang.String getCode() {
		return this.code;
	}
	public void setPartof(java.lang.String value) {
		this.partof = value;
	}
	
	public java.lang.String getPartof() {
		return this.partof;
	}
	public void setJc(java.lang.String value) {
		this.jc = value;
	}
	
	public java.lang.String getJc() {
		return this.jc;
	}

	public String toString() {
		return new ToStringBuilder(this)
			.append("Id",getId())
			.append("Called",getCalled())
			.append("Code",getCode())
			.append("Partof",getPartof())
			.append("Jc",getJc())
			.toString();
	}
	
	public int hashCode() {
		return new HashCodeBuilder()
			.append(getId())
			.append(getCalled())
			.append(getCode())
			.append(getPartof())
			.append(getJc())
			.toHashCode();
	}
	
	public boolean equals(Object obj) {
		if(obj instanceof Tdiccon == false) return false;
		if(this == obj) return true;
		Tdiccon other = (Tdiccon)obj;
		return new EqualsBuilder()
			.append(getId(),other.getId())
			.append(getCalled(),other.getCalled())
			.append(getCode(),other.getCode())
			.append(getPartof(),other.getPartof())
			.append(getJc(),other.getJc())
			.isEquals();
	}
}

