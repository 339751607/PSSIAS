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


public class TjwPre extends BaseEntity {
	
	//alias
	public static final String TABLE_ALIAS = "境外旅客信息";
	public static final String ALIAS_ID = "旅客代码";
	public static final String ALIAS_X_SN = "英文姓";
	public static final String ALIAS_M_FN = "英文名";
	public static final String ALIAS_CHN_N = "中文姓名";
	public static final String ALIAS_SEX = "性别";
	public static final String ALIAS_BDATE = "出生日期";
	public static final String ALIAS_P_NATIONAL = "国籍";
	public static final String ALIAS_PASS_T = "证件类型";
	public static final String ALIAS_PASS_NO = "证件号码";
	public static final String ALIAS_VISA_T = "签证种类";
	public static final String ALIAS_VISA_NO = "签证号码";
	public static final String ALIAS_STAY_DATE = "在华停留期至";
	public static final String ALIAS_QF_UNIT = "签发机关";
	public static final String ALIAS_IN_DATE = "入境日期";
	public static final String ALIAS_IN_PORT = "入境口岸";
	public static final String ALIAS_P_ADDRESS = "留宿单位";
	public static final String ALIAS_JD_UNIT = "接待单位";
	public static final String ALIAS_IN_TIME = "入住时间";
	public static final String ALIAS_NO_ROOM = "入住房号";
	public static final String ALIAS_OUT_TIME = "退宿时间";
	public static final String ALIAS_TRA_TIME = "传送时间";
	public static final String ALIAS_PLACE = "何地来去";
	public static final String ALIAS_CREDIT_CODE = "creditCode";
	public static final String ALIAS_CREDIT_NO = "creditNo";
	public static final String ALIAS_STA_CODE = "所属派出所";
	public static final String ALIAS_BUR_CODE = "所属分局";
	public static final String ALIAS_SPM = "中文名双拼码";
	public static final String ALIAS_INSERT_TIME = "插入时间";
	public static final String ALIAS_MEMO = "memo";
	public static final String ALIAS_REASON = "reason";
	public static final String ALIAS_HOTELID = "hotelid";
	public static final String ALIAS_PDAFLAG = "pdaflag";
	public static final String ALIAS_DRAGOMANAME = "dragomaname";
	public static final String ALIAS_DRAGOMAPHONE = "dragomaphone";
	public static final String ALIAS_GROUPNO = "groupno";
	public static final String ALIAS_TRANSFERFLAG = "????";
	public static final String ALIAS_KYRY = "????";
	public static final String ALIAS_FLAGTJ = "统计标志";
	public static final String ALIAS_DAYS = "住宿天数";
	public static final String ALIAS_SFZH = "身份证号";
	public static final String ALIAS_ZJYXQ = "证件有效期";
	public static final String ALIAS_OPERATOR = "前台操作员姓名";
	public static final String ALIAS_CITY_CODE = "市局代码";
	public static final String ALIAS_LEAVEDATE = "预计离店时间";
	public static final String ALIAS_HOTELNAME = "旅馆名称";	
	//date formats
	
	//columns START
	private java.lang.String id;
	private java.lang.String xsn;
	private java.lang.String mfn;
	private java.lang.String chnN;
	private java.lang.String sex;
	private java.lang.String bdate;
	private java.lang.String pnational;
	private java.lang.String passT;
	private java.lang.String passNo;
	private java.lang.String visaT;
	private java.lang.String visaNo;
	private java.lang.String stayDate;
	private java.lang.String qfUnit;
	private java.lang.String inDate;
	private java.lang.String inPort;
	private java.lang.String paddress;
	private java.lang.String jdUnit;
	private java.lang.String inTime;
	private java.lang.String noRoom;
	private java.lang.String outTime;
	private java.lang.String traTime;
	private java.lang.String place;
	private java.lang.String creditCode;
	private java.lang.String creditNo;
	private java.lang.String staCode;
	private java.lang.String burCode;
	private java.lang.String spm;
	private java.lang.String insertTime;
	private java.lang.String memo;
	private java.lang.String reason;
	private java.lang.String hotelid;
	private java.lang.String pdaflag;
	private java.lang.String dragomaname;
	private java.lang.String dragomaphone;
	private java.lang.String groupno;
	private Long transferflag;
	private java.lang.String kyry;
	private java.lang.String flagtj;
	private Long days;
	private java.lang.String sfzh;
	private java.lang.String zjyxq;
	private java.lang.String operator;
	private java.lang.String cityCode;
	private java.lang.String leavedate;
	private java.lang.String hotelname;
	//columns END

