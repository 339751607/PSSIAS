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
	<title><%=SsNoticeReply.TABLE_ALIAS%>信息</title>
</head>

<body>
<%@ include file="/commons/messages.jsp" %>

<s:form action="/jxy/SsNoticeReply/list.do" method="get" theme="simple">
	<s:hidden name="noticeid" id="noticeid" value="%{model.noticeid}"/>
	<s:hidden name="deptid" id="deptid" value="%{model.deptid}"/>
	<table cellpadding="0" cellspacing="0" border="0" class="tb_all">
	               <tr>
				          <td colspan="4" class="tb_title"> 
							<%=SsNoticeReply.TABLE_ALIAS%>信息
				          </td>
		           </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=SsNoticeReply.ALIAS_NOTICEID%>
		                  </td>
			              <td>
		                           <s:property value="%{model.noticeid}" />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=SsNoticeReply.ALIAS_DEPTID%>
		                  </td>
			              <td>
		                           <s:property value="%{model.deptid}" />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=SsNoticeReply.ALIAS_REPLYDATE%>
		                  </td>
			              <td>
		                           <s:property value="%{model.replydate}" />
		                  </td>
                          <td>&nbsp;</td>
                          <td>&nbsp;</td>
                   </tr>
                   <tr>
						  <td colspan="4" class="tb_bottom">
						           <input type="button" value="返回" onclick="window.location='${ctx}/jxy/SsNoticeReply/list.do?<mytag:params includes="ec*,s*" type="queryStringUtf"/>'"/>
	                      </td>
	               </tr>
	</table>	
</s:form>

</body>

</html>
