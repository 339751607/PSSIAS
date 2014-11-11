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
	<title><%=Tcppunishinfo.TABLE_ALIAS%>编辑</title>
</head>

<body onload="quickSelectInit()" >
<%@ include file="/commons/messages.jsp" %>

<s:form action="/jxy/Tcppunishinfo/update.do"  theme="simple"  method="post">
	<table cellpadding="0" cellspacing="0" border="0" class="tb_all">
	    <input type="hidden" name="returnUrl" value="!/jxy/Tcppunishinfo/list.do?<mytag:params includes="ec*,s*" type="queryStringUtf"/>" />
	        <tr>
				      <td colspan="4" class="tb_title"> 
							<%=Tcppunishinfo.TABLE_ALIAS%>编辑
				     </td>
		    </tr>
	                        <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <FONT color="red">*</FONT><%=Tcppunishinfo.ALIAS_CPCODE%>
		                  </td>
			              <td>
			              <input type="hidden" name="cpcode" value="${model.cpcode}"/>
			              <s:property value="%{model.cpcode}"/>
		                          
		                 			
		                  </td>
                          <td class="crosscolor_td">
			                      <FONT color="red">*</FONT><%=Tcppunishinfo.ALIAS_PDATE%>
		                  </td>
			              <td>
		                        
		                  <input value="${model.pdate}" onclick="WdatePicker({dateFmt:'yyyy-MM-dd',maxDate:'${date}'})"   name="pdate" id="pdate" class="required Wdate" />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <FONT color="red">*</FONT><%=Tcppunishinfo.ALIAS_PFILENO%>
		                  </td>
			              <td>
			              <input type="hidden" name="pfileno" value="${model.pfileno}"/>
			              <s:property value="%{model.pfileno}"/>
		                           
		                  </td>
                          <td class="crosscolor_td">
			                      <FONT color="red">*</FONT><%=Tcppunishinfo.ALIAS_AUTHUNIT%>
		                  </td>
			              <td>
		                          
		                           <mytag:select property="%{model.authunit}" name="authunit" styleClass="required validate-selection" notEmpty="false" dictName="ssfj"></mytag:select>
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=Tcppunishinfo.ALIAS_AUTHPERSON%>
		                  </td>
			              <td>
		                           <s:textfield label="%{@vs@ALIAS_AUTHPERSON}" key="authperson" value="%{model.authperson}"  cssClass="max-length-30" required="false" />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=Tcppunishinfo.ALIAS_EXECPERSON%>
		                  </td>
			              <td>
		                           <s:textfield label="%{@vs@ALIAS_EXECPERSON}" key="execperson" value="%{model.execperson}"  cssClass="max-length-30" required="false" />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
 <td class="crosscolor_td">
			                      <%=Tcppunishinfo.ALIAS_PPERSON%>
		                  </td>
			              <td>
		                           <s:textfield label="%{@vs@ALIAS_PPERSON}" key="pperson" value="%{model.pperson}"  cssClass="max-length-30" required="false" />
		                  </td>
                          <td class="crosscolor_td">
			                      <FONT color="red">*</FONT><%=Tcppunishinfo.ALIAS_PTYPE%>
		                  </td>
			              <td>
		                          
		                 			<mytag:select property="%{model.ptype}" name="ptype" notEmpty="false" styleClass="required validate-selection" dictName="Diccon_cf"></mytag:select>
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=Tcppunishinfo.ALIAS_RANGE%>
		                  </td>
			              <td>
		                           <s:textfield label="%{@vs@ALIAS_RANGE}" key="range" value="%{model.range}"  cssClass="max-length-50" required="false" />
		                  </td>
                         
                   </tr>
                   <tr class="crosscolor_tr">
                    <td class="crosscolor_td">
			                       <FONT color="red">*</FONT><%=Tcppunishinfo.ALIAS_CAUSE%>
		                  </td>
                    <td colspan="3">
			                <s:textarea label="%{@vs@ALIAS_CASEDESC}" rows="6" cols="55"
							key="cause" value="%{model.cause}" cssClass="required max-length-200"
							required="false"></s:textarea>
		                         
		                       
		                  </td>
                   </tr>
	        <tr >
					 <td colspan="4" class="tb_bottom">
	                        <input id="submitButton" name="submitButton" type="submit" value="提交" />
	                        <input type="button" value="返回" onclick="window.location='${ctx}/jxy/Tcppunishinfo/list.do?<mytag:params includes="ec*,s*" type="queryStringUtf"/>'"/>   
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
