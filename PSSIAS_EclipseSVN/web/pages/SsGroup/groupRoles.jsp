<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/commons/taglibs.jsp" %>
<%
String initOpenIds="";
String initSelectIds="";
String groupid="";

if(request.getAttribute("initOpenIds") != null)
   initOpenIds = (String)request.getAttribute("initOpenIds");

if(request.getAttribute("initSelectIds") != null)   
	initSelectIds =(String) request.getAttribute("initSelectIds");

groupid = request.getAttribute("groupid")==null?"" : request.getAttribute("groupid").toString();               

 %>
<!DOCTYPE html
PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN"
"http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<title>角色选择</title>
		
		<%@ include file="/commons/meta.jsp" %>
		

    
	<script type="text/javascript" src="${ctx}/scripts/jsTree/_lib/jquery.js"></script>
	<script type="text/javascript" src="${ctx}/scripts/jsTree/_lib/jquery.cookie.js"></script>
	<script type="text/javascript" src="${ctx}/scripts/jsTree/_lib/jquery.hotkeys.js"></script>
	<script type="text/javascript" src="${ctx}/scripts/jsTree/jquery.jstree.js"></script>


</head>
<body>
		
			<table width="100%" border="0">
			<s:form action="/pages/SsGroup/groupRolesCheckbox.do" name="groupRolesCheckbox" theme="simple"  method="post">
			 <input type="hidden" name="groupid" value="<%=groupid%>" id="groupid"/>
			 <input type="hidden" name="selectRoles" id="selectRoles" />
			  <input type="hidden" name="action" value="y" id="action"/>
			
				<tr>
					<td>
						<div id="demo1" 
						style="width:100%; height: 380px; background-color: #fff; border: 1px solid #99bbe8; font-size: 12px; overflow: auto;">
						</div>
					</td>
				</tr>
				<tr>
					<td  valign="bottom" align="center"  class="tb_bottom">
						<input type="button"
							value="保存" onclick="javascript:getRoleIds();" />
						</td>
				</tr>
				</s:form>
			</table>


		
		<script type="text/javascript" class="source">
        var caller = window.dialogArguments;
        var retName="";
		var retValue="";
		
		
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
					"url" : "${ctx}/pages/SsGroup/getRolesJsTree.do?rootID=000",
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
				"initially_open" : [ <%=initOpenIds%> ] 
			}
		});
});



     //取得选中的菜单id 
      function getRoleIds(){
	       //取得所有选中的节点，返回节点对象的集合
	       var role =  $("#demo1").jstree("get_checked2");   
	       var retName = "";
	       var retValue = "";
	       //得到节点的id.，拼接成字符串 
	       if (role.size()>0) {
		       for(i=0;i<role.size()-1;i++){
		            retName += role[i].names+";";
		            retValue += role[i].id+";";
		       }
		        retValue += role[role.size()-1].id;
		        retName +=  role[role.size()-1].names;
		         // $('#selectRoles')[0].value = retValue;
		        //$('#selectRoles').val(retValue) ;
		        document.getElementById("selectRoles").value=retValue;		        

	       }

	       document.forms.groupRolesCheckbox.submit();           
     
      } 
      
      
    
      
</script>
</body>
</html>