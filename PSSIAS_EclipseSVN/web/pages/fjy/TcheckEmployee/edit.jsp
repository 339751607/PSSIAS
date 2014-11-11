<%@page import="com.dyneinfo.fjy.model.*" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/commons/taglibs.jsp" %>
<%

String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+request.getContextPath()+"/";
%>
<html>

<head>
	<%@ include file="/commons/meta.jsp" %>
	<base href="<%=basePath%>">
	<title><%=TcheckEmployee.TABLE_ALIAS%>编辑</title>
</head>

<body onload="quickSelectInit()" >
<%@ include file="/commons/messages.jsp" %>
<%@ include file="/commons/selectDept.jsp" %>
<s:form action="/pages/fjy/TcheckEmployee/update.do"   name="inputForm"  theme="simple"  method="post">
<s:hidden id="id" name="id" />
	<table cellpadding="0" cellspacing="0" border="1" class="tb_all">
	    <input type="hidden" name="returnUrl" value="!/pages/fjy/TcheckEmployee/list.do?<mytag:params includes="ec*,s*" type="queryStringUtf"/>" />
	        <tr>
				      <td colspan="4" class="tb_title"> 
							<%=TcheckEmployee.TABLE_ALIAS%>编辑
				     </td>
		    </tr>
	         <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <FONT color="red">*</FONT> <%=TcheckEmployee.ALIAS_IDCARD%>
		                  </td>
			              <td>
		                           <s:textfield label="%{@vs@ALIAS_IDCARD}" key="idcard" value="%{model.idcard}"  cssClass="required max-length-18 validate-id-number" required="false" />
		                  </td>
                          <td class="crosscolor_td">
			                     <FONT color="red">*</FONT>  <%=TcheckEmployee.ALIAS_EMPTYPE%>
		                  </td>
			              <td>
						           <mytag:select property="%{model.emptype}"   styleClass="required validate-selection" onchange ="showorhidden();" name="emptype"   notEmpty="false"  dictName="D_empType"/>
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <FONT color="red">*</FONT> <%=TcheckEmployee.ALIAS_FULLNAME%>
		                  </td>
			              <td>
		                           <s:textfield label="%{@vs@ALIAS_FULLNAME}" key="fullname" value="%{model.fullname}"  cssClass="required max-length-50" required="false" />
		                  </td>
                          <td class="crosscolor_td">
			                     <FONT color="red">*</FONT>  <%=TcheckEmployee.ALIAS_SEX%>
		                  </td>
			              <td>
						           <mytag:select property="%{model.sex}"   styleClass="required validate-selection"  name="sex"   notEmpty="false"  dictName="T_DIC_SEX"/>
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr" id="myTr">
                          <td class="crosscolor_td">
			                      <%=TcheckEmployee.ALIAS_POLICENO%>
		                  </td>
			              <td>
		                           <s:textfield label="%{@vs@ALIAS_POLICENO}" key="policeno" value="%{model.policeno}"  cssClass="max-length-6" required="false" />
		                  </td>
		              <tr class="crosscolor_tr" id="ssjg">              
                    <td class="crosscolor_td" >
			     			<FONT color="red">*</FONT>所属公安机关
			     			</td>
			     			<td colspan="3">
			     			<select id="sj" style="width: 150px">
								<option  value="<%=mpcode%>">市公安局</option>
							</select>
                    		<select id="fjid" onchange="getPcs('fjid','pcsid');" style="width: 150px">
								<option>请选择...</option>
							</select>
							<select id="pcsid"  style="width: 150px">
								<option>请选择...</option>
							</select>
							</td>
							<input type="hidden" name="deptid" id="deptid" value="${deptseq}" size="60"/>
                    		

					</tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=TcheckEmployee.ALIAS_DEMO%>
		                  </td>
			           <td colspan="3">
			              
			               <s:textarea label="%{@vs@ALIAS_DEMO}" rows="4" cols="60"
							key="demo" value="%{model.demo}" cssClass="max-length-2000"
							required="false"></s:textarea>
							
		                        </td>
                          
                   </tr>
	        <tr >
					 <td colspan="4" class="tb_bottom">
	                        <input id="submitButton" name="submitButton" type="submit" value="提交" />
	                        <input type="button" value="返回" onclick="window.location='${ctx}/pages/fjy/TcheckEmployee/list.do?<mytag:params includes="ec*,s*" type="queryStringUtf"/>'"/>   
					 </td>
			</tr>
	</table>
</s:form>

<script>
	showorhidden();
	function showorhidden(){
		var enptype = document.getElementById("emptype").value;
		var myTr= document.getElementById("myTr"); 
		var ssjg= document.getElementById("ssjg"); 
		if("01" == enptype){
			myTr.style.display ="block";
			ssjg.style.display ="block";
		}else{
			myTr.style.display ="none";
			ssjg.style.display ="none";
		}
	}
	
	new Validation(document.forms[0],{onSubmit:true,onFormValidate : function(result,form) {
		var finalResult = result;
		
		//在这里添加自定义验证
		submitValueId('fjid','pcsid','','deptid')
		return disableSubmit(finalResult,'submitButton');
	}});

		setValueSelect('fjid','pcsid','','deptid')	   
</script>

</body>

</html>