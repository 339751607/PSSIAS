/*
 * Powered By [lishicheng]
 */

package com.dyneinfo.fjy.model;

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

import com.dyneinfo.fjy.model.*;
import com.dyneinfo.fjy.dao.*;
import com.dyneinfo.fjy.service.*;

/**
 * @author lisc email:lishicheng(a)gmail.com
 */


public class Temployee extends BaseEntity {
	
	//alias
	public static final String TABLE_ALIAS = "从业人员";
	public static final String ALIAS_EMPCODE = "人员编号";
	public static final String ALIAS_EMPNAME = "姓名";
	public static final String ALIAS_SEX = "性别";
	public static final String ALIAS_PERSONID = "身份证号码";
	public static final String ALIAS_BIRTH = "出生年月";
	public static final String ALIAS_ALIAS = "别名";
	public static final String ALIAS_FOLK = "民族";
	public static final String ALIAS_NATIVEPLACE = "户籍地行政区划";
	public static final String ALIAS_POLITYVISAGE = "政治面貌";
	public static final String ALIAS_SCHOOLAGE = "文化程度";
	public static final String ALIAS_HYZH = "婚姻状况";
	public static final String ALIAS_STATURE = "身高";
	public static final String ALIAS_WEIGHT = "体重";
	public static final String ALIAS_POSTURE = "体态";
	public static final String ALIAS_NPCODE = "现住址行政区划";
	public static final String ALIAS_ADDRESS = "现住址";
	public static final String ALIAS_NPADDRESS = "户籍地详细地址";
	public static final String ALIAS_PHONE = "联系电话";
	public static final String ALIAS_CYRJZT = "从业人员状态 ";
	public static final String ALIAS_TEMPORARYCODE = "暂住证号";
	public static final String ALIAS_NOWADRESS = "暂住地址";
	public static final String ALIAS_INSERTTIME = "插入时间";
	public static final String ALIAS_EDITTIME = "编辑时间";
	public static final String ALIAS_CPCODE = "企业代码";
	
	//date formats
	public static final String FORMAT_INSERTTIME = DATE_TIME_FORMAT;
	public static final String FORMAT_EDITTIME = DATE_TIME_FORMAT;
	
	//columns START
	private java.lang.String empcode;
	private String empname;
	private String sex;
	private String personid;
	private String birth;
	private String alias;
	private String folk;
	private String nativeplace;
	private String polityvisage;
	private String schoolage;
	private String hyzh;
	private String stature;
	private String weight;
	private String posture;
	private String npcode;
	private String address;
	private String npaddress;
	private String phone;
	private String cyrjzt;
	private String temporarycode;
	private String nowadress;
	private java.util.Date inserttime;
	private java.util.Date edittime;
	private String cpcode;
	private String position;
	private String username;
	private String enabled;
	private String password;
	private String userid;
	private String userrole;
	
	
	//columns END
	
	private String deptname;

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
	public void setEmpname(String value) {
		this.empname = value;
	}
	
	public String getEmpname() {
		return this.empname;
	}
	public void setSex(String value) {
		this.sex = value;
	}
	
	public String getSex() {
		return this.sex;
	}
	public void setPersonid(String value) {
		this.personid = value;
	}
	
	public String getPersonid() {
		return this.personid;
	}
	public void setBirth(String value) {
		this.birth = value;
	}
	
	public String getBirth() {
		return this.birth;
	}
	public void setAlias(String value) {
		this.alias = value;
	}
	
	public String getAlias() {
		return this.alias;
	}
	public void setFolk(String value) {
		this.folk = value;
	}
	
	public String getFolk() {
		return this.folk;
	}
	public void setNativeplace(String value) {
		this.nativeplace = value;
	}
	
	public String getNativeplace() {
		return this.nativeplace;
	}
	public void setPolityvisage(String value) {
		this.polityvisage = value;
	}
	
	public String getPolityvisage() {
		return this.polityvisage;
	}
	public void setSchoolage(String value) {
		this.schoolage = value;
	}
	
	public String getSchoolage() {
		return this.schoolage;
	}
	public void setHyzh(String value) {
		this.hyzh = value;
	}
	
	public String getHyzh() {
		return this.hyzh;
	}
	public void setStature(String value) {
		this.stature = value;
	}
	
	public String getStature() {
		return this.stature;
	}
	public void setWeight(String value) {
		this.weight = value;
	}
	
	public String getWeight() {
		return this.weight;
	}
	public void setPosture(String value) {
		this.posture = value;
	}
	
	public String getPosture() {
		return this.posture;
	}
	public void setNpcode(String value) {
		this.npcode = value;
	}
	
	public String getNpcode() {
		return this.npcode;
	}
	public void setAddress(String value) {
		this.address = value;
	}
	
	public String getAddress() {
		return this.address;
	}
	public void setNpaddress(String value) {
		this.npaddress = value;
	}
	
	public String getNpaddress() {
		return this.npaddress;
	}
	public void setPhone(String value) {
		this.phone = value;
	}
	
	public String getPhone() {
		return this.phone;
	}
	public void setCyrjzt(String value) {
		this.cyrjzt = value;
	}
	
	public String getCyrjzt() {
		return this.cyrjzt;
	}
	public void setTemporarycode(String value) {
		this.temporarycode = value;
	}
	
