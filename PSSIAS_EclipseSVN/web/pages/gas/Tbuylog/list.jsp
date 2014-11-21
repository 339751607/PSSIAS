<%@page import="com.dyneinfo.gas.model.*" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/commons/taglibs.jsp" %>
<%
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+request.getContextPath()+"/";
%>
<html>

<head>
	<%@ include file="/commons/meta.jsp" %>
	<base href="<%=basePath%>">
	<link href="${ctx}/widgets/extremecomponents/extremecomponents.css" type="text/css" rel=stylesheet>
	<script type='text/javascript' src='${ctx}/dwr/interface/menu.js'></script>
	<script type='text/javascript' src='${ctx}/dwr/engine.js'></script>
	<script type='text/javascript' src='${ctx}/dwr/util.js'></script>
	<title><%=Tbuylog.TABLE_ALIAS%> 维护</title>
</head>
<body onload="getPcs();quickSelectInit()" >
<%@ include file="/commons/messages.jsp" %>
<input id="pcscode" type="hidden" value="${pcscode}" /> 
<input id="pcsname" type="hidden" value="${pcsname}" />
<div class="queryPanel">
    <s:form action="/pages/gas/Tbuylog/list.do"  theme="simple" style="display: inline;" method="post">
	    <table width="100%" border="1" bordercolor="#7c8ca7" align="center" 	cellPadding="0" cellSpacing="0" class="tb_all">
	               <tr>
			              <td class="tb_title" colspan="4"><%=Tbuylog.TABLE_ALIAS%>查询</td>
		           </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=Tbuylog.ALIAS_NAME%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.name}"  name="s_name"  />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=Tbuylog.ALIAS_ID_CODE%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.idCode}"  name="s_idCode"  />
		                  </td>
                   </tr>
		           <tr class="tr_tb">
                          <td class="td_tb">
			                      <%=Tbuylog.ALIAS_BUYTYPE%>
		                  </td>
			              <td>
		                            <mytag:select  value="${pageRequest.filters.buytype}" styleClass="select"  name="s_buytype" notEmpty="false"  dictName="DIC_ITEM_BUY_TYPE"  /> 
		                  </td>
<!--                          <td class="crosscolor_td">-->
<!--			                      <%=Tbuylog.ALIAS_QUANTITY%>-->
<!--		                  </td>-->
<!--			              <td>-->
<!--		                           <input value="${pageRequest.filters.quantity}"  name="s_quantity"  class="validate-number " required="false" />升-->
<!--	                      </td>-->
	                          <td class="td_tb">
				                     购油日期
			                  </td>
				              <td colspan="3" class="td_input">
			                            <s:select name="dateSelect13" list="dateSelectMap"  onchange="dateselect(this,'s_logtimeBegin','s_logtimeEnd','yyyy-MM-dd');"  value="#request.dateSelect13" listKey="key"   listValue="value" theme="simple" label=""  emptyOption="false" ></s:select>
				                          从<input id="d31313" name="s_logtimeBegin"  value="${pageRequest.filters.logtimeBegin}"   maxlength="0" size="12" class="Wdate" type="text" onFocus="WdatePicker({dateFmt:'yyyy-MM-dd',maxDate:'#F{$dp.$D(\'d31413\')}'})"/> &nbsp;到&nbsp;
				                        <input id="d31413" name="s_logtimeEnd"   value="${pageRequest.filters.logtimeEnd}"  maxlength="0" size="12" class="Wdate" type="text" onFocus="WdatePicker({dateFmt:'yyyy-MM-dd',minDate:'#F{$dp.$D(\'d31313\')}'})"/>
			                   
			                  </td>
		                
                   </tr>
                    <tr class="crosscolor_tr">
                    	   <td class="crosscolor_td">
			                      <%=Tbuylog.ALIAS_BURCODE%>
		                  </td>
			              <td>
				                <s:select name="s_burcode" id="country"  value=""   cssStyle="width:155px" onchange="getPcs();" list="provMap" listKey="key" headerKey=""  listValue="value" theme="simple" label="省市"  emptyOption="false" ></s:select>
		                  </td>
                          <td class="crosscolor_td">
			                      <%=Tbuylog.ALIAS_STACODE%>
		                  </td>
			              <td id="pcstd">
								<select id="province" style="width:155px" name="s_stacode"  ></select>
		                  </td>
                   </tr>
                    <tr class="crosscolor_tr">
                    	   <td class="crosscolor_td">
			                      <%=Tbuylog.ALIAS_CPCODE%>
		                  </td>
			              <td colspan ="3">
			              		 <s:select name="s_cpcode" id="cpcode" value=""  list="compMap" cssStyle="width:155px" listKey="key" headerKey=""  listValue="value" theme="simple" label="售油企业"  emptyOption="false" ></s:select>
		                  </td>
                   </tr>
		           <tr>
			              <td class="tb_bottom" colspan="4">
			                       <input type="submit"  value="查询" onclick="getReferenceForm(this).action='${ctx}/pages/gas/Tbuylog/list.do'"/>
			              		   <input style="margin-left: 20px" type="button" value="重置" onclick="resitData(document.forms[0])"/>
			              </td>
		           </tr>
	    </table>
    </s:form>
