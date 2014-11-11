<%@page import="com.dyneinfo.hotel.model.*" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/commons/taglibs.jsp" %>
<%
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+request.getContextPath()+"/";
%>
<html>

<head>
	<%@ include file="/commons/meta.jsp" %>
	<base href="<%=basePath%>">
	<link href="${ctx}/widgets/extremecomponents/extremecomponents.css" type="text/css" rel=stylesheet>
	<title><%=TchTrack.TABLE_ALIAS%> 维护</title>
</head>

<body >
<%@ include file="/commons/messages.jsp" %>

<div class="queryPanel">
    <s:form action="/pages/hotel/TchTrack/detailList.do" name="form1" theme="simple" style="display: inline;" method="post">
	    <table cellpadding="0" cellspacing="0" border="0" class="tb_all">
	               <input type="hidden" name="s_idName" value="${pageRequest.filters.idName}">
	               <input type="hidden" name="s_idCode" value="${pageRequest.filters.idCode}">
	               <tr>
			              <td class="tb_title" colspan="4">住宿轨迹详情列表</td>
		           </tr>
                   <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=TchTrack.ALIAS_IN_TIME%>
		                  </td>
			              <td colspan="3">
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
		           <tr>
			              <td class="tb_bottom" colspan="4">
			                       <input type="submit"  value="查询" onclick="getReferenceForm(this).action='${ctx}/pages/hotel/TchTrack/detailList.do'"/>
			                       <input style="margin-left: 20px" type="button" value="清空" onclick="resitData(document.forms.form1)"/>
			                       <input style="margin-left: 20px" type="button" value="返回" onclick="history.back()"/>
			              </td>
		           </tr>
	    </table>
    </s:form>
</div>



<ec:table items='page.result' var="item" method="get"
	retrieveRowsCallback="limit" sortRowsCallback="limit" filterRowsCallback="limit"
	action="${ctx}/pages/hotel/TchTrack/detailList.do" autoIncludeParameters="true">
	<ec:exportXls fileName="chpre.xls" tooltip="输出Excel文件"/>
	<ec:row>
		                    <ec:column property="name"  title="<%=TchTrack.ALIAS_NAME%>"/>
		                    <mytag:lookupcolumn property="sex"  title="<%=TchTrack.ALIAS_SEX%>"	cell="net.java.dev.ec.table.view.LookUpCell" dictType="T_DIC_SEX" />    
		                    <ec:column property="bdate"  title="<%=TchTrack.ALIAS_BDATE%>" parse="yyyyMMdd" format="yyyy-MM-dd" cell="date"/>
		                    <mytag:lookupcolumn property="idName"  title="<%=TchTrack.ALIAS_ID_NAME%>"	cell="net.java.dev.ec.table.view.LookUpCell" dictType="T_ID_NAME" />
		                    <ec:column property="idCode"  title="<%=TchTrack.ALIAS_ID_CODE%>"/>
			                <ec:column property="inTime"  title="<%=TchTrack.ALIAS_IN_TIME%>" parse="yyyyMMddHHmm" format="yyyy-MM-dd HH:mm" cell="date"/>
							<ec:column property="hotelName" title="<%=TchTrack.ALIAS_HOTELNAME%>">
								<a href="${ctx}/pages/hotel/Thotel/show.do?code=${item.hotelid}" >${item.hotelName}</a>
							</ec:column>			                
		                    <ec:column property="noRoom"  title="<%=TchTrack.ALIAS_NO_ROOM%>"/>
		                    <mytag:lookupcolumn property="staCode"  title="<%=Thotel.ALIAS_STA_CODE%>"	cell="net.java.dev.ec.table.view.LookUpCell" dictType="teHangDwbm" />    
		<ec:column property="操作" title="操作" sortable="false" viewsAllowed="html">
			<a href="${ctx}/pages/hotel/TchPre/show.do?id=${item.id}&<mytag:params includes="ec*,s*" type="queryStringUtf"/>">查看</a>&nbsp;&nbsp;&nbsp;
		</ec:column>
	</ec:row>
</ec:table>

</body>


</html>
