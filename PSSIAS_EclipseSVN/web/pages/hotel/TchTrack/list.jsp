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
	<title><%=TchPre.TABLE_ALIAS%> 维护</title>
</head>

<body >
<%@ include file="/commons/messages.jsp" %>

<div class="queryPanel">
    <s:form action="/pages/hotel/TchTrack/list.do" name="form1" theme="simple" style="display: inline;" method="post">
	    <table cellpadding="0" cellspacing="0" border="0" class="tb_all">
	               <tr>
			              <td class="tb_title" colspan="4">住宿轨迹查询</td>
		           </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=TchPre.ALIAS_NAME%>
		                  </td>
			              <td class="crosscolor_td2">
		                           <input size="25" value="${pageRequest.filters.name}" id="s_name" name="s_name"  />
		                  </td>		           
                          <td class="crosscolor_td">
			                      <%=TchPre.ALIAS_ID_CODE%>
		                  </td>
		                  <td class="crosscolor_td2">
						           <input size="25" value="${pageRequest.filters.idCode}"  name="s_idCode"  />
		                  </td>		           

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
			                       <input type="submit"  value="查询" onclick="getReferenceForm(this).action='${ctx}/pages/hotel/TchTrack/list.do'"/>
			                       <input style="margin-left: 20px" type="button" value="重置" onclick="resitData(document.forms.form1)"/>
			              </td>
		           </tr>
	    </table>
    </s:form>
</div>



<ec:table items='page.result' var="item" method="get"
	retrieveRowsCallback="limit" sortRowsCallback="limit" filterRowsCallback="limit"
	action="${ctx}/pages/hotel/TchTrack/list.do" autoIncludeParameters="true">
	<ec:exportXls fileName="chpre.xls" tooltip="输出Excel文件"/>
	<ec:row>
		                    <ec:column property="name"  title="<%=TchTrack.ALIAS_NAME%>"/>
		                    <ec:column property="guesttype"  title="<%=TchTrack.ALIAS_GUESTTYPE%>"/>
		                    <mytag:lookupcolumn property="idName"  title="<%=TchTrack.ALIAS_ID_NAME%>"	cell="net.java.dev.ec.table.view.LookUpCell" dictType="T_ID_NAME" />
		                    <ec:column property="idCode"  title="<%=TchTrack.ALIAS_ID_CODE%>"/>
		                    <ec:column property="cishu"  title="<%=TchTrack.ALIAS_CISHU%>"/>
		                    
		<ec:column property="操作" title="操作" sortable="false" viewsAllowed="html">
			<a href="${ctx}/pages/hotel/TchTrack/detailList.do?s_idName=${item.idName}&s_idCode=${item.idCode}&s_inTime_Begin=${pageRequest.filters.inTime_Begin}&s_inTime_End=${pageRequest.filters.inTime_End}">查看</a>&nbsp;&nbsp;&nbsp;
		</ec:column>
	</ec:row>
</ec:table>

</body>


</html>
