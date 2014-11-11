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


public class TtjGuestRepeat extends BaseEntity {
	
	//alias
	public static final String TABLE_ALIAS = "频繁入住统计";
	public static final String ALIAS_NAME = "姓名";
	public static final String ALIAS_ID_NAME = "证件类型";
	public static final String ALIAS_ID_CODE = "证件号码";
	public static final String ALIAS_STA_CODE = "派出所";
	public static final String ALIAS_BUR_CODE = "分局";
	public static final String ALIAS_INCOUNT = "入住次数";
	public static final String ALIAS_IN_TIME = "入住时间";

	
	//date formats
	
	//columns START
	private java.lang.String id;
	private java.lang.String name;
	private java.lang.String idName;
	private java.lang.String idCode;
	private java.lang.String inTime;
	private java.lang.String inCount;
	private java.lang.String staCode;
	private java.lang.String burCode;
	
	
	
	public java.lang.String getName() {
		return name;
	}
	public void setName(java.lang.String name) {
		this.name = name;
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
	public java.lang.String getInTime() {
		return inTime;
	}
	public void setInTime(java.lang.String inTime) {
		this.inTime = inTime;
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
	public java.lang.String getInCount() {
		return inCount;
	}
	public void setInCount(java.lang.String inCount) {
		this.inCount = inCount;
	}
	public java.lang.String getId() {
		return id;
	}
	public void setId(java.lang.String id) {
		this.id = id;
	}

}

