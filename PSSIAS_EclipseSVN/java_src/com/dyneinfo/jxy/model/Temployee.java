/*
 * Powered By [lishicheng]
 */

package com.dyneinfo.jxy.model;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;



import javacommon.base.*;



/**
 * @author lisc email:lishicheng(a)gmail.com
 */


public class Temployee extends BaseEntity {
	
	//alias
	public static final String TABLE_ALIAS = "从业人员基本信息";
	public static final String ALIAS_EMPCODE = "人员编号";
	public static final String ALIAS_NAME = "姓名";
	public static final String ALIAS_ALIAS = "别名";
	public static final String ALIAS_SEX = "性别";
	public static final String ALIAS_BIRTH = "出生年月";
	public static final String ALIAS_STATURE = "身高";
	public static final String ALIAS_WEIGHT = "体重";
	public static final String ALIAS_POSTURE = "体态";
	public static final String ALIAS_POLITYVISAGE = "政治面貌";
	public static final String ALIAS_FOLK = "民族";
	public static final String ALIAS_NATIVEPLACE = "籍贯";
	public static final String ALIAS_SCHOOLAGE = "文化程度";
	public static final String ALIAS_HYZK = "婚姻状况";
	public static final String ALIAS_CYRJZT = "从业人员状态 ";
	public static final String ALIAS_ADDRESS = "家庭住址";
	public static final String ALIAS_NOWADRESS = "暂住地址";
	public static final String ALIAS_PHONE = "联系电话";
	public static final String ALIAS_PERSONID = "身份证号码";
	public static final String ALIAS_NPCODE = "户口所在地行政区划";
	public static final String ALIAS_NPADDRESS = "详址";
	public static final String ALIAS_TEMPORARYCODE = "暂住证号";
	public static final String ALIAS_INSERTTIME = "插入时间";
	public static final String ALIAS_EDITTIME = "编辑时间";
	public static final String ALIAS_CPCODE = "企业代码";
	public static final String ALIAS_INDATE = "入职日期";
	public static final String ALIAS_DEPTNAME = "企业名称";
	
	//date formats
	public static final String FORMAT_INSERTTIME = DATE_TIME_FORMAT;
	public static final String FORMAT_EDITTIME = DATE_TIME_FORMAT;
	
	//columns START
	private java.lang.String cpempcode;
	private java.lang.String name;
	private java.lang.String alias;
	private java.lang.String sex;
	private java.lang.String birth;
	private java.lang.String stature;
	private java.lang.String weight;
	private java.lang.String posture;
	private java.lang.String polityvisage;
	private java.lang.String folk;
	private java.lang.String nativeplace;
	private java.lang.String schoolage;
	private java.lang.String hyzk;
	private java.lang.String cyrjzt;
	private java.lang.String address;
	private java.lang.String nowadress;
	private java.lang.String phone;
	private java.lang.String personid;
	private java.lang.String npcode;
	private java.lang.String npaddress;
	private java.lang.String temporarycode;
	private java.util.Date inserttime;
	private java.util.Date edittime;
	private java.lang.String cpcode;
	private java.lang.String indate;
	private java.lang.String leftdate;
	private java.lang.String deptname;
	
	public java.lang.String getDeptname() {
		return deptname;
	}

	public void setDeptname(java.lang.String deptname) {
		this.deptname = deptname;
	}

	//columns END
	public Temployee(){
	}

