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


public class Tcompany extends BaseEntity {
	
	//alias
	public static final String TABLE_ALIAS = "企业信息";
	public static final String ALIAS_CPCODE = "企业代码";
	public static final String ALIAS_POLICEUNIT = "治安管理机构";
	public static final String ALIAS_SCBACKUPUNIT = "特行备案机构";
	public static final String ALIAS_CPNAME = "企业名称";
	public static final String ALIAS_CPADDRESS = "企业地址";
	public static final String ALIAS_PHONE = "联系电话";
	public static final String ALIAS_FAX = "传真";
	public static final String ALIAS_POSTALCODE = "邮政编码";
	public static final String ALIAS_STARTDATE = "开业日期";
	public static final String ALIAS_ECONOMY = "经济类型";
	public static final String ALIAS_CORPCODE = "法人代码";
	public static final String ALIAS_CORPNAME = "法定代表人";
	public static final String ALIAS_POLICENAME = "治安负责人";
	public static final String ALIAS_POLICEPHONE = "保卫部门电话";
	public static final String ALIAS_WORKAREA = "经营范围";
	public static final String ALIAS_ENROLCAPITAL = "注册资本";
	public static final String ALIAS_ACREAGE = "占地面积";
	public static final String ALIAS_SCBACKUPNO = "特行备案编号";
	public static final String ALIAS_LICENCE = "行业许可证号";
	public static final String ALIAS_LICENCEUNIT = "行业许可证发证机构名称";
	public static final String ALIAS_BCRETCODE = "营业执照编号";
	public static final String ALIAS_BCRETUNIT = "营业执照发证机构名称";
	public static final String ALIAS_TAXCODE = "税务登记证编号";
	public static final String ALIAS_TAXUNIT = "税务登记证发证机构名称";
	public static final String ALIAS_STATUS = "企业状态";
	public static final String ALIAS_MODDATE = "状态改变日期";
	public static final String ALIAS_BURCODE = "所属分局";
	public static final String ALIAS_STACODE = "所属派出所";
	public static final String ALIAS_BASJ = "备案时间";
	public static final String ALIAS_BUSINESSCODE = "所属行业";
	public static final String ALIAS_EXITEND2 = "扩展2";
	public static final String ALIAS_EXITEND3 = "扩展3";
	public static final String ALIAS_EXITEND1 = "扩展1";
	
	//date formats
	
	//columns START
	private java.lang.String cpcode;
	private java.lang.String policeunit;
	private java.lang.String scbackupunit;
	private java.lang.String cpname;
	private java.lang.String cpaddress;
	private java.lang.String phone;
	private java.lang.String fax;
	private java.lang.String postalcode;
	private java.lang.String startdate;
	private java.lang.String economy;
	private java.lang.String corpcode;
	private java.lang.String corpname;
	private java.lang.String policename;
	private java.lang.String policephone;
	private java.lang.String workarea;
	private java.lang.Long enrolcapital;
	private java.lang.Long acreage;
	private java.lang.String scbackupno;
	private java.lang.String licence;
	private java.lang.String licenceunit;
	private java.lang.String bcretcode;
	private java.lang.String bcretunit;
	private java.lang.String taxcode;
	private java.lang.String taxunit;
	private java.lang.String status;
	private java.lang.String moddate;
	private java.lang.String burcode;
	private java.lang.String stacode;
	private java.lang.String basj;
	private java.lang.String businesscode;
	private java.lang.String exitend2;
	private java.lang.String exitend3;
	private java.lang.String exitend1;
	
	private java.lang.String burname;
	private java.lang.String staname;
	//columns END

	public Tcompany(){
	}

