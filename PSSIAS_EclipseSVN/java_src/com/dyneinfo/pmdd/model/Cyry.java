/*
 * Powered By [lishicheng]
 */

package com.dyneinfo.pmdd.model;

import javacommon.base.BaseEntity;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

/**
 * @author lisc email:lishicheng(a)gmail.com
 */


public class Cyry extends BaseEntity {
	
	//alias
	public static final String TABLE_ALIAS = "从业人员信息";
	public static final String ALIAS_XM = "姓名";
	public static final String ALIAS_XB = "性别";
	public static final String ALIAS_DWBM = "单位编码";
	public static final String ALIAS_GMSFHM = "身份证号码";
	public static final String ALIAS_DWNBM = "单位内编码";
	public static final String ALIAS_BIRTHDAY = "出生日期";
	public static final String ALIAS_ZZ = "住址";
	public static final String ALIAS_HKSZD = "户口所在地";
	public static final String ALIAS_WHCD = "文化程度";
	public static final String ALIAS_GZLX = "工作类型";
	public static final String ALIAS_RZRQ = "入职日期";
	public static final String ALIAS_FLAG = "是否离职";
	public static final String ALIAS_LZRQ = "离职日期";
	public static final String ALIAS_TIB_FLOWGUID = "TIB_FLOWGUID";
	public static final String ALIAS_TIB_ROWGUID = "TIB_ROWGUID";
	public static final String ALIAS_ZZZH = "暂住证号";
	public static final String ALIAS_ZZDZ = "暂住地址";
	public static final String ALIAS_ZZMM = "政治面貌";
	public static final String ALIAS_ZAPXZ_ID = "治安培训证号";
	public static final String ALIAS_ZZJGBH = "组织结构编号";
	
	//date formats
	
	//columns START
	private String xm;
	private String xb;
	private java.lang.String dwbm;
	private String gmsfhm;
	private java.lang.String dwnbm;
	private String birthday;
	private String zz;
	private String hkszd;
	private String whcd;
	private String gzlx;
	private String rzrq;
	private String flag;
	private String lzrq;
	private String tibFlowguid;
	private String tibRowguid;
	private String zzzh;
	private String zzdz;
	private String zzmm;
	private String zapxzId;
	private String zzjgbh;
	//columns END

	public Cyry(){
	}

	public Cyry(
		java.lang.String dwbm,
		java.lang.String dwnbm
	){
		this.dwbm = dwbm;
		this.dwnbm = dwnbm;
	}

	public void setXm(String value) {
		this.xm = value;
	}
	
	public String getXm() {
		return this.xm;
	}
	public void setXb(String value) {
		this.xb = value;
	}
	
	public String getXb() {
		return this.xb;
	}
	public void setDwbm(java.lang.String value) {
		this.dwbm = value;
	}
	
	public java.lang.String getDwbm() {
		return this.dwbm;
	}
	public void setGmsfhm(String value) {
		this.gmsfhm = value;
	}
	
	public String getGmsfhm() {
		return this.gmsfhm;
	}
	public void setDwnbm(java.lang.String value) {
		this.dwnbm = value;
	}
	
	public java.lang.String getDwnbm() {
		return this.dwnbm;
	}
	public void setBirthday(String value) {
		this.birthday = value;
	}
	
	public String getBirthday() {
		return this.birthday;
	}
	public void setZz(String value) {
		this.zz = value;
	}
	
	public String getZz() {
		return this.zz;
	}
	public void setHkszd(String value) {
		this.hkszd = value;
	}
	
	public String getHkszd() {
		return this.hkszd;
	}
	public void setWhcd(String value) {
		this.whcd = value;
	}
	
	public String getWhcd() {
		return this.whcd;
	}
	public void setGzlx(String value) {
		this.gzlx = value;
	}
	
	public String getGzlx() {
		return this.gzlx;
	}
	public void setRzrq(String value) {
		this.rzrq = value;
	}
	
	public String getRzrq() {
		return this.rzrq;
	}
	public void setFlag(String value) {
		this.flag = value;
	}
	
