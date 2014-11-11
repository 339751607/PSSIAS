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


public class SDictitem extends BaseEntity {
	
	//alias
	public static final String TABLE_ALIAS = "Dictitem";
	public static final String ALIAS_DICTTYPEID = "dicttypeid";
	public static final String ALIAS_DICTID = "dictid";
	public static final String ALIAS_DICTNAME = "dictname";
	public static final String ALIAS_STATUS = "status";
	public static final String ALIAS_SORTNO = "sortno";
	public static final String ALIAS_DICTLEVEL = "dictlevel";
	public static final String ALIAS_PARENTID = "parentid";
	public static final String ALIAS_SEQNO = "seqno";
	
	//date formats
	
	//columns START
	private java.lang.String dicttypeid;
	private java.lang.String dictid;
	private java.lang.String dictname;
	private java.lang.Long status;
	private java.lang.Long sortno;
	private java.lang.Long dictlevel;
	private java.lang.String parentid;
	private java.lang.String seqno;
	//columns END

	public SDictitem(){
	}

	public SDictitem(
		java.lang.String dicttypeid,
		java.lang.String dictid
	){
		this.dicttypeid = dicttypeid;
		this.dictid = dictid;
	}

	public void setDicttypeid(java.lang.String value) {
		this.dicttypeid = value;
	}
	
	public java.lang.String getDicttypeid() {
		return this.dicttypeid;
	}
	public void setDictid(java.lang.String value) {
		this.dictid = value;
	}
	
	public java.lang.String getDictid() {
		return this.dictid;
	}
	public void setDictname(java.lang.String value) {
		this.dictname = value;
	}
	
	public java.lang.String getDictname() {
		return this.dictname;
	}
	public void setStatus(java.lang.Long value) {
		this.status = value;
	}
	
	public java.lang.Long getStatus() {
		return this.status;
	}
	public void setSortno(java.lang.Long value) {
		this.sortno = value;
	}
	
	public java.lang.Long getSortno() {
		return this.sortno;
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

	public String toString() {
		return new ToStringBuilder(this)
			.append("Dicttypeid",getDicttypeid())
			.append("Dictid",getDictid())
			.append("Dictname",getDictname())
			.append("Status",getStatus())
			.append("Sortno",getSortno())
			.append("Dictlevel",getDictlevel())
			.append("Parentid",getParentid())
			.append("Seqno",getSeqno())
			.toString();
	}
	
	public int hashCode() {
		return new HashCodeBuilder()
			.append(getDicttypeid())
			.append(getDictid())
			.append(getDictname())
			.append(getStatus())
			.append(getSortno())
			.append(getDictlevel())
			.append(getParentid())
			.append(getSeqno())
			.toHashCode();
	}
	
	public boolean equals(Object obj) {
		if(obj instanceof SDictitem == false) return false;
		if(this == obj) return true;
		SDictitem other = (SDictitem)obj;
		return new EqualsBuilder()
			.append(getDicttypeid(),other.getDicttypeid())
			.append(getDictid(),other.getDictid())
			.append(getDictname(),other.getDictname())
			.append(getStatus(),other.getStatus())
			.append(getSortno(),other.getSortno())
			.append(getDictlevel(),other.getDictlevel())
			.append(getParentid(),other.getParentid())
			.append(getSeqno(),other.getSeqno())
			.isEquals();
	}
}

