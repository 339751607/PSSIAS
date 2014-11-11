
package com.dyneinfo.zazh.model;

import javacommon.base.BaseEntity;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

/**
 * @author lishicheng(a)gmail.com
 * @version 1.0
 * @since 1.0
 */


public class AsecurityMenu extends BaseEntity {
	
	//alias
	public static final String TABLE_ALIAS = "AsecurityMenu";
	public static final String ALIAS_ID = "id";
	public static final String ALIAS_URL = "url";
	public static final String ALIAS_THE_SORT = "theSort";
	public static final String ALIAS_QTIP = "qtip";
	public static final String ALIAS_DESCN = "descn";
	public static final String ALIAS_NAME = "name";
	public static final String ALIAS_IMAGE = "image";
	public static final String ALIAS_PARENT_ID = "parentId";
	public static final String ALIAS_ISLEAF = "isleaf";
	public static final String ALIAS_ROOTID = "rootid";
	public static final String ALIAS_MENULEVEL = "menulevel";
	public static final String ALIAS_MENUSEQ = "menuseq";
	
	//date formats
	
	//columns START
	private java.math.BigDecimal id;
	private java.lang.String url;
	private java.math.BigDecimal theSort;
	private java.lang.String qtip;
	private java.lang.String descn;
	private java.lang.String name;
	private java.lang.String image;
	private java.math.BigDecimal parentId;
	private java.lang.String isleaf;
	private java.lang.String rootid;
	private java.lang.String menulevel;
	private java.lang.String menuseq;
	//columns END

	public AsecurityMenu(){
	}

	public AsecurityMenu(
		java.math.BigDecimal id
	){
		this.id = id;
	}

	public void setId(java.math.BigDecimal value) {
		this.id = value;
	}
	
	public java.math.BigDecimal getId() {
		return this.id;
	}
	public void setUrl(java.lang.String value) {
		this.url = value;
	}
	
	public java.lang.String getUrl() {
		return this.url;
	}
	public void setTheSort(java.math.BigDecimal value) {
		this.theSort = value;
	}
	
	public java.math.BigDecimal getTheSort() {
		return this.theSort;
	}
	public void setQtip(java.lang.String value) {
		this.qtip = value;
	}
	
	public java.lang.String getQtip() {
		return this.qtip;
	}
	public void setDescn(java.lang.String value) {
		this.descn = value;
	}
	
	public java.lang.String getDescn() {
		return this.descn;
	}
	public void setName(java.lang.String value) {
		this.name = value;
	}
	
	public java.lang.String getName() {
		return this.name;
	}
	public void setImage(java.lang.String value) {
		this.image = value;
	}
	
	public java.lang.String getImage() {
		return this.image;
	}
	public void setParentId(java.math.BigDecimal value) {
		this.parentId = value;
	}
	
	public java.math.BigDecimal getParentId() {
		return this.parentId;
	}
	public void setIsleaf(java.lang.String value) {
		this.isleaf = value;
	}
	
	public java.lang.String getIsleaf() {
		return this.isleaf;
	}
	public void setRootid(java.lang.String value) {
		this.rootid = value;
	}
	
	public java.lang.String getRootid() {
		return this.rootid;
	}
	public void setMenulevel(java.lang.String value) {
		this.menulevel = value;
	}
	
	public java.lang.String getMenulevel() {
		return this.menulevel;
	}
	public void setMenuseq(java.lang.String value) {
		this.menuseq = value;
	}
	
	public java.lang.String getMenuseq() {
		return this.menuseq;
	}

	public String toString() {
		return new ToStringBuilder(this)
			.append("Id",getId())
			.append("Url",getUrl())
			.append("TheSort",getTheSort())
			.append("Qtip",getQtip())
			.append("Descn",getDescn())
			.append("Name",getName())
			.append("Image",getImage())
			.append("ParentId",getParentId())
			.append("Isleaf",getIsleaf())
			.append("Rootid",getRootid())
			.append("Menulevel",getMenulevel())
			.append("Menuseq",getMenuseq())
			.toString();
	}
	
	public int hashCode() {
		return new HashCodeBuilder()
			.append(getId())
			.append(getUrl())
			.append(getTheSort())
			.append(getQtip())
			.append(getDescn())
			.append(getName())
			.append(getImage())
			.append(getParentId())
			.append(getIsleaf())
			.append(getRootid())
			.append(getMenulevel())
			.append(getMenuseq())
			.toHashCode();
	}
	
	public boolean equals(Object obj) {
		if(obj instanceof AsecurityMenu == false) return false;
		if(this == obj) return true;
		AsecurityMenu other = (AsecurityMenu)obj;
		return new EqualsBuilder()
			.append(getId(),other.getId())
			.append(getUrl(),other.getUrl())
			.append(getTheSort(),other.getTheSort())
			.append(getQtip(),other.getQtip())
			.append(getDescn(),other.getDescn())
			.append(getName(),other.getName())
			.append(getImage(),other.getImage())
			.append(getParentId(),other.getParentId())
			.append(getIsleaf(),other.getIsleaf())
			.append(getRootid(),other.getRootid())
			.append(getMenulevel(),other.getMenulevel())
			.append(getMenuseq(),other.getMenuseq())
			.isEquals();
	}
}

