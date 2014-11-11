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
	<title><%=Vupdatacount.TABLE_ALIAS%>信息</title>
</head>

<body>
<%@ include file="/commons/messages.jsp" %>

<s:form action="/jxy/Vupdatacount/list.do" method="get" theme="simple">
	<s:hidden name="cpcode" id="cpcode" value="%{model.cpcode}"/>
	<table cellpadding="0" cellspacing="0" border="0" class="tb_all">
	               <tr>
				          <td colspan="4" class="tb_title"> 
							<%=Vupdatacount.TABLE_ALIAS%>信息
				          </td>
		           </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=Vupdatacount.ALIAS_CPNAME%>
		                  </td>
			              <td>
		                           <s:property value="%{model.cpname}" />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=Vupdatacount.ALIAS_CPADDRESS%>
		                  </td>
			              <td>
		                           <s:property value="%{model.cpaddress}" />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=Vupdatacount.ALIAS_PHONE%>
		                  </td>
			              <td>
		                           <s:property value="%{model.phone}" />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=Vupdatacount.ALIAS_FAX%>
		                  </td>
			              <td>
		                           <s:property value="%{model.fax}" />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=Vupdatacount.ALIAS_POSTALCODE%>
		                  </td>
			              <td>
		                           <s:property value="%{model.postalcode}" />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=Vupdatacount.ALIAS_STARTDATE%>
		                  </td>
			              <td>
		                           <s:property value="%{model.startdate}" />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=Vupdatacount.ALIAS_ECONOMY%>
		                  </td>
			              <td>
		                           <s:property value="%{model.economy}" />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=Vupdatacount.ALIAS_CORPCODE%>
		                  </td>
			              <td>
		                           <s:property value="%{model.corpcode}" />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=Vupdatacount.ALIAS_CORPNAME%>
		                  </td>
			              <td>
		                           <s:property value="%{model.corpname}" />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=Vupdatacount.ALIAS_POLICENAME%>
		                  </td>
			              <td>
		                           <s:property value="%{model.policename}" />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=Vupdatacount.ALIAS_POLICEPHONE%>
		                  </td>
			              <td>
		                           <s:property value="%{model.policephone}" />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=Vupdatacount.ALIAS_WORKAREA%>
		                  </td>
			              <td>
		                           <s:property value="%{model.workarea}" />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=Vupdatacount.ALIAS_ENROLCAPITAL%>
		                  </td>
			              <td>
		                           <s:property value="%{model.enrolcapital}" />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=Vupdatacount.ALIAS_ACREAGE%>
		                  </td>
			              <td>
		                           <s:property value="%{model.acreage}" />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=Vupdatacount.ALIAS_POLICEUNIT%>
		                  </td>
			              <td>
		                           <s:property value="%{model.policeunit}" />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=Vupdatacount.ALIAS_SCBACKUPNO%>
		                  </td>
			              <td>
		                           <s:property value="%{model.scbackupno}" />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=Vupdatacount.ALIAS_SCBACKUPUNIT%>
		                  </td>
			              <td>
		                           <s:property value="%{model.scbackupunit}" />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=Vupdatacount.ALIAS_LICENCE%>
		                  </td>
			              <td>
		                           <s:property value="%{model.licence}" />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=Vupdatacount.ALIAS_LICENCEUNIT%>
		                  </td>
			              <td>
		                           <s:property value="%{model.licenceunit}" />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=Vupdatacount.ALIAS_BCRETCODE%>
		                  </td>
			              <td>
		                           <s:property value="%{model.bcretcode}" />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=Vupdatacount.ALIAS_BCRETUNIT%>
		                  </td>
			              <td>
		                           <s:property value="%{model.bcretunit}" />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=Vupdatacount.ALIAS_TAXCODE%>
		                  </td>
			              <td>
		                           <s:property value="%{model.taxcode}" />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=Vupdatacount.ALIAS_TAXUNIT%>
		                  </td>
			              <td>
		                           <s:property value="%{model.taxunit}" />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=Vupdatacount.ALIAS_FLAG%>
		                  </td>
			              <td>
		                           <s:property value="%{model.flag}" />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=Vupdatacount.ALIAS_STATION%>
		                  </td>
			              <td>
		                           <s:property value="%{model.station}" />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=Vupdatacount.ALIAS_BASJ%>
		                  </td>
			              <td>
		                           <s:property value="%{model.basj}" />
		                  </td>
                   </tr>
                   <tr>
						  <td colspan="4" class="tb_bottom">
						           <input type="button" value="返回" onclick="window.location='${ctx}/jxy/Vupdatacount/list.do?<mytag:params includes="ec*,s*" type="queryStringUtf"/>'"/>
	                      </td>
	               </tr>
	</table>	
</s:form>

</body>

</html>
