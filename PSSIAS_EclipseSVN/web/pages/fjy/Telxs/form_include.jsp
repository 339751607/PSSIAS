<%@page import="com.dyneinfo.fjy.model.*" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/commons/taglibs.jsp" %>

	<s:hidden id="telinfoid" value="%{model.telinfoid}"   name="telinfoid" />

<!-- ONGL access static field: @package.class@field or @vs@field -->

		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <FONT color="red">*</FONT><%=Telxs.ALIAS_GMRXM%>
		                  </td>
			              <td>
	                               <s:textfield label="%{@vs@ALIAS_GMRXM}" key="gmrxm" value="%{model.gmrxm}"  cssClass="required max-length-30 validate-chinese" required="true" />
		                  </td>
                          <td class="crosscolor_td">
			                      <FONT color="red">*</FONT><%=Telxs.ALIAS_GMRXB%>
		                  </td>
			              <td>
						           <mytag:select property="%{model.gmrxb}"   styleClass="required validate-selection"  name="gmrxb"   notEmpty="false"  dictName="T_DIC_SEX"/>
		                  
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          
                          <td class="crosscolor_td">
			                      <FONT color="red">*</FONT><%=Telxs.ALIAS_GMRLXDH%>
		                  </td>
			              <td>
	                               <s:textfield label="%{@vs@ALIAS_GMRLXDH}" key="gmrlxdh" value="%{model.gmrlxdh}"  cssClass="required max-length-30 validate-alphanum" required="true" />
		                  </td>
		                  <td class="crosscolor_td">
			                      <%=Telxs.ALIAS_GMRSFZH%>
		                  </td>
			              <td>
	                               <s:textfield label="%{@vs@ALIAS_GMRSFZH}" onblur="javascript:showBirthday();"  key="gmrsfzh" value="%{model.gmrsfzh}"  cssClass="max-length-18 validate-id-number" required="false" />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=Telxs.ALIAS_GMRJTZZ%>
		                  </td>
			              <td colspan="3">
		                           <s:textfield label="%{@vs@ALIAS_GMRJTZZ}" key="gmrjtzz" size="70" value="%{model.gmrjtzz}"  cssClass="max-length-100" required="false" />
		                  </td>
                        
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=Telxs.ALIAS_BZ%>
		                  </td>
			               <td colspan="3">
			               
			               <s:textarea label="%{@vs@ALIAS_BZ}" rows="4" cols="55"
							key="bz" value="%{model.bz}" cssClass="max-length-200"
							required="false"></s:textarea>
		                          
		                  </td>
                         
                   </tr>
                   
 
