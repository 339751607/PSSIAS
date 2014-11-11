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

import com.dyneinfo.zazh.model.*;
import com.dyneinfo.zazh.dao.*;
import com.dyneinfo.zazh.service.*;

/**
 * @author lisc email:lishicheng(a)gmail.com
 */


public class Sdcpupload extends BaseEntity {
	
	//alias
	public static final String TABLE_ALIAS = "企业上传统计";
	public static final String ALIAS_XH = "序号";
	public static final String ALIAS_CITYCODE = "代码";
	public static final String ALIAS_CITYNAME = "部门名称";
	public static final String ALIAS_SCJS = "上传数据家数";
	public static final String ALIAS_WSCJS = "未上传数据家数";
	public static final String ALIAS_SCL = "企业上传率";
	public static final String ALIAS_LXWSCJS = "N天未上传家数";
	public static final String ALIAS_TJRQ = "统计日期";
	public static final String ALIAS_SCSJL = "上传数据总数";
	public static final String ALIAS_WWSCJS = "未上传数据企业";
	
	//date formats
	
	//columns START
	private java.lang.Long xh;
	private java.lang.String citycode;
	private java.lang.String cityname;
	private java.lang.String scjs;
	private java.lang.String wscjs;
	private String scl;
	private java.lang.String lxwscjs;
	private java.lang.String tjrq;
	private java.lang.String scsjl;
	private java.lang.String deptseq;
	private java.lang.String deptname;
	//columns END

	public Sdcpupload(){
	}

	public Sdcpupload(
		java.lang.Long xh
	){
		this.xh = xh;
	}
	public void setDeptname(java.lang.String value){
		this.deptname = value;
	}
	public java.lang.String getDeptname(){
		return this.deptname;
	}
public void setDeptseq(java.lang.String value){
	this.deptseq = value;
}
public java.lang.String getDeptseq(){
	return this.deptseq;
}
	public void setXh(java.lang.Long value) {
		this.xh = value;
	}
	
	public java.lang.Long getXh() {
		return this.xh;
	}
	public void setCitycode(java.lang.String value) {
		this.citycode = value;
	}
	
	public java.lang.String getCitycode() {
		return this.citycode;
	}
	public void setCityname(java.lang.String value) {
		this.cityname = value;
	}
	
	public java.lang.String getCityname() {
		return this.cityname;
	}
	public void setScjs(java.lang.String value) {
		this.scjs = value;
	}
	
	public java.lang.String getScjs() {
		return this.scjs;
	}
	public void setWscjs(java.lang.String value) {
		this.wscjs = value;
	}
	
	public java.lang.String getWscjs() {
		return this.wscjs;
	}
	public void setScl(String value) {
		this.scl = value;
	}
	
	public String getScl() {
		return this.scl;
	}
	public void setLxwscjs(java.lang.String value) {
		this.lxwscjs = value;
	}
	
	public java.lang.String getLxwscjs() {
		return this.lxwscjs;
	}
	public void setTjrq(java.lang.String value) {
		this.tjrq = value;
	}
	
	public java.lang.String getTjrq() {
		return this.tjrq;
	}
	public void setScsjl(java.lang.String value) {
		this.scsjl = value;
	}
	
	public java.lang.String getScsjl() {
		return this.scsjl;
	}

	public String toString() {
		return new ToStringBuilder(this)
			.append("Xh",getXh())
			.append("Citycode",getCitycode())
			.append("Cityname",getCityname())
			.append("Scjs",getScjs())
			.append("Wscjs",getWscjs())
			.append("Scl",getScl())
			.append("Lxwscjs",getLxwscjs())
			.append("Tjrq",getTjrq())
			.append("Scsjl",getScsjl())
			.append("Deptseq",getDeptseq())
						.append("Deptname",getDeptname())
			.toString();
	}
	
	public int hashCode() {
		return new HashCodeBuilder()
			.append(getXh())
			.append(getCitycode())
			.append(getCityname())
			.append(getScjs())
			.append(getWscjs())
			.append(getScl())
			.append(getLxwscjs())
			.append(getTjrq())
			.append(getScsjl())
			.append(getDeptseq())
			.append(getDeptname())
			.toHashCode();
	}
	
	public boolean equals(Object obj) {
		if(obj instanceof Sdcpupload == false) return false;
		if(this == obj) return true;
		Sdcpupload other = (Sdcpupload)obj;
		return new EqualsBuilder()
			.append(getXh(),other.getXh())
			.append(getCitycode(),other.getCitycode())
			.append(getCityname(),other.getCityname())
			.append(getScjs(),other.getScjs())
			.append(getWscjs(),other.getWscjs())
			.append(getScl(),other.getScl())
			.append(getLxwscjs(),other.getLxwscjs())
			.append(getTjrq(),other.getTjrq())
			.append(getScsjl(),other.getScsjl())
			.append(getDeptseq(),other.getDeptseq())
			.append(getDeptname(),other.getDeptname())
			.isEquals();
	}
}

