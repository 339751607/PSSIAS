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
	<title><%=TtztbFile.TABLE_ALIAS%>信息</title>
</head>

<body>
<%@ include file="/commons/messages.jsp" %>

<s:form action="/pages/gas/TtztbFile/list.do" method="get" theme="simple">
	<s:hidden name="id" id="id" value="%{model.id}"/>
	<table cellpadding="0" cellspacing="0" border="0" class="tb_all">
	               <tr>
				          <td colspan="4" class="tb_title"> 
							<%=TtztbFile.TABLE_ALIAS%>信息
				          </td>
		           </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=TtztbFile.ALIAS_FILEID%>
		                  </td>
			              <td>
		                           <s:property value="%{model.fileid}" />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=TtztbFile.ALIAS_FILECONTENT%>
		                  </td>
			              <td>
		                           <s:property value="%{model.filecontent}" />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=TtztbFile.ALIAS_TZTBTYPE%>
		                  </td>
			              <td>
		                           <s:property value="%{model.tztbtype}" />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=TtztbFile.ALIAS_FILENAME%>
		                  </td>
			              <td>
		                           <s:property value="%{model.filename}" />
		                  </td>
                   </tr>
                   <tr>
						  <td colspan="4" class="tb_bottom">
						           <input type="button" value="返回" onclick="window.location='${ctx}/pages/gas/TtztbFile/list.do?<mytag:params includes="ec*,s*" type="queryStringUtf"/>'"/>
	                      </td>
	               </tr>
	</table>	
</s:form>

</body>

</html>