<%@page import="com.dyneinfo.gas.model.*" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/commons/taglibs.jsp" %>

	<s:hidden id="id" name="id" />

<!-- ONGL access static field: @package.class@field or @vs@field -->
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      处警单位
		                  </td>
			              <td>
		                           <s:textfield label="%{@vs@ALIAS_PJDW}" key="pjdw" value="%{model.pjdw}"  cssClass="required max-length-40" required="false" />
		                  </td>
		                   <td class="crosscolor_td">
			                      <%=TpersonAlarm.ALIAS_CJR%>
		                  </td>
			              <td>
		                           <s:textfield label="%{@vs@ALIAS_CJR}" key="cjr" value="%{model.cjr}"  cssClass="required max-length-20" required="false" />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
		           		 <td class="crosscolor_td">
			                      <%=TpersonAlarm.ALIAS_SFYX%><FONT color="red">*</FONT>
		                  </td>
			              <td>
			              	 <mytag:select property="%{model.sfyx}" name="sfyx" onchange="sfyxchange();"   styleClass=" required validate-selection select"  notEmpty="false"  dictName="sfzh"/>
		                  </td>
                          <td class="crosscolor_td">
			                     处警时间
		                  </td>
			              <td>
			              	<input value="${model.pjsj}" onclick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm'})" id="pjsj" name="pjsj"  maxlength="0" class="required Wdate" />
		                  </td>
                   </tr>
                    <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=TpersonAlarm.ALIAS_WXYY%>
		                  </td>
			               <td colspan="3">
			              		<s:textarea label="wxyy" name="wxyy" cols="105" rows="3"  cssClass="max-length-100" required="false"/>
		                  </td>
                   </tr>
                    <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                     抓获情况
		                  </td>
			              <td colspan="3">
			              		 <mytag:select property="%{model.zhqk}"  styleClass=" required validate-selection select"  onchange="zhqkchange();" name="zhqk"   notEmpty="false"  dictName="zhqk"/>
		                  </td>
		                  
                   </tr>
		           <tr class="crosscolor_tr">
		           			 <td class="crosscolor_td">
			                      <%=TpersonAlarm.ALIAS_ZHDWMC%>
		                  </td>
			              <td>
		                           <s:textfield label="%{@vs@ALIAS_ZHDWMC}" key="zhdwmc" value="%{model.zhdwmc}"  cssClass=" max-length-100" required="false" />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=TpersonAlarm.ALIAS_ZHSJ%>
		                  </td>
			              <td>
			              	<input value="${model.zhsj}" onclick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm'})" id="zhsj" name="zhsj"  maxlength="0" class="Wdate" />
		                  </td>
                   </tr>
                    <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=TpersonAlarm.ALIAS_WZHYY%>
		                  </td>
		                   <td colspan="3">
			              		<s:textarea label="wzhyy" name="wzhyy" cols="105" rows="3"  cssClass="max-length-2000" required="false"/>
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=TpersonAlarm.ALIAS_CLQK%>
		                  </td>
		                   <td colspan="3">
			              		<s:textarea label="clqk" name="clqk" cols="105" rows="3"  cssClass="max-length-200" required="false"/>
		                  </td>
		           </tr>

