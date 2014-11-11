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


public class Tbuylog extends BaseEntity {
	
	//alias
	public static final String TABLE_ALIAS = "购油信息";
	public static final String ALIAS_ID = "购油记录ID";
	public static final String ALIAS_NAME = "购油人";
	public static final String ALIAS_SEX = "性别";
	public static final String ALIAS_NATION = "民族";
	public static final String ALIAS_BDATE = "出生日期";
	public static final String ALIAS_ID_NAME = "证件类型";
	public static final String ALIAS_ID_CODE = "证件号码";
	public static final String ALIAS_XZQH = "地址行政区划";
	public static final String ALIAS_ADDRESS = "详细地址";
	public static final String ALIAS_WORKUNIT = "工作单位";
	public static final String ALIAS_PHONE = "联系电话";
	public static final String ALIAS_USE = "购油用途";
	public static final String ALIAS_BUYTYPE = "油品类别";
	public static final String ALIAS_SORT = "油品型号";
	public static final String ALIAS_QUANTITY = "购油数量";
	public static final String ALIAS_LOGTIME = "购油时间";
	public static final String ALIAS_TRATIME = "上传时间";
	public static final String ALIAS_OPERATOR = "操作员";
	public static final String ALIAS_STACODE = "所属派出所";
	public static final String ALIAS_BURCODE = "所属分局";
	public static final String ALIAS_CPCODE = "售油企业";
	public static final String ALIAS_GYCS = "购油次数";
	
	//date formats
	
	//columns START
	private java.lang.String id;
	private java.lang.String name;
	private java.lang.String sex;
	private java.lang.String nation;
	private java.lang.String bdate;
	private java.lang.String idName;
	private java.lang.String idCode;
	private java.lang.String xzqh;
	private java.lang.String address;
	private java.lang.String workunit;
	private java.lang.String phone;
	private java.lang.String use;
	private java.lang.String buytype;
	private java.lang.String sort;
	private Long quantity;
	private java.lang.String logtime;
	private java.lang.String tratime;
	private java.lang.String operator;
	private java.lang.String stacode;
	private java.lang.String burcode;
	private java.lang.String cpcode;
	private java.lang.String cpname;
	private java.lang.String gycs;
	private java.lang.String polityvisage;
	private java.lang.String nativeplace;
	private java.lang.String pPhotoBuffer;
	//columns END

	public Tbuylog(){
	}

