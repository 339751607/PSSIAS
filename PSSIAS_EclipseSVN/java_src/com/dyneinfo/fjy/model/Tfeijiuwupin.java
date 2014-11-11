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


public class Tfeijiuwupin extends BaseEntity {
	
	//alias
	public static final String TABLE_ALIAS = "废旧金属登记";
	public static final String ALIAS_WUPINXH = "物品序号";
	public static final String ALIAS_WUPINMC = "物品名称";  //物品名称
	public static final String ALIAS_WUPINLB = "物品类别";
	public static final String ALIAS_SHOUGOURQ = "收购日期";
	public static final String ALIAS_SHOUGOURY = "收购人员";
	public static final String ALIAS_CHUSHOURY = "出售人姓名";
	public static final String ALIAS_CHUSHOURENXB = "出售人性别";
	public static final String ALIAS_CHUSHOURENSFZH = "出售人身份证号";
	public static final String ALIAS_BEIZHU = "备注";
	public static final String ALIAS_CHUSHOURENLXDH = "出售人联系电话";
	public static final String ALIAS_ISKEYI = "是否可疑物品";
	public static final String ALIAS_CSRLXDH = "出售人联系电话";
	public static final String ALIAS_JBR = "经办人";
	public static final String ALIAS_JBRSFZH = "经办人身份证号";
	public static final String ALIAS_JBRLXDH = "经办人联系电话";
	public static final String ALIAS_SGWPSL = "收购物品数量";
	public static final String ALIAS_SGWPGG = "收购物品规格";
	public static final String ALIAS_SGR = "收购人";
	public static final String ALIAS_SGRLXDH = "收购人联系电话";
	public static final String ALIAS_WPYS = "颜色";
	public static final String ALIAS_WPPP = "品牌";
	public static final String ALIAS_WPXZ = "形状";
	public static final String ALIAS_WPSF = "成分";
	public static final String ALIAS_WPDX = "大小";
	public static final String ALIAS_WPZL = "重量(公斤)";
	public static final String ALIAS_UNITPRICE ="单价（元/公斤）";
	public static final String ALIAS_TOTALPRICE ="总价";
	public static final String ALIAS_WPBZ = "包装";
	public static final String ALIAS_WPTZ = "特征";
	public static final String ALIAS_WPCD = "产地";
	public static final String ALIAS_CPCODE = "收购企业代码";
	
	//date formats
	
	//columns START
	private java.lang.String wupinxh;
	private String wupinmc;
	private String wupinlb;
	private String shougourq;
	private String shougoury;
	private String csrxm;
	private String csrxb;
	private String chushoury;
	private String chushourenxb;
	private String chushourensfzh;
	private String beizhu;
	private String chushourenlxdh;
	private String iskeyi;
	private String csrlxdh;
	private String jbr;
	private String jbrsfzh;
	private String jbrlxdh;
	private Integer sgwpsl;
	private String sgwpgg;
	private String sgr;
	private String sgrlxdh;
	private String wpys;
	private String wppp;
	private String wpxz;
	private String wpsf;
	private String wpdx;
	private String wpzl;
	private String wpbz;
	private String totalprice;
	private String unitprice;
	private String wptz;
	private String wpcd;
	private java.lang.String cpcode;
	//columns END
	private java.lang.String deptname;
	private java.lang.String empname;
	private String npcode;
	private String npaddress;
	private String praddress;
	private String hjaddress;
	private String zlone;
	private String zlthree;
	private String zltwo;
	private String zlfour;
	
	private Long userid;
	
    
	public Long getUserid() {
		return userid;
	}

	public void setUserid(Long userid) {
		this.userid = userid;
	}

	public String getZlone() {
		return zlone;
	}

	public void setZlone(String zlone) {
		this.zlone = zlone;
	}

	public String getZlthree() {
		return zlthree;
	}

	public void setZlthree(String zlthree) {
		this.zlthree = zlthree;
	}

	public String getZltwo() {
		return zltwo;
	}

	public void setZltwo(String zltwo) {
		this.zltwo = zltwo;
	}

	public String getZlfour() {
		return zlfour;
	}

