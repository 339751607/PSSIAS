<%@page import="com.dyneinfo.jxy.model.*" %>
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
	<title><%=Tempworklog.TABLE_ALIAS%> 维护</title>
</head>

<body >

<div class="queryPanel">
	    <table cellpadding="0" cellspacing="0" border="0" class="tb_all">          
		           <tr>
			              <td class="tb_bottom" colspan="4">
	                              
	                              
			                       <input type="button" value="返回" onclick="javascript:window.parent.doBack();"/>
			             </td>
		           </tr>
	    </table>
</div>



<ec:table items='page.result' var="item" method="get"
	retrieveRowsCallback="limit" sortRowsCallback="limit" filterRowsCallback="limit"
	action="${ctx}/pages/jxy/Tempworklog/list.do" autoIncludeParameters="true">
	<ec:row>
		<ec:column property="选择" title="<input type='checkbox' onclick=\"setAllCheckboxState('items',this.checked)\" >" sortable="false" width="3%" viewsAllowed="html">
			<input type="checkbox" name="items" value="worklogid=${item.worklogid}&"/>
		</ec:column>
		                   
		                    <ec:column property="cpname"  title="<%=Tempworklog.ALIAS_CPNAME%>"/>
				            <ec:column property="indate"  parse="yyyyMMdd" format="yyyy-MM-dd" cell="date"  title="<%=Tempworklog.ALIAS_INDATE%>"/>
				            <ec:column property="leftdate"  parse="yyyyMMdd" format="yyyy-MM-dd" cell="date"  title="<%=Tempworklog.ALIAS_LEFTDATE%>"/>
				            <mytag:lookupcolumn property="emptype"  title="<%=Tempworklog.ALIAS_EMPTYPE%>"	cell="net.java.dev.ec.table.view.LookUpCell" dictType="emptype" />
		                  
		<ec:column property="操作" title="操作" sortable="false" viewsAllowed="html">
			<a href="${ctx}/pages/jxy/Tempworklog/show.do?worklogid=${item.worklogid}&<mytag:params includes="ec*,s*" type="queryStringUtf"/>">查看</a>&nbsp;&nbsp;
			<c:if test="${ deptid eq fn:trim(item.cpcode) && item.status=='0'}">
			<a href="${ctx}/pages/jxy/Tempworklog/edit.do?worklogid=${item.worklogid}&<mytag:params includes="ec*,s*" type="queryStringUtf"/>">修改</a>
			</c:if>
		</ec:column>
	</ec:row>
</ec:table>

</body>

</html>


<script>
	  function doDel() {
		    var form = document.forms.ec;
			if(!form) return;
			if (!hasOneChecked('items')){
               alert('请选择要操作的对象!');
               return;
             }
	        if (confirm('确定执行[删除]操作?')){
				var input_txt = document.createElement("input");
				input_txt.type = "hidden";
				input_txt.name = "returnUrl";
				input_txt.value = "!/pages/jxy/Tempworklog/list.do?<mytag:params includes="ec*,s*" type="queryStringUtf"/>";
				form.appendChild(input_txt);
		        form.action = '${ctx}/pages/jxy/Tempworklog/delete.do';
	            form.submit();
	        }
	  }
</script>
