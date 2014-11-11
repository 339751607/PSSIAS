<%@page import="com.dyneinfo.gas.model.*" %>
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
	<script type='text/javascript' src='${ctx}/dwr/interface/menu.js'></script>
	<script type='text/javascript' src='${ctx}/dwr/engine.js'></script>
	<script type='text/javascript' src='${ctx}/dwr/util.js'></script>
	<title><%=Temployee.TABLE_ALIAS%> 维护</title>
</head>

<body onload="quickSelectInit()" >
<%@ include file="/commons/messages.jsp" %>

<div class="queryPanel">
    <s:form action="/pages/gas/Temployeegas/list.do"  theme="simple" style="display: inline;" method="post">
	    <table width="100%" border="1" bordercolor="#7c8ca7" align="center"  cellPadding="0" cellSpacing="0" class="tb_all">
	               <tr>
			              <td class="tb_title" colspan="4"><%=Temployee.TABLE_ALIAS%>查询</td>
		           </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=Temployee.ALIAS_EMPNAME%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.empname}"  name="s_empname"  />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=Temployee.ALIAS_SEX%>
		                  </td>
			              <td>
			              	 <mytag:select  value="${pageRequest.filters.sex}" name="s_sex"  notEmpty="false"  styleClass="select"   dictName="T_DIC_SEX"/> 
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
		           		<td class="crosscolor_td">
			                      <%=Temployee.ALIAS_PERSONID%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.personid}"  name="s_personid"  />
		                  </td>
		                  
                           <td class="crosscolor_td">
			                      <%=Temployee.ALIAS_FOLK%>
		                  </td>
			              <td>
			              	 <mytag:select  value="${pageRequest.filters.folk}" name="s_folk"  styleClass="select"   notEmpty="false"  dictName="T_DIC_NATION"/> 
		                  </td>
                   </tr>
                   
		           <tr class="tr_tb">
                          <td class="td_tb">
			                      入职日期
		                  </td>
	                           <td colspan="3" class="td_input">
	                            <s:select name="dateSelect13" list="dateSelectMap"  onchange="dateselect(this,'s_logtimeBegin','s_logtimeEnd','yyyy-MM-dd');"  value="#request.dateSelect13" listKey="key"   listValue="value" theme="simple" label=""  emptyOption="false" ></s:select>
		                          从<input id="d31313" name="s_logtimeBegin"  value="${pageRequest.filters.logtimeBegin}"   maxlength="0" size="12" class="Wdate" type="text" onFocus="WdatePicker({dateFmt:'yyyy-MM-dd',maxDate:'#F{$dp.$D(\'d31413\')}'})"/> &nbsp;到&nbsp;
		                        <input id="d31413" name="s_logtimeEnd"   value="${pageRequest.filters.logtimeEnd}"  maxlength="0" size="12" class="Wdate" type="text" onFocus="WdatePicker({dateFmt:'yyyy-MM-dd',minDate:'#F{$dp.$D(\'d31313\')}'})"/>
		                   
		                  </td>
                   </tr>
		           <tr>
			              <td class="tb_bottom" colspan="4">
			                       <input type="submit"  value="查询" onclick="getReferenceForm(this).action='${ctx}/pages/gas/Temployeegas/qylist.do'"/>
			              </td>
		           </tr>
	    </table>
    </s:form>
</div>



<ec:table items='page.result' var="item" method="get"
	retrieveRowsCallback="limit" sortRowsCallback="limit" filterRowsCallback="limit"
	action="${ctx}/pages/gas/Temployeegas/qylist.do" autoIncludeParameters="true">
	<ec:row>
             <ec:column property="empname"  title="<%=Temployee.ALIAS_EMPNAME%>">
				${item.empname} 
             </ec:column>
             <mytag:lookupcolumn property="sex"  title="<%=Temployee.ALIAS_SEX%>"	cell="net.java.dev.ec.table.view.LookUpCell" dictType="gender" />
             <ec:column property="birth" cell="date"  title="<%=Temployee.ALIAS_BIRTH%>"/>
             <ec:column property="cpcode"  title="<%=Temployee.ALIAS_CPCODE%>">
				${item.cpname} 
             </ec:column>
             
             <mytag:lookupcolumn property="cyrjzt"  title="<%=Temployee.ALIAS_CYRJZT%>"	cell="net.java.dev.ec.table.view.LookUpCell" dictType="cyryFlag" />
             
             <ec:column property="操作" title="操作" sortable="false" viewsAllowed="html">
				<a href="${ctx}/pages/gas/Temployeegas/show.do?empcode=${item.empcode}&<mytag:params includes="ec*,s*" type="queryStringUtf"/>">查看</a>&nbsp;&nbsp;&nbsp;
				<a href="${ctx}/pages/gas/Temployeegas/edit.do?empcode=${item.empcode}&<mytag:params includes="ec*,s*" type="queryStringUtf"/>">修改</a>
			</ec:column>
		                    
	</ec:row>
</ec:table>

</body>

</html>
<script>
</script>