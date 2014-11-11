<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="sec"   uri="http://www.springframework.org/security/tags"%>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<%
String webContext = request.getContextPath();
String str_tzCount="0",Str_xctbCount="0";
int tzCount=0,xctbCount=0;
	if (request.getAttribute("tzCount") != null){
		 str_tzCount = (String)request.getAttribute("tzCount");
		 tzCount =  Integer.parseInt(str_tzCount);
	}
	if (request.getAttribute("xctbCount") != null) {
		 Str_xctbCount = (String)request.getAttribute("xctbCount");
		  xctbCount =  Integer.parseInt(Str_xctbCount);
	}
	
%>	 
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312">
<title>达因治安综合管理信息系统</title>
<meta http-equiv="Cache-Control" content="no-store"/>
<meta http-equiv="Pragma" content="no-cache"/>
<meta http-equiv="Expires" content="0"/>
<link href="<%=webContext%>/pages/outlookmenu/css/main.css" rel="stylesheet" type="text/css">
<link href="<%=webContext%>/pages/outlookmenu/css/ListView.css" rel="stylesheet" type="text/css">
<script src="<c:url value="/scripts/dateSelect.js"/>" type="text/javascript"></script>
<%=request.getAttribute("outlookJscript")%>
<script>
function top_tool(){
//alert(window.parent.top_frame.rows);
if(window.parent.top_frame.rows=="0,36,*,28"){
top_frameshow.src="<%=webContext%>/pages/outlookmenu/img/top_p1.gif";
top_tree.title="隐藏标题栏"
window.parent.top_frame.rows="78,36,*,28";
}
else{
top_frameshow.src="<%=webContext%>/pages/outlookmenu/img/top_p2.gif";
top_tree.title="显示标题栏"
window.parent.top_frame.rows="0,36,*,28";
}
}
</script>
</head>
<style type="text/css">
	<!--
	body{
      background: url(<%=webContext%>/pages/outlookmenu/img/menu_bg.gif) left top repeat-x;
      height:34px;
    }
     .topmenu {
	    background-image: url(<%=webContext%>/pages/outlookmenu/img/menu_bg.gif);
		background-repeat: repeat-x;
		height: 34px;
		width: 100%;
		margin:0px;
		padding:0px;
		border-bottom:5px solid #019BD8;	
	}
	-->
	</style>
<BODY>
<div class="topmenu">				
	  
    <DIV id="header"></DIV> 
</div>
</BODY>
</html>
<script language="javascript">
	var leftMenuHtml="";

	function makeSubMenu(menuID){
	    //top.mainFrame.window.location.href = "about:blank";
	    //调整一级菜单被点击后的显示状态
	    var beginPoint = innerHtml.indexOf(menuID);//获得所选菜单id在原始数据中的位置
	    var preStr = innerHtml.substring(0,beginPoint);
	    var endStr = innerHtml.substring(beginPoint);
	    var insertPoint = preStr.lastIndexOf("<li>") + 3;//获取插入id="current"字符串的位置
	    preStr = preStr.substring(0,insertPoint) + ' id="current"' + preStr.substring(insertPoint);
	    header.innerHTML = preStr + endStr;
	    
	    //为生成子菜单准备正确的数据格式
	    leftMenuHtml="";
	    for(var i=0;i<menus.length;i++){
	        var arr=menus[i];
	        if(arr[0]==menuID){
	            leftMenuHtml+='<DSTreeRoot text="'+arr[1]+'" open="true" href="'+arr[2]+'">';
	        }
	        if(arr[3]==menuID){
	            searchSub(arr[0]);
	        }
	    }
	    leftMenuHtml+='</DSTreeRoot>';
	    //显示点击之后一级菜单的画面
	    top.bodyFrame.window.location.href = "<%=webContext%>/pages/outlookmenu/work_body.jsp";
	}
	
	function makeButtonMenu(menuID,url) {
	    defaultURL = url;
		//top.mainFrame.window.location.href = "about:blank";
		//调整一级菜单被点击后的显示状态
		var beginPoint = innerHtml.indexOf(menuID);
		//获得所选菜单id在原始数据中的位置
		var preStr = innerHtml.substring(0,beginPoint);
		var endStr = innerHtml.substring(beginPoint);
		var insertPoint = preStr.lastIndexOf("<li>") + 3;
		//获取插入id="current"字符串的位置
		preStr = preStr.substring(0,insertPoint) + ' id="current"' + preStr.substring(insertPoint);
		header.innerHTML = preStr + endStr;
		//为生成子菜单准备正确的数据格式
		leftMenuHtml="";
		for (var i=0;i<menus.length;i++) {
			var arr=menus[i];
			if (arr[0]==menuID) {
				leftMenuHtml+='<DSTreeRoot text="'+arr[1]+'" open="true" status="'+arr[5]+'"  href="'+arr[2]+'">';
			}
			if (arr[3]==menuID) {
				searchSub(arr[0]);
			}
		}
		leftMenuHtml+='</DSTreeRoot>';
		//显示点击之后一级菜单的画面
		top.bodyFrame.window.location.href = defaultURL;
	}
	
	
	//两个辅助函数
	function searchSub(menuID){
	    var parentID="";
	    var flag = "no";
	    
	    for(var i=0;i<menus.length;i++){
	        var arr=menus[i];
	        if(arr[0]==menuID){
	            if(judgeSub(arr[0],arr[4])==false){
	                leftMenuHtml+='<DSTree text="'+arr[1]+'" open="false" href="'+arr[2]+'" target="mainFrame"/>';
	            }else{
	            	flag = "yes";
	                parentID=arr[0];
	                leftMenuHtml+='<DSTree text="'+arr[1]+'" open="true" href="'+arr[2]+'" target="mainFrame">';
	            }
	        }
	        if(arr[3]==menuID){
	            searchSub(arr[0]);
	            if(judgeSub(parentID,arr[4])==false){
	                leftMenuHtml+='</DSTree>';
	            }
	        } 
	    }
	    if( flag == "yes" )
	    	leftMenuHtml+='</DSTree>';
	    
	}
	function judgeSub(menuID,no){
	    var j=parseInt(no)+1;
	    for(var i=j;i<menus.length;i++){
	        var arr=menus[i];
	        if(arr[3]==menuID) return true;
	    }
	    return false;
	}


	//生成一级菜单
	var innerHtml="<ul>";
	var bodyFrame = "bodyFrame";
	for(var i=0;i<menus.length;i++){
	    var arr=menus[i];
	    if(arr[3]==0){
	        innerHtml+='<li><a href=javascript:makeSubMenu("'+arr[0]+'");>'+arr[1]+'</a></li>';
	    }
	   // if(i==0){
	    //    	makeSubMenu(arr[0]);
	    //    }
	}
	innerHtml=innerHtml.substring(0,innerHtml.length-"".length);
	innerHtml+='</ul>';
	header.innerHTML = innerHtml;
</script>


