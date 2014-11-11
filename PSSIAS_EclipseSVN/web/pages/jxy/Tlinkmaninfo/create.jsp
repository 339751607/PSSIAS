<%@page import="com.dyneinfo.jxy.model.*" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/commons/taglibs.jsp" %>
<%
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+request.getContextPath()+"/";
String s_empcode = "";
if (request.getParameter("s_empcode") != null)
	s_empcode = request.getParameter("s_empcode");
%>
<html>
<head>
	<%@ include file="/commons/meta.jsp" %>
	<base href="<%=basePath%>">
	<title><%=Tlinkmaninfo.TABLE_ALIAS%>新增</title>
</head>
<body onload="quickSelectInit()">
<%@ include file="/commons/messages.jsp" %>

<s:form action="/jxy/Tlinkmaninfo/save.do" theme="simple"  method="post">
	<table cellpadding="0" cellspacing="0" border="0" class="tb_all">
	    <input type="hidden" name="returnUrl" value="!/jxy/Tlinkmaninfo/list.do?<mytag:params includes="ec*,s*" type="queryStringUtf"/>" />
	         <input type="hidden" value="<%=s_empcode%>"  name="empcode"  />
	       <tr>
				<td colspan="4" class="tb_title"> 
							<%=Tlinkmaninfo.TABLE_ALIAS%>新增
			    </td>
		   </tr>
	       <tr class="crosscolor_tr">
                         
                          <td class="crosscolor_td">
			                     <FONT color="red">*</FONT> <%=Tlinkmaninfo.ALIAS_LINKMAN%>
		                  </td>
			              <td>
	                               <s:textfield label="%{@vs@ALIAS_LINKMAN}" key="linkman" value="%{model.linkman}"  cssClass="required max-length-30 validate-chinese" required="false" />
		                  </td>
		                   <td class="crosscolor_td">
			                    <FONT color="red">*</FONT>  <%=Tlinkmaninfo.ALIAS_SEX%>
		                  </td>
			              <td>
						           <mytag:select property="%{model.sex}"   styleClass="required validate-selection"  name="sex"   notEmpty="false"  dictName="T_DIC_SEX"/>
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
		                  <td class="crosscolor_td">
			                     <FONT color="red">*</FONT> <%=Tlinkmaninfo.ALIAS_PHONE%>
		                  </td>
			              <td>
		                           <s:textfield label="%{@vs@ALIAS_PHONE}" key="phone" value="%{model.phone}"  cssClass="required max-length-20" required="false" />
		                  </td>
                          <td class="crosscolor_td">
			                     <%=Tlinkmaninfo.ALIAS_IDCODE%>
		                  </td>
			              <td>
	                               <s:textfield label="%{@vs@ALIAS_IDCODE}" key="idcode" value="%{model.idcode}" onblur="javascript:showBirthday();"    cssClass=" max-length-18 validate-id-number" required="false" />
		                  </td>
		                  
                         
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=Tlinkmaninfo.ALIAS_JOBORDWELL%>
		                  </td>
			              <td colspan="3">
		                           <s:textfield label="%{@vs@ALIAS_JOBORDWELL}" size="60" key="jobordwell" value="%{model.jobordwell}"  cssClass="max-length-100" required="false" />
		                  </td>
		            </tr>
		           <tr class="crosscolor_tr">        
                          <td class="crosscolor_td">
			                      <%=Tlinkmaninfo.ALIAS_COMMADDRESS%>
		                  </td>
			               <td colspan="3">
		                           <s:textfield label="%{@vs@ALIAS_COMMADDRESS}" size="60" key="commaddress" value="%{model.commaddress}"  cssClass="max-length-100" required="false" />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                         
                          <td class="crosscolor_td">
			                      <%=Tlinkmaninfo.ALIAS_RELATION%>
		                  </td>
			               <td colspan="3">
		                           <s:textfield label="%{@vs@ALIAS_RELATION}" size="60" key="relation" value="%{model.relation}"  cssClass="max-length-20" required="false" />
		                  </td>
                   </tr>
	       <tr >
				<td colspan="4" class="tb_bottom">
							<input id="submitButton" name="submitButton" type="submit" value="提交" />
	                        <input type="button" value="返回" onclick="window.location='${ctx}/jxy/Tlinkmaninfo/list.do?<mytag:params includes="ec*,s*" type="queryStringUtf"/>'"/>
			    </td>
	        </tr>
	</table>
</s:form>

<script>
	
	new Validation(document.forms[0],{onSubmit:true,onFormValidate : function(result,form) {
		var finalResult = result;
		
		//在这里添加自定义验证
		showBirthday();
		return disableSubmit(finalResult,'submitButton');
	}});
	function showBirthday() {
	
		var birthdayValue,xzqhs,val;
		val = document.all.idcode.value;
		
	
		  
		if (15 == val.length) {//15位身份证号码   
			birthdayValue = val.charAt(6) + val.charAt(7);
			if (parseInt(birthdayValue) < 10) {
				birthdayValue = '20' + birthdayValue;
				document.all.idcode.value =  chg_sfzh(document.all.idcode.value,20);
			} else {
				birthdayValue = '19' + birthdayValue;
				document.all.idcode.value =  chg_sfzh(document.all.idcode.value,19);
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
