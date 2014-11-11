<%@page import="com.dyneinfo.hotel.model.*" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/commons/taglibs.jsp" %>
<%@ include file="/pages/hotel/commons/getHotelName.jsp" %>
<%
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+request.getContextPath()+"/";
%>
<html>

<head>
	<%@ include file="/commons/meta.jsp" %>
	<base href="<%=basePath%>">
	<link href="${ctx}/widgets/extremecomponents/extremecomponents.css" type="text/css" rel=stylesheet>
	<title><%=TchPre.TABLE_ALIAS%> 维护</title>
</head>

<body>
<%@ include file="/commons/messages.jsp" %>

<ec:table items='page.result' var="item" method="get"
	retrieveRowsCallback="limit" sortRowsCallback="limit" filterRowsCallback="limit"
	action="${ctx}/pages/hotel/TchPre/list.do" autoIncludeParameters="true">
	<ec:exportXls fileName="chpre.xls" tooltip="输出Excel文件"/>
	<ec:row>
		                    <ec:column property="name"  title="<%=TchPre.ALIAS_NAME%>"/>
		                    <ec:column property="bdate"  title="<%=TchPre.ALIAS_BDATE%>" parse="yyyyMMdd" format="yyyy-MM-dd" cell="date"/>		                    
		                    <mytag:lookupcolumn property="idName"  title="<%=TchPre.ALIAS_ID_NAME%>"	cell="net.java.dev.ec.table.view.LookUpCell" dictType="T_ID_NAME" />
		                    <ec:column property="idCode"  title="<%=TchPre.ALIAS_ID_CODE%>"/>
							<ec:column property="hotelname" title="<%=TchPre.ALIAS_HOTELNAME%>">
								<a href="${ctx}/pages/hotel/Thotel/show.do?code=${item.hotelid}" >${item.hotelname}</a>
							</ec:column>
		                    <ec:column property="noRoom"  title="<%=TchPre.ALIAS_NO_ROOM%>"/>
		                    <ec:column property="inTime"  title="<%=TchPre.ALIAS_IN_TIME%>" parse="yyyyMMddHHmm" format="yyyy-MM-dd HH:mm" cell="date"/>
		                    
		<ec:column property="操作" title="操作" sortable="false" viewsAllowed="html">
			<a href="${ctx}/pages/hotel/TchPre/show.do?id=${item.id}&<mytag:params includes="ec*,s*" type="queryStringUtf"/>">查看</a>&nbsp;&nbsp;&nbsp;
		</ec:column>
	</ec:row>
</ec:table>
	<table cellpadding="0" cellspacing="0" border="0" class="tb_all">
             <tr>
			  <td colspan="5" class="tb_bottom">
			           <input type="button" value="返回" onclick="history.back()"/>
                    </td>
          </tr>
	</table>
</body>


</html>
