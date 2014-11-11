<%@page import="com.dyneinfo.zazh.model.*" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/commons/taglibs.jsp" %>

	<s:hidden id="groupid" name="groupid" />

<!-- ONGL access static field: @package.class@field or @vs@field -->

		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=SsGroup.ALIAS_ORGID%>
		                  </td>
			              <td>
		                           <s:textfield label="%{@vs@ALIAS_ORGID}" key="orgid" value="%{model.orgid}"  cssClass="validate-integer " required="false" />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=SsGroup.ALIAS_PARENTGROUPID%>
		                  </td>
			              <td>
		                           <s:textfield label="%{@vs@ALIAS_PARENTGROUPID}" key="parentgroupid" value="%{model.parentgroupid}"  cssClass="validate-integer " required="false" />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=SsGroup.ALIAS_GROUPLEVEL%>
		                  </td>
			              <td>
		                           <s:textfield label="%{@vs@ALIAS_GROUPLEVEL}" key="grouplevel" value="%{model.grouplevel}"  cssClass="validate-integer max-value-2147483647" required="false" />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=SsGroup.ALIAS_GROUPNAME%>
		                  </td>
			              <td>
		                           <s:textfield label="%{@vs@ALIAS_GROUPNAME}" key="groupname" value="%{model.groupname}"  cssClass="max-length-64" required="false" />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=SsGroup.ALIAS_GROUPDESC%>
		                  </td>
			              <td>
		                           <s:textfield label="%{@vs@ALIAS_GROUPDESC}" key="groupdesc" value="%{model.groupdesc}"  cssClass="max-length-64" required="false" />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=SsGroup.ALIAS_GROUPTYPE%>
		                  </td>
			              <td>
		                           <s:textfield label="%{@vs@ALIAS_GROUPTYPE}" key="grouptype" value="%{model.grouptype}"  cssClass="max-length-64" required="false" />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=SsGroup.ALIAS_GROUPSEQ%>
		                  </td>
			              <td>
		                           <s:textfield label="%{@vs@ALIAS_GROUPSEQ}" key="groupseq" value="%{model.groupseq}"  cssClass="max-length-1024" required="false" />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=SsGroup.ALIAS_STARTDATE%>
		                  </td>
			              <td>
		                           <input value="${model.startdateString}" onclick="WdatePicker({dateFmt:'<%=SsGroup.FORMAT_STARTDATE%>'})" id="startdateString" name="startdateString"  maxlength="0" class="Wdate" />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=SsGroup.ALIAS_ENDDATE%>
		                  </td>
			              <td>
		                           <input value="${model.enddateString}" onclick="WdatePicker({dateFmt:'<%=SsGroup.FORMAT_ENDDATE%>'})" id="enddateString" name="enddateString"  maxlength="0" class="Wdate" />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=SsGroup.ALIAS_GROUPSTATUS%>
		                  </td>
			              <td>
		                           <s:textfield label="%{@vs@ALIAS_GROUPSTATUS}" key="groupstatus" value="%{model.groupstatus}"  cssClass="max-length-64" required="false" />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=SsGroup.ALIAS_MANAGER%>
		                  </td>
			              <td>
		                           <s:textfield label="%{@vs@ALIAS_MANAGER}" key="manager" value="%{model.manager}"  cssClass="max-length-128" required="false" />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=SsGroup.ALIAS_CREATETIME%>
		                  </td>
			              <td>
		                           <input value="${model.createtimeString}" onclick="WdatePicker({dateFmt:'<%=SsGroup.FORMAT_CREATETIME%>'})" id="createtimeString" name="createtimeString"  maxlength="0" class="Wdate" />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=SsGroup.ALIAS_LASTUPDATE%>
		                  </td>
			              <td>
		                           <input value="${model.lastupdateString}" onclick="WdatePicker({dateFmt:'<%=SsGroup.FORMAT_LASTUPDATE%>'})" id="lastupdateString" name="lastupdateString"  maxlength="0" class="Wdate" />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=SsGroup.ALIAS_ISLEAF%>
		                  </td>
			              <td>
		                           <s:textfield label="%{@vs@ALIAS_ISLEAF}" key="isleaf" value="%{model.isleaf}"  cssClass="max-length-1" required="false" />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=SsGroup.ALIAS_DISPLAYORDER%>
		                  </td>
			              <td>
		                           <s:textfield label="%{@vs@ALIAS_DISPLAYORDER}" key="displayorder" value="%{model.displayorder}"  cssClass="validate-integer max-value-2147483647" required="false" />
		                  </td>
                          <td>&nbsp;</td>
                          <td>&nbsp;</td>
                   </tr>
 
 
