<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/commons/taglibs.jsp" %>
<%
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+request.getContextPath()+"/";
%>
<html>

<head>
	<%@ include file="/commons/meta.jsp" %>
	<base href="<%=basePath%>">
	<title>处警管理</title>
</head>

<body onload="quickSelectInit()" >
<%@ include file="/commons/messages.jsp" %>

<s:form action="/pages/gas/TpersonAlarm/update.do"  theme="simple"  method="post">
	<table width="100%" border="1" bordercolor="#7c8ca7" align="center" 	cellPadding="0" cellSpacing="0" class="tb_all">
	    <input type="hidden" name="returnUrl" value="!/pages/gas/TpersonAlarm/list.do?<mytag:params includes="ec*,s*" type="queryStringUtf"/>" />
	        <tr>
				      <td colspan="4" class="tb_title"> 
							处警管理
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

//是否有效改变事件
 function  sfyxchange(){
 
 	var provinceId = document.getElementsByName('sfyx')[0].value;
	if(provinceId == "1"){ //无效
		document.getElementsByName('wxyy')[0].addClassName("required");
		document.getElementsByName('zhqk')[0].value ="1";
		zhqkchange();
		document.getElementsByName('zhqk')[0].disabled=true;
		document.getElementsByName('zhdwmc')[0].value="";
		document.getElementsByName('zhsj')[0].value="";
		document.getElementsByName('zhdwmc')[0].disabled=true;
		document.getElementsByName('zhsj')[0].disabled=true;
		document.getElementsByName('wxyy')[0].disabled=false;
	}else{ //有效等
		document.getElementsByName('wxyy')[0].removeClassName("required");
		document.getElementsByName('zhqk')[0].value ="";
		document.getElementsByName('wxyy')[0].value ="";
		zhqkchange();
		document.getElementsByName('zhqk')[0].disabled=false;
		document.getElementsByName('zhdwmc')[0].disabled=false;
		document.getElementsByName('wxyy')[0].disabled=true;
		document.getElementsByName('zhsj')[0].disabled=false;
	}
 }

//抓获情况改变事件
 function  zhqkchange(){
 	var zhqk = document.getElementsByName('zhqk')[0].value;
 	if(zhqk == "1"){ //未抓获
 		document.getElementsByName('wzhyy')[0].addClassName("required");
 		document.getElementsByName('zhdwmc')[0].removeClassName("required");
 		document.getElementsByName('zhsj')[0].removeClassName("required");
 		document.getElementsByName('clqk')[0].addClassName("required");
 		document.getElementsByName('zhdwmc')[0].value="";
		document.getElementsByName('zhsj')[0].value="";
		document.getElementsByName('zhdwmc')[0].disabled=true;
		document.getElementsByName('zhsj')[0].disabled=true;
		document.getElementsByName('wzhyy')[0].disabled=false;
 	}else if(zhqk == "0"){ //已抓获
 		document.getElementsByName('wzhyy')[0].removeClassName("required");
 		document.getElementsByName('zhdwmc')[0].addClassName("required");
 		document.getElementsByName('zhsj')[0].addClassName("required");
 		document.getElementsByName('clqk')[0].addClassName("required");
 		document.getElementsByName('wzhyy')[0].disabled=true;
 	}else { //已派警
 		document.getElementsByName('wzhyy')[0].removeClassName("required");
 		document.getElementsByName('zhdwmc')[0].removeClassName("required");
 		document.getElementsByName('zhsj')[0].removeClassName("required");
 		document.getElementsByName('clqk')[0].removeClassName("required");
 		document.getElementsByName('wzhyy')[0].disabled=false;
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