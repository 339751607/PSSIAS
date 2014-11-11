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
	<title><%=TtjGuestPre.TABLE_ALIAS%>查询</title>
</head>

<body>
<%@ include file="/commons/messages.jsp" %>
<div class="queryPanel">
    <s:form action="/pages/hotel/TchPre/list.do"  theme="simple" style="display: inline;" method="post">
	    <table cellpadding="0" cellspacing="0" border="0" class="tb_all">
	               <tr>
			              <td class="tb_title" colspan="4"><%=TtjGuestPre.TABLE_ALIAS%>查询</td>
		           </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=TtjGuestPre.ALIAS_NAME%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.name}"  name="s_name"  />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=TtjGuestPre.ALIAS_SEX%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.sex}"  name="s_sex"  />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=TtjGuestPre.ALIAS_NATION%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.nation}"  name="s_nation"  />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=TtjGuestPre.ALIAS_BDATE%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.bdate}"  name="s_bdate"  />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=TtjGuestPre.ALIAS_ID_NAME%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.idName}"  name="s_idName"  />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=TtjGuestPre.ALIAS_ID_CODE%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.idCode}"  name="s_idCode"  />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=TtjGuestPre.ALIAS_XZQH%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.xzqh}"  name="s_xzqh"  />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=TtjGuestPre.ALIAS_ADDRESS%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.address}"  name="s_address"  />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=TtjGuestPre.ALIAS_IN_TIME%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.inTime}"  name="s_inTime"  />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=TtjGuestPre.ALIAS_NO_ROOM%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.noRoom}"  name="s_noRoom"  />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=TtjGuestPre.ALIAS_OUT_TIME%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.outTime}"  name="s_outTime"  />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=TtjGuestPre.ALIAS_TRA_TIME%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.traTime}"  name="s_traTime"  />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=TtjGuestPre.ALIAS_CREDIT_CODE%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.creditCode}"  name="s_creditCode"  />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=TtjGuestPre.ALIAS_CREDIT_NO%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.creditNo}"  name="s_creditNo"  />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=TtjGuestPre.ALIAS_STA_CODE%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.staCode}"  name="s_staCode"  />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=TtjGuestPre.ALIAS_BUR_CODE%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.burCode}"  name="s_burCode"  />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=TtjGuestPre.ALIAS_SPM%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.spm}"  name="s_spm"  />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=TtjGuestPre.ALIAS_INSERT_TIME%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.insertTime}"  name="s_insertTime"  />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=TtjGuestPre.ALIAS_MEMO%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.memo}"  name="s_memo"  />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=TtjGuestPre.ALIAS_HOTELID%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.hotelid}"  name="s_hotelid"  />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=TtjGuestPre.ALIAS_PDAFLAG%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.pdaflag}"  name="s_pdaflag"  />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=TtjGuestPre.ALIAS_DRAGOMANAME%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.dragomaname}"  name="s_dragomaname"  />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=TtjGuestPre.ALIAS_DRAGOMAPHONE%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.dragomaphone}"  name="s_dragomaphone"  />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=TtjGuestPre.ALIAS_GROUPNO%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.groupno}"  name="s_groupno"  />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=TtjGuestPre.ALIAS_KYRY%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.kyry}"  name="s_kyry"  />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=TtjGuestPre.ALIAS_FLAGTJ%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.flagtj}"  name="s_flagtj"  />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=TtjGuestPre.ALIAS_DAYS%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.days}"  name="s_days"  />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=TtjGuestPre.ALIAS_FLAGKY%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.flagky}"  name="s_flagky"  />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=TtjGuestPre.ALIAS_KYTYPE%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.kytype}"  name="s_kytype"  />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=TtjGuestPre.ALIAS_FLAGCQBF%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.flagcqbf}"  name="s_flagcqbf"  />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=TtjGuestPre.ALIAS_HOTELNAME%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.hotelname}"  name="s_hotelname"  />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=TtjGuestPre.ALIAS_CITY_CODE%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.cityCode}"  name="s_cityCode"  />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=TtjGuestPre.ALIAS_TLSY%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.tlsy}"  name="s_tlsy"  />
		                  </td>
                          <td>&nbsp;</td>
                          <td>&nbsp;</td>
                   </tr>
		           <tr>
			              <td class="tb_bottom" colspan="4">
			                       <input type="submit"  value="查询" onclick="getReferenceForm(this).action='${ctx}/pages/hotel/TchPre/list.do'"/>
	                               <input type="submit"  value="新增" onclick="getReferenceForm(this).action='${ctx}/pages/hotel/TchPre/create.do?<mytag:params includes="ec*,s*" type="queryStringUtf"/>'"/>
			              </td>
		           </tr>
	    </table>
    </s:form>
</div>
			
</body>

</html>