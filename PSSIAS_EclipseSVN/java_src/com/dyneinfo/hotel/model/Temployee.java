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


public class Temployee extends BaseEntity {
	
	//alias
	public static final String TABLE_ALIAS = "从业人员";
	public static final String ALIAS_EMPCODE = "人员编号";
	public static final String ALIAS_EMPNAME = "姓名";
	public static final String ALIAS_ALIAS = "别名";
	public static final String ALIAS_SEX = "性别";
	public static final String ALIAS_BIRTH = "出生日期";
	public static final String ALIAS_STATURE = "身高";
	public static final String ALIAS_WEIGHT = "体重";
	public static final String ALIAS_POSTURE = "体态";
	public static final String ALIAS_POLITYVISAGE = "政治面貌";
	public static final String ALIAS_FOLK = "民族";
	public static final String ALIAS_NATIVEPLACE = "籍贯";
	public static final String ALIAS_ADDRESS = "家庭住址";
	public static final String ALIAS_NOWADRESS = "暂住地址";
	public static final String ALIAS_PHONE = "联系电话";
	public static final String ALIAS_SCHOOLAGE = "学历";
	public static final String ALIAS_PERSONID = "身份证号";
	public static final String ALIAS_NPCODE = "户籍地";
	public static final String ALIAS_NPADDRESS = "详址";
	public static final String ALIAS_TEMPORARYCODE = "暂住证号";
	public static final String ALIAS_INSERTTIME = "入职时间";
	public static final String ALIAS_EDITTIME = "最后更新时间";
	public static final String ALIAS_HYZH = "婚姻状况";
	public static final String ALIAS_CYRJZT = "人员状态";
	public static final String ALIAS_TRATIME = "数据包传输时间";
	public static final String ALIAS_INDBTIME = "进入后台数据库时间";
	public static final String ALIAS_HOTELCODE = "旅馆代码";
	public static final String ALIAS_STACODE = "所属派出所";
	public static final String ALIAS_BURCODE = "所属分局";
	public static final String ALIAS_CITYCODE = "市局代码";
	public static final String ALIAS_TRANSFLAG = "transflag";
	public static final String ALIAS_HOTELNAME = "从业旅馆";	
	
	//date formats
	
	//columns START
	private java.lang.String empcode;
	private java.lang.String empname;
	private java.lang.String alias;
	private java.lang.String sex;
	private java.lang.String birth;
	private java.lang.String stature;
	private java.lang.String weight;
	private java.lang.String posture;
	private java.lang.String polityvisage;
	private java.lang.String folk;
	private java.lang.String nativeplace;
	private java.lang.String address;
	private java.lang.String nowadress;
	private java.lang.String phone;
	private java.lang.String schoolage;
	private java.lang.String personid;
	private java.lang.String xzqh;
	private java.lang.String npaddress;
	private java.lang.String temporarycode;
	private java.lang.String inserttime;
	private java.lang.String edittime;
	private java.lang.String hyzh;
	private java.lang.String cyrjzt;
	private java.lang.String tratime;
	private java.lang.String indbtime;
	private java.lang.String hotelcode;
	private java.lang.String staCode;
	private java.lang.String burCode;
	private java.lang.String citycode;
	private Long transflag;
	private java.lang.String hotelname;
	//columns END

	public Temployee(){
	}

