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
	<title><%=ThotelBsQa.TABLE_ALIAS%> 维护</title>
</head>

<body onload="quickSelectInit()" >
<%@ include file="/commons/messages.jsp" %>

<div class="queryPanel">
    <s:form action="/pages/pmdd/ThotelBsQa/list.do" name="form1"  theme="simple" style="display: inline;" method="post">
	    <table cellpadding="0" cellspacing="0" border="0" class="tb_all">
	               <tr>
			              <td class="tb_title" colspan="4"><%=ThotelBsQa.TABLE_ALIAS%></td>
		           </tr>
					<tr class="crosscolor_tr">
						<td class="crosscolor_td">
							<%=ThotelBsQa.ALIAS_WTSJ%>
						</td>
						<td>
							  <s:select name="dateSelect1" list="dateSelectMap"  onchange="dateselect(this,'s_wtsjBegin','s_wtsjEnd','yyyy-MM-dd');"  value="#request.dateSelect1" listKey="key"   listValue="value" theme="simple" label=""  emptyOption="false" ></s:select>
			                          从<input id="d3132" name="s_wtsjBegin"  value="${pageRequest.filters.wtsjBegin}"   maxlength="0" size="12" class="Wdate" type="text" onFocus="WdatePicker({dateFmt:'yyyy-MM-dd',maxDate:'#F{$dp.$D(\'d3142\')}'})"/> &nbsp;到&nbsp;
			                        <input id="d3142" name="s_wtsjEnd"   value="${pageRequest.filters.wtsjEnd}"  maxlength="0" size="12" class="Wdate" type="text" onFocus="WdatePicker({dateFmt:'yyyy-MM-dd',minDate:'#F{$dp.$D(\'d3132\')}'})"/>
		                  </td>
						</td>
						<td class="crosscolor_td">
							<%=ThotelBsQa.ALIAS_JDSJ%>
						</td>
						<td>
							 <s:select name="dateSelect2" list="dateSelectMap"  onchange="dateselect(this,'s_jdsjBegin','s_jdsjEnd','yyyy-MM-dd');"  value="#request.dateSelect2" listKey="key"   listValue="value" theme="simple" label=""  emptyOption="false" ></s:select>
			                          从<input id="d3133" name="s_jdsjBegin"  value="${pageRequest.filters.jdsjBegin}"   maxlength="0" size="12" class="Wdate" type="text" onFocus="WdatePicker({dateFmt:'yyyy-MM-dd',maxDate:'#F{$dp.$D(\'d3143\')}'})"/> &nbsp;到&nbsp;
			                        <input id="d3143" name="s_jdsjEnd"   value="${pageRequest.filters.jdsjEnd}"  maxlength="0" size="12" class="Wdate" type="text" onFocus="WdatePicker({dateFmt:'yyyy-MM-dd',minDate:'#F{$dp.$D(\'d3133\')}'})"/>
						</td>
					</tr>

					<tr class="crosscolor_tr">
						<td class="crosscolor_td">
							<%=ThotelBsQa.ALIAS_WTFL%>
						</td>
						<td>
							<mytag:select  name="s_wtfl" value="${pageRequest.filters.wtfl}"  notEmpty="false"  dictName="wtfl"/>
						</td>
						<td class="crosscolor_td">
							<%=ThotelBsQa.ALIAS_JDBZ%>
						</td>
						<td>
							<mytag:select  name="s_jdbz" value="${pageRequest.filters.jdbz}"  notEmpty="false"  dictName="jdbz"/>
						</td>
					</tr>
		           <tr>
			              <td class="tb_bottom" colspan="4">
			                       <input type="submit"  value="查询" onclick="getReferenceForm(this).action='${ctx}/pages/pmdd/ThotelBsQa/listUser.do'"/>
	                               <input type="submit"  value="提问" onclick="getReferenceForm(this).action='${ctx}/pages/pmdd/ThotelBsQa/create.do?<mytag:params includes="ec*,s*" type="queryStringUtf"/>'"/>
			             <input type="button" value="清空" onclick="resitData(document.forms.form1);"/>
			              </td>
		           </tr>
	    </table>
    </s:form>
</div>



<ec:table items='page.result' var="item" method="get"
	retrieveRowsCallback="limit" sortRowsCallback="limit" filterRowsCallback="limit"
	action="${ctx}/pages/pmdd/ThotelBsQa/list.do" autoIncludeParameters="true">
	<ec:row>	         
				<ec:column property="wtsj"  parse="yyyyMMdd" format="yyyy-MM-dd" cell="date"  title="<%=ThotelBsQa.ALIAS_WTSJ%>"/>
				<mytag:lookupcolumn property="wtfl"  title="<%=ThotelBsQa.ALIAS_WTFL%>"	cell="net.java.dev.ec.table.view.LookUpCell" dictType="wtfl" />
				<ec:column property="jdsj"  parse="yyyyMMdd" format="yyyy-MM-dd" cell="date"  title="<%=ThotelBsQa.ALIAS_JDSJ%>"/>
				<ec:column property="jdr" title="<%=ThotelBsQa.ALIAS_JDR%>" />
				<mytag:lookupcolumn property="jdbz"  title="<%=ThotelBsQa.ALIAS_JDBZ%>"	cell="net.java.dev.ec.table.view.LookUpCell" dictType="jdbz" />
		<ec:column property="操作" title="操作" sortable="false" viewsAllowed="html">
			<a href="${ctx}/pages/pmdd/ThotelBsQa/show.do?xh=${item.xh}&<mytag:params includes="ec*,s*" type="queryStringUtf"/>">查看</a>&nbsp;&nbsp;&nbsp;
		</ec:column>
	</ec:row>
</ec:table>

</body>

</html>
