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


public class Tcarinfo extends BaseEntity {
	
	//alias
	public static final String TABLE_ALIAS = "车辆信息";
	public static final String ALIAS_ENROLID = "登记序号";
	public static final String ALIAS_CAROWNER = "车主";
	public static final String ALIAS_CARTYPE = "车辆类型";
	public static final String ALIAS_BRAND = "车辆品牌";
	public static final String ALIAS_COLOR = "车身颜色";
	public static final String ALIAS_CARID = "车牌号";
	public static final String ALIAS_ENGINECODE = "发动机号";
	public static final String ALIAS_BODYCODE = "车架号";
	public static final String ALIAS_CLSBCODE = "车辆识别代码";
	public static final String ALIAS_ENROLTIME = "登记时间";
	public static final String ALIAS_OPERATOR = "操作员";
	public static final String ALIAS_CPCODE = "企业编号";
	public static final String ALIAS_FLAG = "车辆状态";
	public static final String ALIAS_CARPICTURE = "车辆照片";
	public static final String ALIAS_XSZ = "行驶证";
	public static final String ALIAS_ZJLX = "证件类型";
	
	
	//date formats
	
	//columns START
	//CLSBCODE
	private java.lang.String clsbcode;
	public java.lang.String getClsbcode() {
		return clsbcode;
	}

	public void setClsbcode(java.lang.String value) {
		this.clsbcode = value;
	}

	private java.lang.String enrolid;
	private java.lang.String carowner;
	private java.lang.String cartype;
	private java.lang.String brand;
	private java.lang.String color;
	private java.lang.String carid;
	private java.lang.String enginecode;
	private java.lang.String bodycode;
	private java.lang.String enroltime;
	private java.lang.String operator;
	private java.lang.String cpcode;
	private java.lang.String flag;
	private java.sql.Blob carpicture;
	private java.lang.String color1;
	private java.lang.String color2;
	private java.lang.String color3;
	private java.lang.String carid1;
	private java.lang.String carid2;
	

	private java.lang.String deliname;//送车人姓名
	private java.lang.String delicredcode;//送车人身份证号码
	private java.lang.String delitelephone;//送车人电话号码
	private java.lang.String recename;//收车人姓名
	private java.lang.String recetime;//收车时间
	private java.lang.String serveritem;//服务项目
	private java.lang.String takeoffname;//取车人姓名
	private java.lang.String tocredcode;//取车人证件号码
	private java.lang.String totime;//取车时间
	private java.lang.String demo;//备注
	private java.lang.String deliaddress;//送车人住址 add by zzq 2012/06/12
	
	
	public java.lang.String deptname;
	//columns END

	public java.lang.String getDeptname() {
		return this.deptname;
	}

	public void setDeptname(java.lang.String value) {
		this.deptname = value;
	}

	public Tcarinfo(){
	}

