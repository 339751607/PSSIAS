<%@ page contentType="text/html;charset=UTF-8"%>
<script src="<c:url value="/scripts/jquery.js"/>" type="text/javascript"></script>
<script language="javascript">     
             var j$ = jQuery.noConflict();     
    </script>
<%@ page import="net.java.dev.common.dict.taglib.DictHelpImpl"%>

<html>
	<head>
	</head>
	<body>
			
			    <select id="province" value="<%=(String)DictHelpImpl.getInitData("prcode")%>" onchange="getCity('province','city');setValue(this)" >
					<option value="">
						请选择...
					</option>
				</select>
				<select id="city"  onchange="getCounties('city','counties');setValue(this)" >
					<option value="">
						请选择...
					</option>
				</select> 
				<select id="counties" onchange="setValue(this)">
					<option value="">
						请选择...
					</option>
				</select>
			
			<input type="hidden"  name="s_nativeplace" id="xzqh" value="${xzqhCode}" />

	</body>
<script language="javascript">



var xzqh=document.getElementById("xzqh");
setXzqhSelect('province','city','counties','xzqh');

	//根据省
	function getProvince(p,c,n){
		var url= "${ctx}/pages/SelectXzqh/list.do?ajax=true&outId=province&inputid=";
		
		getXzqhDate(p,url);
	}
	//查询市
	function getCity(inputId,outinputid){
		var url= "${ctx}/pages/SelectXzqh/list.do?ajax=true&outId=city&inputid="+document.getElementById(inputId).value;
		j$("#counties").html("<option value=\"\">请选择...</option>");
		getXzqhDate(outinputid,url);
	}
	//查询区县
	function getCounties(inputId,outinputid){
		var url= "${ctx}/pages/SelectXzqh/list.do?ajax=true&outId=counties&inputid="+document.getElementById(inputId).value;;
		getXzqhDate(outinputid,url);
	}

	function getXzqhDate(outinputid,url){
		j$.post(url, function(data) {
			j$("#"+outinputid).html(data);
		});
	}

	 function setXzqhSelect(p,c,n,valueId){
			var pv="",cv="",s_xzqh;
			s_xzqh=document.getElementById(valueId).value;
			var url= "${ctx}/pages/SelectXzqh/list.do?ajax=true";

			if(s_xzqh==""){
				getProvince('province','city','counties');
				return;
			}
			 pv=s_xzqh.substring(0,2)+"0000";
			 cv=s_xzqh.substring(0,4)+"00";
			if(s_xzqh.substring(2,6)!='0000'){
				j$.post(url+"&outId=province&oldId="+pv, function(data) {
					j$("#province").html(data);
				});
			}
			if(s_xzqh.substring(4,6)!='00'){

				j$.post(url+"&outId=city&inputid="+pv+"&oldId="+cv, function(data) {
					j$("#city").html(data);
				});
			}
			j$.post(url+"&outId=counties&inputid="+cv+"&oldId="+s_xzqh, function(data) {
				j$("#counties").html(data);
			});
			
	}
	


function setMr(inputid,outid){
		var s_xzqh=document.getElementById("xzqh").value;
		var p=s_xzqh.substring(0,2)+"0000";
		var c=s_xzqh.substring(0,4)+"00";
		var n=s_xzqh;
		var oldId="";
		var url="${ctx}/pages/SelectXzqh/list.do?ajax=true&outId=";
		if(s_xzqh!=""){
			 if(s_xzqh.substring(2,6)!='0000'){
			 	alert(url+"province&inputid="+p);
				j$.post(url+"&inputid"+p, function(data) {
					j$("#province").html(data);
				});
			 }
			 if(s_xzqh.substring(4,6)!='00'){
			 alert(url+"city&inputid="+c);
				j$.post(url+"counties&inputid"+c, function(data) {
					j$("#city").html(data);
				});
			 }
			  if(s_xzqh.substring(4,6)!='00'){
			   alert(url+"counties&inputid="+n);
				j$.post(url+"counties&inputid"+n, function(data) {
					j$("#counties").html(data);
				});
			 }
		}else{
			selectXzqh(inputid,outid);
		}
}
function setValue(obj){

	
		xzqh.value=returnValue(obj.options[obj.selectedIndex].value);
	
	
	if(obj.options[obj.selectedIndex].value!=""){
		xzqh.value=returnValue(obj.options[obj.selectedIndex].value);
	}else{
		if(obj.id=="city"){
			xzqh.value=returnValue(document.getElementById("province").value);
		}
		if(obj.id=="counties"){
			xzqh.value=returnValue(document.getElementById("city").value);
		}

	}
}
function returnValue(xzqh){

	if(xzqh.substr(4,6)=="00"){
		xzqh=xzqh.substr(0,4);
		if(xzqh.substr(2,4)=="00"){
			xzqh=xzqh.substr(0,2);
		}
	} 

	return xzqh;
}

</script>
</html>

