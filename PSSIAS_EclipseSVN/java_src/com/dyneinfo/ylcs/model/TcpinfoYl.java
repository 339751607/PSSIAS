/*
 * Powered By [lishicheng]
 */

package com.dyneinfo.ylcs.model;

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

import com.dyneinfo.ylcs.model.*;
import com.dyneinfo.ylcs.dao.*;
import com.dyneinfo.ylcs.service.*;

/**
 * @author lisc email:lishicheng(a)gmail.com
 */


public class TcpinfoYl extends BaseEntity {
	
	//alias
	public static final String TABLE_ALIAS = "企业信息表";
	public static final String ALIAS_LOCODE = "场所编号";
	public static final String ALIAS_STATION = "所属派出所(代码)";
	public static final String ALIAS_STARTDATE = "开业日期";
	public static final String ALIAS_ACREAGE = "占地面积";
	public static final String ALIAS_ENROLCAPITAL = "注册资本";
	public static final String ALIAS_CPNAME = "企业名称";
	public static final String ALIAS_CPADDRESS = "企业地址";
	public static final String ALIAS_PHONE = "联系电话";
	public static final String ALIAS_FAX = "传真";
	public static final String ALIAS_POSTALCODE = "邮政编码";
	public static final String ALIAS_ECONOMY = "经济类型";
	public static final String ALIAS_CORPCODE = "法人代码";
	public static final String ALIAS_CORPNAME = "法定代表人";
	public static final String ALIAS_POLICENAME = "治安负责人";
	public static final String ALIAS_POLICEPHONE = "保卫部门电话";
	public static final String ALIAS_WORKAREA = "经营范围";
	public static final String ALIAS_POLICEUNIT = "治安管理机构";
	public static final String ALIAS_SCBACKUPNO = "特行备案编号";
	public static final String ALIAS_SCBACKUPUNIT = "特行备案机构";
	public static final String ALIAS_LICENCE = "行业许可证号";
	public static final String ALIAS_LICENCEUNIT = "行业许可证发证机构名称";
	public static final String ALIAS_BCRETCODE = "营业执照编号";
	public static final String ALIAS_BCRETUNIT = "营业执照发证机构名称";
	public static final String ALIAS_TAXCODE = "税务登记证编号";
	public static final String ALIAS_TAXUNIT = "税务登记证发证机构名称";
	public static final String ALIAS_THCODE = "特行编号";
	public static final String ALIAS_FJCODE = "分局行政区划";
	public static final String ALIAS_WORKAREASEC = "兼营范围";
	public static final String ALIAS_STOPDATE = "停业日期";
	public static final String ALIAS_HIS = "删除标识(默认为'0',删除置'1')";
	public static final String ALIAS_JWDZB = "经纬度坐标";
	public static final String ALIAS_GDXX = "股东信息(按公司章程填写)";
	public static final String ALIAS_XFZSL = "消费者数量（人）";
	public static final String ALIAS_BXSL = "包箱数量";
	public static final String ALIAS_ZAJB = " 治安级别代码（字典表T_DIC_ZAJB）";
	public static final String ALIAS_CSXJ = "场所星级(字典表 T_DIC_CSXJ";
	public static final String ALIAS_STATE = "1营业,2停业,3歇业,4注销,9其它";
	public static final String ALIAS_POLICELEVELCODE = "治安管理等级  0 普通 1 重点";
	public static final String ALIAS_FLAGPACK = "flagpack";
	public static final String ALIAS_AUTHORIZATIONCODE = "授权码";
	public static final String ALIAS_SPJRURL = "视频接入URL";
	public static final String ALIAS_CURRENTSCORE = "当前分值";
	public static final String ALIAS_JCJB = " 检查级别代码（字典表T_DIC_PLACE_GRADES）";
	
	//date formats
	public static final String FORMAT_STARTDATE = DATE_FORMAT;
	public static final String FORMAT_STOPDATE = DATE_FORMAT;
	
