/*
 * Powered By [lishicheng]
 */

package com.dyneinfo.jxy.model;

import javacommon.base.BaseEntity;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

/**
 * @author lisc email:lishicheng(a)gmail.com
 */


public class ViewJspCpstat extends BaseEntity {
	
	//alias
	public static final String TABLE_ALIAS = "企业信息统计";
	public static final String ALIAS_CPCODE = "企业代码";
	public static final String ALIAS_CPNAME = "企业名称";
	public static final String ALIAS_XSAJ = "刑事案件";
	public static final String ALIAS_ZAAJ = "治安案件";
	public static final String ALIAS_JGCS = "警告次数";
	public static final String ALIAS_FMFFSD = "罚没非法所得";
	public static final String ALIAS_TYZD = "停业整顿";
	public static final String ALIAS_ZJZR = "追究责任";
	public static final String ALIAS_QTCF = "其他处罚";
	
	//date formats
	
	//columns START
	private java.lang.String cpcode;
	private java.lang.String cpname;
	private Long xsaj;//已上传企业
	private Long zaaj;//上传信息
	private Long jgcs;//系统安装数量
	private Long fmffsd;
	private Long tyzd;
	private Long zjzr;
	private Long qtcf;
	private Long closeNum;
	private Long openNum;
	private Long unInstallNum;
	//columns END

	public Long getCloseNum() {
		return closeNum;
	}

	public void setCloseNum(Long closeNum) {
		this.closeNum = closeNum;
	}

	public Long getOpenNum() {
		return openNum;
	}

	public void setOpenNum(Long openNum) {
		this.openNum = openNum;
	}

	public Long getUnInstallNum() {
		return unInstallNum;
	}

	public void setUnInstallNum(Long unInstallNum) {
		this.unInstallNum = unInstallNum;
	}

	public ViewJspCpstat(){
	}

	public ViewJspCpstat(
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
	public void setXsaj(Long value) {
		this.xsaj = value;
	}
	
	public Long getXsaj() {
		return this.xsaj;
	}
	public void setZaaj(Long value) {
		this.zaaj = value;
	}
	
	public Long getZaaj() {
		return this.zaaj;
	}
	public void setJgcs(Long value) {
		this.jgcs = value;
	}
	
	public Long getJgcs() {
		return this.jgcs;
	}
	public void setFmffsd(Long value) {
		this.fmffsd = value;
	}
	
	public Long getFmffsd() {
		return this.fmffsd;
	}
	public void setTyzd(Long value) {
		this.tyzd = value;
	}
	
	public Long getTyzd() {
		return this.tyzd;
	}
	public void setZjzr(Long value) {
		this.zjzr = value;
	}
	
	public Long getZjzr() {
		return this.zjzr;
	}
	public void setQtcf(Long value) {
		this.qtcf = value;
	}
	
	public Long getQtcf() {
		return this.qtcf;
	}

	public String toString() {
		return new ToStringBuilder(this)
			.append("Cpcode",getCpcode())
			.append("Cpname",getCpname())
			.append("Xsaj",getXsaj())
			.append("Zaaj",getZaaj())
			.append("Jgcs",getJgcs())
			.append("Fmffsd",getFmffsd())
			.append("Tyzd",getTyzd())
			.append("Zjzr",getZjzr())
			.append("Qtcf",getQtcf())
			.toString();
	}
	
	public int hashCode() {
		return new HashCodeBuilder()
			.append(getCpcode())
			.append(getCpname())
			.append(getXsaj())
			.append(getZaaj())
			.append(getJgcs())
			.append(getFmffsd())
			.append(getTyzd())
			.append(getZjzr())
			.append(getQtcf())
			.toHashCode();
	}
	
	public boolean equals(Object obj) {
		if(obj instanceof ViewJspCpstat == false) return false;
		if(this == obj) return true;
		ViewJspCpstat other = (ViewJspCpstat)obj;
		return new EqualsBuilder()
			.append(getCpcode(),other.getCpcode())
			.append(getCpname(),other.getCpname())
			.append(getXsaj(),other.getXsaj())
			.append(getZaaj(),other.getZaaj())
			.append(getJgcs(),other.getJgcs())
			.append(getFmffsd(),other.getFmffsd())
			.append(getTyzd(),other.getTyzd())
			.append(getZjzr(),other.getZjzr())
			.append(getQtcf(),other.getQtcf())
			.isEquals();
	}

}

