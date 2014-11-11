<%@page import="com.dyneinfo.hotel.model.*" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/commons/taglibs.jsp" %>

	<s:hidden id="enrolid" name="enrolid" />

<!-- ONGL access static field: @package.class@field or @vs@field -->

		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=Tcarinfo.ALIAS_CAROWNER%>
		                  </td>
			              <td>
		                           <s:textfield label="%{@vs@ALIAS_CAROWNER}" key="carowner" value="%{model.carowner}"  cssClass="max-length-40" required="false" />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=Tcarinfo.ALIAS_CARTYPE%>
		                  </td>
			              <td>
		                           <s:textfield label="%{@vs@ALIAS_CARTYPE}" key="cartype" value="%{model.cartype}"  cssClass="max-length-10" required="false" />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=Tcarinfo.ALIAS_BRAND%>
		                  </td>
			              <td>
		                           <s:textfield label="%{@vs@ALIAS_BRAND}" key="brand" value="%{model.brand}"  cssClass="max-length-10" required="false" />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=Tcarinfo.ALIAS_COLOR%>
		                  </td>
			              <td>
		                           <s:textfield label="%{@vs@ALIAS_COLOR}" key="color" value="%{model.color}"  cssClass="max-length-3" required="false" />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=Tcarinfo.ALIAS_CARID%>
		                  </td>
			              <td>
		                           <s:textfield label="%{@vs@ALIAS_CARID}" key="carid" value="%{model.carid}"  cssClass="max-length-15" required="false" />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=Tcarinfo.ALIAS_ENGINECODE%>
		                  </td>
			              <td>
		                           <s:textfield label="%{@vs@ALIAS_ENGINECODE}" key="enginecode" value="%{model.enginecode}"  cssClass="max-length-30" required="false" />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=Tcarinfo.ALIAS_BODYCODE%>
		                  </td>
			              <td>
		                           <s:textfield label="%{@vs@ALIAS_BODYCODE}" key="bodycode" value="%{model.bodycode}"  cssClass="max-length-30" required="false" />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=Tcarinfo.ALIAS_ENROLTIME%>
		                  </td>
			              <td>
		                           <s:textfield label="%{@vs@ALIAS_ENROLTIME}" key="enroltime" value="%{model.enroltime}"  cssClass="max-length-12" required="false" />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=Tcarinfo.ALIAS_OPERATOR%>
		                  </td>
			              <td>
		                           <s:textfield label="%{@vs@ALIAS_OPERATOR}" key="operator" value="%{model.operator}"  cssClass="max-length-30" required="false" />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=Tcarinfo.ALIAS_CPCODE%>
		                  </td>
			              <td>
		                           <s:textfield label="%{@vs@ALIAS_CPCODE}" key="cpcode" value="%{model.cpcode}"  cssClass="max-length-13" required="false" />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=Tcarinfo.ALIAS_FLAG%>
		                  </td>
			              <td>
		                           <s:textfield label="%{@vs@ALIAS_FLAG}" key="flag" value="%{model.flag}"  cssClass="max-length-1" required="false" />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=Tcarinfo.ALIAS_CARPICTURE%>
		                  </td>
			              <td>
		                           <s:textfield label="%{@vs@ALIAS_CARPICTURE}" key="carpicture" value="%{model.carpicture}"  cssClass="" required="false" />
		                  </td>
                   </tr>
 
 
