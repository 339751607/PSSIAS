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
	<title><%=Registers.TABLE_ALIAS%>查询</title>
</head>

<body>
<%@ include file="/commons/messages.jsp" %>
<div class="queryPanel">
    <s:form action="/pages/jxy/Registers/list.do"  theme="simple" style="display: inline;" method="post">
	    <table cellpadding="0" cellspacing="0" border="0" class="tb_all">
	               <tr>
			              <td class="tb_title" colspan="4"><%=Registers.TABLE_ALIAS%>查询</td>
		           </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=Registers.ALIAS_CLUSTERGROUP%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.clustergroup}"  name="s_clustergroup"  />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=Registers.ALIAS_IPADDRESS%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.ipaddress}"  name="s_ipaddress"  />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=Registers.ALIAS_DATASOURCENAME%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.datasourcename}"  name="s_datasourcename"  />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=Registers.ALIAS_NOTE%>
		                  </td>
			              <td>
				                   <mytag:select  name="s_note"   notEmpty="false"  dictName="T_DIC_SEX"/>
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=Registers.ALIAS_PACKAGES%>
		                  </td>
			              <td>
				                   <s:select name="dateSelect4" list="dateSelectMap"  onchange="dateselect(this,'s_packagesBegin','s_packagesEnd','yyyy-MM-dd');"  value="#request.dateSelect4" listKey="key"   listValue="value" theme="simple" label=""  emptyOption="false" ></s:select>
			                          从<input id="d3134" name="s_packagesBegin"  value="${pageRequest.filters.packagesBegin}"   maxlength="0" size="12" class="Wdate" type="text" onFocus="WdatePicker({dateFmt:'yyyy-MM-dd',maxDate:'#F{$dp.$D(\'d3144\')}'})"/> &nbsp;到&nbsp;
			                        <input id="d3144" name="s_packagesEnd"   value="${pageRequest.filters.packagesEnd}"  maxlength="0" size="12" class="Wdate" type="text" onFocus="WdatePicker({dateFmt:'yyyy-MM-dd',minDate:'#F{$dp.$D(\'d3134\')}'})"/>
		                  </td>
                          <td class="crosscolor_td">
			                      <%=Registers.ALIAS_PORT%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.port}"  name="s_port"  />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=Registers.ALIAS_PROTOCOL%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.protocol}"  name="s_protocol"  />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=Registers.ALIAS_REGISTERTIME%>
		                  </td>
			              <td>
		                           <s:select name="dateSelect7" list="dateSelectMap"  onchange="dateselect(this,'s_registertimeBegin','s_registertimeEnd','yyyy-MM-dd');"  value="#request.dateSelect7" listKey="key"   listValue="value" theme="simple" label=""  emptyOption="false" ></s:select>
			                          从<input id="d3137" name="s_registertimeBegin"  value="${pageRequest.filters.registertimeBegin}"   maxlength="0" size="12" class="Wdate" type="text" onFocus="WdatePicker({dateFmt:'<%=Registers.FORMAT_REGISTERTIME%>',maxDate:'#F{$dp.$D(\'d3147\')}'})"/> &nbsp;到&nbsp;
			                        <input id="d3147" name="s_registertimeEnd"   value="${pageRequest.filters.registertimeEnd}"  maxlength="0" size="12" class="Wdate" type="text" onFocus="WdatePicker({dateFmt:'<%=Registers.FORMAT_REGISTERTIME%>',minDate:'#F{$dp.$D(\'d3137\')}'})"/>
		                  </td>
                   </tr>
		           <tr>
			              <td class="tb_bottom" colspan="4">
			                       <input type="submit"  value="查询" onclick="getReferenceForm(this).action='${ctx}/pages/jxy/Registers/list.do'"/>
	                               <input type="submit"  value="新增" onclick="getReferenceForm(this).action='${ctx}/pages/jxy/Registers/create.do?<mytag:params includes="ec*,s*" type="queryStringUtf"/>'"/>
			              </td>
		           </tr>
	    </table>
    </s:form>
</div>
			
</body>

</html>
