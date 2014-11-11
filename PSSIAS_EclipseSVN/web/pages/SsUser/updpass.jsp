<%@page import="com.dyneinfo.zazh.model.*" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/commons/taglibs.jsp" %>
<script type="text/javascript">
  function chkPass()
  {
    var oldpass = document.getElementById("oldpass").value;
    var newpass = document.getElementById("newpass").value;
    var sepass = document.getElementById("sepass").value;
    if(oldpass=="")
    {
      alert('请输入原密码');
      return false;
    }
   if(newpass=="")
    {
      alert('请输入新密码');
      
      return false;
    }
    if(sepass=="")
    {
      alert('请再次确认密码');
      return false;
    }
    if(newpass!=sepass)
    {
      alert('两次输入新密码不一样');
      return false;
    }
    
    return true;
  }
</script>

<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=GBK">
		<title>修改密码</title>
		<%@ include file="/commons/meta.jsp" %>
		<link href="${ctx}/styles/tb.css" rel="stylesheet" type="text/css">
	</head>
	<body onload="quickSelectInit()" >
	<%@ include file="/commons/messages.jsp" %>
	<s:form action="/pages/SsUser/changepwdSave.do"  theme="simple"  method="post">
		<table width="50%" border="1" bordercolor="#7c8ca7" align="center" cellPadding="0" cellSpacing="0" class="tb_all">
			
			<tr>
				<!---------表头<td>加入 class="tb_title"------------>
				<TD colspan="4" class="tb_title">
					修改密码
				</TD>
			</tr>
			<!---------行元素<tr>加入 class="crosscolor_tr"------------>
			<tr class="crosscolor_tr">
				<td>
					请输入原密码
				</td>
				<td width="50%">
					<input name="oldpass" type="password"   class="required validate-alphanum min-length-3 max-length-10"  id="oldpass"
						value="" size="20" maxLength="10"><FONT color="red">*</FONT>
				</td>
			</tr>
			<tr class="crosscolor_tr">
				<td>
					请输入新密码
				</td>
				<td>
					<input name="newpass" type="password" class="required validate-alphanum min-length-6 max-length-10" id="newpass"
						value="" size="20" maxLength="10""><FONT color="red">*</FONT>
				</td>
			</tr>
			<tr class="crosscolor_tr">
				<td>
					再次输入新密码
				</td>
				<td>
					<input name="sepass" type="password" class="required validate-alphanum min-length-6 max-length-10" id="sepass"
						value="" size="20" maxLength="10"><FONT color="red">*</FONT>
				</td>
			</tr>
			<!--    <tr class="crosscolor_tr">
                         <td>用户描述：</td>
                         <td colspan="3"><textarea name="describe" cols="45" rows="5" class="pp" id="describe" maxLength="5"></textarea></td>
                       </tr>----->
			<tr >
				<!--     ------底部有确认、清除按钮的在<td>中加入class="tb_bottom"--------->
				<!--------------切记要加入<td>中-------------------->
				<td colspan="4" class="tb_bottom">
					
<input id="submit" name="submit" type="submit" value="确认" />
					<input name="ResetB" type="reset" value="取消">
				</td>
			</tr>

           
		</table>
		</s:form>

<script>
	
	new Validation(document.forms[0],{onSubmit:true,onFormValidate : function(result,form) {
		var finalResult = result;
		
		//在这里添加自定义验证
		if(result){
		  if(!chkPass())
		       return false;
		}
		
		return disableSubmit(finalResult,'submit');
	}});
	

</script>
	</body>
</html>
