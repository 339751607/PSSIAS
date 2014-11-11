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
	<title><%=Tcpinfo.TABLE_ALIAS%>信息</title>
</head>

<body>
<%@ include file="/commons/messages.jsp" %>

<s:form action="/jxy/Tcpinfo/list.do" method="get" theme="simple">
	<s:hidden name="cpcode" id="cpcode" value="%{model.cpcode}"/>
	<table cellpadding="0" cellspacing="0" border="0" class="tb_all">
	               <tr>
				          <td colspan="4" class="tb_title"> 
							<%=Tcpinfo.TABLE_ALIAS%>信息
				          </td>
		           </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=Tcpinfo.ALIAS_CPNAME%>
		                  </td>
			              <td colspan="3">
		                           <s:property value="%{model.cpname}" />
		                  </td>
		            </tr>
		           <tr class="crosscolor_tr">       
                          <td class="crosscolor_td">
			                      <%=Tcpinfo.ALIAS_CPADDRESS%>
		                  </td>
			              <td colspan="3">
		                           <s:property value="%{model.cpaddress}" />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=Tcpinfo.ALIAS_WORKAREA%>
		                  </td>
			              <td>
		                           <s:property value="%{model.workarea}" />
		                  </td>
                          <td>
			                      <%=Tcpinfo.ALIAS_PHONE%>
		                  </td>
			              <td>
		                           <s:property value="%{model.phone}" />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=Tcpinfo.ALIAS_FAX%>
		                  </td>
			              <td>
		                           <s:property value="%{model.fax}" />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=Tcpinfo.ALIAS_ENROLCAPITAL%>
		                  </td>
			              <td>
		                           <s:property value="%{model.enrolcapital}" />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=Tcpinfo.ALIAS_POSTALCODE%>
		                  </td>
			              <td>
		                           <s:property value="%{model.postalcode}" />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=Tcpinfo.ALIAS_STARTDATE%>
		                  </td>
			              <td>
		                           <s:property value="%{model.startdate}" />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=Tcpinfo.ALIAS_ECONOMY%>
		                  </td>
			              <td>
			                       <mytag:write property="%{model.economy}"   name="economy"  notEmpty="true"  dictName="T_DIC_CPKIND"/>
		                  </td>
                          <td class="crosscolor_td">
			                      <%=Tcpinfo.ALIAS_CORPCODE%>
		                  </td>
			              <td>
		                           <s:property value="%{model.corpcode}" />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=Tcpinfo.ALIAS_CORPNAME%>
		                  </td>
			              <td>
		                           <s:property value="%{model.corpname}" />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=Tcpinfo.ALIAS_POLICENAME%>
		                  </td>
			              <td>
		                           <s:property value="%{model.policename}" />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=Tcpinfo.ALIAS_POLICEPHONE%>
		                  </td>
			              <td>
		                           <s:property value="%{model.policephone}" />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=Tcpinfo.ALIAS_ACREAGE%>
		                  </td>
			              <td>
		                           <s:property value="%{model.acreage}" />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=Tcpinfo.ALIAS_POLICEUNIT%>
		                  </td>
			              <td>
			                       <mytag:write property="%{model.policeunit}"   name="policeunit"  notEmpty="true"  dictName="ssfj"/>
		                  </td>
                          <td class="crosscolor_td">
			                      <%=Tcpinfo.ALIAS_SCBACKUPNO%>
		                  </td>
			              <td>
		                           <s:property value="%{model.scbackupno}" />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=Tcpinfo.ALIAS_SCBACKUPUNIT%>
		                  </td>
			              <td>
			                       <mytag:write property="%{model.scbackupunit}"   name="scbackupunit"  notEmpty="true"  dictName="ssfj"/>
		                  </td>
                          <td class="crosscolor_td">
			                      <%=Tcpinfo.ALIAS_BASJ%>
		                  </td>
			              <td>
		                           <s:property value="%{model.basj}" />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=Tcpinfo.ALIAS_LICENCEUNIT%>
		                  </td>
			              <td>
		                           <s:property value="%{model.licenceunit}" />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=Tcpinfo.ALIAS_BCRETCODE%>
		                  </td>
			              <td>
		                           <s:property value="%{model.bcretcode}" />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=Tcpinfo.ALIAS_BCRETUNIT%>
		                  </td>
			              <td>
		                           <s:property value="%{model.bcretunit}" />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=Tcpinfo.ALIAS_TAXCODE%>
		                  </td>
			              <td>
		                           <s:property value="%{model.taxcode}" />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=Tcpinfo.ALIAS_TAXUNIT%>
		                  </td>
			              <td>
		                           <s:property value="%{model.taxunit}" />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=Tcpinfo.ALIAS_LICENCE%>
		                  </td>
			              <td>
		                           <s:property value="%{model.licence}" />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=Tcpinfo.ALIAS_FLAG%>
		                  </td>
			              <td>
			                       <mytag:write property="%{model.flag}"   name="flag"  notEmpty="true"  dictName="shiFou"/>
		                  </td>
                          <td class="crosscolor_td">
			                      <%=Tcpinfo.ALIAS_STATION%>
		                  </td>
			              <td>
		                           <s:property value="%{model.stationName}" />
		                  </td>
                   </tr>
                   <tr>
						  <td colspan="4" class="tb_bottom">
						           <input type="button" value="返回" onclick="javascript:history.back()"/>
	                      </td>
	               </tr>
	</table>	
</s:form>

</body>

</html>
