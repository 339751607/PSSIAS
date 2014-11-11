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


public class TxctbPic extends BaseEntity {
	
	//alias
	public static final String TABLE_ALIAS = "协查通报照片表";
	public static final String ALIAS_ID = "照片流水号";
	public static final String ALIAS_TBID = "协查通报ID";
	public static final String ALIAS_PICTURE = "照片实体";
	
	//date formats
	
	//columns START
	private Long id;
	private Long tbid;
	private java.sql.Blob picture;
	//columns END

	public TxctbPic(){
	}

	public TxctbPic(
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
	public void setTbid(Long value) {
		this.tbid = value;
	}
	
	public Long getTbid() {
		return this.tbid;
	}
	public void setPicture(java.sql.Blob value) {
		this.picture = value;
	}
	
	public java.sql.Blob getPicture() {
		return this.picture;
	}

	public String toString() {
		return new ToStringBuilder(this)
			.append("Id",getId())
			.append("Tbid",getTbid())
			.append("Picture",getPicture())
			.toString();
	}
	
	public int hashCode() {
		return new HashCodeBuilder()
			.append(getId())
			.append(getTbid())
			.append(getPicture())
			.toHashCode();
	}
	
	public boolean equals(Object obj) {
		if(obj instanceof TxctbPic == false) return false;
		if(this == obj) return true;
		TxctbPic other = (TxctbPic)obj;
		return new EqualsBuilder()
			.append(getId(),other.getId())
			.append(getTbid(),other.getTbid())
			.append(getPicture(),other.getPicture())
			.isEquals();
	}
}

