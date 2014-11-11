<%@page import="com.dyneinfo.fjy.model.*" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/commons/taglibs.jsp" %>
<%
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+request.getContextPath()+"/";
String  picCount ="";
 if ( request.getAttribute("picCount") != null)
     picCount = (String)request.getAttribute("picCount");
%>
<html>

<head>
	<%@ include file="/commons/meta.jsp" %>
	<base href="<%=basePath%>">
	<title><%=Temployee.TABLE_ALIAS%>信息</title>
</head>

<body>
<%@ include file="/commons/messages.jsp" %>

<s:form action="/pages/fjy/Temployee/list.do" method="get" theme="simple">
	<s:hidden name="empcode" id="empcode" value="%{model.empcode}"/>
	<table cellpadding="0" cellspacing="0" border="1" class="tb_all">
	               <tr>
				          <td colspan="5" class="tb_title"> 
						<%=Temployee.TABLE_ALIAS%>信息
				          </td>
		           </tr>
		              <tr class="crosscolor_tr">
		              		<td class="crosscolor_td">
			                      工作单位
		                  </td>
		                  <td colspan="3">
		                           <s:property value="%{model.deptname}" />
		                  </td>
		                   <td rowspan="8" width="18%" align="center" >
						      <%if(picCount != null && picCount.equals("1")) { %>
					            <img src='${ctx}/pages/fjy/Temployee/showPic.do?xh=<s:property value="%{model.empcode}" />'  height="126" alt="" width="102" border="0" name="photo">	
					           <% } else {%>
					              <IMG src="${ctx}/images/spacer.gif" height="126" alt="" width="102" border="0" name="photo"> 
					           <%} %>
					       </td>
		              </tr>
		           
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=Temployee.ALIAS_EMPNAME%>
		                  </td>
			              <td>
		                           <s:property value="%{model.empname}" />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=Temployee.ALIAS_SEX%>
		                  </td>
			              <td>
			                       <mytag:write property="%{model.sex}"   name="sex"  notEmpty="true"  dictName="T_DIC_SEX"/>
		                  </td>

                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=Temployee.ALIAS_PERSONID%>
		                  </td>
			              <td>
		                           <s:property value="%{model.personid}" />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=Temployee.ALIAS_BIRTH%>
		                  </td>
			              <td>
		                           <s:property value="%{model.birth}" />
		                  </td>
                   </tr>

		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=Temployee.ALIAS_PHONE%>
		                  </td>
			              <td colspan="3">
		                           <s:property value="%{model.phone}" />
		                  </td>
                        
                   </tr>		            
		           <tr class="crosscolor_tr">
		                   <td class="crosscolor_td">
			                      <%=Temployee.ALIAS_FOLK%>
		                  </td>
			              <td>
			                       <mytag:write property="%{model.folk}"   name="folk"  notEmpty="true"  dictName="T_DIC_NATION"/>
		                  </td>
                          <td class="crosscolor_td">
			                      <%=Temployee.ALIAS_ALIAS%>
		                  </td>
			              <td>
		                           <s:property value="%{model.alias}" />
		                  </td>

                   </tr>
		           <tr class="crosscolor_tr">
		                  <td class="crosscolor_td">
			                      <%=Temployee.ALIAS_SCHOOLAGE%>
		                  </td>
			              <td>
			                       <mytag:write property="%{model.schoolage}"   name="schoolage"  notEmpty="true"  dictName="educations"/>
		                  </td>
                          <td class="crosscolor_td">
			                      <%=Temployee.ALIAS_POLITYVISAGE%>
		                  </td>
			              <td>
			                       <mytag:write property="%{model.polityvisage}"   name="polityvisage"  notEmpty="true"  dictName="partyvisage"/>
		                  </td>

                   </tr>
		           <tr class="crosscolor_tr">

                          <td class="crosscolor_td">
			                      <%=Temployee.ALIAS_HYZH%>
		                  </td>
			              <td>
			                       <mytag:write property="%{model.hyzh}"   name="hyzh"  notEmpty="true"  dictName="T_DIC_HYZK"/>
		                  </td>
		                   <td class="crosscolor_td">
			                      <%=Temployee.ALIAS_STATURE%>
		                  </td>
			              <td>
		                           <s:property value="%{model.stature}" />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
		                   <td class="crosscolor_td">
			                      <%=Temployee.ALIAS_POSTURE%>
		                  </td>
			              <td>
			                       <mytag:write property="%{model.posture}"   name="posture"  notEmpty="true"  dictName="T_DIC_SHAPE"/>
		                  </td>
                          <td class="crosscolor_td">
			                      <%=Temployee.ALIAS_WEIGHT%>
		                  </td>
			              <td>
		                           <s:property value="%{model.weight}" />
		                  </td>

                   </tr>
                    <tr class="crosscolor_tr">

		                  <td class="crosscolor_td">
			                      <%=Temployee.ALIAS_NATIVEPLACE%>
		                  </td>
			              <td colspan="4">
			                       <mytag:write property="%{model.nativeplace}"   name="nativeplace"  notEmpty="true"  dictName="T_DIC_XZQH"/>
		                  </td>
				</tr>
				
		           <tr class="crosscolor_tr">       
                          <td class="crosscolor_td">
			                      <%=Temployee.ALIAS_NPADDRESS%>
		                  </td>
			              <td colspan="4">
		                           <s:property value="%{model.npaddress}" />
		                  </td>
                   </tr>
                   <tr class="crosscolor_tr">
                         <td class="crosscolor_td">
			                      <%=Temployee.ALIAS_NPCODE%>
		                  </td>
			              <td colspan="4">
			                       <mytag:write property="%{model.npcode}"   name="npcode"  notEmpty="true"  dictName="T_DIC_XZQH"/>
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=Temployee.ALIAS_ADDRESS%>
		                  </td>
			              <td colspan="4">
		                           <s:property value="%{model.address}" />
		                  </td>
		            </tr>


		           <tr class="crosscolor_tr">
		           <td class="crosscolor_td">
						人员职务:
					</td>
					<td>
						<mytag:write  property="%{model.position}"   name="position" notEmpty="false" dictName="DICT_ITEM_EMP_POSI" />
					</td>
                          <td class="crosscolor_td">
		                      <%=Temployee.ALIAS_CYRJZT%>
	                  </td>
		              <td colspan="2">
		                       <mytag:write property="%{model.cyrjzt}"   name="cyrjzt"  notEmpty="true"  dictName="cyryFlag"/>
	                  </td>
                   </tr>

		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=Temployee.ALIAS_INSERTTIME%>
		                  </td>
			              <td>
		                           <s:property value="%{model.inserttimeString}" />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=Temployee.ALIAS_EDITTIME%>
		                  </td>
			              <td colspan="2">
		                           <s:property value="%{model.edittimeString}" />
		                  </td>
                   </tr>
                   <tr>
						  <td colspan="5" class="tb_bottom">
						           <input type="button" value="返回" onclick="history.go(-1)"/>
	                      </td>
	               </tr>
	</table>	
</s:form>

</body>

</html>