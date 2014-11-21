<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/commons/taglibs.jsp" %>
<%@page import="com.dyneinfo.ylcs.model.*" %>
<%
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+request.getContextPath()+"/";
%>
<html>

<head>
	<%@ include file="/commons/meta.jsp" %>
	<base href="<%=basePath%>">
	<title><%=TcpinfoYl.TABLE_ALIAS%>编辑</title>
</head>

<body onload="quickSelectInit()" >
<%@ include file="/commons/messages.jsp" %>

<s:form action="/pages/ylcs/TcpinfoYl/update.do"  theme="simple"  method="post">
	<table width="100%" border="1" bordercolor="#7c8ca7" align="center"  cellPadding="0" cellSpacing="0" class="tb_all">
	    <input type="hidden" name="returnUrl" value="!/pages/ylcs/TcpinfoYl/list.do?<mytag:params includes="ec*,s*" type="queryStringUtf"/>" />
	        <tr>
				      <td colspan="4" class="tb_title"> 
							<%=TcpinfoYl.TABLE_ALIAS%>编辑
				     </td>
		    </tr>
	              <s:hidden id="locode" name="locode" />

<!-- ONGL access static field: @package.class@field or @vs@field -->
					<tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=TcpinfoYl.ALIAS_CPNAME%>
		                  </td>
			              <td  colspan="3">
		                           <s:textfield label="%{@vs@ALIAS_CPNAME}" key="cpname" size="60" value="%{model.cpname}"  cssClass="required max-length-40" required="false" /><font color="red">*</font>
		                  </td>
                         
                   </tr>
                   <tr class="crosscolor_tr">
             
                          <td class="crosscolor_td">
			                      <%=TcpinfoYl.ALIAS_CPADDRESS%>
		                  </td>
			              <td colspan="3">
		                           <s:textfield label="%{@vs@ALIAS_CPADDRESS}" key="cpaddress" size="60" value="%{model.cpaddress}"  cssClass="required max-length-100" required="false" /><font color="red">*</font>
		                  </td>
                   </tr>
                   <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=TcpinfoYl.ALIAS_PHONE%>
		                  </td>
			              <td>
		                           <s:textfield label="%{@vs@ALIAS_PHONE}" key="phone" value="%{model.phone}"  cssClass="required max-length-20" required="false" /><font color="red">*</font>
		                  </td>
                          <td class="crosscolor_td">
			                      <%=TcpinfoYl.ALIAS_FAX%>
		                  </td>
			              <td>
		                           <s:textfield label="%{@vs@ALIAS_FAX}" key="fax" value="%{model.fax}"  cssClass="max-length-20" required="false" />
		                  </td>
                   </tr>
                    <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=TcpinfoYl.ALIAS_POSTALCODE%>
		                  </td>
			              <td>
		                           <s:textfield label="%{@vs@ALIAS_POSTALCODE}" key="postalcode" value="%{model.postalcode}"  cssClass="max-length-6" required="false" />
		                  </td>
		                  <td class="crosscolor_td">
			                      <%=TcpinfoYl.ALIAS_CORPCODE%>
		                  </td>
			              <td>
		                           <s:textfield label="%{@vs@ALIAS_CORPCODE}" key="corpcode" value="%{model.corpcode}"  cssClass="max-length-9" required="false" />
		                  </td>
                          
                   </tr>
                   <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=TcpinfoYl.ALIAS_CORPNAME%>
		                  </td>
			              <td>
		                           <s:textfield label="%{@vs@ALIAS_CORPNAME}" key="corpname" value="%{model.corpname}"  cssClass="required max-length-30" required="false" /><font color="red">*</font>
		                  </td>
		                  <td class="crosscolor_td">
			                      <%=TcpinfoYl.ALIAS_ACREAGE%>
		                  </td>
			              <td>
		                           <s:textfield label="%{@vs@ALIAS_ACREAGE}" key="acreage" value="%{model.acreage}"  cssClass="validate-integer " required="false" />
		                  </td>
		                  
                   </tr>
                    <tr class="crosscolor_tr">
                          
                          <td class="crosscolor_td">
			                      <%=TcpinfoYl.ALIAS_ENROLCAPITAL%>
		                  </td>
			              <td>
		                           <s:textfield label="%{@vs@ALIAS_ENROLCAPITAL}" key="enrolcapital" value="%{model.enrolcapital}"  cssClass="validate-number " required="false" />
		                  </td>
		                  <td class="crosscolor_td">
			                      <%=TcpinfoYl.ALIAS_ECONOMY%>
		                  </td>
			              <td>
		                           <s:textfield label="%{@vs@ALIAS_ECONOMY}" key="economy" value="%{model.economy}"  cssClass="required max-length-3" required="false" /><font color="red">*</font>
		                  </td>
                   </tr>
                    <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=TcpinfoYl.ALIAS_WORKAREA%>
		                  </td>
			              <td>
		                           <s:textfield label="%{@vs@ALIAS_WORKAREA}" key="workarea"  size="38" value="%{model.workarea}"  cssClass="required max-length-160" required="false" /><font color="red">*</font>
		                  </td>
		                  <td class="crosscolor_td">
			                      <%=TcpinfoYl.ALIAS_WORKAREASEC%>
		                  </td>
			              <td>
		                           <s:textfield label="%{@vs@ALIAS_WORKAREASEC}" key="workareasec"  size="38" value="%{model.workareasec}"  cssClass="max-length-160" required="false" />
		                  </td>
                  </tr>
                   <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=TcpinfoYl.ALIAS_POLICENAME%>
		                  </td>
			              <td>
		                           <s:textfield label="%{@vs@ALIAS_POLICENAME}" key="policename" value="%{model.policename}"  cssClass="max-length-30" required="false" />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=TcpinfoYl.ALIAS_POLICEPHONE%>
		                  </td>
			              <td>
		                           <s:textfield label="%{@vs@ALIAS_POLICEPHONE}" key="policephone" value="%{model.policephone}"  cssClass="max-length-20" required="false" />
		                  </td>
                   </tr>
                   <tr class="crosscolor_tr">
                         <td class="crosscolor_td">
			                      <%=TcpinfoYl.ALIAS_POLICEUNIT%>
		                  </td>
			              <td>
			              		   <mytag:select dictName="ssfj" styleClass="required" name="policeunit" property="%{model.policeunit}"/>
		                           <font color="red">*</font>
		                  </td>
		                  <td class="crosscolor_td">
			                      <%=TcpinfoYl.ALIAS_SCBACKUPNO%>
		                  </td>
			              <td>
		                           <s:textfield label="%{@vs@ALIAS_SCBACKUPNO}" key="scbackupno" value="%{model.scbackupno}"  cssClass="required max-length-20" required="false" /><font color="red">*</font>
		                  </td>
                   </tr>
                   <tr class="crosscolor_tr">
                          
                          <td class="crosscolor_td">
			                      <%=TcpinfoYl.ALIAS_SCBACKUPUNIT%>
		                  </td>
			              <td>
			              		   <mytag:select dictName="ssfj" styleClass="required" name="scbackupunit" property="%{model.scbackupunit}" notEmpty="false"/>
		                           <font color="red">*</font>
		                  </td>
		                  <td class="crosscolor_td">
			                      <%=TcpinfoYl.ALIAS_LICENCE%>
		                  </td>
			              <td>
		                           <s:textfield label="%{@vs@ALIAS_LICENCE}" key="licence" value="%{model.licence}"  cssClass="required max-length-20" required="false" /><font color="red">*</font>
		                  </td>
                   </tr>
                   <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=TcpinfoYl.ALIAS_FJCODE%>
		                  </td>
			              <td>
			              		  <mytag:select dictName="ssfj" styleClass="required" name="fjcode" property="%{model.fjcode}"/>
		                          <font color="red">*</font>
		                  </td>
		                  <td class="crosscolor_td">
			                      <%=TcpinfoYl.ALIAS_STATION%>
		                  </td>
			              <td>
			              		   <select name="station" id="station" >
										<option value="">请选择...</option>
									</select>
									<font color="red">*</font>
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=TcpinfoYl.ALIAS_THCODE%>
		                  </td>
			              <td>
			              		   <mytag:select dictName="t_dic_cptype" styleClass="required" name="thcode" property="%{model.thcode}"/>
		                           <font color="red">*</font>
		                  </td>
		                  <td class="crosscolor_td">
			                      <%=TcpinfoYl.ALIAS_ZAJB%>
		                  </td>
			              <td>
			              		   <mytag:select dictName="T_DIC_ZAJB" styleClass="required" name="zajb" property="%{model.zajb}"/>
		                           <font color="red">*</font>
		                  </td>
                   </tr>
                   <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=TcpinfoYl.ALIAS_CSXJ%>
		                  </td>
			              <td>
			              		   <mytag:select dictName="T_DIC_CSXJ" name="csxj" property="%{model.csxj}"/>
		                  </td>
		                   <td class="crosscolor_td">
			                      <%=TcpinfoYl.ALIAS_JWDZB%>
		                  </td>
			              <td>
		                           <s:textfield label="%{@vs@ALIAS_JWDZB}" key="jwdzb" value="%{model.jwdzb}"  cssClass="max-length-40" required="false" />
		                  </td>
                          <%--<td class="crosscolor_td">
			                      <%=TcpinfoYl.ALIAS_STATE%>
		                  </td>
			              <td>
		                           <s:textfield label="%{@vs@ALIAS_STATE}" key="state" value="%{model.state}"  cssClass="max-length-1" required="false" />
		                  </td>
                   --%></tr>
                   <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=TcpinfoYl.ALIAS_BXSL%>
		                  </td>
			              <td>
		                           <s:textfield label="%{@vs@ALIAS_BXSL}" key="bxsl" value="%{model.bxsl}"  cssClass="validate-integer max-value-2147483647" required="false" />
		                  </td>
		                  <td class="crosscolor_td">
			                      <%=TcpinfoYl.ALIAS_XFZSL%>
		                  </td>
			              <td>
		                           <s:textfield label="%{@vs@ALIAS_XFZSL}" key="xfzsl" value="%{model.xfzsl}"  cssClass="validate-integer max-value-2147483647" required="false" />
		                  </td>
                          
                   </tr>
                   <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=TcpinfoYl.ALIAS_GDXX%>
		                  </td>
			              <td colspan="3">
		                           <s:textarea label="%{@vs@ALIAS_GDXX}" cols="58" rows="2" key="gdxx" value="%{model.gdxx}"  cssClass="max-length-100" required="false" />
		                  </td>
                          
                   </tr>
                    <tr class="crosscolor_tr">
                          
                          <td class="crosscolor_td">
			                      <%=TcpinfoYl.ALIAS_STATE%>
		                  </td>
			              <td>
			              		   <mytag:select dictName="T_DIC_YLCSSTATE" property="%{model.state}" name="state" styleClass="required"/><font color="red">*</font>
		                  </td>
		                  <td class="crosscolor_td">
			                      <%=TcpinfoYl.ALIAS_POLICELEVELCODE%>
		                  </td>
			              <td>
			              		   <mytag:select dictName="T_DIC_ZADJ" name="policelevelcode" property="%{model.policelevelcode}"  styleClass="required"></mytag:select>
		                  </td>

                   </tr>
                   <tr class="crosscolor_tr">
                  		 <td class="crosscolor_td">
			                      <%=TcpinfoYl.ALIAS_STARTDATE%>
		                  </td>
			              <td>
		                           <input value="${model.startdateString}" onclick="WdatePicker({dateFmt:'<%=TcpinfoYl.FORMAT_STARTDATE%>'})" id="startdateString" name="startdateString"  maxlength="0" class="required Wdate" /><font color="red">*</font>
		                  </td>
		                  <td class="crosscolor_td">
			                      <%=TcpinfoYl.ALIAS_STOPDATE%>
		                  </td>
			              <td>
		                           <input value="${model.stopdateString}" onclick="WdatePicker({dateFmt:'<%=TcpinfoYl.FORMAT_STOPDATE%>'})" id="stopdateString" name="stopdateString"  maxlength="0" class="Wdate" />
		                  </td>
                    </tr>
                   <tr class="crosscolor_tr"><%--
                          <td class="crosscolor_td">
			                     	单位类型 		
		                  </td>
			              <td>
			              	<mytag:select dictName="T_DIC_UNITTYPE" styleClass="required" name="dwlx" property="%{model.dwlx}"/>
							<font color="red">*</font>
		                  </td>
                          --%><td class="crosscolor_td">
			                      <%=TcpinfoYl.ALIAS_SPJRURL%>
		                  </td>
			              <td>
		                           <s:textfield label="%{@vs@ALIAS_SPJRURL}" key="spjrurl" value="%{model.spjrurl}"  cssClass="max-length-50" required="false" />
		                  </td>
                   </tr>
	        <tr >
					 <td colspan="4" class="tb_bottom">
	                        <input id="submitButton" name="submitButton" type="submit" value="提交" />
	                        <input type="button" value="返回" onclick="window.location='${ctx}/pages/ylcs/TcpinfoYl/list.do?<mytag:params includes="ec*,s*" type="queryStringUtf"/>'"/>   
					 </td>
			</tr>
	</table>
</s:form>

<script>
	
	new Validation(document.forms[0],{onSubmit:true,onFormValidate : function(result,form) {
		var finalResult = result;
		
		//在这里添加自定义验证
		
		return disableSubmit(finalResult,'submitButton');
	}});
	$(document).ready(function(){
		
		$("select[name=fjcode]").change(function(){
			var url="${ctx}/pages/zazh/Tcoordinate/addStation.do?fjcode="+this.value;
			$.get(url,function(data){
				$("#station").html(data);
					//alert(data);
			});
		});
		var url="${ctx}/pages/zazh/Tcoordinate/addStation.do?fjcode=${model.fjcode}&pcscode=${model.station}";
		$.get(url,function(data){
			$("#station").html(data);
					//alert(data);
		});
	});
</script>

</body>

</html>