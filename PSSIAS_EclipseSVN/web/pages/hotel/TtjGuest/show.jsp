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
	<title><%=Thotel.TABLE_ALIAS%>信息</title>
</head>

<body>
<%@ include file="/commons/messages.jsp" %>

<s:form action="/pages/hotel/TtjGuest/list.do" method="get" theme="simple">
	<s:hidden name="code" id="code" value="%{model.code}"/>
	<table cellpadding="0" cellspacing="0" border="0" class="tb_all">
	               <tr>
				          <td colspan="4" class="tb_title"> 
							<%=Thotel.TABLE_ALIAS%>信息
				          </td>
		           </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=Thotel.ALIAS_CALLED%>
		                  </td>
			              <td colspan="3">
		                           <s:property value="%{model.called}" />
		                  </td>
                   </tr>		
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=Thotel.ALIAS_ADDRESS%>
		                  </td>
			              <td>
		                           <s:property value="%{model.address}" />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=Thotel.ALIAS_TEL%>
		                  </td>
			              <td>
		                           <s:property value="%{model.tel}" />
		                  </td>
                   </tr>	           
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=Thotel.ALIAS_BUR_CODE%>
		                  </td>
			              <td>
		                           <mytag:write property="%{model.burCode}"  dictName="ssfj" />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=Thotel.ALIAS_STA_CODE%>
		                  </td>
			              <td>
		                           <mytag:write property="%{model.staCode}"  dictName="teHangDwbm"/>
		                  </td>
                   </tr>	
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=Thotel.ALIAS_LEGAL_PERSON%>
		                  </td>
			              <td>
		                           <s:property value="%{model.legalPerson}" />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=Thotel.ALIAS_MANAGER%>
		                  </td>
			              <td>
		                           <s:property value="%{model.manager}" />
		                  </td>
                   </tr>   
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=Thotel.ALIAS_TEL_LEGAL%>
		                  </td>
			              <td>
		                           <s:property value="%{model.telLegal}" />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=Thotel.ALIAS_POLICE_MANAGER%>
		                  </td>
			              <td>
		                           <s:property value="%{model.policeManager}" />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=Thotel.ALIAS_STATUS%>
		                  </td>
			              <td>
		                           <mytag:write property="%{model.status}"  dictName="DIC_ITEM_HOTEL_STATUS"/>
		                  </td>
                          <td class="crosscolor_td">
			                      <%=Thotel.ALIAS_MOD_TIME%>
		                  </td>
			              <td>
		                           <s:property value="%{model.modTime}" />
		                  </td>
                   </tr>                   
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=Thotel.ALIAS_STAR%>
		                  </td>
			              <td>
		                           <mytag:write property="%{model.star}"  dictName="DIC_ITEM_HOTEL_STAR"/>
		                  </td>
                          <td class="crosscolor_td">
			                      <%=Thotel.ALIAS_GRADE%>
		                  </td>
			              <td>
		                           <mytag:write property="%{model.grade}"  dictName="DIC_ITEM_HOTEL_GRADE"/>
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=Thotel.ALIAS_ROOM_NUM%>
		                  </td>
			              <td>
		                           <s:property value="%{model.roomNum}" />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=Thotel.ALIAS_BED_NUM%>
		                  </td>
			              <td>
		                           <s:property value="%{model.bedNum}" />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=Thotel.ALIAS_POLICE_TEL%>
		                  </td>
			              <td>
		                           <s:property value="%{model.policeTel}" />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=Thotel.ALIAS_POLICEMEN%>
		                  </td>
			              <td>
		                           <s:property value="%{model.policemen}" />
		                  </td>
                   </tr>   
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=Thotel.ALIAS_WORKMEN%>
		                  </td>
			              <td>
		                           <s:property value="%{model.workmen}" />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=Thotel.ALIAS_OTHERPLACEMEN%>
		                  </td>
			              <td>
		                           <s:property value="%{model.otherplacemen}" />
		                  </td>
                   </tr>                                   
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=Thotel.ALIAS_SPECIAL_LICENCE%>
		                  </td>
			              <td>
		                           <s:property value="%{model.specialLicence}" />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=Thotel.ALIAS_POLICE_LICENCE%>
		                  </td>
			              <td>
		                           <s:property value="%{model.policeLicence}" />
		                  </td>
                   </tr>                   
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=Thotel.ALIAS_SUITROOMS%>
		                  </td>
			              <td>
		                           <s:property value="%{model.suitrooms}" />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=Thotel.ALIAS_STANDARDROOMS%>
		                  </td>
			              <td>
		                           <s:property value="%{model.standardrooms}" />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=Thotel.ALIAS_DOUBLEROOMS%>
		                  </td>
			              <td>
		                           <s:property value="%{model.doublerooms}" />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=Thotel.ALIAS_SINGLEROOMS%>
		                  </td>
			              <td>
		                           <s:property value="%{model.singlerooms}" />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=Thotel.ALIAS_OTHERROOMS%>
		                  </td>
			              <td>
		                           <s:property value="%{model.otherrooms}" />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=Thotel.ALIAS_MONITOR_CONTROL%>
		                  </td>
			              <td>
		                           <s:property value="%{model.monitorControl}" />
		                  </td>
                   </tr>

		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=Thotel.ALIAS_COFFER%>
		                  </td>
			              <td>
		                           <s:property value="%{model.coffer}" />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=Thotel.ALIAS_TECH_DEFEND%>
		                  </td>
			              <td>
		                           <s:property value="%{model.techDefend}" />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=Thotel.ALIAS_THING_DEFEND%>
		                  </td>
			              <td>
		                           <s:property value="%{model.thingDefend}" />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=Thotel.ALIAS_KTV%>
		                  </td>
			              <td>
		                           <s:property value="%{model.ktv}" />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=Thotel.ALIAS_CHESSROOM%>
		                  </td>
			              <td>
		                           <s:property value="%{model.chessroom}" />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=Thotel.ALIAS_COMMERCE%>
		                  </td>
			              <td>
		                           <s:property value="%{model.commerce}" />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=Thotel.ALIAS_SAUNA%>
		                  </td>
			              <td>
		                           <s:property value="%{model.sauna}" />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=Thotel.ALIAS_BOWLING%>
		                  </td>
			              <td>
		                           <s:property value="%{model.bowling}" />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=Thotel.ALIAS_GAMEROOM%>
		                  </td>
			              <td>
		                           <s:property value="%{model.gameroom}" />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=Thotel.ALIAS_LOCKTYPE%>
		                  </td>
			              <td>
		                           <s:property value="%{model.locktype}" />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=Thotel.ALIAS_LOCKNAME%>
		                  </td>
			              <td>
		                           <s:property value="%{model.lockname}" />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=Thotel.ALIAS_BASICREMARK%>
		                  </td>
			              <td>
		                           <s:property value="%{model.basicremark}" />
		                  </td>
                   </tr>
                   <tr><td colspan="4" class="tb_title2">KTV舞厅情况</td></tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=Thotel.ALIAS_KTV_ROOMS%>
		                  </td>
			              <td>
		                           <s:property value="%{model.ktvRooms}" />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=Thotel.ALIAS_KTV_MEN%>
		                  </td>
			              <td>
		                           <s:property value="%{model.ktvMen}" />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=Thotel.ALIAS_KTV_LICENCE%>
		                  </td>
			              <td>
		                           <s:property value="%{model.ktvLicence}" />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=Thotel.ALIAS_KTV_FIREPROOFING%>
		                  </td>
			              <td>
		                           <s:property value="%{model.ktvFireproofing}" />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=Thotel.ALIAS_KTV_MONITOR_CONTROL%>
		                  </td>
			              <td>
		                           <s:property value="%{model.ktvMonitorControl}" />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=Thotel.ALIAS_KTV_CONTRACTOR%>
		                  </td>
			              <td>
		                           <s:property value="%{model.ktvContractor}" />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=Thotel.ALIAS_KTV_NAME%>
		                  </td>
			              <td>
		                           <s:property value="%{model.ktvName}" />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=Thotel.ALIAS_KTV_TEL%>
		                  </td>
			              <td>
		                           <s:property value="%{model.ktvTel}" />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=Thotel.ALIAS_KTV_ID%>
		                  </td>
			              <td>
		                           <s:property value="%{model.ktvId}" />
		                  </td>
						  <td></td>
						  <td></td>
                   </tr>
                   <tr><td colspan="4" class="tb_title2">棋牌室情况</td></tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=Thotel.ALIAS_CHESS_BOXES%>
		                  </td>
			              <td>
		                           <s:property value="%{model.chessBoxes}" />
		                  </td>		           
                          <td class="crosscolor_td">
			                      <%=Thotel.ALIAS_CHESS_FIREPROOFING%>
		                  </td>
			              <td>
		                           <s:property value="%{model.chessFireproofing}" />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=Thotel.ALIAS_CHESS_CONTRACTOR%>
		                  </td>
			              <td>
		                           <s:property value="%{model.chessContractor}" />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=Thotel.ALIAS_CHESS_NAME%>
		                  </td>
			              <td>
		                           <s:property value="%{model.chessName}" />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=Thotel.ALIAS_CHESS_TEL%>
		                  </td>
			              <td>
		                           <s:property value="%{model.chessTel}" />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=Thotel.ALIAS_CHESS_ID%>
		                  </td>
			              <td>
		                           <s:property value="%{model.chessId}" />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=Thotel.ALIAS_CHESS_MONITOR_CONTROL%>
		                  </td>
			              <td>
		                           <s:property value="%{model.chessMonitorControl}" />
		                  </td>
		                  <td></td>
		                  <td></td>
                   </tr>
                   <tr><td colspan="4" class="tb_title2">商务中心情况</td></tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=Thotel.ALIAS_COMMERCE_COPY%>
		                  </td>
			              <td>
		                           <s:property value="%{model.commerceCopy}" />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=Thotel.ALIAS_COMMERCE_FAX%>
		                  </td>
			              <td>
		                           <s:property value="%{model.commerceFax}" />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=Thotel.ALIAS_COMMERCE_TYPED%>
		                  </td>
			              <td>
		                           <s:property value="%{model.commerceTyped}" />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=Thotel.ALIAS_COMMERCE_TICKET%>
		                  </td>
			              <td>
		                           <s:property value="%{model.commerceTicket}" />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=Thotel.ALIAS_COMMERCE_CONTRACTOR%>
		                  </td>
			              <td>
		                           <s:property value="%{model.commerceContractor}" />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=Thotel.ALIAS_COMMERCE_NAME%>
		                  </td>
			              <td>
		                           <s:property value="%{model.commerceName}" />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=Thotel.ALIAS_COMMERCE_TEL%>
		                  </td>
			              <td>
		                           <s:property value="%{model.commerceTel}" />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=Thotel.ALIAS_COMMERCE_ID%>
		                  </td>
			              <td>
		                           <s:property value="%{model.commerceId}" />
		                  </td>
                   </tr>
                   <tr><td colspan="4" class="tb_title2">桑拿按摩间情况</td></tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=Thotel.ALIAS_SAUNA_KNEAD%>
		                  </td>
			              <td>
		                           <s:property value="%{model.saunaKnead}" />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=Thotel.ALIAS_SAUNA_ROOMS%>
		                  </td>
			              <td>
		                           <s:property value="%{model.saunaRooms}" />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=Thotel.ALIAS_SAUNA_WORKMEN%>
		                  </td>
			              <td>
		                           <s:property value="%{model.saunaWorkmen}" />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=Thotel.ALIAS_SAUNA_CONTRACTOR%>
		                  </td>
			              <td>
		                           <s:property value="%{model.saunaContractor}" />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=Thotel.ALIAS_SAUNA_NAME%>
		                  </td>
			              <td>
		                           <s:property value="%{model.saunaName}" />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=Thotel.ALIAS_SAUNA_TEL%>
		                  </td>
			              <td>
		                           <s:property value="%{model.saunaTel}" />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=Thotel.ALIAS_SAUNA_ID%>
		                  </td>
			              <td>
		                           <s:property value="%{model.saunaId}" />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=Thotel.ALIAS_OTHERREMARK%>
		                  </td>
			              <td>
		                           <s:property value="%{model.otherremark}" />
		                  </td>
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
