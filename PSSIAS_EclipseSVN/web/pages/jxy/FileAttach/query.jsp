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
	<title><%=FileAttach.TABLE_ALIAS%>查询</title>
</head>

<body>
<%@ include file="/commons/messages.jsp" %>
<div class="queryPanel">
    <s:form action="/jxy/FileAttach/list.do"  theme="simple" style="display: inline;" method="post">
	    <table cellpadding="0" cellspacing="0" border="0" class="tb_all">
	               <tr>
			              <td class="tb_title" colspan="4"><%=FileAttach.TABLE_ALIAS%>查询</td>
		           </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=FileAttach.ALIAS_FILENAME%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.filename}"  name="s_filename"  />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=FileAttach.ALIAS_CONTENTTYPE%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.contenttype}"  name="s_contenttype"  />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=FileAttach.ALIAS_FILESIZE%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.filesize}"  name="s_filesize"  />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=FileAttach.ALIAS_FILEEXT%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.fileext}"  name="s_fileext"  />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=FileAttach.ALIAS_FILE_SAVE%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.fileSave}"  name="s_fileSave"  />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=FileAttach.ALIAS_CONTENT%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.content}"  name="s_content"  />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=FileAttach.ALIAS_FILEPATH%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.filepath}"  name="s_filepath"  />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=FileAttach.ALIAS_ABSOLUTEPATH%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.absolutepath}"  name="s_absolutepath"  />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=FileAttach.ALIAS_FILEGROUP%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.filegroup}"  name="s_filegroup"  />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=FileAttach.ALIAS_RELATION_ID%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.relationId}"  name="s_relationId"  />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=FileAttach.ALIAS_NOTE%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.note}"  name="s_note"  />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=FileAttach.ALIAS_CREATETIME%>
		                  </td>
			              <td>
		                           <s:select name="dateSelect11" list="dateSelectMap"  onchange="dateselect(this,'s_createtimeBegin','s_createtimeEnd','yyyy-MM-dd');"  value="#request.dateSelect11" listKey="key"   listValue="value" theme="simple" label=""  emptyOption="false" ></s:select>
			                          从<input id="d31311" name="s_createtimeBegin"  value="${pageRequest.filters.createtimeBegin}"   maxlength="0" size="12" class="Wdate" type="text" onFocus="WdatePicker({dateFmt:'<%=FileAttach.FORMAT_CREATETIME%>',maxDate:'#F{$dp.$D(\'d31411\')}'})"/> &nbsp;到&nbsp;
			                        <input id="d31411" name="s_createtimeEnd"   value="${pageRequest.filters.createtimeEnd}"  maxlength="0" size="12" class="Wdate" type="text" onFocus="WdatePicker({dateFmt:'<%=FileAttach.FORMAT_CREATETIME%>',minDate:'#F{$dp.$D(\'d31311\')}'})"/>
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=FileAttach.ALIAS_CREATOR%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.creator}"  name="s_creator"  />
		                  </td>
                          <td>&nbsp;</td>
                          <td>&nbsp;</td>
                   </tr>
		           <tr>
			              <td class="tb_bottom" colspan="4">
			                       <input type="submit"  value="查询" onclick="getReferenceForm(this).action='${ctx}/jxy/FileAttach/list.do'"/>
	                               <input type="submit"  value="新增" onclick="getReferenceForm(this).action='${ctx}/jxy/FileAttach/create.do?<mytag:params includes="ec*,s*" type="queryStringUtf"/>'"/>
			              </td>
		           </tr>
	    </table>
    </s:form>
</div>
			
</body>

</html>
