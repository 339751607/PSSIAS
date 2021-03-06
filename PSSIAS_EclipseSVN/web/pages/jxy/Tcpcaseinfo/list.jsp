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
	<title><%=Tcpcaseinfo.TABLE_ALIAS%> 维护</title>
</head>

<body onload="quickSelectInit()" >
<%@ include file="/commons/messages.jsp" %>

<div class="queryPanel">
    <s:form action="/pages/jxy/Tcpcaseinfo/list.do"  theme="simple" style="display: inline;" method="post">
	    <table cellpadding="0" cellspacing="0" border="0" class="tb_all">
	               <tr>
			              <td class="tb_title" colspan="4"><%=Tcpcaseinfo.TABLE_ALIAS%>查询</td>
		           </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=Tcpcaseinfo.ALIAS_CPCODE%>
		                  </td>
			              <td class="crosscolor_td2">
		                           <input value="${pageRequest.filters.cpcode}"  name="s_cpcode"  />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=Tcpcaseinfo.ALIAS_CASECODE%>
		                  </td>
			              <td class="crosscolor_td2">
		                           <input value="${pageRequest.filters.casecode}"  name="s_casecode"  />
		                  </td>
                   </tr>
		         
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=Tcpcaseinfo.ALIAS_CASETYPE%>
		                  </td>
			              <td colspan="3">
		                           
		                           <mytag:select value="${pageRequest.filters.casetype}" name="s_casetype" notEmpty="false" dictName="Diccon_AJ"></mytag:select>
		                  </td>
		                  
                   </tr>
		         
		           <tr>
			              <td class="tb_bottom" colspan="4">
			                       <input type="submit"  value="查询" onclick="getReferenceForm(this).action='${ctx}/pages/jxy/Tcpcaseinfo/list.do'"/>
	                               <input type="button" value="重置" onclick="resitData(document.forms[0])"/>
	                               <input type="submit"  value="新增" onclick="getReferenceForm(this).action='${ctx}/pages/jxy/Tcpcaseinfo/create.do?<mytag:params includes="ec*,s*" type="queryStringUtf"/>'"/>
	                              
			              </td>
		           </tr>
	    </table>
    </s:form>
</div>



<ec:table items='page.result' var="item" method="get"
	retrieveRowsCallback="limit" sortRowsCallback="limit" filterRowsCallback="limit"
	action="${ctx}/pages/jxy/Tcpcaseinfo/list.do" autoIncludeParameters="true">
	<ec:row>
		
	
		                    <ec:column property="cpcode"  title="<%=Tcpcaseinfo.ALIAS_CPCODE%>"/>
		                    <ec:column property="name"  title="<%=Tcpcaseinfo.ALIAS_NAME%>"/>
		                    <ec:column property="casecode"  title="<%=Tcpcaseinfo.ALIAS_CASECODE%>"/>
		                    <ec:column property="happentime"  parse="yyyyMMddhhmm" format="yyyy-MM-dd hh:mm" cell="date" title="<%=Tcpcaseinfo.ALIAS_HAPPENTIME%>"/>
		                    <mytag:lookupcolumn property="caseflag"  title="<%=Tcpcaseinfo.ALIAS_CASEFLAG%>"	cell="net.java.dev.ec.table.view.LookUpCell" dictType="DIC_ITEM_CASEFLAG" />
		                   
		                     <mytag:lookupcolumn property="casetype"  title="<%=Tcpcaseinfo.ALIAS_CASETYPE%>"	cell="net.java.dev.ec.table.view.LookUpCell" dictType="Diccon_AJ" />
		                    
		                    <ec:column width="300px" property="casedesc"  title="<%=Tcpcaseinfo.ALIAS_CASEDESC%>"/>
		                    
		<ec:column width="30px" property="操作" title="操作" sortable="false" viewsAllowed="html">
			<a href="${ctx}/pages/jxy/Tcpcaseinfo/show.do?cpcode=${item.cpcode}&casecode=${item.casecode}&<mytag:params includes="ec*,s*" type="queryStringUtf"/>">查看</a>
			<a href="${ctx}/pages/jxy/Tcpcaseinfo/edit.do?cpcode=${item.cpcode}&casecode=${item.casecode}&<mytag:params includes="ec*,s*" type="queryStringUtf"/>">修改</a>
			<a href="${ctx}/pages/jxy/Tcpcaseinfo/delete.do?cpcode=${item.cpcode}&casecode=${item.casecode}&<mytag:params includes="ec*,s*" type="queryStringUtf"/>" onClick="return confirm('确定执行[删除]操作?')">删除</a>
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
				input_txt.value = "!/pages/jxy/Tcpcaseinfo/list.do?<mytag:params includes="ec*,s*" type="queryStringUtf"/>";
				form.appendChild(input_txt);
		        form.action = '${ctx}/pages/jxy/Tcpcaseinfo/delete.do';
	            form.submit();
	        }
	  }
</script>
