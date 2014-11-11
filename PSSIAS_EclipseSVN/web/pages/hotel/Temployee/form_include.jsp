<%@page import="com.dyneinfo.hotel.model.*" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/commons/taglibs.jsp" %>

	<s:hidden id="empcode" name="empcode" />

<!-- ONGL access static field: @package.class@field or @vs@field -->

		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=Temployee.ALIAS_EMPNAME%>
		                  </td>
			              <td>
		                           <s:textfield label="%{@vs@ALIAS_EMPNAME}" key="empname" value="%{model.empname}"  cssClass="max-length-30" required="false" />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=Temployee.ALIAS_ALIAS%>
		                  </td>
			              <td>
		                           <s:textfield label="%{@vs@ALIAS_ALIAS}" key="alias" value="%{model.alias}"  cssClass="max-length-30" required="false" />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=Temployee.ALIAS_SEX%>
		                  </td>
			              <td>
		                           <s:textfield label="%{@vs@ALIAS_SEX}" key="sex" value="%{model.sex}"  cssClass="max-length-1" required="false" />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=Temployee.ALIAS_BIRTH%>
		                  </td>
			              <td>
		                           <s:textfield label="%{@vs@ALIAS_BIRTH}" key="birth" value="%{model.birth}"  cssClass="max-length-8" required="false" />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=Temployee.ALIAS_STATURE%>
		                  </td>
			              <td>
		                           <s:textfield label="%{@vs@ALIAS_STATURE}" key="stature" value="%{model.stature}"  cssClass="max-length-3" required="false" />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=Temployee.ALIAS_WEIGHT%>
		                  </td>
			              <td>
		                           <s:textfield label="%{@vs@ALIAS_WEIGHT}" key="weight" value="%{model.weight}"  cssClass="max-length-3" required="false" />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=Temployee.ALIAS_POSTURE%>
		                  </td>
			              <td>
		                           <s:textfield label="%{@vs@ALIAS_POSTURE}" key="posture" value="%{model.posture}"  cssClass="max-length-4" required="false" />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=Temployee.ALIAS_POLITYVISAGE%>
		                  </td>
			              <td>
		                           <s:textfield label="%{@vs@ALIAS_POLITYVISAGE}" key="polityvisage" value="%{model.polityvisage}"  cssClass="max-length-2" required="false" />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=Temployee.ALIAS_FOLK%>
		                  </td>
			              <td>
		                           <s:textfield label="%{@vs@ALIAS_FOLK}" key="folk" value="%{model.folk}"  cssClass="max-length-2" required="false" />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=Temployee.ALIAS_NATIVEPLACE%>
		                  </td>
			              <td>
		                           <s:textfield label="%{@vs@ALIAS_NATIVEPLACE}" key="nativeplace" value="%{model.nativeplace}"  cssClass="max-length-6" required="false" />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=Temployee.ALIAS_ADDRESS%>
		                  </td>
			              <td>
		                           <s:textfield label="%{@vs@ALIAS_ADDRESS}" key="address" value="%{model.address}"  cssClass="max-length-200" required="false" />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=Temployee.ALIAS_NOWADRESS%>
		                  </td>
			              <td>
		                           <s:textfield label="%{@vs@ALIAS_NOWADRESS}" key="nowadress" value="%{model.nowadress}"  cssClass="max-length-200" required="false" />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=Temployee.ALIAS_PHONE%>
		                  </td>
			              <td>
		                           <s:textfield label="%{@vs@ALIAS_PHONE}" key="phone" value="%{model.phone}"  cssClass="max-length-20" required="false" />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=Temployee.ALIAS_SCHOOLAGE%>
		                  </td>
			              <td>
		                           <s:textfield label="%{@vs@ALIAS_SCHOOLAGE}" key="schoolage" value="%{model.schoolage}"  cssClass="max-length-2" required="false" />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=Temployee.ALIAS_PERSONID%>
		                  </td>
			              <td>
		                           <s:textfield label="%{@vs@ALIAS_PERSONID}" key="personid" value="%{model.personid}"  cssClass="max-length-18" required="false" />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=Temployee.ALIAS_NPCODE%>
		                  </td>
			              <td>
		                           <s:textfield label="%{@vs@ALIAS_NPCODE}" key="npcode" value="%{model.npcode}"  cssClass="max-length-6" required="false" />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=Temployee.ALIAS_NPADDRESS%>
		                  </td>
			              <td>
		                           <s:textfield label="%{@vs@ALIAS_NPADDRESS}" key="npaddress" value="%{model.npaddress}"  cssClass="max-length-200" required="false" />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=Temployee.ALIAS_TEMPORARYCODE%>
		                  </td>
			              <td>
		                           <s:textfield label="%{@vs@ALIAS_TEMPORARYCODE}" key="temporarycode" value="%{model.temporarycode}"  cssClass="max-length-16" required="false" />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=Temployee.ALIAS_INSERTTIME%>
		                  </td>
			              <td>
		                           <s:textfield label="%{@vs@ALIAS_INSERTTIME}" key="inserttime" value="%{model.inserttime}"  cssClass="max-length-14" required="false" />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=Temployee.ALIAS_EDITTIME%>
		                  </td>
			              <td>
		                           <s:textfield label="%{@vs@ALIAS_EDITTIME}" key="edittime" value="%{model.edittime}"  cssClass="max-length-14" required="false" />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=Temployee.ALIAS_HYZH%>
		                  </td>
			              <td>
		                           <s:textfield label="%{@vs@ALIAS_HYZH}" key="hyzh" value="%{model.hyzh}"  cssClass="max-length-2" required="false" />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=Temployee.ALIAS_CYRJZT%>
		                  </td>
			              <td>
		                           <s:textfield label="%{@vs@ALIAS_CYRJZT}" key="cyrjzt" value="%{model.cyrjzt}"  cssClass="max-length-1" required="false" />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=Temployee.ALIAS_TRATIME%>
		                  </td>
			              <td>
		                           <s:textfield label="%{@vs@ALIAS_TRATIME}" key="tratime" value="%{model.tratime}"  cssClass="max-length-12" required="false" />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=Temployee.ALIAS_INDBTIME%>
		                  </td>
			              <td>
		                           <s:textfield label="%{@vs@ALIAS_INDBTIME}" key="indbtime" value="%{model.indbtime}"  cssClass="max-length-12" required="false" />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=Temployee.ALIAS_HOTELCODE%>
		                  </td>
			              <td>
		                           <s:textfield label="%{@vs@ALIAS_HOTELCODE}" key="hotelcode" value="%{model.hotelcode}"  cssClass="max-length-10" required="false" />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=Temployee.ALIAS_STACODE%>
		                  </td>
			              <td>
		                           <s:textfield label="%{@vs@ALIAS_STACODE}" key="stacode" value="%{model.stacode}"  cssClass="max-length-12" required="false" />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=Temployee.ALIAS_BURCODE%>
		                  </td>
			              <td>
		                           <s:textfield label="%{@vs@ALIAS_BURCODE}" key="burcode" value="%{model.burcode}"  cssClass="max-length-12" required="false" />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=Temployee.ALIAS_CITYCODE%>
		                  </td>
			              <td>
		                           <s:textfield label="%{@vs@ALIAS_CITYCODE}" key="citycode" value="%{model.citycode}"  cssClass="max-length-12" required="false" />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=Temployee.ALIAS_TRANSFLAG%>
		                  </td>
			              <td>
		                           <s:textfield label="%{@vs@ALIAS_TRANSFLAG}" key="transflag" value="%{model.transflag}"  cssClass="validate-number " required="false" />
		                  </td>
                          <td>&nbsp;</td>
                          <td>&nbsp;</td>
                   </tr>
 
 
