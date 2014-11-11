<%@page import="com.dyneinfo.fjy.model.*" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/commons/taglibs.jsp" %>

	<s:hidden id="logid" name="logid" />

<!-- ONGL access static field: @package.class@field or @vs@field -->

		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=TcpinfoLog.ALIAS_CPCODE%>
		                  </td>
			              <td>
		                           <s:textfield label="%{@vs@ALIAS_CPCODE}" key="cpcode" value="%{model.cpcode}"  cssClass="max-length-13" required="false" />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=TcpinfoLog.ALIAS_USERID%>
		                  </td>
			              <td>
		                           <s:textfield label="%{@vs@ALIAS_USERID}" key="userid" value="%{model.userid}"  cssClass="max-length-20" required="false" />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=TcpinfoLog.ALIAS_DEPTID%>
		                  </td>
			              <td>
		                           <s:textfield label="%{@vs@ALIAS_DEPTID}" key="deptid" value="%{model.deptid}"  cssClass="max-length-13" required="false" />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=TcpinfoLog.ALIAS_TYPE%>
		                  </td>
			              <td>
		                           <s:textfield label="%{@vs@ALIAS_TYPE}" key="type" value="%{model.type}"  cssClass="max-length-20" required="false" />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=TcpinfoLog.ALIAS_DEPTNAME%>
		                  </td>
			              <td>
		                           <s:textfield label="%{@vs@ALIAS_DEPTNAME}" key="deptname" value="%{model.deptname}"  cssClass="max-length-100" required="false" />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=TcpinfoLog.ALIAS_USERNAME%>
		                  </td>
			              <td>
		                           <s:textfield label="%{@vs@ALIAS_USERNAME}" key="username" value="%{model.username}"  cssClass="max-length-50" required="false" />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=TcpinfoLog.ALIAS_UPDATEDATE%>
		                  </td>
			              <td>
		                           <input value="${model.updatedateString}" onclick="WdatePicker({dateFmt:'<%=TcpinfoLog.FORMAT_UPDATEDATE%>'})" id="updatedateString" name="updatedateString"  maxlength="0" class="Wdate" />
		                  </td>
                          <td>&nbsp;</td>
                          <td>&nbsp;</td>
                   </tr>
 
 
