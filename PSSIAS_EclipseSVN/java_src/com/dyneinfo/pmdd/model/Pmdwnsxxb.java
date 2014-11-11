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


public class Pmdwnsxxb extends BaseEntity {
	
	//alias
	public static final String TABLE_ALIAS = "典当单位年审信息";
	public static final String ALIAS_TIB_FLOWGUID = "_流程ID";
	public static final String ALIAS_TIB_ROWGUID = "_记录ID";
	public static final String ALIAS_DWBM = "单位编码";
	public static final String ALIAS_NSND = "年审年度";
	public static final String ALIAS_TH_TYPE = "特行类型";
	public static final String ALIAS_NSRQ = "年审日期";
	public static final String ALIAS_NSJG = "年审结果";
	public static final String ALIAS_NSYJ = "年审意见";
	public static final String ALIAS_NSYJQSR = "年审意见签署人";
	public static final String ALIAS_NSYJJBR = "年审意见经办人";
	public static final String ALIAS_DWMC = "单位名称";
	//date formats
	
	//columns START
	private java.lang.String tibFlowguid;
	private java.lang.String tibRowguid;
	private java.lang.String dwbm;
	private java.lang.String nsnd;
	private java.lang.String thType;
	private java.lang.String nsrq;
	private java.lang.String nsjg;
	private java.lang.String nsyj;
	private java.lang.String nsyjqsr;
	private java.lang.String nsyjjbr;
	private java.lang.String dwmc;
	//columns END

	public Pmdwnsxxb(){
	}

	public Pmdwnsxxb(
		java.lang.String dwbm
	){
		this.dwbm = dwbm;
	}

	public void setTibFlowguid(java.lang.String value) {
		this.tibFlowguid = value;
	}
	
	public java.lang.String getTibFlowguid() {
		return this.tibFlowguid;
	}
	public void setTibRowguid(java.lang.String value) {
		this.tibRowguid = value;
	}
	
	public java.lang.String getTibRowguid() {
		return this.tibRowguid;
	}
	public void setDwbm(java.lang.String value) {
		this.dwbm = value;
	}
	
	public java.lang.String getDwbm() {
		return this.dwbm;
	}
	public void setNsnd(java.lang.String value) {
		this.nsnd = value;
	}
	
	public java.lang.String getNsnd() {
		return this.nsnd;
	}
	public void setThType(java.lang.String value) {
		this.thType = value;
	}
	
	public java.lang.String getThType() {
		return this.thType;
	}
	public void setNsrq(java.lang.String value) {
		this.nsrq = value;
	}
	
	public java.lang.String getNsrq() {
		return this.nsrq;
	}
	public void setNsjg(java.lang.String value) {
		this.nsjg = value;
	}
	
	public java.lang.String getNsjg() {
		return this.nsjg;
	}
	public void setNsyj(java.lang.String value) {
		this.nsyj = value;
	}
	
	public java.lang.String getNsyj() {
		return this.nsyj;
	}
	public void setNsyjqsr(java.lang.String value) {
		this.nsyjqsr = value;
	}
	
	public java.lang.String getNsyjqsr() {
		return this.nsyjqsr;
	}
	public void setNsyjjbr(java.lang.String value) {
		this.nsyjjbr = value;
	}
	
	public java.lang.String getNsyjjbr() {
		return this.nsyjjbr;
	}

	public java.lang.String getDwmc() {
		return dwmc;
	}

	public void setDwmc(java.lang.String dwmc) {
		this.dwmc = dwmc;
	}

	public String toString() {
		return new ToStringBuilder(this)
			.append("TibFlowguid",getTibFlowguid())
			.append("TibRowguid",getTibRowguid())
			.append("Dwbm",getDwbm())
			.append("Nsnd",getNsnd())
			.append("ThType",getThType())
			.append("Nsrq",getNsrq())
			.append("Nsjg",getNsjg())
			.append("Nsyj",getNsyj())
			.append("Nsyjqsr",getNsyjqsr())
			.append("Nsyjjbr",getNsyjjbr())
			.append("Dwmc",getDwmc())
			.toString();
	}
	
	public int hashCode() {
		return new HashCodeBuilder()
			.append(getTibFlowguid())
			.append(getTibRowguid())
			.append(getDwbm())
			.append(getNsnd())
			.append(getThType())
			.append(getNsrq())
			.append(getNsjg())
			.append(getNsyj())
			.append(getNsyjqsr())
			.append(getNsyjjbr())
			.append(getDwmc())
			.toHashCode();
	}
	
	public boolean equals(Object obj) {
		if(obj instanceof Pmdwnsxxb == false) return false;
		if(this == obj) return true;
		Pmdwnsxxb other = (Pmdwnsxxb)obj;
		return new EqualsBuilder()
			.append(getTibFlowguid(),other.getTibFlowguid())
			.append(getTibRowguid(),other.getTibRowguid())
			.append(getDwbm(),other.getDwbm())
			.append(getNsnd(),other.getNsnd())
			.append(getThType(),other.getThType())
			.append(getNsrq(),other.getNsrq())
			.append(getNsjg(),other.getNsjg())
			.append(getNsyj(),other.getNsyj())
			.append(getNsyjqsr(),other.getNsyjqsr())
			.append(getNsyjjbr(),other.getNsyjjbr())
			.append(getDwmc(), other.getDwmc())
			.isEquals();
	}
}

