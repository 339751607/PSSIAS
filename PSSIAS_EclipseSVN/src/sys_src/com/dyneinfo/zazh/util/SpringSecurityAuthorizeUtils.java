package com.dyneinfo.zazh.util;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.security.Authentication;
import org.springframework.security.GrantedAuthority;
import org.springframework.security.GrantedAuthorityImpl;
import org.springframework.security.context.SecurityContextHolder;
import org.springframework.util.StringUtils;

public final class SpringSecurityAuthorizeUtils {
	public static final Log log = LogFactory.getLog(SpringSecurityAuthorizeUtils.class);

	public static final Set<GrantedAuthority> parseAuthoritiesString(String authorizationsString) {
		final Set<GrantedAuthority> requiredAuthorities = new HashSet<GrantedAuthority>();
		final String[] authorities = StringUtils.commaDelimitedListToStringArray(authorizationsString);

		for (int i = 0; i < authorities.length; i++) {
			String authority = authorities[i];

			// Remove the role's whitespace characters without depending on JDK
			// 1.4+
			// Includes space, tab, new line, carriage return and form feed.
			String role = authority.trim(); // trim, don't use spaces, as per
			// SEC-378
			role = StringUtils.deleteAny(role, "\t\n\r\f");
			requiredAuthorities.add(new GrantedAuthorityImpl(role));
		}

		return requiredAuthorities;
	}

	public static final Set<String> authoritiesToRoles(Collection<GrantedAuthority> c) {
		Set<String> target = new HashSet<String>();

		for (GrantedAuthority authority : c) {
			if (null == authority.getAuthority()) {
				throw new IllegalArgumentException(
						"Cannot process GrantedAuthority objects which return null from getAuthority() - attempting to process "
								+ authority.toString());
			}
			target.add(authority.getAuthority());
		}
		return target;
	}

	public static final Set<GrantedAuthority> retainAll(final Collection<GrantedAuthority> granted,
			final Set<GrantedAuthority> required) {
		Set<String> grantedRoles = authoritiesToRoles(granted);
		Set<String> requiredRoles = authoritiesToRoles(required);
		grantedRoles.retainAll(requiredRoles);
		return rolesToAuthorities(grantedRoles, granted);
	}

	public static final Set<GrantedAuthority> removeAll(final Collection<GrantedAuthority> granted,
			final Set<GrantedAuthority> required) {
		Set<String> grantedRoles = authoritiesToRoles(granted);
		Set<String> requiredRoles = authoritiesToRoles(required);
		grantedRoles.removeAll(requiredRoles);
		return rolesToAuthorities(grantedRoles, granted);
	}

	public static final Set<GrantedAuthority> rolesToAuthorities(Set<String> grantedRoles,
			Collection<GrantedAuthority> granted) {
		Set<GrantedAuthority> target = new HashSet<GrantedAuthority>();
		for (String role : grantedRoles) {
			for (GrantedAuthority authority : granted) {
				if (authority.getAuthority().equals(role)) {
					target.add(authority);
					break;
				}
			}
		}

		return target;
	}

	@SuppressWarnings("unchecked")
	public static final Collection<GrantedAuthority> getPrincipalAuthorities() {
		Authentication currentUser = SecurityContextHolder.getContext().getAuthentication();

		if (null == currentUser) {
			return Collections.EMPTY_LIST;
		}
		if ((null == currentUser.getAuthorities()) || (currentUser.getAuthorities().length < 1)) {
			return Collections.EMPTY_LIST;
		}
		GrantedAuthority[] authorities = currentUser.getAuthorities();
		if (log.isDebugEnabled()) {
			log.debug("current user[" + currentUser.getName() + "] principal authorities:"
					+ Arrays.toString(authorities));
		}
		return Arrays.asList(authorities);
	}

	/**
	 * 是否不包含这些权限
	 * 
	 * @param granted
	 *            需要检查的权限
	 * @param ifAllGranted
	 *            对应的字符串,已逗号分隔,中间的\t\n\r\f等符号,将会被删除
	 * @return 如果需要检查的权限完全不出现在对应的字符串中,返回true,其他false
	 */
	public static final boolean ifNotGranted(Collection<GrantedAuthority> granted, String ifNotGranted) {
		if (StringUtils.hasText(ifNotGranted)) {
			Set<GrantedAuthority> grantedCopy = SpringSecurityAuthorizeUtils.removeAll(granted,
					SpringSecurityAuthorizeUtils.parseAuthoritiesString(ifNotGranted));
			if (!grantedCopy.isEmpty()
					&& !granted.containsAll(SpringSecurityAuthorizeUtils.parseAuthoritiesString(ifNotGranted))) {
				return true;
			}
		}
		return false;
	}

	/**
	 * 是否包含全部权限
	 * 
	 * @param granted
	 *            需要检查的权限
	 * @param ifAllGranted
	 *            对应的字符串,已逗号分隔,中间的\t\n\r\f等符号,将会被删除
	 * @return 如果需要检查的权限和对应的字符串中定义的权限完全相同,返回true,其他false
	 */
	public static final boolean ifAllGranted(Collection<GrantedAuthority> granted, String ifAllGranted) {
		if (StringUtils.hasText(ifAllGranted)) {
			if (granted.containsAll(SpringSecurityAuthorizeUtils.parseAuthoritiesString(ifAllGranted))) {
				return true;
			}
		}
		return false;
	}

	/**
	 * 是否包含其中任意的一个权限
	 * 
	 * @param granted
	 *            需要检查的权限
	 * @param ifAnyGranted
	 *            对应的字符串,已逗号分隔,中间的\t\n\r\f等符号,将会被删除
	 * @return 如果需要检查的权限在对应的字符串中出现,返回true,其他false
	 */
	public static final boolean ifAnyGranted(Collection<GrantedAuthority> granted, String ifAnyGranted) {
		if (StringUtils.hasText(ifAnyGranted)) {
			Set<GrantedAuthority> grantedCopy = SpringSecurityAuthorizeUtils.retainAll(granted,
					SpringSecurityAuthorizeUtils.parseAuthoritiesString(ifAnyGranted));
			if (!grantedCopy.isEmpty()) {
				return true;
			}
		}
		return false;
	}

}