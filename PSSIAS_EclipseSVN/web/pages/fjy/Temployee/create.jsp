<%@ page import="com.dyneinfo.fjy.model.*" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/commons/taglibs.jsp" %>
<%@ page import="net.java.dev.common.dict.taglib.DictHelpImpl"%>
<%
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ request.getContextPath() + "/";
	String IDCardType = (String) DictHelpImpl.getInitData("IDCardType");
	String prcode = (String)DictHelpImpl.getInitData("prcode");
	String type = (String)request.getAttribute("x");   
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
<body onload="quickSelectInit()" >
<%@ include file="/commons/messages.jsp" %>

<s:form action="/pages/fjy/Temployee/save.do" theme="simple"  enctype="multipart/form-data"  name="inputForm" method="post">
<s:hidden key="npcodehidden"  />
<s:hidden key="nativeplacehidden"  />
	<table cellpadding="0" cellspacing="0" border="1" class="tb_all">
	    <input type="hidden" name="returnUrl" value="!/pages/fjy/Temployee/list.do?<mytag:params includes="ec*,s*" type="queryStringUtf"/>" />
	      <input type="hidden"  id="fileid" name="s_files"/>
	       <tr>
				<td colspan="5" id="chongyerenyuantianjia" class="tb_title"> 
							<%=Temployee.TABLE_ALIAS%>新增
			    </td>
		   </tr>
	              <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <FONT color="red">*</FONT><%=Temployee.ALIAS_EMPNAME%>
		                  </td>
			              <td>
	                               <s:textfield label="%{@vs@ALIAS_EMPNAME}" key="empname" value="%{model.empname}"  cssClass="required max-length-30 validate-chinese" required="true" />
		                  </td>
                          <td class="crosscolor_td">
			                      <FONT color="red">*</FONT><%=Temployee.ALIAS_SEX%>
		                  </td>
			              <td>
						           <mytag:select property="%{model.sex}"   styleClass="required validate-selection"  name="sex"   notEmpty="false"  dictName="T_DIC_SEX"/>
		                  </td>
		                  <c:if test="${x != 1}">
			                  <td width="25%" rowspan="7" id="clxxDevice" >
				             <%
				             	if (IDCardType != null && IDCardType.equals("0")) {
				             %>     
							  <IFRAME height="170" width="340" name="result"   src="${ctx}/pages/fjy/Temployee/IDcard.htm"
								align="center" frameBorder="0" marginHeight="0" marginWidth="0"></IFRAME>
							  <%
							  	} else if (IDCardType != null && IDCardType.equals("1")) {
							  %>	
								<IFRAME height="370" width="280" name="result"   src="${ctx}/pages/fjy/Temployee/CVR_IDCard.html"
								align="center" frameBorder="0" marginHeight="0" marginWidth="0"></IFRAME>
							  <%
							  	} else if (IDCardType != null && IDCardType.equals("2")) {
							  %>	
								<IFRAME height="370" width="280" name="result"   src="${ctx}/pages/fjy/Temployee/WENT_IDCard.html"
								align="center" frameBorder="0" marginHeight="0" marginWidth="0"></IFRAME>
							  <%
							  	}
							  %>
						       </td>
						       
						    <td width ="25%" rowspan="7"  align="center" id="imgidtd" style="display:none;">
								 <img id="imgid"	 src='${ctx}/images/spacer.gif'"  width="150" height="200" alt="" border="0" name="photo"> 
							</td>
					       </c:if>
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
			                      <%=Temployee.ALIAS_FOLK%>
		                  </td>
			              <td>
						           <mytag:select property="%{model.folk}"    name="folk"   notEmpty="false"  dictName="T_DIC_NATION"/>
		                  </td>
                          <td class="crosscolor_td">
			                      <%=Temployee.ALIAS_ALIAS%>
		                  </td>
			              <td>
		                           <s:textfield label="%{@vs@ALIAS_ALIAS}" key="alias" value="%{model.alias}"  cssClass="max-length-30" required="false" />
		                  </td>
                         
                   </tr>

		           
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=Temployee.ALIAS_SCHOOLAGE%>
		                  </td>
			              <td>
						           <mytag:select property="%{model.schoolage}"    name="schoolage"   notEmpty="false"  dictName="educations"/>
		                  </td>
		                  <td class="crosscolor_td">
			                      <%=Temployee.ALIAS_POLITYVISAGE%>
		                  </td>
			              <td>
						           <mytag:select property="%{model.polityvisage}"     name="polityvisage"   notEmpty="false"  dictName="partyvisage"/>
		                  </td>

                   </tr>
		           <tr class="crosscolor_tr">
		                  <td class="crosscolor_td">
			                      <%=Temployee.ALIAS_HYZH%>
		                  </td>
			              <td>
						           <mytag:select property="%{model.hyzh}"     name="hyzh"   notEmpty="false"  dictName="T_DIC_HYZK"/>
		                  </td>
                          <td class="crosscolor_td">
			                      <%=Temployee.ALIAS_STATURE%>
		                  </td>
			              <td>
	                               <s:textfield label="%{@vs@ALIAS_STATURE}" key="stature" value="%{model.stature}"  cssClass="max-length-3 validate-digits" required="false" />
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
			                      <%=Temployee.ALIAS_WEIGHT%>
		                  </td>
			              <td >
	                               <s:textfield label="%{@vs@ALIAS_WEIGHT}" key="weight" value="%{model.weight}"  cssClass="max-length-3 validate-digits" required="false" />
		                  </td>
                         
                   </tr>
                   <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=Temployee.ALIAS_NATIVEPLACE%>
		                  </td>
			               <td colspan="4">
			                <s:select name="prov" id="prov"  value=""  onchange="changeprov();" list="provMap" listKey="key" headerValue="请选择..." headerKey=""  listValue="value" theme="simple" label="省市"  emptyOption="false" ></s:select>
							<select id="nativeplace" name="nativeplace"  ></select>
		                  </td>
		          </tr> 

		                              <tr class="crosscolor_tr">     
                          <td class="crosscolor_td">
			                      <%=Temployee.ALIAS_NPADDRESS%>
		                  </td>
			              <td colspan="4">
		                           <s:textfield label="%{@vs@ALIAS_NPADDRESS}"  size="60" key="npaddress" value="%{model.npaddress}"  cssClass="max-length-100" required="false" />
		                  </td>
                   </tr>
                                      <tr class="crosscolor_tr">  
                          <td class="crosscolor_td">
			                    <FONT color="red">*</FONT>  <%=Temployee.ALIAS_NPCODE%>
		                  </td>
			               <td colspan="4">
						          <s:select name="prov2" id="prov2"  value=""  cssClass="required" onchange="changeprov2();" list="provMap" listKey="key" headerValue="请选择..." headerKey=""  listValue="value" theme="simple" label="省市"  emptyOption="false" ></s:select>
							      <select id="npcode" name="npcode"  ></select>
						          
		                  </td>
		            </tr>      
                   
       		         <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=Temployee.ALIAS_ADDRESS%>
		                  </td>
			              <td colspan="4">
		                           <s:textfield label="%{@vs@ALIAS_ADDRESS}" size="60" key="address" value="%{model.address}"  cssClass="max-length-100" required="false" />
		                  </td>
		           </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=Temployee.ALIAS_PHONE%>
		                  </td>
			              <td colspan="4">
	                               <s:textfield label="%{@vs@ALIAS_PHONE}" key="phone" value="%{model.phone}"  cssClass="max-length-20 validate-number" required="false" />
		                  </td>

                   </tr>
		        <tr class="crosscolor_tr">

					<td>
						<FONT color="red">*</FONT>人员职务:
					</td>
					<td >
						<mytag:select property="%{model.position}"
							styleClass="required validate-selection" name="position"
							notEmpty="false" dictName="DICT_ITEM_EMP_POSI" />

					</td>
					                          <td class="crosscolor_td">
			                      <FONT color="red">*</FONT><%=Temployee.ALIAS_CYRJZT%>
		                  </td>
			              <td colspan="2">
						           <mytag:select property="%{model.cyrjzt}"   styleClass="required validate-selection"  name="cyrjzt"   notEmpty="false"  dictName="cyryFlag"/>
		                  </td>
				</tr>


				<tr class="crosscolor_tr">
					<td class="crosscolor_td" colspan="5" style="text-align: left;">
						<input type="checkbox" id="checkOpr" class="formRadio"
							onclick="isDisplay();" />
						操作员信息
					</td>
				</tr>
				<tr id="show0a" style="display:none" class="crosscolor_tr">
					<td class="crosscolor_td">
						<FONT color="red">*</FONT>
						<%=User.ALIAS_USERNAME%>
					</td>
					<td>
						<s:textfield label="%{@vs@ALIAS_USERNAME}" id="username" key="username"
							value="%{model.username}" cssClass="required max-length-50"
							required="false" />
					</td>
					<td class="crosscolor_td">
						<FONT color="red">*</FONT>
						<%=User.ALIAS_ENABLED%>
					</td>
					<td colspan="2">
						<mytag:select property="%{model.enabled}"
							styleClass="required validate-selection" name="enabled"
							notEmpty="false" dictName="status" />

					</td>

				</tr>
				<tr id="show0b" style="display:none"  class="crosscolor_tr">
					<td class="crosscolor_td">
						<FONT color="red">*</FONT> 注册密码
					</td>
					<td>
						<input type="password" name="password" id="password" class="required max-length-50">
	
					</td>
					<td class="crosscolor_td">
						<FONT color="red">*</FONT> 再次输入密码
					</td>
					<td colspan="2">
					
						<input type="password" name="password2" id="password2" class="required max-length-50">

					</td>
				</tr>
                <tr id="show0c"  style="display:none"  class="crosscolor_tr">
						<td>
							<FONT color="red">*</FONT>角色
						</td>
						<td colspan="4">
							<s:radio value="selectList" listKey="roleid" cssClass="formRadio"
								listValue="roledesc" list="rolemap" name="roles" />
						</td>
					</tr>
				<tr >
				
				<td colspan="5" class="tb_bottom">
							<input id="submitButton" name="submitButton" type="submit" value="保存" />
	                        <input type="button" value="返回" onclick="window.location='${ctx}/pages/fjy/Temployee/list.do?<mytag:params includes="ec*,s*" type="queryStringUtf"/>'"/>
			    </td>
	        </tr>
	</table>
