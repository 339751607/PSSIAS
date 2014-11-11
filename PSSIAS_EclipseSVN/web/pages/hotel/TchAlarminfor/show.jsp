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
	<title><%=TchAlarminfor.TABLE_ALIAS%></title>
</head>

<body>
<%@ include file="/commons/messages.jsp" %>

<s:form action="/pages/hotel/TchAlarminfor/list.do" method="get" theme="simple">
	<s:hidden name="id" id="id" value="%{model.id}"/>
	<table cellpadding="0" cellspacing="0" border="0" class="tb_all">
	               <tr>
				          <td colspan="4" class="tb_title"> 
							<%=TchAlarminfor.TABLE_ALIAS%>
				          </td>
		           </tr>
		            <tr><td colspan="4" class="tb_title2">布控信息</td></tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=TchAlarminfor.ALIAS_XH%>
		                  </td>
			              <td>
		                           <s:property value="%{model.xh}" />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=TchAlarminfor.ALIAS_SFZH%>
		                  </td>
			              <td>
		                           <s:property value="%{model.sfzh}" />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=TchAlarminfor.ALIAS_BKID%>
		                  </td>
			              <td>
		                           <s:property value="%{model.bkid}" />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=TchAlarminfor.ALIAS_BKLX%>
		                  </td>
			              <td>
		                           <s:property value="%{model.bklx}" />
		                  </td>		                  
                   </tr>                   
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=TchAlarminfor.ALIAS_XM%>
		                  </td>
			              <td>
		                           <s:property value="%{model.xm}" />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=TchAlarminfor.ALIAS_HM1%>
		                  </td>
			              <td>
		                           <s:property value="%{model.hm1}" />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=TchAlarminfor.ALIAS_HM2%>
		                  </td>
			              <td>
		                           <s:property value="%{model.hm2}" />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=TchAlarminfor.ALIAS_XB%>
		                  </td>
			              <td>
		                           <mytag:write property="%{model.xb}" dictName="T_DIC_SEX"/>
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=TchAlarminfor.ALIAS_NL%>
		                  </td>
			              <td>
		                           <s:property value="%{model.nl}" />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=TchAlarminfor.ALIAS_JG%>
		                  </td>
			              <td>
		                           <mytag:write property="%{model.jg}" dictName="T_DIC_XZQH"/>
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=TchAlarminfor.ALIAS_HJD%>
		                  </td>
			              <td>
		                           <s:property value="%{model.hjd}" />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=TchAlarminfor.ALIAS_ZZ%>
		                  </td>
			              <td>
		                           <s:property value="%{model.zz}" />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=TchAlarminfor.ALIAS_SG%>
		                  </td>
			              <td>
		                           <s:property value="%{model.sg}" />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=TchAlarminfor.ALIAS_TX%>
		                  </td>
			              <td>
		                           <s:property value="%{model.tx}" />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=TchAlarminfor.ALIAS_TSTZ%>
		                  </td>
			              <td>
		                           <s:property value="%{model.tstz}" />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=TchAlarminfor.ALIAS_AB%>
		                  </td>
			              <td>
		                           <mytag:write property="%{model.ab}" dictName="Diccon_AJ"/>
		                           
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=TchAlarminfor.ALIAS_LADW%>
		                  </td>
			              <td>
		                           <s:property value="%{model.ladw}" />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=TchAlarminfor.ALIAS_LASJ%>
		                  </td>
			              <td>
		                           <s:property value="%{model.lasj}" />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=TchAlarminfor.ALIAS_JYAQ%>
		                  </td>
			              <td>
		                           <s:property value="%{model.jyaq}" />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=TchAlarminfor.ALIAS_TBDW%>
		                  </td>
			              <td>
		                           <s:property value="%{model.tbdw}" />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=TchAlarminfor.ALIAS_BKSJ%>
		                  </td>
			              <td>
		                           <s:property value="%{model.bksj}" />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=TchAlarminfor.ALIAS_CZR%>
		                  </td>
			              <td>
		                           <s:property value="%{model.czr}" />
		                  </td>
                   </tr>                   
		            <tr><td colspan="4" class="tb_title2">住宿信息</td></tr>                   
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=TchAlarminfor.ALIAS_NAME%>
		                  </td>
			              <td>
		                           <s:property value="%{model.name}" />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=TchAlarminfor.ALIAS_ID_NAME%>
		                  </td>
			              <td>
		                           <mytag:write property="%{model.idName}" dictName="T_ID_NAME"/>
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=TchAlarminfor.ALIAS_ID_CODE%>
		                  </td>
			              <td>
		                           <s:property value="%{model.idCode}" />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=TchAlarminfor.ALIAS_SEX%>
		                  </td>
			              <td>
		                           <mytag:write property="%{model.sex}" dictName="T_DIC_SEX"/>
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=TchAlarminfor.ALIAS_NATION%>
		                  </td>
			              <td>
		                           <mytag:write property="%{model.nation}" dictName="DIC_ITEM_HOTEL_NATION"/>
		                  </td>
                          <td class="crosscolor_td">
			                      <%=TchAlarminfor.ALIAS_BDATE%>
		                  </td>
			              <td>
		                           <s:property value="%{model.bdate}" />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=TchAlarminfor.ALIAS_ADDRESS%>
		                  </td>
			              <td>
		                           <s:property value="%{model.address}" />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=TchAlarminfor.ALIAS_XZQH%>
		                  </td>
			              <td>
		                           <mytag:write property="%{model.xzqh}" dictName="T_DIC_XZQH"/>
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=TchAlarminfor.ALIAS_HOTELNAME%>
		                  </td>
			              <td>
		                           <s:property value="%{model.hotelname}" />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=TchAlarminfor.ALIAS_HOTELADDRESS%>
		                  </td>
			              <td>
		                           <s:property value="%{model.hotelAddress}" />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=TchAlarminfor.ALIAS_NO_ROOM%>
		                  </td>
			              <td>
		                           <s:property value="%{model.noRoom}" />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=TchAlarminfor.ALIAS_IN_TIME%>
		                  </td>
			              <td>
		                           <s:property value="%{model.inTime}" />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=TchAlarminfor.ALIAS_FTIME%>
		                  </td>
			              <td>
		                           <s:property value="%{model.ftime}" />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=TchAlarminfor.ALIAS_TYPE%>
		                  </td>
			              <td>
			              		   <mytag:write property="%{model.type}" dictName="DIC_ITEM_ALARMTYPE"/>
		                  </td>
                   </tr>
		            <tr><td colspan="4" class="tb_title2">处警信息</td></tr>                    
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=TchAlarminfor.ALIAS_PJDW%>
		                  </td>
			              <td>
		                           <s:property value="%{model.pjdw}" />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=TchAlarminfor.ALIAS_CLQK%>
		                  </td>
			              <td>
		                           <s:property value="%{model.clqk}" />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=TchAlarminfor.ALIAS_PJSJ%>
		                  </td>
			              <td>
		                           <s:property value="%{model.pjsj}" />
		                  </td>	
		                  <td class="crosscolor_td">
			                      <%=TchAlarminfor.ALIAS_ZHSJ%>
		                  </td>
			              <td>
		                           <s:property value="%{model.zhsj}" />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=TchAlarminfor.ALIAS_EMPFLAG%>
		                  </td>
			              <td>
			              		   <mytag:write property="%{model.empflag}" dictName="shiFou"/>
		                  </td>
                          <td class="crosscolor_td">
			                      <%=TchAlarminfor.ALIAS_SFYX%>
		                  </td>
			              <td>
			              		   <mytag:write property="%{model.sfyx}" dictName="fouShi"/>
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=TchAlarminfor.ALIAS_WXYY%>
		                  </td>
			              <td>
		                           <s:property value="%{model.wxyy}" />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=TchAlarminfor.ALIAS_SFYZH%>
		                  </td>
			              <td>
			              		   <mytag:write property="%{model.sfyzh}" dictName="fouShi"/>
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=TchAlarminfor.ALIAS_ZHDWMC%>
		                  </td>
			              <td>
		                           <s:property value="%{model.zhdwmc}" />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=TchAlarminfor.ALIAS_WZHYY%>
		                  </td>
			              <td>
		                           <s:property value="%{model.wzhyy}" />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=TchAlarminfor.ALIAS_CJR%>
		                  </td>
			              <td>
		                           <s:property value="%{model.cjr}" />
		                  </td>
                          <td>&nbsp;</td>
                          <td>&nbsp;</td>
                   </tr>
                   <tr>
						  <td colspan="4" class="tb_bottom">
						           <input type="button" value="返回" onclick="window.location='${ctx}/pages/hotel/TchAlarminfor/list.do?<mytag:params includes="ec*,s*" type="queryStringUtf"/>'"/>
	                      </td>
	               </tr>
	</table>	
</s:form>

</body>

</html>