	//columns START
	private java.lang.String locode;
	private java.lang.String station;
	private java.util.Date startdate;
	private java.lang.Long acreage;
	private Long enrolcapital;
	private java.lang.String cpname;
	private java.lang.String cpaddress;
	private java.lang.String phone;
	private java.lang.String fax;
	private java.lang.String postalcode;
	private java.lang.String economy;
	private java.lang.String corpcode;
	private java.lang.String corpname;
	private java.lang.String policename;
	private java.lang.String policephone;
	private java.lang.String workarea;
	private java.lang.String policeunit;
	private java.lang.String scbackupno;
	private java.lang.String scbackupunit;
	private java.lang.String licence;
	private java.lang.String licenceunit;
	private java.lang.String bcretcode;
	private java.lang.String bcretunit;
	private java.lang.String taxcode;
	private java.lang.String taxunit;
	private java.lang.String thcode;
	private java.lang.String fjcode;
	private java.lang.String workareasec;
	private java.util.Date stopdate;
	private java.lang.String his;
	private java.lang.String jwdzb;
	private java.lang.String gdxx;
	private java.lang.Integer xfzsl;
	private java.lang.Integer bxsl;
	private java.lang.String zajb;
	private java.lang.String csxj;
	private java.lang.String state;
	private java.lang.String policelevelcode;
	private java.lang.String flagpack;
	private java.lang.String authorizationcode;
	private java.lang.String spjrurl;
	private Long currentscore;
	private java.lang.String jcjb;
	//columns END

	public TcpinfoYl(){
	}

	public TcpinfoYl(
		java.lang.String locode
	){
		this.locode = locode;
	}

	public void setLocode(java.lang.String value) {
		this.locode = value;
	}
	
	public java.lang.String getLocode() {
		return this.locode;
	}
	public void setStation(java.lang.String value) {
		this.station = value;
	}
	
	public java.lang.String getStation() {
		return this.station;
	}
	public String getStartdateString() {
		return date2String(getStartdate(), FORMAT_STARTDATE);
	}
	public void setStartdateString(String value) {
		setStartdate(string2Date(value, FORMAT_STARTDATE,java.util.Date.class));
	}
	
	public void setStartdate(java.util.Date value) {
		this.startdate = value;
	}
	
	public java.util.Date getStartdate() {
		return this.startdate;
	}
	public void setAcreage(java.lang.Long value) {
		this.acreage = value;
	}
	
	public java.lang.Long getAcreage() {
		return this.acreage;
	}
	public void setEnrolcapital(Long value) {
		this.enrolcapital = value;
	}
	
