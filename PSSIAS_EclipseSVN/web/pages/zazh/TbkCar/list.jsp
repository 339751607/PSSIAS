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
	<title><%=TbkCar.TABLE_ALIAS%> 维护</title>
</head>

<body onload="quickSelectInit()" >
<%@ include file="/commons/messages.jsp" %>

<div class="queryPanel">
    <s:form name="queryForm" action="/pages/zazh/TbkCar/list.do"  theme="simple" style="display: inline;" method="post">
	    <table width="100%" border="1" bordercolor="#7c8ca7" align="center"  cellPadding="0" cellSpacing="0" class="tb_all">
	               <tr>
			              <td class="tb_title" colspan="4"><%=TbkCar.TABLE_ALIAS%>查询</td>
		           </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=TbkCar.ALIAS_CARCODE%>
		                  </td>
			              <td>
			                     <mytag:select  name="s_prefix"  
	         			             value="${pageRequest.filters.prefix}" dictName="cpht"/>	
		                           <input value="${pageRequest.filters.carcode}"  name="s_carcode"  />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=TbkCar.ALIAS_BODYCODE%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.bodycode}"  name="s_bodycode"  />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=TbkCar.ALIAS_ENGINECODE%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.enginecode}"  name="s_enginecode"  />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=TbkCar.ALIAS_CAROWNER%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.carowner}"  name="s_carowner"  />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=TbkCar.ALIAS_BKLX%>
		                  </td>
			              <td>
		                            <mytag:select  name="s_bklx"  
	         			             value="${pageRequest.filters.bklx}" dictName="DIC_ITEM_BKLX"/>
		                  </td>
		                   <td class="crosscolor_td">
			                      <%=TbkCar.ALIAS_CANCELFLAG%>
		                  </td>
			              <td>
		                            <mytag:select  name="s_cancelflag"  
	         			             value="${pageRequest.filters.cancelflag}" dictName="DIC_ITEM_CKBZ"/>
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">

                          <td class="crosscolor_td">
			                      <%=TbkCar.ALIAS_BKSJ%>
		                  </td>
			              <td colspan="3">
			              <table class="list">
								<tr>
									<td>
		                           <input id="d31312" name="s_bksj_start"  value="${pageRequest.filters.bksj_start}"   maxlength="0" size="15" class="Wdate" type="text" onFocus="WdatePicker({dateFmt:'yyyy-MM-dd',maxDate:'#F{$dp.$D(\'d31412\')}'})"/>
			                        </td>
									<td>到</td>
									<td>
			                          <input id="d31412" name="s_bksj_end"   value="${pageRequest.filters.bksj_end}"  maxlength="0" size="15" class="Wdate" type="text" onFocus="WdatePicker({dateFmt:'yyyy-MM-dd',minDate:'#F{$dp.$D(\'d31312\')}'})"/>
			              	        </td>
			              	     </tr>
							</table>  
		                  </td>
                   </tr>
		           <tr>
			              <td class="tb_bottom" colspan="4">
			                       <input type="submit"  value="查询" onclick="getReferenceForm(this).action='${ctx}/pages/zazh/TbkCar/list.do'"/>
	                               <input type="button" value="重置" onclick="resitData(document.forms.queryForm)"/>
	                               <input type="submit"  value="新增" onclick="getReferenceForm(this).action='${ctx}/pages/zazh/TbkCar/create.do?<mytag:params includes="ec*,s*" type="queryStringUtf"/>'"/>
	                               <!--  
	                               <input type="button"  value="删除" onclick="doDel();"/>
	                               -->
			              </td>
		           </tr>
	    </table>
    </s:form>
</div>



<ec:table items='page.result' var="item" method="get"
	retrieveRowsCallback="limit" sortRowsCallback="limit" filterRowsCallback="limit"
	action="${ctx}/pages/zazh/TbkCar/list.do" autoIncludeParameters="true">
	<ec:row>
		<ec:column property="选择" title="<input type='checkbox' onclick=\"setAllCheckboxState('items',this.checked)\" >" sortable="false" width="3%" viewsAllowed="html">
			<input type="checkbox" name="items" value="id=${item.id}&"/>
		</ec:column>
             <ec:column property="carcode"  title="<%=TbkCar.ALIAS_CARCODE%>"/>
             <ec:column property="bodycode"  title="<%=TbkCar.ALIAS_BODYCODE%>"/>
             <ec:column property="enginecode"  title="<%=TbkCar.ALIAS_ENGINECODE%>"/>
             <mytag:lookupcolumn property="cartype"  title="<%=TbkCar.ALIAS_CARTYPE%>"	cell="net.java.dev.ec.table.view.LookUpCell" dictType="cllx" />
                
             <ec:column property="brand"  title="<%=TbkCar.ALIAS_BRAND%>"/>
             <ec:column property="carmode"  title="<%=TbkCar.ALIAS_CARMODE%>"/>
             <mytag:lookupcolumn property="color"  title="<%=TbkCar.ALIAS_COLOR%>"	cell="net.java.dev.ec.table.view.LookUpCell" dictType="csys" />
             <ec:column property="carowner"  title="<%=TbkCar.ALIAS_CAROWNER%>"/>
             <mytag:lookupcolumn property="bklx"  title="<%=TbkCar.ALIAS_BKLX%>"	cell="net.java.dev.ec.table.view.LookUpCell" dictType="DIC_ITEM_BKLX" />
     	     <ec:column property="bksj"  parse="yyyyMMddhhmm" format="yyyy-MM-dd HH:mm" cell="date" value="${item.bksj}" title="<%=TbkCar.ALIAS_BKSJ%>"/>
             <mytag:lookupcolumn property="cancelflag"  title="<%=TbkCar.ALIAS_CANCELFLAG%>"	cell="net.java.dev.ec.table.view.LookUpCell" dictType="DIC_ITEM_CKBZ" />
      
		<ec:column property="操作" title="操作" sortable="false" viewsAllowed="html">
		<div align="left">
			<a href="${ctx}/pages/zazh/TbkCar/show.do?id=${item.id}&<mytag:params includes="ec*,s*" type="queryStringUtf"/>">查看</a>&nbsp;&nbsp;&nbsp;
			<c:if test="${item.cancelflag == '0' }">
				<a href="${ctx}/pages/zazh/TbkCar/edit.do?id=${item.id}&<mytag:params includes="ec*,s*" type="queryStringUtf"/>">修改</a>&nbsp;&nbsp;&nbsp;
				<a href="${ctx}/pages/zazh/TbkCar/cancel.do?id=${item.id}&<mytag:params includes="ec*,s*" type="queryStringUtf"/>">撤控</a>
		    </c:if>
		</div>
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
				input_txt.value = "!/pages/zazh/TbkCar/list.do?<mytag:params includes="ec*,s*" type="queryStringUtf"/>";
				form.appendChild(input_txt);
		        form.action = '${ctx}/pages/zazh/TbkCar/delete.do';
	            form.submit();
	        }
	  }
</script>