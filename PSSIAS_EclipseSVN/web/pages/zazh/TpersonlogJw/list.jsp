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
	<title><%=TpersonlogJw.TABLE_ALIAS%> 维护</title>
</head>

<body onload="quickSelectInit()" >
<%@ include file="/commons/messages.jsp" %>

<div class="queryPanel">
    <s:form action="/pages/zazh/TpersonlogJw/list.do"  theme="simple" style="display: inline;" method="post">
	    <table width="100%" border="1" bordercolor="#7c8ca7" align="center"  cellPadding="0" cellSpacing="0" class="tb_all">
	               <tr>
			              <td class="tb_title" colspan="4"><%=TpersonlogJw.TABLE_ALIAS%>查询</td>
		           </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=TpersonlogJw.ALIAS_PERSONID%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.personid}"  name="s_personid"  />
		                  </td>
                          <td class="crosscolor_td">
			                   
		                  </td>
			              <td>
		                    
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=TpersonlogJw.ALIAS_PASS_T%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.passT}"  name="s_passT"  />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=TpersonlogJw.ALIAS_PASS_NO%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.passNo}"  name="s_passNo"  />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=TpersonlogJw.ALIAS_SOURCE%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.source}"  name="s_source"  />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=TpersonlogJw.ALIAS_SID%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.sid}"  name="s_sid"  />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=TpersonlogJw.ALIAS_PERSONTYPE%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.persontype}"  name="s_persontype"  />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=TpersonlogJw.ALIAS_EMPSTATUS%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.empstatus}"  name="s_empstatus"  />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=TpersonlogJw.ALIAS_STARTTIME%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.starttime}"  name="s_starttime"  />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=TpersonlogJw.ALIAS_ENDTIME%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.endtime}"  name="s_endtime"  />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=TpersonlogJw.ALIAS_INSERTTIME%>
		                  </td>
			              <td>
		                           <s:select name="dateSelect10" list="dateSelectMap"  onchange="dateselect(this,'s_inserttimeBegin','s_inserttimeEnd','yyyy-MM-dd');"  value="#request.dateSelect10" listKey="key"   listValue="value" theme="simple" label=""  emptyOption="false" ></s:select>
			                          从<input id="d31310" name="s_inserttimeBegin"  value="${pageRequest.filters.inserttimeBegin}"   maxlength="0" size="12" class="Wdate" type="text" onFocus="WdatePicker({dateFmt:'<%=TpersonlogJw.FORMAT_INSERTTIME%>',maxDate:'#F{$dp.$D(\'d31410\')}'})"/> &nbsp;到&nbsp;
			                        <input id="d31410" name="s_inserttimeEnd"   value="${pageRequest.filters.inserttimeEnd}"  maxlength="0" size="12" class="Wdate" type="text" onFocus="WdatePicker({dateFmt:'<%=TpersonlogJw.FORMAT_INSERTTIME%>',minDate:'#F{$dp.$D(\'d31310\')}'})"/>
		                  </td>
                          <td class="crosscolor_td">
			                      <%=TpersonlogJw.ALIAS_UPDATETIME%>
		                  </td>
			              <td>
		                           <s:select name="dateSelect11" list="dateSelectMap"  onchange="dateselect(this,'s_updatetimeBegin','s_updatetimeEnd','yyyy-MM-dd');"  value="#request.dateSelect11" listKey="key"   listValue="value" theme="simple" label=""  emptyOption="false" ></s:select>
			                          从<input id="d31311" name="s_updatetimeBegin"  value="${pageRequest.filters.updatetimeBegin}"   maxlength="0" size="12" class="Wdate" type="text" onFocus="WdatePicker({dateFmt:'<%=TpersonlogJw.FORMAT_UPDATETIME%>',maxDate:'#F{$dp.$D(\'d31411\')}'})"/> &nbsp;到&nbsp;
			                        <input id="d31411" name="s_updatetimeEnd"   value="${pageRequest.filters.updatetimeEnd}"  maxlength="0" size="12" class="Wdate" type="text" onFocus="WdatePicker({dateFmt:'<%=TpersonlogJw.FORMAT_UPDATETIME%>',minDate:'#F{$dp.$D(\'d31311\')}'})"/>
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=TpersonlogJw.ALIAS_TABLEFORPIC%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.tableforpic}"  name="s_tableforpic"  />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=TpersonlogJw.ALIAS_FIELDFORPIC%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.fieldforpic}"  name="s_fieldforpic"  />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=TpersonlogJw.ALIAS_CPCODE%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.cpcode}"  name="s_cpcode"  />
		                  </td>
                          <td>&nbsp;</td>
                          <td>&nbsp;</td>
                   </tr>
		           <tr>
			              <td class="tb_bottom" colspan="4">
			                       <input type="submit"  value="查询" onclick="getReferenceForm(this).action='${ctx}/pages/zazh/TpersonlogJw/list.do'"/>
	                               <input type="submit"  value="新增" onclick="getReferenceForm(this).action='${ctx}/pages/zazh/TpersonlogJw/create.do?<mytag:params includes="ec*,s*" type="queryStringUtf"/>'"/>
	                               <input type="button"  value="删除" onclick="doDel();"/>
			              </td>
		           </tr>
	    </table>
    </s:form>