</s:form>
<script>
	
	new Validation(document.forms[0],{onSubmit:true,onFormValidate : function(result,form) {
		var finalResult = result;
		
		//在这里添加自定义验证
		var frm = document.forms[0];

		var flag= document.getElementById("checkOpr").checked;
		if(flag)  {  

			if (!hasOneChecked("roles")){
	            alert('请在操作员信息中选择角色!');
	            finalResult =  false;
			}
			
			if(finalResult){
				if(!isTrueName($F("username")))
				{
					alert("操作员信息中用户名请以字母开头，长度在6-10之间！");
					finalResult =  false;
				}
		    }
			
            if(finalResult){
				if(document.all.password.value!=document.all.password2.value)
			    {
			      alert('操作员信息中两次输入密码不一样');
			      finalResult = false;
			    }
	        }
	    }
		showBirthday();
		return disableSubmit(finalResult,'submitButton');
	}});

	function clxxDevice(){ //用于框架调用
	 	if(<%=type %> != 1){
		 	document.getElementById("clxxDevice").style.display ="none";
		 	document.getElementById("imgidtd").style.display ="";
	 	}
	 }
	
	function isTrueName(s) {
		var patrn = /^[a-zA-Z][a-zA-Z0-9_]{5,10}$/;
		if (!patrn.exec(s))
			return false
		return true
	}
