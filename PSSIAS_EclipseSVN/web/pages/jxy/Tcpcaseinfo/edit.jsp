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
	<title><%=Tcpcaseinfo.TABLE_ALIAS%>编辑</title>
</head>

<body onload="quickSelectInit()" >
<%@ include file="/commons/messages.jsp" %>

<s:form action="/jxy/Tcpcaseinfo/update.do"  theme="simple"  method="post">
	<table cellpadding="0" cellspacing="0" border="0" class="tb_all">
	    <input type="hidden" name="returnUrl" value="!/jxy/Tcpcaseinfo/list.do?<mytag:params includes="ec*,s*" type="queryStringUtf"/>" />
	        <tr>
				      <td colspan="4" class="tb_title"> 
							<%=Tcpcaseinfo.TABLE_ALIAS%>编辑
				     </td>
		    </tr>
	             <s:hidden id="id" name="id" />

<!-- ONGL access static field: @package.class@field or @vs@field -->

		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                     <%=Tcpcaseinfo.ALIAS_CPCODE%>
		                  </td>
			              <td>
			              <s:property value="%{model.cpcode}"/>
			              <input type="hidden" name="cpcode" value="${model.cpcode}"/>
		                         
		                         
		                  </td>
                          <td class="crosscolor_td">
			                     <%=Tcpcaseinfo.ALIAS_CASECODE%>
		                  </td>
			              <td>
			              <s:property value="%{model.casecode}"/>
		                           
		                 <input type="hidden" name="casecode" value="${model.casecode}"/>
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
		            <td class="crosscolor_td">
			                      <%=Tcpcaseinfo.ALIAS_CASEFLAG%><font color="red">*</font>
		                  </td>
			              <td>
		                          
		                           <mytag:select dictName="DIC_ITEM_CASEFLAG" name="caseflag" property="%{model.caseflag}" styleClass="required validate-selection" notEmpty="false"></mytag:select>
		                  </td>
		           <td class="crosscolor_td">
			                      <%=Tcpcaseinfo.ALIAS_CASETYPE%><font color="red">*</font>
		                  </td>
			              <td>
		                          <mytag:select name="casetype" property="%{model.casetype}"  notEmpty="false"  styleClass="required validate-selection" dictName="Diccon_AJ"></mytag:select>
		                  </td>
                         
                         
                   </tr>
                   
		           <tr class="crosscolor_tr">
		            <td class="crosscolor_td">
			                      <%=Tcpcaseinfo.ALIAS_HAPPENTIME%><font color="red">*</font>
		                  </td>
			              <td>
			              			 <input value="${model.happentime}" onclick="WdatePicker({dateFmt:'<%=Tcpcaseinfo.FORMAT_STARTTIME%>',maxDate:'${date}'})"  name="happentime"  cssClass="required " class="required Wdate" />
		                  </td>
                          
                         
                   </tr>
                   <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=Tcpcaseinfo.ALIAS_CASEDESC%>
		                  </td>
			              <td colspan="3" align="left" >
			                <s:textarea style="margin-left: 10px" label="%{@vs@ALIAS_CASEDESC}" rows="6" cols="55"
							key="casedesc" value="%{model.casedesc}" cssClass="max-length-200"
							required="false"></s:textarea>
		                         
		                       
		                  </td>
                   </tr>
		         
	        <tr >
					 <td colspan="4" class="tb_bottom">
	                        <input id="submitButton" name="submitButton" type="submit" value="提交" />
	                        <input type="button" value="返回" onclick="window.location='${ctx}/jxy/Tcpcaseinfo/list.do?<mytag:params includes="ec*,s*" type="queryStringUtf"/>'"/>   
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
