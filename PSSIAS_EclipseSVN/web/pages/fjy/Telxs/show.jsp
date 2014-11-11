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
	<title><%=Telxs.TABLE_ALIAS%>信息</title>
</head>

<body>
<%@ include file="/commons/messages.jsp" %>

<s:form action="/pages/fjy/Telxs/list.do" method="get" theme="simple">
	<s:hidden name="telinfoid" id="telinfoid" value="%{model.telinfoid}"/>
	<table cellpadding="0" cellspacing="0" border="1" class="tb_all">
	               <tr>
				          <td colspan="4" class="tb_title"> 
							<%=Telxs.TABLE_ALIAS%>信息
				          </td>
		           </tr>
		           <tr class="crosscolor_tr">
                          <td width="15%" class="crosscolor_td">
			                      <%=Telxs.ALIAS_GMRXM%>
		                  </td>
			              <td width="35%">
		                           <s:property value="%{model.gmrxm}" />
		                  </td>
                          <td  width="15%" class="crosscolor_td">
			                      <%=Telxs.ALIAS_GMRXB%>
		                  </td>
			              <td>
			                       <mytag:write property="%{model.gmrxb}"   name="gmrxb"  notEmpty="true"  dictName="T_DIC_SEX"/>
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=Telxs.ALIAS_GMRSFZH%>
		                  </td>
			              <td>
		                           <s:property value="%{model.gmrsfzh}" />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=Telxs.ALIAS_GMRLXDH%>
		                  </td>
			              <td>
		                           <s:property value="%{model.gmrlxdh}" />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=Telxs.ALIAS_GMRJTZZ%>
		                  </td>
			              <td>
		                           <s:property value="%{model.gmrjtzz}" />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=Telxs.ALIAS_JBR%>
		                  </td>
			              <td>
		                           <s:property value="%{model.jbr}" />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=Telxs.ALIAS_BZ%>
		                  </td>
			              <td>
		                           <s:property value="%{model.bz}" />
		                  </td>
                          <td>&nbsp;</td>
                          <td>&nbsp;</td>
                   </tr>
                   <tr>
						  <td colspan="4" class="tb_bottom">
						            <input type="button" value="返回" onclick="window.parent.location='${ctx}/pages/fjy/TelInfoView/listAll.do?<mytag:params includes="ec*,s*,telinfoid*" type="queryStringUtf"/>'"/>
	                      </td>
	               </tr>
	</table>	
</s:form>

</body>

</html>