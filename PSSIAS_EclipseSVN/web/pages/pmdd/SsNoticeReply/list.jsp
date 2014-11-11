<%@page import="com.dyneinfo.pmdd.model.*" %>
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
	<title><%=SsNoticeReply.TABLE_ALIAS%> 维护</title>
</head>

<body onload="quickSelectInit()" >
<%@ include file="/commons/messages.jsp" %>

<div class="queryPanel">
    <s:form action="/pages/pmdd/SsNoticeReply/list.do"  theme="simple" style="display: inline;" method="post">
	    <table cellpadding="0" cellspacing="0" border="0" class="tb_all">
	               <tr>
			              <td class="tb_title" colspan="4"><%=SsNoticeReply.TABLE_ALIAS%>查询</td>
		           </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=SsNoticeReply.ALIAS_DEPTNAME%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.deptname}"  name="s_deptname"  />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=SsNoticeReply.ALIAS_REPLYDATE%>
		                  </td>
                          <td>
		               		<table class="list">
			              		<tr>
			              			<td>
			              				<s:select name="dateSelect3" list="dateSelectMap"  onchange="dateselect(this,'d3133','d3143','yyyy-MM-dd');"  value="#request.dateSelect3" listKey="key"   listValue="value" theme="simple" label=""  emptyOption="false" ></s:select>
			              			</td>
			              			<td>从</td>
			              			<td>
			              				<input id="d3133" name="s_replydateBegin"  value="${pageRequest.filters.replydateBegin}"   maxlength="0" size="12" class="Wdate" type="text" onFocus="WdatePicker({dateFmt:'yyyy-MM-dd',maxDate:'#F{$dp.$D(\'d3143\')}'})"/>
			              			</td>
			              			<td>到</td>
			              			<td>
			              				<input id="d3143" name="s_replydateEnd"   value="${pageRequest.filters.replydateEnd}"  maxlength="0" size="12" class="Wdate" type="text" onFocus="WdatePicker({dateFmt:'yyyy-MM-dd',minDate:'#F{$dp.$D(\'d3133\')}'})"/>
			              			</td>
			              		</tr>
			              	</table>      
		                  </td>
                   </tr>
		           <tr>
			              <td class="tb_bottom" colspan="4">
			                       <input type="submit"  value="查询" onclick="getReferenceForm(this).action='${ctx}/pages/pmdd/SsNoticeReply/list.do'"/>
			                       <input type="button" value="返回" onclick="window.location='${ctx}/pages/pmdd/SsNotice/htadlist.do?<mytag:params includes="ec*,s*" type="queryStringUtf"/>'"/>
			              </td>
		           </tr>
	    </table>
    </s:form>
</div>



<ec:table items='page.result' var="item" method="get"
	retrieveRowsCallback="limit" sortRowsCallback="limit" filterRowsCallback="limit"
	action="${ctx}/pages/pmdd/SsNoticeReply/list.do" autoIncludeParameters="true">
	<ec:row>

		                    <ec:column property="noticetitle"  title="<%=SsNoticeReply.ALIAS_NOTICETITLE%>"/>
		                    <ec:column property="deptname"  title="<%=SsNoticeReply.ALIAS_DEPTNAME%>"/>
		                     <ec:column property="replydate"  parse="yyyyMMdd" format="yyyy-MM-dd" cell="date"  title="<%=SsNoticeReply.ALIAS_REPLYDATE%>"/>
	</ec:row>
</ec:table>

</body>

</html>


<script>
	
    function doBack(){
    	var url="";
    	url =  "${ctx}/pages/pmdd/Temployee/list.do?<mytag:params includes="ec*,s*" type="queryStringUtf"/>";
    	location.href = url;
    }
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
				input_txt.value = "!/pages/pmdd/SsNoticeReply/list.do?<mytag:params includes="ec*,s*" type="queryStringUtf"/>";
				form.appendChild(input_txt);
		        form.action = '${ctx}/pages/pmdd/SsNoticeReply/delete.do';
	            form.submit();
	        }
	  }
</script>