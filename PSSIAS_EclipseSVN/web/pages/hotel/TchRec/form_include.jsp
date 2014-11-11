<%@page import="com.dyneinfo.hotel.model.*" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/commons/taglibs.jsp" %>

	<s:hidden id="id" name="id" />

<!-- ONGL access static field: @package.class@field or @vs@field -->

		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=TchRec.ALIAS_NAME%>
		                  </td>
			              <td>
		                           <s:textfield label="%{@vs@ALIAS_NAME}" key="name" value="%{model.name}"  cssClass="max-length-30" required="false" />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=TchRec.ALIAS_SEX%>
		                  </td>
			              <td>
		                           <s:textfield label="%{@vs@ALIAS_SEX}" key="sex" value="%{model.sex}"  cssClass="max-length-1" required="false" />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=TchRec.ALIAS_NATION%>
		                  </td>
			              <td>
		                           <s:textfield label="%{@vs@ALIAS_NATION}" key="nation" value="%{model.nation}"  cssClass="max-length-2" required="false" />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=TchRec.ALIAS_BDATE%>
		                  </td>
			              <td>
		                           <s:textfield label="%{@vs@ALIAS_BDATE}" key="bdate" value="%{model.bdate}"  cssClass="max-length-8" required="false" />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=TchRec.ALIAS_ID_NAME%>
		                  </td>
			              <td>
		                           <s:textfield label="%{@vs@ALIAS_ID_NAME}" key="idName" value="%{model.idName}"  cssClass="max-length-2" required="false" />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=TchRec.ALIAS_ID_CODE%>
		                  </td>
			              <td>
		                           <s:textfield label="%{@vs@ALIAS_ID_CODE}" key="idCode" value="%{model.idCode}"  cssClass="max-length-18" required="false" />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=TchRec.ALIAS_XZQH%>
		                  </td>
			              <td>
		                           <s:textfield label="%{@vs@ALIAS_XZQH}" key="xzqh" value="%{model.xzqh}"  cssClass="max-length-6" required="false" />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=TchRec.ALIAS_ADDRESS%>
		                  </td>
			              <td>
		                           <s:textfield label="%{@vs@ALIAS_ADDRESS}" key="address" value="%{model.address}"  cssClass="max-length-100" required="false" />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=TchRec.ALIAS_IN_TIME%>
		                  </td>
			              <td>
		                           <s:textfield label="%{@vs@ALIAS_IN_TIME}" key="inTime" value="%{model.inTime}"  cssClass="max-length-12" required="false" />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=TchRec.ALIAS_NO_ROOM%>
		                  </td>
			              <td>
		                           <s:textfield label="%{@vs@ALIAS_NO_ROOM}" key="noRoom" value="%{model.noRoom}"  cssClass="max-length-10" required="false" />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=TchRec.ALIAS_OUT_TIME%>
		                  </td>
			              <td>
		                           <s:textfield label="%{@vs@ALIAS_OUT_TIME}" key="outTime" value="%{model.outTime}"  cssClass="max-length-12" required="false" />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=TchRec.ALIAS_TRA_TIME%>
		                  </td>
			              <td>
		                           <s:textfield label="%{@vs@ALIAS_TRA_TIME}" key="traTime" value="%{model.traTime}"  cssClass="max-length-12" required="false" />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=TchRec.ALIAS_CREDIT_CODE%>
		                  </td>
			              <td>
		                           <s:textfield label="%{@vs@ALIAS_CREDIT_CODE}" key="creditCode" value="%{model.creditCode}"  cssClass="max-length-10" required="false" />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=TchRec.ALIAS_CREDIT_NO%>
		                  </td>
			              <td>
		                           <s:textfield label="%{@vs@ALIAS_CREDIT_NO}" key="creditNo" value="%{model.creditNo}"  cssClass="max-length-19" required="false" />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=TchRec.ALIAS_STA_CODE%>
		                  </td>
			              <td>
		                           <s:textfield label="%{@vs@ALIAS_STA_CODE}" key="staCode" value="%{model.staCode}"  cssClass="max-length-12" required="false" />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=TchRec.ALIAS_BUR_CODE%>
		                  </td>
			              <td>
		                           <s:textfield label="%{@vs@ALIAS_BUR_CODE}" key="burCode" value="%{model.burCode}"  cssClass="max-length-12" required="false" />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=TchRec.ALIAS_SPM%>
		                  </td>
			              <td>
		                           <s:textfield label="%{@vs@ALIAS_SPM}" key="spm" value="%{model.spm}"  cssClass="max-length-30" required="false" />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=TchRec.ALIAS_INSERT_TIME%>
		                  </td>
			              <td>
		                           <s:textfield label="%{@vs@ALIAS_INSERT_TIME}" key="insertTime" value="%{model.insertTime}"  cssClass="max-length-12" required="false" />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=TchRec.ALIAS_MEMO%>
		                  </td>
			              <td>
		                           <s:textfield label="%{@vs@ALIAS_MEMO}" key="memo" value="%{model.memo}"  cssClass="max-length-200" required="false" />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=TchRec.ALIAS_HOTELID%>
		                  </td>
			              <td>
		                           <s:textfield label="%{@vs@ALIAS_HOTELID}" key="hotelid" value="%{model.hotelid}"  cssClass="max-length-10" required="false" />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=TchRec.ALIAS_PDAFLAG%>
		                  </td>
			              <td>
		                           <s:textfield label="%{@vs@ALIAS_PDAFLAG}" key="pdaflag" value="%{model.pdaflag}"  cssClass="max-length-4" required="false" />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=TchRec.ALIAS_DRAGOMANAME%>
		                  </td>
			              <td>
		                           <s:textfield label="%{@vs@ALIAS_DRAGOMANAME}" key="dragomaname" value="%{model.dragomaname}"  cssClass="max-length-50" required="false" />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=TchRec.ALIAS_DRAGOMAPHONE%>
		                  </td>
			              <td>
		                           <s:textfield label="%{@vs@ALIAS_DRAGOMAPHONE}" key="dragomaphone" value="%{model.dragomaphone}"  cssClass="max-length-50" required="false" />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=TchRec.ALIAS_GROUPNO%>
		                  </td>
			              <td>
		                           <s:textfield label="%{@vs@ALIAS_GROUPNO}" key="groupno" value="%{model.groupno}"  cssClass="max-length-50" required="false" />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=TchRec.ALIAS_KYRY%>
		                  </td>
			              <td>
		                           <s:textfield label="%{@vs@ALIAS_KYRY}" key="kyry" value="%{model.kyry}"  cssClass="max-length-1" required="false" />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=TchRec.ALIAS_FLAGTJ%>
		                  </td>
			              <td>
		                           <s:textfield label="%{@vs@ALIAS_FLAGTJ}" key="flagtj" value="%{model.flagtj}"  cssClass="max-length-1" required="false" />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=TchRec.ALIAS_DAYS%>
		                  </td>
			              <td>
		                           <s:textfield label="%{@vs@ALIAS_DAYS}" key="days" value="%{model.days}"  cssClass="validate-number " required="false" />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=TchRec.ALIAS_FLAGKY%>
		                  </td>
			              <td>
		                           <s:textfield label="%{@vs@ALIAS_FLAGKY}" key="flagky" value="%{model.flagky}"  cssClass="max-length-1" required="false" />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=TchRec.ALIAS_KYTYPE%>
		                  </td>
			              <td>
		                           <s:textfield label="%{@vs@ALIAS_KYTYPE}" key="kytype" value="%{model.kytype}"  cssClass="max-length-1" required="false" />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=TchRec.ALIAS_FLAGCQBF%>
		                  </td>
			              <td>
		                           <s:textfield label="%{@vs@ALIAS_FLAGCQBF}" key="flagcqbf" value="%{model.flagcqbf}"  cssClass="max-length-1" required="false" />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=TchRec.ALIAS_HOTELNAME%>
		                  </td>
			              <td>
		                           <s:textfield label="%{@vs@ALIAS_HOTELNAME}" key="hotelname" value="%{model.hotelname}"  cssClass="max-length-50" required="false" />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=TchRec.ALIAS_CITY_CODE%>
		                  </td>
			              <td>
		                           <s:textfield label="%{@vs@ALIAS_CITY_CODE}" key="cityCode" value="%{model.cityCode}"  cssClass="max-length-12" required="false" />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=TchRec.ALIAS_TLSY%>
		                  </td>
			              <td>
		                           <s:textfield label="%{@vs@ALIAS_TLSY}" key="tlsy" value="%{model.tlsy}"  cssClass="max-length-2" required="false" />
		                  </td>
                          <td>&nbsp;</td>
                          <td>&nbsp;</td>
                   </tr>
 
 
