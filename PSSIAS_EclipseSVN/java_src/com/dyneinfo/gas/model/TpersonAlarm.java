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


public class TpersonAlarm extends BaseEntity {
	
	//alias
	public static final String TABLE_ALIAS = "报警信息";
	public static final String ALIAS_XH = "布控档案号";
	public static final String ALIAS_SFZH = "身份证号";
	public static final String ALIAS_XM = "布控人姓名";
	public static final String ALIAS_HM1 = "化名一";
	public static final String ALIAS_HM2 = "华名二";
	public static final String ALIAS_XB = "性别";
	public static final String ALIAS_NL = "出生日期";
	public static final String ALIAS_JG = "籍贯";
	public static final String ALIAS_HJD = "户籍地";
	public static final String ALIAS_ZZ = "住址";
	public static final String ALIAS_SG = "身高";
	public static final String ALIAS_TX = "体型";
	public static final String ALIAS_TSTZ = "特殊特征";
	public static final String ALIAS_AB = "案件类别";
	public static final String ALIAS_LADW = "立案单位";
	public static final String ALIAS_LASJ = "立案时间";
	public static final String ALIAS_JYAQ = "简要案情";
	public static final String ALIAS_TBDW = "填报单位";
	public static final String ALIAS_ID = "ID";
	public static final String ALIAS_NAME = "姓名";
	public static final String ALIAS_ID_NAME = "证件名称";
	public static final String ALIAS_ID_CODE = "证件号码";
	public static final String ALIAS_SEX = "性别";
	public static final String ALIAS_NATION = "民族";
	public static final String ALIAS_BDATE = "出生日期";
	public static final String ALIAS_ADDRESS = "身份证详细地址";
	public static final String ALIAS_XZQH = "行政区划";
	public static final String ALIAS_CPCODE = "加油站名称";
	public static final String ALIAS_BUYTIME = "购油时间";
	public static final String ALIAS_ALARMTIME = "报警时间";
	public static final String ALIAS_ALARMSOURCE = "报警比对源";
	public static final String ALIAS_BKLX = "布控类型";
	public static final String ALIAS_ZHSJ = "抓获时间";
	public static final String ALIAS_PJDW = "派警代为";
	public static final String ALIAS_CLQK = "处理情况";
	public static final String ALIAS_PJSJ = "派警时间";
	public static final String ALIAS_BKID = "布控ID";
	public static final String ALIAS_ALARMTEL = "接警电话";
	public static final String ALIAS_BKSJ = "布控时间";
	public static final String ALIAS_CZR = "布控操作人";
	public static final String ALIAS_EMPFLAG = "从业人员标志";
	public static final String ALIAS_SFYX = "是否有效";
	public static final String ALIAS_WXYY = "无效原因";
	public static final String ALIAS_SFYZH = "是否已抓获";
	public static final String ALIAS_ZHDWMC = "抓获单位名称";
	public static final String ALIAS_WZHYY = "未抓获原因";
	public static final String ALIAS_CJR = "处警人";
	public static final String ALIAS_CLFLAG = "处警状态";
	public static final String ALIAS_BURCODE = "所属分局";
	public static final String ALIAS_STACODE = "所属派出所";
	public static final String ALIAS_CPNAME = "企业名称";
	
	//date formats
	
	//columns START
	private java.lang.String xh;
	private java.lang.String sfzh;
	private java.lang.String xm;
	private java.lang.String hm1;
	private java.lang.String hm2;
	private java.lang.String xb;
	private java.lang.String nl;
	private java.lang.String jg;
	private java.lang.String hjd;
	private java.lang.String zz;
	private java.lang.String sg;
	private java.lang.String tx;
	private java.lang.String tstz;
	private java.lang.String ab;
	private java.lang.String ladw;
	private java.lang.String lasj;
	private java.lang.String jyaq;
	private java.lang.String tbdw;
	private java.lang.String id;
	private java.lang.String name;
	private java.lang.String idName;
	private java.lang.String idCode;
	private java.lang.String sex;
	private java.lang.String nation;
	private java.lang.String bdate;
	private java.lang.String address;
	private java.lang.String xzqh;
	private java.lang.String cpcode;
	private java.lang.String buytime;
	private java.lang.String alarmtime;
	private java.lang.String alarmsource;
	private java.lang.String bklx;
	private java.lang.String zhsj;
	private java.lang.String pjdw;
	private java.lang.String clqk;
	private java.lang.String pjsj;
	private java.lang.String bkid;
	private java.lang.String alarmtel;
	private java.lang.String bksj;
	private java.lang.String czr;
	private java.lang.String empflag;
	private java.lang.String sfyx;
	private java.lang.String wxyy;
	private java.lang.String sfyzh;
	private java.lang.String zhdwmc;
	private java.lang.String wzhyy;
	private java.lang.String cjr;
	private java.lang.String clflag;
	private java.lang.String zhqk;
	
