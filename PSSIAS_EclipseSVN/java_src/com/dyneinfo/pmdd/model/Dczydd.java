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


public class Dczydd extends BaseEntity {
	
	//alias
	public static final String TABLE_ALIAS = "动产质押典当";
	public static final String ALIAS_HTID = "当票编号";
	public static final String ALIAS_SQR = "申请人";
	public static final String ALIAS_D_NUMBER = "典当序号";
	public static final String ALIAS_ZJHM = "证件号码";
	public static final String ALIAS_DZ = "地址";
	public static final String ALIAS_GZDW = "工作单位";
	public static final String ALIAS_LXDH = "联系电话";
	public static final String ALIAS_DWMC = "当物名称";
	public static final String ALIAS_DDLX = "典当类别";
	public static final String ALIAS_DWZJ = "当物证件";
	public static final String ALIAS_FLAG = "动产质押类别";
	public static final String ALIAS_DDQX = "典当期限";
	public static final String ALIAS_DWMS = "当物描述";
	public static final String ALIAS_REMARK = "备注";
	public static final String ALIAS_DDRQ = "典当日期";
	public static final String ALIAS_LRRQ = "录入日期";
	public static final String ALIAS_SDR = "收当人";
	public static final String ALIAS_TIB_FLOWGUID = "流程ID";
	public static final String ALIAS_TIB_ROWGUID = "记录ID";
	public static final String ALIAS_OPTIME = "操作时间";
	public static final String ALIAS_FRDB = "法人代表";
	public static final String ALIAS_YXZJ = "有效证件";
	public static final String ALIAS_SQDDJE = "申请典当金额";
	public static final String ALIAS_SFSH = "是否赎回";
	public static final String ALIAS_DW = "典当单位";
	public static final String ALIAS_FJDM = "所属分局";
	public static final String ALIAS_PCSDM = "所属派出所";
	public static final String ALIAS_WPPP = "品牌";
	public static final String ALIAS_WPGG = "规格";
	public static final String ALIAS_WPZL = "重量";
	public static final String ALIAS_WPXZ = "形状特征";
	public static final String ALIAS_WPLYQKSM = "物品来源情况说明";
	public static final String ALIAS_WPCQZMCL = "产权证明材料";
	public static final String ALIAS_DDRYZP = "典当人员照片";
	public static final String ALIAS_DWZP ="单位照片";
	//品牌 规格 重量 形状特征 物品来源情况说明 产权证明材料
	
	
	//date formats
	
	//columns START
	private String htid;
	private String sqr;
	private java.lang.String dnumber;
	private String zjhm;
	private String dz;
	private String gzdw;
	private String lxdh;
	private String dwmc;
	private String ddlx;
	private String dwzj;
	private String flag;
	private String ddqx;
	private String dwms;
	private String remark;
	private String ddrq;
	private String lrrq;
	private String sdr;
	private String tibFlowguid;
	private String tibRowguid;
	private String optime;
	private String frdb;
	private String yxzj;
	private Long sqddje;
	private String sfsh;
	private String dw;
	private String fjdm;
	private String pcsdm;
	private String dwdz;
	private String txxkzh;
	

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

	private java.lang.String wppp;
	private java.lang.String wpgg;
	private java.lang.String wpzl;
	private java.lang.String wpxz;
	private java.lang.String wplyqksm;
	private java.lang.String wpcqzmcl;
	
	//columns END

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

	public Dczydd(){
	}

