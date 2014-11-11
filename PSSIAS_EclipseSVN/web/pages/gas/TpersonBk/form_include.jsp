<%@page import="com.dyneinfo.gas.model.*" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/commons/taglibs.jsp" %>

	<s:hidden id="id" name="id" />

<!-- ONGL access static field: @package.class@field or @vs@field -->

		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=TpersonBk.ALIAS_XM%>
		                  </td>
			              <td>
		                           <s:textfield label="%{@vs@ALIAS_XM}" key="xm" value="%{model.xm}"  cssClass="max-length-30" required="false" />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=TpersonBk.ALIAS_HM1%>
		                  </td>
			              <td>
		                           <s:textfield label="%{@vs@ALIAS_HM1}" key="hm1" value="%{model.hm1}"  cssClass="max-length-30" required="false" />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=TpersonBk.ALIAS_HM2%>
		                  </td>
			              <td>
		                           <s:textfield label="%{@vs@ALIAS_HM2}" key="hm2" value="%{model.hm2}"  cssClass="max-length-40" required="false" />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=TpersonBk.ALIAS_XB%>
		                  </td>
			              <td>
		                           <s:textfield label="%{@vs@ALIAS_XB}" key="xb" value="%{model.xb}"  cssClass="max-length-1" required="false" />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=TpersonBk.ALIAS_BDATE%>
		                  </td>
			              <td>
		                           <s:textfield label="%{@vs@ALIAS_BDATE}" key="bdate" value="%{model.bdate}"  cssClass="max-length-8" required="false" />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=TpersonBk.ALIAS_JG%>
		                  </td>
			              <td>
		                           <s:textfield label="%{@vs@ALIAS_JG}" key="jg" value="%{model.jg}"  cssClass="max-length-6" required="false" />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=TpersonBk.ALIAS_HJD%>
		                  </td>
			              <td>
		                           <s:textfield label="%{@vs@ALIAS_HJD}" key="hjd" value="%{model.hjd}"  cssClass="max-length-6" required="false" />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=TpersonBk.ALIAS_ZZ%>
		                  </td>
			              <td>
		                           <s:textfield label="%{@vs@ALIAS_ZZ}" key="zz" value="%{model.zz}"  cssClass="max-length-50" required="false" />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=TpersonBk.ALIAS_SFZH%>
		                  </td>
			              <td>
		                           <s:textfield label="%{@vs@ALIAS_SFZH}" key="sfzh" value="%{model.sfzh}"  cssClass="max-length-18" required="false" />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=TpersonBk.ALIAS_SG%>
		                  </td>
			              <td>
		                           <s:textfield label="%{@vs@ALIAS_SG}" key="sg" value="%{model.sg}"  cssClass="max-length-3" required="false" />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=TpersonBk.ALIAS_TX%>
		                  </td>
			              <td>
		                           <s:textfield label="%{@vs@ALIAS_TX}" key="tx" value="%{model.tx}"  cssClass="max-length-4" required="false" />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=TpersonBk.ALIAS_TSTZ%>
		                  </td>
			              <td>
		                           <s:textfield label="%{@vs@ALIAS_TSTZ}" key="tstz" value="%{model.tstz}"  cssClass="max-length-90" required="false" />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=TpersonBk.ALIAS_XH%>
		                  </td>
			              <td>
		                           <s:textfield label="%{@vs@ALIAS_XH}" key="xh" value="%{model.xh}"  cssClass="max-length-20" required="false" />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=TpersonBk.ALIAS_AB%>
		                  </td>
			              <td>
		                           <s:textfield label="%{@vs@ALIAS_AB}" key="ab" value="%{model.ab}"  cssClass="max-length-12" required="false" />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=TpersonBk.ALIAS_LADW%>
		                  </td>
			              <td>
		                           <s:textfield label="%{@vs@ALIAS_LADW}" key="ladw" value="%{model.ladw}"  cssClass="max-length-40" required="false" />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=TpersonBk.ALIAS_LASJ%>
		                  </td>
			              <td>
		                           <s:textfield label="%{@vs@ALIAS_LASJ}" key="lasj" value="%{model.lasj}"  cssClass="max-length-8" required="false" />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=TpersonBk.ALIAS_PZR%>
		                  </td>
			              <td>
		                           <s:textfield label="%{@vs@ALIAS_PZR}" key="pzr" value="%{model.pzr}"  cssClass="max-length-30" required="false" />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=TpersonBk.ALIAS_LXR%>
		                  </td>
			              <td>
		                           <s:textfield label="%{@vs@ALIAS_LXR}" key="lxr" value="%{model.lxr}"  cssClass="max-length-30" required="false" />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=TpersonBk.ALIAS_LXDH%>
		                  </td>
			              <td>
		                           <s:textfield label="%{@vs@ALIAS_LXDH}" key="lxdh" value="%{model.lxdh}"  cssClass="max-length-30" required="false" />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=TpersonBk.ALIAS_ZTSJ%>
		                  </td>
			              <td>
		                           <s:textfield label="%{@vs@ALIAS_ZTSJ}" key="ztsj" value="%{model.ztsj}"  cssClass="max-length-8" required="false" />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=TpersonBk.ALIAS_JYAQ%>
		                  </td>
			              <td>
		                           <s:textfield label="%{@vs@ALIAS_JYAQ}" key="jyaq" value="%{model.jyaq}"  cssClass="max-length-300" required="false" />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=TpersonBk.ALIAS_TAF1%>
		                  </td>
			              <td>
		                           <s:textfield label="%{@vs@ALIAS_TAF1}" key="taf1" value="%{model.taf1}"  cssClass="max-length-30" required="false" />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=TpersonBk.ALIAS_TAF2%>
		                  </td>
			              <td>
		                           <s:textfield label="%{@vs@ALIAS_TAF2}" key="taf2" value="%{model.taf2}"  cssClass="max-length-30" required="false" />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=TpersonBk.ALIAS_TAF3%>
		                  </td>
			              <td>
		                           <s:textfield label="%{@vs@ALIAS_TAF3}" key="taf3" value="%{model.taf3}"  cssClass="max-length-30" required="false" />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=TpersonBk.ALIAS_TAF4%>
		                  </td>
			              <td>
		                           <s:textfield label="%{@vs@ALIAS_TAF4}" key="taf4" value="%{model.taf4}"  cssClass="max-length-30" required="false" />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=TpersonBk.ALIAS_TJH1%>
		                  </td>
			              <td>
		                           <s:textfield label="%{@vs@ALIAS_TJH1}" key="tjh1" value="%{model.tjh1}"  cssClass="max-length-20" required="false" />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=TpersonBk.ALIAS_TJH2%>
		                  </td>
			              <td>
		                           <s:textfield label="%{@vs@ALIAS_TJH2}" key="tjh2" value="%{model.tjh2}"  cssClass="max-length-20" required="false" />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=TpersonBk.ALIAS_TJH3%>
		                  </td>
			              <td>
		                           <s:textfield label="%{@vs@ALIAS_TJH3}" key="tjh3" value="%{model.tjh3}"  cssClass="max-length-20" required="false" />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=TpersonBk.ALIAS_TBDW%>
		                  </td>
			              <td>
		                           <s:textfield label="%{@vs@ALIAS_TBDW}" key="tbdw" value="%{model.tbdw}"  cssClass="max-length-40" required="false" />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=TpersonBk.ALIAS_BKLX%>
		                  </td>
			              <td>
		                           <s:textfield label="%{@vs@ALIAS_BKLX}" key="bklx" value="%{model.bklx}"  cssClass="max-length-1" required="false" />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=TpersonBk.ALIAS_ALARM_TEL%>
		                  </td>
			              <td>
		                           <s:textfield label="%{@vs@ALIAS_ALARM_TEL}" key="alarmTel" value="%{model.alarmTel}"  cssClass="max-length-80" required="false" />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=TpersonBk.ALIAS_BKPZR%>
		                  </td>
			              <td>
		                           <s:textfield label="%{@vs@ALIAS_BKPZR}" key="bkpzr" value="%{model.bkpzr}"  cssClass="max-length-30" required="false" />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=TpersonBk.ALIAS_CZR%>
		                  </td>
			              <td>
		                           <s:textfield label="%{@vs@ALIAS_CZR}" key="czr" value="%{model.czr}"  cssClass="max-length-30" required="false" />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=TpersonBk.ALIAS_BKSJ%>
		                  </td>
			              <td>
		                           <s:textfield label="%{@vs@ALIAS_BKSJ}" key="bksj" value="%{model.bksj}"  cssClass="max-length-12" required="false" />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=TpersonBk.ALIAS_SFYX%>
		                  </td>
			              <td>
		                           <s:textfield label="%{@vs@ALIAS_SFYX}" key="sfyx" value="%{model.sfyx}"  cssClass="max-length-1" required="false" />
		                  </td>
                          <td>&nbsp;</td>
                          <td>&nbsp;</td>
                   </tr>
 
 
