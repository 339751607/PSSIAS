/*
 * Powered By [lishicheng]
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
 * @author lisc email:lishicheng(a)gmail.com
 */


public class TalarmCar extends BaseEntity {
	
	//alias
	public static final String TABLE_ALIAS = "车辆报警表";
	public static final String ALIAS_ID = "报警流水号";
	public static final String ALIAS_BKID = "布控ID";
	public static final String ALIAS_BKTYPE = "布控类型";
	public static final String ALIAS_SID = "在行业子系统业务表中的ID";
	public static final String ALIAS_ALARMTIME = "报警时间";
	public static final String ALIAS_ALARMSOURCE = "报警来源";
	public static final String ALIAS_ALARMTYPE = "报警类型";
	public static final String ALIAS_BUSINESSTYPE = "业务类型";
	public static final String ALIAS_BUSINESSTIME = "业务发生时间";
	public static final String ALIAS_CPCODE = "企业代码";
	public static final String ALIAS_CAROWNER = "车主";
	public static final String ALIAS_CARTYPE = "车辆类型";
	public static final String ALIAS_BRAND = "车辆品牌";
	public static final String ALIAS_CARMODE = "车辆型号";
	public static final String ALIAS_COLOR = "车身颜色";
	public static final String ALIAS_CARID = "车牌号";
	public static final String ALIAS_ENGINECODE = "发动机号";
	public static final String ALIAS_BODYCODE = "车架号";
	public static final String ALIAS_CLFLAG = "处警标志";
	public static final String ALIAS_CJDW = "处警单位";
	public static final String ALIAS_CJR = "处警人";
	public static final String ALIAS_CJSJ = "处警时间";
	public static final String ALIAS_VALIDFLAG = "报警是否有效";
	public static final String ALIAS_VOIDCAUSE = "无效原因";
	public static final String ALIAS_ZHFLAG = "抓获情况";
	public static final String ALIAS_ZHDW = "抓获单位";
	public static final String ALIAS_ZHSJ = "抓获时间";
	public static final String ALIAS_WZHYY = "未抓获原因";
	public static final String ALIAS_CLQK = "处理情况";
	
	//date formats
	
	//columns START
	private Long id;
	private java.lang.String bkid;
	private java.lang.String bktype;
	private java.lang.String sid;
	private java.lang.String alarmtime;
	private java.lang.String alarmsource;
	private java.lang.String alarmtype;
	private java.lang.String businesstype;
	private java.lang.String businesstime;
	private java.lang.String cpcode;
	private java.lang.String carowner;
	private java.lang.String cartype;
	private java.lang.String brand;
	private java.lang.String carmode;
	private java.lang.String color;
	private java.lang.String carid;
	private java.lang.String enginecode;
	private java.lang.String bodycode;
	private java.lang.String clflag;
	private java.lang.String cjdw;
	private java.lang.String cjr;
	private java.lang.String cjsj;
	private java.lang.String validflag;
	private java.lang.String voidcause;
	private java.lang.String zhflag;
	private java.lang.String zhdw;
	private java.lang.String zhsj;
	private java.lang.String wzhyy;
	private java.lang.String clqk;
	private java.lang.String cpname;
	private java.lang.String deptname;
	//columns END

	public TalarmCar(){
	}

	public TalarmCar(
		Long id
	){
		this.id = id;
	}

	public void setId(Long value) {
		this.id = value;
	}
	
	public Long getId() {
		return this.id;
	}
	public void setBkid(java.lang.String value) {
		this.bkid = value;
	}
	
	public java.lang.String getBkid() {
		return this.bkid;
	}
	public void setBktype(java.lang.String value) {
		this.bktype = value;
	}
	
	public java.lang.String getBktype() {
		return this.bktype;
	}
	public void setSid(java.lang.String value) {
		this.sid = value;
	}
	
	public java.lang.String getSid() {
		return this.sid;
	}
	public void setAlarmtime(java.lang.String value) {
		this.alarmtime = value;
	}
	
