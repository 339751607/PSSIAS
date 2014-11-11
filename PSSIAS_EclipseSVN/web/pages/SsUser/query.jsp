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
	<title><%=SsUser.TABLE_ALIAS%>查询</title>
</head>

<body onload="quickSelectInit()" >
<%@ include file="/commons/messages.jsp" %>

<s:form action="/pages/SsUser/list.do" method="post">
	<input type="submit" value="提交" onclick="return new Validation(document.forms[0]).validate();"/>
	<input type="button" value="返回列表" onclick="window.location='${ctx}/pages/SsUser/list.do'"/>
	<input type="button" value="后退" onclick="history.back();"/>
	
	<table class="formTable">
	
		<tr bgcolor="#FFFFFF">
		   <td class="tdLabel"><%=SsUser.ALIAS_USERNAME%></td>
		   <td>
				<input  type="text" name="s_username" size="30" maxlength="50" class="max-length-50"/>
		   </td>
		</tr>
		<tr bgcolor="#FFFFFF">
		   <td class="tdLabel"><%=SsUser.ALIAS_PASSWORD%></td>
		   <td>
				<input  type="text" name="s_password" size="30" maxlength="50" class="max-length-50"/>
		   </td>
		</tr>
		<tr bgcolor="#FFFFFF">
		   <td class="tdLabel"><%=SsUser.ALIAS_FULLNAME%></td>
		   <td>
				<input  type="text" name="s_fullname" size="30" maxlength="128" class="max-length-128"/>
		   </td>
		</tr>
		<tr bgcolor="#FFFFFF">
		   <td class="tdLabel"><%=SsUser.ALIAS_SEX%></td>
		   <td>
				<input  type="text" name="s_sex" size="30" maxlength="1" class="max-length-1"/>
		   </td>
		</tr>
		<tr bgcolor="#FFFFFF">
		   <td class="tdLabel"><%=SsUser.ALIAS_SFZH%></td>
		   <td>
				<input  type="text" name="s_sfzh" size="30" maxlength="200" class="max-length-200"/>
		   </td>
		</tr>
		<tr bgcolor="#FFFFFF">
		   <td class="tdLabel"><%=SsUser.ALIAS_POLICEID%></td>
		   <td>
				<input  type="text" name="s_policeid" size="30" maxlength="200" class="max-length-200"/>
		   </td>
		</tr>
		<tr bgcolor="#FFFFFF">
		   <td class="tdLabel"><%=SsUser.ALIAS_PHONE%></td>
		   <td>
				<input  type="text" name="s_phone" size="30" maxlength="32" class="max-length-32"/>
		   </td>
		</tr>
		<tr bgcolor="#FFFFFF">
		   <td class="tdLabel"><%=SsUser.ALIAS_MOBILE%></td>
		   <td>
				<input  type="text" name="s_mobile" size="30" maxlength="32" class="max-length-32"/>
		   </td>
		</tr>
		<tr bgcolor="#FFFFFF">
		   <td class="tdLabel"><%=SsUser.ALIAS_FAX%></td>
		   <td>
				<input  type="text" name="s_fax" size="30" maxlength="32" class="max-length-32"/>
		   </td>
		</tr>
		<tr bgcolor="#FFFFFF">
		   <td class="tdLabel"><%=SsUser.ALIAS_ADDRESS%></td>
		   <td>
				<input  type="text" name="s_address" size="30" maxlength="64" class="max-length-64"/>
		   </td>
		</tr>
		<tr bgcolor="#FFFFFF">
		   <td class="tdLabel"><%=SsUser.ALIAS_ZIP%></td>
		   <td>
				<input  type="text" name="s_zip" size="30" maxlength="32" class="max-length-32"/>
		   </td>
		</tr>
		<tr bgcolor="#FFFFFF">
		   <td class="tdLabel"><%=SsUser.ALIAS_EMAILADDRESS%></td>
		   <td>
				<input  type="text" name="s_emailaddress" size="30" maxlength="200" class="max-length-200"/>
		   </td>
		</tr>
		<tr bgcolor="#FFFFFF">
		   <td class="tdLabel"><%=SsUser.ALIAS_CREATEDATE%></td>
		   <td>
				<input onclick="WdatePicker({dateFmt:'<%=SsUser.FORMAT_CREATEDATE%>'})" type="text" name="s_createdate" size="30" maxlength="7" class="validate-date "/>
		   </td>
		</tr>
		<tr bgcolor="#FFFFFF">
		   <td class="tdLabel"><%=SsUser.ALIAS_DEPTID%></td>
		   <td>
				<input  type="text" name="s_deptid" size="30" maxlength="22" class="validate-number "/>
		   </td>
		</tr>
		<tr bgcolor="#FFFFFF">
		   <td class="tdLabel"><%=SsUser.ALIAS_ENABLED%></td>
		   <td>
				<input  type="text" name="s_enabled" size="30" maxlength="22" class="validate-number "/>
		   </td>
		</tr>
		<tr bgcolor="#FFFFFF">
		   <td class="tdLabel"><%=SsUser.ALIAS_PHOTO%></td>
		   <td>
				<input  type="text" name="s_photo" size="30" maxlength="128" class="max-length-128"/>
		   </td>
		</tr>
	
	</table>
</s:form>	
			
</body>

</html>