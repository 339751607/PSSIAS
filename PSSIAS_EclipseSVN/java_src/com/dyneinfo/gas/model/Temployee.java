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


public class Temployee extends BaseEntity {
	
	//alias
	public static final String TABLE_ALIAS = "从业人员基本信息";
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
	public static final String ALIAS_PERSONID = "公民身份证号码";
	public static final String ALIAS_NPCODE = "户口所在地行政区划";
	public static final String ALIAS_NPADDRESS = "详址";
	public static final String ALIAS_TEMPORARYCODE = "暂住证号";
	public static final String ALIAS_INSERTTIME = "前台登记时间";
	public static final String ALIAS_EDITTIME = "最后更新时间";
	public static final String ALIAS_HYZH = "婚姻状况";
	public static final String ALIAS_CYRJZT = "从业人员状态";
	public static final String ALIAS_TRATIME = "上传时间";
	public static final String ALIAS_CPCODE = "加油站名称";
	public static final String ALIAS_STACODE = "派出所名称";
	public static final String ALIAS_BURCODE = "分局名称";
	public static final String ALIAS_INDATE = "入职日期";
	public static final String ALIAS_LEFTDATE = "离职日期";
	public static final String ALIAS_EMPDUTY = "职务";
	
	
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
	private java.lang.String npcode;
	private java.lang.String npaddress;
	private java.lang.String temporarycode;
	private java.lang.String inserttime;
	private java.lang.String edittime;
	private java.lang.String hyzh;
	private java.lang.String cyrjzt;
	private java.lang.String tratime;
	private java.lang.String cpcode;
	private java.lang.String stacode;
	private java.lang.String burcode;
	private java.lang.String indate;
	private java.lang.String leftdate;
	private java.lang.String empduty;
	private java.lang.String cpname;
	
	private java.lang.String pPhotoBuffer;
	
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
	public void setNpcode(java.lang.String value) {
		this.npcode = value;
	}
	
	public java.lang.String getNpcode() {
		return this.npcode;
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
	public void setCpcode(java.lang.String value) {
		this.cpcode = value;
	}
	
	public java.lang.String getCpcode() {
		return this.cpcode;
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
			.append("Npcode",getNpcode())
			.append("Npaddress",getNpaddress())
			.append("Temporarycode",getTemporarycode())
			.append("Inserttime",getInserttime())
			.append("Edittime",getEdittime())
			.append("Hyzh",getHyzh())
			.append("Cyrjzt",getCyrjzt())
			.append("Tratime",getTratime())
			.append("Cpcode",getCpcode())
			.append("Stacode",getStacode())
			.append("Burcode",getBurcode())
			.append("Indate",getIndate())
			.append("Leftdate",getLeftdate())
			.append("Empduty",getEmpduty())
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
			.append(getNpcode())
			.append(getNpaddress())
			.append(getTemporarycode())
			.append(getInserttime())
			.append(getEdittime())
			.append(getHyzh())
			.append(getCyrjzt())
			.append(getTratime())
			.append(getCpcode())
			.append(getStacode())
			.append(getBurcode())
			.append(getIndate())
			.append(getLeftdate())
			.append(getEmpduty())
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
			.append(getNpcode(),other.getNpcode())
			.append(getNpaddress(),other.getNpaddress())
			.append(getTemporarycode(),other.getTemporarycode())
			.append(getInserttime(),other.getInserttime())
			.append(getEdittime(),other.getEdittime())
			.append(getHyzh(),other.getHyzh())
			.append(getCyrjzt(),other.getCyrjzt())
			.append(getTratime(),other.getTratime())
			.append(getCpcode(),other.getCpcode())
			.append(getStacode(),other.getStacode())
			.append(getBurcode(),other.getBurcode())
			.append(getIndate(),other.getIndate())
			.append(getLeftdate(),other.getLeftdate())
			.append(getEmpduty(),other.getEmpduty())
			.isEquals();
	}

	public java.lang.String getIndate() {
		return indate;
	}

	public void setIndate(java.lang.String indate) {
		this.indate = indate;
	}

	public java.lang.String getLeftdate() {
		return leftdate;
	}

	public void setLeftdate(java.lang.String leftdate) {
		this.leftdate = leftdate;
	}

	public java.lang.String getEmpduty() {
		return empduty;
	}

	public void setEmpduty(java.lang.String empduty) {
		this.empduty = empduty;
	}

	public java.lang.String getCpname() {
		return cpname;
	}

	public void setCpname(java.lang.String cpname) {
		this.cpname = cpname;
	}

	public java.lang.String getPPhotoBuffer() {
		return pPhotoBuffer;
	}

	public void setPPhotoBuffer(java.lang.String photoBuffer) {
		pPhotoBuffer = photoBuffer;
	}
}

