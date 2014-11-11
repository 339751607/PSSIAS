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
	<title>报警详细信息</title>
</head>

<body>
<%@ include file="/commons/messages.jsp" %>

<s:form action="/pages/gas/TpersonAlarm/list.do" method="get" theme="simple">
	<s:hidden name="id" id="id" value="%{model.id}"/>
	<table width="100%" border="0" cellpadding="0" cellspacing="0"
	align="center">
	<tr>
          <td colspan="4" class="tb_title"> 
			报警详细信息
          </td>
	</tr>
</table>
<table>
	<tr>
		<td height="3"></td>
	</tr>
</table>
<fieldset>
	<legend>
		人员基本信息
	</legend>
	<table width="100%" border="1" bordercolor="#7c8ca7" align="center"   cellPadding="0" cellSpacing="0" class="tb_all">
		 <tr class="crosscolor_tr">
                          <td class="crosscolor_td" style="width=200px;">
			                      <%=TpersonAlarm.ALIAS_NAME%>
		                  </td>
			              <td style="width=340px;">
		                           <s:property value="%{model.name}" />&nbsp;
		                  </td>
                          <td class="crosscolor_td" style="width=200px;" >
			                      <%=TpersonAlarm.ALIAS_ID_NAME%>
		                  </td>
			              <td>
		                           <mytag:write property="%{idName}"  name="idName"   notEmpty="true"  dictName="T_ID_NAME"/>&nbsp;
		                  </td>
		                   <td rowspan="5" width="10%"  style="padding:1px;height:160px;text-align:center;vertical-align:middle;">
		                   	 <c:if test='${model.empflag == 1}'>
                          	      <img src='${ctx}/pages/gas/Temployeegas/showPic.do?xh=<s:property value="%{model.id}" />'  height="126" alt="" width="102" border="0" name="photo">
                          	</c:if>
                          	<c:if test='${model.empflag == 0}'>
                          	    <img src='${ctx}/pages/gas/TbuyPic/showPic.do?xh=<s:property value="%{model.id}" />'  height="126" alt="" width="102" border="0" name="photo">
                          	</c:if>
		                   </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=TpersonAlarm.ALIAS_ID_CODE%>
		                  </td>
			              <td>
		                           <s:property value="%{model.idCode}" />&nbsp;
		                  </td>
                          <td class="crosscolor_td">
			                      <%=TpersonAlarm.ALIAS_SEX%>
		                  </td>
			              <td>
		                           <mytag:write property="%{sex}"  name="sex"   notEmpty="true"  dictName="T_DIC_SEX"/>&nbsp;
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=TpersonAlarm.ALIAS_NATION%>
		                  </td>
			              <td>
		                         <mytag:write property="%{nation}"  name="nation"   notEmpty="true"  dictName="T_DIC_NATION"/>&nbsp;
		                  </td>
                          <td class="crosscolor_td">
			                      <%=TpersonAlarm.ALIAS_BDATE%>
		                  </td>
			              <td>
		                           <s:property value="%{model.bdate}" />&nbsp;
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=TpersonAlarm.ALIAS_ADDRESS%>
		                  </td>
			              <td>
		                           <s:property value="%{model.address}" />&nbsp;
		                  </td>
                          <td class="crosscolor_td">
			                      <%=TpersonAlarm.ALIAS_XZQH%>
		                  </td>
			              <td>
			             	 <mytag:write property="%{xzqh}"  name="xzqh"   notEmpty="true"  dictName="T_DIC_XZQH"/>&nbsp;
		                  </td>
                   </tr>
                   
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                <c:if test='${model.empflag == 1}'>
                          	      工作单位
                          	
                          	</c:if>
                          	<c:if test='${model.empflag == 0}'>
                          	      <%=TpersonAlarm.ALIAS_CPCODE%>
                          	</c:if>
		                  </td>
			              <td>
		                   <a href="${ctx}/pages/gas/Tcompanyinfogas/gycpshow.do?cpcode=${model.cpcode}" style="color: #0000FF; text-decoration: underline;">
		                       <s:property value="%{model.cpname}" />
		                   </a>&nbsp;
		                  </td>
                          <td class="crosscolor_td">
                          	<c:if test='${model.empflag == 1}'>
                          	      入职时间
                          	
                          	</c:if>
                          	<c:if test='${model.empflag == 0}'>
			                      <%=TpersonAlarm.ALIAS_BUYTIME%>
                          	</c:if>
		                  </td>
			              <td>
		                           <s:property value="%{model.buytime}" />&nbsp;
		                  </td>
                   </tr>
		
	</table>					
</fieldset>
<table>
  <tr>
    <td height=3></td>
  </tr>
</table>

<fieldset>
	<legend>
	   布控信息
	</legend>
