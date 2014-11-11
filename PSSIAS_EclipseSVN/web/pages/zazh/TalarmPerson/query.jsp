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
	<title><%=TalarmPerson.TABLE_ALIAS%>查询</title>
</head>

<body>
<%@ include file="/commons/messages.jsp" %>
<div class="queryPanel">
    <s:form action="/pages/zazh/TalarmPerson/list.do"  theme="simple" style="display: inline;" method="post">
	    <table width="100%" border="1" bordercolor="#7c8ca7" align="center"  cellPadding="0" cellSpacing="0" class="tb_all">
	               <tr>
			              <td class="tb_title" colspan="4"><%=TalarmPerson.TABLE_ALIAS%>查询</td>
		           </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=TalarmPerson.ALIAS_BKID%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.bkid}"  name="s_bkid"  />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=TalarmPerson.ALIAS_BKTYPE%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.bktype}"  name="s_bktype"  />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=TalarmPerson.ALIAS_SID%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.sid}"  name="s_sid"  />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=TalarmPerson.ALIAS_ALARMTIME%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.alarmtime}"  name="s_alarmtime"  />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=TalarmPerson.ALIAS_ALARMSOURCE%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.alarmsource}"  name="s_alarmsource"  />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=TalarmPerson.ALIAS_ALARMTYPE%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.alarmtype}"  name="s_alarmtype"  />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=TalarmPerson.ALIAS_BUSINESSTYPE%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.businesstype}"  name="s_businesstype"  />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=TalarmPerson.ALIAS_BUSINESSTIME%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.businesstime}"  name="s_businesstime"  />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=TalarmPerson.ALIAS_CPCODE%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.cpcode}"  name="s_cpcode"  />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=TalarmPerson.ALIAS_NAME%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.name}"  name="s_name"  />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=TalarmPerson.ALIAS_SEX%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.sex}"  name="s_sex"  />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=TalarmPerson.ALIAS_NATION%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.nation}"  name="s_nation"  />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=TalarmPerson.ALIAS_BDATE%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.bdate}"  name="s_bdate"  />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=TalarmPerson.ALIAS_IDNAME%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.idname}"  name="s_idname"  />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=TalarmPerson.ALIAS_IDCODE%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.idcode}"  name="s_idcode"  />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=TalarmPerson.ALIAS_HJD%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.hjd}"  name="s_hjd"  />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=TalarmPerson.ALIAS_ADDRESS%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.address}"  name="s_address"  />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=TalarmPerson.ALIAS_CLFLAG%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.clflag}"  name="s_clflag"  />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=TalarmPerson.ALIAS_CJDW%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.cjdw}"  name="s_cjdw"  />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=TalarmPerson.ALIAS_CJR%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.cjr}"  name="s_cjr"  />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=TalarmPerson.ALIAS_CJSJ%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.cjsj}"  name="s_cjsj"  />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=TalarmPerson.ALIAS_VALIDFLAG%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.validflag}"  name="s_validflag"  />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=TalarmPerson.ALIAS_VOIDCAUSE%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.voidcause}"  name="s_voidcause"  />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=TalarmPerson.ALIAS_ZHFLAG%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.zhflag}"  name="s_zhflag"  />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=TalarmPerson.ALIAS_ZHDW%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.zhdw}"  name="s_zhdw"  />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=TalarmPerson.ALIAS_ZHSJ%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.zhsj}"  name="s_zhsj"  />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=TalarmPerson.ALIAS_WZHYY%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.wzhyy}"  name="s_wzhyy"  />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=TalarmPerson.ALIAS_CLQK%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.clqk}"  name="s_clqk"  />
		                  </td>
                   </tr>
		           <tr>
			              <td class="tb_bottom" colspan="4">
			                       <input type="submit"  value="查询" onclick="getReferenceForm(this).action='${ctx}/pages/zazh/TalarmPerson/list.do'"/>
	                               <input type="submit"  value="新增" onclick="getReferenceForm(this).action='${ctx}/pages/zazh/TalarmPerson/create.do?<mytag:params includes="ec*,s*" type="queryStringUtf"/>'"/>
			              </td>
		           </tr>
	    </table>
    </s:form>
</div>
			
</body>

</html>