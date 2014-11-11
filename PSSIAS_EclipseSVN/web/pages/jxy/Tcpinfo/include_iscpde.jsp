<%@ page import="com.dyneinfo.jxy.model.*" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/commons/taglibs.jsp" %>

<%

String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+request.getContextPath()+"/";
%>
<html>
<head>
	<%@ include file="/commons/meta.jsp" %>
	<base href="<%=basePath%>">
	<title><%=Tcpinfo.TABLE_ALIAS%>注册</title>
</head>
<body onload="quickSelectInit()" >
<%@ include file="/commons/messages.jsp" %>



 
<s:form action="/jxy/Tcpinfo/saveiscode.do" theme="simple" name="inputForm"   method="post">
	<table cellpadding="0" cellspacing="0" border="0" class="tb_all">
	    <input type="hidden" name="returnUrl" value="!/jxy/Tcpinfo/list.do?<mytag:params includes="ec*,s*" type="queryStringUtf"/>" />
	    <input type="hidden" name="cptype" id="cptype" value="E02"/>
	       <tr>
				<td colspan="4" class="tb_title"> 
							<%=Tcpinfo.TABLE_ALIAS%>授权
			    </td>
		   </tr>
	        <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                    <FONT color="red">*</FONT> 软件授权码
		                  </td>
			              <td >
		                            <s:textfield label="%{@vs@ALIAS_AREA}" key="iscode" value="%{model.iscode}" onkeyup="value=value.replace(/[^ A-Z0-9a-z.-]/g,'') " cssClass="required max-length-50 " required="false" />
		                  </td>
		                  <td class="crosscolor_td">
			                   	 读卡器授权码
		                  </td>
			              <td >
		                            <s:textfield label="%{@vs@ALIAS_AREA}" key="typecode" value="%{model.typecode}" onkeyup="value=value.replace(/[^ A-Z0-9a-z.-]/g,'') " cssClass=" max-length-50 " required="false" />
		                  </td>
		                  
		           </tr>
		               <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                    <FONT color="red">*</FONT> 扫描仪授权码
		                  </td>
			              <td >
		                            <s:textfield label="%{@vs@ALIAS_AREA}" key="smycode" value="%{model.smycode}" onkeyup="value=value.replace(/[^ A-Z0-9a-z.-]/g,'') " cssClass=" max-length-50 " required="false" />
		                  </td>  
		                  <td></td><td></td>   
		           </tr>
		          

                    <tr >
				<td colspan="4" class="tb_bottom">
				<input id="cp" name="cp" type="hidden" value="${cpcode}">
							<input id="submitButton" name="submitButton" type="submit" value="保存" />
	                        <input type="button" value="返回" onclick="window.location='${ctx}/jxy/Tcpinfo/list.do?<mytag:params includes="ec*,s*" type="queryStringUtf"/>'"/>
			    </td>
	        </tr>
	</table>
</s:form>

<script>

	
	new Validation(document.forms[0],{onSubmit:true,onFormValidate : function(result,form) {
		var finalResult = result;
		
		return disableSubmit(finalResult,'submitButton');
	}});
</script>

</body>
</html>
