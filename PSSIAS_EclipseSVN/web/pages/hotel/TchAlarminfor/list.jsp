<%@page import="com.dyneinfo.hotel.model.*" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/commons/taglibs.jsp" %>
<%@ include file="/pages/hotel/commons/getHotelName.jsp" %>
<%@ include file="/pages/hotel/commons/dept.jsp" %>
<%@ include file="/pages/hotel/commons/xzqh.jsp" %>
<%
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+request.getContextPath()+"/";
%>
<html>

<head>
	<%@ include file="/commons/meta.jsp" %>
	<base href="<%=basePath%>">
	<link href="${ctx}/widgets/extremecomponents/extremecomponents.css" type="text/css" rel=stylesheet>
	<title><%=TchAlarminfor.TABLE_ALIAS%> 维护</title>
<script type="text/javascript">


	function loadSelect(){
		queryCity();
		queryCity2();
	}
</script>	
</head>

<body onload="loadSelect()" >
<%@ include file="/commons/messages.jsp" %>

<div class="queryPanel">
    <s:form action="/pages/hotel/TchAlarminfor/list.do"  theme="simple" style="display: inline;" method="post" name="form1">
	    <table cellpadding="0" cellspacing="0" border="0" class="tb_all">
	               <tr>
			              <td class="tb_title" colspan="4"><%=TchAlarminfor.TABLE_ALIAS%>查询</td>
		           </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=TchAlarminfor.ALIAS_NAME%>
		                  </td>
			              <td class="crosscolor_td2">
		                           <input value="${pageRequest.filters.name}"  name="s_name"  />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=TchAlarminfor.ALIAS_SEX%>
		                  </td>
			              <td class="crosscolor_td2">
		                            <mytag:select  name="s_sex" value="${pageRequest.filters.sex}"  notEmpty="false"  dictName="T_DIC_SEX"/>
		                  </td>		                  
                          
                   </tr>
		           <tr class="crosscolor_tr">
		           		  <td class="crosscolor_td">
			                      <%=TchAlarminfor.ALIAS_ID_NAME%>
		                  </td>
			              <td class="crosscolor_td2">
		                           <mytag:select name="s_idName" value="${pageRequest.filters.idName}" notEmpty="false"  dictName="T_ID_NAME"/>
		                  </td>
                          <td class="crosscolor_td">
			                      <%=TchAlarminfor.ALIAS_ID_CODE%>
		                  </td>
			              <td class="crosscolor_td2">
		                           <input value="${pageRequest.filters.idCode}"  name="s_idCode"  />
		                  </td>

                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=TchAlarminfor.ALIAS_NATION%>
		                  </td>
			              <td class="crosscolor_td2">
		                            <mytag:select name="s_nation" value="${pageRequest.filters.nation}" notEmpty="false"  dictName="DIC_ITEM_HOTEL_NATION"/>
		                  </td>
                          <td class="crosscolor_td">
			                      <%=TchAlarminfor.ALIAS_XZQH%>
		                  </td>	           
		                  <td>
						           <mytag:select onchange="changeprov();" name="s_province" value="${pageRequest.filters.province}" notEmpty="false"  dictName="T_DICT_PROV"/>
							      <select name="s_xzqh" value="${pageRequest.filters.xzqh}" />
						          
		                  </td>			                  
                   </tr>
 					<tr class="crosscolor_tr">
	           
                          <td class="crosscolor_td">
			                      <%=TchAlarminfor.ALIAS_BUR_CODE%>
		                  </td>
			              <td>
			              		<mytag:select  name="s_burCode" onchange="cleanHotelName();changeprov2();" value="${pageRequest.filters.burCode}" dictName="ssfj"/>
		                  </td>	
                          <td class="crosscolor_td">
			                      <%=TchAlarminfor.ALIAS_STA_CODE%>
		                  </td>
			              <td>
			              			<select onchange="cleanHotelName();" name="s_staCode"  value="${pageRequest.filters.staCode}"  >
			              			</select>
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
		           			<td class="crosscolor_td">
			                      <%=TchAlarminfor.ALIAS_HOTELNAME%>
		                  </td>
			              <td>
		                           <input size="25" onclick="Click();" onkeyup="getHotelNameByName()" value="${pageRequest.filters.hotelname}"  name="s_hotelname"  />
		                  </td>
		                  <div id="search_suggest" style="position:absolute;z-index:1;margin-top:4px;padding-top:20px;"></div>
                          <td class="crosscolor_td">
			                      <%=TchAlarminfor.ALIAS_PJSJ%>
		                  </td>
			              <td class="crosscolor_td2">
			              <table class="list">
			               <tr>
			              <td>
				                   <s:select name="dateSelect1" list="dateSelectMap"  onchange="dateselect(this,'s_pjsj_Begin','s_pjsj_End','yyyy-MM-dd HH:mm');"  value="#request.dateSelect1" listKey="key"   listValue="value" theme="simple" label=""  emptyOption="false" ></s:select>
			               </td>
			               <td>从</td>
			               <td>
			                          <input id="d31310" name="s_pjsj_Begin"  value="${pageRequest.filters.pjsj_Begin}"   maxlength="0" size="15" class="Wdate" type="text" onFocus="WdatePicker({startDate:'%y-%M-%d 00:00',dateFmt:'yyyy-MM-dd HH:mm',maxDate:'#F{$dp.$D(\'d31410\')}'})"/>
			               <td>到</td>
			               <td>
			                        <input id="d31410" name="s_pjsj_End"   value="${pageRequest.filters.pjsj_End}"  maxlength="0" size="15" class="Wdate" type="text" onFocus="WdatePicker({startDate:'%y-%M-%d 23:59',dateFmt:'yyyy-MM-dd HH:mm',minDate:'#F{$dp.$D(\'d31310\')}'})"/>
			               </td>
			              </tr>
			              </table>
		                  </td>			                           
                   </tr>                      
		           <tr>
			              <td class="tb_bottom" colspan="4">
			                       <input type="submit"  value="查询" onclick="getReferenceForm(this).action='${ctx}/pages/hotel/TchAlarminfor/list.do'"/>
	                               <input style="margin-left: 20px" type="button" value="重置" onclick="resitData(document.forms.form1)"/>
			              </td>
		           </tr>
	    </table>
    </s:form>
