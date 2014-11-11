/*
 * Powered By [lishicheng]
 */

package com.dyneinfo.zazh.model;

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

import com.dyneinfo.zazh.model.*;
import com.dyneinfo.zazh.dao.*;
import com.dyneinfo.zazh.service.*;

/**
 * @author lisc email:lishicheng(a)gmail.com
 */


public class SsDictType extends BaseEntity {
	
	//alias
	public static final String TABLE_ALIAS = "字典";
	public static final String ALIAS_DICTTYPEID = "字典类型";
	public static final String ALIAS_DICTTYPENAME = "字典类型名";
	public static final String ALIAS_DICTLEVEL = "级别";
	public static final String ALIAS_PARENTID = "父类型";
	public static final String ALIAS_SEQNO = "seqno";
	public static final String ALIAS_DICTFLAG = "数据来源";
	public static final String ALIAS_QUERYSQL = "自定义来源SQL";
	
	//date formats
	
	//columns START
	private java.lang.String dicttypeid;
	private java.lang.String dicttypename;
	private java.lang.Long dictlevel;
	private java.lang.String parentid;
	private java.lang.String seqno;
	private java.lang.String dictflag;
	private java.lang.String querysql;
	//columns END

	public SsDictType(){
	}

	public SsDictType(
		java.lang.String dicttypeid
	){
		this.dicttypeid = dicttypeid;
	}

	public void setDicttypeid(java.lang.String value) {
		this.dicttypeid = value;
	}
	
	public java.lang.String getDicttypeid() {
		return this.dicttypeid;
	}
	public void setDicttypename(java.lang.String value) {
		this.dicttypename = value;
	}
	
	public java.lang.String getDicttypename() {
		return this.dicttypename;
	}
	public void setDictlevel(java.lang.Long value) {
		this.dictlevel = value;
	}
	
	public java.lang.Long getDictlevel() {
		return this.dictlevel;
	}
	public void setParentid(java.lang.String value) {
		this.parentid = value;
	}
	
	public java.lang.String getParentid() {
		return this.parentid;
	}
	public void setSeqno(java.lang.String value) {
		this.seqno = value;
	}
	
	public java.lang.String getSeqno() {
		return this.seqno;
	}
	public void setDictflag(java.lang.String value) {
		this.dictflag = value;
	}
	
	public java.lang.String getDictflag() {
		return this.dictflag;
	}
	public void setQuerysql(java.lang.String value) {
		this.querysql = value;
	}
	
	public java.lang.String getQuerysql() {
		return this.querysql;
	}

	public String toString() {
		return new ToStringBuilder(this)
			.append("Dicttypeid",getDicttypeid())
			.append("Dicttypename",getDicttypename())
			.append("Dictlevel",getDictlevel())
			.append("Parentid",getParentid())
			.append("Seqno",getSeqno())
			.append("Dictflag",getDictflag())
			.append("Querysql",getQuerysql())
			.toString();
	}
	
	public int hashCode() {
		return new HashCodeBuilder()
			.append(getDicttypeid())
			.append(getDicttypename())
			.append(getDictlevel())
			.append(getParentid())
			.append(getSeqno())
			.append(getDictflag())
			.append(getQuerysql())
			.toHashCode();
	}
	
	public boolean equals(Object obj) {
		if(obj instanceof SsDictType == false) return false;
		if(this == obj) return true;
		SsDictType other = (SsDictType)obj;
		return new EqualsBuilder()
			.append(getDicttypeid(),other.getDicttypeid())
			.append(getDicttypename(),other.getDicttypename())
			.append(getDictlevel(),other.getDictlevel())
			.append(getParentid(),other.getParentid())
			.append(getSeqno(),other.getSeqno())
			.append(getDictflag(),other.getDictflag())
			.append(getQuerysql(),other.getQuerysql())
			.isEquals();
	}
}

