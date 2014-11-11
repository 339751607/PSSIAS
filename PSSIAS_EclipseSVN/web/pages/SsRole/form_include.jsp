<%@page import="com.dyneinfo.zazh.model.*" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/commons/taglibs.jsp" %>

	<s:hidden id="roleid" name="roleid" />






		    <tr class="crosscolor_tr">
               <td class="crosscolor_td">
			       <span class="required">*</span><%=SsRole.ALIAS_ROLENAME%>:
		       </td>
			   <td >
		             <s:textfield label="%{@vs@ALIAS_ROLENAME}" key="rolename" value="%{model.rolename}" cssClass="required max-length-50" required="true" />
		       </td>
        
               <td class="crosscolor_td">
			       <%=SsRole.ALIAS_ROLEDESC%>:
		       </td>
			   <td >
		             <s:textfield label="%{@vs@ALIAS_ROLEDESC}" key="roledesc" value="%{model.roledesc}" cssClass="max-length-200" required="false" />
		       </td>
        </tr>
