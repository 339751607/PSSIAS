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
	<title><%=TtztbFile.TABLE_ALIAS%>查询</title>
</head>

<body>
<%@ include file="/commons/messages.jsp" %>
<div class="queryPanel">
    <s:form action="/pages/gas/TtztbFile/list.do"  theme="simple" style="display: inline;" method="post">
	    <table cellpadding="0" cellspacing="0" border="0" class="tb_all">
	               <tr>
			              <td class="tb_title" colspan="4"><%=TtztbFile.TABLE_ALIAS%>查询</td>
		           </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=TtztbFile.ALIAS_FILEID%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.fileid}"  name="s_fileid"  />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=TtztbFile.ALIAS_FILECONTENT%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.filecontent}"  name="s_filecontent"  />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=TtztbFile.ALIAS_TZTBTYPE%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.tztbtype}"  name="s_tztbtype"  />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=TtztbFile.ALIAS_FILENAME%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.filename}"  name="s_filename"  />
		                  </td>
                   </tr>
		           <tr>
			              <td class="tb_bottom" colspan="4">
			                       <input type="submit"  value="查询" onclick="getReferenceForm(this).action='${ctx}/pages/gas/TtztbFile/list.do'"/>
	                               <input type="submit"  value="新增" onclick="getReferenceForm(this).action='${ctx}/pages/gas/TtztbFile/create.do?<mytag:params includes="ec*,s*" type="queryStringUtf"/>'"/>
			              </td>
		           </tr>
	    </table>
    </s:form>
</div>
			
</body>

</html>