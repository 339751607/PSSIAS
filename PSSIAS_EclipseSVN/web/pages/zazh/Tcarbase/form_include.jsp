<%@page import="com.dyneinfo.zazh.model.*" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/commons/taglibs.jsp" %>

	<s:hidden id="id" name="id" />

<!-- ONGL access static field: @package.class@field or @vs@field -->

		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=Tcarbase.ALIAS_CAROWNER%>
		                  </td>
			              <td>
		                           <s:textfield label="%{@vs@ALIAS_CAROWNER}" key="carowner" value="%{model.carowner}"  cssClass="max-length-40" required="false" />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=Tcarbase.ALIAS_CARTYPE%>
		                  </td>
			              <td>
		                           <s:textfield label="%{@vs@ALIAS_CARTYPE}" key="cartype" value="%{model.cartype}"  cssClass="max-length-4" required="false" />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=Tcarbase.ALIAS_BRAND%>
		                  </td>
			              <td>
		                           <s:textfield label="%{@vs@ALIAS_BRAND}" key="brand" value="%{model.brand}"  cssClass="max-length-60" required="false" />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=Tcarbase.ALIAS_CARMODE%>
		                  </td>
			              <td>
		                           <s:textfield label="%{@vs@ALIAS_CARMODE}" key="carmode" value="%{model.carmode}"  cssClass="max-length-30" required="false" />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=Tcarbase.ALIAS_COLOR%>
		                  </td>
			              <td>
		                           <s:textfield label="%{@vs@ALIAS_COLOR}" key="color" value="%{model.color}"  cssClass="max-length-3" required="false" />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=Tcarbase.ALIAS_CARID%>
		                  </td>
			              <td>
		                           <s:textfield label="%{@vs@ALIAS_CARID}" key="carid" value="%{model.carid}"  cssClass="max-length-15" required="false" />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=Tcarbase.ALIAS_ENGINECODE%>
		                  </td>
			              <td>
		                           <s:textfield label="%{@vs@ALIAS_ENGINECODE}" key="enginecode" value="%{model.enginecode}"  cssClass="max-length-30" required="false" />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=Tcarbase.ALIAS_BODYCODE%>
		                  </td>
			              <td>
		                           <s:textfield label="%{@vs@ALIAS_BODYCODE}" key="bodycode" value="%{model.bodycode}"  cssClass="max-length-30" required="false" />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=Tcarbase.ALIAS_UPDATETIME%>
		                  </td>
			              <td>
		                           <input value="${model.updatetimeString}" onclick="WdatePicker({dateFmt:'<%=Tcarbase.FORMAT_UPDATETIME%>'})" id="updatetimeString" name="updatetimeString"  maxlength="0" class="Wdate" />
		                  </td>
                          <td>&nbsp;</td>
                          <td>&nbsp;</td>
                   </tr>
 
 
