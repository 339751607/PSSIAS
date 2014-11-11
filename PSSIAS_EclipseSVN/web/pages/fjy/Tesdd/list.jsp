<%@page import="com.dyneinfo.fjy.model.*" %>
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
	<title><%=Tesdd.TABLE_ALIAS%> 维护</title>
</head>

<body onload="quickSelectInit()" >
<%@ include file="/commons/messages.jsp" %>

<div class="queryPanel">
    <s:form action="/pages/fjy/Tesdd/list.do"  theme="simple" style="display: inline;" method="post">
	    <table cellpadding="0" cellspacing="0" border="1" class="tb_all">
	               <tr>
			              <td class="tb_title" colspan="4"><%=Tesdd.TABLE_ALIAS%>查询</td>
		           </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=Tesdd.ALIAS_DDLX%>
		                  </td>
			              <td>
				                   <mytag:select  name="s_ddlx" value="${pageRequest.filters.ddlx}"  notEmpty="false"  dictName="T_DIC_JQLX"/>
		                  </td>
                          <td class="crosscolor_td">
			                      <%=Tesdd.ALIAS_DNPP%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.dnpp}"  name="s_dnpp"  />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=Tesdd.ALIAS_DNXH%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.dnxh}"  name="s_dnxh"  />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=Tesdd.ALIAS_ZBH%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.zbh}"  name="s_zbh"  />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=Tesdd.ALIAS_YPH%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.yph}"  name="s_yph"  />
		                  </td>
                         
                          <td class="crosscolor_td">
			                      <%=Tesdd.ALIAS_CHUSHOURY%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.chushoury}"  name="s_chushoury"  />
		                  </td>
                   </tr>
		         
		           <tr class="tr_tb">
                          <td class="td_tb">
			                      <%=Tesdd.ALIAS_MACDZ%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.macdz}"  name="s_macdz"  />
		                  </td>
                          <td class="td_tb">
			                      <%=Tesdd.ALIAS_SGSJ%>
		                  </td>
			              <td class="td_input">
				                   <s:select name="dateSelect13" list="dateSelectMap"  onchange="dateselect('list_dateSelect13','d31313','d31413','yyyy-MM-dd HH:mm:ss');"  value="#request.dateSelect13" listKey="key"   listValue="value" theme="simple" label=""  emptyOption="false" ></s:select>
			                          从<input id="d31313" name="s_sgsjBegin"  value="${pageRequest.filters.sgsjBegin}"   maxlength="0" size="12" class="Wdate" type="text" onFocus="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss',maxDate:'#F{$dp.$D(\'d31413\')}'})"/> &nbsp;到&nbsp;
			                        <input id="d31413" name="s_sgsjEnd"   value="${pageRequest.filters.sgsjEnd}"  maxlength="0" size="12" class="Wdate" type="text" onFocus="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss',minDate:'#F{$dp.$D(\'d31313\')}'})"/>
		                  </td>
                   </tr>
		          
		           <tr>
			              <td class="tb_bottom" colspan="4">
			                       <input type="submit"  value="查询" onclick="getReferenceForm(this).action='${ctx}/pages/fjy/Tesdd/list.do'"/>
	                               <input type="submit"  value="新增" onclick="getReferenceForm(this).action='${ctx}/pages/fjy/Tesdd/create.do?<mytag:params includes="ec*,s*" type="queryStringUtf"/>'"/>
	                               
			              </td>
		           </tr>
	    </table>
    </s:form>
</div>



<ec:table items='page.result' var="item" method="get"
	retrieveRowsCallback="limit" sortRowsCallback="limit" filterRowsCallback="limit"
	action="${ctx}/pages/fjy/Tesdd/list.do" autoIncludeParameters="true">
	<ec:row>
		<ec:column property="选择" title="<input type='checkbox' onclick=\"setAllCheckboxState('items',this.checked)\" >" sortable="false" width="3%" viewsAllowed="html">
			<input type="checkbox" name="items" value="dnid=${item.dnid}&"/>
		</ec:column>
				            <mytag:lookupcolumn property="ddlx"  title="<%=Tesdd.ALIAS_DDLX%>"	cell="net.java.dev.ec.table.view.LookUpCell" dictType="T_DIC_JQLX" />
		                    <ec:column property="dnpp"  title="<%=Tesdd.ALIAS_DNPP%>"/>
		                    <ec:column property="dnxh"  title="<%=Tesdd.ALIAS_DNXH%>"/>
		                    <ec:column property="zbh"  title="<%=Tesdd.ALIAS_ZBH%>"/>
		                    <ec:column property="yph"  title="<%=Tesdd.ALIAS_YPH%>"/>
		                 
		                    <ec:column property="chushoury"  title="<%=Tesdd.ALIAS_CHUSHOURY%>"/>
				           
		           
		<ec:column property="操作" title="操作" sortable="false" viewsAllowed="html">
			<a href="${ctx}/pages/fjy/Tesdd/show.do?dnid=${item.dnid}&<mytag:params includes="ec*,s*" type="queryStringUtf"/>">查看</a>&nbsp;&nbsp;&nbsp;
			<a href="${ctx}/pages/fjy/Tesdd/edit.do?dnid=${item.dnid}&<mytag:params includes="ec*,s*" type="queryStringUtf"/>">修改</a>&nbsp;&nbsp;&nbsp;
			<a href="${ctx}/pages/fjy/Tesdd/tab.do?dnid=${item.dnid}&<mytag:params includes="ec*,s*" type="queryStringUtf"/>">销售信息</a>
		</ec:column>
	</ec:row>
</ec:table>

</body>

</html>


