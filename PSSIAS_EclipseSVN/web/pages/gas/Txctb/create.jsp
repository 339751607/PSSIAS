
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/commons/taglibs.jsp" %>
<%
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+request.getContextPath()+"/";
%>
<html>
<head>
	<%@ include file="/commons/meta.jsp" %>
	<base href="<%=basePath%>">
	<title><%=Txctb.TABLE_ALIAS%>新增</title>
</head>
<body>
<%@ include file="/commons/messages.jsp" %>

<s:form action="/pages/gas/Txctb/save.do" theme="simple"  enctype="multipart/form-data"  method="post">
	<table width="100%" border="1" bordercolor="#7c8ca7" align="center" 	cellPadding="0" cellSpacing="0" class="tb_all">
	    <input type="hidden" name="returnUrl" value="!/pages/gas/Txctb/list.do?<mytag:params includes="ec*,s*" type="queryStringUtf"/>" />
	       <tr>
				<td colspan="4" class="tb_title"> 
							<%=Txctb.TABLE_ALIAS%>新增
			    </td>
		   </tr>
	<%@ include file="form_include.jsp" %>
	
     <input type="hidden" id="zp2"  value=""/> 
     <input type="hidden" id="zp3" value=""/> 
			              
	       <tr >
				<td colspan="4" class="tb_bottom">
							<input id="submitButton" name="submitButton" type="submit" value="下发" />
	                        <input type="button" value="返回" onclick="window.location='${ctx}/pages/gas/Txctb/list.do?<mytag:params includes="ec*,s*" type="queryStringUtf"/>'"/>
			    </td>
	        </tr>
	</table>
</s:form>

<script>
	
	new Validation(document.forms[0],{onSubmit:true,onFormValidate : function(result,form) {
		var finalResult = result;
		
		//在这里添加自定义验证
		if(document.getElementsByName('zpl1')[0].value=="1"){
			document.getElementById('zp1').style.borderColor = 'red';
			finalResult=false;
		}else{
			document.getElementById('zp1').style.borderColor = '';
		}
		if(document.getElementsByName('zpl2')[0].value=="1"){
			document.getElementById('zp2').style.borderColor = 'red';
			finalResult=false;
		}else{
			document.getElementById('zp2').style.borderColor = '';
		}
		if(document.getElementsByName('zpl3')[0].value=="1"){
			document.getElementById('zp3').style.borderColor = 'red';
			finalResult=false;
		}else{
			document.getElementById('zp3').style.borderColor = '';
		}
		if(document.getElementsByName('fj')[0].value=="1"){
			document.getElementsByName('affix')[0].style.borderColor = 'red';
			finalResult=false;
		}else{
			document.getElementsByName('affix')[0].style.borderColor = '';
		}
		
		return disableSubmit(finalResult,'submitButton');
	}});
</script>
</body>
</html>