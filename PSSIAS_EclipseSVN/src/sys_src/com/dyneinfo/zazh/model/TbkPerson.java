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


public class TbkPerson extends BaseEntity {
	
	//alias
	public static final String TABLE_ALIAS = "人员布控";
	public static final String ALIAS_ID = "序列号";
	public static final String ALIAS_XM = "布控人姓名";
	public static final String ALIAS_HJD = "户籍地";
	public static final String ALIAS_SFZH = "身份证号码";
	public static final String ALIAS_HM1 = "化名一";
	public static final String ALIAS_HM2 = "化名二";
	public static final String ALIAS_XB = "性别";
	public static final String ALIAS_BDATE = "出生年月";
	public static final String ALIAS_JG = "籍贯";
	public static final String ALIAS_ZZ = "家庭住址";
	public static final String ALIAS_SG = "身高";
	public static final String ALIAS_TX = "体型";
	public static final String ALIAS_TSTZ = "特殊特征";
	public static final String ALIAS_XH = "档案号";
	public static final String ALIAS_AB = "案件类别";
	public static final String ALIAS_LADW = "立案单位";
	public static final String ALIAS_LASJ = "立案时间";
	public static final String ALIAS_PZR = "批准人";
	public static final String ALIAS_LXR = "联系人";
	public static final String ALIAS_LXDH = "联系电话";
	public static final String ALIAS_ZTSJ = "在逃时间";
	public static final String ALIAS_JYAQ = "简要案情";
	public static final String ALIAS_TAF1 = "同案犯一";
	public static final String ALIAS_TAF2 = "同案犯二";
	public static final String ALIAS_TAF3 = "同案犯三";
	public static final String ALIAS_TAF4 = "同案犯四";
	public static final String ALIAS_TJH1 = "通缉号一";
	public static final String ALIAS_TJH2 = "通缉号二";
	public static final String ALIAS_TJH3 = "通缉号三";
	public static final String ALIAS_TBDW = "布控单位";
	public static final String ALIAS_BKLX = "布控类型";
	public static final String ALIAS_ALARM_TEL = "接警电话";
	public static final String ALIAS_BKPZR = "布控批准人";
	public static final String ALIAS_CZR = "操作人";
	public static final String ALIAS_BKSJ = "布控时间";
	public static final String ALIAS_CANCELFLAG = "是否撤控";
	public static final String ALIAS_CANCELTIME = "撤控时间";
	public static final String ALIAS_CANCELCAUSE = "撤控原因";
	public static final String ALIAS_CANCELNAME = "撤控人";
	
	//date formats
	
	//columns START
	private java.lang.String id;
	private java.lang.String xm;
	private java.lang.String hjd;
	private java.lang.String sfzh;
	private java.lang.String hm1;
	private java.lang.String hm2;
	private java.lang.String xb;
	private java.lang.String bdate;
	private java.lang.String jg;
	private java.lang.String zz;
	private java.lang.String sg;
	private java.lang.String tx;
	private java.lang.String tstz;
	private java.lang.String xh;
	private java.lang.String ab;
	private java.lang.String ladw;
	private java.lang.String lasj;
	private java.lang.String pzr;
	private java.lang.String lxr;
	private java.lang.String lxdh;
	private java.lang.String ztsj;
	private java.lang.String jyaq;
	private java.lang.String taf1;
	private java.lang.String taf2;
	private java.lang.String taf3;
	private java.lang.String taf4;
	private java.lang.String tjh1;
	private java.lang.String tjh2;
	private java.lang.String tjh3;
	private java.lang.String tbdw;
	private java.lang.String bklx;
	private java.lang.String alarmTel;
	private java.lang.String bkpzr;
	private java.lang.String czr;
	private java.lang.String bksj;
	private java.lang.String cancelflag;
	private java.lang.String canceltime;
	private java.lang.String cancelcause;
	private java.lang.String cancelname;
	private java.lang.String deptname;
	//columns END

	public TbkPerson(){
	}

