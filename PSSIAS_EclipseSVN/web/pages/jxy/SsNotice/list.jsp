<%@page import="com.dyneinfo.jxy.model.*" %>
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
    <s:form action="/jxy/SsNotice/htadlist.do"  theme="simple" style="display: inline;" method="post">
	    <table cellpadding="0" cellspacing="0" border="0" class="tb_all">
	               <tr>
			              <td class="tb_title" colspan="4"><%=SsNotice.TABLE_ALIAS%>查询</td>
		           </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=SsNotice.ALIAS_NOTICETITLE%>
		                  </td>
			              <td class="crosscolor_td2">
		                           <input value="${pageRequest.filters.noticetitle}"  name="s_noticetitle"  />
		                  </td>
		                   <td class="crosscolor_td">
			                      <%=SsNotice.ALIAS_STATE%>
		                  </td>
			              <td class="crosscolor_td2">
				                   <mytag:select  name="s_state" value="${pageRequest.filters.state}"  notEmpty="false"  dictName="NOTICE_STATE"/>
		                  </td>
                         
                   </tr>
                    <tr class="crosscolor_tr">
                         
                          <td class="crosscolor_td">
			                      <%=SsNotice.ALIAS_AUTHORID%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.authorid}"  name="s_authorid"  />
		                  </td>
                  
                          <td class="crosscolor_td">
			                      <%=SsNotice.ALIAS_SENDUNITID%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.sendunitid}"  name="s_sendunitid"  />
		                  </td>
                        
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td" >
			                      <%=SsNotice.ALIAS_STARTTIME%>
		                  </td>
			              <td colspan="1" align="left"> 
			                 <table class="list">
			                   <tr>
			                       <td>
		                               <s:select name="dateSelect2" list="dateSelectMap"  onchange="dateselect(this,'s_starttimeBegin','s_starttimeEnd','yyyy-MM-dd');"  value="#request.dateSelect2" listKey="key"   listValue="value" theme="simple" label=""  emptyOption="false" ></s:select>
		                           </td>
			                       <td>从</td>
			                       <td>
			                          <input id="d3132" name="s_starttimeBegin"  value="${pageRequest.filters.starttimeBegin}"   maxlength="0" size="15" class="Wdate" type="text" onFocus="WdatePicker({dateFmt:'yyyy-MM-dd',maxDate:'#F{$dp.$D(\'d3142\')}'})"/> 
			                       </td>
			                       <td>到</td>
			                       <td>
			                          <input id="d3142" name="s_starttimeEnd"   value="${pageRequest.filters.starttimeEnd}"  maxlength="0" size="15" class="Wdate" type="text" onFocus="WdatePicker({dateFmt:'yyyy-MM-dd',minDate:'#F{$dp.$D(\'d3132\')}'})"/>
		                           </td>
		                        </tr>
		                     </table>
		                  </td>
		                  <td class="crosscolor_td">
			                      <%=SsNotice.ALIAS_ISREPLY%>
		                  </td>
			              <td  colspan="3">
		                           <mytag:select name="s_isreply" value="${pageRequest.filters.isreply}"  notEmpty="false"  dictName="shiFou" />
		                  </td>
		           </tr>
		           <tr class="crosscolor_tr">   
		           <td class="crosscolor_td">
			                      <%=SsNotice.ALIAS_ENDTIME%>
		                  </td>
			               <td colspan="1" align="left"> 
			                 <table class="list">
			                   <tr>
			                       <td>
		                             <s:select name="dateSelect3" list="dateSelectMap"  onchange="dateselect(this,'s_endtimeBegin','s_endtimeEnd','yyyy-MM-dd');"  value="#request.dateSelect3" listKey="key"   listValue="value" theme="simple" label=""  emptyOption="false" ></s:select>
			                       </td>     
			                       <td>从</td>
			                       <td>  
			                         <input id="d3133" name="s_endtimeBegin"  value="${pageRequest.filters.endtimeBegin}"   maxlength="0" size="15" class="Wdate" type="text" onFocus="WdatePicker({dateFmt:'yyyy-MM-dd',maxDate:'#F{$dp.$D(\'d3143\')}'})"/> 
			                       </td>
			                       <td>到</td>
			                       <td>  
			                         <input id="d3143" name="s_endtimeEnd"   value="${pageRequest.filters.endtimeEnd}"  maxlength="0" size="15" class="Wdate" type="text" onFocus="WdatePicker({dateFmt:'yyyy-MM-dd',minDate:'#F{$dp.$D(\'d3133\')}'})"/>
		                           </td>
		                        </tr>
		                     </table>
		                  </td>     
	           			<td></td><td></td>
                   </tr>
	
		          
		           <tr>
			              <td class="tb_bottom" colspan="4">
			                       <input type="submit"  value="查询" onclick="getReferenceForm(this).action='${ctx}/jxy/SsNotice/htadlist.do'"/>
	                               <input type="submit"  value="新增" onclick="getReferenceForm(this).action='${ctx}/jxy/SsNotice/create.do?<mytag:params includes="ec*,s*" type="queryStringUtf"/>'"/>
	                               <input type="button"  value="删除" onclick="doDel();"/>
			              </td>
		           </tr>
	    </table>
    </s:form>
