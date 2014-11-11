<%@ page import="com.dyneinfo.fjy.model.*" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/commons/taglibs.jsp" %>
<%
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+request.getContextPath()+"/";
%>
<html>
<head>
	<%@ include file="/commons/meta.jsp" %>
	<base href="<%=basePath%>">
	<title><%=User.TABLE_ALIAS%>新增</title>
</head>
<body onload="quickSelectInit()" >
<%@ include file="/commons/messages.jsp" %>

<s:form action="/pages/fjy/User/save.do" theme="simple"  method="post">
	<table cellpadding="0" cellspacing="0" border="1" class="tb_all">
	    <input type="hidden" name="returnUrl" value="!/pages/fjy/User/list.do?<mytag:params includes="ec*,s*" type="queryStringUtf"/>" />
	       <tr>
				<td colspan="4" class="tb_title"> 
							<%=User.TABLE_ALIAS%>新增
			    </td>
		   </tr>
	             <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                     <FONT color="red">*</FONT> <%=User.ALIAS_USERNAME%>
		                  </td>
			              <td colspan="3">
		                           <s:textfield label="%{@vs@ALIAS_USERNAME}" key="username" value="%{model.username}"  cssClass="required max-length-50" required="false" />
		                  </td>
                         
                   </tr>
                    <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                  <FONT color="red">*</FONT>  注册密码
		                  </td>
			              <td>
		                           <s:textfield label="%{@vs@ALIAS_PASSWORD}" key="password" value="%{model.password}"  cssClass="required max-length-50" required="false" />
		                  </td>
                          <td class="crosscolor_td">
			                    <FONT color="red">*</FONT>  再次输入密码
		                  </td>
			              <td>
		                           <s:textfield label="%{@vs@ALIAS_PASSWORD}" key="password2" value="%{model.password2}"  cssClass="required max-length-50" required="false" />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                   <FONT color="red">*</FONT>   <%=User.ALIAS_FULLNAME%>
		                  </td>
			              <td>
		                           <s:textfield label="%{@vs@ALIAS_FULLNAME}" key="fullname" value="%{model.fullname}"  cssClass="required max-length-128" required="false" />
		                  </td>
                          <td class="crosscolor_td">
			                     <FONT color="red">*</FONT> <%=User.ALIAS_SEX%>
		                  </td>
			              <td>
		                         
		                            <mytag:select property="%{model.sex}"
							styleClass="required validate-selection" name="sex"
							notEmpty="false" dictName="T_DIC_SEX" />
		                  
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                     <FONT color="red">*</FONT> <%=User.ALIAS_SFZH%>
		                  </td>
			              <td>
		                           <s:textfield label="%{@vs@ALIAS_SFZH}" key="sfzh" value="%{model.sfzh}" onblur="javascript:showBirthday();"   cssClass="required max-length-200 validate-id-number" required="false" />
		                  </td>
                          <td class="crosscolor_td">
			                     <FONT color="red">*</FONT> <%=User.ALIAS_ENABLED%>
		                  </td>
			              <td>
		                           <mytag:select property="%{model.enabled}"
							styleClass="required validate-selection" name="enabled"
							notEmpty="false" dictName="status" />
		                 
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=User.ALIAS_PHONE%>
		                  </td>
			              <td>
		                           <s:textfield label="%{@vs@ALIAS_PHONE}" key="phone" value="%{model.phone}"  cssClass="max-length-32" required="false" />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=User.ALIAS_MOBILE%>
		                  </td>
			              <td>
		                           <s:textfield label="%{@vs@ALIAS_MOBILE}" key="mobile" value="%{model.mobile}"  cssClass="max-length-32" required="false" />
		                  </td>
                   </tr>
                    <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=User.ALIAS_FAX%>
		                  </td>
			              <td>
		                           <s:textfield label="%{@vs@ALIAS_FAX}" key="fax" value="%{model.fax}"  cssClass="max-length-32" required="false" />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=User.ALIAS_ZIP%>
		                  </td>
			              <td>
		                           <s:textfield label="%{@vs@ALIAS_ZIP}" key="zip" value="%{model.zip}"  cssClass="max-length-32" required="false" />
		                  </td>
                         
                   </tr>
		           <tr class="crosscolor_tr">
                          
                          <td class="crosscolor_td">
			                      <%=User.ALIAS_ADDRESS%>
		                  </td>
			              <td colspan="3">
		                           <s:textfield label="%{@vs@ALIAS_ADDRESS}" size="75" key="address" value="%{model.address}"  cssClass="max-length-64" required="false" />
		                  </td>
                   </tr>
					<tr class="crosscolor_tr">
						<td>
							<FONT color="red">*</FONT>角色
						</td>
						<td colspan="3">
							<s:checkboxlist value="selectList" listKey="roleid"
								listValue="roledesc" list="rolemap" name="roles" />
						</td>
					</tr>
	       <tr >
				<td colspan="4" class="tb_bottom">
							<input id="submitButton" name="submitButton" type="submit" value="保存" />
	                        <input type="button" value="返回" onclick="window.location='${ctx}/pages/fjy/User/list.do?<mytag:params includes="ec*,s*" type="queryStringUtf"/>'"/>
			    </td>
	        </tr>
	</table>
