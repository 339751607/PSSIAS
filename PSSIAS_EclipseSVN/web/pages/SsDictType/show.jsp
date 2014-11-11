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
	<title><%=SsDictType.TABLE_ALIAS%>信息</title>
</head>

<body>
<%@ include file="/commons/messages.jsp" %>

<s:form action="/pages/SsDictType/list.do" method="get" theme="simple">
	<s:hidden name="dicttypeid" id="dicttypeid" value="%{model.dicttypeid}"/>
	  <table width="100%" border="1" bordercolor="#7c8ca7" align="center"  cellPadding="0" cellSpacing="0" class="tb_all">
	               <tr>
				          <td colspan="4" class="tb_title"> 
							<%=SsDictType.TABLE_ALIAS%>信息
				          </td>
		           </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=SsDictType.ALIAS_DICTTYPENAME%>
		                  </td>
			              <td>
		                           <s:property value="%{model.dicttypename}" />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=SsDictType.ALIAS_DICTLEVEL%>
		                  </td>
			              <td>
		                           <s:property value="%{model.dictlevel}" />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=SsDictType.ALIAS_PARENTID%>
		                  </td>
			              <td>
		                           <s:property value="%{model.parentid}" />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=SsDictType.ALIAS_SEQNO%>
		                  </td>
			              <td>
		                           <s:property value="%{model.seqno}" />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=SsDictType.ALIAS_DICTFLAG%>
		                  </td>
			              <td>
			                       <mytag:write property="%{model.dictflag}"   name="dictflag"  notEmpty="true"  dictName="dictflag"/>
		                  </td>
                          <td class="crosscolor_td">
			                      <%=SsDictType.ALIAS_QUERYSQL%>
		                  </td>
			              <td>
		                           <s:property value="%{model.querysql}" />
		                  </td>
                   </tr>
                   <tr>
						  <td colspan="4" class="tb_bottom">
						           <input type="button" value="返回" onclick="window.location='${ctx}/pages/SsDictType/list.do?<mytag:params includes="ec*,s*" type="queryStringUtf"/>'"/>
	                      </td>
	               </tr>
	</table>	
</s:form>

</body>

</html>