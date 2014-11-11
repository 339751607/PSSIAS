/*
 * Powered By [lishicheng]
 */

package com.dyneinfo.fjy.model;

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

import com.dyneinfo.fjy.model.*;
import com.dyneinfo.fjy.dao.*;
import com.dyneinfo.fjy.service.*;

/**
 * @author lisc email:lishicheng(a)gmail.com
 */


public class TcpCheckInfo extends BaseEntity {
	
	//alias
	public static final String TABLE_ALIAS = "TcpCheckInfo";
	public static final String ALIAS_ID = "id";
	public static final String ALIAS_CHECKID = "检查id";
	public static final String ALIAS_ITEM = "检查项目";
	public static final String ALIAS_DETAIL = "详情";
	
	//date formats
	
	//columns START
	private java.lang.Long id;
	private Long checkid;
	private String item;
	private String detail;
	//columns END

	public TcpCheckInfo(){
	}

	public TcpCheckInfo(
		java.lang.Long id
	){
		this.id = id;
	}

	public void setId(java.lang.Long value) {
		this.id = value;
	}
	
	public java.lang.Long getId() {
		return this.id;
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
			.append("Id",getId())
			.append("Checkid",getCheckid())
			.append("Item",getItem())
			.append("Detail",getDetail())
			.toString();
	}
	
	public int hashCode() {
		return new HashCodeBuilder()
			.append(getId())
			.append(getCheckid())
			.append(getItem())
			.append(getDetail())
			.toHashCode();
	}
	
	public boolean equals(Object obj) {
		if(obj instanceof TcpCheckInfo == false) return false;
		if(this == obj) return true;
		TcpCheckInfo other = (TcpCheckInfo)obj;
		return new EqualsBuilder()
			.append(getId(),other.getId())
			.append(getCheckid(),other.getCheckid())
			.append(getItem(),other.getItem())
			.append(getDetail(),other.getDetail())
			.isEquals();
	}
}

