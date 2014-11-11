/*
 * Powered By [lishicheng]
 */

package com.dyneinfo.gas.model;

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

import com.dyneinfo.gas.model.*;
import com.dyneinfo.gas.dao.*;
import com.dyneinfo.gas.service.*;

/**
 * @author lisc email:lishicheng(a)gmail.com
 */


public class TtztbFile extends BaseEntity {
	
	//alias
	public static final String TABLE_ALIAS = "通知/通报附件表";
	public static final String ALIAS_ID = "附件流水号";
	public static final String ALIAS_FILEID = "通知/通报ID";
	public static final String ALIAS_FILECONTENT = "通知/通报附件内容";
	public static final String ALIAS_TZTBTYPE = "通知/通报=1/2";
	public static final String ALIAS_FILENAME = "文件名";
	
	//date formats
	
	//columns START
	private Long id;
	private Long fileid;
	private java.sql.Blob filecontent;
	private java.lang.String tztbtype;
	private java.lang.String filename;
	//columns END

	public TtztbFile(){
	}

	public TtztbFile(
		Long id
	){
		this.id = id;
	}

	public void setId(Long value) {
		this.id = value;
	}
	
	public Long getId() {
		return this.id;
	}
	public void setFileid(Long value) {
		this.fileid = value;
	}
	
	public Long getFileid() {
		return this.fileid;
	}
	public void setFilecontent(java.sql.Blob value) {
		this.filecontent = value;
	}
	
	public java.sql.Blob getFilecontent() {
		return this.filecontent;
	}
	public void setTztbtype(java.lang.String value) {
		this.tztbtype = value;
	}
	
	public java.lang.String getTztbtype() {
		return this.tztbtype;
	}
	public void setFilename(java.lang.String value) {
		this.filename = value;
	}
	
	public java.lang.String getFilename() {
		return this.filename;
	}

	public String toString() {
		return new ToStringBuilder(this)
			.append("Id",getId())
			.append("Fileid",getFileid())
			.append("Filecontent",getFilecontent())
			.append("Tztbtype",getTztbtype())
			.append("Filename",getFilename())
			.toString();
	}
	
	public int hashCode() {
		return new HashCodeBuilder()
			.append(getId())
			.append(getFileid())
			.append(getFilecontent())
			.append(getTztbtype())
			.append(getFilename())
			.toHashCode();
	}
	
	public boolean equals(Object obj) {
		if(obj instanceof TtztbFile == false) return false;
		if(this == obj) return true;
		TtztbFile other = (TtztbFile)obj;
		return new EqualsBuilder()
			.append(getId(),other.getId())
			.append(getFileid(),other.getFileid())
			.append(getFilecontent(),other.getFilecontent())
			.append(getTztbtype(),other.getTztbtype())
			.append(getFilename(),other.getFilename())
			.isEquals();
	}
}