<table width="100%" border="1" bordercolor="#7c8ca7" align="center"  cellPadding="0" cellSpacing="0" class="tb_all">
	 <tr class="crosscolor_tr">
                          <td class="crosscolor_td" style="width=200px;">
			                      <%=TpersonAlarm.ALIAS_XM%>
		                  </td>
			              <td style="width=340px;">
		                           <s:property value="%{model.xm}" />&nbsp;
		                  </td>
                          <td class="crosscolor_td" style="width=200px;">
			                      <%=TpersonAlarm.ALIAS_SFZH%>
		                  </td>
			              <td >
		                           <s:property value="%{model.sfzh}" />&nbsp;
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=TpersonAlarm.ALIAS_HM1%>
		                  </td>
			              <td>
		                           <s:property value="%{model.hm1}" />&nbsp;
		                  </td>
                          <td class="crosscolor_td">
			                      <%=TpersonAlarm.ALIAS_XB%>
		                  </td>
			              <td >
			               <mytag:write property="%{xb}"  name="xb"   notEmpty="true"  dictName="T_DIC_SEX"/>&nbsp;
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=TpersonAlarm.ALIAS_NL%>
		                  </td>
			              <td>
		                           <s:property value="%{model.nl}" />&nbsp;
		                  </td>
                          <td class="crosscolor_td">
			                      <%=TpersonAlarm.ALIAS_JG%>
		                  </td>
			              <td >
			            	  <mytag:write property="%{jg}"  name="jg"   notEmpty="true"  dictName="T_DIC_XZQH"/>&nbsp;
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=TpersonAlarm.ALIAS_HJD%>
		                  </td>
			              <td>
			            	  <mytag:write property="%{hjd}"  name="hjd"   notEmpty="true"  dictName="T_DIC_XZQH"/>&nbsp;
		                  </td>
                          <td class="crosscolor_td">
			                      <%=TpersonAlarm.ALIAS_ZZ%>
		                  </td>
			              <td >
		                           <s:property value="%{model.zz}" />&nbsp;
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=TpersonAlarm.ALIAS_SG%>
		                  </td>
			              <td>
		                           <s:property value="%{model.sg}" />&nbsp;
		                  </td>
                          <td class="crosscolor_td">
			                      <%=TpersonAlarm.ALIAS_TX%>
		                  </td>
			              <td >
			            	  <mytag:write property="%{tx}"  name="tx"   notEmpty="true"  dictName="T_DIC_SHAPE"/>&nbsp;
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=TpersonAlarm.ALIAS_TSTZ%>
		                  </td>
			              <td>
		                           <s:property value="%{model.tstz}" />&nbsp;
		                  </td>
                          <td class="crosscolor_td">
			                      <%=TpersonAlarm.ALIAS_AB%>
		                  </td>
			              <td >
		                           <s:property value="%{model.ab}" />&nbsp;
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=TpersonAlarm.ALIAS_LADW%>
		                  </td>
			              <td>
		                           <s:property value="%{model.ladw}" />&nbsp;
		                  </td>
                          <td class="crosscolor_td">
			                      <%=TpersonAlarm.ALIAS_LASJ%>
		                  </td>
			              <td >
		                           <s:property value="%{model.lasj}" />&nbsp;
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=TpersonAlarm.ALIAS_JYAQ%>
		                  </td>
			              <td>
		                           <s:property value="%{model.jyaq}" />&nbsp;
		                  </td>
                          <td class="crosscolor_td">
			                      <%=TpersonAlarm.ALIAS_TBDW%>
		                  </td>
			              <td > 
		                           <s:property value="%{model.tbdw}" /> &nbsp;
		                  </td>
                   </tr>
	</table>
</fieldset>
<table>
  <tr>
    <td height=3></td>
  </tr>
</table>

<fieldset>
	<legend>
	   处警信息
	</legend>
<table width="100%" border="1" bordercolor="#7c8ca7" align="center"  cellPadding="0" cellSpacing="0" class="tb_all">
		           <tr class="crosscolor_tr">
			           <td class="crosscolor_td" style="width=200px;">
				                     派警单位
			            </td>
			            <td style="width=340px;">
		                      <s:property value="%{model.pjdw}" />&nbsp;
		                </td>
			            <td class="crosscolor_td" style="width=200px;">
				              <%=TpersonAlarm.ALIAS_CJR%>
			            </td>
				        <td>
			                  <s:property value="%{model.cjr}" />&nbsp;
			            </td>   
		           </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=TpersonAlarm.ALIAS_SFYX%>
		                  </td>
			              <td>
		                         <mytag:write property="%{sfyx}"  name="sfyx"   notEmpty="true"  dictName="sfzh"/>&nbsp;
		                  </td>        
		                   <td class="crosscolor_td">
			                      处警时间
		                  </td>
			              <td>
		                           <s:property value="%{model.pjsj}" />&nbsp;
		                  </td>
		              </tr>    
		           <tr class="crosscolor_tr">
					 <td class="crosscolor_td">
			                      <%=TpersonAlarm.ALIAS_WXYY%>
		                  </td>
			              <td colspan="3">
		                           <s:property value="%{model.wxyy}" />&nbsp;
		                  </td>
		             </tr>
		           <tr class="crosscolor_tr">
		              <td class="crosscolor_td">
			                      <%=TpersonAlarm.ALIAS_ZHDWMC%>
		                  </td>
			              <td>
		                           <s:property value="%{model.zhdwmc}" />&nbsp;
		                  </td>
		                  
		                    <td class="crosscolor_td">
			                      <%=TpersonAlarm.ALIAS_ZHSJ%>
		                  </td>
			              <td>
		                           <s:property value="%{model.zhsj}" />&nbsp;
		                  </td>
		             </tr>
		                <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=TpersonAlarm.ALIAS_WZHYY%>
		                  </td>
			              <td colspan="3">
		                           <s:property value="%{model.wzhyy}" />&nbsp;
		                  </td>
                   </tr>		                  
		           <tr class="crosscolor_tr">
                         
                          <td class="crosscolor_td">
			                      <%=TpersonAlarm.ALIAS_CLQK%>
		                  </td>
			              <td colspan="3">
		                           <s:property value="%{model.clqk}" />&nbsp;
		                  </td>
                   </tr>
	</table>
</fieldset>
<table border="0" align="center" cellpadding="0"  class="tb_all" cellspacing="0">
	 <tr>
		 <td colspan="4" class="tb_bottom">
			  <input type="button" value="返回" onclick="window.location='${ctx}/pages/gas/TpersonAlarm/list.do?<mytag:params includes="ec*,s*" type="queryStringUtf"/>'"/>
		 </td>
	 </tr>
</table>	
</s:form>

</body>

</html>