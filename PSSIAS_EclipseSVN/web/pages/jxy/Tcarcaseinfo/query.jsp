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
	<title><%=Tcarcaseinfo.TABLE_ALIAS%>查询</title>
</head>

<body>
<%@ include file="/commons/messages.jsp" %>
<div class="queryPanel">
    <s:form action="/jxy/Tcarcaseinfo/list.do"  theme="simple" style="display: inline;" method="post">
	    <table cellpadding="0" cellspacing="0" border="0" class="tb_all">
	               <tr>
			              <td class="tb_title" colspan="4"><%=Tcarcaseinfo.TABLE_ALIAS%>查询</td>
		           </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=Tcarcaseinfo.ALIAS_ENROLID%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.enrolid}"  name="s_enrolid"  />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=Tcarcaseinfo.ALIAS_CREDID%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.credid}"  name="s_credid"  />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=Tcarcaseinfo.ALIAS_CREDUNIT%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.credunit}"  name="s_credunit"  />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=Tcarcaseinfo.ALIAS_PARTI%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.parti}"  name="s_parti"  />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=Tcarcaseinfo.ALIAS_PARTII%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.partii}"  name="s_partii"  />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=Tcarcaseinfo.ALIAS_PARTIII%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.partiii}"  name="s_partiii"  />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=Tcarcaseinfo.ALIAS_REPORTER%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.reporter}"  name="s_reporter"  />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=Tcarcaseinfo.ALIAS_REPTIME%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.reptime}"  name="s_reptime"  />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=Tcarcaseinfo.ALIAS_DEMO%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.demo}"  name="s_demo"  />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=Tcarcaseinfo.ALIAS_FLAG%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.flag}"  name="s_flag"  />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=Tcarcaseinfo.ALIAS_ENROLTIME%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.enroltime}"  name="s_enroltime"  />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=Tcarcaseinfo.ALIAS_OPERATOR%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.operator}"  name="s_operator"  />
		                  </td>
                   </tr>
		           <tr>
			              <td class="tb_bottom" colspan="4">
			                       <input type="submit"  value="查询" onclick="getReferenceForm(this).action='${ctx}/jxy/Tcarcaseinfo/list.do'"/>
	                               <input type="submit"  value="新增" onclick="getReferenceForm(this).action='${ctx}/jxy/Tcarcaseinfo/create.do?<mytag:params includes="ec*,s*" type="queryStringUtf"/>'"/>
			              </td>
		           </tr>
	    </table>
    </s:form>
</div>
			
</body>

</html>
