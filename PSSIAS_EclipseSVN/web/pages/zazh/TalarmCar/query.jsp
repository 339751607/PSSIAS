<%@page import="com.dyneinfo.zazh.model.*" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/commons/taglibs.jsp" %>
<%
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+request.getContextPath()+"/";
%>
<html>

<head>
	<%@ include file="/commons/meta.jsp" %>
	<base href="<%=basePath%>">
	<title><%=TalarmCar.TABLE_ALIAS%>查询</title>
</head>

<body>
<%@ include file="/commons/messages.jsp" %>
<div class="queryPanel">
    <s:form action="/pages/zazh/TalarmCar/list.do"  theme="simple" style="display: inline;" method="post">
	    <table width="100%" border="1" bordercolor="#7c8ca7" align="center"  cellPadding="0" cellSpacing="0" class="tb_all">
	               <tr>
			              <td class="tb_title" colspan="4"><%=TalarmCar.TABLE_ALIAS%>查询</td>
		           </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=TalarmCar.ALIAS_BKID%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.bkid}"  name="s_bkid"  />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=TalarmCar.ALIAS_BKTYPE%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.bktype}"  name="s_bktype"  />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=TalarmCar.ALIAS_SID%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.sid}"  name="s_sid"  />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=TalarmCar.ALIAS_ALARMTIME%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.alarmtime}"  name="s_alarmtime"  />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=TalarmCar.ALIAS_ALARMSOURCE%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.alarmsource}"  name="s_alarmsource"  />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=TalarmCar.ALIAS_ALARMTYPE%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.alarmtype}"  name="s_alarmtype"  />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=TalarmCar.ALIAS_BUSINESSTYPE%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.businesstype}"  name="s_businesstype"  />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=TalarmCar.ALIAS_BUSINESSTIME%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.businesstime}"  name="s_businesstime"  />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=TalarmCar.ALIAS_CPCODE%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.cpcode}"  name="s_cpcode"  />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=TalarmCar.ALIAS_CAROWNER%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.carowner}"  name="s_carowner"  />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=TalarmCar.ALIAS_CARTYPE%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.cartype}"  name="s_cartype"  />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=TalarmCar.ALIAS_BRAND%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.brand}"  name="s_brand"  />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=TalarmCar.ALIAS_CARMODE%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.carmode}"  name="s_carmode"  />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=TalarmCar.ALIAS_COLOR%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.color}"  name="s_color"  />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=TalarmCar.ALIAS_CARID%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.carid}"  name="s_carid"  />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=TalarmCar.ALIAS_ENGINECODE%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.enginecode}"  name="s_enginecode"  />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=TalarmCar.ALIAS_BODYCODE%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.bodycode}"  name="s_bodycode"  />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=TalarmCar.ALIAS_CLFLAG%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.clflag}"  name="s_clflag"  />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=TalarmCar.ALIAS_CJDW%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.cjdw}"  name="s_cjdw"  />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=TalarmCar.ALIAS_CJR%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.cjr}"  name="s_cjr"  />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=TalarmCar.ALIAS_CJSJ%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.cjsj}"  name="s_cjsj"  />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=TalarmCar.ALIAS_VALIDFLAG%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.validflag}"  name="s_validflag"  />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=TalarmCar.ALIAS_VOIDCAUSE%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.voidcause}"  name="s_voidcause"  />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=TalarmCar.ALIAS_ZHFLAG%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.zhflag}"  name="s_zhflag"  />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=TalarmCar.ALIAS_ZHDW%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.zhdw}"  name="s_zhdw"  />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=TalarmCar.ALIAS_ZHSJ%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.zhsj}"  name="s_zhsj"  />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=TalarmCar.ALIAS_WZHYY%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.wzhyy}"  name="s_wzhyy"  />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=TalarmCar.ALIAS_CLQK%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.clqk}"  name="s_clqk"  />
		                  </td>
                   </tr>
		           <tr>
			              <td class="tb_bottom" colspan="4">
			                       <input type="submit"  value="查询" onclick="getReferenceForm(this).action='${ctx}/pages/zazh/TalarmCar/list.do'"/>
	                               <input type="submit"  value="新增" onclick="getReferenceForm(this).action='${ctx}/pages/zazh/TalarmCar/create.do?<mytag:params includes="ec*,s*" type="queryStringUtf"/>'"/>
			              </td>
		           </tr>
	    </table>
    </s:form>
</div>
			
</body>

</html>