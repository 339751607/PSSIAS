<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/commons/taglibs.jsp"%>
<%@ page import="com.dyneinfo.jxy.model.*"%>
<%@ page import="net.java.dev.common.dict.taglib.DictHelpImpl"%>
<%
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+request.getContextPath()+"/";
String sfzhcardtype = "1";	
String serveritemName = "";
if(request.getAttribute("serveritemName") != null)
	serveritemName =(String)request.getAttribute("serveritemName");
	
	String deploycity = (String)DictHelpImpl.getInitData("deploycity");
	request.setAttribute("city",deploycity);
	String typecode = (String)request.getAttribute("typecode");
	String smycode = (String)request.getAttribute("smycode");
	int inCol=1;
	//if(deploycity.equals("ZhanJiang"))
//		inCol=3;
//	else
//		inCol=1;
%>
<html>
	<head>
		<%@ include file="/commons/meta.jsp"%>
		<base href="<%=basePath%>">
		<title><%=Tcarinfo.TABLE_ALIAS%>编辑</title>
		<style type="text/css">
		</style>
	</head>

	<body onload="quickSelectInit()"  id="bd">
		<%@ include file="/commons/messages.jsp"%>

		<s:form action="/jxy/Tcarinfo/collectUpdate.do" theme="simple"
			name="inputForm" enctype="multipart/form-data" method="post">
			<table cellpadding="0" cellspacing="0" border="0" class="tb_all">
				<input type="hidden" name="returnUrl"
					value="!/jxy/Tcarinfo/list.do?<mytag:params includes="ec*,s*" type="queryStringUtf"/>" />
				<s:hidden id="enrolid" name="enrolid" />
				 <s:hidden  id="serveritem" name="serveritem" value="%{model.serveritem}"></s:hidden>
				<tr>
					<td colspan="5" class="tb_title">
						<%=Tcarinfo.TABLE_ALIAS%>编辑
					</td>
				</tr>
				<tr class="crosscolor_tr" >
					<td colspan="4" >
						<b>车辆信息</b>
					</td>
					<td	width="25%" align="center"> 
					<b><%=Tcarinfo.ALIAS_CARPICTURE%></b>
					</td>
				</tr>
				<tr class="crosscolor_tr">
					<td class="crosscolor_td">
						<%=Tcarinfo.ALIAS_CAROWNER%>

					</td>
					<td >
						<s:property value="%{model.carowner}" />
					</td>
					<td  class="crosscolor_td">
						<%=Tcarinfo.ALIAS_CARID%>
					</td>
					<td >
						<mytag:write property="%{model.carid1}" 
							notEmpty="true" dictName="cpht" />
							<s:property value="%{model.carid}" />
					</td>
					<td rowspan="4"  align="center">
									<a
							onclick="javascript:uploadEmpPhoto('<s:property value="%{model.enrolid}" />');return false;"
							href="#"> <img
								src='${ctx}/jxy/Tcarinfo/showPic.do?enrolid=<s:property value="%{model.enrolid}" />'
								onerror="this.src='${ctx}/images/noCar.gif'"   
								alt="" height="100" width="200" border="0" name="photo"> </a>
							
						
					</td>
				</tr>
				<tr class="crosscolor_tr">
					<td class="crosscolor_td">
						<%=Tcarinfo.ALIAS_CARTYPE%>
					</td>
					<td>
						<mytag:write property="%{model.cartype}"
							notEmpty="true" dictName="cllx" />
					</td>
					<td class="crosscolor_td">
						<%=Tcarinfo.ALIAS_BRAND%>
					</td>
					<td>
						<s:property value="%{model.brand}" />

					</td>
					
				</tr>

				<tr class="crosscolor_tr">
					<td class="crosscolor_td">
						<%=Tcarinfo.ALIAS_ENGINECODE%>
					</td>
					<td colspan=<%=inCol%>>
						<s:property value="%{model.enginecode}" />
					</td>
				  <td class="crosscolor_td">
			                    <%=Tcarinfo.ALIAS_CLSBCODE%>
		                  </td>
			              <td >
			              <s:property value="%{model.clsbcode}"/>
		                 </td>
				</tr>
				<tr class="crosscolor_tr">
					<td class="crosscolor_td" colspan="4">
						<%=Tcarinfo.ALIAS_COLOR%>：&nbsp;
						<mytag:write property="%{model.color1}" 
							notEmpty="true" dictName="csys" />
						&nbsp;&nbsp;&nbsp;&nbsp;第一辅色：&nbsp;
						<mytag:write property="%{model.color2}" 
							notEmpty="true" dictName="csys" />
						&nbsp;&nbsp;&nbsp;&nbsp;第二辅色：&nbsp;
						<mytag:write property="%{model.color3}" 
							notEmpty="true" dictName="csys" />
					</td>
				</tr>
				<tr class="crosscolor_tr">
					<td colspan="4" class="crosscolor_d">
						<b>车辆交接信息</b>
					</td>
					<td	width="25%" align="center"> 
					<b>取车人照片</b>
					</td>
				</tr>
				<tr class="crosscolor_tr">
					<td class="crosscolor_td">
						<%=Tcarreturn.ALIAS_DELINAME%>
					</td>
					<td>
						<s:property value="%{model.deliname}" />
		                <s:hidden label="%{@vs@ALIAS_TAKEOFFNAME}" id="deliname" key="deliname" value="%{model.deliname}"  required="false" />
					</td>
					<td class="crosscolor_td">
