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
	<title>人员信息日志</title>
</head>

<body onload="quickSelectInit()" >
<%@ include file="/commons/messages.jsp" %>

<ec:table items='page.result' var="item" method="get"
	retrieveRowsCallback="limit" sortRowsCallback="limit" filterRowsCallback="limit"
	action="${ctx}/pages/zazh/TpersonlogJn/itemlist.do" autoIncludeParameters="true">
	<ec:row>
	        <ec:column property="starttime"  parse="yyyyMMddhhmm" format="yyyy-MM-dd hh:mm" 
               cell="date" value="${item.starttime}" title="开始时间"/>
            <ec:column property="endtime"  parse="yyyyMMddhhmm" format="yyyy-MM-dd hh:mm" 
               cell="date" value="${item.endtime}" title="结束时间"/>
            <mytag:lookupcolumn property="persontype"  title="业务类型"	cell="net.java.dev.ec.table.view.LookUpCell" dictType="DIC_ITEM_BUSINESSTYPE" />	
            <mytag:lookupcolumn property="source"  title="行业"	cell="net.java.dev.ec.table.view.LookUpCell" dictType="T_ITEM_BUSSINESS" />		
            
	        <ec:column property="cpname"  title="<%=TpersonlogJw.ALIAS_CPNAME%>"/>
            <ec:column property="cpcode"  title="<%=TpersonlogJw.ALIAS_CPCODE%>"/>
			                
			<ec:column property="操作" title="操作" sortable="false" viewsAllowed="html">
				<a href="javascript:openDetail_JN('${ctx}','${item.sid}','${item.persontype}','${item.source}','${item.cpcode}','${item.cardname}','${item.cardno}');" />查看</a>
			</ec:column>
	</ec:row>
</ec:table>

</body>

</html>