</div>



<ec:table items='page.result' var="item" method="get"
	retrieveRowsCallback="limit" sortRowsCallback="limit" filterRowsCallback="limit"
	action="${ctx}/pages/zazh/TpersonlogJw/list.do" autoIncludeParameters="true">
	<ec:row>
		<ec:column property="选择" title="<input type='checkbox' onclick=\"setAllCheckboxState('items',this.checked)\" >" sortable="false" width="3%" viewsAllowed="html">
			<input type="checkbox" name="items" value="id=${item.id}&"/>
		</ec:column>
		                    <ec:column property="personid"  title="<%=TpersonlogJw.ALIAS_PERSONID%>"/>
		                    <ec:column property="surname"  title="<%=TpersonlogJw.ALIAS_SURNAME%>"/>
		                    <ec:column property="passT"  title="<%=TpersonlogJw.ALIAS_PASS_T%>"/>
		                    <ec:column property="passNo"  title="<%=TpersonlogJw.ALIAS_PASS_NO%>"/>
		                    <ec:column property="source"  title="<%=TpersonlogJw.ALIAS_SOURCE%>"/>
		                    <ec:column property="sid"  title="<%=TpersonlogJw.ALIAS_SID%>"/>
		                    <ec:column property="persontype"  title="<%=TpersonlogJw.ALIAS_PERSONTYPE%>"/>
		                    <ec:column property="empstatus"  title="<%=TpersonlogJw.ALIAS_EMPSTATUS%>"/>
		                    <ec:column property="starttime"  title="<%=TpersonlogJw.ALIAS_STARTTIME%>"/>
		                    <ec:column property="endtime"  title="<%=TpersonlogJw.ALIAS_ENDTIME%>"/>
		                    <ec:column property="inserttime" value="${item.inserttimeString}" title="<%=TpersonlogJw.ALIAS_INSERTTIME%>"/>
		                    <ec:column property="updatetime" value="${item.updatetimeString}" title="<%=TpersonlogJw.ALIAS_UPDATETIME%>"/>
		                    <ec:column property="tableforpic"  title="<%=TpersonlogJw.ALIAS_TABLEFORPIC%>"/>
		                    <ec:column property="fieldforpic"  title="<%=TpersonlogJw.ALIAS_FIELDFORPIC%>"/>
		                    <ec:column property="cpcode"  title="<%=TpersonlogJw.ALIAS_CPCODE%>"/>
		<ec:column property="操作" title="操作" sortable="false" viewsAllowed="html">
			<a href="${ctx}/pages/zazh/TpersonlogJw/show.do?id=${item.id}&<mytag:params includes="ec*,s*" type="queryStringUtf"/>">查看</a>&nbsp;&nbsp;&nbsp;
			<a href="${ctx}/pages/zazh/TpersonlogJw/edit.do?id=${item.id}&<mytag:params includes="ec*,s*" type="queryStringUtf"/>">修改</a>
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
				input_txt.value = "!/pages/zazh/TpersonlogJw/list.do?<mytag:params includes="ec*,s*" type="queryStringUtf"/>";
				form.appendChild(input_txt);
		        form.action = '${ctx}/pages/zazh/TpersonlogJw/delete.do';
	            form.submit();
	        }
	  }
</script>