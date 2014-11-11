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


public class TchTrack extends BaseEntity {
	
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
	public static final String ALIAS_GUESTTYPE = "旅客类别";
	public static final String ALIAS_CISHU = "住宿次数";
	
	//date formats
	
	//columns START
	private java.lang.String id;
	private java.lang.String name;
	private java.lang.String sex;
	private java.lang.String bdate;
	private java.lang.String idName;
	private java.lang.String idCode;
	private java.lang.String hotelid;
	private java.lang.String noRoom;
	private java.lang.String inTime;
	private java.lang.String outTime;
	private java.lang.String traTime;
	private java.lang.String insertTime;
	private java.lang.String staCode;
	private java.lang.String burCode;
	private java.lang.String guesttype;
	private java.lang.String cishu;
	private java.lang.String province;
	private java.lang.String hotelName;

	public TchTrack(){
	}

	public TchTrack(
		java.lang.String id
	){
		this.id = id;
	}

	public java.lang.String getId() {
		return id;
	}

	public void setId(java.lang.String id) {
		this.id = id;
	}

	public java.lang.String getName() {
		return name;
	}

	public void setName(java.lang.String name) {
		this.name = name;
	}

	public java.lang.String getSex() {
		return sex;
	}

	public void setSex(java.lang.String sex) {
		this.sex = sex;
	}

	public java.lang.String getBdate() {
		return bdate;
	}

	public void setBdate(java.lang.String bdate) {
		this.bdate = bdate;
	}

	public java.lang.String getIdName() {
		return idName;
	}

	public void setIdName(java.lang.String idName) {
		this.idName = idName;
	}

	public java.lang.String getIdCode() {
		return idCode;
	}

	public void setIdCode(java.lang.String idCode) {
		this.idCode = idCode;
	}

	public java.lang.String getHotelid() {
		return hotelid;
	}

	public void setHotelid(java.lang.String hotelid) {
		this.hotelid = hotelid;
	}

	public java.lang.String getNoRoom() {
		return noRoom;
	}

	public void setNoRoom(java.lang.String noRoom) {
		this.noRoom = noRoom;
	}

	public java.lang.String getInTime() {
		return inTime;
	}

	public void setInTime(java.lang.String inTime) {
		this.inTime = inTime;
	}

	public java.lang.String getOutTime() {
		return outTime;
	}

	public void setOutTime(java.lang.String outTime) {
		this.outTime = outTime;
	}

	public java.lang.String getTraTime() {
		return traTime;
	}

	public void setTraTime(java.lang.String traTime) {
		this.traTime = traTime;
	}

	public java.lang.String getInsertTime() {
		return insertTime;
	}

	public void setInsertTime(java.lang.String insertTime) {
		this.insertTime = insertTime;
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

	public java.lang.String getGuesttype() {
		return guesttype;
	}

	public void setGuesttype(java.lang.String guesttype) {
		this.guesttype = guesttype;
	}

	public java.lang.String getCishu() {
		return cishu;
	}

	public void setCishu(java.lang.String cishu) {
		this.cishu = cishu;
	}

	public java.lang.String getProvince() {
		return province;
	}

	public void setProvince(java.lang.String province) {
		this.province = province;
	}

	public java.lang.String getHotelName() {
		return hotelName;
	}

	public void setHotelName(java.lang.String hotelName) {
		this.hotelName = hotelName;
	}

	
}

