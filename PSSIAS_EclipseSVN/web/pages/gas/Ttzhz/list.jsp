<%@page import="com.dyneinfo.gas.model.*" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/commons/taglibs.jsp" %>
<%
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+request.getContextPath()+"/";
%>
<html>

<head>
	<%@ include file="/commons/meta.jsp" %>
	<base href="<%=basePath%>">
	<link href="${ctx}/widgets/extremecomponents/extremecomponents.css" type="text/css" rel=stylesheet>
	<title><%=Ttzhz.TABLE_ALIAS%>信息查看</title>
</head>

<body onload="quickSelectInit()" >
<%@ include file="/commons/messages.jsp" %>

<ec:table items='page.result' var="item" method="get"
	retrieveRowsCallback="limit" sortRowsCallback="limit" filterRowsCallback="limit"
	action="${ctx}/pages/gas/Ttzhz/list.do" autoIncludeParameters="true">
	<ec:row>
               <ec:column property="cpname"  title="<%=Ttzhz.ALIAS_CPCODE%>"/>
               <ec:column property="hzsj"  parse="yyyyMMddHHmm" format="yyyy-MM-dd HH:mm"  cell="date"  title="<%=Ttzhz.ALIAS_HZSJ%>"/>
	</ec:row>
</ec:table>

</body>

</html>

