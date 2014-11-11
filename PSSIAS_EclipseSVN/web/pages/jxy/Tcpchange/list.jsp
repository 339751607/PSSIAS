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
	<title><%=Tcpchange.TABLE_ALIAS%> 维护</title>
</head>

<body onload="quickSelectInit()" >
<%@ include file="/commons/messages.jsp" %>

<div class="queryPanel">
    <s:form action="/jxy/Tcpchange/list.do"  theme="simple" style="display: inline;" method="post">
	    <table cellpadding="0" cellspacing="0" border="0" class="tb_all">
	               <tr>
			              <td class="tb_title" colspan="4"><%=Tcpchange.TABLE_ALIAS%>查询</td>
		           </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=Tcpchange.ALIAS_CPCODE%>
		                  </td>
			              <td class="crosscolor_td2">
		                           <input value="${pageRequest.filters.cpcode}"  name="s_cpcode"  />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=Tcpchange.ALIAS_CHANGEDATE%>
		                  </td>
			              <td class="crosscolor_td2">
		                           <input value="${pageRequest.filters.changedate}"  name="s_changedate"  />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=Tcpchange.ALIAS_CHANGECODE%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.changecode}"  name="s_changecode"  />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=Tcpchange.ALIAS_BEFORECONTEN%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.beforeconten}"  name="s_beforeconten"  />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=Tcpchange.ALIAS_AFTERCONTENT%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.aftercontent}"  name="s_aftercontent"  />
		                  </td>
                          <td>&nbsp;</td>
                          <td>&nbsp;</td>
                   </tr>
		           <tr>
			              <td class="tb_bottom" colspan="4">
			                       <input type="submit"  value="查询" onclick="getReferenceForm(this).action='${ctx}/jxy/Tcpchange/list.do'"/>
	                              
	                               
			              </td>
		           </tr>
	    </table>
    </s:form>
</div>



<ec:table items='page.result' var="item" method="get"
	retrieveRowsCallback="limit" sortRowsCallback="limit" filterRowsCallback="limit"
	action="${ctx}/jxy/Tcpchange/list.do" autoIncludeParameters="true">
	<ec:row>
		                    <ec:column property="cpcode"  title="<%=Tcpchange.ALIAS_CPCODE%>"/>
		                    <ec:column property="name"  title="<%=Tcpchange.ALIAS_NAME%>"/>
		                    <ec:column property="changedate"  parse="yyyyMMdd" format="yyyy-MM-dd" cell="date" title="<%=Tcpchange.ALIAS_CHANGEDATE%>"/>
		                    
		                    
		                    <mytag:lookupcolumn property="changecode"  title="<%=Tcpchange.ALIAS_CHANGECODE%>"	cell="net.java.dev.ec.table.view.LookUpCell" dictType="cybg" />
		                    
		                    <ec:column property="beforeconten"  title="<%=Tcpchange.ALIAS_BEFORECONTEN%>"/>
		                    <ec:column property="aftercontent"  title="<%=Tcpchange.ALIAS_AFTERCONTENT%>"/>
		
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
				input_txt.value = "!/jxy/Tcpchange/list.do?<mytag:params includes="ec*,s*" type="queryStringUtf"/>";
				form.appendChild(input_txt);
		        form.action = '${ctx}/jxy/Tcpchange/delete.do';
	            form.submit();
	        }
	  }
</script>
