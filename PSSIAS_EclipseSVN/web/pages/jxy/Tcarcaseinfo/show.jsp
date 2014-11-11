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
	<title><%=Tcarcaseinfo.TABLE_ALIAS%>信息</title>
</head>

<body>
<%@ include file="/commons/messages.jsp" %>

<s:form action="/jxy/Tcarcaseinfo/list.do" method="get" theme="simple">
	<s:hidden name="enrolid" id="enrolid" value="%{model.enrolid}"/>
	<s:hidden name="credid" id="credid" value="%{model.credid}"/>
	<table cellpadding="0" cellspacing="0" border="0" class="tb_all">
	               <tr>
				          <td colspan="4" class="tb_title"> 
							<%=Tcarcaseinfo.TABLE_ALIAS%>信息
				          </td>
		           </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=Tcarcaseinfo.ALIAS_ENROLID%>
		                  </td>
			              <td>
		                           <s:property value="%{model.enrolid}" />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=Tcarcaseinfo.ALIAS_CREDID%>
		                  </td>
			              <td>
		                           <s:property value="%{model.credid}" />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=Tcarcaseinfo.ALIAS_CREDUNIT%>
		                  </td>
			              <td>
		                           <s:property value="%{model.credunit}" />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=Tcarcaseinfo.ALIAS_PARTI%>
		                  </td>
			              <td>
	
		                                    <mytag:write property="%{model.parti}" name="parti"
							notEmpty="true" dictName="clshbw" />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=Tcarcaseinfo.ALIAS_PARTII%>
			                     
		                  </td>
			              <td>
			               <mytag:write property="%{model.partii}" name="partii"
							notEmpty="true" dictName="clshbw" />
		                           
		                  </td>
                          <td class="crosscolor_td">
			                      <%=Tcarcaseinfo.ALIAS_PARTIII%>
		                  </td>
			              <td>
			              <mytag:write property="%{model.partiii}" name="partiii"
							notEmpty="true" dictName="clshbw" />
		                           
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=Tcarcaseinfo.ALIAS_REPORTER%>
		                  </td>
			              <td>
		                           <s:property value="%{model.reporter}" />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=Tcarcaseinfo.ALIAS_REPTIME%>
		                  </td>
			              <td>
		                           <s:property value="%{model.reptime}" />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=Tcarcaseinfo.ALIAS_DEMO%>
		                  </td>
			              <td  colspan="3">
		                           <s:property value="%{model.demo}" />
		                  </td>

                   </tr>


	</table>	
</s:form>

</body>

</html>
