<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<title>务工易信息支撑门户</title>
		<%
			String BasePath = request.getContextPath();
		%>
		<link href="<%=BasePath%>/css/base.css" rel="stylesheet"
			type="text/css" />
		<link href="<%=BasePath%>/css/main.css" rel="stylesheet"
			type="text/css" />

		<script type="text/javascript">
	        function showParentBtn()
	        {
	        	window.parent.document.getElementById("closeBtn").disabled=false;
		    }
        </script>
	<body onload="showParentBtn()" >
		<FORM METHOD=POST ACTION="" name="excelAction" enctype ="multipart/form-data">
			<div id="main">
				<div class="content p15">
					<div class="bd_e mb10 p10">
						<dl class="box_01 sch">
							<dt>
								<span class="f_r c039"> </span>
								<b ><font color="#FF0000">导入文件错误：</font></b>
							</dt>
							<dd class="bd_e">
								<table>

									<tr>
										<td>
											文件被占用、过大或为不支持的文件格式！
											<a href="#" onclick="javascript:history.go(-1)">返回</a>
										</td>
									</tr>
								</table>
								</dd>
							</dl>
						
					</div>
				</div>
			</div>

		</form>
	</body>

</html>