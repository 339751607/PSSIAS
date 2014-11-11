<%@page import="com.dyneinfo.pmdd.model.*" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/commons/taglibs.jsp" %>
<%
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+request.getContextPath()+"/";
%>
<html>

<head>
	<%@ include file="/commons/meta.jsp" %>
	<base href="<%=basePath%>">
	<title><%=ThotelBsQa.TABLE_ALIAS%>编辑</title>
</head>

<body onload="quickSelectInit()" >
<%@ include file="/commons/messages.jsp" %>

<s:form action="/pages/pmdd/ThotelBsQa/update.do"  theme="simple"  method="post">
	<table cellpadding="0" cellspacing="0" border="0" class="tb_all">
	    <input type="hidden" name="returnUrl" value="!/pages/pmdd/ThotelBsQa/htadlist.do?<mytag:params includes="ec*,s*" type="queryStringUtf"/>" />
	    	<s:hidden id="xh" name="xh" />
	        <tr>
				      <td colspan="4" class="tb_title"> 
							<%=ThotelBsQa.TABLE_ALIAS%>编辑
				     </td>
		    </tr>
	        <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=ThotelBsQa.ALIAS_DWMC%>
		                  </td>
			              <td>
		                          <s:property value="%{model.dwmc}" />
		                  </td>
                          <td class="crosscolor_td">
			                     <%=ThotelBsQa.ALIAS_USERNAME%>
		                  </td>
			              <td>
		                           <s:property value="%{model.username}" /> 
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
		                 <td class="crosscolor_td">
			                      <%=ThotelBsQa.ALIAS_WTFL%>
		                  </td>
			              <td>
		                            <mytag:write property="%{model.wtfl}"   name="wtfl"  notEmpty="true"  dictName="wtfl"/>
		                  </td>
                          <td class="crosscolor_td">
			                      <%=ThotelBsQa.ALIAS_WTSJ%>
		                  </td>
			              <td>
		                           <s:property value="%{model.wtsj}" />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=ThotelBsQa.ALIAS_USERTEL%>
		                  </td>
			              <td colspan="3" >
			              <s:property value="%{model.usertel}" />
		                  </td>
		             </tr>
		            <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=ThotelBsQa.ALIAS_WTNR%>
		                  </td>
			              <td colspan="3" >
		                           <s:property value="%{model.wtnr}" />
		                           
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <FONT color="red">*</FONT><%=ThotelBsQa.ALIAS_JDBZ%>
		                  </td>
			              <td>
		                        <mytag:select property="%{model.jdbz}"  styleClass="required validate-selection"  name="jdbz"   notEmpty="false"  dictName="jdbz"/>
		                  </td>
                          <td class="crosscolor_td">
			                      <FONT color="red">*</FONT><%=ThotelBsQa.ALIAS_FLAG%>
		                  </td>
			              <td>
		                       <mytag:select property="%{model.flag}"   styleClass="required validate-selection"  name="flag"   notEmpty="false"  dictName="shiFou"/>
		                  </td>
                   </tr>
                   	 <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                       <FONT color="red">*</FONT><%=ThotelBsQa.ALIAS_JDNR%>
		                  </td>
			              <td  colspan="3"> 
		                            <s:textarea label="%{@vs@ALIAS_JDNR}" rows="8" cols="80"
							key="jdnr" value="%{model.jdnr}" cssClass="required max-length-200"
							required="false"></s:textarea>
		                  </td>

                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=ThotelBsQa.ALIAS_NOTE%>
		                  </td>
			              <td colspan="3">
		                            <s:textarea label="%{@vs@ALIAS_NOTE}" rows="4" cols="80"
							key="note" value="%{model.note}" cssClass="max-length-60"
							required="false"></s:textarea>
		                  </td>
                   </tr>
	        <tr >
					 <td colspan="4" class="tb_bottom">
	                        <input id="submitButton" name="submitButton" type="submit" value="提交" />
	                        <input type="button" value="返回" onclick="window.location='${ctx}/pages/pmdd/ThotelBsQa/htadlist.do?<mytag:params includes="ec*,s*" type="queryStringUtf"/>'"/>   
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