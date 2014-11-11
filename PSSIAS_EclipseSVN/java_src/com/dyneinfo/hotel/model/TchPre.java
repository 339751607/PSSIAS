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


public class TchPre extends BaseEntity {
	
	//alias
	public static final String TABLE_ALIAS = "境内旅客信息";
	public static final String ALIAS_ID = "旅客代码";
	public static final String ALIAS_NAME = "姓名";
	public static final String ALIAS_SEX = "性别";
	public static final String ALIAS_NATION = "民族";
	public static final String ALIAS_BDATE = "出生日期";
	public static final String ALIAS_ID_NAME = "证件类型";
	public static final String ALIAS_ID_CODE = "证件号码";
	public static final String ALIAS_XZQH = "户籍地";
	public static final String ALIAS_ADDRESS = "详细住址";
	public static final String ALIAS_IN_TIME = "入住时间";
	public static final String ALIAS_NO_ROOM = "房间号码";
	public static final String ALIAS_OUT_TIME = "退宿时间";
	public static final String ALIAS_TRA_TIME = "信息传递时间";
	public static final String ALIAS_CREDIT_CODE = "信用卡";
	public static final String ALIAS_CREDIT_NO = "信用卡号";
	public static final String ALIAS_STA_CODE = "派出所";
	public static final String ALIAS_BUR_CODE = "分局";
	public static final String ALIAS_SPM = "姓名双拼码";
	public static final String ALIAS_INSERT_TIME = "插入时间";
	public static final String ALIAS_MEMO = "备注";
	public static final String ALIAS_HOTELID = "旅馆代码";
	public static final String ALIAS_PDAFLAG = "前台上传设备（PDA或PC）";
	public static final String ALIAS_DRAGOMANAME = "导游姓名";
	public static final String ALIAS_DRAGOMAPHONE = "导游电话";
	public static final String ALIAS_GROUPNO = "团队号";
	public static final String ALIAS_KYRY = "kyry";
	public static final String ALIAS_FLAGTJ = "统计标志";
	public static final String ALIAS_DAYS = "住宿天数";
	public static final String ALIAS_FLAGKY = "可疑人员标志";
	public static final String ALIAS_KYTYPE = "可疑类型";
	public static final String ALIAS_FLAGCQBF = "长期包房标志";
	public static final String ALIAS_HOTELNAME = "旅馆名称";
	public static final String ALIAS_CITY_CODE = "市局代码";
	public static final String ALIAS_TLSY = "停留事由";
	
	//date formats
	
	//columns START
	private java.lang.String id;
	private java.lang.String name;
	private java.lang.String sex;
	private java.lang.String nation;
	private java.lang.String bdate;
	private java.lang.String idName;
	private java.lang.String idCode;
	private java.lang.String xzqh;
	private java.lang.String address;
	private java.lang.String inTime;
	private java.lang.String noRoom;
	private java.lang.String outTime;
	private java.lang.String traTime;
	private java.lang.String creditCode;
	private java.lang.String creditNo;
	private java.lang.String staCode;
	private java.lang.String burCode;
	private java.lang.String spm;
	private java.lang.String insertTime;
	private java.lang.String memo;
	private java.lang.String hotelid;
	private java.lang.String pdaflag;
	private java.lang.String dragomaname;
	private java.lang.String dragomaphone;
	private java.lang.String groupno;
	private java.lang.String kyry;
	private java.lang.String flagtj;
	private Long days;
	private java.lang.String flagky;
	private java.lang.String kytype;
	private java.lang.String flagcqbf;
	private java.lang.String hotelname;
	private java.lang.String cityCode;
	private java.lang.String tlsy;
	private java.lang.String province;
	private java.lang.String roommates;
	//columns END

	public TchPre(){
	}

