<%@page import="com.dyneinfo.hotel.model.*" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/commons/taglibs.jsp" %>
<%
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+request.getContextPath()+"/";
%>
<html>

<head>
	<%@ include file="/commons/meta.jsp" %>
	<base href="<%=basePath%>">
	<title><%=TjwPre.TABLE_ALIAS%></title>
</head>

<body>
<%@ include file="/commons/messages.jsp" %>

<s:form action="/pages/hotel/TjwPre/list.do" method="get" theme="simple">
	<s:hidden name="id" id="id" value="%{model.id}"/>
	<table cellpadding="0" cellspacing="0" border="0" class="tb_all">
	               <tr>
				          <td colspan="5" class="tb_title"> 
							<%=TjwPre.TABLE_ALIAS%>
				          </td>
		           </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=TjwPre.ALIAS_X_SN%>
		                  </td>
			              <td>
		                           <s:property value="%{model.xsn}" />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=TjwPre.ALIAS_M_FN%>
		                  </td>
			              <td>
		                           <s:property value="%{model.mfn}" />
		                  </td>
		                  <td rowspan="7" align="center" width="15%">
		                  <img
							src='${ctx}/pages/hotel/TjwPre/showPic.do?id=<s:property value="%{model.id}" />'
							onerror="this.src='${ctx}/images/spacer.gif'"  alt=""
							width="130" height="170"  border="0" name="photo">
		                  </td>			                  
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=TjwPre.ALIAS_CHN_N%>
		                  </td>
			              <td>
		                           <s:property value="%{model.chnN}" />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=TjwPre.ALIAS_SEX%>
		                  </td>
			              <td>
		                           <mytag:write property="%{model.sex}" dictName="T_DIC_SEX"/>
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=TjwPre.ALIAS_BDATE%>
		                  </td>
			              <td>
		                           <s:property value="%{model.bdate}" />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=TjwPre.ALIAS_P_NATIONAL%>
		                  </td>
			              <td>
		                           <mytag:write property="%{model.pnational}" dictName="DIC_ITEM_COUNTRY"/>
		                           
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=TjwPre.ALIAS_PASS_T%>
		                  </td>
			              <td>
		                           <mytag:write property="%{model.passT}" dictName="DIC_ITEM_PASSPORT"/>
		                  </td>
                          <td class="crosscolor_td">
			                      <%=TjwPre.ALIAS_PASS_NO%>
		                  </td>
			              <td>
		                           <s:property value="%{model.passNo}" />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=TjwPre.ALIAS_VISA_T%>
		                  </td>
			              <td>
		                           <mytag:write property="%{model.visaT}" dictName="DIC_ITEM_VISA"/>
		                  </td>
                          <td class="crosscolor_td">
			                      <%=TjwPre.ALIAS_VISA_NO%>
		                  </td>
			              <td>
		                           <s:property value="%{model.visaNo}" />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=TjwPre.ALIAS_STAY_DATE%>
		                  </td>
			              <td>
		                           <s:property value="%{model.stayDate}" />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=TjwPre.ALIAS_QF_UNIT%>
		                  </td>
			              <td>
		                           <mytag:write property="%{model.qfUnit}" dictName="DIC_ITEM_VISADEP"/>
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=TjwPre.ALIAS_IN_DATE%>
		                  </td>
			              <td>
		                           <s:property value="%{model.inDate}" />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=TjwPre.ALIAS_IN_PORT%>
		                  </td>
			              <td>
		                           <mytag:write property="%{model.inPort}" dictName="T_DIC_PORT"/>
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=TjwPre.ALIAS_P_ADDRESS%>
		                  </td>
			              <td>
		                           <s:property value="%{model.paddress}" />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=TjwPre.ALIAS_JD_UNIT%>
		                  </td>
			              <td>
		                           <s:property value="%{model.jdUnit}" />
		                  </td>
		                  <td></td>
                   </tr>
		           <tr class="crosscolor_tr">
		           		  <td class="crosscolor_td">
			                      <%=TchPre.ALIAS_HOTELNAME%>
		                  </td>
			              <td>
								  <s:property value="%{model.hotelname}" />
		                  </td>		                  
                          <td class="crosscolor_td">
			                      <%=TjwPre.ALIAS_NO_ROOM%>
		                  </td>
			              <td>
		                           <s:property value="%{model.noRoom}" />
		                  </td>
		                  <td></td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=TjwPre.ALIAS_IN_TIME%>
		                  </td>
			              <td>
		                           <s:property value="%{model.inTime}" />
		                  </td>		           
                          <td class="crosscolor_td">
			                      <%=TjwPre.ALIAS_OUT_TIME%>
		                  </td>
			              <td>
		                           <s:property value="%{model.outTime}" />
		                  </td>
		                  <td></td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=TjwPre.ALIAS_BUR_CODE%>
		                  </td>
			              <td>
		                           <mytag:write property="%{model.burCode}"  dictName="ssfj" />
		                  </td>
		                  <td class="crosscolor_td">
			                      <%=TjwPre.ALIAS_STA_CODE%>
		                  </td>
			              <td>
		                           <mytag:write property="%{model.staCode}"  dictName="teHangDwbm"/>
		                  </td>
		                  <td></td>
                   </tr>
	</table>	
</s:form>

</body>

</html>
