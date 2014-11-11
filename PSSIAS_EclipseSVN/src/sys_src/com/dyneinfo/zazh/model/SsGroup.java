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


public class SsGroup extends BaseEntity {
	
	//alias
	public static final String TABLE_ALIAS = "角色组";
	public static final String ALIAS_GROUPID = "角色组ID";
	public static final String ALIAS_ORGID = "角色ID";
	public static final String ALIAS_PARENTGROUPID = "上级工作组";
	public static final String ALIAS_GROUPLEVEL = "工作组级别";
	public static final String ALIAS_GROUPNAME = "工作组名称";
	public static final String ALIAS_GROUPDESC = "工作组描述";
	public static final String ALIAS_GROUPTYPE = "工作组类型";
	public static final String ALIAS_GROUPSEQ = "层级关系";
	public static final String ALIAS_STARTDATE = "有效开始日期";
	public static final String ALIAS_ENDDATE = "有效截止日期";
	public static final String ALIAS_GROUPSTATUS = "状态";
	public static final String ALIAS_MANAGER = "管理者";
	public static final String ALIAS_CREATETIME = "注册日期";
	public static final String ALIAS_LASTUPDATE = "修改日期";
	public static final String ALIAS_ISLEAF = "叶子节点";
	public static final String ALIAS_DISPLAYORDER = "排列顺序";
	
	//date formats
	public static final String FORMAT_STARTDATE = DATE_TIME_FORMAT;
	public static final String FORMAT_ENDDATE = DATE_TIME_FORMAT;
	public static final String FORMAT_CREATETIME = DATE_TIME_FORMAT;
	public static final String FORMAT_LASTUPDATE = DATE_TIME_FORMAT;
	
	//columns START
	private java.lang.Long groupid;
	private java.lang.Long orgid;
	private java.lang.Long parentgroupid;
	private Integer grouplevel;
	private java.lang.String groupname;
	private java.lang.String groupdesc;
	private java.lang.String grouptype;
	private java.lang.String groupseq;
	private java.util.Date startdate;
	private java.util.Date enddate;
	private java.lang.String groupstatus;
	private java.lang.String manager;
	private java.util.Date createtime;
	private java.util.Date lastupdate;
	private java.lang.String isleaf;
	private java.lang.Integer displayorder;
	//columns END

	public SsGroup(){
	}

	public SsGroup(
		java.lang.Long groupid
	){
		this.groupid = groupid;
	}

	public void setGroupid(java.lang.Long value) {
		this.groupid = value;
	}
	
	public java.lang.Long getGroupid() {
		return this.groupid;
	}
	public void setOrgid(java.lang.Long value) {
		this.orgid = value;
	}
	
	public java.lang.Long getOrgid() {
		return this.orgid;
	}
	public void setParentgroupid(java.lang.Long value) {
		this.parentgroupid = value;
	}
	
	public java.lang.Long getParentgroupid() {
		return this.parentgroupid;
	}
	public void setGrouplevel(Integer value) {
		this.grouplevel = value;
	}
	
	public Integer getGrouplevel() {
		return this.grouplevel;
	}
	public void setGroupname(java.lang.String value) {
		this.groupname = value;
	}
	
	public java.lang.String getGroupname() {
		return this.groupname;
	}
	public void setGroupdesc(java.lang.String value) {
		this.groupdesc = value;
	}
	
	public java.lang.String getGroupdesc() {
		return this.groupdesc;
	}
	public void setGrouptype(java.lang.String value) {
		this.grouptype = value;
	}
	
	public java.lang.String getGrouptype() {
		return this.grouptype;
	}
	public void setGroupseq(java.lang.String value) {
		this.groupseq = value;
	}
	
	public java.lang.String getGroupseq() {
		return this.groupseq;
	}
	public String getStartdateString() {
		return date2String(getStartdate(), FORMAT_STARTDATE);
	}
	public void setStartdateString(String value) {
		setStartdate(string2Date(value, FORMAT_STARTDATE,java.util.Date.class));
	}
	
	public void setStartdate(java.util.Date value) {
		this.startdate = value;
	}
	
	public java.util.Date getStartdate() {
		return this.startdate;
	}
	public String getEnddateString() {
		return date2String(getEnddate(), FORMAT_ENDDATE);
	}
	public void setEnddateString(String value) {
		setEnddate(string2Date(value, FORMAT_ENDDATE,java.util.Date.class));
	}
	
