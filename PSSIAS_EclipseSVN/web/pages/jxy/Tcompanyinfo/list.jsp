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
	<title><%=Tcompanyinfo.TABLE_ALIAS%> 维护</title>
</head>

<body onload="quickSelectInit()" >
<%@ include file="/commons/messages.jsp" %>

<div class="queryPanel">
    <s:form action="/jxy/Tcompanyinfo/list.do"  theme="simple" style="display: inline;" method="post">
	    <table cellpadding="0" cellspacing="0" border="0" class="tb_all">
	               <tr>
			              <td class="tb_title" colspan="4"><%=Tcompanyinfo.TABLE_ALIAS%>查询</td>
		           </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=Tcompanyinfo.ALIAS_CPNAME%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.cpname}"  name="s_cpname"  />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=Tcompanyinfo.ALIAS_CPADDRESS%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.cpaddress}"  name="s_cpaddress"  />
		                  </td>
                   </tr>
		      
		           <tr class="crosscolor_tr">
                         <td class="crosscolor_td">
			                      <%=Tcompanyinfo.ALIAS_STATION%>
		                  </td>
			              <td>
		                           
		                            <mytag:select  name="s_station" value="${pageRequest.filters.station}"  notEmpty="false"  dictName="sspcs"/>
		                  </td>
                         
		                 
		                   <td class="crosscolor_td">
			                      <%=Tcompanyinfo.ALIAS_ECONOMY%>
		                  </td>
			              <td>
		                           
		                           <mytag:select  name="s_economy" value="${pageRequest.filters.economy}"  notEmpty="false"  dictName="T_DIC_CPKIND"/>
		                  </td>
                   </tr>
		          
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=Tcompanyinfo.ALIAS_CORPNAME%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.corpname}"  name="s_corpname"  />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=Tcompanyinfo.ALIAS_POLICENAME%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.policename}"  name="s_policename"  />
		                  </td>
                   </tr>
		         
		         
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=Tcompanyinfo.ALIAS_POLICEUNIT%>
		                  </td>
			              <td>
		                          
		                           <mytag:select name="s_policeunit" value="${pageRequest.filters.policeunit}" notEmpty="false" dictName="ssfj"></mytag:select>
		                  </td>                       
                   </tr>
	           <tr>
			              <td class="tb_bottom" colspan="4">
			                       <input type="submit"  value="查询" onclick="getReferenceForm(this).action='${ctx}/jxy/Tcompanyinfo/list.do'"/>
	                               <input type="submit"  value="新增" onclick="getReferenceForm(this).action='${ctx}/jxy/Tcompanyinfo/create.do?<mytag:params includes="ec*,s*" type="queryStringUtf"/>'"/>
	                               <input type="button"  value="删除" onclick="doDel();"/>
			              </td>
		           </tr>
	    </table>
    </s:form>
</div>



<ec:table items='page.result' var="item" method="get"
	retrieveRowsCallback="limit" sortRowsCallback="limit" filterRowsCallback="limit"
	action="${ctx}/jxy/Tcompanyinfo/list.do" autoIncludeParameters="true">
	<ec:row >
		<ec:column property="选择" title="<input type='checkbox' onclick=\"setAllCheckboxState('items',this.checked)\" >" sortable="false" width="3%" viewsAllowed="html">
			<input type="checkbox" name="items" value="cpcode=${item.cpcode}&"/>
		</ec:column>			
		                    <ec:column property="cpname"  title="<%=Tcompanyinfo.ALIAS_CPNAME%>"/>
		                    <ec:column property="cpaddress"  title="<%=Tcompanyinfo.ALIAS_CPADDRESS%>"/>		                    
		                    <ec:column property="corpname"  title="<%=Tcompanyinfo.ALIAS_CORPNAME%>"/>
		                    <ec:column property="policename"  title="<%=Tcompanyinfo.ALIAS_POLICENAME%>"/>		                   	                    
		<ec:column property="操作" title="操作" sortable="false" viewsAllowed="html">
			<a href="${ctx}/jxy/Tcompanyinfo/show.do?cpcode=${item.cpcode}&<mytag:params includes="ec*,s*" type="queryStringUtf"/>">查看</a>&nbsp;&nbsp;&nbsp;
			<a href="${ctx}/jxy/Tcompanyinfo/edit.do?cpcode=${item.cpcode}&<mytag:params includes="ec*,s*" type="queryStringUtf"/>">修改</a>
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
				input_txt.value = "!/jxy/Tcompanyinfo/list.do?<mytag:params includes="ec*,s*" type="queryStringUtf"/>";
				form.appendChild(input_txt);
		        form.action = '${ctx}/jxy/Tcompanyinfo/delete.do';
	            form.submit();
	        }
	  }
</script>
