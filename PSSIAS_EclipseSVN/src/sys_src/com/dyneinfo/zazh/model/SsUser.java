/*
 * Powered By []
 * Web Site: 
 * 
 */

package com.dyneinfo.zazh.model;

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

import com.dyneinfo.zazh.model.*;
import com.dyneinfo.zazh.dao.*;
import com.dyneinfo.zazh.service.*;

/**
 * @author  email: lee(a)gmail.com
 * @version 1.0
 * @since 1.0
 */


public class SsUser extends BaseEntity {
	
	//alias
	public static final String TABLE_ALIAS = "SsUser";
	public static final String ALIAS_USERID = "用户ID";
	public static final String ALIAS_USERNAME = "用户名";
	public static final String ALIAS_PASSWORD = "密码";
	public static final String ALIAS_FULLNAME = "姓名";
	public static final String ALIAS_SEX = "性别";
	public static final String ALIAS_SFZH = "身份证号";
	public static final String ALIAS_POLICEID = "警号";
	public static final String ALIAS_PHONE = "家庭电话";
	public static final String ALIAS_MOBILE = "移动电话";
	public static final String ALIAS_FAX = "传真";
	public static final String ALIAS_ADDRESS = "家庭住址";
	public static final String ALIAS_ZIP = "邮编";
	public static final String ALIAS_EMAILADDRESS = "电子邮件";
	public static final String ALIAS_CREATEDATE = "创建日期";
	public static final String ALIAS_DEPTID = "部门ID";
	public static final String ALIAS_ENABLED = "状态";
	public static final String ALIAS_PHOTO = "照片";
	public static final String ALIAS_DESCRIPTION="描述";
	public static final String ALIAS_EXPIRATIONDATE ="有效期";
	
	
	//date formats
	public static final String FORMAT_CREATEDATE = DATE_TIME_FORMAT;
	
	//columns START
	private java.lang.Long userid;
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
	private java.sql.Date createdate;
	private java.lang.String deptid;
	private java.lang.String deptname;
	private java.lang.Long enabled;
	private java.lang.String photo;
	private java.lang.Long createuserid;
	private java.lang.Long initialpassword;
	private java.lang.String description;
	private java.lang.String expirationdate;
	
	private java.lang.String sfxsdel; //是否显示删除操作
	
	private java.lang.Long roleid;
	
	protected SsDept dept;
	//columns END

	public SsUser(){
	}

	public java.lang.Long getRoleid() {
		return roleid;
	}

	public void setRoleid(java.lang.Long roleid) {
		this.roleid = roleid;
	}

	public SsUser(
		java.lang.Long userid
	){
		this.userid = userid;
	}

	public void setUserid(java.lang.Long value) {
		this.userid = value;
	}
	
	public java.lang.Long getUserid() {
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

	
	public void setCreatedate(java.sql.Date createdate) {
		this.createdate = createdate;
	}

	public java.sql.Date getCreatedate() {
		return this.createdate;
	}
	public void setDeptid(java.lang.String value) {
		this.deptid = value;
	}
	
	public java.lang.String getDeptid() {
		return this.deptid;
	}
	public void setEnabled(java.lang.Long value) {
		this.enabled = value;
	}
	
	public java.lang.Long getEnabled() {
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
			.append("Createuserid",getCreateuserid())
			.append("Initialpassword",getInitialpassword())
			.append("Description",getDescription())
			.append("Expirationdate",getExpirationdate())
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
			.append(getCreateuserid())
			.append(getInitialpassword())
			.append(getDescription())
			.append(getExpirationdate())
			.toHashCode();
	}
	
	public boolean equals(Object obj) {
		if(obj instanceof SsUser == false) return false;
		if(this == obj) return true;
		SsUser other = (SsUser)obj;
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
			.append(getCreateuserid(),other.getCreateuserid())
			.append(getInitialpassword(),other.getInitialpassword())
			.append(getDescription(),other.getDescription())
			.append(getExpirationdate(),other.getExpirationdate())
			.isEquals();
	}

	public SsDept getDept() {
		return dept;
	}

	public void setDept(SsDept dept) {
		this.dept = dept;
	}

	public java.lang.Long getCreateuserid() {
		return createuserid;
	}

	public void setCreateuserid(java.lang.Long createuserid) {
		this.createuserid = createuserid;
	}

	public java.lang.Long getInitialpassword() {
		return initialpassword;
	}

	public void setInitialpassword(java.lang.Long initialpassword) {
		this.initialpassword = initialpassword;
	}

	public java.lang.String getDescription() {
		return description;
	}

	public void setDescription(java.lang.String description) {
		this.description = description;
	}

	public java.lang.String getExpirationdate() {
		return expirationdate;
	}

	public void setExpirationdate(java.lang.String expirationdate) {
		this.expirationdate = expirationdate;
	}

	public java.lang.String getDeptname() {
		return deptname;
	}

	public void setDeptname(java.lang.String deptname) {
		this.deptname = deptname;
	}

	public java.lang.String getSfxsdel() {
		return sfxsdel;
	}

	public void setSfxsdel(java.lang.String sfxsdel) {
		this.sfxsdel = sfxsdel;
	}


}