</s:form>

<script>
	
	new Validation(document.forms[0],{onSubmit:true,onFormValidate : function(result,form) {
		var finalResult = result;
		
		//在这里添加自定义验证
		if(result){
			if (!hasOneChecked("roles")){
	            alert('请选择角色!');
	            return false;
			}
		}
		if(result){
			if(!isTrueName($F("username")))
			{
				alert("用户名请以字母开头，长度在6-10之间！");
				return false;
				result = false;
			}
		}
		
		if(result){
			 var newpass = document.getElementById("password").value;
	         var sepass = document.getElementById("password2").value;
			if(newpass!=sepass)
		    {
		      alert('两次输入密码不一样');
		      return false;
		      result = false;
		    }
	    }
		 showBirthday();
		return disableSubmit(finalResult,'submitButton');
	}});
	
	function isTrueName(s) {
		var patrn = /^[a-zA-Z][a-zA-Z0-9_]{5,10}$/;
		if (!patrn.exec(s))
			return false
		return true
	}
	
		function showBirthday() {
	
		var birthdayValue,xzqhs,val;
		val = document.all.sfzh.value;
		
	
		  
		if (15 == val.length) {//15位身份证号码   
			birthdayValue = val.charAt(6) + val.charAt(7);
			if (parseInt(birthdayValue) < 10) {
				birthdayValue = '20' + birthdayValue;
				document.all.sfzh.value =  chg_sfzh(document.all.sfzh.value,20);
			} else {
				birthdayValue = '19' + birthdayValue;
				document.all.sfzh.value =  chg_sfzh(document.all.sfzh.value,19);
			}
			birthdayValue = birthdayValue + '-' + val.charAt(8) + val.charAt(9)
					+ '-' + val.charAt(10) + val.charAt(11);
			xzqhs = 	val.substr(0,6);
			provId = 	val.substr(0,2);
			if (parseInt(val.charAt(14) / 2) * 2 != val.charAt(14))
				document.all.sex.value = '1';
			else
				document.all.sex.value = '2';
		
			
		}
		if (18 == val.length) {//18位身份证号码   
			birthdayValue = val.charAt(6) + val.charAt(7) + val.charAt(8)
					+ val.charAt(9) + '-' + val.charAt(10) + val.charAt(11)
					+ '-' + val.charAt(12) + val.charAt(13);
			xzqhs = 	val.substr(0,6);
			provId = 	val.substr(0,2);			
			if (parseInt(val.charAt(16) / 2) * 2 != val.charAt(16))
				document.all.sex.value = '1';
			else
				document.all.sex.value = '2';
			
		

		
			
			
		}
		
		
	}
	
	
	//   18位身份证号最后一位校验   
	function IDCard(Num) {
		if (Num.length != 18)
			return false;
		var x = 0;
		var y = '';

		for (i = 18; i >= 2; i--)
			x = x + (square(2, (i - 1)) % 11)
					* parseInt(Num.charAt(19 - i - 1));
		x %= 11;
		y = 12 - x;
		if (x == 0)
			y = '1';
		if (x == 1)
			y = '0';
		if (x == 2)
			y = 'X';
		return y;
	}
	//   求得x的y次方   
	function square(x, y) {
		var i = 1;
		for (j = 1; j <= y; j++)
			i *= x;
		return i;
	}
	
	
	function chg_sfzh(sfzh,year)
{
	var tab1 = new Array(18);
	var tab2 = new Array(11);
	tab1[0] = 7;
	tab1[1] = 9;
	tab1[2] = 10;
	tab1[3] = 5;
	tab1[4] = 8;
	tab1[5] = 4;
	tab1[6] = 2;
	tab1[7] = 1;
	tab1[8] = 6;
	tab1[9] = 3;
	tab1[10] = 7;
	tab1[11] = 9;
	tab1[12] = 10;
	tab1[13] = 5;
	tab1[14] = 8;
	tab1[15] = 4;
	tab1[16] = 2;
	tab1[17] = 1;
	tab2[0] = '1';
	tab2[1] = '0';
	tab2[2] = 'X';
	tab2[3] = '9';
	tab2[4] = '8';
	tab2[5] = '7';
	tab2[6] = '6';
	tab2[7] = '5';
	tab2[8] = '4';
	tab2[9] = '3';
	tab2[10] = '2';
	
	var i,j;
	var sj =  new Array(18);
	var new_sfzh = new Array(18);
	
	for (i=0,j=0;i<15;i++)
	{
		if (i==6) {sj[j++]=Math.ceil(year/10-1);sj[j++]=year%10;}
		sj[j++]=sfzh.substr(i,1)-'0';
	}
	
	for (i=0;i<17;i++) 
	    new_sfzh[i]=sj[i];
	for (i=0;i<17;i++) 
	    sj[i]*=tab1[i];
	for (i=0,j=0;i<17;i++) j+=sj[i];
	    new_sfzh[17]=tab2[j%11];
	var sfz;
	sfz='';
	for (i=0,j=0;i<=17;i++) sfz=sfz+new_sfzh[i];
	return sfz;
 }
</script>

</body>
</html>