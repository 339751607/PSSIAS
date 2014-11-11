<%@page import="com.dyneinfo.fjy.model.*" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/commons/taglibs.jsp" %>

	<s:hidden id="checkinfoid" name="checkinfoid" />

<!-- ONGL access static field: @package.class@field or @vs@field -->

		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=TpoliceCheckinfo.ALIAS_CHECKID%>
		                  </td>
			              <td>
		                           <s:textfield label="%{@vs@ALIAS_CHECKID}" key="checkid" value="%{model.checkid}"  cssClass="validate-number " required="false" />
		                  </td>
                          <td class="crosscolor_td">
			                      <FONT color="red">*</FONT> <%=TpoliceCheckinfo.ALIAS_ITEM%>
		                  </td>
			              <td>
						           <mytag:select property="%{model.item}"   styleClass="required validate-selection"  name="item"   notEmpty="false"  dictName="checkItem"/>
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=TpoliceCheckinfo.ALIAS_DETAIL%>
		                  </td>
			              <td>
		                           <s:textfield label="%{@vs@ALIAS_DETAIL}" key="detail" value="%{model.detail}"  cssClass="max-length-1024" required="false" />
		                  </td>
                          <td>&nbsp;</td>
                          <td>&nbsp;</td>
                   </tr>
 
 
