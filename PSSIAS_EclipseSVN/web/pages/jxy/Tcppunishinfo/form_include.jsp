<%@page import="com.dyneinfo.jxy.model.*" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/commons/taglibs.jsp" %>


<!-- ONGL access static field: @package.class@field or @vs@field -->

		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <FONT color="red">*</FONT><%=Tcppunishinfo.ALIAS_CPCODE%>
		                  </td>
			              <td>
		                           <s:textfield label="%{@vs@ALIAS_CPCODE}" readonly="true" key="cpcode" value="%{model.cpcode}"  cssClass="required max-length-13" required="true" />
		                 			<input name="selectPersons" onclick="selectEmp()"   value="选择" type="button">
		                  </td>
                          <td class="crosscolor_td">
			                      <FONT color="red">*</FONT><%=Tcppunishinfo.ALIAS_PDATE%>
		                  </td>
			              <td>
		                        
		                  <input value="${model.pdate}" onclick="WdatePicker({dateFmt:'yyyy-MM-dd',maxDate:'${date}'})"   name="pdate" id="pdate" class="required Wdate" />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <FONT color="red">*</FONT><%=Tcppunishinfo.ALIAS_PFILENO%>
		                  </td>
			              <td>
		                           <s:textfield label="%{@vs@ALIAS_PFILENO}" key="pfileno" value="%{model.pfileno}"  cssClass="required max-length-20" required="true" />
		                  </td>
                          <td class="crosscolor_td">
			                      <FONT color="red">*</FONT><%=Tcppunishinfo.ALIAS_AUTHUNIT%>
		                  </td>
			              <td>
		                          
		                           <mytag:select property="%{model.authunit}" name="authunit" styleClass="required validate-selection" notEmpty="false" dictName="ssfj"></mytag:select>
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=Tcppunishinfo.ALIAS_AUTHPERSON%>
		                  </td>
			              <td>
		                           <s:textfield label="%{@vs@ALIAS_AUTHPERSON}" key="authperson" value="%{model.authperson}"  cssClass="validate-chinese" required="false" />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=Tcppunishinfo.ALIAS_EXECPERSON%>
		                  </td>
			              <td>
		                           <s:textfield label="%{@vs@ALIAS_EXECPERSON}" key="execperson" value="%{model.execperson}"  cssClass="validate-chinese" required="false" />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
 <td class="crosscolor_td">
			                      <%=Tcppunishinfo.ALIAS_PPERSON%>
		                  </td>
			              <td>
		                           <s:textfield label="%{@vs@ALIAS_PPERSON}" key="pperson" value="%{model.pperson}"  cssClass="validate-chinese" required="false" />
		                  </td>
                          <td class="crosscolor_td">
			                      <FONT color="red">*</FONT><%=Tcppunishinfo.ALIAS_PTYPE%>
		                  </td>
			              <td>
		                          
		                 			<mytag:select property="%{model.ptype}" name="ptype" notEmpty="false" styleClass="required validate-selection" dictName="Diccon_cf"></mytag:select>
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=Tcppunishinfo.ALIAS_RANGE%>
		                  </td>
			              <td>
		                           <s:textfield label="%{@vs@ALIAS_RANGE}" key="range" value="%{model.range}"  cssClass="max-length-50" required="false" />
		                  </td>
                         
                   </tr>
                   <tr class="crosscolor_tr">
                    <td class="crosscolor_td">
			                      <FONT color="red">*</FONT><%=Tcppunishinfo.ALIAS_CAUSE%>
		                  </td>
                    <td colspan="3">
			                <s:textarea label="%{@vs@ALIAS_CASEDESC}" rows="6" cols="55"
							key="cause" value="%{model.cause}" cssClass="required max-length-200"
							required="false"></s:textarea>
		                         
		                       
		                  </td>
                   </tr>
 
 
