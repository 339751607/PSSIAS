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
	<title><%=SsGroup.TABLE_ALIAS%>查询</title>
</head>

<body>
<%@ include file="/commons/messages.jsp" %>
<div class="queryPanel">
    <s:form action="/pages/SsGroup/list.do"  theme="simple" style="display: inline;" method="post">
	    <table cellpadding="0" cellspacing="0" border="0" class="tb_all">
	               <tr>
			              <td class="tb_title" colspan="4"><%=SsGroup.TABLE_ALIAS%>查询</td>
		           </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=SsGroup.ALIAS_ORGID%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.orgid}"  name="s_orgid"  />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=SsGroup.ALIAS_PARENTGROUPID%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.parentgroupid}"  name="s_parentgroupid"  />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=SsGroup.ALIAS_GROUPLEVEL%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.grouplevel}"  name="s_grouplevel"  />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=SsGroup.ALIAS_GROUPNAME%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.groupname}"  name="s_groupname"  />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=SsGroup.ALIAS_GROUPDESC%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.groupdesc}"  name="s_groupdesc"  />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=SsGroup.ALIAS_GROUPTYPE%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.grouptype}"  name="s_grouptype"  />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=SsGroup.ALIAS_GROUPSEQ%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.groupseq}"  name="s_groupseq"  />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=SsGroup.ALIAS_STARTDATE%>
		                  </td>
			              <td>
		                           <s:select name="dateSelect7" list="dateSelectMap"  onchange="dateselect(this,'s_startdateBegin','s_startdateEnd','yyyy-MM-dd');"  value="#request.dateSelect7" listKey="key"   listValue="value" theme="simple" label=""  emptyOption="false" ></s:select>
			                          从<input id="d3137" name="s_startdateBegin"  value="${pageRequest.filters.startdateBegin}"   maxlength="0" size="12" class="Wdate" type="text" onFocus="WdatePicker({dateFmt:'<%=SsGroup.FORMAT_STARTDATE%>',maxDate:'#F{$dp.$D(\'d3147\')}'})"/> &nbsp;到&nbsp;
			                        <input id="d3147" name="s_startdateEnd"   value="${pageRequest.filters.startdateEnd}"  maxlength="0" size="12" class="Wdate" type="text" onFocus="WdatePicker({dateFmt:'<%=SsGroup.FORMAT_STARTDATE%>',minDate:'#F{$dp.$D(\'d3137\')}'})"/>
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=SsGroup.ALIAS_ENDDATE%>
		                  </td>
			              <td>
		                           <s:select name="dateSelect8" list="dateSelectMap"  onchange="dateselect(this,'s_enddateBegin','s_enddateEnd','yyyy-MM-dd');"  value="#request.dateSelect8" listKey="key"   listValue="value" theme="simple" label=""  emptyOption="false" ></s:select>
			                          从<input id="d3138" name="s_enddateBegin"  value="${pageRequest.filters.enddateBegin}"   maxlength="0" size="12" class="Wdate" type="text" onFocus="WdatePicker({dateFmt:'<%=SsGroup.FORMAT_ENDDATE%>',maxDate:'#F{$dp.$D(\'d3148\')}'})"/> &nbsp;到&nbsp;
			                        <input id="d3148" name="s_enddateEnd"   value="${pageRequest.filters.enddateEnd}"  maxlength="0" size="12" class="Wdate" type="text" onFocus="WdatePicker({dateFmt:'<%=SsGroup.FORMAT_ENDDATE%>',minDate:'#F{$dp.$D(\'d3138\')}'})"/>
		                  </td>
                          <td class="crosscolor_td">
			                      <%=SsGroup.ALIAS_GROUPSTATUS%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.groupstatus}"  name="s_groupstatus"  />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=SsGroup.ALIAS_MANAGER%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.manager}"  name="s_manager"  />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=SsGroup.ALIAS_CREATETIME%>
		                  </td>
			              <td>
		                           <s:select name="dateSelect11" list="dateSelectMap"  onchange="dateselect(this,'s_createtimeBegin','s_createtimeEnd','yyyy-MM-dd');"  value="#request.dateSelect11" listKey="key"   listValue="value" theme="simple" label=""  emptyOption="false" ></s:select>
			                          从<input id="d31311" name="s_createtimeBegin"  value="${pageRequest.filters.createtimeBegin}"   maxlength="0" size="12" class="Wdate" type="text" onFocus="WdatePicker({dateFmt:'<%=SsGroup.FORMAT_CREATETIME%>',maxDate:'#F{$dp.$D(\'d31411\')}'})"/> &nbsp;到&nbsp;
			                        <input id="d31411" name="s_createtimeEnd"   value="${pageRequest.filters.createtimeEnd}"  maxlength="0" size="12" class="Wdate" type="text" onFocus="WdatePicker({dateFmt:'<%=SsGroup.FORMAT_CREATETIME%>',minDate:'#F{$dp.$D(\'d31311\')}'})"/>
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=SsGroup.ALIAS_LASTUPDATE%>
		                  </td>
			              <td>
		                           <s:select name="dateSelect12" list="dateSelectMap"  onchange="dateselect(this,'s_lastupdateBegin','s_lastupdateEnd','yyyy-MM-dd');"  value="#request.dateSelect12" listKey="key"   listValue="value" theme="simple" label=""  emptyOption="false" ></s:select>
			                          从<input id="d31312" name="s_lastupdateBegin"  value="${pageRequest.filters.lastupdateBegin}"   maxlength="0" size="12" class="Wdate" type="text" onFocus="WdatePicker({dateFmt:'<%=SsGroup.FORMAT_LASTUPDATE%>',maxDate:'#F{$dp.$D(\'d31412\')}'})"/> &nbsp;到&nbsp;
			                        <input id="d31412" name="s_lastupdateEnd"   value="${pageRequest.filters.lastupdateEnd}"  maxlength="0" size="12" class="Wdate" type="text" onFocus="WdatePicker({dateFmt:'<%=SsGroup.FORMAT_LASTUPDATE%>',minDate:'#F{$dp.$D(\'d31312\')}'})"/>
		                  </td>
                          <td class="crosscolor_td">
			                      <%=SsGroup.ALIAS_ISLEAF%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.isleaf}"  name="s_isleaf"  />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=SsGroup.ALIAS_DISPLAYORDER%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.displayorder}"  name="s_displayorder"  />
		                  </td>
                          <td>&nbsp;</td>
                          <td>&nbsp;</td>
                   </tr>
		           <tr>
			              <td class="tb_bottom" colspan="4">
			                       <input type="submit"  value="查询" onclick="getReferenceForm(this).action='${ctx}/pages/SsGroup/list.do'"/>
	                               <input type="submit"  value="新增" onclick="getReferenceForm(this).action='${ctx}/pages/SsGroup/create.do?<mytag:params includes="ec*,s*" type="queryStringUtf"/>'"/>
			              </td>
		           </tr>
	    </table>
    </s:form>
</div>
			
</body>

</html>