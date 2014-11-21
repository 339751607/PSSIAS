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
	<link href="${ctx}/widgets/extremecomponents/extremecomponents.css" type="text/css" rel=stylesheet>
	<title><%=FileAttach.TABLE_ALIAS%> 维护</title>
</head>

<body onload="quickSelectInit()" >
<%@ include file="/commons/messages.jsp" %>

<div class="queryPanel">
    <s:form action="/pages/jxy/FileAttach/list.do"  theme="simple" style="display: inline;" method="post">
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
		                           <s:select name="dateSelect11" list="dateSelectMap"  onchange="dateselect('list_dateSelect11','d31311','d31411','yyyy-MM-dd');"  value="#request.dateSelect11" listKey="key"   listValue="value" theme="simple" label=""  emptyOption="false" ></s:select>
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
			                       <input type="submit"  value="查询" onclick="getReferenceForm(this).action='${ctx}/pages/jxy/FileAttach/list.do'"/>
	                               <input type="submit"  value="新增" onclick="getReferenceForm(this).action='${ctx}/pages/jxy/FileAttach/create.do?<mytag:params includes="ec*,s*" type="queryStringUtf"/>'"/>
	                               <input type="button"  value="删除" onclick="doDel();"/>
			              </td>
		           </tr>
	    </table>
    </s:form>
</div>



<ec:table items='page.result' var="item" method="get"
	retrieveRowsCallback="limit" sortRowsCallback="limit" filterRowsCallback="limit"
	action="${ctx}/pages/jxy/FileAttach/list.do" autoIncludeParameters="true">
	<ec:row>
		<ec:column property="选择" title="<input type='checkbox' onclick=\"setAllCheckboxState('items',this.checked)\" >" sortable="false" width="3%" viewsAllowed="html">
			<input type="checkbox" name="items" value="fileid=${item.fileid}&"/>
		</ec:column>
		                    <ec:column property="filename"  title="<%=FileAttach.ALIAS_FILENAME%>"/>
		                    <ec:column property="contenttype"  title="<%=FileAttach.ALIAS_CONTENTTYPE%>"/>
		                    <ec:column property="filesize"  title="<%=FileAttach.ALIAS_FILESIZE%>"/>
		                    <ec:column property="fileext"  title="<%=FileAttach.ALIAS_FILEEXT%>"/>
		                    <ec:column property="fileSave"  title="<%=FileAttach.ALIAS_FILE_SAVE%>"/>
		                    <ec:column property="content"  title="<%=FileAttach.ALIAS_CONTENT%>"/>
		                    <ec:column property="filepath"  title="<%=FileAttach.ALIAS_FILEPATH%>"/>
		                    <ec:column property="absolutepath"  title="<%=FileAttach.ALIAS_ABSOLUTEPATH%>"/>
		                    <ec:column property="filegroup"  title="<%=FileAttach.ALIAS_FILEGROUP%>"/>
		                    <ec:column property="relationId"  title="<%=FileAttach.ALIAS_RELATION_ID%>"/>
		                    <ec:column property="note"  title="<%=FileAttach.ALIAS_NOTE%>"/>
		                    <ec:column property="createtime" value="${item.createtimeString}" title="<%=FileAttach.ALIAS_CREATETIME%>"/>
		                    <ec:column property="creator"  title="<%=FileAttach.ALIAS_CREATOR%>"/>
		<ec:column property="操作" title="操作" sortable="false" viewsAllowed="html">
			<a href="${ctx}/pages/jxy/FileAttach/show.do?fileid=${item.fileid}&<mytag:params includes="ec*,s*" type="queryStringUtf"/>">查看</a>&nbsp;&nbsp;&nbsp;
			<a href="${ctx}/pages/jxy/FileAttach/edit.do?fileid=${item.fileid}&<mytag:params includes="ec*,s*" type="queryStringUtf"/>">修改</a>
		</ec:column>
	</ec:row>
</ec:table>

</body>

</html>


<script>
	  function doDel() {
		    var form = document.forms.ec;
			if(!form) return;
			if (!hasOneChecked('items')){
               alert('请选择要操作的对象!');
               return;
             }
	        if (confirm('确定执行[删除]操作?')){
				var input_txt = document.createElement("input");
				input_txt.type = "hidden";
				input_txt.name = "returnUrl";
				input_txt.value = "!/pages/jxy/FileAttach/list.do?<mytag:params includes="ec*,s*" type="queryStringUtf"/>";
				form.appendChild(input_txt);
		        form.action = '${ctx}/pages/jxy/FileAttach/delete.do';
	            form.submit();
	        }
	  }
</script>
