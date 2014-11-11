/**
 *
 */
package org.security.resourcedetails;

import org.springframework.security.GrantedAuthority;
import org.springframework.util.Assert;

/**
 * @author Administrator
 *
 */
public class Resourc implements ResourcDetail {

	/**
	 *
	 */
	private static final long serialVersionUID = 8334097189812396236L;
	private String resourceName;
	private String resourceType;
	private GrantedAuthority[] authorities;

	/**
	 * @param resourceName
	 * @param resourceType
	 * @param authorities
	 */
	public Resourc(String resourceName, String resourceType,
			GrantedAuthority[] authorities) {
		if (resourceName == null || "".equals(resourceName)) {
			throw new IllegalArgumentException("Cannot pass null or empty values to resource name");
		}
		if (resourceType == null || "".equals(resourceType)) {
			throw new IllegalArgumentException("Cannot pass null or empty values to resource type");
		}
		this.resourceName = resourceName;
		this.resourceType = resourceType;
		setAuthorities(authorities);
	}

	/* (non-Javadoc)
	 * @see org.security.resourcedetails.ResourcDetail#getAuthorities()
	 */
	public GrantedAuthority[] getAuthorities() {
		// TODO Auto-generated method stub
		return this.authorities;
	}

	/* (non-Javadoc)
	 * @see org.security.resourcedetails.ResourcDetail#getResourceName()
	 */
	public String getResourceName() {
		// TODO Auto-generated method stub
		return this.resourceName;
	}

	/* (non-Javadoc)
	 * @see org.security.resourcedetails.ResourcDetail#getResourceType()
	 */
	public String getResourceType() {
		// TODO Auto-generated method stub
		return this.resourceType;
	}

	/**
	 * @param resourceName the resourceName to set
	 */
	public void setResourceName(String resourceName) {
		this.resourceName = resourceName;
	}

	/**
	 * @param resourceType the resourceType to set
	 */
	public void setResourceType(String resourceType) {
		this.resourceType = resourceType;
	}

	/**
	 * @param authorities the authorities to set
	 */
	public void setAuthorities(GrantedAuthority[] authorities) {
		Assert.notNull(authorities, "Cannot pass a null GrantedAuthority array");
		for (int i = 0; i < authorities.length; i++) {
			Assert.notNull(authorities[i],
					"Granted authority element " + i + " is null - GrantedAuthority[] cannot contain any null elements");
		}
		this.authorities = authorities;
	}

}
