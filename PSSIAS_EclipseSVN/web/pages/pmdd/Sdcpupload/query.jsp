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
	<title><%=Sdcpupload.TABLE_ALIAS%> 维护</title>
</head>

<body onload="quickSelectInit()" >
<%@ include file="/commons/messages.jsp" %>

<div class="queryPanel">
    <s:form action="/pages/pmdd/Sdcpupload/list.do"  name="inputForm" theme="simple" style="display: inline;" method="post">
	    <table cellpadding="0" cellspacing="0" border="0" class="tb_all">
	               <tr>
			              <td class="tb_title" colspan="4">未上传数据企业</td>
		           </tr>
		           
		           
	    </table>
    </s:form>
</div>





<ec:table items='page.result' var="item" method="get"
	retrieveRowsCallback="limit" sortRowsCallback="limit" filterRowsCallback="limit"
	action="${ctx}/pages/pmdd/Sdcpupload/show.do" autoIncludeParameters="true">
	<ec:row>
		
		                    
		                    <ec:column property="deptname"  title="<%=Sdcpupload.ALIAS_WWSCJS%>"/>
		                
			
		
		                   
		
	</ec:row>
</ec:table>
<div class="queryPanel">
    <s:form action="/pages/pmdd/Sdcpupload/list.do"  name="inputForm" theme="simple" style="display: inline;" method="post">
	    <table cellpadding="0" cellspacing="0" border="0" class="tb_all">
	             
		           <tr>
			              <td class="tb_bottom" colspan="4">
			                       <input type="submit"  value="返回" onclick="getReferenceForm(this).action='${ctx}/pages/pmdd/Sdcpupload/list.do?s_starttimeBegin=${pageRequest.filters.starttimeBegin}&s_starttimeEnd=${pageRequest.filters.starttimeEnd}'"/>
	                              
			              </td>
		           </tr>
	    </table>
    </s:form>
</div>
</body>

</html>
<script>
 function selectDept(frm,displayName,hiddenName) {
	           window.showModalDialog('${ctx}/pages/SsDept/selectDept.do?idValueIsSeq=true&formName=' + frm.name + '&inputName='+displayName+'&hiddenName='+hiddenName+'&rootID=false&maxPatiNum=1&hiddenType=ID_SPLIT',frm,'dialogHeight:500px;dialogWidth:560px;center:yes');
       }
</script>