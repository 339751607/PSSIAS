<%@page import="com.dyneinfo.gas.model.*" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/commons/taglibs.jsp" %>

	<s:hidden id="id" name="id" />

<!-- ONGL access static field: @package.class@field or @vs@field -->

		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=TbuyPic.ALIAS_PICLEN%>
		                  </td>
			              <td>
		                           <s:textfield label="%{@vs@ALIAS_PICLEN}" key="piclen" value="%{model.piclen}"  cssClass="validate-number " required="false" />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=TbuyPic.ALIAS_PICTURE%>
		                  </td>
			              <td>
		                           <s:textfield label="%{@vs@ALIAS_PICTURE}" key="picture" value="%{model.picture}"  cssClass="" required="false" />
		                  </td>
                   </tr>
 
 
