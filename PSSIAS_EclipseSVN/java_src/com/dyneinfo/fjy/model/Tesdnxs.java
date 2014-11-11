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


public class Tesdnxs extends BaseEntity {
	
	//alias
	public static final String TABLE_ALIAS = "二手电脑销售信息";
	public static final String ALIAS_DNID = "序号";
	public static final String ALIAS_GMRXM = "购买人姓名";
	public static final String ALIAS_GMRXB = "购买人性别";
	public static final String ALIAS_GMRSFZH = "购买人身份证号";
	public static final String ALIAS_GMRLXDH = "购买人联系电话";
	public static final String ALIAS_GMRJTZZ = "购买人住址";
	public static final String ALIAS_JBR = "经办人";
	public static final String ALIAS_BZ = "备注";
	public static final String ALIAS_XH = "序号";
	
	//date formats
	
	//columns START
	private String dnid;
	private String gmrxm;
	private String gmrxb;
	private String gmrsfzh;
	private String gmrlxdh;
	private String gmrjtzz;
	private String jbr;
	private String bz;
	private Long xh;
	//columns END

	public Tesdnxs(){
	}

	public Tesdnxs(
		Long xh
	){
		this.xh = xh;
	}

	public void setDnid(String value) {
		this.dnid = value;
	}
	
	public String getDnid() {
		return this.dnid;
	}
	public void setGmrxm(String value) {
		this.gmrxm = value;
	}
	
	public String getGmrxm() {
		return this.gmrxm;
	}
	public void setGmrxb(String value) {
		this.gmrxb = value;
	}
	
	public String getGmrxb() {
		return this.gmrxb;
	}
	public void setGmrsfzh(String value) {
		this.gmrsfzh = value;
	}
	
	public String getGmrsfzh() {
		return this.gmrsfzh;
	}
	public void setGmrlxdh(String value) {
		this.gmrlxdh = value;
	}
	
	public String getGmrlxdh() {
		return this.gmrlxdh;
	}
	public void setGmrjtzz(String value) {
		this.gmrjtzz = value;
	}
	
	public String getGmrjtzz() {
		return this.gmrjtzz;
	}
	public void setJbr(String value) {
		this.jbr = value;
	}
	
	public String getJbr() {
		return this.jbr;
	}
	public void setBz(String value) {
		this.bz = value;
	}
	
	public String getBz() {
		return this.bz;
	}
	public void setXh(Long value) {
		this.xh = value;
	}
	
	public Long getXh() {
		return this.xh;
	}

	public String toString() {
		return new ToStringBuilder(this)
			.append("Dnid",getDnid())
			.append("Gmrxm",getGmrxm())
			.append("Gmrxb",getGmrxb())
			.append("Gmrsfzh",getGmrsfzh())
			.append("Gmrlxdh",getGmrlxdh())
			.append("Gmrjtzz",getGmrjtzz())
			.append("Jbr",getJbr())
			.append("Bz",getBz())
			.append("Xh",getXh())
			.toString();
	}
	
	public int hashCode() {
		return new HashCodeBuilder()
			.append(getDnid())
			.append(getGmrxm())
			.append(getGmrxb())
			.append(getGmrsfzh())
			.append(getGmrlxdh())
			.append(getGmrjtzz())
			.append(getJbr())
			.append(getBz())
			.append(getXh())
			.toHashCode();
	}
	
	public boolean equals(Object obj) {
		if(obj instanceof Tesdnxs == false) return false;
		if(this == obj) return true;
		Tesdnxs other = (Tesdnxs)obj;
		return new EqualsBuilder()
			.append(getDnid(),other.getDnid())
			.append(getGmrxm(),other.getGmrxm())
			.append(getGmrxb(),other.getGmrxb())
			.append(getGmrsfzh(),other.getGmrsfzh())
			.append(getGmrlxdh(),other.getGmrlxdh())
			.append(getGmrjtzz(),other.getGmrjtzz())
			.append(getJbr(),other.getJbr())
			.append(getBz(),other.getBz())
			.append(getXh(),other.getXh())
			.isEquals();
	}
}

