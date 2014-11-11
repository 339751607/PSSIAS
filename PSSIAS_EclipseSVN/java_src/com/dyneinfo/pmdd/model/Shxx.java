/*
 * Powered By [lishicheng]
 */

package com.dyneinfo.pmdd.model;

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

import com.dyneinfo.pmdd.dao.*;
import com.dyneinfo.pmdd.model.*;
import com.dyneinfo.pmdd.service.*;

/**
 * @author lisc email:lishicheng(a)gmail.com
 */


public class Shxx extends BaseEntity {
	
	//alias
	public static final String TABLE_ALIAS = "典当赎回";
	public static final String ALIAS_D_NUMBER = "dnumber";
	public static final String ALIAS_HTID = "当票编号";
	public static final String ALIAS_SHRXM = "赎回人";
	public static final String ALIAS_SHRSFZHM = "证件号码";
	public static final String ALIAS_LXDH = "联系电话";
	public static final String ALIAS_GZDW = "工作单位";
	public static final String ALIAS_BZ = "备注";
	public static final String ALIAS_SHRQ = "赎回日期";
	public static final String ALIAS_TDR = "退当人";
	public static final String ALIAS_LRRQ = "录入日期";
	public static final String ALIAS_OPTIME = "操作时间";
	public static final String ALIAS_DDLX = "典当类型";
	public static final String ALIAS_SHRZP = "赎回人照片";
	public static final String ALIAS_FLAG = "标志";
	public static final String ALIAS_XH = "xh";
	public static final String ALIAS_DWMC = "典当单位";
	
	public static final String ALIAS_FJDM = "所属分局";
	public static final String ALIAS_PCSDM = "所属派出所";
	
	//date formats
	
	//columns START
	private String dnumber;
	private String htid;
	private String shrxm;
	private String shrsfzhm;
	private String lxdh;
	private String gzdw;
	private String bz;
	private String shrq;
	private String tdr;
	private String lrrq;
	private String optime;
	private String ddlx;
	private String flag;
	private java.lang.String xh;
	private String fjdm;
	private String pcsdm;
	private String dwmc;
	
	//columns END
	
	private String yxzj;//YXZJ
	

	public String getDwmc() {
		return dwmc;
	}

	public void setDwmc(String dwmc) {
		this.dwmc = dwmc;
	}

	public Shxx(){
	}

	public Shxx(
		java.lang.String xh
	){
		this.xh = xh;
	}

	public void setDnumber(String value) {
		this.dnumber = value;
	}
	
	public String getFjdm() {
		return fjdm;
	}

	public void setFjdm(String fjdm) {
		this.fjdm = fjdm;
	}

	public String getPcsdm() {
		return pcsdm;
	}

	public void setPcsdm(String pcsdm) {
		this.pcsdm = pcsdm;
	}

	public String getDnumber() {
		return this.dnumber;
	}
	public void setHtid(String value) {
		this.htid = value;
	}
	
	public String getHtid() {
		return this.htid;
	}
	public void setShrxm(String value) {
		this.shrxm = value;
	}
	
	public String getShrxm() {
		return this.shrxm;
	}
	public void setShrsfzhm(String value) {
		this.shrsfzhm = value;
	}
	
	public String getShrsfzhm() {
		return this.shrsfzhm;
	}
	public void setLxdh(String value) {
		this.lxdh = value;
	}
	
	public String getLxdh() {
		return this.lxdh;
	}
	public void setGzdw(String value) {
		this.gzdw = value;
	}
	
	public String getGzdw() {
		return this.gzdw;
	}
	public void setBz(String value) {
		this.bz = value;
	}
	
	public String getBz() {
		return this.bz;
	}
	public void setShrq(String value) {
		this.shrq = value;
	}
	
	public String getShrq() {
		return this.shrq;
	}
	public void setTdr(String value) {
		this.tdr = value;
	}
	
	public String getTdr() {
		return this.tdr;
	}
	public void setLrrq(String value) {
		this.lrrq = value;
	}
	
	public String getLrrq() {
		return this.lrrq;
	}
	public void setOptime(String value) {
		this.optime = value;
	}
	
	public String getOptime() {
		return this.optime;
	}
	public void setDdlx(String value) {
		this.ddlx = value;
	}
	
	public String getDdlx() {
		return this.ddlx;
	}
	public void setFlag(String value) {
		this.flag = value;
	}
	
	public String getFlag() {
		return this.flag;
	}
	public void setXh(java.lang.String value) {
		this.xh = value;
	}
	
	public java.lang.String getXh() {
		return this.xh;
	}

	public String toString() {
		return new ToStringBuilder(this)
			.append("Dnumber",getDnumber())
			.append("Htid",getHtid())
			.append("Shrxm",getShrxm())
			.append("Shrsfzhm",getShrsfzhm())
			.append("Lxdh",getLxdh())
			.append("Gzdw",getGzdw())
			.append("Bz",getBz())
			.append("Shrq",getShrq())
			.append("Tdr",getTdr())
			.append("Lrrq",getLrrq())
			.append("Optime",getOptime())
			.append("Ddlx",getDdlx())
			.append("Flag",getFlag())
			.append("Xh",getXh())
			.append("Fjdm",getFjdm())
			.append("Pcsdm",getPcsdm())
			.append("Yxzj",getYxzj())
			.toString();
	}
	
	public int hashCode() {
		return new HashCodeBuilder()
			.append(getDnumber())
			.append(getHtid())
			.append(getShrxm())
			.append(getShrsfzhm())
			.append(getLxdh())
			.append(getGzdw())
			.append(getBz())
			.append(getShrq())
			.append(getTdr())
			.append(getLrrq())
			.append(getOptime())
			.append(getDdlx())
			.append(getFlag())
			.append(getXh())
			.append(getFjdm())
			.append(getPcsdm())		
			.append(getYxzj())	
			.toHashCode();
	}
	
	public boolean equals(Object obj) {
		if(obj instanceof Shxx == false) return false;
		if(this == obj) return true;
		Shxx other = (Shxx)obj;
		return new EqualsBuilder()
			.append(getDnumber(),other.getDnumber())
			.append(getHtid(),other.getHtid())
			.append(getShrxm(),other.getShrxm())
			.append(getShrsfzhm(),other.getShrsfzhm())
			.append(getLxdh(),other.getLxdh())
			.append(getGzdw(),other.getGzdw())
			.append(getBz(),other.getBz())
			.append(getShrq(),other.getShrq())
			.append(getTdr(),other.getTdr())
			.append(getLrrq(),other.getLrrq())
			.append(getOptime(),other.getOptime())
			.append(getDdlx(),other.getDdlx())
			.append(getFlag(),other.getFlag())
			.append(getXh(),other.getXh())
			.append(getFjdm(),other.getFjdm())
			.append(getPcsdm(),other.getPcsdm())	
			.append(getYxzj(),other.getYxzj())	
			.isEquals();
	}

	public String getYxzj() {
		return yxzj;
	}

	public void setYxzj(String yxzj) {
		this.yxzj = yxzj;
	}
}

