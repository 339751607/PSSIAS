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
	<title><%=Tconfig.TABLE_ALIAS%>信息</title>
</head>

<body>
<%@ include file="/commons/messages.jsp" %>

<s:form action="/pages/gas/Tconfig/list.do" method="get" theme="simple">
	<s:hidden name="key" id="key" value="%{model.key}"/>
	<table width="100%" border="1" bordercolor="#7c8ca7" align="center"  cellPadding="0" cellSpacing="0" class="tb_all">
	               <tr>
				          <td colspan="4" class="tb_title"> 
							<%=Tconfig.TABLE_ALIAS%>信息
				          </td>
		           </tr>
		           <c:if test="${model.key =='gwxzqh'}">
		            <tr class="crosscolor_tr">
			              <td style="width:20%">
		                          重点预警区域
		                  </td>
			              <td colspan="3" >
		                           <s:property value="%{model.name}" />
		                  </td>
                   </tr>
		           </c:if>
		           
		           <c:if test="${model.key !='gwxzqh'}">
		           <tr class="crosscolor_tr">
			              <td style="width:20%">
		                           <s:property value="%{model.name}" />
		                  </td>
			              <td colspan="3" >
		                           <s:property value="%{model.code}" />
		                  </td>
                   </tr>
                   </c:if>
                   <tr>
						  <td colspan="4" class="tb_bottom">
						           <input type="button" value="返回" onclick="window.location='${ctx}/pages/gas/Tconfig/list.do?<mytag:params includes="ec*,s*" type="queryStringUtf"/>'"/>
	                      </td>
	               </tr>
	</table>	
</s:form>

</body>

</html>