	public java.lang.String getAlarmtime() {
		return this.alarmtime;
	}
	public void setAlarmsource(java.lang.String value) {
		this.alarmsource = value;
	}
	
	public java.lang.String getAlarmsource() {
		return this.alarmsource;
	}
	public void setAlarmtype(java.lang.String value) {
		this.alarmtype = value;
	}
	
	public java.lang.String getAlarmtype() {
		return this.alarmtype;
	}
	public void setBusinesstype(java.lang.String value) {
		this.businesstype = value;
	}
	
	public java.lang.String getBusinesstype() {
		return this.businesstype;
	}
	public void setBusinesstime(java.lang.String value) {
		this.businesstime = value;
	}
	
	public java.lang.String getBusinesstime() {
		return this.businesstime;
	}
	public void setCpcode(java.lang.String value) {
		this.cpcode = value;
	}
	
	public java.lang.String getCpcode() {
		return this.cpcode;
	}
	public void setCarowner(java.lang.String value) {
		this.carowner = value;
	}
	
	public java.lang.String getCarowner() {
		return this.carowner;
	}
	public void setCartype(java.lang.String value) {
		this.cartype = value;
	}
	
	public java.lang.String getCartype() {
		return this.cartype;
	}
	public void setBrand(java.lang.String value) {
		this.brand = value;
	}
	
	public java.lang.String getBrand() {
		return this.brand;
	}
	public void setCarmode(java.lang.String value) {
		this.carmode = value;
	}
	
	public java.lang.String getCarmode() {
		return this.carmode;
	}
	public void setColor(java.lang.String value) {
		this.color = value;
	}
	
	public java.lang.String getColor() {
		return this.color;
	}
	public void setCarid(java.lang.String value) {
		this.carid = value;
	}
	
	public java.lang.String getCarid() {
		return this.carid;
	}
	public void setEnginecode(java.lang.String value) {
		this.enginecode = value;
	}
	
	public java.lang.String getEnginecode() {
		return this.enginecode;
	}
	public void setBodycode(java.lang.String value) {
		this.bodycode = value;
	}
	
	public java.lang.String getBodycode() {
		return this.bodycode;
	}
	public void setClflag(java.lang.String value) {
		this.clflag = value;
	}
	
	public java.lang.String getClflag() {
		return this.clflag;
	}
	public void setCjdw(java.lang.String value) {
		this.cjdw = value;
	}
	
	public java.lang.String getCjdw() {
		return this.cjdw;
	}
	public void setCjr(java.lang.String value) {
		this.cjr = value;
	}
	
	public java.lang.String getCjr() {
		return this.cjr;
	}
	public void setCjsj(java.lang.String value) {
		this.cjsj = value;
	}
	
	public java.lang.String getCjsj() {
		return this.cjsj;
	}
	public void setValidflag(java.lang.String value) {
		this.validflag = value;
	}
	
	public java.lang.String getValidflag() {
		return this.validflag;
	}
	public void setVoidcause(java.lang.String value) {
		this.voidcause = value;
	}
	
	public java.lang.String getVoidcause() {
		return this.voidcause;
	}
	public void setZhflag(java.lang.String value) {
		this.zhflag = value;
	}
	
	public java.lang.String getZhflag() {
		return this.zhflag;
	}
	public void setZhdw(java.lang.String value) {
		this.zhdw = value;
	}
	
	public java.lang.String getZhdw() {
		return this.zhdw;
	}
	public void setZhsj(java.lang.String value) {
		this.zhsj = value;
	}
	
	public java.lang.String getZhsj() {
		return this.zhsj;
	}
	public void setWzhyy(java.lang.String value) {
		this.wzhyy = value;
	}
	
	public java.lang.String getWzhyy() {
		return this.wzhyy;
	}
	public void setClqk(java.lang.String value) {
		this.clqk = value;
	}
	
	public java.lang.String getClqk() {
		return this.clqk;
	}

