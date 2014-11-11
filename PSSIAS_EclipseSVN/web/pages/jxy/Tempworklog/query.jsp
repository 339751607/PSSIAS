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
	<title><%=Tempworklog.TABLE_ALIAS%>查询</title>
</head>

<body>
<%@ include file="/commons/messages.jsp" %>
<div class="queryPanel">
    <s:form action="/jxy/Tempworklog/list.do"  theme="simple" style="display: inline;" method="post">
	    <table cellpadding="0" cellspacing="0" border="0" class="tb_all">
	               <tr>
			              <td class="tb_title" colspan="4"><%=Tempworklog.TABLE_ALIAS%>查询</td>
		           </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=Tempworklog.ALIAS_EMPCODE%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.empcode}"  name="s_empcode"  />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=Tempworklog.ALIAS_CPCODE%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.cpcode}"  name="s_cpcode"  />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=Tempworklog.ALIAS_INDATE%>
		                  </td>
			              <td>
				                   <s:select name="dateSelect2" list="dateSelectMap"  onchange="dateselect(this,'s_indateBegin','s_indateEnd','yyyy-MM-dd');"  value="#request.dateSelect2" listKey="key"   listValue="value" theme="simple" label=""  emptyOption="false" ></s:select>
			                          从<input id="d3132" name="s_indateBegin"  value="${pageRequest.filters.indateBegin}"   maxlength="0" size="12" class="Wdate" type="text" onFocus="WdatePicker({dateFmt:'yyyy-MM-dd',maxDate:'#F{$dp.$D(\'d3142\')}'})"/> &nbsp;到&nbsp;
			                        <input id="d3142" name="s_indateEnd"   value="${pageRequest.filters.indateEnd}"  maxlength="0" size="12" class="Wdate" type="text" onFocus="WdatePicker({dateFmt:'yyyy-MM-dd',minDate:'#F{$dp.$D(\'d3132\')}'})"/>
		                  </td>
                          <td class="crosscolor_td">
			                      <%=Tempworklog.ALIAS_LEFTDATE%>
		                  </td>
			              <td>
				                   <s:select name="dateSelect3" list="dateSelectMap"  onchange="dateselect(this,'s_leftdateBegin','s_leftdateEnd','yyyy-MM-dd');"  value="#request.dateSelect3" listKey="key"   listValue="value" theme="simple" label=""  emptyOption="false" ></s:select>
			                          从<input id="d3133" name="s_leftdateBegin"  value="${pageRequest.filters.leftdateBegin}"   maxlength="0" size="12" class="Wdate" type="text" onFocus="WdatePicker({dateFmt:'yyyy-MM-dd',maxDate:'#F{$dp.$D(\'d3143\')}'})"/> &nbsp;到&nbsp;
			                        <input id="d3143" name="s_leftdateEnd"   value="${pageRequest.filters.leftdateEnd}"  maxlength="0" size="12" class="Wdate" type="text" onFocus="WdatePicker({dateFmt:'yyyy-MM-dd',minDate:'#F{$dp.$D(\'d3133\')}'})"/>
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=Tempworklog.ALIAS_EMPTYPE%>
		                  </td>
			              <td>
				                   <mytag:select  name="s_emptype"   notEmpty="false"  dictName="T_DIC_EMPTYPE"/>
		                  </td>
                          <td class="crosscolor_td">
			                      <%=Tempworklog.ALIAS_DEMO%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.demo}"  name="s_demo"  />
		                  </td>
                   </tr>
		           <tr>
			              <td class="tb_bottom" colspan="4">
			                       <input type="submit"  value="查询" onclick="getReferenceForm(this).action='${ctx}/jxy/Tempworklog/list.do'"/>
	                               <input type="submit"  value="新增" onclick="getReferenceForm(this).action='${ctx}/jxy/Tempworklog/create.do?<mytag:params includes="ec*,s*" type="queryStringUtf"/>'"/>
			              </td>
		           </tr>
	    </table>
    </s:form>
</div>
			
</body>

</html>
