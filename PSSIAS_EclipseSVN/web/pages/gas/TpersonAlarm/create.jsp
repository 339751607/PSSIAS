
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/commons/taglibs.jsp" %>
<%
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+request.getContextPath()+"/";
%>
<html>
<head>
	<%@ include file="/commons/meta.jsp" %>
	<base href="<%=basePath%>">
	<title><%=TpersonAlarm.TABLE_ALIAS%>新增</title>
</head>
<body>
<%@ include file="/commons/messages.jsp" %>

<s:form action="/pages/gas/TpersonAlarm/save.do" theme="simple"  method="post">
	<table width="100%" border="1" bordercolor="#7c8ca7" align="center"  cellPadding="0" cellSpacing="0" class="tb_all">
	    <input type="hidden" name="returnUrl" value="!/pages/gas/TpersonAlarm/list.do?<mytag:params includes="ec*,s*" type="queryStringUtf"/>" />
	       <tr>
				<td colspan="4" class="tb_title"> 
							<%=TpersonAlarm.TABLE_ALIAS%>新增
			    </td>
		   </tr>
	<%@ include file="form_include.jsp" %>
	       <tr >
				<td colspan="4" class="tb_bottom">
							<input id="submitButton" name="submitButton" type="submit" value="提交" />
	                        <input type="button" value="返回" onclick="window.location='${ctx}/pages/gas/TpersonAlarm/list.do?<mytag:params includes="ec*,s*" type="queryStringUtf"/>'"/>
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