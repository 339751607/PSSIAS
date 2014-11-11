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


public class Tcarreturn extends BaseEntity {
	
	//alias
	public static final String TABLE_ALIAS = "Tcarreturn";
	public static final String ALIAS_ENROLID = "登记序号";
	public static final String ALIAS_DELINAME = "送车人姓名";
	public static final String ALIAS_DELICREDTYPE = "送车人证件类型";
	public static final String ALIAS_DELICREDCODE = "送车人身份证号码";
	public static final String ALIAS_RECETIME = "收车时间";
	public static final String ALIAS_RECENAME = "收车人姓名";
	public static final String ALIAS_TAKEOFFNAME = "取车人姓名";
	public static final String ALIAS_TOCREDTYPE = "取车人证件类型";
	public static final String ALIAS_TOCREDCODE = "取车人身份证号码";
	public static final String ALIAS_TOTIME = "取车时间";
	public static final String ALIAS_deptname ="企业名称";	
	public static final String ALIAS_FLAG = "是否删除";
	public static final String ALIAS_ENROLTIME = "登记时间";
	public static final String ALIAS_OPERATOR = "操作员";
	public static final String ALIAS_DELITELEPHONE = "送车人电话";
	public static final String ALIAS_DELIADDRESS = "送车人住址";	//add by zzq 2012/06/12
	public static final String ALIAS_SERVERITEM = "服务项目";
	public static final String ALIAS_DEMO = "备注";
	
	//date formats
	
	//columns START
	private java.lang.String enrolid;
	private java.lang.String deliname;
	private java.lang.String delicredtype;
	private java.lang.String delicredcode;
	private java.lang.String recetime;
	private java.lang.String recename;
	private java.lang.String takeoffname;
	private java.lang.String tocredtype;
	private java.lang.String tocredcode;
	private java.lang.String totime;
	private java.lang.String flag;
	private java.lang.String enroltime;
	private java.lang.String operator;
	private java.lang.String delitelephone;
	private java.lang.String deliaddress;//送车人住址(湛江要求添加新字段) add by zzq 2012/06/12
	private java.lang.String serveritem;
	private java.lang.String demo;
	private java.lang.String tomobile;
	private java.lang.String deptname;
	//columns END



	public Tcarreturn(){
	}

	public java.lang.String getDeptname() {
		return this.deptname;
	}

	public void setDeptname(java.lang.String value) {
		this.deptname = value;
	}

	public Tcarreturn(
		java.lang.String enrolid
	){
		this.enrolid = enrolid;
	}

	public void setEnrolid(java.lang.String value) {
		this.enrolid = value;
	}
	
	public java.lang.String getEnrolid() {
		return this.enrolid;
	}
	public void setDeliname(java.lang.String value) {
		this.deliname = value;
	}
	
	public java.lang.String getDeliname() {
		return this.deliname;
	}
	public void setDelicredtype(java.lang.String value) {
		this.delicredtype = value;
	}
	
	public java.lang.String getDelicredtype() {
		return this.delicredtype;
	}
	public void setDelicredcode(java.lang.String value) {
		this.delicredcode = value;
	}
	
	public java.lang.String getDelicredcode() {
		return this.delicredcode;
	}
	public void setRecetime(java.lang.String value) {
		this.recetime = value;
	}
	
	public java.lang.String getRecetime() {
		return this.recetime;
	}
	public void setRecename(java.lang.String value) {
		this.recename = value;
	}
	
	public java.lang.String getRecename() {
		return this.recename;
	}
	public void setTakeoffname(java.lang.String value) {
		this.takeoffname = value;
	}
	
	public java.lang.String getTakeoffname() {
		return this.takeoffname;
	}
	public void setTocredtype(java.lang.String value) {
		this.tocredtype = value;
	}
	
	public java.lang.String getTocredtype() {
		return this.tocredtype;
	}
	public void setTocredcode(java.lang.String value) {
		this.tocredcode = value;
	}
	
	public java.lang.String getTocredcode() {
		return this.tocredcode;
	}
	public void setTotime(java.lang.String value) {
		this.totime = value;
	}
	
