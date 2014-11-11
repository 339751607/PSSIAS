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
	<title><%=Tempworklog.TABLE_ALIAS%> 维护</title>
</head>

<body onload="quickSelectInit()" >
<%@ include file="/commons/messages.jsp" %>

<div class="queryPanel">
    <s:form action="/pages/gas/Tempworklog/list.do"  theme="simple" style="display: inline;" method="post">
	   <table width="100%" border="1" bordercolor="#7c8ca7" align="center"  cellPadding="0" cellSpacing="0" class="tb_all">
	               <tr>
			              <td class="tb_title" colspan="4"><%=Tempworklog.TABLE_ALIAS%>查询</td>
		           </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=Tempworklog.ALIAS_EMPCODE%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.empcode}"  name="s_empcode"  />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=Tempworklog.ALIAS_CPCODE%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.cpcode}"  name="s_cpcode"  />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=Tempworklog.ALIAS_INDATE%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.indate}"  name="s_indate"  />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=Tempworklog.ALIAS_LEFTDATE%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.leftdate}"  name="s_leftdate"  />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=Tempworklog.ALIAS_EMPDUTY%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.empduty}"  name="s_empduty"  />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=Tempworklog.ALIAS_DEMO%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.demo}"  name="s_demo"  />
		                  </td>
                   </tr>
		           <tr>
			              <td class="tb_bottom" colspan="4">
			                       <input type="submit"  value="查询" onclick="getReferenceForm(this).action='${ctx}/pages/gas/Tempworklog/list.do'"/>
	                               <input type="submit"  value="新增" onclick="getReferenceForm(this).action='${ctx}/pages/gas/Tempworklog/create.do?<mytag:params includes="ec*,s*" type="queryStringUtf"/>'"/>
	                               <input type="button"  value="删除" onclick="doDel();"/>
			              </td>
		           </tr>
	    </table>
    </s:form>
</div>



<ec:table items='page.result' var="item" method="get"
	retrieveRowsCallback="limit" sortRowsCallback="limit" filterRowsCallback="limit"
	action="${ctx}/pages/gas/Tempworklog/list.do" autoIncludeParameters="true">
	<ec:row>
		<ec:column property="选择" title="<input type='checkbox' onclick=\"setAllCheckboxState('items',this.checked)\" >" sortable="false" width="3%" viewsAllowed="html">
			<input type="checkbox" name="items" value="empcode=${item.id.empcode}&cpcode=${item.id.cpcode}&"/>
		</ec:column>
		                    <ec:column property="empcode"  title="<%=Tempworklog.ALIAS_EMPCODE%>"/>
		                    <ec:column property="cpcode"  title="<%=Tempworklog.ALIAS_CPCODE%>"/>
		                    <ec:column property="indate"  title="<%=Tempworklog.ALIAS_INDATE%>"/>
		                    <ec:column property="leftdate"  title="<%=Tempworklog.ALIAS_LEFTDATE%>"/>
		                    <ec:column property="empduty"  title="<%=Tempworklog.ALIAS_EMPDUTY%>"/>
		                    <ec:column property="demo"  title="<%=Tempworklog.ALIAS_DEMO%>"/>
		<ec:column property="操作" title="操作" sortable="false" viewsAllowed="html">
			<a href="${ctx}/pages/gas/Tempworklog/show.do?empcode=${item.id.empcode}&cpcode=${item.id.cpcode}&<mytag:params includes="ec*,s*" type="queryStringUtf"/>">查看</a>&nbsp;&nbsp;&nbsp;
			<a href="${ctx}/pages/gas/Tempworklog/edit.do?empcode=${item.id.empcode}&cpcode=${item.id.cpcode}&<mytag:params includes="ec*,s*" type="queryStringUtf"/>">修改</a>
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
				input_txt.value = "!/pages/gas/Tempworklog/list.do?<mytag:params includes="ec*,s*" type="queryStringUtf"/>";
				form.appendChild(input_txt);
		        form.action = '${ctx}/pages/gas/Tempworklog/delete.do';
	            form.submit();
	        }
	  }
</script>