<%@page import="com.dyneinfo.gas.model.*" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/commons/taglibs.jsp" %>

	<s:hidden id="empcode" name="empcode" />
<s:hidden id="pPhotoBuffer" name="pPhotoBuffer" />
<!-- ONGL access static field: @package.class@field or @vs@field -->

		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=Temployee.ALIAS_EMPNAME%><FONT color="red">*</FONT>
		                  </td>
			              <td>
		                           <s:textfield label="%{@vs@ALIAS_EMPNAME}" key="empname" value="%{model.empname}"  cssClass="required max-length-30" required="false" />
		                  </td>
		                  <td class="crosscolor_td">
			                      <%=Temployee.ALIAS_PERSONID%><FONT color="red">*</FONT>
		                  </td>
			              <td>
		                           <s:textfield label="%{@vs@ALIAS_PERSONID}" key="personid" value="%{model.personid}" onblur="javascript:showBirthday();"  cssClass="required validate-id-number" required="false" />
		                  </td>
                         
		                   <td width="5%" rowspan="13" id="clxxDevice" >
		                  	<IFRAME height="200" width="240" name="result"   src="${ctx}/pages/gas/Temployee/CVR_IDCard.html"
								align="center" frameBorder="0" marginHeight="0" marginWidth="0"></IFRAME>
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=Temployee.ALIAS_SEX%><FONT color="red">*</FONT>
		                  </td>
			              <td>
			              		 <mytag:select property="%{model.sex}"    name="sex"   notEmpty="false" styleClass="required validate-selection select" dictName="T_DIC_SEX"/>
		                  </td>
                          <td class="crosscolor_td">
			                      <%=Temployee.ALIAS_BIRTH%><FONT color="red">*</FONT>
		                  </td>
			              <td>
		                           <input value="${model.birth}" onclick="WdatePicker({dateFmt:'yyyy-MM-dd'})" id="birth" name="birth"  maxlength="0" class="required Wdate" />
		                           
		                  </td>
                   </tr>
                   
                    <tr class="crosscolor_tr">
		           		<td class="crosscolor_td">
			                      <%=Temployee.ALIAS_FOLK%><FONT color="red">*</FONT>
		                  </td>
			              <td>
			              		 <mytag:select property="%{model.folk}"    name="folk"   notEmpty="false" styleClass="required validate-selection select " dictName="T_DIC_NATION"/>
			              		 
		                  </td>
		            	<td class="crosscolor_td">
			                      <%=Temployee.ALIAS_ALIAS%>
		                  </td>
			              <td>
		                           <s:textfield label="%{@vs@ALIAS_ALIAS}" key="alias" value="%{model.alias}"  cssClass="max-length-30" required="false" />
		                  </td>
		            </tr>
		           <tr class="crosscolor_tr">
		           		  <td class="crosscolor_td">
			                      <%=Temployee.ALIAS_NPCODE%><FONT color="red">*</FONT>
		                  </td>
			              <td>
			              	 <mytag:select property="%{model.npcode}"    name="npcode"   notEmpty="false" styleClass="required validate-selection select" dictName="T_DIC_XZQH"/>
		                  </td>
                          <td class="crosscolor_td">
			                      <%=Temployee.ALIAS_NPADDRESS%><FONT color="red">*</FONT>
		                  </td>
			              <td>
		                           <s:textfield label="%{@vs@ALIAS_NPADDRESS}" key="npaddress" value="%{model.npaddress}"  cssClass=" required max-length-200" required="false" />
		                  </td>
		                  
		             </tr>
		                <tr class="crosscolor_tr">
                          
                          <td class="crosscolor_td">
			                      <%=Temployee.ALIAS_NATIVEPLACE%>
		                  </td>
			              <td>
			              		 <mytag:select property="%{model.nativeplace}"    name="nativeplace"   notEmpty="false" styleClass="validate-selection select" dictName="T_DIC_XZQH"/>
		                  </td>
		                   <td class="crosscolor_td">
			                      <%=Temployee.ALIAS_ADDRESS%>
		                  </td>
			              <td>
		                           <s:textfield label="%{@vs@ALIAS_ADDRESS}" key="address" value="%{model.address}"  cssClass="max-length-200" required="false" />
		                  </td>
                   </tr>
                    <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=Temployee.ALIAS_TEMPORARYCODE%>
		                  </td>
			              <td>
		                           <s:textfield label="%{@vs@ALIAS_TEMPORARYCODE}" key="temporarycode" value="%{model.temporarycode}"  cssClass="max-length-16" required="false" />
		                  </td>
		                  <td class="crosscolor_td">
			                      <%=Temployee.ALIAS_NOWADRESS%><FONT color="red">*</FONT>
		                  </td>
			              <td>
		                           <s:textfield label="%{@vs@ALIAS_NOWADRESS}" key="nowadress" value="%{model.nowadress}"  cssClass="required max-length-200" required="false" />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
		          		 <td class="crosscolor_td">
			                      <%=Temployee.ALIAS_HYZH%>
		                  </td>
			              <td>
			              		 <mytag:select property="%{model.hyzh}"    name="hyzh"   notEmpty="false" styleClass=" validate-selection select " dictName="T_DIC_HYZK"/>
		                  </td>
                          <td class="crosscolor_td">
			                      <%=Temployee.ALIAS_POLITYVISAGE%>
		                  </td>
			              <td>
			              		 <mytag:select property="%{model.polityvisage}"    name="polityvisage"   notEmpty="false" styleClass="validate-selection select" dictName="partyvisage"/>
		                  </td>
		            </tr>
		            <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=Temployee.ALIAS_SCHOOLAGE%>
		                  </td>
			              <td>
			              		 <mytag:select property="%{model.schoolage}"    name="schoolage"   notEmpty="false" styleClass="validate-selection select " dictName="educations"/>
		                  </td>
                          <td class="crosscolor_td">
			                      <%=Temployee.ALIAS_PHONE%>
		                  </td>
			              <td>
		                           <s:textfield label="%{@vs@ALIAS_PHONE}" key="phone" value="%{model.phone}"  cssClass="validate-mobile-phone max-length-20 " required="false" />
		                  </td>
                   </tr>
                     <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=Temployee.ALIAS_POSTURE%>
		                  </td>
			              <td>
			              		 <mytag:select property="%{model.posture}"    name="posture"   notEmpty="false" styleClass="validate-selection select" dictName="T_DIC_SHAPE"/>
		                  </td>
                          
                          <td class="crosscolor_td">
			                      <%=Temployee.ALIAS_WEIGHT%>
		                  </td>
			              <td>
		                           <s:textfield label="%{@vs@ALIAS_WEIGHT}" key="weight" value="%{model.weight}"  cssClass="max-length-3" required="false" />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
		                <td class="crosscolor_td">
			                      <%=Temployee.ALIAS_STATURE%>
		                  </td>
			              <td>
		                           <s:textfield label="%{@vs@ALIAS_STATURE}" key="stature" value="%{model.stature}"  cssClass="max-length-3" required="false" />
		                  </td>
		                   <td class="crosscolor_td">
			                      <%=Temployee.ALIAS_CYRJZT%><FONT color="red">*</FONT>
		                  </td>
			              <td>
			              			 <mytag:select property="%{model.cyrjzt}"    name="cyrjzt"   notEmpty="false" styleClass="required validate-selection select" dictName="cyryFlag"/>
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=Temployee.ALIAS_INDATE%><FONT color="red">*</FONT>
		                  </td>
			              <td>
			             	 <input value="${model.indate}" onclick="WdatePicker({dateFmt:'yyyy-MM-dd'})" id="indate" name="indate"  maxlength="0" class="required Wdate" />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=Temployee.ALIAS_LEFTDATE%>
		                  </td>
			              <td>
			             		 <input value="${model.leftdate}" onclick="WdatePicker({dateFmt:'yyyy-MM-dd'})" id="leftdate" name="leftdate"  maxlength="0" class="Wdate" />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=Temployee.ALIAS_EMPDUTY%><FONT color="red">*</FONT>
		                  </td>
			              <td>
			              	 <mytag:select property="%{model.empduty}"    name="empduty"   notEmpty="false" styleClass="required validate-selection select" dictName="T_DIC_EMPTYPE"/>
		                  </td>
                          <td class="crosscolor_td">
			                      <%=Temployee.ALIAS_INSERTTIME%><FONT color="red">*</FONT>
		                  </td>
			              <td>
		                       <input value="${model.inserttime}" Disabled ="true" onclick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss'})" id="inserttime1" name="inserttime1"  maxlength="0" class=" required Wdate" />
		                       <input value="${model.inserttime}"  type="hidden" id="inserttime" name="inserttime"  />
		                  </td>
                   </tr>
 
 
