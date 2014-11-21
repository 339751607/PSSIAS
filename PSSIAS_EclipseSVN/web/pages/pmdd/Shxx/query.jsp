<%@page import="com.dyneinfo.pmdd.model.*" %>
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
	<title><%=Shxx.TABLE_ALIAS%>查询</title>
</head>

<body onload="quickSelectInit()" >
<%@ include file="/commons/messages.jsp" %>

<div class="queryPanel">
    <s:form action="/pages/pmdd/Shxx/list.do"  theme="simple" style="display: inline;" method="post">
	    <table cellpadding="0" cellspacing="0" border="0" class="tb_all">
	               <tr>
			              <td class="tb_title" colspan="6"><%=Shxx.TABLE_ALIAS%>查询</td>
		           </tr>
		           <tr class="crosscolor_tr">

                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=Shxx.ALIAS_SHRXM%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.shrxm}"  name="s_shrxm"  />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=Shxx.ALIAS_SHRSFZHM%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.shrsfzhm}"  name="s_shrsfzhm"  />
		                  </td>
		                  
		                  <td class="crosscolor_td">
			                      <%=Shxx.ALIAS_DDLX%>
		                  </td>
			              <td>
				                   <mytag:select  name="s_ddlx" value="${pageRequest.filters.ddlx}"  notEmpty="false"  dictName="ddlb"/>
		                  </td>
                   </tr>

		           <tr class="crosscolor_tr">
		           		<td class="crosscolor_td">
			                      <%=Shxx.ALIAS_HTID%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.htid}"  name="s_htid"  />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=Shxx.ALIAS_SHRQ%>
		                  </td>
			              <td colspan="3">
				              <table class="list">
			              		<tr>
			              			<td>
			              				<s:select name="dateSelect7" list="dateSelectMap"  onchange="dateselect(this,'s_shrqBegin','s_shrqEnd','yyyy-MM-dd');"  value="#request.dateSelect7" listKey="key"   listValue="value" theme="simple" label=""  emptyOption="false" ></s:select>
			              			</td>
			              			<td>从</td>
			              			<td>
			              				<input id="d3137" name="s_shrqBegin"  value="${pageRequest.filters.shrqBegin}"   maxlength="0" size="12" class="Wdate" type="text" onFocus="WdatePicker({dateFmt:'yyyy-MM-dd',maxDate:'#F{$dp.$D(\'d3147\')}'})"/>
			              			</td>
			              			<td>到</td>
			              			<td>
			              				<input id="d3147" name="s_shrqEnd"   value="${pageRequest.filters.shrqEnd}"  maxlength="0" size="12" class="Wdate" type="text" onFocus="WdatePicker({dateFmt:'yyyy-MM-dd',minDate:'#F{$dp.$D(\'d3137\')}'})"/>
			              			</td>
			              		</tr>
			              	</table>
		                  </td>
                   </tr>
		           <tr>
			              <td class="tb_bottom" colspan="6">
			                       <input type="submit"  value="查询" onclick="getReferenceForm(this).action='${ctx}/pages/pmdd/Shxx/list.do?query=true'"/>
			              		   <input style="margin-left: 20px" type="button" value="重置" onclick="resitData(document.forms[0])"/>
			              </td>
		           </tr>
	    </table>
    </s:form>
</div>



<ec:table items='page.result' var="item" method="get"
	retrieveRowsCallback="limit" sortRowsCallback="limit" filterRowsCallback="limit"
	action="${ctx}/pages/pmdd/Shxx/list.do" autoIncludeParameters="true">
	<ec:row>
		<ec:column property="选择" title="<input type='checkbox' onclick=\"setAllCheckboxState('items',this.checked)\" >" sortable="false" width="3%" viewsAllowed="html">
			<input type="checkbox" name="items" value="xh=${item.xh}&"/>
		</ec:column>
		                    <ec:column property="htid"  title="<%=Shxx.ALIAS_HTID%>"/>
		                    <ec:column property="shrxm"  title="<%=Shxx.ALIAS_SHRXM%>"/>
		                    <ec:column property="shrsfzhm"  title="<%=Shxx.ALIAS_SHRSFZHM%>"/>
				             <ec:column property="shrq"  parse="yyyyMMddHHmmss" format="yyyy-MM-dd HH:mm:ss" cell="date"  title="<%=Shxx.ALIAS_SHRQ%>"/>
				            <ec:column property="lrrq"  parse="yyyyMMdd" format="yyyy-MM-dd" cell="date"  title="<%=Shxx.ALIAS_LRRQ%>"/>
		                   <ec:column property="tdr"  title="<%=Shxx.ALIAS_TDR%>"/>
		<ec:column property="操作" title="操作" sortable="false" viewsAllowed="html">
			<a href="${ctx}/pages/pmdd/Shxx/show.do?xh=${item.xh}&<mytag:params includes="ec*,s*" type="queryStringUtf"/>">查看</a>&nbsp;&nbsp;&nbsp;
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
				input_txt.value = "!/pages/pmdd/Shxx/list.do?<mytag:params includes="ec*,s*" type="queryStringUtf"/>";
				form.appendChild(input_txt);
		        form.action = '${ctx}/pages/pmdd/Shxx/delete.do';
	            form.submit();
	        }
	  }
</script>