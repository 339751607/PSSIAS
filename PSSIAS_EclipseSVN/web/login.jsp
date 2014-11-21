<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//ZH">
<html xmlns="http://www.w3.org/1999/xhtml">

	<%@ page contentType="text/html; charset=UTF-8"%>
	<%@ page
		import="org.springframework.security.ui.AbstractProcessingFilter"%>
	<%@ page
		import="org.springframework.security.ui.webapp.AuthenticationProcessingFilter"%>
	<%@ page
		import="org.springframework.security.AuthenticationException,java.util.*"%>	

		
	<%@ taglib prefix='c' uri='http://java.sun.com/jstl/core_rt'%>
	<%@ page import="net.java.dev.common.dict.taglib.DictHelpImpl"%>
	<c:set var="ctx" value="${pageContext.request.contextPath}" />
	<jsp:useBean id="userCount" scope="session" class="org.security.userdetails.jdbc.SessionUserCount"/>
	
	<%
	String pathurl ="http://"+ request.getServerName() + ":" + request.getServerPort() +request.getContextPath();
    String popFlag = "0",login_error="";
   //是否是从welcome.htm弹出进入，如果是,关闭welcome.htm 1为是
   if(request.getParameter("popFlag") != null)
      popFlag=request.getParameter("popFlag");
    if(request.getParameter("login_error") != null)
      login_error=request.getParameter("login_error");   
      
      //取系统实施地市名称
      //String deploycity = (String)DictHelpImpl.getInitData("deploycity");
 
	  %>

	<head>
		<meta http-equiv="content-type" content="text/html;charset=gb2312">
		<style type="text/css">
body {
	background: url("${ctx}/images/login/bg.jpg") #125ED6;
	background-repeat: repeat-x;
	margin: 0px;
	padding: 0px;
}

.down {
	filter: flipv alpha(Opacity = 15); /*ie fliph水平翻转滤镜,flipv垂直翻转滤镜*/
}

.inverted {
	-webkit-transform: rotateY(180deg);
	transform: rotateY(180deg);
	-moz-transform: skew(0deg, 180deg) scale(-1, 1);
	-o-transform: skew(0deg, 180deg) scale(-1, 1);
}

.login01 {
	background: url("${ctx}/images/login/<%=DictHelpImpl.getInitData("imagepath")%>/login01.jpg") left top no-repeat;
	width: 1023px;
	height: 192px;
}

.login02 {
	background: url("${ctx}/images/login/login02.jpg") left top no-repeat;
	width: 1023px;
	height: 60px;
}

.login03_a {
	background: url("${ctx}/images/login/login03_a.jpg") left top no-repeat;
	width: 1023px;
	height: 63px;
	border: 0px;
	padding: 0px;
}

.login03_b {
	background: url("${ctx}/images/login/login03_b.jpg") left top no-repeat;
	width: 1023px;
	height: 134px;
	border: 0px;
	padding: 0px;
	margin-top:0px;
	margin-bottom:0px;
}

.login04 {
	background: url("${ctx}/images/login/login04.jpg") left top no-repeat;
	backgr: 1023px;
	height: 62px;
	font-family: 幼圆;
}

.login05 {
	background: url("${ctx}/images/login/login05.jpg") left top no-repeat;
	width: 1023px;
	height: 62px;
	font-family: 幼圆;
}

.login06 {
	background: url("${ctx}/images/login/<%=DictHelpImpl.getInitData("imagepath")%>/login06.jpg") left top no-repeat;
	width: 1023px;
	height: 127px;
}

.login_input  input {
	height: 18px;
	width: 115px;
	border-left: 1px solid #545454;
	border-top: 1px solid #545454;
	border-right: 1px solid #fff;
	border-bottom: 1px solid #fff;
	background: f0fcff;
}

.btn_ok {
	background: url("${ctx}/images/login/btn_ok.gif") left top no-repeat;
	width: 100px;
	height: 29px;
	border: 0px;
	padding: 0px;
	cursor: pointer;

}
.btn_key {
	background: url("${ctx}/images/login/btn_key.gif") left top no-repeat;
	width: 100px;
	height: 29px;
	border: 0px;
	padding: 0px;
	cursor: pointer;

}

