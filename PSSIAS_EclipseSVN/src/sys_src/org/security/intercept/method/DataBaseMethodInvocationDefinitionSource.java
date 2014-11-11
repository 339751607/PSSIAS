//package org.security.intercept.method;
//
//import java.lang.reflect.Method;
//import java.util.Arrays;
//import java.util.Collection;
//import java.util.HashSet;
//import java.util.List;
//import java.util.Set;
//
//import org.security.resourcedetails.ResourcDetail;
//import org.security.resourcedetails.ResourceManagerImpl;
//import org.springframework.security.ConfigAttributeDefinition;
//import org.springframework.security.ConfigAttributeEditor;
//import org.springframework.security.GrantedAuthority;
//import org.security.intercept.method.AbstractMethodDefinitionSource;
//import com.spring.asecurity.domain.Resource;
//public class DataBaseMethodInvocationDefinitionSource extends
//		AbstractMethodDefinitionSource {
//
//	//private SecurityCacheManager securityCacheManager;
//
//	@SuppressWarnings("unchecked")
//	public ConfigAttributeDefinition lookupAttributes(Method method, Class targetClass) {
//		// TODO Auto-generated method stub
//		//初始化资源并缓存
//	//	securityCacheManager.initResourceInCache();
//
//		//获取所有方法资源
//		List<Resource> methodResourceList  = ResourceManagerImpl.getMethResourceList();
//		//List<String> methods  = securityCacheManager.getMethodResources();
//		
//		
//
//		//权限集合
//		Set<GrantedAuthority> authSet = new HashSet<GrantedAuthority>();
//
//		//遍历方法资源，并获取匹配的资源名称，然后从缓存中获取匹配正确
//		//的资源对应的权限（ResourcDetail对象的GrantedAuthority[]对象数据）
//		for (Resource resource_method : methodResourceList) {
//			System.out.println(">>>>>>>>>>>>>>>" + resource_method.getResString());
//			System.out.println("方法保护>>>>>>>>>>>>>>> MethodInvocation"+resource_method.getResString() );
//			if (isMatch(targetClass, method, resource_method.getResString())) {
//			//	ResourcDetail detail = securityCacheManager.getResourcDetailFromCache(resourceName_method);
//				ResourcDetail detail =   ResourceManagerImpl.getResourcDetail(resource_method.getResString());       
//				if (detail == null) {
//					break;
//				}
//				GrantedAuthority[] authorities = detail.getAuthorities();
//				if (authorities == null || authorities.length == 0) {
//					break;
//				}
//				authSet.addAll(Arrays.asList(authorities));
//			}
//		}
//		if (authSet.size() > 0) {
//			String authString = "";
//			for (GrantedAuthority grantedAuthority : authSet) {
//				authString += grantedAuthority.getAuthority() + ",";
//				//System.out.println("authString = "+authString);
//			}
//			String authority = authString.substring(0, (authString.length() - 1));
//			System.out.println("权限  Method <<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<"+authority);
//			ConfigAttributeEditor attributeEditor = new ConfigAttributeEditor();
//			System.out.println("权限  Method <<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<11111111111111111111111111111111"+authority);
//			attributeEditor.setAsText(authority);
//			System.out.println("权限  Method <<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<2222222222222222222"+authority);
//			//这里出错，没有调试过
//			
//			
//			//return (ConfigAttributeDefinition)attributeEditor.getValue();
//			
//			
//		}
//		System.out.println("权限  Method <<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<33333333333333<");
//		return null;
//		
//	}
//
//	@SuppressWarnings("unchecked")
//	public static boolean isMatch(Class clszz, Method method, String resourceMethod) {
//		boolean isMatch = true;
//		try {
//			int lastDotIndex = resourceMethod.lastIndexOf('.');
//			String className = resourceMethod.substring(0, lastDotIndex);
//			String methodName = resourceMethod.substring(lastDotIndex + 1);
//
//			// 判断类是否相等
//			if (!clszz.getName().equals(className))
//				isMatch = false;
//
//			// 判断接口是否相等
//			Class[] interfaces = clszz.getInterfaces();
//			for (int i = 0; i < interfaces.length; i++) {
//				Class inf = interfaces[i];
//				if (inf.getName().equals(className)) {
//					isMatch = true;
//				}
//			}
//
//			// 判断方法是否相等
//			if (isMatch
//					&& !(method.getName().equals(methodName)
//					|| (methodName.endsWith("*") && method.getName().startsWith(
//					methodName.substring(0, methodName.length() - 1))) || (methodName.startsWith("*") && method
//					.getName().endsWith(methodName.substring(1, methodName.length())))))
//				isMatch = false;
//
//		} catch (Exception e) {
//			isMatch = false;
//		}
//		return isMatch;
//	}
//
//	@SuppressWarnings("unchecked")
//	public Collection getConfigAttributeDefinitions() {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//
//
//}
//
