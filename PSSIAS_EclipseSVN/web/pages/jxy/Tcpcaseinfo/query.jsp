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
	<title><%=Tcpcaseinfo.TABLE_ALIAS%>查询</title>
</head>

<body>
<%@ include file="/commons/messages.jsp" %>
<div class="queryPanel">
    <s:form action="/jxy/Tcpcaseinfo/list.do"  theme="simple" style="display: inline;" method="post">
	    <table cellpadding="0" cellspacing="0" border="0" class="tb_all">
	               <tr>
			              <td class="tb_title" colspan="4"><%=Tcpcaseinfo.TABLE_ALIAS%>查询</td>
		           </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=Tcpcaseinfo.ALIAS_CPCODE%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.cpcode}"  name="s_cpcode"  />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=Tcpcaseinfo.ALIAS_CASECODE%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.casecode}"  name="s_casecode"  />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=Tcpcaseinfo.ALIAS_HAPPENTIME%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.happentime}"  name="s_happentime"  />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=Tcpcaseinfo.ALIAS_CASEFLAG%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.caseflag}"  name="s_caseflag"  />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=Tcpcaseinfo.ALIAS_CASETYPE%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.casetype}"  name="s_casetype"  />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=Tcpcaseinfo.ALIAS_CASEDESC%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.casedesc}"  name="s_casedesc"  />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=Tcpcaseinfo.ALIAS_FLAGPACK%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.flagpack}"  name="s_flagpack"  />
		                  </td>
                          <td>&nbsp;</td>
                          <td>&nbsp;</td>
                   </tr>
		           <tr>
			              <td class="tb_bottom" colspan="4">
			                       <input type="submit"  value="查询" onclick="getReferenceForm(this).action='${ctx}/jxy/Tcpcaseinfo/list.do'"/>
	                               <input type="submit"  value="新增" onclick="getReferenceForm(this).action='${ctx}/jxy/Tcpcaseinfo/create.do?<mytag:params includes="ec*,s*" type="queryStringUtf"/>'"/>
			              </td>
		           </tr>
	    </table>
    </s:form>
</div>
			
</body>

</html>
