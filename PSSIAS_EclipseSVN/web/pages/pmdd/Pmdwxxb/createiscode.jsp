<%@ page import="com.dyneinfo.pmdd.model.*" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/commons/taglibs.jsp" %>
<%
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+request.getContextPath()+"/";
%>
<html>
<head>
	<%@ include file="/commons/meta.jsp" %>
	<base href="<%=basePath%>">
	<title><%=Pmdwxxb.TABLE_ALIAS%>新增</title>
</head>
<body onload="quickSelectInit()">
<%@ include file="/commons/messages.jsp" %>

<s:form action="/pages/pmdd/Pmdwxxb/saveiscode.do" theme="simple"  method="post">
	<table cellpadding="0" cellspacing="0" border="0" class="tb_all">
	    <input type="hidden" name="returnUrl" value="!/pages/pmdd/Pmdwxxb/list.do?<mytag:params includes="ec*,s*" type="queryStringUtf"/>" />
	       <tr>
				<td colspan="4" class="tb_title"> 
							企业授权
			    </td>
		   </tr>
	        <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                    <FONT color="red">*</FONT> 软件授权码
		                  </td>
			              <td >
		                            <s:textfield label="%{@vs@ALIAS_AREA}" key="iscode" value="%{mo	del.iscode}"  cssClass="required max-length-50 " required="false" />
		                  </td>
		                                            <td class="crosscolor_td">
			                   	 读卡器授权码
		                  </td>
			              <td >
		                            <s:textfield label="%{@vs@ALIAS_AREA}" key="typecode" value="%{model.typecode}"  cssClass=" max-length-50 " required="false" />
		                  </td>
		                  
		           </tr>
		               <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                     扫描仪授权码
		                  </td>
			              <td >
		                            <s:textfield label="%{@vs@ALIAS_AREA}" key="smycode" value="%{model.smycode}"  cssClass=" max-length-50 " required="false" />
		                  </td>     
		           </tr>
		          

                    <tr >
				<td colspan="4" class="tb_bottom">
				<input id="cp" name="cp" type="hidden" value="${cpcode}">
				<input id="code" name="code" type="hidden" value="${model.dwbm}">
				
							<input id="submitButton" name="submitButton" type="submit" value="保存" />
	                        <input type="button" value="返回" onclick="javascript:window.history.go(-1);"/>
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