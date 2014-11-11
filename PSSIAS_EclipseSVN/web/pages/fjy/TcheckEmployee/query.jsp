<%@page import="com.dyneinfo.fjy.model.*" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/commons/taglibs.jsp" %>
<%
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+request.getContextPath()+"/";
%>
<html>

<head>
	<%@ include file="/commons/meta.jsp" %>
	<base href="<%=basePath%>">
	<title><%=TcheckEmployee.TABLE_ALIAS%>查询</title>
</head>

<body>
<%@ include file="/commons/messages.jsp" %>
<div class="queryPanel">
    <s:form action="/pages/fjy/TcheckEmployee/list.do"  theme="simple" style="display: inline;" method="post">
	    <table cellpadding="0" cellspacing="0" border="1" class="tb_all">
	               <tr>
			              <td class="tb_title" colspan="4"><%=TcheckEmployee.TABLE_ALIAS%>查询</td>
		           </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=TcheckEmployee.ALIAS_IDCARD%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.idcard}"  name="s_idcard"  />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=TcheckEmployee.ALIAS_EMPTYPE%>
		                  </td>
			              <td>
				                   <mytag:select  name="s_emptype"   notEmpty="false"  dictName="D_empType"/>
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=TcheckEmployee.ALIAS_POLICENO%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.policeno}"  name="s_policeno"  />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=TcheckEmployee.ALIAS_FULLNAME%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.fullname}"  name="s_fullname"  />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=TcheckEmployee.ALIAS_SEX%>
		                  </td>
			              <td>
				                   <mytag:select  name="s_sex"   notEmpty="false"  dictName="T_DIC_SEX"/>
		                  </td>
                          <td class="crosscolor_td">
			                      <%=TcheckEmployee.ALIAS_DEPTID%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.deptid}"  name="s_deptid"  />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=TcheckEmployee.ALIAS_DEMO%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.demo}"  name="s_demo"  />
		                  </td>
                          <td>&nbsp;</td>
                          <td>&nbsp;</td>
                   </tr>
		           <tr>
			              <td class="tb_bottom" colspan="4">
			                       <input type="submit"  value="查询" onclick="getReferenceForm(this).action='${ctx}/pages/fjy/TcheckEmployee/list.do'"/>
	                               <input type="submit"  value="新增" onclick="getReferenceForm(this).action='${ctx}/pages/fjy/TcheckEmployee/create.do?<mytag:params includes="ec*,s*" type="queryStringUtf"/>'"/>
			              </td>
		           </tr>
	    </table>
    </s:form>
</div>
			
</body>

</html>