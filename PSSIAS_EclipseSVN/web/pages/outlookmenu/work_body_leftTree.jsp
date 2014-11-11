<%@ page contentType="text/html; charset=UTF-8"%>
<%
String webContext = request.getContextPath();
%>
<html>
<script src="<%=webContext%>/pages/outlookmenu/scripts/xmltree.js"></script>
<link href="<%=webContext%>/pages/outlookmenu/css/main.css" rel="stylesheet" type="text/css">
<link href="<%=webContext%>/pages/outlookmenu/css/ListView.css" rel="stylesheet" type="text/css">
		<meta http-equiv="Cache-Control" content="no-store"/>
        <meta http-equiv="Pragma" content="no-cache"/>
        <meta http-equiv="Expires" content="0"/>
<style>
 body{
   filter:progid:DXImageTransform.Microsoft.Gradient(startColorStr='#CFE6F5', endColorStr='#C1E8FB', gradientType='0');
   /*border-bottom:5px solid #019BD8;*/
   border-left:5px solid #019BD8;
   /*background:#C9E5F7;*/
   width:100%;
}
 .menu_bg{
    background:url("img/leftmenu_head.gif") left top no-repeat;
    width:175px;
    height:60px;
    padding:50px 0px 0px 5px;
 }
 img {
    border:0px;
    margin:0;
    padding:0;
    float:left;
    vertical-align:top;
}
</style>	
	<body>
  <div class="menu_bg">
	<xml id="menuXML"></xml>
	
	<div id="treeBox"></div>
  </div>
	</body>
	
	<a href="" id="initmenu"></a>
	
</html>

<script language="javascript">

	function creatTree(){
		//取得生成树的数据
		var leftMenuStr = top.topFrame.leftMenuHtml;
		
		//将取得的数据转化成 DOM
		var xmlDoc = document.all.menuXML.XMLDocument; 
	    document.all.treeBox.innerHTML = "";
	    xmlDoc.async="false";
	    xmlDoc.loadXML(leftMenuStr);
	    //根据DOM生成可见的菜单树
	    initTree();
	}
	
	window.onload = creatTree;
</script>