/*
 * Powered By [lishicheng]
 */

package com.dyneinfo.jxy.model;

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

import com.dyneinfo.jxy.dao.*;
import com.dyneinfo.jxy.model.*;
import com.dyneinfo.jxy.service.*;

/**
 * @author lisc email:lishicheng(a)gmail.com
 */


public class tpoliCk extends BaseEntity {
	
	//alias
	public static final String TABLE_ALIAS = "民警检查信息";
	public static final String ALIAS_USERNAME = "被检查人";
	public static final String ALIAS_CHECKDATE = "检查时间";
	public static final String ALIAS_CHECKUSER = "检查人员";
	public static final String ALIAS_CHECKREMARK = "检查内容";
	public static final String ALIAS_CPCODE = "企业代码";
	public static final String ALIAS_CPNAME="部门";
	
	//date formats
	public static final String FORMAT_CHECKTIME = DATE_TIME_FORMAT;
	public static final String FORMAT_DEADLINE = DATE_FORMAT;
	//columns START
	private Long checkid;
	private java.lang.String cpcode;
	public java.lang.String getCpcode() {
		return cpcode;
	}

	public void setCpcode(java.lang.String value) {
		this.cpcode = value;
	}

	private java.lang.String deptid;
	private java.lang.String acceptcheckname;
	private java.lang.String checkname1;
	private java.lang.String checknamephone;
	private java.util.Date checktime;
	private java.lang.String checkname2;
	private java.lang.String entering;
	private java.lang.String visitor;
	private java.lang.String duty;
	private java.lang.String finance;
	private java.lang.String speech;
	private java.lang.String implement;
	private java.lang.String implementInput;
	private java.lang.String visitorInput;
	private java.lang.String dutyInput;
	private java.lang.String financeInput;
	private java.lang.String speechInput;
	private java.lang.String enteringInput;
	private java.lang.String systemNormalUse;
	private java.lang.String systemInput;
	private java.lang.String intradaynews;
	private java.lang.String intradaynewsInput;
	private java.lang.String jdcmaintain;
	private java.lang.String jdcmaintainInput;
	private java.lang.String uploadquantityis;
	private java.lang.String uploadquantityiInput;
	private java.lang.String uploadtimely;
	private java.lang.String uploadtimelyInput;
	private java.lang.String safety;
	private java.lang.String safetyInput;
	private java.lang.String protection;
	private java.lang.String protectionInput;
	private java.lang.String dispose;
	private java.lang.String examine;
	private java.lang.String companyinfo;
	private java.lang.String remark;
	private java.util.Date deadline;
	//columns END

	public tpoliCk(){
	}

	public tpoliCk(
		Long checkid
	){
		this.checkid = checkid;
	}

	public void setCheckid(Long value) {
		this.checkid = value;
	}
	
	public Long getCheckid() {
		return this.checkid;
	}
	public void setDeptid(java.lang.String value) {
		this.deptid = value;
	}
	
	public java.lang.String getDeptid() {
		return this.deptid;
	}
	public void setAcceptcheckname(java.lang.String value) {
		this.acceptcheckname = value;
	}
	
	public java.lang.String getAcceptcheckname() {
		return this.acceptcheckname;
	}
	public void setCheckname1(java.lang.String value) {
		this.checkname1 = value;
	}
	
	public java.lang.String getCheckname1() {
		return this.checkname1;
	}
	public void setChecknamephone(java.lang.String value) {
		this.checknamephone = value;
	}
	
	public java.lang.String getChecknamephone() {
		return this.checknamephone;
	}
	public String getChecktimeString() {
		return date2String(getChecktime(), FORMAT_CHECKTIME);
	}
	public void setChecktimeString(String value) {
		setChecktime(string2Date(value, FORMAT_CHECKTIME,java.util.Date.class));
	}
	
	public void setChecktime(java.util.Date value) {
		this.checktime = value;
	}
	
	public java.util.Date getChecktime() {
		return this.checktime;
	}
	public void setCheckname2(java.lang.String value) {
		this.checkname2 = value;
	}
	
	public java.lang.String getCheckname2() {
		return this.checkname2;
	}
	public void setEntering(java.lang.String value) {
		this.entering = value;
	}
	
	public java.lang.String getEntering() {
		return this.entering;
	}
	public void setVisitor(java.lang.String value) {
		this.visitor = value;
	}
	
	public java.lang.String getVisitor() {
		return this.visitor;
	}
	public void setDuty(java.lang.String value) {
		this.duty = value;
	}
	
	public java.lang.String getDuty() {
		return this.duty;
	}
	public void setFinance(java.lang.String value) {
		this.finance = value;
	}
	
	public java.lang.String getFinance() {
		return this.finance;
	}
	public void setSpeech(java.lang.String value) {
		this.speech = value;
	}
	
	public java.lang.String getSpeech() {
		return this.speech;
	}
	public void setImplement(java.lang.String value) {
		this.implement = value;
	}
	
	public java.lang.String getImplement() {
		return this.implement;
	}
	public void setImplementInput(java.lang.String value) {
		this.implementInput = value;
	}
	
