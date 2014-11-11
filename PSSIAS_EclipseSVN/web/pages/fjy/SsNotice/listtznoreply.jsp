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
	<link href="${ctx}/widgets/extremecomponents/extremecomponents.css" type="text/css" rel="stylesheet">
	<title> 维护</title>
</head>
<body onload="quickSelectInit()" >

 
<%@ include file="/commons/messages.jsp" %>
<ec:table items='page.result' var="item" 
	retrieveRowsCallback="limit" sortRowsCallback="limit" filterRowsCallback="limit" sortable="false" 
		view="org.extremecomponents.table.view.UserCompactView" style="text-align:center"
	action="${ctx}/pages/fjy/SsNotice/listNoReplytz.do" autoIncludeParameters="true">
	
	<ec:row>
		
		<ec:column property="noticeid"  title="企业代码"/>
		<ec:column property="noticetitle"  title="企业名称"/>
       
		
	</ec:row>
</ec:table>
	<table cellpadding="0" cellspacing="0" border="1" class="tb_all">
                   <tr>
						  <td colspan="4" class="tb_bottom">
						 
						           <input type="button" value="返回" onclick="javascript:history.go(-1)"/>
	                      </td>
	               </tr>
	</table>
</body>
</html>

 <script>
	
	  function doAdd() {
	     document.forms.ec.action="${ctx}/hotel/Thotel/create.do";
	     document.forms.ec.submit();
	  }
	   function doDel() {
	      batchDelete('${ctx}/hotel/Thotel/delete.do','items',document.forms.ec);
	  }
</script>

