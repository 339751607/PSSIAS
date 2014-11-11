<%@page import="com.dyneinfo.zazh.model.*" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/commons/taglibs.jsp" %>

	<s:hidden id="id" name="id" />

<!-- ONGL access static field: @package.class@field or @vs@field -->

		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=TalarmPerson.ALIAS_BKID%>
		                  </td>
			              <td>
		                           <s:textfield label="%{@vs@ALIAS_BKID}" key="bkid" value="%{model.bkid}"  cssClass="max-length-21" required="false" />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=TalarmPerson.ALIAS_BKTYPE%>
		                  </td>
			              <td>
		                           <s:textfield label="%{@vs@ALIAS_BKTYPE}" key="bktype" value="%{model.bktype}"  cssClass="max-length-1" required="false" />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=TalarmPerson.ALIAS_SID%>
		                  </td>
			              <td>
		                           <s:textfield label="%{@vs@ALIAS_SID}" key="sid" value="%{model.sid}"  cssClass="max-length-30" required="false" />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=TalarmPerson.ALIAS_ALARMTIME%>
		                  </td>
			              <td>
		                           <s:textfield label="%{@vs@ALIAS_ALARMTIME}" key="alarmtime" value="%{model.alarmtime}"  cssClass="max-length-12" required="false" />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=TalarmPerson.ALIAS_ALARMSOURCE%>
		                  </td>
			              <td>
		                           <s:textfield label="%{@vs@ALIAS_ALARMSOURCE}" key="alarmsource" value="%{model.alarmsource}"  cssClass="max-length-3" required="false" />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=TalarmPerson.ALIAS_ALARMTYPE%>
		                  </td>
			              <td>
		                           <s:textfield label="%{@vs@ALIAS_ALARMTYPE}" key="alarmtype" value="%{model.alarmtype}"  cssClass="max-length-1" required="false" />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=TalarmPerson.ALIAS_BUSINESSTYPE%>
		                  </td>
			              <td>
		                           <s:textfield label="%{@vs@ALIAS_BUSINESSTYPE}" key="businesstype" value="%{model.businesstype}"  cssClass="max-length-2" required="false" />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=TalarmPerson.ALIAS_BUSINESSTIME%>
		                  </td>
			              <td>
		                           <s:textfield label="%{@vs@ALIAS_BUSINESSTIME}" key="businesstime" value="%{model.businesstime}"  cssClass="max-length-12" required="false" />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=TalarmPerson.ALIAS_CPCODE%>
		                  </td>
			              <td>
		                           <s:textfield label="%{@vs@ALIAS_CPCODE}" key="cpcode" value="%{model.cpcode}"  cssClass="max-length-13" required="false" />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=TalarmPerson.ALIAS_NAME%>
		                  </td>
			              <td>
		                           <s:textfield label="%{@vs@ALIAS_NAME}" key="name" value="%{model.name}"  cssClass="max-length-30" required="false" />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=TalarmPerson.ALIAS_SEX%>
		                  </td>
			              <td>
		                           <s:textfield label="%{@vs@ALIAS_SEX}" key="sex" value="%{model.sex}"  cssClass="max-length-1" required="false" />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=TalarmPerson.ALIAS_NATION%>
		                  </td>
			              <td>
		                           <s:textfield label="%{@vs@ALIAS_NATION}" key="nation" value="%{model.nation}"  cssClass="max-length-2" required="false" />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=TalarmPerson.ALIAS_BDATE%>
		                  </td>
			              <td>
		                           <s:textfield label="%{@vs@ALIAS_BDATE}" key="bdate" value="%{model.bdate}"  cssClass="max-length-8" required="false" />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=TalarmPerson.ALIAS_IDNAME%>
		                  </td>
			              <td>
		                           <s:textfield label="%{@vs@ALIAS_IDNAME}" key="idname" value="%{model.idname}"  cssClass="max-length-2" required="false" />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=TalarmPerson.ALIAS_IDCODE%>
		                  </td>
			              <td>
		                           <s:textfield label="%{@vs@ALIAS_IDCODE}" key="idcode" value="%{model.idcode}"  cssClass="max-length-18" required="false" />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=TalarmPerson.ALIAS_HJD%>
		                  </td>
			              <td>
		                           <s:textfield label="%{@vs@ALIAS_HJD}" key="hjd" value="%{model.hjd}"  cssClass="max-length-6" required="false" />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=TalarmPerson.ALIAS_ADDRESS%>
		                  </td>
			              <td>
		                           <s:textfield label="%{@vs@ALIAS_ADDRESS}" key="address" value="%{model.address}"  cssClass="max-length-200" required="false" />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=TalarmPerson.ALIAS_CLFLAG%>
		                  </td>
			              <td>
		                           <s:textfield label="%{@vs@ALIAS_CLFLAG}" key="clflag" value="%{model.clflag}"  cssClass="max-length-1" required="false" />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=TalarmPerson.ALIAS_CJDW%>
		                  </td>
			              <td>
		                           <s:textfield label="%{@vs@ALIAS_CJDW}" key="cjdw" value="%{model.cjdw}"  cssClass="max-length-40" required="false" />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=TalarmPerson.ALIAS_CJR%>
		                  </td>
			              <td>
		                           <s:textfield label="%{@vs@ALIAS_CJR}" key="cjr" value="%{model.cjr}"  cssClass="max-length-30" required="false" />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=TalarmPerson.ALIAS_CJSJ%>
		                  </td>
			              <td>
		                           <s:textfield label="%{@vs@ALIAS_CJSJ}" key="cjsj" value="%{model.cjsj}"  cssClass="max-length-12" required="false" />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=TalarmPerson.ALIAS_VALIDFLAG%>
		                  </td>
			              <td>
		                           <s:textfield label="%{@vs@ALIAS_VALIDFLAG}" key="validflag" value="%{model.validflag}"  cssClass="max-length-1" required="false" />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=TalarmPerson.ALIAS_VOIDCAUSE%>
		                  </td>
			              <td>
		                           <s:textfield label="%{@vs@ALIAS_VOIDCAUSE}" key="voidcause" value="%{model.voidcause}"  cssClass="max-length-100" required="false" />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=TalarmPerson.ALIAS_ZHFLAG%>
		                  </td>
			              <td>
		                           <s:textfield label="%{@vs@ALIAS_ZHFLAG}" key="zhflag" value="%{model.zhflag}"  cssClass="max-length-1" required="false" />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=TalarmPerson.ALIAS_ZHDW%>
		                  </td>
			              <td>
		                           <s:textfield label="%{@vs@ALIAS_ZHDW}" key="zhdw" value="%{model.zhdw}"  cssClass="max-length-40" required="false" />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=TalarmPerson.ALIAS_ZHSJ%>
		                  </td>
			              <td>
		                           <s:textfield label="%{@vs@ALIAS_ZHSJ}" key="zhsj" value="%{model.zhsj}"  cssClass="max-length-12" required="false" />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=TalarmPerson.ALIAS_WZHYY%>
		                  </td>
			              <td>
		                           <s:textfield label="%{@vs@ALIAS_WZHYY}" key="wzhyy" value="%{model.wzhyy}"  cssClass="max-length-100" required="false" />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=TalarmPerson.ALIAS_CLQK%>
		                  </td>
			              <td>
		                           <s:textfield label="%{@vs@ALIAS_CLQK}" key="clqk" value="%{model.clqk}"  cssClass="max-length-200" required="false" />
		                  </td>
                   </tr>
 
 
