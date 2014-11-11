<%@page import="com.dyneinfo.fjy.model.*" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/commons/taglibs.jsp" %>
<%@ taglib prefix="authz" uri="http://www.springframework.org/security/tags" %>
<%
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+request.getContextPath()+"/";
%>
<html>

<head>
	<%@ include file="/commons/meta.jsp" %>
	<base href="<%=basePath%>">
	<link href="${ctx}/widgets/extremecomponents/extremecomponents.css" type="text/css" rel=stylesheet>
	<title><%=Temployee.TABLE_ALIAS%> 维护</title>
</head>

<body onload="quickSelectInit()" >
<%@ include file="/commons/messages.jsp" %>
<div class="queryPanel">
 <table cellpadding="0" cellspacing="0" border="1" class="tb_all">
	               <tr>
			              <td class="tb_title" colspan="4">从业人员统计信息详细列表</td>
		           </tr>
 </table>
 </div>
<ec:table items='page.result' var="item" method="get"
	retrieveRowsCallback="limit" 
	sortRowsCallback="limit" filterRowsCallback="limit"
	action="${ctx}/pages/fjy/Temployee/queryList.do" autoIncludeParameters="true">
	<ec:row>
		                    <ec:column property="deptname"  title="工作单位"/>
		                    <ec:column property="empname"  title="<%=Temployee.ALIAS_EMPNAME%>"/>
				            <mytag:lookupcolumn property="sex"  title="<%=Temployee.ALIAS_SEX%>"	cell="net.java.dev.ec.table.view.LookUpCell" dictType="T_DIC_SEX" />
		                    <ec:column property="personid"  title="<%=Temployee.ALIAS_PERSONID%>"/>
				            <ec:column property="birth"  parse="yyyyMMdd" format="yyyy-MM-dd" cell="date"  title="<%=Temployee.ALIAS_BIRTH%>"/>
				            <mytag:lookupcolumn property="folk"  title="<%=Temployee.ALIAS_FOLK%>"	cell="net.java.dev.ec.table.view.LookUpCell" dictType="T_DIC_NATION" />
				            <mytag:lookupcolumn property="npcode"  title="<%=Temployee.ALIAS_NPCODE%>"	cell="net.java.dev.ec.table.view.LookUpCell" dictType="T_DIC_XZQH" />
				            <mytag:lookupcolumn property="cyrjzt"  title="<%=Temployee.ALIAS_CYRJZT%>"	cell="net.java.dev.ec.table.view.LookUpCell" dictType="cyryFlag" />
		                    
		<ec:column property="操作" title="操作" sortable="false" viewsAllowed="html">
			<a href="${ctx}/pages/fjy/Temployee/queryshow.do?empcode=${item.empcode}&<mytag:params includes="ec*,s*" type="queryStringUtf"/>"><FONT color="red">查看</FONT></a>&nbsp;&nbsp;&nbsp;
		</ec:column>
	</ec:row>
</ec:table>
<div class="queryPanel">
   
	    <table cellpadding="0" cellspacing="0" border="1" class="tb_all">
	               <tr>
			            <td colspan="5" class="tb_bottom">
	                        <input type="button" value="返回" onclick="history.go(-1)" />
			   			 </td>
		           </tr>
	    </table>

</div>
</body>

</html>
