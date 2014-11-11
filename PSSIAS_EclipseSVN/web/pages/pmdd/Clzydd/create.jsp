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
	<title><%=Clzydd.TABLE_ALIAS%>新增</title>
</head>
<body onload="quickSelectInit()" >
<%@ include file="/commons/messages.jsp" %>

<s:form action="/pages/pmdd/Clzydd/save.do" theme="simple" name="inputForm" enctype="multipart/form-data"  method="post">
	<table cellpadding="0" cellspacing="0" border="0" class="tb_all">
	    <input type="hidden" name="returnUrl" value="!/pages/pmdd/Clzydd/list.do?<mytag:params includes="ec*,s*" type="queryStringUtf"/>" />
	      <input value="" type="hidden"  name="photoBuffer"  />
	       <tr>
				<td colspan="5" class="tb_title"> 
							<%=Clzydd.TABLE_ALIAS%>新增
			    </td>
		   </tr>
	      <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                     <FONT color="red">*</FONT> <%=Clzydd.ALIAS_HTID%>
		                  </td>
			              <td>
		                           <s:textfield label="%{@vs@ALIAS_HTID}" key="htid" value="%{model.htid}"  cssClass="required max-length-50 " required="false" />
		                  </td>
                          <td class="crosscolor_td">
			                     <FONT color="red">*</FONT> <%=Clzydd.ALIAS_SQR%>
		                  </td>
			              <td>
		                           <s:textfield label="%{@vs@ALIAS_SQR}" key="sqr" value="%{model.sqr}"  cssClass="required max-length-30 " required="false" />
		                  </td>
		                  <td rowspan="16">                      
						  	 <c:if test="${typecode == 1 && smycode != 1}">                
						  	<IFRAME height="100%" width="100%" name="result" src="${ctx}/pages/pmdd/Dczydd/CVR_IDCard_typecode.html"
							align="center" frameBorder="0" marginHeight="0" marginWidth="0"></IFRAME>
							  </c:if>
		                      <c:if test="${smycode == 1 && typecode != 1}">                
						  	<IFRAME height="100%" width="100%" name="result" src="${ctx}/pages/pmdd/Dczydd/CVR_IDCard_smycode.html"
							align="center" frameBorder="0" marginHeight="0" marginWidth="0"></IFRAME>
							  </c:if>
							    <c:if test="${smycode == 1 && typecode == 1}">                
						  	<IFRAME height="100%" width="100%" name="result" src="${ctx}/pages/pmdd/Dczydd/CVR_IDCard.html"
							align="center" frameBorder="0" marginHeight="0" marginWidth="0"></IFRAME>
							  </c:if>
						</td>
                   </tr>
		           <tr class="crosscolor_tr">
		                   <td class="crosscolor_td">
			                       <FONT color="red">*</FONT><%=Clzydd.ALIAS_YXZJ%>
		                  </td>
			              <td>
			              
			               <mytag:select property="%{model.yxzj}"   styleClass="required validate-selection"  name="yxzj"   notEmpty="false"  dictName="T_ID_NAME"/>
		                         
		                  </td>
                          <td class="crosscolor_td">
			                     <FONT color="red">*</FONT> <%=Clzydd.ALIAS_ZJHM%>
		                  </td>
			              <td>
		                           <s:textfield label="%{@vs@ALIAS_ZJHM}" key="zjhm" value="%{model.zjhm}"  cssClass="required max-length-30" required="false" />
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
		                           <s:textfield label="%{@vs@ALIAS_GZDW}" key="gzdw" value="%{model.gzdw}"  cssClass="max-length-60 " required="false" />
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
		                  </td><%--
			              <td>
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
		                  </td><%--
			              <td>
		                           <s:textfield label="%{@vs@ALIAS_CJHM}" key="cjhm" value="%{model.cjhm}"  cssClass="required max-length-30 " required="false" />
		                  </td>
                          --%><td class="crosscolor_td">
			                      <FONT color="red">*</FONT><%=Clzydd.ALIAS_CSYS%>
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
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=Clzydd.ALIAS_DDQX%>
		                  </td>
			              <td>
		                           <s:textfield label="%{@vs@ALIAS_DDQX}" key="ddqx" value="%{model.ddqx}"  cssClass="max-length-8 validate-integer" required="false" />
		                  </td>
		                   
                          <td class="crosscolor_td">
			                     <FONT color="red">*</FONT><%=Clzydd.ALIAS_DDRQ%>
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
		                           <s:textfield label="%{@vs@ALIAS_SDR}" id="sdr" key="sdr" value="%{model.sdr}"  cssClass="required max-length-30 " required="false" />
		                             <input name="selectOrg" onclick="selectCyry(inputForm,'sdr','sdrid')"   value="选择"type="button"> 
		                            <input value="" type="hidden" id="sdrid"  name="sdrid"  /> 
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
						 <FONT color="red">*</FONT>当物照片
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
	//	     if(finalResult) {
		//     	if( ($F("yxzj")=="11" || $F("yxzj")=="12"))   {   
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
</script>	
<script>
	 function selectCyry(frm,displayName,hiddenName) {
	           //alert('dddddddd');
	           window.showModalDialog('${ctx}/pages/SsDept/selectCyry.do?formName=' + frm.name + '&inputName='+displayName+'&hiddenName='+hiddenName+'&rootID=false&maxPatiNum=1&hiddenType=ID_SPLIT',frm,'dialogHeight:500px;dialogWidth:560px;center:yes');
       }
       
            function selectCapturePhoto(frm,displayName,hiddenName) {
	           window.showModalDialog('${ctx}/pages/FileAttach/selectCapturePhoto.do?formName=' + frm.name + '&inputName='+displayName+'&hiddenName='+hiddenName+'',frm,'dialogHeight:300px;dialogWidth:650px;center:yes');
       }
</script>

</body>
</html>