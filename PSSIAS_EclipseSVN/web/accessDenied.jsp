<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/commons/taglibs.jsp"%>
<%@ page import="org.springframework.security.context.SecurityContextHolder" %>
<%@ page import="org.springframework.security.Authentication" %>
<%
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ request.getContextPath() + "/";
%>
<html>
	<head>
		<base href="<%=basePath%>">
		<STYLE TYPE="text/css">
		<!--
		body {
			text-align: center;
		}
		-->
		</STYLE>
		<title>用户权限</title>
	</head>
	<body leftmargin="0" topmargin="0">
		<table cellspacing="0" cellpadding="0" width="590" border="0">
			<tbody>
				<tr>
					<td bgcolor="#3399cc"><img height="1" src="${ctx}/images/spacer.gif" width="1" border="0"></td>
				</tr>
				<tr>
					<td background="${ctx}/images/new_back2.jpg"><img height="14" src="${ctx}/images/spacer.gif" width="1" border="0"></td>
				</tr>
				<tr>
					<td bgcolor="#000000"><img height="1" src="${ctx}/images/spacer.gif" width="1" border="0"></td>
				</tr>
			</tbody>
		</table>
		<table width="590" border="1" align="center" cellpadding="4"
			cellspacing="0" bordercolorlight="#2F8ABC" bordercolordark="#FFF1DD">

			<tr>
				<td colspan="3">
					<div align="center">
						<p>
							&nbsp;
						</p>
						<p>
							你没有操作权限！
						</p>
						<p>
							&nbsp;
						</p>
					</div>
				</td>
			</tr>
			<tr bgcolor="#ecf0f4">
				<td colspan="3" bgcolor="#ecf0f4">
					<div align="center">
						<input onclick="javascript:history.go(-1);" type="button" value="返  回">
						&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;

					</div>
				</td>
			</tr>
		</table>
	</body>
</html>
