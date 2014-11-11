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


public class Fcdydd extends BaseEntity {
	
	//alias
	public static final String TABLE_ALIAS = "房产质押典当";
	public static final String ALIAS_HTID = "当票编号";
	public static final String ALIAS_SQR = "申请人";
	public static final String ALIAS_D_NUMBER = "典当序号";
	public static final String ALIAS_ZJHM = "证件号码";
	public static final String ALIAS_GZDW = "工作单位";
	public static final String ALIAS_LXDH = "联系电话";
	public static final String ALIAS_FRDB = "法人代表";
	public static final String ALIAS_LB = "房产质押类别";
	public static final String ALIAS_FWQW = "房屋区位";
	public static final String ALIAS_DZ = "地址";
	public static final String ALIAS_FWSYQZH = "房屋所有权证号";
	public static final String ALIAS_JZMJ = "建筑面积";
	public static final String ALIAS_TDSYZH = "土地使用证号";
	public static final String ALIAS_ZDMJ = "占地面积";
	public static final String ALIAS_BXXZ = "保险险种";
	public static final String ALIAS_DDLB = "典当类别";
	public static final String ALIAS_DDQX = "典当期限";
	public static final String ALIAS_DWMS = "房产描述";
	public static final String ALIAS_REMARK = "备注";
	public static final String ALIAS_DDRQ = "典当日期";
	public static final String ALIAS_LRRQ = "录入日期";
	public static final String ALIAS_SDR = "收当人";
	public static final String ALIAS_SFSH = "是否赎回";
	public static final String ALIAS_TIB_FLOWGUID = "流程ID";
	public static final String ALIAS_TIB_ROWGUID = "记录ID";
	public static final String ALIAS_OPTIME = "操作时间";
	public static final String ALIAS_YXZJ = "有效证件";
	public static final String ALIAS_SQDDJE = "申请典当金额";
	public static final String ALIAS_FLAG = "记录标识";
	public static final String ALIAS_DDRYZP = "典当人员照片";
	public static final String ALIAS_DWMC = "典当单位";
	public static final String ALIAS_FJDM = "所属分局";
	public static final String ALIAS_PCSDM = "所属派出所";
	
	//date formats
	
	//columns START
	private String htid;
	private String sqr;
	private java.lang.String dnumber;
	private String zjhm;
	private String gzdw;
	private String lxdh;
	private String frdb;
	private String lb;
	private String fwqw;
	private String dz;
	private String fwsyqzh;
	private String jzmj;
	private String tdsyzh;
	private String zdmj;
	private String bxxz;
	private String ddlb;
	private String ddqx;
	private String dwms;
	private String remark;
	private String ddrq;
	private String lrrq;
	private String sdr;
	private String sfsh;
	private String tibFlowguid;
	private String tibRowguid;
	private String optime;
	private String yxzj;
	private Long sqddje;
	private String flag;
	private String dwmc;
	private String fjdm;
	private String pcsdm;
	private String dwdz;
	private String txxkzh;
	
	//columns END
	public void setDdrq(String ddrq) {
		this.ddrq = ddrq;
	}

	public String getDwdz() {
		return dwdz;
	}

	public void setDwdz(String dwdz) {
		this.dwdz = dwdz;
	}

	public String getTxxkzh() {
		return txxkzh;
	}

	public void setTxxkzh(String txxkzh) {
		this.txxkzh = txxkzh;
	}

	public Fcdydd(){
	}