	public java.lang.String getImplementInput() {
		return this.implementInput;
	}
	public void setVisitorInput(java.lang.String value) {
		this.visitorInput = value;
	}
	
	public java.lang.String getVisitorInput() {
		return this.visitorInput;
	}
	public void setDutyInput(java.lang.String value) {
		this.dutyInput = value;
	}
	
	public java.lang.String getDutyInput() {
		return this.dutyInput;
	}
	public void setFinanceInput(java.lang.String value) {
		this.financeInput = value;
	}
	
	public java.lang.String getFinanceInput() {
		return this.financeInput;
	}
	public void setSpeechInput(java.lang.String value) {
		this.speechInput = value;
	}
	
	public java.lang.String getSpeechInput() {
		return this.speechInput;
	}
	public void setEnteringInput(java.lang.String value) {
		this.enteringInput = value;
	}
	
	public java.lang.String getEnteringInput() {
		return this.enteringInput;
	}
	public void setSystemNormalUse(java.lang.String value) {
		this.systemNormalUse = value;
	}
	
	public java.lang.String getSystemNormalUse() {
		return this.systemNormalUse;
	}
	public void setSystemInput(java.lang.String value) {
		this.systemInput = value;
	}
	
	public java.lang.String getSystemInput() {
		return this.systemInput;
	}
	public void setIntradaynews(java.lang.String value) {
		this.intradaynews = value;
	}
	
	public java.lang.String getIntradaynews() {
		return this.intradaynews;
	}
	public void setIntradaynewsInput(java.lang.String value) {
		this.intradaynewsInput = value;
	}
	
	public java.lang.String getIntradaynewsInput() {
		return this.intradaynewsInput;
	}
	public void setJdcmaintain(java.lang.String value) {
		this.jdcmaintain = value;
	}
	
	public java.lang.String getJdcmaintain() {
		return this.jdcmaintain;
	}
	public void setJdcmaintainInput(java.lang.String value) {
		this.jdcmaintainInput = value;
	}
	
	public java.lang.String getJdcmaintainInput() {
		return this.jdcmaintainInput;
	}
	public void setUploadquantityis(java.lang.String value) {
		this.uploadquantityis = value;
	}
	
	public java.lang.String getUploadquantityis() {
		return this.uploadquantityis;
	}
	public void setUploadquantityiInput(java.lang.String value) {
		this.uploadquantityiInput = value;
	}
	
	public java.lang.String getUploadquantityiInput() {
		return this.uploadquantityiInput;
	}
	public void setUploadtimely(java.lang.String value) {
		this.uploadtimely = value;
	}
	
	public java.lang.String getUploadtimely() {
		return this.uploadtimely;
	}
	public void setUploadtimelyInput(java.lang.String value) {
		this.uploadtimelyInput = value;
	}
	
	public java.lang.String getUploadtimelyInput() {
		return this.uploadtimelyInput;
	}
	public void setSafety(java.lang.String value) {
		this.safety = value;
	}
	
	public java.lang.String getSafety() {
		return this.safety;
	}
	public void setSafetyInput(java.lang.String value) {
		this.safetyInput = value;
	}
	
	public java.lang.String getSafetyInput() {
		return this.safetyInput;
	}
	public void setProtection(java.lang.String value) {
		this.protection = value;
	}
	
	public java.lang.String getProtection() {
		return this.protection;
	}
	public void setProtectionInput(java.lang.String value) {
		this.protectionInput = value;
	}
	
	public java.lang.String getProtectionInput() {
		return this.protectionInput;
	}
	public void setDispose(java.lang.String value) {
		this.dispose = value;
	}
	
	public java.lang.String getDispose() {
		return this.dispose;
	}
	public void setExamine(java.lang.String value) {
		this.examine = value;
	}
	
	public java.lang.String getExamine() {
		return this.examine;
	}
	public void setCompanyinfo(java.lang.String value) {
		this.companyinfo = value;
	}
	
	public java.lang.String getCompanyinfo() {
		return this.companyinfo;
	}
	public void setRemark(java.lang.String value) {
		this.remark = value;
	}
	
	public java.lang.String getRemark() {
		return this.remark;
	}
	public String getDeadlineString() {
		return date2String(getDeadline(), FORMAT_DEADLINE);
	}
	public void setDeadlineString(String value) {
		setDeadline(string2Date(value, FORMAT_DEADLINE,java.util.Date.class));
	}
	
	public void setDeadline(java.util.Date value) {
		this.deadline = value;
	}
	
	public java.util.Date getDeadline() {
		return this.deadline;
	}

