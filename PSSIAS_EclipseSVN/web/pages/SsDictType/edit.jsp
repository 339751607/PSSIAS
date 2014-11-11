<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/commons/taglibs.jsp" %>
<%@page import="com.dyneinfo.zazh.model.*" %>
<%
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+request.getContextPath()+"/";
%>
<html>

<head>
	<%@ include file="/commons/meta.jsp" %>
	<base href="<%=basePath%>">
	<title><%=SsDictType.TABLE_ALIAS%>编辑</title>
</head>

<body onload="quickSelectInit()" >
<%@ include file="/commons/messages.jsp" %>

<s:form action="/pages/SsDictType/update.do"  theme="simple"  method="post">
	  <table width="100%" border="1" bordercolor="#7c8ca7" align="center"  cellPadding="0" cellSpacing="0" class="tb_all">
	    <input type="hidden" name="returnUrl" value="!/pages/SsDictType/list.do?<mytag:params includes="ec*,s*" type="queryStringUtf"/>" />
	        <tr>
				      <td colspan="4" class="tb_title"> 
							<%=SsDictType.TABLE_ALIAS%>编辑
				     </td>
		    </tr>
	           <tr class="crosscolor_tr">
		                  <td class="crosscolor_td">
			                      <FONT color="red">*</FONT><%=SsDictType.ALIAS_DICTTYPEID%>
		                  </td>
			              <td>
			               <s:hidden name="dicttypeids" value="%{model.dicttypeid}"></s:hidden>
			                 <s:property value="%{model.dicttypeid}" />
		                          
		                  </td>
                          <td class="crosscolor_td">
			                      <FONT color="red">*</FONT><%=SsDictType.ALIAS_DICTTYPENAME%>
		                  </td>
			              <td>
		                           <s:textfield label="%{@vs@ALIAS_DICTTYPENAME}" key="dicttypename" value="%{model.dicttypename}" cssClass="required max-length-255" required="false" />
		                  </td>
                        
                   </tr>
		         
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=SsDictType.ALIAS_DICTFLAG%>
		                  </td>
			              <td>
						           <mytag:select property="%{model.dictflag}"   styleClass="required validate-selection"  name="dictflag"   notEmpty="false"  dictName="dictflag"/>
		                  </td>
                          <td class="crosscolor_td">
			                      <%=SsDictType.ALIAS_QUERYSQL%>
		                  </td>
			              <td>
		                           <s:textfield label="%{@vs@ALIAS_QUERYSQL}" key="querysql" value="%{model.querysql}" cssClass="max-length-255" required="false" />
		                  </td>
                   </tr>
	        <tr >
					 <td colspan="4" class="tb_bottom">
	                        <input id="submitButton" name="submitButton" type="submit" value="提交" />
	                        <input type="button" value="返回" onclick="window.location='${ctx}/pages/SsDictType/list.do?<mytag:params includes="ec*,s*" type="queryStringUtf"/>'"/>   
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