<%@page import="com.dyneinfo.pmdd.model.*" %>
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
	<title><%=Tlinkmaninfo.TABLE_ALIAS%> 维护</title>
</head>

<body >


<div class="queryPanel">
	    <table cellpadding="0" cellspacing="0" border="0" class="tb_all">          
		           <tr>
			              <td class="tb_bottom" colspan="4">
			               <authz:authorize ifNotGranted="ROLE_ADMIN,ROLE_HT_ADMIN">
	                               <input type="submit"  value="新增" onclick="window.location='${ctx}/pages/pmdd/Tlinkmaninfo/create.do?<mytag:params includes="ec*,s*" type="queryStringUtf"/>'"/>
	                               <input type="button"  value="删除" onclick="doDel();"/>
			                </authz:authorize>
			                       <input type="button" value="返回" onclick="javascript:window.parent.doBack();"/>
			              </td>
		           </tr>
	    </table>
</div>



<ec:table items='page.result' var="item" method="get"
	retrieveRowsCallback="limit" sortRowsCallback="limit" filterRowsCallback="limit"
	action="${ctx}/pages/pmdd/Tlinkmaninfo/list.do" autoIncludeParameters="true">
	<ec:row>
		<ec:column property="选择" title="<input type='checkbox' onclick=\"setAllCheckboxState('items',this.checked)\" >" sortable="false" width="3%" viewsAllowed="html">
			<input type="checkbox" name="items" value="linkmanid=${item.linkmanid}&"/>
		</ec:column>
		                 
		                    <ec:column property="linkman"  title="<%=Tlinkmaninfo.ALIAS_LINKMAN%>"/>
		                    <mytag:lookupcolumn property="sex"  title="<%=Tlinkmaninfo.ALIAS_SEX%>"	cell="net.java.dev.ec.table.view.LookUpCell" dictType="gender" />
		                    <ec:column property="idcode"  title="<%=Tlinkmaninfo.ALIAS_IDCODE%>"/>
		                    <ec:column property="phone"  title="<%=Tlinkmaninfo.ALIAS_PHONE%>"/>
		                    <ec:column property="relation"  title="<%=Tlinkmaninfo.ALIAS_RELATION%>"/>
		<ec:column property="操作" title="操作" sortable="false" viewsAllowed="html">
			<a href="${ctx}/pages/pmdd/Tlinkmaninfo/show.do?linkmanid=${item.linkmanid}&<mytag:params includes="ec*,s*" type="queryStringUtf"/>">查看</a>&nbsp;&nbsp;&nbsp;
			 <authz:authorize ifNotGranted="ROLE_ADMIN,ROLE_HT_ADMIN">
			<a href="${ctx}/pages/pmdd/Tlinkmaninfo/edit.do?linkmanid=${item.linkmanid}&<mytag:params includes="ec*,s*" type="queryStringUtf"/>">修改</a>
			</authz:authorize>
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
				input_txt.value = "!/pages/pmdd/Tlinkmaninfo/list.do?<mytag:params includes="ec*,s*" type="queryStringUtf"/>";
				form.appendChild(input_txt);
		        form.action = '${ctx}/pages/pmdd/Tlinkmaninfo/delete.do';
	            form.submit();
	        }
	  }
</script>