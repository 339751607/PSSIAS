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


public class Pmdwxxb extends BaseEntity {
	
	//alias
	public static final String TABLE_ALIAS = "典当单位";
	public static final String ALIAS_TIB_FLOWGUID = "_流程ID";
	public static final String ALIAS_TIB_ROWGUID = "_记录ID";
	public static final String ALIAS_DWBM = "单位编码";
	public static final String ALIAS_OPTIME = "时间戳";
	public static final String ALIAS_DWMC = "单位名称";
	public static final String ALIAS_DWDZ = "单位地址";
	public static final String ALIAS_LXDH = "联系电话";
	public static final String ALIAS_CZ = "传真";
	public static final String ALIAS_YZBM = "邮政编码";
	public static final String ALIAS_KYRQ = "开业日期";
	public static final String ALIAS_DWZT = "单位状态";
	public static final String ALIAS_FRXM = "法人姓名";
	public static final String ALIAS_ZGBM = "主管部门";
	public static final String ALIAS_FZR = "负责人";
	public static final String ALIAS_ZAFZR = "治安负责人";
	public static final String ALIAS_BABDH = "保安部电话";
	public static final String ALIAS_JYFW = "经营范围";
	public static final String ALIAS_ZCZB = "注册资本";
	public static final String ALIAS_ZDMJ = "占地面积";
	public static final String ALIAS_TXXKZH = "特行许可证号";
	public static final String ALIAS_TXXKZFZDW = "特行许可证发证单位";
	public static final String ALIAS_YYZZBH = "营业执照编号";
	public static final String ALIAS_YYZZFZDW = "营业执照发证单位";
	public static final String ALIAS_FLAG = "记录标识";
	public static final String ALIAS_XZQHMC = "行政区划名称";
	public static final String ALIAS_XZQHDM = "行政区划代码";
	public static final String ALIAS_FJDM = "所属分局";
	public static final String ALIAS_PCSDM = "所属派出所";
	
	//date formats
	
	//columns START
	private java.lang.String tibFlowguid;
	private java.lang.String tibRowguid;
	private java.lang.String dwbm;
	private java.lang.String optime;
	private java.lang.String dwmc;
	private java.lang.String dwdz;
	private java.lang.String lxdh;
	private java.lang.String cz;
	private java.lang.String yzbm;
	private java.lang.String kyrq;
	private java.lang.String dwzt;
	private java.lang.String frxm;
	private java.lang.String zgbm;
	private java.lang.String fzr;
	private java.lang.String zafzr;
	private java.lang.String babdh;
	private java.lang.String jyfw;
	private java.lang.String zczb;
	private java.lang.String zdmj;
	private java.lang.String txxkzh;
	private java.lang.String txxkzfzdw;
	private java.lang.String yyzzbh;
	private java.lang.String yyzzfzdw;
	private java.lang.String flag;
	private java.lang.String xzqhmc;
	private java.lang.String xzqhdm;
	private java.lang.String fjdm;
	private java.lang.String pcsdm;
	private java.lang.String iscode;
	private java.lang.String smycode;
	private java.lang.String typecode;
	
	//columns END

	public java.lang.String getIscode() {
		return iscode;
	}

	public void setIscode(java.lang.String iscode) {
		this.iscode = iscode;
	}

	public java.lang.String getSmycode() {
		return smycode;
	}

	public void setSmycode(java.lang.String smycode) {
		this.smycode = smycode;
	}

	public java.lang.String getTypecode() {
		return typecode;
	}

	public void setTypecode(java.lang.String typecode) {
		this.typecode = typecode;
	}

	public Pmdwxxb(){
	}

	public Pmdwxxb(
		java.lang.String optime
	){
		this.optime = optime;
	}

	public void setTibFlowguid(java.lang.String value) {
		this.tibFlowguid = value;
	}
	
	public java.lang.String getTibFlowguid() {
		return this.tibFlowguid;
	}
	public void setTibRowguid(java.lang.String value) {
		this.tibRowguid = value;
	}
	
	public java.lang.String getTibRowguid() {
		return this.tibRowguid;
	}
	public void setDwbm(java.lang.String value) {
		this.dwbm = value;
	}
	
