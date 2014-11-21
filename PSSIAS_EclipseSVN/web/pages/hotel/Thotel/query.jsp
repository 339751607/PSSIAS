<%@page import="com.dyneinfo.hotel.model.*" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/commons/taglibs.jsp" %>
<%@ include file="/pages/hotel/commons/getHotelName.jsp" %>
<%@ include file="/pages/hotel/commons/dept.jsp" %>
<%
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+request.getContextPath()+"/";
%>
<html>

<head>
	<%@ include file="/commons/meta.jsp" %>
	<base href="<%=basePath%>">
	<link href="${ctx}/widgets/extremecomponents/extremecomponents.css" type="text/css" rel=stylesheet>
	<title><%=Thotel.TABLE_ALIAS%> 维护</title>
<script type="text/javascript">
	function loadSelect(){
		queryCity2();
	}
</script>

</head>

<body onload="loadSelect()" >
<%@ include file="/commons/messages.jsp" %>

<div class="queryPanel">
    <s:form action="/pages/hotel/Thotel/list.do"  theme="simple" style="display: inline;" method="post" name="form1">
	    <table cellpadding="0" cellspacing="0" border="0" class="tb_all">
	               <tr>
			              <td class="tb_title" colspan="4"><%=Thotel.TABLE_ALIAS%>查询</td>
		           </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=Thotel.ALIAS_BUR_CODE%>
		                  </td>
			              <td class="crosscolor_td2">
			              		<mytag:select  name="s_burCode" onchange="cleanHotelName();changeprov2();" value="${pageRequest.filters.burCode}" dictName="ssfj"/>
		                  </td>
                          <td class="crosscolor_td">
			                      <%=Thotel.ALIAS_STA_CODE%>
		                  </td>
			              <td class="crosscolor_td2">
		                           	<select onchange="cleanHotelName();" name="s_staCode" >
			              			</select>
		                  </td>
                   </tr>		           
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=Thotel.ALIAS_CALLED%>
		                  </td>
			              <td class="crosscolor_td2">
		                           <input onclick="Click();" onkeyup="getHotelNameByName()" value="${pageRequest.filters.hotelname}"  name="s_hotelname"  />
		                  </td>
		                  <div id="search_suggest" style="position:absolute;z-index:1;margin-top:4px;padding-top:20px;"></div>	
                          <td class="crosscolor_td">
			                      <%=Thotel.ALIAS_BED_NUM%>
		                  </td>
		                  <td>
			              <table class="list" >
			               <tr>
			               <td>
		                           <input size="15" value="${pageRequest.filters.bedNum_Begin}"  name="s_bedNum_Begin" class="validate-digits"/>
		                   </td>
			               <td>到</td>
			               <td>
		                           <input size="15" value="${pageRequest.filters.bedNum_End}"  name="s_bedNum_End"  class="validate-digits great-than-equal-s_bedNum_Begin"  />
			               </td>
			              </tr>
			              </table>
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=Thotel.ALIAS_STATUS%>
		                  </td>
			              <td class="crosscolor_td2">
			              		<mytag:select  name="s_status"  value="${pageRequest.filters.status}" dictName="DIC_ITEM_HOTEL_STATUS"/>
		                  </td>
                          <td class="crosscolor_td">
			                      <%=Thotel.ALIAS_MOD_TIME%>
		                  </td>
		                  <td>
			              <table class="list" >
			               <tr>
			              <td>
				                   <s:select name="dateSelect1" list="dateSelectMap"  onchange="dateselect(this,'s_modTime_Begin','s_modTime_End','yyyy-MM-dd');"  value="#request.dateSelect1" listKey="key"   listValue="value" theme="simple" label=""  emptyOption="false" ></s:select>
			               </td>
			               <td>从</td>				               
			               <td>
			                          <input id="d31312" name="s_modTime_Begin"  value="${pageRequest.filters.modTime_Begin}"   maxlength="0" size="15" class="Wdate" type="text" onFocus="WdatePicker({dateFmt:'yyyy-MM-dd',maxDate:'#F{$dp.$D(\'d31412\')}'})"/>
			               <td>到</td>
			               <td>
			                        <input id="d31412" name="s_modTime_End"   value="${pageRequest.filters.modTime_End}"  maxlength="0" size="15" class="Wdate" type="text" onFocus="WdatePicker({dateFmt:'yyyy-MM-dd',minDate:'#F{$dp.$D(\'d31312\')}'})"/>
			               </td>
			              </tr>
			              </table>
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=Thotel.ALIAS_STAR%>
		                  </td>
			              <td class="crosscolor_td2">
			              		<mytag:select  name="s_star"  value="${pageRequest.filters.star}" dictName="DIC_ITEM_HOTEL_STAR"/>
		                  </td>
                          <td class="crosscolor_td">
		                  </td>
			              <td class="crosscolor_td2">
		                  </td>
                   </tr>                   

		           <tr>
			              <td class="tb_bottom" colspan="4">
			                       <input type="submit" id="submitButton" value="查询" onclick="getReferenceForm(this).action='${ctx}/pages/hotel/Thotel/list.do'"/>
			              		   <input style="margin-left: 20px" type="button" value="重置" onclick="resitData(document.forms.form1)"/>
			              </td>
		           </tr>
	    </table>
    </s:form>
</div>

<script>
	
	new Validation(document.forms[0],{onSubmit:true,onFormValidate : function(result,form) {
		var finalResult = result;
		
		//在这里添加自定义验证
		
		return disableSubmit(finalResult,'submitButton');
	}});
</script>
	
</body>

</html>