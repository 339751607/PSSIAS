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
	<title><%=Tcarcaseinfo.TABLE_ALIAS%> 维护</title>
</head>

<body onload="quickSelectInit()" >
<%@ include file="/commons/messages.jsp" %>

<div class="queryPanel">
    <s:form action="/pages/jxy/Tcarcaseinfo/list.do"  theme="simple" style="display: inline;" method="post">
	    <table cellpadding="0" cellspacing="0" border="0" class="tb_all">
	               <tr>
			              <td class="tb_title" colspan="4"><%=Tcarcaseinfo.TABLE_ALIAS%>查询</td>
		           </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=Tcarcaseinfo.ALIAS_ENROLID%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.enrolid}"  name="s_enrolid"  />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=Tcarcaseinfo.ALIAS_CREDID%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.credid}"  name="s_credid"  />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=Tcarcaseinfo.ALIAS_CREDUNIT%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.credunit}"  name="s_credunit"  />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=Tcarcaseinfo.ALIAS_PARTI%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.parti}"  name="s_parti"  />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=Tcarcaseinfo.ALIAS_PARTII%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.partii}"  name="s_partii"  />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=Tcarcaseinfo.ALIAS_PARTIII%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.partiii}"  name="s_partiii"  />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=Tcarcaseinfo.ALIAS_REPORTER%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.reporter}"  name="s_reporter"  />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=Tcarcaseinfo.ALIAS_REPTIME%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.reptime}"  name="s_reptime"  />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=Tcarcaseinfo.ALIAS_DEMO%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.demo}"  name="s_demo"  />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=Tcarcaseinfo.ALIAS_FLAG%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.flag}"  name="s_flag"  />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=Tcarcaseinfo.ALIAS_ENROLTIME%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.enroltime}"  name="s_enroltime"  />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=Tcarcaseinfo.ALIAS_OPERATOR%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.operator}"  name="s_operator"  />
		                  </td>
                   </tr>
		           <tr>
			              <td class="tb_bottom" colspan="4">
			                       <input type="submit"  value="查询" onclick="getReferenceForm(this).action='${ctx}/pages/jxy/Tcarcaseinfo/list.do'"/>
	                               <input type="submit"  value="新增" onclick="getReferenceForm(this).action='${ctx}/pages/jxy/Tcarcaseinfo/create.do?<mytag:params includes="ec*,s*" type="queryStringUtf"/>'"/>
	                               <input type="button"  value="删除" onclick="doDel();"/>
			              </td>
		           </tr>
	    </table>
    </s:form>
</div>



<ec:table items='page.result' var="item" method="get"
	retrieveRowsCallback="limit" sortRowsCallback="limit" filterRowsCallback="limit"
	action="${ctx}/pages/jxy/Tcarcaseinfo/list.do" autoIncludeParameters="true">
	<ec:row>
		<ec:column property="选择" title="<input type='checkbox' onclick=\"setAllCheckboxState('items',this.checked)\" >" sortable="false" width="3%" viewsAllowed="html">
			<input type="checkbox" name="items" value="enrolid=${item.id.enrolid}&credid=${item.id.credid}&"/>
		</ec:column>
		                    <ec:column property="enrolid"  title="<%=Tcarcaseinfo.ALIAS_ENROLID%>"/>
		                    <ec:column property="credid"  title="<%=Tcarcaseinfo.ALIAS_CREDID%>"/>
		                    <ec:column property="credunit"  title="<%=Tcarcaseinfo.ALIAS_CREDUNIT%>"/>
		                    <ec:column property="parti"  title="<%=Tcarcaseinfo.ALIAS_PARTI%>"/>
		                    <ec:column property="partii"  title="<%=Tcarcaseinfo.ALIAS_PARTII%>"/>
		                    <ec:column property="partiii"  title="<%=Tcarcaseinfo.ALIAS_PARTIII%>"/>
		                    <ec:column property="reporter"  title="<%=Tcarcaseinfo.ALIAS_REPORTER%>"/>
		                    <ec:column property="reptime"  title="<%=Tcarcaseinfo.ALIAS_REPTIME%>"/>
		                    <ec:column property="demo"  title="<%=Tcarcaseinfo.ALIAS_DEMO%>"/>
		                    <ec:column property="flag"  title="<%=Tcarcaseinfo.ALIAS_FLAG%>"/>
		                    <ec:column property="enroltime"  title="<%=Tcarcaseinfo.ALIAS_ENROLTIME%>"/>
		                    <ec:column property="operator" width="300px" title="<%=Tcarcaseinfo.ALIAS_OPERATOR%>"/>
		<ec:column property="操作" title="操作" sortable="false" viewsAllowed="html">
			<a href="${ctx}/pages/jxy/Tcarcaseinfo/show.do?enrolid=${item.id.enrolid}&credid=${item.id.credid}&<mytag:params includes="ec*,s*" type="queryStringUtf"/>">查看</a>&nbsp;&nbsp;&nbsp;
			<a href="${ctx}/pages/jxy/Tcarcaseinfo/edit.do?enrolid=${item.id.enrolid}&credid=${item.id.credid}&<mytag:params includes="ec*,s*" type="queryStringUtf"/>">修改</a>
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
				input_txt.value = "!/pages/jxy/Tcarcaseinfo/list.do?<mytag:params includes="ec*,s*" type="queryStringUtf"/>";
				form.appendChild(input_txt);
		        form.action = '${ctx}/pages/jxy/Tcarcaseinfo/delete.do';
	            form.submit();
	        }
	  }
</script>
