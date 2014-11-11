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
	<title><%=TpoliceCheck.TABLE_ALIAS%>新增</title>
</head>
<body onload="quickSelectInit()" >
<%@ include file="/commons/messages.jsp" %>

<s:form action="/pages/fjy/TpoliceCheck/save.do" theme="simple" name="inputForm"  method="post">
	<table cellpadding="0" cellspacing="0" border="1" class="tb_all">
	    <input type="hidden" name="returnUrl" value="!/pages/fjy/TpoliceCheck/list.do?<mytag:params includes="ec*,s*" type="queryStringUtf"/>" />
	       <tr>
				<td colspan="4" class="tb_title"> 
							<%=TpoliceCheck.TABLE_ALIAS%>新增
			    </td>
		   </tr>
	  <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                     <FONT color="red">*</FONT> <%=TpoliceCheck.ALIAS_DEPTID%>
		                  </td>
			              <td>
		                           
		                            <input type="text" class="required" maxlength="0"  name="deptname" maxlength="0" value=""  class="max-length-60"/>
		                            <input type="hidden"  name="deptid" value="" />
		                            <input name="selectPersonButton" onclick="selectDept(inputForm,'deptname','deptid')"   value="选择" type="button"> 
		                         
		                  
		                  </td>
                          <td class="crosscolor_td">
			                    <FONT color="red">*</FONT>  <%=TpoliceCheck.ALIAS_ACCEPTCHECKNAME%>
		                  </td>
			              <td>
		                            <input type="text" class="required"  maxlength="0" name="acceptchecknameXm" maxlength="0" value=""  class="max-length-30"/>
		                            <input type="hidden"  name="acceptcheckname" value="" />
		                            <input name="selectPersonButton" onclick="selectPerson(inputForm,'acceptchecknameXm','acceptcheckname')"   value="选择" type="button"> 
		                         
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <FONT color="red">*</FONT><%=TpoliceCheck.ALIAS_CHECKNAME%>
		                  </td>
			              <td>
		                              <input type="text" class="required"  maxlength="0"  name="checknameXm" maxlength="0" value="<authz:authentication property="principal.userXm"/>"  class="max-length-30"/>
		                            <input type="hidden"  name="checkname" value="<authz:authentication property="principal.username"/>" />
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
			                    <FONT color="red">*</FONT>  <%=TpoliceCheck.ALIAS_CHECKTIME%>
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
	           window.showModalDialog('${ctx}/pages/fjy/SsDept/selectDept.do?random=' + Math.random() + '&formName=' + frm.name + '&inputName='+displayName+'&hiddenName='+hiddenName+'&idValueIsSeq=false&rootID=false&maxPatiNum=1&hiddenType=ID_SPLIT',frm,'dialogHeight:500px;dialogWidth:560px;center:yes');
       }  
</script>

</body>
</html>