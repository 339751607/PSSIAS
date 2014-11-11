
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
	<title><%=Tbuylog.TABLE_ALIAS%>新增</title>
</head>
<body onload=" ">
<%@ include file="/commons/messages.jsp" %>

<s:form action="/pages/gas/Tbuylog/save.do" theme="simple"  method="post">
	<table width="100%" border="1" bordercolor="#7c8ca7" align="center"  cellPadding="0" cellSpacing="0" class="tb_all">
	    <input type="hidden" name="returnUrl" value="!/pages/gas/Tbuylog/list.do?<mytag:params includes="ec*,s*" type="queryStringUtf"/>" />
	       <tr>
				<td colspan="5" class="tb_title"> 
							<%=Tbuylog.TABLE_ALIAS%>新增
			    </td>
		   </tr>
	<%@ include file="form_include.jsp" %>
	       <tr >
				<td colspan="5" class="tb_bottom">
							<input id="submitButton" name="submitButton" type="submit" value="保存" />
	                        <input type="reset" value="重置" />
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
	
	document.getElementById("name").value= "";
   	document.getElementById("sex").value="";
   	document.getElementById("nation").value = "";
	document.getElementById("bdate").value="";
    document.getElementById("idName").value="";
    document.getElementById("idCode").value="";
    document.getElementById("xzqh").value="";
    document.getElementById("address").value = "";
    document.getElementById("pPhotoBuffer").value = "";
    
	document.getElementById("workunit").value="";
    document.getElementById("phone").value="";
    document.getElementById("use").value="";
    document.getElementById("buytype").value="";
    document.getElementById("sort").value = "";
    document.getElementById("quantity").value = "";
    document.getElementById("operator").value = "";
}

	//提取身份信息
	function showBirthday() {
	 if(document.all.idName.value =="11" ||document.all.idName.value =="12"|| document.all.idName.value =="13" || document.all.idName.value =="94"){
	 	var birthdayValue,xzqhs,val,provId;
		val = document.all.idCode.value;
		var reg = /(^\d{15}$)|(^\d{18}$)|(^\d{17}(\d|X|x)$)/;  
	   if(reg.test(val) === false)  
	   {  
	       alert("证件号码输入不合法");  
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
				document.all.bdate.value = birthdayValue;
				document.all.xzqh.value = xzqhs;
				
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
				document.all.bdate.value = birthdayValue;
				document.all.xzqh.value = xzqhs;
			}
		 }
	 }
		
	}
	
	
	
	
	
	function sfzhSetxzqh(provinceId,xzqhValue)
	{
	    DWRUtil.setValue('npcodehidden',xzqhValue);
		menu.queryXzqhById(provinceId,cityCallback2);	
	}
	
	function sfzhSetxzqh2(provinceId,xzqhValue)
	{
	    DWRUtil.setValue('nativeplacehidden',xzqhValue);
		menu.queryXzqhById(provinceId,cityCallback);	
	}
	
	
	//查询所属城市回调函数
	function cityCallback(citys)
	{
      //每次获得新的数据的时候先把每三个下拉框架的长度清0
	   DWRUtil.removeAllOptions("nativeplace");
        try{
           // DWRUtil.addOptions("xzqh",{'':'请选择...'});  
            DWRUtil.addOptions("nativeplace",citys,"id","cityName");//将option对象添加到第三个下拉框中    
            DWRUtil.setValue('nativeplace',$F("nativeplacehidden")); 
        }catch(e){
        }
     
	}
	
		//查询所属城市回调函数
	function cityCallback2(citys)
	{
      //每次获得新的数据的时候先把每三个下拉框架的长度清0
	   DWRUtil.removeAllOptions("npcode");
        try{
           // DWRUtil.addOptions("xzqh",{'':'请选择...'});  
            DWRUtil.addOptions("npcode",citys,"id","cityName");//将option对象添加到第三个下拉框中
           
            DWRUtil.setValue('npcode',$F("npcodehidden")); 
        }catch(e){
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