<!--						<%=Tcarreturn.ALIAS_DELICREDCODE%>-->送车人证件号码
					</td>
					<td>
					<s:property value="%{model.delicredcode}" />
	                <s:hidden label="%{@vs@ALIAS_TAKEOFFNAME}" id="delicredcode" key="delicredcode" value="%{model.delicredcode}" required="false" />
					</td>
					<td width="25%" rowspan="8" id="clxxDevice" bgcolor="#EDF1FF">
					  <%if(typecode.equals("1") && smycode.equals("1")){ %>
						<IFRAME height="170" width="200" name="ifranmename" src="${ctx}/pages/jxy/Tcarinfo/Collect.html"
							align="center" frameBorder="0" marginHeight="0" marginWidth="0"></IFRAME>
							<IFRAME height="170" width="200" name="ifranmename" src="${ctx}/pages/jxy/Tcarinfo/CVR_IDCardCollect.html"
							align="center" frameBorder="0" marginHeight="0" marginWidth="0"></IFRAME>
					   <%}if(!smycode.equals("1") && typecode.equals("1")) { %>     
						<IFRAME height="170" width="200" name="ifranmename" src="${ctx}/pages/jxy/Tcarinfo/Collect.html"
							align="center" frameBorder="0" marginHeight="0" marginWidth="0"></IFRAME>
					    <% } else if(!typecode.equals("1") && smycode.equals("1")) { %>	
					    <IFRAME height="170" width="200" name="ifranmename" src="${ctx}/pages/jxy/Tcarinfo/CVR_IDCardCollect.html"
							align="center" frameBorder="0" marginHeight="0" marginWidth="0"></IFRAME>
						 <% } else if(sfzhcardtype != null && sfzhcardtype.equals("2")) { %>	
						  <IFRAME height="170" width="200" name="ifranmename" src="../IDcardnew.htm"
							align="center" frameBorder="0" marginHeight="0" marginWidth="0"></IFRAME>
							 <% } else if(sfzhcardtype != null && sfzhcardtype.equals("3")) { %>	
						  <IFRAME height="170" width="200" name="resultifranme" src="../CVR_IDCardnew.html"
							align="center" frameBorder="0" marginHeight="0" marginWidth="0"></IFRAME>
							<%} %>	
					</td>
					<td width ="25%" rowspan="8"  align="center" id="imgidtd" bgcolor="#EDF1FF" style="display:none;">
						<img id="imgid" width="120px" height="100px"  src='${ctx}/images/spacer.gif' alt="" border="0" name="photo">
					</td>
				</tr>
				<tr class="crosscolor_tr">
					<td class="crosscolor_td">
						<%=Tcarreturn.ALIAS_DELITELEPHONE%>
					</td>
					<td colspan="3">
					<s:property value="%{model.delitelephone}" />
	                <s:hidden label="%{@vs@ALIAS_TAKEOFFNAME}" id="delitelephone" key="delitelephone" value="%{model.delitelephone}"  required="false" />
					</td>

				</tr>

                 <tr class="crosscolor_tr">
               
		                 <td class="crosscolor_td">
			           		<%=Tcarreturn.ALIAS_DELIADDRESS%>
		                  </td>
			              <td colspan="3">
		                           <s:property  value="%{model.deliaddress}" />
		                  </td>
                  </tr>
                  
				<tr class="crosscolor_tr">
					<td class="crosscolor_td">
						<%=Tcarreturn.ALIAS_RECENAME%>
					</td>
				<td id="rece" >

		            </td>
					<td class="crosscolor_td">
						<%=Tcarreturn.ALIAS_RECETIME%>
					</td>
					<td>
					<s:property value="%{model.recetime}"/>
					<s:hidden id="recetime" name="recetime" value="%{model.recetime}" />

				</tr>
				<tr class="crosscolor_tr">
				         <td class="crosscolor_td">
			                      <FONT color="red">*</FONT><%=Tcarreturn.ALIAS_TAKEOFFNAME%><br><font color="red">同送车人</font><input style="float: none;margin-left: 0;" id="colCar" type="checkbox" name="checkbox" value="checkbox1" onClick="checkbox2() "/>
		                  </td>
			              <td>
		                           <s:textfield label="%{@vs@ALIAS_TAKEOFFNAME}" id="takeoffname" key="takeoffname" value="%{model.takeoffname}"  cssClass="required max-length-30 validate-chinese" required="false" />
		                  </td>
		                   <td class="crosscolor_td">
