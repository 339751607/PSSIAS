<%@page import="com.dyneinfo.fjy.model.*" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/commons/taglibs.jsp" %>

	<s:hidden id="xh" name="xh" />

<!-- ONGL access static field: @package.class@field or @vs@field -->

		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <FONT color="red">*</FONT><%=TfeijiuwupinKeyi.ALIAS_WUPINXH%>
		                  </td>
			              <td>
		                           <s:textfield label="%{@vs@ALIAS_WUPINXH}" key="wupinxh" value="%{model.wupinxh}"  cssClass="required max-length-25" required="true" />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=TfeijiuwupinKeyi.ALIAS_KEYIYUANYIN%>
		                  </td>
			              <td>
		                           <s:textfield label="%{@vs@ALIAS_KEYIYUANYIN}" key="keyiyuanyin" value="%{model.keyiyuanyin}"  cssClass="max-length-100" required="false" />
		                  </td>
                   </tr>
 
 
