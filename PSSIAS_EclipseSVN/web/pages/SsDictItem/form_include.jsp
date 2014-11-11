<%@page import="com.dyneinfo.zazh.model.*" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/commons/taglibs.jsp" %>

	<s:hidden id="dicttypeid" name="dicttypeid" />

<!-- ONGL access static field: @package.class@field or @vs@field -->

		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <FONT color="red">*</FONT><%=SsDictItem.ALIAS_DICTID%>
		                  </td>
			              <td>
		                           <s:textfield label="%{@vs@ALIAS_DICTID}" key="dictid" value="%{model.dictid}" cssClass="required max-length-128" required="true" />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=SsDictItem.ALIAS_DICTNAME%>
		                  </td>
			              <td>
		                           <s:textfield label="%{@vs@ALIAS_DICTNAME}" key="dictname" value="%{model.dictname}" cssClass="max-length-255" required="false" />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=SsDictItem.ALIAS_STATUS%>
		                  </td>
			              <td>
						           <mytag:select property="%{model.status}"   styleClass="required validate-selection"  name="status"   notEmpty="false"  dictName="status"/>
		                  </td>
                          <td class="crosscolor_td">
			                      <%=SsDictItem.ALIAS_SORTNO%>
		                  </td>
			              <td>
		                           <s:textfield label="%{@vs@ALIAS_SORTNO}" key="sortno" value="%{model.sortno}" cssClass="validate-integer " required="false" />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=SsDictItem.ALIAS_DICTLEVEL%>
		                  </td>
			              <td>
		                           <s:textfield label="%{@vs@ALIAS_DICTLEVEL}" key="dictlevel" value="%{model.dictlevel}" cssClass="validate-integer " required="false" />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=SsDictItem.ALIAS_PARENTID%>
		                  </td>
			              <td>
		                           <s:textfield label="%{@vs@ALIAS_PARENTID}" key="parentid" value="%{model.parentid}" cssClass="max-length-255" required="false" />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=SsDictItem.ALIAS_SEQNO%>
		                  </td>
			              <td>
		                           <s:textfield label="%{@vs@ALIAS_SEQNO}" key="seqno" value="%{model.seqno}" cssClass="max-length-255" required="false" />
		                  </td>
                          <td>&nbsp;</td>
                          <td>&nbsp;</td>
                   </tr>
 
 
