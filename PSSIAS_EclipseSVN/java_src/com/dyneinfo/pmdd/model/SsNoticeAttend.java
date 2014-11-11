/*
 * Powered By [lishicheng]
 */

package com.dyneinfo.pmdd.model;

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

import com.dyneinfo.pmdd.dao.*;
import com.dyneinfo.pmdd.model.*;
import com.dyneinfo.pmdd.service.*;

/**
 * @author lisc email:lishicheng(a)gmail.com
 */


public class SsNoticeAttend extends BaseEntity {
	
	//alias
	public static final String TABLE_ALIAS = "通知参与";
	public static final String ALIAS_ATTENDID = "通知参与ID";
	public static final String ALIAS_NOTICEID = "通知ID";
	public static final String ALIAS_USERID = "用户ID";
	public static final String ALIAS_DEPTID = "部门ID";
	public static final String ALIAS_ISDEPT = "是否为部门 0 否 1 是";
	
	//date formats
	
	//columns START
	private java.lang.Long attendid;
	private Long noticeid;
	private String userid;
	private Long deptid;
	private Long isdept;
	//columns END

	public SsNoticeAttend(){
	}

	public SsNoticeAttend(
		java.lang.Long attendid
	){
		this.attendid = attendid;
	}

	public void setAttendid(java.lang.Long value) {
		this.attendid = value;
	}
	
	public java.lang.Long getAttendid() {
		return this.attendid;
	}
	public void setNoticeid(Long value) {
		this.noticeid = value;
	}
	
	public Long getNoticeid() {
		return this.noticeid;
	}
	public void setUserid(String value) {
		this.userid = value;
	}
	
	public String getUserid() {
		return this.userid;
	}
	public void setDeptid(Long value) {
		this.deptid = value;
	}
	
	public Long getDeptid() {
		return this.deptid;
	}
	public void setIsdept(Long value) {
		this.isdept = value;
	}
	
	public Long getIsdept() {
		return this.isdept;
	}
	
	private SsNotice ssNotice;
	
	public void setSsNotice(SsNotice ssNotice){
		this.ssNotice = ssNotice;
	}
	
	public SsNotice getSsNotice() {
		return ssNotice;
	}

	public String toString() {
		return new ToStringBuilder(this)
			.append("Attendid",getAttendid())
			.append("Noticeid",getNoticeid())
			.append("Userid",getUserid())
			.append("Deptid",getDeptid())
			.append("Isdept",getIsdept())
			.toString();
	}
	
	public int hashCode() {
		return new HashCodeBuilder()
			.append(getAttendid())
			.append(getNoticeid())
			.append(getUserid())
			.append(getDeptid())
			.append(getIsdept())
			.toHashCode();
	}
	
	public boolean equals(Object obj) {
		if(obj instanceof SsNoticeAttend == false) return false;
		if(this == obj) return true;
		SsNoticeAttend other = (SsNoticeAttend)obj;
		return new EqualsBuilder()
			.append(getAttendid(),other.getAttendid())
			.append(getNoticeid(),other.getNoticeid())
			.append(getUserid(),other.getUserid())
			.append(getDeptid(),other.getDeptid())
			.append(getIsdept(),other.getIsdept())
			.isEquals();
	}
}

