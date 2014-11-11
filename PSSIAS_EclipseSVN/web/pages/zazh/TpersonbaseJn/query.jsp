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
	<title><%=TpersonbaseJn.TABLE_ALIAS%>查询</title>
</head>

<body>
<%@ include file="/commons/messages.jsp" %>
<div class="queryPanel">
    <s:form action="/pages/zazh/TpersonbaseJn/list.do"  theme="simple" style="display: inline;" method="post">
	    <table width="100%" border="1" bordercolor="#7c8ca7" align="center"  cellPadding="0" cellSpacing="0" class="tb_all">
	               <tr>
			              <td class="tb_title" colspan="4"><%=TpersonbaseJn.TABLE_ALIAS%>查询</td>
		           </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=TpersonbaseJn.ALIAS_NAME%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.name}"  name="s_name"  />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=TpersonbaseJn.ALIAS_SEX%>
		                  </td>
			              <td>
		                       <mytag:select  name="s_sex"  value="${pageRequest.filters.sex}"  notEmpty="false"  dictName="T_DIC_SEX"/>
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                         
                          <td class="crosscolor_td">
			                      <%=TpersonbaseJn.ALIAS_BDATE%>
		                  </td>
			              <td>
		                       <input value="${pageRequest.filters.bdate}"  name="s_bdate"  /><div align="left">(格式：yyyyMMdd)</div>
		                  </td>
		                   <td class="crosscolor_td">
			                      <%=TpersonbaseJn.ALIAS_NATION%>
		                  </td>
			              <td>
		                       <mytag:select  name="s_nation"  value="${pageRequest.filters.nation}"  notEmpty="false"  dictName="T_DIC_NATION"/>
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=TpersonbaseJn.ALIAS_CARDNAME%>
		                  </td>
			              <td>
		                       <mytag:select  name="s_cardname"  value="${pageRequest.filters.cardname}"  notEmpty="false"  dictName="T_ID_NAME"/>
		                           
		                  </td>
                          <td class="crosscolor_td">
			                      <%=TpersonbaseJn.ALIAS_CARDCODE%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.cardcode}"  name="s_cardcode"  />
		                           
		                  </td>
                   </tr>
                   <!--  
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=TpersonbaseJn.ALIAS_XZQH%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.xzqh}"  name="s_xzqh"  />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=TpersonbaseJn.ALIAS_ADDRESS%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.address}"  name="s_address"  />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=TpersonbaseJn.ALIAS_UPDATETIME%>
		                  </td>
			              <td>
		                           <s:select name="dateSelect8" list="dateSelectMap"  onchange="dateselect(this,'s_updatetimeBegin','s_updatetimeEnd','yyyy-MM-dd');"  value="#request.dateSelect8" listKey="key"   listValue="value" theme="simple" label=""  emptyOption="false" ></s:select>
			                          从<input id="d3138" name="s_updatetimeBegin"  value="${pageRequest.filters.updatetimeBegin}"   maxlength="0" size="12" class="Wdate" type="text" onFocus="WdatePicker({dateFmt:'<%=TpersonbaseJn.FORMAT_UPDATETIME%>',maxDate:'#F{$dp.$D(\'d3148\')}'})"/> &nbsp;到&nbsp;
			                        <input id="d3148" name="s_updatetimeEnd"   value="${pageRequest.filters.updatetimeEnd}"  maxlength="0" size="12" class="Wdate" type="text" onFocus="WdatePicker({dateFmt:'<%=TpersonbaseJn.FORMAT_UPDATETIME%>',minDate:'#F{$dp.$D(\'d3138\')}'})"/>
		                  </td>
                          <td>&nbsp;</td>
                          <td>&nbsp;</td>
                   </tr>
                   -->
		           <tr>
			              <td class="tb_bottom" colspan="4">
			                       <input type="submit"  value="查询" onclick="getReferenceForm(this).action='${ctx}/pages/zazh/TpersonbaseJn/list.do'"/>
	                              <!--  
	                               <input type="submit"  value="新增" onclick="getReferenceForm(this).action='${ctx}/pages/zazh/TpersonbaseJn/create.do?<mytag:params includes="ec*,s*" type="queryStringUtf"/>'"/>
			                      -->
			              </td>
		           </tr>
	    </table>
    </s:form>
</div>
			
</body>

</html>