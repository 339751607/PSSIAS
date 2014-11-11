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
	<title><%=Telxs.TABLE_ALIAS%> 维护</title>
</head>

<body onload="quickSelectInit()" >
<%@ include file="/commons/messages.jsp" %>

<div class="queryPanel">
    <s:form action="/pages/fjy/Telxs/list.do"  theme="simple" style="display: inline;" method="post">
	    <table cellpadding="0" cellspacing="0" border="1" class="tb_all">
	               <tr>
			              <td class="tb_title" colspan="4"><%=Telxs.TABLE_ALIAS%>查询</td>
		           </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=Telxs.ALIAS_GMRXM%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.gmrxm}"  name="s_gmrxm"  />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=Telxs.ALIAS_GMRXB%>
		                  </td>
			              <td>
				                   <mytag:select  name="s_gmrxb" value="${pageRequest.filters.gmrxb}"  notEmpty="false"  dictName="T_DIC_SEX"/>
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=Telxs.ALIAS_GMRSFZH%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.gmrsfzh}"  name="s_gmrsfzh"  />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=Telxs.ALIAS_GMRLXDH%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.gmrlxdh}"  name="s_gmrlxdh"  />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=Telxs.ALIAS_GMRJTZZ%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.gmrjtzz}"  name="s_gmrjtzz"  />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=Telxs.ALIAS_JBR%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.jbr}"  name="s_jbr"  />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=Telxs.ALIAS_BZ%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.bz}"  name="s_bz"  />
		                  </td>
                          <td>&nbsp;</td>
                          <td>&nbsp;</td>
                   </tr>
		           <tr>
			              <td class="tb_bottom" colspan="4">
			                       <input type="submit"  value="查询" onclick="getReferenceForm(this).action='${ctx}/pages/fjy/Telxs/list.do'"/>
	                               <input type="submit"  value="新增" onclick="getReferenceForm(this).action='${ctx}/pages/fjy/Telxs/create.do?<mytag:params includes="ec*,s*" type="queryStringUtf"/>'"/>
	                               <input type="button"  value="删除" onclick="doDel();"/>
			              </td>
		           </tr>
	    </table>
    </s:form>
</div>



<ec:table items='page.result' var="item" method="get"
	retrieveRowsCallback="limit" sortRowsCallback="limit" filterRowsCallback="limit"
	action="${ctx}/pages/fjy/Telxs/list.do" autoIncludeParameters="true">
	<ec:row>
		<ec:column property="选择" title="<input type='checkbox' onclick=\"setAllCheckboxState('items',this.checked)\" >" sortable="false" width="3%" viewsAllowed="html">
			<input type="checkbox" name="items" value="telinfoid=${item.telinfoid}&"/>
		</ec:column>
		                    <ec:column property="gmrxm"  title="<%=Telxs.ALIAS_GMRXM%>"/>
				            <mytag:lookupcolumn property="gmrxb"  title="<%=Telxs.ALIAS_GMRXB%>"	cell="net.java.dev.ec.table.view.LookUpCell" dictType="T_DIC_SEX" />
		                    <ec:column property="gmrsfzh"  title="<%=Telxs.ALIAS_GMRSFZH%>"/>
		                    <ec:column property="gmrlxdh"  title="<%=Telxs.ALIAS_GMRLXDH%>"/>
		                    <ec:column property="gmrjtzz"  title="<%=Telxs.ALIAS_GMRJTZZ%>"/>
		                    <ec:column property="jbr"  title="<%=Telxs.ALIAS_JBR%>"/>
		                    <ec:column property="bz"  title="<%=Telxs.ALIAS_BZ%>"/>
		<ec:column property="操作" title="操作" sortable="false" viewsAllowed="html">
			<a href="${ctx}/pages/fjy/Telxs/show.do?telinfoid=${item.telinfoid}&<mytag:params includes="ec*,s*" type="queryStringUtf"/>">查看</a>&nbsp;&nbsp;&nbsp;
			<a href="${ctx}/pages/fjy/Telxs/edit.do?telinfoid=${item.telinfoid}&<mytag:params includes="ec*,s*" type="queryStringUtf"/>">修改</a>
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
				input_txt.value = "!/pages/fjy/Telxs/list.do?<mytag:params includes="ec*,s*" type="queryStringUtf"/>";
				form.appendChild(input_txt);
		        form.action = '${ctx}/pages/fjy/Telxs/delete.do';
	            form.submit();
	        }
	  }
</script>