<%@page import="com.dyneinfo.fjy.model.*" %>
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
	<title><%=TfeijiuwupinKeyi.TABLE_ALIAS%> 维护</title>
</head>

<body onload="quickSelectInit()" >
<%@ include file="/commons/messages.jsp" %>




<div class="queryPanel">
	    <table cellpadding="0" cellspacing="0" border="1" class="tb_all">          
		           <tr>
			              <td class="tb_bottom" colspan="4">      
	                              
			                        <input type="button" value="返回" onclick="javascript:window.parent.doBack();"/>
			              </td>
		           </tr>
	    </table>
</div>


<ec:table items='page.result' var="item" method="get"
	retrieveRowsCallback="limit" sortRowsCallback="limit" filterRowsCallback="limit"
	action="${ctx}/pages/fjy/TfeijiuwupinKeyi/listDisplay.do" autoIncludeParameters="true">
	<ec:row>
		
		                   
		                    <ec:column property="keyiyuanyin"  title="<%=TfeijiuwupinKeyi.ALIAS_KEYIYUANYIN%>"/>
		<ec:column property="操作" title="操作" sortable="false" viewsAllowed="html">
			<a href="${ctx}/pages/fjy/TfeijiuwupinKeyi/show.do?xh=${item.xh}&<mytag:params includes="ec*,s*" type="queryStringUtf"/>">查看</a>
		</ec:column>
	</ec:row>
</ec:table>

</body>

</html>


