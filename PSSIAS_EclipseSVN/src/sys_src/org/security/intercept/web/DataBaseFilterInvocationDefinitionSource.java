///**
// *
// */
//package org.security.intercept.web;
//
//
//
//import java.util.Collection;
//import java.util.Collections;
//import java.util.List;
//
//import javax.servlet.ServletContext;
//
//import org.apache.oro.text.regex.MalformedPatternException;
//import org.apache.oro.text.regex.Pattern;
//import org.apache.oro.text.regex.PatternMatcher;
//import org.apache.oro.text.regex.Perl5Compiler;
//import org.apache.oro.text.regex.Perl5Matcher;
//import org.security.resourcedetails.ResourcDetail;
//import org.security.resourcedetails.ResourceManagerImpl;
//import org.springframework.beans.factory.InitializingBean;
//import org.springframework.security.ConfigAttributeDefinition;
//import org.springframework.security.ConfigAttributeEditor;
//import org.springframework.security.GrantedAuthority;
//import org.springframework.security.intercept.web.FilterInvocation;
//import org.springframework.util.AntPathMatcher;
//import org.springframework.util.Assert;
//import org.springframework.util.PathMatcher;
//
///**
//* @author Administrator
//*
//*/
//public class DataBaseFilterInvocationDefinitionSource extends 
//		AbstractFilterInvocationDefinitionSource implements InitializingBean {
//	    
//	private boolean convertUrlToLowercaseBeforeComprison = false;
//	private boolean useAntPath = false;
//	private PathMatcher pathMatcher = new AntPathMatcher();
//	private PatternMatcher matcher = new Perl5Matcher();
//
//	
//
//	/* (non-Javadoc)
//	 * @see org.springframework.beans.factory.InitializingBean#afterPropertiesSet()
//	 */
//	public void afterPropertiesSet() throws Exception {
//		// TODO Auto-generated method stub
//		
//	}
//	
//	
//
//	/* (non-Javadoc)
//	 * @see org.security.intercept.web.AbstractFilterInvocationDefinitionSource#lookupAttributes(java.lang.String)
//	 */
//	@Override
//	public ConfigAttributeDefinition lookupAttributes(String url,List<String> urlAuthorities) {
//		// TODO Auto-generated method stub
//	
//	
//		if (isUseAntPath()) {
//			int firstQuestionMarkIndex = url.lastIndexOf("?");
//			if (firstQuestionMarkIndex != -1) {
//				url = url.substring(0, firstQuestionMarkIndex);
//			}
//		}
//		//将URL在比较前都转换为小写
//		if (isConvertUrlToLowercaseBeforeComprison()) {
//			url = url.toLowerCase();
//		}
//		//获取所有的URL
//		
//
//		//倒叙排序--如果不进行排序，如果用户使用浏览器的导航工具访问页面可能出现问题
//		//例如：访问被拒绝后用户刷新页面
//		Collections.sort(urlAuthorities);
//		Collections.reverse(urlAuthorities);
//
//		GrantedAuthority[] authorities = new GrantedAuthority[0];
//		//将请求的URL与配置的URL资源进行匹配，并将正确匹配的URL资源对应的权限
//		//取出
//		//System.out.println("将请求的URL与配置的URL资源进行匹配，并将正确匹配的URL资源对应的权限");
//		for (String resourceName_url : urlAuthorities) {
//			boolean matched = false;
//			//使用ant匹配URL
//			if (isUseAntPath()) {
//				//System.out.println("使用ant匹配URL resourceName_url ="+resourceName_url);
//				//System.out.println("使用ant匹配URL url ="+url);
//				matched = pathMatcher.match(resourceName_url, url);
//				//System.out.println("使用ant匹配URL matched ="+matched);
//				
//			} else {//perl5编译URL
//				//System.out.println("perl5编译URL");
//				//System.out.println("perl5编译URL resourceName_url ="+resourceName_url);
//				//System.out.println("perl5编译URL url ="+url);
//				Pattern compliedPattern = null;
//				Perl5Compiler compiler = new Perl5Compiler();
//				try {
//					compliedPattern = compiler.compile(resourceName_url, Perl5Compiler.READ_ONLY_MASK);
//				} catch (MalformedPatternException e) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//				}
//				matched = matcher.matches(url, compliedPattern);
//				//System.out.println("perl5编译URL matched ="+matched);
//			}
//			//匹配正确,获取响应权限
//			if (matched) {
//				//获取正确匹配URL资源对应的权限
//				//System.out.println("获取正确匹配URL资源对应的权限 resourceName_url ="+resourceName_url);
//				ResourcDetail detail =   ResourceManagerImpl.getResourcDetail(resourceName_url);       
//				// cacheManager.getResourcDetailFromCache(resourceName_url);
//				authorities = detail.getAuthorities();
//				break;
//			}
//		}
//		//将权限封装成ConfigAttributeDefinition对象返回（使用ConfigAttributeEditor）
//		if (authorities.length > 0) {
//			//System.out.println("权限封装成ConfigAttributeDefinition对象返回 ");
//			String authTemp = "";
//			for (GrantedAuthority grantedAuthority : authorities) {
//				authTemp += grantedAuthority.getAuthority() + ",";
//			}
//			String authority = authTemp.substring(0, (authTemp.length() - 1));
//			System.out.println("权限  URL  <<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<"+authority);
//			
//			ConfigAttributeEditor attributeEditor = new ConfigAttributeEditor();
//			attributeEditor.setAsText(authority.trim());
//			return (ConfigAttributeDefinition)attributeEditor.getValue();
//		}
//		return null;
//	}
//
//	/* (non-Javadoc)
//	 * @see org.security.intercept.web.AbstractFilterInvocationDefinitionSource#getConfigAttributeDefinitions()
//	 */
//	@SuppressWarnings("unchecked")
//	@Override
//	public Collection getConfigAttributeDefinitions() {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	/**
//	 * @return the convertUrlToLowercaseBeforeComprison
//	 */
//	public boolean isConvertUrlToLowercaseBeforeComprison() {
//		return convertUrlToLowercaseBeforeComprison;
//	}
//
//	/**
//	 * @param convertUrlToLowercaseBeforeComprison the convertUrlToLowercaseBeforeComprison to set
//	 */
//	public void setConvertUrlToLowercaseBeforeComprison(
//			boolean convertUrlToLowercaseBeforeComprison) {
//		this.convertUrlToLowercaseBeforeComprison = convertUrlToLowercaseBeforeComprison;
//	}
//
//	/**
//	 * @return the useAntPath
//	 */
//	public boolean isUseAntPath() {
//		return useAntPath;
//	}
//
//	/**
//	 * @param useAntPath the useAntPath to set
//	 */
//	public void setUseAntPath(boolean useAntPath) {
//		this.useAntPath = useAntPath;
//	}
//
//	/**
//	 * @return the pathMatcher
//	 */
//	public PathMatcher getPathMatcher() {
//		return pathMatcher;
//	}
//
//	/**
//	 * @param pathMatcher the pathMatcher to set
//	 */
//	public void setPathMatcher(PathMatcher pathMatcher) {
//		this.pathMatcher = pathMatcher;
//	}
//
//	/**
//	 * @return the matcher
//	 */
//	public PatternMatcher getMatcher() {
//		return matcher;
//	}
//
//	/**
//	 * @param matcher the matcher to set
//	 */
//	public void setMatcher(PatternMatcher matcher) {
//		this.matcher = matcher;
//	}
//
//
//
//}
