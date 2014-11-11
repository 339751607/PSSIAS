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
	<title><%=Clzydd.TABLE_ALIAS%>编辑</title>
</head>

<body onload="quickSelectInit()" >
<%@ include file="/commons/messages.jsp" %>

<s:form action="/pages/pmdd/Clzydd/update.do"  theme="simple" name="inputForm" enctype="multipart/form-data"  method="post">
	<table cellpadding="0" cellspacing="0" border="0" class="tb_all">
	    <input type="hidden" name="returnUrl" value="!/pages/pmdd/Clzydd/list.do?<mytag:params includes="ec*,s*" type="queryStringUtf"/>" />
	        <tr>
				      <td colspan="6" class="tb_title"> 
							<%=Clzydd.TABLE_ALIAS%>编辑
				     </td>
		    </tr>
	         <s:hidden id="dnumber" name="dnumber" />
<s:hidden name="lrrq" value="%{model.lrrq}"></s:hidden>
<s:hidden name="optime" value="%{model.optime}"></s:hidden>
<s:hidden name="htid" value="%{model.htid}"></s:hidden>
		           <tr class="crosscolor_tr">
                          <td width="13%" class="crosscolor_td">
			                     <FONT color="red">*</FONT> <%=Clzydd.ALIAS_HTID%>
		                  </td>
			              <td width="22%">
		                          
		                   <s:property value="%{model.htid}" />
		                  </td>
                          <td width="13%" class="crosscolor_td">
			                     <FONT color="red">*</FONT> <%=Clzydd.ALIAS_SQR%>
		                  </td>
			              <td>
		                           <s:textfield label="%{@vs@ALIAS_SQR}" key="sqr" value="%{model.sqr}"  cssClass="required max-length-30 " required="false" />
		                  </td>
		                  <td  width="15%" align="center" >
		                           二代证照片 &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		                          <a onclick="javascript:editPic('<s:property value="%{model.dnumber}" />');return false;" href="#"> 修改 
		                          </a>
		                  </td>
		                   <td  width="15%" align="center" >
		                          扫描照片 &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		                          <a onclick="javascript:editSmPic('<s:property value="%{model.dnumber}" />');return false;" href="#"> 修改 
		                          </a>
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
			                     <FONT color="red">*</FONT> <%=Clzydd.ALIAS_ZJHM%>
		                  </td>
			              <td>
		                           <s:textfield label="%{@vs@ALIAS_ZJHM}" key="zjhm" value="%{model.zjhm}"  cssClass="required max-length-30 " required="false" />
		                  </td>
		                 
						  <td rowspan="6"  align="center">
								<table align="center">
									<tr>
										<td align="center">
											<a onclick="javascript:editPic('<s:property value="%{model.dnumber}" />');return false;" href="#"> 
								        <img src='${ctx}/images/spacer.gif'
										onerror="this.src='${ctx}/images/spacer.gif'" height="126"
										alt="" width="102" border="0" id="photo1" name="photo1"> 
								</a>
										</td>
									</tr>
								</table>
								
						  </td>
						  <td rowspan="6"  align="center">
								<table align="center">
									<tr>
										<td align="center">
											<a onclick="javascript:editSmPic('<s:property value="%{model.dnumber}" />');return false;" href="#"> 
								        <img src='${ctx}/images/spacer.gif'
										onerror="this.src='${ctx}/images/spacer.gif'" height="126"
										alt="" width="102" border="0" id="photo3" name="photo3"> 
								</a>
										</td>
									</tr>
								</table>
								
						  </td>

				</tr>
                    <tr class="crosscolor_tr">
                           <td class="crosscolor_td">
			                       <FONT color="red">*</FONT><%=Clzydd.ALIAS_LXDH%>
		                  </td>
			              <td>
		                           <s:textfield label="%{@vs@ALIAS_LXDH}" key="lxdh" value="%{model.lxdh}"  cssClass="required max-length-20 " required="false" />
		                  </td>
                         <td class="crosscolor_td">
			                      <%=Clzydd.ALIAS_GZDW%>
		                  </td>
			              <td >
		                           <s:textfield label="%{@vs@ALIAS_GZDW}"  key="gzdw" value="%{model.gzdw}"  cssClass="max-length-60 " required="false" />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          
                          <td class="crosscolor_td">
			                      <%=Clzydd.ALIAS_DZ%>
		                  </td>
			               <td colspan="3">
		                           <s:textfield label="%{@vs@ALIAS_DZ}" size="80" key="dz" value="%{model.dz}"  cssClass="max-length-120 " required="false" />
		                  </td>
                   </tr>
                    <tr class="crosscolor_tr">
                          
                          <td class="crosscolor_td">
			                      <%=Clzydd.ALIAS_XSZ_DZ%>
		                  </td>
			               <td colspan="3">
		                           <s:textfield label="%{@vs@ALIAS_XSZDZ}" size="80" key="xszdz" value="%{model.xszdz}"  cssClass="max-length-120 " required="false" />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                     <FONT color="red">*</FONT> <%=Clzydd.ALIAS_CPHM%>
		                  </td>
			              <td>
		                           <s:textfield label="%{@vs@ALIAS_CPHM}" key="cphm" value="%{model.cphm}"  cssClass="required max-length-15 " required="false" />
		                  </td>
                          <td class="crosscolor_td">
			                     <FONT color="red">*</FONT> <%=Clzydd.ALIAS_CZMC%>
		                  </td>
			              <td>
		                           <s:textfield label="%{@vs@ALIAS_CZMC}" key="czmc" value="%{model.czmc}"  cssClass="required max-length-60 " required="false" />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                    <FONT color="red">*</FONT>  <%=Clzydd.ALIAS_FDJH%>
		                  </td>
		                    <td >
		                           <s:textfield label="%{@vs@ALIAS_FDJH}" key="fdjh"
		                          
		      						title="只能输入 大写字母 、数字、中杠（-）、点（.）"
		      						onkeyup="value=value.replace(/[^ A-Z0-9.-]/g,'') " 
			  						onbeforepaste="clipboardData.setData('text',clipboardData.getData('text').replace(/[^ A-Z·]/g,''))" 
			  						onkeydown="if(event.keyCode==13)event.keyCode=9"
		      						value="%{model.fdjh}" cssClass="max-length-30" required="false">
		                            </s:textfield>
		                           
		                           
		                           <FONT color="red">*请输入大写字母</FONT>
		                  </td>
			              <%--<td>
		                           <s:textfield label="%{@vs@ALIAS_FDJH}" key="fdjh" value="%{model.fdjh}"  cssClass="required max-length-30 " required="false" />
		                  </td>
                          --%><td class="crosscolor_td">
			                     <FONT color="red">*</FONT> <%=Clzydd.ALIAS_SCCJ%>
		                  </td>
			              <td>
		                           <s:textfield label="%{@vs@ALIAS_SCCJ}" key="sccj" value="%{model.sccj}"  cssClass="required max-length-60 " required="false" />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                     <FONT color="red">*</FONT> <%=Clzydd.ALIAS_CJHM%>
		                  </td>
		                    <td >
		                           <s:textfield label="%{@vs@ALIAS_CJHM}" key="cjhm"
		                            
		      						title="只能输入 大写字母 、数字、中杠（-）、点（.）"
		      						onkeyup="value=value.replace(/[^ A-Z0-9.-]/g,'') " 
			  						onbeforepaste="clipboardData.setData('text',clipboardData.getData('text').replace(/[^ A-Z·]/g,''))" 
			  						onkeydown="if(event.keyCode==13)event.keyCode=9"
		      						value="%{model.cjhm}" cssClass="max-length-30" required="false">
		                            </s:textfield>
		                           
		                           
		                           <FONT color="red">*请输入大写字母</FONT>
		                  </td>
		                  
		                  <%--
			              <td>
		                           <s:textfield label="%{@vs@ALIAS_CJHM}" key="cjhm" value="%{model.cjhm}"  cssClass="required max-length-30 " required="false" />
		                  </td>
                          --%><td class="crosscolor_td">
			                      <%=Clzydd.ALIAS_CSYS%>
		                  </td>
			              <td>
		                            <mytag:select property="%{model.csys}"   styleClass="required validate-selection"  name="csys"   notEmpty="false"  dictName="clys"/>
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <FONT color="red">*</FONT>  <%=Clzydd.ALIAS_CLXH%>
		                  </td>
			              <td>
						           <mytag:select property="%{model.clxh}"   styleClass="required validate-selection"  name="clxh"   notEmpty="false"  dictName="clxh"/>
		                  </td>
                          <td class="crosscolor_td">
			                      <%=Clzydd.ALIAS_YXSGLS%>
		                  </td>
			              <td>
		                           <s:textfield label="%{@vs@ALIAS_YXSGLS}" key="yxsgls" value="%{model.yxsgls}"  cssClass="max-length-8 " required="false" />
		                  </td>
		                  <td align="center" colspan="2">
		                                                  当物照片 &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		                          <a onclick="javascript:editPicdw('<s:property value="%{model.dnumber}" />');return false;" href="#"> 修改</a>
		                  </td>
		           </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=Clzydd.ALIAS_FRDB%>
		                  </td>
			              <td>
		                           <s:textfield label="%{@vs@ALIAS_FRDB}" key="frdb" value="%{model.frdb}"  cssClass="max-length-30 " required="false" />
		                  </td>
                          <td class="crosscolor_td">
			                      <FONT color="red">*</FONT><%=Clzydd.ALIAS_DDLX%>
		                  </td>
			              <td>
						           <mytag:select property="%{model.ddlx}"   styleClass="required validate-selection"  name="ddlx"   notEmpty="false"  dictName="ddlb"/>
		                  </td>
		                  <td rowspan="5"  colspan="2" width="18%" align="center" >
		                  
		                    <table align="center">
									<tr>
										<td align="center">
											 <a onclick="javascript:editPicdw('<s:property value="%{model.dnumber}" />');return false;" href="#"> 
						        <img src='${ctx}/images/spacer.gif'
								onerror="this.src='${ctx}/images/spacer.gif'" height="126"
								alt="" width="102" border="0"  id="photo2" name="photo2"> 
						</a>
										</td>
									</tr>
								</table>
		                 
						</td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=Clzydd.ALIAS_DDQX%>
		                  </td>
			              <td>
		                           <s:textfield label="%{@vs@ALIAS_DDQX}" key="ddqx" value="%{model.ddqx}"  cssClass="max-length-8 validate-integer" required="false" />
		                  </td>
		                   
                          <td class="crosscolor_td">
			                      <%=Clzydd.ALIAS_DDRQ%>
		                  </td>
			              <td>
						           <input value="${model.ddrq}" onclick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss'})" id="ddrq" name="ddrq"  maxlength="0" class="required Wdate" />
		                  </td>
                          
                   </tr>
                   
                    <tr class="crosscolor_tr">
                         <td class="crosscolor_td">
			                      <%=Clzydd.ALIAS_DWMS%>
		                  </td>
			              <td colspan="3">
		                           <s:textfield label="%{@vs@ALIAS_DWMS}" key="dwms" size="80" value="%{model.dwms}"  cssClass="max-length-255 " required="false" />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=Clzydd.ALIAS_REMARK%>
		                  </td>
			              <td colspan="3">
		                             <s:textarea label="%{@vs@ALIAS_REMARK}" rows="4" cols="62"
							key="remark" value="%{model.remark}" cssClass="max-length-120"
							required="false"></s:textarea>
		                  </td>
                         
                   </tr>
		          
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=Clzydd.ALIAS_LRRQ%>
		                  </td>
			              <td>
						           <s:property value="%{model.lrrq}" />
		                  </td>
                          <td class="crosscolor_td">
			                     <FONT color="red">*</FONT> <%=Clzydd.ALIAS_SDR%>
		                  </td>
			              <td>
		                           <s:textfield label="%{@vs@ALIAS_SDR}" key="sdr" value="%{model.sdr}"  cssClass="required max-length-30 " required="false" />
		                             <input name="selectOrg" onclick="selectCyry(inputForm,'sdr','sdrid')"   value="选择"type="button"> 
		                            <input value="" type="hidden"  name="sdrid"  /> 
		                  </td>
                   </tr>
		         
	        <tr >
					 <td colspan="6" class="tb_bottom">
	                        <input id="submitButton" name="submitButton" type="submit" value="提交" />
	                        <input type="button" value="返回" onclick="window.location='${ctx}/pages/Clzydd/list.do?<mytag:params includes="ec*,s*" type="queryStringUtf"/>'"/>   
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
		
		return disableSubmit(finalResult,'submitButton');
	}});
	
	 function selectCyry(frm,displayName,hiddenName) {
	           window.showModalDialog('${ctx}/pages/SsDept/selectCyry.do?formName=' + frm.name + '&inputName='+displayName+'&hiddenName='+hiddenName+'&rootID=false&maxPatiNum=1&hiddenType=ID_SPLIT',frm,'dialogHeight:500px;dialogWidth:560px;center:yes');
       }
    function editPic(dnumber){				
	     var returnvalue = window.showModalDialog("${ctx}/pages/pmdd/Clzydd/picEditFileUpload.jsp?id="+dnumber,"childWIn","dialogHeight:150px;dialogWidth:400px;scroll:off;center:yes");
		if (returnvalue == "yes"){
		    changesrc();
	        //window.location.href= "${ctx}/pages/Clzydd/edit.do?dnumber="+dnumber;
	      }					
						
    } 
    function editPicdw(dnumber){
    	 var returnvalue = window.showModalDialog("${ctx}/pages/pmdd/Clzydd/picEditFileUploaddw.jsp?id="+dnumber,"childWIn","dialogHeight:150px;dialogWidth:400px;scroll:off;center:yes");
		if (returnvalue == "yes"){
		    changesrcdw();
	       // window.location.href= "${ctx}/pages/Clzydd/edit.do?dnumber="+dnumber;
	      }		
    }
    function editSmPic(dnumber){				
	     var returnvalue = window.showModalDialog("${ctx}/pages/pmdd/Clzydd/SmPicEditFileUpload.jsp?id="+dnumber,"childWIn","dialogHeight:150px;dialogWidth:400px;scroll:off;center:yes");
		if (returnvalue == "yes"){
		    changeSmsrc();
	      }					
						
    } 
    rnd.today=new Date();  
    rnd.seed=rnd.today.getTime(); 
    
   function rnd() {  
	　　　  rnd.seed = (rnd.seed*9301+49297) % 233280;  
	　　　　return rnd.seed/(233280.0);  
    } 
   function rand(number) {  
　　　　	return Math.ceil(rnd()*number);  
    }  
    
   function changesrc(){
	    var pic=document.getElementById('photo1');
	    pic.src='${ctx}/pages/pmdd/Clzydd/showPicry.do?xh=<s:property value="%{model.dnumber}" />&rand='+rand(1000);
   }
   function changeSmsrc(){
	    var pic=document.getElementById('photo3');
	    pic.src='${ctx}/pages/pmdd/Clzydd/showPicSmry.do?xh=<s:property value="%{model.dnumber}" />&rand='+rand(1000);
   }
   function changesrcdw(){
	    var pic=document.getElementById('photo2');
	    pic.src='${ctx}/pages/pmdd/Clzydd/showPicdw.do?xh=<s:property value="%{model.dnumber}" />&rand='+rand(1000);
   }
     
</script>

</body>

</html>