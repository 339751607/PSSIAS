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
// alert("apscrol="+arrayPageScroll[1]);
// alert("apsize="+arrayPageSize);
 popupDiv.style.top = (arrayPageScroll[1] + ((arrayPageSize[3] - 35 - 400) / 2)+10 + 'px') ;
 popupDiv.style.left = (((arrayPageSize[0] - 20 - 600) / 2) + 'px');
// alert( "pptop="+popupDiv.style.top);
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
 var TITLE = "请选择服务项目，您最多能选择10项";
 var CLOSE = '<span style="cursor:pointer;" onclick="javascript:closeLayer(this.parentNode.parentNode.parentNode.parentNode);write_result();">[确定]</span>';
 //图片地址
 var TITLEBG = "images/system/51job_title_bg.gif";
 var ICN = "images/system/51job_ico.gif";
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
 htmlDiv += '<div id="container" style="width:600px;"></div>';
 htmlDiv += '<div id="float_lay"></div>';
 //END内容部分
 htmlDiv += '</div>';
 return htmlDiv;
}

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
 var div = [],h = [],input  = [],span = [] ,p = [];
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
   p[j] = document.createElement("p");
   p[j].appendChild(document.createTextNode(ja[maincity[i][1][j]]));
   span[j].appendChild(p[j]);
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
     var arrayPageSize = getPageSize();
     var e = evt || window.event;
     if(arrayPageSize[2]-e.clientX >390){
    	 _float.style.left = e.clientX - document.getElementById("popupAddr").offsetLeft -10 + "px";
     }else{
    	 _float.style.left = e.clientX - document.getElementById("popupAddr").offsetLeft -390 + "px";
     }
    	 
     _float.style.top = e.clientY - document.getElementById("popupAddr").offsetTop - 10 + "px";
     _float.style.display = 'block';
     _float.className = this.id;
//     alert(this.id);
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
 var span = [],input = [],p = [];
 _float.innerHTML = "";

 var x1 = 0;
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
			     if(arr[0] ){
			    	 
			     }
			     
			   span[n] = document.createElement("span");
			   span[n].appendChild(input[n]);
			   
//			   var aLen=arr[1].toString().length;
			   var arrTemp=arr[1];
			
//			   if(aLen<8)
//			   {
//				  
//				   for(var ii=8;ii>aLen;ii--)
//				  {
//					arrTemp=arrTemp+'  ';
//					 
//				   }   
//			   }
			   p[n] = document.createElement("p");
			   p[n].appendChild(document.createTextNode(arrTemp));
			   span[n].appendChild(p[n]);
			   
			   _float.appendChild(span[n]);
			  
			   x1=x1+1;
			   if(!(x1%3)){
				   _float.appendChild(document.createElement("br"));
			   }
				
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
	document.getElementById("serveritem").value=returnValueStr;	  

}