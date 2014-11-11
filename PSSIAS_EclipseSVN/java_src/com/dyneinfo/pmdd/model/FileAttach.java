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

import com.dyneinfo.zazh.model.*;
import com.dyneinfo.zazh.dao.*;
import com.dyneinfo.zazh.service.*;

/**
 * @author lisc email:lishicheng(a)gmail.com
 */


public class FileAttach extends BaseEntity {
	
	//alias
	public static final String TABLE_ALIAS = "FileAttach";
	public static final String ALIAS_FILEID = "ID";
	public static final String ALIAS_FILENAME = "文件名";
	public static final String ALIAS_CONTENTTYPE = "文件类型";
	public static final String ALIAS_FILESIZE = "文件大小";
	public static final String ALIAS_FILEEXT = "扩展名";
	public static final String ALIAS_FILE_SAVE = "保存位置 F 文件 D 数据库";
	public static final String ALIAS_CONTENT = "数据库附件内容";
	public static final String ALIAS_FILEPATH = "文件路径";
	public static final String ALIAS_ABSOLUTEPATH = "相对路径";
	public static final String ALIAS_FILEGROUP = "文件组 对应数据库表名";
	public static final String ALIAS_RELATION_ID = "关联ID";
	public static final String ALIAS_NOTE = "说明";
	public static final String ALIAS_CREATETIME = "创建时间";
	public static final String ALIAS_CREATOR = "上传者";
	
	//date formats
	public static final String FORMAT_CREATETIME = DATE_TIME_FORMAT;
	
	//columns START
	private Long fileid;
	private java.lang.String filename;
	private java.lang.String contenttype;
	private int filesize;
	private java.lang.String fileext;
	private java.lang.String fileSave;
//	private java.sql.Blob content;
	private java.lang.String filepath;
	private java.lang.String absolutepath;
	private java.lang.String filegroup;
	private java.lang.String relationId;
	private java.lang.String note;
	private java.util.Date createtime;
	
	private java.sql.Date createtimeSql;
	
	private java.lang.String creator;
	//columns END

	public FileAttach(){
	}

	public FileAttach(
		Long fileid
	){
		this.fileid = fileid;
	}

	public void setFileid(Long value) {
		this.fileid = value;
	}
	
	public Long getFileid() {
		return this.fileid;
	}
	public void setFilename(java.lang.String value) {
		this.filename = value;
	}
	
	public java.lang.String getFilename() {
		return this.filename;
	}
	public void setContenttype(java.lang.String value) {
		this.contenttype = value;
	}
	
	public java.lang.String getContenttype() {
		return this.contenttype;
	}
	public void setFilesize(int value) {
		this.filesize = value;
	}
	
	public int getFilesize() {
		return this.filesize;
	}
	public void setFileext(java.lang.String value) {
		this.fileext = value;
	}
	
	public java.lang.String getFileext() {
		return this.fileext;
	}
	public void setFileSave(java.lang.String value) {
		this.fileSave = value;
	}
	
	public java.lang.String getFileSave() {
		return this.fileSave;
	}
//	public void setContent(java.sql.Blob value) {
//		this.content = value;
//	}
//	
//	public java.sql.Blob getContent() {
//		return this.content;
//	}
	public void setFilepath(java.lang.String value) {
		this.filepath = value;
	}
	
	public java.lang.String getFilepath() {
		return this.filepath;
	}
	public void setAbsolutepath(java.lang.String value) {
		this.absolutepath = value;
	}
	
	public java.lang.String getAbsolutepath() {
		return this.absolutepath;
	}
	public void setFilegroup(java.lang.String value) {
		this.filegroup = value;
	}
	
	public java.lang.String getFilegroup() {
		return this.filegroup;
	}
	public void setRelationId(java.lang.String value) {
		this.relationId = value;
	}
	
	public java.lang.String getRelationId() {
		return this.relationId;
	}
	public void setNote(java.lang.String value) {
		this.note = value;
	}
	
	public java.lang.String getNote() {
		return this.note;
	}
	public String getCreatetimeString() {
		return date2String(getCreatetime(), FORMAT_CREATETIME);
	}
	public void setCreatetimeString(String value) {
		setCreatetime(string2Date(value, FORMAT_CREATETIME,java.util.Date.class));
		setCreatetimeSql(string2Date(value,FORMAT_CREATETIME));
	}
	
	public void setCreatetime(java.util.Date value) {
		this.createtime = value;
	}
	
	public java.util.Date getCreatetime() {
		return this.createtime;
	}
	public void setCreator(java.lang.String value) {
		this.creator = value;
	}
	
	public java.lang.String getCreator() {
		return this.creator;
	}

	public String toString() {
		return new ToStringBuilder(this)
			.append("Fileid",getFileid())
			.append("Filename",getFilename())
			.append("Contenttype",getContenttype())
			.append("Filesize",getFilesize())
			.append("Fileext",getFileext())
			.append("FileSave",getFileSave())
		//	.append("Content",getContent())
			.append("Filepath",getFilepath())
			.append("Absolutepath",getAbsolutepath())
			.append("Filegroup",getFilegroup())
			.append("RelationId",getRelationId())
			.append("Note",getNote())
			.append("Createtime",getCreatetime())
			.append("Creator",getCreator())
			.toString();
	}
	
	public int hashCode() {
		return new HashCodeBuilder()
			.append(getFileid())
			.append(getFilename())
			.append(getContenttype())
			.append(getFilesize())
			.append(getFileext())
			.append(getFileSave())
			//.append(getContent())
			.append(getFilepath())
			.append(getAbsolutepath())
			.append(getFilegroup())
			.append(getRelationId())
			.append(getNote())
			.append(getCreatetime())
			.append(getCreator())
			.toHashCode();
	}
	
	public boolean equals(Object obj) {
		if(obj instanceof FileAttach == false) return false;
		if(this == obj) return true;
		FileAttach other = (FileAttach)obj;
		return new EqualsBuilder()
			.append(getFileid(),other.getFileid())
			.append(getFilename(),other.getFilename())
			.append(getContenttype(),other.getContenttype())
			.append(getFilesize(),other.getFilesize())
			.append(getFileext(),other.getFileext())
			.append(getFileSave(),other.getFileSave())
			//.append(getContent(),other.getContent())
			.append(getFilepath(),other.getFilepath())
			.append(getAbsolutepath(),other.getAbsolutepath())
			.append(getFilegroup(),other.getFilegroup())
			.append(getRelationId(),other.getRelationId())
			.append(getNote(),other.getNote())
			.append(getCreatetime(),other.getCreatetime())
			.append(getCreator(),other.getCreator())
			.isEquals();
	}

	public java.sql.Date getCreatetimeSql() {
		return createtimeSql;
	}

	public void setCreatetimeSql(java.sql.Date createtimeSql) {
		this.createtimeSql = createtimeSql;
	}
}

