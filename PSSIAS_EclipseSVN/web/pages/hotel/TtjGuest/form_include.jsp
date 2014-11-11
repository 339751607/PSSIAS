<%@page import="com.dyneinfo.hotel.model.*" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/commons/taglibs.jsp" %>

	<s:hidden id="code" name="code" />

<!-- ONGL access static field: @package.class@field or @vs@field -->

		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=Thotel.ALIAS_YWJK%>
		                  </td>
			              <td>
		                           <s:textfield label="%{@vs@ALIAS_YWJK}" key="ywjk" value="%{model.ywjk}"  cssClass="max-length-1" required="false" />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=Thotel.ALIAS_FJBXX%>
		                  </td>
			              <td>
		                           <s:textfield label="%{@vs@ALIAS_FJBXX}" key="fjbxx" value="%{model.fjbxx}"  cssClass="max-length-1" required="false" />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=Thotel.ALIAS_KTVWT%>
		                  </td>
			              <td>
		                           <s:textfield label="%{@vs@ALIAS_KTVWT}" key="ktvwt" value="%{model.ktvwt}"  cssClass="max-length-1" required="false" />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=Thotel.ALIAS_FSCG%>
		                  </td>
			              <td>
		                           <s:textfield label="%{@vs@ALIAS_FSCG}" key="fscg" value="%{model.fscg}"  cssClass="max-length-1" required="false" />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=Thotel.ALIAS_SWZX%>
		                  </td>
			              <td>
		                           <s:textfield label="%{@vs@ALIAS_SWZX}" key="swzx" value="%{model.swzx}"  cssClass="max-length-1" required="false" />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=Thotel.ALIAS_SNF%>
		                  </td>
			              <td>
		                           <s:textfield label="%{@vs@ALIAS_SNF}" key="snf" value="%{model.snf}"  cssClass="max-length-1" required="false" />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=Thotel.ALIAS_BLQG%>
		                  </td>
			              <td>
		                           <s:textfield label="%{@vs@ALIAS_BLQG}" key="blqg" value="%{model.blqg}"  cssClass="max-length-1" required="false" />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=Thotel.ALIAS_YXJF%>
		                  </td>
			              <td>
		                           <s:textfield label="%{@vs@ALIAS_YXJF}" key="yxjf" value="%{model.yxjf}"  cssClass="max-length-1" required="false" />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=Thotel.ALIAS_RZBZ%>
		                  </td>
			              <td>
		                           <s:textfield label="%{@vs@ALIAS_RZBZ}" key="rzbz" value="%{model.rzbz}"  cssClass="validate-number " required="false" />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=Thotel.ALIAS_LEGAL_SFZH%>
		                  </td>
			              <td>
		                           <s:textfield label="%{@vs@ALIAS_LEGAL_SFZH}" key="legalSfzh" value="%{model.legalSfzh}"  cssClass="max-length-18" required="false" />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <FONT color="red">*</FONT><%=Thotel.ALIAS_I_CODE%>
		                  </td>
			              <td>
		                           <s:textfield label="%{@vs@ALIAS_I_CODE}" key="icode" value="%{model.icode}"  cssClass="required max-length-6" required="true" />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=Thotel.ALIAS_SPECIAL_TIME%>
		                  </td>
			              <td>
		                           <s:textfield label="%{@vs@ALIAS_SPECIAL_TIME}" key="specialTime" value="%{model.specialTime}"  cssClass="max-length-8" required="false" />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=Thotel.ALIAS_SPECIAL_UNIT%>
		                  </td>
			              <td>
		                           <s:textfield label="%{@vs@ALIAS_SPECIAL_UNIT}" key="specialUnit" value="%{model.specialUnit}"  cssClass="max-length-100" required="false" />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=Thotel.ALIAS_TRANSFLAG%>
		                  </td>
			              <td>
		                           <s:textfield label="%{@vs@ALIAS_TRANSFLAG}" key="transflag" value="%{model.transflag}"  cssClass="validate-number " required="false" />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=Thotel.ALIAS_CITY_CODE%>
		                  </td>
			              <td>
		                           <s:textfield label="%{@vs@ALIAS_CITY_CODE}" key="cityCode" value="%{model.cityCode}"  cssClass="max-length-12" required="false" />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=Thotel.ALIAS_OLD_CODE%>
		                  </td>
			              <td>
		                           <s:textfield label="%{@vs@ALIAS_OLD_CODE}" key="oldCode" value="%{model.oldCode}"  cssClass="max-length-10" required="false" />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=Thotel.ALIAS_NEW_CODE%>
		                  </td>
			              <td>
		                           <s:textfield label="%{@vs@ALIAS_NEW_CODE}" key="newCode" value="%{model.newCode}"  cssClass="max-length-10" required="false" />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=Thotel.ALIAS_LGSYZ%>
		                  </td>
			              <td>
		                           <s:textfield label="%{@vs@ALIAS_LGSYZ}" key="lgsyz" value="%{model.lgsyz}"  cssClass="max-length-2" required="false" />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=Thotel.ALIAS_LGZL%>
		                  </td>
			              <td>
		                           <s:textfield label="%{@vs@ALIAS_LGZL}" key="lgzl" value="%{model.lgzl}"  cssClass="max-length-2" required="false" />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=Thotel.ALIAS_LGWZ%>
		                  </td>
			              <td>
		                           <s:textfield label="%{@vs@ALIAS_LGWZ}" key="lgwz" value="%{model.lgwz}"  cssClass="max-length-2" required="false" />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=Thotel.ALIAS_CARDTYPE%>
		                  </td>
			              <td>
		                           <s:textfield label="%{@vs@ALIAS_CARDTYPE}" key="cardtype" value="%{model.cardtype}"  cssClass="max-length-2" required="false" />
		                  </td>
                          <td class="crosscolor_td">
			                      <FONT color="red">*</FONT><%=Thotel.ALIAS_CALLED%>
		                  </td>
			              <td>
		                           <s:textfield label="%{@vs@ALIAS_CALLED}" key="called" value="%{model.called}"  cssClass="required max-length-40" required="true" />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=Thotel.ALIAS_AREA_CODE%>
		                  </td>
			              <td>
		                           <s:textfield label="%{@vs@ALIAS_AREA_CODE}" key="areaCode" value="%{model.areaCode}"  cssClass="max-length-14" required="false" />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=Thotel.ALIAS_ZRMJ%>
		                  </td>
			              <td>
		                           <s:textfield label="%{@vs@ALIAS_ZRMJ}" key="zrmj" value="%{model.zrmj}"  cssClass="max-length-60" required="false" />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=Thotel.ALIAS_STA_CODE%>
		                  </td>
			              <td>
		                           <s:textfield label="%{@vs@ALIAS_STA_CODE}" key="staCode" value="%{model.staCode}"  cssClass="max-length-12" required="false" />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=Thotel.ALIAS_BUR_CODE%>
		                  </td>
			              <td>
		                           <s:textfield label="%{@vs@ALIAS_BUR_CODE}" key="burCode" value="%{model.burCode}"  cssClass="max-length-12" required="false" />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=Thotel.ALIAS_LEGAL_PERSON%>
		                  </td>
			              <td>
		                           <s:textfield label="%{@vs@ALIAS_LEGAL_PERSON}" key="legalPerson" value="%{model.legalPerson}"  cssClass="max-length-30" required="false" />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=Thotel.ALIAS_MANAGER%>
		                  </td>
			              <td>
		                           <s:textfield label="%{@vs@ALIAS_MANAGER}" key="manager" value="%{model.manager}"  cssClass="max-length-30" required="false" />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=Thotel.ALIAS_TEL_LEGAL%>
		                  </td>
			              <td>
		                           <s:textfield label="%{@vs@ALIAS_TEL_LEGAL}" key="telLegal" value="%{model.telLegal}"  cssClass="max-length-16" required="false" />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=Thotel.ALIAS_POLICE_MANAGER%>
		                  </td>
			              <td>
		                           <s:textfield label="%{@vs@ALIAS_POLICE_MANAGER}" key="policeManager" value="%{model.policeManager}"  cssClass="max-length-30" required="false" />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=Thotel.ALIAS_ADDRESS%>
		                  </td>
			              <td>
		                           <s:textfield label="%{@vs@ALIAS_ADDRESS}" key="address" value="%{model.address}"  cssClass="max-length-100" required="false" />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=Thotel.ALIAS_TEL%>
		                  </td>
			              <td>
		                           <s:textfield label="%{@vs@ALIAS_TEL}" key="tel" value="%{model.tel}"  cssClass="max-length-16" required="false" />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=Thotel.ALIAS_POLICE_TEL%>
		                  </td>
			              <td>
		                           <s:textfield label="%{@vs@ALIAS_POLICE_TEL}" key="policeTel" value="%{model.policeTel}"  cssClass="max-length-16" required="false" />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=Thotel.ALIAS_POLICEMEN%>
		                  </td>
			              <td>
		                           <s:textfield label="%{@vs@ALIAS_POLICEMEN}" key="policemen" value="%{model.policemen}"  cssClass="max-length-3" required="false" />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=Thotel.ALIAS_STATUS%>
		                  </td>
			              <td>
		                           <s:textfield label="%{@vs@ALIAS_STATUS}" key="status" value="%{model.status}"  cssClass="max-length-1" required="false" />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=Thotel.ALIAS_MOD_TIME%>
		                  </td>
			              <td>
		                           <s:textfield label="%{@vs@ALIAS_MOD_TIME}" key="modTime" value="%{model.modTime}"  cssClass="max-length-8" required="false" />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=Thotel.ALIAS_ROOM_NUM%>
		                  </td>
			              <td>
		                           <s:textfield label="%{@vs@ALIAS_ROOM_NUM}" key="roomNum" value="%{model.roomNum}"  cssClass="max-length-4" required="false" />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=Thotel.ALIAS_BED_NUM%>
		                  </td>
			              <td>
		                           <s:textfield label="%{@vs@ALIAS_BED_NUM}" key="bedNum" value="%{model.bedNum}"  cssClass="max-length-4" required="false" />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=Thotel.ALIAS_STAR%>
		                  </td>
			              <td>
		                           <s:textfield label="%{@vs@ALIAS_STAR}" key="star" value="%{model.star}"  cssClass="max-length-1" required="false" />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=Thotel.ALIAS_GRADE%>
		                  </td>
			              <td>
		                           <s:textfield label="%{@vs@ALIAS_GRADE}" key="grade" value="%{model.grade}"  cssClass="max-length-1" required="false" />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=Thotel.ALIAS_SPECIAL_LICENCE%>
		                  </td>
			              <td>
		                           <s:textfield label="%{@vs@ALIAS_SPECIAL_LICENCE}" key="specialLicence" value="%{model.specialLicence}"  cssClass="max-length-30" required="false" />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=Thotel.ALIAS_POLICE_LICENCE%>
		                  </td>
			              <td>
		                           <s:textfield label="%{@vs@ALIAS_POLICE_LICENCE}" key="policeLicence" value="%{model.policeLicence}"  cssClass="max-length-30" required="false" />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=Thotel.ALIAS_SUITROOMS%>
		                  </td>
			              <td>
		                           <s:textfield label="%{@vs@ALIAS_SUITROOMS}" key="suitrooms" value="%{model.suitrooms}"  cssClass="max-length-3" required="false" />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=Thotel.ALIAS_STANDARDROOMS%>
		                  </td>
			              <td>
		                           <s:textfield label="%{@vs@ALIAS_STANDARDROOMS}" key="standardrooms" value="%{model.standardrooms}"  cssClass="max-length-3" required="false" />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=Thotel.ALIAS_DOUBLEROOMS%>
		                  </td>
			              <td>
		                           <s:textfield label="%{@vs@ALIAS_DOUBLEROOMS}" key="doublerooms" value="%{model.doublerooms}"  cssClass="max-length-3" required="false" />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=Thotel.ALIAS_SINGLEROOMS%>
		                  </td>
			              <td>
		                           <s:textfield label="%{@vs@ALIAS_SINGLEROOMS}" key="singlerooms" value="%{model.singlerooms}"  cssClass="max-length-3" required="false" />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=Thotel.ALIAS_OTHERROOMS%>
		                  </td>
			              <td>
		                           <s:textfield label="%{@vs@ALIAS_OTHERROOMS}" key="otherrooms" value="%{model.otherrooms}"  cssClass="max-length-3" required="false" />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=Thotel.ALIAS_WORKMEN%>
		                  </td>
			              <td>
		                           <s:textfield label="%{@vs@ALIAS_WORKMEN}" key="workmen" value="%{model.workmen}"  cssClass="max-length-4" required="false" />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=Thotel.ALIAS_OTHERPLACEMEN%>
		                  </td>
			              <td>
		                           <s:textfield label="%{@vs@ALIAS_OTHERPLACEMEN}" key="otherplacemen" value="%{model.otherplacemen}"  cssClass="max-length-4" required="false" />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=Thotel.ALIAS_MONITOR_CONTROL%>
		                  </td>
			              <td>
		                           <s:textfield label="%{@vs@ALIAS_MONITOR_CONTROL}" key="monitorControl" value="%{model.monitorControl}"  cssClass="max-length-2" required="false" />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=Thotel.ALIAS_COFFER%>
		                  </td>
			              <td>
		                           <s:textfield label="%{@vs@ALIAS_COFFER}" key="coffer" value="%{model.coffer}"  cssClass="max-length-2" required="false" />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=Thotel.ALIAS_TECH_DEFEND%>
		                  </td>
			              <td>
		                           <s:textfield label="%{@vs@ALIAS_TECH_DEFEND}" key="techDefend" value="%{model.techDefend}"  cssClass="max-length-2" required="false" />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=Thotel.ALIAS_THING_DEFEND%>
		                  </td>
			              <td>
		                           <s:textfield label="%{@vs@ALIAS_THING_DEFEND}" key="thingDefend" value="%{model.thingDefend}"  cssClass="max-length-2" required="false" />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=Thotel.ALIAS_KTV%>
		                  </td>
			              <td>
		                           <s:textfield label="%{@vs@ALIAS_KTV}" key="ktv" value="%{model.ktv}"  cssClass="max-length-2" required="false" />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=Thotel.ALIAS_CHESSROOM%>
		                  </td>
			              <td>
		                           <s:textfield label="%{@vs@ALIAS_CHESSROOM}" key="chessroom" value="%{model.chessroom}"  cssClass="max-length-2" required="false" />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=Thotel.ALIAS_COMMERCE%>
		                  </td>
			              <td>
		                           <s:textfield label="%{@vs@ALIAS_COMMERCE}" key="commerce" value="%{model.commerce}"  cssClass="max-length-2" required="false" />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=Thotel.ALIAS_SAUNA%>
		                  </td>
			              <td>
		                           <s:textfield label="%{@vs@ALIAS_SAUNA}" key="sauna" value="%{model.sauna}"  cssClass="max-length-2" required="false" />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=Thotel.ALIAS_BOWLING%>
		                  </td>
			              <td>
		                           <s:textfield label="%{@vs@ALIAS_BOWLING}" key="bowling" value="%{model.bowling}"  cssClass="max-length-2" required="false" />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=Thotel.ALIAS_GAMEROOM%>
		                  </td>
			              <td>
		                           <s:textfield label="%{@vs@ALIAS_GAMEROOM}" key="gameroom" value="%{model.gameroom}"  cssClass="max-length-2" required="false" />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=Thotel.ALIAS_LOCKTYPE%>
		                  </td>
			              <td>
		                           <s:textfield label="%{@vs@ALIAS_LOCKTYPE}" key="locktype" value="%{model.locktype}"  cssClass="max-length-6" required="false" />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=Thotel.ALIAS_LOCKNAME%>
		                  </td>
			              <td>
		                           <s:textfield label="%{@vs@ALIAS_LOCKNAME}" key="lockname" value="%{model.lockname}"  cssClass="max-length-10" required="false" />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=Thotel.ALIAS_BASICREMARK%>
		                  </td>
			              <td>
		                           <s:textfield label="%{@vs@ALIAS_BASICREMARK}" key="basicremark" value="%{model.basicremark}"  cssClass="max-length-100" required="false" />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=Thotel.ALIAS_KTV_ROOMS%>
		                  </td>
			              <td>
		                           <s:textfield label="%{@vs@ALIAS_KTV_ROOMS}" key="ktvRooms" value="%{model.ktvRooms}"  cssClass="max-length-3" required="false" />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=Thotel.ALIAS_KTV_MEN%>
		                  </td>
			              <td>
		                           <s:textfield label="%{@vs@ALIAS_KTV_MEN}" key="ktvMen" value="%{model.ktvMen}"  cssClass="max-length-3" required="false" />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=Thotel.ALIAS_KTV_LICENCE%>
		                  </td>
			              <td>
		                           <s:textfield label="%{@vs@ALIAS_KTV_LICENCE}" key="ktvLicence" value="%{model.ktvLicence}"  cssClass="max-length-30" required="false" />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=Thotel.ALIAS_KTV_FIREPROOFING%>
		                  </td>
			              <td>
		                           <s:textfield label="%{@vs@ALIAS_KTV_FIREPROOFING}" key="ktvFireproofing" value="%{model.ktvFireproofing}"  cssClass="max-length-2" required="false" />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=Thotel.ALIAS_KTV_MONITOR_CONTROL%>
		                  </td>
			              <td>
		                           <s:textfield label="%{@vs@ALIAS_KTV_MONITOR_CONTROL}" key="ktvMonitorControl" value="%{model.ktvMonitorControl}"  cssClass="max-length-2" required="false" />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=Thotel.ALIAS_KTV_CONTRACTOR%>
		                  </td>
			              <td>
		                           <s:textfield label="%{@vs@ALIAS_KTV_CONTRACTOR}" key="ktvContractor" value="%{model.ktvContractor}"  cssClass="max-length-2" required="false" />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=Thotel.ALIAS_KTV_NAME%>
		                  </td>
			              <td>
		                           <s:textfield label="%{@vs@ALIAS_KTV_NAME}" key="ktvName" value="%{model.ktvName}"  cssClass="max-length-30" required="false" />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=Thotel.ALIAS_KTV_TEL%>
		                  </td>
			              <td>
		                           <s:textfield label="%{@vs@ALIAS_KTV_TEL}" key="ktvTel" value="%{model.ktvTel}"  cssClass="max-length-16" required="false" />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=Thotel.ALIAS_KTV_ID%>
		                  </td>
			              <td>
		                           <s:textfield label="%{@vs@ALIAS_KTV_ID}" key="ktvId" value="%{model.ktvId}"  cssClass="max-length-20" required="false" />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=Thotel.ALIAS_CHESS_BOXES%>
		                  </td>
			              <td>
		                           <s:textfield label="%{@vs@ALIAS_CHESS_BOXES}" key="chessBoxes" value="%{model.chessBoxes}"  cssClass="max-length-3" required="false" />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=Thotel.ALIAS_CHESS_FIREPROOFING%>
		                  </td>
			              <td>
		                           <s:textfield label="%{@vs@ALIAS_CHESS_FIREPROOFING}" key="chessFireproofing" value="%{model.chessFireproofing}"  cssClass="max-length-2" required="false" />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=Thotel.ALIAS_CHESS_MONITOR_CONTROL%>
		                  </td>
			              <td>
		                           <s:textfield label="%{@vs@ALIAS_CHESS_MONITOR_CONTROL}" key="chessMonitorControl" value="%{model.chessMonitorControl}"  cssClass="max-length-2" required="false" />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=Thotel.ALIAS_CHESS_CONTRACTOR%>
		                  </td>
			              <td>
		                           <s:textfield label="%{@vs@ALIAS_CHESS_CONTRACTOR}" key="chessContractor" value="%{model.chessContractor}"  cssClass="max-length-2" required="false" />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=Thotel.ALIAS_CHESS_NAME%>
		                  </td>
			              <td>
		                           <s:textfield label="%{@vs@ALIAS_CHESS_NAME}" key="chessName" value="%{model.chessName}"  cssClass="max-length-10" required="false" />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=Thotel.ALIAS_CHESS_TEL%>
		                  </td>
			              <td>
		                           <s:textfield label="%{@vs@ALIAS_CHESS_TEL}" key="chessTel" value="%{model.chessTel}"  cssClass="max-length-16" required="false" />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=Thotel.ALIAS_CHESS_ID%>
		                  </td>
			              <td>
		                           <s:textfield label="%{@vs@ALIAS_CHESS_ID}" key="chessId" value="%{model.chessId}"  cssClass="max-length-20" required="false" />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=Thotel.ALIAS_COMMERCE_COPY%>
		                  </td>
			              <td>
		                           <s:textfield label="%{@vs@ALIAS_COMMERCE_COPY}" key="commerceCopy" value="%{model.commerceCopy}"  cssClass="max-length-2" required="false" />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=Thotel.ALIAS_COMMERCE_FAX%>
		                  </td>
			              <td>
		                           <s:textfield label="%{@vs@ALIAS_COMMERCE_FAX}" key="commerceFax" value="%{model.commerceFax}"  cssClass="max-length-2" required="false" />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=Thotel.ALIAS_COMMERCE_TYPED%>
		                  </td>
			              <td>
		                           <s:textfield label="%{@vs@ALIAS_COMMERCE_TYPED}" key="commerceTyped" value="%{model.commerceTyped}"  cssClass="max-length-2" required="false" />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=Thotel.ALIAS_COMMERCE_TICKET%>
		                  </td>
			              <td>
		                           <s:textfield label="%{@vs@ALIAS_COMMERCE_TICKET}" key="commerceTicket" value="%{model.commerceTicket}"  cssClass="max-length-2" required="false" />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=Thotel.ALIAS_COMMERCE_CONTRACTOR%>
		                  </td>
			              <td>
		                           <s:textfield label="%{@vs@ALIAS_COMMERCE_CONTRACTOR}" key="commerceContractor" value="%{model.commerceContractor}"  cssClass="max-length-2" required="false" />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=Thotel.ALIAS_COMMERCE_NAME%>
		                  </td>
			              <td>
		                           <s:textfield label="%{@vs@ALIAS_COMMERCE_NAME}" key="commerceName" value="%{model.commerceName}"  cssClass="max-length-30" required="false" />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=Thotel.ALIAS_COMMERCE_TEL%>
		                  </td>
			              <td>
		                           <s:textfield label="%{@vs@ALIAS_COMMERCE_TEL}" key="commerceTel" value="%{model.commerceTel}"  cssClass="max-length-16" required="false" />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=Thotel.ALIAS_COMMERCE_ID%>
		                  </td>
			              <td>
		                           <s:textfield label="%{@vs@ALIAS_COMMERCE_ID}" key="commerceId" value="%{model.commerceId}"  cssClass="max-length-20" required="false" />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=Thotel.ALIAS_SAUNA_KNEAD%>
		                  </td>
			              <td>
		                           <s:textfield label="%{@vs@ALIAS_SAUNA_KNEAD}" key="saunaKnead" value="%{model.saunaKnead}"  cssClass="max-length-2" required="false" />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=Thotel.ALIAS_SAUNA_ROOMS%>
		                  </td>
			              <td>
		                           <s:textfield label="%{@vs@ALIAS_SAUNA_ROOMS}" key="saunaRooms" value="%{model.saunaRooms}"  cssClass="max-length-3" required="false" />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=Thotel.ALIAS_SAUNA_WORKMEN%>
		                  </td>
			              <td>
		                           <s:textfield label="%{@vs@ALIAS_SAUNA_WORKMEN}" key="saunaWorkmen" value="%{model.saunaWorkmen}"  cssClass="max-length-3" required="false" />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=Thotel.ALIAS_SAUNA_CONTRACTOR%>
		                  </td>
			              <td>
		                           <s:textfield label="%{@vs@ALIAS_SAUNA_CONTRACTOR}" key="saunaContractor" value="%{model.saunaContractor}"  cssClass="max-length-2" required="false" />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=Thotel.ALIAS_SAUNA_NAME%>
		                  </td>
			              <td>
		                           <s:textfield label="%{@vs@ALIAS_SAUNA_NAME}" key="saunaName" value="%{model.saunaName}"  cssClass="max-length-30" required="false" />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=Thotel.ALIAS_SAUNA_TEL%>
		                  </td>
			              <td>
		                           <s:textfield label="%{@vs@ALIAS_SAUNA_TEL}" key="saunaTel" value="%{model.saunaTel}"  cssClass="max-length-16" required="false" />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=Thotel.ALIAS_SAUNA_ID%>
		                  </td>
			              <td>
		                           <s:textfield label="%{@vs@ALIAS_SAUNA_ID}" key="saunaId" value="%{model.saunaId}"  cssClass="max-length-20" required="false" />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=Thotel.ALIAS_OTHERREMARK%>
		                  </td>
			              <td>
		                           <s:textfield label="%{@vs@ALIAS_OTHERREMARK}" key="otherremark" value="%{model.otherremark}"  cssClass="max-length-100" required="false" />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=Thotel.ALIAS_DEVICE_TYPE%>
		                  </td>
			              <td>
		                           <s:textfield label="%{@vs@ALIAS_DEVICE_TYPE}" key="deviceType" value="%{model.deviceType}"  cssClass="max-length-1" required="false" />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=Thotel.ALIAS_BA_TIME%>
		                  </td>
			              <td>
		                           <s:textfield label="%{@vs@ALIAS_BA_TIME}" key="baTime" value="%{model.baTime}"  cssClass="max-length-18" required="false" />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=Thotel.ALIAS_FRONT_MANAGER%>
		                  </td>
			              <td>
		                           <s:textfield label="%{@vs@ALIAS_FRONT_MANAGER}" key="frontManager" value="%{model.frontManager}"  cssClass="max-length-30" required="false" />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=Thotel.ALIAS_FRDH%>
		                  </td>
			              <td>
		                           <s:textfield label="%{@vs@ALIAS_FRDH}" key="frdh" value="%{model.frdh}"  cssClass="max-length-22" required="false" />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=Thotel.ALIAS_LGXZ%>
		                  </td>
			              <td>
		                           <s:textfield label="%{@vs@ALIAS_LGXZ}" key="lgxz" value="%{model.lgxz}"  cssClass="max-length-1" required="false" />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=Thotel.ALIAS_TZHYXKZH%>
		                  </td>
			              <td>
		                           <s:textfield label="%{@vs@ALIAS_TZHYXKZH}" key="tzhyxkzh" value="%{model.tzhyxkzh}"  cssClass="max-length-30" required="false" />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=Thotel.ALIAS_ZAXKZH%>
		                  </td>
			              <td>
		                           <s:textfield label="%{@vs@ALIAS_ZAXKZH}" key="zaxkzh" value="%{model.zaxkzh}"  cssClass="max-length-30" required="false" />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=Thotel.ALIAS_TFS%>
		                  </td>
			              <td>
		                           <s:textfield label="%{@vs@ALIAS_TFS}" key="tfs" value="%{model.tfs}"  cssClass="max-length-4" required="false" />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=Thotel.ALIAS_BZFS%>
		                  </td>
			              <td>
		                           <s:textfield label="%{@vs@ALIAS_BZFS}" key="bzfs" value="%{model.bzfs}"  cssClass="max-length-4" required="false" />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=Thotel.ALIAS_SRFS%>
		                  </td>
			              <td>
		                           <s:textfield label="%{@vs@ALIAS_SRFS}" key="srfs" value="%{model.srfs}"  cssClass="max-length-4" required="false" />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=Thotel.ALIAS_DRFS%>
		                  </td>
			              <td>
		                           <s:textfield label="%{@vs@ALIAS_DRFS}" key="drfs" value="%{model.drfs}"  cssClass="max-length-4" required="false" />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=Thotel.ALIAS_QTFS%>
		                  </td>
			              <td>
		                           <s:textfield label="%{@vs@ALIAS_QTFS}" key="qtfs" value="%{model.qtfs}"  cssClass="max-length-4" required="false" />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=Thotel.ALIAS_RYZS%>
		                  </td>
			              <td>
		                           <s:textfield label="%{@vs@ALIAS_RYZS}" key="ryzs" value="%{model.ryzs}"  cssClass="max-length-4" required="false" />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=Thotel.ALIAS_DGRS%>
		                  </td>
			              <td>
		                           <s:textfield label="%{@vs@ALIAS_DGRS}" key="dgrs" value="%{model.dgrs}"  cssClass="max-length-4" required="false" />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=Thotel.ALIAS_MS%>
		                  </td>
			              <td>
		                           <s:textfield label="%{@vs@ALIAS_MS}" key="ms" value="%{model.ms}"  cssClass="max-length-1" required="false" />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=Thotel.ALIAS_WFHG%>
		                  </td>
			              <td>
		                           <s:textfield label="%{@vs@ALIAS_WFHG}" key="wfhg" value="%{model.wfhg}"  cssClass="max-length-1" required="false" />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=Thotel.ALIAS_JFHG%>
		                  </td>
			              <td>
		                           <s:textfield label="%{@vs@ALIAS_JFHG}" key="jfhg" value="%{model.jfhg}"  cssClass="max-length-1" required="false" />
		                  </td>
                          <td>&nbsp;</td>
                          <td>&nbsp;</td>
                   </tr>
 
 
