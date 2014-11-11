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


public class TpoliceCheckinfo extends BaseEntity {
	
	//alias
	public static final String TABLE_ALIAS = "检查信息";
	public static final String ALIAS_CHECKINFOID = "ID";
	public static final String ALIAS_CHECKID = "检查ID";
	public static final String ALIAS_ITEM = "检查项目";
	public static final String ALIAS_DETAIL = "信息详情";
	
	//date formats
	
	//columns START
	private Long checkinfoid;
	private Long checkid;
	private String item;
	private String detail;
	//columns END

	public TpoliceCheckinfo(){
	}

	public TpoliceCheckinfo(
		Long checkinfoid
	){
		this.checkinfoid = checkinfoid;
	}

	public void setCheckinfoid(Long value) {
		this.checkinfoid = value;
	}
	
	public Long getCheckinfoid() {
		return this.checkinfoid;
	}
	public void setCheckid(Long value) {
		this.checkid = value;
	}
	
	public Long getCheckid() {
		return this.checkid;
	}
	public void setItem(String value) {
		this.item = value;
	}
	
	public String getItem() {
		return this.item;
	}
	public void setDetail(String value) {
		this.detail = value;
	}
	
	public String getDetail() {
		return this.detail;
	}

	public String toString() {
		return new ToStringBuilder(this)
			.append("Checkinfoid",getCheckinfoid())
			.append("Checkid",getCheckid())
			.append("Item",getItem())
			.append("Detail",getDetail())
			.toString();
	}
	
	public int hashCode() {
		return new HashCodeBuilder()
			.append(getCheckinfoid())
			.append(getCheckid())
			.append(getItem())
			.append(getDetail())
			.toHashCode();
	}
	
	public boolean equals(Object obj) {
		if(obj instanceof TpoliceCheckinfo == false) return false;
		if(this == obj) return true;
		TpoliceCheckinfo other = (TpoliceCheckinfo)obj;
		return new EqualsBuilder()
			.append(getCheckinfoid(),other.getCheckinfoid())
			.append(getCheckid(),other.getCheckid())
			.append(getItem(),other.getItem())
			.append(getDetail(),other.getDetail())
			.isEquals();
	}
}

