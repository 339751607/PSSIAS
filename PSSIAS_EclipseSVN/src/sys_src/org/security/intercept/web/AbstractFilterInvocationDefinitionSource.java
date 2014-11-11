/**
 *
 */
package org.security.intercept.web;

import java.util.Collection;
import java.util.List;

import javax.servlet.ServletContext;

import org.springframework.security.ConfigAttributeDefinition;
import org.springframework.security.intercept.web.FilterInvocation;
import org.springframework.security.intercept.web.FilterInvocationDefinitionSource;

/**
 * @author Administrator
 * 
 */
public abstract class AbstractFilterInvocationDefinitionSource implements
		FilterInvocationDefinitionSource {

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.springframework.security.intercept.ObjectDefinitionSource#getAttributes
	 * (java.lang.Object)
	 */
	public ConfigAttributeDefinition getAttributes(Object object)
			throws IllegalArgumentException {
		// TODO Auto-generated method stub
		if (object == null || !(this.supports(object.getClass()))) {
			throw new IllegalArgumentException(
					"Object must be a FilterInvocation");
		}
		String url = ((FilterInvocation) object).getRequestUrl();
		//System.out.println("访问的url" + url + ">");
		FilterInvocation filterInvocation = (FilterInvocation) object;
		List<String> urlAuthorities = this.getUrlAuthorities(filterInvocation);

		return this.lookupAttributes(url, urlAuthorities);
	}

	public abstract ConfigAttributeDefinition lookupAttributes(String url,
			List<String> urlAuthorities);

	/*
	 * (non-Javadoc)
	 * 
	 * @seeorg.springframework.security.intercept.ObjectDefinitionSource#
	 * getConfigAttributeDefinitions()
	 */
	@SuppressWarnings("unchecked")
	public abstract Collection getConfigAttributeDefinitions();

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.springframework.security.intercept.ObjectDefinitionSource#supports
	 * (java.lang.Class)
	 */
	@SuppressWarnings("unchecked")
	public boolean supports(Class clazz) {
		// TODO Auto-generated method stub
		return FilterInvocation.class.isAssignableFrom(clazz);
	}

	/**
	 * 
	 * @param filterInvocation
	 * @return
	 */
	@SuppressWarnings("unchecked")
	private List<String> getUrlAuthorities(FilterInvocation filterInvocation) {
		ServletContext servletContext = filterInvocation.getHttpRequest()
				.getSession().getServletContext();
		return (List<String>) servletContext.getAttribute("urlAuthorities");
	}

}
