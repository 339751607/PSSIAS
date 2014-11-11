/*
 * Powered By [lishicheng]
 */

package com.dyneinfo.jxy.model;

import java.util.HashSet;
import java.util.Set;

import javacommon.base.BaseEntity;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

/**
 * @author lisc email:lishicheng(a)gmail.com
 */

public class SsNotice extends BaseEntity {

	// alias
	public static final String TABLE_ALIAS = "通知";
	public static final String ALIAS_NOTICEID = "通知ID";
	public static final String ALIAS_NOTICETITLE = "标题";
	public static final String ALIAS_NOTICECONTENT = "内容";
	public static final String ALIAS_STARTTIME = "开始日期";
	public static final String ALIAS_ENDTIME = "结束日期";
	public static final String ALIAS_STATE = "发送状态";
	public static final String ALIAS_AUTHORID = "发送人";
	public static final String ALIAS_SENDUNITID = "发送单位";
	public static final String ALIAS_CREATETIME = "发布日期";
	public static final String ALIAS_ISREPLY = "是否回执";
	public static final String ALIAS_ISSUESCOPE = "发布范围";
	public static final String ALIAS_PARTICIPANTS = "参与人员";
	public static final String ALIAS_SORTNO = "显示顺序";

	// date formats
	public static final String FORMAT_STARTTIME = DATE_TIME_FORMAT;
	public static final String FORMAT_ENDTIME = DATE_TIME_FORMAT;
	public static final String FORMAT_ENDTIM = DATE_TIME_FORMAT;
	public static final String FORMAT_CREATETIME = DATE_TIME_FORMAT;

	// columns START
	private java.lang.Long noticeid;
	private String noticetitle;
	private String noticecontent;
	private java.util.Date starttime;
	private java.util.Date endtime;
	private String state;
	private String authorid;
	private String sendunitid;
	private java.util.Date createtime;
	private String isreply;
	private String issuescope;
	private String participants;
	private Long sortno;
	private String depttypeid;
	// columns END

	private String authorname;
	private String sendunitname;

	private String participantsName;
	private String issuescopeName;

	public SsNotice() {
	}

	public SsNotice(java.lang.Long noticeid) {
		this.noticeid = noticeid;
	}

	public void setNoticeid(java.lang.Long value) {
		this.noticeid = value;
	}

	public java.lang.Long getNoticeid() {
		return this.noticeid;
	}

	public void setNoticetitle(String value) {
		this.noticetitle = value;
	}

	public String getNoticetitle() {
		return this.noticetitle;
	}

	public void setNoticecontent(String value) {
		this.noticecontent = value;
	}

	public String getNoticecontent() {
		return this.noticecontent;
	}

	public String getStarttimeString() {
		return date2String(getStarttime(), FORMAT_STARTTIME);
	}

	public void setStarttimeString(String value) {
		setStarttime(string2Date(value, FORMAT_STARTTIME, java.util.Date.class));
	}

	public void setStarttime(java.util.Date value) {
		this.starttime = value;
	}

	public java.util.Date getStarttime() {
		return this.starttime;
	}

	public String getEndtimeString() {
		return date2String(getEndtime(), FORMAT_ENDTIME);
	}

	public void setEndtimeString(String value) {
		setEndtime(string2Date(value, FORMAT_ENDTIME, java.util.Date.class));
	}

	public void setEndtime(java.util.Date value) {
		this.endtime = value;
	}

	public java.util.Date getEndtime() {
		return this.endtime;
	}

	public void setState(String value) {
		this.state = value;
	}

	public String getState() {
		return this.state;
	}

	public void setAuthorid(String value) {
		this.authorid = value;
	}

	public String getAuthorid() {
		return this.authorid;
	}

	public void setSendunitid(String value) {
		this.sendunitid = value;
	}

	public String getSendunitid() {
		return this.sendunitid;
	}

	public String getCreatetimeString() {
		return date2String(getCreatetime(), FORMAT_CREATETIME);
	}

