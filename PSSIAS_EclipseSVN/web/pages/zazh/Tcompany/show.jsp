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
	<title><%=Tcompany.TABLE_ALIAS%>信息</title>
</head>

<body>
<%@ include file="/commons/messages.jsp" %>

<s:form action="/pages/zazh/Tcompany/list.do" method="get" theme="simple">
	<s:hidden name="cpcode" id="cpcode" value="%{model.cpcode}"/>
	<table width="100%" border="1" bordercolor="#7c8ca7" align="center"  cellPadding="0" cellSpacing="0" class="tb_all">
	               <tr>
				          <td colspan="4" class="tb_title"> 
							<%=Tcompany.TABLE_ALIAS%>
				          </td>
		           </tr>
		           <tr class="crosscolor_tr">

                          <td class="crosscolor_td">
			                      <%=Tcompany.ALIAS_BUSINESSCODE%>			                      
		                  </td>
			              <td>
		                         <mytag:write  name="businesscode"  value="${model.businesscode}"  dictName="T_ITEM_BUSSINESS"/>
		                  </td>
		                  <td class="crosscolor_td">
			                     <%=Tcompany.ALIAS_CPCODE%>
		                  </td>
			              <td>
		                        <s:property value="%{model.cpcode}" />   
		                  </td>
                   </tr>

		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=Tcompany.ALIAS_CPNAME%>
		                  </td>
			              <td>
		                           <s:property value="%{model.cpname}" />
		                  </td>
		                  <td class="crosscolor_td">
			                      <%=Tcompany.ALIAS_CORPNAME%>
		                  </td>
			              <td>
		                           <s:property value="%{model.corpname}" />
		                  </td>

                   </tr>
                   <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=Tcompany.ALIAS_BURCODE%>
		                  </td>
			              <td>
			                   <mytag:write  name="burcode"  value="${model.burcode}"  dictName="ssfj"/>
		                  </td>
                          <td class="crosscolor_td">
			                      <%=Tcompany.ALIAS_STACODE%>
		                  </td>
			              <td>
		                          <mytag:write  name="stacode"  value="${model.stacode}"  dictName="sspcs"/>
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=Tcompany.ALIAS_PHONE%>
		                  </td>
			              <td>
		                           <s:property value="%{model.phone}" />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=Tcompany.ALIAS_FAX%>
		                  </td>
			              <td>
		                           <s:property value="%{model.fax}" />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=Tcompany.ALIAS_POSTALCODE%>
		                  </td>
			              <td>
		                           <s:property value="%{model.postalcode}" />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=Tcompany.ALIAS_STARTDATE%>
		                  </td>
			              <td>
		                           <s:property value="%{model.startdate}" />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=Tcompany.ALIAS_ECONOMY%>
		                  </td>
			              <td>
			                      <mytag:write  name="economy"  value="${model.economy}"  dictName="DIC_ITEM_QYXZ_ALL"/>
	
		                  </td>
                          <td class="crosscolor_td">
			                      <%=Tcompany.ALIAS_CORPCODE%>
		                  </td>
			              <td>
		                           <s:property value="%{model.corpcode}" />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">

		                  <td class="crosscolor_td">
			                      <%=Tcompany.ALIAS_CPADDRESS%>
		                  </td>
			              <td colspan="3">
		                           <s:property value="%{model.cpaddress}" />
		                  </td>
                         
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=Tcompany.ALIAS_POLICENAME%>
		                  </td>
			              <td>
		                           <s:property value="%{model.policename}" />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=Tcompany.ALIAS_POLICEPHONE%>
		                  </td>
			              <td>
		                           <s:property value="%{model.policephone}" />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=Tcompany.ALIAS_WORKAREA%>
		                  </td>
			              <td>
		                           <s:property value="%{model.workarea}" />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=Tcompany.ALIAS_ENROLCAPITAL%>
		                  </td>
			              <td>
		                           <s:property value="%{model.enrolcapital}" />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=Tcompany.ALIAS_ACREAGE%>
		                  </td>
			              <td>
		                           <s:property value="%{model.acreage}" />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=Tcompany.ALIAS_SCBACKUPNO%>
		                  </td>
			              <td>
		                           <s:property value="%{model.scbackupno}" />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=Tcompany.ALIAS_LICENCE%>
		                  </td>
			              <td>
		                           <s:property value="%{model.licence}" />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=Tcompany.ALIAS_LICENCEUNIT%>
		                  </td>
			              <td>
		                           <s:property value="%{model.licenceunit}" />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=Tcompany.ALIAS_BCRETCODE%>
		                  </td>
			              <td>
		                           <s:property value="%{model.bcretcode}" />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=Tcompany.ALIAS_BCRETUNIT%>
		                  </td>
			              <td>
		                           <s:property value="%{model.bcretunit}" />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=Tcompany.ALIAS_TAXCODE%>
		                  </td>
			              <td>
		                           <s:property value="%{model.taxcode}" />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=Tcompany.ALIAS_TAXUNIT%>
		                  </td>
			              <td>
		                           <s:property value="%{model.taxunit}" />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=Tcompany.ALIAS_STATUS%>
		                  </td>
			              <td>
		                           <mytag:write  name="status"  value="${model.status}"  dictName="T_DICT_QYZT"/>
		                  </td>
                          <td class="crosscolor_td">
			                      <%=Tcompany.ALIAS_MODDATE%>
		                  </td>
			              <td>
		                           <s:property value="%{model.moddate}" />
		                  </td>
                   </tr>


                   <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=Tcompany.ALIAS_POLICEUNIT%>
		                  </td>
			              <td>
		                           <s:property value="%{model.policeunit}" />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=Tcompany.ALIAS_SCBACKUPUNIT%>
		                  </td>
			              <td>
		                           <s:property value="%{model.scbackupunit}" />
		                  </td>
                   </tr>
                   <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=Tcompany.ALIAS_BASJ%>
		                  </td>
			              <td>
		                           <s:property value="%{model.basj}" />
		                  </td>
                          <td class="crosscolor_td">
			                     
		                  </td>
			              <td>
		                           
		                  </td>
                   </tr>
                   <!--  
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=Tcompany.ALIAS_EXITEND2%>
		                  </td>
			              <td>
		                           <s:property value="%{model.exitend2}" />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=Tcompany.ALIAS_EXITEND3%>
		                  </td>
			              <td>
		                           <s:property value="%{model.exitend3}" />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=Tcompany.ALIAS_EXITEND1%>
		                  </td>
			              <td>
		                           <s:property value="%{model.exitend1}" />
		                  </td>
                          <td>&nbsp;</td>
                          <td>&nbsp;</td>
                   </tr>
                   -->
                   <tr>
						  <td colspan="4" class="tb_bottom">
						           <input type="button" value="返回" onclick="window.location='${ctx}/pages/zazh/Tcompany/list.do?<mytag:params includes="ec*,s*" type="queryStringUtf"/>'"/>
	                      </td>
	               </tr>
	</table>	
</s:form>

</body>

</html>