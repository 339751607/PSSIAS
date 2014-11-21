<%@ page contentType="text/html;charset=UTF-8" %>
<%@ page import="com.dyneinfo.fjy.model.*" %>
<%@ page import="java.io.*"%>
<%@ page import="java.sql.Blob,java.util.*"%>
<%@ include file="/commons/taglibs.jsp" %>
<%@ page import="net.java.dev.common.dict.taglib.DictHelpImpl"%>
<%@ taglib prefix="authz" uri="http://www.springframework.org/security/tags" %>
<%
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ request.getContextPath() + "/";
String IDCardType = (String)DictHelpImpl.getInitData("IDCardType");
%>
<html>

<head>
	<%@ include file="/commons/meta.jsp" %>
	<base href="<%=basePath%>">
	 <script language="javascript">     
             var j$ = jQuery.noConflict();     
         </script> 
		<script type='text/javascript' src='${ctx}/dwr/interface/menu.js'></script>
	<script type='text/javascript' src='${ctx}/dwr/engine.js'></script>
	<script type='text/javascript' src='${ctx}/dwr/util.js'></script>	
	<title><%=Tfeijiuwupin.TABLE_ALIAS%>编辑</title>
</head>

<body onload="quickSelectInit()" >
<%@ include file="/commons/messages.jsp" %>

<s:form action="/pages/fjy/Tfeijiuwupin/update.do" enctype="multipart/form-data"  name="editForm"  theme="simple"  method="post">
	<table cellpadding="0" cellspacing="0" border="1" class="tb_all">
	   	<s:hidden id="wupinxh" name="wupinxh" />
	    <input type="hidden" name="returnUrl" value="!/pages/fjy/Tfeijiuwupin/list.do?<mytag:params includes="ec*,s*" type="queryStringUtf"/>" />
	       <tr>
				<td colspan="5" class="tb_title"> 
							<%=Tfeijiuwupin.TABLE_ALIAS%>
			    </td>
		   </tr>
	         <tr class="crosscolor_tr">
                         <td class="crosscolor_td">
			                      <FONT color="red">*</FONT><%=Tfeijiuwupin.ALIAS_WUPINMC%>
		                  </td>
			              <td>
		                           <s:textfield label="%{@vs@ALIAS_WUPINMC}"  key="wupinmc" value="%{model.wupinmc}"  cssClass="required max-length-100" required="true" />
		                  </td> 
		                  
                          <td class="crosscolor_td">
			                      <FONT color="red">*</FONT><%=Tfeijiuwupin.ALIAS_WUPINLB%>
		                  </td>
			              <td >
						           <mytag:select property="%{model.wupinlb}"   styleClass="required validate-selection"  name="wupinlb"   notEmpty="false"  dictName="T_DIC_WUPINLB"/>
		                  </td>
		                  <td width="119" rowspan="16">
			             <%if(IDCardType != null && IDCardType.equals("0")) { %> 
						  <IFRAME height="100%" width="340" name="result"   src="${ctx}/pages/fjy/Temployee/IDcard_fjwp.htm"
							align="center" frameBorder="0" marginHeight="0" marginWidth="0"></IFRAME>
							 <% } else if(IDCardType != null && IDCardType.equals("1")) { %>	
							<IFRAME height="100%" width="220" name="result"   src="${ctx}/pages/fjy/Temployee/CVR_IDCard_fjwp.html"
							align="center" frameBorder="0" marginHeight="0" marginWidth="0"></IFRAME>
						  <% } %>	
					       </td>
                   </tr>
		           <tr class="crosscolor_tr">

                          <td class="crosscolor_td">
			                    <FONT color="red">*</FONT> 收购人员
		                  </td>
			              <td >
			               		<select  name="shougoury" id="shougoury" Class="max-length-24">
									
								</select>
		                            <!--<input type="text" class="required"   name="shougouryXm" maxlength="0" value="<authz:authentication property="principal.userXm"/>"  class="max-length-30"/>
		                            <input type="hidden"  name="shougoury" value="<authz:authentication property="principal.username"/>" />
		                        
		                              <input name="selectPersonButton" onclick="selectPerson(inputForm,'shougouryXm','shougoury')"   value="选择" type="button"> -->
		                  </td>
		                  <td class="crosscolor_td">
			                       <FONT color="red">*</FONT><%=Tfeijiuwupin.ALIAS_WPZL%>
		                  </td>
			              <td>
	                               <s:textfield label="%{@vs@ALIAS_WPZL}" key="wpzl" value="%{model.wpzl}"  cssClass="required  max-length-8 validate-integer" required="false" />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                    <FONT color="red">*</FONT>  <%=Tfeijiuwupin.ALIAS_CHUSHOURY%>
		                  </td>
			              <td>
	                               <s:textfield label="%{@vs@ALIAS_CHUSHOURY}" key="csrxm" value="%{model.csrxm}"  cssClass="required max-length-30 validate-chinese" required="false" />
		                           <input type="hidden"  name="nouse" value="forma" />
		                           <input name="selectCsrxxbutton" onclick="javascript:selectCsrxx()"   value="选择"  type="button"> 
		                  </td>
                          <td class="crosscolor_td">
			                   <FONT color="red">*</FONT>   <%=Tfeijiuwupin.ALIAS_CHUSHOURENXB%>
		                  </td>
			              <td>
						           <mytag:select property="%{model.chushourenxb}"   styleClass="required validate-selection"  name="chushourenxb"   notEmpty="false"  dictName="T_DIC_SEX"/>
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                   <FONT color="red">*</FONT>   <%=Tfeijiuwupin.ALIAS_CHUSHOURENSFZH%>
		                  </td>
			              <td>
	                               <s:textfield label="%{@vs@ALIAS_CHUSHOURENSFZH}" key="chushourensfzh" onblur="javascript:showBirthday();"  value="%{model.chushourensfzh}"  cssClass="required max-length-18 validate-id-number" required="false" />
		                  </td>
	 					<td class="crosscolor_td">
