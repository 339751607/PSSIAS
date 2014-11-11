/*
 * Powered By [lishicheng]
 */

package com.dyneinfo.jxy.model;

import javacommon.base.BaseEntity;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

/**
 * @author lisc email:lishicheng(a)gmail.com
 */


public class Tcarcaseinfo extends BaseEntity {
	
	//alias
	public static final String TABLE_ALIAS = "事故车辆";
	public static final String ALIAS_ENROLID = "登记序号";
	public static final String ALIAS_CREDID = "事故证明编号";
	public static final String ALIAS_CREDUNIT = "事故证明出具单位名称";
	public static final String ALIAS_PARTI = "损坏部位一";
	public static final String ALIAS_PARTII = "损坏部位二";
	public static final String ALIAS_PARTIII = "损坏部位三";
	public static final String ALIAS_REPORTER = "报告人";
	public static final String ALIAS_REPTIME = "报告时间";
	public static final String ALIAS_DEMO = "备注";
	public static final String ALIAS_FLAG = "是否删除";
	public static final String ALIAS_ENROLTIME = "登记时间";
	public static final String ALIAS_OPERATOR = "操作员";
	
	//date formats
	
	//columns START
	private java.lang.String enrolid;
	private java.lang.String credid;
	private java.lang.String credunit;
	private java.lang.String parti;
	private java.lang.String partii;
	private java.lang.String partiii;
	private java.lang.String reporter;
	private java.lang.String reptime;
	private java.lang.String demo;
	private java.lang.String flag;
	private java.lang.String enroltime;
	private java.lang.String operator;
	//columns END

	public Tcarcaseinfo(){
	}

	public Tcarcaseinfo(
		java.lang.String enrolid
	){
		this.enrolid = enrolid;
	}

	public void setEnrolid(java.lang.String value) {
		this.enrolid = value;
	}
	
	public java.lang.String getEnrolid() {
		return this.enrolid;
	}
	public void setCredid(java.lang.String value) {
		this.credid = value;
	}
	
	public java.lang.String getCredid() {
		return this.credid;
	}
	public void setCredunit(java.lang.String value) {
		this.credunit = value;
	}
	
	public java.lang.String getCredunit() {
		return this.credunit;
	}
	public void setParti(java.lang.String value) {
		this.parti = value;
	}
	
	public java.lang.String getParti() {
		return this.parti;
	}
	public void setPartii(java.lang.String value) {
		this.partii = value;
	}
	
	public java.lang.String getPartii() {
		return this.partii;
	}
	public void setPartiii(java.lang.String value) {
		this.partiii = value;
	}
	
	public java.lang.String getPartiii() {
		return this.partiii;
	}
	public void setReporter(java.lang.String value) {
		this.reporter = value;
	}
	
	public java.lang.String getReporter() {
		return this.reporter;
	}
	public void setReptime(java.lang.String value) {
		this.reptime = value;
	}
	
	public java.lang.String getReptime() {
		return this.reptime;
	}
	public void setDemo(java.lang.String value) {
		this.demo = value;
	}
	
	public java.lang.String getDemo() {
		return this.demo;
	}
	public void setFlag(java.lang.String value) {
		this.flag = value;
	}
	
	public java.lang.String getFlag() {
		return this.flag;
	}
	public void setEnroltime(java.lang.String value) {
		this.enroltime = value;
	}
	
	public java.lang.String getEnroltime() {
		return this.enroltime;
	}
	public void setOperator(java.lang.String value) {
		this.operator = value;
	}
	
	public java.lang.String getOperator() {
		return this.operator;
	}

	public String toString() {
		return new ToStringBuilder(this)
			.append("Enrolid",getEnrolid())
			.append("Credid",getCredid())
			.append("Credunit",getCredunit())
			.append("Parti",getParti())
			.append("Partii",getPartii())
			.append("Partiii",getPartiii())
			.append("Reporter",getReporter())
			.append("Reptime",getReptime())
			.append("Demo",getDemo())
			.append("Flag",getFlag())
			.append("Enroltime",getEnroltime())
			.append("Operator",getOperator())
			.toString();
	}
	
	public int hashCode() {
		return new HashCodeBuilder()
			.append(getEnrolid())
			.append(getCredid())
			.append(getCredunit())
			.append(getParti())
			.append(getPartii())
			.append(getPartiii())
			.append(getReporter())
			.append(getReptime())
			.append(getDemo())
			.append(getFlag())
			.append(getEnroltime())
			.append(getOperator())
			.toHashCode();
	}
	
	public boolean equals(Object obj) {
		if(obj instanceof Tcarcaseinfo == false) return false;
		if(this == obj) return true;
		Tcarcaseinfo other = (Tcarcaseinfo)obj;
		return new EqualsBuilder()
			.append(getEnrolid(),other.getEnrolid())
			.append(getCredid(),other.getCredid())
			.append(getCredunit(),other.getCredunit())
			.append(getParti(),other.getParti())
			.append(getPartii(),other.getPartii())
			.append(getPartiii(),other.getPartiii())
			.append(getReporter(),other.getReporter())
			.append(getReptime(),other.getReptime())
			.append(getDemo(),other.getDemo())
			.append(getFlag(),other.getFlag())
			.append(getEnroltime(),other.getEnroltime())
			.append(getOperator(),other.getOperator())
			.isEquals();
	}
}

