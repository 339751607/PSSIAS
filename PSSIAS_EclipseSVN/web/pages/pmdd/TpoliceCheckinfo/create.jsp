<%@page import="com.dyneinfo.pmdd.model.*" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/commons/taglibs.jsp" %>
<%
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+request.getContextPath()+"/";
String s_checkid = "";
if (request.getParameter("s_checkid") != null)
	s_checkid = request.getParameter("s_checkid");
%>
<html>
<head>
	<%@ include file="/commons/meta.jsp" %>
	<base href="<%=basePath%>">
	<title><%=TpoliceCheckinfo.TABLE_ALIAS%>新增</title>
</head>
<body onload="quickSelectInit()">
<%@ include file="/commons/messages.jsp" %>

<s:form action="/pages/pmdd/TpoliceCheckinfo/save.do" theme="simple"  method="post">
	<table cellpadding="0" cellspacing="0" border="0" class="tb_all">
	    <input type="hidden" name="returnUrl" value="!/pages/pmdd/TpoliceCheckinfo/list.do?<mytag:params includes="ec*,s*" type="queryStringUtf"/>" />
	        <input type="hidden" value="<%=s_checkid%>"  name="checkid"  />
	       <tr>
				<td colspan="2" class="tb_title"> 
							<%=TpoliceCheckinfo.TABLE_ALIAS%>新增
			    </td>
		   </tr>
	           <tr class="crosscolor_tr">
                          
                          <td class="crosscolor_td">
			                      <%=TpoliceCheckinfo.ALIAS_ITEM%>
		                  </td>
			              <td>
						           <mytag:select property="%{model.item}"   styleClass="required validate-selection"  name="item"   notEmpty="false"  dictName="checkItem"/><FONT color="red">*</FONT>
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=TpoliceCheckinfo.ALIAS_DETAIL%>
		                  </td>
			              <td>
		                        
		                         <s:textarea label="%{@vs@ALIAS_DETAIL}" rows="6" cols="55"
							key="detail" value="%{model.detail}" cssClass="required max-length-1024"
							required="false"></s:textarea><FONT color="red">*</FONT>
		                     
		                  </td>
                         
                   </tr>
	       <tr >
				<td colspan="2" class="tb_bottom">
							<input id="submitButton" name="submitButton" type="submit" value="提交" />
	                        <input type="button" value="返回" onclick="window.location='${ctx}/pages/pmdd/TpoliceCheckinfo/list.do?<mytag:params includes="ec*,s*" type="queryStringUtf"/>'"/>
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