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


public class Tcarbase extends BaseEntity {
	
	//alias
	public static final String TABLE_ALIAS = "车辆基本信息表";
	public static final String ALIAS_ID = "流水号";
	public static final String ALIAS_CAROWNER = "车主";
	public static final String ALIAS_CARTYPE = "车辆类型";
	public static final String ALIAS_BRAND = "车辆品牌";
	public static final String ALIAS_CARMODE = "车辆型号";
	public static final String ALIAS_COLOR = "车身颜色";
	public static final String ALIAS_CARID = "车牌号";
	public static final String ALIAS_ENGINECODE = "发动机号";
	public static final String ALIAS_BODYCODE = "车架号";
	public static final String ALIAS_UPDATETIME = "数据更新时间";
	
	//date formats
	public static final String FORMAT_UPDATETIME = DATE_TIME_FORMAT;
	
	//columns START
	private Long id;
	private java.lang.String carowner;
	private java.lang.String cartype;
	private java.lang.String brand;
	private java.lang.String carmode;
	private java.lang.String color;
	private java.lang.String carid;
	private java.lang.String enginecode;
	private java.lang.String bodycode;
	private java.util.Date updatetime;
	//columns END

	public Tcarbase(){
	}

	public Tcarbase(
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
	public void setCarowner(java.lang.String value) {
		this.carowner = value;
	}
	
	public java.lang.String getCarowner() {
		return this.carowner;
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
	public void setCarid(java.lang.String value) {
		this.carid = value;
	}
	
	public java.lang.String getCarid() {
		return this.carid;
	}
	public void setEnginecode(java.lang.String value) {
		this.enginecode = value;
	}
	
	public java.lang.String getEnginecode() {
		return this.enginecode;
	}
	public void setBodycode(java.lang.String value) {
		this.bodycode = value;
	}
	
	public java.lang.String getBodycode() {
		return this.bodycode;
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
			.append("Carowner",getCarowner())
			.append("Cartype",getCartype())
			.append("Brand",getBrand())
			.append("Carmode",getCarmode())
			.append("Color",getColor())
			.append("Carid",getCarid())
			.append("Enginecode",getEnginecode())
			.append("Bodycode",getBodycode())
			.append("Updatetime",getUpdatetime())
			.toString();
	}
	
	public int hashCode() {
		return new HashCodeBuilder()
			.append(getId())
			.append(getCarowner())
			.append(getCartype())
			.append(getBrand())
			.append(getCarmode())
			.append(getColor())
			.append(getCarid())
			.append(getEnginecode())
			.append(getBodycode())
			.append(getUpdatetime())
			.toHashCode();
	}
	
	public boolean equals(Object obj) {
		if(obj instanceof Tcarbase == false) return false;
		if(this == obj) return true;
		Tcarbase other = (Tcarbase)obj;
		return new EqualsBuilder()
			.append(getId(),other.getId())
			.append(getCarowner(),other.getCarowner())
			.append(getCartype(),other.getCartype())
			.append(getBrand(),other.getBrand())
			.append(getCarmode(),other.getCarmode())
			.append(getColor(),other.getColor())
			.append(getCarid(),other.getCarid())
			.append(getEnginecode(),other.getEnginecode())
			.append(getBodycode(),other.getBodycode())
			.append(getUpdatetime(),other.getUpdatetime())
			.isEquals();
	}
}