	public java.lang.String getDwbm() {
		return this.dwbm;
	}
	public void setOptime(java.lang.String value) {
		this.optime = value;
	}
	
	public java.lang.String getOptime() {
		return this.optime;
	}
	public void setDwmc(java.lang.String value) {
		this.dwmc = value;
	}
	
	public java.lang.String getDwmc() {
		return this.dwmc;
	}
	public void setDwdz(java.lang.String value) {
		this.dwdz = value;
	}
	
	public java.lang.String getDwdz() {
		return this.dwdz;
	}
	public void setLxdh(java.lang.String value) {
		this.lxdh = value;
	}
	
	public java.lang.String getLxdh() {
		return this.lxdh;
	}
	public void setCz(java.lang.String value) {
		this.cz = value;
	}
	
	public java.lang.String getCz() {
		return this.cz;
	}
	public void setYzbm(java.lang.String value) {
		this.yzbm = value;
	}
	
	public java.lang.String getYzbm() {
		return this.yzbm;
	}
	public void setKyrq(java.lang.String value) {
		this.kyrq = value;
	}
	
	public java.lang.String getKyrq() {
		return this.kyrq;
	}
	public void setDwzt(java.lang.String value) {
		this.dwzt = value;
	}
	
	public java.lang.String getDwzt() {
		return this.dwzt;
	}
	public void setFrxm(java.lang.String value) {
		this.frxm = value;
	}
	
	public java.lang.String getFrxm() {
		return this.frxm;
	}
	public void setZgbm(java.lang.String value) {
		this.zgbm = value;
	}
	
	public java.lang.String getZgbm() {
		return this.zgbm;
	}
	public void setFzr(java.lang.String value) {
		this.fzr = value;
	}
	
	public java.lang.String getFzr() {
		return this.fzr;
	}
	public void setZafzr(java.lang.String value) {
		this.zafzr = value;
	}
	
	public java.lang.String getZafzr() {
		return this.zafzr;
	}
	public void setBabdh(java.lang.String value) {
		this.babdh = value;
	}
	
	public java.lang.String getBabdh() {
		return this.babdh;
	}
	public void setJyfw(java.lang.String value) {
		this.jyfw = value;
	}
	
	public java.lang.String getJyfw() {
		return this.jyfw;
	}
	public void setZczb(java.lang.String value) {
		this.zczb = value;
	}
	
	public java.lang.String getZczb() {
		return this.zczb;
	}
	public void setZdmj(java.lang.String value) {
		this.zdmj = value;
	}
	
	public java.lang.String getZdmj() {
		return this.zdmj;
	}
	public void setTxxkzh(java.lang.String value) {
		this.txxkzh = value;
	}
	
	public java.lang.String getTxxkzh() {
		return this.txxkzh;
	}
	public void setTxxkzfzdw(java.lang.String value) {
		this.txxkzfzdw = value;
	}
	
	public java.lang.String getTxxkzfzdw() {
		return this.txxkzfzdw;
	}
	public void setYyzzbh(java.lang.String value) {
		this.yyzzbh = value;
	}
	
	public java.lang.String getYyzzbh() {
		return this.yyzzbh;
	}
	public void setYyzzfzdw(java.lang.String value) {
		this.yyzzfzdw = value;
	}
	
	public java.lang.String getYyzzfzdw() {
		return this.yyzzfzdw;
	}
	public void setFlag(java.lang.String value) {
		this.flag = value;
	}
	
	public java.lang.String getFlag() {
		return this.flag;
	}
	public void setXzqhmc(java.lang.String value) {
		this.xzqhmc = value;
	}
	
	public java.lang.String getXzqhmc() {
		return this.xzqhmc;
	}
	public void setXzqhdm(java.lang.String value) {
		this.xzqhdm = value;
	}
	
	public java.lang.String getXzqhdm() {
		return this.xzqhdm;
	}
	public void setFjdm(java.lang.String value) {
		this.fjdm = value;
	}
	
	public java.lang.String getFjdm() {
		return this.fjdm;
	}
	public void setPcsdm(java.lang.String value) {
		this.pcsdm = value;
	}
	
	public java.lang.String getPcsdm() {
		return this.pcsdm;
	}

