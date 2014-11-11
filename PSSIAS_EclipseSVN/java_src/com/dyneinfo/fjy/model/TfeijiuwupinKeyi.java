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


public class TfeijiuwupinKeyi extends BaseEntity {
	
	//alias
	public static final String TABLE_ALIAS = "可疑信息";
	public static final String ALIAS_WUPINXH = "物品序号";
	public static final String ALIAS_KEYIYUANYIN = "可疑理由";
	public static final String ALIAS_XH = "序号";
	
	//date formats
	
	//columns START
	private java.lang.String wupinxh;
	private java.lang.String keyiyuanyin;
	private Long xh;
	//columns END

	public TfeijiuwupinKeyi(){
	}

	public TfeijiuwupinKeyi(
		Long xh
	){
		this.xh = xh;
	}

	public void setWupinxh(java.lang.String value) {
		this.wupinxh = value;
	}
	
	public java.lang.String getWupinxh() {
		return this.wupinxh;
	}
	public void setKeyiyuanyin(java.lang.String value) {
		this.keyiyuanyin = value;
	}
	
	public java.lang.String getKeyiyuanyin() {
		return this.keyiyuanyin;
	}
	public void setXh(Long value) {
		this.xh = value;
	}
	
	public Long getXh() {
		return this.xh;
	}

	public String toString() {
		return new ToStringBuilder(this)
			.append("Wupinxh",getWupinxh())
			.append("Keyiyuanyin",getKeyiyuanyin())
			.append("Xh",getXh())
			.toString();
	}
	
	public int hashCode() {
		return new HashCodeBuilder()
			.append(getWupinxh())
			.append(getKeyiyuanyin())
			.append(getXh())
			.toHashCode();
	}
	
	public boolean equals(Object obj) {
		if(obj instanceof TfeijiuwupinKeyi == false) return false;
		if(this == obj) return true;
		TfeijiuwupinKeyi other = (TfeijiuwupinKeyi)obj;
		return new EqualsBuilder()
			.append(getWupinxh(),other.getWupinxh())
			.append(getKeyiyuanyin(),other.getKeyiyuanyin())
			.append(getXh(),other.getXh())
			.isEquals();
	}
}

