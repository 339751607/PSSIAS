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
	<title>频繁购油人员列表</title>
</head>

<body onload=" quickSelectInit()" >
<input id="d31313" name="s_logtimeBegin"  value=" ${pageRequest.filters.logtimeBegin}" type="hidden" /> 
<input id="d31413" name="s_logtimeEnd"   value="${pageRequest.filters.logtimeEnd}" type="hidden"/>
		                   
<%@ include file="/commons/messages.jsp" %>
	<table width="100%" bordercolor="#7c8ca7" align="center"  cellPadding="0" cellSpacing="0" class="tb_all">
             <tr>
	          <td  class="tb_title"> 
				频繁购油人员列表
	          </td>
          </tr>
	</table>
<ec:table items='page.result' var="item" method="get"
	retrieveRowsCallback="limit" sortRowsCallback="limit" filterRowsCallback="limit"
	action="${ctx}/pages/gas/Tbuylog/tzpflist.do" autoIncludeParameters="true">
	<ec:row>
             <ec:column property="name"  title="<%=Tbuylog.ALIAS_NAME%>">
			</ec:column>
              <mytag:lookupcolumn property="sex"  title="<%=Tbuylog.ALIAS_SEX%>"	cell="net.java.dev.ec.table.view.LookUpCell" dictType="gender" />
              <ec:column property="bdate" cell="date"  title="<%=Tbuylog.ALIAS_BDATE%>"/>
              <mytag:lookupcolumn property="nation"  title="<%=Tbuylog.ALIAS_NATION%>"	cell="net.java.dev.ec.table.view.LookUpCell" dictType="nation" />
                
              <ec:column property="idCode"  title="<%=Tbuylog.ALIAS_ID_CODE%>"/>
                
             <ec:column property="gycs"  title="<%=Tbuylog.ALIAS_GYCS%>"/>
             <ec:column property="操作" title="操作" sortable="false" viewsAllowed="html">
				<a href="#"  onclick="javascript:openTz('${item.idCode}','<mytag:params includes="ec*,s*" type="queryStringUtf"/>');return false;"  >查看</a>
			</ec:column>
	</ec:row>
</ec:table>
</body>
</html>
<script>
  function openTz(ID,URL)
  {
   var sReturn = window.showModalDialog("${ctx}/pages/gas/Tbuylog/tzrygyshow.do?idcode="+ID+"&"+URL,"prompt_xctb_pop","dialogHeight:500px;dialogWidth:850px;scroll:on;center:yes");
   if (typeof(sReturn) != "undefined")
       {
       if (sReturn=="1")
       {
        window.location.reload();  
       }
      }
  }
</script>
