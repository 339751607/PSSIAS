<%@page import="com.dyneinfo.zazh.model.*" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/commons/taglibs.jsp" %>
<%
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+request.getContextPath()+"/";
%>
<html>

<head>
	<%@ include file="/commons/meta.jsp" %>
	<base href="<%=basePath%>">
	<title><%=Tcompany.TABLE_ALIAS%>查询</title>
	<link href="${ctx}/widgets/extremecomponents/extremecomponents.css" type="text/css" rel=stylesheet>
	
	
<script type='text/javascript' src='${ctx}/dwr/interface/menu.js'></script>
	<script type='text/javascript' src='${ctx}/dwr/engine.js'></script> 	
<script type='text/javascript' src='${ctx}/dwr/util.js'></script> 	<%--
--%>

</head>

<body>
<%@ include file="/commons/messages.jsp" %>
<div class="queryPanel">
    <s:form action="/pages/zazh/Tcompany/list.do"  theme="simple" style="display: inline;" method="post">
	    <table width="100%" border="1" bordercolor="#7c8ca7" align="center"  cellPadding="0" cellSpacing="0" class="tb_all">
	               <tr>
			              <td class="tb_title" colspan="4"><%=Tcompany.TABLE_ALIAS%>查询</td>
		           </tr>
		           <tr class="crosscolor_tr">
                           <td class="crosscolor_td">
			                  <%=Tcompany.ALIAS_BUSINESSCODE%>
		                  </td>
			              <td>
		                      <mytag:select  name="s_businesscode"  value="${pageRequest.filters.businesscode}"  notEmpty="false"  dictName="DIC_ITEM_VALID_BUSINESSCODE"/>
		                  </td>

                          <td class="crosscolor_td">
			                      <%=Tcompany.ALIAS_CPNAME%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.cpname}"  name="s_cpname"  />
		                  </td>
                   </tr>
                   <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=Tcompany.ALIAS_STATUS%>
		                  </td>
		                  <td>
		                      <mytag:select  name="s_status"  value="${pageRequest.filters.status}"  notEmpty="false"  dictName="T_DICT_QYZT"/>
		                  </td>
                          <td class="crosscolor_td">
			                      <%=Tcompany.ALIAS_MODDATE%>
		                  </td>
			              <td>	
			                 <table class="list">
			                 	<tr>
			                 	  <td>
			                 	    <input id="d31312" name="s_moddate_start"  value="${pageRequest.filters.moddate_start}"   maxlength="0" size="15" class="Wdate" type="text" onFocus="WdatePicker({dateFmt:'yyyy-MM-dd',maxDate:'#F{$dp.$D(\'d31412\')}'})"/>	
			                 	  </td>
			                 	  <td> 到</td>
			                 	  <td>
			                 	    <input id="d31412" name="s_moddate_end"   value="${pageRequest.filters.moddate_end}"  maxlength="0" size="15" class="Wdate" type="text" onFocus="WdatePicker({dateFmt:'yyyy-MM-dd',minDate:'#F{$dp.$D(\'d31312\')}'})"/>		
			                 	  </td>
			                 	</tr>	    	
			                 </table>      
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=Tcompany.ALIAS_BURCODE%>
		                  </td>
			              <td>
	         			       <mytag:select  name="s_burcode" onchange="changeprov2();" 
	         			             value="${pageRequest.filters.burcode}" dictName="ssfj"/>
		                         
		                  </td>
                          <td class="crosscolor_td">
			                      <%=Tcompany.ALIAS_STACODE%>
		                  </td>
			              <td>
		                           <select  name="s_stacode"  value="${pageRequest.filters.stacode}"  >
		                             <option value="">请选择...</option>
			              			</select>
		                  </td>
                   </tr>

		           <tr>
			              <td class="tb_bottom" colspan="4">
			                       <input type="submit"  value="查询" onclick="getReferenceForm(this).action='${ctx}/pages/zazh/Tcompany/list.do'"/>
	                               <input type="button"  value="测试"  id="b1"/>
			              </td>
		           </tr>
	    </table>
    </s:form>
</div>
			
</body>

</html>
<script>
   function changeprov2()
	{
	  queryCity2();
	}
	
	function queryCity2()
	{
		var provinceId = spider("s_burcode").value;
		alert(provinceId);
		menu.queryProvinceById(provinceId,cityCallback2);
	}
	
	function cityCallback2(citys)
	{
      //每次获得新的数据的时候先把每三个下拉框架的长度清0
	   DWRUtil.removeAllOptions("s_stacode");
        try{
            DWRUtil.addOptions("s_stacode",citys,"id","provinceName");//将option对象添加到第三个下拉框中    
            document.getElementById("s_stacode").options.add(new Option("请选择...",""),0);
            if(jsSelectIsExitItem(document.getElementById("s_stacode"),"${pageRequest.filters.stacode}")){
            		document.getElementById("s_stacode").value="${pageRequest.filters.stacode}"; 
            	}else{
		            document.getElementById("s_stacode").options[0].selected=true;
		            
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
	
	$(function(){
		alert(44);
		
		
	});
</script>