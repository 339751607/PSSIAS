<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ include file="/commons/taglibs.jsp"%>
<%@page import="com.dyneinfo.jxy.model.*"%>
<%@ page import="net.java.dev.common.dict.taglib.DictHelpImpl"%>
<%
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ request.getContextPath() + "/";
	String sfzhcardtype = "1";

	String deploycity = (String) DictHelpImpl.getInitData("deploycity");
	String mjjc = (String) DictHelpImpl.getInitData("mjjc");
	request.setAttribute("city", deploycity);
	String typecode = (String) request.getAttribute("typecode");
	String smycode = (String) request.getAttribute("smycode");

	int inCol = 0;
	if (deploycity.equals("ZhanJiang"))
		inCol = 3;
	else
		inCol = 1;
		String webContext = request.getContextPath();
	//System.out.println(request.getAttribute("city"));
%>
<html>
<script src="<%=webContext%>/extclient/serviceItems.js"></script>
	<head>
		<%@ include file="/commons/meta.jsp"%>
		<base href="<%=basePath%>">
		<title><%=Tcarinfo.TABLE_ALIAS%>录入</title>
<style type="text/css">
.crosscolor_td{width: 15%}
#carid1{width:30%}
#cartype{width:153}
		.crosscolor_tr input {
			float: left;
			margin: 0 0 0 0px;
			height: 20px;	
</style>
	</head>
	<body onload="quickSelectInit()" id="bd" >
		<%@ include file="/commons/messages.jsp"%>

		<s:form action="/jxy/Tcarinfo/save.do" theme="simple"
			name="inputForm" enctype="multipart/form-data" method="post">
			<table cellpadding="0" cellspacing="0" border="0" class="tb_all">
				<input type="hidden" name="typecode" value="<%=typecode%>" />
				<input type="hidden" name="smycode" value="<%=smycode%>" />
				<input type="hidden" name="returnUrl"
					value="!/jxy/Tcarinfo/list.do?<mytag:params includes="ec*,s*" type="queryStringUtf"/>" />
				<input type="hidden"  id="serveritem" name="serveritem" value="" />
				<tr>
					<td colspan="5" class="tb_title">
						<%=Tcarinfo.TABLE_ALIAS%>录入
					</td>
				</tr>
				<s:hidden id="enrolid" name="enrolid" />
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
						<FONT color="red">*</FONT><%=Tcarinfo.ALIAS_CAROWNER%>
					</td>
					<td>
						<s:textfield label="%{@vs@ALIAS_CAROWNER}" key="carowner"
							id="carowner" value="%{model.carowner}"
							cssClass="required max-length-40 validate-chinese"
							required="false" />
						
					</td>
					<td class="crosscolor_td">
						<FONT color="red">*</FONT><%=Tcarinfo.ALIAS_CARID%>
					</td>
					<td>
						<mytag:select property="%{model.carid1}"
							styleClass="required validate-selection"
							onchange="document.getElementById('carid').focus()" name="carid1"
							notEmpty="false" dictName="cpht" />
						<!--	                          <s:textfield label="%{@vs@ALIAS_CARID}" key="carid" value="%{model.carid}" id="KProvince" onkeyup="beKeyUp()" onblur="javascript:getOldInfo(document.getElementById('carid1').value+this.value);"  cssClass="required validate-cph" required="false" /><FONT color="red">*</FONT>-->
						<s:textfield label="%{@vs@ALIAS_CARID}" key="carid"
							value="%{model.carid}" id="KProvince" onkeyup="beKeyUp()"
							onblur="javascript:getOldInfo(document.getElementById('carid1').value+this.value);"
							cssClass="required validate-cph" required="false" size="7"/>
						
					</td>
					<div id="search_suggest"
						style="position: absolute; z-index: 1; margin-top: 4px; padding-top: 20px;"></div>
						<td rowspan="5"  align="center">
									<div id="divPreview">
								      <img id="imgHeadPhoto" src="${ctx}/images/noCar.gif" style="width: 200; height: 100; border: solid 1px #d2e2e2;" alt="" />
									</div>
					</td>

				</tr>
				<tr class="crosscolor_tr">
					<td class="crosscolor_td">
						<FONT color="red">*</FONT><%=Tcarinfo.ALIAS_CARTYPE%>
					</td>
					<td>
						<mytag:select property="%{model.cartype}"
							styleClass="required validate-selection" name="cartype"
							notEmpty="false" dictName="cllx" />
						
					</td>
					<td class="crosscolor_td">
						<%=Tcarinfo.ALIAS_BRAND%>
					</td>
					<td>
						<s:textfield label="%{@vs@ALIAS_BRAND}" key="brand"
							value="%{model.brand}" cssClass="max-length-30" required="false" />
					</td>

				</tr>
				<tr class="crosscolor_tr">
					<td class="crosscolor_td">
						<FONT color="red" >*</FONT><%=Tcarinfo.ALIAS_ENGINECODE%>
					</td>
					<td>

						<s:textfield label="%{@vs@ALIAS_ENGINECODE}" key="enginecode"
							title="只能输入 大写字母 、数字、中杠（-）、点（.）"
							onkeyup="value=value.replace(/[^ A-Z0-9.-]/g,'') "
							onbeforepaste="clipboardData.setData('text',clipboardData.getData('text').replace(/[^ A-Z0-9.-]/g,''))"
							onkeydown="if(event.keyCode==13)event.keyCode=9"
							value="%{model.enginecode}" cssClass="required max-length-30"
							required="false">
						</s:textfield>
						
					</td>

					<td class="crosscolor_td">
						<%=Tcarinfo.ALIAS_CLSBCODE%>
					</td>
					<td>
						<s:textfield label="%{@vs@ALIAS_BODYCODE}" key="clsbcode"
							title="只能输入 大写字母 、数字、中杠（-）、点（.）"
							onkeyup="value=value.replace(/[^ A-Z0-9.-]/g,'') "
							onbeforepaste="clipboardData.setData('text',clipboardData.getData('text').replace(/[^ A-Z0-9.-]/g,''))"
							onkeydown="if(event.keyCode==13)event.keyCode=9"
							value="%{model.clsbcode}" cssClass="max-length-30"
							required="false">
						</s:textfield>
					</td>

					<!--
		                  <c:if test="${city ne 'ZhanJiang'}">部署城市不是湛江 add by zzq 2012/06/12
			                 <td class="crosscolor_td">
				                      <%=Tcarinfo.ALIAS_BODYCODE%>
			                  </td>
				              <td>
			                           <s:textfield label="%{@vs@ALIAS_BODYCODE}" key="bodycode" value="%{model.bodycode}"  cssClass="required max-length-30" required="false" /><FONT color="red">*</FONT>
			                  </td>
		                  </c:if>
		                  -->
				</tr>

				<tr class="crosscolor_tr">

					<td class="crosscolor_td">
						 <%=Tcarinfo.ALIAS_COLOR%>
					</td>
					<td colspan="3" class="crosscolor_td" align="left">
					<table class="list">
					<tr>
					<td>
						<mytag:select property="%{model.color1}"
							styleClass="required validate-selection" name="color1"
							notEmpty="false" dictName="csys" />
					</td>
					<td>
						<FONT color="red">*</FONT>
					</td>
					<td style="padding-left: 5px">
						&nbsp;&nbsp;&nbsp;第一辅色:
					</td>
					<td>
						<mytag:select property="%{model.color2}"
							styleClass="validate-selection" name="color2" notEmpty="false"
							dictName="csys" />
					</td>
					<td style="padding-left: 5px">
						&nbsp;&nbsp;第二辅色: 
					</td>
					<td>
						<mytag:select property="%{model.color3}"
							styleClass="validate-selection" name="color3" notEmpty="false"
							dictName="csys" />
					</td>
					</tr>
					</table>
					</td>

				</tr>

				<tr class="crosscolor_tr">
					<td class="crosscolor_td">
						<%=Tcarinfo.ALIAS_CARPICTURE%>
					</td>
					<td colspan="3">
						<s:file name="file" style="WIDTH:300px;cursor:hand"
							UNSELECTABLE="on" id="file"
							cssClass="validate-file-png-jpg-gif-bmp"   onchange="PreviewImage(this,'imgHeadPhoto','divPreview')" label="图片"
							></s:file>
					</td>
				</tr>
				<tr>
				<tr class="crosscolor_tr">
					<td colspan="4" class="crosscolor_d">
						<b>车辆交接信息</b>
					</td>
					<td	width="25%" align="center"> 
					<b>送车人照片</b>
					</td>
				</tr>
				<tr class="crosscolor_tr">
					<td class="crosscolor_td">
						<FONT color="red">*</FONT><%=Tcarreturn.ALIAS_DELINAME%>
					</td>
					<td>
						<s:textfield label="%{@vs@ALIAS_DELINAME}" key="deliname"
							id="deliname" value="%{model.deliname}"
							cssClass="required max-length-30 validate-chinese"
							required="false" />
						
					</td>
					<td class="crosscolor_td">
						<!--						<%=Tcarreturn.ALIAS_DELICREDCODE%>-->
						<FONT color="red">*</FONT>送车人证件号
					</td>
					<td>
						<s:textfield label="%{@vs@ALIAS_DELICREDCODE}" key="delicredcode"
							value="%{model.delicredcode}" cssClass="required"
							required="false" />
						
					</td>
					
					<td width="25%" rowspan="6" id="clxxDevice" bgcolor="#EDF1FF">
						<%
							if (typecode.equals("1") && smycode.equals("1")) {
						%>
						<IFRAME height="170" width="200" name="ifranmename"
							src="${ctx}/pages/jxy/Tcarinfo/IDcard.htm" align="center"
							frameBorder="0" marginHeight="0" marginWidth="0"></IFRAME>
						<IFRAME height="170" width="200" name="ifranmename"
							src="${ctx}/pages/jxy/Tcarinfo/CVR_IDCard.html" align="center"
							frameBorder="0" marginHeight="0" marginWidth="0"></IFRAME>
						<%
					   	}
					   	if (!smycode.equals("1") && typecode.equals("1")) {
					   %>
						<IFRAME height="170" width="200" name="ifranmename"
							src="${ctx}/pages/jxy/Tcarinfo/IDcard.htm" align="center"
							frameBorder="0" marginHeight="0" marginWidth="0"></IFRAME>
						<%
					    	} else if (!typecode.equals("1") && smycode.equals("1")) {
					    %>
						<IFRAME height="170" width="200" name="ifranmename"
							src="${ctx}/pages/jxy/Tcarinfo/CVR_IDCard.html" align="center"
							frameBorder="0" marginHeight="0" marginWidth="0"></IFRAME>
						<%
						 	} else if (sfzhcardtype != null && sfzhcardtype.equals("2")) {
						 %>
						<IFRAME height="170" width="200" name="ifranmename"
							src="../IDcardnew.htm" align="center" frameBorder="0"
							marginHeight="0" marginWidth="0"></IFRAME>
						<%
							 	} else if (sfzhcardtype != null && sfzhcardtype.equals("3")) {
							 %>
						<IFRAME height="170" width="200" name="resultifranme"
							src="../CVR_IDCardnew.html" align="center" frameBorder="0"
							marginHeight="0" marginWidth="0"></IFRAME>
						<%
								}
							%>
					</td>
					<td width ="25%" rowspan="6"  align="center" id="imgidtd" bgcolor="#EDF1FF" style="display:none;">
						<img id="imgid" width="120px" height="100px" src='${ctx}/images/spacer.gif'"  alt=""  border="0" name="photo">
					</td>
				</tr>
				<tr class="crosscolor_tr">
					<td class="crosscolor_td">
						<FONT color="red">*</FONT><%=Tcarreturn.ALIAS_DELITELEPHONE%>
					</td>
					<td colspan="3">
						<s:textfield 
							title="固话区号和号码用'-'隔开"
							label="%{@vs@ALIAS_DELITELEPHONE}"
							key="delitelephone" value="%{model.delitelephone}"
							cssClass="required max-length-18 validate-mobile-or-phone"
							required="false" />
							
					</td>

				</tr>

				<tr class="crosscolor_tr">

					<td class="crosscolor_td">
						<%=Tcarreturn.ALIAS_DELIADDRESS%>
					</td>
					<td colspan="3">
						<s:textfield size="55" label="%{@vs@ALIAS_DELIADDRESS}"
							key="deliaddress" value="%{model.deliaddress}"
							cssClass="max-length-80" required="false" />
					</td>
				</tr>

				<tr class="crosscolor_tr">
					<td class="crosscolor_td">
						<FONT color="red">*</FONT><%=Tcarreturn.ALIAS_RECENAME%>
					</td>
					<td id="rece">
						<select name="recename" id="recename"
							Class="required max-length-30">
							<option value="">
								请选择...
							</option>
						</select>
						
					</td>

					<td class="crosscolor_td">
						<%=Tcarreturn.ALIAS_RECETIME%>
					</td>
					<td>
						<input class="Wdate" size="20" onkeyup="DateFormat(this);"
							onclick="WdatePicker({startDate:'2010-01-01 00:00',dateFmt:'yyyy-MM-dd HH:mm',isShowClear:false})"
							id="recetime" name="recetime" value="${model.recetime}" />
					</td>
				</tr>

				<tr class="crosscolor_tr">
					<td class="crosscolor_td">
						<%=Tcarreturn.ALIAS_SERVERITEM%>
					</td>
					<td colspan="3">

						<div id="addrinfo">
							<input name="input" id="test" value="选择" type="button"
								onclick="zzjs_net('popupAddr')" />
						</div>
						<div id="result"></div>
					</td>
				</tr>
				<tr class="crosscolor_tr">
					<td class="crosscolor_td">
						<%=Tcarreturn.ALIAS_DEMO%>
					</td>
					<td colspan="3" align="left">
						<s:textarea style="margin-left:10px" label="%{@vs@ALIAS_DEMO}" key="demo"
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
		<s:form action="/jxy/Tcarinfo/ryedit.do" theme="simple"
			name="hiddenForm" method="post">
			<input type="hidden" id="hidden_enrolid" name="hidden_enrolid"
				value="" />
		</s:form>
		<script>
	new Validation(document.forms[0],{onSubmit:true,onFormValidate : function(result,form) {
		var finalResult = result;
		
		//在这里添加自定义验证
		//alert(document.getElementById("result").innerHTML);
		
		return disableSubmit(finalResult,'submitButton');
	}});
	
</script>
		<script language="javascript">
 getPcs();
 
function PreviewImage(fileObj,imgPreviewId,divPreviewId){
    var allowExtention=".jpg,.bmp,.gif,.png";//允许上传文件的后缀名document.getElementById("hfAllowPicSuffix").value;
    var extention=fileObj.value.substring(fileObj.value.lastIndexOf(".")+1).toLowerCase();            
    var browserVersion= window.navigator.userAgent.toUpperCase();
    if(allowExtention.indexOf(extention)>-1){ 
        if(fileObj.files){//HTML5实现预览，兼容chrome、火狐7+等
            if(window.FileReader){
                var reader = new FileReader(); 
                reader.onload = function(e){
                    document.getElementById(imgPreviewId).setAttribute("src",e.target.result);
                }  
                reader.readAsDataURL(fileObj.files[0]);
            }else if(browserVersion.indexOf("SAFARI")>-1){
                alert("不支持Safari6.0以下浏览器的图片预览!");
            }
        }else if (browserVersion.indexOf("MSIE")>-1){
            if(browserVersion.indexOf("MSIE 6")>-1){//ie6
                document.getElementById(imgPreviewId).setAttribute("src",fileObj.value);
            }else{//ie[7-9]
                fileObj.select();
                if(browserVersion.indexOf("MSIE 9")>-1)
                    fileObj.blur();//不加上document.selection.createRange().text在ie9会拒绝访问
                var newPreview =document.getElementById(divPreviewId+"New");
                if(newPreview==null){
                    newPreview =document.createElement("div");
                    newPreview.setAttribute("id",divPreviewId+"New");
                    newPreview.style.width = document.getElementById(imgPreviewId).width+"px";
                    newPreview.style.height = document.getElementById(imgPreviewId).height+"px";
                    newPreview.style.border="solid 1px #d2e2e2";
                }
                newPreview.style.filter="progid:DXImageTransform.Microsoft.AlphaImageLoader(sizingMethod='scale',src='" + document.selection.createRange().text + "')";                            
                var tempDivPreview=document.getElementById(divPreviewId);
                tempDivPreview.parentNode.insertBefore(newPreview,tempDivPreview);
                tempDivPreview.style.display="none";                    
            }
        }else if(browserVersion.indexOf("FIREFOX")>-1){//firefox
            var firefoxVersion= parseFloat(browserVersion.toLowerCase().match(/firefox\/([\d.]+)/)[1]);
            if(firefoxVersion<7){//firefox7以下版本
                document.getElementById(imgPreviewId).setAttribute("src",fileObj.files[0].getAsDataURL());
            }else{//firefox7.0+                    
                document.getElementById(imgPreviewId).setAttribute("src",window.URL.createObjectURL(fileObj.files[0]));
            }
        }else{
            document.getElementById(imgPreviewId).setAttribute("src",fileObj.value);
        }         
    }else{
        alert("仅支持"+allowExtention+"为后缀名的文件!");
        fileObj.value="";//清空选中文件
        if(browserVersion.indexOf("MSIE")>-1){                        
            fileObj.select();
            document.selection.clear();
        }                
        fileObj.outerHTML=fileObj.outerHTML;
    }
}

 
function getPcs(){
	//var recename='%{model.recename}';
	var  recename ='';
	var url="${ctx}/jxy/Dictitem/getEmployeeList.do?ajax=true&recename="+recename;
	$.post(url, function(data) {
		$("#rece").html("<select  name='recename'  id='recename' Class='required max-length-30'><option value=''>请选择...</option></select>");
		$("#recename").append(data);
	});
}
var ags=0;
function getOldInfo(carid){
var url="${ctx}/jxy/Tcarinfo/getOldInfo.do?ajax=true&carid="+encodeURI(encodeURI(carid));
$.post(url, function(data){    
	if(data!=null&&data!=""){
		if(data=="zt"){
			alert("你输入的车辆已经在！请重新输入。");
			document.getElementById("carid").value="";
			document.getElementById('carid').focus();
			return;
		}
		ags=1;
		var json = eval("(" + data + ")");
		document.getElementById("carowner").value=json.carowner;
		document.getElementById("cartype").value=json.cartype;
		document.getElementById("brand").value=json.brand;
		document.getElementById("enginecode").value=json.enginecode;
	//	document.getElementById("bodycode").value=json.bodycode;
		document.getElementById("color1").value=json.color1;
		document.getElementById("color2").value=json.color2;
		document.getElementById("color3").value=json.color3;
		
		document.getElementById("deliname").value=json.deliname;
		document.getElementById("delicredcode").value=json.delicredcode;
		document.getElementById("delitelephone").value=json.delitelephone;
		document.getElementById("deliaddress").value=json.deliaddress;
		document.getElementById("clsbcode").value=json.clsbcode ; 
	}else if(ags==1){
		document.getElementById("carowner").value="";
		document.getElementById("cartype").value="";
		document.getElementById("brand").value="";
		document.getElementById("enginecode").value="";
	//	document.getElementById("bodycode").value="";
		document.getElementById("color1").value="";
		document.getElementById("color2").value="";
		document.getElementById("color3").value="";
		document.getElementById("clsbcode").value=""; 
		
		document.getElementById("deliname").value="";
		document.getElementById("delicredcode").value="";
		document.getElementById("delitelephone").value="";
		document.getElementById("deliaddress").value="";
	}
}, 'json');
	
}
</script>

		<style>
.item_normal {
	BORDER-LEFT: #666 1px solid;
	BORDER-RIGHT: #666 1px solid;
	width: 150px;
	background-color: #ffffff;
	overflow: hidden;
}

.itemBg {
	BORDER-LEFT: #666 1px solid;
	BORDER-RIGHT: #666 1px solid;
	cursor: default;
	background-color: #ffffff;
	width: 150px;
}

.item_high {
	background-color: #326BC5;
	cursor: default;
	width: 150px;
	color: white;
}

.item_button {
	BORDER-LEFT: #666 1px solid;
	BORDER-RIGHT: #666 1px solid;
	BORDER-BOTTOM: #666 1px solid;
	text-align: right;
	background-color: #ffffff;
	width: 150px;
	cursor: hand;
}

.suggest_hidden {
	display: none;
}
</style>

		<script type="text/javascript">

$(document).ready(function(){
})

var array=new Array(); //定义一个全局变量数组，用来存放拆分字符串的值，后面具体介绍。
var zz=-1; //此为指针，后面用到
function xmlHttpInitializtions()
        {
            try 
            {
                xmlhttpRequest = new ActiveXObject("Msxml2.XMLHTTP");
            } 
            catch (e) 
            {
                try 
                {
                    xmlhttpRequest = new ActiveXObject("Microsoft.XMLHTTP");
                } 
                catch (e2) 
                {
                    xmlhttpRequest = false;
                }
            }
            if (!xmlhttpRequest && typeof XMLHttpRequest != 'undefined') 
            {
                xmlhttpRequest = new XMLHttpRequest();
            }
        }
   function beKeyUp()
        {
       
            var keyp = document.getElementById("KProvince").value;
            var jkey = document.getElementById("carid1").value;
            var key = jkey+keyp;
            if(key.length>0)//有值才POST，这里最好加个Trim()方法，但是JAVASCRIPT没有现成的方法，自己定义。
            {
                xmlHttpInitializtions();
                xmlhttpRequest.Open("POST","${ctx}/jxy/Tcarinfo/getDataByIdNum.do?key=" + encodeURI(encodeURI(key)),true);//POST
                xmlhttpRequest.onreadystatechange=stateChange;//返回状态调用方法stateChange
                xmlhttpRequest.Send();
            }
        }
        function stateChange()
        {
            if(xmlhttpRequest.readystate==4)
            {
                if(xmlhttpRequest.status==200)
                {
                    var responseStr=xmlhttpRequest.responseText;//获取返回值
                    if(responseStr.length>0)//返回值不为空才执行下面的代码
                    {
                        array=responseStr.split('|');//根据‘|’拆分，根据自己任意特殊字符，初始化数组
                        positionDiv();//调用方法，定位DIV显示，具体见方法解释
                        document.getElementById("search_suggest").style.display="block";
  						document.getElementById("search_suggest").innerHTML="";//每次清空DIV内容
                        for(var i=0;i<array.length;i++)
                        {
                            if(array[i]!="")//项值不为空，组合DIV，每个DIV有onmouseover、onmouseout、onclick对应事件
                            {
                                document.getElementById("search_suggest").innerHTML+="<div id='item" + i + "' class='itemBg' onmouseover='beMouseOver(" + i +")' onmouseout='beMouseOut(" + i + ")' onclick='beClick(" + i + ")'>" + array[i] + "</div>";
                            
                            }
                        }
    //最后一个DIV显示 关闭 效果 onclick方法
                        document.getElementById("search_suggest").innerHTML+="<div class='item_button' onclick='hiddenDiv();'><font color='#999999'>关闭</font></div>";
                        document.getElementById("search_suggest").style.display="inline";
                    }
                    else
                    {
                        document.getElementById("search_suggest").style.display="none";
                    }
                }
            }
        }
        //定位DIV显示
function positionDiv()
        {
              var DivRef= document.getElementById("search_suggest");
              DivRef.style.position = "absolute";
              var t=document.getElementById("KProvince");
              DivRef.style.top= getAbsolutePos(t).y;//相对文本框的TOP高度，方法见下面
              DivRef.style.left= getAbsolutePos(t).x ;//相对文本框的LEFT宽度
              DivRef.style.height=array.length * 20;//DIV的高度等于每行20个象素乘行数（也就是数组的长度，体现全局数组的作用，不然要传入数组长度的参数）
        }
//实现最后一个DIV 关闭 onclick方法
function hiddenDiv()
        {
            document.getElementById("search_suggest").style.display="none";
        }
//定位方法，不做解释
function getAbsolutePos(el)
        {
            var SL = 0, ST = 0;
            var is_div = /^div$/i.test(el.tagName);
            if (is_div && el.scrollLeft) SL = el.scrollLeft;
            if (is_div && el.scrollTop) ST = el.scrollTop;
            var r = { x: el.offsetLeft - SL, y: el.offsetTop - ST };
            if (el.offsetParent)
            {
                var tmp = this.getAbsolutePos(el.offsetParent);
                r.x += tmp.x;
                r.y += tmp.y;
            }
            return r;
        }

        //函数鼠标经过效果        
        function beMouseOverEFF(i)
        {
            if ((i>=0)&(i<=array.length-1))
            {
                document.getElementById("item" + i).className="item_high";
            }
        }

        //函数鼠标移开效果
        function beMouseOutEFF(i)
        {
            if ((i>=0)&(i<=array.length-1))
            {
                document.getElementById("item" + i).className="item_normal";
            }
        }

        //函数鼠标经过
        function beMouseOver(i)
        {
            document.getElementById("KProvince").focus();
            beMouseOutEFF(zz);
            zz=i;
            beMouseOverEFF(zz);
        }

        //函数鼠标移开
        function beMouseOut(i)
        {
            beMouseOutEFF(i);
        }
        //函数单击
        function beClick(i){
            document.getElementById("KProvince").value=array[i];
            document.getElementById("search_suggest").style.display="none";
            document.getElementById("KProvince").focus();
        }

 function clxxDevice(){ //用于框架调用
 	document.getElementById("clxxDevice").style.display ="none";
 	document.getElementById("imgidtd").style.display ="";
 }
   
//工作地点键值匹配数组
<%=request.getAttribute("data")%>
<%=request.getAttribute("dataTwo")%>

</script>
	</body>
</html>
