<%@page import="com.dyneinfo.pmdd.model.*" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/commons/taglibs.jsp" %>


<!-- ONGL access static field: @package.class@field or @vs@field -->

		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=Cyry.ALIAS_XM%>
		                  </td>
			              <td>
		                           <s:textfield label="%{@vs@ALIAS_XM}" key="xm" value="%{model.xm}"  cssClass="max-length-30" required="false" />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=Cyry.ALIAS_XB%>
		                  </td>
			              <td>
						           <mytag:select property="%{model.xb}"   styleClass="required validate-selection"  name="xb"   notEmpty="false"  dictName="gender"/>
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <FONT color="red">*</FONT><%=Cyry.ALIAS_DWBM%>
		                  </td>
			              <td>
		                           <s:textfield label="%{@vs@ALIAS_DWBM}" key="dwbm" value="%{model.dwbm}"  cssClass="required max-length-10" required="true" />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=Cyry.ALIAS_GMSFHM%>
		                  </td>
			              <td>
	                               <s:textfield label="%{@vs@ALIAS_GMSFHM}" key="gmsfhm" value="%{model.gmsfhm}"  cssClass="max-length-18 validate-id-number" required="false" />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <FONT color="red">*</FONT><%=Cyry.ALIAS_DWNBM%>
		                  </td>
			              <td>
		                           <s:textfield label="%{@vs@ALIAS_DWNBM}" key="dwnbm" value="%{model.dwnbm}"  cssClass="required max-length-4" required="true" />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=Cyry.ALIAS_BIRTHDAY%>
		                  </td>
			              <td>
						           <input value="${model.birthday}" onclick="WdatePicker({dateFmt:'yyyy-MM-dd'})" id="birthday" name="birthday"  maxlength="0" class="required Wdate" />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=Cyry.ALIAS_ZZ%>
		                  </td>
			              <td>
		                           <s:textfield label="%{@vs@ALIAS_ZZ}" key="zz" value="%{model.zz}"  cssClass="max-length-120" required="false" />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=Cyry.ALIAS_HKSZD%>
		                  </td>
			              <td>
		                           <s:textfield label="%{@vs@ALIAS_HKSZD}" key="hkszd" value="%{model.hkszd}"  cssClass="max-length-120" required="false" />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=Cyry.ALIAS_WHCD%>
		                  </td>
			              <td>
						           <mytag:select property="%{model.whcd}"   styleClass="required validate-selection"  name="whcd"   notEmpty="false"  dictName="educations"/>
		                  </td>
                          <td class="crosscolor_td">
			                      <%=Cyry.ALIAS_GZLX%>
		                  </td>
			              <td>
						           <mytag:select property="%{model.gzlx}"   styleClass="required validate-selection"  name="gzlx"   notEmpty="false"  dictName="gzlx"/>
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=Cyry.ALIAS_RZRQ%>
		                  </td>
			              <td>
						           <input value="${model.rzrq}" onclick="WdatePicker({dateFmt:'yyyy-MM-dd'})" id="rzrq" name="rzrq"  maxlength="0" class="required Wdate" />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=Cyry.ALIAS_FLAG%>
		                  </td>
			              <td>
						           <mytag:select property="%{model.flag}"   styleClass="required validate-selection"  name="flag"   notEmpty="false"  dictName="cyryFlag"/>
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=Cyry.ALIAS_LZRQ%>
		                  </td>
			              <td>
						           <input value="${model.lzrq}" onclick="WdatePicker({dateFmt:'yyyy-MM-dd'})" id="lzrq" name="lzrq"  maxlength="0" class="required Wdate" />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=Cyry.ALIAS_TIB_FLOWGUID%>
		                  </td>
			              <td>
		                           <s:textfield label="%{@vs@ALIAS_TIB_FLOWGUID}" key="tibFlowguid" value="%{model.tibFlowguid}"  cssClass="max-length-32" required="false" />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=Cyry.ALIAS_TIB_ROWGUID%>
		                  </td>
			              <td>
		                           <s:textfield label="%{@vs@ALIAS_TIB_ROWGUID}" key="tibRowguid" value="%{model.tibRowguid}"  cssClass="max-length-32" required="false" />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=Cyry.ALIAS_ZZZH%>
		                  </td>
			              <td>
		                           <s:textfield label="%{@vs@ALIAS_ZZZH}" key="zzzh" value="%{model.zzzh}"  cssClass="max-length-16" required="false" />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=Cyry.ALIAS_ZZDZ%>
		                  </td>
			              <td>
		                           <s:textfield label="%{@vs@ALIAS_ZZDZ}" key="zzdz" value="%{model.zzdz}"  cssClass="max-length-120" required="false" />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=Cyry.ALIAS_ZZMM%>
		                  </td>
			              <td>
						           <mytag:select property="%{model.zzmm}"   styleClass="required validate-selection"  name="zzmm"   notEmpty="false"  dictName="partyvisage"/>
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=Cyry.ALIAS_ZAPXZ_ID%>
		                  </td>
			              <td>
		                           <s:textfield label="%{@vs@ALIAS_ZAPXZ_ID}" key="zapxzId" value="%{model.zapxzId}"  cssClass="max-length-30" required="false" />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=Cyry.ALIAS_ZZJGBH%>
		                  </td>
			              <td>
		                           <s:textfield label="%{@vs@ALIAS_ZZJGBH}" key="zzjgbh" value="%{model.zzjgbh}"  cssClass="max-length-32" required="false" />
		                  </td>
                   </tr>
 
 
