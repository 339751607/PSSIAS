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


public class TpersonlogJw extends BaseEntity {
	
	//alias
	public static final String TABLE_ALIAS = "境外人员业务记录表";
	public static final String ALIAS_ID = "人员ID(取值：SEQ_T_PERSONLOG_JW)";
	public static final String ALIAS_PERSONID = "人员ID(对应表T_PERSON_JW的ID)";
	public static final String ALIAS_PASS_T = "证件类型";
	public static final String ALIAS_PASS_NO = "证件号码";
	public static final String ALIAS_SOURCE = "数据来源";
	public static final String ALIAS_SID = "原行业子系统中的ID";
	public static final String ALIAS_PERSONTYPE = "业务类型";
	public static final String ALIAS_EMPSTATUS = "从业状态";
	public static final String ALIAS_STARTTIME = "业务开始时间";
	public static final String ALIAS_ENDTIME = "业务结束时间";
	public static final String ALIAS_INSERTTIME = "入平台库时间";
	public static final String ALIAS_UPDATETIME = "最后更新时间";
	public static final String ALIAS_TABLEFORPIC = "照片表名称";
	public static final String ALIAS_FIELDFORPIC = "照片字段名称";
	public static final String ALIAS_CPCODE = "企业代码";
	public static final String ALIAS_CPNAME = "企业名称";
	//date formats
	public static final String FORMAT_INSERTTIME = DATE_TIME_FORMAT;
	public static final String FORMAT_UPDATETIME = DATE_TIME_FORMAT;
	
	//columns START
	private Long id;
	private Long personid;
	private java.lang.String passT;
	private java.lang.String passNo;
	private java.lang.String source;
	private java.lang.String sid;
	private java.lang.String persontype;
	private java.lang.String empstatus;
	private java.lang.String starttime;
	private java.lang.String endtime;
	private java.util.Date inserttime;
	private java.util.Date updatetime;
	private java.lang.String tableforpic;
	private java.lang.String fieldforpic;
	private java.lang.String cpcode;
	private java.lang.String cpname;
	private java.lang.String keyforpic;
	//columns END

	public TpersonlogJw(){
	}

	public TpersonlogJw(
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
	public void setPersonid(Long value) {
		this.personid = value;
	}
	
	public Long getPersonid() {
		return this.personid;
	}
	
	public void setPassT(java.lang.String value) {
		this.passT = value;
	}
	
	public java.lang.String getPassT() {
		return this.passT;
	}
	public void setPassNo(java.lang.String value) {
		this.passNo = value;
	}
	
	public java.lang.String getPassNo() {
		return this.passNo;
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
	public void setPersontype(java.lang.String value) {
		this.persontype = value;
	}
	
	public java.lang.String getPersontype() {
		return this.persontype;
	}
	public void setEmpstatus(java.lang.String value) {
		this.empstatus = value;
	}
	
	public java.lang.String getEmpstatus() {
		return this.empstatus;
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

	public String toString() {
		return new ToStringBuilder(this)
			.append("Id",getId())
			.append("Personid",getPersonid())
			.append("PassT",getPassT())
			.append("PassNo",getPassNo())
			.append("Source",getSource())
			.append("Sid",getSid())
			.append("Persontype",getPersontype())
			.append("Empstatus",getEmpstatus())
			.append("Starttime",getStarttime())
			.append("Endtime",getEndtime())
			.append("Inserttime",getInserttime())
			.append("Updatetime",getUpdatetime())
			.append("Tableforpic",getTableforpic())
			.append("Fieldforpic",getFieldforpic())
			.append("Cpcode",getCpcode())
			.toString();
	}
	
	public int hashCode() {
		return new HashCodeBuilder()
			.append(getId())
			.append(getPersonid())
			.append(getPassT())
			.append(getPassNo())
			.append(getSource())
			.append(getSid())
			.append(getPersontype())
			.append(getEmpstatus())
			.append(getStarttime())
			.append(getEndtime())
			.append(getInserttime())
			.append(getUpdatetime())
			.append(getTableforpic())
			.append(getFieldforpic())
			.append(getCpcode())
			.toHashCode();
	}
	
	public boolean equals(Object obj) {
		if(obj instanceof TpersonlogJw == false) return false;
		if(this == obj) return true;
		TpersonlogJw other = (TpersonlogJw)obj;
		return new EqualsBuilder()
			.append(getId(),other.getId())
			.append(getPersonid(),other.getPersonid())
			.append(getPassT(),other.getPassT())
			.append(getPassNo(),other.getPassNo())
			.append(getSource(),other.getSource())
			.append(getSid(),other.getSid())
			.append(getPersontype(),other.getPersontype())
			.append(getEmpstatus(),other.getEmpstatus())
			.append(getStarttime(),other.getStarttime())
			.append(getEndtime(),other.getEndtime())
			.append(getInserttime(),other.getInserttime())
			.append(getUpdatetime(),other.getUpdatetime())
			.append(getTableforpic(),other.getTableforpic())
			.append(getFieldforpic(),other.getFieldforpic())
			.append(getCpcode(),other.getCpcode())
			.isEquals();
	}

	public java.lang.String getCpname() {
		return cpname;
	}

	public void setCpname(java.lang.String cpname) {
		this.cpname = cpname;
	}

	public java.lang.String getKeyforpic() {
		return keyforpic;
	}

	public void setKeyforpic(java.lang.String keyforpic) {
		this.keyforpic = keyforpic;
	}
}

