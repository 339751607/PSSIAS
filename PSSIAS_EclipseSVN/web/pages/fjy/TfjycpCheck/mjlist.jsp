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
	<title><%=TfjycpCheck.TABLE_ALIAS%> 维护</title>
</head>

<body onload="quickSelectInit()" >
<%@ include file="/commons/messages.jsp" %>

<div class="queryPanel">
	    <table cellpadding="0" cellspacing="0" border="1" class="tb_all">
	               <tr>
			              <td class="tb_title" colspan="4"><%=TfjycpCheck.TABLE_ALIAS%>查询结果列表</td>
		           </tr>
	    </table>

</div>


<!-- rowsDisplayed="20" -->
<ec:table items='page.result' var="item" method="get"
	retrieveRowsCallback="limit" 
	sortRowsCallback="limit" filterRowsCallback="limit"
	action="${ctx}/pages/fjy/TfjycpCheck/list.do" autoIncludeParameters="true">
		<ec:exportXls fileName="TfjycpCheck.xls" tooltip="输出Excel文件"/> 
    <ec:exportCsv fileName="TfjycpCheck.txt" tooltip="输出CSV文件" delimiter=","/> 
	<ec:row>				
							 <ec:column property="deptname"  title="检查企业名称"/>
		                    <ec:column property="cpcode"  title="<%=TfjycpCheck.ALIAS_CPCODE%>"/>
		                     
		                    <ec:column property="empname"  title="被检查人姓名"/>
		                     <ec:column property="fullname"  title="民警姓名"/>
		                     <ec:column property="policeno"  title="警号"/>
		                      <ec:column property="checkdate"  parse="yyyyMMdd" format="yyyy-MM-dd" cell="date"  title="<%=TfjycpCheck.ALIAS_CHECKDATE%>"/>
		<ec:column property="操作" title="操作" sortable="false" viewsAllowed="html">
			<a href="${ctx}/pages/fjy/TfjycpCheck/show.do?id=${item.id}&t_checktype=1&<mytag:params includes="ec*,s*" type="queryStringUtf"/>">查看</a>&nbsp;&nbsp;&nbsp;
		</ec:column>
	</ec:row>
</ec:table>
<div class="queryPanel">
	    <table cellpadding="0" cellspacing="0" border="1" class="tb_all">
		            <tr>
			            <td colspan="5" class="tb_bottom">
	                         <input type="submit"  value="返回" onclick="window.location='${ctx}/pages/fjy/TfjycpCheck/query.do'"/>
			   			 </td>
		           </tr>
	    </table>

</div>
</body>

</html>


<script>

</script>