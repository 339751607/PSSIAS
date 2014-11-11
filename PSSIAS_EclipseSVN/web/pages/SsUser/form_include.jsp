<%@page import="com.dyneinfo.zazh.model.*" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/commons/taglibs.jsp" %>

	<s:hidden id="userid" name="userid" />






		    <tr class="crosscolor_tr">
               <td class="crosscolor_td">
			       <%=SsUser.ALIAS_USERNAME%>:
		       </td>
			   <td >
		             <s:textfield label="%{@vs@ALIAS_USERNAME}" key="username" value="%{model.username}" cssClass="max-length-50" required="false" />
		       </td>
        
               <td class="crosscolor_td">
			       <%=SsUser.ALIAS_PASSWORD%>:
		       </td>
			   <td >
		             <s:textfield label="%{@vs@ALIAS_PASSWORD}" key="password" value="%{model.password}" cssClass="max-length-50" required="false" />
		       </td>
        </tr>
		    <tr class="crosscolor_tr">
               <td class="crosscolor_td">
			       <%=SsUser.ALIAS_FULLNAME%>:
		       </td>
			   <td >
		             <s:textfield label="%{@vs@ALIAS_FULLNAME}" key="fullname" value="%{model.fullname}" cssClass="max-length-128" required="false" />
		       </td>
        
               <td class="crosscolor_td">
			       <%=SsUser.ALIAS_SEX%>:
		       </td>
			   <td >
		             <s:textfield label="%{@vs@ALIAS_SEX}" key="sex" value="%{model.sex}" cssClass="max-length-1" required="false" />
		       </td>
        </tr>
		    <tr class="crosscolor_tr">
               <td class="crosscolor_td">
			       <%=SsUser.ALIAS_SFZH%>:
		       </td>
			   <td >
		             <s:textfield label="%{@vs@ALIAS_SFZH}" key="sfzh" value="%{model.sfzh}" cssClass="max-length-200" required="false" />
		       </td>
        
               <td class="crosscolor_td">
			       <%=SsUser.ALIAS_POLICEID%>:
		       </td>
			   <td >
		             <s:textfield label="%{@vs@ALIAS_POLICEID}" key="policeid" value="%{model.policeid}" cssClass="max-length-200" required="false" />
		       </td>
        </tr>
		    <tr class="crosscolor_tr">
               <td class="crosscolor_td">
			       <%=SsUser.ALIAS_PHONE%>:
		       </td>
			   <td >
		             <s:textfield label="%{@vs@ALIAS_PHONE}" key="phone" value="%{model.phone}" cssClass="max-length-32" required="false" />
		       </td>
        
               <td class="crosscolor_td">
			       <%=SsUser.ALIAS_MOBILE%>:
		       </td>
			   <td >
		             <s:textfield label="%{@vs@ALIAS_MOBILE}" key="mobile" value="%{model.mobile}" cssClass="max-length-32" required="false" />
		       </td>
        </tr>
		    <tr class="crosscolor_tr">
               <td class="crosscolor_td">
			       <%=SsUser.ALIAS_FAX%>:
		       </td>
			   <td >
		             <s:textfield label="%{@vs@ALIAS_FAX}" key="fax" value="%{model.fax}" cssClass="max-length-32" required="false" />
		       </td>
        
               <td class="crosscolor_td">
			       <%=SsUser.ALIAS_ADDRESS%>:
		       </td>
			   <td >
		             <s:textfield label="%{@vs@ALIAS_ADDRESS}" key="address" value="%{model.address}" cssClass="max-length-64" required="false" />
		       </td>
        </tr>
		    <tr class="crosscolor_tr">
               <td class="crosscolor_td">
			       <%=SsUser.ALIAS_ZIP%>:
		       </td>
			   <td >
		             <s:textfield label="%{@vs@ALIAS_ZIP}" key="zip" value="%{model.zip}" cssClass="max-length-32" required="false" />
		       </td>
        
               <td class="crosscolor_td">
			       <%=SsUser.ALIAS_EMAILADDRESS%>:
		       </td>
			   <td >
		             <s:textfield label="%{@vs@ALIAS_EMAILADDRESS}" key="emailaddress" value="%{model.emailaddress}" cssClass="max-length-200" required="false" />
		       </td>
        </tr>
		    <tr class="crosscolor_tr">
               <td class="crosscolor_td">
			       <%=SsUser.ALIAS_CREATEDATE%>:
		       </td>
			   <td >
		             <input value="${model.createdateString}" onclick="WdatePicker({dateFmt:'<%=SsUser.FORMAT_CREATEDATE%>'})" id="createdateString" name="createdateString"  maxlength="0" class="validate-date " />
		       </td>
        
               <td class="crosscolor_td">
			       <%=SsUser.ALIAS_DEPTID%>:
		       </td>
			   <td >
		             <s:textfield label="%{@vs@ALIAS_DEPTID}" key="deptid" value="%{model.deptid}" cssClass="validate-number " required="false" />
		       </td>
        </tr>
		    <tr class="crosscolor_tr">
               <td class="crosscolor_td">
			       <%=SsUser.ALIAS_ENABLED%>:
		       </td>
			   <td >
		             <s:textfield label="%{@vs@ALIAS_ENABLED}" key="enabled" value="%{model.enabled}" cssClass="validate-number " required="false" />
		       </td>
        
               <td class="crosscolor_td">
			       <%=SsUser.ALIAS_PHOTO%>:
		       </td>
			   <td >
		             <s:textfield label="%{@vs@ALIAS_PHOTO}" key="photo" value="%{model.photo}" cssClass="max-length-128" required="false" />
		       </td>
        </tr>
