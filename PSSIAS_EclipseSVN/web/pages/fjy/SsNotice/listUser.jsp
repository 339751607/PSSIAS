<%@page import="com.dyneinfo.fjy.model.*" %>
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
	<title><%=SsNotice.TABLE_ALIAS%> 维护</title>
</head>

<body onload="quickSelectInit()" >
<%@ include file="/commons/messages.jsp" %>

<div class="queryPanel">
    <s:form action="/pages/fjy/SsNotice/list.do"  theme="simple" style="display: inline;" method="post">
	    <table cellpadding="0" cellspacing="0" border="1" class="tb_all">
	               <tr>
			              <td class="tb_title" colspan="4"><%=SsNotice.TABLE_ALIAS%>查询</td>
		           </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=SsNotice.ALIAS_NOTICETITLE%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.noticetitle}"  name="s_noticetitle"  />
		                  </td>
      						<td class="crosscolor_td">
			                      <%=SsNotice.ALIAS_SENDUNITID%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.sendunitid}"  name="s_sendunitid"  />
		                  </td>
                         
                   </tr>

		           <tr class="tr_tb">
                          <td class="td_tb">
			                      <%=SsNotice.ALIAS_STARTTIME%>
		                  </td>
			              <td colspan="3" class="td_input">
		                           <s:select name="dateSelect2" list="dateSelectMap"  onchange="dateselect('list_dateSelect2','d3132','d3142','yyyy-MM-dd');"  value="#request.dateSelect2" listKey="key"   listValue="value" theme="simple" label=""  emptyOption="false" ></s:select>
			                          从<input id="d3132" name="s_starttimeBegin"  value="${pageRequest.filters.starttimeBegin}"   maxlength="0" size="12" class="Wdate" type="text" onFocus="WdatePicker({dateFmt:'yyyy-MM-dd',maxDate:'#F{$dp.$D(\'d3142\')}'})"/> &nbsp;到&nbsp;
			                        <input id="d3142" name="s_starttimeEnd"   value="${pageRequest.filters.starttimeEnd}"  maxlength="0" size="12" class="Wdate" type="text" onFocus="WdatePicker({dateFmt:'yyyy-MM-dd',minDate:'#F{$dp.$D(\'d3132\')}'})"/>
		                  </td>
		                                     </tr>
		           <tr class="tr_tb">
		                                            <td class="td_tb">
			                      <%=SsNotice.ALIAS_ENDTIME%>
		                  </td>
			               <td colspan="3" class="td_input">
		                           <s:select name="dateSelect3" list="dateSelectMap"  onchange="dateselect('list_dateSelect3','d3133','d3143','yyyy-MM-dd');"  value="#request.dateSelect3" listKey="key"   listValue="value" theme="simple" label=""  emptyOption="false" ></s:select>
			                          从<input id="d3133" name="s_endtimeBegin"  value="${pageRequest.filters.endtimeBegin}"   maxlength="0" size="12" class="Wdate" type="text" onFocus="WdatePicker({dateFmt:'yyyy-MM-dd',maxDate:'#F{$dp.$D(\'d3143\')}'})"/> &nbsp;到&nbsp;
			                        <input id="d3143" name="s_endtimeEnd"   value="${pageRequest.filters.endtimeEnd}"  maxlength="0" size="12" class="Wdate" type="text" onFocus="WdatePicker({dateFmt:'yyyy-MM-dd',minDate:'#F{$dp.$D(\'d3133\')}'})"/>
		                  </td>
		           </tr>

		          
		          
		           <tr>
			              <td class="tb_bottom" colspan="4">
			                       <input type="submit"  value="查询" onclick="getReferenceForm(this).action='${ctx}/pages/fjy/SsNotice/listUser.do'"/>
	                               
			              </td>
		           </tr>
	    </table>
    </s:form>
</div>



<ec:table items='page.result' var="item" method="get" 
	retrieveRowsCallback="limit" sortRowsCallback="limit" filterRowsCallback="limit"
	action="${ctx}/pages/fjy/SsNotice/listUser.do" autoIncludeParameters="true">
	<ec:row>
	 
							 
		                    <ec:column property="noticetitle"  title="<%=SsNotice.ALIAS_NOTICETITLE%>"><c:if test="${item.readflag == null}"><B></c:if>${item.noticetitle}</ec:column>
		                    <ec:column property="starttime"  title="<%=SsNotice.ALIAS_STARTTIME%>"><c:if test="${item.readflag == null}"><B></c:if>${item.starttimeString}</ec:column>
		                    <ec:column property="endtime"  title="<%=SsNotice.ALIAS_ENDTIME%>"><c:if test="${item.readflag == null}"><B></c:if>${item.endtimeString}</ec:column>
		                    
				           	 <ec:column property="readflag"  title="状态">
				           	 <c:if test="${item.readflag == null && item.isreply != '1'}">
				           	 	未读
				           	 </c:if>
				           	 <c:if test="${item.readflag != null && item.isreply != '1'}">
				           	 	已读
				           	 </c:if>
				           	 <c:if test="${item.readflag != null && item.isreply == '1'}">
				           	 	已回执
				           	 </c:if>
				           	 <c:if test="${item.readflag == null&&item.isreply == '1'}">
				           	 	未回执
				           	 </c:if>
				           	 </ec:column>
		                    <ec:column property="authorname"  title="<%=SsNotice.ALIAS_AUTHORID%>"><c:if test="${item.readflag == null}"><B></c:if>${item.authorname}</ec:column>
		                    <ec:column property="sendunitname"  title="<%=SsNotice.ALIAS_SENDUNITID%>"><c:if test="${item.readflag == null}"><B></c:if>${item.sendunitname}</ec:column>

		<ec:column property="操作" title="操作" sortable="false" viewsAllowed="html">
			<a href="${ctx}/pages/fjy/SsNotice/showUser.do?noticeid=${item.noticeid}&isreply=${item.isreply}" >
			<c:if test="${item.readflag == null}"><B></c:if> 
			<c:if test="${item.isreply == '1'}"><font color="red"></c:if> 
			查看
			<c:if test="${item.readflag == null&&item.isreply == '1'}"></font></c:if> 
			</a>&nbsp;&nbsp;&nbsp;
	   
		</ec:column>
	</ec:row>
</ec:table>

</body>

</html>