	public String toString() {
		return new ToStringBuilder(this)
			.append("TibFlowguid",getTibFlowguid())
			.append("TibRowguid",getTibRowguid())
			.append("Dwbm",getDwbm())
			.append("Optime",getOptime())
			.append("Dwmc",getDwmc())
			.append("Dwdz",getDwdz())
			.append("Lxdh",getLxdh())
			.append("Cz",getCz())
			.append("Yzbm",getYzbm())
			.append("Kyrq",getKyrq())
			.append("Dwzt",getDwzt())
			.append("Frxm",getFrxm())
			.append("Zgbm",getZgbm())
			.append("Fzr",getFzr())
			.append("Zafzr",getZafzr())
			.append("Babdh",getBabdh())
			.append("Jyfw",getJyfw())
			.append("Zczb",getZczb())
			.append("Zdmj",getZdmj())
			.append("Txxkzh",getTxxkzh())
			.append("Txxkzfzdw",getTxxkzfzdw())
			.append("Yyzzbh",getYyzzbh())
			.append("Yyzzfzdw",getYyzzfzdw())
			.append("Flag",getFlag())
			.append("Xzqhmc",getXzqhmc())
			.append("Xzqhdm",getXzqhdm())
			.append("Fjdm",getFjdm())
			.append("Pcsdm",getPcsdm())
			.append("Iscode",getIscode())
			.append("Smycode",getSmycode())
			.append("Typecode",getTypecode())
			
			.toString();
	}
	
	public int hashCode() {
		return new HashCodeBuilder()
			.append(getTibFlowguid())
			.append(getTibRowguid())
			.append(getDwbm())
			.append(getOptime())
			.append(getDwmc())
			.append(getDwdz())
			.append(getLxdh())
			.append(getCz())
			.append(getYzbm())
			.append(getKyrq())
			.append(getDwzt())
			.append(getFrxm())
			.append(getZgbm())
			.append(getFzr())
			.append(getZafzr())
			.append(getBabdh())
			.append(getJyfw())
			.append(getZczb())
			.append(getZdmj())
			.append(getTxxkzh())
			.append(getTxxkzfzdw())
			.append(getYyzzbh())
			.append(getYyzzfzdw())
			.append(getFlag())
			.append(getXzqhmc())
			.append(getXzqhdm())
			.append(getFjdm())
			.append(getPcsdm())
			.append(getIscode())
			.append(getSmycode())
			.append(getTypecode())
			.toHashCode();
	}
	
	public boolean equals(Object obj) {
		if(obj instanceof Pmdwxxb == false) return false;
		if(this == obj) return true;
		Pmdwxxb other = (Pmdwxxb)obj;
		return new EqualsBuilder()
			.append(getTibFlowguid(),other.getTibFlowguid())
			.append(getTibRowguid(),other.getTibRowguid())
			.append(getDwbm(),other.getDwbm())
			.append(getOptime(),other.getOptime())
			.append(getDwmc(),other.getDwmc())
			.append(getDwdz(),other.getDwdz())
			.append(getLxdh(),other.getLxdh())
			.append(getCz(),other.getCz())
			.append(getYzbm(),other.getYzbm())
			.append(getKyrq(),other.getKyrq())
			.append(getDwzt(),other.getDwzt())
			.append(getFrxm(),other.getFrxm())
			.append(getZgbm(),other.getZgbm())
			.append(getFzr(),other.getFzr())
			.append(getZafzr(),other.getZafzr())
			.append(getBabdh(),other.getBabdh())
			.append(getJyfw(),other.getJyfw())
			.append(getZczb(),other.getZczb())
			.append(getZdmj(),other.getZdmj())
			.append(getTxxkzh(),other.getTxxkzh())
			.append(getTxxkzfzdw(),other.getTxxkzfzdw())
			.append(getYyzzbh(),other.getYyzzbh())
			.append(getYyzzfzdw(),other.getYyzzfzdw())
			.append(getFlag(),other.getFlag())
			.append(getXzqhmc(),other.getXzqhmc())
			.append(getXzqhdm(),other.getXzqhdm())
			.append(getFjdm(),other.getFjdm())
			.append(getPcsdm(),other.getPcsdm())
			.append(getIscode(), other.getIscode())
			.append(getSmycode(), other.getSmycode())
			.append(getTypecode(), other.getTypecode())
			.isEquals();
	}
}

