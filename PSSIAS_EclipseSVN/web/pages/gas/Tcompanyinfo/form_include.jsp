<%@page import="com.dyneinfo.gas.model.*" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/commons/taglibs.jsp" %>

	<s:hidden id="cpcode" name="cpcode" />

<!-- ONGL access static field: @package.class@field or @vs@field -->

		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=Tcompanyinfo.ALIAS_CPNAME%><FONT color="red">*</FONT>
		                  </td>
			              <td colspan="3">
		                           <s:textfield label="%{@vs@ALIAS_CPNAME}" key="cpname" value="%{model.cpname}"  style="width:600px ;" cssClass="required  max-length-50" required="false" />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=Tcompanyinfo.ALIAS_LEGA_LNAME%><FONT color="red">*</FONT>
		                  </td>
			              <td>
		                           <s:textfield label="%{@vs@ALIAS_LEGA_LNAME}" key="legaLname" value="%{model.legaLname}"  cssClass="required  max-length-30" required="false" />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=Tcompanyinfo.ALIAS_LEGAL_CARD%><FONT color="red">*</FONT>
		                  </td>
			              <td>
		                           <s:textfield label="%{@vs@ALIAS_LEGAL_CARD}" key="legalCard" value="%{model.legalCard}"  cssClass="required max-length-18 validate-id-number" required="false" />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=Tcompanyinfo.ALIAS_PHONE%> <FONT color="red">*</FONT>
		                  </td>
			              <td>
		                           <s:textfield label="%{@vs@ALIAS_PHONE}" key="phone" value="%{model.phone}"  cssClass="required max-length-20" required="false" />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=Tcompanyinfo.ALIAS_ADDRESS%><FONT color="red">*</FONT>
		                  </td>
			              <td>
		                           <s:textfield label="%{@vs@ALIAS_ADDRESS}" key="address" value="%{model.address}"  cssClass="required max-length-100" required="false" />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=Tcompanyinfo.ALIAS_STATUS%><FONT color="red">*</FONT>
		                  </td>
			              <td>
		                           <mytag:select property="%{model.status}"    name="status"   notEmpty="false" styleClass="required validate-selection select" dictName="T_DIC_CPSTATE"/> 
		                           
		                  </td>
                          <td class="crosscolor_td">
			                      <%=Tcompanyinfo.ALIAS_MOD_TIME%><FONT color="red">*</FONT>
		                  </td>
			              <td>
		                           <input value="${model.modTime}" onclick="WdatePicker({dateFmt:'yyyy-MM-dd'})" id="modTime" name="modTime"  maxlength="0" class="required required Wdate" />
		                  </td>
                   </tr>
                   <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=Tcompanyinfo.ALIAS_GASOLINE_TYPE%> 
		                  </td>
			              <td  colspan="3">
		                           <s:textfield label="%{@vs@ALIAS_GASOLINE_TYPE}" key="gasolineType" style="width:600px ;"  value="%{model.gasolineType}"  cssClass="max-length-100" required="false" />
		                  </td>
		           </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=Tcompanyinfo.ALIAS_CPTYPE%>
		                  </td>
			              <td>
		                          <mytag:select property="%{model.cptype}"    name="cptype"   notEmpty="false"  styleClass="validate-selection select" dictName="T_DIC_CPKIND"/>
		                           
		                  </td>
                          <td class="crosscolor_td">
			                      <%=Tcompanyinfo.ALIAS_MACHINE%>
		                  </td>
			              <td>
		                           <s:textfield label="%{@vs@ALIAS_MACHINE}" key="machine" value="%{model.machine}"  cssClass="validate-number " required="false" />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=Tcompanyinfo.ALIAS_MONITOR%>
		                  </td>
			              <td>
		                           <s:textfield label="%{@vs@ALIAS_MONITOR}" key="monitor" value="%{model.monitor}"  cssClass="validate-number " required="false" />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=Tcompanyinfo.ALIAS_SERVICEDATEVIEW%><FONT color="red">*</FONT>
		                  </td>
			              <td>
		                           <input value="${model.servicedateview}" onclick="WdatePicker({dateFmt:'yyyy-MM-dd'})" id="servicedateview" name="servicedateview"  maxlength="0" class="required required Wdate" />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=Tcompanyinfo.ALIAS_BURCODE%><FONT color="red">*</FONT>
		                  </td>
			              <td>
		                           <mytag:select property="%{model.burcode}"   onchange="getPcs()"  styleClass="required validate-selection select"  name="burcode"   notEmpty="false"  dictName="ssfj"/>
		                  </td>
                          <td class="crosscolor_td">
			                      <%=Tcompanyinfo.ALIAS_STACODE%><FONT color="red">*</FONT>
		                  </td>
			              <td id="pcstd">
			              	<select  name="stacode" id="stacode"   style="width:155px" class="required  max-length-12">
								<option value="">请选择...</option>
							</select>
		                  </td>
                   </tr>
 
 
<script language="javascript">
function getPcs(){
	var fjbm=document.getElementById("burcode").value;
	var pcsbm='${model.stacode}';
	var url="${ctx}/pages/Dictitem/deptList.do?s_sfsh=0&s_fjbm="+fjbm+"&ajax=true&pcsbm="+pcsbm;
	$.post(url, function(data) {
		$("#pcstd").html("<select  name='stacode'  id='stacode' class='required validate-selection max-length-12'><option value=''>请选择...</option></select>");
		$("#stacode").append(data);
	});
}
</script>