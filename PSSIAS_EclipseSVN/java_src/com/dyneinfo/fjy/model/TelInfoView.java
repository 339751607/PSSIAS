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


public class TelInfoView extends BaseEntity {
	
	//alias
	public static final String ALIAS_DEPTNAME = "收购企业";
	public static final String ALIAS_FULLNAME = "经办人";
	
	public static final String TABLE_ALIAS = "二手手机";
	public static final String ALIAS_TELINFOID = "序号";
	public static final String ALIAS_TELPP = "手机品牌";
	public static final String ALIAS_TELXH = "手机型号";
	public static final String ALIAS_TELYS = "手机颜色";
	public static final String ALIAS_JXXLH = "手机串号(IMEI)";
	public static final String ALIAS_SJLB = "手机类别";
	public static final String ALIAS_BZ = "备注";
	public static final String ALIAS_CPCODE = "收购企业代码";
	public static final String ALIAS_CHUSHOURY = "出售人姓名";
	public static final String ALIAS_CHUSHOURENXB = "出售人性别";
	public static final String ALIAS_CHUSHOURENSFZH = "出售人身份证号";
	public static final String ALIAS_BEIZHU = "备注";
	public static final String ALIAS_CHUSHOURENLXDH = "出售人联系电话";
	public static final String ALIAS_SGSJ = "收购时间";
	public static final String ALIAS_DQSJH = "出售人当前手机号";
	public static final String ALIAS_CSRJTZZ = "出售人现住址";
	public static final String ALIAS_CSRDH = "出售人电话";
	public static final String ALIAS_GJSJ = "购机时间";
	public static final String ALIAS_JBR = "经办人ID";
	
	//date formats
	public static final String FORMAT_SGSJ = DATE_TIME_FORMAT;
	
	//columns START
	private java.lang.String telinfoid;
	private java.lang.String telpp;
	private java.lang.String telxh;
	private java.lang.String telys;
	private java.lang.String jxxlh;
	private java.lang.String sjlb;
	private java.lang.String bz;
	private java.lang.String cpcode;
	private java.lang.String chushoury;
	private java.lang.String chushourenxb;
	private java.lang.String chushourensfzh;
	private java.lang.String beizhu;
	private java.lang.String chushourenlxdh;
	private java.util.Date sgsj;
	private java.lang.String dqsjh;
	private java.lang.String csrjtzz;
	private java.lang.String csrdh;
	private java.lang.String gjsj;
	private java.lang.String jbr;
	private java.lang.String deptname;
	private java.lang.String fullname;
	
	//columns END

	public TelInfoView(){
	}

	public TelInfoView(
		java.lang.String telinfoid
	){
		this.telinfoid = telinfoid;
	}

	public void setTelinfoid(java.lang.String value) {
		this.telinfoid = value;
	}
	
	public java.lang.String getTelinfoid() {
		return this.telinfoid;
	}
	public void setTelpp(java.lang.String value) {
		this.telpp = value;
	}
	
	public java.lang.String getTelpp() {
		return this.telpp;
	}
	public void setTelxh(java.lang.String value) {
		this.telxh = value;
	}
	
	public java.lang.String getTelxh() {
		return this.telxh;
	}
	public void setTelys(java.lang.String value) {
		this.telys = value;
	}
	
	public java.lang.String getTelys() {
		return this.telys;
	}
	public void setJxxlh(java.lang.String value) {
		this.jxxlh = value;
	}
	
	public java.lang.String getJxxlh() {
		return this.jxxlh;
	}
	public void setSjlb(java.lang.String value) {
		this.sjlb = value;
	}
	
	public java.lang.String getSjlb() {
		return this.sjlb;
	}
	public void setBz(java.lang.String value) {
		this.bz = value;
	}
	
	public java.lang.String getBz() {
		return this.bz;
	}
	public void setCpcode(java.lang.String value) {
		this.cpcode = value;
	}
	
	public java.lang.String getCpcode() {
		return this.cpcode;
	}
	public void setChushoury(java.lang.String value) {
		this.chushoury = value;
	}
	
	public java.lang.String getChushoury() {
		return this.chushoury;
	}
	public void setChushourenxb(java.lang.String value) {
		this.chushourenxb = value;
	}
	
	public java.lang.String getChushourenxb() {
		return this.chushourenxb;
	}
	public void setChushourensfzh(java.lang.String value) {
		this.chushourensfzh = value;
	}
	
	public java.lang.String getChushourensfzh() {
		return this.chushourensfzh;
	}
	public void setBeizhu(java.lang.String value) {
		this.beizhu = value;
	}
	
	public java.lang.String getBeizhu() {
		return this.beizhu;
	}
	public void setChushourenlxdh(java.lang.String value) {
		this.chushourenlxdh = value;
	}
	
