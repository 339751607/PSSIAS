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
	<title><%=Fcdydd.TABLE_ALIAS%>编辑</title>
</head>

<body onload="quickSelectInit()" >
<%@ include file="/commons/messages.jsp" %>

<s:form action="/pages/pmdd/Fcdydd/update.do"  theme="simple" name="inputForm" method="post">
	<table cellpadding="0" cellspacing="0" border="0" class="tb_all">
	    <input type="hidden" name="returnUrl" value="!/pages/pmdd/Fcdydd/list.do?<mytag:params includes="ec*,s*" type="queryStringUtf"/>" />
	        <tr>
				      <td colspan="6" class="tb_title"> 
							<%=Fcdydd.TABLE_ALIAS%>编辑
				     </td>
		    </tr>
	         
	<s:hidden id="dnumber" name="dnumber" />
<s:hidden name="lrrq" value="%{model.lrrq}"></s:hidden>
<s:hidden name="optime" value="%{model.optime}"></s:hidden>
<s:hidden name="htid" value="%{model.htid}"></s:hidden>

		           <tr class="crosscolor_tr">
                          <td width="13%" class="crosscolor_td">
			                     <FONT color="red">*</FONT> <%=Fcdydd.ALIAS_HTID%>
		                  </td>
			              <td width="22%">
		                           <s:property value="%{model.htid}" />
		                  </td>
                          <td width="13%" class="crosscolor_td">
			                    <FONT color="red">*</FONT>  <%=Fcdydd.ALIAS_SQR%>
		                  </td>
			              <td  >
		                           <s:textfield label="%{@vs@ALIAS_SQR}" key="sqr" value="%{model.sqr}"  cssClass="required max-length-30" required="false" />
		                  </td>
		                   <td  width="15%" align="center" >
		                          申请人二代证照片&nbsp;&nbsp;
		                           <a onclick="javascript:editPic('<s:property value="%{model.dnumber}" />');return false;" href="#"> 修改
		                    </a>
		                  </td>
		                  <td  width="15%" align="center" >
		                          申请人扫描照片&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		                           <a onclick="javascript:editSmPic('<s:property value="%{model.dnumber}" />');return false;" href="#"> 修改
		                    </a>
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
		                    <td class="crosscolor_td">
			                       <FONT color="red">*</FONT><%=Fcdydd.ALIAS_YXZJ%>
		                  </td>
			              <td>
			              
			               <mytag:select property="%{model.yxzj}"   styleClass="required validate-selection"  name="yxzj"   notEmpty="false"  dictName="T_ID_NAME"/>
		                         
		                  </td>
                          <td class="crosscolor_td">
			                     <FONT color="red">*</FONT> <%=Fcdydd.ALIAS_ZJHM%>
		                  </td>
			              <td>
		                           <s:textfield label="%{@vs@ALIAS_ZJHM}" key="zjhm" value="%{model.zjhm}"  cssClass="required max-length-30 " required="false" />
		                  </td>
                       
		                  <td rowspan="6" width="18%" align="center" >
			              <table align="center">
							<tr>
								<td align="center">
									 <a onclick="javascript:editPic('<s:property value="%{model.dnumber}" />');return false;" href="#"> <img src='${ctx}/images/spacer.gif'  onerror="this.src='${ctx}/images/spacer.gif'" height="126" alt="" width="102" border="0" id="photo" name="photo"> 	
		                    </a>
								</td>
							</tr>
						</table>
		                  
		                   </td>
		                     <td rowspan="6" width="18%" align="center" >
			      <table align="center">
							<tr>
								<td align="center">
									  <a onclick="javascript:editSmPic('<s:property value="%{model.dnumber}" />');return false;" href="#"> <img src='${ctx}/images/spacer.gif'  onerror="this.src='${ctx}/images/spacer.gif'" height="126" alt="" width="102" border="0" id="photoSm" name="photoSm"> 	
		                    </a>
								</td>
							</tr>
						</table>
		                 
		                   </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                       <FONT color="red">*</FONT><%=Fcdydd.ALIAS_LXDH%>
		                  </td>
			              <td>
		                           <s:textfield label="%{@vs@ALIAS_LXDH}" key="lxdh" value="%{model.lxdh}"  cssClass="required max-length-20 validate-number" required="false" />
		                  </td>
		                  <td class="crosscolor_td">
			                     <FONT color="red">*</FONT> <%=Fcdydd.ALIAS_LB%>
		                  </td>
			              <td>
						           <mytag:select property="%{model.lb}"   styleClass="required validate-selection"  name="lb"   notEmpty="false"  dictName="fcdylb"/>
		                  </td>
                          
                   </tr>
		           <tr class="crosscolor_tr">
                          
		                     <td class="crosscolor_td">
			                      <%=Fcdydd.ALIAS_GZDW%>
		                  </td>
			              <td>
		                           <s:textfield label="%{@vs@ALIAS_GZDW}" key="gzdw" value="%{model.gzdw}"  cssClass="max-length-60" required="false" />
		                  </td>
		                  <td class="crosscolor_td">
			                      <%=Fcdydd.ALIAS_FRDB%>
		                  </td>
			              <td>
		                           <s:textfield label="%{@vs@ALIAS_FRDB}" key="frdb" value="%{model.frdb}"  cssClass="max-length-30" required="false" />
		                  </td>
                         
                   </tr>
                    <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                     <FONT color="red">*</FONT> <%=Fcdydd.ALIAS_FWQW%>
		                  </td>
			              <td colspan="3">
		                           <s:textfield label="%{@vs@ALIAS_FWQW}" key="fwqw" value="%{model.fwqw}"  cssClass="required max-length-60" required="false" />
		                  </td>
		            </tr>       
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=Fcdydd.ALIAS_DZ%>
		                  </td>
			              <td colspan="3">
		                           <s:textfield label="%{@vs@ALIAS_DZ}" key="dz" size="80" value="%{model.dz}"  cssClass="max-length-120" required="false" />
		                  </td>
                         
                   </tr>
                  
		           <tr class="crosscolor_tr">
		                  <td class="crosscolor_td">
			                     <FONT color="red">*</FONT> <%=Fcdydd.ALIAS_FWSYQZH%>
		                  </td>
			              <td>
		                           <s:textfield label="%{@vs@ALIAS_FWSYQZH}" key="fwsyqzh" value="%{model.fwsyqzh}"  cssClass="required max-length-30" required="false" />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=Fcdydd.ALIAS_JZMJ%>
		                  </td>
			              <td>
		                           <s:textfield label="%{@vs@ALIAS_JZMJ}" key="jzmj" value="%{model.jzmj}"  cssClass="max-length-10 validate-digits" required="false" />(平米)
		                  </td>
		                 
                         
                   </tr>
		           <tr class="crosscolor_tr">
		                  <td class="crosscolor_td">
			                     <FONT color="red">*</FONT> <%=Fcdydd.ALIAS_TDSYZH%>
		                  </td>
			              <td>
		                           <s:textfield label="%{@vs@ALIAS_TDSYZH}" key="tdsyzh" value="%{model.tdsyzh}"  cssClass="required max-length-30" required="false" />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=Fcdydd.ALIAS_ZDMJ%>
		                  </td>
			              <td>
		                           <s:textfield label="%{@vs@ALIAS_ZDMJ}" key="zdmj" value="%{model.zdmj}"  cssClass="max-length-10 validate-digits" required="false" />(平米)
		                  </td>
		                   <td  colspan="2" align="center" >
		                                               当物照片&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		                           <a onclick="javascript:editDwPic('<s:property value="%{model.dnumber}" />');return false;" href="#"> 修改
		                    </a>
		                  </td>
                          
                   </tr>
                    <tr class="crosscolor_tr">
		                 
                          <td class="crosscolor_td">
			                      <%=Fcdydd.ALIAS_BXXZ%>
		                  </td>
			              <td colspan="3">
		                           <s:textfield label="%{@vs@ALIAS_BXXZ}" key="bxxz" value="%{model.bxxz}"  cssClass="max-length-30" required="false" />
		                  </td>
		                  <td rowspan="6" colspan="2"  align="center" >
			      <table align="center">
							<tr>
								<td align="center">
									 <a onclick="javascript:editDwPic('<s:property value="%{model.dnumber}" />');return false;" href="#"> <img src='${ctx}/images/spacer.gif'  onerror="this.src='${ctx}/images/spacer.gif'" height="126" alt="" width="102" border="0" id="photoDw" name="photoDw"> 	
		                    </a>
								</td>
							</tr>
						</table>
		                  
		                   </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                     <FONT color="red">*</FONT><%=Fcdydd.ALIAS_DDLB%>
		                  </td>
			              <td>
						           <mytag:select property="%{model.ddlb}"   styleClass="required validate-selection"  name="ddlb"   notEmpty="false"  dictName="ddlb"/>
		                  </td>
                          <td class="crosscolor_td">
			                      <%=Fcdydd.ALIAS_DDQX%>
		                  </td>
			              <td>
		                           <s:textfield label="%{@vs@ALIAS_DDQX}" key="ddqx" value="%{model.ddqx}"  cssClass="max-length-8 validate-integer" required="false" />(天)
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=Fcdydd.ALIAS_DWMS%>
		                  </td>
			              <td colspan="3">
		                           <s:textfield label="%{@vs@ALIAS_DWMS}" size="80" key="dwms" value="%{model.dwms}"  cssClass="max-length-255" required="false" />
		                  </td>
                         
                   </tr>
                    <tr class="crosscolor_tr">
                         
                          <td class="crosscolor_td">
			                      <%=Fcdydd.ALIAS_REMARK%>
		                  </td>
			              <td colspan="3">
		                           
		                   <s:textarea label="%{@vs@ALIAS_REMARK}" rows="4" cols="62"
							key="remark" value="%{model.remark}" cssClass="max-length-120"
							required="false"></s:textarea>
		                  
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=Fcdydd.ALIAS_DDRQ%>
		                  </td>
			              <td>
						           <input value="${model.ddrq}" onclick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss'})" id="ddrq" name="ddrq"  maxlength="0" class="required Wdate" />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=Fcdydd.ALIAS_LRRQ%>
		                  </td>
			              <td>
			                        <s:property value="%{model.lrrq}" />
						          
						            
						           
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <FONT color="red">*</FONT><%=Fcdydd.ALIAS_SDR%>
		                  </td>
			              <td colspan="3">
		                           <s:textfield label="%{@vs@ALIAS_SDR}" key="sdr" value="%{model.sdr}"  cssClass="required max-length-30" required="false" />
		                             <input name="selectOrg" onclick="selectCyry(inputForm,'sdr','sdrid')"   value="选择"type="button"> 
		                            <input value="" type="hidden"  name="sdrid"  /> 
		                  </td>
                          
                   </tr>
	        <tr >
					 <td colspan="6" class="tb_bottom">
	                        <input id="submitButton" name="submitButton" type="submit" value="提交" />
	                        <input type="button" value="返回" onclick="window.location='${ctx}/pages/Fcdydd/list.do?<mytag:params includes="ec*,s*" type="queryStringUtf"/>'"/>   
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
	     var returnvalue = window.showModalDialog("${ctx}/pages/pmdd/Fcdydd/picEditFileUpload.jsp?id="+dnumber,"childWIn","dialogHeight:150px;dialogWidth:400px;scroll:off;center:yes");
		if (returnvalue == "yes"){
		    changesrc();
	        //window.location.href= "${ctx}/pages/Fcdydd/edit.do?dnumber="+dnumber;
	      }										
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
	    pic.src='${ctx}/pages/pmdd/Fcdydd/showPic.do?xh=<s:property value="%{model.dnumber}" />&rand='+rand(1000);
   }  
   
   
   function editSmPic(dnumber){				
	    var returnvalue = window.showModalDialog("${ctx}/pages/pmdd/Fcdydd/picEditSmFileUpload.jsp?id="+dnumber,"childWIn","dialogHeight:150px;dialogWidth:400px;scroll:off;center:yes");
		if (returnvalue == "yes"){
		    changeSmsrc();
	        //window.location.href= "${ctx}/pages/Fcdydd/edit.do?dnumber="+dnumber;
	      }										
    }
    
   function changeSmsrc(){
	    var pic=document.getElementById('photoSm');
	    pic.src='${ctx}/pages/pmdd/Fcdydd/showSmPic.do?xh=<s:property value="%{model.dnumber}" />&rand='+rand(1000);
   }  
   
   
   function editDwPic(dnumber){				
	    var returnvalue = window.showModalDialog("${ctx}/pages/pmdd/Fcdydd/picEditDwFileUpload.jsp?id="+dnumber,"childWIn","dialogHeight:150px;dialogWidth:400px;scroll:off;center:yes");
		if (returnvalue == "yes"){
		    changeDwsrc();
	        //window.location.href= "${ctx}/pages/Fcdydd/edit.do?dnumber="+dnumber;
	      }										
    }
    
   function changeDwsrc(){
	    var pic=document.getElementById('photoDw');
	    pic.src='${ctx}/pages/pmdd/Fcdydd/showDwPic.do?xh=<s:property value="%{model.dnumber}" />&rand='+rand(1000);
   } 
</script>

</body>

</html>