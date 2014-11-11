<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="authz" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix='c' uri='http://java.sun.com/jstl/core_rt' %>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=GBK">
<title>达因治安综合管理信息系统</title> 
</head>
<frameset rows="78,36,*,29" frameborder="NO" border="0" framespacing="0" id="top_frame">
  <frame src="./top_head.jsp" name="top_head" scrolling="NO" noresize/>
  <frame src="${ctx}/pages/outlookmenu/topMenu.do" name="topFrame" scrolling="NO" noresize/>
  <frame src="${ctx}/pages/zazh/SsDatasource/loginfo.do" name="bodyFrame">
  <frame src="${ctx}/pages/outlookRight/topRight.do" name="right" scrolling="no" noresize/>
</frameset>

</html>