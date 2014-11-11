<%@page import="com.dyneinfo.fjy.model.*" %>
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
	<title><%=Tesdnxs.TABLE_ALIAS%> 维护</title>
</head>

<body onload="quickSelectInit()" >
<%@ include file="/commons/messages.jsp" %>

<div class="queryPanel">
	    <table cellpadding="0" cellspacing="0" border="1" class="tb_all">          
		           <tr>
			              <td class="tb_bottom" colspan="4">      
	                              <input type="submit"  value="新增" onclick="window.location='${ctx}/pages/fjy/Tesdnxs/create.do?<mytag:params includes="ec*,s*" type="queryStringUtf"/>'"/>
	                               <input type="button"  value="删除" onclick="doDel();"/>
			                        <input type="button" value="返回" onclick="javascript:window.parent.doBack();"/>
			              </td>
		           </tr>
	    </table>
</div>



<ec:table items='page.result' var="item" method="get"
	retrieveRowsCallback="limit" sortRowsCallback="limit" filterRowsCallback="limit"
	action="${ctx}/pages/fjy/Tesdnxs/list.do" autoIncludeParameters="true">
	<ec:row>
		<ec:column property="选择" title="<input type='checkbox' onclick=\"setAllCheckboxState('items',this.checked)\" >" sortable="false" width="3%" viewsAllowed="html">
			<input type="checkbox" name="items" value="xh=${item.xh}&"/>
		</ec:column>
		                   
		                    <ec:column property="gmrxm"  title="<%=Tesdnxs.ALIAS_GMRXM%>"/>
				            <mytag:lookupcolumn property="gmrxb"  title="<%=Tesdnxs.ALIAS_GMRXB%>"	cell="net.java.dev.ec.table.view.LookUpCell" dictType="T_DIC_SEX" />
		                    <ec:column property="gmrsfzh"  title="<%=Tesdnxs.ALIAS_GMRSFZH%>"/>
		                    <ec:column property="gmrlxdh"  title="<%=Tesdnxs.ALIAS_GMRLXDH%>"/>
		                    <ec:column property="gmrjtzz"  title="<%=Tesdnxs.ALIAS_GMRJTZZ%>"/>
		                    <ec:column property="jbr"  title="<%=Tesdnxs.ALIAS_JBR%>"/>
		                    
		<ec:column property="操作" title="操作" sortable="false" viewsAllowed="html">
			<a href="${ctx}/pages/fjy/Tesdnxs/show.do?xh=${item.xh}&<mytag:params includes="ec*,s*" type="queryStringUtf"/>">查看</a>&nbsp;&nbsp;&nbsp;
			<a href="${ctx}/pages/fjy/Tesdnxs/edit.do?xh=${item.xh}&<mytag:params includes="ec*,s*" type="queryStringUtf"/>">修改</a>
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
				input_txt.value = "!/pages/fjy/Tesdnxs/list.do?<mytag:params includes="ec*,s*" type="queryStringUtf"/>";
				form.appendChild(input_txt);
		        form.action = '${ctx}/pages/fjy/Tesdnxs/delete.do';
	            form.submit();
	        }
	  }
</script>