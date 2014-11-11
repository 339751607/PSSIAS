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
	<title><%=Tbuylog.TABLE_ALIAS%>查询</title>
</head>

<body>
<%@ include file="/commons/messages.jsp" %>
<div class="queryPanel">
    <s:form action="/pages/gas/Tbuylog/list.do"  theme="simple" style="display: inline;" method="post">
	    <table width="100%" border="1" bordercolor="#7c8ca7" align="center"  cellPadding="0" cellSpacing="0" class="tb_all">
	               <tr>
			              <td class="tb_title" colspan="4"><%=Tbuylog.TABLE_ALIAS%>查询</td>
		           </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=Tbuylog.ALIAS_NAME%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.name}"  name="s_name"  />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=Tbuylog.ALIAS_ID_CODE%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.idCode}"  name="s_idCode"  />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=Tbuylog.ALIAS_BUYTYPE%>
		                  </td>
			              <td>
		                            <mytag:select  value="${pageRequest.filters.buytype}" name="s_buytype"  notEmpty="false"   styleClass="select"  dictName="DIC_ITEM_BUY_TYPE"/> 
		                  </td>
		                   <td class="crosscolor_td">
			                      <%=Tbuylog.ALIAS_SORT%>
		                  </td>
			              <td>
		                            <mytag:select  value="${pageRequest.filters.sort}" name="s_sort"  notEmpty="false"   styleClass="select"  dictName="DIC_ITEM_BUY_SORT"/> 
		                  </td>
		                  
                   </tr>
		           <tr class="tr_tb">
                          <td class="td_tb">
			                      <%=Tbuylog.ALIAS_LOGTIME%>
		                  </td>
			              <td colspan="3" class="td_input">
		                           <s:select name="dateSelect13" list="dateSelectMap"  onchange="dateselect(this,'s_logtimeBegin','s_logtimeEnd','yyyy-MM-dd');"  value="#request.dateSelect13" listKey="key"   listValue="value" theme="simple" label=""  emptyOption="false" ></s:select>
			                          从<input id="d31313" name="s_logtimeBegin"  value="${pageRequest.filters.logtimeBegin}"   maxlength="0" size="12" class="Wdate" type="text" onFocus="WdatePicker({dateFmt:'yyyy-MM-dd',maxDate:'#F{$dp.$D(\'d31413\')}'})"/> &nbsp;到&nbsp;
			                        <input id="d31413" name="s_logtimeEnd"   value="${pageRequest.filters.logtimeEnd}"  maxlength="0" size="12" class="Wdate" type="text" onFocus="WdatePicker({dateFmt:'yyyy-MM-dd',minDate:'#F{$dp.$D(\'d31313\')}'})"/>
		                  </td>
                   </tr>
		           <tr>
			              <td class="tb_bottom" colspan="4">
			                       <input type="submit"  value="查询" onclick="getReferenceForm(this).action='${ctx}/pages/gas/Tbuylog/query.do'"/>
<!--								<input type="reset" value="重置" />-->
			              </td>
		           </tr>
	    </table>
    </s:form>
</div>
<ec:table items='page.result' var="item" method="get"
	retrieveRowsCallback="limit" sortRowsCallback="limit" filterRowsCallback="limit"
	action="${ctx}/pages/gas/Tbuylog/query.do" autoIncludeParameters="true">
	<ec:row>
      <ec:column property="name"  title="<%=Tbuylog.ALIAS_NAME%>">
		 <a href="${ctx}/pages/gas/Tbuylog/show.do?id=${item.id}" style="color: #0000FF; text-decoration: underline;">${item.name} </a>
	 </ec:column>
	  <mytag:lookupcolumn property="sex"  title="<%=Tbuylog.ALIAS_SEX%>"	cell="net.java.dev.ec.table.view.LookUpCell" dictType="gender" />
	  <ec:column property="bdate"   cell="date" title="<%=Tbuylog.ALIAS_BDATE%>"/>
	 <ec:column property="idCode"  title="<%=Tbuylog.ALIAS_ID_CODE%>"/>
	 <ec:column property="logtime" title="<%=Tbuylog.ALIAS_LOGTIME%>"/>
	 <mytag:lookupcolumn property="buytype"  title="<%=Tbuylog.ALIAS_BUYTYPE%>"	cell="net.java.dev.ec.table.view.LookUpCell" dictType="DIC_ITEM_BUY_TYPE" />
	 <mytag:lookupcolumn property="use"  title="<%=Tbuylog.ALIAS_USE%>"	cell="net.java.dev.ec.table.view.LookUpCell" dictType="DIC_ITEM_BUY_USE" />
	 <ec:column property="quantity"  title="<%=Tbuylog.ALIAS_QUANTITY%>"/>
	 
	</ec:row>
</ec:table>			
</body>

</html>