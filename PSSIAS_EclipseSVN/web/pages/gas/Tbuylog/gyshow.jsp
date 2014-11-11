<%@page import="com.dyneinfo.gas.model.*" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/commons/taglibs.jsp" %>
<%
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+request.getContextPath()+"/";
%>
<html>

<head>
	<%@ include file="/commons/meta.jsp" %>
	<base href="<%=basePath%>">
	<title><%=Tbuylog.TABLE_ALIAS%>详情</title>
</head>

<body>
<%@ include file="/commons/messages.jsp" %>

<s:form action="/pages/gas/Tbuylog/list.do" method="get" theme="simple">
	<s:hidden name="id" id="id" value="%{model.id}"/>
	<table width="100%" border="1" bordercolor="#7c8ca7" align="center"  cellPadding="0" cellSpacing="0" class="tb_all">
	               <tr>
				          <td colspan="5" class="tb_title"> 
							<%=Tbuylog.TABLE_ALIAS%>详情
				          </td>
		           </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=Tbuylog.ALIAS_NAME%>
		                  </td>
			              <td>
		                           <s:property value="%{model.name}" />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=Tbuylog.ALIAS_SEX%>
		                  </td>
			              <td>
		                      <mytag:write property="%{sex}"  name="sex"   notEmpty="true"  dictName="T_DIC_SEX"/>
		                  </td>
		                  <td rowspan="10" width="15%" align="center" valign="middle">
		                   <img src='${ctx}/pages/gas/TbuyPic/showPic.do?xh=<s:property value="%{model.id}" />'  height="126" alt="" width="102" border="0" name="photo">
		                   </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=Tbuylog.ALIAS_NATION%>
		                  </td>
			              <td>
		                        <mytag:write property="%{nation}"  name="nation"   notEmpty="true"  dictName="T_DIC_NATION"/>
		                  </td>
                          <td class="crosscolor_td">
			                      <%=Tbuylog.ALIAS_BDATE%>
		                  </td>
			              <td>
		                           <s:property value="%{model.bdate}" />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=Tbuylog.ALIAS_ID_NAME%>
		                  </td>
			              <td>
		                         <mytag:write property="%{idName}"  name="idName"   notEmpty="true"  dictName="T_ID_NAME"/>
		                  </td>
                          <td class="crosscolor_td">
			                      <%=Tbuylog.ALIAS_ID_CODE%>
		                  </td>
			              <td>
		                           <s:property value="%{model.idCode}" />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=Tbuylog.ALIAS_XZQH%>
		                  </td>
			              <td>
		                         <mytag:write property="%{xzqh}"  name="xzqh"   notEmpty="true"  dictName="T_DIC_XZQH"/>
		                  </td>
                          <td class="crosscolor_td">
			                      <%=Tbuylog.ALIAS_ADDRESS%>
		                  </td>
			              <td>
		                           <s:property value="%{model.address}" />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=Tbuylog.ALIAS_WORKUNIT%>
		                  </td>
			              <td>
		                           <s:property value="%{model.workunit}" />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=Tbuylog.ALIAS_PHONE%>
		                  </td>
			              <td>
		                           <s:property value="%{model.phone}" />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=Tbuylog.ALIAS_USE%>
		                  </td>
			              <td>
		                            <mytag:write property="%{use}"  name="use"   notEmpty="true"  dictName="DIC_ITEM_BUY_USE"/>
		                            
		                  </td>
                          <td class="crosscolor_td">
			                      <%=Tbuylog.ALIAS_BUYTYPE%>
		                  </td>
			              <td>
		                           <mytag:write property="%{buytype}"  name="buytype"   notEmpty="true"  dictName="DIC_ITEM_BUY_TYPE"/>
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=Tbuylog.ALIAS_SORT%>
		                  </td>
			              <td>
		                            <mytag:write property="%{sort}"  name="sort"   notEmpty="true"  dictName="DIC_ITEM_BUY_SORT"/>
		                  </td>
                          <td class="crosscolor_td">
			                      <%=Tbuylog.ALIAS_QUANTITY%>
		                  </td>
			              <td>
		                           <s:property value="%{model.quantity}" />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=Tbuylog.ALIAS_LOGTIME%>
		                  </td>
			              <td>
		                           <s:property value="%{model.logtime}" />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=Tbuylog.ALIAS_TRATIME%>
		                  </td>
			              <td>
		                           <s:property value="%{model.tratime}" />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=Tbuylog.ALIAS_BURCODE%>
		                  </td>
			              <td>
		                           <mytag:write property="%{model.burcode}"   name="burcode"  notEmpty="true"  dictName="teHangDwbm"/>
		                  </td>
                          <td class="crosscolor_td">
			                      <%=Tbuylog.ALIAS_STACODE%>
		                  </td>
			              <td>
		                           <mytag:write property="%{model.stacode}"   name="stacode"  notEmpty="true"  dictName="teHangDwbm"/>
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=Tbuylog.ALIAS_CPCODE%>
		                  </td>
			              <td>
			              <a href="${ctx}/pages/gas/Tcompanyinfogas/gycpshow.do?cpcode=${model.cpcode}" style="color: #0000FF; text-decoration: underline;">
		                       <s:property value="%{model.cpname}" />
		                   </a>
		                  </td>
                          <td class="crosscolor_td">
			                      <%=Tbuylog.ALIAS_OPERATOR%>
		                  </td>
			              <td>
		                           <s:property value="%{model.operator}" />
		                  </td>
                   </tr>
                   <tr>
						  <td colspan="5" class="tb_bottom">
						           <input type="button" value="返回" onclick="javascript:window.history.go(-1);"/>
	                      </td>
	               </tr>
	</table>	
</s:form>

</body>

</html>