<%@page import="com.dyneinfo.zazh.model.*" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/commons/taglibs.jsp" %>

	<s:hidden id="loginid" name="loginid" />

<!-- ONGL access static field: @package.class@field or @vs@field -->

		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=LoginHistory.ALIAS_LOGINTIME%>
		                  </td>
			              <td>
		                           <input value="${model.logintimeString}" onclick="WdatePicker({dateFmt:'<%=LoginHistory.FORMAT_LOGINTIME%>'})" id="logintimeString" name="logintimeString"  maxlength="0" class="Wdate" />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=LoginHistory.ALIAS_LOGINNAME%>
		                  </td>
			              <td>
		                           <s:textfield label="%{@vs@ALIAS_LOGINNAME}" key="loginname" value="%{model.loginname}"  cssClass="max-length-30" required="false" />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=LoginHistory.ALIAS_ISVALID%>
		                  </td>
			              <td>
		                           <s:textfield label="%{@vs@ALIAS_ISVALID}" key="isvalid" value="%{model.isvalid}"  cssClass="max-length-132" required="false" />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=LoginHistory.ALIAS_INVALIDPASSWORD%>
		                  </td>
			              <td>
		                           <s:textfield label="%{@vs@ALIAS_INVALIDPASSWORD}" key="invalidpassword" value="%{model.invalidpassword}"  cssClass="max-length-128" required="false" />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=LoginHistory.ALIAS_IPADDRESS%>
		                  </td>
			              <td>
		                           <s:textfield label="%{@vs@ALIAS_IPADDRESS}" key="ipaddress" value="%{model.ipaddress}"  cssClass="max-length-64" required="false" />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=LoginHistory.ALIAS_BROWSER%>
		                  </td>
			              <td>
		                           <s:textfield label="%{@vs@ALIAS_BROWSER}" key="browser" value="%{model.browser}"  cssClass="max-length-1024" required="false" />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=LoginHistory.ALIAS_HOSTNAME%>
		                  </td>
			              <td>
		                           <s:textfield label="%{@vs@ALIAS_HOSTNAME}" key="hostname" value="%{model.hostname}"  cssClass="max-length-512" required="false" />
		                  </td>
                          <td>&nbsp;</td>
                          <td>&nbsp;</td>
                   </tr>
 
 
