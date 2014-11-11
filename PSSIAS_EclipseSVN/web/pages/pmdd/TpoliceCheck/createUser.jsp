<%@page import="com.dyneinfo.pmdd.model.*" %>
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
<body>
<%@ include file="/commons/messages.jsp" %>

<s:form action="/pages/pmdd/TpoliceCheck/saveUser.do" theme="simple"  name="inputForm" method="post">
	<table cellpadding="0" cellspacing="0" border="0" class="tb_all">
	    <input type="hidden" name="returnUrl" value="!/pages/pmdd/TpoliceCheck/listUser.do?<mytag:params includes="ec*,s*" type="queryStringUtf"/>" />
	      
	       <tr>
				<td colspan="4" class="tb_title"> 
							<%=TpoliceCheck.TABLE_ALIAS%>新增
			    </td>
		   </tr>
	        <tr class="crosscolor_tr">
                         
                        <td class="crosscolor_td">
			                      <%=TpoliceCheck.ALIAS_DEPTID%>
		                  </td>
			              <td>
		                         <authz:authentication property="principal.deptName"/>
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
			                      <%=TpoliceCheck.ALIAS_ACCEPTCHECKNAME%>
		                  </td>
			              <td>
		                         <input type="text"  name="acceptcheckname"  cssClass="required max-length-30" required="false" value="<authz:authentication property='principal.userXm'/>" class="required max-length-30"  /><FONT color="red">*</FONT>
		                  </td>
                          <td class="crosscolor_td">
			                      <%=TpoliceCheck.ALIAS_CHECKNAME%>
		                  </td>
			              <td>
		         
		                         <s:textfield label="%{@vs@ALIAS_CHECKNAME}" key="checkname" value="%{model.checkname}" cssClass="required max-length-30" required="false" /><FONT color="red">*</FONT>
		                  </td>

                   </tr>
                    <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
                             <%=TpoliceCheck.ALIAS_CHECKNAMEPHONE%>
                          </td>
                          <td>
		                           <s:textfield label="%{@vs@ALIAS_CHECKNAMEPHONE}" key="checknamephone" value="%{model.checknamephone}" cssClass="required max-length-30" required="false" /><FONT color="red">*</FONT>
		                  </td>
                   	</tr>
		           
	       <tr >
				<td colspan="4" class="tb_bottom">
							<input id="submitButton" name="submitButton" type="submit" value="提交" />
	                        <input type="button" value="返回" onclick="window.location='${ctx}/pages/pmdd/TpoliceCheck/listUser.do?<mytag:params includes="ec*,s*" type="queryStringUtf"/>'"/>
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
</script>

</body>
</html>