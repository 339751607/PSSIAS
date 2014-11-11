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
	<title><%=${className}.TABLE_ALIAS%>查询</title>
</head>

<body>
<%@ include file="/commons/messages.jsp" %>
<div class="queryPanel">
    <s:form action="${actionBasePath}/list.${actionExtension}"  theme="simple" style="display: inline;" method="post">
	    <table width="100%" border="1" bordercolor="#7c8ca7" align="center"  cellPadding="0" cellSpacing="0" class="tb_all">
	               <tr>
			              <td class="tb_title" colspan="4"><%=${className}.TABLE_ALIAS%>查询</td>
		           </tr>
<#-- 查询字段开始 -->		    
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
		                           <s:select name="dateSelect${i}" list="dateSelectMap"  onchange="dateselect(this,'s_${column.columnNameLower}Begin','s_${column.columnNameLower}End','${column.displayFormat}');"  value="#request.dateSelect${i}" listKey="key"   listValue="value" theme="simple" label=""  emptyOption="false" ></s:select>
			                          从<input id="d313${i}" name="s_${column.columnNameLower}Begin"  value="<@jspEl "pageRequest.filters."+column.columnNameLower+"Begin"/>"   maxlength="0" size="12" class="Wdate" type="text" onFocus="WdatePicker({dateFmt:'<%=${className}.FORMAT_${column.constantName}%>',maxDate:'#F{$dp.$D(\'d314${i}\')}'})"/> &nbsp;到&nbsp;
			                        <input id="d314${i}" name="s_${column.columnNameLower}End"   value="<@jspEl "pageRequest.filters."+column.columnNameLower+"End"/>"  maxlength="0" size="12" class="Wdate" type="text" onFocus="WdatePicker({dateFmt:'<%=${className}.FORMAT_${column.constantName}%>',minDate:'#F{$dp.$D(\'d313${i}\')}'})"/>
	                      <#elseif  column.htmlInputType=="select">
				                   <mytag:select  name="s_${column.columnNameLower}"   notEmpty="false"  dictName="${column.dictName}"/>
				          <#elseif  column.htmlInputType=="date">
				                   <s:select name="dateSelect${i}" list="dateSelectMap"  onchange="dateselect(this,'s_${column.columnNameLower}Begin','s_${column.columnNameLower}End','${column.displayFormat}');"  value="#request.dateSelect${i}" listKey="key"   listValue="value" theme="simple" label=""  emptyOption="false" ></s:select>
			                          从<input id="d313${i}" name="s_${column.columnNameLower}Begin"  value="<@jspEl "pageRequest.filters."+column.columnNameLower+"Begin"/>"   maxlength="0" size="12" class="Wdate" type="text" onFocus="WdatePicker({dateFmt:'${column.displayFormat}',maxDate:'#F{$dp.$D(\'d314${i}\')}'})"/> &nbsp;到&nbsp;
			                        <input id="d314${i}" name="s_${column.columnNameLower}End"   value="<@jspEl "pageRequest.filters."+column.columnNameLower+"End"/>"  maxlength="0" size="12" class="Wdate" type="text" onFocus="WdatePicker({dateFmt:'${column.displayFormat}',minDate:'#F{$dp.$D(\'d313${i}\')}'})"/>
	                      <#else>
		                           <input value="<@jspEl "pageRequest.filters."+column.columnNameLower/>"  name="s_${column.columnNameLower}"  />
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
 <#-- 查询字段结束 -->	
		           <tr>
			              <td class="tb_bottom" colspan="4">
			                       <input type="submit"  value="查询" onclick="getReferenceForm(this).action='<@jspEl 'ctx'/>${actionBasePath}/list.do'"/>
	                               <input type="submit"  value="新增" onclick="getReferenceForm(this).action='<@jspEl 'ctx'/>${actionBasePath}/create.do?<mytag:params includes="ec*,s*" type="queryStringUtf"/>'"/>
			              </td>
		           </tr>
	    </table>
    </s:form>
</div>
			
</body>

</html>