	public Tcarinfo(
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
	public void setCarowner(java.lang.String value) {
		this.carowner = value;
	}
	
	public java.lang.String getCarowner() {
		return this.carowner;
	}
	public void setCartype(java.lang.String value) {
		this.cartype = value;
	}
	
	public java.lang.String getCartype() {
		return this.cartype;
	}
	public void setBrand(java.lang.String value) {
		this.brand = value;
	}
	
	public java.lang.String getBrand() {
		return this.brand;
	}
	public void setColor(java.lang.String value) {
		this.color = value;
	}
	
	public java.lang.String getColor() {
		return this.color;
	}
	public void setCarid(java.lang.String value) {
		this.carid = value;
	}
	
	public java.lang.String getCarid() {
		return this.carid;
	}
	public void setEnginecode(java.lang.String value) {
		this.enginecode = value;
	}
	
	public java.lang.String getEnginecode() {
		return this.enginecode;
	}
	public void setBodycode(java.lang.String value) {
		this.bodycode = value;
	}
	
	public java.lang.String getBodycode() {
		return this.bodycode;
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
	public void setCpcode(java.lang.String value) {
		this.cpcode = value;
	}
	
	public java.lang.String getCpcode() {
		return this.cpcode;
	}
	public void setFlag(java.lang.String value) {
		this.flag = value;
	}
	
	public java.lang.String getFlag() {
		return this.flag;
	}
	public void setCarpicture(java.sql.Blob value) {
		this.carpicture = value;
	}
	
	public java.sql.Blob getCarpicture() {
		return this.carpicture;
	}

	public String toString() {
		return new ToStringBuilder(this)
			.append("Enrolid",getEnrolid())
			.append("Carowner",getCarowner())
			.append("Cartype",getCartype())
			.append("Brand",getBrand())
			.append("Color",getColor())
			.append("Carid",getCarid())
			.append("Enginecode",getEnginecode())
			.append("Bodycode",getBodycode())
			.append("Enroltime",getEnroltime())
			.append("Operator",getOperator())
			.append("Cpcode",getCpcode())
			.append("Flag",getFlag())
			.append("Carpicture",getCarpicture())
			.append("deptname",getDeptname())
			.append("clsbcode",getClsbcode())
			.toString();
	}
	
	public int hashCode() {
		return new HashCodeBuilder()
			.append(getEnrolid())
			.append(getCarowner())
			.append(getCartype())
			.append(getBrand())
			.append(getColor())
			.append(getCarid())
			.append(getEnginecode())
			.append(getBodycode())
			.append(getEnroltime())
			.append(getOperator())
			.append(getCpcode())
			.append(getFlag())
			.append(getCarpicture())
			.append(getDeptname())
			.append(getClsbcode())
			.toHashCode();
	}
	
	public boolean equals(Object obj) {
		if(obj instanceof Tcarinfo == false) return false;
		if(this == obj) return true;
		Tcarinfo other = (Tcarinfo)obj;
		return new EqualsBuilder()
			.append(getEnrolid(),other.getEnrolid())
			.append(getCarowner(),other.getCarowner())
			.append(getCartype(),other.getCartype())
			.append(getBrand(),other.getBrand())
			.append(getColor(),other.getColor())
			.append(getCarid(),other.getCarid())
			.append(getEnginecode(),other.getEnginecode())
			.append(getBodycode(),other.getBodycode())
			.append(getEnroltime(),other.getEnroltime())
			.append(getOperator(),other.getOperator())
			.append(getCpcode(),other.getCpcode())
			.append(getFlag(),other.getFlag())
			.append(getCarpicture(),other.getCarpicture())
			.append(getDeptname(), other.getDeptname())
			.append(getClsbcode(), other.getClsbcode())
			.isEquals();
	}

	public java.lang.String getDeliname() {
		return deliname;
	}

	public void setDeliname(java.lang.String deliname) {
		this.deliname = deliname;
	}


	public java.lang.String getDelicredcode() {
		return delicredcode;
	}

	public void setDelicredcode(java.lang.String delicredcode) {
		this.delicredcode = delicredcode;
	}

	public java.lang.String getRecetime() {
		return recetime;
	}

	public void setRecetime(java.lang.String recetime) {
		this.recetime = recetime;
	}

	public java.lang.String getRecename() {
		return recename;
	}

	public void setRecename(java.lang.String recename) {
		this.recename = recename;
	}

	public java.lang.String getTakeoffname() {
		return takeoffname;
	}

	public void setTakeoffname(java.lang.String takeoffname) {
		this.takeoffname = takeoffname;
	}



	public java.lang.String getTocredcode() {
		return tocredcode;
	}

	public void setTocredcode(java.lang.String tocredcode) {
		this.tocredcode = tocredcode;
	}

	public java.lang.String getTotime() {
		return totime;
	}

	public void setTotime(java.lang.String totime) {
		this.totime = totime;
	}

	public java.lang.String getDelitelephone() {
		return delitelephone;
	}

	public void setDelitelephone(java.lang.String delitelephone) {
		this.delitelephone = delitelephone;
	}

	public java.lang.String getServeritem() {
		return serveritem;
	}

	public void setServeritem(java.lang.String serveritem) {
		this.serveritem = serveritem;
	}

	public java.lang.String getDemo() {
		return demo;
	}

	public void setDemo(java.lang.String demo) {
		this.demo = demo;
	}

	public java.lang.String getColor1() {
		return color1;
	}

	public void setColor1(java.lang.String color1) {
		this.color1 = color1;
	}

	public java.lang.String getColor2() {
		return color2;
	}

	public void setColor2(java.lang.String color2) {
		this.color2 = color2;
	}

	public java.lang.String getColor3() {
		return color3;
	}

	public void setColor3(java.lang.String color3) {
		this.color3 = color3;
	}

	public java.lang.String getCarid1() {
		return carid1;
	}

	public void setCarid1(java.lang.String carid1) {
		this.carid1 = carid1;
	}

	public java.lang.String getDeliaddress() {
		return deliaddress;
	}

	public void setDeliaddress(java.lang.String deliaddress) {
		this.deliaddress = deliaddress;
	}

	public java.lang.String getCarid2() {
		return carid2;
	}

	public void setCarid2(java.lang.String carid2) {
		this.carid2 = carid2;
	}
}

