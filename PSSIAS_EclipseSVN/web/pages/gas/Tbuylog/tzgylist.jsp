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
		<base target="_self"/>
		<link href="${ctx}/widgets/extremecomponents/extremecomponents.css"
			type="text/css" rel="stylesheet">
		<title>购油记录</title>
	</head>
	<table width="100%" bordercolor="#7c8ca7" align="center"  cellPadding="0" cellSpacing="0" class="tb_all">
	               <tr>
				          <td colspan="5" class="tb_title"> 
							购油记录
				          </td>
		           </tr>
	</table>
	<body onload="quickSelectInit()">
		<%@ include file="/commons/messages.jsp"%>
		
		<ec:table items='page.result' var="item" retrieveRowsCallback="limit"
			sortRowsCallback="limit" filterRowsCallback="limit" sortable="false"
			view="org.extremecomponents.table.view.UserCompactView"
			action="${ctx}/pages/gas/Tbuylog/tzrygyshow.do" autoIncludeParameters="true">
			<ec:row>
				 <ec:column property="name"  title="<%=Tbuylog.ALIAS_NAME%>">
			</ec:column>
              <mytag:lookupcolumn property="sex"  title="<%=Tbuylog.ALIAS_SEX%>"	cell="net.java.dev.ec.table.view.LookUpCell" dictType="gender" />
              <mytag:lookupcolumn property="nation"  title="<%=Tbuylog.ALIAS_NATION%>"	cell="net.java.dev.ec.table.view.LookUpCell" dictType="nation" />
                
              <ec:column property="idCode"  title="<%=Tbuylog.ALIAS_ID_CODE%>"/>
              
				<ec:column property="logtime"  title="<%=Tbuylog.ALIAS_LOGTIME%>" />

				<ec:column property="quantity" title="<%=Tbuylog.ALIAS_QUANTITY%>" />

				<ec:column width="10%" property="操作" title="操作" sortable="false"
					viewsDenied="xls">
					<a href="#"  onclick="javascript:openTzgy('${item.id}','<mytag:params includes="ec*,s*" type="queryStringUtf"/>');return false;"  >查看</a>
		</ec:column>
			</ec:row>
		</ec:table>
	</body>
</html>

<script>
  function openTzgy(ID,URL)
  {
   var sReturn = window.showModalDialog("${ctx}/pages/gas/Tbuylog/tzxxgyshow.do?id="+ID+"&"+URL,"prompt_xctb_pop","dialogHeight:360px;dialogWidth:850px;scroll:on;center:yes");
   if (typeof(sReturn) != "undefined")
       {
       if (sReturn=="1")
       {
        window.location.reload();  
       }
      }
  }
</script>

