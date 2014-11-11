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
	<title><%=TfeijiuwupinKeyi.TABLE_ALIAS%>信息</title>
</head>

<body>
<%@ include file="/commons/messages.jsp" %>

<s:form action="/pages/fjy/TfeijiuwupinKeyi/list.do" method="get" theme="simple">
	<s:hidden name="xh" id="xh" value="%{model.xh}"/>
	<table cellpadding="0" cellspacing="0" border="1" class="tb_all">
	               <tr>
				          <td colspan="4" class="tb_title"> 
							<%=TfeijiuwupinKeyi.TABLE_ALIAS%>信息
				          </td>
		           </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=TfeijiuwupinKeyi.ALIAS_WUPINXH%>
		                  </td>
			              <td>
		                           <s:property value="%{model.wupinxh}" />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=TfeijiuwupinKeyi.ALIAS_KEYIYUANYIN%>
		                  </td>
			              <td>
		                           <s:property value="%{model.keyiyuanyin}" />
		                  </td>
                   </tr>
                   <tr>
						  <td colspan="4" class="tb_bottom">
						           <input type="button" value="返回" onclick="window.location='${ctx}/pages/fjy/TfeijiuwupinKeyi/list.do?<mytag:params includes="ec*,s*" type="queryStringUtf"/>'"/>
	                      </td>
	               </tr>
	</table>	
</s:form>

</body>

</html>