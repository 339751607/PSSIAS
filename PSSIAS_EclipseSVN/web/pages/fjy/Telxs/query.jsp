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
	<title><%=Telxs.TABLE_ALIAS%>查询</title>
</head>

<body>
<%@ include file="/commons/messages.jsp" %>
<div class="queryPanel">
    <s:form action="/pages/fjy/Telxs/list.do"  theme="simple" style="display: inline;" method="post">
	    <table cellpadding="0" cellspacing="0" border="1" class="tb_all">
	               <tr>
			              <td class="tb_title" colspan="4"><%=Telxs.TABLE_ALIAS%>查询</td>
		           </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=Telxs.ALIAS_GMRXM%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.gmrxm}"  name="s_gmrxm"  />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=Telxs.ALIAS_GMRXB%>
		                  </td>
			              <td>
				                   <mytag:select  name="s_gmrxb"   notEmpty="false"  dictName="T_DIC_SEX"/>
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=Telxs.ALIAS_GMRSFZH%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.gmrsfzh}"  name="s_gmrsfzh"  />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=Telxs.ALIAS_GMRLXDH%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.gmrlxdh}"  name="s_gmrlxdh"  />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=Telxs.ALIAS_GMRJTZZ%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.gmrjtzz}"  name="s_gmrjtzz"  />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=Telxs.ALIAS_JBR%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.jbr}"  name="s_jbr"  />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=Telxs.ALIAS_BZ%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.bz}"  name="s_bz"  />
		                  </td>
                          <td>&nbsp;</td>
                          <td>&nbsp;</td>
                   </tr>
		           <tr>
			              <td class="tb_bottom" colspan="4">
			                       <input type="submit"  value="查询" onclick="getReferenceForm(this).action='${ctx}/pages/fjy/Telxs/list.do'"/>
	                               <input type="submit"  value="新增" onclick="getReferenceForm(this).action='${ctx}/pages/fjy/Telxs/create.do?<mytag:params includes="ec*,s*" type="queryStringUtf"/>'"/>
			              </td>
		           </tr>
	    </table>
    </s:form>
</div>
			
</body>

</html>