	public String toString() {
		return new ToStringBuilder(this)
			.append("Id",getId())
			.append("Bkid",getBkid())
			.append("Bktype",getBktype())
			.append("Sid",getSid())
			.append("Alarmtime",getAlarmtime())
			.append("Alarmsource",getAlarmsource())
			.append("Alarmtype",getAlarmtype())
			.append("Businesstype",getBusinesstype())
			.append("Businesstime",getBusinesstime())
			.append("Cpcode",getCpcode())
			.append("Carowner",getCarowner())
			.append("Cartype",getCartype())
			.append("Brand",getBrand())
			.append("Carmode",getCarmode())
			.append("Color",getColor())
			.append("Carid",getCarid())
			.append("Enginecode",getEnginecode())
			.append("Bodycode",getBodycode())
			.append("Clflag",getClflag())
			.append("Cjdw",getCjdw())
			.append("Cjr",getCjr())
			.append("Cjsj",getCjsj())
			.append("Validflag",getValidflag())
			.append("Voidcause",getVoidcause())
			.append("Zhflag",getZhflag())
			.append("Zhdw",getZhdw())
			.append("Zhsj",getZhsj())
			.append("Wzhyy",getWzhyy())
			.append("Clqk",getClqk())
			.toString();
	}
	
	public int hashCode() {
		return new HashCodeBuilder()
			.append(getId())
			.append(getBkid())
			.append(getBktype())
			.append(getSid())
			.append(getAlarmtime())
			.append(getAlarmsource())
			.append(getAlarmtype())
			.append(getBusinesstype())
			.append(getBusinesstime())
			.append(getCpcode())
			.append(getCarowner())
			.append(getCartype())
			.append(getBrand())
			.append(getCarmode())
			.append(getColor())
			.append(getCarid())
			.append(getEnginecode())
			.append(getBodycode())
			.append(getClflag())
			.append(getCjdw())
			.append(getCjr())
			.append(getCjsj())
			.append(getValidflag())
			.append(getVoidcause())
			.append(getZhflag())
			.append(getZhdw())
			.append(getZhsj())
			.append(getWzhyy())
			.append(getClqk())
			.toHashCode();
	}
	
	public boolean equals(Object obj) {
		if(obj instanceof TalarmCar == false) return false;
		if(this == obj) return true;
		TalarmCar other = (TalarmCar)obj;
		return new EqualsBuilder()
			.append(getId(),other.getId())
			.append(getBkid(),other.getBkid())
			.append(getBktype(),other.getBktype())
			.append(getSid(),other.getSid())
			.append(getAlarmtime(),other.getAlarmtime())
			.append(getAlarmsource(),other.getAlarmsource())
			.append(getAlarmtype(),other.getAlarmtype())
			.append(getBusinesstype(),other.getBusinesstype())
			.append(getBusinesstime(),other.getBusinesstime())
			.append(getCpcode(),other.getCpcode())
			.append(getCarowner(),other.getCarowner())
			.append(getCartype(),other.getCartype())
			.append(getBrand(),other.getBrand())
			.append(getCarmode(),other.getCarmode())
			.append(getColor(),other.getColor())
			.append(getCarid(),other.getCarid())
			.append(getEnginecode(),other.getEnginecode())
			.append(getBodycode(),other.getBodycode())
			.append(getClflag(),other.getClflag())
			.append(getCjdw(),other.getCjdw())
			.append(getCjr(),other.getCjr())
			.append(getCjsj(),other.getCjsj())
			.append(getValidflag(),other.getValidflag())
			.append(getVoidcause(),other.getVoidcause())
			.append(getZhflag(),other.getZhflag())
			.append(getZhdw(),other.getZhdw())
			.append(getZhsj(),other.getZhsj())
			.append(getWzhyy(),other.getWzhyy())
			.append(getClqk(),other.getClqk())
			.isEquals();
	}

	public java.lang.String getCpname() {
		return cpname;
	}

	public void setCpname(java.lang.String cpname) {
		this.cpname = cpname;
	}

	public java.lang.String getDeptname() {
		return deptname;
	}

	public void setDeptname(java.lang.String deptname) {
		this.deptname = deptname;
	}
}

