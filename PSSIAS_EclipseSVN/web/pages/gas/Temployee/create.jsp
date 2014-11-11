
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/commons/taglibs.jsp" %>
<%
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+request.getContextPath()+"/";
%>
<html>
<head>
	<%@ include file="/commons/meta.jsp" %>
	<base href="<%=basePath%>">
	<link href="<c:url value="/widgets/ext-3.0.0/resources/css/ext-all.css"/>" type="text/css" rel="stylesheet">
	<script src="<c:url value="/widgets/ext-3.0.0/adapter/ext/ext-base.js"/>" type="text/javascript"></script>
	<script src="<c:url value="/widgets/ext-3.0.0/ext-all.js"/>" type="text/javascript"></script>
	<title><%=Temployee.TABLE_ALIAS%>新增</title>
</head>
<body>
<%@ include file="/commons/messages.jsp" %>

<s:form action="/pages/gas/Temployeegas/save.do" theme="simple"  method="post">
	<table width="100%" border="1" bordercolor="#7c8ca7" align="center"  cellPadding="0" cellSpacing="0" class="tb_all">
	    <input type="hidden" name="returnUrl" value="!/pages/gas/Temployeegas/list.do?<mytag:params includes="ec*,s*" type="queryStringUtf"/>" />
	       <tr>
				<td colspan="5" class="tb_title"> 
							<%=Temployee.TABLE_ALIAS%>新增
			    </td>
		   </tr>
	<%@ include file="form_include.jsp" %>
	       <tr >
				<td colspan="5" class="tb_bottom">
							<input id="submitButton" name="submitButton" type="submit" value="提交" />
							 <input type="reset" value="重置" />
<!--	                        <input type="button" value="返回" onclick="window.location='${ctx}/pages/gas/Temployeegas/list.do?<mytag:params includes="ec*,s*" type="queryStringUtf"/>'"/>-->
			    </td>
	        </tr>
	</table>
</s:form>

<script>


if('${mgs}'!=""){
	var xz="no";
	Ext.MessageBox.buttonText.yes = "是";  
	Ext.MessageBox.buttonText.no = "否<span id='tiao'>(10)</span>";  
	Ext.MessageBox.alert("提示",'${mgs}');
	
	document.getElementById("empname").value= "";
   	document.getElementById("personid").value="";
   	document.getElementById("sex").value = "";
	document.getElementById("birth").value="";
    document.getElementById("folk").value="";
    document.getElementById("alias").value="";
    document.getElementById("npcode").value="";
    document.getElementById("npaddress").value = "";
    document.getElementById("pPhotoBuffer").value = "";
    
	document.getElementById("nativeplace").value="";
    document.getElementById("address").value="";
    document.getElementById("temporarycode").value="";
    document.getElementById("nowadress").value="";
    document.getElementById("hyzh").value = "";
    document.getElementById("polityvisage").value = "";
    document.getElementById("schoolage").value = "";
    document.getElementById("phone").value = "";
    document.getElementById("posture").value = "";
    document.getElementById("weight").value = "";
    document.getElementById("stature").value = "";
    document.getElementById("cyrjzt").value = "";
    document.getElementById("indate").value = "";
    document.getElementById("leftdate").value = "";
    document.getElementById("empduty").value = "";
}

	//提取身份信息
	function showBirthday() {
	 	var birthdayValue,xzqhs,val,provId;
		val = document.all.personid.value;
		var reg = /(^\d{15}$)|(^\d{18}$)|(^\d{17}(\d|X|x)$)/;  
	   if(reg.test(val) === false)  
	   {  
	       alert("身份证输入不合法");  
	       return  false;  
	   }else{
		if (15 == val.length) {//15位身份证号码   
			birthdayValue = val.charAt(6) + val.charAt(7);
			if (parseInt(birthdayValue) < 10) {
				birthdayValue = '20' + birthdayValue;
			} else {
				birthdayValue = '19' + birthdayValue;
			}
			birthdayValue = birthdayValue + '-' + val.charAt(8) + val.charAt(9)
					+ '-' + val.charAt(10) + val.charAt(11);
			xzqhs = 	val.substr(0,6);
			if (parseInt(val.charAt(14) / 2) * 2 != val.charAt(14))
				document.all.sex.value = '1';
			else
				document.all.sex.value = '2';
			document.all.birth.value = birthdayValue;
			document.all.npcode.value = xzqhs;
			
		}
		if (18 == val.length) {//18位身份证号码   
			birthdayValue = val.charAt(6) + val.charAt(7) + val.charAt(8)
					+ val.charAt(9) + '-' + val.charAt(10) + val.charAt(11)
					+ '-' + val.charAt(12) + val.charAt(13);
			xzqhs = 	val.substr(0,6);
			if (parseInt(val.charAt(16) / 2) * 2 != val.charAt(16))
				document.all.sex.value = '1';
			else
				document.all.sex.value = '2';
			document.all.birth.value = birthdayValue;
			document.all.npcode.value = xzqhs;
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