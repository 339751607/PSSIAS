<%@page import="com.dyneinfo.jxy.model.*"%>
<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/commons/taglibs.jsp"%>
<%
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ request.getContextPath() + "/";
%>
<html>

	<head>
		<%@ include file="/commons/meta.jsp"%>
		<base href="<%=basePath%>">
		<base target="_self"> 
		<link href="${ctx}/widgets/extremecomponents/extremecomponents.css"
			type="text/css" rel=stylesheet>
		<title><%=Tcarinfo.TABLE_ALIAS%> 维护</title>
	</head>

	<body onload="quickSelectInit()" id="bd">
		<%@ include file="/commons/messages.jsp"%>

		<ec:table items='page.result' var="item" method="get"
			retrieveRowsCallback="limit" sortRowsCallback="limit"
			filterRowsCallback="limit"
			action="${ctx}/jxy/Tcarinfo/queryczxx.do"
			autoIncludeParameters="false">
			<ec:row>
				<ec:column property="carowner" title="<%=Tcarinfo.ALIAS_CAROWNER%>" />
				<mytag:lookupcolumn property="cartype"
					title="<%=Tcarinfo.ALIAS_CARTYPE%>"
					cell="net.java.dev.ec.table.view.LookUpCell" dictType="cllx" />
				<ec:column property="carid" title="<%=Tcarinfo.ALIAS_CARID%>" />
				<ec:column property="enginecode"
					title="<%=Tcarinfo.ALIAS_ENGINECODE%>" />
				<ec:column property="clsbcode" title="车辆识别代码" />
				<ec:column property="delitelephone"
					title="<%=Tcarreturn.ALIAS_DELITELEPHONE%>" />
				<ec:column property="enroltime" parse="yyyyMMddHHmm"
					format="yyyy-MM-dd HH:mm" cell="date"
					title="<%=Tcarinfo.ALIAS_ENROLTIME%>" />
				<ec:column property="操作" title="操作" sortable="false"
					viewsAllowed="html">
					<input type="checkbox" name="checkbox" value="${item.enrolid}" />
				</ec:column>
			</ec:row>
		</ec:table>

	</body>

</html>

<script type="text/javascript">
$(document).ready(function(){
	$(":checkbox").click(function(){
	 var caller = window.dialogArguments; 
	  caller.document.getElementById("hidden_enrolid").value=this.value;	
	  window.close();
	  
	 //window.location.href="${ctx}/jxy/Tcarinfo/ryedit.do?enrolid="+this.value;
	//		$.post(url, function(data) { });
 	// caller.location.reload();
			
	});
})
</script>
