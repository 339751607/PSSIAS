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


public class Telxs extends BaseEntity {
	
	//alias
	public static final String TABLE_ALIAS = "二手手机销售";
	public static final String ALIAS_TELINFOID = "序号";
	public static final String ALIAS_GMRXM = "购买人姓名";
	public static final String ALIAS_GMRXB = "购买人性别";
	public static final String ALIAS_GMRSFZH = "购买人身份证号";
	public static final String ALIAS_GMRLXDH = "购买人联系电话";
	public static final String ALIAS_GMRJTZZ = "购买人家庭住址";
	public static final String ALIAS_JBR = "经办人";
	public static final String ALIAS_BZ = "备注";
	
	//date formats
	
	//columns START
	private java.lang.String telinfoid;
	private String gmrxm;
	private String gmrxb;
	private String gmrsfzh;
	private String gmrlxdh;
	private String gmrjtzz;
	private String jbr;
	private String bz;
	//columns END

	public Telxs(){
	}

	public Telxs(
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

	public String toString() {
		return new ToStringBuilder(this)
			.append("Telinfoid",getTelinfoid())
			.append("Gmrxm",getGmrxm())
			.append("Gmrxb",getGmrxb())
			.append("Gmrsfzh",getGmrsfzh())
			.append("Gmrlxdh",getGmrlxdh())
			.append("Gmrjtzz",getGmrjtzz())
			.append("Jbr",getJbr())
			.append("Bz",getBz())
			.toString();
	}
	
	public int hashCode() {
		return new HashCodeBuilder()
			.append(getTelinfoid())
			.append(getGmrxm())
			.append(getGmrxb())
			.append(getGmrsfzh())
			.append(getGmrlxdh())
			.append(getGmrjtzz())
			.append(getJbr())
			.append(getBz())
			.toHashCode();
	}
	
	public boolean equals(Object obj) {
		if(obj instanceof Telxs == false) return false;
		if(this == obj) return true;
		Telxs other = (Telxs)obj;
		return new EqualsBuilder()
			.append(getTelinfoid(),other.getTelinfoid())
			.append(getGmrxm(),other.getGmrxm())
			.append(getGmrxb(),other.getGmrxb())
			.append(getGmrsfzh(),other.getGmrsfzh())
			.append(getGmrlxdh(),other.getGmrlxdh())
			.append(getGmrjtzz(),other.getGmrjtzz())
			.append(getJbr(),other.getJbr())
			.append(getBz(),other.getBz())
			.isEquals();
	}
}

