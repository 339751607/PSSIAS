<%@page import="com.dyneinfo.fjy.model.*" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/commons/taglibs.jsp" %>

	<s:hidden id="id" name="id" />

<!-- ONGL access static field: @package.class@field or @vs@field -->

		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=TcpCheckInfo.ALIAS_CHECKID%>
		                  </td>
			              <td>
		                           <s:textfield label="%{@vs@ALIAS_CHECKID}" key="checkid" value="%{model.checkid}"  cssClass="validate-integer " required="false" />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=TcpCheckInfo.ALIAS_ITEM%>
		                  </td>
			              <td>
						           <mytag:select property="%{model.item}"   styleClass="required validate-selection"  name="item"   notEmpty="false"  dictName="D_check_item"/>
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=TcpCheckInfo.ALIAS_DETAIL%>
		                  </td>
			              <td>
		                           <s:textfield label="%{@vs@ALIAS_DETAIL}" key="detail" value="%{model.detail}"  cssClass="max-length-512" required="false" />
		                  </td>
                          <td>&nbsp;</td>
                          <td>&nbsp;</td>
                   </tr>
 
 
