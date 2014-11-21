<%@page import="com.dyneinfo.jxy.model.*" %>
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
	<title><%=Temployee.TABLE_ALIAS%></title>
</head>

<body>
<%@ include file="/commons/messages.jsp" %>

<s:form action="/pages/jxy/Temployee/list.do" method="get" theme="simple">
	<s:hidden name="cpempcode" id="cpempcode" value="%{model.cpempcode}"/>
	<table cellpadding="0" cellspacing="0" border="0" class="tb_all">
	               <tr>
				          <td colspan="5" class="tb_title"> 
							<%=Temployee.TABLE_ALIAS%>
				          </td>
		           </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=Temployee.ALIAS_DEPTNAME%>
		                  </td>
			              <td colspan="3">
		                           <s:property value="%{model.deptname}" />
		                  </td>
                         	<td rowspan="12" width="18%" align="center" >
						<img
							src='${ctx}/pages/jxy/Temployee/showPic.do?cpempcode=<s:property value="%{model.cpempcode}" />&cpcode=${model.cpcode}'
							onerror="this.src='${ctx}/images/spacer.gif'" height="150" alt=""
							width="140" border="0" name="photo">
					</td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=Temployee.ALIAS_NAME%>
		                  </td>
			              <td>
		                           <s:property value="%{model.name}" />
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
			                      <%=Temployee.ALIAS_ALIAS%>
		                  </td>
			              <td>
		                           <s:property value="%{model.alias}" />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=Temployee.ALIAS_FOLK%>
		                  </td>
			              <td>
			                       <mytag:write property="%{model.folk}"   name="folk"  notEmpty="true"  dictName="T_DIC_NATION"/>
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=Temployee.ALIAS_NATIVEPLACE%>
		                  </td>
			              <td>
			                       <mytag:write property="%{model.nativeplace}"   name="nativeplace"  notEmpty="true"  dictName="T_DIC_XZQH"/>
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
			                      <%=Temployee.ALIAS_HYZK%>
		                  </td>
			              <td>
			                       <mytag:write property="%{model.hyzk}"   name="T_DIC_HYZK"  notEmpty="true"  dictName="T_DIC_HYZK"/>
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
			                      <%=Temployee.ALIAS_WEIGHT%>
		                  </td>
			              <td>
		                           <s:property value="%{model.weight}" />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
		          		 <td class="crosscolor_td">
			                      <%=Temployee.ALIAS_INDATE%>
		                  </td>
			              <td >
			                       <s:property value="%{model.indate}" />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=Temployee.ALIAS_NPCODE%>
		                  </td>
			              <td >
			                       <mytag:write property="%{model.npcode}"   name="npcode"  notEmpty="true"  dictName="T_DIC_XZQH"/>
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=Temployee.ALIAS_ADDRESS%>
		                  </td>
			              <td colspan="3">
		                           <s:property value="%{model.address}" />
		                  </td>
		            </tr>
		           <tr class="crosscolor_tr">       
                          <td class="crosscolor_td">
			                      <%=Temployee.ALIAS_NPADDRESS%>
		                  </td>
			              <td colspan="3">
		                           <s:property value="%{model.npaddress}" />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=Temployee.ALIAS_PHONE%>
		                  </td>
			              <td>
		                           <s:property value="%{model.phone}" />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=Temployee.ALIAS_CYRJZT%>
		                  </td>
			              <td>
			                       <mytag:write property="%{model.cyrjzt}"   name="cyrjzt"  notEmpty="true"  dictName="cyryFlag"/>
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=Temployee.ALIAS_TEMPORARYCODE%>
		                  </td>
			              <td>
		                           <s:property value="%{model.temporarycode}" />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=Temployee.ALIAS_NOWADRESS%>
		                  </td>
			              <td>
		                           <s:property value="%{model.nowadress}" />
		                  </td>
                   </tr>

		          
                   <tr>
						  <td colspan="5" class="tb_bottom">
						           <input type="button" value="返回" onclick="window.location='${ctx}/pages/jxy/Temployee/list.do?<mytag:params includes="ec*,s*" type="queryStringUtf"/>'"/>
	                      </td>
	               </tr>
	</table>	
</s:form>

</body>

</html>
