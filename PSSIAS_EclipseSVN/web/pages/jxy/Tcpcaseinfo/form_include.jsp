<%@page import="com.dyneinfo.jxy.model.*" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/commons/taglibs.jsp" %>

	<s:hidden id="id" name="id" />

<!-- ONGL access static field: @package.class@field or @vs@field -->

		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <FONT color="red">*</FONT><%=Tcpcaseinfo.ALIAS_CPCODE%>
		                  </td>
			              <td>
		                           <s:textfield label="%{@vs@ALIAS_CPCODE}" key="cpcode"  readonly="true" value="%{model.cpcode}"  cssClass="required max-length-13" required="true" />
		                           <input name="selectPersons" onclick="selectEmp()"   value="选择" type="button">
		                 
		                  </td>
                          <td class="crosscolor_td">
			                      <FONT color="red">*</FONT><%=Tcpcaseinfo.ALIAS_CASECODE%>
		                  </td>
			              <td>
		                           <s:textfield label="%{@vs@ALIAS_CASECODE}" key="casecode" value="%{model.casecode}"  cssClass="required max-length-50" required="true" />
		                  
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
		            <td class="crosscolor_td">
			                      <FONT color="red">*</FONT><%=Tcpcaseinfo.ALIAS_CASEFLAG%>
		                  </td>
			              <td>
		                          
		                           <mytag:select dictName="DIC_ITEM_CASEFLAG" name="caseflag" property="%{model.caseflag}" styleClass="required validate-selection" notEmpty="false"></mytag:select>
		                 
		                  </td>
		           <td class="crosscolor_td">
			                     <FONT color="red">*</FONT><%=Tcpcaseinfo.ALIAS_CASETYPE%>
		                  </td>
			              <td>
		                          <mytag:select name="casetype" property="%{model.casetype}"  notEmpty="false"  styleClass="required validate-selection" dictName="Diccon_AJ"></mytag:select>
		                           
		                  </td>
                         
                         
                   </tr>
                   
		           <tr class="crosscolor_tr">
		            <td class="crosscolor_td">
			                     <FONT color="red">*</FONT><%=Tcpcaseinfo.ALIAS_HAPPENTIME%>
		                  </td>
			              <td>
			              			 <input value="${model.happentime}" onclick="WdatePicker({dateFmt:'<%=Tcpcaseinfo.FORMAT_STARTTIME%>',maxDate:'${date}'})"  name="happentime"  cssClass="required " class="required Wdate" />
		                           
		                  </td>
                          <td></td>
                          <td></td>
                         
                   </tr>
                   <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=Tcpcaseinfo.ALIAS_CASEDESC%>
		                  </td>
			              <td colspan="3" align="left" >
			                <s:textarea style="margin-left: 10px" label="%{@vs@ALIAS_CASEDESC}" rows="6" cols="55"
							key="casedesc" value="%{model.casedesc}" cssClass="max-length-200"
							required="false"></s:textarea>
		                 </td>
		                  
		                  
                   </tr>
		         
 
 