	public String getFlag() {
		return this.flag;
	}
	public void setLzrq(String value) {
		this.lzrq = value;
	}
	
	public String getLzrq() {
		return this.lzrq;
	}
	public void setTibFlowguid(String value) {
		this.tibFlowguid = value;
	}
	
	public String getTibFlowguid() {
		return this.tibFlowguid;
	}
	public void setTibRowguid(String value) {
		this.tibRowguid = value;
	}
	
	public String getTibRowguid() {
		return this.tibRowguid;
	}
	public void setZzzh(String value) {
		this.zzzh = value;
	}
	
	public String getZzzh() {
		return this.zzzh;
	}
	public void setZzdz(String value) {
		this.zzdz = value;
	}
	
	public String getZzdz() {
		return this.zzdz;
	}
	public void setZzmm(String value) {
		this.zzmm = value;
	}
	
	public String getZzmm() {
		return this.zzmm;
	}
	public void setZapxzId(String value) {
		this.zapxzId = value;
	}
	
	public String getZapxzId() {
		return this.zapxzId;
	}
	public void setZzjgbh(String value) {
		this.zzjgbh = value;
	}
	
	public String getZzjgbh() {
		return this.zzjgbh;
	}

	public String toString() {
		return new ToStringBuilder(this)
			.append("Xm",getXm())
			.append("Xb",getXb())
			.append("Dwbm",getDwbm())
			.append("Gmsfhm",getGmsfhm())
			.append("Dwnbm",getDwnbm())
			.append("Birthday",getBirthday())
			.append("Zz",getZz())
			.append("Hkszd",getHkszd())
			.append("Whcd",getWhcd())
			.append("Gzlx",getGzlx())
			.append("Rzrq",getRzrq())
			.append("Flag",getFlag())
			.append("Lzrq",getLzrq())
			.append("TibFlowguid",getTibFlowguid())
			.append("TibRowguid",getTibRowguid())
			.append("Zzzh",getZzzh())
			.append("Zzdz",getZzdz())
			.append("Zzmm",getZzmm())
			.append("ZapxzId",getZapxzId())
			.append("Zzjgbh",getZzjgbh())
			.toString();
	}
	
	public int hashCode() {
		return new HashCodeBuilder()
			.append(getXm())
			.append(getXb())
			.append(getDwbm())
			.append(getGmsfhm())
			.append(getDwnbm())
			.append(getBirthday())
			.append(getZz())
			.append(getHkszd())
			.append(getWhcd())
			.append(getGzlx())
			.append(getRzrq())
			.append(getFlag())
			.append(getLzrq())
			.append(getTibFlowguid())
			.append(getTibRowguid())
			.append(getZzzh())
			.append(getZzdz())
			.append(getZzmm())
			.append(getZapxzId())
			.append(getZzjgbh())
			.toHashCode();
	}
	
	public boolean equals(Object obj) {
		if(obj instanceof Cyry == false) return false;
		if(this == obj) return true;
		Cyry other = (Cyry)obj;
		return new EqualsBuilder()
			.append(getXm(),other.getXm())
			.append(getXb(),other.getXb())
			.append(getDwbm(),other.getDwbm())
			.append(getGmsfhm(),other.getGmsfhm())
			.append(getDwnbm(),other.getDwnbm())
			.append(getBirthday(),other.getBirthday())
			.append(getZz(),other.getZz())
			.append(getHkszd(),other.getHkszd())
			.append(getWhcd(),other.getWhcd())
			.append(getGzlx(),other.getGzlx())
			.append(getRzrq(),other.getRzrq())
			.append(getFlag(),other.getFlag())
			.append(getLzrq(),other.getLzrq())
			.append(getTibFlowguid(),other.getTibFlowguid())
			.append(getTibRowguid(),other.getTibRowguid())
			.append(getZzzh(),other.getZzzh())
			.append(getZzdz(),other.getZzdz())
			.append(getZzmm(),other.getZzmm())
			.append(getZapxzId(),other.getZapxzId())
			.append(getZzjgbh(),other.getZzjgbh())
			.isEquals();
	}
}