	public void setEnddate(java.util.Date value) {
		this.enddate = value;
	}
	
	public java.util.Date getEnddate() {
		return this.enddate;
	}
	public void setGroupstatus(java.lang.String value) {
		this.groupstatus = value;
	}
	
	public java.lang.String getGroupstatus() {
		return this.groupstatus;
	}
	public void setManager(java.lang.String value) {
		this.manager = value;
	}
	
	public java.lang.String getManager() {
		return this.manager;
	}
	public String getCreatetimeString() {
		return date2String(getCreatetime(), FORMAT_CREATETIME);
	}
	public void setCreatetimeString(String value) {
		setCreatetime(string2Date(value, FORMAT_CREATETIME,java.util.Date.class));
	}
	
	public void setCreatetime(java.util.Date value) {
		this.createtime = value;
	}
	
	public java.util.Date getCreatetime() {
		return this.createtime;
	}
	public String getLastupdateString() {
		return date2String(getLastupdate(), FORMAT_LASTUPDATE);
	}
	public void setLastupdateString(String value) {
		setLastupdate(string2Date(value, FORMAT_LASTUPDATE,java.util.Date.class));
	}
	
	public void setLastupdate(java.util.Date value) {
		this.lastupdate = value;
	}
	
	public java.util.Date getLastupdate() {
		return this.lastupdate;
	}
	public void setIsleaf(java.lang.String value) {
		this.isleaf = value;
	}
	
	public java.lang.String getIsleaf() {
		return this.isleaf;
	}
	public void setDisplayorder(java.lang.Integer value) {
		this.displayorder = value;
	}
	
	public java.lang.Integer getDisplayorder() {
		return this.displayorder;
	}

	public String toString() {
		return new ToStringBuilder(this)
			.append("Groupid",getGroupid())
			.append("Orgid",getOrgid())
			.append("Parentgroupid",getParentgroupid())
			.append("Grouplevel",getGrouplevel())
			.append("Groupname",getGroupname())
			.append("Groupdesc",getGroupdesc())
			.append("Grouptype",getGrouptype())
			.append("Groupseq",getGroupseq())
			.append("Startdate",getStartdate())
			.append("Enddate",getEnddate())
			.append("Groupstatus",getGroupstatus())
			.append("Manager",getManager())
			.append("Createtime",getCreatetime())
			.append("Lastupdate",getLastupdate())
			.append("Isleaf",getIsleaf())
			.append("Displayorder",getDisplayorder())
			.toString();
	}
	
	public int hashCode() {
		return new HashCodeBuilder()
			.append(getGroupid())
			.append(getOrgid())
			.append(getParentgroupid())
			.append(getGrouplevel())
			.append(getGroupname())
			.append(getGroupdesc())
			.append(getGrouptype())
			.append(getGroupseq())
			.append(getStartdate())
			.append(getEnddate())
			.append(getGroupstatus())
			.append(getManager())
			.append(getCreatetime())
			.append(getLastupdate())
			.append(getIsleaf())
			.append(getDisplayorder())
			.toHashCode();
	}
	
	public boolean equals(Object obj) {
		if(obj instanceof SsGroup == false) return false;
		if(this == obj) return true;
		SsGroup other = (SsGroup)obj;
		return new EqualsBuilder()
			.append(getGroupid(),other.getGroupid())
			.append(getOrgid(),other.getOrgid())
			.append(getParentgroupid(),other.getParentgroupid())
			.append(getGrouplevel(),other.getGrouplevel())
			.append(getGroupname(),other.getGroupname())
			.append(getGroupdesc(),other.getGroupdesc())
			.append(getGrouptype(),other.getGrouptype())
			.append(getGroupseq(),other.getGroupseq())
			.append(getStartdate(),other.getStartdate())
			.append(getEnddate(),other.getEnddate())
			.append(getGroupstatus(),other.getGroupstatus())
			.append(getManager(),other.getManager())
			.append(getCreatetime(),other.getCreatetime())
			.append(getLastupdate(),other.getLastupdate())
			.append(getIsleaf(),other.getIsleaf())
			.append(getDisplayorder(),other.getDisplayorder())
			.isEquals();
	}
}

