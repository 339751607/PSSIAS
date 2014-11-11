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
	<title><%=Tcarinfo.TABLE_ALIAS%>查询</title>
</head>

<body>
<%@ include file="/commons/messages.jsp" %>
<div class="queryPanel">
    <s:form action="/jxy/Tcarinfo/list.do"  theme="simple" style="display: inline;" method="post">
	    <table cellpadding="0" cellspacing="0" border="0" class="tb_all">
	               <tr>
			              <td class="tb_title" colspan="4"><%=Tcarinfo.TABLE_ALIAS%>查询</td>
		           </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=Tcarinfo.ALIAS_CAROWNER%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.carowner}"  name="s_carowner"  />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=Tcarinfo.ALIAS_CARTYPE%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.cartype}"  name="s_cartype"  />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=Tcarinfo.ALIAS_BRAND%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.brand}"  name="s_brand"  />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=Tcarinfo.ALIAS_COLOR%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.color}"  name="s_color"  />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=Tcarinfo.ALIAS_CARID%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.carid}"  name="s_carid"  />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=Tcarinfo.ALIAS_ENGINECODE%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.enginecode}"  name="s_enginecode"  />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=Tcarinfo.ALIAS_BODYCODE%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.bodycode}"  name="s_bodycode"  />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=Tcarinfo.ALIAS_ENROLTIME%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.enroltime}"  name="s_enroltime"  />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=Tcarinfo.ALIAS_OPERATOR%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.operator}"  name="s_operator"  />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=Tcarinfo.ALIAS_CPCODE%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.cpcode}"  name="s_cpcode"  />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=Tcarinfo.ALIAS_FLAG%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.flag}"  name="s_flag"  />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=Tcarinfo.ALIAS_CARPICTURE%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.carpicture}"  name="s_carpicture"  />
		                  </td>
                   </tr>
		           <tr>
			              <td class="tb_bottom" colspan="4">
			                       <input type="submit"  value="查询" onclick="getReferenceForm(this).action='${ctx}/jxy/Tcarinfo/list.do'"/>
	                               <input type="submit"  value="新增" onclick="getReferenceForm(this).action='${ctx}/jxy/Tcarinfo/create.do?<mytag:params includes="ec*,s*" type="queryStringUtf"/>'"/>
			              </td>
		           </tr>
	    </table>
    </s:form>
</div>
			
</body>

</html>
