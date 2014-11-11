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


public class Tcarlog extends BaseEntity {
	
	//alias
	public static final String TABLE_ALIAS = "车辆业务记录表";
	public static final String ALIAS_ID = "流水号(取值：SEQ_T_PERSONLOG_JN)";
	public static final String ALIAS_CARBASEID = "车辆ID(对应表T_CARBASE的ID)";
	public static final String ALIAS_SOURCE = "数据来源";
	public static final String ALIAS_SID = "原ID(在行业子系统表中的ID)";
	public static final String ALIAS_CARTYPE = "业务类型";
	public static final String ALIAS_STARTTIME = "开始时间";
	public static final String ALIAS_ENDTIME = "结束时间";
	public static final String ALIAS_INSERTTIME = "入平台库时间";
	public static final String ALIAS_UPDATETIME = "最后更新时间";
	public static final String ALIAS_TABLEFORPIC = "照片表名称";
	public static final String ALIAS_FIELDFORPIC = "照片字段名称";
	public static final String ALIAS_CPCODE = "企业代码";
	public static final String ALIAS_CPNAME = "企业名称";
	public static final String ALIAS_KEYFORPIC = "照片表主键字段名";
	public static final String ALIAS_CARID = "车牌号";
	
	//date formats
	public static final String FORMAT_INSERTTIME = DATE_TIME_FORMAT;
	public static final String FORMAT_UPDATETIME = DATE_TIME_FORMAT;
	
	//columns START
	private java.lang.Long id;
	private java.lang.Long carbaseid;
	private java.lang.String source;
	private java.lang.String sid;
	private java.lang.String cartype;
	private java.lang.String starttime;
	private java.lang.String endtime;
	private java.util.Date inserttime;
	private java.util.Date updatetime;
	private java.lang.String tableforpic;
	private java.lang.String fieldforpic;
	private java.lang.String cpcode;
	private java.lang.String keyforpic;
	private java.lang.String carid;
	private java.lang.String cpname;
	//columns END

	public Tcarlog(){
	}

	public Tcarlog(
		java.lang.Long id
	){
		this.id = id;
	}

	public void setId(java.lang.Long value) {
		this.id = value;
	}
	
	public java.lang.Long getId() {
		return this.id;
	}
	public void setCarbaseid(java.lang.Long value) {
		this.carbaseid = value;
	}
	
	public java.lang.Long getCarbaseid() {
		return this.carbaseid;
	}
	public void setSource(java.lang.String value) {
		this.source = value;
	}
	
	public java.lang.String getSource() {
		return this.source;
	}
	public void setSid(java.lang.String value) {
		this.sid = value;
	}
	
	public java.lang.String getSid() {
		return this.sid;
	}
	public void setCartype(java.lang.String value) {
		this.cartype = value;
	}
	
	public java.lang.String getCartype() {
		return this.cartype;
	}
	public void setStarttime(java.lang.String value) {
		this.starttime = value;
	}
	
	public java.lang.String getStarttime() {
		return this.starttime;
	}
	public void setEndtime(java.lang.String value) {
		this.endtime = value;
	}
	
	public java.lang.String getEndtime() {
		return this.endtime;
	}
	public String getInserttimeString() {
		return date2String(getInserttime(), FORMAT_INSERTTIME);
	}
	public void setInserttimeString(String value) {
		setInserttime(string2Date(value, FORMAT_INSERTTIME,java.util.Date.class));
	}
	
	public void setInserttime(java.util.Date value) {
		this.inserttime = value;
	}
	
	public java.util.Date getInserttime() {
		return this.inserttime;
	}
	public String getUpdatetimeString() {
		return date2String(getUpdatetime(), FORMAT_UPDATETIME);
	}
	public void setUpdatetimeString(String value) {
		setUpdatetime(string2Date(value, FORMAT_UPDATETIME,java.util.Date.class));
	}
	
	public void setUpdatetime(java.util.Date value) {
		this.updatetime = value;
	}
	
	public java.util.Date getUpdatetime() {
		return this.updatetime;
	}
	public void setTableforpic(java.lang.String value) {
		this.tableforpic = value;
	}
	
	public java.lang.String getTableforpic() {
		return this.tableforpic;
	}
	public void setFieldforpic(java.lang.String value) {
		this.fieldforpic = value;
	}
	
	public java.lang.String getFieldforpic() {
		return this.fieldforpic;
	}
	public void setCpcode(java.lang.String value) {
		this.cpcode = value;
	}
	
	public java.lang.String getCpcode() {
		return this.cpcode;
	}
	public void setKeyforpic(java.lang.String value) {
		this.keyforpic = value;
	}
	
	public java.lang.String getKeyforpic() {
		return this.keyforpic;
	}
	public void setCarid(java.lang.String value) {
		this.carid = value;
	}
	
	public java.lang.String getCarid() {
		return this.carid;
	}

	public String toString() {
		return new ToStringBuilder(this)
			.append("Id",getId())
			.append("Carbaseid",getCarbaseid())
			.append("Source",getSource())
			.append("Sid",getSid())
			.append("Cartype",getCartype())
			.append("Starttime",getStarttime())
			.append("Endtime",getEndtime())
			.append("Inserttime",getInserttime())
			.append("Updatetime",getUpdatetime())
			.append("Tableforpic",getTableforpic())
			.append("Fieldforpic",getFieldforpic())
			.append("Cpcode",getCpcode())
			.append("Keyforpic",getKeyforpic())
			.append("Carid",getCarid())
			.toString();
	}
	
	public int hashCode() {
		return new HashCodeBuilder()
			.append(getId())
			.append(getCarbaseid())
			.append(getSource())
			.append(getSid())
			.append(getCartype())
			.append(getStarttime())
			.append(getEndtime())
			.append(getInserttime())
			.append(getUpdatetime())
			.append(getTableforpic())
			.append(getFieldforpic())
			.append(getCpcode())
			.append(getKeyforpic())
			.append(getCarid())
			.toHashCode();
	}
	
	public boolean equals(Object obj) {
		if(obj instanceof Tcarlog == false) return false;
		if(this == obj) return true;
		Tcarlog other = (Tcarlog)obj;
		return new EqualsBuilder()
			.append(getId(),other.getId())
			.append(getCarbaseid(),other.getCarbaseid())
			.append(getSource(),other.getSource())
			.append(getSid(),other.getSid())
			.append(getCartype(),other.getCartype())
			.append(getStarttime(),other.getStarttime())
			.append(getEndtime(),other.getEndtime())
			.append(getInserttime(),other.getInserttime())
			.append(getUpdatetime(),other.getUpdatetime())
			.append(getTableforpic(),other.getTableforpic())
			.append(getFieldforpic(),other.getFieldforpic())
			.append(getCpcode(),other.getCpcode())
			.append(getKeyforpic(),other.getKeyforpic())
			.append(getCarid(),other.getCarid())
			.isEquals();
	}

	public java.lang.String getCpname() {
		return cpname;
	}

	public void setCpname(java.lang.String cpname) {
		this.cpname = cpname;
	}
}

