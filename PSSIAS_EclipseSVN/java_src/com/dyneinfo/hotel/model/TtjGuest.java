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


public class TtjGuest extends BaseEntity {
	
	//alias
	public static final String TABLE_ALIAS = "旅馆入退宿情况统计";
	public static final String ALIAS_CALLED = "旅馆名称";
	public static final String ALIAS_STA_CODE = "所属派出所";
	public static final String ALIAS_BUR_CODE = "所属分局";
	public static final String ALIAS_ADDRESS = "旅馆地址";
	public static final String ALIAS_TEL = "总台电话";
	public static final String ALIAS_STATUS = "状态";
	public static final String ALIAS_HOTEL_NUM = "营业旅馆数";
	public static final String ALIAS_ROOM_NUM = "客房数";
	public static final String ALIAS_BED_NUM = "床位数";
	public static final String ALIAS_STAR = "星级";
	public static final String ALIAS_GRADE = "等级";
	public static final String ALIAS_INGUEST = "入住旅客";
	public static final String ALIAS_OUTGUEST = "退宿旅客";
	public static final String ALIAS_IN_TIME = "统计时间";
	public static final String ALIAS_DEPT = "辖区";
	public static final String ALIAS_INFOSUM = "上传信息数";
	
	//date formats
	
	//columns START
	private java.lang.String code;
	private java.lang.String called;
	private java.lang.String tel;
	private java.lang.String address;
	private java.lang.String roomNum;
	private java.lang.String bedNum;
	private java.lang.String inGuestNum;
	private java.lang.String outGuestNum;
	private java.lang.String bur_sta_code;
	private java.lang.String hotelSum;
	private java.lang.String infoSum;
	public java.lang.String getCode() {
		return code;
	}
	public void setCode(java.lang.String code) {
		this.code = code;
	}
	public java.lang.String getCalled() {
		return called;
	}
	public void setCalled(java.lang.String called) {
		this.called = called;
	}
	public java.lang.String getTel() {
		return tel;
	}
	public void setTel(java.lang.String tel) {
		this.tel = tel;
	}
	public java.lang.String getAddress() {
		return address;
	}
	public void setAddress(java.lang.String address) {
		this.address = address;
	}
	public java.lang.String getRoomNum() {
		return roomNum;
	}
	public void setRoomNum(java.lang.String roomNum) {
		this.roomNum = roomNum;
	}
	public java.lang.String getBedNum() {
		return bedNum;
	}
	public void setBedNum(java.lang.String bedNum) {
		this.bedNum = bedNum;
	}
	public java.lang.String getInGuestNum() {
		return inGuestNum;
	}
	public void setInGuestNum(java.lang.String inGuestNum) {
		this.inGuestNum = inGuestNum;
	}
	public java.lang.String getOutGuestNum() {
		return outGuestNum;
	}
	public void setOutGuestNum(java.lang.String outGuestNum) {
		this.outGuestNum = outGuestNum;
	}
	public java.lang.String getBur_sta_code() {
		return bur_sta_code;
	}
	public void setBur_sta_code(java.lang.String bur_sta_code) {
		this.bur_sta_code = bur_sta_code;
	}
	public java.lang.String getHotelSum() {
		return hotelSum;
	}
	public void setHotelSum(java.lang.String hotelSum) {
		this.hotelSum = hotelSum;
	}
	public java.lang.String getInfoSum() {
		return infoSum;
	}
	public void setInfoSum(java.lang.String infoSum) {
		this.infoSum = infoSum;
	}
	
	}