</div>



<ec:table items='page.result' var="item" method="get"
	retrieveRowsCallback="limit" sortRowsCallback="limit" filterRowsCallback="limit"
	action="${ctx}/pages/gas/Tbuylog/list.do" autoIncludeParameters="true">
	<ec:row>
      <ec:column property="name"  title="<%=Tbuylog.ALIAS_NAME%>">
		 <a href="${ctx}/pages/gas/Tbuylog/show.do?id=${item.id}" style="color: #0000FF; text-decoration: underline;">${item.name} </a>
	 </ec:column>
				
	  <mytag:lookupcolumn property="sex"  title="<%=Tbuylog.ALIAS_SEX%>"	cell="net.java.dev.ec.table.view.LookUpCell" dictType="gender" />
	  <ec:column property="bdate"  cell="date" title="<%=Tbuylog.ALIAS_BDATE%>"/>
		                    
	 <ec:column property="cpname"  title="<%=Tbuylog.ALIAS_CPCODE%>">
		 <a href="${ctx}/pages/gas/Tcompanyinfogas/cpshow.do?cpcode=${item.cpcode}" style="color: #0000FF; text-decoration: underline;">spider{item.cpname} </a>
	 </ec:column>
	 <ec:column property="idCode"  title="<%=Tbuylog.ALIAS_ID_CODE%>"/>
	 <ec:column property="logtime"  title="<%=Tbuylog.ALIAS_LOGTIME%>"/>
	 <mytag:lookupcolumn property="buytype"  title="<%=Tbuylog.ALIAS_BUYTYPE%>"	cell="net.java.dev.ec.table.view.LookUpCell" dictType="DIC_ITEM_BUY_TYPE" />
	 <mytag:lookupcolumn property="use"  title="<%=Tbuylog.ALIAS_USE%>"	cell="net.java.dev.ec.table.view.LookUpCell" dictType="DIC_ITEM_BUY_USE" />
	 <ec:column property="quantity"  title="<%=Tbuylog.ALIAS_QUANTITY%>"/>
	 
	</ec:row>
</ec:table>

</body>

</html>
<script>
	function getPcs()
	{
		var countryId = spider("country").value;
		//默认为不选择
		if(countryId == 0)
		{
			  DWRUtil.removeAllOptions("province");
			  DWRUtil.addOptions("province",{'':'请选择...'}); 
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
        var pcsname = spider("pcsname").value;
        if(pcscode == null || pcscode ==""){
	      //每次获得新的数据的时候先把每二个下拉框架的长度清0
	        try{
	           DWRUtil.addOptions("province",{'':'请选择...'});    
	           DWRUtil.addOptions("province",provinces,"id","provinceName");
	        }catch(e){
	        }
        }else{
			var obj = document.getElementById("province");    
       		obj.options.add(new Option(pcsname,pcscode)); 
        }
      }
	
	new Validation(document.forms[0],{onSubmit:true,onFormValidate : function(result,form) {
		var finalResult = result;
		//在这里添加自定义验证
		
		return disableSubmit(finalResult,'submitButton');
	}});
</script>
