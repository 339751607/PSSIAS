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


public class Tesdd extends BaseEntity {
	
	//alias
	public static final String TABLE_ALIAS = "二手电脑基本信息";
	public static final String ALIAS_DNID = "序号";
	public static final String ALIAS_DDLX = "机器类型";
	public static final String ALIAS_DNPP = "品牌";
	public static final String ALIAS_DNXH = "型号";
	public static final String ALIAS_ZBH = "主板号";
	public static final String ALIAS_YPH = "硬盘CT号";
	public static final String ALIAS_ZC = "内存";
	public static final String ALIAS_CPCODE = "收购企业代码";
	public static final String ALIAS_CHUSHOURY = "出售人姓名";
	public static final String ALIAS_CHUSHOURENXB = "出售人性别";
	public static final String ALIAS_CHUSHOURENSFZH = "出售人身份证号";
	public static final String ALIAS_BEIZHU = "备注";
	public static final String ALIAS_CHUSHOURENLXDH = "出售人联系电话";
	public static final String ALIAS_MACDZ = "网卡MAC地址";
	public static final String ALIAS_SGSJ = "收购时间";
	public static final String ALIAS_DQSJH = "出售人手机号";
	public static final String ALIAS_CSRJTZZ = "出售人现住址";
	public static final String ALIAS_CSRDH = "出售人电话";
	public static final String ALIAS_GMSJ = "购买时间";
	public static final String ALIAS_JBR = "经办人";
	
	//date formats
	
	//columns START
	private java.lang.String dnid;
	private String ddlx;
	private String dnpp;
	private String dnxh;
	private String zbh;
	private String yph;
	private String zc;
	private String cpcode;
	private String chushoury;
	private String chushourenxb;
	private String chushourensfzh;
	private String beizhu;
	private String chushourenlxdh;
	private String macdz;
	private String sgsj;
	private String dqsjh;
	private String csrjtzz;
	private String csrdh;
	private String gmsj;
	private String jbr;
	//columns END
	
	
	private String deptname;
	private String jbrXm;

	public Tesdd(){
	}

	public Tesdd(
		java.lang.String dnid
	){
		this.dnid = dnid;
	}

	public void setDnid(java.lang.String value) {
		this.dnid = value;
	}
	
	public java.lang.String getDnid() {
		return this.dnid;
	}
	public void setDdlx(String value) {
		this.ddlx = value;
	}
	
	public String getDdlx() {
		return this.ddlx;
	}
	public void setDnpp(String value) {
		this.dnpp = value;
	}
	
	public String getDnpp() {
		return this.dnpp;
	}
	public void setDnxh(String value) {
		this.dnxh = value;
	}
	
	public String getDnxh() {
		return this.dnxh;
	}
	public void setZbh(String value) {
		this.zbh = value;
	}
	
	public String getZbh() {
		return this.zbh;
	}
	public void setYph(String value) {
		this.yph = value;
	}
	
	public String getYph() {
		return this.yph;
	}
	public void setZc(String value) {
		this.zc = value;
	}
	
	public String getZc() {
		return this.zc;
	}
	public void setCpcode(String value) {
		this.cpcode = value;
	}
	
	public String getCpcode() {
		return this.cpcode;
	}
	public void setChushoury(String value) {
		this.chushoury = value;
	}
	
	public String getChushoury() {
		return this.chushoury;
	}
	public void setChushourenxb(String value) {
		this.chushourenxb = value;
	}
	
	public String getChushourenxb() {
		return this.chushourenxb;
	}
	public void setChushourensfzh(String value) {
		this.chushourensfzh = value;
	}
	
	public String getChushourensfzh() {
		return this.chushourensfzh;
	}
	public void setBeizhu(String value) {
		this.beizhu = value;
	}
	
	public String getBeizhu() {
		return this.beizhu;
	}
	public void setChushourenlxdh(String value) {
		this.chushourenlxdh = value;
	}
	
	public String getChushourenlxdh() {
		return this.chushourenlxdh;
	}
	public void setMacdz(String value) {
		this.macdz = value;
	}
	
