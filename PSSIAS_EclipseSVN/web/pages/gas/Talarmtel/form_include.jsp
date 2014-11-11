<%@page import="com.dyneinfo.gas.model.*" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/commons/taglibs.jsp" %>

	<s:hidden id="deptcode" name="deptcode" />
	<s:hidden id="deptname" name="deptname" />
<!-- ONGL access static field: @package.class@field or @vs@field -->

		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=Talarmtel.ALIAS_DEPTNAME%>
		                  </td>
			              <td>
		                     <mytag:select property="%{model.exitend1}"    name="exitend1" onchange="deptnamechange();"   notEmpty="false" styleClass="required validate-selection" dictName="teHangDwbm"/>
		                  
		                  </td>
                          <td class="crosscolor_td">
			                      <%=Talarmtel.ALIAS_ALARMALL%>
		                  </td>
			              <td>
			              	<mytag:select property="%{model.alarmall}"    name="alarmall"   notEmpty="false" styleClass="required validate-selection" dictName="shiFou"/>
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <FONT color="red">*</FONT><%=Talarmtel.ALIAS_ALARMTEL%>
		                  </td>
			              <td>
		                           <s:textfield label="%{@vs@ALIAS_ALARMTEL}" key="alarmtel"   value="%{model.alarmtel}"  cssClass="required max-length-200" onkeyup="value=value.replace(/[^\d/-]/g,'')" required="true" />
		                 （多电话请用"/"隔开）
		                  </td>
                          <td class="crosscolor_td">
		                  </td>
			              <td>
		                  </td>
                   </tr>
 
 
 <script>
 function deptnamechange(){
	var deptname = document.getElementsByName('exitend1')[0].options[document.getElementsByName('exitend1')[0].selectedIndex].text;
	 document.getElementById("deptname").value=deptname;
}
 </script>
