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


public class VcsrxxSta extends BaseEntity {
	
	//alias
	public static final String TABLE_ALIAS = "VcsrxxSta";
	public static final String ALIAS_IDCARD = "出售人身份证号码";
	public static final String ALIAS_CSRXM = "出售人姓名";
	public static final String ALIAS_CPCODE = "cpcode";
	public static final String ALIAS_NPCODE = "出售人户籍地";
	public static final String ALIAS_NPADDRESS = "出售人户籍地详址";
	public static final String ALIAS_WUPINLB = "wupinlb";
	public static final String ALIAS_CALLED = "废旧物品类别";
	public static final String ALIAS_WPZL = "重量(斤)";
	public static final String ALIAS_DEPTNAME = "收购企业名称";
	public static final String ALIAS_DEPTSEQ = "deptseq";
	public static final String ALIAS_WUPINXH = "wupinxh";
	public static final String ALIAS_SHOUGOURQ = "出售时间";
	
	//date formats
	
	//columns START
	private java.lang.String idcard;
	private java.lang.String csrxm;
	private java.lang.String cpcode;
	private java.lang.String npcode;
	private java.lang.String npaddress;
	private java.lang.String wupinlb;
	private java.lang.String called;
	private java.lang.String wpzl;
	private java.lang.String deptname;
	private java.lang.String deptseq;
	private java.lang.String wupinxh;
	private java.lang.String shougourq;
	//columns END

	public VcsrxxSta(){
	}

	public VcsrxxSta(
		java.lang.String idcard
	){
		this.idcard = idcard;
	}

	public void setIdcard(java.lang.String value) {
		this.idcard = value;
	}
	
	public java.lang.String getIdcard() {
		return this.idcard;
	}
	public void setCsrxm(java.lang.String value) {
		this.csrxm = value;
	}
	
	public java.lang.String getCsrxm() {
		return this.csrxm;
	}
	public void setCpcode(java.lang.String value) {
		this.cpcode = value;
	}
	
	public java.lang.String getCpcode() {
		return this.cpcode;
	}
	public void setNpcode(java.lang.String value) {
		this.npcode = value;
	}
	
	public java.lang.String getNpcode() {
		return this.npcode;
	}
	public void setNpaddress(java.lang.String value) {
		this.npaddress = value;
	}
	
	public java.lang.String getNpaddress() {
		return this.npaddress;
	}
	public void setWupinlb(java.lang.String value) {
		this.wupinlb = value;
	}
	
	public java.lang.String getWupinlb() {
		return this.wupinlb;
	}
	public void setCalled(java.lang.String value) {
		this.called = value;
	}
	
	public java.lang.String getCalled() {
		return this.called;
	}
	public void setWpzl(java.lang.String value) {
		this.wpzl = value;
	}
	
	public java.lang.String getWpzl() {
		return this.wpzl;
	}
	public void setDeptname(java.lang.String value) {
		this.deptname = value;
	}
	
	public java.lang.String getDeptname() {
		return this.deptname;
	}
	public void setDeptseq(java.lang.String value) {
		this.deptseq = value;
	}
	
	public java.lang.String getDeptseq() {
		return this.deptseq;
	}
	public void setWupinxh(java.lang.String value) {
		this.wupinxh = value;
	}
	
	public java.lang.String getWupinxh() {
		return this.wupinxh;
	}
	public void setShougourq(java.lang.String value) {
		this.shougourq = value;
	}
	
	public java.lang.String getShougourq() {
		return this.shougourq;
	}

	public String toString() {
		return new ToStringBuilder(this)
			.append("Idcard",getIdcard())
			.append("Csrxm",getCsrxm())
			.append("Cpcode",getCpcode())
			.append("Npcode",getNpcode())
			.append("Npaddress",getNpaddress())
			.append("Wupinlb",getWupinlb())
			.append("Called",getCalled())
			.append("Wpzl",getWpzl())
			.append("Deptname",getDeptname())
			.append("Deptseq",getDeptseq())
			.append("Wupinxh",getWupinxh())
			.append("Shougourq",getShougourq())
			.toString();
	}
	
	public int hashCode() {
		return new HashCodeBuilder()
			.append(getIdcard())
			.append(getCsrxm())
			.append(getCpcode())
			.append(getNpcode())
			.append(getNpaddress())
			.append(getWupinlb())
			.append(getCalled())
			.append(getWpzl())
			.append(getDeptname())
			.append(getDeptseq())
			.append(getWupinxh())
			.append(getShougourq())
			.toHashCode();
	}
	
	public boolean equals(Object obj) {
		if(obj instanceof VcsrxxSta == false) return false;
		if(this == obj) return true;
		VcsrxxSta other = (VcsrxxSta)obj;
		return new EqualsBuilder()
			.append(getIdcard(),other.getIdcard())
			.append(getCsrxm(),other.getCsrxm())
			.append(getCpcode(),other.getCpcode())
			.append(getNpcode(),other.getNpcode())
			.append(getNpaddress(),other.getNpaddress())
			.append(getWupinlb(),other.getWupinlb())
			.append(getCalled(),other.getCalled())
			.append(getWpzl(),other.getWpzl())
			.append(getDeptname(),other.getDeptname())
			.append(getDeptseq(),other.getDeptseq())
			.append(getWupinxh(),other.getWupinxh())
			.append(getShougourq(),other.getShougourq())
			.isEquals();
	}
}

