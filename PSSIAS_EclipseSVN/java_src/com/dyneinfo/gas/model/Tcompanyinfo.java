/*
 * Powered By [lishicheng]
 */

package com.dyneinfo.gas.model;

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

import com.dyneinfo.gas.model.*;
import com.dyneinfo.gas.dao.*;
import com.dyneinfo.gas.service.*;

/**
 * @author lisc email:lishicheng(a)gmail.com
 */


public class Tcompanyinfo extends BaseEntity {
	
	//alias
	public static final String TABLE_ALIAS = "企业";
	public static final String ALIAS_CPCODE = "企业代码";
	public static final String ALIAS_CPNAME = "企业名称";
	public static final String ALIAS_LEGA_LNAME = "法人姓名";
	public static final String ALIAS_LEGAL_CARD = "身份证号";
	public static final String ALIAS_PHONE = "联系电话";
	public static final String ALIAS_ADDRESS = "企业地址";
	public static final String ALIAS_STATUS = "经营状态";
	public static final String ALIAS_MOD_TIME = "状态改变日期";
	public static final String ALIAS_GASOLINE_TYPE = "经营油品类型";
	public static final String ALIAS_CPTYPE = "企业性质";
	public static final String ALIAS_MACHINE = "加油机数量";
	public static final String ALIAS_MONITOR = "监控数量";
	public static final String ALIAS_BURCODE = "所属分局";
	public static final String ALIAS_STACODE = "所属派出所";
	public static final String ALIAS_SERVICEDATE = "到期日期密文";
	public static final String ALIAS_SERVICEDATEVIEW = "到期日期";
	public static final String ALIAS_EXITEND1 = "扩展1";
	public static final String ALIAS_EXITEND2 = "扩展2";
	public static final String ALIAS_EXITEND3 = "扩展3";
	
	//date formats
	
	//columns START
	private java.lang.String cpcode;
	private java.lang.String cpname;
	private java.lang.String legaLname;
	private java.lang.String legalCard;
	private java.lang.String phone;
	private java.lang.String address;
	private java.lang.String status;
	private java.lang.String modTime;
	private java.lang.String gasolineType;
	private java.lang.String cptype;
	private Long machine;
	private Long monitor;
	private java.lang.String burcode;
	private java.lang.String stacode;
	private java.lang.String exitend1;
	private java.lang.String exitend2;
	private java.lang.String exitend3;
	private java.lang.String polityvisage;
	private java.lang.String nativeplace;
	private java.sql.Date servicedateview;
	private java.lang.String servicedate;
	
	//columns END

	public Tcompanyinfo(){
	}

	public Tcompanyinfo(
		java.lang.String cpcode
	){
		this.cpcode = cpcode;
	}

	public void setCpcode(java.lang.String value) {
		this.cpcode = value;
	}
	
	public java.lang.String getCpcode() {
		return this.cpcode;
	}
	public void setCpname(java.lang.String value) {
		this.cpname = value;
	}
	
	public java.lang.String getCpname() {
		return this.cpname;
	}
	public void setLegaLname(java.lang.String value) {
		this.legaLname = value;
	}
	
	public java.lang.String getLegaLname() {
		return this.legaLname;
	}
	public void setLegalCard(java.lang.String value) {
		this.legalCard = value;
	}
	
	public java.lang.String getLegalCard() {
		return this.legalCard;
	}
	public void setPhone(java.lang.String value) {
		this.phone = value;
	}
	
	public java.lang.String getPhone() {
		return this.phone;
	}
	public void setAddress(java.lang.String value) {
		this.address = value;
	}
	
	public java.lang.String getAddress() {
		return this.address;
	}
	public void setStatus(java.lang.String value) {
		this.status = value;
	}
	
	public java.lang.String getStatus() {
		return this.status;
	}
	public void setModTime(java.lang.String value) {
		this.modTime = value;
	}
	
	public java.lang.String getModTime() {
		return this.modTime;
	}
	public void setGasolineType(java.lang.String value) {
		this.gasolineType = value;
	}
	
	public java.lang.String getGasolineType() {
		return this.gasolineType;
	}
	public void setCptype(java.lang.String value) {
		this.cptype = value;
	}
	
	public java.lang.String getCptype() {
		return this.cptype;
	}
	public void setMachine(Long value) {
		this.machine = value;
	}
	
