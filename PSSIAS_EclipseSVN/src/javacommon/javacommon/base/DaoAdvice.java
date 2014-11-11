package javacommon.base;

import org.springframework.aop.MethodBeforeAdvice;
import org.springframework.asm.commons.Method;

public class DaoAdvice implements MethodBeforeAdvice {
	
	public void before(java.lang.reflect.Method method, Object[] args, Object obj)  throws Throwable {  
		String classSimpleName = obj.getClass().getSimpleName();  
		String className = classSimpleName.substring(0, classSimpleName.length()-3);  
		if(className.equals("ST_RSVRFCCH_BDao")){  
		    CustomerContextHolder.setCustomerType("query_su9921");  
		    System.out.println("------------ST_RSVRFCCH_BDao---------query_su9921- ----------------");  
		}else if(className.equals("DT_RGNCDDao")){  
		    System.out.println("------------DT_RGNCDDao---------query-------------  ----");  
		    CustomerContextHolder.setCustomerType("query");  
		}  
	 }

}
