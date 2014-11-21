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
	<title><%=TjwPre.TABLE_ALIAS%> 维护</title>
	<script type="text/javascript">

	function loadSelect(){
		queryCity2();
		document.getElementById("s_TableName").value="${pageRequest.filters.TableName}";
	}
</script>

</head>

<body onload="loadSelect()" >
<%@ include file="/commons/messages.jsp" %>

<div class="queryPanel">
    <s:form action="/pages/hotel/TjwPre/list.do"  theme="simple" style="display: inline;" method="post" name="form1">
	    <table cellpadding="0" cellspacing="0" border="0" class="tb_all">
	               <tr>
			              <td class="tb_title" colspan="4"><%=TjwPre.TABLE_ALIAS%>查询</td>
		           </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=TjwPre.ALIAS_M_FN%>
		                  </td>
			              <td class="crosscolor_td2">
		                           <input value="${pageRequest.filters.mfn}"  name="s_mfn"  />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=TjwPre.ALIAS_CHN_N%>
		                  </td>
			              <td class="crosscolor_td2">
		                           <input value="${pageRequest.filters.chnN}"  name="s_chnN"  />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=TjwPre.ALIAS_SEX%>
		                  </td>
			              <td >
		                           <mytag:select  name="s_sex" value="${pageRequest.filters.sex}"  notEmpty="false"  dictName="T_DIC_SEX"/>
		                  </td>
		                  <td class="crosscolor_td">
			                      <%=TchPre.ALIAS_BDATE%>
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
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=TjwPre.ALIAS_P_NATIONAL%>
		                  </td>
			              <td>
		                           <mytag:select  name="s_pnational" value="${pageRequest.filters.pnational}"  notEmpty="false"  dictName="DIC_ITEM_COUNTRY"/>
		                  </td>
		                  <td class="crosscolor_td">
			                      <%=TjwPre.ALIAS_QF_UNIT%>
		                  </td>
			              <td>
		                           <mytag:select  name="s_qfUnit" value="${pageRequest.filters.qfUnit}"  notEmpty="false"  dictName="DIC_ITEM_VISADEP"/>
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=TjwPre.ALIAS_VISA_T%>
		                  </td>
			              <td>
		                           <mytag:select  name="s_visaT" value="${pageRequest.filters.visaT}"  notEmpty="false"  dictName="DIC_ITEM_VISA"/>
		                  </td>
                          <td class="crosscolor_td">
			                      <%=TjwPre.ALIAS_VISA_NO%>
		                  </td>
			              <td >
		                           <input value="${pageRequest.filters.visaNo}"  name="s_visaNo"  />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=TjwPre.ALIAS_PASS_T%>
		                  </td>
			              <td>
		                           <mytag:select  name="s_passT" value="${pageRequest.filters.passT}"  notEmpty="false"  dictName="DIC_ITEM_PASSPORT"/>
		                  </td>
                          <td class="crosscolor_td">
			                      <%=TjwPre.ALIAS_PASS_NO%>
		                  </td>
			              <td >
		                           <input value="${pageRequest.filters.passNo}"  name="s_passNo"  />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
		                  <td class="crosscolor_td">
			                      <%=TjwPre.ALIAS_IN_DATE%>
		                  </td>

                          <td>
			              <table class="list" >
			               <tr>
			               <td>
			                          <input id="d31323" name="s_inDate_Begin"  value="${pageRequest.filters.inDate_Begin}"   maxlength="0" size="15" class="Wdate" type="text" onFocus="WdatePicker({dateFmt:'yyyy-MM-dd',maxDate:'#F{$dp.$D(\'d31423\')}'})"/>
			               <td>到</td>
			               <td>
			                        <input id="d31423" name="s_inDate_End"   value="${pageRequest.filters.inDate_End}"  maxlength="0" size="15" class="Wdate" type="text" onFocus="WdatePicker({dateFmt:'yyyy-MM-dd',minDate:'#F{$dp.$D(\'d31323\')}'})"/>
			               </td>
			              </tr>
			              </table>
		                  </td>
                          <td class="crosscolor_td">
			                      <%=TjwPre.ALIAS_STAY_DATE%>
		                  </td>
		                  <td>
			              <table class="list" >
			               <tr>
			               <td>
			                          <input id="d31322" name="s_stayDate_Begin"  value="${pageRequest.filters.stayDate_Begin}"   maxlength="0" size="15" class="Wdate" type="text" onFocus="WdatePicker({dateFmt:'yyyy-MM-dd',maxDate:'#F{$dp.$D(\'d31422\')}'})"/>
			               <td>到</td>
			               <td>
			                        <input id="d31422" name="s_stayDate_End"   value="${pageRequest.filters.stayDate_End}"  maxlength="0" size="15" class="Wdate" type="text" onFocus="WdatePicker({dateFmt:'yyyy-MM-dd',minDate:'#F{$dp.$D(\'d31322\')}'})"/>
			               </td>
			              </tr>
			              </table>
		                  </td>
                   </tr>

		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=TjwPre.ALIAS_BUR_CODE%>
		                  </td>
			              <td>
			              		<mytag:select  name="s_burCode" onchange="cleanHotelName();changeprov2();" value="${pageRequest.filters.burCode}" dictName="ssfj"/>
		                  </td>
                          <td class="crosscolor_td">
			                      <%=TjwPre.ALIAS_IN_TIME%>
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
			                      <%=TjwPre.ALIAS_STA_CODE%>
		                  </td>
			              <td>
		                           	<select onchange="cleanHotelName();" name="s_staCode"  value="${pageRequest.filters.staCode}"  >
			              			</select>
		                  </td>
		                   <td class="crosscolor_td">
			                      <%=TjwPre.ALIAS_OUT_TIME%>
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
			                      <%=TjwPre.ALIAS_HOTELNAME%>
		                  </td>
			              <td>
		                           <input onclick="Click();" onkeyup="getHotelNameByName()" value="${pageRequest.filters.hotelname}"  name="s_hotelname"  />
		                  </td>
		                   <div id="search_suggest" style="position:absolute;z-index:1;margin-top:4px;padding-top:20px;"></div>
		              	<td class="crosscolor_td">
		               	旅客状态
		               </td>
                       <td>					  
						 <select name="s_TableName" size="1" value="${pageRequest.filters.TableName}">
						   <option value="">全部旅客信息</option>
						   <option value="T_JW_PRE">在住旅客信息</option>
						   <option value="T_JW_REC">退宿旅客信息</option>
						   <option value="T_JW_HIS">历史旅客信息</option>
						 </select>					 
					   </td>
                   </tr>



		           <tr>
			              <td class="tb_bottom" colspan="4">
			                       <input type="submit"  value="查询" onclick="getReferenceForm(this).action='${ctx}/pages/hotel/TjwPre/list.do'"/>
			              	       <input style="margin-left: 20px" type="button" value="重置" onclick="resitData(document.forms.form1)"/>
			              </td>
		           </tr>
	    </table>
    </s:form>
</div>


			
</body>

</html>
