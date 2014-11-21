<%@page import="com.dyneinfo.hotel.model.*" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/commons/taglibs.jsp" %>
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
	<title><%=TchPre.TABLE_ALIAS%> 维护</title>
<script type="text/javascript">

	function loadSelect(){
		queryCity();
		queryCity2();
		document.getElementById("s_origin2").value=document.getElementById("s_origin").value;
	}
</script>
<script>
	function changeXzqh(){
		var xzqh = document.getElementById("s_xzqh").options[document.getElementById("s_xzqh").selectedIndex].text;
		var xzqhCode = document.getElementById("s_xzqh").value;
		document.getElementById("s_origin").value+=xzqh+';';
		document.getElementById("s_origin2").value+=xzqh+';';
		document.getElementById("s_originCode").value+=xzqhCode+';';

	}
	function clearInput(){
		document.getElementById("s_originCode").value="";
		document.getElementById("s_origin").value="";
	}
</script>
</head>

<body onload="loadSelect()" >
<%@ include file="/commons/messages.jsp" %>

<div class="queryPanel">
    <s:form action="/pages/hotel/TchXzqh/list.do" name="form1" theme="simple" style="display: inline;" method="post">
	    <table cellpadding="0" cellspacing="0" border="0" class="tb_all">
	              <input type="hidden"  name="s_originCode" value="${pageRequest.filters.originCode}"/>	
	               <tr>
			              <td class="tb_title" colspan="4">重点来源地查询</td>
		           </tr>
		            <tr class="crosscolor_tr">
		                  <td class="crosscolor_td">
			                      <%=TchPre.ALIAS_NATION%>
		                  </td>
		                  <td class="crosscolor_td2">
						           <mytag:select name="s_nation" value="${pageRequest.filters.nation}" notEmpty="false"  dictName="DIC_ITEM_HOTEL_NATION"/>
		                  </td>	
	           
                          <td class="crosscolor_td">
			                      <%=TchPre.ALIAS_BUR_CODE%>
		                  </td>
			              <td class="crosscolor_td2">
			              		<mytag:select  name="s_burCode" onchange="changeprov2();" value="${pageRequest.filters.burCode}" dictName="ssfj"/>
		                  </td>	
                   </tr>
		           <tr class="crosscolor_tr">
		                  <td class="crosscolor_td">
			                      <%=TchPre.ALIAS_XZQH%>
		                  </td>	           
		                  <td>
						           <mytag:select onchange="changeprov();" name="s_province" value="${pageRequest.filters.province}" notEmpty="false"  dictName="T_DICT_PROV"/>
							      <select  style="margin-left: 10px"  name="s_xzqh"  onchange="changeXzqh()"></select>
						          
		                  </td>	
                          <td class="crosscolor_td">
			                      <%=TchPre.ALIAS_STA_CODE%>
		                  </td>
			              <td>
			              			<select name="s_staCode">
			              			</select>
		                  </td>
                   </tr>
                   
                   
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                     来源地
		                  </td>
			              <td colspan="3">
		                           <input type="hidden" value="${pageRequest.filters.origin}" name="s_origin" >
		                           <input size="85" name="s_origin2" disabled="disabled" />
		                  </td>		           
                   </tr>
                    <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=TchPre.ALIAS_IN_TIME%>
		                  </td>
			              <td>
			             	<table class="list">
			               <tr>
			              <td>
				                   <s:select name="dateSelect1" list="dateSelectMap"  onchange="dateselect(this,'s_inTime_Begin','s_inTime_End','yyyy-MM-dd HH:mm');"  value="#request.dateSelect1" listKey="key"   listValue="value" theme="simple" label=""  emptyOption="false" ></s:select>
			               </td>
			               <td>从</td>
			               <td>
			                          <input id="d31310" name="s_inTime_Begin"  value="${pageRequest.filters.inTime_Begin}"   maxlength="0" size="15" class="Wdate" type="text" onFocus="WdatePicker({startDate:'%y-%M-%d 00:00:00',dateFmt:'yyyy-MM-dd HH:mm',maxDate:'#F{$dp.$D(\'d31410\')}'})"/>
			               <td>到</td>
			               <td>
			                        <input id="d31410" name="s_inTime_End"   value="${pageRequest.filters.inTime_End}"  maxlength="0" size="15" class="Wdate" type="text" onFocus="WdatePicker({startDate:'%y-%M-%d 23:59:00',dateFmt:'yyyy-MM-dd HH:mm',minDate:'#F{$dp.$D(\'d31310\')}'})"/>
			               </td>
			              </tr>
			              </table>
		                  </td>	
		                  <td></td>	
		                  <td></td>	
		                  
                   </tr>
		           <tr>
			              <td class="tb_bottom" colspan="4">
			                       <input type="submit"  value="查询" onclick="getReferenceForm(this).action='${ctx}/pages/hotel/TchXzqh/list.do'"/>
			                       <input style="margin-left: 20px" type="button" value="重置" onclick="clearInput();resitData(document.forms.form1)"/>
			              </td>
		           </tr>
	    </table>
    </s:form>
</div>

	
</body>

</html>