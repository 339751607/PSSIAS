<%@page import="com.dyneinfo.zazh.model.*" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/commons/taglibs.jsp" %>
<%
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+request.getContextPath()+"/";
%>
<html>

<head>
	<%@ include file="/commons/meta.jsp" %>
	<base href="<%=basePath%>">
	<title><%=SsDatasource.TABLE_ALIAS%>信息</title>
</head>

<body>
<%@ include file="/commons/messages.jsp" %>

<s:form action="/pages/zazh/SsDatasource/list.do" method="get" theme="simple">
	<s:hidden name="id" id="id" value="%{model.id}"/>
	<table width="100%" border="1" bordercolor="#7c8ca7" align="center"  cellPadding="0" cellSpacing="0" class="tb_all">
	               <tr>
				          <td colspan="4" class="tb_title"> 
							<%=SsDatasource.TABLE_ALIAS%>信息
				          </td>
		           </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td" width="20%">
			                      行业代码
		                  </td>
			              <td width="25%">
		                          <s:property value="%{model.code}" />
		                  </td>
                          <td class="crosscolor_td"  width="20%">
			                      <%=SsDatasource.ALIAS_CALLED%>
		                  </td>
			              <td  width="25%">
		                           <s:property value="%{model.called}" />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=SsDatasource.ALIAS_DBS_DRIVERCLASSNAME%>
		                  </td>
			              <td>
		                           <s:property value="%{model.dbsDriverclassname}" />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=SsDatasource.ALIAS_DBS_URL%>
		                  </td>
			              <td>
		                           <s:property value="%{model.dbsUrl}" />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=SsDatasource.ALIAS_DBS_USERNAME%>
		                  </td>
			              <td>
		                           <s:property value="%{model.dbsUsername}" />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=SsDatasource.ALIAS_DBS_PASSWORD%>
		                  </td>
			              <td>
		                           <s:property value="%{model.dbsPassword}" />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=SsDatasource.ALIAS_DBS_NAME%>
		                  </td>
			              <td>
		                           <s:property value="%{model.dbsName}" />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=SsDatasource.ALIAS_ISVALID%>
		                  </td>
			              <td>
		                          
		                     <mytag:write property="%{model.isvalid}"   name="isvalid"   notEmpty="false"  dictName="T_DICT_VALID"/>
		                  
		                  </td>
                   </tr>
                   <!--  
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=SsDatasource.ALIAS_EXTEND1%>
		                  </td>
			              <td>
		                           <s:property value="%{model.extend1}" />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=SsDatasource.ALIAS_EXTEND2%>
		                  </td>
			              <td>
		                           <s:property value="%{model.extend2}" />
		                  </td>
                   </tr>
                   -->
                   <tr>
						  <td colspan="4" class="tb_bottom">
						           <input type="button" value="返回" onclick="window.location='${ctx}/pages/zazh/SsDatasource/list.do?<mytag:params includes="ec*,s*" type="queryStringUtf"/>'"/>
	                      </td>
	               </tr>
	</table>	
</s:form>

</body>

</html>