	public String toString() {
		return new ToStringBuilder(this)
			.append("Checkid",getCheckid())
			.append("Deptid",getDeptid())
			.append("Acceptcheckname",getAcceptcheckname())
			.append("Checkname1",getCheckname1())
			.append("Checknamephone",getChecknamephone())
			.append("Checktime",getChecktime())
			.append("Checkname2",getCheckname2())
			.append("Entering",getEntering())
			.append("Visitor",getVisitor())
			.append("Duty",getDuty())
			.append("Finance",getFinance())
			.append("Speech",getSpeech())
			.append("Implement",getImplement())
			.append("ImplementInput",getImplementInput())
			.append("VisitorInput",getVisitorInput())
			.append("DutyInput",getDutyInput())
			.append("FinanceInput",getFinanceInput())
			.append("SpeechInput",getSpeechInput())
			.append("EnteringInput",getEnteringInput())
			.append("SystemNormalUse",getSystemNormalUse())
			.append("SystemInput",getSystemInput())
			.append("Intradaynews",getIntradaynews())
			.append("IntradaynewsInput",getIntradaynewsInput())
			.append("Jdcmaintain",getJdcmaintain())
			.append("JdcmaintainInput",getJdcmaintainInput())
			.append("Uploadquantityis",getUploadquantityis())
			.append("UploadquantityiInput",getUploadquantityiInput())
			.append("Uploadtimely",getUploadtimely())
			.append("UploadtimelyInput",getUploadtimelyInput())
			.append("Safety",getSafety())
			.append("SafetyInput",getSafetyInput())
			.append("Protection",getProtection())
			.append("ProtectionInput",getProtectionInput())
			.append("Dispose",getDispose())
			.append("Examine",getExamine())
			.append("Companyinfo",getCompanyinfo())
			.append("Remark",getRemark())
			.append("Deadline",getDeadline())
			.append("cpcode",getCpcode())
			.toString();
	}
	
	public int hashCode() {
		return new HashCodeBuilder()
			.append(getCheckid())
			.append(getDeptid())
			.append(getAcceptcheckname())
			.append(getCheckname1())
			.append(getChecknamephone())
			.append(getChecktime())
			.append(getCheckname2())
			.append(getEntering())
			.append(getVisitor())
			.append(getDuty())
			.append(getFinance())
			.append(getSpeech())
			.append(getImplement())
			.append(getImplementInput())
			.append(getVisitorInput())
			.append(getDutyInput())
			.append(getFinanceInput())
			.append(getSpeechInput())
			.append(getEnteringInput())
			.append(getSystemNormalUse())
			.append(getSystemInput())
			.append(getIntradaynews())
			.append(getIntradaynewsInput())
			.append(getJdcmaintain())
			.append(getJdcmaintainInput())
			.append(getUploadquantityis())
			.append(getUploadquantityiInput())
			.append(getUploadtimely())
			.append(getUploadtimelyInput())
			.append(getSafety())
			.append(getSafetyInput())
			.append(getProtection())
			.append(getProtectionInput())
			.append(getDispose())
			.append(getExamine())
			.append(getCompanyinfo())
			.append(getRemark())
			.append(getDeadline())
			.append(getCpcode())
			.toHashCode();
	}
	
	public boolean equals(Object obj) {
		if(obj instanceof tpoliCk == false) return false;
		if(this == obj) return true;
		tpoliCk other = (tpoliCk)obj;
		return new EqualsBuilder()
			.append(getCheckid(),other.getCheckid())
			.append(getDeptid(),other.getDeptid())
			.append(getAcceptcheckname(),other.getAcceptcheckname())
			.append(getCheckname1(),other.getCheckname1())
			.append(getChecknamephone(),other.getChecknamephone())
			.append(getChecktime(),other.getChecktime())
			.append(getCheckname2(),other.getCheckname2())
			.append(getEntering(),other.getEntering())
			.append(getVisitor(),other.getVisitor())
			.append(getDuty(),other.getDuty())
			.append(getFinance(),other.getFinance())
			.append(getSpeech(),other.getSpeech())
			.append(getImplement(),other.getImplement())
			.append(getImplementInput(),other.getImplementInput())
			.append(getVisitorInput(),other.getVisitorInput())
			.append(getDutyInput(),other.getDutyInput())
			.append(getFinanceInput(),other.getFinanceInput())
			.append(getSpeechInput(),other.getSpeechInput())
			.append(getEnteringInput(),other.getEnteringInput())
			.append(getSystemNormalUse(),other.getSystemNormalUse())
			.append(getSystemInput(),other.getSystemInput())
			.append(getIntradaynews(),other.getIntradaynews())
			.append(getIntradaynewsInput(),other.getIntradaynewsInput())
			.append(getJdcmaintain(),other.getJdcmaintain())
			.append(getJdcmaintainInput(),other.getJdcmaintainInput())
			.append(getUploadquantityis(),other.getUploadquantityis())
			.append(getUploadquantityiInput(),other.getUploadquantityiInput())
			.append(getUploadtimely(),other.getUploadtimely())
			.append(getUploadtimelyInput(),other.getUploadtimelyInput())
			.append(getSafety(),other.getSafety())
			.append(getSafetyInput(),other.getSafetyInput())
			.append(getProtection(),other.getProtection())
			.append(getProtectionInput(),other.getProtectionInput())
			.append(getDispose(),other.getDispose())
			.append(getExamine(),other.getExamine())
			.append(getCompanyinfo(),other.getCompanyinfo())
			.append(getRemark(),other.getRemark())
			.append(getDeadline(),other.getDeadline())
			.append(getCpcode(), other.getCpcode())
			.isEquals();
	}
}