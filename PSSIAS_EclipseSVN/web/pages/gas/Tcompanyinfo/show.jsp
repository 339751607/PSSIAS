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
	<title><%=Tcompanyinfo.TABLE_ALIAS%>信息</title>
</head>

<body>
<%@ include file="/commons/messages.jsp" %>

<s:form action="/pages/gas/Tcompanyinfogas/list.do" method="get" theme="simple">
	<s:hidden name="cpcode" id="cpcode" value="%{model.cpcode}"/>
	<table width="100%" border="1" bordercolor="#7c8ca7" align="center" 	cellPadding="0" cellSpacing="0" class="tb_all">
	               <tr>
				          <td colspan="4" class="tb_title"> 
							<%=Tcompanyinfo.TABLE_ALIAS%>详细
				          </td>
		           </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=Tcompanyinfo.ALIAS_CPNAME%>
		                  </td>
			              <td>
		                           <s:property value="%{model.cpname}" />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=Tcompanyinfo.ALIAS_CPCODE%>
		                  </td>
			              <td>
		                           <s:property value="%{model.cpcode}" />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=Tcompanyinfo.ALIAS_LEGA_LNAME%>
		                  </td>
			              <td>
		                           <s:property value="%{model.legaLname}" />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=Tcompanyinfo.ALIAS_LEGAL_CARD%>
		                  </td>
			              <td>
		                           <s:property value="%{model.legalCard}" />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=Tcompanyinfo.ALIAS_PHONE%>
		                  </td>
			              <td>
		                           <s:property value="%{model.phone}" />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=Tcompanyinfo.ALIAS_ADDRESS%>
		                  </td>
			              <td>
		                           <s:property value="%{model.address}" />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=Tcompanyinfo.ALIAS_STATUS%>
		                  </td>
			              <td>
		                           <mytag:write property="%{status}"  name="status"   notEmpty="true"  dictName="T_DIC_CPSTATE"/>
		                          
		                           
		                  </td>
                          <td class="crosscolor_td">
			                      <%=Tcompanyinfo.ALIAS_MOD_TIME%>
		                  </td>
			              <td>
		                           <s:property value="%{model.modTime}" />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=Tcompanyinfo.ALIAS_GASOLINE_TYPE%>
		                  </td>
			              <td>
		                           <s:property value="%{model.gasolineType}" />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=Tcompanyinfo.ALIAS_CPTYPE%>
		                  </td>
			              <td>
		                          <mytag:write property="%{cptype}"  name="cptype"   notEmpty="true"  dictName="T_DIC_CPKIND"/>
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=Tcompanyinfo.ALIAS_MACHINE%>
		                  </td>
			              <td>
		                           <s:property value="%{model.machine}" />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=Tcompanyinfo.ALIAS_MONITOR%>
		                  </td>
			              <td>
		                           <s:property value="%{model.monitor}" />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=Tcompanyinfo.ALIAS_BURCODE%>
		                  </td>
			              <td>
		                           <mytag:write property="%{model.burcode}"   name="burcode"  notEmpty="true"  dictName="teHangDwbm"/>
		                  </td>
                          <td class="crosscolor_td">
			                      <%=Tcompanyinfo.ALIAS_STACODE%>
		                  </td>
			              <td>
		                           <mytag:write property="%{model.stacode}"   name="stacode"  notEmpty="true"  dictName="teHangDwbm"/>
		                  </td>
                   </tr>
                   <tr>
						  <td colspan="4" class="tb_bottom">
						           <input type="button" value="返回" onclick="window.location='${ctx}/pages/gas/Tcompanyinfogas/querylist.do?<mytag:params includes="ec*,s*" type="queryStringUtf"/>'"/>
	                      </td>
	               </tr>
	</table>	
</s:form>

</body>

</html>