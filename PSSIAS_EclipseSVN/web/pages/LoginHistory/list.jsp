<%@page import="com.dyneinfo.zazh.model.*" %>
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
	<title><%=LoginHistory.TABLE_ALIAS%> 维护</title>
</head>

<body onload="quickSelectInit()" >
<%@ include file="/commons/messages.jsp" %>

<div class="queryPanel">
    <s:form action="/pages/LoginHistory/list.do"  theme="simple" style="display: inline;" method="post">
	    <table width="100%" border="1" bordercolor="#7c8ca7" align="center"  cellPadding="0" cellSpacing="0" class="tb_all">
	               <tr>
			              <td class="tb_title" colspan="4"><%=LoginHistory.TABLE_ALIAS%>查询</td>
		           </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=LoginHistory.ALIAS_LOGINTIME%>
		                  </td>
			              <td>
		                           <s:select name="dateSelect0" list="dateSelectMap"  onchange="dateselect(this,'s_logintimeBegin','s_logintimeEnd','yyyy-MM-dd HH:mm:ss');"  value="#request.dateSelect0" listKey="key"   listValue="value" theme="simple" label=""  emptyOption="false" ></s:select>
			                          从<input id="d3130" name="s_logintimeBegin"  value="${pageRequest.filters.logintimeBegin}"   maxlength="0" size="20" class="Wdate" type="text" onFocus="WdatePicker({dateFmt:'<%=LoginHistory.FORMAT_LOGINTIME%>',maxDate:'#F{$dp.$D(\'d3140\')}'})"/> &nbsp;到&nbsp;
			                        <input id="d3140" name="s_logintimeEnd"   value="${pageRequest.filters.logintimeEnd}"  maxlength="0" size="20" class="Wdate" type="text" onFocus="WdatePicker({dateFmt:'<%=LoginHistory.FORMAT_LOGINTIME%>',minDate:'#F{$dp.$D(\'d3130\')}'})"/>
		                  </td>
                        
                   </tr>
		           <tr class="crosscolor_tr">
		             <td class="crosscolor_td">
			                      <%=LoginHistory.ALIAS_LOGINNAME%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.loginname}"  name="s_loginname"  />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=LoginHistory.ALIAS_ISVALID%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.isvalid}"  name="s_isvalid"  />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=LoginHistory.ALIAS_IPADDRESS%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.ipaddress}"  name="s_ipaddress"  />
		                  </td>
                             <td class="crosscolor_td">
			                      <%=LoginHistory.ALIAS_HOSTNAME%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.hostname}"  name="s_hostname"  />
		                  </td>
                   </tr>
		           <tr>
			              <td class="tb_bottom" colspan="4">
			                       <input type="submit"  value="查询" onclick="getReferenceForm(this).action='${ctx}/pages/LoginHistory/list.do'"/>
			              </td>
		           </tr>
	    </table>
    </s:form>
</div>



<ec:table items='page.result' var="item" method="get"
	retrieveRowsCallback="limit" sortRowsCallback="limit" filterRowsCallback="limit"
	action="${ctx}/pages/LoginHistory/list.do" autoIncludeParameters="true">
	<ec:row>
		<ec:column property="选择" title="<input type='checkbox' onclick=\"setAllCheckboxState('items',this.checked)\" >" sortable="false" width="3%" viewsAllowed="html">
			<input type="checkbox" name="items" value="loginid=${item.loginid}&"/>
		</ec:column>
		                    <ec:column property="logintime" value="${item.logintimeString}" title="<%=LoginHistory.ALIAS_LOGINTIME%>"/>
		                    <ec:column property="loginname"  title="<%=LoginHistory.ALIAS_LOGINNAME%>"/>
		                    <ec:column property="isvalid"  title="<%=LoginHistory.ALIAS_ISVALID%>"/>
		                    <ec:column property="invalidpassword"  title="<%=LoginHistory.ALIAS_INVALIDPASSWORD%>"/>
		                    <ec:column property="ipaddress"  title="<%=LoginHistory.ALIAS_IPADDRESS%>"/>
		                    <ec:column property="hostname"  title="<%=LoginHistory.ALIAS_HOSTNAME%>"/>
		<ec:column property="操作" title="操作" sortable="false" viewsAllowed="html">
			<a href="${ctx}/pages/LoginHistory/show.do?loginid=${item.loginid}&<mytag:params includes="ec*,s*" type="queryStringUtf"/>">查看</a>&nbsp;&nbsp;&nbsp;
		</ec:column>
	</ec:row>
</ec:table>

</body>

</html>
