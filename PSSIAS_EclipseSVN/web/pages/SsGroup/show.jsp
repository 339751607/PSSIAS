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
	<title><%=SsGroup.TABLE_ALIAS%>信息</title>
</head>

<body>
<%@ include file="/commons/messages.jsp" %>

<s:form action="/pages/SsGroup/list.do" method="get" theme="simple">
	<s:hidden name="groupid" id="groupid" value="%{model.groupid}"/>
	<table cellpadding="0" cellspacing="0" border="0" class="tb_all">
	               <tr>
				          <td colspan="4" class="tb_title"> 
							<%=SsGroup.TABLE_ALIAS%>信息
				          </td>
		           </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=SsGroup.ALIAS_ORGID%>
		                  </td>
			              <td>
		                           <s:property value="%{model.orgid}" />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=SsGroup.ALIAS_PARENTGROUPID%>
		                  </td>
			              <td>
		                           <s:property value="%{model.parentgroupid}" />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=SsGroup.ALIAS_GROUPLEVEL%>
		                  </td>
			              <td>
		                           <s:property value="%{model.grouplevel}" />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=SsGroup.ALIAS_GROUPNAME%>
		                  </td>
			              <td>
		                           <s:property value="%{model.groupname}" />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=SsGroup.ALIAS_GROUPDESC%>
		                  </td>
			              <td>
		                           <s:property value="%{model.groupdesc}" />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=SsGroup.ALIAS_GROUPTYPE%>
		                  </td>
			              <td>
		                           <s:property value="%{model.grouptype}" />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=SsGroup.ALIAS_GROUPSEQ%>
		                  </td>
			              <td>
		                           <s:property value="%{model.groupseq}" />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=SsGroup.ALIAS_STARTDATE%>
		                  </td>
			              <td>
		                           <s:property value="%{model.startdateString}" />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=SsGroup.ALIAS_ENDDATE%>
		                  </td>
			              <td>
		                           <s:property value="%{model.enddateString}" />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=SsGroup.ALIAS_GROUPSTATUS%>
		                  </td>
			              <td>
		                           <s:property value="%{model.groupstatus}" />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=SsGroup.ALIAS_MANAGER%>
		                  </td>
			              <td>
		                           <s:property value="%{model.manager}" />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=SsGroup.ALIAS_CREATETIME%>
		                  </td>
			              <td>
		                           <s:property value="%{model.createtimeString}" />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=SsGroup.ALIAS_LASTUPDATE%>
		                  </td>
			              <td>
		                           <s:property value="%{model.lastupdateString}" />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=SsGroup.ALIAS_ISLEAF%>
		                  </td>
			              <td>
		                           <s:property value="%{model.isleaf}" />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=SsGroup.ALIAS_DISPLAYORDER%>
		                  </td>
			              <td>
		                           <s:property value="%{model.displayorder}" />
		                  </td>
                          <td>&nbsp;</td>
                          <td>&nbsp;</td>
                   </tr>
                   <tr>
						  <td colspan="4" class="tb_bottom">
						           <input type="button" value="返回" onclick="window.location='${ctx}/pages/SsGroup/list.do?<mytag:params includes="ec*,s*" type="queryStringUtf"/>'"/>
	                      </td>
	               </tr>
	</table>	
</s:form>

</body>

</html>