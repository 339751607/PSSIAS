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


public class SsAuthority extends BaseEntity {
	
	//alias
	public static final String TABLE_ALIAS = "SsAuthority";
	public static final String ALIAS_AUTHORITYID = "权限ID";
	public static final String ALIAS_AUTHORITYNAME = "权限名称";
	public static final String ALIAS_AUTHORITYDESC = "权限描述";
	public static final String ALIAS_AUTHORITYTYPE = "权限类型";
	public static final String ALIAS_AUTHORITYVALUE = "权限值";
	
	//date formats
	
	//columns START
	private java.lang.Long authorityid;
	private java.lang.String authorityname;
	private java.lang.String authoritydesc;
	private java.lang.String authoritytype;
	private java.lang.String authorityvalue;
	//columns END
	
	 /** * 是否授权. */
    private Boolean authorized;

	public SsAuthority(){
	}

	public SsAuthority(
		java.lang.Long authorityid
	){
		this.authorityid = authorityid;
	}

	public void setAuthorityid(java.lang.Long value) {
		this.authorityid = value;
	}
	
	public java.lang.Long getAuthorityid() {
		return this.authorityid;
	}
	public void setAuthorityname(java.lang.String value) {
		this.authorityname = value;
	}
	
	public java.lang.String getAuthorityname() {
		return this.authorityname;
	}
	public void setAuthoritydesc(java.lang.String value) {
		this.authoritydesc = value;
	}
	
	public java.lang.String getAuthoritydesc() {
		return this.authoritydesc;
	}
	public void setAuthoritytype(java.lang.String value) {
		this.authoritytype = value;
	}
	
	public java.lang.String getAuthoritytype() {
		return this.authoritytype;
	}
	public void setAuthorityvalue(java.lang.String value) {
		this.authorityvalue = value;
	}
	
	public java.lang.String getAuthorityvalue() {
		return this.authorityvalue;
	}
	
	public Boolean getAuthorized() {
        return authorized;
    }

   
    public void setAuthorized(Boolean authorized) {
        this.authorized = authorized;
    }

	public String toString() {
		return new ToStringBuilder(this)
			.append("Authorityid",getAuthorityid())
			.append("Authorityname",getAuthorityname())
			.append("Authoritydesc",getAuthoritydesc())
			.append("Authoritytype",getAuthoritytype())
			.append("Authorityvalue",getAuthorityvalue())
			.toString();
	}
	
	public int hashCode() {
		return new HashCodeBuilder()
			.append(getAuthorityid())
			.append(getAuthorityname())
			.append(getAuthoritydesc())
			.append(getAuthoritytype())
			.append(getAuthorityvalue())
			.toHashCode();
	}
	
	public boolean equals(Object obj) {
		if(obj instanceof SsAuthority == false) return false;
		if(this == obj) return true;
		SsAuthority other = (SsAuthority)obj;
		return new EqualsBuilder()
			.append(getAuthorityid(),other.getAuthorityid())
			.append(getAuthorityname(),other.getAuthorityname())
			.append(getAuthoritydesc(),other.getAuthoritydesc())
			.append(getAuthoritytype(),other.getAuthoritytype())
			.append(getAuthorityvalue(),other.getAuthorityvalue())
			.isEquals();
	}
}

