<%@page import="com.dyneinfo.jxy.model.*" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/commons/taglibs.jsp" %>


<!-- ONGL access static field: @package.class@field or @vs@field -->

		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=Tcarcaseinfo.ALIAS_ENROLID%>
			                     
		                  </td>
			              <td>
		                	<input type="hidden" name="oldenrolid" value="${model.enrolid}"> 
		                   <s:property value="%{model.enrolid}" />
		                  </td>
                          <td class="crosscolor_td">
			                      <FONT color="red">*</FONT><%=Tcarcaseinfo.ALIAS_CREDID%>
		                  </td>
			              <td>
		                           <s:textfield label="%{@vs@ALIAS_CREDID}" key="credid" value="%{model.credid}"  cssClass="required max-length-20" required="true" />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <FONT color="red">*</FONT><%=Tcarcaseinfo.ALIAS_CREDUNIT%>
		                  </td>
			              <td>
		                           <s:textfield label="%{@vs@ALIAS_CREDUNIT}" key="credunit" value="%{model.credunit}"  cssClass="required max-length-40" required="false" />
		                  </td>
                          <td class="crosscolor_td">
			                      <FONT color="red">*</FONT><%=Tcarcaseinfo.ALIAS_PARTI%>
		                  </td>
			              <td>
			              			 <mytag:select property="%{model.parti}"   styleClass="required validate-selection"  name="parti"   notEmpty="false"  dictName="clshbw"/>
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=Tcarcaseinfo.ALIAS_PARTII%>
		                  </td>
			              <td>
			               <mytag:select property="%{model.partii}"   styleClass="validate-selection"  name="partii"   notEmpty="false"  dictName="clshbw"/>
		                  </td>
                          <td class="crosscolor_td">
			                      <%=Tcarcaseinfo.ALIAS_PARTIII%>
		                  </td>
			              <td>
			                 <mytag:select property="%{model.partiii}"   styleClass="validate-selection"  name="partiii"   notEmpty="false"  dictName="clshbw"/>
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=Tcarcaseinfo.ALIAS_REPORTER%>
		                  </td>
			              <td>
		                           <s:textfield label="%{@vs@ALIAS_REPORTER}" key="reporter" value="%{model.reporter}"  cssClass="max-length-30" required="false" />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=Tcarcaseinfo.ALIAS_REPTIME%>
		                  </td>
			              <td>
			              <input value="${model.reptime}" class="Wdate" size="20"
							onkeyup="DateFormat(this);"
							onclick="WdatePicker({startDate:'2010-01-01 00:00',dateFmt:'yyyy-MM-dd HH:mm',isShowClear:false})"
							id="reptime" name="reptime" />
		                         
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=Tcarcaseinfo.ALIAS_DEMO%>
		                  </td>
			              <td colspan="3" align="left" >
		                  <s:textarea style="margin-left: 10px" label="%{@vs@ALIAS_DEMO}" key="demo"
							value="%{model.demo}" rows="6" cols="65"
							cssClass="max-length-200" required="false" />
		                  </td>

                   </tr>

 
 
