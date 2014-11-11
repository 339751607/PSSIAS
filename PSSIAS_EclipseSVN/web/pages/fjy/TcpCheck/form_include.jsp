<%@page import="com.dyneinfo.fjy.model.*" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/commons/taglibs.jsp" %>

	<s:hidden id="id" name="id" />

<!-- ONGL access static field: @package.class@field or @vs@field -->

		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=TcpCheck.ALIAS_DEPTID%>
		                  </td>
			              <td>
		                           <s:textfield label="%{@vs@ALIAS_DEPTID}" key="deptid" value="%{model.deptid}"  cssClass="validate-integer " required="false" />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=TcpCheck.ALIAS_IDCARD%>
		                  </td>
			              <td>
		                           <s:textfield label="%{@vs@ALIAS_IDCARD}" key="idcard" value="%{model.idcard}"  cssClass="max-length-20" required="false" />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=TcpCheck.ALIAS_CHECKTIME%>
		                  </td>
			              <td>
						           <input value="${model.checktime}" onclick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss'})" id="checktime" name="checktime"  maxlength="0" class="required Wdate" />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=TcpCheck.ALIAS_DEMO%>
		                  </td>
			              <td>
		                           <s:textfield label="%{@vs@ALIAS_DEMO}" key="demo" value="%{model.demo}"  cssClass="max-length-2000" required="false" />
		                  </td>
                   </tr>
 
 
