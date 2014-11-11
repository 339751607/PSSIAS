<%@page import="com.dyneinfo.hotel.model.*" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/commons/taglibs.jsp" %>

	<s:hidden id="id" name="id" />

<!-- ONGL access static field: @package.class@field or @vs@field -->

		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=TjwPre.ALIAS_X_SN%>
		                  </td>
			              <td>
		                           <s:textfield label="%{@vs@ALIAS_X_SN}" key="xsn" value="%{model.xsn}"  cssClass="max-length-50" required="false" />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=TjwPre.ALIAS_M_FN%>
		                  </td>
			              <td>
		                           <s:textfield label="%{@vs@ALIAS_M_FN}" key="mfn" value="%{model.mfn}"  cssClass="max-length-50" required="false" />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=TjwPre.ALIAS_CHN_N%>
		                  </td>
			              <td>
		                           <s:textfield label="%{@vs@ALIAS_CHN_N}" key="chnN" value="%{model.chnN}"  cssClass="max-length-30" required="false" />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=TjwPre.ALIAS_SEX%>
		                  </td>
			              <td>
		                           <s:textfield label="%{@vs@ALIAS_SEX}" key="sex" value="%{model.sex}"  cssClass="max-length-1" required="false" />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=TjwPre.ALIAS_BDATE%>
		                  </td>
			              <td>
		                           <s:textfield label="%{@vs@ALIAS_BDATE}" key="bdate" value="%{model.bdate}"  cssClass="max-length-8" required="false" />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=TjwPre.ALIAS_P_NATIONAL%>
		                  </td>
			              <td>
		                           <s:textfield label="%{@vs@ALIAS_P_NATIONAL}" key="pnational" value="%{model.pnational}"  cssClass="max-length-3" required="false" />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=TjwPre.ALIAS_PASS_T%>
		                  </td>
			              <td>
		                           <s:textfield label="%{@vs@ALIAS_PASS_T}" key="passT" value="%{model.passT}"  cssClass="max-length-2" required="false" />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=TjwPre.ALIAS_PASS_NO%>
		                  </td>
			              <td>
		                           <s:textfield label="%{@vs@ALIAS_PASS_NO}" key="passNo" value="%{model.passNo}"  cssClass="max-length-16" required="false" />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=TjwPre.ALIAS_VISA_T%>
		                  </td>
			              <td>
		                           <s:textfield label="%{@vs@ALIAS_VISA_T}" key="visaT" value="%{model.visaT}"  cssClass="max-length-4" required="false" />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=TjwPre.ALIAS_VISA_NO%>
		                  </td>
			              <td>
		                           <s:textfield label="%{@vs@ALIAS_VISA_NO}" key="visaNo" value="%{model.visaNo}"  cssClass="max-length-20" required="false" />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=TjwPre.ALIAS_STAY_DATE%>
		                  </td>
			              <td>
		                           <s:textfield label="%{@vs@ALIAS_STAY_DATE}" key="stayDate" value="%{model.stayDate}"  cssClass="max-length-8" required="false" />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=TjwPre.ALIAS_QF_UNIT%>
		                  </td>
			              <td>
		                           <s:textfield label="%{@vs@ALIAS_QF_UNIT}" key="qfUnit" value="%{model.qfUnit}"  cssClass="max-length-4" required="false" />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=TjwPre.ALIAS_IN_DATE%>
		                  </td>
			              <td>
		                           <s:textfield label="%{@vs@ALIAS_IN_DATE}" key="inDate" value="%{model.inDate}"  cssClass="max-length-8" required="false" />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=TjwPre.ALIAS_IN_PORT%>
		                  </td>
			              <td>
		                           <s:textfield label="%{@vs@ALIAS_IN_PORT}" key="inPort" value="%{model.inPort}"  cssClass="max-length-7" required="false" />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=TjwPre.ALIAS_P_ADDRESS%>
		                  </td>
			              <td>
		                           <s:textfield label="%{@vs@ALIAS_P_ADDRESS}" key="paddress" value="%{model.paddress}"  cssClass="max-length-100" required="false" />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=TjwPre.ALIAS_JD_UNIT%>
		                  </td>
			              <td>
		                           <s:textfield label="%{@vs@ALIAS_JD_UNIT}" key="jdUnit" value="%{model.jdUnit}"  cssClass="max-length-40" required="false" />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=TjwPre.ALIAS_IN_TIME%>
		                  </td>
			              <td>
		                           <s:textfield label="%{@vs@ALIAS_IN_TIME}" key="inTime" value="%{model.inTime}"  cssClass="max-length-12" required="false" />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=TjwPre.ALIAS_NO_ROOM%>
		                  </td>
			              <td>
		                           <s:textfield label="%{@vs@ALIAS_NO_ROOM}" key="noRoom" value="%{model.noRoom}"  cssClass="max-length-10" required="false" />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=TjwPre.ALIAS_OUT_TIME%>
		                  </td>
			              <td>
		                           <s:textfield label="%{@vs@ALIAS_OUT_TIME}" key="outTime" value="%{model.outTime}"  cssClass="max-length-12" required="false" />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=TjwPre.ALIAS_TRA_TIME%>
		                  </td>
			              <td>
		                           <s:textfield label="%{@vs@ALIAS_TRA_TIME}" key="traTime" value="%{model.traTime}"  cssClass="max-length-12" required="false" />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=TjwPre.ALIAS_PLACE%>
		                  </td>
			              <td>
		                           <s:textfield label="%{@vs@ALIAS_PLACE}" key="place" value="%{model.place}"  cssClass="max-length-13" required="false" />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=TjwPre.ALIAS_CREDIT_CODE%>
		                  </td>
			              <td>
		                           <s:textfield label="%{@vs@ALIAS_CREDIT_CODE}" key="creditCode" value="%{model.creditCode}"  cssClass="max-length-10" required="false" />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=TjwPre.ALIAS_CREDIT_NO%>
		                  </td>
			              <td>
		                           <s:textfield label="%{@vs@ALIAS_CREDIT_NO}" key="creditNo" value="%{model.creditNo}"  cssClass="max-length-19" required="false" />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=TjwPre.ALIAS_STA_CODE%>
		                  </td>
			              <td>
		                           <s:textfield label="%{@vs@ALIAS_STA_CODE}" key="staCode" value="%{model.staCode}"  cssClass="max-length-12" required="false" />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=TjwPre.ALIAS_BUR_CODE%>
		                  </td>
			              <td>
		                           <s:textfield label="%{@vs@ALIAS_BUR_CODE}" key="burCode" value="%{model.burCode}"  cssClass="max-length-12" required="false" />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=TjwPre.ALIAS_SPM%>
		                  </td>
			              <td>
		                           <s:textfield label="%{@vs@ALIAS_SPM}" key="spm" value="%{model.spm}"  cssClass="max-length-30" required="false" />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=TjwPre.ALIAS_INSERT_TIME%>
		                  </td>
			              <td>
		                           <s:textfield label="%{@vs@ALIAS_INSERT_TIME}" key="insertTime" value="%{model.insertTime}"  cssClass="max-length-12" required="false" />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=TjwPre.ALIAS_MEMO%>
		                  </td>
			              <td>
		                           <s:textfield label="%{@vs@ALIAS_MEMO}" key="memo" value="%{model.memo}"  cssClass="max-length-200" required="false" />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=TjwPre.ALIAS_REASON%>
		                  </td>
			              <td>
		                           <s:textfield label="%{@vs@ALIAS_REASON}" key="reason" value="%{model.reason}"  cssClass="max-length-40" required="false" />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=TjwPre.ALIAS_HOTELID%>
		                  </td>
			              <td>
		                           <s:textfield label="%{@vs@ALIAS_HOTELID}" key="hotelid" value="%{model.hotelid}"  cssClass="max-length-10" required="false" />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=TjwPre.ALIAS_PDAFLAG%>
		                  </td>
			              <td>
		                           <s:textfield label="%{@vs@ALIAS_PDAFLAG}" key="pdaflag" value="%{model.pdaflag}"  cssClass="max-length-4" required="false" />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=TjwPre.ALIAS_DRAGOMANAME%>
		                  </td>
			              <td>
		                           <s:textfield label="%{@vs@ALIAS_DRAGOMANAME}" key="dragomaname" value="%{model.dragomaname}"  cssClass="max-length-50" required="false" />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=TjwPre.ALIAS_DRAGOMAPHONE%>
		                  </td>
			              <td>
		                           <s:textfield label="%{@vs@ALIAS_DRAGOMAPHONE}" key="dragomaphone" value="%{model.dragomaphone}"  cssClass="max-length-50" required="false" />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=TjwPre.ALIAS_GROUPNO%>
		                  </td>
			              <td>
		                           <s:textfield label="%{@vs@ALIAS_GROUPNO}" key="groupno" value="%{model.groupno}"  cssClass="max-length-50" required="false" />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=TjwPre.ALIAS_TRANSFERFLAG%>
		                  </td>
			              <td>
		                           <s:textfield label="%{@vs@ALIAS_TRANSFERFLAG}" key="transferflag" value="%{model.transferflag}"  cssClass="validate-number " required="false" />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=TjwPre.ALIAS_KYRY%>
		                  </td>
			              <td>
		                           <s:textfield label="%{@vs@ALIAS_KYRY}" key="kyry" value="%{model.kyry}"  cssClass="max-length-1" required="false" />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=TjwPre.ALIAS_FLAGTJ%>
		                  </td>
			              <td>
		                           <s:textfield label="%{@vs@ALIAS_FLAGTJ}" key="flagtj" value="%{model.flagtj}"  cssClass="max-length-1" required="false" />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=TjwPre.ALIAS_DAYS%>
		                  </td>
			              <td>
		                           <s:textfield label="%{@vs@ALIAS_DAYS}" key="days" value="%{model.days}"  cssClass="validate-number " required="false" />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=TjwPre.ALIAS_SFZH%>
		                  </td>
			              <td>
		                           <s:textfield label="%{@vs@ALIAS_SFZH}" key="sfzh" value="%{model.sfzh}"  cssClass="max-length-20" required="false" />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=TjwPre.ALIAS_ZJYXQ%>
		                  </td>
			              <td>
		                           <s:textfield label="%{@vs@ALIAS_ZJYXQ}" key="zjyxq" value="%{model.zjyxq}"  cssClass="max-length-8" required="false" />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=TjwPre.ALIAS_OPERATOR%>
		                  </td>
			              <td>
		                           <s:textfield label="%{@vs@ALIAS_OPERATOR}" key="operator" value="%{model.operator}"  cssClass="max-length-20" required="false" />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=TjwPre.ALIAS_CITY_CODE%>
		                  </td>
			              <td>
		                           <s:textfield label="%{@vs@ALIAS_CITY_CODE}" key="cityCode" value="%{model.cityCode}"  cssClass="max-length-12" required="false" />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=TjwPre.ALIAS_LEAVEDATE%>
		                  </td>
			              <td>
		                           <s:textfield label="%{@vs@ALIAS_LEAVEDATE}" key="leavedate" value="%{model.leavedate}"  cssClass="max-length-8" required="false" />
		                  </td>
                          <td>&nbsp;</td>
                          <td>&nbsp;</td>
                   </tr>
 
 
