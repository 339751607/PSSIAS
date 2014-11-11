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
	<title><%=Thotel.TABLE_ALIAS%>查询</title>
</head>

<body>
<%@ include file="/commons/messages.jsp" %>
<div class="queryPanel">
    <s:form action="/pages/hotel/TtjGuest/list.do"  theme="simple" style="display: inline;" method="post">
	    <table cellpadding="0" cellspacing="0" border="0" class="tb_all">
	               <tr>
			              <td class="tb_title" colspan="4"><%=Thotel.TABLE_ALIAS%>查询</td>
		           </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=Thotel.ALIAS_YWJK%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.ywjk}"  name="s_ywjk"  />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=Thotel.ALIAS_FJBXX%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.fjbxx}"  name="s_fjbxx"  />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=Thotel.ALIAS_KTVWT%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.ktvwt}"  name="s_ktvwt"  />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=Thotel.ALIAS_FSCG%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.fscg}"  name="s_fscg"  />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=Thotel.ALIAS_SWZX%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.swzx}"  name="s_swzx"  />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=Thotel.ALIAS_SNF%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.snf}"  name="s_snf"  />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=Thotel.ALIAS_BLQG%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.blqg}"  name="s_blqg"  />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=Thotel.ALIAS_YXJF%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.yxjf}"  name="s_yxjf"  />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=Thotel.ALIAS_RZBZ%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.rzbz}"  name="s_rzbz"  />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=Thotel.ALIAS_LEGAL_SFZH%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.legalSfzh}"  name="s_legalSfzh"  />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=Thotel.ALIAS_I_CODE%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.icode}"  name="s_icode"  />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=Thotel.ALIAS_SPECIAL_TIME%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.specialTime}"  name="s_specialTime"  />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=Thotel.ALIAS_SPECIAL_UNIT%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.specialUnit}"  name="s_specialUnit"  />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=Thotel.ALIAS_TRANSFLAG%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.transflag}"  name="s_transflag"  />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=Thotel.ALIAS_CITY_CODE%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.cityCode}"  name="s_cityCode"  />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=Thotel.ALIAS_OLD_CODE%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.oldCode}"  name="s_oldCode"  />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=Thotel.ALIAS_NEW_CODE%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.newCode}"  name="s_newCode"  />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=Thotel.ALIAS_LGSYZ%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.lgsyz}"  name="s_lgsyz"  />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=Thotel.ALIAS_LGZL%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.lgzl}"  name="s_lgzl"  />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=Thotel.ALIAS_LGWZ%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.lgwz}"  name="s_lgwz"  />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=Thotel.ALIAS_CARDTYPE%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.cardtype}"  name="s_cardtype"  />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=Thotel.ALIAS_CALLED%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.called}"  name="s_called"  />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=Thotel.ALIAS_AREA_CODE%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.areaCode}"  name="s_areaCode"  />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=Thotel.ALIAS_ZRMJ%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.zrmj}"  name="s_zrmj"  />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=Thotel.ALIAS_STA_CODE%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.staCode}"  name="s_staCode"  />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=Thotel.ALIAS_BUR_CODE%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.burCode}"  name="s_burCode"  />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=Thotel.ALIAS_LEGAL_PERSON%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.legalPerson}"  name="s_legalPerson"  />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=Thotel.ALIAS_MANAGER%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.manager}"  name="s_manager"  />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=Thotel.ALIAS_TEL_LEGAL%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.telLegal}"  name="s_telLegal"  />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=Thotel.ALIAS_POLICE_MANAGER%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.policeManager}"  name="s_policeManager"  />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=Thotel.ALIAS_ADDRESS%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.address}"  name="s_address"  />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=Thotel.ALIAS_TEL%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.tel}"  name="s_tel"  />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=Thotel.ALIAS_POLICE_TEL%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.policeTel}"  name="s_policeTel"  />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=Thotel.ALIAS_POLICEMEN%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.policemen}"  name="s_policemen"  />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=Thotel.ALIAS_STATUS%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.status}"  name="s_status"  />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=Thotel.ALIAS_MOD_TIME%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.modTime}"  name="s_modTime"  />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=Thotel.ALIAS_ROOM_NUM%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.roomNum}"  name="s_roomNum"  />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=Thotel.ALIAS_BED_NUM%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.bedNum}"  name="s_bedNum"  />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=Thotel.ALIAS_STAR%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.star}"  name="s_star"  />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=Thotel.ALIAS_GRADE%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.grade}"  name="s_grade"  />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=Thotel.ALIAS_SPECIAL_LICENCE%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.specialLicence}"  name="s_specialLicence"  />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=Thotel.ALIAS_POLICE_LICENCE%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.policeLicence}"  name="s_policeLicence"  />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=Thotel.ALIAS_SUITROOMS%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.suitrooms}"  name="s_suitrooms"  />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=Thotel.ALIAS_STANDARDROOMS%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.standardrooms}"  name="s_standardrooms"  />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=Thotel.ALIAS_DOUBLEROOMS%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.doublerooms}"  name="s_doublerooms"  />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=Thotel.ALIAS_SINGLEROOMS%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.singlerooms}"  name="s_singlerooms"  />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=Thotel.ALIAS_OTHERROOMS%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.otherrooms}"  name="s_otherrooms"  />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=Thotel.ALIAS_WORKMEN%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.workmen}"  name="s_workmen"  />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=Thotel.ALIAS_OTHERPLACEMEN%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.otherplacemen}"  name="s_otherplacemen"  />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=Thotel.ALIAS_MONITOR_CONTROL%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.monitorControl}"  name="s_monitorControl"  />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=Thotel.ALIAS_COFFER%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.coffer}"  name="s_coffer"  />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=Thotel.ALIAS_TECH_DEFEND%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.techDefend}"  name="s_techDefend"  />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=Thotel.ALIAS_THING_DEFEND%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.thingDefend}"  name="s_thingDefend"  />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=Thotel.ALIAS_KTV%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.ktv}"  name="s_ktv"  />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=Thotel.ALIAS_CHESSROOM%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.chessroom}"  name="s_chessroom"  />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=Thotel.ALIAS_COMMERCE%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.commerce}"  name="s_commerce"  />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=Thotel.ALIAS_SAUNA%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.sauna}"  name="s_sauna"  />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=Thotel.ALIAS_BOWLING%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.bowling}"  name="s_bowling"  />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=Thotel.ALIAS_GAMEROOM%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.gameroom}"  name="s_gameroom"  />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=Thotel.ALIAS_LOCKTYPE%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.locktype}"  name="s_locktype"  />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=Thotel.ALIAS_LOCKNAME%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.lockname}"  name="s_lockname"  />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=Thotel.ALIAS_BASICREMARK%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.basicremark}"  name="s_basicremark"  />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=Thotel.ALIAS_KTV_ROOMS%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.ktvRooms}"  name="s_ktvRooms"  />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=Thotel.ALIAS_KTV_MEN%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.ktvMen}"  name="s_ktvMen"  />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=Thotel.ALIAS_KTV_LICENCE%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.ktvLicence}"  name="s_ktvLicence"  />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=Thotel.ALIAS_KTV_FIREPROOFING%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.ktvFireproofing}"  name="s_ktvFireproofing"  />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=Thotel.ALIAS_KTV_MONITOR_CONTROL%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.ktvMonitorControl}"  name="s_ktvMonitorControl"  />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=Thotel.ALIAS_KTV_CONTRACTOR%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.ktvContractor}"  name="s_ktvContractor"  />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=Thotel.ALIAS_KTV_NAME%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.ktvName}"  name="s_ktvName"  />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=Thotel.ALIAS_KTV_TEL%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.ktvTel}"  name="s_ktvTel"  />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=Thotel.ALIAS_KTV_ID%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.ktvId}"  name="s_ktvId"  />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=Thotel.ALIAS_CHESS_BOXES%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.chessBoxes}"  name="s_chessBoxes"  />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=Thotel.ALIAS_CHESS_FIREPROOFING%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.chessFireproofing}"  name="s_chessFireproofing"  />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=Thotel.ALIAS_CHESS_MONITOR_CONTROL%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.chessMonitorControl}"  name="s_chessMonitorControl"  />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=Thotel.ALIAS_CHESS_CONTRACTOR%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.chessContractor}"  name="s_chessContractor"  />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=Thotel.ALIAS_CHESS_NAME%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.chessName}"  name="s_chessName"  />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=Thotel.ALIAS_CHESS_TEL%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.chessTel}"  name="s_chessTel"  />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=Thotel.ALIAS_CHESS_ID%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.chessId}"  name="s_chessId"  />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=Thotel.ALIAS_COMMERCE_COPY%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.commerceCopy}"  name="s_commerceCopy"  />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=Thotel.ALIAS_COMMERCE_FAX%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.commerceFax}"  name="s_commerceFax"  />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=Thotel.ALIAS_COMMERCE_TYPED%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.commerceTyped}"  name="s_commerceTyped"  />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=Thotel.ALIAS_COMMERCE_TICKET%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.commerceTicket}"  name="s_commerceTicket"  />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=Thotel.ALIAS_COMMERCE_CONTRACTOR%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.commerceContractor}"  name="s_commerceContractor"  />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=Thotel.ALIAS_COMMERCE_NAME%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.commerceName}"  name="s_commerceName"  />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=Thotel.ALIAS_COMMERCE_TEL%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.commerceTel}"  name="s_commerceTel"  />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=Thotel.ALIAS_COMMERCE_ID%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.commerceId}"  name="s_commerceId"  />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=Thotel.ALIAS_SAUNA_KNEAD%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.saunaKnead}"  name="s_saunaKnead"  />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=Thotel.ALIAS_SAUNA_ROOMS%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.saunaRooms}"  name="s_saunaRooms"  />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=Thotel.ALIAS_SAUNA_WORKMEN%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.saunaWorkmen}"  name="s_saunaWorkmen"  />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=Thotel.ALIAS_SAUNA_CONTRACTOR%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.saunaContractor}"  name="s_saunaContractor"  />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=Thotel.ALIAS_SAUNA_NAME%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.saunaName}"  name="s_saunaName"  />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=Thotel.ALIAS_SAUNA_TEL%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.saunaTel}"  name="s_saunaTel"  />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=Thotel.ALIAS_SAUNA_ID%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.saunaId}"  name="s_saunaId"  />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=Thotel.ALIAS_OTHERREMARK%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.otherremark}"  name="s_otherremark"  />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=Thotel.ALIAS_DEVICE_TYPE%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.deviceType}"  name="s_deviceType"  />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=Thotel.ALIAS_BA_TIME%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.baTime}"  name="s_baTime"  />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=Thotel.ALIAS_FRONT_MANAGER%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.frontManager}"  name="s_frontManager"  />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=Thotel.ALIAS_FRDH%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.frdh}"  name="s_frdh"  />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=Thotel.ALIAS_LGXZ%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.lgxz}"  name="s_lgxz"  />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=Thotel.ALIAS_TZHYXKZH%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.tzhyxkzh}"  name="s_tzhyxkzh"  />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=Thotel.ALIAS_ZAXKZH%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.zaxkzh}"  name="s_zaxkzh"  />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=Thotel.ALIAS_TFS%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.tfs}"  name="s_tfs"  />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=Thotel.ALIAS_BZFS%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.bzfs}"  name="s_bzfs"  />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=Thotel.ALIAS_SRFS%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.srfs}"  name="s_srfs"  />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=Thotel.ALIAS_DRFS%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.drfs}"  name="s_drfs"  />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=Thotel.ALIAS_QTFS%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.qtfs}"  name="s_qtfs"  />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=Thotel.ALIAS_RYZS%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.ryzs}"  name="s_ryzs"  />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=Thotel.ALIAS_DGRS%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.dgrs}"  name="s_dgrs"  />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=Thotel.ALIAS_MS%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.ms}"  name="s_ms"  />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=Thotel.ALIAS_WFHG%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.wfhg}"  name="s_wfhg"  />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=Thotel.ALIAS_JFHG%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.jfhg}"  name="s_jfhg"  />
		                  </td>
                          <td>&nbsp;</td>
                          <td>&nbsp;</td>
                   </tr>
		           <tr>
			              <td class="tb_bottom" colspan="4">
			                       <input type="submit"  value="查询" onclick="getReferenceForm(this).action='${ctx}/pages/hotel/TtjGuest/list.do'"/>
	                               <input type="submit"  value="新增" onclick="getReferenceForm(this).action='${ctx}/pages/hotel/TtjGuest/create.do?<mytag:params includes="ec*,s*" type="queryStringUtf"/>'"/>
			              </td>
		           </tr>
	    </table>
    </s:form>
</div>
			
</body>

</html>
