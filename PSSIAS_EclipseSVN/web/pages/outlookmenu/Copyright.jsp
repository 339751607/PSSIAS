<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix='c' uri='http://java.sun.com/jstl/core_rt'%>
<%@ taglib prefix="authz" uri="http://www.springframework.org/security/tags"%>
<c:set var="ctx" value="${pageContext.request.contextPath}" />
<html> 
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
		<title></title>
	</head>

	<style>
a {
	color: #000000;
	text-decoration: none;
}

a:hover {
	text-decoration: underline;
}
</style>
	<script language=JavaScript>
	Date.prototype.format = function(format) //author: meizz 
			{ 
			  var o = { 
			    "M+" : this.getMonth()+1, //month 
			    "d+" : this.getDate(),    //day 
			    "h+" : this.getHours(),   //hour 
			    "m+" : this.getMinutes(), //minute 
			    "s+" : this.getSeconds(), //second 
			    "q+" : Math.floor((this.getMonth()+3)/3),  //quarter 
			    "S" : this.getMilliseconds() //millisecond 
			  } 
			  if(/(y+)/.test(format)) format=format.replace(RegExp.$1, 
			    (this.getFullYear()+"").substr(4 - RegExp.$1.length)); 
			  for(var k in o)if(new RegExp("("+ k +")").test(format)) 
			    format = format.replace(RegExp.$1, 
			      RegExp.$1.length==1 ? o[k] : 
			        ("00"+ o[k]).substr((""+ o[k]).length)); 
			  return format; 
			} 
	// 计算两个日期的间隔天数   
	function Computation(sDate1, sDate2){   //sDate1和sDate2是2008-12-13格式     
	  var aDate, oDate1, oDate2, iDays     
	  aDate = sDate1.split("-")     
	  oDate1 = new Date(aDate[1] + '-' + aDate[2] + '-' + aDate[0])   //转换为12-13-2008格式     
	  aDate = sDate2.split("-")     
	  oDate2 = new Date(aDate[1] + '-' + aDate[2] + '-' + aDate[0])     
	  iDays = parseInt(Math.abs(oDate1 - oDate2) / 1000 / 60 / 60 /24)   //把相差的毫秒数转换为天数     
	      return iDays     
	} 	
	
	  
	   	
 </script>
	<body leftmargin="0" topmargin="0" background="${ctx}/pages/outlookmenu/img/bottom_bg.gif">
		<table width="100%" cellpadding="0" cellspacing="0">
			<tr>
				<td>
					<div style="float: right; margin: 8px 10px 0px 6px;font-size: 13px;">	系统用户总数&nbsp;：&nbsp;<c:out value="${usertotal}"></c:out>&nbsp;个，
					&nbsp; &nbsp; 当前在线数&nbsp;：&nbsp;<c:out value="${usercount}"></c:out>&nbsp;个</div>
					<DIV style="float: left; margin: 8px 0px 0px 6px; font-size: 13px;">
					   <span> 部门：<authz:authentication property="principal.deptName"/>&nbsp;&nbsp;&nbsp;
						操作员：<authz:authentication property="principal.userXm" />
						</span>
					</div>

					<div style="float: left; padding: 8px 0px 0px 3px;">
						<span id="onlineUserCount"></span>&nbsp;&nbsp;
					</div>
					<div style="float: left; padding: 3px 0px 0px 0px;">

					</div>
					<div style="float: left; padding: 4px 0px 0px 15px;">
						<span> <script language=JavaScript>
								today=new Date();
								function initArray(){
								this.length=initArray.arguments.length
								for(var i=0;i<this.length;i++)
								this[i+1]=initArray.arguments[i]  }
								var d=new initArray(
								" 星期日",
								" 星期一",
								" 星期二",
								" 星期三",
								" 星期四",
								" 星期五",
								" 星期六");
								document.write("<font color=#000000 style='font-size:9pt;font-family: 宋体'> ",
								today.getYear(),"年",
								today.getMonth()+1,"月",
								today.getDate(),"日",
								d[today.getDay()+1],
								"</font>" ); 
							 </script> </span>
					</div>
				</td>

			</tr>
		</table>>
	</body>
</html>
