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


public class TchAlarminfor extends BaseEntity {
	
	//alias
	public static final String TABLE_ALIAS = "报警信息";
	public static final String ALIAS_XH = "档案号";
	public static final String ALIAS_SFZH = "身份证号";
	public static final String ALIAS_XM = "姓名";
	public static final String ALIAS_HM1 = "化名一";
	public static final String ALIAS_HM2 = "化名二";
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
	public static final String ALIAS_ID = "旅客代码";
	public static final String ALIAS_NAME = "姓名";
	public static final String ALIAS_ID_NAME = "证件类型";
	public static final String ALIAS_ID_CODE = "证件号码";
	public static final String ALIAS_SEX = "性别";
	public static final String ALIAS_NATION = "民族";
	public static final String ALIAS_BDATE = "出生日期";
	public static final String ALIAS_ADDRESS = "常住地址";
	public static final String ALIAS_XZQH = "户籍地";
	public static final String ALIAS_NO_ROOM = "房间号码";
	public static final String ALIAS_IN_TIME = "入住时间";
	public static final String ALIAS_FTIME = "报警时间";
	public static final String ALIAS_ALARM = "报警标志";
	public static final String ALIAS_TYPE = "报警类型";
	public static final String ALIAS_BKLX = "布控类型";
	public static final String ALIAS_ALARMTJ = "报警";
	public static final String ALIAS_ZHSJ = "捉获时间";
	public static final String ALIAS_PJDW = "处警单位";
	public static final String ALIAS_CLQK = "处理情况";
	public static final String ALIAS_PJSJ = "处警时间";
	public static final String ALIAS_BKID = "布控ID";
	public static final String ALIAS_BKTEL = "布控电话";
	public static final String ALIAS_AUDIT_MARK = "审核标志";
	public static final String ALIAS_BKSJ = "布控时间";
	public static final String ALIAS_CZR = "操作人";
	public static final String ALIAS_EMPFLAG = "从业人员";
	public static final String ALIAS_SFYX = "是否有效";
	public static final String ALIAS_WXYY = "无效原因";
	public static final String ALIAS_SFYZH = "是否已抓获";
	public static final String ALIAS_ZHDWMC = "抓获单位";
	public static final String ALIAS_WZHYY = "未抓获原因";
	public static final String ALIAS_CJR = "处警人";
	public static final String ALIAS_HOTELNAME = "入住旅馆";	
	public static final String ALIAS_STA_CODE = "所属派出所";
	public static final String ALIAS_BUR_CODE = "所属分局";
	public static final String ALIAS_HOTELADDRESS = "旅馆地址";
	
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
	private java.lang.String noRoom;
	private java.lang.String inTime;
	private java.lang.String ftime;
	private java.lang.String alarm;
	private java.lang.String type;
	private java.lang.String bklx;
	private java.lang.String alarmtj;
	private java.lang.String zhsj;
	private java.lang.String pjdw;
	private java.lang.String clqk;
	private java.lang.String pjsj;
	private java.lang.String bkid;
	private java.lang.String bktel;
	private java.lang.String auditMark;
	private java.lang.String bksj;
	private java.lang.String czr;
	private java.lang.String empflag;
	private java.lang.String sfyx;
	private java.lang.String wxyy;
	private java.lang.String sfyzh;
	private java.lang.String zhdwmc;
	private java.lang.String wzhyy;
	private java.lang.String cjr;
	private java.lang.String hotelname;
	private java.lang.String burCode;
	private java.lang.String staCode;
	private java.lang.String hotelAddress;
	
	//columns END

	public TchAlarminfor(){
	}

