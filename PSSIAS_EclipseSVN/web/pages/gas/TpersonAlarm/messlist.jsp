<%@page import="com.dyneinfo.gas.model.*"%>
<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/commons/taglibs.jsp"%>
<%
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+request.getContextPath()+"/";
%>
<html>

	<head>
		<%@ include file="/commons/meta.jsp"%>
		<base href="<%=basePath%>" target="_self">
		<link href="${ctx}/widgets/extremecomponents/extremecomponents.css"
			type="text/css" rel=stylesheet>
		<title>所属辖区未处警列表</title>
	</head>

	<body onload="quickSelectInit()">
	<table width="100%" bordercolor="#7c8ca7" align="center"  cellPadding="0" cellSpacing="0" class="tb_all">
      <tr>
        <td  class="tb_title"> 
			所属辖区未处警列表
        </td>
       </tr>
</table>  
		<%@ include file="/commons/messages.jsp"%>
		<ec:table items='page.result' var="item" method="get"
			retrieveRowsCallback="limit" sortRowsCallback="limit"
			filterRowsCallback="limit" action="${ctx}/pages/gas/TpersonAlarm/messlist.do"
			autoIncludeParameters="true">
			<ec:row>
				<ec:column property="name" title="<%=TpersonAlarm.ALIAS_NAME%>" />
				<mytag:lookupcolumn property="sex"
					title="<%=TpersonAlarm.ALIAS_SEX%>"
					cell="net.java.dev.ec.table.view.LookUpCell" dictType="gender" />
				<mytag:lookupcolumn property="nation"
					title="<%=TpersonAlarm.ALIAS_NATION%>"
					cell="net.java.dev.ec.table.view.LookUpCell" dictType="nation" />
				<ec:column property="bdate" parse="yyyyMMdd" format="yyyy-MM-dd"
					cell="date" title="<%=TpersonAlarm.ALIAS_BDATE%>" />

				<ec:column property="cpname" title="<%=TpersonAlarm.ALIAS_CPNAME%>" />
				<mytag:lookupcolumn property="burcode"
					title="<%=TpersonAlarm.ALIAS_BURCODE%>"
					cell="net.java.dev.ec.table.view.LookUpCell" dictType="teHangDwbm" />
				<mytag:lookupcolumn property="stacode"
					title="<%=TpersonAlarm.ALIAS_STACODE%>"
					cell="net.java.dev.ec.table.view.LookUpCell" dictType="teHangDwbm" />

				<ec:column property="操作" title="操作" sortable="false"	viewsAllowed="html">
					<a href="#"  onclick="javascript:openalarmmess('${item.id}','<mytag:params includes="ec*,s*" type="queryStringUtf"/>');return false;"  >查看</a>&nbsp;&nbsp;&nbsp;
					<a href="#"  onclick="javascript:openmess('${item.id}','<mytag:params includes="ec*,s*" type="queryStringUtf"/>');return false;"  ><font size="2" color="red" >处警</font></a>
				</ec:column>
			</ec:row>
		</ec:table>

	</body>

</html>

<script>
  function openalarmmess(ID,URL)
  {
   var sReturn = window.showModalDialog("${ctx}/pages/gas/TpersonAlarm/tzshow.do?id="+ID+"&"+URL,"prompt_mes_pop","dialogHeight:600px;dialogWidth:1050px;scroll:on;center:yes");
 	  if (typeof(sReturn) != "undefined")
       {
       if (sReturn=="1")
       {
       	window.name = "prompt_tz"; 
		window.open("${ctx}/pages/gas/TpersonAlarm/messlist.do","prompt_tz");
       }
      }
  }
  function openmess(ID,URL)
  {
   var sReturn = window.showModalDialog("${ctx}/pages/gas/TpersonAlarm/messedit.do?id="+ID+"&"+URL,"prompt_mes_pop","dialogHeight:350px;dialogWidth:1050px;scroll:on;center:yes");
 	  if (typeof(sReturn) != "undefined")
       {
       if (sReturn=="1")
       {
       	window.name = "prompt_tz"; 
		window.open("${ctx}/pages/gas/TpersonAlarm/messlist.do","prompt_tz");
       }
      }
  }
</script>