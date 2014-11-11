<%@page import="com.dyneinfo.fjy.model.*" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/commons/taglibs.jsp" %>

	<s:hidden id="dnid" name="dnid" />

<!-- ONGL access static field: @package.class@field or @vs@field -->

		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                     <FONT color="red">*</FONT>  <%=Tesdd.ALIAS_DDLX%>
		                  </td>
			              <td>
						           <mytag:select property="%{model.ddlx}"   styleClass="required validate-selection"  name="ddlx"   notEmpty="false"  dictName="T_DIC_JQLX"/>
		                  </td>
                          <td class="crosscolor_td">
			                      <FONT color="red">*</FONT> <%=Tesdd.ALIAS_DNPP%>
		                  </td>
			              <td>
		                           <s:textfield label="%{@vs@ALIAS_DNPP}" key="dnpp" value="%{model.dnpp}"  cssClass="required max-length-50" required="false" />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <FONT color="red">*</FONT> <%=Tesdd.ALIAS_DNXH%>
		                  </td>
			              <td>
		                           <s:textfield label="%{@vs@ALIAS_DNXH}" key="dnxh" value="%{model.dnxh}"  cssClass="required max-length-50" required="false" />
		                  </td>
                          <td class="crosscolor_td">
			                       <FONT color="red">*</FONT><%=Tesdd.ALIAS_ZBH%>
		                  </td>
			              <td>
		                           <s:textfield label="%{@vs@ALIAS_ZBH}" key="zbh" value="%{model.zbh}"  cssClass="required max-length-15" required="false" />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                       <FONT color="red">*</FONT><%=Tesdd.ALIAS_YPH%>
		                  </td>
			              <td>
		                           <s:textfield label="%{@vs@ALIAS_YPH}" key="yph" value="%{model.yph}"  cssClass="required max-length-15" required="false" />
		                  </td>
		                   <td class="crosscolor_td">
			                     <FONT color="red">*</FONT> <%=Tesdd.ALIAS_MACDZ%>
		                  </td>
			              <td>
		                           <s:textfield label="%{@vs@ALIAS_MACDZ}" key="macdz" value="%{model.macdz}"  cssClass="required max-length-15" required="false" />
		                  </td>
                         
                   </tr>
                    <tr class="crosscolor_tr">
                         
		                   <td class="crosscolor_td">
			                      <%=Tesdd.ALIAS_ZC%>
		                  </td>
			              <td>
		                           <s:textfield label="%{@vs@ALIAS_ZC}" key="zc" value="%{model.zc}"  cssClass="max-length-15" required="false" />
		                  </td>
		                  <td class="crosscolor_td">
			                      <%=Tesdd.ALIAS_GMSJ%>
		                  </td>
			              <td>
						           <input value="${model.gmsj}" onclick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss'})" id="gmsj" name="gmsj"  maxlength="0" class=" Wdate" />
		                  </td>
                         
                   </tr>
		           <tr class="crosscolor_tr">
                        
                          <td class="crosscolor_td">
			                    <FONT color="red">*</FONT>  <%=Tesdd.ALIAS_CHUSHOURY%>
		                  </td>
			              <td>
	                               <s:textfield label="%{@vs@ALIAS_CHUSHOURY}" key="chushoury" value="%{model.chushoury}"  cssClass="required max-length-30 validate-chinese" required="false" />
		                  </td>
                  
                          <td class="crosscolor_td">
			                    <FONT color="red">*</FONT>  <%=Tesdd.ALIAS_CHUSHOURENXB%>
		                  </td>
			              <td>
						           <mytag:select property="%{model.chushourenxb}"   styleClass="required validate-selection"  name="chushourenxb"   notEmpty="false"  dictName="T_DIC_SEX"/>
		                  </td>
		             </tr>
		           <tr class="crosscolor_tr">      
                          <td class="crosscolor_td">
			                     <FONT color="red">*</FONT> <%=Tesdd.ALIAS_CHUSHOURENSFZH%>
		                  </td>
			              <td>
	                               <s:textfield label="%{@vs@ALIAS_CHUSHOURENSFZH}" key="chushourensfzh" value="%{model.chushourensfzh}"  cssClass="required max-length-18 validate-id-number" required="false" />
		                  </td>
                 
                         
                          <td class="crosscolor_td">
			                      <%=Tesdd.ALIAS_CHUSHOURENLXDH%>
		                  </td>
			              <td>
	                               <s:textfield label="%{@vs@ALIAS_CHUSHOURENLXDH}" key="chushourenlxdh" value="%{model.chushourenlxdh}"  cssClass="max-length-30 validate-number" required="false" />
		                  </td>
		                   
                   </tr>
                    <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=Tesdd.ALIAS_BEIZHU%>
		                  </td>
			              <td colspan="3">
		                          <s:textarea label="%{@vs@ALIAS_BEIZHU}" rows="4" cols="55"
							key="beizhu" value="%{model.beizhu}" cssClass="max-length-200"
							required="false"></s:textarea>
		                           </td>
                         
                   </tr>

		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=Tesdd.ALIAS_DQSJH%>
		                  </td>
			              <td>
	                               <s:textfield label="%{@vs@ALIAS_DQSJH}" key="dqsjh" value="%{model.dqsjh}"  cssClass="max-length-11 validate-number" required="false" />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=Tesdd.ALIAS_CSRJTZZ%>
		                  </td>
			              <td>
		                           <s:textfield label="%{@vs@ALIAS_CSRJTZZ}" key="csrjtzz" value="%{model.csrjtzz}"  cssClass="max-length-100" required="false" />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=Tesdd.ALIAS_CSRDH%>
		                  </td>
			              <td>
	                               <s:textfield label="%{@vs@ALIAS_CSRDH}" key="csrdh" value="%{model.csrdh}"  cssClass="max-length-30 validate-number" required="false" />
		                  </td>
                          
		                  
		                   <td class="crosscolor_td">
			                      <%=Tesdd.ALIAS_SGSJ%>
		                  </td>
			              <td>
						           <input value="${model.sgsj}" onclick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss'})" id="sgsj" name="sgsj"  maxlength="0" class=" Wdate" />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=Tesdd.ALIAS_JBR%>
		                  </td>
			              <td>
	                               <s:textfield label="%{@vs@ALIAS_JBR}" key="jbr" value="%{model.jbr}"  cssClass="max-length-30 validate-chinese" required="false" />
		                  </td>
                         <td class="crosscolor_td">
			                      <%=Tesdd.ALIAS_CPCODE%>
		                  </td>
			              <td>
		                           <s:textfield label="%{@vs@ALIAS_CPCODE}" key="cpcode" value="%{model.cpcode}"  cssClass="max-length-10" required="false" />
		                  </td>
                   </tr>
 
 
