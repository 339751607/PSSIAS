<%@page import="com.dyneinfo.gas.model.*"%>
<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/commons/taglibs.jsp"%>
<%@ taglib prefix="authz"
	uri="http://www.springframework.org/security/tags"%>
<%
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+request.getContextPath()+"/";
%>
<html>
	<head>
		<%@ include file="/commons/meta.jsp"%>
		<base href="<%=basePath%>">
		<link href="${ctx}/widgets/extremecomponents/extremecomponents.css"
			type="text/css" rel="stylesheet">
		<title><%=Tbuylog.TABLE_ALIAS%> 维护</title>
	</head>
	<body onload="quickSelectInit()">
		<%@ include file="/commons/messages.jsp"%>
	<table width="100%" bordercolor="#7c8ca7" align="center"  cellPadding="0" cellSpacing="0" class="tb_all">
       <tr>
        <td  class="tb_title"> 
			集中购油信息历史记录
        </td>
       </tr>
	</table> 
		<ec:table items='page.result' var="item" retrieveRowsCallback="limit"
			sortRowsCallback="limit" filterRowsCallback="limit" sortable="false"
			view="org.extremecomponents.table.view.UserCompactView"
			action="${ctx}/pages/gas/Tbuylog/jzgylist.do" autoIncludeParameters="true">
			<ec:row>
				<ec:column property="name"  title="<%=Tbuylog.ALIAS_NAME%>">
				 <a href="${ctx}/pages/gas/Tbuylog/show.do?id=${item.id}" style="color: #0000FF; text-decoration: underline;">
						${item.name} </a>
			</ec:column>

                   <mytag:lookupcolumn property="sex"  title="<%=Tbuylog.ALIAS_SEX%>"	cell="net.java.dev.ec.table.view.LookUpCell" dictType="gender" />
                  <ec:column property="bdate"  title="<%=Tbuylog.ALIAS_BDATE%>"/>
                  
                  <mytag:lookupcolumn property="nation"  title="<%=Tbuylog.ALIAS_NATION%>"	cell="net.java.dev.ec.table.view.LookUpCell" dictType="nation" />
                  
                  <ec:column property="logtime"  title="<%=Tbuylog.ALIAS_LOGTIME%>"/>
                  
                  <mytag:lookupcolumn property="buytype"  title="<%=Tbuylog.ALIAS_BUYTYPE%>"	cell="net.java.dev.ec.table.view.LookUpCell" dictType="DIC_ITEM_BUY_TYPE" />
                   
                  <ec:column property="quantity"  title="<%=Tbuylog.ALIAS_QUANTITY%>"/>
                  <ec:column property="cpname"  title="<%=Tbuylog.ALIAS_CPCODE%>">
						${item.cpname}  
				  </ec:column>
			</ec:row>
		</ec:table>
		 <table width="100%" bordercolor="#7c8ca7" align="center"  cellPadding="0" cellSpacing="0" class="tb_all">
       <tr>
						  <td colspan="5" class="tb_bottom">
						           <input type="button" value="返回" onclick="javascript:window.history.go(-1);"/>
	                      </td>
	               </tr>
</table> </body>
</html>



