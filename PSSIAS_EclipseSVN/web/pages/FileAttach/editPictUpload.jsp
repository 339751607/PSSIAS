<%@page import="com.dyneinfo.zazh.model.*" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/commons/taglibs.jsp" %>
<%
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+request.getContextPath()+"/";
String FILEID = request.getParameter("FILEID");
%>
<html>

<head>
	<%@ include file="/commons/meta.jsp" %>
	<base href="<%=basePath%>">
	<title>图片</title>
</head>

<body>
<form name="editForm"   action="${ctx}/pages/FileAttach/editPict.do" enctype="multipart/form-data" method="post">
<table cellspacing="0" cellpadding="0" border="0" width="100%" class="pg_add">
	<input type="hidden" name="FILEID" value="<%=FILEID%>" />
			<tr class="crosscolor_tr">
				<td width="100%">&nbsp;&nbsp;上传图片:&nbsp;
				<input id="NewFile" name="upload" style="WIDTH: 75%" type="file"></td>
			</tr>
			<tr>
				<td class="pg_add_bottom">
				  <div style="text-align:center;">
				    <input type="button"  title="" value="修改图片" onclick="SendFile();">
				  </div>  
				</td>
			</tr>
</table>	
</form>



<script language="javascript">

function SendFile()
{
   var   newFileValue = document.getElementById("NewFile");
   var   FILEID = document.getElementById("FILEID").value;   
	if(newFileValue.value == ""){
	   alert('请选取上传的图片！');
	   return false;
	}
	document.editForm.action="${ctx}/pages/FileAttach/editPict.do?FILEID="+FILEID;
	document.editForm.submit() ;
}


</script>

</body>
</html>