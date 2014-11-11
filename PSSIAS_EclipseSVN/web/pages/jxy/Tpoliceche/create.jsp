
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/commons/taglibs.jsp" %>

<%
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+request.getContextPath()+"/";
%>
<html>
<head>
	<%@ include file="/commons/meta.jsp" %>
	<base href="<%=basePath%>">
	<title><%=Tpoliceche.TABLE_ALIAS%>新增</title>
</head>
<body>
<%@ include file="/commons/messages.jsp" %>

<s:form action="/jxy/Tpoliceche/save.do" theme="simple"  method="post">
	<table cellpadding="0" cellspacing="0" border="0" class="tb_all">
	    <input type="hidden" name="returnUrl" value="!/jxy/Tpoliceche/list.do?<mytag:params includes="ec*,s*" type="queryStringUtf"/>" />
	       <tr>
				<td colspan="6" class="tb_title"> 
							<%=Tpoliceche.TABLE_ALIAS%>新增
			    </td>
		   </tr>
	<%@ include file="form_include.jsp" %>
	       <tr >
				<td colspan="6" class="tb_bottom">
							<input id="submitButton" name="submitButton" type="submit" value="提交" />
	                        <input type="button" value="返回" onclick="window.location='${ctx}/jxy/Tpoliceche/list.do?<mytag:params includes="ec*,s*" type="queryStringUtf"/>'"/>
			    </td>
	        </tr>
	</table>
</s:form>

<script>
	
	new Validation(document.forms[0],{onSubmit:true,onFormValidate : function(result,form) {
		var finalResult = result;
		
		
		//if ($(checkname2) != $(checkname2).replace(/[^\u4E00-\u9FA5]/g,'')){
  			// alert("不是中文");
		//}

		
		return disableSubmit(finalResult,'submitButton');
	}});
	
	 function selectEmp(){
	  	 var left = "50", top = "50";
	     if(arguments[3] != null) left = "dialogLeft:" + arguments[3] + "px;"
	     if(arguments[4] != null) top = "dialogTop:" + arguments[4] + "px;"
	     window.showModalDialog('${ctx}/jxy/Tpoliceche/getDept.do?flag=0&search_random='+Math.random(),
									window,
									"dialogWidth:420px;" + "dialogHeight:230px;" 
									+ left + top 
									+ "directories:yes;help:no;status:no;resizable:no;scrollbars:yes;");
		
	}
</script>

</body>
</html>
