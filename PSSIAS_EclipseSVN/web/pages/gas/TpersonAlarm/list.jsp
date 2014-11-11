<%@page import="com.dyneinfo.gas.model.*"%>
<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/commons/taglibs.jsp"%>
<%
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+request.getContextPath()+"/";
%>
<html>

	<head>
		<%@ include file="/commons/meta.jsp"%>
		<base href="<%=basePath%>">
		<link href="${ctx}/widgets/extremecomponents/extremecomponents.css"
			type="text/css" rel=stylesheet>
		<title><%=TpersonAlarm.TABLE_ALIAS%> 维护</title>
	</head>

	<body onload="quickSelectInit()">
		<%@ include file="/commons/messages.jsp"%>

		<div class="queryPanel">
			<s:form action="/pages/gas/TpersonAlarm/list.do" theme="simple"
				style="display: inline;" name="TpersonAlarmForms" method="post">
				<table width="100%" border="1" bordercolor="#7c8ca7" align="center"  cellPadding="0" cellSpacing="0" class="tb_all">
					<tr>
						<td class="tb_title" colspan="4"><%=TpersonAlarm.TABLE_ALIAS%>管理
						</td>
					</tr>
					<tr class="crosscolor_tr">
						<td class="crosscolor_td">
							<%=TpersonAlarm.ALIAS_NAME%>
						</td>
						<td>
							<input value="${pageRequest.filters.name}" name="s_name" />
						</td>
						<td class="crosscolor_td">
							<%=TpersonAlarm.ALIAS_SEX%>
						</td>
						<td>
							<mytag:select value="${pageRequest.filters.sex}" name="s_sex"
								notEmpty="false" dictName="T_DIC_SEX" styleClass="select"/>
						</td>
					</tr>
					<tr class="crosscolor_tr">
						<td class="crosscolor_td">
							<%=TpersonAlarm.ALIAS_NATION%>
						</td>
						<td>
							<mytag:select value="${pageRequest.filters.nation}"
								name="s_nation" notEmpty="false" dictName="T_DIC_NATION" styleClass="select"/>
						</td>
						<td class="crosscolor_td">
							户籍地
						</td>
						<td>
							<mytag:select value="${pageRequest.filters.xzqh}" name="s_xzqh"
								notEmpty="false" dictName="T_DIC_XZQH" styleClass="select"/>
						</td>
					</tr>

					<tr class="crosscolor_tr">
						<td class="crosscolor_td">
							信息来源
						</td>
						<td colspan="3">
							<input value="${pageRequest.filters.cpname}" name="s_cpname" />
						</td>
					</tr>
					<tr class="tr_tb">
						<td class="td_tb">
							<%=TpersonAlarm.ALIAS_ALARMTIME%>
						</td>
						<td class="td_input">
							<s:select name="dateSelect13" list="dateSelectMap"
								onchange="dateselect(this,'s_alarmtimeBegin','s_alarmtimeEnd','yyyy-MM-dd');"
								value="#request.dateSelect13" listKey="key" listValue="value"
								theme="simple" label="" emptyOption="false"></s:select>
							从
							<input id="d31313" name="s_alarmtimeBegin"
								value="${pageRequest.filters.alarmtimeBegin}" maxlength="0"
								size="12" class="Wdate" type="text"
								onFocus="WdatePicker({dateFmt:'yyyy-MM-dd',maxDate:'#F{$dp.$D(\'d31413\')}'})" />
							&nbsp;到&nbsp;
							<input id="d31413" name="s_alarmtimeEnd"
								value="${pageRequest.filters.alarmtimeEnd}" maxlength="0"
								size="12" class="Wdate" type="text"
								onFocus="WdatePicker({dateFmt:'yyyy-MM-dd',minDate:'#F{$dp.$D(\'d31313\')}'})" />
						</td>
						<td class="crosscolor_td">
							<%=TpersonAlarm.ALIAS_CLFLAG%>
						</td>
						<td>
							<mytag:select value="${pageRequest.filters.clflag}"
								name="s_clflag" notEmpty="false" dictName="cjbz" styleClass="select" />
						</td>
					</tr>

					<tr>
						<td class="tb_bottom" colspan="4">
							<input type="submit" value="查询"
								onclick="getReferenceForm(this).action='${ctx}/pages/gas/TpersonAlarm/list.do'" />
							<!--			                       <input onclick="javascript:resetData(document.TpersonAlarmForms);"	type="button" value="重置">-->
							<!--	                               <input type="submit"  value="新增" onclick="getReferenceForm(this).action='${ctx}/pages/gas/TpersonAlarm/create.do?<mytag:params includes="ec*,s*" type="queryStringUtf"/>'"/>-->
							<!--	                               <input type="button"  value="删除" onclick="doDel();"/>-->
						</td>
					</tr>
				</table>
			</s:form>
		</div>



		<ec:table items='page.result' var="item" method="get"
			retrieveRowsCallback="limit" sortRowsCallback="limit"
			filterRowsCallback="limit" action="${ctx}/pages/gas/TpersonAlarm/list.do"
			autoIncludeParameters="true">
			<ec:row>
				<ec:column property="name" title="<%=TpersonAlarm.ALIAS_NAME%>" />
				<mytag:lookupcolumn property="sex"
					title="<%=TpersonAlarm.ALIAS_SEX%>"
					cell="net.java.dev.ec.table.view.LookUpCell" dictType="gender" />
				<mytag:lookupcolumn property="nation"
					title="<%=TpersonAlarm.ALIAS_NATION%>"
					cell="net.java.dev.ec.table.view.LookUpCell" dictType="nation" />
				<ec:column property="bdate"  
					cell="date" title="<%=TpersonAlarm.ALIAS_BDATE%>" />

				<ec:column property="cpname" title="<%=TpersonAlarm.ALIAS_CPNAME%>" />
				<mytag:lookupcolumn property="burcode"
					title="<%=TpersonAlarm.ALIAS_BURCODE%>"
					cell="net.java.dev.ec.table.view.LookUpCell" dictType="teHangDwbm" />
				<mytag:lookupcolumn property="stacode"
					title="<%=TpersonAlarm.ALIAS_STACODE%>"
					cell="net.java.dev.ec.table.view.LookUpCell" dictType="teHangDwbm" />

				<ec:column property="操作" title="操作" sortable="false"  style="text-align:left"
					viewsAllowed="html">
					<a
						href="${ctx}/pages/gas/TpersonAlarm/show.do?id=${item.id}&<mytag:params includes="ec*,s*" type="queryStringUtf"/>">查看</a>&nbsp;&nbsp;&nbsp;
			<c:if test='${item.clflag == 0}'>
						<a
							href="${ctx}/pages/gas/TpersonAlarm/edit.do?id=${item.id}&<mytag:params includes="ec*,s*" type="queryStringUtf"/>"><font size="2" color="red" >处警</font></a>
					</c:if>
				</ec:column>
			</ec:row>
		</ec:table>

	</body>

</html>


<script>
	function resetData(frm){
	          frm.reset();
        }
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
				input_txt.value = "!/pages/gas/TpersonAlarm/list.do?<mytag:params includes="ec*,s*" type="queryStringUtf"/>";
				form.appendChild(input_txt);
		        form.action = '${ctx}/pages/gas/TpersonAlarm/delete.do';
	            form.submit();
	        }
	  }
</script>