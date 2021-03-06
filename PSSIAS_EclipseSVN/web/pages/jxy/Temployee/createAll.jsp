<%@ page import="com.dyneinfo.jxy.model.*" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/commons/taglibs.jsp" %>
<%
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+request.getContextPath()+"/";
%>
<html>
<head>
	<%@ include file="/commons/meta.jsp" %>
	<base href="<%=basePath%>">
	<script type='text/javascript' src='${ctx}/dwr/interface/menu.js'></script>
	<script type='text/javascript' src='${ctx}/dwr/engine.js'></script>
	<script type='text/javascript' src='${ctx}/dwr/util.js'></script>
	<title><%=Temployee.TABLE_ALIAS%>新增</title>
</head>
<body onload="quickSelectInit()">
<%@ include file="/commons/messages.jsp" %>

<s:form action="/pages/jxy/Temployee/saveAll.do" theme="simple"  enctype="multipart/form-data"  name="inputForm" method="post">
<s:hidden key="npcodehidden"  />
<s:hidden key="nativeplacehidden"  />
	<table cellpadding="0" cellspacing="0" border="0" class="tb_all">
	    <input type="hidden" name="returnUrl" value="!/pages/jxy/Temployee/listAll.do?<mytag:params includes="ec*,s*" type="queryStringUtf"/>" />
	       <tr>
				<td colspan="4" class="tb_title"> 
							<%=Temployee.TABLE_ALIAS%>新增
			    </td>
		   </tr>
	              <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <FONT color="red">*</FONT><%=Temployee.ALIAS_NAME%>
		                  </td>
			              <td>
	                               <s:textfield label="%{@vs@ALIAS_NAME}" key="name" value="%{model.name}"  cssClass="required max-length-30 validate-chinese" required="true" />
		                  </td>
                          <td class="crosscolor_td">
			                      <FONT color="red">*</FONT><%=Temployee.ALIAS_SEX%>
		                  </td>
			              <td>
						           <mytag:select property="%{model.sex}"   styleClass="required validate-selection"  name="sex"   notEmpty="false"  dictName="T_DIC_SEX"/>
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <FONT color="red">*</FONT><%=Temployee.ALIAS_PERSONID%>
		                  </td>
			              <td>
	                               <s:textfield label="%{@vs@ALIAS_PERSONID}" onblur="javascript:showBirthday();"  key="personid" value="%{model.personid}"  cssClass="required max-length-18 validate-id-number" required="true" />
		                  </td>
                          <td class="crosscolor_td">
			                      <FONT color="red">*</FONT><%=Temployee.ALIAS_BIRTH%>
		                  </td>
			              <td>
			               <input value="${model.birth}" class="required Wdate" size="16"
						onkeyup="DateFormat(this);" 	onclick="WdatePicker({startDate:'1980-05-01',dateFmt:'yyyy-MM-dd'})"
							id="birth" name="birth"  />
						          
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=Temployee.ALIAS_ALIAS%>
		                  </td>
			              <td>
		                           <s:textfield label="%{@vs@ALIAS_ALIAS}" key="alias" value="%{model.alias}"  cssClass="max-length-30" required="false" />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=Temployee.ALIAS_FOLK%>
		                  </td>
			              <td>
						           <mytag:select property="%{model.folk}"    name="folk"   notEmpty="false"  dictName="T_DIC_NATION"/>
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=Temployee.ALIAS_NATIVEPLACE%>
		                  </td>
			              <td>
			                <s:select name="prov" id="prov"  value="220000"  onchange="changeprov();" list="provMap" listKey="key" headerValue="请选择..." headerKey=""  listValue="value" theme="simple" label="省市"  emptyOption="false" ></s:select>
							<select id="nativeplace" name="nativeplace"  ></select>
						          
		                  </td>
                          <td class="crosscolor_td">
			                      <%=Temployee.ALIAS_POLITYVISAGE%>
		                  </td>
			              <td>
						           <mytag:select property="%{model.polityvisage}"     name="polityvisage"   notEmpty="false"  dictName="T_DIC_POLITYVISAGE"/>
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=Temployee.ALIAS_SCHOOLAGE%>
		                  </td>
			              <td>
						           <mytag:select property="%{model.schoolage}"    name="schoolage"   notEmpty="false"  dictName="T_DIC_SCHOOLAGE"/>
		                  </td>
                          <td class="crosscolor_td">
			                      
		                  </td>
			              <td>
						           <mytag:select property="%{model.hyzh}"     name="hyzh"   notEmpty="false"  dictName="T_DIC_HYZK"/>
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=Temployee.ALIAS_STATURE%>
		                  </td>
			              <td>
	                               <s:textfield label="%{@vs@ALIAS_STATURE}" key="stature" value="%{model.stature}"  cssClass="max-length-3 validate-digits" required="false" />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=Temployee.ALIAS_WEIGHT%>
		                  </td>
			              <td>
	                               <s:textfield label="%{@vs@ALIAS_WEIGHT}" key="weight" value="%{model.weight}"  cssClass="max-length-3 validate-digits" required="false" />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=Temployee.ALIAS_POSTURE%>
		                  </td>
			              <td>
						           <mytag:select property="%{model.posture}"    name="posture"   notEmpty="false"  dictName="T_DIC_SHAPE"/>
		                  </td>
                          <td class="crosscolor_td">
			                    <FONT color="red">*</FONT>  <%=Temployee.ALIAS_NPCODE%>
		                  </td>
			              <td>
						          <s:select name="prov2" id="prov2"  value="220000"  onchange="changeprov2();" list="provMap" listKey="key" headerValue="请选择..." headerKey=""  listValue="value" theme="simple" label="省市"  emptyOption="false" ></s:select>
							      <select id="npcode" name="npcode"  ></select>
						          
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=Temployee.ALIAS_ADDRESS%>
		                  </td>
			              <td colspan="3">
		                           <s:textfield label="%{@vs@ALIAS_ADDRESS}" size="60" key="address" value="%{model.address}"  cssClass="max-length-100" required="false" />
		                  </td>
		           </tr>
		           <tr class="crosscolor_tr">     
                          <td class="crosscolor_td">
			                      <%=Temployee.ALIAS_NPADDRESS%>
		                  </td>
			              <td colspan="3">
		                           <s:textfield label="%{@vs@ALIAS_NPADDRESS}"  size="60" key="npaddress" value="%{model.npaddress}"  cssClass="max-length-100" required="false" />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=Temployee.ALIAS_PHONE%>
		                  </td>
			              <td>
	                               <s:textfield label="%{@vs@ALIAS_PHONE}" key="phone" value="%{model.phone}"  cssClass="max-length-20 validate-number" required="false" />
		                  </td>
                          <td class="crosscolor_td">
			                      <FONT color="red">*</FONT><%=Temployee.ALIAS_CYRJZT%>
		                  </td>
			              <td>
						           <mytag:select property="%{model.cyrjzt}"   styleClass="required validate-selection"  name="cyrjzt"   notEmpty="false"  dictName="T_DIC_CYRJZT"/>
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=Temployee.ALIAS_TEMPORARYCODE%>
		                  </td>
			              <td>
		                           <s:textfield label="%{@vs@ALIAS_TEMPORARYCODE}" key="temporarycode" value="%{model.temporarycode}"  cssClass="max-length-16" required="false" />
		                  </td>
		                  <td>
						   照片
						  </td>
						  <td >
								<s:file name="file" style="WIDTH:300px;cursor:hand"  UNSELECTABLE="on"  id="file"
									cssClass="" label="图片"></s:file>
							
						  </td>
                          
                   </tr>
                   <tr class="crosscolor_tr">     
                          <td class="crosscolor_td">
			                      <%=Temployee.ALIAS_NOWADRESS%>
		                  </td>
			              <td >
		                           <s:textfield label="%{@vs@ALIAS_NOWADRESS}"  key="nowadress" value="%{model.nowadress}"  cssClass="max-length-100" required="false" />
		                  </td>
		                   <td class="crosscolor_td">
			                     <FONT color="red">*</FONT>  工作单位
		                  </td>
			              <td>
		                           
		                           <s:textfield  key="deptname" value="%{model.deptname}"  cssClass="required max-length-60 " maxlength="0"  required="false" />
		                           <s:hidden name="cpcode" value="%{model.cpcode}"></s:hidden>
		                           <input name="selectDeptButton"  onclick="javascript:selectDept(inputForm,'deptname','cpcode')"   value="选择" type="button" > 
		                 
		                  </td>
                   </tr>
		         
	       <tr >
				<td colspan="4" class="tb_bottom">
							<input id="submitButton" name="submitButton" type="submit" value="提交" />
	                        <input type="button" value="返回" onclick="window.location='${ctx}/pages/jxy/Temployee/listAll.do?<mytag:params includes="ec*,s*" type="queryStringUtf"/>'"/>
			    </td>
	        </tr>
	</table>
