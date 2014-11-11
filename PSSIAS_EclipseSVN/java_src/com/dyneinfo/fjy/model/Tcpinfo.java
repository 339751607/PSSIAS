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


public class Tcpinfo extends BaseEntity {
	
	//alias
	public static final String TABLE_ALIAS = "企业";
	public static final String ALIAS_CPCODE = "企业代码";
	public static final String ALIAS_CPNAME = "企业名称";
	public static final String ALIAS_CPADRESS = "企业详细地址";
	public static final String ALIAS_CPTEL = "企业联系电话";
	public static final String ALIAS_AREA = "营业面积(平方米)";
	public static final String ALIAS_CPKIND = "企业性质";
	public static final String ALIAS_FRNAME = "企业法人代表";
	public static final String ALIAS_FRSEX = "法人性别";
	public static final String ALIAS_FRIDCODE = "法人身份证号";
	public static final String ALIAS_CPTYPE = "企业类型";
	public static final String ALIAS_CPSTATE = "企业状态";
	public static final String ALIAS_SSPCS = "所属公安机关";
	public static final String ALIAS_JYFW = "经营范围";
	public static final String ALIAS_ZAFZR = "治安负责人";
	public static final String ALIAS_ZAFZRDH = "治安负责人电话";
	public static final String ALIAS_KYSJ = "开业时间";
	public static final String ALIAS_CYRS = "从业人数";
	public static final String ALIAS_GSZZH = "营业执照号";
	public static final String ALIAS_ZCRQ = "注册日期";
	public static final String ALIAS_STATEGBSJ = "状态改变时间";
	public static final String ALIAS_CREATETIME="录入时间";
	public static final String ALIAS_CREATEUSERID="录入人";
	public static final String ALIAS_CREATEDEPTID="录入部门";
	public static final String ALIAS_SETUPFLAG="是否安装系统";
	public static final String ALIAS_SFGSZZH="是否办理营业执照";
	public static final String ALIAS_SFBAN="是否备案";
	
	
	//date formats
	
	//columns START
	private java.lang.String cpcode;
	private String cpname;
	private String cpadress;
	private String cptel;
	private String area;
	private String cpkind;
	private String frname;
	private String frsex;
	private String fridcode;
	private String cptype;
	private String cpstate;
	private String sspcs;
	private String jyfw;
	private String zafzr;
	private String zafzrdh;
	private String kysj;
	private Integer cyrs;
	private String gszzh;
	private String zcrq;
	private String stategbsj;//状态改变
	//columns END
	private String deptname;
	private String createtime;//录入时间
	private String createuserid;//录入人
	private String createdeptid;//录入部门
	private String setupflag;
	private String sfgszzh;
	private String sfban;
	private String iscode;
	private String typecode;
	private String orcmmcode;  //扫描仪授权码
	
	public String getTypecode() {
		return typecode;
	}

	public void setTypecode(String typecode) {
		this.typecode = typecode;
	}

	public String getIscode() {
		return iscode;
	}

	public void setIscode(String iscode) {
		this.iscode = iscode;
	}

	public String getSfgszzh() {
		return sfgszzh;
	}

	public void setSfgszzh(String sfgszzh) {
		this.sfgszzh = sfgszzh;
	}

	public String getSfban() {
		return sfban;
	}

	public void setSfban(String sfban) {
		this.sfban = sfban;
	}

	public Tcpinfo(){
	}

	public String getSetupflag() {
		return setupflag;
	}

