<%@page import="com.dyneinfo.jxy.model.*" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/commons/taglibs.jsp" %>

	<s:hidden id="fileid" name="fileid" />

<!-- ONGL access static field: @package.class@field or @vs@field -->

		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <FONT color="red">*</FONT><%=FileAttach.ALIAS_FILENAME%>
		                  </td>
			              <td>
		                           <s:textfield label="%{@vs@ALIAS_FILENAME}" key="filename" value="%{model.filename}"  cssClass="required max-length-128" required="true" />
		                  </td>
                          <td class="crosscolor_td">
			                      <FONT color="red">*</FONT><%=FileAttach.ALIAS_CONTENTTYPE%>
		                  </td>
			              <td>
		                           <s:textfield label="%{@vs@ALIAS_CONTENTTYPE}" key="contenttype" value="%{model.contenttype}"  cssClass="required max-length-50" required="true" />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=FileAttach.ALIAS_FILESIZE%>
		                  </td>
			              <td>
		                           <s:textfield label="%{@vs@ALIAS_FILESIZE}" key="filesize" value="%{model.filesize}"  cssClass="max-length-50" required="false" />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=FileAttach.ALIAS_FILEEXT%>
		                  </td>
			              <td>
		                           <s:textfield label="%{@vs@ALIAS_FILEEXT}" key="fileext" value="%{model.fileext}"  cssClass="max-length-32" required="false" />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=FileAttach.ALIAS_FILE_SAVE%>
		                  </td>
			              <td>
		                           <s:textfield label="%{@vs@ALIAS_FILE_SAVE}" key="fileSave" value="%{model.fileSave}"  cssClass="validate-number " required="false" />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=FileAttach.ALIAS_CONTENT%>
		                  </td>
			              <td>
		                           <s:textfield label="%{@vs@ALIAS_CONTENT}" key="content" value="%{model.content}"  cssClass="" required="false" />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=FileAttach.ALIAS_FILEPATH%>
		                  </td>
			              <td>
		                           <s:textfield label="%{@vs@ALIAS_FILEPATH}" key="filepath" value="%{model.filepath}"  cssClass="max-length-512" required="false" />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=FileAttach.ALIAS_ABSOLUTEPATH%>
		                  </td>
			              <td>
		                           <s:textfield label="%{@vs@ALIAS_ABSOLUTEPATH}" key="absolutepath" value="%{model.absolutepath}"  cssClass="max-length-512" required="false" />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=FileAttach.ALIAS_FILEGROUP%>
		                  </td>
			              <td>
		                           <s:textfield label="%{@vs@ALIAS_FILEGROUP}" key="filegroup" value="%{model.filegroup}"  cssClass="max-length-32" required="false" />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=FileAttach.ALIAS_RELATION_ID%>
		                  </td>
			              <td>
		                           <s:textfield label="%{@vs@ALIAS_RELATION_ID}" key="relationId" value="%{model.relationId}"  cssClass="max-length-32" required="false" />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=FileAttach.ALIAS_NOTE%>
		                  </td>
			              <td>
		                           <s:textfield label="%{@vs@ALIAS_NOTE}" key="note" value="%{model.note}"  cssClass="max-length-1024" required="false" />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=FileAttach.ALIAS_CREATETIME%>
		                  </td>
			              <td>
		                           <input value="${model.createtimeString}" onclick="WdatePicker({dateFmt:'<%=FileAttach.FORMAT_CREATETIME%>'})" id="createtimeString" name="createtimeString"  maxlength="0" class="Wdate" />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=FileAttach.ALIAS_CREATOR%>
		                  </td>
			              <td>
		                           <s:textfield label="%{@vs@ALIAS_CREATOR}" key="creator" value="%{model.creator}"  cssClass="max-length-32" required="false" />
		                  </td>
                          <td>&nbsp;</td>
                          <td>&nbsp;</td>
                   </tr>
 
 
