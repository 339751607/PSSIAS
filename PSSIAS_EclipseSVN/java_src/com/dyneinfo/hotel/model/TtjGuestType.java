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


public class TtjGuestType extends BaseEntity {
	
	//alias
	public static final String TABLE_ALIAS = "旅客类型统计";
	public static final String ALIAS_GUESTTYPE = "旅客类型";
	public static final String ALIAS_GUESTCH = "境内旅客";
	public static final String ALIAS_GUESTJW = "境外旅客";
	public static final String ALIAS_TOTAL = "合计";
	public static final String ALIAS_BDATE = "出生日期";
	public static final String ALIAS_XZQH = "户籍地";
	public static final String ALIAS_IN_TIME = "入住时间";
	public static final String ALIAS_OUT_TIME = "退宿时间";
	public static final String ALIAS_STA_CODE = "派出所";
	public static final String ALIAS_BUR_CODE = "分局";
	public static final String ALIAS_HOTELNAME = "旅馆名称";
	
	//date formats
	
	//columns START
	private java.lang.String sex;
	private java.lang.String chn;
	private java.lang.String jwn;
	private java.lang.String total;
	public java.lang.String getSex() {
		return sex;
	}
	public void setSex(java.lang.String sex) {
		this.sex = sex;
	}
	public java.lang.String getChn() {
		return chn;
	}
	public void setChn(java.lang.String chn) {
		this.chn = chn;
	}
	public java.lang.String getJwn() {
		return jwn;
	}
	public void setJwn(java.lang.String jwn) {
		this.jwn = jwn;
	}
	public java.lang.String getTotal() {
		return total;
	}
	public void setTotal(java.lang.String total) {
		this.total = total;
	}
}

