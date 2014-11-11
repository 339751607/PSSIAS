<%@page import="com.dyneinfo.ylcs.model.*" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/commons/taglibs.jsp" %>
<%
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+request.getContextPath()+"/";
%>
<html>

<head>
	<%@ include file="/commons/meta.jsp" %>
	<base href="<%=basePath%>">
	<title><%=TcpinfoYl.TABLE_ALIAS%>信息</title>
</head>

<body>
<%@ include file="/commons/messages.jsp" %>

<s:form action="/pages/ylcs/TcpinfoYl/list.do" method="get" theme="simple">
	<s:hidden name="locode" id="locode" value="%{model.locode}"/>
	<table width="100%" border="1" bordercolor="#7c8ca7" align="center"  cellPadding="0" cellSpacing="0" class="tb_all">
	               <tr>
				          <td colspan="4" class="tb_title"> 
							<%=TcpinfoYl.TABLE_ALIAS%>信息
				          </td>
		           </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=TcpinfoYl.ALIAS_STATION%>
		                  </td>
			              <td>
		                           <s:property value="%{model.station}" />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=TcpinfoYl.ALIAS_STARTDATE%>
		                  </td>
			              <td>
		                           <s:property value="%{model.startdateString}" />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=TcpinfoYl.ALIAS_ACREAGE%>
		                  </td>
			              <td>
		                           <s:property value="%{model.acreage}" />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=TcpinfoYl.ALIAS_ENROLCAPITAL%>
		                  </td>
			              <td>
		                           <s:property value="%{model.enrolcapital}" />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=TcpinfoYl.ALIAS_CPNAME%>
		                  </td>
			              <td>
		                           <s:property value="%{model.cpname}" />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=TcpinfoYl.ALIAS_CPADDRESS%>
		                  </td>
			              <td>
		                           <s:property value="%{model.cpaddress}" />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=TcpinfoYl.ALIAS_PHONE%>
		                  </td>
			              <td>
		                           <s:property value="%{model.phone}" />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=TcpinfoYl.ALIAS_FAX%>
		                  </td>
			              <td>
		                           <s:property value="%{model.fax}" />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=TcpinfoYl.ALIAS_POSTALCODE%>
		                  </td>
			              <td>
		                           <s:property value="%{model.postalcode}" />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=TcpinfoYl.ALIAS_ECONOMY%>
		                  </td>
			              <td>
		                           <s:property value="%{model.economy}" />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=TcpinfoYl.ALIAS_CORPCODE%>
		                  </td>
			              <td>
		                           <s:property value="%{model.corpcode}" />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=TcpinfoYl.ALIAS_CORPNAME%>
		                  </td>
			              <td>
		                           <s:property value="%{model.corpname}" />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=TcpinfoYl.ALIAS_POLICENAME%>
		                  </td>
			              <td>
		                           <s:property value="%{model.policename}" />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=TcpinfoYl.ALIAS_POLICEPHONE%>
		                  </td>
			              <td>
		                           <s:property value="%{model.policephone}" />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=TcpinfoYl.ALIAS_WORKAREA%>
		                  </td>
			              <td>
		                           <s:property value="%{model.workarea}" />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=TcpinfoYl.ALIAS_POLICEUNIT%>
		                  </td>
			              <td>
		                           <s:property value="%{model.policeunit}" />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=TcpinfoYl.ALIAS_SCBACKUPNO%>
		                  </td>
			              <td>
		                           <s:property value="%{model.scbackupno}" />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=TcpinfoYl.ALIAS_SCBACKUPUNIT%>
		                  </td>
			              <td>
		                           <s:property value="%{model.scbackupunit}" />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=TcpinfoYl.ALIAS_LICENCE%>
		                  </td>
			              <td>
		                           <s:property value="%{model.licence}" />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=TcpinfoYl.ALIAS_LICENCEUNIT%>
		                  </td>
			              <td>
		                           <s:property value="%{model.licenceunit}" />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=TcpinfoYl.ALIAS_BCRETCODE%>
		                  </td>
			              <td>
		                           <s:property value="%{model.bcretcode}" />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=TcpinfoYl.ALIAS_BCRETUNIT%>
		                  </td>
			              <td>
		                           <s:property value="%{model.bcretunit}" />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=TcpinfoYl.ALIAS_TAXCODE%>
		                  </td>
			              <td>
		                           <s:property value="%{model.taxcode}" />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=TcpinfoYl.ALIAS_TAXUNIT%>
		                  </td>
			              <td>
		                           <s:property value="%{model.taxunit}" />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=TcpinfoYl.ALIAS_THCODE%>
		                  </td>
			              <td>
		                           <s:property value="%{model.thcode}" />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=TcpinfoYl.ALIAS_FJCODE%>
		                  </td>
			              <td>
		                           <s:property value="%{model.fjcode}" />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=TcpinfoYl.ALIAS_WORKAREASEC%>
		                  </td>
			              <td>
		                           <s:property value="%{model.workareasec}" />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=TcpinfoYl.ALIAS_STOPDATE%>
		                  </td>
			              <td>
		                           <s:property value="%{model.stopdateString}" />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=TcpinfoYl.ALIAS_HIS%>
		                  </td>
			              <td>
		                           <s:property value="%{model.his}" />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=TcpinfoYl.ALIAS_JWDZB%>
		                  </td>
			              <td>
		                           <s:property value="%{model.jwdzb}" />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=TcpinfoYl.ALIAS_GDXX%>
		                  </td>
			              <td>
		                           <s:property value="%{model.gdxx}" />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=TcpinfoYl.ALIAS_XFZSL%>
		                  </td>
			              <td>
		                           <s:property value="%{model.xfzsl}" />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=TcpinfoYl.ALIAS_BXSL%>
		                  </td>
			              <td>
		                           <s:property value="%{model.bxsl}" />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=TcpinfoYl.ALIAS_ZAJB%>
		                  </td>
			              <td>
		                           <s:property value="%{model.zajb}" />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=TcpinfoYl.ALIAS_CSXJ%>
		                  </td>
			              <td>
		                           <s:property value="%{model.csxj}" />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=TcpinfoYl.ALIAS_STATE%>
		                  </td>
			              <td>
		                           <s:property value="%{model.state}" />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=TcpinfoYl.ALIAS_POLICELEVELCODE%>
		                  </td>
			              <td>
		                           <s:property value="%{model.policelevelcode}" />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=TcpinfoYl.ALIAS_FLAGPACK%>
		                  </td>
			              <td>
		                           <s:property value="%{model.flagpack}" />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=TcpinfoYl.ALIAS_AUTHORIZATIONCODE%>
		                  </td>
			              <td>
		                           <s:property value="%{model.authorizationcode}" />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=TcpinfoYl.ALIAS_SPJRURL%>
		                  </td>
			              <td>
		                           <s:property value="%{model.spjrurl}" />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=TcpinfoYl.ALIAS_CURRENTSCORE%>
		                  </td>
			              <td>
		                           <s:property value="%{model.currentscore}" />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=TcpinfoYl.ALIAS_JCJB%>
		                  </td>
			              <td>
		                           <s:property value="%{model.jcjb}" />
		                  </td>
                   </tr>
                   <tr>
						  <td colspan="4" class="tb_bottom">
						           <input type="button" value="返回" onclick="window.location='${ctx}/pages/ylcs/TcpinfoYl/list.do?<mytag:params includes="ec*,s*" type="queryStringUtf"/>'"/>
	                      </td>
	               </tr>
	</table>	
</s:form>

</body>

</html>