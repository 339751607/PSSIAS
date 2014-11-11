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
	<title><%=TpersonlogJn.TABLE_ALIAS%>查询</title>
</head>

<body>
<%@ include file="/commons/messages.jsp" %>
<div class="queryPanel">
    <s:form action="/pages/zazh/TpersonlogJn/list.do"  theme="simple" style="display: inline;" method="post">
	    <table width="100%" border="1" bordercolor="#7c8ca7" align="center"  cellPadding="0" cellSpacing="0" class="tb_all">
	               <tr>
			              <td class="tb_title" colspan="4"><%=TpersonlogJn.TABLE_ALIAS%>查询</td>
		           </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=TpersonlogJn.ALIAS_PERSONID%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.personid}"  name="s_personid"  />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=TpersonlogJn.ALIAS_CARDNAME%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.cardname}"  name="s_cardname"  />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=TpersonlogJn.ALIAS_CARDNO%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.cardno}"  name="s_cardno"  />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=TpersonlogJn.ALIAS_SOURCE%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.source}"  name="s_source"  />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=TpersonlogJn.ALIAS_SID%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.sid}"  name="s_sid"  />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=TpersonlogJn.ALIAS_PERSONTYPE%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.persontype}"  name="s_persontype"  />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=TpersonlogJn.ALIAS_EMPSTATUS%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.empstatus}"  name="s_empstatus"  />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=TpersonlogJn.ALIAS_STARTTIME%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.starttime}"  name="s_starttime"  />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=TpersonlogJn.ALIAS_ENDTIME%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.endtime}"  name="s_endtime"  />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=TpersonlogJn.ALIAS_INSERTTIME%>
		                  </td>
			              <td>
		                           <s:select name="dateSelect9" list="dateSelectMap"  onchange="dateselect(this,'s_inserttimeBegin','s_inserttimeEnd','yyyy-MM-dd');"  value="#request.dateSelect9" listKey="key"   listValue="value" theme="simple" label=""  emptyOption="false" ></s:select>
			                          从<input id="d3139" name="s_inserttimeBegin"  value="${pageRequest.filters.inserttimeBegin}"   maxlength="0" size="12" class="Wdate" type="text" onFocus="WdatePicker({dateFmt:'<%=TpersonlogJn.FORMAT_INSERTTIME%>',maxDate:'#F{$dp.$D(\'d3149\')}'})"/> &nbsp;到&nbsp;
			                        <input id="d3149" name="s_inserttimeEnd"   value="${pageRequest.filters.inserttimeEnd}"  maxlength="0" size="12" class="Wdate" type="text" onFocus="WdatePicker({dateFmt:'<%=TpersonlogJn.FORMAT_INSERTTIME%>',minDate:'#F{$dp.$D(\'d3139\')}'})"/>
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=TpersonlogJn.ALIAS_UPDATETIME%>
		                  </td>
			              <td>
		                           <s:select name="dateSelect10" list="dateSelectMap"  onchange="dateselect(this,'s_updatetimeBegin','s_updatetimeEnd','yyyy-MM-dd');"  value="#request.dateSelect10" listKey="key"   listValue="value" theme="simple" label=""  emptyOption="false" ></s:select>
			                          从<input id="d31310" name="s_updatetimeBegin"  value="${pageRequest.filters.updatetimeBegin}"   maxlength="0" size="12" class="Wdate" type="text" onFocus="WdatePicker({dateFmt:'<%=TpersonlogJn.FORMAT_UPDATETIME%>',maxDate:'#F{$dp.$D(\'d31410\')}'})"/> &nbsp;到&nbsp;
			                        <input id="d31410" name="s_updatetimeEnd"   value="${pageRequest.filters.updatetimeEnd}"  maxlength="0" size="12" class="Wdate" type="text" onFocus="WdatePicker({dateFmt:'<%=TpersonlogJn.FORMAT_UPDATETIME%>',minDate:'#F{$dp.$D(\'d31310\')}'})"/>
		                  </td>
                          <td class="crosscolor_td">
			                      <%=TpersonlogJn.ALIAS_TABLEFORPIC%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.tableforpic}"  name="s_tableforpic"  />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=TpersonlogJn.ALIAS_FIELDFORPIC%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.fieldforpic}"  name="s_fieldforpic"  />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=TpersonlogJn.ALIAS_CPCODE%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.cpcode}"  name="s_cpcode"  />
		                  </td>
                   </tr>
		           <tr>
			              <td class="tb_bottom" colspan="4">
			                       <input type="submit"  value="查询" onclick="getReferenceForm(this).action='${ctx}/pages/zazh/TpersonlogJn/list.do'"/>
	                               <input type="submit"  value="新增" onclick="getReferenceForm(this).action='${ctx}/pages/zazh/TpersonlogJn/create.do?<mytag:params includes="ec*,s*" type="queryStringUtf"/>'"/>
			              </td>
		           </tr>
	    </table>
    </s:form>
</div>
			
</body>

</html>