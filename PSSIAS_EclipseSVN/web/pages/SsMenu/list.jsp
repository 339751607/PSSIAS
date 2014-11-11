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
	<title><%=SsMenu.TABLE_ALIAS%> 维护</title>
</head>

<body onload="quickSelectInit()" >
<%@ include file="/commons/messages.jsp" %>

<div class="queryPanel">
<form action="<c:url value="/pages/SsMenu/list.do"/>" method="get" style="display: inline;">

	<table cellpadding="0" cellspacing="0" border="0" class="tb_all">
	    <tr>
			<td class="tb_title" colspan="6">搜索</td>
		</tr>
		 <tr class="crosscolor_tr">	
			<td class="crosscolor_td">
					<%=SsMenu.ALIAS_MENUNAME%>
			</td>		
			<td>
				<input value="${pageRequest.filters.menuname}"  name="s_menuname"  />
			</td>
			<td class="crosscolor_td">
					<%=SsMenu.ALIAS_MENUDESC%>
			</td>		
			<td>
				<input value="${pageRequest.filters.menudesc}"  name="s_menudesc"  />
			</td>
			<td class="crosscolor_td">
					<%=SsMenu.ALIAS_MENULABEL%>
			</td>		
			<td>
				<input value="${pageRequest.filters.menulabel}"  name="s_menulabel"  />
			</td>
		</tr>	
		 <tr class="crosscolor_tr">	
			<td class="crosscolor_td">
					<%=SsMenu.ALIAS_ISLEAF%>
			</td>		
			<td>
				<input value="${pageRequest.filters.isleaf}"  name="s_isleaf"  />
			</td>
			<td class="crosscolor_td">
					<%=SsMenu.ALIAS_MENUURL%>
			</td>		
			<td>
				<input value="${pageRequest.filters.menuurl}"  name="s_menuurl"  />
			</td>
			<td class="crosscolor_td">
					<%=SsMenu.ALIAS_MENULEVEL%>
			</td>		
			<td>
				<input value="${pageRequest.filters.menulevel}"  name="s_menulevel"  />
			</td>
			<td class="crosscolor_td">
					<%=SsMenu.ALIAS_ROOTID%>
			</td>		
			<td>
				<input value="${pageRequest.filters.rootid}"  name="s_rootid"  />
			</td>
		</tr>	
		 <tr class="crosscolor_tr">	
			<td class="crosscolor_td">
					<%=SsMenu.ALIAS_PARENTID%>
			</td>		
			<td>
				<input value="${pageRequest.filters.parentid}"  name="s_parentid"  />
			</td>
			<td class="crosscolor_td">
					<%=SsMenu.ALIAS_IMAGEPATH%>
			</td>		
			<td>
				<input value="${pageRequest.filters.imagepath}"  name="s_imagepath"  />
			</td>
			<td class="crosscolor_td">
					<%=SsMenu.ALIAS_MENUSEQ%>
			</td>		
			<td>
				<input value="${pageRequest.filters.menuseq}"  name="s_menuseq"  />
			</td>
			<td class="crosscolor_td">
					<%=SsMenu.ALIAS_DISPLAYORDER%>
			</td>		
			<td>
				<input value="${pageRequest.filters.displayorder}"  name="s_displayorder"  />
			</td>
		</tr>	
		<tr>
			<td class="tb_bottom" colspan="6">
			   <input type="submit"   value="查询" onclick="getReferenceForm(this).action='${ctx}/pages/SsMenu/list.do'"/>
	            <input type="submit"  value="新增" onclick="getReferenceForm(this).action='${ctx}/pages/SsMenu/create.do'"/>
	           <input type="button"  value="删除" onclick="batchDelete('${ctx}/pages/SsMenu/delete.do','items',document.forms.ec)"/>
			   </td>
		</tr>
	</table>


</form>
</div>

<ec:table items='page.result' var="item" method="get"
	retrieveRowsCallback="limit" sortRowsCallback="limit" filterRowsCallback="limit"
	action="${ctx}/pages/SsMenu/list.do" autoIncludeParameters="true">
	<ec:row>
		<ec:column property="选择" title="<input type='checkbox' onclick=\"setAllCheckboxState('items',this.checked)\" >" sortable="false" width="3%" viewsAllowed="html">
			<input type="checkbox" name="items" value="menuid=${item.menuid}&"/>
		</ec:column>
		<ec:column property="menuname"  title="<%=SsMenu.ALIAS_MENUNAME%>"/>
		<ec:column property="menudesc"  title="<%=SsMenu.ALIAS_MENUDESC%>"/>
		<ec:column property="menulabel"  title="<%=SsMenu.ALIAS_MENULABEL%>"/>
		<ec:column property="isleaf"  title="<%=SsMenu.ALIAS_ISLEAF%>"/>
		<ec:column property="menuurl"  title="<%=SsMenu.ALIAS_MENUURL%>"/>
		<ec:column property="menulevel"  title="<%=SsMenu.ALIAS_MENULEVEL%>"/>
		<ec:column property="rootid"  title="<%=SsMenu.ALIAS_ROOTID%>"/>
		<ec:column property="parentid"  title="<%=SsMenu.ALIAS_PARENTID%>"/>
		<ec:column property="imagepath"  title="<%=SsMenu.ALIAS_IMAGEPATH%>"/>
		<ec:column property="menuseq"  title="<%=SsMenu.ALIAS_MENUSEQ%>"/>
		<ec:column property="displayorder"  title="<%=SsMenu.ALIAS_DISPLAYORDER%>"/>
		<ec:column property="操作" title="操作" sortable="false" viewsAllowed="html">
			<a href="${ctx}/pages/SsMenu/show.do?menuid=${item.menuid}&">查看</a>&nbsp;&nbsp;&nbsp;
			<a href="${ctx}/pages/SsMenu/edit.do?menuid=${item.menuid}&">修改</a>
		</ec:column>
	</ec:row>
</ec:table>

</body>

</html>

