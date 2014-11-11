
package com.dyneinfo.zazh.model;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;
import net.java.dev.common.dict.ISelectOption;


/**
 * @author lisc email:lishicheng(a)gmail.com
 */


public class DictItem implements java.io.Serializable ,ISelectOption{
	
	
	
	//date formats
	
	//columns START
	private java.lang.String dicttypeid;
	private java.lang.String dictid;
	private java.lang.String dictname;
	private java.lang.Long status;
	private java.lang.Long sortno;
	private java.lang.Long dictlevel;
	private java.lang.String parentid;
	private java.lang.String seqno;
	//columns END

	public DictItem(){
	}

	public DictItem(
		java.lang.String dicttypeid,
		java.lang.String dictid
	){
		this.dicttypeid = dicttypeid;
		this.dictid = dictid;
	}

	public void setDicttypeid(java.lang.String value) {
		this.dicttypeid = value;
	}
	
	public java.lang.String getDicttypeid() {
		return this.dicttypeid;
	}
	public void setDictid(java.lang.String value) {
		this.dictid = value;
	}
	
	public java.lang.String getDictid() {
		return this.dictid;
	}
	public void setDictname(java.lang.String value) {
		this.dictname = value;
	}
	
	public java.lang.String getDictname() {
		return this.dictname;
	}
	public void setStatus(java.lang.Long value) {
		this.status = value;
	}
	
	public java.lang.Long getStatus() {
		return this.status;
	}
	public void setSortno(java.lang.Long value) {
		this.sortno = value;
	}
	
	public java.lang.Long getSortno() {
		return this.sortno;
	}
	public void setDictlevel(java.lang.Long value) {
		this.dictlevel = value;
	}
	
	public java.lang.Long getDictlevel() {
		return this.dictlevel;
	}
	public void setParentid(java.lang.String value) {
		this.parentid = value;
	}
	
	public java.lang.String getParentid() {
		return this.parentid;
	}
	public void setSeqno(java.lang.String value) {
		this.seqno = value;
	}
	
	public java.lang.String getSeqno() {
		return this.seqno;
	}
	
	
	public String getValue() {
		return this.dictid + "";
	}

	public void setValue(String value) {
		this.dictid = value;
	}

	public String getName() {
		return this.dictname;
	}

	public void setName(String name) {
		this.dictname = name;
	}

	public String toString() {
		return new ToStringBuilder(this)
			.append("Dicttypeid",getDicttypeid())
			.append("Dictid",getDictid())
			.append("Dictname",getDictname())
			.append("Status",getStatus())
			.append("Sortno",getSortno())
			.append("Dictlevel",getDictlevel())
			.append("Parentid",getParentid())
			.append("Seqno",getSeqno())
			.toString();
	}
	
	public int hashCode() {
		return new HashCodeBuilder()
			.append(getDicttypeid())
			.append(getDictid())
			.append(getDictname())
			.append(getStatus())
			.append(getSortno())
			.append(getDictlevel())
			.append(getParentid())
			.append(getSeqno())
			.toHashCode();
	}
	
	public boolean equals(Object obj) {
		if(obj instanceof DictItem == false) return false;
		if(this == obj) return true;
		DictItem other = (DictItem)obj;
		return new EqualsBuilder()
			.append(getDicttypeid(),other.getDicttypeid())
			.append(getDictid(),other.getDictid())
			.append(getDictname(),other.getDictname())
			.append(getStatus(),other.getStatus())
			.append(getSortno(),other.getSortno())
			.append(getDictlevel(),other.getDictlevel())
			.append(getParentid(),other.getParentid())
			.append(getSeqno(),other.getSeqno())
			.isEquals();
	}
}

