<%@ page contentType="text/html;charset=UTF-8" %>
<%@page import="com.dyneinfo.gas.model.*" %>
<%@ include file="/commons/taglibs.jsp" %>
<%
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+request.getContextPath()+"/";
%>
<html>

<head>
	<%@ include file="/commons/meta.jsp" %>
	<base href="<%=basePath%>">
	<title><%=Tcompanyinfo.TABLE_ALIAS%>编辑</title>
</head>

<body onload="quickSelectInit()" >
<%@ include file="/commons/messages.jsp" %>
<link href="<c:url value="/widgets/ext-3.0.0/resources/css/ext-all.css"/>" type="text/css" rel="stylesheet">
<script src="<c:url value="/widgets/ext-3.0.0/adapter/ext/ext-base.js"/>" type="text/javascript"></script>
<script src="<c:url value="/widgets/ext-3.0.0/ext-all.js"/>" type="text/javascript"></script>

<s:form action="/pages/gas/Tcompanyinfogas/qyupdate.do"  theme="simple"  method="post">
	<table width="100%" border="1" bordercolor="#7c8ca7" align="center" 	cellPadding="0" cellSpacing="0" class="tb_all">
	    <input type="hidden" name="returnUrl" value="!/pages/gas/Tcompanyinfogas/list.do?<mytag:params includes="ec*,s*" type="queryStringUtf"/>" />
	        <tr>
				      <td colspan="4" class="tb_title"> 
							<%=Tcompanyinfo.TABLE_ALIAS%>编辑
				     </td>
		    </tr>

                       <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=Tcompanyinfo.ALIAS_CPNAME%><FONT color="red">*</FONT>
		                  </td>
			              <td colspan="3">
								     <s:hidden id="cpcode" name="cpcode"  value="%{model.cpcode}"/>
		                           <s:textfield label="%{@vs@ALIAS_CPNAME}"  disabled="true"   key="cpname" value="%{model.cpname}"  style="width:600px ;" cssClass="required  max-length-50" required="false" />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=Tcompanyinfo.ALIAS_LEGA_LNAME%><FONT color="red">*</FONT>
		                  </td>
			              <td>
		                           <s:textfield label="%{@vs@ALIAS_LEGA_LNAME}" key="legaLname"  disabled="true"  value="%{model.legaLname}"  cssClass="required  max-length-30" required="false" />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=Tcompanyinfo.ALIAS_LEGAL_CARD%><FONT color="red">*</FONT>
		                  </td>
			              <td>
		                           <s:textfield label="%{@vs@ALIAS_LEGAL_CARD}" key="legalCard" value="%{model.legalCard}"  disabled="true"  cssClass="required max-length-18" required="false" />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=Tcompanyinfo.ALIAS_PHONE%> 
		                  </td>
			              <td>
		                           <s:textfield label="%{@vs@ALIAS_PHONE}" key="phone" value="%{model.phone}"  disabled="true"  cssClass="max-length-20" required="false" />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=Tcompanyinfo.ALIAS_ADDRESS%>
		                  </td>
			              <td>
		                           <s:textfield label="%{@vs@ALIAS_ADDRESS}" disabled="true"   key="address" value="%{model.address}"  cssClass="max-length-100" required="false" />
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
		                           <input value="${model.modTime}"  disabled="true"   onclick="WdatePicker({dateFmt:'yyyy-MM-dd'})" id="modTime" name="modTime"  maxlength="0" class="required required Wdate" />
		                  </td>
                   </tr>
                   <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=Tcompanyinfo.ALIAS_GASOLINE_TYPE%>
		                  </td>
			              <td  colspan="3">
		                           <s:textfield label="%{@vs@ALIAS_GASOLINE_TYPE}" key="gasolineType" style="width:600px ;"  value="%{model.gasolineType}"  cssClass=" max-length-100" required="false" />
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
		                           <s:textfield label="%{@vs@ALIAS_MACHINE}" key="machine" value="%{model.machine}"  cssClass=" validate-number " required="false" />
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
		                           <input value="${model.servicedateview}"  disabled="true"  onclick="WdatePicker({dateFmt:'yyyy-MM-dd'})" id="servicedateview" name="servicedateview"  maxlength="0" class="required required Wdate" />
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
			              	<select  name="stacode" id="stacode"   class="required  max-length-12">
								<option value="">请选择...</option>
							</select>
		                  </td>
                   </tr>
	        <tr >
					 <td colspan="4" class="tb_bottom">
	                        <input id="submitButton" name="submitButton" type="submit" value="保存" />
<!--	                        <input type="button" value="返回" onclick="window.location='${ctx}/pages/gas/Tcompanyinfogas/list.do?<mytag:params includes="ec*,s*" type="queryStringUtf"/>'"/>   -->
					 </td>
			</tr>
	</table>
</s:form>

<script>

if('${msg}'!=""){
	Ext.MessageBox.alert("提示",'${msg}');
}

	getPcs();
function getPcs(){
	var fjbm=document.getElementById("burcode").value;
	var pcsbm='${model.stacode}';
	var url="${ctx}/pages/Dictitem/deptList.do?s_sfsh=0&s_fjbm="+fjbm+"&ajax=true&pcsbm="+pcsbm;
	$.post(url, function(data) {
		$("#pcstd").html("<select  name='stacode'  id='stacode' class='required validate-selection max-length-12'><option value=''>请选择...</option></select>");
		$("#stacode").append(data);
		document.getElementById("stacode").disabled=true;
	});
}
	new Validation(document.forms[0],{onSubmit:true,onFormValidate : function(result,form) {
		var finalResult = result;
		
		//在这里添加自定义验证
		
		return disableSubmit(finalResult,'submitButton');
	}});
document.getElementById("burcode").disabled=true;
document.getElementById("status").disabled=true;

</script>

</body>

</html>