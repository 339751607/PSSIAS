<%@ page import="javax.servlet.http.Cookie" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ include file="/commons/taglibs.jsp" %>
<%@ page import="org.springframework.security.ui.rememberme.TokenBasedRememberMeServices" %>

<%
if (request.getSession(false) != null) {
    session.invalidate();
}
Cookie terminate = new Cookie(TokenBasedRememberMeServices.SPRING_SECURITY_REMEMBER_ME_COOKIE_KEY, null);
String contextPath = request.getContextPath();
terminate.setPath(contextPath != null && contextPath.length() > 0 ? contextPath : "/");
terminate.setMaxAge(0);
response.addCookie(terminate);
%>
<html>
<body>
<form name="frm" action="${ctx}/login.jsp" method="post" target="_top"></form>
</body>
</html>
<script language="JavaScript">
	document.frm.submit();
</script>