<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="authz"
	uri="http://www.springframework.org/security/tags"%>
<%@ page import="net.java.dev.common.dict.taglib.DictHelpImpl"%>
<c:set var="ctx" value="${pageContext.request.contextPath}" />
<%
	String webContext = request.getContextPath();
	String mServerUrl = "http://" + request.getServerName() + ":"
			+ request.getServerPort();
%>

<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=gb2312">
		<title>散装汽油销售治安管理信息系统</title>
		<meta http-equiv="Cache-Control" content="no-store" />
		<meta http-equiv="Pragma" content="no-cache" />
		<meta http-equiv="Expires" content="0" />
		<link href="css/main.css" rel="stylesheet" type="text/css">
		<link href="css/ListView.css" rel="stylesheet" type="text/css">
	</head>
	<style type="text/css">
body {
	background: url(img/top_head_bg.gif) left top repeat-x;
	height: 72px;
	text-align: center;
}

.tophead {
	width: 100%;
	background: url("img/tophead_bg.gif") left top repeat-x;
	height: 78px;
	margin: 0px;
	padding: 0px;
}

.tophead_left {
	background: url("img/tophead_left.gif") left top no-repeat;
	width: 640px;
	height: 78px;
	float: left;
}

.tophead_right {
	background: url("img/tophead_right.gif") left top no-repeat;
	width: 300px;
	height: 78px;
	float: right;
	padding: 20px 0px 0px 94px;
	font-size: 14px;
	font-weight:bold;
	font-family: "微软雅黑", "Verdana", "Arial", "Helvetica";
}

.tophead_right a {
	margin: 0px;
	padding: 0px;
	color: #ffffff;
	text-decoration: none;
}

.tophead_right a:hover {
	margin: 0px;
	padding: 0px;
	color: #ff0000;
	text-decoration: underline;
}

.tophead_right a:visited {
	margin: 0px;
	padding: 0px;
	color: #ffffff;
	text-decoration: none;
}
</style>



	<BODY bgcolor="#0097D6">
		<table cellpadding="0" cellpadding="0" cellspacing="0" border="0"
			class="tophead">
			<tr>
				<td width="100%">
					<div class="tophead_left">
<!--					<object classid="clsid:d27cdb6e-ae6d-11cf-96b8-444553540000"-->
<!--codebase="http://download.macromedia.com/pub/shockwave/cabs/flash/swflash.cab#version=6,0,0,0"-->
<!--width="640" height="78" id="tophead" align="">-->
<!--<param name=movie value="img/tophead.swf"><param name=quality value=high>-->
<!--<embed src="tophead.swf" quality=high  width="640" height="78" name="tophead" align=""-->
<!--type="application/x-shockwave-flash" pluginspage="http://www.macromedia.com/go/getflashplayer">-->
<!--</embed></object>-->
</div>
					<div class="tophead_right">
						<span style="margin: 0px 0px 0px 20px;"><a
							href="${ctx}/pages/zazh/SsDatasource/loginfo.do" target="bodyFrame"><img src="img/index.gif" width="32" height="50"/></a>
						</span>
						<span style="margin: 0px 0px 0px 20px;"><a
							href="${ctx}/pages/SsUser/changepwd.do" target="bodyFrame"><img src="img/key.gif" width="32" height="50"/></a>
						</span>
						<span style="margin: 0px 0px 0px 20px;"><a
							href="${ctx}/j_spring_security_logout" target="_top"><img src="img/exit.gif" width="32" height="50"/></a>
						</span>
					</div>
				</td>

			</tr>
		</table>

	</BODY>
</html>