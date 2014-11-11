<%@page import="com.dyneinfo.gas.model.*" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/commons/taglibs.jsp" %>

	<s:hidden id="id" name="id" />
	<s:hidden id="pPhotoBuffer" name="pPhotoBuffer" />

<!-- ONGL access static field: @package.class@field or @vs@field -->

		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                       <FONT color="red">*</FONT><%=Tbuylog.ALIAS_NAME%>
		                  </td>
			              <td>
		                           <s:textfield label="%{@vs@ALIAS_NAME}" key="name" value="%{model.name}"  cssClass="required max-length-30" required="false" />
		                  </td>
                          <td class="crosscolor_td">
			                       <FONT color="red">*</FONT><%=Tbuylog.ALIAS_SEX%>
		                  </td>
			              <td>
		                        <mytag:select property="%{model.sex}"    name="sex"   notEmpty="false" styleClass="required validate-selection select" dictName="T_DIC_SEX"/> 
		                  </td>
		                  <td width="5%" rowspan="9" id="clxxDevice" >
		                  	<IFRAME height="200" width="240" name="result"   src="${ctx}/pages/gas/Tbuylog/CVR_IDCard.html"
								align="center" frameBorder="0" marginHeight="0" marginWidth="0"></IFRAME>
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <FONT color="red">*</FONT> <%=Tbuylog.ALIAS_NATION%>
		                  </td>
			              <td>
			              	 <mytag:select property="%{model.nation}"    name="nation"   notEmpty="false" styleClass="required validate-selection select" dictName="T_DIC_NATION"/>
		                  </td>
                          <td class="crosscolor_td">
			                      <FONT color="red">*</FONT> <%=Tbuylog.ALIAS_BDATE%>
		                  </td>
			              <td>
			              		<input value="${model.bdate}" onclick="WdatePicker({dateFmt:'yyyy-MM-dd'})" id="bdate" name="bdate"  maxlength="0" class="required Wdate" />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <FONT color="red">*</FONT> <%=Tbuylog.ALIAS_ID_NAME%>
		                  </td>
			              <td>
			                     <mytag:select property="%{model.idName}"    name="idName"   notEmpty="false" styleClass="required validate-selection select" dictName="T_ID_NAME"/>
		                  </td>
                          <td class="crosscolor_td">
			                      <FONT color="red">*</FONT> <%=Tbuylog.ALIAS_ID_CODE%>
		                  </td>

			              <td>
		                           <s:textfield label="%{@vs@ALIAS_ID_CODE}" key="idCode" value="%{model.idCode}" onblur="javascript:showBirthday();"  cssClass="required validate-id-number" required="false" />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                    <FONT color="red">*</FONT><%=Tbuylog.ALIAS_XZQH%>
		                  </td>
			              <td>
			                     <mytag:select property="%{model.xzqh}"    name="xzqh"   notEmpty="false" styleClass="required validate-selection select" dictName="T_DIC_XZQH"/>
		                  </td>
                          <td class="crosscolor_td">
			                     <FONT color="red">*</FONT>  <%=Tbuylog.ALIAS_ADDRESS%>
		                  </td>
			              <td>
		                           <s:textfield label="%{@vs@ALIAS_ADDRESS}" key="address" value="%{model.address}"  cssClass="required max-length-100" required="false" />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <FONT color="red">*</FONT> <%=Tbuylog.ALIAS_WORKUNIT%>
		                  </td>
			              <td>
		                           <s:textfield label="%{@vs@ALIAS_WORKUNIT}" key="workunit" value="%{model.workunit}"  cssClass="required max-length-50" required="false" />
		                  </td>
                          <td class="crosscolor_td">
			                      <FONT color="red">*</FONT> <%=Tbuylog.ALIAS_PHONE%>
		                  </td>
			              <td>
		                           <s:textfield label="%{@vs@ALIAS_PHONE}" key="phone" value="%{model.phone}"  cssClass="required max-length-20" required="false" />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                       <FONT color="red">*</FONT><%=Tbuylog.ALIAS_USE%>
		                  </td>
			              <td>
			                     <mytag:select property="%{model.use}"    name="use"   notEmpty="false" styleClass="required validate-selection select" dictName="DIC_ITEM_BUY_USE"/>
		                  </td>
                          <td class="crosscolor_td">
			                      <FONT color="red">*</FONT> <%=Tbuylog.ALIAS_BUYTYPE%>
		                  </td>
			              <td>
			                     <mytag:select property="%{model.buytype}"   name="buytype"   notEmpty="false" styleClass="required validate-selection select" dictName="DIC_ITEM_BUY_TYPE"/>
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                     <FONT color="red">*</FONT>  <%=Tbuylog.ALIAS_SORT%>
		                  </td>
			              <td>
			                     <mytag:select property="%{model.sort}"  name="sort"   notEmpty="false" styleClass="required validate-selection select " dictName="DIC_ITEM_BUY_SORT"/>
		                  </td>
                          <td class="crosscolor_td">
			                      <FONT color="red">*</FONT> <%=Tbuylog.ALIAS_QUANTITY%>
		                  </td>
			              <td>
		                           <s:textfield label="%{@vs@ALIAS_QUANTITY}" key="quantity" value="%{model.quantity}"  cssClass="required validate-number " required="false" />升
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                     <FONT color="red">*</FONT>  <%=Tbuylog.ALIAS_LOGTIME%>
		                  </td>
			              <td>
			              	<input value="${model.logtime}" onclick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm'})" id="logtime" name="logtime"  maxlength="0" class="required required Wdate" />
		                <td class="crosscolor_td">
			                     <FONT color="red">*</FONT>  <%=Tbuylog.ALIAS_OPERATOR%>
		                  </td>
			              <td >
		                           <s:textfield label="%{@vs@ALIAS_OPERATOR}" key="operator" value="%{model.operator}"  cssClass="required max-length-30" required="false" />
		                  </td>
                   </tr>
 
 
