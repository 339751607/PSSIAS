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
	<title><%=TcpinfoLog.TABLE_ALIAS%>信息</title>
</head>

<body>
<%@ include file="/commons/messages.jsp" %>

<s:form action="/pages/fjy/TcpinfoLog/list.do" method="get" theme="simple">
	<s:hidden name="logid" id="logid" value="%{model.logid}"/>
	<table cellpadding="0" cellspacing="0" border="1" class="tb_all">
	               <tr>
				          <td colspan="4" class="tb_title"> 
							<%=TcpinfoLog.TABLE_ALIAS%>信息
				          </td>
		           </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=TcpinfoLog.ALIAS_CPCODE%>
		                  </td>
			              <td>
		                           <s:property value="%{model.cpcode}" />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=TcpinfoLog.ALIAS_USERID%>
		                  </td>
			              <td>
		                           <s:property value="%{model.userid}" />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=TcpinfoLog.ALIAS_DEPTID%>
		                  </td>
			              <td>
		                           <s:property value="%{model.deptid}" />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=TcpinfoLog.ALIAS_TYPE%>
		                  </td>
			              <td>
		                           <s:property value="%{model.type}" />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=TcpinfoLog.ALIAS_DEPTNAME%>
		                  </td>
			              <td>
		                           <s:property value="%{model.deptname}" />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=TcpinfoLog.ALIAS_USERNAME%>
		                  </td>
			              <td>
		                           <s:property value="%{model.username}" />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=TcpinfoLog.ALIAS_UPDATEDATE%>
		                  </td>
			              <td>
		                           <s:property value="%{model.updatedateString}" />
		                  </td>
                          <td>&nbsp;</td>
                          <td>&nbsp;</td>
                   </tr>
                   <tr>
						  <td colspan="4" class="tb_bottom">
						           <input type="button" value="返回" onclick="window.location='${ctx}/pages/fjy/TcpinfoLog/list.do?<mytag:params includes="ec*,s*" type="queryStringUtf"/>'"/>
	                      </td>
	               </tr>
	</table>	
</s:form>

</body>

</html>