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


public class TelInfo extends BaseEntity {
	
	//alias
	public static final String TABLE_ALIAS = "二手手机";
	public static final String ALIAS_TELINFOID = "序号";
	public static final String ALIAS_TELPP = "手机品牌";
	public static final String ALIAS_TELXH = "手机型号";
	public static final String ALIAS_TELYS = "手机颜色";
	public static final String ALIAS_JXXLH = "手机串号(IMEI)";
	public static final String ALIAS_SJLB = "手机类别";
	public static final String ALIAS_BZ = "购买信息";
	public static final String ALIAS_CPCODE = "收购企业代码";
	public static final String ALIAS_CHUSHOURY = "出售人姓名";
	public static final String ALIAS_CHUSHOURENXB = "出售人性别";
	public static final String ALIAS_CHUSHOURENSFZH = "出售人身份证号";
	public static final String ALIAS_BEIZHU = "备注";
	public static final String ALIAS_CHUSHOURENLXDH = "出售人联系电话";
	public static final String ALIAS_SGSJ = "登记时间";
	public static final String ALIAS_DQSJH = "出售人当前手机号";
	public static final String ALIAS_CSRJTZZ = "出售人现住址";
	public static final String ALIAS_CSRDH = "出售人传真";
	public static final String ALIAS_GJSJ = "购机时间";
	public static final String ALIAS_JBR = "经办人";
	
	//date formats
	public static final String FORMAT_SGSJ = DATE_TIME_FORMAT;
	
	//columns START
	private java.lang.String telinfoid;
	private String telpp;
	private String telxh;
	private String telys;
	private String jxxlh;
	private String sjlb;
	private String bz;
	private String cpcode;
	private String chushoury;
	private String chushourenxb;
	private String chushourensfzh;
	private String beizhu;
	private String chushourenlxdh;
	private java.util.Date sgsj;
	private String dqsjh;
	private String csrjtzz;
	private String csrdh;
	private String gjsj;
	private String jbr;
	//columns END

	public TelInfo(){
	}

	public TelInfo(
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
	public void setTelpp(String value) {
		this.telpp = value;
	}
	
	public String getTelpp() {
		return this.telpp;
	}
	public void setTelxh(String value) {
		this.telxh = value;
	}
	
	public String getTelxh() {
		return this.telxh;
	}
	public void setTelys(String value) {
		this.telys = value;
	}
	
	public String getTelys() {
		return this.telys;
	}
	public void setJxxlh(String value) {
		this.jxxlh = value;
	}
	
	public String getJxxlh() {
		return this.jxxlh;
	}
	public void setSjlb(String value) {
		this.sjlb = value;
	}
	
	public String getSjlb() {
		return this.sjlb;
	}
	public void setBz(String value) {
		this.bz = value;
	}
	
	public String getBz() {
		return this.bz;
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
	public void setGjsj(String value) {
		this.gjsj = value;
	}
	
	public String getGjsj() {
		return this.gjsj;
	}
	public void setJbr(String value) {
		this.jbr = value;
	}
	
	public String getJbr() {
		return this.jbr;
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
			.toHashCode();
	}
	
	public boolean equals(Object obj) {
		if(obj instanceof TelInfo == false) return false;
		if(this == obj) return true;
		TelInfo other = (TelInfo)obj;
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
			.isEquals();
	}
}