	public Temployee(
		java.lang.String cpempcode
	){
		this.cpempcode = cpempcode;
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
	public void setSchoolage(java.lang.String value) {
		this.schoolage = value;
	}
	
	public java.lang.String getSchoolage() {
		return this.schoolage;
	}

	public java.lang.String getHyzk() {
		return hyzk;
	}

	public void setHyzk(java.lang.String hyzk) {
		this.hyzk = hyzk;
	}

	public void setCyrjzt(java.lang.String value) {
		this.cyrjzt = value;
	}
	
	public java.lang.String getCyrjzt() {
		return this.cyrjzt;
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
	public void setCpcode(java.lang.String value) {
		this.cpcode = value;
	}
	
	public java.lang.String getCpcode() {
		return this.cpcode;
	}

	public java.lang.String getCpempcode() {
		return cpempcode;
	}

	public void setCpempcode(java.lang.String cpempcode) {
		this.cpempcode = cpempcode;
	}

	public java.lang.String getName() {
		return name;
	}

	public void setName(java.lang.String name) {
		this.name = name;
	}

	public java.lang.String getIndate() {
		return indate;
	}

	public void setIndate(java.lang.String indate) {
		this.indate = indate;
	}

	public String toString() {
		return new ToStringBuilder(this)
			.append("Cpempcode",getCpempcode())
			.append("Name",getName())
			.append("Alias",getAlias())
			.append("Sex",getSex())
			.append("Birth",getBirth())
			.append("Stature",getStature())
			.append("Weight",getWeight())
			.append("Posture",getPosture())
			.append("Polityvisage",getPolityvisage())
			.append("Folk",getFolk())
			.append("Nativeplace",getNativeplace())
			.append("Schoolage",getSchoolage())
			.append("Hyzk",getHyzk())
			.append("Cyrjzt",getCyrjzt())
			.append("Address",getAddress())
			.append("Nowadress",getNowadress())
			.append("Phone",getPhone())
			.append("Personid",getPersonid())
			.append("Npcode",getNpcode())
			.append("Npaddress",getNpaddress())
			.append("Temporarycode",getTemporarycode())
			.append("Inserttime",getInserttime())
			.append("Edittime",getEdittime())
			.append("Cpcode",getCpcode())
			.append("Indate",getIndate())
			.append("Leftdate",getLeftdate())
			.toString();
	}
	
	public int hashCode() {
		return new HashCodeBuilder()
			.append(getCpempcode())
			.append(getName())
			.append(getAlias())
			.append(getSex())
			.append(getBirth())
			.append(getStature())
			.append(getWeight())
			.append(getPosture())
			.append(getPolityvisage())
			.append(getFolk())
			.append(getNativeplace())
			.append(getSchoolage())
			.append(getHyzk())
			.append(getCyrjzt())
			.append(getAddress())
			.append(getNowadress())
			.append(getPhone())
			.append(getPersonid())
			.append(getNpcode())
			.append(getNpaddress())
			.append(getTemporarycode())
			.append(getInserttime())
			.append(getEdittime())
			.append(getCpcode())
			.append(getIndate())
			.append(getLeftdate())
			.toHashCode();
	}
	
	public boolean equals(Object obj) {
		if(obj instanceof Temployee == false) return false;
		if(this == obj) return true;
		Temployee other = (Temployee)obj;
		return new EqualsBuilder()
			.append(getCpempcode(),other.getCpempcode())
			.append(getName(),other.getName())
			.append(getAlias(),other.getAlias())
			.append(getSex(),other.getSex())
			.append(getBirth(),other.getBirth())
			.append(getStature(),other.getStature())
			.append(getWeight(),other.getWeight())
			.append(getPosture(),other.getPosture())
			.append(getPolityvisage(),other.getPolityvisage())
			.append(getFolk(),other.getFolk())
			.append(getNativeplace(),other.getNativeplace())
			.append(getSchoolage(),other.getSchoolage())
			.append(getHyzk(),other.getHyzk())
			.append(getCyrjzt(),other.getCyrjzt())
			.append(getAddress(),other.getAddress())
			.append(getNowadress(),other.getNowadress())
			.append(getPhone(),other.getPhone())
			.append(getPersonid(),other.getPersonid())
			.append(getNpcode(),other.getNpcode())
			.append(getNpaddress(),other.getNpaddress())
			.append(getTemporarycode(),other.getTemporarycode())
			.append(getInserttime(),other.getInserttime())
			.append(getEdittime(),other.getEdittime())
			.append(getCpcode(),other.getCpcode())
			.append(getIndate(),other.getIndate())
			.append(getLeftdate(),other.getLeftdate())
			.isEquals();
	}

	public java.lang.String getLeftdate() {
		return leftdate;
	}

	public void setLeftdate(java.lang.String leftdate) {
		this.leftdate = leftdate;
	}
}

