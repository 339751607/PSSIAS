<%@page import="com.dyneinfo.pmdd.model.*" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/commons/taglibs.jsp" %>
<%
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+request.getContextPath()+"/";
%>
<html>

<head>
	<%@ include file="/commons/meta.jsp" %>
	<base href="<%=basePath%>">
	<title><%=Dczydd.TABLE_ALIAS%>编辑</title>
</head>

<body onload="quickSelectInit()" >
<%@ include file="/commons/messages.jsp" %>

<s:form action="/pages/pmdd/Dczydd/update.do"  theme="simple" name="inputForm"  method="post">
	<table cellpadding="0" cellspacing="0" border="0" class="tb_all">
	    <input type="hidden" name="returnUrl" value="!/pages/pmdd/Dczydd/list.do?<mytag:params includes="ec*,s*" type="queryStringUtf"/>" />
	        <tr>
				      <td colspan="6" class="tb_title"> 
							<%=Dczydd.TABLE_ALIAS%>编辑
				     </td>
		    </tr>
	        
	<s:hidden id="dnumber" name="dnumber" />
	<s:hidden name="lrrq" value="%{model.lrrq}"></s:hidden>
<s:hidden name="optime" value="%{model.optime}"></s:hidden>
<s:hidden name="htid" value="%{model.htid}"></s:hidden>

		           <tr class="crosscolor_tr">
                          <td width="13%" class="crosscolor_td">
			                      <FONT color="red">*</FONT><%=Dczydd.ALIAS_HTID%>
		                  </td>
			              <td width="22%">
		                          
		                   <s:property value="%{model.htid}" />
		                  </td>
                          <td width="13%" class="crosscolor_td">
			                     <FONT color="red">*</FONT> <%=Dczydd.ALIAS_SQR%>
		                  </td>
			              <td width="22%">
		                           <s:textfield label="%{@vs@ALIAS_SQR}" key="sqr" value="%{model.sqr}" cssClass="required max-length-30" required="false" />
		                  </td>
		                   <td  width="15%" align="center" >
		                          二代证照片 &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		                          <a onclick="javascript:editPic('<s:property value="%{model.dnumber}" />');return false;" href="#"> 修改</a>
		                  </td>
		                  <td  width="15%" align="center" >
		                           扫描照片 &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		                          <a onclick="javascript:editSmPic('<s:property value="%{model.dnumber}" />');return false;" href="#"> 修改</a>
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
		                  
		                  <td rowspan="6" width="15%" align="center" >
		                  	<table align="center">
								<tr>
									<td align="center">
										 <a onclick="javascript:editPic('<s:property value="%{model.dnumber}" />');return false;" href="#">  <img src='${ctx}/images/spacer.gif'  onerror="this.src='${ctx}/images/spacer.gif'" height="126" alt="" width="102" border="0" id="photo" name="photo"> 	</a>
									</td>
								</tr>
							</table> 
			     
		                
		                   </td>
		                    <td rowspan="6" width="15%" align="center" >
		                    	<table align="center">
									<tr>
										<td align="center">
											  <a onclick="javascript:editSmPic('<s:property value="%{model.dnumber}" />');return false;" href="#">  <img src='${ctx}/images/spacer.gif'  onerror="this.src='${ctx}/images/spacer.gif'" height="126" alt="" width="102" border="0" id="photosm" name="photosm"> 	</a>
										</td>
									</tr>
							    </table> 
			     
		                
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
			                       <FONT color="red">*</FONT> <%=Dczydd.ALIAS_LXDH%>
		                  </td>
			              <td>
		                           <s:textfield label="%{@vs@ALIAS_LXDH}" key="lxdh" value="%{model.lxdh}" cssClass="required max-length-20 validate-number" required="false" />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=Dczydd.ALIAS_GZDW%>
		                  </td>
			              <td >
		                           <s:textfield label="%{@vs@ALIAS_GZDW}" key="gzdw"  value="%{model.gzdw}" cssClass="max-length-60" required="false" />
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
						           <mytag:select property="%{model.flag}" styleClass="required validate-selection"    name="flag"   notEmpty="false"  dictName="dczylb"/>
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
		                   <td colspan="2" align="center">
		                                                  当物照片 &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		                          <a onclick="javascript:editPicdw('<s:property value="%{model.dnumber}" />');return false;" href="#"> 修改</a>
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
		                   <td rowspan="5" colspan="2" width="18%" align="center" >
		                   
		                   <table align="center">
							<tr>
								<td align="center">
									 <a onclick="javascript:editPicdw('<s:property value="%{model.dnumber}" />');return false;" href="#">  <img src='${ctx}/images/spacer.gif'  onerror="this.src='${ctx}/images/spacer.gif'" height="126" alt="" width="102" border="0"  id="photo2" name="photo2"> </a>	
		          
								</td>
							</tr>
						</table>
			     
		                 
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
		                           <s:textarea label="%{@vs@ALIAS_REMARK}" rows="4" cols="62"
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
		          
	        <tr >
					 <td colspan="6" class="tb_bottom">
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
		
		return disableSubmit(finalResult,'submitButton');
	}});
	
	
	 function editPic(dnumber){				
	     var returnvalue = window.showModalDialog("${ctx}/pages/pmdd/Dczydd/picEditFileUpload.jsp?id="+dnumber,"childWIn","dialogHeight:150px;dialogWidth:400px;scroll:off;center:yes");
		if (returnvalue == "yes"){
		    changesrc();
	        //window.location.href= "${ctx}/pages/Dczydd/edit.do?dnumber="+dnumber;
	      }					
						
    } 
    
    function editSmPic(dnumber){				
	     var returnvalue = window.showModalDialog("${ctx}/pages/pmdd/Dczydd/picEditFileUploadSm.jsp?id="+dnumber,"childWIn","dialogHeight:150px;dialogWidth:400px;scroll:off;center:yes");
		if (returnvalue == "yes"){
		    changesrcSm();
	        //window.location.href= "${ctx}/pages/Dczydd/edit.do?dnumber="+dnumber;
	      }					
						
    } 
    
     function editPicdw(dnumber){
    	 var returnvalue = window.showModalDialog("${ctx}/pages/pmdd/Dczydd/picEditFileUploaddw.jsp?id="+dnumber,"childWIn","dialogHeight:150px;dialogWidth:400px;scroll:off;center:yes");
		if (returnvalue == "yes"){
		    changesrcdw();
	        //window.location.href= "${ctx}/pages/Dczydd/edit.do?dnumber="+dnumber;
	      }		
    } 
    
    function selectDept(frm,displayName,hiddenName) {
	           window.showModalDialog('${ctx}/pages/SsDept/selectDept.do?formName=' + frm.name + '&inputName='+displayName+'&hiddenName='+hiddenName+'&rootID=false&maxPatiNum=3&hiddenType=ID_SPLIT',frm,'dialogHeight:500px;dialogWidth:560px;center:yes');
    }
	 function selectCyry(frm,displayName,hiddenName) {
	           window.showModalDialog('${ctx}/pages/SsDept/selectCyry.do?formName=' + frm.name + '&inputName='+displayName+'&hiddenName='+hiddenName+'&rootID=false&maxPatiNum=1&hiddenType=ID_SPLIT',frm,'dialogHeight:500px;dialogWidth:560px;center:yes');
       }
    function selectDeptCheckbox(frm,displayName,hiddenName) {
	           window.showModalDialog('${ctx}/pages/SsDept/selectDeptCheckbox.do?formName=' + frm.name + '&inputName='+displayName+'&hiddenName='+hiddenName+'&rootID=false&maxPatiNum=3&hiddenType=ID_SPLIT',frm,'dialogHeight:500px;dialogWidth:450px;center:yes');
    }
    rnd.today=new Date();  
    rnd.seed=rnd.today.getTime(); 
    
    function rnd() {  
	　　　  rnd.seed = (rnd.seed*9301+49297) % 233280;  
	　　　　return rnd.seed/(233280.0);  
    };  
    function rand(number) {  
　　　　	return Math.ceil(rnd()*number);  
    };  
    
   function changesrc(){
	    var pic=document.getElementById('photo');
	    pic.src='${ctx}/pages/pmdd/Dczydd/showPicry.do?xh=<s:property value="%{model.dnumber}" />&rand='+rand(1000);
   }
   
    function changesrcSm(){
	    var pic=document.getElementById('photosm');
	    pic.src='${ctx}/pages/pmdd/Dczydd/showPicrysm.do?xh=<s:property value="%{model.dnumber}" />&rand='+rand(1000);
   }
   
   function changesrcdw(){
	    var pic=document.getElementById('photo2');
	    pic.src='${ctx}/pages/pmdd/Dczydd/showPicdw.do?xh=<s:property value="%{model.dnumber}" />&rand='+rand(1000);
   }
    
</script>

</body>

</html>