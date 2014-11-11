<%@page import="com.dyneinfo.pmdd.model.*" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/commons/taglibs.jsp" %>

	<s:hidden id="xh" name="xh" />

<!-- ONGL access static field: @package.class@field or @vs@field -->

		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <FONT color="red">*</FONT><%=Shxx.ALIAS_D_NUMBER%>
		                  </td>
			              <td>
		                           <s:textfield label="%{@vs@ALIAS_D_NUMBER}" key="dnumber" value="%{model.dnumber}"  cssClass="required max-length-32" required="true" />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=Shxx.ALIAS_HTID%>
		                  </td>
			              <td>
		                           <s:textfield label="%{@vs@ALIAS_HTID}" key="htid" value="%{model.htid}"  cssClass="max-length-50" required="false" />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=Shxx.ALIAS_SHRXM%>
		                  </td>
			              <td>
		                           <s:textfield label="%{@vs@ALIAS_SHRXM}" key="shrxm" value="%{model.shrxm}"  cssClass="max-length-30" required="false" />
		                  </td>
		                   <td class="crosscolor_td">
			                      <%=Shxx.ALIAS_LXDH%>
		                  </td>
			              <td>
		                           <s:textfield label="%{@vs@ALIAS_LXDH}" key="lxdh" value="%{model.lxdh}"  cssClass="max-length-20" required="false" />
		                  </td>
		           </tr>
		           <tr class="crosscolor_tr">
		                   <td class="crosscolor_td">
			                      有效证件
		                  </td>
			              <td>
			              
			               <mytag:select property="%{model.yxzj}"   styleClass="required validate-selection"  name="yxzj"   notEmpty="false"  dictName="T_ID_NAME"/>
		                         <FONT color="red">*</FONT>
		                  </td>        
                          <td class="crosscolor_td">
			                      <%=Shxx.ALIAS_SHRSFZHM%>
		                  </td>
			              <td>
	                               <s:textfield label="%{@vs@ALIAS_SHRSFZHM}" key="shrsfzhm" id="shrsfzhm" value="%{model.shrsfzhm}"  cssClass="max-length-18 " required="false" />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                         
                          <td class="crosscolor_td">
			                      <%=Shxx.ALIAS_GZDW%>
		                  </td>
			              <td colspan="3">
	                               <s:textfield label="%{@vs@ALIAS_GZDW}" size="45" key="gzdw" value="%{model.gzdw}"  cssClass="max-length-60 validate-number" required="false" />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=Shxx.ALIAS_BZ%>
		                  </td>
			              <td>
		                           <s:textfield label="%{@vs@ALIAS_BZ}" key="bz" value="%{model.bz}"  cssClass="max-length-120" required="false" />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=Shxx.ALIAS_SHRQ%>
		                  </td>
			              <td>
						           <input value="${model.shrq}" onclick="WdatePicker({dateFmt:'yyyy-MM-dd'})" id="shrq" name="shrq"  maxlength="0" class="required Wdate" />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=Shxx.ALIAS_TDR%>
		                  </td>
			              <td>
		                           <s:textfield label="%{@vs@ALIAS_TDR}" key="tdr" value="%{model.tdr}"  cssClass="max-length-30" required="false" />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=Shxx.ALIAS_LRRQ%>
		                  </td>
			              <td>
						           <input value="${model.lrrq}" onclick="WdatePicker({dateFmt:'yyyy-MM-dd'})" id="lrrq" name="lrrq"  maxlength="0" class="required Wdate" />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=Shxx.ALIAS_OPTIME%>
		                  </td>
			              <td>
		                           <s:textfield label="%{@vs@ALIAS_OPTIME}" key="optime" value="%{model.optime}"  cssClass="max-length-17" required="false" />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=Shxx.ALIAS_DDLX%>
		                  </td>
			              <td>
						           <mytag:select property="%{model.ddlx}"   styleClass="required validate-selection"  name="ddlx"   notEmpty="false"  dictName="ddlb"/>
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=Shxx.ALIAS_SHRZP%>
		                  </td>
			              <td>
		                           <s:textfield label="%{@vs@ALIAS_SHRZP}" key="shrzp" value="%{model.shrzp}"  cssClass="" required="false" />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=Shxx.ALIAS_FLAG%>
		                  </td>
			              <td>
		                           <s:textfield label="%{@vs@ALIAS_FLAG}" key="flag" value="%{model.flag}"  cssClass="max-length-1" required="false" />
		                  </td>
                   </tr>
 
 
