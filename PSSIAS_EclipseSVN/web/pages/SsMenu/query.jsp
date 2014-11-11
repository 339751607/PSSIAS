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
	<title><%=SsMenu.TABLE_ALIAS%>查询</title>
</head>

<body onload="quickSelectInit()" >
<%@ include file="/commons/messages.jsp" %>

<s:form action="/pages/SsMenu/list.do" method="post">
	<input type="submit" value="提交" onclick="return new Validation(document.forms[0]).validate();"/>
	<input type="button" value="返回列表" onclick="window.location='${ctx}/pages/SsMenu/list.do'"/>
	<input type="button" value="后退" onclick="history.back();"/>
	
	<table class="formTable">
	
		<tr bgcolor="#FFFFFF">
		   <td class="tdLabel"><%=SsMenu.ALIAS_MENUNAME%></td>
		   <td>
				<input  type="text" name="s_menuname" size="30" maxlength="50" class="max-length-50"/>
		   </td>
		</tr>
		<tr bgcolor="#FFFFFF">
		   <td class="tdLabel"><%=SsMenu.ALIAS_MENUDESC%></td>
		   <td>
				<input  type="text" name="s_menudesc" size="30" maxlength="256" class="max-length-256"/>
		   </td>
		</tr>
		<tr bgcolor="#FFFFFF">
		   <td class="tdLabel"><%=SsMenu.ALIAS_MENULABEL%></td>
		   <td>
				<input  type="text" name="s_menulabel" size="30" maxlength="50" class="max-length-50"/>
		   </td>
		</tr>
		<tr bgcolor="#FFFFFF">
		   <td class="tdLabel"><%=SsMenu.ALIAS_ISLEAF%></td>
		   <td>
				<input  type="text" name="s_isleaf" size="30" maxlength="50" class="max-length-50"/>
		   </td>
		</tr>
		<tr bgcolor="#FFFFFF">
		   <td class="tdLabel"><%=SsMenu.ALIAS_MENUURL%></td>
		   <td>
				<input  type="text" name="s_menuurl" size="30" maxlength="50" class="max-length-50"/>
		   </td>
		</tr>
		<tr bgcolor="#FFFFFF">
		   <td class="tdLabel"><%=SsMenu.ALIAS_MENULEVEL%></td>
		   <td>
				<input  type="text" name="s_menulevel" size="30" maxlength="50" class="max-length-50"/>
		   </td>
		</tr>
		<tr bgcolor="#FFFFFF">
		   <td class="tdLabel"><%=SsMenu.ALIAS_ROOTID%></td>
		   <td>
				<input  type="text" name="s_rootid" size="30" maxlength="50" class="max-length-50"/>
		   </td>
		</tr>
		<tr bgcolor="#FFFFFF">
		   <td class="tdLabel"><%=SsMenu.ALIAS_PARENTID%></td>
		   <td>
				<input  type="text" name="s_parentid" size="30" maxlength="22" class="validate-number "/>
		   </td>
		</tr>
		<tr bgcolor="#FFFFFF">
		   <td class="tdLabel"><%=SsMenu.ALIAS_IMAGEPATH%></td>
		   <td>
				<input  type="text" name="s_imagepath" size="30" maxlength="50" class="max-length-50"/>
		   </td>
		</tr>
		<tr bgcolor="#FFFFFF">
		   <td class="tdLabel"><%=SsMenu.ALIAS_MENUSEQ%></td>
		   <td>
				<input  type="text" name="s_menuseq" size="30" maxlength="50" class="max-length-50"/>
		   </td>
		</tr>
		<tr bgcolor="#FFFFFF">
		   <td class="tdLabel"><%=SsMenu.ALIAS_DISPLAYORDER%></td>
		   <td>
				<input  type="text" name="s_displayorder" size="30" maxlength="22" class="validate-number "/>
		   </td>
		</tr>
	
	</table>
</s:form>	
			
</body>

</html>