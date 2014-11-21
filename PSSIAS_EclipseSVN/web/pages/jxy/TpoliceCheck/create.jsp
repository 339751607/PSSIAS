<%@page import="com.dyneinfo.jxy.model.*" %>
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
<body onload="quickSelectInit()">
<%@ include file="/commons/messages.jsp" %>

<s:form action="/pages/jxy/TpoliceCheck/save.do" theme="simple" name="inputForm"  method="post">
	<table cellpadding="0" cellspacing="0" border="0" class="tb_all">
	    <input type="hidden" name="returnUrl" value="!/pages/jxy/TpoliceCheck/list.do?<mytag:params includes="ec*,s*" type="queryStringUtf"/>" />
	       <tr>
				<td colspan="4" class="tb_title"> 
							<%=TpoliceCheck.TABLE_ALIAS%>新增
			    </td>
		   </tr>
	  <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=TpoliceCheck.ALIAS_DEPTID%>
		                  </td>
			              <td colspan="3">
		                           
		                            <input type="text"  maxlength="0"  name="deptname" maxlength="0" value=""  class="required max-length-60"/>
		                            <input type="hidden"  name="deptid" value="" />
		                            <input name="selectPersonButton" onclick="selectDept(inputForm,'deptname','deptid')"   value="选择" type="button"><FONT color="red">*</FONT>
		                         
		                  </td>
                   </tr>
		          <tr class="crosscolor_tr">
		            	 <td class="crosscolor_td">
			                      <%=TpoliceCheck.ALIAS_ACCEPTCHECKNAME%>
		                  </td>
			              <td>
		                         <s:textfield label="%{@vs@ALIAS_ACCEPTCHECKNAME}"  id="acceptcheckname" name="acceptcheckname"  cssClass="required max-length-30" required="false" value="%{model.acceptcheckname}" class="required max-length-30"  /><FONT color="red">*</FONT>
		                  </td>
                          <td class="crosscolor_td">
			                      <%=TpoliceCheck.ALIAS_CHECKNAME%>
		                  </td>
			              <td>
		         
		                         <input name="checkname" value="<authz:authentication property='principal.userXm'/>" Class="required max-length-30" required="false" /><FONT color="red">*</FONT>
		                  </td>

                   </tr>
                    <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
                             <%=TpoliceCheck.ALIAS_CHECKNAMEPHONE%>
                          </td>
                          <td>
		                           <s:textfield label="%{@vs@ALIAS_CHECKNAMEPHONE}" key="checknamephone" value="%{model.checknamephone}" cssClass="required max-length-30" required="false" /><FONT color="red">*</FONT>
		                  </td>
		                     <td class="crosscolor_td">
			                      <%=TpoliceCheck.ALIAS_CHECKTIME%>
		                  </td>
			              <td>
		                           <input value="${model.checktimeString}" onclick="WdatePicker({dateFmt:'<%=TpoliceCheck.FORMAT_CHECKTIME%>'})" id="checktimeString" name="checktimeString"  maxlength="0" class="required Wdate" /><FONT color="red">*</FONT>
		                  </td>
                   	</tr>
                   	
                   	  <tr class="crosscolor_tr">
                          
                          <td class="crosscolor_td">
			                      <%=TpoliceCheckinfo.ALIAS_ITEM%>
		                  </td>
			              <td colspan="3">
						           <mytag:select property="%{model.item}"   styleClass="required validate-selection"  name="item"   notEmpty="false"  dictName="checkItem"/><FONT color="red">*</FONT>
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=TpoliceCheckinfo.ALIAS_DETAIL%>
		                  </td>
			              <td colspan="3">
		                        
		                         <s:textarea label="%{@vs@ALIAS_DETAIL}" rows="6" cols="55"
							key="detail" value="%{model.detail}" cssClass="required max-length-1024"
							required="false"></s:textarea><FONT color="red">*</FONT>
		                     
		                  </td>
                         
                   </tr>

	       <tr >
				<td colspan="4" class="tb_bottom">
							<input id="submitButton" name="submitButton" type="submit" value="提交" />
	                        <input type="button" value="返回" onclick="window.location='${ctx}/pages/jxy/TpoliceCheck/list.do?<mytag:params includes="ec*,s*" type="queryStringUtf"/>'"/>
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
	           window.showModalDialog('${ctx}/pages/SsDept/selectDeptForPoliceCheck.do?fzrName=acceptcheckname&formName=' + frm.name + '&inputName='+displayName+'&hiddenName='+hiddenName+'&rootID=false&maxPatiNum=1&hiddenType=ID_SPLIT',frm,'dialogHeight:500px;dialogWidth:560px;center:yes');
       }  
</script>

</body>
</html>
