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
			                      <%=SsNotice.ALIAS_STATE%>
		                  </td>
			              <td>
				                   <mytag:select  name="s_state" value="${pageRequest.filters.state}"  notEmpty="false"  dictName="NOTICE_STATE"/>
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
			                       <input type="submit"  value="查询" onclick="getReferenceForm(this).action='${ctx}/pages/fjy/SsNotice/list.do'"/>
	                               <input type="button" value="重置" onclick="resitData(document.forms[0])"/>
	                               <input type="submit"  value="新增" onclick="getReferenceForm(this).action='${ctx}/pages/fjy/SsNotice/create.do?<mytag:params includes="ec*,s*" type="queryStringUtf"/>'"/>
			              </td>
		           </tr>
	    </table>
    </s:form>
</div>



<ec:table items='page.result' var="item" method="get"
	retrieveRowsCallback="limit" sortRowsCallback="limit" filterRowsCallback="limit"
	action="${ctx}/pages/fjy/SsNotice/list.do" autoIncludeParameters="true">
	<ec:row>

		                    <ec:column property="noticetitle"  title="<%=SsNotice.ALIAS_NOTICETITLE%>"/>
		                    <ec:column property="starttime" value="${item.starttimeString}" title="<%=SsNotice.ALIAS_STARTTIME%>"/>
		                    <ec:column property="endtime" value="${item.endtimeString}" title="<%=SsNotice.ALIAS_ENDTIME%>"/>
				            <mytag:lookupcolumn property="state"  title="<%=SsNotice.ALIAS_STATE%>"	cell="net.java.dev.ec.table.view.LookUpCell" dictType="NOTICE_STATE" />
		                    <ec:column property="authorname"  title="<%=SsNotice.ALIAS_AUTHORID%>"/>
		                    <ec:column property="sendunitname"  title="<%=SsNotice.ALIAS_SENDUNITID%>"/>
		<ec:column property="操作" title="操作" sortable="false" viewsAllowed="html">
			<a href="${ctx}/pages/fjy/SsNotice/show.do?noticeid=${item.noticeid}&<mytag:params includes="ec*,s*" type="queryStringUtf"/>">查看</a>&nbsp;&nbsp;&nbsp;
			
			<c:if test="${item.state != '1'}">
			<a href="${ctx}/pages/fjy/SsNotice/edit.do?noticeid=${item.noticeid}&<mytag:params includes="ec*,s*" type="queryStringUtf"/>">修改</a>&nbsp;&nbsp;&nbsp;
			<a href="${ctx}/pages/fjy/SsNotice/delete.do?noticeid=${item.noticeid}&returnUrl=!/pages/fjy/SsNotice/list.do?<mytag:params includes="ec*,s*" type="queryStringUtf"/>">删除</a>&nbsp;&nbsp;&nbsp;
		    </c:if> 
		    <c:if test="${item.isreply == '1' && item.state=='1'}">
		   	 <a href="${ctx}/pages/fjy/SsNotice/tzReplylist.do?noticeid=${item.noticeid}&<mytag:params includes="ec*,s*" type="queryStringUtf"/>">回执统计</a>
		    </c:if>
		</ec:column>
	</ec:row>
</ec:table>

</body>

</html>


<script>
	  function doDel() {
		    var form = document.forms.ec;
			if(!form) return;
			if (!hasOneChecked('items')){
               alert('请选择要操作的对象!');
               return;
             }
	        if (confirm('确定执行[删除]操作?')){
				var input_txt = document.createElement("input");
				input_txt.type = "hidden";
				input_txt.name = "returnUrl";
				input_txt.value = "!/pages/fjy/SsNotice/list.do?<mytag:params includes="ec*,s*" type="queryStringUtf"/>";
				form.appendChild(input_txt);
		        form.action = '${ctx}/pages/fjy/SsNotice/delete.do';
	            form.submit();
	        }
	  }
</script>