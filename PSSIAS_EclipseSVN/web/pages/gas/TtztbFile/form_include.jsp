<%@page import="com.dyneinfo.gas.model.*" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/commons/taglibs.jsp" %>

	<s:hidden id="id" name="id" />

<!-- ONGL access static field: @package.class@field or @vs@field -->

		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=TtztbFile.ALIAS_FILEID%>
		                  </td>
			              <td>
		                           <s:textfield label="%{@vs@ALIAS_FILEID}" key="fileid" value="%{model.fileid}"  cssClass="validate-number " required="false" />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=TtztbFile.ALIAS_FILECONTENT%>
		                  </td>
			              <td>
		                           <s:textfield label="%{@vs@ALIAS_FILECONTENT}" key="filecontent" value="%{model.filecontent}"  cssClass="" required="false" />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=TtztbFile.ALIAS_TZTBTYPE%>
		                  </td>
			              <td>
		                           <s:textfield label="%{@vs@ALIAS_TZTBTYPE}" key="tztbtype" value="%{model.tztbtype}"  cssClass="max-length-1" required="false" />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=TtztbFile.ALIAS_FILENAME%>
		                  </td>
			              <td>
		                           <s:textfield label="%{@vs@ALIAS_FILENAME}" key="filename" value="%{model.filename}"  cssClass="max-length-100" required="false" />
		                  </td>
                   </tr>
 
 
