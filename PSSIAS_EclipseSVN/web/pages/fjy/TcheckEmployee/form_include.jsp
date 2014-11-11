<%@page import="com.dyneinfo.fjy.model.*" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/commons/taglibs.jsp" %>

	<s:hidden id="id" name="id" />

<!-- ONGL access static field: @package.class@field or @vs@field -->

		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=TcheckEmployee.ALIAS_IDCARD%>
		                  </td>
			              <td>
		                           <s:textfield label="%{@vs@ALIAS_IDCARD}" key="idcard" value="%{model.idcard}"  cssClass="max-length-18" required="false" />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=TcheckEmployee.ALIAS_EMPTYPE%>
		                  </td>
			              <td>
						           <mytag:select property="%{model.emptype}"   styleClass="required validate-selection"  name="emptype"   notEmpty="false"  dictName="D_empType"/>
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=TcheckEmployee.ALIAS_POLICENO%>
		                  </td>
			              <td>
		                           <s:textfield label="%{@vs@ALIAS_POLICENO}" key="policeno" value="%{model.policeno}"  cssClass="max-length-6" required="false" />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=TcheckEmployee.ALIAS_FULLNAME%>
		                  </td>
			              <td>
		                           <s:textfield label="%{@vs@ALIAS_FULLNAME}" key="fullname" value="%{model.fullname}"  cssClass="max-length-50" required="false" />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=TcheckEmployee.ALIAS_SEX%>
		                  </td>
			              <td>
						           <mytag:select property="%{model.sex}"   styleClass="required validate-selection"  name="sex"   notEmpty="false"  dictName="T_DIC_SEX"/>
		                  </td>
                          <td class="crosscolor_td">
			                      <%=TcheckEmployee.ALIAS_DEPTID%>
		                  </td>
			              <td>
		                           <s:textfield label="%{@vs@ALIAS_DEPTID}" key="deptid" value="%{model.deptid}"  cssClass="max-length-12" required="false" />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=TcheckEmployee.ALIAS_DEMO%>
		                  </td>
			              <td>
		                           <s:textfield label="%{@vs@ALIAS_DEMO}" key="demo" value="%{model.demo}"  cssClass="max-length-2000" required="false" />
		                  </td>
                          <td>&nbsp;</td>
                          <td>&nbsp;</td>
                   </tr>
 
 