<!--			                     <%=Tfeijiuwupin.ALIAS_CHUSHOURENLXDH%>-->
		                  </td>

			              <td >
<!--	                               <s:textfield label="%{@vs@ALIAS_CHUSHOURENLXDH}" key="chushourenlxdh" value="%{model.chushourenlxdh}"  cssClass="max-length-30 validate-number" required="false" />-->
		                  </td>
                   </tr>
                     <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                       <FONT color="red">*</FONT><%=Tcsrxx.ALIAS_NPCODE%>
		                  </td>
			               <td colspan="3">
			                <s:select name="prov" id="prov"   cssClass="required validate-selection" value=""  onchange="changeprov();" list="provMap" listKey="key" headerValue="请选择..." headerKey=""  listValue="value" theme="simple" label="省市"  emptyOption="false" ></s:select>
							<select id="npcode" name="npcode" ></select>
		             </td>
		          </tr> 
		           <tr class="crosscolor_tr">     
                          <td class="crosscolor_td">
			                     <FONT color="red">*</FONT> <%=Tcsrxx.ALIAS_NPADDRESS%>
		                  </td>
			              <td colspan="3">
		                           <s:textfield label="%{@vs@ALIAS_NPADDRESS}"  size="60" key="npaddress" value="%{model.npaddress}"  cssClass="required max-length-100" required="false" />
		                  </td>
                   </tr>
                 <tr class="crosscolor_tr">     
                          <td class="crosscolor_td">
			                     &nbsp;&nbsp;&nbsp;户籍地
		                  </td>
			              <td colspan="3">
		                           <s:textfield label="%{@vs@ALIAS_PRADDRESS}"  size="60" key="hjaddress" value="%{model.hjaddress}"  cssClass="max-length-100" required="false" />
		                  </td>
                   </tr>
