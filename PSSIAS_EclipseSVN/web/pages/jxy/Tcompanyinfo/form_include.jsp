<%@page import="com.dyneinfo.jxy.model.*" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/commons/taglibs.jsp" %>

	<s:hidden id="cpcode" name="cpcode" />

<!-- ONGL access static field: @package.class@field or @vs@field -->

		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <FONT color="red">*</FONT><%=Tcompanyinfo.ALIAS_CPNAME%>
		                  </td>
			              <td>
		                           <s:textfield label="%{@vs@ALIAS_CPNAME}" key="cpname" value="%{model.cpname}"  cssClass="required max-length-40" required="false" />
		                           
		                  </td>
                          <td class="crosscolor_td">
			                     <FONT color="red">*</FONT> <%=Tcompanyinfo.ALIAS_CPADDRESS%>
		                  </td>
			              <td>
		                           <s:textfield label="%{@vs@ALIAS_CPADDRESS}" key="cpaddress" value="%{model.cpaddress}"  cssClass="required max-length-40" required="false" />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <FONT color="red">*</FONT><%=Tcompanyinfo.ALIAS_PHONE%>
		                  </td>
			              <td>
		                           <s:textfield label="%{@vs@ALIAS_PHONE}" key="phone" value="%{model.phone}"  cssClass="required validate-phone" required="false" />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=Tcompanyinfo.ALIAS_FAX%>
		                  </td>
			              <td>
		                           <s:textfield label="%{@vs@ALIAS_FAX}" key="fax" value="%{model.fax}"  cssClass="max-length-20" required="false" />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=Tcompanyinfo.ALIAS_POSTALCODE%>
		                  </td>
			              <td>
		                           <s:textfield label="%{@vs@ALIAS_POSTALCODE}" key="postalcode" value="%{model.postalcode}"  cssClass="max-length-6" required="false" />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=Tcompanyinfo.ALIAS_STARTDATE%>
		                  </td>
			              <td>
			              <input value="${model.startdate}" onclick="WdatePicker()"  name="startdate"  class="required Wdate" />
		                           
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=Tcompanyinfo.ALIAS_ECONOMY%>
		                  </td>
			              <td>
		                           
		                           <mytag:select  name="economy" value="${pageRequest.filters.economy}"   notEmpty="false"  dictName="T_DIC_CPKIND"/>
		                  </td>
                          <td class="crosscolor_td">
			                      <%=Tcompanyinfo.ALIAS_CORPCODE%>
		                  </td>
			              <td>
		                           <s:textfield label="%{@vs@ALIAS_CORPCODE}" key="corpcode" value="%{model.corpcode}"  cssClass="max-length-9" required="false" />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <FONT color="red">*</FONT><%=Tcompanyinfo.ALIAS_CORPNAME%>
		                  </td>
			              <td>
		                           <s:textfield label="%{@vs@ALIAS_CORPNAME}" key="corpname" value="%{model.corpname}"  cssClass="required max-length-30" required="false" />
		                  </td>
                          <td class="crosscolor_td">
			                      <FONT color="red">*</FONT><%=Tcompanyinfo.ALIAS_POLICENAME%>
		                  </td>
			              <td>
		                           <s:textfield label="%{@vs@ALIAS_POLICENAME}" key="policename" value="%{model.policename}"  cssClass="required max-length-30" required="false" />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=Tcompanyinfo.ALIAS_POLICEPHONE%>
		                  </td>
			              <td>
		                           <s:textfield label="%{@vs@ALIAS_POLICEPHONE}" key="policephone" value="%{model.policephone}"  cssClass="max-length-20" required="false" />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=Tcompanyinfo.ALIAS_WORKAREA%>
		                  </td>
			              <td>
		                           <s:textfield label="%{@vs@ALIAS_WORKAREA}" key="workarea" value="%{model.workarea}"  cssClass="max-length-160" required="false" />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=Tcompanyinfo.ALIAS_ENROLCAPITAL%>
		                  </td>
			              <td>
		                           <s:textfield label="%{@vs@ALIAS_ENROLCAPITAL}" key="enrolcapital" value="%{model.enrolcapital}"  cssClass="validate-integer " required="false" />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=Tcompanyinfo.ALIAS_ACREAGE%>
		                  </td>
			              <td>
		                           <s:textfield label="%{@vs@ALIAS_ACREAGE}" key="acreage" value="%{model.acreage}"  cssClass="validate-integer " required="false" />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <FONT color="red">*</FONT><%=Tcompanyinfo.ALIAS_POLICEUNIT%>
		                  </td>
			              <td>
		                           
		                            <mytag:select property="%{model.policeunit}"   styleClass="required validate-selection"  name="policeunit"   notEmpty="false"  dictName="ssfj"/>
		                  </td>
                          <td class="crosscolor_td">
			                      <%=Tcompanyinfo.ALIAS_SCBACKUPNO%>
		                  </td>
			              <td>
		                           <s:textfield label="%{@vs@ALIAS_SCBACKUPNO}" key="scbackupno" value="%{model.scbackupno}"  cssClass=" max-length-20" required="false" />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <FONT color="red">*</FONT><%=Tcompanyinfo.ALIAS_SCBACKUPUNIT%>
		                  </td>
			              <td>
		                           
		                  			<mytag:select property="%{model.scbackupunit}"   styleClass="required validate-selection"  name="scbackupunit"   notEmpty="false"  dictName="ssfj"/>
		                  </td>
                          <td class="crosscolor_td">
			                      <%=Tcompanyinfo.ALIAS_LICENCE%>
		                  </td>
			              <td>
		                           <s:textfield label="%{@vs@ALIAS_LICENCE}" key="licence" value="%{model.licence}"  cssClass=" max-length-20" required="false" />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=Tcompanyinfo.ALIAS_LICENCEUNIT%>
		                  </td>
			              <td>
		                           <s:textfield label="%{@vs@ALIAS_LICENCEUNIT}" key="licenceunit" value="%{model.licenceunit}"  cssClass=" max-length-40" required="false" />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=Tcompanyinfo.ALIAS_BCRETCODE%>
		                  </td>
			              <td>
		                           <s:textfield label="%{@vs@ALIAS_BCRETCODE}" key="bcretcode" value="%{model.bcretcode}"  cssClass=" max-length-20" required="false" />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=Tcompanyinfo.ALIAS_BCRETUNIT%>
		                  </td>
			              <td>
		                           <s:textfield label="%{@vs@ALIAS_BCRETUNIT}" key="bcretunit" value="%{model.bcretunit}"  cssClass=" max-length-40" required="false" />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=Tcompanyinfo.ALIAS_TAXCODE%>
		                  </td>
			              <td>
		                           <s:textfield label="%{@vs@ALIAS_TAXCODE}" key="taxcode" value="%{model.taxcode}"  cssClass=" max-length-20" required="false" />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=Tcompanyinfo.ALIAS_TAXUNIT%>
		                  </td>
			              <td>
		                           <s:textfield label="%{@vs@ALIAS_TAXUNIT}" key="taxunit" value="%{model.taxunit}"  cssClass=" max-length-40" required="false" />
		                  </td>
		                  <td class="crosscolor_td">
			                      <FONT color="red">*</FONT><%=Tcompanyinfo.ALIAS_STATION%>
		                  </td>
			              <td>
		                          
		                           <mytag:select property="%{model.station}"   styleClass="required validate-selection"  name="station"   notEmpty="false"  dictName="sspcs"/>
		                  </td>
                        
                   </tr>
                 
		                  
		                  

		          
		         
 
 
