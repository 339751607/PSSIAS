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
	<title><%=TcpCheck.TABLE_ALIAS%>信息</title>
</head>

<body>
<%@ include file="/commons/messages.jsp" %>

<s:form action="/pages/fjy/TcpCheck/list.do" method="get" theme="simple">
	<s:hidden name="id" id="id" value="%{model.id}"/>
	<table cellpadding="0" cellspacing="0" border="1" class="tb_all">
	               <tr>
				          <td colspan="4" class="tb_title"> 
							<%=TcpCheck.TABLE_ALIAS%>信息
				          </td>
		           </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=TcpCheck.ALIAS_DEPTID%>
		                  </td>
			              <td>
		                           <s:property value="%{model.deptid}" />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=TcpCheck.ALIAS_IDCARD%>
		                  </td>
			              <td>
		                           <s:property value="%{model.idcard}" />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=TcpCheck.ALIAS_CHECKTIME%>
		                  </td>
			              <td>
		                           <s:property value="%{model.checktime}" />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=TcpCheck.ALIAS_DEMO%>
		                  </td>
			              <td>
		                           <s:property value="%{model.demo}" />
		                  </td>
                   </tr>
                   <tr>
						  <td colspan="4" class="tb_bottom">
						           <input type="button" value="返回" onclick="window.location='${ctx}/pages/fjy/TcpCheck/list.do?<mytag:params includes="ec*,s*" type="queryStringUtf"/>'"/>
	                      </td>
	               </tr>
	</table>	
</s:form>

</body>

</html>