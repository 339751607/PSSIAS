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
	<title><%=Tconfig.TABLE_ALIAS%>编辑</title>
</head>

<body onload="quickSelectInit()" >
<%@ include file="/commons/messages.jsp" %>

<s:form action="/pages/gas/Tconfig/update.do"  theme="simple"  method="post">
	<table width="100%" border="1" bordercolor="#7c8ca7" align="center"  cellPadding="0" cellSpacing="0" class="tb_all">
	    <input type="hidden" name="returnUrl" value="!/pages/gas/Tconfig/list.do?<mytag:params includes="ec*,s*" type="queryStringUtf"/>" />
	        <tr>
				      <td colspan="4" class="tb_title"> 
							重点来源地行政区划修改
				     </td>
		    </tr>
	               	<s:hidden id="key" name="key" />
                   <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                   行政区划
		                  </td>
			              <td colspan="3">
                          	 <mytag:select property="%{model.burcode}"   onchange="changeprov();"  styleClass=" validate-selection"  name="prov"   notEmpty="false"  dictName="T_DICT_PROV"/>
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                     行政区划值
		                  </td>
		                   <td colspan="3">
		                  	 <s:hidden label="%{@vs@ALIAS_CODE}" key="code" value="%{model.code}"  cssClass=" required  max-length-128" required="false" />
		                     <s:textfield label="%{@vs@ALIAS_NAME}" key="name" value="%{model.name}" style="width:600px ;"  readonly ="true" cssClass="required max-length-100" required="false" />
		                  </td>
                   </tr>
		           
	        <tr >
					 <td colspan="4" class="tb_bottom">
	                        <input id="submitButton" name="submitButton" type="submit" value="提交" />
	                         <input onclick="javascript:resetData();"	type="button" value="重置">
	                        <input type="button" value="返回" onclick="window.location='${ctx}/pages/gas/Tconfig/list.do?<mytag:params includes="ec*,s*" type="queryStringUtf"/>'"/>   
					 </td>
			</tr>
	</table>
</s:form>

<script>
  function resetData(){
		document.getElementsByName('name')[0].value = "";
		document.getElementsByName('code')[0].value = "";
  }
	
	function changeprov()
	{
		 var provinceId =document.getElementsByName('prov')[0].value;
		var deptname = document.getElementsByName('prov')[0].options[document.getElementsByName('prov')[0].selectedIndex].text;
		if(provinceId !=""){
			var code = document.getElementsByName('code')[0].value;
			var name = document.getElementsByName('name')[0].value;
			if(name ==""){
				document.getElementsByName('name')[0].value = deptname;
				document.getElementsByName('code')[0].value = provinceId;
			}else{
				document.getElementsByName('name')[0].value = name+","+deptname;
				document.getElementsByName('code')[0].value = code+","+provinceId;
			}
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