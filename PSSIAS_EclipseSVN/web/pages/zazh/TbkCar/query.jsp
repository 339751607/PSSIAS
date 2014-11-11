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
	<title><%=TbkCar.TABLE_ALIAS%>查询</title>
</head>

<body>
<%@ include file="/commons/messages.jsp" %>
<div class="queryPanel">
    <s:form action="/pages/zazh/TbkCar/list.do"  theme="simple" style="display: inline;" method="post">
	    <table width="100%" border="1" bordercolor="#7c8ca7" align="center"  cellPadding="0" cellSpacing="0" class="tb_all">
	               <tr>
			              <td class="tb_title" colspan="4"><%=TbkCar.TABLE_ALIAS%>查询</td>
		           </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=TbkCar.ALIAS_CARCODE%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.carcode}"  name="s_carcode"  />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=TbkCar.ALIAS_BODYCODE%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.bodycode}"  name="s_bodycode"  />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=TbkCar.ALIAS_ENGINECODE%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.enginecode}"  name="s_enginecode"  />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=TbkCar.ALIAS_CARTYPE%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.cartype}"  name="s_cartype"  />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=TbkCar.ALIAS_BRAND%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.brand}"  name="s_brand"  />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=TbkCar.ALIAS_CARMODE%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.carmode}"  name="s_carmode"  />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=TbkCar.ALIAS_COLOR%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.color}"  name="s_color"  />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=TbkCar.ALIAS_CAROWNER%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.carowner}"  name="s_carowner"  />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=TbkCar.ALIAS_BKPZR%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.bkpzr}"  name="s_bkpzr"  />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=TbkCar.ALIAS_BKLX%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.bklx}"  name="s_bklx"  />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=TbkCar.ALIAS_BKDW%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.bkdw}"  name="s_bkdw"  />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=TbkCar.ALIAS_BKSJ%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.bksj}"  name="s_bksj"  />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=TbkCar.ALIAS_JYAQ%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.jyaq}"  name="s_jyaq"  />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=TbkCar.ALIAS_ALARMTEL%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.alarmtel}"  name="s_alarmtel"  />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=TbkCar.ALIAS_OPERATOR%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.operator}"  name="s_operator"  />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=TbkCar.ALIAS_CANCELFLAG%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.cancelflag}"  name="s_cancelflag"  />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=TbkCar.ALIAS_CANCELTIME%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.canceltime}"  name="s_canceltime"  />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=TbkCar.ALIAS_CANCELCAUSE%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.cancelcause}"  name="s_cancelcause"  />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=TbkCar.ALIAS_CANCELNAME%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.cancelname}"  name="s_cancelname"  />
		                  </td>
                          <td>&nbsp;</td>
                          <td>&nbsp;</td>
                   </tr>
		           <tr>
			              <td class="tb_bottom" colspan="4">
			                       <input type="submit"  value="查询" onclick="getReferenceForm(this).action='${ctx}/pages/zazh/TbkCar/list.do'"/>
	                               <input type="submit"  value="新增" onclick="getReferenceForm(this).action='${ctx}/pages/zazh/TbkCar/create.do?<mytag:params includes="ec*,s*" type="queryStringUtf"/>'"/>
			              </td>
		           </tr>
	    </table>
    </s:form>
</div>
			
</body>

</html>