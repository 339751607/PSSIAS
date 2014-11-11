<%@page import="${basepackage}.model.*" %>
<#include "/macro.include"/> 
<#include "/custom.include"/> 
<#assign className = table.className>   
<#assign classNameLower = className?uncap_first>
<#assign actionExtension = "do"> 
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/commons/taglibs.jsp" %>
<%
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+request.getContextPath()+"/";
%>
<html>

<head>
	<%@ include file="/commons/meta.jsp" %>
	<base href="<%=basePath%>">
	<title><%=${className}.TABLE_ALIAS%>信息</title>
</head>

<body>
<%@ include file="/commons/messages.jsp" %>

<s:form action="${actionBasePath}/list.${actionExtension}" method="get" theme="simple">
<#list table.columns as column>
<#if column.pk>
	<s:hidden name="${column.columnNameLower}" id="${column.columnNameLower}" value="%{model.${column.columnNameLower}}"/>
</#if>
</#list>
	<table width="100%" border="1" bordercolor="#7c8ca7" align="center"  cellPadding="0" cellSpacing="0" class="tb_all">
	               <tr>
				          <td colspan="4" class="tb_title"> 
							<%=${className}.TABLE_ALIAS%>信息
				          </td>
		           </tr>
<#assign i = 0>
<#assign j = 0>
<#list table.columns as column>
    <#if !column.htmlHidden>
                  <#-- 取5的模，即除于5的倍数余数为0的生成行的开头<tr> -->
		     <#if i%2==0>
		           <tr class="crosscolor_tr">
		     </#if>
                          <td class="crosscolor_td">
			                      <%=${className}.ALIAS_${column.constantName}%>
		                  </td>
			              <td>
	                      <#if column.isDateTimeColumn>
		                           <s:property value="%{model.${column.columnNameLower}String}" />
		                  <#elseif  column.htmlInputType=="select">
			                       <mytag:write property="%{model.${column.columnNameLower}}"   name="${column.columnNameLower}"  notEmpty="true"  dictName="${column.dictName}"/>
	                      <#else>
		                           <s:property value="%{model.${column.columnNameLower}}" />
	                      </#if>
		                  </td>
                          <#-- 如果最后一个不是刚好5列，则要补充完剩下的列 -->
                          <#if column_index == (table.columns?size-1) && i%2!=1>
                                  <#assign end=(2-i%2-1) />
                                  <#-- 根据缺少的列数重新定义一个list生成列 -->
                                  <#list 0..end as x>
                          <td>&nbsp;</td>
                                  </#list>
                   </tr>
                          </#if>
                          <#-- 取5的模，即除于5的倍数余数为4（0到4刚好5列）的生成行的结尾</tr> -->
                          <#if i%2==1>
                   </tr>
                          </#if>
           <#assign i=i+1 />
    <#else>
           <#assign j=j+1 />
    </#if> 
 </#list>
                   <tr>
						  <td colspan="4" class="tb_bottom">
						           <input type="button" value="返回" onclick="window.location='<@jspEl 'ctx'/>${actionBasePath}/list.${actionExtension}?<mytag:params includes="ec*,s*" type="queryStringUtf"/>'"/>
	                      </td>
	               </tr>
	</table>	
</s:form>

</body>

</html>