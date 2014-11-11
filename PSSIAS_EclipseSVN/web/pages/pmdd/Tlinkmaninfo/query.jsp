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
	<title><%=Tlinkmaninfo.TABLE_ALIAS%>查询</title>
</head>

<body>
<%@ include file="/commons/messages.jsp" %>
<div class="queryPanel">
    <s:form action="/pages/pmdd/Tlinkmaninfo/list.do"  theme="simple" style="display: inline;" method="post">
	    <table cellpadding="0" cellspacing="0" border="0" class="tb_all">
	               <tr>
			              <td class="tb_title" colspan="4"><%=Tlinkmaninfo.TABLE_ALIAS%>查询</td>
		           </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=Tlinkmaninfo.ALIAS_EMPCODE%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.empcode}"  name="s_empcode"  />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=Tlinkmaninfo.ALIAS_LINKMAN%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.linkman}"  name="s_linkman"  />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=Tlinkmaninfo.ALIAS_IDCODE%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.idcode}"  name="s_idcode"  />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=Tlinkmaninfo.ALIAS_SEX%>
		                  </td>
			              <td>
				                   <mytag:select  name="s_sex"   notEmpty="false"  dictName="T_DIC_SEX"/>
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=Tlinkmaninfo.ALIAS_JOBORDWELL%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.jobordwell}"  name="s_jobordwell"  />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=Tlinkmaninfo.ALIAS_COMMADDRESS%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.commaddress}"  name="s_commaddress"  />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=Tlinkmaninfo.ALIAS_PHONE%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.phone}"  name="s_phone"  />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=Tlinkmaninfo.ALIAS_RELATION%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.relation}"  name="s_relation"  />
		                  </td>
                   </tr>
		           <tr>
			              <td class="tb_bottom" colspan="4">
			                       <input type="submit"  value="查询" onclick="getReferenceForm(this).action='${ctx}/pages/pmdd/Tlinkmaninfo/list.do'"/>
	                               <input type="submit"  value="新增" onclick="getReferenceForm(this).action='${ctx}/pages/pmdd/Tlinkmaninfo/create.do?<mytag:params includes="ec*,s*" type="queryStringUtf"/>'"/>
			              </td>
		           </tr>
	    </table>
    </s:form>
</div>
			
</body>

</html>