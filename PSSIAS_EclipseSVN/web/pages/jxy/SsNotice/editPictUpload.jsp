<%@page import="com.dyneinfo.jxy.model.*" %>
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
<form name="editForm"   action="${ctx}/pages/jxy/SsNotice/editPict.do" enctype="multipart/form-data" method="post">
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
	document.editForm.action="${ctx}/pages/jxy/SsNotice/editPict.do?FILEID="+FILEID;
	
	var frm = document.editForm;
	if(checkFileUpload(frm,'GIF,JPG,JPEG,PNG,BMP',false))		 
		    document.editForm.submit() ;
	
}

	   //检查上传物件 checkFileUpload(表单名称,档案类型,是否需要上传,档案大小,图片最小宽度,图片最小高度,图片最大宽度,图片最大高度,储存宽度的表单名称,储存高度的表单名称)
function checkFileUpload(form,extensions,requireUpload) {
  document.MM_returnValue = true;
  if (extensions != '') var re = new RegExp("\.(" + extensions.replace(/,/gi,"|") + ")$","i");
  for (var i = 0; i<form.elements.length; i++) {
    field = form.elements[i];
    if (field.type.toUpperCase() != 'FILE' || field.name.toUpperCase() != 'UPLOAD') continue;
    if (field.value == '') {
      if (requireUpload) {alert('请选取上传的文件！');document.MM_returnValue = false;field.focus();break;}
    } else {
      if(extensions != '' && !re.test(field.value)) {
         alert('这个文件不符合上传的类型！\n只有以下的类型才允许上传： ' + extensions + '。\n请依规定选取新的上传文件。');
        document.MM_returnValue = false;
        field.focus();
        break;
      }
   } 
 }
  return document.MM_returnValue;
    
}


</script>

</body>
</html>
