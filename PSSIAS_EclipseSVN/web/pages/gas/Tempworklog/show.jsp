<%@page import="com.dyneinfo.gas.model.*" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/commons/taglibs.jsp" %>
<%
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+request.getContextPath()+"/";
%>
<html>

<head>
	<%@ include file="/commons/meta.jsp" %>
	<base href="<%=basePath%>">
	<title><%=Tempworklog.TABLE_ALIAS%>信息</title>
</head>

<body>
<%@ include file="/commons/messages.jsp" %>

<s:form action="/pages/gas/Tempworklog/list.do" method="get" theme="simple">
	<s:hidden name="empcode" id="empcode" value="%{model.empcode}"/>
	<s:hidden name="cpcode" id="cpcode" value="%{model.cpcode}"/>
	<table width="100%" border="1" bordercolor="#7c8ca7" align="center"  cellPadding="0" cellSpacing="0" class="tb_all">
	               <tr>
				          <td colspan="4" class="tb_title"> 
							<%=Tempworklog.TABLE_ALIAS%>信息
				          </td>
		           </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=Tempworklog.ALIAS_EMPCODE%>
		                  </td>
			              <td>
		                           <s:property value="%{model.empcode}" />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=Tempworklog.ALIAS_CPCODE%>
		                  </td>
			              <td>
		                           <s:property value="%{model.cpcode}" />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=Tempworklog.ALIAS_INDATE%>
		                  </td>
			              <td>
		                           <s:property value="%{model.indate}" />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=Tempworklog.ALIAS_LEFTDATE%>
		                  </td>
			              <td>
		                           <s:property value="%{model.leftdate}" />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=Tempworklog.ALIAS_EMPDUTY%>
		                  </td>
			              <td>
		                           <s:property value="%{model.empduty}" />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=Tempworklog.ALIAS_DEMO%>
		                  </td>
			              <td>
		                           <s:property value="%{model.demo}" />
		                  </td>
                   </tr>
                   <tr>
						  <td colspan="4" class="tb_bottom">
						           <input type="button" value="返回" onclick="window.location='${ctx}/pages/gas/Tempworklog/list.do?<mytag:params includes="ec*,s*" type="queryStringUtf"/>'"/>
	                      </td>
	               </tr>
	</table>	
</s:form>

</body>

</html>