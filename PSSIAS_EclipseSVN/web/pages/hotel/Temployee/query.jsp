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
	<title><%=Temployee.TABLE_ALIAS%>查询</title>
</head>

<body>
<%@ include file="/commons/messages.jsp" %>
<div class="queryPanel">
    <s:form action="/pages/hotel/Temployee/list.do"  theme="simple" style="display: inline;" method="post">
	    <table cellpadding="0" cellspacing="0" border="0" class="tb_all">
	               <tr>
			              <td class="tb_title" colspan="4"><%=Temployee.TABLE_ALIAS%>查询</td>
		           </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=Temployee.ALIAS_EMPNAME%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.empname}"  name="s_empname"  />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=Temployee.ALIAS_ALIAS%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.alias}"  name="s_alias"  />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=Temployee.ALIAS_SEX%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.sex}"  name="s_sex"  />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=Temployee.ALIAS_BIRTH%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.birth}"  name="s_birth"  />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=Temployee.ALIAS_STATURE%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.stature}"  name="s_stature"  />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=Temployee.ALIAS_WEIGHT%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.weight}"  name="s_weight"  />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=Temployee.ALIAS_POSTURE%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.posture}"  name="s_posture"  />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=Temployee.ALIAS_POLITYVISAGE%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.polityvisage}"  name="s_polityvisage"  />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=Temployee.ALIAS_FOLK%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.folk}"  name="s_folk"  />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=Temployee.ALIAS_NATIVEPLACE%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.nativeplace}"  name="s_nativeplace"  />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=Temployee.ALIAS_ADDRESS%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.address}"  name="s_address"  />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=Temployee.ALIAS_NOWADRESS%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.nowadress}"  name="s_nowadress"  />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=Temployee.ALIAS_PHONE%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.phone}"  name="s_phone"  />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=Temployee.ALIAS_SCHOOLAGE%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.schoolage}"  name="s_schoolage"  />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=Temployee.ALIAS_PERSONID%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.personid}"  name="s_personid"  />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=Temployee.ALIAS_NPCODE%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.npcode}"  name="s_npcode"  />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=Temployee.ALIAS_NPADDRESS%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.npaddress}"  name="s_npaddress"  />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=Temployee.ALIAS_TEMPORARYCODE%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.temporarycode}"  name="s_temporarycode"  />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=Temployee.ALIAS_INSERTTIME%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.inserttime}"  name="s_inserttime"  />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=Temployee.ALIAS_EDITTIME%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.edittime}"  name="s_edittime"  />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=Temployee.ALIAS_HYZH%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.hyzh}"  name="s_hyzh"  />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=Temployee.ALIAS_CYRJZT%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.cyrjzt}"  name="s_cyrjzt"  />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=Temployee.ALIAS_TRATIME%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.tratime}"  name="s_tratime"  />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=Temployee.ALIAS_INDBTIME%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.indbtime}"  name="s_indbtime"  />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=Temployee.ALIAS_HOTELCODE%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.hotelcode}"  name="s_hotelcode"  />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=Temployee.ALIAS_STACODE%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.stacode}"  name="s_stacode"  />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=Temployee.ALIAS_BURCODE%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.burcode}"  name="s_burcode"  />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=Temployee.ALIAS_CITYCODE%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.citycode}"  name="s_citycode"  />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=Temployee.ALIAS_TRANSFLAG%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.transflag}"  name="s_transflag"  />
		                  </td>
                          <td>&nbsp;</td>
                          <td>&nbsp;</td>
                   </tr>
		           <tr>
			              <td class="tb_bottom" colspan="4">
			                       <input type="submit"  value="查询" onclick="getReferenceForm(this).action='${ctx}/pages/hotel/Temployee/list.do'"/>
	                               <input type="submit"  value="新增" onclick="getReferenceForm(this).action='${ctx}/pages/hotel/Temployee/create.do?<mytag:params includes="ec*,s*" type="queryStringUtf"/>'"/>
			              </td>
		           </tr>
	    </table>
    </s:form>
</div>
			
</body>

</html>