.btn_reset {
	background: url("${ctx}/images/login/btn_reset.gif") left top no-repeat;
	width: 22px;
	height: 21px;
	border: 0px;
	padding: 0px;
	cursor:pointer;
}
.tittle01 {
	width: 500px;
}

.tittle02 {
	vertical-align: bottom;
	font-family: 幼圆;
}

.tittle03 {
	width: 20px;
}

.tittle04 {
	vertical-align: bottom;
}
td {background-color:;} 
</style>
		<title>达因治安综合管理信息系统</title>
	</head>
	<% if(popFlag != null && popFlag.equals("1"))  {%>
	<script>
    if (window.opener) {
        window.opener.opener=null;
        window.opener.open('','_self');
        window.opener.close();
    }

    </script>
	<% } %>
	<script language="JavaScript">
	function ddd(){
		var WshShell=new ActiveXObject("WScript.Shell");
		var strDesktop = WshShell.SpecialFolders("Desktop");
		var oShellLink = WshShell.CreateShortcut(strDesktop + "\\达因治安综合管理信息系统.lnk");
		//WshShell.ScriptFullName
		oShellLink.TargetPath =  "<%=pathurl%>";
		oShellLink.WindowStyle = 1;
		oShellLink.Hotkey = "Ctrl+Alt+E";
		//oShellLink.IconLocation = "notepad.exe, 0";
		oShellLink.IconLocation = "C:\\Program Files\\Internet Explorer\\IEXPLORE.EXE, 0";
		oShellLink.Description = "达因治安综合管理信息系统";
		oShellLink.WorkingDirectory = strDesktop;
		oShellLink.Save();
	}
  function kjfs(){
	  var fso = new ActiveXObject("Scripting.FileSystemObject");   
	  var shell = new ActiveXObject("WScript.Shell");    
	　　var tagFolder =shell.SpecialFolders("Desktop"); 　　            
	   if(!fso.FolderExists(tagFolder ))
	   {
	       fso.CreateFolder(tagFolder);
	    }
		if(!fso.FileExists(tagFolder + "\\达因治安综合管理信息系统.lnk"))
		{                
		 var link = shell.CreateShortcut(tagFolder + "\\达因治安综合管理信息系统.lnk");  
		   
		 link.TargetPath = "<%=pathurl%>";
		 link.WindowStyle = 0;
		 link.iconlocation=shell.ExpandEnvironmentStrings("%windir%\\SYSTEM32\\fsquirt.exe,47");
		 link.Save(); 
		
		}
	}

<!--
function MM_openBrWindow() { //v2.0

	var login=document.f.j_username.value;
	var password=document.f.j_password.value;
	if(login=="")
	{
		alert("请填写用户名");
		return false
	}
	if(password=="")
	{
		alert("请填写密码");
		return false
	}
}
//-->
</script>
	<script language="javascript">
	if (top.location !== self.location) {
	top.location=self.location; 
	} 
