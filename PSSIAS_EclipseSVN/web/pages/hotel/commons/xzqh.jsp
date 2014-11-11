<%@ page contentType="text/html;charset=UTF-8"%>
<script type="text/javascript">


   function changeprov()
	{
	  queryCity();
	}
	
	//查询所属城市
	function queryCity()
	{
		var provinceId = $("s_province").value;
		provinceId = provinceId.substr(0,2);
		menu.queryXzqhById(provinceId,cityCallback);
	}
	
	//查询所属城市回调函数
	function cityCallback(citys)
	{
      //每次获得新的数据的时候先把每三个下拉框架的长度清0
	   DWRUtil.removeAllOptions("s_xzqh");
        try{
            DWRUtil.addOptions("s_xzqh",citys,"id","cityName");//将option对象添加到第三个下拉框中 
            document.getElementById("s_xzqh").options.add(new Option("请选择...",""),0);
            if(jsSelectIsExitItem(document.getElementById("s_xzqh"),"${pageRequest.filters.xzqh}")){
        		document.getElementById("s_xzqh").value="${pageRequest.filters.xzqh}"; 
        	}else{
	            document.getElementById("s_xzqh").options[0].selected=true;
        	}  
        }catch(e){
        }
     
	}
 
	function jsSelectIsExitItem(objSelect, objItemValue) {        
	    var isExit = false;        
	    for (var i = 0; i < objSelect.options.length; i++) {        
	        if (objSelect.options[i].value == objItemValue) {        
	            isExit = true;        
	            break;        
	        }        
	    }        
	    return isExit;        
	}
</script>