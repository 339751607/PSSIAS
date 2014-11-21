<%@ page import="com.dyneinfo.jxy.model.*" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/commons/taglibs.jsp" %>
<%
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+request.getContextPath()+"/";
%>
<html>
<head>
	<%@ include file="/commons/meta.jsp" %>
	<base href="<%=basePath%>">
	<title><%=SsNotice.TABLE_ALIAS%>发布</title>
</head>
<body onload="quickSelectInit()">
<%@ include file="/commons/messages.jsp" %>

<s:form action="/pages/jxy/SsNotice/save.do"  enctype="multipart/form-data"  theme="simple" name="inputForm"  method="post">
	<table cellpadding="0" cellspacing="0" border="0" class="tb_all">
	    <input type="hidden" name="returnUrl" value="!/pages/jxy/SsNotice/htadlist.do?<mytag:params includes="ec*,s*" type="queryStringUtf"/>" />
	       <tr>
				<td colspan="4" class="tb_title"> 
							<%=SsNotice.TABLE_ALIAS%>发布
			    </td>
		   </tr>
	        <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                     <FONT color="red">*</FONT> <%=SsNotice.ALIAS_NOTICETITLE%>
		                  </td>
			              <td colspan="3">
		                           <s:textfield label="%{@vs@ALIAS_NOTICETITLE}" size="70"  key="noticetitle" value="%{model.noticetitle}"  cssClass="required max-length-256" required="false" />
		                  </td>
		           </tr>
		           <tr class="crosscolor_tr">        
                          <td class="crosscolor_td">
			                    <FONT color="red">*</FONT>  <%=SsNotice.ALIAS_NOTICECONTENT%>
		                  </td>
			               <td colspan="3">
		                           <s:textarea label="%{@vs@ALIAS_NOTICECONTENT}" rows="6" cols="55"
							key="noticecontent" value="%{model.noticecontent}" cssClass="required max-length-3000"
							required="false"></s:textarea>
		                         
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                     <FONT color="red">*</FONT>  <%=SsNotice.ALIAS_STARTTIME%>
		                  </td>
			              <td>
		                           <input value="${model.starttimeString}" onclick="WdatePicker({dateFmt:'<%=SsNotice.FORMAT_STARTTIME%>'})" id="starttimeString" name="starttimeString"  maxlength="0" class="required Wdate" />
		                  </td>
                          <td class="crosscolor_td">
			                     <FONT color="red">*</FONT>  <%=SsNotice.ALIAS_ENDTIME%>
		                  </td>
			              <td>
		                       <input value="${model.endtimeString}" onclick="WdatePicker({dateFmt:'<%=SsNotice.FORMAT_ENDTIME%>'})" id="endtimeString" name="endtimeString"  maxlength="0" class="Wdate" />
		                       
		                  </td>
                   </tr>    
                    <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=SsNotice.ALIAS_PARTICIPANTS%>
		                  </td>
			              <td colspan="3">
		                          
		                            <input type="text" size="80" name="participantsName" maxlength="0" value=""  />
		                            <input type="hidden"  name="participants" value="" />
		                            <input name="selectparticipantsName" onclick="selectMaxPerson(inputForm,'participantsName','participants')"   value="选择" type="button"> 
		                         
		                  </td>
                         
                   </tr>
                   <tr class="crosscolor_tr">
                         
                          <td class="crosscolor_td">
			                      <%=SsNotice.ALIAS_ISSUESCOPE%>
		                  </td>
			             <td colspan="3">
		                            <input type="text"  size="80" name="issuescopeName" maxlength="0" value=""  />
		                            <input type="hidden"  name="issuescope" value="" />
		                            <input name="selectparticipantsName" onclick="selectDeptCheckbox(inputForm,'issuescopeName','issuescope')"   value="选择" type="button"> 
		                         
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                     <FONT color="red">*</FONT>  <%=SsNotice.ALIAS_AUTHORID%>
		                  </td>
			              <td>
		                          
		                            <input type="text" class="required"   name="authorname" maxlength="0" value="<authz:authentication property="principal.userXm"/>"  class="max-length-30"/>
		                            <input type="hidden"  name="authorid" value="<authz:authentication property="principal.username"/>" />
		                            <input name="selectPersonButton" onclick="selectPerson(inputForm,'authorname','authorid')"   value="选择" type="button"> 
		                         
		                  </td>
                           <td class="crosscolor_td">
			                     <FONT color="red">*</FONT>  <%=SsNotice.ALIAS_SENDUNITID%>
		                  </td>
			              <td>
		                           
		                           
		                            <input type="text"   class="required"   name="sendunitname"  maxlength="0" value="<authz:authentication property="principal.deptName"/>"  class="required max-length-60"/>
		                            <input type="hidden"  name="sendunitid" value="<authz:authentication property="principal.deptID"/>" />
		                            <input name="selectDeptButton"  onclick="javascript:selectDept(inputForm,'sendunitname','sendunitid')"   value="选择" type="button" > 
		                 
		                  </td>
                          
                   </tr>
		           <tr class="crosscolor_tr">
                         
		                  <td class="crosscolor_td">
			                    <FONT color="red">*</FONT>   <%=SsNotice.ALIAS_STATE%>
		                  </td>
			              <td>
						           <mytag:select property="%{model.state}"   styleClass="required validate-selection"  name="state"   notEmpty="false"  dictName="NOTICE_STATE"/>
		                  </td>
                          <td class="crosscolor_td">
			                      <%=SsNotice.ALIAS_CREATETIME%>
		                  </td>
			              <td>
		                           <input value="${model.createtimeString}" onclick="WdatePicker({dateFmt:'<%=SsNotice.FORMAT_CREATETIME%>',maxDate:'${date}'})" id="createtimeString" name="createtimeString"  maxlength="0" class="Wdate" />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                    <FONT color="red">*</FONT>   <%=SsNotice.ALIAS_ISREPLY%>
		                  </td>
			              <td colspan="3">
						           <mytag:select property="%{model.isreply}"   styleClass="required validate-selection"  name="isreply"   notEmpty="false"  dictName="shiFou"/>
		                  </td>
                        
                         <!-- 改为默认按通知发布日期倒序 modify by zzq 2012/06/13
                          <td class="crosscolor_td">
			                      <%=SsNotice.ALIAS_SORTNO%>
		                  </td>
			              <td>
		                           <s:textfield label="%{@vs@ALIAS_SORTNO}" key="sortno" value="%{model.sortno}"  cssClass="validate-number " required="false" />
		                  </td>
		                  -->
                   </tr>

				<tr class="crosscolor_tr">
					<TD width="100%" class="crosscolor_td" colSpan="4">
						<code id="FileTable">
							<table border='0' id='tb1' cellspacing='0' cellpadding='0'
								style='width: 100%; margin: 0px 0px 0px 0px;' align='center'
								bgcolor='#ffffff'>
								<tr bgcolor='#ffffff' class="crosscolor_tr">
									<td class="crosscolor_td">
										附件(小于5M)
									</td>
									<td width='588' bgcolor='#ffffff'>
										<input type='file' size='55' name='affix'
											style='BORDER-TOP: 1px solid #7F9DB9; BORDER-LEFT: 1px solid #7F9DB9; BORDER-RIGHT: 1px solid #7F9DB9; BORDER-BOTTOM: 1px solid #7F9DB9;'
											style='400'>
										<input type='button' value='删除附件'
											style='BORDER-TOP: 1px solid #7F9DB9; BORDER-LEFT: 1px solid #7F9DB9; BORDER-RIGHT: 1px solid #7F9DB9; BORDER-BOTTOM: 1px solid #7F9DB9;'
											onclick=delelteTB('tb1','FileTable')>
									</td>
								</tr>
							</table>
						</code>
					</TD>
				</tr>
	       <tr >
				<td colspan="4" class="tb_bottom">
							<input id="submitButton" name="submitButton" type="submit" value="提交" />
	                        <input type="button" value="附件" title="单个文件小于5M，所有文件累加大小小于10M" onclick="javascript:addfj();"/>
	                        <input type="button" value="返回" onclick="window.location='${ctx}/pages/jxy/SsNotice/htadlist.do?<mytag:params includes="ec*,s*" type="queryStringUtf"/>'"/>
			    </td>
	        </tr>
	</table>