	public java.lang.String getChushourenlxdh() {
		return this.chushourenlxdh;
	}
	public String getSgsjString() {
		return date2String(getSgsj(), FORMAT_SGSJ);
	}
	public void setSgsjString(String value) {
		setSgsj(string2Date(value, FORMAT_SGSJ,java.util.Date.class));
	}
	
	public void setSgsj(java.util.Date value) {
		this.sgsj = value;
	}
	
	public java.util.Date getSgsj() {
		return this.sgsj;
	}
	public void setDqsjh(java.lang.String value) {
		this.dqsjh = value;
	}
	
	public java.lang.String getDqsjh() {
		return this.dqsjh;
	}
	public void setCsrjtzz(java.lang.String value) {
		this.csrjtzz = value;
	}
	
	public java.lang.String getCsrjtzz() {
		return this.csrjtzz;
	}
	public void setCsrdh(java.lang.String value) {
		this.csrdh = value;
	}
	
	public java.lang.String getCsrdh() {
		return this.csrdh;
	}
	public void setGjsj(java.lang.String value) {
		this.gjsj = value;
	}
	
	public java.lang.String getGjsj() {
		return this.gjsj;
	}
	public void setJbr(java.lang.String value) {
		this.jbr = value;
	}
	
	public java.lang.String getJbr() {
		return this.jbr;
	}
	public void setDeptname(java.lang.String value) {
		this.deptname = value;
	}
	
	public java.lang.String getDeptname() {
		return this.deptname;
	}
	public void setFullname(java.lang.String value) {
		this.fullname = value;
	}
	
	public java.lang.String getFullname() {
		return this.fullname;
	}

	public String toString() {
		return new ToStringBuilder(this)
			.append("Telinfoid",getTelinfoid())
			.append("Telpp",getTelpp())
			.append("Telxh",getTelxh())
			.append("Telys",getTelys())
			.append("Jxxlh",getJxxlh())
			.append("Sjlb",getSjlb())
			.append("Bz",getBz())
			.append("Cpcode",getCpcode())
			.append("Chushoury",getChushoury())
			.append("Chushourenxb",getChushourenxb())
			.append("Chushourensfzh",getChushourensfzh())
			.append("Beizhu",getBeizhu())
			.append("Chushourenlxdh",getChushourenlxdh())
			.append("Sgsj",getSgsj())
			.append("Dqsjh",getDqsjh())
			.append("Csrjtzz",getCsrjtzz())
			.append("Csrdh",getCsrdh())
			.append("Gjsj",getGjsj())
			.append("Jbr",getJbr())
			.append("Deptname",getDeptname())
			.append("Fullname",getFullname())
			.toString();
	}
	
	public int hashCode() {
		return new HashCodeBuilder()
			.append(getTelinfoid())
			.append(getTelpp())
			.append(getTelxh())
			.append(getTelys())
			.append(getJxxlh())
			.append(getSjlb())
			.append(getBz())
			.append(getCpcode())
			.append(getChushoury())
			.append(getChushourenxb())
			.append(getChushourensfzh())
			.append(getBeizhu())
			.append(getChushourenlxdh())
			.append(getSgsj())
			.append(getDqsjh())
			.append(getCsrjtzz())
			.append(getCsrdh())
			.append(getGjsj())
			.append(getJbr())
			.append(getDeptname())
			.append(getFullname())
			.toHashCode();
	}
	
	public boolean equals(Object obj) {
		if(obj instanceof TelInfoView == false) return false;
		if(this == obj) return true;
		TelInfoView other = (TelInfoView)obj;
		return new EqualsBuilder()
			.append(getTelinfoid(),other.getTelinfoid())
			.append(getTelpp(),other.getTelpp())
			.append(getTelxh(),other.getTelxh())
			.append(getTelys(),other.getTelys())
			.append(getJxxlh(),other.getJxxlh())
			.append(getSjlb(),other.getSjlb())
			.append(getBz(),other.getBz())
			.append(getCpcode(),other.getCpcode())
			.append(getChushoury(),other.getChushoury())
			.append(getChushourenxb(),other.getChushourenxb())
			.append(getChushourensfzh(),other.getChushourensfzh())
			.append(getBeizhu(),other.getBeizhu())
			.append(getChushourenlxdh(),other.getChushourenlxdh())
			.append(getSgsj(),other.getSgsj())
			.append(getDqsjh(),other.getDqsjh())
			.append(getCsrjtzz(),other.getCsrjtzz())
			.append(getCsrdh(),other.getCsrdh())
			.append(getGjsj(),other.getGjsj())
			.append(getJbr(),other.getJbr())
			.append(getDeptname(),other.getDeptname())
			.append(getFullname(),other.getFullname())
			.isEquals();
	}
}

