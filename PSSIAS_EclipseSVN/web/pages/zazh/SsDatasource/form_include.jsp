<%@page import="com.dyneinfo.zazh.model.*" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/commons/taglibs.jsp" %>

	<s:hidden id="id" name="id" />

<!-- ONGL access static field: @package.class@field or @vs@field -->

		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=SsDatasource.ALIAS_CODE%>
		                  </td>
			              <td>
			                   <mytag:select property="%{model.code}"   styleClass="required validate-selection" 
			                    name="code"   notEmpty="false" onchange="javascript: changeBusiness()" dictName="T_ITEM_BUSSINESS"/>
		                  
		                  </td>
                          <td class="crosscolor_td">
			                      <%=SsDatasource.ALIAS_CALLED%>
		                  </td>
			              <td>     
			                      <s:textfield label="%{@vs@ALIAS_CALLED}" key="hidden_called" value="%{model.called}"  disabled="true"  />
		                          <s:hidden label="%{@vs@ALIAS_CALLED}" key="called" value="%{model.called}"   />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">		                  
                          <td class="crosscolor_td">
			                      <%=SsDatasource.ALIAS_DBS_DRIVERCLASSNAME%>
		                  </td>
			              <td>
		                           <s:textfield label="%{@vs@ALIAS_DBS_DRIVERCLASSNAME}" key="dbsDriverclassname" value="%{model.dbsDriverclassname}"  cssClass="max-length-100" size="30" required="false" />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=SsDatasource.ALIAS_DBS_URL%>
		                  </td>
			              <td>
		                           <s:textfield label="%{@vs@ALIAS_DBS_URL}" key="dbsUrl" value="%{model.dbsUrl}"  cssClass="max-length-100" required="false" />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=SsDatasource.ALIAS_DBS_USERNAME%>
		                  </td>
			              <td>
		                           <s:textfield label="%{@vs@ALIAS_DBS_USERNAME}" key="dbsUsername" value="%{model.dbsUsername}"  cssClass="max-length-100" required="false" />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=SsDatasource.ALIAS_DBS_PASSWORD%>
		                  </td>
			              <td>
		                           <s:textfield label="%{@vs@ALIAS_DBS_PASSWORD}" key="dbsPassword" value="%{model.dbsPassword}"  cssClass="max-length-100" required="false" />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">

                          <td class="crosscolor_td">
			                      <%=SsDatasource.ALIAS_ISVALID%>
		                  </td>
			              <td>
			                 <mytag:select property="%{model.isvalid}"   styleClass="required validate-selection"  name="isvalid"   notEmpty="false"  dictName="T_DICT_VALID"/>
		                  </td>
                   </tr>
                   <!--  
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=SsDatasource.ALIAS_EXTEND1%>
		                  </td>
			              <td>
		                           <s:textfield label="%{@vs@ALIAS_EXTEND1}" key="extend1" value="%{model.extend1}"  cssClass="max-length-100" required="false" />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=SsDatasource.ALIAS_EXTEND2%>
		                  </td>
			              <td>
		                           <s:textfield label="%{@vs@ALIAS_EXTEND2}" key="extend2" value="%{model.extend2}"  cssClass="max-length-100" required="false" />
		                  </td>
                   </tr>
                  -->
 
<script>
	function changeBusiness(){
	   var bs = document.getElementById("code");
	   var calledObj = document.getElementById("called");
	   var called_hid_Obj = document.getElementById("hidden_called");
	   calledObj.value=bs.options[bs.selectedIndex].text;
	   called_hid_Obj.value=bs.options[bs.selectedIndex].text;
	}
	
</script>