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
	<title><%=SsDictItem.TABLE_ALIAS%>信息</title>
</head>

<body>
<%@ include file="/commons/messages.jsp" %>

<s:form action="/pages/SsDictItem/list.do" method="get" theme="simple">
	<s:hidden name="dicttypeid" id="dicttypeid" value="%{model.dicttypeid}"/>
	  <table width="100%" border="1" bordercolor="#7c8ca7" align="center"  cellPadding="0" cellSpacing="0" class="tb_all">
	               <tr>
				          <td colspan="4" class="tb_title"> 
							<%=SsDictItem.TABLE_ALIAS%>信息
				          </td>
		           </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=SsDictItem.ALIAS_DICTID%>
		                  </td>
			              <td>
		                           <s:property value="%{model.dictid}" />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=SsDictItem.ALIAS_DICTNAME%>
		                  </td>
			              <td>
		                           <s:property value="%{model.dictname}" />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=SsDictItem.ALIAS_STATUS%>
		                  </td>
			              <td>
			                       <mytag:write property="%{model.status}"   name="status"  notEmpty="true"  dictName="status"/>
		                  </td>
                          <td class="crosscolor_td">
			                      <%=SsDictItem.ALIAS_SORTNO%>
		                  </td>
			              <td>
		                           <s:property value="%{model.sortno}" />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=SsDictItem.ALIAS_DICTLEVEL%>
		                  </td>
			              <td>
		                           <s:property value="%{model.dictlevel}" />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=SsDictItem.ALIAS_PARENTID%>
		                  </td>
			              <td>
		                           <s:property value="%{model.parentid}" />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=SsDictItem.ALIAS_SEQNO%>
		                  </td>
			              <td>
		                           <s:property value="%{model.seqno}" />
		                  </td>
                          <td>&nbsp;</td>
                          <td>&nbsp;</td>
                   </tr>
                   <tr>
						  <td colspan="4" class="tb_bottom">
						           <input type="button" value="返回" onclick="window.location='${ctx}/pages/SsDictItem/list.do?<mytag:params includes="ec*,s*" type="queryStringUtf"/>'"/>
	                      </td>
	               </tr>
	</table>	
</s:form>

</body>

</html>