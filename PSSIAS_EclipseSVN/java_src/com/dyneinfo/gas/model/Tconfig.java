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


public class Tconfig extends BaseEntity {
	
	//alias
	public static final String TABLE_ALIAS = "系统配置";
	public static final String ALIAS_CODE = "值";
	public static final String ALIAS_NAME = "配置项说明";
	public static final String ALIAS_KEY = "配置项关键字";
	
	//date formats
	
	//columns START
	private java.lang.String code;
	private java.lang.String name;
	private java.lang.String key;
	//columns END

	public Tconfig(){
	}

	public Tconfig(
		java.lang.String key
	){
		this.key = key;
	}

	public void setCode(java.lang.String value) {
		this.code = value;
	}
	
	public java.lang.String getCode() {
		return this.code;
	}
	public void setName(java.lang.String value) {
		this.name = value;
	}
	
	public java.lang.String getName() {
		return this.name;
	}
	public void setKey(java.lang.String value) {
		this.key = value;
	}
	
	public java.lang.String getKey() {
		return this.key;
	}

	public String toString() {
		return new ToStringBuilder(this)
			.append("Code",getCode())
			.append("Name",getName())
			.append("Key",getKey())
			.toString();
	}
	
	public int hashCode() {
		return new HashCodeBuilder()
			.append(getCode())
			.append(getName())
			.append(getKey())
			.toHashCode();
	}
	
	public boolean equals(Object obj) {
		if(obj instanceof Tconfig == false) return false;
		if(this == obj) return true;
		Tconfig other = (Tconfig)obj;
		return new EqualsBuilder()
			.append(getCode(),other.getCode())
			.append(getName(),other.getName())
			.append(getKey(),other.getKey())
			.isEquals();
	}
}

