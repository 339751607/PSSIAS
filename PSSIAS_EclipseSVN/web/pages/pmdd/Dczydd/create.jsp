<%@page import="com.dyneinfo.pmdd.model.*" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/commons/taglibs.jsp" %>
<%
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+request.getContextPath()+"/";
//String smycode = request.getParameter("smycode");
//String typecode = request.getParameter("typecode");
%>
<html>
<head>
	<%@ include file="/commons/meta.jsp" %>
	<base href="<%=basePath%>">
	<title><%=Dczydd.TABLE_ALIAS%>新增</title>
</head>
<body onload="quickSelectInit()" >
<%@ include file="/commons/messages.jsp" %>

<s:form action="/pages/pmdd/Dczydd/save.do" theme="simple"  name="inputForm" enctype="multipart/form-data"  method="post">
	<table cellpadding="0" cellspacing="0" border="0" class="tb_all">
	    <input type="hidden" name="returnUrl" value="!/pages/pmdd/Dczydd/list.do?<mytag:params includes="ec*,s*" type="queryStringUtf"/>" />
	    <input value="" type="hidden"  name="photoBuffer"  />
	       <tr>
				<td colspan="5" class="tb_title"> 
							<%=Dczydd.TABLE_ALIAS%>新增
			    </td>
		   </tr>
	       <s:hidden id="dnumber" name="dnumber" />

		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <FONT color="red">*</FONT><%=Dczydd.ALIAS_HTID%>
		                  </td>
			              <td>
		                           <s:textfield label="%{@vs@ALIAS_HTID}" key="htid" value="%{model.htid}" cssClass="required max-length-50" required="false" />
		                  </td>
                          <td class="crosscolor_td">
			                     <FONT color="red">*</FONT> <%=Dczydd.ALIAS_SQR%>
		                  </td>
			              <td>
		                           <s:textfield label="%{@vs@ALIAS_SQR}" key="sqr" value="%{model.sqr}" cssClass="required max-length-30" required="false" />
		                  </td>
		                  <td  rowspan="16">  
		                   <c:if test="${typecode == 1 && smycode != 1}">                
						  	<IFRAME height="100%" width="100%" name="result" src="${ctx}/pages/Dczydd/CVR_IDCard_typecode.html"
							align="center" frameBorder="0" marginHeight="0" marginWidth="0"></IFRAME>
							  </c:if>
		                      <c:if test="${smycode == 1 && typecode != 1}">                
						  	<IFRAME height="100%" width="100%" name="result" src="${ctx}/pages/Dczydd/CVR_IDCard_smycode.html"
							align="center" frameBorder="0" marginHeight="0" marginWidth="0"></IFRAME>
							  </c:if>
							    <c:if test="${smycode == 1 && typecode == 1}">                
						  	<IFRAME height="100%" width="100%" name="result" src="${ctx}/pages/Dczydd/CVR_IDCard.html"
							align="center" frameBorder="0" marginHeight="0" marginWidth="0"></IFRAME>
							  </c:if>
							  
						</td>
                   </tr>
		           <tr class="crosscolor_tr">
		           
		                  <td class="crosscolor_td">
			                       <FONT color="red">*</FONT><%=Dczydd.ALIAS_YXZJ%>
		                  </td>
			              <td>
			              
			               <mytag:select property="%{model.yxzj}"   styleClass="required validate-selection"  name="yxzj"   notEmpty="false"  dictName="T_ID_NAME"/>
		                         
		                  </td>
                          <td class="crosscolor_td">
			                     <FONT color="red">*</FONT> <%=Dczydd.ALIAS_ZJHM%>
		                  </td>
			              <td>
		                           <s:textfield label="%{@vs@ALIAS_ZJHM}" key="zjhm" value="%{model.zjhm}" cssClass="required max-length-30 " required="false" />
		                  </td>
		                  
                         
                   </tr>
                   <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=Dczydd.ALIAS_DZ%>
		                  </td>
			              <td colspan="3">
		                           <s:textfield label="%{@vs@ALIAS_DZ}" key="dz" size="80" value="%{model.dz}" cssClass="max-length-120" required="false" />
		                  </td>
                          
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=Dczydd.ALIAS_GZDW%>
		                  </td>
			              <td >
		                           <s:textfield label="%{@vs@ALIAS_GZDW}" key="gzdw"  value="%{model.gzdw}" cssClass="max-length-60" required="false" />
		                  </td>
		                  <td class="crosscolor_td">
			                      <FONT color="red">*</FONT> <%=Dczydd.ALIAS_LXDH%>
		                  </td>
			              <td>
		                           <s:textfield label="%{@vs@ALIAS_LXDH}" key="lxdh" value="%{model.lxdh}" cssClass="required max-length-20 validate-number" required="false" />
		                  </td>
                          
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                     <FONT color="red">*</FONT> <%=Dczydd.ALIAS_DWMC%>
		                  </td>
			              <td>
		                           <s:textfield label="%{@vs@ALIAS_DWMC}" key="dwmc" value="%{model.dwmc}" cssClass="required max-length-50" required="false" />
		                  </td>
                          <td class="crosscolor_td">
			                  <FONT color="red">*</FONT>  <%=Dczydd.ALIAS_DDLX%>
		                  </td>
			              <td>
						           <mytag:select property="%{model.ddlx}"   styleClass="required validate-selection"  name="ddlx"   notEmpty="false"  dictName="ddlb"/>
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=Dczydd.ALIAS_DWZJ%>
		                  </td>
			              <td>
		                           <s:textfield label="%{@vs@ALIAS_DWZJ}" key="dwzj" value="%{model.dwzj}" cssClass="max-length-30" required="false" />
		                  </td>
                          <td class="crosscolor_td">
			                     <FONT color="red">*</FONT>   <%=Dczydd.ALIAS_FLAG%>
		                  </td>
			              <td>
						           <mytag:select property="%{model.flag}"    styleClass="required validate-selection"  name="flag"   notEmpty="false"  dictName="dczylb"/>
		                  </td>
                   </tr>
                       <tr class="crosscolor_tr">
                         
                          <td class="crosscolor_td">
			                      <%=Dczydd.ALIAS_WPPP%>
		                  </td>
			              <td>
		                           <s:textfield label="%{@vs@ALIAS_WPPP}" key="wppp" value="%{model.wppp}"  cssClass="max-length-30" required="false" />
		                  </td>
		                   <td class="crosscolor_td">
			                      <%=Dczydd.ALIAS_WPGG%>
		                  </td>
			              <td>
		                           <s:textfield label="%{@vs@ALIAS_WPGG}" key="wpgg" value="%{model.wpgg}"  cssClass="max-length-30" required="false" />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                         
                          <td class="crosscolor_td">
			                      <%=Dczydd.ALIAS_WPZL%>
		                  </td>
			              <td>
		                           <s:textfield label="%{@vs@ALIAS_WPZL}" key="wpzl" value="%{model.wpzl}"  cssClass="max-length-30" required="false" />
		                  </td>
		                   <td class="crosscolor_td">
			                      <%=Dczydd.ALIAS_WPXZ%>
		                  </td>
			              <td>
		                           <s:textfield label="%{@vs@ALIAS_WPXZ}" key="wpxz" value="%{model.wpxz}"  cssClass="max-length-30" required="false" />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                         
                          <td class="crosscolor_td">
			                      <%=Dczydd.ALIAS_WPLYQKSM%>
		                  </td>
			              <td>
		                           <s:textfield label="%{@vs@ALIAS_WPLYQKSM}" key="wplyqksm" value="%{model.wplyqksm}"  cssClass="max-length-300" required="false" />
		                  </td>
		                
                          <td class="crosscolor_td">
			                      <%=Dczydd.ALIAS_WPCQZMCL%>
		                  </td>
			              <td>
		                           <s:textfield label="%{@vs@ALIAS_WPCQZMCL}" key="wpcqzmcl" value="%{model.wpcqzmcl}"  cssClass="max-length-300" required="false" />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=Dczydd.ALIAS_DDQX%>(天)
		                  </td>
			              <td>
		                           <s:textfield label="%{@vs@ALIAS_DDQX}" key="ddqx" value="%{model.ddqx}" cssClass="max-length-8 validate-integer" required="false" />
		                  </td>
		                   <td class="crosscolor_td">
			                      <%=Dczydd.ALIAS_DDRQ%>
		                  </td>
			              <td>
						           <input value="${model.ddrq}" onclick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss'})" id="ddrq" name="ddrq"  maxlength="0" class="required Wdate" />
		                  </td>
                         
                   </tr>
                   
                    <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=Dczydd.ALIAS_DWMS%>
		                  </td>
			              <td colspan="3">
		                           <s:textfield label="%{@vs@ALIAS_DWMS}" size="80" key="dwms" value="%{model.dwms}" cssClass="max-length-255" required="false" />
		                  </td>
                   </tr>
                    <tr class="crosscolor_tr">
                            <td class="crosscolor_td">
			                      <%=Dczydd.ALIAS_REMARK%>
		                  </td>
			              <td colspan="3">
			              
			              <s:textarea label="%{@vs@ALIAS_REMARK}" rows="3" cols="62"
							key="remark" value="%{model.remark}" cssClass="max-length-120"
							required="false"></s:textarea>
							
		                          
		                  </td>
                   </tr>
		          
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=Dczydd.ALIAS_LRRQ%>
		                  </td>
			              <td>
						           <s:property value="%{model.lrrq}" />
		                  </td>
                          <td class="crosscolor_td">
			                     <FONT color="red">*</FONT> <%=Dczydd.ALIAS_SDR%>
		                  </td>
			              <td>
		                           <s:textfield label="%{@vs@ALIAS_SDR}" key="sdr" value="%{model.sdr}" cssClass="required max-length-30" required="false" />
		                            <input name="selectOrg" onclick="selectCyry(inputForm,'sdr','sdrid')"   value="选择"type="button"> 
		                            <input value="" type="hidden"  name="sdrid"  />  
		                  </td>
                   </tr>
                
		           
               
				   <tr class="crosscolor_tr">
					<td>
						申请人二代证照片
					</td>
					<td colspan="3">
						<s:file name="upload" style="WIDTH:300px;cursor:hand"  UNSELECTABLE="on"  id="upload"
							cssClass=" validate-file-png-jpg-gif-bmp" label="图片"></s:file>
					</td>
				   </tr>
				   <tr class="crosscolor_tr">
					<td>
						<FONT color="red">*</FONT>申请人扫描照片
					</td>
					<td colspan="3">
						<s:file name="pic" style="WIDTH:300px;cursor:hand"  UNSELECTABLE="on"  id="pic"
							cssClass=" validate-file-png-jpg-gif-bmp" label="图片"></s:file>
							
							<input name="selectOrg" onclick="selectCapturePhoto(inputForm,'pic','picfileid')"   value="摄像头"type="button"> 
		                            <input value="" type="hidden"  name="picfileid"  />
		                            <input value="" type="hidden"  name="picfilename"  />
					</td>
				   </tr>
				   <tr class="crosscolor_tr">
					<td>
						 <FONT color="red">*</FONT> 当物照片
					</td>
					<td colspan="3">
						<s:file name="affix" style="WIDTH:300px;cursor:hand"  UNSELECTABLE="on"  id="affix"
							cssClass=" validate-file-png-jpg-gif-bmp" label="图片"></s:file>
							
							<input name="selectOrg" onclick="selectCapturePhoto(inputForm,'affix','affixfileid')"   value="摄像头"type="button"> 
		                            <input value="" type="hidden"  name="affixfileid"  />
		                            <input value="" type="hidden"  name="affixfilename"  />
					</td>
				   </tr>
		          
	       <tr >
				<td colspan="5" class="tb_bottom">
							<input id="submitButton" name="submitButton" type="submit" value="提交" />
	                        <input type="button" value="返回" onclick="window.location='${ctx}/pages/pmdd/Dczydd/list.do?<mytag:params includes="ec*,s*" type="queryStringUtf"/>'"/>
			    </td>
	        </tr>
	</table>
