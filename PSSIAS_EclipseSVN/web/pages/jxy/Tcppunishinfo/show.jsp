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
	<title><%=Tcppunishinfo.TABLE_ALIAS%>信息</title>
</head>

<body>
<%@ include file="/commons/messages.jsp" %>

<s:form action="/jxy/Tcppunishinfo/list.do" method="get" theme="simple">
	<s:hidden name="cpcode" id="cpcode" value="%{model.cpcode}"/>
	<s:hidden name="pfileno" id="pfileno" value="%{model.pfileno}"/>
	<table cellpadding="0" cellspacing="0" border="0" class="tb_all">
	               <tr>
				          <td colspan="4" class="tb_title"> 
							<%=Tcppunishinfo.TABLE_ALIAS%>
				          </td>
		           </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=Tcppunishinfo.ALIAS_CPCODE%>
		                  </td>
			              <td>
		                           <s:property value="%{model.cpcode}" />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=Tcppunishinfo.ALIAS_PDATE%>
		                  </td>
			              <td>
		                           <s:property value="%{model.pdate}" />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=Tcppunishinfo.ALIAS_PFILENO%>
		                  </td>
			              <td>
		                           <s:property value="%{model.pfileno}" />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=Tcppunishinfo.ALIAS_AUTHUNIT%>
		                  </td>
			              <td>
		                         
		                           <mytag:write property="%{model.authunit}" notEmpty="false" dictName="ssfj"></mytag:write>
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=Tcppunishinfo.ALIAS_AUTHPERSON%>
		                  </td>
			              <td>
		                           <s:property value="%{model.authperson}" />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=Tcppunishinfo.ALIAS_EXECPERSON%>
		                  </td>
			              <td>
		                           <s:property value="%{model.execperson}" />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
		            <td class="crosscolor_td">
			                      <%=Tcppunishinfo.ALIAS_PPERSON%>
		                  </td>
			              <td>
		                           <s:property value="%{model.pperson}" />
		                  </td>
                          
                          <td class="crosscolor_td">
			                      <%=Tcppunishinfo.ALIAS_PTYPE%>
		                  </td>
			              <td>
		                           
		                           <mytag:write property="%{model.ptype}" notEmpty="false" dictName="Diccon_cf"></mytag:write>
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=Tcppunishinfo.ALIAS_RANGE%>
		                  </td>
			              <td colspan="3">
		                           <s:property value="%{model.range}" />
		                  </td>
		                  
                         
                   </tr>
                     <tr class="crosscolor_tr">
                          <td class="crosscolor_td" >
			                      <%=Tcppunishinfo.ALIAS_CAUSE%>
		                  </td>
			              <td colspan="3">
		                           <s:property value="%{model.cause}" />
		                  </td>
		                  </tr>
                   <tr>
						  <td colspan="4" class="tb_bottom">
						           <input type="button" value="返回" onclick="window.location='${ctx}/jxy/Tcppunishinfo/list.do?<mytag:params includes="ec*,s*" type="queryStringUtf"/>'"/>
	                      </td>
	               </tr>
	</table>	
</s:form>

</body>

</html>