	public Tcompany(
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
	public void setPoliceunit(java.lang.String value) {
		this.policeunit = value;
	}
	
	public java.lang.String getPoliceunit() {
		return this.policeunit;
	}
	public void setScbackupunit(java.lang.String value) {
		this.scbackupunit = value;
	}
	
	public java.lang.String getScbackupunit() {
		return this.scbackupunit;
	}
	public void setCpname(java.lang.String value) {
		this.cpname = value;
	}
	
	public java.lang.String getCpname() {
		return this.cpname;
	}
	public void setCpaddress(java.lang.String value) {
		this.cpaddress = value;
	}
	
	public java.lang.String getCpaddress() {
		return this.cpaddress;
	}
	public void setPhone(java.lang.String value) {
		this.phone = value;
	}
	
	public java.lang.String getPhone() {
		return this.phone;
	}
	public void setFax(java.lang.String value) {
		this.fax = value;
	}
	
	public java.lang.String getFax() {
		return this.fax;
	}
	public void setPostalcode(java.lang.String value) {
		this.postalcode = value;
	}
	
	public java.lang.String getPostalcode() {
		return this.postalcode;
	}
	public void setStartdate(java.lang.String value) {
		this.startdate = value;
	}
	
	public java.lang.String getStartdate() {
		return this.startdate;
	}
	public void setEconomy(java.lang.String value) {
		this.economy = value;
	}
	
	public java.lang.String getEconomy() {
		return this.economy;
	}
	public void setCorpcode(java.lang.String value) {
		this.corpcode = value;
	}
	
	public java.lang.String getCorpcode() {
		return this.corpcode;
	}
	public void setCorpname(java.lang.String value) {
		this.corpname = value;
	}
	
	public java.lang.String getCorpname() {
		return this.corpname;
	}

	public void setPolicename(java.lang.String value) {
		this.policename = value;
	}
	
	public java.lang.String getPolicename() {
		return this.policename;
	}
	public void setPolicephone(java.lang.String value) {
		this.policephone = value;
	}
	
	public java.lang.String getPolicephone() {
		return this.policephone;
	}
	public void setWorkarea(java.lang.String value) {
		this.workarea = value;
	}
	
	public java.lang.String getWorkarea() {
		return this.workarea;
	}
	public void setEnrolcapital(java.lang.Long value) {
		this.enrolcapital = value;
	}
	
	public java.lang.Long getEnrolcapital() {
		return this.enrolcapital;
	}
	public void setAcreage(java.lang.Long value) {
		this.acreage = value;
	}
	
	public java.lang.Long getAcreage() {
		return this.acreage;
	}
	public void setScbackupno(java.lang.String value) {
		this.scbackupno = value;
	}
	
	public java.lang.String getScbackupno() {
		return this.scbackupno;
	}
	public void setLicence(java.lang.String value) {
		this.licence = value;
	}
	
	public java.lang.String getLicence() {
		return this.licence;
	}
	public void setLicenceunit(java.lang.String value) {
		this.licenceunit = value;
	}
	
	public java.lang.String getLicenceunit() {
		return this.licenceunit;
	}
	public void setBcretcode(java.lang.String value) {
		this.bcretcode = value;
	}
	
	public java.lang.String getBcretcode() {
		return this.bcretcode;
	}
	public void setBcretunit(java.lang.String value) {
		this.bcretunit = value;
	}
	
	public java.lang.String getBcretunit() {
		return this.bcretunit;
	}
	public void setTaxcode(java.lang.String value) {
		this.taxcode = value;
	}
	
	public java.lang.String getTaxcode() {
		return this.taxcode;
	}
	public void setTaxunit(java.lang.String value) {
		this.taxunit = value;
	}
	
	public java.lang.String getTaxunit() {
		return this.taxunit;
	}
	public void setStatus(java.lang.String value) {
		this.status = value;
	}
	
	public java.lang.String getStatus() {
		return this.status;
	}
	public void setModdate(java.lang.String value) {
		this.moddate = value;
	}
	
	public java.lang.String getModdate() {
		return this.moddate;
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
	public void setBasj(java.lang.String value) {
		this.basj = value;
	}
	
	public java.lang.String getBasj() {
		return this.basj;
	}
	public void setBusinesscode(java.lang.String value) {
		this.businesscode = value;
	}
	
	public java.lang.String getBusinesscode() {
		return this.businesscode;
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
	public void setExitend1(java.lang.String value) {
		this.exitend1 = value;
	}
	
	public java.lang.String getExitend1() {
		return this.exitend1;
	}

	public String toString() {
		return new ToStringBuilder(this)
			.append("Cpcode",getCpcode())
			.append("Policeunit",getPoliceunit())
			.append("Scbackupunit",getScbackupunit())
			.append("Cpname",getCpname())
			.append("Cpaddress",getCpaddress())
			.append("Phone",getPhone())
			.append("Fax",getFax())
			.append("Postalcode",getPostalcode())
			.append("Startdate",getStartdate())
			.append("Economy",getEconomy())
			.append("Corpcode",getCorpcode())
			.append("Corpname",getCorpname())
			.append("Policename",getPolicename())
			.append("Policephone",getPolicephone())
			.append("Workarea",getWorkarea())
			.append("Enrolcapital",getEnrolcapital())
			.append("Acreage",getAcreage())
			.append("Scbackupno",getScbackupno())
			.append("Licence",getLicence())
			.append("Licenceunit",getLicenceunit())
			.append("Bcretcode",getBcretcode())
			.append("Bcretunit",getBcretunit())
			.append("Taxcode",getTaxcode())
			.append("Taxunit",getTaxunit())
			.append("Status",getStatus())
			.append("Moddate",getModdate())
			.append("Burcode",getBurcode())
			.append("Stacode",getStacode())
			.append("Basj",getBasj())
			.append("Businesscode",getBusinesscode())
			.append("Exitend2",getExitend2())
			.append("Exitend3",getExitend3())
			.append("Exitend1",getExitend1())
			.toString();
	}
	
	public int hashCode() {
		return new HashCodeBuilder()
			.append(getCpcode())
			.append(getPoliceunit())
			.append(getScbackupunit())
			.append(getCpname())
			.append(getCpaddress())
			.append(getPhone())
			.append(getFax())
			.append(getPostalcode())
			.append(getStartdate())
			.append(getEconomy())
			.append(getCorpcode())
			.append(getCorpname())
			.append(getPolicename())
			.append(getPolicephone())
			.append(getWorkarea())
			.append(getEnrolcapital())
			.append(getAcreage())
			.append(getScbackupno())
			.append(getLicence())
			.append(getLicenceunit())
			.append(getBcretcode())
			.append(getBcretunit())
			.append(getTaxcode())
			.append(getTaxunit())
			.append(getStatus())
			.append(getModdate())
			.append(getBurcode())
			.append(getStacode())
			.append(getBasj())
			.append(getBusinesscode())
			.append(getExitend2())
			.append(getExitend3())
			.append(getExitend1())
			.toHashCode();
	}
	
	public boolean equals(Object obj) {
		if(obj instanceof Tcompany == false) return false;
		if(this == obj) return true;
		Tcompany other = (Tcompany)obj;
		return new EqualsBuilder()
			.append(getCpcode(),other.getCpcode())
			.append(getPoliceunit(),other.getPoliceunit())
			.append(getScbackupunit(),other.getScbackupunit())
			.append(getCpname(),other.getCpname())
			.append(getCpaddress(),other.getCpaddress())
			.append(getPhone(),other.getPhone())
			.append(getFax(),other.getFax())
			.append(getPostalcode(),other.getPostalcode())
			.append(getStartdate(),other.getStartdate())
			.append(getEconomy(),other.getEconomy())
			.append(getCorpcode(),other.getCorpcode())
			.append(getCorpname(),other.getCorpname())
			.append(getPolicename(),other.getPolicename())
			.append(getPolicephone(),other.getPolicephone())
			.append(getWorkarea(),other.getWorkarea())
			.append(getEnrolcapital(),other.getEnrolcapital())
			.append(getAcreage(),other.getAcreage())
			.append(getScbackupno(),other.getScbackupno())
			.append(getLicence(),other.getLicence())
			.append(getLicenceunit(),other.getLicenceunit())
			.append(getBcretcode(),other.getBcretcode())
			.append(getBcretunit(),other.getBcretunit())
			.append(getTaxcode(),other.getTaxcode())
			.append(getTaxunit(),other.getTaxunit())
			.append(getStatus(),other.getStatus())
			.append(getModdate(),other.getModdate())
			.append(getBurcode(),other.getBurcode())
			.append(getStacode(),other.getStacode())
			.append(getBasj(),other.getBasj())
			.append(getBusinesscode(),other.getBusinesscode())
			.append(getExitend2(),other.getExitend2())
			.append(getExitend3(),other.getExitend3())
			.append(getExitend1(),other.getExitend1())
			.isEquals();
	}

	public java.lang.String getBurname() {
		return burname;
	}

	public void setBurname(java.lang.String burname) {
		this.burname = burname;
	}

	public java.lang.String getStaname() {
		return staname;
	}

	public void setStaname(java.lang.String staname) {
		this.staname = staname;
	}
}

