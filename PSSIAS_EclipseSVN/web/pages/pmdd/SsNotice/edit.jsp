<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/commons/taglibs.jsp" %>
<%@ page import="java.io.*"%>
<%@ page import="java.sql.Blob,java.util.*"%>
<%@ page import="com.dyneinfo.pmdd.model.*" %>
<%
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+request.getContextPath()+"/";
	List list = (List) request.getAttribute("listpic");
	List listfile = (List) request.getAttribute("listfile");
%>
<html>

<head>
	<%@ include file="/commons/meta.jsp" %>
	<base href="<%=basePath%>">
	<title><%=SsNotice.TABLE_ALIAS%>编辑</title>
</head>

<body onload="quickSelectInit()" >
<%@ include file="/commons/messages.jsp" %>
<s:form action="/pages/pmdd/SsNotice/update.do"  enctype="multipart/form-data"  theme="simple" name="inputForm"  method="post">

	<table cellpadding="0" cellspacing="0" border="0" class="tb_all">
	    <input type="hidden" name="returnUrl" value="!/pages/pmdd/SsNotice/htadlist.do?<mytag:params includes="ec*,s*" type="queryStringUtf"/>" />
	    <s:hidden id="noticeid" name="noticeid" />
	        <tr>
				      <td colspan="4" class="tb_title"> 
							<%=SsNotice.TABLE_ALIAS%>编辑
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
			                      <%=SsNotice.ALIAS_NOTICECONTENT%>
		                  </td>
			               <td colspan="3">
		                           <s:textarea label="%{@vs@ALIAS_NOTICECONTENT}" rows="6" cols="55"
							key="noticecontent" value="%{model.noticecontent}" cssClass="max-length-3000"
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
		                           <input value="${model.endtimeString}" onclick="WdatePicker({dateFmt:'<%=SsNotice.FORMAT_ENDTIME%>'})" id="endtimeString" name="endtimeString"  maxlength="0" class="required Wdate" />
		                  </td>
                   </tr> 
                    <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=SsNotice.ALIAS_PARTICIPANTS%>
		                  </td>
			              <td colspan="3">
		                          
		                            <s:textfield  key="participantsName" size="80" value="%{model.participantsName}"  cssClass=" " required="false" />
		                            <s:hidden name="participants" value="%{model.participants}"></s:hidden>
		                            <input name="selectparticipantsName" onclick="selectMaxPerson(inputForm,'participantsName','participants')"   value="选择" type="button"> 
		                         
		                  </td>
                         
                   </tr>
                   <tr class="crosscolor_tr">
                         
                          <td class="crosscolor_td">
			                      <%=SsNotice.ALIAS_ISSUESCOPE%>
		                  </td>
			             <td colspan="3">
		                           
		                            <s:textfield  key="issuescopeName" size="80" value="%{model.issuescopeName}"  cssClass=" " required="false" />
		                            <s:hidden name="issuescope" value="%{model.issuescope}"></s:hidden>
		                            <input name="selectparticipantsName" onclick="selectDeptMul(inputForm,'issuescopeName','issuescope')"   value="选择" type="button"> 
		                         
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                     <FONT color="red">*</FONT>  <%=SsNotice.ALIAS_AUTHORID%>
		                  </td>
			              <td>
		                          
		                          <s:textfield  key="authorname" value="%{model.authorname}"  cssClass="required max-length-60 " maxlength="0" required="false" />
		                          <s:hidden name="authorid" value="%{model.authorid}"></s:hidden>
		                           <input name="selectPersonButton" onclick="selectPerson(inputForm,'authorname','authorid')"   value="选择" type="button"> 
		                         
		                  </td>
                           <td class="crosscolor_td">
			                     <FONT color="red">*</FONT>  <%=SsNotice.ALIAS_SENDUNITID%>
		                  </td>
			              <td>
		                           
		                           <s:textfield  key="sendunitname" value="%{model.sendunitname}"  cssClass="required max-length-60 " maxlength="0" required="false" />
		                           <s:hidden name="sendunitid" value="%{model.sendunitid}"></s:hidden>
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
		                           <input value="${model.createtimeString}" onclick="WdatePicker({dateFmt:'<%=SsNotice.FORMAT_CREATETIME%>'})" id="createtimeString" name="createtimeString"  maxlength="0" class="Wdate" />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                    <FONT color="red">*</FONT>   <%=SsNotice.ALIAS_ISREPLY%>
		                  </td>
			              <td>
						           <mytag:select property="%{model.isreply}"   styleClass="required validate-selection"  name="isreply"   notEmpty="false"  dictName="shiFou"/>
		                  </td>
                        
                         
                          <td class="crosscolor_td">
			                      <%=SsNotice.ALIAS_SORTNO%>
		                  </td>
			              <td>
		                           <s:textfield label="%{@vs@ALIAS_SORTNO}" key="sortno" value="%{model.sortno}"  cssClass="validate-number " required="false" />
		                  </td>
                   </tr>
				<%
					if (listfile != null) {
						for (int i = 0; i < listfile.size(); i++) {
							Map results = (HashMap) listfile.get(i);
							String FILEID = (String) results.get("FILEID");
							String FILENAME = (String) results.get("FILENAME");
				%>
				<tr class="crosscolor_tr">
					<td>
						附件
					</td>
					<td >
						<%=FILENAME %>&nbsp;&nbsp;&nbsp;
					</td>
					<td colspan="2" align="left" >
						<a href="javascript:deleteFile('<%=FILEID%>');">删除</a>
						&nbsp;&nbsp;&nbsp;
						<a href="javascript:download('<%=FILEID%>');">下载</a>
					</td>
				</tr>
				<%
					     }
					 }
					 if (listfile.size()<3) {
				%>
			
			<tr class="crosscolor_tr">
					<TD width="100%" class="crosscolor_td" colSpan="8">
						<code id="FileTable">
							<table border='0' id='tb1' cellspacing='0' cellpadding='0'
								style='width: 100%; margin: 0px 0px 1px 0px;' align='center'
								bgcolor='#3A6EA5'>
								<tr bgcolor='#ffffff' class="crosscolor_tr">
									<td width='10%' bgcolor='#D7F1F2'>
										附件(小于5M)
									</td>
									<td width='588' bgcolor='#F4FDFD'>
										<input type='file' size='55' name='affix'
											style='BORDER-TOP: 1px solid #484848; BORDER-LEFT: 1px solid #484848; BORDER-RIGHT: 1px solid #484848; BORDER-BOTTOM: 1px solid #484848;'
											style='400'>
										<input type='button' value='删除附件'
											style='BORDER-TOP: 1px solid #484848; BORDER-LEFT: 1px solid #484848; BORDER-RIGHT: 1px solid #484848; BORDER-BOTTOM: 1px solid #484848;'
											onclick=delelteTB('tb1','FileTable')>
									</td>
								</tr>
							</table>
						</code>
					</TD>
				</tr>
	       <tr >
	       	<%
	       	}
	       	 %>
	        <tr >
					 <td colspan="4" class="tb_bottom">
						 	<input type="button" value="附件" title="单个文件小于5M，所有文件累加大小小于10M" onclick="javascript:addfj();"/>
	                        <input id="submitButton" name="submitButton" type="submit" value="提交" />
	                        <input type="button" value="返回" onclick="window.location='${ctx}/pages/pmdd/SsNotice/htadlist.do?<mytag:params includes="ec*,s*" type="queryStringUtf"/>'"/>   
					 </td>
			</tr>
	</table>
