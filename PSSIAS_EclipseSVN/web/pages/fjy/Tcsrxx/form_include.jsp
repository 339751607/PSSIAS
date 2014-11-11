<%@page import="com.dyneinfo.fjy.model.*" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/commons/taglibs.jsp" %>

	<s:hidden id="id" name="id" />
 <s:hidden name="cpcode" value="%{model.cpcode}"></s:hidden>
<!-- ONGL access static field: @package.class@field or @vs@field -->

		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <FONT color="red">*</FONT><%=Tcsrxx.ALIAS_IDCARD%>
		                  </td>
			              <td>
	                               <s:textfield label="%{@vs@ALIAS_IDCARD}" key="idcard" value="%{model.idcard}"  cssClass="required max-length-18 validate-id-number" required="true" />
		                  </td>
                          <td class="crosscolor_td">
			                      <FONT color="red">*</FONT><%=Tcsrxx.ALIAS_CSRXM%>
		                  </td>
			              <td>
	                               <s:textfield label="%{@vs@ALIAS_CSRXM}" key="csrxm" value="%{model.csrxm}"  cssClass="required max-length-20 validate-chinese" required="true" />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <FONT color="red">*</FONT><%=Tcsrxx.ALIAS_CSRDH%>
		                  </td>
			               <td colspan="3">
		                           <s:textfield label="%{@vs@ALIAS_CSRDH}" key="csrdh" value="%{model.csrdh}"  cssClass="required max-length-30" required="true" />
		                  </td>
		               </tr>

		          
 
 
