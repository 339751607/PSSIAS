<%@page import="com.dyneinfo.gas.model.*" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/commons/taglibs.jsp" %>
<%
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+request.getContextPath()+"/";
%>
<html>

<head>
	<%@ include file="/commons/meta.jsp" %>
	<base href="<%=basePath%>">
	<title><%=Temployee.TABLE_ALIAS%></title>
</head>

<body>
<%@ include file="/commons/messages.jsp" %>

<s:form action="/pages/gas/Temployeegas/list.do" method="get" theme="simple">
	<s:hidden name="empcode" id="empcode" value="%{model.empcode}"/>
	<table width="100%" border="1" bordercolor="#7c8ca7" align="center"  cellPadding="0" cellSpacing="0" class="tb_all">
	               <tr>
				          <td colspan="5" class="tb_title"> 
							<%=Temployee.TABLE_ALIAS%>详细
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
			                      <%=Temployee.ALIAS_PERSONID%>
		                  </td>
			              <td>
		                           <s:property value="%{model.personid}" />  
		                  </td>
		                  
		                   <td rowspan="13" width="15%" align="center" valign="middle">
		                   <img src='${ctx}/pages/gas/Temployeegas/showPic.do?xh=<s:property value="%{model.empcode}" />'  height="126" alt="" width="102" border="0" name="photo">
		                   </td>
                        
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=Temployee.ALIAS_SEX%>
		                  </td>
			              <td>
		                            <mytag:write property="%{sex}"  name="sex"   notEmpty="true"  dictName="T_DIC_SEX"/>
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
			                      <%=Temployee.ALIAS_FOLK%>
		                  </td>
			              <td>
		                           <mytag:write property="%{folk}"  name="folk"   notEmpty="true"  dictName="T_DIC_NATION"/>
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
			                      <%=Temployee.ALIAS_NPCODE%>
		                  </td>
			              <td>
			              		<mytag:write property="%{npcode}"  name="npcode"   notEmpty="true"  dictName="T_DIC_XZQH"/>
		                  </td>
                          <td class="crosscolor_td">
			                      <%=Temployee.ALIAS_NPADDRESS%>
		                  </td>
			              <td>
		                           <s:property value="%{model.npaddress}" />
		                  </td>
		           </tr>
		           <tr class="crosscolor_tr">
		           		 <td class="crosscolor_td">
			                      <%=Temployee.ALIAS_NATIVEPLACE%>
		                  </td>
			              <td>
			              		<mytag:write property="%{nativeplace}"  name="nativeplace"   notEmpty="true"  dictName="T_DIC_XZQH"/>
		                  </td>
		                   <td class="crosscolor_td">
			                      <%=Temployee.ALIAS_ADDRESS%>
		                  </td>
			              <td>
		                           <s:property value="%{model.address}" />
		                  </td>
		           </tr>
		            <tr class="crosscolor_tr">
                         
                          <td class="crosscolor_td">
			                      <%=Temployee.ALIAS_NOWADRESS%>
		                  </td>
			              <td>
		                           <s:property value="%{model.nowadress}" />
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
			                      <%=Temployee.ALIAS_POLITYVISAGE%>
		                  </td>
			              <td>
		                            <mytag:write property="%{model.polityvisage}"   name="polityvisage"  notEmpty="true"  dictName="partyvisage"/>
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
			                      <%=Temployee.ALIAS_PHONE%>
		                  </td>
			              <td>
		                           <s:property value="%{model.phone}" />
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
			                      <%=Temployee.ALIAS_STATURE%>
		                  </td>
			              <td>
		                           <s:property value="%{model.stature}" />
		                  </td>
		                   <td class="crosscolor_td">
			                      <%=Temployee.ALIAS_CPCODE%>
		                  </td>
			              <td>
		                           <s:property value="%{model.cpname}" />
		                  </td>
		           </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                    <%=Temployee.ALIAS_INDATE%>
		                  </td>
			              <td>
		                           <s:property value="%{model.indate}" />
		                  </td>
                          <td class="crosscolor_td">
			                    <%=Temployee.ALIAS_EMPDUTY%>
		                  </td>
			              <td>
			              		 <mytag:write property="%{model.empduty}"   name="empduty"  notEmpty="true"  dictName="T_DIC_EMPTYPE"/>
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
		           		  <td class="crosscolor_td">
			                      <%=Temployee.ALIAS_CYRJZT%>
		                  </td>
			              <td>
			              		 <mytag:write property="%{model.cyrjzt}"   name="cyrjzt"  notEmpty="true"  dictName="cyryFlag"/>
		                  </td>
		                    <td class="crosscolor_td">
			                      <%=Temployee.ALIAS_LEFTDATE%>
		                  </td>
			              <td>
		                           <s:property value="%{model.leftdate}" />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=Temployee.ALIAS_BURCODE%>
		                  </td>
			              <td>
			              		 <mytag:write property="%{model.burcode}"   name="burcode"  notEmpty="true"  dictName="teHangDwbm"/>
		                  </td>
                          <td class="crosscolor_td">
			                      <%=Temployee.ALIAS_STACODE%>
		                  </td>
			              <td>
		                           <mytag:write property="%{model.stacode}"   name="stacode"  notEmpty="true"  dictName="teHangDwbm"/>
		                  </td>
                   </tr><%--
                   <tr>
						  <td colspan="5" class="tb_bottom">
						           <input type="button" value="返回" onclick="javascript:window.history.go(-1);"/>
	                      </td>
	               </tr>
	--%></table>	
</s:form>

</body>

</html>