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
	<title><%=LoginHistory.TABLE_ALIAS%>信息</title>
</head>

<body>
<%@ include file="/commons/messages.jsp" %>

<s:form action="/pages/LoginHistory/list.do" method="get" theme="simple">
	<s:hidden name="loginid" id="loginid" value="%{model.loginid}"/>
	<table width="100%" border="1" bordercolor="#7c8ca7" align="center"  cellPadding="0" cellSpacing="0" class="tb_all">
	               <tr>
				          <td colspan="4" class="tb_title"> 
							<%=LoginHistory.TABLE_ALIAS%>信息
				          </td>
		           </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=LoginHistory.ALIAS_LOGINTIME%>
		                  </td>
			              <td>
		                           <s:property value="%{model.logintimeString}" />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=LoginHistory.ALIAS_LOGINNAME%>
		                  </td>
			              <td>
		                           <s:property value="%{model.loginname}" />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=LoginHistory.ALIAS_ISVALID%>
		                  </td>
			              <td>
		                           <s:property value="%{model.isvalid}" />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=LoginHistory.ALIAS_INVALIDPASSWORD%>
		                  </td>
			              <td>
		                           <s:property value="%{model.invalidpassword}" />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=LoginHistory.ALIAS_IPADDRESS%>
		                  </td>
			              <td>
		                           <s:property value="%{model.ipaddress}" />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=LoginHistory.ALIAS_BROWSER%>
		                  </td>
			              <td>
		                           <s:property value="%{model.browser}" />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=LoginHistory.ALIAS_HOSTNAME%>
		                  </td>
			              <td>
		                           <s:property value="%{model.hostname}" />
		                  </td>
                          <td>&nbsp;</td>
                          <td>&nbsp;</td>
                   </tr>
                   <tr>
						  <td colspan="4" class="tb_bottom">
						           <input type="button" value="返回" onclick="window.location='${ctx}/pages/LoginHistory/list.do?<mytag:params includes="ec*,s*" type="queryStringUtf"/>'"/>
	                      </td>
	               </tr>
	</table>	
</s:form>

</body>

</html>