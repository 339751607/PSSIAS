/*
 * Powered By [lishicheng]
 */

package com.dyneinfo.jxy.model;

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

import com.dyneinfo.jxy.dao.*;
import com.dyneinfo.jxy.model.*;
import com.dyneinfo.jxy.service.*;

/**
 * @author lisc email:lishicheng(a)gmail.com
 */


public class Tcpinfo extends BaseEntity {
	
	//alias
	public static final String TABLE_ALIAS = "企业";
	public static final String ALIAS_CPCODE = "企业代码";
	public static final String ALIAS_CPNAME = "企业名称";
	public static final String ALIAS_CPADDRESS = "企业地址";
	public static final String ALIAS_WORKAREA = "经营范围";
	public static final String ALIAS_PHONE = "联系电话";
	public static final String ALIAS_FAX = "传真";
	public static final String ALIAS_ENROLCAPITAL = "注册资本";
	public static final String ALIAS_POSTALCODE = "邮政编码";
	public static final String ALIAS_STARTDATE = "开业日期";
	public static final String ALIAS_ECONOMY = "经济类型";
	public static final String ALIAS_CORPCODE = "法人代码";
	public static final String ALIAS_CORPNAME = "法定代表人";
	public static final String ALIAS_POLICENAME = "治安负责人";
	public static final String ALIAS_POLICEPHONE = "保卫部门电话";
	public static final String ALIAS_ACREAGE = "占地面积";
	public static final String ALIAS_POLICEUNIT = "治安管理机构";
	public static final String ALIAS_SCBACKUPNO = "特行备案编号";
	public static final String ALIAS_SCBACKUPUNIT = "特行备案机构";
	public static final String ALIAS_BASJ = "备案时间";
	public static final String ALIAS_LICENCEUNIT = "行业证发证机构";
	public static final String ALIAS_BCRETCODE = "营业执照编号";
	public static final String ALIAS_BCRETUNIT = "营业执照发证机构";
	public static final String ALIAS_TAXCODE = "税务登记证编号";
	public static final String ALIAS_TAXUNIT = "税务登记证发证机构";
	public static final String ALIAS_LICENCE = "行业许可证号";
	public static final String ALIAS_FLAG = "是否注销";
	public static final String ALIAS_STATION = "所属部门";
	
	//date formats
	
	//columns START
	private java.lang.String cpcode;
	private String cpname;
	private String cpaddress;
	private String workarea;
	private String phone;
	private String fax;
	private Long enrolcapital;
	private String postalcode;
	private String startdate;
	private String economy;
	private String corpcode;
	private String corpname;
	private String policename;
	private String policephone;
	private Long acreage;
	private String policeunit;
	private String scbackupno;
	private String scbackupunit;
	private String basj;
	private String licenceunit;
	private String bcretcode;
	private String bcretunit;
	private String taxcode;
	private String taxunit;
	private String licence;
	private String flag;
	private String station;
	
	private String cpDeptName;
	private String stationName;
	private String iscode;
	private String typecode;
	private String smycode;
	
	//columns END

	public String getIscode() {
		return iscode;
	}

	public void setIscode(String iscode) {
		this.iscode = iscode;
	}

	public String getTypecode() {
		return typecode;
	}

	public void setTypecode(String typecode) {
		this.typecode = typecode;
	}

	public String getSmycode() {
		return smycode;
	}

	public void setSmycode(String smycode) {
		this.smycode = smycode;
	}

	public Tcpinfo(){
	}