</s:form>
<script>
	
	new Validation(document.forms[0],{onSubmit:true,onFormValidate : function(result,form) {
		var finalResult = result;
		
		//在这里添加自定义验证
		var frm = document.forms[0];
		if(finalResult){
		if(!checkFileUpload(frm,'GIF,JPG,JPEG,PNG,BMP',false))		 
		     finalResult = false;
		 }
		showBirthday();
		return disableSubmit(finalResult,'submitButton');
	}});
</script>
<SCRIPT LANGUAGE="JavaScript">
<!-- Begin  -->  	
  	//提取身份信息
	function showBirthday() {
	
		var birthdayValue,xzqhs,val,provId;
		val = document.all.personid.value;
		
	
		  
		if (15 == val.length) {//15位身份证号码   
			birthdayValue = val.charAt(6) + val.charAt(7);
			if (parseInt(birthdayValue) < 10) {
				birthdayValue = '20' + birthdayValue;
				document.all.personid.value =  chg_sfzh(document.all.personid.value,20);
			} else {
				birthdayValue = '19' + birthdayValue;
				document.all.personid.value =  chg_sfzh(document.all.personid.value,19);
			}
			birthdayValue = birthdayValue + '-' + val.charAt(8) + val.charAt(9)
					+ '-' + val.charAt(10) + val.charAt(11);
			xzqhs = 	val.substr(0,6);
			provId = 	val.substr(0,2);
			if (parseInt(val.charAt(14) / 2) * 2 != val.charAt(14))
				document.all.sex.value = '1';
			else
				document.all.sex.value = '2';
			document.all.birth.value = birthdayValue;
			document.all.prov.value = provId+"0000";
			document.all.prov2.value = provId+"0000";
			sfzhSetxzqh(provId,xzqhs);
			sfzhSetxzqh2(provId,xzqhs);
			
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
			if (val.charAt(17) != IDCard(val)) {
				document.all.personid.style.backgroundColor = '#ffc8c8';
				document.all.personid.value= val.toUpperCase();
			} else {
				document.all.personid.style.backgroundColor = 'white';
			}
			document.all.birth.value = birthdayValue;
			document.all.prov.value = provId+"0000";
			document.all.prov2.value = provId+"0000";
			
			sfzhSetxzqh(provId,xzqhs);
			sfzhSetxzqh2(provId,xzqhs);
			
			
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
	
   function sfzhSetxzqh(provinceId,xzqhValue)
	{
	    DWRUtil.setValue('npcodehidden',xzqhValue);
		menu.queryXzqhById(provinceId,cityCallback2);	
	}
	
	function sfzhSetxzqh2(provinceId,xzqhValue)
	{
	    DWRUtil.setValue('nativeplacehidden',xzqhValue);
		menu.queryXzqhById(provinceId,cityCallback);	
	}


   function changeprov()
	{
	  queryCity();
	}
	
	//查询所属城市
	function queryCity()
	{
		var provinceId = spider("prov").value;
		provinceId = provinceId.substr(0,2);
		menu.queryXzqhById(provinceId,cityCallback);
	}
	
	//查询所属城市回调函数
	function cityCallback(citys)
	{
      //每次获得新的数据的时候先把每三个下拉框架的长度清0
	   DWRUtil.removeAllOptions("nativeplace");
        try{
           // DWRUtil.addOptions("xzqh",{'':'请选择...'});  
            DWRUtil.addOptions("nativeplace",citys,"id","cityName");//将option对象添加到第三个下拉框中    
            DWRUtil.setValue('nativeplace',$F("nativeplacehidden")); 
        }catch(e){
        }
     
	}
	
	function changeprov2()
	{
	  queryCity2();
	}
	
	//查询所属城市
	function queryCity2()
	{
		var provinceId = spider("prov2").value;
		provinceId = provinceId.substr(0,2);
		menu.queryXzqhById(provinceId,cityCallback2);
	}
	
		//查询所属城市回调函数
	function cityCallback2(citys)
	{
      //每次获得新的数据的时候先把每三个下拉框架的长度清0
	   DWRUtil.removeAllOptions("npcode");
        try{
           // DWRUtil.addOptions("xzqh",{'':'请选择...'});  
            DWRUtil.addOptions("npcode",citys,"id","cityName");//将option对象添加到第三个下拉框中
           
            DWRUtil.setValue('npcode',$F("npcodehidden")); 
        }catch(e){
        }
     
	}
	queryCity();
    queryCity2();
    
    	//格式日期
	function DateFormat(obj) {
	    var bdate;
		bdate = obj.value;
		if(bdate != "" && 8 == bdate.length){
		   obj.value = bdate.charAt(0) + bdate.charAt(1) + bdate.charAt(2)
					+ bdate.charAt(3) + '-' + bdate.charAt(4) + bdate.charAt(5)
					+ '-' + bdate.charAt(6) + bdate.charAt(7);
		}
	
	}


     function selectDept(frm,displayName,hiddenName) {
	           window.showModalDialog('${ctx}/pages/SsDept/selectDept.do?formName=' + frm.name + '&inputName='+displayName+'&hiddenName='+hiddenName+'&rootID=false&maxPatiNum=1&hiddenType=ID_SPLIT',frm,'dialogHeight:500px;dialogWidth:560px;center:yes');
       }
       
       	
		   //检查上传物件 checkFileUpload(表单名称,档案类型,是否需要上传,档案大小,图片最小宽度,图片最小高度,图片最大宽度,图片最大高度,储存宽度的表单名称,储存高度的表单名称)
function checkFileUpload(form,extensions,requireUpload) {
  document.MM_returnValue = true;
  if (extensions != '') var re = new RegExp("\.(" + extensions.replace(/,/gi,"|") + ")$","i");
  for (var i = 0; i<form.elements.length; i++) {
    field = form.elements[i];
    if (field.type.toUpperCase() != 'FILE' || field.name.toUpperCase() != 'FILE') continue;
    if (field.value == '') {
      if (requireUpload) {alert('请选取上传的文件！');document.MM_returnValue = false;field.focus();break;}
    } else {
      if(extensions != '' && !re.test(field.value)) {
         alert('图片文件不符合上传的类型！\n只有以下的类型才允许上传： ' + extensions + '。\n请依规定选取新的上传文件。');
        document.MM_returnValue = false;
        field.focus();
        break;
      }
   } 
 }
  return document.MM_returnValue;
    
}
<!-- End -->
</SCRIPT>

</body>
</html>
