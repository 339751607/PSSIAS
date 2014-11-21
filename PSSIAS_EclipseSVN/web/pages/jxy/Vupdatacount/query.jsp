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
	<title><%=Vupdatacount.TABLE_ALIAS%>查询</title>
</head>

<body>
<%@ include file="/commons/messages.jsp" %>
<div class="queryPanel">
    <s:form action="/pages/jxy/Vupdatacount/list.do"  theme="simple" style="display: inline;" method="post">
	    <table cellpadding="0" cellspacing="0" border="0" class="tb_all">
	               <tr>
			              <td class="tb_title" colspan="4"><%=Vupdatacount.TABLE_ALIAS%>查询</td>
		           </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=Vupdatacount.ALIAS_CPNAME%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.cpname}"  name="s_cpname"  />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=Vupdatacount.ALIAS_CPADDRESS%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.cpaddress}"  name="s_cpaddress"  />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=Vupdatacount.ALIAS_PHONE%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.phone}"  name="s_phone"  />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=Vupdatacount.ALIAS_FAX%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.fax}"  name="s_fax"  />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=Vupdatacount.ALIAS_POSTALCODE%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.postalcode}"  name="s_postalcode"  />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=Vupdatacount.ALIAS_STARTDATE%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.startdate}"  name="s_startdate"  />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=Vupdatacount.ALIAS_ECONOMY%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.economy}"  name="s_economy"  />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=Vupdatacount.ALIAS_CORPCODE%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.corpcode}"  name="s_corpcode"  />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=Vupdatacount.ALIAS_CORPNAME%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.corpname}"  name="s_corpname"  />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=Vupdatacount.ALIAS_POLICENAME%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.policename}"  name="s_policename"  />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=Vupdatacount.ALIAS_POLICEPHONE%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.policephone}"  name="s_policephone"  />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=Vupdatacount.ALIAS_WORKAREA%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.workarea}"  name="s_workarea"  />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=Vupdatacount.ALIAS_ENROLCAPITAL%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.enrolcapital}"  name="s_enrolcapital"  />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=Vupdatacount.ALIAS_ACREAGE%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.acreage}"  name="s_acreage"  />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=Vupdatacount.ALIAS_POLICEUNIT%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.policeunit}"  name="s_policeunit"  />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=Vupdatacount.ALIAS_SCBACKUPNO%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.scbackupno}"  name="s_scbackupno"  />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=Vupdatacount.ALIAS_SCBACKUPUNIT%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.scbackupunit}"  name="s_scbackupunit"  />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=Vupdatacount.ALIAS_LICENCE%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.licence}"  name="s_licence"  />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=Vupdatacount.ALIAS_LICENCEUNIT%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.licenceunit}"  name="s_licenceunit"  />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=Vupdatacount.ALIAS_BCRETCODE%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.bcretcode}"  name="s_bcretcode"  />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=Vupdatacount.ALIAS_BCRETUNIT%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.bcretunit}"  name="s_bcretunit"  />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=Vupdatacount.ALIAS_TAXCODE%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.taxcode}"  name="s_taxcode"  />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=Vupdatacount.ALIAS_TAXUNIT%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.taxunit}"  name="s_taxunit"  />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=Vupdatacount.ALIAS_FLAG%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.flag}"  name="s_flag"  />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=Vupdatacount.ALIAS_STATION%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.station}"  name="s_station"  />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=Vupdatacount.ALIAS_BASJ%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.basj}"  name="s_basj"  />
		                  </td>
                   </tr>
		           <tr>
			              <td class="tb_bottom" colspan="4">
			                       <input type="submit"  value="查询" onclick="getReferenceForm(this).action='${ctx}/pages/jxy/Vupdatacount/list.do'"/>
	                               <input type="submit"  value="新增" onclick="getReferenceForm(this).action='${ctx}/pages/jxy/Vupdatacount/create.do?<mytag:params includes="ec*,s*" type="queryStringUtf"/>'"/>
			              </td>
		           </tr>
	    </table>
    </s:form>
</div>
			
</body>

</html>