<!--		           <tr class="crosscolor_tr">     -->
<!--                          <td class="crosscolor_td">-->
<!--			                     &nbsp;&nbsp;&nbsp;<%=Tcsrxx.ALIAS_PRADDRESS%>-->
<!--		                  </td>-->
<!--			              <td colspan="3">-->
<!--		                           <s:textfield label="%{@vs@ALIAS_PRADDRESS}"  size="60" key="praddress" value="%{model.praddress}"  cssClass="max-length-100" required="false" />-->
<!--		                  </td>-->
<!--                   </tr>-->

				<tr>
               		<td><input onclick="disp_something('feibt');return false" type="button" class="buttom" value="显示" id="xsbutton"/>
               		</td>
               	</tr>

                <tbody  id='feibt'   style="display:none;">

                   <tr class="crosscolor_tr">


		                   <td class="crosscolor_td">
			                   收购时间
		                  </td>
			               <td colspan="3">
						           <input value="${model.shougourq}" onclick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss'})" id="shougourq" name="shougourq"  maxlength="0" class=" Wdate" />
		                  </td>
		             </tr>    
	
                   
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=Tfeijiuwupin.ALIAS_JBR%>
		                  </td>
			              <td>
	                               <s:textfield label="%{@vs@ALIAS_JBR}" key="jbr" value="%{model.jbr}"  cssClass="max-length-30 validate-chinese" required="false" />
		                  </td>
                  
                          <td class="crosscolor_td">
			                      <%=Tfeijiuwupin.ALIAS_JBRSFZH%>
		                  </td>
			              <td>
	                               <s:textfield label="%{@vs@ALIAS_JBRSFZH}" key="jbrsfzh" value="%{model.jbrsfzh}"  cssClass="max-length-18 validate-id-number" required="false" />
		                  </td>
		            </tr>
		            
		           <tr class="crosscolor_tr">       
                          <td class="crosscolor_td">
			                      <%=Tfeijiuwupin.ALIAS_JBRLXDH%>
		                  </td>
			              <td>
	                               <s:textfield label="%{@vs@ALIAS_JBRLXDH}" key="jbrlxdh" value="%{model.jbrlxdh}"  cssClass="max-length-50 validate-number" required="false" />
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
			                      <%=Tfeijiuwupin.ALIAS_SGRLXDH%>
		                  </td>
			              <td>
	                               <s:textfield label="%{@vs@ALIAS_SGRLXDH}" key="sgrlxdh" value="%{model.sgrlxdh}"  cssClass="max-length-50 validate-number" required="false" />
		                  </td>
                 
                          <td class="crosscolor_td">
			                      <%=Tfeijiuwupin.ALIAS_WPYS%>
		                  </td>
			              <td>
						           <mytag:select property="%{model.wpys}"     name="wpys"   notEmpty="false"  dictName="T_DIC_SJYS"/>
		                  </td>
		             </tr>
		             
		           <tr class="crosscolor_tr">       
                          <td class="crosscolor_td">
			                      <%=Tfeijiuwupin.ALIAS_WPPP%>
		                  </td>
			              <td>
		                           <s:textfield label="%{@vs@ALIAS_WPPP}" key="wppp" value="%{model.wppp}"  cssClass="max-length-50" required="false" />
		                  </td>
		                   <td class="crosscolor_td">
			                      <%=Tfeijiuwupin.ALIAS_WPCD%>
		                  </td>
			              <td>
		                           <s:textfield label="%{@vs@ALIAS_WPCD}" key="wpcd" value="%{model.wpcd}"  cssClass="max-length-100" required="false" />
		                  </td>
                   </tr>
                   
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=Tfeijiuwupin.ALIAS_WPXZ%>
		                  </td>
			              <td>
		                           <s:textfield label="%{@vs@ALIAS_WPXZ}" key="wpxz" value="%{model.wpxz}"  cssClass="max-length-10" required="false" />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=Tfeijiuwupin.ALIAS_WPSF%>
		                  </td>
			              <td>
		                           <s:textfield label="%{@vs@ALIAS_WPSF}" key="wpsf" value="%{model.wpsf}"  cssClass="max-length-50" required="false" />
		                  </td>
                   </tr>
		         
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=Tfeijiuwupin.ALIAS_WPBZ%>
		                  </td>
			              <td>
		                           <s:textfield label="%{@vs@ALIAS_WPBZ}" key="wpbz" value="%{model.wpbz}"  cssClass="max-length-30" required="false" />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=Tfeijiuwupin.ALIAS_WPTZ%>
		                  </td>
			              <td>
		                           <s:textfield label="%{@vs@ALIAS_WPTZ}" key="wptz" value="%{model.wptz}"  cssClass="max-length-50" required="false" />
		                  </td>
                   </tr>


				

