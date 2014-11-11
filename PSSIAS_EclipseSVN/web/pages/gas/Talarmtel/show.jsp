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
	<title><%=Talarmtel.TABLE_ALIAS%>信息</title>
</head>

<body>
<%@ include file="/commons/messages.jsp" %>

<s:form action="/pages/gas/Talarmtel/list.do" method="get" theme="simple">
	<s:hidden name="deptcode" id="deptcode" value="%{model.deptcode}"/>
	<table width="100%" border="1" bordercolor="#7c8ca7" align="center"  cellPadding="0" cellSpacing="0" class="tb_all">
	               <tr>
				          <td colspan="4" class="tb_title"> 
							<%=Talarmtel.TABLE_ALIAS%>信息
				          </td>
		           </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=Talarmtel.ALIAS_DEPTNAME%>
		                  </td>
			              <td>
		                           <s:property value="%{model.deptname}" />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=Talarmtel.ALIAS_ALARMALL%>
		                  </td>
			              <td>
		                            <mytag:write property="%{alarmall}"  name="alarmall"   notEmpty="true"  dictName="shiFou"/>
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=Talarmtel.ALIAS_ALARMTEL%>
		                  </td>
			              <td>
		                           <s:property value="%{model.alarmtel}" />
		                  </td>
                          <td class="crosscolor_td">
		                  </td>
			              <td>
		                  </td>
                   </tr>
                   <tr>
						  <td colspan="4" class="tb_bottom">
						           <input type="button" value="返回" onclick="window.location='${ctx}/pages/gas/Talarmtel/list.do?<mytag:params includes="ec*,s*" type="queryStringUtf"/>'"/>
	                      </td>
	               </tr>
	</table>	
</s:form>

</body>

</html>