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
	<title><%=TchPre.TABLE_ALIAS%>信息</title>
</head>

<body>
<%@ include file="/commons/messages.jsp" %>

<s:form action="/pages/hotel/TchPre/list.do" method="get" theme="simple">
	<s:hidden name="id" id="id" value="%{model.id}"/>
	<table cellpadding="0" cellspacing="0" border="0" class="tb_all">
	               <tr>
				          <td colspan="4" class="tb_title"> 
							<%=TchPre.TABLE_ALIAS%>
				          </td>
		           </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=TchPre.ALIAS_NAME%>
		                  </td>
			              <td>
		                           <s:property value="%{model.name}" />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=TchPre.ALIAS_SEX%>
		                  </td>
			              <td>
		                            <mytag:write property="%{model.sex}" dictName="T_DIC_SEX"/>
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=TchPre.ALIAS_NATION%>
		                  </td>
			              <td>
		                           <mytag:write property="%{model.nation}" dictName="DIC_ITEM_HOTEL_NATION"/>
		                  </td>
                          <td class="crosscolor_td">
			                      <%=TchPre.ALIAS_BDATE%>
		                  </td>
			              <td>
		                           <s:property value="%{model.bdate}" />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=TchPre.ALIAS_ID_NAME%>
		                  </td>
			              <td>
		                           <mytag:write property="%{model.idName}" dictName="T_ID_NAME"/>
		                  </td>
                          <td class="crosscolor_td">
			                      <%=TchPre.ALIAS_ID_CODE%>
		                  </td>
			              <td>
		                           <s:property value="%{model.idCode}" />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=TchPre.ALIAS_XZQH%>
		                  </td>
			              <td>
		                           <mytag:write property="%{model.xzqh}" dictName="T_DIC_XZQH"/>
		                  </td>
                          <td class="crosscolor_td">
			                      <%=TchPre.ALIAS_ADDRESS%>
		                  </td>
			              <td>
		                           <s:property value="%{model.address}" />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
		           		  <td class="crosscolor_td">
			                      <%=TchPre.ALIAS_HOTELNAME%>
		                  </td>
			              <td>
		                           <a href="${ctx}/pages/hotel/Thotel/show.do?code=${model.hotelid}" ><s:property value="%{model.hotelname}" /></a>
		                  </td>
                          <td class="crosscolor_td">
			                      <%=TchPre.ALIAS_NO_ROOM%>
		                  </td>
			              <td>
		                           <s:property value="%{model.noRoom}" />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=TchPre.ALIAS_IN_TIME%>
		                  </td>
			              <td>
		                           <s:property value="%{model.inTime}" />
		                  </td>		           
                          <td class="crosscolor_td">
			                      <%=TchPre.ALIAS_OUT_TIME%>
		                  </td>
			              <td>
		                           <s:property value="%{model.outTime}" />
		                  </td>

                   </tr>

		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=TchPre.ALIAS_BUR_CODE%>
		                  </td>
			              <td>
		                           <mytag:write property="%{model.burCode}"  dictName="ssfj" />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=TchPre.ALIAS_STA_CODE%>
		                  </td>
			              <td>
		                           <mytag:write property="%{model.staCode}"  dictName="teHangDwbm"/>
		                  </td>
                   </tr>
                   		<tr class="crosscolor_tr">

                   </tr>
                   <tr>
						  <td colspan="4" class="tb_bottom">
						           <input type="button" value="返回" onclick="history.back()"/>
	                      </td>
	               </tr>
	</table>	
</s:form>

</body>

</html>
