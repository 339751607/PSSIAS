<%@page import="com.dyneinfo.zazh.model.*" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/commons/taglibs.jsp" %>
<%
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+request.getContextPath()+"/";
String id = "";
if (request.getParameter("id") != null)
				id = request.getParameter("id");
%>
<html>
<head>
	<%@ include file="/commons/wdScrollTab.jsp" %>
	<title>角色组</title>
</head>
<script type="text/javascript" >
var tabpanel;  
var jcTabs = [
'<iframe src="../../pages/SsGroup/list.do" width="100%" height="100%" frameborder="0"></iframe>'
];

$(document).ready(function(){  
    tabpanel = new TabPanel({  
        renderTo:'tab',  
        width:'100%',  
        height:'100%',  
        //border:'none',  
        active : 0,
        //maxLength : 10,  
        items : [
            {id:'toolbarPlugin1',title:'角色组',html:jcTabs[0],closable: false}
        ]
    });  
}); 
</script>
</head>
<body topmargin="0" leftmargin="0">
 <div id="tab"></div>
 <div >
 
 </div>
</body>
</html>




