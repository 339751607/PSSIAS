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
	<title><%=SsDictItem.TABLE_ALIAS%> 维护</title>
</head>

<body onload="quickSelectInit()" >
<%@ include file="/commons/messages.jsp" %>

<div class="queryPanel">

       <form id="list" name="list" action="/sys/pages/SsDictItem/list.do" method="post" style="display: inline;">
    
	      <table width="100%" border="1" bordercolor="#7c8ca7" align="center"  cellPadding="0" cellSpacing="0" class="tb_all">
	               <tr>
	               <input type="hidden" value="<mytag:params includes="ec*,s*" type="queryStringUtf"/>">
			              <td class="tb_title" colspan="4"><%=SsDictItem.TABLE_ALIAS%>查询</td>
		           </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=SsDictItem.ALIAS_DICTID%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.dictid}"  name="s_dictid"  />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=SsDictItem.ALIAS_DICTNAME%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.dictname}"  name="s_dictname"  />
		                  </td>
                   </tr>
		         
		           <tr>
			              <td class="tb_bottom" colspan="4">
			                       <input type="submit"  value="查询" onclick="getReferenceForm(this).action='${ctx}/pages/SsDictItem/list.do?<mytag:params includes="ec*,s_dicttype*" type="queryStringUtf"/>'"/>
	                               <input type="submit"  value="新增" onclick="getReferenceForm(this).action='${ctx}/pages/SsDictItem/create.do?<mytag:params includes="ec*,s*" type="queryStringUtf"/>'"/>
	                               <input type="button"  value="删除" onclick="doDel();"/>
			              </td>
		           </tr>
	    </table>
  </form>
</div>



<ec:table items='page.result' var="item" method="get"
	retrieveRowsCallback="limit" sortRowsCallback="limit" filterRowsCallback="limit"
	action="${ctx}/pages/SsDictItem/list.do" autoIncludeParameters="true">
	<ec:row>
		<ec:column property="选择" title="<input type='checkbox' class='formRadio' onclick=\"setAllCheckboxState('items',this.checked)\" >" sortable="false" width="3%" viewsAllowed="html">
			<input type="checkbox" name="items"  class="formRadio" value="dicttypeid=${item.dicttypeid}&dictid=${item.dictid}&"/>
		</ec:column>
		                    <ec:column property="dictid"  title="<%=SsDictItem.ALIAS_DICTID%>"/>
		                    <ec:column property="dictname"  title="<%=SsDictItem.ALIAS_DICTNAME%>"/>
				            <mytag:lookupcolumn property="status"  title="<%=SsDictItem.ALIAS_STATUS%>"	cell="net.java.dev.ec.table.view.LookUpCell" dictType="status" />
		                    <ec:column property="sortno"  title="<%=SsDictItem.ALIAS_SORTNO%>"/>
		<ec:column property="操作" title="操作" sortable="false" viewsAllowed="html">
			<a href="${ctx}/pages/SsDictItem/show.do?dicttypeid=${item.dicttypeid}&dictid=${item.dictid}&<mytag:params includes="ec*,s*" type="queryStringUtf"/>">查看</a>&nbsp;&nbsp;&nbsp;
			<a href="${ctx}/pages/SsDictItem/edit.do?dicttypeid=${item.dicttypeid}&dictid=${item.dictid}&<mytag:params includes="ec*,s*" type="queryStringUtf"/>">修改</a>
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
				input_txt.value = "!/pages/SsDictItem/list.do?<mytag:params includes="ec*,s*" type="queryStringUtf"/>";
				form.appendChild(input_txt);
		        form.action = '${ctx}/pages/SsDictItem/delete.do';
	            form.submit();
	        }
	  }
</script>