<%@page import="java.text.*,java.util.*"%>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/commons/taglibs.jsp" %>
<%
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+request.getContextPath()+"/";

%>
<html>
<head>
	<%@ include file="/commons/meta.jsp" %>
	<base href="<%=basePath%>">
	<script type='text/javascript' src='${ctx}/dwr/interface/menu.js'></script>
	<script type='text/javascript' src='${ctx}/dwr/engine.js'></script>
	<script type='text/javascript' src='${ctx}/dwr/util.js'></script>
	<title><%=Ttz.TABLE_ALIAS%>新增</title>
</head>

<script type="text/javascript">
	function queryProvince()
	{
		var countryId = $("country").value;
		//默认为不选择
		if(countryId == 0)
		{
			  DWRUtil.removeAllOptions("province");
			  DWRUtil.removeAllOptions("city");
			  DWRUtil.addOptions("province",{'':'全部'}); 
		}
		else
		{
			menu.queryProvinceById(countryId,provinceCallback);
		}	
	}
	
	//根据国家id查询所属省或州的回调函数
	function provinceCallback(provinces)
	{
        DWRUtil.removeAllOptions("province");
        var pcscode = $("pcscode").value;
        var pcsname = $("pcsname").value;
        if(pcscode == null || pcscode ==""){
	      //每次获得新的数据的时候先把每二个下拉框架的长度清0
	        try{
	           DWRUtil.addOptions("province",{'':'全部'});    
	           DWRUtil.addOptions("province",provinces,"id","provinceName");
	        }catch(e){
	        }
        }else{
			var obj = document.getElementById("province");    
       		obj.options.add(new Option(pcsname,pcscode)); 
        }
     
      //同时关联第三级
    
	  var provinceId = $("province").value;
      menu.queryCityById(provinceId,cityCallback);
      }
	//查询所属城市
	function queryCity()
	{
		var provinceId = $("province").value;
		menu.queryCityById(provinceId,cityCallback);
	}
	//查询所属城市回调函数
	function cityCallback(citys)
	{
      //每次获得新的数据的时候先把每三个下拉框架的长度清0
      
	   DWRUtil.removeAllOptions("city");
        try{
            DWRUtil.addOptions("city",{'':'全部'});  
            DWRUtil.addOptions("city",citys,"id","cityName");//将option对象添加到第三个下拉框中
        }catch(e){
        }
     
	}
	
</script>

<body onload="queryProvince();quickSelectInit();">
<%@ include file="/commons/messages.jsp" %>
<input id="pcscode" type="hidden" value="${pcscode}" /> 
<input id="pcsname" type="hidden" value="${pcsname}" /> 
<s:form action="/pages/gas/Ttz/save.do" theme="simple" enctype="multipart/form-data"  method="post">
	<table width="100%" border="1" bordercolor="#7c8ca7" align="center" 	cellPadding="0" cellSpacing="0" class="tb_all">
	    <input type="hidden" name="returnUrl" value="!/pages/gas/Ttz/list.do?<mytag:params includes="ec*,s*" type="queryStringUtf"/>" />
	       <tr>
				<td colspan="4" class="tb_title"> 
							<%=Ttz.TABLE_ALIAS%>新增
			    </td>
		   </tr>
	<%@ include file="form_include.jsp" %>
	       <tr >
				<td colspan="4" class="tb_bottom">
							<input id="submitButton" name="submitButton" type="submit" value="下发" />
	                        <input type="button" value="返回" onclick="window.location='${ctx}/pages/gas/Ttz/list.do?<mytag:params includes="ec*,s*" type="queryStringUtf"/>'"/>
			    </td>
	        </tr>
	</table>
</s:form>

<script>
	
	new Validation(document.forms[0],{onSubmit:true,onFormValidate : function(result,form) {
		var finalResult = result;
		if(document.getElementsByName('filexx')[0].value=="1"){
			document.getElementsByName('affix')[0].style.borderColor = 'red';
			finalResult=false;
		}
		
		//在这里添加自定义验证
		
		return disableSubmit(finalResult,'submitButton');
	}});
</script>

</body>
</html>