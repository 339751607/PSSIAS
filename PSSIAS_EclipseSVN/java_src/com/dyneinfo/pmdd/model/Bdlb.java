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


public class Bdlb extends BaseEntity {
	
	//alias
	public static final String TABLE_ALIAS = "Bdlb";
	public static final String ALIAS_TIB_FLOWGUID = "tibFlowguid";
	public static final String ALIAS_TIB_ROWGUID = "tibRowguid";
	public static final String ALIAS_MC = "mc";
	public static final String ALIAS_DM = "dm";
	
	//date formats
	
	//columns START
	private java.lang.String tibFlowguid;
	private java.lang.String tibRowguid;
	private java.lang.String mc;
	private java.lang.String dm;
	//columns END

	public Bdlb(){
	}

	public Bdlb(
		java.lang.String mc
	){
		this.mc = mc;
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
	public void setMc(java.lang.String value) {
		this.mc = value;
	}
	
	public java.lang.String getMc() {
		return this.mc;
	}
	public void setDm(java.lang.String value) {
		this.dm = value;
	}
	
	public java.lang.String getDm() {
		return this.dm;
	}

	public String toString() {
		return new ToStringBuilder(this)
			.append("TibFlowguid",getTibFlowguid())
			.append("TibRowguid",getTibRowguid())
			.append("Mc",getMc())
			.append("Dm",getDm())
			.toString();
	}
	
	public int hashCode() {
		return new HashCodeBuilder()
			.append(getTibFlowguid())
			.append(getTibRowguid())
			.append(getMc())
			.append(getDm())
			.toHashCode();
	}
	
	public boolean equals(Object obj) {
		if(obj instanceof Bdlb == false) return false;
		if(this == obj) return true;
		Bdlb other = (Bdlb)obj;
		return new EqualsBuilder()
			.append(getTibFlowguid(),other.getTibFlowguid())
			.append(getTibRowguid(),other.getTibRowguid())
			.append(getMc(),other.getMc())
			.append(getDm(),other.getDm())
			.isEquals();
	}
}

