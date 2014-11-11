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
	<base target="_self"/>
	<link href="${ctx}/widgets/extremecomponents/extremecomponents.css" type="text/css" rel=stylesheet>
	<script type='text/javascript' src='${ctx}/dwr/interface/menu.js'></script>
	<script type='text/javascript' src='${ctx}/dwr/engine.js'></script>
	<script type='text/javascript' src='${ctx}/dwr/util.js'></script>
	<title>重点户籍地人员购油列表</title>
</head>

<body onload=" ;quickSelectInit()" >
<%@ include file="/commons/messages.jsp" %>
<table width="100%" bordercolor="#7c8ca7" align="center"  cellPadding="0" cellSpacing="0" class="tb_all">
      <tr>
        <td  class="tb_title"> 
			重点户籍地人员购油记录
        </td>
       </tr>
</table>  
<ec:table items='page.result' var="item" method="get"
	retrieveRowsCallback="limit" sortRowsCallback="limit" filterRowsCallback="limit" 
	action="${ctx}/pages/gas/Tbuylog/tzgwlist.do" autoIncludeParameters="true">
	<ec:row>
             <ec:column property="name"  title="<%=Tbuylog.ALIAS_NAME%>">
			</ec:column>
              <mytag:lookupcolumn property="sex"  title="<%=Tbuylog.ALIAS_SEX%>"	cell="net.java.dev.ec.table.view.LookUpCell" dictType="gender" />
              <mytag:lookupcolumn property="nation"  title="<%=Tbuylog.ALIAS_NATION%>"	cell="net.java.dev.ec.table.view.LookUpCell" dictType="nation" />
              <mytag:lookupcolumn property="xzqh"  title="户籍地"	cell="net.java.dev.ec.table.view.LookUpCell" dictType="xzqh" />
              <ec:column property="idCode"  title="<%=Tbuylog.ALIAS_ID_CODE%>"/>
             <ec:column property="logtime" title="<%=Tbuylog.ALIAS_LOGTIME%>" />     
             <ec:column property="quantity"  title="<%=Tbuylog.ALIAS_QUANTITY%>"/>
             <ec:column property="操作" title="操作" sortable="false" viewsAllowed="html">
				<a href="#"  onclick="javascript:openTzGw('${item.id}','<mytag:params includes="ec*,s*" type="queryStringUtf"/>');return false;"  >查看</a>
			</ec:column>
	</ec:row>
</ec:table>

</body>

</html>
<script>
  function openTzGw(ID,URL)
  {
   var sReturn = window.showModalDialog("${ctx}/pages/gas/Tbuylog/tzxxgyshow.do?id="+ID+"&"+URL,"prompt_tzgw","dialogHeight:350px;dialogWidth:850px;scroll:on;center:yes");
   if (typeof(sReturn) != "undefined")
       {
       if (sReturn=="1")
       {
        window.location.reload();  
       }
      }
  }
</script>