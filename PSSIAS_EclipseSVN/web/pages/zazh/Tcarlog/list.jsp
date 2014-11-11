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
	<title><%=Tcarlog.TABLE_ALIAS%> 维护</title>
</head>

<body onload="quickSelectInit()" >
<%@ include file="/commons/messages.jsp" %>

<div class="queryPanel">
    <s:form action="/pages/zazh/Tcarlog/list.do"  theme="simple" style="display: inline;" method="post">
	    <table width="100%" border="1" bordercolor="#7c8ca7" align="center"  cellPadding="0" cellSpacing="0" class="tb_all">
	               <tr>
			              <td class="tb_title" colspan="4"><%=Tcarlog.TABLE_ALIAS%>查询</td>
		           </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=Tcarlog.ALIAS_CARBASEID%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.carbaseid}"  name="s_carbaseid"  />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=Tcarlog.ALIAS_SOURCE%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.source}"  name="s_source"  />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=Tcarlog.ALIAS_SID%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.sid}"  name="s_sid"  />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=Tcarlog.ALIAS_CARTYPE%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.cartype}"  name="s_cartype"  />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=Tcarlog.ALIAS_STARTTIME%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.starttime}"  name="s_starttime"  />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=Tcarlog.ALIAS_ENDTIME%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.endtime}"  name="s_endtime"  />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=Tcarlog.ALIAS_INSERTTIME%>
		                  </td>
			              <td>
		                           <s:select name="dateSelect6" list="dateSelectMap"  onchange="dateselect(this,'s_inserttimeBegin','s_inserttimeEnd','yyyy-MM-dd');"  value="#request.dateSelect6" listKey="key"   listValue="value" theme="simple" label=""  emptyOption="false" ></s:select>
			                          从<input id="d3136" name="s_inserttimeBegin"  value="${pageRequest.filters.inserttimeBegin}"   maxlength="0" size="12" class="Wdate" type="text" onFocus="WdatePicker({dateFmt:'<%=Tcarlog.FORMAT_INSERTTIME%>',maxDate:'#F{$dp.$D(\'d3146\')}'})"/> &nbsp;到&nbsp;
			                        <input id="d3146" name="s_inserttimeEnd"   value="${pageRequest.filters.inserttimeEnd}"  maxlength="0" size="12" class="Wdate" type="text" onFocus="WdatePicker({dateFmt:'<%=Tcarlog.FORMAT_INSERTTIME%>',minDate:'#F{$dp.$D(\'d3136\')}'})"/>
		                  </td>
                          <td class="crosscolor_td">
			                      <%=Tcarlog.ALIAS_UPDATETIME%>
		                  </td>
			              <td>
		                           <s:select name="dateSelect7" list="dateSelectMap"  onchange="dateselect(this,'s_updatetimeBegin','s_updatetimeEnd','yyyy-MM-dd');"  value="#request.dateSelect7" listKey="key"   listValue="value" theme="simple" label=""  emptyOption="false" ></s:select>
			                          从<input id="d3137" name="s_updatetimeBegin"  value="${pageRequest.filters.updatetimeBegin}"   maxlength="0" size="12" class="Wdate" type="text" onFocus="WdatePicker({dateFmt:'<%=Tcarlog.FORMAT_UPDATETIME%>',maxDate:'#F{$dp.$D(\'d3147\')}'})"/> &nbsp;到&nbsp;
			                        <input id="d3147" name="s_updatetimeEnd"   value="${pageRequest.filters.updatetimeEnd}"  maxlength="0" size="12" class="Wdate" type="text" onFocus="WdatePicker({dateFmt:'<%=Tcarlog.FORMAT_UPDATETIME%>',minDate:'#F{$dp.$D(\'d3137\')}'})"/>
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=Tcarlog.ALIAS_TABLEFORPIC%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.tableforpic}"  name="s_tableforpic"  />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=Tcarlog.ALIAS_FIELDFORPIC%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.fieldforpic}"  name="s_fieldforpic"  />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=Tcarlog.ALIAS_CPCODE%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.cpcode}"  name="s_cpcode"  />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=Tcarlog.ALIAS_KEYFORPIC%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.keyforpic}"  name="s_keyforpic"  />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=Tcarlog.ALIAS_CARID%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.carid}"  name="s_carid"  />
		                  </td>
                          <td>&nbsp;</td>
                          <td>&nbsp;</td>
                   </tr>
		           <tr>
			              <td class="tb_bottom" colspan="4">
			                       <input type="submit"  value="查询" onclick="getReferenceForm(this).action='${ctx}/pages/zazh/Tcarlog/list.do'"/>
	                               <input type="submit"  value="新增" onclick="getReferenceForm(this).action='${ctx}/pages/zazh/Tcarlog/create.do?<mytag:params includes="ec*,s*" type="queryStringUtf"/>'"/>
	                               <input type="button"  value="删除" onclick="doDel();"/>
			              </td>
		           </tr>
	    </table>
    </s:form>
