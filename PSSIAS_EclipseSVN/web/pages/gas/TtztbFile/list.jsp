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
	<title><%=TtztbFile.TABLE_ALIAS%> 维护</title>
</head>

<body onload="quickSelectInit()" >
<%@ include file="/commons/messages.jsp" %>

<div class="queryPanel">
    <s:form action="/pages/gas/TtztbFile/list.do"  theme="simple" style="display: inline;" method="post">
	    <table cellpadding="0" cellspacing="0" border="0" class="tb_all">
	               <tr>
			              <td class="tb_title" colspan="4"><%=TtztbFile.TABLE_ALIAS%>查询</td>
		           </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=TtztbFile.ALIAS_FILEID%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.fileid}"  name="s_fileid"  />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=TtztbFile.ALIAS_FILECONTENT%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.filecontent}"  name="s_filecontent"  />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=TtztbFile.ALIAS_TZTBTYPE%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.tztbtype}"  name="s_tztbtype"  />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=TtztbFile.ALIAS_FILENAME%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.filename}"  name="s_filename"  />
		                  </td>
                   </tr>
		           <tr>
			              <td class="tb_bottom" colspan="4">
			                       <input type="submit"  value="查询" onclick="getReferenceForm(this).action='${ctx}/pages/gas/TtztbFile/list.do'"/>
	                               <input type="submit"  value="新增" onclick="getReferenceForm(this).action='${ctx}/pages/gas/TtztbFile/create.do?<mytag:params includes="ec*,s*" type="queryStringUtf"/>'"/>
	                               <input type="button"  value="删除" onclick="doDel();"/>
			              </td>
		           </tr>
	    </table>
    </s:form>
</div>



<ec:table items='page.result' var="item" method="get"
	retrieveRowsCallback="limit" sortRowsCallback="limit" filterRowsCallback="limit"
	action="${ctx}/pages/gas/TtztbFile/list.do" autoIncludeParameters="true">
	<ec:row>
		<ec:column property="选择" title="<input type='checkbox' onclick=\"setAllCheckboxState('items',this.checked)\" >" sortable="false" width="3%" viewsAllowed="html">
			<input type="checkbox" name="items" value="id=${item.id}&"/>
		</ec:column>
		                    <ec:column property="fileid"  title="<%=TtztbFile.ALIAS_FILEID%>"/>
		                    <ec:column property="filecontent"  title="<%=TtztbFile.ALIAS_FILECONTENT%>"/>
		                    <ec:column property="tztbtype"  title="<%=TtztbFile.ALIAS_TZTBTYPE%>"/>
		                    <ec:column property="filename"  title="<%=TtztbFile.ALIAS_FILENAME%>"/>
		<ec:column property="操作" title="操作" sortable="false" viewsAllowed="html">
			<a href="${ctx}/pages/gas/TtztbFile/show.do?id=${item.id}&<mytag:params includes="ec*,s*" type="queryStringUtf"/>">查看</a>&nbsp;&nbsp;&nbsp;
			<a href="${ctx}/pages/gas/TtztbFile/edit.do?id=${item.id}&<mytag:params includes="ec*,s*" type="queryStringUtf"/>">修改</a>
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
				input_txt.value = "!/pages/gas/TtztbFile/list.do?<mytag:params includes="ec*,s*" type="queryStringUtf"/>";
				form.appendChild(input_txt);
		        form.action = '${ctx}/pages/gas/TtztbFile/delete.do';
	            form.submit();
	        }
	  }
</script>