<%@page import="com.dyneinfo.gas.model.*" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/commons/taglibs.jsp" %>


<!-- ONGL access static field: @package.class@field or @vs@field -->

		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <FONT color="red">*</FONT><%=Tempworklog.ALIAS_EMPCODE%>
		                  </td>
			              <td>
		                           <s:textfield label="%{@vs@ALIAS_EMPCODE}" key="empcode" value="%{model.empcode}"  cssClass="required max-length-27" required="true" />
		                  </td>
                          <td class="crosscolor_td">
			                      <FONT color="red">*</FONT><%=Tempworklog.ALIAS_CPCODE%>
		                  </td>
			              <td>
		                           <s:textfield label="%{@vs@ALIAS_CPCODE}" key="cpcode" value="%{model.cpcode}"  cssClass="required max-length-13" required="true" />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=Tempworklog.ALIAS_INDATE%>
		                  </td>
			              <td>
		                           <s:textfield label="%{@vs@ALIAS_INDATE}" key="indate" value="%{model.indate}"  cssClass="max-length-8" required="false" />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=Tempworklog.ALIAS_LEFTDATE%>
		                  </td>
			              <td>
		                           <s:textfield label="%{@vs@ALIAS_LEFTDATE}" key="leftdate" value="%{model.leftdate}"  cssClass="max-length-8" required="false" />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=Tempworklog.ALIAS_EMPDUTY%>
		                  </td>
			              <td>
		                           <s:textfield label="%{@vs@ALIAS_EMPDUTY}" key="empduty" value="%{model.empduty}"  cssClass="max-length-2" required="false" />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=Tempworklog.ALIAS_DEMO%>
		                  </td>
			              <td>
		                           <s:textfield label="%{@vs@ALIAS_DEMO}" key="demo" value="%{model.demo}"  cssClass="max-length-200" required="false" />
		                  </td>
                   </tr>
 
 
