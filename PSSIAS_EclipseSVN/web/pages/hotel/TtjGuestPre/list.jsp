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
	<title><%=TtjGuestPre.TABLE_ALIAS%> 维护</title>
<script type="text/javascript">

	function loadSelect(){
		queryCity();
		queryCity2();
		if(1 == "${pageRequest.filters.nonnative}"){
			document.getElementById("s_nonnative").checked=true;
		}
		
	}
	function rt(){
			document.getElementById("s_nonnative").checked=false;
	}
</script>
</head>

<body onload="loadSelect()" >
<%@ include file="/commons/messages.jsp" %>

<div class="queryPanel">
    <s:form action="/pages/hotel/TtjGuestPre/list.do" name="form1" theme="simple"  method="post">
	    <table cellpadding="0" cellspacing="0" border="0" class="tb_all">
	               <tr>
			              <td class="tb_title" colspan="4"><%=TtjGuestPre.TABLE_ALIAS %></td>
		           </tr>
		            <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=TtjGuestPre.ALIAS_BUR_CODE%>
		                  </td>
			              <td class="crosscolor_td2">
			              		<mytag:select  name="s_burCode" onchange="changeprov2();" value="${pageRequest.filters.burCode}" dictName="ssfj"/>
		                  </td>
		                  <td class="crosscolor_td">
			                      <%=TtjGuestPre.ALIAS_STA_CODE%>
		                  </td>
			              <td class="crosscolor_td2">
			              			<select name="s_staCode"  >
			              			</select>
		                  </td>	
                   </tr>
		           <tr class="crosscolor_tr">
		                  <td class="crosscolor_td">
			                      <%=TtjGuestPre.ALIAS_XZQH%>
		                  </td>	           
		                  <td>
						           <mytag:select onchange="changeprov();" name="s_province" value="${pageRequest.filters.province}" notEmpty="false"  dictName="T_DICT_PROV"/>
							      <select style="margin-left: 10px" name="s_xzqh"></select>
		                  </td>
		                  <td  class="crosscolor_td">
		                  		查询非本地人员
		                  </td>	           
		                  <td>
		                  		<input type="checkbox" name="s_nonnative" value="1">
		                  </td>	           
		                  	
                          
                   </tr>
                   <tr class="crosscolor_tr">
                   		<td class="crosscolor_td">
                   			旅馆入住人数
                   		</td>
                   		<td>
                   			<input size="10" value="${pageRequest.filters.guestHotel}" name="s_guestHotel" class="validate-digits" />
                   			人以上
                   		</td>
                   		<td class="crosscolor_td">
                   			房间入住人数
                   		</td>
                   		<td>
                   			<input size="10" value="${pageRequest.filters.guestRoom}" name="s_guestRoom" class="validate-digits" />
                   			人以上
                   		</td>
                   </tr>
                    <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=TtjGuestPre.ALIAS_IN_TIME%>
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
			                       <input type="submit" id="submitButton" value="统计" onclick="getReferenceForm(this).action='${ctx}/pages/hotel/TtjGuestPre/list.do'"/>
			                       <input style="margin-left: 20px" type="button" value="重置" onclick="rt();resitData(document.forms.form1)"/>
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

<ec:table items='page.result' var="item" method="get"
	retrieveRowsCallback="limit" sortRowsCallback="limit" filterRowsCallback="limit"
	action="${ctx}/pages/hotel/TtjGuestPre/list.do" autoIncludeParameters="true">
	<ec:exportXls fileName="chpre.xls" tooltip="输出Excel文件"/>
	<ec:row>
		                    <ec:column property="hotelname" title="<%=TtjGuestPre.ALIAS_HOTELNAME%>">
								<a href="${ctx}/pages/hotel/Thotel/show.do?code=${item.hotelid}" >${item.hotelname}</a>
							</ec:column>		                    
		                    <ec:column property="address"  title="<%=TtjGuestPre.ALIAS_ADDRESS%>"/>
		                    <ec:column property="tel"  title="<%=TtjGuestPre.ALIAS_TEL%>"/>
		                    <ec:column property="roomNum"  title="<%=TtjGuestPre.ALIAS_ROOM_NUM%>"/>
		                    <ec:column property="bedNum"  title="<%=TtjGuestPre.ALIAS_BED_NUM%>"/>
		                    <ec:column property="guestHotel"  title="<%=TtjGuestPre.ALIAS_GUEST_NUM%>"/>
		                    <mytag:lookupcolumn property="burCode"  title="<%=TtjGuestPre.ALIAS_BUR_CODE%>"	cell="net.java.dev.ec.table.view.LookUpCell" dictType="ssfj" />
		                    <mytag:lookupcolumn property="staCode"  title="<%=TtjGuestPre.ALIAS_STA_CODE%>"	cell="net.java.dev.ec.table.view.LookUpCell" dictType="sspcs" />
		                    
		<ec:column property="操作" title="操作" sortable="false" viewsAllowed="html">
			<a href="${ctx}/pages/hotel/TchPre/list.do?s_hotelid=${item.hotelid}&listOnly=true&s_TableName=T_CH_PRE&<mytag:params includes="ec*,s*" type="queryStringUtf"/>">查看</a>&nbsp;&nbsp;&nbsp;
		</ec:column>
	</ec:row>
</ec:table>

</body>


</html>
