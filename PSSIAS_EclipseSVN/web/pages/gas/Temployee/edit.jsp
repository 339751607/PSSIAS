<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/commons/taglibs.jsp" %>
<%@page import="com.dyneinfo.gas.model.*" %>
<%
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+request.getContextPath()+"/";
%>
<html>

<head>
	<%@ include file="/commons/meta.jsp" %>
	<base href="<%=basePath%>">
	<title><%=Temployee.TABLE_ALIAS%>编辑</title>
</head>

<body onload="quickSelectInit()" >
<%@ include file="/commons/messages.jsp" %>

<s:form action="/pages/gas/Temployeegas/update.do"  theme="simple"  method="post">
	<table width="100%" border="1" bordercolor="#7c8ca7" align="center"  cellPadding="0" cellSpacing="0" class="tb_all">
	    <input type="hidden" name="returnUrl" value="!/pages/gas/Temployeegas/qylist.do?<mytag:params includes="ec*,s*" type="queryStringUtf"/>" />
	        <tr>
				      <td colspan="5" class="tb_title"> 
							<%=Temployee.TABLE_ALIAS%>编辑
				     </td>
		    </tr>
	         <s:hidden id="empcode" name="empcode" />
<s:hidden id="pPhotoBuffer" name="pPhotoBuffer" />
<!-- ONGL access static field: @package.class@field or @vs@field -->

		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=Temployee.ALIAS_EMPNAME%><FONT color="red">*</FONT>
		                  </td>
			              <td>
		                           <s:textfield label="%{@vs@ALIAS_EMPNAME}" key="empname" value="%{model.empname}"  cssClass="required max-length-30" required="false" />
		                  </td>
		                  <td class="crosscolor_td">
			                      <%=Temployee.ALIAS_PERSONID%><FONT color="red">*</FONT>
		                  </td>
			              <td>
		                           <s:textfield label="%{@vs@ALIAS_PERSONID}" key="personid" value="%{model.personid}" onblur="javascript:showBirthday();"  cssClass="required validate-id-number" required="false" />
		                  </td>
                         
		                   <td rowspan="13" width="15%" align="center" valign="middle">
		                   <img src='${ctx}/pages/gas/Temployeegas/showPic.do?xh=<s:property value="%{model.empcode}" />'  height="260" alt="" width="220" border="0" name="photo">
		                   </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=Temployee.ALIAS_SEX%><FONT color="red">*</FONT>
		                  </td>
			              <td>
			              		 <mytag:select property="%{model.sex}"    name="sex"   notEmpty="false" styleClass="required validate-selection select" dictName="T_DIC_SEX"/>
		                  </td>
                          <td class="crosscolor_td">
			                      <%=Temployee.ALIAS_BIRTH%><FONT color="red">*</FONT>
		                  </td>
			              <td>
		                           <input value="${model.birth}" onclick="WdatePicker({dateFmt:'yyyy-MM-dd'})" id="birth" name="birth"  maxlength="0" class="required Wdate" />
		                           
		                  </td>
                   </tr>
                   
                    <tr class="crosscolor_tr">
		           		<td class="crosscolor_td">
			                      <%=Temployee.ALIAS_FOLK%><FONT color="red">*</FONT>
		                  </td>
			              <td>
			              		 <mytag:select property="%{model.folk}"    name="folk"   notEmpty="false" styleClass="required validate-selection select" dictName="T_DIC_NATION"/>
			              		 
		                  </td>
		            	<td class="crosscolor_td">
			                      <%=Temployee.ALIAS_ALIAS%>
		                  </td>
			              <td>
		                           <s:textfield label="%{@vs@ALIAS_ALIAS}" key="alias" value="%{model.alias}"  cssClass="max-length-30" required="false" />
		                  </td>
		            </tr>
		           <tr class="crosscolor_tr">
		           		  <td class="crosscolor_td">
			                      <%=Temployee.ALIAS_NPCODE%><FONT color="red">*</FONT>
		                  </td>
			              <td>
			              	 <mytag:select property="%{model.npcode}"    name="npcode"   notEmpty="false" styleClass="required validate-selection select" dictName="T_DIC_XZQH"/>
		                  </td>
                          <td class="crosscolor_td">
			                      <%=Temployee.ALIAS_NPADDRESS%><FONT color="red">*</FONT>
		                  </td>
			              <td>
		                           <s:textfield label="%{@vs@ALIAS_NPADDRESS}" key="npaddress" value="%{model.npaddress}"  cssClass=" required max-length-200" required="false" />
		                  </td>
		                  
		             </tr>
		                <tr class="crosscolor_tr">
                          
                          <td class="crosscolor_td">
			                      <%=Temployee.ALIAS_NATIVEPLACE%>
		                  </td>
			              <td>
			              		 <mytag:select property="%{model.nativeplace}"    name="nativeplace"   notEmpty="false" styleClass="validate-selection select" dictName="T_DIC_XZQH"/>
		                  </td>
		                   <td class="crosscolor_td">
			                      <%=Temployee.ALIAS_ADDRESS%>
		                  </td>
			              <td>
		                           <s:textfield label="%{@vs@ALIAS_ADDRESS}" key="address" value="%{model.address}"  cssClass="max-length-200" required="false" />
		                  </td>
                   </tr>
                    <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=Temployee.ALIAS_TEMPORARYCODE%>
		                  </td>
			              <td>
		                           <s:textfield label="%{@vs@ALIAS_TEMPORARYCODE}" key="temporarycode" value="%{model.temporarycode}"  cssClass="max-length-16" required="false" />
		                  </td>
		                  <td class="crosscolor_td">
			                      <%=Temployee.ALIAS_NOWADRESS%><FONT color="red">*</FONT>
		                  </td>
			              <td>
		                           <s:textfield label="%{@vs@ALIAS_NOWADRESS}" key="nowadress" value="%{model.nowadress}"  cssClass="required max-length-200" required="false" />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
		          		 <td class="crosscolor_td">
			                      <%=Temployee.ALIAS_HYZH%>
		                  </td>
			              <td>
			              		 <mytag:select property="%{model.hyzh}"    name="hyzh"   notEmpty="false" styleClass=" validate-selection select" dictName="T_DIC_HYZK"/>
		                  </td>
                          <td class="crosscolor_td">
			                      <%=Temployee.ALIAS_POLITYVISAGE%>
		                  </td>
			              <td>
			              		 <mytag:select property="%{model.polityvisage}"    name="polityvisage"   notEmpty="false" styleClass="validate-selection select" dictName="partyvisage"/>
		                  </td>
		            </tr>
		            <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=Temployee.ALIAS_SCHOOLAGE%>
		                  </td>
			              <td>
			              		 <mytag:select property="%{model.schoolage}"    name="schoolage"   notEmpty="false" styleClass="validate-selection select" dictName="educations"/>
		                  </td>
                          <td class="crosscolor_td">
			                      <%=Temployee.ALIAS_PHONE%>
		                  </td>
			              <td>
		                           <s:textfield label="%{@vs@ALIAS_PHONE}" key="phone" value="%{model.phone}"  cssClass="validate-mobile-phone max-length-20" required="false" />
		                  </td>
                   </tr>
                     <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=Temployee.ALIAS_POSTURE%>
		                  </td>
			              <td>
			              		 <mytag:select property="%{model.posture}"    name="posture"   notEmpty="false" styleClass="validate-selection select " dictName="T_DIC_SHAPE"/>
		                  </td>
                          
                          <td class="crosscolor_td">
			                      <%=Temployee.ALIAS_WEIGHT%>
		                  </td>
			              <td>
		                           <s:textfield label="%{@vs@ALIAS_WEIGHT}" key="weight" value="%{model.weight}"  cssClass="max-length-3" required="false" />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
		                <td class="crosscolor_td">
			                      <%=Temployee.ALIAS_STATURE%>
		                  </td>
			              <td>
		                           <s:textfield label="%{@vs@ALIAS_STATURE}" key="stature" value="%{model.stature}"  cssClass="max-length-3" required="false" />
		                  </td>
		                   <td class="crosscolor_td">
			                      <%=Temployee.ALIAS_CYRJZT%><FONT color="red">*</FONT>
		                  </td>
			              <td>
			              			 <mytag:select property="%{model.cyrjzt}"    name="cyrjzt" onchange="cyryzt()"  notEmpty="false" styleClass="required validate-selection select" dictName="cyryFlag"/>
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=Temployee.ALIAS_INDATE%><FONT color="red">*</FONT>
		                  </td>
			              <td>
			             	 <input value="${model.indate}" onclick="WdatePicker({dateFmt:'yyyy-MM-dd'})" id="indate" name="indate"  maxlength="0" class="required Wdate" />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=Temployee.ALIAS_LEFTDATE%>
		                  </td>
			              <td>
			             		 <input value="${model.leftdate}" onclick="WdatePicker({dateFmt:'yyyy-MM-dd'})" id="leftdate" name="leftdate"  maxlength="0" class="Wdate" />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=Temployee.ALIAS_EMPDUTY%><FONT color="red">*</FONT>
		                  </td>
			              <td>
			              	 <mytag:select property="%{model.empduty}"    name="empduty"   notEmpty="false" styleClass="required validate-selection select" dictName="T_DIC_EMPTYPE"/>
		                  </td>
                          <td class="crosscolor_td">
			                      <%=Temployee.ALIAS_INSERTTIME%><FONT color="red">*</FONT>
		                  </td>
			              <td>
		                       <input value="${model.inserttime}" Disabled ="true" onclick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss'})" id="inserttime1" name="inserttime1"  maxlength="0" class=" required Wdate" />
		                       <input value="${model.inserttime}"  type="hidden" id="inserttime" name="inserttime"  />
		                  </td>
                   </tr>
 
	        <tr >
					 <td colspan="4" class="tb_bottom">
	                        <input id="submitButton" name="submitButton" type="submit" value="提交" />
	                        <input type="button" value="返回" onclick="window.location='${ctx}/pages/gas/Temployeegas/qylist.do?<mytag:params includes="ec*,s*" type="queryStringUtf"/>'"/>   
					 </td>
			</tr>
	</table>
</s:form>

<script>
	function cyryzt(){
		var provinceId = document.getElementsByName('cyrjzt')[0].value;
		if(provinceId == "1"){  
			document.getElementsByName('leftdate')[0].addClassName("required");
		}else{  
			document.getElementsByName('leftdate')[0].removeClassName("required");
		}
	}
	
	
	new Validation(document.forms[0],{onSubmit:true,onFormValidate : function(result,form) {
		var finalResult = result;
		
		//在这里添加自定义验证
		
		return disableSubmit(finalResult,'submitButton');
	}});
</script>

</body>

</html>