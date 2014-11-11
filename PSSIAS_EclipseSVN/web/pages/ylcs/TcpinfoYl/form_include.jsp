<%@page import="com.dyneinfo.ylcs.model.*" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/commons/taglibs.jsp" %>

	<s:hidden id="locode" name="locode" />

<!-- ONGL access static field: @package.class@field or @vs@field -->

		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=TcpinfoYl.ALIAS_STATION%>
		                  </td>
			              <td>
		                           <s:textfield label="%{@vs@ALIAS_STATION}" key="station" value="%{model.station}"  cssClass="max-length-12" required="false" />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=TcpinfoYl.ALIAS_STARTDATE%>
		                  </td>
			              <td>
		                           <input value="${model.startdateString}" onclick="WdatePicker({dateFmt:'<%=TcpinfoYl.FORMAT_STARTDATE%>'})" id="startdateString" name="startdateString"  maxlength="0" class="Wdate" />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=TcpinfoYl.ALIAS_ACREAGE%>
		                  </td>
			              <td>
		                           <s:textfield label="%{@vs@ALIAS_ACREAGE}" key="acreage" value="%{model.acreage}"  cssClass="validate-integer " required="false" />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=TcpinfoYl.ALIAS_ENROLCAPITAL%>
		                  </td>
			              <td>
		                           <s:textfield label="%{@vs@ALIAS_ENROLCAPITAL}" key="enrolcapital" value="%{model.enrolcapital}"  cssClass="validate-number " required="false" />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=TcpinfoYl.ALIAS_CPNAME%>
		                  </td>
			              <td>
		                           <s:textfield label="%{@vs@ALIAS_CPNAME}" key="cpname" value="%{model.cpname}"  cssClass="max-length-40" required="false" />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=TcpinfoYl.ALIAS_CPADDRESS%>
		                  </td>
			              <td>
		                           <s:textfield label="%{@vs@ALIAS_CPADDRESS}" key="cpaddress" value="%{model.cpaddress}"  cssClass="max-length-100" required="false" />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=TcpinfoYl.ALIAS_PHONE%>
		                  </td>
			              <td>
		                           <s:textfield label="%{@vs@ALIAS_PHONE}" key="phone" value="%{model.phone}"  cssClass="max-length-20" required="false" />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=TcpinfoYl.ALIAS_FAX%>
		                  </td>
			              <td>
		                           <s:textfield label="%{@vs@ALIAS_FAX}" key="fax" value="%{model.fax}"  cssClass="max-length-20" required="false" />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=TcpinfoYl.ALIAS_POSTALCODE%>
		                  </td>
			              <td>
		                           <s:textfield label="%{@vs@ALIAS_POSTALCODE}" key="postalcode" value="%{model.postalcode}"  cssClass="max-length-6" required="false" />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=TcpinfoYl.ALIAS_ECONOMY%>
		                  </td>
			              <td>
		                           <s:textfield label="%{@vs@ALIAS_ECONOMY}" key="economy" value="%{model.economy}"  cssClass="max-length-3" required="false" />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=TcpinfoYl.ALIAS_CORPCODE%>
		                  </td>
			              <td>
		                           <s:textfield label="%{@vs@ALIAS_CORPCODE}" key="corpcode" value="%{model.corpcode}"  cssClass="max-length-9" required="false" />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=TcpinfoYl.ALIAS_CORPNAME%>
		                  </td>
			              <td>
		                           <s:textfield label="%{@vs@ALIAS_CORPNAME}" key="corpname" value="%{model.corpname}"  cssClass="max-length-30" required="false" />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=TcpinfoYl.ALIAS_POLICENAME%>
		                  </td>
			              <td>
		                           <s:textfield label="%{@vs@ALIAS_POLICENAME}" key="policename" value="%{model.policename}"  cssClass="max-length-30" required="false" />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=TcpinfoYl.ALIAS_POLICEPHONE%>
		                  </td>
			              <td>
		                           <s:textfield label="%{@vs@ALIAS_POLICEPHONE}" key="policephone" value="%{model.policephone}"  cssClass="max-length-20" required="false" />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=TcpinfoYl.ALIAS_WORKAREA%>
		                  </td>
			              <td>
		                           <s:textfield label="%{@vs@ALIAS_WORKAREA}" key="workarea" value="%{model.workarea}"  cssClass="max-length-160" required="false" />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=TcpinfoYl.ALIAS_POLICEUNIT%>
		                  </td>
			              <td>
		                           <s:textfield label="%{@vs@ALIAS_POLICEUNIT}" key="policeunit" value="%{model.policeunit}"  cssClass="max-length-12" required="false" />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=TcpinfoYl.ALIAS_SCBACKUPNO%>
		                  </td>
			              <td>
		                           <s:textfield label="%{@vs@ALIAS_SCBACKUPNO}" key="scbackupno" value="%{model.scbackupno}"  cssClass="max-length-20" required="false" />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=TcpinfoYl.ALIAS_SCBACKUPUNIT%>
		                  </td>
			              <td>
		                           <s:textfield label="%{@vs@ALIAS_SCBACKUPUNIT}" key="scbackupunit" value="%{model.scbackupunit}"  cssClass="max-length-12" required="false" />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=TcpinfoYl.ALIAS_LICENCE%>
		                  </td>
			              <td>
		                           <s:textfield label="%{@vs@ALIAS_LICENCE}" key="licence" value="%{model.licence}"  cssClass="max-length-20" required="false" />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=TcpinfoYl.ALIAS_LICENCEUNIT%>
		                  </td>
			              <td>
		                           <s:textfield label="%{@vs@ALIAS_LICENCEUNIT}" key="licenceunit" value="%{model.licenceunit}"  cssClass="max-length-40" required="false" />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=TcpinfoYl.ALIAS_BCRETCODE%>
		                  </td>
			              <td>
		                           <s:textfield label="%{@vs@ALIAS_BCRETCODE}" key="bcretcode" value="%{model.bcretcode}"  cssClass="max-length-20" required="false" />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=TcpinfoYl.ALIAS_BCRETUNIT%>
		                  </td>
			              <td>
		                           <s:textfield label="%{@vs@ALIAS_BCRETUNIT}" key="bcretunit" value="%{model.bcretunit}"  cssClass="max-length-40" required="false" />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=TcpinfoYl.ALIAS_TAXCODE%>
		                  </td>
			              <td>
		                           <s:textfield label="%{@vs@ALIAS_TAXCODE}" key="taxcode" value="%{model.taxcode}"  cssClass="max-length-20" required="false" />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=TcpinfoYl.ALIAS_TAXUNIT%>
		                  </td>
			              <td>
		                           <s:textfield label="%{@vs@ALIAS_TAXUNIT}" key="taxunit" value="%{model.taxunit}"  cssClass="max-length-40" required="false" />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=TcpinfoYl.ALIAS_THCODE%>
		                  </td>
			              <td>
		                           <s:textfield label="%{@vs@ALIAS_THCODE}" key="thcode" value="%{model.thcode}"  cssClass="max-length-3" required="false" />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=TcpinfoYl.ALIAS_FJCODE%>
		                  </td>
			              <td>
		                           <s:textfield label="%{@vs@ALIAS_FJCODE}" key="fjcode" value="%{model.fjcode}"  cssClass="max-length-12" required="false" />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=TcpinfoYl.ALIAS_WORKAREASEC%>
		                  </td>
			              <td>
		                           <s:textfield label="%{@vs@ALIAS_WORKAREASEC}" key="workareasec" value="%{model.workareasec}"  cssClass="max-length-160" required="false" />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=TcpinfoYl.ALIAS_STOPDATE%>
		                  </td>
			              <td>
		                           <input value="${model.stopdateString}" onclick="WdatePicker({dateFmt:'<%=TcpinfoYl.FORMAT_STOPDATE%>'})" id="stopdateString" name="stopdateString"  maxlength="0" class="Wdate" />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=TcpinfoYl.ALIAS_HIS%>
		                  </td>
			              <td>
		                           <s:textfield label="%{@vs@ALIAS_HIS}" key="his" value="%{model.his}"  cssClass="max-length-1" required="false" />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=TcpinfoYl.ALIAS_JWDZB%>
		                  </td>
			              <td>
		                           <s:textfield label="%{@vs@ALIAS_JWDZB}" key="jwdzb" value="%{model.jwdzb}"  cssClass="max-length-40" required="false" />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=TcpinfoYl.ALIAS_GDXX%>
		                  </td>
			              <td>
		                           <s:textfield label="%{@vs@ALIAS_GDXX}" key="gdxx" value="%{model.gdxx}"  cssClass="max-length-100" required="false" />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=TcpinfoYl.ALIAS_XFZSL%>
		                  </td>
			              <td>
		                           <s:textfield label="%{@vs@ALIAS_XFZSL}" key="xfzsl" value="%{model.xfzsl}"  cssClass="validate-integer max-value-2147483647" required="false" />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=TcpinfoYl.ALIAS_BXSL%>
		                  </td>
			              <td>
		                           <s:textfield label="%{@vs@ALIAS_BXSL}" key="bxsl" value="%{model.bxsl}"  cssClass="validate-integer max-value-2147483647" required="false" />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=TcpinfoYl.ALIAS_ZAJB%>
		                  </td>
			              <td>
		                           <s:textfield label="%{@vs@ALIAS_ZAJB}" key="zajb" value="%{model.zajb}"  cssClass="max-length-1" required="false" />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=TcpinfoYl.ALIAS_CSXJ%>
		                  </td>
			              <td>
		                           <s:textfield label="%{@vs@ALIAS_CSXJ}" key="csxj" value="%{model.csxj}"  cssClass="max-length-1" required="false" />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=TcpinfoYl.ALIAS_STATE%>
		                  </td>
			              <td>
		                           <s:textfield label="%{@vs@ALIAS_STATE}" key="state" value="%{model.state}"  cssClass="max-length-1" required="false" />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=TcpinfoYl.ALIAS_POLICELEVELCODE%>
		                  </td>
			              <td>
		                           <s:textfield label="%{@vs@ALIAS_POLICELEVELCODE}" key="policelevelcode" value="%{model.policelevelcode}"  cssClass="max-length-1" required="false" />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=TcpinfoYl.ALIAS_FLAGPACK%>
		                  </td>
			              <td>
		                           <s:textfield label="%{@vs@ALIAS_FLAGPACK}" key="flagpack" value="%{model.flagpack}"  cssClass="max-length-1" required="false" />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=TcpinfoYl.ALIAS_AUTHORIZATIONCODE%>
		                  </td>
			              <td>
		                           <s:textfield label="%{@vs@ALIAS_AUTHORIZATIONCODE}" key="authorizationcode" value="%{model.authorizationcode}"  cssClass="max-length-30" required="false" />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=TcpinfoYl.ALIAS_SPJRURL%>
		                  </td>
			              <td>
		                           <s:textfield label="%{@vs@ALIAS_SPJRURL}" key="spjrurl" value="%{model.spjrurl}"  cssClass="max-length-50" required="false" />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=TcpinfoYl.ALIAS_CURRENTSCORE%>
		                  </td>
			              <td>
		                           <s:textfield label="%{@vs@ALIAS_CURRENTSCORE}" key="currentscore" value="%{model.currentscore}"  cssClass="validate-number " required="false" />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=TcpinfoYl.ALIAS_JCJB%>
		                  </td>
			              <td>
		                           <s:textfield label="%{@vs@ALIAS_JCJB}" key="jcjb" value="%{model.jcjb}"  cssClass="max-length-1" required="false" />
		                  </td>
                   </tr>
 
 
