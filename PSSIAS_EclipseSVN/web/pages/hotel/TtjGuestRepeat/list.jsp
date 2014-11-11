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
	<script type='text/javascript' src='${ctx}/dwr/interface/menu.js'></script>
	<script type='text/javascript' src='${ctx}/dwr/engine.js'></script>
	<script type='text/javascript' src='${ctx}/dwr/util.js'></script>

<script type="text/javascript">

	function loadSelect(){
		queryCity2();
		var type = "${pageRequest.filters.TableName}"
		if('T_CH_PRE'==type){
			document.getElementById("radio1").checked = true;
		}else{
			document.getElementById("radio0").checked = true;
		}
		
	}
	function rt(){
		document.getElementById("radio0").checked = true;
	}
</script>

</head>

<body onload="loadSelect()" >
<%@ include file="/commons/messages.jsp" %>

<div class="queryPanel">
    <s:form action="/pages/hotel/TtjGuestRepeat/list.do"  theme="simple" style="display: inline;" method="post" name="form1">
	    <table cellpadding="0" cellspacing="0" border="0" class="tb_all">
	               <tr>
			              <td class="tb_title" colspan="4"><%=TtjGuestRepeat.TABLE_ALIAS%></td>
		           </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=TtjGuestRepeat.ALIAS_BUR_CODE%>
		                  </td>
			              <td class="crosscolor_td2">
			              		<mytag:select  name="s_burCode" onchange="changeprov2();" value="${pageRequest.filters.burCode}" dictName="ssfj"/>
		                  </td>
                          <td class="crosscolor_td">
			                      <%=TtjGuestRepeat.ALIAS_STA_CODE%>
		                  </td>
			              <td class="crosscolor_td2">
		                           	<select name="s_staCode"   >
			              			</select>
		                  </td>
                   </tr>		           
                   <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                   入住次数
		                  </td>
			              <td class="crosscolor_td2">
		                           <input size="25" value="${pageRequest.filters.inCount}" name="s_inCount" class="validate-digits" />
		                  </td>		           			  
                          <td class="crosscolor_td">
			                      <%=TtjGuestRepeat.ALIAS_IN_TIME%>
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
		                  	统计类型
		                  </td>	
		                  <td>
		                  		   <input type="radio" name="s_TableName" id="radio0" value="V_CH_ALL" checked="checked"/>
		                            频繁入住
		                           <input type="radio" name="s_TableName" id="radio1" value="T_CH_PRE" />
		                            一证多住
		                  </td>	
		                  <td></td>	
		                  <td></td>			                  
                   </tr>
		           <tr>
			              <td class="tb_bottom" colspan="4">
			                       <input type="submit" id="submitButton" value="查询" onclick="getReferenceForm(this).action='${ctx}/pages/hotel/TtjGuestRepeat/list.do'"/>
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
<ec:table items='page.result' var="item" method="get"
	retrieveRowsCallback="limit" sortRowsCallback="limit" filterRowsCallback="limit"
	action="${ctx}/pages/hotel/TtjGuestRepeat/list.do" autoIncludeParameters="true">
	<ec:exportXls fileName="chpre.xls" tooltip="输出Excel文件"/>
	<ec:row>
		                    <ec:column property="name"  title="<%=TtjGuestRepeat.ALIAS_NAME%>"/>
		                    <mytag:lookupcolumn property="idName"  title="<%=TtjGuestRepeat.ALIAS_ID_NAME%>"	cell="net.java.dev.ec.table.view.LookUpCell" dictType="T_ID_NAME" />
		                    <ec:column property="idCode"  title="<%=TtjGuestRepeat.ALIAS_ID_CODE%>"/>
		                    <ec:column property="inCount"  title="<%=TtjGuestRepeat.ALIAS_INCOUNT%>"/>
		                    
		<ec:column property="操作" title="操作" sortable="false" viewsAllowed="html">
			<a href="${ctx}/pages/hotel/TchPre/list.do?s_idName=${item.idName}&s_idCode=${item.idCode}&listOnly=true&<mytag:params includes="ec*,s*" type="queryStringUtf"/>">查看</a>&nbsp;&nbsp;&nbsp;
		</ec:column>
	</ec:row>
</ec:table>



</body>

</html>


