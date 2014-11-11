<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/commons/taglibs.jsp" %>
<%@page import="com.dyneinfo.pmdd.model.*" %>
<%
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+request.getContextPath()+"/";
%>
<html>

<head>
	<%@ include file="/commons/meta.jsp" %>
	<base href="<%=basePath%>">
	<title><%=Cyry.TABLE_ALIAS%>编辑</title>
</head>

<body onload="quickSelectInit()" >
<%@ include file="/commons/messages.jsp" %>

<s:form action="/pages/pmdd/Cyry/update.do"  theme="simple"  method="post">
	<table cellpadding="0" cellspacing="0" border="0" class="tb_all">
	    <input type="hidden" name="returnUrl" value="!/pages/pmdd/Cyry/list.do?<mytag:params includes="ec*,s*" type="queryStringUtf"/>" />
	        <tr>
				      <td colspan="4" class="tb_title"> 
							<%=Cyry.TABLE_ALIAS%>编辑
				     </td>
		    </tr>
		     <s:hidden name="dwbm" value="%{model.dwbm}"></s:hidden>
		      <s:hidden name="dwnbm" value="%{model.dwnbm}"></s:hidden>
	          <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                     <FONT color="red">*</FONT> <%=Cyry.ALIAS_XM%>
		                  </td>
			              <td>
		                           <s:textfield label="%{@vs@ALIAS_XM}" key="xm" value="%{model.xm}"  cssClass="required max-length-30" required="false" />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=Cyry.ALIAS_XB%>
		                  </td>
			              <td>
						           <mytag:select property="%{model.xb}"   styleClass="required validate-selection"  name="xb"   notEmpty="false"  dictName="gender"/>
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                         
                          <td class="crosscolor_td">
			                     <FONT color="red">*</FONT> <%=Cyry.ALIAS_GMSFHM%>
		                  </td>
			              <td>
	                               <s:textfield label="%{@vs@ALIAS_GMSFHM}" key="gmsfhm" onblur="javascript:showBirthday();" value="%{model.gmsfhm}"  cssClass="required max-length-18 validate-id-number" required="false" />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=Cyry.ALIAS_BIRTHDAY%>
		                  </td>
			              <td>
						           <input value="${model.birthday}" onclick="WdatePicker({dateFmt:'yyyy-MM-dd'})" id="birthday" name="birthday"  maxlength="0" class="required Wdate" />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=Cyry.ALIAS_ZZ%>
		                  </td>
			              <td colspan="3">
		                           <s:textfield label="%{@vs@ALIAS_ZZ}" key="zz" size="80" value="%{model.zz}"  cssClass="max-length-120" required="false" />
		                  </td>
		            </tr>
		           <tr class="crosscolor_tr">     
                          <td class="crosscolor_td">
			                      <%=Cyry.ALIAS_HKSZD%>
		                  </td>
			             <td colspan="3">
		                           <s:textfield label="%{@vs@ALIAS_HKSZD}" key="hkszd"  size="80" value="%{model.hkszd}"  cssClass="max-length-120" required="false" />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=Cyry.ALIAS_WHCD%>
		                  </td>
			              <td>
						           <mytag:select property="%{model.whcd}"   name="whcd"   notEmpty="false"  dictName="educations"/>
		                  </td>
                          <td class="crosscolor_td">
			                      <%=Cyry.ALIAS_GZLX%>
		                  </td>
			              <td>
						           <mytag:select property="%{model.gzlx}"    name="gzlx"   notEmpty="false"  dictName="gzlx"/>
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=Cyry.ALIAS_RZRQ%>
		                  </td>
			              <td colspan="3">
						           <input value="${model.rzrq}" onclick="WdatePicker({dateFmt:'yyyy-MM-dd'})" id="rzrq" name="rzrq"  maxlength="0" class="required Wdate" />
		                  </td>
                         
                   </tr>
		           <tr class="crosscolor_tr">
		                 <td class="crosscolor_td">
			                      <%=Cyry.ALIAS_FLAG%>
		                  </td>
			              <td>
						           <mytag:select property="%{model.flag}"   styleClass="required validate-selection"  name="flag"   notEmpty="false"  dictName="cyryFlag"/>
		                  </td>
                          <td class="crosscolor_td">
			                      <%=Cyry.ALIAS_LZRQ%>
		                  </td>
			              <td>
						           <input value="${model.lzrq}" onclick="WdatePicker({dateFmt:'yyyy-MM-dd'})" id="lzrq" name="lzrq"  maxlength="0" class=" Wdate" />
		                  </td>
                          
                   </tr>
		          
	        <tr >
					 <td colspan="4" class="tb_bottom">
	                        <input id="submitButton" name="submitButton" type="submit" value="提交" />
	                        <input type="button" value="返回" onclick="window.location='${ctx}/pages/pmdd/Cyry/list.do?<mytag:params includes="ec*,s*" type="queryStringUtf"/>'"/>   
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
	
	
	//提取身份信息
	function showBirthday() {
	
		var birthdayValue,xzqhs,val,provId;
		val = document.all.gmsfhm.value;
		
	
		  
		if (15 == val.length) {//15位身份证号码   
			birthdayValue = val.charAt(6) + val.charAt(7);
			if (parseInt(birthdayValue) < 10) {
				birthdayValue = '20' + birthdayValue;
				document.all.gmsfhm.value =  chg_sfzh(document.all.gmsfhm.value,20);
			} else {
				birthdayValue = '19' + birthdayValue;
				document.all.gmsfhm.value =  chg_sfzh(document.all.gmsfhm.value,19);
			}
			birthdayValue = birthdayValue + '-' + val.charAt(8) + val.charAt(9)
					+ '-' + val.charAt(10) + val.charAt(11);
			xzqhs = 	val.substr(0,6);
			provId = 	val.substr(0,2);
			if (parseInt(val.charAt(14) / 2) * 2 != val.charAt(14))
				document.all.xb.value = '1';
			else
				document.all.xb.value = '2';
			document.all.birthday.value = birthdayValue;
			//document.all.prov.value = provId+"0000";
			//document.all.prov2.value = provId+"0000";
			//sfzhSetxzqh(provId,xzqhs);
			//sfzhSetxzqh2(provId,xzqhs);
			
		}
		if (18 == val.length) {//18位身份证号码   
			birthdayValue = val.charAt(6) + val.charAt(7) + val.charAt(8)
					+ val.charAt(9) + '-' + val.charAt(10) + val.charAt(11)
					+ '-' + val.charAt(12) + val.charAt(13);
			xzqhs = 	val.substr(0,6);
			provId = 	val.substr(0,2);			
			if (parseInt(val.charAt(16) / 2) * 2 != val.charAt(16))
				document.all.xb.value = '1';
			else
				document.all.xb.value = '2';
			if (val.charAt(17) != IDCard(val)) {
				document.all.gmsfhm.style.backgroundColor = '#ffc8c8';
				document.all.gmsfhm.value= val.toUpperCase();
			} else {
				document.all.gmsfhm.style.backgroundColor = 'white';
			}
			document.all.birthday.value = birthdayValue;
			//document.all.prov.value = provId+"0000";
			//document.all.prov2.value = provId+"0000";
			
			
			
			
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