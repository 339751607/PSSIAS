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
	<title><%=Tcarlog.TABLE_ALIAS%>查询</title>
</head>

<body>
<%@ include file="/commons/messages.jsp" %>
<div class="queryPanel">
    <s:form action="/pages/zazh/Tcarlog/list.do"  theme="simple" style="display: inline;" method="post">
	    <table width="100%" border="1" bordercolor="#7c8ca7" align="center"  cellPadding="0" cellSpacing="0" class="tb_all">
	               <tr>
			              <td class="tb_title" colspan="4"><%=Tcarlog.TABLE_ALIAS%>查询</td>
		           </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=Tcarlog.ALIAS_CARBASEID%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.carbaseid}"  name="s_carbaseid"  />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=Tcarlog.ALIAS_SOURCE%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.source}"  name="s_source"  />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=Tcarlog.ALIAS_SID%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.sid}"  name="s_sid"  />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=Tcarlog.ALIAS_CARTYPE%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.cartype}"  name="s_cartype"  />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=Tcarlog.ALIAS_STARTTIME%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.starttime}"  name="s_starttime"  />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=Tcarlog.ALIAS_ENDTIME%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.endtime}"  name="s_endtime"  />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=Tcarlog.ALIAS_INSERTTIME%>
		                  </td>
			              <td>
		                           <s:select name="dateSelect6" list="dateSelectMap"  onchange="dateselect(this,'s_inserttimeBegin','s_inserttimeEnd','yyyy-MM-dd');"  value="#request.dateSelect6" listKey="key"   listValue="value" theme="simple" label=""  emptyOption="false" ></s:select>
			                          从<input id="d3136" name="s_inserttimeBegin"  value="${pageRequest.filters.inserttimeBegin}"   maxlength="0" size="12" class="Wdate" type="text" onFocus="WdatePicker({dateFmt:'<%=Tcarlog.FORMAT_INSERTTIME%>',maxDate:'#F{$dp.$D(\'d3146\')}'})"/> &nbsp;到&nbsp;
			                        <input id="d3146" name="s_inserttimeEnd"   value="${pageRequest.filters.inserttimeEnd}"  maxlength="0" size="12" class="Wdate" type="text" onFocus="WdatePicker({dateFmt:'<%=Tcarlog.FORMAT_INSERTTIME%>',minDate:'#F{$dp.$D(\'d3136\')}'})"/>
		                  </td>
                          <td class="crosscolor_td">
			                      <%=Tcarlog.ALIAS_UPDATETIME%>
		                  </td>
			              <td>
		                           <s:select name="dateSelect7" list="dateSelectMap"  onchange="dateselect(this,'s_updatetimeBegin','s_updatetimeEnd','yyyy-MM-dd');"  value="#request.dateSelect7" listKey="key"   listValue="value" theme="simple" label=""  emptyOption="false" ></s:select>
			                          从<input id="d3137" name="s_updatetimeBegin"  value="${pageRequest.filters.updatetimeBegin}"   maxlength="0" size="12" class="Wdate" type="text" onFocus="WdatePicker({dateFmt:'<%=Tcarlog.FORMAT_UPDATETIME%>',maxDate:'#F{$dp.$D(\'d3147\')}'})"/> &nbsp;到&nbsp;
			                        <input id="d3147" name="s_updatetimeEnd"   value="${pageRequest.filters.updatetimeEnd}"  maxlength="0" size="12" class="Wdate" type="text" onFocus="WdatePicker({dateFmt:'<%=Tcarlog.FORMAT_UPDATETIME%>',minDate:'#F{$dp.$D(\'d3137\')}'})"/>
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=Tcarlog.ALIAS_TABLEFORPIC%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.tableforpic}"  name="s_tableforpic"  />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=Tcarlog.ALIAS_FIELDFORPIC%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.fieldforpic}"  name="s_fieldforpic"  />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=Tcarlog.ALIAS_CPCODE%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.cpcode}"  name="s_cpcode"  />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=Tcarlog.ALIAS_KEYFORPIC%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.keyforpic}"  name="s_keyforpic"  />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=Tcarlog.ALIAS_CARID%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.carid}"  name="s_carid"  />
		                  </td>
                          <td>&nbsp;</td>
                          <td>&nbsp;</td>
                   </tr>
		           <tr>
			              <td class="tb_bottom" colspan="4">
			                       <input type="submit"  value="查询" onclick="getReferenceForm(this).action='${ctx}/pages/zazh/Tcarlog/list.do'"/>
	                               <input type="submit"  value="新增" onclick="getReferenceForm(this).action='${ctx}/pages/zazh/Tcarlog/create.do?<mytag:params includes="ec*,s*" type="queryStringUtf"/>'"/>
			              </td>
		           </tr>
	    </table>
    </s:form>
</div>
			
</body>

</html>