	public Dczydd(
		java.lang.String dnumber
	){
		this.dnumber = dnumber;
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
	public void setDz(String value) {
		this.dz = value;
	}
	
	public String getDz() {
		return this.dz;
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
	public void setDwmc(String value) {
		this.dwmc = value;
	}
	
	public String getDwmc() {
		return this.dwmc;
	}
	public void setDdlx(String value) {
		this.ddlx = value;
	}
	
	public String getDdlx() {
		return this.ddlx;
	}
	public void setDwzj(String value) {
		this.dwzj = value;
	}
	
	public String getDwzj() {
		return this.dwzj;
	}
	public void setFlag(String value) {
		this.flag = value;
	}
	
	public String getFlag() {
		return this.flag;
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
	public void setFrdb(String value) {
		this.frdb = value;
	}
	
	public String getFrdb() {
		return this.frdb;
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
	public void setSfsh(String value) {
		this.sfsh = value;
	}
	
	public String getSfsh() {
		return this.sfsh;
	}
	

	public String toString() {
		return new ToStringBuilder(this)
			.append("Htid",getHtid())
			.append("Sqr",getSqr())
			.append("Dnumber",getDnumber())
			.append("Zjhm",getZjhm())
			.append("Dz",getDz())
			.append("Gzdw",getGzdw())
			.append("Lxdh",getLxdh())
			.append("Dwmc",getDwmc())
			.append("Ddlx",getDdlx())
			.append("Dwzj",getDwzj())
			.append("Flag",getFlag())
			.append("Ddqx",getDdqx())
			.append("Dwms",getDwms())
			.append("Remark",getRemark())
			.append("Ddrq",getDdrq())
			.append("Lrrq",getLrrq())
			.append("Sdr",getSdr())
			.append("TibFlowguid",getTibFlowguid())
			.append("TibRowguid",getTibRowguid())
			.append("Optime",getOptime())
			.append("Frdb",getFrdb())
			.append("Yxzj",getYxzj())
			.append("Sqddje",getSqddje())
			.append("Sfsh",getSfsh())
			.append("Dw",getDw())
			.append("Fjdm",getFjdm())
			.append("Pcsdm",getPcsdm())
			.append("Wppp",getWppp())
			.append("Wpgg",getWpgg())
			.append("Wpzl",getWpzl())
			.append("Wpxz",getWpxz())
			.append("Wplyqksm",getWplyqksm())
			.append("Wpcqzmcl",getWpcqzmcl())
			.toString();
	}
	
	public int hashCode() {
		return new HashCodeBuilder()
			.append(getHtid())
			.append(getSqr())
			.append(getDnumber())
			.append(getZjhm())
			.append(getDz())
			.append(getGzdw())
			.append(getLxdh())
			.append(getDwmc())
			.append(getDdlx())
			.append(getDwzj())
			.append(getFlag())
			.append(getDdqx())
			.append(getDwms())
			.append(getRemark())
			.append(getDdrq())
			.append(getLrrq())
			.append(getSdr())
			.append(getTibFlowguid())
			.append(getTibRowguid())
			.append(getOptime())
			.append(getFrdb())
			.append(getYxzj())
			.append(getSqddje())
			.append(getSfsh())
			.append(getDw())
			.append(getFjdm())
			.append(getPcsdm())
			.append(getWppp())
			.append(getWpgg())
			.append(getWpzl())
			.append(getWpxz())
			.append(getWplyqksm())
			.append(getWpcqzmcl())
			.toHashCode();
	}
	
	public boolean equals(Object obj) {
		if(obj instanceof Dczydd == false) return false;
		if(this == obj) return true;
		Dczydd other = (Dczydd)obj;
		return new EqualsBuilder()
			.append(getHtid(),other.getHtid())
			.append(getSqr(),other.getSqr())
			.append(getDnumber(),other.getDnumber())
			.append(getZjhm(),other.getZjhm())
			.append(getDz(),other.getDz())
			.append(getGzdw(),other.getGzdw())
			.append(getLxdh(),other.getLxdh())
			.append(getDwmc(),other.getDwmc())
			.append(getDdlx(),other.getDdlx())
			.append(getDwzj(),other.getDwzj())
			.append(getFlag(),other.getFlag())
			.append(getDdqx(),other.getDdqx())
			.append(getDwms(),other.getDwms())
			.append(getRemark(),other.getRemark())
			.append(getDdrq(),other.getDdrq())
			.append(getLrrq(),other.getLrrq())
			.append(getSdr(),other.getSdr())
			.append(getTibFlowguid(),other.getTibFlowguid())
			.append(getTibRowguid(),other.getTibRowguid())
			.append(getOptime(),other.getOptime())
			.append(getFrdb(),other.getFrdb())
			.append(getYxzj(),other.getYxzj())
			.append(getSqddje(),other.getSqddje())
			.append(getSfsh(),other.getSfsh())
			.append(getDw(),other.getDw())
			.append(getFjdm(),other.getFjdm())
			.append(getPcsdm(),other.getPcsdm())
			.append(getWppp(),other.getWppp())
			.append(getWpgg(),other.getWpgg())
			.append(getWpzl(),other.getWpzl())
			.append(getWpxz(),other.getWpxz())
			.append(getWplyqksm(),other.getWplyqksm())
			.append(getWpcqzmcl(),other.getWpcqzmcl())
			.isEquals();
	}

	public String getDw() {
		return dw;
	}

	public void setDw(String dw) {
		this.dw = dw;
	}

	public java.lang.String getWppp() {
		return wppp;
	}

	public void setWppp(java.lang.String wppp) {
		this.wppp = wppp;
	}

	public java.lang.String getWpgg() {
		return wpgg;
	}

	public void setWpgg(java.lang.String wpgg) {
		this.wpgg = wpgg;
	}

	public java.lang.String getWpzl() {
		return wpzl;
	}

	public void setWpzl(java.lang.String wpzl) {
		this.wpzl = wpzl;
	}

	public java.lang.String getWpxz() {
		return wpxz;
	}

	public void setWpxz(java.lang.String wpxz) {
		this.wpxz = wpxz;
	}

	public java.lang.String getWplyqksm() {
		return wplyqksm;
	}

	public void setWplyqksm(java.lang.String wplyqksm) {
		this.wplyqksm = wplyqksm;
	}

	public java.lang.String getWpcqzmcl() {
		return wpcqzmcl;
	}

	public void setWpcqzmcl(java.lang.String wpcqzmcl) {
		this.wpcqzmcl = wpcqzmcl;
	}

}

