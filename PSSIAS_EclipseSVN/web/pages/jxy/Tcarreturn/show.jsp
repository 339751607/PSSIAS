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
	<title><%=Tcarreturn.TABLE_ALIAS%>信息</title>
</head>

<body>
<%@ include file="/commons/messages.jsp" %>

<s:form action="/pages/jxy/Tcarreturn/list.do" method="get" theme="simple">
	<s:hidden name="enrolid" id="enrolid" value="%{model.enrolid}"/>
	<table cellpadding="0" cellspacing="0" border="0" class="tb_all">
	               <tr>
				          <td colspan="4" class="tb_title"> 
							<%=Tcarreturn.TABLE_ALIAS%>信息
				          </td>
		           </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=Tcarreturn.ALIAS_DELINAME%>
		                  </td>
			              <td>
		                           <s:property value="%{model.deliname}" />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=Tcarreturn.ALIAS_DELICREDTYPE%>
		                  </td>
			              <td>
		                           <s:property value="%{model.delicredtype}" />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=Tcarreturn.ALIAS_DELICREDCODE%>
		                  </td>
			              <td>
		                           <s:property value="%{model.delicredcode}" />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=Tcarreturn.ALIAS_RECETIME%>
		                  </td>
			              <td>
		                           <s:property value="%{model.recetime}" />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=Tcarreturn.ALIAS_RECENAME%>
		                  </td>
			              <td>
		                           <s:property value="%{model.recename}" />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=Tcarreturn.ALIAS_TAKEOFFNAME%>
		                  </td>
			              <td>
		                           <s:property value="%{model.takeoffname}" />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=Tcarreturn.ALIAS_TOCREDTYPE%>
		                  </td>
			              <td>
		                           <s:property value="%{model.tocredtype}" />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=Tcarreturn.ALIAS_TOCREDCODE%>
		                  </td>
			              <td>
		                           <s:property value="%{model.tocredcode}" />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=Tcarreturn.ALIAS_TOTIME%>
		                  </td>
			              <td>
		                           <s:property value="%{model.totime}" />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=Tcarreturn.ALIAS_FLAG%>
		                  </td>
			              <td>
		                           <s:property value="%{model.flag}" />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=Tcarreturn.ALIAS_ENROLTIME%>
		                  </td>
			              <td>
		                           <s:property value="%{model.enroltime}" />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=Tcarreturn.ALIAS_OPERATOR%>
		                  </td>
			              <td>
		                           <s:property value="%{model.operator}" />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=Tcarreturn.ALIAS_DELITELEPHONE%>
		                  </td>
			              <td>
		                           <s:property value="%{model.delitelephone}" />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=Tcarreturn.ALIAS_SERVERITEM%>
		                  </td>
			              <td>
		                           <s:property value="%{model.serveritem}" />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=Tcarreturn.ALIAS_DEMO%>
		                  </td>
			              <td>
		                           <s:property value="%{model.demo}" />
		                  </td>
                          <td>&nbsp;</td>
                          <td>&nbsp;</td>
                   </tr>
                   <tr>
						  <td colspan="4" class="tb_bottom">
						           <input type="button" value="返回" onclick="window.location='${ctx}/pages/jxy/Tcarreturn/list.do?<mytag:params includes="ec*,s*" type="queryStringUtf"/>'"/>
	                      </td>
	               </tr>
	</table>	
</s:form>

</body>

</html>
