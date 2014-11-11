<%@page import="com.dyneinfo.jxy.model.*" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/commons/taglibs.jsp" %>
<%
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+request.getContextPath()+"/";
%>
<html>

<head>
	<%@ include file="/commons/meta.jsp" %>
	<base href="<%=basePath%>">
	<title><%=TpoliceCheckinfo.TABLE_ALIAS%>编辑</title>
</head>

<body onload="quickSelectInit()" >
<%@ include file="/commons/messages.jsp" %>

<s:form action="/jxy/TpoliceCheckinfo/update.do"  theme="simple"  method="post">
	<table cellpadding="0" cellspacing="0" border="0" class="tb_all">
	    <input type="hidden" name="returnUrl" value="!/jxy/TpoliceCheckinfo/list.do?<mytag:params includes="ec*,s*" type="queryStringUtf"/>" />
	       <s:hidden id="checkinfoid" name="checkinfoid" />
	        <tr>
				      <td colspan="2" class="tb_title"> 
							<%=TpoliceCheckinfo.TABLE_ALIAS%>编辑
				     </td>
		    </tr>
	         <tr class="crosscolor_tr">
                        
                          <td class="crosscolor_td">
			                      <%=TpoliceCheckinfo.ALIAS_ITEM%>
		                  </td>
			              <td>
						           <mytag:select property="%{model.item}"   styleClass="required validate-selection"  name="item"   notEmpty="false"  dictName="checkItem"/>
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=TpoliceCheckinfo.ALIAS_DETAIL%>
		                  </td>
			              <td>
		                          
		                         <s:textarea label="%{@vs@ALIAS_DETAIL}" rows="6" cols="55"
							key="detail" value="%{model.detail}" cssClass="max-length-1024"
							required="false"></s:textarea>
		                  </td>
                          
                   </tr>
	        <tr >
					 <td colspan="2" class="tb_bottom">
	                        <input id="submitButton" name="submitButton" type="submit" value="提交" />
	                        <input type="button" value="返回" onclick="window.location='${ctx}/jxy/TpoliceCheckinfo/list.do?<mytag:params includes="ec*,s*" type="queryStringUtf"/>'"/>   
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
</script>

</body>

</html>
