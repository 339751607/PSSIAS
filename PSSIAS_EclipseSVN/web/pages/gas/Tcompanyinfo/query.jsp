<%@page import="com.dyneinfo.gas.model.*" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/commons/taglibs.jsp" %>
<%
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+request.getContextPath()+"/";
%>
<html>

<head>
	<%@ include file="/commons/meta.jsp" %>
	<base href="<%=basePath%>">
	<title><%=Tcompanyinfo.TABLE_ALIAS%>查询</title>
</head>

<body>
<%@ include file="/commons/messages.jsp" %>
<div class="queryPanel">
    <s:form action="/pages/gas/Tcompanyinfogas/list.do"  theme="simple" style="display: inline;" method="post">
	    <table cellpadding="0" cellspacing="0" border="0" class="tb_all">
	               <tr>
			              <td class="tb_title" colspan="4"><%=Tcompanyinfo.TABLE_ALIAS%>查询</td>
		           </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=Tcompanyinfo.ALIAS_CPNAME%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.cpname}"  name="s_cpname"  />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=Tcompanyinfo.ALIAS_LEGA_LNAME%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.legaLname}"  name="s_legaLname"  />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=Tcompanyinfo.ALIAS_LEGAL_CARD%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.legalCard}"  name="s_legalCard"  />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=Tcompanyinfo.ALIAS_PHONE%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.phone}"  name="s_phone"  />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=Tcompanyinfo.ALIAS_ADDRESS%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.address}"  name="s_address"  />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=Tcompanyinfo.ALIAS_STATUS%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.status}"  name="s_status"  />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=Tcompanyinfo.ALIAS_MOD_TIME%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.modTime}"  name="s_modTime"  />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=Tcompanyinfo.ALIAS_GASOLINE_TYPE%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.gasolineType}"  name="s_gasolineType"  />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=Tcompanyinfo.ALIAS_CPTYPE%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.cptype}"  name="s_cptype"  />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=Tcompanyinfo.ALIAS_MACHINE%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.machine}"  name="s_machine"  />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=Tcompanyinfo.ALIAS_MONITOR%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.monitor}"  name="s_monitor"  />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=Tcompanyinfo.ALIAS_BURCODE%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.burcode}"  name="s_burcode"  />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=Tcompanyinfo.ALIAS_STACODE%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.stacode}"  name="s_stacode"  />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=Tcompanyinfo.ALIAS_EXITEND1%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.exitend1}"  name="s_exitend1"  />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=Tcompanyinfo.ALIAS_EXITEND2%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.exitend2}"  name="s_exitend2"  />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=Tcompanyinfo.ALIAS_EXITEND3%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.exitend3}"  name="s_exitend3"  />
		                  </td>
                   </tr>
		           <tr>
			              <td class="tb_bottom" colspan="4">
			                       <input type="submit"  value="查询" onclick="getReferenceForm(this).action='${ctx}/pages/gas/Tcompanyinfogas/list.do'"/>
	                               <input type="submit"  value="新增" onclick="getReferenceForm(this).action='${ctx}/pages/gas/Tcompanyinfogas/create.do?<mytag:params includes="ec*,s*" type="queryStringUtf"/>'"/>
			              </td>
		           </tr>
	    </table>
    </s:form>
</div>
			
</body>

</html>