</div>



<ec:table items='page.result' var="item" method="get"
	retrieveRowsCallback="limit" sortRowsCallback="limit" filterRowsCallback="limit"
	action="${ctx}/jxy/SsNotice/htadlist.do" autoIncludeParameters="true">
	<ec:row>
		<ec:column property="选择" title="<input type='checkbox' onclick=\"setAllCheckboxState('items',this.checked)\" >" sortable="false" width="3%" viewsAllowed="html">
			<input type="checkbox" name="items" value="noticeid=${item.noticeid}&"/>
		</ec:column>
		                    <ec:column width="200px" property="noticetitle"  title="<%=SsNotice.ALIAS_NOTICETITLE%>"/>
		                    <ec:column property="starttime" value="${item.starttimeString}" title="<%=SsNotice.ALIAS_STARTTIME%>"/>
		                    <ec:column property="endtime" value="${item.endtimeString}" title="<%=SsNotice.ALIAS_ENDTIME%>"/>
				            <mytag:lookupcolumn property="state"  title="<%=SsNotice.ALIAS_STATE%>"	cell="net.java.dev.ec.table.view.LookUpCell" dictType="NOTICE_STATE" />
		                    <ec:column property="authorname"  title="<%=SsNotice.ALIAS_AUTHORID%>"/>
		                    <ec:column property="sendunitname"  title="<%=SsNotice.ALIAS_SENDUNITID%>"/>
		                   <mytag:lookupcolumn property="isreply"  title="<%=SsNotice.ALIAS_ISREPLY%>"	cell="net.java.dev.ec.table.view.LookUpCell" dictType="shiFou" />
		<ec:column width="60px" property="操作" title="操作" sortable="false" viewsAllowed="html">
			<a href="${ctx}/jxy/SsNotice/show.do?noticeid=${item.noticeid}&<mytag:params includes="ec*,s*" type="queryStringUtf"/>">查看</a>
			<c:if test="${item.state != '1'}">
			<a href="${ctx}/jxy/SsNotice/edit.do?noticeid=${item.noticeid}&<mytag:params includes="ec*,s*" type="queryStringUtf"/>">修改</a>
		    </c:if> 
		    <c:if test="${item.isreply == '1'}">
				<a href="${ctx}/jxy/SsNoticeReply/list.do?h_noticeid=${item.noticeid}&<mytag:params includes="ec*,s*" type="queryStringUtf"/>">回执</a>
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
				input_txt.value = "!/jxy/SsNotice/htadlist.do?<mytag:params includes="ec*,s*" type="queryStringUtf"/>";
				form.appendChild(input_txt);
		        form.action = '${ctx}/jxy/SsNotice/delete.do';
	            form.submit();
	        }
	  }
</script>
