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
	<link href="${ctx}/widgets/extremecomponents/extremecomponents.css" type="text/css" rel=stylesheet>
	<title><%=SsRole.TABLE_ALIAS%> 维护</title>
</head>

<body onload="quickSelectInit()" >
<%@ include file="/commons/messages.jsp" %>

<div class="queryPanel">
<form action="<c:url value="/pages/SsRole/list.do"/>" method="get" style="display: inline;">

	<table cellpadding="0" cellspacing="0" border="0" class="tb_all">
	    <tr>
			<td class="tb_title" colspan="6">搜索</td>
		</tr>
		 <tr class="crosscolor_tr">	
			<td class="crosscolor_td">
					<%=SsRole.ALIAS_ROLENAME%>
			</td>		
			<td>
				<input value="${pageRequest.filters.rolename}"  name="s_rolename"  />
			</td>
			<td class="crosscolor_td">
					<%=SsRole.ALIAS_ROLEDESC%>
			</td>		
			<td>
				<input value="${pageRequest.filters.roledesc}"  name="s_roledesc"  />
			</td>
		</tr>	
		<tr>
			<td class="tb_bottom" colspan="6">
			   <input type="submit"   value="查询" onclick="getReferenceForm(this).action='${ctx}/pages/SsRole/list.do'"/>
	            <input type="submit"  value="新增" onclick="getReferenceForm(this).action='${ctx}/pages/SsRole/create.do'"/>
	           <input type="button"  value="删除" onclick="batchDelete('${ctx}/pages/SsRole/delete.do','items',document.forms.ec)"/>
			   </td>
		</tr>
	</table>


</form>
</div>

<ec:table items='page.result' var="item" method="get"
	retrieveRowsCallback="limit" sortRowsCallback="limit" filterRowsCallback="limit"
	action="${ctx}/pages/SsRole/list.do" autoIncludeParameters="true">
	<ec:row>
		<ec:column property="选择" title="<input type='checkbox' onclick=\"setAllCheckboxState('items',this.checked)\" >" sortable="false" width="3%" viewsAllowed="html">
			<input type="checkbox" name="items" value="roleid=${item.roleid}&"/>
		</ec:column>
		<ec:column property="rolename"  title="<%=SsRole.ALIAS_ROLENAME%>"/>
		<ec:column property="roledesc"  title="<%=SsRole.ALIAS_ROLEDESC%>"/>
		<ec:column property="操作" title="操作" sortable="false" viewsAllowed="html">
			<a href="${ctx}/pages/SsRole/show.do?roleid=${item.roleid}&">查看</a>&nbsp;&nbsp;&nbsp;
			<a href="${ctx}/pages/SsRole/edit.do?roleid=${item.roleid}&">修改</a>
		</ec:column>
	</ec:row>
</ec:table>

</body>

</html>

