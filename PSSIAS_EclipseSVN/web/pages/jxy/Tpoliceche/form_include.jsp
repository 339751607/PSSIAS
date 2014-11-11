<%@page import="com.dyneinfo.jxy.model.*" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/commons/taglibs.jsp" %>
<%@ page import="net.java.dev.common.dict.taglib.DictHelpImpl"%>

<%
String mjjc = (String) DictHelpImpl.getInitData("mjjc");
%>
	<s:hidden id="checkid" name="checkid" />

<!-- ONGL access static field: @package.class@field or @vs@field -->

		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                    <FONT color="red">*</FONT>  <%=Tpoliceche.ALIAS_DEPTID%>
		                  </td>
			              <td>
		                 		<s:textfield   readonly="true" label="%{@vs@ALIAS_COMPANYINFO}" key="companyinfo" value="%{model.companyinfo}"  cssClass="required validate-chinese max-length-60"  required="false" />
		                 		<% if("1".equals(mjjc) || "".equals(mjjc)){ %>
		                 			<input name="selectPersons" onclick="selectEmp()"   value="选择" type="button">	
		                 		<%} %>
		                  </td>
		                  <td class="crosscolor_td">
			                     <FONT color="red">*</FONT> <%=Tpoliceche.ALIAS_CHECKNAME1%>
		                  </td>
			              <td>
		                           <s:textfield  label="%{@vs@ALIAS_CHECKNAME1}" key="checkname1" value="%{model.checkname1}"  cssClass="required validate-chinese max-length-30"   required="false" />
		                  
		                  </td>
		                  <td class="crosscolor_td">
			                      <%=Tpoliceche.ALIAS_CHECKNAME2%>
		                  </td>
			              <td>
		                           <s:textfield label="%{@vs@ALIAS_CHECKNAME2}" key="checkname2" value="%{model.checkname2}"  cssClass="validate-chinese max-length-50" required="false" />
		                  </td>
                         
                   </tr>
		           <tr class="crosscolor_tr">
		            
                          
                          <td class="crosscolor_td">
			                    <FONT color="red">*</FONT>   <%=Tpoliceche.ALIAS_COMPANYINFO%>
		                  </td>
			              <td>		<!-- 
		                           <input type="text" value="${model.companyinfo}" disabled="disabled" name="Companyinfo"/>
		                 			<input type="hidden" value="${model.companyinfo}" name="company" id = "company"/>-->

			              			<s:property value="%{model.deptid}"/>
		                           <s:hidden label="%{@vs@ALIAS_DEPTID}" key="deptid" value="%{model.deptid}"  cssClass="required  max-length-60" required="false" />
		                           
		                  </td>
		                  
		                  <td class="crosscolor_td">
			                      <FONT color="red">*</FONT> <%=Tpoliceche.ALIAS_EXAMINE%>
		                  </td>
			              <td>
			              <mytag:select property="%{model.examine}"   styleClass="required validate-selection"  name="examine"   notEmpty="false"  dictName="jxfs"/>
		                   
		                          
		                 
		                  </td>
		                  <td class="crosscolor_td">
			                     <FONT color="red">*</FONT> <%=Tpoliceche.ALIAS_ACCEPTCHECKNAME%>
		                 
		                  </td>
			               <td>
		                           <s:textfield label="%{@vs@ALIAS_ACCEPTCHECKNAME}" key="acceptcheckname" value="%{model.acceptcheckname}"  cssClass="required validate-chinese max-length-30" required="false" />
		                  
		                  </td>
		                  
                   </tr>
		         
		                
                         
                         
                  
                   
                    <tr class="crosscolor_tr">
		           
		            <td class="crosscolor_td">
			                      <%=Tpoliceche.ALIAS_IMPLEMENT%>
		                  </td>
			              <td >
		                        
		                        <table class="list2">
			              		<tr><td>
		                        <input type="radio" name="implement" value="0" checked="checked">
			              		</td><td>
		                       	是		
		                        </td><td>
		                        <input type="radio" name="implement" value="1">
		                        </td><td>
		                                                                否	
		                        </td></tr>
			              		</table>
		                           
		                  </td>
		                 <td colspan="4">
		                  <s:textfield size="80" label="%{@vs@ALIAS_IMPLEMENT_INPUT}" key="implementInput" value="%{model.implementInput}"  cssClass="max-length-30" required="false" />
		                 </td>
		                
                         
                         
                   </tr>
                   <tr class="crosscolor_tr">
                      <td class="crosscolor_td">
			                      <%=Tpoliceche.ALIAS_VISITOR%>
		                  </td>
			              <td >
			              		<table class="list2">
			              		<tr><td>
		                        <input type="radio" name="visitor" value="0" checked="checked">
			              		</td><td>
		                       	是		
		                        </td><td>
		                        <input type="radio" name="visitor" value="1">
		                        </td><td>
		                                                                否	
		                        </td></tr>
			              		</table>
		                        
		                           
		                  </td>
		                 <td colspan="4">
		                  <s:textfield size="80" label="%{@vs@ALIAS_VISITOR_INPUT}" key="visitorInput" value="%{model.visitorInput}"  cssClass="max-length-30" required="false" />
		                 </td>
		                
                         
                         
                   </tr>
                     <tr class="crosscolor_tr">
                      <td class="crosscolor_td">
			                      <%=Tpoliceche.ALIAS_DUTY%>
		                  </td>
			              <td >
		                        
		                        <table class="list2">
			              		<tr><td>
			              		 <input type="radio" name="duty" value="0" checked="checked">
			              		</td><td>
		                       	是		
		                        </td><td>
		                         <input type="radio" name="duty" value="1">
		                        </td><td>
		                                                                否	
		                        </td></tr>
			              		</table>  
		                  </td>
		                 <td colspan="4">
		                  <s:textfield size="80" label="%{@vs@ALIAS_DUTY_INPUT}" key="dutyInput" value="%{model.dutyInput}"  cssClass="max-length-30" required="false" />
		                 </td>  
                   </tr>
                   <tr class="crosscolor_tr">
                      <td class="crosscolor_td">
			                      <%=Tpoliceche.ALIAS_FINANCE%>
		                  </td>
			              <td >
		                        
		                       <table class="list2">
			              		<tr><td>
			              		 <input type="radio" name="finance" value="0" checked="checked">
			              		</td><td>
		                       	是		
		                        </td><td>
		                         <input type="radio" name="finance" value="1">
		                        </td><td>
		                                                                否	
		                        </td></tr>
			              		</table>  
		                  </td>
		                 <td colspan="4">
		                  <s:textfield size="80" label="%{@vs@ALIAS_FINANCE_INPUT}" key="financeInput" value="%{model.financeInput}"  cssClass="max-length-30" required="false" />
		                 </td>  
                   </tr>
                    <tr class="crosscolor_tr">
                      <td class="crosscolor_td">
			                      <%=Tpoliceche.ALIAS_SPEECH%>
		                  </td>
			              <td >
		                        
		                        <table class="list2">
			              		<tr><td>
			              		 <input type="radio" name="speech" value="0" checked="checked">
			              		</td><td>
		                       	是		
		                        </td><td>
		                         <input type="radio" name="speech" value="1">
		                        </td><td>
		                                                                否	
		                        </td></tr>
			              		</table> 
		                           
		                  </td>
		                 <td colspan="4">
		                  <s:textfield size="80" label="%{@vs@ALIAS_SPEECH_INPUT}" key="speechInput" value="%{model.speechInput}"  cssClass="max-length-30" required="false" />
		                 </td>  
                   </tr>
                      <tr class="crosscolor_tr">
                      <td class="crosscolor_td">
			                      <%=Tpoliceche.ALIAS_ENTERING%>
		                  </td>
			              <td >
		                        
		                        <table class="list2">
			              		<tr><td>
			              		 <input type="radio" name="entering" value="0" checked="checked">
			              		</td><td>
		                       	是		
		                        </td><td>
		                         <input type="radio" name="entering" value="1">
		                        </td><td>
		                                                                否	
		                        </td></tr>
			              		</table> 
		                           
		                  </td>
		                 <td colspan="4">
		                  <s:textfield size="80" label="%{@vs@ALIAS_ENTERING_INPUT}" key="enteringInput" value="%{model.enteringInput}"  cssClass="max-length-30" required="false" />
		                 </td>  
                   </tr>
                   
                   
                          <tr class="crosscolor_tr">
                      <td class="crosscolor_td">
			                      <%=Tpoliceche.ALIAS_SYSTEM_NORMAL_USE%>
		                  </td>
			              <td >
		                        
		                        <table class="list2">
			              		<tr><td>
			              		 <input type="radio" name="systemNormalUse" value="0" checked="checked">
			              		</td><td>
		                       	是		
		                        </td><td>
		                         <input type="radio" name="systemNormalUse" value="1">
		                        </td><td>
		                                                                否	
		                        </td></tr>
			              		</table> 
		                           
		                  </td>
		                 <td colspan="4">
		                  <s:textfield size="80" label="%{@vs@ALIAS_SYSTEM_INPUT}" key="systemInput" value="%{model.systemInput}"  cssClass="max-length-30" required="false" />
		                 </td>  
                   </tr>
                   
                        <tr class="crosscolor_tr">
                      <td class="crosscolor_td">
			                      <%=Tpoliceche.ALIAS_INTRADAYNEWS%>
		                  </td>
			              <td >
		                        
		                        <table class="list2">
			              		<tr><td>
			              		 <input type="radio" name="intradaynews" value="0" checked="checked">
			              		</td><td>
		                       	是		
		                        </td><td>
		                         <input type="radio" name="intradaynews" value="1">
		                        </td><td>
		                                                                否	
		                        </td></tr>
			              		</table> 
		                           
		                  </td>
		                 <td colspan="4">
		                  <s:textfield size="80" label="%{@vs@ALIAS_INTRADAYNEWS_INPUT}" key="intradaynewsInput" value="%{model.intradaynewsInput}"  cssClass="max-length-30" required="false" />
		                 </td>  
                   </tr>
		     
		     
		     
		        <tr class="crosscolor_tr">
                      <td class="crosscolor_td">
			                      <%=Tpoliceche.ALIAS_JDCMAINTAIN%>
		                  </td>
			              <td >
		                        
		                        <table class="list2">
			              		<tr><td>
			              		 <input type="radio" name="jdcmaintain" value="0" checked="checked">
			              		</td><td>
		                       	是		
		                        </td><td>
		                         <input type="radio" name="jdcmaintain" value="1">
		                        </td><td>
		                                                                否	
		                        </td></tr>
			              		</table> 
		                           
		                  </td>
		                 <td colspan="4">
		                  <s:textfield size="80" label="%{@vs@ALIAS_JDCMAINTAIN_INPUT}" key="jdcmaintainInput" value="%{model.jdcmaintainInput}"  cssClass="max-length-30" required="false" />
		                 </td>  
                   </tr>
                   
                   
                           <tr class="crosscolor_tr">
                      <td class="crosscolor_td">
			                      <%=Tpoliceche.ALIAS_UPLOADQUANTITYIS%>
		                  </td>
			              <td >
		                        
		                        <table class="list2">
			              		<tr><td>
			              		 <input type="radio" name="uploadquantityis" value="0" checked="checked">
			              		</td><td>
		                       	是		
		                        </td><td>
		                         <input type="radio" name="uploadquantityis" value="1">
		                        </td><td>
		                                                                否	
		                        </td></tr>
			              		</table> 
		                           
		                  </td>
		                 <td colspan="4">
		                  <s:textfield size="80" label="%{@vs@ALIAS_UPLOADQUANTITYI_INPUT}" key="uploadquantityiInput" value="%{model.uploadquantityiInput}"  cssClass="max-length-30" required="false" />
		                 </td>  
                   </tr>
                   
                   
                   
                          <tr class="crosscolor_tr">
                      <td class="crosscolor_td">
			                      <%=Tpoliceche.ALIAS_UPLOADTIMELY%>
		                  </td>
			              <td >
		                        
		                        <table class="list2">
			              		<tr><td>
			              		 <input type="radio" name="uploadtimely" value="0" checked="checked">
			              		</td><td>
		                       	是		
		                        </td><td>
		                         <input type="radio" name="uploadtimely" value="1">
		                        </td><td>
		                                                                否	
		                        </td></tr>
			              		</table> 
		                           
		                  </td>
		                 <td colspan="4">
		                  <s:textfield size="80" label="%{@vs@ALIAS_UPLOADTIMELY_INPUT}" key="uploadtimelyInput" value="%{model.uploadtimelyInput}"  cssClass="max-length-30" required="false" />
		                 </td>  
                   </tr>
                   
                   
                         <tr class="crosscolor_tr">
                      <td class="crosscolor_td">
			                      <%=Tpoliceche.ALIAS_SAFETY%>
		                  </td>
			              <td >
		                        
		                        <table class="list2">
			              		<tr><td>
			              		 <input type="radio" name="safety" value="0" checked="checked">
			              		</td><td>
		                       	是		
		                        </td><td>
		                         <input type="radio" name="safety" value="1">
		                        </td><td>
		                                                                否	
		                        </td></tr>
			              		</table> 
		                           
		                  </td>
		                 <td colspan="4">
		                  <s:textfield size="80" label="%{@vs@ALIAS_SAFETY_INPUT}" key="safetyInput" value="%{model.safetyInput}"  cssClass="max-length-30" required="false" />
		                 </td>  
                   </tr>
                       <tr class="crosscolor_tr">
                      <td class="crosscolor_td">
			                      <%=Tpoliceche.ALIAS_PROTECTION%>
		                  </td>
			              <td >
		                        
		                        <table class="list2">
			              		<tr><td>
			              		 <input type="radio" name="protection" value="0" checked="checked">
			              		</td><td>
		                       	是		
		                        </td><td>
		                         <input type="radio" name="protection" value="1">
		                        </td><td>
		                                                                否	
		                        </td></tr>
			              		</table> 
		                           
		                  </td>
		                 <td colspan="4">
		                  <s:textfield size="80" label="%{@vs@ALIAS_PROTECTION_INPUT}" key="protectionInput" value="%{model.protectionInput}"  cssClass="max-length-30" required="false" />
		                 </td>  
                   </tr>
		       
		       <tr class="crosscolor_tr">
		           
		            <td class="crosscolor_td">
			                      <%=Tpoliceche.ALIAS_DISPOSE%>
		                  </td>
			              <td>
			              <mytag:select property="%{model.dispose}"   styleClass=" validate-selection"  name="dispose"   notEmpty="false"  dictName="qlyj"/>
		                          
		                  </td>
		                  <td class="crosscolor_td">
			                      <%=Tpoliceche.ALIAS_DEADLINE%>
		                  </td>
			              <td colspan="3">
		                           <input value="${model.deadlineString}" onclick="WdatePicker({dateFmt:'<%=Tpoliceche.FORMAT_DEADLINE%>'})" id="deadlineString" name="deadlineString"  maxlength="0" class="Wdate" />
		                  </td>
                         
                         
                   </tr>
                   <tr class="crosscolor_tr">
		           
		            <td class="crosscolor_td">
			                      <%=Tpoliceche.ALIAS_REMARK%><br/>
			                       <FONT color="red">民警现场检查时如发现其他情况，可在备注注明。</FONT>
		                  </td>
			           
 <td colspan="5" align="left" >
		                           <s:textarea style=" margin-left:10px" label="%{@vs@ALIAS_REMARK}" rows="6" cols="55"
							key="remark" value="%{model.remark}" cssClass="max-length-300"
							required="false"></s:textarea>
		                         
		                                  
 </td>
		                
                         
                         
                   </tr>
		       
		           <tr class="crosscolor_tr">
		            <td class="crosscolor_td">
			                      <%=Tpoliceche.ALIAS_CHECKTIME%>
		                  </td>
			              <td colspan="5">
		                         <input value="${model.checktimeString}" onclick="WdatePicker({dateFmt:'<%=Tpoliceche.FORMAT_CHECKTIME%>'})" id="checktimeString" name="checktimeString"  disabled="disabled" maxlength="0" class="required Wdate" />
		                  <input type="hidden" value="${model.checktimeString}" id ="checktime" name = "checktime" />
		                  </td>
                   </tr>
 
 
