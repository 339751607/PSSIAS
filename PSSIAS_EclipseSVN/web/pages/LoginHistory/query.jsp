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
	<title><%=LoginHistory.TABLE_ALIAS%>查询</title>
</head>

<body>
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
		                           <s:select name="dateSelect0" list="dateSelectMap"  onchange="dateselect(this,'s_logintimeBegin','s_logintimeEnd','yyyy-MM-dd');"  value="#request.dateSelect0" listKey="key"   listValue="value" theme="simple" label=""  emptyOption="false" ></s:select>
			                          从<input id="d3130" name="s_logintimeBegin"  value="${pageRequest.filters.logintimeBegin}"   maxlength="0" size="12" class="Wdate" type="text" onFocus="WdatePicker({dateFmt:'<%=LoginHistory.FORMAT_LOGINTIME%>',maxDate:'#F{$dp.$D(\'d3140\')}'})"/> &nbsp;到&nbsp;
			                        <input id="d3140" name="s_logintimeEnd"   value="${pageRequest.filters.logintimeEnd}"  maxlength="0" size="12" class="Wdate" type="text" onFocus="WdatePicker({dateFmt:'<%=LoginHistory.FORMAT_LOGINTIME%>',minDate:'#F{$dp.$D(\'d3130\')}'})"/>
		                  </td>
                          <td class="crosscolor_td">
			                      <%=LoginHistory.ALIAS_LOGINNAME%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.loginname}"  name="s_loginname"  />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=LoginHistory.ALIAS_ISVALID%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.isvalid}"  name="s_isvalid"  />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=LoginHistory.ALIAS_INVALIDPASSWORD%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.invalidpassword}"  name="s_invalidpassword"  />
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
			                      <%=LoginHistory.ALIAS_BROWSER%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.browser}"  name="s_browser"  />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=LoginHistory.ALIAS_HOSTNAME%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.hostname}"  name="s_hostname"  />
		                  </td>
                          <td>&nbsp;</td>
                          <td>&nbsp;</td>
                   </tr>
		           <tr>
			              <td class="tb_bottom" colspan="4">
			                       <input type="submit"  value="查询" onclick="getReferenceForm(this).action='${ctx}/pages/LoginHistory/list.do'"/>
	                               <input type="submit"  value="新增" onclick="getReferenceForm(this).action='${ctx}/pages/LoginHistory/create.do?<mytag:params includes="ec*,s*" type="queryStringUtf"/>'"/>
			              </td>
		           </tr>
	    </table>
    </s:form>
</div>
			
</body>

</html>