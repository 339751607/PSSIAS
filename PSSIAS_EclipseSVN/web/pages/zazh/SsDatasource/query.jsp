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
	<title>行业数据源查询</title>
</head>

<body>
<%@ include file="/commons/messages.jsp" %>
<div class="queryPanel">
    <s:form action="/pages/zazh/SsDatasource/list.do"  theme="simple" style="display: inline;" method="post">
	    <table width="100%" border="1" bordercolor="#7c8ca7" align="center"  cellPadding="0" cellSpacing="0" class="tb_all">
	               <tr>
			              <td class="tb_title" colspan="4"><%=SsDatasource.TABLE_ALIAS%>查询</td>
		           </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=SsDatasource.ALIAS_CODE%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.code}"  name="s_code"  />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=SsDatasource.ALIAS_CALLED%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.called}"  name="s_called"  />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=SsDatasource.ALIAS_DBS_DRIVERCLASSNAME%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.dbsDriverclassname}"  name="s_dbsDriverclassname"  />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=SsDatasource.ALIAS_DBS_URL%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.dbsUrl}"  name="s_dbsUrl"  />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=SsDatasource.ALIAS_DBS_USERNAME%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.dbsUsername}"  name="s_dbsUsername"  />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=SsDatasource.ALIAS_DBS_PASSWORD%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.dbsPassword}"  name="s_dbsPassword"  />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=SsDatasource.ALIAS_DBS_NAME%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.dbsName}"  name="s_dbsName"  />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=SsDatasource.ALIAS_ISVALID%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.isvalid}"  name="s_isvalid"  />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=SsDatasource.ALIAS_EXTEND1%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.extend1}"  name="s_extend1"  />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=SsDatasource.ALIAS_EXTEND2%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.extend2}"  name="s_extend2"  />
		                  </td>
                   </tr>
		           <tr>
			              <td class="tb_bottom" colspan="4">
			                       <input type="submit"  value="查询" onclick="getReferenceForm(this).action='${ctx}/pages/zazh/SsDatasource/list.do'"/>
	                               <input type="submit"  value="新增" onclick="getReferenceForm(this).action='${ctx}/pages/zazh/SsDatasource/create.do?<mytag:params includes="ec*,s*" type="queryStringUtf"/>'"/>
			              </td>
		           </tr>
	    </table>
    </s:form>
</div>
			
</body>

</html>