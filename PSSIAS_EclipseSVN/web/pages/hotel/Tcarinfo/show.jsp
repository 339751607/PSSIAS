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
	<title><%=Tcarinfo.TABLE_ALIAS%>信息</title>
</head>

<body>
<%@ include file="/commons/messages.jsp" %>

<s:form action="/pages/hotel/Tcarinfo/list.do" method="get" theme="simple">
	<s:hidden name="enrolid" id="enrolid" value="%{model.enrolid}"/>
	<table width="100%" border="1" bordercolor="#7c8ca7" align="center"  cellPadding="0" cellSpacing="0" class="tb_all">
	               <tr>
				          <td colspan="5" class="tb_title"> 
							<%=Tcarinfo.TABLE_ALIAS%>信息
				          </td>
		           </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=Tcarinfo.ALIAS_CAROWNER%>
		                  </td>
			              <td>
		                           <s:property value="%{model.carowner}" />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=Tcarinfo.ALIAS_CARTYPE%>
		                  </td>
			              <td>
			              		   <mytag:write property="%{model.cartype}" dictName="cllx"/>
		                  </td>
					<td rowspan="5"  align="center" width="15%">
					     
									<img
							src='${ctx}/pages/hotel/Tcarinfo/showPic.do?enrolid=<s:property value="%{model.enrolid}" />'
							onerror="this.src='${ctx}/images/noCar.gif'"  alt=""
							height="120" width="200" border="0" name="photo">
								
						
					</td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=Tcarinfo.ALIAS_BRAND%>
		                  </td>
			              <td>
		                           <s:property value="%{model.brand}" />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=Tcarinfo.ALIAS_COLOR%>
		                  </td>
			              <td>
			              		   <mytag:write property="%{model.color}" dictName="csys"/>
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=Tcarinfo.ALIAS_CARID%>
		                  </td>
			              <td>
		                           <s:property value="%{model.carid}" />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=Tcarinfo.ALIAS_ENGINECODE%>
		                  </td>
			              <td>
		                           <s:property value="%{model.enginecode}" />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=Tcarinfo.ALIAS_BODYCODE%>
		                  </td>
			              <td>
		                           <s:property value="%{model.bodycode}" />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=Tcarinfo.ALIAS_ENROLTIME%>
		                  </td>
			              <td>
		                           <s:property value="%{model.enroltime}" />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=Tcarinfo.ALIAS_CPCODE%>
		                  </td>
			              <td>
		                           <s:property value="%{model.hotelname}" />
		                  </td>
		                  <td></td>
		                  <td></td>
                   </tr>
	</table>	
</s:form>

</body>

</html>