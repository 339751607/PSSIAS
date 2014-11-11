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


public class SsNoticeReply extends BaseEntity {
	
	//alias
	public static final String TABLE_ALIAS = "回执信息";
	public static final String ALIAS_NOTICEID = "通知通告ID";
	public static final String ALIAS_DEPTID = "部门编号";
	public static final String ALIAS_REPLYDATE = "回执日期";
	public static final String ALIAS_DEPTNAME = "单位名称";
	public static final String ALIAS_NOTICETITLE = "通知通告标题";
	
	//date formats
	
	//columns START
	private java.lang.String noticeid;
	private java.lang.String deptid;
	private java.lang.String replydate;
	private java.lang.String deptname;
	private java.lang.String noticetitle;
	//columns END

	public java.lang.String getDeptname() {
		return deptname;
	}

	public void setDeptname(java.lang.String deptname) {
		this.deptname = deptname;
	}

	public java.lang.String getNoticetitle() {
		return noticetitle;
	}

	public void setNoticetitle(java.lang.String noticetitle) {
		this.noticetitle = noticetitle;
	}

	public SsNoticeReply(){
	}

	public SsNoticeReply(java.lang.String noticeid){
		this.noticeid = noticeid;
	}

	

	public java.lang.String getNoticeid() {
		return noticeid;
	}

	public void setNoticeid(java.lang.String noticeid) {
		this.noticeid = noticeid;
	}

	public java.lang.String getDeptid() {
		return deptid;
	}

	public void setDeptid(java.lang.String deptid) {
		this.deptid = deptid;
	}

	public java.lang.String getReplydate() {
		return replydate;
	}

	public void setReplydate(java.lang.String replydate) {
		this.replydate = replydate;
	}

	public String toString() {
		return new ToStringBuilder(this)
			.append("Noticeid",getNoticeid())
			.append("Deptid",getDeptid())
			.append("Replydate",getReplydate())
			.append("Deptname",getDeptname())
			.append("Noticetitle",getNoticetitle())
			.toString();
	}
	
	public int hashCode() {
		return new HashCodeBuilder()
			.append(getNoticeid())
			.append(getDeptid())
			.append(getReplydate())
			.append(getDeptname())
			.append(getNoticetitle())
			.toHashCode();
	}
	
	public boolean equals(Object obj) {
		if(obj instanceof SsNoticeReply == false) return false;
		if(this == obj) return true;
		SsNoticeReply other = (SsNoticeReply)obj;
		return new EqualsBuilder()
			.append(getNoticeid(),other.getNoticeid())
			.append(getDeptid(),other.getDeptid())
			.append(getReplydate(),other.getReplydate())
			.append(getDeptname(),other.getDeptname())
			.append(getNoticetitle(),other.getNoticetitle())
			.isEquals();
	}
}

