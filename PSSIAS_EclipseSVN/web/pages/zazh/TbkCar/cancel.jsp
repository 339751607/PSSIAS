<%@page import="com.dyneinfo.zazh.model.*" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/commons/taglibs.jsp" %>
<%
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+request.getContextPath()+"/";
%>
<html>
<head>
	<%@ include file="/commons/meta.jsp" %>
	<base href="<%=basePath%>">
	<title>撤销布控</title>
</head>
<body>
<%@ include file="/commons/messages.jsp" %>

<s:form action="/pages/zazh/TbkCar/saveCancel.do" theme="simple"  method="post">
	<table width="100%" border="1" bordercolor="#7c8ca7" align="center"  cellPadding="0" cellSpacing="0" class="tb_all">
	    <input type="hidden" name="returnUrl" value="!/pages/zazh/TbkCar/list.do?<mytag:params includes="ec*,s*" type="queryStringUtf"/>" />
	       <tr>
				<td colspan="4" class="tb_title"> 
							撤销布控
			    </td>
		   </tr>
	<s:hidden id="id" name="id" />
       
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=TbkCar.ALIAS_CANCELFLAG%>
		                  </td>
			              <td>
			                       <input type="hidden" name="cancelflag" value="1" />
		                           撤销布控
		                  </td>
                          <td class="crosscolor_td">
			                      <%=TbkCar.ALIAS_CANCELTIME%>
		                  </td>
			              <td>
			              <s:property value="#request.nowtime" />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
  
                          <td class="crosscolor_td">
			                      <%=TbkCar.ALIAS_CANCELNAME%>
		                  </td>
			              <td>
			                      <s:property value="%{model.cancelname}" />
		                  </td>
		                  <td class="crosscolor_td">
			                     
		                  </td>
			              <td>		                           
		                  </td>
                   </tr>
                 <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=TbkCar.ALIAS_CANCELCAUSE%>
		                  </td>
			              <td colspan="3">
		                           <s:textarea label="%{@vs@ALIAS_CANCELCAUSE}" key="cancelcause"  cssClass="required max-length-200" required="false"
									value="%{model.cancelcause}" rows="6" cols="60"></s:textarea><FONT color="red">*</FONT>
		                  </td>
                       
                   </tr>             
 

	       <tr >
				<td colspan="4" class="tb_bottom">
							<input id="submitButton" name="submitButton" type="submit" value="提交" />
	                        <input type="button" value="返回" onclick="window.location='${ctx}/pages/zazh/TbkCar/list.do?<mytag:params includes="ec*,s*" type="queryStringUtf"/>'"/>
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