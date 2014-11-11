/*
 * Powered By []
 * Web Site: 
 * 
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
 * @author  email: lee(a)gmail.com
 * @version 1.0
 * @since 1.0
 */


public class SsMenu extends BaseEntity {
	
	//alias
	public static final String TABLE_ALIAS = "SsMenu";
	public static final String ALIAS_MENUID = "菜单ID";
	public static final String ALIAS_MENUNAME = "菜单名称";
	public static final String ALIAS_MENUDESC = "菜单描述";
	public static final String ALIAS_MENULABEL = "菜单显示";
	public static final String ALIAS_ISLEAF = "是否子节点";
	public static final String ALIAS_MENUURL = "菜单链接";
	public static final String ALIAS_MENULEVEL = "菜单层数";
	public static final String ALIAS_ROOTID = "ROOTID";
	public static final String ALIAS_PARENTID = "父菜单ID";
	public static final String ALIAS_IMAGEPATH = "图片路径";
	public static final String ALIAS_MENUSEQ = "层级关系";
	public static final String ALIAS_DISPLAYORDER = "显示顺序";
	
	//date formats
	
	//columns START
	private java.lang.Long menuid;
	private java.lang.String menuname;
	private java.lang.String menudesc;
	private java.lang.String menulabel;
	private java.lang.String isleaf;
	private java.lang.String menuurl;
	private java.lang.String menulevel;
	private java.lang.String rootid;
	private java.lang.Long parentid;
	private java.lang.String imagepath;
	private java.lang.String menuseq;
	private java.lang.Long displayorder;
	
	  /** * checked. */
    private boolean checked = false;
	//columns END

	public SsMenu(){
	}

	public SsMenu(
		java.lang.Long menuid
	){
		this.menuid = menuid;
	}

	public void setMenuid(java.lang.Long value) {
		this.menuid = value;
	}
	
	public java.lang.Long getMenuid() {
		return this.menuid;
	}
	public void setMenuname(java.lang.String value) {
		this.menuname = value;
	}
	
	public java.lang.String getMenuname() {
		return this.menuname;
	}
	public void setMenudesc(java.lang.String value) {
		this.menudesc = value;
	}
	
	public java.lang.String getMenudesc() {
		return this.menudesc;
	}
	public void setMenulabel(java.lang.String value) {
		this.menulabel = value;
	}
	
	public java.lang.String getMenulabel() {
		return this.menulabel;
	}
	public void setIsleaf(java.lang.String value) {
		this.isleaf = value;
	}
	
	public java.lang.String getIsleaf() {
		return this.isleaf;
	}
	public void setMenuurl(java.lang.String value) {
		this.menuurl = value;
	}
	
	public java.lang.String getMenuurl() {
		return this.menuurl;
	}
	public void setMenulevel(java.lang.String value) {
		this.menulevel = value;
	}
	
	public java.lang.String getMenulevel() {
		return this.menulevel;
	}
	public void setRootid(java.lang.String value) {
		this.rootid = value;
	}
	
	public java.lang.String getRootid() {
		return this.rootid;
	}
	public void setParentid(java.lang.Long value) {
		this.parentid = value;
	}
	
	public java.lang.Long getParentid() {
		return this.parentid;
	}
	public void setImagepath(java.lang.String value) {
		this.imagepath = value;
	}
	
	public java.lang.String getImagepath() {
		return this.imagepath;
	}
	public void setMenuseq(java.lang.String value) {
		this.menuseq = value;
	}
	
	public java.lang.String getMenuseq() {
		return this.menuseq;
	}
	public void setDisplayorder(java.lang.Long value) {
		this.displayorder = value;
	}
	
	public java.lang.Long getDisplayorder() {
		return this.displayorder;
	}
	
    public Set<SsMenu> getChildren() {
        return children;
    }

    /** * @param children Set. */
    public void setChildren(Set<SsMenu> children) {
        this.children = children;
    }
	
	 public boolean isChecked() {
	        return checked;
	    }

	    /** * @param checked boolean. */
	    public void setChecked(boolean checked) {
	        this.checked = checked;
	    }
	private Set<SsMenu> children = new HashSet<SsMenu>(0);
	

	public String toString() {
		return new ToStringBuilder(this)
			.append("Menuid",getMenuid())
			.append("Menuname",getMenuname())
			.append("Menudesc",getMenudesc())
			.append("Menulabel",getMenulabel())
			.append("Isleaf",getIsleaf())
			.append("Menuurl",getMenuurl())
			.append("Menulevel",getMenulevel())
			.append("Rootid",getRootid())
			.append("Parentid",getParentid())
			.append("Imagepath",getImagepath())
			.append("Menuseq",getMenuseq())
			.append("Displayorder",getDisplayorder())
			.toString();
	}
	
	public int hashCode() {
		return new HashCodeBuilder()
			.append(getMenuid())
			.append(getMenuname())
			.append(getMenudesc())
			.append(getMenulabel())
			.append(getIsleaf())
			.append(getMenuurl())
			.append(getMenulevel())
			.append(getRootid())
			.append(getParentid())
			.append(getImagepath())
			.append(getMenuseq())
			.append(getDisplayorder())
			.toHashCode();
	}
	
	public boolean equals(Object obj) {
		if(obj instanceof SsMenu == false) return false;
		if(this == obj) return true;
		SsMenu other = (SsMenu)obj;
		return new EqualsBuilder()
			.append(getMenuid(),other.getMenuid())
			.append(getMenuname(),other.getMenuname())
			.append(getMenudesc(),other.getMenudesc())
			.append(getMenulabel(),other.getMenulabel())
			.append(getIsleaf(),other.getIsleaf())
			.append(getMenuurl(),other.getMenuurl())
			.append(getMenulevel(),other.getMenulevel())
			.append(getRootid(),other.getRootid())
			.append(getParentid(),other.getParentid())
			.append(getImagepath(),other.getImagepath())
			.append(getMenuseq(),other.getMenuseq())
			.append(getDisplayorder(),other.getDisplayorder())
			.isEquals();
	}
}

