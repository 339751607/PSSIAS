<%@page import="com.dyneinfo.pmdd.model.*" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/commons/taglibs.jsp" %>
<%
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+request.getContextPath()+"/";
%>
<html>

<head>
	<%@ include file="/commons/meta.jsp" %>
	<base href="<%=basePath%>">
	<title><%=Pmdwnsxxb.TABLE_ALIAS%>查询</title>
</head>

<body>
<%@ include file="/commons/messages.jsp" %>
<div class="queryPanel">
    <s:form action="/pages/pmdd/Pmdwnsxxb/list.do"  theme="simple" style="display: inline;" method="post">
	    <table cellpadding="0" cellspacing="0" border="0" class="tb_all">
	               <tr>
			              <td class="tb_title" colspan="4"><%=Pmdwnsxxb.TABLE_ALIAS%>查询</td>
		           </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=Pmdwnsxxb.ALIAS_TIB_FLOWGUID%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.tibFlowguid}"  name="s_tibFlowguid"  />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=Pmdwnsxxb.ALIAS_TIB_ROWGUID%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.tibRowguid}"  name="s_tibRowguid"  />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=Pmdwnsxxb.ALIAS_NSND%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.nsnd}"  name="s_nsnd"  />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=Pmdwnsxxb.ALIAS_TH_TYPE%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.thType}"  name="s_thType"  />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=Pmdwnsxxb.ALIAS_NSRQ%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.nsrq}"  name="s_nsrq"  />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=Pmdwnsxxb.ALIAS_NSJG%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.nsjg}"  name="s_nsjg"  />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=Pmdwnsxxb.ALIAS_NSYJ%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.nsyj}"  name="s_nsyj"  />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=Pmdwnsxxb.ALIAS_NSYJQSR%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.nsyjqsr}"  name="s_nsyjqsr"  />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=Pmdwnsxxb.ALIAS_NSYJJBR%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.nsyjjbr}"  name="s_nsyjjbr"  />
		                  </td>
                          <td>&nbsp;</td>
                          <td>&nbsp;</td>
                   </tr>
		           <tr>
			              <td class="tb_bottom" colspan="4">
			                       <input type="submit"  value="查询" onclick="getReferenceForm(this).action='${ctx}/pages/pmdd/Pmdwnsxxb/list.do'"/>
	                               <input type="submit"  value="新增" onclick="getReferenceForm(this).action='${ctx}/pages/pmdd/Pmdwnsxxb/create.do?<mytag:params includes="ec*,s*" type="queryStringUtf"/>'"/>
			              </td>
		           </tr>
	    </table>
    </s:form>
</div>
			
</body>

</html>