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
	<title><%=TpersonAlarm.TABLE_ALIAS%>查询</title>
</head>

<body>
<%@ include file="/commons/messages.jsp" %>
<div class="queryPanel">
    <s:form action="/pages/gas/TpersonAlarm/list.do"  theme="simple" style="display: inline;" method="post">
	    <table width="100%" border="1" bordercolor="#7c8ca7" align="center" 	cellPadding="0" cellSpacing="0" class="tb_all">
	               <tr>
			              <td class="tb_title" colspan="4"><%=TpersonAlarm.TABLE_ALIAS%>查询</td>
		           </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=TpersonAlarm.ALIAS_XH%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.xh}"  name="s_xh"  />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=TpersonAlarm.ALIAS_SFZH%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.sfzh}"  name="s_sfzh"  />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=TpersonAlarm.ALIAS_XM%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.xm}"  name="s_xm"  />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=TpersonAlarm.ALIAS_HM1%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.hm1}"  name="s_hm1"  />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=TpersonAlarm.ALIAS_HM2%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.hm2}"  name="s_hm2"  />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=TpersonAlarm.ALIAS_XB%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.xb}"  name="s_xb"  />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=TpersonAlarm.ALIAS_NL%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.nl}"  name="s_nl"  />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=TpersonAlarm.ALIAS_JG%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.jg}"  name="s_jg"  />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=TpersonAlarm.ALIAS_HJD%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.hjd}"  name="s_hjd"  />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=TpersonAlarm.ALIAS_ZZ%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.zz}"  name="s_zz"  />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=TpersonAlarm.ALIAS_SG%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.sg}"  name="s_sg"  />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=TpersonAlarm.ALIAS_TX%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.tx}"  name="s_tx"  />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=TpersonAlarm.ALIAS_TSTZ%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.tstz}"  name="s_tstz"  />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=TpersonAlarm.ALIAS_AB%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.ab}"  name="s_ab"  />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=TpersonAlarm.ALIAS_LADW%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.ladw}"  name="s_ladw"  />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=TpersonAlarm.ALIAS_LASJ%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.lasj}"  name="s_lasj"  />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=TpersonAlarm.ALIAS_JYAQ%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.jyaq}"  name="s_jyaq"  />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=TpersonAlarm.ALIAS_TBDW%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.tbdw}"  name="s_tbdw"  />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=TpersonAlarm.ALIAS_NAME%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.name}"  name="s_name"  />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=TpersonAlarm.ALIAS_ID_NAME%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.idName}"  name="s_idName"  />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=TpersonAlarm.ALIAS_ID_CODE%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.idCode}"  name="s_idCode"  />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=TpersonAlarm.ALIAS_SEX%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.sex}"  name="s_sex"  />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=TpersonAlarm.ALIAS_NATION%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.nation}"  name="s_nation"  />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=TpersonAlarm.ALIAS_BDATE%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.bdate}"  name="s_bdate"  />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=TpersonAlarm.ALIAS_ADDRESS%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.address}"  name="s_address"  />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=TpersonAlarm.ALIAS_XZQH%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.xzqh}"  name="s_xzqh"  />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=TpersonAlarm.ALIAS_CPCODE%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.cpcode}"  name="s_cpcode"  />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=TpersonAlarm.ALIAS_BUYTIME%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.buytime}"  name="s_buytime"  />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=TpersonAlarm.ALIAS_ALARMTIME%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.alarmtime}"  name="s_alarmtime"  />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=TpersonAlarm.ALIAS_ALARMSOURCE%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.alarmsource}"  name="s_alarmsource"  />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=TpersonAlarm.ALIAS_BKLX%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.bklx}"  name="s_bklx"  />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=TpersonAlarm.ALIAS_ZHSJ%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.zhsj}"  name="s_zhsj"  />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=TpersonAlarm.ALIAS_PJDW%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.pjdw}"  name="s_pjdw"  />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=TpersonAlarm.ALIAS_CLQK%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.clqk}"  name="s_clqk"  />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=TpersonAlarm.ALIAS_PJSJ%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.pjsj}"  name="s_pjsj"  />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=TpersonAlarm.ALIAS_BKID%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.bkid}"  name="s_bkid"  />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=TpersonAlarm.ALIAS_ALARMTEL%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.alarmtel}"  name="s_alarmtel"  />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=TpersonAlarm.ALIAS_BKSJ%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.bksj}"  name="s_bksj"  />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=TpersonAlarm.ALIAS_CZR%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.czr}"  name="s_czr"  />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=TpersonAlarm.ALIAS_EMPFLAG%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.empflag}"  name="s_empflag"  />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=TpersonAlarm.ALIAS_SFYX%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.sfyx}"  name="s_sfyx"  />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=TpersonAlarm.ALIAS_WXYY%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.wxyy}"  name="s_wxyy"  />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=TpersonAlarm.ALIAS_SFYZH%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.sfyzh}"  name="s_sfyzh"  />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=TpersonAlarm.ALIAS_ZHDWMC%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.zhdwmc}"  name="s_zhdwmc"  />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=TpersonAlarm.ALIAS_WZHYY%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.wzhyy}"  name="s_wzhyy"  />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=TpersonAlarm.ALIAS_CJR%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.cjr}"  name="s_cjr"  />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=TpersonAlarm.ALIAS_CLFLAG%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.clflag}"  name="s_clflag"  />
		                  </td>
                          <td>&nbsp;</td>
                          <td>&nbsp;</td>
                   </tr>
		           <tr>
			              <td class="tb_bottom" colspan="4">
			                       <input type="submit"  value="查询" onclick="getReferenceForm(this).action='${ctx}/pages/gas/TpersonAlarm/list.do'"/>
	                               <input type="submit"  value="新增" onclick="getReferenceForm(this).action='${ctx}/pages/gas/TpersonAlarm/create.do?<mytag:params includes="ec*,s*" type="queryStringUtf"/>'"/>
			              </td>
		           </tr>
	    </table>
    </s:form>
</div>
			
</body>

</html>