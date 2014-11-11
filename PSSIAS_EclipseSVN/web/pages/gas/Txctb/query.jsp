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
	<title><%=Txctb.TABLE_ALIAS%>查询</title>
</head>

<body>
<%@ include file="/commons/messages.jsp" %>
<div class="queryPanel">
    <s:form action="/pages/gas/Txctb/list.do"  theme="simple" style="display: inline;" method="post">
	    <table width="100%" border="1" bordercolor="#7c8ca7" align="center" 	cellPadding="0" cellSpacing="0" class="tb_all">
	               <tr>
			              <td class="tb_title" colspan="4"><%=Txctb.TABLE_ALIAS%>查询</td>
		           </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=Txctb.ALIAS_FBR%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.fbr}"  name="s_fbr"  />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=Txctb.ALIAS_CZ%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.cz}"  name="s_cz"  />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=Txctb.ALIAS_FBSJ%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.fbsj}"  name="s_fbsj"  />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=Txctb.ALIAS_BT%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.bt}"  name="s_bt"  />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=Txctb.ALIAS_NR%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.nr}"  name="s_nr"  />
		                  </td>
                          <td>&nbsp;</td>
                          <td>&nbsp;</td>
                   </tr>
		           <tr>
			              <td class="tb_bottom" colspan="4">
			                       <input type="submit"  value="查询" onclick="getReferenceForm(this).action='${ctx}/pages/gas/Txctb/list.do'"/>
	                               <input type="submit"  value="新增" onclick="getReferenceForm(this).action='${ctx}/pages/gas/Txctb/create.do?<mytag:params includes="ec*,s*" type="queryStringUtf"/>'"/>
			              </td>
		           </tr>
	    </table>
    </s:form>
</div>
			
</body>

</html>