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


public class SsRole extends BaseEntity {
	
	//alias
	public static final String TABLE_ALIAS = "SsRole";
	public static final String ALIAS_ROLEID = "角色ID";
	public static final String ALIAS_ROLENAME = "角色名称";
	public static final String ALIAS_ROLEDESC = "角色描述";

	
	//date formats
	
	//columns START
	private java.lang.Long roleid;
	private java.lang.String rolename;
	private java.lang.String roledesc;
	private java.lang.String roleseq;
	private Long parentid;
	private Long rolelevel;
	private java.lang.String businesscode;
	private java.lang.String strRoleid;
	  /** * 是否授权. */
    private Boolean authorized;
    /** * users. */
    private Set<SsUser> users = new HashSet<SsUser>(0);

    /** * rescs. */
    private Set<SsAuthority> rescs = new HashSet<SsAuthority>(0);

    /** * menus. */
    private Set<SsMenu> menus = new HashSet<SsMenu>(0);
	//columns END

	public SsRole(){
	}

	public SsRole(
		java.lang.Long roleid
	){
		this.roleid = roleid;
	}

	public void setRoleid(java.lang.Long value) {
		this.roleid = value;
	}
	
	public java.lang.Long getRoleid() {
		return this.roleid;
	}
	public void setRolename(java.lang.String value) {
		this.rolename = value;
	}
	
	public java.lang.String getRolename() {
		return this.rolename;
	}
	public void setRoledesc(java.lang.String value) {
		this.roledesc = value;
	}
	
	public java.lang.String getRoledesc() {
		return this.roledesc;
	}
	


	public String toString() {
		return new ToStringBuilder(this)
			.append("Roleid",getRoleid())
			.append("Rolename",getRolename())
			.append("Roledesc",getRoledesc())
			.append("Parentid",getParentid())
			.append("Roleseq",getRoleseq())
			.append("Rolelevel",getRolelevel())
			.toString();
	}
	
    public Boolean getAuthorized() {
        return authorized;
    }

    /** * @param authorized is authorized. */
    public void setAuthorized(Boolean authorized) {
        this.authorized = authorized;
    }

	
	public int hashCode() {
		return new HashCodeBuilder()
			.append(getRoleid())
			.append(getRolename())
			.append(getRoledesc())
			.append(getParentid())
			.append(getRoleseq())
			.append(getRolelevel())
			.toHashCode();
	}
	
	public boolean equals(Object obj) {
		if(obj instanceof SsRole == false) return false;
		if(this == obj) return true;
		SsRole other = (SsRole)obj;
		return new EqualsBuilder()
			.append(getRoleid(),other.getRoleid())
			.append(getRolename(),other.getRolename())
			.append(getRoledesc(),other.getRoledesc())
			.append(getParentid(),other.getParentid())
			.append(getRoleseq(),other.getRoleseq())
			.append(getRolelevel(),other.getRolelevel())
			.isEquals();
	}

	public Set<SsUser> getUsers() {
		return users;
	}

	public void setUsers(Set<SsUser> users) {
		this.users = users;
	}

	public Set<SsAuthority> getRescs() {
		return rescs;
	}

	public void setRescs(Set<SsAuthority> rescs) {
		this.rescs = rescs;
	}

	public Set<SsMenu> getMenus() {
		return menus;
	}

	public void setMenus(Set<SsMenu> menus) {
		this.menus = menus;
	}

	public java.lang.String getRoleseq() {
		return roleseq;
	}

	public void setRoleseq(java.lang.String roleseq) {
		this.roleseq = roleseq;
	}

	public Long getParentid() {
		return parentid;
	}

	public void setParentid(Long parentid) {
		this.parentid = parentid;
	}

	public Long getRolelevel() {
		return rolelevel;
	}

	public void setRolelevel(Long rolelevel) {
		this.rolelevel = rolelevel;
	}

	public java.lang.String getBusinesscode() {
		return businesscode;
	}

	public void setBusinesscode(java.lang.String businesscode) {
		this.businesscode = businesscode;
	}

	public java.lang.String getStrRoleid() {
		return strRoleid;
	}

	public void setStrRoleid(java.lang.String strRoleid) {
		this.strRoleid = strRoleid;
	}
}

