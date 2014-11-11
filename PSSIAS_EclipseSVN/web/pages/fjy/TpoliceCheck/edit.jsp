<%@page import="com.dyneinfo.fjy.model.*" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/commons/taglibs.jsp" %>
<%@ taglib prefix="authz" uri="http://www.springframework.org/security/tags" %>
<%
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+request.getContextPath()+"/";
%>
<html>

<head>
	<%@ include file="/commons/meta.jsp" %>
	<base href="<%=basePath%>">
	<title><%=TpoliceCheck.TABLE_ALIAS%>编辑</title>
</head>

<body onload="quickSelectInit()" >
<%@ include file="/commons/messages.jsp" %>

<s:form action="/pages/fjy/TpoliceCheck/update.do" name="inputForm" theme="simple"  method="post">
	<table cellpadding="0" cellspacing="0" border="1" class="tb_all">
	    <input type="hidden" name="returnUrl" value="!/pages/fjy/TpoliceCheck/list.do?<mytag:params includes="ec*,s*" type="queryStringUtf"/>" />
	       	<s:hidden id="checkid" name="checkid" />
	        <tr>
				      <td colspan="4" class="tb_title"> 
							<%=TpoliceCheck.TABLE_ALIAS%>编辑
				     </td>
		    </tr>
	           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <FONT color="red">*</FONT> <%=TpoliceCheck.ALIAS_DEPTID%>
		                  </td>
			              <td>
		                           <s:textfield label="%{@vs@ALIAS_DEPTID}"  maxlength="0"  key="deptname" value="%{model.deptname}"   required="false" />
		                            <s:hidden name="deptid" value="%{model.deptid}"></s:hidden> 
		                            <input name="selectPersonButton" onclick="selectDept(inputForm,'deptname','deptid')"   value="选择" type="button"> 
		                         
		                  </td>
                          <td class="crosscolor_td">
			                      <FONT color="red">*</FONT> <%=TpoliceCheck.ALIAS_ACCEPTCHECKNAME%>
		                  </td>
			              <td>
		                         
		                   <s:textfield label="%{@vs@ALIAS_ACCEPTCHECKNAME}" maxlength="0" key="acceptchecknameXm" value="%{model.acceptchecknameXm}"  cssClass="max-length-30" required="false" />
		                            <s:hidden name="acceptcheckname" value="%{model.acceptcheckname}"></s:hidden> 
		                            <input name="selectPersonButton" onclick="selectPerson(inputForm,'acceptchecknameXm','acceptcheckname')"   value="选择" type="button"> 
		                         
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <FONT color="red">*</FONT> <%=TpoliceCheck.ALIAS_CHECKNAME%>
		                  </td>
			              <td>
		                          <s:textfield label="%{@vs@ALIAS_CHECKNAME}" maxlength="0" key="checknameXm" value="%{model.checknameXm}"  cssClass="max-length-30" required="false" />
										<s:hidden name="checkname" value="%{model.checkname}"></s:hidden> 
		                           
		                            <input name="selectPersonButton" onclick="selectPerson(inputForm,'checknameXm','checkname')"   value="选择" type="button"> 
		                         
		                  </td>
                          <td class="crosscolor_td">
			                      <%=TpoliceCheck.ALIAS_CHECKNAMEPHONE%>
		                  </td>
			              <td>
		                           <s:textfield label="%{@vs@ALIAS_CHECKNAMEPHONE}" key="checknamephone" value="%{model.checknamephone}"  cssClass="max-length-30" required="false" />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <FONT color="red">*</FONT> <%=TpoliceCheck.ALIAS_CHECKTIME%>
		                  </td>
			              <td>
		                           <input value="${model.checktimeString}" onclick="WdatePicker({dateFmt:'<%=TpoliceCheck.FORMAT_CHECKTIME%>'})" id="checktimeString" name="checktimeString"  maxlength="0" class="required Wdate" />
		                  </td>
                          <td>&nbsp;</td>
                          <td>&nbsp;</td>
                   </tr>
	        <tr >
					 <td colspan="4" class="tb_bottom">
	                        <input id="submitButton" name="submitButton" type="submit" value="保存" />
	                        <input type="button" value="返回" onclick="window.location='${ctx}/pages/fjy/TpoliceCheck/list.do?<mytag:params includes="ec*,s*" type="queryStringUtf"/>'"/>   
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
	           window.showModalDialog('${ctx}/pages/fjy/SsDept/selectDept.do?formName=' + frm.name + '&inputName='+displayName+'&hiddenName='+hiddenName+'&idValueIsSeq=false&rootID=false&maxPatiNum=1&hiddenType=ID_SPLIT',frm,'dialogHeight:500px;dialogWidth:560px;center:yes');
       }  
</script>

</body>

</html>