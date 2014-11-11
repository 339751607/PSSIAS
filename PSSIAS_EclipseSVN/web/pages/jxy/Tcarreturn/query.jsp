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
	<title><%=Tcarreturn.TABLE_ALIAS%>查询</title>
</head>

<body>
<%@ include file="/commons/messages.jsp" %>
<div class="queryPanel">
    <s:form action="/jxy/Tcarreturn/list.do"  theme="simple" style="display: inline;" method="post">
	    <table cellpadding="0" cellspacing="0" border="0" class="tb_all">
	               <tr>
			              <td class="tb_title" colspan="4"><%=Tcarreturn.TABLE_ALIAS%>查询</td>
		           </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=Tcarreturn.ALIAS_DELINAME%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.deliname}"  name="s_deliname"  />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=Tcarreturn.ALIAS_DELICREDTYPE%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.delicredtype}"  name="s_delicredtype"  />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=Tcarreturn.ALIAS_DELICREDCODE%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.delicredcode}"  name="s_delicredcode"  />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=Tcarreturn.ALIAS_RECETIME%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.recetime}"  name="s_recetime"  />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=Tcarreturn.ALIAS_RECENAME%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.recename}"  name="s_recename"  />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=Tcarreturn.ALIAS_TAKEOFFNAME%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.takeoffname}"  name="s_takeoffname"  />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=Tcarreturn.ALIAS_TOCREDTYPE%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.tocredtype}"  name="s_tocredtype"  />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=Tcarreturn.ALIAS_TOCREDCODE%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.tocredcode}"  name="s_tocredcode"  />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=Tcarreturn.ALIAS_TOTIME%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.totime}"  name="s_totime"  />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=Tcarreturn.ALIAS_FLAG%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.flag}"  name="s_flag"  />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=Tcarreturn.ALIAS_ENROLTIME%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.enroltime}"  name="s_enroltime"  />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=Tcarreturn.ALIAS_OPERATOR%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.operator}"  name="s_operator"  />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=Tcarreturn.ALIAS_DELITELEPHONE%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.delitelephone}"  name="s_delitelephone"  />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=Tcarreturn.ALIAS_SERVERITEM%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.serveritem}"  name="s_serveritem"  />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=Tcarreturn.ALIAS_DEMO%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.demo}"  name="s_demo"  />
		                  </td>
                          <td>&nbsp;</td>
                          <td>&nbsp;</td>
                   </tr>
		           <tr>
			              <td class="tb_bottom" colspan="4">
			                       <input type="submit"  value="查询" onclick="getReferenceForm(this).action='${ctx}/jxy/Tcarreturn/list.do'"/>
	                               <input type="submit"  value="新增" onclick="getReferenceForm(this).action='${ctx}/jxy/Tcarreturn/create.do?<mytag:params includes="ec*,s*" type="queryStringUtf"/>'"/>
			              </td>
		           </tr>
	    </table>
    </s:form>
</div>
			
</body>

</html>
