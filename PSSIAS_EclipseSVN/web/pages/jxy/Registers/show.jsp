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
	<title><%=Registers.TABLE_ALIAS%>信息</title>
</head>

<body>
<%@ include file="/commons/messages.jsp" %>

<s:form action="/pages/jxy/Registers/list.do" method="get" theme="simple">
	<s:hidden name="unitid" id="unitid" value="%{model.unitid}"/>
	<table cellpadding="0" cellspacing="0" border="0" class="tb_all">
	               <tr>
				          <td colspan="4" class="tb_title"> 
							<%=Registers.TABLE_ALIAS%>信息
				          </td>
		           </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=Registers.ALIAS_CLUSTERGROUP%>
		                  </td>
			              <td>
		                           <s:property value="%{model.clustergroup}" />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=Registers.ALIAS_IPADDRESS%>
		                  </td>
			              <td>
		                           <s:property value="%{model.ipaddress}" />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=Registers.ALIAS_DATASOURCENAME%>
		                  </td>
			              <td>
		                           <s:property value="%{model.datasourcename}" />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=Registers.ALIAS_NOTE%>
		                  </td>
			              <td>
			                       <mytag:write property="%{model.note}"   name="note"  notEmpty="true"  dictName="T_DIC_SEX"/>
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=Registers.ALIAS_PACKAGES%>
		                  </td>
			              <td>
		                           <s:property value="%{model.packages}" />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=Registers.ALIAS_PORT%>
		                  </td>
			              <td>
		                           <s:property value="%{model.port}" />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=Registers.ALIAS_PROTOCOL%>
		                  </td>
			              <td>
		                           <s:property value="%{model.protocol}" />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=Registers.ALIAS_REGISTERTIME%>
		                  </td>
			              <td>
		                           <s:property value="%{model.registertimeString}" />
		                  </td>
                   </tr>
                   <tr>
						  <td colspan="4" class="tb_bottom">
						           <input type="button" value="返回" onclick="window.location='${ctx}/pages/jxy/Registers/list.do?<mytag:params includes="ec*,s*" type="queryStringUtf"/>'"/>
	                      </td>
	               </tr>
	</table>	
</s:form>

</body>

</html>
