package org.security.resourcedetails;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.InitializingBean;

import org.springframework.security.intercept.method.DelegatingMethodDefinitionSource;
import org.springframework.security.intercept.method.MethodDefinitionSource;
import org.springframework.security.intercept.method.aopalliance.MethodSecurityInterceptor;
import org.springframework.security.intercept.method.aspectj.AspectJSecurityInterceptor;
import org.springframework.security.intercept.web.FilterInvocationDefinitionSource;
import org.springframework.security.intercept.web.FilterSecurityInterceptor;
import org.springframework.security.util.AntUrlPathMatcher;
import org.springframework.security.util.UrlMatcher;


public class ResourceDetailsMonitor implements InitializingBean {
  
    
    private String queryUrl = "select au.authorityValue,r.ROLENAME " +
    		"from ss_role r, ss_role_authority ra, ss_authority au " +
    		"where au.authorityID=ra.authorityID  " +
    		"and r.roleid=ra.roleid  " +
    		"and au.authorityType='URL' " +
    		"order by au.authorityID";
    
   
    
    private String queryMethod="select au.authorityValue,r.rolename " +
    		"from ss_role r, ss_role_authority ra ,ss_authority au " +
    		"where au.authorityType='METHED' " +
    		"and r.roleid=ra.roleid " +
    		"and au.authorityID=ra.authorityID " +
    		"order by au.authorityValue";
    
    private DataSource dataSource;
    private FilterSecurityInterceptor filterSecurityInterceptor;
    private DelegatingMethodDefinitionSource delegatingMethodDefinitionSource;
    private ResourceDetailsBuilder resourceDetailsBuilder;

    public void setQueryUrl(String queryUrl) {
        this.queryUrl = queryUrl;
    }

    public void setQueryMethod(String queryMethod) {
        this.queryMethod = queryMethod;
    }

    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public void setFilterSecurityInterceptor(
        FilterSecurityInterceptor filterSecurityInterceptor) {
        this.filterSecurityInterceptor = filterSecurityInterceptor;
    }

    public void setDelegatingMethodDefinitionSource(
        DelegatingMethodDefinitionSource delegatingMethodDefinitionSource) {
        this.delegatingMethodDefinitionSource = delegatingMethodDefinitionSource;
    }

    protected UrlMatcher getUrlMatcher() {
        return new AntUrlPathMatcher();
    }

    public void afterPropertiesSet() {
        resourceDetailsBuilder = new ResourceDetailsBuilder(dataSource);
        refresh();
    }

    public void refresh() {
    	System.out.println("refresh start");
        if (filterSecurityInterceptor != null) {
            FilterInvocationDefinitionSource source = resourceDetailsBuilder
                .createUrlSource(queryUrl, getUrlMatcher());
        	System.out.println("refresh queryUrl="+queryUrl);
            filterSecurityInterceptor.setObjectDefinitionSource(source);
        }

        if (delegatingMethodDefinitionSource != null) {
            MethodDefinitionSource source = resourceDetailsBuilder
                .createMethodSource(queryMethod);
            System.out.println("refresh queryMethod="+queryMethod);
            List<MethodDefinitionSource> sources = new ArrayList<MethodDefinitionSource>();
            sources.add(source);
            delegatingMethodDefinitionSource.setMethodDefinitionSources(sources);
        }
    }
}
