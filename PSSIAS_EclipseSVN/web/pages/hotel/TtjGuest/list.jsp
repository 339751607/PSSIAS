<%@page import="com.dyneinfo.hotel.model.*" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/commons/taglibs.jsp" %>
<%@ include file="/pages/hotel/commons/dept.jsp" %>

<%
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+request.getContextPath()+"/";
%>
<html>

<head>
	<%@ include file="/commons/meta.jsp" %>
	<base href="<%=basePath%>">
	<link href="${ctx}/widgets/extremecomponents/extremecomponents.css" type="text/css" rel=stylesheet>
	<title><%=TtjGuest.TABLE_ALIAS%> 维护</title>

<script type="text/javascript">
	function loadSelect(){
		queryCity2();
		var type = "${pageRequest.filters.type}"
		if(1==type){
			document.getElementById("radio1").checked = true;
		}else{
			document.getElementById("radio0").checked = true;
		}
		
		document.getElementById("s_TableName").value="${pageRequest.filters.TableName}";		
		
	}
	function rt(){
		document.getElementById("radio0").checked = true;
	}
</script>

</head>

<body onload="loadSelect()" >
<%@ include file="/commons/messages.jsp" %>

<div class="queryPanel">
    <s:form action="/pages/hotel/TtjGuest/list.do"  theme="simple" style="display: inline;" method="post" name="form1">
	    <table cellpadding="0" cellspacing="0" border="0" class="tb_all">
	               <tr>
			              <td class="tb_title" colspan="4"><%=TtjGuest.TABLE_ALIAS%></td>
		           </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=TtjGuest.ALIAS_BUR_CODE%>
		                  </td>
			              <td class="crosscolor_td2">
			              		<mytag:select  name="s_burCode" onchange="changeprov2();" value="${pageRequest.filters.burCode}" dictName="ssfj"/>
		                  </td>
                          <td class="crosscolor_td">
			                      <%=TtjGuest.ALIAS_STA_CODE%>
		                  </td>
			              <td class="crosscolor_td2">
		                           	<select name="s_staCode"   >
			              			</select>
		                  </td>
                   </tr>		           
		           <tr class="crosscolor_tr">
		               <td class="crosscolor_td">
		               	旅客类型
		               </td>
                       <td>					  
						 <select name="s_TableName" size="1" >
						   <option value="">境内旅客</option>
						   <option value="T_JW_ALL_TEMP">境外旅客</option>
						   <option value="V_ALL_TEMP">所有旅客</option>
						 </select>					 
					   </td>
                          <td class="crosscolor_td">
			                      <%=TtjGuest.ALIAS_STAR%>
		                  </td>
			              <td class="crosscolor_td2">
			              		<mytag:select  name="s_star"  value="${pageRequest.filters.star}" dictName="DIC_ITEM_HOTEL_STAR"/>
		                  </td>		                  
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=TtjGuest.ALIAS_ROOM_NUM%>
		                  </td>
		                  <td>
			              <table class="list" >
			               <tr>
			               <td>
		                           <input size="15" value="${pageRequest.filters.roomNum_Begin}"  name="s_roomNum_Begin" class="validate-digits" />
		                   </td>
			               <td>到</td>
			               <td>
		                           <input size="15" value="${pageRequest.filters.roomNum_End}"  name="s_roomNum_End" class="validate-digits great-than-equal-s_roomNum_Begin"  />
			               </td>
			              </tr>
			              </table>
		                  </td>		           
                          <td class="crosscolor_td">
			                      <%=TtjGuest.ALIAS_BED_NUM%>
		                  </td>
		                  <td>
			              <table class="list" >
			               <tr>
			               <td>
		                           <input size="15" value="${pageRequest.filters.bedNum_Begin}"  name="s_bedNum_Begin" class="validate-digits" />
		                   </td>
			               <td>到</td>
			               <td>
		                           <input size="15" value="${pageRequest.filters.bedNum_End}"  name="s_bedNum_End" class="validate-digits great-than-equal-s_bedNum_Begin" />
			               </td>
			              </tr>
			              </table>
		                  </td>

                   </tr>
                   <tr class="crosscolor_tr">
	           
                          <td class="crosscolor_td">
			                      <%=TtjGuest.ALIAS_IN_TIME%>
		                  </td>
			              <td>
			              <table class="list">
			               <tr>
			              <td>
				                   <s:select name="dateSelect1" list="dateSelectMap"  onchange="dateselect(this,'s_inTime_Begin','s_inTime_End','yyyy-MM-dd');"  value="#request.dateSelect1" listKey="key"   listValue="value" theme="simple" label=""  emptyOption="false" ></s:select>
			               </td>
			               <td>从</td>
			               <td>
			                          <input id="d31310" name="s_inTime_Begin"  value="${pageRequest.filters.inTime_Begin}"   maxlength="0" size="15" class="Wdate" type="text" onFocus="WdatePicker({startDate:'%y-%M-%d',dateFmt:'yyyy-MM-dd',maxDate:'#F{$dp.$D(\'d31410\')}'})"/>
			               <td>到</td>
			               <td>
			                        <input id="d31410" name="s_inTime_End"   value="${pageRequest.filters.inTime_End}"  maxlength="0" size="15" class="Wdate" type="text" onFocus="WdatePicker({startDate:'%y-%M-%d',dateFmt:'yyyy-MM-dd',minDate:'#F{$dp.$D(\'d31310\')}'})"/>
			               </td>
			              </tr>
			              </table>
		                  </td>	
		                  <td class="crosscolor_td">
		                  		统计类型
		                  </td>	
		                  <td>
		                  		   <input type="radio" name="s_type" id="radio0" value="0" checked="checked"/>
		                            按辖区
		                           <input type="radio" name="s_type" id="radio1" value="1" />
		                            按旅馆
		                  </td>	
                   </tr>
		           <tr>
			              <td class="tb_bottom" colspan="4">
			                       <input type="submit" id="submitButton" value="统计" onclick="getReferenceForm(this).action='${ctx}/pages/hotel/TtjGuest/list.do'"/>
			              		   <input style="margin-left: 20px" type="button" value="重置" onclick="rt();resitData(document.forms.form1)"/>
			              </td>
		           </tr>
	    </table>
    </s:form>