	public Long getEnrolcapital() {
		return this.enrolcapital;
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
	public void setPoliceunit(java.lang.String value) {
		this.policeunit = value;
	}
	
	public java.lang.String getPoliceunit() {
		return this.policeunit;
	}
	public void setScbackupno(java.lang.String value) {
		this.scbackupno = value;
	}
	
	public java.lang.String getScbackupno() {
		return this.scbackupno;
	}
	public void setScbackupunit(java.lang.String value) {
		this.scbackupunit = value;
	}
	
	public java.lang.String getScbackupunit() {
		return this.scbackupunit;
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
	public void setThcode(java.lang.String value) {
		this.thcode = value;
	}
	
	public java.lang.String getThcode() {
		return this.thcode;
	}
	public void setFjcode(java.lang.String value) {
		this.fjcode = value;
	}
	
	public java.lang.String getFjcode() {
		return this.fjcode;
	}
	public void setWorkareasec(java.lang.String value) {
		this.workareasec = value;
	}
	
	public java.lang.String getWorkareasec() {
		return this.workareasec;
	}
	public String getStopdateString() {
		return date2String(getStopdate(), FORMAT_STOPDATE);
	}
	public void setStopdateString(String value) {
		setStopdate(string2Date(value, FORMAT_STOPDATE,java.util.Date.class));
	}
	
	public void setStopdate(java.util.Date value) {
		this.stopdate = value;
	}
	
	public java.util.Date getStopdate() {
		return this.stopdate;
	}
	public void setHis(java.lang.String value) {
		this.his = value;
	}
	
	public java.lang.String getHis() {
		return this.his;
	}
	public void setJwdzb(java.lang.String value) {
		this.jwdzb = value;
	}
	
	public java.lang.String getJwdzb() {
		return this.jwdzb;
	}
	public void setGdxx(java.lang.String value) {
		this.gdxx = value;
	}
	
	public java.lang.String getGdxx() {
		return this.gdxx;
	}
	public void setXfzsl(java.lang.Integer value) {
		this.xfzsl = value;
	}
	
	public java.lang.Integer getXfzsl() {
		return this.xfzsl;
	}
	public void setBxsl(java.lang.Integer value) {
		this.bxsl = value;
	}
	
	public java.lang.Integer getBxsl() {
		return this.bxsl;
	}
	public void setZajb(java.lang.String value) {
		this.zajb = value;
	}
	
	public java.lang.String getZajb() {
		return this.zajb;
	}
	public void setCsxj(java.lang.String value) {
		this.csxj = value;
	}
	
	public java.lang.String getCsxj() {
		return this.csxj;
	}
	public void setState(java.lang.String value) {
		this.state = value;
	}
	
	public java.lang.String getState() {
		return this.state;
	}
	public void setPolicelevelcode(java.lang.String value) {
		this.policelevelcode = value;
	}
	
	public java.lang.String getPolicelevelcode() {
		return this.policelevelcode;
	}
	public void setFlagpack(java.lang.String value) {
		this.flagpack = value;
	}
	
	public java.lang.String getFlagpack() {
		return this.flagpack;
	}
	public void setAuthorizationcode(java.lang.String value) {
		this.authorizationcode = value;
	}
	
	public java.lang.String getAuthorizationcode() {
		return this.authorizationcode;
	}
	public void setSpjrurl(java.lang.String value) {
		this.spjrurl = value;
	}
	
	public java.lang.String getSpjrurl() {
		return this.spjrurl;
	}
	public void setCurrentscore(Long value) {
		this.currentscore = value;
	}
	
	public Long getCurrentscore() {
		return this.currentscore;
	}
	public void setJcjb(java.lang.String value) {
		this.jcjb = value;
	}
	
	public java.lang.String getJcjb() {
		return this.jcjb;
	}

	public String toString() {
		return new ToStringBuilder(this)
			.append("Locode",getLocode())
			.append("Station",getStation())
			.append("Startdate",getStartdate())
			.append("Acreage",getAcreage())
			.append("Enrolcapital",getEnrolcapital())
			.append("Cpname",getCpname())
			.append("Cpaddress",getCpaddress())
			.append("Phone",getPhone())
			.append("Fax",getFax())
			.append("Postalcode",getPostalcode())
			.append("Economy",getEconomy())
			.append("Corpcode",getCorpcode())
			.append("Corpname",getCorpname())
			.append("Policename",getPolicename())
			.append("Policephone",getPolicephone())
			.append("Workarea",getWorkarea())
			.append("Policeunit",getPoliceunit())
			.append("Scbackupno",getScbackupno())
			.append("Scbackupunit",getScbackupunit())
			.append("Licence",getLicence())
			.append("Licenceunit",getLicenceunit())
			.append("Bcretcode",getBcretcode())
			.append("Bcretunit",getBcretunit())
			.append("Taxcode",getTaxcode())
			.append("Taxunit",getTaxunit())
			.append("Thcode",getThcode())
			.append("Fjcode",getFjcode())
			.append("Workareasec",getWorkareasec())
			.append("Stopdate",getStopdate())
			.append("His",getHis())
			.append("Jwdzb",getJwdzb())
			.append("Gdxx",getGdxx())
			.append("Xfzsl",getXfzsl())
			.append("Bxsl",getBxsl())
			.append("Zajb",getZajb())
			.append("Csxj",getCsxj())
			.append("State",getState())
			.append("Policelevelcode",getPolicelevelcode())
			.append("Flagpack",getFlagpack())
			.append("Authorizationcode",getAuthorizationcode())
			.append("Spjrurl",getSpjrurl())
			.append("Currentscore",getCurrentscore())
			.append("Jcjb",getJcjb())
			.toString();
	}
	
	public int hashCode() {
		return new HashCodeBuilder()
			.append(getLocode())
			.append(getStation())
			.append(getStartdate())
			.append(getAcreage())
			.append(getEnrolcapital())
			.append(getCpname())
			.append(getCpaddress())
			.append(getPhone())
			.append(getFax())
			.append(getPostalcode())
			.append(getEconomy())
			.append(getCorpcode())
			.append(getCorpname())
			.append(getPolicename())
			.append(getPolicephone())
			.append(getWorkarea())
			.append(getPoliceunit())
			.append(getScbackupno())
			.append(getScbackupunit())
			.append(getLicence())
			.append(getLicenceunit())
			.append(getBcretcode())
			.append(getBcretunit())
			.append(getTaxcode())
			.append(getTaxunit())
			.append(getThcode())
			.append(getFjcode())
			.append(getWorkareasec())
			.append(getStopdate())
			.append(getHis())
			.append(getJwdzb())
			.append(getGdxx())
			.append(getXfzsl())
			.append(getBxsl())
			.append(getZajb())
			.append(getCsxj())
			.append(getState())
			.append(getPolicelevelcode())
			.append(getFlagpack())
			.append(getAuthorizationcode())
			.append(getSpjrurl())
			.append(getCurrentscore())
			.append(getJcjb())
			.toHashCode();
	}
	
	public boolean equals(Object obj) {
		if(obj instanceof TcpinfoYl == false) return false;
		if(this == obj) return true;
		TcpinfoYl other = (TcpinfoYl)obj;
		return new EqualsBuilder()
			.append(getLocode(),other.getLocode())
			.append(getStation(),other.getStation())
			.append(getStartdate(),other.getStartdate())
			.append(getAcreage(),other.getAcreage())
			.append(getEnrolcapital(),other.getEnrolcapital())
			.append(getCpname(),other.getCpname())
			.append(getCpaddress(),other.getCpaddress())
			.append(getPhone(),other.getPhone())
			.append(getFax(),other.getFax())
			.append(getPostalcode(),other.getPostalcode())
			.append(getEconomy(),other.getEconomy())
			.append(getCorpcode(),other.getCorpcode())
			.append(getCorpname(),other.getCorpname())
			.append(getPolicename(),other.getPolicename())
			.append(getPolicephone(),other.getPolicephone())
			.append(getWorkarea(),other.getWorkarea())
			.append(getPoliceunit(),other.getPoliceunit())
			.append(getScbackupno(),other.getScbackupno())
			.append(getScbackupunit(),other.getScbackupunit())
			.append(getLicence(),other.getLicence())
			.append(getLicenceunit(),other.getLicenceunit())
			.append(getBcretcode(),other.getBcretcode())
			.append(getBcretunit(),other.getBcretunit())
			.append(getTaxcode(),other.getTaxcode())
			.append(getTaxunit(),other.getTaxunit())
			.append(getThcode(),other.getThcode())
			.append(getFjcode(),other.getFjcode())
			.append(getWorkareasec(),other.getWorkareasec())
			.append(getStopdate(),other.getStopdate())
			.append(getHis(),other.getHis())
			.append(getJwdzb(),other.getJwdzb())
			.append(getGdxx(),other.getGdxx())
			.append(getXfzsl(),other.getXfzsl())
			.append(getBxsl(),other.getBxsl())
			.append(getZajb(),other.getZajb())
			.append(getCsxj(),other.getCsxj())
			.append(getState(),other.getState())
			.append(getPolicelevelcode(),other.getPolicelevelcode())
			.append(getFlagpack(),other.getFlagpack())
			.append(getAuthorizationcode(),other.getAuthorizationcode())
			.append(getSpjrurl(),other.getSpjrurl())
			.append(getCurrentscore(),other.getCurrentscore())
			.append(getJcjb(),other.getJcjb())
			.isEquals();
	}
}

