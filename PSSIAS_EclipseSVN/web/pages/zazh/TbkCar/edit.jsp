<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/commons/taglibs.jsp" %>
<%
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+request.getContextPath()+"/";

%>
<html>

<head>
	<%@ include file="/commons/meta.jsp" %>
	<base href="<%=basePath%>">
	<title><%=TbkCar.TABLE_ALIAS%>编辑</title>
</head>

<body onload="quickSelectInit()" >
<%@ include file="/commons/messages.jsp" %>

<s:form action="/pages/zazh/TbkCar/update.do"  enctype="multipart/form-data"    theme="simple"  method="post">
	<table width="100%" border="1" bordercolor="#7c8ca7" align="center"  cellPadding="0" cellSpacing="0" class="tb_all">
	    <input type="hidden" name="returnUrl" value="!/pages/zazh/TbkCar/list.do?<mytag:params includes="ec*,s*" type="queryStringUtf"/>" />
	        <tr>
				      <td colspan="4" class="tb_title"> 
							车辆布控编辑
				     </td>
		    </tr>
	               <%@ include file="form_include.jsp" %>
	        <tr >
					 <td colspan="4" class="tb_bottom">
	                        <input id="submitButton" name="submitButton" type="submit" value="提交" />
	                        <input type="button" value="返回" onclick="window.location='${ctx}/pages/zazh/TbkCar/list.do?<mytag:params includes="ec*,s*" type="queryStringUtf"/>'"/>   
					 </td>
			</tr>
	</table>
</s:form>

<script>
	
	new Validation(document.forms[0],{onSubmit:true,onFormValidate : function(result,form) {
		var finalResult = result;
		
		//在这里添加自定义验证
				//在这里添加自定义验证
		var carcode = document.getElementById('update_carcode').value;
		var bodycode = document.getElementById('update_bodycode').value;
		var enginecode = document.getElementById('update_enginecode').value;
		if(carcode=="" && bodycode=="" && enginecode==""){
		   alert("车牌号,车架号和发动机号至少输入一项！");
		   finalResult = false;
		}
		return disableSubmit(finalResult,'submitButton');
	}});
</script>

</body>

</html>