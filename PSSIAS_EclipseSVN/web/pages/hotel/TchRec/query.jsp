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
	<title><%=TchRec.TABLE_ALIAS%> 维护</title>
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
    <s:form action="/pages/hotel/TchRec/list.do"  theme="simple" style="display: inline;" method="post" name="form1">
	    <table width="100%" border="1" bordercolor="#7c8ca7" align="center"  cellPadding="0" cellSpacing="0" class="tb_all">
	               <tr>
			              <td class="tb_title" colspan="4"><%=TchRec.TABLE_ALIAS%>查询</td>
		           </tr>
					<tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=TchRec.ALIAS_NAME%>
		                  </td>
			              <td class="crosscolor_td2">
		                           <input size="25" value="${pageRequest.filters.name}" id="s_name" name="s_name"  />
		                  </td>		           
                          <td class="crosscolor_td">
			                      <%=TchRec.ALIAS_ID_CODE%>
		                  </td>
		                  <td class="crosscolor_td2">
						           <mytag:select name="s_idName" value="${pageRequest.filters.idName}" notEmpty="false"  dictName="T_ID_NAME"/>
						           <input size="20" value="${pageRequest.filters.idCode}"  name="s_idCode"  />
		                  </td>		           

                   </tr>
                   <tr class="crosscolor_tr">
			              <td class="crosscolor_td">
			                      <%=TchRec.ALIAS_BDATE%>
		                  </td>
		                  <td>
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
			                      <%=TchRec.ALIAS_SEX%>
		                  </td>
		                   <td>
		                             <mytag:select  name="s_sex" value="${pageRequest.filters.sex}"  notEmpty="false"  dictName="T_DIC_SEX"/>
		                  </td>		                  	                  
	                   
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=TchRec.ALIAS_XZQH%>
		                  </td>	           
		                  <td>
						           <mytag:select onchange="changeprov();" name="s_province" value="${pageRequest.filters.province}" notEmpty="false"  dictName="T_DICT_PROV"/>
							      <select style="margin-left: 10px" name="s_xzqh"></select>
						          
		                  </td>	
		                  <td class="crosscolor_td">
			                      <%=TchRec.ALIAS_NATION%>
		                  </td>
		                  <td>
						           <mytag:select name="s_nation" value="${pageRequest.filters.nation}" notEmpty="false"  dictName="DIC_ITEM_HOTEL_NATION"/>
		                  </td>	


                   </tr>                      
		           <tr class="crosscolor_tr">
	           
                          <td class="crosscolor_td">
			                      <%=TchRec.ALIAS_BUR_CODE%>
		                  </td>
			              <td>
			              		<mytag:select  name="s_burCode" onchange="cleanHotelName();changeprov2();" value="${pageRequest.filters.burCode}" dictName="ssfj"/>
		                  </td>	
                          <td class="crosscolor_td">
			                      <%=TchRec.ALIAS_IN_TIME%>
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
                   </tr>
		           <tr class="crosscolor_tr">

		                  	           
                          <td class="crosscolor_td">
			                      <%=TchRec.ALIAS_STA_CODE%>
		                  </td>
			              <td>
			              			<select onchange="cleanHotelName();" name="s_staCode"  value="${pageRequest.filters.staCode}"  >
			              			</select>
		                  </td>
		           		  <td class="crosscolor_td">
			                      <%=TchRec.ALIAS_OUT_TIME%>
		                  </td>
		                  <td>
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
                   </tr>
		           <tr class="crosscolor_tr">
		           			<td class="crosscolor_td">
			                      <%=TchRec.ALIAS_HOTELNAME%>
		                  </td>
			              <td>
		                           <input size="25" onclick="Click();" onkeyup="getHotelNameByName()" value="${pageRequest.filters.hotelname}"  name="s_hotelname"  />
		                  </td>
		                  <div id="search_suggest" style="position:absolute;z-index:1;margin-top:4px;padding-top:20px;"></div>
                          <td class="crosscolor_td">
			                      	最低<%=TchRec.ALIAS_DAYS%>
		                  </td>
			              <td class="crosscolor_td2">
		                           <input size="25" value="${pageRequest.filters.days}" id="s_days" name="s_days" class="validate-digits" />
		                  </td>			               
                   </tr>                 
		           <tr>		          
		           <tr>
			              <td class="tb_bottom" colspan="4">
			                       <input type="submit" id="submitButton" value="查询" onclick="getReferenceForm(this).action='${ctx}/pages/hotel/TchRec/list.do'"/>
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