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
	<title><%=Tfeijiuwupin.TABLE_ALIAS%> 维护</title>
</head>

<body onload="quickSelectInit()" >
<%@ include file="/commons/messages.jsp" %>

<div class="queryPanel">
   
	    <table cellpadding="0" cellspacing="0" border="1" class="tb_all">
	               <tr>
			              <td class="tb_title" colspan="4">废旧金属统计信息详细列表</td>
		           </tr>
	    </table>

</div>



<ec:table items='page.result' var="item" method="get" 
	retrieveRowsCallback="limit" sortRowsCallback="limit" filterRowsCallback="limit"
	action="${ctx}/pages/fjy/Tfeijiuwupin/queryList.do" autoIncludeParameters="true">
	<ec:row>
				           <ec:column property="shougourq"  parse="yyyyMMddHHmmss" format="yyyy-MM-dd HH:mm" cell="date"  title="<%=Tfeijiuwupin.ALIAS_SHOUGOURQ%>"/>
		                    <ec:column property="empname"  title="<%=Tfeijiuwupin.ALIAS_SHOUGOURY%>"/>
		                    <ec:column property="csrxm"  title="<%=Tfeijiuwupin.ALIAS_CHUSHOURY%>"/>
				            <mytag:lookupcolumn property="csrxb"  title="<%=Tfeijiuwupin.ALIAS_CHUSHOURENXB%>"	cell="net.java.dev.ec.table.view.LookUpCell" dictType="T_DIC_SEX" />
		                    <ec:column property="chushourensfzh"  title="<%=Tfeijiuwupin.ALIAS_CHUSHOURENSFZH%>"/>
		                    <ec:column property="wpzl"  title="<%=Tfeijiuwupin.ALIAS_WPZL%>"/>
		<ec:column property="操作" title="操作" sortable="false" viewsAllowed="html">
			<a href="${ctx}/pages/fjy/Tfeijiuwupin/queryshow.do?wupinxh=${item.wupinxh}&fh=tj">查看</a>&nbsp;&nbsp;&nbsp;
		</ec:column>
	</ec:row>
</ec:table>
<div class="queryPanel">
   
	    <table cellpadding="0" cellspacing="0" border="1" class="tb_all">
	               <tr>
			            <td colspan="5" class="tb_bottom">
	                        <input type="button" value="返回" onclick="history.go(-1);" />
			   			 </td>
		           </tr>
	    </table>

</div>
</body>

</html>


