<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/commons/taglibs.jsp" %>
<%@page import="com.dyneinfo.fjy.model.*,java.util.List" %>
<%
response.setHeader("Pragma","No-Cache");
response.setHeader("Cache-Control","No-Cache");
response.setDateHeader("Expires", 0);
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+request.getContextPath()+"/";
String telinfoids = "";
if (request.getAttribute("telinfoids") != null)
	telinfoids = (String)request.getAttribute("telinfoids");
%>
<html>
<head>
	<%@ include file="/commons/meta.jsp" %>
	<base href="<%=basePath%>">
	<link rel="stylesheet" href="${ctx}/styles/tab.css" type="text/css"/>
	<style type="text/css">
		.tabSelectUp {
			font-size: 12px;
			cursor: default;
			background: url("${ctx}/images/tab/tab_select.gif");
			color: buttontext;
			padding-left: 2px;
			padding-right: 2px;
			padding-top: 2px;
			text-decoration: underline;
		}
		.tabSelectDown {
			font-size: 12px;
			cursor: default;
			background: url("${ctx}images/tab/tab_unselect.gif");
			color: buttontext;
			padding-left: 2px;
			padding-right: 2px;
			padding-top: 5px;
		}
      </style>
	  <SCRIPT language="JavaScript" src="${ctx}/scripts/tab.js"></SCRIPT>
	  <script type='text/javascript'>	
		function createTabTable(tabId, imgPath) {
			tabId.defaultSelectNo = -1;
			tabId.total = 0;
			tabId.tabContent = new Array();
	
			tabId.select_tab = _tab_select;
			tabId.createTabContent = _create_tab_content;
			tabId.initTab = _init_tab_table;
			tabId.showTabByObj = _show_tab_by_obj;
			tabId.mouseovertab = _mouse_over_tab;
			tabId.mouseouttab = _mouse_out_tab;
			tabId.select_obj = _obj_select;
	
			tabId.imgPath = "${ctx}/images/tab";
			if (imgPath != null)
				tabId.imgPath = imgPath;
		}
      </script>
		<title></title>
</head>
<body topmargin="0">
 <script language="javascript">    
    document.title = "销售信息";
 </script>
<mytag:tab id="orgInfo"  width="100%" height="100%"   >
     <mytag:tabContent url="${ctx}/pages/fjy/TelInfoView/show.do?sbutton=1"     param="telinfoid"  paramValue="<%=telinfoids%>"   frameBorder="0" tabType="frame" scrolling="auto" title="手机信息"/>
	 <mytag:tabContent url="${ctx}/pages/fjy/Telxs/show.do"  selected="true"   param="telinfoid"  paramValue="<%=telinfoids%>"   frameBorder="0" tabType="frame" scrolling="auto" title="销售信息"/>
</mytag:tab>
</body>
</html>
<script>
	
    function doBack(){
    	var url="";
    	url =  "${ctx}/pages/fjy/Telxs/list.do?<mytag:params includes="ec*,s*" type="queryStringUtf"/>";
    	location.href = url;
    }
</script>