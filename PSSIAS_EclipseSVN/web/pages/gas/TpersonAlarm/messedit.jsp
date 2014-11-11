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
<script src="<c:url value="/scripts/jquery.js"/>" type="text/javascript"></script>
<%@ include file="/commons/messages.jsp" %>

<s:form action="/pages/gas/TpersonAlarm/messupdate.do"  theme="simple"  method="post">
	<table width="100%" border="1" bordercolor="#7c8ca7" align="center" 	cellPadding="0" cellSpacing="0" class="tb_all">
	    <input type="hidden" name="returnUrl" value="!/pages/gas/TpersonAlarm/messlist.do?<mytag:params includes="ec*,s*" type="queryStringUtf"/>" />
	        <tr>
				      <td colspan="4" class="tb_title"> 
							处警管理
				     </td>
		    </tr>
	               <%@ include file="form_include.jsp" %>
	        <tr >
					 <td colspan="4" class="tb_bottom">
	                        <input id="submitButton" name="submitButton" type="submit" value="提交" />
<!--	                          <input id="submitButton" name="submitButton" type="button" onclick="setAdd(true);" value="提交" />-->
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
		zhqkchange();
		document.getElementsByName('zhqk')[0].disabled=false;
		document.getElementsByName('zhdwmc')[0].disabled=false;
		document.getElementsByName('zhsj')[0].disabled=false;
		document.getElementsByName('wxyy')[0].value ="";
		document.getElementsByName('wxyy')[0].disabled=true;
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
				
		//return disableSubmit(finalResult,'submitButton');
	}});
	
	
	
	function setAdd(){
		var id=document.getElementsByName('id')[0].value;
		var pjdw=document.getElementsByName('pjdw')[0].value;
		var cjr=document.getElementsByName('cjr')[0].value;
		var sfyx=document.getElementsByName('sfyx')[0].value;
		var pjsj=document.getElementsByName('pjsj')[0].value;
		var wxyy=document.getElementsByName('wxyy')[0].value;
		var zhqk=document.getElementsByName('zhqk')[0].value;
		var zhdwmc=document.getElementsByName('zhdwmc')[0].value;
		var zhsj=document.getElementsByName('zhsj')[0].value;
		var wzhyy=document.getElementsByName('wzhyy')[0].value;
		var clqk=document.getElementsByName('clqk')[0].value;
	 $.ajax({
		   type:"post", //请求方式
		   url:"${ctx}/pages/gas/TpersonAlarm/messupdate.do", //发送请求地址
		   data:{ id:id ,pjdw:pjdw,cjr:cjr,sfyx:sfyx,pjsj:pjsj,zhqk:zhqk,zhdwmc:zhdwmc,zhsj:zhsj,wzhyy:wzhyy,clqk:clqk,wxyy:wxyy
		   },
		  complete : function(XMLHttpRequest, textStatus, errorThrown) {       
		    alert( "处警成功!" );
		    window.returnValue="1"; 
		    window.close();
           } 
		});
	}
	
	new Validation(document.forms[0],{onSubmit:true,onFormValidate : function(result,form) {
		var finalResult = result;
		if(finalResult== true){
			setAdd();
		}
		return disableSubmit(finalResult,'submitButton');
	}});
</script>

</body>

</html>