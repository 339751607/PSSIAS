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
	<title><%=SsDictType.TABLE_ALIAS%>查询</title>
</head>

<body>
<%@ include file="/commons/messages.jsp" %>
<div class="queryPanel">
    <s:form action="/pages/SsDictType/list.do"  theme="simple" style="display: inline;" method="post">
	     <table width="100%" border="1" bordercolor="#7c8ca7" align="center"  cellPadding="0" cellSpacing="0" class="tb_all">
	               <tr>
			              <td class="tb_title" colspan="4"><%=SsDictType.TABLE_ALIAS%>查询</td>
		           </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=SsDictType.ALIAS_DICTTYPENAME%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.dicttypename}"  name="s_dicttypename"  />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=SsDictType.ALIAS_DICTLEVEL%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.dictlevel}"  name="s_dictlevel"  />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=SsDictType.ALIAS_PARENTID%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.parentid}"  name="s_parentid"  />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=SsDictType.ALIAS_SEQNO%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.seqno}"  name="s_seqno"  />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=SsDictType.ALIAS_DICTFLAG%>
		                  </td>
			              <td>
				                   <mytag:select  name="s_dictflag"   notEmpty="false"  dictName="dictflag"/>
		                  </td>
                          <td class="crosscolor_td">
			                      <%=SsDictType.ALIAS_QUERYSQL%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.querysql}"  name="s_querysql"  />
		                  </td>
                   </tr>
		           <tr>
			              <td class="tb_bottom" colspan="4">
			                       <input type="submit"  value="查询" onclick="getReferenceForm(this).action='${ctx}/pages/SsDictType/list.do'"/>
	                               <input type="submit"  value="新增" onclick="getReferenceForm(this).action='${ctx}/pages/SsDictType/create.do?<mytag:params includes="ec*,s*" type="queryStringUtf"/>'"/>
			              </td>
		           </tr>
	    </table>
    </s:form>
</div>
			
</body>

</html>