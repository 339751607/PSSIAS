<%@page import="com.dyneinfo.gas.model.*" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/commons/taglibs.jsp" %>


	<s:hidden id="key" name="key" />
<!-- ONGL access static field: @package.class@field or @vs@field -->

		           <tr class="crosscolor_tr">
			              <td style="30px">
			              	<s:property value="%{model.name}" />
		                  </td>
			              <td colspan="3" >
		                           <s:textfield label="%{@vs@ALIAS_CODE}" key="code" value="%{model.code}"  cssClass=" required validate-number max-length-4" required="false" />
		                  </td>
                   </tr>
 
 
