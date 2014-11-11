<%@page import="com.dyneinfo.fjy.model.*" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/commons/taglibs.jsp" %>
<%
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+request.getContextPath()+"/";
%>
<html>

<head>
	<%@ include file="/commons/meta.jsp" %>
	<base target="_self"/> 
	<link href="${ctx}/widgets/extremecomponents/extremecomponents.css" type="text/css" rel=stylesheet>
	<title><%=SsNotice.TABLE_ALIAS%></title>
</head>

<body  >
<%@ include file="/commons/messages.jsp" %>
<ec:table items='page.result' var="item" method="get"
	retrieveRowsCallback="limit" sortRowsCallback="limit" filterRowsCallback="limit"
	action="${ctx}/pages/fjy/SsNotice/listPop.do" autoIncludeParameters="true">
	<ec:row>
		                    <ec:column property="noticetitle"  title="<%=SsNotice.ALIAS_NOTICETITLE%>"/>
		                    <ec:column property="authorname"  title="<%=SsNotice.ALIAS_AUTHORID%>"/>
		                    <ec:column property="sendunitname"  title="<%=SsNotice.ALIAS_SENDUNITID%>"/>
		                   
		<ec:column property="操作" title="操作" sortable="false" viewsAllowed="html">
			<a href="${ctx}/pages/fjy/SsNotice/showPop.do?noticeid=${item.noticeid}&<mytag:params includes="ec*,s*" type="queryStringUtf"/>">查看</a>&nbsp;&nbsp;&nbsp;		
		</ec:column>
	</ec:row>
</ec:table>

</body>

</html>


