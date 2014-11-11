<%@page import="com.dyneinfo.pmdd.model.*" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@page import="java.text.SimpleDateFormat"%>
<%@ include file="/commons/taglibs.jsp" %>
<%
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+request.getContextPath()+"/";
String dwmc="";
String type="";
String name="";
if(request.getAttribute("dwmc") != null)
  dwmc=(String)request.getAttribute("dwmc"); 
if(request.getAttribute("type") != null)
  type=(String)request.getAttribute("type"); 
  
 if (type != null && type.equals("D")) {
 	name="当物名称";
 }else if(type != null && type.equals("F")){
 	name="房产描述";
 }else if(type != null && type.equals("C")){
 	name="车辆描述";
 } 
  
%>
<html>
<head>
	<%@ include file="/commons/meta.jsp" %>
	<base target="_self">
	<title>典当赎回录入</title>
</head>
<body>
<%@ include file="/commons/messages.jsp" %>

<s:form action="/pages/pmdd/Shxx/redeemsave.do" theme="simple"  name="inputForm" enctype="multipart/form-data"   method="post">
	<table cellpadding="0" cellspacing="0" border="0" class="tb_all">
	    <input type="hidden" name="returnUrl" value="!/pages/pmdd/Shxx/list.do?<mytag:params includes="ec*,s*" type="queryStringUtf"/>" />
	    <s:hidden id="flag" name="flag" />
	    <s:hidden id="htid" name="htid" />
	    <s:hidden id="dnumber" name="dnumber" />
	       <tr>
				<td colspan="4" class="tb_title"> 
							典当赎回录入
			    </td>
		   </tr>
	      <tr class="crosscolor_tr">
                          
                          <td class="crosscolor_td">
			                  <%=Shxx.ALIAS_HTID%>
		                  </td>
			              <td>
		                           <s:property value="%{model.htid}" />
		                  </td>
		                   <td class="crosscolor_td">
		                   	<%=name %>
		                  </td>
			              <td>
		                     <%=dwmc%>
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <FONT color="red">*</FONT><%=Shxx.ALIAS_SHRXM%>
		                  </td>
			              <td>
		                           <s:textfield label="%{@vs@ALIAS_SHRXM}" key="shrxm" value="%{model.shrxm}"  cssClass="required max-length-30" required="false" />
		                  </td>
                           <td class="crosscolor_td">
			                      <%=Shxx.ALIAS_LXDH%>
		                  </td>
			              <td>
		                           <s:textfield label="%{@vs@ALIAS_LXDH}" key="lxdh" value="%{model.lxdh}"  cssClass="max-length-20 validate-number" required="false" />
		                  </td>
                   </tr>
                   <tr class="crosscolor_tr">
		                   <td class="crosscolor_td">
			                      有效证件
		                  </td>
			              <td>
			              
			               <mytag:select property="%{model.yxzj}"   styleClass="required validate-selection"  name="yxzj"   notEmpty="false"  dictName="T_ID_NAME"/>
		                         <FONT color="red">*</FONT>
		                  </td>        
                          <td class="crosscolor_td">
			                      <%=Shxx.ALIAS_SHRSFZHM%>
		                  </td>
			              <td>
	                               <s:textfield label="%{@vs@ALIAS_SHRSFZHM}" key="shrsfzhm"  id="shrsfzhm" value="%{model.shrsfzhm}"  cssClass="max-length-18" required="false" />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                         
                          <td class="crosscolor_td">
			                      <%=Shxx.ALIAS_GZDW%>
		                  </td>
			              <td colspan="3">
	                               <s:textfield label="%{@vs@ALIAS_GZDW}" key="gzdw" value="%{model.gzdw}"  cssClass="max-length-60 " required="false" />
		                  </td>
                   </tr>
                    <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=Shxx.ALIAS_BZ%>
		                  </td>
			              <td colspan="3">
		                           <s:textfield label="%{@vs@ALIAS_BZ}" size="50" key="bz" value="%{model.bz}"  cssClass="max-length-120" required="false" />
		                  </td>
                         
                   </tr>
		           <tr class="crosscolor_tr">
       
                          <td class="crosscolor_td">
			                      <%=Shxx.ALIAS_SHRQ%>
		                  </td>
			              <td>
						           <input value="${model.shrq}" onclick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss'})" id="shrq" name="shrq"  maxlength="0" class="required Wdate" />
		                  </td>
                          <td class="crosscolor_td">
			                    <FONT color="red">*</FONT>  <%=Shxx.ALIAS_TDR%>
		                  </td>
			              <td>
		                           <s:textfield label="%{@vs@ALIAS_TDR}" key="tdr" value="%{model.tdr}"  cssClass="required max-length-30" required="false" />
		                            <input name="selectOrg" onclick="selectCyry(inputForm,'tdr','sdrid')"   value="选择"type="button"> 
		                            <input value="" type="hidden"  name="sdrid"  /> 
		                            
		                  </td>
                          
                   </tr>
		         
		           <tr class="crosscolor_tr">
                         <td>
						赎回人照片
					</td>
					<td colspan="3">
						<s:file name="upload"  style="WIDTH:300px;cursor:hand"  UNSELECTABLE="on"  id="file"
							cssClass="validate-file-png-jpg-gif-bmp" label="图片"></s:file>
							
							<input name="selectOrg" onclick="selectCapturePhoto(inputForm,'file','uploadfileid')"   value="摄像头"type="button"> 
		                            <input value="" type="hidden"  name="uploadfileid"  />
		                            <input value="" type="hidden"  name="uploadfilename"  />

					</td>
                   </tr>
	       <tr >
				<td colspan="4" class="tb_bottom">
							<input id="submitButton" name="submitButton" type="submit" value="提交" />
	                        <input type="button" value="关闭" onclick="window.close();"/>
			    </td>
	        </tr>
	</table>
</s:form>

<script>
	
	new Validation(document.forms[0],{onSubmit:true,onFormValidate : function(result,form) {
		var finalResult = result;
		
		//在这里添加自定义验证
		
		if(finalResult) {
			     if( ($F("yxzj")=="11" || $F("yxzj")=="12") && $F("shrsfzhm").length > 0  ) {
			          if(!f_check_IDno($F("shrsfzhm"))){
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
    function editPic(dnumber,flag){				
	     var returnvalue = window.showModalDialog("${ctx}/pages/pmdd/Shxx/picEditFileUpload.jsp?id="+dnumber+"&type="+flag,"childWIn","dialogHeight:150px;dialogWidth:400px;scroll:off;center:yes");
		if (returnvalue == "yes"){
	        changesrc();
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
	    pic.src='${ctx}/pages/pmdd/Shxx/showPic.do?flag=<s:property value="%{model.flag}" />&dnumber=<s:property value="%{model.dnumber}" />&rand='+rand(1000);
   }
   
   function selectCapturePhoto(frm,displayName,hiddenName) {
	           window.showModalDialog('${ctx}/pages/FileAttach/selectCapturePhoto.do?formName=' + frm.name + '&inputName='+displayName+'&hiddenName='+hiddenName+'',frm,'dialogHeight:300px;dialogWidth:640px;center:yes');
    }
</script>

</body>
</html>