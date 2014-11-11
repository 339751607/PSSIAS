<%@page import="com.dyneinfo.zazh.model.*" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/commons/taglibs.jsp" %>

	<s:hidden id="id" name="id" />

<!-- ONGL access static field: @package.class@field or @vs@field -->

		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <FONT color="red">*</FONT><%=TpersonlogJw.ALIAS_PERSONID%>
		                  </td>
			              <td>
		                           <s:textfield label="%{@vs@ALIAS_PERSONID}" key="personid" value="%{model.personid}"  cssClass="required validate-number " required="true" />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=TpersonlogJw.ALIAS_SURNAME%>
		                  </td>
			              <td>
		                           <s:textfield label="%{@vs@ALIAS_SURNAME}" key="surname" value="%{model.surname}"  cssClass="max-length-255" required="false" />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=TpersonlogJw.ALIAS_PASS_T%>
		                  </td>
			              <td>
		                           <s:textfield label="%{@vs@ALIAS_PASS_T}" key="passT" value="%{model.passT}"  cssClass="max-length-2" required="false" />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=TpersonlogJw.ALIAS_PASS_NO%>
		                  </td>
			              <td>
		                           <s:textfield label="%{@vs@ALIAS_PASS_NO}" key="passNo" value="%{model.passNo}"  cssClass="max-length-30" required="false" />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=TpersonlogJw.ALIAS_SOURCE%>
		                  </td>
			              <td>
		                           <s:textfield label="%{@vs@ALIAS_SOURCE}" key="source" value="%{model.source}"  cssClass="max-length-3" required="false" />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=TpersonlogJw.ALIAS_SID%>
		                  </td>
			              <td>
		                           <s:textfield label="%{@vs@ALIAS_SID}" key="sid" value="%{model.sid}"  cssClass="max-length-30" required="false" />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=TpersonlogJw.ALIAS_PERSONTYPE%>
		                  </td>
			              <td>
		                           <s:textfield label="%{@vs@ALIAS_PERSONTYPE}" key="persontype" value="%{model.persontype}"  cssClass="max-length-2" required="false" />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=TpersonlogJw.ALIAS_EMPSTATUS%>
		                  </td>
			              <td>
		                           <s:textfield label="%{@vs@ALIAS_EMPSTATUS}" key="empstatus" value="%{model.empstatus}"  cssClass="max-length-2" required="false" />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=TpersonlogJw.ALIAS_STARTTIME%>
		                  </td>
			              <td>
		                           <s:textfield label="%{@vs@ALIAS_STARTTIME}" key="starttime" value="%{model.starttime}"  cssClass="max-length-12" required="false" />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=TpersonlogJw.ALIAS_ENDTIME%>
		                  </td>
			              <td>
		                           <s:textfield label="%{@vs@ALIAS_ENDTIME}" key="endtime" value="%{model.endtime}"  cssClass="" required="false" />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=TpersonlogJw.ALIAS_INSERTTIME%>
		                  </td>
			              <td>
		                           <input value="${model.inserttimeString}" onclick="WdatePicker({dateFmt:'<%=TpersonlogJw.FORMAT_INSERTTIME%>'})" id="inserttimeString" name="inserttimeString"  maxlength="0" class="Wdate" />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=TpersonlogJw.ALIAS_UPDATETIME%>
		                  </td>
			              <td>
		                           <input value="${model.updatetimeString}" onclick="WdatePicker({dateFmt:'<%=TpersonlogJw.FORMAT_UPDATETIME%>'})" id="updatetimeString" name="updatetimeString"  maxlength="0" class="Wdate" />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <FONT color="red">*</FONT><%=TpersonlogJw.ALIAS_TABLEFORPIC%>
		                  </td>
			              <td>
		                           <s:textfield label="%{@vs@ALIAS_TABLEFORPIC}" key="tableforpic" value="%{model.tableforpic}"  cssClass="required max-length-30" required="true" />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=TpersonlogJw.ALIAS_FIELDFORPIC%>
		                  </td>
			              <td>
		                           <s:textfield label="%{@vs@ALIAS_FIELDFORPIC}" key="fieldforpic" value="%{model.fieldforpic}"  cssClass="max-length-20" required="false" />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=TpersonlogJw.ALIAS_CPCODE%>
		                  </td>
			              <td>
		                           <s:textfield label="%{@vs@ALIAS_CPCODE}" key="cpcode" value="%{model.cpcode}"  cssClass="max-length-15" required="false" />
		                  </td>
                          <td>&nbsp;</td>
                          <td>&nbsp;</td>
                   </tr>
 
 
