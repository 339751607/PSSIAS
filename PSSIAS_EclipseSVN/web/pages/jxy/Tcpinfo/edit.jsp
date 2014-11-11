<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/commons/taglibs.jsp" %>
<%@page import="com.dyneinfo.jxy.model.*" %>
<%
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+request.getContextPath()+"/";
%>
<html>

<head>
	<%@ include file="/commons/meta.jsp" %>
	<base href="<%=basePath%>">
	<title><%=Tcpinfo.TABLE_ALIAS%>编辑</title>
</head>

<body onload="quickSelectInit()" >
<%@ include file="/commons/messages.jsp" %>

<s:form action="/jxy/Tcpinfo/update.do" name="form1"   theme="simple"  method="post">
	<table cellpadding="0" cellspacing="0" border="0" class="tb_all">
	    <input type="hidden" name="returnUrl" value="!/jxy/Tcpinfo/list.do?<mytag:params includes="ec*,s*" type="queryStringUtf"/>" />
	        <tr>
				      <td colspan="4" class="tb_title"> 
							<%=Tcpinfo.TABLE_ALIAS%>编辑
				     </td>
		    </tr>
	               <s:hidden id="cpcode" name="cpcode" />

<!-- ONGL access static field: @package.class@field or @vs@field -->

		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=Tcpinfo.ALIAS_CPNAME%>
		                  </td>
			              <td colspan="3">
		                          
		                           <s:property value="%{model.cpname}"/>
		                   
		                  </td>
		            </tr>
		           <tr class="crosscolor_tr">       
                          <td class="crosscolor_td">
			                      <%=Tcpinfo.ALIAS_CPADDRESS%>
		                  </td>
			              <td colspan="3">
		                           
		                           <s:property value="%{model.cpaddress}"/>
		                 
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=Tcpinfo.ALIAS_WORKAREA%>
		                  </td>
			             <td colspan="3">
		                           <s:textfield label="%{@vs@ALIAS_WORKAREA}" key="workarea" size="70" value="%{model.workarea}"  cssClass="max-length-160" required="false" />
		                  </td>
                          
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=Tcpinfo.ALIAS_PHONE%><font color="red">*</font>
		                  </td>
			              <td>
		                           <s:textfield label="%{@vs@ALIAS_PHONE}" key="phone" value="%{model.phone}"  cssClass="required max-length-20" required="false" />
		                            
		                  </td>
                          <td class="crosscolor_td">
			                      <%=Tcpinfo.ALIAS_FAX%>
		                  </td>
			              <td>
		                           <s:textfield label="%{@vs@ALIAS_FAX}" key="fax" value="%{model.fax}"  cssClass="max-length-20" required="false" />
		                  </td>
                          
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=Tcpinfo.ALIAS_ENROLCAPITAL%>
		                  </td>
			              <td style="float: left">
	                               <s:textfield label="%{@vs@ALIAS_ENROLCAPITAL}" key="enrolcapital" value="%{model.enrolcapital}"  cssClass="validate-integer  validate-number" required="false" />
		                            万元（人民币）
		                  </td>
                          <td class="crosscolor_td">
			                      <%=Tcpinfo.ALIAS_POSTALCODE%>
		                  </td>
			              <td>
	                               <s:textfield label="%{@vs@ALIAS_POSTALCODE}" key="postalcode" value="%{model.postalcode}"  cssClass="max-length-6 validate-zip" required="false" />
		                  </td>
                          
                   </tr>
		           <tr class="crosscolor_tr">
                         <td class="crosscolor_td">
			                      <%=Tcpinfo.ALIAS_STARTDATE%><font color="red">*</font>
		                  </td>
			              <td>
						           <input value="${model.startdate}" onclick="WdatePicker({dateFmt:'yyyy-MM-dd',maxDate:'${date}'})" id="startdate" name="startdate"  maxlength="0" class="required Wdate" />
		                             
		                  </td>
                          <td class="crosscolor_td">
			                      <%=Tcpinfo.ALIAS_ECONOMY%>
		                  </td>
			              <td>
						           <mytag:select property="%{model.economy}"   styleClass=" validate-selection"  name="economy"   notEmpty="false"  dictName="T_DIC_CPKIND"/>
		                  </td>
                          
                   </tr>
		           <tr class="crosscolor_tr">
                         <td class="crosscolor_td">
			                      <%=Tcpinfo.ALIAS_CORPCODE%>
		                  </td>
			              <td>
		                           <s:textfield label="%{@vs@ALIAS_CORPCODE}" key="corpcode" value="%{model.corpcode}"  cssClass="max-length-9" required="false" />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=Tcpinfo.ALIAS_CORPNAME%>
		                  </td>
			              <td>
			              <s:property value="%{model.corpname}"/>
		                         
		                  </td>
                         
                   </tr>
		           <tr class="crosscolor_tr">
                           <td class="crosscolor_td">
			                      <%=Tcpinfo.ALIAS_POLICENAME%>
		                  </td>
			              <td>
			              <s:property value="%{model.policename}"/>
		                          
		                  </td>
                          <td class="crosscolor_td">
			                      <%=Tcpinfo.ALIAS_POLICEPHONE%>
		                  </td>
			              <td>
		                           <s:textfield label="%{@vs@ALIAS_POLICEPHONE}" key="policephone" value="%{model.policephone}"  cssClass="max-length-20" required="false" />
		                  </td>
                         
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=Tcpinfo.ALIAS_ACREAGE%>
		                  </td>
			              <td style="float: left">
	                               <s:textfield label="%{@vs@ALIAS_ACREAGE}" key="acreage" value="%{model.acreage}"  cssClass="validate-integer  validate-number" required="false" />
		                                                     平方米
		                  </td>
                          <td class="crosscolor_td">
			                      <%=Tcpinfo.ALIAS_POLICEUNIT%>
		                  </td>
			              <td>
						           
		                            <mytag:write property="%{model.policeunit}" notEmpty="false" dictName="ssfj"></mytag:write>
		                  </td>
                         
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=Tcpinfo.ALIAS_SCBACKUPNO%>
		                  </td>
			              <td>
		                           <s:textfield label="%{@vs@ALIAS_SCBACKUPNO}" key="scbackupno" value="%{model.scbackupno}"  cssClass="max-length-20" required="false" />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=Tcpinfo.ALIAS_SCBACKUPUNIT%><font color="red">*</font>
		                  </td>
			              <td>
						           <mytag:select property="%{model.scbackupunit}"   styleClass="required validate-selection"  name="scbackupunit"   notEmpty="false"  dictName="ssfj"/>
		                    </td>
                          
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=Tcpinfo.ALIAS_BASJ%>
		                  </td>
			              <td>
						           <input value="${model.basj}" onclick="WdatePicker({dateFmt:'yyyy-MM-dd',maxDate:'${date}'})" id="basj" name="basj"  maxlength="0" class=" Wdate" />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=Tcpinfo.ALIAS_LICENCEUNIT%>
		                  </td>
			              <td>
		                           <s:textfield label="%{@vs@ALIAS_LICENCEUNIT}" key="licenceunit" value="%{model.licenceunit}"  cssClass="max-length-40" required="false" />
		                  </td>
                         
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=Tcpinfo.ALIAS_BCRETCODE%>
		                  </td>
			              <td>
		                           <s:textfield label="%{@vs@ALIAS_BCRETCODE}" key="bcretcode" value="%{model.bcretcode}"  cssClass="max-length-20" required="false" />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=Tcpinfo.ALIAS_BCRETUNIT%>
		                  </td>
			              <td>
		                           <s:textfield label="%{@vs@ALIAS_BCRETUNIT}" key="bcretunit" value="%{model.bcretunit}"  cssClass="max-length-40" required="false" />
		                  </td>
                         
                   </tr>
		           <tr class="crosscolor_tr">
                           <td class="crosscolor_td">
			                      <%=Tcpinfo.ALIAS_TAXCODE%>
		                  </td>
			              <td>
		                           <s:textfield label="%{@vs@ALIAS_TAXCODE}" key="taxcode" value="%{model.taxcode}"  cssClass="max-length-20" required="false" />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=Tcpinfo.ALIAS_TAXUNIT%>
		                  </td>
			              <td>
		                           <s:textfield label="%{@vs@ALIAS_TAXUNIT}" key="taxunit" value="%{model.taxunit}"  cssClass="max-length-40" required="false" />
		                  </td>
                          
                   </tr>
		           <tr class="crosscolor_tr">
                         <td class="crosscolor_td">
			                      <%=Tcpinfo.ALIAS_LICENCE%>
		                  </td>
			              <td>
		                           <s:textfield label="%{@vs@ALIAS_LICENCE}" key="licence" value="%{model.licence}"  cssClass="max-length-20" required="false" />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=Tcpinfo.ALIAS_STATION%>
		                  </td>
			              <td>
			             <s:property value="%{model.stationName}" />
		                 
		                   
		                  </td>
                   </tr>
 
 <script>
 function selectDept(frm,displayName,hiddenName) {
	           window.showModalDialog('${ctx}/pages/SsDept/selectDept.do?idValueIsSeq=false&formName=' + frm.name + '&inputName='+displayName+'&hiddenName='+hiddenName+'&rootID=false&maxPatiNum=1&hiddenType=ID_SPLIT',frm,'dialogHeight:500px;dialogWidth:560px;center:yes');
       }
</script>

	        <tr >
					 <td colspan="4" class="tb_bottom">
	                        <input id="submitButton" name="submitButton" type="submit" value="提交" />
	                        <input type="button" value="返回" onclick="window.location='${ctx}/jxy/Tcpinfo/list.do?<mytag:params includes="ec*,s*" type="queryStringUtf"/>'"/>   
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
</script>

</body>

</html>