</tbody>
				<tr >
					 <td colspan="4" class="tb_bottom">
	                        <input id="submitButton" name="submitButton" type="submit" value="保存" />
	                        <input type="button" value="返回" onclick="window.location='${ctx}/pages/fjy/Tfeijiuwupin/list.do?<mytag:params includes="ec*,s*" type="queryStringUtf"/>'"/>   
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
	
    function selectPerson(frm,displayName,hiddenName) {
	           window.showModalDialog('${ctx}/pages/fjy/SsDept/selectPerson.do?deptTypeId=0,<authz:authentication property="principal.deptTypeID"/>&formName=' + frm.name + '&inputName='+displayName+'&hiddenName='+hiddenName+'&rootID=false&maxPatiNum=1&hiddenType=ID_SPLIT',frm,'dialogHeight:500px;dialogWidth:560px;center:yes');
       }
       
       
    function editPict(FILEID){
    	var url="";
    	url ="${ctx}/pages/fjy/Tfeijiuwupin/editPictUpload.jsp?FILEID="+FILEID;
    	newwin = window.open(url,
						"picUpdate",
						"width=400,height=150,top=100,left=100,resizable=yes,status=yes,menubar=no,scrollbars=yes"); 
    } 
    
    function editFile(FILEID){
    	var url="";
    	url ="${ctx}/pages/fjy/Tfeijiuwupin/editFileUpload.jsp?FILEID="+FILEID;
    	newwin = window.open(url,
						"fileUpdate",
						"width=400,height=150,top=100,left=100,resizable=yes,status=yes,menubar=no,scrollbars=yes"); 
    } 
 
       
    function deletePict(FILEID){
          if (confirm('确定执行[删除]操作?')){ 
              var form = document.forms.update;
              var input_txt = document.createElement("input");
			  input_txt.type = "hidden";
			  input_txt.name = "deleteReturnUrl";
			  input_txt.value = "!/pages/fjy/Tfeijiuwupin/edit.do?wupinxh=<s:property value="%{model.wupinxh}" />&<mytag:params includes="ec*,s*" type="queryStringUtf"/>";
			  form.appendChild(input_txt);
		      form.action = '${ctx}/pages/fjy/Tfeijiuwupin/deletePict.do?FILEID='+FILEID;
	          form.submit(); 
	      }
    }
    
    function deleteFile(FILEID){
           if (confirm('确定执行[删除]操作?')){ 
              var form = document.forms.update;
              var input_txt = document.createElement("input");
			  input_txt.type = "hidden";
			  input_txt.name = "deleteReturnUrl";
			  input_txt.value = "!/pages/fjy/Tfeijiuwupin/edit.do?wupinxh=<s:property value="%{model.wupinxh}" />&<mytag:params includes="ec*,s*" type="queryStringUtf"/>";
			  form.appendChild(input_txt);
		      form.action = '${ctx}/pages/fjy/Tfeijiuwupin/deleteFile.do?FILEID='+FILEID;
	          form.submit();      
	       } 
    }
    		
    function view(FILEID){
    	var url="";
    	url ="${ctx}/pages/fjy/FileAttach/pictShow.do?FILEID="+FILEID;
    	newwin = window.open(url,
						"popupnav",
						"resizable=yes,status=yes,menubar=no,scrollbars=yes");
    }

    function download(FILEID){
		olddoc = document;
    	var url="";
    	url =  "${ctx}/filedownload/downloadDB.do?FILEID="+FILEID;
    	location.href = url;
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

document.getElementById("wupinlb").style.width="150px";
document.getElementById("iskeyi").style.width="150px";
document.getElementById("chushourenxb").style.width="150px";
document.getElementById("wpys").style.width="150px";
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
           
            DWRUtil.setValue('npcode',$F("npcodehidden")); 
        }catch(e){
        }
     
	}


	queryCity();
	
	
	
function   disp_something(str)
  {
	obj=document.getElementById(str);
	var xsbutton=document.getElementById("xsbutton");

	if(obj)
	{
		if(obj.style.display=="")
	{
		obj.style.display="none";

		xsbutton.value="显示";
	}
	else if(obj.style.display=="none")
	{
		obj.style.display="";

		xsbutton.value="隐藏";
		
	}
	}
}
getCyry();
function getCyry(){
	var url="${ctx}/pages/fjy/Temployee/selectList.do?ajax=true";
	j$.post(url, function(data) {
		j$("#shougoury").append(data);
	});
}
</script>

</body>

</html>