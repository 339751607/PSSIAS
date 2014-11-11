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
	<title><%=TchAlarminfor.TABLE_ALIAS%>查询</title>
</head>

<body>
<%@ include file="/commons/messages.jsp" %>
<div class="queryPanel">
    <s:form action="/pages/hotel/TchAlarminfor/list.do"  theme="simple" style="display: inline;" method="post">
	    <table cellpadding="0" cellspacing="0" border="0" class="tb_all">
	               <tr>
			              <td class="tb_title" colspan="4"><%=TchAlarminfor.TABLE_ALIAS%>查询</td>
		           </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=TchAlarminfor.ALIAS_XH%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.xh}"  name="s_xh"  />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=TchAlarminfor.ALIAS_SFZH%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.sfzh}"  name="s_sfzh"  />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=TchAlarminfor.ALIAS_XM%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.xm}"  name="s_xm"  />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=TchAlarminfor.ALIAS_HM1%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.hm1}"  name="s_hm1"  />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=TchAlarminfor.ALIAS_HM2%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.hm2}"  name="s_hm2"  />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=TchAlarminfor.ALIAS_XB%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.xb}"  name="s_xb"  />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=TchAlarminfor.ALIAS_NL%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.nl}"  name="s_nl"  />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=TchAlarminfor.ALIAS_JG%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.jg}"  name="s_jg"  />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=TchAlarminfor.ALIAS_HJD%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.hjd}"  name="s_hjd"  />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=TchAlarminfor.ALIAS_ZZ%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.zz}"  name="s_zz"  />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=TchAlarminfor.ALIAS_SG%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.sg}"  name="s_sg"  />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=TchAlarminfor.ALIAS_TX%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.tx}"  name="s_tx"  />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=TchAlarminfor.ALIAS_TSTZ%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.tstz}"  name="s_tstz"  />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=TchAlarminfor.ALIAS_AB%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.ab}"  name="s_ab"  />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=TchAlarminfor.ALIAS_LADW%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.ladw}"  name="s_ladw"  />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=TchAlarminfor.ALIAS_LASJ%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.lasj}"  name="s_lasj"  />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=TchAlarminfor.ALIAS_JYAQ%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.jyaq}"  name="s_jyaq"  />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=TchAlarminfor.ALIAS_TBDW%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.tbdw}"  name="s_tbdw"  />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=TchAlarminfor.ALIAS_NAME%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.name}"  name="s_name"  />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=TchAlarminfor.ALIAS_ID_NAME%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.idName}"  name="s_idName"  />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=TchAlarminfor.ALIAS_ID_CODE%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.idCode}"  name="s_idCode"  />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=TchAlarminfor.ALIAS_SEX%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.sex}"  name="s_sex"  />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=TchAlarminfor.ALIAS_NATION%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.nation}"  name="s_nation"  />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=TchAlarminfor.ALIAS_BDATE%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.bdate}"  name="s_bdate"  />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=TchAlarminfor.ALIAS_ADDRESS%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.address}"  name="s_address"  />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=TchAlarminfor.ALIAS_XZQH%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.xzqh}"  name="s_xzqh"  />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=TchAlarminfor.ALIAS_NO_ROOM%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.noRoom}"  name="s_noRoom"  />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=TchAlarminfor.ALIAS_IN_TIME%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.inTime}"  name="s_inTime"  />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=TchAlarminfor.ALIAS_FTIME%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.ftime}"  name="s_ftime"  />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=TchAlarminfor.ALIAS_ALARM%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.alarm}"  name="s_alarm"  />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=TchAlarminfor.ALIAS_TYPE%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.type}"  name="s_type"  />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=TchAlarminfor.ALIAS_BKLX%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.bklx}"  name="s_bklx"  />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=TchAlarminfor.ALIAS_ALARMTJ%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.alarmtj}"  name="s_alarmtj"  />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=TchAlarminfor.ALIAS_ZHSJ%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.zhsj}"  name="s_zhsj"  />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=TchAlarminfor.ALIAS_PJDW%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.pjdw}"  name="s_pjdw"  />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=TchAlarminfor.ALIAS_CLQK%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.clqk}"  name="s_clqk"  />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=TchAlarminfor.ALIAS_PJSJ%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.pjsj}"  name="s_pjsj"  />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=TchAlarminfor.ALIAS_BKID%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.bkid}"  name="s_bkid"  />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=TchAlarminfor.ALIAS_BKTEL%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.bktel}"  name="s_bktel"  />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=TchAlarminfor.ALIAS_AUDIT_MARK%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.auditMark}"  name="s_auditMark"  />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=TchAlarminfor.ALIAS_BKSJ%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.bksj}"  name="s_bksj"  />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=TchAlarminfor.ALIAS_CZR%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.czr}"  name="s_czr"  />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=TchAlarminfor.ALIAS_EMPFLAG%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.empflag}"  name="s_empflag"  />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=TchAlarminfor.ALIAS_SFYX%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.sfyx}"  name="s_sfyx"  />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=TchAlarminfor.ALIAS_WXYY%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.wxyy}"  name="s_wxyy"  />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=TchAlarminfor.ALIAS_SFYZH%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.sfyzh}"  name="s_sfyzh"  />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=TchAlarminfor.ALIAS_ZHDWMC%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.zhdwmc}"  name="s_zhdwmc"  />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=TchAlarminfor.ALIAS_WZHYY%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.wzhyy}"  name="s_wzhyy"  />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=TchAlarminfor.ALIAS_CJR%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.cjr}"  name="s_cjr"  />
		                  </td>
                          <td>&nbsp;</td>
                          <td>&nbsp;</td>
                   </tr>
		           <tr>
			              <td class="tb_bottom" colspan="4">
			                       <input type="submit"  value="查询" onclick="getReferenceForm(this).action='${ctx}/pages/hotel/TchAlarminfor/list.do'"/>
	                               <input type="submit"  value="新增" onclick="getReferenceForm(this).action='${ctx}/pages/hotel/TchAlarminfor/create.do?<mytag:params includes="ec*,s*" type="queryStringUtf"/>'"/>
			              </td>
		           </tr>
	    </table>
    </s:form>
</div>
			
</body>

</html>