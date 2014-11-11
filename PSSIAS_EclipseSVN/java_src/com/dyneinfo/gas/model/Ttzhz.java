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


public class Ttzhz extends BaseEntity {
	
	//alias
	public static final String TABLE_ALIAS = "通知回执";
	public static final String ALIAS_ID = "通知ID";
	public static final String ALIAS_HZSJ = "回执时间";
	public static final String ALIAS_CPCODE = "加油站名称";
	
	//date formats
	
	//columns START
	private Long id;
	private java.lang.String hzsj;
	private java.lang.String cpcode;
	private java.lang.String cpname;
	private java.lang.String tzhzid;
	//columns END

	public Ttzhz(){
	}

	public Ttzhz(
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
	public void setHzsj(java.lang.String value) {
		this.hzsj = value;
	}
	
	public java.lang.String getHzsj() {
		return this.hzsj;
	}
	public void setCpcode(java.lang.String value) {
		this.cpcode = value;
	}
	
	public java.lang.String getCpcode() {
		return this.cpcode;
	}

	public String toString() {
		return new ToStringBuilder(this)
			.append("Id",getId())
			.append("Hzsj",getHzsj())
			.append("Cpcode",getCpcode())
			.append("Tzhzid",getTzhzid())
			.append("Cpname",getCpname())
			.toString();
	}
	
	public int hashCode() {
		return new HashCodeBuilder()
			.append(getId())
			.append(getHzsj())
			.append(getCpcode())
			.append(getTzhzid())
			.append(getCpname())
			.toHashCode();
	}
	
	public boolean equals(Object obj) {
		if(obj instanceof Ttzhz == false) return false;
		if(this == obj) return true;
		Ttzhz other = (Ttzhz)obj;
		return new EqualsBuilder()
			.append(getId(),other.getId())
			.append(getHzsj(),other.getHzsj())
			.append(getCpcode(),other.getCpcode())
			.append(getTzhzid(),other.getTzhzid())
			.append(getCpname(),other.getCpname())
			.isEquals();
	}

	public java.lang.String getCpname() {
		return cpname;
	}

	public void setCpname(java.lang.String cpname) {
		this.cpname = cpname;
	}

	public java.lang.String getTzhzid() {
		return tzhzid;
	}

	public void setTzhzid(java.lang.String tzhzid) {
		this.tzhzid = tzhzid;
	}
}

