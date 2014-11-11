/*
 * Powered By [lishicheng]
 */

package com.dyneinfo.zazh.model;

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

import com.dyneinfo.zazh.model.*;
import com.dyneinfo.zazh.dao.*;
import com.dyneinfo.zazh.service.*;

/**
 * @author lisc email:lishicheng(a)gmail.com
 */


public class TpersonbaseJn extends BaseEntity {
	
	//alias
	public static final String TABLE_ALIAS = "境内人员";
	public static final String ALIAS_ID = "人员ID(取值：SEQ_T_PERSONBASE_JN)";
	public static final String ALIAS_NAME = "姓名";
	public static final String ALIAS_SEX = "性别";
	public static final String ALIAS_NATION = "民族";
	public static final String ALIAS_BDATE = "出生日期";
	public static final String ALIAS_CARDNAME = "证件类型";
	public static final String ALIAS_CARDCODE = "证件号码";
	public static final String ALIAS_XZQH = "户籍地代码";
	public static final String ALIAS_ADDRESS = "详细住址";
	public static final String ALIAS_UPDATETIME = "最后更新时间";
	
	//date formats
	public static final String FORMAT_UPDATETIME = DATE_TIME_FORMAT;
	
	//columns START
	private Long id;
	private java.lang.String name;
	private java.lang.String sex;
	private java.lang.String nation;
	private java.lang.String bdate;
	private java.lang.String cardname;
	private java.lang.String cardcode;
	private java.lang.String xzqh;
	private java.lang.String address;
	private java.util.Date updatetime;
	//columns END

	public TpersonbaseJn(){
	}

	public TpersonbaseJn(
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
	public void setName(java.lang.String value) {
		this.name = value;
	}
	
	public java.lang.String getName() {
		return this.name;
	}
	public void setSex(java.lang.String value) {
		this.sex = value;
	}
	
	public java.lang.String getSex() {
		return this.sex;
	}
	public void setNation(java.lang.String value) {
		this.nation = value;
	}
	
	public java.lang.String getNation() {
		return this.nation;
	}
	public void setBdate(java.lang.String value) {
		this.bdate = value;
	}
	
	public java.lang.String getBdate() {
		return this.bdate;
	}
	public void setCardname(java.lang.String value) {
		this.cardname = value;
	}
	
	public java.lang.String getCardname() {
		return this.cardname;
	}
	public void setCardcode(java.lang.String value) {
		this.cardcode = value;
	}
	
	public java.lang.String getCardcode() {
		return this.cardcode;
	}
	public void setXzqh(java.lang.String value) {
		this.xzqh = value;
	}
	
	public java.lang.String getXzqh() {
		return this.xzqh;
	}
	public void setAddress(java.lang.String value) {
		this.address = value;
	}
	
	public java.lang.String getAddress() {
		return this.address;
	}
	public String getUpdatetimeString() {
		return date2String(getUpdatetime(), FORMAT_UPDATETIME);
	}
	public void setUpdatetimeString(String value) {
		setUpdatetime(string2Date(value, FORMAT_UPDATETIME,java.util.Date.class));
	}
	
	public void setUpdatetime(java.util.Date value) {
		this.updatetime = value;
	}
	
	public java.util.Date getUpdatetime() {
		return this.updatetime;
	}

	public String toString() {
		return new ToStringBuilder(this)
			.append("Id",getId())
			.append("Name",getName())
			.append("Sex",getSex())
			.append("Nation",getNation())
			.append("Bdate",getBdate())
			.append("Cardname",getCardname())
			.append("Cardcode",getCardcode())
			.append("Xzqh",getXzqh())
			.append("Address",getAddress())
			.append("Updatetime",getUpdatetime())
			.toString();
	}
	
	public int hashCode() {
		return new HashCodeBuilder()
			.append(getId())
			.append(getName())
			.append(getSex())
			.append(getNation())
			.append(getBdate())
			.append(getCardname())
			.append(getCardcode())
			.append(getXzqh())
			.append(getAddress())
			.append(getUpdatetime())
			.toHashCode();
	}
	
	public boolean equals(Object obj) {
		if(obj instanceof TpersonbaseJn == false) return false;
		if(this == obj) return true;
		TpersonbaseJn other = (TpersonbaseJn)obj;
		return new EqualsBuilder()
			.append(getId(),other.getId())
			.append(getName(),other.getName())
			.append(getSex(),other.getSex())
			.append(getNation(),other.getNation())
			.append(getBdate(),other.getBdate())
			.append(getCardname(),other.getCardname())
			.append(getCardcode(),other.getCardcode())
			.append(getXzqh(),other.getXzqh())
			.append(getAddress(),other.getAddress())
			.append(getUpdatetime(),other.getUpdatetime())
			.isEquals();
	}
}

