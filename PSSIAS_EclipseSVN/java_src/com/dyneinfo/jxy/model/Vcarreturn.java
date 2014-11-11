/*
 * Powered By [lishicheng]
 */

package com.dyneinfo.jxy.model;

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

import com.dyneinfo.jxy.dao.*;
import com.dyneinfo.jxy.model.*;
import com.dyneinfo.jxy.service.*;

/**
 * @author lisc email:lishicheng(a)gmail.com
 */


public class Vcarreturn extends BaseEntity {
	
	//alias

	
	public static final String TABLE_ALIAS = "承接车辆信息";
	public static final String ALIAS_CPCODE = "企业代码";
	public static final String ALIAS_CPNAME ="企业名称";
	public static final String ALIAS_STATION="所属派出所";
	public static final String ALIAS_CAROWNER="车主姓名";
	public static final String ALIAS_CARTYPE="车辆类型";
	public static final String ALIAS_CARID="车牌号";
	public static final String ALIAS_ENGINECODE="发动机号";
	public static final String ALIAS_BODYCODE="车架号";
	public static final String ALIAS_DELINAME="送车人姓名";
	public static final String ALIAS_RECENAME="收车人姓名";
	public static final String ALIAS_TOTIME="取车时间";
	public static final String ALIAS_RECETIME="送车时间";
	public static final String ALIAS_CARPICTURE="详细信息";
	//date formats
	
	
	
	private java.lang.String cpcode;
	private java.lang.String cpname;
	private java.lang.String station;
	private java.lang.String carowner;
	private java.lang.String cartype;
	private java.lang.String carid;
	private java.lang.String enginecode;
	private java.lang.String bodycode;
	private java.lang.String deliname;
	private java.lang.String recename;
	private java.lang.String totime;
	private java.lang.String recetime;
	private java.lang.String carpicture;
	private java.lang.String enrolid;
	
	//columns START
	
	//columns END

	public java.lang.String getEnrolid() {
		return enrolid;
	}





	public void setEnrolid(java.lang.String enrolid) {
		this.enrolid = enrolid;
	}





	public Vcarreturn(){
	}

	

	

	public java.lang.String getCpcode() {
		return cpcode;
	}

	public void setCpcode(java.lang.String value) {
		this.cpcode = value;
	}

	public java.lang.String getCpname() {
		return cpname;
	}

	public void setCpname(java.lang.String value) {
		this.cpname = value;
	}

	public java.lang.String getStation() {
		return station;
	}

	public void setStation(java.lang.String value) {
		this.station = value;
	}

	public java.lang.String getCarowner() {
		return carowner;
	}

	public void setCarowner(java.lang.String value) {
		this.carowner = value;
	}

	public java.lang.String getCartype() {
		return cartype;
	}

	public void setCartype(java.lang.String value) {
		this.cartype = value;
	}

	public java.lang.String getCarid() {
		return carid;
	}

	public void setCarid(java.lang.String value) {
		this.carid = value;
	}

	public java.lang.String getEnginecode() {
		return enginecode;
	}

	public void setEnginecode(java.lang.String value) {
		this.enginecode = value;
	}

	public java.lang.String getBodycode() {
		return bodycode;
	}

	public void setBodycode(java.lang.String value) {
		this.bodycode = value;
	}

	public java.lang.String getDeliname() {
		return deliname;
	}

	public void setDeliname(java.lang.String value) {
		this.deliname = value;
	}

	public java.lang.String getRecename() {
		return recename;
	}

	public void setRecename(java.lang.String value) {
		this.recename = value;
	}

	public java.lang.String getTotime() {
		return totime;
	}

	public void setTotime(java.lang.String value) {
		this.totime = value;
	}

	public java.lang.String getRecetime() {
		return recetime;
	}

	public void setRecetime(java.lang.String value) {
		this.recetime = value;
	}

	public java.lang.String getCarpicture() {
		return carpicture;
	}

	public void setCarpicture(java.lang.String value) {
		this.carpicture = value;
	}

	public String toString() {
		//cpcode,cpname,station,carowner,cartype, carid,enginecode,bodycode, deliname,recename,totime,recetime,carpicture
		return new ToStringBuilder(this)
			.append("cpcode",getCpcode())
			.append("cpname",getCpname())
			.append("station",getStation())
			.append("carowner",getCarowner())
			.append("cartype",getCartype())
			
			.append("carid",getCarid())
			.append("enginecode",getEnginecode())
			
			.append("bodycode",getBodycode())
			.append("deliname",getDeliname())
			.append("recename",getRecename())
			.append("totime",getTotime())
			.append("recetime",getRecetime())
			.append("carpicture",getCarpicture())
			.append("enrolid",getEnrolid())
			
			.toString();
	}
	
	public int hashCode() {
		return new HashCodeBuilder()
			.append(getCpcode())
			.append(getCpname())
			.append(getStation())
			.append(getCarowner())
			
			.append(getCartype())
			.append(getCarid())
			.append(getEnginecode())
			
			.append(getBodycode())
			.append(getDeliname())
			.append(getRecename())
			
			.append(getTotime())
			.append(getRecetime())
			.append(getCarpicture())
			.append(getEnrolid())
			
			.toHashCode();
	}
	
	public boolean equals(Object obj) {
		if(obj instanceof Vcarreturn == false) return false;
		if(this == obj) return true;
		Vcarreturn other = (Vcarreturn)obj;
		return new EqualsBuilder()
			.append(getCpcode(),other.getCpcode())
			.append(getCpname(),other.getCpname())
			.append(getStation(),other.getStation())
			.append(getCarowner(),other.getCarowner())
			
			.append(getCartype(),other.getCartype())
			.append(getCarid(),other.getCarid())
			.append(getEnginecode(),other.getEnginecode())
			
			.append(getBodycode(),other.getBodycode())
			.append(getDeliname(),other.getDeliname())
			.append(getRecename(),other.getRecename())
			.append(getTotime(),other.getTotime())
			.append(getRecetime(),other.getRecetime())
			.append(getCarpicture(),other.getCarpicture())
			.append(getEnrolid(), other.getEnrolid())
			
			.isEquals();
	}
}

