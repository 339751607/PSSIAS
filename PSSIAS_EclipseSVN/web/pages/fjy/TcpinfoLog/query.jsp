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
	<title><%=TcpinfoLog.TABLE_ALIAS%>查询</title>
</head>

<body>
<%@ include file="/commons/messages.jsp" %>
<div class="queryPanel">
    <s:form action="/pages/fjy/TcpinfoLog/list.do"  theme="simple" style="display: inline;" method="post">
	    <table cellpadding="0" cellspacing="0" border="1" class="tb_all">
	               <tr>
			              <td class="tb_title" colspan="4"><%=TcpinfoLog.TABLE_ALIAS%>查询</td>
		           </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=TcpinfoLog.ALIAS_CPCODE%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.cpcode}"  name="s_cpcode"  />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=TcpinfoLog.ALIAS_USERID%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.userid}"  name="s_userid"  />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=TcpinfoLog.ALIAS_DEPTID%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.deptid}"  name="s_deptid"  />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=TcpinfoLog.ALIAS_TYPE%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.type}"  name="s_type"  />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=TcpinfoLog.ALIAS_DEPTNAME%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.deptname}"  name="s_deptname"  />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=TcpinfoLog.ALIAS_USERNAME%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.username}"  name="s_username"  />
		                  </td>
                   </tr>
		           <tr class="tr_tb">
                          <td class="td_tb">
			                      <%=TcpinfoLog.ALIAS_UPDATEDATE%>
		                  </td>
			              <td class="td_input">
		                           <s:select name="dateSelect6" list="dateSelectMap"  onchange="dateselect(this,'s_updatedateBegin','s_updatedateEnd','yyyy-MM-dd');"  value="#request.dateSelect6" listKey="key"   listValue="value" theme="simple" label=""  emptyOption="false" ></s:select>
			                          从<input id="d3136" name="s_updatedateBegin"  value="${pageRequest.filters.updatedateBegin}"   maxlength="0" size="12" class="Wdate" type="text" onFocus="WdatePicker({dateFmt:'<%=TcpinfoLog.FORMAT_UPDATEDATE%>',maxDate:'#F{$dp.$D(\'d3146\')}'})"/> &nbsp;到&nbsp;
			                        <input id="d3146" name="s_updatedateEnd"   value="${pageRequest.filters.updatedateEnd}"  maxlength="0" size="12" class="Wdate" type="text" onFocus="WdatePicker({dateFmt:'<%=TcpinfoLog.FORMAT_UPDATEDATE%>',minDate:'#F{$dp.$D(\'d3136\')}'})"/>
		                  </td>
                          <td>&nbsp;</td>
                          <td>&nbsp;</td>
                   </tr>
		           <tr>
			              <td class="tb_bottom" colspan="4">
			                       <input type="submit"  value="查询" onclick="getReferenceForm(this).action='${ctx}/pages/fjy/TcpinfoLog/list.do'"/>
	                               <input type="submit"  value="新增" onclick="getReferenceForm(this).action='${ctx}/pages/fjy/TcpinfoLog/create.do?<mytag:params includes="ec*,s*" type="queryStringUtf"/>'"/>
			              </td>
		           </tr>
	    </table>
    </s:form>
</div>
			
</body>

</html>