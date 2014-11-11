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


public class TbkCar extends BaseEntity {
	
	//alias
	public static final String TABLE_ALIAS = "布控车辆信息";
	public static final String ALIAS_ID = "布控ID";
	public static final String ALIAS_CARCODE = "车牌号";
	public static final String ALIAS_BODYCODE = "车架号";
	public static final String ALIAS_ENGINECODE = "发动机号";
	public static final String ALIAS_CARTYPE = "车辆类型";
	public static final String ALIAS_BRAND = "车辆品牌";
	public static final String ALIAS_CARMODE = "车辆型号";
	public static final String ALIAS_COLOR = "车身颜色";
	public static final String ALIAS_CAROWNER = "车主姓名";
	public static final String ALIAS_BKPZR = "批准人";
	public static final String ALIAS_BKLX = "布控类型";
	public static final String ALIAS_BKDW = "布控单位";
	public static final String ALIAS_BKSJ = "布控时间";
	public static final String ALIAS_JYAQ = "简要案情";
	public static final String ALIAS_ALARMTEL = "接警电话";
	public static final String ALIAS_OPERATOR = "操作人";
	public static final String ALIAS_CANCELFLAG = "撤控标志";
	public static final String ALIAS_CANCELTIME = "撤控时间";
	public static final String ALIAS_CANCELCAUSE = "撤控原因";
	public static final String ALIAS_CANCELNAME = "撤控人姓名";
	
	//date formats
	
	//columns START
	private java.lang.String id;
	private java.lang.String prefix;
	private java.lang.String carcode;
	private java.lang.String bodycode;
	private java.lang.String enginecode;
	private java.lang.String cartype;
	private java.lang.String brand;
	private java.lang.String carmode;
	private java.lang.String color;
	private java.lang.String carowner;
	private java.lang.String bkpzr;
	private java.lang.String bklx;
	private java.lang.String bkdw;
	private java.lang.String bksj;
	private java.lang.String jyaq;
	private java.lang.String alarmtel;
	private java.lang.String operator;
	private java.lang.String cancelflag;
	private java.lang.String canceltime;
	private java.lang.String cancelcause;
	private java.lang.String cancelname;
	private java.lang.String deptname;
	//columns END

	public TbkCar(){
	}

