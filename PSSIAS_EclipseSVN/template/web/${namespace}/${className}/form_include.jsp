<%@page import="${basepackage}.model.*" %>
<#include "/macro.include"/> 
<#assign className = table.className>   
<#assign classNameLower = className?uncap_first>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/commons/taglibs.jsp" %>

<#list table.columns as column>
<#if column.htmlHidden>
	<s:hidden id="${column.columnNameLower}" name="${column.columnNameLower}" />
</#if>
</#list>

<!-- ONGL access static field: @package.class@field or @vs@field -->

<#assign i = 0>
<#assign j = 0>
<#list table.columns as column>
    <#if !column.htmlHidden>
                  <#-- 取5的模，即除于5的倍数余数为0的生成行的开头<tr> -->
		     <#if i%2==0>
		           <tr class="crosscolor_tr">
		     </#if>
                          <td class="crosscolor_td">
			                      <#if !column.nullable><FONT color="red">*</FONT></#if><%=${className}.ALIAS_${column.constantName}%>
		                  </td>
			              <td>
	                      <#if column.isDateTimeColumn>
		                           <input value="<@jspEl 'model.'+column.columnNameLower+'String'/>" onclick="WdatePicker({dateFmt:'<%=${className}.FORMAT_${column.constantName}%>'})" id="${column.columnNameLower}String" name="${column.columnNameLower}String"  maxlength="0" class="Wdate" />
	                      <#elseif  column.htmlInputType=="select">
						           <mytag:select property="%{model.${column.columnNameLower}}"   styleClass="required validate-selection"  name="${column.columnNameLower}"   notEmpty="false"  dictName="${column.dictName}"/>
					      <#elseif  column.htmlInputType=="date">
						           <input value="<@jspEl 'model.'+column.columnNameLower+''/>" onclick="WdatePicker({dateFmt:'${column.displayFormat}'})" id="${column.columnNameLower}" name="${column.columnNameLower}"  maxlength="0" class="required Wdate" />
	                      <#elseif  column.jsValidateName=="emptys">
		                           <s:textfield label="%{@vs@ALIAS_${column.constantName}}" key="${column.columnNameLower}" value="%{model.${column.columnNameLower}}"  cssClass="${column.validateString}" required="${(!column.nullable)?string}" />
	                      <#else> 
	                               <s:textfield label="%{@vs@ALIAS_${column.constantName}}" key="${column.columnNameLower}" value="%{model.${column.columnNameLower}}"  cssClass="${column.validateString} ${column.jsValidateName}" required="${(!column.nullable)?string}" />
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
 
 
