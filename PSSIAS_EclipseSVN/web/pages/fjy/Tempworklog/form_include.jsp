<%@page import="com.dyneinfo.fjy.model.*" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/commons/taglibs.jsp" %>

	<s:hidden id="worklogid" name="worklogid" />

<!-- ONGL access static field: @package.class@field or @vs@field -->

		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <FONT color="red">*</FONT><%=Tempworklog.ALIAS_EMPCODE%>
		                  </td>
			              <td>
		                           <s:textfield label="%{@vs@ALIAS_EMPCODE}" key="empcode" value="%{model.empcode}"  cssClass="required max-length-26" required="true" />
		                  </td>
                          <td class="crosscolor_td">
			                      <FONT color="red">*</FONT><%=Tempworklog.ALIAS_CPCODE%>
		                  </td>
			              <td>
		                           <s:textfield label="%{@vs@ALIAS_CPCODE}" key="cpcode" value="%{model.cpcode}"  cssClass="required max-length-10" required="true" />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <FONT color="red">*</FONT><%=Tempworklog.ALIAS_INDATE%>
		                  </td>
			              <td>
						           <input value="${model.indate}" onclick="WdatePicker({dateFmt:'yyyy-MM-dd'})" id="indate" name="indate"  maxlength="0" class="required Wdate" />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=Tempworklog.ALIAS_LEFTDATE%>
		                  </td>
			              <td>
						           <input value="${model.leftdate}" onclick="WdatePicker({dateFmt:'yyyy-MM-dd'})" id="leftdate" name="leftdate"  maxlength="0" class="required Wdate" />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <FONT color="red">*</FONT><%=Tempworklog.ALIAS_EMPTYPE%>
		                  </td>
			              <td>
						           <mytag:select property="%{model.emptype}"   styleClass="required validate-selection"  name="emptype"   notEmpty="false"  dictName="T_DIC_EMPTYPE"/>
		                  </td>
                          <td class="crosscolor_td">
			                      <%=Tempworklog.ALIAS_DEMO%>
		                  </td>
			              <td>
		                           <s:textfield label="%{@vs@ALIAS_DEMO}" key="demo" value="%{model.demo}"  cssClass="max-length-200" required="false" />
		                  </td>
                   </tr>
 
 