	public Long getMachine() {
		return this.machine;
	}
	public void setMonitor(Long value) {
		this.monitor = value;
	}
	
	public Long getMonitor() {
		return this.monitor;
	}
	public void setBurcode(java.lang.String value) {
		this.burcode = value;
	}
	
	public java.lang.String getBurcode() {
		return this.burcode;
	}
	public void setStacode(java.lang.String value) {
		this.stacode = value;
	}
	
	public java.lang.String getStacode() {
		return this.stacode;
	}
	public void setExitend1(java.lang.String value) {
		this.exitend1 = value;
	}
	
	public java.lang.String getExitend1() {
		return this.exitend1;
	}
	public void setExitend2(java.lang.String value) {
		this.exitend2 = value;
	}
	
	public java.lang.String getExitend2() {
		return this.exitend2;
	}
	public void setExitend3(java.lang.String value) {
		this.exitend3 = value;
	}
	
	public java.lang.String getExitend3() {
		return this.exitend3;
	}

	public String toString() {
		return new ToStringBuilder(this)
			.append("Cpcode",getCpcode())
			.append("Cpname",getCpname())
			.append("LegaLname",getLegaLname())
			.append("LegalCard",getLegalCard())
			.append("Phone",getPhone())
			.append("Address",getAddress())
			.append("Status",getStatus())
			.append("ModTime",getModTime())
			.append("GasolineType",getGasolineType())
			.append("Cptype",getCptype())
			.append("Machine",getMachine())
			.append("Monitor",getMonitor())
			.append("Burcode",getBurcode())
			.append("Stacode",getStacode())
			.append("Servicedate",getServicedateview())
			.append("Servicedate",getServicedate())
			.append("Exitend1",getExitend1())
			.append("Exitend2",getExitend2())
			.append("Exitend3",getExitend3())
			.toString();
	}
	
	public int hashCode() {
		return new HashCodeBuilder()
			.append(getCpcode())
			.append(getCpname())
			.append(getLegaLname())
			.append(getLegalCard())
			.append(getPhone())
			.append(getAddress())
			.append(getStatus())
			.append(getModTime())
			.append(getGasolineType())
			.append(getCptype())
			.append(getMachine())
			.append(getMonitor())
			.append(getBurcode())
			.append(getStacode())
			.append(getServicedateview())
			.append(getServicedate())
			.append(getExitend1())
			.append(getExitend2())
			.append(getExitend3())
			.toHashCode();
	}
	
	public boolean equals(Object obj) {
		if(obj instanceof Tcompanyinfo == false) return false;
		if(this == obj) return true;
		Tcompanyinfo other = (Tcompanyinfo)obj;
		return new EqualsBuilder()
			.append(getCpcode(),other.getCpcode())
			.append(getCpname(),other.getCpname())
			.append(getLegaLname(),other.getLegaLname())
			.append(getLegalCard(),other.getLegalCard())
			.append(getPhone(),other.getPhone())
			.append(getAddress(),other.getAddress())
			.append(getStatus(),other.getStatus())
			.append(getModTime(),other.getModTime())
			.append(getGasolineType(),other.getGasolineType())
			.append(getCptype(),other.getCptype())
			.append(getMachine(),other.getMachine())
			.append(getMonitor(),other.getMonitor())
			.append(getBurcode(),other.getBurcode())
			.append(getStacode(),other.getStacode())
			.append(getServicedateview(),other.getServicedateview())
			.append(getServicedate(),other.getServicedate())
			.append(getExitend1(),other.getExitend1())
			.append(getExitend2(),other.getExitend2())
			.append(getExitend3(),other.getExitend3())
			.isEquals();
	}

	public java.lang.String getPolityvisage() {
		return polityvisage;
	}

	public void setPolityvisage(java.lang.String polityvisage) {
		this.polityvisage = polityvisage;
	}

	public java.lang.String getNativeplace() {
		return nativeplace;
	}

	public void setNativeplace(java.lang.String nativeplace) {
		this.nativeplace = nativeplace;
	}


	public java.lang.String getServicedate() {
		return servicedate;
	}

	public void setServicedate(java.lang.String servicedate) {
		this.servicedate = servicedate;
	}

	public void setServicedateview(java.sql.Date servicedateview) {
		this.servicedateview = servicedateview;
	}

	public java.sql.Date getServicedateview() {
		return servicedateview;
	}
}

