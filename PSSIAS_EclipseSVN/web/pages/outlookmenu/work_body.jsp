<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312">
		<meta http-equiv="Cache-Control" content="no-store"/>
        <meta http-equiv="Pragma" content="no-cache"/>
        <meta http-equiv="Expires" content="0"/>
<title>CMIS</title>
</head>

<frameset rows="*" cols="180,10,*" framespacing="0" frameborder="no" border="0" id="oa_frame">
	<frame src="${ctx}/pages/outlookmenu/leftTree.do" name="leftFrame " noresize>
	<frame src="./tool_mid.html" scrolling="no" name="middleqwe" noresize>
	<frame src="" name="rightWorkSpace" scrolling="auto">
</frameset>
</html>