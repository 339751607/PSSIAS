<%@page import="com.dyneinfo.pmdd.model.*" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/commons/taglibs.jsp" %>

	<s:hidden id="xh" name="xh" />

<!-- ONGL access static field: @package.class@field or @vs@field -->
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=ThotelBsQa.ALIAS_WTFL%><FONT color="red">*</FONT>
		                  </td>
			              <td>
		                <mytag:select property="%{model.wtfl}"    styleClass="required validate-selection"  name="wtfl"   notEmpty="false"  dictName="wtfl"/>
		                  </td>
		                   <td class="crosscolor_td">
			                      <%=ThotelBsQa.ALIAS_USERTEL%>
		                  </td>
			              <td>
		                           <s:textfield label="%{@vs@ALIAS_USERTEL}" key="usertel" value="%{model.usertel}"  cssClass="max-length-30" required="false" />
		                  </td>
                         
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=ThotelBsQa.ALIAS_WTNR%><FONT color="red">*</FONT>
		                  </td>
			              <td colspan="3">
		                         
		                            <s:textarea label="%{@vs@ALIAS_WTNR}" rows="8" cols="80"
							key="wtnr" value="%{model.wtnr}" cssClass="required max-length-100"
							required="false"></s:textarea>
		                  </td>
                   </tr>
 
 