</div>

<script>
	
	new Validation(document.forms[0],{onSubmit:true,onFormValidate : function(result,form) {
		var finalResult = result;
		
		
		return disableSubmit(finalResult,'submitButton');
	}});
</script>
<%
	String s_type = request.getParameter("s_type");
	if(null != s_type && s_type.equals("1")){//按旅馆统计
		%>
<ec:table items='page.result' var="item" method="get"
	retrieveRowsCallback="limit" sortRowsCallback="limit" filterRowsCallback="limit"
	action="${ctx}/pages/hotel/TtjGuest/list.do" autoIncludeParameters="true">
	<ec:exportXls fileName="chpre.xls" tooltip="输出Excel文件"/>
	<ec:row>
							<ec:column property="called" title="<%=TtjGuest.ALIAS_CALLED%>">
								<a href="${ctx}/pages/hotel/TtjGuest/show.do?code=${item.code}" >${item.called}</a>
							</ec:column>		                    
		                    <ec:column property="address"  title="<%=TtjGuest.ALIAS_ADDRESS%>"/>
		                    <ec:column property="tel"  title="<%=TtjGuest.ALIAS_TEL%>"/>
		                    <ec:column property="roomNum"  title="<%=TtjGuest.ALIAS_ROOM_NUM%>"/>
		                    <ec:column property="bedNum"  title="<%=TtjGuest.ALIAS_BED_NUM%>"/>
		                    <ec:column property="inGuestNum"  title="<%=TtjGuest.ALIAS_INGUEST%>"/>
		                    <ec:column property="outGuestNum"  title="<%=TtjGuest.ALIAS_OUTGUEST%>"/>
	</ec:row>
</ec:table>		
		<%
	}else{//按辖区统计
		%>
<ec:table items='page.result' var="item" method="get"
	retrieveRowsCallback="limit" sortRowsCallback="limit" filterRowsCallback="limit"
	action="${ctx}/pages/hotel/TtjGuest/list.do" autoIncludeParameters="true" showPagination="false">
	<ec:exportXls fileName="chpre.xls" tooltip="输出Excel文件"/>
	<ec:row>
			<mytag:lookupcolumn property="bur_sta_code"  title="<%=TtjGuest.ALIAS_DEPT%>"	cell="net.java.dev.ec.table.view.LookUpCell" dictType="teHangDwbm" />
            <ec:column property="hotelSum"  title="<%=TtjGuest.ALIAS_HOTEL_NUM%>" cell="number" format="###,###,##0"  calc="total" calcTitle= "合计"/>
            <ec:column property="roomNum"  title="<%=TtjGuest.ALIAS_ROOM_NUM%>" cell="number" format="###,###,##0"  calc="total" calcTitle= "合计"/>
            <ec:column property="bedNum"  title="<%=TtjGuest.ALIAS_BED_NUM%>" cell="number" format="###,###,##0"  calc="total" calcTitle= "合计"/>
            <ec:column property="inGuestNum"  title="<%=TtjGuest.ALIAS_INGUEST%>" cell="number" format="###,###,##0"  calc="total" calcTitle= "合计"/>
            <ec:column property="outGuestNum"  title="<%=TtjGuest.ALIAS_OUTGUEST%>" cell="number" format="###,###,##0"  calc="total" calcTitle= "合计"/>
            <ec:column property="infoSum"  title="<%=TtjGuest.ALIAS_INFOSUM%>" cell="number" format="###,###,##0"  calc="total" calcTitle= "合计"/>
	</ec:row>
</ec:table>		
		
		<%
	}
%>



</body>

</html>


