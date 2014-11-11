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
	<title><%=Tempworklog.TABLE_ALIAS%>信息</title>
</head>

<body>
<%@ include file="/commons/messages.jsp" %>

<s:form action="/pages/fjy/Tempworklog/list.do" method="get" theme="simple">
	<s:hidden name="worklogid" id="worklogid" value="%{model.worklogid}"/>
	<table cellpadding="0" cellspacing="0" border="1" class="tb_all">
	               <tr>
				          <td colspan="4" class="tb_title"> 
							<%=Tempworklog.TABLE_ALIAS%>信息
				          </td>
		           </tr>
		           <tr class="crosscolor_tr">
                         
                          <td class="crosscolor_td">
			                      <%=Tempworklog.ALIAS_CPNAME%>
		                  </td>
			              <td>
		                           <s:property value="%{model.cpname}" />
		                  </td>
		                   <td class="crosscolor_td">
			                      <%=Tempworklog.ALIAS_EMPTYPE%>
		                  </td>
			              <td>
			                       <mytag:write property="%{model.emptype}"   name="emptype"  notEmpty="true"  dictName="T_DIC_EMPTYPE"/>
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
			                      <%=Tempworklog.ALIAS_DEMO%>
		                  </td>
			              <td colspan="3">
		                           <s:property value="%{model.demo}" />
		                  </td>
                   </tr>
                   <tr>
						  <td colspan="4" class="tb_bottom">
						           <input type="button" value="返回" onclick="window.location='${ctx}/pages/fjy/Tempworklog/list.do?<mytag:params includes="ec*,s*" type="queryStringUtf"/>'"/>
	                      </td>
	               </tr>
	</table>	
</s:form>

</body>

</html>