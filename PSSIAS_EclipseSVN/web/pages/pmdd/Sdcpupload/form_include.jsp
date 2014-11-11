<%@page import="com.dyneinfo.pmdd.model.*" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/commons/taglibs.jsp" %>

	<s:hidden id="xh" name="xh" />

<!-- ONGL access static field: @package.class@field or @vs@field -->

		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=Sdcpupload.ALIAS_CITYCODE%>
		                  </td>
			              <td>
		                           <s:textfield label="%{@vs@ALIAS_CITYCODE}" key="citycode" value="%{model.citycode}"  cssClass="max-length-30" required="false" />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=Sdcpupload.ALIAS_CITYNAME%>
		                  </td>
			              <td>
		                           <s:textfield label="%{@vs@ALIAS_CITYNAME}" key="cityname" value="%{model.cityname}"  cssClass="max-length-128" required="false" />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=Sdcpupload.ALIAS_SCJS%>
		                  </td>
			              <td>
		                           <s:textfield label="%{@vs@ALIAS_SCJS}" key="scjs" value="%{model.scjs}"  cssClass="validate-integer max-value-2147483647" required="false" />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=Sdcpupload.ALIAS_WSCJS%>
		                  </td>
			              <td>
		                           <s:textfield label="%{@vs@ALIAS_WSCJS}" key="wscjs" value="%{model.wscjs}"  cssClass="validate-integer max-value-2147483647" required="false" />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=Sdcpupload.ALIAS_SCL%>
		                  </td>
			              <td>
		                           <s:textfield label="%{@vs@ALIAS_SCL}" key="scl" value="%{model.scl}"  cssClass="validate-number " required="false" />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=Sdcpupload.ALIAS_LXWSCJS%>
		                  </td>
			              <td>
		                           <s:textfield label="%{@vs@ALIAS_LXWSCJS}" key="lxwscjs" value="%{model.lxwscjs}"  cssClass="validate-integer max-value-2147483647" required="false" />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=Sdcpupload.ALIAS_TJRQ%>
		                  </td>
			              <td>
		                           <s:textfield label="%{@vs@ALIAS_TJRQ}" key="tjrq" value="%{model.tjrq}"  cssClass="max-length-8" required="false" />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=Sdcpupload.ALIAS_SCSJL%>
		                  </td>
			              <td>
		                           <s:textfield label="%{@vs@ALIAS_SCSJL}" key="scsjl" value="%{model.scsjl}"  cssClass="validate-integer max-value-2147483647" required="false" />
		                  </td>
                   </tr>
 
 