</s:form>

<script>
	
	new Validation(document.forms[0],{onSubmit:true,onFormValidate : function(result,form) {
		var finalResult = result;
		
		//在这里添加自定义验证
		     if(finalResult) {
			     if( ($F("yxzj")=="11" || $F("yxzj")=="12") && $F("zjhm").length > 0  ) {
			          if(!f_check_IDno($F("zjhm"))){
			             alert("身份证号错误！\r\n请重新确认身份证号，X请输入大写");	
			             finalResult = false;
			             }
			      }
		      }
		//      if(finalResult) {
		  //    	if( ($F("yxzj")=="11" || $F("yxzj")=="12"))   {
			//	   if($F("upload") == "" && $F("photoBuffer") == ""  ){
				//           alert("申请人二代证照片为空\r\n请选择照片信息!");
		          //         finalResult = false;
				 	//}
				 //}
		      //}
		      if(finalResult) {   
				   if($F("pic") == "" && $F("picfileid") == ""  ){
				           alert("申请人扫描照片为空\r\n请选择照片信息!");
		                   finalResult = false;
				 }
		      }
		      if(finalResult) {   
				   if($F("affix") == "" && $F("affixfileid") == ""  ){
				           alert("当物照片为空\r\n请选择照片信息!");
		                   finalResult = false;
				 }
		      }
		
		return disableSubmit(finalResult,'submitButton');
	}});
	
	
	  function selectDept(frm,displayName,hiddenName) {
	           window.showModalDialog('${ctx}/pages/SsDept/selectDept.do?formName=' + frm.name + '&inputName='+displayName+'&hiddenName='+hiddenName+'&rootID=false&maxPatiNum=3&hiddenType=ID_SPLIT',frm,'dialogHeight:500px;dialogWidth:560px;center:yes');
       }
       
      function selectCapturePhoto(frm,displayName,hiddenName) {
	           window.showModalDialog('${ctx}/pages/FileAttach/selectCapturePhoto.do?formName=' + frm.name + '&inputName='+displayName+'&hiddenName='+hiddenName+'',frm,'dialogHeight:300px;dialogWidth:650px;center:yes');
       }
	  function selectCyry(frm,displayName,hiddenName) {
	           window.showModalDialog('${ctx}/pages/SsDept/selectCyry.do?formName=' + frm.name + '&inputName='+displayName+'&hiddenName='+hiddenName+'&rootID=false&maxPatiNum=1&hiddenType=ID_SPLIT',frm,'dialogHeight:500px;dialogWidth:560px;center:yes');
       }
      function selectDeptCheckbox(frm,displayName,hiddenName) {
	           window.showModalDialog('${ctx}/pages/SsDept/selectDeptCheckbox.do?formName=' + frm.name + '&inputName='+displayName+'&hiddenName='+hiddenName+'&rootID=false&maxPatiNum=3&hiddenType=ID_SPLIT',frm,'dialogHeight:500px;dialogWidth:450px;center:yes');
      }
      
      //提取身份信息
	function showBirthday() {
	 if(($F("yxzj")=="11" ||  $F("yxzj")=="94" ||  $F("yxzj")=="12") &&  $F("zjhm").length > 0 ) {
		var birthdayValue,val;
		val = document.all.zjhm.value;
		
		
		  
		if (15 == val.length) {//15位身份证号码   
			birthdayValue = val.charAt(6) + val.charAt(7);
			if (parseInt(birthdayValue) < 10) {
				birthdayValue = '20' + birthdayValue;
				document.all.zjhm.value =  chg_sfzh(document.all.zjhm.value,20);
			} else {
				birthdayValue = '19' + birthdayValue;
				document.all.zjhm.value =  chg_sfzh(document.all.zjhm.value,19);
			}
			
			
			
		}
		if (18 == val.length) {//18位身份证号码   
			if (val.charAt(17) != IDCard(val)) {
				document.all.zjhm.style.backgroundColor = '#ffc8c8';
				document.all.zjhm.value= val.toUpperCase();
			} else {
				document.all.zjhm.style.backgroundColor = 'white';
			}
			
			
			
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
</script>

</body>
</html>