<%@page import="com.dyneinfo.pmdd.model.*" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/commons/taglibs.jsp" %>

	<s:hidden id="mc" name="mc" />

<!-- ONGL access static field: @package.class@field or @vs@field -->

		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=Bdlb.ALIAS_TIB_FLOWGUID%>
		                  </td>
			              <td>
		                           <s:textfield label="%{@vs@ALIAS_TIB_FLOWGUID}" key="tibFlowguid" value="%{model.tibFlowguid}"  cssClass="max-length-32" required="false" />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=Bdlb.ALIAS_TIB_ROWGUID%>
		                  </td>
			              <td>
		                           <s:textfield label="%{@vs@ALIAS_TIB_ROWGUID}" key="tibRowguid" value="%{model.tibRowguid}"  cssClass="max-length-32" required="false" />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=Bdlb.ALIAS_DM%>
		                  </td>
			              <td>
		                           <s:textfield label="%{@vs@ALIAS_DM}" key="dm" value="%{model.dm}"  cssClass="max-length-3" required="false" />
		                  </td>
                          <td>&nbsp;</td>
                          <td>&nbsp;</td>
                   </tr>
 
 
