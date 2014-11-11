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
	<title><%=FileAttach.TABLE_ALIAS%>信息</title>
</head>

<body>
<%@ include file="/commons/messages.jsp" %>

<s:form action="/jxy/FileAttach/list.do" method="get" theme="simple">
	<s:hidden name="fileid" id="fileid" value="%{model.fileid}"/>
	<table cellpadding="0" cellspacing="0" border="0" class="tb_all">
	               <tr>
				          <td colspan="4" class="tb_title"> 
							<%=FileAttach.TABLE_ALIAS%>信息
				          </td>
		           </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=FileAttach.ALIAS_FILENAME%>
		                  </td>
			              <td>
		                           <s:property value="%{model.filename}" />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=FileAttach.ALIAS_CONTENTTYPE%>
		                  </td>
			              <td>
		                           <s:property value="%{model.contenttype}" />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=FileAttach.ALIAS_FILESIZE%>
		                  </td>
			              <td>
		                           <s:property value="%{model.filesize}" />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=FileAttach.ALIAS_FILEEXT%>
		                  </td>
			              <td>
		                           <s:property value="%{model.fileext}" />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=FileAttach.ALIAS_FILE_SAVE%>
		                  </td>
			              <td>
		                           <s:property value="%{model.fileSave}" />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=FileAttach.ALIAS_CONTENT%>
		                  </td>
			              <td>
		                           <s:property value="%{model.content}" />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=FileAttach.ALIAS_FILEPATH%>
		                  </td>
			              <td>
		                           <s:property value="%{model.filepath}" />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=FileAttach.ALIAS_ABSOLUTEPATH%>
		                  </td>
			              <td>
		                           <s:property value="%{model.absolutepath}" />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=FileAttach.ALIAS_FILEGROUP%>
		                  </td>
			              <td>
		                           <s:property value="%{model.filegroup}" />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=FileAttach.ALIAS_RELATION_ID%>
		                  </td>
			              <td>
		                           <s:property value="%{model.relationId}" />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=FileAttach.ALIAS_NOTE%>
		                  </td>
			              <td>
		                           <s:property value="%{model.note}" />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=FileAttach.ALIAS_CREATETIME%>
		                  </td>
			              <td>
		                           <s:property value="%{model.createtimeString}" />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=FileAttach.ALIAS_CREATOR%>
		                  </td>
			              <td>
		                           <s:property value="%{model.creator}" />
		                  </td>
                          <td>&nbsp;</td>
                          <td>&nbsp;</td>
                   </tr>
                   <tr>
						  <td colspan="4" class="tb_bottom">
						           <input type="button" value="返回" onclick="window.location='${ctx}/jxy/FileAttach/list.do?<mytag:params includes="ec*,s*" type="queryStringUtf"/>'"/>
	                      </td>
	               </tr>
	</table>	
</s:form>

</body>

</html>
