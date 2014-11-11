<%@page import="com.dyneinfo.fjy.model.*" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/commons/taglibs.jsp" %>

	<s:hidden id="telinfoid" name="telinfoid" />

<!-- ONGL access static field: @package.class@field or @vs@field -->

		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <FONT color="red">*</FONT>  <%=TelInfo.ALIAS_TELPP%>
		                  </td>
			              <td>
						            <s:doubleselect name="telpp" list="provList" listKey="id"  
								listValue="name" doubleName="telxh"  
								value="#request.defaultItem"
								doubleValue="#request.doubleDefaultItem" 
								doubleList="cityMap.get(top.id)" doubleListKey="id"
								doubleListValue="name" theme="simple" />
		                  </td>
		                  <td class="crosscolor_td">
			                      <%=TelInfo.ALIAS_TELYS%>
		                  </td>
			              <td>
						           <mytag:select property="%{model.telys}"     name="telys"   notEmpty="false"  dictName="T_DIC_SJYS"/>
		                  </td>
                         
                   </tr>
		           <tr class="crosscolor_tr">
                          
                          <td class="crosscolor_td">
			                       <FONT color="red">*</FONT> <%=TelInfo.ALIAS_JXXLH%>
		                  </td>
			              <td>
		                           <s:textfield label="%{@vs@ALIAS_JXXLH}" key="jxxlh" value="%{model.jxxlh}"  cssClass="required max-length-15" required="false" />
		                  </td>
		                  <td class="crosscolor_td">
			                      <FONT color="red">*</FONT><%=TelInfo.ALIAS_SJLB%>
		                  </td>
			              <td>
						           <mytag:select property="%{model.sjlb}"   styleClass="required validate-selection"  name="sjlb"   notEmpty="false"  dictName="T_DIC_SJLB"/>
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          
                          <td class="crosscolor_td">
			                      <%=TelInfo.ALIAS_BZ%>
		                  </td>
			              <td colspan="3">
		                          
		                            <s:textarea label="%{@vs@ALIAS_BZ}" rows="4" cols="55"
							key="bz" value="%{model.bz}" cssClass="max-length-100"
							required="false"></s:textarea>
		                 
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          
                          <td class="crosscolor_td">
			                      <FONT color="red">*</FONT><%=TelInfo.ALIAS_CHUSHOURY%>
		                  </td>
			              <td>
	                               <s:textfield label="%{@vs@ALIAS_CHUSHOURY}" key="chushoury" value="%{model.chushoury}"  cssClass="required max-length-30 validate-chinese" required="false" />
		                  </td>
		                    <td class="crosscolor_td">
			                      <%=TelInfo.ALIAS_CHUSHOURENXB%>
		                  </td>
			              <td>
						           <mytag:select property="%{model.chushourenxb}"   styleClass="validate-selection"  name="chushourenxb"   notEmpty="false"  dictName="T_DIC_SEX"/>
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                        
                          <td class="crosscolor_td">
			                      <FONT color="red">*</FONT>  <%=TelInfo.ALIAS_CHUSHOURENSFZH%>
		                  </td>
			              <td>
	                               <s:textfield label="%{@vs@ALIAS_CHUSHOURENSFZH}" onblur="javascript:showBirthday();" key="chushourensfzh" value="%{model.chushourensfzh}"  cssClass="required max-length-18 validate-id-number" required="false" />
		                  </td>
		                  <td class="crosscolor_td">
			                      <%=TelInfo.ALIAS_CHUSHOURENLXDH%>
		                  </td>
			              <td>
		                           <s:textfield label="%{@vs@ALIAS_CHUSHOURENLXDH}" key="chushourenlxdh" value="%{model.chushourenlxdh}"  cssClass="max-length-30" required="false" />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=TelInfo.ALIAS_BEIZHU%>
		                  </td>
			              <td colspan="3">
			                       <s:textarea label="%{@vs@ALIAS_BEIZHU}" rows="4" cols="55"
							key="beizhu" value="%{model.beizhu}" cssClass="max-length-200"
							required="false"></s:textarea>
		                         
		                  </td>
                          
                   </tr>
		           <tr class="crosscolor_tr">
                         
                          <td class="crosscolor_td">
			                      <%=TelInfo.ALIAS_DQSJH%>
		                  </td>
			              <td>
	                               <s:textfield label="%{@vs@ALIAS_DQSJH}" key="dqsjh" value="%{model.dqsjh}"  cssClass="max-length-11 validate-mobile-phone" required="false" />
		                  </td>
		                   <td class="crosscolor_td">
			                      <%=TelInfo.ALIAS_CSRDH%>
		                  </td>
			              <td>
	                               <s:textfield label="%{@vs@ALIAS_CSRDH}" key="csrdh" value="%{model.csrdh}"  cssClass="max-length-30 validate-phone" required="false" />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=TelInfo.ALIAS_CSRJTZZ%>
		                  </td>
			              <td colspan="3">
		                           <s:textfield label="%{@vs@ALIAS_CSRJTZZ}" key="csrjtzz" size="60" value="%{model.csrjtzz}"  cssClass="max-length-100" required="false" />
		                  </td>
                         
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=TelInfo.ALIAS_GJSJ%>
		                  </td>
			              <td>
						           <input value="${model.gjsj}" onclick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss'})" id="gjsj" name="gjsj"  maxlength="0" class="Wdate" />
		                  </td>
                          <td class="crosscolor_td">
			                     <FONT color="red">*</FONT> <%=TelInfo.ALIAS_JBR%>
		                  </td>
			              <td>
			              
		                         
		                          <s:textfield label="%{@vs@ALIAS_FULLNAME}" key="fullname" value="%{model.fullname}" maxlength="0"  cssClass="max-length-30" required="false" />
		                            <s:hidden name="jbr" value="%{model.jbr}"></s:hidden>
		                            <input name="selectOrg" onclick="selectPerson(inputForm,'fullname','jbr')"   value="选择"type="button"> 
		                            
		                  </td>
                   </tr>
 
 
