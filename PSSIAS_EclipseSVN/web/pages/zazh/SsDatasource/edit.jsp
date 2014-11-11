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
	<title><%=SsDatasource.TABLE_ALIAS%>编辑</title>
</head>

<body onload="quickSelectInit()" >
<%@ include file="/commons/messages.jsp" %>

<s:form action="/pages/zazh/SsDatasource/update.do"  theme="simple"  method="post">
	<table width="100%" border="1" bordercolor="#7c8ca7" align="center"  cellPadding="0" cellSpacing="0" class="tb_all">
	    <input type="hidden" name="returnUrl" value="!/pages/zazh/SsDatasource/list.do?<mytag:params includes="ec*,s*" type="queryStringUtf"/>" />
	        <tr>
				      <td colspan="4" class="tb_title"> 
							行业数据源编辑
				     </td>
		    </tr>
	              
	        <s:hidden id="id" name="id" />

<!-- ONGL access static field: @package.class@field or @vs@field -->

		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=SsDatasource.ALIAS_CODE%>
		                  </td>
			              <td>
			                   <mytag:write property="%{model.code}"   
			                    name="code"  dictName="T_ITEM_BUSSINESS"/>
		                  
		                  </td>
                          <td class="crosscolor_td">
			                      <%=SsDatasource.ALIAS_CALLED%>
		                  </td>
			              <td>     
			                      <s:property value="%{model.called}" />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">	
		                  <td class="crosscolor_td">
			                      <%=SsDatasource.ALIAS_DBS_NAME%>
		                  </td>
			              <td>     
			                      <s:property value="%{model.dbsName}" />
		                  </td>                     	
		                  <td class="crosscolor_td">
			                      数据库IP：
		                  </td>
			              <td>
		                           <input type="text"  id="dbIP" name="dbIP" value='<s:property value="#request.dbIP" />'  class="required max-length-20" required="false" />
		                  </td>
                   </tr>
                   <tr class="crosscolor_tr">		                  
                          <td class="crosscolor_td">
			                     数据库端口：
		                  </td>
			              <td>
		                           <input type="text"  id="dbPort" name="dbPort" value='<s:property value="#request.dbPort" />' class="required max-length-10" />
		                  </td>
                          <td class="crosscolor_td">
			                  数据库服务名：    
		                  </td>
			              <td>
		                            <input type="text"  id="dbServ" name="dbServ" value='<s:property value="#request.dbServ" />'  class="required max-length-30" required="false" />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=SsDatasource.ALIAS_DBS_USERNAME%>
		                  </td>
			              <td>
		                           <s:textfield label="%{@vs@ALIAS_DBS_USERNAME}" key="dbsUsername" value="%{model.dbsUsername}"  cssClass="required max-length-100" required="false" />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=SsDatasource.ALIAS_DBS_PASSWORD%>
		                  </td>
			              <td>
		                           <s:textfield label="%{@vs@ALIAS_DBS_PASSWORD}" key="dbsPassword" value="%{model.dbsPassword}"  cssClass="required max-length-100" required="false" />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=SsDatasource.ALIAS_DBS_DRIVERCLASSNAME%>
		                  </td>
			              <td>
		                           <s:textfield label="%{@vs@ALIAS_DBS_DRIVERCLASSNAME}" key="dbsDriverclassname" value="%{model.dbsDriverclassname}"  cssClass="required max-length-100" size="30" required="false" />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=SsDatasource.ALIAS_ISVALID%>
		                  </td>
			              <td>
			                 <mytag:select property="%{model.isvalid}"   styleClass="required validate-selection"  name="isvalid"   notEmpty="false"  dictName="T_DICT_VALID"/>
		                  </td>
                   </tr>
                   <!--  
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=SsDatasource.ALIAS_EXTEND1%>
		                  </td>
			              <td>
		                           <s:textfield label="%{@vs@ALIAS_EXTEND1}" key="extend1" value="%{model.extend1}"  cssClass="max-length-100" required="false" />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=SsDatasource.ALIAS_EXTEND2%>
		                  </td>
			              <td>
		                           <s:textfield label="%{@vs@ALIAS_EXTEND2}" key="extend2" value="%{model.extend2}"  cssClass="max-length-100" required="false" />
		                  </td>
                   </tr>
                  -->
	        <tr >
					 <td colspan="4" class="tb_bottom">
	                        <input id="submitButton" name="submitButton" type="submit" value="提交" />
	                        <input type="button" value="返回" onclick="window.location='${ctx}/pages/zazh/SsDatasource/list.do?<mytag:params includes="ec*,s*" type="queryStringUtf"/>'"/>   
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