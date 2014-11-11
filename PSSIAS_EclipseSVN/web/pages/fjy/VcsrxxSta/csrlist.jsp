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
	<title>出售人统计</title>
</head>

<body onload="quickSelectInit()" >
<%@ include file="/commons/messages.jsp" %>

<div class="queryPanel">
    <s:form action="/pages/fjy/VcsrxxSta/list.do"  theme="simple" style="display: inline;" method="post">
	    <table cellpadding="0" cellspacing="0" border="1" class="tb_all">
	               <tr>
			              <td class="tb_title" colspan="4">出售人统计出售人出售物品详细列表</td>
		           </tr>

	    </table>
    </s:form>
</div>



<ec:table items='page.result' var="item" method="get"
	retrieveRowsCallback="limit" sortRowsCallback="limit" filterRowsCallback="limit"
	action="${ctx}/pages/fjy/VcsrxxSta/list.do" autoIncludeParameters="true">
	<ec:row>

		                    <ec:column property="csrxm"  title="<%=VcsrxxSta.ALIAS_CSRXM%>"/>
		                    <ec:column property="npaddress"  title="<%=VcsrxxSta.ALIAS_NPADDRESS%>"/>
		                    <ec:column property="wpzl"  title="<%=VcsrxxSta.ALIAS_WPZL%>"/>
		                    <ec:column property="deptname"  title="<%=VcsrxxSta.ALIAS_DEPTNAME%>"/>
		                    <ec:column property="shougourq"  title="<%=VcsrxxSta.ALIAS_SHOUGOURQ%>"/>
		<ec:column property="操作" title="操作" sortable="false" viewsAllowed="html">
			<a href="${ctx}/pages/fjy/Tfeijiuwupin/queryshow.do?wupinxh=${item.wupinxh}&fh=tj&<mytag:params includes="ec*,s*" type="queryStringUtf"/>">查看</a>&nbsp;&nbsp;&nbsp;
		</ec:column>
	</ec:row>
</ec:table>
<div class="queryPanel">
   
	    <table cellpadding="0" cellspacing="0" border="1" class="tb_all">
	               <tr>
			            <td colspan="5" class="tb_bottom">
	                        <input type="button" value="返回" onclick="history.go(-1);" />
			   			 </td>
		           </tr>
	    </table>

</div>
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
				input_txt.value = "!/pages/fjy/VcsrxxSta/list.do?<mytag:params includes="ec*,s*" type="queryStringUtf"/>";
				form.appendChild(input_txt);
		        form.action = '${ctx}/pages/fjy/VcsrxxSta/delete.do';
	            form.submit();
	        }
	  }
</script>