	private java.lang.String burcode;
	private java.lang.String stacode;
	private java.lang.String cpname;
	
	//columns END

	public TpersonAlarm(){
	}

	public TpersonAlarm(
		java.lang.String id
	){
		this.id = id;
	}

	public void setXh(java.lang.String value) {
		this.xh = value;
	}
	
	public java.lang.String getXh() {
		return this.xh;
	}
	public void setSfzh(java.lang.String value) {
		this.sfzh = value;
	}
	
	public java.lang.String getSfzh() {
		return this.sfzh;
	}
	public void setXm(java.lang.String value) {
		this.xm = value;
	}
	
	public java.lang.String getXm() {
		return this.xm;
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
	public void setNl(java.lang.String value) {
		this.nl = value;
	}
	
	public java.lang.String getNl() {
		return this.nl;
	}
	public void setJg(java.lang.String value) {
		this.jg = value;
	}
	
	public java.lang.String getJg() {
		return this.jg;
	}
	public void setHjd(java.lang.String value) {
		this.hjd = value;
	}
	
	public java.lang.String getHjd() {
		return this.hjd;
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
	public void setJyaq(java.lang.String value) {
		this.jyaq = value;
	}
	
	public java.lang.String getJyaq() {
		return this.jyaq;
	}
	public void setTbdw(java.lang.String value) {
		this.tbdw = value;
	}
	
	public java.lang.String getTbdw() {
		return this.tbdw;
	}
	public void setId(java.lang.String value) {
		this.id = value;
	}
	
	public java.lang.String getId() {
		return this.id;
	}
	public void setName(java.lang.String value) {
		this.name = value;
	}
	
	public java.lang.String getName() {
		return this.name;
	}
	public void setIdName(java.lang.String value) {
		this.idName = value;
	}
	
	public java.lang.String getIdName() {
		return this.idName;
	}
	public void setIdCode(java.lang.String value) {
		this.idCode = value;
	}
	
	public java.lang.String getIdCode() {
		return this.idCode;
	}
	public void setSex(java.lang.String value) {
		this.sex = value;
	}
	
	public java.lang.String getSex() {
		return this.sex;
	}
	public void setNation(java.lang.String value) {
		this.nation = value;
	}
	
	public java.lang.String getNation() {
		return this.nation;
	}
	public void setBdate(java.lang.String value) {
		this.bdate = value;
	}
	
	public java.lang.String getBdate() {
		return this.bdate;
	}
	public void setAddress(java.lang.String value) {
		this.address = value;
	}
	
	public java.lang.String getAddress() {
		return this.address;
	}
	public void setXzqh(java.lang.String value) {
		this.xzqh = value;
	}
	
	public java.lang.String getXzqh() {
		return this.xzqh;
	}
	public void setCpcode(java.lang.String value) {
		this.cpcode = value;
	}
	
	public java.lang.String getCpcode() {
		return this.cpcode;
	}
	public void setBuytime(java.lang.String value) {
		this.buytime = value;
	}
	
	public java.lang.String getBuytime() {
		return this.buytime;
	}
	public void setAlarmtime(java.lang.String value) {
		this.alarmtime = value;
	}
	
	public java.lang.String getAlarmtime() {
		return this.alarmtime;
	}
	public void setAlarmsource(java.lang.String value) {
		this.alarmsource = value;
	}
	
	public java.lang.String getAlarmsource() {
		return this.alarmsource;
	}
	public void setBklx(java.lang.String value) {
		this.bklx = value;
	}
	
	public java.lang.String getBklx() {
		return this.bklx;
	}
	public void setZhsj(java.lang.String value) {
		this.zhsj = value;
	}
	
	public java.lang.String getZhsj() {
		return this.zhsj;
	}
	public void setPjdw(java.lang.String value) {
		this.pjdw = value;
	}
	
	public java.lang.String getPjdw() {
		return this.pjdw;
	}
	public void setClqk(java.lang.String value) {
		this.clqk = value;
	}
	
	public java.lang.String getClqk() {
		return this.clqk;
	}
	public void setPjsj(java.lang.String value) {
		this.pjsj = value;
	}
	
	public java.lang.String getPjsj() {
		return this.pjsj;
	}
	public void setBkid(java.lang.String value) {
		this.bkid = value;
	}
	
	public java.lang.String getBkid() {
		return this.bkid;
	}
	public void setAlarmtel(java.lang.String value) {
		this.alarmtel = value;
	}
	
	public java.lang.String getAlarmtel() {
		return this.alarmtel;
	}
	public void setBksj(java.lang.String value) {
		this.bksj = value;
	}
	
	public java.lang.String getBksj() {
		return this.bksj;
	}
	public void setCzr(java.lang.String value) {
		this.czr = value;
	}
	
	public java.lang.String getCzr() {
		return this.czr;
	}
	public void setEmpflag(java.lang.String value) {
		this.empflag = value;
	}
	
	public java.lang.String getEmpflag() {
		return this.empflag;
	}
	public void setSfyx(java.lang.String value) {
		this.sfyx = value;
	}
	
	public java.lang.String getSfyx() {
		return this.sfyx;
	}
	public void setWxyy(java.lang.String value) {
		this.wxyy = value;
	}
	
	public java.lang.String getWxyy() {
		return this.wxyy;
	}
	public void setSfyzh(java.lang.String value) {
		this.sfyzh = value;
	}
	
	public java.lang.String getSfyzh() {
		return this.sfyzh;
	}
	public void setZhdwmc(java.lang.String value) {
		this.zhdwmc = value;
	}
	
	public java.lang.String getZhdwmc() {
		return this.zhdwmc;
	}
	public void setWzhyy(java.lang.String value) {
		this.wzhyy = value;
	}
	
	public java.lang.String getWzhyy() {
		return this.wzhyy;
	}
	public void setCjr(java.lang.String value) {
		this.cjr = value;
	}
	
	public java.lang.String getCjr() {
		return this.cjr;
	}
	public void setClflag(java.lang.String value) {
		this.clflag = value;
	}
	
	public java.lang.String getClflag() {
		return this.clflag;
	}

	public String toString() {
		return new ToStringBuilder(this)
			.append("Xh",getXh())
			.append("Sfzh",getSfzh())
			.append("Xm",getXm())
			.append("Hm1",getHm1())
			.append("Hm2",getHm2())
			.append("Xb",getXb())
			.append("Nl",getNl())
			.append("Jg",getJg())
			.append("Hjd",getHjd())
			.append("Zz",getZz())
			.append("Sg",getSg())
			.append("Tx",getTx())
			.append("Tstz",getTstz())
			.append("Ab",getAb())
			.append("Ladw",getLadw())
			.append("Lasj",getLasj())
			.append("Jyaq",getJyaq())
			.append("Tbdw",getTbdw())
			.append("Id",getId())
			.append("Name",getName())
			.append("IdName",getIdName())
			.append("IdCode",getIdCode())
			.append("Sex",getSex())
			.append("Nation",getNation())
			.append("Bdate",getBdate())
			.append("Address",getAddress())
			.append("Xzqh",getXzqh())
			.append("Cpcode",getCpcode())
			.append("Buytime",getBuytime())
			.append("Alarmtime",getAlarmtime())
			.append("Alarmsource",getAlarmsource())
			.append("Bklx",getBklx())
			.append("Zhsj",getZhsj())
			.append("Pjdw",getPjdw())
			.append("Clqk",getClqk())
			.append("Pjsj",getPjsj())
			.append("Bkid",getBkid())
			.append("Alarmtel",getAlarmtel())
			.append("Bksj",getBksj())
			.append("Czr",getCzr())
			.append("Empflag",getEmpflag())
			.append("Sfyx",getSfyx())
			.append("Wxyy",getWxyy())
			.append("Sfyzh",getSfyzh())
			.append("Zhdwmc",getZhdwmc())
			.append("Wzhyy",getWzhyy())
			.append("Cjr",getCjr())
			.append("Clflag",getClflag())
			.append("Burcode",getBurcode())
			.append("Stacode",getStacode())
			.append("Cpname",getCpname())
			.toString();
	}
	
	public int hashCode() {
		return new HashCodeBuilder()
			.append(getXh())
			.append(getSfzh())
			.append(getXm())
			.append(getHm1())
			.append(getHm2())
			.append(getXb())
			.append(getNl())
			.append(getJg())
			.append(getHjd())
			.append(getZz())
			.append(getSg())
			.append(getTx())
			.append(getTstz())
			.append(getAb())
			.append(getLadw())
			.append(getLasj())
			.append(getJyaq())
			.append(getTbdw())
			.append(getId())
			.append(getName())
			.append(getIdName())
			.append(getIdCode())
			.append(getSex())
			.append(getNation())
			.append(getBdate())
			.append(getAddress())
			.append(getXzqh())
			.append(getCpcode())
			.append(getBuytime())
			.append(getAlarmtime())
			.append(getAlarmsource())
			.append(getBklx())
			.append(getZhsj())
			.append(getPjdw())
			.append(getClqk())
			.append(getPjsj())
			.append(getBkid())
			.append(getAlarmtel())
			.append(getBksj())
			.append(getCzr())
			.append(getEmpflag())
			.append(getSfyx())
			.append(getWxyy())
			.append(getSfyzh())
			.append(getZhdwmc())
			.append(getWzhyy())
			.append(getCjr())
			.append(getClflag())
			.append(getBurcode())
			.append(getStacode())
			.append(getCpname())
			.toHashCode();
	}
	
	public boolean equals(Object obj) {
		if(obj instanceof TpersonAlarm == false) return false;
		if(this == obj) return true;
		TpersonAlarm other = (TpersonAlarm)obj;
		return new EqualsBuilder()
			.append(getXh(),other.getXh())
			.append(getSfzh(),other.getSfzh())
			.append(getXm(),other.getXm())
			.append(getHm1(),other.getHm1())
			.append(getHm2(),other.getHm2())
			.append(getXb(),other.getXb())
			.append(getNl(),other.getNl())
			.append(getJg(),other.getJg())
			.append(getHjd(),other.getHjd())
			.append(getZz(),other.getZz())
			.append(getSg(),other.getSg())
			.append(getTx(),other.getTx())
			.append(getTstz(),other.getTstz())
			.append(getAb(),other.getAb())
			.append(getLadw(),other.getLadw())
			.append(getLasj(),other.getLasj())
			.append(getJyaq(),other.getJyaq())
			.append(getTbdw(),other.getTbdw())
			.append(getId(),other.getId())
			.append(getName(),other.getName())
			.append(getIdName(),other.getIdName())
			.append(getIdCode(),other.getIdCode())
			.append(getSex(),other.getSex())
			.append(getNation(),other.getNation())
			.append(getBdate(),other.getBdate())
			.append(getAddress(),other.getAddress())
			.append(getXzqh(),other.getXzqh())
			.append(getCpcode(),other.getCpcode())
			.append(getBuytime(),other.getBuytime())
			.append(getAlarmtime(),other.getAlarmtime())
			.append(getAlarmsource(),other.getAlarmsource())
			.append(getBklx(),other.getBklx())
			.append(getZhsj(),other.getZhsj())
			.append(getPjdw(),other.getPjdw())
			.append(getClqk(),other.getClqk())
			.append(getPjsj(),other.getPjsj())
			.append(getBkid(),other.getBkid())
			.append(getAlarmtel(),other.getAlarmtel())
			.append(getBksj(),other.getBksj())
			.append(getCzr(),other.getCzr())
			.append(getEmpflag(),other.getEmpflag())
			.append(getSfyx(),other.getSfyx())
			.append(getWxyy(),other.getWxyy())
			.append(getSfyzh(),other.getSfyzh())
			.append(getZhdwmc(),other.getZhdwmc())
			.append(getWzhyy(),other.getWzhyy())
			.append(getCjr(),other.getCjr())
			.append(getClflag(),other.getClflag())
			.append(getBurcode(),other.getBurcode())
			.append(getStacode(),other.getStacode())
			.append(getCpname(),other.getCpname())
			.isEquals();
	}

	public java.lang.String getBurcode() {
		return burcode;
	}

	public void setBurcode(java.lang.String burcode) {
		this.burcode = burcode;
	}

	public java.lang.String getStacode() {
		return stacode;
	}

	public void setStacode(java.lang.String stacode) {
		this.stacode = stacode;
	}

	public java.lang.String getCpname() {
		return cpname;
	}

	public void setCpname(java.lang.String cpname) {
		this.cpname = cpname;
	}

	public java.lang.String getZhqk() {
		return zhqk;
	}

	public void setZhqk(java.lang.String zhqk) {
		this.zhqk = zhqk;
	}
}

