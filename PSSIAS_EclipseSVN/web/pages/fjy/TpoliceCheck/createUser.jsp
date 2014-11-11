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

<s:form action="/pages/fjy/TpoliceCheck/saveUser.do" theme="simple"  name="inputForm" method="post">
	<table cellpadding="0" cellspacing="0" border="1" class="tb_all">
	    <input type="hidden" name="returnUrl" value="!/pages/fjy/TpoliceCheck/listUser.do?<mytag:params includes="ec*,s*" type="queryStringUtf"/>" />
	      
	       <tr>
				<td colspan="4" class="tb_title"> 
							<%=TpoliceCheck.TABLE_ALIAS%>新增
			    </td>
		   </tr>
	        <tr class="crosscolor_tr">
                         
                          <td class="crosscolor_td">
			                    <FONT color="red">*</FONT>  <%=TpoliceCheck.ALIAS_ACCEPTCHECKNAME%>
		                  </td>
			              <td>
		                          
		                            <input type="text" class="required"   name="acceptchecknameXm" maxlength="0" value="<authz:authentication property="principal.userXm"/>"  class="max-length-30"/>
		                            <input type="hidden"  name="acceptcheckname" value="<authz:authentication property="principal.username"/>" />
		                            <input name="selectPersonButton" onclick="selectPerson(inputForm,'acceptchecknameXm','acceptcheckname')"   value="选择" type="button"> 
		                         
		                  
		                  </td>
		                   <td class="crosscolor_td">
			                      <%=TpoliceCheck.ALIAS_CHECKTIME%>
		                  </td>
			              <td>
			              <s:property value="%{model.checktimeString}" />
		                  <s:hidden name="checktimeString" value="%{model.checktimeString}"></s:hidden>
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                       <FONT color="red">*</FONT><%=TpoliceCheck.ALIAS_CHECKNAME%>
		                  </td>
			              <td>

		                            <input type="text" class="required"   name="checknameXm" maxlength="0" value=""  class="max-length-30"/>
		                            <input type="hidden"  name="checkname" value="" />
		                            <input name="selectPersonButton" onclick="selectPerson(inputForm,'checknameXm','checkname')"   value="选择" type="button"> 
		                         
		                  
		                  
		                  </td>
                          <td class="crosscolor_td">
			                      <%=TpoliceCheck.ALIAS_CHECKNAMEPHONE%>
		                  </td>
			              <td>
		                           <s:textfield label="%{@vs@ALIAS_CHECKNAMEPHONE}" key="checknamephone" value="%{model.checknamephone}"  cssClass="max-length-30" required="false" />
		                  </td>
                   </tr>
		           
	       <tr >
				<td colspan="4" class="tb_bottom">
							<input id="submitButton" name="submitButton" type="submit" value="保存" />
	                        <input type="button" value="返回" onclick="window.location='${ctx}/pages/fjy/TpoliceCheck/listUser.do?<mytag:params includes="ec*,s*" type="queryStringUtf"/>'"/>
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
</script>

</body>
</html>