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
	<title><%=TpoliceCheck.TABLE_ALIAS%>信息</title>
</head>

<body>
<%@ include file="/commons/messages.jsp" %>

<s:form action="/jxy/TpoliceCheck/list.do" method="get" theme="simple">
	<s:hidden name="checkid" id="checkid" value="%{model.checkid}"/>
	<table cellpadding="0" cellspacing="0" border="0" class="tb_all">
	               <tr>
				          <td colspan="4" class="tb_title"> 
							<%=TpoliceCheck.TABLE_ALIAS%>信息
				          </td>
		           </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=TpoliceCheck.ALIAS_DEPTID%>
		                  </td>
			              <td>
		                           <s:property value="%{model.deptname}" />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=TpoliceCheck.ALIAS_ACCEPTCHECKNAME%>
		                  </td>
			              <td>
		                           <s:property value="%{model.acceptchecknameXm}" />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=TpoliceCheck.ALIAS_CHECKNAME%>
		                  </td>
			              <td>
		                           <s:property value="%{model.checknameXm}" />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=TpoliceCheck.ALIAS_CHECKNAMEPHONE%>
		                  </td>
			              <td>
		                           <s:property value="%{model.checknamephone}" />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=TpoliceCheck.ALIAS_CHECKTIME%>
		                  </td>
			              <td>
		                           <s:property value="%{model.checktimeString}" />
		                  </td>
                          <td>&nbsp;</td>
                          <td>&nbsp;</td>
                   </tr>
                   <tr>
						  <td colspan="4" class="tb_bottom">
						           <input type="button" value="返回" onclick="window.location='${ctx}/jxy/TpoliceCheck/listUser.do?<mytag:params includes="ec*,s*" type="queryStringUtf"/>'"/>
	                      </td>
	               </tr>
	</table>	
</s:form>

</body>

</html>