	public String getMacdz() {
		return this.macdz;
	}
	public void setSgsj(String value) {
		this.sgsj = value;
	}
	
	public String getSgsj() {
		return this.sgsj;
	}
	public void setDqsjh(String value) {
		this.dqsjh = value;
	}
	
	public String getDqsjh() {
		return this.dqsjh;
	}
	public void setCsrjtzz(String value) {
		this.csrjtzz = value;
	}
	
	public String getCsrjtzz() {
		return this.csrjtzz;
	}
	public void setCsrdh(String value) {
		this.csrdh = value;
	}
	
	public String getCsrdh() {
		return this.csrdh;
	}
	public void setGmsj(String value) {
		this.gmsj = value;
	}
	
	public String getGmsj() {
		return this.gmsj;
	}
	public void setJbr(String value) {
		this.jbr = value;
	}
	
	public String getJbr() {
		return this.jbr;
	}

	public String toString() {
		return new ToStringBuilder(this)
			.append("Dnid",getDnid())
			.append("Ddlx",getDdlx())
			.append("Dnpp",getDnpp())
			.append("Dnxh",getDnxh())
			.append("Zbh",getZbh())
			.append("Yph",getYph())
			.append("Zc",getZc())
			.append("Cpcode",getCpcode())
			.append("Chushoury",getChushoury())
			.append("Chushourenxb",getChushourenxb())
			.append("Chushourensfzh",getChushourensfzh())
			.append("Beizhu",getBeizhu())
			.append("Chushourenlxdh",getChushourenlxdh())
			.append("Macdz",getMacdz())
			.append("Sgsj",getSgsj())
			.append("Dqsjh",getDqsjh())
			.append("Csrjtzz",getCsrjtzz())
			.append("Csrdh",getCsrdh())
			.append("Gmsj",getGmsj())
			.append("Jbr",getJbr())
			.toString();
	}
	
	public int hashCode() {
		return new HashCodeBuilder()
			.append(getDnid())
			.append(getDdlx())
			.append(getDnpp())
			.append(getDnxh())
			.append(getZbh())
			.append(getYph())
			.append(getZc())
			.append(getCpcode())
			.append(getChushoury())
			.append(getChushourenxb())
			.append(getChushourensfzh())
			.append(getBeizhu())
			.append(getChushourenlxdh())
			.append(getMacdz())
			.append(getSgsj())
			.append(getDqsjh())
			.append(getCsrjtzz())
			.append(getCsrdh())
			.append(getGmsj())
			.append(getJbr())
			.toHashCode();
	}
	
	public boolean equals(Object obj) {
		if(obj instanceof Tesdd == false) return false;
		if(this == obj) return true;
		Tesdd other = (Tesdd)obj;
		return new EqualsBuilder()
			.append(getDnid(),other.getDnid())
			.append(getDdlx(),other.getDdlx())
			.append(getDnpp(),other.getDnpp())
			.append(getDnxh(),other.getDnxh())
			.append(getZbh(),other.getZbh())
			.append(getYph(),other.getYph())
			.append(getZc(),other.getZc())
			.append(getCpcode(),other.getCpcode())
			.append(getChushoury(),other.getChushoury())
			.append(getChushourenxb(),other.getChushourenxb())
			.append(getChushourensfzh(),other.getChushourensfzh())
			.append(getBeizhu(),other.getBeizhu())
			.append(getChushourenlxdh(),other.getChushourenlxdh())
			.append(getMacdz(),other.getMacdz())
			.append(getSgsj(),other.getSgsj())
			.append(getDqsjh(),other.getDqsjh())
			.append(getCsrjtzz(),other.getCsrjtzz())
			.append(getCsrdh(),other.getCsrdh())
			.append(getGmsj(),other.getGmsj())
			.append(getJbr(),other.getJbr())
			.isEquals();
	}

	public String getDeptname() {
		return deptname;
	}

	public void setDeptname(String deptname) {
		this.deptname = deptname;
	}

	public String getJbrXm() {
		return jbrXm;
	}

	public void setJbrXm(String jbrXm) {
		this.jbrXm = jbrXm;
	}
}

