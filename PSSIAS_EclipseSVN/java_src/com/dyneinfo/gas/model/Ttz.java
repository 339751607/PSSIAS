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


public class Ttz extends BaseEntity {
	
	//alias
	public static final String TABLE_ALIAS = "通知信息";
	public static final String ALIAS_ID = "通知ID(流水号)";
	public static final String ALIAS_RQ = "下发时间";
	public static final String ALIAS_NR = "通知内容";
	public static final String ALIAS_BT = "标题";
	public static final String ALIAS_FSQT = "发送全体";
	public static final String ALIAS_FSDW = "接收单位";
	public static final String ALIAS_FSR = "下发人/单位";
	public static final String ALIAS_BURCODE = "下发范围";
	public static final String ALIAS_STACODE = "下发范围";
	public static final String ALIAS_USERUNIT = "下发单位代码)";
	public static final String ALIAS_HZFLAG = "通知是否需要回执";
	
	//date formats
	
	//columns START
	private Long id;
	private java.lang.String rq;
	private java.lang.String nr;
	private java.lang.String bt;
	private java.lang.String fsqt;
	private java.lang.String fsdw;
	private java.lang.String fsr;
	private java.lang.String burcode;
	private java.lang.String stacode;
	private java.lang.String userunit;
	private java.lang.String hzflag;
	//columns END

	public Ttz(){
	}

	public Ttz(
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
	public void setRq(java.lang.String value) {
		this.rq = value;
	}
	
	public java.lang.String getRq() {
		return this.rq;
	}
	public void setNr(java.lang.String value) {
		this.nr = value;
	}
	
	public java.lang.String getNr() {
		return this.nr;
	}
	public void setBt(java.lang.String value) {
		this.bt = value;
	}
	
	public java.lang.String getBt() {
		return this.bt;
	}
	public void setFsqt(java.lang.String value) {
		this.fsqt = value;
	}
	
	public java.lang.String getFsqt() {
		return this.fsqt;
	}
	public void setFsdw(java.lang.String value) {
		this.fsdw = value;
	}
	
	public java.lang.String getFsdw() {
		return this.fsdw;
	}
	public void setFsr(java.lang.String value) {
		this.fsr = value;
	}
	
	public java.lang.String getFsr() {
		return this.fsr;
	}
	public void setBurcode(java.lang.String value) {
		this.burcode = value;
	}
	
	public java.lang.String getBurcode() {
		return this.burcode;
	}
	public void setStacode(java.lang.String value) {
		this.stacode = value;
	}
	
	public java.lang.String getStacode() {
		return this.stacode;
	}
	public void setUserunit(java.lang.String value) {
		this.userunit = value;
	}
	
	public java.lang.String getUserunit() {
		return this.userunit;
	}
	public void setHzflag(java.lang.String value) {
		this.hzflag = value;
	}
	
	public java.lang.String getHzflag() {
		return this.hzflag;
	}

	public String toString() {
		return new ToStringBuilder(this)
			.append("Id",getId())
			.append("Rq",getRq())
			.append("Nr",getNr())
			.append("Bt",getBt())
			.append("Fsqt",getFsqt())
			.append("Fsdw",getFsdw())
			.append("Fsr",getFsr())
			.append("Burcode",getBurcode())
			.append("Stacode",getStacode())
			.append("Userunit",getUserunit())
			.append("Hzflag",getHzflag())
			.toString();
	}
	
	public int hashCode() {
		return new HashCodeBuilder()
			.append(getId())
			.append(getRq())
			.append(getNr())
			.append(getBt())
			.append(getFsqt())
			.append(getFsdw())
			.append(getFsr())
			.append(getBurcode())
			.append(getStacode())
			.append(getUserunit())
			.append(getHzflag())
			.toHashCode();
	}
	
	public boolean equals(Object obj) {
		if(obj instanceof Ttz == false) return false;
		if(this == obj) return true;
		Ttz other = (Ttz)obj;
		return new EqualsBuilder()
			.append(getId(),other.getId())
			.append(getRq(),other.getRq())
			.append(getNr(),other.getNr())
			.append(getBt(),other.getBt())
			.append(getFsqt(),other.getFsqt())
			.append(getFsdw(),other.getFsdw())
			.append(getFsr(),other.getFsr())
			.append(getBurcode(),other.getBurcode())
			.append(getStacode(),other.getStacode())
			.append(getUserunit(),other.getUserunit())
			.append(getHzflag(),other.getHzflag())
			.isEquals();
	}
}

