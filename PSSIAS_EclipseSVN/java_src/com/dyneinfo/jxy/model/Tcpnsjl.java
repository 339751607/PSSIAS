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


public class Tcpnsjl extends BaseEntity {
	
	//alias
	public static final String TABLE_ALIAS = "年审信息";
	public static final String ALIAS_CPCODE = "企业代码";
	public static final String ALIAS_NAME="企业名称";
	public static final String ALIAS_SHND = "审核年度";
	public static final String ALIAS_SHRJ = "审核日期";
	public static final String ALIAS_NSYJ = "年审意见";
	public static final String ALIAS_QSR = "年审意见签署人";
	public static final String ALIAS_JBR = "年审意见经办人";
	
	//date formats
	
	//columns START
	private java.lang.String cpcode;
	private java.lang.String shnd;
	private java.lang.String shrj;
	private java.lang.String nsyj;
	private java.lang.String qsr;
	private java.lang.String jbr;
	private java.lang.String name;
	//columns END

	public Tcpnsjl(){
	}

	public Tcpnsjl(
		java.lang.String cpcode,
		java.lang.String shnd
		
	){
		this.cpcode = cpcode;
		this.shnd = shnd;
		
	}

	public java.lang.String getName() {
		return name;
	}

	public void setName(java.lang.String value) {
		this.name = value;
	}

	public void setCpcode(java.lang.String value) {
		this.cpcode = value;
	}
	
	public java.lang.String getCpcode() {
		return this.cpcode;
	}
	public void setShnd(java.lang.String value) {
		this.shnd = value;
	}
	
	public java.lang.String getShnd() {
		return this.shnd;
	}
	public void setShrj(java.lang.String value) {
		this.shrj = value;
	}
	
	public java.lang.String getShrj() {
		return this.shrj;
	}
	public void setNsyj(java.lang.String value) {
		this.nsyj = value;
	}
	
	public java.lang.String getNsyj() {
		return this.nsyj;
	}
	public void setQsr(java.lang.String value) {
		this.qsr = value;
	}
	
	public java.lang.String getQsr() {
		return this.qsr;
	}
	public void setJbr(java.lang.String value) {
		this.jbr = value;
	}
	
	public java.lang.String getJbr() {
		return this.jbr;
	}

	public String toString() {
		return new ToStringBuilder(this)
			.append("Cpcode",getCpcode())
			.append("Shnd",getShnd())
			.append("Shrj",getShrj())
			.append("Nsyj",getNsyj())
			.append("Qsr",getQsr())
			.append("Jbr",getJbr())
			.append("name",getName())
			.toString();
	}
	
	public int hashCode() {
		return new HashCodeBuilder()
			.append(getCpcode())
			.append(getShnd())
			.append(getShrj())
			.append(getNsyj())
			.append(getQsr())
			.append(getJbr())
			.append(getName())
			.toHashCode();
	}
	
	public boolean equals(Object obj) {
		if(obj instanceof Tcpnsjl == false) return false;
		if(this == obj) return true;
		Tcpnsjl other = (Tcpnsjl)obj;
		return new EqualsBuilder()
			.append(getCpcode(),other.getCpcode())
			.append(getShnd(),other.getShnd())
			.append(getShrj(),other.getShrj())
			.append(getNsyj(),other.getNsyj())
			.append(getQsr(),other.getQsr())
			.append(getJbr(),other.getJbr())
			.append(getName(),other.getName())
			
			.isEquals();
	}
}

