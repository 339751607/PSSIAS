<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/commons/taglibs.jsp" %>
<%
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+request.getContextPath()+"/";
%>
<html>
<head>
	<%@ include file="/commons/meta.jsp" %>
	<base href="<%=basePath%>">
	<title></title>
</head>
<body>

		<table width="400" height="200" border="1" align="center" cellpadding="4" cellspacing="0" bordercolorlight="#2F8ABC" bordercolordark="#FFF1DD">

			<tr>
				<td colspan="3">
					<s:if test="%{actionErrors != null && actionErrors.size > 0}">
						<div class="error">
							<s:iterator value="%{actionErrors}">
								<img src="${ctx}/images/iconWarning.gif" alt="Warning" />
								<s:property />
								<br />
							</s:iterator>
						</div>
					</s:if>

					<s:if test="#request.message != null">
						<div class="message">
							<img src="${ctx}/images/iconInformation.gif" alt="Info" />
							<s:property value="#request.message" />
							<br />
						</div>
					</s:if>
				</td>
			</tr>
			<tr bgcolor="#ecf0f4" height="30">
				<td colspan="3" bgcolor="#ecf0f4">
					<div align="center">
						<input onclick="window.close();" type="button"
							value="关   闭">
						&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;

					</div>
				</td>
			</tr>
		</table>
	</body>
</html>
