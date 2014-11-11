<%@ page import="com.dyneinfo.fjy.model.*" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/commons/taglibs.jsp" %>
<%
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+request.getContextPath()+"/";
%>
<html>

<head>
	<%@ include file="/commons/meta.jsp" %>
	<base href="<%=basePath%>">
	<title><%=User.TABLE_ALIAS%>编辑</title>
</head>

<body onload="quickSelectInit()" >
<%@ include file="/commons/messages.jsp" %>

<s:form action="/pages/fjy/User/update.do"  theme="simple"  method="post">
	<table cellpadding="0" cellspacing="0" border="1" class="tb_all">
	    <input type="hidden" name="returnUrl" value="!/pages/fjy/User/list.do?<mytag:params includes="ec*,s*" type="queryStringUtf"/>" />
	       <s:hidden id="userid" name="userid" />
	        <tr>
				      <td colspan="4" class="tb_title"> 
							<%=User.TABLE_ALIAS%>编辑
				     </td>
		    </tr>
	           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                     <%=User.ALIAS_USERNAME%>
		                  </td>
			              <td colspan="3">
		                          <s:property value="%{model.username}" />
		                  </td>
                         
                   </tr>
                   
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                   <FONT color="red">*</FONT>   <%=User.ALIAS_FULLNAME%>
		                  </td>
			              <td>
		                           <s:textfield label="%{@vs@ALIAS_FULLNAME}" key="fullname" value="%{model.fullname}"  cssClass="required max-length-128" required="false" />
		                  </td>
                          <td class="crosscolor_td">
			                     <FONT color="red">*</FONT> <%=User.ALIAS_SEX%>
		                  </td>
			              <td>
		                         
		                            <mytag:select property="%{model.sex}"
							styleClass="required validate-selection" name="sex"
							notEmpty="false" dictName="T_DIC_SEX" />
		                  
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                     <FONT color="red">*</FONT> <%=User.ALIAS_SFZH%>
		                  </td>
			              <td>
		                           <s:textfield label="%{@vs@ALIAS_SFZH}" key="sfzh" value="%{model.sfzh}" onblur="javascript:showBirthday();"   cssClass="required max-length-200 validate-id-number" required="false" />
		                  </td>
                          <td class="crosscolor_td">
			                     <FONT color="red">*</FONT> <%=User.ALIAS_ENABLED%>
		                  </td>
			              <td>
		                             <mytag:select property="%{model.enabled}" styleClass="required validate-selection" name="enabled" notEmpty="false" dictName="status" />
		                 
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=User.ALIAS_PHONE%>
		                  </td>
			              <td>
		                           <s:textfield label="%{@vs@ALIAS_PHONE}" key="phone" value="%{model.phone}"  cssClass="max-length-32" required="false" />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=User.ALIAS_MOBILE%>
		                  </td>
			              <td>
		                           <s:textfield label="%{@vs@ALIAS_MOBILE}" key="mobile" value="%{model.mobile}"  cssClass="max-length-32" required="false" />
		                  </td>
                   </tr>
                    <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=User.ALIAS_FAX%>
		                  </td>
			              <td>
		                           <s:textfield label="%{@vs@ALIAS_FAX}" key="fax" value="%{model.fax}"  cssClass="max-length-32" required="false" />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=User.ALIAS_ZIP%>
		                  </td>
			              <td>
		                           <s:textfield label="%{@vs@ALIAS_ZIP}" key="zip" value="%{model.zip}"  cssClass="max-length-32" required="false" />
		                  </td>
                         
                   </tr>
		           <tr class="crosscolor_tr">
                          
                          <td class="crosscolor_td">
			                      <%=User.ALIAS_ADDRESS%>
		                  </td>
			              <td colspan="3">
		                           <s:textfield label="%{@vs@ALIAS_ADDRESS}" size="75" key="address" value="%{model.address}"  cssClass="max-length-64" required="false" />
		                  </td>
                   </tr>
					<tr class="crosscolor_tr">
						<td>
							<FONT color="red">*</FONT>角色
						</td>
						<td colspan="3">
							<s:checkboxlist value="selectList" listKey="roleid"
								listValue="roledesc" list="rolemap" name="roles" />
						</td>
					</tr>
	        <tr >
					 <td colspan="4" class="tb_bottom">
	                        <input id="submitButton" name="submitButton" type="submit" value="保存" />
	                        <input type="button" value="返回" onclick="window.location='${ctx}/pages/fjy/User/list.do?<mytag:params includes="ec*,s*" type="queryStringUtf"/>'"/>   
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