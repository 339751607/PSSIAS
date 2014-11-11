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


public class Tcsrxx extends BaseEntity {
	
	//alias
	public static final String TABLE_ALIAS = "出售通信录";
	public static final String ALIAS_ID = "id";
	public static final String ALIAS_IDCARD = "身份证号";
	public static final String ALIAS_CSRXM = "出售人姓名";
	public static final String ALIAS_CSRDH = "出售人联系电话";
	public static final String ALIAS_CPCODE = "企业代码";
	public static final String ALIAS_NPCODE = "身份证行政区划";
	public static final String ALIAS_NPADDRESS = "身份证详址";
	public static final String ALIAS_PRADDRESS="出售人现住址";
	public static final String ALLAS_HJDDRESS="出售人户籍地";
	//date formats
	
	//columns START
	private String idcard;
	private String csrxm;
	private String csrdh;;
	private String cpcode;
	//columns END
	private String npcode;
	private String npaddress;
	private String praddress;
	private String csrxb;
	private String uptime;
	private String hjaddress;
	
	public String getUptime() {
		return uptime;
	}

	public String getHjaddress() {
		return hjaddress;
	}

	public void setHjaddress(String hjaddress) {
		this.hjaddress = hjaddress;
	}

	public void setUptime(String uptime) {
		this.uptime = uptime;
	}

	public String getCsrxb() {
		return csrxb;
	}

	public void setCsrxb(String csrxb) {
		this.csrxb = csrxb;
	}

	public String getPraddress() {
		return praddress;
	}

	public void setPraddress(String praddress) {
		this.praddress = praddress;
	}

	public String getNpcode() {
		return npcode;
	}

	public void setNpcode(String npcode) {
		this.npcode = npcode;
	}

	public String getNpaddress() {
		return npaddress;
	}

	public void setNpaddress(String npaddress) {
		this.npaddress = npaddress;
	}

	public Tcsrxx(){
	}

	public Tcsrxx(
		String idcard
	){
		this.idcard = idcard;
	}


	public void setIdcard(String value) {
		this.idcard = value;
	}
	
	public String getIdcard() {
		return this.idcard;
	}
	public void setCsrxm(String value) {
		this.csrxm = value;
	}
	
	public String getCsrxm() {
		return this.csrxm;
	}
	public void setCsrdh(String value) {
		this.csrdh = value;
	}
	
	public String getCsrdh() {
		return this.csrdh;
	}

	public void setCpcode(String value) {
		this.cpcode = value;
	}
	
	public String getCpcode() {
		return this.cpcode;
	}

	public String toString() {
		return new ToStringBuilder(this)
			.append("Idcard",getIdcard())
			.append("Csrxm",getCsrxm())
			.append("Csrdh",getCsrdh())
			.append("Npcode",getNpcode())
			.append("Npaddress",getNpaddress())
			.append("Praddress",getPraddress())
			.append("Cpcode",getCpcode())
			.append("Csrxb",getCsrxb())
			.append("Uptime",getUptime())
			.append("Hjaddress",getHjaddress())
			.toString();
	}
	
	public int hashCode() {
		return new HashCodeBuilder()
			.append(getIdcard())
			.append(getCsrxm())
			.append(getCsrdh())
			.append(getCpcode())
			.append(getNpaddress())
			.append(getPraddress())
			.append(getCpcode())
			.append(getCsrxb())
			.append(getUptime())
			.append(getHjaddress())
			.toHashCode();
	}
	
	public boolean equals(Object obj) {
		if(obj instanceof Tcsrxx == false) return false;
		if(this == obj) return true;
		Tcsrxx other = (Tcsrxx)obj;
		return new EqualsBuilder()
			.append(getIdcard(),other.getIdcard())
			.append(getCsrxm(),other.getCsrxm())
			.append(getCsrdh(),other.getCsrdh())
			.append(getNpaddress(),other.getNpaddress())
			.append(getNpcode(),other.getNpcode())
			.append(getCpcode(),other.getCpcode())
			.append(getPraddress(),other.getPraddress())
			.append(getCsrxb(),other.getCsrxb())
			.append(getUptime(), other.getUptime())
			.append(getHjaddress(), this.getHjaddress())
			.isEquals();
	}
}

