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


public class TbuyPic extends BaseEntity {
	
	//alias
	public static final String TABLE_ALIAS = "购油顾客照片表";
	public static final String ALIAS_ID = "购油记录ID(编码规则：12位企业代码+YYYYMMDD+4位流水号)";
	public static final String ALIAS_PICLEN = "照片长度(字节)";
	public static final String ALIAS_PICTURE = "照片实体";
	
	//date formats
	
	//columns START
	private java.lang.String id;
	private int piclen;
	private  byte[] picture;
	//columns END

	public TbuyPic(){
	}

	public TbuyPic(
		java.lang.String id
	){
		this.id = id;
	}

	public void setId(java.lang.String value) {
		this.id = value;
	}
	
	public java.lang.String getId() {
		return this.id;
	}

	public String toString() {
		return new ToStringBuilder(this)
			.append("Id",getId())
			.append("Piclen",getPiclen())
			.append("Picture",getPicture())
			.toString();
	}
	
	public int hashCode() {
		return new HashCodeBuilder()
			.append(getId())
			.append(getPiclen())
			.append(getPicture())
			.toHashCode();
	}
	
	public boolean equals(Object obj) {
		if(obj instanceof TbuyPic == false) return false;
		if(this == obj) return true;
		TbuyPic other = (TbuyPic)obj;
		return new EqualsBuilder()
			.append(getId(),other.getId())
			.append(getPiclen(),other.getPiclen())
			.append(getPicture(),other.getPicture())
			.isEquals();
	}

	public int getPiclen() {
		return piclen;
	}

	public void setPiclen(int piclen) {
		this.piclen = piclen;
	}

	public byte[] getPicture() {
		return picture;
	}

	public void setPicture(byte[] picture) {
		this.picture = picture;
	}
}