	public Temployee(
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
	public void setEmpname(java.lang.String value) {
		this.empname = value;
	}
	
	public java.lang.String getEmpname() {
		return this.empname;
	}
	public void setAlias(java.lang.String value) {
		this.alias = value;
	}
	
	public java.lang.String getAlias() {
		return this.alias;
	}
	public void setSex(java.lang.String value) {
		this.sex = value;
	}
	
	public java.lang.String getSex() {
		return this.sex;
	}
	public void setBirth(java.lang.String value) {
		this.birth = value;
	}
	
	public java.lang.String getBirth() {
		return this.birth;
	}
	public void setStature(java.lang.String value) {
		this.stature = value;
	}
	
	public java.lang.String getStature() {
		return this.stature;
	}
	public void setWeight(java.lang.String value) {
		this.weight = value;
	}
	
	public java.lang.String getWeight() {
		return this.weight;
	}
	public void setPosture(java.lang.String value) {
		this.posture = value;
	}
	
	public java.lang.String getPosture() {
		return this.posture;
	}
	public void setPolityvisage(java.lang.String value) {
		this.polityvisage = value;
	}
	
	public java.lang.String getPolityvisage() {
		return this.polityvisage;
	}
	public void setFolk(java.lang.String value) {
		this.folk = value;
	}
	
	public java.lang.String getFolk() {
		return this.folk;
	}
	public void setNativeplace(java.lang.String value) {
		this.nativeplace = value;
	}
	
	public java.lang.String getNativeplace() {
		return this.nativeplace;
	}
	public void setAddress(java.lang.String value) {
		this.address = value;
	}
	
	public java.lang.String getAddress() {
		return this.address;
	}
	public void setNowadress(java.lang.String value) {
		this.nowadress = value;
	}
	
	public java.lang.String getNowadress() {
		return this.nowadress;
	}
	public void setPhone(java.lang.String value) {
		this.phone = value;
	}
	
	public java.lang.String getPhone() {
		return this.phone;
	}
	public void setSchoolage(java.lang.String value) {
		this.schoolage = value;
	}
	
	public java.lang.String getSchoolage() {
		return this.schoolage;
	}
	public void setPersonid(java.lang.String value) {
		this.personid = value;
	}
	
	public java.lang.String getPersonid() {
		return this.personid;
	}
	public void setNpaddress(java.lang.String value) {
		this.npaddress = value;
	}
	
	public java.lang.String getNpaddress() {
		return this.npaddress;
	}
	public void setTemporarycode(java.lang.String value) {
		this.temporarycode = value;
	}
	
	public java.lang.String getTemporarycode() {
		return this.temporarycode;
	}
	public void setInserttime(java.lang.String value) {
		this.inserttime = value;
	}
	
	public java.lang.String getInserttime() {
		return this.inserttime;
	}
	public void setEdittime(java.lang.String value) {
		this.edittime = value;
	}
	
	public java.lang.String getEdittime() {
		return this.edittime;
	}
	public void setHyzh(java.lang.String value) {
		this.hyzh = value;
	}
	
	public java.lang.String getHyzh() {
		return this.hyzh;
	}
	public void setCyrjzt(java.lang.String value) {
		this.cyrjzt = value;
	}
	
	public java.lang.String getCyrjzt() {
		return this.cyrjzt;
	}
	public void setTratime(java.lang.String value) {
		this.tratime = value;
	}
	
	public java.lang.String getTratime() {
		return this.tratime;
	}
	public void setIndbtime(java.lang.String value) {
		this.indbtime = value;
	}
	
	public java.lang.String getIndbtime() {
		return this.indbtime;
	}
	public void setHotelcode(java.lang.String value) {
		this.hotelcode = value;
	}
	
	public java.lang.String getHotelcode() {
		return this.hotelcode;
	}
	public void setCitycode(java.lang.String value) {
		this.citycode = value;
	}
	
	public java.lang.String getCitycode() {
		return this.citycode;
	}
	public void setTransflag(Long value) {
		this.transflag = value;
	}
	
	public Long getTransflag() {
		return this.transflag;
	}

	public String toString() {
		return new ToStringBuilder(this)
			.append("Empcode",getEmpcode())
			.append("Empname",getEmpname())
			.append("Alias",getAlias())
			.append("Sex",getSex())
			.append("Birth",getBirth())
			.append("Stature",getStature())
			.append("Weight",getWeight())
			.append("Posture",getPosture())
			.append("Polityvisage",getPolityvisage())
			.append("Folk",getFolk())
			.append("Nativeplace",getNativeplace())
			.append("Address",getAddress())
			.append("Nowadress",getNowadress())
			.append("Phone",getPhone())
			.append("Schoolage",getSchoolage())
			.append("Personid",getPersonid())
			.append("Npaddress",getNpaddress())
			.append("Temporarycode",getTemporarycode())
			.append("Inserttime",getInserttime())
			.append("Edittime",getEdittime())
			.append("Hyzh",getHyzh())
			.append("Cyrjzt",getCyrjzt())
			.append("Tratime",getTratime())
			.append("Indbtime",getIndbtime())
			.append("Hotelcode",getHotelcode())
			.append("Stacode",getStaCode())
			.append("Burcode",getBurCode())
			.append("Citycode",getCitycode())
			.append("Transflag",getTransflag())
			.toString();
	}
	
	public int hashCode() {
		return new HashCodeBuilder()
			.append(getEmpcode())
			.append(getEmpname())
			.append(getAlias())
			.append(getSex())
			.append(getBirth())
			.append(getStature())
			.append(getWeight())
			.append(getPosture())
			.append(getPolityvisage())
			.append(getFolk())
			.append(getNativeplace())
			.append(getAddress())
			.append(getNowadress())
			.append(getPhone())
			.append(getSchoolage())
			.append(getPersonid())
			.append(getNpaddress())
			.append(getTemporarycode())
			.append(getInserttime())
			.append(getEdittime())
			.append(getHyzh())
			.append(getCyrjzt())
			.append(getTratime())
			.append(getIndbtime())
			.append(getHotelcode())
			.append(getStaCode())
			.append(getBurCode())
			.append(getCitycode())
			.append(getTransflag())
			.toHashCode();
	}
	
	public boolean equals(Object obj) {
		if(obj instanceof Temployee == false) return false;
		if(this == obj) return true;
		Temployee other = (Temployee)obj;
		return new EqualsBuilder()
			.append(getEmpcode(),other.getEmpcode())
			.append(getEmpname(),other.getEmpname())
			.append(getAlias(),other.getAlias())
			.append(getSex(),other.getSex())
			.append(getBirth(),other.getBirth())
			.append(getStature(),other.getStature())
			.append(getWeight(),other.getWeight())
			.append(getPosture(),other.getPosture())
			.append(getPolityvisage(),other.getPolityvisage())
			.append(getFolk(),other.getFolk())
			.append(getNativeplace(),other.getNativeplace())
			.append(getAddress(),other.getAddress())
			.append(getNowadress(),other.getNowadress())
			.append(getPhone(),other.getPhone())
			.append(getSchoolage(),other.getSchoolage())
			.append(getPersonid(),other.getPersonid())
			.append(getNpaddress(),other.getNpaddress())
			.append(getTemporarycode(),other.getTemporarycode())
			.append(getInserttime(),other.getInserttime())
			.append(getEdittime(),other.getEdittime())
			.append(getHyzh(),other.getHyzh())
			.append(getCyrjzt(),other.getCyrjzt())
			.append(getTratime(),other.getTratime())
			.append(getIndbtime(),other.getIndbtime())
			.append(getHotelcode(),other.getHotelcode())
			.append(getStaCode(),other.getStaCode())
			.append(getBurCode(),other.getBurCode())
			.append(getCitycode(),other.getCitycode())
			.append(getTransflag(),other.getTransflag())
			.isEquals();
	}

	public void setHotelname(java.lang.String hotelname) {
		this.hotelname = hotelname;
	}

	public java.lang.String getHotelname() {
		return hotelname;
	}

	public java.lang.String getXzqh() {
		return xzqh;
	}

	public void setXzqh(java.lang.String xzqh) {
		this.xzqh = xzqh;
	}

	public java.lang.String getStaCode() {
		return staCode;
	}

	public void setStaCode(java.lang.String staCode) {
		this.staCode = staCode;
	}

	public java.lang.String getBurCode() {
		return burCode;
	}

	public void setBurCode(java.lang.String burCode) {
		this.burCode = burCode;
	}
}

