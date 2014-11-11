<%@page import="com.dyneinfo.jxy.model.*" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/commons/taglibs.jsp" %>

	<s:hidden id="linkmanid" name="linkmanid" />

<!-- ONGL access static field: @package.class@field or @vs@field -->

		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <FONT color="red">*</FONT><%=Tlinkmaninfo.ALIAS_EMPCODE%>
		                  </td>
			              <td>
		                           <s:textfield label="%{@vs@ALIAS_EMPCODE}" key="empcode" value="%{model.empcode}"  cssClass="required max-length-26" required="true" />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=Tlinkmaninfo.ALIAS_LINKMAN%>
		                  </td>
			              <td>
	                               <s:textfield label="%{@vs@ALIAS_LINKMAN}" key="linkman" value="%{model.linkman}"  cssClass="max-length-30 validate-chinese" required="false" />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=Tlinkmaninfo.ALIAS_IDCODE%>
		                  </td>
			              <td>
	                               <s:textfield label="%{@vs@ALIAS_IDCODE}" key="idcode" value="%{model.idcode}"  cssClass="max-length-18 validate-id-number" required="false" />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=Tlinkmaninfo.ALIAS_SEX%>
		                  </td>
			              <td>
						           <mytag:select property="%{model.sex}"   styleClass="required validate-selection"  name="sex"   notEmpty="false"  dictName="T_DIC_SEX"/>
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=Tlinkmaninfo.ALIAS_JOBORDWELL%>
		                  </td>
			              <td>
		                           <s:textfield label="%{@vs@ALIAS_JOBORDWELL}" key="jobordwell" value="%{model.jobordwell}"  cssClass="max-length-100" required="false" />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=Tlinkmaninfo.ALIAS_COMMADDRESS%>
		                  </td>
			              <td>
		                           <s:textfield label="%{@vs@ALIAS_COMMADDRESS}" key="commaddress" value="%{model.commaddress}"  cssClass="max-length-100" required="false" />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=Tlinkmaninfo.ALIAS_PHONE%>
		                  </td>
			              <td>
		                           <s:textfield label="%{@vs@ALIAS_PHONE}" key="phone" value="%{model.phone}"  cssClass="max-length-20" required="false" />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=Tlinkmaninfo.ALIAS_RELATION%>
		                  </td>
			              <td>
		                           <s:textfield label="%{@vs@ALIAS_RELATION}" key="relation" value="%{model.relation}"  cssClass="max-length-20" required="false" />
		                  </td>
                   </tr>
 
 
