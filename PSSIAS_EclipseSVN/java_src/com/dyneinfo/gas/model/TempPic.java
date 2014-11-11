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


public class TempPic extends BaseEntity {
	
	//alias
	public static final String TABLE_ALIAS = "TempPic";
	public static final String ALIAS_EMPCODE = "从业人员编码";
	public static final String ALIAS_PICLEN = "照片长度";
	public static final String ALIAS_PICTURE = "照片实体";
	
	//date formats
	
	//columns START
	private java.lang.String empcode;
	private int piclen;
	private  byte[] picture;
	//columns END

	public TempPic(){
	}

	public TempPic(
		java.lang.String empcode
	){
		this.empcode = empcode;
	}

	public void setEmpcode(java.lang.String value) {
		this.empcode = value;
	}
	
	public java.lang.String getEmpcode() {
		return this.empcode;
	}

	public String toString() {
		return new ToStringBuilder(this)
			.append("Empcode",getEmpcode())
			.append("Piclen",getPiclen())
			.append("Picture",getPicture())
			.toString();
	}
	
	public int hashCode() {
		return new HashCodeBuilder()
			.append(getEmpcode())
			.append(getPiclen())
			.append(getPicture())
			.toHashCode();
	}
	
	public boolean equals(Object obj) {
		if(obj instanceof TempPic == false) return false;
		if(this == obj) return true;
		TempPic other = (TempPic)obj;
		return new EqualsBuilder()
			.append(getEmpcode(),other.getEmpcode())
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

