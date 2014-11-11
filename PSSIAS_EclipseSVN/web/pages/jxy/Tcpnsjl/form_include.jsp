<%@page import="com.dyneinfo.jxy.model.*" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/commons/taglibs.jsp" %>



		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <FONT color="red">*</FONT><%=Tcpnsjl.ALIAS_CPCODE%>
		                  </td>
			              <td>
		                           <s:textfield readonly="true" label="%{@vs@ALIAS_CPCODE}" key="cpcode" value="%{model.cpcode}"  cssClass="required max-length-13" required="true" />
		                 <input name="selectPersons" onclick="selectEmp()"   value="选择" type="button">
						 </td>
                          <td class="crosscolor_td">
			                      <FONT color="red">*</FONT><%=Tcpnsjl.ALIAS_SHND%>
		                  </td>
			              <td>
			               <select name="shnd">
                  <s:iterator var="counter" begin="2001" end="2030" > <option value="${counter}">${counter}</option> </s:iterator> 
                  </select>
		                        
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <FONT color="red">*</FONT><%=Tcpnsjl.ALIAS_SHRJ%>
		                  </td>
			              <td>
		                          
		                 <input value="${model.shrj}" onclick="WdatePicker({dateFmt:'yyyy-MM-dd',maxDate:'${date}'})"   name="shrj" id="shrj" class="required Wdate" />
		                 
		                  </td>
                        
                   </tr>
                   <tr class="crosscolor_tr">
                   <td class="crosscolor_td">
			                      <FONT color="red">*</FONT><%=Tcpnsjl.ALIAS_NSYJ%>
		                  </td>
                    <td colspan="3">
			                <s:textarea label="%{@vs@ALIAS_CASEDESC}" rows="6" cols="55"
							key="nsyj" value="%{model.nsyj}" cssClass="required max-length-3000"
							required="false"></s:textarea>
		                         
		                       
		                  </td>
                   
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                     <FONT color="red">*</FONT> <%=Tcpnsjl.ALIAS_QSR%>
		                  </td>
			              <td>
			            
		                           <s:textfield label="%{@vs@ALIAS_QSR}" key="qsr" value="%{model.qsr}"  cssClass="required validate-chinese" required="false" />
		                  </td>
                          <td class="crosscolor_td">
			                     <FONT color="red">*</FONT> <%=Tcpnsjl.ALIAS_JBR%>
		                  </td>
			              <td>
		                           <s:textfield label="%{@vs@ALIAS_JBR}" key="jbr" value="%{model.jbr}"  cssClass="required validate-chinese" required="false" />
		                  </td>
                   </tr>
                   <tr class="crosscolor_tr">
                   
                   </tr>
 
 
