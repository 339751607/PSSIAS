<%@page import="com.dyneinfo.pmdd.model.*" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/commons/taglibs.jsp" %>

	<s:hidden id="dnumber" name="dnumber" />

<!-- ONGL access static field: @package.class@field or @vs@field -->

		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                     <FONT color="red">*</FONT> <%=Fcdydd.ALIAS_HTID%>
		                  </td>
			              <td>
		                           <s:textfield label="%{@vs@ALIAS_HTID}" key="htid" value="%{model.htid}"  cssClass="required max-length-50" required="false" />
		                  </td>
                          <td class="crosscolor_td">
			                    <FONT color="red">*</FONT>  <%=Fcdydd.ALIAS_SQR%>
		                  </td>
			              <td>
		                           <s:textfield label="%{@vs@ALIAS_SQR}" key="sqr" value="%{model.sqr}"  cssClass="required max-length-30" required="false" />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                     <FONT color="red">*</FONT> <%=Fcdydd.ALIAS_ZJHM%>
		                  </td>
			              <td>
		                           <s:textfield label="%{@vs@ALIAS_ZJHM}" key="zjhm" value="%{model.zjhm}"  cssClass="required max-length-30 validate-id-number" required="false" />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=Fcdydd.ALIAS_GZDW%>
		                  </td>
			              <td>
		                           <s:textfield label="%{@vs@ALIAS_GZDW}" key="gzdw" value="%{model.gzdw}"  cssClass="max-length-60" required="false" />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=Fcdydd.ALIAS_LXDH%>
		                  </td>
			              <td>
		                           <s:textfield label="%{@vs@ALIAS_LXDH}" key="lxdh" value="%{model.lxdh}"  cssClass="max-length-20 validate-number" required="false" />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=Fcdydd.ALIAS_FRDB%>
		                  </td>
			              <td>
		                           <s:textfield label="%{@vs@ALIAS_FRDB}" key="frdb" value="%{model.frdb}"  cssClass="max-length-30" required="false" />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                     <FONT color="red">*</FONT> <%=Fcdydd.ALIAS_LB%>
		                  </td>
			              <td>
						           <mytag:select property="%{model.lb}"   styleClass="required validate-selection"  name="lb"   notEmpty="false"  dictName="fcdylb"/>
		                  </td>
                          <td class="crosscolor_td">
			                     <FONT color="red">*</FONT> <%=Fcdydd.ALIAS_FWQW%>
		                  </td>
			              <td>
		                           <s:textfield label="%{@vs@ALIAS_FWQW}" key="fwqw" value="%{model.fwqw}"  cssClass="required max-length-60" required="false" />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=Fcdydd.ALIAS_DZ%>
		                  </td>
			              <td colspan="3">
		                           <s:textfield label="%{@vs@ALIAS_DZ}" key="dz" size="80" value="%{model.dz}"  cssClass="max-length-120" required="false" />
		                  </td>
                         
                   </tr>
		           <tr class="crosscolor_tr">
		                  <td class="crosscolor_td">
			                     <FONT color="red">*</FONT> <%=Fcdydd.ALIAS_FWSYQZH%>
		                  </td>
			              <td>
		                           <s:textfield label="%{@vs@ALIAS_FWSYQZH}" key="fwsyqzh" value="%{model.fwsyqzh}"  cssClass="required max-length-30" required="false" />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=Fcdydd.ALIAS_JZMJ%>
		                  </td>
			              <td>
		                           <s:textfield label="%{@vs@ALIAS_JZMJ}" key="jzmj" value="%{model.jzmj}"  cssClass="max-length-10 validate-digits" required="false" />(平米)
		                  </td>
                         
                   </tr>
		           <tr class="crosscolor_tr">
		                  <td class="crosscolor_td">
			                     <FONT color="red">*</FONT> <%=Fcdydd.ALIAS_TDSYZH%>
		                  </td>
			              <td>
		                           <s:textfield label="%{@vs@ALIAS_TDSYZH}" key="tdsyzh" value="%{model.tdsyzh}"  cssClass="required max-length-30" required="false" />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=Fcdydd.ALIAS_ZDMJ%>
		                  </td>
			              <td>
		                           <s:textfield label="%{@vs@ALIAS_ZDMJ}" key="zdmj" value="%{model.zdmj}"  cssClass="max-length-10 validate-digits" required="false" />(平米)
		                  </td>
                          
                   </tr>
                    <tr class="crosscolor_tr">
		                 
                          <td class="crosscolor_td">
			                      <%=Fcdydd.ALIAS_BXXZ%>
		                  </td>
			              <td colspan="3">
		                           <s:textfield label="%{@vs@ALIAS_BXXZ}" key="bxxz" value="%{model.bxxz}"  cssClass="max-length-30" required="false" />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                     <FONT color="red">*</FONT><%=Fcdydd.ALIAS_DDLB%>
		                  </td>
			              <td>
						           <mytag:select property="%{model.ddlb}"   styleClass="required validate-selection"  name="ddlb"   notEmpty="false"  dictName="ddlb"/>
		                  </td>
                          <td class="crosscolor_td">
			                      <%=Fcdydd.ALIAS_DDQX%>
		                  </td>
			              <td>
		                           <s:textfield label="%{@vs@ALIAS_DDQX}" key="ddqx" value="%{model.ddqx}"  cssClass="max-length-8 validate-integer" required="false" />(天)
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=Fcdydd.ALIAS_DWMS%>
		                  </td>
			              <td colspan="3">
		                           <s:textfield label="%{@vs@ALIAS_DWMS}" size="80" key="dwms" value="%{model.dwms}"  cssClass="max-length-255" required="false" />
		                  </td>
                         
                   </tr>
                    <tr class="crosscolor_tr">
                         
                          <td class="crosscolor_td">
			                      <%=Fcdydd.ALIAS_REMARK%>
		                  </td>
			              <td colspan="3">
		                           
		                   <s:textarea label="%{@vs@ALIAS_REMARK}" rows="4" cols="62"
							key="remark" value="%{model.remark}" cssClass="max-length-120"
							required="false"></s:textarea>
		                  
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=Fcdydd.ALIAS_DDRQ%>
		                  </td>
			              <td>
						           <input value="${model.ddrq}" onclick="WdatePicker({dateFmt:'yyyy-MM-dd'})" id="ddrq" name="ddrq"  maxlength="0" class="required Wdate" />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=Fcdydd.ALIAS_LRRQ%>
		                  </td>
			              <td>
						           <input value="${model.lrrq}" onclick="WdatePicker({dateFmt:'yyyy-MM-dd'})" id="lrrq" name="lrrq"  maxlength="0" class="required Wdate" />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <FONT color="red">*</FONT><%=Fcdydd.ALIAS_SDR%>
		                  </td>
			              <td>
		                           <s:textfield label="%{@vs@ALIAS_SDR}" key="sdr" value="%{model.sdr}"  cssClass="required max-length-30" required="false" />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=Fcdydd.ALIAS_SFSH%>
		                  </td>
			              <td>
						           <mytag:select property="%{model.sfsh}"   styleClass="required validate-selection"  name="sfsh"   notEmpty="false"  dictName="shiFou"/>
		                  </td>
                   </tr>
		           
 
 
