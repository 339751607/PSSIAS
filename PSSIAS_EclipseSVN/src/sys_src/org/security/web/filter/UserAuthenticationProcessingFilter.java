package org.security.web.filter;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.security.Authentication;
import org.springframework.security.AuthenticationException;
import org.springframework.security.context.SecurityContextHolder;
import org.springframework.security.event.authentication.InteractiveAuthenticationSuccessEvent;
import org.springframework.security.ui.AbstractProcessingFilter;
import org.springframework.security.ui.webapp.AuthenticationProcessingFilter;

import com.dyneinfo.zazh.model.LoginHistory;
import com.dyneinfo.zazh.service.LoginHistoryManager;


/**
 * 把User变量放入http session中,key为Constants.USER_IN_SESSION.
 * 
 * @author cac
 * @author Lingo
 * @since 2007-03-25
 * @version 1.0
 */
public class UserAuthenticationProcessingFilter extends
		AuthenticationProcessingFilter {
	/**
	 * logger.
	 */
	private static Log logger = LogFactory
			.getLog(UserAuthenticationProcessingFilter.class);
	
	private LoginHistoryManager loginHistoryManager;
	
	public void setLoginHistoryManager(LoginHistoryManager manager) {
		this.loginHistoryManager = manager;
	}	



	// 在验证前，验证成功后，验证失败后，提供扩展的逻辑操作
	@Override
	protected void onPreAuthentication(HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		System.out.println("&&&&&&&&&&&&&&在验证前");
		System.out.println("j_username=" + request.getParameter("j_username"));
		System.out.println("j_password=" + request.getParameter("j_password"));

		loginLog(request, response, "登录验证前","1");
	}


	
	@Override
	protected void onSuccessfulAuthentication(HttpServletRequest request,
			HttpServletResponse response, Authentication authResult)
			throws IOException {
		super.onSuccessfulAuthentication(request, response, authResult);
		 //  System.out.println("&&&&&&&&&&&&&&验证成功后");
	}

	 @Override
	    protected void onUnsuccessfulAuthentication( HttpServletRequest request, HttpServletResponse response,
	            AuthenticationException failed ) throws IOException {
	     super.onUnsuccessfulAuthentication(request, response, failed);
		loginLog(request, response, "验证失败","0");
	}
	
	




	// 验证成功，返回json消息
	/**
	 * 覆盖超类的方法，在验证成功的时候返回json消息，而不是跳转.
	 * 
	 * @param request
	 *            请求
	 * @param response
	 *            响应
	 * @param authResult
	 *            验证结果
	 * @throws IOException
	 *             异常
	 */
	@Override
	protected void successfulAuthentication(HttpServletRequest request,
			HttpServletResponse response, Authentication authResult)
			throws IOException {

		
		//	System.out.println("验证成功，返回json消息 successfulAuthentication      successfulAuthentication Authentication success: ="+ authResult.toString());
		
		loginLog(request, response, "登录成功","1");

		SecurityContextHolder.getContext().setAuthentication(authResult);

		System.out.println("Updated SecurityContextHolder to contain the following Authentication: '"
						+ authResult + "'");

		String targetUrl = determineTargetUrl(request);

		System.out.println("Redirecting to target URL from HTTP Session (or default): "
						+ targetUrl);

		onSuccessfulAuthentication(request, response, authResult);
	

		//getRememberMeServices().loginSuccess(request, response, authResult);

		// Fire event
		if (this.eventPublisher != null) {
			eventPublisher
					.publishEvent(new InteractiveAuthenticationSuccessEvent(
							authResult, this.getClass()));
		}


		System.out.println("------------------------------" + targetUrl);
		sendRedirect(request, response,targetUrl);
	}

	public void loginLog(HttpServletRequest request,
			HttpServletResponse response, String Useroperation,String loginflag) {

		String browsertype = request.getHeader("user-agent");
		String ipaddress = request.getRemoteAddr();
		String hostname = request.getRemoteHost();
		
      HttpSession session =   request.getSession();
      String message = "";
      if (session.getAttribute(AbstractProcessingFilter.SPRING_SECURITY_LAST_EXCEPTION_KEY) != null) {
    	message =  ((AuthenticationException) session.getAttribute(AbstractProcessingFilter.SPRING_SECURITY_LAST_EXCEPTION_KEY)).getMessage(); 
      }
		
		String username = request.getParameter("j_username");
		String password = request.getParameter("j_password");
		if (username != null) {
				Date date = new Date();
				SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				String currDate = format.format(date);
				LoginHistory thotelBsLogs = new LoginHistory();
				thotelBsLogs.setLoginname(username);
				thotelBsLogs.setLogintimeString(currDate);
				thotelBsLogs.setBrowser(browsertype);
				thotelBsLogs.setHostname(hostname);
				thotelBsLogs.setIpaddress(ipaddress);
				if(loginflag != null && loginflag.equals("0")){
				thotelBsLogs.setInvalidpassword(password);
				
				thotelBsLogs.setIsvalid(Useroperation+message);
				}else {
					thotelBsLogs.setIsvalid(Useroperation);
				}
				loginHistoryManager.save(thotelBsLogs);
			}

	

	}

}
