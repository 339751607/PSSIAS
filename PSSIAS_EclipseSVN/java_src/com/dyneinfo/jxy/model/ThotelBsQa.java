/*
 * Powered By [lishicheng]
 */

package com.dyneinfo.jxy.model;

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

import com.dyneinfo.jxy.dao.*;
import com.dyneinfo.jxy.model.*;
import com.dyneinfo.jxy.service.*;

/**
 * @author lisc email:lishicheng(a)gmail.com
 */


public class ThotelBsQa extends BaseEntity {
	
	//alias
	public static final String TABLE_ALIAS = "问题反馈";
	public static final String ALIAS_XH = "问题序号";
	public static final String ALIAS_CODE = "单位代码";
	public static final String ALIAS_DWMC = "提问单位名称";
	public static final String ALIAS_USERNAME = "用户";
	public static final String ALIAS_WTSJ = "提问时间";
	public static final String ALIAS_COMPUTERIP = "用户IP";
	public static final String ALIAS_USERTEL = "提问用户电话";
	public static final String ALIAS_WTNR = "问题内容";
	public static final String ALIAS_WTFL = "问题分类";
	public static final String ALIAS_JDSJ = "解答时间";
	public static final String ALIAS_JDNR = "解答内容";
	public static final String ALIAS_JDR = "解答人";
	public static final String ALIAS_JDBZ = "解答状态";
	public static final String ALIAS_FLAG = "前台是否显示";
	public static final String ALIAS_NOTE = "备注";
	//date formats
	
	//columns START
	private Long xh;
	private java.lang.String code;
	private java.lang.String dwmc;
	private java.lang.String username;
	private java.lang.String wtsj;
	private java.lang.String computerip;
	private java.lang.String usertel;
	private java.lang.String wtnr;
	private java.lang.String wtfl;
	private java.lang.String jdsj;
	private java.lang.String jdnr;
	private java.lang.String jdr;
	private java.lang.String jdbz;
	private java.lang.String flag;
	private java.lang.String note;
	//columns END

	public java.lang.String getDwmc() {
		return dwmc;
	}

	public void setDwmc(java.lang.String dwmc) {
		this.dwmc = dwmc;
	}

	public ThotelBsQa(){
	}

	public ThotelBsQa(
		Long xh
	){
		this.xh = xh;
	}

	public void setXh(Long value) {
		this.xh = value;
	}
	
	public Long getXh() {
		return this.xh;
	}
	public void setCode(java.lang.String value) {
		this.code = value;
	}
	
	public java.lang.String getCode() {
		return this.code;
	}
	public void setUsername(java.lang.String value) {
		this.username = value;
	}
	
	public java.lang.String getUsername() {
		return this.username;
	}
	public void setWtsj(java.lang.String value) {
		this.wtsj = value;
	}
	
	public java.lang.String getWtsj() {
		return this.wtsj;
	}
	public void setComputerip(java.lang.String value) {
		this.computerip = value;
	}
	
	public java.lang.String getComputerip() {
		return this.computerip;
	}
	public void setUsertel(java.lang.String value) {
		this.usertel = value;
	}
	
	public java.lang.String getUsertel() {
		return this.usertel;
	}
	public void setWtnr(java.lang.String value) {
		this.wtnr = value;
	}
	
	public java.lang.String getWtnr() {
		return this.wtnr;
	}
	public void setWtfl(java.lang.String value) {
		this.wtfl = value;
	}
	
	public java.lang.String getWtfl() {
		return this.wtfl;
	}
	public void setJdsj(java.lang.String value) {
		this.jdsj = value;
	}
	
	public java.lang.String getJdsj() {
		return this.jdsj;
	}
	public void setJdnr(java.lang.String value) {
		this.jdnr = value;
	}
	
	public java.lang.String getJdnr() {
		return this.jdnr;
	}
	public void setJdr(java.lang.String value) {
		this.jdr = value;
	}
	
	public java.lang.String getJdr() {
		return this.jdr;
	}
	public void setJdbz(java.lang.String value) {
		this.jdbz = value;
	}
	
	public java.lang.String getJdbz() {
		return this.jdbz;
	}
	public void setFlag(java.lang.String value) {
		this.flag = value;
	}
	
	public java.lang.String getFlag() {
		return this.flag;
	}
	public void setNote(java.lang.String value) {
		this.note = value;
	}
	
	public java.lang.String getNote() {
		return this.note;
	}

	public String toString() {
		return new ToStringBuilder(this)
			.append("Xh",getXh())
			.append("Code",getCode())
			.append("Username",getUsername())
			.append("Wtsj",getWtsj())
			.append("Computerip",getComputerip())
			.append("Usertel",getUsertel())
			.append("Wtnr",getWtnr())
			.append("Wtfl",getWtfl())
			.append("Jdsj",getJdsj())
			.append("Jdnr",getJdnr())
			.append("Jdr",getJdr())
			.append("Jdbz",getJdbz())
			.append("Flag",getFlag())
			.append("Note",getNote())
			.toString();
	}
	
	public int hashCode() {
		return new HashCodeBuilder()
			.append(getXh())
			.append(getCode())
			.append(getUsername())
			.append(getWtsj())
			.append(getComputerip())
			.append(getUsertel())
			.append(getWtnr())
			.append(getWtfl())
			.append(getJdsj())
			.append(getJdnr())
			.append(getJdr())
			.append(getJdbz())
			.append(getFlag())
			.append(getNote())
			.toHashCode();
	}
	
	public boolean equals(Object obj) {
		if(obj instanceof ThotelBsQa == false) return false;
		if(this == obj) return true;
		ThotelBsQa other = (ThotelBsQa)obj;
		return new EqualsBuilder()
			.append(getXh(),other.getXh())
			.append(getCode(),other.getCode())
			.append(getUsername(),other.getUsername())
			.append(getWtsj(),other.getWtsj())
			.append(getComputerip(),other.getComputerip())
			.append(getUsertel(),other.getUsertel())
			.append(getWtnr(),other.getWtnr())
			.append(getWtfl(),other.getWtfl())
			.append(getJdsj(),other.getJdsj())
			.append(getJdnr(),other.getJdnr())
			.append(getJdr(),other.getJdr())
			.append(getJdbz(),other.getJdbz())
			.append(getFlag(),other.getFlag())
			.append(getNote(),other.getNote())
			.isEquals();
	}
}

