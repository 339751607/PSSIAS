<%@page import="com.dyneinfo.fjy.model.*" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/commons/taglibs.jsp" %>
<%
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+request.getContextPath()+"/";
%>
<html>

<head>
	<%@ include file="/commons/meta.jsp" %>
	<base href="<%=basePath%>">
	<title><%=TcpMaintain.TABLE_ALIAS%>查询</title>
</head>

<body>
<%@ include file="/commons/messages.jsp" %>
<div class="queryPanel">
    <s:form action="/pages/fjy/TcpMaintain/list.do"  theme="simple" style="display: inline;" method="post">
	    <table cellpadding="0" cellspacing="0" border="1" class="tb_all">
	               <tr>
			              <td class="tb_title" colspan="4"><%=TcpMaintain.TABLE_ALIAS%>查询</td>
		           </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=TcpMaintain.ALIAS_DEPTID%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.deptid}"  name="s_deptid"  />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=TcpMaintain.ALIAS_IDCARD%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.idcard}"  name="s_idcard"  />
		                  </td>
                   </tr>
		           <tr class="tr_tb">
                          <td class="td_tb">
			                      <%=TcpMaintain.ALIAS_MAINTAINTIME%>
		                  </td>
			              <td class="td_input">
				                   <s:select name="dateSelect2" list="dateSelectMap"  onchange="dateselect(this,'s_maintaintimeBegin','s_maintaintimeEnd','yyyy-MM-dd HH:mm:ss');"  value="#request.dateSelect2" listKey="key"   listValue="value" theme="simple" label=""  emptyOption="false" ></s:select>
			                          从<input id="d3132" name="s_maintaintimeBegin"  value="${pageRequest.filters.maintaintimeBegin}"   maxlength="0" size="12" class="Wdate" type="text" onFocus="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss',maxDate:'#F{$dp.$D(\'d3142\')}'})"/> &nbsp;到&nbsp;
			                        <input id="d3142" name="s_maintaintimeEnd"   value="${pageRequest.filters.maintaintimeEnd}"  maxlength="0" size="12" class="Wdate" type="text" onFocus="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss',minDate:'#F{$dp.$D(\'d3132\')}'})"/>
		                  </td>
                          <td class="crosscolor_td">
			                      <%=TcpMaintain.ALIAS_DEMO%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.demo}"  name="s_demo"  />
		                  </td>
                   </tr>
		           <tr>
			              <td class="tb_bottom" colspan="4">
			                       <input type="submit"  value="查询" onclick="getReferenceForm(this).action='${ctx}/pages/fjy/TcpMaintain/list.do'"/>
	                               <input type="submit"  value="新增" onclick="getReferenceForm(this).action='${ctx}/pages/fjy/TcpMaintain/create.do?<mytag:params includes="ec*,s*" type="queryStringUtf"/>'"/>
			              </td>
		           </tr>
	    </table>
    </s:form>
</div>
			
</body>

</html>