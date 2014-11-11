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


public class Tlinkmaninfo extends BaseEntity {
	
	//alias
	public static final String TABLE_ALIAS = "应急联系人信息表";
	public static final String ALIAS_LINKMANID = "联系人ID";
	public static final String ALIAS_EMPCODE = "人员编号";
	public static final String ALIAS_LINKMAN = "联系人姓名";
	public static final String ALIAS_IDCODE = "身份证号码";
	public static final String ALIAS_SEX = "性别";
	public static final String ALIAS_JOBORDWELL = "工作单位或住址";
	public static final String ALIAS_COMMADDRESS = "通讯地址";
	public static final String ALIAS_PHONE = "联系电话";
	public static final String ALIAS_RELATION = "与本人关系";
	
	//date formats
	
	//columns START
	private java.lang.String linkmanid;
	private String empcode;
	private String linkman;
	private String idcode;
	private String sex;
	private String jobordwell;
	private String commaddress;
	private String phone;
	private String relation;
	//columns END

	public Tlinkmaninfo(){
	}

	public Tlinkmaninfo(
		java.lang.String linkmanid
	){
		this.linkmanid = linkmanid;
	}

	public void setLinkmanid(java.lang.String value) {
		this.linkmanid = value;
	}
	
	public java.lang.String getLinkmanid() {
		return this.linkmanid;
	}
	public void setEmpcode(String value) {
		this.empcode = value;
	}
	
	public String getEmpcode() {
		return this.empcode;
	}
	public void setLinkman(String value) {
		this.linkman = value;
	}
	
	public String getLinkman() {
		return this.linkman;
	}
	public void setIdcode(String value) {
		this.idcode = value;
	}
	
	public String getIdcode() {
		return this.idcode;
	}
	public void setSex(String value) {
		this.sex = value;
	}
	
	public String getSex() {
		return this.sex;
	}
	public void setJobordwell(String value) {
		this.jobordwell = value;
	}
	
	public String getJobordwell() {
		return this.jobordwell;
	}
	public void setCommaddress(String value) {
		this.commaddress = value;
	}
	
	public String getCommaddress() {
		return this.commaddress;
	}
	public void setPhone(String value) {
		this.phone = value;
	}
	
	public String getPhone() {
		return this.phone;
	}
	public void setRelation(String value) {
		this.relation = value;
	}
	
	public String getRelation() {
		return this.relation;
	}

	public String toString() {
		return new ToStringBuilder(this)
			.append("Linkmanid",getLinkmanid())
			.append("Empcode",getEmpcode())
			.append("Linkman",getLinkman())
			.append("Idcode",getIdcode())
			.append("Sex",getSex())
			.append("Jobordwell",getJobordwell())
			.append("Commaddress",getCommaddress())
			.append("Phone",getPhone())
			.append("Relation",getRelation())
			.toString();
	}
	
	public int hashCode() {
		return new HashCodeBuilder()
			.append(getLinkmanid())
			.append(getEmpcode())
			.append(getLinkman())
			.append(getIdcode())
			.append(getSex())
			.append(getJobordwell())
			.append(getCommaddress())
			.append(getPhone())
			.append(getRelation())
			.toHashCode();
	}
	
	public boolean equals(Object obj) {
		if(obj instanceof Tlinkmaninfo == false) return false;
		if(this == obj) return true;
		Tlinkmaninfo other = (Tlinkmaninfo)obj;
		return new EqualsBuilder()
			.append(getLinkmanid(),other.getLinkmanid())
			.append(getEmpcode(),other.getEmpcode())
			.append(getLinkman(),other.getLinkman())
			.append(getIdcode(),other.getIdcode())
			.append(getSex(),other.getSex())
			.append(getJobordwell(),other.getJobordwell())
			.append(getCommaddress(),other.getCommaddress())
			.append(getPhone(),other.getPhone())
			.append(getRelation(),other.getRelation())
			.isEquals();
	}
}

