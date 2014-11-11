package com.dyneinfo.ylcs.model;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

/**
 * @author liutao - 刘涛
 * @category satisfic model class 治安综合平台统计模型类
 * @since 2014/10/29
 * @see  菜单：治安综合平台 - 上传情况统计 
 */
public class SatisficInfo {
	public static final String TABLE_ALIAS = "治安综合平台统计信息表";  //没有实际表，为存储过程的查询结果p_stastic_onload
	public static final String ALIAS_TYPE = "行业类型";  //所属那个行业。如“001”- 旅馆业
	public static final String ALIAS_DEPTID = "机构代码";  //
	public static final String ALIAS_DEPTNAME = "机构名称";  //
	public static final String ALIAS_OPENNUM = "营业数";  //
	public static final String ALIAS_UPLOADNUM = "上传数";  //
	public static final String ALIAS_NOTUPLOADNUM = "未上传数";  //
	
	private String type;
	private String deptId;
	private String deptName;
	private String    openNum; //营业数
	private String uploadNum; //上传数
	private String notUploadNum;//未上传数   (未上传数 = 营业数 - 上传数)
	
	
	
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getDeptId() {
		return deptId;
	}
	public void setDeptId(String deptId) {
		this.deptId = deptId;
	}
	public String getDeptName() {
		return deptName;
	}
	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}
	public String getOpenNum() {
		return openNum;
	}
	public void setOpenNum(String openNum) {
		this.openNum = openNum;
	}
	public String getUploadNum() {
		return uploadNum;
	}
	public void setUploadNum(String uploadNum) {
		this.uploadNum = uploadNum;
	}
	public String getNotUploadNum() {
		return notUploadNum;
	}
	public void setNotUploadNum(String notUploadNum) {
		this.notUploadNum = notUploadNum;
	}
	
	public String toString() {
		return new ToStringBuilder(this)
			.append("Type",getType())
			.append("DeptId",getDeptId())
			.append("DeptName",getDeptName())
			.append("OpenNum",getOpenNum())
			.append("UploadNum",getUploadNum())
			.append("NotUploadNum",getNotUploadNum())
			.toString();
	}
	
	public int hashCode() {
		return new HashCodeBuilder()
			.append(getType())
			.append(getDeptId())
			.append(getDeptName())
			.append(getOpenNum())
			.append(getUploadNum())
			.append(getNotUploadNum())
			.toHashCode();
	}
	
	public boolean equals(Object obj) {
		if(obj instanceof SatisficInfo == false) return false;
		if(this == obj) return true;
		SatisficInfo other = (SatisficInfo)obj;
		return new EqualsBuilder()
			.append(getType(),other.getType())
			.append(getDeptId(),other.getDeptId())
			.append(getDeptName(),other.getDeptName())
			.append(getOpenNum(),other.getOpenNum())
			.append(getUploadNum(),other.getUploadNum())
			.append(getNotUploadNum(),other.getNotUploadNum())
			.isEquals();
	}
	
	
}
