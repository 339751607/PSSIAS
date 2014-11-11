<%@page import="com.dyneinfo.fjy.model.*" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/commons/taglibs.jsp" %>
<%
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+request.getContextPath()+"/";
%>
<html>

<head>
	<%@ include file="/commons/meta.jsp" %>
	<script src="<c:url value="/scripts/checkBox.js"/>" type="text/javascript"></script>
	<base target="_self"/>
	<link href="${ctx}/widgets/extremecomponents/extremecomponents.css" type="text/css" rel=stylesheet>
	<title>企业信息变更记录</title>
</head>

<body onload="quickSelectInit()" >
<%@ include file="/commons/messages.jsp" %>

<ec:table items='page.result' var="item" method="get"
	retrieveRowsCallback="limit" sortRowsCallback="limit" filterRowsCallback="limit"
	action="${ctx}/pages/fjy/TcpinfoLog/list.do" autoIncludeParameters="true">
	<ec:row>
		                    <ec:column property="cpcode"  title="<%=TcpinfoLog.ALIAS_CPCODE%>"/>
		                   <ec:column property="type"  title="<%=TcpinfoLog.ALIAS_TYPE%>">
				           	 <c:if test="${item.type == '1'}">
				           	 	创建
				           	 </c:if>
				           	 <c:if test="${item.type == '2'}">
				           	 	修改
				           	 </c:if>
				           	 </ec:column>
		                    <ec:column property="deptname"  title="<%=TcpinfoLog.ALIAS_DEPTNAME%>"/>
		                    <ec:column property="username"  title="<%=TcpinfoLog.ALIAS_USERNAME%>"/>
		                    <ec:column property="updatedate"  format="yyyy-MM-dd hh:mm:ss" cell ="date" title="<%=TcpinfoLog.ALIAS_UPDATEDATE%>"/>

	</ec:row>
</ec:table>
</body>

</html>


