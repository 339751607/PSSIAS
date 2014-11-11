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


public class StaCl extends BaseEntity {
	
	//alias
	public static final String TABLE_ALIAS = "StaCl";
	public static final String ALIAS_ROWKEY = "rowkey";
	public static final String ALIAS_ROWNAME = "rowname";
	public static final String ALIAS_DEPTSEQ = "deptseq";
	public static final String ALIAS_SUMVALUE = "sumvalue";
	
	//date formats
	
	//columns START
	private Long rowkey;
	private java.lang.String rowname;
	private java.lang.String deptseq;
	private Long oneZl;
	private Long twoZl;
	private Long sumZl;
	private String isLeaf;
	//columns END

	public StaCl(){
	}

	public StaCl(
		Long rowkey
	){
		this.rowkey = rowkey;
	}

	public void setRowkey(Long value) {
		this.rowkey = value;
	}
	
	public Long getRowkey() {
		return this.rowkey;
	}
	public void setRowname(java.lang.String value) {
		this.rowname = value;
	}
	
	public java.lang.String getRowname() {
		return this.rowname;
	}
	public void setDeptseq(java.lang.String value) {
		this.deptseq = value;
	}
	
	public java.lang.String getDeptseq() {
		return this.deptseq;
	}


	public String toString() {
		return new ToStringBuilder(this)
			.append("Rowkey",getRowkey())
			.append("Rowname",getRowname())
			.append("Deptseq",getDeptseq())
			.append("Sumvalue",getSumZl())
			.toString();
	}
	
	public int hashCode() {
		return new HashCodeBuilder()
			.append(getRowkey())
			.append(getRowname())
			.append(getDeptseq())
			.append(getSumZl())
			.toHashCode();
	}
	
	public boolean equals(Object obj) {
		if(obj instanceof StaCl == false) return false;
		if(this == obj) return true;
		StaCl other = (StaCl)obj;
		return new EqualsBuilder()
			.append(getRowkey(),other.getRowkey())
			.append(getRowname(),other.getRowname())
			.append(getDeptseq(),other.getDeptseq())
			.append(getSumZl(),other.getSumZl())
			.isEquals();
	}

	public Long getOneZl() {
		return oneZl;
	}

	public void setOneZl(Long oneZl) {
		this.oneZl = oneZl;
	}

	public Long getTwoZl() {
		return twoZl;
	}

	public void setTwoZl(Long twoZl) {
		this.twoZl = twoZl;
	}

	public Long getSumZl() {
		return sumZl;
	}

	public void setSumZl(Long sumZl) {
		this.sumZl = sumZl;
	}

	public String getIsLeaf() {
		return isLeaf;
	}

	public void setIsLeaf(String isLeaf) {
		this.isLeaf = isLeaf;
	}
}

