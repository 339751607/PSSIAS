/*
 * Powered By [lishicheng]
 */

package com.dyneinfo.pmdd.model;

import javacommon.base.BaseEntity;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

/**
 * @author lisc email:lishicheng(a)gmail.com
 */


public class Clzydd extends BaseEntity {
	
	//alias
	public static final String TABLE_ALIAS = "车辆质押典当";
	public static final String ALIAS_HTID = "当票编号";
	public static final String ALIAS_SQR = "申请人";
	public static final String ALIAS_D_NUMBER = "典当序号";
	public static final String ALIAS_ZJHM = "证件号码";
	public static final String ALIAS_GZDW = "工作单位";
	public static final String ALIAS_LXDH = "联系电话";
	public static final String ALIAS_DZ = "地址";
	public static final String ALIAS_XSZ_DZ = "行驶证地址";
	public static final String ALIAS_CPHM = "车牌号码";
	public static final String ALIAS_CZMC = "车主名称";
	public static final String ALIAS_FDJH = "发动机号";
	public static final String ALIAS_SCCJ = "厂牌型号";
	public static final String ALIAS_CJHM = "车辆识别码";
	public static final String ALIAS_CSYS = "车身颜色";
	public static final String ALIAS_CLXH = "车辆型号";
	public static final String ALIAS_YXSGLS = "已行驶公里数";
	public static final String ALIAS_FRDB = "法人代表";
	public static final String ALIAS_DDLX = "典当类型";
	public static final String ALIAS_DDQX = "典当期限";
	public static final String ALIAS_DWMS = "车辆描述";
	public static final String ALIAS_REMARK = "备注";
	public static final String ALIAS_DDRQ = "典当日期";
	public static final String ALIAS_LRRQ = "录入日期";
	public static final String ALIAS_SDR = "收当人";
	public static final String ALIAS_TIB_FLOWGUID = "流程ID";
	public static final String ALIAS_TIB_ROWGUID = "记录ID";
	public static final String ALIAS_OPTIME = "操作时间";
	public static final String ALIAS_SQDDJE = "申请典当金额";
	public static final String ALIAS_YXZJ = "有效证件";
	public static final String ALIAS_FLAG = "记录标识";
	public static final String ALIAS_LB = "车辆质押类别";
	public static final String ALIAS_SFSH = "是否赎回";
	public static final String ALIAS_DDRYZP = "典当人员照片";
	public static final String ALIAS_DWZP = "车辆照片";
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
	private String dz;
	private String cphm;
	private String czmc;
	private String fdjh;
	private String sccj;
	private String cjhm;
	private String csys;
	private String clxh;
	private String yxsgls;
	private String frdb;
	private String ddlx;
	private String ddqx;
	private String dwms;
	private String remark;
	private String ddrq;
	private String lrrq;
	private String sdr;
	private String tibFlowguid;
	private String tibRowguid;
	private String optime;
	private Long sqddje;
	private String yxzj;
	private String flag;
	private String lb;
	private String sfsh;
	private String dwmc;
	private String fjdm;
	private String pcsdm;
	private String xszdz;
	//columns END

	public String getXszdz() {
		return xszdz;
	}

	public void setXszdz(String xszdz) {
		this.xszdz = xszdz;
	}

	public Clzydd(){
	}

	public Clzydd(
		java.lang.String dnumber
	){
		this.dnumber = dnumber;
	}

