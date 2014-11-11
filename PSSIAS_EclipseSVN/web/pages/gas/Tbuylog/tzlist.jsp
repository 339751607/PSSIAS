<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix='c' uri='http://java.sun.com/jstl/core_rt'%>
<%@ taglib prefix="authz" uri="http://www.springframework.org/security/tags"%>
<c:set var="ctx" value="${pageContext.request.contextPath}" />
<%
	String webContext = request.getContextPath();

	String pc = "0"; 
	String zl= "0"; 
	String gycs = "0";
	String gwxzqh = "0";
	String zlinit= "0"; 
	String gycsinit = "0";

	if ( request.getAttribute("sjcsinit") != null)
		gycsinit = (String)request.getAttribute("sjcsinit"); 
	if ( request.getAttribute("gyslinit") != null)
	      zlinit = (String)request.getAttribute("gyslinit"); 
	if ( request.getAttribute("gycs") != null)
		gycs = (String)request.getAttribute("gycs"); 
	if ( request.getAttribute("gysl") != null)
	      zl = (String)request.getAttribute("gysl"); 
	if ( request.getAttribute("sjpc") != null)
	      pc = (String)request.getAttribute("sjpc"); 
	if ( request.getAttribute("gwxzqh") != null)
		 gwxzqh = (String)request.getAttribute("gwxzqh"); 
	String telInfo = ""; 
	String style="style=\"PADDING-LEFT: 8px; FONT-SIZE: 18px; COLOR: #1f336b; PADDING-TOP: 6px; \" ";

	telInfo = telInfo + "<table width=100% align=\"center\"  >";
	 if("1".equals(gycs)){
		    telInfo = telInfo + "<tr  >";
			telInfo  = telInfo + "<td height =\"30px\" align=\"center\"" + style + " >近"+pc+"天购油次数超过<a href=\"#\" onclick=\"alert();\">"+gycsinit+"</a>次</td>";
			telInfo = telInfo + "</tr>";
	 }
	 if("1".equals(zl)){
		 
		    telInfo = telInfo + "<tr  >";
			telInfo  = telInfo + "<td height =\"30px\" align=\"center\"" + style + " >近"+pc+"天购油总升数超过<a href=\"#\">"+zlinit+"</a>升</td>";
			telInfo = telInfo + "</tr>";
	 }
	 if(!"0".equals(gwxzqh)){
		    telInfo = telInfo + "<tr  >";
			telInfo  = telInfo + "<td height =\"30px\" align=\"center\"" + style + " >近"+pc+"天有<a href=\"#\">"+gwxzqh+"人/次</a>重点户籍地人员购油</td>";
			telInfo = telInfo + "</tr>";
	 }

			telInfo = telInfo + "</table>";
%>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
	<title>预警信息</title>
	
</head>
<body >
<div><%= telInfo%></div>
</body>
</html>



