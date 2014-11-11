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
	<title><%=Tcarreturn.TABLE_ALIAS%> 维护</title>
</head>

<body onload="quickSelectInit()" >
<%@ include file="/commons/messages.jsp" %>

<div class="queryPanel">
    <s:form action="/jxy/Tcarreturn/list.do"  theme="simple" style="display: inline;" method="post">
	    <table cellpadding="0" cellspacing="0" border="0" class="tb_all">
	               <tr>
			              <td class="tb_title" colspan="4"><%=Tcarreturn.TABLE_ALIAS%>查询</td>
		           </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=Tcarreturn.ALIAS_DELINAME%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.deliname}"  name="s_deliname"  />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=Tcarreturn.ALIAS_DELICREDTYPE%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.delicredtype}"  name="s_delicredtype"  />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=Tcarreturn.ALIAS_DELICREDCODE%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.delicredcode}"  name="s_delicredcode"  />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=Tcarreturn.ALIAS_RECETIME%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.recetime}"  name="s_recetime"  />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=Tcarreturn.ALIAS_RECENAME%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.recename}"  name="s_recename"  />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=Tcarreturn.ALIAS_TAKEOFFNAME%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.takeoffname}"  name="s_takeoffname"  />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=Tcarreturn.ALIAS_TOCREDTYPE%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.tocredtype}"  name="s_tocredtype"  />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=Tcarreturn.ALIAS_TOCREDCODE%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.tocredcode}"  name="s_tocredcode"  />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=Tcarreturn.ALIAS_TOTIME%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.totime}"  name="s_totime"  />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=Tcarreturn.ALIAS_FLAG%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.flag}"  name="s_flag"  />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=Tcarreturn.ALIAS_ENROLTIME%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.enroltime}"  name="s_enroltime"  />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=Tcarreturn.ALIAS_OPERATOR%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.operator}"  name="s_operator"  />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=Tcarreturn.ALIAS_DELITELEPHONE%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.delitelephone}"  name="s_delitelephone"  />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=Tcarreturn.ALIAS_SERVERITEM%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.serveritem}"  name="s_serveritem"  />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=Tcarreturn.ALIAS_DEMO%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.demo}"  name="s_demo"  />
		                  </td>
                          <td>&nbsp;</td>
                          <td>&nbsp;</td>
                   </tr>
		           <tr>
			              <td class="tb_bottom" colspan="4">
			                       <input type="submit"  value="查询" onclick="getReferenceForm(this).action='${ctx}/jxy/Tcarreturn/list.do'"/>
	                               <input type="submit"  value="新增" onclick="getReferenceForm(this).action='${ctx}/jxy/Tcarreturn/create.do?<mytag:params includes="ec*,s*" type="queryStringUtf"/>'"/>
	                               <input type="button"  value="删除" onclick="doDel();"/>
			              </td>
		           </tr>
	    </table>
    </s:form>
</div>



<ec:table items='page.result' var="item" method="get"
	retrieveRowsCallback="limit" sortRowsCallback="limit" filterRowsCallback="limit"
	action="${ctx}/jxy/Tcarreturn/list.do" autoIncludeParameters="true">
	<ec:row>
		<ec:column property="选择" title="<input type='checkbox' onclick=\"setAllCheckboxState('items',this.checked)\" >" sortable="false" width="3%" viewsAllowed="html">
			<input type="checkbox" name="items" value="enrolid=${item.enrolid}&"/>
		</ec:column>
		                    <ec:column property="deliname"  title="<%=Tcarreturn.ALIAS_DELINAME%>"/>
		                    <ec:column property="delicredtype"  title="<%=Tcarreturn.ALIAS_DELICREDTYPE%>"/>
		                    <ec:column property="delicredcode"  title="<%=Tcarreturn.ALIAS_DELICREDCODE%>"/>
		                    <ec:column property="recetime"  title="<%=Tcarreturn.ALIAS_RECETIME%>"/>
		                    <ec:column property="recename"  title="<%=Tcarreturn.ALIAS_RECENAME%>"/>
		                    <ec:column property="takeoffname"  title="<%=Tcarreturn.ALIAS_TAKEOFFNAME%>"/>
		                    <ec:column property="tocredtype"  title="<%=Tcarreturn.ALIAS_TOCREDTYPE%>"/>
		                    <ec:column property="tocredcode"  title="<%=Tcarreturn.ALIAS_TOCREDCODE%>"/>
		                    <ec:column property="totime"  title="<%=Tcarreturn.ALIAS_TOTIME%>"/>
		                    <ec:column property="flag"  title="<%=Tcarreturn.ALIAS_FLAG%>"/>
		                    <ec:column property="enroltime"  title="<%=Tcarreturn.ALIAS_ENROLTIME%>"/>
		                    <ec:column property="operator"  title="<%=Tcarreturn.ALIAS_OPERATOR%>"/>
		                    <ec:column property="delitelephone"  title="<%=Tcarreturn.ALIAS_DELITELEPHONE%>"/>
		                    <ec:column property="serveritem"  title="<%=Tcarreturn.ALIAS_SERVERITEM%>"/>
		                    <ec:column property="demo"  title="<%=Tcarreturn.ALIAS_DEMO%>"/>
		<ec:column property="操作" title="操作" sortable="false" viewsAllowed="html">
			<a href="${ctx}/jxy/Tcarreturn/show.do?enrolid=${item.enrolid}&<mytag:params includes="ec*,s*" type="queryStringUtf"/>">查看</a>&nbsp;&nbsp;&nbsp;
			<a href="${ctx}/jxy/Tcarreturn/edit.do?enrolid=${item.enrolid}&<mytag:params includes="ec*,s*" type="queryStringUtf"/>">修改</a>
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
				input_txt.value = "!/jxy/Tcarreturn/list.do?<mytag:params includes="ec*,s*" type="queryStringUtf"/>";
				form.appendChild(input_txt);
		        form.action = '${ctx}/jxy/Tcarreturn/delete.do';
	            form.submit();
	        }
	  }
</script>
