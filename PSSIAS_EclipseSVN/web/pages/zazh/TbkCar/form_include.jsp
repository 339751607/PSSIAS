<%@page import="com.dyneinfo.zazh.model.*" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/commons/taglibs.jsp" %>
<%
String picCount = "";
 if(request.getAttribute("picCount") != null)
       picCount= (String)request.getAttribute("picCount");

%>
	<s:hidden id="id" name="id" />

<!-- ONGL access static field: @package.class@field or @vs@field -->
						
				   <tr class="tb_title">
                          <td class="crosscolor_td"  colspan="5">
			                 <div align="left"> 
			                      车辆信息
			                 </div>  
		                  </td>                
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td" width="20%">
			                      <%=TbkCar.ALIAS_CARCODE%>
		                  </td>
			              <td width="25%">
			               <mytag:select  name="prefix"   
	         			             value="${model.prefix}" dictName="cpht"/>			                       
		                           <s:textfield label="%{@vs@ALIAS_CARCODE}" key="carcode" value="%{model.carcode}"  cssClass=" max-length-8" required="false" />
		                  </td>
                          <td class="crosscolor_td" width="20%">
			                      <%=TbkCar.ALIAS_BODYCODE%>
		                  </td>
			              <td width="25%">
		                           <s:textfield label="%{@vs@ALIAS_BODYCODE}" key="bodycode" value="%{model.bodycode}"  cssClass=" max-length-30" required="false" />
		                  </td>
		                  <td rowspan="7" width="10%">
		                       <%if(picCount != null && picCount.equals("1")) { %>
						             <img src='${ctx}/pages/zazh/TbkCar/showPic.do?bkid=<s:property value="%{model.id}" />' height="150" alt="照片" width="120" border="0" name="photo"> 	
						           <% } else {%>
						           <IMG src="${ctx}/images/spacer.gif" height="150" alt="照片" width="120" border="0" name="photo">
						           <%} %>
		                           <s:file name="file" style="WIDTH:130px;cursor:hand"  UNSELECTABLE="on"  id="file"
							cssClass="validate-file-png-jpg-gif-bmp" label="图片"></s:file>                   
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=TbkCar.ALIAS_ENGINECODE%>
		                  </td>
			              <td>
		                           <s:textfield label="%{@vs@ALIAS_ENGINECODE}" key="enginecode" value="%{model.enginecode}"  cssClass="max-length-30" required="false" />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=TbkCar.ALIAS_CARTYPE%>
		                  </td>
			              <td >
			                    <mytag:select  name="cartype"    styleClass="required validate-selection"
	         			             value="${model.cartype}" dictName="cllx"/>
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=TbkCar.ALIAS_BRAND%>
		                  </td>
			              <td>
		                           <s:textfield label="%{@vs@ALIAS_BRAND}" key="brand" value="%{model.brand}"  cssClass="max-length-10" required="false" />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=TbkCar.ALIAS_CARMODE%>
		                  </td>
			              <td >
		                           <s:textfield label="%{@vs@ALIAS_CARMODE}" key="carmode" value="%{model.carmode}"  cssClass="max-length-30" required="false" />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=TbkCar.ALIAS_COLOR%>
		                  </td>
			              <td>
			                 <mytag:select  name="color"    styleClass="required validate-selection"
	         			             value="${model.color}" dictName="csys"/>
		                  </td>
                          <td class="crosscolor_td">
			                      <%=TbkCar.ALIAS_CAROWNER%>
		                  </td>
			              <td >
		                           <s:textfield label="%{@vs@ALIAS_CAROWNER}" key="carowner" value="%{model.carowner}"  cssClass="required max-length-40" required="false" />
		                           <FONT color="red">*</FONT>
		                  </td>
                   </tr>
                   <tr>
						<td colspan="4" class="tb_title"> 
						         <div align="left"> 
									布控信息
								</div>
					    </td>
				   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=TbkCar.ALIAS_BKPZR%>
		                  </td>
			              <td>
		                           <s:textfield label="%{@vs@ALIAS_BKPZR}" key="bkpzr" value="%{model.bkpzr}"  cssClass="max-length-30" required="false" />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=TbkCar.ALIAS_BKLX%>
		                  </td>
			              <td >
		                            <mytag:select  name="bklx"    styleClass="required validate-selection"
	         			             value="${model.bklx}" dictName="DIC_ITEM_BKLX"/>
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                           
		                   <td class="crosscolor_td">
			                      <%=TbkCar.ALIAS_OPERATOR%>
		                  </td>
			              <td>
			                      <s:property value="#request.userxm"/>

		                  </td>
		                  <td class="crosscolor_td">
			                     <%=TbkCar.ALIAS_BKDW%>
		                  </td>
			              <td >
			                  <s:property value="#request.deptname"/>		                          
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                         
                          <td class="crosscolor_td">
			                      <%=TbkCar.ALIAS_ALARMTEL%>
		                  </td>
			              <td  colspan="4">
		                              <s:textarea label="%{@vs@ALIAS_ALARM_TEL}" key="alarmtel"  cssClass="required max-length-80" required="false"
									value="%{model.alarmtel}" rows="3" cols="50"></s:textarea><FONT color="red">*(多个电话用“/”分割）</FONT>
                          
		                  </td>

                   </tr>
		           <tr class="crosscolor_tr">

		                   <td class="crosscolor_td">
			                      <%=TbkCar.ALIAS_JYAQ%>
		                  </td>
			              <td colspan="4">
		                           
		                           <s:textarea label="%{@vs@ALIAS_JYAQ}" key="jyaq"  cssClass="required max-length-255" required="false"
									value="%{model.jyaq}" rows="6" cols="60"></s:textarea><FONT color="red">*</FONT>
		                  </td>
		                  <!-- 
                          <td class="crosscolor_td">
			                      <%=TbkCar.ALIAS_CANCELFLAG%>
		                  </td>
			              <td>
		                           <s:textfield label="%{@vs@ALIAS_CANCELFLAG}" key="cancelflag" value="%{model.cancelflag}"  cssClass="max-length-1" required="false" />
		                  </td>
		                   -->
                   </tr>
                   <!--  
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=TbkCar.ALIAS_CANCELTIME%>
		                  </td>
			              <td>
		                           <s:textfield label="%{@vs@ALIAS_CANCELTIME}" key="canceltime" value="%{model.canceltime}"  cssClass="max-length-12" required="false" />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=TbkCar.ALIAS_CANCELCAUSE%>
		                  </td>
			              <td>
		                           <s:textfield label="%{@vs@ALIAS_CANCELCAUSE}" key="cancelcause" value="%{model.cancelcause}"  cssClass="max-length-200" required="false" />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=TbkCar.ALIAS_CANCELNAME%>
		                  </td>
			              <td>
		                           <s:textfield label="%{@vs@ALIAS_CANCELNAME}" key="cancelname" value="%{model.cancelname}"  cssClass="max-length-30" required="false" />
		                  </td>
                          <td>&nbsp;</td>
                          <td>&nbsp;</td>
                   </tr>
                   -->
 
