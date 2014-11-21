<%@page import="com.dyneinfo.jxy.model.*" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/commons/taglibs.jsp" %>
<%
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+request.getContextPath()+"/";
String id = request.getParameter("id");
String type = request.getParameter("type");
%>
<html>

<head>
	<%@ include file="/commons/meta.jsp" %>
	<title>照片上传</title>
</head>
<base target="_self">
<body  >
	
<table cellspacing="0" cellpadding="0" border="0" width="100%" class="pg_add">
	<form id="editForm" name="editForm"  action="${ctx}/pages/jxy/Shxx/picEdit.do" enctype="multipart/form-data" action="" method="post">
	<input type="hidden" name="dnumber" value="<%=id%>" />
	<input type="hidden" name="flag" value="<%=type%>" />
			<tr class="crosscolor_tr">
				<td width="100%">&nbsp;&nbsp;上传照片:&nbsp;
				<input id="NewFile" name="upload" style="WIDTH: 75%" type="file" ></td>

			</tr>
			
			<tr>
				<td class="pg_add_bottom">
				  <div style="text-align:center;">
				    <input type="button"  title="" value="修改图片" onclick="SendFile();">
				  </div>  
				</td>
			</tr>
	</form>
</table>	





<script language="javascript">

   //检查上传物件 checkFileUpload(表单名称,档案类型,是否需要上传,档案大小,图片最小宽度,图片最小高度,图片最大宽度,图片最大高度,储存宽度的表单名称,储存高度的表单名称)
function checkFileUpload(form,extensions,requireUpload,sizeLimit,minWidth,minHeight,maxWidth,maxHeight,saveWidth,saveHeight) {
  document.MM_returnValue = true;
  if (extensions != '') var re = new RegExp("\.(" + extensions.replace(/,/gi,"|") + ")$","i");
  for (var i = 0; i<form.elements.length; i++) {
    field = form.elements[i];
    if (field.type.toUpperCase() != 'FILE') continue;
    if (field.value == '') {
      if (requireUpload) {alert('请选取上传的文件！');document.MM_returnValue = false;field.focus();break;}
    } else {
      if(extensions != '' && !re.test(field.value)) {
        alert('这个文件不符合上传的类型！\n只有以下的类型才允许上传： ' + extensions + '。\n请依规定选取新的上传文件。');
        document.MM_returnValue = false;field.focus();break;
      }
    document.PU_uploadForm = form;
    re = new RegExp(".(gif|jpg|png|bmp|jpeg)$","i");
    if(re.test(field.value) && (sizeLimit != '' || minWidth != '' || minHeight != '' || maxWidth != '' || maxHeight != '' || saveWidth != '' || saveHeight != '')) {
      setTimeout('if (document.MM_returnValue) document.PU_uploadForm.submit()',500);
      checkImageDimensions(field.value,sizeLimit,minWidth,minHeight,maxWidth,maxHeight,saveWidth,saveHeight);
    } } }
    
  if(document.MM_returnValue )
     form.submit(); 
}

function SendFile()
{
    var   newFileValue = document.getElementById("NewFile");
   var   dnumber = document.getElementById("dnumber").value; 
   var   flag = document.getElementById("flag").value; 
      
	if(newFileValue.value == ""){
	   alert('请选取上传的文件！');
	   return false;
	}
	
	document.editForm.action="${ctx}/pages/jxy/Shxx/picEdit.do?dnumber="+dnumber+"&flag="+flag;
	var frm = document.editForm;
    checkFileUpload(frm,'GIF,JPG,JPEG,PNG,BMP',true,'','','','','','','');
	//document.editForm.submit() ;
}


</script>
</body>
</html>
