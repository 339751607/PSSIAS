<%@page import="com.dyneinfo.jxy.model.*" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/commons/taglibs.jsp" %>

	<s:hidden id="enrolid" name="enrolid" />

<!-- ONGL access static field: @package.class@field or @vs@field -->
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=Tcarinfo.ALIAS_CAROWNER%>
		                  </td>
			              <td>
		                           <s:textfield label="%{@vs@ALIAS_CAROWNER}" key="carowner" value="%{model.carowner}"  cssClass="required max-length-40 validate-chinese" required="false" /><FONT color="red">*</FONT>
		                  </td>
		                   <td class="crosscolor_td">
			                      <%=Tcarinfo.ALIAS_CARID%>
		                  </td>
			              <td>
		               		  <mytag:select property="%{model.carid}"   styleClass="required validate-selection"  onchange="document.getElementById('carid').focus()" name="carid1" notEmpty="false"  dictName="cpht"/>
	                          <s:textfield label="%{@vs@ALIAS_CARID}" key="carid" value="%{model.carid}" id="KProvince" onkeyup="beKeyUp()" onblur="javascript:getOldInfo(document.getElementById('carid1').value+this.value);"  cssClass="required validate-cph" required="false" /><FONT color="red">*</FONT>
		                  </td>
		                  <div id="search_suggest" style="position:absolute;z-index:1;margin-top:4px;padding-top:20px;"></div>
		                  
		                  
                   </tr>
		           <tr class="crosscolor_tr">
		           		<td class="crosscolor_td">
			                      <%=Tcarinfo.ALIAS_CARTYPE%>
		                  </td>
			              <td>
			             			 <mytag:select property="cartype"   styleClass="required validate-selection"  name="cartype"   notEmpty="false"  dictName="cllx"/><FONT color="red">*</FONT>
		                  </td>
                          <td class="crosscolor_td">
			                      <%=Tcarinfo.ALIAS_BRAND%>
		                  </td>
			              <td>
		                           <s:textfield label="%{@vs@ALIAS_BRAND}" key="brand" value="%{model.brand}"  cssClass="max-length-50" required="false" />
		                  </td>
                         
                   </tr> 
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=Tcarinfo.ALIAS_ENGINECODE%>
		                  </td>
			              <td>
		                           <s:textfield label="%{@vs@ALIAS_ENGINECODE}" key="enginecode" value="%{model.enginecode}"  cssClass="required max-length-30" required="false" /><FONT color="red">*</FONT>
		                  </td>
		                 <td class="crosscolor_td">
			                      <%=Tcarinfo.ALIAS_BODYCODE%>
		                  </td>
			              <td>
		                           <s:textfield label="%{@vs@ALIAS_BODYCODE}" key="bodycode" value="%{model.bodycode}"  cssClass="required max-length-30" required="false" /><FONT color="red">*</FONT>
		                  </td>
                   </tr>
                    <tr class="crosscolor_tr">
               
		                 <td class="crosscolor_td">
			                      <%=Tcarinfo.ALIAS_CLSBCODE%>
		                  </td>
			              <td>
		                           <s:textfield label="%{@vs@ALIAS_BODYCODE}" key="clsbcode" value="%{model.clsbcode}"  cssClass="required max-length-30" required="false" /><FONT color="red">*</FONT>
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">

		                <td class="crosscolor_td">
			                      <%=Tcarinfo.ALIAS_COLOR%>
		                  </td>
			              <td colspan="3" class="crosscolor_td"> 
			              		<mytag:select property="%{model.color}"   styleClass="required validate-selection"  name="color1"   notEmpty="false"  dictName="csys"/><FONT color="red">*</FONT>
			              		  &nbsp;&nbsp;&nbsp;&nbsp;第一辅色:  &nbsp;&nbsp;&nbsp;&nbsp;<mytag:select property="%{model.color}"   styleClass="validate-selection"  name="color2"   notEmpty="false"  dictName="csys"/>
			              		  &nbsp;&nbsp;&nbsp;&nbsp;第二辅色:  &nbsp;&nbsp;&nbsp;&nbsp;<mytag:select property="%{model.color}"   styleClass="validate-selection"  name="color3"   notEmpty="false"  dictName="csys"/>  
		                  </td>	
		                  	                  
                   </tr>

		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td" >
			                      <%=Tcarinfo.ALIAS_CARPICTURE%>
		                  </td>
			              <td colspan="3">  
		                    <s:file name="file" style="WIDTH:300px;cursor:hand"  UNSELECTABLE="on"  id="file"
							cssClass="validate-file-png-jpg-gif-bmp" label="图片"></s:file>
		                  </td>
                   </tr>
 
 
