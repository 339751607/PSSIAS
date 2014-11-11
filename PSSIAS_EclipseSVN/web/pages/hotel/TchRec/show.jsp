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
	<title><%=TchRec.TABLE_ALIAS%>信息</title>
</head>

<body>
<%@ include file="/commons/messages.jsp" %>

<s:form action="/pages/hotel/TchRec/list.do" method="get" theme="simple">
	<s:hidden name="id" id="id" value="%{model.id}"/>
	<table width="100%" border="1" bordercolor="#7c8ca7" align="center"  cellPadding="0" cellSpacing="0" class="tb_all">
	               <tr>
				          <td colspan="5" class="tb_title"> 
							<%=TchRec.TABLE_ALIAS%>信息
				          </td>
		           </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=TchRec.ALIAS_NAME%>
		                  </td>
			              <td>
		                           <s:property value="%{model.name}" />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=TchRec.ALIAS_SEX%>
		                  </td>
			              <td>
		                            <mytag:write property="%{model.sex}" dictName="T_DIC_SEX"/>
		                  </td>
		                  <td rowspan="7" align="center" width="15%">
		                  <img
							src='${ctx}/pages/hotel/TchPre/showPic.do?id=<s:property value="%{model.id}" />'
							onerror="this.src='${ctx}/images/spacer.gif'"  alt=""
							width="130" height="170"  border="0" name="photo">
		                  </td>				                  
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=TchRec.ALIAS_NATION%>
		                  </td>
			              <td>
		                           <mytag:write property="%{model.nation}" dictName="DIC_ITEM_HOTEL_NATION"/>
		                  </td>
                          <td class="crosscolor_td">
			                      <%=TchRec.ALIAS_BDATE%>
		                  </td>
			              <td>
		                           <s:property value="%{model.bdate}" />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=TchRec.ALIAS_ID_NAME%>
		                  </td>
			              <td>
		                           <mytag:write property="%{model.idName}" dictName="T_ID_NAME"/>
		                  </td>
                          <td class="crosscolor_td">
			                      <%=TchRec.ALIAS_ID_CODE%>
		                  </td>
			              <td>
		                           <s:property value="%{model.idCode}" />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=TchRec.ALIAS_XZQH%>
		                  </td>
			              <td>
		                           <mytag:write property="%{model.xzqh}" dictName="T_DIC_XZQH"/>
		                  </td>
                          <td class="crosscolor_td">
			                      <%=TchRec.ALIAS_ADDRESS%>
		                  </td>
			              <td>
		                           <s:property value="%{model.address}" />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
		           		  <td class="crosscolor_td">
			                      <%=TchRec.ALIAS_HOTELNAME%>
		                  </td>
			              <td>
			              		  <a href="${ctx}/pages/hotel/Thotel/show.do?code=${model.hotelid}" ><s:property value="%{model.hotelname}" /></a>
		                  </td>
                          <td class="crosscolor_td">
			                      <%=TchRec.ALIAS_NO_ROOM%>
		                  </td>
			              <td>
		                           <s:property value="%{model.noRoom}" />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=TchRec.ALIAS_IN_TIME%>
		                  </td>
			              <td>
		                           <s:property value="%{model.inTime}" />
		                  </td>		           
                          <td class="crosscolor_td">
			                      <%=TchRec.ALIAS_OUT_TIME%>
		                  </td>
			              <td>
		                           <s:property value="%{model.outTime}" />
		                  </td>

                   </tr>

		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=TchRec.ALIAS_BUR_CODE%>
		                  </td>
			              <td>
		                           <mytag:write property="%{model.burCode}"  dictName="ssfj" />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=TchRec.ALIAS_STA_CODE%>
		                  </td>
			              <td>
		                           <mytag:write property="%{model.staCode}"  dictName="teHangDwbm"/>
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=TchRec.ALIAS_DAYS%>
		                  </td>
			              <td>
		                           <s:property value="%{model.days}" />
		                  </td>
                          <td class="crosscolor_td">
		                  </td>
			              <td>
		                  </td>
		                  <td></td>
                   </tr>
                   <tr>
						  <td colspan="5" class="tb_bottom">
						           <input type="button" value="返回" onclick="window.location='${ctx}/pages/hotel/TchRec/list.do?<mytag:params includes="ec*,s*" type="queryStringUtf"/>'"/>
	                      </td>
	               </tr>
	</table>	
</s:form>

</body>

</html>
