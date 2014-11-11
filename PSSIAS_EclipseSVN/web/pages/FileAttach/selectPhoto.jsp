<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/commons/taglibs.jsp" %>
<%
String formName="";
String inputName="";
String hiddenName="";

if(request.getAttribute("formName") != null)
   formName = (String)request.getAttribute("formName");
if(request.getAttribute("inputName") != null)
   inputName =(String) request.getAttribute("inputName");
if(request.getAttribute("hiddenName") != null)
   hiddenName =(String) request.getAttribute("hiddenName");
                       

 %>
<!DOCTYPE html
PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN"
"http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<title>摄像头照片捕获</title>
</head>


<script type="text/javascript">
		    
        var caller = window.dialogArguments;
		var retName="";
		var retValue="";
		var formName="<%=formName%>";
		var inputName="<%=inputName%>";
		var hiddenName="<%=hiddenName%>";
		


		

         /**
		  *	该方法中具体执行点击确定按钮后的，执行动作
		  */
		function add(){
			retValue = document.getElementById("photoId").value;
			retName = document.getElementById("photoId").value;
			if (inputName=="") 
				inputName="null";
			if (hiddenName=="") 
				 hiddenName="null";
			if(retValue == ""){
			     alert('没有捕获照片！');
			}	 
			if(hiddenName!='undefined'&&inputName!=undefined){
				 eval("caller.elements['"  +  inputName +   "'].disabled = true;" );
				 eval("caller.elements['"  +  hiddenName +  "'].value = '"+retValue+"';");
			 }
			 window.close();
		}

		

</script>
<body>
<table><tr><td valign=top>
	
	
	<!-- First, include the JPEGCam JavaScript Library -->
	<script type="text/javascript" src="webcam.js"></script>
	
	<!-- Configure a few settings -->
	<script language="JavaScript">
		webcam.set_api_url( 'saveWebcamFile.do' );
		webcam.set_quality( 90 ); // JPEG quality (1 - 100)
		//webcam.set_shutter_sound( true ); // play shutter click sound
	</script>
	
	<!-- Next, write the movie to the page at 320x240 -->
	<script language="JavaScript">
		document.write( webcam.get_html(280, 210) );
	</script>
	
	<!-- Some buttons for controlling things -->
	<form>
	    
	      <input value="" type="hidden" id="photoId"  name="photoId"  />
	    <input type=button value="捕获" onClick="webcam.freeze()">
		<input type=button value="重置" onClick="webcam.reset()">
		<input type=button value="上传并选择" onClick="do_uploadAndAdd()">
		<br>
		<input type=button value="上传" onClick="do_upload()">
		<input type=button value="选择" onClick="add()">
		<input type=button value="设置" onClick="webcam.configure()">
		
		
		
	</form>
	
	<!-- Code to handle the server response (see test.php) -->
	<script language="JavaScript">
		
		
		function do_upload() {
			// upload to server
			webcam.set_hook( 'onComplete', 'my_completion_handler' );
			document.getElementById('upload_results').innerHTML = '<h1>上传中...</h1>';
			webcam.upload();
		}
		
		function do_uploadAndAdd() {
			// upload to server
			webcam.set_hook( 'onComplete', 'my_completion_handler_add' );
			document.getElementById('upload_results').innerHTML = '<h1>上传中...</h1>';
			webcam.upload();
			
		}
		
		function my_completion_handler(fileid) {
			 //alert("上传成功！");
			 document.getElementById("photoId").value = fileid; 
			 document.getElementById('upload_results').innerHTML = 
					'<img src="${ctx}/pages/FileAttach/pictShow.do?FILEID=' + fileid + '">' + 
					'<h3>上传成功，选择后浏览选中的照片将失效。</h3>';
				
				// reset camera for another shot
				webcam.reset();
		}
		function my_completion_handler_add(fileid) {
			 //alert("上传成功！");
			 document.getElementById("photoId").value = fileid; 
			 document.getElementById('upload_results').innerHTML = 
					'<img src="${ctx}/pages/FileAttach/pictShow.do?FILEID=' + fileid + '">' + 
					'<h3>上传成功，浏览选择的照片将失效。</h3>';
				
				// reset camera for another shot
				add();
				webcam.reset();
		}
	</script>
	
	</td>
	<td width=20>&nbsp;</td>
	<td valign=top>
		<div id="upload_results" style="background-color:#eee;"></div>
	</td></tr></table>

</body>
</html>