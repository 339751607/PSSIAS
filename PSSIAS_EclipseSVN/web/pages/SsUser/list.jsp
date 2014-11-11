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
	<title><%=SsUser.TABLE_ALIAS%> 维护</title>
</head>

<body onload="quickSelectInit()" >
<%@ include file="/commons/messages.jsp" %>

<div class="queryPanel">

<s:form action="<c:url value="/pages/SsUser/list.do"/>" name="TchPreForms"  target="result" method="post">	

	<table cellpadding="0" cellspacing="0" border="0" class="tb_all">
	    <tr>
			<td class="tb_title" colspan="6">搜索</td>
		</tr>
		 <tr class="crosscolor_tr">	
			<td class="crosscolor_td">
					<%=SsUser.ALIAS_USERNAME%>
			</td>		
			<td>
				<input value="${pageRequest.filters.username}"  name="s_username"  />
			</td>
			<td class="crosscolor_td">
					<%=SsUser.ALIAS_PASSWORD%>
			</td>		
			<td>
				<input value="${pageRequest.filters.password}"  name="s_password"  />
			</td>
			<td class="crosscolor_td">
					<%=SsUser.ALIAS_FULLNAME%>
			</td>		
			<td>
				<input value="${pageRequest.filters.fullname}"  name="s_fullname"  />
			</td>
		</tr>	
		 <tr class="crosscolor_tr">	
			<td class="crosscolor_td">
					<%=SsUser.ALIAS_SEX%>
			</td>		
			<td>
				<input value="${pageRequest.filters.sex}"  name="s_sex"  />
			</td>
			<td class="crosscolor_td">
					<%=SsUser.ALIAS_SFZH%>
			</td>		
			<td>
				<input value="${pageRequest.filters.sfzh}"  name="s_sfzh"  />
			</td>
			<td class="crosscolor_td">
					<%=SsUser.ALIAS_POLICEID%>
			</td>		
			<td>
				<input value="${pageRequest.filters.policeid}"  name="s_policeid"  />
			</td>
			<td class="crosscolor_td">
					<%=SsUser.ALIAS_PHONE%>
			</td>		
			<td>
				<input value="${pageRequest.filters.phone}"  name="s_phone"  />
			</td>
		</tr>	
		 <tr class="crosscolor_tr">	
			<td class="crosscolor_td">
					<%=SsUser.ALIAS_MOBILE%>
			</td>		
			<td>
				<input value="${pageRequest.filters.mobile}"  name="s_mobile"  />
			</td>
			<td class="crosscolor_td">
					<%=SsUser.ALIAS_FAX%>
			</td>		
			<td>
				<input value="${pageRequest.filters.fax}"  name="s_fax"  />
			</td>
			<td class="crosscolor_td">
					<%=SsUser.ALIAS_ADDRESS%>
			</td>		
			<td>
				<input value="${pageRequest.filters.address}"  name="s_address"  />
			</td>
			<td class="crosscolor_td">
					<%=SsUser.ALIAS_ZIP%>
			</td>		
			<td>
				<input value="${pageRequest.filters.zip}"  name="s_zip"  />
			</td>
		</tr>	
		 <tr class="crosscolor_tr">	
			<td class="crosscolor_td">
					<%=SsUser.ALIAS_EMAILADDRESS%>
			</td>		
			<td>
				<input value="${pageRequest.filters.emailaddress}"  name="s_emailaddress"  />
			</td>
			<td class="crosscolor_td">
					<%=SsUser.ALIAS_CREATEDATE%>
			</td>		
			<td>
				<input value="${pageRequest.filters.createdate}" onclick="WdatePicker({dateFmt:'<%=SsUser.FORMAT_CREATEDATE%>'})"  name="s_createdate"   />
			</td>
			<td class="crosscolor_td">
					<%=SsUser.ALIAS_DEPTID%>
			</td>		
			<td>
				<input value="${pageRequest.filters.deptid}"  name="s_deptid"  />
			</td>
			<td class="crosscolor_td">
					<%=SsUser.ALIAS_ENABLED%>
			</td>		
			<td>
				<input value="${pageRequest.filters.enabled}"  name="s_enabled"  />
			</td>
		</tr>	
		 <tr class="crosscolor_tr">	
			<td class="crosscolor_td">
					<%=SsUser.ALIAS_PHOTO%>
			</td>		
			<td>
				<input value="${pageRequest.filters.photo}"  name="s_photo"  />
			</td>
		</tr>	
		<tr>
			<td class="tb_bottom" colspan="6">
			   <input type="submit"   value="查询" onclick="getReferenceForm(this).action='${ctx}/pages/SsUser/list.do'"/>
	            <input type="submit"  value="新增" onclick="getReferenceForm(this).action='${ctx}/pages/SsUser/create.do'"/>
	           <input type="button"  value="删除" onclick="batchDelete('${ctx}/pages/SsUser/delete.do','items',document.forms.ec)"/>
			   </td>
		</tr>
	</table>


</s:form>
</div>

<ec:table items='page.result' var="item" method="get"
	retrieveRowsCallback="limit" sortRowsCallback="limit" filterRowsCallback="limit"
	action="${ctx}/pages/SsUser/list.do" autoIncludeParameters="true">
	<ec:row>
		<ec:column property="选择" title="<input type='checkbox' onclick=\"setAllCheckboxState('items',this.checked)\" >" sortable="false" width="3%" viewsAllowed="html">
			<input type="checkbox" name="items" value="userid=${item.userid}&"/>
		</ec:column>
		<ec:column property="username"  title="<%=SsUser.ALIAS_USERNAME%>"/>
		<ec:column property="password"  title="<%=SsUser.ALIAS_PASSWORD%>"/>
		<ec:column property="fullname"  title="<%=SsUser.ALIAS_FULLNAME%>"/>
		<ec:column property="sex"  title="<%=SsUser.ALIAS_SEX%>"/>
		<ec:column property="sfzh"  title="<%=SsUser.ALIAS_SFZH%>"/>
		<ec:column property="policeid"  title="<%=SsUser.ALIAS_POLICEID%>"/>
		<ec:column property="phone"  title="<%=SsUser.ALIAS_PHONE%>"/>
		<ec:column property="mobile"  title="<%=SsUser.ALIAS_MOBILE%>"/>
		<ec:column property="fax"  title="<%=SsUser.ALIAS_FAX%>"/>
		<ec:column property="address"  title="<%=SsUser.ALIAS_ADDRESS%>"/>
		<ec:column property="zip"  title="<%=SsUser.ALIAS_ZIP%>"/>
		<ec:column property="emailaddress"  title="<%=SsUser.ALIAS_EMAILADDRESS%>"/>
		<ec:column property="createdate" value="${item.createdateString}" title="<%=SsUser.ALIAS_CREATEDATE%>"/>
		<ec:column property="deptid"  title="<%=SsUser.ALIAS_DEPTID%>"/>
		<ec:column property="enabled"  title="<%=SsUser.ALIAS_ENABLED%>"/>
		<ec:column property="photo"  title="<%=SsUser.ALIAS_PHOTO%>"/>
		<ec:column property="操作" title="操作" sortable="false" viewsAllowed="html">
			<a href="${ctx}/pages/SsUser/show.do?userid=${item.userid}&">查看</a>&nbsp;&nbsp;&nbsp;
			<a href="${ctx}/pages/SsUser/edit.do?userid=${item.userid}&">修改</a>
		</ec:column>
	</ec:row>
</ec:table>

</body>

</html>

