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
	<title><%=Ttz.TABLE_ALIAS%>查询</title>
</head>

<body>
<%@ include file="/commons/messages.jsp" %>
<div class="queryPanel">
    <s:form action="/pages/gas/Ttz/list.do"  theme="simple" style="display: inline;" method="post">
	   <table width="100%" border="1" bordercolor="#7c8ca7" align="center" 	cellPadding="0" cellSpacing="0" class="tb_all">
	               <tr>
			              <td class="tb_title" colspan="4"><%=Ttz.TABLE_ALIAS%>查询</td>
		           </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=Ttz.ALIAS_RQ%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.rq}"  name="s_rq"  />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=Ttz.ALIAS_NR%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.nr}"  name="s_nr"  />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=Ttz.ALIAS_BT%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.bt}"  name="s_bt"  />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=Ttz.ALIAS_FSQT%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.fsqt}"  name="s_fsqt"  />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=Ttz.ALIAS_FSDW%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.fsdw}"  name="s_fsdw"  />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=Ttz.ALIAS_FSR%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.fsr}"  name="s_fsr"  />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=Ttz.ALIAS_BURCODE%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.burcode}"  name="s_burcode"  />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=Ttz.ALIAS_STACODE%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.stacode}"  name="s_stacode"  />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=Ttz.ALIAS_USERUNIT%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.userunit}"  name="s_userunit"  />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=Ttz.ALIAS_HZFLAG%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.hzflag}"  name="s_hzflag"  />
		                  </td>
                   </tr>
		           <tr>
			              <td class="tb_bottom" colspan="4">
			                       <input type="submit"  value="查询" onclick="getReferenceForm(this).action='${ctx}/pages/gas/Ttz/list.do'"/>
	                               <input type="submit"  value="新增" onclick="getReferenceForm(this).action='${ctx}/pages/gas/Ttz/create.do?<mytag:params includes="ec*,s*" type="queryStringUtf"/>'"/>
			              </td>
		           </tr>
	    </table>
    </s:form>
</div>
			
</body>

</html>