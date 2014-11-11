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
	<title><%=Tcpcaseinfo.TABLE_ALIAS%>信息</title>
</head>

<body>
<%@ include file="/commons/messages.jsp" %>

<s:form action="/jxy/Tcpcaseinfo/list.do" method="get" theme="simple">
	<s:hidden name="id" id="id" value="%{model.id}"/>
	<table cellpadding="0" cellspacing="0" border="0" class="tb_all">
	               <tr>
				          <td colspan="4" class="tb_title"> 
							<%=Tcpcaseinfo.TABLE_ALIAS%>信息
				          </td>
		           </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=Tcpcaseinfo.ALIAS_CPCODE%>
		                  </td>
			              <td>
		                           <s:property value="%{model.cpcode}" />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=Tcpcaseinfo.ALIAS_CASECODE%>
		                  </td>
			              <td>
			              			
		                           <s:property value="%{model.casecode}" />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=Tcpcaseinfo.ALIAS_HAPPENTIME%>
		                  </td>
			              <td>
			              	
		                           <s:property value="%{model.happentime}" />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=Tcpcaseinfo.ALIAS_CASEFLAG%>
		                  </td>
			              <td>
		                           
		                           <mytag:write property="%{model.caseflag}" notEmpty="true" dictName="DIC_ITEM_CASEFLAG"></mytag:write>
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=Tcpcaseinfo.ALIAS_CASETYPE%>
		                  </td>
			              <td>
		                           
		                           <mytag:write property="%{model.casetype}" notEmpty="true" dictName="Diccon_AJ"></mytag:write>
		                  </td>
                          <td></td>
		                  <td></td>		
                   </tr>
                    <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=Tcpcaseinfo.ALIAS_CASEDESC%>
		                  </td>
			              <td colspan="3">
		                   <s:property value="%{model.casedesc}" />
		                  </td>
                   </tr>
		          
                   <tr>
						  <td colspan="4" class="tb_bottom">
						           <input type="button" value="返回" onclick="window.location='${ctx}/jxy/Tcpcaseinfo/list.do?<mytag:params includes="ec*,s*" type="queryStringUtf"/>'"/>
	                      </td>
	               </tr>
	</table>	
</s:form>

</body>

</html>
