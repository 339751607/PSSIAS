<%@page import="com.dyneinfo.jxy.model.*" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/commons/taglibs.jsp" %>

	<s:hidden id="cpempcode" name="cpempcode" />

<!-- ONGL access static field: @package.class@field or @vs@field -->

		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <FONT color="red">*</FONT><%=Temployee.ALIAS_NAME%>
		                  </td>
			              <td>
	                               <s:textfield label="%{@vs@ALIAS_NAME}" key="name" value="%{model.name}"  cssClass="required max-length-30 validate-chinese" required="true" />
		                  </td>
                          <td class="crosscolor_td">
			                      <FONT color="red">*</FONT><%=Temployee.ALIAS_SEX%>
		                  </td>
			              <td>
						           <mytag:select property="%{model.sex}"   styleClass="required validate-selection"  name="sex"   notEmpty="false"  dictName="T_DIC_SEX"/>
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <FONT color="red">*</FONT><%=Temployee.ALIAS_PERSONID%>
		                  </td>
			              <td>
	                               <s:textfield label="%{@vs@ALIAS_PERSONID}" key="personid" value="%{model.personid}"  cssClass="required max-length-18 validate-id-number" required="true" />
		                  </td>
                          <td class="crosscolor_td">
			                      <FONT color="red">*</FONT><%=Temployee.ALIAS_BIRTH%>
		                  </td>
			              <td>
						           <input value="${model.birth}" onclick="WdatePicker({dateFmt:'yyyy-MM-dd'})" id="birth" name="birth"  maxlength="0" class="required Wdate" />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=Temployee.ALIAS_ALIAS%>
		                  </td>
			              <td>
		                           <s:textfield label="%{@vs@ALIAS_ALIAS}" key="alias" value="%{model.alias}"  cssClass="max-length-30" required="false" />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=Temployee.ALIAS_FOLK%>
		                  </td>
			              <td>
						           <mytag:select property="%{model.folk}"    name="folk"   notEmpty="false"  dictName="T_DIC_NATION"/>
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=Temployee.ALIAS_NATIVEPLACE%>
		                  </td>
			              <td>
						           <mytag:select property="%{model.nativeplace}"     name="nativeplace"   notEmpty="false"  dictName="T_DIC_XZQH"/>
		                  </td>
                          <td class="crosscolor_td">
			                      <%=Temployee.ALIAS_POLITYVISAGE%>
		                  </td>
			              <td>
						           <mytag:select property="%{model.polityvisage}"     name="polityvisage"   notEmpty="false"  dictName="T_DIC_POLITYVISAGE"/>
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=Temployee.ALIAS_SCHOOLAGE%>
		                  </td>
			              <td>
						           <mytag:select property="%{model.schoolage}"    name="schoolage"   notEmpty="false"  dictName="T_DIC_SCHOOLAGE"/>
		                  </td>
                          <td class="crosscolor_td">
			                     
		                  </td>
			              <td>
						           <mytag:select property="%{model.hyzh}"     name="hyzh"   notEmpty="false"  dictName="T_DIC_HYZK"/>
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=Temployee.ALIAS_STATURE%>
		                  </td>
			              <td>
	                               <s:textfield label="%{@vs@ALIAS_STATURE}" key="stature" value="%{model.stature}"  cssClass="max-length-3 validate-digits" required="false" />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=Temployee.ALIAS_WEIGHT%>
		                  </td>
			              <td>
	                               <s:textfield label="%{@vs@ALIAS_WEIGHT}" key="weight" value="%{model.weight}"  cssClass="max-length-3 validate-digits" required="false" />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=Temployee.ALIAS_POSTURE%>
		                  </td>
			              <td>
						           <mytag:select property="%{model.posture}"    name="posture"   notEmpty="false"  dictName="T_DIC_SHAPE"/>
		                  </td>
                          <td class="crosscolor_td">
			                    <FONT color="red">*</FONT>  <%=Temployee.ALIAS_NPCODE%>
		                  </td>
			              <td>
						           <mytag:select property="%{model.npcode}"   styleClass="required validate-selection"  name="npcode"   notEmpty="false"  dictName="T_DIC_XZQH"/>
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=Temployee.ALIAS_ADDRESS%>
		                  </td>
			              <td>
		                           <s:textfield label="%{@vs@ALIAS_ADDRESS}" key="address" value="%{model.address}"  cssClass="max-length-100" required="false" />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=Temployee.ALIAS_NPADDRESS%>
		                  </td>
			              <td>
		                           <s:textfield label="%{@vs@ALIAS_NPADDRESS}" key="npaddress" value="%{model.npaddress}"  cssClass="max-length-100" required="false" />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=Temployee.ALIAS_PHONE%>
		                  </td>
			              <td>
	                               <s:textfield label="%{@vs@ALIAS_PHONE}" key="phone" value="%{model.phone}"  cssClass="max-length-20 validate-number" required="false" />
		                  </td>
                          <td class="crosscolor_td">
			                      <FONT color="red">*</FONT><%=Temployee.ALIAS_CYRJZT%>
		                  </td>
			              <td>
						           <mytag:select property="%{model.cyrjzt}"   styleClass="required validate-selection"  name="cyrjzt"   notEmpty="false"  dictName="T_DIC_CYRJZT"/>
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
			                      <%=Temployee.ALIAS_NOWADRESS%>
		                  </td>
			              <td>
		                           <s:textfield label="%{@vs@ALIAS_NOWADRESS}" key="nowadress" value="%{model.nowadress}"  cssClass="max-length-100" required="false" />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <FONT color="red">*</FONT><%=Temployee.ALIAS_INSERTTIME%>
		                  </td>
			              <td>
		                           <input value="${model.inserttimeString}" onclick="WdatePicker({dateFmt:'<%=Temployee.FORMAT_INSERTTIME%>'})" id="inserttimeString" name="inserttimeString"  maxlength="0" class="Wdate" />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=Temployee.ALIAS_EDITTIME%>
		                  </td>
			              <td>
		                           <input value="${model.edittimeString}" onclick="WdatePicker({dateFmt:'<%=Temployee.FORMAT_EDITTIME%>'})" id="edittimeString" name="edittimeString"  maxlength="0" class="Wdate" />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=Temployee.ALIAS_CPCODE%>
		                  </td>
			              <td>
		                           <s:textfield label="%{@vs@ALIAS_CPCODE}" key="cpcode" value="%{model.cpcode}"  cssClass="max-length-13" required="false" />
		                  </td>
                          <td>&nbsp;</td>
                          <td>&nbsp;</td>
                   </tr>
 
 
