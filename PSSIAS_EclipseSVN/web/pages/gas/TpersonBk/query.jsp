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
	<title><%=TpersonBk.TABLE_ALIAS%>查询</title>
</head>

<body>
<%@ include file="/commons/messages.jsp" %>
<div class="queryPanel">
    <s:form action="/pages/gas/TpersonBk/list.do"  theme="simple" style="display: inline;" method="post">
	    <table cellpadding="0" cellspacing="0" border="0" class="tb_all">
	               <tr>
			              <td class="tb_title" colspan="4"><%=TpersonBk.TABLE_ALIAS%>查询</td>
		           </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=TpersonBk.ALIAS_XM%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.xm}"  name="s_xm"  />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=TpersonBk.ALIAS_HM1%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.hm1}"  name="s_hm1"  />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=TpersonBk.ALIAS_HM2%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.hm2}"  name="s_hm2"  />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=TpersonBk.ALIAS_XB%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.xb}"  name="s_xb"  />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=TpersonBk.ALIAS_BDATE%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.bdate}"  name="s_bdate"  />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=TpersonBk.ALIAS_JG%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.jg}"  name="s_jg"  />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=TpersonBk.ALIAS_HJD%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.hjd}"  name="s_hjd"  />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=TpersonBk.ALIAS_ZZ%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.zz}"  name="s_zz"  />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=TpersonBk.ALIAS_SFZH%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.sfzh}"  name="s_sfzh"  />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=TpersonBk.ALIAS_SG%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.sg}"  name="s_sg"  />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=TpersonBk.ALIAS_TX%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.tx}"  name="s_tx"  />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=TpersonBk.ALIAS_TSTZ%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.tstz}"  name="s_tstz"  />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=TpersonBk.ALIAS_XH%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.xh}"  name="s_xh"  />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=TpersonBk.ALIAS_AB%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.ab}"  name="s_ab"  />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=TpersonBk.ALIAS_LADW%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.ladw}"  name="s_ladw"  />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=TpersonBk.ALIAS_LASJ%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.lasj}"  name="s_lasj"  />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=TpersonBk.ALIAS_PZR%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.pzr}"  name="s_pzr"  />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=TpersonBk.ALIAS_LXR%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.lxr}"  name="s_lxr"  />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=TpersonBk.ALIAS_LXDH%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.lxdh}"  name="s_lxdh"  />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=TpersonBk.ALIAS_ZTSJ%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.ztsj}"  name="s_ztsj"  />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=TpersonBk.ALIAS_JYAQ%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.jyaq}"  name="s_jyaq"  />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=TpersonBk.ALIAS_TAF1%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.taf1}"  name="s_taf1"  />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=TpersonBk.ALIAS_TAF2%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.taf2}"  name="s_taf2"  />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=TpersonBk.ALIAS_TAF3%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.taf3}"  name="s_taf3"  />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=TpersonBk.ALIAS_TAF4%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.taf4}"  name="s_taf4"  />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=TpersonBk.ALIAS_TJH1%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.tjh1}"  name="s_tjh1"  />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=TpersonBk.ALIAS_TJH2%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.tjh2}"  name="s_tjh2"  />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=TpersonBk.ALIAS_TJH3%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.tjh3}"  name="s_tjh3"  />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=TpersonBk.ALIAS_TBDW%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.tbdw}"  name="s_tbdw"  />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=TpersonBk.ALIAS_BKLX%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.bklx}"  name="s_bklx"  />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=TpersonBk.ALIAS_ALARM_TEL%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.alarmTel}"  name="s_alarmTel"  />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=TpersonBk.ALIAS_BKPZR%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.bkpzr}"  name="s_bkpzr"  />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=TpersonBk.ALIAS_CZR%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.czr}"  name="s_czr"  />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=TpersonBk.ALIAS_BKSJ%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.bksj}"  name="s_bksj"  />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=TpersonBk.ALIAS_SFYX%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.sfyx}"  name="s_sfyx"  />
		                  </td>
                          <td>&nbsp;</td>
                          <td>&nbsp;</td>
                   </tr>
		           <tr>
			              <td class="tb_bottom" colspan="4">
			                       <input type="submit"  value="查询" onclick="getReferenceForm(this).action='${ctx}/pages/gas/TpersonBk/list.do'"/>
	                               <input type="submit"  value="新增" onclick="getReferenceForm(this).action='${ctx}/pages/gas/TpersonBk/create.do?<mytag:params includes="ec*,s*" type="queryStringUtf"/>'"/>
			              </td>
		           </tr>
	    </table>
    </s:form>
</div>
			
</body>

</html>