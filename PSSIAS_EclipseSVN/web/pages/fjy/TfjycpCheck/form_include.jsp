<%@page import="com.dyneinfo.fjy.model.*" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/commons/taglibs.jsp" %>

	<s:hidden id="id" name="id" />

<!-- ONGL access static field: @package.class@field or @vs@field -->

		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=TfjycpCheck.ALIAS_CPCODE%>
		                  </td>
			              <td>
		                           <s:textfield label="%{@vs@ALIAS_CPCODE}" key="cpcode" value="%{model.cpcode}"  cssClass="max-length-13" required="false" />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=TfjycpCheck.ALIAS_IDCARD%>
		                  </td>
			              <td>
		                           <s:textfield label="%{@vs@ALIAS_IDCARD}" key="idcard" value="%{model.idcard}"  cssClass="max-length-18" required="false" />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=TfjycpCheck.ALIAS_CONTENT%>
		                  </td>
			              <td>
		                           <s:textfield label="%{@vs@ALIAS_CONTENT}" key="content" value="%{model.content}"  cssClass="max-length-1000" required="false" />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=TfjycpCheck.ALIAS_CHECKDATE%>
		                  </td>
			              <td>
		                           <s:textfield label="%{@vs@ALIAS_CHECKDATE}" key="checkdate" value="%{model.checkdate}"  cssClass="max-length-8" required="false" />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=TfjycpCheck.ALIAS_CHECKTYPE%>
		                  </td>
			              <td>
		                           <s:textfield label="%{@vs@ALIAS_CHECKTYPE}" key="checktype" value="%{model.checktype}"  cssClass="max-length-1" required="false" />
		                  </td>
                          <td>&nbsp;</td>
                          <td>&nbsp;</td>
                   </tr>
 
 
