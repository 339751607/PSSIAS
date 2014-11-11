<%@page import="com.dyneinfo.fjy.model.*,java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/commons/taglibs.jsp" %>
<%@ page import="net.java.dev.common.dict.taglib.DictHelpImpl"%>
<%@ taglib prefix="authz" uri="http://www.springframework.org/security/tags" %>

<%
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+request.getContextPath()+"/";
String IDCardType = (String)DictHelpImpl.getInitData("IDCardType");
%>
<html>
<head>
	<%@ include file="/commons/meta.jsp" %>
	<base href="<%=basePath%>">
	<title><%=TelInfo.TABLE_ALIAS%>收购</title>
</head>
<body onload="quickSelectInit()" >
<%@ include file="/commons/messages.jsp" %>

<s:form action="/pages/fjy/TelInfo/save.do" theme="simple" name="inputForm"  method="post">
	<table cellpadding="0" cellspacing="0" border="1" class="tb_all">
	    <input type="hidden" name="returnUrl" value="!/pages/fjy/TelInfoView/list.do?<mytag:params includes="ec*,s*" type="queryStringUtf"/>" />
	       <tr>
				<td colspan="5" class="tb_title"> 
							<%=TelInfo.TABLE_ALIAS%>收购
			    </td>
		   </tr>
	    <tr class="crosscolor_tr">
                          <td width="15%" class="crosscolor_td">
			                      <FONT color="red">*</FONT>  <%=TelInfo.ALIAS_TELPP%>
		                  </td>
			              <td colspan="3" >
						            <s:doubleselect name="telpp" list="provList" listKey="id"  
								listValue="name" doubleName="telxh"  
								value="#request.defaultItem"
								doubleValue="#request.doubleDefaultItem" 
								doubleList="cityMap.get(top.id)" doubleListKey="id"
								doubleListValue="name" theme="simple" />
		                  </td>
		                  
		                  <td width="90" rowspan="10">
			              <%if(IDCardType != null && IDCardType.equals("0")) { %> 
			               <IFRAME height="100%" width="340" name="result"   src="${ctx}/pages/fjy/Temployee/IDcard_telInfo.htm"
							align="center" frameBorder="0" marginHeight="0" marginWidth="0"></IFRAME>
			              <% } else if(IDCardType != null && IDCardType.equals("1")) { %>
						  <IFRAME height="100%" width="220" name="result"   src="${ctx}/pages/fjy/Temployee/CVR_IDCard_telInfo.html"
							align="center" frameBorder="0" marginHeight="0" marginWidth="0"></IFRAME>
							<% } %>	
								
					       </td>
                         
                   </tr>
		           <tr class="crosscolor_tr">
                          
                          <td class="crosscolor_td">
			                       <FONT color="red">*</FONT> <%=TelInfo.ALIAS_JXXLH%>
		                  </td>
			              <td colspan="3">
		                           <s:textfield label="%{@vs@ALIAS_JXXLH}" key="jxxlh" value="%{model.jxxlh}"  cssClass="required max-length-15" required="false" />
		                  </td>
		                 
                   </tr>
                   <tr class="crosscolor_tr"> 
                         <td class="crosscolor_td">
			                      <%=TelInfo.ALIAS_TELYS%>
		                  </td>
			              <td  >
						           <mytag:select property="%{model.telys}"     name="telys"   notEmpty="false"  dictName="T_DIC_SJYS"/>
		                  </td>
		                  <td class="crosscolor_td">
			                      <FONT color="red">*</FONT><%=TelInfo.ALIAS_SJLB%>
		                  </td>
			              <td>
						           <mytag:select property="%{model.sjlb}"   styleClass="required validate-selection"  name="sjlb"   notEmpty="false"  dictName="T_DIC_SJLB"/>
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          
                          <td class="crosscolor_td">
			                      <%=TelInfo.ALIAS_BZ%>
		                  </td>
			              <td colspan="3">
		                          
		                            <s:textarea label="%{@vs@ALIAS_BZ}" rows="4" cols="40"
							key="bz" value="%{model.bz}" cssClass="max-length-100"
							required="false"></s:textarea>
		                 
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          
                          <td class="crosscolor_td">
			                      <FONT color="red">*</FONT><%=TelInfo.ALIAS_CHUSHOURY%>
		                  </td>
			              <td>
	                               <s:textfield label="%{@vs@ALIAS_CHUSHOURY}" key="chushoury" value="%{model.chushoury}"  cssClass="required max-length-30 validate-chinese" required="false" />
		                  </td>
		                    <td class="crosscolor_td">
			                      <%=TelInfo.ALIAS_CHUSHOURENXB%>
		                  </td>
			              <td>
						           <mytag:select property="%{model.chushourenxb}"   styleClass="validate-selection"  name="chushourenxb"   notEmpty="false"  dictName="T_DIC_SEX"/>
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                        
                          <td class="crosscolor_td">
			                      <FONT color="red">*</FONT> <%=TelInfo.ALIAS_CHUSHOURENSFZH%>
		                  </td>
			              <td>
	                               <s:textfield label="%{@vs@ALIAS_CHUSHOURENSFZH}" key="chushourensfzh" onblur="javascript:showBirthday();"  value="%{model.chushourensfzh}"  cssClass="required max-length-18 validate-id-number" required="false" />
		                  </td>
		                  <td class="crosscolor_td">
			                      <%=TelInfo.ALIAS_CHUSHOURENLXDH%>
		                  </td>
			              <td>
		                           <s:textfield label="%{@vs@ALIAS_CHUSHOURENLXDH}" key="chushourenlxdh" value="%{model.chushourenlxdh}"  cssClass="max-length-30" required="false" />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=TelInfo.ALIAS_BEIZHU%>
		                  </td>
			              <td colspan="3">
			                       <s:textarea label="%{@vs@ALIAS_BEIZHU}" rows="4" cols="40"
							key="beizhu" value="%{model.beizhu}" cssClass="max-length-200"
							required="false"></s:textarea>
		                         
		                  </td>
                          
                   </tr>
		           <tr class="crosscolor_tr">
                         
                          <td class="crosscolor_td">
			                      <%=TelInfo.ALIAS_DQSJH%>
		                  </td>
			              <td>
	                               <s:textfield label="%{@vs@ALIAS_DQSJH}" key="dqsjh" value="%{model.dqsjh}"  cssClass="max-length-11 validate-mobile-phone" required="false" />
		                  </td>
		                   <td class="crosscolor_td">
			                      <%=TelInfo.ALIAS_CSRDH%>
		                  </td>
			              <td>
	                               <s:textfield label="%{@vs@ALIAS_CSRDH}" key="csrdh" value="%{model.csrdh}"  cssClass="max-length-30 validate-phone" required="false" />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=TelInfo.ALIAS_CSRJTZZ%>
		                  </td>
			              <td colspan="3">
		                           <s:textfield label="%{@vs@ALIAS_CSRJTZZ}" key="csrjtzz" size="40" value="%{model.csrjtzz}"  cssClass="max-length-100" required="false" />
		                  </td>
                         
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=TelInfo.ALIAS_GJSJ%>
		                  </td>
			              <td>
						           <input value="${model.gjsj}" onclick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss'})" id="gjsj" name="gjsj"  maxlength="0" class="Wdate" />
		                  </td>
                          <td class="crosscolor_td">
			                     <FONT color="red">*</FONT> <%=TelInfo.ALIAS_JBR%>
		                  </td>
			              <td>
		                         
		                         
		                     <input type="text" class="required"   name="jbrXm" maxlength="0" value="<authz:authentication property="principal.userXm"/>"  class="max-length-30"/>
		                            <input type="hidden"  name="jbr" value="<authz:authentication property="principal.username"/>" />
		                            <input name="selectPersonButton" onclick="selectPerson(inputForm,'jbrXm','jbr')"   value="选择" type="button"> 
		                              
		                         
		                    
		                            
		                       
		                  </td>
                   </tr>
	       <tr >
				<td colspan="5" class="tb_bottom">
							<input id="submitButton" name="submitButton" type="submit" value="保存" />
	                        <input type="button" value="返回" onclick="window.location='${ctx}/pages/fjy/TelInfoView/list.do?<mytag:params includes="ec*,s*" type="queryStringUtf"/>'"/>
			    </td>
	        </tr>
	</table>
</s:form>

<script>
	
	new Validation(document.forms[0],{onSubmit:true,onFormValidate : function(result,form) {
		var finalResult = result;
		if(finalResult){
			if( $F("telpp")==""){
			    alert("错误\r\n请输入手机品牌!");	
			    finalResult = false;
			}
		}
		if(finalResult){
			if( $F("telxh")==""){
			    alert("错误\r\n请输入手机型号!");	
			    finalResult = false;
			}
		}
		 showBirthday();
		//在这里添加自定义验证
		
		return disableSubmit(finalResult,'submitButton');
	}});
	
	
	 function selectPerson(frm,displayName,hiddenName) {
	           window.showModalDialog('${ctx}/pages/fjy/SsDept/selectPerson.do?deptTypeId=0,<authz:authentication property="principal.deptTypeID"/>&formName=' + frm.name + '&inputName='+displayName+'&hiddenName='+hiddenName+'&rootID=false&maxPatiNum=1&hiddenType=ID_SPLIT',frm,'dialogHeight:500px;dialogWidth:560px;center:yes');
       }
       
       
       
     
     
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