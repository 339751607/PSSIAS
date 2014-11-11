<%@page import="com.dyneinfo.jxy.model.*" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/commons/taglibs.jsp" %>

	<s:hidden id="cpcode" name="cpcode" />

<!-- ONGL access static field: @package.class@field or @vs@field -->

		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <font color="red">*</font><%=Tcpinfo.ALIAS_CPNAME%>
		                  </td>
			              <td colspan="3">
		                           <s:textfield label="%{@vs@ALIAS_CPNAME}" key="cpname" size="70" value="%{model.cpname}"  cssClass="required max-length-80" required="false" />
		                   
		                  </td>
		            </tr>
		           <tr class="crosscolor_tr">       
                          <td class="crosscolor_td">
			                      <font color="red">*</font><%=Tcpinfo.ALIAS_CPADDRESS%>
		                  </td>
			              <td colspan="3">
		                           <s:textfield label="%{@vs@ALIAS_CPADDRESS}" key="cpaddress" size="70" value="%{model.cpaddress}"  cssClass="required max-length-80" required="false" />
		                  
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=Tcpinfo.ALIAS_WORKAREA%>
		                  </td>
			             <td colspan="3">
		                           <s:textfield label="%{@vs@ALIAS_WORKAREA}" key="workarea" size="70" value="%{model.workarea}"  cssClass="max-length-160" required="false" />
		                  </td>
                          
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <font color="red">*</font><%=Tcpinfo.ALIAS_PHONE%>
		                  </td>
			              <td>
		                           <s:textfield label="%{@vs@ALIAS_PHONE}" key="phone" value="%{model.phone}"  cssClass="required validate-mobile-or-phone" required="false" />
		                            
		                  </td>
                          <td class="crosscolor_td">
			                      <%=Tcpinfo.ALIAS_FAX%>
		                  </td>
			              <td>
		                           <s:textfield label="%{@vs@ALIAS_FAX}" key="fax" value="%{model.fax}"  cssClass="max-length-20" required="false" />
		                  </td>
                          
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td" >
			                      <%=Tcpinfo.ALIAS_ENROLCAPITAL%>
		                  </td>
			              <td style="float: left">
	                               <s:textfield label="%{@vs@ALIAS_ENROLCAPITAL}" key="enrolcapital" value="%{model.enrolcapital}"  cssClass="validate-integer  validate-number" required="false" />
		                            万元（人民币）
		                  </td>
                          <td class="crosscolor_td">
			                      <%=Tcpinfo.ALIAS_POSTALCODE%>
		                  </td>
			              <td>
	                               <s:textfield label="%{@vs@ALIAS_POSTALCODE}" key="postalcode" value="%{model.postalcode}"  cssClass="max-length-6 validate-zip" required="false" />
		                  </td>
                          
                   </tr>
		           <tr class="crosscolor_tr">
                         <td class="crosscolor_td">
			                      <font color="red">*</font><%=Tcpinfo.ALIAS_STARTDATE%>
		                  </td>
			              <td>
						           <input value="${model.startdate}" onclick="WdatePicker({dateFmt:'yyyy-MM-dd',maxDate:'${date}'})" id="startdate" name="startdate"  maxlength="0" class="required Wdate" />
		                             
		                  </td>
                          <td class="crosscolor_td">
			                      <%=Tcpinfo.ALIAS_ECONOMY%>
		                  </td>
			              <td>
						           <mytag:select property="%{model.economy}"   styleClass=" validate-selection"  name="economy"   notEmpty="false"  dictName="T_DIC_CPKIND"/>
		                  </td>
                          
                   </tr>
		           <tr class="crosscolor_tr">
                         <td class="crosscolor_td">
			                      <%=Tcpinfo.ALIAS_CORPCODE%>
		                  </td>
			              <td>
		                           <s:textfield label="%{@vs@ALIAS_CORPCODE}" key="corpcode" value="%{model.corpcode}"  cssClass="max-length-9" required="false" />
		                  </td>
                          <td class="crosscolor_td">
			                       <font color="red">*</font><%=Tcpinfo.ALIAS_CORPNAME%>
		                  </td>
			              <td>
		                           <s:textfield label="%{@vs@ALIAS_CORPNAME}" key="corpname" value="%{model.corpname}"  cssClass="required validate-chinese max-length-30" required="false" />
		                           
		                  </td>
                         
                   </tr>
		           <tr class="crosscolor_tr">
                           <td class="crosscolor_td">
			                      <%=Tcpinfo.ALIAS_POLICENAME%>
		                  </td>
			              <td>
		                           <s:textfield label="%{@vs@ALIAS_POLICENAME}" key="policename" value="%{model.policename}"  cssClass="validate-chinese max-length-12" required="false" />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=Tcpinfo.ALIAS_POLICEPHONE%>
		                  </td>
			              <td>
		                           <s:textfield label="%{@vs@ALIAS_POLICEPHONE}" key="policephone" value="%{model.policephone}"  cssClass="max-length-20" required="false" />
		                  </td>
                         
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=Tcpinfo.ALIAS_ACREAGE%>
		                  </td>
			              <td style="float: left">
	                               <s:textfield label="%{@vs@ALIAS_ACREAGE}" key="acreage" value="%{model.acreage}"  cssClass="validate-integer  validate-number" required="false" />
		                                                     平方米
		                  </td>
                          <td class="crosscolor_td">
			                      <font color="red">*</font><%=Tcpinfo.ALIAS_POLICEUNIT%>
		                  </td>
			              <td>
						           <mytag:select property="%{model.policeunit}"   styleClass="required validate-selection"  name="policeunit"   notEmpty="false"  dictName="ssfj"/>
		                             
		                  </td>
                         
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=Tcpinfo.ALIAS_SCBACKUPNO%>
		                  </td>
			              <td>
		                           <s:textfield label="%{@vs@ALIAS_SCBACKUPNO}" key="scbackupno" value="%{model.scbackupno}"  cssClass="max-length-20" required="false" />
		                  </td>
                          <td class="crosscolor_td">
			                      <font color="red">*</font><%=Tcpinfo.ALIAS_SCBACKUPUNIT%>
		                  </td>
			              <td>
						           <mytag:select property="%{model.scbackupunit}"   styleClass="required validate-selection"  name="scbackupunit"   notEmpty="false"  dictName="ssfj"/>
		                            
		                    </td>
                          
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=Tcpinfo.ALIAS_BASJ%>
		                  </td>
			              <td>
						           <input value="${model.basj}" onclick="WdatePicker({dateFmt:'yyyy-MM-dd',maxDate:'${date}'})" id="basj" name="basj"  maxlength="0" class=" Wdate" />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=Tcpinfo.ALIAS_LICENCEUNIT%>
		                  </td>
			              <td>
		                           <s:textfield label="%{@vs@ALIAS_LICENCEUNIT}" key="licenceunit" value="%{model.licenceunit}"  cssClass="max-length-40" required="false" />
		                  </td>
                         
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=Tcpinfo.ALIAS_BCRETCODE%>
		                  </td>
			              <td>
		                           <s:textfield label="%{@vs@ALIAS_BCRETCODE}" key="bcretcode" value="%{model.bcretcode}"  cssClass="max-length-20" required="false" />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=Tcpinfo.ALIAS_BCRETUNIT%>
		                  </td>
			              <td>
		                           <s:textfield label="%{@vs@ALIAS_BCRETUNIT}" key="bcretunit" value="%{model.bcretunit}"  cssClass="max-length-40" required="false" />
		                  </td>
                         
                   </tr>
		           <tr class="crosscolor_tr">
                           <td class="crosscolor_td">
			                      <%=Tcpinfo.ALIAS_TAXCODE%>
		                  </td>
			              <td>
		                           <s:textfield label="%{@vs@ALIAS_TAXCODE}" key="taxcode" value="%{model.taxcode}"  cssClass="max-length-20" required="false" />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=Tcpinfo.ALIAS_TAXUNIT%>
		                  </td>
			              <td>
		                           <s:textfield label="%{@vs@ALIAS_TAXUNIT}" key="taxunit" value="%{model.taxunit}"  cssClass="max-length-40" required="false" />
		                  </td>
                          
                   </tr>
		           <tr class="crosscolor_tr">
                         <td class="crosscolor_td">
			                      <%=Tcpinfo.ALIAS_LICENCE%>
		                  </td>
			              <td>
		                           <s:textfield label="%{@vs@ALIAS_LICENCE}" key="licence" value="%{model.licence}"  cssClass="max-length-20" required="false" />
		                  </td>
                          <td class="crosscolor_td">
			                      <font color="red">*</font><%=Tcpinfo.ALIAS_STATION%>
		                  </td>
			              <td>
			              
			               <s:textfield  key="stationName" id="stationName" maxlength="0" value="%{model.stationName}"  cssClass="required max-length-60" required="false" />
		                           
		                            <input name="selectDeptButton"  onclick="javascript:selectDept(form1,'stationName','station')"   value="选择" type="button" > 
		                          
		                           <s:hidden  id="station" key="station" value="%{model.station}"   required="false" />
		                   
		                   
		                  </td>
                   </tr>
 
 <script>
 function selectDept(frm,displayName,hiddenName) {
	           window.showModalDialog('${ctx}/pages/SsDept/selectDept.do?idValueIsSeq=false&formName=' + frm.name + '&inputName='+displayName+'&hiddenName='+hiddenName+'&rootID=false&maxPatiNum=1&hiddenType=ID_SPLIT',frm,'dialogHeight:500px;dialogWidth:560px;center:yes');
       }
</script>
