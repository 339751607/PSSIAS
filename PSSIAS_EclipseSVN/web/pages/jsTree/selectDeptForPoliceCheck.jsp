<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/commons/taglibs.jsp" %>
<%
String formName="";
String inputName="";
String hiddenName="";
String hiddenType="";
String maxPatiNum="";
String initPageFlag="";
String rootID="";
String deptID="";
String deptTypeId = "";
String idValueIsSeq = "false";
String startwith="";
String fzrName="";
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
if(request.getAttribute("initPageFlag") != null)
   initPageFlag = (String)request.getAttribute("initPageFlag");
if(request.getAttribute("rootID") != null)
   rootID = (String)request.getAttribute("rootID");
if(request.getAttribute("deptID") != null)
   deptID = (String)request.getAttribute("deptID");
if(request.getAttribute("deptTypeId") != null)
   deptTypeId = (String)request.getAttribute("deptTypeId");                          
if(request.getAttribute("idValueIsSeq") != null)
   idValueIsSeq = (String)request.getAttribute("idValueIsSeq");
if(request.getAttribute("startwith") != null)
	startwith = (String)request.getAttribute("startwith");  
if(request.getAttribute("fzrName") != null)
	fzrName = (String)request.getAttribute("fzrName");

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

	<style type="text/css">
	html, body { margin:0; padding:0;}
	body, td, th, pre, code, select, option, input, textarea { font-family:verdana,arial,sans-serif; font-size:10px; }
	.demo, .demo input, .jstree-dnd-helper, #vakata-contextmenu { font-size:10px; font-family:Verdana; }
	#container { width:550px; margin:10px auto; overflow:hidden; position:relative; }
	#demo { width:auto; height:480px; overflow:auto; border:1px solid gray; }

	#menu { height:30px; overflow:auto; }
	#text { margin-top:1px; }

	#alog { font-size:9px !important; margin:5px; border:1px solid silver; }
	</style>
</head>
<body onLoad="javascript:initSelect();">
<div id="container">

<!-- the tree container (notice NOT an UL node) -->
<div id="demo" class="demo"></div>
<!-- JavaScript neccessary for the tree -->
<script type="text/javascript">
		    
        var caller = window.dialogArguments;
		var retName="";
		var retValue="";
		var formName="<%=formName%>";
		var inputName="<%=inputName%>";
		var hiddenName="<%=hiddenName%>";
		var hiddenType="<%=hiddenType%>";
		var maxPatiNum= "<%=maxPatiNum%>";
		var initPageFlag= "<%=initPageFlag%>";
		var rootID= "<%=rootID%>";
		var deptID= "<%=deptID%>";
		var idValueIsSeq= "<%=idValueIsSeq%>";
		var fzrName= "<%=fzrName%>";
		if(rootID == 'true')
		    deptID = '1000';  