	public String getTemporarycode() {
		return this.temporarycode;
	}
	public void setNowadress(String value) {
		this.nowadress = value;
	}
	
	public String getNowadress() {
		return this.nowadress;
	}
	public String getInserttimeString() {
		return date2String(getInserttime(), FORMAT_INSERTTIME);
	}
	public void setInserttimeString(String value) {
		setInserttime(string2Date(value, FORMAT_INSERTTIME,java.util.Date.class));
	}
	
	public void setInserttime(java.util.Date value) {
		this.inserttime = value;
	}
	
	public java.util.Date getInserttime() {
		return this.inserttime;
	}
	public String getEdittimeString() {
		return date2String(getEdittime(), FORMAT_EDITTIME);
	}
	public void setEdittimeString(String value) {
		setEdittime(string2Date(value, FORMAT_EDITTIME,java.util.Date.class));
	}
	
	public void setEdittime(java.util.Date value) {
		this.edittime = value;
	}
	
	public java.util.Date getEdittime() {
		return this.edittime;
	}
	public void setCpcode(String value) {
		this.cpcode = value;
	}
	
	public String getCpcode() {
		return this.cpcode;
	}

	public String toString() {
		return new ToStringBuilder(this)
			.append("Empcode",getEmpcode())
			.append("Empname",getEmpname())
			.append("Sex",getSex())
			.append("Personid",getPersonid())
			.append("Birth",getBirth())
			.append("Alias",getAlias())
			.append("Folk",getFolk())
			.append("Nativeplace",getNativeplace())
			.append("Polityvisage",getPolityvisage())
			.append("Schoolage",getSchoolage())
			.append("Hyzh",getHyzh())
			.append("Stature",getStature())
			.append("Weight",getWeight())
			.append("Posture",getPosture())
			.append("Npcode",getNpcode())
			.append("Address",getAddress())
			.append("Npaddress",getNpaddress())
			.append("Phone",getPhone())
			.append("Cyrjzt",getCyrjzt())
			.append("Temporarycode",getTemporarycode())
			.append("Nowadress",getNowadress())
			.append("Inserttime",getInserttime())
			.append("Edittime",getEdittime())
			.append("Cpcode",getCpcode())
			.append("Position",getPosition())
			.append("Username",getUsername())
			.append("Enabled",getEnabled())
			.append("Password",getPassword())
			.append("Userid",getUserid())
			.toString();
	}
	
	public int hashCode() {
		return new HashCodeBuilder()
			.append(getEmpcode())
			.append(getEmpname())
			.append(getSex())
			.append(getPersonid())
			.append(getBirth())
			.append(getAlias())
			.append(getFolk())
			.append(getNativeplace())
			.append(getPolityvisage())
			.append(getSchoolage())
			.append(getHyzh())
			.append(getStature())
			.append(getWeight())
			.append(getPosture())
			.append(getNpcode())
			.append(getAddress())
			.append(getNpaddress())
			.append(getPhone())
			.append(getCyrjzt())
			.append(getTemporarycode())
			.append(getNowadress())
			.append(getInserttime())
			.append(getEdittime())
			.append(getCpcode())
			.append(getPosition())
			.append(getUsername())
			.append(getEnabled())
			.append(getPassword())
			.append(getUserid())
			.toHashCode();
	}
	
	public boolean equals(Object obj) {
		if(obj instanceof Temployee == false) return false;
		if(this == obj) return true;
		Temployee other = (Temployee)obj;
		return new EqualsBuilder()
			.append(getEmpcode(),other.getEmpcode())
			.append(getEmpname(),other.getEmpname())
			.append(getSex(),other.getSex())
			.append(getPersonid(),other.getPersonid())
			.append(getBirth(),other.getBirth())
			.append(getAlias(),other.getAlias())
			.append(getFolk(),other.getFolk())
			.append(getNativeplace(),other.getNativeplace())
			.append(getPolityvisage(),other.getPolityvisage())
			.append(getSchoolage(),other.getSchoolage())
			.append(getHyzh(),other.getHyzh())
			.append(getStature(),other.getStature())
			.append(getWeight(),other.getWeight())
			.append(getPosture(),other.getPosture())
			.append(getNpcode(),other.getNpcode())
			.append(getAddress(),other.getAddress())
			.append(getNpaddress(),other.getNpaddress())
			.append(getPhone(),other.getPhone())
			.append(getCyrjzt(),other.getCyrjzt())
			.append(getTemporarycode(),other.getTemporarycode())
			.append(getNowadress(),other.getNowadress())
			.append(getInserttime(),other.getInserttime())
			.append(getEdittime(),other.getEdittime())
			.append(getCpcode(),other.getCpcode())
			.append(getPosition(),other.getPosition())
			.append(getUsername(),other.getUsername())
			.append(getEnabled(),other.getEnabled())
			.append(getPassword(),other.getPassword())
			.append(getUserid(),other.getUserid())
			.isEquals();
	}

	public String getDeptname() {
		return deptname;
	}

	public void setDeptname(String deptname) {
		this.deptname = deptname;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getEnabled() {
		return enabled;
	}

	public void setEnabled(String enabled) {
		this.enabled = enabled;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public String getUserrole() {
		return userrole;
	}

	public void setUserrole(String userrole) {
		this.userrole = userrole;
	}
}