</script>
	<%
  
  
    //以下代码，产生一个随机数，
  	//RandomUtils ran = new RandomUtils();
  	String ranData = "";
  	String in_data = "20090721";
  	String dec_data = "933535470";
  %>
	<script>
	  function login_onclick() 
		{
		    var DevicePath,ret,n,mylen;
		    var in_data = '<%=Integer.parseInt(in_data)%>';
		    var ranD = '<%=ranData%>';
			var dec_data = '<%=Integer.parseInt(dec_data)%>';
			try
			 {
				//建立操作我们的锁的控件对象，用于操作我们的锁
	            var aObject = new ActiveXObject("Syunew3A.s_simnew3");
	            
	            //查找是否存在锁,这里使用了FindPort函数，也可以使用FindPort_2函数来查找指定的锁，建议使用FindPort_2
				DevicePath = aObject.FindPort_2(0,in_data,dec_data);
				
				if( aObject.LastError!= 0 )
				{
					window.alert ("您没有使用加密锁或您所使用的加密锁与开发商提供的不一致，请插入正确的加密锁");
					window.open("error.jsp","_self");
				}
				else
				{
				    var decStr = aObject.EncString(ranD, DevicePath);
				    
				    if(this.document.f.j_username.value==""){
				    	alert("请输入用户名称！");
				    	return ;
				    }
				    if(this.document.f.j_password.value==""){
				    	alert("请输入用户密码！");
				    	return ;
				    }
				    //this.document.form.randata.value=ranD;
				   // this.document.form.decdata.value=decStr;
					form.action="${ctx}/j_spring_security_check";
					alert(form.action);
					form.submit();
				}
			}
			catch(err)  
			{  
				  txt="错误,原因是" + err.description + "\n\n"  
				  txt+="请检查是否安装驱动程序"
				  alert(txt)  
			 }  
		}
  </script>
	<body>
	 <table border="0" cellpadding="0" cellspacing="0" align="center">
			<tr>
				<td class="login01"></td>
			</tr>
			<tr>
				<td class="login02">
					<div style="margin: 0px 0px 0px 550px; padding: 0px">
						<div class="tittle02">
							<font style="font-size: 20px;"> &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 版本：1.0
							</font>
						</div>
					</div>
				</td>
			</tr>
			<tr>
				<td class="login03_a">
				   <div style="margin: 35px 0px 0px 500px; font-size: 12px;">
									<% if(login_error != null && login_error.equals("5"))  {%>
									<font color="red">已过期或注册错误</font>
									<% } else  if(login_error != null && login_error.equals("4")) { %>
									<font color="red">用户已失效</font>
									<% } else { %>
									<c:if test="${not empty param.login_error}">
										<font color="red"> <c:out
												value="${SPRING_SECURITY_LAST_EXCEPTION.message}" /> </font>
									</c:if>
									<%} %>

				    </div>
				</td>
		    </tr>
			<tr>
				<td class="login03_b" >	
							<form name="f" onsubmit="return MM_openBrWindow()" action="${ctx}/j_spring_security_check" method="POST">
								
                                    <div class="login_input" style="margin: 10px 0px 0px 550px; ">
										<input tabindex="2" type='text' name='j_username' id='j_username' maxlength="20" value=""
											value='<c:if test="${not empty param.login_error}"><c:out value="${SPRING_SECURITY_LAST_USERNAME}"/></c:if>' />
									</div>
                                    
                                    <div style="margin: -22px 0px 0px 675px; padding: 0px;">
										<input tabIndex="-4" type="reset" value="" class="btn_reset" />
									</div>
                                
									<div style="margin: 18px 0px 0px 550px; padding: 0px;" class="login_input">
										<input tabIndex="3" type='password' id='j_password' name='j_password' value="">
									</div>
									
									<div style="margin: 10px 0px 0px 490px; padding:0px;">
										<input tabIndex="-1"  name="submit" id="LoginBut" value="" class="btn_ok" type="submit">
										<input tabIndex="-1"  name="submit" id="LoginKeyBut" value="" class="btn_key" type="button">
									</div>
							   
							</form>
				</td>
			</tr>
			<tr>
				<td class="login04" valign="top">
				</td>
			</tr>

			<tr>
				<td class="login05" valign="bottom">
					<table border="0" cellpadding="0" cellspacing="0">
						<tr>
							<td class="down">
							</td>
						</tr>
					</table>
				</td>
			</tr>
			<tr>
				<td class="login06">
					<div style=" width:300px; height:50px; margin:0 auto; ;">
						<span><font style="font-size: 13px;"><strong>技术支持</strong></font></span>&nbsp;&nbsp;&nbsp; <font style="font-size: 13px;"><img src="${ctx}/images/login_logo.gif" align="absmiddle" />  <%=DictHelpImpl.getInitData("initSUPPORT")%>
							</font><br/>
					      
						<span><font style="font-size: 13px;"><strong>联系方式</strong></font></span><font style="font-size: 13px;">
						&nbsp;&nbsp;&nbsp;<img src="${ctx}/images/phone.gif" align="absmiddle" /> <%=DictHelpImpl.getInitData("initTELPHONE")%>	</font>
					 
					</div>

				</td>
			</tr>
		</table>
	</body>
</html>
