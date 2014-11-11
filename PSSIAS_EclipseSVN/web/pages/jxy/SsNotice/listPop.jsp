<%@page import="com.dyneinfo.jxy.model.*" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/commons/taglibs.jsp" %>
<%
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+request.getContextPath()+"/";
%>
<html>

<head>
	<%@ include file="/commons/meta.jsp" %>
	<base target="_self"/> 
	<link href="${ctx}/widgets/extremecomponents/extremecomponents.css" type="text/css" rel=stylesheet>
	<title><%=SsNotice.TABLE_ALIAS%></title>
</head>

<body>
<%@ include file="/commons/messages.jsp" %>
<ec:table style="margin: 8px" items='page.result' var="item" method="get"
	retrieveRowsCallback="limit" sortRowsCallback="limit" filterRowsCallback="limit"
	action="${ctx}/jxy/SsNotice/listPop.do" autoIncludeParameters="true">
	<ec:row>
		                    <ec:column width="250px" property="noticetitle"  title="<%=SsNotice.ALIAS_NOTICETITLE%>"/>
		                    <ec:column property="authorname"  title="<%=SsNotice.ALIAS_AUTHORID%>"/>
		                    <ec:column property="sendunitname"  title="<%=SsNotice.ALIAS_SENDUNITID%>"/>
		                   
		<ec:column width="30px" property="操作" title="操作" sortable="false" viewsAllowed="html">
			<a href="${ctx}/jxy/SsNotice/showPop.do?noticeid=${item.noticeid}&<mytag:params includes="ec*,s*" type="queryStringUtf"/>">查看</a>	
		</ec:column>
	</ec:row>
</ec:table>
        <script language="javascript"> 
        var k=window.dialogArguments; 
		if('${page.result}'!='[]'){
			//k.document.getElementById("tzbj").innerHTML ='<a harf="#" onclick="openNotice()"><font color="#FF000" >通知通告</font></a>'; 
			k.document.getElementById("imgid").src="${ctx}/pages/jxy/outlookmenu/img/menu.gif";
		}else{
			k.document.getElementById("imgid").src="${ctx}/pages/jxy/outlookmenu/img/letter.png";
		}
		
        </script>
</body>

</html>


