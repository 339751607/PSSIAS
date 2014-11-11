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


public class Talarmtel extends BaseEntity {
	
	//alias
	public static final String TABLE_ALIAS = "接警电话配置";
	public static final String ALIAS_DEPTCODE = "接警单位代码";
	public static final String ALIAS_DEPTNAME = "接警单位名称";
	public static final String ALIAS_ALARMALL = "是否接收所有报警信息";
	public static final String ALIAS_ALARMTEL = "接警电话";
	public static final String ALIAS_EXITEND1 = "扩展1";
	public static final String ALIAS_EXITEND2 = "扩展2";
	public static final String ALIAS_EXITEND3 = "扩展3";
	
	//date formats
	
	//columns START
	private java.lang.String deptcode;
	private java.lang.String deptname;
	private java.lang.String alarmall;
	private java.lang.String alarmtel;
	private java.lang.String exitend1;
	private java.lang.String exitend2;
	private java.lang.String exitend3;
	//columns END

	public Talarmtel(){
	}

	public Talarmtel(
		java.lang.String deptcode
	){
		this.deptcode = deptcode;
	}

	public void setDeptcode(java.lang.String value) {
		this.deptcode = value;
	}
	
	public java.lang.String getDeptcode() {
		return this.deptcode;
	}
	public void setDeptname(java.lang.String value) {
		this.deptname = value;
	}
	
	public java.lang.String getDeptname() {
		return this.deptname;
	}
	public void setAlarmall(java.lang.String value) {
		this.alarmall = value;
	}
	
	public java.lang.String getAlarmall() {
		return this.alarmall;
	}
	public void setAlarmtel(java.lang.String value) {
		this.alarmtel = value;
	}
	
	public java.lang.String getAlarmtel() {
		return this.alarmtel;
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
			.append("Deptcode",getDeptcode())
			.append("Deptname",getDeptname())
			.append("Alarmall",getAlarmall())
			.append("Alarmtel",getAlarmtel())
			.append("Exitend1",getExitend1())
			.append("Exitend2",getExitend2())
			.append("Exitend3",getExitend3())
			.toString();
	}
	
	public int hashCode() {
		return new HashCodeBuilder()
			.append(getDeptcode())
			.append(getDeptname())
			.append(getAlarmall())
			.append(getAlarmtel())
			.append(getExitend1())
			.append(getExitend2())
			.append(getExitend3())
			.toHashCode();
	}
	
	public boolean equals(Object obj) {
		if(obj instanceof Talarmtel == false) return false;
		if(this == obj) return true;
		Talarmtel other = (Talarmtel)obj;
		return new EqualsBuilder()
			.append(getDeptcode(),other.getDeptcode())
			.append(getDeptname(),other.getDeptname())
			.append(getAlarmall(),other.getAlarmall())
			.append(getAlarmtel(),other.getAlarmtel())
			.append(getExitend1(),other.getExitend1())
			.append(getExitend2(),other.getExitend2())
			.append(getExitend3(),other.getExitend3())
			.isEquals();
	}
}