	public Tbuylog(
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
	public void setIdName(java.lang.String value) {
		this.idName = value;
	}
	
	public java.lang.String getIdName() {
		return this.idName;
	}
	public void setIdCode(java.lang.String value) {
		this.idCode = value;
	}
	
	public java.lang.String getIdCode() {
		return this.idCode;
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
	public void setWorkunit(java.lang.String value) {
		this.workunit = value;
	}
	
	public java.lang.String getWorkunit() {
		return this.workunit;
	}
	public void setPhone(java.lang.String value) {
		this.phone = value;
	}
	
	public java.lang.String getPhone() {
		return this.phone;
	}
	public void setUse(java.lang.String value) {
		this.use = value;
	}
	
	public java.lang.String getUse() {
		return this.use;
	}
	public void setBuytype(java.lang.String value) {
		this.buytype = value;
	}
	
	public java.lang.String getBuytype() {
		return this.buytype;
	}
	public void setSort(java.lang.String value) {
		this.sort = value;
	}
	
	public java.lang.String getSort() {
		return this.sort;
	}
	public void setQuantity(Long value) {
		this.quantity = value;
	}
	
	public Long getQuantity() {
		return this.quantity;
	}
	public void setLogtime(java.lang.String value) {
		this.logtime = value;
	}
	
	public java.lang.String getLogtime() {
		return this.logtime;
	}
	public void setTratime(java.lang.String value) {
		this.tratime = value;
	}
	
	public java.lang.String getTratime() {
		return this.tratime;
	}
	public void setOperator(java.lang.String value) {
		this.operator = value;
	}
	
	public java.lang.String getOperator() {
		return this.operator;
	}
	public void setStacode(java.lang.String value) {
		this.stacode = value;
	}
	
	public java.lang.String getStacode() {
		return this.stacode;
	}
	public void setBurcode(java.lang.String value) {
		this.burcode = value;
	}
	
	public java.lang.String getBurcode() {
		return this.burcode;
	}
	public void setCpcode(java.lang.String value) {
		this.cpcode = value;
	}
	
	public java.lang.String getCpcode() {
		return this.cpcode;
	}
	public void setGycs(java.lang.String value) {
		this.gycs = value;
	}
	
	public java.lang.String getGycs() {
		return this.gycs;
	}

	public String toString() {
		return new ToStringBuilder(this)
			.append("Id",getId())
			.append("Name",getName())
			.append("Sex",getSex())
			.append("Nation",getNation())
			.append("Bdate",getBdate())
			.append("IdName",getIdName())
			.append("IdCode",getIdCode())
			.append("Xzqh",getXzqh())
			.append("Address",getAddress())
			.append("Workunit",getWorkunit())
			.append("Phone",getPhone())
			.append("Use",getUse())
			.append("Buytype",getBuytype())
			.append("Sort",getSort())
			.append("Quantity",getQuantity())
			.append("Logtime",getLogtime())
			.append("Tratime",getTratime())
			.append("Operator",getOperator())
			.append("Stacode",getStacode())
			.append("Burcode",getBurcode())
			.append("Cpcode",getCpcode())
			.append("Gycs",getGycs())
			.toString();
	}
	
	public int hashCode() {
		return new HashCodeBuilder()
			.append(getId())
			.append(getName())
			.append(getSex())
			.append(getNation())
			.append(getBdate())
			.append(getIdName())
			.append(getIdCode())
			.append(getXzqh())
			.append(getAddress())
			.append(getWorkunit())
			.append(getPhone())
			.append(getUse())
			.append(getBuytype())
			.append(getSort())
			.append(getQuantity())
			.append(getLogtime())
			.append(getTratime())
			.append(getOperator())
			.append(getStacode())
			.append(getBurcode())
			.append(getCpcode())
			.append(getGycs())
			.toHashCode();
	}
	
	public boolean equals(Object obj) {
		if(obj instanceof Tbuylog == false) return false;
		if(this == obj) return true;
		Tbuylog other = (Tbuylog)obj;
		return new EqualsBuilder()
			.append(getId(),other.getId())
			.append(getName(),other.getName())
			.append(getSex(),other.getSex())
			.append(getNation(),other.getNation())
			.append(getBdate(),other.getBdate())
			.append(getIdName(),other.getIdName())
			.append(getIdCode(),other.getIdCode())
			.append(getXzqh(),other.getXzqh())
			.append(getAddress(),other.getAddress())
			.append(getWorkunit(),other.getWorkunit())
			.append(getPhone(),other.getPhone())
			.append(getUse(),other.getUse())
			.append(getBuytype(),other.getBuytype())
			.append(getSort(),other.getSort())
			.append(getQuantity(),other.getQuantity())
			.append(getLogtime(),other.getLogtime())
			.append(getTratime(),other.getTratime())
			.append(getOperator(),other.getOperator())
			.append(getStacode(),other.getStacode())
			.append(getBurcode(),other.getBurcode())
			.append(getCpcode(),other.getCpcode())
			.append(getGycs(),other.getGycs())
			.isEquals();
	}

	public java.lang.String getCpname() {
		return cpname;
	}

	public void setCpname(java.lang.String cpname) {
		this.cpname = cpname;
	}

	public java.lang.String getPolityvisage() {
		return polityvisage;
	}

	public void setPolityvisage(java.lang.String polityvisage) {
		this.polityvisage = polityvisage;
	}

	public java.lang.String getNativeplace() {
		return nativeplace;
	}

	public void setNativeplace(java.lang.String nativeplace) {
		this.nativeplace = nativeplace;
	}

	public java.lang.String getPPhotoBuffer() {
		return pPhotoBuffer;
	}

	public void setPPhotoBuffer(java.lang.String photoBuffer) {
		pPhotoBuffer = photoBuffer;
	}
}

