<%@ page contentType="text/html;charset=UTF-8"%>
<script src="<c:url value="/scripts/jquery.js"/>" type="text/javascript"></script>
<script language="javascript">     
             var j$ = jQuery.noConflict();     
    </script>
<%@ page import="net.java.dev.common.dict.taglib.DictHelpImpl"%>
<%
String prcode = (String)DictHelpImpl.getInitData("prcode");
String mpcode = (String)DictHelpImpl.getInitData("mpcode");
 %>
<script language="javascript">
	
	var prcode="<%=prcode%>";
	var mpcode="<%=mpcode%>";
	//根据派出所分局
	function getFj(f,p,q){
		var url= "${ctx}/pages/SelectDept/getFj.do?ajax=true";
		
		getDate(f,url);
	}
	//根据查派出所
	function getPcs(inputId,outinputid){
		
		var url= "${ctx}/pages/SelectDept/getPcs.do?ajax=true&inputid="+document.getElementById(inputId).value;
		getDate(outinputid,url);
	}
	//根据派出所查企业
	function getDeptByParentid(inputId,outinputid){
		if(document.getElementById(inputId).value=="")getDeptByParentid('fjid','dept');
		var url= "${ctx}/pages/SelectDept/getDeptByParentid.do?ajax=true&inputid="+document.getElementById(inputId).value;
		getDate(outinputid,url);
	}
	//查父节点
	function getParentid(i,o){
		var url= "${ctx}/pages/SelectDept/getParentid.do?ajax=true&inputid="+document.getElementById(i).value;
		j$.post(url, function(data) {
			var ops=document.getElementById(o);
			for(var i=0;i<ops.options.length;i++){
				if(ops.options[i].value==data){
					ops.options[i].selected=true;
				}
			}
			
		});
	}

	function submitThisValue(f,p,d,v){
		var v=document.getElementById(v);
		var value=".1000."+mpcode;
		if(f!=""&&document.getElementById(f).value!=""){
			value+="."+document.getElementById(f).value;
		}
		if(p!=""&&document.getElementById(p).value!=""){
			value+="."+document.getElementById(p).value;
		}
		if(d!=""&&document.getElementById(d).value!=""){
			value+="."+document.getElementById(d).value;
		}
		if(value!="")v.value=value+"."
	}
	
	function getDate(outinputid,url){
		j$.post(url, function(data) {
			j$("#"+outinputid).html(data);
		});
	}
	  function setValueSelect(f,p,q,valueId){
		var fv="",pv="",qv="",oldseq;
	
			oldseq=document.getElementById(valueId).value;
			
				oldseq=oldseq.replace(".1000."+mpcode+".","");
				
			if(oldseq==""){
				getFj(f,p,q);
				return;
			}
			
			var oldseqs=oldseq.split(".");
			if(oldseqs.length>1){
				fv=oldseqs[0];
				var urlf= "${ctx}/pages/SelectDept/getFj.do?ajax=true&inputid="+fv+"&oldId="+fv;
				j$.post(urlf, function(data) {
					j$("#"+f).html(data);
				});
			}
			if(oldseqs.length>=2){
				pv=oldseqs[1];
				var urlp= "${ctx}/pages/SelectDept/getPcs.do?ajax=true&inputid="+fv+"&oldId="+pv;
				j$.post(urlp, function(data) {
					j$("#"+p).html(data);
				});
			}
			if(oldseqs.length>3){
				qv=oldseqs[2];
				if(q!=""){
						var urlq= "${ctx}/pages/SelectDept/getDeptByParentid.do?ajax=true&inputid="+pv+"&oldId="+qv;
						j$.post(urlq, function(data) {
						j$("#"+q).html(data);
					});
				}
			}
		
		
		
		
	}
	function submitValue(f,p,d,v){
		var v=document.getElementById(v);
		var value=".1000."+mpcode;
		if(f!=""&&document.getElementById(f).value!=""){
			value+="."+document.getElementById(f).value;
		}
		if(p!=""&&document.getElementById(p).value!=""){
			value+="."+document.getElementById(p).value;
		}
		if(d!=""&&document.getElementById(d).value!=""){
			value+="."+document.getElementById(d).value;
		}
		//alert(value);
		if(value!="")v.value=value+"."
	}
	
	function submitValueId(f,p,d,v){
		var v=document.getElementById(v);
		v.value=mpcode;
		if(f!=""&&document.getElementById(f).value!=""){
			var f=document.getElementById(f).value;
			v.value=f;
		}
		if(p!=""&&document.getElementById(p).value!=""){
			var p=document.getElementById(p).value;
			v.value=p;
		}
		if(d!=""&&document.getElementById(d).value!=""){
			var d=document.getElementById(d).value;
			v.value=d;
		}
		
	}

</script>


