<%@ page contentType="text/html;charset=UTF-8"%>
	<script type='text/javascript' src='${ctx}/dwr/interface/menu.js'></script>
	<script type='text/javascript' src='${ctx}/dwr/engine.js'></script>
	<script type='text/javascript' src='${ctx}/dwr/util.js'></script>	
<script type="text/javascript">

   function changeprov2()
	{
	  queryCity2();
	}
	
	//查询所属城市
	function queryCity2()
	{
		var provinceId = spider("s_burCode").value;
		menu.queryProvinceById(provinceId,cityCallback2);
	}
	
	//查询所属城市回调函数
	function cityCallback2(citys)
	{
      //每次获得新的数据的时候先把每三个下拉框架的长度清0
	   DWRUtil.removeAllOptions("s_staCode");
        try{
            DWRUtil.addOptions("s_staCode",citys,"id","provinceName");//将option对象添加到第三个下拉框中    
            document.getElementById("s_staCode").options.add(new Option("请选择...",""),0);
            if(jsSelectIsExitItem(document.getElementById("s_staCode"),"${pageRequest.filters.staCode}")){
            		document.getElementById("s_staCode").value="${pageRequest.filters.staCode}"; 
            	}else{
		            document.getElementById("s_staCode").options[0].selected=true;
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