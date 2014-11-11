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
	<title><%=TpersonlogJn.TABLE_ALIAS%>信息</title>
</head>

<body>
<%@ include file="/commons/messages.jsp" %>

<s:form action="/pages/zazh/TpersonlogJn/list.do" method="get" theme="simple">
	<s:hidden name="id" id="id" value="%{model.id}"/>
	<table width="100%" border="1" bordercolor="#7c8ca7" align="center"  cellPadding="0" cellSpacing="0" class="tb_all">
	               <tr>
				          <td colspan="4" class="tb_title"> 
							<%=TpersonlogJn.TABLE_ALIAS%>信息
				          </td>
		           </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=TpersonlogJn.ALIAS_PERSONID%>
		                  </td>
			              <td>
		                           <s:property value="%{model.personid}" />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=TpersonlogJn.ALIAS_CARDNAME%>
		                  </td>
			              <td>
		                           <s:property value="%{model.cardname}" />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=TpersonlogJn.ALIAS_CARDNO%>
		                  </td>
			              <td>
		                           <s:property value="%{model.cardno}" />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=TpersonlogJn.ALIAS_SOURCE%>
		                  </td>
			              <td>
		                           <s:property value="%{model.source}" />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=TpersonlogJn.ALIAS_SID%>
		                  </td>
			              <td>
		                           <s:property value="%{model.sid}" />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=TpersonlogJn.ALIAS_PERSONTYPE%>
		                  </td>
			              <td>
		                           <s:property value="%{model.persontype}" />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=TpersonlogJn.ALIAS_EMPSTATUS%>
		                  </td>
			              <td>
		                           <s:property value="%{model.empstatus}" />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=TpersonlogJn.ALIAS_STARTTIME%>
		                  </td>
			              <td>
		                           <s:property value="%{model.starttime}" />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=TpersonlogJn.ALIAS_ENDTIME%>
		                  </td>
			              <td>
		                           <s:property value="%{model.endtime}" />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=TpersonlogJn.ALIAS_INSERTTIME%>
		                  </td>
			              <td>
		                           <s:property value="%{model.inserttimeString}" />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=TpersonlogJn.ALIAS_UPDATETIME%>
		                  </td>
			              <td>
		                           <s:property value="%{model.updatetimeString}" />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=TpersonlogJn.ALIAS_TABLEFORPIC%>
		                  </td>
			              <td>
		                           <s:property value="%{model.tableforpic}" />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=TpersonlogJn.ALIAS_FIELDFORPIC%>
		                  </td>
			              <td>
		                           <s:property value="%{model.fieldforpic}" />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=TpersonlogJn.ALIAS_CPCODE%>
		                  </td>
			              <td>
		                           <s:property value="%{model.cpcode}" />
		                  </td>
                   </tr>
                   <tr>
						  <td colspan="4" class="tb_bottom">
						           <input type="button" value="返回" onclick="window.location='${ctx}/pages/zazh/TpersonlogJn/list.do?<mytag:params includes="ec*,s*" type="queryStringUtf"/>'"/>
	                      </td>
	               </tr>
	</table>	
</s:form>

</body>

</html>