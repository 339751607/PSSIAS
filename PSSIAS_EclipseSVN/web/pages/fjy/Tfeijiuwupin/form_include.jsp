<%@page import="com.dyneinfo.fjy.model.*" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/commons/taglibs.jsp" %>

	<s:hidden id="wupinxh" name="wupinxh" />

<!-- ONGL access static field: @package.class@field or @vs@field -->

		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <FONT color="red">*</FONT><%=Tfeijiuwupin.ALIAS_WUPINMC%>
		                  </td>
			              <td>
		                           <s:textfield label="%{@vs@ALIAS_WUPINMC}" key="wupinmc" value="%{model.wupinmc}"  cssClass="required max-length-100" required="true" />
		                  </td>
                          <td class="crosscolor_td">
			                      <FONT color="red">*</FONT><%=Tfeijiuwupin.ALIAS_WUPINLB%>
		                  </td>
			              <td>
						           <mytag:select property="%{model.wupinlb}"   styleClass="required validate-selection"  name="wupinlb"   notEmpty="false"  dictName="T_DIC_WUPINLB"/>
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                     <FONT color="red">*</FONT> <%=Tfeijiuwupin.ALIAS_SHOUGOURQ%>
		                  </td>
			              <td>
						           <input value="${model.shougourq}" onclick="WdatePicker({dateFmt:'yyyy-MM-dd'})" id="shougourq" name="shougourq"  maxlength="0" class="required Wdate" />
		                  </td>
		                   <td class="crosscolor_td">
			                      <%=Tfeijiuwupin.ALIAS_SGR%>
		                  </td>
			              <td>
	                               <s:textfield label="%{@vs@ALIAS_SGR}" key="sgr" value="%{model.sgr}"  cssClass="max-length-30 validate-chinese" required="false" />
		                  </td>
                         
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=Tfeijiuwupin.ALIAS_CHUSHOURY%>
		                  </td>
			              <td>
	                               <s:textfield label="%{@vs@ALIAS_CHUSHOURY}" key="chushoury" value="%{model.chushoury}"  cssClass="max-length-30 validate-chinese" required="false" />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=Tfeijiuwupin.ALIAS_CHUSHOURENXB%>
		                  </td>
			              <td>
						           <mytag:select property="%{model.chushourenxb}"   styleClass="required validate-selection"  name="chushourenxb"   notEmpty="false"  dictName="T_DIC_SEX"/>
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=Tfeijiuwupin.ALIAS_CHUSHOURENSFZH%>
		                  </td>
			              <td>
	                               <s:textfield label="%{@vs@ALIAS_CHUSHOURENSFZH}" key="chushourensfzh" value="%{model.chushourensfzh}"  cssClass="max-length-18 validate-id-number" required="false" />
		                  </td>
		                    <td class="crosscolor_td">
			                      <%=Tfeijiuwupin.ALIAS_CHUSHOURENLXDH%>
		                  </td>
			              <td>
	                               <s:textfield label="%{@vs@ALIAS_CHUSHOURENLXDH}" key="chushourenlxdh" value="%{model.chushourenlxdh}"  cssClass="max-length-30 validate-number" required="false" />
		                  </td>
                         
                   </tr>
                    <tr class="crosscolor_tr">
                         
                          <td class="crosscolor_td">
			                      <%=Tfeijiuwupin.ALIAS_BEIZHU%>
		                  </td>
			              <td colspan="3">
		                          
		                  <s:textarea label="%{@vs@ALIAS_BEIZHU}" rows="4" cols="55"
							key="beizhu" value="%{model.beizhu}" cssClass="max-length-200"
							required="false"></s:textarea>
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                        
                          <td class="crosscolor_td">
			                      <%=Tfeijiuwupin.ALIAS_ISKEYI%>
		                  </td>
			              <td>
						           <mytag:select property="%{model.iskeyi}"     name="iskeyi"   notEmpty="false"  dictName="shiFou"/>
		                  </td>
                  
                         
                          <td class="crosscolor_td">
			                      <%=Tfeijiuwupin.ALIAS_JBR%>
		                  </td>
			              <td>
	                               <s:textfield label="%{@vs@ALIAS_JBR}" key="jbr" value="%{model.jbr}"  cssClass="max-length-30 validate-chinese" required="false" />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=Tfeijiuwupin.ALIAS_JBRSFZH%>
		                  </td>
			              <td>
	                               <s:textfield label="%{@vs@ALIAS_JBRSFZH}" key="jbrsfzh" value="%{model.jbrsfzh}"  cssClass="max-length-18 validate-id-number" required="false" />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=Tfeijiuwupin.ALIAS_JBRLXDH%>
		                  </td>
			              <td>
	                               <s:textfield label="%{@vs@ALIAS_JBRLXDH}" key="jbrlxdh" value="%{model.jbrlxdh}"  cssClass="max-length-50 validate-number" required="false" />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=Tfeijiuwupin.ALIAS_SGWPSL%>
		                  </td>
			              <td>
	                               <s:textfield label="%{@vs@ALIAS_SGWPSL}" key="sgwpsl" value="%{model.sgwpsl}"  cssClass="validate-integer max-value-2147483647 validate-id-number" required="false" />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=Tfeijiuwupin.ALIAS_SGWPGG%>
		                  </td>
			              <td>
		                           <s:textfield label="%{@vs@ALIAS_SGWPGG}" key="sgwpgg" value="%{model.sgwpgg}"  cssClass="max-length-50" required="false" />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                         
		                  
		                   <td class="crosscolor_td">
			                      <%=Tfeijiuwupin.ALIAS_SHOUGOURY%>
		                  </td>
			              <td>
		                           <s:textfield label="%{@vs@ALIAS_SHOUGOURY}" key="shougoury" value="%{model.shougoury}"  cssClass="max-length-26" required="false" />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=Tfeijiuwupin.ALIAS_SGRLXDH%>
		                  </td>
			              <td>
	                               <s:textfield label="%{@vs@ALIAS_SGRLXDH}" key="sgrlxdh" value="%{model.sgrlxdh}"  cssClass="max-length-50 validate-number" required="false" />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=Tfeijiuwupin.ALIAS_WPYS%>
		                  </td>
			              <td>
						           <mytag:select property="%{model.wpys}"     name="wpys"   notEmpty="false"  dictName="T_DIC_SJYS"/>
		                  </td>
                          <td class="crosscolor_td">
			                      <%=Tfeijiuwupin.ALIAS_WPPP%>
		                  </td>
			              <td>
		                           <s:textfield label="%{@vs@ALIAS_WPPP}" key="wppp" value="%{model.wppp}"  cssClass="max-length-50" required="false" />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=Tfeijiuwupin.ALIAS_WPXZ%>
		                  </td>
			              <td>
		                           <s:textfield label="%{@vs@ALIAS_WPXZ}" key="wpxz" value="%{model.wpxz}"  cssClass="max-length-10" required="false" />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=Tfeijiuwupin.ALIAS_WPSF%>
		                  </td>
			              <td>
		                           <s:textfield label="%{@vs@ALIAS_WPSF}" key="wpsf" value="%{model.wpsf}"  cssClass="max-length-50" required="false" />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=Tfeijiuwupin.ALIAS_WPDX%>
		                  </td>
			              <td>
		                           <s:textfield label="%{@vs@ALIAS_WPDX}" key="wpdx" value="%{model.wpdx}"  cssClass="max-length-10" required="false" />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=Tfeijiuwupin.ALIAS_WPZL%>
		                  </td>
			              <td>
	                               <s:textfield label="%{@vs@ALIAS_WPZL}" key="wpzl" value="%{model.wpzl}"  cssClass="validate-integer max-value-2147483647 validate-digits" required="false" />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=Tfeijiuwupin.ALIAS_WPBZ%>
		                  </td>
			              <td>
		                           <s:textfield label="%{@vs@ALIAS_WPBZ}" key="wpbz" value="%{model.wpbz}"  cssClass="max-length-30" required="false" />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=Tfeijiuwupin.ALIAS_WPTZ%>
		                  </td>
			              <td>
		                           <s:textfield label="%{@vs@ALIAS_WPTZ}" key="wptz" value="%{model.wptz}"  cssClass="max-length-50" required="false" />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=Tfeijiuwupin.ALIAS_WPCD%>
		                  </td>
			              <td>
		                           <s:textfield label="%{@vs@ALIAS_WPCD}" key="wpcd" value="%{model.wpcd}"  cssClass="max-length-100" required="false" />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=Tfeijiuwupin.ALIAS_CPCODE%>
		                  </td>
			              <td>
		                           <s:textfield label="%{@vs@ALIAS_CPCODE}" key="cpcode" value="%{model.cpcode}"  cssClass="max-length-15" required="false" />
		                  </td>
                   </tr>
 
 