	public void setHtid(String value) {
		this.htid = value;
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
	public void setDz(String value) {
		this.dz = value;
	}
	
	public String getDz() {
		return this.dz;
	}
	public void setCphm(String value) {
		this.cphm = value;
	}
	
	public String getCphm() {
		return this.cphm;
	}
	public void setCzmc(String value) {
		this.czmc = value;
	}
	
	public String getCzmc() {
		return this.czmc;
	}
	public void setFdjh(String value) {
		this.fdjh = value;
	}
	
	public String getFdjh() {
		return this.fdjh;
	}
	public void setSccj(String value) {
		this.sccj = value;
	}
	
	public String getSccj() {
		return this.sccj;
	}
	public void setCjhm(String value) {
		this.cjhm = value;
	}
	
	public String getCjhm() {
		return this.cjhm;
	}
	public void setCsys(String value) {
		this.csys = value;
	}
	
	public String getCsys() {
		return this.csys;
	}
	public void setClxh(String value) {
		this.clxh = value;
	}
	
	public String getClxh() {
		return this.clxh;
	}
	public void setYxsgls(String value) {
		this.yxsgls = value;
	}
	
	public String getYxsgls() {
		return this.yxsgls;
	}
	public void setFrdb(String value) {
		this.frdb = value;
	}
	
	public String getFrdb() {
		return this.frdb;
	}
	public void setDdlx(String value) {
		this.ddlx = value;
	}
	
	public String getDdlx() {
		return this.ddlx;
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
	public void setDdrq(String value) {
		this.ddrq = value;
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
	public void setSqddje(Long value) {
		this.sqddje = value;
	}
	
	public Long getSqddje() {
		return this.sqddje;
	}
	public void setYxzj(String value) {
		this.yxzj = value;
	}
	
	public String getYxzj() {
		return this.yxzj;
	}
	public void setFlag(String value) {
		this.flag = value;
	}
	
	public String getFlag() {
		return this.flag;
	}
	public void setLb(String value) {
		this.lb = value;
	}
	
	public String getLb() {
		return this.lb;
	}
	public void setSfsh(String value) {
		this.sfsh = value;
	}
	
	public String getSfsh() {
		return this.sfsh;
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
			.append("Dz",getDz())
			.append("Cphm",getCphm())
			.append("Czmc",getCzmc())
			.append("Fdjh",getFdjh())
			.append("Sccj",getSccj())
			.append("Cjhm",getCjhm())
			.append("Csys",getCsys())
			.append("Clxh",getClxh())
			.append("Yxsgls",getYxsgls())
			.append("Frdb",getFrdb())
			.append("Ddlx",getDdlx())
			.append("Ddqx",getDdqx())
			.append("Dwms",getDwms())
			.append("Remark",getRemark())
			.append("Ddrq",getDdrq())
			.append("Lrrq",getLrrq())
			.append("Sdr",getSdr())
			.append("TibFlowguid",getTibFlowguid())
			.append("TibRowguid",getTibRowguid())
			.append("Optime",getOptime())
			.append("Sqddje",getSqddje())
			.append("Yxzj",getYxzj())
			.append("Flag",getFlag())
			.append("Lb",getLb())
			.append("Sfsh",getSfsh())
			.append("Dwmc",getSfsh())
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
			.append(getDz())
			.append(getCphm())
			.append(getCzmc())
			.append(getFdjh())
			.append(getSccj())
			.append(getCjhm())
			.append(getCsys())
			.append(getClxh())
			.append(getYxsgls())
			.append(getFrdb())
			.append(getDdlx())
			.append(getDdqx())
			.append(getDwms())
			.append(getRemark())
			.append(getDdrq())
			.append(getLrrq())
			.append(getSdr())
			.append(getTibFlowguid())
			.append(getTibRowguid())
			.append(getOptime())
			.append(getSqddje())
			.append(getYxzj())
			.append(getFlag())
			.append(getLb())
			.append(getSfsh())
			.append(getDwmc())
			.append(getFjdm())
			.append(getPcsdm())
			.toHashCode();
	}
	
	public boolean equals(Object obj) {
		if(obj instanceof Clzydd == false) return false;
		if(this == obj) return true;
		Clzydd other = (Clzydd)obj;
		return new EqualsBuilder()
			.append(getHtid(),other.getHtid())
			.append(getSqr(),other.getSqr())
			.append(getDnumber(),other.getDnumber())
			.append(getZjhm(),other.getZjhm())
			.append(getGzdw(),other.getGzdw())
			.append(getLxdh(),other.getLxdh())
			.append(getDz(),other.getDz())
			.append(getCphm(),other.getCphm())
			.append(getCzmc(),other.getCzmc())
			.append(getFdjh(),other.getFdjh())
			.append(getSccj(),other.getSccj())
			.append(getCjhm(),other.getCjhm())
			.append(getCsys(),other.getCsys())
			.append(getClxh(),other.getClxh())
			.append(getYxsgls(),other.getYxsgls())
			.append(getFrdb(),other.getFrdb())
			.append(getDdlx(),other.getDdlx())
			.append(getDdqx(),other.getDdqx())
			.append(getDwms(),other.getDwms())
			.append(getRemark(),other.getRemark())
			.append(getDdrq(),other.getDdrq())
			.append(getLrrq(),other.getLrrq())
			.append(getSdr(),other.getSdr())
			.append(getTibFlowguid(),other.getTibFlowguid())
			.append(getTibRowguid(),other.getTibRowguid())
			.append(getOptime(),other.getOptime())
			.append(getSqddje(),other.getSqddje())
			.append(getYxzj(),other.getYxzj())
			.append(getFlag(),other.getFlag())
			.append(getLb(),other.getLb())
			.append(getSfsh(),other.getSfsh())
			.append(getDwmc(),other.getDwmc())
			.append(getFjdm(),other.getFjdm())
			.append(getPcsdm(),other.getPcsdm())
			.isEquals();
	}


}

