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
	<title><%=Temployee.TABLE_ALIAS%>信息</title>
</head>

<body>
<%@ include file="/commons/messages.jsp" %>

<s:form action="/pages/hotel/Temployee/list.do" method="get" theme="simple">
	<s:hidden name="empcode" id="empcode" value="%{model.empcode}"/>
	<table cellpadding="0" cellspacing="0" border="0" class="tb_all">
	               <tr>
				          <td colspan="5" class="tb_title"> 
							<%=Temployee.TABLE_ALIAS%>信息
				          </td>
		           </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=Temployee.ALIAS_EMPNAME%>
		                  </td>
			              <td>
		                           <s:property value="%{model.empname}" />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=Temployee.ALIAS_ALIAS%>
		                  </td>
			              <td>
		                           <s:property value="%{model.alias}" />
		                  </td>
		                  <td rowspan="7" align="center" width="15%">
		                  <img
							src='${ctx}/pages/hotel/Temployee/showPic.do?id=<s:property value="%{model.empcode}" />'
							onerror="this.src='${ctx}/images/spacer.gif'"  alt=""
							width="130" height="170"  border="0" name="photo">
		                  </td>				                  
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=Temployee.ALIAS_SEX%>
		                  </td>
			              <td>
		                           <mytag:write property="%{model.sex}" dictName="T_DIC_SEX"/>
		                  </td>
                          <td class="crosscolor_td">
			                      <%=Temployee.ALIAS_BIRTH%>
		                  </td>
			              <td>
		                           <s:property value="%{model.birth}" />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=Temployee.ALIAS_STATURE%>
		                  </td>
			              <td>
		                           <s:property value="%{model.stature}" />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=Temployee.ALIAS_WEIGHT%>
		                  </td>
			              <td>
		                           <s:property value="%{model.weight}" />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=Temployee.ALIAS_POSTURE%>
		                  </td>
			              <td>
		                           <s:property value="%{model.posture}" />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=Temployee.ALIAS_POLITYVISAGE%>
		                  </td>
			              <td>
		                           <s:property value="%{model.polityvisage}" />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=Temployee.ALIAS_FOLK%>
		                  </td>
			              <td>
		                           <mytag:write property="%{model.folk}" dictName="DIC_ITEM_HOTEL_NATION"/>
		                  </td>
                          <td class="crosscolor_td">
			                      <%=Temployee.ALIAS_NATIVEPLACE%>
		                  </td>
			              <td>
		                           <mytag:write property="%{model.nativeplace}" dictName="T_DIC_XZQH"/>
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=Temployee.ALIAS_ADDRESS%>
		                  </td>
			              <td>
		                           <s:property value="%{model.address}" />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=Temployee.ALIAS_NOWADRESS%>
		                  </td>
			              <td>
		                           <s:property value="%{model.nowadress}" />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=Temployee.ALIAS_PHONE%>
		                  </td>
			              <td>
		                           <s:property value="%{model.phone}" />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=Temployee.ALIAS_SCHOOLAGE%>
		                  </td>
			              <td>
		                           <s:property value="%{model.schoolage}" />
		                  </td>
		                  
                   </tr>
		           <tr  class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=Temployee.ALIAS_PERSONID%>
		                  </td>
			              <td>
		                           <s:property value="%{model.personid}" />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=Temployee.ALIAS_NPCODE%>
		                  </td>
			              <td colspan="2">
		                           <mytag:write property="%{model.npcode}" dictName="T_DIC_XZQH"/>
		                           
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=Temployee.ALIAS_NPADDRESS%>
		                  </td>
			              <td>
		                           <s:property value="%{model.npaddress}" />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=Temployee.ALIAS_TEMPORARYCODE%>
		                  </td>
			              <td colspan="2">
		                           <s:property value="%{model.temporarycode}" />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=Temployee.ALIAS_INSERTTIME%>
		                  </td>
			              <td>
		                           <s:property value="%{model.inserttime}" />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=Temployee.ALIAS_EDITTIME%>
		                  </td>
			              <td colspan="2">
		                           <s:property value="%{model.edittime}" />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=Temployee.ALIAS_HYZH%>
		                  </td>
			              <td>
		                           <s:property value="%{model.hyzh}" />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=Temployee.ALIAS_CYRJZT%>
		                  </td>
			              <td colspan="2">
		                           <mytag:write property="%{model.cyrjzt}" dictName="cyryFlag"/>
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=Temployee.ALIAS_TRATIME%>
		                  </td>
			              <td>
		                           <s:property value="%{model.tratime}" />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=Temployee.ALIAS_INDBTIME%>
		                  </td>
			              <td colspan="2">
		                           <s:property value="%{model.indbtime}" />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=Temployee.ALIAS_HOTELNAME%>
		                  </td>
			              <td>
		                          <s:property value="%{model.hotelname}" />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=Temployee.ALIAS_STACODE%>
		                  </td>
			              <td colspan="2">
		                           <mytag:write property="%{model.stacode}"  dictName="teHangDwbm"/>
		                  </td >
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=Temployee.ALIAS_BURCODE%>
		                  </td>
			              <td>
		                           <mytag:write property="%{model.burcode}"  dictName="ssfj" />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=Temployee.ALIAS_CITYCODE%>
		                  </td>
			              <td colspan="2">
		                           <s:property value="%{model.citycode}" />
		                  </td>
                   </tr>
	</table>	
</s:form>

</body>

</html>
