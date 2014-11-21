<%@ page contentType="text/html;charset=UTF-8" %>
<%@page import="com.dyneinfo.jxy.model.*" %>
<%@ include file="/commons/taglibs.jsp" %>
<%
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+request.getContextPath()+"/";
%>
<html>

<head>
	<%@ include file="/commons/meta.jsp" %>
	<base href="<%=basePath%>">
	<title><%=Tcpnsjl.TABLE_ALIAS%>编辑</title>
</head>

<body onload="quickSelectInit()" >
<%@ include file="/commons/messages.jsp" %>

<s:form action="/pages/jxy/Tcpnsjl/update.do"  theme="simple"  method="post">
	<table cellpadding="0" cellspacing="0" border="0" class="tb_all">
	    <input type="hidden" name="returnUrl" value="!/pages/jxy/Tcpnsjl/list.do?<mytag:params includes="ec*,s*" type="queryStringUtf"/>" />
	        <tr>
				      <td colspan="4" class="tb_title"> 
							<%=Tcpnsjl.TABLE_ALIAS%>编辑
				     </td>
		    </tr>
	             
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <FONT color="red">*</FONT><%=Tcpnsjl.ALIAS_CPCODE%>
		                  </td>
			              <td>
			              <s:property value="%{model.cpcode}"/>
		                           <input type="hidden" value="${model.cpcode}" name="cpcode">
		                 
						 </td>
                          <td class="crosscolor_td">
			                      <FONT color="red">*</FONT><%=Tcpnsjl.ALIAS_SHND%>
		                  </td>
			              <td>
			              <input type="hidden" value="${shnd}" name="sh">
			               <select name="shnd">
			               
                  <s:iterator var="counter" begin="2001" end="2030" > <option value="${counter}" ${shnd == counter?'selected':""}>${counter}</option> </s:iterator> 
                  </select>
		                        
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <FONT color="red">*</FONT><%=Tcpnsjl.ALIAS_SHRJ%>
		                  </td>
			              <td>
		                          
		                 <input value="${model.shrj}" onclick="WdatePicker({dateFmt:'yyyy-MM-dd',maxDate:'${date}'})"  name="shrj" id="shrj" class="required Wdate" />
		                 
		                  </td>
                        
                   </tr>
                   <tr class="crosscolor_tr">
                   <td class="crosscolor_td">
			                      <FONT color="red">*</FONT><%=Tcpnsjl.ALIAS_NSYJ%>
		                  </td>
                    <td colspan="3">
			                <s:textarea label="%{@vs@ALIAS_CASEDESC}" rows="6" cols="55"
							key="nsyj" value="%{model.nsyj}" cssClass="required max-length-3000"
							required="false"></s:textarea>
		                         
		                       
		                  </td>
                   
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                     <FONT color="red">*</FONT> <%=Tcpnsjl.ALIAS_QSR%>
		                  </td>
			              <td>
			            
		                           <s:textfield label="%{@vs@ALIAS_QSR}" key="qsr" value="%{model.qsr}"  cssClass="required validate-chinese" required="false" />
		                  </td>
                          <td class="crosscolor_td">
			                     <FONT color="red">*</FONT> <%=Tcpnsjl.ALIAS_JBR%>
		                  </td>
			              <td>
		                           <s:textfield label="%{@vs@ALIAS_JBR}" key="jbr" value="%{model.jbr}"  cssClass="required validate-chinese" required="false" />
		                  </td>
                   </tr>
                   <tr class="crosscolor_tr">
                   
                   </tr>
 
	        <tr >
					 <td colspan="4" class="tb_bottom">
	                        <input id="submitButton" name="submitButton" type="submit" value="提交" />
	                        <input type="button" value="返回" onclick="window.location='${ctx}/pages/jxy/Tcpnsjl/list.do?<mytag:params includes="ec*,s*" type="queryStringUtf"/>'"/>   
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