<!--			                      <%=Tcarreturn.ALIAS_TOCREDCODE%>--><FONT color="red">*</FONT>取车人证件号码
		                  </td>
			              <td >
		                           <s:textfield label="%{@vs@ALIAS_TOCREDCODE}" id="tocredcode" key="tocredcode" value="%{model.tocredcode}"  cssClass="required max-length-18" required="false" />
		                  </td>
		         </tr>
		         <tr class="crosscolor_tr">
					<td class="crosscolor_td">
						<FONT color="red">*</FONT>取车人电话
					</td>
					<td >
						 <s:textfield  key="tomobile" value="%{model.tomobile}" id="tomobile"  cssClass="required max-length-30" required="false" />
						 
					</td>
					<td class="crosscolor_td">
						<%=Tcarreturn.ALIAS_TOTIME%>
					</td>
					<td >
						<input value="${model.totime}" class="Wdate" size="20"
						onkeyup="DateFormat(this);" Checked="true"	onclick="WdatePicker({startDate:'2010-01-01 00:00',dateFmt:'yyyy-MM-dd HH:mm',minDate:'%y-%M-%d',isShowClear:false})"
							id="totime" name="totime"  />
					</td>

				</tr>
				<tr class="crosscolor_tr">
					<td class="crosscolor_td">
						<%=Tcarreturn.ALIAS_SERVERITEM%>
					</td>
					<td colspan="3">
<!--						<div id="addrinfo"> <input name="input" id="test" value="选择" type="button" onclick="zzjs_net('popupAddr')" /></div>-->
						<span id="showserveritem"><%=serveritemName%> 
