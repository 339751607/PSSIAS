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


public class Txctb extends BaseEntity {
	
	//alias
	public static final String TABLE_ALIAS = "协查通报";
	public static final String ALIAS_ID = "协查通报ID(流水号)";
	public static final String ALIAS_FBR = "发布人";
	public static final String ALIAS_CZ = "出自";
	public static final String ALIAS_FBSJ = "下发日期";
	public static final String ALIAS_BT = "标题";
	public static final String ALIAS_NR = "内容";
	
	//date formats
	
	//columns START
	private Long id;
	private java.lang.String fbr;
	private java.lang.String cz;
	private java.lang.String fbsj;
	private java.lang.String bt;
	private java.lang.String nr;
	//columns END

	public Txctb(){
	}

	public Txctb(
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
	public void setFbr(java.lang.String value) {
		this.fbr = value;
	}
	
	public java.lang.String getFbr() {
		return this.fbr;
	}
	public void setCz(java.lang.String value) {
		this.cz = value;
	}
	
	public java.lang.String getCz() {
		return this.cz;
	}
	public void setFbsj(java.lang.String value) {
		this.fbsj = value;
	}
	
	public java.lang.String getFbsj() {
		return this.fbsj;
	}
	public void setBt(java.lang.String value) {
		this.bt = value;
	}
	
	public java.lang.String getBt() {
		return this.bt;
	}
	public void setNr(java.lang.String value) {
		this.nr = value;
	}
	
	public java.lang.String getNr() {
		return this.nr;
	}

	public String toString() {
		return new ToStringBuilder(this)
			.append("Id",getId())
			.append("Fbr",getFbr())
			.append("Cz",getCz())
			.append("Fbsj",getFbsj())
			.append("Bt",getBt())
			.append("Nr",getNr())
			.toString();
	}
	
	public int hashCode() {
		return new HashCodeBuilder()
			.append(getId())
			.append(getFbr())
			.append(getCz())
			.append(getFbsj())
			.append(getBt())
			.append(getNr())
			.toHashCode();
	}
	
	public boolean equals(Object obj) {
		if(obj instanceof Txctb == false) return false;
		if(this == obj) return true;
		Txctb other = (Txctb)obj;
		return new EqualsBuilder()
			.append(getId(),other.getId())
			.append(getFbr(),other.getFbr())
			.append(getCz(),other.getCz())
			.append(getFbsj(),other.getFbsj())
			.append(getBt(),other.getBt())
			.append(getNr(),other.getNr())
			.isEquals();
	}
}

