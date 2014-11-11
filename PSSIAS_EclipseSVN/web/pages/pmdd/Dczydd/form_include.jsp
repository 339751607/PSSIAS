<%@page import="com.dyneinfo.pmdd.model.*" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/commons/taglibs.jsp" %>

	<s:hidden id="dnumber" name="dnumber" />

		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <FONT color="red">*</FONT><%=Dczydd.ALIAS_HTID%>
		                  </td>
			              <td>
		                           <s:textfield label="%{@vs@ALIAS_HTID}" key="htid" value="%{model.htid}" cssClass="required max-length-50" required="false" />
		                  </td>
                          <td class="crosscolor_td">
			                     <FONT color="red">*</FONT> <%=Dczydd.ALIAS_SQR%>
		                  </td>
			              <td>
		                           <s:textfield label="%{@vs@ALIAS_SQR}" key="sqr" value="%{model.sqr}" cssClass="required max-length-30" required="false" />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                     <FONT color="red">*</FONT> <%=Dczydd.ALIAS_ZJHM%>
		                  </td>
			              <td>
		                           <s:textfield label="%{@vs@ALIAS_ZJHM}" key="zjhm" value="%{model.zjhm}" cssClass="required max-length-30 validate-id-number" required="false" />
		                  </td>
		                  <td class="crosscolor_td">
			                      <%=Dczydd.ALIAS_LXDH%>
		                  </td>
			              <td>
		                           <s:textfield label="%{@vs@ALIAS_LXDH}" key="lxdh" value="%{model.lxdh}" cssClass="max-length-20 validate-number" required="false" />
		                  </td>
                         
                   </tr>
                   <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=Dczydd.ALIAS_DZ%>
		                  </td>
			              <td colspan="3">
		                           <s:textfield label="%{@vs@ALIAS_DZ}" key="dz" size="80" value="%{model.dz}" cssClass="max-length-120" required="false" />
		                  </td>
                          
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=Dczydd.ALIAS_GZDW%>
		                  </td>
			              <td colspan="3">
		                           <s:textfield label="%{@vs@ALIAS_GZDW}" key="gzdw" size="80" value="%{model.gzdw}" cssClass="max-length-60" required="false" />
		                  </td>
                          
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                     <FONT color="red">*</FONT> <%=Dczydd.ALIAS_DWMC%>
		                  </td>
			              <td>
		                           <s:textfield label="%{@vs@ALIAS_DWMC}" key="dwmc" value="%{model.dwmc}" cssClass="required max-length-50" required="false" />
		                  </td>
                          <td class="crosscolor_td">
			                    <FONT color="red">*</FONT>  <%=Dczydd.ALIAS_DDLX%>
		                  </td>
			              <td>
						           <mytag:select property="%{model.ddlx}"   styleClass="required validate-selection"  name="ddlx"   notEmpty="false"  dictName="ddlb"/>
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=Dczydd.ALIAS_DWZJ%>
		                  </td>
			              <td>
		                           <s:textfield label="%{@vs@ALIAS_DWZJ}" key="dwzj" value="%{model.dwzj}" cssClass="max-length-30" required="false" />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=Dczydd.ALIAS_FLAG%>
		                  </td>
			              <td>
						           <mytag:select property="%{model.flag}"     name="flag"   notEmpty="false"  dictName="dczylb"/>
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=Dczydd.ALIAS_DDQX%>(天)
		                  </td>
			              <td>
		                           <s:textfield label="%{@vs@ALIAS_DDQX}" key="ddqx" value="%{model.ddqx}" cssClass="max-length-8 validate-integer" required="false" />
		                  </td>
		                   <td class="crosscolor_td">
			                      <%=Dczydd.ALIAS_DDRQ%>
		                  </td>
			              <td>
						           <input value="${model.ddrq}" onclick="WdatePicker({dateFmt:'yyyy-MM-dd'})" id="ddrq" name="ddrq"  maxlength="0" class="required Wdate" />
		                  </td>
                         
                   </tr>
                   
                    <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=Dczydd.ALIAS_DWMS%>
		                  </td>
			              <td colspan="3">
		                           <s:textfield label="%{@vs@ALIAS_DWMS}" size="80" key="dwms" value="%{model.dwms}" cssClass="max-length-255" required="false" />
		                  </td>
                   </tr>
                    <tr class="crosscolor_tr">
                            <td class="crosscolor_td">
			                      <%=Dczydd.ALIAS_REMARK%>
		                  </td>
			              <td colspan="3">
		                           <s:textfield label="%{@vs@ALIAS_REMARK}" size="80" key="remark" value="%{model.remark}" cssClass="max-length-120" required="false" />
		                  </td>
                   </tr>
		          
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=Dczydd.ALIAS_LRRQ%>
		                  </td>
			              <td>
						           <input value="${model.lrrq}" onclick="WdatePicker({dateFmt:'yyyy-MM-dd'})" id="lrrq" name="lrrq"  maxlength="0" class="required Wdate" />
		                  </td>
                          <td class="crosscolor_td">
			                     <FONT color="red">*</FONT> <%=Dczydd.ALIAS_SDR%>
		                  </td>
			              <td>
		                           <s:textfield label="%{@vs@ALIAS_SDR}" key="sdr" value="%{model.sdr}" cssClass="required max-length-30" required="false" />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=Dczydd.ALIAS_TIB_FLOWGUID%>
		                  </td>
			              <td>
		                           <s:textfield label="%{@vs@ALIAS_TIB_FLOWGUID}" key="tibFlowguid" value="%{model.tibFlowguid}" cssClass="max-length-32" required="false" />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=Dczydd.ALIAS_TIB_ROWGUID%>
		                  </td>
			              <td>
		                           <s:textfield label="%{@vs@ALIAS_TIB_ROWGUID}" key="tibRowguid" value="%{model.tibRowguid}" cssClass="max-length-32" required="false" />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <FONT color="red">*</FONT><%=Dczydd.ALIAS_OPTIME%>
		                  </td>
			              <td>
		                           <s:textfield label="%{@vs@ALIAS_OPTIME}" key="optime" value="%{model.optime}" cssClass="required max-length-17" required="true" />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=Dczydd.ALIAS_FRDB%>
		                  </td>
			              <td>
		                           <s:textfield label="%{@vs@ALIAS_FRDB}" key="frdb" value="%{model.frdb}" cssClass="max-length-30" required="false" />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=Dczydd.ALIAS_YXZJ%>
		                  </td>
			              <td>
		                           <s:textfield label="%{@vs@ALIAS_YXZJ}" key="yxzj" value="%{model.yxzj}" cssClass="max-length-30" required="false" />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=Dczydd.ALIAS_SQDDJE%>
		                  </td>
			              <td>
		                           <s:textfield label="%{@vs@ALIAS_SQDDJE}" key="sqddje" value="%{model.sqddje}" cssClass="validate-number" required="false" />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                    <FONT color="red">*</FONT>  <%=Dczydd.ALIAS_SFSH%>
		                  </td>
			              <td>
						           <mytag:select property="%{model.sfsh}"   styleClass="required validate-selection"  name="sfsh"   notEmpty="false"  dictName="shiFou"/>
		                  </td>
                          <td class="crosscolor_td">
			                      <%=Dczydd.ALIAS_DDRYZP%>
		                  </td>
			              <td>
		                           <s:textfield label="%{@vs@ALIAS_DDRYZP}" key="ddryzp" value="%{model.ddryzp}" cssClass="" required="false" />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=Dczydd.ALIAS_DWZP%>
		                  </td>
			              <td>
		                           <s:textfield label="%{@vs@ALIAS_DWZP}" key="dwzp" value="%{model.dwzp}" cssClass="" required="false" />
		                  </td>
                          <td>&nbsp;</td>
                          <td>&nbsp;</td>
                   </tr>
 
 
