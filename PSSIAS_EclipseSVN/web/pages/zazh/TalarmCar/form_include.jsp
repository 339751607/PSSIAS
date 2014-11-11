<%@page import="com.dyneinfo.zazh.model.*" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/commons/taglibs.jsp" %>

	<s:hidden id="id" name="id" />

<!-- ONGL access static field: @package.class@field or @vs@field -->

		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=TalarmCar.ALIAS_BKID%>
		                  </td>
			              <td>
		                           <s:textfield label="%{@vs@ALIAS_BKID}" key="bkid" value="%{model.bkid}"  cssClass="max-length-21" required="false" />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=TalarmCar.ALIAS_BKTYPE%>
		                  </td>
			              <td>
		                           <s:textfield label="%{@vs@ALIAS_BKTYPE}" key="bktype" value="%{model.bktype}"  cssClass="max-length-1" required="false" />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=TalarmCar.ALIAS_SID%>
		                  </td>
			              <td>
		                           <s:textfield label="%{@vs@ALIAS_SID}" key="sid" value="%{model.sid}"  cssClass="max-length-30" required="false" />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=TalarmCar.ALIAS_ALARMTIME%>
		                  </td>
			              <td>
		                           <s:textfield label="%{@vs@ALIAS_ALARMTIME}" key="alarmtime" value="%{model.alarmtime}"  cssClass="max-length-12" required="false" />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=TalarmCar.ALIAS_ALARMSOURCE%>
		                  </td>
			              <td>
		                           <s:textfield label="%{@vs@ALIAS_ALARMSOURCE}" key="alarmsource" value="%{model.alarmsource}"  cssClass="max-length-3" required="false" />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=TalarmCar.ALIAS_ALARMTYPE%>
		                  </td>
			              <td>
		                           <s:textfield label="%{@vs@ALIAS_ALARMTYPE}" key="alarmtype" value="%{model.alarmtype}"  cssClass="max-length-1" required="false" />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=TalarmCar.ALIAS_BUSINESSTYPE%>
		                  </td>
			              <td>
		                           <s:textfield label="%{@vs@ALIAS_BUSINESSTYPE}" key="businesstype" value="%{model.businesstype}"  cssClass="max-length-2" required="false" />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=TalarmCar.ALIAS_BUSINESSTIME%>
		                  </td>
			              <td>
		                           <s:textfield label="%{@vs@ALIAS_BUSINESSTIME}" key="businesstime" value="%{model.businesstime}"  cssClass="max-length-12" required="false" />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=TalarmCar.ALIAS_CPCODE%>
		                  </td>
			              <td>
		                           <s:textfield label="%{@vs@ALIAS_CPCODE}" key="cpcode" value="%{model.cpcode}"  cssClass="max-length-13" required="false" />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=TalarmCar.ALIAS_CAROWNER%>
		                  </td>
			              <td>
		                           <s:textfield label="%{@vs@ALIAS_CAROWNER}" key="carowner" value="%{model.carowner}"  cssClass="max-length-40" required="false" />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=TalarmCar.ALIAS_CARTYPE%>
		                  </td>
			              <td>
		                           <s:textfield label="%{@vs@ALIAS_CARTYPE}" key="cartype" value="%{model.cartype}"  cssClass="max-length-2" required="false" />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=TalarmCar.ALIAS_BRAND%>
		                  </td>
			              <td>
		                           <s:textfield label="%{@vs@ALIAS_BRAND}" key="brand" value="%{model.brand}"  cssClass="max-length-60" required="false" />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=TalarmCar.ALIAS_CARMODE%>
		                  </td>
			              <td>
		                           <s:textfield label="%{@vs@ALIAS_CARMODE}" key="carmode" value="%{model.carmode}"  cssClass="max-length-30" required="false" />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=TalarmCar.ALIAS_COLOR%>
		                  </td>
			              <td>
		                           <s:textfield label="%{@vs@ALIAS_COLOR}" key="color" value="%{model.color}"  cssClass="max-length-3" required="false" />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=TalarmCar.ALIAS_CARID%>
		                  </td>
			              <td>
		                           <s:textfield label="%{@vs@ALIAS_CARID}" key="carid" value="%{model.carid}"  cssClass="max-length-15" required="false" />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=TalarmCar.ALIAS_ENGINECODE%>
		                  </td>
			              <td>
		                           <s:textfield label="%{@vs@ALIAS_ENGINECODE}" key="enginecode" value="%{model.enginecode}"  cssClass="max-length-30" required="false" />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=TalarmCar.ALIAS_BODYCODE%>
		                  </td>
			              <td>
		                           <s:textfield label="%{@vs@ALIAS_BODYCODE}" key="bodycode" value="%{model.bodycode}"  cssClass="max-length-30" required="false" />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=TalarmCar.ALIAS_CLFLAG%>
		                  </td>
			              <td>
		                           <s:textfield label="%{@vs@ALIAS_CLFLAG}" key="clflag" value="%{model.clflag}"  cssClass="max-length-1" required="false" />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=TalarmCar.ALIAS_CJDW%>
		                  </td>
			              <td>
		                           <s:textfield label="%{@vs@ALIAS_CJDW}" key="cjdw" value="%{model.cjdw}"  cssClass="max-length-40" required="false" />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=TalarmCar.ALIAS_CJR%>
		                  </td>
			              <td>
		                           <s:textfield label="%{@vs@ALIAS_CJR}" key="cjr" value="%{model.cjr}"  cssClass="max-length-30" required="false" />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=TalarmCar.ALIAS_CJSJ%>
		                  </td>
			              <td>
		                           <s:textfield label="%{@vs@ALIAS_CJSJ}" key="cjsj" value="%{model.cjsj}"  cssClass="max-length-12" required="false" />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=TalarmCar.ALIAS_VALIDFLAG%>
		                  </td>
			              <td>
		                           <s:textfield label="%{@vs@ALIAS_VALIDFLAG}" key="validflag" value="%{model.validflag}"  cssClass="max-length-1" required="false" />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=TalarmCar.ALIAS_VOIDCAUSE%>
		                  </td>
			              <td>
		                           <s:textfield label="%{@vs@ALIAS_VOIDCAUSE}" key="voidcause" value="%{model.voidcause}"  cssClass="max-length-100" required="false" />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=TalarmCar.ALIAS_ZHFLAG%>
		                  </td>
			              <td>
		                           <s:textfield label="%{@vs@ALIAS_ZHFLAG}" key="zhflag" value="%{model.zhflag}"  cssClass="max-length-1" required="false" />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=TalarmCar.ALIAS_ZHDW%>
		                  </td>
			              <td>
		                           <s:textfield label="%{@vs@ALIAS_ZHDW}" key="zhdw" value="%{model.zhdw}"  cssClass="max-length-40" required="false" />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=TalarmCar.ALIAS_ZHSJ%>
		                  </td>
			              <td>
		                           <s:textfield label="%{@vs@ALIAS_ZHSJ}" key="zhsj" value="%{model.zhsj}"  cssClass="max-length-12" required="false" />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=TalarmCar.ALIAS_WZHYY%>
		                  </td>
			              <td>
		                           <s:textfield label="%{@vs@ALIAS_WZHYY}" key="wzhyy" value="%{model.wzhyy}"  cssClass="max-length-100" required="false" />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=TalarmCar.ALIAS_CLQK%>
		                  </td>
			              <td>
		                           <s:textfield label="%{@vs@ALIAS_CLQK}" key="clqk" value="%{model.clqk}"  cssClass="max-length-200" required="false" />
		                  </td>
                   </tr>
 
 
