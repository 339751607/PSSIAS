<%@ page import="com.dyneinfo.fjy.model.*" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/commons/taglibs.jsp" %>
<%@ page import="net.java.dev.common.dict.taglib.DictHelpImpl"%>
<%@ taglib prefix="authz" uri="http://www.springframework.org/security/tags" %>

<%
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+request.getContextPath()+"/";
String IDCardType = (String)DictHelpImpl.getInitData("IDCardType");
String npcode = (String)DictHelpImpl.getInitData("mpcode").substring(0,6);
String type = (String)request.getAttribute("x"); 

%>
<html>
<style type="text/css">
<!--



.buttom{
font-size:14px;
border:0px #1E7ACE solid;
background:#D0F0FF;
color：#D0F0FF;
}


-->
</style>
<head>
	<%@ include file="/commons/meta.jsp" %>
	<base href="<%=basePath%>">
		<script src="<c:url value="/scripts/jquery.js"/>" type="text/javascript"></script>
	 <script language="javascript">     
             var j$ = jQuery.noConflict();     
     </script>
	<script type='text/javascript' src='${ctx}/dwr/interface/menu.js'></script>
	<script type='text/javascript' src='${ctx}/dwr/engine.js'></script>
	<script type='text/javascript' src='${ctx}/dwr/util.js'></script>

	<link href="<c:url value="/widgets/ext-3.0.0/resources/css/ext-all.css"/>" type="text/css" rel="stylesheet">
	<script src="<c:url value="/widgets/ext-3.0.0/adapter/ext/ext-base.js"/>" type="text/javascript"></script>
	<script src="<c:url value="/widgets/ext-3.0.0/ext-all.js"/>" type="text/javascript"></script>
	<title><%=Tfeijiuwupin.TABLE_ALIAS%></title>
</head>
<body onload="quickSelectInit()" >
<%@ include file="/commons/messages.jsp" %>
<s:hidden name="npcodehidden" value="%{#request.npcodehidden}"></s:hidden>
			<s:hidden name="nativeplacehidden"
				value="%{#request.nativeplacehidden}"></s:hidden>
<s:form action="/pages/fjy/Tfeijiuwupin/save.do"  enctype="multipart/form-data" theme="simple" name="inputForm"  method="post">
	<table cellpadding="0" cellspacing="0" border="1" class="tb_all">
	 <input value="" type="hidden" id="photoBuffer" name="photoBuffer"  />
	 
	    <input type="hidden" name="returnUrl" value="!/pages/fjy/Tfeijiuwupin/create.do?<mytag:params includes="ec*,s*" type="queryStringUtf"/>" />
	       <tr>
				<td colspan="5" class="tb_title"> 
							<%=Tfeijiuwupin.TABLE_ALIAS%>
			    </td>
		   </tr>
	         <tr class="crosscolor_tr">
		                   <td class="crosscolor_td">
			                    <FONT color="red">*</FONT> 收购人
		                  </td>
			              <td >
			              
			              <input type="hidden" style="width:200px;"  class="required max-length-100"   id="shougoury" readOnly  name="shougoury" value="${shougoury}">
			              <input type="text" style="width:200px;"  class="required max-length-100"   id="username" readOnly  name="username" value="${username}">
