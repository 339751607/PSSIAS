
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/commons/taglibs.jsp" %>
<%
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+request.getContextPath()+"/";
%>
<html>
<head>
	<%@ include file="/commons/meta.jsp" %>
	<base href="<%=basePath%>">
	<title><%=Shxx.TABLE_ALIAS%>新增</title>
</head>
<body onload="quickSelectInit()">
<%@ include file="/commons/messages.jsp" %>

<s:form action="/pages/pmdd/Shxx/save.do" theme="simple"  method="post">
	<table cellpadding="0" cellspacing="0" border="0" class="tb_all">
	    <input type="hidden" name="returnUrl" value="!/pages/pmdd/Shxx/list.do?<mytag:params includes="ec*,s*" type="queryStringUtf"/>" />
	       <tr>
				<td colspan="4" class="tb_title"> 
							<%=Shxx.TABLE_ALIAS%>新增
			    </td>
		   </tr>
	<%@ include file="form_include.jsp" %>
	       <tr >
				<td colspan="4" class="tb_bottom">
							<input id="submitButton" name="submitButton" type="submit" value="提交" />
	                        <input type="button" value="返回" onclick="window.location='${ctx}/pages/pmdd/Shxx/list.do?<mytag:params includes="ec*,s*" type="queryStringUtf"/>'"/>
			    </td>
	        </tr>
	</table>
</s:form>

<script>
	
	new Validation(document.forms[0],{onSubmit:true,onFormValidate : function(result,form) {
		var finalResult = result;
		
		//在这里添加自定义验证
		if(finalResult) {
			     if( ($F("yxzj")=="11" || $F("yxzj")=="12") && $F("shrsfzhm").length > 0  ) {
			          if(!f_check_IDno($F("shrsfzhm"))){
			             alert("身份证号错误！\r\n请重新确认身份证号，X请输入大写");	
			             finalResult = false;
			             }
			      }
		      }
		
		return disableSubmit(finalResult,'submitButton');
	}});
</script>

</body>
</html>