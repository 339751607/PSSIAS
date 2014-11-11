<%@page import="com.dyneinfo.fjy.model.*" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/commons/taglibs.jsp" %>

	<s:hidden id="xh" name="xh" />

<!-- ONGL access static field: @package.class@field or @vs@field -->

		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=Tesdnxs.ALIAS_DNID%>
		                  </td>
			              <td>
		                           <s:textfield label="%{@vs@ALIAS_DNID}" key="dnid" value="%{model.dnid}"  cssClass="max-length-12" required="false" />
		                  </td>
                          <td class="crosscolor_td">
			                      <FONT color="red">*</FONT><%=Tesdnxs.ALIAS_GMRXM%>
		                  </td>
			              <td>
	                               <s:textfield label="%{@vs@ALIAS_GMRXM}" key="gmrxm" value="%{model.gmrxm}"  cssClass="required max-length-30 validate-chinese" required="true" />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <FONT color="red">*</FONT><%=Tesdnxs.ALIAS_GMRXB%>
		                  </td>
			              <td>
						           <mytag:select property="%{model.gmrxb}"   styleClass="required validate-selection"  name="gmrxb"   notEmpty="false"  dictName="T_DIC_SEX"/>
		                  </td>
                          <td class="crosscolor_td">
			                      <%=Tesdnxs.ALIAS_GMRSFZH%>
		                  </td>
			              <td>
	                               <s:textfield label="%{@vs@ALIAS_GMRSFZH}" key="gmrsfzh" value="%{model.gmrsfzh}"  cssClass="max-length-18 validate-chinese" required="false" />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <FONT color="red">*</FONT><%=Tesdnxs.ALIAS_GMRLXDH%>
		                  </td>
			              <td>
	                               <s:textfield label="%{@vs@ALIAS_GMRLXDH}" key="gmrlxdh" value="%{model.gmrlxdh}"  cssClass="required max-length-30 validate-number" required="true" />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=Tesdnxs.ALIAS_GMRJTZZ%>
		                  </td>
			              <td>
		                           <s:textfield label="%{@vs@ALIAS_GMRJTZZ}" key="gmrjtzz" value="%{model.gmrjtzz}"  cssClass="max-length-100" required="false" />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <FONT color="red">*</FONT><%=Tesdnxs.ALIAS_JBR%>
		                  </td>
			              <td>
		                           <s:textfield label="%{@vs@ALIAS_JBR}" key="jbr" value="%{model.jbr}"  cssClass="required max-length-30" required="true" />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=Tesdnxs.ALIAS_BZ%>
		                  </td>
			              <td>
		                           <s:textfield label="%{@vs@ALIAS_BZ}" key="bz" value="%{model.bz}"  cssClass="max-length-200" required="false" />
		                  </td>
                   </tr>
 
 
