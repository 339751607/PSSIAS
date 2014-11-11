<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/commons/taglibs.jsp" %>
<%
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+request.getContextPath()+"/";
%>
<html>

<head>
	<%@ include file="/commons/meta.jsp" %>
	<base href="<%=basePath%>">
	<title><%=SsUser.TABLE_ALIAS%>编辑</title>
</head>

<body onload="quickSelectInit()" >
<%@ include file="/commons/messages.jsp" %>

<s:form action="/pages/SsUser/update.do"  theme="simple"  method="post">

	
	<table cellpadding="0" cellspacing="0" border="0" class="tb_all">
	        <tr>
				      <td colspan="4" class="tb_title"> 
							<%=SsUser.TABLE_ALIAS%>编辑
				     </td>
		    </tr>
	               <%@ include file="form_include.jsp" %>
	        <tr >
					 <td colspan="4" class="tb_bottom">
	                        <input id="submitButton" name="submitButton" type="submit" value="提交" />
	                        <input type="button" value="返回列表" onclick="window.location='${ctx}/pages/SsUser/list.do'"/>
	                        <input type="button" value="后退" onclick="history.back();"/>
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