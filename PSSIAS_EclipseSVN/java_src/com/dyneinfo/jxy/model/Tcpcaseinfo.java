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


public class Tcpcaseinfo extends BaseEntity {
	
	//alias
	
	public static final String TABLE_ALIAS = "企业案(事)件";
	public static final String ALIAS_CPCODE = "企业编号";
	public static final String ALIAS_NAME = "企业名称";
	public static final String ALIAS_CASECODE = "立案编号";
	public static final String ALIAS_HAPPENTIME = "发案时间";
	public static final String ALIAS_CASEFLAG = "案(事)件性质";
	public static final String ALIAS_CASETYPE = "案(事)件类型";
	public static final String ALIAS_CASEDESC = "情况描述";
	public static final String ALIAS_ID = "id";
	public static final String ALIAS_FLAGPACK = "flagpack";
	
	//date formats
	public static final String FORMAT_STARTTIME = DATE_TIME_FORMAT;
	
	//columns START
	private java.lang.String cpcode;
	private java.lang.String casecode;
	private java.lang.String happentime;
	private java.lang.String caseflag;
	private java.lang.String casetype;
	private java.lang.String casedesc;
	private java.lang.String id;
	private java.lang.String flagpack;
	private java.lang.String name;
	//columns END

	public java.lang.String getName() {
		return name;
	}

	public void setName(java.lang.String value) {
		this.name = value;
	}

	public Tcpcaseinfo(){
	}

	public Tcpcaseinfo(
		java.lang.String id
	){
		this.id = id;
	}

	public void setCpcode(java.lang.String value) {
		this.cpcode = value;
	}
	
	public java.lang.String getCpcode() {
		return this.cpcode;
	}
	public void setCasecode(java.lang.String value) {
		this.casecode = value;
	}
	
	public java.lang.String getCasecode() {
		return this.casecode;
	}
	public void setHappentime(java.lang.String value) {
		this.happentime = value;
	}
	
	public java.lang.String getHappentime() {
		return this.happentime;
	}
	public void setCaseflag(java.lang.String value) {
		this.caseflag = value;
	}
	
	public java.lang.String getCaseflag() {
		return this.caseflag;
	}
	public void setCasetype(java.lang.String value) {
		this.casetype = value;
	}
	
	public java.lang.String getCasetype() {
		return this.casetype;
	}
	public void setCasedesc(java.lang.String value) {
		this.casedesc = value;
	}
	
	public java.lang.String getCasedesc() {
		return this.casedesc;
	}
	public void setId(java.lang.String value) {
		this.id = value;
	}
	
	public java.lang.String getId() {
		return this.id;
	}
	public void setFlagpack(java.lang.String value) {
		this.flagpack = value;
	}
	
	public java.lang.String getFlagpack() {
		return this.flagpack;
	}

	public String toString() {
		return new ToStringBuilder(this)
			.append("Cpcode",getCpcode())
			.append("Casecode",getCasecode())
			.append("Happentime",getHappentime())
			.append("Caseflag",getCaseflag())
			.append("Casetype",getCasetype())
			.append("Casedesc",getCasedesc())
			.append("Id",getId())
			.append("Flagpack",getFlagpack())
			.append("name",getName())
			.toString();
	}
	
	public int hashCode() {
		return new HashCodeBuilder()
			.append(getCpcode())
			.append(getCasecode())
			.append(getHappentime())
			.append(getCaseflag())
			.append(getCasetype())
			.append(getCasedesc())
			.append(getId())
			.append(getFlagpack())
			.append(getName())
			.toHashCode();
	}
	
	public boolean equals(Object obj) {
		if(obj instanceof Tcpcaseinfo == false) return false;
		if(this == obj) return true;
		Tcpcaseinfo other = (Tcpcaseinfo)obj;
		return new EqualsBuilder()
			.append(getCpcode(),other.getCpcode())
			.append(getCasecode(),other.getCasecode())
			.append(getHappentime(),other.getHappentime())
			.append(getCaseflag(),other.getCaseflag())
			.append(getCasetype(),other.getCasetype())
			.append(getCasedesc(),other.getCasedesc())
			.append(getId(),other.getId())
			.append(getFlagpack(),other.getFlagpack())
			.append(getName(),other.getName())
			.isEquals();
	}
}

