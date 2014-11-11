<%@page import="com.dyneinfo.jxy.model.*" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/commons/taglibs.jsp" %>
<%
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+request.getContextPath()+"/";
%>
<html>

<head>
	<%@ include file="/commons/meta.jsp" %>
	<base href="<%=basePath%>">
	<title><%=SsNotice.TABLE_ALIAS%>查询</title>
</head>

<body>
<%@ include file="/commons/messages.jsp" %>
<div class="queryPanel">
    <s:form action="/jxy/SsNotice/htadlist.do"  theme="simple" style="display: inline;" method="post">
	    <table cellpadding="0" cellspacing="0" border="0" class="tb_all">
	               <tr>
			              <td class="tb_title" colspan="4"><%=SsNotice.TABLE_ALIAS%>查询</td>
		           </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=SsNotice.ALIAS_NOTICETITLE%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.noticetitle}"  name="s_noticetitle"  />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=SsNotice.ALIAS_NOTICECONTENT%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.noticecontent}"  name="s_noticecontent"  />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=SsNotice.ALIAS_STARTTIME%>
		                  </td>
			              <td>
		                           <s:select name="dateSelect2" list="dateSelectMap"  onchange="dateselect(this,'s_starttimeBegin','s_starttimeEnd','yyyy-MM-dd');"  value="#request.dateSelect2" listKey="key"   listValue="value" theme="simple" label=""  emptyOption="false" ></s:select>
			                          从<input id="d3132" name="s_starttimeBegin"  value="${pageRequest.filters.starttimeBegin}"   maxlength="0" size="12" class="Wdate" type="text" onFocus="WdatePicker({dateFmt:'<%=SsNotice.FORMAT_STARTTIME%>',maxDate:'#F{$dp.$D(\'d3142\')}'})"/> &nbsp;到&nbsp;
			                        <input id="d3142" name="s_starttimeEnd"   value="${pageRequest.filters.starttimeEnd}"  maxlength="0" size="12" class="Wdate" type="text" onFocus="WdatePicker({dateFmt:'<%=SsNotice.FORMAT_STARTTIME%>',minDate:'#F{$dp.$D(\'d3132\')}'})"/>
		                  </td>
                          <td class="crosscolor_td">
			                      <%=SsNotice.ALIAS_ENDTIME%>
		                  </td>
			              <td>
		                           <s:select name="dateSelect3" list="dateSelectMap"  onchange="dateselect(this,'s_endtimeBegin','s_endtimeEnd','yyyy-MM-dd');"  value="#request.dateSelect3" listKey="key"   listValue="value" theme="simple" label=""  emptyOption="false" ></s:select>
			                          从<input id="d3133" name="s_endtimeBegin"  value="${pageRequest.filters.endtimeBegin}"   maxlength="0" size="12" class="Wdate" type="text" onFocus="WdatePicker({dateFmt:'<%=SsNotice.FORMAT_ENDTIME%>',maxDate:'#F{$dp.$D(\'d3143\')}'})"/> &nbsp;到&nbsp;
			                        <input id="d3143" name="s_endtimeEnd"   value="${pageRequest.filters.endtimeEnd}"  maxlength="0" size="12" class="Wdate" type="text" onFocus="WdatePicker({dateFmt:'<%=SsNotice.FORMAT_ENDTIME%>',minDate:'#F{$dp.$D(\'d3133\')}'})"/>
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=SsNotice.ALIAS_STATE%>
		                  </td>
			              <td>
				                   <mytag:select  name="s_state"   notEmpty="false"  dictName="NOTICE_STATE"/>
		                  </td>
                          <td class="crosscolor_td">
			                      <%=SsNotice.ALIAS_AUTHORID%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.authorid}"  name="s_authorid"  />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=SsNotice.ALIAS_SENDUNITID%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.sendunitid}"  name="s_sendunitid"  />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=SsNotice.ALIAS_CREATETIME%>
		                  </td>
			              <td>
		                           <s:select name="dateSelect7" list="dateSelectMap"  onchange="dateselect(this,'s_createtimeBegin','s_createtimeEnd','yyyy-MM-dd');"  value="#request.dateSelect7" listKey="key"   listValue="value" theme="simple" label=""  emptyOption="false" ></s:select>
			                          从<input id="d3137" name="s_createtimeBegin"  value="${pageRequest.filters.createtimeBegin}"   maxlength="0" size="12" class="Wdate" type="text" onFocus="WdatePicker({dateFmt:'<%=SsNotice.FORMAT_CREATETIME%>',maxDate:'#F{$dp.$D(\'d3147\')}'})"/> &nbsp;到&nbsp;
			                        <input id="d3147" name="s_createtimeEnd"   value="${pageRequest.filters.createtimeEnd}"  maxlength="0" size="12" class="Wdate" type="text" onFocus="WdatePicker({dateFmt:'<%=SsNotice.FORMAT_CREATETIME%>',minDate:'#F{$dp.$D(\'d3137\')}'})"/>
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=SsNotice.ALIAS_ISREPLY%>
		                  </td>
			              <td>
				                   <mytag:select  name="s_isreply"   notEmpty="false"  dictName="NOTICE_ISREPLY"/>
		                  </td>
                          <td class="crosscolor_td">
			                      <%=SsNotice.ALIAS_ISSUESCOPE%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.issuescope}"  name="s_issuescope"  />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=SsNotice.ALIAS_PARTICIPANTS%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.participants}"  name="s_participants"  />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=SsNotice.ALIAS_SORTNO%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.sortno}"  name="s_sortno"  />
		                  </td>
                   </tr>
		           <tr>
			              <td class="tb_bottom" colspan="4">
			                       <input type="submit"  value="查询" onclick="getReferenceForm(this).action='${ctx}/jxy/SsNotice/htadlist.do'"/>
	                               <input type="submit"  value="新增" onclick="getReferenceForm(this).action='${ctx}/jxy/SsNotice/create.do?<mytag:params includes="ec*,s*" type="queryStringUtf"/>'"/>
			              </td>
		           </tr>
	    </table>
    </s:form>
</div>
			
</body>

</html>
