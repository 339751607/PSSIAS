<%@page import="com.dyneinfo.zazh.model.*" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/commons/taglibs.jsp" %>
<%
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+request.getContextPath()+"/";
%>
<html>

<head>
	<%@ include file="/commons/meta.jsp" %>
	<base href="<%=basePath%>">
	<title><%=Tcarlog.TABLE_ALIAS%>信息</title>
</head>

<body>
<%@ include file="/commons/messages.jsp" %>

<s:form action="/pages/zazh/Tcarlog/list.do" method="get" theme="simple">
	<s:hidden name="id" id="id" value="%{model.id}"/>
	<table width="100%" border="1" bordercolor="#7c8ca7" align="center"  cellPadding="0" cellSpacing="0" class="tb_all">
	               <tr>
				          <td colspan="4" class="tb_title"> 
							<%=Tcarlog.TABLE_ALIAS%>信息
				          </td>
		           </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=Tcarlog.ALIAS_CARBASEID%>
		                  </td>
			              <td>
		                           <s:property value="%{model.carbaseid}" />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=Tcarlog.ALIAS_SOURCE%>
		                  </td>
			              <td>
		                           <s:property value="%{model.source}" />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=Tcarlog.ALIAS_SID%>
		                  </td>
			              <td>
		                           <s:property value="%{model.sid}" />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=Tcarlog.ALIAS_CARTYPE%>
		                  </td>
			              <td>
		                           <s:property value="%{model.cartype}" />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=Tcarlog.ALIAS_STARTTIME%>
		                  </td>
			              <td>
		                           <s:property value="%{model.starttime}" />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=Tcarlog.ALIAS_ENDTIME%>
		                  </td>
			              <td>
		                           <s:property value="%{model.endtime}" />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=Tcarlog.ALIAS_INSERTTIME%>
		                  </td>
			              <td>
		                           <s:property value="%{model.inserttimeString}" />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=Tcarlog.ALIAS_UPDATETIME%>
		                  </td>
			              <td>
		                           <s:property value="%{model.updatetimeString}" />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=Tcarlog.ALIAS_TABLEFORPIC%>
		                  </td>
			              <td>
		                           <s:property value="%{model.tableforpic}" />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=Tcarlog.ALIAS_FIELDFORPIC%>
		                  </td>
			              <td>
		                           <s:property value="%{model.fieldforpic}" />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=Tcarlog.ALIAS_CPCODE%>
		                  </td>
			              <td>
		                           <s:property value="%{model.cpcode}" />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=Tcarlog.ALIAS_KEYFORPIC%>
		                  </td>
			              <td>
		                           <s:property value="%{model.keyforpic}" />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=Tcarlog.ALIAS_CARID%>
		                  </td>
			              <td>
		                           <s:property value="%{model.carid}" />
		                  </td>
                          <td>&nbsp;</td>
                          <td>&nbsp;</td>
                   </tr>
                   <tr>
						  <td colspan="4" class="tb_bottom">
						           <input type="button" value="返回" onclick="window.location='${ctx}/pages/zazh/Tcarlog/list.do?<mytag:params includes="ec*,s*" type="queryStringUtf"/>'"/>
	                      </td>
	               </tr>
	</table>	
</s:form>

</body>

</html>