<!--						</span><div id="result"></div>-->
					</td>
					

				</tr>
				<tr class="crosscolor_tr">
					<td class="crosscolor_td">
						<%=Tcarreturn.ALIAS_DEMO%>
					</td>
					<td colspan="3" align="left" >
						<s:textarea style="margin-left: 10px" label="%{@vs@ALIAS_DEMO}" key="demo" 
							value="%{model.demo}" rows="6" cols="50"
							cssClass="max-length-300" required="false" />
					</td>
				</tr>
				<tr>
					<td colspan="5" class="tb_bottom">
						<input id="submitButton" name="submitButton" type="submit"
							value="提交" />
						<input type="button" value="返回"
							onclick="window.location='${ctx}/jxy/Tcarinfo/list.do?<mytag:params includes="ec*,s*" type="queryStringUtf"/>'" />
					</td>
				</tr>
			</table>
		</s:form>

		<script>
	new Validation(document.forms[0],{onSubmit:true,onFormValidate : function(result,form) {
		var finalResult = result;
		
		//在这里添加自定义验证
		
		return disableSubmit(finalResult,'submitButton');
	}});
	function uploadEmpPhoto(enrolid) {
        var frm = document.forms("form1");
		var returnvalue = window.showModalDialog("${ctx}/jxy/Tcarinfo/uploadPhoto.jsp?enrolid="+enrolid,"childWIn","dialogHeight:150px;dialogWidth:400px;scroll:off;center:yes");
		if (returnvalue == "yes"){
		    changesrc();
	      }      
	}
	 function clxxDevice(){ //用于框架调用
	 	document.getElementById("clxxDevice").style.display ="none";
	 	document.getElementById("imgidtd").style.display ="";
	 }
	 
	 
	function checkbox2(){
		 if(document.getElementById("checkbox").checked){
			 $("#takeoffname").val($("#deliname").val()); 
			 $("#tocredcode").val($("#delicredcode").val()); 
			 $("#tomobile").val($("#delitelephone").val()); 
		 }else{
			 $("#takeoffname").val("");
			 $("#tocredcode").val(""); 
			 $("#tomobile").val(""); 
		 }
	}
	
	
	rnd.today=new Date();  
    rnd.seed=rnd.today.getTime(); 
    
    function rnd() {  
	　　　  rnd.seed = (rnd.seed*9301+49297) % 233280;  
	　　　　return rnd.seed/(233280.0);  
    };  
    function rand(number) {  
　　　　	return Math.ceil(rnd()*number);  
    };  
    
	function changesrc(){
	    var pic=document.getElementById('photo');
	    pic.src='${ctx}/jxy/Tcarinfo/showPic.do?enrolid=<s:property value="%{model.enrolid}" />&rand='+rand(1000);
   }  
   getPcs();
	function getPcs(){
	var recename='${model.recename}';
	var url="${ctx}/jxy/Dictitem/getEmployeeList.do?ajax=true&show=true&recename="+recename;
	$.post(url, function(data) {
		$("#rece").html(data);
	});
	}
</script>
<script type="text/javascript">


