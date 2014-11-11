<%@page import="com.dyneinfo.zazh.model.*" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/commons/taglibs.jsp" %>

	<s:hidden id="id" name="id" />

<!-- ONGL access static field: @package.class@field or @vs@field -->

		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <FONT color="red">*</FONT><%=Tcarlog.ALIAS_CARBASEID%>
		                  </td>
			              <td>
		                           <s:textfield label="%{@vs@ALIAS_CARBASEID}" key="carbaseid" value="%{model.carbaseid}"  cssClass="required validate-integer " required="true" />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=Tcarlog.ALIAS_SOURCE%>
		                  </td>
			              <td>
		                           <s:textfield label="%{@vs@ALIAS_SOURCE}" key="source" value="%{model.source}"  cssClass="max-length-3" required="false" />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=Tcarlog.ALIAS_SID%>
		                  </td>
			              <td>
		                           <s:textfield label="%{@vs@ALIAS_SID}" key="sid" value="%{model.sid}"  cssClass="max-length-30" required="false" />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=Tcarlog.ALIAS_CARTYPE%>
		                  </td>
			              <td>
		                           <s:textfield label="%{@vs@ALIAS_CARTYPE}" key="cartype" value="%{model.cartype}"  cssClass="max-length-2" required="false" />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=Tcarlog.ALIAS_STARTTIME%>
		                  </td>
			              <td>
		                           <s:textfield label="%{@vs@ALIAS_STARTTIME}" key="starttime" value="%{model.starttime}"  cssClass="max-length-12" required="false" />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=Tcarlog.ALIAS_ENDTIME%>
		                  </td>
			              <td>
		                           <s:textfield label="%{@vs@ALIAS_ENDTIME}" key="endtime" value="%{model.endtime}"  cssClass="max-length-12" required="false" />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=Tcarlog.ALIAS_INSERTTIME%>
		                  </td>
			              <td>
		                           <input value="${model.inserttimeString}" onclick="WdatePicker({dateFmt:'<%=Tcarlog.FORMAT_INSERTTIME%>'})" id="inserttimeString" name="inserttimeString"  maxlength="0" class="Wdate" />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=Tcarlog.ALIAS_UPDATETIME%>
		                  </td>
			              <td>
		                           <input value="${model.updatetimeString}" onclick="WdatePicker({dateFmt:'<%=Tcarlog.FORMAT_UPDATETIME%>'})" id="updatetimeString" name="updatetimeString"  maxlength="0" class="Wdate" />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=Tcarlog.ALIAS_TABLEFORPIC%>
		                  </td>
			              <td>
		                           <s:textfield label="%{@vs@ALIAS_TABLEFORPIC}" key="tableforpic" value="%{model.tableforpic}"  cssClass="max-length-30" required="false" />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=Tcarlog.ALIAS_FIELDFORPIC%>
		                  </td>
			              <td>
		                           <s:textfield label="%{@vs@ALIAS_FIELDFORPIC}" key="fieldforpic" value="%{model.fieldforpic}"  cssClass="max-length-20" required="false" />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=Tcarlog.ALIAS_CPCODE%>
		                  </td>
			              <td>
		                           <s:textfield label="%{@vs@ALIAS_CPCODE}" key="cpcode" value="%{model.cpcode}"  cssClass="max-length-15" required="false" />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=Tcarlog.ALIAS_KEYFORPIC%>
		                  </td>
			              <td>
		                           <s:textfield label="%{@vs@ALIAS_KEYFORPIC}" key="keyforpic" value="%{model.keyforpic}"  cssClass="max-length-20" required="false" />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=Tcarlog.ALIAS_CARID%>
		                  </td>
			              <td>
		                           <s:textfield label="%{@vs@ALIAS_CARID}" key="carid" value="%{model.carid}"  cssClass="max-length-15" required="false" />
		                  </td>
                          <td>&nbsp;</td>
                          <td>&nbsp;</td>
                   </tr>
 
 
