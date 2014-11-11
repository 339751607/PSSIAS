<%@page import="com.dyneinfo.zazh.model.*" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/commons/taglibs.jsp" %>

	<s:hidden id="id" name="id" />

<!-- ONGL access static field: @package.class@field or @vs@field -->

		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=TpersonbaseJn.ALIAS_NAME%>
		                  </td>
			              <td>
		                           <s:textfield label="%{@vs@ALIAS_NAME}" key="name" value="%{model.name}"  cssClass="max-length-30" required="false" />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=TpersonbaseJn.ALIAS_SEX%>
		                  </td>
			              <td>
		                           <s:textfield label="%{@vs@ALIAS_SEX}" key="sex" value="%{model.sex}"  cssClass="max-length-1" required="false" />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=TpersonbaseJn.ALIAS_NATION%>
		                  </td>
			              <td>
		                           <s:textfield label="%{@vs@ALIAS_NATION}" key="nation" value="%{model.nation}"  cssClass="max-length-2" required="false" />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=TpersonbaseJn.ALIAS_BDATE%>
		                  </td>
			              <td>
		                           <s:textfield label="%{@vs@ALIAS_BDATE}" key="bdate" value="%{model.bdate}"  cssClass="max-length-8" required="false" />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=TpersonbaseJn.ALIAS_CARDNAME%>
		                  </td>
			              <td>
		                           <s:textfield label="%{@vs@ALIAS_CARDNAME}" key="cardname" value="%{model.cardname}"  cssClass="max-length-2" required="false" />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=TpersonbaseJn.ALIAS_CARDCODE%>
		                  </td>
			              <td>
		                           <s:textfield label="%{@vs@ALIAS_CARDCODE}" key="cardcode" value="%{model.cardcode}"  cssClass="max-length-18" required="false" />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=TpersonbaseJn.ALIAS_XZQH%>
		                  </td>
			              <td>
		                           <s:textfield label="%{@vs@ALIAS_XZQH}" key="xzqh" value="%{model.xzqh}"  cssClass="max-length-6" required="false" />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=TpersonbaseJn.ALIAS_ADDRESS%>
		                  </td>
			              <td>
		                           <s:textfield label="%{@vs@ALIAS_ADDRESS}" key="address" value="%{model.address}"  cssClass="max-length-200" required="false" />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=TpersonbaseJn.ALIAS_UPDATETIME%>
		                  </td>
			              <td>
		                           <input value="${model.updatetimeString}" onclick="WdatePicker({dateFmt:'<%=TpersonbaseJn.FORMAT_UPDATETIME%>'})" id="updatetimeString" name="updatetimeString"  maxlength="0" class="Wdate" />
		                  </td>
                          <td>&nbsp;</td>
                          <td>&nbsp;</td>
                   </tr>
 
 