	public java.lang.String getTotime() {
		return this.totime;
	}
	public void setFlag(java.lang.String value) {
		this.flag = value;
	}
	
	public java.lang.String getFlag() {
		return this.flag;
	}
	public void setEnroltime(java.lang.String value) {
		this.enroltime = value;
	}
	
	public java.lang.String getEnroltime() {
		return this.enroltime;
	}
	public void setOperator(java.lang.String value) {
		this.operator = value;
	}
	
	public java.lang.String getOperator() {
		return this.operator;
	}
	public void setDelitelephone(java.lang.String value) {
		this.delitelephone = value;
	}
	
	public java.lang.String getDelitelephone() {
		return this.delitelephone;
	}
	public void setServeritem(java.lang.String value) {
		this.serveritem = value;
	}
	
	public java.lang.String getServeritem() {
		return this.serveritem;
	}
	public void setDemo(java.lang.String value) {
		this.demo = value;
	}
	
	public java.lang.String getDemo() {
		return this.demo;
	}

	public String toString() {
		return new ToStringBuilder(this)
			.append("Enrolid",getEnrolid())
			.append("Deliname",getDeliname())
			.append("Delicredtype",getDelicredtype())
			.append("Delicredcode",getDelicredcode())
			.append("Recetime",getRecetime())
			.append("Recename",getRecename())
			.append("Takeoffname",getTakeoffname())
			.append("Tocredtype",getTocredtype())
			.append("Tocredcode",getTocredcode())
			.append("Totime",getTotime())
			.append("Flag",getFlag())
			.append("Enroltime",getEnroltime())
			.append("Operator",getOperator())
			.append("Delitelephone",getDelitelephone())
			.append("Serveritem",getServeritem())
			.append("Demo",getDemo())
			.append("Tomobile",getTomobile())
			.append("deptname",getDeptname())
			.toString();
	}
	
	public int hashCode() {
		return new HashCodeBuilder()
			.append(getEnrolid())
			.append(getDeliname())
			.append(getDelicredtype())
			.append(getDelicredcode())
			.append(getRecetime())
			.append(getRecename())
			.append(getTakeoffname())
			.append(getTocredtype())
			.append(getTocredcode())
			.append(getTotime())
			.append(getFlag())
			.append(getEnroltime())
			.append(getOperator())
			.append(getDelitelephone())
			.append(getServeritem())
			.append(getDemo())
			.append(getTomobile())
			.append(getDeptname())
			.toHashCode();
	}
	
	public boolean equals(Object obj) {
		if(obj instanceof Tcarreturn == false) return false;
		if(this == obj) return true;
		Tcarreturn other = (Tcarreturn)obj;
		return new EqualsBuilder()
			.append(getEnrolid(),other.getEnrolid())
			.append(getDeliname(),other.getDeliname())
			.append(getDelicredtype(),other.getDelicredtype())
			.append(getDelicredcode(),other.getDelicredcode())
			.append(getRecetime(),other.getRecetime())
			.append(getRecename(),other.getRecename())
			.append(getTakeoffname(),other.getTakeoffname())
			.append(getTocredtype(),other.getTocredtype())
			.append(getTocredcode(),other.getTocredcode())
			.append(getTotime(),other.getTotime())
			.append(getFlag(),other.getFlag())
			.append(getEnroltime(),other.getEnroltime())
			.append(getOperator(),other.getOperator())
			.append(getDelitelephone(),other.getDelitelephone())
			.append(getServeritem(),other.getServeritem())
			.append(getDemo(),other.getDemo())
			.append(getTomobile(),other.getTomobile())
			.append(getDeptname(), other.getDeptname())
			.isEquals();
	}

	public java.lang.String getTomobile() {
		return tomobile;
	}

	public void setTomobile(java.lang.String tomobile) {
		this.tomobile = tomobile;
	}

	public java.lang.String getDeliaddress() {
		return deliaddress;
	}

	public void setDeliaddress(java.lang.String deliaddress) {
		this.deliaddress = deliaddress;
	}
}

