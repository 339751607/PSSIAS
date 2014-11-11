<%@page import="com.dyneinfo.jxy.model.*" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/commons/taglibs.jsp" %>

	<s:hidden id="enrolid" name="enrolid" />

<!-- ONGL access static field: @package.class@field or @vs@field -->

		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=Tcarreturn.ALIAS_DELINAME%>
		                  </td>
			              <td>
		                           <s:textfield label="%{@vs@ALIAS_DELINAME}" key="deliname" value="%{model.deliname}"  cssClass="max-length-30" required="false" />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=Tcarreturn.ALIAS_DELICREDTYPE%>
		                  </td>
			              <td>
		                           <s:textfield label="%{@vs@ALIAS_DELICREDTYPE}" key="delicredtype" value="%{model.delicredtype}"  cssClass="max-length-1" required="false" />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=Tcarreturn.ALIAS_DELICREDCODE%>
		                  </td>
			              <td>
		                           <s:textfield label="%{@vs@ALIAS_DELICREDCODE}" key="delicredcode" value="%{model.delicredcode}"  cssClass="max-length-18" required="false" />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=Tcarreturn.ALIAS_RECETIME%>
		                  </td>
			              <td>
		                           <s:textfield label="%{@vs@ALIAS_RECETIME}" key="recetime" value="%{model.recetime}"  cssClass="max-length-12" required="false" />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=Tcarreturn.ALIAS_RECENAME%>
		                  </td>
			              <td>
		                           <s:textfield label="%{@vs@ALIAS_RECENAME}" key="recename" value="%{model.recename}"  cssClass="max-length-30" required="false" />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=Tcarreturn.ALIAS_TAKEOFFNAME%>
		                  </td>
			              <td>
		                           <s:textfield label="%{@vs@ALIAS_TAKEOFFNAME}" key="takeoffname" value="%{model.takeoffname}"  cssClass="max-length-30" required="false" />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=Tcarreturn.ALIAS_TOCREDTYPE%>
		                  </td>
			              <td>
		                           <s:textfield label="%{@vs@ALIAS_TOCREDTYPE}" key="tocredtype" value="%{model.tocredtype}"  cssClass="max-length-1" required="false" />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=Tcarreturn.ALIAS_TOCREDCODE%>
		                  </td>
			              <td>
		                           <s:textfield label="%{@vs@ALIAS_TOCREDCODE}" key="tocredcode" value="%{model.tocredcode}"  cssClass="max-length-18" required="false" />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=Tcarreturn.ALIAS_TOTIME%>
		                  </td>
			              <td>
		                           <s:textfield label="%{@vs@ALIAS_TOTIME}" key="totime" value="%{model.totime}"  cssClass="max-length-12" required="false" />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=Tcarreturn.ALIAS_FLAG%>
		                  </td>
			              <td>
		                           <s:textfield label="%{@vs@ALIAS_FLAG}" key="flag" value="%{model.flag}"  cssClass="max-length-1" required="false" />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=Tcarreturn.ALIAS_ENROLTIME%>
		                  </td>
			              <td>
		                           <s:textfield label="%{@vs@ALIAS_ENROLTIME}" key="enroltime" value="%{model.enroltime}"  cssClass="max-length-12" required="false" />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=Tcarreturn.ALIAS_OPERATOR%>
		                  </td>
			              <td>
		                           <s:textfield label="%{@vs@ALIAS_OPERATOR}" key="operator" value="%{model.operator}"  cssClass="max-length-50" required="false" />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=Tcarreturn.ALIAS_DELITELEPHONE%>
		                  </td>
			              <td>
		                           <s:textfield label="%{@vs@ALIAS_DELITELEPHONE}" key="delitelephone" value="%{model.delitelephone}"  cssClass="max-length-18" required="false" />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=Tcarreturn.ALIAS_SERVERITEM%>
		                  </td>
			              <td>
		                           <s:textfield label="%{@vs@ALIAS_SERVERITEM}" key="serveritem" value="%{model.serveritem}"  cssClass="max-length-50" required="false" />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=Tcarreturn.ALIAS_DEMO%>
		                  </td>
			              <td>
		                           <s:textfield label="%{@vs@ALIAS_DEMO}" key="demo" value="%{model.demo}"  cssClass="max-length-300" required="false" />
		                  </td>
                          <td>&nbsp;</td>
                          <td>&nbsp;</td>
                   </tr>
 
 