	public TbkCar(
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
	public void setCarcode(java.lang.String value) {
		this.carcode = value;
	}
	
	public java.lang.String getCarcode() {
		return this.carcode;
	}
	public void setBodycode(java.lang.String value) {
		this.bodycode = value;
	}
	
	public java.lang.String getBodycode() {
		return this.bodycode;
	}
	public void setEnginecode(java.lang.String value) {
		this.enginecode = value;
	}
	
	public java.lang.String getEnginecode() {
		return this.enginecode;
	}
	public void setCartype(java.lang.String value) {
		this.cartype = value;
	}
	
	public java.lang.String getCartype() {
		return this.cartype;
	}
	public void setBrand(java.lang.String value) {
		this.brand = value;
	}
	
	public java.lang.String getBrand() {
		return this.brand;
	}
	public void setCarmode(java.lang.String value) {
		this.carmode = value;
	}
	
	public java.lang.String getCarmode() {
		return this.carmode;
	}
	public void setColor(java.lang.String value) {
		this.color = value;
	}
	
	public java.lang.String getColor() {
		return this.color;
	}
	public void setCarowner(java.lang.String value) {
		this.carowner = value;
	}
	
	public java.lang.String getCarowner() {
		return this.carowner;
	}
	public void setBkpzr(java.lang.String value) {
		this.bkpzr = value;
	}
	
	public java.lang.String getBkpzr() {
		return this.bkpzr;
	}
	public void setBklx(java.lang.String value) {
		this.bklx = value;
	}
	
	public java.lang.String getBklx() {
		return this.bklx;
	}
	public void setBkdw(java.lang.String value) {
		this.bkdw = value;
	}
	
	public java.lang.String getBkdw() {
		return this.bkdw;
	}
	public void setBksj(java.lang.String value) {
		this.bksj = value;
	}
	
	public java.lang.String getBksj() {
		return this.bksj;
	}
	public void setJyaq(java.lang.String value) {
		this.jyaq = value;
	}
	
	public java.lang.String getJyaq() {
		return this.jyaq;
	}
	public void setAlarmtel(java.lang.String value) {
		this.alarmtel = value;
	}
	
	public java.lang.String getAlarmtel() {
		return this.alarmtel;
	}
	public void setOperator(java.lang.String value) {
		this.operator = value;
	}
	
	public java.lang.String getOperator() {
		return this.operator;
	}
	public void setCancelflag(java.lang.String value) {
		this.cancelflag = value;
	}
	
	public java.lang.String getCancelflag() {
		return this.cancelflag;
	}
	public void setCanceltime(java.lang.String value) {
		this.canceltime = value;
	}
	
	public java.lang.String getCanceltime() {
		return this.canceltime;
	}
	public void setCancelcause(java.lang.String value) {
		this.cancelcause = value;
	}
	
	public java.lang.String getCancelcause() {
		return this.cancelcause;
	}
	public void setCancelname(java.lang.String value) {
		this.cancelname = value;
	}
	
	public java.lang.String getCancelname() {
		return this.cancelname;
	}

	public String toString() {
		return new ToStringBuilder(this)
			.append("Id",getId())
			.append("Carcode",getCarcode())
			.append("Bodycode",getBodycode())
			.append("Enginecode",getEnginecode())
			.append("Cartype",getCartype())
			.append("Brand",getBrand())
			.append("Carmode",getCarmode())
			.append("Color",getColor())
			.append("Carowner",getCarowner())
			.append("Bkpzr",getBkpzr())
			.append("Bklx",getBklx())
			.append("Bkdw",getBkdw())
			.append("Bksj",getBksj())
			.append("Jyaq",getJyaq())
			.append("Alarmtel",getAlarmtel())
			.append("Operator",getOperator())
			.append("Cancelflag",getCancelflag())
			.append("Canceltime",getCanceltime())
			.append("Cancelcause",getCancelcause())
			.append("Cancelname",getCancelname())
			.toString();
	}
	
	public int hashCode() {
		return new HashCodeBuilder()
			.append(getId())
			.append(getCarcode())
			.append(getBodycode())
			.append(getEnginecode())
			.append(getCartype())
			.append(getBrand())
			.append(getCarmode())
			.append(getColor())
			.append(getCarowner())
			.append(getBkpzr())
			.append(getBklx())
			.append(getBkdw())
			.append(getBksj())
			.append(getJyaq())
			.append(getAlarmtel())
			.append(getOperator())
			.append(getCancelflag())
			.append(getCanceltime())
			.append(getCancelcause())
			.append(getCancelname())
			.toHashCode();
	}
	
	public boolean equals(Object obj) {
		if(obj instanceof TbkCar == false) return false;
		if(this == obj) return true;
		TbkCar other = (TbkCar)obj;
		return new EqualsBuilder()
			.append(getId(),other.getId())
			.append(getCarcode(),other.getCarcode())
			.append(getBodycode(),other.getBodycode())
			.append(getEnginecode(),other.getEnginecode())
			.append(getCartype(),other.getCartype())
			.append(getBrand(),other.getBrand())
			.append(getCarmode(),other.getCarmode())
			.append(getColor(),other.getColor())
			.append(getCarowner(),other.getCarowner())
			.append(getBkpzr(),other.getBkpzr())
			.append(getBklx(),other.getBklx())
			.append(getBkdw(),other.getBkdw())
			.append(getBksj(),other.getBksj())
			.append(getJyaq(),other.getJyaq())
			.append(getAlarmtel(),other.getAlarmtel())
			.append(getOperator(),other.getOperator())
			.append(getCancelflag(),other.getCancelflag())
			.append(getCanceltime(),other.getCanceltime())
			.append(getCancelcause(),other.getCancelcause())
			.append(getCancelname(),other.getCancelname())
			.isEquals();
	}

	public java.lang.String getPrefix() {
		return prefix;
	}

	public void setPrefix(java.lang.String prefix) {
		this.prefix = prefix;
	}

	public java.lang.String getDeptname() {
		return deptname;
	}

	public void setDeptname(java.lang.String deptname) {
		this.deptname = deptname;
	}
}

