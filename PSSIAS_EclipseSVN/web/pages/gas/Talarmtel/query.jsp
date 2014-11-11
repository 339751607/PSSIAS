<%@page import="com.dyneinfo.gas.model.*" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/commons/taglibs.jsp" %>
<%
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+request.getContextPath()+"/";
%>
<html>

<head>
	<%@ include file="/commons/meta.jsp" %>
	<base href="<%=basePath%>">
	<title><%=Talarmtel.TABLE_ALIAS%>查询</title>
</head>

<body>
<%@ include file="/commons/messages.jsp" %>
<div class="queryPanel">
    <s:form action="/pages/gas/Talarmtel/list.do"  theme="simple" style="display: inline;" method="post">
	    <table width="100%" border="1" bordercolor="#7c8ca7" align="center"  cellPadding="0" cellSpacing="0" class="tb_all">
	               <tr>
			              <td class="tb_title" colspan="4"><%=Talarmtel.TABLE_ALIAS%>查询</td>
		           </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=Talarmtel.ALIAS_DEPTNAME%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.deptname}"  name="s_deptname"  />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=Talarmtel.ALIAS_ALARMALL%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.alarmall}"  name="s_alarmall"  />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=Talarmtel.ALIAS_ALARMTEL%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.alarmtel}"  name="s_alarmtel"  />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=Talarmtel.ALIAS_EXITEND1%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.exitend1}"  name="s_exitend1"  />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=Talarmtel.ALIAS_EXITEND2%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.exitend2}"  name="s_exitend2"  />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=Talarmtel.ALIAS_EXITEND3%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.exitend3}"  name="s_exitend3"  />
		                  </td>
                   </tr>
		           <tr>
			              <td class="tb_bottom" colspan="4">
			                       <input type="submit"  value="查询" onclick="getReferenceForm(this).action='${ctx}/pages/gas/Talarmtel/list.do'"/>
	                               <input type="submit"  value="新增" onclick="getReferenceForm(this).action='${ctx}/pages/gas/Talarmtel/create.do?<mytag:params includes="ec*,s*" type="queryStringUtf"/>'"/>
			              </td>
		           </tr>
	    </table>
    </s:form>
</div>
			
</body>

</html>