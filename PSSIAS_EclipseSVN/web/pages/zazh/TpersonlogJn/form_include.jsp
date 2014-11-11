<%@page import="com.dyneinfo.zazh.model.*" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/commons/taglibs.jsp" %>

	<s:hidden id="id" name="id" />

<!-- ONGL access static field: @package.class@field or @vs@field -->

		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <FONT color="red">*</FONT><%=TpersonlogJn.ALIAS_PERSONID%>
		                  </td>
			              <td>
		                           <s:textfield label="%{@vs@ALIAS_PERSONID}" key="personid" value="%{model.personid}"  cssClass="required validate-number " required="true" />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=TpersonlogJn.ALIAS_CARDNAME%>
		                  </td>
			              <td>
		                           <s:textfield label="%{@vs@ALIAS_CARDNAME}" key="cardname" value="%{model.cardname}"  cssClass="max-length-2" required="false" />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=TpersonlogJn.ALIAS_CARDNO%>
		                  </td>
			              <td>
		                           <s:textfield label="%{@vs@ALIAS_CARDNO}" key="cardno" value="%{model.cardno}"  cssClass="max-length-18" required="false" />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=TpersonlogJn.ALIAS_SOURCE%>
		                  </td>
			              <td>
		                           <s:textfield label="%{@vs@ALIAS_SOURCE}" key="source" value="%{model.source}"  cssClass="max-length-3" required="false" />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=TpersonlogJn.ALIAS_SID%>
		                  </td>
			              <td>
		                           <s:textfield label="%{@vs@ALIAS_SID}" key="sid" value="%{model.sid}"  cssClass="max-length-30" required="false" />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=TpersonlogJn.ALIAS_PERSONTYPE%>
		                  </td>
			              <td>
		                           <s:textfield label="%{@vs@ALIAS_PERSONTYPE}" key="persontype" value="%{model.persontype}"  cssClass="max-length-2" required="false" />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=TpersonlogJn.ALIAS_EMPSTATUS%>
		                  </td>
			              <td>
		                           <s:textfield label="%{@vs@ALIAS_EMPSTATUS}" key="empstatus" value="%{model.empstatus}"  cssClass="max-length-2" required="false" />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=TpersonlogJn.ALIAS_STARTTIME%>
		                  </td>
			              <td>
		                           <s:textfield label="%{@vs@ALIAS_STARTTIME}" key="starttime" value="%{model.starttime}"  cssClass="max-length-12" required="false" />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=TpersonlogJn.ALIAS_ENDTIME%>
		                  </td>
			              <td>
		                           <s:textfield label="%{@vs@ALIAS_ENDTIME}" key="endtime" value="%{model.endtime}"  cssClass="max-length-12" required="false" />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=TpersonlogJn.ALIAS_INSERTTIME%>
		                  </td>
			              <td>
		                           <input value="${model.inserttimeString}" onclick="WdatePicker({dateFmt:'<%=TpersonlogJn.FORMAT_INSERTTIME%>'})" id="inserttimeString" name="inserttimeString"  maxlength="0" class="Wdate" />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=TpersonlogJn.ALIAS_UPDATETIME%>
		                  </td>
			              <td>
		                           <input value="${model.updatetimeString}" onclick="WdatePicker({dateFmt:'<%=TpersonlogJn.FORMAT_UPDATETIME%>'})" id="updatetimeString" name="updatetimeString"  maxlength="0" class="Wdate" />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=TpersonlogJn.ALIAS_TABLEFORPIC%>
		                  </td>
			              <td>
		                           <s:textfield label="%{@vs@ALIAS_TABLEFORPIC}" key="tableforpic" value="%{model.tableforpic}"  cssClass="max-length-30" required="false" />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=TpersonlogJn.ALIAS_FIELDFORPIC%>
		                  </td>
			              <td>
		                           <s:textfield label="%{@vs@ALIAS_FIELDFORPIC}" key="fieldforpic" value="%{model.fieldforpic}"  cssClass="max-length-20" required="false" />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=TpersonlogJn.ALIAS_CPCODE%>
		                  </td>
			              <td>
		                           <s:textfield label="%{@vs@ALIAS_CPCODE}" key="cpcode" value="%{model.cpcode}"  cssClass="max-length-15" required="false" />
		                  </td>
                   </tr>
 
 
