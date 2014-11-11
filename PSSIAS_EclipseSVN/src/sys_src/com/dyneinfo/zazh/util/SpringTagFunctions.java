package com.dyneinfo.zazh.util;

import java.util.Collection; 

import org.springframework.security.GrantedAuthority;
public class SpringTagFunctions { 


    /** 
     * 检查当前用户是否不包含权限 
     *  
     * {@link SpringSecurityAuthorizeUtils} 
     *  
     * @param ifNotGranted 
     *  
     * @return 是否不包含全部权限 
     */ 
    public static final boolean ifNotGranted(String ifNotGranted) { 
            final Collection<GrantedAuthority> granted = SpringSecurityAuthorizeUtils.getPrincipalAuthorities(); 
            return SpringSecurityAuthorizeUtils.ifNotGranted(granted, ifNotGranted); 
    } 

    /** 
     * 检查当前用户是否全部包含权限 
     *  
     * {@link SpringSecurityAuthorizeUtils} 
     *  
     * @param ifAllGranted 
     *  
     * @return 是否和参数中的所有权限匹配 
     */ 
    public static final boolean ifAllGranted(String ifAllGranted) { 
            final Collection<GrantedAuthority> granted = SpringSecurityAuthorizeUtils.getPrincipalAuthorities(); 
            return SpringSecurityAuthorizeUtils.ifAllGranted(granted, ifAllGranted); 
    } 

    /** 
     * 检查当前用户是否包含其中任意一个权限 
     *  
     * {@link SpringSecurityAuthorizeUtils} 
     *  
     * @param ifAnyGranted 
     *  
     * @return 是否和权限中的权限匹配 
     */ 
    public static final boolean ifAnyGranted(String ifAnyGranted) { 
            final Collection<GrantedAuthority> granted = SpringSecurityAuthorizeUtils.getPrincipalAuthorities(); 
            return SpringSecurityAuthorizeUtils.ifAnyGranted(granted, ifAnyGranted); 
    } 
} 
