<%@page import="com.dyneinfo.hotel.model.*" %>
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
	<title><%=Tcarinfo.TABLE_ALIAS%> 维护</title>
</head>

<body onload="quickSelectInit()" >
<%@ include file="/commons/messages.jsp" %>

<div class="queryPanel">
    <s:form action="/pages/hotel/Tcarinfo/list.do"  theme="simple" style="display: inline;" method="post">
	    <table width="100%" border="1" bordercolor="#7c8ca7" align="center"  cellPadding="0" cellSpacing="0" class="tb_all">
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
			                       <input type="submit"  value="查询" onclick="getReferenceForm(this).action='${ctx}/pages/hotel/Tcarinfo/list.do'"/>
	                               <input type="submit"  value="新增" onclick="getReferenceForm(this).action='${ctx}/pages/hotel/Tcarinfo/create.do?<mytag:params includes="ec*,s*" type="queryStringUtf"/>'"/>
	                               <input type="button"  value="删除" onclick="doDel();"/>
			              </td>
		           </tr>
	    </table>
    </s:form>
</div>



<ec:table items='page.result' var="item" method="get"
	retrieveRowsCallback="limit" sortRowsCallback="limit" filterRowsCallback="limit"
	action="${ctx}/pages/hotel/Tcarinfo/list.do" autoIncludeParameters="true">
	<ec:row>
		<ec:column property="选择" title="<input type='checkbox' onclick=\"setAllCheckboxState('items',this.checked)\" >" sortable="false" width="3%" viewsAllowed="html">
			<input type="checkbox" name="items" value="enrolid=${item.enrolid}&"/>
		</ec:column>
		                    <ec:column property="carowner"  title="<%=Tcarinfo.ALIAS_CAROWNER%>"/>
		                    <ec:column property="cartype"  title="<%=Tcarinfo.ALIAS_CARTYPE%>"/>
		                    <ec:column property="brand"  title="<%=Tcarinfo.ALIAS_BRAND%>"/>
		                    <ec:column property="color"  title="<%=Tcarinfo.ALIAS_COLOR%>"/>
		                    <ec:column property="carid"  title="<%=Tcarinfo.ALIAS_CARID%>"/>
		                    <ec:column property="enginecode"  title="<%=Tcarinfo.ALIAS_ENGINECODE%>"/>
		                    <ec:column property="bodycode"  title="<%=Tcarinfo.ALIAS_BODYCODE%>"/>
		                    <ec:column property="enroltime"  title="<%=Tcarinfo.ALIAS_ENROLTIME%>"/>
		                    <ec:column property="operator"  title="<%=Tcarinfo.ALIAS_OPERATOR%>"/>
		                    <ec:column property="cpcode"  title="<%=Tcarinfo.ALIAS_CPCODE%>"/>
		                    <ec:column property="flag"  title="<%=Tcarinfo.ALIAS_FLAG%>"/>
		                    <ec:column property="carpicture"  title="<%=Tcarinfo.ALIAS_CARPICTURE%>"/>
		<ec:column property="操作" title="操作" sortable="false" viewsAllowed="html">
			<a href="${ctx}/pages/hotel/Tcarinfo/show.do?enrolid=${item.enrolid}&<mytag:params includes="ec*,s*" type="queryStringUtf"/>">查看</a>&nbsp;&nbsp;&nbsp;
			<a href="${ctx}/pages/hotel/Tcarinfo/edit.do?enrolid=${item.enrolid}&<mytag:params includes="ec*,s*" type="queryStringUtf"/>">修改</a>
		</ec:column>
	</ec:row>
</ec:table>

</body>

</html>

