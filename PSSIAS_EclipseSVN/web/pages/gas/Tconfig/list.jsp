<%@page import="com.dyneinfo.gas.model.*" %>
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
	<title><%=Tconfig.TABLE_ALIAS%> 维护</title>
</head>

<body onload="quickSelectInit()" >
<%@ include file="/commons/messages.jsp" %>
<table width="100%" bordercolor="#7c8ca7" align="center"  cellPadding="0" cellSpacing="0" class="tb_all">
      <tr>
        <td  class="tb_title"> 
			预警配置
        </td>
       </tr>
</table>
<ec:table items='page.result' var="item" method="get"
	retrieveRowsCallback="limit" sortRowsCallback="limit" filterRowsCallback="limit"
	action="${ctx}/pages/gas/Tconfig/list.do" autoIncludeParameters="true">
	<ec:row>
		<c:if test="${item.key =='gwxzqh'}">
         <ec:column property="name"  title="<%=Tconfig.ALIAS_NAME%>">重点预警区域</ec:column>
         <ec:column property="code"  title="<%=Tconfig.ALIAS_CODE%>">${item.name}</ec:column>
		 <ec:column property="操作" title="操作" sortable="false" viewsAllowed="html">
			<a href="${ctx}/pages/gas/Tconfig/show.do?key=${item.key}&<mytag:params includes="ec*,s*" type="queryStringUtf"/>">查看</a>&nbsp;&nbsp;&nbsp;
			<a href="${ctx}/pages/gas/Tconfig/gwedit.do?key=${item.key}&<mytag:params includes="ec*,s*" type="queryStringUtf"/>">修改</a>
		</ec:column>
		</c:if>
		<c:if test="${item.key !='gwxzqh'}">
		
         <ec:column property="name"  title="<%=Tconfig.ALIAS_NAME%>"/>
         <ec:column property="code"  title="<%=Tconfig.ALIAS_CODE%>"/>
		<ec:column property="操作" title="操作" sortable="false" viewsAllowed="html">
			<a href="${ctx}/pages/gas/Tconfig/show.do?key=${item.key}&<mytag:params includes="ec*,s*" type="queryStringUtf"/>">查看</a>&nbsp;&nbsp;&nbsp;
			<a href="${ctx}/pages/gas/Tconfig/edit.do?key=${item.key}&<mytag:params includes="ec*,s*" type="queryStringUtf"/>">修改</a>
		</ec:column>
		</c:if>
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
				input_txt.value = "!/pages/gas/Tconfig/list.do?<mytag:params includes="ec*,s*" type="queryStringUtf"/>";
				form.appendChild(input_txt);
		        form.action = '${ctx}/pages/gas/Tconfig/delete.do';
	            form.submit();
	        }
	  }
</script>