</div>



<ec:table items='page.result' var="item" method="get"
	retrieveRowsCallback="limit" sortRowsCallback="limit" filterRowsCallback="limit"
	action="${ctx}/pages/zazh/Tcarlog/list.do" autoIncludeParameters="true">
	<ec:row>
		<ec:column property="选择" title="<input type='checkbox' onclick=\"setAllCheckboxState('items',this.checked)\" >" sortable="false" width="3%" viewsAllowed="html">
			<input type="checkbox" name="items" value="id=${item.id}&"/>
		</ec:column>
		                    <ec:column property="carbaseid"  title="<%=Tcarlog.ALIAS_CARBASEID%>"/>
		                    <ec:column property="source"  title="<%=Tcarlog.ALIAS_SOURCE%>"/>
		                    <ec:column property="sid"  title="<%=Tcarlog.ALIAS_SID%>"/>
		                    <ec:column property="cartype"  title="<%=Tcarlog.ALIAS_CARTYPE%>"/>
		                    <ec:column property="starttime"  title="<%=Tcarlog.ALIAS_STARTTIME%>"/>
		                    <ec:column property="endtime"  title="<%=Tcarlog.ALIAS_ENDTIME%>"/>
		                    <ec:column property="inserttime" value="${item.inserttimeString}" title="<%=Tcarlog.ALIAS_INSERTTIME%>"/>
		                    <ec:column property="updatetime" value="${item.updatetimeString}" title="<%=Tcarlog.ALIAS_UPDATETIME%>"/>
		                    <ec:column property="tableforpic"  title="<%=Tcarlog.ALIAS_TABLEFORPIC%>"/>
		                    <ec:column property="fieldforpic"  title="<%=Tcarlog.ALIAS_FIELDFORPIC%>"/>
		                    <ec:column property="cpcode"  title="<%=Tcarlog.ALIAS_CPCODE%>"/>
		                    <ec:column property="keyforpic"  title="<%=Tcarlog.ALIAS_KEYFORPIC%>"/>
		                    <ec:column property="carid"  title="<%=Tcarlog.ALIAS_CARID%>"/>
		<ec:column property="操作" title="操作" sortable="false" viewsAllowed="html">
			<a href="${ctx}/pages/zazh/Tcarlog/show.do?id=${item.id}&<mytag:params includes="ec*,s*" type="queryStringUtf"/>">查看</a>&nbsp;&nbsp;&nbsp;
			<a href="${ctx}/pages/zazh/Tcarlog/edit.do?id=${item.id}&<mytag:params includes="ec*,s*" type="queryStringUtf"/>">修改</a>
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
				input_txt.value = "!/pages/zazh/Tcarlog/list.do?<mytag:params includes="ec*,s*" type="queryStringUtf"/>";
				form.appendChild(input_txt);
		        form.action = '${ctx}/pages/zazh/Tcarlog/delete.do';
	            form.submit();
	        }
	  }
</script>