</div>



<ec:table items='page.result' var="item" method="get"
	retrieveRowsCallback="limit" sortRowsCallback="limit" filterRowsCallback="limit"
	action="${ctx}/pages/hotel/TchAlarminfor/list.do" autoIncludeParameters="true">
	<ec:row>
		                    <ec:column property="name"  title="<%=TchAlarminfor.ALIAS_NAME%>"/>
		                    <ec:column property="idCode"  title="<%=TchAlarminfor.ALIAS_ID_CODE%>"/>
		                    <ec:column property="hotelname"  title="<%=TchAlarminfor.ALIAS_HOTELNAME%>"/>
		                    <ec:column property="noRoom"  title="<%=TchAlarminfor.ALIAS_NO_ROOM%>"/>
		                    <mytag:lookupcolumn property="burCode"  title="<%=TchAlarminfor.ALIAS_BUR_CODE%>"	cell="net.java.dev.ec.table.view.LookUpCell" dictType="ssfj" />
		                    <ec:column property="pjsj"  title="<%=TchAlarminfor.ALIAS_PJSJ%>" parse="yyyyMMddHHmm" format="yyyy-MM-dd HH:mm" cell="date"/>
		<ec:column property="操作" title="操作" sortable="false" viewsAllowed="html">
			<a href="${ctx}/pages/hotel/TchAlarminfor/show.do?id=${item.id}&<mytag:params includes="ec*,s*" type="queryStringUtf"/>">查看</a>&nbsp;&nbsp;&nbsp;
		</ec:column>
	</ec:row>
</ec:table>

</body>

</html>