$(function () {
	// Settings up the tree - using $(selector).jstree(options);
	// All those configuration options are documented in the _docs folder
	$("#demo")
		.jstree({ 
			// the list of plugins to include
			"plugins" : [ "themes", "json_data", "ui", "crrm", "cookies", "dnd", "search", "types", "hotkeys", "contextmenu" ],
			// Plugin configuration

			// I usually configure the plugin that handles the data first - in this case JSON as it is most common
			"json_data" : { 
				// I chose an ajax enabled tree - again - as this is most common, and maybe a bit more complex
				// All the options are the same as jQuery's except for `data` which CAN (not should) be a function
				"ajax" : {
					// the URL to fetch the data
					"url" : "${ctx}/pages/SsDept/getJsTreeForPoliceCheck.do?rootID=<%=rootID%>&deptTypeId=<%=deptTypeId%>&startwith=<%=startwith%>",
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
			// Configuring the search plugin
			"search" : {
				// As this has been a common question - async search
				// Same as above - the `ajax` config option is actually jQuery's object (only `data` can be a function)
				"ajax" : {
					"url" : "./server.php",
					// You get the search string as a parameter
					"data" : function (str) {
						return { 
							"operation" : "search", 
							"search_str" : str 
						}; 
					}
				}
			},
			// Using types - most of the time this is an overkill
			// Still meny people use them - here is how
			"types" : {
				// I set both options to -2, as I do not need depth and children count checking
				// Those two checks may slow jstree a lot, so use only when needed
				"max_depth" : -2,
				"max_children" : -2,
				// I want only `drive` nodes to be root nodes 
				// This will prevent moving or creating any other type as a root node
				"valid_children" : [ "drive" ],
				"types" : {
					// The default type
					"default" : {
						// I want this type to have no children (so only leaf nodes)
						// In my case - those are files
						"valid_children" : "none",
						// If we specify an icon for the default type it WILL OVERRIDE the theme icons
						"icon" : {
							"image" : "${ctx}/pages/jsTree/file.png"
						}
					},
					// The `folder` type
					"folder" : {
						// can have files and other folders inside of it, but NOT `drive` nodes
						"valid_children" : [ "default", "folder" ],
						"icon" : {
							"image" : "${ctx}/pages/jsTree/folder.png"
						}
					},
					// The `drive` nodes 
					"drive" : {
						// can have files and folders inside, but NOT other `drive` nodes
						"valid_children" : [ "default", "folder" ],
						"icon" : {
						    "image" : "${ctx}/pages/jsTree/root.png"
						},
						// those options prevent the functions with the same name to be used on the `drive` type nodes
						// internally the `before` event is used
						"start_drag" : false,
						"move_node" : false,
						"delete_node" : false,
						"remove" : false
					}
				}
			},
			// For UI & core - the nodes to initially select and open will be overwritten by the cookie plugin

			// the UI plugin - it handles selecting/deselecting/hovering nodes
			"ui" : {
				// this makes the node with ID node_4 selected onload
				"initially_select" : [ deptID ]
			},
			// the core plugin - not many options here
			"core" : { 
				// just open those two nodes up
				// as this is an AJAX enabled tree, both will be downloaded from the server
				"initially_open" : [ deptID ] 
			}
		})
		.bind("select_node.jstree", function (event, data){
		  var name = data.rslt.obj.attr("names");
		  var id = data.rslt.obj.attr("id");
		  var type = data.rslt.obj.attr("rel"); 
		  var deptseq = data.rslt.obj.attr("deptseq"); 
		  var deptcode = data.rslt.obj.attr("deptcode");
		   // alert(" idValueIsSeq"+idValueIsSeq);
		    // alert(" deptcode"+deptcode);
		    //alert(idValueIsSeq);
		  if(initPageFlag =="1") {
		    
		         addP(name,id+"----"+deptseq,type);
		    
		   
		   }
		   initPageFlag = "1";
		 });
});
</script>
<script type="text/javascript">
$(function () { 
	$("#menu input").click(function () {
		switch(this.id) {
			case "add_default":
			case "add_folder":
				$("#demo").jstree("create", null, "last", { "attr" : { "rel" : this.id.toString().replace("add_", "") } });
				break;
			case "search":
				$("#demo").jstree("search", document.getElementById("text").value);
				break;
			case "text": break;
			default:
				$("#demo").jstree(this.id);
				break;
		}
	});
});



		
		function initSelect(){
		   if ("ID_SPLIT"==hiddenType) {
			        if(hiddenName!='undefined'&&inputName!=undefined){
					     inputNameValue=eval("caller.elements['"  +  inputName +   "'].value " );
					     hiddenNameValue=eval("caller.elements['"  +  hiddenName +  "'].value ");
					     fzrNameValue=eval("caller.elements['"  +  fzrName +  "'].value ");
						if(inputNameValue!=""){
							  if(inputNameValue.indexOf(";")!=-1){
							    var nameArray=inputNameValue.split(";");
							    var hiddenArray=hiddenNameValue.split(";");
							     var fzrArray=fzrNameValue.split(";");
							    for(var i=0;i<nameArray.length;i++){
							     document.form2.selectedOperator.options[i]=new Option(nameArray[i],hiddenArray[i]+"----"+fzrArray[i]);
							    }
							  }else{
							    document.form2.selectedOperator.options[0]=new Option(inputNameValue,hiddenNameValue+"----"+fzrNameValue);
							  }
						}
					}
				}
		
		
		}
         /**
		  *	该方法中具体执行点击确定按钮后的，执行动作
		  */
		function add(){
			var elm = document.form2.selectedOperator;
			var curLength = elm.options.length;
			//这里作循环拼出返回到inputName和hiddenName中的值
			if (curLength>0) {
				for (var i = 0; i < document.form2.selectedOperator.length-1 ; i++) {
					retName += document.form2.selectedOperator.options[i].text+";";
				if ("ID_SPLIT"==hiddenType) {
					retValue += document.form2.selectedOperator.options[i].value+";";
				}else{
					retValue += document.form2.selectedOperator.options[i].value;					
					}
				}
				retValue += document.form2.selectedOperator.options[document.form2.selectedOperator.length-1].value;
				retName += document.form2.selectedOperator.options[document.form2.selectedOperator.length-1].text;
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
				 eval("caller.elements['"  +  hiddenName +  "'].value = '"+retValue.split("----")[0]+"';");
				 eval("caller.elements['"  +  fzrName +  "'].value = '"+retValue.split("----")[1]+"';");
			 }
			 window.close();
		}
		function remove(){
			var elm = document.form2.selectedOperator;
			var Cnt = elm.options.length;
			var delCnt = 0;
			var j=0;
			var	unSelectedOptions=new Array(Cnt);
			for (var i = 0;i<Cnt;i++) {
				if (elm.options[i].selected) 
					delCnt++;
				else
					unSelectedOptions[j++]=new Option(elm.options[i].text,elm.options[i].value);

			}
			elm.options.length-=delCnt;
			for (var i=0;i<elm.options.length;i++) {
				elm.options[i]= new Option(unSelectedOptions[i].text,unSelectedOptions[i].value);
			}

		}
		
		
		
		function addP(name,id,type){ 
			var ops = document.form2.selectedOperator.options;
			var	length = ops.length;
			var value = setvalue(hiddenType,id,type,name);
			initPageFlag = "1";
			if(check(value)==0){
				ops[length]=new Option(name,value);		
				//parent.manipulate.document.form2.selectedOperator.options.length++;
			}
		
	    }
	
	    function setvalue(hiddentype,id,type,name){
		    var slt    = document.form2.selectedOperator;
	        if(hiddentype=="ID_SPLIT") 
	        return id;
	    }
	   //防止选中已选的
		function check(value){
			var slt    = document.form2.selectedOperator;
			var flag=0;
			//alert(maxPatiNum);
			if(maxPatiNum != "" && maxPatiNum <= document.form2.selectedOperator.options.length){
					flag=1;
					alert("超过最多可选择参与者的个数");				
					return flag;//修改-----------------------增加返回
			}
			for(var i=0;i<document.form2.selectedOperator.length;i++){
				if(value==slt.options[i].value)	{
						alert("该选项已经选中");
						flag=1;
						return flag;//修改-----------------------增加返回
				}
			}
			return flag;
		}
		

</script>

<div style="position:absolute; right:20px; top:10px; width:220px; border:1px solid silver; min-height:260px;">  
<form name="form2" method="post">
			<table width="100%" border="0">
				<tr>
					<td><font size="2">选中的部门</font></td>
				</tr>
				<tr>
					<td><select size="21" name="selectedOperator" style="font-size:16px;width:100%;" multiple="true">
						</select></td>
				</tr>
				<tr>
					<td width="50%" valign="bottom" align="center">
					   <input type="button" value="确定" onClick="javascript:add();" />
					   <input type="button" value="移除" onClick="javascript:remove();" />
					   <input type="button" value="关闭" onClick="javascript:parent.window.close();" /></td>
				</tr>
			</table>
		</form>

</div>

</div>

</body>
</html>