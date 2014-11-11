<%@page import="com.dyneinfo.jxy.model.*" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/commons/taglibs.jsp" %>


<!-- ONGL access static field: @package.class@field or @vs@field -->

		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <FONT color="red">*</FONT><%=Tcpchange.ALIAS_CPCODE%>
		                  </td>
			              <td>
		                           <s:textfield label="%{@vs@ALIAS_CPCODE}" key="cpcode" value="%{model.cpcode}"  cssClass="required max-length-13" required="true" />
		                  </td>
                          <td class="crosscolor_td">
			                      <FONT color="red">*</FONT><%=Tcpchange.ALIAS_CHANGEDATE%>
		                  </td>
			              <td>
		                           <s:textfield label="%{@vs@ALIAS_CHANGEDATE}" key="changedate" value="%{model.changedate}"  cssClass="required max-length-8" required="true" />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <FONT color="red">*</FONT><%=Tcpchange.ALIAS_CHANGECODE%>
		                  </td>
			              <td>
		                           <s:textfield label="%{@vs@ALIAS_CHANGECODE}" key="changecode" value="%{model.changecode}"  cssClass="required max-length-1" required="true" />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=Tcpchange.ALIAS_BEFORECONTEN%>
		                  </td>
			              <td>
		                           <s:textfield label="%{@vs@ALIAS_BEFORECONTEN}" key="beforeconten" value="%{model.beforeconten}"  cssClass="max-length-160" required="false" />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=Tcpchange.ALIAS_AFTERCONTENT%>
		                  </td>
			              <td>
		                           <s:textfield label="%{@vs@ALIAS_AFTERCONTENT}" key="aftercontent" value="%{model.aftercontent}"  cssClass="max-length-160" required="false" />
		                  </td>
                          <td>&nbsp;</td>
                          <td>&nbsp;</td>
                   </tr>
 
 
