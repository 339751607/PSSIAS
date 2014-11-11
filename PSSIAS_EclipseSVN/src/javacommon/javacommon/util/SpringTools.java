package javacommon.util;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

public class SpringTools {
	public static Object getBean(String bean) {
		ApplicationContext context = new FileSystemXmlApplicationContext(
				"WebContent/WEB-INF/spring/applicationContext.xml");
		return context.getBean(bean);
	}

	public static ApplicationContext getContext() {
		return new FileSystemXmlApplicationContext("WebContent/WEB-INF/spring/applicationContext.xml");
	}
}
