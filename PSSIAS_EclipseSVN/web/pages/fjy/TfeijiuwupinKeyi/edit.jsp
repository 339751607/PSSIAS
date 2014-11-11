<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/commons/taglibs.jsp" %>
<%@page import="com.dyneinfo.fjy.model.*" %>
<%
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+request.getContextPath()+"/";
%>
<html>

<head>
	<%@ include file="/commons/meta.jsp" %>
	<base href="<%=basePath%>">
	<title><%=TfeijiuwupinKeyi.TABLE_ALIAS%>编辑</title>
</head>

<body onload="quickSelectInit()" >
<%@ include file="/commons/messages.jsp" %>

<s:form action="/pages/fjy/TfeijiuwupinKeyi/update.do"  theme="simple"  method="post">
	<table cellpadding="0" cellspacing="0" border="1" class="tb_all">
	    <input type="hidden" name="returnUrl" value="!/pages/fjy/TfeijiuwupinKeyi/list.do?<mytag:params includes="ec*,s*" type="queryStringUtf"/>" />
	       <s:hidden id="xh" name="xh" />
	        <s:hidden name="wupinxh" value="%{model.wupinxh}"></s:hidden>
	        <tr>
				      <td colspan="2" class="tb_title"> 
							<%=TfeijiuwupinKeyi.TABLE_ALIAS%>编辑
				     </td>
		    </tr>
	            <tr class="crosscolor_tr">
                         
                          <td class="crosscolor_td">
			                      <%=TfeijiuwupinKeyi.ALIAS_KEYIYUANYIN%>
		                  </td>
			              <td>
			              
			               <s:textarea label="%{@vs@ALIAS_KEYIYUANYIN}" rows="6" cols="55"
							key="keyiyuanyin" value="%{model.keyiyuanyin}" cssClass="max-length-100"
							required="false"></s:textarea>
							
							
		                           
		                  </td>
                   </tr>
	        <tr >
					 <td colspan="2" class="tb_bottom">
	                        <input id="submitButton" name="submitButton" type="submit" value="保存" />
	                        <input type="button" value="返回" onclick="window.location='${ctx}/pages/fjy/TfeijiuwupinKeyi/list.do?<mytag:params includes="ec*,s*" type="queryStringUtf"/>'"/>   
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