	public TbkPerson(
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
	public void setXm(java.lang.String value) {
		this.xm = value;
	}
	
	public java.lang.String getXm() {
		return this.xm;
	}
	public void setHjd(java.lang.String value) {
		this.hjd = value;
	}
	
	public java.lang.String getHjd() {
		return this.hjd;
	}
	public void setSfzh(java.lang.String value) {
		this.sfzh = value;
	}
	
	public java.lang.String getSfzh() {
		return this.sfzh;
	}
	public void setHm1(java.lang.String value) {
		this.hm1 = value;
	}
	
	public java.lang.String getHm1() {
		return this.hm1;
	}
	public void setHm2(java.lang.String value) {
		this.hm2 = value;
	}
	
	public java.lang.String getHm2() {
		return this.hm2;
	}
	public void setXb(java.lang.String value) {
		this.xb = value;
	}
	
	public java.lang.String getXb() {
		return this.xb;
	}
	public void setBdate(java.lang.String value) {
		this.bdate = value;
	}
	
	public java.lang.String getBdate() {
		return this.bdate;
	}
	public void setJg(java.lang.String value) {
		this.jg = value;
	}
	
	public java.lang.String getJg() {
		return this.jg;
	}
	public void setZz(java.lang.String value) {
		this.zz = value;
	}
	
	public java.lang.String getZz() {
		return this.zz;
	}
	public void setSg(java.lang.String value) {
		this.sg = value;
	}
	
	public java.lang.String getSg() {
		return this.sg;
	}
	public void setTx(java.lang.String value) {
		this.tx = value;
	}
	
	public java.lang.String getTx() {
		return this.tx;
	}
	public void setTstz(java.lang.String value) {
		this.tstz = value;
	}
	
	public java.lang.String getTstz() {
		return this.tstz;
	}
	public void setXh(java.lang.String value) {
		this.xh = value;
	}
	
	public java.lang.String getXh() {
		return this.xh;
	}
	public void setAb(java.lang.String value) {
		this.ab = value;
	}
	
	public java.lang.String getAb() {
		return this.ab;
	}
	public void setLadw(java.lang.String value) {
		this.ladw = value;
	}
	
	public java.lang.String getLadw() {
		return this.ladw;
	}
	public void setLasj(java.lang.String value) {
		this.lasj = value;
	}
	
	public java.lang.String getLasj() {
		return this.lasj;
	}
	public void setPzr(java.lang.String value) {
		this.pzr = value;
	}
	
	public java.lang.String getPzr() {
		return this.pzr;
	}
	public void setLxr(java.lang.String value) {
		this.lxr = value;
	}
	
	public java.lang.String getLxr() {
		return this.lxr;
	}
	public void setLxdh(java.lang.String value) {
		this.lxdh = value;
	}
	
	public java.lang.String getLxdh() {
		return this.lxdh;
	}
	public void setZtsj(java.lang.String value) {
		this.ztsj = value;
	}
	
	public java.lang.String getZtsj() {
		return this.ztsj;
	}
	public void setJyaq(java.lang.String value) {
		this.jyaq = value;
	}
	
	public java.lang.String getJyaq() {
		return this.jyaq;
	}
	public void setTaf1(java.lang.String value) {
		this.taf1 = value;
	}
	
	public java.lang.String getTaf1() {
		return this.taf1;
	}
	public void setTaf2(java.lang.String value) {
		this.taf2 = value;
	}
	
	public java.lang.String getTaf2() {
		return this.taf2;
	}
	public void setTaf3(java.lang.String value) {
		this.taf3 = value;
	}
	
	public java.lang.String getTaf3() {
		return this.taf3;
	}
	public void setTaf4(java.lang.String value) {
		this.taf4 = value;
	}
	
	public java.lang.String getTaf4() {
		return this.taf4;
	}
	public void setTjh1(java.lang.String value) {
		this.tjh1 = value;
	}
	
	public java.lang.String getTjh1() {
		return this.tjh1;
	}
	public void setTjh2(java.lang.String value) {
		this.tjh2 = value;
	}
	
	public java.lang.String getTjh2() {
		return this.tjh2;
	}
	public void setTjh3(java.lang.String value) {
		this.tjh3 = value;
	}
	
	public java.lang.String getTjh3() {
		return this.tjh3;
	}
	public void setTbdw(java.lang.String value) {
		this.tbdw = value;
	}
	
	public java.lang.String getTbdw() {
		return this.tbdw;
	}
	public void setBklx(java.lang.String value) {
		this.bklx = value;
	}
	
	public java.lang.String getBklx() {
		return this.bklx;
	}
	public void setAlarmTel(java.lang.String value) {
		this.alarmTel = value;
	}
	
	public java.lang.String getAlarmTel() {
		return this.alarmTel;
	}
	public void setBkpzr(java.lang.String value) {
		this.bkpzr = value;
	}
	
	public java.lang.String getBkpzr() {
		return this.bkpzr;
	}
	public void setCzr(java.lang.String value) {
		this.czr = value;
	}
	
	public java.lang.String getCzr() {
		return this.czr;
	}
	public void setBksj(java.lang.String value) {
		this.bksj = value;
	}
	
	public java.lang.String getBksj() {
		return this.bksj;
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
			.append("Xm",getXm())
			.append("Hjd",getHjd())
			.append("Sfzh",getSfzh())
			.append("Hm1",getHm1())
			.append("Hm2",getHm2())
			.append("Xb",getXb())
			.append("Bdate",getBdate())
			.append("Jg",getJg())
			.append("Zz",getZz())
			.append("Sg",getSg())
			.append("Tx",getTx())
			.append("Tstz",getTstz())
			.append("Xh",getXh())
			.append("Ab",getAb())
			.append("Ladw",getLadw())
			.append("Lasj",getLasj())
			.append("Pzr",getPzr())
			.append("Lxr",getLxr())
			.append("Lxdh",getLxdh())
			.append("Ztsj",getZtsj())
			.append("Jyaq",getJyaq())
			.append("Taf1",getTaf1())
			.append("Taf2",getTaf2())
			.append("Taf3",getTaf3())
			.append("Taf4",getTaf4())
			.append("Tjh1",getTjh1())
			.append("Tjh2",getTjh2())
			.append("Tjh3",getTjh3())
			.append("Tbdw",getTbdw())
			.append("Bklx",getBklx())
			.append("AlarmTel",getAlarmTel())
			.append("Bkpzr",getBkpzr())
			.append("Czr",getCzr())
			.append("Bksj",getBksj())
			.append("Cancelflag",getCancelflag())
			.append("Canceltime",getCanceltime())
			.append("Cancelcause",getCancelcause())
			.append("Cancelname",getCancelname())
			.toString();
	}
	
	public int hashCode() {
		return new HashCodeBuilder()
			.append(getId())
			.append(getXm())
			.append(getHjd())
			.append(getSfzh())
			.append(getHm1())
			.append(getHm2())
			.append(getXb())
			.append(getBdate())
			.append(getJg())
			.append(getZz())
			.append(getSg())
			.append(getTx())
			.append(getTstz())
			.append(getXh())
			.append(getAb())
			.append(getLadw())
			.append(getLasj())
			.append(getPzr())
			.append(getLxr())
			.append(getLxdh())
			.append(getZtsj())
			.append(getJyaq())
			.append(getTaf1())
			.append(getTaf2())
			.append(getTaf3())
			.append(getTaf4())
			.append(getTjh1())
			.append(getTjh2())
			.append(getTjh3())
			.append(getTbdw())
			.append(getBklx())
			.append(getAlarmTel())
			.append(getBkpzr())
			.append(getCzr())
			.append(getBksj())
			.append(getCancelflag())
			.append(getCanceltime())
			.append(getCancelcause())
			.append(getCancelname())
			.toHashCode();
	}
	
	public boolean equals(Object obj) {
		if(obj instanceof TbkPerson == false) return false;
		if(this == obj) return true;
		TbkPerson other = (TbkPerson)obj;
		return new EqualsBuilder()
			.append(getId(),other.getId())
			.append(getXm(),other.getXm())
			.append(getHjd(),other.getHjd())
			.append(getSfzh(),other.getSfzh())
			.append(getHm1(),other.getHm1())
			.append(getHm2(),other.getHm2())
			.append(getXb(),other.getXb())
			.append(getBdate(),other.getBdate())
			.append(getJg(),other.getJg())
			.append(getZz(),other.getZz())
			.append(getSg(),other.getSg())
			.append(getTx(),other.getTx())
			.append(getTstz(),other.getTstz())
			.append(getXh(),other.getXh())
			.append(getAb(),other.getAb())
			.append(getLadw(),other.getLadw())
			.append(getLasj(),other.getLasj())
			.append(getPzr(),other.getPzr())
			.append(getLxr(),other.getLxr())
			.append(getLxdh(),other.getLxdh())
			.append(getZtsj(),other.getZtsj())
			.append(getJyaq(),other.getJyaq())
			.append(getTaf1(),other.getTaf1())
			.append(getTaf2(),other.getTaf2())
			.append(getTaf3(),other.getTaf3())
			.append(getTaf4(),other.getTaf4())
			.append(getTjh1(),other.getTjh1())
			.append(getTjh2(),other.getTjh2())
			.append(getTjh3(),other.getTjh3())
			.append(getTbdw(),other.getTbdw())
			.append(getBklx(),other.getBklx())
			.append(getAlarmTel(),other.getAlarmTel())
			.append(getBkpzr(),other.getBkpzr())
			.append(getCzr(),other.getCzr())
			.append(getBksj(),other.getBksj())
			.append(getCancelflag(),other.getCancelflag())
			.append(getCanceltime(),other.getCanceltime())
			.append(getCancelcause(),other.getCancelcause())
			.append(getCancelname(),other.getCancelname())
			.isEquals();
	}

	public java.lang.String getDeptname() {
		return deptname;
	}

	public void setDeptname(java.lang.String deptname) {
		this.deptname = deptname;
	}
}