	public Fcdydd(
		java.lang.String dnumber
	){
		this.dnumber = dnumber;
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

	public void setHtid(String value) {
		this.htid = value;
	}
	
	public String getHtid() {
		return this.htid;
	}
	public void setSqr(String value) {
		this.sqr = value;
	}
	
	public String getSqr() {
		return this.sqr;
	}
	public void setDnumber(java.lang.String value) {
		this.dnumber = value;
	}
	
	public java.lang.String getDnumber() {
		return this.dnumber;
	}
	public void setZjhm(String value) {
		this.zjhm = value;
	}
	
	public String getZjhm() {
		return this.zjhm;
	}
	public void setGzdw(String value) {
		this.gzdw = value;
	}
	
	public String getGzdw() {
		return this.gzdw;
	}
	public void setLxdh(String value) {
		this.lxdh = value;
	}
	
	public String getLxdh() {
		return this.lxdh;
	}
	public void setFrdb(String value) {
		this.frdb = value;
	}
	
	public String getFrdb() {
		return this.frdb;
	}
	public void setLb(String value) {
		this.lb = value;
	}
	
	public String getLb() {
		return this.lb;
	}
	public void setFwqw(String value) {
		this.fwqw = value;
	}
	
	public String getFwqw() {
		return this.fwqw;
	}
	public void setDz(String value) {
		this.dz = value;
	}
	
	public String getDz() {
		return this.dz;
	}
	public void setFwsyqzh(String value) {
		this.fwsyqzh = value;
	}
	
	public String getFwsyqzh() {
		return this.fwsyqzh;
	}
	public void setJzmj(String value) {
		this.jzmj = value;
	}
	
	public String getJzmj() {
		return this.jzmj;
	}
	public void setTdsyzh(String value) {
		this.tdsyzh = value;
	}
	
	public String getTdsyzh() {
		return this.tdsyzh;
	}
	public void setZdmj(String value) {
		this.zdmj = value;
	}
	
	public String getZdmj() {
		return this.zdmj;
	}
	public void setBxxz(String value) {
		this.bxxz = value;
	}
	
	public String getBxxz() {
		return this.bxxz;
	}
	public void setDdlb(String value) {
		this.ddlb = value;
	}
	
	public String getDdlb() {
		return this.ddlb;
	}
	public void setDdqx(String value) {
		this.ddqx = value;
	}
	
	public String getDdqx() {
		return this.ddqx;
	}
	public void setDwms(String value) {
		this.dwms = value;
	}
	
	public String getDwms() {
		return this.dwms;
	}
	public void setRemark(String value) {
		this.remark = value;
	}
	
	public String getRemark() {
		return this.remark;
	}

	
	public String getDdrq() {
		return this.ddrq;
	}
	public void setLrrq(String value) {
		this.lrrq = value;
	}
	
	public String getLrrq() {
		return this.lrrq;
	}
	public void setSdr(String value) {
		this.sdr = value;
	}
	
	public String getSdr() {
		return this.sdr;
	}
	public void setSfsh(String value) {
		this.sfsh = value;
	}
	
	public String getSfsh() {
		return this.sfsh;
	}
	public void setTibFlowguid(String value) {
		this.tibFlowguid = value;
	}
	
	public String getTibFlowguid() {
		return this.tibFlowguid;
	}
	public void setTibRowguid(String value) {
		this.tibRowguid = value;
	}
	
	public String getTibRowguid() {
		return this.tibRowguid;
	}
	public void setOptime(String value) {
		this.optime = value;
	}
	
	public String getOptime() {
		return this.optime;
	}
	public void setYxzj(String value) {
		this.yxzj = value;
	}
	
	public String getYxzj() {
		return this.yxzj;
	}
	public void setSqddje(Long value) {
		this.sqddje = value;
	}
	
	public Long getSqddje() {
		return this.sqddje;
	}
	public void setFlag(String value) {
		this.flag = value;
	}
	
	public String getFlag() {
		return this.flag;
	}
	public String getDwmc() {
		return dwmc;
	}

	public void setDwmc(String dwmc) {
		this.dwmc = dwmc;
	}

	public String toString() {
		return new ToStringBuilder(this)
			.append("Htid",getHtid())
			.append("Sqr",getSqr())
			.append("Dnumber",getDnumber())
			.append("Zjhm",getZjhm())
			.append("Gzdw",getGzdw())
			.append("Lxdh",getLxdh())
			.append("Frdb",getFrdb())
			.append("Lb",getLb())
			.append("Fwqw",getFwqw())
			.append("Dz",getDz())
			.append("Fwsyqzh",getFwsyqzh())
			.append("Jzmj",getJzmj())
			.append("Tdsyzh",getTdsyzh())
			.append("Zdmj",getZdmj())
			.append("Bxxz",getBxxz())
			.append("Ddlb",getDdlb())
			.append("Ddqx",getDdqx())
			.append("Dwms",getDwms())
			.append("Remark",getRemark())
			.append("Ddrq",getDdrq())
			.append("Lrrq",getLrrq())
			.append("Sdr",getSdr())
			.append("Sfsh",getSfsh())
			.append("TibFlowguid",getTibFlowguid())
			.append("TibRowguid",getTibRowguid())
			.append("Optime",getOptime())
			.append("Yxzj",getYxzj())
			.append("Sqddje",getSqddje())
			.append("Flag",getFlag())	
			.append("Dwmc",getDwmc())	
			.append("Fjdm",getFjdm())
			.append("Pcsdm",getPcsdm())
			.toString();
	}
	
	public int hashCode() {
		return new HashCodeBuilder()
			.append(getHtid())
			.append(getSqr())
			.append(getDnumber())
			.append(getZjhm())
			.append(getGzdw())
			.append(getLxdh())
			.append(getFrdb())
			.append(getLb())
			.append(getFwqw())
			.append(getDz())
			.append(getFwsyqzh())
			.append(getJzmj())
			.append(getTdsyzh())
			.append(getZdmj())
			.append(getBxxz())
			.append(getDdlb())
			.append(getDdqx())
			.append(getDwms())
			.append(getRemark())
			.append(getDdrq())
			.append(getLrrq())
			.append(getSdr())
			.append(getSfsh())
			.append(getTibFlowguid())
			.append(getTibRowguid())
			.append(getOptime())
			.append(getYxzj())
			.append(getSqddje())
			.append(getFlag())
			.append(getDwmc())
			.append(getFjdm())
			.append(getPcsdm())			
			.toHashCode();
	}
	
	public boolean equals(Object obj) {
		if(obj instanceof Fcdydd == false) return false;
		if(this == obj) return true;
		Fcdydd other = (Fcdydd)obj;
		return new EqualsBuilder()
			.append(getHtid(),other.getHtid())
			.append(getSqr(),other.getSqr())
			.append(getDnumber(),other.getDnumber())
			.append(getZjhm(),other.getZjhm())
			.append(getGzdw(),other.getGzdw())
			.append(getLxdh(),other.getLxdh())
			.append(getFrdb(),other.getFrdb())
			.append(getLb(),other.getLb())
			.append(getFwqw(),other.getFwqw())
			.append(getDz(),other.getDz())
			.append(getFwsyqzh(),other.getFwsyqzh())
			.append(getJzmj(),other.getJzmj())
			.append(getTdsyzh(),other.getTdsyzh())
			.append(getZdmj(),other.getZdmj())
			.append(getBxxz(),other.getBxxz())
			.append(getDdlb(),other.getDdlb())
			.append(getDdqx(),other.getDdqx())
			.append(getDwms(),other.getDwms())
			.append(getRemark(),other.getRemark())
			.append(getDdrq(),other.getDdrq())
			.append(getLrrq(),other.getLrrq())
			.append(getSdr(),other.getSdr())
			.append(getSfsh(),other.getSfsh())
			.append(getTibFlowguid(),other.getTibFlowguid())
			.append(getTibRowguid(),other.getTibRowguid())
			.append(getOptime(),other.getOptime())
			.append(getYxzj(),other.getYxzj())
			.append(getSqddje(),other.getSqddje())
			.append(getFlag(),other.getFlag())
			.append(getDwmc(),other.getDwmc())
			.append(getFjdm(),other.getFjdm())
			.append(getPcsdm(),other.getPcsdm())			
			.isEquals();
	}


}

