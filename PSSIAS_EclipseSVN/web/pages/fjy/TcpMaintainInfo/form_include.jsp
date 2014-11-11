<%@page import="com.dyneinfo.fjy.model.*" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/commons/taglibs.jsp" %>

	<s:hidden id="id" name="id" />

<!-- ONGL access static field: @package.class@field or @vs@field -->

		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=TcpMaintainInfo.ALIAS_MAINTAINID%>
		                  </td>
			              <td>
		                           <s:textfield label="%{@vs@ALIAS_MAINTAINID}" key="maintainid" value="%{model.maintainid}"  cssClass="validate-integer " required="false" />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=TcpMaintainInfo.ALIAS_ITEM%>
		                  </td>
			              <td>
						           <mytag:select property="%{model.item}"   styleClass="required validate-selection"  name="item"   notEmpty="false"  dictName="D_mainTain_item"/>
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=TcpMaintainInfo.ALIAS_DETAIL%>
		                  </td>
			              <td>
		                           <s:textfield label="%{@vs@ALIAS_DETAIL}" key="detail" value="%{model.detail}"  cssClass="max-length-512" required="false" />
		                  </td>
                          <td>&nbsp;</td>
                          <td>&nbsp;</td>
                   </tr>
 
 
