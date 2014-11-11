<%@page import="com.dyneinfo.pmdd.model.*" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/commons/taglibs.jsp" %>

	<s:hidden id="dnumber" name="dnumber" />

<!-- ONGL access static field: @package.class@field or @vs@field -->

		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                     <FONT color="red">*</FONT> <%=Clzydd.ALIAS_HTID%>
		                  </td>
			              <td>
		                           <s:textfield label="%{@vs@ALIAS_HTID}" key="htid" value="%{model.htid}"  cssClass="required max-length-50 " required="false" />
		                  </td>
                          <td class="crosscolor_td">
			                     <FONT color="red">*</FONT> <%=Clzydd.ALIAS_SQR%>
		                  </td>
			              <td>
		                           <s:textfield label="%{@vs@ALIAS_SQR}" key="sqr" value="%{model.sqr}"  cssClass="required max-length-30 " required="false" />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                     <FONT color="red">*</FONT> <%=Clzydd.ALIAS_ZJHM%>
		                  </td>
			              <td>
		                           <s:textfield label="%{@vs@ALIAS_ZJHM}" key="zjhm" value="%{model.zjhm}"  cssClass="required max-length-30 validate-id-number" required="false" />
		                  </td>
		                  <td class="crosscolor_td">
			                      <%=Clzydd.ALIAS_LXDH%>
		                  </td>
			              <td>
		                           <s:textfield label="%{@vs@ALIAS_LXDH}" key="lxdh" value="%{model.lxdh}"  cssClass="max-length-20 " required="false" />
		                  </td>
                          
                   </tr>
                    <tr class="crosscolor_tr">
                         <td class="crosscolor_td">
			                      <%=Clzydd.ALIAS_GZDW%>
		                  </td>
			              <td colspan="3">
		                           <s:textfield label="%{@vs@ALIAS_GZDW}" size="80" key="gzdw" value="%{model.gzdw}"  cssClass="max-length-60 " required="false" />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          
                          <td class="crosscolor_td">
			                      <%=Clzydd.ALIAS_DZ%>
		                  </td>
			               <td colspan="3">
		                           <s:textfield label="%{@vs@ALIAS_DZ}" size="80" key="dz" value="%{model.dz}"  cssClass="max-length-120 " required="false" />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                     <FONT color="red">*</FONT> <%=Clzydd.ALIAS_CPHM%>
		                  </td>
			              <td>
		                           <s:textfield label="%{@vs@ALIAS_CPHM}" key="cphm" value="%{model.cphm}"  cssClass="required max-length-15 " required="false" />
		                  </td>
                          <td class="crosscolor_td">
			                     <FONT color="red">*</FONT> <%=Clzydd.ALIAS_CZMC%>
		                  </td>
			              <td>
		                           <s:textfield label="%{@vs@ALIAS_CZMC}" key="czmc" value="%{model.czmc}"  cssClass="required max-length-60 " required="false" />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                    <FONT color="red">*</FONT>  <%=Clzydd.ALIAS_FDJH%>
		                  </td>
			              <td>
		                           <s:textfield label="%{@vs@ALIAS_FDJH}" key="fdjh" value="%{model.fdjh}"  cssClass="required max-length-30 " required="false" />
		                  </td>
                          <td class="crosscolor_td">
			                     <FONT color="red">*</FONT> <%=Clzydd.ALIAS_SCCJ%>
		                  </td>
			              <td>
		                           <s:textfield label="%{@vs@ALIAS_SCCJ}" key="sccj" value="%{model.sccj}"  cssClass="required max-length-60 " required="false" />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                     <FONT color="red">*</FONT> <%=Clzydd.ALIAS_CJHM%>
		                  </td>
			              <td>
		                           <s:textfield label="%{@vs@ALIAS_CJHM}" key="cjhm" value="%{model.cjhm}"  cssClass="required max-length-30 " required="false" />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=Clzydd.ALIAS_CSYS%>
		                  </td>
			              <td>
		                           <s:textfield label="%{@vs@ALIAS_CSYS}" key="csys" value="%{model.csys}"  cssClass="max-length-20 " required="false" />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <FONT color="red">*</FONT>  <%=Clzydd.ALIAS_CLXH%>
		                  </td>
			              <td>
						           <mytag:select property="%{model.clxh}"   styleClass="required validate-selection"  name="clxh"   notEmpty="false"  dictName="clxh"/>
		                  </td>
                          <td class="crosscolor_td">
			                      <%=Clzydd.ALIAS_YXSGLS%>
		                  </td>
			              <td>
		                           <s:textfield label="%{@vs@ALIAS_YXSGLS}" key="yxsgls" value="%{model.yxsgls}"  cssClass="max-length-8 " required="false" />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=Clzydd.ALIAS_FRDB%>
		                  </td>
			              <td>
		                           <s:textfield label="%{@vs@ALIAS_FRDB}" key="frdb" value="%{model.frdb}"  cssClass="max-length-30 " required="false" />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=Clzydd.ALIAS_DDLX%>
		                  </td>
			              <td>
						           <mytag:select property="%{model.ddlx}"   styleClass="required validate-selection"  name="ddlx"   notEmpty="false"  dictName="ddlb"/>
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=Clzydd.ALIAS_DDQX%>
		                  </td>
			              <td>
		                           <s:textfield label="%{@vs@ALIAS_DDQX}" key="ddqx" value="%{model.ddqx}"  cssClass="max-length-8 validate-integer" required="false" />
		                  </td>
		                   
                          <td class="crosscolor_td">
			                      <%=Clzydd.ALIAS_DDRQ%>
		                  </td>
			              <td>
						           <input value="${model.ddrq}" onclick="WdatePicker({dateFmt:'yyyy-MM-dd'})" id="ddrq" name="ddrq"  maxlength="0" class="required Wdate" />
		                  </td>
                          
                   </tr>
                   
                    <tr class="crosscolor_tr">
                         <td class="crosscolor_td">
			                      <%=Clzydd.ALIAS_DWMS%>
		                  </td>
			              <td colspan="3">
		                           <s:textfield label="%{@vs@ALIAS_DWMS}" key="dwms" size="80" value="%{model.dwms}"  cssClass="max-length-255 " required="false" />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=Clzydd.ALIAS_REMARK%>
		                  </td>
			              <td colspan="3">
		                          
		                             <s:textarea label="%{@vs@ALIAS_REMARK}" rows="4" cols="62"
							key="remark" value="%{model.remark}" cssClass="max-length-120"
							required="false"></s:textarea>
		                  </td>
                         
                   </tr>
		          
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=Clzydd.ALIAS_LRRQ%>
		                  </td>
			              <td>
						           <input value="${model.lrrq}" onclick="WdatePicker({dateFmt:'yyyy-MM-dd'})" id="lrrq" name="lrrq"  maxlength="0" class="required Wdate" />
		                  </td>
                          <td class="crosscolor_td">
			                     <FONT color="red">*</FONT> <%=Clzydd.ALIAS_SDR%>
		                  </td>
			              <td>
		                           <s:textfield label="%{@vs@ALIAS_SDR}" key="sdr" value="%{model.sdr}"  cssClass="required max-length-30 " required="false" />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=Clzydd.ALIAS_TIB_FLOWGUID%>
		                  </td>
			              <td>
		                           <s:textfield label="%{@vs@ALIAS_TIB_FLOWGUID}" key="tibFlowguid" value="%{model.tibFlowguid}"  cssClass="max-length-32 " required="false" />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=Clzydd.ALIAS_TIB_ROWGUID%>
		                  </td>
			              <td>
		                           <s:textfield label="%{@vs@ALIAS_TIB_ROWGUID}" key="tibRowguid" value="%{model.tibRowguid}"  cssClass="max-length-32 " required="false" />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <FONT color="red">*</FONT><%=Clzydd.ALIAS_OPTIME%>
		                  </td>
			              <td>
		                           <s:textfield label="%{@vs@ALIAS_OPTIME}" key="optime" value="%{model.optime}"  cssClass="required max-length-17 " required="true" />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=Clzydd.ALIAS_SQDDJE%>
		                  </td>
			              <td>
		                           <s:textfield label="%{@vs@ALIAS_SQDDJE}" key="sqddje" value="%{model.sqddje}"  cssClass="validate-number  validate-digits" required="false" />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=Clzydd.ALIAS_YXZJ%>
		                  </td>
			              <td>
		                           <s:textfield label="%{@vs@ALIAS_YXZJ}" key="yxzj" value="%{model.yxzj}"  cssClass="max-length-30 " required="false" />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=Clzydd.ALIAS_FLAG%>
		                  </td>
			              <td>
						           <mytag:select property="%{model.flag}"   styleClass="required validate-selection"  name="flag"   notEmpty="false"  dictName="fcdyddFlag"/>
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=Clzydd.ALIAS_LB%>
		                  </td>
			              <td>
						           <mytag:select property="%{model.lb}"   styleClass="required validate-selection"  name="lb"   notEmpty="false"  dictName="clzylb"/>
		                  </td>
                          <td class="crosscolor_td">
			                      <%=Clzydd.ALIAS_SFSH%>
		                  </td>
			              <td>
						           <mytag:select property="%{model.sfsh}"   styleClass="required validate-selection"  name="sfsh"   notEmpty="false"  dictName="shiFou"/>
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=Clzydd.ALIAS_DDRYZP%>
		                  </td>
			              <td>
		                           <s:textfield label="%{@vs@ALIAS_DDRYZP}" key="ddryzp" value="%{model.ddryzp}"  cssClass=" " required="false" />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=Clzydd.ALIAS_DWZP%>
		                  </td>
			              <td>
		                           <s:textfield label="%{@vs@ALIAS_DWZP}" key="dwzp" value="%{model.dwzp}"  cssClass=" " required="false" />
		                  </td>
                   </tr>
 
 
