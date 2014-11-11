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
	<title><%=SsGroup.TABLE_ALIAS%> 维护</title>
</head>

<body onload="quickSelectInit()" >
<%@ include file="/commons/messages.jsp" %>

<div class="queryPanel">
    <s:form action="/pages/SsGroup/list.do"  theme="simple" style="display: inline;" method="post">
	    <table cellpadding="0" cellspacing="0" border="0" width="100%" class="tb_all">
	               <tr>
			              <td class="tb_title" colspan="4">角色组查询</td>
		           </tr>

		           <tr class="crosscolor_tr">

		       
                          <td class="crosscolor_td">
			                      <%=SsGroup.ALIAS_GROUPNAME%>
		                  </td>
			              <td colspan="3">
		                           <input value="${pageRequest.filters.groupname}"  name="s_groupname"  />
		                  </td>
		                   
		                  
                   </tr>

		           <tr>
			              <td class="tb_bottom" colspan="4">
			                      <br>
			                       <input type="submit"  value="查询" onclick="getReferenceForm(this).action='${ctx}/pages/SsGroup/list.do'"/>
	                             <!--  
	                               <input type="submit"  value="新增" onclick="getReferenceForm(this).action='${ctx}/pages/SsGroup/create.do?<mytag:params includes="ec*,s*" type="queryStringUtf"/>'"/>
	                               <input type="button"  value="删除" onclick="doDel();"/>
	                              -->
			              </td>
		           </tr>
	    </table>
    </s:form>
</div>



<ec:table items='page.result' var="item" method="get"
	retrieveRowsCallback="limit" sortRowsCallback="limit" filterRowsCallback="limit"
	action="${ctx}/pages/SsGroup/list.do" autoIncludeParameters="true">
	<ec:row>
           <ec:column property="groupname"  title="<%=SsGroup.ALIAS_GROUPNAME%>"/>
           <ec:column property="groupdesc"  title="<%=SsGroup.ALIAS_GROUPDESC%>"/>                      
           <ec:column property="isleaf"  title="<%=SsGroup.ALIAS_ISLEAF%>"/>
           <ec:column property="displayorder"  title="<%=SsGroup.ALIAS_DISPLAYORDER%>"/>
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
				input_txt.value = "!/pages/SsGroup/list.do?<mytag:params includes="ec*,s*" type="queryStringUtf"/>";
				form.appendChild(input_txt);
		        form.action = '${ctx}/pages/SsGroup/delete.do';
	            form.submit();
	        }
	  }
</script>