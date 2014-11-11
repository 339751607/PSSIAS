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


public class Registers extends BaseEntity {
	
	//alias
	public static final String TABLE_ALIAS = "Registers";
	public static final String ALIAS_CLUSTERGROUP = "clustergroup";
	public static final String ALIAS_IPADDRESS = "ipaddress";
	public static final String ALIAS_DATASOURCENAME = "datasourcename";
	public static final String ALIAS_NOTE = "note";
	public static final String ALIAS_PACKAGES = "packages";
	public static final String ALIAS_PORT = "port";
	public static final String ALIAS_PROTOCOL = "protocol";
	public static final String ALIAS_REGISTERTIME = "registertime";
	public static final String ALIAS_UNITID = "unitid";
	
	//date formats
	public static final String FORMAT_REGISTERTIME = DATE_TIME_FORMAT;
	
	//columns START
	private String clustergroup;
	private String ipaddress;
	private String datasourcename;
	private String note;
	private String packages;
	private String port;
	private String protocol;
	private java.util.Date registertime;
	private Long unitid;
	//columns END

	public Registers(){
	}

	public Registers(
		Long unitid
	){
		this.unitid = unitid;
	}

	public void setClustergroup(String value) {
		this.clustergroup = value;
	}
	
	public String getClustergroup() {
		return this.clustergroup;
	}
	public void setIpaddress(String value) {
		this.ipaddress = value;
	}
	
	public String getIpaddress() {
		return this.ipaddress;
	}
	public void setDatasourcename(String value) {
		this.datasourcename = value;
	}
	
	public String getDatasourcename() {
		return this.datasourcename;
	}
	public void setNote(String value) {
		this.note = value;
	}
	
	public String getNote() {
		return this.note;
	}
	public void setPackages(String value) {
		this.packages = value;
	}
	
	public String getPackages() {
		return this.packages;
	}
	public void setPort(String value) {
		this.port = value;
	}
	
	public String getPort() {
		return this.port;
	}
	public void setProtocol(String value) {
		this.protocol = value;
	}
	
	public String getProtocol() {
		return this.protocol;
	}
	public String getRegistertimeString() {
		return date2String(getRegistertime(), FORMAT_REGISTERTIME);
	}
	public void setRegistertimeString(String value) {
		setRegistertime(string2Date(value, FORMAT_REGISTERTIME,java.util.Date.class));
	}
	
	public void setRegistertime(java.util.Date value) {
		this.registertime = value;
	}
	
	public java.util.Date getRegistertime() {
		return this.registertime;
	}
	public void setUnitid(Long value) {
		this.unitid = value;
	}
	
	public Long getUnitid() {
		return this.unitid;
	}

	public String toString() {
		return new ToStringBuilder(this)
			.append("Clustergroup",getClustergroup())
			.append("Ipaddress",getIpaddress())
			.append("Datasourcename",getDatasourcename())
			.append("Note",getNote())
			.append("Packages",getPackages())
			.append("Port",getPort())
			.append("Protocol",getProtocol())
			.append("Registertime",getRegistertime())
			.append("Unitid",getUnitid())
			.toString();
	}
	
	public int hashCode() {
		return new HashCodeBuilder()
			.append(getClustergroup())
			.append(getIpaddress())
			.append(getDatasourcename())
			.append(getNote())
			.append(getPackages())
			.append(getPort())
			.append(getProtocol())
			.append(getRegistertime())
			.append(getUnitid())
			.toHashCode();
	}
	
	public boolean equals(Object obj) {
		if(obj instanceof Registers == false) return false;
		if(this == obj) return true;
		Registers other = (Registers)obj;
		return new EqualsBuilder()
			.append(getClustergroup(),other.getClustergroup())
			.append(getIpaddress(),other.getIpaddress())
			.append(getDatasourcename(),other.getDatasourcename())
			.append(getNote(),other.getNote())
			.append(getPackages(),other.getPackages())
			.append(getPort(),other.getPort())
			.append(getProtocol(),other.getProtocol())
			.append(getRegistertime(),other.getRegistertime())
			.append(getUnitid(),other.getUnitid())
			.isEquals();
	}
}

