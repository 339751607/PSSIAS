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


public class VfeijiuwupinSta extends BaseEntity {
	
	//alias
	public static final String TABLE_ALIAS = "回收物品统计";
	public static final String ALIAS_DEPTID = "deptid";
	public static final String ALIAS_DEPTNAME = "deptname";
	public static final String ALIAS_DEPTSEQ = "deptseq";
	public static final String ALIAS_DEPTLEVEL = "deptlevel";
	public static final String ALIAS_STATUS = "status";
	public static final String ALIAS_NUM = "num";
	public static final String ALIAS_ONEZL = "onezl";
	public static final String ALIAS_TWOZL = "twozl";
	public static final String ALIAS_THREEZL = "threezl";
	public static final String ALIAS_FOURZL = "fourzl";
	public static final String ALIAS_SUMZL = "sumzl";
	
	//date formats
	
	//columns START
	private Long deptid;
	private java.lang.String deptname;
	private java.lang.String deptseq;
	private Long deptlevel;
	private java.lang.String status;
	private Long num;
	private Long onezl;
	private Long twozl;
	private Long threezl;
	private Long fourzl;
	private Long sumzl;
	//columns END

	public VfeijiuwupinSta(){
	}

	public VfeijiuwupinSta(
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
	public void setNum(Long value) {
		this.num = value;
	}
	
	public Long getNum() {
		return this.num;
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
			.append("Num",getNum())
			.append("Onezl",getOnezl())
			.append("Twozl",getTwozl())
			.append("Threezl",getThreezl())
			.append("Fourzl",getFourzl())
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
			.append(getNum())
			.append(getOnezl())
			.append(getTwozl())
			.append(getThreezl())
			.append(getFourzl())
			.append(getSumzl())
			.toHashCode();
	}
	
	public boolean equals(Object obj) {
		if(obj instanceof VfeijiuwupinSta == false) return false;
		if(this == obj) return true;
		VfeijiuwupinSta other = (VfeijiuwupinSta)obj;
		return new EqualsBuilder()
			.append(getDeptid(),other.getDeptid())
			.append(getDeptname(),other.getDeptname())
			.append(getDeptseq(),other.getDeptseq())
			.append(getDeptlevel(),other.getDeptlevel())
			.append(getStatus(),other.getStatus())
			.append(getNum(),other.getNum())
			.append(getOnezl(),other.getOnezl())
			.append(getTwozl(),other.getTwozl())
			.append(getThreezl(),other.getThreezl())
			.append(getFourzl(),other.getFourzl())
			.append(getSumzl(),other.getSumzl())
			.isEquals();
	}
}