//弹出层
function zzjs_net()
{
 //创建一个div元素
 var popupDiv = document.createElement("div");
 //给这个元素设置属性与样式
 popupDiv.setAttribute("id","popupAddr")
 popupDiv.style.border = "1px solid #ccc";
 popupDiv.style.width = "600px";
 popupDiv.style.height = "400px";
 popupDiv.style.background = "#fff";
 popupDiv.style.zIndex = 99;
 popupDiv.style.position = "absolute";
 //让弹出层在页面中垂直左右居中
 var arrayPageSize = getPageSize();
 var arrayPageScroll = getPageScroll();
 //alert(arrayPageScroll);
 //alert(arrayPageSize);
 popupDiv.style.top = (arrayPageScroll[1] + ((arrayPageSize[3] - 35 - 400) / 2) + 'px') ;
 popupDiv.style.left = (((arrayPageSize[0] - 20 - 600) / 2) + 'px');
 //alert( popupDiv.style.top);
 //创建背景层
 var bodyBack = document.createElement("div");
 bodyBack.setAttribute("id","bodybg")
 //alert(arrayPageSize[0]);
 bodyBack.style.width = (arrayPageSize[0] + 10 + 'px');
 bodyBack.style.height = (arrayPageSize[1] + 435 + 'px');
 bodyBack.style.zIndex = 98;
 bodyBack.style.position = "absolute";
 bodyBack.style.top = 0;
 bodyBack.style.left = 0;
 bodyBack.style.filter = "alpha(opacity=20)";
 bodyBack.style.opacity = 0.2;
 bodyBack.style.background = "#000";
 //收工插入到目标元素之后
 var mybody = document.getElementById("test");
 insertAfter(popupDiv,mybody);
 insertAfter(bodyBack,mybody);
 //弹出层内容
 popupDiv.innerHTML = addrHTML();
 init_check();
 init_check_event();
}
//元素插入另一个元素之后
function insertAfter(newElement, targetElement)
{
    var parent = targetElement.parentNode;
    if(parent.lastChild == targetElement)
    {
        parent.appendChild(newElement);
    }
    else
    {
        parent.insertBefore(newElement, targetElement.nextSibling);
    }
}
//获取滚动条的高度
function getPageScroll(){
 var yScroll;
 if (self.pageYOffset) {
  yScroll = self.pageYOffset;
 } else if (document.documentElement && document.documentElement.scrollTop){  // Explorer 6 Strict
  yScroll = document.documentElement.scrollTop;
 } else if (document.body) {// all other Explorers
  yScroll = document.body.scrollTop;
 }
 arrayPageScroll = new Array('',yScroll)
 return arrayPageScroll;
}
//获取页面实际大小
function getPageSize(){
    var xScroll, yScroll;
    if (window.innerHeight && window.scrollMaxY) {
        xScroll = document.body.scrollWidth;
        yScroll = window.innerHeight + window.scrollMaxY;
    } else if (document.body.scrollHeight > document.body.offsetHeight){ // all but Explorer Mac
        xScroll = document.body.scrollWidth;
        yScroll = document.body.scrollHeight;
    } else { // Explorer Mac...would also work in Explorer 6 Strict, Mozilla and Safari
        xScroll = document.body.offsetWidth;
        yScroll = document.body.offsetHeight;
    }
    var windowWidth, windowHeight;
    if (self.innerHeight) {    // all except Explorer
        windowWidth = self.innerWidth;
        windowHeight = self.innerHeight;
    } else if (document.documentElement && document.documentElement.clientHeight) { // Explorer 6 Strict Mode
        windowWidth = document.documentElement.clientWidth;
        windowHeight = document.documentElement.clientHeight;
    } else if (document.body) { // other Explorers
        windowWidth = document.body.clientWidth;
        windowHeight = document.body.clientHeight;
    }
    // for small pages with total height less then height of the viewport
    if(yScroll < windowHeight){
        pageHeight = windowHeight;
    } else {
        pageHeight = yScroll;
    }
    // for small pages with total width less then width of the viewport
    if(xScroll < windowWidth){
        pageWidth = windowWidth;
    } else {
        pageWidth = xScroll;
    }
    arrayPageSize = new Array(pageWidth,pageHeight,windowWidth,windowHeight)
    return arrayPageSize;
}
//关闭弹出层
function closeLayer(obj)
{
 obj.style.display = "none";
 document.getElementById("bodybg").style.display = "none";
 return false;
}
//拖动函数
function mousedown(e)
{
 var obj = document.getElementById("popupAddr");
 var e = window.event ? window.event : e;
 obj.startX = e.clientX - obj.offsetLeft;
 obj.startY = e.clientY - obj.offsetTop;
 document.onmousemove = mousemove;
 var temp = document.attachEvent ? document.attachEvent("onmouseup",mouseup) : document.addEventListener("mouseup",mouseup,"");
}
function mousemove(e)
{
 var obj = document.getElementById("popupAddr");
 var e = window.event ? window.event : e;
 with(obj.style)
 {
  left = e.clientX - obj.startX + "px";
  top = e.clientY - obj.startY + "px";
 }
}
function mouseup(e)
{
 document.onmousemove = "";
 var temp = document.detachEvent ? document.detachEvent("onmouseup",mouseup) : document.addEventListener("mouseup",mouseup,"");
}
//END拖动函数
//弹出层内容
function addrHTML() {
 //文字
 var TITLE = "请选择服务项目，你最多能选择10项";
 var CLOSE = '<span style="cursor:pointer;" onclick="javascript:closeLayer(this.parentNode.parentNode.parentNode.parentNode);write_result();">[确定]</span>';
 //图片地址
 var TITLEBG = "${ctx}/images/system/51job_title_bg.gif";
 var ICN = "${ctx}/images/system/51job_ico.gif";
 var htmlDiv = '';
 htmlDiv += '<div style="width:100%;font-size:12px;">';
 //头部
 htmlDiv += '<div style="background:url('+TITLEBG+') repeat-x;height:40px;color:#fff;cursor:move;" onmousedown="mousedown(arguments[0])">';
 htmlDiv += '<span style="line-height:30px;padding-left:22px;float:left;background:url('+ ICN +') no-repeat 6px 8px;">';
 htmlDiv += TITLE;
 htmlDiv += '</span>';
 htmlDiv += '<span style="float:right;padding-right:12px;line-height:30px;">';
 htmlDiv += CLOSE;
 htmlDiv += '</span>';
 htmlDiv += '</div>';
 //END头部
 //内容部分
 htmlDiv += '<div id="container" style="width:600px;height:400px;"></div>';
 htmlDiv += '<div id="float_lay"></div>';
 //END内容部分
 htmlDiv += '</div>';
 return htmlDiv;
}
//工作地点键值匹配数组
<%=request.getAttribute("data")%>
<%=request.getAttribute("dataTwo")%>
//主要城市数据字典
var maincity=[['服务',['0200','0300','0400','0500']]];
//所有省份数据字典
var allprov=[['维修',['0100','0110','0120','0130','0140','0150']],['喷漆',['0600']],['其它',['3300','3400','3500','3600']]];
var isIE = /msie/.test(navigator.userAgent.toLowerCase());
var containerID = "container";
var floatID = "float_lay";
function init_check(){
 _container = document.getElementById(containerID);
 _float = document.getElementById(floatID);
 _float.onmouseover = function(){this.style.display = 'block';}
 _float.onmouseout = function(){this.style.display = 'none';}
 //三个区域的创建
 _selectCity = document.createElement("div");
 if(document.getElementById("result").getElementsByTagName("input").length == 0){
  var s_h3 = document.createElement("h3"); s_h3.innerHTML = "";
  _selectCity.appendChild(s_h3);
 }else{
  _selectCity.innerHTML = document.getElementById("result").innerHTML;
  var _input_s = _selectCity.getElementsByTagName("input");
  for (var i = 0 ; i < _input_s.length; i++){
   _input_s[i].checked = true;
   _input_s[i].onclick = function(){
    var _input_m = _mainCity.getElementsByTagName("input");
    var _input_a = _allProvince.getElementsByTagName("input");
    for (var i=0; i<_input_a.length; i++)
     _input_m[_input_m.length+i] = _input_a[i];
    for(var j=0; j<_input_m.length+_input_a.length; j++)
     if(_input_m[j].value == this.value)
      _input_m[j].checked = false;
    _selectCity.removeChild(this.parentNode);
   }
  }
 }
 _mainCity = document.createElement("div");
 var m_h3 = document.createElement("h3"); m_h3.innerHTML = "";
 _mainCity.appendChild(m_h3);
 _allProvince = document.createElement("div");
 var a_h3 = document.createElement("h3"); a_h3.innerHTML = "";
 _allProvince.appendChild(a_h3);
 var div = [],h = [],input  = [],span = [];
 _selectCity.id = "select_city"; _mainCity.id = "main_city"; _allProvince.id = "all_province";
 _container.appendChild(_selectCity); _container.appendChild(_mainCity); _container.appendChild(_allProvince);
 //主要城市部分check的创建
 for (var i = 0 ; i < maincity.length ;i++){
  div[i] = document.createElement("div");
  _mainCity.appendChild(div[i]);
  h[i] = document.createElement("h4");
  div[i].appendChild(h[i]);
  h[i].innerHTML = maincity[i][0];
  for (var j=0 ; j < maincity[i][1].length ; j++){
	if(isIE) {
		input[j] = document.createElement("<input type='checkbox' value='"+maincity[i][1][j]+"' name='serveritemDiv'>")
    } else {
		input[j] = document.createElement("input");
        input[j].type = "checkbox";
		input[j].name = "serveritemDiv";
        input[j].value = maincity[i][1][j];
    }
   span[j] = document.createElement("span");
   div[i].appendChild(span[j]);
   span[j].appendChild(input[j]);
   span[j].appendChild(document.createTextNode(ja[maincity[i][1][j]]));
  }
 }
 //所有省份check的创建(不包括其他)
 for (var i=0 ; i < allprov.length - 1; i++){
  div[i] = document.createElement("div");
  _allProvince.appendChild(div[i]);
  h[i] = document.createElement("h4");
  div[i].appendChild(h[i]);
  h[i].innerHTML = allprov[i][0];
  for (var j=0 ; j < allprov[i][1].length ; j++){
   span[j] = document.createElement("span");
   span[j].id = allprov[i][1][j];
   span[j].innerHTML = ja[allprov[i][1][j]];
   div[i].appendChild(span[j]);
   span[j].onclick = function(evt){
    if(_float.style.display == 'none'){
     var e = evt || window.event;
     _float.style.left = e.clientX-document.getElementById("popupAddr").offsetLeft + "px";
     _float.style.top = e.clientY-document.getElementById("popupAddr").offsetTop + "px";
     _float.style.display = 'block';
     _float.className = this.id;
     //alert(this.id);
     createLay(this.id);
    }
   }
   span[j].onmouseover = function(){
    if(_float.className == this.id)
     _float.style.display = 'block';
   }
   span[j].onmouseout = function(){
    _float.style.display = 'none';
   }
  }
 }

 check_in_select();
}
//maincity中的checkbox的事件相应
function init_check_event(){
 var _input_m = _mainCity.getElementsByTagName("input");
 var _input_a = _allProvince.getElementsByTagName("input");
 for (var j=0; j<_input_a.length; j++)
  _input_m[_input_m.length+j] = _input_a[j];
 for(var i=0 ; i < _input_m.length+_input_a.length ; i++)
  _input_m[i].onclick = function(){
   if(this.checked && check_num(this)){
    var span = this.parentNode.cloneNode(true);
    _selectCity.appendChild(span);
    change_float_check(this.value);
    if(isIE) select_true();
    //已选中的checkbox的事件相应
    span.getElementsByTagName("input")[0].onclick = function(){
     for(var j=0; j<_input_m.length+_input_a.length; j++)
      if(_input_m[j].value == this.value)
       _input_m[j].checked = false;
     change_float_check(this.value);
     _selectCity.removeChild(this.parentNode);
    }
   } else {
    var _input_s = _selectCity.getElementsByTagName("input");
    for (var j=0; j < _input_s.length; j++){
     if(_input_s[j].value == this.value)
      _selectCity.removeChild(_input_s[j].parentNode);
    }
    change_float_check(this.value);
   }
  }
}
//为浮动层创建数据
function createLay(id){
 if(id.substr(0,1) != '0')
  var num = parseInt(id);
 else
  var num = parseInt(id.substr(1,4));
  
  //alert(id);
  //alert(num);
 var n;
 var span = [],input = [];
 _float.innerHTML = "";

  if(isIE) {
		 input[num] = document.createElement("<input type='checkbox' value='"+ id+"' name='serveritemDiv'>")
   } else {
		 input[num] = document.createElement("input");
         input[num].type = "checkbox";
         input[num].name = "serveritemDiv";
         input[num].value = id;
    }
 span[num] = document.createElement("span");
 span[num].appendChild(input[num]);
 span[num].appendChild(document.createTextNode(ja[id]));
 _float.appendChild(span[num]);
 _float.appendChild(document.createElement("br"));
 
 for (var i=0;i<menus.length;i++) {
            if(num > 950)
                n = i.toString();
            else
                n = '0' + i.toString();
			var arr=menus[i];
			if (arr[2]==id) {
			     if(isIE) {
					  input[n] = document.createElement("<input type='checkbox' value='"+ arr[0]+"' name='serveritemDiv'>")
			     } else {
					  input[n] = document.createElement("input");
			          input[n].type = "checkbox";
			          input[n].name = "serveritemDiv";
			          input[n].value = n;
			     }
			   span[n] = document.createElement("span");
			   span[n].appendChild(input[n]);
			   span[n].appendChild(document.createTextNode(arr[1]));
			   _float.appendChild(span[n]);
				
			}			
}
 
 
 

 check_in_select();
 init_lay_event();
}//欢迎来到站长特效网，我们的网址是www.zzjs.net，很好记，zz站长，js 就是js特效，本站收集大量高质量js代码，还有许多广告代码下载。
function init_lay_event(){
 var _input_l = _float.getElementsByTagName("input");
 for (var i = 0 ; i < _input_l.length ; i++){
  _input_l[i].id = i;
  _input_l[i].onclick = function(){
   if(this.checked && check_num(this)){
    if(this.id == 0){
     var _input_s = _selectCity.getElementsByTagName("input");
     for (var j = 0 ; j < _input_s.length; j++){
      if(_input_s[j].value.indexOf(this.value.substr(0,2)) != -1){
       change_maincity_check(_input_s[j].value);
       change_float_check(_input_s[j].value);
       _selectCity.removeChild(_input_s[j].parentNode);
       j--;
      }
     }
    }
    else{
     if(_input_l[0].checked){
      var _input_t = _selectCity.getElementsByTagName("input");
      //alert(_input_t.length);
      for (var k = 0 ; k < _input_t.length; k++){
       if(_input_t[k].value == _input_l[0].value)
        _selectCity.removeChild(_input_t[k].parentNode);
       //alert(_input_t[k].value);
      }
      _input_l[0].checked = false;
     }
    }
    var span = this.parentNode.cloneNode(true);
    _selectCity.appendChild(span);
    if(isIE) select_true();
    change_maincity_check(this.value);
    //float层中已选中的checkbox的事件相应
    span.getElementsByTagName("input")[0].onclick = function(){
     for(var j=0; j<_input_l.length; j++)
      if(_input_l[j].value == this.value)
       _input_l[j].checked = false;
     change_maincity_check(this.value);
     _selectCity.removeChild(this.parentNode);
    }
   } else {
    var _input_s = _selectCity.getElementsByTagName("input");
    for (var j=0; j < _input_s.length; j++){
     if(_input_s[j].value == this.value)
      _selectCity.removeChild(_input_s[j].parentNode);
    }
    change_maincity_check(this.value);
   }
  }
 }
}
function check_num(obj){
 var _input_s = _selectCity.getElementsByTagName("input");
 if(_input_s.length < 10) return true;
 else{
  obj.checked = false;
  alert("最多只能选择10个选项");
  return false;
 }
}//欢迎来到站长特效网，我们的网址是 www.zzjs.net，很好记，zz站长，js就是js特效，本站收集大量高质量js代码，还有许多广告代码下载。
function change_maincity_check(value){
 var _input_m = _mainCity.getElementsByTagName("input");
 for (var i = 0 ; i < _input_m.length; i++){
  if(_input_m[i].value == value)
   if(!_input_m[i].checked)
    _input_m[i].checked = true;
   else
    _input_m[i].checked = false;
 }
}
function change_float_check(value){
 var _input_f = _float.getElementsByTagName("input");
 for (var i = 0 ; i < _input_f.length; i++){
  if(_input_f[i].value == value)
   if(!_input_f[i].checked)
    _input_f[i].checked = true;
   else
    _input_f[i].checked = false;
 }
}//欢迎来到站长特效网，我们的网 址是www.zzjs.net，很好记，zz站长，js就是js特效，本站收集大量高质量js代码，还有许多广告代码下载。
function check_in_select(value){
 var _input_s = _selectCity.getElementsByTagName("input");
 var _input_f = _float.getElementsByTagName("input");
 var _input_m = _mainCity.getElementsByTagName("input");
 var _input_a = _allProvince.getElementsByTagName("input");
 for (var i = 0 ; i < _input_s.length ; i++){
  for (var j=0 ; j < _input_f.length ; j++){
   if(_input_f[j].value == _input_s[i].value)
    _input_f[j].checked = true;
  }
  for (var k=0 ; k < _input_m.length ; k++){
   if(_input_m[k].value == _input_s[i].value)
    _input_m[k].checked = true;
  }
  for (var l=0 ; l < _input_a.length ; l++){
   if(_input_a[l].value == _input_s[i].value)
    _input_a[l].checked = true;
  }
 }
}
function select_true(){
 var _input_s = _selectCity.getElementsByTagName("input");
 for (var i = 0 ; i < _input_s.length; i++)
  _input_s[i].checked = true;
}//欢迎来到站长 特效网，我们的网址是www.zzjs.net，很好记，zz站长，js就是js特效，本站收集大量高质量js代码，还有许多广告代码下载。
function write_result(){
 var _result = document.getElementById("result");
 _result.innerHTML = _selectCity.innerHTML;
 var _result_input = _result.getElementsByTagName("input");
 for (var i = 0 ; i < _result_input.length; i++){
  _result_input[i].checked = true;
  _result_input[i].onclick = function(){
   _result.removeChild(this.parentNode);
  }
 
 }
 var returnValueStr = "";
 for(i=0;i<_result_input.length;i++){
 	if(_result_input[i].checked){
 	    if(i != _result_input.length -1)
    	    returnValueStr = returnValueStr+ _result_input[i].value+";";    
    	 else       
    	    returnValueStr = returnValueStr+ _result_input[i].value;        
    }
 }
    document.getElementById("showserveritem").innerHTML ="";
	document.getElementById("serveritem").value=returnValueStr;	  

}
//document.getElementById("result").innerHTML=htmlcheckbox;
</script>
	</body>

</html>
