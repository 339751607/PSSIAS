<%@page import="com.dyneinfo.pmdd.model.*" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/commons/taglibs.jsp" %>
<%
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+request.getContextPath()+"/";
%>
<html>

<head>
	<%@ include file="/commons/meta.jsp" %>
	<base href="<%=basePath%>">
	<title><%=Sdcpupload.TABLE_ALIAS%>信息</title>
</head>

<body>
<%@ include file="/commons/messages.jsp" %>

<s:form action="/pages/pmdd/Sdcpupload/list.do" method="get" theme="simple">
	<s:hidden name="xh" id="xh" value="%{model.xh}"/>
	<table cellpadding="0" cellspacing="0" border="0" class="tb_all">
	               <tr>
				          <td colspan="4" class="tb_title"> 
							<%=Sdcpupload.TABLE_ALIAS%>信息
				          </td>
		           </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=Sdcpupload.ALIAS_CITYCODE%>
		                  </td>
			              <td>
		                           <s:property value="%{model.citycode}" />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=Sdcpupload.ALIAS_CITYNAME%>
		                  </td>
			              <td>
		                           <s:property value="%{model.cityname}" />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=Sdcpupload.ALIAS_SCJS%>
		                  </td>
			              <td>
		                           <s:property value="%{model.scjs}" />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=Sdcpupload.ALIAS_WSCJS%>
		                  </td>
			              <td>
		                           <s:property value="%{model.wscjs}" />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=Sdcpupload.ALIAS_SCL%>
		                  </td>
			              <td>
		                           <s:property value="%{model.scl}" />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=Sdcpupload.ALIAS_LXWSCJS%>
		                  </td>
			              <td>
		                           <s:property value="%{model.lxwscjs}" />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=Sdcpupload.ALIAS_TJRQ%>
		                  </td>
			              <td>
		                           <s:property value="%{model.tjrq}" />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=Sdcpupload.ALIAS_SCSJL%>
		                  </td>
			              <td>
		                           <s:property value="%{model.scsjl}" />
		                  </td>
                   </tr>
                   <tr>
						  <td colspan="4" class="tb_bottom">
						           <input type="button" value="返回" onclick="window.location='${ctx}/pages/pmdd/Sdcpupload/list.do?<mytag:params includes="ec*,s*" type="queryStringUtf"/>'"/>
	                      </td>
	               </tr>
	</table>	
</s:form>

</body>

</html>