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
	<title><%=TpersonBk.TABLE_ALIAS%>信息</title>
</head>

<body>
<%@ include file="/commons/messages.jsp" %>

<s:form action="/pages/gas/TpersonBk/list.do" method="get" theme="simple">
	<s:hidden name="id" id="id" value="%{model.id}"/>
	<table cellpadding="0" cellspacing="0" border="0" class="tb_all">
	               <tr>
				          <td colspan="4" class="tb_title"> 
							<%=TpersonBk.TABLE_ALIAS%>信息
				          </td>
		           </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=TpersonBk.ALIAS_XM%>
		                  </td>
			              <td>
		                           <s:property value="%{model.xm}" />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=TpersonBk.ALIAS_HM1%>
		                  </td>
			              <td>
		                           <s:property value="%{model.hm1}" />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=TpersonBk.ALIAS_HM2%>
		                  </td>
			              <td>
		                           <s:property value="%{model.hm2}" />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=TpersonBk.ALIAS_XB%>
		                  </td>
			              <td>
		                           <s:property value="%{model.xb}" />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=TpersonBk.ALIAS_BDATE%>
		                  </td>
			              <td>
		                           <s:property value="%{model.bdate}" />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=TpersonBk.ALIAS_JG%>
		                  </td>
			              <td>
		                           <s:property value="%{model.jg}" />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=TpersonBk.ALIAS_HJD%>
		                  </td>
			              <td>
		                           <s:property value="%{model.hjd}" />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=TpersonBk.ALIAS_ZZ%>
		                  </td>
			              <td>
		                           <s:property value="%{model.zz}" />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=TpersonBk.ALIAS_SFZH%>
		                  </td>
			              <td>
		                           <s:property value="%{model.sfzh}" />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=TpersonBk.ALIAS_SG%>
		                  </td>
			              <td>
		                           <s:property value="%{model.sg}" />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=TpersonBk.ALIAS_TX%>
		                  </td>
			              <td>
		                           <s:property value="%{model.tx}" />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=TpersonBk.ALIAS_TSTZ%>
		                  </td>
			              <td>
		                           <s:property value="%{model.tstz}" />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=TpersonBk.ALIAS_XH%>
		                  </td>
			              <td>
		                           <s:property value="%{model.xh}" />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=TpersonBk.ALIAS_AB%>
		                  </td>
			              <td>
		                           <s:property value="%{model.ab}" />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=TpersonBk.ALIAS_LADW%>
		                  </td>
			              <td>
		                           <s:property value="%{model.ladw}" />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=TpersonBk.ALIAS_LASJ%>
		                  </td>
			              <td>
		                           <s:property value="%{model.lasj}" />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=TpersonBk.ALIAS_PZR%>
		                  </td>
			              <td>
		                           <s:property value="%{model.pzr}" />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=TpersonBk.ALIAS_LXR%>
		                  </td>
			              <td>
		                           <s:property value="%{model.lxr}" />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=TpersonBk.ALIAS_LXDH%>
		                  </td>
			              <td>
		                           <s:property value="%{model.lxdh}" />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=TpersonBk.ALIAS_ZTSJ%>
		                  </td>
			              <td>
		                           <s:property value="%{model.ztsj}" />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=TpersonBk.ALIAS_JYAQ%>
		                  </td>
			              <td>
		                           <s:property value="%{model.jyaq}" />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=TpersonBk.ALIAS_TAF1%>
		                  </td>
			              <td>
		                           <s:property value="%{model.taf1}" />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=TpersonBk.ALIAS_TAF2%>
		                  </td>
			              <td>
		                           <s:property value="%{model.taf2}" />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=TpersonBk.ALIAS_TAF3%>
		                  </td>
			              <td>
		                           <s:property value="%{model.taf3}" />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=TpersonBk.ALIAS_TAF4%>
		                  </td>
			              <td>
		                           <s:property value="%{model.taf4}" />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=TpersonBk.ALIAS_TJH1%>
		                  </td>
			              <td>
		                           <s:property value="%{model.tjh1}" />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=TpersonBk.ALIAS_TJH2%>
		                  </td>
			              <td>
		                           <s:property value="%{model.tjh2}" />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=TpersonBk.ALIAS_TJH3%>
		                  </td>
			              <td>
		                           <s:property value="%{model.tjh3}" />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=TpersonBk.ALIAS_TBDW%>
		                  </td>
			              <td>
		                           <s:property value="%{model.tbdw}" />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=TpersonBk.ALIAS_BKLX%>
		                  </td>
			              <td>
		                           <s:property value="%{model.bklx}" />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=TpersonBk.ALIAS_ALARM_TEL%>
		                  </td>
			              <td>
		                           <s:property value="%{model.alarmTel}" />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=TpersonBk.ALIAS_BKPZR%>
		                  </td>
			              <td>
		                           <s:property value="%{model.bkpzr}" />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=TpersonBk.ALIAS_CZR%>
		                  </td>
			              <td>
		                           <s:property value="%{model.czr}" />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=TpersonBk.ALIAS_BKSJ%>
		                  </td>
			              <td>
		                           <s:property value="%{model.bksj}" />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=TpersonBk.ALIAS_SFYX%>
		                  </td>
			              <td>
		                           <s:property value="%{model.sfyx}" />
		                  </td>
                          <td>&nbsp;</td>
                          <td>&nbsp;</td>
                   </tr>
                   <tr>
						  <td colspan="4" class="tb_bottom">
						           <input type="button" value="返回" onclick="window.location='${ctx}/pages/gas/TpersonBk/list.do?<mytag:params includes="ec*,s*" type="queryStringUtf"/>'"/>
	                      </td>
	               </tr>
	</table>	
</s:form>

</body>

</html>