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
	<title><%=Fcdydd.TABLE_ALIAS%>新增</title>
</head>
<body onload="quickSelectInit()">
<%@ include file="/commons/messages.jsp" %>

<s:form action="/pages/pmdd/Fcdydd/save.do" theme="simple" name="inputForm" enctype="multipart/form-data"  method="post">
	<table cellpadding="0" cellspacing="0" border="0" class="tb_all">
	    <input type="hidden" name="returnUrl" value="!/pages/pmdd/Fcdydd/list.do?<mytag:params includes="ec*,s*" type="queryStringUtf"/>" />
	      <input value="" type="hidden"  name="photoBuffer"  />
	       <tr>
				<td colspan="5" class="tb_title"> 
							<%=Fcdydd.TABLE_ALIAS%>新增
			    </td>
		   </tr>
	       		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                     <FONT color="red">*</FONT> <%=Fcdydd.ALIAS_HTID%>
		                  </td>
			              <td>
		                           <s:textfield    key="htid" value="%{model.htid}"  cssClass="required max-length-50" required="false" />
		                  </td>
                          <td class="crosscolor_td">
			                    <FONT color="red">*</FONT>  <%=Fcdydd.ALIAS_SQR%>
		                  </td>
			              <td>
		                           <s:textfield label="%{@vs@ALIAS_SQR}" key="sqr" value="%{model.sqr}"  cssClass="required max-length-30" required="false" />
		                  </td>
		                  <td  rowspan="16">
		                  <c:if test="${smycode == 1 && typecode != 1}">
						  	<IFRAME height="100%" width="100%" name="result" src="${ctx}/pages/pmdd/Dczydd/CVR_IDCard_smycode.html"
							align="center" frameBorder="0" marginHeight="0" marginWidth="0"></IFRAME>
						</td>
						</c:if>	
						 <c:if test="${smycode != 1 && typecode == 1}">
						  	<IFRAME height="100%" width="100%" name="result" src="${ctx}/pages/pmdd/Dczydd/CVR_IDCard_typecode.html"
							align="center" frameBorder="0" marginHeight="0" marginWidth="0"></IFRAME>
						</td>
						</c:if>	
						 <c:if test="${smycode == 1 && typecode == 1}">
						  	<IFRAME height="100%" width="100%" name="result" src="${ctx}/pages/pmdd/Dczydd/CVR_IDCard.html"
							align="center" frameBorder="0" marginHeight="0" marginWidth="0"></IFRAME>
						</td>
						</c:if>		                  
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
                         
                   </tr>
		           <tr class="crosscolor_tr">
		                  <td class="crosscolor_td">
			                       <FONT color="red">*</FONT> <%=Fcdydd.ALIAS_LXDH%>
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
		                           <s:textfield label="%{@vs@ALIAS_FWQW}" key="fwqw" size="60" value="%{model.fwqw}"  cssClass="required max-length-60" required="false" />
		                  </td>
		            </tr>
		           <tr class="crosscolor_tr">       
                          <td class="crosscolor_td">
			                      <%=Fcdydd.ALIAS_DZ%>
		                  </td>
			              <td colspan="3">
		                           <s:textfield label="%{@vs@ALIAS_DZ}" key="dz"  size="60" value="%{model.dz}"  cssClass="max-length-120" required="false" />
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
		                           <s:textfield label="%{@vs@ALIAS_ZDMJ}" key="zdmj" value="%{model.zdmj}"  cssClass="max-length-10 validate-digits" required="false" /> (平米)
		                  </td>
                          
                   </tr>
                    <tr class="crosscolor_tr">
		                 
                          <td class="crosscolor_td">
			                      <%=Fcdydd.ALIAS_BXXZ%>
		                  </td>
			              <td colspan="3">
		                           <s:textfield label="%{@vs@ALIAS_BXXZ}" key="bxxz" value="%{model.bxxz}"  cssClass="max-length-30" required="false" />
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
		                           
		                   <s:textarea label="%{@vs@ALIAS_REMARK}" rows="3" cols="62"
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
			                      <FONT color="red">*</FONT><%=Fcdydd.ALIAS_SDR%>
		                  </td>
			              <td>
		                           <s:textfield label="%{@vs@ALIAS_SDR}" key="sdr" value="%{model.sdr}"  cssClass="required max-length-30" required="false" />
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
	                        <input type="button" value="返回" onclick="window.location='${ctx}/pages/pmdd_lanbin/Fcdydd/list.do?<mytag:params includes="ec*,s*" type="queryStringUtf"/>'"/>
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
		   //   if(finalResult) {
		     // 	if( ($F("yxzj")=="11" || $F("yxzj")=="12"))   {   
				//   if($F("upload") == "" && $F("photoBuffer") == ""  ){
				  //         alert("申请人二代证照片为空\r\n请选择照片信息!");
		            //       finalResult = false;
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
	
	 function selectCyry(frm,displayName,hiddenName) {
	           window.showModalDialog('${ctx}/pages/SsDept/selectCyry.do?formName=' + frm.name + '&inputName='+displayName+'&hiddenName='+hiddenName+'&rootID=false&maxPatiNum=1&hiddenType=ID_SPLIT',frm,'dialogHeight:500px;dialogWidth:560px;center:yes');
       }
       
            function selectCapturePhoto(frm,displayName,hiddenName) {
	           window.showModalDialog('${ctx}/pages/FileAttach/selectCapturePhoto.do?formName=' + frm.name + '&inputName='+displayName+'&hiddenName='+hiddenName+'',frm,'dialogHeight:300px;dialogWidth:650px;center:yes');
       }
</script>

</body>
</html>