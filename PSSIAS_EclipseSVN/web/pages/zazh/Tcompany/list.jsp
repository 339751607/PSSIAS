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
	<title><%=Tcompany.TABLE_ALIAS%> 维护</title>
	
</head>

<body onload="fireOnChange();quickSelectInit(); loadSelect(); " >
<%@ include file="/commons/messages.jsp" %>
<div class="queryPanel">
    <s:form name="queryForm" action="/pages/zazh/Tcompany/list.do"  theme="simple" style="display: inline;" method="post">
	    <table width="100%" border="1" bordercolor="#7c8ca7" align="center"  cellPadding="0" cellSpacing="0" class="tb_all">
	               <tr>
			              <td class="tb_title" colspan="4"><%=Tcompany.TABLE_ALIAS%>查询</td>
		           </tr>
		           <tr class="crosscolor_tr">
                           <td class="crosscolor_td">
			                  <%=Tcompany.ALIAS_BUSINESSCODE%>
		                  </td>
			              <td>
		                      <mytag:select  name="s_businesscode"  value="${pageRequest.filters.businesscode}"  notEmpty="false"  dictName="DIC_ITEM_VALID_BUSINESSCODE"/>
		                  </td>
                          <td class="crosscolor_td">
			                      <%=Tcompany.ALIAS_CPNAME%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.cpname}"  name="s_cpname"  />
		                  </td>
                   </tr>
                   <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=Tcompany.ALIAS_STATUS%>
		                  </td>
		                  <td>
		                      <mytag:select  name="s_status"  value="${pageRequest.filters.status}"  notEmpty="false"  dictName="T_DICT_QYZT"/>
		                  </td>
                          <td class="crosscolor_td">
			                      <%=Tcompany.ALIAS_MODDATE%>
		                  </td>
			              <td>	
			                 <table class="list">
			                 	<tr>
			                 	  <td>
			                 	    <input id="d31312" name="s_moddate_start"  value="${pageRequest.filters.moddate_start}"   maxlength="0" size="15" class="Wdate" type="text" onFocus="WdatePicker({dateFmt:'yyyy-MM-dd',maxDate:'#F{$dp.$D(\'d31412\')}'})"/>	
			                 	  </td>
			                 	  <td> 到</td>
			                 	  <td>
			                 	    <input id="d31412" name="s_moddate_end"   value="${pageRequest.filters.moddate_end}"  maxlength="0" size="15" class="Wdate" type="text" onFocus="WdatePicker({dateFmt:'yyyy-MM-dd',minDate:'#F{$dp.$D(\'d31312\')}'})"/>		
			                 	  </td>
			                 	</tr>	    	
			                 </table>     
		                  </td>
                   </tr>
		          <%@ include file="/pages/SsDept/deptQuery.jsp" %>

		           <tr>
			              <td class="tb_bottom" colspan="4">
			                       <input type="submit"  value="查询" onclick="getReferenceForm(this).action='${ctx}/pages/zazh/Tcompany/list.do'"/>
	                               <input style="margin-left: 20px" type="button" value="重置" onclick="resitData(document.forms.queryForm)"/>
			              </td>
		           </tr>
	    </table>
    </s:form>
</div>


<ec:table items='page.result' var="item" method="get"
	retrieveRowsCallback="limit" sortRowsCallback="limit" filterRowsCallback="limit"
	action="${ctx}/pages/zazh/Tcompany/list.do" autoIncludeParameters="true">
	<ec:row>
            
            <mytag:lookupcolumn property="businesscode"  title="<%=Tcompany.ALIAS_BUSINESSCODE%>"	cell="net.java.dev.ec.table.view.LookUpCell" dictType="DIC_ITEM_VALID_BUSINESSCODE" />		
            <ec:column property="cpname"  title="<%=Tcompany.ALIAS_CPNAME%>"/>
            <ec:column property="phone"  title="<%=Tcompany.ALIAS_PHONE%>"/>
            <ec:column property="cpaddress"  title="<%=Tcompany.ALIAS_CPADDRESS%>"/> 
            <mytag:lookupcolumn property="status"  title="<%=Tcompany.ALIAS_STATUS%>"	cell="net.java.dev.ec.table.view.LookUpCell" dictType="T_DICT_QYZT" />		
            <ec:column property="moddate"  parse="yyyyMMdd" format="yyyy-MM-dd" cell="date" value="${item.moddate}" title="<%=Tcompany.ALIAS_MODDATE%>"/>
		    <ec:column property="burname"  title="<%=Tcompany.ALIAS_BURCODE%>"/>
            <ec:column property="staname"  title="<%=Tcompany.ALIAS_STACODE%>"/>
		                    
		<ec:column property="操作" title="操作" sortable="false" viewsAllowed="html">
			<a href="${ctx}/pages/zazh/Tcompany/show.do?cpcode=${item.cpcode}&<mytag:params includes="ec*,s*" type="queryStringUtf"/>">查看</a>
		
		</ec:column>
	</ec:row>
</ec:table>

</body>

</html>