	public Tcpinfo(
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
	public void setCpname(String value) {
		this.cpname = value;
	}
	
	public String getCpname() {
		return this.cpname;
	}
	public void setCpaddress(String value) {
		this.cpaddress = value;
	}
	
	public String getCpaddress() {
		return this.cpaddress;
	}
	public void setWorkarea(String value) {
		this.workarea = value;
	}
	
	public String getWorkarea() {
		return this.workarea;
	}
	public void setPhone(String value) {
		this.phone = value;
	}
	
	public String getPhone() {
		return this.phone;
	}
	public void setFax(String value) {
		this.fax = value;
	}
	
	public String getFax() {
		return this.fax;
	}
	public void setEnrolcapital(Long value) {
		this.enrolcapital = value;
	}
	
	public Long getEnrolcapital() {
		return this.enrolcapital;
	}
	public void setPostalcode(String value) {
		this.postalcode = value;
	}
	
	public String getPostalcode() {
		return this.postalcode;
	}
	public void setStartdate(String value) {
		this.startdate = value;
	}
	
	public String getStartdate() {
		return this.startdate;
	}
	public void setEconomy(String value) {
		this.economy = value;
	}
	
	public String getEconomy() {
		return this.economy;
	}
	public void setCorpcode(String value) {
		this.corpcode = value;
	}
	
	public String getCorpcode() {
		return this.corpcode;
	}
	public void setCorpname(String value) {
		this.corpname = value;
	}
	
	public String getCorpname() {
		return this.corpname;
	}
	public void setPolicename(String value) {
		this.policename = value;
	}
	
	public String getPolicename() {
		return this.policename;
	}
	public void setPolicephone(String value) {
		this.policephone = value;
	}
	
	public String getPolicephone() {
		return this.policephone;
	}
	public void setAcreage(Long value) {
		this.acreage = value;
	}
	
	public Long getAcreage() {
		return this.acreage;
	}
	public void setPoliceunit(String value) {
		this.policeunit = value;
	}
	
	public String getPoliceunit() {
		return this.policeunit;
	}
	public void setScbackupno(String value) {
		this.scbackupno = value;
	}
	
	public String getScbackupno() {
		return this.scbackupno;
	}
	public void setScbackupunit(String value) {
		this.scbackupunit = value;
	}
	
	public String getScbackupunit() {
		return this.scbackupunit;
	}
	public void setBasj(String value) {
		this.basj = value;
	}
	
	public String getBasj() {
		return this.basj;
	}
	public void setLicenceunit(String value) {
		this.licenceunit = value;
	}
	
	public String getLicenceunit() {
		return this.licenceunit;
	}
	public void setBcretcode(String value) {
		this.bcretcode = value;
	}
	
	public String getBcretcode() {
		return this.bcretcode;
	}
	public void setBcretunit(String value) {
		this.bcretunit = value;
	}
	
	public String getBcretunit() {
		return this.bcretunit;
	}
	public void setTaxcode(String value) {
		this.taxcode = value;
	}
	
	public String getTaxcode() {
		return this.taxcode;
	}
	public void setTaxunit(String value) {
		this.taxunit = value;
	}
	
	public String getTaxunit() {
		return this.taxunit;
	}
	public void setLicence(String value) {
		this.licence = value;
	}
	
	public String getLicence() {
		return this.licence;
	}
	public void setFlag(String value) {
		this.flag = value;
	}
	
	public String getFlag() {
		return this.flag;
	}
	public void setStation(String value) {
		this.station = value;
	}
	
	public String getStation() {
		return this.station;
	}

	public String toString() {
		return new ToStringBuilder(this)
			.append("Cpcode",getCpcode())
			.append("Cpname",getCpname())
			.append("Cpaddress",getCpaddress())
			.append("Workarea",getWorkarea())
			.append("Phone",getPhone())
			.append("Fax",getFax())
			.append("Enrolcapital",getEnrolcapital())
			.append("Postalcode",getPostalcode())
			.append("Startdate",getStartdate())
			.append("Economy",getEconomy())
			.append("Corpcode",getCorpcode())
			.append("Corpname",getCorpname())
			.append("Policename",getPolicename())
			.append("Policephone",getPolicephone())
			.append("Acreage",getAcreage())
			.append("Policeunit",getPoliceunit())
			.append("Scbackupno",getScbackupno())
			.append("Scbackupunit",getScbackupunit())
			.append("Basj",getBasj())
			.append("Licenceunit",getLicenceunit())
			.append("Bcretcode",getBcretcode())
			.append("Bcretunit",getBcretunit())
			.append("Taxcode",getTaxcode())
			.append("Taxunit",getTaxunit())
			.append("Licence",getLicence())
			.append("Flag",getFlag())
			.append("Station",getStation())
			.append("smycode",getSmycode())
			.append("iscode",getIscode())
			.append("typecode",getTypecode())
			.toString();
	}
	
	public int hashCode() {
		return new HashCodeBuilder()
			.append(getCpcode())
			.append(getCpname())
			.append(getCpaddress())
			.append(getWorkarea())
			.append(getPhone())
			.append(getFax())
			.append(getEnrolcapital())
			.append(getPostalcode())
			.append(getStartdate())
			.append(getEconomy())
			.append(getCorpcode())
			.append(getCorpname())
			.append(getPolicename())
			.append(getPolicephone())
			.append(getAcreage())
			.append(getPoliceunit())
			.append(getScbackupno())
			.append(getScbackupunit())
			.append(getBasj())
			.append(getLicenceunit())
			.append(getBcretcode())
			.append(getBcretunit())
			.append(getTaxcode())
			.append(getTaxunit())
			.append(getLicence())
			.append(getFlag())
			.append(getStation())
			.append(getSmycode())
			.append(getIscode())
			.append(getTypecode())
			.toHashCode();
	}
	
	public boolean equals(Object obj) {
		if(obj instanceof Tcpinfo == false) return false;
		if(this == obj) return true;
		Tcpinfo other = (Tcpinfo)obj;
		return new EqualsBuilder()
			.append(getCpcode(),other.getCpcode())
			.append(getCpname(),other.getCpname())
			.append(getCpaddress(),other.getCpaddress())
			.append(getWorkarea(),other.getWorkarea())
			.append(getPhone(),other.getPhone())
			.append(getFax(),other.getFax())
			.append(getEnrolcapital(),other.getEnrolcapital())
			.append(getPostalcode(),other.getPostalcode())
			.append(getStartdate(),other.getStartdate())
			.append(getEconomy(),other.getEconomy())
			.append(getCorpcode(),other.getCorpcode())
			.append(getCorpname(),other.getCorpname())
			.append(getPolicename(),other.getPolicename())
			.append(getPolicephone(),other.getPolicephone())
			.append(getAcreage(),other.getAcreage())
			.append(getPoliceunit(),other.getPoliceunit())
			.append(getScbackupno(),other.getScbackupno())
			.append(getScbackupunit(),other.getScbackupunit())
			.append(getBasj(),other.getBasj())
			.append(getLicenceunit(),other.getLicenceunit())
			.append(getBcretcode(),other.getBcretcode())
			.append(getBcretunit(),other.getBcretunit())
			.append(getTaxcode(),other.getTaxcode())
			.append(getTaxunit(),other.getTaxunit())
			.append(getLicence(),other.getLicence())
			.append(getFlag(),other.getFlag())
			.append(getStation(),other.getStation())
			.append(getSmycode(), other.getSmycode())
			.append(getIscode(), other.getIscode())
			.append(getTypecode(), other.getTypecode())
			.isEquals();
	}

	public String getCpDeptName() {
		return cpDeptName;
	}

	public void setCpDeptName(String cpDeptName) {
		this.cpDeptName = cpDeptName;
	}

	public String getStationName() {
		return stationName;
	}

	public void setStationName(String stationName) {
		this.stationName = stationName;
	}
}