</s:form>

<script>
	
	new Validation(document.forms[0],{onSubmit:true,onFormValidate : function(result,form) {
		var finalResult = result;
		
		//在这里添加自定义验证
		
		return disableSubmit(finalResult,'submitButton');
	}});
	
	 function selectPerson(frm,displayName,hiddenName) {
	           window.showModalDialog('${ctx}/pages/SsDept/selectPerson.do?formName=' + frm.name + '&inputName='+displayName+'&hiddenName='+hiddenName+'&rootID=false&maxPatiNum=1&hiddenType=ID_SPLIT',frm,'dialogHeight:500px;dialogWidth:560px;center:yes');
       }
       
     function selectDept(frm,displayName,hiddenName) {
	           window.showModalDialog('${ctx}/pages/SsDept/selectDept.do?formName=' + frm.name + '&inputName='+displayName+'&hiddenName='+hiddenName+'&rootID=false&maxPatiNum=1&hiddenType=ID_SPLIT',frm,'dialogHeight:500px;dialogWidth:560px;center:yes');
       }
         
     function selectDeptMul(frm,displayName,hiddenName) {
	           window.showModalDialog('${ctx}/pages/SsDept/selectDept.do?idValueIsSeq=false&formName=' + frm.name + '&inputName='+displayName+'&hiddenName='+hiddenName+'&rootID=false&maxPatiNum=50&hiddenType=ID_SPLIT',frm,'dialogHeight:500px;dialogWidth:560px;center:yes');
     }    
       
     function selectDeptCheckbox(frm,displayName,hiddenName) {
        window.showModalDialog('${ctx}/pages/SsDept/selectDeptCheckbox.do?formName=' + frm.name + '&inputName='+displayName+'&hiddenName='+hiddenName+'&rootID=false&maxPatiNum=50&hiddenType=ID_SPLIT',frm,'dialogHeight:500px;dialogWidth:560px;center:yes');
       }
       
     function selectMaxPerson(frm,displayName,hiddenName) {
         window.showModalDialog('${ctx}/pages/SsDept/selectPerson.do?formName=' + frm.name + '&inputName='+displayName+'&hiddenName='+hiddenName+'&rootID=false&maxPatiNum=50&hiddenType=ID_SPLIT',frm,'dialogHeight:500px;dialogWidth:560px;center:yes');
       }   
       
      function editPict(FILEID){
    	var url="";
    	url ="${ctx}/pages/pmdd/SsNotice/editPictUpload.jsp?FILEID="+FILEID;
    	newwin = window.open(url,
						"picUpdate",
						"width=400,height=150,top=100,left=100,resizable=yes,status=yes,menubar=no,scrollbars=yes"); 
    } 
    
    function editFile(FILEID){
    	var url="";
    	url ="${ctx}/pages/pmdd/SsNotice/editFileUpload.jsp?FILEID="+FILEID;
    	newwin = window.open(url,
						"fileUpdate",
						"width=400,height=150,top=100,left=100,resizable=yes,status=yes,menubar=no,scrollbars=yes,alwaysRaised=no"); 
		//window.showModalDialog('',frm,'dialogHeight:500px;dialogWidth:450px;center:yes');
    } 
 
    var k=Number("<%=listfile.size()%>")+2;   
    function deletePict(FILEID){
          if (confirm('确定执行[删除]操作?')){ 
              var form = document.forms.update;
              var input_txt = document.createElement("input");
			  input_txt.type = "hidden";
			  input_txt.name = "deleteReturnUrl";
			  input_txt.value = "!/pages/pmdd/SsNotice/edit.do?noticeid=<s:property value="%{model.noticeid}" />&<mytag:params includes="ec*,s*" type="queryStringUtf"/>";
			  form.appendChild(input_txt);
		      form.action = '${ctx}/pages/pmdd/SsNotice/deletePict.do?FILEID='+FILEID;
		      k--;
	          form.submit(); 
	      }
    }
    
    function deleteFile(FILEID){
           if (confirm('确定执行[删除]操作?')){ 
              var form = document.forms.update;
              var input_txt = document.createElement("input");
			  input_txt.type = "hidden";
			  input_txt.name = "deleteReturnUrl";
			  input_txt.value = "!/pages/pmdd/SsNotice/edit.do?noticeid=<s:property value="%{model.noticeid}" />&<mytag:params includes="ec*,s*" type="queryStringUtf"/>";
			  form.appendChild(input_txt);
		      form.action = '${ctx}/pages/pmdd/SsNotice/deleteFile.do?FILEID='+FILEID;
	          form.submit();      
	       } 
    }
    		
    function view(FILEID){
    	var url="";
    	url ="${ctx}/pages/FileAttach/pictShow.do?FILEID="+FILEID;
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

	function addfj()
	{
	 if(k<4){
		  var tb="<table border='0' id='tb"+k+"' cellspacing='1' cellpadding='5' style='width:100%;margin:0px 0px 1px 0px;' align='center' bgcolor='#3A6EA5'><tr class='crosscolor_tr' bgcolor='#ffffff'><td width='10%' bgcolor='#D7F1F2'>附件(小于5M)</td><td width='588' bgcolor='#F4FDFD'><input type='file' size='55' name='affix' style=' BORDER-TOP: 1px solid #484848 ;BORDER-LEFT:1px solid #484848 ;BORDER-RIGHT: 1px solid #484848 ;BORDER-BOTTOM: 1px solid #484848 ;' style='400'>&nbsp;&nbsp;<input type='button' value='删除附件' style=' BORDER-TOP: 1px solid #484848 ;BORDER-LEFT:1px solid #484848;BORDER-RIGHT:1px solid #484848 ;BORDER-BOTTOM:1px solid #484848;' onclick=delelteTB('tb"+k+"','FileTable')></td></tr></table>";
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
	   if(Tableobj=="FileTable"){
	     FileTable.removeChild(obj);
	     k--;
	  }
	 
	} 
</script>

</body>

</html>