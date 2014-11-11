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
	<title><%=TcpinfoYl.TABLE_ALIAS%>查询</title>
</head>

<body>
<%@ include file="/commons/messages.jsp" %>
<div class="queryPanel">
    <s:form action="/pages/ylcs/TcpinfoYl/list.do"  theme="simple" style="display: inline;" method="post">
	    <table width="100%" border="1" bordercolor="#7c8ca7" align="center"  cellPadding="0" cellSpacing="0" class="tb_all">
	               <tr>
			              <td class="tb_title" colspan="4"><%=TcpinfoYl.TABLE_ALIAS%>查询</td>
		           </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=TcpinfoYl.ALIAS_STATION%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.station}"  name="s_station"  />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=TcpinfoYl.ALIAS_STARTDATE%>
		                  </td>
			              <td>
		                           <s:select name="dateSelect1" list="dateSelectMap"  onchange="dateselect(this,'s_startdateBegin','s_startdateEnd','yyyy-MM-dd');"  value="#request.dateSelect1" listKey="key"   listValue="value" theme="simple" label=""  emptyOption="false" ></s:select>
			                          从<input id="d3131" name="s_startdateBegin"  value="${pageRequest.filters.startdateBegin}"   maxlength="0" size="12" class="Wdate" type="text" onFocus="WdatePicker({dateFmt:'<%=TcpinfoYl.FORMAT_STARTDATE%>',maxDate:'#F{$dp.$D(\'d3141\')}'})"/> &nbsp;到&nbsp;
			                        <input id="d3141" name="s_startdateEnd"   value="${pageRequest.filters.startdateEnd}"  maxlength="0" size="12" class="Wdate" type="text" onFocus="WdatePicker({dateFmt:'<%=TcpinfoYl.FORMAT_STARTDATE%>',minDate:'#F{$dp.$D(\'d3131\')}'})"/>
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=TcpinfoYl.ALIAS_ACREAGE%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.acreage}"  name="s_acreage"  />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=TcpinfoYl.ALIAS_ENROLCAPITAL%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.enrolcapital}"  name="s_enrolcapital"  />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=TcpinfoYl.ALIAS_CPNAME%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.cpname}"  name="s_cpname"  />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=TcpinfoYl.ALIAS_CPADDRESS%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.cpaddress}"  name="s_cpaddress"  />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=TcpinfoYl.ALIAS_PHONE%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.phone}"  name="s_phone"  />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=TcpinfoYl.ALIAS_FAX%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.fax}"  name="s_fax"  />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=TcpinfoYl.ALIAS_POSTALCODE%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.postalcode}"  name="s_postalcode"  />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=TcpinfoYl.ALIAS_ECONOMY%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.economy}"  name="s_economy"  />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=TcpinfoYl.ALIAS_CORPCODE%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.corpcode}"  name="s_corpcode"  />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=TcpinfoYl.ALIAS_CORPNAME%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.corpname}"  name="s_corpname"  />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=TcpinfoYl.ALIAS_POLICENAME%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.policename}"  name="s_policename"  />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=TcpinfoYl.ALIAS_POLICEPHONE%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.policephone}"  name="s_policephone"  />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=TcpinfoYl.ALIAS_WORKAREA%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.workarea}"  name="s_workarea"  />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=TcpinfoYl.ALIAS_POLICEUNIT%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.policeunit}"  name="s_policeunit"  />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=TcpinfoYl.ALIAS_SCBACKUPNO%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.scbackupno}"  name="s_scbackupno"  />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=TcpinfoYl.ALIAS_SCBACKUPUNIT%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.scbackupunit}"  name="s_scbackupunit"  />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=TcpinfoYl.ALIAS_LICENCE%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.licence}"  name="s_licence"  />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=TcpinfoYl.ALIAS_LICENCEUNIT%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.licenceunit}"  name="s_licenceunit"  />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=TcpinfoYl.ALIAS_BCRETCODE%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.bcretcode}"  name="s_bcretcode"  />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=TcpinfoYl.ALIAS_BCRETUNIT%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.bcretunit}"  name="s_bcretunit"  />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=TcpinfoYl.ALIAS_TAXCODE%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.taxcode}"  name="s_taxcode"  />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=TcpinfoYl.ALIAS_TAXUNIT%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.taxunit}"  name="s_taxunit"  />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=TcpinfoYl.ALIAS_THCODE%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.thcode}"  name="s_thcode"  />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=TcpinfoYl.ALIAS_FJCODE%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.fjcode}"  name="s_fjcode"  />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=TcpinfoYl.ALIAS_WORKAREASEC%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.workareasec}"  name="s_workareasec"  />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=TcpinfoYl.ALIAS_STOPDATE%>
		                  </td>
			              <td>
		                           <s:select name="dateSelect27" list="dateSelectMap"  onchange="dateselect(this,'s_stopdateBegin','s_stopdateEnd','yyyy-MM-dd');"  value="#request.dateSelect27" listKey="key"   listValue="value" theme="simple" label=""  emptyOption="false" ></s:select>
			                          从<input id="d31327" name="s_stopdateBegin"  value="${pageRequest.filters.stopdateBegin}"   maxlength="0" size="12" class="Wdate" type="text" onFocus="WdatePicker({dateFmt:'<%=TcpinfoYl.FORMAT_STOPDATE%>',maxDate:'#F{$dp.$D(\'d31427\')}'})"/> &nbsp;到&nbsp;
			                        <input id="d31427" name="s_stopdateEnd"   value="${pageRequest.filters.stopdateEnd}"  maxlength="0" size="12" class="Wdate" type="text" onFocus="WdatePicker({dateFmt:'<%=TcpinfoYl.FORMAT_STOPDATE%>',minDate:'#F{$dp.$D(\'d31327\')}'})"/>
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=TcpinfoYl.ALIAS_HIS%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.his}"  name="s_his"  />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=TcpinfoYl.ALIAS_JWDZB%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.jwdzb}"  name="s_jwdzb"  />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=TcpinfoYl.ALIAS_GDXX%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.gdxx}"  name="s_gdxx"  />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=TcpinfoYl.ALIAS_XFZSL%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.xfzsl}"  name="s_xfzsl"  />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=TcpinfoYl.ALIAS_BXSL%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.bxsl}"  name="s_bxsl"  />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=TcpinfoYl.ALIAS_ZAJB%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.zajb}"  name="s_zajb"  />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=TcpinfoYl.ALIAS_CSXJ%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.csxj}"  name="s_csxj"  />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=TcpinfoYl.ALIAS_STATE%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.state}"  name="s_state"  />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=TcpinfoYl.ALIAS_POLICELEVELCODE%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.policelevelcode}"  name="s_policelevelcode"  />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=TcpinfoYl.ALIAS_FLAGPACK%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.flagpack}"  name="s_flagpack"  />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=TcpinfoYl.ALIAS_AUTHORIZATIONCODE%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.authorizationcode}"  name="s_authorizationcode"  />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=TcpinfoYl.ALIAS_SPJRURL%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.spjrurl}"  name="s_spjrurl"  />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=TcpinfoYl.ALIAS_CURRENTSCORE%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.currentscore}"  name="s_currentscore"  />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=TcpinfoYl.ALIAS_JCJB%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.jcjb}"  name="s_jcjb"  />
		                  </td>
                   </tr>
		           <tr>
			              <td class="tb_bottom" colspan="4">
			                       <input type="submit"  value="查询" onclick="getReferenceForm(this).action='${ctx}/pages/ylcs/TcpinfoYl/list.do'"/>
	                               <input type="submit"  value="新增" onclick="getReferenceForm(this).action='${ctx}/pages/ylcs/TcpinfoYl/create.do?<mytag:params includes="ec*,s*" type="queryStringUtf"/>'"/>
			              </td>
		           </tr>
	    </table>
    </s:form>
</div>
			
</body>

</html>