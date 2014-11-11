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
	<title><%=TpersonlogJw.TABLE_ALIAS%>信息</title>
</head>

<body>
<%@ include file="/commons/messages.jsp" %>

<s:form action="/pages/zazh/TpersonlogJw/list.do" method="get" theme="simple">
	<s:hidden name="id" id="id" value="%{model.id}"/>
	<table width="100%" border="1" bordercolor="#7c8ca7" align="center"  cellPadding="0" cellSpacing="0" class="tb_all">
	               <tr>
				          <td colspan="4" class="tb_title"> 
							<%=TpersonlogJw.TABLE_ALIAS%>信息
				          </td>
		           </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=TpersonlogJw.ALIAS_PERSONID%>
		                  </td>
			              <td>
		                           <s:property value="%{model.personid}" />
		                  </td>
                          <td class="crosscolor_td">			                      
		                  </td>
			              <td>		                         
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=TpersonlogJw.ALIAS_PASS_T%>
		                  </td>
			              <td>
		                           <s:property value="%{model.passT}" />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=TpersonlogJw.ALIAS_PASS_NO%>
		                  </td>
			              <td>
		                           <s:property value="%{model.passNo}" />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=TpersonlogJw.ALIAS_SOURCE%>
		                  </td>
			              <td>
		                           <s:property value="%{model.source}" />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=TpersonlogJw.ALIAS_SID%>
		                  </td>
			              <td>
		                           <s:property value="%{model.sid}" />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=TpersonlogJw.ALIAS_PERSONTYPE%>
		                  </td>
			              <td>
		                           <s:property value="%{model.persontype}" />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=TpersonlogJw.ALIAS_EMPSTATUS%>
		                  </td>
			              <td>
		                           <s:property value="%{model.empstatus}" />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=TpersonlogJw.ALIAS_STARTTIME%>
		                  </td>
			              <td>
		                           <s:property value="%{model.starttime}" />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=TpersonlogJw.ALIAS_ENDTIME%>
		                  </td>
			              <td>
		                           <s:property value="%{model.endtime}" />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=TpersonlogJw.ALIAS_INSERTTIME%>
		                  </td>
			              <td>
		                           <s:property value="%{model.inserttimeString}" />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=TpersonlogJw.ALIAS_UPDATETIME%>
		                  </td>
			              <td>
		                           <s:property value="%{model.updatetimeString}" />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=TpersonlogJw.ALIAS_TABLEFORPIC%>
		                  </td>
			              <td>
		                           <s:property value="%{model.tableforpic}" />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=TpersonlogJw.ALIAS_FIELDFORPIC%>
		                  </td>
			              <td>
		                           <s:property value="%{model.fieldforpic}" />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=TpersonlogJw.ALIAS_CPCODE%>
		                  </td>
			              <td>
		                           <s:property value="%{model.cpcode}" />
		                  </td>
                          <td>&nbsp;</td>
                          <td>&nbsp;</td>
                   </tr>
                   <tr>
						  <td colspan="4" class="tb_bottom">
						           <input type="button" value="返回" onclick="window.location='${ctx}/pages/zazh/TpersonlogJw/list.do?<mytag:params includes="ec*,s*" type="queryStringUtf"/>'"/>
	                      </td>
	               </tr>
	</table>	
</s:form>

</body>

</html>