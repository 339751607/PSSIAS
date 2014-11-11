<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/commons/taglibs.jsp" %>
<%@ page import="java.io.*"%>
<%@ page import="java.sql.Blob,java.util.*"%>
<%@ page import="com.dyneinfo.fjy.model.*" %>
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

<s:form action="/pages/fjy/SsNotice/update.do"  theme="simple" name="inputForm"  method="post">
	<table cellpadding="0" cellspacing="0" border="1" class="tb_all">
	    <input type="hidden" name="returnUrl" value="!/pages/fjy/SsNotice/list.do?<mytag:params includes="ec*,s*" type="queryStringUtf"/>" />
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
			                      <FONT color="red">*</FONT><%=SsNotice.ALIAS_NOTICECONTENT%>
		                  </td>
			               <td colspan="3">
		                           <s:textarea label="%{@vs@ALIAS_NOTICECONTENT}" rows="6" cols="55"
							key="noticecontent" value="%{model.noticecontent}" cssClass="required max-length-3000"
							required="false"></s:textarea>
		                         
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                     有效期：
		                  </td>
			              <td colspan="3">
		                           <input value="${model.starttimeString}" onclick="WdatePicker({dateFmt:'<%=SsNotice.FORMAT_STARTTIME%>'})" id="starttimeString" name="starttimeString"  maxlength="0" class="required Wdate" />至
		                           <input value="${model.endtimeString}" onclick="WdatePicker({dateFmt:'<%=SsNotice.FORMAT_ENDTIME%>'})" id="endtimeString" name="endtimeString"  maxlength="0" class="required Wdate" />
		                  </td>
                   </tr>
                  <input type="hidden" name="depttypeid" value="E02" id="depttypeid">     

                   <tr class="crosscolor_tr">
                         
                          <td class="crosscolor_td">
			                     <FONT color="red">*</FONT><%=SsNotice.ALIAS_ISSUESCOPE%>
		                  </td>
			             <td colspan="3">
		                            <input type="text"  readonly size="80" name="issuescopeName" value="${model.issuescopeName}" class="required"  maxlength="0" value="" onclick="selectDeptCheckbox(inputForm,'issuescopeName','issuescope')"  />
		                            <input type="hidden"  name="issuescope" value="${model.issuescope}" />

		                  </td>
                   </tr>
                  <tr class="crosscolor_tr">
                    <td class="crosscolor_td">
			                      发布单位
		                  </td>
		                   <td colspan="3">
                   		 ${model.issuescopeName}
                   		 <input type="hidden"  name="sendunitid" value="${model.sendunitid}" />
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
			                      <%=SsNotice.ALIAS_CREATETIME%>
		                  </td>
			              <td >
		                           <input value="${model.createtimeString}" onclick="WdatePicker({dateFmt:'<%=SsNotice.FORMAT_CREATETIME%>'})" id="createtimeString" name="createtimeString"  maxlength="0" class="Wdate" />
		                  </td>

                   </tr>
                   <%
					if (list != null) {
						for (int i = 0; i < list.size(); i++) {
							Map results = (HashMap) list.get(i);
							String FILEID = (String) results.get("FILEID");
							
				%>
				<tr class="crosscolor_tr">
					   <td class="crosscolor_td">
						图片
					</td>
					<td colspan="3">
						<a href="javascript:editPict('<%=FILEID%>');">修改</a>
						&nbsp;&nbsp;&nbsp;
						<a href="javascript:deletePict('<%=FILEID%>');">删除</a>
						&nbsp;&nbsp;&nbsp;
						<a href="javascript:view('<%=FILEID%>');">查看</a>
					</td>
				</tr>
				<%
					    }
					}
				%>

				<%
					if (listfile != null) {
						for (int i = 0; i < listfile.size(); i++) {
							Map results = (HashMap) listfile.get(i);
							String FILEID = (String) results.get("FILEID");
				%>


				<tr class="crosscolor_tr">
					  <td class="crosscolor_td">
						附件
					</td>
					<td colspan="3"  >
						<a href="javascript:editFile('<%=FILEID%>');">修改</a>
						&nbsp;&nbsp;&nbsp;
						<a href="javascript:deleteFile('<%=FILEID%>');">删除</a>
						&nbsp;&nbsp;&nbsp;
						<a href="javascript:download('<%=FILEID%>');">下载</a>
					</td>
				</tr>

				<%
					     }
					 }
				%>
	        <tr >
	         <input type="hidden" name="state"   id="state"/>
					 <td colspan="4" class="tb_bottom">
	                        <input id="submitButton" name="submitButton" onclick="document.getElementById('state').value='1'"  type="submit" value="发送" />
	                        <input type="button" value="返回" onclick="window.location='${ctx}/pages/fjy/SsNotice/list.do?<mytag:params includes="ec*,s*" type="queryStringUtf"/>'"/>   
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
	           window.showModalDialog('${ctx}/pages/fjy/SsDept/selectPerson.do?formName=' + frm.name + '&inputName='+displayName+'&hiddenName='+hiddenName+'&rootID=false&maxPatiNum=1&hiddenType=ID_SPLIT',frm,'dialogHeight:500px;dialogWidth:560px;center:yes');
       }
       
     function selectDept(frm,displayName,hiddenName) {
	           window.showModalDialog('${ctx}/pages/fjy/SsDept/selectDept.do?formName=' + frm.name + '&inputName='+displayName+'&hiddenName='+hiddenName+'&rootID=false&maxPatiNum=1&hiddenType=ID_SPLIT',frm,'dialogHeight:500px;dialogWidth:560px;center:yes');
       }
       
     function selectDeptCheckbox(frm,displayName,hiddenName) {
             var depttypeidValue = document.getElementById('depttypeid').value;
             if(depttypeidValue != "" )
                window.showModalDialog("${ctx}/pages/fjy/SsDept/selectDeptCheckbox.do?deptTypeId='0','"+depttypeidValue+"'&formName=" + frm.name + "&inputName="+displayName+"&hiddenName="+hiddenName+"&rootID=false&maxPatiNum=50&hiddenType=ID_SPLIT",frm,"dialogHeight:500px;dialogWidth:560px;center:yes");
             else{
                alert("请先选择企业类型！");
                return false;
	            //window.showModalDialog('${ctx}/pages/fjy/SsDept/selectDeptCheckbox.do?formName=' + frm.name + '&inputName='+displayName+'&hiddenName='+hiddenName+'&rootID=false&maxPatiNum=3&hiddenType=ID_SPLIT',frm,'dialogHeight:500px;dialogWidth:450px;center:yes');
              }
       }
       
     function selectMaxPerson(frm,displayName,hiddenName) {
             var depttypeidValue = document.getElementById('depttypeid').value;
             if(depttypeidValue != "" )
                window.showModalDialog("${ctx}/pages/fjy/SsDept/selectPerson.do?deptTypeId='0','"+depttypeidValue+"'&formName=" + frm.name + "&inputName="+displayName+'&hiddenName='+hiddenName+"&rootID=false&maxPatiNum=50&hiddenType=ID_SPLIT",frm,"dialogHeight:500px;dialogWidth:560px;center:yes");
             else {
                alert("请先选择企业类型！");
                return false;
	           // window.showModalDialog('${ctx}/pages/fjy/SsDept/selectPerson.do?formName=' + frm.name + '&inputName='+displayName+'&hiddenName='+hiddenName+'&rootID=false&maxPatiNum=50&hiddenType=ID_SPLIT',frm,'dialogHeight:500px;dialogWidth:560px;center:yes');
              }
       }   
	
       
          function editPict(FILEID){
    	var url="";
    	url ="${ctx}/pages/fjy/SsNotice/editPictUpload.jsp?FILEID="+FILEID;
    	newwin = window.open(url,
						"picUpdate",
						"width=400,height=150,top=100,left=100,resizable=yes,status=yes,menubar=no,scrollbars=yes"); 
    } 
    
    function editFile(FILEID){
    	var url="";
    	url ="${ctx}/pages/fjy/SsNotice/editFileUpload.jsp?FILEID="+FILEID;
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
			  input_txt.value = "!/pages/fjy/SsNotice/edit.do?noticeid=<s:property value="%{model.noticeid}" />&<mytag:params includes="ec*,s*" type="queryStringUtf"/>";
			  form.appendChild(input_txt);
		      form.action = '${ctx}/pages/fjy/SsNotice/deletePict.do?FILEID='+FILEID;
	          form.submit(); 
	      }
    }
    
    function deleteFile(FILEID){
           if (confirm('确定执行[删除]操作?')){ 
              var form = document.forms.update;
              var input_txt = document.createElement("input");
			  input_txt.type = "hidden";
			  input_txt.name = "deleteReturnUrl";
			  input_txt.value = "!/pages/fjy/SsNotice/edit.do?noticeid=<s:property value="%{model.noticeid}" />&<mytag:params includes="ec*,s*" type="queryStringUtf"/>";
			  form.appendChild(input_txt);
		      form.action = '${ctx}/pages/fjy/SsNotice/deleteFile.do?FILEID='+FILEID;
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
</script>

</body>

</html>