<!--			               		<select  name="shougoury" id="shougoury"    Class="required validate-selection">-->
<!--			               		-->
<!--			               		</select>-->
		                  </td>
		                  <td class="crosscolor_td">
			                  <FONT color="red">*</FONT> 物品类别 
		                  </td>
			              <td>
						           <mytag:select property="%{model.wupinlb}"   styleClass="required validate-selection"  name="wupinlb"   notEmpty="false"  dictName="T_DIC_WUPINLB"/>
		                  </td>
		                  <c:if test="${x != 1}">
		                  <td width="119" rowspan="16" id="clxxDevice">
		                  
			             <%if(IDCardType != null && IDCardType.equals("0")) { %> 
						  <IFRAME height="100%" width="340" name="result"   src="${ctx}/pages/fjy/Temployee/IDcard_fjwp.htm"
							align="center" frameBorder="0" marginHeight="0" marginWidth="0"></IFRAME>
						<% } else if(IDCardType != null && IDCardType.equals("1")) { %>	
							<IFRAME height="100%" width="220" name="result"   src="${ctx}/pages/fjy/Temployee/CVR_IDCard_fjwp.html"
							align="center" frameBorder="0" marginHeight="0" marginWidth="0"></IFRAME>
						<% } else if(IDCardType != null && IDCardType.equals("2")) { %>	
							<IFRAME height="100%" width="220" name="result"   src="${ctx}/pages/fjy/Temployee/WENT_IDCard_wp.html"
							align="center" frameBorder="0" marginHeight="0" marginWidth="0"></IFRAME>
						  <% } %>	
						  
					       </td>
					       
					        <td width ="25%" rowspan="16"  align="center" id="imgidtd" style="display:none;">
							<img id="imgid"	 src='${ctx}/images/spacer.gif'"  width="150" height="200"  alt="" border="0" name="photo">
							</td>
					       </c:if>
                   </tr>

		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                    <FONT color="red">*</FONT>  <%=Tfeijiuwupin.ALIAS_CHUSHOURY%>
		                  </td>
			              <td>
			              <input type="text" style="width:140px;" class="required max-length-30"  id="csrxm" name="csrxm" value="${model.csrxm}">
		                           <input name="selectCsrxxbutton" onclick="javascript:selectCsrxx()"   value="选择" style="width:40px" type="button"> 
		                  </td>
                          <td class="crosscolor_td">
			                   <FONT color="red">*</FONT>   <%=Tfeijiuwupin.ALIAS_CHUSHOURENXB%>
		                  </td>
			              <td>
			              <input id = "pPhotoBuffer" name = "pPhotoBuffer" type="hidden" value=""/>
						           <mytag:select property="%{model.csrxb}"   styleClass="required validate-selection"  name="csrxb"   notEmpty="false"  dictName="T_DIC_SEX"/>
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                   <FONT color="red">*</FONT>   <%=Tfeijiuwupin.ALIAS_CHUSHOURENSFZH%>
		                  </td>
			              <td>
	                               <s:textfield label="%{@vs@ALIAS_CHUSHOURENSFZH}" id="chushourensfzh"  key="chushourensfzh" onblur="javascript:showBirthday();"  value="%{model.chushourensfzh}"  cssClass="required max-length-18 validate-id-number" required="false" />
		                  </td>
	 					<td class="crosscolor_td">
<!--			                     Tfeijiuwupin.ALIAS_CHUSHOURENLXDH   张家口提出修改-->
		                  </td>

			              <td >
<!--	                               <s:textfield label="%{@vs@ALIAS_CHUSHOURENLXDH}" id="chushourenlxdh"  key="chushourenlxdh" value="%{model.chushourenlxdh}"  cssClass="max-length-30 validate-number" required="false" />-->
		                  </td>
                   </tr>
                     <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                       <FONT color="red">*</FONT>身份证行政区划
		                  </td>
					<td colspan="3">
						<s:select name="prov" id="prov"
							value="#request.npcodeprovhidden"  cssClass="required" onchange="changeprov();"
							list="provMap" listKey="key" headerValue="请选择..." headerKey=""
							listValue="value" theme="simple" label="省市" emptyOption="false"></s:select>
						<select id="npcode" name="npcode"> </select>

					</td>
		          </tr> 
		           <tr class="crosscolor_tr">     
                          <td class="crosscolor_td">
			                     <FONT color="red">*</FONT>身份证详址
		                  </td>
			              <td colspan="3">
			              		<input type="text" style="width:350px;" class="required max-length-100"  id="npaddress" name="npaddress" value="${model.npaddress}">
		                         
		                  </td>
                   </tr>
                   	<tr class="crosscolor_tr">     
                          <td class="crosscolor_td">
			                     &nbsp;&nbsp;&nbsp;出售人户籍地
		                  </td>
			              <td colspan="3">
			              	<input type="text" style="width:350px;" class=" max-length-100" id="hjaddress"  name="hjaddress" value="${model.hjaddress}">
		                         
		                  </td>
                   </tr>
