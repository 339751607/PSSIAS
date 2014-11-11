<%@page import="com.dyneinfo.pmdd.model.*" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/commons/taglibs.jsp" %>


<!-- ONGL access static field: @package.class@field or @vs@field -->

		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <FONT color="red">*</FONT><%=SsNoticeReply.ALIAS_NOTICEID%>
		                  </td>
			              <td>
		                           <s:textfield label="%{@vs@ALIAS_NOTICEID}" key="noticeid" value="%{model.noticeid}"  cssClass="required max-length-30" required="true" />
		                  </td>
                          <td class="crosscolor_td">
			                      <FONT color="red">*</FONT><%=SsNoticeReply.ALIAS_DEPTID%>
		                  </td>
			              <td>
		                           <s:textfield label="%{@vs@ALIAS_DEPTID}" key="deptid" value="%{model.deptid}"  cssClass="required max-length-30" required="true" />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=SsNoticeReply.ALIAS_REPLYDATE%>
		                  </td>
			              <td>
		                           <s:textfield label="%{@vs@ALIAS_REPLYDATE}" key="replydate" value="%{model.replydate}"  cssClass="max-length-14" required="false" />
		                  </td>
                          <td>&nbsp;</td>
                          <td>&nbsp;</td>
                   </tr>
 
 
