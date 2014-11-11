/*
 * Powered By [lishicheng]
 */

package com.dyneinfo.hotel.model;

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

import com.dyneinfo.hotel.model.*;
import com.dyneinfo.hotel.dao.*;
import com.dyneinfo.hotel.service.*;

/**
 * @author lisc email:lishicheng(a)gmail.com
 */


public class Tcarinfo extends BaseEntity {
	
	//alias
	public static final String TABLE_ALIAS = "车辆";
	public static final String ALIAS_ENROLID = "登记序号";
	public static final String ALIAS_CAROWNER = "车主";
	public static final String ALIAS_CARTYPE = "车辆类型";
	public static final String ALIAS_BRAND = "车辆品牌";
	public static final String ALIAS_COLOR = "车身颜色";
	public static final String ALIAS_CARID = "车牌号";
	public static final String ALIAS_ENGINECODE = "发动机号";
	public static final String ALIAS_BODYCODE = "车架号";
	public static final String ALIAS_ENROLTIME = "登记时间";
	public static final String ALIAS_OPERATOR = "操作者";
	public static final String ALIAS_CPCODE = "入住旅馆";
	public static final String ALIAS_FLAG = "是否删除";
	public static final String ALIAS_CARPICTURE = "carpicture";
	
	//date formats
	
	//columns START
	private java.lang.String enrolid;
	private java.lang.String carowner;
	private java.lang.String cartype;
	private java.lang.String brand;
	private java.lang.String color;
	private java.lang.String carid;
	private java.lang.String enginecode;
	private java.lang.String bodycode;
	private java.lang.String enroltime;
	private java.lang.String operator;
	private java.lang.String cpcode;
	private java.lang.String flag;
	private java.lang.String hotelname;
	private java.sql.Blob carpicture;
	//columns END

	public Tcarinfo(){
	}

	public Tcarinfo(
		java.lang.String enrolid
	){
		this.enrolid = enrolid;
	}

	public void setEnrolid(java.lang.String value) {
		this.enrolid = value;
	}
	
	public java.lang.String getEnrolid() {
		return this.enrolid;
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
	public void setEnroltime(java.lang.String value) {
		this.enroltime = value;
	}
	
	public java.lang.String getEnroltime() {
		return this.enroltime;
	}
	public void setOperator(java.lang.String value) {
		this.operator = value;
	}
	
	public java.lang.String getOperator() {
		return this.operator;
	}
	public void setCpcode(java.lang.String value) {
		this.cpcode = value;
	}
	
	public java.lang.String getCpcode() {
		return this.cpcode;
	}
	public void setFlag(java.lang.String value) {
		this.flag = value;
	}
	
	public java.lang.String getFlag() {
		return this.flag;
	}
	public void setCarpicture(java.sql.Blob value) {
		this.carpicture = value;
	}
	
	public java.sql.Blob getCarpicture() {
		return this.carpicture;
	}

	public String toString() {
		return new ToStringBuilder(this)
			.append("Enrolid",getEnrolid())
			.append("Carowner",getCarowner())
			.append("Cartype",getCartype())
			.append("Brand",getBrand())
			.append("Color",getColor())
			.append("Carid",getCarid())
			.append("Enginecode",getEnginecode())
			.append("Bodycode",getBodycode())
			.append("Enroltime",getEnroltime())
			.append("Operator",getOperator())
			.append("Cpcode",getCpcode())
			.append("Flag",getFlag())
			.append("Carpicture",getCarpicture())
			.toString();
	}
	
	public int hashCode() {
		return new HashCodeBuilder()
			.append(getEnrolid())
			.append(getCarowner())
			.append(getCartype())
			.append(getBrand())
			.append(getColor())
			.append(getCarid())
			.append(getEnginecode())
			.append(getBodycode())
			.append(getEnroltime())
			.append(getOperator())
			.append(getCpcode())
			.append(getFlag())
			.append(getCarpicture())
			.toHashCode();
	}
	
	public boolean equals(Object obj) {
		if(obj instanceof Tcarinfo == false) return false;
		if(this == obj) return true;
		Tcarinfo other = (Tcarinfo)obj;
		return new EqualsBuilder()
			.append(getEnrolid(),other.getEnrolid())
			.append(getCarowner(),other.getCarowner())
			.append(getCartype(),other.getCartype())
			.append(getBrand(),other.getBrand())
			.append(getColor(),other.getColor())
			.append(getCarid(),other.getCarid())
			.append(getEnginecode(),other.getEnginecode())
			.append(getBodycode(),other.getBodycode())
			.append(getEnroltime(),other.getEnroltime())
			.append(getOperator(),other.getOperator())
			.append(getCpcode(),other.getCpcode())
			.append(getFlag(),other.getFlag())
			.append(getCarpicture(),other.getCarpicture())
			.isEquals();
	}

	public java.lang.String getHotelname() {
		return hotelname;
	}

	public void setHotelname(java.lang.String hotelname) {
		this.hotelname = hotelname;
	}
}