	public void setCreatetimeString(String value) {
		setCreatetime(string2Date(value, FORMAT_CREATETIME,
				java.util.Date.class));
	}

	public void setCreatetime(java.util.Date value) {
		this.createtime = value;
	}

	public java.util.Date getCreatetime() {
		return this.createtime;
	}

	public void setIsreply(String value) {
		this.isreply = value;
	}

	public String getIsreply() {
		return this.isreply;
	}

	public void setIssuescope(String value) {
		this.issuescope = value;
	}

	public String getIssuescope() {
		return this.issuescope;
	}

	public void setParticipants(String value) {
		this.participants = value;
	}

	public String getParticipants() {
		return this.participants;
	}

	public void setSortno(Long value) {
		this.sortno = value;
	}

	public Long getSortno() {
		return this.sortno;
	}

	private Set ssNoticeAttends = new HashSet(0);

	public void setSsNoticeAttends(Set<SsNoticeAttend> ssNoticeAttend) {
		this.ssNoticeAttends = ssNoticeAttend;
	}

	public Set<SsNoticeAttend> getSsNoticeAttends() {
		return ssNoticeAttends;
	}

	public String toString() {
		return new ToStringBuilder(this).append("Noticeid", getNoticeid())
				.append("Noticetitle", getNoticetitle()).append(
						"Noticecontent", getNoticecontent()).append(
						"Starttime", getStarttime()).append("Endtime",
						getEndtime()).append("State", getState()).append(
						"Authorid", getAuthorid()).append("Sendunitid",
						getSendunitid()).append("Createtime", getCreatetime())
				.append("Isreply", getIsreply()).append("Issuescope",
						getIssuescope()).append("Participants",
						getParticipants()).append("Sortno", getSortno())
				.append("Depttypeid", getDepttypeid()).toString();
	}

	public int hashCode() {
		return new HashCodeBuilder().append(getNoticeid()).append(
				getNoticetitle()).append(getNoticecontent()).append(
				getStarttime()).append(getEndtime()).append(getState()).append(
				getAuthorid()).append(getSendunitid()).append(getCreatetime())
				.append(getIsreply()).append(getIssuescope()).append(
						getParticipants()).append(getSortno()).append(
						getDepttypeid()).toHashCode();
	}

	public boolean equals(Object obj) {
		if (obj instanceof SsNotice == false)
			return false;
		if (this == obj)
			return true;
		SsNotice other = (SsNotice) obj;
		return new EqualsBuilder().append(getNoticeid(), other.getNoticeid())
				.append(getNoticetitle(), other.getNoticetitle()).append(
						getNoticecontent(), other.getNoticecontent()).append(
						getStarttime(), other.getStarttime()).append(
						getEndtime(), other.getEndtime()).append(getState(),
						other.getState()).append(getAuthorid(),
						other.getAuthorid()).append(getSendunitid(),
						other.getSendunitid()).append(getCreatetime(),
						other.getCreatetime()).append(getIsreply(),
						other.getIsreply()).append(getIssuescope(),
						other.getIssuescope()).append(getParticipants(),
						other.getParticipants()).append(getSortno(),
						other.getSortno()).append(getDepttypeid(),
						other.getDepttypeid()).isEquals();
	}

	public String getAuthorname() {
		return authorname;
	}

	public void setAuthorname(String authorname) {
		this.authorname = authorname;
	}

	public String getSendunitname() {
		return sendunitname;
	}

	public void setSendunitname(String sendunitname) {
		this.sendunitname = sendunitname;
	}

	public String getParticipantsName() {
		return participantsName;
	}

	public void setParticipantsName(String participantsName) {
		this.participantsName = participantsName;
	}

	public String getIssuescopeName() {
		return issuescopeName;
	}

	public void setIssuescopeName(String issuescopeName) {
		this.issuescopeName = issuescopeName;
	}

	public String getDepttypeid() {
		return depttypeid;
	}

	public void setDepttypeid(String depttypeid) {
		this.depttypeid = depttypeid;
	}
}
