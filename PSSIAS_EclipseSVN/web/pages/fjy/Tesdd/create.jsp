<%@page import="com.dyneinfo.fjy.model.*" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/commons/taglibs.jsp" %>
<%
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+request.getContextPath()+"/";
%>
<html>
<head>
	<%@ include file="/commons/meta.jsp" %>
	<base href="<%=basePath%>">
	<title><%=Tesdd.TABLE_ALIAS%>新增</title>
</head>
<body onload="quickSelectInit()" >
<%@ include file="/commons/messages.jsp" %>

<s:form action="/pages/fjy/Tesdd/save.do" theme="simple"  method="post">
	<table cellpadding="0" cellspacing="0" border="1" class="tb_all">
	    <input type="hidden" name="returnUrl" value="!/pages/fjy/Tesdd/list.do?<mytag:params includes="ec*,s*" type="queryStringUtf"/>" />
	       <tr>
				<td colspan="4" class="tb_title"> 
							<%=Tesdd.TABLE_ALIAS%>新增
			    </td>
		   </tr>
	 <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                     <FONT color="red">*</FONT>  <%=Tesdd.ALIAS_DDLX%>
		                  </td>
			              <td>
						           <mytag:select property="%{model.ddlx}"   styleClass="required validate-selection"  name="ddlx"   notEmpty="false"  dictName="T_DIC_JQLX"/>
		                  </td>
                          <td class="crosscolor_td">
			                      <FONT color="red">*</FONT> <%=Tesdd.ALIAS_DNPP%>
		                  </td>
			              <td>
		                           <s:textfield label="%{@vs@ALIAS_DNPP}" key="dnpp" value="%{model.dnpp}"  cssClass="required max-length-50" required="false" />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <FONT color="red">*</FONT> <%=Tesdd.ALIAS_DNXH%>
		                  </td>
			              <td>
		                           <s:textfield label="%{@vs@ALIAS_DNXH}" key="dnxh" value="%{model.dnxh}"  cssClass="required max-length-50" required="false" />
		                  </td>
                          <td class="crosscolor_td">
			                       <FONT color="red">*</FONT><%=Tesdd.ALIAS_ZBH%>
		                  </td>
			              <td>
		                           <s:textfield label="%{@vs@ALIAS_ZBH}" key="zbh" value="%{model.zbh}"  cssClass="required max-length-15" required="false" />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                       <FONT color="red">*</FONT><%=Tesdd.ALIAS_YPH%>
		                  </td>
			              <td>
		                           <s:textfield label="%{@vs@ALIAS_YPH}" key="yph" value="%{model.yph}"  cssClass="required max-length-15" required="false" />
		                  </td>
		                   <td class="crosscolor_td">
			                     <FONT color="red">*</FONT> <%=Tesdd.ALIAS_MACDZ%>
		                  </td>
			              <td>
		                           <s:textfield label="%{@vs@ALIAS_MACDZ}" key="macdz" value="%{model.macdz}"  cssClass="required max-length-15" required="false" />
		                  </td>
                         
                   </tr>
                    <tr class="crosscolor_tr">
                         
		                   <td class="crosscolor_td">
			                      <%=Tesdd.ALIAS_ZC%>
		                  </td>
			              <td>
		                           <s:textfield label="%{@vs@ALIAS_ZC}" key="zc" value="%{model.zc}"  cssClass="max-length-15" required="false" />
		                  </td>
		                  <td class="crosscolor_td">
			                      <%=Tesdd.ALIAS_GMSJ%>
		                  </td>
			              <td>
						           <input value="${model.gmsj}" onclick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss'})" id="gmsj" name="gmsj"  maxlength="0" class=" Wdate" />
		                  </td>
                         
                   </tr>
		           <tr class="crosscolor_tr">
                        
                          <td class="crosscolor_td">
			                    <FONT color="red">*</FONT>  <%=Tesdd.ALIAS_CHUSHOURY%>
		                  </td>
			              <td>
	                               <s:textfield label="%{@vs@ALIAS_CHUSHOURY}" key="chushoury" value="%{model.chushoury}"  cssClass="required max-length-30 validate-chinese" required="false" />
		                  </td>
                  
                          <td class="crosscolor_td">
			                    <FONT color="red">*</FONT>  <%=Tesdd.ALIAS_CHUSHOURENXB%>
		                  </td>
			              <td>
						           <mytag:select property="%{model.chushourenxb}"   styleClass="required validate-selection"  name="chushourenxb"   notEmpty="false"  dictName="T_DIC_SEX"/>
		                  </td>
		             </tr>
		           <tr class="crosscolor_tr">      
                          <td class="crosscolor_td">
			                     <FONT color="red">*</FONT> <%=Tesdd.ALIAS_CHUSHOURENSFZH%>
		                  </td>
			              <td>
	                               <s:textfield label="%{@vs@ALIAS_CHUSHOURENSFZH}" key="chushourensfzh" onblur="javascript:showBirthday();" value="%{model.chushourensfzh}"  cssClass="required max-length-18 validate-id-number" required="false" />
		                  </td>
                 
                         
                          <td class="crosscolor_td">
			                      <%=Tesdd.ALIAS_CHUSHOURENLXDH%>
		                  </td>
			              <td>
	                               <s:textfield label="%{@vs@ALIAS_CHUSHOURENLXDH}" key="chushourenlxdh" value="%{model.chushourenlxdh}"  cssClass="max-length-30 validate-number" required="false" />
		                  </td>
		                   
                   </tr>
                    

		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=Tesdd.ALIAS_DQSJH%>
		                  </td>
			              <td colspan="3">
	                               <s:textfield label="%{@vs@ALIAS_DQSJH}" key="dqsjh" value="%{model.dqsjh}"  cssClass="max-length-11 validate-number" required="false" />
		                  </td>
                          
                   </tr>
		           <tr class="crosscolor_tr">
                         
                          
		                 <td class="crosscolor_td">
			                      <%=Tesdd.ALIAS_CSRJTZZ%>
		                  </td>
			              <td colspan="3">
		                           <s:textfield label="%{@vs@ALIAS_CSRJTZZ}" size="80" key="csrjtzz" value="%{model.csrjtzz}"  cssClass="max-length-100" required="false" />
		                  </td>
                   </tr>
                   <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=Tesdd.ALIAS_BEIZHU%>
		                  </td>
			              <td colspan="3">
		                          <s:textarea label="%{@vs@ALIAS_BEIZHU}" rows="4" cols="55"
							key="beizhu" value="如显示器，键盘等信息" onfocus="document.getElementById('beizhu').value=''; document.getElementById('beizhu').onfocus = Function('void(0)');"  cssClass="max-length-200"
							required="false"></s:textarea>
		                           </td>
                         
                   </tr>

	       <tr >
				<td colspan="4" class="tb_bottom">
							<input id="submitButton" name="submitButton" type="submit" value="保存" />
	                        <input type="button" value="返回" onclick="window.location='${ctx}/pages/fjy/Tesdd/list.do?<mytag:params includes="ec*,s*" type="queryStringUtf"/>'"/>
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
		val = document.all.chushourensfzh.value;
		
	
		  
		if (15 == val.length) {//15位身份证号码   
			birthdayValue = val.charAt(6) + val.charAt(7);
			if (parseInt(birthdayValue) < 10) {
				birthdayValue = '20' + birthdayValue;
				document.all.chushourensfzh.value =  chg_sfzh(document.all.chushourensfzh.value,20);
			} else {
				birthdayValue = '19' + birthdayValue;
				document.all.chushourensfzh.value =  chg_sfzh(document.all.chushourensfzh.value,19);
			}
			birthdayValue = birthdayValue + '-' + val.charAt(8) + val.charAt(9)
					+ '-' + val.charAt(10) + val.charAt(11);
			xzqhs = 	val.substr(0,6);
			provId = 	val.substr(0,2);
			if (parseInt(val.charAt(14) / 2) * 2 != val.charAt(14))
				document.all.chushourenxb.value = '1';
			else
				document.all.chushourenxb.value = '2';
		
			
		}
		if (18 == val.length) {//18位身份证号码   
			birthdayValue = val.charAt(6) + val.charAt(7) + val.charAt(8)
					+ val.charAt(9) + '-' + val.charAt(10) + val.charAt(11)
					+ '-' + val.charAt(12) + val.charAt(13);
			xzqhs = 	val.substr(0,6);
			provId = 	val.substr(0,2);			
			if (parseInt(val.charAt(16) / 2) * 2 != val.charAt(16))
				document.all.chushourenxb.value = '1';
			else
				document.all.chushourenxb.value = '2';
			
		

		
			
			
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