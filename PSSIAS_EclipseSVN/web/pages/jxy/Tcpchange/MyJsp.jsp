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

<s:form action="/pages/jxy/Tcpinfo/list.do" method="get" theme="simple">
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
		                             <s:textfield label="%{@vs@ALIAS_CPNAME}" key="s_cpname" value="%{model.cpname}"  cssClass=" max-length-40" required="false" />
		                  </td>
		            </tr>
		           <tr class="crosscolor_tr">       
                          <td class="crosscolor_td">
			                      <%=Tcpinfo.ALIAS_CPADDRESS%>
		                  </td>
			              <td colspan="3">
		                            <s:textfield  label="%{@vs@ALIAS_CPADDRESS}" key="s_cpaddress" value="%{model.cpaddress}"  cssClass="required max-length-40" required="false" />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=Tcpinfo.ALIAS_WORKAREA%>
		                  </td>
			              <td>
		                           <s:property value="%{model.workarea}" />
		                  </td>
                          <td class="crosscolor_td">
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
		                          <s:textfield  label="%{@vs@ALIAS_CORPNAME}" key="s_corpname" value="%{model.corpname}"  cssClass="required max-length-30" required="false" />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=Tcpinfo.ALIAS_POLICENAME%>
		                  </td>
			              <td>
		                          <s:textfield  label="%{@vs@ALIAS_POLICENAME}" key="s_policename" value="%{model.policename}"  cssClass="required max-length-30" required="false" />
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
			                         <mytag:select  property="%{model.policeunit}"  styleClass="required validate-selection"    name="s_policeunit"   notEmpty="false"  dictName="ssfj"/>
		                 <input type="hidden" name="policeuni"  id="policeuni" value="<mytag:write  property="%{model.policeunit}" notEmpty="false" dictName="ssfj"></mytag:write>"> 
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
		                         <mytag:select  property="%{model.station}"  styleClass="required validate-selection"    name="s_station"   notEmpty="false"  dictName="sspcs"/>
		                           <input type="hidden" name="station1"  id="station1" value="<mytag:write  property="%{model.station}" notEmpty="false" dictName="sspcs"></mytag:write>"> 
		                  </td>
                   </tr>
                   <tr>
						  <td colspan="4" class="tb_bottom">
						           <input type="button" value="返回" onclick="window.location='${ctx}/pages/jxy/Tcpinfo/list.do?<mytag:params includes="ec*,s*" type="queryStringUtf"/>'"/>
	                      </td>
	               </tr>
	</table>	
</s:form>

</body>

</html>
