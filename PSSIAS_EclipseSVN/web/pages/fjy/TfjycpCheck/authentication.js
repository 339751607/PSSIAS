$(document).ready(function (){

 $("#zg").click(function() {
  document.getElementById("overlay").style.display="block";
  document.getElementById("tishi").style.display="block";
document.getElementById("hsdk").contentWindow.location.reload(true); 
 });


 $("#cancel").click(function () {
  document.getElementById("overlay").style.display="none";
  document.getElementById("tishi").style.display="none";
 });

});

function authentication(){
	var url=document.getElementById("jqueryUrl").value;
    var idcard=document.getElementById("idcard").value;
   
    var t_emptype=document.getElementById("t_emptype").value;
	var jqueryUrl=url+"authentication.do?ajax=true&t_emptype="+t_emptype+"&idcard="+idcard;

	$.post(jqueryUrl, function(data) {
		if(data=="true")
			goToCreate(url,idcard,t_emptype);
		else
		alert("验证失败！身份证未在系统注册，请到后台注册。");
		
	});
}
function goToCreate(url,idcard,t_emptype){
	window.location=url+"create.do?t_emptype="+t_emptype+"&idcard="+idcard;
}