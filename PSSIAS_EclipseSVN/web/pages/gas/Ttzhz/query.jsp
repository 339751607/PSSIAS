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
	<title><%=Ttzhz.TABLE_ALIAS%>查询</title>
</head>

<body>
<%@ include file="/commons/messages.jsp" %>
<div class="queryPanel">
    <s:form action="/pages/gas/Ttzhz/list.do"  theme="simple" style="display: inline;" method="post">
	    <table width="100%" border="1" bordercolor="#7c8ca7" align="center" 	cellPadding="0" cellSpacing="0" class="tb_all">
	               <tr>
			              <td class="tb_title" colspan="4"><%=Ttzhz.TABLE_ALIAS%>查询</td>
		           </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=Ttzhz.ALIAS_HZSJ%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.hzsj}"  name="s_hzsj"  />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=Ttzhz.ALIAS_CPCODE%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.cpcode}"  name="s_cpcode"  />
		                  </td>
                   </tr>
		           <tr>
			              <td class="tb_bottom" colspan="4">
			                       <input type="submit"  value="查询" onclick="getReferenceForm(this).action='${ctx}/pages/gas/Ttzhz/list.do'"/>
	                               <input type="submit"  value="新增" onclick="getReferenceForm(this).action='${ctx}/pages/gas/Ttzhz/create.do?<mytag:params includes="ec*,s*" type="queryStringUtf"/>'"/>
			              </td>
		           </tr>
	    </table>
    </s:form>
</div>
			
</body>

</html>