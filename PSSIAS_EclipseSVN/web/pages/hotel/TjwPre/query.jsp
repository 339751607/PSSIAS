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
	<title><%=TjwPre.TABLE_ALIAS%>查询</title>
</head>

<body>
<%@ include file="/commons/messages.jsp" %>
<div class="queryPanel">
    <s:form action="/pages/hotel/TjwPre/list.do"  theme="simple" style="display: inline;" method="post">
	    <table cellpadding="0" cellspacing="0" border="0" class="tb_all">
	               <tr>
			              <td class="tb_title" colspan="4"><%=TjwPre.TABLE_ALIAS%>查询</td>
		           </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=TjwPre.ALIAS_X_SN%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.xsn}"  name="s_xsn"  />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=TjwPre.ALIAS_M_FN%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.mfn}"  name="s_mfn"  />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=TjwPre.ALIAS_CHN_N%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.chnN}"  name="s_chnN"  />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=TjwPre.ALIAS_SEX%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.sex}"  name="s_sex"  />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=TjwPre.ALIAS_BDATE%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.bdate}"  name="s_bdate"  />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=TjwPre.ALIAS_P_NATIONAL%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.pnational}"  name="s_pnational"  />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=TjwPre.ALIAS_PASS_T%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.passT}"  name="s_passT"  />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=TjwPre.ALIAS_PASS_NO%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.passNo}"  name="s_passNo"  />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=TjwPre.ALIAS_VISA_T%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.visaT}"  name="s_visaT"  />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=TjwPre.ALIAS_VISA_NO%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.visaNo}"  name="s_visaNo"  />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=TjwPre.ALIAS_STAY_DATE%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.stayDate}"  name="s_stayDate"  />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=TjwPre.ALIAS_QF_UNIT%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.qfUnit}"  name="s_qfUnit"  />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=TjwPre.ALIAS_IN_DATE%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.inDate}"  name="s_inDate"  />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=TjwPre.ALIAS_IN_PORT%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.inPort}"  name="s_inPort"  />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=TjwPre.ALIAS_P_ADDRESS%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.paddress}"  name="s_paddress"  />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=TjwPre.ALIAS_JD_UNIT%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.jdUnit}"  name="s_jdUnit"  />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=TjwPre.ALIAS_IN_TIME%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.inTime}"  name="s_inTime"  />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=TjwPre.ALIAS_NO_ROOM%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.noRoom}"  name="s_noRoom"  />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=TjwPre.ALIAS_OUT_TIME%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.outTime}"  name="s_outTime"  />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=TjwPre.ALIAS_TRA_TIME%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.traTime}"  name="s_traTime"  />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=TjwPre.ALIAS_PLACE%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.place}"  name="s_place"  />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=TjwPre.ALIAS_CREDIT_CODE%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.creditCode}"  name="s_creditCode"  />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=TjwPre.ALIAS_CREDIT_NO%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.creditNo}"  name="s_creditNo"  />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=TjwPre.ALIAS_STA_CODE%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.staCode}"  name="s_staCode"  />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=TjwPre.ALIAS_BUR_CODE%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.burCode}"  name="s_burCode"  />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=TjwPre.ALIAS_SPM%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.spm}"  name="s_spm"  />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=TjwPre.ALIAS_INSERT_TIME%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.insertTime}"  name="s_insertTime"  />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=TjwPre.ALIAS_MEMO%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.memo}"  name="s_memo"  />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=TjwPre.ALIAS_REASON%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.reason}"  name="s_reason"  />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=TjwPre.ALIAS_HOTELID%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.hotelid}"  name="s_hotelid"  />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=TjwPre.ALIAS_PDAFLAG%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.pdaflag}"  name="s_pdaflag"  />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=TjwPre.ALIAS_DRAGOMANAME%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.dragomaname}"  name="s_dragomaname"  />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=TjwPre.ALIAS_DRAGOMAPHONE%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.dragomaphone}"  name="s_dragomaphone"  />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=TjwPre.ALIAS_GROUPNO%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.groupno}"  name="s_groupno"  />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=TjwPre.ALIAS_TRANSFERFLAG%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.transferflag}"  name="s_transferflag"  />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=TjwPre.ALIAS_KYRY%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.kyry}"  name="s_kyry"  />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=TjwPre.ALIAS_FLAGTJ%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.flagtj}"  name="s_flagtj"  />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=TjwPre.ALIAS_DAYS%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.days}"  name="s_days"  />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=TjwPre.ALIAS_SFZH%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.sfzh}"  name="s_sfzh"  />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=TjwPre.ALIAS_ZJYXQ%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.zjyxq}"  name="s_zjyxq"  />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=TjwPre.ALIAS_OPERATOR%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.operator}"  name="s_operator"  />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=TjwPre.ALIAS_CITY_CODE%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.cityCode}"  name="s_cityCode"  />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=TjwPre.ALIAS_LEAVEDATE%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.leavedate}"  name="s_leavedate"  />
		                  </td>
                          <td>&nbsp;</td>
                          <td>&nbsp;</td>
                   </tr>
		           <tr>
			              <td class="tb_bottom" colspan="4">
			                       <input type="submit"  value="查询" onclick="getReferenceForm(this).action='${ctx}/pages/hotel/TjwPre/list.do'"/>
	                               <input type="submit"  value="新增" onclick="getReferenceForm(this).action='${ctx}/pages/hotel/TjwPre/create.do?<mytag:params includes="ec*,s*" type="queryStringUtf"/>'"/>
			              </td>
		           </tr>
	    </table>
    </s:form>
</div>
			
</body>

</html>