	public TchAlarminfor(
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
	public void setNoRoom(java.lang.String value) {
		this.noRoom = value;
	}
	
	public java.lang.String getNoRoom() {
		return this.noRoom;
	}
	public void setInTime(java.lang.String value) {
		this.inTime = value;
	}
	
	public java.lang.String getInTime() {
		return this.inTime;
	}
	public void setFtime(java.lang.String value) {
		this.ftime = value;
	}
	
	public java.lang.String getFtime() {
		return this.ftime;
	}
	public void setAlarm(java.lang.String value) {
		this.alarm = value;
	}
	
	public java.lang.String getAlarm() {
		return this.alarm;
	}
	public void setType(java.lang.String value) {
		this.type = value;
	}
	
	public java.lang.String getType() {
		return this.type;
	}
	public void setBklx(java.lang.String value) {
		this.bklx = value;
	}
	
	public java.lang.String getBklx() {
		return this.bklx;
	}
	public void setAlarmtj(java.lang.String value) {
		this.alarmtj = value;
	}
	
	public java.lang.String getAlarmtj() {
		return this.alarmtj;
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
	public void setBktel(java.lang.String value) {
		this.bktel = value;
	}
	
	public java.lang.String getBktel() {
		return this.bktel;
	}
	public void setAuditMark(java.lang.String value) {
		this.auditMark = value;
	}
	
	public java.lang.String getAuditMark() {
		return this.auditMark;
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
			.append("NoRoom",getNoRoom())
			.append("InTime",getInTime())
			.append("Ftime",getFtime())
			.append("Alarm",getAlarm())
			.append("Type",getType())
			.append("Bklx",getBklx())
			.append("Alarmtj",getAlarmtj())
			.append("Zhsj",getZhsj())
			.append("Pjdw",getPjdw())
			.append("Clqk",getClqk())
			.append("Pjsj",getPjsj())
			.append("Bkid",getBkid())
			.append("Bktel",getBktel())
			.append("AuditMark",getAuditMark())
			.append("Bksj",getBksj())
			.append("Czr",getCzr())
			.append("Empflag",getEmpflag())
			.append("Sfyx",getSfyx())
			.append("Wxyy",getWxyy())
			.append("Sfyzh",getSfyzh())
			.append("Zhdwmc",getZhdwmc())
			.append("Wzhyy",getWzhyy())
			.append("Cjr",getCjr())
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
			.append(getNoRoom())
			.append(getInTime())
			.append(getFtime())
			.append(getAlarm())
			.append(getType())
			.append(getBklx())
			.append(getAlarmtj())
			.append(getZhsj())
			.append(getPjdw())
			.append(getClqk())
			.append(getPjsj())
			.append(getBkid())
			.append(getBktel())
			.append(getAuditMark())
			.append(getBksj())
			.append(getCzr())
			.append(getEmpflag())
			.append(getSfyx())
			.append(getWxyy())
			.append(getSfyzh())
			.append(getZhdwmc())
			.append(getWzhyy())
			.append(getCjr())
			.toHashCode();
	}
	
	public boolean equals(Object obj) {
		if(obj instanceof TchAlarminfor == false) return false;
		if(this == obj) return true;
		TchAlarminfor other = (TchAlarminfor)obj;
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
			.append(getNoRoom(),other.getNoRoom())
			.append(getInTime(),other.getInTime())
			.append(getFtime(),other.getFtime())
			.append(getAlarm(),other.getAlarm())
			.append(getType(),other.getType())
			.append(getBklx(),other.getBklx())
			.append(getAlarmtj(),other.getAlarmtj())
			.append(getZhsj(),other.getZhsj())
			.append(getPjdw(),other.getPjdw())
			.append(getClqk(),other.getClqk())
			.append(getPjsj(),other.getPjsj())
			.append(getBkid(),other.getBkid())
			.append(getBktel(),other.getBktel())
			.append(getAuditMark(),other.getAuditMark())
			.append(getBksj(),other.getBksj())
			.append(getCzr(),other.getCzr())
			.append(getEmpflag(),other.getEmpflag())
			.append(getSfyx(),other.getSfyx())
			.append(getWxyy(),other.getWxyy())
			.append(getSfyzh(),other.getSfyzh())
			.append(getZhdwmc(),other.getZhdwmc())
			.append(getWzhyy(),other.getWzhyy())
			.append(getCjr(),other.getCjr())
			.isEquals();
	}

	public void setHotelname(java.lang.String hotelname) {
		this.hotelname = hotelname;
	}

	public java.lang.String getHotelname() {
		return hotelname;
	}
	
	public java.lang.String getBurCode() {
		return burCode;
	}

	public void setBurCode(java.lang.String burCode) {
		this.burCode = burCode;
	}

	public java.lang.String getStaCode() {
		return staCode;
	}

	public void setStaCode(java.lang.String staCode) {
		this.staCode = staCode;
	}

	public java.lang.String getHotelAddress() {
		return hotelAddress;
	}

	public void setHotelAddress(java.lang.String hotelAddress) {
		this.hotelAddress = hotelAddress;
	}
}

