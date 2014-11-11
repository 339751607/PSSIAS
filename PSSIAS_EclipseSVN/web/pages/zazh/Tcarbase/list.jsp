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
	<title>车辆信息查询</title>
</head>

<body onload="quickSelectInit()" >
<%@ include file="/commons/messages.jsp" %>

<div class="queryPanel">
    <s:form action="/pages/zazh/Tcarbase/list.do"  theme="simple" style="display: inline;" method="post">
	    <table width="100%" border="1" bordercolor="#7c8ca7" align="center"  cellPadding="0" cellSpacing="0" class="tb_all">
	               <tr>
			              <td class="tb_title" colspan="4">车辆信息查询</td>
		           </tr>
		          		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=Tcarbase.ALIAS_CAROWNER%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.carowner}"  name="s_carowner"  />
		                  </td>
            
                          <td class="crosscolor_td">
			                      <%=Tcarbase.ALIAS_CARID%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.carid}"  name="s_carid"  />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=Tcarbase.ALIAS_ENGINECODE%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.enginecode}"  name="s_enginecode"  />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=Tcarbase.ALIAS_BODYCODE%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.bodycode}"  name="s_bodycode"  />
		                  </td>
                   </tr>

		           <tr>
			              <td class="tb_bottom" colspan="4">
			                       <input type="submit"  value="查询" onclick="getReferenceForm(this).action='${ctx}/pages/zazh/Tcarbase/list.do'"/>
	                               <!--  
	                               <input type="submit"  value="新增" onclick="getReferenceForm(this).action='${ctx}/pages/zazh/Tcarbase/create.do?<mytag:params includes="ec*,s*" type="queryStringUtf"/>'"/>
	                               <input type="button"  value="删除" onclick="doDel();"/>
	                               -->
			              </td>
		           </tr>
	    </table>
    </s:form>
</div>



<ec:table items='page.result' var="item" method="get"
	retrieveRowsCallback="limit" sortRowsCallback="limit" filterRowsCallback="limit"
	action="${ctx}/pages/zazh/Tcarbase/list.do" autoIncludeParameters="true">
	<ec:row>
		<ec:column property="carid"  title="<%=Tcarbase.ALIAS_CARID%>"/>        
        <ec:column property="carowner"  title="<%=Tcarbase.ALIAS_CAROWNER%>"/>  
        <ec:column property="enginecode"  title="<%=Tcarbase.ALIAS_ENGINECODE%>"/>
        <ec:column property="bodycode"  title="<%=Tcarbase.ALIAS_BODYCODE%>"/>      
        <mytag:lookupcolumn property="cartype"  title="<%=Tcarbase.ALIAS_CARTYPE%>"	cell="net.java.dev.ec.table.view.LookUpCell" dictType="cllx" />
                
        <ec:column property="brand"  title="<%=Tcarbase.ALIAS_BRAND%>"/>
        <ec:column property="carmode"  title="<%=Tcarbase.ALIAS_CARMODE%>"/>
        <mytag:lookupcolumn property="color"  title="<%=Tcarbase.ALIAS_COLOR%>"	cell="net.java.dev.ec.table.view.LookUpCell" dictType="csys" />
        <ec:column property="updatetime"  parse="yyyyMMddhhmmss" format="yyyy-MM-dd HH:mm:ss" cell="date" value="${item.updatetime}" title="<%=Tcarbase.ALIAS_UPDATETIME%>"/>
           
		
		<ec:column property="操作" title="操作" sortable="false" viewsAllowed="html">
			<a href="${ctx}/pages/zazh/Tcarbase/show.do?id=${item.id}&<mytag:params includes="ec*,s*" type="queryStringUtf"/>">查看</a>&nbsp;&nbsp;&nbsp;
			<!--  
			<a href="${ctx}/pages/zazh/Tcarbase/edit.do?id=${item.id}&<mytag:params includes="ec*,s*" type="queryStringUtf"/>">修改</a>
		    -->
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
				input_txt.value = "!/pages/zazh/Tcarbase/list.do?<mytag:params includes="ec*,s*" type="queryStringUtf"/>";
				form.appendChild(input_txt);
		        form.action = '${ctx}/pages/zazh/Tcarbase/delete.do';
	            form.submit();
	        }
	  }
</script>