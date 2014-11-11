<%@page import="com.dyneinfo.zazh.model.*" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/commons/taglibs.jsp" %>
<%
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+request.getContextPath()+"/";
%>
<html>

<head>
	<%@ include file="/commons/meta.jsp" %>
	<script src="<c:url value="/scripts/checkDetail.js"/>" type="text/javascript"></script>
	<base href="<%=basePath%>">
	<base target="_self"/> 
	<link href="${ctx}/widgets/extremecomponents/extremecomponents.css" type="text/css" rel=stylesheet>
	<title>车辆信息日志</title>
</head>

<body onload="quickSelectInit()" >
<%@ include file="/commons/messages.jsp" %>

<ec:table items='page.result' var="item" method="get"
	retrieveRowsCallback="limit" sortRowsCallback="limit" filterRowsCallback="limit"
	action="${ctx}/pages/zazh/Tcarlog/itemlist.do" autoIncludeParameters="true">

	<ec:row>
	          <ec:column property="starttime"  parse="yyyyMMddHHmm" format="yyyy-MM-dd HH:mm" cell="date" value="${item.starttime}" title="<%=Tcarlog.ALIAS_STARTTIME%>"/>
	          <ec:column property="endtime"  parse="yyyyMMddHHmm" format="yyyy-MM-dd HH:mm" cell="date" value="${item.endtime}" title="<%=Tcarlog.ALIAS_ENDTIME%>"/>
	          <mytag:lookupcolumn property="cartype"  title="<%=Tcarlog.ALIAS_CARTYPE%>"	cell="net.java.dev.ec.table.view.LookUpCell" dictType="DIC_ITEM_BUSINESSTYPE" />
	          <mytag:lookupcolumn property="source"  title="<%=Tcarlog.ALIAS_SOURCE%>"	cell="net.java.dev.ec.table.view.LookUpCell" dictType="T_ITEM_BUSSINESS" />
	          <ec:column property="cpname"  title="<%=Tcarlog.ALIAS_CPNAME%>"/>
	          <ec:column property="cpcode"  title="<%=Tcarlog.ALIAS_CPCODE%>"/>

	         <ec:column property="操作" title="操作" sortable="false" viewsAllowed="html">
				<a href="javascript:openDetail_Car('${ctx}','${item.sid}','${item.cartype}','${item.source}');" />查看</a>
		     </ec:column>  
	</ec:row>
</ec:table>

</body>

</html>
<script>

</script>