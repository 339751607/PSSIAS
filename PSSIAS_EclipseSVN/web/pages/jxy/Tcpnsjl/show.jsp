<%@page import="com.dyneinfo.jxy.model.*" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/commons/taglibs.jsp" %>
<%
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+request.getContextPath()+"/";
%>
<html>

<head>
	<%@ include file="/commons/meta.jsp" %>
	<base href="<%=basePath%>">
	<title><%=Tcpnsjl.TABLE_ALIAS%>信息</title>
</head>

<body>
<%@ include file="/commons/messages.jsp" %>

<s:form action="/pages/jxy/Tcpnsjl/list.do" method="get" theme="simple">
	<s:hidden name="cpcode" id="cpcode" value="%{model.cpcode}"/>
	<s:hidden name="shnd" id="shnd" value="%{model.shnd}"/>
	<table cellpadding="0" cellspacing="0" border="0" class="tb_all">
	               <tr>
				          <td colspan="4" class="tb_title"> 
							<%=Tcpnsjl.TABLE_ALIAS%>
				          </td>
		           </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=Tcpnsjl.ALIAS_CPCODE%>
		                  </td>
			              <td>
		                           <s:property value="%{model.cpcode}" />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=Tcpnsjl.ALIAS_SHND%>
		                  </td>
			              <td>
		                           <s:property value="%{model.shnd}" />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=Tcpnsjl.ALIAS_SHRJ%>
		                  </td>
			              <td>
		                           <s:property value="%{model.shrj}" />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=Tcpnsjl.ALIAS_NSYJ%>
		                  </td>
			              <td>
		                           <s:property value="%{model.nsyj}" />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=Tcpnsjl.ALIAS_QSR%>
		                  </td>
			              <td>
		                           <s:property value="%{model.qsr}" />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=Tcpnsjl.ALIAS_JBR%>
		                  </td>
			              <td>
		                           <s:property value="%{model.jbr}" />
		                  </td>
                   </tr>
                   <tr>
						  <td colspan="4" class="tb_bottom">
						           <input type="button" value="返回" onclick="window.location='${ctx}/pages/jxy/Tcpnsjl/list.do?<mytag:params includes="ec*,s*" type="queryStringUtf"/>'"/>
	                      </td>
	               </tr>
	</table>	
</s:form>

</body>

</html>