</s:form>

<script>

     function selectPerson(frm,displayName,hiddenName) {
	           window.showModalDialog('${ctx}/pages/SsDept/selectPerson.do?formName=' + frm.name + '&inputName='+displayName+'&hiddenName='+hiddenName+'&rootID=false&maxPatiNum=1&hiddenType=ID_SPLIT',frm,'dialogHeight:500px;dialogWidth:560px;center:yes');
       }
     	 function selectCyry(frm,displayName,hiddenName) {
	           window.showModalDialog('${ctx}/pages/SsDept/selectCyry.do?formName=' + frm.name + '&inputName='+displayName+'&hiddenName='+hiddenName+'&rootID=false&maxPatiNum=1&hiddenType=ID_SPLIT',frm,'dialogHeight:500px;dialogWidth:560px;center:yes');
       }
     function selectDept(frm,displayName,hiddenName) {
	           window.showModalDialog('${ctx}/pages/SsDept/selectDept.do?formName=' + frm.name + '&inputName='+displayName+'&hiddenName='+hiddenName+'&rootID=false&maxPatiNum=1&hiddenType=ID_SPLIT',frm,'dialogHeight:500px;dialogWidth:560px;center:yes');
       }
       
     function selectDeptCheckbox(frm,displayName,hiddenName) {
               window.showModalDialog('${ctx}/pages/SsDept/selectDeptCheckbox.do?formName=' + frm.name + '&inputName='+displayName+'&hiddenName='+hiddenName+'&rootID=false&maxPatiNum=50&hiddenType=ID_SPLIT',frm,'dialogHeight:500px;dialogWidth:560px;center:yes');
       }
       
     function selectMaxPerson(frm,displayName,hiddenName) {
            // var depttypeidValue = document.getElementById('depttypeid').value;

           window.showModalDialog('${ctx}/pages/SsDept/selectPerson.do?formName=' + frm.name + '&inputName='+displayName+'&hiddenName='+hiddenName+'&rootID=false&maxPatiNum=50&hiddenType=ID_SPLIT',frm,'dialogHeight:500px;dialogWidth:560px;center:yes');
             
       }   
	
	new Validation(document.forms[0],{onSubmit:true,onFormValidate : function(result,form) {
		var finalResult = result;
		
		//在这里添加自定义验证
		if(finalResult){
			var frm = document.forms[0];
			if(!checkFileUpload(frm,'GIF,JPG,JPEG,PNG,BMP',false))		 
			     finalResult = false;
		}
		if(finalResult){
			 if($F("issuescope") == "" && $F("participants") == ""){
			   alert("参与人员、发布范围请至少选择一项!");
			   finalResult = false;
			}
		}
		return disableSubmit(finalResult,'submitButton');
	}});

	    //添加附件
	var i=2;
	function addpic()
	{
	 if(i<4){
		  var pctb="<table border='0' id='pctb"+i+"' cellspacing='1' cellpadding='5' style='width:100%;margin:0px 0px 1px 0px;' align='center' bgcolor='#3A6EA5'><tr class='crosscolor_tr' bgcolor='#ffffff'><td width='10%' bgcolor='#D7F1F2'>图片(小于5M)</td><td width='588' bgcolor='#F4FDFD'><input type='file' size='55' name='upload' style=' BORDER-TOP: 1px solid #7F9DB9 ;BORDER-LEFT:1px solid #7F9DB9 ;BORDER-RIGHT: 1px solid #7F9DB9 ;BORDER-BOTTOM: 1px solid #7F9DB9 ;' style='400'>&nbsp;&nbsp;<input type='button' value='删除图片' style=' BORDER-TOP: 1px solid #7F9DB9 ;BORDER-LEFT:1px solid #7F9DB9;BORDER-RIGHT:1px solid #7F9DB9 ;BORDER-BOTTOM:1px solid #7F9DB9;' onclick=delelteTB('pctb"+i+"','PicTable')></td></tr></table>";
		  PicTable.insertAdjacentHTML("BeforeEnd",pctb);
		  i++;
	 }else{
	   alert("上传文件个数最多三个");
	   return false;
	 }
	}
	
	var k=2;
	function addfj()
	{
	 if(k<4){
		  var tb="<table border='0' id='tb"+k+"' cellspacing='0' cellpadding='0' style='width:100%;margin:0px 0px 0px 0px;' align='center' bgcolor='#ffffff'><tr class='crosscolor_tr' bgcolor='#ffffff'><td class='crosscolor_td'>附件(小于5M)</td><td width='588' bgcolor='#ffffff'><input type='file' size='55' name='affix' style=' BORDER-TOP: 1px solid #7F9DB9 ;BORDER-LEFT:1px solid #7F9DB9 ;BORDER-RIGHT: 1px solid #7F9DB9 ;BORDER-BOTTOM: 1px solid #7F9DB9 ;' style='400'><input type='button' value='删除附件' style=' BORDER-TOP: 1px solid #7F9DB9 ;BORDER-LEFT:1px solid #7F9DB9;BORDER-RIGHT:1px solid #7F9DB9 ;BORDER-BOTTOM:1px solid #7F9DB9;' onclick=delelteTB('tb"+k+"','FileTable')></td></tr></table>";
		 
		  FileTable.insertAdjacentHTML("BeforeEnd",tb);
		  k++;
	 }else{
	   alert("上传文件个数最多三个");
	   return false;
	 }
	}
	
	//删除附件
	function delelteTB(tbid,Tableobj)
	{
	  var obj = document.getElementById(tbid);
	   if(Tableobj=="PicTable"){
	     PicTable.removeChild(obj);
	     i--;
	   }
	   if(Tableobj=="FileTable"){
	     FileTable.removeChild(obj);
	     k--;
	  }
	 
	} 
	
	
	  



	   //检查上传物件 checkFileUpload(表单名称,档案类型,是否需要上传,档案大小,图片最小宽度,图片最小高度,图片最大宽度,图片最大高度,储存宽度的表单名称,储存高度的表单名称)
function checkFileUpload(form,extensions,requireUpload) {
  document.MM_returnValue = true;
  if (extensions != '') var re = new RegExp("\.(" + extensions.replace(/,/gi,"|") + ")$","i");
  for (var i = 0; i<form.elements.length; i++) {
    field = form.elements[i];
   
    if (field.type.toUpperCase() != 'FILE' || field.name.toUpperCase() != 'UPLOAD') continue;
    if (field.value == '') {
      if (requireUpload) {alert('请选取上传的文件！');document.MM_returnValue = false;field.focus();break;}
    } else {
      if(extensions != '' && !re.test(field.value)) {
         alert('图片文件不符合上传的类型！\n只有以下的类型才允许上传： ' + extensions + '。\n请依规定选取新的上传文件。');
        document.MM_returnValue = false;
        field.focus();
        break;
      }
   } 
 }
  return document.MM_returnValue;
    
}
	
 
    
</script>

</body>
</html>
