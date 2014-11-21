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
	<title><%=ThotelBsQa.TABLE_ALIAS%>查询</title>
</head>

<body>
<%@ include file="/commons/messages.jsp" %>
<div class="queryPanel">
    <s:form action="/pages/jxy/ThotelBsQa/list.do"  theme="simple" style="display: inline;" method="post">
	    <table cellpadding="0" cellspacing="0" border="0" class="tb_all">
	               <tr>
			              <td class="tb_title" colspan="4"><%=ThotelBsQa.TABLE_ALIAS%>查询</td>
		           </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=ThotelBsQa.ALIAS_CODE%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.code}"  name="s_code"  />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=ThotelBsQa.ALIAS_USERNAME%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.username}"  name="s_username"  />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=ThotelBsQa.ALIAS_WTSJ%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.wtsj}"  name="s_wtsj"  />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=ThotelBsQa.ALIAS_COMPUTERIP%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.computerip}"  name="s_computerip"  />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=ThotelBsQa.ALIAS_USERTEL%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.usertel}"  name="s_usertel"  />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=ThotelBsQa.ALIAS_WTNR%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.wtnr}"  name="s_wtnr"  />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=ThotelBsQa.ALIAS_WTFL%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.wtfl}"  name="s_wtfl"  />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=ThotelBsQa.ALIAS_JDSJ%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.jdsj}"  name="s_jdsj"  />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=ThotelBsQa.ALIAS_JDNR%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.jdnr}"  name="s_jdnr"  />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=ThotelBsQa.ALIAS_JDR%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.jdr}"  name="s_jdr"  />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=ThotelBsQa.ALIAS_JDBZ%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.jdbz}"  name="s_jdbz"  />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=ThotelBsQa.ALIAS_FLAG%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.flag}"  name="s_flag"  />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=ThotelBsQa.ALIAS_NOTE%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.note}"  name="s_note"  />
		                  </td>
                          <td>&nbsp;</td>
                          <td>&nbsp;</td>
                   </tr>
		           <tr>
			              <td class="tb_bottom" colspan="4">
			                       <input type="submit"  value="查询" onclick="getReferenceForm(this).action='${ctx}/pages/jxy/ThotelBsQa/list.do'"/>
	                               <input type="submit"  value="新增" onclick="getReferenceForm(this).action='${ctx}/pages/jxy/ThotelBsQa/create.do?<mytag:params includes="ec*,s*" type="queryStringUtf"/>'"/>
			              </td>
		           </tr>
	    </table>
    </s:form>
</div>
			
</body>

</html>
