<%@page import="com.dyneinfo.jxy.model.*" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/commons/taglibs.jsp" %>
<%
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+request.getContextPath()+"/";
%>
<html>

<head>
	<%@ include file="/commons/meta.jsp" %>
	<base href="<%=basePath%>">
	<title><%=Tcppunishinfo.TABLE_ALIAS%>查询</title>
</head>

<body>
<%@ include file="/commons/messages.jsp" %>
<div class="queryPanel">
    <s:form action="/jxy/Tcppunishinfo/list.do"  theme="simple" style="display: inline;" method="post">
	    <table cellpadding="0" cellspacing="0" border="0" class="tb_all">
	               <tr>
			              <td class="tb_title" colspan="4"><%=Tcppunishinfo.TABLE_ALIAS%>查询</td>
		           </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=Tcppunishinfo.ALIAS_CPCODE%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.cpcode}"  name="s_cpcode"  />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=Tcppunishinfo.ALIAS_PDATE%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.pdate}"  name="s_pdate"  />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=Tcppunishinfo.ALIAS_PFILENO%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.pfileno}"  name="s_pfileno"  />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=Tcppunishinfo.ALIAS_AUTHUNIT%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.authunit}"  name="s_authunit"  />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=Tcppunishinfo.ALIAS_AUTHPERSON%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.authperson}"  name="s_authperson"  />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=Tcppunishinfo.ALIAS_EXECPERSON%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.execperson}"  name="s_execperson"  />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=Tcppunishinfo.ALIAS_CAUSE%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.cause}"  name="s_cause"  />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=Tcppunishinfo.ALIAS_PTYPE%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.ptype}"  name="s_ptype"  />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=Tcppunishinfo.ALIAS_RANGE%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.range}"  name="s_range"  />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=Tcppunishinfo.ALIAS_PPERSON%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.pperson}"  name="s_pperson"  />
		                  </td>
                   </tr>
		           <tr>
			              <td class="tb_bottom" colspan="4">
			                       <input type="submit"  value="查询" onclick="getReferenceForm(this).action='${ctx}/jxy/Tcppunishinfo/list.do'"/>
	                               <input type="submit"  value="新增" onclick="getReferenceForm(this).action='${ctx}/jxy/Tcppunishinfo/create.do?<mytag:params includes="ec*,s*" type="queryStringUtf"/>'"/>
			              </td>
		           </tr>
	    </table>
    </s:form>
</div>
			
</body>

</html>
