package net.java.dev.common.startup;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import net.java.dev.common.dict.taglib.DictHelpImpl;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

/**
 * web项目系统启动时会执行一些初始化操作,该类已经在web.xml中注册
 * 
 * <br />
 * 	<listener>
 *		<listener-class>net.java.dev.common.startup.CustomLoaderListenerImpl</listener-class>
 *	</listener>
 * @author lishicheng
 */

public class CustomLoaderListenerImpl implements ServletContextListener{

	public void contextInitialized(ServletContextEvent event) {
		ServletContext context = event.getServletContext();
		System.out.println("[javacommon.startup.WebProjectStartup] 系统正在启动.... 在这里可以执行相关初始化操作");
		try {

			ServletContext ctx = event.getServletContext();
			WebApplicationContext springContext = WebApplicationContextUtils.getWebApplicationContext(ctx);

			System.out.println("加载业务字典");
			DictHelpImpl beanRep = (DictHelpImpl) springContext.getBean("DictHelpImpl");
			beanRep.initLoad();

		} catch (Exception e) {
			System.out.println("加载业务字典失败！");
			e.printStackTrace();
		}
	}
	
	public void contextDestroyed(ServletContextEvent event) {
		ServletContext context = event.getServletContext();
	}
	

}

