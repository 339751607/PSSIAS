<%@page import="com.dyneinfo.zazh.model.*" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/commons/taglibs.jsp" %>
<%
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+request.getContextPath()+"/";
String picCount = "";
if(request.getAttribute("picCount") != null)
      picCount= (String)request.getAttribute("picCount");

%>
<html>

<head>
	<%@ include file="/commons/meta.jsp" %>
	<base href="<%=basePath%>">
	<title><%=TbkCar.TABLE_ALIAS%></title>
</head>

<body>
<%@ include file="/commons/messages.jsp" %>

<s:form action="/pages/zazh/TbkCar/list.do" method="get" theme="simple">
	<s:hidden name="id" id="id" value="%{model.id}"/>
	<table width="100%" border="1" bordercolor="#7c8ca7" align="center"  cellPadding="0" cellSpacing="0" class="tb_all">
	               <tr>
				          <td colspan="5" class="tb_title"> 
							<%=TbkCar.TABLE_ALIAS%>
				          </td>
		           </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=TbkCar.ALIAS_CARCODE%>
		                  </td>
			              <td>
		                           <s:property value="%{model.carcode}" />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=TbkCar.ALIAS_BODYCODE%>
		                  </td>
			              <td>
		                           <s:property value="%{model.bodycode}" />
		                  </td>
		                   <td rowspan="7" width="20%">
		                       <%if(picCount != null && picCount.equals("1")) { %>
						             <img src='${ctx}/pages/zazh/TbkCar/showPic.do?bkid=<s:property value="%{model.id}" />' height="150" alt="照片" width="120" border="0" name="photo"> 	
						           <% } else {%>
						           <IMG src="${ctx}/images/spacer.gif" height="150" alt="照片" width="120" border="0" name="photo">
						           <%} %>		                                         
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=TbkCar.ALIAS_ENGINECODE%>
		                  </td>
			              <td>
		                           <s:property value="%{model.enginecode}" />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=TbkCar.ALIAS_CARTYPE%>
		                  </td>
			              <td>
		                           <mytag:write  name="cartype"  value="${model.cartype}"   dictName="cllx"  />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=TbkCar.ALIAS_BRAND%>
		                  </td>
			              <td>
		                           <s:property value="%{model.brand}" />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=TbkCar.ALIAS_CARMODE%>
		                  </td>
			              <td>
		                           <s:property value="%{model.carmode}" />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=TbkCar.ALIAS_COLOR%>
		                  </td>
			              <td>
		                           <mytag:write  name="color"  value="${model.color}"   dictName="csys"  />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=TbkCar.ALIAS_CAROWNER%>
		                  </td>
			              <td>
		                           <s:property value="%{model.carowner}" />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=TbkCar.ALIAS_BKPZR%>
		                  </td>
			              <td>
		                           <s:property value="%{model.bkpzr}" />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=TbkCar.ALIAS_BKLX%>
		                  </td>
			              <td>
		                            <mytag:write  name="bklx"  value="${model.bklx}"   dictName="DIC_ITEM_BKLX"  />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=TbkCar.ALIAS_BKDW%>
		                  </td>
			              <td>
		                           <s:property value="%{model.deptname}" />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=TbkCar.ALIAS_BKSJ%>
		                  </td>
			              <td>
		                           <s:property value="%{model.bksj}" />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=TbkCar.ALIAS_ALARMTEL%>
		                  </td>
			              <td colspan="3">
		                           <s:property value="%{model.alarmtel}" />
		                  </td>
                         
                   </tr>
                   <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=TbkCar.ALIAS_JYAQ%>
		                  </td>
			              <td  colspan="4">
		                           <s:property value="%{model.jyaq}" />
		                  </td>

                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=TbkCar.ALIAS_OPERATOR%>
		                  </td>
			              <td>
		                           <s:property value="%{model.operator}" />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=TbkCar.ALIAS_CANCELTIME%>
		                  </td>
			              <td  colspan="2">
		                           <s:property value="%{model.canceltime}" />
		                  </td>
                   </tr>
                   <tr class="crosscolor_tr">
		                  <td class="crosscolor_td">
			                      <%=TbkCar.ALIAS_CANCELFLAG%>
		                  </td>
			              <td>
		                           <mytag:write  name="cancelflag"  value="${model.cancelflag}"   dictName="DIC_ITEM_CKBZ"  />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=TbkCar.ALIAS_CANCELNAME%>
		                  </td>
			              <td  colspan="2">
		                           <s:property value="%{model.cancelname}" />
		                  </td>
                          
                   </tr>
                   <tr class="crosscolor_tr">

                          <td class="crosscolor_td">
			                      <%=TbkCar.ALIAS_CANCELCAUSE%>
		                  </td>
			              <td colspan="4">
		                           <s:property value="%{model.cancelcause}" />
		                  </td>
                   </tr>       
                   <tr>
						  <td colspan="5" class="tb_bottom">
						           <input type="button" value="返回" onclick="window.location='${ctx}/pages/zazh/TbkCar/list.do?<mytag:params includes="ec*,s*" type="queryStringUtf"/>'"/>
	                      </td>
	               </tr>
	</table>	
</s:form>

</body>

</html>