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
	<title><%=Tcpinfo.TABLE_ALIAS%> 维护</title>
</head>

<body onload="quickSelectInit()" >
<%@ include file="/commons/messages.jsp" %>

<div class="queryPanel">
	    <table cellpadding="0" cellspacing="0" border="1" class="tb_all">
              <tr>
	              <td class="tb_title" colspan="4"><%=Tcpinfo.TABLE_ALIAS%>查询结果列表</td>
           </tr>
          </table>
</div>


<!--  rowsDisplayed="20" -->
<ec:table items='page.result' var="item" method="get"
	retrieveRowsCallback="limit" sortRowsCallback="limit" filterRowsCallback="limit"
	action="${ctx}/pages/fjy/Tcpinfo/queryList.do" autoIncludeParameters="true">
    <ec:exportXls fileName="TcpinfoList.xls" tooltip="输出Excel文件"/> 
    <ec:exportCsv fileName="TcpinfoList.txt" tooltip="输出CSV文件" delimiter=","/>  
	<ec:row>
		<ec:column property="cpcode"  title="<%=Tcpinfo.ALIAS_CPCODE%>"/>
		                    <ec:column property="cpname"  title="<%=Tcpinfo.ALIAS_CPNAME%>"/>
		                  
		                    <ec:column property="cptel"  title="<%=Tcpinfo.ALIAS_CPTEL%>"/>
		                  
				             <ec:column property="frname"  title="<%=Tcpinfo.ALIAS_FRNAME%>"/>
				              <mytag:lookupcolumn property="cpstate"  title="<%=Tcpinfo.ALIAS_CPSTATE%>"	cell="net.java.dev.ec.table.view.LookUpCell" dictType="T_DIC_CPSTATE" />
		                    <ec:column property="deptname"  title="<%=Tcpinfo.ALIAS_SSPCS%>"/>
		                    
		                    <ec:column property="zafzr"  title="<%=Tcpinfo.ALIAS_ZAFZR%>"/>
		                 
				            <ec:column property="kysj"  parse="yyyyMMdd" format="yyyy-MM-dd" cell="date"  title="<%=Tcpinfo.ALIAS_KYSJ%>"/>
		                   
		<ec:column property="操作" title="操作" sortable="false" viewsAllowed="html">
		
			<a href="${ctx}/pages/fjy/Tcpinfo/queryshow.do?cpcode=${item.cpcode}&<mytag:params includes="ec*,s*" type="queryStringUtf"/>">查看</a>&nbsp;&nbsp;&nbsp;
		</ec:column>
	</ec:row>
</ec:table>
<div class="queryPanel">
   
	    <table cellpadding="0" cellspacing="0" border="1" class="tb_all">
	               <tr>
			            <td colspan="5" class="tb_bottom">
	                        <input type="button" value="返回" onclick="window.location='${ctx}/pages/fjy/Tcpinfo/query.do?<mytag:params includes="ec*,s*" type="queryStringUtf"/>'" />
			   			 </td>
		           </tr>
	    </table>

</div>
<script type="text/javascript">
 function selectEmp(){
	  	 var left = "50", top = "50";
	     if(arguments[3] != null) left = "dialogLeft:" + arguments[3] + "px;"
	     if(arguments[4] != null) top = "dialogTop:" + arguments[4] + "px;"
	     window.showModalDialog('${ctx}/pages/fjy/Tcpinfo/cariscode.do?search_random='+Math.random(),
									window,
									"dialogWidth:700px;" + "dialogHeight:550px;" 
									+ left + top 
									+ "directories:yes;help:no;status:no;resizable:no;scrollbars:yes;");
		
	}
</script>
</body>

</html>