<!--		           <tr class="crosscolor_tr">     -->
<!--                          <td class="crosscolor_td">-->
<!--			                     &nbsp;&nbsp;&nbsp;出售人现住址-->
<!--		                  </td>-->
<!--			              <td colspan="3">      张家口提出修改-->
<!--			             <input type="text" style="width:350px;" class=" max-length-100"   id="praddress" name="praddress" value="${model.praddress}">-->
		                           
<!--		                  </td>-->
<!--                   </tr>-->
  				<tr class="crosscolor_tr">     
                           <td class="crosscolor_td">
			                       <FONT color="red">*</FONT><%=Tfeijiuwupin.ALIAS_WPZL%>
		                  </td>
			              <td>
	                               <s:textfield label="%{@vs@ALIAS_WPZL}" key="wpzl" value="%{model.wpzl}" onblur="calculate();"  cssClass="required  max-length-8" required="false" />
		                  </td>
		                  <td class="crosscolor_td">
			                      <%=Tfeijiuwupin.ALIAS_SGWPSL%>
		                  </td>
			              <td>
	                               <s:textfield label="%{@vs@ALIAS_SGWPSL}" key="sgwpsl" value="%{model.sgwpsl}"  cssClass="validate-integer max-length-3 " required="false" />
		                  </td>
                          
                   </tr>
  				<tr class="crosscolor_tr">     
                           <td class="crosscolor_td">
			                        <%=Tfeijiuwupin.ALIAS_UNITPRICE%>
		                  </td>
			              <td>
	                               <s:textfield label="%{@vs@ALIAS_UNITPRICE}" key="unitprice"  value="%{model.unitprice}" onblur="calculate();"  required="false" />
		                  </td>
		                  <td class="crosscolor_td">
			                      <%=Tfeijiuwupin.ALIAS_TOTALPRICE%>
		                  </td>
			              <td>
	                               <s:textfield label="%{@vs@ALIAS_TOTALPRICE}" readonly="true"  key="totalprice" value="%{model.totalprice}"  cssClass="max-length-18 " required="false" /></br>（总价=重量数*单价）
		                  </td>
                          
                   </tr>
  				<tr class="crosscolor_tr">   
  				          <td class="crosscolor_td">
			                      <%=Tfeijiuwupin.ALIAS_SGWPGG%>
		                  </td>
			              <td>
		                           <s:textfield label="%{@vs@ALIAS_SGWPGG}" key="sgwpgg" value="%{model.sgwpgg}"  cssClass="max-length-50" required="false" />
		                  </td>
                           <td class="crosscolor_td">
			                      <%=Tfeijiuwupin.ALIAS_WPDX%>
		                  </td>
			              <td>
		                           <s:textfield label="%{@vs@ALIAS_WPDX}" key="wpdx" value="%{model.wpdx}"  cssClass="max-length-10" required="false" />
		                  </td>
                       
                   </tr>   
                     				<tr class="crosscolor_tr">     
                          <td class="crosscolor_td">
			                    废钢铁重量
		                  </td>
			              <td >
		                           <s:textfield label=""  key="zlone"  cssClass="max-length-18 validate-number" required="false" />
		                  </td>
		                   <td class="crosscolor_td">
			                    废合金钢重量
		                  </td>
			              <td >
		                          <s:textfield label=""   key="zltwo"   cssClass="max-length-18 validate-number" required="false" />
		                  </td>
                   </tr>
  				<tr class="crosscolor_tr">     
                          <td class="crosscolor_td">
			                     废有色金属重量
		                  </td>
			              <td>
		                          <s:textfield label=""   key="zlthree"   cssClass="max-length-18 validate-number" required="false" />
		                  </td>
		                  <td class="crosscolor_td">
			                     废稀贵金属重量
		                  </td>
			              <td>
		                       <s:textfield label=""   key="zlfour"  cssClass="max-length-18 validate-number" required="false" />
		                  </td>
                   </tr>                                    
				<tr >
				 <tr class="crosscolor_tr">
					<td class="crosscolor_td">
						二代证照片
					</td>
					<td colspan="3">
						<s:file name="upload" style="WIDTH:300px;cursor:hand"  UNSELECTABLE="on"  id="upload"
							cssClass=" validate-file-png-jpg-jpeg-gif-bmp" label="图片"></s:file>
					</td>
				   </tr>
				   <tr class="crosscolor_tr">
					<td class="crosscolor_td">
						出售人拍照照片
					</td>
					<td colspan="3">
						<s:file name="pic" style="WIDTH:300px;cursor:hand"  UNSELECTABLE="on"  id="pics"
							cssClass=" validate-file-png-jpg-jpeg-gif-bmp" label="图片"></s:file>
							
							<input name="selectOrg" onclick="selectCapturePhoto(inputForm,'pic','picfileid')"   value="摄像头"type="button"> 
		                            <input value="" type="hidden"  name="picfileid"  />
		                            <input value="" type="hidden"  name="picfilename"  />
					</td>
				   </tr>
				   <tr class="crosscolor_tr">
					<td class="crosscolor_td">
						废旧金属拍照照片
					</td>
					<td colspan="3">
						<s:file name="affix" style="WIDTH:300px;cursor:hand"  UNSELECTABLE="on"  id="affix"
							cssClass=" validate-file-png-jpg-jpeg-gif-bmp" label="图片"></s:file>
							
							<input name="selectOrg" onclick="selectCapturePhoto(inputForm,'affix','affixfileid')"   value="摄像头"type="button"> 
		                            <input value="" type="hidden"  name="affixfileid"  />
		                            <input value="" type="hidden"  name="affixfilename"  />
					</td>
				   </tr>
				<td colspan="5" class="tb_bottom">
							<input id="submitButton" name="submitButton" type="submit" value="保存" />
 							<input type="reset" value="重置" />
			    </td>
	        </tr>
	</table>
