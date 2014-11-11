<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/commons/taglibs.jsp" %>
<%
String formName="";
String inputName="";
String hiddenName="";
String hiddenType="";
String maxPatiNum="";
String rootID="";
String deptID="";
String initSelectIds="";
String initOpenIds="";
String deptTypeId = "";

if(request.getAttribute("formName") != null)
   formName = (String)request.getAttribute("formName");
if(request.getAttribute("inputName") != null)
   inputName =(String) request.getAttribute("inputName");
if(request.getAttribute("hiddenName") != null)
   hiddenName =(String) request.getAttribute("hiddenName");
if(request.getAttribute("hiddenType") != null)
   hiddenType = (String)request.getAttribute("hiddenType");
if(request.getAttribute("maxPatiNum") != null)
   maxPatiNum = (String)request.getAttribute("maxPatiNum");
if(request.getAttribute("rootID") != null)
   rootID = (String)request.getAttribute("rootID");  
if(request.getAttribute("deptID") != null)
   deptID = (String)request.getAttribute("deptID"); 
if(request.getAttribute("initSelectIds") != null)
   initSelectIds = (String)request.getAttribute("initSelectIds");
if(request.getAttribute("initOpenIds") != null)
   initOpenIds = (String)request.getAttribute("initOpenIds");
if(request.getAttribute("deptTypeId") != null)
   deptTypeId = (String)request.getAttribute("deptTypeId");               
               

 %>
<!DOCTYPE html
PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN"
"http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<title>部门选择</title>
	<script type="text/javascript" src="${ctx}/scripts/jsTree/_lib/jquery.js"></script>
	<script type="text/javascript" src="${ctx}/scripts/jsTree/_lib/jquery.cookie.js"></script>
	<script type="text/javascript" src="${ctx}/scripts/jsTree/_lib/jquery.hotkeys.js"></script>
	<script type="text/javascript" src="${ctx}/scripts/jsTree/jquery.jstree.js"></script>

    <link type="text/css" rel="stylesheet" href="${ctx}/scripts/jsTree/syntax/!style.css"/>
	<script type="text/javascript" src="${ctx}/scripts/jsTree/syntax/!script.js"></script>
	<style type="text/css">
	html, body { margin:0; padding:0;}
	body, td, th, pre, code, select, option, input, textarea { font-family:verdana,arial,sans-serif; font-size:10px; }
	.demo, .demo input, .jstree-dnd-helper, #vakata-contextmenu { font-size:10px; font-family:Verdana; }
	#container { width:420px; margin:10px auto; overflow:hidden; position:relative; }
	#demo1 { width:auto; height:450px; overflow:auto; border:1px solid gray; }
	</style>
</head>
<body>
		<div id="container">
			<table width="100%" border="0">
				<tr>
					<td>
						<div id="demo1" class="demo">
						</div>
					</td>
				</tr>
				<tr>
					<td width="50%" valign="bottom" align="center">
						<input type="button"
							value="确定" onclick="javascript:getMenuIds();" />
						<input type="button"
							
							value="关闭" onclick="javascript:parent.window.close();" />
					</td>
				</tr>
			</table>


		</div>
		<script type="text/javascript" class="source">
        var caller = window.dialogArguments;
        var retName="";
		var retValue="";
		var formName="<%=formName%>";
		var inputName="<%=inputName%>";
		var hiddenName="<%=hiddenName%>";
		var hiddenType="<%=hiddenType%>";
		var maxPatiNum= "<%=maxPatiNum%>";
		var rootID= "<%=rootID%>";
		var deptID= "<%=deptID%>";
		if(rootID == 'true')
		    deptID = '1000';
		    
   
		
$(function () {
	// Settings up the tree - using $(selector).jstree(options);
	// All those configuration options are documented in the _docs folder
	

	
	
	$("#demo1")
		.jstree({ 
			// the list of plugins to include
			"plugins" : [ "themes", "json_data", "ui", "checkbox"],
			// Plugin configuration

			// I usually configure the plugin that handles the data first - in this case JSON as it is most common
			"json_data" : { 
				// I chose an ajax enabled tree - again - as this is most common, and maybe a bit more complex
				// All the options are the same as jQuery's except for `data` which CAN (not should) be a function
				"ajax" : {
					// the URL to fetch the data
					"url" : "${ctx}/pages/SsDept/getJsTree.do?rootID=<%=rootID%>&deptTypeId=<%=deptTypeId%>",
					// this function is executed in the instance's scope (this refers to the tree instance)
					// the parameter is the node being loaded (may be -1, 0, or undefined when loading the root nodes)
					"data" : function (n) { 
						// the result is fed to the AJAX request `data` option
						return { 
							"operation" : "get_children", 
							"id" : n.attr ? n.attr("id").replace("node_","") : 1 
						}; 
					}
				}
			},
			
			
			// For UI & core - the nodes to initially select and open will be overwritten by the cookie plugin

			// the UI plugin - it handles selecting/deselecting/hovering nodes
			"ui" : {
				// this makes the node with ID node_4 selected onload
				"initially_select" : [ <%=initSelectIds%> ]
			},
			// the core plugin - not many options here
			"core" : { 
				// just open those two nodes up
				// as this is an AJAX enabled tree, both will be downloaded from the server
				"initially_open" : [<%=initOpenIds%>] 
			}
		});
});



     //取得选中的菜单id 
      function getMenuIds(){
	       //取得所有选中的节点，返回节点对象的集合
	       var menu =  $("#demo1").jstree("get_checked");           
	       //得到节点的id.，拼接成字符串 
	       if (menu.size()>0) {
		       for(i=0;i<menu.size()-1;i++){
		            retName +=  menu[i].names+";";
		            if ("ID_SPLIT"==hiddenType) {
							retValue += menu[i].id+";";
					}else{
							retValue += menu[i].id;					
				    }
		        }
		        retValue += menu[menu.size()-1].id;
		        retName +=  menu[menu.size()-1].names;
	       }
	       if (retValue=="") {
				alert("请选择参与者");
				return;
			}
		   if (inputName=="") 
				inputName="null";
		   if (hiddenName=="") 
				 hiddenName="null";
		   if(hiddenName!='undefined'&&inputName!=undefined){
				 eval("caller.elements['"  +  inputName +   "'].value = '"+retName+"';" );
				 eval("caller.elements['"  +  hiddenName +  "'].value = '"+retValue+"';");
		   }
			window.close();
        
     
      } 
      
      
    
      
</script>
</body>
</html>