<%@page import="com.dyneinfo.zazh.model.*" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/commons/taglibs.jsp" %>

	<s:hidden id="id" name="id" />

<!-- ONGL access static field: @package.class@field or @vs@field -->

		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=TpersonbaseJw.ALIAS_SURNAME%>
		                  </td>
			              <td>
		                           <s:textfield label="%{@vs@ALIAS_SURNAME}" key="surname" value="%{model.surname}"  cssClass="max-length-255" required="false" />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=TpersonbaseJw.ALIAS_NAME%>
		                  </td>
			              <td>
		                           <s:textfield label="%{@vs@ALIAS_NAME}" key="name" value="%{model.name}"  cssClass="max-length-30" required="false" />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=TpersonbaseJw.ALIAS_CH_NAME%>
		                  </td>
			              <td>
		                           <s:textfield label="%{@vs@ALIAS_CH_NAME}" key="chName" value="%{model.chName}"  cssClass="max-length-30" required="false" />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=TpersonbaseJw.ALIAS_SEX%>
		                  </td>
			              <td>
		                           <s:textfield label="%{@vs@ALIAS_SEX}" key="sex" value="%{model.sex}"  cssClass="max-length-1" required="false" />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=TpersonbaseJw.ALIAS_BDATE%>
		                  </td>
			              <td>
		                           <s:textfield label="%{@vs@ALIAS_BDATE}" key="bdate" value="%{model.bdate}"  cssClass="max-length-8" required="false" />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=TpersonbaseJw.ALIAS_NATIONALITY%>
		                  </td>
			              <td>
		                           <s:textfield label="%{@vs@ALIAS_NATIONALITY}" key="nationality" value="%{model.nationality}"  cssClass="max-length-3" required="false" />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=TpersonbaseJw.ALIAS_PASS_T%>
		                  </td>
			              <td>
		                           <s:textfield label="%{@vs@ALIAS_PASS_T}" key="passT" value="%{model.passT}"  cssClass="max-length-2" required="false" />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=TpersonbaseJw.ALIAS_PASS_NO%>
		                  </td>
			              <td>
		                           <s:textfield label="%{@vs@ALIAS_PASS_NO}" key="passNo" value="%{model.passNo}"  cssClass="max-length-30" required="false" />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=TpersonbaseJw.ALIAS_VISA_T%>
		                  </td>
			              <td>
		                           <s:textfield label="%{@vs@ALIAS_VISA_T}" key="visaT" value="%{model.visaT}"  cssClass="max-length-4" required="false" />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=TpersonbaseJw.ALIAS_VISA_NO%>
		                  </td>
			              <td>
		                           <s:textfield label="%{@vs@ALIAS_VISA_NO}" key="visaNo" value="%{model.visaNo}"  cssClass="max-length-20" required="false" />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=TpersonbaseJw.ALIAS_STAY_DATE%>
		                  </td>
			              <td>
		                           <s:textfield label="%{@vs@ALIAS_STAY_DATE}" key="stayDate" value="%{model.stayDate}"  cssClass="max-length-8" required="false" />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=TpersonbaseJw.ALIAS_QF_UNIT%>
		                  </td>
			              <td>
		                           <s:textfield label="%{@vs@ALIAS_QF_UNIT}" key="qfUnit" value="%{model.qfUnit}"  cssClass="max-length-4" required="false" />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=TpersonbaseJw.ALIAS_IN_DATE%>
		                  </td>
			              <td>
		                           <s:textfield label="%{@vs@ALIAS_IN_DATE}" key="inDate" value="%{model.inDate}"  cssClass="max-length-8" required="false" />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=TpersonbaseJw.ALIAS_IN_PORT%>
		                  </td>
			              <td>
		                           <s:textfield label="%{@vs@ALIAS_IN_PORT}" key="inPort" value="%{model.inPort}"  cssClass="max-length-7" required="false" />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=TpersonbaseJw.ALIAS_UPDATETIME%>
		                  </td>
			              <td>
		                           <input value="${model.updatetimeString}" onclick="WdatePicker({dateFmt:'<%=TpersonbaseJw.FORMAT_UPDATETIME%>'})" id="updatetimeString" name="updatetimeString"  maxlength="0" class="Wdate" />
		                  </td>
                          <td>&nbsp;</td>
                          <td>&nbsp;</td>
                   </tr>
 
 
