<%@page import="com.dyneinfo.pmdd.model.*" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/commons/taglibs.jsp" %>

	<s:hidden id="unitid" name="unitid" />

<!-- ONGL access static field: @package.class@field or @vs@field -->

		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=Registers.ALIAS_CLUSTERGROUP%>
		                  </td>
			              <td>
		                           <s:textfield label="%{@vs@ALIAS_CLUSTERGROUP}" key="clustergroup" value="%{model.clustergroup}" cssClass="max-length-128" required="false" />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=Registers.ALIAS_IPADDRESS%>
		                  </td>
			              <td>
		                           <s:textfield label="%{@vs@ALIAS_IPADDRESS}" key="ipaddress" value="%{model.ipaddress}" cssClass="max-length-32" required="false" />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=Registers.ALIAS_DATASOURCENAME%>
		                  </td>
			              <td>
		                           <s:textfield label="%{@vs@ALIAS_DATASOURCENAME}" key="datasourcename" value="%{model.datasourcename}" cssClass="max-length-64" required="false" />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=Registers.ALIAS_NOTE%>
		                  </td>
			              <td>
						           <mytag:select property="%{model.note}"   styleClass="required validate-selection"  name="note"   notEmpty="false"  dictName="gender"/>
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <FONT color="red">*</FONT><%=Registers.ALIAS_PACKAGES%>
		                  </td>
			              <td>
						           <input value="${model.packages}" onclick="WdatePicker({dateFmt:'yyyy-MM-dd'})" id="packages" name="packages"  maxlength="0" class="required Wdate" />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=Registers.ALIAS_PORT%>
		                  </td>
			              <td>
		                           <s:textfield label="%{@vs@ALIAS_PORT}" key="port" value="%{model.port}" cssClass="max-length-16" required="false" />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=Registers.ALIAS_PROTOCOL%>
		                  </td>
			              <td>
		                           <s:textfield label="%{@vs@ALIAS_PROTOCOL}" key="protocol" value="%{model.protocol}" cssClass="max-length-16" required="false" />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=Registers.ALIAS_REGISTERTIME%>
		                  </td>
			              <td>
		                           <input value="${model.registertimeString}" onclick="WdatePicker({dateFmt:'<%=Registers.FORMAT_REGISTERTIME%>'})" id="registertimeString" name="registertimeString"  maxlength="0" class="Wdate" />
		                  </td>
                   </tr>
 
 