	public TchPre(
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
	public void setName(java.lang.String value) {
		this.name = value;
	}
	
	public java.lang.String getName() {
		return this.name;
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
	public void setXzqh(java.lang.String value) {
		this.xzqh = value;
	}
	
	public java.lang.String getXzqh() {
		return this.xzqh;
	}
	public void setAddress(java.lang.String value) {
		this.address = value;
	}
	
	public java.lang.String getAddress() {
		return this.address;
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
	public void setFlagky(java.lang.String value) {
		this.flagky = value;
	}
	
	public java.lang.String getFlagky() {
		return this.flagky;
	}
	public void setKytype(java.lang.String value) {
		this.kytype = value;
	}
	
	public java.lang.String getKytype() {
		return this.kytype;
	}
	public void setFlagcqbf(java.lang.String value) {
		this.flagcqbf = value;
	}
	
	public java.lang.String getFlagcqbf() {
		return this.flagcqbf;
	}
	public void setHotelname(java.lang.String value) {
		this.hotelname = value;
	}
	
	public java.lang.String getHotelname() {
		return this.hotelname;
	}
	public void setCityCode(java.lang.String value) {
		this.cityCode = value;
	}
	
	public java.lang.String getCityCode() {
		return this.cityCode;
	}
	public void setTlsy(java.lang.String value) {
		this.tlsy = value;
	}
	
	public java.lang.String getTlsy() {
		return this.tlsy;
	}

	public String toString() {
		return new ToStringBuilder(this)
			.append("Id",getId())
			.append("Name",getName())
			.append("Sex",getSex())
			.append("Nation",getNation())
			.append("Bdate",getBdate())
			.append("IdName",getIdName())
			.append("IdCode",getIdCode())
			.append("Xzqh",getXzqh())
			.append("Address",getAddress())
			.append("InTime",getInTime())
			.append("NoRoom",getNoRoom())
			.append("OutTime",getOutTime())
			.append("TraTime",getTraTime())
			.append("CreditCode",getCreditCode())
			.append("CreditNo",getCreditNo())
			.append("StaCode",getStaCode())
			.append("BurCode",getBurCode())
			.append("Spm",getSpm())
			.append("InsertTime",getInsertTime())
			.append("Memo",getMemo())
			.append("Hotelid",getHotelid())
			.append("Pdaflag",getPdaflag())
			.append("Dragomaname",getDragomaname())
			.append("Dragomaphone",getDragomaphone())
			.append("Groupno",getGroupno())
			.append("Kyry",getKyry())
			.append("Flagtj",getFlagtj())
			.append("Days",getDays())
			.append("Flagky",getFlagky())
			.append("Kytype",getKytype())
			.append("Flagcqbf",getFlagcqbf())
			.append("Hotelname",getHotelname())
			.append("CityCode",getCityCode())
			.append("Tlsy",getTlsy())
			.toString();
	}
	
	public int hashCode() {
		return new HashCodeBuilder()
			.append(getId())
			.append(getName())
			.append(getSex())
			.append(getNation())
			.append(getBdate())
			.append(getIdName())
			.append(getIdCode())
			.append(getXzqh())
			.append(getAddress())
			.append(getInTime())
			.append(getNoRoom())
			.append(getOutTime())
			.append(getTraTime())
			.append(getCreditCode())
			.append(getCreditNo())
			.append(getStaCode())
			.append(getBurCode())
			.append(getSpm())
			.append(getInsertTime())
			.append(getMemo())
			.append(getHotelid())
			.append(getPdaflag())
			.append(getDragomaname())
			.append(getDragomaphone())
			.append(getGroupno())
			.append(getKyry())
			.append(getFlagtj())
			.append(getDays())
			.append(getFlagky())
			.append(getKytype())
			.append(getFlagcqbf())
			.append(getHotelname())
			.append(getCityCode())
			.append(getTlsy())
			.toHashCode();
	}
	
	public boolean equals(Object obj) {
		if(obj instanceof TchPre == false) return false;
		if(this == obj) return true;
		TchPre other = (TchPre)obj;
		return new EqualsBuilder()
			.append(getId(),other.getId())
			.append(getName(),other.getName())
			.append(getSex(),other.getSex())
			.append(getNation(),other.getNation())
			.append(getBdate(),other.getBdate())
			.append(getIdName(),other.getIdName())
			.append(getIdCode(),other.getIdCode())
			.append(getXzqh(),other.getXzqh())
			.append(getAddress(),other.getAddress())
			.append(getInTime(),other.getInTime())
			.append(getNoRoom(),other.getNoRoom())
			.append(getOutTime(),other.getOutTime())
			.append(getTraTime(),other.getTraTime())
			.append(getCreditCode(),other.getCreditCode())
			.append(getCreditNo(),other.getCreditNo())
			.append(getStaCode(),other.getStaCode())
			.append(getBurCode(),other.getBurCode())
			.append(getSpm(),other.getSpm())
			.append(getInsertTime(),other.getInsertTime())
			.append(getMemo(),other.getMemo())
			.append(getHotelid(),other.getHotelid())
			.append(getPdaflag(),other.getPdaflag())
			.append(getDragomaname(),other.getDragomaname())
			.append(getDragomaphone(),other.getDragomaphone())
			.append(getGroupno(),other.getGroupno())
			.append(getKyry(),other.getKyry())
			.append(getFlagtj(),other.getFlagtj())
			.append(getDays(),other.getDays())
			.append(getFlagky(),other.getFlagky())
			.append(getKytype(),other.getKytype())
			.append(getFlagcqbf(),other.getFlagcqbf())
			.append(getHotelname(),other.getHotelname())
			.append(getCityCode(),other.getCityCode())
			.append(getTlsy(),other.getTlsy())
			.isEquals();
	}

	public void setProvince(java.lang.String province) {
		this.province = province;
	}

	public java.lang.String getProvince() {
		return province;
	}

	public java.lang.String getRoommates() {
		return roommates;
	}

	public void setRoommates(java.lang.String roommates) {
		this.roommates = roommates;
	}
}