	public void setSetupflag(String setupflag) {
		this.setupflag = setupflag;
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
	public void setCpadress(String value) {
		this.cpadress = value;
	}
	
	public String getCpadress() {
		return this.cpadress;
	}
	public void setCptel(String value) {
		this.cptel = value;
	}
	
	public String getCptel() {
		return this.cptel;
	}
	public void setArea(String value) {
		this.area = value;
	}
	
	public String getArea() {
		return this.area;
	}
	public void setCpkind(String value) {
		this.cpkind = value;
	}
	
	public String getCpkind() {
		return this.cpkind;
	}
	public void setFrname(String value) {
		this.frname = value;
	}
	
	public String getFrname() {
		return this.frname;
	}
	public void setFrsex(String value) {
		this.frsex = value;
	}
	
	public String getFrsex() {
		return this.frsex;
	}
	public void setFridcode(String value) {
		this.fridcode = value;
	}
	
	public String getFridcode() {
		return this.fridcode;
	}
	public void setCptype(String value) {
		this.cptype = value;
	}
	
	public String getCptype() {
		return this.cptype;
	}
	public void setCpstate(String value) {
		this.cpstate = value;
	}
	
	public String getCpstate() {
		return this.cpstate;
	}
	public void setSspcs(String value) {
		this.sspcs = value;
	}
	
	public String getSspcs() {
		return this.sspcs;
	}
	public void setJyfw(String value) {
		this.jyfw = value;
	}
	
	public String getJyfw() {
		return this.jyfw;
	}
	public void setZafzr(String value) {
		this.zafzr = value;
	}
	
	public String getZafzr() {
		return this.zafzr;
	}
	public void setZafzrdh(String value) {
		this.zafzrdh = value;
	}
	
	public String getZafzrdh() {
		return this.zafzrdh;
	}
	public void setKysj(String value) {
		this.kysj = value;
	}
	
	public String getKysj() {
		return this.kysj;
	}
	public void setCyrs(Integer value) {
		this.cyrs = value;
	}
	
	public Integer getCyrs() {
		return this.cyrs;
	}
	public void setGszzh(String value) {
		this.gszzh = value;
	}
	
	public String getGszzh() {
		return this.gszzh;
	}
	public void setZcrq(String value) {
		this.zcrq = value;
	}
	
	public String getZcrq() {
		return this.zcrq;
	}

	public String toString() {
		return new ToStringBuilder(this)
			.append("Cpcode",getCpcode())
			.append("Cpname",getCpname())
			.append("Cpadress",getCpadress())
			.append("Cptel",getCptel())
			.append("Area",getArea())
			.append("Cpkind",getCpkind())
			.append("Frname",getFrname())
			.append("Frsex",getFrsex())
			.append("Fridcode",getFridcode())
			.append("Cptype",getCptype())
			.append("Cpstate",getCpstate())
			.append("Sspcs",getSspcs())
			.append("Jyfw",getJyfw())
			.append("Zafzr",getZafzr())
			.append("Zafzrdh",getZafzrdh())
			.append("Kysj",getKysj())
			.append("Cyrs",getCyrs())
			.append("Gszzh",getGszzh())
			.append("Zcrq",getZcrq())
			.append("Stategbsj",getStategbsj())
			.append("iscode",getIscode())
			.append("typecode",getTypecode())
			.toString();
	}
	
	public int hashCode() {
		return new HashCodeBuilder()
			.append(getCpcode())
			.append(getCpname())
			.append(getCpadress())
			.append(getCptel())
			.append(getArea())
			.append(getCpkind())
			.append(getFrname())
			.append(getFrsex())
			.append(getFridcode())
			.append(getCptype())
			.append(getCpstate())
			.append(getSspcs())
			.append(getJyfw())
			.append(getZafzr())
			.append(getZafzrdh())
			.append(getKysj())
			.append(getCyrs())
			.append(getGszzh())
			.append(getZcrq())
			.append(getStategbsj())
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
			.append(getCpadress(),other.getCpadress())
			.append(getCptel(),other.getCptel())
			.append(getArea(),other.getArea())
			.append(getCpkind(),other.getCpkind())
			.append(getFrname(),other.getFrname())
			.append(getFrsex(),other.getFrsex())
			.append(getFridcode(),other.getFridcode())
			.append(getCptype(),other.getCptype())
			.append(getCpstate(),other.getCpstate())
			.append(getSspcs(),other.getSspcs())
			.append(getJyfw(),other.getJyfw())
			.append(getZafzr(),other.getZafzr())
			.append(getZafzrdh(),other.getZafzrdh())
			.append(getKysj(),other.getKysj())
			.append(getCyrs(),other.getCyrs())
			.append(getGszzh(),other.getGszzh())
			.append(getZcrq(),other.getZcrq())
			.append(getStategbsj(),other.getStategbsj())
			.append(getIscode(), other.getIscode())
			.append(getTypecode(), other.getTypecode())
			.isEquals();
	}

	public String getDeptname() {
		return deptname;
	}

	public void setDeptname(String deptname) {
		this.deptname = deptname;
	}

	public String getStategbsj() {
		return stategbsj;
	}

	public void setStategbsj(String stategbsj) {
		this.stategbsj = stategbsj;
	}

	public String getCreatetime() {
		return createtime;
	}

	public void setCreatetime(String createtime) {
		this.createtime = createtime;
	}

	public String getCreateuserid() {
		return createuserid;
	}

	public void setCreateuserid(String createuserid) {
		this.createuserid = createuserid;
	}

	public String getCreatedeptid() {
		return createdeptid;
	}

	public void setCreatedeptid(String createdeptid) {
		this.createdeptid = createdeptid;
	}

	public String getOrcmmcode() {
		return orcmmcode;
	}

	public void setOrcmmcode(String orcmmcode) {
		this.orcmmcode = orcmmcode;
	}
}

