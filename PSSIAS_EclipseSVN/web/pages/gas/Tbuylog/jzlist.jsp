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
    <s:form action="/pages/gas/Tbuylog/jzlist.do"  theme="simple" style="display: inline;" method="post">
	    <table width="100%" border="1" bordercolor="#7c8ca7" align="center"  cellPadding="0" cellSpacing="0" class="tb_all">
	               <tr>
			              <td class="tb_title" colspan="4">集中购油信息查询</td>
		           </tr>
		           <tr class="crosscolor_tr">
		                  <td class="crosscolor_td">
			                      <%=Tcompanyinfo.ALIAS_BURCODE%>
		                  </td>
			              <td>
			              	<s:select name="s_burcode" id="country"  cssStyle="width:155px"  value=""  onchange="getPcs();" list="provMap" listKey="key" headerKey=""  listValue="value" theme="simple" label="省市"  emptyOption="false" ></s:select>
		                  </td>
		                   <td class="crosscolor_td">
			                      <%=Tcompanyinfo.ALIAS_STACODE%>
		                  </td>
			              <td>
								<select id="province" name="s_stacode"  style="width:155px" ></select>
		                  </td>
		              </tr>
		            <tr class="tr_tb">
                          <td class="td_tb">
			                     购油日期
		                  </td>
			              <td colspan="3" class="td_input">
		                            <s:select name="dateSelect13" list="dateSelectMap"  onchange="dateselect(this,'s_logtimeBegin','s_logtimeEnd','yyyy-MM-dd');"  value="#request.dateSelect13" listKey="key"   listValue="value" theme="simple" label=""  emptyOption="false" ></s:select>
			                          从<input id="d31313" name="s_logtimeBegin"  value="${pageRequest.filters.logtimeBegin}"   maxlength="0" size="12" class="Wdate" type="text" onFocus="WdatePicker({dateFmt:'yyyy-MM-dd',maxDate:'#F{$dp.$D(\'d31413\')}'})"/> &nbsp;到&nbsp;
			                        <input id="d31413" name="s_logtimeEnd"   value="${pageRequest.filters.logtimeEnd}"  maxlength="0" size="12" class="Wdate" type="text" onFocus="WdatePicker({dateFmt:'yyyy-MM-dd',minDate:'#F{$dp.$D(\'d31313\')}'})"/>
		                   
		                  </td>
                   </tr>
		           <tr>
			              <td class="tb_bottom" colspan="4">
			                       <input type="submit"  value="查询" onclick="getReferenceForm(this).action='${ctx}/pages/gas/Tbuylog/jzlist.do'"/>
			              </td>
		           </tr>
	    </table>
    </s:form>
</div>



<ec:table items='page.result' var="item" method="get"
	retrieveRowsCallback="limit" sortRowsCallback="limit" filterRowsCallback="limit"
	action="${ctx}/pages/gas/Tbuylog/jzlist.do" autoIncludeParameters="true">
	<ec:row>
             <mytag:lookupcolumn property="stacode"  title="<%=Tcompanyinfo.ALIAS_STACODE%>"	cell="net.java.dev.ec.table.view.LookUpCell" dictType="teHangDwbm" />
             <ec:column property="gycs"  title="<%=Tbuylog.ALIAS_GYCS%>"/>
             <ec:column property="操作" title="操作" sortable="false" viewsAllowed="html">
				<a href="${ctx}/pages/gas/Tbuylog/jzgylist.do?cpcode=${item.stacode}&<mytag:params includes="ec*,s*" type="queryStringUtf"/>">查看</a>&nbsp;&nbsp;&nbsp;
			</ec:column>
	</ec:row>
</ec:table>

</body>

</html>
<script>

	function getPcs()
	{
		var countryId = $("country").value;
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
        var pcsname = $("pcsname").value;
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
 function changeprov()
	{
		var provinceId = $("prov").value;
		var provincename = $("prov").options[$("prov").options.selectedIndex].text;
		var nativeplace = $("s_nativeplace").value;
		var xzqh = $("s_xzqh").value;
		if(nativeplace==""){
			$("s_nativeplace").value = provincename;
			$("s_xzqh").value = provinceId;
		}else{
			$("s_nativeplace").value = nativeplace+","+provincename;
			$("s_xzqh").value = xzqh+","+provinceId;
		}
	}
	
</script>