	public TjwPre(){
	}

	public TjwPre(
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
	public void setXsn(java.lang.String value) {
		this.xsn = value;
	}
	
	public java.lang.String getXsn() {
		return this.xsn;
	}
	public void setMfn(java.lang.String value) {
		this.mfn = value;
	}
	
	public java.lang.String getMfn() {
		return this.mfn;
	}
	public void setChnN(java.lang.String value) {
		this.chnN = value;
	}
	
	public java.lang.String getChnN() {
		return this.chnN;
	}
	public void setSex(java.lang.String value) {
		this.sex = value;
	}
	
	public java.lang.String getSex() {
		return this.sex;
	}
	public void setBdate(java.lang.String value) {
		this.bdate = value;
	}
	
	public java.lang.String getBdate() {
		return this.bdate;
	}
	public void setPnational(java.lang.String value) {
		this.pnational = value;
	}
	
	public java.lang.String getPnational() {
		return this.pnational;
	}
	public void setPassT(java.lang.String value) {
		this.passT = value;
	}
	
	public java.lang.String getPassT() {
		return this.passT;
	}
	public void setPassNo(java.lang.String value) {
		this.passNo = value;
	}
	
	public java.lang.String getPassNo() {
		return this.passNo;
	}
	public void setVisaT(java.lang.String value) {
		this.visaT = value;
	}
	
	public java.lang.String getVisaT() {
		return this.visaT;
	}
	public void setVisaNo(java.lang.String value) {
		this.visaNo = value;
	}
	
	public java.lang.String getVisaNo() {
		return this.visaNo;
	}
	public void setStayDate(java.lang.String value) {
		this.stayDate = value;
	}
	
	public java.lang.String getStayDate() {
		return this.stayDate;
	}
	public void setQfUnit(java.lang.String value) {
		this.qfUnit = value;
	}
	
	public java.lang.String getQfUnit() {
		return this.qfUnit;
	}
	public void setInDate(java.lang.String value) {
		this.inDate = value;
	}
	
	public java.lang.String getInDate() {
		return this.inDate;
	}
	public void setInPort(java.lang.String value) {
		this.inPort = value;
	}
	
	public java.lang.String getInPort() {
		return this.inPort;
	}
	public void setPaddress(java.lang.String value) {
		this.paddress = value;
	}
	
	public java.lang.String getPaddress() {
		return this.paddress;
	}
	public void setJdUnit(java.lang.String value) {
		this.jdUnit = value;
	}
	
	public java.lang.String getJdUnit() {
		return this.jdUnit;
	}
	public void setInTime(java.lang.String value) {
		this.inTime = value;
	}
	
	public java.lang.String getInTime() {
		return this.inTime;
	}
	public void setNoRoom(java.lang.String value) {
		this.noRoom = value;
	}
	
	public java.lang.String getNoRoom() {
		return this.noRoom;
	}
	public void setOutTime(java.lang.String value) {
		this.outTime = value;
	}
	
	public java.lang.String getOutTime() {
		return this.outTime;
	}
	public void setTraTime(java.lang.String value) {
		this.traTime = value;
	}
	
	public java.lang.String getTraTime() {
		return this.traTime;
	}
	public void setPlace(java.lang.String value) {
		this.place = value;
	}
	
	public java.lang.String getPlace() {
		return this.place;
	}
	public void setCreditCode(java.lang.String value) {
		this.creditCode = value;
	}
	
	public java.lang.String getCreditCode() {
		return this.creditCode;
	}
	public void setCreditNo(java.lang.String value) {
		this.creditNo = value;
	}
	
	public java.lang.String getCreditNo() {
		return this.creditNo;
	}
	public void setStaCode(java.lang.String value) {
		this.staCode = value;
	}
	
	public java.lang.String getStaCode() {
		return this.staCode;
	}
	public void setBurCode(java.lang.String value) {
		this.burCode = value;
	}
	
	public java.lang.String getBurCode() {
		return this.burCode;
	}
	public void setSpm(java.lang.String value) {
		this.spm = value;
	}
	
	public java.lang.String getSpm() {
		return this.spm;
	}
	public void setInsertTime(java.lang.String value) {
		this.insertTime = value;
	}
	
	public java.lang.String getInsertTime() {
		return this.insertTime;
	}
	public void setMemo(java.lang.String value) {
		this.memo = value;
	}
	
	public java.lang.String getMemo() {
		return this.memo;
	}
	public void setReason(java.lang.String value) {
		this.reason = value;
	}
	
	public java.lang.String getReason() {
		return this.reason;
	}
	public void setHotelid(java.lang.String value) {
		this.hotelid = value;
	}
	
	public java.lang.String getHotelid() {
		return this.hotelid;
	}
	public void setPdaflag(java.lang.String value) {
		this.pdaflag = value;
	}
	
	public java.lang.String getPdaflag() {
		return this.pdaflag;
	}
	public void setDragomaname(java.lang.String value) {
		this.dragomaname = value;
	}
	
	public java.lang.String getDragomaname() {
		return this.dragomaname;
	}
	public void setDragomaphone(java.lang.String value) {
		this.dragomaphone = value;
	}
	
	public java.lang.String getDragomaphone() {
		return this.dragomaphone;
	}
	public void setGroupno(java.lang.String value) {
		this.groupno = value;
	}
	
	public java.lang.String getGroupno() {
		return this.groupno;
	}
	public void setTransferflag(Long value) {
		this.transferflag = value;
	}
	
	public Long getTransferflag() {
		return this.transferflag;
	}
	public void setKyry(java.lang.String value) {
		this.kyry = value;
	}
	
	public java.lang.String getKyry() {
		return this.kyry;
	}
	public void setFlagtj(java.lang.String value) {
		this.flagtj = value;
	}
	
	public java.lang.String getFlagtj() {
		return this.flagtj;
	}
	public void setDays(Long value) {
		this.days = value;
	}
	
	public Long getDays() {
		return this.days;
	}
	public void setSfzh(java.lang.String value) {
		this.sfzh = value;
	}
	
	public java.lang.String getSfzh() {
		return this.sfzh;
	}
	public void setZjyxq(java.lang.String value) {
		this.zjyxq = value;
	}
	
	public java.lang.String getZjyxq() {
		return this.zjyxq;
	}
	public void setOperator(java.lang.String value) {
		this.operator = value;
	}
	
	public java.lang.String getOperator() {
		return this.operator;
	}
	public void setCityCode(java.lang.String value) {
		this.cityCode = value;
	}
	
	public java.lang.String getCityCode() {
		return this.cityCode;
	}
	public void setLeavedate(java.lang.String value) {
		this.leavedate = value;
	}
	
	public java.lang.String getLeavedate() {
		return this.leavedate;
	}

	public String toString() {
		return new ToStringBuilder(this)
			.append("Id",getId())
			.append("Xsn",getXsn())
			.append("Mfn",getMfn())
			.append("ChnN",getChnN())
			.append("Sex",getSex())
			.append("Bdate",getBdate())
			.append("Pnational",getPnational())
			.append("PassT",getPassT())
			.append("PassNo",getPassNo())
			.append("VisaT",getVisaT())
			.append("VisaNo",getVisaNo())
			.append("StayDate",getStayDate())
			.append("QfUnit",getQfUnit())
			.append("InDate",getInDate())
			.append("InPort",getInPort())
			.append("Paddress",getPaddress())
			.append("JdUnit",getJdUnit())
			.append("InTime",getInTime())
			.append("NoRoom",getNoRoom())
			.append("OutTime",getOutTime())
			.append("TraTime",getTraTime())
			.append("Place",getPlace())
			.append("CreditCode",getCreditCode())
			.append("CreditNo",getCreditNo())
			.append("StaCode",getStaCode())
			.append("BurCode",getBurCode())
			.append("Spm",getSpm())
			.append("InsertTime",getInsertTime())
			.append("Memo",getMemo())
			.append("Reason",getReason())
			.append("Hotelid",getHotelid())
			.append("Pdaflag",getPdaflag())
			.append("Dragomaname",getDragomaname())
			.append("Dragomaphone",getDragomaphone())
			.append("Groupno",getGroupno())
			.append("Transferflag",getTransferflag())
			.append("Kyry",getKyry())
			.append("Flagtj",getFlagtj())
			.append("Days",getDays())
			.append("Sfzh",getSfzh())
			.append("Zjyxq",getZjyxq())
			.append("Operator",getOperator())
			.append("CityCode",getCityCode())
			.append("Leavedate",getLeavedate())
			.toString();
	}
	
	public int hashCode() {
		return new HashCodeBuilder()
			.append(getId())
			.append(getXsn())
			.append(getMfn())
			.append(getChnN())
			.append(getSex())
			.append(getBdate())
			.append(getPnational())
			.append(getPassT())
			.append(getPassNo())
			.append(getVisaT())
			.append(getVisaNo())
			.append(getStayDate())
			.append(getQfUnit())
			.append(getInDate())
			.append(getInPort())
			.append(getPaddress())
			.append(getJdUnit())
			.append(getInTime())
			.append(getNoRoom())
			.append(getOutTime())
			.append(getTraTime())
			.append(getPlace())
			.append(getCreditCode())
			.append(getCreditNo())
			.append(getStaCode())
			.append(getBurCode())
			.append(getSpm())
			.append(getInsertTime())
			.append(getMemo())
			.append(getReason())
			.append(getHotelid())
			.append(getPdaflag())
			.append(getDragomaname())
			.append(getDragomaphone())
			.append(getGroupno())
			.append(getTransferflag())
			.append(getKyry())
			.append(getFlagtj())
			.append(getDays())
			.append(getSfzh())
			.append(getZjyxq())
			.append(getOperator())
			.append(getCityCode())
			.append(getLeavedate())
			.toHashCode();
	}
	
	public boolean equals(Object obj) {
		if(obj instanceof TjwPre == false) return false;
		if(this == obj) return true;
		TjwPre other = (TjwPre)obj;
		return new EqualsBuilder()
			.append(getId(),other.getId())
			.append(getXsn(),other.getXsn())
			.append(getMfn(),other.getMfn())
			.append(getChnN(),other.getChnN())
			.append(getSex(),other.getSex())
			.append(getBdate(),other.getBdate())
			.append(getPnational(),other.getPnational())
			.append(getPassT(),other.getPassT())
			.append(getPassNo(),other.getPassNo())
			.append(getVisaT(),other.getVisaT())
			.append(getVisaNo(),other.getVisaNo())
			.append(getStayDate(),other.getStayDate())
			.append(getQfUnit(),other.getQfUnit())
			.append(getInDate(),other.getInDate())
			.append(getInPort(),other.getInPort())
			.append(getPaddress(),other.getPaddress())
			.append(getJdUnit(),other.getJdUnit())
			.append(getInTime(),other.getInTime())
			.append(getNoRoom(),other.getNoRoom())
			.append(getOutTime(),other.getOutTime())
			.append(getTraTime(),other.getTraTime())
			.append(getPlace(),other.getPlace())
			.append(getCreditCode(),other.getCreditCode())
			.append(getCreditNo(),other.getCreditNo())
			.append(getStaCode(),other.getStaCode())
			.append(getBurCode(),other.getBurCode())
			.append(getSpm(),other.getSpm())
			.append(getInsertTime(),other.getInsertTime())
			.append(getMemo(),other.getMemo())
			.append(getReason(),other.getReason())
			.append(getHotelid(),other.getHotelid())
			.append(getPdaflag(),other.getPdaflag())
			.append(getDragomaname(),other.getDragomaname())
			.append(getDragomaphone(),other.getDragomaphone())
			.append(getGroupno(),other.getGroupno())
			.append(getTransferflag(),other.getTransferflag())
			.append(getKyry(),other.getKyry())
			.append(getFlagtj(),other.getFlagtj())
			.append(getDays(),other.getDays())
			.append(getSfzh(),other.getSfzh())
			.append(getZjyxq(),other.getZjyxq())
			.append(getOperator(),other.getOperator())
			.append(getCityCode(),other.getCityCode())
			.append(getLeavedate(),other.getLeavedate())
			.isEquals();
	}

	public void setHotelname(java.lang.String hotelname) {
		this.hotelname = hotelname;
	}

	public java.lang.String getHotelname() {
		return hotelname;
	}
}

