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
	<title><%=TtjGuestType.TABLE_ALIAS%> 维护</title>
<script type="text/javascript">

	function loadSelect(){
		queryCity();
		queryCity2();
		document.getElementById("s_TableName").value="${pageRequest.filters.TableName}";
	}
</script>
</head>

<body onload="loadSelect()" >
<%@ include file="/commons/messages.jsp" %>

<div class="queryPanel">
    <s:form action="/pages/hotel/TtjGuestType/list.do" name="form1" theme="simple" style="display: inline;" method="post">
	    <table cellpadding="0" cellspacing="0" border="0" class="tb_all">
	               <tr>
			              <td class="tb_title" colspan="4"><%=TtjGuestType.TABLE_ALIAS %></td>
		           </tr>
                   <tr class="crosscolor_tr">
			              <td class="crosscolor_td">
			                      <%=TtjGuestType.ALIAS_BDATE%>
		                  </td>
		                  <td class="crosscolor_td2">
			              <table class="list" >
			               <tr>
			               <td>
			                          <input id="d31312" name="s_bdate_Begin"  value="${pageRequest.filters.bdate_Begin}"   maxlength="0" size="15" class="Wdate" type="text" onFocus="WdatePicker({dateFmt:'yyyy-MM-dd',maxDate:'#F{$dp.$D(\'d31412\')}'})"/>
			               <td>到</td>
			               <td>
			                        <input id="d31412" name="s_bdate_End"   value="${pageRequest.filters.bdate_End}"  maxlength="0" size="15" class="Wdate" type="text" onFocus="WdatePicker({dateFmt:'yyyy-MM-dd',minDate:'#F{$dp.$D(\'d31312\')}'})"/>
			               </td>
			              </tr>
			              </table>
		                  </td>                   
                          <td class="crosscolor_td">
			                      <%=TtjGuestType.ALIAS_XZQH%>
		                  </td>	           
		                  <td class="crosscolor_td2">
						           <mytag:select onchange="changeprov();" name="s_province" value="${pageRequest.filters.province}" notEmpty="false"  dictName="T_DICT_PROV"/>
							      <select style="margin-left: 10px" name="s_xzqh" ></select>
						          
		                  </td>	
	                   
                   </tr>
                     
		           <tr class="crosscolor_tr">
	           
                          <td class="crosscolor_td">
			                      <%=TtjGuestType.ALIAS_IN_TIME%>
		                  </td>
			              <td class="crosscolor_td2">
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
                          <td class="crosscolor_td">
			                      <%=TtjGuestType.ALIAS_BUR_CODE%>
		                  </td>
			              <td class="crosscolor_td2">
			              		<mytag:select  name="s_burCode" onchange="cleanHotelName();changeprov2();" value="${pageRequest.filters.burCode}" dictName="ssfj"/>
		                  </td>	
                   </tr>
		           <tr class="crosscolor_tr">

		                  	           
		           		  <td class="crosscolor_td">
			                      <%=TtjGuestType.ALIAS_OUT_TIME%>
		                  </td>
		                  <td class="crosscolor_td2">
			              <table class="list">
			               <tr>
			              <td>
				                   <s:select name="dateSelect2" list="dateSelectMap"  onchange="dateselect(this,'s_outTime_Begin','s_outTime_End','yyyy-MM-dd HH:mm');"  value="#request.dateSelect2" listKey="key"   listValue="value" theme="simple" label=""  emptyOption="false" ></s:select>
			               </td>
			               <td>从</td>
			               <td>
			                          <input id="d31311" name="s_outTime_Begin"  value="${pageRequest.filters.outTime_Begin}"   maxlength="0" size="15" class="Wdate" type="text" onFocus="WdatePicker({startDate:'%y-%M-%d 00:00:00',dateFmt:'yyyy-MM-dd HH:mm',maxDate:'#F{$dp.$D(\'d31411\')}'})"/>
			               <td>到</td>
			               <td>
			                        <input id="d31411" name="s_outTime_End"   value="${pageRequest.filters.outTime_End}"  maxlength="0" size="15" class="Wdate" type="text" onFocus="WdatePicker({startDate:'%y-%M-%d 23:59:00',dateFmt:'yyyy-MM-dd HH:mm',minDate:'#F{$dp.$D(\'d31311\')}'})"/>
			               </td>
			              </tr>
			              </table>
		                  </td>	
                          <td class="crosscolor_td">
			                      <%=TtjGuestType.ALIAS_STA_CODE%>
		                  </td>
			              <td class="crosscolor_td2">
			              			<select onchange="cleanHotelName();" name="s_staCode"  value="${pageRequest.filters.staCode}"  >
			              			</select>
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
		              	<td class="crosscolor_td">
		               	旅客状态
		               </td>	               
                       <td class="crosscolor_td2">					  
						 <select name="s_TableName" size="1" value="${pageRequest.filters.TableName}">
						   <option value="">全部旅客信息</option>
						   <option value="T_CH_PRE">在住旅客信息</option>
						   <option value="T_CH_REC">退宿旅客信息</option>
						   <option value="T_CH_HIS">历史旅客信息</option>
						 </select>					 
					   </td>
		           			<td class="crosscolor_td">
			                      <%=TtjGuestType.ALIAS_HOTELNAME%>
		                  </td>
			              <td class="crosscolor_td2">
		                           <input size="25" onclick="Click();" onkeyup="getHotelNameByName();" value="${pageRequest.filters.hotelname}"  name="s_hotelname"  />
		                  </td>
		                  <div id="search_suggest" style="position:absolute;z-index:1;margin-top:4px;padding-top:20px;"></div>
                   </tr>                 
		           <tr>
			              <td class="tb_bottom" colspan="4">
			                       <input type="submit"  value="统计" onclick="getReferenceForm(this).action='${ctx}/pages/hotel/TtjGuestType/list.do'"/>
			                       <input style="margin-left: 20px" type="button" value="重置" onclick="resitData(document.forms.form1)"/>
			              </td>
		           </tr>
	    </table>
    </s:form>
</div>


			
</body>

</html>