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
	<title><%=Tcpnsjl.TABLE_ALIAS%>查询</title>
</head>

<body>
<%@ include file="/commons/messages.jsp" %>
<div class="queryPanel">
    <s:form action="/pages/jxy/Tcpnsjl/list.do"  theme="simple" style="display: inline;" method="post">
	    <table cellpadding="0" cellspacing="0" border="0" class="tb_all">
	               <tr>
			              <td class="tb_title" colspan="4"><%=Tcpnsjl.TABLE_ALIAS%>查询</td>
		           </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=Tcpnsjl.ALIAS_CPCODE%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.cpcode}"  name="s_cpcode"  />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=Tcpnsjl.ALIAS_SHND%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.shnd}"  name="s_shnd"  />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=Tcpnsjl.ALIAS_SHRJ%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.shrj}"  name="s_shrj"  />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=Tcpnsjl.ALIAS_NSYJ%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.nsyj}"  name="s_nsyj"  />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=Tcpnsjl.ALIAS_QSR%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.qsr}"  name="s_qsr"  />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=Tcpnsjl.ALIAS_JBR%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.jbr}"  name="s_jbr"  />
		                  </td>
                   </tr>
		           <tr>
			              <td class="tb_bottom" colspan="4">
			                       <input type="submit"  value="查询" onclick="getReferenceForm(this).action='${ctx}/pages/jxy/Tcpnsjl/list.do'"/>
	                               <input type="submit"  value="新增" onclick="getReferenceForm(this).action='${ctx}/pages/jxy/Tcpnsjl/create.do?<mytag:params includes="ec*,s*" type="queryStringUtf"/>'"/>
			              </td>
		           </tr>
	    </table>
    </s:form>
</div>
			
</body>

</html>
