<%@page import="com.dyneinfo.zazh.model.*" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/commons/taglibs.jsp" %>
<%
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+request.getContextPath()+"/";
%>
<html>

<head>
	<%@ include file="/commons/meta.jsp" %>
	<base href="<%=basePath%>">
	<title><%=SsRole.TABLE_ALIAS%>信息</title>
</head>

<body>
<%@ include file="/commons/messages.jsp" %>

<s:form action="/pages/SsRole/list.do" method="get" theme="simple">
	<s:hidden name="roleid" id="roleid" value="%{model.roleid}"/>

	<table cellpadding="0" cellspacing="0" border="0" class="tb_all">
	     <tr>
				  <td colspan="4" class="tb_title"> 
							<%=SsRole.TABLE_ALIAS%>信息
				  </td>
		</tr>
	    <tr class="crosscolor_tr">
			<td class="crosscolor_td"><%=SsRole.ALIAS_ROLENAME%></td>	
			<td><s:property value="%{model.rolename}" /></td>
        
	    
			<td class="crosscolor_td"><%=SsRole.ALIAS_ROLEDESC%></td>	
			<td><s:property value="%{model.roledesc}" /></td>
        </tr>
        <tr>
						<td colspan="4" class="tb_bottom">
							<input type="button" value="返回列表" onclick="window.location='${ctx}/pages/SsRole/list.do'"/>
	                        <input type="button" value="后退" onclick="history.back();"/>
	
						</td>
	     </tr>
	</table>
</s:form>

</body>

</html>