</s:form>

<script>
	//根据单价和重量计算总的价格
	function calculate(){
		 if(document.getElementById("unitprice").value !="" && document.getElementById("wpzl").value !=""){
			var unitprice = document.getElementById("unitprice").value;
			var wpzl = document.getElementById("wpzl").value;
			 if(isNaN(unitprice)){
			 	alert("请输入正确的单价");
			 }else if(isNaN(wpzl)){
			 	alert("请输入正确的重量");
			 }else{
				var totalprice = unitprice * wpzl;
				document.getElementById("totalprice").value= totalprice.toFixed(2);
			 }
		}
	}

	new Validation(document.forms[0],{onSubmit:true,onFormValidate : function(result,form) {
		var finalResult = result;
		
		//在这里添加自定义验证
		//if(yzzl())
		return disableSubmit(finalResult,'submitButton');
	}});
	
	
	function clxxDevice(){ //用于框架调用
		if(<%=type %> != 1){
		 	document.getElementById("clxxDevice").style.display ="none";
		 	document.getElementById("imgidtd").style.display ="";
		 }
	 }
	 
	function yzzl(){
		if(document.getElementById("zlone").value==""&&document.getElementById("zltwo").value==""&&document.getElementById("zlthree").value==""&&document.getElementById("zlfour").value==""){
			alert("请录入收购物品重量！");
			document.getElementById("zlone").focus();
			return false;
		}
		return true;
	}

	  function selectCapturePhoto(frm,displayName,hiddenName) {
	       window.showModalDialog('${ctx}/pages/fjy/FileAttach/selectCapturePhoto.do?formName=' + frm.name + '&inputName='+displayName+'&hiddenName='+hiddenName+'',frm,'dialogHeight:300px;dialogWidth:650px;center:yes');
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
				document.all.csrxb.value = '1';
			else
				document.all.csrxb.value = '2';

			document.all.prov.value = provId+"0000";
			sfzhSetxzqh(provId,xzqhs);
			
		}
		if (18 == val.length) {//18位身份证号码   
			birthdayValue = val.charAt(6) + val.charAt(7) + val.charAt(8)
					+ val.charAt(9) + '-' + val.charAt(10) + val.charAt(11)
					+ '-' + val.charAt(12) + val.charAt(13);
			xzqhs = 	val.substr(0,6);
			provId = 	val.substr(0,2);			
			if (parseInt(val.charAt(16) / 2) * 2 != val.charAt(16))
				document.all.csrxb.value = '1';
			else
				document.all.csrxb.value = '2';

			document.all.prov.value = provId+"0000";
			sfzhSetxzqh(provId,xzqhs);
			
			
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
 


document.getElementById("csrxb").style.width="150px";


   function sfzhSetxzqh(provinceId,xzqhValue)
	{
	    DWRUtil.setValue('npcodehidden',xzqhValue);
		menu.queryXzqhById(provinceId,cityCallback);
	}


function selectCsrxx(){
	  	 var left = "50", top = "50";
	     if(arguments[3] != null) left = "dialogLeft:" + arguments[3] + "px;"
	     if(arguments[4] != null) top = "dialogTop:" + arguments[4] + "px;"
	     window.showModalDialog('${ctx}/pages/fjy/Tcsrxx/listSelect.do?search_random='+Math.random(),
									window,
									"dialogWidth:700px;" + "dialogHeight:550px;" 
									+ left + top 
									+ "directories:yes;help:no;status:no;resizable:no;scrollbars:yes;");
		
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
	   DWRUtil.removeAllOptions("npcode");
        try{
           // DWRUtil.addOptions("xzqh",{'':'请选择...'});  
            DWRUtil.addOptions("npcode",citys,"id","cityName");//将option对象添加到第三个下拉框中
           if($F("npcodehidden") ==""){ 
          	  DWRUtil.setValue('npcode',<%=npcode%> ); 
           }else{
          	  DWRUtil.setValue('npcode',$F("npcodehidden")); 
           }
        }catch(e){
        }
     
	}


queryCity();
<!--getCyry();-->

 
if('${mgs}'!=""){
var xz="no";
Ext.MessageBox.buttonText.yes = "是";  
Ext.MessageBox.buttonText.no = "否<span id='tiao'>(10)</span>";  
	Ext.MessageBox.confirm("提示","是否继续收购此出售人废旧物品？",function(btn){
            if(btn=="yes"){
	            yes();
	            xz="yes";
			}
            else{
	          	no();
	        }
	}); 
	countDown(10);
}


 function countDown(secs){
         document.getElementById("tiao").innerText="("+secs+")";
         	if(xz=="yes")return;
            if(--secs>=0){
             setTimeout("countDown("+secs+")",1000);
            }else{
             Ext.MessageBox.hide();
             no();
       }
}


//性别读取
   function sexSelectItemByValue(objItemText) {            
	     var objSelect = document.getElementById("csrxb");    
	     var isExit = false;        
	     for (var i = 0; i < objSelect.options.length; i++) {        
	         if (objSelect.options[i].text == objItemText) {        
	             objSelect.options[i].selected = true;        
	             isExit = true;        
	             break;        
	         }        
	     }              
    }
   
function yes(){
	document.getElementById("zlone").value="";
	document.getElementById("zltwo").value="";
	document.getElementById("zlthree").value="";
	document.getElementById("zlfour").value="";
}
function no(){
 var shougoury = document.getElementById("shougoury").value;
 var username = document.getElementById("username").value;
	resitData(document.forms[0]);
//	getCyry();
  document.getElementById("shougoury").value = shougoury ;
  document.getElementById("username").value = username;
}
function getCyry(){
	var url="${ctx}/pages/fjy/Temployee/selectList.do?ajax=true";
	j$.post(url, function(data) {
		j$("#shougoury").html(data);
	});
}
</script>

</body>
</html>