</script>
<SCRIPT LANGUAGE="JavaScript">
<!-- Begin  -->  	
  	//提取身份信息
  	
    function isTrueName(s) {
		var patrn = /^[a-zA-Z][a-zA-Z0-9_]{5,10}$/;
		if (!patrn.exec(s))
			return false
		return true
	}
	
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
	
	//性别读取
   function sexSelectItemByValue(objItemText) {            
	     var objSelect = document.getElementById("sex");       
	     var isExit = false;        
	     for (var i = 0; i < objSelect.options.length; i++) {        
	         if (objSelect.options[i].text == objItemText) {        
	             objSelect.options[i].selected = true;        
	             isExit = true;        
	             break;        
	         }        
	     }              
    }
   
  //名族读取
  function folkSelectItemByValue(objItemText) {            
	     var objSelect = document.getElementById("folk");       
	     var isExit = false;        
	     for (var i = 0; i < objSelect.options.length; i++) {        
	         if (objSelect.options[i].text == objItemText+'族') {        
	             objSelect.options[i].selected = true;        
	             isExit = true;        
	             break;        
	         }        
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
		var provinceId = $("prov").value;
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
		var provinceId = $("prov2").value;
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
	




function isDisplay() {	
      var flag= document.getElementById("checkOpr").checked;   
	   document.getElementById("show0a").style.display = flag?"":"none";
	   document.getElementById("show0b").style.display = flag?"":"none";
	   document.getElementById("show0c").style.display = flag?"":"none";	    	   
	}

<!-- End -->
</SCRIPT>

</body>
</html>