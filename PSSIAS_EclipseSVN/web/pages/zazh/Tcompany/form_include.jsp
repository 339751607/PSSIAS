<%@page import="com.dyneinfo.zazh.model.*" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/commons/taglibs.jsp" %>

	<s:hidden id="cpcode" name="cpcode" />

<!-- ONGL access static field: @package.class@field or @vs@field -->

		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=Tcompany.ALIAS_POLICEUNIT%>
		                  </td>
			              <td>
		                           <s:textfield label="%{@vs@ALIAS_POLICEUNIT}" key="policeunit" value="%{model.policeunit}"  cssClass="max-length-12" required="false" />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=Tcompany.ALIAS_SCBACKUPUNIT%>
		                  </td>
			              <td>
		                           <s:textfield label="%{@vs@ALIAS_SCBACKUPUNIT}" key="scbackupunit" value="%{model.scbackupunit}"  cssClass="max-length-12" required="false" />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=Tcompany.ALIAS_CPNAME%>
		                  </td>
			              <td>
		                           <s:textfield label="%{@vs@ALIAS_CPNAME}" key="cpname" value="%{model.cpname}"  cssClass="max-length-40" required="false" />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=Tcompany.ALIAS_CPADDRESS%>
		                  </td>
			              <td>
		                           <s:textfield label="%{@vs@ALIAS_CPADDRESS}" key="cpaddress" value="%{model.cpaddress}"  cssClass="max-length-40" required="false" />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=Tcompany.ALIAS_PHONE%>
		                  </td>
			              <td>
		                           <s:textfield label="%{@vs@ALIAS_PHONE}" key="phone" value="%{model.phone}"  cssClass="max-length-20" required="false" />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=Tcompany.ALIAS_FAX%>
		                  </td>
			              <td>
		                           <s:textfield label="%{@vs@ALIAS_FAX}" key="fax" value="%{model.fax}"  cssClass="max-length-20" required="false" />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=Tcompany.ALIAS_POSTALCODE%>
		                  </td>
			              <td>
		                           <s:textfield label="%{@vs@ALIAS_POSTALCODE}" key="postalcode" value="%{model.postalcode}"  cssClass="max-length-6" required="false" />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=Tcompany.ALIAS_STARTDATE%>
		                  </td>
			              <td>
		                           <s:textfield label="%{@vs@ALIAS_STARTDATE}" key="startdate" value="%{model.startdate}"  cssClass="max-length-8" required="false" />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=Tcompany.ALIAS_ECONOMY%>
		                  </td>
			              <td>
		                           <s:textfield label="%{@vs@ALIAS_ECONOMY}" key="economy" value="%{model.economy}"  cssClass="max-length-3" required="false" />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=Tcompany.ALIAS_CORPCODE%>
		                  </td>
			              <td>
		                           <s:textfield label="%{@vs@ALIAS_CORPCODE}" key="corpcode" value="%{model.corpcode}"  cssClass="max-length-9" required="false" />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=Tcompany.ALIAS_CORPNAME%>
		                  </td>
			              <td>
		                           <s:textfield label="%{@vs@ALIAS_CORPNAME}" key="corpname" value="%{model.corpname}"  cssClass="max-length-30" required="false" />
		                  </td>
                          <td class="crosscolor_td">
			                     
		                  </td>
			              <td>
		                         
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=Tcompany.ALIAS_POLICENAME%>
		                  </td>
			              <td>
		                           <s:textfield label="%{@vs@ALIAS_POLICENAME}" key="policename" value="%{model.policename}"  cssClass="max-length-30" required="false" />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=Tcompany.ALIAS_POLICEPHONE%>
		                  </td>
			              <td>
		                           <s:textfield label="%{@vs@ALIAS_POLICEPHONE}" key="policephone" value="%{model.policephone}"  cssClass="max-length-20" required="false" />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=Tcompany.ALIAS_WORKAREA%>
		                  </td>
			              <td>
		                           <s:textfield label="%{@vs@ALIAS_WORKAREA}" key="workarea" value="%{model.workarea}"  cssClass="max-length-160" required="false" />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=Tcompany.ALIAS_ENROLCAPITAL%>
		                  </td>
			              <td>
		                           <s:textfield label="%{@vs@ALIAS_ENROLCAPITAL}" key="enrolcapital" value="%{model.enrolcapital}"  cssClass="validate-integer " required="false" />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=Tcompany.ALIAS_ACREAGE%>
		                  </td>
			              <td>
		                           <s:textfield label="%{@vs@ALIAS_ACREAGE}" key="acreage" value="%{model.acreage}"  cssClass="validate-integer " required="false" />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=Tcompany.ALIAS_SCBACKUPNO%>
		                  </td>
			              <td>
		                           <s:textfield label="%{@vs@ALIAS_SCBACKUPNO}" key="scbackupno" value="%{model.scbackupno}"  cssClass="max-length-20" required="false" />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=Tcompany.ALIAS_LICENCE%>
		                  </td>
			              <td>
		                           <s:textfield label="%{@vs@ALIAS_LICENCE}" key="licence" value="%{model.licence}"  cssClass="max-length-20" required="false" />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=Tcompany.ALIAS_LICENCEUNIT%>
		                  </td>
			              <td>
		                           <s:textfield label="%{@vs@ALIAS_LICENCEUNIT}" key="licenceunit" value="%{model.licenceunit}"  cssClass="max-length-40" required="false" />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=Tcompany.ALIAS_BCRETCODE%>
		                  </td>
			              <td>
		                           <s:textfield label="%{@vs@ALIAS_BCRETCODE}" key="bcretcode" value="%{model.bcretcode}"  cssClass="max-length-20" required="false" />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=Tcompany.ALIAS_BCRETUNIT%>
		                  </td>
			              <td>
		                           <s:textfield label="%{@vs@ALIAS_BCRETUNIT}" key="bcretunit" value="%{model.bcretunit}"  cssClass="max-length-40" required="false" />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=Tcompany.ALIAS_TAXCODE%>
		                  </td>
			              <td>
		                           <s:textfield label="%{@vs@ALIAS_TAXCODE}" key="taxcode" value="%{model.taxcode}"  cssClass="max-length-20" required="false" />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=Tcompany.ALIAS_TAXUNIT%>
		                  </td>
			              <td>
		                           <s:textfield label="%{@vs@ALIAS_TAXUNIT}" key="taxunit" value="%{model.taxunit}"  cssClass="max-length-40" required="false" />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=Tcompany.ALIAS_STATUS%>
		                  </td>
			              <td>
		                           <s:textfield label="%{@vs@ALIAS_STATUS}" key="status" value="%{model.status}"  cssClass="max-length-2" required="false" />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=Tcompany.ALIAS_MODDATE%>
		                  </td>
			              <td>
		                           <s:textfield label="%{@vs@ALIAS_MODDATE}" key="moddate" value="%{model.moddate}"  cssClass="max-length-8" required="false" />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=Tcompany.ALIAS_BURCODE%>
		                  </td>
			              <td>
		                           <s:textfield label="%{@vs@ALIAS_BURCODE}" key="burcode" value="%{model.burcode}"  cssClass="max-length-12" required="false" />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=Tcompany.ALIAS_STACODE%>
		                  </td>
			              <td>
		                           <s:textfield label="%{@vs@ALIAS_STACODE}" key="stacode" value="%{model.stacode}"  cssClass="max-length-12" required="false" />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=Tcompany.ALIAS_BASJ%>
		                  </td>
			              <td>
		                           <s:textfield label="%{@vs@ALIAS_BASJ}" key="basj" value="%{model.basj}"  cssClass="max-length-8" required="false" />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=Tcompany.ALIAS_BUSINESSCODE%>
		                  </td>
			              <td>
		                           <s:textfield label="%{@vs@ALIAS_BUSINESSCODE}" key="businesscode" value="%{model.businesscode}"  cssClass="max-length-3" required="false" />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=Tcompany.ALIAS_EXITEND2%>
		                  </td>
			              <td>
		                           <s:textfield label="%{@vs@ALIAS_EXITEND2}" key="exitend2" value="%{model.exitend2}"  cssClass="max-length-100" required="false" />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=Tcompany.ALIAS_EXITEND3%>
		                  </td>
			              <td>
		                           <s:textfield label="%{@vs@ALIAS_EXITEND3}" key="exitend3" value="%{model.exitend3}"  cssClass="max-length-100" required="false" />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=Tcompany.ALIAS_EXITEND1%>
		                  </td>
			              <td>
		                           <s:textfield label="%{@vs@ALIAS_EXITEND1}" key="exitend1" value="%{model.exitend1}"  cssClass="max-length-100" required="false" />
		                  </td>
                          <td>&nbsp;</td>
                          <td>&nbsp;</td>
                   </tr>
 
 