	public void setZlfour(String zlfour) {
		this.zlfour = zlfour;
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

	public Tfeijiuwupin(){
	}

	public Tfeijiuwupin(
		java.lang.String wupinxh
	){
		this.wupinxh = wupinxh;
	}

	public void setWupinxh(java.lang.String value) {
		this.wupinxh = value;
	}
	
	public java.lang.String getWupinxh() {
		return this.wupinxh;
	}
	public void setWupinmc(String value) {
		this.wupinmc = value;
	}
	
	public String getWupinmc() {
		return this.wupinmc;
	}
	public void setWupinlb(String value) {
		this.wupinlb = value;
	}
	
	public String getWupinlb() {
		return this.wupinlb;
	}
	public void setShougourq(String value) {
		this.shougourq = value;
	}
	
	public String getShougourq() {
		return this.shougourq;
	}
	public void setShougoury(String value) {
		this.shougoury = value;
	}
	
	public String getShougoury() {
		return this.shougoury;
	}
	
	public String getCsrxm() {
		return csrxm;
	}

	public void setCsrxm(String csrxm) {
		this.csrxm = csrxm;
	}

	public String getCsrxb() {
		return csrxb;
	}

	public void setCsrxb(String csrxb) {
		this.csrxb = csrxb;
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
	public void setIskeyi(String value) {
		this.iskeyi = value;
	}
	
	public String getIskeyi() {
		return this.iskeyi;
	}
	public void setCsrlxdh(String value) {
		this.csrlxdh = value;
	}
	
	public String getCsrlxdh() {
		return this.csrlxdh;
	}
	public void setJbr(String value) {
		this.jbr = value;
	}
	
	public String getJbr() {
		return this.jbr;
	}
	public void setJbrsfzh(String value) {
		this.jbrsfzh = value;
	}
	
	public String getJbrsfzh() {
		return this.jbrsfzh;
	}
	public void setJbrlxdh(String value) {
		this.jbrlxdh = value;
	}
	
	public String getJbrlxdh() {
		return this.jbrlxdh;
	}
	public void setSgwpsl(Integer value) {
		this.sgwpsl = value;
	}
	
	public Integer getSgwpsl() {
		return this.sgwpsl;
	}
	public void setSgwpgg(String value) {
		this.sgwpgg = value;
	}
	
	public String getSgwpgg() {
		return this.sgwpgg;
	}
	public void setSgr(String value) {
		this.sgr = value;
	}
	
	public String getSgr() {
		return this.sgr;
	}
	public void setSgrlxdh(String value) {
		this.sgrlxdh = value;
	}
	
	public String getSgrlxdh() {
		return this.sgrlxdh;
	}
	public void setWpys(String value) {
		this.wpys = value;
	}
	
	public String getWpys() {
		return this.wpys;
	}
	public void setWppp(String value) {
		this.wppp = value;
	}
	
	public String getWppp() {
		return this.wppp;
	}
	public void setWpxz(String value) {
		this.wpxz = value;
	}
	
	public String getWpxz() {
		return this.wpxz;
	}
	public void setWpsf(String value) {
		this.wpsf = value;
	}
	
	public String getWpsf() {
		return this.wpsf;
	}
	public void setWpdx(String value) {
		this.wpdx = value;
	}
	
	public String getWpdx() {
		return this.wpdx;
	}

	public String getWpzl() {
		return wpzl;
	}

	public void setWpzl(String wpzl) {
		this.wpzl = wpzl;
	}

	public void setWpbz(String value) {
		this.wpbz = value;
	}
	
	public String getWpbz() {
		return this.wpbz;
	}
	public void setWptz(String value) {
		this.wptz = value;
	}
	
	public String getWptz() {
		return this.wptz;
	}
	public void setWpcd(String value) {
		this.wpcd = value;
	}
	
	public String getWpcd() {
		return this.wpcd;
	}
	public void setCpcode(java.lang.String value) {
		this.cpcode = value;
	}
	
	public java.lang.String getCpcode() {
		return this.cpcode;
	}

	public String toString() {
		return new ToStringBuilder(this)
			.append("Wupinxh",getWupinxh())
			.append("Wupinmc",getWupinmc())
			.append("Wupinlb",getWupinlb())
			.append("Shougourq",getShougourq())
			.append("Shougoury",getShougoury())
			.append("Csrxm",getCsrxm())
			.append("Csrxb",getCsrxb())
			.append("Chushourensfzh",getChushourensfzh())
			.append("Beizhu",getBeizhu())
			.append("Chushourenlxdh",getChushourenlxdh())
			.append("Iskeyi",getIskeyi())
			.append("Csrlxdh",getCsrlxdh())
			.append("Jbr",getJbr())
			.append("Jbrsfzh",getJbrsfzh())
			.append("Jbrlxdh",getJbrlxdh())
			.append("Sgwpsl",getSgwpsl())
			.append("Sgwpgg",getSgwpgg())
			.append("Sgr",getSgr())
			.append("Sgrlxdh",getSgrlxdh())
			.append("Wpys",getWpys())
			.append("Wppp",getWppp())
			.append("Wpxz",getWpxz())
			.append("Wpsf",getWpsf())
			.append("Wpdx",getWpdx())
			.append("Wpzl",getWpzl())
			.append("Wpbz",getWpbz())
			.append("Wptz",getWptz())
			.append("Wpcd",getWpcd())
			.append("Cpcode",getCpcode())
			.append("Npcode",getNpcode())
			.append("Npaddress",getNpaddress())
			.append("Hjaddress",getHjaddress())
			.append("Zlone",getZlone())
			.append("Zltwo",getZltwo())
			.append("Zlthree",getZlthree())
			.append("Zlfour",getZlfour())
			.append("Zlone",getPraddress())
			.toString();
	}
	
	public int hashCode() {
		return new HashCodeBuilder()
			.append(getWupinxh())
			.append(getWupinmc())
			.append(getWupinlb())
			.append(getShougourq())
			.append(getShougoury())
			.append(getCsrxm())
			.append(getCsrxb())
			.append(getChushourensfzh())
			.append(getBeizhu())
			.append(getChushourenlxdh())
			.append(getIskeyi())
			.append(getCsrlxdh())
			.append(getJbr())
			.append(getJbrsfzh())
			.append(getJbrlxdh())
			.append(getSgwpsl())
			.append(getSgwpgg())
			.append(getSgr())
			.append(getSgrlxdh())
			.append(getWpys())
			.append(getWppp())
			.append(getWpxz())
			.append(getWpsf())
			.append(getWpdx())
			.append(getWpzl())
			.append(getWpbz())
			.append(getWptz())
			.append(getWpcd())
			.append(getCpcode())
			.append(getCpcode())
			.append(getNpaddress())
			.append(getPraddress())
			.append(getHjaddress())
			.append(getZlone())
			.append(getZltwo())
			.append(getZlthree())
			.append(getZlfour())
			.toHashCode();
	}
	
	public boolean equals(Object obj) {
		if(obj instanceof Tfeijiuwupin == false) return false;
		if(this == obj) return true;
		Tfeijiuwupin other = (Tfeijiuwupin)obj;
		return new EqualsBuilder()
			.append(getWupinxh(),other.getWupinxh())
			.append(getWupinmc(),other.getWupinmc())
			.append(getWupinlb(),other.getWupinlb())
			.append(getShougourq(),other.getShougourq())
			.append(getShougoury(),other.getShougoury())
			.append(getCsrxm(),other.getCsrxm())
			.append(getCsrxb(),other.getCsrxb())
			.append(getChushourensfzh(),other.getChushourensfzh())
			.append(getBeizhu(),other.getBeizhu())
			.append(getChushourenlxdh(),other.getChushourenlxdh())
			.append(getIskeyi(),other.getIskeyi())
			.append(getCsrlxdh(),other.getCsrlxdh())
			.append(getJbr(),other.getJbr())
			.append(getJbrsfzh(),other.getJbrsfzh())
			.append(getJbrlxdh(),other.getJbrlxdh())
			.append(getSgwpsl(),other.getSgwpsl())
			.append(getSgwpgg(),other.getSgwpgg())
			.append(getSgr(),other.getSgr())
			.append(getSgrlxdh(),other.getSgrlxdh())
			.append(getWpys(),other.getWpys())
			.append(getWppp(),other.getWppp())
			.append(getWpxz(),other.getWpxz())
			.append(getWpsf(),other.getWpsf())
			.append(getWpdx(),other.getWpdx())
			.append(getWpzl(),other.getWpzl())
			.append(getWpbz(),other.getWpbz())
			.append(getWptz(),other.getWptz())
			.append(getWpcd(),other.getWpcd())
			.append(getCpcode(),other.getCpcode())
			.append(getNpaddress(),other.getNpaddress())
			.append(getPraddress(),other.getPraddress())
			.append(getHjaddress(), this.getHjaddress())
			.append(getNpcode(),other.getNpcode())
			.append(getZlone(),other.getZlone())
			.append(getZltwo(),other.getZltwo())
			.append(getZlthree(),other.getZlthree())
			.append(getZlfour(),other.getZlfour())
			.isEquals();
	}

	public java.lang.String getDeptname() {
		return deptname;
	}

	public void setDeptname(java.lang.String deptname) {
		this.deptname = deptname;
	}

	public java.lang.String getEmpname() {
		return empname;
	}

	public void setEmpname(java.lang.String empname) {
		this.empname = empname;
	}

	public String getHjaddress() {
		return hjaddress;
	}

	public void setHjaddress(String hjaddress) {
		this.hjaddress = hjaddress;
	}

	public String getChushoury() {
		return chushoury;
	}

	public void setChushoury(String chushoury) {
		this.chushoury = chushoury;
	}

	public String getChushourenxb() {
		return chushourenxb;
	}

	public void setChushourenxb(String chushourenxb) {
		this.chushourenxb = chushourenxb;
	}

	public String getTotalprice() {
		return totalprice;
	}

	public void setTotalprice(String totalprice) {
		this.totalprice = totalprice;
	}

	public String getUnitprice() {
		return unitprice;
	}

	public void setUnitprice(String unitprice) {
		this.unitprice = unitprice;
	}

	
}

