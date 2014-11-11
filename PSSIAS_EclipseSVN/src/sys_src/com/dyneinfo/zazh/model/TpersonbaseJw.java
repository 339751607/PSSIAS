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


public class TpersonbaseJw extends BaseEntity {
	
	//alias
	public static final String TABLE_ALIAS = "境外人员";
	public static final String ALIAS_ID = "人员ID（取值：SEQ_T_PERSONBASE_JW）";
	public static final String ALIAS_SURNAME = "英文姓";
	public static final String ALIAS_NAME = "英文名";
	public static final String ALIAS_CH_NAME = "中文姓名";
	public static final String ALIAS_SEX = "性别";
	public static final String ALIAS_BDATE = "出生日期";
	public static final String ALIAS_NATIONALITY = "国籍";
	public static final String ALIAS_PASS_T = "证件类型";
	public static final String ALIAS_PASS_NO = "证件号码";
	public static final String ALIAS_VISA_T = "签证种类";
	public static final String ALIAS_VISA_NO = "签证号码";
	public static final String ALIAS_STAY_DATE = "签证有效期";
	public static final String ALIAS_QF_UNIT = "签证签发机关";
	public static final String ALIAS_IN_DATE = "入境日期";
	public static final String ALIAS_IN_PORT = "入境口岸";
	public static final String ALIAS_UPDATETIME = "最后更新时间";
	
	//date formats
	public static final String FORMAT_UPDATETIME = DATE_TIME_FORMAT;
	
	//columns START
	private Long id;
	private java.lang.String surname;
	private java.lang.String name;
	private java.lang.String chName;
	private java.lang.String sex;
	private java.lang.String bdate;
	private java.lang.String nationality;
	private java.lang.String passT;
	private java.lang.String passNo;
	private java.lang.String visaT;
	private java.lang.String visaNo;
	private java.lang.String stayDate;
	private java.lang.String qfUnit;
	private java.lang.String inDate;
	private java.lang.String inPort;
	private java.util.Date updatetime;
	//columns END

	public TpersonbaseJw(){
	}

	public TpersonbaseJw(
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
	public void setSurname(java.lang.String value) {
		this.surname = value;
	}
	
	public java.lang.String getSurname() {
		return this.surname;
	}
	public void setName(java.lang.String value) {
		this.name = value;
	}
	
	public java.lang.String getName() {
		return this.name;
	}
	public void setChName(java.lang.String value) {
		this.chName = value;
	}
	
	public java.lang.String getChName() {
		return this.chName;
	}
	public void setSex(java.lang.String value) {
		this.sex = value;
	}
	
	public java.lang.String getSex() {
		return this.sex;
	}
	public void setBdate(java.lang.String value) {
		this.bdate = value;
	}
	
	public java.lang.String getBdate() {
		return this.bdate;
	}
	public void setNationality(java.lang.String value) {
		this.nationality = value;
	}
	
	public java.lang.String getNationality() {
		return this.nationality;
	}
	public void setPassT(java.lang.String value) {
		this.passT = value;
	}
	
	public java.lang.String getPassT() {
		return this.passT;
	}
	public void setPassNo(java.lang.String value) {
		this.passNo = value;
	}
	
	public java.lang.String getPassNo() {
		return this.passNo;
	}
	public void setVisaT(java.lang.String value) {
		this.visaT = value;
	}
	
	public java.lang.String getVisaT() {
		return this.visaT;
	}
	public void setVisaNo(java.lang.String value) {
		this.visaNo = value;
	}
	
	public java.lang.String getVisaNo() {
		return this.visaNo;
	}
	public void setStayDate(java.lang.String value) {
		this.stayDate = value;
	}
	
	public java.lang.String getStayDate() {
		return this.stayDate;
	}
	public void setQfUnit(java.lang.String value) {
		this.qfUnit = value;
	}
	
	public java.lang.String getQfUnit() {
		return this.qfUnit;
	}
	public void setInDate(java.lang.String value) {
		this.inDate = value;
	}
	
	public java.lang.String getInDate() {
		return this.inDate;
	}
	public void setInPort(java.lang.String value) {
		this.inPort = value;
	}
	
	public java.lang.String getInPort() {
		return this.inPort;
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
			.append("Surname",getSurname())
			.append("Name",getName())
			.append("ChName",getChName())
			.append("Sex",getSex())
			.append("Bdate",getBdate())
			.append("Nationality",getNationality())
			.append("PassT",getPassT())
			.append("PassNo",getPassNo())
			.append("VisaT",getVisaT())
			.append("VisaNo",getVisaNo())
			.append("StayDate",getStayDate())
			.append("QfUnit",getQfUnit())
			.append("InDate",getInDate())
			.append("InPort",getInPort())
			.append("Updatetime",getUpdatetime())
			.toString();
	}
	
	public int hashCode() {
		return new HashCodeBuilder()
			.append(getId())
			.append(getSurname())
			.append(getName())
			.append(getChName())
			.append(getSex())
			.append(getBdate())
			.append(getNationality())
			.append(getPassT())
			.append(getPassNo())
			.append(getVisaT())
			.append(getVisaNo())
			.append(getStayDate())
			.append(getQfUnit())
			.append(getInDate())
			.append(getInPort())
			.append(getUpdatetime())
			.toHashCode();
	}
	
	public boolean equals(Object obj) {
		if(obj instanceof TpersonbaseJw == false) return false;
		if(this == obj) return true;
		TpersonbaseJw other = (TpersonbaseJw)obj;
		return new EqualsBuilder()
			.append(getId(),other.getId())
			.append(getSurname(),other.getSurname())
			.append(getName(),other.getName())
			.append(getChName(),other.getChName())
			.append(getSex(),other.getSex())
			.append(getBdate(),other.getBdate())
			.append(getNationality(),other.getNationality())
			.append(getPassT(),other.getPassT())
			.append(getPassNo(),other.getPassNo())
			.append(getVisaT(),other.getVisaT())
			.append(getVisaNo(),other.getVisaNo())
			.append(getStayDate(),other.getStayDate())
			.append(getQfUnit(),other.getQfUnit())
			.append(getInDate(),other.getInDate())
			.append(getInPort(),other.getInPort())
			.append(getUpdatetime(),other.getUpdatetime())
			.isEquals();
	}
}

