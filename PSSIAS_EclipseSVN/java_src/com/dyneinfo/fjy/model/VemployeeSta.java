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


public class VemployeeSta extends BaseEntity {
	
	//alias
	public static final String TABLE_ALIAS = "从业人员统计";
	public static final String ALIAS_DEPTID = "deptid";
	public static final String ALIAS_DEPTNAME = "名称";
	public static final String ALIAS_DEPTSEQ = "deptseq";
	public static final String ALIAS_DEPTLEVEL = "deptlevel";
	public static final String ALIAS_STATUS = "status";
	public static final String ALIAS_ONEZL = "在职";
	public static final String ALIAS_TWOZL = "离职";
	public static final String ALIAS_THREEZL = "休假";
	public static final String ALIAS_FOURZL = "出差";
	public static final String ALIAS_NINEZL = "其他";
	public static final String ALIAS_SUMZL = "总人数";
	
	//date formats
	
	//columns START
	private Long deptid;
	private java.lang.String deptname;
	private java.lang.String deptseq;
	private Long deptlevel;
	private java.lang.String status;
	private Long onezl;
	private Long twozl;
	private Long threezl;
	private Long fourzl;
	private Long ninezl;
	private Long sumzl;
	//columns END

	public VemployeeSta(){
	}

	public VemployeeSta(
		Long deptid
	){
		this.deptid = deptid;
	}

	public void setDeptid(Long value) {
		this.deptid = value;
	}
	
	public Long getDeptid() {
		return this.deptid;
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
	public void setDeptlevel(Long value) {
		this.deptlevel = value;
	}
	
	public Long getDeptlevel() {
		return this.deptlevel;
	}
	public void setStatus(java.lang.String value) {
		this.status = value;
	}
	
	public java.lang.String getStatus() {
		return this.status;
	}
	public void setOnezl(Long value) {
		this.onezl = value;
	}
	
	public Long getOnezl() {
		return this.onezl;
	}
	public void setTwozl(Long value) {
		this.twozl = value;
	}
	
	public Long getTwozl() {
		return this.twozl;
	}
	public void setThreezl(Long value) {
		this.threezl = value;
	}
	
	public Long getThreezl() {
		return this.threezl;
	}
	public void setFourzl(Long value) {
		this.fourzl = value;
	}
	
	public Long getFourzl() {
		return this.fourzl;
	}
	public void setNinezl(Long value) {
		this.ninezl = value;
	}
	
	public Long getNinezl() {
		return this.ninezl;
	}
	public void setSumzl(Long value) {
		this.sumzl = value;
	}
	
	public Long getSumzl() {
		return this.sumzl;
	}

	public String toString() {
		return new ToStringBuilder(this)
			.append("Deptid",getDeptid())
			.append("Deptname",getDeptname())
			.append("Deptseq",getDeptseq())
			.append("Deptlevel",getDeptlevel())
			.append("Status",getStatus())
			.append("Onezl",getOnezl())
			.append("Twozl",getTwozl())
			.append("Threezl",getThreezl())
			.append("Fourzl",getFourzl())
			.append("Ninezl",getNinezl())
			.append("Sumzl",getSumzl())
			.toString();
	}
	
	public int hashCode() {
		return new HashCodeBuilder()
			.append(getDeptid())
			.append(getDeptname())
			.append(getDeptseq())
			.append(getDeptlevel())
			.append(getStatus())
			.append(getOnezl())
			.append(getTwozl())
			.append(getThreezl())
			.append(getFourzl())
			.append(getNinezl())
			.append(getSumzl())
			.toHashCode();
	}
	
	public boolean equals(Object obj) {
		if(obj instanceof VemployeeSta == false) return false;
		if(this == obj) return true;
		VemployeeSta other = (VemployeeSta)obj;
		return new EqualsBuilder()
			.append(getDeptid(),other.getDeptid())
			.append(getDeptname(),other.getDeptname())
			.append(getDeptseq(),other.getDeptseq())
			.append(getDeptlevel(),other.getDeptlevel())
			.append(getStatus(),other.getStatus())
			.append(getOnezl(),other.getOnezl())
			.append(getTwozl(),other.getTwozl())
			.append(getThreezl(),other.getThreezl())
			.append(getFourzl(),other.getFourzl())
			.append(getNinezl(),other.getNinezl())
			.append(getSumzl(),other.getSumzl())
			.isEquals();
	}
}

