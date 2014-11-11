<%@page import="com.dyneinfo.hotel.model.*" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/commons/taglibs.jsp" %>

	<s:hidden id="id" name="id" />

<!-- ONGL access static field: @package.class@field or @vs@field -->

		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <FONT color="red">*</FONT><%=TchAlarminfor.ALIAS_XH%>
		                  </td>
			              <td>
		                           <s:textfield label="%{@vs@ALIAS_XH}" key="xh" value="%{model.xh}"  cssClass="required max-length-22" required="true" />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=TchAlarminfor.ALIAS_SFZH%>
		                  </td>
			              <td>
		                           <s:textfield label="%{@vs@ALIAS_SFZH}" key="sfzh" value="%{model.sfzh}"  cssClass="max-length-18" required="false" />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <FONT color="red">*</FONT><%=TchAlarminfor.ALIAS_XM%>
		                  </td>
			              <td>
		                           <s:textfield label="%{@vs@ALIAS_XM}" key="xm" value="%{model.xm}"  cssClass="required max-length-30" required="true" />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=TchAlarminfor.ALIAS_HM1%>
		                  </td>
			              <td>
		                           <s:textfield label="%{@vs@ALIAS_HM1}" key="hm1" value="%{model.hm1}"  cssClass="max-length-200" required="false" />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=TchAlarminfor.ALIAS_HM2%>
		                  </td>
			              <td>
		                           <s:textfield label="%{@vs@ALIAS_HM2}" key="hm2" value="%{model.hm2}"  cssClass="max-length-200" required="false" />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=TchAlarminfor.ALIAS_XB%>
		                  </td>
			              <td>
		                           <s:textfield label="%{@vs@ALIAS_XB}" key="xb" value="%{model.xb}"  cssClass="max-length-1" required="false" />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=TchAlarminfor.ALIAS_NL%>
		                  </td>
			              <td>
		                           <s:textfield label="%{@vs@ALIAS_NL}" key="nl" value="%{model.nl}"  cssClass="max-length-8" required="false" />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=TchAlarminfor.ALIAS_JG%>
		                  </td>
			              <td>
		                           <s:textfield label="%{@vs@ALIAS_JG}" key="jg" value="%{model.jg}"  cssClass="max-length-40" required="false" />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=TchAlarminfor.ALIAS_HJD%>
		                  </td>
			              <td>
		                           <s:textfield label="%{@vs@ALIAS_HJD}" key="hjd" value="%{model.hjd}"  cssClass="max-length-300" required="false" />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=TchAlarminfor.ALIAS_ZZ%>
		                  </td>
			              <td>
		                           <s:textfield label="%{@vs@ALIAS_ZZ}" key="zz" value="%{model.zz}"  cssClass="max-length-500" required="false" />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=TchAlarminfor.ALIAS_SG%>
		                  </td>
			              <td>
		                           <s:textfield label="%{@vs@ALIAS_SG}" key="sg" value="%{model.sg}"  cssClass="max-length-3" required="false" />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=TchAlarminfor.ALIAS_TX%>
		                  </td>
			              <td>
		                           <s:textfield label="%{@vs@ALIAS_TX}" key="tx" value="%{model.tx}"  cssClass="max-length-4" required="false" />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=TchAlarminfor.ALIAS_TSTZ%>
		                  </td>
			              <td>
		                           <s:textfield label="%{@vs@ALIAS_TSTZ}" key="tstz" value="%{model.tstz}"  cssClass="max-length-90" required="false" />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=TchAlarminfor.ALIAS_AB%>
		                  </td>
			              <td>
		                           <s:textfield label="%{@vs@ALIAS_AB}" key="ab" value="%{model.ab}"  cssClass="max-length-20" required="false" />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=TchAlarminfor.ALIAS_LADW%>
		                  </td>
			              <td>
		                           <s:textfield label="%{@vs@ALIAS_LADW}" key="ladw" value="%{model.ladw}"  cssClass="max-length-40" required="false" />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=TchAlarminfor.ALIAS_LASJ%>
		                  </td>
			              <td>
		                           <s:textfield label="%{@vs@ALIAS_LASJ}" key="lasj" value="%{model.lasj}"  cssClass="max-length-8" required="false" />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=TchAlarminfor.ALIAS_JYAQ%>
		                  </td>
			              <td>
		                           <s:textfield label="%{@vs@ALIAS_JYAQ}" key="jyaq" value="%{model.jyaq}"  cssClass="max-length-255" required="false" />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=TchAlarminfor.ALIAS_TBDW%>
		                  </td>
			              <td>
		                           <s:textfield label="%{@vs@ALIAS_TBDW}" key="tbdw" value="%{model.tbdw}"  cssClass="max-length-40" required="false" />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=TchAlarminfor.ALIAS_NAME%>
		                  </td>
			              <td>
		                           <s:textfield label="%{@vs@ALIAS_NAME}" key="name" value="%{model.name}"  cssClass="max-length-30" required="false" />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=TchAlarminfor.ALIAS_ID_NAME%>
		                  </td>
			              <td>
		                           <s:textfield label="%{@vs@ALIAS_ID_NAME}" key="idName" value="%{model.idName}"  cssClass="max-length-2" required="false" />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=TchAlarminfor.ALIAS_ID_CODE%>
		                  </td>
			              <td>
		                           <s:textfield label="%{@vs@ALIAS_ID_CODE}" key="idCode" value="%{model.idCode}"  cssClass="max-length-18" required="false" />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=TchAlarminfor.ALIAS_SEX%>
		                  </td>
			              <td>
		                           <s:textfield label="%{@vs@ALIAS_SEX}" key="sex" value="%{model.sex}"  cssClass="max-length-1" required="false" />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=TchAlarminfor.ALIAS_NATION%>
		                  </td>
			              <td>
		                           <s:textfield label="%{@vs@ALIAS_NATION}" key="nation" value="%{model.nation}"  cssClass="max-length-2" required="false" />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=TchAlarminfor.ALIAS_BDATE%>
		                  </td>
			              <td>
		                           <s:textfield label="%{@vs@ALIAS_BDATE}" key="bdate" value="%{model.bdate}"  cssClass="max-length-8" required="false" />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=TchAlarminfor.ALIAS_ADDRESS%>
		                  </td>
			              <td>
		                           <s:textfield label="%{@vs@ALIAS_ADDRESS}" key="address" value="%{model.address}"  cssClass="max-length-200" required="false" />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=TchAlarminfor.ALIAS_XZQH%>
		                  </td>
			              <td>
		                           <s:textfield label="%{@vs@ALIAS_XZQH}" key="xzqh" value="%{model.xzqh}"  cssClass="max-length-6" required="false" />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=TchAlarminfor.ALIAS_NO_ROOM%>
		                  </td>
			              <td>
		                           <s:textfield label="%{@vs@ALIAS_NO_ROOM}" key="noRoom" value="%{model.noRoom}"  cssClass="max-length-10" required="false" />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=TchAlarminfor.ALIAS_IN_TIME%>
		                  </td>
			              <td>
		                           <s:textfield label="%{@vs@ALIAS_IN_TIME}" key="inTime" value="%{model.inTime}"  cssClass="max-length-12" required="false" />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=TchAlarminfor.ALIAS_FTIME%>
		                  </td>
			              <td>
		                           <s:textfield label="%{@vs@ALIAS_FTIME}" key="ftime" value="%{model.ftime}"  cssClass="max-length-12" required="false" />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=TchAlarminfor.ALIAS_ALARM%>
		                  </td>
			              <td>
		                           <s:textfield label="%{@vs@ALIAS_ALARM}" key="alarm" value="%{model.alarm}"  cssClass="max-length-1" required="false" />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=TchAlarminfor.ALIAS_TYPE%>
		                  </td>
			              <td>
		                           <s:textfield label="%{@vs@ALIAS_TYPE}" key="type" value="%{model.type}"  cssClass="max-length-1" required="false" />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=TchAlarminfor.ALIAS_BKLX%>
		                  </td>
			              <td>
		                           <s:textfield label="%{@vs@ALIAS_BKLX}" key="bklx" value="%{model.bklx}"  cssClass="max-length-1" required="false" />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=TchAlarminfor.ALIAS_ALARMTJ%>
		                  </td>
			              <td>
		                           <s:textfield label="%{@vs@ALIAS_ALARMTJ}" key="alarmtj" value="%{model.alarmtj}"  cssClass="max-length-1" required="false" />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=TchAlarminfor.ALIAS_ZHSJ%>
		                  </td>
			              <td>
		                           <s:textfield label="%{@vs@ALIAS_ZHSJ}" key="zhsj" value="%{model.zhsj}"  cssClass="max-length-12" required="false" />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=TchAlarminfor.ALIAS_PJDW%>
		                  </td>
			              <td>
		                           <s:textfield label="%{@vs@ALIAS_PJDW}" key="pjdw" value="%{model.pjdw}"  cssClass="max-length-40" required="false" />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=TchAlarminfor.ALIAS_CLQK%>
		                  </td>
			              <td>
		                           <s:textfield label="%{@vs@ALIAS_CLQK}" key="clqk" value="%{model.clqk}"  cssClass="max-length-200" required="false" />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=TchAlarminfor.ALIAS_PJSJ%>
		                  </td>
			              <td>
		                           <s:textfield label="%{@vs@ALIAS_PJSJ}" key="pjsj" value="%{model.pjsj}"  cssClass="max-length-12" required="false" />
		                  </td>
                          <td class="crosscolor_td">
			                      <FONT color="red">*</FONT><%=TchAlarminfor.ALIAS_BKID%>
		                  </td>
			              <td>
		                           <s:textfield label="%{@vs@ALIAS_BKID}" key="bkid" value="%{model.bkid}"  cssClass="required max-length-22" required="true" />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=TchAlarminfor.ALIAS_BKTEL%>
		                  </td>
			              <td>
		                           <s:textfield label="%{@vs@ALIAS_BKTEL}" key="bktel" value="%{model.bktel}"  cssClass="max-length-180" required="false" />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=TchAlarminfor.ALIAS_AUDIT_MARK%>
		                  </td>
			              <td>
		                           <s:textfield label="%{@vs@ALIAS_AUDIT_MARK}" key="auditMark" value="%{model.auditMark}"  cssClass="max-length-1" required="false" />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=TchAlarminfor.ALIAS_BKSJ%>
		                  </td>
			              <td>
		                           <s:textfield label="%{@vs@ALIAS_BKSJ}" key="bksj" value="%{model.bksj}"  cssClass="max-length-12" required="false" />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=TchAlarminfor.ALIAS_CZR%>
		                  </td>
			              <td>
		                           <s:textfield label="%{@vs@ALIAS_CZR}" key="czr" value="%{model.czr}"  cssClass="max-length-30" required="false" />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=TchAlarminfor.ALIAS_EMPFLAG%>
		                  </td>
			              <td>
		                           <s:textfield label="%{@vs@ALIAS_EMPFLAG}" key="empflag" value="%{model.empflag}"  cssClass="max-length-1" required="false" />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=TchAlarminfor.ALIAS_SFYX%>
		                  </td>
			              <td>
		                           <s:textfield label="%{@vs@ALIAS_SFYX}" key="sfyx" value="%{model.sfyx}"  cssClass="max-length-1" required="false" />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=TchAlarminfor.ALIAS_WXYY%>
		                  </td>
			              <td>
		                           <s:textfield label="%{@vs@ALIAS_WXYY}" key="wxyy" value="%{model.wxyy}"  cssClass="max-length-100" required="false" />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=TchAlarminfor.ALIAS_SFYZH%>
		                  </td>
			              <td>
		                           <s:textfield label="%{@vs@ALIAS_SFYZH}" key="sfyzh" value="%{model.sfyzh}"  cssClass="max-length-1" required="false" />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=TchAlarminfor.ALIAS_ZHDWMC%>
		                  </td>
			              <td>
		                           <s:textfield label="%{@vs@ALIAS_ZHDWMC}" key="zhdwmc" value="%{model.zhdwmc}"  cssClass="max-length-100" required="false" />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=TchAlarminfor.ALIAS_WZHYY%>
		                  </td>
			              <td>
		                           <s:textfield label="%{@vs@ALIAS_WZHYY}" key="wzhyy" value="%{model.wzhyy}"  cssClass="max-length-100" required="false" />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=TchAlarminfor.ALIAS_CJR%>
		                  </td>
			              <td>
		                           <s:textfield label="%{@vs@ALIAS_CJR}" key="cjr" value="%{model.cjr}"  cssClass="max-length-20" required="false" />
		                  </td>
                          <td>&nbsp;</td>
                          <td>&nbsp;</td>
                   </tr>
 
 
