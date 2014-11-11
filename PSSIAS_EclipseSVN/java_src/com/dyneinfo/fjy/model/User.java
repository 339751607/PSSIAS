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


public class User extends BaseEntity {
	
	//alias
	public static final String TABLE_ALIAS = "操作员";
	public static final String ALIAS_USERID = "ID";
	public static final String ALIAS_USERNAME = "用户名";
	public static final String ALIAS_PASSWORD = "密码";
	public static final String ALIAS_FULLNAME = "姓名";
	public static final String ALIAS_SEX = "性别";
	public static final String ALIAS_SFZH = "身份证号码";
	public static final String ALIAS_POLICEID = "警号";
	public static final String ALIAS_PHONE = "电话号码";
	public static final String ALIAS_MOBILE = "手机号码";
	public static final String ALIAS_FAX = "传真号码";
	public static final String ALIAS_ADDRESS = "家庭地址";
	public static final String ALIAS_ZIP = "邮政编码";
	public static final String ALIAS_EMAILADDRESS = "电子邮件";
	public static final String ALIAS_CREATEDATE = "创建日期";
	public static final String ALIAS_DEPTID = "deptid";
	public static final String ALIAS_ENABLED = "状态";
	public static final String ALIAS_PHOTO = "photo";
	
	//date formatszh
	public static final String FORMAT_CREATEDATE = DATE_TIME_FORMAT;
	
	//columns START
	private Long userid;
	private java.lang.String username;
	private java.lang.String password;
	private java.lang.String fullname;
	private java.lang.String sex;
	private java.lang.String sfzh;
	private java.lang.String policeid;
	private java.lang.String phone;
	private java.lang.String mobile;
	private java.lang.String fax;
	private java.lang.String address;
	private java.lang.String zip;
	private java.lang.String emailaddress;
	private java.util.Date createdate;
	private Long deptid;
	private String enabled;
	private java.lang.String photo;
	//columns END

	public User(){
	}

	public User(
		Long userid
	){
		this.userid = userid;
	}

	public void setUserid(Long value) {
		this.userid = value;
	}
	
	public Long getUserid() {
		return this.userid;
	}
	public void setUsername(java.lang.String value) {
		this.username = value;
	}
	
	public java.lang.String getUsername() {
		return this.username;
	}
	public void setPassword(java.lang.String value) {
		this.password = value;
	}
	
	public java.lang.String getPassword() {
		return this.password;
	}
	public void setFullname(java.lang.String value) {
		this.fullname = value;
	}
	
	public java.lang.String getFullname() {
		return this.fullname;
	}
	public void setSex(java.lang.String value) {
		this.sex = value;
	}
	
	public java.lang.String getSex() {
		return this.sex;
	}
	public void setSfzh(java.lang.String value) {
		this.sfzh = value;
	}
	
	public java.lang.String getSfzh() {
		return this.sfzh;
	}
	public void setPoliceid(java.lang.String value) {
		this.policeid = value;
	}
	
	public java.lang.String getPoliceid() {
		return this.policeid;
	}
	public void setPhone(java.lang.String value) {
		this.phone = value;
	}
	
	public java.lang.String getPhone() {
		return this.phone;
	}
	public void setMobile(java.lang.String value) {
		this.mobile = value;
	}
	
	public java.lang.String getMobile() {
		return this.mobile;
	}
	public void setFax(java.lang.String value) {
		this.fax = value;
	}
	
	public java.lang.String getFax() {
		return this.fax;
	}
	public void setAddress(java.lang.String value) {
		this.address = value;
	}
	
	public java.lang.String getAddress() {
		return this.address;
	}
	public void setZip(java.lang.String value) {
		this.zip = value;
	}
	
	public java.lang.String getZip() {
		return this.zip;
	}
	public void setEmailaddress(java.lang.String value) {
		this.emailaddress = value;
	}
	
	public java.lang.String getEmailaddress() {
		return this.emailaddress;
	}
	public String getCreatedateString() {
		return date2String(getCreatedate(), FORMAT_CREATEDATE);
	}
	public void setCreatedateString(String value) {
		setCreatedate(string2Date(value, FORMAT_CREATEDATE,java.util.Date.class));
	}
	
	public void setCreatedate(java.util.Date value) {
		this.createdate = value;
	}
	
	public java.util.Date getCreatedate() {
		return this.createdate;
	}
	public void setDeptid(Long value) {
		this.deptid = value;
	}
	
	public Long getDeptid() {
		return this.deptid;
	}
	public void setEnabled(String value) {
		this.enabled = value;
	}
	
	public String getEnabled() {
		return this.enabled;
	}
	public void setPhoto(java.lang.String value) {
		this.photo = value;
	}
	
	public java.lang.String getPhoto() {
		return this.photo;
	}

	public String toString() {
		return new ToStringBuilder(this)
			.append("Userid",getUserid())
			.append("Username",getUsername())
			.append("Password",getPassword())
			.append("Fullname",getFullname())
			.append("Sex",getSex())
			.append("Sfzh",getSfzh())
			.append("Policeid",getPoliceid())
			.append("Phone",getPhone())
			.append("Mobile",getMobile())
			.append("Fax",getFax())
			.append("Address",getAddress())
			.append("Zip",getZip())
			.append("Emailaddress",getEmailaddress())
			.append("Createdate",getCreatedate())
			.append("Deptid",getDeptid())
			.append("Enabled",getEnabled())
			.append("Photo",getPhoto())
			.toString();
	}
	
	public int hashCode() {
		return new HashCodeBuilder()
			.append(getUserid())
			.append(getUsername())
			.append(getPassword())
			.append(getFullname())
			.append(getSex())
			.append(getSfzh())
			.append(getPoliceid())
			.append(getPhone())
			.append(getMobile())
			.append(getFax())
			.append(getAddress())
			.append(getZip())
			.append(getEmailaddress())
			.append(getCreatedate())
			.append(getDeptid())
			.append(getEnabled())
			.append(getPhoto())
			.toHashCode();
	}
	
	public boolean equals(Object obj) {
		if(obj instanceof User == false) return false;
		if(this == obj) return true;
		User other = (User)obj;
		return new EqualsBuilder()
			.append(getUserid(),other.getUserid())
			.append(getUsername(),other.getUsername())
			.append(getPassword(),other.getPassword())
			.append(getFullname(),other.getFullname())
			.append(getSex(),other.getSex())
			.append(getSfzh(),other.getSfzh())
			.append(getPoliceid(),other.getPoliceid())
			.append(getPhone(),other.getPhone())
			.append(getMobile(),other.getMobile())
			.append(getFax(),other.getFax())
			.append(getAddress(),other.getAddress())
			.append(getZip(),other.getZip())
			.append(getEmailaddress(),other.getEmailaddress())
			.append(getCreatedate(),other.getCreatedate())
			.append(getDeptid(),other.getDeptid())
			.append(getEnabled(),other.getEnabled())
			.append(getPhoto(),other.getPhoto())
			.isEquals();
	}
}

