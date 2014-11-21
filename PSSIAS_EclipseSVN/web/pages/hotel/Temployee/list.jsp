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
	<title><%=Temployee.TABLE_ALIAS%> 维护</title>
	
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
    <s:form action="/pages/hotel/Temployee/list.do"  theme="simple"  method="post" name="form1">
	    <table cellpadding="0" cellspacing="0" border="0" class="tb_all">
	               <tr>
			              <td class="tb_title" colspan="4"><%=Temployee.TABLE_ALIAS%>查询</td>
		           </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=Temployee.ALIAS_EMPNAME%>
		                  </td>
			              <td class="crosscolor_td2">
		                           <input value="${pageRequest.filters.empname}"  name="s_empname"  />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=Temployee.ALIAS_SEX%>
		                  </td>
			              <td class="crosscolor_td2">
		                           <mytag:select  name="s_sex" value="${pageRequest.filters.sex}"  notEmpty="false"  dictName="T_DIC_SEX"/>
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=Temployee.ALIAS_FOLK%>
		                  </td>
			              <td class="crosscolor_td">
		                           <mytag:select name="s_folk" value="${pageRequest.filters.folk}" notEmpty="false"  dictName="DIC_ITEM_HOTEL_NATION"/>
		                  </td>		           
                          <td class="crosscolor_td">
			                      <%=Temployee.ALIAS_BIRTH%>
		                  </td>
		                  <td>
			              <table class="list" >
			               <tr>
			               <td>
			                          <input id="d31311" name="s_bdate_Begin"  value="${pageRequest.filters.bdate_Begin}"   maxlength="0" size="15" class="Wdate" type="text" onFocus="WdatePicker({dateFmt:'yyyy-MM-dd',maxDate:'#F{$dp.$D(\'d31411\')}'})"/>
			               <td>到</td>
			               <td>
			                        <input id="d31411" name="s_bdate_End"   value="${pageRequest.filters.bdate_End}"  maxlength="0" size="15" class="Wdate" type="text" onFocus="WdatePicker({dateFmt:'yyyy-MM-dd',minDate:'#F{$dp.$D(\'d31311\')}'})"/>
			               </td>
			              </tr>
			              </table>
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=Temployee.ALIAS_NPCODE%>
		                  </td>	           
		                  <td>
						           <mytag:select onchange="changeprov();" name="s_province" value="${pageRequest.filters.province}" notEmpty="false"  dictName="T_DICT_PROV"/>
							      <select style="margin-left: 10px" name="s_xzqh" ></select>
						          
		                  </td>
                          <td class="crosscolor_td">
			                      <%=Temployee.ALIAS_PERSONID%>
		                  </td>
			              <td >
		                           <input value="${pageRequest.filters.personid}"  name="s_personid"  />
		                  </td>		                  
		           </tr>

		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=Temployee.ALIAS_INSERTTIME%>
		                  </td>
		                  <td>
			              <table class="list" >
			               <tr>
						              <td>
							                   <s:select name="dateSelect1" list="dateSelectMap"  onchange="dateselect(this,'s_inTime_Begin','s_inTime_End','yyyy-MM-dd');"  value="#request.dateSelect1" listKey="key"   listValue="value" theme="simple" label=""  emptyOption="false" ></s:select>
						               </td>
					              		 <td>从</td>			               
			               <td>
			                          <input id="d31312" name="s_intime_Begin"  value="${pageRequest.filters.intime_Begin}"   maxlength="0" size="15" class="Wdate" type="text" onFocus="WdatePicker({dateFmt:'yyyy-MM-dd',maxDate:'#F{$dp.$D(\'d31412\')}'})"/>
			               <td>到</td>
			               <td>
			                        <input id="d31412" name="s_intime_End"   value="${pageRequest.filters.intime_End}"  maxlength="0" size="15" class="Wdate" type="text" onFocus="WdatePicker({dateFmt:'yyyy-MM-dd',minDate:'#F{$dp.$D(\'d31312\')}'})"/>
			               </td>
			              </tr>
			              </table>
		                  </td>
                          <td class="crosscolor_td">
			                      <%=Temployee.ALIAS_CYRJZT%>
		                  </td>
			              <td class="crosscolor_td">
			              		<mytag:select  name="s_cyrjzt" value="${pageRequest.filters.cyrjzt}" dictName="cyryFlag"/>
		                  </td>
                   </tr>
		           		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=Temployee.ALIAS_BURCODE%>
		                  </td>
			              <td>
			              		<mytag:select  name="s_burCode" onchange="changeprov2();" value="${pageRequest.filters.burCode}" dictName="ssfj"/>
		                  </td>	
		                  	           
                          <td class="crosscolor_td">
			                      <%=Temployee.ALIAS_STACODE%>
		                  </td>
			              <td>
			              			<select name="s_staCode" >
			              			</select>
		                  </td>

                   </tr>
		           <tr class="crosscolor_tr">
		           			<td class="crosscolor_td">
			                      <%=Temployee.ALIAS_HOTELNAME%>
		                  </td>
			              <td>
		                           <input size="25" onclick="Click();" onkeyup="getHotelNameByName()" value="${pageRequest.filters.hotelname}"  name="s_hotelname"  />
		                  </td>
		                  <div id="search_suggest" style="position:absolute;z-index:1;margin-top:4px;padding-top:20px;"></div>
		                  <td></td>
		                  <td></td>
		           </tr>		           
		           
		           <tr>
			              <td class="tb_bottom" colspan="4">
			                       <input type="submit"  value="查询" onclick="getReferenceForm(this).action='${ctx}/pages/hotel/Temployee/list.do'"/>
			                       <input style="margin-left: 20px" type="button" value="重置" onclick="resitData(document.forms.form1)"/>
			              </td>
		           </tr>
	    </table>
    </s:form>
</div>



<ec:table items='page.result' var="item" method="get"
	retrieveRowsCallback="limit" sortRowsCallback="limit" filterRowsCallback="limit"
	action="${ctx}/pages/hotel/Temployee/list.do" autoIncludeParameters="true">
	<ec:exportXls fileName="employee.xls" tooltip="输出Excel文件"/>
	<ec:row>
		                    <ec:column property="empname"  title="<%=Temployee.ALIAS_EMPNAME%>"/>
		                    <ec:column property="birth"  title="<%=Temployee.ALIAS_BIRTH%>" parse="yyyyMMdd" format="yyyy-MM-dd" cell="date"/>
		                    <ec:column property="personid"  title="<%=Temployee.ALIAS_PERSONID%>"/>
		                    <ec:column property="address"  title="<%=Temployee.ALIAS_ADDRESS%>"/>
		                    <ec:column property="hotelname"  title="<%=Temployee.ALIAS_HOTELNAME%>"/>
		                    <mytag:lookupcolumn property="cyrjzt"  title="<%=Temployee.ALIAS_CYRJZT%>"	cell="net.java.dev.ec.table.view.LookUpCell" dictType="cyryFlag" />
		                    <ec:column property="inserttime"  title="<%=Temployee.ALIAS_INSERTTIME%>" parse="yyyyMMddHHmmss" format="yyyy-MM-dd" cell="date"/>
		                    
		<ec:column property="操作" title="操作" sortable="false" viewsAllowed="html">
			<a href="${ctx}/pages/hotel/Temployee/show.do?empcode=${item.empcode}&<mytag:params includes="ec*,s*" type="queryStringUtf"/>">查看</a>&nbsp;&nbsp;&nbsp;
		</ec:column>
	</ec:row>
</ec:table>

</body>

</html>


