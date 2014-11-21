<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/commons/taglibs.jsp" %>
<%@page import="com.dyneinfo.jxy.model.*" %>
<%
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+request.getContextPath()+"/";
%>
<html>

<head>
	<%@ include file="/commons/meta.jsp" %>
	<base href="<%=basePath%>">
	<title><%=Tempworklog.TABLE_ALIAS%>编辑</title>
</head>

<body onload="quickSelectInit()" >
<%@ include file="/commons/messages.jsp" %>

<s:form action="/pages/jxy/Tempworklog/update.do"  theme="simple" name="inputForm"  method="post">
	<table cellpadding="0" cellspacing="0" border="0" class="tb_all">
	    <input type="hidden" name="returnUrl" value="!/pages/jxy/Tempworklog/list.do?<mytag:params includes="ec*,s*" type="queryStringUtf"/>" />
	      	<s:hidden id="worklogid" name="worklogid" />
	      	<s:hidden name="empcode" value="%{model.empcode}"></s:hidden>
	        <tr>
				      <td colspan="4" class="tb_title"> 
							<%=Tempworklog.TABLE_ALIAS%>编辑
				     </td>
		    </tr>
	              <tr class="crosscolor_tr">
                          
                          <td class="crosscolor_td">
			                      <%=Tempworklog.ALIAS_CPNAME%>
		                  </td>
			              <td>
		                          <s:property value="%{model.cpname}" />
		                           <s:hidden name="cpcode" value="%{model.cpcode}"></s:hidden>		                
		                  </td>
		                  <td class="crosscolor_td">
			                      <FONT color="red">*</FONT><%=Tempworklog.ALIAS_EMPTYPE%>
		                  </td>
			              <td>
						           <mytag:select property="%{model.emptype}"   styleClass="required validate-selection"  name="emptype"   notEmpty="false"  dictName="T_DIC_EMPTYPE"/>
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <FONT color="red">*</FONT><%=Tempworklog.ALIAS_INDATE%>
		                  </td>
			              <td>
						          <s:property value="%{model.indate}" />
						           <s:hidden name="indate" value="%{model.indate}"></s:hidden>	
		                  </td>
							<td class="crosscolor_td">
			                      <%=Tempworklog.ALIAS_LEFTDATE%>
		                  </td>
			              <td>
						           <s:property value="%{model.leftdate}" />
						            <s:hidden name="leftdate" value="%{model.leftdate}"></s:hidden>	
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          
                          <td class="crosscolor_td">
			                      <%=Tempworklog.ALIAS_DEMO%>
		                  </td>
			              <td colspan="3">
		                             <s:textarea label="%{@vs@ALIAS_DEMO}" rows="4" cols="100"
							key="demo" value="%{model.demo}" cssClass="max-length-200"
							required="false"></s:textarea>
		                  </td>
                   </tr>
	        <tr >
					 <td colspan="4" class="tb_bottom">
	                        <input id="submitButton" name="submitButton" type="submit" value="提交" />
	                        <input type="button" value="返回" onclick="window.location='${ctx}/pages/jxy/Tempworklog/list.do?<mytag:params includes="ec*,s*" type="queryStringUtf"/>'"/>   
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
	
	  function selectDept(frm,displayName,hiddenName) {
	           window.showModalDialog('${ctx}/pages/SsDept/selectDept.do?formName=' + frm.name + '&inputName='+displayName+'&hiddenName='+hiddenName+'&rootID=true&maxPatiNum=3&hiddenType=ID_SPLIT',frm,'dialogHeight:500px;dialogWidth:560px;center:yes');
       }
</script>

</body>

</html>
