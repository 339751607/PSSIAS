/*
 * Powered By [lishicheng]
 */

package com.dyneinfo.fjy.model;

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

import com.dyneinfo.fjy.model.*;
import com.dyneinfo.fjy.dao.*;
import com.dyneinfo.fjy.service.*;

/**
 * @author lisc email:lishicheng(a)gmail.com
 */


public class Question extends BaseEntity {
	
	//alias
	public static final String TABLE_ALIAS = "问题反馈";
	public static final String ALIAS_XH = "xh";
	public static final String ALIAS_USERNAME = "用户名";
	public static final String ALIAS_WTSJ = "反馈时间";
	public static final String ALIAS_COMPUTERIP = "用户IP";
	public static final String ALIAS_USERTEL = "用户电话";
	public static final String ALIAS_WTFL = "问题分类";
	public static final String ALIAS_WTNR = "问题内容";
	public static final String ALIAS_JDSJ = "解答时间";
	public static final String ALIAS_JDNR = "解答内容";
	public static final String ALIAS_JDR = "解答人";
	public static final String ALIAS_JDBZ = "解答";
	public static final String ALIAS_FLAG = "显示";
	public static final String ALIAS_NOTE = "备注";
	
	//date formats
	
	//columns START
	private Long xh;
	private String username;
	private String wtsj;
	private String computerip;
	private String usertel;
	private String wtfl;
	private String wtnr;
	private String jdsj;
	private String jdnr;
	private String jdr;
	private String jdbz;
	private String flag;
	private String note;
	
	private String deptid;
	private String deptname;
	//columns END

	public Question(){
	}

	public Question(
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
	public void setUsername(String value) {
		this.username = value;
	}
	
	public String getUsername() {
		return this.username;
	}
	public void setWtsj(String value) {
		this.wtsj = value;
	}
	
	public String getWtsj() {
		return this.wtsj;
	}
	public void setComputerip(String value) {
		this.computerip = value;
	}
	
	public String getComputerip() {
		return this.computerip;
	}
	public void setUsertel(String value) {
		this.usertel = value;
	}
	
	public String getUsertel() {
		return this.usertel;
	}
	public void setWtfl(String value) {
		this.wtfl = value;
	}
	
	public String getWtfl() {
		return this.wtfl;
	}
	public void setWtnr(String value) {
		this.wtnr = value;
	}
	
	public String getWtnr() {
		return this.wtnr;
	}
	public void setJdsj(String value) {
		this.jdsj = value;
	}
	
	public String getJdsj() {
		return this.jdsj;
	}
	public void setJdnr(String value) {
		this.jdnr = value;
	}
	
	public String getJdnr() {
		return this.jdnr;
	}
	public void setJdr(String value) {
		this.jdr = value;
	}
	
	public String getJdr() {
		return this.jdr;
	}
	public void setJdbz(String value) {
		this.jdbz = value;
	}
	
	public String getJdbz() {
		return this.jdbz;
	}
	public void setFlag(String value) {
		this.flag = value;
	}
	
	public String getFlag() {
		return this.flag;
	}
	public void setNote(String value) {
		this.note = value;
	}
	
	public String getNote() {
		return this.note;
	}

	public String toString() {
		return new ToStringBuilder(this)
			.append("Xh",getXh())
			.append("Username",getUsername())
			.append("Wtsj",getWtsj())
			.append("Computerip",getComputerip())
			.append("Usertel",getUsertel())
			.append("Wtfl",getWtfl())
			.append("Wtnr",getWtnr())
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
			.append(getUsername())
			.append(getWtsj())
			.append(getComputerip())
			.append(getUsertel())
			.append(getWtfl())
			.append(getWtnr())
			.append(getJdsj())
			.append(getJdnr())
			.append(getJdr())
			.append(getJdbz())
			.append(getFlag())
			.append(getNote())
			.toHashCode();
	}
	
	public boolean equals(Object obj) {
		if(obj instanceof Question == false) return false;
		if(this == obj) return true;
		Question other = (Question)obj;
		return new EqualsBuilder()
			.append(getXh(),other.getXh())
			.append(getUsername(),other.getUsername())
			.append(getWtsj(),other.getWtsj())
			.append(getComputerip(),other.getComputerip())
			.append(getUsertel(),other.getUsertel())
			.append(getWtfl(),other.getWtfl())
			.append(getWtnr(),other.getWtnr())
			.append(getJdsj(),other.getJdsj())
			.append(getJdnr(),other.getJdnr())
			.append(getJdr(),other.getJdr())
			.append(getJdbz(),other.getJdbz())
			.append(getFlag(),other.getFlag())
			.append(getNote(),other.getNote())
			.isEquals();
	}

	public String getDeptid() {
		return deptid;
	}

	public void setDeptid(String deptid) {
		this.deptid = deptid;
	}

	public String getDeptname() {
		return deptname;
	}

	public void setDeptname(String deptname) {
		this.deptname = deptname;
	}
}

