/**
 *
 */
package org.security.resourcedetails;

import java.io.Serializable;

import org.springframework.security.GrantedAuthority;

/**
 * @author Administrator
 *
 */
public interface ResourcDetail extends Serializable {

	String getResourceName();

	String getResourceType();

	GrantedAuthority[] getAuthorities();

}
